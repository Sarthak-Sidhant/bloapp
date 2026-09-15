package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class OverseasDetailsRepository_MembersInjector implements MembersInjector<OverseasDetailsRepository> {
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public OverseasDetailsRepository_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    public static MembersInjector<OverseasDetailsRepository> create(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new OverseasDetailsRepository_MembersInjector(dbHandlerProvider, eciDatabaseProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OverseasDetailsRepository instance) {
        injectDbHandler(instance, this.dbHandlerProvider.get());
        injectEciDatabase(instance, this.eciDatabaseProvider.get());
    }

    public static void injectDbHandler(OverseasDetailsRepository instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }

    public static void injectEciDatabase(OverseasDetailsRepository instance, EciDatabase eciDatabase) {
        instance.eciDatabase = eciDatabase;
    }
}
