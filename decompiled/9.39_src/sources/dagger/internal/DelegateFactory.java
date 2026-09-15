package dagger.internal;

import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private Provider<T> delegate;

    public T get() {
        Provider<T> provider = this.delegate;
        if (provider == null) {
            throw new IllegalStateException();
        }
        return (T) provider.get();
    }

    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }

    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = provider2;
    }

    Provider<T> getDelegate() {
        return (Provider) Preconditions.checkNotNull(this.delegate);
    }
}
