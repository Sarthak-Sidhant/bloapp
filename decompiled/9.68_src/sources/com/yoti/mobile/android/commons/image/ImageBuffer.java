package com.yoti.mobile.android.commons.image;

import android.graphics.ImageFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: ImageBuffer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "", "height", "", "getHeight", "()I", "width", "getWidth", "fillData", "", "dest", "", "getData", "Companion", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageBuffer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* JADX INFO: compiled from: ImageBuffer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yoti/mobile/android/commons/image/ImageBuffer$Companion;", "", "()V", "getRequiredBufferSize", "", "width", "height", "commons-image_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final int getRequiredBufferSize(int width, int height) {
            return ((width * height) * ImageFormat.getBitsPerPixel(17)) / 8;
        }
    }

    /* JADX INFO: compiled from: ImageBuffer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static byte[] getData(ImageBuffer imageBuffer) {
            byte[] bArr = new byte[ImageBuffer.INSTANCE.getRequiredBufferSize(imageBuffer.getWidth(), imageBuffer.getHeight())];
            imageBuffer.fillData(bArr);
            return bArr;
        }
    }

    @JvmStatic
    static int getRequiredBufferSize(int i, int i2) {
        return INSTANCE.getRequiredBufferSize(i, i2);
    }

    void fillData(byte[] dest);

    byte[] getData();

    int getHeight();

    int getWidth();
}
