package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: RxObservable.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class RxObservableCoroutine$onSend$2 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, Object, Object, Object> {
    public static final RxObservableCoroutine$onSend$2 INSTANCE = new RxObservableCoroutine$onSend$2();

    RxObservableCoroutine$onSend$2() {
        super(3, RxObservableCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RxObservableCoroutine<?> rxObservableCoroutine, Object obj, Object obj2) {
        return rxObservableCoroutine.processResultSelectSend(obj, obj2);
    }
}
