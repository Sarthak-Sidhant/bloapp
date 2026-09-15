package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.room.roommodel.GrevianceModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class GrevianceDao_Impl implements GrevianceDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<GrevianceModel> __insertAdapterOfGrevianceModel = new EntityInsertAdapter<GrevianceModel>() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl.1
        protected String createQuery() {
            return "INSERT OR ABORT INTO `GREVIANCE_DETAILS` (`ID`,`MOBILE_NUMBER`,`STATE`,`DISTRICT`,`CONSTITUENCY`,`CATEGORY`,`SUBCATEGORY`,`SUBJECT_TYPE`,`INCIDENT`,`FORM`,`REFERENCE_NUMBER`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final GrevianceModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.mobNum == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.mobNum);
            }
            if (entity.state == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.district);
            }
            if (entity.constituency == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.constituency);
            }
            if (entity.category == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.category);
            }
            if (entity.subCat == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.subCat);
            }
            if (entity.subjectType == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.subjectType);
            }
            if (entity.incident == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.incident);
            }
            if (entity.form == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.form);
            }
            if (entity.referenceNo == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.referenceNo);
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<GrevianceModel> __deleteAdapterOfGrevianceModel = new EntityDeleteOrUpdateAdapter<GrevianceModel>() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `GREVIANCE_DETAILS` WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final GrevianceModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<GrevianceModel> __updateAdapterOfGrevianceModel = new EntityDeleteOrUpdateAdapter<GrevianceModel>() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `GREVIANCE_DETAILS` SET `ID` = ?,`MOBILE_NUMBER` = ?,`STATE` = ?,`DISTRICT` = ?,`CONSTITUENCY` = ?,`CATEGORY` = ?,`SUBCATEGORY` = ?,`SUBJECT_TYPE` = ?,`INCIDENT` = ?,`FORM` = ?,`REFERENCE_NUMBER` = ? WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final GrevianceModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.mobNum == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.mobNum);
            }
            if (entity.state == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.district);
            }
            if (entity.constituency == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.constituency);
            }
            if (entity.category == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.category);
            }
            if (entity.subCat == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.subCat);
            }
            if (entity.subjectType == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.subjectType);
            }
            if (entity.incident == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.incident);
            }
            if (entity.form == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.form);
            }
            if (entity.referenceNo == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.referenceNo);
            }
            if (entity.id == null) {
                statement.bindNull(12);
            } else {
                statement.bindLong(12, entity.id.longValue());
            }
        }
    };

    public GrevianceDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.GrevianceDao
    public Completable insert(final GrevianceModel grevianceModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(grevianceModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insert$0(GrevianceModel grevianceModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfGrevianceModel.insert(sQLiteConnection, grevianceModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.GrevianceDao
    public Completable delete(final GrevianceModel grevianceModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(grevianceModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$delete$1(GrevianceModel grevianceModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfGrevianceModel.handle(sQLiteConnection, grevianceModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.GrevianceDao
    public Completable update(final GrevianceModel grevianceModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$2(grevianceModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$update$2(GrevianceModel grevianceModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfGrevianceModel.handle(sQLiteConnection, grevianceModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.GrevianceDao
    public Maybe<List<GrevianceModel>> getGreviance() {
        return RxRoom.createMaybe(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.GrevianceDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return GrevianceDao_Impl.lambda$getGreviance$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getGreviance$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM greviance_details ");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ID");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOBILE_NUMBER");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STATE");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DISTRICT");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CONSTITUENCY");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CATEGORY");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SUBCATEGORY");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "SUBJECT_TYPE");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "INCIDENT");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FORM");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "REFERENCE_NUMBER");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new GrevianceModel(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow)), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
