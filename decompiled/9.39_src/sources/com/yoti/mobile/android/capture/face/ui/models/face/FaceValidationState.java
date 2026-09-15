package com.yoti.mobile.android.capture.face.ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceValidationState.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "", "()V", "FaceNotCentered", "FaceNotStable", "FaceTooBig", "FaceTooSmall", "ValidFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotStable;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$ValidFace;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FaceValidationState {
    public /* synthetic */ FaceValidationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceTooSmall extends FaceValidationState {
        public static final FaceTooSmall INSTANCE = new FaceTooSmall();

        private FaceTooSmall() {
            super(null);
        }
    }

    private FaceValidationState() {
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceTooBig extends FaceValidationState {
        public static final FaceTooBig INSTANCE = new FaceTooBig();

        private FaceTooBig() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotCentered extends FaceValidationState {
        public static final FaceNotCentered INSTANCE = new FaceNotCentered();

        private FaceNotCentered() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotStable;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceNotStable extends FaceValidationState {
        public static final FaceNotStable INSTANCE = new FaceNotStable();

        private FaceNotStable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$ValidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ValidFace extends FaceValidationState {
        public static final ValidFace INSTANCE = new ValidFace();

        private ValidFace() {
            super(null);
        }
    }
}
