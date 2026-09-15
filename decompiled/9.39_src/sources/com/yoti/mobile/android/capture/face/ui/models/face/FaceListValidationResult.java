package com.yoti.mobile.android.capture.face.ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "", "()V", "FaceDetected", "MultipleFacesDetected", "NoFaceDetected", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$FaceDetected;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FaceListValidationResult {
    public /* synthetic */ FaceListValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NoFaceDetected extends FaceListValidationResult {
        public static final NoFaceDetected INSTANCE = new NoFaceDetected();

        private NoFaceDetected() {
            super(null);
        }
    }

    private FaceListValidationResult() {
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MultipleFacesDetected extends FaceListValidationResult {
        public static final MultipleFacesDetected INSTANCE = new MultipleFacesDetected();

        private MultipleFacesDetected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$FaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceDetected extends FaceListValidationResult {
        public static final FaceDetected INSTANCE = new FaceDetected();

        private FaceDetected() {
            super(null);
        }
    }
}
