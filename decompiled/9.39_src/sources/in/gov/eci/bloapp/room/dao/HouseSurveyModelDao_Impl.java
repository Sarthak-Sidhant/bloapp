package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class HouseSurveyModelDao_Impl implements HouseSurveyModelDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<HouseSurveyModel.Payload> __insertAdapterOfPayload = new EntityInsertAdapter<HouseSurveyModel.Payload>() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl.1
        protected String createQuery() {
            return "INSERT OR IGNORE INTO `HOUSE_SURVEY_DETAILS` (`EPIC_NO`,`HOUSE_NO`,`SECTION_NO`,`partNo`,`BLO_ID`,`MODIFIED_ON`,`LAST_SYNC_STATUS`) VALUES (?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final HouseSurveyModel.Payload entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getHouseNo());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getSectionNo());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getPartNo());
            }
            if (entity.getBloId() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getBloId());
            }
            if (entity.getModifiedOn() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getModifiedOn());
            }
            if (entity.getLastSyncStatus() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getLastSyncStatus());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<HouseSurveyModel.Payload> __updateAdapterOfPayload = new EntityDeleteOrUpdateAdapter<HouseSurveyModel.Payload>() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl.2
        protected String createQuery() {
            return "UPDATE OR ABORT `HOUSE_SURVEY_DETAILS` SET `EPIC_NO` = ?,`HOUSE_NO` = ?,`SECTION_NO` = ?,`partNo` = ?,`BLO_ID` = ?,`MODIFIED_ON` = ?,`LAST_SYNC_STATUS` = ? WHERE `EPIC_NO` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final HouseSurveyModel.Payload entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getHouseNo());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getSectionNo());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getPartNo());
            }
            if (entity.getBloId() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getBloId());
            }
            if (entity.getModifiedOn() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getModifiedOn());
            }
            if (entity.getLastSyncStatus() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getLastSyncStatus());
            }
            if (entity.getEpicNo() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getEpicNo());
            }
        }
    };

    public HouseSurveyModelDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.HouseSurveyModelDao
    public void addHouseSurveyDetails(final HouseSurveyModel.Payload houseSurveyModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return this.f$0.lambda$addHouseSurveyDetails$0(houseSurveyModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addHouseSurveyDetails$0(HouseSurveyModel.Payload payload, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfPayload.insert(sQLiteConnection, payload);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.HouseSurveyModelDao
    public void updateHouseSurveyDetails(final HouseSurveyModel.Payload houseSurveyModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updateHouseSurveyDetails$1(houseSurveyModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateHouseSurveyDetails$1(HouseSurveyModel.Payload payload, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfPayload.handle(sQLiteConnection, payload);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.HouseSurveyModelDao
    public List<HouseSurveyModel.Payload> getAllHouseSurveyDetails(final String partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return HouseSurveyModelDao_Impl.lambda$getAllHouseSurveyDetails$2(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllHouseSurveyDetails$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from HOUSE_SURVEY_DETAILS where partNo = ? and BLO_ID = ? and (LAST_SYNC_STATUS = 'SUCCESS' or LAST_SYNC_STATUS = 'INSERTED')");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NO");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "HOUSE_NO");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SECTION_NO");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseSurveyModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.HouseSurveyModelDao
    public List<HouseSurveyModel.Payload> getLastModifiedDate(final String partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return HouseSurveyModelDao_Impl.lambda$getLastModifiedDate$3(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getLastModifiedDate$3(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from HOUSE_SURVEY_DETAILS where partNo = ? and BLO_ID = ? and LAST_SYNC_STATUS is not null and LAST_SYNC_STATUS != '' and LAST_SYNC_STATUS != 'INSERTED'");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NO");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "HOUSE_NO");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SECTION_NO");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseSurveyModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.HouseSurveyModelDao
    public void deleteHouseSurveyDetails(final String partNo, final String bloId) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.HouseSurveyModelDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return HouseSurveyModelDao_Impl.lambda$deleteHouseSurveyDetails$4(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteHouseSurveyDetails$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM HOUSE_SURVEY_DETAILS WHERE partNo = ? and BLO_ID = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
