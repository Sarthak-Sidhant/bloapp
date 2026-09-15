package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloActivityStatement4Binding;
import in.gov.eci.bloapp.databinding.BloProgressLayoutBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Statement4 extends BaseActivity {
    BloActivityStatement4Binding BloActivityStatement4Binding;
    String asmblyNO;
    String asmblyName;
    Retrofit.Builder builder;
    String districtCode;
    String districtName;
    String partName;
    String partNo;
    Dialog progressDialog;
    String refreshToken;
    Retrofit retrofit;
    String stateCode;
    String stateName;
    String token;
    CommomUtility commonUtilClass = new CommomUtility();
    String logTag = "Statement4";
    String sectionNo = "";
    String houseNo = "";
    String id = "0";
    String alertText = "Alert";
    String maleCount = "0";
    String femaleCount = "0";
    String thirdGenderCount = "0";
    String malePWDCount = "0";
    String femalePWDCount = "0";
    String thirdGenderPWDCount = "0";
    int totalPersonsLivingInTheHouse = 0;
    int totalPwDLivingInTheHouse = 0;
    String stateCdText = "stateCd";
    String acNoText = "acNo";
    String partNoText = "partNo";
    String sectionNoText = "sectionNo";
    String houseNoText = "houseNo";
    String housenoText = "houseno";
    String statusCodeText = "statusCode";
    String messageText = "message";
    String textForZeroValue = "0";
    String districtCdText = "districtCd";
    String idText = "id";
    String currentRole = "blo";
    String maleText = "male";
    String femaleText = "female";
    String thirdGenderText = "thirdGender";
    String malePwdText = "malePwd";
    String femalePwdText = "femalePwd";
    String thirdGenderPwdText = "thirdGenderPwd";
    String sessionExpiredText = "Session Expired. Please Login again..";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String nullText = "null";
    String okText = "Ok";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public Statement4() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityStatement4Binding bloActivityStatement4BindingInflate = BloActivityStatement4Binding.inflate(getLayoutInflater());
        this.BloActivityStatement4Binding = bloActivityStatement4BindingInflate;
        setContentView((View) bloActivityStatement4BindingInflate.getRoot());
        this.BloActivityStatement4Binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.BloActivityStatement4Binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
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
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.houseNo = extras.getString(this.housenoText);
            this.sectionNo = extras.getString(this.sectionNoText);
            Logger.d(this.logTag, "houseNo from HouseList -- > " + this.houseNo);
            Logger.d(this.logTag, "sectionNo from HouseList -- > " + this.sectionNo);
        }
        if (this.progressDialog == null) {
            this.progressDialog = showProgressDialog(this);
        }
        this.BloActivityStatement4Binding.statement4PartNoName.setText(String.format(getString(R.string.blo_part_Population), new Object[0]) + " (" + this.partNo + " - " + this.partName + ") ");
        if (isNetworkAvailable(this)) {
            showProgressVisible();
            getStatement4Data();
        }
        this.BloActivityStatement4Binding.etTotalMaleInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPersonsLivingInTheHouse -= Integer.parseInt(Statement4.this.maleCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.maleCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.setText(Statement4.this.maleCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.maleCount = statement5.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString();
                }
                Statement4.this.totalPersonsLivingInTheHouse += Integer.parseInt(Statement4.this.maleCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPersonsLivingInTheHouse -= Integer.parseInt(Statement4.this.femaleCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.femaleCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.setText(Statement4.this.femaleCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.femaleCount = statement5.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString();
                }
                Statement4.this.totalPersonsLivingInTheHouse += Integer.parseInt(Statement4.this.femaleCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPersonsLivingInTheHouse -= Integer.parseInt(Statement4.this.thirdGenderCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.thirdGenderCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.setText(Statement4.this.thirdGenderCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.thirdGenderCount = statement5.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString();
                }
                Statement4.this.totalPersonsLivingInTheHouse += Integer.parseInt(Statement4.this.thirdGenderCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPersonsLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPwDLivingInTheHouse -= Integer.parseInt(Statement4.this.malePWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.malePWDCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.setText(Statement4.this.malePWDCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.malePWDCount = statement5.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString();
                }
                Statement4.this.totalPwDLivingInTheHouse += Integer.parseInt(Statement4.this.malePWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPwDLivingInTheHouse -= Integer.parseInt(Statement4.this.femalePWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.femalePWDCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.setText(Statement4.this.femalePWDCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.femalePWDCount = statement5.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString();
                }
                Statement4.this.totalPwDLivingInTheHouse += Integer.parseInt(Statement4.this.femalePWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.Statement4.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString() == null && Statement4.this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("")) {
                    return;
                }
                Statement4.this.totalPwDLivingInTheHouse -= Integer.parseInt(Statement4.this.thirdGenderPWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (Statement4.this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString() == null || Statement4.this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString().isEmpty()) {
                    Statement4 statement4 = Statement4.this;
                    statement4.thirdGenderPWDCount = statement4.textForZeroValue;
                    Statement4.this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.setText(Statement4.this.thirdGenderPWDCount);
                } else {
                    Statement4 statement5 = Statement4.this;
                    statement5.thirdGenderPWDCount = statement5.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString();
                }
                Statement4.this.totalPwDLivingInTheHouse += Integer.parseInt(Statement4.this.thirdGenderPWDCount);
                Statement4.this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(Statement4.this.totalPwDLivingInTheHouse));
            }
        });
        this.BloActivityStatement4Binding.resetButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.BloActivityStatement4Binding.submitButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
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
        if (isNetworkAvailable(this)) {
            showProgressVisible();
            getStatement4Data();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (isNetworkAvailable(this)) {
            if (this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Male Count");
                return;
            }
            if (this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Female Count");
                return;
            }
            if (this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Third Gender Count");
                return;
            }
            if (this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Male PWD Count");
                return;
            }
            if (this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Female PWD Count");
                return;
            }
            if (this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString() == null || this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString().equals("") || this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString().equals(this.nullText)) {
                showCountAlertdialog1(this.alertText, "Enter Third Gender PWD Count");
                return;
            }
            if (Integer.parseInt(this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.getText().toString()) > Integer.parseInt(this.BloActivityStatement4Binding.etTotalMaleInTheHouse.getText().toString()) || Integer.parseInt(this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.getText().toString()) > Integer.parseInt(this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.getText().toString()) || Integer.parseInt(this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.getText().toString()) > Integer.parseInt(this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.getText().toString())) {
                showCountAlertdialog1(this.alertText, "PWD Count can not be greater than gender count.");
                return;
            }
            int i = this.totalPersonsLivingInTheHouse;
            if (i > 9 && this.totalPwDLivingInTheHouse <= 9) {
                showCountAlertdialog(this.alertText, "Do you want to confirm this gender count ?");
                return;
            }
            if (i <= 9 && this.totalPwDLivingInTheHouse > 9) {
                showCountAlertdialog(this.alertText, "Do you want to confirm this pwd count ?");
            } else if (i > 9 && this.totalPwDLivingInTheHouse > 9) {
                showCountAlertdialog(this.alertText, "Do you want to confirm this gender and pwd count ?");
            } else {
                showProgressVisible();
                submitStatement4Data();
            }
        }
    }

    public void setHouseData() {
        this.BloActivityStatement4Binding.etTotalMaleInTheHouse.setText(this.maleCount);
        this.BloActivityStatement4Binding.etTotalFemaleInTheHouse.setText(this.femaleCount);
        this.BloActivityStatement4Binding.etTotalThirdGInTheHouse.setText(this.thirdGenderCount);
        this.BloActivityStatement4Binding.etTotalMalePwDInTheHouse.setText(this.malePWDCount);
        this.BloActivityStatement4Binding.etTotalFemalePwDInTheHouse.setText(this.femalePWDCount);
        this.BloActivityStatement4Binding.etTotalThirdGPwDInTheHouse.setText(this.thirdGenderPWDCount);
        this.totalPersonsLivingInTheHouse = 0;
        this.totalPersonsLivingInTheHouse = Integer.parseInt(this.maleCount) + Integer.parseInt(this.femaleCount) + Integer.parseInt(this.thirdGenderCount);
        this.BloActivityStatement4Binding.etTotalPersonsLivingInTheHouse.setText(String.valueOf(this.totalPersonsLivingInTheHouse));
        this.totalPwDLivingInTheHouse = 0;
        this.totalPwDLivingInTheHouse = Integer.parseInt(this.malePWDCount) + Integer.parseInt(this.femalePWDCount) + Integer.parseInt(this.thirdGenderPWDCount);
        this.BloActivityStatement4Binding.etTotalPwDLivingInTheHouse.setText(String.valueOf(this.totalPwDLivingInTheHouse));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getStatement4Data() {
        HashMap map = new HashMap();
        Logger.d("getStatement4Data() -> stateCode : ", this.stateCode);
        Logger.d("getStatement4Data() -> asmblyNO : ", this.asmblyNO);
        Logger.d("getStatement4Data() -> partNo : ", this.partNo);
        Logger.d("getStatement4Data() -> sectionNo : ", this.sectionNo);
        Logger.d("getStatement4Data() -> houseNo : ", this.houseNo);
        map.put(this.stateCdText, this.stateCode);
        map.put(this.acNoText, Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        map.put(this.partNoText, Integer.valueOf(Integer.parseInt(this.partNo)));
        map.put(this.sectionNoText, Integer.valueOf(Integer.parseInt(this.sectionNo)));
        map.put(this.houseNoText, this.houseNo);
        Logger.d("getStatement4Data() -> getStatement4Map : ", String.valueOf(map));
        HashMap map2 = new HashMap();
        map2.put("Authorization", this.token);
        map2.put("currentRole", this.currentRole);
        map2.put("state", this.stateCode);
        map2.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map2.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map2.put("channelidobo", "BLOAPP");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("getStatement4Data() -> getStatement4Header : ", map2.toString());
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getStatement4Data(map2, map).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.Statement4$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.Statement4] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("getStatement4Data -> code : ", "" + response.code());
            if (response.code() == 200) {
                Statement4.this.showProgressInVisible();
                Logger.d(Statement4.this.logTag, "In getStatement4Data() -> response body");
                Logger.d(Statement4.this.logTag, "In getStatement4Data() -> statusCode : " + ((JsonObject) response.body()).get(Statement4.this.statusCodeText));
                Logger.d(Statement4.this.logTag, "In getStatement4Data() -> message : " + ((JsonObject) response.body()).get(Statement4.this.messageText));
                String strValueOf = String.valueOf(((JsonObject) response.body()).get(Statement4.this.messageText));
                try {
                    if (!strValueOf.equals("No data found") && !strValueOf.equals("no data found") && !strValueOf.equals("No Data Found")) {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                        Logger.d("In getStatement4Data() -> payload : ", "" + asJsonArray);
                        if (asJsonArray.get(0).get(Statement4.this.stateCdText) != null) {
                            Statement4.this.stateCode = String.valueOf(asJsonArray.get(0).get(Statement4.this.stateCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.districtCdText) != null) {
                            Statement4.this.districtCode = String.valueOf(asJsonArray.get(0).get(Statement4.this.districtCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.acNoText) != null) {
                            Statement4.this.asmblyNO = String.valueOf(asJsonArray.get(0).get(Statement4.this.acNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.idText) != null) {
                            Statement4.this.id = String.valueOf(asJsonArray.get(0).get(Statement4.this.idText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.partNoText) != null) {
                            Statement4.this.partNo = String.valueOf(asJsonArray.get(0).get(Statement4.this.partNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.sectionNoText) != null) {
                            Statement4.this.sectionNo = String.valueOf(asJsonArray.get(0).get(Statement4.this.sectionNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.houseNoText) != null) {
                            Statement4.this.houseNo = String.valueOf(asJsonArray.get(0).get(Statement4.this.houseNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.maleText) != null) {
                            Statement4.this.maleCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.maleText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.femaleText) != null) {
                            Statement4.this.femaleCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.femaleText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.thirdGenderText) != null) {
                            Statement4.this.thirdGenderCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.thirdGenderText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.malePwdText) != null) {
                            Statement4.this.malePWDCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.malePwdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.femalePwdText) != null) {
                            Statement4.this.femalePWDCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.femalePwdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (asJsonArray.get(0).get(Statement4.this.thirdGenderPwdText) != null) {
                            Statement4.this.thirdGenderPWDCount = String.valueOf(asJsonArray.get(0).get(Statement4.this.thirdGenderPwdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        Statement4.this.setHouseData();
                        return;
                    }
                    Statement4 statement4 = Statement4.this;
                    statement4.maleCount = statement4.textForZeroValue;
                    Statement4 statement5 = Statement4.this;
                    statement5.femaleCount = statement5.textForZeroValue;
                    Statement4 statement6 = Statement4.this;
                    statement6.thirdGenderCount = statement6.textForZeroValue;
                    Statement4 statement7 = Statement4.this;
                    statement7.malePWDCount = statement7.textForZeroValue;
                    Statement4 statement8 = Statement4.this;
                    statement8.femalePWDCount = statement8.textForZeroValue;
                    Statement4 statement9 = Statement4.this;
                    statement9.thirdGenderPWDCount = statement9.textForZeroValue;
                    Statement4.this.setHouseData();
                    return;
                } catch (Exception e) {
                    Logger.e(Statement4.this.logTag, "In getStatement4Data() -> Exception " + e.getMessage());
                    return;
                }
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = Statement4.this.commonUtilClass;
                ?? r7 = Statement4.this;
                commomUtility.getRefreshToken(r7, r7.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.Statement4$7$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            Statement4.this.showProgressInVisible();
            Logger.d(Statement4.this.logTag, "In getStatement4Data() -> else part ----> Response Body is null");
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(Statement4.this.messageText);
                Statement4 statement10 = Statement4.this;
                statement10.showSubmitAlertdialog(statement10.alertText, strOptString);
                Logger.d(Statement4.this.logTag, strOptString);
            } catch (Exception e2) {
                Logger.d(Statement4.this.logTag, e2.getMessage());
                Statement4.this.showSubmitAlertdialog(Statement4.this.alertText + response.code(), response.message());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.Statement4] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Logger.d(Statement4.this.logTag, Statement4.this.getRefreshTokenText + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = Statement4.this.commonUtilClass;
                ?? r5 = Statement4.this;
                commomUtility.showMessageOK(r5, r5.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                Statement4.this.token = Statement4.this.bearerText + str;
                Statement4.this.refreshToken = str2;
                SharedPref.getInstance(Statement4.this).setRefreshToken(str2);
                SharedPref.getInstance(Statement4.this).setToken(Statement4.this.bearerText + str);
                Statement4.this.getStatement4Data();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement4.this).setIsLoggedIn(false);
            SharedPref.getInstance(Statement4.this).setLocaleBool(false);
            Statement4.this.startActivity(new Intent((Context) Statement4.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Statement4.this.showProgressInVisible();
            Logger.d("In getStatement4Data() -> ON failure", t.getMessage());
            Statement4 statement4 = Statement4.this;
            statement4.showSubmitAlertdialog(statement4.alertText, t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submitStatement4Data() {
        HashMap map = new HashMap();
        try {
            Logger.d("submitStatement4Data() -> stateCd : ", this.stateCode);
            Logger.d("submitStatement4Data() -> districtCode : ", this.districtCode);
            Logger.d("submitStatement4Data() -> asmblyNO : ", this.asmblyNO);
            String str = this.id;
            if (str != null) {
                Logger.d("submitStatement4Data() -> id : ", str);
            }
            Logger.d("submitStatement4Data() -> partNo : ", this.partNo);
            Logger.d("submitStatement4Data() -> sectionNo : ", this.sectionNo);
            Logger.d("submitStatement4Data() -> houseNo : ", this.houseNo);
            Logger.d("submitStatement4Data() -> maleCount : ", this.maleCount);
            Logger.d("submitStatement4Data() -> femaleCount : ", this.femaleCount);
            Logger.d("submitStatement4Data() -> thirdGenderCount : ", this.thirdGenderCount);
            Logger.d("submitStatement4Data() -> malePWDCount : ", this.malePWDCount);
            Logger.d("submitStatement4Data() -> femalePWDCount : ", this.femalePWDCount);
            Logger.d("submitStatement4Data() -> thirdGenderPWDCount : ", this.thirdGenderPWDCount);
            String str2 = this.id;
            if (str2 == null || str2.equals(this.nullText) || this.id.equals(this.textForZeroValue) || this.id.equals("")) {
                map.put(this.stateCdText, this.stateCode);
                map.put(this.districtCdText, this.districtCode);
                map.put(this.acNoText, Integer.valueOf(Integer.parseInt(this.asmblyNO)));
                map.put(this.partNoText, Integer.valueOf(Integer.parseInt(this.partNo)));
                map.put(this.sectionNoText, Integer.valueOf(Integer.parseInt(this.sectionNo)));
                map.put(this.houseNoText, this.houseNo);
                map.put(this.maleText, Integer.valueOf(Integer.parseInt(this.maleCount)));
                map.put(this.femaleText, Integer.valueOf(Integer.parseInt(this.femaleCount)));
                map.put(this.thirdGenderText, Integer.valueOf(Integer.parseInt(this.thirdGenderCount)));
                map.put(this.malePwdText, Integer.valueOf(Integer.parseInt(this.malePWDCount)));
                map.put(this.femalePwdText, Integer.valueOf(Integer.parseInt(this.femalePWDCount)));
                map.put(this.thirdGenderPwdText, Integer.valueOf(Integer.parseInt(this.thirdGenderPWDCount)));
            } else {
                map.put(this.stateCdText, this.stateCode);
                map.put(this.districtCdText, this.districtCode);
                map.put(this.acNoText, Integer.valueOf(Integer.parseInt(this.asmblyNO)));
                map.put(this.idText, Integer.valueOf(Integer.parseInt(this.id)));
                map.put(this.partNoText, Integer.valueOf(Integer.parseInt(this.partNo)));
                map.put(this.sectionNoText, Integer.valueOf(Integer.parseInt(this.sectionNo)));
                map.put(this.houseNoText, this.houseNo);
                map.put(this.maleText, Integer.valueOf(Integer.parseInt(this.maleCount)));
                map.put(this.femaleText, Integer.valueOf(Integer.parseInt(this.femaleCount)));
                map.put(this.thirdGenderText, Integer.valueOf(Integer.parseInt(this.thirdGenderCount)));
                map.put(this.malePwdText, Integer.valueOf(Integer.parseInt(this.malePWDCount)));
                map.put(this.femalePwdText, Integer.valueOf(Integer.parseInt(this.femalePWDCount)));
                map.put(this.thirdGenderPwdText, Integer.valueOf(Integer.parseInt(this.thirdGenderPWDCount)));
            }
            Logger.d("submitStatement4Data() -> submitStatement4Map : ", String.valueOf(map));
            HashMap map2 = new HashMap();
            map2.put("Authorization", this.token);
            map2.put("currentRole", this.currentRole);
            map2.put("state", this.stateCode);
            map2.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
            map2.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
            map2.put("channelidobo", "BLOAPP");
            map2.put("PLATFORM-TYPE", "ANDROIDMOB");
            Logger.d("submitStatement4Data() -> submitStatement4Header : ", map2.toString());
            this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).submitStatement4Data(map2, map).enqueue(new AnonymousClass8());
        } catch (Exception e) {
            showProgressInVisible();
            Logger.d("submitStatement4Data() -> Catch Block --> Exception : ", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.Statement4$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        AnonymousClass8() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.Statement4] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("submitStatement4Data -> code : ", "" + response.code());
            if (response.code() == 200) {
                Statement4.this.showProgressInVisible();
                Logger.d(Statement4.this.logTag, "In submitStatement4Data() -> response body");
                Logger.d(Statement4.this.logTag, "In submitStatement4Data() -> statusCode : " + ((JsonObject) response.body()).get(Statement4.this.statusCodeText));
                Logger.d(Statement4.this.logTag, "In submitStatement4Data() -> message : " + ((JsonObject) response.body()).get(Statement4.this.messageText));
                Statement4.this.showSubmitAlertdialog("Success", "Data Updated Successfully.");
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = Statement4.this.commonUtilClass;
                ?? r5 = Statement4.this;
                commomUtility.getRefreshToken(r5, r5.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.Statement4$8$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            Statement4.this.showProgressInVisible();
            Logger.d(Statement4.this.logTag, "In submitStatement4Data() -> else part ----> Response Body is null");
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(Statement4.this.messageText);
                Statement4 statement4 = Statement4.this;
                statement4.showSubmitAlertdialog(statement4.alertText, strOptString);
                Logger.d(Statement4.this.logTag, strOptString);
            } catch (Exception e) {
                Logger.d(Statement4.this.logTag, e.getMessage());
                Statement4.this.showSubmitAlertdialog(Statement4.this.alertText + response.code(), response.message());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.Statement4] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Logger.d(Statement4.this.logTag, Statement4.this.getRefreshTokenText + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = Statement4.this.commonUtilClass;
                ?? r5 = Statement4.this;
                commomUtility.showMessageOK(r5, r5.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                Statement4.this.token = Statement4.this.bearerText + str;
                Statement4.this.refreshToken = str2;
                SharedPref.getInstance(Statement4.this).setRefreshToken(str2);
                SharedPref.getInstance(Statement4.this).setToken(Statement4.this.bearerText + str);
                Statement4.this.submitStatement4Data();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement4.this).setIsLoggedIn(false);
            SharedPref.getInstance(Statement4.this).setLocaleBool(false);
            Statement4.this.startActivity(new Intent((Context) Statement4.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Statement4.this.showProgressInVisible();
            Logger.d("In submitStatement4Data() -> ON failure", t.getMessage());
            Statement4 statement4 = Statement4.this;
            statement4.showSubmitAlertdialog(statement4.alertText, t.getMessage());
        }
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
    private void showCountAlertdialog(String title, String msg) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showCountAlertdialog$4(dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showCountAlertdialog$5(dialogInterface, i);
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCountAlertdialog$4(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        showProgressVisible();
        submitStatement4Data();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCountAlertdialog$5(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        showProgressVisible();
        getStatement4Data();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showCountAlertdialog1(String title, String msg) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda0
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
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.Statement4$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showSubmitAlertdialog$7(dialogInterface, i);
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSubmitAlertdialog$7(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        finish();
    }
}
