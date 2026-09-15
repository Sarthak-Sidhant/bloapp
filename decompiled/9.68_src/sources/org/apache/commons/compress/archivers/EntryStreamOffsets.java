package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface EntryStreamOffsets {
    public static final long OFFSET_UNKNOWN = -1;

    long getDataOffset();

    boolean isStreamContiguous();
}
