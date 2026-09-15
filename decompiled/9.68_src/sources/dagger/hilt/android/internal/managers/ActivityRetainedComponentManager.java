package dagger.hilt.android.internal.managers;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityRetainedComponentManager implements GeneratedComponentManager<ActivityRetainedComponent> {
    private volatile ActivityRetainedComponent component;
    private final Object componentLock = new Object();
    private final ViewModelProvider viewModelProvider;

    public interface ActivityRetainedComponentBuilderEntryPoint {
        ActivityRetainedComponentBuilder retainedComponentBuilder();
    }

    public interface ActivityRetainedLifecycleEntryPoint {
        ActivityRetainedLifecycle getActivityRetainedLifecycle();
    }

    static final class ActivityRetainedComponentViewModel extends ViewModel {
        private final ActivityRetainedComponent component;

        ActivityRetainedComponentViewModel(ActivityRetainedComponent component) {
            this.component = component;
        }

        ActivityRetainedComponent getComponent() {
            return this.component;
        }

        protected void onCleared() {
            super.onCleared();
            ((Lifecycle) ((ActivityRetainedLifecycleEntryPoint) EntryPoints.get(this.component, ActivityRetainedLifecycleEntryPoint.class)).getActivityRetainedLifecycle()).dispatchOnCleared();
        }
    }

    ActivityRetainedComponentManager(ComponentActivity activity) {
        this.viewModelProvider = getViewModelProvider(activity, activity);
    }

    private ViewModelProvider getViewModelProvider(ViewModelStoreOwner owner, final Context context) {
        return new ViewModelProvider(owner, new ViewModelProvider.Factory() { // from class: dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.1
            public <T extends ViewModel> T create(Class<T> aClass) {
                return new ActivityRetainedComponentViewModel(((ActivityRetainedComponentBuilderEntryPoint) EntryPointAccessors.fromApplication(context, ActivityRetainedComponentBuilderEntryPoint.class)).retainedComponentBuilder().build());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // dagger.hilt.internal.GeneratedComponentManager
    public ActivityRetainedComponent generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                if (this.component == null) {
                    this.component = createComponent();
                }
            }
        }
        return this.component;
    }

    private ActivityRetainedComponent createComponent() {
        return ((ActivityRetainedComponentViewModel) this.viewModelProvider.get(ActivityRetainedComponentViewModel.class)).getComponent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class Lifecycle implements ActivityRetainedLifecycle {
        private final Set<ActivityRetainedLifecycle.OnClearedListener> listeners = new HashSet();
        private boolean onClearedDispatched = false;

        @Inject
        Lifecycle() {
        }

        @Override // dagger.hilt.android.ActivityRetainedLifecycle
        public void addOnClearedListener(ActivityRetainedLifecycle.OnClearedListener listener) {
            ThreadUtil.ensureMainThread();
            throwIfOnClearedDispatched();
            this.listeners.add(listener);
        }

        @Override // dagger.hilt.android.ActivityRetainedLifecycle
        public void removeOnClearedListener(ActivityRetainedLifecycle.OnClearedListener listener) {
            ThreadUtil.ensureMainThread();
            throwIfOnClearedDispatched();
            this.listeners.remove(listener);
        }

        void dispatchOnCleared() {
            ThreadUtil.ensureMainThread();
            this.onClearedDispatched = true;
            Iterator<ActivityRetainedLifecycle.OnClearedListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onCleared();
            }
        }

        private void throwIfOnClearedDispatched() {
            if (this.onClearedDispatched) {
                throw new IllegalStateException("There was a race between the call to add/remove an OnClearedListener and onCleared(). This can happen when posting to the Main thread from a background thread, which is not supported.");
            }
        }
    }

    @Module
    static abstract class LifecycleModule {
        @Binds
        abstract ActivityRetainedLifecycle bind(Lifecycle impl);

        LifecycleModule() {
        }
    }
}
