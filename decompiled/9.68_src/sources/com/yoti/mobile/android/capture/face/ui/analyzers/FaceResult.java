package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.graphics.Rect;
import com.yoti.mobile.android.capture.face.ui.models.face.FacialLandmarks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFaceDetection.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "", "boundingBox", "Landroid/graphics/Rect;", "eyesClosed", "", "invalidAngle", "facialLandmarks", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "smileScore", "", "(Landroid/graphics/Rect;ZZLcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Ljava/lang/Float;)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getEyesClosed", "()Z", "getFacialLandmarks", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "getInvalidAngle", "getSmileScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "copy", "(Landroid/graphics/Rect;ZZLcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Ljava/lang/Float;)Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "equals", "other", "hashCode", "", "toString", "", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class FaceResult {
    private final Rect boundingBox;
    private final boolean eyesClosed;
    private final FacialLandmarks facialLandmarks;
    private final boolean invalidAngle;
    private final Float smileScore;

    public static /* synthetic */ FaceResult copy$default(FaceResult faceResult, Rect rect, boolean z, boolean z2, FacialLandmarks facialLandmarks, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = faceResult.boundingBox;
        }
        if ((i & 2) != 0) {
            z = faceResult.eyesClosed;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = faceResult.invalidAngle;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            facialLandmarks = faceResult.facialLandmarks;
        }
        FacialLandmarks facialLandmarks2 = facialLandmarks;
        if ((i & 16) != 0) {
            f = faceResult.smileScore;
        }
        return faceResult.copy(rect, z3, z4, facialLandmarks2, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEyesClosed() {
        return this.eyesClosed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getInvalidAngle() {
        return this.invalidAngle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FacialLandmarks getFacialLandmarks() {
        return this.facialLandmarks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getSmileScore() {
        return this.smileScore;
    }

    public final FaceResult copy(Rect boundingBox, boolean eyesClosed, boolean invalidAngle, FacialLandmarks facialLandmarks, Float smileScore) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        Intrinsics.checkNotNullParameter(facialLandmarks, "facialLandmarks");
        return new FaceResult(boundingBox, eyesClosed, invalidAngle, facialLandmarks, smileScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceResult)) {
            return false;
        }
        FaceResult faceResult = (FaceResult) other;
        return Intrinsics.areEqual(this.boundingBox, faceResult.boundingBox) && this.eyesClosed == faceResult.eyesClosed && this.invalidAngle == faceResult.invalidAngle && Intrinsics.areEqual(this.facialLandmarks, faceResult.facialLandmarks) && Intrinsics.areEqual((Object) this.smileScore, (Object) faceResult.smileScore);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.boundingBox.hashCode() * 31;
        boolean z = this.eyesClosed;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.invalidAngle;
        int iHashCode2 = (((i + (z2 ? 1 : z2)) * 31) + this.facialLandmarks.hashCode()) * 31;
        Float f = this.smileScore;
        return iHashCode2 + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "FaceResult(boundingBox=" + this.boundingBox + ", eyesClosed=" + this.eyesClosed + ", invalidAngle=" + this.invalidAngle + ", facialLandmarks=" + this.facialLandmarks + ", smileScore=" + this.smileScore + ')';
    }

    public FaceResult(Rect boundingBox, boolean z, boolean z2, FacialLandmarks facialLandmarks, Float f) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        Intrinsics.checkNotNullParameter(facialLandmarks, "facialLandmarks");
        this.boundingBox = boundingBox;
        this.eyesClosed = z;
        this.invalidAngle = z2;
        this.facialLandmarks = facialLandmarks;
        this.smileScore = f;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final boolean getEyesClosed() {
        return this.eyesClosed;
    }

    public final boolean getInvalidAngle() {
        return this.invalidAngle;
    }

    public final FacialLandmarks getFacialLandmarks() {
        return this.facialLandmarks;
    }

    public final Float getSmileScore() {
        return this.smileScore;
    }
}
