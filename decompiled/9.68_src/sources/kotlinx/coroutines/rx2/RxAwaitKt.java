package kotlinx.coroutines.rx2;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: RxAwait.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\u0006\u0010\r\u001a\u0002H\u0004H\u0086@¢\u0006\u0002\u0010\u000e\u001a,\u0010\u000f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a \u0010\u0013\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u0014\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a2\u0010\u0015\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\n2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0004H\u0082@¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0019\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u0002H\u0004H\u0087@¢\u0006\u0002\u0010\u001a\u001a\u001e\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a \u0010\u001c\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u001d\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¨\u0006!"}, d2 = {"await", "", "Lio/reactivex/CompletableSource;", "(Lio/reactivex/CompletableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/reactivex/MaybeSource;", "(Lio/reactivex/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/SingleSource;", "(Lio/reactivex/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirst", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lio/reactivex/ObservableSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "mode", "Lkotlinx/coroutines/rx2/Mode;", "(Lio/reactivex/ObservableSource;Lkotlinx/coroutines/rx2/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOrDefault", "(Lio/reactivex/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrNull", "disposeOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "d", "Lio/reactivex/disposables/Disposable;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RxAwaitKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxAwaitKt$awaitFirstOrElse$1, reason: invalid class name */
    /* JADX INFO: compiled from: RxAwait.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {196}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return RxAwaitKt.awaitFirstOrElse(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxAwaitKt$awaitOrDefault$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxAwait.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {122}, m = "awaitOrDefault", n = {"default"}, s = {"L$0"})
    static final class C01481<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01481(Continuation<? super C01481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return RxAwaitKt.awaitOrDefault(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.rx2.RxAwaitKt$awaitSingle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RxAwait.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {}, l = {78}, m = "awaitSingle", n = {}, s = {})
    static final class C01491<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01491(Continuation<? super C01491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= IntCompanionObject.MIN_VALUE;
            return RxAwaitKt.awaitSingle((MaybeSource) null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object awaitSingle(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        C01491 c01491;
        if (continuation instanceof C01491) {
            c01491 = (C01491) continuation;
            if ((c01491.label & IntCompanionObject.MIN_VALUE) != 0) {
                c01491.label -= IntCompanionObject.MIN_VALUE;
            } else {
                c01491 = new C01491(continuation);
            }
        } else {
            c01491 = new C01491(continuation);
        }
        Object objAwaitSingleOrNull = c01491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitSingleOrNull);
            c01491.label = 1;
            objAwaitSingleOrNull = awaitSingleOrNull(maybeSource, c01491);
            if (objAwaitSingleOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitSingleOrNull);
        }
        if (objAwaitSingleOrNull != null) {
            return objAwaitSingleOrNull;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    public static final /* synthetic */ Object awaitOrDefault(MaybeSource maybeSource, Object obj, Continuation continuation) {
        C01481 c01481;
        if (continuation instanceof C01481) {
            c01481 = (C01481) continuation;
            if ((c01481.label & IntCompanionObject.MIN_VALUE) != 0) {
                c01481.label -= IntCompanionObject.MIN_VALUE;
            } else {
                c01481 = new C01481(continuation);
            }
        } else {
            c01481 = new C01481(continuation);
        }
        Object objAwaitSingleOrNull = c01481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01481.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitSingleOrNull);
            c01481.L$0 = obj;
            c01481.label = 1;
            objAwaitSingleOrNull = awaitSingleOrNull(maybeSource, c01481);
            if (objAwaitSingleOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c01481.L$0;
            ResultKt.throwOnFailure(objAwaitSingleOrNull);
        }
        return objAwaitSingleOrNull == null ? obj : objAwaitSingleOrNull;
    }

    public static final <T> Object awaitFirst(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.FIRST, null, continuation, 2, null);
    }

    public static final <T> Object awaitFirstOrDefault(ObservableSource<T> observableSource, T t, Continuation<? super T> continuation) {
        return awaitOne(observableSource, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    public static final <T> Object awaitFirstOrNull(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object awaitFirstOrElse(ObservableSource<T> observableSource, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & IntCompanionObject.MIN_VALUE) != 0) {
                anonymousClass1.label -= IntCompanionObject.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objAwaitOne$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitOne$default);
            Mode mode = Mode.FIRST_OR_DEFAULT;
            anonymousClass2.L$0 = function0;
            anonymousClass2.label = 1;
            objAwaitOne$default = awaitOne$default(observableSource, mode, null, anonymousClass2, 2, null);
            if (objAwaitOne$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objAwaitOne$default);
        }
        return objAwaitOne$default == null ? function0.invoke() : objAwaitOne$default;
    }

    public static final <T> Object awaitLast(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.LAST, null, continuation, 2, null);
    }

    public static final <T> Object awaitSingle(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.SINGLE, null, continuation, 2, null);
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, final Disposable disposable) {
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt.disposeOnCancellation.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                disposable.dispose();
            }
        });
    }

    static /* synthetic */ Object awaitOne$default(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(observableSource, mode, obj, continuation);
    }

    public static final Object await(CompletableSource completableSource, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        completableSource.subscribe(new CompletableObserver() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$2$1
            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, d);
            }

            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(Unit.INSTANCE));
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable e) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public static final <T> Object awaitSingleOrNull(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        maybeSource.subscribe(new MaybeObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitSingleOrNull$2$1
            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, d);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(null));
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(t));
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(error)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object await(SingleSource<T> singleSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        singleSource.subscribe(new SingleObserver<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$await$5$1
            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl2, d);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(t));
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(error)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(ObservableSource<T> observableSource, final Mode mode, final T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        observableSource.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1
            private boolean seenValue;
            private Disposable subscription;
            private T value;

            /* JADX INFO: compiled from: RxAwait.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Mode.values().length];
                    try {
                        iArr[Mode.FIRST.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Mode.LAST.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Mode.SINGLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(final Disposable sub) {
                this.subscription = sub;
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx2.RxAwaitKt$awaitOne$2$1$onSubscribe$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        sub.dispose();
                    }
                });
            }

            @Override // io.reactivex.Observer
            public void onNext(T t2) {
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                Disposable disposable = null;
                if (i == 1 || i == 2) {
                    if (this.seenValue) {
                        return;
                    }
                    this.seenValue = true;
                    CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5265constructorimpl(t2));
                    Disposable disposable2 = this.subscription;
                    if (disposable2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("subscription");
                    } else {
                        disposable = disposable2;
                    }
                    disposable.dispose();
                    return;
                }
                if (i == 3 || i == 4) {
                    if (mode == Mode.SINGLE && this.seenValue) {
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + mode))));
                        }
                        Disposable disposable3 = this.subscription;
                        if (disposable3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("subscription");
                        } else {
                            disposable = disposable3;
                        }
                        disposable.dispose();
                        return;
                    }
                    this.value = t2;
                    this.seenValue = true;
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.seenValue) {
                    if (cancellableContinuationImpl2.isActive()) {
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m5265constructorimpl(this.value));
                        return;
                    }
                    return;
                }
                if (mode == Mode.FIRST_OR_DEFAULT) {
                    CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl2;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m5265constructorimpl(t));
                } else if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation3.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + mode))));
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable e) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5265constructorimpl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
