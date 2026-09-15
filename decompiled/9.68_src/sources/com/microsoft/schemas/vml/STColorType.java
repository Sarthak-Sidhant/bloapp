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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface STColorType extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STColorType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443").resolveHandle("stcolortype99c1type");

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(STColorType.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static STColorType newInstance() {
            return (STColorType) getTypeLoader().newInstance(STColorType.type, null);
        }

        public static STColorType newInstance(XmlOptions xmlOptions) {
            return (STColorType) getTypeLoader().newInstance(STColorType.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColorType.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColorType.type, xmlOptions);
        }

        public static STColorType newValue(Object obj) {
            return (STColorType) STColorType.type.newValue(obj);
        }

        public static STColorType parse(File file) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(file, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(file, STColorType.type, xmlOptions);
        }

        public static STColorType parse(InputStream inputStream) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(inputStream, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(inputStream, STColorType.type, xmlOptions);
        }

        public static STColorType parse(Reader reader) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(reader, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(reader, STColorType.type, xmlOptions);
        }

        public static STColorType parse(String str) throws XmlException {
            return (STColorType) getTypeLoader().parse(str, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) getTypeLoader().parse(str, STColorType.type, xmlOptions);
        }

        public static STColorType parse(URL url) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(url, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) getTypeLoader().parse(url, STColorType.type, xmlOptions);
        }

        public static STColorType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STColorType) getTypeLoader().parse(xMLStreamReader, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) getTypeLoader().parse(xMLStreamReader, STColorType.type, xmlOptions);
        }

        @Deprecated
        public static STColorType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (STColorType) getTypeLoader().parse(xMLInputStream, STColorType.type, (XmlOptions) null);
        }

        @Deprecated
        public static STColorType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (STColorType) getTypeLoader().parse(xMLInputStream, STColorType.type, xmlOptions);
        }

        public static STColorType parse(Node node) throws XmlException {
            return (STColorType) getTypeLoader().parse(node, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) getTypeLoader().parse(node, STColorType.type, xmlOptions);
        }
    }
}
