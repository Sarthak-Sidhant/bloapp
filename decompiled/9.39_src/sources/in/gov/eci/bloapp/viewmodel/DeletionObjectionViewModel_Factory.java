package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DeletionObjectionViewModel_Factory implements Factory<DeletionObjectionViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider;

    public DeletionObjectionViewModel_Factory(Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.deletionObjectionRepositoryProvider = deletionObjectionRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeletionObjectionViewModel m647get() {
        DeletionObjectionViewModel deletionObjectionViewModelNewInstance = newInstance((DeletionObjectionRepository) this.deletionObjectionRepositoryProvider.get());
        DeletionObjectionViewModel_MembersInjector.injectApiInterface(deletionObjectionViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return deletionObjectionViewModelNewInstance;
    }

    public static DeletionObjectionViewModel_Factory create(Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new DeletionObjectionViewModel_Factory(deletionObjectionRepositoryProvider, apiInterfaceProvider);
    }

    public static DeletionObjectionViewModel newInstance(DeletionObjectionRepository deletionObjectionRepository) {
        return new DeletionObjectionViewModel(deletionObjectionRepository);
    }
}
