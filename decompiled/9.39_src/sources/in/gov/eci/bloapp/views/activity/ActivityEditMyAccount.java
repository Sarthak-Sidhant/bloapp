package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.databinding.BloActivityEditMyAccountBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ActivityEditMyAccount extends Hilt_ActivityEditMyAccount {
    String asmblyName;
    BloActivityEditMyAccountBinding binding;
    String districtName;
    String email;
    String fName;
    String lName;
    String name;
    String partName;
    String phoneNumber;
    String refreshToken;
    String stateCode;
    String stateName;
    String token;
    String totalPartNumber;
    String userName;
    MyDetailsViewModel viewModel;
    CommomUtility commonUtils = new CommomUtility();
    String alertTag = "Alert";
    HashMap<String, Object> json = new HashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        this.binding = BloActivityEditMyAccountBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        this.viewModel = (MyDetailsViewModel) new ViewModelProvider(this).get(MyDetailsViewModel.class);
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.token = SharedPref.getInstance(this).getToken();
        this.userName = SharedPref.getInstance(this).getUserName();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.fName = intent.getStringExtra("fName");
        this.lName = intent.getStringExtra("lName");
        this.name = this.fName + " " + this.lName;
        this.phoneNumber = intent.getStringExtra("MobileNumber");
        this.totalPartNumber = SharedPref.getInstance(this).getTotalPartNumber();
        if (!Objects.equals(intent.getStringExtra("Email"), "")) {
            this.email = intent.getStringExtra("Email");
        } else {
            this.email = "";
        }
        this.stateName = intent.getStringExtra("State");
        this.districtName = intent.getStringExtra("District");
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partName = intent.getStringExtra("officeAddress");
        this.binding.firstName.setLongClickable(false);
        this.binding.firstName.setTextIsSelectable(false);
        this.binding.mobileNumber.setLongClickable(false);
        this.binding.mobileNumber.setTextIsSelectable(false);
        this.binding.emailId.setLongClickable(false);
        this.binding.emailId.setTextIsSelectable(false);
        this.binding.officeAddress.setLongClickable(false);
        this.binding.officeAddress.setTextIsSelectable(false);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        Logger.d("USER_DETAILS", "Name --------> " + this.fName + this.lName);
        getBlo();
        getDate();
        Logger.d("USER_DETAILS", "Part Number  --------> " + this.totalPartNumber);
        String[] strArrSplit = this.totalPartNumber.replace(RegexMatcher.JSON_STRING_REGEX, " ").replace("[", "").replace("]", "").replace(" ", "").split(",");
        Logger.d("N value", String.valueOf(strArrSplit.length));
        for (String str : strArrSplit) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 7, 15, 0);
            TextView textView = new TextView(this);
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.blo_testsquare1);
            textView.setPadding(20, 20, 20, 20);
            this.binding.test6.addView(textView);
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.sendForApproval.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (test()) {
            this.json.put("oldBoSignatureDln", null);
            this.json.put("boSignatureDln", null);
            this.json.put("oldAlternateLandlineNumber", null);
            this.json.put("oldDesignation", "BLO");
            this.json.put("oldLandlineNumber", null);
            this.json.put("oldPin", null);
            this.json.put("alternateLandlineNumber", null);
            this.json.put("createdDttm", null);
            this.json.put("designation", "BLO");
            this.json.put("pin", null);
            this.json.put("currentStatusId", "20025");
            this.json.put("processMasterId", "20009");
            this.json.put("landlineNumber", null);
            String str = this.partName;
            if (str == null || str.isEmpty()) {
                this.json.put("oldAddress", null);
            } else {
                this.json.put("oldAddress", this.partName);
            }
            String str2 = this.email;
            if (str2 == null || str2.isEmpty()) {
                this.json.put("oldEmail", null);
            } else {
                this.json.put("oldEmail", this.email);
            }
            String str3 = this.phoneNumber;
            if (str3 == null || str3.isEmpty()) {
                this.json.put("oldMobileNumber", null);
            } else {
                this.json.put("oldMobileNumber", this.phoneNumber);
            }
            String str4 = this.fName;
            if (str4 == null || str4.isEmpty()) {
                this.json.put("oldUserFname", null);
            } else {
                this.json.put("oldUserFname", this.fName);
            }
            String str5 = this.lName;
            if (str5 == null || str5.isEmpty()) {
                this.json.put("oldUserLname", null);
            } else {
                this.json.put("oldUserLname", this.lName);
            }
            if (this.binding.officeAddress.getText().toString().isEmpty()) {
                this.json.put("address", null);
            } else {
                this.json.put("address", this.binding.officeAddress.getText().toString().replace("'", ""));
            }
            if (this.binding.emailId.getText().toString().isEmpty()) {
                this.json.put("email", null);
            } else {
                this.json.put("email", this.binding.emailId.getText().toString());
            }
            String str6 = this.userName;
            if (str6 == null || str6.isEmpty()) {
                this.json.put("loginName", null);
            } else {
                this.json.put("loginName", this.userName);
            }
            if (this.binding.mobileNumber.getText().toString().isEmpty()) {
                this.json.put("mobileNumber", null);
            } else {
                this.json.put("mobileNumber", this.binding.mobileNumber.getText().toString());
            }
            String str7 = this.stateCode;
            if (str7 == null || str7.isEmpty()) {
                this.json.put("stateCd", null);
            } else {
                this.json.put("stateCd", this.stateCode);
            }
            int iLastIndexOf = this.binding.firstName.getText().toString().trim().lastIndexOf(32);
            System.out.println("Hii iam space pos " + iLastIndexOf);
            if (iLastIndexOf == -1) {
                this.json.put("userFname", this.binding.firstName.getText().toString().trim());
                this.json.put("userLname", null);
            } else {
                this.json.put("userFname", this.binding.firstName.getText().toString().trim().substring(0, iLastIndexOf));
                this.json.put("userLname", this.binding.firstName.getText().toString().trim().substring(iLastIndexOf + 1));
            }
            String string = new JSONObject(this.json).toString();
            getBlo1(this.json);
            Logger.e("edit my profile", "hii i am map" + string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getBlo1(HashMap<String, Object> json) {
        ((RestClient) ApiClient.getClient(this).create(RestClient.class)).updateMyProfile(this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", this.stateCode, json).enqueue(new AnonymousClass1(json));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ HashMap val$json;

        AnonymousClass1(final HashMap val$json) {
            this.val$json = val$json;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ActivityEditMyAccount] */
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
            if (response.code() == 200) {
                System.out.println("hii i am map1");
                Intent intent = new Intent((Context) ActivityEditMyAccount.this, (Class<?>) ActivitySendForApproval.class);
                intent.putExtra("oldPhoneNumber", ActivityEditMyAccount.this.phoneNumber);
                intent.putExtra("newPhoneNumber", ActivityEditMyAccount.this.binding.mobileNumber.getText().toString());
                ActivityEditMyAccount.this.startActivity(intent);
                ActivityEditMyAccount.this.finish();
                return;
            }
            if (response.code() == 401) {
                System.out.println("hii i am 401");
                CommomUtility commomUtility = ActivityEditMyAccount.this.commonUtils;
                ?? r5 = ActivityEditMyAccount.this;
                String str = r5.refreshToken;
                final HashMap map = this.val$json;
                commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map, i, str2, str3);
                    }
                });
                return;
            }
            System.out.println("hii i am map2");
            try {
                System.out.println("hii i am map3");
                ActivityEditMyAccount.this.commonUtils.showMessageWithTitleOK(ActivityEditMyAccount.this, "Error", new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$1$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (Exception e) {
                System.out.println("hii i am map4");
                Logger.e("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
        public /* synthetic */ void lambda$onResponse$1(HashMap map, int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ActivityEditMyAccount.this.commonUtils.showMessageOK(ActivityEditMyAccount.this, "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ActivityEditMyAccount.this.token = "Bearer " + str;
            SharedPref.getInstance(ActivityEditMyAccount.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(ActivityEditMyAccount.this.getApplicationContext()).setToken("Bearer " + str);
            Toast.makeText(ActivityEditMyAccount.this.getApplicationContext(), "Token Refreshed", 1).show();
            ActivityEditMyAccount.this.getBlo1(map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityEditMyAccount.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityEditMyAccount.this.getApplicationContext()).setLocaleBool(false);
            ActivityEditMyAccount.this.startActivity(new Intent((Context) ActivityEditMyAccount.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("on Failure............", t.getMessage());
        }
    }

    public void getBlo() {
        this.binding.firstName.setText(this.name);
        this.binding.mobileNumber.setText(this.phoneNumber);
        this.binding.emailId.setText(this.email);
        this.binding.officeAddress.setText(this.partName);
        this.binding.stateValue.setText(this.stateName);
        this.binding.districtValue.setText(this.districtName);
        this.binding.assembly5Value.setText(this.asmblyName);
    }

    public boolean test() {
        if (this.binding.firstName.getText().toString().isEmpty()) {
            showDialog(this.alertTag, "Please Enter Name");
            return false;
        }
        if (this.binding.mobileNumber.getText().toString().isEmpty()) {
            showDialog(this.alertTag, "Please Enter Mobile Number");
            return false;
        }
        if (!this.binding.mobileNumber.getText().toString().isEmpty() && this.binding.mobileNumber.getText().toString().length() != 10) {
            showDialog(this.alertTag, "Please Enter Correct 10 Digit Mobile Number");
            return false;
        }
        if (!this.binding.mobileNumber.getText().toString().isEmpty() && this.binding.mobileNumber.getText().toString().length() == 10 && !this.binding.mobileNumber.getText().toString().matches("[6-9][0-9]{9}")) {
            showDialog(this.alertTag, "Please Enter Correct Mobile Number");
            return false;
        }
        if (!this.binding.emailId.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && !this.binding.emailId.getText().toString().isEmpty()) {
            showDialog(this.alertTag, "Please enter correct Email ID");
            return false;
        }
        if (!this.binding.officeAddress.getText().toString().isEmpty()) {
            return true;
        }
        showDialog(this.alertTag, "Please Enter Office Address");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityEditMyAccount$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public String getDate() {
        return new SimpleDateFormat("dd/MM/yy").format(new Date());
    }
}
