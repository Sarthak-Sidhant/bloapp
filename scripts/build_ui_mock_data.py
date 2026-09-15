#!/usr/bin/env python3
"""
Reconstructs a clickable UI prototype from the decompiled v9.68 sources/resources.

For every Activity/Fragment class we can resolve to a layout XML, this parses the
layout into a simplified widget tree (inputs, labels, buttons, choices) with all
@string references resolved to real text, and writes one JSON file per screen into
explorer/data/screens/. explorer/app.js turns these into an actual clickable,
fillable mock of the app (no login, no backend) navigable via the flow graph
already built by build_explorer_data.py.
"""
import os
import re
import json
import xml.etree.ElementTree as ET

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
VERSION = "9.68"
SRC_ROOT = os.path.join(BASE_DIR, "decompiled", f"{VERSION}_src", "sources", "in", "gov", "eci", "bloapp")
RES_ROOT = os.path.join(BASE_DIR, "decompiled", f"{VERSION}_res", "resources", "in.gov.eci.bloapp.apk", "res")
LAYOUT_DIR = os.path.join(RES_ROOT, "layout")
STATE_FILE = os.path.join(BASE_DIR, "explorer", "data", "state", f"{VERSION}.json")
OUT_DIR = os.path.join(BASE_DIR, "explorer", "data", "screens")

ANDROID = "{http://schemas.android.com/apk/res/android}"
APP = "{http://schemas.android.com/apk/res-auto}"

CONTAINER_TAGS = {
    "LinearLayout", "RelativeLayout", "FrameLayout", "ScrollView", "HorizontalScrollView",
    "androidx.core.widget.NestedScrollView", "androidx.constraintlayout.widget.ConstraintLayout",
    "androidx.cardview.widget.CardView", "androidx.coordinatorlayout.widget.CoordinatorLayout",
    "androidx.swiperefreshlayout.widget.SwipeRefreshLayout", "com.google.android.material.card.MaterialCardView",
    "TableLayout", "TableRow", "GridLayout", "merge", "com.google.android.material.appbar.AppBarLayout",
    "com.google.android.material.textfield.TextInputLayout",
}
TEXT_TAGS = {"TextView", "com.google.android.material.textview.MaterialTextView"}
INPUT_TAGS = {
    "EditText", "AutoCompleteTextView", "MultiAutoCompleteTextView",
    "com.google.android.material.textfield.TextInputEditText",
}
SPINNER_TAGS = {"Spinner", "androidx.appcompat.widget.AppCompatSpinner"}
BUTTON_TAGS = {
    "Button", "androidx.appcompat.widget.AppCompatButton", "com.google.android.material.button.MaterialButton",
    "ImageButton", "androidx.appcompat.widget.AppCompatImageButton",
}
CHECKBOX_TAGS = {"CheckBox", "androidx.appcompat.widget.AppCompatCheckBox", "com.google.android.material.checkbox.MaterialCheckBox"}
RADIO_TAGS = {"RadioButton", "androidx.appcompat.widget.AppCompatRadioButton"}
SWITCH_TAGS = {"Switch", "SwitchCompat", "androidx.appcompat.widget.SwitchCompat"}
LIST_TAGS = {
    "androidx.recyclerview.widget.RecyclerView", "ListView", "GridView", "ExpandableListView",
}
SKIP_TAGS = {"ImageView", "androidx.appcompat.widget.AppCompatImageView", "View", "Space", "ProgressBar",
             "com.google.android.material.progressindicator.CircularProgressIndicator", "WebView"}
TOOLBAR_TAGS = {"androidx.appcompat.widget.Toolbar", "com.google.android.material.appbar.MaterialToolbar", "Toolbar"}


def load_strings():
    with open(STATE_FILE) as f:
        return json.load(f)["strings"]


STRINGS = {}


def android_unescape(text):
    if text is None:
        return text
    return text.replace("\\'", "'").replace('\\"', '"').replace("\\n", "\n").replace("\\t", "\t")


def resolve_text(raw):
    if raw is None:
        return None
    raw = raw.strip()
    if not raw:
        return None
    if raw.startswith("@string/"):
        return STRINGS.get(raw[len("@string/"):], None)
    if raw.startswith("@android:string/") or raw.startswith("@") or raw.startswith("?"):
        return None
    return android_unescape(raw)


def layout_binding_prefix(filename):
    parts = filename.split("_")
    return "".join(p[:1].upper() + p[1:] for p in parts if p)


