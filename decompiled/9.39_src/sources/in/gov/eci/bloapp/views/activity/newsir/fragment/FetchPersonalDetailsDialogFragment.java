package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.DialogFetchPersonalDetailsBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EpicIssuedAdapter;
import in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.FormInProcessAdapter;
import in.gov.eci.bloapp.views.model.EpicIssuedPayload;
import in.gov.eci.bloapp.views.model.EpicIssuedRoot;
import in.gov.eci.bloapp.views.model.FormInProcessPayload;
import in.gov.eci.bloapp.views.model.FormInProcessRoot;
import in.gov.eci.bloapp.views.model.InnerResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FetchPersonalDetailsDialogFragment extends DialogFragment {
    String ac;
    private String acNo;
    FormInProcessAdapter adapter;
    int age;
    AlertDialog alertDialog;
    private String atkband;
    private DialogFetchPersonalDetailsBinding binding;
    EpicIssuedAdapter epicIssuedAdapter;
    String gender;
    private OnDataReceivedListener listener;
    String name;
    private String partNo;
    private String refreshToken;
    String rlnName;
    String rlnType;
    private String rtkband;
    EpicIssuedPayload selectedItem;
    private String state;
    String stateCd;
    private String token;
    UserClient userClient;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    Gson gson = new GsonBuilder().setLenient().create();
    String dsedeclaration = "N";
    ArrayList<FormInProcessPayload> forminprocessList = new ArrayList<>();
    ArrayList<EpicIssuedPayload> epicissuedList = new ArrayList<>();
    boolean isitemSelected = false;

    public interface OnDataReceivedListener {
        void onDataReceived(EpicIssuedPayload epicIssuedPayload, MappingList mappingList, String result3, String dsedeclaration);
    }

    public void setOnDataReceivedListener(OnDataReceivedListener listener) {
        this.listener = listener;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setGravity(17);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        return dialogOnCreateDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DialogFetchPersonalDetailsBinding.inflate(getLayoutInflater());
        if (getArguments() != null) {
            this.stateCd = getArguments().getString("stateCd");
            this.name = getArguments().getString("name");
            this.age = getArguments().getInt("age");
            this.gender = getArguments().getString("gender");
            this.rlnName = getArguments().getString("rlnName");
            this.rlnType = getArguments().getString("rlnType");
            this.ac = getArguments().getString("acNo");
        }
        init();
        getSessionValue();
        handleButtonClicks();
        return this.binding.getRoot();
    }

    private void handleButtonClicks() {
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FetchPersonalDetailsDialogFragment.this.listener != null) {
                    FetchPersonalDetailsDialogFragment.this.dismiss();
                }
            }
        });
        this.binding.cbNotsubmitted.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FetchPersonalDetailsDialogFragment.this.binding.cbNotsubmitted.isChecked()) {
                    if (FetchPersonalDetailsDialogFragment.this.isitemSelected) {
                        FetchPersonalDetailsDialogFragment.this.dsedeclaration = "N";
                        FetchPersonalDetailsDialogFragment.this.binding.form8.setVisibility(0);
                        FetchPersonalDetailsDialogFragment.this.binding.form6.setVisibility(8);
                        return;
                    } else {
                        FetchPersonalDetailsDialogFragment.this.dsedeclaration = "Y";
                        FetchPersonalDetailsDialogFragment.this.binding.form8.setVisibility(8);
                        FetchPersonalDetailsDialogFragment.this.binding.form6.setVisibility(0);
                        return;
                    }
                }
                FetchPersonalDetailsDialogFragment.this.dsedeclaration = "N";
            }
        });
        this.binding.form8.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FetchPersonalDetailsDialogFragment.this.listener != null) {
                    FetchPersonalDetailsDialogFragment.this.dismiss();
                    FetchPersonalDetailsDialogFragment.this.listener.onDataReceived(FetchPersonalDetailsDialogFragment.this.selectedItem, null, "form8", FetchPersonalDetailsDialogFragment.this.dsedeclaration);
                }
            }
        });
        this.binding.form6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FetchPersonalDetailsDialogFragment.this.listener != null) {
                    FetchPersonalDetailsDialogFragment.this.dismiss();
                    FetchPersonalDetailsDialogFragment.this.listener.onDataReceived(null, null, "form6", FetchPersonalDetailsDialogFragment.this.dsedeclaration);
                }
            }
        });
        this.binding.exit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FetchPersonalDetailsDialogFragment.this.listener != null) {
                    FetchPersonalDetailsDialogFragment.this.dismiss();
                    FetchPersonalDetailsDialogFragment.this.listener.onDataReceived(null, null, "exit", FetchPersonalDetailsDialogFragment.this.dsedeclaration);
                }
            }
        });
    }

    private void init() {
        this.utils = new Utils();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
    }

    private void getSessionValue() {
        this.atkband = SharedPref.getInstance(requireActivity()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireActivity()).getRtknBnd();
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.state = SharedPref.getInstance(requireActivity()).getStateCode();
        this.acNo = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
        checkDseInIndiaFormProcessing();
        new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment.6
            @Override // java.lang.Runnable
            public void run() {
                FetchPersonalDetailsDialogFragment.this.DseElasticRequestApis();
            }
        }, 2000L);
    }

    public void checkDseInIndiaFormProcessing() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("stateCd", this.state);
        map2.put("name", this.name);
        map2.put("age", Integer.valueOf(this.age));
        map2.put("gender", this.gender);
        map2.put("rlnName", this.rlnName);
        map2.put("rlnType", this.rlnType);
        map2.put("acNo", this.acNo);
        this.state.toLowerCase();
        Call<FormInProcessRoot> callCheckDseInIndiaFormProcessing = ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).checkDseInIndiaFormProcessing(map, map2);
        this.alertDialog.show();
        callCheckDseInIndiaFormProcessing.enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<FormInProcessRoot> {
        static /* synthetic */ void lambda$onResponse$0() {
        }

        AnonymousClass7() {
        }

        public void onResponse(Call<FormInProcessRoot> call, Response<FormInProcessRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (FetchPersonalDetailsDialogFragment.this.forminprocessList.size() > 0) {
                        FetchPersonalDetailsDialogFragment.this.forminprocessList.clear();
                    }
                    FetchPersonalDetailsDialogFragment.this.forminprocessList = ((FormInProcessRoot) response.body()).getPayload();
                    if (FetchPersonalDetailsDialogFragment.this.forminprocessList.size() > 0) {
                        Logger.d("blo list size", "" + FetchPersonalDetailsDialogFragment.this.forminprocessList.size());
                        FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setLayoutManager(new LinearLayoutManager(FetchPersonalDetailsDialogFragment.this.requireActivity()));
                        if (FetchPersonalDetailsDialogFragment.this.forminprocessList != null && !FetchPersonalDetailsDialogFragment.this.forminprocessList.isEmpty()) {
                            FetchPersonalDetailsDialogFragment.this.binding.mainLayout.setVisibility(0);
                            FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setVisibility(0);
                            FetchPersonalDetailsDialogFragment.this.adapter = new FormInProcessAdapter(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.forminprocessList, new FormInProcessAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment$7$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.FormInProcessAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    FetchPersonalDetailsDialogFragment.AnonymousClass7.lambda$onResponse$0();
                                }
                            });
                            FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setLayoutManager(new LinearLayoutManager(FetchPersonalDetailsDialogFragment.this.getContext()));
                            FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setNestedScrollingEnabled(false);
                            FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setAdapter(FetchPersonalDetailsDialogFragment.this.adapter);
                        }
                    } else {
                        FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                    }
                } catch (Exception unused) {
                }
                FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                    FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                    FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    FetchPersonalDetailsDialogFragment.this.utils.infoDialog(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                } else {
                    FetchPersonalDetailsDialogFragment.this.utils.infoDialog(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                    FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                    FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        public void onFailure(Call<FormInProcessRoot> call, Throwable t) {
            if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    public void DseElasticRequestApis() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("stateCd", this.state);
        map2.put("name", this.name);
        map2.put("age", Integer.valueOf(this.age));
        map2.put("gender", this.gender);
        map2.put("rlnName", this.rlnName);
        map2.put("rlnType", this.rlnType);
        map2.put("acNo", this.acNo);
        this.state.toLowerCase();
        Call<EpicIssuedRoot> callDseElasticRequestApis = ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).DseElasticRequestApis(map, map2);
        this.alertDialog.show();
        callDseElasticRequestApis.enqueue(new AnonymousClass8());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<EpicIssuedRoot> {
        AnonymousClass8() {
        }

        public void onResponse(Call<EpicIssuedRoot> call, Response<EpicIssuedRoot> response) {
            if (!response.isSuccessful() || response.body() == null) {
                if (response.code() == 401) {
                    if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                        FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                        FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                    }
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString("message");
                    if (TextUtils.isEmpty(strOptString)) {
                        FetchPersonalDetailsDialogFragment.this.utils.infoDialog(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                    } else {
                        FetchPersonalDetailsDialogFragment.this.utils.infoDialog(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                    }
                    Logger.e("TAG", strOptString);
                    if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                        FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                } catch (IOException | JSONException e) {
                    if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                        FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                    }
                    Logger.e("TAG", e.getMessage());
                    return;
                }
            }
            try {
                if (FetchPersonalDetailsDialogFragment.this.epicissuedList.size() > 0) {
                    FetchPersonalDetailsDialogFragment.this.epicissuedList.clear();
                }
                EpicIssuedRoot epicIssuedRoot = (EpicIssuedRoot) response.body();
                Gson gson = new Gson();
                FetchPersonalDetailsDialogFragment.this.epicissuedList = ((InnerResponse) gson.fromJson(epicIssuedRoot.getWithinState(), InnerResponse.class)).getPayload();
                if (FetchPersonalDetailsDialogFragment.this.epicissuedList.size() > 0) {
                    Logger.d("blo list size", "" + FetchPersonalDetailsDialogFragment.this.epicissuedList.size());
                    FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setLayoutManager(new LinearLayoutManager(FetchPersonalDetailsDialogFragment.this.requireActivity()));
                    if (FetchPersonalDetailsDialogFragment.this.forminprocessList != null && !FetchPersonalDetailsDialogFragment.this.epicissuedList.isEmpty()) {
                        FetchPersonalDetailsDialogFragment.this.binding.mainLayout.setVisibility(0);
                        FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setVisibility(0);
                        FetchPersonalDetailsDialogFragment.this.epicIssuedAdapter = new EpicIssuedAdapter(FetchPersonalDetailsDialogFragment.this.requireActivity(), FetchPersonalDetailsDialogFragment.this.epicissuedList, new EpicIssuedAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.FetchPersonalDetailsDialogFragment$8$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EpicIssuedAdapter.OnItemSelectedListener
                            public final void onItemSelected() {
                                this.f$0.lambda$onResponse$0();
                            }
                        });
                        FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setLayoutManager(new LinearLayoutManager(FetchPersonalDetailsDialogFragment.this.getContext()));
                        FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setNestedScrollingEnabled(false);
                        FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setAdapter(FetchPersonalDetailsDialogFragment.this.epicIssuedAdapter);
                    }
                } else {
                    FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
                }
                if (FetchPersonalDetailsDialogFragment.this.forminprocessList.isEmpty() && FetchPersonalDetailsDialogFragment.this.epicissuedList.isEmpty()) {
                    FetchPersonalDetailsDialogFragment.this.dismiss();
                    FetchPersonalDetailsDialogFragment.this.listener.onDataReceived(null, null, "form6", "N");
                } else if (!FetchPersonalDetailsDialogFragment.this.forminprocessList.isEmpty() && FetchPersonalDetailsDialogFragment.this.epicissuedList.isEmpty()) {
                    FetchPersonalDetailsDialogFragment.this.binding.mainLayout.setVisibility(0);
                    FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setVisibility(0);
                    FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setVisibility(8);
                } else if (FetchPersonalDetailsDialogFragment.this.forminprocessList.isEmpty() && !FetchPersonalDetailsDialogFragment.this.epicissuedList.isEmpty()) {
                    FetchPersonalDetailsDialogFragment.this.binding.mainLayout.setVisibility(0);
                    FetchPersonalDetailsDialogFragment.this.binding.rvFormsInProcess.setVisibility(8);
                    FetchPersonalDetailsDialogFragment.this.binding.rvEpicIssued.setVisibility(0);
                }
            } catch (Exception unused) {
            }
            FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FetchPersonalDetailsDialogFragment.this.binding.form8.setVisibility(0);
            for (int i = 0; i <= FetchPersonalDetailsDialogFragment.this.epicissuedList.size(); i++) {
                if (FetchPersonalDetailsDialogFragment.this.epicissuedList.get(i).isSelected()) {
                    FetchPersonalDetailsDialogFragment.this.isitemSelected = true;
                    FetchPersonalDetailsDialogFragment fetchPersonalDetailsDialogFragment = FetchPersonalDetailsDialogFragment.this;
                    fetchPersonalDetailsDialogFragment.selectedItem = fetchPersonalDetailsDialogFragment.epicissuedList.get(i);
                    FetchPersonalDetailsDialogFragment.this.binding.form6.setVisibility(8);
                    FetchPersonalDetailsDialogFragment.this.binding.form8.setVisibility(0);
                    FetchPersonalDetailsDialogFragment.this.binding.cbNotsubmitted.setChecked(false);
                    FetchPersonalDetailsDialogFragment.this.dsedeclaration = "N";
                    return;
                }
            }
        }

        public void onFailure(Call<EpicIssuedRoot> call, Throwable t) {
            if (FetchPersonalDetailsDialogFragment.this.alertDialog != null) {
                FetchPersonalDetailsDialogFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }
}
