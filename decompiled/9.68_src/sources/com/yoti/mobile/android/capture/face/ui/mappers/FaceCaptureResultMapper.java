package com.yoti.mobile.android.capture.face.ui.mappers;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Size;
import com.yoti.mobile.android.capture.face.ui.analyzers.FaceDetectionResultValidator;
import com.yoti.mobile.android.capture.face.ui.analyzers.FaceResult;
import com.yoti.mobile.android.capture.face.ui.analyzers.FaceValidator;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureInvalid;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureState;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceListValidationResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceValidationResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceValidationState;
import com.yoti.mobile.android.capture.face.ui.models.face.FacialLandmarks;
import com.yoti.mobile.android.capture.face.util.ImageFaceCropper;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureResultMapper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ&\u0010\u0013\u001a\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/mappers/FaceCaptureResultMapper;", "", "faceValidator", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceValidator;", "faceDetectionResultValidator", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionResultValidator;", "faceCropper", "Lcom/yoti/mobile/android/capture/face/util/ImageFaceCropper;", "(Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceValidator;Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionResultValidator;Lcom/yoti/mobile/android/capture/face/util/ImageFaceCropper;)V", "mapDetectionResult", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "originalImage", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "faces", "", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "mapError", "mapFaceState", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "imageBuffer", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceCaptureResultMapper {
    private final ImageFaceCropper faceCropper;
    private final FaceDetectionResultValidator faceDetectionResultValidator;
    private final FaceValidator faceValidator;

    public FaceCaptureResultMapper() {
        this(null, null, null, 7, null);
    }

    public FaceCaptureResultMapper(FaceValidator faceValidator, FaceDetectionResultValidator faceDetectionResultValidator, ImageFaceCropper faceCropper) {
        Intrinsics.checkNotNullParameter(faceValidator, "faceValidator");
        Intrinsics.checkNotNullParameter(faceDetectionResultValidator, "faceDetectionResultValidator");
        Intrinsics.checkNotNullParameter(faceCropper, "faceCropper");
        this.faceValidator = faceValidator;
        this.faceDetectionResultValidator = faceDetectionResultValidator;
        this.faceCropper = faceCropper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FaceCaptureResultMapper(FaceValidator faceValidator, FaceDetectionResultValidator faceDetectionResultValidator, ImageFaceCropper imageFaceCropper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            faceValidator = new FaceValidator(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        this(faceValidator, (i & 2) != 0 ? new FaceDetectionResultValidator() : faceDetectionResultValidator, (i & 4) != 0 ? new ImageFaceCropper() : imageFaceCropper);
    }

    public final FaceCaptureResult mapDetectionResult(ImageBuffer originalImage, List<FaceResult> faces, FaceCaptureConfiguration configuration) {
        Intrinsics.checkNotNullParameter(originalImage, "originalImage");
        Intrinsics.checkNotNullParameter(faces, "faces");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new FaceCaptureResult(originalImage, mapFaceState(faces, originalImage, configuration));
    }

    public final FaceCaptureResult mapError(ImageBuffer originalImage) {
        return new FaceCaptureResult(originalImage, new FaceCaptureState.InvalidFace(FaceCaptureInvalid.AnalysisError.INSTANCE));
    }

    private final FaceCaptureState mapFaceState(List<FaceResult> faces, ImageBuffer imageBuffer, FaceCaptureConfiguration configuration) {
        FaceListValidationResult faceListValidationResultValidateFaceList = this.faceDetectionResultValidator.validateFaceList(faces);
        if (Intrinsics.areEqual(faceListValidationResultValidateFaceList, FaceListValidationResult.NoFaceDetected.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.NoFaceDetected.INSTANCE);
        }
        if (Intrinsics.areEqual(faceListValidationResultValidateFaceList, FaceListValidationResult.MultipleFacesDetected.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.MultipleFacesDetected.INSTANCE);
        }
        Intrinsics.areEqual(faceListValidationResultValidateFaceList, FaceListValidationResult.FaceDetected.INSTANCE);
        Size size = new Size(imageBuffer.getF(), imageBuffer.getG());
        PointF faceCenter = configuration.getFaceCenter();
        Rect boundingBox = ((FaceResult) CollectionsKt.first((List) faces)).getBoundingBox();
        Rect rectCreateCropRect = this.faceCropper.createCropRect(boundingBox, imageBuffer.getF());
        FacialLandmarks facialLandmarks = ((FaceResult) CollectionsKt.first((List) faces)).getFacialLandmarks();
        FacialLandmarks croppedFacialLandmarks = this.faceCropper.getCroppedFacialLandmarks(rectCreateCropRect, facialLandmarks);
        FaceValidationState faceValidationStateValidateFace = this.faceValidator.validateFace(boundingBox, rectCreateCropRect, faceCenter, size, FaceCaptureConfiguration.INSTANCE.getMIN_FACE_SIZE(), FaceCaptureConfiguration.INSTANCE.getMAX_FACE_SIZE(), FaceCaptureConfiguration.INSTANCE.getMAX_CENTER_DISTANCE(), configuration);
        if (Intrinsics.areEqual(faceValidationStateValidateFace, FaceValidationState.FaceTooSmall.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.FaceTooSmall.INSTANCE);
        }
        if (Intrinsics.areEqual(faceValidationStateValidateFace, FaceValidationState.FaceTooBig.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.FaceTooBig.INSTANCE);
        }
        if (Intrinsics.areEqual(faceValidationStateValidateFace, FaceValidationState.FaceNotCentered.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.FaceNotCentered.INSTANCE);
        }
        if (Intrinsics.areEqual(faceValidationStateValidateFace, FaceValidationState.FaceNotStable.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.FaceNotStable.INSTANCE);
        }
        Intrinsics.areEqual(faceValidationStateValidateFace, FaceValidationState.ValidFace.INSTANCE);
        FaceValidationResult faceValidationResultValidateFace = this.faceDetectionResultValidator.validateFace((FaceResult) CollectionsKt.first((List) faces), configuration);
        if (Intrinsics.areEqual(faceValidationResultValidateFace, FaceValidationResult.FaceNotStraight.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.FaceNotStraight.INSTANCE);
        }
        if (Intrinsics.areEqual(faceValidationResultValidateFace, FaceValidationResult.FaceEyesClosed.INSTANCE)) {
            return new FaceCaptureState.InvalidFace(FaceCaptureInvalid.EyesClosed.INSTANCE);
        }
        if (!Intrinsics.areEqual(faceValidationResultValidateFace, FaceValidationResult.FaceValid.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        ImageFaceCropper imageFaceCropper = this.faceCropper;
        return new FaceCaptureState.ValidFace(imageFaceCropper.encodeImage(imageFaceCropper.performCrop(rectCreateCropRect, imageBuffer), configuration), rectCreateCropRect, boundingBox, facialLandmarks, croppedFacialLandmarks, configuration.getProvideSmileScore() ? ((FaceResult) CollectionsKt.first((List) faces)).getSmileScore() : null);
    }
}
