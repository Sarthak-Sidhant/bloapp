package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.CheckListRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CheckListViewModel_Factory implements Factory<CheckListViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<CheckListRepository> repoProvider;

    public CheckListViewModel_Factory(Provider<CheckListRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CheckListViewModel m644get() {
        CheckListViewModel checkListViewModelNewInstance = newInstance((CheckListRepository) this.repoProvider.get());
        CheckListViewModel_MembersInjector.injectApiInterface(checkListViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return checkListViewModelNewInstance;
    }

    public static CheckListViewModel_Factory create(Provider<CheckListRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new CheckListViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static CheckListViewModel newInstance(CheckListRepository repo) {
        return new CheckListViewModel(repo);
    }
}
