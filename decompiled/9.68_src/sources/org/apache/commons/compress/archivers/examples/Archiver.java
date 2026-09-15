package org.apache.commons.compress.archivers.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Archiver {

    private interface ArchiveEntryConsumer {
        void accept(File file, ArchiveEntry archiveEntry) throws IOException;
    }

    private interface ArchiveEntryCreator {
        ArchiveEntry create(File file, String str) throws IOException;
    }

    private interface Finisher {
        void finish() throws IOException;
    }

    public void create(String str, File file, File file2) throws ArchiveException, IOException {
        if (prefersSeekableByteChannel(str)) {
            FileChannel fileChannelOpen = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            try {
                create(str, fileChannelOpen, file2, CloseableConsumer.CLOSING_CONSUMER);
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
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        try {
            create(str, outputStreamNewOutputStream, file2, CloseableConsumer.CLOSING_CONSUMER);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    @Deprecated
    public void create(String str, OutputStream outputStream, File file) throws ArchiveException, IOException {
        create(str, outputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void create(String str, OutputStream outputStream, File file, CloseableConsumer closeableConsumer) throws ArchiveException, IOException {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            create((ArchiveOutputStream) closeableConsumerAdapter.track(new ArchiveStreamFactory().createArchiveOutputStream(str, outputStream)), file);
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
    public void create(String str, SeekableByteChannel seekableByteChannel, File file) throws ArchiveException, IOException {
        create(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    public void create(String str, SeekableByteChannel seekableByteChannel, File file, CloseableConsumer closeableConsumer) throws ArchiveException, IOException {
        CloseableConsumerAdapter closeableConsumerAdapter = new CloseableConsumerAdapter(closeableConsumer);
        try {
            if (!prefersSeekableByteChannel(str)) {
                create(str, (OutputStream) closeableConsumerAdapter.track(Channels.newOutputStream(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(str)) {
                create((ArchiveOutputStream) closeableConsumerAdapter.track(new ZipArchiveOutputStream(seekableByteChannel)), file);
            } else if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
                create((SevenZOutputFile) closeableConsumerAdapter.track(new SevenZOutputFile(seekableByteChannel)), file);
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

    public void create(final ArchiveOutputStream archiveOutputStream, File file) throws ArchiveException, IOException {
        create(file, new ArchiveEntryCreator() { // from class: org.apache.commons.compress.archivers.examples.Archiver.1
            @Override // org.apache.commons.compress.archivers.examples.Archiver.ArchiveEntryCreator
            public ArchiveEntry create(File file2, String str) throws IOException {
                return archiveOutputStream.createArchiveEntry(file2, str);
            }
        }, new ArchiveEntryConsumer() { // from class: org.apache.commons.compress.archivers.examples.Archiver.2
            @Override // org.apache.commons.compress.archivers.examples.Archiver.ArchiveEntryConsumer
            public void accept(File file2, ArchiveEntry archiveEntry) throws IOException {
                archiveOutputStream.putArchiveEntry(archiveEntry);
                if (!archiveEntry.isDirectory()) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file2.toPath(), new OpenOption[0]));
                    try {
                        IOUtils.copy(bufferedInputStream, archiveOutputStream);
                        bufferedInputStream.close();
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
                archiveOutputStream.closeArchiveEntry();
            }
        }, new Finisher() { // from class: org.apache.commons.compress.archivers.examples.Archiver.3
            @Override // org.apache.commons.compress.archivers.examples.Archiver.Finisher
            public void finish() throws IOException {
                archiveOutputStream.finish();
            }
        });
    }

    public void create(final SevenZOutputFile sevenZOutputFile, File file) throws IOException {
        create(file, new ArchiveEntryCreator() { // from class: org.apache.commons.compress.archivers.examples.Archiver.4
            @Override // org.apache.commons.compress.archivers.examples.Archiver.ArchiveEntryCreator
            public ArchiveEntry create(File file2, String str) throws IOException {
                return sevenZOutputFile.createArchiveEntry(file2, str);
            }
        }, new ArchiveEntryConsumer() { // from class: org.apache.commons.compress.archivers.examples.Archiver.5
            @Override // org.apache.commons.compress.archivers.examples.Archiver.ArchiveEntryConsumer
            public void accept(File file2, ArchiveEntry archiveEntry) throws IOException {
                sevenZOutputFile.putArchiveEntry(archiveEntry);
                if (!archiveEntry.isDirectory()) {
                    byte[] bArr = new byte[8024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file2.toPath(), new OpenOption[0]));
                    while (true) {
                        try {
                            int i = bufferedInputStream.read(bArr);
                            if (-1 == i) {
                                break;
                            } else {
                                sevenZOutputFile.write(bArr, 0, i);
                            }
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
                    bufferedInputStream.close();
                }
                sevenZOutputFile.closeArchiveEntry();
            }
        }, new Finisher() { // from class: org.apache.commons.compress.archivers.examples.Archiver.6
            @Override // org.apache.commons.compress.archivers.examples.Archiver.Finisher
            public void finish() throws IOException {
                sevenZOutputFile.finish();
            }
        });
    }

    private boolean prefersSeekableByteChannel(String str) {
        return ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str);
    }

    private void create(File file, ArchiveEntryCreator archiveEntryCreator, ArchiveEntryConsumer archiveEntryConsumer, Finisher finisher) throws IOException {
        create("", file, archiveEntryCreator, archiveEntryConsumer);
        finisher.finish();
    }

    private void create(String str, File file, ArchiveEntryCreator archiveEntryCreator, ArchiveEntryConsumer archiveEntryConsumer) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String str2 = str + file2.getName() + (file2.isDirectory() ? "/" : "");
            archiveEntryConsumer.accept(file2, archiveEntryCreator.create(file2, str2));
            if (file2.isDirectory()) {
                create(str2, file2, archiveEntryCreator, archiveEntryConsumer);
            }
        }
    }
}
