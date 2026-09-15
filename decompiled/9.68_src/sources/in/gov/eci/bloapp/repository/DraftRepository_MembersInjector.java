package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DraftRepository_MembersInjector implements MembersInjector<DraftRepository> {
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public DraftRepository_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    public static MembersInjector<DraftRepository> create(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new DraftRepository_MembersInjector(dbHandlerProvider, eciDatabaseProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DraftRepository instance) {
        injectDbHandler(instance, this.dbHandlerProvider.get());
        injectEciDatabase(instance, this.eciDatabaseProvider.get());
    }

    public static void injectDbHandler(DraftRepository instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }

    public static void injectEciDatabase(DraftRepository instance, EciDatabase eciDatabase) {
        instance.eciDatabase = eciDatabase;
    }
}
