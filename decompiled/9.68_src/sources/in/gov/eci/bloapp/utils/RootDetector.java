package in.gov.eci.bloapp.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class RootDetector {
    private static final String[] SU_PATHS = {"/system/bin/su", "/system/xbin/su", "/sbin/su", "/vendor/bin/su", "/system/sd/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/su/bin/su", "/magisk/.core/bin/su"};
    private static final String[] BUSYBOX_PATHS = {"/system/bin/busybox", "/system/xbin/busybox", "/sbin/busybox", "/vendor/bin/busybox", "/data/local/busybox"};
    private static final String[] KNOWN_ROOT_APPS = {"com.topjohnwu.magisk", "com.topjohnwu.magisk.debug", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.kingroot.kinguser", "com.zachspong.temprootremovejb", "com.noshufou.android.su"};
    private static final String[] MAGISK_FOOTPRINTS = {"/sbin/.magisk", "/cache/.magisk", "/data/adb/magisk", "/data/adb/magisk.db", "/data/adb/modules", "/data/adb/ksu"};

    private RootDetector() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public static boolean isDeviceRooted(Context context) {
        ?? HasTestKeys = hasTestKeys();
        int i = HasTestKeys;
        if (hasSuBinary()) {
            i = HasTestKeys + 1;
        }
        int i2 = i;
        if (canExecuteSu()) {
            i2 = i + 2;
        }
        int i3 = i2;
        if (hasBusybox()) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (hasDangerousProps()) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (isSelinuxPermissive()) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (hasRwMounts()) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (hasKnownRootApps(context)) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (hasMagiskFootprints()) {
            i8 = i7 + 2;
        }
        return i8 >= 2;
    }

    public static boolean hasTestKeys() {
        try {
            String str = Build.TAGS;
            return str != null && str.contains("test-keys");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasSuBinary() {
        for (String str : SU_PATHS) {
            try {
                if (new File(str).exists()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean hasBusybox() {
        for (String str : BUSYBOX_PATHS) {
            try {
                if (new File(str).exists()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean canExecuteSu() {
        for (String str : SU_PATHS) {
            if (tryExec(new String[]{str, "-c", "id"})) {
                return true;
            }
        }
        return tryExec(new String[]{"which", "su"}) || tryExec(new String[]{"/system/xbin/which", "su"});
    }

    private static boolean tryExec(String[] cmd) {
        Process processExec;
        boolean z = false;
        BufferedReader bufferedReader = null;
        try {
            processExec = Runtime.getRuntime().exec(cmd);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                try {
                    String line = bufferedReader2.readLine();
                    try {
                        processExec.waitFor();
                    } catch (InterruptedException unused) {
                    }
                    if (line != null && !line.trim().isEmpty()) {
                        z = true;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused2) {
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return z;
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return false;
                }
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
            processExec = null;
        }
    }

    public static boolean hasDangerousProps() {
        String[][] strArr = {new String[]{"ro.debuggable", "1"}, new String[]{"ro.secure", "0"}};
        for (int i = 0; i < 2; i++) {
            String[] strArr2 = strArr[i];
            if (strArr2[1].equals(getProp(strArr2[0]))) {
                return true;
            }
        }
        return false;
    }

    private static String getProp(String name) {
        Process processExec;
        String strTrim = "";
        BufferedReader bufferedReader = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"getprop", name});
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                try {
                    String line = bufferedReader2.readLine();
                    try {
                        processExec.waitFor();
                    } catch (InterruptedException unused) {
                    }
                    if (line != null) {
                        strTrim = line.trim();
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused2) {
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return strTrim;
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return "";
                }
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
            processExec = null;
        }
    }

    public static boolean isSelinuxPermissive() {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("/sys/fs/selinux/enforce");
            if (!file.exists()) {
                return false;
            }
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader2.readLine();
                boolean zEquals = "0".equals(line != null ? line.trim() : "");
                try {
                    bufferedReader2.close();
                } catch (Throwable unused) {
                }
                return zEquals;
            } catch (Throwable unused2) {
                bufferedReader = bufferedReader2;
            }
        } catch (Throwable unused3) {
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused4) {
            }
        }
        return false;
    }

    public static boolean hasRwMounts() {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            break;
                        }
                        if (line.contains(" /system ") || line.contains(" /vendor ") || line.contains(" /")) {
                            if (line.contains(" rw,")) {
                                try {
                                    bufferedReader2.close();
                                    return true;
                                } catch (Throwable unused) {
                                    return true;
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader == null) {
                            return false;
                        }
                        bufferedReader.close();
                    }
                }
            } catch (Throwable unused3) {
                return false;
            }
        } catch (Throwable unused4) {
        }
        return false;
    }

    public static boolean hasKnownRootApps(Context ctx) {
        PackageManager packageManager = ctx.getPackageManager();
        for (String str : KNOWN_ROOT_APPS) {
            try {
                packageManager.getPackageInfo(str, 0);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean hasMagiskFootprints() {
        for (String str : MAGISK_FOOTPRINTS) {
            try {
                if (new File(str).exists()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return !getProp("magisk.version").isEmpty() || "1".equals(getProp("zygisk.enable"));
    }
}
