package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.PseRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class PseViewModel_Factory implements Factory<PseViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<PseRepository> repoProvider;

    public PseViewModel_Factory(Provider<PseRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public PseViewModel get() {
        PseViewModel pseViewModelNewInstance = newInstance(this.repoProvider.get());
        PseViewModel_MembersInjector.injectApiInterface(pseViewModelNewInstance, this.apiInterfaceProvider.get());
        return pseViewModelNewInstance;
    }

    public static PseViewModel_Factory create(Provider<PseRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new PseViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static PseViewModel newInstance(PseRepository repo) {
        return new PseViewModel(repo);
    }
}
