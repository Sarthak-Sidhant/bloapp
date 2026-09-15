package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FormsRepo;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FormsViewModel_Factory implements Factory<FormsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<FormsRepo> repoProvider;

    public FormsViewModel_Factory(Provider<FormsRepo> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FormsViewModel m662get() {
        FormsViewModel formsViewModelNewInstance = newInstance((FormsRepo) this.repoProvider.get());
        FormsViewModel_MembersInjector.injectApiInterface(formsViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return formsViewModelNewInstance;
    }

    public static FormsViewModel_Factory create(Provider<FormsRepo> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new FormsViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static FormsViewModel newInstance(FormsRepo repo) {
        return new FormsViewModel(repo);
    }
}
