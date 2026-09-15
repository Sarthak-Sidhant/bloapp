package in.gov.eci.bloapp.views.fragments.elector_data_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentElectorDataSyncBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ElectorDataSyncFragment extends Hilt_ElectorDataSyncFragment {
    public static final String ALERT = "Alert";
    public static final String TAG = "ElectorDataSyncFragment";
    AlertDialog alertDialog;
    BloFragmentElectorDataSyncBinding binding;
    String color1C77FF;
    String colorFF000000;
    String colorFFFFFF;
    String colorFFFFFFFF;
    String ddMMyyyyhhmmss;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    String formattedDate;
    String formattedDateFromat;
    H2HSurveyStatusModel.Payload h2HSurveyPayLoad;
    String h2h;
    HouseSurveyModel.Payload houseSurveyPayLoad;
    PartElectorDetailsModel.Items partElectorPayload;
    String timeStamp;
    SimpleDateFormat timeStampTemp;
    SimpleDateFormat todayDate;
    SimpleDateFormat todayDateFormat;
    private int progr = 0;
    String token = "";
    String refreshTokenApiCalled = "Refresh token Api Called";
    String stateCode = "";
    String refreshToken = "";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String modifiedOnElector = "";
    String lastSyncStatusElector = "";
    String modifiedOnVerified = "";
    String lastSyncStatusVerified = "";
    String modifiedOnH2hSurveyStatus = "";
    String lastSyncStatusH2hSurvey = "";
    int pageNumber = 1;
    int pageLimit = 100;
    String isTotalCount = "Y";
    int totalElectorCount = 0;
    CommomUtility commomUtility = new CommomUtility();
    String acNo = "";
    String bloId = "";
    String partNumber = "";
    int count = 0;
    String success = "SUCCESS";
    String failure = "FAILURE";
    Date c = Calendar.getInstance().getTime();

    static /* synthetic */ void lambda$onCreateView$2(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$onCreateView$4(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$onCreateView$6(DialogInterface dialogInterface, int i) {
    }

    public ElectorDataSyncFragment() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault());
        this.todayDate = simpleDateFormat;
        this.formattedDate = simpleDateFormat.format(this.c);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        this.todayDateFormat = simpleDateFormat2;
        this.formattedDateFromat = simpleDateFormat2.format(this.c);
        this.ddMMyyyyhhmmss = "ddMMyyyyhhmmss";
        this.colorFFFFFFFF = "#FFFFFFFF";
        this.colorFF000000 = "#FF000000";
        this.colorFFFFFF = "#FFFFFF";
        this.color1C77FF = "#1C77FF";
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(this.ddMMyyyyhhmmss, Locale.getDefault());
        this.timeStampTemp = simpleDateFormat3;
        this.timeStamp = simpleDateFormat3.format(new Date());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentElectorDataSyncBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloId = SharedPref.getInstance(requireContext()).getPreferredUsername();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(TAG, "Token ---> " + this.token);
        Logger.d(TAG, "StateCode ---> " + this.stateCode);
        Logger.d(TAG, "AcNo ---> " + this.acNo);
        Logger.d(TAG, "PartNumber ---> " + this.partNumber);
        Logger.d(TAG, "bloId ---> " + this.bloId);
        this.binding.totalData.setVisibility(8);
        this.binding.progressBar.setVisibility(8);
        this.binding.progressBar.setProgress(0);
        this.binding.totalData.setText(this.progr + "%");
        this.binding.textViewConstituencyDetails.setText(this.acNo + " | " + SharedPref.getInstance(requireContext()).getAssemblyName() + " | " + this.partNumber);
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        updateProgressBar();
        this.binding.onlineButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.offlineButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            getBloAppProfile(this.stateCode, this.token);
            this.binding.totalElectorDataSync.setEnabled(true);
            this.binding.dataSyncVerified.setEnabled(true);
            this.binding.h2hSurveyButton.setEnabled(true);
            this.binding.offlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_blue));
            this.binding.offlineButton.setTextColor(Color.parseColor(this.colorFFFFFFFF));
            this.binding.onlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_white));
            this.binding.onlineButton.setTextColor(Color.parseColor(this.colorFF000000));
            this.binding.totalElectorDataSync.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
            this.binding.totalElectorDataSync.setTextColor(Color.parseColor(this.color1C77FF));
            this.binding.dataSyncVerified.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
            this.binding.dataSyncVerified.setTextColor(Color.parseColor(this.color1C77FF));
            this.binding.h2hSurveyButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
            this.binding.h2hSurveyButton.setTextColor(Color.parseColor(this.color1C77FF));
        } else {
            this.binding.totalElectorDataSync.setEnabled(false);
            this.binding.dataSyncVerified.setEnabled(false);
            this.binding.h2hSurveyButton.setEnabled(false);
            this.binding.onlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_blue));
            this.binding.onlineButton.setTextColor(Color.parseColor(this.colorFFFFFFFF));
            this.binding.offlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_white));
            this.binding.offlineButton.setTextColor(Color.parseColor(this.colorFF000000));
            this.binding.totalElectorDataSync.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
            this.binding.totalElectorDataSync.setTextColor(Color.parseColor(this.colorFFFFFF));
            this.binding.dataSyncVerified.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
            this.binding.dataSyncVerified.setTextColor(Color.parseColor(this.colorFFFFFF));
            this.binding.h2hSurveyButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
            this.binding.h2hSurveyButton.setTextColor(Color.parseColor(this.colorFFFFFF));
        }
        this.binding.totalElectorsTextView.setText(String.valueOf(((ArrayList) this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(this.partNumber, this.bloId)).size()));
        ArrayList arrayList = (ArrayList) this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getLastModifiedDate(this.partNumber, this.bloId);
        if (!arrayList.isEmpty()) {
            this.modifiedOnElector = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
            this.lastSyncStatusElector = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
            this.binding.totalElectorsSyncStatus.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
            this.binding.totalElectorsSyncDate.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn());
        } else {
            this.lastSyncStatusElector = "";
            this.modifiedOnElector = "";
        }
        this.binding.totalElectorDataSync.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(this.partNumber, this.bloId)).size()));
        ArrayList arrayList2 = (ArrayList) this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(this.partNumber, this.bloId);
        if (!arrayList2.isEmpty()) {
            this.modifiedOnVerified = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
            this.lastSyncStatusVerified = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus();
            this.binding.lastVerifiedDetailSyncStatus.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus());
            this.binding.verifiedSyncDate.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn());
        } else {
            this.modifiedOnVerified = "";
        }
        this.binding.dataSyncVerified.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(this.partNumber), this.bloId)).size()));
        ArrayList arrayList3 = (ArrayList) this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getLastModifiedDate(Integer.parseInt(this.partNumber), this.bloId);
        if (!arrayList3.isEmpty()) {
            this.modifiedOnH2hSurveyStatus = ((H2HSurveyStatusModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
            this.lastSyncStatusH2hSurvey = ((H2HSurveyStatusModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus();
            this.binding.lastH2hSurveyStatus.setText(((H2HSurveyStatusModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus());
            this.binding.h2hSurveySyncDate.setText(((H2HSurveyStatusModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn());
        } else {
            this.modifiedOnH2hSurveyStatus = "";
        }
        this.binding.h2hSurveyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        this.binding.totalElectorDataSync.setEnabled(false);
        this.binding.dataSyncVerified.setEnabled(false);
        this.binding.h2hSurveyButton.setEnabled(false);
        this.binding.onlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_blue));
        this.binding.onlineButton.setTextColor(Color.parseColor(this.colorFFFFFFFF));
        this.binding.offlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_white));
        this.binding.offlineButton.setTextColor(Color.parseColor(this.colorFF000000));
        this.binding.totalElectorDataSync.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
        this.binding.totalElectorDataSync.setTextColor(Color.parseColor(this.colorFFFFFF));
        this.binding.dataSyncVerified.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
        this.binding.dataSyncVerified.setTextColor(Color.parseColor(this.colorFFFFFF));
        this.binding.h2hSurveyButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_online));
        this.binding.h2hSurveyButton.setTextColor(Color.parseColor(this.colorFFFFFF));
        SharedPref.getInstance(requireContext()).setIsOnline("Y");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        getBloAppProfile(this.stateCode, this.token);
        Constants.sectionFil = 0;
        this.binding.totalElectorDataSync.setEnabled(true);
        this.binding.dataSyncVerified.setEnabled(true);
        this.binding.h2hSurveyButton.setEnabled(true);
        this.binding.offlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_blue));
        this.binding.offlineButton.setTextColor(Color.parseColor(this.colorFFFFFFFF));
        this.binding.onlineButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_white));
        this.binding.onlineButton.setTextColor(Color.parseColor(this.colorFF000000));
        this.binding.totalElectorDataSync.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
        this.binding.totalElectorDataSync.setTextColor(Color.parseColor(this.color1C77FF));
        this.binding.dataSyncVerified.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
        this.binding.dataSyncVerified.setTextColor(Color.parseColor(this.color1C77FF));
        this.binding.h2hSurveyButton.setBackground(getResources().getDrawable(R.drawable.blo_elector_data_sync_rectangle_4));
        this.binding.h2hSurveyButton.setTextColor(Color.parseColor(this.color1C77FF));
        SharedPref.getInstance(requireContext()).setIsOnline("N");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        Logger.d(TAG, "modifiedOnElector ---> " + this.modifiedOnElector);
        Logger.d(TAG, "formatted_Date ---> " + this.formattedDateFromat);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.ddMMyyyyhhmmss, Locale.getDefault());
        this.timeStampTemp = simpleDateFormat;
        this.timeStamp = simpleDateFormat.format(new Date());
        if (isNetworkAvailable(requireContext())) {
            if (this.modifiedOnElector.equals(this.formattedDateFromat) && this.lastSyncStatusElector.equals(this.success)) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Data is already synced for " + this.modifiedOnElector, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.lambda$onCreateView$2(dialogInterface, i);
                    }
                });
                return;
            }
            this.alertDialog.show();
            this.progr = 0;
            this.binding.totalData.setText(this.progr + "%");
            this.binding.progressBar.setProgress(0);
            initViewModel();
            return;
        }
        Toast.makeText(getContext(), "Please check network", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.ddMMyyyyhhmmss, Locale.getDefault());
        this.timeStampTemp = simpleDateFormat;
        this.timeStamp = simpleDateFormat.format(new Date());
        if (isNetworkAvailable(requireContext())) {
            if (this.modifiedOnVerified.equals(this.formattedDateFromat) && this.lastSyncStatusVerified.equals(this.success)) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Data is already synced for " + this.modifiedOnVerified, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.lambda$onCreateView$4(dialogInterface, i);
                    }
                });
                return;
            }
            this.alertDialog.show();
            this.progr = 0;
            this.binding.totalData.setText(this.progr + "%");
            this.binding.progressBar.setProgress(0);
            partElectorData();
            return;
        }
        Toast.makeText(getContext(), "Please check network", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.ddMMyyyyhhmmss, Locale.getDefault());
        this.timeStampTemp = simpleDateFormat;
        this.timeStamp = simpleDateFormat.format(new Date());
        if (isNetworkAvailable(requireContext())) {
            if (this.modifiedOnH2hSurveyStatus.equals(this.formattedDateFromat) && this.lastSyncStatusH2hSurvey.equals(this.success)) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Data is already synced for " + this.modifiedOnH2hSurveyStatus, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.lambda$onCreateView$6(dialogInterface, i);
                    }
                });
                return;
            }
            this.alertDialog.show();
            this.progr = 0;
            this.binding.totalData.setText(this.progr + "%");
            this.binding.progressBar.setProgress(0);
            h2hSurveyData();
            return;
        }
        Toast.makeText(getContext(), "Please check network", 1).show();
    }

    private void getBloAppProfile(String stateCode, String Token) {
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getBloAppProfile(stateCode, Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment.1
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                        ElectorDataSyncFragment.this.h2h = String.valueOf(asJsonArray.get(0).getAsJsonObject().get("h2h")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        Logger.d(ElectorDataSyncFragment.TAG, ElectorDataSyncFragment.this.h2h);
                        if (ElectorDataSyncFragment.this.h2h.isEmpty() || !ElectorDataSyncFragment.this.h2h.equalsIgnoreCase("N")) {
                            return;
                        }
                        ElectorDataSyncFragment.this.showDialog("This feature is disabled for your State as per the ECI direction");
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Logger.d("Content", e.getMessage());
            Toast.makeText(getContext().getApplicationContext(), "API failure", 1).show();
        }
    }

    private void h2hSurveyData() {
        HashMap map = new HashMap();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNumber);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getH2HSurveyStatusData(map, map2).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<H2HSurveyStatusModel.Root> {
        static /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
        }

        AnonymousClass2() {
        }

        public void onResponse(Call<H2HSurveyStatusModel.Root> call, final Response<H2HSurveyStatusModel.Root> response) {
            if (response.code() == 200) {
                if (!((H2HSurveyStatusModel.Root) response.body()).getPayload().isEmpty()) {
                    ElectorDataSyncFragment.this.binding.h2hSurveyStatusLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(8);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    ElectorDataSyncFragment.this.binding.totalData.setVisibility(0);
                    ElectorDataSyncFragment.this.binding.progressBar.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$3(response);
                        }
                    }, 6000L);
                    return;
                }
                ElectorDataSyncFragment.this.h2HSurveyPayLoad = new H2HSurveyStatusModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", 0, Integer.parseInt(ElectorDataSyncFragment.this.partNumber), 0, "", "", "", "", "", "", ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, "No verified houses");
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().addH2HSurveyDetails(ElectorDataSyncFragment.this.h2HSurveyPayLoad);
                ElectorDataSyncFragment.this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList.isEmpty()) {
                    ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusH2hSurvey = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.lastH2hSurveyStatus.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.h2hSurveySyncDate.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "Alert", "No h2H Survey Status", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.AnonymousClass2.lambda$onResponse$5(dialogInterface, i);
                    }
                });
                return;
            }
            if (response.code() == 401) {
                ElectorDataSyncFragment.this.h2HSurveyPayLoad = new H2HSurveyStatusModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", 0, Integer.parseInt(ElectorDataSyncFragment.this.partNumber), 0, "", "", "", "", "", "", ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().addH2HSurveyDetails(ElectorDataSyncFragment.this.h2HSurveyPayLoad);
                ElectorDataSyncFragment.this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList2 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList2.isEmpty()) {
                    ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusH2hSurvey = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.lastH2hSurveyStatus.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.h2hSurveySyncDate.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$6();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.refreshTokenApi();
                return;
            }
            ElectorDataSyncFragment.this.h2HSurveyPayLoad = new H2HSurveyStatusModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", 0, Integer.parseInt(ElectorDataSyncFragment.this.partNumber), 0, "", "", "", "", "", "", ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().addH2HSurveyDetails(ElectorDataSyncFragment.this.h2HSurveyPayLoad);
            ElectorDataSyncFragment.this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList3 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (arrayList3.isEmpty()) {
                ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = "";
            } else {
                ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = ((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                ElectorDataSyncFragment.this.lastSyncStatusH2hSurvey = ((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.lastH2hSurveyStatus.setText(((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.h2hSurveySyncDate.setText(((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$7();
                }
            }, 2000L);
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(ElectorDataSyncFragment.TAG, "getVerifiedEpicHouse errorResponse --> " + strOptString);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(ElectorDataSyncFragment.TAG, "eroPasswordFlow exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(final Response response) {
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId);
            if (!arrayList.isEmpty()) {
                ElectorDataSyncFragment.this.count = 0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ElectorDataSyncFragment.this.count = size;
                    ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().deleteH2HSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                }
            }
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += 50;
                ElectorDataSyncFragment.this.updateProgressBar();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1(response);
                }
            }, 2000L);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 3000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Response response) {
            for (int i = 0; i < ((H2HSurveyStatusModel.Root) response.body()).getPayload().size(); i++) {
                ((H2HSurveyStatusModel.Root) response.body()).getPayload().get(i).setBloId(ElectorDataSyncFragment.this.bloId);
                ((H2HSurveyStatusModel.Root) response.body()).getPayload().get(i).setModifiedOn(ElectorDataSyncFragment.this.formattedDate);
                ((H2HSurveyStatusModel.Root) response.body()).getPayload().get(i).setPartNo(Integer.parseInt(ElectorDataSyncFragment.this.partNumber));
                ((H2HSurveyStatusModel.Root) response.body()).getPayload().get(i).setLastSyncStatus(ElectorDataSyncFragment.this.success);
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().addH2HSurveyDetails(((H2HSurveyStatusModel.Root) response.body()).getPayload().get(i));
                ElectorDataSyncFragment.this.count++;
                Logger.d("TAG", "electorDetailsDatabaseHelperAdded ---> " + i);
            }
            ElectorDataSyncFragment.this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId)).size()));
            SharedPref.getInstance(ElectorDataSyncFragment.this.requireContext()).setLastVerifiedHouseSyncDate(ElectorDataSyncFragment.this.formattedDate);
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += 50;
                ElectorDataSyncFragment.this.updateProgressBar();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            Toast.makeText((Context) ElectorDataSyncFragment.this.getActivity(), (CharSequence) "H2H Survey Data Updated Successfully", 1).show();
            ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.h2hSurveyStatusLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalH2hSurveyStatus.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getLastModifiedDate(Integer.parseInt(ElectorDataSyncFragment.this.partNumber), ElectorDataSyncFragment.this.bloId);
            if (!arrayList.isEmpty()) {
                String[] strArrSplit = ((H2HSurveyStatusModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE);
                ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = strArrSplit[0];
                ElectorDataSyncFragment.this.lastSyncStatusH2hSurvey = ((H2HSurveyStatusModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.lastH2hSurveyStatus.setText(((H2HSurveyStatusModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.h2hSurveySyncDate.setText(((H2HSurveyStatusModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn());
            } else {
                ElectorDataSyncFragment.this.modifiedOnH2hSurveyStatus = "";
            }
            ElectorDataSyncFragment.this.binding.totalData.setVisibility(8);
            ElectorDataSyncFragment.this.binding.progressBar.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$6() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<H2HSurveyStatusModel.Root> call, Throwable t) {
            ElectorDataSyncFragment.this.h2HSurveyPayLoad = new H2HSurveyStatusModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", 0, Integer.parseInt(ElectorDataSyncFragment.this.partNumber), 0, "", "", "", "", "", "", ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure);
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().addH2HSurveyDetails(ElectorDataSyncFragment.this.h2HSurveyPayLoad);
            ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse onFailure Error ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$11();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$11() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgressBar() {
        this.binding.progressBar.setProgress(this.progr);
        this.binding.totalData.setText(this.progr + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewModel() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("stateCd", this.stateCode);
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNumber);
        map2.put("pageNumber", Integer.valueOf(this.pageNumber));
        map2.put("pageLimit", Integer.valueOf(this.pageLimit));
        map2.put("isTotalCount", this.isTotalCount);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getPartElector(map, map2).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<PartElectorDetailsModel.Root> {
        static /* synthetic */ void lambda$onResponse$6(DialogInterface dialogInterface, int i) {
        }

        AnonymousClass3() {
        }

        public void onResponse(Call<PartElectorDetailsModel.Root> call, final Response<PartElectorDetailsModel.Root> response) {
            if (response.code() == 200) {
                if (!((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().isEmpty()) {
                    ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.h2hSurveyStatusLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(8);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    ElectorDataSyncFragment.this.binding.totalData.setVisibility(0);
                    ElectorDataSyncFragment.this.binding.progressBar.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$4(response);
                        }
                    }, 6000L);
                    return;
                }
                ElectorDataSyncFragment.this.partElectorPayload = new PartElectorDetailsModel.Items(ElectorDataSyncFragment.this.timeStamp, ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, "Data not updated");
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().insertElecorDetails(ElectorDataSyncFragment.this.partElectorPayload);
                ElectorDataSyncFragment.this.binding.totalElectorsTextView.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList.isEmpty()) {
                    ElectorDataSyncFragment.this.lastSyncStatusElector = "";
                    ElectorDataSyncFragment.this.modifiedOnElector = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnElector = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusElector = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.totalElectorsSyncStatus.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.totalElectorsSyncDate.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$5();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "Alert", "No verified houses please start H2H Survey", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.AnonymousClass3.lambda$onResponse$6(dialogInterface, i);
                    }
                });
                return;
            }
            if (response.code() == 401) {
                ElectorDataSyncFragment.this.partElectorPayload = new PartElectorDetailsModel.Items(ElectorDataSyncFragment.this.timeStamp, ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().insertElecorDetails(ElectorDataSyncFragment.this.partElectorPayload);
                ElectorDataSyncFragment.this.binding.totalElectorsTextView.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList2 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList2.isEmpty()) {
                    ElectorDataSyncFragment.this.lastSyncStatusElector = "";
                    ElectorDataSyncFragment.this.modifiedOnElector = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnElector = ((PartElectorDetailsModel.Items) arrayList2.get(arrayList2.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusElector = ((PartElectorDetailsModel.Items) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.totalElectorsSyncStatus.setText(((PartElectorDetailsModel.Items) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.totalElectorsSyncDate.setText(((PartElectorDetailsModel.Items) arrayList2.get(arrayList2.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$7();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.refreshTokenApi();
                return;
            }
            ElectorDataSyncFragment.this.partElectorPayload = new PartElectorDetailsModel.Items(ElectorDataSyncFragment.this.timeStamp, ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().insertElecorDetails(ElectorDataSyncFragment.this.partElectorPayload);
            ElectorDataSyncFragment.this.binding.totalElectorsTextView.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList3 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (arrayList3.isEmpty()) {
                ElectorDataSyncFragment.this.lastSyncStatusElector = "";
                ElectorDataSyncFragment.this.modifiedOnElector = "";
            } else {
                ElectorDataSyncFragment.this.modifiedOnElector = ((PartElectorDetailsModel.Items) arrayList3.get(arrayList3.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                ElectorDataSyncFragment.this.lastSyncStatusElector = ((PartElectorDetailsModel.Items) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.totalElectorsSyncStatus.setText(((PartElectorDetailsModel.Items) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.totalElectorsSyncDate.setText(((PartElectorDetailsModel.Items) arrayList3.get(arrayList3.size() - 1)).getModifiedOn());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$8();
                }
            }, 2000L);
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(ElectorDataSyncFragment.TAG, "GetPartElector errorResponse --> " + strOptString);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetPartElector Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda10
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetPartElector Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda11
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(ElectorDataSyncFragment.TAG, "GetPartElector exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(final Response response) {
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            Logger.d("TAG", "OldData ---> " + arrayList.size());
            Logger.d("TAG", "NewData ---> " + ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().size());
            int size = arrayList.size() + ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().size();
            ElectorDataSyncFragment.this.totalElectorCount = ((PartElectorDetailsModel.Root) response.body()).getPayload().getTotalCount();
            Logger.d("TAG", "Total Data ---> " + size);
            if (((PartElectorDetailsModel.Root) response.body()).getPayload().getNext()) {
                ElectorDataSyncFragment.this.pageNumber++;
                ElectorDataSyncFragment.this.isTotalCount = "N";
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.initViewModel();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$3(response);
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += ElectorDataSyncFragment.this.pageNumber;
                if (ElectorDataSyncFragment.this.progr < 90) {
                    ElectorDataSyncFragment.this.updateProgressBar();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(Response response) {
            for (int i = 0; i < ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().size(); i++) {
                if (((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).getSectionName() == null || ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).getSectionName().equals("null")) {
                    ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).setSectionName("");
                }
                ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).setBloId(ElectorDataSyncFragment.this.bloId);
                ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).setModifiedOn(ElectorDataSyncFragment.this.formattedDate);
                ((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i).setLastSyncStatus(ElectorDataSyncFragment.this.success);
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().addPartElecorDetails(((PartElectorDetailsModel.Root) response.body()).getPayload().getItems().get(i));
                ElectorDataSyncFragment.this.count++;
                Logger.d("TAG", "electorDetailsDatabaseHelperAdded ---> " + i);
            }
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            SharedPref.getInstance(ElectorDataSyncFragment.this.requireContext()).setLastElectorSyncDate(ElectorDataSyncFragment.this.formattedDate);
            ElectorDataSyncFragment.this.binding.totalElectorsTextView.setText(String.valueOf(arrayList.size()));
            ElectorDataSyncFragment.this.binding.totalElectorsSyncDate.setText(SharedPref.getInstance(ElectorDataSyncFragment.this.requireContext()).getLastElectorSyncDate());
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += 50 - ElectorDataSyncFragment.this.pageNumber;
                ElectorDataSyncFragment.this.updateProgressBar();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 3000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            Toast.makeText((Context) ElectorDataSyncFragment.this.getActivity(), (CharSequence) "Total Elector Data Updated Successfully", 1).show();
            ElectorDataSyncFragment.this.binding.totalElectorsTextView.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (!arrayList.isEmpty()) {
                String[] strArrSplit = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE);
                ElectorDataSyncFragment.this.modifiedOnElector = strArrSplit[0];
                ElectorDataSyncFragment.this.lastSyncStatusElector = ((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.totalElectorsSyncStatus.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.totalElectorsSyncDate.setText(((PartElectorDetailsModel.Items) arrayList.get(arrayList.size() - 1)).getModifiedOn());
            } else {
                ElectorDataSyncFragment.this.lastSyncStatusElector = "";
                ElectorDataSyncFragment.this.modifiedOnElector = "";
            }
            ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalData.setVisibility(8);
            ElectorDataSyncFragment.this.binding.progressBar.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$8() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<PartElectorDetailsModel.Root> call, Throwable t) {
            ElectorDataSyncFragment.this.partElectorPayload = new PartElectorDetailsModel.Items(ElectorDataSyncFragment.this.timeStamp, ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure);
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().insertElecorDetails(ElectorDataSyncFragment.this.partElectorPayload);
            ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetPartElector onFailure Error ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$3$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$12();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$12() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }
    }

    private void partElectorData() {
        HashMap map = new HashMap();
        map.put("stCode", this.stateCode);
        map.put("acNo", this.acNo);
        map.put("partNo", this.partNumber);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Authorization", this.token);
        map2.put("currentRole", "blo");
        map2.put("state", this.stateCode);
        map2.put("Content-Type", "application/json");
        map2.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map2.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map2.put("channelidobo", "BLOAPP");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getVerifiedEpicHouse(map2, map).enqueue(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<HouseSurveyModel.Root> {
        static /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
        }

        AnonymousClass4() {
        }

        public void onResponse(Call<HouseSurveyModel.Root> call, final Response<HouseSurveyModel.Root> response) {
            if (response.code() == 200) {
                if (!((HouseSurveyModel.Root) response.body()).getPayload().isEmpty()) {
                    ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(8);
                    ElectorDataSyncFragment.this.binding.h2hSurveyStatusLayout.setVisibility(8);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    ElectorDataSyncFragment.this.binding.totalData.setVisibility(0);
                    ElectorDataSyncFragment.this.binding.progressBar.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$3(response);
                        }
                    }, 6000L);
                    return;
                }
                ElectorDataSyncFragment.this.houseSurveyPayLoad = new HouseSurveyModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", "", ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, "No verified houses");
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(ElectorDataSyncFragment.this.houseSurveyPayLoad);
                ElectorDataSyncFragment.this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList.isEmpty()) {
                    ElectorDataSyncFragment.this.modifiedOnVerified = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnVerified = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusVerified = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.lastVerifiedDetailSyncStatus.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.verifiedSyncDate.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "Alert", "No verified houses please start H2H Survey", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ElectorDataSyncFragment.AnonymousClass4.lambda$onResponse$5(dialogInterface, i);
                    }
                });
                return;
            }
            if (response.code() == 401) {
                ElectorDataSyncFragment.this.houseSurveyPayLoad = new HouseSurveyModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", "", ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(ElectorDataSyncFragment.this.houseSurveyPayLoad);
                ElectorDataSyncFragment.this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
                ArrayList arrayList2 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                if (arrayList2.isEmpty()) {
                    ElectorDataSyncFragment.this.modifiedOnVerified = "";
                } else {
                    ElectorDataSyncFragment.this.modifiedOnVerified = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                    ElectorDataSyncFragment.this.lastSyncStatusVerified = ((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus();
                    ElectorDataSyncFragment.this.binding.lastVerifiedDetailSyncStatus.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getLastSyncStatus());
                    ElectorDataSyncFragment.this.binding.verifiedSyncDate.setText(((HouseSurveyModel.Payload) arrayList2.get(arrayList2.size() - 1)).getModifiedOn());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$6();
                    }
                }, 2000L);
                ElectorDataSyncFragment.this.refreshTokenApi();
                return;
            }
            ElectorDataSyncFragment.this.houseSurveyPayLoad = new HouseSurveyModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", "", ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure + StringUtils.SPACE + response.code());
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(ElectorDataSyncFragment.this.houseSurveyPayLoad);
            ElectorDataSyncFragment.this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList3 = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (arrayList3.isEmpty()) {
                ElectorDataSyncFragment.this.modifiedOnVerified = "";
            } else {
                ElectorDataSyncFragment.this.modifiedOnVerified = ((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn().split(StringUtils.SPACE)[0];
                ElectorDataSyncFragment.this.lastSyncStatusVerified = ((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.lastVerifiedDetailSyncStatus.setText(((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.verifiedSyncDate.setText(((HouseSurveyModel.Payload) arrayList3.get(arrayList3.size() - 1)).getModifiedOn());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$7();
                }
            }, 2000L);
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(ElectorDataSyncFragment.TAG, "getVerifiedEpicHouse errorResponse --> " + strOptString);
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(ElectorDataSyncFragment.TAG, "eroPasswordFlow exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(final Response response) {
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (!arrayList.isEmpty()) {
                ElectorDataSyncFragment.this.count = 0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ElectorDataSyncFragment.this.count = size;
                    ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().deleteHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
                }
            }
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += 50;
                ElectorDataSyncFragment.this.updateProgressBar();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1(response);
                }
            }, 2000L);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 3000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Response response) {
            for (int i = 0; i < ((HouseSurveyModel.Root) response.body()).getPayload().size(); i++) {
                ((HouseSurveyModel.Root) response.body()).getPayload().get(i).setBloId(ElectorDataSyncFragment.this.bloId);
                ((HouseSurveyModel.Root) response.body()).getPayload().get(i).setModifiedOn(ElectorDataSyncFragment.this.formattedDate);
                ((HouseSurveyModel.Root) response.body()).getPayload().get(i).setPartNo(ElectorDataSyncFragment.this.partNumber);
                ((HouseSurveyModel.Root) response.body()).getPayload().get(i).setLastSyncStatus(ElectorDataSyncFragment.this.success);
                ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(((HouseSurveyModel.Root) response.body()).getPayload().get(i));
                ElectorDataSyncFragment.this.count++;
                Logger.d("TAG", "electorDetailsDatabaseHelperAdded ---> " + i);
            }
            ElectorDataSyncFragment.this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
            SharedPref.getInstance(ElectorDataSyncFragment.this.requireContext()).setLastVerifiedHouseSyncDate(ElectorDataSyncFragment.this.formattedDate);
            if (ElectorDataSyncFragment.this.progr <= 100) {
                ElectorDataSyncFragment.this.progr += 50;
                ElectorDataSyncFragment.this.updateProgressBar();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            Toast.makeText((Context) ElectorDataSyncFragment.this.getActivity(), (CharSequence) "Total  Verified Elector Data Updated Successfully", 1).show();
            ElectorDataSyncFragment.this.binding.totalElectorsTextViewLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalHouseVerifiedLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.h2hSurveyStatusLayout.setVisibility(0);
            ElectorDataSyncFragment.this.binding.totalHouseVerified.setText(String.valueOf(((ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getAllHouseSurveyDetails(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId)).size()));
            ArrayList arrayList = (ArrayList) ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().getLastModifiedDate(ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId);
            if (!arrayList.isEmpty()) {
                String[] strArrSplit = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn().split(StringUtils.SPACE);
                ElectorDataSyncFragment.this.modifiedOnVerified = strArrSplit[0];
                ElectorDataSyncFragment.this.lastSyncStatusVerified = ((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus();
                ElectorDataSyncFragment.this.binding.lastVerifiedDetailSyncStatus.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getLastSyncStatus());
                ElectorDataSyncFragment.this.binding.verifiedSyncDate.setText(((HouseSurveyModel.Payload) arrayList.get(arrayList.size() - 1)).getModifiedOn());
            } else {
                ElectorDataSyncFragment.this.modifiedOnVerified = "";
            }
            ElectorDataSyncFragment.this.binding.totalData.setVisibility(8);
            ElectorDataSyncFragment.this.binding.progressBar.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$6() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<HouseSurveyModel.Root> call, Throwable t) {
            ElectorDataSyncFragment.this.houseSurveyPayLoad = new HouseSurveyModel.Payload(ElectorDataSyncFragment.this.timeStamp, "", "", ElectorDataSyncFragment.this.partNumber, ElectorDataSyncFragment.this.bloId, ElectorDataSyncFragment.this.formattedDate, ElectorDataSyncFragment.this.failure);
            ElectorDataSyncFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(ElectorDataSyncFragment.this.houseSurveyPayLoad);
            ElectorDataSyncFragment.this.commomUtility.showMessageWithTitleOK(ElectorDataSyncFragment.this.requireContext(), "GetVerifiedEpicHouse onFailure Error ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$4$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$11();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$11() {
            ElectorDataSyncFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTokenApi() {
        this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda3
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$11(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$11(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println(this.refreshTokenApiCalled + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$8(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$10(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$10(DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        ((FragmentActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager().beginTransaction().replace(getId(), new ElectorDataSyncFragment()).commit();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$refreshTokenApi$9();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$9() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        new android.app.AlertDialog.Builder(getContext()).setTitle("Alert").setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$12(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }
}
