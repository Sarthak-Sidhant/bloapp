package in.gov.eci.bloapp.utils;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SSLFactoryHelper {

    public static class SSLParams {
        public final SSLSocketFactory sslSocketFactory;
        public final X509TrustManager trustManager;

        public SSLParams(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            this.sslSocketFactory = sslSocketFactory;
            this.trustManager = trustManager;
        }
    }

    public static SSLParams getSSLParams(Context context, int certResId) {
        X509TrustManager x509TrustManager;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(certResId);
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(inputStreamOpenRawResource);
            inputStreamOpenRawResource.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", certificateGenerateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    x509TrustManager = null;
                    break;
                }
                TrustManager trustManager = trustManagers[i];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i++;
            }
            if (x509TrustManager == null) {
                throw new IllegalStateException("No X509TrustManager found");
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            return new SSLParams(sSLContext.getSocketFactory(), x509TrustManager);
        } catch (Exception e) {
            throw new RuntimeException("Error creating SSL factory", e);
        }
    }

    public static SSLParams getSSLParams(Context context, int[] certResIds) {
        X509TrustManager x509TrustManager;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            for (int i = 0; i < certResIds.length; i++) {
                InputStream inputStreamOpenRawResource = context.getResources().openRawResource(certResIds[i]);
                try {
                    keyStore.setCertificateEntry("ca-" + i, certificateFactory.generateCertificate(inputStreamOpenRawResource));
                    if (inputStreamOpenRawResource != null) {
                        inputStreamOpenRawResource.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenRawResource != null) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    x509TrustManager = null;
                    break;
                }
                TrustManager trustManager = trustManagers[i2];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i2++;
            }
            if (x509TrustManager == null) {
                throw new IllegalStateException("No X509TrustManager found");
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            return new SSLParams(sSLContext.getSocketFactory(), x509TrustManager);
        } catch (Exception e) {
            throw new RuntimeException("Error creating SSL factory", e);
        }
    }
}
