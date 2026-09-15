package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesConstituencyModel;
import in.gov.eci.bloapp.model.app_model.HomeGenderDataModel;
import in.gov.eci.bloapp.model.app_model.ReceivedFormStatsDashModel;
import in.gov.eci.bloapp.model.network_model.PostsResponse;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MainRepository;
import in.gov.eci.bloapp.room.roommodel.BoothModel;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MainActivityViewModel extends ViewModel {
    public static final LiveData<List<PostsResponse>> booth;
    public static final MutableLiveData<List<PostsResponse>> booth1;
    public static final MutableLiveData<List<FacilitiesConstituencyModel>> facilitiesConstituencyDetailss;
    public static final MutableLiveData<List<HomeGenderDataModel>> genData;
    public static final MutableLiveData<List<ReceivedFormStatsDashModel>> homeStatsDataa;
    public static final MutableLiveData<List<ReceivedFormStatsDashModel>> homeStatsDataa1;
    public static final LiveData<List<PostsResponse>> post;
    public static final MutableLiveData<List<PostsResponse>> post1;

    @Inject
    ApiInterface apiInterface;
    MainRepository mainRepository;
    LiveData<List<ReceivedFormStatsDashModel>> homeChartData = homeStatsDataa;
    LiveData<List<ReceivedFormStatsDashModel>> homeChartData1 = homeStatsDataa1;
    LiveData<List<HomeGenderDataModel>> genderData = genData;
    LiveData<List<FacilitiesConstituencyModel>> facilitiesConstituencyDetails = facilitiesConstituencyDetailss;

    @Inject
    public MainActivityViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    static {
        MutableLiveData<List<PostsResponse>> mutableLiveData = new MutableLiveData<>();
        post1 = mutableLiveData;
        MutableLiveData<List<PostsResponse>> mutableLiveData2 = new MutableLiveData<>();
        booth1 = mutableLiveData2;
        post = mutableLiveData;
        booth = mutableLiveData2;
        homeStatsDataa = new MutableLiveData<>();
        homeStatsDataa1 = new MutableLiveData<>();
        genData = new MutableLiveData<>();
        facilitiesConstituencyDetailss = new MutableLiveData<>();
    }

    public LiveData<List<PostsResponse>> getData() {
        return this.mainRepository.getPost();
    }

    public LiveData<List<BoothModel>> getBooth() {
        return this.mainRepository.getBooth();
    }

    public void insertBooth(BoothModel boothModel) {
        this.mainRepository.insertBooth(boothModel);
    }

    public LiveData<List<ReceivedFormStatsDashModel>> getDashChartData() {
        LiveData<List<ReceivedFormStatsDashModel>> dashChartData = this.mainRepository.getDashChartData();
        this.homeChartData = dashChartData;
        return dashChartData;
    }

    public LiveData<List<ReceivedFormStatsDashModel>> getDashChartDataBefore7() {
        LiveData<List<ReceivedFormStatsDashModel>> dashChartDataBefore7 = this.mainRepository.getDashChartDataBefore7();
        this.homeChartData1 = dashChartDataBefore7;
        return dashChartDataBefore7;
    }

    public LiveData<List<HomeGenderDataModel>> getGenderData() {
        LiveData<List<HomeGenderDataModel>> genderData = this.mainRepository.getGenderData();
        this.genderData = genderData;
        return genderData;
    }

    public LiveData<List<FacilitiesConstituencyModel>> getConstituencyNameNumber(String partNumber) {
        LiveData<List<FacilitiesConstituencyModel>> constituencyNameNumber = this.mainRepository.getConstituencyNameNumber(partNumber);
        this.facilitiesConstituencyDetails = constituencyNameNumber;
        return constituencyNameNumber;
    }
}
