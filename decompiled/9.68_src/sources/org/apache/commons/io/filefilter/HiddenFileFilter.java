package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HiddenFileFilter extends AbstractFileFilter {
    public static final IOFileFilter HIDDEN;
    public static final IOFileFilter VISIBLE;

    static {
        HiddenFileFilter hiddenFileFilter = new HiddenFileFilter();
        HIDDEN = hiddenFileFilter;
        VISIBLE = new NotFileFilter(hiddenFileFilter);
    }

    protected HiddenFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.isHidden();
    }
}
