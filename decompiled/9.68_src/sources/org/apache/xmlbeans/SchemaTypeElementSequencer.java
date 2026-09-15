package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaTypeElementSequencer {
    boolean next(QName qName);

    boolean peek(QName qName);
}
