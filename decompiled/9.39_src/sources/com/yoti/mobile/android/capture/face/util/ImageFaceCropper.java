package com.yoti.mobile.android.capture.face.util;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.face.FacialLandmarks;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.core.yuvtools.YuvTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ImageFaceCropper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¨\u0006\u0018"}, d2 = {"Lcom/yoti/mobile/android/capture/face/util/ImageFaceCropper;", "", "()V", "createCropRect", "Landroid/graphics/Rect;", "boundingBox", "maxWidth", "", "encodeImage", "", "imageBuffer", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "getCroppedFacialLandmarks", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "croppedBox", "landmarks", "performCrop", "croppedBoundingBox", "shift", "Landroid/graphics/PointF;", "dx", "dy", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageFaceCropper {
    public final Rect createCropRect(Rect boundingBox, int maxWidth) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        int iRoundToInt = MathKt.roundToInt(boundingBox.height() * FaceCaptureConfiguration.INSTANCE.getCROP_MULTIPLIER_TOP());
        int iRoundToInt2 = MathKt.roundToInt(boundingBox.height() * FaceCaptureConfiguration.INSTANCE.getCROP_MULTIPLIER_BOTTOM());
        Rect rect = new Rect(boundingBox);
        rect.left = 0;
        rect.top -= iRoundToInt;
        rect.right = maxWidth;
        rect.bottom += iRoundToInt2;
        return rect;
    }

    public final FacialLandmarks getCroppedFacialLandmarks(Rect croppedBox, FacialLandmarks landmarks) {
        Intrinsics.checkNotNullParameter(croppedBox, "croppedBox");
        Intrinsics.checkNotNullParameter(landmarks, "landmarks");
        PointF leftEye = landmarks.getLeftEye();
        PointF pointFShift = leftEye != null ? shift(leftEye, croppedBox.left, croppedBox.top) : null;
        PointF rightEye = landmarks.getRightEye();
        PointF pointFShift2 = rightEye != null ? shift(rightEye, croppedBox.left, croppedBox.top) : null;
        PointF noseBase = landmarks.getNoseBase();
        PointF pointFShift3 = noseBase != null ? shift(noseBase, croppedBox.left, croppedBox.top) : null;
        PointF mouthLeft = landmarks.getMouthLeft();
        PointF pointFShift4 = mouthLeft != null ? shift(mouthLeft, croppedBox.left, croppedBox.top) : null;
        PointF mouthRight = landmarks.getMouthRight();
        PointF pointFShift5 = mouthRight != null ? shift(mouthRight, croppedBox.left, croppedBox.top) : null;
        PointF mouthBottom = landmarks.getMouthBottom();
        PointF pointFShift6 = mouthBottom != null ? shift(mouthBottom, croppedBox.left, croppedBox.top) : null;
        PointF leftEar = landmarks.getLeftEar();
        PointF pointFShift7 = leftEar != null ? shift(leftEar, croppedBox.left, croppedBox.top) : null;
        PointF rightEar = landmarks.getRightEar();
        PointF pointFShift8 = rightEar != null ? shift(rightEar, croppedBox.left, croppedBox.top) : null;
        PointF leftCheek = landmarks.getLeftCheek();
        PointF pointFShift9 = leftCheek != null ? shift(leftCheek, croppedBox.left, croppedBox.top) : null;
        PointF rightCheek = landmarks.getRightCheek();
        return new FacialLandmarks(pointFShift, pointFShift2, pointFShift3, pointFShift4, pointFShift5, pointFShift6, pointFShift7, pointFShift8, pointFShift9, rightCheek != null ? shift(rightCheek, croppedBox.left, croppedBox.top) : null);
    }

    public final ImageBuffer performCrop(Rect croppedBoundingBox, ImageBuffer imageBuffer) {
        Intrinsics.checkNotNullParameter(croppedBoundingBox, "croppedBoundingBox");
        Intrinsics.checkNotNullParameter(imageBuffer, "imageBuffer");
        DirectBuffer directBufferYuvCrop = YuvTools.yuvCrop(imageBuffer, new RectF(croppedBoundingBox));
        Intrinsics.checkNotNullExpressionValue(directBufferYuvCrop, "yuvCrop(imageBuffer, RectF(croppedBoundingBox))");
        return directBufferYuvCrop;
    }

    public final byte[] encodeImage(ImageBuffer imageBuffer, FaceCaptureConfiguration configuration) {
        Intrinsics.checkNotNullParameter(imageBuffer, "imageBuffer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return BufferConversion.toJpeg(imageBuffer, configuration.getImageQuality());
    }

    private final PointF shift(PointF pointF, int i, int i2) {
        return new PointF(pointF.x - i, pointF.y - i2);
    }
}
