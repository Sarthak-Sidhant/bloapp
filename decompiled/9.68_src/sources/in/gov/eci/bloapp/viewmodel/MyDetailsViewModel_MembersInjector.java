package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MyDetailsViewModel_MembersInjector implements MembersInjector<MyDetailsViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public MyDetailsViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<MyDetailsViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new MyDetailsViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyDetailsViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(MyDetailsViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
