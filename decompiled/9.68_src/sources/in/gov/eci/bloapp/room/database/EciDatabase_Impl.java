package in.gov.eci.bloapp.room.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import in.gov.eci.bloapp.room.dao.BoothDao;
import in.gov.eci.bloapp.room.dao.BoothDao_Impl;
import in.gov.eci.bloapp.room.dao.GrevianceDao;
import in.gov.eci.bloapp.room.dao.GrevianceDao_Impl;
import in.gov.eci.bloapp.room.dao.RegistrationDao;
import in.gov.eci.bloapp.room.dao.RegistrationDao_Impl;
import in.gov.eci.bloapp.room.dao.VoterChangeDao;
import in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl;
import in.gov.eci.bloapp.room.dao.VoterDetailsDao;
import in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class EciDatabase_Impl extends EciDatabase {
    private volatile BoothDao _boothDao;
    private volatile GrevianceDao _grevianceDao;
    private volatile RegistrationDao _registrationDao;
    private volatile VoterChangeDao _voterChangeDao;
    private volatile VoterDetailsDao _voterDetailsDao;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m625createOpenDelegate() {
        return new RoomOpenDelegate(1, "426dc91bc8ea9c5e5b65f0210abb5908", "3b9b4275b9b00dd87bcbaa8c0eef851f") { // from class: in.gov.eci.bloapp.room.database.EciDatabase_Impl.1
            public void onCreate(final SQLiteConnection connection) {
            }

            public void onPostMigrate(final SQLiteConnection connection) {
            }

            public void createAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `BOOTH_LOCATOR` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `BOOTH_ID` TEXT, `AERO_NAME` TEXT, `AERO_MOBILE_NUMBER` INTEGER, `BLO_NAME` TEXT, `BLO_MOBILE_NUMBER` INTEGER, `ERO_NAME` TEXT, `ERO_MOBILE_NUMBER` INTEGER, `DEO_NAME` TEXT, `DEO_MOBILE_NUMBER` INTEGER, `ASSEMBLY_CONSTITUENCY` TEXT, `PARLIAMENT_CONSTITUENCY` TEXT, `POLLING_STATION` TEXT, `ELECTION_TYPE` TEXT, `ELECTION_YEAR` INTEGER)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `GREVIANCE_DETAILS` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `MOBILE_NUMBER` TEXT, `STATE` TEXT, `DISTRICT` TEXT, `CONSTITUENCY` TEXT, `CATEGORY` TEXT, `SUBCATEGORY` TEXT, `SUBJECT_TYPE` TEXT, `INCIDENT` TEXT, `FORM` TEXT, `REFERENCE_NUMBER` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `REGISTRATION_TABLE` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `FIRST_NAME` TEXT, `LAST_NAME` TEXT, `MOBILE_NUMBER` TEXT, `EMAIL_ID` TEXT, `PASSWORD` TEXT, `EPIC_NUMBER` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `VOTER_CHANGE_REQUEST` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `NAME` TEXT, `FATHER_NAME` TEXT, `STATE` TEXT, `DISTRICT` TEXT, `ASSEMBLY_CONSTITUENCY` TEXT, `STATUS` TEXT, `PWD_MOBILE_NUMBER` TEXT, `HOUSE_NUMBER` TEXT, `STREET` TEXT, `TOWN` TEXT, `POSTOFFICE` TEXT, `CHANGE_TYPE` TEXT, `PINCODE` TEXT, `REQUEST_TYPE` TEXT, `PART_NUMBER` TEXT, `EPIC_NUMBER` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `VOTER_DETAILS` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `FIRST_NAME` TEXT, `LAST_NAME` TEXT, `FATHER_NAME` TEXT, `MOBILE_NUMBER` TEXT, `AGE` TEXT, `GENDER` TEXT, `CONSTITUENCY` TEXT, `EPIC_NUMBER` TEXT, `STATE` TEXT, `DISTRICT` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '426dc91bc8ea9c5e5b65f0210abb5908')");
            }

            public void dropAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `BOOTH_LOCATOR`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `GREVIANCE_DETAILS`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `REGISTRATION_TABLE`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `VOTER_CHANGE_REQUEST`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `VOTER_DETAILS`");
            }

            public void onOpen(final SQLiteConnection connection) {
                EciDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(final SQLiteConnection connection) {
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(final SQLiteConnection connection) {
                HashMap map = new HashMap(15);
                map.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, (String) null, 1));
                map.put("BOOTH_ID", new TableInfo.Column("BOOTH_ID", "TEXT", false, 0, (String) null, 1));
                map.put("AERO_NAME", new TableInfo.Column("AERO_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("AERO_MOBILE_NUMBER", new TableInfo.Column("AERO_MOBILE_NUMBER", "INTEGER", false, 0, (String) null, 1));
                map.put("BLO_NAME", new TableInfo.Column("BLO_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("BLO_MOBILE_NUMBER", new TableInfo.Column("BLO_MOBILE_NUMBER", "INTEGER", false, 0, (String) null, 1));
                map.put("ERO_NAME", new TableInfo.Column("ERO_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("ERO_MOBILE_NUMBER", new TableInfo.Column("ERO_MOBILE_NUMBER", "INTEGER", false, 0, (String) null, 1));
                map.put("DEO_NAME", new TableInfo.Column("DEO_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("DEO_MOBILE_NUMBER", new TableInfo.Column("DEO_MOBILE_NUMBER", "INTEGER", false, 0, (String) null, 1));
                map.put("ASSEMBLY_CONSTITUENCY", new TableInfo.Column("ASSEMBLY_CONSTITUENCY", "TEXT", false, 0, (String) null, 1));
                map.put("PARLIAMENT_CONSTITUENCY", new TableInfo.Column("PARLIAMENT_CONSTITUENCY", "TEXT", false, 0, (String) null, 1));
                map.put("POLLING_STATION", new TableInfo.Column("POLLING_STATION", "TEXT", false, 0, (String) null, 1));
                map.put("ELECTION_TYPE", new TableInfo.Column("ELECTION_TYPE", "TEXT", false, 0, (String) null, 1));
                map.put("ELECTION_YEAR", new TableInfo.Column("ELECTION_YEAR", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("BOOTH_LOCATOR", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(connection, "BOOTH_LOCATOR");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "BOOTH_LOCATOR(in.gov.eci.bloapp.room.roommodel.BoothModel).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(11);
                map2.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, (String) null, 1));
                map2.put("MOBILE_NUMBER", new TableInfo.Column("MOBILE_NUMBER", "TEXT", false, 0, (String) null, 1));
                map2.put("STATE", new TableInfo.Column("STATE", "TEXT", false, 0, (String) null, 1));
                map2.put("DISTRICT", new TableInfo.Column("DISTRICT", "TEXT", false, 0, (String) null, 1));
                map2.put("CONSTITUENCY", new TableInfo.Column("CONSTITUENCY", "TEXT", false, 0, (String) null, 1));
                map2.put("CATEGORY", new TableInfo.Column("CATEGORY", "TEXT", false, 0, (String) null, 1));
                map2.put("SUBCATEGORY", new TableInfo.Column("SUBCATEGORY", "TEXT", false, 0, (String) null, 1));
                map2.put("SUBJECT_TYPE", new TableInfo.Column("SUBJECT_TYPE", "TEXT", false, 0, (String) null, 1));
                map2.put("INCIDENT", new TableInfo.Column("INCIDENT", "TEXT", false, 0, (String) null, 1));
                map2.put("FORM", new TableInfo.Column("FORM", "TEXT", false, 0, (String) null, 1));
                map2.put("REFERENCE_NUMBER", new TableInfo.Column("REFERENCE_NUMBER", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("GREVIANCE_DETAILS", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(connection, "GREVIANCE_DETAILS");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "GREVIANCE_DETAILS(in.gov.eci.bloapp.room.roommodel.GrevianceModel).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(7);
                map3.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, (String) null, 1));
                map3.put("FIRST_NAME", new TableInfo.Column("FIRST_NAME", "TEXT", false, 0, (String) null, 1));
                map3.put("LAST_NAME", new TableInfo.Column("LAST_NAME", "TEXT", false, 0, (String) null, 1));
                map3.put("MOBILE_NUMBER", new TableInfo.Column("MOBILE_NUMBER", "TEXT", false, 0, (String) null, 1));
                map3.put("EMAIL_ID", new TableInfo.Column("EMAIL_ID", "TEXT", false, 0, (String) null, 1));
                map3.put("PASSWORD", new TableInfo.Column("PASSWORD", "TEXT", false, 0, (String) null, 1));
                map3.put("EPIC_NUMBER", new TableInfo.Column("EPIC_NUMBER", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("REGISTRATION_TABLE", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(connection, "REGISTRATION_TABLE");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "REGISTRATION_TABLE(in.gov.eci.bloapp.room.roommodel.RegistrationModel).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(17);
                map4.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, (String) null, 1));
                map4.put("NAME", new TableInfo.Column("NAME", "TEXT", false, 0, (String) null, 1));
                map4.put("FATHER_NAME", new TableInfo.Column("FATHER_NAME", "TEXT", false, 0, (String) null, 1));
                map4.put("STATE", new TableInfo.Column("STATE", "TEXT", false, 0, (String) null, 1));
                map4.put("DISTRICT", new TableInfo.Column("DISTRICT", "TEXT", false, 0, (String) null, 1));
                map4.put("ASSEMBLY_CONSTITUENCY", new TableInfo.Column("ASSEMBLY_CONSTITUENCY", "TEXT", false, 0, (String) null, 1));
                map4.put("STATUS", new TableInfo.Column("STATUS", "TEXT", false, 0, (String) null, 1));
                map4.put("PWD_MOBILE_NUMBER", new TableInfo.Column("PWD_MOBILE_NUMBER", "TEXT", false, 0, (String) null, 1));
                map4.put("HOUSE_NUMBER", new TableInfo.Column("HOUSE_NUMBER", "TEXT", false, 0, (String) null, 1));
                map4.put("STREET", new TableInfo.Column("STREET", "TEXT", false, 0, (String) null, 1));
                map4.put("TOWN", new TableInfo.Column("TOWN", "TEXT", false, 0, (String) null, 1));
                map4.put("POSTOFFICE", new TableInfo.Column("POSTOFFICE", "TEXT", false, 0, (String) null, 1));
                map4.put("CHANGE_TYPE", new TableInfo.Column("CHANGE_TYPE", "TEXT", false, 0, (String) null, 1));
                map4.put("PINCODE", new TableInfo.Column("PINCODE", "TEXT", false, 0, (String) null, 1));
                map4.put("REQUEST_TYPE", new TableInfo.Column("REQUEST_TYPE", "TEXT", false, 0, (String) null, 1));
                map4.put("PART_NUMBER", new TableInfo.Column("PART_NUMBER", "TEXT", false, 0, (String) null, 1));
                map4.put("EPIC_NUMBER", new TableInfo.Column("EPIC_NUMBER", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("VOTER_CHANGE_REQUEST", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(connection, "VOTER_CHANGE_REQUEST");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "VOTER_CHANGE_REQUEST(in.gov.eci.bloapp.room.roommodel.VoterChangeModel).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(11);
                map5.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, (String) null, 1));
                map5.put("FIRST_NAME", new TableInfo.Column("FIRST_NAME", "TEXT", false, 0, (String) null, 1));
                map5.put("LAST_NAME", new TableInfo.Column("LAST_NAME", "TEXT", false, 0, (String) null, 1));
                map5.put("FATHER_NAME", new TableInfo.Column("FATHER_NAME", "TEXT", false, 0, (String) null, 1));
                map5.put("MOBILE_NUMBER", new TableInfo.Column("MOBILE_NUMBER", "TEXT", false, 0, (String) null, 1));
                map5.put("AGE", new TableInfo.Column("AGE", "TEXT", false, 0, (String) null, 1));
                map5.put("GENDER", new TableInfo.Column("GENDER", "TEXT", false, 0, (String) null, 1));
                map5.put("CONSTITUENCY", new TableInfo.Column("CONSTITUENCY", "TEXT", false, 0, (String) null, 1));
                map5.put("EPIC_NUMBER", new TableInfo.Column("EPIC_NUMBER", "TEXT", false, 0, (String) null, 1));
                map5.put("STATE", new TableInfo.Column("STATE", "TEXT", false, 0, (String) null, 1));
                map5.put("DISTRICT", new TableInfo.Column("DISTRICT", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo9 = new TableInfo("VOTER_DETAILS", map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(connection, "VOTER_DETAILS");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenDelegate.ValidationResult(false, "VOTER_DETAILS(in.gov.eci.bloapp.room.roommodel.VoterDetailsModel).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"BOOTH_LOCATOR", "GREVIANCE_DETAILS", "REGISTRATION_TABLE", "VOTER_CHANGE_REQUEST", "VOTER_DETAILS"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"BOOTH_LOCATOR", "GREVIANCE_DETAILS", "REGISTRATION_TABLE", "VOTER_CHANGE_REQUEST", "VOTER_DETAILS"});
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(BoothDao.class, BoothDao_Impl.getRequiredConverters());
        map.put(GrevianceDao.class, GrevianceDao_Impl.getRequiredConverters());
        map.put(RegistrationDao.class, RegistrationDao_Impl.getRequiredConverters());
        map.put(VoterChangeDao.class, VoterChangeDao_Impl.getRequiredConverters());
        map.put(VoterDetailsDao.class, VoterDetailsDao_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // in.gov.eci.bloapp.room.database.EciDatabase
    public BoothDao boothDao() {
        BoothDao boothDao;
        if (this._boothDao != null) {
            return this._boothDao;
        }
        synchronized (this) {
            if (this._boothDao == null) {
                this._boothDao = new BoothDao_Impl(this);
            }
            boothDao = this._boothDao;
        }
        return boothDao;
    }

    @Override // in.gov.eci.bloapp.room.database.EciDatabase
    public GrevianceDao grevianceDao() {
        GrevianceDao grevianceDao;
        if (this._grevianceDao != null) {
            return this._grevianceDao;
        }
        synchronized (this) {
            if (this._grevianceDao == null) {
                this._grevianceDao = new GrevianceDao_Impl(this);
            }
            grevianceDao = this._grevianceDao;
        }
        return grevianceDao;
    }

    @Override // in.gov.eci.bloapp.room.database.EciDatabase
    public RegistrationDao registrationDao() {
        RegistrationDao registrationDao;
        if (this._registrationDao != null) {
            return this._registrationDao;
        }
        synchronized (this) {
            if (this._registrationDao == null) {
                this._registrationDao = new RegistrationDao_Impl(this);
            }
            registrationDao = this._registrationDao;
        }
        return registrationDao;
    }

    @Override // in.gov.eci.bloapp.room.database.EciDatabase
    public VoterChangeDao voterChangeDao() {
        VoterChangeDao voterChangeDao;
        if (this._voterChangeDao != null) {
            return this._voterChangeDao;
        }
        synchronized (this) {
            if (this._voterChangeDao == null) {
                this._voterChangeDao = new VoterChangeDao_Impl(this);
            }
            voterChangeDao = this._voterChangeDao;
        }
        return voterChangeDao;
    }

    @Override // in.gov.eci.bloapp.room.database.EciDatabase
    public VoterDetailsDao voterDetailsDao() {
        VoterDetailsDao voterDetailsDao;
        if (this._voterDetailsDao != null) {
            return this._voterDetailsDao;
        }
        synchronized (this) {
            if (this._voterDetailsDao == null) {
                this._voterDetailsDao = new VoterDetailsDao_Impl(this);
            }
            voterDetailsDao = this._voterDetailsDao;
        }
        return voterDetailsDao;
    }
}
