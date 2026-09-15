package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.EdgeToEdge;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityUpdateMobileBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobilePayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UpdateMobileActivity extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityUpdateMobileBinding binding;
    String currentDate;
    private Long epicId;
    protected long filesize;
    String flag;
    String from;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private byte[] pdfbyteArray;
    String reason;
    String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    UserClient service;
    private String state;
    String stateCode;
    String temp;
    private String token;
    Utils utils;
    UpdateMobilePayload verifyPayload;
    String img = "image";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    CommomUtility commomUtility = new CommomUtility();
    private final String TAG = "UncollectableTAG";
    String SESSION = "";
    String cancel = "";
    String takephoto = "";
    String imgmsg = "";
    String fileNotFoundMessage = "Something went wrong.";
    String alertText = "";
    String functionNameForLogBaseActivity = "";
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String photo1strNew = "EnumerationFormPage1";
    String photo2strNew = "EnumerationFormPage2";
    String photo3strNew = "SupportingDocumentPage1";
    String photo4strNew = "SupportingDocumentPage2";
    String relativeDocument1UrlS = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    String reasonTrans = "";
    String choosepdf = "Choose PDF from Gallery";
    String addPdf = "Add PDF!";
    String applicationpdf = "application/pdf";
    String chooseFile = "Choose File";
    String alert = "Alert";
    String pdf3 = "PDF size exceeded 10MB limit.";
    String logTagBaseActivity = "UpdateBloBlaMomActivity";
    File file1 = null;
    int photocount = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityUpdateMobileBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (UpdateMobilePayload) intent.getParcelableExtra("data");
        }
        this.epicId = this.verifyPayload.getEpicId();
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
        this.stateCode = SharedPref.getInstance(getApplicationContext()).getStateCode();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        initClickListener();
        this.utils = new Utils();
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableTAG", str);
        this.binding.electorNamePendingSir.setText(TextUtils.isEmpty(this.verifyPayload.getEpicName()) ? "" : this.verifyPayload.getEpicName());
        this.binding.epicPendingSir.setText(TextUtils.isEmpty(this.verifyPayload.getEpicNo()) ? "" : this.verifyPayload.getEpicNo());
        this.binding.serialNoPendingSir.setText(this.verifyPayload.getPartSerialNo() != 0 ? String.valueOf(this.verifyPayload.getPartSerialNo()) : "");
        this.binding.llAge.setVisibility(8);
        if (!TextUtils.isEmpty(this.verifyPayload.getMobileNo())) {
            this.binding.tvMobilenumbervalue.setText("Phone No - " + this.verifyPayload.getMobileNo());
            this.binding.rbMobilenumber.setText(this.verifyPayload.getMobileNo());
            this.binding.cdMobilenumber.setVisibility(0);
            this.binding.btnOk.setVisibility(8);
        } else {
            this.binding.cdMobilenumber.setVisibility(8);
            this.binding.btnOk.setVisibility(8);
        }
        this.binding.textView3.setText(getResources().getString(R.string.update_mobile));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.btnOk.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateMobileActivity.this.validate();
            }
        });
        this.binding.rbUpdateMobilenumber.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateMobileActivity.this.binding.etmobilenumber.setVisibility(0);
                UpdateMobileActivity.this.binding.btnOk.setVisibility(0);
                UpdateMobileActivity.this.binding.rbMobilenumber.setChecked(false);
            }
        });
        this.binding.rbMobilenumber.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateMobileActivity.this.binding.etmobilenumber.setVisibility(8);
                UpdateMobileActivity.this.binding.rbUpdateMobilenumber.setChecked(false);
                UpdateMobileActivity.this.binding.btnOk.setVisibility(0);
                UpdateMobileActivity.this.binding.etmobilenumber.setText("");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validate() {
        if (this.binding.rbUpdateMobilenumber.isChecked()) {
            if (TextUtils.isEmpty(this.binding.etmobilenumber.getText().toString())) {
                showDialog1(this.alertText, "Please enter updated mobile number");
                return;
            } else if (this.binding.etmobilenumber.getText().toString().length() < 10) {
                showDialog1(this.alertText, "Mobile number should be in 10 digits");
                return;
            } else {
                submit();
                return;
            }
        }
        submit();
    }

    private void submit() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("appname", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("state", this.state);
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        map2.put("epicId", this.verifyPayload.getEpicId());
        if (this.binding.rbUpdateMobilenumber.isChecked()) {
            map2.put("phone", this.binding.etmobilenumber.getText().toString());
        } else {
            map2.put("phone", this.verifyPayload.getMobileNo());
        }
        this.service.updateMobileByEpicID(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        AnonymousClass4() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity] */
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
            if (response.isSuccessful() && response.body() != null) {
                if (UpdateMobileActivity.this.alertDialog != null) {
                    UpdateMobileActivity.this.alertDialog.dismiss();
                }
                UpdateMobileActivity.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 401) {
                if (UpdateMobileActivity.this.alertDialog != null) {
                    UpdateMobileActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UpdateMobileActivity.this.commomUtility;
                ?? r5 = UpdateMobileActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (UpdateMobileActivity.this.alertDialog != null) {
                    UpdateMobileActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                UpdateMobileActivity updateMobileActivity = UpdateMobileActivity.this;
                updateMobileActivity.showDialog1(updateMobileActivity.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (UpdateMobileActivity.this.alertDialog != null) {
                    UpdateMobileActivity.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UpdateMobileActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UpdateMobileActivity.this.getApplicationContext()).setLocaleBool(false);
            UpdateMobileActivity.this.startActivity(new Intent(UpdateMobileActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UpdateMobileActivity.this.alertDialog != null) {
                UpdateMobileActivity.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableTAG", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$0(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$1(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) UpdateMobileListActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$2(View view) {
        finish();
    }
}
