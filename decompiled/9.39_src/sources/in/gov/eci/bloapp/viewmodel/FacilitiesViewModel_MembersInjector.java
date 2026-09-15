package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FacilitiesViewModel_MembersInjector implements MembersInjector<FacilitiesViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public FacilitiesViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<FacilitiesViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new FacilitiesViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FacilitiesViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(FacilitiesViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
