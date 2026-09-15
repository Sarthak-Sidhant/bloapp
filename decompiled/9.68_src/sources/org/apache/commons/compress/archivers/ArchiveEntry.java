package org.apache.commons.compress.archivers;

import java.util.Date;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ArchiveEntry {
    public static final long SIZE_UNKNOWN = -1;

    Date getLastModifiedDate();

    String getName();

    long getSize();

    boolean isDirectory();
}
