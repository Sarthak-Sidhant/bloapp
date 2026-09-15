package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FormsRepo;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> _mobNo;

    @Inject
    ApiInterface apiInterface;
    public LiveData<String> mobNo;
    public FormsRepo repo;

    @Inject
    public LoginViewModel(FormsRepo repo) {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._mobNo = mutableLiveData;
        this.mobNo = mutableLiveData;
        this.repo = repo;
    }

    public LiveData<String> getMobileNo() {
        return this.mobNo;
    }

    public void setMobileNo(String mobileNo) {
        this._mobNo.postValue(mobileNo);
    }
}
