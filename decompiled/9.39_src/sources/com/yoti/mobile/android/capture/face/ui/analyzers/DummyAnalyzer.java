package com.yoti.mobile.android.capture.face.ui.analyzers;

import androidx.camera.core.ImageProxy;
import com.yoti.mobile.android.capture.face.ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageAnalyzer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/DummyAnalyzer;", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/ImageAnalyzer;", "()V", "analyze", "", "image", "Landroidx/camera/core/ImageProxy;", "isAnalysing", "", "startAnalysing", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "listener", "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "stopAnalysing", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DummyAnalyzer implements ImageAnalyzer {
    public void analyze(ImageProxy image) {
        Intrinsics.checkNotNullParameter(image, "image");
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public boolean isAnalysing() {
        return false;
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public void stopAnalysing() {
    }
}
