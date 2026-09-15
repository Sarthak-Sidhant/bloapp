package com.yoti.mobile.android.capture.face.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.common.util.concurrent.ListenableFuture;
import com.yoti.mobile.android.capture.face.databinding.FaceCaptureBinding;
import com.yoti.mobile.android.capture.face.ui.analyzers.DummyAnalyzer;
import com.yoti.mobile.android.capture.face.ui.analyzers.FaceAnalyzer;
import com.yoti.mobile.android.capture.face.ui.analyzers.ImageAnalyzer;
import com.yoti.mobile.android.capture.face.ui.mappers.CameraInitializationErrorMapper;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraState;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraStateListener;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCapture.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0003J\b\u0010,\u001a\u00020#H\u0003J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018J&\u00101\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u00100\u001a\u0004\u0018\u0001022\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007J\u0006\u00103\u001a\u00020#J\b\u00104\u001a\u00020#H\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/FaceCapture;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_cameraState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "binding", "Lcom/yoti/mobile/android/capture/face/databinding/FaceCaptureBinding;", "cameraInitErrorMapper", "Lcom/yoti/mobile/android/capture/face/ui/mappers/CameraInitializationErrorMapper;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "cameraState", "Landroidx/lifecycle/LiveData;", "getCameraState", "()Landroidx/lifecycle/LiveData;", "faceAnalyzer", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/ImageAnalyzer;", "faceCaptureListener", "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "arePermissionsGranted", "", "buildCameraPreview", "Landroidx/camera/core/Preview;", "cameraConfiguration", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraConfiguration;", "buildFaceAnalyzer", "initCamera", "", "cameraProviderFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isAnalysing", "isCameraRunning", "onCameraReady", "onPause", "onResume", "startAnalysing", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "listener", "startCamera", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraStateListener;", "stopAnalysing", "stopCamera", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceCapture extends ConstraintLayout implements LifecycleObserver {
    private final MutableLiveData<CameraState> _cameraState;
    private final FaceCaptureBinding binding;
    private final CameraInitializationErrorMapper cameraInitErrorMapper;
    private ProcessCameraProvider cameraProvider;
    private final LiveData<CameraState> cameraState;
    private final ImageAnalyzer faceAnalyzer;
    private FaceCaptureListener faceCaptureListener;
    private ImageAnalysis imageAnalyzer;

    public final void startCamera(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        startCamera$default(this, lifecycleOwner, null, null, 6, null);
    }

    public final void startCamera(LifecycleOwner lifecycleOwner, CameraStateListener cameraStateListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        startCamera$default(this, lifecycleOwner, cameraStateListener, null, 4, null);
    }

    public /* synthetic */ FaceCapture(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaceCapture(Context context, AttributeSet attributeSet) {
        DummyAnalyzer dummyAnalyzer;
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        FaceCaptureBinding faceCaptureBindingInflate = FaceCaptureBinding.inflate(LayoutInflater.from(context), (ViewGroup) this);
        Intrinsics.checkNotNullExpressionValue(faceCaptureBindingInflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = faceCaptureBindingInflate;
        this.cameraInitErrorMapper = new CameraInitializationErrorMapper();
        if (isInEditMode()) {
            dummyAnalyzer = new DummyAnalyzer();
        } else {
            dummyAnalyzer = new FaceAnalyzer(context, null, null, null, null, 30, null);
        }
        this.faceAnalyzer = dummyAnalyzer;
        LiveData<CameraState> mutableLiveData = new MutableLiveData<>(CameraState.CameraStopped.INSTANCE);
        this._cameraState = mutableLiveData;
        this.cameraState = mutableLiveData;
    }

    public final LiveData<CameraState> getCameraState() {
        return this.cameraState;
    }

    public static /* synthetic */ void startCamera$default(FaceCapture faceCapture, LifecycleOwner lifecycleOwner, CameraStateListener cameraStateListener, CameraConfiguration cameraConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            cameraStateListener = null;
        }
        if ((i & 4) != 0) {
            cameraConfiguration = new CameraConfiguration(null, 1, null);
        }
        faceCapture.startCamera(lifecycleOwner, cameraStateListener, cameraConfiguration);
    }

    public final void startCamera(final LifecycleOwner lifecycleOwner, final CameraStateListener listener, final CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraConfiguration, "cameraConfiguration");
        if (listener != null) {
            this.cameraState.observe(lifecycleOwner, new Observer() { // from class: com.yoti.mobile.android.capture.face.ui.FaceCapture$$ExternalSyntheticLambda0
                public final void onChanged(Object obj) {
                    listener.onCameraState((CameraState) obj);
                }
            });
        }
        if (!arePermissionsGranted()) {
            Log.d("FaceCapture", "Permissions not granted.");
            this._cameraState.setValue(CameraState.MissingPermissions.INSTANCE);
        } else {
            if (isCameraRunning()) {
                Log.d("FaceCapture", "Camera already running.");
                return;
            }
            final ListenableFuture processCameraProvider = ProcessCameraProvider.getInstance(getContext());
            processCameraProvider.addListener(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.FaceCapture$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FaceCapture.m1startCamera$lambda1$lambda0(this.f$0, processCameraProvider, lifecycleOwner, cameraConfiguration);
                }
            }, ContextCompat.getMainExecutor(getContext()));
            lifecycleOwner.getLifecycle().addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startCamera$lambda-1$lambda-0, reason: not valid java name */
    public static final void m1startCamera$lambda1$lambda0(FaceCapture faceCapture, ListenableFuture listenableFuture, LifecycleOwner lifecycleOwner, CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(faceCapture, "this$0");
        Intrinsics.checkNotNullParameter(listenableFuture, "$this_with");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraConfiguration, "$cameraConfiguration");
        faceCapture.initCamera(listenableFuture, lifecycleOwner, cameraConfiguration);
    }

    private final void initCamera(ListenableFuture<ProcessCameraProvider> cameraProviderFuture, LifecycleOwner lifecycleOwner, CameraConfiguration cameraConfiguration) {
        try {
            Object obj = cameraProviderFuture.get();
            ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) obj;
            processCameraProvider.unbindAll();
            Camera cameraBindToLifecycle = processCameraProvider.bindToLifecycle(lifecycleOwner, cameraConfiguration.getFacing().getSelector(), new UseCase[]{(UseCase) buildCameraPreview(cameraConfiguration), (UseCase) buildFaceAnalyzer(cameraConfiguration)});
            Intrinsics.checkNotNullExpressionValue(cameraBindToLifecycle, "bindToLifecycle(\n       …ration)\n                )");
            cameraBindToLifecycle.getCameraControl().setLinearZoom(cameraConfiguration.getFacing().getDefaultZoomLevel());
            this.cameraProvider = (ProcessCameraProvider) obj;
            Log.d("FaceCapture", "Camera running.");
            onCameraReady();
        } catch (Exception e) {
            this._cameraState.setValue(this.cameraInitErrorMapper.invoke(e));
        }
    }

    private final Preview buildCameraPreview(CameraConfiguration cameraConfiguration) {
        Preview previewBuild = new Preview.Builder().setTargetResolution(cameraConfiguration.getTargetResolution()).build();
        previewBuild.setSurfaceProvider(this.binding.cameraPreview.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "Builder()\n            .s…review.surfaceProvider) }");
        return previewBuild;
    }

    private final ImageAnalysis buildFaceAnalyzer(CameraConfiguration cameraConfiguration) {
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).setTargetResolution(cameraConfiguration.getTargetResolution()).build();
        imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), this.faceAnalyzer);
        this.imageAnalyzer = imageAnalysisBuild;
        Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "Builder()\n            .s…alyzer = it\n            }");
        return imageAnalysisBuild;
    }

    public final void stopCamera() {
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        this.cameraProvider = null;
        Log.d("FaceCapture", "Camera stopped.");
        this._cameraState.setValue(CameraState.CameraStopped.INSTANCE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (isCameraRunning()) {
            onCameraReady();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        if (isCameraRunning()) {
            this._cameraState.setValue(CameraState.CameraStopped.INSTANCE);
        }
    }

    public final void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.faceCaptureListener = listener;
        this.faceAnalyzer.startAnalysing(configuration, listener);
        if (isCameraRunning()) {
            this._cameraState.setValue(CameraState.Analyzing.INSTANCE);
        }
    }

    public final void stopAnalysing() {
        this.faceAnalyzer.stopAnalysing();
        if (Intrinsics.areEqual(this.cameraState.getValue(), CameraState.Analyzing.INSTANCE)) {
            this._cameraState.setValue(CameraState.CameraReady.INSTANCE);
        }
    }

    private final void onCameraReady() {
        if (isAnalysing()) {
            this._cameraState.setValue(CameraState.Analyzing.INSTANCE);
        } else {
            this._cameraState.setValue(CameraState.CameraReady.INSTANCE);
        }
    }

    private final boolean arePermissionsGranted() {
        for (String str : FaceCaptureConfiguration.INSTANCE.getREQUIRED_PERMISSIONS()) {
            if (ContextCompat.checkSelfPermission(getContext(), str) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isCameraRunning() {
        return this.cameraProvider != null;
    }

    public final boolean isAnalysing() {
        return this.faceAnalyzer.isAnalysing();
    }
}
