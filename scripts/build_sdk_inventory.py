#!/usr/bin/env python3
"""
Catalogues the third-party libraries embedded in v9.68 (beyond the app's own
in.gov.eci.bloapp code): what they are, how many classes they contribute, what
native libraries / bundled model assets they ship, and a rough signal for
whether they contain any networking code at all.

This is deliberately conservative about verdicts: only entries we've actually
traced end-to-end (currently just Yoti) are marked "verifiedOnDevice". Others
get raw, low-interpretation signal (http literal / URL / Socket / WebView hits)
so the explorer can show evidence instead of asserting something unverified.

Writes explorer/data/sdk_inventory.json.
"""
import os
import re
import json
import zipfile
import io

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
VERSION = "9.68"
SRC_ROOT = os.path.join(BASE_DIR, "decompiled", f"{VERSION}_src", "sources")
APP_ROOT = os.path.join(SRC_ROOT, "in", "gov", "eci", "bloapp")
XAPK_PATH = os.path.join(BASE_DIR, "apks", f"BLOApp_{VERSION}.xapk")
OUT_PATH = os.path.join(BASE_DIR, "explorer", "data", "sdk_inventory.json")

NETWORK_SIGNAL_RE = re.compile(r"okhttp3\.OkHttp|HttpURLConnection|java\.net\.URL\(|WebView|new Socket\(|https?://")

FEATURE_SDKS = [
    {
        "id": "yoti-face-capture",
        "displayName": "Yoti Face Capture Module",
        "roots": ["com/yoti"],
        "verifiedOnDevice": True,
        "nativeLibNames": ["libface_detector_v2_jni.so", "libyuv_tools.so"],
        "bundledAssetPrefix": "assets/models/",
        "description": (
            "On-device face detection, framing and liveness-quality checks used when a BLO "
            "photographs an elector. Verified: ships its own TensorFlow Lite models and a "
            "native JNI face detector, contains no networking code anywhere in its ~80 classes, "
            "and the Activity wrapping it never touches the app's own API client — capture and "
            "quality-gating happen entirely on the device. A separate, later step in the calling "
            "screen uploads the resulting photo to the app's own face-detection/check-face endpoint."
        ),
    },
    {
        "id": "shockwave-pdfium",
        "displayName": "Pdfium (Shockwave)",
        "roots": ["com/shockwave"],
        "verifiedOnDevice": False,
        "nativeLibNames": ["libjniPdfium.so", "libmodpdfium.so", "libmodft2.so", "libmodpng.so"],
        "description": (
            "Local PDF rendering engine (PdfiumAndroid). Used to render/preview PDF documents "
            "(forms, uploaded proofs) inside the app rather than shelling out to an external "
            "viewer or a server-side renderer."
        ),
    },
    {
        "id": "sqlcipher",
        "displayName": "SQLCipher",
        "roots": ["net/sqlcipher"],
        "verifiedOnDevice": False,
        "nativeLibNames": ["libsqlcipher.so"],
        "description": (
            "Encrypted SQLite database engine. Suggests the app's local offline data store "
            "(cached forms, elector records held for offline use) is encrypted at rest on the "
            "device rather than kept in a plain SQLite file."
        ),
    },
    {
        "id": "ucrop",
        "displayName": "uCrop",
        "roots": ["com/yalantis"],
        "verifiedOnDevice": False,
        "description": "Image-cropping UI, used when a BLO selects/adjusts a photo (elector photo, document scan) before attaching it to a form.",
    },
    {
        "id": "youtube-player",
        "displayName": "Android YouTube Player",
        "roots": ["com/pierfrancescosoffritti"],
        "verifiedOnDevice": False,
        "description": (
            "Embeds YouTube videos in-app (likely training/help content for BLOs). Unlike the "
            "other libraries here, this one genuinely does reach the network — it loads video "
            "through a WebView-based player, which is why it shows the strongest network signal "
            "of the non-core libraries below."
        ),
    },
    {
        "id": "opencsv",
        "displayName": "OpenCSV",
        "roots": ["com/opencsv"],
        "verifiedOnDevice": False,
        "description": "CSV read/write library — likely used for bulk import/export of elector or form data.",
    },
    {
        "id": "circleimageview",
        "displayName": "CircleImageView",
        "roots": ["de/hdodenhof"],
        "verifiedOnDevice": False,
        "description": "Small UI widget rendering a circular ImageView — used for profile/elector photo thumbnails.",
    },
    {
        "id": "apache-commons-xmlbeans",
        "displayName": "Apache Commons + XMLBeans + MS Office XML schemas",
        "roots": ["org/apache", "com/microsoft"],
        "verifiedOnDevice": False,
        "uncertain": True,
        "description": (
            "Apache Commons utilities (lang3, io, compress) plus XMLBeans and Microsoft Office "
            "Open XML schema classes — 675 classes combined, but only ~10 of them are ever "
            "referenced by the app's own code: mainly commons-lang3's StringUtils (used in 210 "
            "files for null-safe string checks) and BooleanUtils (17 files), plus XMLBeans' "
            "XmlValidationError/XmlErrorCodes (24 files, XML validation) and a handful of "
            "commons-compress tar/cpio constants (archive handling). So the utility classes are "
            "genuinely and heavily used; what's unclear is why the full 675-class library (and "
            "the 47-class Microsoft Office XML schema set specifically) is bundled rather than "
            "just the handful of classes actually imported — likely the whole dependency wasn't "
            "tree-shaken rather than anything deliberately using the rest. Any http(s):// "
            "literals found here are very likely XML namespace URIs (a normal part of XML schema "
            "code), not live network calls."
        ),
    },
    {
        "id": "sparsebits",
        "displayName": "SparseBitSet (zaxxer)",
        "roots": ["com/zaxxer"],
        "verifiedOnDevice": False,
        "description": "A single-class bitset utility — trivial, almost certainly a transitive dependency of something else.",
    },
]

