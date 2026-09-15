package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MainActivityViewModel_MembersInjector implements MembersInjector<MainActivityViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public MainActivityViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<MainActivityViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new MainActivityViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainActivityViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(MainActivityViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
