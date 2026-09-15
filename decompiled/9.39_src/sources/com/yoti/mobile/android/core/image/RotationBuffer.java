package com.yoti.mobile.android.core.image;

import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.core.yuvtools.YuvTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0001H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0086\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yoti/mobile/android/core/image/RotationBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "raw", "rotationDegrees", "", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;I)V", "flipDimensions", "", "height", "getHeight", "()I", "width", "getWidth", "component1", "component2", "fillData", "", "dest", "", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RotationBuffer implements ImageBuffer {
    private final ImageBuffer a;
    private final int b;
    private final boolean c;
    private final int d;
    private final int e;

    public RotationBuffer(ImageBuffer imageBuffer, int i) {
        Intrinsics.checkNotNullParameter(imageBuffer, "raw");
        this.a = imageBuffer;
        this.b = i;
        boolean z = i % 180 != 0;
        this.c = z;
        this.d = z ? imageBuffer.getE() : imageBuffer.getD();
        this.e = z ? imageBuffer.getD() : imageBuffer.getE();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageBuffer getA() {
        return this.a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getB() {
        return this.b;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public void fillData(byte[] dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i = this.b;
        if (i == 0) {
            this.a.fillData(dest);
        } else {
            YuvTools.yuvRotate(this.a, dest, i);
        }
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    public byte[] getData() {
        return ImageBuffer.DefaultImpls.getData(this);
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public int getD() {
        return this.d;
    }

    @Override // com.yoti.mobile.android.commons.image.ImageBuffer
    /* JADX INFO: renamed from: getWidth, reason: from getter */
    public int getE() {
        return this.e;
    }
}
