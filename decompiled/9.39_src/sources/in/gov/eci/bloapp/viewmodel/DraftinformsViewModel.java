package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FormsModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DraftRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DraftinformsViewModel extends ViewModel {
    public MutableLiveData<List<FormsModel>> _selectadhaarauthenticationvoter;
    public MutableLiveData<List<FormsModel>> _selectdeletionObjectionvoter;
    public MutableLiveData<List<FormsModel>> _selectnewVoter;
    public MutableLiveData<List<FormsModel>> _selectoverseasElectorVoter;
    public MutableLiveData<List<FormsModel>> _selectshiftingcorrectnessvoter;

    @Inject
    ApiInterface apiInterface;
    public DraftRepository repo;
    public LiveData<List<FormsModel>> selectadhaarauthenticationvoter;
    public LiveData<List<FormsModel>> selectdeletionObjectionvoter;
    public LiveData<List<FormsModel>> selectnewVoter;
    public LiveData<List<FormsModel>> selectoverseasElectorVoter;
    public LiveData<List<FormsModel>> selectshiftingcorrectnessvoter;

    @Inject
    public DraftinformsViewModel(DraftRepository repo) {
        MutableLiveData<List<FormsModel>> mutableLiveData = new MutableLiveData<>();
        this._selectnewVoter = mutableLiveData;
        this.selectnewVoter = mutableLiveData;
        MutableLiveData<List<FormsModel>> mutableLiveData2 = new MutableLiveData<>();
        this._selectoverseasElectorVoter = mutableLiveData2;
        this.selectoverseasElectorVoter = mutableLiveData2;
        MutableLiveData<List<FormsModel>> mutableLiveData3 = new MutableLiveData<>();
        this._selectadhaarauthenticationvoter = mutableLiveData3;
        this.selectadhaarauthenticationvoter = mutableLiveData3;
        MutableLiveData<List<FormsModel>> mutableLiveData4 = new MutableLiveData<>();
        this._selectdeletionObjectionvoter = mutableLiveData4;
        this.selectdeletionObjectionvoter = mutableLiveData4;
        MutableLiveData<List<FormsModel>> mutableLiveData5 = new MutableLiveData<>();
        this._selectshiftingcorrectnessvoter = mutableLiveData5;
        this.selectshiftingcorrectnessvoter = mutableLiveData5;
        this.repo = repo;
    }

    public LiveData<List<FormsModel>> selectnewVoter() {
        LiveData<List<FormsModel>> liveDataSelectnewVoter = this.repo.selectnewVoter();
        this.selectnewVoter = liveDataSelectnewVoter;
        return liveDataSelectnewVoter;
    }

    public LiveData<List<FormsModel>> selectoverseasElectorVoter() {
        LiveData<List<FormsModel>> liveDataSelectoverseasElectorVoter = this.repo.selectoverseasElectorVoter();
        this.selectoverseasElectorVoter = liveDataSelectoverseasElectorVoter;
        return liveDataSelectoverseasElectorVoter;
    }

    public LiveData<List<FormsModel>> selectadhaarauthenticationvoter() {
        LiveData<List<FormsModel>> liveDataSelectadhaarauthenticationvoter = this.repo.selectadhaarauthenticationvoter();
        this.selectadhaarauthenticationvoter = liveDataSelectadhaarauthenticationvoter;
        return liveDataSelectadhaarauthenticationvoter;
    }

    public LiveData<List<FormsModel>> selectdeletionObjectionvoter() {
        LiveData<List<FormsModel>> liveDataSelectdeletionObjectionvoter = this.repo.selectdeletionObjectionvoter();
        this.selectdeletionObjectionvoter = liveDataSelectdeletionObjectionvoter;
        return liveDataSelectdeletionObjectionvoter;
    }

    public LiveData<List<FormsModel>> selectshiftingcorrectnessvoter() {
        LiveData<List<FormsModel>> liveDataSelectshiftingcorrectnessvoter = this.repo.selectshiftingcorrectnessvoter();
        this.selectshiftingcorrectnessvoter = liveDataSelectshiftingcorrectnessvoter;
        return liveDataSelectshiftingcorrectnessvoter;
    }

    public void deletefromsindraft(String createdon) {
        this.repo.deletefromsindraft(createdon);
    }
}
