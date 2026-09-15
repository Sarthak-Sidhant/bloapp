package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.room.roommodel.BoothModel;
import io.reactivex.Completable;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BoothDao_Impl implements BoothDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<BoothModel> __insertAdapterOfBoothModel = new EntityInsertAdapter<BoothModel>() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl.1
        protected String createQuery() {
            return "INSERT OR ABORT INTO `BOOTH_LOCATOR` (`ID`,`BOOTH_ID`,`AERO_NAME`,`AERO_MOBILE_NUMBER`,`BLO_NAME`,`BLO_MOBILE_NUMBER`,`ERO_NAME`,`ERO_MOBILE_NUMBER`,`DEO_NAME`,`DEO_MOBILE_NUMBER`,`ASSEMBLY_CONSTITUENCY`,`PARLIAMENT_CONSTITUENCY`,`POLLING_STATION`,`ELECTION_TYPE`,`ELECTION_YEAR`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final BoothModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.boothID == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.boothID);
            }
            if (entity.aeroName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.aeroName);
            }
            if (entity.aeroMobileNo == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, entity.aeroMobileNo.intValue());
            }
            if (entity.bloName == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.bloName);
            }
            if (entity.bloMobNo == null) {
                statement.bindNull(6);
            } else {
                statement.bindLong(6, entity.bloMobNo.intValue());
            }
            if (entity.eroName == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.eroName);
            }
            if (entity.eroMobNo == null) {
                statement.bindNull(8);
            } else {
                statement.bindLong(8, entity.eroMobNo.intValue());
            }
            if (entity.deoName == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.deoName);
            }
            if (entity.deoMobNo == null) {
                statement.bindNull(10);
            } else {
                statement.bindLong(10, entity.deoMobNo.intValue());
            }
            if (entity.assemblyConstituency == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.assemblyConstituency);
            }
            if (entity.parliamentConstituency == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.parliamentConstituency);
            }
            if (entity.pollingStation == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.pollingStation);
            }
            if (entity.electionType == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.electionType);
            }
            if (entity.electionYear == null) {
                statement.bindNull(15);
            } else {
                statement.bindLong(15, entity.electionYear.intValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<BoothModel> __deleteAdapterOfBoothModel = new EntityDeleteOrUpdateAdapter<BoothModel>() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `BOOTH_LOCATOR` WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final BoothModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<BoothModel> __updateAdapterOfBoothModel = new EntityDeleteOrUpdateAdapter<BoothModel>() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `BOOTH_LOCATOR` SET `ID` = ?,`BOOTH_ID` = ?,`AERO_NAME` = ?,`AERO_MOBILE_NUMBER` = ?,`BLO_NAME` = ?,`BLO_MOBILE_NUMBER` = ?,`ERO_NAME` = ?,`ERO_MOBILE_NUMBER` = ?,`DEO_NAME` = ?,`DEO_MOBILE_NUMBER` = ?,`ASSEMBLY_CONSTITUENCY` = ?,`PARLIAMENT_CONSTITUENCY` = ?,`POLLING_STATION` = ?,`ELECTION_TYPE` = ?,`ELECTION_YEAR` = ? WHERE `ID` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final BoothModel entity) {
            if (entity.id == null) {
                statement.bindNull(1);
            } else {
                statement.bindLong(1, entity.id.longValue());
            }
            if (entity.boothID == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.boothID);
            }
            if (entity.aeroName == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.aeroName);
            }
            if (entity.aeroMobileNo == null) {
                statement.bindNull(4);
            } else {
                statement.bindLong(4, entity.aeroMobileNo.intValue());
            }
            if (entity.bloName == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.bloName);
            }
            if (entity.bloMobNo == null) {
                statement.bindNull(6);
            } else {
                statement.bindLong(6, entity.bloMobNo.intValue());
            }
            if (entity.eroName == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.eroName);
            }
            if (entity.eroMobNo == null) {
                statement.bindNull(8);
            } else {
                statement.bindLong(8, entity.eroMobNo.intValue());
            }
            if (entity.deoName == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.deoName);
            }
            if (entity.deoMobNo == null) {
                statement.bindNull(10);
            } else {
                statement.bindLong(10, entity.deoMobNo.intValue());
            }
            if (entity.assemblyConstituency == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.assemblyConstituency);
            }
            if (entity.parliamentConstituency == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.parliamentConstituency);
            }
            if (entity.pollingStation == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.pollingStation);
            }
            if (entity.electionType == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.electionType);
            }
            if (entity.electionYear == null) {
                statement.bindNull(15);
            } else {
                statement.bindLong(15, entity.electionYear.intValue());
            }
            if (entity.id == null) {
                statement.bindNull(16);
            } else {
                statement.bindLong(16, entity.id.longValue());
            }
        }
    };

    public BoothDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.BoothDao
    public Completable insert(final BoothModel boothModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(boothModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insert$0(BoothModel boothModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfBoothModel.insert(sQLiteConnection, boothModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.BoothDao
    public Completable delete(final BoothModel boothModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(boothModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$delete$1(BoothModel boothModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfBoothModel.handle(sQLiteConnection, boothModel);
        return Unit.INSTANCE;
    }

    @Override // in.gov.eci.bloapp.room.dao.BoothDao
    public Completable update(final BoothModel boothModel) {
        return RxRoom.createCompletable(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.BoothDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$2(boothModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$update$2(BoothModel boothModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfBoothModel.handle(sQLiteConnection, boothModel);
        return Unit.INSTANCE;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
