import os
import re
import sys
import time
import zipfile
import subprocess
from concurrent.futures import ThreadPoolExecutor, as_completed

BASE_DIR = "/Users/sidhant/Desktop/bloapp"
APKS_DIR = os.path.join(BASE_DIR, "apks")
EXTRACTED_DIR = os.path.join(BASE_DIR, "extracted")
DECOMPILED_DIR = os.path.join(BASE_DIR, "decompiled")

os.makedirs(APKS_DIR, exist_ok=True)
os.makedirs(EXTRACTED_DIR, exist_ok=True)
os.makedirs(DECOMPILED_DIR, exist_ok=True)

def parse_versions():
    md_file = os.path.join(BASE_DIR, "BLOApp_download_list.md")
    with open(md_file, "r") as f:
        content = f.read()

    matches = re.findall(
        r'\|\s*([0-9.]+)\s*\|\s*([0-9-]+)\s*\|\s*\[.*?\]\((https://apkcombo\.com/bloapp/[^)]+)\)\s*\|\s*\[.*?\]\((https://apkcombo\.com/d\?[^)]+)\)',
        content
    )
    versions = []
    for ver, date, page, direct in matches:
        versions.append({
            "version": ver,
            "date": date,
            "page": page,
            "direct": direct
        })
    return versions

def download_and_extract_version(v_info):
    ver = v_info["version"]
    date = v_info["date"]
    url = v_info["direct"]
    
    xapk_path = os.path.join(APKS_DIR, f"BLOApp_{ver}.xapk")
    out_dir = os.path.join(EXTRACTED_DIR, ver)
    manifest_target = os.path.join(out_dir, "AndroidManifest.xml")
    strings_target = os.path.join(out_dir, "strings.xml")

    if os.path.exists(manifest_target) and os.path.exists(strings_target):
        print(f"[{ver}] Already extracted.")
        return ver, True, "cached"

    # Step 1: Download if not present
    if not os.path.exists(xapk_path) or os.path.getsize(xapk_path) < 1000000:
        print(f"[{ver}] Downloading from CDN ({date})...")
        t0 = time.time()
        cmd = [
            "curl", "-s", "-L", "-A", "curl/7.88.1",
            "--connect-timeout", "15", "--max-time", "120",
            "-o", xapk_path, url
        ]
        ret = subprocess.run(cmd)
        if ret.returncode != 0 or os.path.getsize(xapk_path) < 1000000:
            print(f"[{ver}] Download failed or incomplete!")
            return ver, False, "download_failed"
        print(f"[{ver}] Downloaded ({os.path.getsize(xapk_path)/(1024*1024):.1f}MB) in {time.time()-t0:.1f}s")

    # Step 2: Extract base APK from XAPK and save DEX files
    os.makedirs(out_dir, exist_ok=True)
    dex_dir = os.path.join(out_dir, "dex")
    os.makedirs(dex_dir, exist_ok=True)
    temp_base_apk = os.path.join(out_dir, "in.gov.eci.bloapp.apk")
    try:
        with zipfile.ZipFile(xapk_path, 'r') as zf:
            base_data = zf.read("in.gov.eci.bloapp.apk")
            with open(temp_base_apk, 'wb') as out_f:
                out_f.write(base_data)
            
            # Also extract dex files from base_data
            import io
            with zipfile.ZipFile(io.BytesIO(base_data), 'r') as bzf:
                for bname in bzf.namelist():
                    if bname.startswith("classes") and bname.endswith(".dex"):
                        with open(os.path.join(dex_dir, bname), 'wb') as df:
                            df.write(bzf.read(bname))
    except Exception as e:
        print(f"[{ver}] Error extracting base apk or dex: {e}")
        return ver, False, str(e)

    # Step 3: Run jadx -s on base apk to decode resources
    res_dir = os.path.join(out_dir, "res_decoded")
    t0 = time.time()
    cmd = ["jadx", "-s", "-q", "-d", res_dir, temp_base_apk]
    ret = subprocess.run(cmd)
    
    # Check if Manifest and strings exist
    m_src = os.path.join(res_dir, "resources", "AndroidManifest.xml")
    if not os.path.exists(m_src):
        # alternate path
        m_src = os.path.join(res_dir, "AndroidManifest.xml")
        
    s_src = os.path.join(res_dir, "resources", "res", "values", "strings.xml")
    if not os.path.exists(s_src):
        s_src = os.path.join(res_dir, "res", "values", "strings.xml")

    if os.path.exists(m_src):
        os.replace(m_src, manifest_target)
    if os.path.exists(s_src):
        os.replace(s_src, strings_target)

    # Remove the large unzipped base apk and temp res_dir to keep things clean, but keep XAPK and dex
    try:
        os.remove(temp_base_apk)
        subprocess.run(["rm", "-rf", res_dir])
    except Exception:
        pass

    print(f"[{ver}] Decoded and saved resources in {time.time()-t0:.1f}s")
    return ver, True, "success"

def main():
    versions = parse_versions()
    print(f"Starting processing for {len(versions)} versions with 4 workers...")
    t_start = time.time()
    
    with ThreadPoolExecutor(max_workers=4) as executor:
        futures = {executor.submit(download_and_extract_version, v): v["version"] for v in versions}
        for future in as_completed(futures):
            ver = futures[future]
            try:
                v, success, msg = future.result()
                print(f"Completed {v}: {msg}")
            except Exception as e:
                print(f"Exception for {ver}: {e}")

    print(f"All processing finished in {time.time()-t_start:.1f}s")

if __name__ == "__main__":
    main()
