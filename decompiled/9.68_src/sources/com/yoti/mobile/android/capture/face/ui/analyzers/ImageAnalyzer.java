package com.yoti.mobile.android.capture.face.ui.analyzers;

import androidx.camera.core.ImageAnalysis;
import com.yoti.mobile.android.capture.face.ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageAnalyzer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/ImageAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "isAnalysing", "", "startAnalysing", "", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "listener", "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "stopAnalysing", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageAnalyzer extends ImageAnalysis.Analyzer {
    boolean isAnalysing();

    void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener);

    void stopAnalysing();
}
