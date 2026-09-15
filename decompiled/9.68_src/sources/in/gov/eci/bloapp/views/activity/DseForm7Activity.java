package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivityDseForm7Binding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DseForm7Activity extends Hilt_DseForm7Activity implements View.OnClickListener {
    String acNo;
    String age;
    AlertDialog alertDialog;
    String applicantEpic;
    String assembly;
    String assemblyno;
    private BloActivityDseForm7Binding binding;
    Retrofit.Builder builder2;
    String certificateAttached;
    String certificateName;
    String certificateSize;
    CommomUtility commonUtilClass;
    String contentText;
    private String createdOn;
    private String date;
    String deletionObjection;
    String district;
    String districtCdOfPersonToBeDeleted;
    String districtCode;
    String docref;
    VerifyPayload dseDataPayload;
    String epic;
    private String epicId;
    private String epicNumberId;
    String firstNameApplicant;
    private String flag;
    FusedLocationProviderClient fusedLocationProviderClient;
    String gender;
    String house;
    String houseRegional;
    private String isSelfMobile;
    String lastNameApplicant;
    private LocationRequest locationRequest;
    String mobileType;
    String mobilenum;
    private String name;
    String objectToInclFormRefNum;
    private String objectToInclFormType;
    String partNo;
    String partNumberApplicant;
    String partNumberOfPersonToBeDeleted;
    private JsonObject payloadContent;
    String pincode;
    String place;
    String postoffice;
    String postofficeRegional;
    private int pseId;
    String reasonForDeletion;
    String referenceNumber;
    private String refreshToken;
    String rejectionOption;
    String rejectionOptionSubcategory;
    private String request;
    Retrofit retrofit;
    String sectionNoApplicant;
    private String serialNumberApplicant;
    String serialNumberOfPersonToBeDeleted;
    UserClient service;
    String sessionExpiredString;
    String state;
    String stateCode;
    String street;
    String streetRegional;
    String surname;
    String tehsil;
    String tehsilRegional;
    String token;
    String uploadDoc1Photoname;
    String uploadDoc1Size;
    String uploadDoc2Photoname;
    String uploadDoc2Size;
    String uploadForm6Page1Url;
    String uploadForm6Page2Url;
    UserClient userClient;
    Utils utils;
    private DeletionObjectionViewModel viewModel;
    String village;
    String villageRegional;
    String districtCdOfPersonToBeDeletedString = "districtCdOfPersonToBeDeleted";
    String objectionString = "objection";
    String alert = "Alert";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public DseForm7Activity() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder2 = builderClient;
        this.retrofit = builderClient.build();
        this.deletionObjection = "Deletion Objection";
        this.commonUtilClass = new CommomUtility();
        this.sessionExpiredString = "Session token expired please Login";
        this.contentText = "content";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityDseForm7Binding bloActivityDseForm7BindingInflate = BloActivityDseForm7Binding.inflate(getLayoutInflater());
        this.binding = bloActivityDseForm7BindingInflate;
        setContentView((View) bloActivityDseForm7BindingInflate.getRoot());
        this.viewModel = (DeletionObjectionViewModel) new ViewModelProvider(this).get(DeletionObjectionViewModel.class);
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.acNo = SharedPref.getInstance(this).getAssemblyNumber();
        this.assemblyno = SharedPref.getInstance(this).getAssemblyNumber();
        this.assembly = SharedPref.getInstance(this).getAssemblyName();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.refreshToken = SharedPref.getInstance(this).getRefreshToken();
        this.state = SharedPref.getInstance(this).getStateName();
        this.district = SharedPref.getInstance(this).getDistrictName();
        this.userClient = (UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        Logger.d("token Deletion/Objecion", this.token);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("flag");
            this.flag = string;
            this.flag = nullChecker(string);
            VerifyPayload verifyPayload = (VerifyPayload) extras.getParcelable("data");
            this.dseDataPayload = verifyPayload;
            String strValueOf = String.valueOf(verifyPayload.getEpicId());
            this.epicId = strValueOf;
            this.epicId = nullChecker(strValueOf);
            String str = this.dseDataPayload.epicNo;
            this.epicNumberId = str;
            this.epicNumberId = nullChecker(str);
        }
        this.alertDialog.show();
        this.createdOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
        starMarkerAndRemover();
        fieldupdater();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getCurrentLocation();
        initializingClicks();
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    private String nullCheckerPartNumber(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null") || bundleObject.isEmpty()) ? this.partNo : bundleObject;
    }

    private void starMarkerAndRemover() {
        this.binding.textView1.setText(mandatoryremover(this.binding.textView1.getText().toString()));
        this.binding.textView2.setText(mandatoryremover(this.binding.textView2.getText().toString()));
        this.binding.constituencyTv.setText(mandatoryremover(this.binding.constituencyTv.getText().toString()));
        this.binding.textView17.setText(mandatoryremover(this.binding.textView17.getText().toString()));
        this.binding.textView18.setText(mandatoryremover(this.binding.textView18.getText().toString()));
        this.binding.textView19.setText(mandatoryremover(this.binding.textView19.getText().toString()));
        this.binding.textView31.setText(mandatoryremover(this.binding.textView31.getText().toString()));
        this.binding.textView32.setText(mandatoryremover(this.binding.textView32.getText().toString()));
    }

    private void fieldupdater() {
        this.binding.stateTv.setText(this.state);
        this.binding.districtTv.setText(this.district);
        this.binding.constituencynoEd.setText(this.assemblyno);
        this.binding.constituencyEd.setText(this.assembly);
        SpannableString spannableString = new SpannableString("Already Enrolled");
        spannableString.setSpan(new StyleSpan(1), 0, 16, 33);
        this.binding.optionRb3.setText(spannableString);
        this.binding.issueDateEd.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
        this.binding.placeEd.setText("");
        getEpicDetails();
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.homeBtnIv.setOnClickListener(this);
        this.binding.submitTv.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131362490) {
            finish();
        }
        if (v.getId() == 2131364196) {
            Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
        if (v.getId() == 2131366158) {
            savePseForm7Details(this.dseDataPayload, 0);
        }
    }

    public String mandatoryremover(String simple) {
        return simple.endsWith("*") ? simple.substring(0, simple.length() - 1) : simple;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog1(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showdialog1$0(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent((Context) this, (Class<?>) DseVerifiedListActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void savePseForm7Details(final VerifyPayload efPayload, int pos) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", efPayload.getEpicId());
        map2.put("stateCd", this.stateCode);
        map2.put("epicNo", efPayload.getEpicNo());
        map2.put("dseId", Integer.valueOf(efPayload.getDseId()));
        map2.put("clusterId", efPayload.getDseClusterId());
        map2.put("eroActionStatus", "form7");
        map2.put("isPse", 0);
        map2.put("userName", SharedPref.getInstance(getApplicationContext()).getName());
        map2.put("userId", SharedPref.getInstance(getApplicationContext()).getPreferredUsername());
        map2.put("currentRole", "Blo");
        map2.put("module", "dse");
        map2.put("partSerialNumber", Integer.valueOf(efPayload.getPartSerialNo()));
        map2.put("reasonForDeletion", "AERL");
        arrayList.add(map2);
        Call<AsdActionrRoot> callSavePseForm7Details = this.service.savePseForm7Details(map, arrayList);
        this.alertDialog.show();
        callSavePseForm7Details.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity.1
            public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                    try {
                        DseForm7Activity.this.callDseVerified(efPayload, ((AsdActionrRoot) response.body()).getRefId());
                        return;
                    } catch (Exception unused) {
                        if (DseForm7Activity.this.alertDialog != null) {
                            DseForm7Activity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                    DseForm7Activity.this.showdialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (DseForm7Activity.this.alertDialog != null) {
                    DseForm7Activity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDseVerified(VerifyPayload efPayload, final String refrenceNmber) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(getApplicationContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getApplicationContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", efPayload.getEpicId());
        map2.put("epicNo", efPayload.getEpicNo());
        map2.put("state", this.stateCode);
        map2.put("bloActionTaken", "form7");
        Call<AsdActionrRoot> callUpdateBloAction = this.service.updateBloAction(map, map2);
        this.alertDialog.show();
        callUpdateBloAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.DseForm7Activity] */
            public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = new Utils();
                        ?? r0 = DseForm7Activity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage() + "\nReference Number : " + refrenceNmber, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity.2.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                Intent intent = new Intent((Context) DseForm7Activity.this, (Class<?>) DseVerifiedListActivity.class);
                                intent.setFlags(268468224);
                                DseForm7Activity.this.startActivity(intent);
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (DseForm7Activity.this.alertDialog != null) {
                            DseForm7Activity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                    DseForm7Activity.this.showdialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (DseForm7Activity.this.alertDialog != null) {
                        DseForm7Activity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (DseForm7Activity.this.alertDialog != null) {
                    DseForm7Activity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getEpicDetails() {
        HashMap map = new HashMap();
        map.put("epicNumber", this.dseDataPayload.getEpicNo());
        this.commonUtilClass.getRetrofitClient(this, this.token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd()).getByEpicForForm(this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.DseForm7Activity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonArray> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.DseForm7Activity] */
        /* JADX WARN: Type inference failed for: r2v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.DseForm7Activity] */
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
        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                ArrayList arrayList = new ArrayList();
                JsonArray jsonArray = (JsonArray) response.body();
                for (int i = 0; i < jsonArray.size(); i++) {
                    DseForm7Activity.this.payloadContent = jsonArray.get(i).get(DseForm7Activity.this.contentText);
                    String strTrim = String.valueOf(DseForm7Activity.this.payloadContent.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim2 = String.valueOf(DseForm7Activity.this.payloadContent.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim3 = String.valueOf(DseForm7Activity.this.payloadContent.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim4 = String.valueOf(DseForm7Activity.this.payloadContent.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim5 = String.valueOf(DseForm7Activity.this.payloadContent.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim6 = String.valueOf(DseForm7Activity.this.payloadContent.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    if (!TextUtils.isEmpty(strTrim2) && !strTrim2.equalsIgnoreCase("null")) {
                        DseForm7Activity.this.binding.nameEd.setText(strTrim2);
                    } else {
                        DseForm7Activity.this.binding.nameEd.setText("");
                    }
                    if (!TextUtils.isEmpty(strTrim3) && !strTrim3.equalsIgnoreCase("null")) {
                        DseForm7Activity.this.binding.surnameEd2.setText(strTrim3);
                    } else {
                        DseForm7Activity.this.binding.surnameEd2.setText("");
                    }
                    if (!TextUtils.isEmpty(strTrim) && !strTrim.equalsIgnoreCase("null")) {
                        DseForm7Activity.this.binding.epicEd2.setText(strTrim);
                    } else {
                        DseForm7Activity.this.binding.epicEd2.setText("");
                    }
                    if (!TextUtils.isEmpty(strTrim5) && !strTrim5.equalsIgnoreCase("null")) {
                        DseForm7Activity.this.binding.ageEd2.setText(strTrim5);
                    } else {
                        DseForm7Activity.this.binding.ageEd2.setText("");
                    }
                    if (!TextUtils.isEmpty(strTrim4) && !strTrim4.equalsIgnoreCase("null")) {
                        DseForm7Activity.this.binding.relationnameEd2.setText(strTrim4);
                    } else {
                        DseForm7Activity.this.binding.relationnameEd2.setText("");
                    }
                    if (!TextUtils.isEmpty(strTrim6) && !strTrim6.equalsIgnoreCase("null")) {
                        if (strTrim6.equals("GMTH")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Grand Mother");
                        } else if (strTrim6.equals("GFTH")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Grand Father");
                        } else if (strTrim6.equalsIgnoreCase("M") || strTrim6.equalsIgnoreCase("MOTHER") || strTrim6.equalsIgnoreCase("MTHR")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Mother");
                        } else if (strTrim6.equalsIgnoreCase("F") || strTrim6.equalsIgnoreCase("FATHER") || strTrim6.equalsIgnoreCase("FTHR")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Father");
                        } else if (strTrim6.equalsIgnoreCase("H") || strTrim6.equalsIgnoreCase("HUSBAND") || strTrim6.equalsIgnoreCase("HSBN")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Husband");
                        } else if (strTrim6.equalsIgnoreCase("W") || strTrim6.equalsIgnoreCase("WIFE")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Wife");
                        } else if (strTrim6.equalsIgnoreCase("L") || strTrim6.equalsIgnoreCase("OTHER") || strTrim6.equalsIgnoreCase("O")) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("Other");
                        } else if (TextUtils.isEmpty(strTrim6)) {
                            DseForm7Activity.this.binding.relationtypeEd2.setText("");
                        } else {
                            DseForm7Activity.this.binding.relationtypeEd2.setText(strTrim6);
                        }
                    } else {
                        DseForm7Activity.this.binding.relationtypeEd2.setText("");
                    }
                }
                if (arrayList.size() == 0) {
                    DseForm7Activity.this.alertDialog.dismiss();
                    return;
                } else {
                    DseForm7Activity.this.alertDialog.dismiss();
                    return;
                }
            }
            try {
                if (response.code() == 401) {
                    CommomUtility commomUtility = DseForm7Activity.this.commonUtilClass;
                    ?? r2 = DseForm7Activity.this;
                    commomUtility.getRefreshToken(r2, ((DseForm7Activity) r2).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                } else {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("Form 7 Other Epic case error: ", strOptString);
                    DseForm7Activity.this.alertDialog.dismiss();
                    DseForm7Activity dseForm7Activity = DseForm7Activity.this;
                    dseForm7Activity.showdialog(dseForm7Activity.alert, strOptString);
                }
            } catch (Exception e) {
                Logger.d("", e.getMessage());
                DseForm7Activity.this.alertDialog.dismiss();
                if (response.code() == 401) {
                    CommomUtility commomUtility2 = DseForm7Activity.this.commonUtilClass;
                    ?? r12 = DseForm7Activity.this;
                    commomUtility2.getRefreshToken(r12, ((DseForm7Activity) r12).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$3$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$3(i2, str, str2);
                        }
                    });
                } else if (response != null && response.code() != 200 && response.message() != null) {
                    DseForm7Activity dseForm7Activity2 = DseForm7Activity.this;
                    dseForm7Activity2.showdialog(dseForm7Activity2.alert, response.message());
                }
            }
            DseForm7Activity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.DseForm7Activity] */
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
            DseForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = DseForm7Activity.this.commonUtilClass;
                ?? r5 = DseForm7Activity.this;
                commomUtility.showMessageOK(r5, r5.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$3$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                DseForm7Activity.this.token = "Bearer " + str;
                Toast.makeText((Context) DseForm7Activity.this, (CharSequence) "Token Refreshed", 1).show();
                SharedPref.getInstance(DseForm7Activity.this).setRefreshToken(str2);
                SharedPref.getInstance(DseForm7Activity.this).setToken("Bearer " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DseForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(DseForm7Activity.this).setLocaleBool(false);
            DseForm7Activity.this.startActivity(new Intent((Context) DseForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.DseForm7Activity] */
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
        public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
            DseForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = DseForm7Activity.this.commonUtilClass;
                ?? r5 = DseForm7Activity.this;
                commomUtility.showMessageOK(r5, r5.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
            } else {
                DseForm7Activity.this.token = "Bearer " + str;
                Toast.makeText((Context) DseForm7Activity.this, (CharSequence) "Token Refreshed", 1).show();
                SharedPref.getInstance(DseForm7Activity.this).setRefreshToken(str2);
                SharedPref.getInstance(DseForm7Activity.this).setToken("Bearer " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DseForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(DseForm7Activity.this).setLocaleBool(false);
            DseForm7Activity.this.startActivity(new Intent((Context) DseForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            DseForm7Activity.this.alertDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$$ExternalSyntheticLambda1
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$2(task);
                    }
                });
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getCurrentLocation$2(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation.get(0).getLocality().isEmpty()) {
                    return;
                }
                this.binding.placeEd.setText(fromLocation.get(0).getLocality());
            } catch (Exception e) {
                Logger.d("Content : ", e.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(this).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.DseForm7Activity$$ExternalSyntheticLambda0
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$3(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$3(Task task) {
        try {
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((DseForm7Activity) Objects.requireNonNull(this)).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }
}
