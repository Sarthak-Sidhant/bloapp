package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import in.gov.eci.bloapp.R;
import java.io.InputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MyAppGlideModule extends AppGlideModule {
    public boolean isManifestParsingEnabled() {
        return false;
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(SslHelper.buildClientTrustingRawCert(context, R.raw.stage_cert_new)));
    }
}
