package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DraftRepository_Factory implements Factory<DraftRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public DraftRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DraftRepository m602get() {
        DraftRepository draftRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        DraftRepository_MembersInjector.injectDbHandler(draftRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        DraftRepository_MembersInjector.injectEciDatabase(draftRepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return draftRepositoryNewInstance;
    }

    public static DraftRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new DraftRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static DraftRepository newInstance(ApiInterface apiInterface) {
        return new DraftRepository(apiInterface);
    }
}
