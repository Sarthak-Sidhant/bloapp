package dagger.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Target({ElementType.TYPE})
public @interface ComponentDefinitionType {
    Class<?> value();
}
