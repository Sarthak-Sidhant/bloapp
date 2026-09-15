package com.yoti.mobile.android.commons.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.yoti.mobile.android.commons.util.PictureHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferHelper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "toBitmapFast", "context", "Landroid/content/Context;", "commons-image_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BufferHelper {
    public static final Bitmap toBitmap(ImageBuffer imageBuffer) {
        Intrinsics.checkNotNullParameter(imageBuffer, "<this>");
        return PictureHelper.YuvToBitmapCompat(imageBuffer.getData(), imageBuffer.getF(), imageBuffer.getG());
    }

    public static final Bitmap toBitmapFast(ImageBuffer imageBuffer, Context context) {
        Intrinsics.checkNotNullParameter(imageBuffer, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return PictureHelper.YuvToBitmap(context, imageBuffer.getData(), imageBuffer.getF(), imageBuffer.getG());
    }
}
