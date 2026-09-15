package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class NewVoterViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }

    public static NewVoterViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(NewVoterViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final NewVoterViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NewVoterViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
