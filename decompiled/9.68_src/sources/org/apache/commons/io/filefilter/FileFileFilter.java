package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FileFileFilter extends AbstractFileFilter {
    public static final IOFileFilter FILE = new FileFileFilter();

    protected FileFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.isFile();
    }
}
