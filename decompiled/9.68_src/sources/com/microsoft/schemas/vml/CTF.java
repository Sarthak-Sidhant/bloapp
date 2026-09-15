package com.microsoft.schemas.vml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface CTF extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTF.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443").resolveHandle("ctfbc3atype");

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(CTF.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static CTF newInstance() {
            return (CTF) getTypeLoader().newInstance(CTF.type, null);
        }

        public static CTF newInstance(XmlOptions xmlOptions) {
            return (CTF) getTypeLoader().newInstance(CTF.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTF.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(File file) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(file, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(file, CTF.type, xmlOptions);
        }

        public static CTF parse(InputStream inputStream) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(inputStream, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(inputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(Reader reader) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(reader, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(reader, CTF.type, xmlOptions);
        }

        public static CTF parse(String str) throws XmlException {
            return (CTF) getTypeLoader().parse(str, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTF) getTypeLoader().parse(str, CTF.type, xmlOptions);
        }

        public static CTF parse(URL url) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(url, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) getTypeLoader().parse(url, CTF.type, xmlOptions);
        }

        public static CTF parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTF) getTypeLoader().parse(xMLStreamReader, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTF) getTypeLoader().parse(xMLStreamReader, CTF.type, xmlOptions);
        }

        @Deprecated
        public static CTF parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTF) getTypeLoader().parse(xMLInputStream, CTF.type, (XmlOptions) null);
        }

        @Deprecated
        public static CTF parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTF) getTypeLoader().parse(xMLInputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(Node node) throws XmlException {
            return (CTF) getTypeLoader().parse(node, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTF) getTypeLoader().parse(node, CTF.type, xmlOptions);
        }
    }

    String getEqn();

    boolean isSetEqn();

    void setEqn(String str);

    void unsetEqn();

    XmlString xgetEqn();

    void xsetEqn(XmlString xmlString);
}
