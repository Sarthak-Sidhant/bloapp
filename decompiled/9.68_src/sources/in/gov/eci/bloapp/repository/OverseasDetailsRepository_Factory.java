package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class OverseasDetailsRepository_Factory implements Factory<OverseasDetailsRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public OverseasDetailsRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public OverseasDetailsRepository get() {
        OverseasDetailsRepository overseasDetailsRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        OverseasDetailsRepository_MembersInjector.injectDbHandler(overseasDetailsRepositoryNewInstance, this.dbHandlerProvider.get());
        OverseasDetailsRepository_MembersInjector.injectEciDatabase(overseasDetailsRepositoryNewInstance, this.eciDatabaseProvider.get());
        return overseasDetailsRepositoryNewInstance;
    }

    public static OverseasDetailsRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new OverseasDetailsRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static OverseasDetailsRepository newInstance(ApiInterface apiInterface) {
        return new OverseasDetailsRepository(apiInterface);
    }
}
