package net.sqlcipher;

import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long initialAllocationSize = FileUtils.ONE_MB;
    private long WindowAllocationUnbounded = 0;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
