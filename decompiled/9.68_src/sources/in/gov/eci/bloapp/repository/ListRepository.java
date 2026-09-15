package in.gov.eci.bloapp.repository;

import android.content.Context;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.DocumentResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.entity.ListData;
import in.gov.eci.bloapp.room.dao.ListDataDao;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ListRepository {
    private static final long CACHE_EXPIRY = 86400000;
    private final Context ctx;
    private final ListDataDao dao;
    private final SIRDatabaseHelper databaseHelper;
    private final UserClient userClient;

    public ListRepository(Context context, ListDataDao myDao) {
        this.userClient = (UserClient) ApiClient.getClient1(context).create(UserClient.class);
        this.databaseHelper = SIRDatabaseHelper.getDB(context);
        this.dao = myDao;
        this.ctx = context;
    }

    public void fetchAndSaveAllListTypes() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.repository.ListRepository$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchAndSaveAllListTypes$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchAndSaveAllListTypes$0() {
        Long lastUpdatedTime = this.dao.getLastUpdatedTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (lastUpdatedTime == null || jCurrentTimeMillis - lastUpdatedTime.longValue() > 86400000) {
            String[] strArr = {"LIST-1", "LIST-2", "LIST-3", "LIST-4", "LIST-5", "LIST-6", "LIST-7", "LIST-8"};
            for (int i = 0; i < 8; i++) {
                String str = strArr[i];
                try {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("Authorization", SharedPref.getInstance(this.ctx).getToken());
                    map.put("Content-Type", "application/json");
                    map.put("state", SharedPref.getInstance(this.ctx).getStateCode());
                    map.put("currentRole", "blo");
                    map.put("atkn_bnd", SharedPref.getInstance(this.ctx).getAtknBnd());
                    map.put("rtkn_bnd", SharedPref.getInstance(this.ctx).getRtknBnd());
                    map.put("channelidobo", "BLOAPP");
                    HashMap map2 = new HashMap();
                    map2.put("lists", str);
                    Response responseExecute = this.userClient.getSpecialRevisionListOfflineSIR(map, map2).execute();
                    if (responseExecute.isSuccessful() && responseExecute.body() != null && ((DocumentResponse) responseExecute.body()).data != null) {
                        List<ListData> list = ((DocumentResponse) responseExecute.body()).data;
                        Iterator<ListData> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().lists = str;
                        }
                        this.databaseHelper.ListDataDao().insertAll(list);
                        this.databaseHelper.ListDataDao().setLastUpdatedTime(Long.valueOf(jCurrentTimeMillis));
                    }
                } catch (IOException e) {
                    Logger.d("ListRepositry", e.toString());
                }
            }
        }
    }
}
