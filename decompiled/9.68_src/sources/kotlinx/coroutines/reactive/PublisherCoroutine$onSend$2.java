package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: Publish.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class PublisherCoroutine$onSend$2 extends FunctionReferenceImpl implements Function3<PublisherCoroutine<?>, Object, Object, Object> {
    public static final PublisherCoroutine$onSend$2 INSTANCE = new PublisherCoroutine$onSend$2();

    PublisherCoroutine$onSend$2() {
        super(3, PublisherCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PublisherCoroutine<?> publisherCoroutine, Object obj, Object obj2) {
        return publisherCoroutine.processResultSelectSend(obj, obj2);
    }
}
