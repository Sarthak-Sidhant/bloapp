package in.gov.eci.bloapp.di;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
abstract class Hilt_MyApp extends Application implements GeneratedComponentManagerHolder {
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: in.gov.eci.bloapp.di.Hilt_MyApp.1
        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public Object get() {
            return DaggerMyApp_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_MyApp.this)).build();
        }
    });

    Hilt_MyApp() {
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // android.app.Application
    public void onCreate() {
        ((MyApp_GeneratedInjector) generatedComponent()).injectMyApp((MyApp) UnsafeCasts.unsafeCast(this));
        super.onCreate();
    }
}
