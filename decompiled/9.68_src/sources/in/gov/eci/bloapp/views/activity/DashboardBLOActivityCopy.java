package in.gov.eci.bloapp.views.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivityDashboardBloactivityCopyBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.fragments.DashBoardChartFragment;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DashboardBLOActivityCopy extends BaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    String asmblyName;
    BloActivityDashboardBloactivityCopyBinding binding;
    LayoutInflater inflaterDayBeginProgress;
    JSONParser parser;
    String partNo;
    String refreshToken;
    String stateCode;
    String token;
    CommomUtility commonUtilClass = new CommomUtility();
    Integer totalForm6 = 0;
    Integer totalForm6A = 0;
    Integer totalForm6B = 0;
    Integer totalForm7 = 0;
    Integer totalForm8 = 0;
    Integer withinForm6 = 0;
    Integer withinForm6A = 0;
    Integer withinForm6B = 0;
    Integer withinForm7 = 0;
    Integer withinForm8 = 0;
    Integer beforeForm6 = 0;
    Integer beforeForm6A = 0;
    Integer beforeForm6B = 0;
    Integer beforeForm7 = 0;
    Integer beforeForm8 = 0;
    String homeMaleText = "Home Male - ";
    String homeFemaleText = "Home Female - ";
    String homeTotalText = "Home Total - ";
    String homeTransText = "Home Trans - ";
    String total6 = "total6";
    String total6a = "total6a";
    String total6b = "total6b";
    String total7 = "total7";
    String total8 = "total8";
    String total7Days6 = "total7Days6";
    String total7Days6a = "total7Days6a";
    String total7Days6b = "total7Days6b";
    String total7Days7 = "total7Days7";
    String total7Days8 = "total7Days8";
    String male = "male";
    String female = "female";
    String trans = "trans";
    String pwd = "pwd";
    String total = "total";
    Gson gson = new GsonBuilder().setLenient().create();

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.json.simple.parser.ParseException */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) throws ParseException {
        super.onCreate(savedInstanceState);
        BloActivityDashboardBloactivityCopyBinding bloActivityDashboardBloactivityCopyBindingInflate = BloActivityDashboardBloactivityCopyBinding.inflate(getLayoutInflater());
        this.binding = bloActivityDashboardBloactivityCopyBindingInflate;
        setContentView((View) bloActivityDashboardBloactivityCopyBindingInflate.getRoot());
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.stateCode = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.asmblyName = SharedPref.getInstance(getApplicationContext()).getAssemblyName();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        Logger.d("Home_Token - ", this.token);
        Logger.d("Home_asmblyNO - ", this.asmblyNO);
        Logger.d("Home_asmblyName - ", this.asmblyName);
        Logger.d("Home_stateCode - ", this.stateCode);
        Logger.d("Home_partNo - ", this.partNo);
        Logger.d("Home_Token - ", this.token);
        Logger.d("Home_RefToken - ", this.refreshToken);
        Logger.d("Home_asmblyNO - ", this.asmblyNO);
        Logger.d("Home_asmblyName - ", this.asmblyName);
        Logger.d("Home_stateCode - ", this.stateCode);
        Logger.d("Home_partNo - ", this.partNo);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        this.inflaterDayBeginProgress = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.homerefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$$ExternalSyntheticLambda0
            public final void onRefresh() {
                this.f$0.lambda$onCreate$0();
            }
        });
        if (Boolean.TRUE.equals(Boolean.valueOf(isNetworkAvailable(getApplicationContext())))) {
            if (SharedPref.getInstance(getApplicationContext()).getGenderWiseElectorsCountHomeResponseCode() == 200 && SharedPref.getInstance(getApplicationContext()).getDashChartDataResponseCode() == 200) {
                this.alertDialog.dismiss();
                Logger.d("In getDashChartData()_1 - > payload - ", SharedPref.getInstance(getApplicationContext()).getDashChartData());
                Logger.d("In getGenderDashboardHome()_1 - > payload - ", SharedPref.getInstance(getApplicationContext()).getGenderWiseElectorsCountHome());
                try {
                    getGenDashCommonSharedPref();
                } catch (Exception e) {
                    Logger.d("In getDashChartData()_1.1 - > payload - ", e.getMessage());
                }
            } else {
                getGenDashCommon();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please check network,swipe down to refresh the data", 1).show();
        }
        this.binding.linerLayoutElector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        if (Boolean.TRUE.equals(Boolean.valueOf(isNetworkAvailable(getApplicationContext())))) {
            getGenDashCommon();
        } else {
            Toast.makeText(getApplicationContext(), "Please check network", 1).show();
        }
        this.binding.homerefreshlayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) ElectorsListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getDashChartData() {
        Logger.d("getDashChartData", "In getDashChartData()_2");
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getDashFormCount(this.stateCode, this.asmblyNO, this.partNo, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "ANDROIDMOB").enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                JSONArray payload = ((EronetResponse) response.body()).getPayload();
                Logger.d("In getDashChartData()_3", " payload - " + payload);
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) payload.get(0);
                JsonObject asJsonObject = DashboardBLOActivityCopy.this.gson.toJsonTree(linkedTreeMap).getAsJsonObject();
                Logger.d("In getDashChartData()_4", " jsonDailyObject - " + asJsonObject);
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total6) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy.totalForm6 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy.total6));
                } else {
                    DashboardBLOActivityCopy.this.totalForm6 = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total6a) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy2 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy2.totalForm6A = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy2.total6a));
                } else {
                    DashboardBLOActivityCopy.this.totalForm6A = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total6b) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy3 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy3.totalForm6B = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy3.total6b));
                } else {
                    DashboardBLOActivityCopy.this.totalForm6B = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy4 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy4.totalForm7 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy4.total7));
                } else {
                    DashboardBLOActivityCopy.this.totalForm7 = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total8) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy5 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy5.totalForm8 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy5.total8));
                } else {
                    DashboardBLOActivityCopy.this.totalForm8 = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7Days6) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy6 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy6.withinForm6 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy6.total7Days6));
                } else {
                    DashboardBLOActivityCopy.this.withinForm6 = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7Days6a) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy7 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy7.withinForm6A = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy7.total7Days6a));
                } else {
                    DashboardBLOActivityCopy.this.withinForm6A = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7Days6b) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy8 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy8.withinForm6B = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy8.total7Days6b));
                } else {
                    DashboardBLOActivityCopy.this.withinForm6B = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7Days7) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy9 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy9.withinForm7 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy9.total7Days7));
                } else {
                    DashboardBLOActivityCopy.this.withinForm7 = 0;
                }
                if (asJsonObject.get(DashboardBLOActivityCopy.this.total7Days8) != null) {
                    DashboardBLOActivityCopy dashboardBLOActivityCopy10 = DashboardBLOActivityCopy.this;
                    dashboardBLOActivityCopy10.withinForm8 = Integer.valueOf((String) linkedTreeMap.get(dashboardBLOActivityCopy10.total7Days8));
                } else {
                    DashboardBLOActivityCopy.this.withinForm8 = 0;
                }
                DashboardBLOActivityCopy dashboardBLOActivityCopy11 = DashboardBLOActivityCopy.this;
                dashboardBLOActivityCopy11.beforeForm6 = Integer.valueOf(dashboardBLOActivityCopy11.totalForm6.intValue() - DashboardBLOActivityCopy.this.withinForm6.intValue());
                DashboardBLOActivityCopy dashboardBLOActivityCopy12 = DashboardBLOActivityCopy.this;
                dashboardBLOActivityCopy12.beforeForm6A = Integer.valueOf(dashboardBLOActivityCopy12.totalForm6A.intValue() - DashboardBLOActivityCopy.this.withinForm6A.intValue());
                DashboardBLOActivityCopy dashboardBLOActivityCopy13 = DashboardBLOActivityCopy.this;
                dashboardBLOActivityCopy13.beforeForm6B = Integer.valueOf(dashboardBLOActivityCopy13.totalForm6B.intValue() - DashboardBLOActivityCopy.this.withinForm6B.intValue());
                DashboardBLOActivityCopy dashboardBLOActivityCopy14 = DashboardBLOActivityCopy.this;
                dashboardBLOActivityCopy14.beforeForm7 = Integer.valueOf(dashboardBLOActivityCopy14.totalForm7.intValue() - DashboardBLOActivityCopy.this.withinForm7.intValue());
                DashboardBLOActivityCopy dashboardBLOActivityCopy15 = DashboardBLOActivityCopy.this;
                dashboardBLOActivityCopy15.beforeForm8 = Integer.valueOf(dashboardBLOActivityCopy15.totalForm8.intValue() - DashboardBLOActivityCopy.this.withinForm8.intValue());
                if (DashboardBLOActivityCopy.this.beforeForm6.intValue() < 0) {
                    DashboardBLOActivityCopy.this.beforeForm6 = 0;
                }
                if (DashboardBLOActivityCopy.this.beforeForm6A.intValue() < 0) {
                    DashboardBLOActivityCopy.this.beforeForm6A = 0;
                }
                if (DashboardBLOActivityCopy.this.beforeForm6B.intValue() < 0) {
                    DashboardBLOActivityCopy.this.beforeForm6B = 0;
                }
                if (DashboardBLOActivityCopy.this.beforeForm7.intValue() < 0) {
                    DashboardBLOActivityCopy.this.beforeForm7 = 0;
                }
                if (DashboardBLOActivityCopy.this.beforeForm8.intValue() < 0) {
                    DashboardBLOActivityCopy.this.beforeForm8 = 0;
                }
                Logger.d("Home totalForm6 - ", DashboardBLOActivityCopy.this.totalForm6.toString());
                Logger.d("Home totalForm6A - ", DashboardBLOActivityCopy.this.totalForm6A.toString());
                Logger.d("Home totalForm6B - ", DashboardBLOActivityCopy.this.totalForm6B.toString());
                Logger.d("Home totalForm7 - ", DashboardBLOActivityCopy.this.totalForm7.toString());
                Logger.d("Home totalForm8 - ", DashboardBLOActivityCopy.this.totalForm8.toString());
                Logger.d("Home withinForm6 - ", DashboardBLOActivityCopy.this.withinForm6.toString());
                Logger.d("Home withinForm6A - ", DashboardBLOActivityCopy.this.withinForm6A.toString());
                Logger.d("Home withinForm6B - ", DashboardBLOActivityCopy.this.withinForm6B.toString());
                Logger.d("Home withinForm7 - ", DashboardBLOActivityCopy.this.withinForm7.toString());
                Logger.d("Home withinForm8 - ", DashboardBLOActivityCopy.this.withinForm8.toString());
                Logger.d("Home beforeForm6 - ", DashboardBLOActivityCopy.this.beforeForm6.toString());
                Logger.d("Home beforeForm6A - ", DashboardBLOActivityCopy.this.beforeForm6A.toString());
                Logger.d("Home beforeForm6B - ", DashboardBLOActivityCopy.this.beforeForm6B.toString());
                Logger.d("Home beforeForm7 - ", DashboardBLOActivityCopy.this.beforeForm7.toString());
                Logger.d("Home beforeForm8 - ", DashboardBLOActivityCopy.this.beforeForm8.toString());
                FragmentTransaction fragmentTransactionBeginTransaction = DashboardBLOActivityCopy.this.getSupportFragmentManager().beginTransaction();
                DashBoardChartFragment dashBoardChartFragment = new DashBoardChartFragment();
                Bundle bundle = new Bundle();
                bundle.putString("withForm6", String.valueOf(DashboardBLOActivityCopy.this.withinForm6));
                bundle.putString("withForm6A", String.valueOf(DashboardBLOActivityCopy.this.withinForm6A));
                bundle.putString("withForm6B", String.valueOf(DashboardBLOActivityCopy.this.withinForm6B));
                bundle.putString("withForm7", String.valueOf(DashboardBLOActivityCopy.this.withinForm7));
                bundle.putString("withForm8", String.valueOf(DashboardBLOActivityCopy.this.withinForm8));
                bundle.putString("beforeForm6", String.valueOf(DashboardBLOActivityCopy.this.beforeForm6));
                bundle.putString("beforeForm6A", String.valueOf(DashboardBLOActivityCopy.this.beforeForm6A));
                bundle.putString("beforeForm6B", String.valueOf(DashboardBLOActivityCopy.this.beforeForm6B));
                bundle.putString("beforeForm7", String.valueOf(DashboardBLOActivityCopy.this.beforeForm7));
                bundle.putString("beforeForm8", String.valueOf(DashboardBLOActivityCopy.this.beforeForm8));
                dashBoardChartFragment.setArguments(bundle);
                fragmentTransactionBeginTransaction.add(R.id.containerChart, dashBoardChartFragment);
                fragmentTransactionBeginTransaction.commit();
                DashboardBLOActivityCopy.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                try {
                    Logger.d("jsonObject", String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (IOException | JSONException e) {
                    Logger.d("", e.getMessage());
                }
                DashboardBLOActivityCopy.this.commonUtilClass.getRefreshToken(DashboardBLOActivityCopy.this.getApplicationContext(), DashboardBLOActivityCopy.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("jsonObject", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
            DashboardBLOActivityCopy.this.alertDialog.dismiss();
            Logger.d("", "API Failure else - Data not updated getDashChartData()");
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
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            DashboardBLOActivityCopy.this.alertDialog.dismiss();
            Logger.d("getRefreshToken DBA ", i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Toast.makeText(DashboardBLOActivityCopy.this.getApplicationContext(), "API Failure else - Data not updated", 0);
                DashboardBLOActivityCopy.this.commonUtilClass.showMessageOK(DashboardBLOActivityCopy.this, "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DashboardBLOActivityCopy.this.token = "Bearer " + str;
            SharedPref.getInstance(DashboardBLOActivityCopy.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(DashboardBLOActivityCopy.this.getApplicationContext()).setToken("Bearer " + str);
            DashboardBLOActivityCopy.this.getGenDashCommon();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DashboardBLOActivityCopy.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DashboardBLOActivityCopy.this.getApplicationContext()).setLocaleBool(false);
            DashboardBLOActivityCopy.this.startActivity(new Intent(DashboardBLOActivityCopy.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d("coming in onFailure ", t.getMessage());
            DashboardBLOActivityCopy.this.alertDialog.dismiss();
            Toast.makeText(DashboardBLOActivityCopy.this.getApplicationContext(), "API Failure - Data not updated", 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getGenderWiseElectorsCountHome(String stateCode, String asmblyNO, String partNo, String tokenn) {
        Logger.d("In getGenderDashboardHome()_2", "In getGenderDashboardHome()_2.1");
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getGenderWiseElectorsCount(stateCode, asmblyNO, partNo, tokenn, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.DashboardBLOActivityCopy.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    try {
                        JsonObject jsonObject = (JsonObject) response.body();
                        Logger.d("In getGenderDashboardHome()_3 - > payload - ", String.valueOf(jsonObject));
                        JSONObject jSONObject = new JSONObject(String.valueOf(jsonObject)).getJSONObject("payload");
                        DashboardBLOActivityCopy.this.binding.textMaleCount.setText(jSONObject.getString(DashboardBLOActivityCopy.this.male));
                        DashboardBLOActivityCopy.this.binding.textFemaleCount.setText(jSONObject.getString(DashboardBLOActivityCopy.this.female));
                        DashboardBLOActivityCopy.this.binding.textThirdGenCount.setText(jSONObject.getString(DashboardBLOActivityCopy.this.trans));
                        SpannableString spannableString = new SpannableString(jSONObject.getString(DashboardBLOActivityCopy.this.total));
                        spannableString.setSpan(new UnderlineSpan(), 0, jSONObject.getString(DashboardBLOActivityCopy.this.total).length(), 0);
                        DashboardBLOActivityCopy.this.binding.textTotalElectorsCount.setText(spannableString);
                        Logger.d(DashboardBLOActivityCopy.this.homeMaleText, jSONObject.getString(DashboardBLOActivityCopy.this.male));
                        Logger.d(DashboardBLOActivityCopy.this.homeFemaleText, jSONObject.getString(DashboardBLOActivityCopy.this.female));
                        Logger.d(DashboardBLOActivityCopy.this.homeTotalText, jSONObject.getString(DashboardBLOActivityCopy.this.total));
                        Logger.d(DashboardBLOActivityCopy.this.homeTransText, jSONObject.getString(DashboardBLOActivityCopy.this.trans));
                        Logger.d("male - ", jSONObject.getString(DashboardBLOActivityCopy.this.male));
                        Logger.d("female - ", jSONObject.getString(DashboardBLOActivityCopy.this.female));
                        Logger.d("total - ", jSONObject.getString(DashboardBLOActivityCopy.this.total));
                        Logger.d("trans - ", jSONObject.getString(DashboardBLOActivityCopy.this.trans));
                        Logger.d("pwd - ", jSONObject.getString(DashboardBLOActivityCopy.this.pwd));
                        return;
                    } catch (JSONException e) {
                        Logger.d("", e.getMessage());
                        return;
                    }
                }
                try {
                    Logger.d("jsonObject getGenderDashboardHome()", String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d("coming in onFailure ", t.getMessage());
            }
        });
    }

    public void getGenDashCommon() {
        this.alertDialog.show();
        getGenderWiseElectorsCountHome(this.stateCode, this.asmblyNO, this.partNo, this.token);
        getDashChartData();
    }

    public void getGenDashCommonSharedPref() throws ParseException {
        this.alertDialog.show();
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        org.json.simple.JSONObject jSONObject = (org.json.simple.JSONObject) jSONParser.parse(SharedPref.getInstance(getApplicationContext()).getGenderWiseElectorsCountHome());
        Logger.d("In getGenderDashboardHome()_4 - > payload - ", String.valueOf(jSONObject));
        this.binding.textMaleCount.setText(Objects.requireNonNull(jSONObject.get(this.male)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        this.binding.textFemaleCount.setText(Objects.requireNonNull(jSONObject.get(this.female)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        this.binding.textThirdGenCount.setText(Objects.requireNonNull(jSONObject.get(this.trans)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        SpannableString spannableString = new SpannableString(Objects.requireNonNull(jSONObject.get(this.total)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        spannableString.setSpan(new UnderlineSpan(), 0, Objects.requireNonNull(jSONObject.get(this.total)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).length(), 0);
        this.binding.textTotalElectorsCount.setText(spannableString);
        Logger.d(this.homeMaleText, Objects.requireNonNull(jSONObject.get(this.male)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d(this.homeFemaleText, Objects.requireNonNull(jSONObject.get(this.female)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d(this.homeTotalText, Objects.requireNonNull(jSONObject.get(this.total)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d(this.homeTransText, Objects.requireNonNull(jSONObject.get(this.trans)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d("male - ", Objects.requireNonNull(jSONObject.get(this.male)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d("female - ", Objects.requireNonNull(jSONObject.get(this.female)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d("total - ", Objects.requireNonNull(jSONObject.get(this.total)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d("trans - ", Objects.requireNonNull(jSONObject.get(this.trans)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        Logger.d("pwd - ", Objects.requireNonNull(jSONObject.get(this.pwd)).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        JSONArray jSONArray = (JSONArray) this.parser.parse(SharedPref.getInstance(getApplicationContext()).getDashChartData());
        Logger.d("In getDashChartData()_5 ", " payload - " + jSONArray);
        JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(0)).getAsJsonObject();
        Logger.d("In getDashChartData()_6 ", " jsonDailyObject - " + asJsonObject);
        if (!asJsonObject.get(this.total6).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.totalForm6 = Integer.valueOf(asJsonObject.get(this.total6).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.totalForm6 = 0;
        }
        if (!asJsonObject.get(this.total6a).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.totalForm6A = Integer.valueOf(asJsonObject.get(this.total6a).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.totalForm6A = 0;
        }
        if (!asJsonObject.get(this.total6b).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.totalForm6B = Integer.valueOf(asJsonObject.get(this.total6b).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.totalForm6B = 0;
        }
        if (!asJsonObject.get(this.total7).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.totalForm7 = Integer.valueOf(asJsonObject.get(this.total7).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.totalForm7 = 0;
        }
        if (!asJsonObject.get(this.total8).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.totalForm8 = Integer.valueOf(asJsonObject.get(this.total8).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.totalForm8 = 0;
        }
        if (!asJsonObject.get(this.total7Days6).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.withinForm6 = Integer.valueOf(asJsonObject.get(this.total7Days6).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.withinForm6 = 0;
        }
        if (!asJsonObject.get(this.total7Days6a).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.withinForm6A = Integer.valueOf(asJsonObject.get(this.total7Days6a).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.withinForm6A = 0;
        }
        if (!asJsonObject.get(this.total7Days6b).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.withinForm6B = Integer.valueOf(asJsonObject.get(this.total7Days6b).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.withinForm6B = 0;
        }
        if (!asJsonObject.get(this.total7Days7).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.withinForm7 = Integer.valueOf(asJsonObject.get(this.total7Days7).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.withinForm7 = 0;
        }
        if (!asJsonObject.get(this.total7Days8).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals("null")) {
            this.withinForm8 = Integer.valueOf(asJsonObject.get(this.total7Days8).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE));
        } else {
            this.withinForm8 = 0;
        }
        this.beforeForm6 = Integer.valueOf(this.totalForm6.intValue() - this.withinForm6.intValue());
        this.beforeForm6A = Integer.valueOf(this.totalForm6A.intValue() - this.withinForm6A.intValue());
        this.beforeForm6B = Integer.valueOf(this.totalForm6B.intValue() - this.withinForm6B.intValue());
        this.beforeForm7 = Integer.valueOf(this.totalForm7.intValue() - this.withinForm7.intValue());
        this.beforeForm8 = Integer.valueOf(this.totalForm8.intValue() - this.withinForm8.intValue());
        if (this.beforeForm6.intValue() < 0) {
            this.beforeForm6 = 0;
        }
        if (this.beforeForm6A.intValue() < 0) {
            this.beforeForm6A = 0;
        }
        if (this.beforeForm6B.intValue() < 0) {
            this.beforeForm6B = 0;
        }
        if (this.beforeForm7.intValue() < 0) {
            this.beforeForm7 = 0;
        }
        if (this.beforeForm8.intValue() < 0) {
            this.beforeForm8 = 0;
        }
        Logger.d("Home totalForm6 - ", this.totalForm6.toString());
        Logger.d("Home totalForm6A - ", this.totalForm6A.toString());
        Logger.d("Home totalForm6B - ", this.totalForm6B.toString());
        Logger.d("Home totalForm7 - ", this.totalForm7.toString());
        Logger.d("Home totalForm8 - ", this.totalForm8.toString());
        Logger.d("Home withinForm6 - ", this.withinForm6.toString());
        Logger.d("Home withinForm6A - ", this.withinForm6A.toString());
        Logger.d("Home withinForm6B - ", this.withinForm6B.toString());
        Logger.d("Home withinForm7 - ", this.withinForm7.toString());
        Logger.d("Home withinForm8 - ", this.withinForm8.toString());
        Logger.d("Home beforeForm6 - ", this.beforeForm6.toString());
        Logger.d("Home beforeForm6A - ", this.beforeForm6A.toString());
        Logger.d("Home beforeForm6B - ", this.beforeForm6B.toString());
        Logger.d("Home beforeForm7 - ", this.beforeForm7.toString());
        Logger.d("Home beforeForm8 - ", this.beforeForm8.toString());
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        DashBoardChartFragment dashBoardChartFragment = new DashBoardChartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("withForm6", String.valueOf(this.withinForm6));
        bundle.putString("withForm6A", String.valueOf(this.withinForm6A));
        bundle.putString("withForm6B", String.valueOf(this.withinForm6B));
        bundle.putString("withForm7", String.valueOf(this.withinForm7));
        bundle.putString("withForm8", String.valueOf(this.withinForm8));
        bundle.putString("beforeForm6", String.valueOf(this.beforeForm6));
        bundle.putString("beforeForm6A", String.valueOf(this.beforeForm6A));
        bundle.putString("beforeForm6B", String.valueOf(this.beforeForm6B));
        bundle.putString("beforeForm7", String.valueOf(this.beforeForm7));
        bundle.putString("beforeForm8", String.valueOf(this.beforeForm8));
        dashBoardChartFragment.setArguments(bundle);
        fragmentTransactionBeginTransaction.add(R.id.containerChart, dashBoardChartFragment);
        fragmentTransactionBeginTransaction.commit();
        this.alertDialog.dismiss();
    }

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
