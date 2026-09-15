package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@TypeQualifierDefault({ElementType.PARAMETER})
@Nullable
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersAreNullableByDefault {
}
