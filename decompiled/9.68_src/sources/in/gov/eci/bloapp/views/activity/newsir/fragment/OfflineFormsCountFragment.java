package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentOfflineFormsCountBinding;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class OfflineFormsCountFragment extends AppCompatActivity {
    String acNo;
    AlertDialog alertDialog;
    final Retrofit.Builder builder1;
    Bundle bundle;
    final CommomUtility commomUtility;
    LayoutInflater inf;
    String messageError;
    BloFragmentOfflineFormsCountBinding offlineFormsCountBinding;
    final OkHttpClient okHttpClient;
    boolean payload;
    String refID;
    String refreshToken;
    final Retrofit retrofit;
    String stateCode;
    String token;
    Utils utils;

    public OfflineFormsCountFragment() {
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

    private static void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloFragmentOfflineFormsCountBinding bloFragmentOfflineFormsCountBindingInflate = BloFragmentOfflineFormsCountBinding.inflate(getLayoutInflater());
        this.offlineFormsCountBinding = bloFragmentOfflineFormsCountBindingInflate;
        setContentView(bloFragmentOfflineFormsCountBindingInflate.getRoot());
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        this.inf = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.utils = new Utils();
        new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment.1
            public void handleOnBackPressed() {
                OfflineFormsCountFragment.this.startActivity(new Intent((Context) OfflineFormsCountFragment.this, (Class<?>) VoterForms.class));
            }
        };
        this.offlineFormsCountBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.offlineFormsCountBinding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.offlineFormsCountBinding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        setCurrentDate();
        getFormCountDataFromServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (this.offlineFormsCountBinding.edtCount.getText().toString().trim().length() > 0) {
            submitData();
        } else {
            this.utils.infoDialog(this, "Alert", "Please enter form 6 count.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submitData() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        String stateCode = SharedPref.getInstance(this).getStateCode();
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", stateCode);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("stateCd", stateCode);
        map2.put("dateOfEntry", this.offlineFormsCountBinding.txtDate.getText().toString().trim());
        map2.put("form6", this.offlineFormsCountBinding.edtCount.getText().toString().trim());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).submitCollectedFormCount(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (OfflineFormsCountFragment.this.alertDialog != null) {
                        OfflineFormsCountFragment.this.alertDialog.dismiss();
                    }
                    if (response.isSuccessful()) {
                        if (response.code() == 200) {
                            String string = new JSONObject(((JsonObject) response.body()).toString()).getString("status");
                            if (string == null || string.trim().length() <= 0 || !string.trim().equalsIgnoreCase("Success")) {
                                return;
                            }
                            OfflineFormsCountFragment.this.offlineFormsCountBinding.edtCount.setText("");
                            OfflineFormsCountFragment.this.showDialog("Alert", "Form6 Count submitted successfully");
                            return;
                        }
                        Toast.makeText((Context) OfflineFormsCountFragment.this, (CharSequence) "Something went wrong", 0).show();
                        return;
                    }
                    if (OfflineFormsCountFragment.this.alertDialog != null) {
                        OfflineFormsCountFragment.this.alertDialog.dismiss();
                    }
                    new JSONObject(response.errorBody().string()).getString("status");
                    Toast.makeText((Context) OfflineFormsCountFragment.this, (CharSequence) "Server Error", 0).show();
                } catch (Exception unused) {
                    if (OfflineFormsCountFragment.this.alertDialog != null) {
                        OfflineFormsCountFragment.this.alertDialog.dismiss();
                    }
                    Toast.makeText((Context) OfflineFormsCountFragment.this, (CharSequence) "Server Error", 0).show();
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (OfflineFormsCountFragment.this.alertDialog != null) {
                    OfflineFormsCountFragment.this.alertDialog.dismiss();
                }
                Toast.makeText((Context) OfflineFormsCountFragment.this, (CharSequence) "Server Error", 0).show();
            }
        });
    }

    void setCurrentDate() {
        this.offlineFormsCountBinding.txtDate.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getFormCountDataFromServer() {
        String stateCode = SharedPref.getInstance(this).getStateCode();
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", stateCode);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("stateCd", stateCode);
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getCurrentDateStatusFormCollected(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment.3
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (OfflineFormsCountFragment.this.alertDialog != null) {
                        OfflineFormsCountFragment.this.alertDialog.dismiss();
                    }
                    if (response.code() == 200) {
                        OfflineFormsCountFragment.this.payload = new JSONObject(((JsonObject) response.body()).toString()).getBoolean("payload");
                    } else {
                        if (OfflineFormsCountFragment.this.alertDialog != null) {
                            OfflineFormsCountFragment.this.alertDialog.dismiss();
                        }
                        JSONObject jSONObject = new JSONObject(response.errorBody().string());
                        OfflineFormsCountFragment.this.payload = jSONObject.getBoolean("payload");
                        OfflineFormsCountFragment.this.messageError = jSONObject.getString("message");
                        Log.d("hiii", "" + OfflineFormsCountFragment.this.payload);
                    }
                } catch (Exception unused) {
                    if (OfflineFormsCountFragment.this.alertDialog != null) {
                        OfflineFormsCountFragment.this.alertDialog.dismiss();
                    }
                    Toast.makeText((Context) OfflineFormsCountFragment.this, (CharSequence) "Server Error", 0).show();
                } finally {
                    if (!OfflineFormsCountFragment.this.payload) {
                        OfflineFormsCountFragment.this.offlineFormsCountBinding.txtErrorMsg.setVisibility(0);
                        OfflineFormsCountFragment.this.offlineFormsCountBinding.txtErrorMsg.setText(OfflineFormsCountFragment.this.messageError);
                        OfflineFormsCountFragment.this.offlineFormsCountBinding.submit.setEnabled(false);
                        OfflineFormsCountFragment.this.offlineFormsCountBinding.submit.setBackgroundColor(OfflineFormsCountFragment.this.getResources().getColor(R.color.blo_disable_color));
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (OfflineFormsCountFragment.this.alertDialog != null) {
                    OfflineFormsCountFragment.this.alertDialog.dismiss();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog11(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Alert");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$3(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        finish();
        dialogInterface.dismiss();
    }
}