INFRA_SDKS = [
    {
        "id": "okhttp-okio",
        "displayName": "OkHttp + Okio",
        "roots": ["okhttp3", "okio"],
        "description": "The HTTP client / IO engine underlying all of the app's own network calls (see the endpoint catalogue used elsewhere in this explorer).",
    },
    {
        "id": "dagger-hilt",
        "displayName": "Dagger / Hilt",
        "roots": ["dagger"],
        "description": "Dependency-injection framework used throughout the app's architecture — not a feature SDK.",
    },
    {
        "id": "rxjava",
        "displayName": "RxJava",
        "roots": ["io/reactivex"],
        "description": "Reactive-programming library used for async/event-driven code throughout the app.",
    },
    {
        "id": "kotlin-runtime",
        "displayName": "Kotlin stdlib + Coroutines",
        "roots": ["kotlin", "kotlinx"],
        "description": "Kotlin language runtime and coroutines library — present because large parts of the app are written in Kotlin.",
    },
]


def count_classes(root):
    path = os.path.join(SRC_ROOT, root)
    if not os.path.isdir(path):
        return 0
    n = 0
    for _, _, files in os.walk(path):
        n += sum(1 for f in files if f.endswith(".java"))
    return n


def network_signal(root):
    path = os.path.join(SRC_ROOT, root)
    if not os.path.isdir(path):
        return {"httpLiteralOrApiHits": 0, "filesWithSignal": 0}
    files_with_signal = 0
    total_hits = 0
    for dirpath, _, files in os.walk(path):
        for fn in files:
            if not fn.endswith(".java"):
                continue
            with open(os.path.join(dirpath, fn), errors="ignore") as f:
                content = f.read()
            hits = len(NETWORK_SIGNAL_RE.findall(content))
            if hits:
                files_with_signal += 1
                total_hits += hits
    return {"httpLiteralOrApiHits": total_hits, "filesWithSignal": files_with_signal}


def used_by_app_file_count(roots):
    dotted_prefixes = [r.replace("/", ".") for r in roots]
    count = 0
    for dirpath, _, files in os.walk(APP_ROOT):
        for fn in files:
            if not fn.endswith(".java"):
                continue
            with open(os.path.join(dirpath, fn), errors="ignore") as f:
                content = f.read()
            if any(p in content for p in dotted_prefixes):
                count += 1
    return count


def load_native_libs_and_assets():
    native_libs = {}
    assets = []
    if not os.path.exists(XAPK_PATH):
        return native_libs, assets
    with zipfile.ZipFile(XAPK_PATH) as z:
        with zipfile.ZipFile(io.BytesIO(z.read("config.arm64_v8a.apk"))) as z2:
            for info in z2.infolist():
                if info.filename.startswith("lib/arm64-v8a/") and info.filename.endswith(".so"):
                    native_libs[os.path.basename(info.filename)] = info.file_size
        with zipfile.ZipFile(io.BytesIO(z.read("in.gov.eci.bloapp.apk"))) as z2:
            for info in z2.infolist():
                if info.filename.startswith("assets/models/"):
                    assets.append({"name": info.filename, "sizeBytes": info.file_size})
    return native_libs, assets


def build_entry(spec, native_libs, assets, category):
    class_count = sum(count_classes(r) for r in spec["roots"])
    sig = {"httpLiteralOrApiHits": 0, "filesWithSignal": 0}
    for r in spec["roots"]:
        s = network_signal(r)
        sig["httpLiteralOrApiHits"] += s["httpLiteralOrApiHits"]
        sig["filesWithSignal"] += s["filesWithSignal"]

    native = []
    for name in spec.get("nativeLibNames", []):
        if name in native_libs:
            native.append({"name": name, "sizeBytes": native_libs[name]})

    bundled_models = []
    prefix = spec.get("bundledAssetPrefix")
    if prefix:
        bundled_models = [a for a in assets if a["name"].startswith(prefix)]

    return {
        "id": spec["id"],
        "displayName": spec["displayName"],
        "category": category,
        "packageRoots": spec["roots"],
        "classCount": class_count,
        "description": spec["description"],
        "verifiedOnDevice": spec.get("verifiedOnDevice", False),
        "uncertain": spec.get("uncertain", False),
        "networkSignal": sig,
        "nativeLibs": native,
        "bundledModels": bundled_models,
        "usedByAppFileCount": used_by_app_file_count(spec["roots"]),
    }


def main():
    native_libs, assets = load_native_libs_and_assets()
    print(f"{len(native_libs)} native libs, {len(assets)} bundled model assets found in v{VERSION} xapk")

    entries = [build_entry(s, native_libs, assets, "feature") for s in FEATURE_SDKS]
    entries += [build_entry(s, native_libs, assets, "infrastructure") for s in INFRA_SDKS]
    entries.sort(key=lambda e: (e["category"], -e["classCount"]))

    mapped_libs = {n for e in entries for n in [x["name"] for x in e["nativeLibs"]]}
    unmapped_libs = [{"name": k, "sizeBytes": v} for k, v in native_libs.items() if k not in mapped_libs]

    out = {
        "version": VERSION,
        "sdks": entries,
        "unmappedNativeLibs": unmapped_libs,
    }
    os.makedirs(os.path.dirname(OUT_PATH), exist_ok=True)
    with open(OUT_PATH, "w") as f:
        json.dump(out, f, indent=None, separators=(",", ":"))
    print(f"Wrote {len(entries)} SDK entries to {OUT_PATH}")


if __name__ == "__main__":
    main()
