import os
import re
import json
import xml.etree.ElementTree as ET
import glob

BASE_DIR = "/Users/sidhant/Desktop/bloapp"
EXTRACTED_DIR = os.path.join(BASE_DIR, "extracted")
MD_FILE = os.path.join(BASE_DIR, "BLOApp_download_list.md")

def get_ordered_versions():
    with open(MD_FILE, "r") as f:
        content = f.read()
    matches = re.findall(r'\|\s*([0-9.]+)\s*\|\s*([0-9-]+)\s*\|', content)
    # The file has newest first (9.68 -> 9.39). Reverse it so it is chronological (9.39 -> 9.68)
    return list(reversed(matches))

def parse_manifest(v):
    path = os.path.join(EXTRACTED_DIR, v, "AndroidManifest.xml")
    if not os.path.exists(path):
        return None
    try:
        tree = ET.parse(path)
        root = tree.getroot()
        ns = {'android': 'http://schemas.android.com/apk/res/android'}
        
        v_code = root.attrib.get('{http://schemas.android.com/apk/res/android}versionCode', '')
        v_name = root.attrib.get('{http://schemas.android.com/apk/res/android}versionName', '')
        
        uses_sdk = root.find('uses-sdk')
        min_sdk = uses_sdk.attrib.get('{http://schemas.android.com/apk/res/android}minSdkVersion', '') if uses_sdk is not None else ''
        target_sdk = uses_sdk.attrib.get('{http://schemas.android.com/apk/res/android}targetSdkVersion', '') if uses_sdk is not None else ''
        
        permissions = set()
        for p in root.findall('uses-permission'):
            name = p.attrib.get('{http://schemas.android.com/apk/res/android}name')
            if name: permissions.add(name)
            
        activities = set()
        for a in root.iter('activity'):
            name = a.attrib.get('{http://schemas.android.com/apk/res/android}name')
            if name: activities.add(name)
            
        services = set()
        for s in root.iter('service'):
            name = s.attrib.get('{http://schemas.android.com/apk/res/android}name')
            if name: services.add(name)
            
        receivers = set()
        for r in root.iter('receiver'):
            name = r.attrib.get('{http://schemas.android.com/apk/res/android}name')
            if name: receivers.add(name)

        return {
            'versionCode': v_code,
            'versionName': v_name,
            'minSdkVersion': min_sdk,
            'targetSdkVersion': target_sdk,
            'permissions': permissions,
            'activities': activities,
            'services': services,
            'receivers': receivers
        }
    except Exception as e:
        print(f"Error parsing manifest for {v}: {e}")
        return None

def parse_strings(v):
    path = os.path.join(EXTRACTED_DIR, v, "strings.xml")
    if not os.path.exists(path):
        return {}
    try:
        tree = ET.parse(path)
        root = tree.getroot()
        res = {}
        for s in root.findall('string'):
            name = s.attrib.get('name')
            text = s.text or ''
            if name: res[name] = text
        return res
    except Exception as e:
        print(f"Error parsing strings for {v}: {e}")
        return {}

def parse_dex_classes(v):
    dex_dir = os.path.join(EXTRACTED_DIR, v, "dex")
    if not os.path.exists(dex_dir):
        return set()
    classes = set()
    for f in glob.glob(os.path.join(dex_dir, "*.dex")):
        try:
            with open(f, "rb") as fp:
                data = fp.read()
            found = re.findall(b'Lin/gov/eci/[a-zA-Z0-9_/$]+;', data)
            for c in found:
                classes.add(c.decode('utf-8', errors='ignore'))
        except Exception:
            pass
    return classes

