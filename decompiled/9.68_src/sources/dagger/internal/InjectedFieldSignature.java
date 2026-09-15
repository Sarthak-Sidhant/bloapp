package dagger.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface InjectedFieldSignature {
    String value();
}
