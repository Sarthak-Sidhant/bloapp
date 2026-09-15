package net.sqlcipher.database;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
