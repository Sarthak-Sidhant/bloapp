package com.yoti.mobile.android.commons.functional;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aZ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u0006H\u0086\bø\u0001\u0000\u001a/\u0010\u0007\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00012\u0006\u0010\b\u001a\u0002H\u0004¢\u0006\u0002\u0010\t\u001aN\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"flatMap", "Lcom/yoti/mobile/android/commons/functional/Either;", "FailureType", "MappedSuccessType", "SuccessType", "mapFunction", "Lkotlin/Function1;", "getOrElse", "value", "(Lcom/yoti/mobile/android/commons/functional/Either;Ljava/lang/Object;)Ljava/lang/Object;", "map", "commons-functional_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EitherKt {
    public static final <MappedSuccessType, FailureType, SuccessType> Either<FailureType, MappedSuccessType> flatMap(Either<? extends FailureType, ? extends SuccessType> either, Function1<? super SuccessType, ? extends Either<? extends FailureType, ? extends MappedSuccessType>> mapFunction) {
        Either<? extends FailureType, ? extends MappedSuccessType> eitherInvoke;
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        if (either instanceof Either.Failure) {
            eitherInvoke = either.failure((Object) ((Either.Failure) either).getFailResult());
        } else {
            if (!(either instanceof Either.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            eitherInvoke = mapFunction.invoke((Object) ((Either.Success) either).getSuccessResult());
        }
        return eitherInvoke;
    }

    public static final <FailureType, SuccessType> SuccessType getOrElse(Either<? extends FailureType, ? extends SuccessType> either, SuccessType successtype) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either instanceof Either.Failure) {
            return successtype;
        }
        if (either instanceof Either.Success) {
            return (SuccessType) ((Either.Success) either).getSuccessResult();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <MappedSuccessType, FailureType, SuccessType> Either<FailureType, MappedSuccessType> map(Either<? extends FailureType, ? extends SuccessType> either, Function1<? super SuccessType, ? extends MappedSuccessType> mapFunction) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        if (either instanceof Either.Failure) {
            return either.failure((Object) ((Either.Failure) either).getFailResult());
        }
        if (either instanceof Either.Success) {
            return new Either.Success(mapFunction.invoke((Object) ((Either.Success) either).getSuccessResult()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
