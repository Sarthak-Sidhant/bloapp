package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.FacilitiesConstituencyModel;
import in.gov.eci.bloapp.model.app_model.HomeGenderDataModel;
import in.gov.eci.bloapp.model.app_model.ReceivedFormStatsDashModel;
import in.gov.eci.bloapp.model.network_model.PostsResponse;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.room.roommodel.BoothModel;
import in.gov.eci.bloapp.utils.Logger;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MainRepository {
    public static final String TAG = "TAG";
    public MutableLiveData<List<FacilitiesConstituencyModel>> _facilitiesConstituencyDetails;
    public MutableLiveData<List<HomeGenderDataModel>> _genData;
    public MutableLiveData<List<ReceivedFormStatsDashModel>> _homeStatsData;
    public MutableLiveData<List<ReceivedFormStatsDashModel>> _homeStatsData1;
    ApiInterface apiInterface;
    public LiveData<List<BoothModel>> booth;
    List<ReceivedFormStatsDashModel> dashChartList;
    List<ReceivedFormStatsDashModel> dashChartList1;

    @Inject
    DatabaseHelper dbHandler;
    public LiveData<List<BoothModel>> district;

    @Inject
    EciDatabase eciDatabase;
    public LiveData<List<FacilitiesConstituencyModel>> facilitiesConstituencyDetails;
    List<FacilitiesConstituencyModel> facilitiesConstituencyList;
    public LiveData<List<HomeGenderDataModel>> genderData;
    List<HomeGenderDataModel> genderList;
    public LiveData<List<ReceivedFormStatsDashModel>> homeChartData;
    public LiveData<List<ReceivedFormStatsDashModel>> homeChartData1;
    public LiveData<List<BoothModel>> state;
    private final List<BoothModel> boothList = new ArrayList();
    public MutableLiveData<List<PostsResponse>> _post = new MutableLiveData<>();
    public MutableLiveData<List<BoothModel>> _booth = new MutableLiveData<>();
    public MutableLiveData<List<String>> _state = new MutableLiveData<>();
    public MutableLiveData<List<BoothModel>> _district = new MutableLiveData<>();
    public LiveData<List<PostsResponse>> post = this._post;

    @Inject
    public MainRepository(ApiInterface apiInterface) {
        MutableLiveData<List<BoothModel>> mutableLiveData = this._booth;
        this.booth = mutableLiveData;
        this.state = mutableLiveData;
        this.district = mutableLiveData;
        MutableLiveData<List<ReceivedFormStatsDashModel>> mutableLiveData2 = new MutableLiveData<>();
        this._homeStatsData = mutableLiveData2;
        this.homeChartData = mutableLiveData2;
        this.dashChartList = new ArrayList();
        MutableLiveData<List<ReceivedFormStatsDashModel>> mutableLiveData3 = new MutableLiveData<>();
        this._homeStatsData1 = mutableLiveData3;
        this.homeChartData1 = mutableLiveData3;
        this.dashChartList1 = new ArrayList();
        MutableLiveData<List<HomeGenderDataModel>> mutableLiveData4 = new MutableLiveData<>();
        this._genData = mutableLiveData4;
        this.genderData = mutableLiveData4;
        this.genderList = new ArrayList();
        MutableLiveData<List<FacilitiesConstituencyModel>> mutableLiveData5 = new MutableLiveData<>();
        this._facilitiesConstituencyDetails = mutableLiveData5;
        this.facilitiesConstituencyDetails = mutableLiveData5;
        this.facilitiesConstituencyList = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public LiveData<List<BoothModel>> getBooth() {
        Logger.e("TAG", "SELECT * FROM BOOTH_LOCATOR");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM BOOTH_LOCATOR", (String[]) null);
        if (cursorRawQuery.moveToFirst()) {
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                try {
                    cursorRawQuery.getString(0);
                    cursorRawQuery.getString(1);
                    cursorRawQuery.getString(2);
                    cursorRawQuery.getString(3);
                    cursorRawQuery.getString(4);
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                cursorRawQuery.moveToNext();
            }
        }
        return this.booth;
    }

    public void insertBooth(BoothModel boothModel) {
        this.eciDatabase.boothDao().insert(boothModel).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new CompletableObserver() { // from class: in.gov.eci.bloapp.repository.MainRepository.1
            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable d) {
            }

            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                Logger.d("TAG", "Booth data inserted");
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable e) {
                Logger.d("TAG", e.toString());
            }
        });
    }

    public LiveData<List<PostsResponse>> getPost() {
        this.apiInterface.getPosts().enqueue(new Callback<List<PostsResponse>>() { // from class: in.gov.eci.bloapp.repository.MainRepository.2
            public void onResponse(Call<List<PostsResponse>> call, Response<List<PostsResponse>> response) {
                MainRepository.this._post.setValue((List) response.body());
            }

            public void onFailure(Call<List<PostsResponse>> call, Throwable t) {
                t.toString();
            }
        });
        return this.post;
    }

    public LiveData<List<ReceivedFormStatsDashModel>> getDashChartData() {
        System.out.println("coming....in ReceivedFormStatsDash repo ");
        Logger.e("TAG", "SELECT COUNT(*) AS Count,REQUEST_TYPE AS RType FROM VOTER_DETAILS WHERE CREATED_ON >= date('now','-7 day') GROUP BY REQUEST_TYPE");
        this.dashChartList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT COUNT(*) AS Count,REQUEST_TYPE AS RType FROM VOTER_DETAILS WHERE CREATED_ON >= date('now','-7 day') GROUP BY REQUEST_TYPE", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.dashChartList.add(new ReceivedFormStatsDashModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Count")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RType"))));
                this._homeStatsData.postValue(this.dashChartList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._homeStatsData.postValue(this.dashChartList);
        }
        return this.homeChartData;
    }

    public LiveData<List<ReceivedFormStatsDashModel>> getDashChartDataBefore7() {
        System.out.println("coming....in getDashChartDataBefore7 repo ");
        Logger.e("TAG", "SELECT COUNT(*) AS Count,REQUEST_TYPE AS RType FROM VOTER_DETAILS WHERE CREATED_ON < date('now','-7 day') GROUP BY REQUEST_TYPE");
        this.dashChartList1.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT COUNT(*) AS Count,REQUEST_TYPE AS RType FROM VOTER_DETAILS WHERE CREATED_ON < date('now','-7 day') GROUP BY REQUEST_TYPE", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Count"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RType"));
                System.out.println("coming....in getDashChartDataBefore7 repo - " + string + " - " + string2);
                this.dashChartList1.add(new ReceivedFormStatsDashModel(string, string2));
                this._homeStatsData1.postValue(this.dashChartList1);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._homeStatsData1.postValue(this.dashChartList1);
        }
        return this.homeChartData1;
    }

    public LiveData<List<HomeGenderDataModel>> getGenderData() {
        System.out.println("coming....in GenderDataModel repo ");
        Logger.e("TAG", "SELECT COUNT(*) AS Count,GENDER AS GType FROM VOTER_DETAILS WHERE REQUEST_TYPE = 'Form 6' OR REQUEST_TYPE = 'Form 6A' GROUP BY GENDER");
        this.genderList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT COUNT(*) AS Count,GENDER AS GType FROM VOTER_DETAILS WHERE REQUEST_TYPE = 'Form 6' OR REQUEST_TYPE = 'Form 6A' GROUP BY GENDER", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Count"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GType"));
                System.out.println("GenderData in Repository - " + string + "-" + string2);
                this.genderList.add(new HomeGenderDataModel(string, string2));
                this._genData.postValue(this.genderList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._genData.postValue(this.genderList);
        }
        return this.genderData;
    }

    public LiveData<List<FacilitiesConstituencyModel>> getConstituencyNameNumber(String part_number) {
        this.facilitiesConstituencyList.clear();
        String str = "SELECT * FROM BLO_DETAILS WHERE PART_NUMBER = '" + part_number + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            while (cursorRawQuery.moveToNext()) {
                try {
                    this.facilitiesConstituencyList.add(new FacilitiesConstituencyModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME_CONSTITUENCY")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME_CONSTITUENCY")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NUMBER_CONSTITUENCY")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NUMBER_CONSTITUENCY")) : ""));
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }
            this._facilitiesConstituencyDetails.postValue(this.facilitiesConstituencyList);
        } else {
            Logger.d("", "Else Part of Query");
            this._facilitiesConstituencyDetails.postValue(this.facilitiesConstituencyList);
        }
        return this.facilitiesConstituencyDetails;
    }
}
