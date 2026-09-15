package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AppModule_GetApiInterfaceFactory implements Factory<ApiInterface> {
    private final AppModule module;
    private final Provider<Retrofit> retrofitProvider;

    public AppModule_GetApiInterfaceFactory(AppModule module, Provider<Retrofit> retrofitProvider) {
        this.module = module;
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ApiInterface m543get() {
        return getApiInterface(this.module, (Retrofit) this.retrofitProvider.get());
    }

    public static AppModule_GetApiInterfaceFactory create(AppModule module, Provider<Retrofit> retrofitProvider) {
        return new AppModule_GetApiInterfaceFactory(module, retrofitProvider);
    }

    public static ApiInterface getApiInterface(AppModule instance, Retrofit retrofit) {
        return (ApiInterface) Preconditions.checkNotNullFromProvides(instance.getApiInterface(retrofit));
    }
}
