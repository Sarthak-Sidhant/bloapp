package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
abstract class Hilt_PseActivity extends AppCompatActivity implements GeneratedComponentManagerHolder {
    private volatile ActivityComponentManager componentManager;
    private final Object componentManagerLock;
    private boolean injected;

    Hilt_PseActivity() {
        this.componentManagerLock = new Object();
        this.injected = false;
        _initHiltInternal();
    }

    Hilt_PseActivity(int contentLayoutId) {
        super(contentLayoutId);
        this.componentManagerLock = new Object();
        this.injected = false;
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: in.gov.eci.bloapp.views.activity.Hilt_PseActivity.1
            public void onContextAvailable(Context context) {
                Hilt_PseActivity.this.inject();
            }
        });
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ActivityComponentManager createComponentManager() {
        return new ActivityComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ActivityComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((PseActivity_GeneratedInjector) generatedComponent()).injectPseActivity((PseActivity) UnsafeCasts.unsafeCast(this));
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getActivityFactory(this, super.getDefaultViewModelProviderFactory());
    }
}
