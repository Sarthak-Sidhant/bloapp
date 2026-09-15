package org.apache.xmlbeans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface Filer {
    OutputStream createBinaryFile(String str) throws IOException;

    Writer createSourceFile(String str) throws IOException;
}
