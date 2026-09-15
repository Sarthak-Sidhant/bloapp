package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FailFast.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yoti/mobile/android/commons/util/FailFastException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "error", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "commons-utils_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FailFastException extends RuntimeException {
    /* JADX WARN: Multi-variable type inference failed */
    public FailFastException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FailFastException(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FailFastException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    public FailFastException(String str, Throwable th) {
        super(str, th);
    }
}
