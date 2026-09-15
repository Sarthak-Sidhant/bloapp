package dagger.hilt.android.internal.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ApplicationContextModule_ProvideApplicationFactory implements Factory<Application> {
    private final ApplicationContextModule module;

    public ApplicationContextModule_ProvideApplicationFactory(ApplicationContextModule module) {
        this.module = module;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Application m8get() {
        return provideApplication(this.module);
    }

    public static ApplicationContextModule_ProvideApplicationFactory create(ApplicationContextModule module) {
        return new ApplicationContextModule_ProvideApplicationFactory(module);
    }

    public static Application provideApplication(ApplicationContextModule instance) {
        return (Application) Preconditions.checkNotNullFromProvides(instance.provideApplication());
    }
}
