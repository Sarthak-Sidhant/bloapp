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
import in.gov.eci.bloapp.databinding.BloFragmentPseDoneBinding;
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
public class PseDoneFragment extends Fragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog1;
    private List<psePendingModel> allhousesList;
    BloFragmentPseDoneBinding binding;
    private String bloassemcode;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String refreshToken;
    Retrofit retrofit;
    private String stateCode;
    private String token = "";
    private final JSONArray payloadAllHouses1 = new JSONArray();
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PseDoneFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blopartnumber = "";
        this.bloassemcode = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseDoneBinding.inflate(getLayoutInflater());
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
        return this.binding.getRoot();
    }

    public JSONArray pseDoneList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartnumber);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).pseDone(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "application/json", map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("response pse: ", String.valueOf(response.code()));
            if (response.code() == 200) {
                Logger.d("response payload", String.valueOf(((EronetResponse) response.body()).getPayload()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    PseDoneFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (PseDoneFragment.this.payloadAllHouses.isEmpty()) {
                        return;
                    }
                    for (int i = 0; i < PseDoneFragment.this.payloadAllHouses.size(); i++) {
                        if (((LinkedTreeMap) PseDoneFragment.this.payloadAllHouses.get(i)).get("status").equals("Submitted")) {
                            PseDoneFragment.this.payloadAllHouses1.add(PseDoneFragment.this.payloadAllHouses.get(i));
                        }
                    }
                    if (!PseDoneFragment.this.payloadAllHouses1.isEmpty()) {
                        PseDoneFragment pseDoneFragment = PseDoneFragment.this;
                        pseDoneFragment.renderingdata(pseDoneFragment.payloadAllHouses1);
                    } else {
                        PseDoneFragment.this.alertDialog1.dismiss();
                        PseDoneFragment.this.binding.nodatalayout.setVisibility(0);
                        PseDoneFragment.this.binding.allAppsRv.setVisibility(8);
                    }
                    PseDoneFragment.this.alertDialog1.dismiss();
                    return;
                }
                PseDoneFragment.this.alertDialog1.dismiss();
                PseDoneFragment.this.binding.nodatalayout.setVisibility(0);
                PseDoneFragment.this.binding.allAppsRv.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                PseDoneFragment.this.commomUtility.getRefreshToken(PseDoneFragment.this.getContext(), PseDoneFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i2, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("errorResponse", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
            }
            PseDoneFragment.this.alertDialog1.dismiss();
            PseDoneFragment.this.binding.nodatalayout.setVisibility(0);
            PseDoneFragment.this.binding.allAppsRv.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseDoneFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseDoneFragment.this.commomUtility.showMessageOK(PseDoneFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseDoneFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseDoneFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseDoneFragment.this.requireContext()).setToken("Bearer " + str);
            PseDoneFragment.this.pseDoneList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseDoneFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseDoneFragment.this.requireContext()).setLocaleBool(false);
            PseDoneFragment.this.startActivity(new Intent((Context) PseDoneFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            PseDoneFragment.this.alertDialog1.dismiss();
            PseDoneFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$$ExternalSyntheticLambda0
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloPsependingRvItemBinding.inflate(PseDoneFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloPsependingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloPsependingRvItemBinding) holder.binding).HNoTv.setText(((psePendingModel) PseDoneFragment.this.allhousesList.get(position)).getClusterId());
            final String str = ((psePendingModel) PseDoneFragment.this.allhousesList.get(position)).clusterId;
            ((BloPsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseDoneFragment$2$$ExternalSyntheticLambda0
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
            bundle.putString("Flag", "1");
            ClusterNumberFragment clusterNumberFragment = new ClusterNumberFragment();
            clusterNumberFragment.setArguments(bundle);
            PseDoneFragment.this.openFragment(clusterNumberFragment, "cluster_details");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return PseDoneFragment.this.allhousesList.size();
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
