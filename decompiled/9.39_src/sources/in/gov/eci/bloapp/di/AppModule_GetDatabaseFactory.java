package in.gov.eci.bloapp.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AppModule_GetDatabaseFactory implements Factory<DatabaseHelper> {
    private final Provider<Context> contextProvider;
    private final AppModule module;

    public AppModule_GetDatabaseFactory(AppModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DatabaseHelper m544get() {
        return getDatabase(this.module, (Context) this.contextProvider.get());
    }

    public static AppModule_GetDatabaseFactory create(AppModule module, Provider<Context> contextProvider) {
        return new AppModule_GetDatabaseFactory(module, contextProvider);
    }

    public static DatabaseHelper getDatabase(AppModule instance, Context context) {
        return (DatabaseHelper) Preconditions.checkNotNullFromProvides(instance.getDatabase(context));
    }
}
