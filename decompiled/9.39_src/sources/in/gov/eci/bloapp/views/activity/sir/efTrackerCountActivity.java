package in.gov.eci.bloapp.views.activity.sir;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.EfTrackerCountScreenFinalBinding;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class efTrackerCountActivity extends SuperBaseActivity {
    String SESSION = "";
    private String acNo;
    AlertDialog alertDialog;
    private String atkband;
    EfTrackerCountScreenFinalBinding binding;
    String filter;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;

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
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.textView5.setText("v9.39");
        onClickListeners();
        callAPI();
    }

    private void onClickListeners() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onClickListeners$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClickListeners$0(View view) {
        finish();
    }

    private void callAPI() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
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
        efCount.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity.1
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
                        efTrackerCountActivity.this.binding.tvUpdateTime.setText(DateStringConverter.toDdMmYy(strOptString));
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
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
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
