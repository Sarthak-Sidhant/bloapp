package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectoralListModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;
    private final ElectoralListModule module;

    public ElectoralListModule_ProvideHttpClientFactory(ElectoralListModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
        this.module = module;
        this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
    }

    public OkHttpClient get() {
        return provideHttpClient(this.module, (HttpLoggingInterceptor) this.httpLoggingInterceptorProvider.get());
    }

    public static ElectoralListModule_ProvideHttpClientFactory create(ElectoralListModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
        return new ElectoralListModule_ProvideHttpClientFactory(module, httpLoggingInterceptorProvider);
    }

    public static OkHttpClient provideHttpClient(ElectoralListModule instance, HttpLoggingInterceptor httpLoggingInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(instance.provideHttpClient(httpLoggingInterceptor));
    }
}
