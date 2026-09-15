package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PseRepository_Factory implements Factory<PseRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public PseRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PseRepository m611get() {
        PseRepository pseRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        PseRepository_MembersInjector.injectDbHandler(pseRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        PseRepository_MembersInjector.injectEciDatabase(pseRepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return pseRepositoryNewInstance;
    }

    public static PseRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new PseRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static PseRepository newInstance(ApiInterface apiInterface) {
        return new PseRepository(apiInterface);
    }
}
