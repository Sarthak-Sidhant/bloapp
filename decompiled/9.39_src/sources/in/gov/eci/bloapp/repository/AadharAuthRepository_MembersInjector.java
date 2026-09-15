package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AadharAuthRepository_MembersInjector implements MembersInjector<AadharAuthRepository> {
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public AadharAuthRepository_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    public static MembersInjector<AadharAuthRepository> create(Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new AadharAuthRepository_MembersInjector(dbHandlerProvider, eciDatabaseProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AadharAuthRepository instance) {
        injectDbHandler(instance, (DatabaseHelper) this.dbHandlerProvider.get());
        injectEciDatabase(instance, (EciDatabase) this.eciDatabaseProvider.get());
    }

    public static void injectDbHandler(AadharAuthRepository instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }

    public static void injectEciDatabase(AadharAuthRepository instance, EciDatabase eciDatabase) {
        instance.eciDatabase = eciDatabase;
    }
}
