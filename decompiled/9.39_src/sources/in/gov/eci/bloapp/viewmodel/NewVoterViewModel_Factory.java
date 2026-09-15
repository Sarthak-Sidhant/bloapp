package in.gov.eci.bloapp.viewmodel;

import dagger.internal.Factory;
import in.gov.eci.bloapp.repository.NewVoterrepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class NewVoterViewModel_Factory implements Factory<NewVoterViewModel> {
    private final Provider<NewVoterrepository> requestWheelchairRepositoryProvider;

    public NewVoterViewModel_Factory(Provider<NewVoterrepository> requestWheelchairRepositoryProvider) {
        this.requestWheelchairRepositoryProvider = requestWheelchairRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NewVoterViewModel m678get() {
        return newInstance((NewVoterrepository) this.requestWheelchairRepositoryProvider.get());
    }

    public static NewVoterViewModel_Factory create(Provider<NewVoterrepository> requestWheelchairRepositoryProvider) {
        return new NewVoterViewModel_Factory(requestWheelchairRepositoryProvider);
    }

    public static NewVoterViewModel newInstance(NewVoterrepository requestWheelchairRepository) {
        return new NewVoterViewModel(requestWheelchairRepository);
    }
}
