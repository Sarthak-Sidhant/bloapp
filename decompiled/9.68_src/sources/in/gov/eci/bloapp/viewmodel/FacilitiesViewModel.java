package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesConstituencyModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesGenderModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesRemarkDetailsModel;
import in.gov.eci.bloapp.model.app_model.FacilitiespollingModel;
import in.gov.eci.bloapp.model.app_model.ImageModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FacilitiesRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FacilitiesViewModel extends ViewModel {
    public MutableLiveData<List<FacilitiesModel>> _facilities;
    public MutableLiveData<List<FacilitiesConstituencyModel>> _facilitiesConstituencyDetails;
    public MutableLiveData<List<FacilitiesRemarkDetailsModel>> _facilitiesRemarkDetails;
    public MutableLiveData<List<FacilitiesGenderModel>> _genData;
    public MutableLiveData<List<ImageModel>> _getimage;
    public MutableLiveData<List<FacilitiespollingModel>> _polls;

    @Inject
    ApiInterface apiInterface;
    public LiveData<List<FacilitiesModel>> facilities;
    public LiveData<List<FacilitiesConstituencyModel>> facilitiesConstituencyDetails;
    public LiveData<List<FacilitiesRemarkDetailsModel>> facilitiesRemarkDetails;
    public FacilitiesRepository facilitiesRepository;
    public LiveData<List<FacilitiesGenderModel>> genderData;
    public LiveData<List<ImageModel>> getimage;
    public LiveData<List<FacilitiespollingModel>> polls;

    @Inject
    public FacilitiesViewModel(FacilitiesRepository facilitiesRepository) {
        MutableLiveData<List<FacilitiesModel>> mutableLiveData = new MutableLiveData<>();
        this._facilities = mutableLiveData;
        this.facilities = mutableLiveData;
        MutableLiveData<List<FacilitiespollingModel>> mutableLiveData2 = new MutableLiveData<>();
        this._polls = mutableLiveData2;
        this.polls = mutableLiveData2;
        MutableLiveData<List<FacilitiesGenderModel>> mutableLiveData3 = new MutableLiveData<>();
        this._genData = mutableLiveData3;
        this.genderData = mutableLiveData3;
        MutableLiveData<List<FacilitiesRemarkDetailsModel>> mutableLiveData4 = new MutableLiveData<>();
        this._facilitiesRemarkDetails = mutableLiveData4;
        this.facilitiesRemarkDetails = mutableLiveData4;
        MutableLiveData<List<FacilitiesConstituencyModel>> mutableLiveData5 = new MutableLiveData<>();
        this._facilitiesConstituencyDetails = mutableLiveData5;
        this.facilitiesConstituencyDetails = mutableLiveData5;
        MutableLiveData<List<ImageModel>> mutableLiveData6 = new MutableLiveData<>();
        this._getimage = mutableLiveData6;
        this.getimage = mutableLiveData6;
        this.facilitiesRepository = facilitiesRepository;
    }

    public LiveData<List<FacilitiesGenderModel>> getGenderData() {
        LiveData<List<FacilitiesGenderModel>> genderData = this.facilitiesRepository.getGenderData();
        this.genderData = genderData;
        return genderData;
    }

    public void updateFacilitiesData(String stateCd, String acNumber, String partNumber, String polling_station_name, String capture_gps_address, String provision_ramp, String drinking_water, String amf_adequate_furniture, String lighting, String help_desk, String signnage, String toilet, String permanent_ramp, String emf_adequate_furniture, String shatter, String road_connectivity, String crossing, String landline_fax_connection, String mobile_connectivity, String electricity_arrangements, String internet_facility, String signance, String lwe_affected_area, String forest_area, String vulnerable_location, String sensitive_ps, String building_quality, String ps_less_than_20, String building_status, String government_ps, String religious_ps, String school_ps, String ground_floor_ps, String separate_entry_exit, String provision_ramp_remarks, String drinking_water_remarks, String amf_adequate_furniture_remarks, String lighting_remarks, String help_desk_remarks, String signnage_remarks, String toilet_remarks, String permanent_ramp_remarks, String emf_adequate_furniture_remarks, String shatter_remarks, String road_connectivity_remarks, String crossing_remarks, String landline_fax_connection_remarks, String mobile_connectivity_remarks, String electricity_arrangements_remarks, String internet_facility_remarks, String signance_remarks, String lwe_affected_area_remarks, String forest_area_remarks, String vulnerable_location_remarks, String sensitive_ps_remarks, String building_quality_remarks, String ps_less_than_20_remarks, String building_status_remarks, String government_ps_remarks, String religious_ps_remarks, String school_ps_remarks, String ground_floor_ps_remarks, String separate_entry_exit_remarks, String PROVISION_RAMP_RATING, String DRINKING_WATER_RATING, String AMF_ADEQUATE_FURNITURE_RATING, String LIGHTING_RATING, String HELP_DESK_RATING, String SIGNNAGE_RATING, String TOILET_RATING, String PERMANENT_RAMP_RATING, String EMF_ADEQUATE_FURNITURE_RATING, String SHATTER_RATING, String ROAD_CONNECTIVITY_RATING, String CROSSING_RATING, String LANDLINE_FAX_CONNECTION_RATING, String MOBILE_CONNECTIVITY_RATING, String ELECTRICITY_ARRANGEMENTS_RATING, String INTERNET_FACILITY_RATING, String SIGNANCE_RATING, String LWE_AFFECTED_AREA_RATING, String FOREST_AREA_RATING, String VULNERABLE_LOCATION_RATING, String SENSITIVE_PS_RATING, String BUILDING_QUALITY_RATING, String PS_LESS_THAN_20_RATING, String BUILDING_STATUS_RATING, String GOVERNMENT_PS_RATING, String RELIGIOUS_PS_RATING, String SCHOOL_PS_RATING, String GROUND_FLOOR_PS_RATING, String SEPARATE_ENTRY_EXIT_RATING) {
        this.facilitiesRepository.updateFacilitiesData(stateCd, acNumber, partNumber, polling_station_name, capture_gps_address, provision_ramp, drinking_water, amf_adequate_furniture, lighting, help_desk, signnage, toilet, permanent_ramp, emf_adequate_furniture, shatter, road_connectivity, crossing, landline_fax_connection, mobile_connectivity, electricity_arrangements, internet_facility, signance, lwe_affected_area, forest_area, vulnerable_location, sensitive_ps, building_quality, ps_less_than_20, building_status, government_ps, religious_ps, school_ps, ground_floor_ps, separate_entry_exit, provision_ramp_remarks, drinking_water_remarks, amf_adequate_furniture_remarks, lighting_remarks, help_desk_remarks, signnage_remarks, toilet_remarks, permanent_ramp_remarks, emf_adequate_furniture_remarks, shatter_remarks, road_connectivity_remarks, crossing_remarks, landline_fax_connection_remarks, mobile_connectivity_remarks, electricity_arrangements_remarks, internet_facility_remarks, signance_remarks, lwe_affected_area_remarks, forest_area_remarks, vulnerable_location_remarks, sensitive_ps_remarks, building_quality_remarks, ps_less_than_20_remarks, building_status_remarks, government_ps_remarks, religious_ps_remarks, school_ps_remarks, ground_floor_ps_remarks, separate_entry_exit_remarks, PROVISION_RAMP_RATING, DRINKING_WATER_RATING, AMF_ADEQUATE_FURNITURE_RATING, LIGHTING_RATING, HELP_DESK_RATING, SIGNNAGE_RATING, TOILET_RATING, PERMANENT_RAMP_RATING, EMF_ADEQUATE_FURNITURE_RATING, SHATTER_RATING, ROAD_CONNECTIVITY_RATING, CROSSING_RATING, LANDLINE_FAX_CONNECTION_RATING, MOBILE_CONNECTIVITY_RATING, ELECTRICITY_ARRANGEMENTS_RATING, INTERNET_FACILITY_RATING, SIGNANCE_RATING, LWE_AFFECTED_AREA_RATING, FOREST_AREA_RATING, VULNERABLE_LOCATION_RATING, SENSITIVE_PS_RATING, BUILDING_QUALITY_RATING, PS_LESS_THAN_20_RATING, BUILDING_STATUS_RATING, GOVERNMENT_PS_RATING, RELIGIOUS_PS_RATING, SCHOOL_PS_RATING, GROUND_FLOOR_PS_RATING, SEPARATE_ENTRY_EXIT_RATING);
    }

    public LiveData<String> getUpdateResponse() {
        return this.facilitiesRepository.getUpdateResponse();
    }

    public LiveData<List<FacilitiespollingModel>> getBooths(String booth_id) {
        LiveData<List<FacilitiespollingModel>> booths = this.facilitiesRepository.getBooths(booth_id);
        this.polls = booths;
        return booths;
    }

    public LiveData<List<FacilitiesRemarkDetailsModel>> getFacilityRemarkDetails(String stateCd, String acNumber, String partNumber) {
        LiveData<List<FacilitiesRemarkDetailsModel>> facilityRemarkDetails = this.facilitiesRepository.getFacilityRemarkDetails(stateCd, acNumber, partNumber);
        this.facilitiesRemarkDetails = facilityRemarkDetails;
        return facilityRemarkDetails;
    }

    public LiveData<List<FacilitiesConstituencyModel>> getConstituencyNameNumber(String part_number) {
        LiveData<List<FacilitiesConstituencyModel>> constituencyNameNumber = this.facilitiesRepository.getConstituencyNameNumber(part_number);
        this.facilitiesConstituencyDetails = constituencyNameNumber;
        return constituencyNameNumber;
    }

    public LiveData<List<ImageModel>> getFacilityImage(String booth_id) {
        LiveData<List<ImageModel>> facilityImage = this.facilitiesRepository.getFacilityImage(booth_id);
        this.getimage = facilityImage;
        return facilityImage;
    }

    public void updateImages(String boothid, ArrayList<byte[]> imagelist, List<String> imagetext, List<String> address, List<String> longitude, List<String> latitude) {
        this.facilitiesRepository.updateImages(boothid, imagelist, imagetext, address, longitude, latitude);
    }
}
