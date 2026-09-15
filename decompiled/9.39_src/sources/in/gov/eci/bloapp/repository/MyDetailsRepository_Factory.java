package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MyDetailsRepository_Factory implements Factory<MyDetailsRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public MyDetailsRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MyDetailsRepository m608get() {
        MyDetailsRepository myDetailsRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        MyDetailsRepository_MembersInjector.injectDbHandler(myDetailsRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        MyDetailsRepository_MembersInjector.injectEciDatabase(myDetailsRepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return myDetailsRepositoryNewInstance;
    }

    public static MyDetailsRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new MyDetailsRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static MyDetailsRepository newInstance(ApiInterface apiInterface) {
        return new MyDetailsRepository(apiInterface);
    }
}
