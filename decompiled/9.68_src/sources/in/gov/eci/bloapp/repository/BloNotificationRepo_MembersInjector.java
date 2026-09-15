package in.gov.eci.bloapp.repository;

import dagger.MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloNotificationRepo_MembersInjector implements MembersInjector<BloNotificationRepo> {
    private final Provider<DatabaseHelper> dbHandlerProvider;

    public BloNotificationRepo_MembersInjector(Provider<DatabaseHelper> dbHandlerProvider) {
        this.dbHandlerProvider = dbHandlerProvider;
    }

    public static MembersInjector<BloNotificationRepo> create(Provider<DatabaseHelper> dbHandlerProvider) {
        return new BloNotificationRepo_MembersInjector(dbHandlerProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BloNotificationRepo instance) {
        injectDbHandler(instance, this.dbHandlerProvider.get());
    }

    public static void injectDbHandler(BloNotificationRepo instance, DatabaseHelper dbHandler) {
        instance.dbHandler = dbHandler;
    }
}
