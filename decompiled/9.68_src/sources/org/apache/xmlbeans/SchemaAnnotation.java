package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaAnnotation extends SchemaComponent {

    public interface Attribute {
        QName getName();

        String getValue();

        String getValueUri();
    }

    XmlObject[] getApplicationInformation();

    Attribute[] getAttributes();

    XmlObject[] getUserInformation();
}
