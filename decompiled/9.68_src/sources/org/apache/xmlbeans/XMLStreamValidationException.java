package org.apache.xmlbeans;

import org.apache.xmlbeans.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class XMLStreamValidationException extends XMLStreamException {
    private XmlError _xmlError;

    public XMLStreamValidationException(XmlError xmlError) {
        super(xmlError.toString());
        this._xmlError = xmlError;
    }

    public XmlError getXmlError() {
        return this._xmlError;
    }
}
