package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.BloModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MyDetailsRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MyDetailsViewModel extends ViewModel {
    public LiveData<List<BloModel>> Details;
    public MutableLiveData<List<BloModel>> _Details;

    @Inject
    ApiInterface apiInterface;
    public MyDetailsRepository repo;

    @Inject
    public MyDetailsViewModel(MyDetailsRepository repo) {
        MutableLiveData<List<BloModel>> mutableLiveData = new MutableLiveData<>();
        this._Details = mutableLiveData;
        this.Details = mutableLiveData;
        this.repo = repo;
    }

    public LiveData<List<BloModel>> getBLO(String partNumber) {
        LiveData<List<BloModel>> blo = this.repo.getBLO(partNumber);
        this.Details = blo;
        return blo;
    }

    public void updateBLODetails(String first_name, String mobile_number, String office_address, String email_id, String partNumber) {
        this.repo.updateBLODetails(first_name, mobile_number, office_address, email_id, partNumber);
    }

    public void updateDetails(String first_name, String mobile_number, String office_address, String email_id, String partNumber) {
        this.repo.updateDetails(first_name, mobile_number, office_address, email_id, partNumber);
    }
}
