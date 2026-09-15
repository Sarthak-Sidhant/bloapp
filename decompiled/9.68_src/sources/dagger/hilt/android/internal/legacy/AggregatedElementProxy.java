package dagger.hilt.android.internal.legacy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface AggregatedElementProxy {
    Class<?> value();
}
