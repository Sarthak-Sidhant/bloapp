package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RxConvert.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", i = {0}, l = {110}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableEmitter<T> $emitter;
    final /* synthetic */ Flow<T> $this_asObservable;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RxConvertKt$asObservable$1$job$1(Flow<? extends T> flow, ObservableEmitter<T> observableEmitter, Continuation<? super RxConvertKt$asObservable$1$job$1> continuation) {
        super(2, continuation);
        this.$this_asObservable = flow;
        this.$emitter = observableEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.$this_asObservable, this.$emitter, continuation);
        rxConvertKt$asObservable$1$job$1.L$0 = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                Flow<T> flow = this.$this_asObservable;
                final ObservableEmitter<T> observableEmitter = this.$emitter;
                FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        observableEmitter.onNext(t);
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (flow.collect((FlowCollector<? super T>) flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } catch (Throwable th2) {
                coroutineScope = coroutineScope2;
                th = th2;
                if (!(th instanceof CancellationException)) {
                    if (!this.$emitter.tryOnError(th)) {
                        RxCancellableKt.handleUndeliverableException(th, coroutineScope.getCoroutineContext());
                    }
                } else {
                    this.$emitter.onComplete();
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                if (!(th instanceof CancellationException)) {
                    if (!this.$emitter.tryOnError(th)) {
                        RxCancellableKt.handleUndeliverableException(th, coroutineScope.getCoroutineContext());
                    }
                } else {
                    this.$emitter.onComplete();
                }
            }
        }
        this.$emitter.onComplete();
        return Unit.INSTANCE;
    }
}
