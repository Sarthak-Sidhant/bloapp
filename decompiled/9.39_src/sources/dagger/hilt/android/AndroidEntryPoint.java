package dagger.hilt.android;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Target({ElementType.TYPE})
public @interface AndroidEntryPoint {
    Class<?> value() default Void.class;
}
