package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DeviceCompatibilityRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DeviceCompatibilityViewModel_Factory implements Factory<DeviceCompatibilityViewModel> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DeviceCompatibilityRepository> deviceCompatibilityRepositoryProvider;

    public DeviceCompatibilityViewModel_Factory(Provider<DeviceCompatibilityRepository> deviceCompatibilityRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        this.deviceCompatibilityRepositoryProvider = deviceCompatibilityRepositoryProvider;
        this.apiInterfaceProvider = apiInterfaceProvider;
    }

    @Override // javax.inject.Provider
    public DeviceCompatibilityViewModel get() {
        DeviceCompatibilityViewModel deviceCompatibilityViewModelNewInstance = newInstance(this.deviceCompatibilityRepositoryProvider.get());
        DeviceCompatibilityViewModel_MembersInjector.injectApiInterface(deviceCompatibilityViewModelNewInstance, this.apiInterfaceProvider.get());
        return deviceCompatibilityViewModelNewInstance;
    }

    public static DeviceCompatibilityViewModel_Factory create(Provider<DeviceCompatibilityRepository> deviceCompatibilityRepositoryProvider, Provider<ApiInterface> apiInterfaceProvider) {
        return new DeviceCompatibilityViewModel_Factory(deviceCompatibilityRepositoryProvider, apiInterfaceProvider);
    }

    public static DeviceCompatibilityViewModel newInstance(DeviceCompatibilityRepository deviceCompatibilityRepository) {
        return new DeviceCompatibilityViewModel(deviceCompatibilityRepository);
    }
}
