#!/usr/bin/env python3
"""
Builds the JSON data files consumed by the local explorer site (explorer/index.html).

Reads:
  - extracted/<version>/AndroidManifest.xml + strings.xml   (all 30 versions)
  - decompiled/<version>_src/sources/**/*.java              (9.39 and 9.68 only, for flow graphs)

Writes into explorer/data/:
  - versions.json          summary + diff-vs-previous for every version (timeline view)
  - state/<version>.json   full activities/services/receivers/permissions/strings snapshot
  - feature_index.json     lifespan (first/last seen) of every activity across all versions
  - string_index.json      lifespan of every string id across all versions
  - flows/<version>.json   navigation graph (activities/fragments + edges) for 9.39 and 9.68
"""
import os
import re
import json
import xml.etree.ElementTree as ET

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
EXTRACTED_DIR = os.path.join(BASE_DIR, "extracted")
DECOMPILED_DIR = os.path.join(BASE_DIR, "decompiled")
MD_FILE = os.path.join(BASE_DIR, "BLOApp_download_list.md")
OUT_DIR = os.path.join(BASE_DIR, "explorer", "data")
STATE_DIR = os.path.join(OUT_DIR, "state")
FLOWS_DIR = os.path.join(OUT_DIR, "flows")

ANDROID_NS = "{http://schemas.android.com/apk/res/android}"
FLOW_VERSIONS = ["9.39", "9.68"]


def get_ordered_versions():
    with open(MD_FILE) as f:
        content = f.read()
    matches = re.findall(r"\|\s*([0-9.]+)\s*\|\s*([0-9-]+)\s*\|", content)
    seen = {}
    for ver, date in matches:
        seen[ver] = date
    # chronological order; tie-break equal dates by version number (file lists newest first)
    def sort_key(kv):
        ver, date = kv
        return (date, tuple(int(p) for p in ver.split(".")))
    ordered = sorted(seen.items(), key=sort_key)
    return ordered  # list of (version, date)


def parse_manifest(version):
    path = os.path.join(EXTRACTED_DIR, version, "AndroidManifest.xml")
    tree = ET.parse(path)
    root = tree.getroot()

    def attr(el, name):
        return el.attrib.get(f"{ANDROID_NS}{name}") if el is not None else None

    uses_sdk = root.find("uses-sdk")
    permissions = sorted({attr(p, "name") for p in root.findall("uses-permission") if attr(p, "name")})
    activities = sorted({attr(a, "name") for a in root.iter("activity") if attr(a, "name")})
    services = sorted({attr(s, "name") for s in root.iter("service") if attr(s, "name")})
    receivers = sorted({attr(r, "name") for r in root.iter("receiver") if attr(r, "name")})

    launcher_activities = []
    for a in root.iter("activity"):
        name = attr(a, "name")
        for intent_filter in a.findall("intent-filter"):
            actions = {attr(x, "name") for x in intent_filter.findall("action")}
            if "android.intent.action.MAIN" in actions:
                launcher_activities.append(name)

    return {
        "versionCode": attr(root, "versionCode"),
        "versionName": attr(root, "versionName"),
        "minSdkVersion": attr(uses_sdk, "minSdkVersion") if uses_sdk is not None else None,
        "targetSdkVersion": attr(uses_sdk, "targetSdkVersion") if uses_sdk is not None else None,
        "permissions": permissions,
        "activities": activities,
        "services": services,
        "receivers": receivers,
        "launcherActivities": launcher_activities,
    }


def android_unescape(text):
    """Undo Android string-resource escaping (\\' \\" \\n etc.) so display text is clean."""
    if text is None:
        return text
    return (
        text.replace("\\'", "'")
        .replace('\\"', '"')
        .replace("\\n", "\n")
        .replace("\\t", "\t")
    )


def parse_strings(version):
    path = os.path.join(EXTRACTED_DIR, version, "strings.xml")
    tree = ET.parse(path)
    root = tree.getroot()
    out = {}
    for el in root.findall("string"):
        name = el.attrib.get("name")
        if not name:
            continue
        text = "".join(el.itertext())
        out[name] = android_unescape(text)
    return out


MODULE_PREFIX = "in.gov.eci.bloapp."


def derive_module(class_name):
    """Group a fully-qualified class name into a browsable feature module."""
    if class_name.startswith(MODULE_PREFIX):
        rest = class_name[len(MODULE_PREFIX):]
    else:
        rest = class_name
    parts = rest.split(".")
    parts = parts[:-1]  # drop the class itself
    if not parts:
        return "core"
    if parts[0] in ("views", "view"):
        parts = parts[1:]
    if not parts:
        return "core"
    if parts[0] in ("activity", "activities", "fragments", "fragment"):
        parts = parts[1:]
    if not parts:
        return "core"
    return parts[0]


def humanize(class_name):
    short = class_name.rsplit(".", 1)[-1]
    # split CamelCase into words
    words = re.findall(r"[A-Z]+(?=[A-Z][a-z])|[A-Z]?[a-z]+|[A-Z]+|\d+", short)
    return " ".join(words) if words else short


