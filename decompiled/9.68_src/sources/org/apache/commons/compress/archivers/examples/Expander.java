package org.apache.commons.compress.archivers.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Expander {

    private interface ArchiveEntrySupplier {
        ArchiveEntry getNextReadableEntry() throws IOException;
    }

    private interface EntryWriter {
        void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException;
    }

    public void expand(File file, File file2) throws ArchiveException, IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]));
        try {
            new ArchiveStreamFactory();
            String strDetect = ArchiveStreamFactory.detect(bufferedInputStream);
            bufferedInputStream.close();
            expand(strDetect, file, file2);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void expand(String str, File file, File file2) throws ArchiveException, IOException {
        if (prefersSeekableByteChannel(str)) {
            FileChannel fileChannelOpen = FileChannel.open(file.toPath(), StandardOpenOption.READ);
            try {
                expand(str, fileChannelOpen, file2, CloseableConsumer.CLOSING_CONSUMER);
                if (fileChannelOpen != null) {
                    fileChannelOpen.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (fileChannelOpen != null) {
                        try {
                            fileChannelOpen.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]));
        try {
            expand(str, bufferedInputStream, file2, CloseableConsumer.CLOSING_CONSUMER);
            bufferedInputStream.close();
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    @Deprecated
    public void expand(InputStream inputStream, File file) throws ArchiveException, IOException {
        expand(inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(InputStream inputStream, File file, CloseableConsumer closeableConsumer) throws ArchiveException, IOException {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            expand((ArchiveInputStream) closeableConsumerAdapter.track(new ArchiveStreamFactory().createArchiveInputStream(inputStream)), file);
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public void expand(String str, InputStream inputStream, File file) throws ArchiveException, IOException {
        expand(str, inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(String str, InputStream inputStream, File file, CloseableConsumer closeableConsumer) throws ArchiveException, IOException {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            expand((ArchiveInputStream) closeableConsumerAdapter.track(new ArchiveStreamFactory().createArchiveInputStream(str, inputStream)), file);
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public void expand(String str, SeekableByteChannel seekableByteChannel, File file) throws ArchiveException, IOException {
        expand(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void expand(String str, SeekableByteChannel seekableByteChannel, File file, CloseableConsumer closeableConsumer) throws ArchiveException, IOException {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            if (!prefersSeekableByteChannel(str)) {
                expand(str, (InputStream) closeableConsumerAdapter.track(Channels.newInputStream(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(str)) {
                expand((ZipFile) closeableConsumerAdapter.track(new ZipFile(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
                expand((SevenZFile) closeableConsumerAdapter.track(new SevenZFile(seekableByteChannel)), file);
            } else {
                throw new ArchiveException("Don't know how to handle format " + str);
            }
            closeableConsumerAdapter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    closeableConsumerAdapter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void expand(final ArchiveInputStream archiveInputStream, File file) throws ArchiveException, IOException {
        expand(new ArchiveEntrySupplier() { // from class: org.apache.commons.compress.archivers.examples.Expander.1
            @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
            public ArchiveEntry getNextReadableEntry() throws IOException {
                ArchiveEntry nextEntry = archiveInputStream.getNextEntry();
                while (nextEntry != null && !archiveInputStream.canReadEntryData(nextEntry)) {
                    nextEntry = archiveInputStream.getNextEntry();
                }
                return nextEntry;
            }
        }, new EntryWriter() { // from class: org.apache.commons.compress.archivers.examples.Expander.2
            @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
            public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
                IOUtils.copy(archiveInputStream, outputStream);
            }
        }, file);
    }

    public void expand(final ZipFile zipFile, File file) throws ArchiveException, IOException {
        final Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
        expand(new ArchiveEntrySupplier() { // from class: org.apache.commons.compress.archivers.examples.Expander.3
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0013, code lost:
            
                r0 = null;
             */
            @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public org.apache.commons.compress.archivers.ArchiveEntry getNextReadableEntry() throws java.io.IOException {
                /*
                    r3 = this;
                    java.util.Enumeration r0 = r2
                    boolean r0 = r0.hasMoreElements()
                    r1 = 0
                    if (r0 == 0) goto L12
                    java.util.Enumeration r0 = r2
                    java.lang.Object r0 = r0.nextElement()
                    org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
                    goto L13
                L12:
                    r0 = r1
                L13:
                    if (r0 == 0) goto L2e
                    org.apache.commons.compress.archivers.zip.ZipFile r2 = r3
                    boolean r2 = r2.canReadEntryData(r0)
                    if (r2 != 0) goto L2e
                    java.util.Enumeration r0 = r2
                    boolean r0 = r0.hasMoreElements()
                    if (r0 == 0) goto L12
                    java.util.Enumeration r0 = r2
                    java.lang.Object r0 = r0.nextElement()
                    org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
                    goto L13
                L2e:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.AnonymousClass3.getNextReadableEntry():org.apache.commons.compress.archivers.ArchiveEntry");
            }
        }, new EntryWriter() { // from class: org.apache.commons.compress.archivers.examples.Expander.4
            @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
            public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
                InputStream inputStream = zipFile.getInputStream((ZipArchiveEntry) archiveEntry);
                try {
                    IOUtils.copy(inputStream, outputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
        }, file);
    }

    public void expand(final SevenZFile sevenZFile, File file) throws ArchiveException, IOException {
        expand(new ArchiveEntrySupplier() { // from class: org.apache.commons.compress.archivers.examples.Expander.5
            @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
            public ArchiveEntry getNextReadableEntry() throws IOException {
                return sevenZFile.getNextEntry();
            }
        }, new EntryWriter() { // from class: org.apache.commons.compress.archivers.examples.Expander.6
            @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
            public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
                byte[] bArr = new byte[8024];
                while (true) {
                    int i = sevenZFile.read(bArr);
                    if (-1 == i) {
                        return;
                    } else {
                        outputStream.write(bArr, 0, i);
                    }
                }
            }
        }, file);
    }

    private boolean prefersSeekableByteChannel(String str) {
        return ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str);
    }

    private void expand(ArchiveEntrySupplier archiveEntrySupplier, EntryWriter entryWriter, File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith(File.separator)) {
            canonicalPath = canonicalPath + File.separator;
        }
        ArchiveEntry nextReadableEntry = archiveEntrySupplier.getNextReadableEntry();
        while (nextReadableEntry != null) {
            File file2 = new File(file, nextReadableEntry.getName());
            if (!file2.getCanonicalPath().startsWith(canonicalPath)) {
                throw new IOException("Expanding " + nextReadableEntry.getName() + " would create file outside of " + file);
            }
            if (nextReadableEntry.isDirectory()) {
                if (!file2.isDirectory() && !file2.mkdirs()) {
                    throw new IOException("Failed to create directory " + file2);
                }
            } else {
                File parentFile = file2.getParentFile();
                if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + parentFile);
                }
                OutputStream outputStreamNewOutputStream = Files.newOutputStream(file2.toPath(), new OpenOption[0]);
                try {
                    entryWriter.writeEntryDataTo(nextReadableEntry, outputStreamNewOutputStream);
                    if (outputStreamNewOutputStream != null) {
                        outputStreamNewOutputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (outputStreamNewOutputStream != null) {
                            try {
                                outputStreamNewOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            nextReadableEntry = archiveEntrySupplier.getNextReadableEntry();
        }
    }
}
