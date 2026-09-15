package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: Preconditions.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, d2 = {"checkArgument", "", "condition", "", "errorMessage", "", "checkState", "commons-utils_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Preconditions {
    public static final void checkArgument(boolean z, Object obj) {
        if (z) {
        } else {
            throw new IllegalArgumentException(obj != null ? obj.toString() : null);
        }
    }

    public static /* synthetic */ void checkArgument$default(boolean z, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        checkArgument(z, obj);
    }

    public static final void checkState(boolean z, Object obj) {
        if (z) {
        } else {
            throw new IllegalStateException(obj != null ? obj.toString() : null);
        }
    }

    public static /* synthetic */ void checkState$default(boolean z, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        checkState(z, obj);
    }
}
