package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: RxScheduler.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001aN\u0010\u0006\u001a\u00020\u0007*\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\r2,\u0010\u000e\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u000fH\u0002*8\b\u0002\u0010\u0013\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¨\u0006\u0014"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/reactivex/Scheduler;", "asCoroutineDispatcher0", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "asScheduler", "scheduleTask", "Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delayMillis", "", "adaptForScheduling", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "Task", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RxSchedulerKt {
    public static final CoroutineDispatcher asCoroutineDispatcher(Scheduler scheduler) {
        if (scheduler instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) scheduler).dispatcher;
        }
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    /* JADX INFO: renamed from: asCoroutineDispatcher, reason: collision with other method in class */
    public static final /* synthetic */ SchedulerCoroutineDispatcher m6834asCoroutineDispatcher(Scheduler scheduler) {
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    public static final Scheduler asScheduler(CoroutineDispatcher coroutineDispatcher) {
        if (coroutineDispatcher instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) coroutineDispatcher).getScheduler();
        }
        return new DispatcherScheduler(coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, kotlinx.coroutines.DisposableHandle] */
    public static final Disposable scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Disposable disposableFromRunnable = Disposables.fromRunnable(new Runnable() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.scheduleTask$lambda$0(objectRef);
            }
        });
        Runnable runnableInvoke = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(disposableFromRunnable, coroutineContext, RxJavaPlugins.onSchedule(runnable)));
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Disposables.disposed();
        }
        if (j <= 0) {
            runnableInvoke.run();
        } else {
            objectRef.element = DelayKt.getDelay(coroutineContext).invokeOnTimeout(j, runnableInvoke, coroutineContext);
        }
        return disposableFromRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleTask$lambda$0(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object scheduleTask$task(Disposable disposable, CoroutineContext coroutineContext, final Runnable runnable, Continuation<? super Unit> continuation) {
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$1;
        if (continuation instanceof RxSchedulerKt$scheduleTask$task$1) {
            rxSchedulerKt$scheduleTask$task$1 = (RxSchedulerKt$scheduleTask$task$1) continuation;
            if ((rxSchedulerKt$scheduleTask$task$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxSchedulerKt$scheduleTask$task$1.label -= IntCompanionObject.MIN_VALUE;
            } else {
                rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
            }
        } else {
            rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
        }
        Object obj = rxSchedulerKt$scheduleTask$task$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = rxSchedulerKt$scheduleTask$task$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (disposable.isDisposed()) {
                    return Unit.INSTANCE;
                }
                Function0<Unit> function0 = new Function0<Unit>() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        runnable.run();
                    }
                };
                rxSchedulerKt$scheduleTask$task$1.L$0 = coroutineContext;
                rxSchedulerKt$scheduleTask$task$1.label = 1;
                if (InterruptibleKt.runInterruptible$default(null, function0, rxSchedulerKt$scheduleTask$task$1, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineContext = (CoroutineContext) rxSchedulerKt$scheduleTask$task$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            RxCancellableKt.handleUndeliverableException(th, coroutineContext);
        }
        return Unit.INSTANCE;
    }
}
