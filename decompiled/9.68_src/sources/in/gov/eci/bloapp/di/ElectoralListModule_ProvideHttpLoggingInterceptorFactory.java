package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectoralListModule_ProvideHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    private final ElectoralListModule module;

    public ElectoralListModule_ProvideHttpLoggingInterceptorFactory(ElectoralListModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    public HttpLoggingInterceptor get() {
        return provideHttpLoggingInterceptor(this.module);
    }

    public static ElectoralListModule_ProvideHttpLoggingInterceptorFactory create(ElectoralListModule module) {
        return new ElectoralListModule_ProvideHttpLoggingInterceptorFactory(module);
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor(ElectoralListModule instance) {
        return (HttpLoggingInterceptor) Preconditions.checkNotNullFromProvides(instance.provideHttpLoggingInterceptor());
    }
}
