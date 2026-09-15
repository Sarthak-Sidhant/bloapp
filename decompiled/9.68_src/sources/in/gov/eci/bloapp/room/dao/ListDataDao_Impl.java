package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.entity.ListData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ListDataDao_Impl implements ListDataDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<ListData> __insertAdapterOfListData = new EntityInsertAdapter<ListData>() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl.1
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `ListData` (`docCode`,`docName`,`lists`,`lastUpdated`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final ListData entity) {
            if (entity.docCode == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.docCode);
            }
            if (entity.docName == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.docName);
            }
            if (entity.lists == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.lists);
            }
            statement.bindLong(4, entity.getLastUpdated());
        }
    };

    public ListDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public void insertAll(final List<ListData> listData) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insertAll$0(listData, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insertAll$0(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfListData.insert(sQLiteConnection, list);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public List<ListData> getList(final String list) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListDataDao_Impl.lambda$getList$1(list, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getList$1(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from ListData where lists =?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "docCode");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "docName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "lists");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdated");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                ListData listData = new ListData();
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow)) {
                    listData.docCode = null;
                } else {
                    listData.docCode = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow2)) {
                    listData.docName = null;
                } else {
                    listData.docName = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    listData.lists = null;
                } else {
                    listData.lists = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                }
                listData.setLastUpdated(sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                arrayList.add(listData);
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public int getCount() {
        return ((Integer) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListDataDao_Impl.lambda$getCount$2((SQLiteConnection) obj);
            }
        })).intValue();
    }

    static /* synthetic */ Integer lambda$getCount$2(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select count(*) from ListData");
        try {
            return Integer.valueOf(sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public Long getLastUpdatedTime() {
        return (Long) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListDataDao_Impl.lambda$getLastUpdatedTime$3((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Long lambda$getLastUpdatedTime$3(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select lastUpdated from ListData order by lastUpdated desc limit 1");
        try {
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public void clearTable() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListDataDao_Impl.lambda$clearTable$4((SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$clearTable$4(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("delete from ListData");
        try {
            sQLiteStatementPrepare.step();
            return null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.ListDataDao
    public void setLastUpdatedTime(final Long lastUpdated) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.ListDataDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListDataDao_Impl.lambda$setLastUpdatedTime$5(lastUpdated, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$setLastUpdatedTime$5(Long l, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE ListData set lastUpdated =? ");
        try {
            if (l == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindLong(1, l.longValue());
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
