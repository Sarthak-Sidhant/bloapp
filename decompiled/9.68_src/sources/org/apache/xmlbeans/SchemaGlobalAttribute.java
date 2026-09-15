package org.apache.xmlbeans;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface SchemaGlobalAttribute extends SchemaLocalAttribute, SchemaComponent {
    Ref getRef();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 3;
        }

        public Ref(SchemaGlobalAttribute schemaGlobalAttribute) {
            super(schemaGlobalAttribute);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaGlobalAttribute get() {
            return (SchemaGlobalAttribute) getComponent();
        }
    }
}
