package com.yoti.mobile.android.capture.face.ui.models.camera;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraState.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "IllegalState", "UnableToResolveCamera", "Unknown", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$IllegalState;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$UnableToResolveCamera;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$Unknown;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CameraError extends Exception {
    public /* synthetic */ CameraError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$IllegalState;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IllegalState extends CameraError {
        public static final IllegalState INSTANCE = new IllegalState();

        private IllegalState() {
            super(null);
        }
    }

    private CameraError() {
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$UnableToResolveCamera;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnableToResolveCamera extends CameraError {
        public static final UnableToResolveCamera INSTANCE = new UnableToResolveCamera();

        private UnableToResolveCamera() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CameraState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError$Unknown;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "()V", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unknown extends CameraError {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }
}
