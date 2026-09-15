package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectoralListModule_ProvideRetrofitElectorsListFactory implements Factory<Retrofit> {
    private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;
    private final ElectoralListModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ElectoralListModule_ProvideRetrofitElectorsListFactory(ElectoralListModule module, Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
        this.module = module;
        this.okHttpClientProvider = okHttpClientProvider;
        this.gsonConverterFactoryProvider = gsonConverterFactoryProvider;
    }

    @Override // javax.inject.Provider
    public Retrofit get() {
        return provideRetrofitElectorsList(this.module, this.okHttpClientProvider.get(), this.gsonConverterFactoryProvider.get());
    }

    public static ElectoralListModule_ProvideRetrofitElectorsListFactory create(ElectoralListModule module, Provider<OkHttpClient> okHttpClientProvider, Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
        return new ElectoralListModule_ProvideRetrofitElectorsListFactory(module, okHttpClientProvider, gsonConverterFactoryProvider);
    }

    public static Retrofit provideRetrofitElectorsList(ElectoralListModule instance, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(instance.provideRetrofitElectorsList(okHttpClient, gsonConverterFactory));
    }
}
