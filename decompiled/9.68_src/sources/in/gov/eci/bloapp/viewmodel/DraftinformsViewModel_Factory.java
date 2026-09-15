package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DraftRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DraftinformsViewModel_Factory implements Factory<DraftinformsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DraftRepository> repoProvider;

    public DraftinformsViewModel_Factory(Provider<DraftRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public DraftinformsViewModel get() {
        DraftinformsViewModel draftinformsViewModelNewInstance = newInstance(this.repoProvider.get());
        DraftinformsViewModel_MembersInjector.injectApiInterface(draftinformsViewModelNewInstance, this.apiInterfaceProvider.get());
        return draftinformsViewModelNewInstance;
    }

    public static DraftinformsViewModel_Factory create(Provider<DraftRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new DraftinformsViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static DraftinformsViewModel newInstance(DraftRepository repo) {
        return new DraftinformsViewModel(repo);
    }
}
