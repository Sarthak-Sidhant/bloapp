package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectoralListModule_ProvideConverterFactoryFactory implements Factory<GsonConverterFactory> {
    private final ElectoralListModule module;

    public ElectoralListModule_ProvideConverterFactoryFactory(ElectoralListModule module) {
        this.module = module;
    }

    public GsonConverterFactory get() {
        return provideConverterFactory(this.module);
    }

    public static ElectoralListModule_ProvideConverterFactoryFactory create(ElectoralListModule module) {
        return new ElectoralListModule_ProvideConverterFactoryFactory(module);
    }

    public static GsonConverterFactory provideConverterFactory(ElectoralListModule instance) {
        return (GsonConverterFactory) Preconditions.checkNotNullFromProvides(instance.provideConverterFactory());
    }
}
