package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Named {
    String value() default "";
}
