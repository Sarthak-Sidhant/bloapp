package in.gov.eci.bloapp.views.fragments.h2h_dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.model.EronetResonse;
import in.gov.eci.bloapp.databinding.BloFragmentH2HDashboardBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.H2HSurveyStatusHomeActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.Statement6;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class H2HDashboardFragment extends BaseFragment {
    String acId;
    String acIdText;
    String acNoText;
    AlertDialog alertDialog;
    String alertText;
    String asmblyNO;
    String asmblyName;
    String bearerText;
    BloFragmentH2HDashboardBinding binding;
    Retrofit.Builder builder;
    String currentRole;
    String districtCdText;
    String districtCode;
    String districtId;
    String districtIdText;
    String districtName;
    String getRefreshTokenText;
    String langName;
    LayoutInflater layoutInflater;
    String logTag;
    String partLang;
    String partName;
    String partNo;
    String password;
    String refreshToken;
    Retrofit retrofit;
    String sessionExpiredText;
    String sessionExpiredTextForRefresh;
    String stateCdText;
    String stateCode;
    String stateId;
    String stateIdText;
    String stateName;
    String tokenValue;
    String totalPartNumber;
    String userName;
    CommomUtility commonutils = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public H2HDashboardFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.logTag = "H2HDashboardFragment";
        this.currentRole = "blo";
        this.stateId = "";
        this.acId = "";
        this.districtId = "";
        this.stateIdText = "stateId";
        this.acIdText = "acId";
        this.districtIdText = "districtId";
        this.stateCdText = "stateCd";
        this.acNoText = "acNo";
        this.districtCdText = "districtCd";
        this.alertText = "Alert";
        this.sessionExpiredText = "Session Expired. Please Login again..";
        this.sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
        this.bearerText = "Bearer ";
        this.getRefreshTokenText = "getRefreshToken : ";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentH2HDashboardBinding.inflate(getLayoutInflater());
        this.tokenValue = SharedPref.getInstance(requireContext()).getToken();
        this.userName = SharedPref.getInstance(requireContext()).getUserName();
        this.password = SharedPref.getInstance(requireContext()).getPassword();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.partName = SharedPref.getInstance(requireContext()).getPartName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(this.logTag, "tokenValue -- > " + this.tokenValue);
        Logger.d(this.logTag, "stateCode -- > " + this.stateCode);
        Logger.d(this.logTag, "districtCode -- > " + this.districtCode);
        Logger.d(this.logTag, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(this.logTag, "totalPartNumber -- > " + this.totalPartNumber);
        Logger.d(this.logTag, "stateName -- > " + this.stateName);
        Logger.d(this.logTag, "districtName -- > " + this.districtName);
        Logger.d(this.logTag, "asmblyName -- > " + this.asmblyName);
        Logger.d(this.logTag, "partName -- > " + this.partName);
        Logger.d(this.logTag, "langName -- > " + this.langName);
        Logger.d(this.logTag, "partLang -- > " + this.partLang);
        Logger.d(this.logTag, "partNo -- > " + this.partNo);
        Logger.d(this.logTag, "refreshToken -- > " + this.refreshToken);
        this.layoutInflater = LayoutInflater.from(getActivity());
        View viewInflate = inflater.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            fetchAllId();
        }
        this.binding.statement1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.statement5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.draftH2H.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment.1
            public void handleOnBackPressed() {
                H2HDashboardFragment.this.requireActivity().finish();
            }
        });
        this.binding.statement6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.H2HSurveyStatusLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreateView$5(view, motionEvent);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Statement1 statement1 = new Statement1();
        Bundle bundle = new Bundle();
        bundle.putString(this.stateIdText, this.stateId);
        bundle.putString(this.acIdText, this.acId);
        bundle.putString(this.districtIdText, this.districtId);
        Logger.d(this.logTag, "Bundle for Statement1 : " + bundle);
        statement1.setArguments(bundle);
        openFragment(statement1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        Statement5 statement5 = new Statement5();
        Bundle bundle = new Bundle();
        bundle.putString(this.stateIdText, this.stateId);
        bundle.putString(this.acIdText, this.acId);
        bundle.putString(this.districtIdText, this.districtId);
        Logger.d(this.logTag, "Bundle for Statement5 : " + bundle);
        statement5.setArguments(bundle);
        openFragment(statement5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        BloRegisterDraftFragment bloRegisterDraftFragment = new BloRegisterDraftFragment();
        Bundle bundle = new Bundle();
        bundle.putString(this.stateIdText, this.stateId);
        bundle.putString(this.acIdText, this.acId);
        bundle.putString(this.districtIdText, this.districtId);
        Logger.d(this.logTag, "Bundle for BloRegisterDraftFragment : " + bundle);
        bloRegisterDraftFragment.setArguments(bundle);
        openFragment(bloRegisterDraftFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Statement6.class);
        intent.putExtra(this.stateIdText, this.stateId);
        intent.putExtra(this.acIdText, this.acId);
        intent.putExtra(this.districtIdText, this.districtId);
        Logger.d(this.logTag, "Bundle for Statement6 : " + intent);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        startActivity(new Intent(view.getContext(), (Class<?>) H2HSurveyStatusHomeActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$5(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
        return true;
    }

    public void fetchAllId() {
        Logger.d("fetchAllId() -> stateCode : ", this.stateCode);
        Logger.d("fetchAllId() -> asmblyNO : ", this.asmblyNO);
        HashMap map = new HashMap();
        map.put("Authorization", this.tokenValue);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("fetchAllId() -> fetchAllIdHeader : ", map.toString());
        this.commomUtility.getRetrofitClient(getContext(), this.tokenValue, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getAllId(this.asmblyNO, this.districtCode, map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResonse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResonse> call, Response<EronetResonse> response) {
            Logger.d(H2HDashboardFragment.this.logTag, "fetchAllId() -> code : " + response.code());
            if (response.code() == 200) {
                Logger.d(H2HDashboardFragment.this.logTag, "------ Fetching Data from fetchAllId API -- Start ----");
                Logger.d(H2HDashboardFragment.this.logTag, "In fetchAllId() -> status : " + ((EronetResonse) response.body()).getStatus());
                Logger.d(H2HDashboardFragment.this.logTag, "In fetchAllId() -> statusCode : " + ((EronetResonse) response.body()).getStatusCode());
                JSONArray payload = ((EronetResonse) response.body()).getPayload();
                Logger.d(H2HDashboardFragment.this.logTag, "In fetchAllId() -> payload : " + payload);
                JsonObject asJsonObject = H2HDashboardFragment.this.gson.toJsonTree((LinkedTreeMap) payload.get(0)).getAsJsonObject();
                if (asJsonObject.get(H2HDashboardFragment.this.acNoText) != null) {
                    H2HDashboardFragment h2HDashboardFragment = H2HDashboardFragment.this;
                    h2HDashboardFragment.asmblyNO = String.valueOf(asJsonObject.get(h2HDashboardFragment.acNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(H2HDashboardFragment.this.stateCdText) != null) {
                    H2HDashboardFragment h2HDashboardFragment2 = H2HDashboardFragment.this;
                    h2HDashboardFragment2.stateCode = String.valueOf(asJsonObject.get(h2HDashboardFragment2.stateCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(H2HDashboardFragment.this.districtCdText) != null) {
                    H2HDashboardFragment h2HDashboardFragment3 = H2HDashboardFragment.this;
                    h2HDashboardFragment3.districtCode = String.valueOf(asJsonObject.get(h2HDashboardFragment3.districtCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(H2HDashboardFragment.this.stateIdText) != null) {
                    H2HDashboardFragment h2HDashboardFragment4 = H2HDashboardFragment.this;
                    h2HDashboardFragment4.stateId = String.valueOf(asJsonObject.get(h2HDashboardFragment4.stateIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(H2HDashboardFragment.this.acIdText) != null) {
                    H2HDashboardFragment h2HDashboardFragment5 = H2HDashboardFragment.this;
                    h2HDashboardFragment5.acId = String.valueOf(asJsonObject.get(h2HDashboardFragment5.acIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(H2HDashboardFragment.this.districtIdText) != null) {
                    H2HDashboardFragment h2HDashboardFragment6 = H2HDashboardFragment.this;
                    h2HDashboardFragment6.districtId = String.valueOf(asJsonObject.get(h2HDashboardFragment6.districtIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> acNo : " + H2HDashboardFragment.this.asmblyNO);
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> stateCd : " + H2HDashboardFragment.this.stateCode);
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> districtCd : " + H2HDashboardFragment.this.districtCode);
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> stateId : " + H2HDashboardFragment.this.stateId);
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> acId : " + H2HDashboardFragment.this.acId);
                Logger.d(H2HDashboardFragment.this.logTag, "Payload --> districtId : " + H2HDashboardFragment.this.districtId);
                Logger.d(H2HDashboardFragment.this.logTag, "------ Fetching Data from fetchAllId API -- End ----");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                H2HDashboardFragment.this.commonutils.getRefreshToken(H2HDashboardFragment.this.getContext(), H2HDashboardFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$3(i, str, str2);
                    }
                });
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4();
                    }
                }, 2000L);
                return;
            }
            Logger.d(H2HDashboardFragment.this.logTag, "In fetchAllId() -> else part ----> Response Body is null ");
            try {
                Logger.d(H2HDashboardFragment.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(H2HDashboardFragment.this.logTag, e.getMessage());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$5();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            H2HDashboardFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, final String str, final String str2) {
            Logger.d(H2HDashboardFragment.this.logTag, H2HDashboardFragment.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                H2HDashboardFragment.this.commonutils.showMessageOK(H2HDashboardFragment.this.getContext(), H2HDashboardFragment.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            } else {
                H2HDashboardFragment.this.commonutils.showMessageOK(H2HDashboardFragment.this.getContext(), H2HDashboardFragment.this.sessionExpiredTextForRefresh, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(str, str2, dialogInterface, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDashboardFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDashboardFragment.this.getContext()).setLocaleBool(false);
            H2HDashboardFragment.this.startActivity(new Intent(H2HDashboardFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2, DialogInterface dialogInterface, int i) {
            H2HDashboardFragment.this.tokenValue = H2HDashboardFragment.this.bearerText + str;
            H2HDashboardFragment.this.refreshToken = str2;
            SharedPref.getInstance(H2HDashboardFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HDashboardFragment.this.getContext()).setToken(H2HDashboardFragment.this.bearerText + str);
            H2HDashboardFragment.this.fetchAllId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4() {
            H2HDashboardFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5() {
            H2HDashboardFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResonse> call, Throwable t) {
            Logger.d(H2HDashboardFragment.this.logTag, "In fetchAllId() -> ON failure" + t.getMessage());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$6();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$6() {
            H2HDashboardFragment.this.alertDialog.dismiss();
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
