package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.BloNotificationRepo;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloNotificationViewModel_Factory implements Factory<BloNotificationViewModel> {
    private final Provider<BloNotificationRepo> requestWheelchairRepositoryProvider;

    public BloNotificationViewModel_Factory(Provider<BloNotificationRepo> requestWheelchairRepositoryProvider) {
        this.requestWheelchairRepositoryProvider = requestWheelchairRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public BloNotificationViewModel m641get() {
        return newInstance((BloNotificationRepo) this.requestWheelchairRepositoryProvider.get());
    }

    public static BloNotificationViewModel_Factory create(Provider<BloNotificationRepo> requestWheelchairRepositoryProvider) {
        return new BloNotificationViewModel_Factory(requestWheelchairRepositoryProvider);
    }

    public static BloNotificationViewModel newInstance(BloNotificationRepo requestWheelchairRepository) {
        return new BloNotificationViewModel(requestWheelchairRepository);
    }
}
