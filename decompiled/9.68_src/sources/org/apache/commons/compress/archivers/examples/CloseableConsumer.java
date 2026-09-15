package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface CloseableConsumer {
    public static final CloseableConsumer CLOSING_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.CloseableConsumer.1
        @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
        public void accept(Closeable closeable) throws IOException {
            closeable.close();
        }
    };
    public static final CloseableConsumer NULL_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.CloseableConsumer.2
        @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
        public void accept(Closeable closeable) {
        }
    };

    void accept(Closeable closeable) throws IOException;
}
