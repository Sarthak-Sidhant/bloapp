package org.apache.commons.compress.archivers.dump;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UnrecognizedFormatException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnrecognizedFormatException() {
        super("this is not a recognized format.");
    }
}
