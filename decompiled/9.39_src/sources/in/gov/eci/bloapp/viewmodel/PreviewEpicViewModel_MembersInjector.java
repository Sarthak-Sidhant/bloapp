package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PreviewEpicViewModel_MembersInjector implements MembersInjector<PreviewEpicViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public PreviewEpicViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<PreviewEpicViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new PreviewEpicViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PreviewEpicViewModel instance) {
        injectApiInterface(instance, (ApiInterface) this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(PreviewEpicViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
