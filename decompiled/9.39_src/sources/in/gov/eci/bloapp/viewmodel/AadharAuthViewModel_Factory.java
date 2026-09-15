package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.AadharAuthRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AadharAuthViewModel_Factory implements Factory<AadharAuthViewModel> {
    private final Provider<AadharAuthRepository> aadharAuthRepositoryProvider;
    private final Provider<ApiInterface> apiInterfaceProvider;

    public AadharAuthViewModel_Factory(Provider<AadharAuthRepository> aadharAuthRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.aadharAuthRepositoryProvider = aadharAuthRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AadharAuthViewModel m635get() {
        AadharAuthViewModel aadharAuthViewModelNewInstance = newInstance((AadharAuthRepository) this.aadharAuthRepositoryProvider.get());
        AadharAuthViewModel_MembersInjector.injectApiInterface(aadharAuthViewModelNewInstance, (ApiInterface) this.apiInterfaceProvider.get());
        return aadharAuthViewModelNewInstance;
    }

    public static AadharAuthViewModel_Factory create(Provider<AadharAuthRepository> aadharAuthRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new AadharAuthViewModel_Factory(aadharAuthRepositoryProvider, apiInterfaceProvider);
    }

    public static AadharAuthViewModel newInstance(AadharAuthRepository aadharAuthRepository) {
        return new AadharAuthViewModel(aadharAuthRepository);
    }
}
