package in.gov.eci.bloapp.views.activity.SIRBH;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityUncollectableSirBhBinding;
import in.gov.eci.bloapp.model.SIR.unCollectableModel;
import in.gov.eci.bloapp.model.UnCollectableModelBH;
import in.gov.eci.bloapp.model.UnCollectableStatusBH;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UncollectableSIRBH extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String alreadyEpic;
    String asmblyNO;
    private String atkband;
    ActivityUncollectableSirBhBinding binding;
    UnCollectableModelBH bodyModel;
    byte[] byteArray;
    String currentDate;
    private String epic;
    protected long filesize;
    String flag;
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
    String temp;
    private String token;
    private String unCollectReason;
    String img = "image";
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    ArrayList<unCollectableModel> bodyList = new ArrayList<>();
    ArrayList<UnCollectableStatusBH> status = new ArrayList<>();
    String validEpicFlag = "N";
    CommomUtility commomUtility = new CommomUtility();
    private final String TAG = "UncollectableTAG";
    String SESSION = "";
    String cancel = "";
    String takephoto = "";
    String imgmsg = "";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
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
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUncollectableSirBhBinding activityUncollectableSirBhBindingInflate = ActivityUncollectableSirBhBinding.inflate(getLayoutInflater());
        this.binding = activityUncollectableSirBhBindingInflate;
        setContentView(activityUncollectableSirBhBindingInflate.getRoot());
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
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
        initClickListener();
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.SESSION = getString(R.string.sessionMsg);
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableTAG", str);
        this.epic = TextUtils.isEmpty(getIntent().getStringExtra("epic")) ? "" : getIntent().getStringExtra("epic");
        this.partSerialNo = TextUtils.isEmpty(getIntent().getStringExtra("psl")) ? 0 : Integer.parseInt(getIntent().getStringExtra("psl"));
        String stringExtra = TextUtils.isEmpty(getIntent().getStringExtra("flag")) ? "" : getIntent().getStringExtra("flag");
        this.flag = stringExtra;
        if (stringExtra.equalsIgnoreCase("UN")) {
            String stringExtra2 = TextUtils.isEmpty(getIntent().getStringExtra("reason")) ? "" : getIntent().getStringExtra("reason");
            this.reason = stringExtra2;
            Logger.d("reasonUCEF", stringExtra2);
            this.unCollectReason = this.reason;
            this.binding.absentRb.setEnabled(false);
            this.binding.alreadyEnrolledRb.setEnabled(false);
            this.binding.deadRb.setEnabled(false);
            this.binding.permanentRb.setEnabled(false);
            this.binding.alreadyEpicLayout.setVisibility(8);
            String stringExtra3 = TextUtils.isEmpty(getIntent().getStringExtra("enrolledEpic")) ? "" : getIntent().getStringExtra("enrolledEpic");
            if (this.reason.equalsIgnoreCase("Untraceable/Absent")) {
                this.binding.absentRb.setChecked(true);
            } else if (this.reason.equalsIgnoreCase("Already enrolled")) {
                this.binding.alreadyEpicLayout.setVisibility(0);
                if (this.epic.equals(stringExtra3)) {
                    this.binding.enterEpicSirTv.setText("");
                } else {
                    this.binding.enterEpicSirTv.setText(stringExtra3);
                }
                this.binding.alreadyEnrolledRb.setChecked(true);
            } else if (this.reason.equalsIgnoreCase("Death")) {
                this.binding.deadRb.setChecked(true);
            } else if (this.reason.equalsIgnoreCase("Permanently Shifted")) {
                this.binding.permanentRb.setChecked(true);
            } else {
                this.binding.absentRb.setEnabled(true);
                this.binding.alreadyEnrolledRb.setEnabled(true);
                this.binding.deadRb.setEnabled(true);
                this.binding.permanentRb.setEnabled(true);
            }
        }
        this.binding.uncollectableRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) UncollectableSIRBH.this.findViewById(radioGroup.getCheckedRadioButtonId());
                UncollectableSIRBH.this.unCollectReason = radioButton.getText().toString();
                if (UncollectableSIRBH.this.unCollectReason.equalsIgnoreCase(UncollectableSIRBH.this.getString(R.string.already_enrolled_sir))) {
                    UncollectableSIRBH.this.binding.alreadyEpicLayout.setVisibility(0);
                } else {
                    UncollectableSIRBH.this.binding.alreadyEpicLayout.setVisibility(8);
                }
            }
        });
        this.binding.submitSIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRBH.this.pickPhoto(101, "enFormPage1");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRBH.this.pickPhoto(102, "enFormPage2");
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRBH.this.pickPhoto(103, "sDPage1");
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRBH.this.pickPhoto(104, "sDPage2");
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        deletePhoto(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        deletePhoto(104);
    }

    private void validate() {
        String string = this.binding.enterEpicSirTv.getText().toString();
        this.alreadyEpic = string;
        if (!TextUtils.isEmpty(string)) {
            checkEpicNumber(this.alreadyEpic);
        } else {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit() {
        if (this.binding.uncollectableRG.getCheckedRadioButtonId() == -1) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.selectOneMsg));
            return;
        }
        if (this.binding.alreadyEnrolledRb.isChecked() && TextUtils.isEmpty(this.alreadyEpic) && !this.alreadyEpic.equals(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.enterEpicMsg));
            return;
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) || TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.uploadEnumerationFormMsg1));
            return;
        }
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
        this.status.add(new UnCollectableStatusBH(this.partSerialNo, this.epic, "U", "Y", "Y", "N", "Y", "", "", this.currentDate, this.unCollectReason, "", this.alreadyEpic, this.relativeDocument1UrlS, this.relativeDocument2UrlS, this.relativeSupportingDocumentPage1UrlS, this.relativeSupportingDocumentPage2UrlS));
        UnCollectableModelBH unCollectableModelBH = new UnCollectableModelBH(this.state, this.acNo, this.partNo, this.status);
        this.bodyModel = unCollectableModelBH;
        this.service.saveEnumerationStatus(map, unCollectableModelBH).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        AnonymousClass6() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH] */
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
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIRBH.this.commomUtility;
                ?? r5 = UncollectableSIRBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRBH.this.startActivity(new Intent(UncollectableSIRBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UncollectableSIRBH.this.alertDialog != null) {
                UncollectableSIRBH.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableTAG", t.getMessage());
        }
    }

    private void checkEpicNumber(String epic) {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("epicNumber", epic);
        map.put("isActive", "Y");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getEpicForForm8(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonArray> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH] */
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
        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200 && response.body() != null) {
                if (!((JsonArray) response.body()).isEmpty()) {
                    Toast.makeText((Context) UncollectableSIRBH.this, (CharSequence) "Valid EPIC", 0).show();
                    UncollectableSIRBH.this.validEpicFlag = "Y";
                    UncollectableSIRBH.this.submit();
                    UncollectableSIRBH.this.alertDialog.dismiss();
                    return;
                }
                UncollectableSIRBH uncollectableSIRBH = UncollectableSIRBH.this;
                uncollectableSIRBH.showDialog1(uncollectableSIRBH.getString(R.string.alertMsg), UncollectableSIRBH.this.getString(R.string.please_check_epic_number));
                UncollectableSIRBH.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIRBH.this.commomUtility;
                ?? r4 = UncollectableSIRBH.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRBH.this.startActivity(new Intent(UncollectableSIRBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            if (UncollectableSIRBH.this.alertDialog != null) {
                UncollectableSIRBH.this.alertDialog.dismiss();
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$5(DialogInterface dialogInterface, int i) {
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$6(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        if (this.flag.equalsIgnoreCase("PL")) {
            startActivity(new Intent((Context) this, (Class<?>) pendingElectorsBH.class));
            return;
        }
        if (this.flag.equalsIgnoreCase("RE")) {
            startActivity(new Intent((Context) this, (Class<?>) RollbackFormsListBH.class));
        } else if (this.flag.equalsIgnoreCase("RN")) {
            startActivity(new Intent((Context) this, (Class<?>) RollBAckNewFormsBH.class));
        } else if (this.flag.equalsIgnoreCase("UN")) {
            startActivity(new Intent((Context) this, (Class<?>) UncollectedEFBH.class));
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$7(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (requestCode == 0) {
                Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(data), 0).show();
                return;
            } else {
                Toast.makeText((Context) this, (CharSequence) "Uploading cancelled", 0).show();
                this.alertDialog.dismiss();
                return;
            }
        }
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
            this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        try {
            Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
            Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            String[] strArrSplit = saveImagePath.getPath().split("/");
            if (requestCode == 101) {
                long j = this.filesize;
                if (j < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                    this.binding.enumerationFormPage1.setVisibility(0);
                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                    this.binding.enumerationFormPage1Image.setVisibility(0);
                    ImageView imageView = this.binding.enumerationFormPage1Image;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                    this.binding.enumerationFormPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j > 2048) {
                    this.binding.enumerationFormPage1.setVisibility(8);
                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                    this.binding.enumerationFormPage1Image.setVisibility(8);
                    this.binding.uploadEnumerationFormPage1.setEnabled(true);
                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j2 = j / 1024;
                    this.filesize = j2;
                    double dRound = Math.round(j2 * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.binding.enumerationFormPage1.setVisibility(8);
                        this.binding.uploadEnumerationFormPage1.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                        this.binding.enumerationFormPage1.setVisibility(0);
                        this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                        this.binding.enumerationFormPage1ImageName.setVisibility(0);
                        this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                        this.binding.enumerationFormPage1Image.setVisibility(0);
                        ImageView imageView2 = this.binding.enumerationFormPage1Image;
                        byte[] bArr2 = this.pdfbyteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                        this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.uploadEnumerationFormPage1.setEnabled(false);
                        this.binding.enumerationFormPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.enumerationFormPage1ImageSize.setText(dRound + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 102) {
                long j3 = this.filesize;
                if (j3 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                    this.binding.enumerationFormPage2.setVisibility(0);
                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                    this.binding.enumerationFormPage2Image.setVisibility(0);
                    ImageView imageView3 = this.binding.enumerationFormPage2Image;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                    this.binding.enumerationFormPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j3 > 2048) {
                    this.binding.enumerationFormPage2.setVisibility(8);
                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                    this.binding.enumerationFormPage2Image.setVisibility(8);
                    this.binding.uploadEnumerationFormPage2.setEnabled(true);
                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j4 = j3 / 1024;
                    this.filesize = j4;
                    double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                    if (dRound2 > 2.0d) {
                        this.binding.enumerationFormPage2Image.setVisibility(8);
                        this.binding.uploadEnumerationFormPage2.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                        this.binding.enumerationFormPage2Image.setVisibility(0);
                        this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                        this.binding.enumerationFormPage2ImageName.setVisibility(0);
                        this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                        this.binding.enumerationFormPage2Image.setVisibility(0);
                        ImageView imageView4 = this.binding.enumerationFormPage2Image;
                        byte[] bArr4 = this.pdfbyteArray;
                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                        this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.uploadEnumerationFormPage2.setEnabled(false);
                        this.binding.enumerationFormPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.enumerationFormPage2ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 103) {
                long j5 = this.filesize;
                if (j5 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                    this.binding.supportingDocumentsPage1.setVisibility(0);
                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                    ImageView imageView5 = this.binding.supportingDocumentsPage1Image;
                    byte[] bArr5 = this.pdfbyteArray;
                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                    this.binding.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j5 > 2048) {
                    this.binding.supportingDocumentsPage1.setVisibility(8);
                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                    this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j6 = j5 / 1024;
                    this.filesize = j6;
                    double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                    if (dRound3 > 2.0d) {
                        this.binding.supportingDocumentsPage1.setVisibility(8);
                        this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                        this.binding.supportingDocumentsPage1.setVisibility(0);
                        this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                        this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                        this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                        this.binding.supportingDocumentsPage1Image.setVisibility(0);
                        ImageView imageView6 = this.binding.supportingDocumentsPage1Image;
                        byte[] bArr6 = this.pdfbyteArray;
                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                        this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                        this.binding.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 104) {
                long j7 = this.filesize;
                if (j7 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                    this.binding.supportingDocumentsPage2.setVisibility(0);
                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                    ImageView imageView7 = this.binding.supportingDocumentsPage2Image;
                    byte[] bArr7 = this.pdfbyteArray;
                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                    this.binding.supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j7 > 2048) {
                    this.binding.supportingDocumentsPage2.setVisibility(8);
                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                    this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                    this.binding.supportingDocumentsPage2Image.setVisibility(8);
                    this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j8 = j7 / 1024;
                    this.filesize = j8;
                    double dRound4 = Math.round(j8 * 100.0d) / 100.0d;
                    if (dRound4 > 2.0d) {
                        this.binding.supportingDocumentsPage1.setVisibility(8);
                        this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                        this.binding.supportingDocumentsPage2.setVisibility(0);
                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                        this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                        this.binding.supportingDocumentsPage2Image.setVisibility(0);
                        ImageView imageView8 = this.binding.supportingDocumentsPage2Image;
                        byte[] bArr8 = this.pdfbyteArray;
                        imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                        this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                        this.binding.supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.supportingDocumentsPage2ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                    }
                }
            }
            cursorQuery.close();
        } catch (Exception e2) {
            Logger.d("", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, final String listCode) {
        final String strReplaceAll = this.epic.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$8(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$8(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), captureFileName);
        restClient.uploadImageWithSIR(this.token, "blo", "BLOAPP", partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass8(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass8(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v22, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH] */
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
            if (response.code() == 401) {
                CommomUtility commomUtility = UncollectableSIRBH.this.commomUtility;
                ?? r13 = UncollectableSIRBH.this;
                String str = ((UncollectableSIRBH) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$8$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo1strNew)) {
                    UncollectableSIRBH.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo2strNew)) {
                    UncollectableSIRBH.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo3strNew)) {
                    UncollectableSIRBH.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo4strNew)) {
                    UncollectableSIRBH.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRBH.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo1strNew)) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.photo1countNew = 0;
                UncollectableSIRBH.this.binding.enumerationFormPage1.setVisibility(8);
                UncollectableSIRBH uncollectableSIRBH = UncollectableSIRBH.this;
                uncollectableSIRBH.showDialog1(uncollectableSIRBH.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo2strNew)) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.photo2countNew = 0;
                UncollectableSIRBH.this.binding.enumerationFormPage2.setVisibility(8);
                UncollectableSIRBH uncollectableSIRBH2 = UncollectableSIRBH.this;
                uncollectableSIRBH2.showDialog1(uncollectableSIRBH2.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo3strNew)) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.photo3countNew = 0;
                UncollectableSIRBH.this.binding.supportingDocumentsPage1.setVisibility(8);
                UncollectableSIRBH uncollectableSIRBH3 = UncollectableSIRBH.this;
                uncollectableSIRBH3.showDialog1(uncollectableSIRBH3.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                UncollectableSIRBH.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                UncollectableSIRBH.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo4strNew)) {
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.photo4countNew = 0;
                UncollectableSIRBH.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIRBH uncollectableSIRBH4 = UncollectableSIRBH.this;
                uncollectableSIRBH4.showDialog1(uncollectableSIRBH4.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                UncollectableSIRBH.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                UncollectableSIRBH.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            UncollectableSIRBH.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRBH.this.commomUtility;
                ?? r2 = UncollectableSIRBH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UncollectableSIRBH.this.token = "Bearer " + str8;
            UncollectableSIRBH.this.refreshToken = str9;
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setToken("Bearer " + str8);
            UncollectableSIRBH uncollectableSIRBH = UncollectableSIRBH.this;
            uncollectableSIRBH.uploadPhoto(str, str2, str3, str4, str5, uncollectableSIRBH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRBH.this.startActivity(new Intent((Context) UncollectableSIRBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo1strNew)) {
                if (UncollectableSIRBH.this.photo1countNew < 2 && TextUtils.isEmpty(UncollectableSIRBH.this.relativeDocument1UrlS)) {
                    UncollectableSIRBH.this.photo1countNew++;
                    UncollectableSIRBH uncollectableSIRBH = UncollectableSIRBH.this;
                    uncollectableSIRBH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRBH.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRBH.this.alertDialog != null) {
                        UncollectableSIRBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRBH.this.photo1countNew = 0;
                    UncollectableSIRBH.this.binding.enumerationFormPage1.setVisibility(8);
                    UncollectableSIRBH uncollectableSIRBH2 = UncollectableSIRBH.this;
                    uncollectableSIRBH2.showDialog1(uncollectableSIRBH2.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo2strNew)) {
                if (UncollectableSIRBH.this.photo2countNew < 2 && TextUtils.isEmpty(UncollectableSIRBH.this.relativeDocument2UrlS)) {
                    UncollectableSIRBH.this.photo2countNew++;
                    UncollectableSIRBH uncollectableSIRBH3 = UncollectableSIRBH.this;
                    uncollectableSIRBH3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRBH3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRBH.this.alertDialog != null) {
                        UncollectableSIRBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRBH.this.photo2countNew = 0;
                    UncollectableSIRBH.this.binding.enumerationFormPage2.setVisibility(8);
                    UncollectableSIRBH uncollectableSIRBH4 = UncollectableSIRBH.this;
                    uncollectableSIRBH4.showDialog1(uncollectableSIRBH4.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo3strNew)) {
                if (UncollectableSIRBH.this.photo3countNew < 2 && TextUtils.isEmpty(UncollectableSIRBH.this.relativeSupportingDocumentPage1UrlS)) {
                    UncollectableSIRBH.this.photo3countNew++;
                    UncollectableSIRBH uncollectableSIRBH5 = UncollectableSIRBH.this;
                    uncollectableSIRBH5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRBH5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRBH.this.alertDialog != null) {
                        UncollectableSIRBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRBH.this.photo3countNew = 0;
                    UncollectableSIRBH.this.binding.supportingDocumentsPage1.setVisibility(8);
                    UncollectableSIRBH uncollectableSIRBH6 = UncollectableSIRBH.this;
                    uncollectableSIRBH6.showDialog1(uncollectableSIRBH6.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                    UncollectableSIRBH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRBH.this.photo4strNew)) {
                if (UncollectableSIRBH.this.photo4countNew < 2 && TextUtils.isEmpty(UncollectableSIRBH.this.relativeSupportingDocumentPage2UrlS)) {
                    UncollectableSIRBH.this.photo4countNew++;
                    UncollectableSIRBH uncollectableSIRBH7 = UncollectableSIRBH.this;
                    uncollectableSIRBH7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRBH7.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UncollectableSIRBH.this.alertDialog != null) {
                    UncollectableSIRBH.this.alertDialog.dismiss();
                }
                UncollectableSIRBH.this.photo4countNew = 0;
                UncollectableSIRBH.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIRBH uncollectableSIRBH8 = UncollectableSIRBH.this;
                uncollectableSIRBH8.showDialog1(uncollectableSIRBH8.alertText, UncollectableSIRBH.this.fileNotFoundMessage);
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRBH.this.whitecolor));
                UncollectableSIRBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d("UncollectableTAG", "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d("UncollectableTAG", str2);
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        }
        File file2 = new File(file, this.saveImageFileName);
        byte[] bArrDecode = Base64.decode(fileNameBase64, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("UncollectableTAG", "filesize " + this.filesize);
        Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    private void deletePhoto(int code) {
        if (code == 101) {
            this.relativeDocument1UrlS = null;
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
            this.binding.enumerationFormPage1Image.setVisibility(8);
            this.binding.enumerationFormPage1ImageSize.setText("");
            this.binding.enumerationFormPage1ImageName.setText("");
            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 102) {
            this.relativeDocument2UrlS = null;
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
            this.binding.enumerationFormPage2Image.setVisibility(8);
            this.binding.enumerationFormPage2ImageSize.setText("");
            this.binding.enumerationFormPage2ImageName.setText("");
            this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 103) {
            this.relativeSupportingDocumentPage1UrlS = null;
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.supportingDocumentsPage1Image.setVisibility(8);
            this.binding.supportingDocumentsPage1ImageName.setText("");
            this.binding.supportingDocumentsPage1ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 104) {
            this.relativeSupportingDocumentPage2UrlS = null;
            this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.supportingDocumentsPage2Image.setVisibility(8);
            this.binding.supportingDocumentsPage2ImageName.setText("");
            this.binding.supportingDocumentsPage2ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
        }
    }
}
