package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.AllApplicationsModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.AllApplicationRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AllApplicatonViewModel extends ViewModel {
    public MutableLiveData<List<AllApplicationsModel>> _wheel;

    @Inject
    ApiInterface apiInterface;
    public AllApplicationRepository requestWheelchairRepository;
    public LiveData<List<AllApplicationsModel>> wheel;

    @Inject
    public AllApplicatonViewModel(AllApplicationRepository requestWheelchairRepository) {
        MutableLiveData<List<AllApplicationsModel>> mutableLiveData = new MutableLiveData<>();
        this._wheel = mutableLiveData;
        this.wheel = mutableLiveData;
        this.requestWheelchairRepository = requestWheelchairRepository;
    }

    public LiveData<List<AllApplicationsModel>> getAllStatus() {
        LiveData<List<AllApplicationsModel>> allStatus = this.requestWheelchairRepository.getAllStatus();
        this.wheel = allStatus;
        return allStatus;
    }
}
