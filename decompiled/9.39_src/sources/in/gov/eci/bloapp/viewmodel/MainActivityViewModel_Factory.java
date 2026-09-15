package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MainRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MainActivityViewModel_Factory implements Factory<MainActivityViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<MainRepository> mainRepositoryProvider;

    public MainActivityViewModel_Factory(Provider<MainRepository> mainRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.mainRepositoryProvider = mainRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MainActivityViewModel m669get() {
        MainActivityViewModel mainActivityViewModelNewInstance = newInstance((MainRepository) this.mainRepositoryProvider.get());
        MainActivityViewModel_MembersInjector.injectApiInterface(mainActivityViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return mainActivityViewModelNewInstance;
    }

    public static MainActivityViewModel_Factory create(Provider<MainRepository> mainRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new MainActivityViewModel_Factory(mainRepositoryProvider, apiInterfaceProvider);
    }

    public static MainActivityViewModel newInstance(MainRepository mainRepository) {
        return new MainActivityViewModel(mainRepository);
    }
}
