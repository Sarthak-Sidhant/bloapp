package in.gov.eci.bloapp.di;

import dagger.Module;
import dagger.Provides;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.utils.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Module
public class ElectoralListModule {
    CommomUtility commomUtility = new CommomUtility();

    static /* synthetic */ boolean lambda$provideHttpClient$0(String str, SSLSession sSLSession) {
        return true;
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: in.gov.eci.bloapp.di.ElectoralListModule.1
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
            return new OkHttpClient.Builder().readTimeout(15L, TimeUnit.SECONDS).connectTimeout(15L, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]).hostnameVerifier(new HostnameVerifier() { // from class: in.gov.eci.bloapp.di.ElectoralListModule$$ExternalSyntheticLambda0
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return ElectoralListModule.lambda$provideHttpClient$0(str, sSLSession);
                }
            }).build();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            Logger.d("", e.getMessage());
            return null;
        }
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    @Named("retrofit")
    public Retrofit provideRetrofitElectorsList(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).client(okHttpClient).addConverterFactory(gsonConverterFactory).build();
    }

    @Provides
    @Singleton
    public UserClient provideRetrofitServiceElectorsList(@Named("retrofit") Retrofit retrofit) {
        return (UserClient) retrofit.create(UserClient.class);
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }
}
