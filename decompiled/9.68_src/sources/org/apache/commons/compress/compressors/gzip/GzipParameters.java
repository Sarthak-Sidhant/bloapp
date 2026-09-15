package org.apache.commons.compress.compressors.gzip;

import kotlin.KotlinVersion;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class GzipParameters {
    private String comment;
    private String filename;
    private long modificationTime;
    private int compressionLevel = -1;
    private int operatingSystem = KotlinVersion.MAX_COMPONENT_VALUE;

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid gzip compression level: " + i);
        }
        this.compressionLevel = i;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public void setModificationTime(long j) {
        this.modificationTime = j;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public int getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(int i) {
        this.operatingSystem = i;
    }
}
