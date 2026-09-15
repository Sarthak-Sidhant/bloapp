package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MyDetailsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MyDetailsViewModel_Factory implements Factory<MyDetailsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<MyDetailsRepository> repoProvider;

    public MyDetailsViewModel_Factory(Provider<MyDetailsRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.repoProvider = repoProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MyDetailsViewModel m675get() {
        MyDetailsViewModel myDetailsViewModelNewInstance = newInstance((MyDetailsRepository) this.repoProvider.get());
        MyDetailsViewModel_MembersInjector.injectApiInterface(myDetailsViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return myDetailsViewModelNewInstance;
    }

    public static MyDetailsViewModel_Factory create(Provider<MyDetailsRepository> repoProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new MyDetailsViewModel_Factory(repoProvider, apiInterfaceProvider);
    }

    public static MyDetailsViewModel newInstance(MyDetailsRepository repo) {
        return new MyDetailsViewModel(repo);
    }
}
