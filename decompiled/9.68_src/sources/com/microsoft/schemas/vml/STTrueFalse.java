package com.microsoft.schemas.vml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface STTrueFalse extends XmlString {
    public static final int INT_F = 2;
    public static final int INT_FALSE = 4;
    public static final int INT_T = 1;
    public static final int INT_TRUE = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTrueFalse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443").resolveHandle("sttruefalse4ab9type");
    public static final Enum T = Enum.forString("t");
    public static final Enum F = Enum.forString("f");
    public static final Enum TRUE = Enum.forString(BooleanUtils.TRUE);
    public static final Enum FALSE = Enum.forString(BooleanUtils.FALSE);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 2;
        static final int INT_FALSE = 4;
        static final int INT_T = 1;
        static final int INT_TRUE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum("f", 2), new Enum(BooleanUtils.TRUE, 3), new Enum(BooleanUtils.FALSE, 4)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(STTrueFalse.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static STTrueFalse newInstance() {
            return (STTrueFalse) getTypeLoader().newInstance(STTrueFalse.type, null);
        }

        public static STTrueFalse newInstance(XmlOptions xmlOptions) {
            return (STTrueFalse) getTypeLoader().newInstance(STTrueFalse.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse newValue(Object obj) {
            return (STTrueFalse) STTrueFalse.type.newValue(obj);
        }

        public static STTrueFalse parse(File file) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(file, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(file, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(InputStream inputStream) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(inputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(inputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Reader reader) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(reader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(reader, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(String str) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(str, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(str, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(URL url) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(url, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) getTypeLoader().parse(url, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(xMLStreamReader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(xMLStreamReader, STTrueFalse.type, xmlOptions);
        }

        @Deprecated
        public static STTrueFalse parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (STTrueFalse) getTypeLoader().parse(xMLInputStream, STTrueFalse.type, (XmlOptions) null);
        }

        @Deprecated
        public static STTrueFalse parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (STTrueFalse) getTypeLoader().parse(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Node node) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(node, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) getTypeLoader().parse(node, STTrueFalse.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
