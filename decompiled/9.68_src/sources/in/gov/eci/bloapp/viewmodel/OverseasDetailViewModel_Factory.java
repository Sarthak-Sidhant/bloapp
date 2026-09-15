package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class OverseasDetailViewModel_Factory implements Factory<OverseasDetailViewModel> {
    private final Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider;

    public OverseasDetailViewModel_Factory(Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider) {
        this.requestWheelchairRepositoryProvider = requestWheelchairRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public OverseasDetailViewModel get() {
        return newInstance(this.requestWheelchairRepositoryProvider.get());
    }

    public static OverseasDetailViewModel_Factory create(Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider) {
        return new OverseasDetailViewModel_Factory(requestWheelchairRepositoryProvider);
    }

    public static OverseasDetailViewModel newInstance(OverseasDetailsRepository requestWheelchairRepository) {
        return new OverseasDetailViewModel(requestWheelchairRepository);
    }
}
