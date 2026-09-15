package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.util.Size;
import com.yalantis.ucrop.view.CropImageView;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScalingHelper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/ScalingHelper;", "", "()V", "calculateDistanceScaling", "", "currentSize", "Landroid/util/Size;", "targetSize", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScalingHelper {
    public static /* synthetic */ float calculateDistanceScaling$default(ScalingHelper scalingHelper, Size size, Size size2, int i, Object obj) {
        if ((i & 2) != 0) {
            size2 = new Size(CameraConfiguration.TARGET_WIDTH, CameraConfiguration.TARGET_HEIGHT);
        }
        return scalingHelper.calculateDistanceScaling(size, size2);
    }

    public final float calculateDistanceScaling(Size currentSize, Size targetSize) {
        float height;
        int height2;
        Intrinsics.checkNotNullParameter(currentSize, "currentSize");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        int width = targetSize.getWidth() - currentSize.getWidth();
        int height3 = targetSize.getHeight() - currentSize.getHeight();
        if (width <= 0 && height3 <= 0) {
            return 1.0f;
        }
        if (width >= height3) {
            height = currentSize.getWidth();
            height2 = targetSize.getWidth();
        } else {
            height = currentSize.getHeight();
            height2 = targetSize.getHeight();
        }
        return RangesKt.coerceIn(height / height2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }
}
