package in.gov.eci.bloapp.repository;

import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.model.app_model.HonbleCommissionModel;
import in.gov.eci.bloapp.network.ApiEndPoints;
import in.gov.eci.bloapp.network.ApiInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HonbleCommissionRepository {
    private ApiInterface apiInterface;
    private final RestClient restClient;

    public HonbleCommissionRepository(RestClient restClient) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        this.restClient = (RestClient) new Retrofit.Builder().baseUrl(ApiEndPoints.HONBLE_COMMISSION_BASE_URL).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create()).build().create(RestClient.class);
    }

    public void makeHonbleCommissionApiCall(String key, String page, String featured, String sortDir, final MutableLiveData<HonbleCommissionModel> honbleCommissionModelMutableLiveData) {
        this.restClient.getHonbleCommissionData(key, page, featured, sortDir).enqueue(new Callback<HonbleCommissionModel>() { // from class: in.gov.eci.bloapp.repository.HonbleCommissionRepository.1
            public void onResponse(Call<HonbleCommissionModel> call, Response<HonbleCommissionModel> response) {
                if (response.isSuccessful()) {
                    honbleCommissionModelMutableLiveData.postValue((HonbleCommissionModel) response.body());
                } else {
                    honbleCommissionModelMutableLiveData.postValue((Object) null);
                }
            }

            public void onFailure(Call<HonbleCommissionModel> call, Throwable t) {
                honbleCommissionModelMutableLiveData.postValue((Object) null);
            }
        });
    }
}
