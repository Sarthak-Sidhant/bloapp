package org.apache.xmlbeans;

import java.util.Set;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface QNameSetSpecification {
    boolean contains(QName qName);

    boolean containsAll(QNameSetSpecification qNameSetSpecification);

    Set excludedQNamesInIncludedURIs();

    Set excludedURIs();

    Set includedQNamesInExcludedURIs();

    Set includedURIs();

    QNameSet intersect(QNameSetSpecification qNameSetSpecification);

    QNameSet inverse();

    boolean isAll();

    boolean isDisjoint(QNameSetSpecification qNameSetSpecification);

    boolean isEmpty();

    QNameSet union(QNameSetSpecification qNameSetSpecification);
}
