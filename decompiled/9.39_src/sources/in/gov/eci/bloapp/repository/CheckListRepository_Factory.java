package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CheckListRepository_Factory implements Factory<CheckListRepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<Utils> utilsProvider;

    public CheckListRepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<Utils> utilsProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.utilsProvider = utilsProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CheckListRepository m599get() {
        CheckListRepository checkListRepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        CheckListRepository_MembersInjector.injectDbHandler(checkListRepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        CheckListRepository_MembersInjector.injectUtils(checkListRepositoryNewInstance, (Utils) this.utilsProvider.get());
        return checkListRepositoryNewInstance;
    }

    public static CheckListRepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<Utils> utilsProvider) {
        return new CheckListRepository_Factory(apiInterfaceProvider, dbHandlerProvider, utilsProvider);
    }

    public static CheckListRepository newInstance(ApiInterface apiInterface) {
        return new CheckListRepository(apiInterface);
    }
}
