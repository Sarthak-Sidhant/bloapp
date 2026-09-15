package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.AadhaarAuthModel;
import in.gov.eci.bloapp.model.app_model.AssemblyConstituencyModel;
import in.gov.eci.bloapp.model.app_model.AssemblyNoModel;
import in.gov.eci.bloapp.model.app_model.DistrictModel;
import in.gov.eci.bloapp.model.app_model.FormsinDraftModel;
import in.gov.eci.bloapp.model.app_model.ParliamantaryModel;
import in.gov.eci.bloapp.model.app_model.StateDetailsModel;
import in.gov.eci.bloapp.model.app_model.StateModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.AadharAuthRepository;
import in.gov.eci.bloapp.utils.Logger;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AadharAuthViewModel extends ViewModel {
    public static AadharAuthRepository aadharAuthRepository;

    @Inject
    ApiInterface apiInterface;
    public LiveData<List<AssemblyConstituencyModel>> assembly;
    public MutableLiveData<List<AssemblyConstituencyModel>> assemblyLiveData;
    public LiveData<List<StateDetailsModel>> blo;
    public MutableLiveData<List<StateDetailsModel>> bloLiveData;
    public LiveData<List<FormsinDraftModel>> data;
    public MutableLiveData<List<FormsinDraftModel>> dataLiveData;
    public LiveData<List<DistrictModel>> district;
    public MutableLiveData<List<DistrictModel>> districtLiveData;
    public LiveData<List<ParliamantaryModel>> parliamentary;
    public MutableLiveData<List<ParliamantaryModel>> parliamentaryLiveData;
    public LiveData<List<StateModel>> state;
    public MutableLiveData<List<StateModel>> stateLiveData;
    public LiveData<List<AadhaarAuthModel>> wheel;
    public LiveData<List<AssemblyNoModel>> wheel1;
    public MutableLiveData<List<AssemblyNoModel>> wheel1LiveData;
    public MutableLiveData<List<AadhaarAuthModel>> wheelLiveData;
    String logTag = "AadharAuthViewModel";
    String epicIdText = "epicId";

    @Inject
    public AadharAuthViewModel(AadharAuthRepository aadharAuthRepository2) {
        MutableLiveData<List<StateModel>> mutableLiveData = new MutableLiveData<>();
        this.stateLiveData = mutableLiveData;
        this.state = mutableLiveData;
        MutableLiveData<List<DistrictModel>> mutableLiveData2 = new MutableLiveData<>();
        this.districtLiveData = mutableLiveData2;
        this.district = mutableLiveData2;
        MutableLiveData<List<AssemblyConstituencyModel>> mutableLiveData3 = new MutableLiveData<>();
        this.assemblyLiveData = mutableLiveData3;
        this.assembly = mutableLiveData3;
        MutableLiveData<List<ParliamantaryModel>> mutableLiveData4 = new MutableLiveData<>();
        this.parliamentaryLiveData = mutableLiveData4;
        this.parliamentary = mutableLiveData4;
        MutableLiveData<List<FormsinDraftModel>> mutableLiveData5 = new MutableLiveData<>();
        this.dataLiveData = mutableLiveData5;
        this.data = mutableLiveData5;
        MutableLiveData<List<AadhaarAuthModel>> mutableLiveData6 = new MutableLiveData<>();
        this.wheelLiveData = mutableLiveData6;
        this.wheel = mutableLiveData6;
        MutableLiveData<List<AssemblyNoModel>> mutableLiveData7 = new MutableLiveData<>();
        this.wheel1LiveData = mutableLiveData7;
        this.wheel1 = mutableLiveData7;
        MutableLiveData<List<StateDetailsModel>> mutableLiveData8 = new MutableLiveData<>();
        this.bloLiveData = mutableLiveData8;
        this.blo = mutableLiveData8;
        aadharAuthRepository = aadharAuthRepository2;
    }

    public LiveData<List<StateModel>> getState() {
        LiveData<List<StateModel>> state = aadharAuthRepository.getState();
        this.state = state;
        return state;
    }

    public LiveData<List<DistrictModel>> getDistrict(String state) {
        LiveData<List<DistrictModel>> district = aadharAuthRepository.getDistrict(state);
        this.district = district;
        return district;
    }

    public LiveData<List<AssemblyConstituencyModel>> getAsmbly(String state, String district) {
        LiveData<List<AssemblyConstituencyModel>> asmbly = aadharAuthRepository.getAsmbly(state, district);
        this.assembly = asmbly;
        return asmbly;
    }

    public LiveData<List<ParliamantaryModel>> getParliamentary(String state, String district) {
        LiveData<List<ParliamantaryModel>> parliamentary = aadharAuthRepository.getParliamentary(state, district);
        this.parliamentary = parliamentary;
        return parliamentary;
    }

    public static void insertVoterIdDetails(String firstName, String lastName, String state, String district, String idNumber, String constituency, String mobileNumber, String town, String epicNumber, byte[] ageProof, String CREATED_ON, String REFERENCE_NUMBER, String Email_Id, String status, String request_type) {
        aadharAuthRepository.insertVoterIdDetails(firstName, lastName, state, district, idNumber, constituency, mobileNumber, town, epicNumber, ageProof, CREATED_ON, REFERENCE_NUMBER, Email_Id, status, request_type);
    }

    public static void insertIntoDraft(String name, String stateDetail, String personalDetail, int sequence, String REFERENCE_NUMBER, String formType, String createdOn) {
        aadharAuthRepository.insertIntoDraft(name, stateDetail, personalDetail, sequence, REFERENCE_NUMBER, formType, createdOn);
    }

    public static void updateDraft(String selectedType, String referenceNo, String authDetail, int sequence, byte[] img) {
        aadharAuthRepository.updateDraft(selectedType, referenceNo, authDetail, sequence, img);
    }

    public static void updateDraft1(String referenceNo, String otherDetail, int sequence) {
        aadharAuthRepository.updateDraft1(referenceNo, otherDetail, sequence);
    }

    public LiveData<List<FormsinDraftModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<FormsinDraftModel>> liveDataDataoneditbutton = aadharAuthRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }

    public String getVoterDetails(String epicNumber) {
        String voterDetails = aadharAuthRepository.getVoterDetails(epicNumber);
        Logger.d(this.logTag, String.valueOf(voterDetails));
        return voterDetails;
    }

    public LiveData<List<AadhaarAuthModel>> getAadhaarData(String epicId) {
        Logger.d(this.logTag, this.epicIdText + epicId);
        LiveData<List<AadhaarAuthModel>> aadhaarData = aadharAuthRepository.getAadhaarData(epicId);
        this.wheel = aadhaarData;
        return aadhaarData;
    }

    public LiveData<List<AssemblyNoModel>> getConstituencyNo(String constituencyName) {
        Logger.d(this.logTag, "constituencyName : " + constituencyName);
        LiveData<List<AssemblyNoModel>> constituencyNo = aadharAuthRepository.getConstituencyNo(constituencyName);
        this.wheel1 = constituencyNo;
        return constituencyNo;
    }

    public LiveData<List<StateDetailsModel>> getStateDetail() {
        LiveData<List<StateDetailsModel>> stateDetail = aadharAuthRepository.getStateDetail();
        this.blo = stateDetail;
        return stateDetail;
    }
}
