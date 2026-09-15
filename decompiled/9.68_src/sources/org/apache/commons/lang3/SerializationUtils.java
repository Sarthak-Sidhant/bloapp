package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SerializationUtils {

    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        static {
            HashMap map = new HashMap();
            primitiveTypes = map;
            map.put("byte", Byte.TYPE);
            map.put("short", Short.TYPE);
            map.put(XmlErrorCodes.INT, Integer.TYPE);
            map.put(XmlErrorCodes.LONG, Long.TYPE);
            map.put(XmlErrorCodes.FLOAT, Float.TYPE);
            map.put(XmlErrorCodes.DOUBLE, Double.TYPE);
            map.put(XmlErrorCodes.BOOLEAN, Boolean.TYPE);
            map.put("char", Character.TYPE);
            map.put("void", Void.TYPE);
        }

        ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException e) {
                    Class<?> cls = primitiveTypes.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw e;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }

    public static <T extends Serializable> T clone(T t) {
        if (t == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serialize(t));
        Class cls = ObjectUtils.getClass(t);
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(byteArrayInputStream, cls.getClassLoader());
            try {
                T t2 = (T) cls.cast(classLoaderAwareObjectInputStream.readObject());
                classLoaderAwareObjectInputStream.close();
                return t2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        classLoaderAwareObjectInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(String.format("%s while reading cloned object data", e.getClass().getSimpleName()), e);
        }
    }

    public static <T> T deserialize(byte[] bArr) {
        Objects.requireNonNull(bArr, "objectData");
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    public static <T> T deserialize(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputStream");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (T) deserialize(serialize(t));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Objects.requireNonNull(outputStream, "outputStream");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
