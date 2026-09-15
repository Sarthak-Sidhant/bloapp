package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FailFast.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"failFast", "", "message", "", "error", "", "commons-utils_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FailFast {
    public static final void failFast() {
        failFast$default(null, null, 3, null);
    }

    public static final void failFast(String str) {
        failFast$default(str, null, 2, null);
    }

    public static final void failFast(String str, Throwable th) {
        throw new FailFastException(str, th);
    }

    public static /* synthetic */ void failFast$default(String str, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        failFast(str, th);
    }

    public static final void failFast(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        throw new FailFastException(null, error, 1, null);
    }
}
