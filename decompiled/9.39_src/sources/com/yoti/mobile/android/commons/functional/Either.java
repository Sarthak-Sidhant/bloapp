package com.yoti.mobile.android.commons.functional;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u000b\u001a\u0002H\u0001¢\u0006\u0002\u0010\fJ?\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0002\u0010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000e0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0015\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0002\n\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/yoti/mobile/android/commons/functional/Either;", "FailureType", "SuccessType", "", "()V", "isFailure", "", "()Z", "isSuccess", "failure", "Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "failResult", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "fold", "R", "fnFailure", "Lkotlin/Function1;", "fnSuccess", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "success", "Lcom/yoti/mobile/android/commons/functional/Either$Success;", "successResult", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Success;", "Failure", "Success", "commons-functional_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Either<FailureType, SuccessType> {

    /* JADX INFO: compiled from: Either.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "FailureType", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "failResult", "(Ljava/lang/Object;)V", "getFailResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "equals", "", "other", "", "hashCode", "", "toString", "", "commons-functional_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Failure<FailureType> extends Either {
        private final FailureType a;

        public Failure(FailureType failuretype) {
            super(null);
            this.a = failuretype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Failure copy$default(Failure failure, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = failure.a;
            }
            return failure.copy(obj);
        }

        public final FailureType component1() {
            return this.a;
        }

        public final Failure<FailureType> copy(FailureType failResult) {
            return new Failure<>(failResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.a, ((Failure) other).a);
        }

        public final FailureType getFailResult() {
            return this.a;
        }

        public int hashCode() {
            FailureType failuretype = this.a;
            if (failuretype == null) {
                return 0;
            }
            return failuretype.hashCode();
        }

        public String toString() {
            return "Failure(failResult=" + this.a + ')';
        }
    }

    /* JADX INFO: compiled from: Either.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/yoti/mobile/android/commons/functional/Either$Success;", "SuccessType", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "successResult", "(Ljava/lang/Object;)V", "getSuccessResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "commons-functional_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Success<SuccessType> extends Either {
        private final SuccessType a;

        public Success(SuccessType successtype) {
            super(null);
            this.a = successtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.a;
            }
            return success.copy(obj);
        }

        public final SuccessType component1() {
            return this.a;
        }

        public final Success<SuccessType> copy(SuccessType successResult) {
            return new Success<>(successResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.a, ((Success) other).a);
        }

        public final SuccessType getSuccessResult() {
            return this.a;
        }

        public int hashCode() {
            SuccessType successtype = this.a;
            if (successtype == null) {
                return 0;
            }
            return successtype.hashCode();
        }

        public String toString() {
            return "Success(successResult=" + this.a + ')';
        }
    }

    private Either() {
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <FailureType> Failure<FailureType> failure(FailureType failResult) {
        return new Failure<>(failResult);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final <R> R fold(Function1<? super FailureType, ? extends R> fnFailure, Function1<? super SuccessType, ? extends R> fnSuccess) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(fnFailure, "fnFailure");
        Intrinsics.checkNotNullParameter(fnSuccess, "fnSuccess");
        if (this instanceof Failure) {
            return (R) fnFailure.invoke(((Failure) this).getFailResult());
        }
        if (this instanceof Success) {
            return (R) fnSuccess.invoke(((Success) this).getSuccessResult());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isFailure() {
        return this instanceof Failure;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    public final <SuccessType> Success<SuccessType> success(SuccessType successResult) {
        return new Success<>(successResult);
    }
}
