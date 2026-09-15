package net.sqlcipher.database;

import android.database.Cursor;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor cursor);

    net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory cursorFactory, String[] strArr);

    void setBindArguments(String[] strArr);
}
