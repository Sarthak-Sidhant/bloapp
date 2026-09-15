package com.yoti.mobile.android.core.yuvtools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class YuvTools {
    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("yuv_tools");
    }

    private static boolean a(int i, int i2, ByteBuffer byteBuffer) {
        return byteBuffer != null && byteBuffer.isDirect() && byteBuffer.capacity() >= (i * i2) * 3;
    }

    @Deprecated
    public static Bitmap convertYuvBufferToBitmap(Context context, YuvBuffer yuvBuffer) {
        return YuvConversionHelper.convertYuvBufferToBitmap(context, yuvBuffer);
    }

    @Deprecated
    public static Bitmap convertYuvBufferToBitmap(YuvBuffer yuvBuffer) {
        return YuvConversionHelper.convertYuvBufferToBitmap(yuvBuffer);
    }

    @Deprecated
    public static ByteBuffer convertYuvToRgb(YuvBuffer yuvBuffer, ByteBuffer byteBuffer) {
        if (a(yuvBuffer.width, yuvBuffer.height, byteBuffer)) {
            byteBuffer.rewind();
        } else {
            byteBuffer = ByteBuffer.allocateDirect(yuvBuffer.height * yuvBuffer.width * 3);
        }
        try {
            yuvToolsConvertToRgb(yuvBuffer.data, byteBuffer, yuvBuffer.width, yuvBuffer.height);
            return byteBuffer;
        } catch (YuvException unused) {
            return null;
        }
    }

    @Deprecated
    public static YuvModel generateYUVFormat(YuvBuffer yuvBuffer) {
        return YuvConversionHelper.generateYUVFormat(yuvBuffer);
    }

    @Deprecated
    public static YuvModel generateYUVFormat(YuvBuffer yuvBuffer, boolean z) {
        return YuvConversionHelper.generateYUVFormat(yuvBuffer, z);
    }

    public static YuvModel generateYUVFormat(byte[] bArr, int i, int i2, boolean z) {
        return YuvConversionHelper.generateYUVFormat(bArr, i, i2, z);
    }

    public static DirectBuffer yuvCrop(ImageBuffer imageBuffer, RectF rectF) {
        DirectBuffer directBufferConvert = DirectBuffer.convert(imageBuffer);
        Rect rect = new Rect();
        rectF.round(rect);
        int i = rect.left;
        if (i % 2 == 1) {
            rect.left = i - 1;
        }
        int i2 = rect.top;
        if (i2 % 2 == 1) {
            rect.top = i2 - 1;
        }
        int i3 = rect.right;
        if (i3 % 2 == 1) {
            rect.right = i3 + 1;
        }
        int i4 = rect.bottom;
        if (i4 % 2 == 1) {
            rect.bottom = i4 + 1;
        }
        DirectBuffer directBuffer = new DirectBuffer(rect.width(), rect.height());
        try {
            yuvToolsCrop(directBufferConvert.rawData, directBuffer.rawData, rect.left, rect.top, rect.width(), rect.height(), directBufferConvert.getF(), directBufferConvert.getG());
            return directBuffer;
        } catch (YuvException unused) {
            return null;
        }
    }

    @Deprecated
    public static YuvBuffer yuvCrop(YuvBuffer yuvBuffer, RectF rectF) {
        DirectBuffer directBufferYuvCrop = yuvCrop(yuvBuffer.toBuffer(), rectF);
        if (directBufferYuvCrop == null) {
            return null;
        }
        return YuvBuffer.fromBuffer(directBufferYuvCrop);
    }

    @Deprecated
    public static YuvBuffer yuvRotate(YuvBuffer yuvBuffer, int i) {
        if (i == 0) {
            return yuvBuffer;
        }
        YuvBuffer yuvBuffer2 = new YuvBuffer(yuvBuffer.width, yuvBuffer.height);
        if (yuvRotate(yuvBuffer, yuvBuffer2, i)) {
            return yuvBuffer2;
        }
        return null;
    }

    public static void yuvRotate(ImageBuffer imageBuffer, byte[] bArr, int i) {
        yuvToolsRotate(imageBuffer.getData(), bArr, i, imageBuffer.getF(), imageBuffer.getG());
    }

    @Deprecated
    public static boolean yuvRotate(YuvBuffer yuvBuffer, YuvBuffer yuvBuffer2, int i) {
        byte[] bArr = yuvBuffer2.data;
        if (bArr == null || bArr.length < yuvBuffer.data.length) {
            yuvBuffer2.data = new byte[yuvBuffer.data.length];
        }
        if (i % 180 == 0) {
            yuvBuffer2.height = yuvBuffer.height;
            yuvBuffer2.width = yuvBuffer.width;
        } else {
            yuvBuffer2.width = yuvBuffer.height;
            yuvBuffer2.height = yuvBuffer.width;
        }
        yuvBuffer2.rotation = (yuvBuffer.rotation - i) % 360;
        try {
            yuvToolsRotate(yuvBuffer.data, yuvBuffer2.data, i, yuvBuffer.width, yuvBuffer.height);
            return true;
        } catch (YuvException unused) {
            return false;
        }
    }

    @Deprecated
    public static YuvBuffer yuvRotateToUpright(YuvBuffer yuvBuffer) {
        return yuvRotate(yuvBuffer, yuvBuffer.rotation);
    }

    @Deprecated
    public static boolean yuvRotateToUpright(YuvBuffer yuvBuffer, YuvBuffer yuvBuffer2) {
        return yuvRotate(yuvBuffer, yuvBuffer2, yuvBuffer.rotation);
    }

    private static native void yuvToolsConvertToRgb(byte[] bArr, ByteBuffer byteBuffer, int i, int i2);

    private static native void yuvToolsCrop(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private static native void yuvToolsRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3);
}
