package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeviceCompatibilityViewModel_HiltModules {
    private DeviceCompatibilityViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @Binds
        @IntoMap
        @StringKey("in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel")
        public abstract ViewModel binds(DeviceCompatibilityViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        private KeyModule() {
        }

        @Provides
        @IntoSet
        public static String provide() {
            return "in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel";
        }
    }
}
