package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MigrationRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class PreviewViewModel_Factory implements Factory<PreviewViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;

    public PreviewViewModel_Factory(Provider<MigrationRepository> migrationRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.migrationRepositoryProvider = migrationRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public PreviewViewModel get() {
        PreviewViewModel previewViewModelNewInstance = newInstance(this.migrationRepositoryProvider.get());
        PreviewViewModel_MembersInjector.injectApiInterface(previewViewModelNewInstance, this.apiInterfaceProvider.get());
        return previewViewModelNewInstance;
    }

    public static PreviewViewModel_Factory create(Provider<MigrationRepository> migrationRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new PreviewViewModel_Factory(migrationRepositoryProvider, apiInterfaceProvider);
    }

    public static PreviewViewModel newInstance(MigrationRepository migrationRepository) {
        return new PreviewViewModel(migrationRepository);
    }
}
