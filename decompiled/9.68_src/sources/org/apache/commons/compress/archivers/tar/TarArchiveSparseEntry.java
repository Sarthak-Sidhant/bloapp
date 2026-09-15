package org.apache.commons.compress.archivers.tar;

import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class TarArchiveSparseEntry implements TarConstants {
    private final boolean isExtended;

    public TarArchiveSparseEntry(byte[] bArr) throws IOException {
        this.isExtended = TarUtils.parseBoolean(bArr, TarConstants.SPARSELEN_GNU_SPARSE);
    }

    public boolean isExtended() {
        return this.isExtended;
    }
}
