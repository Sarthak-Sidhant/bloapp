package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.room.roommodel.VoterChangeModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class VoterChangeDao_Impl implements VoterChangeDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<VoterChangeModel> __insertAdapterOfVoterChangeModel = new EntityInsertAdapter<VoterChangeModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl.1
        protected String createQuery() {
            return "INSERT OR ABORT INTO `VOTER_CHANGE_REQUEST` (`ID`,`NAME`,`FATHER_NAME`,`STATE`,`DISTRICT`,`ASSEMBLY_CONSTITUENCY`,`STATUS`,`PWD_MOBILE_NUMBER`,`HOUSE_NUMBER`,`STREET`,`TOWN`,`POSTOFFICE`,`CHANGE_TYPE`,`PINCODE`,`REQUEST_TYPE`,`PART_NUMBER`,`EPIC_NUMBER`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterChangeModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.name == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.name);
            }
            if (entity.fatherName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.fatherName);
            }
            if (entity.state == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.district);
            }
            if (entity.assemblyCons == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.assemblyCons);
            }
            if (entity.status == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.status);
            }
            if (entity.pwdMob == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.pwdMob);
            }
            if (entity.houseNo == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.houseNo);
            }
            if (entity.street == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.street);
            }
            if (entity.town == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.town);
            }
            if (entity.postOffice == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.postOffice);
            }
            if (entity.changeType == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.changeType);
            }
            if (entity.pincode == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.pincode);
            }
            if (entity.requestType == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.requestType);
            }
            if (entity.partNo == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.partNo);
            }
            if (entity.epicNum == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.epicNum);
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<VoterChangeModel> __deleteAdapterOfVoterChangeModel = new EntityDeleteOrUpdateAdapter<VoterChangeModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `VOTER_CHANGE_REQUEST` WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterChangeModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<VoterChangeModel> __updateAdapterOfVoterChangeModel = new EntityDeleteOrUpdateAdapter<VoterChangeModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `VOTER_CHANGE_REQUEST` SET `ID` = ?,`NAME` = ?,`FATHER_NAME` = ?,`STATE` = ?,`DISTRICT` = ?,`ASSEMBLY_CONSTITUENCY` = ?,`STATUS` = ?,`PWD_MOBILE_NUMBER` = ?,`HOUSE_NUMBER` = ?,`STREET` = ?,`TOWN` = ?,`POSTOFFICE` = ?,`CHANGE_TYPE` = ?,`PINCODE` = ?,`REQUEST_TYPE` = ?,`PART_NUMBER` = ?,`EPIC_NUMBER` = ? WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterChangeModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.name == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.name);
            }
            if (entity.fatherName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.fatherName);
            }
            if (entity.state == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.district);
            }
            if (entity.assemblyCons == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.assemblyCons);
            }
            if (entity.status == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.status);
            }
            if (entity.pwdMob == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.pwdMob);
            }
            if (entity.houseNo == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.houseNo);
            }
            if (entity.street == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.street);
            }
            if (entity.town == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.town);
            }
            if (entity.postOffice == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.postOffice);
            }
            if (entity.changeType == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.changeType);
            }
            if (entity.pincode == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.pincode);
            }
            if (entity.requestType == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.requestType);
            }
            if (entity.partNo == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.partNo);
            }
            if (entity.epicNum == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.epicNum);
            }
            if (entity.id == null) {
                statement.bindNull(18);
            } else {
                statement.bindLong(18, entity.id.longValue());
            }
        }
    };

    public VoterChangeDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterChangeDao
    public Completable insert(final VoterChangeModel voterChange) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(voterChange, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insert$0(VoterChangeModel voterChangeModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfVoterChangeModel.insert(sQLiteConnection, voterChangeModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterChangeDao
    public Completable delete(final VoterChangeModel voterChange) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(voterChange, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$delete$1(VoterChangeModel voterChangeModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfVoterChangeModel.handle(sQLiteConnection, voterChangeModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterChangeDao
    public Completable update(final VoterChangeModel voterChange) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$2(voterChange, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$update$2(VoterChangeModel voterChangeModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfVoterChangeModel.handle(sQLiteConnection, voterChangeModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterChangeDao
    public Maybe<List<VoterChangeModel>> getVoterChangeRequest() {
        return RxRoom.createMaybe(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterChangeDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return VoterChangeDao_Impl.lambda$getVoterChangeRequest$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getVoterChangeRequest$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM voter_change_request ");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ID");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "NAME");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FATHER_NAME");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STATE");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "DISTRICT");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ASSEMBLY_CONSTITUENCY");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STATUS");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PWD_MOBILE_NUMBER");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "HOUSE_NUMBER");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "STREET");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "TOWN");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "POSTOFFICE");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "CHANGE_TYPE");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PINCODE");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "REQUEST_TYPE");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PART_NUMBER");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NUMBER");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow));
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i2) ? null : sQLiteStatementPrepare.getText(i2);
                int i3 = columnIndexOrThrow16;
                String text15 = sQLiteStatementPrepare.isNull(i3) ? null : sQLiteStatementPrepare.getText(i3);
                int i4 = columnIndexOrThrow17;
                arrayList.add(new VoterChangeModel(lValueOf, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4)));
                columnIndexOrThrow = i;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow16 = i3;
                columnIndexOrThrow17 = i4;
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
