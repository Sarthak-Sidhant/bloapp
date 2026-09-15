package org.apache.xmlbeans;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaCodePrinter {
    void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem) throws IOException;

    void printType(Writer writer, SchemaType schemaType) throws IOException;

    void printTypeImpl(Writer writer, SchemaType schemaType) throws IOException;
}
