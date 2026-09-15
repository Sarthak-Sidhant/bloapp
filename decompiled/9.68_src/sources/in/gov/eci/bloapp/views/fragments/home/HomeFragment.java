package in.gov.eci.bloapp.views.fragments.home;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import com.yalantis.ucrop.view.CropImageView;
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
import in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity;
import in.gov.eci.bloapp.views.activity.FomatCListActivity;
import in.gov.eci.bloapp.views.activity.H2HDashBoard;
import in.gov.eci.bloapp.views.activity.Housetohouse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
import in.gov.eci.bloapp.views.activity.PseVerifiedListActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.WebLoginActivity;
import in.gov.eci.bloapp.views.activity.facility;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity;
import in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity;
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
import org.apache.commons.lang3.StringUtils;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
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
    ArrayList<String> statecodeallowedList;
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
    private final ActivityResultLauncher<String> requestNotifications = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda25
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$29((Boolean) obj);
        }
    });
    String packageBundle = "package";

    static /* synthetic */ void lambda$checkNotificationPermission$32(DialogInterface dialogInterface, int i) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AlertDialog alertDialog;
        this.binding = BloFragmentHomeBinding.inflate(getLayoutInflater());
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.viewModel = (MainActivityViewModel) new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.stateCode = SharedPref.getInstance(requireActivity()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.asmblyName = SharedPref.getInstance(requireActivity()).getAssemblyName();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (!TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole()) && SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) {
            this.binding.cardFacilities.setVisibility(8);
            this.binding.cardChecklist.setVisibility(8);
            this.binding.cardForms.setVisibility(8);
            this.binding.cardH2HSurvey.setVisibility(8);
            this.binding.cardH2HDashboardForms.setVisibility(8);
            this.binding.cardDse.setVisibility(8);
            this.binding.cardPSE.setVisibility(8);
            this.binding.notiLayout.setVisibility(8);
            this.binding.cardCallRequestMAin.setVisibility(8);
            this.binding.cardBla.setVisibility(8);
            this.binding.cardElectorMapping.setVisibility(8);
            this.binding.cardSpecialRevision.setVisibility(0);
            this.binding.cardDSEVerified.setVisibility(8);
            this.binding.selectphotocard.setVisibility(8);
            this.binding.webLogin.setVisibility(8);
            this.binding.pseActivity.setVisibility(8);
            this.binding.formcCard.setVisibility(8);
            this.binding.cardView2.setVisibility(8);
            this.binding.cardView1.setVisibility(8);
            this.binding.cardAddNotional.setVisibility(8);
            if (TextUtils.isEmpty(SharedPref.getInstance(getContext()).getSupervisorData()) && (alertDialog = this.alertDialog) != null) {
                alertDialog.show();
                getBloSupervisorData(this.stateCode, this.token);
            }
            this.binding.textViewConstituencyHeader.setText(String.format(getString(R.string.blo_constituency_details), new Object[0]));
            this.binding.textViewConstituencyDetails.setText(this.asmblyNO + " | " + SharedPref.getInstance(requireContext()).getAssemblyName());
        } else {
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
            allowedStateCodeList();
            getBloAppProfile(this.stateCode, this.token);
            getSirStatus(this.stateCode, this.token);
            getNotification(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAssemblyNumber());
            Logger.d("BLODetails", this.blofName + this.bloLname + this.bloPhoneNumber);
            this.binding.textViewConstituencyHeader.setText(String.format(getString(R.string.blo_constituency_details), new Object[0]) + " | " + String.format(getString(R.string.blo_part_number), new Object[0]));
            this.binding.textViewConstituencyDetails.setText(this.asmblyNO + " | " + this.asmblyName + " | " + this.partNo);
        }
        this.binding.cardView1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda28
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
        this.binding.pseActivity.setOnClickListener(this);
        this.binding.cardEpicDelivery.setOnClickListener(this);
        this.binding.CardAT.setOnClickListener(this);
        this.binding.MarkVipCard.setOnClickListener(this);
        this.binding.cardAddNotional.setOnClickListener(this);
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
                HomeFragment.this.bloPhoneNumber = jsonObject.get("mobileNumber").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                HomeFragment.this.blofName = jsonObject.get("userFname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                HomeFragment.this.bloLname = jsonObject.get("userLname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
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
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$0();
            }
        }, 1000L);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$2();
            }
        }, 1000L);
        startActivity(new Intent((Context) getActivity(), (Class<?>) DashboardBLOActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2() {
        this.alertDialog.dismiss();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> arrayList = this.statecodeallowedList;
        if (arrayList != null && !arrayList.isEmpty() && this.statecodeallowedList.contains(this.stateCode)) {
            if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
                getTrainingStatus();
                return;
            } else {
                if (SharedPref.getInstance(requireContext()).getEroAppStatus() == 0 || SharedPref.getInstance(requireContext()).getEroAppStatus() == 2) {
                    getEroNetAppStatus();
                    return;
                }
                return;
            }
        }
        if (SharedPref.getInstance(requireContext()).getEroAppStatus() == 0 || SharedPref.getInstance(requireContext()).getEroAppStatus() == 2) {
            getEroNetAppStatus();
        }
    }

    private void allowedStateCodeList() {
        ArrayList<String> arrayList = this.statecodeallowedList;
        if (arrayList != null && arrayList.size() > 0) {
            this.statecodeallowedList.clear();
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.statecodeallowedList = arrayList2;
        arrayList2.add("S01");
        this.statecodeallowedList.add("S02");
        this.statecodeallowedList.add("S07");
        this.statecodeallowedList.add("S10");
        this.statecodeallowedList.add("S13");
        this.statecodeallowedList.add("S14");
        this.statecodeallowedList.add("S15");
        this.statecodeallowedList.add("S16");
        this.statecodeallowedList.add("S17");
        this.statecodeallowedList.add("S18");
        this.statecodeallowedList.add("S19");
        this.statecodeallowedList.add("S21");
        this.statecodeallowedList.add("S23");
        this.statecodeallowedList.add("S27");
        this.statecodeallowedList.add("S28");
        this.statecodeallowedList.add("S29");
        this.statecodeallowedList.add("U02");
        this.statecodeallowedList.add("U03");
        this.statecodeallowedList.add("U05");
    }

    public String getDeviceIdd() {
        return Settings.Secure.getString(requireContext().getContentResolver(), "android_id");
    }

    public String getDeviceName() {
        return Build.BRAND + StringUtils.SPACE + Build.MANUFACTURER + "  " + Build.MODEL;
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
            ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getAllIsSeenCount(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.4
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

    /* JADX WARN: Code duplicated, block: B:117:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:11:0x006b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0691  */
    /* JADX WARN: Code duplicated, block: B:137:0x0696  */
    /* JADX WARN: Code duplicated, block: B:138:0x069b  */
    /* JADX WARN: Code duplicated, block: B:140:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:156:0x0776  */
    /* JADX WARN: Code duplicated, block: B:158:0x077b  */
    /* JADX WARN: Code duplicated, block: B:174:0x084f  */
    /* JADX WARN: Code duplicated, block: B:176:0x0854  */
    /* JADX WARN: Code duplicated, block: B:192:0x092f  */
    /* JADX WARN: Code duplicated, block: B:194:0x0934  */
    /* JADX WARN: Code duplicated, block: B:210:0x0a0f  */
    /* JADX WARN: Code duplicated, block: B:212:0x0a14  */
    /* JADX WARN: Code duplicated, block: B:228:0x0aec  */
    /* JADX WARN: Code duplicated, block: B:230:0x0af1  */
    /* JADX WARN: Code duplicated, block: B:246:0x0bc9  */
    /* JADX WARN: Code duplicated, block: B:248:0x0bce  */
    /* JADX WARN: Code duplicated, block: B:249:0x0be3  */
    /* JADX WARN: Code duplicated, block: B:251:0x0be8  */
    /* JADX WARN: Code duplicated, block: B:27:0x012f  */
    /* JADX WARN: Code duplicated, block: B:281:0x0d37  */
    /* JADX WARN: Code duplicated, block: B:283:0x0d3c  */
    /* JADX WARN: Code duplicated, block: B:299:0x0e12  */
    /* JADX WARN: Code duplicated, block: B:301:0x0e17  */
    /* JADX WARN: Code duplicated, block: B:317:0x0eed  */
    /* JADX WARN: Code duplicated, block: B:319:0x0ef2  */
    /* JADX WARN: Code duplicated, block: B:335:0x0fc6  */
    /* JADX WARN: Code duplicated, block: B:337:0x0fcb  */
    /* JADX WARN: Code duplicated, block: B:344:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x03f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:348:0x02fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:355:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:0x05b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:357:0x04d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:407:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0213  */
    /* JADX WARN: Code duplicated, block: B:63:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:81:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:99:0x04cd  */
    @Override // android.view.View.OnClickListener
    public void onClick(final View v) {
        String str;
        int id = v.getId();
        if (!TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole())) {
            str = "bla2Creation";
            if (!SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) {
            }
            if (id == 2131362657) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            if (this.gson.toJsonTree(((JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData())).get(0)).getAsJsonObject().get(this.facility).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) facility.class));
                            }
                        } catch (Exception e) {
                            Logger.d("absdaf ", e.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$4(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131362653) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData3 ", String.valueOf(jSONArray));
                            JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf3 ", String.valueOf(asJsonObject.get(this.checklist)));
                            if (asJsonObject.get(this.checklist).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) CheckList.class));
                            }
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda15
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
            if (id == 2131362658) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            JSONArray jSONArray2 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData5 ", String.valueOf(jSONArray2));
                            JsonObject asJsonObject2 = this.gson.toJsonTree(jSONArray2.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf5 ", String.valueOf(asJsonObject2.get(this.forms)));
                            if (asJsonObject2.get(this.forms).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) VoterForms.class));
                            }
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda16
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
            if (id == 2131362660) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            JSONArray jSONArray3 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData7 ", String.valueOf(jSONArray3));
                            JsonObject asJsonObject3 = this.gson.toJsonTree(jSONArray3.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf7 ", String.valueOf(asJsonObject3.get("h2h")));
                            if (asJsonObject3.get("h2h").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                SharedPref.getInstance(getContext()).setAllHousesData("");
                                SharedPref.getInstance(getContext()).setSearchedAllHousesData("");
                                startActivity(new Intent(v.getContext(), (Class<?>) Housetohouse.class));
                            }
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda17
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
            if (id == 2131362663) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            return;
                        }
                        JSONArray jSONArray4 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData9 ", String.valueOf(jSONArray4));
                        JsonObject asJsonObject4 = this.gson.toJsonTree(jSONArray4.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf9 ", String.valueOf(asJsonObject4.get("pse")));
                        if (asJsonObject4.get("pse").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) PseActivity.class));
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda18
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
            if (id == 2131362659) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            JSONArray jSONArray5 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData11 ", String.valueOf(jSONArray5));
                            JsonObject asJsonObject5 = this.gson.toJsonTree(jSONArray5.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject5.get(this.bloRegister)));
                            if (asJsonObject5.get(this.bloRegister).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) H2HDashBoard.class));
                            }
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda19
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
            if (id == 2131362655) {
                try {
                    if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                        if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                            return;
                        }
                        JSONArray jSONArray6 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData13 ", String.valueOf(jSONArray6));
                        JsonObject asJsonObject6 = this.gson.toJsonTree(jSONArray6.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf13 ", String.valueOf(asJsonObject6.get("des")));
                        if (asJsonObject6.get("des").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) DseActivity.class));
                        }
                        this.alertDialog.dismiss();
                        return;
                    }
                    getBloAppProfile(this.stateCode, this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda20
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
            if (id == 2131365054) {
                askNotificationPermission();
                return;
            }
            if (id == 2131366993) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray7 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray7));
                            JsonObject asJsonObject7 = this.gson.toJsonTree(jSONArray7.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject7.get("webLogin")));
                            if (asJsonObject7.get("webLogin").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) WebLoginActivity.class));
                            }
                        } catch (Exception e8) {
                            Logger.d("absdaf ", e8.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda21
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$11(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131365477) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray8 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray8));
                            JsonObject asJsonObject8 = this.gson.toJsonTree(jSONArray8.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject8.get("pseActivity")));
                            if (asJsonObject8.get("pseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) PseVerifiedListActivity.class));
                            }
                        } catch (Exception e9) {
                            Logger.d("absdaf ", e9.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda23
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$12(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131362687) {
                this.alertDialog.dismiss();
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray9 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray9));
                            JsonObject asJsonObject9 = this.gson.toJsonTree(jSONArray9.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf17 ", String.valueOf(asJsonObject9.get("epicDelivery")));
                            if (asJsonObject9.get("epicDelivery").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) EpicDeliveryListActivity.class));
                            }
                        } catch (Exception e10) {
                            Logger.d("absdaf ", e10.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$13(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131361819) {
                this.alertDialog.dismiss();
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray10 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray10));
                            JsonObject asJsonObject10 = this.gson.toJsonTree(jSONArray10.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf18 ", String.valueOf(asJsonObject10.get("atModule")));
                            if (asJsonObject10.get("atModule").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) ATModuleNoticeListActivity.class));
                            }
                        } catch (Exception e11) {
                            Logger.d("absdaf ", e11.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$14(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131361931) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray11 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray11));
                            JsonObject asJsonObject11 = this.gson.toJsonTree(jSONArray11.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf20 ", String.valueOf(asJsonObject11.get("vipElectors")));
                            if (asJsonObject11.get("vipElectors").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) MarkVipListActivity.class));
                            }
                        } catch (Exception e12) {
                            Logger.d("absdaf ", e12.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$15(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131362650) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray12 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray12));
                            JsonObject asJsonObject12 = this.gson.toJsonTree(jSONArray12.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf21 ", String.valueOf(asJsonObject12.get("notionalHnoUpdate")));
                            if (asJsonObject12.get("notionalHnoUpdate").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) AddNotionalListActivity.class));
                            }
                        } catch (Exception e13) {
                            Logger.d("absdaf ", e13.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$16(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131362652) {
                startActivity(new Intent((Context) getActivity(), (Class<?>) callRequestMain.class));
                this.alertDialog.dismiss();
                return;
            }
            if (id == 2131362664) {
                if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole()) && SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) {
                    startActivity(new Intent(v.getContext(), (Class<?>) BloSuperVisorActivity.class));
                    return;
                }
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray13 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray13));
                            JsonObject asJsonObject13 = this.gson.toJsonTree(jSONArray13.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject13.get("specialRevision")));
                            if (asJsonObject13.get("specialRevision").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                if (SharedPref.getInstance(requireContext()).getTrainingStatus() == 0 || SharedPref.getInstance(requireContext()).getTrainingStatus() == 2) {
                                    if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getTrainingMessage())) {
                                        startActivity(new Intent(v.getContext(), (Class<?>) SIRLanguageSelection.class));
                                    } else {
                                        alertDialog_sir();
                                    }
                                } else {
                                    startActivity(new Intent(v.getContext(), (Class<?>) SIRLanguageSelection.class));
                                }
                            }
                        } catch (Exception e14) {
                            Logger.d("absdaf ", e14.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$17(v);
                    }
                }, 2000L);
                return;
            }
            if (id == 2131362651) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray14 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray14));
                            JsonObject asJsonObject14 = this.gson.toJsonTree(jSONArray14.get(0)).getAsJsonObject();
                            String str2 = str;
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject14.get(str2)));
                            if (asJsonObject14.get(str2).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) BlaActivity.class));
                            }
                        } catch (Exception e15) {
                            Logger.d("absdaf ", e15.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$18(v);
                    }
                }, 2000L);
            }
            if (id == 2131362656) {
                if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                    if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                        try {
                            JSONArray jSONArray15 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                            Logger.d("profileData1 ", String.valueOf(jSONArray15));
                            JsonObject asJsonObject15 = this.gson.toJsonTree(jSONArray15.get(0)).getAsJsonObject();
                            Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject15.get("electorMapping")));
                            if (asJsonObject15.get("electorMapping").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                                startActivity(new Intent(v.getContext(), (Class<?>) ElectorMappingMainLayout.class));
                            }
                        } catch (Exception e16) {
                            Logger.d("absdaf ", e16.getMessage());
                        }
                    }
                    this.alertDialog.dismiss();
                    return;
                }
                getBloAppProfile(this.stateCode, this.token);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$19(v);
                    }
                }, 2000L);
            }
            if (id != 2131362654) {
                if (id == 2131365878) {
                    this.alertDialog.dismiss();
                    startActivity(new Intent(v.getContext(), (Class<?>) NonSirSelectPhotoListActivity.class));
                }
            }
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null && !SharedPref.getInstance(requireContext()).getCurrentDate().equals("") && SharedPref.getInstance(requireContext()).getCurrentDate().equals(this.formatter.format(new Date()))) {
                if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                    try {
                        JSONArray jSONArray16 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                        Logger.d("profileData1 ", String.valueOf(jSONArray16));
                        JsonObject asJsonObject16 = this.gson.toJsonTree(jSONArray16.get(0)).getAsJsonObject();
                        Logger.d("acbsfvnmsf vmf11 ", String.valueOf(asJsonObject16.get("dseActivity")));
                        if (asJsonObject16.get("dseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                            startActivity(new Intent(v.getContext(), (Class<?>) DseVerifiedListActivity.class));
                        }
                    } catch (Exception e17) {
                        Logger.d("absdaf ", e17.getMessage());
                    }
                }
                this.alertDialog.dismiss();
                return;
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$20(v);
                }
            }, 2000L);
        }
        str = "bla2Creation";
        this.alertDialog.show();
        if (id == 2131362657) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$4(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362653) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$5(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362658) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$6(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362660) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$7(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362663) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$8(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362659) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$9(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362655) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$10(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131365054) {
            askNotificationPermission();
            return;
        }
        if (id == 2131366993) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$11(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131365477) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$12(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362687) {
            this.alertDialog.dismiss();
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$13(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131361819) {
            this.alertDialog.dismiss();
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$14(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131361931) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$15(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362650) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$16(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362652) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) callRequestMain.class));
            this.alertDialog.dismiss();
            return;
        }
        if (id == 2131362664) {
            if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole())) {
            }
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$17(v);
                }
            }, 2000L);
            return;
        }
        if (id == 2131362651) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$18(v);
                }
            }, 2000L);
        } else if (id == 2131362656) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$19(v);
                }
            }, 2000L);
        } else if (id != 2131362654) {
            if (SharedPref.getInstance(requireContext()).getCurrentDate() == null) {
            }
            getBloAppProfile(this.stateCode, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$20(v);
                }
            }, 2000L);
        } else if (id == 2131365878) {
            this.alertDialog.dismiss();
            startActivity(new Intent(v.getContext(), (Class<?>) NonSirSelectPhotoListActivity.class));
        }
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
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("pseActivity")));
                if (asJsonObject.get("pseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) PseVerifiedListActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) PseVerifiedListActivity.class));
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
                Logger.d("acbsfvnmsf vmf17 ", String.valueOf(asJsonObject.get("epicDelivery")));
                if (asJsonObject.get("epicDelivery").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) EpicDeliveryListActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) EpicDeliveryListActivity.class));
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
                Logger.d("acbsfvnmsf vmf18 ", String.valueOf(asJsonObject.get("atModule")));
                if (asJsonObject.get("atModule").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) ATModuleNoticeListActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) ATModuleNoticeListActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$15(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf20 ", String.valueOf(asJsonObject.get("vipElectors")));
                if (asJsonObject.get("vipElectors").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) MarkVipListActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) MarkVipListActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$16(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf21 ", String.valueOf(asJsonObject.get("notionalHnoUpdate")));
                if (asJsonObject.get("notionalHnoUpdate").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) AddNotionalListActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) AddNotionalListActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$17(View view) {
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
    public /* synthetic */ void lambda$onClick$18(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("bla2Creation")));
                if (asJsonObject.get("bla2Creation").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) BlaActivity.class));
                }
            } else if (SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                startActivity(new Intent(view.getContext(), (Class<?>) BlaActivity.class));
            }
        } catch (Exception e) {
            Logger.d("xdbcjfbv1 ", e.getMessage());
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$19(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("electorMapping")));
                if (asJsonObject.get("electorMapping").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) ElectorMappingMainLayout.class));
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
    public /* synthetic */ void lambda$onClick$20(View view) {
        try {
            Logger.d("ndsfbvhfv1 ", SharedPref.getInstance(requireContext()).getProfileData());
            if (!SharedPref.getInstance(requireContext()).getProfileData().equals("")) {
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getProfileData());
                Logger.d("profileData2 ", String.valueOf(jSONArray));
                JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
                Logger.d("acbsfvnmsf vmf2 ", String.valueOf(asJsonObject.get("dseActivity")));
                if (asJsonObject.get("dseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    startActivity(new Intent(view.getContext(), (Class<?>) DseVerifiedListActivity.class));
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
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void getBloAppProfile(String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getBloAppProfile(stateCode, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new AnonymousClass5(stateCode));
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
                if (asJsonObject.get("pseActivity") != null && asJsonObject.get("pseActivity").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.pseActivity.setVisibility(0);
                } else {
                    HomeFragment.this.binding.pseActivity.setVisibility(8);
                }
                if (asJsonObject.get("formatC") != null && asJsonObject.get("formatC").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.formcCard.setVisibility(0);
                } else {
                    HomeFragment.this.binding.formcCard.setVisibility(8);
                }
                if (asJsonObject.get("notionalHnoUpdate") != null && asJsonObject.get("notionalHnoUpdate").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardAddNotional.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardAddNotional.setVisibility(8);
                }
                if (asJsonObject.get("bloNotification") != null && asJsonObject.get("bloNotification").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.notiLayout.setVisibility(0);
                } else {
                    HomeFragment.this.binding.notiLayout.setVisibility(8);
                }
                if (asJsonObject.get("epicDelivery") != null && asJsonObject.get("epicDelivery").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardEpicDelivery.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardEpicDelivery.setVisibility(8);
                }
                if (asJsonObject.get("atModule") != null && asJsonObject.get("atModule").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.CardAT.setVisibility(0);
                } else {
                    HomeFragment.this.binding.CardAT.setVisibility(8);
                }
                if (asJsonObject.get("vipElectors") != null && asJsonObject.get("vipElectors").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.MarkVipCard.setVisibility(0);
                } else {
                    HomeFragment.this.binding.MarkVipCard.setVisibility(8);
                }
                if (asJsonObject.get("facility") != null && asJsonObject.get("facility").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardFacilities.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardFacilities.setVisibility(8);
                }
                if (asJsonObject.get("checklist") != null && asJsonObject.get("checklist").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardChecklist.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardChecklist.setVisibility(8);
                }
                if (asJsonObject.get("h2h") != null && asJsonObject.get("h2h").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardH2HSurvey.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardH2HSurvey.setVisibility(8);
                }
                if (asJsonObject.get("bloRegister") != null && asJsonObject.get("bloRegister").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardH2HDashboardForms.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardH2HDashboardForms.setVisibility(8);
                }
                if (asJsonObject.get("des") != null && asJsonObject.get("des").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardDse.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardDse.setVisibility(8);
                }
                if (asJsonObject.get("pse") != null && asJsonObject.get("pse").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardPSE.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardPSE.setVisibility(8);
                }
                if (asJsonObject.get("forms") != null && asJsonObject.get("forms").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    HomeFragment.this.binding.cardForms.setVisibility(0);
                } else {
                    HomeFragment.this.binding.cardForms.setVisibility(8);
                }
                if (asJsonObject.get("bla2Creation") != null) {
                    if (asJsonObject.get("bla2Creation").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                        HomeFragment.this.binding.cardBla.setVisibility(0);
                        return;
                    } else {
                        HomeFragment.this.binding.cardBla.setVisibility(8);
                        return;
                    }
                }
                HomeFragment.this.binding.cardBla.setVisibility(8);
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
                } else if (response.code() == 417 || response.code() == 409) {
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
            SharedPref.getInstance(HomeFragment.this.requireContext()).clear();
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
            HomeFragment.this.checkStateCodeSirState();
            Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "API failure", 1).show();
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStateCodeSirState() {
        if (isValide19SIRState(this.stateCode)) {
            this.binding.cardSpecialRevision.setVisibility(0);
        } else {
            this.binding.cardSpecialRevision.setVisibility(8);
        }
    }

    public void getBloSupervisorData(String stateCode, String Token) {
        try {
            UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", Token);
            map.put("currentRole", "blos");
            map.put("state", stateCode);
            map.put("Content-Type", "application/json");
            map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
            map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
            map.put("channelidobo", "BLOAPP");
            userClient.getBloSupervisorData(map, new HashMap()).enqueue(new AnonymousClass6());
        } catch (Exception unused) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            Toast.makeText(getContext().getApplicationContext(), "API failure", 1).show();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        AnonymousClass6() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (HomeFragment.this.alertDialog != null) {
                    HomeFragment.this.alertDialog.dismiss();
                }
                if (response.body() != null) {
                    SharedPref.getInstance(HomeFragment.this.getContext()).setSupervisorData(HomeFragment.this.gson.toJson(((JsonObject) response.body()).get("data")));
                    SharedPref.getInstance(HomeFragment.this.getContext()).setAssemblyName(((JsonObject) response.body()).get("assemblyName").isJsonNull() ? "" : ((JsonObject) response.body()).get("assemblyName").getAsString());
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setLanguageName(((JsonObject) response.body()).get("acL1").isJsonNull() ? "" : ((JsonObject) response.body()).get("acL1").getAsString());
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setLanguageName2(((JsonObject) response.body()).get("acL2").isJsonNull() ? "" : ((JsonObject) response.body()).get("acL2").getAsString());
                }
                HomeFragment.this.binding.textViewConstituencyHeader.setText(String.format(HomeFragment.this.getString(R.string.blo_constituency_details), new Object[0]));
                HomeFragment.this.binding.textViewConstituencyDetails.setText(HomeFragment.this.asmblyNO + " | " + SharedPref.getInstance(HomeFragment.this.requireContext()).getAssemblyName());
                return;
            }
            if (HomeFragment.this.alertDialog != null) {
                HomeFragment.this.alertDialog.dismiss();
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                if (response.code() == 401) {
                    HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass1());
                    return;
                }
                if (response.code() == 417) {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                } else {
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    HomeFragment.this.showdialog1("Alert", strOptString);
                }
            } catch (IOException | JSONException e) {
                if (HomeFragment.this.alertDialog != null) {
                    HomeFragment.this.alertDialog.dismiss();
                }
                if (response.code() == 401) {
                    HomeFragment.this.commomUtility.getRefreshToken(HomeFragment.this.requireContext(), HomeFragment.this.refreshToken, new AnonymousClass2());
                } else {
                    Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "Error", 1).show();
                }
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6$1, reason: invalid class name */
        class AnonymousClass1 implements aadharcallback {
            AnonymousClass1() {
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6$1$$ExternalSyntheticLambda0
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
                SharedPref.getInstance(HomeFragment.this.requireContext()).clear();
                SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
                HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(HomeFragment.this.requireContext()).clear();
            SharedPref.getInstance(HomeFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(HomeFragment.this.requireContext()).setLocaleBool(false);
            HomeFragment.this.startActivity(new Intent((Context) HomeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6$2, reason: invalid class name */
        class AnonymousClass2 implements aadharcallback {
            AnonymousClass2() {
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$6$2$$ExternalSyntheticLambda0
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

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (HomeFragment.this.alertDialog != null) {
                HomeFragment.this.alertDialog.dismiss();
            }
        }
    }

    public void getSirStatus(String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getSirFeatureStatusSIR(stateCode, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new Callback<SIRResponseData>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.7
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
                        SharedPref.getInstance(HomeFragment.this.getContext()).setmigratedElectors(payload.getMigratedElectors());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setpostDraft(payload.getPostDraft());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setPostAnomaly(payload.getViewPostAnomaly());
                        SharedPref.getInstance(HomeFragment.this.getContext()).setAdditionalCommentTab(payload.getAdditionalCommentTab());
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
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getDobQualifying(stateCode, this.asmblyNO, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "GARUDA").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.8
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

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$8$1, reason: invalid class name */
                class AnonymousClass1 implements aadharcallback {
                    AnonymousClass1() {
                    }

                    @Override // in.gov.eci.bloapp.aadharcallback
                    public void onCallBack(int code, String status, String message) {
                        if (code == 401) {
                            HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$8$1$$ExternalSyntheticLambda0
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

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.home.HomeFragment$8$2, reason: invalid class name */
                class AnonymousClass2 implements aadharcallback {
                    AnonymousClass2() {
                    }

                    @Override // in.gov.eci.bloapp.aadharcallback
                    public void onCallBack(int code, String status, String message) {
                        if (code == 401) {
                            HomeFragment.this.commomUtility.showMessageOK(HomeFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$8$2$$ExternalSyntheticLambda0
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
                    HomeFragment.this.checkStateCodeSirState();
                    Toast.makeText(HomeFragment.this.getContext().getApplicationContext(), "API failure", 1).show();
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
            checkStateCodeSirState();
            Toast.makeText(getContext().getApplicationContext(), "API failure", 1).show();
        }
    }

    private void getAllState() {
        this.commomUtility.getState(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda32
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllState$24(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllState$24(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$getAllState$23(i2, str, str2);
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
    public /* synthetic */ void lambda$getAllState$23(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllState$22(dialogInterface, i2);
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
    public /* synthetic */ void lambda$getAllState$22(DialogInterface dialogInterface, int i) {
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
        ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getRelationList(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.9
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
        ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).getTrainingStatus(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (((JsonObject) response.body()) != null) {
                        String asString = ((JsonObject) response.body()).get("message").getAsString();
                        int asInt = ((JsonObject) response.body()).get("payload").getAsInt();
                        SharedPref.getInstance(HomeFragment.this.getContext()).setTrainingStatus(asInt);
                        SharedPref.getInstance(HomeFragment.this.getContext()).setTrainingMessage(asString);
                        if (asInt == 0 || asInt == 2) {
                            HomeFragment.this.alertDialog_sir();
                            return;
                        }
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

    public void getEroNetAppStatus() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.stateCode);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).getEronetAppStatus(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.11
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (((JsonObject) response.body()) != null) {
                        String asString = ((JsonObject) response.body()).get("message").getAsString();
                        int asInt = ((JsonObject) response.body()).get("payload").getAsInt();
                        SharedPref.getInstance(HomeFragment.this.getContext()).setEroAppStatus(asInt);
                        SharedPref.getInstance(HomeFragment.this.getContext()).setEroAppMessage(asString);
                        if (asInt == 0 || asInt == 2) {
                            HomeFragment.this.alertDialog_eroApp();
                            return;
                        }
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

    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole()) || !SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) {
            checkStateCodeSirState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertDialog_sir() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog_sir, (ViewGroup) null);
        builder.setView(viewInflate);
        final android.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) viewInflate.findViewById(2131364346)).setText(String.valueOf(SharedPref.getInstance(requireContext()).getTrainingMessage()));
        Button button = (Button) viewInflate.findViewById(R.id.yes);
        Button button2 = (Button) viewInflate.findViewById(R.id.no);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_sir$25(alertDialogCreate, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_sir$26(alertDialogCreate, view);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_sir$25(android.app.AlertDialog alertDialog, View view) {
        postTrainingStatus(1);
        Log.d("Yes", "Yes");
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_sir$26(android.app.AlertDialog alertDialog, View view) {
        postTrainingStatus(2);
        Log.d("No", "No");
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertDialog_eroApp() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog_sir, (ViewGroup) null);
        builder.setView(viewInflate);
        final android.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) viewInflate.findViewById(2131364346)).setText(String.valueOf(SharedPref.getInstance(requireContext()).getEroAppMessage()));
        Button button = (Button) viewInflate.findViewById(R.id.yes);
        Button button2 = (Button) viewInflate.findViewById(R.id.no);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_eroApp$27(alertDialogCreate, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$alertDialog_eroApp$28(alertDialogCreate, view);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_eroApp$27(android.app.AlertDialog alertDialog, View view) {
        postEroAppStatus(1);
        Log.d("Yes", "Yes");
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alertDialog_eroApp$28(android.app.AlertDialog alertDialog, View view) {
        postEroAppStatus(2);
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
        callPostTrainingStatus.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.12
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Toast.makeText(HomeFragment.this.requireContext(), String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setTrainingStatus(status);
                    if (HomeFragment.this.alertDialog != null) {
                        HomeFragment.this.alertDialog.dismiss();
                    }
                    if (SharedPref.getInstance(HomeFragment.this.requireContext()).getEroAppStatus() == 0 || SharedPref.getInstance(HomeFragment.this.requireContext()).getEroAppStatus() == 2) {
                        HomeFragment.this.getEroNetAppStatus();
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

    private void postEroAppStatus(final int status) {
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
        Call<JsonObject> callPostEroappStatus = ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).postEroappStatus(map, map2);
        Log.d("here1", "here1");
        callPostEroappStatus.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment.13
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Toast.makeText(HomeFragment.this.requireContext(), String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    SharedPref.getInstance(HomeFragment.this.requireContext()).setEroAppStatus(status);
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
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.POST_NOTIFICATIONS") != 0) {
                this.requestNotifications.launch("android.permission.POST_NOTIFICATIONS");
            } else {
                startActivity(new Intent((Context) getActivity(), (Class<?>) BloNotifiy.class));
                this.alertDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$29(Boolean bool) {
        if (bool.booleanValue()) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) BloNotifiy.class));
            this.alertDialog.dismiss();
            Toast.makeText((Context) getActivity(), (CharSequence) "Notification Permission Granted", 0).show();
        } else {
            this.alertDialog.dismiss();
            checkNotificationPermission();
            Toast.makeText((Context) getActivity(), (CharSequence) "Permission Denied", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateBellSwing(final ImageView bell) {
        bell.post(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.lambda$animateBellSwing$30(bell);
            }
        });
    }

    static /* synthetic */ void lambda$animateBellSwing$30(ImageView imageView) {
        imageView.setPivotX(imageView.getWidth() / 2.0f);
        imageView.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", CropImageView.DEFAULT_ASPECT_RATIO, -20.0f, 15.0f, -10.0f, 5.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.start();
    }

    public void checkNotificationPermission() {
        new android.app.AlertDialog.Builder(getActivity()).setTitle("request Permission").setMessage("Kindly Allow Notification Permission").setCancelable(false).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkNotificationPermission$31(dialogInterface, i);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.home.HomeFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                HomeFragment.lambda$checkNotificationPermission$32(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkNotificationPermission$31(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, getActivity().getPackageName(), null));
        startActivity(intent);
    }

    public static boolean isValide19SIRState(String stateCode) {
        return stateCode.equalsIgnoreCase("S01") || stateCode.equalsIgnoreCase("S02") || stateCode.equalsIgnoreCase("S07") || stateCode.equalsIgnoreCase("S10") || stateCode.equalsIgnoreCase("S13") || stateCode.equalsIgnoreCase("S14") || stateCode.equalsIgnoreCase("S15") || stateCode.equalsIgnoreCase("S16") || stateCode.equalsIgnoreCase("S17") || stateCode.equalsIgnoreCase("S18") || stateCode.equalsIgnoreCase("S19") || stateCode.equalsIgnoreCase("S21") || stateCode.equalsIgnoreCase("S27") || stateCode.equalsIgnoreCase("S28") || stateCode.equalsIgnoreCase("S29") || stateCode.equalsIgnoreCase("U02") || stateCode.equalsIgnoreCase("U03") || stateCode.equalsIgnoreCase("U05");
    }
}
