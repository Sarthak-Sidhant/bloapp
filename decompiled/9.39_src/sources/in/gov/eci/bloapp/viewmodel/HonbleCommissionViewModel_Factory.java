package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class HonbleCommissionViewModel_Factory implements Factory<HonbleCommissionViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<RestClient> restClientProvider;

    public HonbleCommissionViewModel_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<RestClient> restClientProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.restClientProvider = restClientProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public HonbleCommissionViewModel m665get() {
        HonbleCommissionViewModel honbleCommissionViewModelNewInstance = newInstance();
        HonbleCommissionViewModel_MembersInjector.injectApiInterface(honbleCommissionViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        HonbleCommissionViewModel_MembersInjector.injectRestClient(honbleCommissionViewModelNewInstance, (RestClient) this.restClientProvider.get());
        return honbleCommissionViewModelNewInstance;
    }

    public static HonbleCommissionViewModel_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<RestClient> restClientProvider) {
        return new HonbleCommissionViewModel_Factory(apiInterfaceProvider, restClientProvider);
    }

    public static HonbleCommissionViewModel newInstance() {
        return new HonbleCommissionViewModel();
    }
}
