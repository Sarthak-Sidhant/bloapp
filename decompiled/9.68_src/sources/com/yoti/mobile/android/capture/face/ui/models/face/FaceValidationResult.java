package com.yoti.mobile.android.capture.face.ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "", "()V", "FaceEyesClosed", "FaceNotStraight", "FaceValid", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceEyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceValid;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FaceValidationResult {
    public /* synthetic */ FaceValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotStraight extends FaceValidationResult {
        public static final FaceNotStraight INSTANCE = new FaceNotStraight();

        private FaceNotStraight() {
            super(null);
        }
    }

    private FaceValidationResult() {
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceEyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceEyesClosed extends FaceValidationResult {
        public static final FaceEyesClosed INSTANCE = new FaceEyesClosed();

        private FaceEyesClosed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceValid;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceValid extends FaceValidationResult {
        public static final FaceValid INSTANCE = new FaceValid();

        private FaceValid() {
            super(null);
        }
    }
}
