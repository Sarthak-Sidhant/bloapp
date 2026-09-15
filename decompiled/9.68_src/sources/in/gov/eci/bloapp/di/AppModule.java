package in.gov.eci.bloapp.di;

import android.content.Context;
import android.provider.Settings;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import in.gov.eci.bloapp.network.ApiEndPoints;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Module
public class AppModule {
    @Provides
    @Singleton
    public EciDatabase provideEciDatabase(Context context) {
        return (EciDatabase) Room.databaseBuilder(context, EciDatabase.class, "sample.db").build();
    }

    @Provides
    @Singleton
    public DatabaseHelper getDatabase(Context context) {
        return new DatabaseHelper(context);
    }

    @Provides
    @Singleton
    public Retrofit getApiClient(final Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();
        new HttpLoggingInterceptor().level(HttpLoggingInterceptor.Level.BODY);
        return new Retrofit.Builder().baseUrl(ApiEndPoints.LOGIN_BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.newBuilder().connectTimeout(120L, TimeUnit.SECONDS).readTimeout(120L, TimeUnit.SECONDS).writeTimeout(120L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: in.gov.eci.bloapp.di.AppModule.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                return chain.proceed(request.newBuilder().header("Content-Type", "application/json").addHeader("authKey", "kdkd").addHeader("PLATFORM-TYPE", "ANDROIDMOB").header("DEVICE-ID", Settings.Secure.getString(context.getContentResolver(), "android_id")).method(request.method(), request.body()).build());
            }
        }).build()).build();
    }

    @Provides
    @Singleton
    public ApiInterface getApiInterface(Retrofit retrofit) {
        return (ApiInterface) retrofit.create(ApiInterface.class);
    }
}
