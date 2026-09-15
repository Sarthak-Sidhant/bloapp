package org.apache.xmlbeans;

import javax.xml.namespace.QName;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface XmlSaxHandler {
    void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

    void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark);

    ContentHandler getContentHandler();

    LexicalHandler getLexicalHandler();

    XmlObject getObject() throws XmlException;
}
