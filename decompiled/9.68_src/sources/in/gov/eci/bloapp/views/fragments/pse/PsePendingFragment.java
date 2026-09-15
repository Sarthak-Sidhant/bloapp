package in.gov.eci.bloapp.views.fragments.pse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import in.gov.eci.bloapp.databinding.BloFragmentPsePendingBinding;
import in.gov.eci.bloapp.databinding.BloPsependingRvItemBinding;
import in.gov.eci.bloapp.model.app_model.psePendingModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
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
public class PsePendingFragment extends Fragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog1;
    private List<psePendingModel> allhousesList;
    BloFragmentPsePendingBinding binding;
    private String bloassemcode;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String refreshToken;
    Retrofit retrofit;
    private String token = "";
    private JSONArray payloadAllHouses = null;
    private final JSONArray payloadAllHouses1 = new JSONArray();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PsePendingFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blopartnumber = "";
        this.blostatecode = "";
        this.bloassemcode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPsePendingBinding.inflate(getLayoutInflater());
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
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        psePendingList();
        return this.binding.getRoot();
    }

    public JSONArray psePendingList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartnumber);
        System.out.println("cgh" + new JSONObject(map));
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).psePending(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (((EronetResponse) response.body()).getPayload() != null) {
                    PsePendingFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (PsePendingFragment.this.payloadAllHouses != null && !PsePendingFragment.this.payloadAllHouses.isEmpty()) {
                        for (int i = 0; i < PsePendingFragment.this.payloadAllHouses.size(); i++) {
                            if (((LinkedTreeMap) PsePendingFragment.this.payloadAllHouses.get(i)).get("status").equals("Pending")) {
                                PsePendingFragment.this.payloadAllHouses1.add(PsePendingFragment.this.payloadAllHouses.get(i));
                            }
                        }
                        if (!PsePendingFragment.this.payloadAllHouses1.isEmpty()) {
                            PsePendingFragment psePendingFragment = PsePendingFragment.this;
                            psePendingFragment.renderingdata(psePendingFragment.payloadAllHouses1);
                        } else {
                            PsePendingFragment.this.alertDialog1.dismiss();
                            PsePendingFragment.this.binding.nodatalayout.setVisibility(0);
                            PsePendingFragment.this.binding.allAppsRv.setVisibility(8);
                        }
                        PsePendingFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    PsePendingFragment.this.alertDialog1.dismiss();
                    PsePendingFragment.this.binding.nodatalayout.setVisibility(0);
                    PsePendingFragment.this.binding.allAppsRv.setVisibility(8);
                    return;
                }
                PsePendingFragment.this.alertDialog1.dismiss();
                PsePendingFragment.this.binding.nodatalayout.setVisibility(0);
                PsePendingFragment.this.binding.allAppsRv.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                PsePendingFragment.this.commomUtility.getRefreshToken(PsePendingFragment.this.getContext(), PsePendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i2, str, str2);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d("errorResponse", String.valueOf(jSONObject));
                System.out.println("errorResponseTest" + jSONObject);
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
            }
            PsePendingFragment.this.alertDialog1.dismiss();
            PsePendingFragment.this.binding.nodatalayout.setVisibility(0);
            PsePendingFragment.this.binding.allAppsRv.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PsePendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PsePendingFragment.this.commomUtility.showMessageOK(PsePendingFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PsePendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PsePendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PsePendingFragment.this.requireContext()).setToken("Bearer " + str);
            PsePendingFragment.this.psePendingList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PsePendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PsePendingFragment.this.requireContext()).setLocaleBool(false);
            PsePendingFragment.this.startActivity(new Intent((Context) PsePendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            PsePendingFragment.this.alertDialog1.dismiss();
            PsePendingFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$0(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) PseActivity.class));
    }

    public void renderingdata(JSONArray allHouses) {
        this.allhousesList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                this.allhousesList.add(new psePendingModel((String) ((LinkedTreeMap) allHouses.get(i)).get("clusterId")));
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloPsependingRvItemBinding.inflate(PsePendingFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloPsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloPsependingRvItemBinding) holder.binding).HNoTv.setText(((psePendingModel) PsePendingFragment.this.allhousesList.get(position)).getClusterId());
            final String str = ((psePendingModel) PsePendingFragment.this.allhousesList.get(position)).clusterId;
            ((BloPsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PsePendingFragment$2$$ExternalSyntheticLambda0
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
            bundle.putString("Flag", "0");
            ClusterNumberFragment clusterNumberFragment = new ClusterNumberFragment();
            clusterNumberFragment.setArguments(bundle);
            PsePendingFragment.this.openFragment(clusterNumberFragment, "cluster_details");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return PsePendingFragment.this.allhousesList.size();
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
