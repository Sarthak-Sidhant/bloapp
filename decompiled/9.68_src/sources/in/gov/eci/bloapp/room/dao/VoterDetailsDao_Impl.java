package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.room.roommodel.BoothModel;
import in.gov.eci.bloapp.room.roommodel.VoterDetailsModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class VoterDetailsDao_Impl implements VoterDetailsDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<VoterDetailsModel> __insertAdapterOfVoterDetailsModel = new EntityInsertAdapter<VoterDetailsModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl.1
        protected String createQuery() {
            return "INSERT OR ABORT INTO `VOTER_DETAILS` (`ID`,`FIRST_NAME`,`LAST_NAME`,`FATHER_NAME`,`MOBILE_NUMBER`,`AGE`,`GENDER`,`CONSTITUENCY`,`EPIC_NUMBER`,`STATE`,`DISTRICT`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterDetailsModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.firstName == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.firstName);
            }
            if (entity.lastName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.lastName);
            }
            if (entity.fatherName == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.fatherName);
            }
            if (entity.mobNum == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.mobNum);
            }
            if (entity.agr == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.agr);
            }
            if (entity.gender == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.gender);
            }
            if (entity.constituency == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.constituency);
            }
            if (entity.epicNum == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.epicNum);
            }
            if (entity.state == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.district);
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<VoterDetailsModel> __deleteAdapterOfVoterDetailsModel = new EntityDeleteOrUpdateAdapter<VoterDetailsModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `VOTER_DETAILS` WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterDetailsModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<VoterDetailsModel> __updateAdapterOfVoterDetailsModel = new EntityDeleteOrUpdateAdapter<VoterDetailsModel>() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `VOTER_DETAILS` SET `ID` = ?,`FIRST_NAME` = ?,`LAST_NAME` = ?,`FATHER_NAME` = ?,`MOBILE_NUMBER` = ?,`AGE` = ?,`GENDER` = ?,`CONSTITUENCY` = ?,`EPIC_NUMBER` = ?,`STATE` = ?,`DISTRICT` = ? WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final VoterDetailsModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.firstName == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.firstName);
            }
            if (entity.lastName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.lastName);
            }
            if (entity.fatherName == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.fatherName);
            }
            if (entity.mobNum == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.mobNum);
            }
            if (entity.agr == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.agr);
            }
            if (entity.gender == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.gender);
            }
            if (entity.constituency == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.constituency);
            }
            if (entity.epicNum == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.epicNum);
            }
            if (entity.state == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.state);
            }
            if (entity.district == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.district);
            }
            if (entity.id == null) {
                statement.bindNull(12);
            } else {
                statement.bindLong(12, entity.id.longValue());
            }
        }
    };

    public VoterDetailsDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterDetailsDao
    public Completable insert(final VoterDetailsModel voterDetails) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(voterDetails, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insert$0(VoterDetailsModel voterDetailsModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfVoterDetailsModel.insert(sQLiteConnection, voterDetailsModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterDetailsDao
    public Completable delete(final VoterDetailsModel voterDetails) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(voterDetails, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$delete$1(VoterDetailsModel voterDetailsModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfVoterDetailsModel.handle(sQLiteConnection, voterDetailsModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterDetailsDao
    public Completable update(final VoterDetailsModel voterDetails) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$2(voterDetails, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$update$2(VoterDetailsModel voterDetailsModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfVoterDetailsModel.handle(sQLiteConnection, voterDetailsModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.VoterDetailsDao
    public Maybe<List<BoothModel>> getVoterDetails() {
        return RxRoom.createMaybe(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.VoterDetailsDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VoterDetailsDao_Impl.lambda$getVoterDetails$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getVoterDetails$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM voter_details  ");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ID");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new BoothModel(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow)), null, null, null, null, null, null, null, null, null, null, null, null, null, null));
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
