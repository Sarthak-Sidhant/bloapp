package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MainRepository_Factory implements Factory<MainRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public MainRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public MainRepository get() {
        MainRepository mainRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        MainRepository_MembersInjector.injectDbHandler(mainRepositoryNewInstance, this.dbHandlerProvider.get());
        MainRepository_MembersInjector.injectEciDatabase(mainRepositoryNewInstance, this.eciDatabaseProvider.get());
        return mainRepositoryNewInstance;
    }

    public static MainRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new MainRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static MainRepository newInstance(ApiInterface apiInterface) {
        return new MainRepository(apiInterface);
    }
}
