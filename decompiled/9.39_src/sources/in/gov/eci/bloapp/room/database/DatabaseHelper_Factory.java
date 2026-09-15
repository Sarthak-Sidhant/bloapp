package in.gov.eci.bloapp.room.database;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DatabaseHelper_Factory implements Factory<DatabaseHelper> {
    private final Provider<Context> contextProvider;

    public DatabaseHelper_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DatabaseHelper m616get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static DatabaseHelper_Factory create(Provider<Context> contextProvider) {
        return new DatabaseHelper_Factory(contextProvider);
    }

    public static DatabaseHelper newInstance(Context context) {
        return new DatabaseHelper(context);
    }
}
