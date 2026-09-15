package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeletionObjectionRepository_Factory implements Factory<DeletionObjectionRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public DeletionObjectionRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public DeletionObjectionRepository get() {
        DeletionObjectionRepository deletionObjectionRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        DeletionObjectionRepository_MembersInjector.injectDbHandler(deletionObjectionRepositoryNewInstance, this.dbHandlerProvider.get());
        DeletionObjectionRepository_MembersInjector.injectEciDatabase(deletionObjectionRepositoryNewInstance, this.eciDatabaseProvider.get());
        return deletionObjectionRepositoryNewInstance;
    }

    public static DeletionObjectionRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new DeletionObjectionRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static DeletionObjectionRepository newInstance(ApiInterface apiInterface) {
        return new DeletionObjectionRepository(apiInterface);
    }
}
