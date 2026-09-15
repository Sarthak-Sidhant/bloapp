package com.yoti.mobile.android.core.yuvtools;

import android.graphics.ImageFormat;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Deprecated
public class YuvBuffer implements Serializable {
    public byte[] data;
    public int height;
    public int rotation;
    public int width;

    public YuvBuffer(int i, int i2) {
        this.rotation = 0;
        this.data = new byte[getRequiredBufferSize(i, i2)];
        this.width = i;
        this.height = i2;
    }

    public YuvBuffer(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, 0);
    }

    public YuvBuffer(byte[] bArr, int i, int i2, int i3) {
        this.data = bArr;
        this.width = i;
        this.height = i2;
        this.rotation = i3;
    }

    public static YuvBuffer fromBuffer(ImageBuffer imageBuffer) {
        DirectBuffer directBufferConvert = DirectBuffer.convert(imageBuffer);
        return new YuvBuffer(directBufferConvert.rawData, directBufferConvert.getWidth(), directBufferConvert.getHeight());
    }

    public static int getRequiredBufferSize(int i, int i2) {
        return ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
    }

    public DirectBuffer toBuffer() {
        return new DirectBuffer(this.width, this.height, this.data);
    }
}