def build_layout_registry():
    registry = {}
    for fn in os.listdir(LAYOUT_DIR):
        if not fn.endswith(".xml"):
            continue
        name = fn[:-4]
        binding_class = layout_binding_prefix(name) + "Binding"
        registry[binding_class] = name
    return registry


BINDING_INFLATE_RE = re.compile(r"([A-Za-z0-9]+Binding)\.inflate\(")
BINDING_NEW_RE = re.compile(r"new\s+([A-Za-z0-9]+Binding)\(")
CONTENTVIEW_LAYOUT_RE = re.compile(r"setContentView\(\s*R\.layout\.([a-zA-Z0-9_]+)")
INFLATE_LAYOUT_RE = re.compile(r"\.inflate\(\s*R\.layout\.([a-zA-Z0-9_]+)")
PACKAGE_RE = re.compile(r"^package\s+([\w.]+);", re.MULTILINE)
CLASS_DECL_RE = re.compile(r"\bclass\s+\w+\s+extends\s+([\w.<>]+)")


def find_layout_for_source(content, registry):
    for m in BINDING_INFLATE_RE.finditer(content):
        cls = m.group(1)
        if cls in registry:
            return registry[cls]
    for m in BINDING_NEW_RE.finditer(content):
        cls = m.group(1)
        if cls in registry:
            return registry[cls]
    m = CONTENTVIEW_LAYOUT_RE.search(content)
    if m:
        return m.group(1)
    m = INFLATE_LAYOUT_RE.search(content)
    if m:
        return m.group(1)
    return None


def humanize(short_name):
    words = re.findall(r"[A-Z]+(?=[A-Z][a-z])|[A-Z]?[a-z]+|[A-Z]+|\d+", short_name)
    return " ".join(words) if words else short_name


def collect_source_map():
    """short class name -> (full_name, file content, kind guess)"""
    out = {}
    for dirpath, _, filenames in os.walk(SRC_ROOT):
        for fn in filenames:
            if not fn.endswith(".java"):
                continue
            short = fn[:-5]
            path = os.path.join(dirpath, fn)
            with open(path, "r", errors="ignore") as f:
                content = f.read()
            pkg_m = PACKAGE_RE.search(content)
            full = f"{pkg_m.group(1)}.{short}" if pkg_m else short
            out.setdefault(short, (full, content))
    return out


def resolve_include(path, depth=0):
    if depth > 4 or not os.path.exists(path):
        return None
    try:
        return ET.parse(path).getroot()
    except ET.ParseError:
        return None


def walk_layout(el, widgets, depth=0):
    if depth > 40:
        return
    tag = el.tag
    tag = tag.split("}")[-1] if tag.startswith("{") else tag

    if tag == "include":
        layout_ref = el.attrib.get(ANDROID + "layout") or el.attrib.get("layout")
        if layout_ref and layout_ref.startswith("@layout/"):
            inc_path = os.path.join(LAYOUT_DIR, layout_ref[len("@layout/"):] + ".xml")
            root = resolve_include(inc_path, depth + 1)
            if root is not None:
                walk_layout(root, widgets, depth + 1)
        return

    android_id = el.attrib.get(ANDROID + "id", "")
    id_name = android_id.replace("@+id/", "").replace("@id/", "")
    text = resolve_text(el.attrib.get(ANDROID + "text"))
    hint = resolve_text(el.attrib.get(ANDROID + "hint"))
    content_desc = resolve_text(el.attrib.get(ANDROID + "contentDescription"))
    visibility = el.attrib.get(ANDROID + "visibility")
    is_gone = visibility == "gone"

    if tag in TOOLBAR_TAGS:
        # capture any TextView title inside toolbar as the screen title candidate
        for child in el.iter():
            ctag = child.tag.split("}")[-1]
            if ctag in TEXT_TAGS:
                t = resolve_text(child.attrib.get(ANDROID + "text"))
                if t:
                    widgets.append({"kind": "title", "label": t})
        return

    if tag in TEXT_TAGS:
        if text and not is_gone and len(text) > 0:
            widgets.append({"kind": "text", "label": text, "id": id_name})
    elif tag in INPUT_TAGS:
        if not is_gone:
            widgets.append({"kind": "input", "label": hint or content_desc or humanize(id_name or "field"), "id": id_name})
    elif tag in SPINNER_TAGS:
        if not is_gone:
            widgets.append({"kind": "select", "label": hint or content_desc or humanize(id_name or "select"), "id": id_name})
    elif tag in CHECKBOX_TAGS:
        if not is_gone:
            widgets.append({"kind": "checkbox", "label": text or humanize(id_name or "option"), "id": id_name})
    elif tag in RADIO_TAGS:
        if not is_gone:
            widgets.append({"kind": "radio", "label": text or humanize(id_name or "option"), "id": id_name})
    elif tag in SWITCH_TAGS:
        if not is_gone:
            widgets.append({"kind": "switch", "label": text or humanize(id_name or "toggle"), "id": id_name})
    elif tag in BUTTON_TAGS:
        if not is_gone:
            label = text or content_desc or humanize(id_name or "action")
            widgets.append({"kind": "button", "label": label, "id": id_name})
    elif tag in LIST_TAGS:
        widgets.append({"kind": "list", "label": humanize(id_name or "items"), "id": id_name})
    elif tag == "RadioGroup":
        pass  # fall through to children, radio buttons collected individually
    elif tag in SKIP_TAGS or tag in CONTAINER_TAGS:
        pass  # container / decorative, recurse only
    else:
        # unknown custom view — still try to surface any text/hint it carries
        if text and not is_gone:
            widgets.append({"kind": "text", "label": text, "id": id_name})

    if not is_gone:
        for child in list(el):
            walk_layout(child, widgets, depth + 1)


