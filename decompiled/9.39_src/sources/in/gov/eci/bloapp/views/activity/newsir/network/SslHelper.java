package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SslHelper {
    public static OkHttpClient buildClientTrustingRawCert(Context context, int rawResId) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(rawResId);
            try {
                Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(inputStreamOpenRawResource);
                inputStreamOpenRawResource.close();
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca", certificateGenerateCertificate);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length != 0) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
                        return new OkHttpClient.Builder().sslSocketFactory(sSLContext.getSocketFactory(), x509TrustManager).build();
                    }
                }
                throw new IllegalStateException("Unexpected trust managers");
            } catch (Throwable th) {
                inputStreamOpenRawResource.close();
                throw th;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create trusted OkHttp client", e);
        }
    }
}
