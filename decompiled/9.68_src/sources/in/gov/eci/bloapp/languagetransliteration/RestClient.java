package in.gov.eci.bloapp.languagetransliteration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface RestClient {
    @GET
    Call<String> transliteration(@Url String url, @Header("Content-Type") String content);
}
