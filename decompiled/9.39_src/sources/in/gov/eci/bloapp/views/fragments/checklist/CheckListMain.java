package in.gov.eci.bloapp.views.fragments.checklist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentChecklistMainBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CheckListMain extends Hilt_CheckListMain {
    private GenericFragmentPagerAdapter adapter;
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    AlertDialog alertDialog;
    private BloFragmentChecklistMainBinding binding;
    String refreshToken;
    public String stateCode;
    Utils utils;
    public String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();
    ArrayList<String> relationNameSpinnerVal = new ArrayList<>();
    ArrayList<String> relationCodeSpinnerVal = new ArrayList<>();
    String selectRelationType = "";
    String SESSION = "";
    private final String[] tabs = {"TOTAL LIST", "VERIFIED"};
    final int[] ICONS_CHECKLIST = {R.drawable.blo_outline_non_verified, R.drawable.blo_outline_verified};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(requireContext()).getToken();
        SharedPref.getInstance(requireContext()).getStateCode();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentChecklistMainBinding.inflate(getLayoutInflater());
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        setUpViewPager();
        initViewPagerAndTagLayout();
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(0))).setIcon(this.ICONS_CHECKLIST[0]);
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(1))).setIcon(this.ICONS_CHECKLIST[1]);
        initClickListener();
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.SESSION = getString(R.string.sessionMsg);
        this.utils = new Utils();
        if (SharedPref.getInstance(requireContext()).getRelativeListCode(Constants.RELATIVE_LIST_CODE).isEmpty() || SharedPref.getInstance(requireContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME).isEmpty()) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            getRelationTypeDropdown();
        }
        return this.binding.getRoot();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.CheckListMain$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.checklist.CheckListMain.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new TotalListFragment();
                }
                return new VerifiedFragment();
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.adapter = new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface);
        this.binding.viewPager.setAdapter(this.adapter);
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.checklist.CheckListMain$$ExternalSyntheticLambda1
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$1(tab, i);
            }
        }).attach();
        getResources().getColor(R.color.blo_black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$1(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }

    private void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", SharedPref.getInstance(requireContext()).getToken());
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getRelationDropdownSIR(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.CheckListMain.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (CheckListMain.this.alertDialog != null) {
                        CheckListMain.this.alertDialog.dismiss();
                    }
                    JsonObject jsonObject = (JsonObject) response.body();
                    if (jsonObject != null) {
                        JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                        CheckListMain.this.relationNameSpinnerVal.clear();
                        CheckListMain.this.relationCodeSpinnerVal.clear();
                        CheckListMain.this.relationNameSpinnerVal.add(CheckListMain.this.selectRelationType);
                        CheckListMain.this.relationCodeSpinnerVal.add("");
                        int size = asJsonArray.size();
                        for (int i = 0; i < size; i++) {
                            JsonObject asJsonObject = CheckListMain.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                            CheckListMain.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            CheckListMain.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        }
                        SharedPref.getInstance(CheckListMain.this.getContext()).saveRelativeListName(CheckListMain.this.relationNameSpinnerVal, Constants.RELATIVE_LIST_NAME);
                        SharedPref.getInstance(CheckListMain.this.getContext()).saveRelativeListCode(CheckListMain.this.relationCodeSpinnerVal, Constants.RELATIVE_LIST_CODE);
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (CheckListMain.this.alertDialog != null) {
                        CheckListMain.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    if (CheckListMain.this.alertDialog != null) {
                        CheckListMain.this.alertDialog.dismiss();
                    }
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString("message");
                    Logger.e("", jSONObject.optString("message"));
                    CheckListMain.this.utils.infoDialog(CheckListMain.this.getContext(), CheckListMain.this.getResources().getString(R.string.alertMsg), strOptString);
                } catch (IOException | JSONException e) {
                    if (CheckListMain.this.alertDialog != null) {
                        CheckListMain.this.alertDialog.dismiss();
                    }
                    CheckListMain.this.utils.infoDialog(CheckListMain.this.getContext(), CheckListMain.this.getResources().getString(R.string.alertMsg), CheckListMain.this.getResources().getString(R.string.something_went_wrong));
                    Logger.e("", e.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (CheckListMain.this.alertDialog != null) {
                    CheckListMain.this.alertDialog.dismiss();
                }
                CheckListMain.this.utils.infoDialog(CheckListMain.this.getContext(), CheckListMain.this.getResources().getString(R.string.alertMsg), CheckListMain.this.getResources().getString(R.string.something_went_wrong));
                Logger.d("", "OnFailure" + t.getMessage());
            }
        });
    }
}
