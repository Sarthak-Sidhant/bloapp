package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.FormsModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PseRepository {
    public static final String TAG = "TAG";
    public MutableLiveData<Integer> _stage5;
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    public LiveData<Integer> stage5;
    List<FormsModel> stageList5;

    @Inject
    public PseRepository(ApiInterface apiInterface) {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._stage5 = mutableLiveData;
        this.stage5 = mutableLiveData;
        this.stageList5 = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public LiveData<Integer> selectshiftingcorrectnessvoter(String epicNumber, String formType, String formOrigin) {
        this.stageList5.clear();
        String str = "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formType + "' AND FORM_ORIGIN = '" + formOrigin + "' AND EPIC_NUMBER = '" + epicNumber + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        System.out.println("Form 8 & 7- Deletion count--->" + cursorRawQuery.getCount());
        this._stage5.postValue(Integer.valueOf(cursorRawQuery.getCount()));
        return this.stage5;
    }

    public void deleteRecord(String epicNumber, String formType, String formOrigin) {
        String str = "DELETE FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formType + "' AND FORM_ORIGIN = '" + formOrigin + "' AND EPIC_NUMBER = '" + epicNumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }
}
