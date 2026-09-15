package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentTrackStatusBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;
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
public class TrackStatusFragment extends Fragment {
    String acNo;
    AlertDialog alertDialog;
    final Retrofit.Builder builder1;
    Bundle bundle;
    final CommomUtility commomUtility;
    BloFragmentTrackStatusBinding fragmentTrackStatusBinding;
    LayoutInflater inf;
    final OkHttpClient okHttpClient;
    String refID;
    String refreshToken;
    final Retrofit retrofit;
    String stateCode;
    String token;

    public TrackStatusFragment() {
        CommomUtility commomUtility = new CommomUtility();
        this.commomUtility = commomUtility;
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild);
        this.builder1 = builderClient;
        this.retrofit = builderClient.build();
        this.bundle = new Bundle();
        this.inf = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fragmentTrackStatusBinding = BloFragmentTrackStatusBinding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.inf = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment.1
            public void handleOnBackPressed() {
                TrackStatusFragment.this.startActivity(new Intent((Context) TrackStatusFragment.this.getActivity(), (Class<?>) VoterForms.class));
            }
        });
        this.fragmentTrackStatusBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.fragmentTrackStatusBinding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        getdata();
        return this.fragmentTrackStatusBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new VoterFormsFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getdata() {
        this.fragmentTrackStatusBinding.trackStatusLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$getdata$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdata$2(View view) {
        if (this.fragmentTrackStatusBinding.referenceIdEd.getText().toString().length() > 10 && this.fragmentTrackStatusBinding.referenceIdEd.getText().toString().matches("^[A-Za-z0-9]*$")) {
            this.refID = this.fragmentTrackStatusBinding.referenceIdEd.getText().toString();
            Logger.d("token", this.token);
            Logger.d("stateCode", this.stateCode);
            Logger.d("refID", this.refID);
            Call<JsonObject> callErotrackstatus = this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).erotrackstatus(this.refID, this.token, "blo", this.stateCode, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "ANDROIDMOB");
            this.alertDialog.show();
            callErotrackstatus.enqueue(new AnonymousClass2());
            return;
        }
        this.fragmentTrackStatusBinding.referenceIdEd.setError("Please enter correct reference no.");
        this.fragmentTrackStatusBinding.frame.removeAllViews();
        showDialog("Please enter correct reference no");
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            String str;
            String str2;
            String str3;
            String str4;
            TrackStatusFragment.this.alertDialog.show();
            if (response.body() != null) {
                TrackStatusFragment.this.alertDialog.dismiss();
                try {
                    jSONObject = (JSONObject) new JSONObject(String.valueOf(response.body())).get("payload");
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                try {
                    String string = jSONObject.get(Constants.FIRST_NAME).toString();
                    String str5 = string.equals("null") ? "" : string;
                    String string2 = jSONObject.get(Constants.LAST_NAME).toString();
                    if (string2.equals("null")) {
                        string2 = "";
                    }
                    String string3 = jSONObject.get("formType").toString();
                    if (string3.equals("null")) {
                        string3 = "";
                    }
                    String str6 = string3;
                    String string4 = jSONObject.get("formRefNo").toString();
                    if (string4.equals("null")) {
                        string4 = "";
                    }
                    String string5 = jSONObject.get("accepted").toString();
                    if (string5.equals("null")) {
                        string5 = "";
                    }
                    String str7 = string5;
                    String string6 = jSONObject.get("fvrSubmitted").toString();
                    if (string6.equals("null")) {
                        string6 = "";
                    }
                    String string7 = jSONObject.get("bloAssigned").toString();
                    if (string7.equals("null")) {
                        string7 = "";
                    }
                    String string8 = jSONObject.get("hearingScheduled").toString();
                    if (string8.equals("null")) {
                        string8 = "";
                    }
                    String str8 = string8;
                    String string9 = jSONObject.get("submissionDate").toString();
                    if (string9.equals("null")) {
                        string9 = "";
                    }
                    String str9 = string6;
                    String string10 = jSONObject.get("currentStatus").toString();
                    if (string10.equals("null")) {
                        string10 = "";
                    }
                    String string11 = jSONObject.get("submitted").toString();
                    if (string11.equals("null")) {
                        string11 = "";
                    }
                    String string12 = jSONObject.get("epicNo").toString();
                    if (string12.equals("null")) {
                        string12 = "";
                    }
                    String string13 = jSONObject.get("epicDispatchedDate").toString();
                    if (string13.equals("null")) {
                        str2 = "fvrSubmittedHearingScheduled";
                        str = "";
                    } else {
                        str = string13;
                        str2 = "fvrSubmittedHearingScheduled";
                    }
                    String str10 = str2;
                    String string14 = jSONObject.get(str2).toString();
                    if (string14.equals("null")) {
                        str4 = "rejected";
                        str3 = "";
                    } else {
                        str3 = string14;
                        str4 = "rejected";
                    }
                    String str11 = str4;
                    String string15 = jSONObject.get(str4).toString();
                    String str12 = string15.equals("null") ? "" : string15;
                    String string16 = jSONObject.get(r38).toString();
                    String str13 = string16.equals("null") ? "" : string16;
                    try {
                        String str14 = string7;
                        TrackStatusFragment.this.acNo = jSONObject.get("acNo").toString();
                        if (TrackStatusFragment.this.acNo.equals("null")) {
                            TrackStatusFragment.this.acNo = "";
                        }
                        TrackStatusFragment.this.bundle.putString(Constants.FIRST_NAME, str5);
                        TrackStatusFragment.this.bundle.putString(Constants.LAST_NAME, string2);
                        TrackStatusFragment.this.bundle.putString("formRefNo", string4);
                        TrackStatusFragment.this.bundle.putString("formType", str6);
                        TrackStatusFragment.this.bundle.putString("submissionDate", string9);
                        TrackStatusFragment.this.bundle.putString("currentStatus", string10);
                        TrackStatusFragment.this.bundle.putString("submitted", string11);
                        TrackStatusFragment.this.bundle.putString("bloAssigned", str14);
                        TrackStatusFragment.this.bundle.putString("fvrSubmitted", str9);
                        TrackStatusFragment.this.bundle.putString("epicNo", string12);
                        TrackStatusFragment.this.bundle.putString("epicDispatchedDate", str);
                        TrackStatusFragment.this.bundle.putString("hearingScheduled", str8);
                        TrackStatusFragment.this.bundle.putString(str10, str3);
                        TrackStatusFragment.this.bundle.putString("accepted", str7);
                        TrackStatusFragment.this.bundle.putString(str11, str12);
                        TrackStatusFragment.this.bundle.putString("erollUpdatedDate", str13);
                    } catch (JSONException unused2) {
                    }
                } catch (JSONException unused3) {
                    this = this;
                }
                System.out.println(TrackStatusFragment.this.acNo + "TTTTTTTTTTTTTTTTTTTTT" + SharedPref.getInstance(TrackStatusFragment.this.requireContext()).getAssemblyNumber());
                if (TrackStatusFragment.this.acNo.equals(SharedPref.getInstance(TrackStatusFragment.this.requireContext()).getAssemblyNumber()) && TrackStatusFragment.this.stateCode.equals(SharedPref.getInstance(TrackStatusFragment.this.requireContext()).getStateCode())) {
                    TrackStatusFragment.this.openFragment1(new TrackStatusButtonFragment());
                    return;
                } else {
                    TrackStatusFragment.this.showDialog("This reference number does not belongs  to your AC.");
                    return;
                }
            }
            TrackStatusFragment.this.fragmentTrackStatusBinding.frame.removeAllViews();
            TrackStatusFragment.this.alertDialog.dismiss();
            try {
                TrackStatusFragment.this.showDialog(new JSONObject(response.errorBody().string()).get("message").toString());
            } catch (Exception unused4) {
            }
            if (response.code() == 401) {
                TrackStatusFragment trackStatusFragment = TrackStatusFragment.this;
                trackStatusFragment.refreshToken = SharedPref.getInstance(trackStatusFragment.requireContext()).getRefreshToken();
                TrackStatusFragment.this.commomUtility.getRefreshToken(TrackStatusFragment.this.requireContext(), TrackStatusFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str15, String str16) {
                        this.f$0.lambda$onResponse$1(i, str15, str16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                TrackStatusFragment.this.commomUtility.showMessageWithTitleOK(TrackStatusFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            System.out.println("zxnbchdbvfhvb ---> else refresh" + i + StringUtils.SPACE + str + StringUtils.SPACE);
            TrackStatusFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(TrackStatusFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(TrackStatusFragment.this.requireContext()).setToken("Bearer " + str);
            TrackStatusFragment.this.getdata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(TrackStatusFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(TrackStatusFragment.this.getContext()).setLocaleBool(false);
            TrackStatusFragment.this.startActivity(new Intent((Context) TrackStatusFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, "Voter Forms");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment1(Fragment fragment) {
        fragment.setArguments(this.bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, "app");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
