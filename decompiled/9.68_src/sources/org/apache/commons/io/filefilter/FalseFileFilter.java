package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FalseFileFilter implements IOFileFilter {
    public static final IOFileFilter FALSE;
    public static final IOFileFilter INSTANCE;

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return false;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return false;
    }

    static {
        FalseFileFilter falseFileFilter = new FalseFileFilter();
        FALSE = falseFileFilter;
        INSTANCE = falseFileFilter;
    }

    protected FalseFileFilter() {
    }
}
