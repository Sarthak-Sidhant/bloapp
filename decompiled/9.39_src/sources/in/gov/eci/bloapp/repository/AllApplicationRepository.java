package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.AllApplicationsModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AllApplicationRepository {
    public MutableLiveData<List<AllApplicationsModel>> _allStatus;
    public LiveData<List<AllApplicationsModel>> allStatus;
    List<AllApplicationsModel> allStatusList = new ArrayList();
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;

    @Inject
    public AllApplicationRepository(ApiInterface apiInterface) {
        MutableLiveData<List<AllApplicationsModel>> mutableLiveData = new MutableLiveData<>();
        this._allStatus = mutableLiveData;
        this.allStatus = mutableLiveData;
        this.apiInterface = apiInterface;
    }

    public LiveData<List<AllApplicationsModel>> getAllStatus() {
        this.allStatusList.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    this.allStatusList.add(new AllApplicationsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FIRST_NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LAST_NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATUS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REQUEST_TYPE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"))));
                    cursorRawQuery.moveToNext();
                }
                this._allStatus.postValue(this.allStatusList);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.allStatus;
    }
}
