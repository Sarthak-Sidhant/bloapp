package in.gov.eci.bloapp.room.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao;
import in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl;
import in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao;
import in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl;
import in.gov.eci.bloapp.room.dao.HouseSurveyModelDao;
import in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl;
import in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao;
import in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectorDetailsDatabaseHelper_Impl extends ElectorDetailsDatabaseHelper {
    private volatile H2HElectorDetailModelDao _h2HElectorDetailModelDao;
    private volatile H2HSurveyStatusDao _h2HSurveyStatusDao;
    private volatile HouseSurveyModelDao _houseSurveyModelDao;
    private volatile PartElectorDetailsModelDao _partElectorDetailsModelDao;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m626createOpenDelegate() {
        return new RoomOpenDelegate(4, "084a00ab43ea97d0c7424f25e2412cfe", "01462a5eb0850709279128fe1eb183e5") { // from class: in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper_Impl.1
            public void onCreate(final SQLiteConnection connection) {
            }

            public void onPostMigrate(final SQLiteConnection connection) {
            }

            public void createAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `PART_ELECTOR_DETAILS` (`id` INTEGER NOT NULL, `epicNo` TEXT NOT NULL, `houseNo` TEXT, `applicantName` TEXT, `applicantNameL1` TEXT, `gender` TEXT, `relativeName` TEXT, `relativeNameL1` TEXT, `relativeType` TEXT, `mobileNo` TEXT, `email` TEXT, `isElectorRecordSame` TEXT, `dob` TEXT, `dobAttachment` TEXT, `isDobRecordSame` TEXT, `addressAttachment` TEXT, `isAddressRecordSame` TEXT, `houseApplicantFound` TEXT, `allDetailsVerified` TEXT, `remarks` TEXT, `misDocument` TEXT, `dateOfVerification` TEXT, `coordinate` TEXT, `age` TEXT, `localitySreet` TEXT, `village` TEXT, `postOffice` TEXT, `pinCode` TEXT, `stateCode` TEXT, `acNo` TEXT, `partNo` TEXT, `photo` TEXT, `localitySreetL1` TEXT, `houseNoL1` TEXT, `postOfficeL1` TEXT, `villageL1` TEXT, `tehsilTalukaMandal` TEXT, `tehsilTalukaMandalL1` TEXT, `aadharNo` TEXT, `sectionNo` TEXT, `sectionName` TEXT, `pwd` TEXT, `disabilityPercentage` TEXT, `otherDisability` TEXT, `disabilityLocomotor` TEXT, `disabilitySpeechHearing` TEXT, `disabilityVisually` TEXT, `partSerialNumber` TEXT, `BLO_ID` TEXT, `MODIFIED_ON` TEXT, `LAST_SYNC_STATUS` TEXT, PRIMARY KEY(`epicNo`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `H2H_SURVEY_STATUS` (`epicNo` TEXT NOT NULL, `partName` TEXT, `acNo` INTEGER NOT NULL, `partNo` INTEGER NOT NULL, `serialNo` INTEGER NOT NULL, `applicantFirstName` TEXT, `applicantLastName` TEXT, `submissionDate` TEXT, `h2HMarking` TEXT, `form7Status` TEXT, `form8Status` TEXT, `BLO_ID` TEXT, `MODIFIED_ON` TEXT, `LAST_SYNC_STATUS` TEXT, PRIMARY KEY(`epicNo`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `H2H_ELECTOR_DETAILS` (`epicNo` TEXT NOT NULL, `applicantName` TEXT, `mobileNo` TEXT, `gender` TEXT, `email` TEXT, `aadharNo` TEXT, `dob` TEXT, `age` TEXT, `relativeName` TEXT, `relativeType` TEXT, `houseNo` TEXT, `village` TEXT, `postOffice` TEXT, `acNo` TEXT, `localitySreet` TEXT, `address` TEXT, `pinCode` TEXT, `partNo` TEXT, `stateCode` TEXT, `coordinate` TEXT, `residingPeriod` TEXT, `houseApplicantFound` TEXT, `isAadharVerified` TEXT, `isElectorRecordSame` TEXT, `allDetailsVerified` TEXT, `isAddressRecordSame` TEXT, `isDobRecordSame` TEXT, `photographEleIsCorrect` TEXT, `disabilityType` TEXT, `isVisual` TEXT, `sectionNo` TEXT, `isPwd` TEXT, `isDeaf` TEXT, `pwdPercentage` TEXT, `isLocomotive` TEXT, `otherDisability` TEXT, `metInPerson` INTEGER NOT NULL, `phoneNumberVerified` TEXT, `dateOfVerification` TEXT, `addressAttachment` TEXT, `dobAttachment` TEXT, `misDocument` TEXT, `remarks` TEXT, `sectionName` TEXT, `applicantNameRegional` TEXT, `partSerialNumber` TEXT, `relativeNameRegional` TEXT, `photo` TEXT, PRIMARY KEY(`epicNo`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `HOUSE_SURVEY_DETAILS` (`EPIC_NO` TEXT NOT NULL, `HOUSE_NO` TEXT, `SECTION_NO` TEXT, `partNo` TEXT, `BLO_ID` TEXT, `MODIFIED_ON` TEXT, `LAST_SYNC_STATUS` TEXT, PRIMARY KEY(`EPIC_NO`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '084a00ab43ea97d0c7424f25e2412cfe')");
            }

            public void dropAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `PART_ELECTOR_DETAILS`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `H2H_SURVEY_STATUS`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `H2H_ELECTOR_DETAILS`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `HOUSE_SURVEY_DETAILS`");
            }

            public void onOpen(final SQLiteConnection connection) {
                ElectorDetailsDatabaseHelper_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(final SQLiteConnection connection) {
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(final SQLiteConnection connection) {
                HashMap map = new HashMap(51);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 0, (String) null, 1));
                map.put("epicNo", new TableInfo.Column("epicNo", "TEXT", true, 1, (String) null, 1));
                map.put("houseNo", new TableInfo.Column("houseNo", "TEXT", false, 0, (String) null, 1));
                map.put("applicantName", new TableInfo.Column("applicantName", "TEXT", false, 0, (String) null, 1));
                map.put("applicantNameL1", new TableInfo.Column("applicantNameL1", "TEXT", false, 0, (String) null, 1));
                map.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, (String) null, 1));
                map.put("relativeName", new TableInfo.Column("relativeName", "TEXT", false, 0, (String) null, 1));
                map.put("relativeNameL1", new TableInfo.Column("relativeNameL1", "TEXT", false, 0, (String) null, 1));
                map.put("relativeType", new TableInfo.Column("relativeType", "TEXT", false, 0, (String) null, 1));
                map.put("mobileNo", new TableInfo.Column("mobileNo", "TEXT", false, 0, (String) null, 1));
                map.put("email", new TableInfo.Column("email", "TEXT", false, 0, (String) null, 1));
                map.put("isElectorRecordSame", new TableInfo.Column("isElectorRecordSame", "TEXT", false, 0, (String) null, 1));
                map.put("dob", new TableInfo.Column("dob", "TEXT", false, 0, (String) null, 1));
                map.put("dobAttachment", new TableInfo.Column("dobAttachment", "TEXT", false, 0, (String) null, 1));
                map.put("isDobRecordSame", new TableInfo.Column("isDobRecordSame", "TEXT", false, 0, (String) null, 1));
                map.put("addressAttachment", new TableInfo.Column("addressAttachment", "TEXT", false, 0, (String) null, 1));
                map.put("isAddressRecordSame", new TableInfo.Column("isAddressRecordSame", "TEXT", false, 0, (String) null, 1));
                map.put("houseApplicantFound", new TableInfo.Column("houseApplicantFound", "TEXT", false, 0, (String) null, 1));
                map.put("allDetailsVerified", new TableInfo.Column("allDetailsVerified", "TEXT", false, 0, (String) null, 1));
                map.put("remarks", new TableInfo.Column("remarks", "TEXT", false, 0, (String) null, 1));
                map.put("misDocument", new TableInfo.Column("misDocument", "TEXT", false, 0, (String) null, 1));
                map.put("dateOfVerification", new TableInfo.Column("dateOfVerification", "TEXT", false, 0, (String) null, 1));
                map.put("coordinate", new TableInfo.Column("coordinate", "TEXT", false, 0, (String) null, 1));
                map.put("age", new TableInfo.Column("age", "TEXT", false, 0, (String) null, 1));
                map.put("localitySreet", new TableInfo.Column("localitySreet", "TEXT", false, 0, (String) null, 1));
                map.put("village", new TableInfo.Column("village", "TEXT", false, 0, (String) null, 1));
                map.put("postOffice", new TableInfo.Column("postOffice", "TEXT", false, 0, (String) null, 1));
                map.put("pinCode", new TableInfo.Column("pinCode", "TEXT", false, 0, (String) null, 1));
                map.put("stateCode", new TableInfo.Column("stateCode", "TEXT", false, 0, (String) null, 1));
                map.put("acNo", new TableInfo.Column("acNo", "TEXT", false, 0, (String) null, 1));
                map.put("partNo", new TableInfo.Column("partNo", "TEXT", false, 0, (String) null, 1));
                map.put("photo", new TableInfo.Column("photo", "TEXT", false, 0, (String) null, 1));
                map.put("localitySreetL1", new TableInfo.Column("localitySreetL1", "TEXT", false, 0, (String) null, 1));
                map.put("houseNoL1", new TableInfo.Column("houseNoL1", "TEXT", false, 0, (String) null, 1));
                map.put("postOfficeL1", new TableInfo.Column("postOfficeL1", "TEXT", false, 0, (String) null, 1));
                map.put("villageL1", new TableInfo.Column("villageL1", "TEXT", false, 0, (String) null, 1));
                map.put("tehsilTalukaMandal", new TableInfo.Column("tehsilTalukaMandal", "TEXT", false, 0, (String) null, 1));
                map.put("tehsilTalukaMandalL1", new TableInfo.Column("tehsilTalukaMandalL1", "TEXT", false, 0, (String) null, 1));
                map.put("aadharNo", new TableInfo.Column("aadharNo", "TEXT", false, 0, (String) null, 1));
                map.put("sectionNo", new TableInfo.Column("sectionNo", "TEXT", false, 0, (String) null, 1));
                map.put("sectionName", new TableInfo.Column("sectionName", "TEXT", false, 0, (String) null, 1));
                map.put("pwd", new TableInfo.Column("pwd", "TEXT", false, 0, (String) null, 1));
                map.put("disabilityPercentage", new TableInfo.Column("disabilityPercentage", "TEXT", false, 0, (String) null, 1));
                map.put("otherDisability", new TableInfo.Column("otherDisability", "TEXT", false, 0, (String) null, 1));
                map.put("disabilityLocomotor", new TableInfo.Column("disabilityLocomotor", "TEXT", false, 0, (String) null, 1));
                map.put("disabilitySpeechHearing", new TableInfo.Column("disabilitySpeechHearing", "TEXT", false, 0, (String) null, 1));
                map.put("disabilityVisually", new TableInfo.Column("disabilityVisually", "TEXT", false, 0, (String) null, 1));
                map.put("partSerialNumber", new TableInfo.Column("partSerialNumber", "TEXT", false, 0, (String) null, 1));
                map.put("BLO_ID", new TableInfo.Column("BLO_ID", "TEXT", false, 0, (String) null, 1));
                map.put("MODIFIED_ON", new TableInfo.Column("MODIFIED_ON", "TEXT", false, 0, (String) null, 1));
                map.put("LAST_SYNC_STATUS", new TableInfo.Column("LAST_SYNC_STATUS", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("PART_ELECTOR_DETAILS", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(connection, "PART_ELECTOR_DETAILS");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PART_ELECTOR_DETAILS(in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel.Items).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(14);
                map2.put("epicNo", new TableInfo.Column("epicNo", "TEXT", true, 1, (String) null, 1));
                map2.put("partName", new TableInfo.Column("partName", "TEXT", false, 0, (String) null, 1));
                map2.put("acNo", new TableInfo.Column("acNo", "INTEGER", true, 0, (String) null, 1));
                map2.put("partNo", new TableInfo.Column("partNo", "INTEGER", true, 0, (String) null, 1));
                map2.put("serialNo", new TableInfo.Column("serialNo", "INTEGER", true, 0, (String) null, 1));
                map2.put("applicantFirstName", new TableInfo.Column("applicantFirstName", "TEXT", false, 0, (String) null, 1));
                map2.put("applicantLastName", new TableInfo.Column("applicantLastName", "TEXT", false, 0, (String) null, 1));
                map2.put("submissionDate", new TableInfo.Column("submissionDate", "TEXT", false, 0, (String) null, 1));
                map2.put("h2HMarking", new TableInfo.Column("h2HMarking", "TEXT", false, 0, (String) null, 1));
                map2.put("form7Status", new TableInfo.Column("form7Status", "TEXT", false, 0, (String) null, 1));
                map2.put("form8Status", new TableInfo.Column("form8Status", "TEXT", false, 0, (String) null, 1));
                map2.put("BLO_ID", new TableInfo.Column("BLO_ID", "TEXT", false, 0, (String) null, 1));
                map2.put("MODIFIED_ON", new TableInfo.Column("MODIFIED_ON", "TEXT", false, 0, (String) null, 1));
                map2.put("LAST_SYNC_STATUS", new TableInfo.Column("LAST_SYNC_STATUS", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("H2H_SURVEY_STATUS", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(connection, "H2H_SURVEY_STATUS");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "H2H_SURVEY_STATUS(in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel.Payload).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(48);
                map3.put("epicNo", new TableInfo.Column("epicNo", "TEXT", true, 1, (String) null, 1));
                map3.put("applicantName", new TableInfo.Column("applicantName", "TEXT", false, 0, (String) null, 1));
                map3.put("mobileNo", new TableInfo.Column("mobileNo", "TEXT", false, 0, (String) null, 1));
                map3.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, (String) null, 1));
                map3.put("email", new TableInfo.Column("email", "TEXT", false, 0, (String) null, 1));
                map3.put("aadharNo", new TableInfo.Column("aadharNo", "TEXT", false, 0, (String) null, 1));
                map3.put("dob", new TableInfo.Column("dob", "TEXT", false, 0, (String) null, 1));
                map3.put("age", new TableInfo.Column("age", "TEXT", false, 0, (String) null, 1));
                map3.put("relativeName", new TableInfo.Column("relativeName", "TEXT", false, 0, (String) null, 1));
                map3.put("relativeType", new TableInfo.Column("relativeType", "TEXT", false, 0, (String) null, 1));
                map3.put("houseNo", new TableInfo.Column("houseNo", "TEXT", false, 0, (String) null, 1));
                map3.put("village", new TableInfo.Column("village", "TEXT", false, 0, (String) null, 1));
                map3.put("postOffice", new TableInfo.Column("postOffice", "TEXT", false, 0, (String) null, 1));
                map3.put("acNo", new TableInfo.Column("acNo", "TEXT", false, 0, (String) null, 1));
                map3.put("localitySreet", new TableInfo.Column("localitySreet", "TEXT", false, 0, (String) null, 1));
                map3.put("address", new TableInfo.Column("address", "TEXT", false, 0, (String) null, 1));
                map3.put("pinCode", new TableInfo.Column("pinCode", "TEXT", false, 0, (String) null, 1));
                map3.put("partNo", new TableInfo.Column("partNo", "TEXT", false, 0, (String) null, 1));
                map3.put("stateCode", new TableInfo.Column("stateCode", "TEXT", false, 0, (String) null, 1));
                map3.put("coordinate", new TableInfo.Column("coordinate", "TEXT", false, 0, (String) null, 1));
                map3.put("residingPeriod", new TableInfo.Column("residingPeriod", "TEXT", false, 0, (String) null, 1));
                map3.put("houseApplicantFound", new TableInfo.Column("houseApplicantFound", "TEXT", false, 0, (String) null, 1));
                map3.put("isAadharVerified", new TableInfo.Column("isAadharVerified", "TEXT", false, 0, (String) null, 1));
                map3.put("isElectorRecordSame", new TableInfo.Column("isElectorRecordSame", "TEXT", false, 0, (String) null, 1));
                map3.put("allDetailsVerified", new TableInfo.Column("allDetailsVerified", "TEXT", false, 0, (String) null, 1));
                map3.put("isAddressRecordSame", new TableInfo.Column("isAddressRecordSame", "TEXT", false, 0, (String) null, 1));
                map3.put("isDobRecordSame", new TableInfo.Column("isDobRecordSame", "TEXT", false, 0, (String) null, 1));
                map3.put("photographEleIsCorrect", new TableInfo.Column("photographEleIsCorrect", "TEXT", false, 0, (String) null, 1));
                map3.put("disabilityType", new TableInfo.Column("disabilityType", "TEXT", false, 0, (String) null, 1));
                map3.put("isVisual", new TableInfo.Column("isVisual", "TEXT", false, 0, (String) null, 1));
                map3.put("sectionNo", new TableInfo.Column("sectionNo", "TEXT", false, 0, (String) null, 1));
                map3.put("isPwd", new TableInfo.Column("isPwd", "TEXT", false, 0, (String) null, 1));
                map3.put("isDeaf", new TableInfo.Column("isDeaf", "TEXT", false, 0, (String) null, 1));
                map3.put("pwdPercentage", new TableInfo.Column("pwdPercentage", "TEXT", false, 0, (String) null, 1));
                map3.put("isLocomotive", new TableInfo.Column("isLocomotive", "TEXT", false, 0, (String) null, 1));
                map3.put("otherDisability", new TableInfo.Column("otherDisability", "TEXT", false, 0, (String) null, 1));
                map3.put("metInPerson", new TableInfo.Column("metInPerson", "INTEGER", true, 0, (String) null, 1));
                map3.put("phoneNumberVerified", new TableInfo.Column("phoneNumberVerified", "TEXT", false, 0, (String) null, 1));
                map3.put("dateOfVerification", new TableInfo.Column("dateOfVerification", "TEXT", false, 0, (String) null, 1));
                map3.put("addressAttachment", new TableInfo.Column("addressAttachment", "TEXT", false, 0, (String) null, 1));
                map3.put("dobAttachment", new TableInfo.Column("dobAttachment", "TEXT", false, 0, (String) null, 1));
                map3.put("misDocument", new TableInfo.Column("misDocument", "TEXT", false, 0, (String) null, 1));
                map3.put("remarks", new TableInfo.Column("remarks", "TEXT", false, 0, (String) null, 1));
                map3.put("sectionName", new TableInfo.Column("sectionName", "TEXT", false, 0, (String) null, 1));
                map3.put("applicantNameRegional", new TableInfo.Column("applicantNameRegional", "TEXT", false, 0, (String) null, 1));
                map3.put("partSerialNumber", new TableInfo.Column("partSerialNumber", "TEXT", false, 0, (String) null, 1));
                map3.put("relativeNameRegional", new TableInfo.Column("relativeNameRegional", "TEXT", false, 0, (String) null, 1));
                map3.put("photo", new TableInfo.Column("photo", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("H2H_ELECTOR_DETAILS", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(connection, "H2H_ELECTOR_DETAILS");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenDelegate.ValidationResult(false, "H2H_ELECTOR_DETAILS(in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(7);
                map4.put("EPIC_NO", new TableInfo.Column("EPIC_NO", "TEXT", true, 1, (String) null, 1));
                map4.put("HOUSE_NO", new TableInfo.Column("HOUSE_NO", "TEXT", false, 0, (String) null, 1));
                map4.put("SECTION_NO", new TableInfo.Column("SECTION_NO", "TEXT", false, 0, (String) null, 1));
                map4.put("partNo", new TableInfo.Column("partNo", "TEXT", false, 0, (String) null, 1));
                map4.put("BLO_ID", new TableInfo.Column("BLO_ID", "TEXT", false, 0, (String) null, 1));
                map4.put("MODIFIED_ON", new TableInfo.Column("MODIFIED_ON", "TEXT", false, 0, (String) null, 1));
                map4.put("LAST_SYNC_STATUS", new TableInfo.Column("LAST_SYNC_STATUS", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("HOUSE_SURVEY_DETAILS", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(connection, "HOUSE_SURVEY_DETAILS");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenDelegate.ValidationResult(false, "HOUSE_SURVEY_DETAILS(in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel.Payload).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"PART_ELECTOR_DETAILS", "H2H_SURVEY_STATUS", "H2H_ELECTOR_DETAILS", "HOUSE_SURVEY_DETAILS"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"PART_ELECTOR_DETAILS", "H2H_SURVEY_STATUS", "H2H_ELECTOR_DETAILS", "HOUSE_SURVEY_DETAILS"});
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(PartElectorDetailsModelDao.class, PartElectorDetailsModelDao_Impl.getRequiredConverters());
        map.put(H2HElectorDetailModelDao.class, H2HElectorDetailModelDao_Impl.getRequiredConverters());
        map.put(HouseSurveyModelDao.class, HouseSurveyModelDao_Impl.getRequiredConverters());
        map.put(H2HSurveyStatusDao.class, H2HSurveyStatusDao_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper
    public PartElectorDetailsModelDao partElectorDetailsModelDao() {
        PartElectorDetailsModelDao partElectorDetailsModelDao;
        if (this._partElectorDetailsModelDao != null) {
            return this._partElectorDetailsModelDao;
        }
        synchronized (this) {
            if (this._partElectorDetailsModelDao == null) {
                this._partElectorDetailsModelDao = new PartElectorDetailsModelDao_Impl(this);
            }
            partElectorDetailsModelDao = this._partElectorDetailsModelDao;
        }
        return partElectorDetailsModelDao;
    }

    @Override // in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper
    public H2HElectorDetailModelDao h2HElectorDetailModelDao() {
        H2HElectorDetailModelDao h2HElectorDetailModelDao;
        if (this._h2HElectorDetailModelDao != null) {
            return this._h2HElectorDetailModelDao;
        }
        synchronized (this) {
            if (this._h2HElectorDetailModelDao == null) {
                this._h2HElectorDetailModelDao = new H2HElectorDetailModelDao_Impl(this);
            }
            h2HElectorDetailModelDao = this._h2HElectorDetailModelDao;
        }
        return h2HElectorDetailModelDao;
    }

    @Override // in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper
    public HouseSurveyModelDao houseSurveyModelDao() {
        HouseSurveyModelDao houseSurveyModelDao;
        if (this._houseSurveyModelDao != null) {
            return this._houseSurveyModelDao;
        }
        synchronized (this) {
            if (this._houseSurveyModelDao == null) {
                this._houseSurveyModelDao = new HouseSurveyModelDao_Impl(this);
            }
            houseSurveyModelDao = this._houseSurveyModelDao;
        }
        return houseSurveyModelDao;
    }

    @Override // in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper
    public H2HSurveyStatusDao h2HSurveyStatusDao() {
        H2HSurveyStatusDao h2HSurveyStatusDao;
        if (this._h2HSurveyStatusDao != null) {
            return this._h2HSurveyStatusDao;
        }
        synchronized (this) {
            if (this._h2HSurveyStatusDao == null) {
                this._h2HSurveyStatusDao = new H2HSurveyStatusDao_Impl(this);
            }
            h2HSurveyStatusDao = this._h2HSurveyStatusDao;
        }
        return h2HSurveyStatusDao;
    }
}
