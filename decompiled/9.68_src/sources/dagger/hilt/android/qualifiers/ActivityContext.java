package dagger.hilt.android.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface ActivityContext {
}
