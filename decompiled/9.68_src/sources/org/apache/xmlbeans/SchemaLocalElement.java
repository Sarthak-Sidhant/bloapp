package org.apache.xmlbeans;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaLocalElement extends SchemaField, SchemaAnnotated {
    boolean blockExtension();

    boolean blockRestriction();

    boolean blockSubstitution();

    SchemaIdentityConstraint[] getIdentityConstraints();

    boolean isAbstract();
}
