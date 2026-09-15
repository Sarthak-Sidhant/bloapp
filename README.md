# BLO App — Reverse Engineering & Version History Explorer

Comprehensive analysis, decompilation, and interactive web explorer for **BLO App** (`in.gov.eci.bloapp` - Election Commission of India's Booth Level Officer application) across 30 releases (v9.39 through v9.68+).

---

## Overview

This repository contains:
1. **Interactive Web Explorer (`explorer/`)**: A browser-based interface to explore the release timeline, feature mappings, navigation flow graphs, UI reconstructions, embedded SDK inventory, and version-to-version diffs.
2. **Decompiled Code & Resources (`decompiled/`)**: Java source code and Android resource trees (`res/layout`, strings, etc.) for baseline (v9.39) and latest (v9.68).
3. **Extracted Metadata (`extracted/`)**: Parsed `AndroidManifest.xml` and `strings.xml` for all 30 releases.
4. **Analysis Scripts (`scripts/`)**: Python tools used to process APKs, extract Retrofit network interfaces, map Activity/Fragment navigation graphs, reconstruct XML UI layouts, and index bundled SDKs.
5. **Reports & Data**:
   - `BLOApp_Version_Changes_Report.md` — Detailed version-by-version change report.
   - `timeline_analysis.json` — Aggregated timeline diffs and metrics.
   - `BLOApp_download_list.md` & `BLOApp_direct_links.txt` — APK source catalogs.

---

## Directory Structure

```
bloapp/
├── explorer/                  # Interactive Web Explorer UI & generated datasets
│   ├── index.html             # Main explorer application
│   ├── app.js                 # Frontend application logic
│   ├── style.css              # Custom styling & dark-theme UI
│   ├── data/                  # Precomputed JSON datasets (timeline, features, mock UI)
│   └── README.md              # Explorer-specific documentation
├── scripts/                   # Data extraction and analysis pipeline
│   ├── build_explorer_data.py # Generates timeline diffs & flow graphs
│   ├── build_ui_mock_data.py  # Parses layouts & maps screens to Retrofit endpoints
│   ├── build_sdk_inventory.py # Indexes bundled SDKs, native .so libs, and models
│   ├── generate_timeline.py   # Historical version timeline generator
│   └── process_versions.py    # Per-version manifest and strings extraction
├── decompiled/                # Jadx-decompiled sources and resources
│   ├── 9.39_src/ & 9.39_res/  # Baseline version (v9.39)
│   └── 9.68_src/ & 9.68_res/  # Modern version (v9.68)
├── extracted/                 # 30 versions (v9.39 to v9.68) with AndroidManifest & strings
├── BLOApp_Version_Changes_Report.md
├── timeline_analysis.json
└── .gitignore
```

---

## Running the Web Explorer

The explorer is entirely static and runs in any modern web browser:

```bash
cd explorer
python3 -m http.server 8000
```

Then visit **`http://localhost:8000`** in your browser.

> **Note**: HTTP serving is required because browsers block local `file://` fetch requests for the data JSONs.

### Key Explorer Features
- **Timeline**: Track screen, permission, receiver, and string additions/removals across 30 releases.
- **Screens & Features**: Functional module grouping of all mapped activities.
- **Flow Explorer**: Interactive screen navigation graph extracted via static call-graph analysis of `startActivity` and `FragmentTransaction` calls.
- **Try the App**: Interactive mock UI reconstructed directly from Android layout XMLs with resolved string keys and mapped Retrofit API endpoints.
- **Embedded SDKs**: Inventory of third-party libraries, bundled `.so` binaries, and ML models.
- **Version Compare**: Side-by-side accumulated diffs between any two arbitrary versions.

---

## Regenerating Data

If new releases are added or scripts are updated:

```bash
python3 scripts/build_explorer_data.py   # Rebuild timeline & flow graphs
python3 scripts/build_ui_mock_data.py    # Rebuild UI mock layouts & API mappings
python3 scripts/build_sdk_inventory.py   # Rebuild SDK inventory
```
