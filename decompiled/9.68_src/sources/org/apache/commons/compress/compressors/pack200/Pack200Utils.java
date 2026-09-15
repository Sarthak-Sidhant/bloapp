package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File file) throws IOException {
        normalize(file, file, null);
    }

    public static void normalize(File file, Map<String, String> map) throws IOException {
        normalize(file, file, map);
    }

    public static void normalize(File file, File file2) throws IOException {
        normalize(file, file2, null);
    }

    public static void normalize(File file, File file2, Map<String, String> map) throws IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("pack.segment.limit", "-1");
        File fileCreateTempFile = File.createTempFile("commons-compress", "pack200normalize");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    Pack200.Packer packerNewPacker = Pack200.newPacker();
                    packerNewPacker.properties().putAll(map);
                    packerNewPacker.pack(jarFile, fileOutputStream);
                    jarFile.close();
                    fileOutputStream.close();
                    Pack200.Unpacker unpackerNewUnpacker = Pack200.newUnpacker();
                    JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
                    try {
                        unpackerNewUnpacker.unpack(fileCreateTempFile, jarOutputStream);
                        jarOutputStream.close();
                        if (fileCreateTempFile.delete()) {
                            return;
                        }
                        fileCreateTempFile.deleteOnExit();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                jarOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            jarFile.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            if (!fileCreateTempFile.delete()) {
                fileCreateTempFile.deleteOnExit();
            }
            throw th10;
        }
    }
}
