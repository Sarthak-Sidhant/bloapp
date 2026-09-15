package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CompatHelper {
    public static void removeGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void setViewBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static Bitmap convertYuvImageToBitmap(Context context, byte[] bArr, int i, int i2) {
        if (context != null) {
            return PictureHelper.YuvToBitmap(context, bArr, i, i2);
        }
        return PictureHelper.YuvToBitmapCompat(bArr, i, i2);
    }
}
