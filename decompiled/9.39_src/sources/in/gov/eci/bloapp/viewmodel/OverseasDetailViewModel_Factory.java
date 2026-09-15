package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class OverseasDetailViewModel_Factory implements Factory<OverseasDetailViewModel> {
    private final Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider;

    public OverseasDetailViewModel_Factory(Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider) {
        this.requestWheelchairRepositoryProvider = requestWheelchairRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public OverseasDetailViewModel m681get() {
        return newInstance((OverseasDetailsRepository) this.requestWheelchairRepositoryProvider.get());
    }

    public static OverseasDetailViewModel_Factory create(Provider<OverseasDetailsRepository> requestWheelchairRepositoryProvider) {
        return new OverseasDetailViewModel_Factory(requestWheelchairRepositoryProvider);
    }

    public static OverseasDetailViewModel newInstance(OverseasDetailsRepository requestWheelchairRepository) {
        return new OverseasDetailViewModel(requestWheelchairRepository);
    }
}
