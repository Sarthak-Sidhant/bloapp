package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class LoginViewModel_MembersInjector implements MembersInjector<LoginViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public LoginViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<LoginViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new LoginViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LoginViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(LoginViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
