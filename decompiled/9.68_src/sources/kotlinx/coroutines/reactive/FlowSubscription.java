package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: ReactiveFlow.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0014\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\t\u0010\u0011\u001a\u00020\u0012X\u0082\u0004R\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "subscriber", "Lorg/reactivestreams/Subscriber;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "cancellationRequested", "", "producer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlin/coroutines/Continuation;", "requested", "Lkotlinx/atomicfu/AtomicLong;", "cancel", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInitialContinuation", "flowProcessing", "request", "n", "", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    private volatile boolean cancellationRequested;
    public final Flow<T> flow;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;
    public final Subscriber<? super T> subscriber;
    private static final /* synthetic */ AtomicLongFieldUpdater requested$volatile$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater producer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer$volatile");

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReactiveFlow.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {0}, l = {205}, m = "flowProcessing", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowSubscription<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowSubscription<T> flowSubscription, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = flowSubscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return this.this$0.flowProcessing(this);
        }
    }

    private final /* synthetic */ long getAndUpdate$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
        return j;
    }

    private final /* synthetic */ Object getProducer$volatile() {
        return this.producer$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getProducer$volatile$FU() {
        return producer$volatile$FU;
    }

    private final /* synthetic */ long getRequested$volatile() {
        return this.requested$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getRequested$volatile$FU() {
        return requested$volatile$FU;
    }

    private final /* synthetic */ void setProducer$volatile(Object obj) {
        this.producer$volatile = obj;
    }

    private final /* synthetic */ void setRequested$volatile(long j) {
        this.requested$volatile = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.producer$volatile = createInitialContinuation();
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext coroutineContext = getCoroutineContext();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return coroutineContext;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) throws Throwable {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:49:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object flowProcessing(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        FlowSubscription flowSubscription;
        FlowSubscription flowSubscription2;
        Throwable thUnwrapImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (consumeFlow(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowSubscription2 = this;
                flowSubscription2.subscriber.onComplete();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                flowSubscription = this;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    thUnwrapImpl = StackTraceRecoveryKt.unwrapImpl(th);
                } else {
                    thUnwrapImpl = th;
                }
                if (flowSubscription.cancellationRequested || flowSubscription.isActive() || thUnwrapImpl != flowSubscription.getCancellationException()) {
                    flowSubscription.subscriber.onError(th);
                }
                return Unit.INSTANCE;
            }
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        flowSubscription = (FlowSubscription) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            flowSubscription2 = flowSubscription;
            try {
                flowSubscription2.subscriber.onComplete();
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription2.getCoroutineContext(), th2);
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                thUnwrapImpl = th;
            } else {
                thUnwrapImpl = StackTraceRecoveryKt.unwrapImpl(th);
            }
            if (flowSubscription.cancellationRequested) {
                try {
                    flowSubscription.subscriber.onError(th);
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                    CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription.getCoroutineContext(), th);
                }
            } else {
                flowSubscription.subscriber.onError(th);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object objCollect = this.flow.collect(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription.consumeFlow.2
            final /* synthetic */ FlowSubscription<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                this.this$0.subscriber.onNext(t);
                if (FlowSubscription.getRequested$volatile$FU().decrementAndGet(this.this$0) <= 0) {
                    FlowSubscription<T> flowSubscription = this.this$0;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellableContinuationImpl.initCancellability();
                    FlowSubscription.getProducer$volatile$FU().set(flowSubscription, cancellableContinuationImpl);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                JobKt.ensureActive(this.this$0.getCoroutineContext());
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    public void request(long n) {
        long j;
        long j2;
        Continuation continuation;
        if (n <= 0) {
            return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = requested$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = j + n;
            if (j2 <= 0) {
                j2 = LongCompanionObject.MAX_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        if (j <= 0) {
            do {
                continuation = (Continuation) producer$volatile$FU.getAndSet(this, null);
            } while (continuation == null);
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m5265constructorimpl(Unit.INSTANCE));
        }
    }
}
