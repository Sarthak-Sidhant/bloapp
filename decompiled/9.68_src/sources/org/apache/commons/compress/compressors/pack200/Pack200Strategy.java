package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public enum Pack200Strategy {
    IN_MEMORY { // from class: org.apache.commons.compress.compressors.pack200.Pack200Strategy.1
        @Override // org.apache.commons.compress.compressors.pack200.Pack200Strategy
        StreamBridge newStreamBridge() {
            return new InMemoryCachingStreamBridge();
        }
    },
    TEMP_FILE { // from class: org.apache.commons.compress.compressors.pack200.Pack200Strategy.2
        @Override // org.apache.commons.compress.compressors.pack200.Pack200Strategy
        StreamBridge newStreamBridge() throws IOException {
            return new TempFileCachingStreamBridge();
        }
    };

    abstract StreamBridge newStreamBridge() throws IOException;
}
