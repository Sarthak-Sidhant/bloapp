package com.yoti.mobile.android.capture.face.ui.models.face;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureResult.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006+"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "", "leftEye", "Landroid/graphics/PointF;", "rightEye", "noseBase", "mouthLeft", "mouthRight", "mouthBottom", "leftEar", "rightEar", "leftCheek", "rightCheek", "(Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "getLeftCheek", "()Landroid/graphics/PointF;", "getLeftEar", "getLeftEye", "getMouthBottom", "getMouthLeft", "getMouthRight", "getNoseBase", "getRightCheek", "getRightEar", "getRightEye", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class FacialLandmarks {
    private final PointF leftCheek;
    private final PointF leftEar;
    private final PointF leftEye;
    private final PointF mouthBottom;
    private final PointF mouthLeft;
    private final PointF mouthRight;
    private final PointF noseBase;
    private final PointF rightCheek;
    private final PointF rightEar;
    private final PointF rightEye;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PointF getLeftEye() {
        return this.leftEye;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PointF getRightCheek() {
        return this.rightCheek;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PointF getRightEye() {
        return this.rightEye;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PointF getNoseBase() {
        return this.noseBase;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PointF getMouthLeft() {
        return this.mouthLeft;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PointF getMouthRight() {
        return this.mouthRight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PointF getMouthBottom() {
        return this.mouthBottom;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PointF getLeftEar() {
        return this.leftEar;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final PointF getRightEar() {
        return this.rightEar;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PointF getLeftCheek() {
        return this.leftCheek;
    }

    public final FacialLandmarks copy(PointF leftEye, PointF rightEye, PointF noseBase, PointF mouthLeft, PointF mouthRight, PointF mouthBottom, PointF leftEar, PointF rightEar, PointF leftCheek, PointF rightCheek) {
        return new FacialLandmarks(leftEye, rightEye, noseBase, mouthLeft, mouthRight, mouthBottom, leftEar, rightEar, leftCheek, rightCheek);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FacialLandmarks)) {
            return false;
        }
        FacialLandmarks facialLandmarks = (FacialLandmarks) other;
        return Intrinsics.areEqual(this.leftEye, facialLandmarks.leftEye) && Intrinsics.areEqual(this.rightEye, facialLandmarks.rightEye) && Intrinsics.areEqual(this.noseBase, facialLandmarks.noseBase) && Intrinsics.areEqual(this.mouthLeft, facialLandmarks.mouthLeft) && Intrinsics.areEqual(this.mouthRight, facialLandmarks.mouthRight) && Intrinsics.areEqual(this.mouthBottom, facialLandmarks.mouthBottom) && Intrinsics.areEqual(this.leftEar, facialLandmarks.leftEar) && Intrinsics.areEqual(this.rightEar, facialLandmarks.rightEar) && Intrinsics.areEqual(this.leftCheek, facialLandmarks.leftCheek) && Intrinsics.areEqual(this.rightCheek, facialLandmarks.rightCheek);
    }

    public int hashCode() {
        PointF pointF = this.leftEye;
        int iHashCode = (pointF == null ? 0 : pointF.hashCode()) * 31;
        PointF pointF2 = this.rightEye;
        int iHashCode2 = (iHashCode + (pointF2 == null ? 0 : pointF2.hashCode())) * 31;
        PointF pointF3 = this.noseBase;
        int iHashCode3 = (iHashCode2 + (pointF3 == null ? 0 : pointF3.hashCode())) * 31;
        PointF pointF4 = this.mouthLeft;
        int iHashCode4 = (iHashCode3 + (pointF4 == null ? 0 : pointF4.hashCode())) * 31;
        PointF pointF5 = this.mouthRight;
        int iHashCode5 = (iHashCode4 + (pointF5 == null ? 0 : pointF5.hashCode())) * 31;
        PointF pointF6 = this.mouthBottom;
        int iHashCode6 = (iHashCode5 + (pointF6 == null ? 0 : pointF6.hashCode())) * 31;
        PointF pointF7 = this.leftEar;
        int iHashCode7 = (iHashCode6 + (pointF7 == null ? 0 : pointF7.hashCode())) * 31;
        PointF pointF8 = this.rightEar;
        int iHashCode8 = (iHashCode7 + (pointF8 == null ? 0 : pointF8.hashCode())) * 31;
        PointF pointF9 = this.leftCheek;
        int iHashCode9 = (iHashCode8 + (pointF9 == null ? 0 : pointF9.hashCode())) * 31;
        PointF pointF10 = this.rightCheek;
        return iHashCode9 + (pointF10 != null ? pointF10.hashCode() : 0);
    }

    public String toString() {
        return "FacialLandmarks(leftEye=" + this.leftEye + ", rightEye=" + this.rightEye + ", noseBase=" + this.noseBase + ", mouthLeft=" + this.mouthLeft + ", mouthRight=" + this.mouthRight + ", mouthBottom=" + this.mouthBottom + ", leftEar=" + this.leftEar + ", rightEar=" + this.rightEar + ", leftCheek=" + this.leftCheek + ", rightCheek=" + this.rightCheek + ')';
    }

    public FacialLandmarks(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8, PointF pointF9, PointF pointF10) {
        this.leftEye = pointF;
        this.rightEye = pointF2;
        this.noseBase = pointF3;
        this.mouthLeft = pointF4;
        this.mouthRight = pointF5;
        this.mouthBottom = pointF6;
        this.leftEar = pointF7;
        this.rightEar = pointF8;
        this.leftCheek = pointF9;
        this.rightCheek = pointF10;
    }

    public final PointF getLeftEye() {
        return this.leftEye;
    }

    public final PointF getRightEye() {
        return this.rightEye;
    }

    public final PointF getNoseBase() {
        return this.noseBase;
    }

    public final PointF getMouthLeft() {
        return this.mouthLeft;
    }

    public final PointF getMouthRight() {
        return this.mouthRight;
    }

    public final PointF getMouthBottom() {
        return this.mouthBottom;
    }

    public final PointF getLeftEar() {
        return this.leftEar;
    }

    public final PointF getRightEar() {
        return this.rightEar;
    }

    public final PointF getLeftCheek() {
        return this.leftCheek;
    }

    public final PointF getRightCheek() {
        return this.rightCheek;
    }
}
