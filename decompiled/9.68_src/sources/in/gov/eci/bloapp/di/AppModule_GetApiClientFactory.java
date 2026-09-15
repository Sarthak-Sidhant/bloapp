package in.gov.eci.bloapp.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AppModule_GetApiClientFactory implements Factory<Retrofit> {
    private final Provider<Context> contextProvider;
    private final AppModule module;

    public AppModule_GetApiClientFactory(AppModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public Retrofit get() {
        return getApiClient(this.module, this.contextProvider.get());
    }

    public static AppModule_GetApiClientFactory create(AppModule module, Provider<Context> contextProvider) {
        return new AppModule_GetApiClientFactory(module, contextProvider);
    }

    public static Retrofit getApiClient(AppModule instance, Context context) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(instance.getApiClient(context));
    }
}
