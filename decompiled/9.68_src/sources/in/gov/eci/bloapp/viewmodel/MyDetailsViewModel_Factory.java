package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MyDetailsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MyDetailsViewModel_Factory implements Factory<MyDetailsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<MyDetailsRepository> repoProvider;

    public MyDetailsViewModel_Factory(Provider<MyDetailsRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public MyDetailsViewModel get() {
        MyDetailsViewModel myDetailsViewModelNewInstance = newInstance(this.repoProvider.get());
        MyDetailsViewModel_MembersInjector.injectApiInterface(myDetailsViewModelNewInstance, this.apiInterfaceProvider.get());
        return myDetailsViewModelNewInstance;
    }

    public static MyDetailsViewModel_Factory create(Provider<MyDetailsRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new MyDetailsViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static MyDetailsViewModel newInstance(MyDetailsRepository repo) {
        return new MyDetailsViewModel(repo);
    }
}
