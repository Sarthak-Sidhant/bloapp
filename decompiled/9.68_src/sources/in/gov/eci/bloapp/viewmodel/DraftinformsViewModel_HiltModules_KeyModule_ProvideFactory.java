package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }

    public static DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(DraftinformsViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
