package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
abstract class Hilt_Migration_preview_Form extends Fragment implements GeneratedComponentManagerHolder {
    private ContextWrapper componentContext;
    private volatile FragmentComponentManager componentManager;
    private final Object componentManagerLock;
    private boolean disableGetContextFix;
    private boolean injected;

    Hilt_Migration_preview_Form() {
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    Hilt_Migration_preview_Form(int contentLayoutId) {
        super(contentLayoutId);
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        initializeComponentContext();
        inject();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.componentContext;
        Preconditions.checkState(contextWrapper == null || FragmentComponentManager.findActivity(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        initializeComponentContext();
        inject();
    }

    private void initializeComponentContext() {
        if (this.componentContext == null) {
            this.componentContext = FragmentComponentManager.createContextWrapper(super.getContext(), this);
            this.disableGetContextFix = FragmentGetContextFix.isFragmentGetContextFixDisabled(super.getContext());
        }
    }

    public Context getContext() {
        if (super.getContext() == null && !this.disableGetContextFix) {
            return null;
        }
        initializeComponentContext();
        return this.componentContext;
    }

    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(savedInstanceState), this));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    protected FragmentComponentManager createComponentManager() {
        return new FragmentComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final FragmentComponentManager componentManager() {
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
        ((Migration_preview_Form_GeneratedInjector) generatedComponent()).injectMigration_preview_Form((Migration_preview_Form) UnsafeCasts.unsafeCast(this));
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getFragmentFactory(this, super.getDefaultViewModelProviderFactory());
    }
}