def build_versions_and_state(ordered_versions):
    os.makedirs(STATE_DIR, exist_ok=True)
    states = {}
    for ver, date in ordered_versions:
        manifest = parse_manifest(ver)
        strings = parse_strings(ver)
        state = {
            "version": ver,
            "date": date,
            **manifest,
            "strings": strings,
        }
        states[ver] = state
        with open(os.path.join(STATE_DIR, f"{ver}.json"), "w") as f:
            json.dump(state, f, indent=None, separators=(",", ":"))

    versions_summary = []
    prev = None
    for ver, date in ordered_versions:
        st = states[ver]
        act_set = set(st["activities"])
        str_set = st["strings"]
        svc_set = set(st["services"])
        rcv_set = set(st["receivers"])
        perm_set = set(st["permissions"])

        diff = {
            "addedActivities": [],
            "removedActivities": [],
            "addedServices": [],
            "removedServices": [],
            "addedReceivers": [],
            "removedReceivers": [],
            "addedPermissions": [],
            "removedPermissions": [],
            "addedStrings": {},
            "removedStrings": [],
            "modifiedStrings": {},
        }
        if prev is not None:
            p = states[prev]
            p_act, p_svc, p_rcv, p_perm = set(p["activities"]), set(p["services"]), set(p["receivers"]), set(p["permissions"])
            p_str = p["strings"]

            diff["addedActivities"] = sorted(act_set - p_act)
            diff["removedActivities"] = sorted(p_act - act_set)
            diff["addedServices"] = sorted(svc_set - p_svc)
            diff["removedServices"] = sorted(p_svc - svc_set)
            diff["addedReceivers"] = sorted(rcv_set - p_rcv)
            diff["removedReceivers"] = sorted(p_rcv - rcv_set)
            diff["addedPermissions"] = sorted(perm_set - p_perm)
            diff["removedPermissions"] = sorted(p_perm - perm_set)

            for k, v in str_set.items():
                if k not in p_str:
                    diff["addedStrings"][k] = v
                elif p_str[k] != v:
                    diff["modifiedStrings"][k] = {"old": p_str[k], "new": v}
            diff["removedStrings"] = sorted(set(p_str.keys()) - set(str_set.keys()))

        versions_summary.append({
            "version": ver,
            "date": date,
            "versionCode": st["versionCode"],
            "targetSdkVersion": st["targetSdkVersion"],
            "minSdkVersion": st["minSdkVersion"],
            "counts": {
                "activities": len(act_set),
                "strings": len(str_set),
                "services": len(svc_set),
                "receivers": len(rcv_set),
                "permissions": len(perm_set),
            },
            "diff": diff,
            "diffCounts": {
                "addedActivities": len(diff["addedActivities"]),
                "removedActivities": len(diff["removedActivities"]),
                "addedStrings": len(diff["addedStrings"]),
                "removedStrings": len(diff["removedStrings"]),
                "modifiedStrings": len(diff["modifiedStrings"]),
                "addedServices": len(diff["addedServices"]),
                "addedReceivers": len(diff["addedReceivers"]),
                "addedPermissions": len(diff["addedPermissions"]),
                "removedPermissions": len(diff["removedPermissions"]),
            },
        })
        prev = ver

    with open(os.path.join(OUT_DIR, "versions.json"), "w") as f:
        json.dump(versions_summary, f, indent=None, separators=(",", ":"))

    return states


def build_feature_index(states, ordered_versions):
    versions_in_order = [v for v, _ in ordered_versions]
    activity_lifespan = {}
    for ver in versions_in_order:
        for act in states[ver]["activities"]:
            entry = activity_lifespan.setdefault(act, {
                "className": act,
                "label": humanize(act),
                "module": derive_module(act),
                "versions": [],
                "isLauncher": False,
            })
            entry["versions"].append(ver)
            if act in states[ver]["launcherActivities"]:
                entry["isLauncher"] = True

    features = []
    for act, entry in activity_lifespan.items():
        vs = entry["versions"]
        entry["firstSeen"] = vs[0]
        entry["lastSeen"] = vs[-1]
        entry["stillPresent"] = vs[-1] == versions_in_order[-1]
        entry["versionCount"] = len(vs)
        features.append(entry)

    features.sort(key=lambda e: (e["module"], e["label"]))

    modules = sorted({f["module"] for f in features})

    with open(os.path.join(OUT_DIR, "feature_index.json"), "w") as f:
        json.dump({"features": features, "modules": modules, "versions": versions_in_order}, f, separators=(",", ":"))


def build_string_index(states, ordered_versions):
    versions_in_order = [v for v, _ in ordered_versions]
    lifespan = {}
    for ver in versions_in_order:
        for key, text in states[ver]["strings"].items():
            entry = lifespan.setdefault(key, {"key": key, "versions": [], "text": text})
            entry["versions"].append(ver)
            entry["text"] = text  # keep latest text
    out = []
    for key, entry in lifespan.items():
        vs = entry["versions"]
        out.append({
            "key": key,
            "text": entry["text"],
            "firstSeen": vs[0],
            "lastSeen": vs[-1],
            "stillPresent": vs[-1] == versions_in_order[-1],
            "versionCount": len(vs),
        })
    out.sort(key=lambda e: e["key"])
    with open(os.path.join(OUT_DIR, "string_index.json"), "w") as f:
        json.dump({"strings": out}, f, separators=(",", ":"))


