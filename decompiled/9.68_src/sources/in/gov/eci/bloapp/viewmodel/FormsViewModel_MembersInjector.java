package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class FormsViewModel_MembersInjector implements MembersInjector<FormsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public FormsViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<FormsViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new FormsViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FormsViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(FormsViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
