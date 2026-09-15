package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.network_model.PostsResponse;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DeviceCompatibilityRepository;
import in.gov.eci.bloapp.utils.Logger;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeviceCompatibilityViewModel extends ViewModel {
    public MutableLiveData<List<PostsResponse>> _post;

    @Inject
    ApiInterface apiInterface;
    long count = 0;
    public DeviceCompatibilityRepository deviceCompatibilityRepository;
    public LiveData<List<PostsResponse>> post;

    @Inject
    public DeviceCompatibilityViewModel(DeviceCompatibilityRepository deviceCompatibilityRepository) {
        MutableLiveData<List<PostsResponse>> mutableLiveData = new MutableLiveData<>();
        this._post = mutableLiveData;
        this.post = mutableLiveData;
        this.deviceCompatibilityRepository = deviceCompatibilityRepository;
    }

    public long dataSync() {
        long jDataSync = this.deviceCompatibilityRepository.dataSync();
        this.count = jDataSync;
        Logger.d("count", String.valueOf(jDataSync));
        return this.count;
    }
}
