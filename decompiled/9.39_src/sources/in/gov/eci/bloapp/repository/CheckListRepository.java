package in.gov.eci.bloapp.repository;

import android.content.ContentValues;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CheckListRepository {
    public MutableLiveData<List<TotalListModel>> _searchList;
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;
    public LiveData<List<TotalListModel>> last15List;
    public LiveData<List<TotalListModel>> lastWeekList;
    public LiveData<List<TotalListModel>> searchList;
    public LiveData<List<TotalListModel>> todayList;
    public LiveData<List<TotalListModel>> totalList;

    @Inject
    Utils utils;
    public LiveData<List<TotalListModel>> verifiedList;
    List<TotalListModel> totalListModel = new ArrayList();
    List<TotalListModel> todayListModel = new ArrayList();
    List<TotalListModel> verifiedListModel = new ArrayList();
    List<TotalListModel> searchListModel = new ArrayList();
    public MutableLiveData<List<TotalListModel>> _totalList = new MutableLiveData<>();
    public MutableLiveData<List<TotalListModel>> _todayList = new MutableLiveData<>();
    public MutableLiveData<List<TotalListModel>> _lastWeekList = new MutableLiveData<>();
    public MutableLiveData<List<TotalListModel>> _last15List = new MutableLiveData<>();
    public MutableLiveData<List<TotalListModel>> _verifiedList = new MutableLiveData<>();

    @Inject
    public CheckListRepository(ApiInterface apiInterface) {
        MutableLiveData<List<TotalListModel>> mutableLiveData = new MutableLiveData<>();
        this._searchList = mutableLiveData;
        this.totalList = this._totalList;
        this.todayList = this._todayList;
        this.lastWeekList = this._lastWeekList;
        this.last15List = this._last15List;
        this.verifiedList = this._verifiedList;
        this.searchList = mutableLiveData;
        this.apiInterface = apiInterface;
    }

    public LiveData<List<TotalListModel>> getTotalList() {
        this.totalListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false'", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._totalList.postValue(this.totalListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.totalList;
    }

    public LiveData<List<TotalListModel>> getTodayList() {
        this.todayListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now')");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now')", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._todayList.postValue(this.todayListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.todayList;
    }

    public LiveData<List<TotalListModel>> getLastWeekList() {
        this.todayListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now','-7 day')");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now','-7 day')", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._lastWeekList.postValue(this.todayListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.lastWeekList;
    }

    public LiveData<List<TotalListModel>> getLast15List() {
        this.todayListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now','-15 day')");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'false' and  DATE >= date('now','-15 day')", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._last15List.postValue(this.todayListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.last15List;
    }

    public LiveData<List<TotalListModel>> getVerifiedList() {
        this.verifiedListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'true'");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO WHERE VERIFIED = 'true'", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._verifiedList.postValue(this.verifiedListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.verifiedList;
    }

    public LiveData<List<TotalListModel>> getSearchList() {
        this.searchListModel.clear();
        Logger.e("TAG", "SELECT * FROM VOTER_DETAILS_ERO");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM VOTER_DETAILS_ERO", (String[]) null);
        try {
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Name"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REFERENCE_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DATE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VERIFIED"));
                    cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("FORM_TYPE"));
                    cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ADDRESS"));
                    cursorRawQuery.moveToNext();
                }
                this._searchList.postValue(this.searchListModel);
            }
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        return this.searchList;
    }

    public long updateVoterDetails(String referenceNo) {
        long jUpdate;
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        ContentValues contentValues = new ContentValues();
        contentValues.put("VERIFIED", "true");
        try {
            jUpdate = writableDatabase.update("VOTER_DETAILS_ERO", contentValues, "REFERENCE_NUMBER=?", new String[]{referenceNo});
        } catch (Exception e) {
            Logger.d("", e.getMessage());
            jUpdate = -1;
        }
        if (jUpdate != -1) {
            Logger.d("Candidate Verified", "Successfully");
        }
        writableDatabase.close();
        return jUpdate;
    }
}
