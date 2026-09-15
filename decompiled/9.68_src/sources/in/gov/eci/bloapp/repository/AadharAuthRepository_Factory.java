package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AadharAuthRepository_Factory implements Factory<AadharAuthRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public AadharAuthRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public AadharAuthRepository get() {
        AadharAuthRepository aadharAuthRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        AadharAuthRepository_MembersInjector.injectDbHandler(aadharAuthRepositoryNewInstance, this.dbHandlerProvider.get());
        AadharAuthRepository_MembersInjector.injectEciDatabase(aadharAuthRepositoryNewInstance, this.eciDatabaseProvider.get());
        return aadharAuthRepositoryNewInstance;
    }

    public static AadharAuthRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new AadharAuthRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static AadharAuthRepository newInstance(ApiInterface apiInterface) {
        return new AadharAuthRepository(apiInterface);
    }
}
