package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.CheckListRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CheckListViewModel extends ViewModel {

    @Inject
    ApiInterface apiInterface;
    public CheckListRepository repo;

    @Inject
    public CheckListViewModel(CheckListRepository repo) {
        this.repo = repo;
    }

    public LiveData<List<TotalListModel>> getTotalList() {
        return this.repo.getTotalList();
    }

    public LiveData<List<TotalListModel>> getTodayList() {
        return this.repo.getTodayList();
    }

    public LiveData<List<TotalListModel>> getLastWeekList() {
        return this.repo.getLastWeekList();
    }

    public LiveData<List<TotalListModel>> getLast15List() {
        return this.repo.getLast15List();
    }

    public LiveData<List<TotalListModel>> getVerifiedList() {
        return this.repo.getVerifiedList();
    }

    public LiveData<List<TotalListModel>> getSearchList() {
        return this.repo.getSearchList();
    }

    public void updateVoterDetails(String referenceNo) {
        this.repo.updateVoterDetails(referenceNo);
    }
}
