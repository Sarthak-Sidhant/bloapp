package net.sqlcipher;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class CursorWrapper extends android.database.CursorWrapper implements Cursor {
    private final Cursor mCursor;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        this.mCursor = cursor;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i) {
        return this.mCursor.getType(i);
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.mCursor;
    }
}
