package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.content.Context;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import com.yoti.mobile.android.capture.face.ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.ui.mappers.FaceCaptureResultMapper;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureInvalid;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureState;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceAnalyzer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0003J\u001e\u0010\u001f\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceAnalyzer;", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/ImageAnalyzer;", "context", "Landroid/content/Context;", "luminosityValidator", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/LuminosityValidator;", "faceDetector", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;", "faceResultMapper", "Lcom/yoti/mobile/android/capture/face/ui/mappers/FaceCaptureResultMapper;", "mainHandler", "Landroid/os/Handler;", "(Landroid/content/Context;Lcom/yoti/mobile/android/capture/face/ui/analyzers/LuminosityValidator;Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;Lcom/yoti/mobile/android/capture/face/ui/mappers/FaceCaptureResultMapper;Landroid/os/Handler;)V", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "listener", "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "isAnalysing", "", "onCaptureResult", "result", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "onFailure", "exception", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionError;", "buffer", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "onSuccess", "faces", "", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "startAnalysing", "stopAnalysing", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceAnalyzer implements ImageAnalyzer {
    private FaceCaptureConfiguration configuration;
    private final IFaceDetection faceDetector;
    private final FaceCaptureResultMapper faceResultMapper;
    private FaceCaptureListener listener;
    private final LuminosityValidator luminosityValidator;
    private final Handler mainHandler;

    public FaceAnalyzer(Context context, LuminosityValidator luminosityValidator, IFaceDetection iFaceDetection, FaceCaptureResultMapper faceCaptureResultMapper, Handler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(luminosityValidator, "luminosityValidator");
        Intrinsics.checkNotNullParameter(iFaceDetection, "faceDetector");
        Intrinsics.checkNotNullParameter(faceCaptureResultMapper, "faceResultMapper");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        this.luminosityValidator = luminosityValidator;
        this.faceDetector = iFaceDetection;
        this.faceResultMapper = faceCaptureResultMapper;
        this.mainHandler = handler;
        this.configuration = new FaceCaptureConfiguration(null, null, false, false, false, 0, false, false, 255, null);
    }

    public /* synthetic */ FaceAnalyzer(Context context, LuminosityValidator luminosityValidator, IFaceDetection iFaceDetection, FaceCaptureResultMapper faceCaptureResultMapper, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new LuminosityValidator(context) : luminosityValidator, (i & 4) != 0 ? new MlkitFaceDetection(null, 1, null) : iFaceDetection, (i & 8) != 0 ? new FaceCaptureResultMapper(null, null, null, 7, null) : faceCaptureResultMapper, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public void analyze(ImageProxy imageProxy) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image != null) {
            try {
                ImageBuffer bufferInternal = FaceAnalyzerKt.toBufferInternal(imageProxy);
                Either<FaceDetectionError, List<FaceResult>> eitherAnalyse = this.faceDetector.analyse(image, imageProxy.getImageInfo().getRotationDegrees());
                if (eitherAnalyse instanceof Either.Failure) {
                    onFailure((FaceDetectionError) ((Either.Failure) eitherAnalyse).getFailResult(), bufferInternal);
                } else if (eitherAnalyse instanceof Either.Success) {
                    onSuccess((List) ((Either.Success) eitherAnalyse).getSuccessResult(), bufferInternal);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (UnsatisfiedLinkError unused) {
                onFailure$default(this, FaceDetectionError.UNKNOWN, null, 2, null);
            }
        }
        imageProxy.close();
    }

    private final void onSuccess(List<FaceResult> faces, ImageBuffer buffer) {
        if (this.configuration.getRequireBrightEnvironment() && !this.luminosityValidator.isValid()) {
            onCaptureResult(new FaceCaptureResult(buffer, new FaceCaptureState.InvalidFace(FaceCaptureInvalid.EnvironmentTooDark.INSTANCE)));
        } else {
            onCaptureResult(this.faceResultMapper.mapDetectionResult(buffer, faces, this.configuration));
        }
    }

    private final void onCaptureResult(final FaceCaptureResult result) {
        this.mainHandler.post(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.analyzers.FaceAnalyzer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FaceAnalyzer.m2onCaptureResult$lambda3(this.f$0, result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCaptureResult$lambda-3, reason: not valid java name */
    public static final void m2onCaptureResult$lambda3(FaceAnalyzer faceAnalyzer, FaceCaptureResult faceCaptureResult) {
        Intrinsics.checkNotNullParameter(faceAnalyzer, "this$0");
        Intrinsics.checkNotNullParameter(faceCaptureResult, "$result");
        FaceCaptureListener faceCaptureListener = faceAnalyzer.listener;
        if (faceCaptureListener != null) {
            faceCaptureListener.onFaceCaptureResult(faceCaptureResult);
        }
    }

    static /* synthetic */ void onFailure$default(FaceAnalyzer faceAnalyzer, FaceDetectionError faceDetectionError, ImageBuffer imageBuffer, int i, Object obj) {
        if ((i & 2) != 0) {
            imageBuffer = null;
        }
        faceAnalyzer.onFailure(faceDetectionError, imageBuffer);
    }

    private final void onFailure(FaceDetectionError exception, ImageBuffer buffer) {
        Log.e("FaceAnalyzer", "Face detection failure: " + exception);
        final FaceCaptureResult faceCaptureResultMapError = this.faceResultMapper.mapError(buffer);
        this.mainHandler.post(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.analyzers.FaceAnalyzer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FaceAnalyzer.m3onFailure$lambda4(this.f$0, faceCaptureResultMapError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onFailure$lambda-4, reason: not valid java name */
    public static final void m3onFailure$lambda4(FaceAnalyzer faceAnalyzer, FaceCaptureResult faceCaptureResult) {
        Intrinsics.checkNotNullParameter(faceAnalyzer, "this$0");
        Intrinsics.checkNotNullParameter(faceCaptureResult, "$result");
        FaceCaptureListener faceCaptureListener = faceAnalyzer.listener;
        if (faceCaptureListener != null) {
            faceCaptureListener.onFaceCaptureResult(faceCaptureResult);
        }
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Log.d("FaceAnalyzer", "Started analyzing. ImageQuality=[" + configuration.getImageQuality() + ']');
        this.configuration = configuration;
        this.listener = listener;
        if (configuration.getRequireBrightEnvironment()) {
            this.luminosityValidator.start();
        }
        this.faceDetector.onConfigChanged(configuration);
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public void stopAnalysing() {
        Log.d("FaceAnalyzer", "Stopped analyzing.");
        if (this.configuration.getRequireBrightEnvironment()) {
            this.luminosityValidator.stop();
        }
        this.listener = null;
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer
    public boolean isAnalysing() {
        return this.listener != null;
    }
}
