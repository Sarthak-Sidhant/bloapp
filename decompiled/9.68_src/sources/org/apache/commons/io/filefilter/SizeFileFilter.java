package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SizeFileFilter extends AbstractFileFilter {
    private boolean acceptLarger;
    private long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j;
        this.acceptLarger = z;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z = file.length() < this.size;
        if (this.acceptLarger) {
            return !z;
        }
        return z;
    }
}
