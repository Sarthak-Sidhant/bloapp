package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CheckListRepository_MembersInjector implements MembersInjector<CheckListRepository> {
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<Utils> utilsProvider;

    public CheckListRepository_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider, Provider<Utils> utilsProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<CheckListRepository> create(Provider<DatabaseHelper> dbHandlerProvider, Provider<Utils> utilsProvider) {
        return new CheckListRepository_MembersInjector(dbHandlerProvider, utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CheckListRepository instance) {
        injectDbHandler(instance, (DatabaseHelper) this.dbHandlerProvider.get());
        injectUtils(instance, (Utils) this.utilsProvider.get());
    }

    public static void injectDbHandler(CheckListRepository instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }

    public static void injectUtils(CheckListRepository instance, Utils utils) {
        instance.utils = utils;
    }
}
