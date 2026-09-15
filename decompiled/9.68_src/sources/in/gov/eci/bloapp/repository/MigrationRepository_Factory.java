package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MigrationRepository_Factory implements Factory<MigrationRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public MigrationRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public MigrationRepository get() {
        MigrationRepository migrationRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        MigrationRepository_MembersInjector.injectDbHandler(migrationRepositoryNewInstance, this.dbHandlerProvider.get());
        MigrationRepository_MembersInjector.injectEciDatabase(migrationRepositoryNewInstance, this.eciDatabaseProvider.get());
        return migrationRepositoryNewInstance;
    }

    public static MigrationRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new MigrationRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static MigrationRepository newInstance(ApiInterface apiInterface) {
        return new MigrationRepository(apiInterface);
    }
}
