package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AllApplicationRepository_Factory implements Factory<AllApplicationRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public AllApplicationRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public AllApplicationRepository get() {
        AllApplicationRepository allApplicationRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        AllApplicationRepository_MembersInjector.injectDbHandler(allApplicationRepositoryNewInstance, this.dbHandlerProvider.get());
        AllApplicationRepository_MembersInjector.injectEciDatabase(allApplicationRepositoryNewInstance, this.eciDatabaseProvider.get());
        return allApplicationRepositoryNewInstance;
    }

    public static AllApplicationRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new AllApplicationRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static AllApplicationRepository newInstance(ApiInterface apiInterface) {
        return new AllApplicationRepository(apiInterface);
    }
}
