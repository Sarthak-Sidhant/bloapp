package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AllApplicatonViewModel_MembersInjector implements MembersInjector<AllApplicatonViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public AllApplicatonViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<AllApplicatonViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new AllApplicatonViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AllApplicatonViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(AllApplicatonViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
