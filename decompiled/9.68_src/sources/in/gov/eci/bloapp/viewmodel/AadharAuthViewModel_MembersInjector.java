package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AadharAuthViewModel_MembersInjector implements MembersInjector<AadharAuthViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public AadharAuthViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<AadharAuthViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new AadharAuthViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AadharAuthViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(AadharAuthViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
