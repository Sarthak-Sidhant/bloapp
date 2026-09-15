package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.FacilitiesConstituencyModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesGenderModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesModel;
import in.gov.eci.bloapp.model.app_model.FacilitiesRemarkDetailsModel;
import in.gov.eci.bloapp.model.app_model.FacilitiespollingModel;
import in.gov.eci.bloapp.model.app_model.ImageModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FacilitiesRepository {
    public LiveData<String> UpdateImageResponse;
    public LiveData<String> UpdateResponse;
    public MutableLiveData<String> _UpdateImageResponse;
    public MutableLiveData<String> _UpdateResponse;
    public MutableLiveData<List<FacilitiesModel>> _facilities;
    public MutableLiveData<List<FacilitiesConstituencyModel>> _facilitiesConstituencyDetails;
    List<FacilitiesModel> _facilitiesList;
    public MutableLiveData<List<FacilitiesRemarkDetailsModel>> _facilitiesRemarkDetails;
    List<FacilitiesRemarkDetailsModel> _facilitiesRemarkDetailsList;
    public MutableLiveData<List<FacilitiesGenderModel>> _genData;
    public MutableLiveData<List<ImageModel>> _getimage;
    List<ImageModel> _getimagelist;
    public MutableLiveData<List<FacilitiespollingModel>> _polls;
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    public LiveData<List<FacilitiesModel>> facilities;
    public LiveData<List<FacilitiesConstituencyModel>> facilitiesConstituencyDetails;
    List<FacilitiesConstituencyModel> facilitiesConstituencyList;
    public LiveData<List<FacilitiesRemarkDetailsModel>> facilitiesRemarkDetails;
    public LiveData<List<FacilitiesGenderModel>> genderData;
    List<FacilitiesGenderModel> genderList;
    public LiveData<List<ImageModel>> getimage;
    public LiveData<List<FacilitiespollingModel>> polls;
    List<FacilitiespollingModel> poolsList;

    @Inject
    public FacilitiesRepository(ApiInterface apiInterface) {
        MutableLiveData<List<FacilitiesModel>> mutableLiveData = new MutableLiveData<>();
        this._facilities = mutableLiveData;
        this.facilities = mutableLiveData;
        this._facilitiesList = new ArrayList();
        MutableLiveData<List<FacilitiesRemarkDetailsModel>> mutableLiveData2 = new MutableLiveData<>();
        this._facilitiesRemarkDetails = mutableLiveData2;
        this.facilitiesRemarkDetails = mutableLiveData2;
        this._facilitiesRemarkDetailsList = new ArrayList();
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this._UpdateResponse = mutableLiveData3;
        this.UpdateResponse = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._UpdateImageResponse = mutableLiveData4;
        this.UpdateImageResponse = mutableLiveData4;
        MutableLiveData<List<FacilitiespollingModel>> mutableLiveData5 = new MutableLiveData<>();
        this._polls = mutableLiveData5;
        this.polls = mutableLiveData5;
        this.poolsList = new ArrayList();
        MutableLiveData<List<FacilitiesGenderModel>> mutableLiveData6 = new MutableLiveData<>();
        this._genData = mutableLiveData6;
        this.genderData = mutableLiveData6;
        this.genderList = new ArrayList();
        MutableLiveData<List<FacilitiesConstituencyModel>> mutableLiveData7 = new MutableLiveData<>();
        this._facilitiesConstituencyDetails = mutableLiveData7;
        this.facilitiesConstituencyDetails = mutableLiveData7;
        this.facilitiesConstituencyList = new ArrayList();
        MutableLiveData<List<ImageModel>> mutableLiveData8 = new MutableLiveData<>();
        this._getimage = mutableLiveData8;
        this.getimage = mutableLiveData8;
        this._getimagelist = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public LiveData<List<FacilitiesGenderModel>> getGenderData() {
        System.out.println("coming....in Facilities Repository ");
        Logger.e("TAG", "SELECT COUNT(*) AS Count,GENDER AS GType FROM VOTER_DETAILS WHERE REQUEST_TYPE = 'Form 6' OR REQUEST_TYPE = 'Form 6A' GROUP BY GENDER");
        this.genderList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT COUNT(*) AS Count,GENDER AS GType FROM VOTER_DETAILS WHERE REQUEST_TYPE = 'Form 6' OR REQUEST_TYPE = 'Form 6A' GROUP BY GENDER", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Count"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GType"));
                System.out.println("GenderData in Repository - " + string + "-" + string2);
                this.genderList.add(new FacilitiesGenderModel(string, string2));
                this._genData.postValue(this.genderList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._genData.postValue(this.genderList);
        }
        return this.genderData;
    }

    public void updateFacilitiesData(String stateCd, String acNumber, String partNumber, String polling_station_name, String capture_gps_address, String provision_ramp, String drinking_water, String amf_adequate_furniture, String lighting, String help_desk, String signnage, String toilet, String permanent_ramp, String emf_adequate_furniture, String shatter, String road_connectivity, String crossing, String landline_fax_connection, String mobile_connectivity, String electricity_arrangements, String internet_facility, String signance, String lwe_affected_area, String forest_area, String vulnerable_location, String sensitive_ps, String building_quality, String ps_less_than_20, String building_status, String government_ps, String religious_ps, String school_ps, String ground_floor_ps, String separate_entry_exit, String provision_ramp_remarks, String drinking_water_remarks, String amf_adequate_furniture_remarks, String lighting_remarks, String help_desk_remarks, String signnage_remarks, String toilet_remarks, String permanent_ramp_remarks, String emf_adequate_furniture_remarks, String shatter_remarks, String road_connectivity_remarks, String crossing_remarks, String landline_fax_connection_remarks, String mobile_connectivity_remarks, String electricity_arrangements_remarks, String internet_facility_remarks, String signance_remarks, String lwe_affected_area_remarks, String forest_area_remarks, String vulnerable_location_remarks, String sensitive_ps_remarks, String building_quality_remarks, String ps_less_than_20_remarks, String building_status_remarks, String government_ps_remarks, String religious_ps_remarks, String school_ps_remarks, String ground_floor_ps_remarks, String separate_entry_exit_remarks, String PROVISION_RAMP_RATING, String DRINKING_WATER_RATING, String AMF_ADEQUATE_FURNITURE_RATING, String LIGHTING_RATING, String HELP_DESK_RATING, String SIGNNAGE_RATING, String TOILET_RATING, String PERMANENT_RAMP_RATING, String EMF_ADEQUATE_FURNITURE_RATING, String SHATTER_RATING, String ROAD_CONNECTIVITY_RATING, String CROSSING_RATING, String LANDLINE_FAX_CONNECTION_RATING, String MOBILE_CONNECTIVITY_RATING, String ELECTRICITY_ARRANGEMENTS_RATING, String INTERNET_FACILITY_RATING, String SIGNANCE_RATING, String LWE_AFFECTED_AREA_RATING, String FOREST_AREA_RATING, String VULNERABLE_LOCATION_RATING, String SENSITIVE_PS_RATING, String BUILDING_QUALITY_RATING, String PS_LESS_THAN_20_RATING, String BUILDING_STATUS_RATING, String GOVERNMENT_PS_RATING, String RELIGIOUS_PS_RATING, String SCHOOL_PS_RATING, String GROUND_FLOOR_PS_RATING, String SEPARATE_ENTRY_EXIT_RATING) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        writableDatabase.beginTransaction();
        try {
            try {
                String str = "UPDATE BOOTH_LOCATOR SET POLLING_STATION = '" + polling_station_name + "', CAPTURE_GPS_ADDRESS = '" + capture_gps_address + "', PROVISION_RAMP = '" + provision_ramp + "', DRINKING_WATER = '" + drinking_water + "', AMF_ADEQUATE_FURNITURE = '" + amf_adequate_furniture + "', LIGHTING = '" + lighting + "', HELP_DESK = '" + help_desk + "', SIGNNAGE = '" + signnage + "', TOILET = '" + toilet + "', PERMANENT_RAMP = '" + permanent_ramp + "', EMF_ADEQUATE_FURNITURE = '" + emf_adequate_furniture + "', SHATTER = '" + shatter + "', ROAD_CONNECTIVITY = '" + road_connectivity + "', CROSSING = '" + crossing + "', LANDLINE_FAX_CONNECTION = '" + landline_fax_connection + "', MOBILE_CONNECTIVITY = '" + mobile_connectivity + "', ELECTRICITY_ARRANGEMENTS = '" + electricity_arrangements + "', INTERNET_FACILITY = '" + internet_facility + "', SIGNANCE = '" + signance + "', LWE_AFFECTED_AREA = '" + lwe_affected_area + "', FOREST_AREA = '" + forest_area + "', VULNERABLE_LOCATION = '" + vulnerable_location + "', SENSITIVE_PS = '" + sensitive_ps + "', BUILDING_QUALITY = '" + building_quality + "', PS_LESS_THAN_20 = '" + ps_less_than_20 + "', BUILDING_STATUS = '" + building_status + "', GOVERNMENT_PS = '" + government_ps + "', RILIGIOUS_PS = '" + religious_ps + "', SCHOOL_PS = '" + school_ps + "', GROUND_FLOOR_PS = '" + ground_floor_ps + "', SEPARATE_ENTRY_EXIT = '" + separate_entry_exit + "', PROVISION_RAMP_REMARKS = '" + provision_ramp_remarks + "', DRINKING_WATER_REMARKS = '" + drinking_water_remarks + "', AMF_ADEQUATE_FURNITURE_REMARKS = '" + amf_adequate_furniture_remarks + "', LIGHTING_REMARKS = '" + lighting_remarks + "', HELP_DESK_REMARKS = '" + help_desk_remarks + "', SIGNNAGE_REMARKS = '" + signnage_remarks + "', TOILET_REMARKS = '" + toilet_remarks + "', PERMANENT_RAMP_REMARKS = '" + permanent_ramp_remarks + "', EMF_ADEQUATE_FURNITURE_REMARKS = '" + emf_adequate_furniture_remarks + "', SHATTER_REMARKS = '" + shatter_remarks + "', ROAD_CONNECTIVITY_REMARKS = '" + road_connectivity_remarks + "', CROSSING_REMARKS = '" + crossing_remarks + "', LANDLINE_FAX_CONNECTION_REMARKS = '" + landline_fax_connection_remarks + "', MOBILE_CONNECTIVITY_REMARKS = '" + mobile_connectivity_remarks + "', ELECTRICITY_ARRANGEMENTS_REMARKS = '" + electricity_arrangements_remarks + "', INTERNET_FACILITY_REMARKS = '" + internet_facility_remarks + "', SIGNANCE_REMARKS = '" + signance_remarks + "', LWE_AFFECTED_AREA_REMARKS = '" + lwe_affected_area_remarks + "', FOREST_AREA_REMARKS = '" + forest_area_remarks + "', VULNERABLE_LOCATION_REMARKS = '" + vulnerable_location_remarks + "', SENSITIVE_PS_REMARKS = '" + sensitive_ps_remarks + "', BUILDING_QUALITY_REMARKS = '" + building_quality_remarks + "', PS_LESS_THAN_20_REMARKS = '" + ps_less_than_20_remarks + "', BUILDING_STATUS_REMARKS = '" + building_status_remarks + "', GOVERNMENT_PS_REMARKS = '" + government_ps_remarks + "', RELIGIOUS_PS_REMARKS = '" + religious_ps_remarks + "', SCHOOL_PS_REMARKS = '" + school_ps_remarks + "', GROUND_FLOOR_PS_REMARKS = '" + ground_floor_ps_remarks + "', SEPARATE_ENTRY_EXIT_REMARKS = '" + separate_entry_exit_remarks + "', PROVISION_RAMP_RATING = '" + PROVISION_RAMP_RATING + "', DRINKING_WATER_RATING = '" + DRINKING_WATER_RATING + "', AMF_ADEQUATE_FURNITURE_RATING = '" + AMF_ADEQUATE_FURNITURE_RATING + "', LIGHTING_RATING = '" + LIGHTING_RATING + "', HELP_DESK_RATING = '" + HELP_DESK_RATING + "', SIGNNAGE_RATING = '" + SIGNNAGE_RATING + "', TOILET_RATING = '" + TOILET_RATING + "', PERMANENT_RAMP_RATING = '" + PERMANENT_RAMP_RATING + "', EMF_ADEQUATE_FURNITURE_RATING = '" + EMF_ADEQUATE_FURNITURE_RATING + "', SHATTER_RATING = '" + SHATTER_RATING + "', ROAD_CONNECTIVITY_RATING = '" + ROAD_CONNECTIVITY_RATING + "', CROSSING_RATING = '" + CROSSING_RATING + "', LANDLINE_FAX_CONNECTION_RATING = '" + LANDLINE_FAX_CONNECTION_RATING + "', MOBILE_CONNECTIVITY_RATING = '" + MOBILE_CONNECTIVITY_RATING + "', ELECTRICITY_ARRANGEMENTS_RATING = '" + ELECTRICITY_ARRANGEMENTS_RATING + "', INTERNET_FACILITY_RATING = '" + INTERNET_FACILITY_RATING + "', SIGNANCE_RATING = '" + SIGNANCE_RATING + "', LWE_AFFECTED_AREA_RATING = '" + LWE_AFFECTED_AREA_RATING + "', FOREST_AREA_RATING = '" + FOREST_AREA_RATING + "', VULNERABLE_LOCATION_RATING = '" + VULNERABLE_LOCATION_RATING + "', SENSITIVE_PS_RATING = '" + SENSITIVE_PS_RATING + "', BUILDING_QUALITY_RATING = '" + BUILDING_QUALITY_RATING + "', PS_LESS_THAN_20_RATING = '" + PS_LESS_THAN_20_RATING + "', BUILDING_STATUS_RATING = '" + BUILDING_STATUS_RATING + "', GOVERNMENT_PS_RATING = '" + GOVERNMENT_PS_RATING + "', RELIGIOUS_PS_RATING = '" + RELIGIOUS_PS_RATING + "', SCHOOL_PS_RATING = '" + SCHOOL_PS_RATING + "', GROUND_FLOOR_PS_RATING = '" + GROUND_FLOOR_PS_RATING + "', SEPARATE_ENTRY_EXIT_RATING = '" + SEPARATE_ENTRY_EXIT_RATING + "' WHERE stateCd = '" + stateCd + "' AND acNumber = '" + acNumber + "' AND partNumber = '" + partNumber + "'";
                Logger.e("TAG", str);
                writableDatabase.execSQL(str);
                Logger.d("updateFacilitiesData() -> ", "Data updated in BOOTH_LOCATOR table");
                this._UpdateResponse.postValue("Success");
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                Logger.d("updateFacilitiesData() -> CONTENT : ", e.getMessage());
                this._UpdateResponse.postValue("Failure");
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public LiveData<String> getUpdateResponse() {
        return this.UpdateResponse;
    }

    public LiveData<List<FacilitiespollingModel>> getBooths(String boothId) {
        this.poolsList.clear();
        String str = "SELECT * FROM BOOTH_LOCATOR WHERE BOOTH_ID = '" + boothId + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            if (cursorRawQuery.moveToFirst()) {
                this.poolsList.add(new FacilitiespollingModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("POLLING_STATION"))));
                this._polls.postValue(this.poolsList);
            }
        } else {
            this._polls.postValue(this.poolsList);
        }
        return this.polls;
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

    public LiveData<List<FacilitiesRemarkDetailsModel>> getFacilityRemarkDetails(String stateCd, String acNumber, String partNumber) {
        FacilitiesRepository facilitiesRepository;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Exception exc;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String str11 = "SENSITIVE_PS";
        String str12 = "TOILET";
        String str13 = "VULNERABLE_LOCATION";
        String str14 = "SIGNNAGE";
        String str15 = "FOREST_AREA";
        String str16 = "LWE_AFFECTED_AREA";
        String str17 = "SIGNANCE";
        String str18 = "INTERNET_FACILITY";
        String str19 = "ELECTRICITY_ARRANGEMENTS";
        String str20 = "MOBILE_CONNECTIVITY";
        this._facilitiesRemarkDetailsList.clear();
        String str21 = "LANDLINE_FAX_CONNECTION";
        String str22 = "SELECT * FROM BOOTH_LOCATOR WHERE stateCd = '" + stateCd + "' AND acNumber = '" + acNumber + "' AND partNumber = '" + partNumber + "'";
        Logger.e("TAG", str22);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str22, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            while (cursorRawQuery.moveToNext()) {
                try {
                    if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP")) != null) {
                        try {
                            string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP"));
                        } catch (Exception e) {
                            str = str13;
                            str2 = str15;
                            str3 = str16;
                            str4 = str17;
                            str5 = str18;
                            str6 = str19;
                            str7 = str20;
                            str8 = str21;
                            exc = e;
                            str9 = str12;
                            str10 = str14;
                            Logger.d("", exc.getMessage());
                            cursorRawQuery = cursorRawQuery;
                            str14 = str10;
                            str12 = str9;
                            str21 = str8;
                            str20 = str7;
                            str19 = str6;
                            str18 = str5;
                            str17 = str4;
                            str16 = str3;
                            str15 = str2;
                            str13 = str;
                            str11 = str11;
                        }
                    } else {
                        string = "";
                    }
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER")) : "";
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE")) : "";
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING")) : "";
                    String string13 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK")) : "";
                    String string14 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str14)) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str14)) : "";
                    String string15 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str12)) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str12)) : "";
                    String string16 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP")) : "";
                    String string17 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE")) : "";
                    String string18 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER")) : "";
                    String string19 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY")) : "";
                    String string20 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING")) : "";
                    str8 = str21;
                    str9 = str12;
                    try {
                        if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str8)) != null) {
                            try {
                                string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str8));
                            } catch (Exception e2) {
                                cursorRawQuery = cursorRawQuery;
                                str11 = str11;
                                str = str13;
                                str2 = str15;
                                str3 = str16;
                                str4 = str17;
                                str5 = str18;
                                str6 = str19;
                                str7 = str20;
                                exc = e2;
                                str10 = str14;
                                Logger.d("", exc.getMessage());
                                cursorRawQuery = cursorRawQuery;
                                str14 = str10;
                                str12 = str9;
                                str21 = str8;
                                str20 = str7;
                                str19 = str6;
                                str18 = str5;
                                str17 = str4;
                                str16 = str3;
                                str15 = str2;
                                str13 = str;
                                str11 = str11;
                            }
                        } else {
                            string2 = "";
                        }
                        String str23 = str20;
                        str10 = str14;
                        try {
                            if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str23)) != null) {
                                try {
                                    string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str23));
                                } catch (Exception e3) {
                                    str = str13;
                                    str2 = str15;
                                    str3 = str16;
                                    str4 = str17;
                                    str5 = str18;
                                    str6 = str19;
                                    exc = e3;
                                    str7 = str23;
                                    Logger.d("", exc.getMessage());
                                    cursorRawQuery = cursorRawQuery;
                                    str14 = str10;
                                    str12 = str9;
                                    str21 = str8;
                                    str20 = str7;
                                    str19 = str6;
                                    str18 = str5;
                                    str17 = str4;
                                    str16 = str3;
                                    str15 = str2;
                                    str13 = str;
                                    str11 = str11;
                                }
                            } else {
                                string3 = "";
                            }
                            String str24 = str19;
                            str7 = str23;
                            try {
                                if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str24)) != null) {
                                    try {
                                        string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str24));
                                    } catch (Exception e4) {
                                        cursorRawQuery = cursorRawQuery;
                                        str11 = str11;
                                        str = str13;
                                        str2 = str15;
                                        str3 = str16;
                                        str4 = str17;
                                        str5 = str18;
                                        exc = e4;
                                        str6 = str24;
                                        Logger.d("", exc.getMessage());
                                        cursorRawQuery = cursorRawQuery;
                                        str14 = str10;
                                        str12 = str9;
                                        str21 = str8;
                                        str20 = str7;
                                        str19 = str6;
                                        str18 = str5;
                                        str17 = str4;
                                        str16 = str3;
                                        str15 = str2;
                                        str13 = str;
                                        str11 = str11;
                                    }
                                } else {
                                    string4 = "";
                                }
                                String str25 = str18;
                                str6 = str24;
                                try {
                                    if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str25)) != null) {
                                        try {
                                            string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str25));
                                        } catch (Exception e5) {
                                            str = str13;
                                            str2 = str15;
                                            str3 = str16;
                                            str4 = str17;
                                            exc = e5;
                                            str5 = str25;
                                            Logger.d("", exc.getMessage());
                                            cursorRawQuery = cursorRawQuery;
                                            str14 = str10;
                                            str12 = str9;
                                            str21 = str8;
                                            str20 = str7;
                                            str19 = str6;
                                            str18 = str5;
                                            str17 = str4;
                                            str16 = str3;
                                            str15 = str2;
                                            str13 = str;
                                            str11 = str11;
                                        }
                                    } else {
                                        string5 = "";
                                    }
                                    String str26 = str17;
                                    str5 = str25;
                                    try {
                                        if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str26)) != null) {
                                            try {
                                                string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str26));
                                            } catch (Exception e6) {
                                                cursorRawQuery = cursorRawQuery;
                                                str11 = str11;
                                                str = str13;
                                                str2 = str15;
                                                str3 = str16;
                                                exc = e6;
                                                str4 = str26;
                                                Logger.d("", exc.getMessage());
                                                cursorRawQuery = cursorRawQuery;
                                                str14 = str10;
                                                str12 = str9;
                                                str21 = str8;
                                                str20 = str7;
                                                str19 = str6;
                                                str18 = str5;
                                                str17 = str4;
                                                str16 = str3;
                                                str15 = str2;
                                                str13 = str;
                                                str11 = str11;
                                            }
                                        } else {
                                            string6 = "";
                                        }
                                        String str27 = str16;
                                        str4 = str26;
                                        try {
                                            if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str27)) != null) {
                                                try {
                                                    string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str27));
                                                } catch (Exception e7) {
                                                    str = str13;
                                                    str2 = str15;
                                                    exc = e7;
                                                    str3 = str27;
                                                    Logger.d("", exc.getMessage());
                                                    cursorRawQuery = cursorRawQuery;
                                                    str14 = str10;
                                                    str12 = str9;
                                                    str21 = str8;
                                                    str20 = str7;
                                                    str19 = str6;
                                                    str18 = str5;
                                                    str17 = str4;
                                                    str16 = str3;
                                                    str15 = str2;
                                                    str13 = str;
                                                    str11 = str11;
                                                }
                                            } else {
                                                string7 = "";
                                            }
                                            String str28 = str15;
                                            str3 = str27;
                                            try {
                                                if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str28)) != null) {
                                                    try {
                                                        string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str28));
                                                    } catch (Exception e8) {
                                                        cursorRawQuery = cursorRawQuery;
                                                        str11 = str11;
                                                        str = str13;
                                                        exc = e8;
                                                        str2 = str28;
                                                        Logger.d("", exc.getMessage());
                                                    }
                                                } else {
                                                    string8 = "";
                                                }
                                                String str29 = str13;
                                                str2 = str28;
                                                try {
                                                    if (cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str29)) != null) {
                                                        try {
                                                            string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str29));
                                                        } catch (Exception e9) {
                                                            exc = e9;
                                                            str = str29;
                                                            Logger.d("", exc.getMessage());
                                                        }
                                                    } else {
                                                        string9 = "";
                                                    }
                                                    String str30 = str11;
                                                    str = str29;
                                                    try {
                                                        try {
                                                            str11 = str30;
                                                            try {
                                                                this._facilitiesRemarkDetailsList.add(new FacilitiesRemarkDetailsModel(string, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string2, string3, string4, string5, string6, string7, string8, string9, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str30)) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str30)) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RILIGIOUS_PS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RILIGIOUS_PS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_REMARKS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_REMARKS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RILIGIOUS_PS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RILIGIOUS_PS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_AMF_EMF_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_AMF_EMF_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_APPROVAL_STATUS")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_APPROVAL_STATUS")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PROVISION_RAMP_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DRINKING_WATER_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AMF_ADEQUATE_FURNITURE_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LIGHTING_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("HELP_DESK_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNNAGE_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TOILET_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERMANENT_RAMP_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMF_ADEQUATE_FURNITURE_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SHATTER_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ROAD_CONNECTIVITY_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CROSSING_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LANDLINE_FAX_CONNECTION_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_CONNECTIVITY_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ELECTRICITY_ARRANGEMENTS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("INTERNET_FACILITY_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SIGNANCE_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LWE_AFFECTED_AREA_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FOREST_AREA_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VULNERABLE_LOCATION_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SENSITIVE_PS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_QUALITY_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PS_LESS_THAN_20_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BUILDING_STATUS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GOVERNMENT_PS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RELIGIOUS_PS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SCHOOL_PS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("GROUND_FLOOR_PS_RATING")) : "", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_RATING")) != null ? cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SEPARATE_ENTRY_EXIT_RATING")) : ""));
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                exc = e;
                                                                Logger.d("", exc.getMessage());
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            str11 = str30;
                                                            exc = e;
                                                            Logger.d("", exc.getMessage());
                                                            cursorRawQuery = cursorRawQuery;
                                                            str14 = str10;
                                                            str12 = str9;
                                                            str21 = str8;
                                                            str20 = str7;
                                                            str19 = str6;
                                                            str18 = str5;
                                                            str17 = str4;
                                                            str16 = str3;
                                                            str15 = str2;
                                                            str13 = str;
                                                            str11 = str11;
                                                        }
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        cursorRawQuery = cursorRawQuery;
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    str = str29;
                                                    exc = e;
                                                    Logger.d("", exc.getMessage());
                                                    cursorRawQuery = cursorRawQuery;
                                                    str14 = str10;
                                                    str12 = str9;
                                                    str21 = str8;
                                                    str20 = str7;
                                                    str19 = str6;
                                                    str18 = str5;
                                                    str17 = str4;
                                                    str16 = str3;
                                                    str15 = str2;
                                                    str13 = str;
                                                    str11 = str11;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                cursorRawQuery = cursorRawQuery;
                                                str11 = str11;
                                                str = str13;
                                                str2 = str28;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                            str = str13;
                                            str2 = str15;
                                            str3 = str27;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        cursorRawQuery = cursorRawQuery;
                                        str11 = str11;
                                        str = str13;
                                        str2 = str15;
                                        str3 = str16;
                                        str4 = str26;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str = str13;
                                    str2 = str15;
                                    str3 = str16;
                                    str4 = str17;
                                    str5 = str25;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                cursorRawQuery = cursorRawQuery;
                                str11 = str11;
                                str = str13;
                                str2 = str15;
                                str3 = str16;
                                str4 = str17;
                                str5 = str18;
                                str6 = str24;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            str = str13;
                            str2 = str15;
                            str3 = str16;
                            str4 = str17;
                            str5 = str18;
                            str6 = str19;
                            str7 = str23;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        cursorRawQuery = cursorRawQuery;
                        str11 = str11;
                        str = str13;
                        str2 = str15;
                        str3 = str16;
                        str4 = str17;
                        str5 = str18;
                        str6 = str19;
                        str7 = str20;
                        str10 = str14;
                    }
                } catch (Exception e21) {
                    e = e21;
                    str = str13;
                    str2 = str15;
                    str3 = str16;
                    str4 = str17;
                    str5 = str18;
                    str6 = str19;
                    str7 = str20;
                    str8 = str21;
                    str9 = str12;
                    str10 = str14;
                }
                cursorRawQuery = cursorRawQuery;
                str14 = str10;
                str12 = str9;
                str21 = str8;
                str20 = str7;
                str19 = str6;
                str18 = str5;
                str17 = str4;
                str16 = str3;
                str15 = str2;
                str13 = str;
                str11 = str11;
            }
            facilitiesRepository = this;
            facilitiesRepository._facilitiesRemarkDetails.postValue(facilitiesRepository._facilitiesRemarkDetailsList);
        } else {
            facilitiesRepository = this;
            Logger.d("", "Else Part of Query");
            facilitiesRepository._facilitiesRemarkDetails.postValue(facilitiesRepository._facilitiesRemarkDetailsList);
        }
        return facilitiesRepository.facilitiesRemarkDetails;
    }

    public LiveData<List<ImageModel>> getFacilityImage(String booth_id) {
        this._getimagelist.clear();
        String str = "SELECT IMAGES,IMAGE_TEXT,IMAGE_LOCATION FROM BOOTH_IMAGES WHERE BOOTH_ID = '" + booth_id + "'";
        Logger.e("TAG", str);
        try {
            Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
            if (cursorRawQuery.getCount() > 0) {
                cursorRawQuery.moveToFirst();
                for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                    this._getimagelist.add(new ImageModel(cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("IMAGES")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("IMAGE_TEXT")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("IMAGE_LOCATION"))));
                    cursorRawQuery.moveToNext();
                }
                this._getimage.postValue(this._getimagelist);
            } else {
                Logger.d("", "Else Part of Query");
                this._getimage.postValue(this._getimagelist);
            }
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
        return this.getimage;
    }

    public void updateImages(String boothid, ArrayList<byte[]> imagelist, List<String> imagetext, List<String> address, List<String> longitude, List<String> latitude) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        writableDatabase.execSQL("DELETE FROM BOOTH_IMAGES where BOOTH_ID='" + boothid + "'");
        for (int i = 0; i < imagelist.size(); i++) {
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("INSERT INTO BOOTH_IMAGES(BOOTH_ID,IMAGES,IMAGE_TEXT,IMAGE_LOCATION,LONGITUDE,LATITUDE) values(?,?,?,?,?,?)");
            sQLiteStatementCompileStatement.clearBindings();
            sQLiteStatementCompileStatement.bindString(1, boothid);
            sQLiteStatementCompileStatement.bindBlob(2, imagelist.get(i));
            sQLiteStatementCompileStatement.bindString(3, imagetext.get(i));
            if (address.get(i) == null) {
                sQLiteStatementCompileStatement.bindString(4, StringUtils.SPACE);
            } else {
                sQLiteStatementCompileStatement.bindString(4, address.get(i));
                sQLiteStatementCompileStatement.bindString(5, longitude.get(i));
                sQLiteStatementCompileStatement.bindString(6, latitude.get(i));
            }
            try {
                sQLiteStatementCompileStatement.executeInsert();
            } catch (Exception e) {
                Logger.d("TAG", e.getMessage());
            }
        }
        writableDatabase.close();
    }
}
