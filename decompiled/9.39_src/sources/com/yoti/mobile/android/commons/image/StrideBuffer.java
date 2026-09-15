package com.yoti.mobile.android.commons.image;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrideBuffer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J2\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0003H\u0004R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yoti/mobile/android/commons/image/StrideBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "width", "", "height", "raw", "", "stride", "pixelStride", "(II[BII)V", "wrapped", "Ljava/nio/ByteBuffer;", "rowStride", "(IILjava/nio/ByteBuffer;II)V", "getHeight", "()I", "getWidth", "fillData", "", "dest", "readPixelRow", "src", "bytesToRead", "bytesToSkip", "totalBytesRead", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StrideBuffer implements ImageBuffer {
    private final int a;
    private final int b;
    private final ByteBuffer c;
    private final int d;
    private final int e;

    public StrideBuffer(int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(byteBuffer, "wrapped");
        this.a = i;
        this.b = i2;
        this.c = byteBuffer;
        this.d = i3;
        this.e = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrideBuffer(int i, int i2, byte[] bArr) {
        this(i, i2, bArr, 0, 0, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bArr, "raw");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrideBuffer(int i, int i2, byte[] bArr, int i3) {
        this(i, i2, bArr, i3, 0, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bArr, "raw");
    }

    public static /* synthetic */ int readPixelRow$default(StrideBuffer strideBuffer, ByteBuffer byteBuffer, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixelRow");
        }
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        return strideBuffer.readPixelRow(byteBuffer, bArr, i, i2, i3);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int pixelRow = 0;
        if (this.e == 1) {
            int a = this.d - getA();
            if (a == 0) {
                ByteBuffer byteBuffer = this.c;
                byteBuffer.get(dest, 0, byteBuffer.remaining());
                return;
            } else {
                while (this.c.hasRemaining()) {
                    pixelRow += readPixelRow(this.c, dest, getA(), a, pixelRow);
                }
                return;
            }
        }
        int a2 = getA() * this.e;
        int i = this.d - a2;
        byte[] bArr = new byte[a2];
        int a3 = 0;
        while (this.c.hasRemaining()) {
            readPixelRow$default(this, this.c, bArr, a2, i, 0, 16, null);
            int a4 = getA();
            for (int i2 = 0; i2 < a4; i2++) {
                dest[a3 + i2] = bArr[this.e * i2];
            }
            a3 += getA();
        }
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public byte[] getData() {
        return ImageBuffer.DefaultImpls.getData(this);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public int getB() {
        return this.b;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getWidth, reason: from getter */
    public int getA() {
        return this.a;
    }

    protected final int readPixelRow(ByteBuffer src, byte[] dest, int bytesToRead, int bytesToSkip, int totalBytesRead) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dest, "dest");
        int iMin = Math.min(bytesToRead, src.remaining());
        src.get(dest, totalBytesRead, iMin);
        src.position(Math.min(src.position() + bytesToSkip, src.limit()));
        return iMin;
    }

    public /* synthetic */ StrideBuffer(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, byteBuffer, (i5 & 8) != 0 ? i : i3, (i5 & 16) != 0 ? 1 : i4);
    }

    public /* synthetic */ StrideBuffer(int i, int i2, byte[] bArr, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, bArr, (i5 & 8) != 0 ? i : i3, (i5 & 16) != 0 ? 1 : i4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StrideBuffer(int i, int i2, byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "raw");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(raw)");
        this(i, i2, byteBufferWrap, i3, i4);
    }
}
