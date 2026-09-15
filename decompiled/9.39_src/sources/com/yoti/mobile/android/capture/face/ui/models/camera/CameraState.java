package com.yoti.mobile.android.capture.face.ui.models.camera;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraState.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "", "()V", "Analyzing", "CameraInitializationError", "CameraReady", "CameraStopped", "MissingPermissions", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraReady;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraStopped;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$Analyzing;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraInitializationError;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$MissingPermissions;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CameraState {
    public /* synthetic */ CameraState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraReady;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CameraReady extends CameraState {
        public static final CameraReady INSTANCE = new CameraReady();

        private CameraReady() {
            super(null);
        }
    }

    private CameraState() {
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraStopped;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CameraStopped extends CameraState {
        public static final CameraStopped INSTANCE = new CameraStopped();

        private CameraStopped() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$Analyzing;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Analyzing extends CameraState {
        public static final Analyzing INSTANCE = new Analyzing();

        private Analyzing() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraInitializationError;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "cause", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;)V", "getCause", "()Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CameraInitializationError extends CameraState {
        private final CameraError cause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CameraInitializationError(CameraError cameraError) {
            super(null);
            Intrinsics.checkNotNullParameter(cameraError, "cause");
            this.cause = cameraError;
        }

        public final CameraError getCause() {
            return this.cause;
        }
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$MissingPermissions;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MissingPermissions extends CameraState {
        public static final MissingPermissions INSTANCE = new MissingPermissions();

        private MissingPermissions() {
            super(null);
        }
    }
}
