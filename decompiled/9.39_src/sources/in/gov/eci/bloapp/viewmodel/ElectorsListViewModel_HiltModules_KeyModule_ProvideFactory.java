package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ElectorsListViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
