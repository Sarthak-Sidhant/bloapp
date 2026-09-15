package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.api.service.UserClient;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectoralListModule_ProvideRetrofitServiceElectorsListFactory implements Factory<UserClient> {
    private final ElectoralListModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ElectoralListModule_ProvideRetrofitServiceElectorsListFactory(ElectoralListModule module, Provider<Retrofit> retrofitProvider) {
        this.module = module;
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public UserClient m592get() {
        return provideRetrofitServiceElectorsList(this.module, (Retrofit) this.retrofitProvider.get());
    }

    public static ElectoralListModule_ProvideRetrofitServiceElectorsListFactory create(ElectoralListModule module, Provider<Retrofit> retrofitProvider) {
        return new ElectoralListModule_ProvideRetrofitServiceElectorsListFactory(module, retrofitProvider);
    }

    public static UserClient provideRetrofitServiceElectorsList(ElectoralListModule instance, Retrofit retrofit) {
        return (UserClient) Preconditions.checkNotNullFromProvides(instance.provideRetrofitServiceElectorsList(retrofit));
    }
}