def group_radio_buttons(widgets):
    out = []
    i = 0
    while i < len(widgets):
        w = widgets[i]
        if w["kind"] == "radio":
            group = [w]
            j = i + 1
            while j < len(widgets) and widgets[j]["kind"] == "radio":
                group.append(widgets[j])
                j += 1
            out.append({"kind": "radiogroup", "options": [g["label"] for g in group], "id": group[0]["id"]})
            i = j
        else:
            out.append(w)
            i += 1
    return out


def dedupe_collapse(widgets):
    """Drop empty/duplicate noise: consecutive identical text labels, empty labels."""
    out = []
    prev = None
    for w in widgets:
        label = w.get("label")
        if w["kind"] in ("text", "title") and (not label or not label.strip()):
            continue
        if prev and prev["kind"] == w["kind"] == "text" and prev.get("label") == label:
            continue
        out.append(w)
        prev = w
    return out


def parse_layout_file(layout_name):
    path = os.path.join(LAYOUT_DIR, layout_name + ".xml")
    if not os.path.exists(path):
        return None
    try:
        root = ET.parse(path).getroot()
    except ET.ParseError:
        return None
    widgets = []
    walk_layout(root, widgets)
    widgets = dedupe_collapse(widgets)
    widgets = group_radio_buttons(widgets)
    return widgets


def guess_title(class_short, widgets):
    return humanize(class_short)


# ---------------------------------------------------------------------------
# Network calls + result flow: instead of hand-annotating individual screens
# (e.g. "the face-capture screen calls the check-face endpoint"), we extract
# this generically for every screen by parsing the app's own Retrofit
# interfaces for (httpVerb, path) per Java method name, then scanning each
# screen's source for calls to those methods. Same idea for setResult(...):
# any screen that hands data back to its caller (like ManualFaceCaptureActivity
# returning "file_uri") gets that surfaced automatically.
# ---------------------------------------------------------------------------

RETROFIT_INTERFACE_FILES = [
    "api/RestClient.java",
    "api/service/UserClient.java",
    "network/ApiInterface.java",
]

VERB_RE = re.compile(r'^\s*@(GET|POST|PUT|DELETE|PATCH)\(\s*"([^"]*)"\s*\)')
METHOD_DECL_RE = re.compile(r'^\s*(?:public\s+)?Call<.*>\s+([A-Za-z_][A-Za-z0-9_]*)\s*\(')
SET_RESULT_RE = re.compile(r'setResult\(\s*-?\d+\s*,\s*(\w+)\s*\)')
PUT_EXTRA_RE = re.compile(r'(\w+)\.putExtra\(\s*"([^"]+)"')


def build_endpoint_map():
    """Java Retrofit method name -> {'verb': 'POST', 'path': '...'}."""
    endpoint_map = {}
    for rel in RETROFIT_INTERFACE_FILES:
        path = os.path.join(SRC_ROOT, rel)
        if not os.path.exists(path):
            continue
        with open(path, errors="ignore") as f:
            lines = f.readlines()
        pending = None
        for line in lines:
            m = VERB_RE.match(line)
            if m:
                pending = (m.group(1), m.group(2))
                continue
            if pending is None:
                continue
            m = METHOD_DECL_RE.match(line)
            if m:
                endpoint_map[m.group(1)] = {"verb": pending[0], "path": pending[1]}
                pending = None
            elif line.strip().startswith("@"):
                continue  # another annotation (e.g. @Multipart) before the Call<> line
            else:
                pending = None  # not the shape we expect; drop it
    return endpoint_map


