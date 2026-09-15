package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class HonbleCommissionViewModel_MembersInjector implements MembersInjector<HonbleCommissionViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<RestClient> restClientProvider;

    public HonbleCommissionViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider, Provider<RestClient> restClientProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.restClientProvider = restClientProvider;
    }

    public static MembersInjector<HonbleCommissionViewModel> create(Provider<ApiInterface> apiInterfaceProvider, Provider<RestClient> restClientProvider) {
        return new HonbleCommissionViewModel_MembersInjector(apiInterfaceProvider, restClientProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HonbleCommissionViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
        injectRestClient(instance, (RestClient) this.restClientProvider.get());
    }

    public static void injectApiInterface(HonbleCommissionViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }

    public static void injectRestClient(HonbleCommissionViewModel instance, RestClient restClient) {
        instance.restClient = restClient;
    }
}
