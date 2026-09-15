package in.gov.eci.bloapp.languagetransliteration.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile MasterDAO _masterDAO;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m594createOpenDelegate() {
        return new RoomOpenDelegate(1, "b1f269e66b44dc6af1953d9bf781c650", "c1cb825c558bf78b85bdbf3377d8c1c8") { // from class: in.gov.eci.bloapp.languagetransliteration.db.AppDatabase_Impl.1
            public void onCreate(final SQLiteConnection connection) {
            }

            public void onPostMigrate(final SQLiteConnection connection) {
            }

            public void createAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `table_state` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `state_name` TEXT, `state_code` TEXT, `status` INTEGER NOT NULL DEFAULT 1)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `table_district` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `dist_name` TEXT, `state_code` TEXT, `dist_code` TEXT, `core_document_enabled` INTEGER NOT NULL DEFAULT true, `status` INTEGER NOT NULL DEFAULT 1)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `table_ac` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ac_name` TEXT, `ac_code` TEXT, `state_code` TEXT, `dist_code` TEXT, `st_lang_code` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b1f269e66b44dc6af1953d9bf781c650')");
            }

            public void dropAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `table_state`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `table_district`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `table_ac`");
            }

            public void onOpen(final SQLiteConnection connection) {
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(final SQLiteConnection connection) {
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(final SQLiteConnection connection) {
                HashMap map = new HashMap(4);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map.put("state_name", new TableInfo.Column("state_name", "TEXT", false, 0, (String) null, 1));
                map.put("state_code", new TableInfo.Column("state_code", "TEXT", false, 0, (String) null, 1));
                map.put("status", new TableInfo.Column("status", "INTEGER", true, 0, "1", 1));
                TableInfo tableInfo = new TableInfo("table_state", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(connection, "table_state");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "table_state(in.gov.eci.bloapp.languagetransliteration.db.TState).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(6);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map2.put("dist_name", new TableInfo.Column("dist_name", "TEXT", false, 0, (String) null, 1));
                map2.put("state_code", new TableInfo.Column("state_code", "TEXT", false, 0, (String) null, 1));
                map2.put("dist_code", new TableInfo.Column("dist_code", "TEXT", false, 0, (String) null, 1));
                map2.put("core_document_enabled", new TableInfo.Column("core_document_enabled", "INTEGER", true, 0, "true", 1));
                map2.put("status", new TableInfo.Column("status", "INTEGER", true, 0, "1", 1));
                TableInfo tableInfo3 = new TableInfo("table_district", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(connection, "table_district");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "table_district(in.gov.eci.bloapp.languagetransliteration.db.TDistrict).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(6);
                map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map3.put("ac_name", new TableInfo.Column("ac_name", "TEXT", false, 0, (String) null, 1));
                map3.put("ac_code", new TableInfo.Column("ac_code", "TEXT", false, 0, (String) null, 1));
                map3.put("state_code", new TableInfo.Column("state_code", "TEXT", false, 0, (String) null, 1));
                map3.put("dist_code", new TableInfo.Column("dist_code", "TEXT", false, 0, (String) null, 1));
                map3.put("st_lang_code", new TableInfo.Column("st_lang_code", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("table_ac", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(connection, "table_ac");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "table_ac(in.gov.eci.bloapp.languagetransliteration.db.TAc).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"table_state", "table_district", "table_ac"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"table_state", "table_district", "table_ac"});
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(MasterDAO.class, MasterDAO_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.AppDatabase
    public MasterDAO masterDAO() {
        MasterDAO masterDAO;
        if (this._masterDAO != null) {
            return this._masterDAO;
        }
        synchronized (this) {
            if (this._masterDAO == null) {
                this._masterDAO = new MasterDAO_Impl(this);
            }
            masterDAO = this._masterDAO;
        }
        return masterDAO;
    }
}
