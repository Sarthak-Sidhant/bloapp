package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeletionObjectionViewModel_MembersInjector implements MembersInjector<DeletionObjectionViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public DeletionObjectionViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<DeletionObjectionViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new DeletionObjectionViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DeletionObjectionViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(DeletionObjectionViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
