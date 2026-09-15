package com.microsoft.schemas.vml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface CTFormulas extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFormulas.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443").resolveHandle("ctformulas808btype");

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(CTFormulas.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static CTFormulas newInstance() {
            return (CTFormulas) getTypeLoader().newInstance(CTFormulas.type, null);
        }

        public static CTFormulas newInstance(XmlOptions xmlOptions) {
            return (CTFormulas) getTypeLoader().newInstance(CTFormulas.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(File file) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(file, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(file, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(inputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(inputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Reader reader) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(reader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(reader, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(String str) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(str, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(str, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(URL url) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(url, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) getTypeLoader().parse(url, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(xMLStreamReader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(xMLStreamReader, CTFormulas.type, xmlOptions);
        }

        @Deprecated
        public static CTFormulas parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFormulas) getTypeLoader().parse(xMLInputStream, CTFormulas.type, (XmlOptions) null);
        }

        @Deprecated
        public static CTFormulas parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFormulas) getTypeLoader().parse(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Node node) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(node, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) getTypeLoader().parse(node, CTFormulas.type, xmlOptions);
        }
    }

    CTF addNewF();

    CTF getFArray(int i);

    @Deprecated
    CTF[] getFArray();

    List<CTF> getFList();

    CTF insertNewF(int i);

    void removeF(int i);

    void setFArray(int i, CTF ctf);

    void setFArray(CTF[] ctfArr);

    int sizeOfFArray();
}
