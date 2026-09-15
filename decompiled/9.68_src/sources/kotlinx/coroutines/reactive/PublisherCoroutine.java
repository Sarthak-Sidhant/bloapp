package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
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
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: Publish.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\rJ\b\u0010 \u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016J\u0017\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u001e\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030+H\u0016J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0011H\u0014J\u0015\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010/J\u001e\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u000101H\u0002J\u001e\u00104\u001a\u00020\u00032\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\b\u00102\u001a\u0004\u0018\u000101H\u0002J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000209H\u0016J\u0016\u0010:\u001a\u00020\u00032\u0006\u00102\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010;J\u001a\u0010<\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u0011H\u0002J#\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u00102\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u0003H\u0002R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u001b8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0088\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lorg/reactivestreams/Subscriber;", "exceptionOnCancelHandler", "Lkotlin/Function2;", "", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "_nRequested", "Lkotlinx/atomicfu/AtomicLong;", "cancelled", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isClosedForSend", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "close", "cause", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "doLockedSignalCompleted", "handled", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "onCancelled", "onCompleted", "value", "(Lkotlin/Unit;)V", "processResultSelectSend", "", "element", "selectResult", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "request", "n", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "unlockAndCheckCompleted", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$volatile$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    private final Mutex mutex;
    private final Subscriber<T> subscriber;

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.PublisherCoroutine$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Publish.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {128}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    static final class C01471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PublisherCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01471(PublisherCoroutine<? super T> publisherCoroutine, Continuation<? super C01471> continuation) {
            super(continuation);
            this.this$0 = publisherCoroutine;
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

    private final /* synthetic */ long get_nRequested$volatile() {
        return this._nRequested$volatile;
    }

    private final /* synthetic */ void set_nRequested$volatile(long j) {
        this._nRequested$volatile = j;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: invokeOnClose, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo6827invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext coroutineContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
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
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 publisherCoroutine$onSend$1 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$1, 3);
        PublisherCoroutine$onSend$2 publisherCoroutine$onSend$2 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> select, Object element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(this, select, null), 3, null);
        } else {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectForSend$1, reason: invalid class name */
    /* JADX INFO: compiled from: Publish.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectForSend$1", f = "Publish.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectInstance<?> $select;
        int label;
        final /* synthetic */ PublisherCoroutine<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PublisherCoroutine<? super T> publisherCoroutine, SelectInstance<?> selectInstance, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = publisherCoroutine;
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
                if (Mutex.DefaultImpls.lock$default(((PublisherCoroutine) this.this$0).mutex, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!this.$select.trySelect(this.this$0, Unit.INSTANCE)) {
                Mutex.DefaultImpls.unlock$default(((PublisherCoroutine) this.this$0).mutex, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) throws Throwable {
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
        C01471 c01471;
        PublisherCoroutine<T> publisherCoroutine;
        if (continuation instanceof C01471) {
            c01471 = (C01471) continuation;
            if ((c01471.label & IntCompanionObject.MIN_VALUE) != 0) {
                c01471.label -= IntCompanionObject.MIN_VALUE;
            } else {
                c01471 = new C01471(this, continuation);
            }
        } else {
            c01471 = new C01471(this, continuation);
        }
        Object obj = c01471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01471.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex = this.mutex;
            c01471.L$0 = this;
            c01471.L$1 = t;
            c01471.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c01471, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            publisherCoroutine = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) c01471.L$1;
            publisherCoroutine = (PublisherCoroutine) c01471.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Throwable thDoLockedNext = publisherCoroutine.doLockedNext(t);
        if (thDoLockedNext != null) {
            throw thDoLockedNext;
        }
        return Unit.INSTANCE;
    }

    private final Throwable doLockedNext(T elem) {
        long j;
        long j2;
        if (elem == null) {
            unlockAndCheckCompleted();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        }
        if (!isActive()) {
            unlockAndCheckCompleted();
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(elem);
            do {
                j = _nRequested$volatile$FU.get(this);
                if (j >= 0 && j != LongCompanionObject.MAX_VALUE) {
                    j2 = j - 1;
                }
                unlockAndCheckCompleted();
                return null;
            } while (!_nRequested$volatile$FU.compareAndSet(this, j, j2));
            if (j2 == 0) {
                return null;
            }
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            this.cancelled = true;
            boolean zClose = close(th);
            unlockAndCheckCompleted();
            if (zClose) {
                return th;
            }
            this.exceptionOnCancelHandler.invoke(th, get$context());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        try {
            if (_nRequested$volatile$FU.get(this) != -2) {
                _nRequested$volatile$FU.set(this, -2L);
                if (!this.cancelled) {
                    if (cause == null) {
                        try {
                            this.subscriber.onComplete();
                        } catch (Throwable th) {
                            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), th);
                        }
                    } else {
                        try {
                            this.subscriber.onError(cause);
                        } catch (Throwable th2) {
                            if (th2 != cause) {
                                ExceptionsKt.addSuppressed(cause, th2);
                            }
                            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), cause);
                        }
                    }
                    Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
                    return;
                }
                if (cause != null && !handled) {
                    this.exceptionOnCancelHandler.invoke(cause, get$context());
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        } catch (Throwable th3) {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            throw th3;
        }
    }

    public void request(long n) {
        long j;
        long j2;
        if (n <= 0) {
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + n));
            return;
        }
        do {
            j = _nRequested$volatile$FU.get(this);
            if (j < 0) {
                return;
            }
            long j3 = j + n;
            j2 = (j3 < 0 || n == LongCompanionObject.MAX_VALUE) ? Long.MAX_VALUE : j3;
            if (j == j2) {
                return;
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j, j2));
        if (j == 0) {
            unlockAndCheckCompleted();
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        long j;
        do {
            j = _nRequested$volatile$FU.get(this);
            if (j == -2) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j, -1L));
        if (j == 0) {
            doLockedSignalCompleted(cause, handled);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
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

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
    }
}
