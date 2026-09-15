package org.apache.xmlbeans;

import java.io.InputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ResourceLoader {
    void close();

    InputStream getResourceAsStream(String str);
}
