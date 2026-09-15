package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeviceCompatibilityRepository_Factory implements Factory<DeviceCompatibilityRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public DeviceCompatibilityRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public DeviceCompatibilityRepository get() {
        DeviceCompatibilityRepository deviceCompatibilityRepositoryNewInstance = newInstance(this.apiInterfaceProvider.get());
        DeviceCompatibilityRepository_MembersInjector.injectDbHandler(deviceCompatibilityRepositoryNewInstance, this.dbHandlerProvider.get());
        DeviceCompatibilityRepository_MembersInjector.injectEciDatabase(deviceCompatibilityRepositoryNewInstance, this.eciDatabaseProvider.get());
        return deviceCompatibilityRepositoryNewInstance;
    }

    public static DeviceCompatibilityRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new DeviceCompatibilityRepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static DeviceCompatibilityRepository newInstance(ApiInterface apiInterface) {
        return new DeviceCompatibilityRepository(apiInterface);
    }
}
