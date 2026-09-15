package in.gov.eci.bloapp.languagetransliteration.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DBClient {
    private static final String DB_NAME = "vha_state";
    private static DBClient mInstance;
    private final AppDatabase appDatabase;
    public Context mCtx;
    private final RoomDatabase.Callback roomCallback;

    private DBClient(Context mCtx) {
        RoomDatabase.Callback callback = new RoomDatabase.Callback() { // from class: in.gov.eci.bloapp.languagetransliteration.db.DBClient.1
            public void onCreate(SupportSQLiteDatabase db) {
                super.onCreate(db);
            }
        };
        this.roomCallback = callback;
        this.mCtx = mCtx;
        this.appDatabase = (AppDatabase) Room.databaseBuilder(mCtx, AppDatabase.class, DB_NAME).addCallback(callback).allowMainThreadQueries().build();
    }

    public static synchronized DBClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DBClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return this.appDatabase;
    }
}
