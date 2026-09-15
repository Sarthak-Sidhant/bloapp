package in.gov.eci.bloapp.languagetransliteration.db;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public abstract class AppDatabase extends RoomDatabase {
    static final Migration MIGRATION_1_2 = new Migration(1, 2) { // from class: in.gov.eci.bloapp.languagetransliteration.db.AppDatabase.1
        public void migrate(SupportSQLiteDatabase database) {
        }
    };

    public abstract MasterDAO masterDAO();
}
