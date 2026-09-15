package com.yoti.mobile.android.commons.image;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlanarStrideBuffer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/yoti/mobile/android/commons/image/PlanarStrideBuffer;", "Lcom/yoti/mobile/android/commons/image/StrideBuffer;", "width", "", "height", "yBuffer", "Ljava/nio/ByteBuffer;", "yRowStride", "yPixelStride", "uBuffer", "vBuffer", "uvRowStride", "uvPixelStride", "(IILjava/nio/ByteBuffer;IILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;II)V", "getHeight", "()I", "getWidth", "fillData", "", "dest", "", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlanarStrideBuffer extends StrideBuffer {
    private final int f;
    private final int g;
    private final ByteBuffer h;
    private final ByteBuffer i;
    private final int j;
    private final int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanarStrideBuffer(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5, int i6) {
        super(i, i2, byteBuffer, i3, i4);
        Intrinsics.checkNotNullParameter(byteBuffer, "yBuffer");
        Intrinsics.checkNotNullParameter(byteBuffer2, "uBuffer");
        Intrinsics.checkNotNullParameter(byteBuffer3, "vBuffer");
        this.f = i;
        this.g = i2;
        this.h = byteBuffer2;
        this.i = byteBuffer3;
        this.j = i5;
        this.k = i6;
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.fillData(dest);
        int f = getF() * getG();
        int f2 = getF() / 2;
        int i = this.k * f2;
        int i2 = this.j - i;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i];
        int g = getG() / 2;
        int i3 = f;
        int i4 = 0;
        while (i4 < g) {
            int i5 = i4;
            StrideBuffer.readPixelRow$default(this, this.h, bArr, i, i2, 0, 16, null);
            StrideBuffer.readPixelRow$default(this, this.i, bArr2, i, i2, 0, 16, null);
            for (int i6 = 0; i6 < f2; i6++) {
                int i7 = i3 + (i6 * 2);
                int i8 = this.k * i6;
                dest[i7] = bArr2[i8];
                dest[i7 + 1] = bArr[i8];
            }
            i3 += f2 * 2;
            i4 = i5 + 1;
        }
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public int getG() {
        return this.g;
    }

    @Override // com.yoti.mobile.android.commons.image.StrideBuffer, com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getWidth, reason: from getter */
    public int getF() {
        return this.f;
    }
}
