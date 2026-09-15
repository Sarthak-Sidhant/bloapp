package in.gov.eci.bloapp.views.activity.frs;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CaptureRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.yoti.mobile.android.capture.face.ui.FaceCapture;
import com.yoti.mobile.android.capture.face.ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraConfiguration;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraError;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraFacing;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraState;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraStateListener;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureInvalid;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureState;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.ActivityManualFaceCaptureBinding;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: ManualFaceCaptureActivity.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0012\u0010)\u001a\u00020\u00172\b\b\u0001\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010*\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020;H\u0002J\u0010\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020;H\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010;2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020;H\u0002J\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00106\u001a\u0002072\u0006\u0010F\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u00102\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000f¨\u0006G"}, d2 = {"Lin/gov/eci/bloapp/views/activity/frs/ManualFaceCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lin/gov/eci/bloapp/databinding/ActivityManualFaceCaptureBinding;", "isManualCaptureButtonClicked", "", "TAG", "", "temp", "garudaTextBaseActivity", "getGarudaTextBaseActivity", "()Ljava/lang/String;", "setGarudaTextBaseActivity", "(Ljava/lang/String;)V", "jpgTextBaseActivity", "getJpgTextBaseActivity", "setJpgTextBaseActivity", "imageTextBaseActivity", "getImageTextBaseActivity", "setImageTextBaseActivity", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onFaceCaptureResult", "result", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "handleValidFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "handleInvalidFace", "cause", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "setValidImageAsResult", "image", "", "startCamera", "stopAnalyzing", "logState", "state", "", "clearState", "onCameraState", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "handleCameraInitError", "error", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraError;", "g_file_uri", "getG_file_uri", "setG_file_uri", "saveBitmapImage", "bitmap", "Landroid/graphics/Bitmap;", "disableAutoFocusOnYotiCamera", "tryDisableAfOnObject", "obj", "", "setAfOffOnBuilderIfPossible", "builderObj", "setAfOffOnCameraDeviceIfPossible", "camDevObj", "tryInvokeMethodReturning", "method", "Ljava/lang/reflect/Method;", "target", "getSaveImagePath", "Landroid/net/Uri;", "code", "app_prodRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualFaceCaptureActivity extends AppCompatActivity {
    private ActivityManualFaceCaptureBinding binding;
    private String g_file_uri;
    private boolean isManualCaptureButtonClicked;
    private String TAG = "FaceCapture";
    private String temp = "";
    private String garudaTextBaseActivity = "GARUDA";
    private String jpgTextBaseActivity = ".jpg";
    private String imageTextBaseActivity = "image";

    public final String getGarudaTextBaseActivity() {
        return this.garudaTextBaseActivity;
    }

    public final void setGarudaTextBaseActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.garudaTextBaseActivity = str;
    }

    public final String getJpgTextBaseActivity() {
        return this.jpgTextBaseActivity;
    }

    public final void setJpgTextBaseActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jpgTextBaseActivity = str;
    }

    public final String getImageTextBaseActivity() {
        return this.imageTextBaseActivity;
    }

    public final void setImageTextBaseActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageTextBaseActivity = str;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBindingInflate = ActivityManualFaceCaptureBinding.inflate(getLayoutInflater());
        this.binding = activityManualFaceCaptureBindingInflate;
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = null;
        if (activityManualFaceCaptureBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBindingInflate = null;
        }
        setContentView((View) activityManualFaceCaptureBindingInflate.getRoot());
        this.temp = String.valueOf(getIntent().getStringExtra("temp"));
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding2 = this.binding;
        if (activityManualFaceCaptureBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityManualFaceCaptureBinding = activityManualFaceCaptureBinding2;
        }
        activityManualFaceCaptureBinding.manualCaptureButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.isManualCaptureButtonClicked = true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        clearState();
        startCamera();
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        activityManualFaceCaptureBinding.faceCaptureView.startAnalysing(DefaultConfigurationKt.getFaceCaptureConfiguration(), new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: ManualFaceCaptureActivity.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 implements FaceCaptureListener, FunctionAdapter {
        AnonymousClass1() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FaceCaptureListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl<>(1, ManualFaceCaptureActivity.this, ManualFaceCaptureActivity.class, "onFaceCaptureResult", "onFaceCaptureResult(Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        @Override // com.yoti.mobile.android.capture.face.ui.FaceCaptureListener
        public final void onFaceCaptureResult(FaceCaptureResult faceCaptureResult) throws NoWhenBranchMatchedException {
            Intrinsics.checkNotNullParameter(faceCaptureResult, "p0");
            ManualFaceCaptureActivity.this.onFaceCaptureResult(faceCaptureResult);
        }
    }

    protected void onPause() {
        stopAnalyzing();
        clearState();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onFaceCaptureResult(FaceCaptureResult result) throws NoWhenBranchMatchedException {
        FaceCaptureState state = result.getState();
        if (state instanceof FaceCaptureState.InvalidFace) {
            handleInvalidFace(((FaceCaptureState.InvalidFace) state).getCause());
        } else {
            if (!(state instanceof FaceCaptureState.ValidFace)) {
                throw new NoWhenBranchMatchedException();
            }
            handleValidFace((FaceCaptureState.ValidFace) state);
        }
    }

    private final void handleValidFace(FaceCaptureState.ValidFace result) {
        logState(R.string.yoti_fcm_demo_result_valid_face);
        setValidImageAsResult(result.getCroppedImage());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void handleInvalidFace(FaceCaptureInvalid cause) throws NoWhenBranchMatchedException {
        int i;
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        Button button = activityManualFaceCaptureBinding.manualCaptureButton;
        Intrinsics.checkNotNullExpressionValue(button, "manualCaptureButton");
        button.setVisibility(4);
        this.isManualCaptureButtonClicked = false;
        if (cause instanceof FaceCaptureInvalid.AnalysisError) {
            i = R.string.yoti_fcm_demo_result_error_analysis;
        } else if (cause instanceof FaceCaptureInvalid.NoFaceDetected) {
            i = R.string.yoti_fcm_demo_result_error_no_face_detected;
        } else if (cause instanceof FaceCaptureInvalid.MultipleFacesDetected) {
            i = R.string.yoti_fcm_demo_result_error_multiple_faces;
        } else if (cause instanceof FaceCaptureInvalid.FaceTooBig) {
            i = R.string.yoti_fcm_demo_result_error_too_big;
        } else if (cause instanceof FaceCaptureInvalid.FaceTooSmall) {
            i = R.string.yoti_fcm_demo_result_error_too_small;
        } else if (cause instanceof FaceCaptureInvalid.FaceNotCentered) {
            i = R.string.yoti_fcm_demo_result_error_not_centered;
        } else if (cause instanceof FaceCaptureInvalid.FaceNotStraight) {
            i = R.string.yoti_fcm_demo_result_error_bad_angle;
        } else if (cause instanceof FaceCaptureInvalid.EyesClosed) {
            i = R.string.yoti_fcm_demo_result_error_eyes_closed;
        } else if (cause instanceof FaceCaptureInvalid.FaceNotStable) {
            i = R.string.yoti_fcm_demo_result_error_not_stable;
        } else {
            if (!(cause instanceof FaceCaptureInvalid.EnvironmentTooDark)) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.yoti_fcm_demo_result_error_too_dark;
        }
        logState(i);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity$setValidImageAsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ManualFaceCaptureActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity$setValidImageAsResult$1", f = "ManualFaceCaptureActivity.kt", i = {}, l = {128, 129}, m = "invokeSuspend", n = {}, s = {})
    static final class C00441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $image;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00441(byte[] bArr, Continuation<? super C00441> continuation) {
            super(2, continuation);
            this.$image = bArr;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ManualFaceCaptureActivity.this.new C00441(this.$image, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) throws IOException {
            ImageView imageView;
            ManualFaceCaptureActivity manualFaceCaptureActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    imageView = (ImageView) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    manualFaceCaptureActivity = (ManualFaceCaptureActivity) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Uri saveImagePath = manualFaceCaptureActivity.getSaveImagePath((Bitmap) obj, ManualFaceCaptureActivity.this.temp);
                Intent intent = new Intent();
                Log.e("g_file_uri", String.valueOf(saveImagePath));
                intent.putExtra("file_uri", String.valueOf(saveImagePath));
                ManualFaceCaptureActivity.this.setResult(-1, intent);
                ManualFaceCaptureActivity.this.finish();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = ManualFaceCaptureActivity.this.binding;
            if (activityManualFaceCaptureBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityManualFaceCaptureBinding = null;
            }
            imageView = activityManualFaceCaptureBinding.captureResult;
            this.L$0 = imageView;
            this.label = 1;
            obj = new ByteArrayToBitmapConverter((CoroutineDispatcher) null, 1, (DefaultConstructorMarker) null).convert(this.$image, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            imageView.setImageBitmap((Bitmap) obj);
            ManualFaceCaptureActivity manualFaceCaptureActivity2 = ManualFaceCaptureActivity.this;
            this.L$0 = manualFaceCaptureActivity2;
            this.label = 2;
            Object objConvert = new ByteArrayToBitmapConverter((CoroutineDispatcher) null, 1, (DefaultConstructorMarker) null).convert(this.$image, (Continuation) this);
            if (objConvert == coroutine_suspended) {
                return coroutine_suspended;
            }
            manualFaceCaptureActivity = manualFaceCaptureActivity2;
            obj = objConvert;
            Uri saveImagePath2 = manualFaceCaptureActivity.getSaveImagePath((Bitmap) obj, ManualFaceCaptureActivity.this.temp);
            Intent intent2 = new Intent();
            Log.e("g_file_uri", String.valueOf(saveImagePath2));
            intent2.putExtra("file_uri", String.valueOf(saveImagePath2));
            ManualFaceCaptureActivity.this.setResult(-1, intent2);
            ManualFaceCaptureActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    private final void setValidImageAsResult(byte[] image) {
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new C00441(image, null), 3, (Object) null);
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding2 = this.binding;
        if (activityManualFaceCaptureBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityManualFaceCaptureBinding = activityManualFaceCaptureBinding2;
        }
        Button button = activityManualFaceCaptureBinding.manualCaptureButton;
        Intrinsics.checkNotNullExpressionValue(button, "manualCaptureButton");
        button.setVisibility(4);
        stopAnalyzing();
        clearState();
    }

    private final void startCamera() {
        CameraConfiguration cameraConfiguration;
        if (String.valueOf(getIntent().getStringExtra("camera_type_configuration")).equals("back")) {
            cameraConfiguration = new CameraConfiguration(CameraFacing.BACK);
        } else {
            cameraConfiguration = new CameraConfiguration(CameraFacing.FRONT);
        }
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        activityManualFaceCaptureBinding.faceCaptureView.startCamera((LifecycleOwner) this, new C00451(), cameraConfiguration);
        disableAutoFocusOnYotiCamera();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity$startCamera$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ManualFaceCaptureActivity.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class C00451 implements CameraStateListener, FunctionAdapter {
        C00451() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof CameraStateListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl<>(1, ManualFaceCaptureActivity.this, ManualFaceCaptureActivity.class, "onCameraState", "onCameraState(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.yoti.mobile.android.capture.face.ui.models.camera.CameraStateListener
        public final void onCameraState(CameraState cameraState) {
            Intrinsics.checkNotNullParameter(cameraState, "p0");
            ManualFaceCaptureActivity.this.onCameraState(cameraState);
        }
    }

    private final void stopAnalyzing() {
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        if (activityManualFaceCaptureBinding.faceCaptureView.isAnalysing()) {
            activityManualFaceCaptureBinding.faceCaptureView.stopAnalysing();
        }
    }

    private final void logState(int state) {
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        activityManualFaceCaptureBinding.userFeedback.setText(state);
    }

    private final void clearState() {
        this.isManualCaptureButtonClicked = false;
        ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
        if (activityManualFaceCaptureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManualFaceCaptureBinding = null;
        }
        activityManualFaceCaptureBinding.userFeedback.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCameraState(CameraState state) {
        if (state instanceof CameraState.CameraInitializationError) {
            logState(handleCameraInitError(((CameraState.CameraInitializationError) state).getCause()));
        } else if (state instanceof CameraState.MissingPermissions) {
            logState(R.string.yoti_fcm_demo_camera_error_permissions);
        }
    }

    private final int handleCameraInitError(CameraError error) {
        if (Intrinsics.areEqual(error, CameraError.IllegalState.INSTANCE)) {
            return R.string.yoti_fcm_demo_camera_error_illegal_state;
        }
        return Intrinsics.areEqual(error, CameraError.UnableToResolveCamera.INSTANCE) ? R.string.yoti_fcm_demo_camera_error_unable_to_resolve : R.string.yoti_fcm_demo_camera_error_unknown;
    }

    public final String getG_file_uri() {
        return this.g_file_uri;
    }

    public final void setG_file_uri(String str) {
        this.g_file_uri = str;
    }

    private final void saveBitmapImage(Bitmap bitmap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mime_type", "image/png");
        contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("relative_path", "Pictures/" + getString(R.string.app_name));
            contentValues.put("is_pending", (Boolean) true);
            Uri uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            this.g_file_uri = String.valueOf(uriInsert);
            if (uriInsert != null) {
                try {
                    OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(uriInsert);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
                            outputStreamOpenOutputStream.close();
                        } catch (Exception e) {
                            Log.e(this.TAG, "saveBitmapImage: ", e);
                        }
                    }
                    contentValues.put("is_pending", (Boolean) false);
                    getContentResolver().update(uriInsert, contentValues, null, null);
                    return;
                } catch (Exception e2) {
                    Log.e(this.TAG, "saveBitmapImage: ", e2);
                    return;
                }
            }
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, jCurrentTimeMillis + ".png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e3) {
                Log.e(this.TAG, "saveBitmapImage: ", e3);
            }
            contentValues.put("_data", file2.getAbsolutePath());
            this.g_file_uri = String.valueOf(getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
            Unit unit = Unit.INSTANCE;
        } catch (Exception e4) {
            Integer.valueOf(Log.e(this.TAG, "saveBitmapImage: ", e4));
        }
    }

    private final void disableAutoFocusOnYotiCamera() {
        try {
            ActivityManualFaceCaptureBinding activityManualFaceCaptureBinding = this.binding;
            if (activityManualFaceCaptureBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityManualFaceCaptureBinding = null;
            }
            FaceCapture faceCapture = activityManualFaceCaptureBinding.faceCaptureView;
            Intrinsics.checkNotNullExpressionValue(faceCapture, "faceCaptureView");
            Class<?> cls = faceCapture.getClass();
            Log.d(this.TAG, "Attempting to disable autofocus on Yoti camera. viewClass=" + cls.getName());
            Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredFields());
            while (it.hasNext()) {
                Field field = (Field) it.next();
                try {
                    field.setAccessible(true);
                    Object obj = field.get(faceCapture);
                    if (obj != null) {
                        String name = obj.getClass().getName();
                        Intrinsics.checkNotNull(name);
                        if (StringsKt.contains(name, "Camera", true) || StringsKt.contains(name, "controller", true) || StringsKt.contains(name, "preview", true) || StringsKt.contains(name, "session", true)) {
                            Log.d(this.TAG, "Found candidate field " + field.getName() + " -> " + name);
                            tryDisableAfOnObject(obj);
                        }
                    }
                } catch (Throwable th) {
                    Log.d(this.TAG, "Field reflection failed: " + field.getName() + " -> " + th.getLocalizedMessage());
                }
            }
            Iterator it2 = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
            while (it2.hasNext()) {
                Method method = (Method) it2.next();
                try {
                    method.setAccessible(true);
                    String name2 = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String lowerCase = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains$default(lowerCase, "setautofocus", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "enableautofocus", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "setaf", false, 2, (Object) null)) {
                        Log.d(this.TAG, "Invoking method " + lowerCase + " to disable AF");
                        try {
                            method.invoke(faceCapture, false);
                            Log.d(this.TAG, "Invoked " + lowerCase + " successfully");
                        } catch (Throwable th2) {
                            Log.d(this.TAG, "Invocation of " + lowerCase + " failed: " + th2.getLocalizedMessage());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th3) {
            Log.d(this.TAG, "disableAutoFocusOnYotiCamera failed: " + th3.getLocalizedMessage());
        }
    }

    private final void tryDisableAfOnObject(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
            while (it.hasNext()) {
                Method method = (Method) it.next();
                try {
                    method.setAccessible(true);
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String lowerCase = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains$default(lowerCase, "getcapture", false, 2, (Object) null) && StringsKt.contains$default(lowerCase, "builder", false, 2, (Object) null)) {
                        Intrinsics.checkNotNull(method);
                        Object objTryInvokeMethodReturning = tryInvokeMethodReturning(method, obj);
                        if (objTryInvokeMethodReturning != null) {
                            setAfOffOnBuilderIfPossible(objTryInvokeMethodReturning);
                        }
                    } else if (StringsKt.contains$default(lowerCase, "getpreviewrequest", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "getpreview", false, 2, (Object) null)) {
                        Intrinsics.checkNotNull(method);
                        Object objTryInvokeMethodReturning2 = tryInvokeMethodReturning(method, obj);
                        if (objTryInvokeMethodReturning2 != null) {
                            setAfOffOnBuilderIfPossible(objTryInvokeMethodReturning2);
                        }
                    } else if (StringsKt.contains$default(lowerCase, "getcameradevice", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "getcameradev", false, 2, (Object) null)) {
                        Intrinsics.checkNotNull(method);
                        Object objTryInvokeMethodReturning3 = tryInvokeMethodReturning(method, obj);
                        if (objTryInvokeMethodReturning3 != null) {
                            setAfOffOnCameraDeviceIfPossible(objTryInvokeMethodReturning3);
                        }
                    } else if (StringsKt.contains$default(lowerCase, "setautofocus", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "enableautofocus", false, 2, (Object) null)) {
                        try {
                            method.invoke(obj, false);
                            Log.d(this.TAG, "Called " + method.getName() + " with false");
                            return;
                        } catch (Throwable th) {
                            Log.d(this.TAG, "Failed to call " + method.getName() + ": " + th.getLocalizedMessage());
                        }
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
            Iterator it2 = ArrayIteratorKt.iterator(cls.getDeclaredFields());
            while (it2.hasNext()) {
                Field field = (Field) it2.next();
                try {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        String name2 = field.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        String lowerCase2 = name2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(lowerCase2, "builder", false, 2, (Object) null)) {
                            String name3 = obj2.getClass().getName();
                            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                            if (StringsKt.contains(name3, "builder", true)) {
                            }
                        }
                        setAfOffOnBuilderIfPossible(obj2);
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th2) {
            Log.d(this.TAG, "tryDisableAfOnObject failed: " + th2.getLocalizedMessage());
        }
    }

    private final void setAfOffOnBuilderIfPossible(Object builderObj) {
        try {
            Class<?> cls = builderObj.getClass();
            CollectionsKt.listOf(new String[]{"set", "addTarget", "build"});
            try {
                Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
                while (it.hasNext()) {
                    Method method = (Method) it.next();
                    method.setAccessible(true);
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String lowerCase = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, "set") || StringsKt.contains$default(lowerCase, "set", false, 2, (Object) null)) {
                        if (method.getParameterTypes().length == 2) {
                            try {
                                method.invoke(builderObj, CaptureRequest.CONTROL_AF_MODE, 0);
                                Log.d(this.TAG, "Called builder.set(CONTROL_AF_MODE, OFF) on " + cls.getName());
                                return;
                            } catch (Throwable th) {
                                Log.d(this.TAG, "builder.set invocation failed: " + th.getLocalizedMessage());
                            }
                        } else {
                            continue;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                Integer.valueOf(Log.d(this.TAG, "setAfOffOnBuilderIfPossible inner failed: " + th2.getLocalizedMessage()));
            }
        } catch (Throwable th3) {
            Log.d(this.TAG, "setAfOffOnBuilderIfPossible failed: " + th3.getLocalizedMessage());
        }
    }

    private final void setAfOffOnCameraDeviceIfPossible(Object camDevObj) {
        try {
            Class<?> cls = camDevObj.getClass();
            Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
            while (it.hasNext()) {
                Method method = (Method) it.next();
                try {
                    method.setAccessible(true);
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String lowerCase = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains$default(lowerCase, "create", false, 2, (Object) null) && StringsKt.contains$default(lowerCase, "request", false, 2, (Object) null)) {
                        Log.d(this.TAG, "Found create request method " + method.getName() + " on " + cls.getName() + ", but not invoking (unsafe).");
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            Log.d(this.TAG, "setAfOffOnCameraDeviceIfPossible failed: " + th.getLocalizedMessage());
        }
    }

    private final Object tryInvokeMethodReturning(Method method, Object target) {
        try {
            return method.invoke(target, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Uri getSaveImagePath(Bitmap bitmap, String code) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(code, "code");
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "img_" + code + this.jpgTextBaseActivity);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                Integer.valueOf(Log.e(this.TAG, "saveBitmapImage: ", e));
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "saveBitmapImage: ", e2);
        }
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }
}
