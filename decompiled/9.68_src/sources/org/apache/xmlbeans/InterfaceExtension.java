package org.apache.xmlbeans;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface InterfaceExtension {

    public interface MethodSignature {
        String[] getExceptionTypes();

        String getName();

        String[] getParameterTypes();

        String getReturnType();
    }

    String getInterface();

    MethodSignature[] getMethods();

    String getStaticHandler();
}
