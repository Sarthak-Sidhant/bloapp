package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FormsRepo;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<FormsRepo> repoProvider;

    public LoginViewModel_Factory(Provider<FormsRepo> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public LoginViewModel get() {
        LoginViewModel loginViewModelNewInstance = newInstance(this.repoProvider.get());
        LoginViewModel_MembersInjector.injectApiInterface(loginViewModelNewInstance, this.apiInterfaceProvider.get());
        return loginViewModelNewInstance;
    }

    public static LoginViewModel_Factory create(Provider<FormsRepo> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new LoginViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static LoginViewModel newInstance(FormsRepo repo) {
        return new LoginViewModel(repo);
    }
}
