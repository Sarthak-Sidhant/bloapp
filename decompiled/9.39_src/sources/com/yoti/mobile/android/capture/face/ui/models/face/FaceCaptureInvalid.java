package com.yoti.mobile.android.capture.face.ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceCaptureResult.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "", "()V", "AnalysisError", "EnvironmentTooDark", "EyesClosed", "FaceNotCentered", "FaceNotStable", "FaceNotStraight", "FaceTooBig", "FaceTooSmall", "MultipleFacesDetected", "NoFaceDetected", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$AnalysisError;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$EnvironmentTooDark;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$EyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotStable;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FaceCaptureInvalid {
    public /* synthetic */ FaceCaptureInvalid(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$AnalysisError;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnalysisError extends FaceCaptureInvalid {
        public static final AnalysisError INSTANCE = new AnalysisError();

        private AnalysisError() {
            super(null);
        }
    }

    private FaceCaptureInvalid() {
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NoFaceDetected extends FaceCaptureInvalid {
        public static final NoFaceDetected INSTANCE = new NoFaceDetected();

        private NoFaceDetected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MultipleFacesDetected extends FaceCaptureInvalid {
        public static final MultipleFacesDetected INSTANCE = new MultipleFacesDetected();

        private MultipleFacesDetected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceTooSmall extends FaceCaptureInvalid {
        public static final FaceTooSmall INSTANCE = new FaceTooSmall();

        private FaceTooSmall() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceTooBig extends FaceCaptureInvalid {
        public static final FaceTooBig INSTANCE = new FaceTooBig();

        private FaceTooBig() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotCentered extends FaceCaptureInvalid {
        public static final FaceNotCentered INSTANCE = new FaceNotCentered();

        private FaceNotCentered() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$EnvironmentTooDark;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EnvironmentTooDark extends FaceCaptureInvalid {
        public static final EnvironmentTooDark INSTANCE = new EnvironmentTooDark();

        private EnvironmentTooDark() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotStraight extends FaceCaptureInvalid {
        public static final FaceNotStraight INSTANCE = new FaceNotStraight();

        private FaceNotStraight() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$EyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EyesClosed extends FaceCaptureInvalid {
        public static final EyesClosed INSTANCE = new EyesClosed();

        private EyesClosed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid$FaceNotStable;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotStable extends FaceCaptureInvalid {
        public static final FaceNotStable INSTANCE = new FaceNotStable();

        private FaceNotStable() {
            super(null);
        }
    }
}
