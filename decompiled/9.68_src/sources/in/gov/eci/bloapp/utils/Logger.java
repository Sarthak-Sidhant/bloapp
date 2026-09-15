package in.gov.eci.bloapp.utils;

import android.util.Log;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Logger {
    public static boolean isDebugEnabled() {
        return false;
    }

    public static void d(String tag, String data) {
        if (isDebugEnabled()) {
            Log.d(tag, data);
        }
    }

    public static void i(String tag, String data) {
        if (isDebugEnabled()) {
            Log.i(tag, data);
        }
    }

    public static void e(String tag, String data) {
        if (isDebugEnabled()) {
            Log.e(tag, data);
        }
    }

    public static void e(String tag, String data, Throwable t) {
        if (isDebugEnabled()) {
            Log.e(tag, data, t);
        }
    }

    public static void w(String tag, String data) {
        if (isDebugEnabled()) {
            Log.w(tag, data);
        }
    }

    public static void wtf(String tag, String data) {
        if (isDebugEnabled()) {
            Log.wtf(tag, data);
        }
    }
}
