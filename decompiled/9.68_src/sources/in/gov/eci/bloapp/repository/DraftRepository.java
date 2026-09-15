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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DraftRepository {
    public static final String TAG = "TAG";
    public MutableLiveData<List<FormsModel>> _stage1;
    public MutableLiveData<List<FormsModel>> _stage2;
    public MutableLiveData<List<FormsModel>> _stage3;
    public MutableLiveData<List<FormsModel>> _stage4;
    public MutableLiveData<List<FormsModel>> _stage5;
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    public LiveData<List<FormsModel>> stage1;
    public LiveData<List<FormsModel>> stage2;
    public LiveData<List<FormsModel>> stage3;
    public LiveData<List<FormsModel>> stage4;
    public LiveData<List<FormsModel>> stage5;
    List<FormsModel> stageList1;
    List<FormsModel> stageList2;
    List<FormsModel> stageList3;
    List<FormsModel> stageList4;
    List<FormsModel> stageList5;

    @Inject
    public DraftRepository(ApiInterface apiInterface) {
        MutableLiveData<List<FormsModel>> mutableLiveData = new MutableLiveData<>();
        this._stage1 = mutableLiveData;
        this.stage1 = mutableLiveData;
        MutableLiveData<List<FormsModel>> mutableLiveData2 = new MutableLiveData<>();
        this._stage2 = mutableLiveData2;
        this.stage2 = mutableLiveData2;
        MutableLiveData<List<FormsModel>> mutableLiveData3 = new MutableLiveData<>();
        this._stage3 = mutableLiveData3;
        this.stage3 = mutableLiveData3;
        MutableLiveData<List<FormsModel>> mutableLiveData4 = new MutableLiveData<>();
        this._stage4 = mutableLiveData4;
        this.stage4 = mutableLiveData4;
        MutableLiveData<List<FormsModel>> mutableLiveData5 = new MutableLiveData<>();
        this._stage5 = mutableLiveData5;
        this.stage5 = mutableLiveData5;
        this.stageList1 = new ArrayList();
        this.stageList2 = new ArrayList();
        this.stageList3 = new ArrayList();
        this.stageList4 = new ArrayList();
        this.stageList5 = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public LiveData<List<FormsModel>> selectnewVoter() {
        try {
            this.stageList1.clear();
            Logger.e("TAG", "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6'");
            Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6'", (String[]) null);
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    this.stageList1.add(new FormsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON"))));
                    this._stage1.postValue(this.stageList1);
                    cursorRawQuery.moveToNext();
                }
                this._stage1.postValue(this.stageList1);
            }
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
        }
        return this.stage1;
    }

    public LiveData<List<FormsModel>> selectoverseasElectorVoter() {
        this.stageList2.clear();
        Logger.e("TAG", "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6A'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6A'", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.stageList2.add(new FormsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON"))));
                this._stage2.postValue(this.stageList2);
                cursorRawQuery.moveToNext();
            }
            this._stage2.postValue(this.stageList2);
        }
        return this.stage2;
    }

    public LiveData<List<FormsModel>> selectadhaarauthenticationvoter() {
        this.stageList3.clear();
        Logger.e("TAG", "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6B'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 6B'", (String[]) null);
        System.out.println("Form 6B count--->" + cursorRawQuery.getCount());
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.stageList3.add(new FormsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON"))));
                this._stage3.postValue(this.stageList3);
                cursorRawQuery.moveToNext();
            }
            this._stage3.postValue(this.stageList3);
        }
        return this.stage3;
    }

    public LiveData<List<FormsModel>> selectdeletionObjectionvoter() {
        this.stageList4.clear();
        Logger.e("TAG", "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 7'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 7'", (String[]) null);
        System.out.println("Form 7- Deletion count--->" + cursorRawQuery.getCount());
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.stageList4.add(new FormsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON"))));
                this._stage4.postValue(this.stageList4);
                cursorRawQuery.moveToNext();
            }
            this._stage4.postValue(this.stageList4);
        }
        return this.stage4;
    }

    public LiveData<List<FormsModel>> selectshiftingcorrectnessvoter() {
        this.stageList5.clear();
        Logger.e("TAG", "SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 8'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM DRAFT_FORMS WHERE FORM_TYPE  = 'Form 8'", (String[]) null);
        System.out.println("Form 8- Deletion count--->" + cursorRawQuery.getCount());
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.stageList5.add(new FormsModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CREATED_ON")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS"))));
                this._stage5.postValue(this.stageList5);
                cursorRawQuery.moveToNext();
            }
            this._stage5.postValue(this.stageList5);
        }
        return this.stage5;
    }

    public void deletefromsindraft(String createdon) {
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("DELETE FROM DRAFT_FORMS where CREATED_ON='" + createdon + "'");
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }
}
