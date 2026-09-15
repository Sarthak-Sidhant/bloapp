package in.gov.eci.bloapp.views.fragments.pse.pseidentified;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloFragmentClusterDetailsPseIdentifiedBinding;
import in.gov.eci.bloapp.databinding.BloPseIdentifiedRvItemBinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ClusterDetailsPseIdentifiedFragment extends Fragment {
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CLUSTER_ID = "clusterId";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String CONTENT = "CONTENT";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    private GenericRecyclerView adapter;
    private String address;
    private AlertDialog alertDialog;
    BloFragmentClusterDetailsPseIdentifiedBinding binding;
    private Bitmap bitmap;
    Retrofit.Builder builder;
    private String clusterId;
    private String encodedImage;
    private List<clusterDetailsDseModel> finalDetailsList;
    private List<clusterDetailsDseModel> housedetailList;
    private List<clusterDetailsDseModel> newDetailsList;
    private String partNo;
    private String refreshToken;
    private List<clusterDetailsDseModel> removedDetailsList;
    Retrofit retrofit;
    private String blostatecode = "";
    private String token = "";
    private JSONArray addressDetails = null;
    private JSONArray payloadHousedetails = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public ClusterDetailsPseIdentifiedFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentClusterDetailsPseIdentifiedBinding.inflate(getLayoutInflater());
        this.finalDetailsList = new ArrayList();
        this.newDetailsList = new ArrayList();
        this.removedDetailsList = new ArrayList();
        this.housedetailList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.clusterId = arguments.getString(CLUSTER_ID);
        }
        this.binding.headTitle.setText(this.clusterId);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        pseclusterDetails();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void pseclusterDetails() {
        Logger.d("in cluster details fetch..............................", "");
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put(CLUSTER_ID, this.clusterId);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseIdentifiedCluster(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "Close", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("ksjhf", String.valueOf(response.body()));
            if (response.code() == 200) {
                ClusterDetailsPseIdentifiedFragment.this.payloadHousedetails = ((EronetResponse) response.body()).getPayload();
                if (ClusterDetailsPseIdentifiedFragment.this.payloadHousedetails.isEmpty()) {
                    return;
                }
                Logger.d("json: ", String.valueOf(ClusterDetailsPseIdentifiedFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterDetailsPseIdentifiedFragment.this.payloadHousedetails.get(0)).getAsJsonObject()));
                Logger.d("payload: ", String.valueOf(ClusterDetailsPseIdentifiedFragment.this.payloadHousedetails));
                ClusterDetailsPseIdentifiedFragment clusterDetailsPseIdentifiedFragment = ClusterDetailsPseIdentifiedFragment.this;
                clusterDetailsPseIdentifiedFragment.renderingdata(clusterDetailsPseIdentifiedFragment.payloadHousedetails);
                ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                ClusterDetailsPseIdentifiedFragment.this.commomUtility.getRefreshToken(ClusterDetailsPseIdentifiedFragment.this.getContext(), ClusterDetailsPseIdentifiedFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterDetailsPseIdentifiedFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterDetailsPseIdentifiedFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
            ClusterDetailsPseIdentifiedFragment.this.showdialog2("Alert", "No Record Found");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterDetailsPseIdentifiedFragment.this.commomUtility.showMessageOK(ClusterDetailsPseIdentifiedFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterDetailsPseIdentifiedFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterDetailsPseIdentifiedFragment.this.pseclusterDetails();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setLocaleBool(false);
            ClusterDetailsPseIdentifiedFragment.this.startActivity(new Intent((Context) ClusterDetailsPseIdentifiedFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
            ClusterDetailsPseIdentifiedFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(ClusterDetailsPseIdentifiedFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdata(JSONArray housedetails) {
        this.housedetailList.clear();
        this.finalDetailsList.clear();
        this.removedDetailsList.clear();
        this.newDetailsList.clear();
        String str = "";
        Logger.d("pse identified cluster details..........................", "");
        int i = 0;
        while (i < housedetails.size()) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) housedetails.get(i);
            String str2 = (String) linkedTreeMap.get(Constants.FIRST_NAME);
            String str3 = (String) linkedTreeMap.get(Constants.LAST_NAME);
            if (str2 == null || str2.equals("null")) {
                str2 = str;
            }
            if (str3 == null || str3.equals("null")) {
                str3 = str;
            }
            String str4 = (String) linkedTreeMap.get("epicNo");
            String str5 = (String) linkedTreeMap.get("acNo");
            String str6 = (String) linkedTreeMap.get("partNo");
            String str7 = (String) linkedTreeMap.get("age");
            String str8 = (String) linkedTreeMap.get("gender");
            String str9 = (String) linkedTreeMap.get("relationFirstName");
            String str10 = (String) linkedTreeMap.get("relationLastName");
            if (str9 == null || str9.equals("null")) {
                str9 = str;
            }
            String str11 = (str10 == null || str10.equals("null")) ? str : str10;
            String str12 = (String) linkedTreeMap.get("relationType");
            String str13 = (String) linkedTreeMap.get("pseId");
            String str14 = (String) linkedTreeMap.get(CLUSTER_ID);
            String str15 = (String) linkedTreeMap.get("photo");
            String str16 = (String) linkedTreeMap.get("createdDttm");
            String str17 = (String) linkedTreeMap.get("isActive");
            if (str17 == null || str17.equals("null") || str17.equals(str)) {
                str17 = "Y";
            }
            this.finalDetailsList.add(new clusterDetailsDseModel(str2, str3, str4, str5, str6, str7, str8, str9, str11, str12, "", 0, str13, str16, str17, str15, str14, "", "", 0));
            i++;
            str = str;
        }
        for (int i2 = 0; i2 < this.finalDetailsList.size(); i2++) {
            if (this.partNo.equals(this.finalDetailsList.get(i2).getPartnumber())) {
                this.newDetailsList.add(this.finalDetailsList.get(i2));
            }
        }
        for (int i3 = 0; i3 < this.finalDetailsList.size(); i3++) {
            if (!this.partNo.equals(this.finalDetailsList.get(i3).getPartnumber())) {
                this.removedDetailsList.add(this.finalDetailsList.get(i3));
            }
        }
        this.housedetailList.addAll(this.newDetailsList);
        this.housedetailList.addAll(this.removedDetailsList);
        initRecyclerViewAdapter();
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment.2
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloPseIdentifiedRvItemBinding.inflate(ClusterDetailsPseIdentifiedFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloPseIdentifiedRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
                ((BloPseIdentifiedRvItemBinding) holder.binding).epicNoET.setText(((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getEpicnumber());
                ((BloPseIdentifiedRvItemBinding) holder.binding).acPartnoET.setText(((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getAc() + " // " + ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPartnumber());
                HashMap map = new HashMap();
                map.put(ClusterDetailsPseIdentifiedFragment.EPIC_NUMBER, ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getEpicnumber());
                map.put("acNo", ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getAc());
                map.put("partNumber", ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPartnumber());
                map.put("stateCd", ClusterDetailsPseIdentifiedFragment.this.blostatecode);
                ClusterDetailsPseIdentifiedFragment.this.commomUtility.getRetrofitClient(ClusterDetailsPseIdentifiedFragment.this.getContext(), ClusterDetailsPseIdentifiedFragment.this.token, SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.getContext()).getRtknBnd()).getaddressDetailsPse(ClusterDetailsPseIdentifiedFragment.this.token, SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).getRtknBnd(), "BLOAPP", "blo", ClusterDetailsPseIdentifiedFragment.this.blostatecode, ClusterDetailsPseIdentifiedFragment.APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass1(holder));
                ((BloPseIdentifiedRvItemBinding) holder.binding).applicantNameET.setText(((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getApplicantLastname());
                if (((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getBloVerifStatus().equals("N") || ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getBloVerifStatus().equals("n")) {
                    ((BloPseIdentifiedRvItemBinding) holder.binding).statusLayout.setVisibility(0);
                } else {
                    ((BloPseIdentifiedRvItemBinding) holder.binding).statusLayout.setVisibility(8);
                }
                if (((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPhoto() != null) {
                    Logger.d("photo---------------", ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPhoto());
                    ClusterDetailsPseIdentifiedFragment.this.commomUtility.getRetrofitClient(ClusterDetailsPseIdentifiedFragment.this.getContext(), ClusterDetailsPseIdentifiedFragment.this.token, SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.getContext()).getRtknBnd()).getFile("objectstorage", ((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPhoto(), ClusterDetailsPseIdentifiedFragment.this.token, SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new C00422(holder));
                } else {
                    ((BloPseIdentifiedRvItemBinding) holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterDetailsPseIdentifiedFragment.this.getResources(), R.drawable.blo_dummy_image));
                }
                if (ClusterDetailsPseIdentifiedFragment.this.partNo.equals(((clusterDetailsDseModel) ClusterDetailsPseIdentifiedFragment.this.housedetailList.get(position)).getPartnumber())) {
                    ((BloPseIdentifiedRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#C9F2FF"));
                } else {
                    ((BloPseIdentifiedRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }

            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$1, reason: invalid class name */
            class AnonymousClass1 implements Callback<EronetResponse> {
                final /* synthetic */ RecyclerViewHolder val$holder;

                AnonymousClass1(final RecyclerViewHolder val$holder) {
                    this.val$holder = val$holder;
                }

                public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
                    if (response.code() == 200) {
                        ClusterDetailsPseIdentifiedFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                        String string = "";
                        if (!ClusterDetailsPseIdentifiedFragment.this.addressDetails.isEmpty()) {
                            JsonObject asJsonObject = ClusterDetailsPseIdentifiedFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterDetailsPseIdentifiedFragment.this.addressDetails.get(0)).getAsJsonObject();
                            ClusterDetailsPseIdentifiedFragment clusterDetailsPseIdentifiedFragment = ClusterDetailsPseIdentifiedFragment.this;
                            if (!String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.HOUSE_NUMBER)).equals("null")) {
                                StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                                if (!String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.STATE_NAME_ENGLISH)).equals("null")) {
                                    StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    if (!String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.PIN_CODE_NEW)).equals("null")) {
                                        string = ", " + String.valueOf(asJsonObject.get(ClusterDetailsPseIdentifiedFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    }
                                    string = sbAppend2.append(string).toString();
                                }
                                string = sbAppend.append(string).toString();
                            }
                            clusterDetailsPseIdentifiedFragment.address = string;
                            ((BloPseIdentifiedRvItemBinding) this.val$holder.binding).addressEt.setText(ClusterDetailsPseIdentifiedFragment.this.address.replaceAll("[,]+", ","));
                            ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
                            return;
                        }
                        ((BloPseIdentifiedRvItemBinding) this.val$holder.binding).addressEt.setText("");
                        return;
                    }
                    if (response.code() == 401) {
                        ClusterDetailsPseIdentifiedFragment.this.commomUtility.getRefreshToken(ClusterDetailsPseIdentifiedFragment.this.getContext(), ClusterDetailsPseIdentifiedFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$1$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str, String str2) {
                                this.f$0.lambda$onResponse$1(i, str, str2);
                            }
                        });
                        return;
                    }
                    try {
                        Logger.d(ClusterDetailsPseIdentifiedFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
                    } catch (IOException | JSONException e) {
                        Logger.d(ClusterDetailsPseIdentifiedFragment.HOUSE_NUMBER_FRAG, e.getMessage());
                    }
                    ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                    ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                    if (i == 401 || i == 400) {
                        ClusterDetailsPseIdentifiedFragment.this.commomUtility.showMessageOK(ClusterDetailsPseIdentifiedFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$1$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                            }
                        });
                        return;
                    }
                    ClusterDetailsPseIdentifiedFragment.this.token = "Bearer " + str;
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setToken("Bearer " + str);
                    ClusterDetailsPseIdentifiedFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setIsLoggedIn(false);
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setLocaleBool(false);
                    ClusterDetailsPseIdentifiedFragment.this.startActivity(new Intent((Context) ClusterDetailsPseIdentifiedFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                }

                public void onFailure(Call<EronetResponse> call, Throwable t) {
                    Logger.d(ClusterDetailsPseIdentifiedFragment.COMING_IN_ON_FAILURE, t.getMessage());
                }
            }

            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$2, reason: invalid class name and collision with other inner class name */
            class C00422 implements Callback<JsonObject> {
                final /* synthetic */ RecyclerViewHolder val$holder;

                C00422(final RecyclerViewHolder val$holder) {
                    this.val$holder = val$holder;
                }

                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        ((JsonObject) response.body()).get("file");
                        ClusterDetailsPseIdentifiedFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (ClusterDetailsPseIdentifiedFragment.this.encodedImage == null) {
                            ((BloPseIdentifiedRvItemBinding) this.val$holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterDetailsPseIdentifiedFragment.this.getResources(), R.drawable.blo_dummy_image));
                            return;
                        } else {
                            byte[] bArrDecode = Base64.decode(ClusterDetailsPseIdentifiedFragment.this.encodedImage, 0);
                            ClusterDetailsPseIdentifiedFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                            ((BloPseIdentifiedRvItemBinding) this.val$holder.binding).imageView9.setImageBitmap(ClusterDetailsPseIdentifiedFragment.this.bitmap);
                            return;
                        }
                    }
                    if (response.code() == 401) {
                        ClusterDetailsPseIdentifiedFragment.this.commomUtility.getRefreshToken(ClusterDetailsPseIdentifiedFragment.this.getContext(), ClusterDetailsPseIdentifiedFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$2$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str, String str2) {
                                this.f$0.lambda$onResponse$1(i, str, str2);
                            }
                        });
                        return;
                    }
                    try {
                        Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString("message"));
                    } catch (Exception e) {
                        Logger.e("", e.getMessage());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                    ClusterDetailsPseIdentifiedFragment.this.alertDialog.dismiss();
                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                    if (i == 401 || i == 400) {
                        ClusterDetailsPseIdentifiedFragment.this.commomUtility.showMessageOK(ClusterDetailsPseIdentifiedFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$2$2$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                            }
                        });
                        return;
                    }
                    ClusterDetailsPseIdentifiedFragment.this.token = "Bearer " + str;
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setToken("Bearer " + str);
                    ClusterDetailsPseIdentifiedFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setIsLoggedIn(false);
                    SharedPref.getInstance(ClusterDetailsPseIdentifiedFragment.this.requireContext()).setLocaleBool(false);
                    ClusterDetailsPseIdentifiedFragment.this.startActivity(new Intent((Context) ClusterDetailsPseIdentifiedFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d(ClusterDetailsPseIdentifiedFragment.COMING_IN_ON_FAILURE, t.getMessage());
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return ClusterDetailsPseIdentifiedFragment.this.housedetailList.size();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog2(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$2(DialogInterface dialogInterface, int i) {
        openFragment(new PseIdentifiedFragment(), "pseIdentifiedFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$3(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(CLUSTER_ID, this.clusterId);
        ClusterDetailsPseIdentifiedFragment clusterDetailsPseIdentifiedFragment = new ClusterDetailsPseIdentifiedFragment();
        clusterDetailsPseIdentifiedFragment.setArguments(bundle);
        openFragment(clusterDetailsPseIdentifiedFragment, "clusterDetailsPseIdentifiedFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$4(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) PseActivity.class));
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
