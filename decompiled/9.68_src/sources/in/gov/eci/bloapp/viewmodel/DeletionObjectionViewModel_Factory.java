package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeletionObjectionViewModel_Factory implements Factory<DeletionObjectionViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider;

    public DeletionObjectionViewModel_Factory(Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.deletionObjectionRepositoryProvider = deletionObjectionRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public DeletionObjectionViewModel get() {
        DeletionObjectionViewModel deletionObjectionViewModelNewInstance = newInstance(this.deletionObjectionRepositoryProvider.get());
        DeletionObjectionViewModel_MembersInjector.injectApiInterface(deletionObjectionViewModelNewInstance, this.apiInterfaceProvider.get());
        return deletionObjectionViewModelNewInstance;
    }

    public static DeletionObjectionViewModel_Factory create(Provider<DeletionObjectionRepository> deletionObjectionRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new DeletionObjectionViewModel_Factory(deletionObjectionRepositoryProvider, apiInterfaceProvider);
    }

    public static DeletionObjectionViewModel newInstance(DeletionObjectionRepository deletionObjectionRepository) {
        return new DeletionObjectionViewModel(deletionObjectionRepository);
    }
}
