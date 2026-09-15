package in.gov.eci.bloapp.viewmodel;

import dagger.MembersInjector;
import in.gov.eci.bloapp.network.ApiInterface;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeviceCompatibilityViewModel_MembersInjector implements MembersInjector<DeviceCompatibilityViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;

    public DeviceCompatibilityViewModel_MembersInjector(Provider<ApiInterface> apiInterfaceProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    public static MembersInjector<DeviceCompatibilityViewModel> create(Provider<ApiInterface> apiInterfaceProvider) {
        return new DeviceCompatibilityViewModel_MembersInjector(apiInterfaceProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DeviceCompatibilityViewModel instance) {
        injectApiInterface(instance, this.apiInterfaceProvider.get());
    }

    public static void injectApiInterface(DeviceCompatibilityViewModel instance, ApiInterface apiInterface) {
        instance.apiInterface = apiInterface;
    }
}
