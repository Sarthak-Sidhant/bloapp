package in.gov.eci.bloapp.views.activity.sir;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.EfTrackerCountScreenFinalBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class efTrackerCountActivity extends SuperBaseActivity {
    private String acNo;
    ArrayAdapter<String> adapter;
    AlertDialog alertDialog;
    private String atkband;
    EfTrackerCountScreenFinalBinding binding;
    String filter;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    ArrayList<String> singleSelect;
    private String state;
    private String token;
    String SESSION = "";
    List<String> partNameList = new ArrayList();
    List<Integer> partList = new ArrayList();
    String totalPartNumber = "";
    CommomUtility commomUtility = new CommomUtility();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = EfTrackerCountScreenFinalBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.totalPartNumber = SharedPref.getInstance(getApplicationContext()).getTotalPartNumber();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.textView5.setText("v9.68");
        onClickListeners();
        this.binding.efPartSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                efTrackerCountActivity.this.binding.efPartSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                efTrackerCountActivity.this.binding.efPartSpinner.showDropDown();
            }
        });
        this.binding.efPartSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    efTrackerCountActivity.this.partNo = null;
                    efTrackerCountActivity.this.binding.efPartSpinner.setText("");
                    efTrackerCountActivity.this.binding.efPartSpinner.setHint("Select Part");
                } else {
                    String string = parent.getItemAtPosition(i).toString();
                    efTrackerCountActivity eftrackercountactivity = efTrackerCountActivity.this;
                    eftrackercountactivity.partNo = String.valueOf(eftrackercountactivity.partList.get(efTrackerCountActivity.this.partNameList.indexOf(string)));
                    efTrackerCountActivity.this.callAPI();
                }
            }
        });
        if (!TextUtils.isEmpty(SharedPref.getInstance(this).getUserRole()) && SharedPref.getInstance(getApplicationContext()).getUserRole().equalsIgnoreCase("blos")) {
            this.binding.singleSelectll.setVisibility(0);
            String str = this.totalPartNumber;
            if (str == null || str.isEmpty()) {
                this.commomUtility.showMessageWithTitleOK(this, " Error", "BLO Supervisor details are not available.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
                return;
            } else {
                singleSelect(this.totalPartNumber);
                return;
            }
        }
        this.binding.singleSelectll.setVisibility(8);
        callAPI();
    }

    private void onClickListeners() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onClickListeners$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClickListeners$1(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void singleSelect(String totalPartNumber) {
        this.binding.efPartSpinner.setText("");
        this.binding.efPartSpinner.setHint("Select Part");
        this.partList.clear();
        this.partNameList.clear();
        String supervisorData = SharedPref.getInstance(this).getSupervisorData();
        if (!supervisorData.isEmpty()) {
            prepareList(supervisorData);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown_new, (List) this.partNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.efPartSpinner.setAdapter(arrayAdapter);
        this.binding.efPartSpinner.setThreshold(0);
    }

    private void prepareList(String jsonString) {
        try {
            JSONArray jSONArray = new JSONArray(jsonString);
            this.partList.clear();
            this.partNameList.clear();
            this.partNameList.add("Select Part");
            this.partList.add(0);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int iOptInt = jSONObject.optInt("partNo", 0);
                String strOptString = jSONObject.optString("partName", "");
                this.partList.add(Integer.valueOf(iOptInt));
                this.partNameList.add(iOptInt + " - " + strOptString);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void callAPI() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        if ((TextUtils.isEmpty(SharedPref.getInstance(this).getUserRole()) || !SharedPref.getInstance(getApplicationContext()).getUserRole().equalsIgnoreCase("blo")) && !TextUtils.isEmpty(SharedPref.getInstance(this).getUserRole()) && SharedPref.getInstance(getApplicationContext()).getUserRole().equalsIgnoreCase("blos")) {
            map.put("currentRole", "blos");
        } else {
            map.put("currentRole", "blo");
        }
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        Call<JsonObject> efCount = this.service.getEfCount(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        efCount.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (efTrackerCountActivity.this.alertDialog != null) {
                        efTrackerCountActivity.this.alertDialog.dismiss();
                    }
                    String json = new Gson().toJson(((JsonObject) response.body()).get("payload"));
                    Log.d("jsonString", json);
                    try {
                        JSONObject jSONObject = new JSONObject(json);
                        int iOptInt = jSONObject.optInt("totalElectors", 0);
                        int iOptInt2 = jSONObject.optInt("unCollectable", 0);
                        int iOptInt3 = jSONObject.optInt("distributed", 0);
                        int iOptInt4 = jSONObject.optInt("notDistributed", 0);
                        int iOptInt5 = jSONObject.optInt("ditizedByBLO", 0);
                        jSONObject.optInt("rollBackToBLO", 0);
                        int iOptInt6 = jSONObject.optInt("filledByCitizenVerPen", 0);
                        int iOptInt7 = jSONObject.optInt("filledByCitizenVerDone", 0);
                        int iOptInt8 = jSONObject.optInt("deliveredDitizationPending", 0);
                        String strOptString = jSONObject.optString("lastUpdateTimeStr", null);
                        if (TextUtils.isEmpty(strOptString)) {
                            strOptString = "";
                        }
                        efTrackerCountActivity.this.binding.tvSirHeader.setText(String.valueOf(iOptInt));
                        efTrackerCountActivity.this.binding.tvUpdateTime.setText(strOptString);
                        efTrackerCountActivity.this.binding.tvEfDistBlo.setText(String.valueOf(iOptInt3));
                        efTrackerCountActivity.this.binding.tvEfNotDistBlo.setText(String.valueOf(iOptInt4));
                        efTrackerCountActivity.this.binding.tvEfUncollectable.setText(String.valueOf(iOptInt2));
                        efTrackerCountActivity.this.binding.tvEfDigitBlo.setText(String.valueOf(iOptInt5));
                        efTrackerCountActivity.this.binding.tvEfNotDigitBlo.setText(String.valueOf(iOptInt8));
                        efTrackerCountActivity.this.binding.tvEfCitizenBlo.setText(String.valueOf(iOptInt6));
                        efTrackerCountActivity.this.binding.tvEfBloVerified.setText(String.valueOf(iOptInt7));
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                try {
                    if (efTrackerCountActivity.this.alertDialog != null) {
                        efTrackerCountActivity.this.alertDialog.dismiss();
                    }
                    efTrackerCountActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (efTrackerCountActivity.this.alertDialog != null) {
                        efTrackerCountActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (efTrackerCountActivity.this.alertDialog != null) {
                    efTrackerCountActivity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
