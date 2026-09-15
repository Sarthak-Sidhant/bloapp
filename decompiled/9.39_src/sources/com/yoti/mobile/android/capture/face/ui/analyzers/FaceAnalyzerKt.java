package com.yoti.mobile.android.capture.face.ui.analyzers;

import androidx.camera.core.ImageProxy;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.image.PlanarStrideBuffer;
import com.yoti.mobile.android.core.image.RotationBufferKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceAnalyzer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", "", "toBufferInternal", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Landroidx/camera/core/ImageProxy;", "face_bundledRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FaceAnalyzerKt {
    private static final String TAG = "FaceAnalyzer";

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageBuffer toBufferInternal(ImageProxy imageProxy) {
        if (imageProxy.getFormat() != 35) {
            throw new IllegalArgumentException(("Invalid image format: " + imageProxy.getFormat()).toString());
        }
        DirectBuffer.Companion companion = DirectBuffer.INSTANCE;
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "planes[0].buffer");
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        ByteBuffer buffer2 = imageProxy.getPlanes()[1].getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer2, "planes[1].buffer");
        ByteBuffer buffer3 = imageProxy.getPlanes()[2].getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer3, "planes[2].buffer");
        return companion.convert(RotationBufferKt.rotateBy(new PlanarStrideBuffer(width, height, buffer, rowStride, pixelStride, buffer2, buffer3, imageProxy.getPlanes()[1].getRowStride(), imageProxy.getPlanes()[1].getPixelStride()), imageProxy.getImageInfo().getRotationDegrees()));
    }
}
