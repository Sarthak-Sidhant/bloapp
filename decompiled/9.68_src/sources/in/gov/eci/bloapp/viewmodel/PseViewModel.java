package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.PseRepository;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PseViewModel extends ViewModel {
    public MutableLiveData<Integer> _selectshiftingcorrectnessvoter;

    @Inject
    ApiInterface apiInterface;
    public PseRepository repo;
    public LiveData<Integer> selectshiftingcorrectnessvoter;

    @Inject
    public PseViewModel(PseRepository repo) {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._selectshiftingcorrectnessvoter = mutableLiveData;
        this.selectshiftingcorrectnessvoter = mutableLiveData;
        this.repo = repo;
    }

    public LiveData<Integer> selectshiftingcorrectnessvoter(String epicNumber, String formType, String formOrigin) {
        LiveData<Integer> liveDataSelectshiftingcorrectnessvoter = this.repo.selectshiftingcorrectnessvoter(epicNumber, formType, formOrigin);
        this.selectshiftingcorrectnessvoter = liveDataSelectshiftingcorrectnessvoter;
        return liveDataSelectshiftingcorrectnessvoter;
    }

    public void deleteRecord(String epicNumber, String formType, String formOrigin) {
        this.repo.deleteRecord(epicNumber, formType, formOrigin);
    }
}
