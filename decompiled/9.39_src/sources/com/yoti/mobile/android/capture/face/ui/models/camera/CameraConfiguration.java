package com.yoti.mobile.android.capture.face.ui.models.camera;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraConfiguration.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraConfiguration;", "", "facing", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraFacing;", "(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraFacing;)V", "getFacing", "()Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraFacing;", "targetResolution", "Landroid/util/Size;", "getTargetResolution", "()Landroid/util/Size;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Defaults", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class CameraConfiguration {
    public static final int TARGET_HEIGHT = 1280;
    public static final int TARGET_WIDTH = 720;
    private final CameraFacing facing;
    private final Size targetResolution;

    /* JADX WARN: Illegal instructions before constructor call */
    public CameraConfiguration() {
        CameraFacing cameraFacing = null;
        this(cameraFacing, 1, cameraFacing);
    }

    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, CameraFacing cameraFacing, int i, Object obj) {
        if ((i & 1) != 0) {
            cameraFacing = cameraConfiguration.facing;
        }
        return cameraConfiguration.copy(cameraFacing);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CameraFacing getFacing() {
        return this.facing;
    }

    public final CameraConfiguration copy(CameraFacing facing) {
        Intrinsics.checkNotNullParameter(facing, "facing");
        return new CameraConfiguration(facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CameraConfiguration) && this.facing == ((CameraConfiguration) other).facing;
    }

    public int hashCode() {
        return this.facing.hashCode();
    }

    public String toString() {
        return "CameraConfiguration(facing=" + this.facing + ')';
    }

    public CameraConfiguration(CameraFacing cameraFacing) {
        Intrinsics.checkNotNullParameter(cameraFacing, "facing");
        this.facing = cameraFacing;
        this.targetResolution = new Size(TARGET_WIDTH, TARGET_HEIGHT);
    }

    public /* synthetic */ CameraConfiguration(CameraFacing cameraFacing, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CameraFacing.FRONT : cameraFacing);
    }

    public final CameraFacing getFacing() {
        return this.facing;
    }

    public final Size getTargetResolution() {
        return this.targetResolution;
    }
}
