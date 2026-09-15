package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<T> provider;

    private ProviderOfLazy(Provider<T> provider) {
        this.provider = provider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Lazy<T> m11get() {
        return DoubleCheck.lazy(this.provider);
    }

    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }
}
