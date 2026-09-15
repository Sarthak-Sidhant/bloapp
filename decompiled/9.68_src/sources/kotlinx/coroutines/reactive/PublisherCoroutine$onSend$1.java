package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: Publish.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class PublisherCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<PublisherCoroutine<?>, SelectInstance<?>, Object, Unit> {
    public static final PublisherCoroutine$onSend$1 INSTANCE = new PublisherCoroutine$onSend$1();

    PublisherCoroutine$onSend$1() {
        super(3, PublisherCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PublisherCoroutine<?> publisherCoroutine, SelectInstance<?> selectInstance, Object obj) {
        invoke2(publisherCoroutine, selectInstance, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PublisherCoroutine<?> publisherCoroutine, SelectInstance<?> selectInstance, Object obj) {
        publisherCoroutine.registerSelectForSend(selectInstance, obj);
    }
}
