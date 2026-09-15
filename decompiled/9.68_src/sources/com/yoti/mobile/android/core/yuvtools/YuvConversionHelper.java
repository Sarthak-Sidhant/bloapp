package com.yoti.mobile.android.core.yuvtools;

import android.content.Context;
import android.graphics.Bitmap;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.util.CompatHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class YuvConversionHelper {
    private static byte[] a(byte[] bArr, int i, int i2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr, i, i2);
                    gZIPOutputStream2.close();
                } catch (IOException unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static YuvModel b(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        for (int i4 = 0; i4 < i3 / 4; i4++) {
            int i5 = (i4 * 2) + i3;
            byte b = bArr[i5];
            int i6 = i5 + 1;
            bArr[i5] = bArr[i6];
            bArr[i6] = b;
        }
        return new YuvModel("YOTI_YUV", a(bArr, 0, i3), a(bArr, i3, i3 / 2), i2, i);
    }

    @Deprecated
    public static Bitmap convertYuvBufferToBitmap(Context context, YuvBuffer yuvBuffer) {
        return CompatHelper.convertYuvImageToBitmap(context, yuvBuffer.data, yuvBuffer.width, yuvBuffer.height);
    }

    @Deprecated
    public static Bitmap convertYuvBufferToBitmap(YuvBuffer yuvBuffer) {
        return convertYuvBufferToBitmap(null, yuvBuffer);
    }

    public static YuvModel generateYUVFormat(ImageBuffer imageBuffer) {
        return generateYUVFormat(imageBuffer.getData(), imageBuffer.getWidth(), imageBuffer.getHeight(), false);
    }

    @Deprecated
    public static YuvModel generateYUVFormat(YuvBuffer yuvBuffer) {
        return generateYUVFormat(yuvBuffer.data, yuvBuffer.width, yuvBuffer.height, true);
    }

    @Deprecated
    public static YuvModel generateYUVFormat(YuvBuffer yuvBuffer, boolean z) {
        return generateYUVFormat(yuvBuffer.data, yuvBuffer.width, yuvBuffer.height, z);
    }

    public static YuvModel generateYUVFormat(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr = bArr2;
        }
        return b(bArr, i, i2);
    }
}
