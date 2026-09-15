package com.yoti.mobile.android.commons.image;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DirectBuffer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/yoti/mobile/android/commons/image/DirectBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Ljava/io/Serializable;", "width", "", "height", "rawData", "", "(II[B)V", "getHeight", "()I", "getWidth", "fillData", "", "dest", "Companion", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DirectBuffer implements ImageBuffer, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 1;
    private final int height;
    public final byte[] rawData;
    private final int width;

    /* JADX INFO: compiled from: DirectBuffer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yoti/mobile/android/commons/image/DirectBuffer$Companion;", "", "()V", "serialVersionUID", "", "convert", "Lcom/yoti/mobile/android/commons/image/DirectBuffer;", "buffer", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DirectBuffer convert(ImageBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            DirectBuffer directBuffer = buffer instanceof DirectBuffer ? (DirectBuffer) buffer : null;
            return directBuffer == null ? new DirectBuffer(buffer.getWidth(), buffer.getHeight(), buffer.getData()) : directBuffer;
        }
    }

    public DirectBuffer(int i, int i2) {
        this(i, i2, null, 4, null);
    }

    public DirectBuffer(int i, int i2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "rawData");
        this.width = i;
        this.height = i2;
        this.rawData = bArr;
    }

    @JvmStatic
    public static final DirectBuffer convert(ImageBuffer imageBuffer) {
        return INSTANCE.convert(imageBuffer);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArraysKt.copyInto$default(this.rawData, dest, 0, 0, 0, 14, (Object) null);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public byte[] getData() {
        return ImageBuffer.DefaultImpls.getData(this);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public int getWidth() {
        return this.width;
    }

    public /* synthetic */ DirectBuffer(int i, int i2, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? new byte[ImageBuffer.INSTANCE.getRequiredBufferSize(i, i2)] : bArr);
    }
}
