package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FacilitiesRepository_Factory implements Factory<FacilitiesRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public FacilitiesRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FacilitiesRepository m604get() {
        FacilitiesRepository facilitiesRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        FacilitiesRepository_MembersInjector.injectDbHandler(facilitiesRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        FacilitiesRepository_MembersInjector.injectEciDatabase(facilitiesRepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return facilitiesRepositoryNewInstance;
    }

    public static FacilitiesRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new FacilitiesRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static FacilitiesRepository newInstance(ApiInterface apiInterface) {
        return new FacilitiesRepository(apiInterface);
    }
}
