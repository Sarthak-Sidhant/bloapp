package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }

    public static OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OverseasDetailViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