# ---------------- Flow graph extraction (9.39 / 9.68 only) ----------------

INTENT_TARGET_RE = re.compile(r"\(Class<\?>\)\s*([A-Za-z_][A-Za-z0-9_]*)\.class")
SIMPLE_CLASS_INTENT_RE = re.compile(r"new\s+Intent\s*\([^;{}]*?,\s*([A-Za-z_][A-Za-z0-9_]*)\.class\s*\)")
FRAGMENT_NEW_RE = re.compile(r"\.(?:replace|add)\s*\([^,]+,\s*new\s+([A-Za-z_][A-Za-z0-9_]*)\s*\(")
PACKAGE_RE = re.compile(r"^package\s+([\w.]+);", re.MULTILINE)


def build_flow_for_version(version):
    src_root = os.path.join(DECOMPILED_DIR, f"{version}_src", "sources", "in", "gov", "eci", "bloapp")
    if not os.path.isdir(src_root):
        return None

    # index short-class-name -> fully qualified name, restricted to app's own package
    short_to_full = {}
    files_by_full = {}
    for dirpath, _, filenames in os.walk(src_root):
        for fn in filenames:
            if not fn.endswith(".java"):
                continue
            full_path = os.path.join(dirpath, fn)
            short = fn[:-5]
            with open(full_path, "r", errors="ignore") as f:
                content = f.read()
            pkg_match = PACKAGE_RE.search(content)
            pkg = pkg_match.group(1) if pkg_match else None
            full_name = f"{pkg}.{short}" if pkg else short
            # skip inner/anonymous helper duplicates: prefer first occurrence
            short_to_full.setdefault(short, full_name)
            files_by_full[full_name] = content

    nodes = {}
    edges = []
    edge_seen = set()

    def ensure_node(full_name, kind_hint=None):
        if full_name not in nodes:
            nodes[full_name] = {
                "id": full_name,
                "label": humanize(full_name),
                "module": derive_module(full_name),
                "kind": kind_hint or ("fragment" if "Fragment" in full_name else "activity"),
            }
        elif kind_hint:
            nodes[full_name]["kind"] = kind_hint

    for full_name, content in files_by_full.items():
        is_activity_file = "extends Activity" in content or "extends AppCompatActivity" in content or "extends FragmentActivity" in content or "extends BaseActivity" in content
        is_fragment_file = "extends Fragment" in content or "extends DialogFragment" in content or "extends BottomSheetDialogFragment" in content
        source_kind = "activity" if is_activity_file else ("fragment" if is_fragment_file else None)

        targets = set(INTENT_TARGET_RE.findall(content)) | set(SIMPLE_CLASS_INTENT_RE.findall(content))
        frag_targets = set(FRAGMENT_NEW_RE.findall(content))

        if not targets and not frag_targets:
            continue

        if source_kind:
            ensure_node(full_name, source_kind)
        else:
            continue  # only emit edges from recognizable activities/fragments to keep the graph legible

        for t in targets:
            if t == full_name.rsplit(".", 1)[-1]:
                continue
            target_full = short_to_full.get(t)
            if not target_full:
                continue  # external / framework class, skip
            ensure_node(target_full, "activity")
            key = (full_name, target_full, "startActivity")
            if key not in edge_seen:
                edge_seen.add(key)
                edges.append({"source": full_name, "target": target_full, "kind": "startActivity"})

        for t in frag_targets:
            target_full = short_to_full.get(t)
            if not target_full or target_full == full_name:
                continue
            ensure_node(target_full, "fragment")
            key = (full_name, target_full, "showFragment")
            if key not in edge_seen:
                edge_seen.add(key)
                edges.append({"source": full_name, "target": target_full, "kind": "showFragment"})

    return {
        "version": version,
        "nodes": list(nodes.values()),
        "edges": edges,
    }


def build_flows():
    os.makedirs(FLOWS_DIR, exist_ok=True)
    for ver in FLOW_VERSIONS:
        flow = build_flow_for_version(ver)
        if flow is None:
            print(f"[flows] no decompiled source for {ver}, skipping")
            continue
        with open(os.path.join(FLOWS_DIR, f"{ver}.json"), "w") as f:
            json.dump(flow, f, separators=(",", ":"))
        print(f"[flows] {ver}: {len(flow['nodes'])} nodes, {len(flow['edges'])} edges")


def main():
    os.makedirs(OUT_DIR, exist_ok=True)
    ordered_versions = get_ordered_versions()
    print(f"Processing {len(ordered_versions)} versions...")
    states = build_versions_and_state(ordered_versions)
    build_feature_index(states, ordered_versions)
    build_string_index(states, ordered_versions)
    build_flows()
    print("Done. Data written to", OUT_DIR)


if __name__ == "__main__":
    main()
