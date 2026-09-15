package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloNotificationRepo_Factory implements Factory<BloNotificationRepo> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;

    public BloNotificationRepo_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BloNotificationRepo m598get() {
        BloNotificationRepo bloNotificationRepoNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        BloNotificationRepo_MembersInjector.injectDbHandler(bloNotificationRepoNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        return bloNotificationRepoNewInstance;
    }

    public static BloNotificationRepo_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider) {
        return new BloNotificationRepo_Factory(apiInterfaceProvider, dbHandlerProvider);
    }

    public static BloNotificationRepo newInstance(ApiInterface apiInterface) {
        return new BloNotificationRepo(apiInterface);
    }
}
