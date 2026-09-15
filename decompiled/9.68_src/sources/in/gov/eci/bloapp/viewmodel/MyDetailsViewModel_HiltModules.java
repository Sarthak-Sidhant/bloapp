package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MyDetailsViewModel_HiltModules {
    private MyDetailsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @Binds
        @IntoMap
        @StringKey("in.gov.eci.bloapp.viewmodel.MyDetailsViewModel")
        public abstract ViewModel binds(MyDetailsViewModel vm);

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
            return "in.gov.eci.bloapp.viewmodel.MyDetailsViewModel";
        }
    }
}
