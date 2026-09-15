package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CLI {

    private enum Mode {
        LIST("Analysing") { // from class: org.apache.commons.compress.archivers.sevenz.CLI.Mode.1
            @Override // org.apache.commons.compress.archivers.sevenz.CLI.Mode
            public void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) {
                System.out.print(sevenZArchiveEntry.getName());
                if (sevenZArchiveEntry.isDirectory()) {
                    System.out.print(" dir");
                } else {
                    System.out.print(StringUtils.SPACE + sevenZArchiveEntry.getCompressedSize() + "/" + sevenZArchiveEntry.getSize());
                }
                if (sevenZArchiveEntry.getHasLastModifiedDate()) {
                    System.out.print(StringUtils.SPACE + sevenZArchiveEntry.getLastModifiedDate());
                } else {
                    System.out.print(" no last modified date");
                }
                if (!sevenZArchiveEntry.isDirectory()) {
                    System.out.println(StringUtils.SPACE + getContentMethods(sevenZArchiveEntry));
                } else {
                    System.out.println("");
                }
            }

            private String getContentMethods(SevenZArchiveEntry sevenZArchiveEntry) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (SevenZMethodConfiguration sevenZMethodConfiguration : sevenZArchiveEntry.getContentMethods()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(sevenZMethodConfiguration.getMethod());
                    if (sevenZMethodConfiguration.getOptions() != null) {
                        sb.append("(").append(sevenZMethodConfiguration.getOptions()).append(")");
                    }
                    z = false;
                }
                return sb.toString();
            }
        },
        EXTRACT("Extracting") { // from class: org.apache.commons.compress.archivers.sevenz.CLI.Mode.2
            private final byte[] buf = new byte[8192];

            @Override // org.apache.commons.compress.archivers.sevenz.CLI.Mode
            public void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
                File file = new File(sevenZArchiveEntry.getName());
                if (sevenZArchiveEntry.isDirectory()) {
                    if (!file.isDirectory() && !file.mkdirs()) {
                        throw new IOException("Cannot create directory " + file);
                    }
                    System.out.println("created directory " + file);
                    return;
                }
                System.out.println("extracting to " + file);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    throw new IOException("Cannot create " + parentFile);
                }
                OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
                try {
                    long size = sevenZArchiveEntry.getSize();
                    long j = 0;
                    while (j < size) {
                        int i = sevenZFile.read(this.buf, 0, (int) Math.min(size - j, this.buf.length));
                        if (i < 1) {
                            throw new IOException("Reached end of entry " + sevenZArchiveEntry.getName() + " after " + j + " bytes, expected " + size);
                        }
                        j += (long) i;
                        outputStreamNewOutputStream.write(this.buf, 0, i);
                    }
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
        };

        private final String message;

        public abstract void takeAction(SevenZFile sevenZFile, SevenZArchiveEntry sevenZArchiveEntry) throws IOException;

        Mode(String str) {
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            usage();
            return;
        }
        Mode modeGrabMode = grabMode(strArr);
        System.out.println(modeGrabMode.getMessage() + StringUtils.SPACE + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            System.err.println(file + " doesn't exist or is a directory");
        }
        SevenZFile sevenZFile = new SevenZFile(file);
        while (true) {
            try {
                SevenZArchiveEntry nextEntry = sevenZFile.getNextEntry();
                if (nextEntry != null) {
                    modeGrabMode.takeAction(sevenZFile, nextEntry);
                } else {
                    sevenZFile.close();
                    return;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        sevenZFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [list|extract]");
    }

    private static Mode grabMode(String[] strArr) {
        if (strArr.length < 2) {
            return Mode.LIST;
        }
        return (Mode) Enum.valueOf(Mode.class, strArr[1].toUpperCase());
    }
}
