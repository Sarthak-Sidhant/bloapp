package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.ElectorsListRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectorsListViewModel_Factory implements Factory<ElectorsListViewModel> {
    private final Provider<ElectorsListRepository> electorsListRepositoryProvider;

    public ElectorsListViewModel_Factory(Provider<ElectorsListRepository> electorsListRepositoryProvider) {
        this.electorsListRepositoryProvider = electorsListRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ElectorsListViewModel m656get() {
        return newInstance((ElectorsListRepository) this.electorsListRepositoryProvider.get());
    }

    public static ElectorsListViewModel_Factory create(Provider<ElectorsListRepository> electorsListRepositoryProvider) {
        return new ElectorsListViewModel_Factory(electorsListRepositoryProvider);
    }

    public static ElectorsListViewModel newInstance(ElectorsListRepository electorsListRepository) {
        return new ElectorsListViewModel(electorsListRepository);
    }
}
