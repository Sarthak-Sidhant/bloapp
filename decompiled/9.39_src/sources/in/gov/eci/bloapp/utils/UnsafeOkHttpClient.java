package in.gov.eci.bloapp.utils;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UnsafeOkHttpClient {
    static /* synthetic */ boolean lambda$getUnsafeOkHttpClient$0(String str, SSLSession sSLSession) {
        return true;
    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: in.gov.eci.bloapp.utils.UnsafeOkHttpClient.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(socketFactory, (X509TrustManager) trustManagerArr[0]);
            builder.hostnameVerifier(new HostnameVerifier() { // from class: in.gov.eci.bloapp.utils.UnsafeOkHttpClient$$ExternalSyntheticLambda0
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return UnsafeOkHttpClient.lambda$getUnsafeOkHttpClient$0(str, sSLSession);
                }
            });
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
