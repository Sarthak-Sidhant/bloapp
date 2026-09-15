package in.gov.eci.bloapp.views.fragments.home;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.SIRResponseData;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentHomeBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel;
import in.gov.eci.bloapp.views.activity.BloNotifiy;
import in.gov.eci.bloapp.views.activity.CheckList;
import in.gov.eci.bloapp.views.activity.DashboardBLOActivity;
import in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.DseVerifiedListActivity;
import in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout;
import in.gov.eci.bloapp.views.activity.FomatCListActivity;
import in.gov.eci.bloapp.views.activity.H2HDashBoard;
import in.gov.eci.bloapp.views.activity.Housetohouse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.WebLoginActivity;
import in.gov.eci.bloapp.views.activity.facility;
import in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection;
import in.gov.eci.bloapp.views.fragments.bla.BlaActivity;
import in.gov.eci.bloapp.views.fragments.callRequest.callRequestMain;
import in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HomeFragment extends Hilt_HomeFragment implements View.OnClickListener {
    AlertDialog alertDialog;
    String asmblyNO;
    String asmblyName;
    BloFragmentHomeBinding binding;
    String bloLname;
    String bloPhoneNumber;
    String blofName;
    String partNo;
    private String refreshToken;
    String stateCode;
    private ArrayList<String> statecode1;
    private ArrayList<String> statename;
    String token;
    MainActivityViewModel viewModel;
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String facility = "facility";
    String checklist = "checklist";
    String forms = "forms";
    String bloRegister = "bloRegister";
    String callRequest = "callRequest";
    String alrt = "Alert";
    String disableMess = "This feature is disabled for your State as per the ECI direction";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES).build();
    Retrofit.Builder builder = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<String> relationNameSpinnerVal = new ArrayList<>();
    ArrayList<String> relationCodeSpinnerVal = new ArrayList<>();
    String selectRelationType = "Select Relation Type";
    private final ActivityResultLauncher<String> requestNotifications = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda14
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$21((Boolean) obj);
        }
    });

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentHomeBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        Logger.d("on home screen", "on home screen");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.viewModel = (MainActivityViewModel) new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.stateCode = SharedPref.getInstance(requireActivity()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.asmblyName = SharedPref.getInstance(requireActivity()).getAssemblyName();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
        askNotificationPermission();
        String userName = SharedPref.getInstance(requireContext()).getUserName();
        HashMap map = new HashMap();
        map.put("deviceIp", "0.0.0.0");
        map.put("deviceBrand", brandName());
        map.put("deviceId", getDeviceIdd());
        map.put("deviceLocation", SharedPref.getInstance(requireContext()).getCityName());
        map.put("deviceName", getDeviceName());
        map.put("deviceModel", getDeviceModel());
        map.put("deviceType", determineDevice());
        map.put("acNo", this.asmblyNO);
        map.put("stateCd", this.stateCode);
        map.put("partNo", this.partNo);
        map.put("createdBy", userName);
        map.put("createdDttm", currentDate());
        map.put("modifiedBy", userName);
        map.put("modifiedDttm", currentDate());
        Logger.d("hasmap", "hashmap");
        this.builder.build();
        if (SharedPref.getInstance(getContext()).getAcListName(Constants.STATE_LIST_NAME).isEmpty() || SharedPref.getInstance(getContext()).getAcListCode(Constants.STATE_LIST_CODE).isEmpty()) {
            getAllState();
        }
        getRelationTypeDropdown();
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).saveBloLogin(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "application/json", "BLOAPP", SharedPref.getInstance(requireContext()).getStateCode(), "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.1
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(ElectorDataSyncFragment.TAG, "save BLO Login API " + ((JsonObject) response.body()).toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(ElectorDataSyncFragment.TAG, "save BLO Login API error" + t.getMessage());
            }
        });
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getMyProfile(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB").enqueue(new AnonymousClass2());
        getBloAppProfile(this.stateCode, this.token);
        getSirStatus(this.stateCode, this.token);
        getNotification(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAssemblyNumber());
        if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
            getTrainingStatus();
        }
        Logger.d("BLODetails", this.blofName + this.bloLname + this.bloPhoneNumber);
        this.binding.textViewConstituencyHeader.setText(String.format(getString(R.string.blo_constituency_details), new Object[0]) + " | " + String.format(getString(R.string.blo_part_number), new Object[0]));
        this.binding.textViewConstituencyDetails.setText(this.asmblyNO + " | " + this.asmblyName + " | " + this.partNo);
        this.binding.cardView1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.cardFacilities.setOnClickListener(this);
        this.binding.cardChecklist.setOnClickListener(this);
        this.binding.cardForms.setOnClickListener(this);
        this.binding.cardH2HSurvey.setOnClickListener(this);
        this.binding.cardH2HDashboardForms.setOnClickListener(this);
        this.binding.cardDse.setOnClickListener(this);
        this.binding.cardPSE.setOnClickListener(this);
        this.binding.notiLayout.setOnClickListener(this);
        this.binding.cardCallRequestMAin.setOnClickListener(this);
        this.binding.cardBla.setOnClickListener(this);
        this.binding.cardElectorMapping.setOnClickListener(this);
        this.binding.cardSpecialRevision.setOnClickListener(this);
        this.binding.cardDSEVerified.setOnClickListener(this);
        this.binding.selectphotocard.setOnClickListener(this);
        this.binding.webLogin.setOnClickListener(this);
        this.binding.formcCard.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) FomatCListActivity.class));
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            System.out.println("hii i am response code " + response.code());
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                HomeFragment.this.bloPhoneNumber = jsonObject.get("mobileNumber").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                HomeFragment.this.blofName = jsonObject.get("userFname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                HomeFragment.this.bloLname = jsonObject.get("userLname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                SharedPref.getInstance(HomeFragment.this.requireContext()).setBloFname(HomeFragment.this.blofName);
                SharedPref.getInstance(HomeFragment.this.requireContext()).setBloLname(HomeFragment.this.bloLname);
                SharedPref.getInstance(HomeFragment.this.requireContext()).setBloPhone(HomeFragment.this.bloPhoneNumber);
                Logger.d("BLODetails success", HomeFragment.this.blofName + HomeFragment.this.bloLname + HomeFragment.this.bloPhoneNumber);
                return;
            }
            if (response.code() == 401) {
                System.out.println("Hii i am 401");
                HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.getContext(), HomeFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), HomeFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
            HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        this.alertDialog.show();
        this.commomUtility.getGenderWiseElectorsCountHome(this.stateCode, this.asmblyNO, this.partNo, this.token, requireContext());
        CommomUtility commomUtility = this.commomUtility;
        String str = this.stateCode;
        commomUtility.getDashChartData(str, this.asmblyNO, this.partNo, this.token, str, requireContext());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$0();
            }
        }, 1000L);
        Logger.d("In getDashChartData() Device- > payload - ", String.valueOf(SharedPref.getInstance(requireContext()).getDashChartDataResponseCode()));
        Logger.d("In getGenderDashboardHome() Device- > payload - ", String.valueOf(SharedPref.getInstance(requireContext()).getGenderWiseElectorsCountHomeResponseCode()));
        Logger.d("In getDashChartData() - > payload - ", SharedPref.getInstance(requireContext()).getDashChartData());
        Logger.d("In getGenderDashboardHome() - > payload - ", SharedPref.getInstance(requireContext()).getGenderWiseElectorsCountHome());
        startActivity(new Intent((Context) getActivity(), (Class<?>) DashboardBLOActivityCopy.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        this.alertDialog.show();
        this.commomUtility.getGenderWiseElectorsCountHome(this.stateCode, this.asmblyNO, this.partNo, this.token, requireContext());
        CommomUtility commomUtility = this.commomUtility;
        String str = this.stateCode;
        commomUtility.getDashChartData(str, this.asmblyNO, this.partNo, this.token, str, requireContext());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$2();
            }
        }, 1000L);
        Logger.d("In getDashChartData() Device- > payload - ", String.valueOf(SharedPref.getInstance(requireContext()).getDashChartDataResponseCode()));
        Logger.d("In getGenderDashboardHome() Device- > payload - ", String.valueOf(SharedPref.getInstance(requireContext()).getGenderWiseElectorsCountHomeResponseCode()));
        Logger.d("In getDashChartData() - > payload - ", SharedPref.getInstance(requireContext()).getDashChartData());
        Logger.d("In getGenderDashboardHome() - > payload - ", SharedPref.getInstance(requireContext()).getGenderWiseElectorsCountHome());
        startActivity(new Intent((Context) getActivity(), (Class<?>) DashboardBLOActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2() {
        this.alertDialog.dismiss();
    }

    public String getDeviceIdd() {
        return Settings.Secure.getString(requireContext().getContentResolver(), "android_id");
    }

    public String getDeviceName() {
        return Build.BRAND + " " + Build.MANUFACTURER + "  " + Build.MODEL;
    }

    public String getDeviceModel() {
        return Build.MANUFACTURER + "  " + Build.MODEL;
    }

    public String brandName() {
        return Build.BRAND;
    }

    public String currentDate() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    public void getNotification(String stateCode, String Token, String acNo) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("currentRole", "blo");
            map.put("state", stateCode);
            map.put("Content-Type", "application/json");
            map.put("channelidobo", "BLOAPP");
            ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getAllIsSeenCount(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.4
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        if (response.body() != null && ((JsonObject) response.body()).get("payload") != null) {
                            HomeFragment homeFragment = HomeFragment.this;
                            homeFragment.animateBellSwing(homeFragment.binding.ivBell);
                            if (((JsonObject) response.body()).get("payload").getAsInt() == 0) {
                                HomeFragment.this.binding.tvBadge.setVisibility(0);
                            } else {
                                HomeFragment.this.binding.tvBadge.setVisibility(0);
                                HomeFragment.this.binding.tvBadge.setText("" + ((JsonObject) response.body()).get("payload"));
                            }
                        } else {
                            HomeFragment.this.binding.tvBadge.setVisibility(8);
                            HomeFragment.this.binding.tvBadge.setText("0");
                        }
                        HomeFragment.this.alertDialog.dismiss();
                        return;
                    }
                    HomeFragment.this.alertDialog.dismiss();
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    HomeFragment.this.alertDialog.dismiss();
                }
            });
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
        }
    }

    public String determineDevice() {
        return isTablet() ? "Tablet" : "Phone";
    }

    public boolean isTablet() {
        int i = getResources().getConfiguration().screenLayout & 15;
        return i == 3 || i == 4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View v) {
        int id = v.getId();
        this.alertDialog.show();
        if (id == 2131362611) {
            Logger.d(" SharedPerf currentdate ", SharedPref.getInstance(requireContext()).getCurrentDate());
            Logger.d("currentdate ", this.formatter.format(new Date()));
            Logger.d("boolean ", String.valueOf(SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))));
            if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    try {
                        JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData1 ", String.valueOf(jSONArray));
                        JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf1 ", String.valueOf(asJsonObject.get(this.facility)));
                        if (asJsonObject.get(this.facility).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) facility.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    } catch (Exception e) {
                        Logger.d("absdaf ", e.getMessage());
                    }
                }
                this.alertDialog.dismiss();
                return;
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$4(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362607) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        JSONArray jSONArray2 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData3 ", String.valueOf(jSONArray2));
                        JsonObject asJsonObject2 = this.gson.toJsonTree(jSONArray2.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf3 ", String.valueOf(asJsonObject2.get(this.checklist)));
                        if (asJsonObject2.get(this.checklist).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) CheckList.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$5(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e2) {
                Logger.d("djcncncmzcnc1 ", e2.getMessage());
                return;
            }
        }
        if (id == 2131362612) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        JSONArray jSONArray3 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData5 ", String.valueOf(jSONArray3));
                        JsonObject asJsonObject3 = this.gson.toJsonTree(jSONArray3.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf5 ", String.valueOf(asJsonObject3.get(this.forms)));
                        if (asJsonObject3.get(this.forms).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) VoterForms.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$6(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e3) {
                Logger.d("djcncncmzcnc2 ", e3.getMessage());
                return;
            }
        }
        if (id == 2131362614) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        JSONArray jSONArray4 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData7 ", String.valueOf(jSONArray4));
                        JsonObject asJsonObject4 = this.gson.toJsonTree(jSONArray4.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf7 ", String.valueOf(asJsonObject4.get("h2h")));
                        if (asJsonObject4.get("h2h").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            SharedPref.getInstance(getContext()).setAllHousesData("");
                            SharedPref.getInstance(getContext()).setSearchedAllHousesData("");
                            startActivity(new Intent(v.getContext(), (Class<?>) Housetohouse.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$7(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e4) {
                Logger.d("djcncncmzcnc3 ", e4.getMessage());
                return;
            }
        }
        if (id == 2131362617) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        return;
                    }
                    JSONArray jSONArray5 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                    Logger.d("profileData9 ", String.valueOf(jSONArray5));
                    JsonObject asJsonObject5 = this.gson.toJsonTree(jSONArray5.get(0)).getAsJsonObject();
                    Logger.d("acbsfvnmsf vmf9 ", String.valueOf(asJsonObject5.get("pse")));
                    if (asJsonObject5.get("pse").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                        startActivity(new Intent(v.getContext(), (Class<?>) PseActivity.class));
                    } else {
                        showdialog1(this.alrt, this.disableMess);
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$8(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e5) {
                Logger.d("djcncncmzcnc4 ", e5.getMessage());
                return;
            }
        }
        if (id == 2131362613) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        JSONArray jSONArray6 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData11 ", String.valueOf(jSONArray6));
                        JsonObject asJsonObject6 = this.gson.toJsonTree(jSONArray6.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject6.get(this.bloRegister)));
                        if (asJsonObject6.get(this.bloRegister).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) H2HDashBoard.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$9(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e6) {
                Logger.d("djcncncmzcnc5 ", e6.getMessage());
                return;
            }
        }
        if (id == 2131362609) {
            try {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        return;
                    }
                    JSONArray jSONArray7 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                    Logger.d("profileData13 ", String.valueOf(jSONArray7));
                    JsonObject asJsonObject7 = this.gson.toJsonTree(jSONArray7.get(0)).getAsJsonObject();
                    Logger.d("acbsfvnmsf vmf13 ", String.valueOf(asJsonObject7.get("des")));
                    if (asJsonObject7.get("des").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                        startActivity(new Intent(v.getContext(), (Class<?>) DseActivity.class));
                    } else {
                        showdialog1(this.alrt, this.disableMess);
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$10(v);
                    }
                }, 2000L);
                return;
            } catch (Exception e7) {
                Logger.d("djcncncmzcnc6 ", e7.getMessage());
                return;
            }
        }
        if (id == 2131364887) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) BloNotifiy.class));
            this.alertDialog.dismiss();
            return;
        }
        if (id == 2131366717) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    try {
                        JSONArray jSONArray8 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData1 ", String.valueOf(jSONArray8));
                        JsonObject asJsonObject8 = this.gson.toJsonTree(jSONArray8.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject8.get("webLogin")));
                        if (asJsonObject8.get("webLogin").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) WebLoginActivity.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    } catch (Exception e8) {
                        Logger.d("absdaf ", e8.getMessage());
                    }
                }
                this.alertDialog.dismiss();
                return;
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$11(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362606) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) callRequestMain.class));
            this.alertDialog.dismiss();
            return;
        }
        if (id == 2131362618) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    try {
                        JSONArray jSONArray9 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData1 ", String.valueOf(jSONArray9));
                        JsonObject asJsonObject9 = this.gson.toJsonTree(jSONArray9.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject9.get("specialRevision")));
                        if (asJsonObject9.get("specialRevision").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
                                if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getTrainingMessage())) {
                                    startActivity(new Intent(v.getContext(), (Class<?>) SIRLanguageSelection.class));
                                } else {
                                    alertDialog_sir();
                                }
                            } else {
                                startActivity(new Intent(v.getContext(), (Class<?>) SIRLanguageSelection.class));
                            }
                        } else {
                            showdialog1(this.alrt, "This Feature is only for SIR of Bihar");
                        }
                    } catch (Exception e9) {
                        Logger.d("absdaf ", e9.getMessage());
                    }
                }
                this.alertDialog.dismiss();
                return;
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$12(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362605) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) BlaActivity.class));
            this.alertDialog.dismiss();
            return;
        }
        if (id == 2131362610) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    try {
                        JSONArray jSONArray10 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData1 ", String.valueOf(jSONArray10));
                        JsonObject asJsonObject10 = this.gson.toJsonTree(jSONArray10.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject10.get("electorMapping")));
                        if (asJsonObject10.get("electorMapping").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) ElectorMappingMainLayout.class));
                        } else {
                            showdialog1(this.alrt, this.disableMess);
                        }
                    } catch (Exception e10) {
                        Logger.d("absdaf ", e10.getMessage());
                    }
                }
                this.alertDialog.dismiss();
                return;
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$13(v);
                }
            }, 2000L);
            return;
        }
        if (id != 2131362608) {
            if (id == 2131365663) {
                this.alertDialog.dismiss();
                startActivity(new Intent(v.getContext(), (Class<?>) NonSirSelectPhotoListActivity.class));
                return;
            }
            return;
        }
        if (SharedPref.getInstance(requireContext()).getCurrentDate() != null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                try {
                    JSONArray jSONArray11 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                    Logger.d("profileData1 ", String.valueOf(jSONArray11));
                    JsonObject asJsonObject11 = this.gson.toJsonTree(jSONArray11.get(0)).getAsJsonObject();
                    Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject11.get("dseActivity")));
                    if (asJsonObject11.get("dseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                        startActivity(new Intent(v.getContext(), (Class<?>) DseVerifiedListActivity.class));
                    } else {
                        showdialog1(this.alrt, this.disableMess);
                    }
                } catch (Exception e11) {
                    Logger.d("absdaf ", e11.getMessage());
                }
            }
            this.alertDialog.dismiss();
            return;
        }
        getBloAppProfile(this.stateCode, this.token);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onClick$14(v);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$4(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) facility.class));
                }
            } else {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get(this.facility)));
                if (asJsonObject.get(this.facility).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) facility.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$5(View view) {
        try {
            Logger.d("ndsfbvhfv2 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) CheckList.class));
                }
            } else {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData4 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf4 ", String.valueOf(asJsonObject.get(this.checklist)));
                if (asJsonObject.get(this.checklist).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) CheckList.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv2 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$6(View view) {
        try {
            Logger.d("ndsfbvhfv3 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) VoterForms.class));
                }
            } else {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData6 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf6 ", String.valueOf(asJsonObject.get(this.forms)));
                if (asJsonObject.get(this.forms).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) VoterForms.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv3 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$7(View view) {
        try {
            Logger.d("ndsfbvhfv4 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData8 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf8 ", String.valueOf(asJsonObject.get("h2h")));
                if (asJsonObject.get("h2h").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    SharedPref.getInstance(getContext()).setAllHousesData("");
                    SharedPref.getInstance(getContext()).setSearchedAllHousesData("");
                    startActivity(new Intent(view.getContext(), (Class<?>) Housetohouse.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                SharedPref.getInstance(getContext()).setAllHousesData("");
                SharedPref.getInstance(getContext()).setSearchedAllHousesData("");
                startActivity(new Intent(view.getContext(), (Class<?>) Housetohouse.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv4 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$8(View view) {
        try {
            Logger.d("ndsfbvhfv5 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData10 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf10 ", String.valueOf(asJsonObject.get("pse")));
                if (asJsonObject.get("pse").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) PseActivity.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) PseActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv5 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$9(View view) {
        try {
            Logger.d("ndsfbvhfv6 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) H2HDashBoard.class));
                }
            } else {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData12 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf12 ", String.valueOf(asJsonObject.get(this.bloRegister)));
                if (asJsonObject.get(this.bloRegister).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) H2HDashBoard.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv6 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$10(View view) {
        try {
            Logger.d("ndsfbvhfv7 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData14 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf14 ", String.valueOf(asJsonObject.get("des")));
                if (asJsonObject.get("des").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) DseActivity.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) DseActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv7 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$11(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("webLogin")));
                if (asJsonObject.get("webLogin").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) WebLoginActivity.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) WebLoginActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$12(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("specialRevision")));
                if (asJsonObject.get("specialRevision").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
                        if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getTrainingMessage())) {
                            startActivity(new Intent(view.getContext(), (Class<?>) SIRLanguageSelection.class));
                        } else {
                            alertDialog_sir();
                        }
                    } else {
                        startActivity(new Intent(view.getContext(), (Class<?>) SIRLanguageSelection.class));
                    }
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
                    if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getTrainingMessage())) {
                        startActivity(new Intent(view.getContext(), (Class<?>) SIRLanguageSelection.class));
                    } else {
                        alertDialog_sir();
                    }
                } else {
                    startActivity(new Intent(view.getContext(), (Class<?>) SIRLanguageSelection.class));
                }
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$13(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("electorMapping")));
                if (asJsonObject.get("electorMapping").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) ElectorMappingMainLayout.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) ElectorMappingMainLayout.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$14(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("dseActivity")));
                if (asJsonObject.get("dseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) DseVerifiedListActivity.class));
                } else {
                    showdialog1(this.alrt, this.disableMess);
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) DseVerifiedListActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void getBloAppProfile(String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getBloAppProfile(stateCode, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new AnonymousClass5(stateCode));
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
            Toast.makeText(getContext().getApplicationContext(), "API failure", 1).show();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$stateCode;

        AnonymousClass5(final String val$stateCode) {
            this.val$stateCode = val$stateCode;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                SharedPref.getInstance(HomeFragment.this.getContext()).setProfileData(asJsonArray.toString());
                Logger.d("formatter.format(new Date())", HomeFragment.this.formatter.format(new Date()));
                SharedPref.getInstance(HomeFragment.this.getContext()).setCurrentDate(HomeFragment.this.formatter.format(new Date()));
                HomeFragment homeFragment = HomeFragment.this;
                homeFragment.getDobQualifying(this.val$stateCode, homeFragment.token);
                JsonObject asJsonObject = HomeFragment.this.gson.toJsonTree(asJsonArray.get(0)).getAsJsonObject();
                if (asJsonObject.get("specialRevision") != null && asJsonObject.get("specialRevision").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardSpecialRevision.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardSpecialRevision.setVisibility(8);
                }
                if (asJsonObject.get("electorMapping") != null && asJsonObject.get("electorMapping").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardElectorMapping.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardElectorMapping.setVisibility(8);
                }
                if (asJsonObject.get("dseActivity") != null && asJsonObject.get("dseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardDSEVerified.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardDSEVerified.setVisibility(8);
                }
                if (asJsonObject.get("selectPhoto") != null && asJsonObject.get("selectPhoto").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.selectphotocard.setVisibility(0);
                } else {
                    HomeFragment.this.binding.selectphotocard.setVisibility(8);
                }
                if (asJsonObject.get("webLogin") != null && asJsonObject.get("webLogin").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.webLogin.setVisibility(0);
                } else {
                    HomeFragment.this.binding.webLogin.setVisibility(8);
                }
                if (asJsonObject.get("formatC") != null && asJsonObject.get("formatC").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.formcCard.setVisibility(0);
                } else {
                    HomeFragment.this.binding.formcCard.setVisibility(8);
                }
                if (asJsonObject.get("bloNotification") != null) {
                    if (asJsonObject.get("bloNotification").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                        HomeFragment.this.binding.notiLayout.setVisibility(0);
                        return;
                    } else {
                        HomeFragment.this.binding.notiLayout.setVisibility(8);
                        return;
                    }
                }
                HomeFragment.this.binding.notiLayout.setVisibility(8);
                return;
            }
            SharedPref.getInstance(HomeFragment.this.getContext()).setProfileData("");
            SharedPref.getInstance(HomeFragment.this.getContext()).setCurrentDate("");
            HomeFragment homeFragment2 = HomeFragment.this;
            homeFragment2.getDobQualifying(this.val$stateCode, homeFragment2.token);
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                if (response.code() == 401) {
                    HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass1());
                } else if (response.code() == 417) {
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                } else {
                    HomeFragment.this.showdialog1("Alert", strOptString);
                }
            } catch (IOException | JSONException e) {
                if (response.code() == 401) {
                    HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass2());
                } else {
                    Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
                }
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5$1, reason: invalid class name */
        class AnonymousClass1 implements aadharcallback {
            AnonymousClass1() {
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCallBack$0(dialogInterface, i);
                        }
                    });
                    return;
                }
                if (code == 200) {
                    HomeFragment.this.token = "Bearer " + status;
                    HomeFragment.this.refreshToken = message;
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setToken("Bearer " + status);
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setRefreshToken(message);
                    HomeFragment.this.getBloAppProfile(AnonymousClass5.this.val$stateCode, HomeFragment.this.token);
                    return;
                }
                Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
                HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
            HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5$2, reason: invalid class name */
        class AnonymousClass2 implements aadharcallback {
            AnonymousClass2() {
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$5$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCallBack$0(dialogInterface, i);
                        }
                    });
                    return;
                }
                if (code == 200) {
                    HomeFragment.this.token = "Bearer " + status;
                    HomeFragment.this.refreshToken = message;
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setToken("Bearer " + status);
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setRefreshToken(message);
                    HomeFragment.this.getBloAppProfile(AnonymousClass5.this.val$stateCode, HomeFragment.this.token);
                    return;
                }
                Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
                HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            HomeFragment.this.alertDialog.dismiss();
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.getDobQualifying(this.val$stateCode, homeFragment.token);
            SharedPref.getInstance(HomeFragment.this.getContext()).setProfileData("");
            SharedPref.getInstance(HomeFragment.this.getContext()).setCurrentDate("");
            Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "API failure", 1).show();
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    public void getSirStatus(String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getSirFeatureStatusSIR(stateCode, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new Callback<SIRResponseData>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.6
                public void onResponse(Call<SIRResponseData> call, Response<SIRResponseData> response) {
                    if (response.code() == 200) {
                        SIRResponseData.StatusPaylod payload = ((SIRResponseData) response.body()).getPayload();
                        SharedPref.getInstance(HomeFragment.this.getContext()).setSirFlag(payload.getFlag());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setPendingElectors(payload.getPendingElectors());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setFillEnumerationForm(payload.getFillEnumerationForm());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setVerifyFormsFilled(payload.getVerifyFormsFilled());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setReverifyUploadDocs(payload.getReverifyUploadDocs());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setSentBackByEro(payload.getSentBackByEro());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setUploadEfForUncollected(payload.getUploadEfForUncollected());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setMarkUncollectableSentBack(payload.getMarkUncollectableSentBack());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setAlreadyFilledFormSentBack(payload.getAlreadyFilledFormSentBack());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setAlreadyFilledFormSentBackMarkUnButton(payload.getAlreadyFilledFormSentBackMarkUnButton());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setViewModifiedByAEROERO(payload.getViewModifiedByAEROERO());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setOfflineTab(payload.getOfflineTab());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setEfTrackerTab(payload.getEfDistributionTracker());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setScheduleHearingTab(payload.getScheduleHearingNotice());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setFaceRecognitionFlag(payload.getFaceRecognition());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setOnlineStatusFlag(payload.getIsOnlineSirFlag());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setAutoFaceDetection(payload.getAutoFaceDetection());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setElectorUpload(payload.getIsElectorUpload());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setlastSIRYear(payload.getLastSIRYear());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setEpicMatchEFFlag(payload.getEpicMatchFillEF());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setEfDashBoardTab(payload.getEfDashBoard());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setverifyMarkUncollectable(payload.getVerifyMarkUncollectable());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setreverifyMarkUncollectable(payload.getReverifyMarkUncollectable());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setDeceasedElectors(payload.getDeceasedElectors());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setElectorsAnomaly(payload.getElectorsAnomaly());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setefPhotoFlag(payload.getEfPhotoFlag());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setDuplicateVerification(payload.getDuplicateVerification());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setuploadBLOMOM(payload.getUploadBLOMOM());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setAnomaly(payload.getAnomaly());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setFormCounts(payload.getFormsCount());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setPseVerification(payload.getPseVerification());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setdraftList(payload.getDraftList());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setNoMapping(payload.getNoMapping());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setSelectPhoto(payload.getSelectPhoto());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setviewDocCitizen(payload.getViewDocCitizen());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setUploadAttendence(payload.getUploadAttendance());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setupdateMobile(payload.getUpdateMobile());
                        return;
                    }
                    Logger.d("coming in onFailure ", "API error code");
                }

                public void onFailure(Call<SIRResponseData> call, Throwable t) {
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
        }
    }

    public void getDobQualifying(final String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getDobQualifying(stateCode, this.asmblyNO, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "GARUDA").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.7
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        JsonObject jsonObject = (JsonObject) response.body();
                        Logger.d("dobqualifyingdate", String.valueOf(jsonObject.get("message")));
                        try {
                            if (jsonObject.get("message") != null && !jsonObject.get("message").equals("")) {
                                String str = (Integer.parseInt(jsonObject.get("message").getAsString().split("-")[0]) - 18) + "-10-01";
                                Logger.d("dobqualifyingdate", HomeFragment.this.formatter.format(HomeFragment.this.formatter1.parse(str)));
                                SharedPref.getInstance(HomeFragment.this.getContext()).setDobQualifyingDate(HomeFragment.this.formatter.format(HomeFragment.this.formatter1.parse(str)));
                            } else {
                                Logger.d("dobqualifyingdate else ", "");
                                SharedPref.getInstance(HomeFragment.this.getContext()).setDobQualifyingDate("01/10/2006");
                            }
                            return;
                        } catch (Exception e) {
                            Logger.d("", e.getMessage());
                            return;
                        }
                    }
                    SharedPref.getInstance(HomeFragment.this.getContext()).setDobQualifyingDate("01/10/2006");
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                        if (response.code() == 401) {
                            HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass1());
                        } else {
                            Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error - " + strOptString, 1).show();
                        }
                    } catch (IOException | JSONException e2) {
                        if (response.code() == 401) {
                            HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass2());
                        } else {
                            Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
                        }
                        Logger.d("", e2.getMessage());
                    }
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$7$1, reason: invalid class name */
                class AnonymousClass1 implements aadharcallback {
                    AnonymousClass1() {
                    }

                    @Override // in.gov.eci.bloapp.aadharcallback
                    public void onCallBack(int code, String status, String message) {
                        if (code == 401) {
                            HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$7$1$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$onCallBack$0(dialogInterface, i);
                                }
                            });
                            return;
                        }
                        if (code == 200) {
                            HomeFragment.this.token = "Bearer " + status;
                            HomeFragment.this.refreshToken = message;
                            SharedPref.getInstance(HomeFragment.this.requireContext()).setToken("Bearer " + status);
                            SharedPref.getInstance(HomeFragment.this.requireContext()).setRefreshToken(message);
                            return;
                        }
                        Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
                        HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$7$2, reason: invalid class name */
                class AnonymousClass2 implements aadharcallback {
                    AnonymousClass2() {
                    }

                    @Override // in.gov.eci.bloapp.aadharcallback
                    public void onCallBack(int code, String status, String message) {
                        if (code == 401) {
                            HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$7$2$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$onCallBack$0(dialogInterface, i);
                                }
                            });
                            return;
                        }
                        if (code == 200) {
                            HomeFragment.this.token = "Bearer " + status;
                            HomeFragment.this.refreshToken = message;
                            SharedPref.getInstance(HomeFragment.this.requireContext()).setToken("Bearer " + status);
                            SharedPref.getInstance(HomeFragment.this.requireContext()).setRefreshToken(message);
                            HomeFragment.this.getDobQualifying(stateCode, HomeFragment.this.token);
                            return;
                        }
                        Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
                        HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    HomeFragment.this.alertDialog.dismiss();
                    SharedPref.getInstance(HomeFragment.this.getContext()).setDobQualifyingDate("01/10/2006");
                    Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "API failure", 1).show();
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
            Toast.makeText(getContext().getApplicationContext(), "API failure", 1).show();
        }
    }

    private void getAllState() {
        this.commomUtility.getState(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda20
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllState$18(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllState$18(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$getAllState$17(i2, str, str2);
                }
            });
            return;
        }
        this.statename = arrayList;
        this.statecode1 = arrayList2;
        SharedPref.getInstance(getContext()).saveAcListName(this.statename, Constants.STATE_LIST_NAME);
        SharedPref.getInstance(getContext()).saveAcListCode(this.statecode1, Constants.STATE_LIST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllState$17(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda21
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllState$16(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(getContext()).setRefreshToken(str2);
        SharedPref.getInstance(getContext()).setToken("Bearer " + str);
        getAllState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllState$16(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getContext()).setLocaleBool(false);
        startActivity(new Intent(getContext(), (Class<?>) LoginActivity.class));
    }

    private void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getRelationList(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.8
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    JsonObject jsonObject = (JsonObject) response.body();
                    if (jsonObject != null) {
                        HomeFragment.this.relationNameSpinnerVal.add(HomeFragment.this.selectRelationType);
                        HomeFragment.this.relationCodeSpinnerVal.add("");
                        for (String str : jsonObject.keySet()) {
                            String asString = jsonObject.get(str).getAsString();
                            HomeFragment.this.relationNameSpinnerVal.add(str);
                            HomeFragment.this.relationCodeSpinnerVal.add(asString);
                            System.out.println("Key: " + str + ", Value: " + asString);
                        }
                        SharedPref.getInstance(HomeFragment.this.getActivity()).saveRelativeListName(HomeFragment.this.relationNameSpinnerVal, Constants.RELATIVE_MAPPING_LIST_NAME);
                        SharedPref.getInstance(HomeFragment.this.getActivity()).saveRelativeListCode(HomeFragment.this.relationCodeSpinnerVal, Constants.RELATIVE_MAPPING_LIST_CODE);
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    Logger.e(ElectorDataSyncFragment.TAG, new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException e) {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    Logger.e(ElectorDataSyncFragment.TAG, e.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (HomeFragment.this.alertDialog != null) {
                    HomeFragment.this.alertDialog.dismiss();
                }
                Logger.d(ElectorDataSyncFragment.TAG, "OnFailure" + t.getMessage());
            }
        });
    }

    public void getTrainingStatus() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.stateCode);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getTrainingStatus(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.9
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    if (jsonObject != null) {
                        Log.d("payloaddddd", jsonObject.toString());
                        String asString = ((JsonObject) response.body()).get("message").getAsString();
                        SharedPref.getInstance(HomeFragment.this.getContext()).setTrainingStatus(((JsonObject) response.body()).get("payload").getAsInt());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setTrainingMessage(asString);
                        Log.d("messload", String.valueOf(SharedPref.getInstance(HomeFragment.this.getContext()).getTrainingStatus()));
                        Log.d("messload", String.valueOf(SharedPref.getInstance(HomeFragment.this.getContext()).getTrainingMessage()));
                        return;
                    }
                    return;
                }
                response.code();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(ElectorDataSyncFragment.TAG, "OnFailure" + t.getMessage());
            }
        });
    }

    private void alertDialog_sir() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        View viewInflate = getLayoutInflater().inflate(R.layout.alert_dialog_sir, (ViewGroup) null);
        builder.setView(viewInflate);
        final android.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) viewInflate.findViewById(2131364212)).setText(String.valueOf(SharedPref.getInstance(getContext()).getTrainingMessage()));
        Button button = (Button) viewInflate.findViewById(R.id.yes);
        Button button2 = (Button) viewInflate.findViewById(R.id.no);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_sir$19(alertDialogCreate, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_sir$20(alertDialogCreate, view);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_sir$19(android.app.AlertDialog alertDialog, View view) {
        postTrainingStatus(1);
        Log.d("Yes", "Yes");
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_sir$20(android.app.AlertDialog alertDialog, View view) {
        postTrainingStatus(2);
        Log.d("No", "No");
        alertDialog.dismiss();
    }

    private void postTrainingStatus(final int status) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.stateCode);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        this.alertDialog.show();
        HashMap map2 = new HashMap();
        map2.put("status", Integer.valueOf(status));
        Call<JsonObject> callPostTrainingStatus = ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).postTrainingStatus(map, map2);
        Log.d("here1", "here1");
        callPostTrainingStatus.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Toast.makeText(HomeFragment.this.requireContext(), String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setTrainingStatus(status);
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                if (HomeFragment.this.alertDialog != null) {
                    HomeFragment.this.alertDialog.dismiss();
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(HomeFragment.this.requireContext(), new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                    }
                } catch (Exception e) {
                    Logger.d("Training Status", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (HomeFragment.this.alertDialog != null) {
                    HomeFragment.this.alertDialog.dismiss();
                }
                Logger.d(ElectorDataSyncFragment.TAG, "OnFailure" + t.getMessage());
            }
        });
    }

    private void askNotificationPermission() {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        this.requestNotifications.launch("android.permission.POST_NOTIFICATIONS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$21(Boolean bool) {
        if (bool.booleanValue()) {
            Toast.makeText((Context) getActivity(), (CharSequence) "Notification Permission Granted", 0).show();
        } else {
            Toast.makeText((Context) getActivity(), (CharSequence) "Permission Denied", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateBellSwing(final ImageView bell) {
        bell.post(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.lambda$animateBellSwing$22(bell);
            }
        });
    }

    static /* synthetic */ void lambda$animateBellSwing$22(ImageView imageView) {
        imageView.setPivotX(imageView.getWidth() / 2.0f);
        imageView.setPivotY(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, -20.0f, 15.0f, -10.0f, 5.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.start();
    }
}
