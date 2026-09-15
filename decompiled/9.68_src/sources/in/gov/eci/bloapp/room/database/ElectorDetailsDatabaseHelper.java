package in.gov.eci.bloapp.room.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao;
import in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao;
import in.gov.eci.bloapp.room.dao.HouseSurveyModelDao;
import in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class ElectorDetailsDatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "ElectorDetailsDB";
    static final Migration MIGRATION_1_2;
    static final Migration MIGRATION_2_3;
    static final Migration MIGRATION_3_4;
    private static ElectorDetailsDatabaseHelper instance;

    public abstract H2HElectorDetailModelDao h2HElectorDetailModelDao();

    public abstract H2HSurveyStatusDao h2HSurveyStatusDao();

    public abstract HouseSurveyModelDao houseSurveyModelDao();

    public abstract PartElectorDetailsModelDao partElectorDetailsModelDao();

    public static synchronized ElectorDetailsDatabaseHelper getDB(Context context) {
        if (instance == null) {
            ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper = (ElectorDetailsDatabaseHelper) Room.databaseBuilder(context, ElectorDetailsDatabaseHelper.class, DB_NAME).addMigrations(new Migration[]{MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4}).fallbackToDestructiveMigration().allowMainThreadQueries().build();
            instance = electorDetailsDatabaseHelper;
            electorDetailsDatabaseHelper.getOpenHelper().getWritableDatabase();
        }
        return instance;
    }

    static {
        int i = 2;
        MIGRATION_1_2 = new Migration(1, i) { // from class: in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper.1
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("ALTER TABLE h2h_elector_details  ADD COLUMN metInPerson Int");
                supportSQLiteDatabase.execSQL("ALTER TABLE h2h_elector_details  ADD COLUMN phoneNumberVerified String");
            }
        };
        int i2 = 3;
        MIGRATION_2_3 = new Migration(i, i2) { // from class: in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper.2
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("ALTER TABLE h2h_elector_details  ADD COLUMN metInPerson String");
                supportSQLiteDatabase.execSQL("ALTER TABLE h2h_elector_details  ADD COLUMN phoneNumberVerified String");
            }
        };
        MIGRATION_3_4 = new Migration(i2, 4) { // from class: in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper.3
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("ALTER TABLE h2h_elector_details  ADD COLUMN partSerialNumber TEXT");
                supportSQLiteDatabase.execSQL("ALTER TABLE PART_ELECTOR_DETAILS ADD COLUMN partSerialNumber TEXT");
            }
        };
    }
}
