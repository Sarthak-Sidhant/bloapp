package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyKey {
    When when() default When.ALWAYS;
}
