package org.apache.xmlbeans;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    SchemaAnnotation[] annotations();

    SchemaAttributeGroup[] attributeGroups();

    SchemaType[] attributeTypes();

    SchemaType[] documentTypes();

    ClassLoader getClassLoader();

    String getName();

    SchemaGlobalAttribute[] globalAttributes();

    SchemaGlobalElement[] globalElements();

    SchemaType[] globalTypes();

    SchemaModelGroup[] modelGroups();

    void resolve();

    SchemaComponent resolveHandle(String str);

    void save(Filer filer);

    void saveToDirectory(File file);

    SchemaType typeForHandle(String str);
}
