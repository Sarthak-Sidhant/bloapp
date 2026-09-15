package in.gov.eci.bloapp.room.database;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import in.gov.eci.bloapp.room.dao.BoothDao;
import in.gov.eci.bloapp.room.dao.GrevianceDao;
import in.gov.eci.bloapp.room.dao.RegistrationDao;
import in.gov.eci.bloapp.room.dao.VoterChangeDao;
import in.gov.eci.bloapp.room.dao.VoterDetailsDao;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class EciDatabase extends RoomDatabase {
    public static Migration MIGRATION_1_2 = new Migration(1, 2) { // from class: in.gov.eci.bloapp.room.database.EciDatabase.1
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE BOOTH_LOCATOR  ADD COLUMN pub_year INTEGER");
        }
    };

    public abstract BoothDao boothDao();

    public abstract GrevianceDao grevianceDao();

    public abstract RegistrationDao registrationDao();

    public abstract VoterChangeDao voterChangeDao();

    public abstract VoterDetailsDao voterDetailsDao();
}
