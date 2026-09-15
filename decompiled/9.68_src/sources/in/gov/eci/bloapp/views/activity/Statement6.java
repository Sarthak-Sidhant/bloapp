package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloActivityStatement6Binding;
import in.gov.eci.bloapp.databinding.BloProgressLayoutBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Statement6 extends BaseActivity {
    BloActivityStatement6Binding BloActivityStatement6Binding;
    String acNoText;
    String alertText;
    String applicationJsonText;
    String asmblyNO;
    String asmblyName;
    String bearerText;
    Retrofit.Builder builder;
    String buildingText;
    CommomUtility commomUtility;
    String crntElecIncDescPopulationText;
    String crntElecPopulationRatioText;
    String crntElecPrevPopulationRatioText;
    String crntRevisionNoText;
    String crntTotalIncDescPopulationText;
    String currentRole;
    String districtCdText;
    String districtCode;
    String districtName;
    Double electorPopulationRatioAtTimeOfCurrentRevision;
    Double electorPopulationRationAtTimeOfPreviousRevision;
    String getRefreshTokenText;
    String houseText;
    Double increaseDecreaseInElectorPopulationRatio;
    String messageText;
    OkHttpClient okHttpClient;
    String okText;
    String onFailureText;
    String partName;
    String partNo;
    String partNoText;
    String payloadText;
    Dialog progressDialog;
    String refreshToken;
    Retrofit retrofit;
    String sessionExpiredText;
    String sessionExpiredTextForRefresh;
    String societyText;
    String stateCdText;
    String stateCode;
    String stateName;
    String statusCodeText;
    String textForZeroValue;
    String token;
    CommomUtility commonUtilClass = new CommomUtility();
    String logTag = "Statement6";
    String houseCount = "0";
    String buildingCount = "0";
    String societyCount = "0";
    String crntTotalIncDescPopulation = "0";
    String crntElecPopulationRatio = "0";
    String crntElecIncDescPopulation = "0";
    String crntElecPrevPopulationRatio = "0";
    String crntRevisionNo = "0";
    String currentYearPopulatuon = "0";
    String previousYearPopulatuon = "0";
    String currentRevisionElectors = "0";
    String previousRevisionElectors = "0";
    int increaseDecreaseInTotalPopulationOfPartVillage = 0;

    public Statement6() {
        Double dValueOf = Double.valueOf(0.0d);
        this.electorPopulationRatioAtTimeOfCurrentRevision = dValueOf;
        this.electorPopulationRationAtTimeOfPreviousRevision = dValueOf;
        this.increaseDecreaseInElectorPopulationRatio = dValueOf;
        this.stateCdText = "stateCd";
        this.acNoText = "acNo";
        this.partNoText = "partNo";
        this.statusCodeText = "statusCode";
        this.messageText = "message";
        this.textForZeroValue = "0";
        this.districtCdText = "districtCd";
        this.currentRole = "blo";
        this.sessionExpiredText = "Session Expired. Please Login again..";
        this.sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
        this.okText = "Ok";
        this.alertText = "Alert";
        this.applicationJsonText = "application/json";
        this.houseText = "house";
        this.buildingText = "building";
        this.societyText = "society";
        this.crntTotalIncDescPopulationText = "crntTotalIncDescPopulation";
        this.crntElecPopulationRatioText = "crntElecPopulationRatio";
        this.crntElecIncDescPopulationText = "crntElecIncDescPopulation";
        this.crntElecPrevPopulationRatioText = "crntElecPrevPopulationRatio";
        this.crntRevisionNoText = "crntRevisionNo";
        this.onFailureText = "onFailure : ";
        this.payloadText = "payload";
        this.bearerText = "Bearer ";
        this.getRefreshTokenText = "getRefreshToken : ";
        this.okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.commomUtility = new CommomUtility();
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityStatement6Binding bloActivityStatement6BindingInflate = BloActivityStatement6Binding.inflate(getLayoutInflater());
        this.BloActivityStatement6Binding = bloActivityStatement6BindingInflate;
        setContentView((View) bloActivityStatement6BindingInflate.getRoot());
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.stateName = SharedPref.getInstance(this).getStateName();
        this.districtName = SharedPref.getInstance(this).getDistrictName();
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partName = SharedPref.getInstance(this).getPartName();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.refreshToken = SharedPref.getInstance(this).getRefreshToken();
        Logger.d(this.logTag, "token -- > " + this.token);
        Logger.d(this.logTag, "stateCode -- > " + this.stateCode);
        Logger.d(this.logTag, "districtCode -- > " + this.districtCode);
        Logger.d(this.logTag, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(this.logTag, "stateName -- > " + this.stateName);
        Logger.d(this.logTag, "districtName -- > " + this.districtName);
        Logger.d(this.logTag, "asmblyName -- > " + this.asmblyName);
        Logger.d(this.logTag, "partName -- > " + this.partName);
        Logger.d(this.logTag, "partNo -- > " + this.partNo);
        Logger.d(this.logTag, "refreshToken -- > " + this.refreshToken);
        this.BloActivityStatement6Binding.titleBarPreview.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewCardView.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewFooterCardView.setVisibility(8);
        if (this.progressDialog == null) {
            this.progressDialog = showProgressDialog(this);
        }
        this.BloActivityStatement6Binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.BloActivityStatement6Binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.BloActivityStatement6Binding.homePreviewBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        if (isNetworkAvailable(this)) {
            showProgressVisible();
            getStatement6LastRevisionData();
            getStatement6CurrentRevisionData();
        }
        this.BloActivityStatement6Binding.resetButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.BloActivityStatement6Binding.previewButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.BloActivityStatement6Binding.backPreview.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.BloActivityStatement6Binding.keepEditingButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.BloActivityStatement6Binding.submitButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (isNetworkAvailable(this)) {
            showProgressVisible();
            getStatement6LastRevisionData();
            getStatement6CurrentRevisionData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHouses.getText().toString() == null || this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHouses.getText().toString().equals("")) {
            showAlertdialog(this.alertText, "Please Enter newly Constructed houses.");
            return;
        }
        if (this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildings.getText().toString() == null || this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildings.getText().toString().equals("")) {
            showAlertdialog(this.alertText, "Please Enter newly Constructed buildings.");
            return;
        }
        if (this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocieties.getText().toString() == null || this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocieties.getText().toString().equals("")) {
            showAlertdialog(this.alertText, "Please Enter newly Constructed socities.");
            return;
        }
        this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHousesPreview.setText(this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHouses.getText().toString());
        this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildingsPreview.setText(this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildings.getText().toString());
        this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocietiesPreview.setText(this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocieties.getText().toString());
        this.BloActivityStatement6Binding.etIncreaseDecreaseInTotalPopulationOfPartVillagePreview.setText(this.BloActivityStatement6Binding.etIncreaseDecreaseInTotalPopulationOfPartVillage.getText().toString());
        this.BloActivityStatement6Binding.etElectorPopulationRatioAtTimeOfCurrentRevisionPreview.setText(this.BloActivityStatement6Binding.etElectorPopulationRatioAtTimeOfCurrentRevision.getText().toString());
        this.BloActivityStatement6Binding.etElectorPopulationRationAtTimeOfPreviousRevisionPreview.setText(this.BloActivityStatement6Binding.etElectorPopulationRationAtTimeOfPreviousRevision.getText().toString());
        this.BloActivityStatement6Binding.etIncreaseDecreaseInElectorPopulationRatioPreview.setText(this.BloActivityStatement6Binding.etIncreaseDecreaseInElectorPopulationRatio.getText().toString());
        this.houseCount = this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHouses.getText().toString();
        this.buildingCount = this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildings.getText().toString();
        this.societyCount = this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocieties.getText().toString();
        this.BloActivityStatement6Binding.titleBar.setVisibility(8);
        this.BloActivityStatement6Binding.statement6CardView.setVisibility(8);
        this.BloActivityStatement6Binding.statement6FooterCardView.setVisibility(8);
        this.BloActivityStatement6Binding.titleBarPreview.setVisibility(0);
        this.BloActivityStatement6Binding.statement6PreviewCardView.setVisibility(0);
        this.BloActivityStatement6Binding.statement6PreviewFooterCardView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        this.BloActivityStatement6Binding.titleBar.setVisibility(0);
        this.BloActivityStatement6Binding.statement6CardView.setVisibility(0);
        this.BloActivityStatement6Binding.statement6FooterCardView.setVisibility(0);
        this.BloActivityStatement6Binding.titleBarPreview.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewCardView.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewFooterCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        this.BloActivityStatement6Binding.titleBar.setVisibility(0);
        this.BloActivityStatement6Binding.statement6CardView.setVisibility(0);
        this.BloActivityStatement6Binding.statement6FooterCardView.setVisibility(0);
        this.BloActivityStatement6Binding.titleBarPreview.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewCardView.setVisibility(8);
        this.BloActivityStatement6Binding.statement6PreviewFooterCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (isNetworkAvailable(this)) {
            showProgressVisible();
            submitStatement6Data();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getStatement6LastRevisionData() {
        Logger.d("getStatement6LastRevisionData() -> stateCode : ", this.stateCode);
        Logger.d("getStatement6LastRevisionData() -> partNo : ", this.partNo);
        Logger.d("getStatement6LastRevisionData() -> asmblyNO : ", this.asmblyNO);
        Logger.d("getStatement6LastRevisionData() -> token : ", this.token);
        HashMap map = new HashMap();
        map.put("Authorization", this.token);
        map.put("CurrentRole", this.currentRole);
        map.put("state", this.stateCode);
        map.put("Content-Type", this.applicationJsonText);
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("getStatement6LastRevisionData() -> getStatement6LastRevisionDataHeader : ", map.toString());
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getStatement6LastRevisionData(this.stateCode, this.asmblyNO, this.partNo, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.Statement6.1
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.e(Statement6.this.logTag, String.valueOf(response.body()));
                Logger.e(Statement6.this.logTag, "" + response.code());
                Logger.e(Statement6.this.logTag, "" + response.isSuccessful());
                if (response.code() == 200) {
                    Statement6.this.showProgressInVisible();
                    Logger.d(Statement6.this.logTag, "In getStatement6LastRevisionData() -> response body");
                    Logger.d(Statement6.this.logTag, "In getStatement6LastRevisionData() -> statusCode : " + ((JsonObject) response.body()).get(Statement6.this.statusCodeText));
                    Logger.d(Statement6.this.logTag, "In getStatement6LastRevisionData() -> message : " + ((JsonObject) response.body()).get(Statement6.this.messageText));
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray(Statement6.this.payloadText);
                        Logger.d("In getStatement6LastRevisionData() -> payload : ", "" + asJsonArray);
                        Statement6.this.houseCount = String.valueOf(asJsonArray.get(0).get(Statement6.this.houseText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.buildingCount = String.valueOf(asJsonArray.get(0).get(Statement6.this.buildingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.societyCount = String.valueOf(asJsonArray.get(0).get(Statement6.this.societyText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.crntTotalIncDescPopulation = String.valueOf(asJsonArray.get(0).get(Statement6.this.crntTotalIncDescPopulationText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.crntElecPopulationRatio = String.valueOf(asJsonArray.get(0).get(Statement6.this.crntElecPopulationRatioText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.crntElecIncDescPopulation = String.valueOf(asJsonArray.get(0).get(Statement6.this.crntElecIncDescPopulationText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.crntElecPrevPopulationRatio = String.valueOf(asJsonArray.get(0).get(Statement6.this.crntElecPrevPopulationRatioText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.crntRevisionNo = String.valueOf(asJsonArray.get(0).get(Statement6.this.crntRevisionNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("In getStatement6LastRevisionData() -> houseCount : ", Statement6.this.houseCount);
                        Logger.d("In getStatement6LastRevisionData() -> buildingCount : ", Statement6.this.buildingCount);
                        Logger.d("In getStatement6LastRevisionData() -> societyCount : ", Statement6.this.societyCount);
                        Logger.d("In getStatement6LastRevisionData() -> crntTotalIncDescPopulation : ", Statement6.this.crntTotalIncDescPopulation);
                        Logger.d("In getStatement6LastRevisionData() -> crntElecPopulationRatio : ", Statement6.this.crntElecPopulationRatio);
                        Logger.d("In getStatement6LastRevisionData() -> crntElecIncDescPopulation : ", Statement6.this.crntElecIncDescPopulation);
                        Logger.d("In getStatement6LastRevisionData() -> crntElecPrevPopulationRatio : ", Statement6.this.crntElecPrevPopulationRatio);
                        Logger.d("In getStatement6LastRevisionData() -> crntRevisionNo : ", Statement6.this.crntRevisionNo);
                        Statement6.this.BloActivityStatement6Binding.etNumberOfNewlyConstructedHouses.setText(Statement6.this.houseCount);
                        Statement6.this.BloActivityStatement6Binding.etNumberOfNewlyConstructedBuildings.setText(Statement6.this.buildingCount);
                        Statement6.this.BloActivityStatement6Binding.etNumberOfNewlyConstructedSocieties.setText(Statement6.this.societyCount);
                        return;
                    } catch (Exception e) {
                        Logger.e(Statement6.this.logTag, "In getStatement6LastRevisionData() -> Exception " + e.getMessage());
                        return;
                    }
                }
                if (response.code() == 401 || response.code() == 400) {
                    Statement6.this.refreshScreen();
                    return;
                }
                Statement6.this.showProgressInVisible();
                Logger.d(Statement6.this.logTag, "In getStatement6LastRevisionData() -> else part ----> Response Body is null ");
                try {
                    Logger.d(Statement6.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (Exception e2) {
                    Logger.d(Statement6.this.logTag, "getStatement6LastRevisionData : " + e2.getMessage());
                    Statement6.this.showSubmitAlertdialog(Statement6.this.alertText + response.code(), response.message());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Statement6.this.showProgressInVisible();
                Logger.d(Statement6.this.logTag, Statement6.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getStatement6CurrentRevisionData() {
        Logger.d("getStatement6CurrentRevisionData() -> stateCode : ", this.stateCode);
        Logger.d("getStatement6CurrentRevisionData() -> districtCode : ", this.districtCode);
        Logger.d("getStatement6CurrentRevisionData() -> partNo : ", this.partNo);
        Logger.d("getStatement6CurrentRevisionData() -> asmblyNO : ", this.asmblyNO);
        Logger.d("getStatement6CurrentRevisionData() -> token : ", this.token);
        HashMap map = new HashMap();
        map.put("Authorization", this.token);
        map.put("CurrentRole", this.currentRole);
        map.put("state", this.stateCode);
        map.put("Content-Type", this.applicationJsonText);
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("getStatement6CurrentRevisionData() -> getStatement6CurrentRevisionDataHeader : ", map.toString());
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getStatement6CurrentRevisionData(this.stateCode, this.districtCode, this.asmblyNO, this.partNo, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.Statement6.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.e(Statement6.this.logTag, String.valueOf(response.body()));
                Logger.e(Statement6.this.logTag, "" + response.code());
                Logger.e(Statement6.this.logTag, "" + response.isSuccessful());
                if (response.code() == 200) {
                    Statement6.this.showProgressInVisible();
                    Logger.d(Statement6.this.logTag, "In getStatement6CurrentRevisionData() -> response body");
                    Logger.d(Statement6.this.logTag, "In getStatement6CurrentRevisionData() -> statusCode : " + ((JsonObject) response.body()).get(Statement6.this.statusCodeText));
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray(Statement6.this.payloadText);
                        Logger.d("In getStatement6CurrentRevisionData() -> payload : ", "" + asJsonArray);
                        Statement6.this.currentYearPopulatuon = String.valueOf(asJsonArray.get(0).get("currentYearPopulatuon")).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.previousYearPopulatuon = String.valueOf(asJsonArray.get(0).get("previousYearPopulatuon")).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.currentRevisionElectors = String.valueOf(asJsonArray.get(0).get("currentRevisionElectors")).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Statement6.this.previousRevisionElectors = String.valueOf(asJsonArray.get(0).get("previousRevisionElectors")).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("In getStatement6CurrentRevisionData() -> currentYearPopulatuon : ", Statement6.this.currentYearPopulatuon);
                        Logger.d("In getStatement6CurrentRevisionData() -> previousYearPopulatuon : ", Statement6.this.previousYearPopulatuon);
                        Logger.d("In getStatement6CurrentRevisionData() -> currentRevisionElectors : ", Statement6.this.currentRevisionElectors);
                        Logger.d("In getStatement6CurrentRevisionData() -> previousRevisionElectors : ", Statement6.this.previousRevisionElectors);
                        if (Statement6.this.currentYearPopulatuon.equals(Statement6.this.textForZeroValue) || Statement6.this.previousYearPopulatuon.equals(Statement6.this.textForZeroValue)) {
                            Statement6.this.increaseDecreaseInTotalPopulationOfPartVillage = 0;
                            Statement6.this.electorPopulationRatioAtTimeOfCurrentRevision = Double.valueOf(0.0d);
                            Statement6.this.electorPopulationRationAtTimeOfPreviousRevision = Double.valueOf(0.0d);
                            Statement6.this.increaseDecreaseInElectorPopulationRatio = Double.valueOf(0.0d);
                        } else if (Statement6.this.currentRevisionElectors.equals(Statement6.this.textForZeroValue) || Statement6.this.previousRevisionElectors.equals(Statement6.this.textForZeroValue)) {
                            Statement6 statement6 = Statement6.this;
                            statement6.increaseDecreaseInTotalPopulationOfPartVillage = Integer.parseInt(statement6.currentYearPopulatuon) - Integer.parseInt(Statement6.this.previousYearPopulatuon);
                            Statement6 statement7 = Statement6.this;
                            statement7.electorPopulationRatioAtTimeOfCurrentRevision = Double.valueOf((Double.parseDouble(statement7.previousYearPopulatuon) / Double.parseDouble(Statement6.this.currentYearPopulatuon)) * 100.0d);
                            Statement6.this.electorPopulationRationAtTimeOfPreviousRevision = Double.valueOf(0.0d);
                            Statement6.this.increaseDecreaseInElectorPopulationRatio = Double.valueOf(0.0d);
                        } else {
                            Statement6 statement8 = Statement6.this;
                            statement8.increaseDecreaseInTotalPopulationOfPartVillage = Integer.parseInt(statement8.currentYearPopulatuon) - Integer.parseInt(Statement6.this.previousYearPopulatuon);
                            Statement6 statement9 = Statement6.this;
                            statement9.electorPopulationRatioAtTimeOfCurrentRevision = Double.valueOf((Double.parseDouble(statement9.previousYearPopulatuon) / Double.parseDouble(Statement6.this.currentYearPopulatuon)) * 100.0d);
                            Statement6 statement10 = Statement6.this;
                            statement10.electorPopulationRationAtTimeOfPreviousRevision = Double.valueOf((Double.parseDouble(statement10.currentRevisionElectors) / Double.parseDouble(Statement6.this.previousRevisionElectors)) * 100.0d);
                            Statement6 statement11 = Statement6.this;
                            statement11.increaseDecreaseInElectorPopulationRatio = Double.valueOf(statement11.electorPopulationRatioAtTimeOfCurrentRevision.doubleValue() - Statement6.this.electorPopulationRationAtTimeOfPreviousRevision.doubleValue());
                        }
                        Logger.d("In getStatement6CurrentRevisionData() -> increaseDecreaseInTotalPopulationOfPartVillage : ", String.valueOf(Statement6.this.increaseDecreaseInTotalPopulationOfPartVillage));
                        Logger.d("In getStatement6CurrentRevisionData() -> electorPopulationRatioAtTimeOfCurrentRevision : ", String.valueOf(Statement6.this.electorPopulationRatioAtTimeOfCurrentRevision));
                        Logger.d("In getStatement6CurrentRevisionData() -> electorPopulationRationAtTimeOfPreviousRevision : ", String.valueOf(Statement6.this.electorPopulationRationAtTimeOfPreviousRevision));
                        Logger.d("In getStatement6CurrentRevisionData() -> increaseDecreaseInElectorPopulationRatio : ", String.valueOf(Statement6.this.increaseDecreaseInElectorPopulationRatio));
                        Statement6.this.BloActivityStatement6Binding.etIncreaseDecreaseInTotalPopulationOfPartVillage.setText(String.valueOf(Statement6.this.increaseDecreaseInTotalPopulationOfPartVillage));
                        Statement6.this.BloActivityStatement6Binding.etElectorPopulationRatioAtTimeOfCurrentRevision.setText(String.format("%.2f", Statement6.this.electorPopulationRatioAtTimeOfCurrentRevision) + " %");
                        Statement6.this.BloActivityStatement6Binding.etElectorPopulationRationAtTimeOfPreviousRevision.setText(String.format("%.2f", Statement6.this.electorPopulationRationAtTimeOfPreviousRevision) + " %");
                        Statement6.this.BloActivityStatement6Binding.etIncreaseDecreaseInElectorPopulationRatio.setText(String.format("%.2f", Statement6.this.increaseDecreaseInElectorPopulationRatio) + " %");
                        return;
                    } catch (Exception e) {
                        Logger.e(Statement6.this.logTag, "In getStatement6CurrentRevisionData() -> Exception " + e.getMessage());
                        return;
                    }
                }
                if (response.code() == 401 || response.code() == 400) {
                    Statement6.this.refreshScreen();
                    return;
                }
                Statement6.this.showProgressInVisible();
                Logger.d(Statement6.this.logTag, "In getStatement6CurrentRevisionData() -> else part ----> Response Body is null ");
                try {
                    Logger.d(Statement6.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (Exception e2) {
                    Logger.d(Statement6.this.logTag, "getStatement6CurrentRevisionData : " + e2.getMessage());
                    Statement6.this.showSubmitAlertdialog(Statement6.this.alertText + response.code(), response.message());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Statement6.this.showProgressInVisible();
                Logger.d(Statement6.this.logTag, Statement6.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submitStatement6Data() {
        HashMap map = new HashMap();
        Logger.d("submitStatement6Data() -> stateCd : ", this.stateCode);
        Logger.d("submitStatement6Data() -> districtCode : ", this.districtCode);
        Logger.d("submitStatement6Data() -> asmblyNO : ", this.asmblyNO);
        Logger.d("submitStatement6Data() -> partNo : ", this.partNo);
        Logger.d("submitStatement6Data() -> houseCount : ", this.houseCount);
        Logger.d("submitStatement6Data() -> buildingCount : ", this.buildingCount);
        Logger.d("submitStatement6Data() -> societyCount : ", this.societyCount);
        Logger.d("submitStatement6Data() -> crntTotalIncDescPopulation : ", this.crntTotalIncDescPopulation);
        Logger.d("submitStatement6Data() -> crntElecPopulationRatio : ", this.crntElecPopulationRatio);
        Logger.d("submitStatement6Data() -> crntElecPrevPopulationRatio : ", this.crntElecPrevPopulationRatio);
        Logger.d("submitStatement6Data() -> crntElecIncDescPopulation : ", this.crntElecIncDescPopulation);
        map.put(this.stateCdText, this.stateCode);
        map.put(this.districtCdText, this.districtCode);
        map.put(this.acNoText, Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        map.put(this.partNoText, Integer.valueOf(Integer.parseInt(this.partNo)));
        map.put(this.houseText, Integer.valueOf(Integer.parseInt(this.houseCount)));
        map.put(this.buildingText, Integer.valueOf(Integer.parseInt(this.buildingCount)));
        map.put(this.societyText, Integer.valueOf(Integer.parseInt(this.societyCount)));
        map.put(this.crntTotalIncDescPopulationText, Integer.valueOf(Integer.parseInt(this.crntTotalIncDescPopulation)));
        map.put(this.crntElecPopulationRatioText, Integer.valueOf(Integer.parseInt(this.crntElecPopulationRatio)));
        map.put(this.crntElecPrevPopulationRatioText, Integer.valueOf(Integer.parseInt(this.crntElecPrevPopulationRatio)));
        map.put(this.crntElecIncDescPopulationText, Integer.valueOf(Integer.parseInt(this.crntElecIncDescPopulation)));
        Logger.d("submitStatement6Data() -> submitStatement6Map : ", String.valueOf(map));
        HashMap map2 = new HashMap();
        map2.put("Authorization", this.token);
        map2.put("CurrentRole", this.currentRole);
        map2.put("state", this.stateCode);
        map2.put("Content-Type", this.applicationJsonText);
        map2.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map2.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map2.put("channelidobo", "BLOAPP");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("submitStatement6Data() -> submitStatement6DataHeader : ", map2.toString());
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).submitStatement6Data(map2, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.Statement6.3
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.d("submitStatement6Data -> code : ", "" + response.code());
                if (response.code() == 200) {
                    Statement6.this.showProgressInVisible();
                    Logger.d(Statement6.this.logTag, "In submitStatement6Data() -> response body");
                    Logger.d(Statement6.this.logTag, "In submitStatement6Data() -> statusCode : " + ((JsonObject) response.body()).get(Statement6.this.statusCodeText));
                    Logger.d(Statement6.this.logTag, "In submitStatement6Data() -> message : " + ((JsonObject) response.body()).get(Statement6.this.messageText));
                    Statement6.this.showSubmitAlertdialog("Success", "Data Updated Successfully.");
                    return;
                }
                if (response.code() == 401 || response.code() == 400) {
                    Statement6.this.refreshScreen();
                    return;
                }
                Statement6.this.showProgressInVisible();
                Logger.d(Statement6.this.logTag, "In submitStatement6Data() -> else part ----> Response Body is null");
                try {
                    Logger.d(Statement6.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (Exception e) {
                    Logger.d(Statement6.this.logTag, e.getMessage());
                    Statement6.this.showSubmitAlertdialog(Statement6.this.alertText + response.code(), response.message());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Statement6.this.showProgressInVisible();
                Logger.d("In submitStatement6Data() -> ON failure", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void refreshScreen() {
        this.commonUtilClass.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshScreen$10(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshScreen$10(int i, final String str, final String str2) {
        Logger.d(this.logTag, this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(this, this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshScreen$8(dialogInterface, i2);
                }
            });
        } else {
            this.commonUtilClass.showMessageOK(this, this.sessionExpiredTextForRefresh, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshScreen$9(str, str2, dialogInterface, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshScreen$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshScreen$9(String str, String str2, DialogInterface dialogInterface, int i) {
        this.token = this.bearerText + str;
        this.refreshToken = str2;
        SharedPref.getInstance(this).setRefreshToken(str2);
        SharedPref.getInstance(this).setToken(this.bearerText + str);
        startActivity(new Intent((Context) this, (Class<?>) Statement6.class));
    }

    public static Dialog showProgressDialog(Context context) {
        BloProgressLayoutBinding bloProgressLayoutBindingInflate = BloProgressLayoutBinding.inflate(LayoutInflater.from(context));
        Dialog dialog = new Dialog(context, 2132017708);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(bloProgressLayoutBindingInflate.getRoot());
        dialog.setCancelable(false);
        return dialog;
    }

    public void showProgressVisible() {
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void showProgressInVisible() {
        Dialog dialog = this.progressDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showAlertdialog(String title, String msg) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showSubmitAlertdialog(String title, String msg) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement6$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showSubmitAlertdialog$12(dialogInterface, i);
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSubmitAlertdialog$12(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        finish();
    }
}
