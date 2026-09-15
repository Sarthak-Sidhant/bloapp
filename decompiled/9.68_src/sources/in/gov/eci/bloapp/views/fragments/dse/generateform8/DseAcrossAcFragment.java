package in.gov.eci.bloapp.views.fragments.dse.generateform8;

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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloDsependingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentDseAcrossAcBinding;
import in.gov.eci.bloapp.model.app_model.dsePendingModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment;
import in.gov.eci.bloapp.views.fragments.dse.SearchDseFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class DseAcrossAcFragment extends Fragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog1;
    private List<dsePendingModel> allhousesList;
    private String asmblyNO;
    BloFragmentDseAcrossAcBinding binding;
    private String blostatecode;
    Retrofit.Builder builder;
    private String partNo;
    private String refreshToken;
    Retrofit retrofit;
    private String token = "";
    private JsonArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public DseAcrossAcFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blostatecode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentDseAcrossAcBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        psePendingList();
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$$ExternalSyntheticLambda1
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
        bundle.putString("Flag", "4");
        SearchDseFragment searchDseFragment = new SearchDseFragment();
        searchDseFragment.setArguments(bundle);
        openFragment(searchDseFragment, "SearchDseFragment");
    }

    public JsonArray psePendingList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("acNo", this.asmblyNO);
        map.put("partNumber", this.partNo);
        map.put("dseType", 3);
        JSONObject jSONObject = new JSONObject(map);
        Logger.d("HELLO NO", String.valueOf(jSONObject));
        System.out.println("kjdksd" + jSONObject);
        System.out.println("atkn" + SharedPref.getInstance(requireContext()).getAtknBnd());
        System.out.println("rtkn" + SharedPref.getInstance(requireContext()).getRtknBnd());
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).dseIdentifiedNew(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonArray> {
        AnonymousClass1() {
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    DseAcrossAcFragment.this.payloadAllHouses = (JsonArray) response.body();
                    DseAcrossAcFragment dseAcrossAcFragment = DseAcrossAcFragment.this;
                    dseAcrossAcFragment.renderingdata(dseAcrossAcFragment.payloadAllHouses);
                    DseAcrossAcFragment.this.alertDialog1.dismiss();
                    return;
                }
                DseAcrossAcFragment.this.alertDialog1.dismiss();
                DseAcrossAcFragment.this.binding.nodatalayout.setVisibility(0);
                DseAcrossAcFragment.this.binding.allAppsRv.setVisibility(8);
                DseAcrossAcFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                DseAcrossAcFragment.this.commomUtility.getRefreshToken(DseAcrossAcFragment.this.getContext(), DseAcrossAcFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$1$$ExternalSyntheticLambda1
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
                if (response.code() == 401) {
                    DseAcrossAcFragment.this.alertDialog1.dismiss();
                    DseAcrossAcFragment.this.commomUtility.showMessageWithTitleOK(DseAcrossAcFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$1$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i);
                        }
                    });
                }
            }
            DseAcrossAcFragment.this.alertDialog1.dismiss();
            DseAcrossAcFragment.this.binding.nodatalayout.setVisibility(0);
            DseAcrossAcFragment.this.binding.allAppsRv.setVisibility(8);
            DseAcrossAcFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            DseAcrossAcFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                DseAcrossAcFragment.this.commomUtility.showMessageOK(DseAcrossAcFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DseAcrossAcFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(DseAcrossAcFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(DseAcrossAcFragment.this.requireContext()).setToken("Bearer " + str);
            DseAcrossAcFragment.this.psePendingList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DseAcrossAcFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DseAcrossAcFragment.this.requireContext()).setLocaleBool(false);
            DseAcrossAcFragment.this.startActivity(new Intent((Context) DseAcrossAcFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DseAcrossAcFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DseAcrossAcFragment.this.getContext()).setLocaleBool(false);
            DseAcrossAcFragment.this.startActivity(new Intent((Context) DseAcrossAcFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            DseAcrossAcFragment.this.alertDialog1.dismiss();
            DseAcrossAcFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$$ExternalSyntheticLambda0
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

    public void renderingdata(JsonArray allHouses) {
        this.allhousesList.clear();
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
                String strReplace3 = jsonObject.get("clusterId").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace4 = String.valueOf(jsonObject.get("relationName")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace5 = String.valueOf(jsonObject.get("relationLName")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (strReplace4 == null || strReplace4.equals("null")) {
                    strReplace4 = "";
                }
                if (strReplace5 == null || strReplace5.equals("null")) {
                    strReplace5 = "";
                }
                this.allhousesList.add(new dsePendingModel(strReplace3, str, strReplace4 + StringUtils.SPACE + strReplace5, jsonObject.get("gender").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""), jsonObject.get("age").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""), "", Integer.parseInt(jsonObject.get("dseType").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""))));
            }
            initRecyclerViewAdapter();
            this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.allAppsRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d("All houses", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloDsependingRvItemBinding.inflate(DseAcrossAcFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloDsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloDsependingRvItemBinding) holder.binding).HNoTv.setText(((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).getClusterId());
            ((BloDsependingRvItemBinding) holder.binding).applicantName.setText(((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).getFirstName());
            ((BloDsependingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).clusterId;
            System.out.println("cluster Id" + str);
            final String str2 = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).firstName;
            final String str3 = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).relativeName;
            final String str4 = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).relationType;
            final String str5 = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).gender;
            final String str6 = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).age;
            final int i = ((dsePendingModel) DseAcrossAcFragment.this.allhousesList.get(position)).dseType;
            ((BloDsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.generateform8.DseAcrossAcFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, str2, str3, str4, str5, str6, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, int i, View view) {
            Bundle bundle = new Bundle();
            bundle.putString("clusterId", str);
            bundle.putString("applicantName", str2);
            bundle.putString("relationName", str3);
            bundle.putString("relationType", str4);
            bundle.putString("gender", str5);
            bundle.putString("age", str6);
            bundle.putInt("dseType", i);
            bundle.putString("Flag", "2");
            ClusterNumberDseFragment clusterNumberDseFragment = new ClusterNumberDseFragment();
            clusterNumberDseFragment.setArguments(bundle);
            DseAcrossAcFragment.this.openFragment(clusterNumberDseFragment, "cluster_details");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return DseAcrossAcFragment.this.allhousesList.size();
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
