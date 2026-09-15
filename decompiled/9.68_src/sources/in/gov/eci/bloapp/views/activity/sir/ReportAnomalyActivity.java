package in.gov.eci.bloapp.views.activity.sir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityReportAnomalyBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ReportAnomalyActivity extends AppCompatActivity {
    String SESSION = "";
    private int acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityReportAnomalyBinding binding;
    private String epic;
    private Long epicId;
    protected long filesize;
    private String flag;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    UserClient service;
    private String state;
    private String token;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityReportAnomalyBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.acNo = Integer.parseInt(SharedPref.getInstance(getApplicationContext()).getAssemblyNumber());
        this.partNo = Integer.parseInt(SharedPref.getInstance(getApplicationContext()).getPartNumber());
        this.partNoS = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.epicId = Long.valueOf(getIntent().getLongExtra("epicId", 0L));
        this.epic = TextUtils.isEmpty(getIntent().getStringExtra("epic")) ? "" : getIntent().getStringExtra("epic");
        this.partSerialNo = getIntent().getIntExtra("psl", 0);
        this.flag = TextUtils.isEmpty(getIntent().getStringExtra("flag")) ? "" : getIntent().getStringExtra("flag");
        getAnomalyRemark();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.submitAnomaly.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        submitBloRemark();
    }

    private void submitBloRemark() {
        this.alertDialog.show();
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("epicId", this.epicId);
        map2.put("epicNo", this.epic);
        map2.put("bloRemark", this.binding.reasontv.getText().toString());
        ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).updateAnomalyRemark(this.state.toLowerCase(), map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity.1
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                ReportAnomalyActivity.this.alertDialog.dismiss();
                if (response.isSuccessful() && response.code() == 200) {
                    ReportAnomalyActivity.this.alertDialog.dismiss();
                    try {
                        ReportAnomalyActivity.this.showDialog("", new JSONObject(String.valueOf((JsonObject) response.body())).getString("message"));
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException | JSONException e2) {
                    Logger.d("ReportAnomalyActivity", e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d("ReportAnomalyActivity", "onFailureText" + t.getMessage());
            }
        });
    }

    private void getAnomalyRemark() {
        this.alertDialog.show();
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).getAnomalyRemark(this.state.toLowerCase(), this.epicId, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    ReportAnomalyActivity.this.alertDialog.dismiss();
                    try {
                        String string = new JSONObject(String.valueOf((JsonObject) response.body())).getJSONObject("payload").getString("bloRemark");
                        if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null")) {
                            ReportAnomalyActivity.this.binding.reasontv.setText(string);
                        } else {
                            ReportAnomalyActivity.this.binding.reasontv.setText("");
                        }
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                ReportAnomalyActivity.this.alertDialog.dismiss();
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException | JSONException e2) {
                    Logger.d("ReportAnomalyActivity", e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d("ReportAnomalyActivity", "onFailureText" + t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog(String alertText, String message) {
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$2(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        finish();
        getAnomalyRemark();
    }
}
