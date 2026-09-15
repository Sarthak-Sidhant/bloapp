package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DraftinformsViewModel_MembersInjector implements MembersInjector<DraftinformsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public DraftinformsViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<DraftinformsViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new DraftinformsViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DraftinformsViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(DraftinformsViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
