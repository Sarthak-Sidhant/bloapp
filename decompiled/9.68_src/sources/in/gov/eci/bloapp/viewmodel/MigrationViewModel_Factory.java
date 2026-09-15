package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.MigrationRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MigrationViewModel_Factory implements Factory<MigrationViewModel> {
    private final Provider<MigrationRepository> migrationRepositoryProvider;

    public MigrationViewModel_Factory(Provider<MigrationRepository> migrationRepositoryProvider) {
        this.migrationRepositoryProvider = migrationRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public MigrationViewModel get() {
        return newInstance(this.migrationRepositoryProvider.get());
    }

    public static MigrationViewModel_Factory create(Provider<MigrationRepository> migrationRepositoryProvider) {
        return new MigrationViewModel_Factory(migrationRepositoryProvider);
    }

    public static MigrationViewModel newInstance(MigrationRepository migrationRepository) {
        return new MigrationViewModel(migrationRepository);
    }
}
