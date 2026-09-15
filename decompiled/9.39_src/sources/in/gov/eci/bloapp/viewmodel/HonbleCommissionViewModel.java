package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.model.app_model.HonbleCommissionModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.HonbleCommissionRepository;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HonbleCommissionViewModel extends ViewModel {

    @Inject
    ApiInterface apiInterface;
    MutableLiveData<HonbleCommissionModel> honbleCommissionModelMutableLiveData = new MutableLiveData<>();

    @Inject
    public RestClient restClient;

    @Inject
    public HonbleCommissionViewModel() {
    }

    public MutableLiveData<HonbleCommissionModel> getHonbleCommissionResponseLiveData() {
        return this.honbleCommissionModelMutableLiveData;
    }

    public void getHonbleCommissionApiCall() {
        new HonbleCommissionRepository(this.restClient).makeHonbleCommissionApiCall("d1ffc5d345855d3dec0987d10dff691d", "1", "1", "asc", this.honbleCommissionModelMutableLiveData);
    }
}
