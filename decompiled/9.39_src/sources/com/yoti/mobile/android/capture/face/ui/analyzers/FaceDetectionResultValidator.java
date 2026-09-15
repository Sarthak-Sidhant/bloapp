package com.yoti.mobile.android.capture.face.ui.analyzers;

import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceListValidationResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceValidationResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceDetectionResultValidator.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¨\u0006\u0012"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionResultValidator;", "", "()V", "areEyesClosed", "", "face", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "areMultipleFacesDetected", "faces", "", "isAngleInvalid", "isNoFaceDetected", "validateFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "validateFaceList", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceDetectionResultValidator {
    public final FaceListValidationResult validateFaceList(List<FaceResult> faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        if (isNoFaceDetected(faces)) {
            return FaceListValidationResult.NoFaceDetected.INSTANCE;
        }
        return areMultipleFacesDetected(faces) ? FaceListValidationResult.MultipleFacesDetected.INSTANCE : FaceListValidationResult.FaceDetected.INSTANCE;
    }

    private final boolean isNoFaceDetected(List<FaceResult> faces) {
        List<FaceResult> list = faces;
        return list == null || list.isEmpty();
    }

    private final boolean areMultipleFacesDetected(List<FaceResult> faces) {
        return faces.size() > 1;
    }

    public final FaceValidationResult validateFace(FaceResult face, FaceCaptureConfiguration configuration) {
        Intrinsics.checkNotNullParameter(face, "face");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (isAngleInvalid(face, configuration)) {
            return FaceValidationResult.FaceNotStraight.INSTANCE;
        }
        return areEyesClosed(face, configuration) ? FaceValidationResult.FaceEyesClosed.INSTANCE : FaceValidationResult.FaceValid.INSTANCE;
    }

    private final boolean isAngleInvalid(FaceResult face, FaceCaptureConfiguration configuration) {
        return configuration.getRequireValidAngle() && face.getInvalidAngle();
    }

    private final boolean areEyesClosed(FaceResult face, FaceCaptureConfiguration configuration) {
        return configuration.getRequireEyesOpen() && face.getEyesClosed();
    }
}
