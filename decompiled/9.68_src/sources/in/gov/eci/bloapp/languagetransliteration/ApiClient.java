package in.gov.eci.bloapp.languagetransliteration;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ApiClient {
    public static final String ECI_BASE_LANGUAGE_URL = "https://transservice.ecinet.in/api/";
    private static Retrofit retrofitTransliteration;

    public static Retrofit getTransliterationClient() {
        if (retrofitTransliteration == null) {
            retrofitTransliteration = new Retrofit.Builder().baseUrl(ECI_BASE_LANGUAGE_URL).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(30L, TimeUnit.SECONDS).build()).build();
        }
        return retrofitTransliteration;
    }
}
