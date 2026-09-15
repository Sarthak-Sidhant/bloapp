package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FormsRepo_Factory implements Factory<FormsRepo> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public FormsRepo_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FormsRepo m605get() {
        FormsRepo formsRepoNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        FormsRepo_MembersInjector.injectDbHandler(formsRepoNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        FormsRepo_MembersInjector.injectEciDatabase(formsRepoNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return formsRepoNewInstance;
    }

    public static FormsRepo_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new FormsRepo_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static FormsRepo newInstance(ApiInterface apiInterface) {
        return new FormsRepo(apiInterface);
    }
}
