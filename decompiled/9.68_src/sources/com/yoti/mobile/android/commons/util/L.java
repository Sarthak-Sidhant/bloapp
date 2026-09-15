package com.yoti.mobile.android.commons.util;

import android.util.Log;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: Log.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u001a*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"isRunningInJvm", "", "logDebug", "", "tag", "", "message", "logError", "error", "", "logForJvm", "printStream", "Ljava/io/PrintStream;", "logIntoJvmErrorOutput", "logIntoJvmNormalOutput", "logWarning", "commons-utils_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class L {
    private static final boolean a;

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    static {
        boolean zContainsMatchIn;
        String property = System.getProperty(SystemProperties.JAVA_RUNTIME_NAME);
        if (property != null) {
            String lowerCase = property.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (lowerCase != null) {
                zContainsMatchIn = new Regex("jdk|java.* se").containsMatchIn(lowerCase);
            } else {
                zContainsMatchIn = false;
            }
        } else {
            zContainsMatchIn = false;
        }
        a = zContainsMatchIn;
    }

    static /* synthetic */ void a(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        b(str, str2, th);
    }

    private static final void b(String str, String str2, Throwable th) {
        PrintStream out = System.out;
        Intrinsics.checkNotNullExpressionValue(out, "out");
        a(out, str, str2, th);
    }

    public static final void logDebug(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (a) {
            a(tag, message, null, 4, null);
        } else if (Debug.isDebugBuild) {
            Log.d(tag, message);
        }
    }

    public static final void logError(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        logError$default(tag, message, null, 4, null);
    }

    public static final void logError(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (a) {
            a(tag, message, th);
        } else if (Debug.isDebugBuild) {
            Log.e(tag, message, th);
        }
    }

    public static /* synthetic */ void logError$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logError(str, str2, th);
    }

    public static final void logWarning(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        logWarning$default(tag, message, null, 4, null);
    }

    public static final void logWarning(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (a) {
            a(tag, message, th);
        } else if (Debug.isDebugBuild) {
            Log.w(tag, message, th);
        }
    }

    public static /* synthetic */ void logWarning$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logWarning(str, str2, th);
    }

    private static final void a(String str, String str2, Throwable th) {
        PrintStream err = System.err;
        Intrinsics.checkNotNullExpressionValue(err, "err");
        a(err, str, str2, th);
    }

    private static final void a(PrintStream printStream, String str, String str2, Throwable th) {
        printStream.println(str + '\t' + str2);
        if (th != null) {
            th.printStackTrace();
        }
    }
}
