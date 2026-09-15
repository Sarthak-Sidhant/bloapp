package in.gov.eci.bloapp.views.fragments.pse.pseidentified;

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
import in.gov.eci.bloapp.databinding.BloFragmentPseAcrossAcBinding;
import in.gov.eci.bloapp.model.app_model.dsePendingModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class PseAcrossAcFragment extends Fragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog1;
    private List<dsePendingModel> allhousesList;
    BloFragmentPseAcrossAcBinding binding;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String refreshToken;
    Retrofit retrofit;
    private String token = "";
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PseAcrossAcFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blopartnumber = "";
        this.blostatecode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseAcrossAcBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.searchDsePending.setVisibility(0);
        pseAcrossAc();
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$$ExternalSyntheticLambda1
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
        SearchPseFragment searchPseFragment = new SearchPseFragment();
        searchPseFragment.setArguments(bundle);
        openFragment(searchPseFragment, "searchPseFragment");
    }

    public JSONArray pseAcrossAc() {
        Logger.d("in Pse within Part..............................", "");
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("partNo", this.blopartnumber);
        map.put("clusterBifurcation", "WST");
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseIdentified(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "Close", "blo", this.blostatecode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    PseAcrossAcFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (!PseAcrossAcFragment.this.payloadAllHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(PseAcrossAcFragment.this.gson.toJsonTree((LinkedTreeMap) PseAcrossAcFragment.this.payloadAllHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(PseAcrossAcFragment.this.payloadAllHouses));
                        PseAcrossAcFragment pseAcrossAcFragment = PseAcrossAcFragment.this;
                        pseAcrossAcFragment.renderingdata(pseAcrossAcFragment.payloadAllHouses);
                        PseAcrossAcFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    PseAcrossAcFragment.this.alertDialog1.dismiss();
                    PseAcrossAcFragment.this.binding.nodatalayout.setVisibility(0);
                    PseAcrossAcFragment.this.binding.allAppsRv.setVisibility(8);
                    PseAcrossAcFragment.this.binding.searchDsePending.setVisibility(8);
                    return;
                }
                PseAcrossAcFragment.this.alertDialog1.dismiss();
                PseAcrossAcFragment.this.binding.nodatalayout.setVisibility(0);
                PseAcrossAcFragment.this.binding.allAppsRv.setVisibility(8);
                PseAcrossAcFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                PseAcrossAcFragment.this.commomUtility.getRefreshToken(PseAcrossAcFragment.this.getContext(), PseAcrossAcFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$1$$ExternalSyntheticLambda0
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
            PseAcrossAcFragment.this.alertDialog1.dismiss();
            PseAcrossAcFragment.this.binding.nodatalayout.setVisibility(0);
            PseAcrossAcFragment.this.binding.allAppsRv.setVisibility(8);
            PseAcrossAcFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseAcrossAcFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseAcrossAcFragment.this.commomUtility.showMessageOK(PseAcrossAcFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseAcrossAcFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseAcrossAcFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseAcrossAcFragment.this.requireContext()).setToken("Bearer " + str);
            PseAcrossAcFragment.this.pseAcrossAc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseAcrossAcFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseAcrossAcFragment.this.requireContext()).setLocaleBool(false);
            PseAcrossAcFragment.this.startActivity(new Intent((Context) PseAcrossAcFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            PseAcrossAcFragment.this.alertDialog1.dismiss();
            PseAcrossAcFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$$ExternalSyntheticLambda0
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

    public void renderingdata(JSONArray allhouses) {
        this.allhousesList.clear();
        for (int i = 0; i < allhouses.size(); i++) {
            try {
                this.allhousesList.add(new dsePendingModel(String.valueOf(this.gson.toJsonTree(allhouses.get(i)).getAsJsonObject().get("clusterId")).replace(RegexMatcher.JSON_STRING_REGEX, ""), null, null, null, null, null, 0));
            } catch (Exception e) {
                Logger.d("All houses", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter();
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloDsependingRvItemBinding.inflate(PseAcrossAcFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloDsependingRvItemBinding) holder.binding).textView16.setVisibility(8);
            ((BloDsependingRvItemBinding) holder.binding).applicantName.setVisibility(8);
            ((BloDsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloDsependingRvItemBinding) holder.binding).HNoTv.setText(((dsePendingModel) PseAcrossAcFragment.this.allhousesList.get(position)).getClusterId());
            ((BloDsependingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((dsePendingModel) PseAcrossAcFragment.this.allhousesList.get(position)).clusterId;
            ((BloDsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseAcrossAcFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, View view) {
            Bundle bundle = new Bundle();
            bundle.putString("clusterId", str);
            ClusterDetailsPseIdentifiedFragment clusterDetailsPseIdentifiedFragment = new ClusterDetailsPseIdentifiedFragment();
            clusterDetailsPseIdentifiedFragment.setArguments(bundle);
            PseAcrossAcFragment.this.openFragment(clusterDetailsPseIdentifiedFragment, "clusterDetailsPseIdentifiedFragment");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return PseAcrossAcFragment.this.allhousesList.size();
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
