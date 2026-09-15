package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DraftRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DraftinformsViewModel_Factory implements Factory<DraftinformsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DraftRepository> repoProvider;

    public DraftinformsViewModel_Factory(Provider<DraftRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DraftinformsViewModel m653get() {
        DraftinformsViewModel draftinformsViewModelNewInstance = newInstance((DraftRepository) this.repoProvider.get());
        DraftinformsViewModel_MembersInjector.injectApiInterface(draftinformsViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return draftinformsViewModelNewInstance;
    }

    public static DraftinformsViewModel_Factory create(Provider<DraftRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new DraftinformsViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static DraftinformsViewModel newInstance(DraftRepository repo) {
        return new DraftinformsViewModel(repo);
    }
}
