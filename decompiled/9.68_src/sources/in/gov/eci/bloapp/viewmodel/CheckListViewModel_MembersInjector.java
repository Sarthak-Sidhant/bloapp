package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CheckListViewModel_MembersInjector implements MembersInjector<CheckListViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public CheckListViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<CheckListViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new CheckListViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CheckListViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(CheckListViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
