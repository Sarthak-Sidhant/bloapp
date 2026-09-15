package org.apache.commons.compress.archivers.dump;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UnsupportedCompressionAlgorithmException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnsupportedCompressionAlgorithmException() {
        super("this file uses an unsupported compression algorithm.");
    }

    public UnsupportedCompressionAlgorithmException(String str) {
        super("this file uses an unsupported compression algorithm: " + str + ".");
    }
}