def run():
    ordered = get_ordered_versions()
    print(f"Processing timeline for {len(ordered)} chronological versions...")
    
    timeline = []
    prev_manifest = None
    prev_strings = None
    prev_classes = None

    for ver, date in ordered:
        manifest = parse_manifest(ver)
        strings = parse_strings(ver)
        classes = parse_dex_classes(ver)
        
        diff = {
            'version': ver,
            'date': date,
            'versionCode': manifest['versionCode'] if manifest else '',
            'targetSdkVersion': manifest['targetSdkVersion'] if manifest else '',
            'total_activities': len(manifest['activities']) if manifest else 0,
            'total_strings': len(strings),
            'total_eci_classes': len(classes),
            'added_activities': [],
            'removed_activities': [],
            'added_strings': {},
            'modified_strings': {},
            'added_classes': [],
            'removed_classes': []
        }
        
        if prev_manifest:
            diff['added_activities'] = sorted(list(manifest['activities'] - prev_manifest['activities']))
            diff['removed_activities'] = sorted(list(prev_manifest['activities'] - manifest['activities']))
            
        if prev_strings:
            added_str_keys = set(strings.keys()) - set(prev_strings.keys())
            diff['added_strings'] = {k: strings[k] for k in sorted(added_str_keys)}
            
            mod_str_keys = [k for k in prev_strings if k in strings and prev_strings[k] != strings[k]]
            diff['modified_strings'] = {k: {'old': prev_strings[k], 'new': strings[k]} for k in sorted(mod_str_keys)}
            
        if prev_classes is not None:
            diff['added_classes'] = sorted(list(classes - prev_classes))
            diff['removed_classes'] = sorted(list(prev_classes - classes))
            
        timeline.append(diff)
        prev_manifest = manifest
        prev_strings = strings
        prev_classes = classes

    # Save to JSON
    out_json = os.path.join(BASE_DIR, "timeline_analysis.json")
    with open(out_json, "w", encoding="utf-8") as f:
        json.dump(timeline, f, indent=2, ensure_ascii=False)
    print(f"Saved timeline analysis to {out_json}")

    # Generate Markdown Summary
    md_report = os.path.join(BASE_DIR, "BLOApp_Version_Changes_Report.md")
    with open(md_report, "w", encoding="utf-8") as f:
        f.write("# BLO App (in.gov.eci.bloapp) Comprehensive Software Change Log\n\n")
        f.write("## Overview of Version Evolution During SIR (June 2026 – September 2026)\n\n")
        f.write("| Version | Date | Version Code | Activities | Strings | ECI Classes | Major Changes Summary |\n")
        f.write("|---|---|---|---|---|---|---|\n")
        
        for item in timeline:
            v = item['version']
            dt = item['date']
            vc = item['versionCode']
            n_act = item['total_activities']
            n_str = item['total_strings']
            n_cls = item['total_eci_classes']
            
            highlights = []
            if item['added_activities']:
                highlights.append(f"+{len(item['added_activities'])} activities ({', '.join([a.split('.')[-1] for a in item['added_activities'][:3]])}{'...' if len(item['added_activities']) > 3 else ''})")
            if item['added_strings']:
                highlights.append(f"+{len(item['added_strings'])} strings")
            if item['modified_strings']:
                highlights.append(f"{len(item['modified_strings'])} modified strings")
            if item['added_classes']:
                highlights.append(f"+{len(item['added_classes'])} classes")
            if not highlights:
                highlights.append("Minor maintenance / bugfix")
                
            summary = "; ".join(highlights)
            f.write(f"| {v} | {dt} | {vc} | {n_act} | {n_str} | {n_cls} | {summary} |\n")
            
        f.write("\n\n---\n\n## Detailed Version-by-Version Breakdown\n\n")
        
        for item in timeline:
            f.write(f"### Version {item['version']} (Date: {item['date']}, Version Code: {item['versionCode']})\n\n")
            if item['added_activities']:
                f.write("#### New Activities Added:\n")
                for a in item['added_activities']:
                    f.write(f"- `{a}`\n")
                f.write("\n")
                
            if item['removed_activities']:
                f.write("#### Activities Removed:\n")
                for a in item['removed_activities']:
                    f.write(f"- `{a}`\n")
                f.write("\n")
                
            if item['added_strings']:
                f.write("#### New UI Strings / Features:\n")
                for k, val in item['added_strings'].items():
                    val_clean = val.replace("\n", " ")
                    f.write(f"- **`{k}`**: \"{val_clean}\"\n")
                f.write("\n")

            if item['modified_strings']:
                f.write("#### Modified Strings:\n")
                for k, diffs in item['modified_strings'].items():
                    old_c = diffs['old'].replace("\n", " ")
                    new_c = diffs['new'].replace("\n", " ")
                    f.write(f"- **`{k}`**:\n  - *Old*: \"{old_c}\"\n  - *New*: \"{new_c}\"\n")
                f.write("\n")

            if item['added_classes']:
                f.write(f"#### Codebase Changes:\n- Added {len(item['added_classes'])} new classes.\n")
                # Group added classes by package
                pkgs = {}
                for c in item['added_classes']:
                    pkg = "/".join(c.strip("L;").split("/")[:-1]).replace("/", ".")
                    pkgs[pkg] = pkgs.get(pkg, 0) + 1
                f.write("  - Package breakdown of added classes:\n")
                for p, count in sorted(pkgs.items(), key=lambda x: -x[1])[:8]:
                    f.write(f"    - `{p}`: {count} classes\n")
                f.write("\n")

    print(f"Report generated at {md_report}")

if __name__ == "__main__":
    run()
