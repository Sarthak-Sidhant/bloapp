package org.apache.xmlbeans;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface PrePostExtension {
    public static final int OPERATION_INSERT = 2;
    public static final int OPERATION_REMOVE = 3;
    public static final int OPERATION_SET = 1;

    String getStaticHandler();

    boolean hasPostCall();

    boolean hasPreCall();
}
