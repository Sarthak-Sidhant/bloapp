package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ArchiveException extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public ArchiveException(String str) {
        super(str);
    }

    public ArchiveException(String str, Exception exc) {
        super(str);
        initCause(exc);
    }
}
