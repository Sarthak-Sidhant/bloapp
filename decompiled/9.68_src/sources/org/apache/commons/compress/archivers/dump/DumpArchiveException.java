package org.apache.commons.compress.archivers.dump;

import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DumpArchiveException extends IOException {
    private static final long serialVersionUID = 1;

    public DumpArchiveException() {
    }

    public DumpArchiveException(String str) {
        super(str);
    }

    public DumpArchiveException(Throwable th) {
        initCause(th);
    }

    public DumpArchiveException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
