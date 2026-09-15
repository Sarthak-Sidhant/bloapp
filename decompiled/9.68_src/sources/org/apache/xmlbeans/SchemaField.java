package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaField {
    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaType getType();

    Object getUserData();

    boolean isAttribute();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();
}
