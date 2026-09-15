package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }

    public static MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(MyDetailsViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
