package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: RxObservable.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u001e\u0010$\u001a\u00020%2\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u00040'H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0014J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0014¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00022\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010/\u001a\u00020\u00042\n\u00100\u001a\u0006\u0012\u0002\b\u0003012\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u00102\u001a\u00020\u00042\u0006\u0010-\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0002J#\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004062\u0006\u0010-\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\u0004H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u00178VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lkotlinx/coroutines/rx2/RxObservableCoroutine;", "T", "", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/ObservableEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/ObservableEmitter;)V", "_signal", "Lkotlinx/atomicfu/AtomicInt;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isClosedForSend", "", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "doLockedSignalCompleted", "handled", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "onCancelled", "onCompleted", "value", "(Lkotlin/Unit;)V", "processResultSelectSend", "element", "selectResult", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "unlockAndCheckCompleted", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    private volatile /* synthetic */ int _signal$volatile;
    private final Mutex mutex;
    private final ObservableEmitter<T> subscriber;

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxObservableCoroutine$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxObservable.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine", f = "RxObservable.kt", i = {0, 0}, l = {113}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    static final class C01541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxObservableCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01541(RxObservableCoroutine<T> rxObservableCoroutine, Continuation<? super C01541> continuation) {
            super(continuation);
            this.this$0 = rxObservableCoroutine;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return this.this$0.send(null, this);
        }
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ int get_signal$volatile() {
        return this._signal$volatile;
    }

    private final /* synthetic */ void set_signal$volatile(int i) {
        this._signal$volatile = i;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: invokeOnClose */
    public /* bridge */ /* synthetic */ void mo6827invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    public RxObservableCoroutine(CoroutineContext coroutineContext, ObservableEmitter<T> observableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = observableEmitter;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return cancelCoroutine(cause);
    }

    public Void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3);
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> select, Object element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(this, select, null), 3, null);
        } else {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxObservableCoroutine$registerSelectForSend$1, reason: invalid class name */
    /* JADX INFO: compiled from: RxObservable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine$registerSelectForSend$1", f = "RxObservable.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectInstance<?> $select;
        int label;
        final /* synthetic */ RxObservableCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RxObservableCoroutine<T> rxObservableCoroutine, SelectInstance<?> selectInstance, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = rxObservableCoroutine;
            this.$select = selectInstance;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$select, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Mutex.DefaultImpls.lock$default(((RxObservableCoroutine) this.this$0).mutex, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!this.$select.trySelect(this.this$0, Unit.INSTANCE)) {
                Mutex.DefaultImpls.unlock$default(((RxObservableCoroutine) this.this$0).mutex, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) throws Throwable {
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type T of kotlinx.coroutines.rx2.RxObservableCoroutine");
        Throwable thDoLockedNext = doLockedNext(element);
        if (thDoLockedNext == null) {
            return this;
        }
        throw thDoLockedNext;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo6758trySendJP2dKIU(T element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.INSTANCE.m6783failurePtdJZtk();
        }
        Throwable thDoLockedNext = doLockedNext(element);
        if (thDoLockedNext == null) {
            return ChannelResult.INSTANCE.m6784successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.INSTANCE.m6782closedJP2dKIU(thDoLockedNext);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation<? super Unit> continuation) throws Throwable {
        C01541 c01541;
        RxObservableCoroutine<T> rxObservableCoroutine;
        if (continuation instanceof C01541) {
            c01541 = (C01541) continuation;
            if ((c01541.label & IntCompanionObject.MIN_VALUE) != 0) {
                c01541.label -= IntCompanionObject.MIN_VALUE;
            } else {
                c01541 = new C01541(this, continuation);
            }
        } else {
            c01541 = new C01541(this, continuation);
        }
        Object obj = c01541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01541.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex = this.mutex;
            c01541.L$0 = this;
            c01541.L$1 = t;
            c01541.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c01541, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            rxObservableCoroutine = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) c01541.L$1;
            rxObservableCoroutine = (RxObservableCoroutine) c01541.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Throwable thDoLockedNext = rxObservableCoroutine.doLockedNext(t);
        if (thDoLockedNext != null) {
            throw thDoLockedNext;
        }
        return Unit.INSTANCE;
    }

    private final Throwable doLockedNext(T elem) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(elem);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean zClose = close(undeliverableException);
            unlockAndCheckCompleted();
            if (zClose) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, get$context());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isActive() || !Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return;
        }
        doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        Throwable thUnwrapImpl;
        try {
            if (_signal$volatile$FU.get(this) != -2) {
                _signal$volatile$FU.set(this, -2);
                if (cause != null) {
                    thUnwrapImpl = !DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
                } else {
                    thUnwrapImpl = null;
                }
                if (thUnwrapImpl == null) {
                    try {
                        this.subscriber.onComplete();
                    } catch (Exception e) {
                        RxCancellableKt.handleUndeliverableException(e, get$context());
                    }
                } else if ((thUnwrapImpl instanceof UndeliverableException) && !handled) {
                    RxCancellableKt.handleUndeliverableException(cause, get$context());
                } else if (thUnwrapImpl != getCancellationException() || !this.subscriber.isDisposed()) {
                    try {
                        this.subscriber.onError(cause);
                    } catch (Exception e2) {
                        ExceptionsKt.addSuppressed(cause, e2);
                        RxCancellableKt.handleUndeliverableException(cause, get$context());
                    }
                }
                Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
                return;
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        } catch (Throwable th) {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            throw th;
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        if (_signal$volatile$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit value) {
        signalCompleted(null, false);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }
}
