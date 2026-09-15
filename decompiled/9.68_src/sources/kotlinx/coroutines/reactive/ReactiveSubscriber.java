package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: ReactiveFlow.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0086@¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "T", "", "Lorg/reactivestreams/Subscriber;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "requestSize", "", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "subscription", "Lorg/reactivestreams/Subscription;", "cancel", "", "makeRequest", "onComplete", "onError", "t", "", "onNext", "value", "(Ljava/lang/Object;)V", "onSubscribe", "s", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ReactiveSubscriber<T> implements Subscriber<T> {
    private final Channel<T> channel;
    private final long requestSize;
    private Subscription subscription;

    /* JADX INFO: renamed from: kotlinx.coroutines.reactive.ReactiveSubscriber$takeNextOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReactiveFlow.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.reactive.ReactiveSubscriber", f = "ReactiveFlow.kt", i = {}, l = {125}, m = "takeNextOrNull", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ReactiveSubscriber<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReactiveSubscriber<T> reactiveSubscriber, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = reactiveSubscriber;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return this.this$0.takeNextOrNull(this);
        }
    }

    public ReactiveSubscriber(int i, BufferOverflow bufferOverflow, long j) {
        this.requestSize = j;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel$default(i == 0 ? 1 : i, bufferOverflow, null, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object takeNextOrNull(Continuation<? super T> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object holder;
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
            Channel<T> channel = this.channel;
            anonymousClass1.label = 1;
            holder = channel.mo6762receiveCatchingJP2dKIU(anonymousClass1);
            if (holder == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            holder = ((ChannelResult) obj).getHolder();
        }
        Throwable thM6773exceptionOrNullimpl = ChannelResult.m6773exceptionOrNullimpl(holder);
        if (thM6773exceptionOrNullimpl != null) {
            throw thM6773exceptionOrNullimpl;
        }
        if (!(holder instanceof ChannelResult.Failed)) {
            return holder;
        }
        ChannelResult.m6773exceptionOrNullimpl(holder);
        return null;
    }

    public void onNext(T value) {
        if (!ChannelResult.m6779isSuccessimpl(this.channel.mo6758trySendJP2dKIU(value))) {
            throw new IllegalArgumentException(("Element " + value + " was not added to channel because it was full, " + this.channel).toString());
        }
    }

    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    public void onError(Throwable t) {
        this.channel.close(t);
    }

    public void onSubscribe(Subscription s) {
        this.subscription = s;
        makeRequest();
    }

    public final void makeRequest() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.request(this.requestSize);
    }

    public final void cancel() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.cancel();
    }
}
