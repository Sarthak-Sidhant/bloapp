package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.AadhaarAuthModel;
import in.gov.eci.bloapp.model.app_model.AssemblyConstituencyModel;
import in.gov.eci.bloapp.model.app_model.AssemblyNoModel;
import in.gov.eci.bloapp.model.app_model.DistrictModel;
import in.gov.eci.bloapp.model.app_model.FormsinDraftModel;
import in.gov.eci.bloapp.model.app_model.ParliamantaryModel;
import in.gov.eci.bloapp.model.app_model.StateDetailsModel;
import in.gov.eci.bloapp.model.app_model.StateModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AadharAuthRepository {
    public MutableLiveData<List<AssemblyConstituencyModel>> _assembly;
    public MutableLiveData<List<StateDetailsModel>> _blo;
    public MutableLiveData<List<FormsinDraftModel>> _data;
    public MutableLiveData<List<DistrictModel>> _district;
    public MutableLiveData<List<ParliamantaryModel>> _parliamentary;
    public MutableLiveData<List<StateModel>> _state;
    public MutableLiveData<List<AadhaarAuthModel>> _wheel;
    public MutableLiveData<List<AssemblyNoModel>> _wheel1;
    ApiInterface apiInterface;
    public LiveData<List<AssemblyConstituencyModel>> assembly;
    List<AssemblyConstituencyModel> assemblyList;
    public LiveData<List<StateDetailsModel>> blo;
    public LiveData<List<FormsinDraftModel>> data;
    List<FormsinDraftModel> dataList;

    @Inject
    DatabaseHelper dbHandler;
    public LiveData<List<DistrictModel>> district;
    List<DistrictModel> districtList;

    @Inject
    EciDatabase eciDatabase;
    String insertIntoStageDetails;
    public LiveData<List<ParliamantaryModel>> parliamentary;
    List<ParliamantaryModel> parliamentaryList;
    String stageDataValue;
    public LiveData<List<StateModel>> state;
    List<StateModel> stateList;
    public LiveData<List<AadhaarAuthModel>> wheel;
    public LiveData<List<AssemblyNoModel>> wheel1;
    String voterIdStatus = "";
    String logTag = "AadharAuthRepository";
    String[] stageData = {"Submitted", "BLO Assigned", "Directly forwarded to ERO", "Core document verified", "FVR Submitted", " FVR Review and sent to ERO", "Re-initiated", "Hearing Scheduled", "Accepted", "Rejected", "Roll back Requested", "Roll back Accepted"};
    String voterDetailsRepoText = "in VoterDetailsModel Repository";

    @Inject
    public AadharAuthRepository(ApiInterface apiInterface) {
        MutableLiveData<List<StateModel>> mutableLiveData = new MutableLiveData<>();
        this._state = mutableLiveData;
        this.state = mutableLiveData;
        this.stateList = new ArrayList();
        MutableLiveData<List<DistrictModel>> mutableLiveData2 = new MutableLiveData<>();
        this._district = mutableLiveData2;
        this.district = mutableLiveData2;
        this.districtList = new ArrayList();
        MutableLiveData<List<AssemblyConstituencyModel>> mutableLiveData3 = new MutableLiveData<>();
        this._assembly = mutableLiveData3;
        this.assembly = mutableLiveData3;
        this.assemblyList = new ArrayList();
        MutableLiveData<List<ParliamantaryModel>> mutableLiveData4 = new MutableLiveData<>();
        this._parliamentary = mutableLiveData4;
        this.parliamentary = mutableLiveData4;
        this.parliamentaryList = new ArrayList();
        MutableLiveData<List<FormsinDraftModel>> mutableLiveData5 = new MutableLiveData<>();
        this._data = mutableLiveData5;
        this.data = mutableLiveData5;
        this.dataList = new ArrayList();
        MutableLiveData<List<AadhaarAuthModel>> mutableLiveData6 = new MutableLiveData<>();
        this._wheel = mutableLiveData6;
        this.wheel = mutableLiveData6;
        MutableLiveData<List<AssemblyNoModel>> mutableLiveData7 = new MutableLiveData<>();
        this._wheel1 = mutableLiveData7;
        this.wheel1 = mutableLiveData7;
        MutableLiveData<List<StateDetailsModel>> mutableLiveData8 = new MutableLiveData<>();
        this._blo = mutableLiveData8;
        this.blo = mutableLiveData8;
        this.apiInterface = apiInterface;
    }

    public LiveData<List<StateModel>> getState() {
        Logger.d(this.logTag, this.voterDetailsRepoText);
        this.stateList.clear();
        Logger.e(this.logTag, "SELECT DISTINCT STATE_NAME FROM STATE");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT DISTINCT STATE_NAME FROM STATE", (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.stateList.add(new StateModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_NAME"))));
                this._state.postValue(this.stateList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._state.postValue(this.stateList);
        }
        return this.state;
    }

    public LiveData<List<DistrictModel>> getDistrict(String state) {
        Logger.d(this.logTag, this.voterDetailsRepoText);
        String str = "SELECT DISTINCT d.DISTRICT_VALUE FROM DISTRICT as d inner join STATE as s on s.STATE_CD=d.STATE_CD where STATE_NAME='" + state + "'";
        Logger.e(this.logTag, str);
        this.districtList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.districtList.add(new DistrictModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DISTRICT_VALUE"))));
                this._district.postValue(this.districtList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._district.postValue(this.districtList);
        }
        return this.district;
    }

    public LiveData<List<AssemblyConstituencyModel>> getAsmbly(String state, String district) {
        Logger.d(this.logTag, this.voterDetailsRepoText);
        String str = "SELECT DISTINCT a.ASMBLY_NAME, a.ASMBLY_NO FROM ASSEMBLY_CONSTITUENCY as a inner join STATE as s on s.STATE_CD=a.STATE_CD inner join DISTRICT as d on d.DISTRICT_CD=a.DISTRICT_CD where s.STATE_NAME='" + state + "' and d.DISTRICT_VALUE='" + district + "' and STATE_TYPE ='ST'";
        Logger.e(this.logTag, str);
        this.assemblyList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ASMBLY_NAME"));
                Logger.d(this.logTag, string + " - " + cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ASMBLY_NO")));
                this.assemblyList.add(new AssemblyConstituencyModel(string));
                this._assembly.postValue(this.assemblyList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._assembly.postValue(this.assemblyList);
        }
        return this.assembly;
    }

    public LiveData<List<ParliamantaryModel>> getParliamentary(String state, String district) {
        Logger.d(this.logTag, this.voterDetailsRepoText);
        String str = "SELECT DISTINCT a.PRLMNT_NAME, a.PRLMNT_NO FROM PARLIAMENT_CONSTITUENCY as a inner join STATE as s on s.STATE_CD=a.STATE_CD inner join DISTRICT as d on d.DISTRICT_CD=a.DISTRICT_CD where STATE_NAME='" + state + "' and DISTRICT_VALUE='" + district + "' and STATE_TYPE ='UT'";
        Logger.e(this.logTag, str);
        this.parliamentaryList.clear();
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.parliamentaryList.add(new ParliamantaryModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PRLMNT_NAME"))));
                this._parliamentary.postValue(this.parliamentaryList);
                cursorRawQuery.moveToNext();
            }
        } else {
            this._parliamentary.postValue(this.parliamentaryList);
        }
        return this.parliamentary;
    }

    public void insertVoterIdDetails(String firstName, String lastName, String state, String district, String idNumber, String constituency, String mobileNumber, String town, String epicNumber, byte[] ageProof, String CREATED_ON, String REFERENCE_NUMBER, String Email_Id, String status, String request_type) {
        String str;
        String str2;
        SQLException e;
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (ageProof == null || idNumber != null) {
            str = "DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='";
            str2 = "";
            try {
                Logger.e(this.logTag, "INSERT INTO VOTER_DETAILS (FIRST_NAME, LAST_NAME, STATE,DISTRICT, AADHAR_NUMBER, CONSTITUENCY, MOBILE_NUMBER, SUBMISSION_PLACE,EPIC_NUMBER, CREATED_ON, REFERENCE_NUMBER, EMAIL_ID, STATUS, REQUEST_TYPE)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("INSERT INTO VOTER_DETAILS (FIRST_NAME, LAST_NAME, STATE,DISTRICT, AADHAR_NUMBER, CONSTITUENCY, MOBILE_NUMBER, SUBMISSION_PLACE,EPIC_NUMBER, CREATED_ON, REFERENCE_NUMBER, EMAIL_ID, STATUS, REQUEST_TYPE)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, firstName);
                sQLiteStatementCompileStatement.bindString(2, lastName);
                sQLiteStatementCompileStatement.bindString(3, state);
                sQLiteStatementCompileStatement.bindString(4, district);
                sQLiteStatementCompileStatement.bindString(5, idNumber);
                sQLiteStatementCompileStatement.bindString(6, constituency);
                sQLiteStatementCompileStatement.bindString(7, mobileNumber);
                sQLiteStatementCompileStatement.bindString(8, town);
                sQLiteStatementCompileStatement.bindString(9, epicNumber);
                sQLiteStatementCompileStatement.bindString(10, CREATED_ON);
                sQLiteStatementCompileStatement.bindString(11, REFERENCE_NUMBER);
                sQLiteStatementCompileStatement.bindString(12, Email_Id);
                sQLiteStatementCompileStatement.bindString(13, status);
                sQLiteStatementCompileStatement.bindString(14, request_type);
                sQLiteStatementCompileStatement.executeInsert();
            } catch (SQLException e2) {
                e = e2;
                Logger.d(this.logTag, e.getMessage());
            }
        } else {
            try {
                Logger.e(this.logTag, "INSERT INTO VOTER_DETAILS (FIRST_NAME, LAST_NAME, STATE,DISTRICT, AADHAR_NUMBER, CONSTITUENCY, MOBILE_NUMBER, SUBMISSION_PLACE,EPIC_NUMBER, PHOTOGRAPH, CREATED_ON, REFERENCE_NUMBER, EMAIL_ID, STATUS, REQUEST_TYPE)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("INSERT INTO VOTER_DETAILS (FIRST_NAME, LAST_NAME, STATE,DISTRICT, AADHAR_NUMBER, CONSTITUENCY, MOBILE_NUMBER, SUBMISSION_PLACE,EPIC_NUMBER, PHOTOGRAPH, CREATED_ON, REFERENCE_NUMBER, EMAIL_ID, STATUS, REQUEST_TYPE)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                sQLiteStatementCompileStatement2.clearBindings();
                sQLiteStatementCompileStatement2.bindString(1, firstName);
                sQLiteStatementCompileStatement2.bindString(2, lastName);
                sQLiteStatementCompileStatement2.bindString(3, state);
                sQLiteStatementCompileStatement2.bindString(4, district);
                sQLiteStatementCompileStatement2.bindString(5, "");
                sQLiteStatementCompileStatement2.bindString(6, constituency);
                sQLiteStatementCompileStatement2.bindString(7, mobileNumber);
                sQLiteStatementCompileStatement2.bindString(8, town);
                sQLiteStatementCompileStatement2.bindString(9, epicNumber);
                sQLiteStatementCompileStatement2.bindBlob(10, ageProof);
                sQLiteStatementCompileStatement2.bindString(11, CREATED_ON);
                sQLiteStatementCompileStatement2.bindString(12, REFERENCE_NUMBER);
                sQLiteStatementCompileStatement2.bindString(13, Email_Id);
                sQLiteStatementCompileStatement2.bindString(14, status);
                sQLiteStatementCompileStatement2.bindString(15, request_type);
                sQLiteStatementCompileStatement2.executeInsert();
                str = "DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='";
                str2 = "";
            } catch (SQLException e3) {
                e = e3;
                str2 = "";
                Logger.d(this.logTag, e.getMessage());
            }
        }
        writableDatabase.execSQL(str + REFERENCE_NUMBER + "'");
        int i = 0;
        while (i < this.stageData.length) {
            String str3 = str2;
            Logger.d(str3, "Length " + i + StringUtils.SPACE + this.stageData[i]);
            String str4 = this.stageData[i];
            this.stageDataValue = str4;
            this.insertIntoStageDetails = str3;
            Logger.d("stageDataValue ", str4);
            if (this.stageDataValue.equals("Submitted")) {
                this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,DATE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + CREATED_ON + "','" + REFERENCE_NUMBER + "')";
            } else {
                this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + REFERENCE_NUMBER + "')";
            }
            writableDatabase.execSQL(this.insertIntoStageDetails);
            i++;
            str2 = str3;
        }
    }

    public void insertIntoDraft(String name, String stateDetail, String personalDetail, int sequence, String REFERENCE_NUMBER, String formType, String createdOn) {
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("INSERT INTO DRAFT_FORMS (NAME, STATE_DETAILS, PERSONAL_DETAILS, STEP_SEQUENCE, FORM_REFERENCE_NUMBER, FORM_TYPE, CREATED_ON) VALUES ('" + name + "','" + stateDetail + "', '" + personalDetail + "', '" + sequence + "', '" + REFERENCE_NUMBER + "','" + formType + "', '" + createdOn + "')");
        } catch (SQLException e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void updateDraft(String selectedType, String referenceNo, String authDetail, int sequence, byte[] img) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (selectedType.equals("A")) {
            Logger.e(this.logTag, "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, AUTHENTICATION_DETAILS =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, AUTHENTICATION_DETAILS =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement.clearBindings();
            sQLiteStatementCompileStatement.bindString(1, String.valueOf(sequence));
            sQLiteStatementCompileStatement.bindString(2, authDetail);
            sQLiteStatementCompileStatement.bindString(3, referenceNo);
            sQLiteStatementCompileStatement.execute();
            writableDatabase.close();
            return;
        }
        try {
            Logger.e(this.logTag, "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, AUTHENTICATION_DETAILS =?, PHOTOGRAPH =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, AUTHENTICATION_DETAILS =?, PHOTOGRAPH =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement2.clearBindings();
            sQLiteStatementCompileStatement2.bindString(1, String.valueOf(sequence));
            sQLiteStatementCompileStatement2.bindString(2, authDetail);
            sQLiteStatementCompileStatement2.bindBlob(3, img);
            sQLiteStatementCompileStatement2.bindString(4, referenceNo);
            sQLiteStatementCompileStatement2.execute();
            writableDatabase.close();
        } catch (SQLException e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void updateDraft1(String referenceNo, String otherDetail, int sequence) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + sequence + "', OPTION_OF_APPLICATION='" + otherDetail + "' where FORM_REFERENCE_NUMBER='" + referenceNo + "'";
        Logger.e(this.logTag, str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public LiveData<List<FormsinDraftModel>> dataoneditbutton(String name, String date, String formtype) {
        this.dataList.clear();
        String str = "SELECT STATE_DETAILS,PERSONAL_DETAILS, AUTHENTICATION_DETAILS, OPTION_OF_APPLICATION, FORM_REFERENCE_NUMBER, PHOTOGRAPH, STEP_SEQUENCE FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formtype + "' and NAME='" + name + "' and CREATED_ON='" + date + "'";
        Logger.e(this.logTag, str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        Logger.d(this.logTag, "Form 6B- Deletion count--->" + cursorRawQuery.getCount());
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToNext();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.dataList.add(new FormsinDraftModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AUTHENTICATION_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("OPTION_OF_APPLICATION")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STEP_SEQUENCE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FORM_REFERENCE_NUMBER")), cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("PHOTOGRAPH"))));
                this._data.postValue(this.dataList);
                cursorRawQuery.moveToNext();
            }
            this._data.postValue(this.dataList);
        }
        return this.data;
    }

    public String getVoterDetails(String epic_Number) {
        String str = "SELECT * FROM VOTER_DETAILS WHERE EPIC_NUMBER = '" + epic_Number + "'";
        SQLiteDatabase readableDatabase = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY);
        Logger.d("epic_Number ", epic_Number);
        this.voterIdStatus = "";
        try {
            Cursor cursorRawQuery = readableDatabase.rawQuery(str, (String[]) null);
            this.voterIdStatus = "";
            if (cursorRawQuery.getCount() > 0) {
                this.voterIdStatus = "epicNumberFound";
            } else {
                this.voterIdStatus = "epicNumberNotFound";
            }
        } catch (SQLException e) {
            Logger.d("CONTENT :- ", e.getMessage());
        }
        return this.voterIdStatus;
    }

    public LiveData<List<AadhaarAuthModel>> getAadhaarData(String epicId) {
        String str = this.logTag;
        Logger.d(str, str);
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT * FROM VOTER_DETAILS WHERE EPIC_NUMBER = '" + epicId + "'";
        Logger.e(this.logTag, str2);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str2, (String[]) null);
        if (cursorRawQuery.moveToNext()) {
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                try {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FIRST_NAME"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LAST_NAME"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EPIC_NUMBER"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FATHER_NAME"));
                    String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE"));
                    String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DISTRICT"));
                    String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CONSTITUENCY"));
                    String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MARK_AS_PWD"));
                    String string9 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_NUMBER"));
                    String string10 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CURRENT_HOUSE_NUMBER"));
                    String string11 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CURRENT_STREET"));
                    String string12 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CURRENT_TOWN"));
                    String string13 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CURRENT_POSTOFFICE"));
                    String string14 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CURRENT_PINCODE"));
                    String string15 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PART_NUMBER"));
                    if (Objects.equals(string, null)) {
                        string = "";
                    }
                    if (Objects.equals(string2, null)) {
                        string2 = "";
                    }
                    arrayList.add(new AadhaarAuthModel(string, string2, string3, Objects.equals(string4, null) ? "" : string4, Objects.equals(string5, null) ? "" : string5, Objects.equals(string6, null) ? "" : string6, string7, string10, string11, string12, string13, string14, string15, Objects.equals(string9, null) ? "" : string9, string8));
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                cursorRawQuery.moveToNext();
            }
            this._wheel.postValue(arrayList);
        }
        return this.wheel;
    }

    public LiveData<List<AssemblyNoModel>> getConstituencyNo(String constituencyName) {
        Logger.d(this.logTag, "coming....in RequestWheelModel repo ");
        ArrayList arrayList = new ArrayList();
        String str = "SELECT ASMBLY_NO FROM ASSEMBLY_CONSTITUENCY WHERE ASMBLY_NAME = '" + constituencyName + "'";
        Logger.e(this.logTag, str);
        SQLiteDatabase readableDatabase = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY);
        Cursor cursorRawQuery = readableDatabase.rawQuery(str, (String[]) null);
        int i = 0;
        if (cursorRawQuery.moveToNext()) {
            while (i < cursorRawQuery.getCount()) {
                try {
                    arrayList.add(new AssemblyNoModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ASMBLY_NO")), ""));
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                cursorRawQuery.moveToNext();
                i++;
            }
            this._wheel1.postValue(arrayList);
        } else {
            String str2 = "SELECT PRLMNT_NO FROM PARLIAMENT_CONSTITUENCY WHERE PRLMNT_NAME = '" + constituencyName + "'";
            Logger.e(this.logTag, str2);
            Cursor cursorRawQuery2 = readableDatabase.rawQuery(str2, (String[]) null);
            if (cursorRawQuery2.moveToNext()) {
                while (i < cursorRawQuery2.getCount()) {
                    try {
                        arrayList.add(new AssemblyNoModel("", cursorRawQuery2.getString(cursorRawQuery.getColumnIndex("PRLMNT_NO"))));
                    } catch (Exception e2) {
                        Logger.d("", e2.getMessage());
                    }
                    cursorRawQuery2.moveToNext();
                    i++;
                }
                this._wheel1.postValue(arrayList);
            }
        }
        return this.wheel1;
    }

    public LiveData<List<StateDetailsModel>> getStateDetail() {
        Logger.d(this.logTag, "coming....in StateDetailsModel repo ");
        ArrayList arrayList = new ArrayList();
        Logger.e(this.logTag, "SELECT * FROM BLO_DETAILS");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT * FROM BLO_DETAILS", (String[]) null);
        if (cursorRawQuery.moveToNext()) {
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                try {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DISTRICT"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NUMBER_CONSTITUENCY"));
                    String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("NAME_CONSTITUENCY"));
                    if (Objects.equals(string, null)) {
                        string = "";
                    }
                    if (Objects.equals(string2, null)) {
                        string2 = "";
                    }
                    if (Objects.equals(string3, null)) {
                        string3 = "";
                    }
                    if (Objects.equals(string4, null)) {
                        string4 = "";
                    }
                    arrayList.add(new StateDetailsModel(string, string4, string3, string2));
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                cursorRawQuery.moveToNext();
            }
            this._blo.postValue(arrayList);
        }
        return this.blo;
    }
}
