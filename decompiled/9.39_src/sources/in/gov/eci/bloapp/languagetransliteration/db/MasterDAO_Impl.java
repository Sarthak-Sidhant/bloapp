package in.gov.eci.bloapp.languagetransliteration.db;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MasterDAO_Impl implements MasterDAO {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<TState> __insertAdapterOfTState = new EntityInsertAdapter<TState>() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl.1
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `table_state` (`id`,`state_name`,`state_code`,`status`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final TState entity) {
            statement.bindLong(1, entity.id);
            if (entity.state_name == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.state_name);
            }
            if (entity.state_code == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.state_code);
            }
            statement.bindLong(4, entity.status);
        }
    };
    private final EntityInsertAdapter<TDistrict> __insertAdapterOfTDistrict = new EntityInsertAdapter<TDistrict>() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl.2
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `table_district` (`id`,`dist_name`,`state_code`,`dist_code`,`core_document_enabled`,`status`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, TDistrict tDistrict) {
            sQLiteStatement.bindLong(1, tDistrict.id);
            if (tDistrict.dist_name == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, tDistrict.dist_name);
            }
            if (tDistrict.state_code == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, tDistrict.state_code);
            }
            if (tDistrict.dist_code == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindText(4, tDistrict.dist_code);
            }
            sQLiteStatement.bindLong(5, tDistrict.core_document_enabled ? 1L : 0L);
            sQLiteStatement.bindLong(6, tDistrict.status);
        }
    };
    private final EntityInsertAdapter<TAc> __insertAdapterOfTAc = new EntityInsertAdapter<TAc>() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl.3
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `table_ac` (`id`,`ac_name`,`ac_code`,`state_code`,`dist_code`,`st_lang_code`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final TAc entity) {
            statement.bindLong(1, entity.id);
            if (entity.ac_name == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.ac_name);
            }
            if (entity.ac_code == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.ac_code);
            }
            if (entity.state_code == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.state_code);
            }
            if (entity.dist_code == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.dist_code);
            }
            if (entity.st_lang_code == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.st_lang_code);
            }
        }
    };

    public MasterDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void insertStates(final TState... states) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insertStates$0(states, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insertStates$0(TState[] tStateArr, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfTState.insert(sQLiteConnection, tStateArr);
        return null;
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void insertDistricts(final TDistrict... districts) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insertDistricts$1(districts, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insertDistricts$1(TDistrict[] tDistrictArr, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfTDistrict.insert(sQLiteConnection, tDistrictArr);
        return null;
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void insertAcs(final TAc... acs) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insertAcs$2(acs, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insertAcs$2(TAc[] tAcArr, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfTAc.insert(sQLiteConnection, tAcArr);
        return null;
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public List<TState> getStates() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$getStates$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getStates$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from table_state ORDER BY state_name ASC");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state_code");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                TState tState = new TState();
                tState.id = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    tState.state_name = null;
                } else {
                    tState.state_name = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    tState.state_code = null;
                } else {
                    tState.state_code = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                tState.status = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                arrayList.add(tState);
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public List<TDistrict> getDistricts(final String state_code) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$getDistricts$4(state_code, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getDistricts$4(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from table_district where state_code=? ORDER BY dist_name ASC");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dist_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state_code");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dist_code");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "core_document_enabled");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                TDistrict tDistrict = new TDistrict();
                tDistrict.id = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    tDistrict.dist_name = null;
                } else {
                    tDistrict.dist_name = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    tDistrict.state_code = null;
                } else {
                    tDistrict.state_code = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow4)) {
                    tDistrict.dist_code = null;
                } else {
                    tDistrict.dist_code = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                }
                tDistrict.core_document_enabled = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                tDistrict.status = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                arrayList.add(tDistrict);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public List<TAc> getAcs(final String state_code) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$getAcs$5(state_code, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAcs$5(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from table_ac where state_code=? ORDER BY ac_name ASC");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ac_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ac_code");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state_code");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dist_code");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "st_lang_code");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                TAc tAc = new TAc();
                tAc.id = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    tAc.ac_name = null;
                } else {
                    tAc.ac_name = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    tAc.ac_code = null;
                } else {
                    tAc.ac_code = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow4)) {
                    tAc.state_code = null;
                } else {
                    tAc.state_code = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow5)) {
                    tAc.dist_code = null;
                } else {
                    tAc.dist_code = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow6)) {
                    tAc.st_lang_code = null;
                } else {
                    tAc.st_lang_code = sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                }
                arrayList.add(tAc);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public TAc getAc(final String state_code, final String ac_code) {
        return (TAc) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$getAc$6(state_code, ac_code, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ TAc lambda$getAc$6(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from table_ac where state_code=? and ac_code=? ORDER BY ac_name ASC");
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
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ac_name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "ac_code");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state_code");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dist_code");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "st_lang_code");
            TAc tAc = null;
            if (sQLiteStatementPrepare.step()) {
                TAc tAc2 = new TAc();
                tAc2.id = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    tAc2.ac_name = null;
                } else {
                    tAc2.ac_name = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    tAc2.ac_code = null;
                } else {
                    tAc2.ac_code = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow4)) {
                    tAc2.state_code = null;
                } else {
                    tAc2.state_code = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow5)) {
                    tAc2.dist_code = null;
                } else {
                    tAc2.dist_code = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow6)) {
                    tAc2.st_lang_code = null;
                } else {
                    tAc2.st_lang_code = sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                }
                tAc = tAc2;
            }
            sQLiteStatementPrepare.close();
            return tAc;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void deleteStates() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$deleteStates$7((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteStates$7(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("delete from table_state");
        try {
            sQLiteStatementPrepare.step();
            return null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void deleteDists() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$deleteDists$8((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteDists$8(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("delete from table_district");
        try {
            sQLiteStatementPrepare.step();
            return null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.languagetransliteration.db.MasterDAO
    public void deleteAcs() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.languagetransliteration.db.MasterDAO_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return MasterDAO_Impl.lambda$deleteAcs$9((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteAcs$9(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("delete from table_ac");
        try {
            sQLiteStatementPrepare.step();
            return null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
