package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SSLUtil {
    private SSLUtil() {
    }

    public static SSLSocketFactory buildSSLSocketFactory(Context ctx, int caResId, X509TrustManager[] outTrustManagerHolder) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream inputStreamOpenRawResource = ctx.getResources().openRawResource(caResId);
        try {
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(inputStreamOpenRawResource);
            inputStreamOpenRawResource.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("custom_ca", certificateGenerateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                    outTrustManagerHolder[0] = x509TrustManager;
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                    return sSLContext.getSocketFactory();
                }
            }
            throw new IllegalStateException("Unexpected default trust managers: " + Arrays.toString(trustManagers));
        } catch (Throwable th) {
            inputStreamOpenRawResource.close();
            throw th;
        }
    }
}
