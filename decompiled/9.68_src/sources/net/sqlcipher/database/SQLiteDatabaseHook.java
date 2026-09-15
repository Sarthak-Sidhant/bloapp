package net.sqlcipher.database;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SQLiteDatabaseHook {
    void postKey(SQLiteDatabase sQLiteDatabase);

    void preKey(SQLiteDatabase sQLiteDatabase);
}
