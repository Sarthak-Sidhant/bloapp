package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class SupportFactory implements SupportSQLiteOpenHelper.Factory {
    private final boolean clearPassphrase;
    private final SQLiteDatabaseHook hook;
    private final byte[] passphrase;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SupportFactory(byte[] bArr) {
        this(bArr, null);
    }

    public SupportFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(bArr, sQLiteDatabaseHook, true);
    }

    public SupportFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z) {
        this.passphrase = bArr;
        this.hook = sQLiteDatabaseHook;
        this.clearPassphrase = z;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SupportHelper(configuration, this.passphrase, this.hook, this.clearPassphrase);
    }
}
