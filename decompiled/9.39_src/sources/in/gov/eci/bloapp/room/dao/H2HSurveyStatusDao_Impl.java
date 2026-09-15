package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class H2HSurveyStatusDao_Impl implements H2HSurveyStatusDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<H2HSurveyStatusModel.Payload> __insertAdapterOfPayload = new EntityInsertAdapter<H2HSurveyStatusModel.Payload>() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl.1
        protected String createQuery() {
            return "INSERT OR IGNORE INTO `H2H_SURVEY_STATUS` (`epicNo`,`partName`,`acNo`,`partNo`,`serialNo`,`applicantFirstName`,`applicantLastName`,`submissionDate`,`h2HMarking`,`form7Status`,`form8Status`,`BLO_ID`,`MODIFIED_ON`,`LAST_SYNC_STATUS`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final H2HSurveyStatusModel.Payload entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
            if (entity.getPartName() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getPartName());
            }
            statement.bindLong(3, entity.getAcNo());
            statement.bindLong(4, entity.getPartNo());
            statement.bindLong(5, entity.getSerialNo());
            if (entity.getApplicantFirstName() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getApplicantFirstName());
            }
            if (entity.getApplicantLastName() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getApplicantLastName());
            }
            if (entity.getSubmissionDate() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getSubmissionDate());
            }
            if (entity.getH2HMarking() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getH2HMarking());
            }
            if (entity.getForm7Status() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getForm7Status());
            }
            if (entity.getForm8Status() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getForm8Status());
            }
            if (entity.getBloId() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getBloId());
            }
            if (entity.getModifiedOn() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getModifiedOn());
            }
            if (entity.getLastSyncStatus() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getLastSyncStatus());
            }
        }
    };

    public H2HSurveyStatusDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public void addH2HSurveyDetails(final H2HSurveyStatusModel.Payload h2HSurveyStatusModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$addH2HSurveyDetails$0(h2HSurveyStatusModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addH2HSurveyDetails$0(H2HSurveyStatusModel.Payload payload, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfPayload.insert(sQLiteConnection, payload);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public List<H2HSurveyStatusModel.Payload> getH2HSurveyDetails(final int partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return H2HSurveyStatusDao_Impl.lambda$getH2HSurveyDetails$1(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getH2HSurveyDetails$1(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from H2H_SURVEY_STATUS where partNo = ? and BLO_ID = ? and (LAST_SYNC_STATUS = 'SUCCESS' or LAST_SYNC_STATUS = 'INSERTED')");
        try {
            sQLiteStatementPrepare.bindLong(1, i);
            if (str == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serialNo");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantFirstName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantLastName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "submissionDate");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "h2HMarking");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form7Status");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form8Status");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i2 = columnIndexOrThrow2;
                int i3 = columnIndexOrThrow3;
                int i4 = columnIndexOrThrow4;
                int i5 = columnIndexOrThrow;
                H2HSurveyStatusModel.Payload payload = new H2HSurveyStatusModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14));
                ArrayList arrayList2 = arrayList;
                arrayList2.add(payload);
                columnIndexOrThrow = i5;
                columnIndexOrThrow14 = columnIndexOrThrow14;
                columnIndexOrThrow3 = i3;
                columnIndexOrThrow4 = i4;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public List<H2HSurveyStatusModel.Payload> getH2HSurveyDetailsAsPerDate(final int partNo, final String bloId, final String fromDate, final String toDate) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return H2HSurveyStatusDao_Impl.lambda$getH2HSurveyDetailsAsPerDate$2(partNo, bloId, fromDate, toDate, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getH2HSurveyDetailsAsPerDate$2(int i, String str, String str2, String str3, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from H2H_SURVEY_STATUS where partNo = ? and BLO_ID = ? and (LAST_SYNC_STATUS = 'SUCCESS' or LAST_SYNC_STATUS = 'INSERTED') and submissionDate BETWEEN ? AND ?");
        try {
            sQLiteStatementPrepare.bindLong(1, i);
            if (str == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(3);
            } else {
                sQLiteStatementPrepare.bindText(3, str2);
            }
            if (str3 == null) {
                sQLiteStatementPrepare.bindNull(4);
            } else {
                sQLiteStatementPrepare.bindText(4, str3);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serialNo");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantFirstName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantLastName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "submissionDate");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "h2HMarking");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form7Status");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form8Status");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i2 = columnIndexOrThrow3;
                arrayList.add(new H2HSurveyStatusModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow = columnIndexOrThrow;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow3 = i2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public List<H2HSurveyStatusModel.Payload> getH2HSurveyDetailsAsPerSerialNo(final int partNo, final String bloId, final String serialNo) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return H2HSurveyStatusDao_Impl.lambda$getH2HSurveyDetailsAsPerSerialNo$3(partNo, bloId, serialNo, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getH2HSurveyDetailsAsPerSerialNo$3(int i, String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from H2H_SURVEY_STATUS where partNo = ? and BLO_ID = ? and (LAST_SYNC_STATUS = 'SUCCESS' or LAST_SYNC_STATUS = 'INSERTED') and serialNo = ?");
        try {
            sQLiteStatementPrepare.bindLong(1, i);
            if (str == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(3);
            } else {
                sQLiteStatementPrepare.bindText(3, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serialNo");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantFirstName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantLastName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "submissionDate");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "h2HMarking");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form7Status");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form8Status");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i2 = columnIndexOrThrow3;
                int i3 = columnIndexOrThrow4;
                arrayList.add(new H2HSurveyStatusModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14)));
                columnIndexOrThrow = columnIndexOrThrow;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow3 = i2;
                columnIndexOrThrow4 = i3;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public List<H2HSurveyStatusModel.Payload> getLastModifiedDate(final int partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return H2HSurveyStatusDao_Impl.lambda$getLastModifiedDate$4(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getLastModifiedDate$4(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from H2H_SURVEY_STATUS where partNo = ? and BLO_ID = ? and LAST_SYNC_STATUS is not null and LAST_SYNC_STATUS != '' and LAST_SYNC_STATUS != 'INSERTED'");
        try {
            sQLiteStatementPrepare.bindLong(1, i);
            if (str == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serialNo");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantFirstName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantLastName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "submissionDate");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "h2HMarking");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form7Status");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "form8Status");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i2 = columnIndexOrThrow2;
                int i3 = columnIndexOrThrow3;
                int i4 = columnIndexOrThrow4;
                int i5 = columnIndexOrThrow;
                H2HSurveyStatusModel.Payload payload = new H2HSurveyStatusModel.Payload(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14));
                ArrayList arrayList2 = arrayList;
                arrayList2.add(payload);
                columnIndexOrThrow = i5;
                columnIndexOrThrow14 = columnIndexOrThrow14;
                columnIndexOrThrow3 = i3;
                columnIndexOrThrow4 = i4;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao
    public void deleteH2HSurveyDetails(final String partNo, final String bloId) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HSurveyStatusDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return H2HSurveyStatusDao_Impl.lambda$deleteH2HSurveyDetails$5(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteH2HSurveyDetails$5(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM H2H_SURVEY_STATUS WHERE partNo = ? and BLO_ID = ?");
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
