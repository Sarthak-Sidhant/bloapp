package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.ElectorsListRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ElectorsListViewModel_Factory implements Factory<ElectorsListViewModel> {
    private final Provider<ElectorsListRepository> electorsListRepositoryProvider;

    public ElectorsListViewModel_Factory(Provider<ElectorsListRepository> electorsListRepositoryProvider) {
        this.electorsListRepositoryProvider = electorsListRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ElectorsListViewModel get() {
        return newInstance(this.electorsListRepositoryProvider.get());
    }

    public static ElectorsListViewModel_Factory create(Provider<ElectorsListRepository> electorsListRepositoryProvider) {
        return new ElectorsListViewModel_Factory(electorsListRepositoryProvider);
    }

    public static ElectorsListViewModel newInstance(ElectorsListRepository electorsListRepository) {
        return new ElectorsListViewModel(electorsListRepository);
    }
}
