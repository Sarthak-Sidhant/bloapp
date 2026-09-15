package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.utils.BoundedInputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ScatterZipOutputStream implements Closeable {
    private final ScatterGatherBackingStore backingStore;
    private final StreamCompressor streamCompressor;
    private final Queue<CompressedEntry> items = new ConcurrentLinkedQueue();
    private AtomicBoolean isClosed = new AtomicBoolean();
    private ZipEntryWriter zipEntryWriter = null;

    private static class CompressedEntry {
        final long compressedSize;
        final long crc;
        final long size;
        final ZipArchiveEntryRequest zipArchiveEntryRequest;

        public CompressedEntry(ZipArchiveEntryRequest zipArchiveEntryRequest, long j, long j2, long j3) {
            this.zipArchiveEntryRequest = zipArchiveEntryRequest;
            this.crc = j;
            this.compressedSize = j2;
            this.size = j3;
        }

        public ZipArchiveEntry transferToArchiveEntry() {
            ZipArchiveEntry zipArchiveEntry = this.zipArchiveEntryRequest.getZipArchiveEntry();
            zipArchiveEntry.setCompressedSize(this.compressedSize);
            zipArchiveEntry.setSize(this.size);
            zipArchiveEntry.setCrc(this.crc);
            zipArchiveEntry.setMethod(this.zipArchiveEntryRequest.getMethod());
            return zipArchiveEntry;
        }
    }

    public ScatterZipOutputStream(ScatterGatherBackingStore scatterGatherBackingStore, StreamCompressor streamCompressor) {
        this.backingStore = scatterGatherBackingStore;
        this.streamCompressor = streamCompressor;
    }

    public void addArchiveEntry(ZipArchiveEntryRequest zipArchiveEntryRequest) throws IOException {
        InputStream payloadStream = zipArchiveEntryRequest.getPayloadStream();
        try {
            this.streamCompressor.deflate(payloadStream, zipArchiveEntryRequest.getMethod());
            if (payloadStream != null) {
                payloadStream.close();
            }
            this.items.add(new CompressedEntry(zipArchiveEntryRequest, this.streamCompressor.getCrc32(), this.streamCompressor.getBytesWrittenForLastEntry(), this.streamCompressor.getBytesRead()));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (payloadStream != null) {
                    try {
                        payloadStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0041 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeTo(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            org.apache.commons.compress.parallel.ScatterGatherBackingStore r0 = r6.backingStore
            r0.closeForWriting()
            org.apache.commons.compress.parallel.ScatterGatherBackingStore r0 = r6.backingStore
            java.io.InputStream r0 = r0.getInputStream()
            java.util.Queue<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry> r1 = r6.items     // Catch: java.lang.Throwable -> L41
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L41
        L11:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3b
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L41
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream$CompressedEntry r2 = (org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.CompressedEntry) r2     // Catch: java.lang.Throwable -> L41
            org.apache.commons.compress.utils.BoundedInputStream r3 = new org.apache.commons.compress.utils.BoundedInputStream     // Catch: java.lang.Throwable -> L41
            long r4 = r2.compressedSize     // Catch: java.lang.Throwable -> L41
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L41
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = r2.transferToArchiveEntry()     // Catch: java.lang.Throwable -> L2f
            r7.addRawArchiveEntry(r2, r3)     // Catch: java.lang.Throwable -> L2f
            r3.close()     // Catch: java.lang.Throwable -> L41
            goto L11
        L2f:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L31
        L31:
            r1 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L36
            goto L3a
        L36:
            r2 = move-exception
            r7.addSuppressed(r2)     // Catch: java.lang.Throwable -> L41
        L3a:
            throw r1     // Catch: java.lang.Throwable -> L41
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            return
        L41:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L43
        L43:
            r1 = move-exception
            if (r0 == 0) goto L4e
            r0.close()     // Catch: java.lang.Throwable -> L4a
            goto L4e
        L4a:
            r0 = move-exception
            r7.addSuppressed(r0)
        L4e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.writeTo(org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream):void");
    }

    public static class ZipEntryWriter implements Closeable {
        private final Iterator<CompressedEntry> itemsIterator;
        private final InputStream itemsIteratorData;

        public ZipEntryWriter(ScatterZipOutputStream scatterZipOutputStream) throws IOException {
            scatterZipOutputStream.backingStore.closeForWriting();
            this.itemsIterator = scatterZipOutputStream.items.iterator();
            this.itemsIteratorData = scatterZipOutputStream.backingStore.getInputStream();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.itemsIteratorData;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void writeNextZipEntry(ZipArchiveOutputStream zipArchiveOutputStream) throws IOException {
            CompressedEntry next = this.itemsIterator.next();
            BoundedInputStream boundedInputStream = new BoundedInputStream(this.itemsIteratorData, next.compressedSize);
            try {
                zipArchiveOutputStream.addRawArchiveEntry(next.transferToArchiveEntry(), boundedInputStream);
                boundedInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        boundedInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    public ZipEntryWriter zipEntryWriter() throws IOException {
        if (this.zipEntryWriter == null) {
            this.zipEntryWriter = new ZipEntryWriter(this);
        }
        return this.zipEntryWriter;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed.compareAndSet(false, true)) {
            try {
                ZipEntryWriter zipEntryWriter = this.zipEntryWriter;
                if (zipEntryWriter != null) {
                    zipEntryWriter.close();
                }
                this.backingStore.close();
            } finally {
                this.streamCompressor.close();
            }
        }
    }

    public static ScatterZipOutputStream fileBased(File file) throws FileNotFoundException {
        return fileBased(file, -1);
    }

    public static ScatterZipOutputStream fileBased(File file, int i) throws FileNotFoundException {
        FileBasedScatterGatherBackingStore fileBasedScatterGatherBackingStore = new FileBasedScatterGatherBackingStore(file);
        return new ScatterZipOutputStream(fileBasedScatterGatherBackingStore, StreamCompressor.create(i, fileBasedScatterGatherBackingStore));
    }
}
