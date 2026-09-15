package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FileManager {
    public static final String FILES_DIR_DEFAULT = "imageTemp";
    private static final String a = "FileManager";

    public static boolean deleteDir(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteLocalFile(Context context, String str) {
        return deleteLocalFile(context, FILES_DIR_DEFAULT, str);
    }

    public static String getFileStoragePath(Context context, String str, String str2, String str3) {
        try {
            return new File(context.getDir(FILES_DIR_DEFAULT, 0), str).getAbsolutePath();
        } catch (Exception e) {
            L.logError(str2, str3, e);
            return null;
        }
    }

    public static byte[] readByteArrayFromContentUri(Context context, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        InputStream inputStreamOpenInputStream = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    L.logWarning(a, "Error closing stream", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    L.logWarning(a, "Error closing stream", e2);
                }
            }
            throw th;
        }
    }

    public static byte[] readByteArrayFromFile(Context context, String str) {
        return readByteArrayFromFile(context, FILES_DIR_DEFAULT, str);
    }

    public static byte[] readByteArrayFromFileThrowing(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(str);
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            L.logWarning(a, "Error closing stream", e);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            L.logWarning(a, "Error closing stream", e2);
                        }
                    }
                    throw th;
                }
            }
            fileInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFile(String str) {
        try {
            return (T) readSerializedFromFileThrowing(str);
        } catch (FileNotFoundException e) {
            L.logError(a, "Missing file for read bytes", e);
            return null;
        } catch (IOException e2) {
            L.logError(a, "Error reading bytes", e2);
            return null;
        } catch (ClassNotFoundException e3) {
            L.logError(a, "Error decoding bytes", e3);
            return null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFileThrowing(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File(str)));
            try {
                T t = (T) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    L.logWarning(a, "Error closing stream", e);
                }
                return t;
            } catch (Throwable th) {
                th = th;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                        L.logWarning(a, "Error closing stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
        }
    }

    public static String saveByteArrayToFile(Context context, byte[] bArr, String str) throws IOException {
        return saveByteArrayToFile(context, bArr, FILES_DIR_DEFAULT, str);
    }

    public static String saveSerializedToFile(Context context, Serializable serializable, String str, String str2) throws Throwable {
        File file = new File(context.getDir(str, 0), str2);
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                    try {
                        objectOutputStream2.writeObject(serializable);
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        L.logError(a, "Error saving bytes", e);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        return file.getAbsolutePath();
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e2) {
                                L.logWarning(a, "Error closing stream", e2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
                return file.getAbsolutePath();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            L.logWarning(a, "Error closing stream", e4);
        }
    }

    public static boolean deleteLocalFile(Context context, String str, String str2) {
        return new File(context.getDir(str, 0), str2).delete();
    }

    public static byte[] readByteArrayFromFile(Context context, String str, String str2) {
        return readByteArrayFromFile(new File(context.getDir(str, 0), str2).getAbsolutePath());
    }

    public static String saveByteArrayToFile(Context context, byte[] bArr, String str, String str2) throws Throwable {
        File file = new File(context.getDir(str, 0), str2);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.close();
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        L.logError(a, "Error saving bytes", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return file.getAbsolutePath();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                L.logWarning(a, "Error closing stream", e2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            L.logWarning(a, "Error closing stream", e4);
        }
        return file.getAbsolutePath();
    }

    public static byte[] readByteArrayFromFile(String str) {
        try {
            return readByteArrayFromFileThrowing(str);
        } catch (FileNotFoundException e) {
            L.logError(a, "Missing file for read bytes", e);
            return null;
        } catch (IOException e2) {
            L.logError(a, "Error reading bytes", e2);
            return null;
        }
    }

    public static <T extends Serializable> T readSerializedFromFile(Context context, String str, String str2) {
        return (T) readSerializedFromFile(new File(context.getDir(str, 0), str2).getAbsolutePath());
    }
}
