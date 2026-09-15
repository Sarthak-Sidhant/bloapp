package com.yoti.mobile.android.core.image;

import com.yoti.mobile.android.commons.image.ImageBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"rotateBy", "Lcom/yoti/mobile/android/core/image/RotationBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "degrees", "", "lib_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RotationBufferKt {
    public static final RotationBuffer rotateBy(ImageBuffer imageBuffer, int i) {
        Intrinsics.checkNotNullParameter(imageBuffer, "<this>");
        if (!(imageBuffer instanceof RotationBuffer)) {
            return new RotationBuffer(imageBuffer, i);
        }
        RotationBuffer rotationBuffer = (RotationBuffer) imageBuffer;
        return new RotationBuffer(rotationBuffer.getA(), rotationBuffer.getB() + i);
    }
}
