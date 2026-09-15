package in.gov.eci.bloapp.repository;

import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.electors_list.ElectorsListModel;
import in.gov.eci.bloapp.utils.Logger;
import java.util.HashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorsListRepository {
    String TAG = "ElectorsListRepository";
    private final UserClient userClient;

    @Inject
    public ElectorsListRepository(UserClient userClient) {
        this.userClient = userClient;
    }

    public void getEpicList(String token, String currentRole, String state, String acNo, String partNumber, MutableLiveData<ElectorsListModel.getEpicList.Root> getEpicListLiveData) {
        Logger.d(this.TAG, "token ---> " + token);
        Logger.d(this.TAG, "currentRole ---> " + currentRole);
        Logger.d(this.TAG, "state ---> " + state);
        Logger.d(this.TAG, "acNo ---> " + acNo);
        Logger.d(this.TAG, "partNumber ---> " + partNumber);
        HashMap map = new HashMap();
        map.put("state", state);
        map.put("acNo", acNo);
        map.put("partNo", partNumber);
    }
}
