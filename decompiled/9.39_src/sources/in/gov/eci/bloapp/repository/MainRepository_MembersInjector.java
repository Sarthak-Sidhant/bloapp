package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MainRepository_MembersInjector implements MembersInjector<MainRepository> {
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public MainRepository_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    public static MembersInjector<MainRepository> create(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new MainRepository_MembersInjector(dbHandlerProvider, eciDatabaseProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainRepository instance) {
        injectDbHandler(instance, (DatabaseHelper) this.dbHandlerProvider.get());
        injectEciDatabase(instance, (EciDatabase) this.eciDatabaseProvider.get());
    }

    public static void injectDbHandler(MainRepository instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }

    public static void injectEciDatabase(MainRepository instance, EciDatabase eciDatabase) {
        instance.eciDatabase = eciDatabase;
    }
}
