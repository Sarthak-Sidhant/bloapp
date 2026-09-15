package dagger.hilt.android.internal.lifecycle;

import android.app.Application;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DefaultViewModelFactories_InternalFactoryFactory_Factory implements Factory<DefaultViewModelFactories.InternalFactoryFactory> {
    private final Provider<Application> applicationProvider;
    private final Provider<Set<String>> keySetProvider;
    private final Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider;

    public DefaultViewModelFactories_InternalFactoryFactory_Factory(Provider<Application> applicationProvider, Provider<Set<String>> keySetProvider, Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider) {
        this.applicationProvider = applicationProvider;
        this.keySetProvider = keySetProvider;
        this.viewModelComponentBuilderProvider = viewModelComponentBuilderProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DefaultViewModelFactories.InternalFactoryFactory m5get() {
        return newInstance((Application) this.applicationProvider.get(), (Set) this.keySetProvider.get(), (ViewModelComponentBuilder) this.viewModelComponentBuilderProvider.get());
    }

    public static DefaultViewModelFactories_InternalFactoryFactory_Factory create(Provider<Application> applicationProvider, Provider<Set<String>> keySetProvider, Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider) {
        return new DefaultViewModelFactories_InternalFactoryFactory_Factory(applicationProvider, keySetProvider, viewModelComponentBuilderProvider);
    }

    public static DefaultViewModelFactories.InternalFactoryFactory newInstance(Application application, Set<String> keySet, ViewModelComponentBuilder viewModelComponentBuilder) {
        return new DefaultViewModelFactories.InternalFactoryFactory(application, keySet, viewModelComponentBuilder);
    }
}
