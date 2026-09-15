package in.gov.eci.bloapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.api.service.UserClient;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectoralListModule_ProvideRetrofitServiceElectorsListFactory implements Factory<UserClient> {
    private final ElectoralListModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ElectoralListModule_ProvideRetrofitServiceElectorsListFactory(ElectoralListModule module, Provider<Retrofit> retrofitProvider) {
        this.module = module;
        this.retrofitProvider = retrofitProvider;
    }

    @Override // javax.inject.Provider
    public UserClient get() {
        return provideRetrofitServiceElectorsList(this.module, this.retrofitProvider.get());
    }

    public static ElectoralListModule_ProvideRetrofitServiceElectorsListFactory create(ElectoralListModule module, Provider<Retrofit> retrofitProvider) {
        return new ElectoralListModule_ProvideRetrofitServiceElectorsListFactory(module, retrofitProvider);
    }

    public static UserClient provideRetrofitServiceElectorsList(ElectoralListModule instance, Retrofit retrofit) {
        return (UserClient) Preconditions.checkNotNullFromProvides(instance.provideRetrofitServiceElectorsList(retrofit));
    }
}
