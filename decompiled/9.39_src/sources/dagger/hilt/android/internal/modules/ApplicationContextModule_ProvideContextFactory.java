package dagger.hilt.android.internal.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ApplicationContextModule_ProvideContextFactory implements Factory<Context> {
    private final ApplicationContextModule module;

    public ApplicationContextModule_ProvideContextFactory(ApplicationContextModule module) {
        this.module = module;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Context m9get() {
        return provideContext(this.module);
    }

    public static ApplicationContextModule_ProvideContextFactory create(ApplicationContextModule module) {
        return new ApplicationContextModule_ProvideContextFactory(module);
    }

    public static Context provideContext(ApplicationContextModule instance) {
        return (Context) Preconditions.checkNotNullFromProvides(instance.provideContext());
    }
}
