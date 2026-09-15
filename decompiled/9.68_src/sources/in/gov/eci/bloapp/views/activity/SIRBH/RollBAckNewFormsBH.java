package in.gov.eci.bloapp.views.activity.SIRBH;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.RollbackNewFormAdapterBH;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityRollBackNewFormsBhBinding;
import in.gov.eci.bloapp.model.SIR.RollbackNewModel;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollBAckNewFormsBH extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    RollbackNewFormAdapterBH adapter;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityRollBackNewFormsBhBinding binding;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<RollbackNewModel> rollBackNewList = new ArrayList<>();
    ArrayList<RollbackNewModel> rollBackSearchList = new ArrayList<>();
    private final String TAG = "RollBackNewFormsTAG";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRollBackNewFormsBhBinding activityRollBackNewFormsBhBindingInflate = ActivityRollBackNewFormsBhBinding.inflate(getLayoutInflater());
        this.binding = activityRollBackNewFormsBhBindingInflate;
        setContentView(activityRollBackNewFormsBhBindingInflate.getRoot());
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
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
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.SESSION = getString(R.string.sessionMsg);
        this.adapter = new RollbackNewFormAdapterBH(this.rollBackSearchList, this);
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllRollBackNew();
        this.rollBackSearchList.clear();
        this.rollBackSearchList.addAll(this.rollBackNewList);
        this.adapter.notifyDataSetChanged();
        initClickListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void cameraPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") == 0) {
            initScanner();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, REQUEST_CODE_CAMERA_PORTRAIT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initScanner() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        intentIntegrator.initiateScan();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (activityResult != null) {
            if (activityResult.getContents() == null) {
                Toast.makeText((Context) this, (CharSequence) "Scanning cancelled!", 1).show();
                return;
            }
            String contents = activityResult.getContents();
            try {
                this.barcode = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
            } catch (Exception unused) {
                this.barcode = contents;
            }
            this.barcode = this.barcode.replace(StringUtils.SPACE, "");
            this.binding.search.setText(this.barcode);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        }
    }

    private void getAllRollBackNew() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("stCode", this.state);
        Call<JsonObject> uncollectedEfList = this.service.getUncollectedEfList(map, map2);
        this.alertDialog.show();
        uncollectedEfList.enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (response.isSuccessful() && response.body() != null) {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("epicNo", null);
                        RollBAckNewFormsBH.this.rollBackNewList.add(new RollbackNewModel(jSONObject.optString("electorName", null), strOptString, 0L, jSONObject.optString("partSerialNo", null), jSONObject.optString("backToBloRemarks", null), jSONObject.optString("efFrontUrl", ""), jSONObject.optString("efBackUrl", ""), jSONObject.optString("suppDoc1Url", ""), jSONObject.optString("suppDoc2Url", ""), jSONObject.optString("uncollectableReason", ""), jSONObject.optString("enrolledEpicNo", "")));
                    }
                    RollBAckNewFormsBH.this.rollBackSearchList.addAll(RollBAckNewFormsBH.this.rollBackNewList);
                    RollBAckNewFormsBH.this.binding.recyclerView.setAdapter(RollBAckNewFormsBH.this.adapter);
                    RollBAckNewFormsBH.this.alertDialog.dismiss();
                    RollBAckNewFormsBH.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH.1.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<RollbackNewModel> arrayList = new ArrayList<>();
                            for (RollbackNewModel rollbackNewModel : RollBAckNewFormsBH.this.rollBackSearchList) {
                                if (rollbackNewModel.getEpicNo().toLowerCase().contains(string.toLowerCase())) {
                                    arrayList.add(rollbackNewModel);
                                }
                            }
                            RollBAckNewFormsBH.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                }
                if (response.code() == 400 || response.code() == 401) {
                    if (RollBAckNewFormsBH.this.alertDialog != null) {
                        RollBAckNewFormsBH.this.alertDialog.dismiss();
                    }
                    CommomUtility commomUtility = RollBAckNewFormsBH.this.commomUtility;
                    ?? r2 = RollBAckNewFormsBH.this;
                    commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                try {
                    if (RollBAckNewFormsBH.this.alertDialog != null) {
                        RollBAckNewFormsBH.this.alertDialog.dismiss();
                    }
                    String strOptString2 = new JSONObject(response.errorBody().string()).optString("message");
                    RollBAckNewFormsBH rollBAckNewFormsBH = RollBAckNewFormsBH.this;
                    rollBAckNewFormsBH.showDialog1(rollBAckNewFormsBH.getString(R.string.alertMsg), strOptString2);
                    Logger.e("RollBackNewFormsTAG", strOptString2);
                } catch (IOException | JSONException e) {
                    if (RollBAckNewFormsBH.this.alertDialog != null) {
                        RollBAckNewFormsBH.this.alertDialog.dismiss();
                    }
                    Logger.e("RollBackNewFormsTAG", e.getMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollBAckNewFormsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollBAckNewFormsBH.this.getApplicationContext()).setLocaleBool(false);
            RollBAckNewFormsBH.this.startActivity(new Intent(RollBAckNewFormsBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (RollBAckNewFormsBH.this.alertDialog != null) {
                RollBAckNewFormsBH.this.alertDialog.dismiss();
            }
            Logger.e("RollBackNewFormsTAG", t.getMessage());
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RollBAckNewFormsBH.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        onBackPressed();
    }

    private void rollBackSearchList(String query) {
        this.rollBackSearchList.clear();
        for (RollbackNewModel rollbackNewModel : this.rollBackNewList) {
            try {
                if (rollbackNewModel.getEpicNo().toLowerCase().contains(query.toLowerCase())) {
                    this.rollBackSearchList.add(rollbackNewModel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Logger.d("search", "queryResult count" + this.rollBackSearchList.size());
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        startActivity(new Intent((Context) this, (Class<?>) FormTypesBH.class));
    }
}
