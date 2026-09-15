package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.network_model.PostsResponse;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeviceCompatibilityRepository {
    public MutableLiveData<String> _epicNumber;
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    public LiveData<String> epicNumber;
    public LiveData<List<PostsResponse>> post;
    long count = 0;
    public MutableLiveData<List<PostsResponse>> _post = new MutableLiveData<>();

    @Inject
    public DeviceCompatibilityRepository(ApiInterface apiInterface) {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._epicNumber = mutableLiveData;
        this.post = this._post;
        this.epicNumber = mutableLiveData;
        this.apiInterface = apiInterface;
    }

    public long dataSync() {
        try {
            this.count = DatabaseUtils.queryNumEntries(this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY), "VOTER_DETAILS");
        } catch (SQLException e) {
            Logger.d("CONTENT :- ", e.getMessage());
        }
        return this.count;
    }
}
