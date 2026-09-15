package net.sqlcipher;

import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
