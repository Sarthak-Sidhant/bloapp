package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
final class CloseableConsumerAdapter implements Closeable {
    private Closeable closeable;
    private final CloseableConsumer consumer;

    CloseableConsumerAdapter(CloseableConsumer closeableConsumer) {
        if (closeableConsumer == null) {
            throw new NullPointerException("consumer must not be null");
        }
        this.consumer = closeableConsumer;
    }

    <C extends Closeable> C track(C c) {
        this.closeable = c;
        return c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Closeable closeable = this.closeable;
        if (closeable != null) {
            this.consumer.accept(closeable);
        }
    }
}
