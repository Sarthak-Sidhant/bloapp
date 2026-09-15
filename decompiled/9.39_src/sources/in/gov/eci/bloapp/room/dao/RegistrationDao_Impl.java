package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.room.roommodel.RegistrationModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class RegistrationDao_Impl implements RegistrationDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<RegistrationModel> __insertAdapterOfRegistrationModel = new EntityInsertAdapter<RegistrationModel>() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl.1
        protected String createQuery() {
            return "INSERT OR ABORT INTO `REGISTRATION_TABLE` (`ID`,`FIRST_NAME`,`LAST_NAME`,`MOBILE_NUMBER`,`EMAIL_ID`,`PASSWORD`,`EPIC_NUMBER`) VALUES (?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final RegistrationModel entity) {
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
            if (entity.mobNo == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.mobNo);
            }
            if (entity.email == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.email);
            }
            if (entity.password == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.password);
            }
            if (entity.epicNum == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.epicNum);
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<RegistrationModel> __deleteAdapterOfRegistrationModel = new EntityDeleteOrUpdateAdapter<RegistrationModel>() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `REGISTRATION_TABLE` WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final RegistrationModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<RegistrationModel> __updateAdapterOfRegistrationModel = new EntityDeleteOrUpdateAdapter<RegistrationModel>() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `REGISTRATION_TABLE` SET `ID` = ?,`FIRST_NAME` = ?,`LAST_NAME` = ?,`MOBILE_NUMBER` = ?,`EMAIL_ID` = ?,`PASSWORD` = ?,`EPIC_NUMBER` = ? WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final RegistrationModel entity) {
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
            if (entity.mobNo == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.mobNo);
            }
            if (entity.email == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.email);
            }
            if (entity.password == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.password);
            }
            if (entity.epicNum == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.epicNum);
            }
            if (entity.id == null) {
                statement.bindNull(8);
            } else {
                statement.bindLong(8, entity.id.longValue());
            }
        }
    };

    public RegistrationDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.RegistrationDao
    public Completable insert(final RegistrationModel registration) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(registration, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insert$0(RegistrationModel registrationModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfRegistrationModel.insert(sQLiteConnection, registrationModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.RegistrationDao
    public Completable delete(final RegistrationModel registration) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(registration, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$delete$1(RegistrationModel registrationModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfRegistrationModel.handle(sQLiteConnection, registrationModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.RegistrationDao
    public Completable update(final RegistrationModel registration) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$2(registration, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$update$2(RegistrationModel registrationModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfRegistrationModel.handle(sQLiteConnection, registrationModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.RegistrationDao
    public Maybe<List<RegistrationModel>> getRegDetails() {
        return RxRoom.createMaybe(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.RegistrationDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return RegistrationDao_Impl.lambda$getRegDetails$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getRegDetails$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM registration_table ");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ID");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "FIRST_NAME");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_NAME");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MOBILE_NUMBER");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EMAIL_ID");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "PASSWORD");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "EPIC_NUMBER");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new RegistrationModel(sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow)), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7)));
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
