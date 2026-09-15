package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MigrationRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class PreviewEpicViewModel_Factory implements Factory<PreviewEpicViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;

    public PreviewEpicViewModel_Factory(Provider<MigrationRepository> migrationRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.migrationRepositoryProvider = migrationRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public PreviewEpicViewModel get() {
        PreviewEpicViewModel previewEpicViewModelNewInstance = newInstance(this.migrationRepositoryProvider.get());
        PreviewEpicViewModel_MembersInjector.injectApiInterface(previewEpicViewModelNewInstance, this.apiInterfaceProvider.get());
        return previewEpicViewModelNewInstance;
    }

    public static PreviewEpicViewModel_Factory create(Provider<MigrationRepository> migrationRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new PreviewEpicViewModel_Factory(migrationRepositoryProvider, apiInterfaceProvider);
    }

    public static PreviewEpicViewModel newInstance(MigrationRepository migrationRepository) {
        return new PreviewEpicViewModel(migrationRepository);
    }
}
