package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.graphics.PointF;
import android.graphics.Rect;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceLandmark;
import com.yoti.mobile.android.capture.face.ui.models.face.FacialLandmarks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MlkitFaceMapper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\t\u001a\u00020\n*\u00020\u0006H\u0002J\f\u0010\u000b\u001a\u00020\n*\u00020\u0006H\u0002J\u0013\u0010\f\u001a\u00020\n*\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/MlkitFaceMapper;", "", "()V", "getFacialLandmarks", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "face", "Lcom/google/mlkit/vision/face/Face;", "map", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "areEyesClosed", "", "isAngleInvalid", "isBelowEyesOpenThreshold", "", "(Ljava/lang/Float;)Z", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MlkitFaceMapper {
    public final FaceResult map(Face face) {
        Intrinsics.checkNotNullParameter(face, "face");
        Rect boundingBox = face.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue(boundingBox, "face.boundingBox");
        return new FaceResult(boundingBox, areEyesClosed(face), isAngleInvalid(face), getFacialLandmarks(face), face.getSmilingProbability());
    }

    private final boolean isAngleInvalid(Face face) {
        return Math.abs(face.getHeadEulerAngleY()) > 30.0f || Math.abs(face.getHeadEulerAngleZ()) > 30.0f;
    }

    private final boolean areEyesClosed(Face face) {
        return isBelowEyesOpenThreshold(face.getLeftEyeOpenProbability()) || isBelowEyesOpenThreshold(face.getRightEyeOpenProbability());
    }

    private final boolean isBelowEyesOpenThreshold(Float f) {
        return f != null && ((double) f.floatValue()) < 0.25d;
    }

    private final FacialLandmarks getFacialLandmarks(Face face) {
        FaceLandmark landmark = face.getLandmark(4);
        PointF position = landmark != null ? landmark.getPosition() : null;
        FaceLandmark landmark2 = face.getLandmark(10);
        PointF position2 = landmark2 != null ? landmark2.getPosition() : null;
        FaceLandmark landmark3 = face.getLandmark(6);
        PointF position3 = landmark3 != null ? landmark3.getPosition() : null;
        FaceLandmark landmark4 = face.getLandmark(5);
        PointF position4 = landmark4 != null ? landmark4.getPosition() : null;
        FaceLandmark landmark5 = face.getLandmark(11);
        PointF position5 = landmark5 != null ? landmark5.getPosition() : null;
        FaceLandmark landmark6 = face.getLandmark(0);
        PointF position6 = landmark6 != null ? landmark6.getPosition() : null;
        FaceLandmark landmark7 = face.getLandmark(3);
        PointF position7 = landmark7 != null ? landmark7.getPosition() : null;
        FaceLandmark landmark8 = face.getLandmark(9);
        PointF position8 = landmark8 != null ? landmark8.getPosition() : null;
        FaceLandmark landmark9 = face.getLandmark(1);
        PointF position9 = landmark9 != null ? landmark9.getPosition() : null;
        FaceLandmark landmark10 = face.getLandmark(7);
        return new FacialLandmarks(position, position2, position3, position4, position5, position6, position7, position8, position9, landmark10 != null ? landmark10.getPosition() : null);
    }
}
