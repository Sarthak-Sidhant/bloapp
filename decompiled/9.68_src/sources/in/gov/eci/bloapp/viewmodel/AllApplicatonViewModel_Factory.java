package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.AllApplicationRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AllApplicatonViewModel_Factory implements Factory<AllApplicatonViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<AllApplicationRepository> requestWheelchairRepositoryProvider;

    public AllApplicatonViewModel_Factory(Provider<AllApplicationRepository> requestWheelchairRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.requestWheelchairRepositoryProvider = requestWheelchairRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public AllApplicatonViewModel get() {
        AllApplicatonViewModel allApplicatonViewModelNewInstance = newInstance(this.requestWheelchairRepositoryProvider.get());
        AllApplicatonViewModel_MembersInjector.injectApiInterface(allApplicatonViewModelNewInstance, this.apiInterfaceProvider.get());
        return allApplicatonViewModelNewInstance;
    }

    public static AllApplicatonViewModel_Factory create(Provider<AllApplicationRepository> requestWheelchairRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new AllApplicatonViewModel_Factory(requestWheelchairRepositoryProvider, apiInterfaceProvider);
    }

    public static AllApplicatonViewModel newInstance(AllApplicationRepository requestWheelchairRepository) {
        return new AllApplicatonViewModel(requestWheelchairRepository);
    }
}
