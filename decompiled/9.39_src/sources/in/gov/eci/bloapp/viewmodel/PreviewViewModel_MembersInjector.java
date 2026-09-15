package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PreviewViewModel_MembersInjector implements MembersInjector<PreviewViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public PreviewViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<PreviewViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new PreviewViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PreviewViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(PreviewViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
