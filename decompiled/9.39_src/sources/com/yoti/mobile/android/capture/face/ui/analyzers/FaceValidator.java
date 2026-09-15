package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Size;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceValidationState;
import com.yoti.mobile.android.capture.face.util.RectStabilityValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceValidator.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002JF\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceValidator;", "", "stabilityValidator", "Lcom/yoti/mobile/android/capture/face/util/RectStabilityValidator;", "scalingHelper", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/ScalingHelper;", "(Lcom/yoti/mobile/android/capture/face/util/RectStabilityValidator;Lcom/yoti/mobile/android/capture/face/ui/analyzers/ScalingHelper;)V", "isFaceNotCentered", "", "boundingBox", "Landroid/graphics/Rect;", "croppedBoundingBox", "faceCenter", "Landroid/graphics/PointF;", "maxResolution", "Landroid/util/Size;", "maxDistance", "", "isFaceNotStable", "imageSize", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "isFaceTooBig", "maxFaceSize", "isFaceTooSmall", "minFaceSize", "validateFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceValidator {
    private final ScalingHelper scalingHelper;
    private final RectStabilityValidator stabilityValidator;

    /* JADX WARN: Multi-variable type inference failed */
    public FaceValidator() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FaceValidator(RectStabilityValidator rectStabilityValidator, ScalingHelper scalingHelper) {
        Intrinsics.checkNotNullParameter(rectStabilityValidator, "stabilityValidator");
        Intrinsics.checkNotNullParameter(scalingHelper, "scalingHelper");
        this.stabilityValidator = rectStabilityValidator;
        this.scalingHelper = scalingHelper;
    }

    public /* synthetic */ FaceValidator(RectStabilityValidator rectStabilityValidator, ScalingHelper scalingHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RectStabilityValidator() : rectStabilityValidator, (i & 2) != 0 ? new ScalingHelper() : scalingHelper);
    }

    public final FaceValidationState validateFace(Rect boundingBox, Rect croppedBoundingBox, PointF faceCenter, Size maxResolution, Size minFaceSize, Size maxFaceSize, int maxDistance, FaceCaptureConfiguration configuration) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        Intrinsics.checkNotNullParameter(croppedBoundingBox, "croppedBoundingBox");
        Intrinsics.checkNotNullParameter(faceCenter, "faceCenter");
        Intrinsics.checkNotNullParameter(maxResolution, "maxResolution");
        Intrinsics.checkNotNullParameter(minFaceSize, "minFaceSize");
        Intrinsics.checkNotNullParameter(maxFaceSize, "maxFaceSize");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (isFaceTooSmall(boundingBox, minFaceSize)) {
            return FaceValidationState.FaceTooSmall.INSTANCE;
        }
        if (isFaceTooBig(boundingBox, maxFaceSize)) {
            return FaceValidationState.FaceTooBig.INSTANCE;
        }
        if (isFaceNotCentered(boundingBox, croppedBoundingBox, faceCenter, maxResolution, maxDistance)) {
            return FaceValidationState.FaceNotCentered.INSTANCE;
        }
        return isFaceNotStable(boundingBox, maxResolution, configuration) ? FaceValidationState.FaceNotStable.INSTANCE : FaceValidationState.ValidFace.INSTANCE;
    }

    private final boolean isFaceTooSmall(Rect boundingBox, Size minFaceSize) {
        return boundingBox.width() < minFaceSize.getWidth() || boundingBox.height() < minFaceSize.getHeight();
    }

    private final boolean isFaceTooBig(Rect boundingBox, Size maxFaceSize) {
        return boundingBox.width() > maxFaceSize.getWidth() || boundingBox.height() > maxFaceSize.getHeight();
    }

    private final boolean isFaceNotCentered(Rect boundingBox, Rect croppedBoundingBox, PointF faceCenter, Size maxResolution, int maxDistance) {
        if (croppedBoundingBox.top < 0 || croppedBoundingBox.bottom > maxResolution.getHeight()) {
            return true;
        }
        double d = 2;
        return ((float) Math.sqrt((double) (((float) Math.pow((double) ((((float) maxResolution.getWidth()) * faceCenter.x) - boundingBox.exactCenterX()), d)) + ((float) Math.pow((double) ((((float) maxResolution.getHeight()) * faceCenter.y) - boundingBox.exactCenterY()), d))))) > ((float) maxDistance) * ScalingHelper.calculateDistanceScaling$default(this.scalingHelper, maxResolution, null, 2, null);
    }

    private final boolean isFaceNotStable(Rect boundingBox, Size imageSize, FaceCaptureConfiguration configuration) {
        return !this.stabilityValidator.isRectStable(boundingBox, imageSize.getWidth(), imageSize.getHeight(), configuration.getRequiredStableFrames());
    }
}
