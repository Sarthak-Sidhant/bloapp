package in.gov.eci.bloapp.views.activity.sir;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityUncollectableSirBinding;
import in.gov.eci.bloapp.model.SIR.unCollectableModel;
import in.gov.eci.bloapp.model.SIR.unCollectableStatus;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.PSEVerificationListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyCitizenFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.pendingElectorsEpicMatch;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.UncollectableDocumentListActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.AsdListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.UncollectedEF.UncollectedEF;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UncollectableSIR extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String alreadyEpic;
    String asmblyNO;
    private String atkband;
    ActivityUncollectableSirBinding binding;
    unCollectableModel bodyModel;
    byte[] byteArray;
    String currentDate;
    private String epic;
    private Long epicId;
    protected long filesize;
    String flag;
    String from;
    String mime;
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
    Utils utils;
    String img = "image";
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    ArrayList<unCollectableModel> bodyList = new ArrayList<>();
    ArrayList<unCollectableStatus> status = new ArrayList<>();
    String validEpicFlag = "N";
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
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    String reasonTrans = "";
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String messageString = "message";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityUncollectableSirBinding.inflate(getLayoutInflater());
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
        initClickListener();
        this.utils = new Utils();
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableTAG", str);
        this.epicId = Long.valueOf(getIntent().getLongExtra("epicId", 0L));
        this.epic = TextUtils.isEmpty(getIntent().getStringExtra("epic")) ? "" : getIntent().getStringExtra("epic");
        this.partSerialNo = getIntent().getIntExtra("psl", 0);
        this.flag = TextUtils.isEmpty(getIntent().getStringExtra("flag")) ? "" : getIntent().getStringExtra("flag");
        this.from = getIntent().getStringExtra("from");
        if (this.flag.equalsIgnoreCase("UN")) {
            String stringExtra = TextUtils.isEmpty(getIntent().getStringExtra("reason")) ? "" : getIntent().getStringExtra("reason");
            this.reason = stringExtra;
            Logger.d("reasonUCEF", stringExtra);
            this.unCollectReason = this.reason;
            this.binding.absentRb.setEnabled(false);
            this.binding.alreadyEnrolledRb.setEnabled(false);
            this.binding.deadRb.setEnabled(false);
            this.binding.permanentRb.setEnabled(false);
            this.binding.alreadyEpicLayout.setVisibility(8);
            String stringExtra2 = TextUtils.isEmpty(getIntent().getStringExtra("enrolledEpic")) ? "" : getIntent().getStringExtra("enrolledEpic");
            if (this.reason.equalsIgnoreCase("Untraceable/Absent")) {
                this.binding.absentRb.setChecked(true);
            } else if (this.reason.equalsIgnoreCase("Already enrolled")) {
                this.binding.alreadyEpicLayout.setVisibility(0);
                if (this.epic.equals(stringExtra2)) {
                    this.binding.enterEpicSirTv.setText("");
                } else {
                    this.binding.enterEpicSirTv.setText(stringExtra2);
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
        if (this.flag.equalsIgnoreCase("ERO")) {
            setValue();
        } else if (this.flag.equalsIgnoreCase("Uncollected")) {
            setValueUncollected();
        }
        this.binding.uncollectableRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) UncollectableSIR.this.findViewById(radioGroup.getCheckedRadioButtonId());
                int iIndexOfChild = radioGroup.indexOfChild(radioButton);
                if (iIndexOfChild == 0) {
                    UncollectableSIR.this.reasonTrans = String.valueOf(iIndexOfChild);
                } else {
                    UncollectableSIR.this.reasonTrans = String.valueOf(iIndexOfChild - 1);
                }
                UncollectableSIR.this.unCollectReason = radioButton.getText().toString();
                if (UncollectableSIR.this.unCollectReason.equalsIgnoreCase(UncollectableSIR.this.getString(R.string.already_enrolled_sir))) {
                    UncollectableSIR.this.binding.alreadyEpicLayout.setVisibility(0);
                } else {
                    UncollectableSIR.this.binding.alreadyEpicLayout.setVisibility(8);
                    UncollectableSIR.this.binding.enterEpicSirTv.setText("");
                }
            }
        });
        this.binding.submitSIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.speakReason.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.2
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
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UncollectableSIR.this.utils.showVoicePopup(UncollectableSIR.this, new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.2.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        if (result.length() > 150) {
                            UncollectableSIR.this.showDialog1(UncollectableSIR.this.getString(R.string.alertMsg), "Reason should not be more the 150 characters.");
                        } else {
                            UncollectableSIR.this.binding.resontv.setText(result);
                        }
                    }
                });
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.pickPhoto(101, "enFormPage1");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeDocument1UrlS)) {
                    UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                    uncollectableSIR.showDialog1(uncollectableSIR.alertText, "Please Upload Page 1");
                } else {
                    UncollectableSIR.this.pickPhoto(102, "enFormPage2");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.pickPhoto(103, "sDPage1");
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage1UrlS)) {
                    UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                    uncollectableSIR.showDialog1(uncollectableSIR.alertText, "Please Upload Page 1");
                } else {
                    UncollectableSIR.this.pickPhoto(104, "sDPage2");
                }
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.textView5.setText("v" + new CommomUtility().appversion);
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
        String string = this.binding.resontv.getText().toString();
        if (this.binding.uncollectableRG.getCheckedRadioButtonId() == -1) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.selectOneMsg));
        } else if (this.binding.resontv.getText().toString().isEmpty()) {
            showDialog1(this.alertText, "Please enter reason");
        } else if (this.binding.alreadyEnrolledRb.isChecked() && TextUtils.isEmpty(this.alreadyEpic) && !this.alreadyEpic.equals(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.enterEpicMsg));
        } else if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(getString(R.string.alertMsg), getString(R.string.uploadfrontpagemsg));
        } else {
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
            String lowerCase = this.state.toLowerCase();
            this.status.add(new unCollectableStatus(this.partSerialNo, this.epic, this.epicId, "U", "Y", "Y", "N", "Y", "", "", this.currentDate, this.reasonTrans, "", this.alreadyEpic, this.relativeDocument1UrlS, this.relativeDocument2UrlS, this.relativeSupportingDocumentPage1UrlS, this.relativeSupportingDocumentPage2UrlS, string));
            unCollectableModel uncollectablemodel = new unCollectableModel(this.state, this.acNo, this.partNo, this.status);
            this.bodyModel = uncollectablemodel;
            this.service.saveEnumerationStatusSIR(lowerCase, map, uncollectablemodel).enqueue(new AnonymousClass7());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r5 = UncollectableSIR.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                uncollectableSIR.showDialog1(uncollectableSIR.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent(UncollectableSIR.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableTAG", t.getMessage());
        }
    }

    private void checkEpicNumber(String epic) {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("epicNumber", epic);
        map.put("isActive", "Y");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getEpicForForm8(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass8());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonArray> {
        AnonymousClass8() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                    Toast.makeText((Context) UncollectableSIR.this, (CharSequence) "Valid EPIC", 0).show();
                    UncollectableSIR.this.validEpicFlag = "Y";
                    UncollectableSIR.this.submit();
                    UncollectableSIR.this.alertDialog.dismiss();
                    return;
                }
                UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                uncollectableSIR.showDialog1(uncollectableSIR.getString(R.string.alertMsg), UncollectableSIR.this.getString(R.string.please_check_epic_number));
                UncollectableSIR.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r4 = UncollectableSIR.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent(UncollectableSIR.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda8
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda12
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
            if (this.from.equalsIgnoreCase("pendingelector")) {
                Intent intent = new Intent((Context) this, (Class<?>) pendingElectors.class);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
            Intent intent2 = new Intent((Context) this, (Class<?>) pendingElectorsEpicMatch.class);
            intent2.setFlags(67108864);
            startActivity(intent2);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("RE")) {
            Intent intent3 = new Intent((Context) this, (Class<?>) SentBackEroFormsListActivity.class);
            intent3.setFlags(67108864);
            startActivity(intent3);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("RN")) {
            Intent intent4 = new Intent((Context) this, (Class<?>) RollBAckNewForms.class);
            intent4.setFlags(67108864);
            startActivity(intent4);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("UN")) {
            Intent intent5 = new Intent((Context) this, (Class<?>) UncollectedEF.class);
            intent5.setFlags(67108864);
            startActivity(intent5);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("ERO")) {
            Intent intent6 = new Intent((Context) this, (Class<?>) SentBackEroUncollectableListActivity.class);
            intent6.setFlags(67108864);
            startActivity(intent6);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("Uncollected")) {
            Intent intent7 = new Intent((Context) this, (Class<?>) UncollectableDocumentListActivity.class);
            intent7.setFlags(67108864);
            startActivity(intent7);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("verifym")) {
            Intent intent8 = new Intent((Context) this, (Class<?>) VerifyCitizenFormsListActivity.class);
            intent8.setFlags(67108864);
            startActivity(intent8);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("reverifym")) {
            Intent intent9 = new Intent((Context) this, (Class<?>) ReverifyFormsListActivity.class);
            intent9.setFlags(67108864);
            startActivity(intent9);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("asdlist")) {
            Intent intent10 = new Intent((Context) this, (Class<?>) AsdListAdapter.class);
            intent10.setFlags(67108864);
            startActivity(intent10);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("duplicateverify")) {
            Intent intent11 = new Intent((Context) this, (Class<?>) DuplicateVerificationListActivity.class);
            intent11.setFlags(67108864);
            startActivity(intent11);
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("pseverify")) {
            Intent intent12 = new Intent((Context) this, (Class<?>) PSEVerificationListActivity.class);
            intent12.setFlags(67108864);
            startActivity(intent12);
            finish();
            return;
        }
        if (this.from.equalsIgnoreCase("pendingelector")) {
            Intent intent13 = new Intent((Context) this, (Class<?>) pendingElectors.class);
            intent13.setFlags(67108864);
            startActivity(intent13);
            finish();
            return;
        }
        Intent intent14 = new Intent((Context) this, (Class<?>) pendingElectorsEpicMatch.class);
        intent14.setFlags(67108864);
        startActivity(intent14);
        finish();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initClickListener$7(View view) {
        if (this.flag.equalsIgnoreCase("RE")) {
            finish();
            return;
        }
        if (this.flag.equalsIgnoreCase("ERO") || this.flag.equalsIgnoreCase("reverifym") || this.flag.equalsIgnoreCase("verifym") || this.flag.equalsIgnoreCase("asdlist") || this.flag.equalsIgnoreCase("duplicateverify") || this.flag.equalsIgnoreCase("Uncollected") || this.flag.equalsIgnoreCase("pseverify")) {
            finish();
        } else if (this.flag.equalsIgnoreCase("PL")) {
            finish();
        } else {
            startActivity(new Intent((Context) this, (Class<?>) pendingElectors.class));
            finish();
        }
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
                        this.binding.enumerationFormPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.enumerationFormPage1ImageSize.setText(dRound + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 102) {
                long j3 = this.filesize;
                if (j3 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
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
                        this.binding.enumerationFormPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.enumerationFormPage2ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 103) {
                long j5 = this.filesize;
                if (j5 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
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
                    ImageView imageView = this.binding.supportingDocumentsPage2Image;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
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
                        ImageView imageView2 = this.binding.supportingDocumentsPage2Image;
                        byte[] bArr2 = this.pdfbyteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda1
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
            this.binding.enumerationFormPage1.setVisibility(8);
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
            this.binding.enumerationFormPage2.setVisibility(8);
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
            this.binding.supportingDocumentsPage1.setVisibility(8);
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
            this.binding.supportingDocumentsPage2.setVisibility(8);
            this.binding.supportingDocumentsPage2ImageName.setText("");
            this.binding.supportingDocumentsPage2ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
        }
    }

    public static String getMD5Checksum(File file) {
        String strEncodeToString;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                if (Build.VERSION.SDK_INT >= 33) {
                    strEncodeToString = java.util.Base64.getEncoder().encodeToString(messageDigest.digest(fileInputStream.readAllBytes()));
                } else {
                    strEncodeToString = java.util.Base64.getEncoder().encodeToString(messageDigest.digest(toByteArray(fileInputStream)));
                }
                fileInputStream.close();
                return strEncodeToString;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr, 0, 1024);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static SecretKey convertStringToSecretKey(String encodedKey) {
        byte[] bArrDecode = java.util.Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES");
    }

    private static GCMParameterSpec generateGcm() {
        return new GCMParameterSpec(128, new byte[16]);
    }

    public String decryptUrl(String cipherText) {
        try {
            String strDecrypt = decrypt("AES/GCM/NoPadding", cipherText, convertStringToSecretKey("P79vtNtk/WZaAXsQKCHClA=="), generateGcm());
            if (strDecrypt.length() < 20 || strDecrypt == null) {
                return null;
            }
            return strDecrypt.substring(14, strDecrypt.length() - 6);
        } catch (Exception unused) {
            System.out.println("decryption failed");
            return null;
        }
    }

    private static String decrypt(String algorithm, String cipherText, SecretKey key, GCMParameterSpec gcmParameterSpec) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(2, key, gcmParameterSpec);
            return new String(cipher.doFinal(java.util.Base64.getDecoder().decode(cipherText)));
        } catch (Exception unused) {
            return null;
        }
    }

    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        try {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            String strSubstring = captureFileName.substring(captureFileName.lastIndexOf("."));
            this.mime = "";
            if (".jpg".equalsIgnoreCase(strSubstring) || ".png".equalsIgnoreCase(strSubstring) || ".jpeg".equalsIgnoreCase(strSubstring)) {
                this.mime = "image/jpeg";
            } else if (".pdf".equalsIgnoreCase(strSubstring)) {
                this.mime = "application/pdf";
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("currentRole", "blo");
            map.put("state", this.state);
            map.put("Content-Type", "application/json");
            map.put("userId", SharedPref.getInstance(getApplicationContext()).getUserName());
            String mD5Checksum = getMD5Checksum(new File(filepath + captureFileName));
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.epic);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d("UncollectableTAG", map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass9(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass9(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r13 = UncollectableSIR.this;
                String str = ((UncollectableSIR) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$9$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                JsonResponse jsonResponse = (JsonResponse) new Gson().fromJson(response.errorBody().toString(), JsonResponse.class);
                if (jsonResponse.getPayload() != null) {
                    Object payload = jsonResponse.getPayload();
                    jsonResponse.getRefId();
                    if (payload instanceof Map) {
                        Map map = (Map) payload;
                        Double d = (Double) map.get("retryTime");
                        Long lValueOf = Long.valueOf(Math.round(d.doubleValue() * 1000.0d));
                        System.out.println("Retry time : " + lValueOf);
                        try {
                            Thread.sleep(lValueOf.longValue());
                        } catch (Exception unused) {
                        }
                        UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                        uncollectableSIR.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIR.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UncollectableSIR.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(UncollectableSIR.this.photo1strNew)) {
                        UncollectableSIR.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UncollectableSIR.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UncollectableSIR.this.relativeDocument1UrlS);
                    }
                    if (this.val$uploadtype.equals(UncollectableSIR.this.photo2strNew)) {
                        UncollectableSIR.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UncollectableSIR.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UncollectableSIR.this.relativeDocument2UrlS);
                    }
                    if (this.val$uploadtype.equals(UncollectableSIR.this.photo3strNew)) {
                        UncollectableSIR.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UncollectableSIR.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UncollectableSIR.this.relativeSupportingDocumentPage1UrlS);
                    }
                    if (this.val$uploadtype.equals(UncollectableSIR.this.photo4strNew)) {
                        UncollectableSIR.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UncollectableSIR.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UncollectableSIR.this.relativeSupportingDocumentPage2UrlS);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo1strNew)) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.photo1countNew = 0;
                UncollectableSIR.this.binding.enumerationFormPage1.setVisibility(8);
                UncollectableSIR.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                UncollectableSIR.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo2strNew)) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.photo2countNew = 0;
                UncollectableSIR.this.binding.enumerationFormPage2.setVisibility(8);
                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo3strNew)) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.photo3countNew = 0;
                UncollectableSIR.this.binding.supportingDocumentsPage1.setVisibility(8);
                UncollectableSIR.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                UncollectableSIR.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo4strNew)) {
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.photo4countNew = 0;
                UncollectableSIR.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIR.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                UncollectableSIR.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            UncollectableSIR.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                UncollectableSIR uncollectableSIR2 = UncollectableSIR.this;
                uncollectableSIR2.showDialog1(uncollectableSIR2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r2 = UncollectableSIR.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$9$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UncollectableSIR.this.token = "Bearer " + str8;
            UncollectableSIR.this.refreshToken = str9;
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setToken("Bearer " + str8);
            UncollectableSIR uncollectableSIR = UncollectableSIR.this;
            uncollectableSIR.uploadPhoto(str, str2, str3, str4, str5, uncollectableSIR.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent((Context) UncollectableSIR.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo1strNew)) {
                if (UncollectableSIR.this.photo1countNew < 2 && TextUtils.isEmpty(UncollectableSIR.this.relativeDocument1UrlS)) {
                    UncollectableSIR.this.photo1countNew++;
                    UncollectableSIR uncollectableSIR = UncollectableSIR.this;
                    uncollectableSIR.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIR.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.photo1countNew = 0;
                    UncollectableSIR.this.binding.enumerationFormPage1.setVisibility(8);
                    UncollectableSIR uncollectableSIR2 = UncollectableSIR.this;
                    uncollectableSIR2.showDialog1(uncollectableSIR2.alertText, UncollectableSIR.this.fileNotFoundMessage);
                    UncollectableSIR.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                    UncollectableSIR.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo2strNew)) {
                if (UncollectableSIR.this.photo2countNew < 2 && TextUtils.isEmpty(UncollectableSIR.this.relativeDocument2UrlS)) {
                    UncollectableSIR.this.photo2countNew++;
                    UncollectableSIR uncollectableSIR3 = UncollectableSIR.this;
                    uncollectableSIR3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIR3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.photo2countNew = 0;
                    UncollectableSIR.this.binding.enumerationFormPage2.setVisibility(8);
                    UncollectableSIR uncollectableSIR4 = UncollectableSIR.this;
                    uncollectableSIR4.showDialog1(uncollectableSIR4.alertText, UncollectableSIR.this.fileNotFoundMessage);
                    UncollectableSIR.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                    UncollectableSIR.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo3strNew)) {
                if (UncollectableSIR.this.photo3countNew < 2 && TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage1UrlS)) {
                    UncollectableSIR.this.photo3countNew++;
                    UncollectableSIR uncollectableSIR5 = UncollectableSIR.this;
                    uncollectableSIR5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIR5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.photo3countNew = 0;
                    UncollectableSIR.this.binding.supportingDocumentsPage1.setVisibility(8);
                    UncollectableSIR uncollectableSIR6 = UncollectableSIR.this;
                    uncollectableSIR6.showDialog1(uncollectableSIR6.alertText, UncollectableSIR.this.fileNotFoundMessage);
                    UncollectableSIR.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                    UncollectableSIR.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UncollectableSIR.this.photo4strNew)) {
                if (UncollectableSIR.this.photo4countNew < 2 && TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage2UrlS)) {
                    UncollectableSIR.this.photo4countNew++;
                    UncollectableSIR uncollectableSIR7 = UncollectableSIR.this;
                    uncollectableSIR7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uncollectableSIR7.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.photo4countNew = 0;
                UncollectableSIR.this.binding.supportingDocumentsPage2.setVisibility(8);
                UncollectableSIR uncollectableSIR8 = UncollectableSIR.this;
                uncollectableSIR8.showDialog1(uncollectableSIR8.alertText, UncollectableSIR.this.fileNotFoundMessage);
                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIR.this.whitecolor));
                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public void setValue() {
        if (this.flag.equalsIgnoreCase("ERO")) {
            String stringExtra = TextUtils.isEmpty(getIntent().getStringExtra("enrolledEpicNo")) ? "" : getIntent().getStringExtra("enrolledEpicNo");
            this.partSerialNo = getIntent().getIntExtra("psl", 0);
            this.relativeDocument1UrlS = getIntent().getStringExtra("photoUrl1");
            this.relativeDocument2UrlS = getIntent().getStringExtra("photoUrl2");
            this.relativeSupportingDocumentPage1UrlS = getIntent().getStringExtra("photoUrl3");
            this.relativeSupportingDocumentPage2UrlS = getIntent().getStringExtra("photoUrl4");
            String stringExtra2 = TextUtils.isEmpty(getIntent().getStringExtra("reason")) ? "" : getIntent().getStringExtra("reason");
            this.reason = stringExtra2;
            Logger.d("UncollectableTAG", stringExtra2);
            String str = this.reason;
            this.unCollectReason = str;
            if (!TextUtils.isEmpty(str)) {
                String str2 = this.unCollectReason;
                this.reasonTrans = str2;
                if (str2.equalsIgnoreCase("0") || this.reasonTrans.equalsIgnoreCase("Already enrolled")) {
                    this.reasonTrans = "0";
                    this.binding.alreadyEpicLayout.setVisibility(0);
                    this.binding.enterEpicSirTv.setText(stringExtra);
                    this.binding.alreadyEnrolledRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("1") || this.reasonTrans.equalsIgnoreCase("Death")) {
                    this.reasonTrans = "1";
                    this.binding.deadRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("2") || this.reasonTrans.equalsIgnoreCase("Permanently Shifted")) {
                    this.reasonTrans = "2";
                    this.binding.permanentRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("3") || this.reasonTrans.equalsIgnoreCase("Untraceable/Absent")) {
                    this.reasonTrans = "3";
                    this.binding.absentRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("4") || this.reasonTrans.equalsIgnoreCase("Refused to sign EF")) {
                    this.reasonTrans = "4";
                    this.binding.refusedRb.setChecked(true);
                } else {
                    this.binding.absentRb.setEnabled(true);
                    this.binding.alreadyEnrolledRb.setEnabled(true);
                    this.binding.deadRb.setEnabled(true);
                    this.binding.permanentRb.setEnabled(true);
                    this.binding.refusedRb.setEnabled(true);
                }
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("uncollectableRemarks"))) {
                this.binding.resontv.setText(getIntent().getStringExtra("uncollectableRemarks"));
            }
            setImages();
        }
        handledeleteClick();
    }

    public void setValueUncollected() {
        if (this.flag.equalsIgnoreCase("Uncollected")) {
            String stringExtra = TextUtils.isEmpty(getIntent().getStringExtra("enrolledEpicNo")) ? "" : getIntent().getStringExtra("enrolledEpicNo");
            this.partSerialNo = getIntent().getIntExtra("psl", 0);
            String stringExtra2 = TextUtils.isEmpty(getIntent().getStringExtra("reason")) ? "" : getIntent().getStringExtra("reason");
            this.reason = stringExtra2;
            Logger.d("UncollectableTAG", stringExtra2);
            String str = this.reason;
            this.unCollectReason = str;
            if (!TextUtils.isEmpty(str)) {
                String str2 = this.unCollectReason;
                this.reasonTrans = str2;
                if (str2.equalsIgnoreCase("0") || this.reasonTrans.equalsIgnoreCase("Already enrolled")) {
                    this.reasonTrans = "0";
                    this.binding.alreadyEpicLayout.setVisibility(0);
                    this.binding.enterEpicSirTv.setText(stringExtra);
                    this.binding.alreadyEnrolledRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("1") || this.reasonTrans.equalsIgnoreCase("Death")) {
                    this.reasonTrans = "1";
                    this.binding.deadRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("2") || this.reasonTrans.equalsIgnoreCase("Permanently Shifted")) {
                    this.reasonTrans = "2";
                    this.binding.permanentRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("3") || this.reasonTrans.equalsIgnoreCase("Untraceable/Absent")) {
                    this.reasonTrans = "3";
                    this.binding.absentRb.setChecked(true);
                } else if (this.reasonTrans.equalsIgnoreCase("4") || this.reasonTrans.equalsIgnoreCase("Refused to sign EF")) {
                    this.reasonTrans = "4";
                    this.binding.refusedRb.setChecked(true);
                } else {
                    this.binding.absentRb.setEnabled(true);
                    this.binding.alreadyEnrolledRb.setEnabled(true);
                    this.binding.deadRb.setEnabled(true);
                    this.binding.permanentRb.setEnabled(true);
                    this.binding.refusedRb.setEnabled(true);
                }
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("uncollectableRemarks"))) {
                this.binding.resontv.setText(getIntent().getStringExtra("uncollectableRemarks"));
            }
            this.binding.alreadyEnrolledRb.setEnabled(false);
            this.binding.enterEpicSirTv.setFocusable(false);
            this.binding.enterEpicSirTv.setEnabled(false);
            this.binding.deadRb.setEnabled(false);
            this.binding.permanentRb.setEnabled(false);
            this.binding.refusedRb.setEnabled(false);
            this.binding.absentRb.setEnabled(false);
            this.binding.resontv.setEnabled(false);
            this.binding.resontv.setFocusable(false);
            this.binding.speakReason.setClickable(false);
            this.binding.speakReason.setEnabled(false);
        }
    }

    private void handledeleteClick() {
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.binding.firstLL.setVisibility(8);
                UncollectableSIR.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                UncollectableSIR.this.binding.enumerationFormLayout.setVisibility(0);
                UncollectableSIR.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeDocument1UrlS) && TextUtils.isEmpty(UncollectableSIR.this.relativeDocument2UrlS)) {
                    UncollectableSIR.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                    UncollectableSIR.this.binding.fbImageLL.setVisibility(8);
                }
                if (UncollectableSIR.this.binding.secondLL.getVisibility() != 8 || TextUtils.isEmpty(UncollectableSIR.this.relativeDocument2UrlS)) {
                    return;
                }
                UncollectableSIR.this.binding.fbImageLL.setVisibility(8);
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.binding.secondLL.setVisibility(8);
                UncollectableSIR.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                UncollectableSIR.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeDocument1UrlS) && TextUtils.isEmpty(UncollectableSIR.this.relativeDocument2UrlS)) {
                    UncollectableSIR.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                    UncollectableSIR.this.binding.fbImageLL.setVisibility(8);
                }
                if (UncollectableSIR.this.binding.firstLL.getVisibility() == 8 && !TextUtils.isEmpty(UncollectableSIR.this.relativeDocument1UrlS)) {
                    UncollectableSIR.this.binding.fbImageLL.setVisibility(8);
                }
                UncollectableSIR.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.binding.firstLL1.setVisibility(8);
                UncollectableSIR.this.binding.lvSupportChoose1.setVisibility(0);
                UncollectableSIR.this.binding.supprtingDocumentsLayout.setVisibility(0);
                UncollectableSIR.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage2UrlS)) {
                    UncollectableSIR.this.binding.lvSupportChoose2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UncollectableSIR.this.binding.secondLL1.setVisibility(8);
                UncollectableSIR.this.binding.lvSupportChoose2.setVisibility(0);
                UncollectableSIR.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(UncollectableSIR.this.relativeSupportingDocumentPage2UrlS)) {
                    UncollectableSIR.this.binding.lvSupportChoose1.setVisibility(0);
                }
                UncollectableSIR.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
    }

    private void setImages() {
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) && TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLL.setVisibility(8);
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.firstLL.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
            this.binding.secondLL.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            getFile1(this.relativeDocument1UrlS);
            this.binding.lvPage1EnumrationChoose.setVisibility(8);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.firstLL.setVisibility(0);
            if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
                this.binding.lvPage2EnumrationChoose.setVisibility(8);
                this.binding.secondLL.setVisibility(0);
            } else {
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
                this.binding.secondLL.setVisibility(8);
            }
            if (this.relativeDocument1UrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            getFile2(this.relativeDocument2UrlS);
            this.binding.secondLL.setVisibility(0);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.lvPage2EnumrationChoose.setVisibility(8);
            if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.lvPage1EnumrationChoose.setVisibility(8);
                this.binding.firstLL.setVisibility(0);
            } else {
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.firstLL.setVisibility(8);
            }
            if (this.relativeDocument2UrlS.endsWith(".pdf")) {
                this.binding.backImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS) && !TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.fbImageLL1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
            this.binding.secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            getFile3(this.relativeSupportingDocumentPage1UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            this.binding.firstLL1.setVisibility(0);
            this.binding.lvSupportChoose1.setVisibility(8);
            if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.secondLL1.setVisibility(0);
                this.binding.lvSupportChoose2.setVisibility(8);
            } else {
                this.binding.secondLL1.setVisibility(8);
                this.binding.lvSupportChoose2.setVisibility(0);
            }
            if (this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
                this.binding.frontImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            return;
        }
        getFile4(this.relativeSupportingDocumentPage2UrlS);
        this.binding.fbImageLL1.setVisibility(0);
        this.binding.secondLL1.setVisibility(0);
        this.binding.lvSupportChoose2.setVisibility(8);
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.firstLL1.setVisibility(0);
            this.binding.lvSupportChoose1.setVisibility(8);
        } else {
            this.binding.firstLL1.setVisibility(8);
            this.binding.lvSupportChoose1.setVisibility(0);
        }
        if (this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
            this.binding.backImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UncollectableSIR.this).load(UncollectableSIR.this.preSignedurl1).into(UncollectableSIR.this.binding.frontImage);
                }
                if (TextUtils.isEmpty(UncollectableSIR.this.preSignedurl1)) {
                    UncollectableSIR.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIR.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                    ?? r6 = UncollectableSIR.this;
                    String str = ((UncollectableSIR) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$14$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIR.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$14$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIR.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UncollectableSIR.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
            UncollectableSIR.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r5 = UncollectableSIR.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$14$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIR.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIR.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent((Context) UncollectableSIR.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag + t.getMessage());
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
            UncollectableSIR uncollectableSIR = UncollectableSIR.this;
            uncollectableSIR.showDialog1(uncollectableSIR.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UncollectableSIR.this).load(UncollectableSIR.this.preSignedurl2).into(UncollectableSIR.this.binding.backImage);
                }
                if (TextUtils.isEmpty(UncollectableSIR.this.preSignedurl2)) {
                    UncollectableSIR.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIR.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                    ?? r6 = UncollectableSIR.this;
                    String str = ((UncollectableSIR) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$15$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIR.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$15$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIR.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UncollectableSIR.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
            UncollectableSIR.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r5 = UncollectableSIR.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$15$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIR.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIR.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent((Context) UncollectableSIR.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag + t.getMessage());
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
            UncollectableSIR uncollectableSIR = UncollectableSIR.this;
            uncollectableSIR.showDialog1(uncollectableSIR.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UncollectableSIR.this).load(UncollectableSIR.this.preSignedurl3).into(UncollectableSIR.this.binding.frontImage1);
                }
                if (TextUtils.isEmpty(UncollectableSIR.this.preSignedurl3)) {
                    UncollectableSIR.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIR.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                    ?? r6 = UncollectableSIR.this;
                    String str = ((UncollectableSIR) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$16$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIR.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$16$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIR.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UncollectableSIR.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
            UncollectableSIR.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r5 = UncollectableSIR.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$16$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIR.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIR.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent((Context) UncollectableSIR.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag + t.getMessage());
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
            UncollectableSIR uncollectableSIR = UncollectableSIR.this;
            uncollectableSIR.showDialog1(uncollectableSIR.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass17(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass17(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
                if (UncollectableSIR.this.alertDialog != null) {
                    UncollectableSIR.this.alertDialog.dismiss();
                }
                UncollectableSIR.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UncollectableSIR.this).load(UncollectableSIR.this.preSignedurl4).into(UncollectableSIR.this.binding.backImage1);
                }
                if (TextUtils.isEmpty(UncollectableSIR.this.preSignedurl4)) {
                    UncollectableSIR.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(UncollectableSIR.this.getResources(), R.drawable.blo_dummy_image));
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                    ?? r6 = UncollectableSIR.this;
                    String str = ((UncollectableSIR) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$17$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag);
                }
            } else {
                try {
                    UncollectableSIR.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$17$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UncollectableSIR.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UncollectableSIR.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
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
            UncollectableSIR.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UncollectableSIR.this.commomUtility;
                ?? r5 = UncollectableSIR.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$17$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UncollectableSIR.this.token = "Bearer " + str2;
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setToken("Bearer " + str2);
                UncollectableSIR.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectableSIR.this.getApplicationContext()).setLocaleBool(false);
            UncollectableSIR.this.startActivity(new Intent((Context) UncollectableSIR.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UncollectableSIR.this.comingTag + t.getMessage());
            if (UncollectableSIR.this.alertDialog != null) {
                UncollectableSIR.this.alertDialog.dismiss();
            }
            UncollectableSIR uncollectableSIR = UncollectableSIR.this;
            uncollectableSIR.showDialog1(uncollectableSIR.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        textView.setVisibility(8);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void resetImage(String imageType, String error) {
        if (imageType.equals(this.photo1strNew)) {
            this.relativeDocument1UrlS = "";
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.enumerationFormPage1.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
        }
        if (imageType.equals(this.photo2strNew)) {
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
            this.binding.enumerationFormPage2.setVisibility(8);
            this.relativeDocument2UrlS = "";
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
        }
        if (imageType.equals(this.photo3strNew)) {
            this.relativeSupportingDocumentPage1UrlS = "";
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.supportingDocumentsPage1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.photo4strNew)) {
            this.relativeSupportingDocumentPage2UrlS = "";
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.supportingDocumentsPage2.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.18
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(UncollectableSIR.this.photo1strNew)) {
                        UncollectableSIR.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.18.1
                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.binding.enumerationFormPage1.setVisibility(0);
                                UncollectableSIR.this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage1Image.setVisibility(0);
                                UncollectableSIR.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UncollectableSIR.this.greycolor));
                                UncollectableSIR.this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                Glide.with(UncollectableSIR.this).load(strReplace).into(UncollectableSIR.this.binding.enumerationFormPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UncollectableSIR.this.photo2strNew)) {
                        UncollectableSIR.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.18.2
                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.binding.enumerationFormPage2.setVisibility(0);
                                UncollectableSIR.this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                UncollectableSIR.this.binding.enumerationFormPage2Image.setVisibility(0);
                                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UncollectableSIR.this.greycolor));
                                UncollectableSIR.this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                Glide.with(UncollectableSIR.this).load(strReplace).into(UncollectableSIR.this.binding.enumerationFormPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UncollectableSIR.this.photo3strNew)) {
                        UncollectableSIR.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.18.3
                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.binding.supportingDocumentsPage1.setVisibility(0);
                                UncollectableSIR.this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                UncollectableSIR.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UncollectableSIR.this.greycolor));
                                UncollectableSIR.this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(UncollectableSIR.this).load(strReplace).into(UncollectableSIR.this.binding.supportingDocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equalsIgnoreCase(UncollectableSIR.this.photo4strNew)) {
                        UncollectableSIR.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.18.4
                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.binding.supportingDocumentsPage2.setVisibility(0);
                                UncollectableSIR.this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                UncollectableSIR.this.binding.supportingDocumentsPage2Image.setImageBitmap(BitmapFactory.decodeByteArray(UncollectableSIR.this.pdfbyteArray, 0, UncollectableSIR.this.pdfbyteArray.length));
                                UncollectableSIR.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UncollectableSIR.this.greycolor));
                                UncollectableSIR.this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(UncollectableSIR.this).load(strReplace).into(UncollectableSIR.this.binding.supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UncollectableSIR.this.alertDialog != null) {
                                    UncollectableSIR.this.alertDialog.dismiss();
                                }
                                UncollectableSIR.this.resetImage(uploadType, message);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.resetImage(uploadType, Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(UncollectableSIR.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    UncollectableSIR.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e("UncollectableTAG", e.getMessage());
                    UncollectableSIR.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                UncollectableSIR.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase(this.photo1strNew)) {
            int i = this.getImage1Count;
            if (i < 2) {
                this.getImage1Count = i + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.getImage1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo2strNew)) {
            int i2 = this.getImage2Count;
            if (i2 < 2) {
                this.getImage2Count = i2 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog2 = this.alertDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                this.getImage2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo3strNew)) {
            int i3 = this.getImage3Count;
            if (i3 < 2) {
                this.getImage3Count = i3 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog3 = this.alertDialog;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                this.getImage3Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo4strNew)) {
            int i4 = this.getImage4Count;
            if (i4 < 2) {
                this.getImage4Count = i4 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog4 = this.alertDialog;
            if (alertDialog4 != null) {
                alertDialog4.dismiss();
            }
            this.getImage4Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.19
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (UncollectableSIR.this.alertDialog != null) {
                        UncollectableSIR.this.alertDialog.dismiss();
                    }
                    UncollectableSIR.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(UncollectableSIR.this.photo1strNew)) {
                            UncollectableSIR.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UncollectableSIR.this.photo2strNew)) {
                            UncollectableSIR.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UncollectableSIR.this.photo3strNew)) {
                            UncollectableSIR.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UncollectableSIR.this.photo4strNew)) {
                            UncollectableSIR.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$12(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.UncollectableSIR] */
    public /* synthetic */ void lambda$checkImageFromURL$12(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        ?? r4 = 0;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection2.setConnectTimeout(10000);
                        httpsURLConnection2.setReadTimeout(20000);
                        httpsURLConnection2.setInstanceFollowRedirects(true);
                        httpsURLConnection2.setRequestMethod("GET");
                        httpsURLConnection2.setUseCaches(false);
                        httpsURLConnection2.setRequestProperty("Accept", "image/*,*/*;q=0.8");
                        httpsURLConnection2.connect();
                        int responseCode = httpsURLConnection2.getResponseCode();
                        if (responseCode != 200) {
                            if (responseCode != 403) {
                                str2 = responseCode != 404 ? "Server returned HTTP " + responseCode : "File not found (HTTP 404). The object may have been deleted or the URL is incorrect.";
                            } else {
                                str2 = "Link expired or invalid (HTTP 403). Please request a new presigned URL.";
                            }
                            throw new IOException(str2);
                        }
                        String contentType = httpsURLConnection2.getContentType();
                        String lowerCase = contentType == null ? "" : contentType.toLowerCase(Locale.US);
                        lowerCase.startsWith("image/");
                        if (httpsURLConnection2.getContentLength() == 0) {
                            throw new IOException("Content-Length is zero; image appears empty.");
                        }
                        InputStream inputStream = httpsURLConnection2.getInputStream();
                        if (inputStream == null) {
                            throw new IOException("Empty response body.");
                        }
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            bufferedInputStream.mark(64);
                            byte[] headBytes = readHeadBytes(bufferedInputStream, 16);
                            bufferedInputStream.reset();
                            if (headBytes.length == 0) {
                                throw new IOException("No data received; image appears empty.");
                            }
                            if (lowerCase.startsWith("image/")) {
                                if (!isImageMagic(headBytes)) {
                                    throw new IOException("Response says image/*, but header bytes don't match known image formats.");
                                }
                            } else if (!isImageMagic(headBytes)) {
                                throw new IOException("Unexpected content type (" + contentType + "); data does not look like an image.");
                            }
                            bufferedInputStream.close();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    downloadCallback.onSuccess(null);
                                }
                            });
                            r4 = headBytes;
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                                r4 = headBytes;
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        httpsURLConnection = httpsURLConnection2;
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.UncollectableSIR$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                UncollectableSIR.DownloadCallback downloadCallback2 = downloadCallback;
                                Exception exc = e;
                                downloadCallback2.onError(exc.getMessage(), exc);
                            }
                        });
                        r4 = httpsURLConnection;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            r4 = httpsURLConnection;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r4 = httpsURLConnection2;
                        if (r4 != 0) {
                            try {
                                r4.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused2) {
        }
    }

    private static byte[] readHeadBytes(InputStream is, int n) throws IOException {
        byte[] bArr = new byte[n];
        int i = is.read(bArr);
        if (i <= 0) {
            return new byte[0];
        }
        return Arrays.copyOf(bArr, i);
    }

    private static boolean isImageMagic(byte[] head) {
        byte b;
        int length = head == null ? 0 : head.length;
        if (length >= 3 && (head[0] & 255) == 255 && (head[1] & 255) == 216 && (head[2] & 255) == 255) {
            return true;
        }
        byte[] bArr = {-119, 80, 78, 71, 13, 10, 26, 10};
        if (length >= 8 && startsWithBytes(head, bArr)) {
            return true;
        }
        if (length >= 6 && head[0] == 71 && head[1] == 73 && head[2] == 70 && head[3] == 56 && (((b = head[4]) == 55 || b == 57) && head[5] == 97)) {
            return true;
        }
        if (length >= 12 && head[0] == 82 && head[1] == 73 && head[2] == 70 && head[3] == 70 && head[8] == 87 && head[9] == 69 && head[10] == 66 && head[11] == 80) {
            return true;
        }
        return length >= 2 && head[0] == 66 && head[1] == 77;
    }

    private static boolean startsWithBytes(byte[] a, byte[] prefix) {
        if (a == null || prefix == null || a.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (a[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }
}