RETROFIT_INTERFACE_SIMPLE_NAMES = ("RestClient", "UserClient", "ApiInterface")


def uses_a_retrofit_client(content):
    """Gate api-call detection on real evidence this file builds one of our
    known Retrofit interfaces — without it, generic getter names (getState(),
    getName(), ...) collide with unrelated method calls and produce false
    positives."""
    return any(f".create({name}.class)" in content for name in RETROFIT_INTERFACE_SIMPLE_NAMES)


def extract_api_calls(content, endpoint_map):
    if not uses_a_retrofit_client(content):
        return []
    found = {}
    for name, info in endpoint_map.items():
        if f".{name}(" in content:
            found[name] = info
    return [{"javaMethod": k, **v} for k, v in sorted(found.items())]


def extract_return_extras(content):
    var_extras = {}
    for var, key in PUT_EXTRA_RE.findall(content):
        var_extras.setdefault(var, []).append(key)
    extras = set()
    returns = False
    for var in SET_RESULT_RE.findall(content):
        returns = True
        extras.update(var_extras.get(var, []))
    if not returns:
        return None
    return sorted(extras)


# Mirrors the `verifiedOnDevice` entries in build_sdk_inventory.py — kept as a
# small separate list rather than reading that JSON, since this script must
# also run standalone. Only include something here once it's actually been
# traced (no network code in the library + no Retrofit client touched by the
# screens that use it), not just guessed.
VERIFIED_ON_DEVICE_SDKS = [
    {"displayName": "Yoti Face Capture Module", "importPrefix": "com.yoti"},
]


def detect_on_device_sdks(content, api_calls):
    if api_calls:
        return []  # screen already makes its own network calls; a badge here would be misleading
    return [sdk["displayName"] for sdk in VERIFIED_ON_DEVICE_SDKS if sdk["importPrefix"] in content]


def main():
    global STRINGS
    STRINGS = load_strings()
    registry = build_layout_registry()
    print(f"{len(registry)} layout->binding mappings built from {LAYOUT_DIR}")

    src_map = collect_source_map()
    os.makedirs(OUT_DIR, exist_ok=True)

    endpoint_map = build_endpoint_map()
    print(f"{len(endpoint_map)} Retrofit endpoints indexed from {len(RETROFIT_INTERFACE_FILES)} interfaces")

    with open(os.path.join(BASE_DIR, "explorer", "data", "feature_index.json")) as f:
        feature_index = json.load(f)
    activity_full_names = {f["className"] for f in feature_index["features"]}

    screens = {}
    mapped, unmapped = 0, 0
    layout_cache = {}

    candidates = {}
    for short, (full, content) in src_map.items():
        is_activity = full in activity_full_names
        is_fragment_like = "Fragment" in short and ("extends Fragment" in content or "extends DialogFragment" in content or "extends BottomSheetDialogFragment" in content)
        if not (is_activity or is_fragment_like):
            continue
        candidates[full] = (short, content, "activity" if is_activity else "fragment")

    for full, (short, content, kind) in candidates.items():
        layout_name = find_layout_for_source(content, registry)
        if not layout_name:
            unmapped += 1
            continue
        if layout_name not in layout_cache:
            layout_cache[layout_name] = parse_layout_file(layout_name)
        widgets = layout_cache[layout_name]
        if widgets is None:
            unmapped += 1
            continue
        mapped += 1
        api_calls = extract_api_calls(content, endpoint_map)
        screens[full] = {
            "id": full,
            "shortName": short,
            "kind": kind,
            "layout": layout_name,
            "title": guess_title(short, widgets),
            "widgets": [w for w in widgets if w["kind"] != "title"],
            "apiCalls": api_calls,
            "returnsExtras": extract_return_extras(content),
            "onDeviceSdks": detect_on_device_sdks(content, api_calls),
        }

    for full, screen in screens.items():
        out_path = os.path.join(OUT_DIR, full + ".json")
        os.makedirs(os.path.dirname(out_path), exist_ok=True)
        with open(out_path, "w") as f:
            json.dump(screen, f, separators=(",", ":"))

    index = {
        "version": VERSION,
        "screens": sorted(screens.keys()),
    }
    with open(os.path.join(BASE_DIR, "explorer", "data", "screens_index.json"), "w") as f:
        json.dump(index, f, separators=(",", ":"))

    print(f"Mapped {mapped} screens to layouts, {unmapped} activities/fragments had no resolvable layout.")
    print(f"Screen JSON written to {OUT_DIR}")


if __name__ == "__main__":
    main()
