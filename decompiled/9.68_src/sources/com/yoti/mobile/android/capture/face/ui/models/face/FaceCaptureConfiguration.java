package com.yoti.mobile.android.capture.face.ui.models.face;

import android.graphics.PointF;
import android.util.Size;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureConfiguration.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "", "faceCenter", "Landroid/graphics/PointF;", "imageQuality", "Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "requireValidAngle", "", "requireEyesOpen", "requireBrightEnvironment", "requiredStableFrames", "", "provideLandmarks", "provideSmileScore", "(Landroid/graphics/PointF;Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;ZZZIZZ)V", "getFaceCenter", "()Landroid/graphics/PointF;", "getImageQuality", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "getProvideLandmarks", "()Z", "getProvideSmileScore", "getRequireBrightEnvironment", "getRequireEyesOpen", "getRequireValidAngle", "getRequiredStableFrames", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "Defaults", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class FaceCaptureConfiguration {
    public static final double EYES_OPEN_PROBABILITY_THRESHOLD = 0.25d;
    public static final float STABILITY_SCALE_TOLERANCE = 0.015f;
    public static final float STABILITY_SHIFT_TOLERANCE = 0.025f;
    public static final int VALID_ANGLE_THRESHOLD_DEGREES = 30;
    private final PointF faceCenter;
    private final ImageQuality imageQuality;
    private final boolean provideLandmarks;
    private final boolean provideSmileScore;
    private final boolean requireBrightEnvironment;
    private final boolean requireEyesOpen;
    private final boolean requireValidAngle;
    private final int requiredStableFrames;

    /* JADX INFO: renamed from: Defaults, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] REQUIRED_PERMISSIONS = {"android.permission.CAMERA"};
    private static final PointF FACE_CENTER = new PointF(0.5f, 0.45f);
    private static final Size MIN_FACE_SIZE = new Size(400, 400);
    private static final Size MAX_FACE_SIZE = new Size(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
    private static final int MAX_CENTER_DISTANCE = 60;
    private static final float CROP_MULTIPLIER_TOP = 0.6f;
    private static final float CROP_MULTIPLIER_BOTTOM = 0.3f;

    public FaceCaptureConfiguration() {
        this(null, null, false, false, false, 0, false, false, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PointF getFaceCenter() {
        return this.faceCenter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImageQuality getImageQuality() {
        return this.imageQuality;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRequireValidAngle() {
        return this.requireValidAngle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequireEyesOpen() {
        return this.requireEyesOpen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRequireBrightEnvironment() {
        return this.requireBrightEnvironment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRequiredStableFrames() {
        return this.requiredStableFrames;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getProvideLandmarks() {
        return this.provideLandmarks;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getProvideSmileScore() {
        return this.provideSmileScore;
    }

    public final FaceCaptureConfiguration copy(PointF faceCenter, ImageQuality imageQuality, boolean requireValidAngle, boolean requireEyesOpen, boolean requireBrightEnvironment, int requiredStableFrames, boolean provideLandmarks, boolean provideSmileScore) {
        Intrinsics.checkNotNullParameter(faceCenter, "faceCenter");
        Intrinsics.checkNotNullParameter(imageQuality, "imageQuality");
        return new FaceCaptureConfiguration(faceCenter, imageQuality, requireValidAngle, requireEyesOpen, requireBrightEnvironment, requiredStableFrames, provideLandmarks, provideSmileScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureConfiguration)) {
            return false;
        }
        FaceCaptureConfiguration faceCaptureConfiguration = (FaceCaptureConfiguration) other;
        return Intrinsics.areEqual(this.faceCenter, faceCaptureConfiguration.faceCenter) && this.imageQuality == faceCaptureConfiguration.imageQuality && this.requireValidAngle == faceCaptureConfiguration.requireValidAngle && this.requireEyesOpen == faceCaptureConfiguration.requireEyesOpen && this.requireBrightEnvironment == faceCaptureConfiguration.requireBrightEnvironment && this.requiredStableFrames == faceCaptureConfiguration.requiredStableFrames && this.provideLandmarks == faceCaptureConfiguration.provideLandmarks && this.provideSmileScore == faceCaptureConfiguration.provideSmileScore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.faceCenter.hashCode() * 31) + this.imageQuality.hashCode()) * 31;
        boolean z = this.requireValidAngle;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.requireEyesOpen;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.requireBrightEnvironment;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode2 = (((i2 + r3) * 31) + Integer.hashCode(this.requiredStableFrames)) * 31;
        boolean z4 = this.provideLandmarks;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode2 + r4) * 31;
        boolean z5 = this.provideSmileScore;
        return i3 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "FaceCaptureConfiguration(faceCenter=" + this.faceCenter + ", imageQuality=" + this.imageQuality + ", requireValidAngle=" + this.requireValidAngle + ", requireEyesOpen=" + this.requireEyesOpen + ", requireBrightEnvironment=" + this.requireBrightEnvironment + ", requiredStableFrames=" + this.requiredStableFrames + ", provideLandmarks=" + this.provideLandmarks + ", provideSmileScore=" + this.provideSmileScore + ')';
    }

    public FaceCaptureConfiguration(PointF faceCenter, ImageQuality imageQuality, boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(faceCenter, "faceCenter");
        Intrinsics.checkNotNullParameter(imageQuality, "imageQuality");
        this.faceCenter = faceCenter;
        this.imageQuality = imageQuality;
        this.requireValidAngle = z;
        this.requireEyesOpen = z2;
        this.requireBrightEnvironment = z3;
        this.requiredStableFrames = i;
        this.provideLandmarks = z4;
        this.provideSmileScore = z5;
    }

    public /* synthetic */ FaceCaptureConfiguration(PointF pointF, ImageQuality imageQuality, boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? FACE_CENTER : pointF, (i2 & 2) != 0 ? ImageQuality.INSTANCE.getDefault() : imageQuality, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3, (i2 & 32) == 0 ? i : 1, (i2 & 64) != 0 ? false : z4, (i2 & 128) == 0 ? z5 : false);
    }

    public final PointF getFaceCenter() {
        return this.faceCenter;
    }

    public final ImageQuality getImageQuality() {
        return this.imageQuality;
    }

    public final boolean getRequireValidAngle() {
        return this.requireValidAngle;
    }

    public final boolean getRequireEyesOpen() {
        return this.requireEyesOpen;
    }

    public final boolean getRequireBrightEnvironment() {
        return this.requireBrightEnvironment;
    }

    public final int getRequiredStableFrames() {
        return this.requiredStableFrames;
    }

    public final boolean getProvideLandmarks() {
        return this.provideLandmarks;
    }

    public final boolean getProvideSmileScore() {
        return this.provideSmileScore;
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration$Defaults, reason: from kotlin metadata */
    /* JADX INFO: compiled from: FaceCaptureConfiguration.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration$Defaults;", "", "()V", "CROP_MULTIPLIER_BOTTOM", "", "getCROP_MULTIPLIER_BOTTOM", "()F", "CROP_MULTIPLIER_TOP", "getCROP_MULTIPLIER_TOP", "EYES_OPEN_PROBABILITY_THRESHOLD", "", "FACE_CENTER", "Landroid/graphics/PointF;", "getFACE_CENTER", "()Landroid/graphics/PointF;", "MAX_CENTER_DISTANCE", "", "getMAX_CENTER_DISTANCE", "()I", "MAX_FACE_SIZE", "Landroid/util/Size;", "getMAX_FACE_SIZE", "()Landroid/util/Size;", "MIN_FACE_SIZE", "getMIN_FACE_SIZE", "REQUIRED_PERMISSIONS", "", "", "getREQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STABILITY_SCALE_TOLERANCE", "STABILITY_SHIFT_TOLERANCE", "VALID_ANGLE_THRESHOLD_DEGREES", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getREQUIRED_PERMISSIONS() {
            return FaceCaptureConfiguration.REQUIRED_PERMISSIONS;
        }

        public final PointF getFACE_CENTER() {
            return FaceCaptureConfiguration.FACE_CENTER;
        }

        public final Size getMIN_FACE_SIZE() {
            return FaceCaptureConfiguration.MIN_FACE_SIZE;
        }

        public final Size getMAX_FACE_SIZE() {
            return FaceCaptureConfiguration.MAX_FACE_SIZE;
        }

        public final int getMAX_CENTER_DISTANCE() {
            return FaceCaptureConfiguration.MAX_CENTER_DISTANCE;
        }

        public final float getCROP_MULTIPLIER_TOP() {
            return FaceCaptureConfiguration.CROP_MULTIPLIER_TOP;
        }

        public final float getCROP_MULTIPLIER_BOTTOM() {
            return FaceCaptureConfiguration.CROP_MULTIPLIER_BOTTOM;
        }
    }
}
