package org.apache.xmlbeans;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaLocalAttribute extends SchemaField, SchemaAnnotated {
    public static final int OPTIONAL = 2;
    public static final int PROHIBITED = 1;
    public static final int REQUIRED = 3;

    int getUse();
}
