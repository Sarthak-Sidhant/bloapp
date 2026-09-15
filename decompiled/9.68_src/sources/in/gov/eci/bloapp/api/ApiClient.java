package in.gov.eci.bloapp.api;

import android.content.Context;
import android.provider.Settings;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ApiClient {
    static CommomUtility commomUtility = new CommomUtility();
    private static Retrofit retrofitLogin;
    private static Retrofit retrofitLogin1;
    private static Retrofit retrofitLogin12;

    public static Retrofit getClient(final Context context) {
        SSLFactoryHelper.SSLParams sSLParams = SSLFactoryHelper.getSSLParams(context, new int[]{context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", context.getPackageName()), context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", context.getPackageName())});
        String str = commomUtility.baseurl;
        if (retrofitLogin == null) {
            retrofitLogin = new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().sslSocketFactory(sSLParams.sslSocketFactory, sSLParams.trustManager).addInterceptor(new Interceptor() { // from class: in.gov.eci.bloapp.api.ApiClient.1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    return chain.proceed(request.newBuilder().header("DEVICE-ID", Settings.Secure.getString(context.getContentResolver(), "android_id")).header("platform-type", "ANDROIDMOB").header("app_version", ApiClient.commomUtility.appversion).build());
                }
            }).build()).build();
        }
        return retrofitLogin;
    }

    public static Retrofit getClient1(final Context context) {
        SSLFactoryHelper.SSLParams sSLParams = SSLFactoryHelper.getSSLParams(context, new int[]{context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", context.getPackageName()), context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", context.getPackageName())});
        String str = commomUtility.baseurl;
        if (retrofitLogin1 == null) {
            retrofitLogin1 = new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().sslSocketFactory(sSLParams.sslSocketFactory, sSLParams.trustManager).connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: in.gov.eci.bloapp.api.ApiClient.2
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    return chain.proceed(request.newBuilder().header("DEVICE-ID", Settings.Secure.getString(context.getContentResolver(), "android_id")).header("platform-type", "ANDROIDMOB").header("app_version", ApiClient.commomUtility.appversion).build());
                }
            }).build()).build();
        }
        return retrofitLogin1;
    }

    public static Retrofit getClient2(final Context context) {
        SSLFactoryHelper.SSLParams sSLParams = SSLFactoryHelper.getSSLParams(context, new int[]{context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", context.getPackageName()), context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", context.getPackageName())});
        String str = commomUtility.baseurl2;
        if (retrofitLogin12 == null) {
            retrofitLogin12 = new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().sslSocketFactory(sSLParams.sslSocketFactory, sSLParams.trustManager).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: in.gov.eci.bloapp.api.ApiClient.3
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    return chain.proceed(request.newBuilder().header("DEVICE-ID", Settings.Secure.getString(context.getContentResolver(), "android_id")).header("platform-type", "ANDROIDMOB").header("app_version", ApiClient.commomUtility.appversion).build());
                }
            }).build()).build();
        }
        return retrofitLogin12;
    }

    public static Retrofit getEronetLogin() {
        String str = commomUtility.baseurl;
        if (retrofitLogin == null) {
            OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
            new GsonBuilder().setLenient().create();
            retrofitLogin = new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild).build();
        }
        return retrofitLogin;
    }
}
