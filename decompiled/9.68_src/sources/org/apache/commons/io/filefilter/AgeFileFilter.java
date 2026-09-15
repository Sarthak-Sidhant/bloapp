package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AgeFileFilter extends AbstractFileFilter {
    private boolean acceptOlder;
    private long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean zIsFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            return !zIsFileNewer;
        }
        return zIsFileNewer;
    }
}
