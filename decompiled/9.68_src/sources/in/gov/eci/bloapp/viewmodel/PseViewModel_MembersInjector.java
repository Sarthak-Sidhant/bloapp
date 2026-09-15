package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class PseViewModel_MembersInjector implements MembersInjector<PseViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public PseViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<PseViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new PseViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PseViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(PseViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
