package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FacilitiesRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FacilitiesViewModel_Factory implements Factory<FacilitiesViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<FacilitiesRepository> facilitiesRepositoryProvider;

    public FacilitiesViewModel_Factory(Provider<FacilitiesRepository> facilitiesRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.facilitiesRepositoryProvider = facilitiesRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FacilitiesViewModel m659get() {
        FacilitiesViewModel facilitiesViewModelNewInstance = newInstance((FacilitiesRepository) this.facilitiesRepositoryProvider.get());
        FacilitiesViewModel_MembersInjector.injectApiInterface(facilitiesViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return facilitiesViewModelNewInstance;
    }

    public static FacilitiesViewModel_Factory create(Provider<FacilitiesRepository> facilitiesRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new FacilitiesViewModel_Factory(facilitiesRepositoryProvider, apiInterfaceProvider);
    }

    public static FacilitiesViewModel newInstance(FacilitiesRepository facilitiesRepository) {
        return new FacilitiesViewModel(facilitiesRepository);
    }
}
