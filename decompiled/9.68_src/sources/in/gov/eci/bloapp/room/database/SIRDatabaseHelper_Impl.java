package in.gov.eci.bloapp.room.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import in.gov.eci.bloapp.room.dao.ListDataDao;
import in.gov.eci.bloapp.room.dao.ListDataDao_Impl;
import in.gov.eci.bloapp.room.dao.SpecialRevisionDao;
import in.gov.eci.bloapp.room.dao.SpecialRevisionDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class SIRDatabaseHelper_Impl extends SIRDatabaseHelper {
    private volatile ListDataDao _listDataDao;
    private volatile SpecialRevisionDao _specialRevisionDao;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m627createOpenDelegate() {
        return new RoomOpenDelegate(1, "1a1dd769d6518a6a6d908c74c85eecf0", "ebbe21a114fd40b1dc2cd8eb95da8056") { // from class: in.gov.eci.bloapp.room.database.SIRDatabaseHelper_Impl.1
            public void onCreate(final SQLiteConnection connection) {
            }

            public void onPostMigrate(final SQLiteConnection connection) {
            }

            public void createAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `special_revision_survey` (`EPIC_ID` INTEGER, `STATE_CD` TEXT, `EPIC_NO` TEXT NOT NULL, `HOUSE_NO` TEXT, `DOB_VERIFIED` TEXT, `EROLL_DOB` TEXT, `DISTRICT_CD` TEXT, `AC_NO` TEXT, `PART_NO` TEXT, `PART_SERIAL_NO` TEXT, `CREATED_DTTM` TEXT, `CREATED_BY` TEXT, `MODIFIED_DTTM` TEXT, `MODIFIED_BY` TEXT, `PHOTO_URL` TEXT, `SR_FORM_PAGE_1_URL` TEXT, `CITIZENSHIP_TYPE` TEXT, `CITIZENSHIP_TYPE_CAT` TEXT, `LIST_1_DOC` TEXT, `LIST_2_DOC` TEXT, `LIST_3_DOC` TEXT, `LIST_4_DOC` TEXT, `LIST_5_DOC` TEXT, `LIST_6_DOC` TEXT, `LIST_7_DOC` TEXT, `LIST_1_DOC_URL` TEXT, `LIST_2_DOC_URL` TEXT, `LIST_3_DOC_URL` TEXT, `LIST_4_DOC_URL` TEXT, `LIST_5_DOC_URL` TEXT, `LIST_6_DOC_URL` TEXT, `LIST_7_DOC_URL` TEXT, `SURVEY_CHANNEL` TEXT, `AADHAR_NO` TEXT, `MOBILE_NO` TEXT, `FATHERS_OR_GUARDIAN_NAME` TEXT, `FATHERS_OR_GUARDIAN_EPIC_NO` TEXT, `MOTHERS_NAME` TEXT, `MOTHERS_EPIC_NO` TEXT, `SPOUSE_NAME` TEXT, `SPOUSE_EPIC_NO` TEXT, `ANNEXURE_C_URL` TEXT, `PRE_REVISION_VOTER_FLG` TEXT, `PRE_REVISION_VOTER_DOC_URL` TEXT, `SUBMITTED_FOR_RECOMMENDATION` TEXT, `FATHERS_NATIONALITY` TEXT, `MOTHERS_NATIONALITY` TEXT, `SR_FORM_PAGE_2_URL` TEXT, `OLD_AC_NO` TEXT, `OLD_PART_NO` TEXT, `OLD_PSL_NO` TEXT, `F_OLD_AC_NO` TEXT, `F_OLD_PART_NO` TEXT, `F_OLD_PSL_NO` TEXT, `M_OLD_AC_NO` TEXT, `M_OLD_PART_NO` TEXT, `M_OLD_PSL_NO` TEXT, `LIST_8_DOC` TEXT, `DOCUMENT_UPLOADED_FLG` TEXT, `citizen_signature_filepath` TEXT, `FORM_SUBMISSION_PLACE` TEXT, `LIST_1_DOC_URL_PG2` TEXT, `LIST_2_DOC_URL_PG2` TEXT, `LIST_3_DOC_URL_PG2` TEXT, `LIST_4_DOC_URL_PG2` TEXT, `LIST_5_DOC_URL_PG2` TEXT, `LIST_5_DOC_URL_PG3` TEXT, `LIST_6_DOC_URL_PG2` TEXT, `LIST_7_DOC_URL_PG2` TEXT, `PRE_REVISION_VOTER_DOC_URL_PG2` TEXT, `ANNEXURE_C_URL_PG2` TEXT, `IP_ADDRESS` TEXT, `USER_ID` TEXT, `IS_LEGACY_OPT` TEXT, `BLO_OVER_RIDDEN_FLG` TEXT, `EMAIL_ID` TEXT, `PASSPORT_NO` TEXT, `ELECTOR_TYPE` TEXT, `ELECTOR_NAME` TEXT, `PRV_PARTNO` TEXT, `PRV_PARTSLNO` TEXT, `PRV_CAT` TEXT, `RELATION_TYPE` TEXT, `RELATION_PROOF_DOC_URL_PG1` TEXT, `RELATION_PROOF_DOC_URL_PG2` TEXT, `RELATION_OLD_AC_NO` TEXT, `RELATION_OLD_PART_NO` TEXT, `RELATION_OLD_PSL_NO` TEXT, `RELATION_DOC_TYPE` TEXT, `RELATION_DOC_URL_PG1` TEXT, `RELATION_DOC_URL_PG2` TEXT, `IS_RELATIVE_PRE_VOTER_FLG` TEXT, `RELATION_EPIC_NO` TEXT, `IS_THIS_YOU_FLG` TEXT, `IS_THIS_YOU_REL_FLG` TEXT, `RELATION_OLD_STATE_CD` TEXT, `OLD_STATE_CD` TEXT, `tabName` TEXT, `COMMENTS` TEXT, `REQUEST_STATUS_CODE` INTEGER NOT NULL, PRIMARY KEY(`EPIC_ID`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `ListData` (`docCode` TEXT NOT NULL, `docName` TEXT, `lists` TEXT, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`docCode`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1a1dd769d6518a6a6d908c74c85eecf0')");
            }

            public void dropAllTables(final SQLiteConnection connection) {
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `special_revision_survey`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `ListData`");
            }

            public void onOpen(final SQLiteConnection connection) {
                SIRDatabaseHelper_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(final SQLiteConnection connection) {
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(final SQLiteConnection connection) {
                HashMap map = new HashMap(100);
                map.put("EPIC_ID", new TableInfo.Column("EPIC_ID", "INTEGER", false, 1, (String) null, 1));
                map.put("STATE_CD", new TableInfo.Column("STATE_CD", "TEXT", false, 0, (String) null, 1));
                map.put("EPIC_NO", new TableInfo.Column("EPIC_NO", "TEXT", true, 0, (String) null, 1));
                map.put("HOUSE_NO", new TableInfo.Column("HOUSE_NO", "TEXT", false, 0, (String) null, 1));
                map.put("DOB_VERIFIED", new TableInfo.Column("DOB_VERIFIED", "TEXT", false, 0, (String) null, 1));
                map.put("EROLL_DOB", new TableInfo.Column("EROLL_DOB", "TEXT", false, 0, (String) null, 1));
                map.put("DISTRICT_CD", new TableInfo.Column("DISTRICT_CD", "TEXT", false, 0, (String) null, 1));
                map.put("AC_NO", new TableInfo.Column("AC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("PART_NO", new TableInfo.Column("PART_NO", "TEXT", false, 0, (String) null, 1));
                map.put("PART_SERIAL_NO", new TableInfo.Column("PART_SERIAL_NO", "TEXT", false, 0, (String) null, 1));
                map.put("CREATED_DTTM", new TableInfo.Column("CREATED_DTTM", "TEXT", false, 0, (String) null, 1));
                map.put("CREATED_BY", new TableInfo.Column("CREATED_BY", "TEXT", false, 0, (String) null, 1));
                map.put("MODIFIED_DTTM", new TableInfo.Column("MODIFIED_DTTM", "TEXT", false, 0, (String) null, 1));
                map.put("MODIFIED_BY", new TableInfo.Column("MODIFIED_BY", "TEXT", false, 0, (String) null, 1));
                map.put("PHOTO_URL", new TableInfo.Column("PHOTO_URL", "TEXT", false, 0, (String) null, 1));
                map.put("SR_FORM_PAGE_1_URL", new TableInfo.Column("SR_FORM_PAGE_1_URL", "TEXT", false, 0, (String) null, 1));
                map.put("CITIZENSHIP_TYPE", new TableInfo.Column("CITIZENSHIP_TYPE", "TEXT", false, 0, (String) null, 1));
                map.put("CITIZENSHIP_TYPE_CAT", new TableInfo.Column("CITIZENSHIP_TYPE_CAT", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_1_DOC", new TableInfo.Column("LIST_1_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_2_DOC", new TableInfo.Column("LIST_2_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_3_DOC", new TableInfo.Column("LIST_3_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_4_DOC", new TableInfo.Column("LIST_4_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_5_DOC", new TableInfo.Column("LIST_5_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_6_DOC", new TableInfo.Column("LIST_6_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_7_DOC", new TableInfo.Column("LIST_7_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_1_DOC_URL", new TableInfo.Column("LIST_1_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_2_DOC_URL", new TableInfo.Column("LIST_2_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_3_DOC_URL", new TableInfo.Column("LIST_3_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_4_DOC_URL", new TableInfo.Column("LIST_4_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_5_DOC_URL", new TableInfo.Column("LIST_5_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_6_DOC_URL", new TableInfo.Column("LIST_6_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_7_DOC_URL", new TableInfo.Column("LIST_7_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("SURVEY_CHANNEL", new TableInfo.Column("SURVEY_CHANNEL", "TEXT", false, 0, (String) null, 1));
                map.put("AADHAR_NO", new TableInfo.Column("AADHAR_NO", "TEXT", false, 0, (String) null, 1));
                map.put("MOBILE_NO", new TableInfo.Column("MOBILE_NO", "TEXT", false, 0, (String) null, 1));
                map.put("FATHERS_OR_GUARDIAN_NAME", new TableInfo.Column("FATHERS_OR_GUARDIAN_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("FATHERS_OR_GUARDIAN_EPIC_NO", new TableInfo.Column("FATHERS_OR_GUARDIAN_EPIC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("MOTHERS_NAME", new TableInfo.Column("MOTHERS_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("MOTHERS_EPIC_NO", new TableInfo.Column("MOTHERS_EPIC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("SPOUSE_NAME", new TableInfo.Column("SPOUSE_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("SPOUSE_EPIC_NO", new TableInfo.Column("SPOUSE_EPIC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("ANNEXURE_C_URL", new TableInfo.Column("ANNEXURE_C_URL", "TEXT", false, 0, (String) null, 1));
                map.put("PRE_REVISION_VOTER_FLG", new TableInfo.Column("PRE_REVISION_VOTER_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("PRE_REVISION_VOTER_DOC_URL", new TableInfo.Column("PRE_REVISION_VOTER_DOC_URL", "TEXT", false, 0, (String) null, 1));
                map.put("SUBMITTED_FOR_RECOMMENDATION", new TableInfo.Column("SUBMITTED_FOR_RECOMMENDATION", "TEXT", false, 0, (String) null, 1));
                map.put("FATHERS_NATIONALITY", new TableInfo.Column("FATHERS_NATIONALITY", "TEXT", false, 0, (String) null, 1));
                map.put("MOTHERS_NATIONALITY", new TableInfo.Column("MOTHERS_NATIONALITY", "TEXT", false, 0, (String) null, 1));
                map.put("SR_FORM_PAGE_2_URL", new TableInfo.Column("SR_FORM_PAGE_2_URL", "TEXT", false, 0, (String) null, 1));
                map.put("OLD_AC_NO", new TableInfo.Column("OLD_AC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("OLD_PART_NO", new TableInfo.Column("OLD_PART_NO", "TEXT", false, 0, (String) null, 1));
                map.put("OLD_PSL_NO", new TableInfo.Column("OLD_PSL_NO", "TEXT", false, 0, (String) null, 1));
                map.put("F_OLD_AC_NO", new TableInfo.Column("F_OLD_AC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("F_OLD_PART_NO", new TableInfo.Column("F_OLD_PART_NO", "TEXT", false, 0, (String) null, 1));
                map.put("F_OLD_PSL_NO", new TableInfo.Column("F_OLD_PSL_NO", "TEXT", false, 0, (String) null, 1));
                map.put("M_OLD_AC_NO", new TableInfo.Column("M_OLD_AC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("M_OLD_PART_NO", new TableInfo.Column("M_OLD_PART_NO", "TEXT", false, 0, (String) null, 1));
                map.put("M_OLD_PSL_NO", new TableInfo.Column("M_OLD_PSL_NO", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_8_DOC", new TableInfo.Column("LIST_8_DOC", "TEXT", false, 0, (String) null, 1));
                map.put("DOCUMENT_UPLOADED_FLG", new TableInfo.Column("DOCUMENT_UPLOADED_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("citizen_signature_filepath", new TableInfo.Column("citizen_signature_filepath", "TEXT", false, 0, (String) null, 1));
                map.put("FORM_SUBMISSION_PLACE", new TableInfo.Column("FORM_SUBMISSION_PLACE", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_1_DOC_URL_PG2", new TableInfo.Column("LIST_1_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_2_DOC_URL_PG2", new TableInfo.Column("LIST_2_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_3_DOC_URL_PG2", new TableInfo.Column("LIST_3_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_4_DOC_URL_PG2", new TableInfo.Column("LIST_4_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_5_DOC_URL_PG2", new TableInfo.Column("LIST_5_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_5_DOC_URL_PG3", new TableInfo.Column("LIST_5_DOC_URL_PG3", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_6_DOC_URL_PG2", new TableInfo.Column("LIST_6_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("LIST_7_DOC_URL_PG2", new TableInfo.Column("LIST_7_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("PRE_REVISION_VOTER_DOC_URL_PG2", new TableInfo.Column("PRE_REVISION_VOTER_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("ANNEXURE_C_URL_PG2", new TableInfo.Column("ANNEXURE_C_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("IP_ADDRESS", new TableInfo.Column("IP_ADDRESS", "TEXT", false, 0, (String) null, 1));
                map.put("USER_ID", new TableInfo.Column("USER_ID", "TEXT", false, 0, (String) null, 1));
                map.put("IS_LEGACY_OPT", new TableInfo.Column("IS_LEGACY_OPT", "TEXT", false, 0, (String) null, 1));
                map.put("BLO_OVER_RIDDEN_FLG", new TableInfo.Column("BLO_OVER_RIDDEN_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("EMAIL_ID", new TableInfo.Column("EMAIL_ID", "TEXT", false, 0, (String) null, 1));
                map.put("PASSPORT_NO", new TableInfo.Column("PASSPORT_NO", "TEXT", false, 0, (String) null, 1));
                map.put("ELECTOR_TYPE", new TableInfo.Column("ELECTOR_TYPE", "TEXT", false, 0, (String) null, 1));
                map.put("ELECTOR_NAME", new TableInfo.Column("ELECTOR_NAME", "TEXT", false, 0, (String) null, 1));
                map.put("PRV_PARTNO", new TableInfo.Column("PRV_PARTNO", "TEXT", false, 0, (String) null, 1));
                map.put("PRV_PARTSLNO", new TableInfo.Column("PRV_PARTSLNO", "TEXT", false, 0, (String) null, 1));
                map.put("PRV_CAT", new TableInfo.Column("PRV_CAT", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_TYPE", new TableInfo.Column("RELATION_TYPE", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_PROOF_DOC_URL_PG1", new TableInfo.Column("RELATION_PROOF_DOC_URL_PG1", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_PROOF_DOC_URL_PG2", new TableInfo.Column("RELATION_PROOF_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_OLD_AC_NO", new TableInfo.Column("RELATION_OLD_AC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_OLD_PART_NO", new TableInfo.Column("RELATION_OLD_PART_NO", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_OLD_PSL_NO", new TableInfo.Column("RELATION_OLD_PSL_NO", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_DOC_TYPE", new TableInfo.Column("RELATION_DOC_TYPE", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_DOC_URL_PG1", new TableInfo.Column("RELATION_DOC_URL_PG1", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_DOC_URL_PG2", new TableInfo.Column("RELATION_DOC_URL_PG2", "TEXT", false, 0, (String) null, 1));
                map.put("IS_RELATIVE_PRE_VOTER_FLG", new TableInfo.Column("IS_RELATIVE_PRE_VOTER_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_EPIC_NO", new TableInfo.Column("RELATION_EPIC_NO", "TEXT", false, 0, (String) null, 1));
                map.put("IS_THIS_YOU_FLG", new TableInfo.Column("IS_THIS_YOU_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("IS_THIS_YOU_REL_FLG", new TableInfo.Column("IS_THIS_YOU_REL_FLG", "TEXT", false, 0, (String) null, 1));
                map.put("RELATION_OLD_STATE_CD", new TableInfo.Column("RELATION_OLD_STATE_CD", "TEXT", false, 0, (String) null, 1));
                map.put("OLD_STATE_CD", new TableInfo.Column("OLD_STATE_CD", "TEXT", false, 0, (String) null, 1));
                map.put("tabName", new TableInfo.Column("tabName", "TEXT", false, 0, (String) null, 1));
                map.put("COMMENTS", new TableInfo.Column("COMMENTS", "TEXT", false, 0, (String) null, 1));
                map.put("REQUEST_STATUS_CODE", new TableInfo.Column("REQUEST_STATUS_CODE", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("special_revision_survey", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(connection, "special_revision_survey");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "special_revision_survey(in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(4);
                map2.put("docCode", new TableInfo.Column("docCode", "TEXT", true, 1, (String) null, 1));
                map2.put("docName", new TableInfo.Column("docName", "TEXT", false, 0, (String) null, 1));
                map2.put("lists", new TableInfo.Column("lists", "TEXT", false, 0, (String) null, 1));
                map2.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("ListData", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(connection, "ListData");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ListData(in.gov.eci.bloapp.entity.ListData).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"special_revision_survey", "ListData"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"special_revision_survey", "ListData"});
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(SpecialRevisionDao.class, SpecialRevisionDao_Impl.getRequiredConverters());
        map.put(ListDataDao.class, ListDataDao_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // in.gov.eci.bloapp.room.database.SIRDatabaseHelper
    public SpecialRevisionDao SpecialRevisionDao() {
        SpecialRevisionDao specialRevisionDao;
        if (this._specialRevisionDao != null) {
            return this._specialRevisionDao;
        }
        synchronized (this) {
            if (this._specialRevisionDao == null) {
                this._specialRevisionDao = new SpecialRevisionDao_Impl(this);
            }
            specialRevisionDao = this._specialRevisionDao;
        }
        return specialRevisionDao;
    }

    @Override // in.gov.eci.bloapp.room.database.SIRDatabaseHelper
    public ListDataDao ListDataDao() {
        ListDataDao listDataDao;
        if (this._listDataDao != null) {
            return this._listDataDao;
        }
        synchronized (this) {
            if (this._listDataDao == null) {
                this._listDataDao = new ListDataDao_Impl(this);
            }
            listDataDao = this._listDataDao;
        }
        return listDataDao;
    }
}
