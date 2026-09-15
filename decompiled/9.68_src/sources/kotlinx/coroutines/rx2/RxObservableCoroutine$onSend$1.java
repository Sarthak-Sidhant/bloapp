package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: RxObservable.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class RxObservableCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, SelectInstance<?>, Object, Unit> {
    public static final RxObservableCoroutine$onSend$1 INSTANCE = new RxObservableCoroutine$onSend$1();

    RxObservableCoroutine$onSend$1() {
        super(3, RxObservableCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RxObservableCoroutine<?> rxObservableCoroutine, SelectInstance<?> selectInstance, Object obj) {
        invoke2(rxObservableCoroutine, selectInstance, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RxObservableCoroutine<?> rxObservableCoroutine, SelectInstance<?> selectInstance, Object obj) {
        rxObservableCoroutine.registerSelectForSend(selectInstance, obj);
    }
}
