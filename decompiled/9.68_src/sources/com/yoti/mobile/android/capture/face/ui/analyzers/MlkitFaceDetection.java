package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.media.Image;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.commons.functional.Either;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MlkitFaceDetection.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/MlkitFaceDetection;", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;", "faceMapper", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/MlkitFaceMapper;", "(Lcom/yoti/mobile/android/capture/face/ui/analyzers/MlkitFaceMapper;)V", "detector", "Lcom/google/mlkit/vision/face/FaceDetector;", "analyse", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionError;", "", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "image", "Landroid/media/Image;", "rotationDegrees", "", "initDetector", "", "config", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "onConfigChanged", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MlkitFaceDetection implements IFaceDetection {
    private FaceDetector detector;
    private final MlkitFaceMapper faceMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public MlkitFaceDetection() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MlkitFaceDetection(MlkitFaceMapper faceMapper) {
        Intrinsics.checkNotNullParameter(faceMapper, "faceMapper");
        this.faceMapper = faceMapper;
        initDetector(new FaceCaptureConfiguration(null, null, false, false, false, 0, false, false, KotlinVersion.MAX_COMPONENT_VALUE, null));
    }

    public /* synthetic */ MlkitFaceDetection(MlkitFaceMapper mlkitFaceMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MlkitFaceMapper() : mlkitFaceMapper);
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.IFaceDetection
    public Either<FaceDetectionError, List<FaceResult>> analyse(Image image, int rotationDegrees) {
        Intrinsics.checkNotNullParameter(image, "image");
        FaceDetector faceDetector = this.detector;
        if (faceDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detector");
            faceDetector = null;
        }
        Task taskProcess = faceDetector.process(InputImage.fromMediaImage(image, rotationDegrees));
        Intrinsics.checkNotNullExpressionValue(taskProcess, "detector.process(\n      …              )\n        )");
        try {
            List result = (List) Tasks.await(taskProcess);
            Intrinsics.checkNotNullExpressionValue(result, "result");
            List list = result;
            MlkitFaceMapper mlkitFaceMapper = this.faceMapper;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(mlkitFaceMapper.map((Face) it.next()));
            }
            return new Either.Success(arrayList);
        } catch (InterruptedException unused) {
            return new Either.Failure(FaceDetectionError.INTERRUPTED);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            MlKitException mlKitException = cause instanceof MlKitException ? (MlKitException) cause : null;
            if (mlKitException != null && mlKitException.getErrorCode() == 14) {
                return new Either.Failure(FaceDetectionError.MISSING_MODEL);
            }
            return new Either.Failure(FaceDetectionError.UNKNOWN);
        }
    }

    @Override // com.yoti.mobile.android.capture.face.ui.analyzers.IFaceDetection
    public void onConfigChanged(FaceCaptureConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        initDetector(config);
    }

    private final void initDetector(FaceCaptureConfiguration config) {
        FaceDetector client = FaceDetection.getClient(new FaceDetectorOptions.Builder().setPerformanceMode(1).setContourMode(1).setLandmarkMode(config.getProvideLandmarks() ? 2 : 1).setClassificationMode((config.getRequireEyesOpen() || config.getProvideSmileScore()) ? 2 : 1).build());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(\n             …       .build()\n        )");
        this.detector = client;
    }
}
