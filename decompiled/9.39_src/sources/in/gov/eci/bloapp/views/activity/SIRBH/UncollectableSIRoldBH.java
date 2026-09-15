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
import in.gov.eci.bloapp.databinding.ActivityUncollectableSirOldBhBinding;
import in.gov.eci.bloapp.model.SIR.unCollectableModel;
import in.gov.eci.bloapp.model.UnCollectableModelBH;
import in.gov.eci.bloapp.model.UnCollectableStatusBH;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UncollectableSIRoldBH extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String alreadyEpic;
    String asmblyNO;
    private String atkband;
    ActivityUncollectableSirOldBhBinding binding;
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
    String comingTag = "coming in onFailure";
    String messageString = "message";
    ArrayList<unCollectableModel> bodyList = new ArrayList<>();
    ArrayList<UnCollectableStatusBH> status = new ArrayList<>();
    String objectStorageString = "objectstorage";
    String validEpicFlag = "N";
    CommomUtility commomUtility = new CommomUtility();
    private final String TAG = "UncollectableSIRoldTAG";
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
    String photo1str = "EnumerationFormPage1";
    String photo2str = "EnumerationFormPage2";
    String photo3str = "SupportingDocumentPage1";
    String photo4str = "SupportingDocumentPage2";
    String enumrationFormPage1UrlS = "";
    String enumrationFormPage2UrlS = "";
    String supportingDocumentPage1UrlS = "";
    String supportingDocumentPage2UrlS = "";
    int photo1count = 0;
    int photo2count = 0;
    int photo3count = 0;
    int photo4count = 0;
    String base64element1 = "";
    String base64element2 = "";
    String base64element3 = "";
    String base64element4 = "";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUncollectableSirOldBhBinding activityUncollectableSirOldBhBindingInflate = ActivityUncollectableSirOldBhBinding.inflate(getLayoutInflater());
        this.binding = activityUncollectableSirOldBhBindingInflate;
        setContentView(activityUncollectableSirOldBhBindingInflate.getRoot());
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
        this.SESSION = getString(R.string.sessionMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        initClickListener();
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableSIRoldTAG", str);
        this.enumrationFormPage1UrlS = getIntent().getStringExtra("photoUrl1");
        this.enumrationFormPage2UrlS = getIntent().getStringExtra("photoUrl2");
        this.supportingDocumentPage1UrlS = getIntent().getStringExtra("photoUrl3");
        this.supportingDocumentPage2UrlS = getIntent().getStringExtra("photoUrl4");
        this.epic = TextUtils.isEmpty(getIntent().getStringExtra("epic")) ? null : getIntent().getStringExtra("epic");
        this.partSerialNo = TextUtils.isEmpty(getIntent().getStringExtra("psl")) ? 0 : Integer.parseInt(getIntent().getStringExtra("psl"));
        this.flag = TextUtils.isEmpty(getIntent().getStringExtra("flag")) ? null : getIntent().getStringExtra("flag");
        String stringExtra = TextUtils.isEmpty(getIntent().getStringExtra("enrolledEpicNo")) ? "" : getIntent().getStringExtra("enrolledEpicNo");
        if (this.flag.equalsIgnoreCase("RN") || this.flag.equalsIgnoreCase("ERO")) {
            String stringExtra2 = TextUtils.isEmpty(getIntent().getStringExtra("reason")) ? "" : getIntent().getStringExtra("reason");
            this.reason = stringExtra2;
            Logger.d("UncollectableSIRoldTAG", stringExtra2);
            String str2 = this.reason;
            this.unCollectReason = str2;
            if (str2.equalsIgnoreCase("Untraceable/Absent")) {
                this.binding.absentRb.setChecked(true);
            } else if (this.reason.equalsIgnoreCase("Already enrolled")) {
                this.binding.alreadyEpicLayout.setVisibility(0);
                if (this.epic.equals(stringExtra)) {
                    this.binding.enterEpicSirTv.setText("");
                } else {
                    this.binding.enterEpicSirTv.setText(stringExtra);
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
        this.binding.uncollectableRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) UncollectableSIRoldBH.this.findViewById(radioGroup.getCheckedRadioButtonId());
                UncollectableSIRoldBH.this.unCollectReason = radioButton.getText().toString();
                if (UncollectableSIRoldBH.this.unCollectReason.equalsIgnoreCase(UncollectableSIRoldBH.this.getString(R.string.already_enrolled_sir))) {
                    UncollectableSIRoldBH.this.binding.alreadyEpicLayout.setVisibility(0);
                } else {
                    UncollectableSIRoldBH.this.binding.alreadyEpicLayout.setVisibility(8);
                }
            }
        });
        this.binding.submitSIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        if (TextUtils.isEmpty(this.enumrationFormPage1UrlS) && TextUtils.isEmpty(this.enumrationFormPage2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLL.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.enumrationFormPage1UrlS)) {
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.firstLL.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.enumrationFormPage2UrlS)) {
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
            this.binding.secondLL.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.enumrationFormPage1UrlS)) {
            getFile1(this.enumrationFormPage1UrlS);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.enumerationFormLayout.setVisibility(8);
            if (this.enumrationFormPage1UrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.enumrationFormPage2UrlS)) {
            getFile2(this.enumrationFormPage2UrlS);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.enumerationFormLayout.setVisibility(8);
            if (this.enumrationFormPage2UrlS.endsWith(".pdf")) {
                this.binding.backImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (TextUtils.isEmpty(this.supportingDocumentPage1UrlS) && TextUtils.isEmpty(this.supportingDocumentPage2UrlS)) {
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.fbImageLL1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.supportingDocumentPage1UrlS)) {
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.supportingDocumentPage2UrlS)) {
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
            this.binding.secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.supportingDocumentPage1UrlS)) {
            getFile3(this.supportingDocumentPage1UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            this.binding.supprtingDocumentsLayout.setVisibility(8);
            if (this.supportingDocumentPage1UrlS.endsWith(".pdf")) {
                this.binding.frontImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.supportingDocumentPage2UrlS)) {
            getFile4(this.supportingDocumentPage2UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            this.binding.supprtingDocumentsLayout.setVisibility(8);
            if (this.enumrationFormPage2UrlS.endsWith(".pdf")) {
                this.binding.backImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.pickPhoto(101, "enFormPage1");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.pickPhoto(102, "enFormPage2");
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.pickPhoto(103, "sDPage1");
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.pickPhoto(104, "sDPage2");
            }
        });
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.binding.firstLL.setVisibility(8);
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                UncollectableSIRoldBH.this.binding.enumerationFormLayout.setVisibility(0);
                UncollectableSIRoldBH.this.enumrationFormPage1UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage1UrlS) && TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage2UrlS)) {
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.binding.secondLL.setVisibility(8);
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                UncollectableSIRoldBH.this.enumrationFormPage2UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage1UrlS) && TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage2UrlS)) {
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                }
                UncollectableSIRoldBH.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.binding.firstLL1.setVisibility(8);
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                UncollectableSIRoldBH.this.binding.supprtingDocumentsLayout.setVisibility(0);
                UncollectableSIRoldBH.this.supportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage1UrlS) && TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage2UrlS)) {
                    UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIRoldBH.this.binding.secondLL1.setVisibility(8);
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                UncollectableSIRoldBH.this.supportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage1UrlS) && TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage2UrlS)) {
                    UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                }
                UncollectableSIRoldBH.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda8
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
        if (TextUtils.isEmpty(this.enumrationFormPage1UrlS) || TextUtils.isEmpty(this.enumrationFormPage2UrlS)) {
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
        this.status.add(new UnCollectableStatusBH(this.partSerialNo, this.epic, "U", "Y", "Y", "N", "Y", "", "", this.currentDate, this.unCollectReason, "", this.alreadyEpic, this.enumrationFormPage1UrlS, this.enumrationFormPage2UrlS, this.supportingDocumentPage1UrlS, this.supportingDocumentPage2UrlS));
        UnCollectableModelBH unCollectableModelBH = new UnCollectableModelBH(this.state, this.acNo, this.partNo, this.status);
        this.bodyModel = unCollectableModelBH;
        this.service.saveEnumerationStatus(map, unCollectableModelBH).enqueue(new AnonymousClass10());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        AnonymousClass10() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r5 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$10$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableSIRoldTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableSIRoldTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent(UncollectableSIRoldBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableSIRoldTAG", t.getMessage());
        }
    }

    private void checkEpicNumber(String epic) {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("epicNumber", epic);
        map.put("isActive", "Y");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getEpicForForm8(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass11());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonArray> {
        AnonymousClass11() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
                    Toast.makeText((Context) UncollectableSIRoldBH.this, (CharSequence) "Valid EPIC", 0).show();
                    UncollectableSIRoldBH.this.validEpicFlag = "Y";
                    UncollectableSIRoldBH.this.submit();
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                    return;
                }
                UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.getString(R.string.alertMsg), UncollectableSIRoldBH.this.getString(R.string.please_check_epic_number));
                UncollectableSIRoldBH.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r4 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent(UncollectableSIRoldBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableSIRoldTAG", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda0
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda1
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
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("RE")) {
            startActivity(new Intent((Context) this, (Class<?>) RollbackFormsListBH.class));
            finish();
        } else if (this.flag.equalsIgnoreCase("RN")) {
            startActivity(new Intent((Context) this, (Class<?>) RollBAckNewFormsBH.class));
            finish();
        } else if (this.flag.equalsIgnoreCase("ERO")) {
            startActivity(new Intent((Context) this, (Class<?>) RollBAckNewFormsEroBH.class));
            finish();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda2
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1str);
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
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
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
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3str);
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
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4str);
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
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4str);
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$$ExternalSyntheticLambda3
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
        restClient.uploadImageWithSIR(this.token, "blo", "BLOAPP", partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass12(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass12(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v22, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r13 = UncollectableSIRoldBH.this;
                String str = ((UncollectableSIRoldBH) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$12$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo1str)) {
                    UncollectableSIRoldBH.this.enumrationFormPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo2str)) {
                    UncollectableSIRoldBH.this.enumrationFormPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo3str)) {
                    UncollectableSIRoldBH.this.supportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo4str)) {
                    UncollectableSIRoldBH.this.supportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo1str)) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.photo1count = 0;
                UncollectableSIRoldBH.this.binding.enumerationFormPage1.setVisibility(8);
                UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo2str)) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.photo2count = 0;
                UncollectableSIRoldBH.this.binding.enumerationFormPage2.setVisibility(8);
                UncollectableSIRoldBH uncollectableSIRoldBH2 = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH2.showDialog1(uncollectableSIRoldBH2.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo3str)) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.photo3count = 0;
                UncollectableSIRoldBH.this.binding.supportingDocumentsPage1.setVisibility(8);
                UncollectableSIRoldBH uncollectableSIRoldBH3 = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH3.showDialog1(uncollectableSIRoldBH3.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo4str)) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.photo4count = 0;
                UncollectableSIRoldBH.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIRoldBH uncollectableSIRoldBH4 = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH4.showDialog1(uncollectableSIRoldBH4.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                UncollectableSIRoldBH.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            UncollectableSIRoldBH.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str8 + " " + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r2 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$12$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UncollectableSIRoldBH.this.token = "Bearer " + str8;
            UncollectableSIRoldBH.this.refreshToken = str9;
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setToken("Bearer " + str8);
            UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
            uncollectableSIRoldBH.uploadPhoto(str, str2, str3, str4, str5, uncollectableSIRoldBH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent((Context) UncollectableSIRoldBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo1str)) {
                if (UncollectableSIRoldBH.this.photo1count < 2 && TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage1UrlS)) {
                    UncollectableSIRoldBH.this.photo1count++;
                    UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRoldBH.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRoldBH.this.photo1count = 0;
                    UncollectableSIRoldBH.this.binding.enumerationFormPage1.setVisibility(8);
                    UncollectableSIRoldBH uncollectableSIRoldBH2 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH2.showDialog1(uncollectableSIRoldBH2.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo2str)) {
                if (UncollectableSIRoldBH.this.photo2count < 2 && TextUtils.isEmpty(UncollectableSIRoldBH.this.enumrationFormPage2UrlS)) {
                    UncollectableSIRoldBH.this.photo2count++;
                    UncollectableSIRoldBH uncollectableSIRoldBH3 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRoldBH3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRoldBH.this.photo2count = 0;
                    UncollectableSIRoldBH.this.binding.enumerationFormPage2.setVisibility(8);
                    UncollectableSIRoldBH uncollectableSIRoldBH4 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH4.showDialog1(uncollectableSIRoldBH4.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo3str)) {
                if (UncollectableSIRoldBH.this.photo3count < 2 && TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage1UrlS)) {
                    UncollectableSIRoldBH.this.photo3count++;
                    UncollectableSIRoldBH uncollectableSIRoldBH5 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRoldBH5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    UncollectableSIRoldBH.this.photo3count = 0;
                    UncollectableSIRoldBH.this.binding.supportingDocumentsPage1.setVisibility(8);
                    UncollectableSIRoldBH uncollectableSIRoldBH6 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH6.showDialog1(uncollectableSIRoldBH6.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                    UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIRoldBH.this.photo4str)) {
                if (UncollectableSIRoldBH.this.photo4count < 2 && TextUtils.isEmpty(UncollectableSIRoldBH.this.supportingDocumentPage2UrlS)) {
                    UncollectableSIRoldBH.this.photo4count++;
                    UncollectableSIRoldBH uncollectableSIRoldBH7 = UncollectableSIRoldBH.this;
                    uncollectableSIRoldBH7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIRoldBH7.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.photo4count = 0;
                UncollectableSIRoldBH.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIRoldBH uncollectableSIRoldBH8 = UncollectableSIRoldBH.this;
                uncollectableSIRoldBH8.showDialog1(uncollectableSIRoldBH8.alertText, UncollectableSIRoldBH.this.fileNotFoundMessage);
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIRoldBH.this.whitecolor));
                UncollectableSIRoldBH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d("UncollectableSIRoldTAG", "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d("UncollectableSIRoldTAG", str2);
            Logger.d("UncollectableSIRoldTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d("UncollectableSIRoldTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d("UncollectableSIRoldTAG", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("UncollectableSIRoldTAG", "filesize " + this.filesize);
        Logger.d("UncollectableSIRoldTAG", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    private void deletePhoto(int code) {
        if (code == 101) {
            this.enumrationFormPage1UrlS = null;
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
            this.binding.enumerationFormPage1Image.setVisibility(8);
            this.binding.enumerationFormPage1ImageSize.setText("");
            this.binding.enumerationFormPage1ImageName.setText("");
            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.enumrationFormPage2UrlS) && TextUtils.isEmpty(this.enumrationFormPage1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 102) {
            this.enumrationFormPage2UrlS = null;
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
            this.binding.enumerationFormPage2Image.setVisibility(8);
            this.binding.enumerationFormPage2ImageSize.setText("");
            this.binding.enumerationFormPage2ImageName.setText("");
            this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.enumrationFormPage2UrlS) && TextUtils.isEmpty(this.enumrationFormPage1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 103) {
            this.supportingDocumentPage1UrlS = null;
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.supportingDocumentsPage1Image.setVisibility(8);
            this.binding.supportingDocumentsPage1ImageName.setText("");
            this.binding.supportingDocumentsPage1ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.supportingDocumentPage1UrlS) && TextUtils.isEmpty(this.supportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 104) {
            this.supportingDocumentPage2UrlS = null;
            this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.supportingDocumentsPage2Image.setVisibility(8);
            this.binding.supportingDocumentsPage2ImageName.setText("");
            this.binding.supportingDocumentsPage2ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.supportingDocumentPage1UrlS) && TextUtils.isEmpty(this.supportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
        }
    }

    public void getFile1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass13(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
            if (response.code() == 200) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(UncollectableSIRoldBH.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    UncollectableSIRoldBH.this.binding.frontImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (UncollectableSIRoldBH.this.base64element1.isEmpty() || UncollectableSIRoldBH.this.base64element1.equals("null")) {
                    UncollectableSIRoldBH.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIRoldBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                    ?? r6 = UncollectableSIRoldBH.this;
                    String str = ((UncollectableSIRoldBH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$13$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIRoldBH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$13$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableSIRoldTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIRoldBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableSIRoldTAG", e.getMessage());
                }
            }
            UncollectableSIRoldBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            UncollectableSIRoldBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r5 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$13$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIRoldBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIRoldBH.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent((Context) UncollectableSIRoldBH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag + t.getMessage());
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
            uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFile2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
            if (response.code() == 200) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.base64element2 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(UncollectableSIRoldBH.this.base64element2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    UncollectableSIRoldBH.this.binding.backImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (UncollectableSIRoldBH.this.base64element2.isEmpty() || UncollectableSIRoldBH.this.base64element2.equals("null")) {
                    UncollectableSIRoldBH.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIRoldBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                    ?? r6 = UncollectableSIRoldBH.this;
                    String str = ((UncollectableSIRoldBH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$14$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIRoldBH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$14$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableSIRoldTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIRoldBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableSIRoldTAG", e.getMessage());
                }
            }
            UncollectableSIRoldBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            UncollectableSIRoldBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r5 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$14$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIRoldBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIRoldBH.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent((Context) UncollectableSIRoldBH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag + t.getMessage());
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
            uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFile3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
            if (response.code() == 200) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.base64element3 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(UncollectableSIRoldBH.this.base64element3, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    UncollectableSIRoldBH.this.binding.frontImage1.setImageBitmap(bitmapDecodeByteArray);
                }
                if (UncollectableSIRoldBH.this.base64element3.isEmpty() || UncollectableSIRoldBH.this.base64element3.equals("null")) {
                    UncollectableSIRoldBH.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIRoldBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                    ?? r6 = UncollectableSIRoldBH.this;
                    String str = ((UncollectableSIRoldBH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$15$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIRoldBH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$15$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableSIRoldTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIRoldBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableSIRoldTAG", e.getMessage());
                }
            }
            UncollectableSIRoldBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            UncollectableSIRoldBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r5 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$15$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIRoldBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIRoldBH.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent((Context) UncollectableSIRoldBH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag + t.getMessage());
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
            uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFile4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
            if (response.code() == 200) {
                if (UncollectableSIRoldBH.this.alertDialog != null) {
                    UncollectableSIRoldBH.this.alertDialog.dismiss();
                }
                UncollectableSIRoldBH.this.base64element4 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(UncollectableSIRoldBH.this.base64element4, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    UncollectableSIRoldBH.this.binding.backImage1.setImageBitmap(bitmapDecodeByteArray);
                }
                if (UncollectableSIRoldBH.this.base64element4.isEmpty() || UncollectableSIRoldBH.this.base64element4.equals("null")) {
                    UncollectableSIRoldBH.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIRoldBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                    ?? r6 = UncollectableSIRoldBH.this;
                    String str = ((UncollectableSIRoldBH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$16$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIRoldBH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$16$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableSIRoldTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIRoldBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIRoldBH.this.alertDialog != null) {
                        UncollectableSIRoldBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableSIRoldTAG", e.getMessage());
                }
            }
            UncollectableSIRoldBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            UncollectableSIRoldBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIRoldBH.this.commomUtility;
                ?? r5 = UncollectableSIRoldBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH$16$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIRoldBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIRoldBH.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIRoldBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIRoldBH.this.startActivity(new Intent((Context) UncollectableSIRoldBH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableSIRoldTAG", UncollectableSIRoldBH.this.comingTag + t.getMessage());
            if (UncollectableSIRoldBH.this.alertDialog != null) {
                UncollectableSIRoldBH.this.alertDialog.dismiss();
            }
            UncollectableSIRoldBH uncollectableSIRoldBH = UncollectableSIRoldBH.this;
            uncollectableSIRoldBH.showDialog1(uncollectableSIRoldBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }
}
