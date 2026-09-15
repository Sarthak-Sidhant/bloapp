package net.sqlcipher.database;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {
    private static final String s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(s);
    }
}
