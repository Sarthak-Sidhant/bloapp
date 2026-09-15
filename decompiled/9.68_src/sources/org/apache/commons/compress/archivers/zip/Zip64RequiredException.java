package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Zip64RequiredException extends ZipException {
    static final String ARCHIVE_TOO_BIG_MESSAGE = "Archive's size exceeds the limit of 4GByte.";
    static final String TOO_MANY_ENTRIES_MESSAGE = "Archive contains more than 65535 entries.";
    private static final long serialVersionUID = 20110809;

    static String getEntryTooBigMessage(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getName() + "'s size exceeds the limit of 4GByte.";
    }

    public Zip64RequiredException(String str) {
        super(str);
    }
}
