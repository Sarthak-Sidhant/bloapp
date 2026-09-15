package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class OverseasDetailsRepository_Factory implements Factory<OverseasDetailsRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public OverseasDetailsRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public OverseasDetailsRepository m610get() {
        OverseasDetailsRepository overseasDetailsRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        OverseasDetailsRepository_MembersInjector.injectDbHandler(overseasDetailsRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        OverseasDetailsRepository_MembersInjector.injectEciDatabase(overseasDetailsRepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return overseasDetailsRepositoryNewInstance;
    }

    public static OverseasDetailsRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new OverseasDetailsRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static OverseasDetailsRepository newInstance(ApiInterface apiInterface) {
        return new OverseasDetailsRepository(apiInterface);
    }
}
