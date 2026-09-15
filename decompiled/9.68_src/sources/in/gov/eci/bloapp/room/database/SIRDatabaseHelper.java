package in.gov.eci.bloapp.room.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import in.gov.eci.bloapp.room.dao.ListDataDao;
import in.gov.eci.bloapp.room.dao.SpecialRevisionDao;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class SIRDatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "SIRDetailsDB";
    private static SIRDatabaseHelper instance;

    public abstract ListDataDao ListDataDao();

    public abstract SpecialRevisionDao SpecialRevisionDao();

    public static synchronized SIRDatabaseHelper getDB(Context context) {
        if (instance == null) {
            SIRDatabaseHelper sIRDatabaseHelper = (SIRDatabaseHelper) Room.databaseBuilder(context, SIRDatabaseHelper.class, DB_NAME).allowMainThreadQueries().build();
            instance = sIRDatabaseHelper;
            sIRDatabaseHelper.getOpenHelper().getWritableDatabase();
        }
        return instance;
    }
}
