package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.api.service.UserClient;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectorsListRepository_Factory implements Factory<ElectorsListRepository> {
    private final Provider<UserClient> userClientProvider;

    public ElectorsListRepository_Factory(Provider<UserClient> userClientProvider) {
        this.userClientProvider = userClientProvider;
    }

    @Override // javax.inject.Provider
    public ElectorsListRepository get() {
        return newInstance(this.userClientProvider.get());
    }

    public static ElectorsListRepository_Factory create(Provider<UserClient> userClientProvider) {
        return new ElectorsListRepository_Factory(userClientProvider);
    }

    public static ElectorsListRepository newInstance(UserClient userClient) {
        return new ElectorsListRepository(userClient);
    }
}
