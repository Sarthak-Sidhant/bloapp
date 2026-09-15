package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class OkHttpFactory {
    public static OkHttpClient createDefault(Context context) {
        SSLFactoryHelper.SSLParams sSLParams = SSLFactoryHelper.getSSLParams(context, new int[]{context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", context.getPackageName()), context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", context.getPackageName())});
        return new OkHttpClient.Builder().sslSocketFactory(sSLParams.sslSocketFactory, sSLParams.trustManager).protocols(Collections.singletonList(Protocol.HTTP_1_1)).connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(0L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
    }
}
