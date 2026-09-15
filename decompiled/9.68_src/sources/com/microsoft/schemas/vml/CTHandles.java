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
public interface CTHandles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHandles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443").resolveHandle("cthandles5c1ftype");

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(CTHandles.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static CTHandles newInstance() {
            return (CTHandles) getTypeLoader().newInstance(CTHandles.type, null);
        }

        public static CTHandles newInstance(XmlOptions xmlOptions) {
            return (CTHandles) getTypeLoader().newInstance(CTHandles.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHandles.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(File file) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(file, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(file, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(inputStream, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(inputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(Reader reader) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(reader, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(reader, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(String str) throws XmlException {
            return (CTHandles) getTypeLoader().parse(str, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) getTypeLoader().parse(str, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(URL url) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(url, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) getTypeLoader().parse(url, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHandles) getTypeLoader().parse(xMLStreamReader, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) getTypeLoader().parse(xMLStreamReader, CTHandles.type, xmlOptions);
        }

        @Deprecated
        public static CTHandles parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHandles) getTypeLoader().parse(xMLInputStream, CTHandles.type, (XmlOptions) null);
        }

        @Deprecated
        public static CTHandles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHandles) getTypeLoader().parse(xMLInputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(Node node) throws XmlException {
            return (CTHandles) getTypeLoader().parse(node, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) getTypeLoader().parse(node, CTHandles.type, xmlOptions);
        }
    }

    CTH addNewH();

    CTH getHArray(int i);

    @Deprecated
    CTH[] getHArray();

    List<CTH> getHList();

    CTH insertNewH(int i);

    void removeH(int i);

    void setHArray(int i, CTH cth);

    void setHArray(CTH[] cthArr);

    int sizeOfHArray();
}
