package net.sqlcipher;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i, int i2) {
        super("Index " + i + " requested, with a size of " + i2);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
