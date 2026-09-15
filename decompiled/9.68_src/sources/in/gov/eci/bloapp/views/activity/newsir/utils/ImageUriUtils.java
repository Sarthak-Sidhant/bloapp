package in.gov.eci.bloapp.views.activity.newsir.utils;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ImageUriUtils {
    private ImageUriUtils() {
    }

    public static Uri createCacheImageUri(Context ctx, String fileName) {
        File file = new File(ctx.getCacheDir(), "crops");
        if (!file.exists()) {
            file.mkdirs();
        }
        return FileProvider.getUriForFile(ctx, ctx.getPackageName() + ".provider", new File(file, fileName));
    }
}
