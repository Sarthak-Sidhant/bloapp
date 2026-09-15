package com.yoti.mobile.android.capture.face.ui.models.face;

import android.graphics.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureResult.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "", "()V", "InvalidFace", "ValidFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$InvalidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FaceCaptureState {
    public /* synthetic */ FaceCaptureState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$InvalidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "cause", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "(Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;)V", "getCause", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class InvalidFace extends FaceCaptureState {
        private final FaceCaptureInvalid cause;

        public static /* synthetic */ InvalidFace copy$default(InvalidFace invalidFace, FaceCaptureInvalid faceCaptureInvalid, int i, Object obj) {
            if ((i & 1) != 0) {
                faceCaptureInvalid = invalidFace.cause;
            }
            return invalidFace.copy(faceCaptureInvalid);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FaceCaptureInvalid getCause() {
            return this.cause;
        }

        public final InvalidFace copy(FaceCaptureInvalid cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new InvalidFace(cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidFace) && Intrinsics.areEqual(this.cause, ((InvalidFace) other).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "InvalidFace(cause=" + this.cause + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidFace(FaceCaptureInvalid cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final FaceCaptureInvalid getCause() {
            return this.cause;
        }
    }

    private FaceCaptureState() {
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JL\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "croppedImage", "", "croppedFaceBoundingBox", "Landroid/graphics/Rect;", "faceBoundingBox", "originalLandmarks", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "croppedLandmarks", "smileScore", "", "([BLandroid/graphics/Rect;Landroid/graphics/Rect;Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Ljava/lang/Float;)V", "getCroppedFaceBoundingBox", "()Landroid/graphics/Rect;", "getCroppedImage", "()[B", "getCroppedLandmarks", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;", "getFaceBoundingBox", "getOriginalLandmarks", "getSmileScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "([BLandroid/graphics/Rect;Landroid/graphics/Rect;Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Lcom/yoti/mobile/android/capture/face/ui/models/face/FacialLandmarks;Ljava/lang/Float;)Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "equals", "", "other", "", "hashCode", "", "toString", "", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class ValidFace extends FaceCaptureState {
        private final Rect croppedFaceBoundingBox;
        private final byte[] croppedImage;
        private final FacialLandmarks croppedLandmarks;
        private final Rect faceBoundingBox;
        private final FacialLandmarks originalLandmarks;
        private final Float smileScore;

        public static /* synthetic */ ValidFace copy$default(ValidFace validFace, byte[] bArr, Rect rect, Rect rect2, FacialLandmarks facialLandmarks, FacialLandmarks facialLandmarks2, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = validFace.croppedImage;
            }
            if ((i & 2) != 0) {
                rect = validFace.croppedFaceBoundingBox;
            }
            Rect rect3 = rect;
            if ((i & 4) != 0) {
                rect2 = validFace.faceBoundingBox;
            }
            Rect rect4 = rect2;
            if ((i & 8) != 0) {
                facialLandmarks = validFace.originalLandmarks;
            }
            FacialLandmarks facialLandmarks3 = facialLandmarks;
            if ((i & 16) != 0) {
                facialLandmarks2 = validFace.croppedLandmarks;
            }
            FacialLandmarks facialLandmarks4 = facialLandmarks2;
            if ((i & 32) != 0) {
                f = validFace.smileScore;
            }
            return validFace.copy(bArr, rect3, rect4, facialLandmarks3, facialLandmarks4, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getCroppedImage() {
            return this.croppedImage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Rect getCroppedFaceBoundingBox() {
            return this.croppedFaceBoundingBox;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Rect getFaceBoundingBox() {
            return this.faceBoundingBox;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final FacialLandmarks getOriginalLandmarks() {
            return this.originalLandmarks;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FacialLandmarks getCroppedLandmarks() {
            return this.croppedLandmarks;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Float getSmileScore() {
            return this.smileScore;
        }

        public final ValidFace copy(byte[] croppedImage, Rect croppedFaceBoundingBox, Rect faceBoundingBox, FacialLandmarks originalLandmarks, FacialLandmarks croppedLandmarks, Float smileScore) {
            Intrinsics.checkNotNullParameter(croppedImage, "croppedImage");
            Intrinsics.checkNotNullParameter(croppedFaceBoundingBox, "croppedFaceBoundingBox");
            Intrinsics.checkNotNullParameter(faceBoundingBox, "faceBoundingBox");
            Intrinsics.checkNotNullParameter(originalLandmarks, "originalLandmarks");
            Intrinsics.checkNotNullParameter(croppedLandmarks, "croppedLandmarks");
            return new ValidFace(croppedImage, croppedFaceBoundingBox, faceBoundingBox, originalLandmarks, croppedLandmarks, smileScore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidFace)) {
                return false;
            }
            ValidFace validFace = (ValidFace) other;
            return Intrinsics.areEqual(this.croppedImage, validFace.croppedImage) && Intrinsics.areEqual(this.croppedFaceBoundingBox, validFace.croppedFaceBoundingBox) && Intrinsics.areEqual(this.faceBoundingBox, validFace.faceBoundingBox) && Intrinsics.areEqual(this.originalLandmarks, validFace.originalLandmarks) && Intrinsics.areEqual(this.croppedLandmarks, validFace.croppedLandmarks) && Intrinsics.areEqual((Object) this.smileScore, (Object) validFace.smileScore);
        }

        public int hashCode() {
            int iHashCode = ((((((((Arrays.hashCode(this.croppedImage) * 31) + this.croppedFaceBoundingBox.hashCode()) * 31) + this.faceBoundingBox.hashCode()) * 31) + this.originalLandmarks.hashCode()) * 31) + this.croppedLandmarks.hashCode()) * 31;
            Float f = this.smileScore;
            return iHashCode + (f == null ? 0 : f.hashCode());
        }

        public String toString() {
            return "ValidFace(croppedImage=" + Arrays.toString(this.croppedImage) + ", croppedFaceBoundingBox=" + this.croppedFaceBoundingBox + ", faceBoundingBox=" + this.faceBoundingBox + ", originalLandmarks=" + this.originalLandmarks + ", croppedLandmarks=" + this.croppedLandmarks + ", smileScore=" + this.smileScore + ')';
        }

        public final byte[] getCroppedImage() {
            return this.croppedImage;
        }

        public final Rect getCroppedFaceBoundingBox() {
            return this.croppedFaceBoundingBox;
        }

        public final Rect getFaceBoundingBox() {
            return this.faceBoundingBox;
        }

        public final FacialLandmarks getOriginalLandmarks() {
            return this.originalLandmarks;
        }

        public final FacialLandmarks getCroppedLandmarks() {
            return this.croppedLandmarks;
        }

        public final Float getSmileScore() {
            return this.smileScore;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidFace(byte[] croppedImage, Rect croppedFaceBoundingBox, Rect faceBoundingBox, FacialLandmarks originalLandmarks, FacialLandmarks croppedLandmarks, Float f) {
            super(null);
            Intrinsics.checkNotNullParameter(croppedImage, "croppedImage");
            Intrinsics.checkNotNullParameter(croppedFaceBoundingBox, "croppedFaceBoundingBox");
            Intrinsics.checkNotNullParameter(faceBoundingBox, "faceBoundingBox");
            Intrinsics.checkNotNullParameter(originalLandmarks, "originalLandmarks");
            Intrinsics.checkNotNullParameter(croppedLandmarks, "croppedLandmarks");
            this.croppedImage = croppedImage;
            this.croppedFaceBoundingBox = croppedFaceBoundingBox;
            this.faceBoundingBox = faceBoundingBox;
            this.originalLandmarks = originalLandmarks;
            this.croppedLandmarks = croppedLandmarks;
            this.smileScore = f;
        }
    }
}
