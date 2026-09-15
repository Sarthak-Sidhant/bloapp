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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloDsependingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentDseDoneBinding;
import in.gov.eci.bloapp.model.app_model.dsePendingModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
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
public class DseDoneFragment extends Fragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog1;
    private List<dsePendingModel> allhousesList;
    BloFragmentDseDoneBinding binding;
    private String bloassemcode;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String refreshToken;
    Retrofit retrofit;
    private String stateCode;
    private String token = "";
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(3, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public DseDoneFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blopartnumber = "";
        this.bloassemcode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentDseDoneBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        pseDoneList();
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "1");
        SearchDseFragment searchDseFragment = new SearchDseFragment();
        searchDseFragment.setArguments(bundle);
        openFragment(searchDseFragment, "SearchDseFragment");
    }

    public void pseDoneList() {
        Logger.d("CONTENT", "in house fetch..............................");
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stCode", this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartnumber);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).dseDone(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "Close", "blo", this.stateCode, map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("response pse: in done ", String.valueOf(response.code()));
            if (response.code() == 200) {
                Logger.d("response payload in done ", String.valueOf(((EronetResponse) response.body()).getPayload()));
                if (((EronetResponse) response.body()).getPayload() != null || !((EronetResponse) response.body()).getPayload().isEmpty()) {
                    DseDoneFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (!DseDoneFragment.this.payloadAllHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(DseDoneFragment.this.gson.toJsonTree((LinkedTreeMap) DseDoneFragment.this.payloadAllHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(DseDoneFragment.this.payloadAllHouses));
                        DseDoneFragment dseDoneFragment = DseDoneFragment.this;
                        dseDoneFragment.renderingdata(dseDoneFragment.payloadAllHouses);
                        DseDoneFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    DseDoneFragment.this.alertDialog1.dismiss();
                    DseDoneFragment.this.binding.nodatalayout.setVisibility(0);
                    DseDoneFragment.this.binding.allAppsRv.setVisibility(8);
                    DseDoneFragment.this.binding.searchDsePending.setVisibility(8);
                    return;
                }
                DseDoneFragment.this.alertDialog1.dismiss();
                DseDoneFragment.this.binding.nodatalayout.setVisibility(0);
                DseDoneFragment.this.binding.allAppsRv.setVisibility(8);
                DseDoneFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                DseDoneFragment.this.commomUtility.getRefreshToken(DseDoneFragment.this.getContext(), DseDoneFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("errorResponse", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
            }
            DseDoneFragment.this.alertDialog1.dismiss();
            DseDoneFragment.this.binding.nodatalayout.setVisibility(0);
            DseDoneFragment.this.binding.allAppsRv.setVisibility(8);
            DseDoneFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            DseDoneFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                DseDoneFragment.this.commomUtility.showMessageOK(DseDoneFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DseDoneFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(DseDoneFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(DseDoneFragment.this.requireContext()).setToken("Bearer " + str);
            DseDoneFragment.this.pseDoneList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DseDoneFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DseDoneFragment.this.requireContext()).setLocaleBool(false);
            DseDoneFragment.this.startActivity(new Intent((Context) DseDoneFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            DseDoneFragment.this.alertDialog1.dismiss();
            DseDoneFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$1(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) DseActivity.class));
    }

    public void renderingdata(JSONArray allHouses) {
        this.allhousesList.clear();
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
                String str4 = str + " " + str2;
                String strValueOf = String.valueOf(linkedTreeMap.get("dseClusterId"));
                String str5 = (String) linkedTreeMap.get("relationFirstName");
                String str6 = (String) linkedTreeMap.get("relationLastName");
                if (str5 == null || str5.equals("null")) {
                    str5 = "";
                }
                if (str6 != null && !str6.equals("null")) {
                    str3 = str6;
                }
                this.allhousesList.add(new dsePendingModel(strValueOf, str4, str5 + " " + str3, (String) linkedTreeMap.get("gender"), String.valueOf(linkedTreeMap.get("age")), (String) linkedTreeMap.get("relationType"), Integer.parseInt((String) linkedTreeMap.get("dseType"))));
            }
            initRecyclerViewAdapter();
            this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.allAppsRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d("All houses", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloDsependingRvItemBinding.inflate(DseDoneFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloDsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloDsependingRvItemBinding) holder.binding).HNoTv.setText(((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).getClusterId());
            ((BloDsependingRvItemBinding) holder.binding).applicantName.setText(((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).getFirstName());
            ((BloDsependingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).clusterId;
            final String str2 = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).firstName;
            final String str3 = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).relativeName;
            final String str4 = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).relationType;
            final String str5 = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).gender;
            final String str6 = ((dsePendingModel) DseDoneFragment.this.allhousesList.get(position)).age;
            ((BloDsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseDoneFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, str2, str3, str4, str5, str6, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, View view) {
            Bundle bundle = new Bundle();
            bundle.putString("clusterId", str);
            bundle.putString("applicantName", str2);
            bundle.putString("relationName", str3);
            bundle.putString("relationType", str4);
            bundle.putString("gender", str5);
            bundle.putString("age", str6);
            bundle.putString("Flag", "1");
            ClusterNumberDseFragment clusterNumberDseFragment = new ClusterNumberDseFragment();
            clusterNumberDseFragment.setArguments(bundle);
            DseDoneFragment.this.openFragment(clusterNumberDseFragment, "cluster_details");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return DseDoneFragment.this.allhousesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
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
