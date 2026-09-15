package in.gov.eci.bloapp.views.fragments.dse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.SearchView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloDsependingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentSearchDseBinding;
import in.gov.eci.bloapp.model.app_model.dsePendingModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.dse.generateform8.DseIdentifiedFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
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
public class SearchDseFragment extends Fragment {
    private static final String ALERT = "Alert";
    private static final String ALL_HOUSES = "All houses";
    private static final String APPLICANT_NAME = "applicantName";
    private static final String CLOSE = "Close";
    private static final String CLUSTER_DETAILS = "cluster_details";
    private static final String CLUSTER_ID = "clusterId";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String CONTENT = "CONTENT";
    private static final String DSE_TYPE = "dseType";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String GENDER = "gender";
    private static final String JSON = "json: ";
    private static final String PAYLOAD = "payload: ";
    private static final String RELATION_NAME = "relationName";
    private static final String RELATION_TYPE = "relationType";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String UNABLE_TO_LOAD_DATA_PLEASE_TRY_AGAIN = "Unable to load data, Please try again.";
    private FilterableRecyclerView adapter;
    private AlertDialog alertDialog1;
    private String asmblyNO;
    BloFragmentSearchDseBinding binding;
    private String bloassemcode;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String flagValue;
    private ArrayList<dsePendingModel> mSearchList;
    private String partNo;
    private JSONArray payloadSearchHouses;
    private JsonArray payloadSearchHouses12;
    private String refreshToken;
    Retrofit retrofit;
    private ArrayList<dsePendingModel> searchList;
    private String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public SearchDseFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.payloadSearchHouses = null;
        this.blopartnumber = "";
        this.blostatecode = "";
        this.bloassemcode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSearchDseBinding.inflate(getLayoutInflater());
        this.searchList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flagValue = arguments.getString("Flag");
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        System.out.println("flag value is " + this.flagValue);
        if (this.flagValue.equals("0")) {
            dsependingFetch();
        } else if (this.flagValue.equals("2") || this.flagValue.equals("3") || this.flagValue.equals("4")) {
            dseidentified();
        } else {
            dseDoneFetch();
        }
        initCLickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        if (this.flagValue.equals("0") || this.flagValue.equals("1")) {
            openFragment(new DseFragment(), "dseFragment");
        } else {
            openFragment(new DseIdentifiedFragment(), "DseIdentifiedFragment");
        }
    }

    private void initCLickListener() {
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                SearchDseFragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public JsonArray dseidentified() {
        System.out.println("in dseidentified");
        Logger.d(CONTENT, "in dseidentified..............................");
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("acNo", this.asmblyNO);
        map.put("partNumber", this.partNo);
        if (this.flagValue.equals("2")) {
            map.put(DSE_TYPE, 1);
        } else if (this.flagValue.equals("3")) {
            map.put(DSE_TYPE, 2);
        } else if (this.flagValue.equals("4")) {
            map.put(DSE_TYPE, 3);
        }
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).dseIdentifiedNew(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass2());
        return this.payloadSearchHouses12;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonArray> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            System.out.println("kJSBKJ" + response.code());
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    SearchDseFragment.this.payloadSearchHouses12 = (JsonArray) response.body();
                    SearchDseFragment searchDseFragment = SearchDseFragment.this;
                    searchDseFragment.renderingdataNew(searchDseFragment.payloadSearchHouses12);
                    SearchDseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchDseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchDseFragment.this.commomUtility.getRefreshToken(SearchDseFragment.this.getContext(), SearchDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchDseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchDseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchDseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                SearchDseFragment.this.commomUtility.showMessageOK(SearchDseFragment.this.requireContext(), SearchDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchDseFragment.this.dseidentified();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setLocaleBool(false);
            SearchDseFragment.this.startActivity(new Intent((Context) SearchDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            SearchDseFragment.this.alertDialog1.dismiss();
            SearchDseFragment.this.showdialog4("Alert", SearchDseFragment.UNABLE_TO_LOAD_DATA_PLEASE_TRY_AGAIN);
            Logger.d(SearchDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$1(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    public JSONArray dsependingFetch() {
        Logger.d(CONTENT, "in dsependingFetch..............................");
        this.alertDialog1.show();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.partNo);
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("acNo", this.asmblyNO);
        map.put("partNumbers", arrayList);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).dsePending(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", CLOSE, "blo", this.blostatecode, "ANDROIDMOB", map).enqueue(new AnonymousClass3());
        return this.payloadSearchHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Logger.d("dsePending responseBody", String.valueOf(response.body()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    SearchDseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                    if (!SearchDseFragment.this.payloadSearchHouses.isEmpty()) {
                        Logger.d(SearchDseFragment.JSON, String.valueOf(SearchDseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchDseFragment.this.payloadSearchHouses.get(0)).getAsJsonObject()));
                        Logger.d(SearchDseFragment.PAYLOAD, String.valueOf(SearchDseFragment.this.payloadSearchHouses));
                        SearchDseFragment searchDseFragment = SearchDseFragment.this;
                        searchDseFragment.renderingdata(searchDseFragment.payloadSearchHouses);
                        SearchDseFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    SearchDseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchDseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchDseFragment.this.commomUtility.getRefreshToken(SearchDseFragment.this.getContext(), SearchDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$3$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchDseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchDseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchDseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                SearchDseFragment.this.commomUtility.showMessageOK(SearchDseFragment.this.requireContext(), SearchDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchDseFragment.this.dsependingFetch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setLocaleBool(false);
            SearchDseFragment.this.startActivity(new Intent((Context) SearchDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            SearchDseFragment.this.alertDialog1.dismiss();
            SearchDseFragment.this.showdialog4("Alert", SearchDseFragment.UNABLE_TO_LOAD_DATA_PLEASE_TRY_AGAIN);
            Logger.d(SearchDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public JSONArray dseDoneFetch() {
        Logger.d(CONTENT, "in dseDoneFetch..............................");
        this.alertDialog1.show();
        new ArrayList().add(this.partNo);
        HashMap map = new HashMap();
        map.put("stCode", this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartnumber);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).dseDone(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", CLOSE, "blo", this.blostatecode, map).enqueue(new AnonymousClass4());
        return this.payloadSearchHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    SearchDseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                    if (!SearchDseFragment.this.payloadSearchHouses.isEmpty()) {
                        Logger.d(SearchDseFragment.JSON, String.valueOf(SearchDseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchDseFragment.this.payloadSearchHouses.get(0)).getAsJsonObject()));
                        Logger.d(SearchDseFragment.PAYLOAD, String.valueOf(SearchDseFragment.this.payloadSearchHouses));
                        SearchDseFragment searchDseFragment = SearchDseFragment.this;
                        searchDseFragment.renderingdata1(searchDseFragment.payloadSearchHouses);
                        SearchDseFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    SearchDseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchDseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchDseFragment.this.commomUtility.getRefreshToken(SearchDseFragment.this.getContext(), SearchDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchDseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchDseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchDseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                SearchDseFragment.this.commomUtility.showMessageOK(SearchDseFragment.this.requireContext(), SearchDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchDseFragment.this.dseDoneFetch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchDseFragment.this.requireContext()).setLocaleBool(false);
            SearchDseFragment.this.startActivity(new Intent((Context) SearchDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            SearchDseFragment.this.alertDialog1.dismiss();
            SearchDseFragment.this.showdialog4("Alert", SearchDseFragment.UNABLE_TO_LOAD_DATA_PLEASE_TRY_AGAIN);
            Logger.d(SearchDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdata(JSONArray allHouses) {
        this.searchList.clear();
        try {
            Logger.d("in reading...........................", String.valueOf(allHouses));
            for (int i = 0; i < allHouses.size(); i++) {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                double dDoubleValue = ((Double) linkedTreeMap.get("dseClusterId")).doubleValue();
                String strReplace = String.valueOf(linkedTreeMap.get(Constants.FIRST_NAME)).trim().replace("[ ]+", "");
                String strReplace2 = String.valueOf(linkedTreeMap.get(Constants.LAST_NAME)).trim().replace("[ ]+", "");
                if (strReplace == null || strReplace.equals("null")) {
                    strReplace = "";
                }
                if (strReplace2 == null || strReplace2.equals("null")) {
                    strReplace2 = "";
                }
                String str = strReplace + StringUtils.SPACE + strReplace2;
                String strValueOf = String.valueOf((int) dDoubleValue);
                String strReplace3 = String.valueOf(linkedTreeMap.get("relationFirstName")).trim().replace("[ ]+", "");
                String strReplace4 = String.valueOf(linkedTreeMap.get("relationLastName")).trim().replace("[ ]+", "");
                if (strReplace3 == null || strReplace3.equals("null")) {
                    strReplace3 = "";
                }
                if (strReplace4 == null || strReplace4.equals("null")) {
                    strReplace4 = "";
                }
                this.searchList.add(new dsePendingModel(strValueOf, str, strReplace3 + StringUtils.SPACE + strReplace4, (String) linkedTreeMap.get(GENDER), String.valueOf((int) ((Double) linkedTreeMap.get("age")).doubleValue()), (String) linkedTreeMap.get(RELATION_TYPE), (int) ((Double) linkedTreeMap.get(DSE_TYPE)).doubleValue()));
            }
            initRecyclerViewAdapter();
            this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.searchListDseRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d(ALL_HOUSES, e.getMessage());
        }
    }

    public void renderingdataNew(JsonArray allHouses) {
        this.searchList.clear();
        try {
            Logger.d("in reading...........................", String.valueOf(allHouses));
            for (int i = 0; i < allHouses.size(); i++) {
                JsonObject jsonObject = allHouses.get(i);
                String strReplace = String.valueOf(jsonObject.get("applicantFirstName")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace2 = String.valueOf(jsonObject.get("applicantLastName")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (strReplace == null || strReplace.equals("null")) {
                    strReplace = "";
                }
                if (strReplace2 == null || strReplace2.equals("null")) {
                    strReplace2 = "";
                }
                String str = strReplace + StringUtils.SPACE + strReplace2;
                String strReplace3 = jsonObject.get(CLUSTER_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace4 = String.valueOf(jsonObject.get(RELATION_NAME)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace5 = String.valueOf(jsonObject.get("relationLName")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (strReplace4 == null || strReplace4.equals("null")) {
                    strReplace4 = "";
                }
                if (strReplace5 == null || strReplace5.equals("null")) {
                    strReplace5 = "";
                }
                this.searchList.add(new dsePendingModel(strReplace3, str, strReplace4 + StringUtils.SPACE + strReplace5, jsonObject.get(GENDER).toString().replace(RegexMatcher.JSON_STRING_REGEX, ""), jsonObject.get("age").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""), "", jsonObject.get(DSE_TYPE).getAsInt()));
            }
            initRecyclerViewAdapter();
            this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.searchListDseRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d(ALL_HOUSES, e.getMessage());
        }
    }

    public void renderingdata1(JSONArray allHouses) {
        this.searchList.clear();
        try {
            Logger.d("in reading...........................", String.valueOf(allHouses));
            for (int i = 0; i < allHouses.size(); i++) {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
                String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
                String str3 = "";
                if (str == null || str.equals("null")) {
                    str = "";
                }
                if (str2 == null || str2.equals("null")) {
                    str2 = "";
                }
                String str4 = str + StringUtils.SPACE + str2;
                String strValueOf = String.valueOf(linkedTreeMap.get("dseClusterId"));
                String str5 = (String) linkedTreeMap.get("relationFirstName");
                String str6 = (String) linkedTreeMap.get("relationLastName");
                if (str5 == null || str5.equals("null")) {
                    str5 = "";
                }
                if (str6 != null && !str6.equals("null")) {
                    str3 = str6;
                }
                this.searchList.add(new dsePendingModel(strValueOf, str4, str5 + StringUtils.SPACE + str3, (String) linkedTreeMap.get(GENDER), String.valueOf(linkedTreeMap.get("age")), (String) linkedTreeMap.get(RELATION_TYPE), ((Integer) linkedTreeMap.get(DSE_TYPE)).intValue()));
            }
            initRecyclerViewAdapter();
            this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.searchListDseRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d(ALL_HOUSES, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$5, reason: invalid class name */
    class AnonymousClass5 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass5() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloDsependingRvItemBinding.inflate(SearchDseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloDsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloDsependingRvItemBinding) holder.binding).HNoTv.setText(((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).getClusterId());
            ((BloDsependingRvItemBinding) holder.binding).applicantName.setText(((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).getFirstName());
            ((BloDsependingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).clusterId;
            final String str2 = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).firstName;
            final String str3 = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).relativeName;
            final String str4 = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).relationType;
            final String str5 = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).gender;
            final String str6 = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).age;
            final int i = ((dsePendingModel) SearchDseFragment.this.mSearchList.get(position)).dseType;
            ((BloDsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment$5$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, str2, str3, str4, str5, str6, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, int i, View view) {
            AnonymousClass5 anonymousClass5;
            if (SearchDseFragment.this.flagValue.equals("0")) {
                Bundle bundle = new Bundle();
                bundle.putString(SearchDseFragment.CLUSTER_ID, str);
                bundle.putString(SearchDseFragment.APPLICANT_NAME, str2);
                bundle.putString(SearchDseFragment.RELATION_NAME, str3);
                bundle.putString(SearchDseFragment.RELATION_TYPE, str4);
                bundle.putString(SearchDseFragment.GENDER, str5);
                bundle.putString("age", str6);
                bundle.putInt(SearchDseFragment.DSE_TYPE, i);
                bundle.putString("Flag", "0");
                ClusterNumberDseFragment clusterNumberDseFragment = new ClusterNumberDseFragment();
                clusterNumberDseFragment.setArguments(bundle);
                anonymousClass5 = this;
                SearchDseFragment.this.openFragment(clusterNumberDseFragment, SearchDseFragment.CLUSTER_DETAILS);
            } else {
                anonymousClass5 = this;
                if (SearchDseFragment.this.flagValue.equals("2") || SearchDseFragment.this.flagValue.equals("3") || SearchDseFragment.this.flagValue.equals("4")) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SearchDseFragment.CLUSTER_ID, str);
                    bundle2.putString(SearchDseFragment.APPLICANT_NAME, str2);
                    bundle2.putString(SearchDseFragment.RELATION_NAME, str3);
                    bundle2.putString(SearchDseFragment.RELATION_TYPE, str4);
                    bundle2.putString(SearchDseFragment.GENDER, str5);
                    bundle2.putString("age", str6);
                    bundle2.putInt(SearchDseFragment.DSE_TYPE, i);
                    bundle2.putString("Flag", "2");
                    ClusterNumberDseFragment clusterNumberDseFragment2 = new ClusterNumberDseFragment();
                    clusterNumberDseFragment2.setArguments(bundle2);
                    SearchDseFragment.this.openFragment(clusterNumberDseFragment2, SearchDseFragment.CLUSTER_DETAILS);
                    return;
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString(SearchDseFragment.CLUSTER_ID, str);
                bundle3.putString(SearchDseFragment.APPLICANT_NAME, str2);
                bundle3.putString(SearchDseFragment.RELATION_NAME, str3);
                bundle3.putString(SearchDseFragment.RELATION_TYPE, str4);
                bundle3.putString(SearchDseFragment.GENDER, str5);
                bundle3.putString("age", str6);
                bundle3.putInt(SearchDseFragment.DSE_TYPE, i);
                bundle3.putString("Flag", "1");
                ClusterNumberDseFragment clusterNumberDseFragment3 = new ClusterNumberDseFragment();
                clusterNumberDseFragment3.setArguments(bundle3);
                SearchDseFragment.this.openFragment(clusterNumberDseFragment3, SearchDseFragment.CLUSTER_DETAILS);
            }
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchDseFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment.5.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        SearchDseFragment.this.mSearchList = SearchDseFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (dsePendingModel dsependingmodel : SearchDseFragment.this.mSearchList) {
                            if (dsependingmodel.firstName.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(dsependingmodel);
                            }
                        }
                        SearchDseFragment.this.mSearchList = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchDseFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchDseFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapter() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new AnonymousClass5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
