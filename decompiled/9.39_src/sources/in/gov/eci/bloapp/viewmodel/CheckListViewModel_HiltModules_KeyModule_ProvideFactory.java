package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CheckListViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static CheckListViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(CheckListViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final CheckListViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CheckListViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
