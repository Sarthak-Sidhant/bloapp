package com.yoti.mobile.android.core.yuvtools;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/yoti/mobile/android/core/yuvtools/YuvModel;", "", "header", "", "gzipY", "", "gzipX", "height", "", "width", "(Ljava/lang/String;[B[BII)V", "getGzipX", "()[B", "getGzipY", "getHeader", "()Ljava/lang/String;", "getHeight", "()I", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class YuvModel {
    private final String a;
    private final byte[] b;
    private final byte[] c;
    private final int d;
    private final int e;

    public YuvModel(String str, byte[] bArr, byte[] bArr2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "header");
        Intrinsics.checkNotNullParameter(bArr, "gzipY");
        Intrinsics.checkNotNullParameter(bArr2, "gzipX");
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
        this.d = i;
        this.e = i2;
    }

    public static /* synthetic */ YuvModel copy$default(YuvModel yuvModel, String str, byte[] bArr, byte[] bArr2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = yuvModel.a;
        }
        if ((i3 & 2) != 0) {
            bArr = yuvModel.b;
        }
        byte[] bArr3 = bArr;
        if ((i3 & 4) != 0) {
            bArr2 = yuvModel.c;
        }
        byte[] bArr4 = bArr2;
        if ((i3 & 8) != 0) {
            i = yuvModel.d;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = yuvModel.e;
        }
        return yuvModel.copy(str, bArr3, bArr4, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final byte[] getC() {
        return this.c;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getD() {
        return this.d;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getE() {
        return this.e;
    }

    public final YuvModel copy(String header, byte[] gzipY, byte[] gzipX, int height, int width) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(gzipY, "gzipY");
        Intrinsics.checkNotNullParameter(gzipX, "gzipX");
        return new YuvModel(header, gzipY, gzipX, height, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YuvModel)) {
            return false;
        }
        YuvModel yuvModel = (YuvModel) other;
        return Intrinsics.areEqual(this.a, yuvModel.a) && Intrinsics.areEqual(this.b, yuvModel.b) && Intrinsics.areEqual(this.c, yuvModel.c) && this.d == yuvModel.d && this.e == yuvModel.e;
    }

    public final byte[] getGzipX() {
        return this.c;
    }

    public final byte[] getGzipY() {
        return this.b;
    }

    public final String getHeader() {
        return this.a;
    }

    public final int getHeight() {
        return this.d;
    }

    public final int getWidth() {
        return this.e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "YuvModel(header=" + this.a + ", gzipY=" + Arrays.toString(this.b) + ", gzipX=" + Arrays.toString(this.c) + ", height=" + this.d + ", width=" + this.e + ')';
    }
}
