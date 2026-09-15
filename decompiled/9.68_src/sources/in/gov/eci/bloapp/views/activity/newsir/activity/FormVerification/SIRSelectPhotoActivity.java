package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.animation.ValueAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yalantis.ucrop.UCrop;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySirSelectPhotoSimpleBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.SelectPhotoPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.SelectPhotoRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.ImageUriUtils;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import kotlin.UByte;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SIRSelectPhotoActivity extends SuperBaseActivity {
    private int acNo;
    private Call<JsonObject> activeCall;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivitySirSelectPhotoSimpleBinding binding;
    byte[] byteArray;
    CommomUtility commonUtilClass;
    String currentDate;
    private float dpprivate;
    private Long epicId;
    private String epicNo;
    protected long filesize;
    String flag;
    String from;
    String image2;
    String mime;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private byte[] pdfbyteArray;
    String photoref;
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
    private ActivityResultLauncher<Intent> uCropLauncher;
    Utils utils;
    VerifyPayload verifyPayload;
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
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String messageString = "message";
    File efImageFile = null;
    String greycolor = "#99000000";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;
    String erollPhoto = "";
    String surveyPhoto = "";
    String choose_front_camera = "";
    String choose_back_camera = "";
    boolean faceRecognition = true;
    String photostr = "Photo";
    String whitecolor = "#000000";

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivitySirSelectPhotoSimpleBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
        }
        this.epicId = this.verifyPayload.getEpicId();
        this.epicNo = this.verifyPayload.getEpicNo();
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
        this.choose_front_camera = getString(R.string.capture_from_front_camera);
        this.choose_back_camera = getString(R.string.capture_from_back_camera);
        if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
            this.faceRecognition = true;
        } else {
            this.faceRecognition = false;
        }
        getPhotoDetails();
        this.binding.textView3.setText(getResources().getString(R.string.select_photo));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        animateCardElevation(this.binding.cardMale, 4.0f, 12.0f, 180L);
        animateCardElevation(this.binding.cardPhoto2, 12.0f, 4.0f, 180L);
        this.binding.cardMale.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(8);
                SIRSelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto1.setChecked(true);
                SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.animateCardElevation(sIRSelectPhotoActivity.binding.cardMale, 4.0f, 12.0f, 180L);
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.animateCardElevation(sIRSelectPhotoActivity2.binding.cardPhoto2, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.cardPhoto2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(8);
                SIRSelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto2.setChecked(true);
                SIRSelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.animateCardElevation(sIRSelectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.animateCardElevation(sIRSelectPhotoActivity2.binding.cardMale, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.rbPhoto1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(8);
                SIRSelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto1.setChecked(true);
                SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.animateCardElevation(sIRSelectPhotoActivity.binding.cardMale, 4.0f, 12.0f, 180L);
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.animateCardElevation(sIRSelectPhotoActivity2.binding.cardPhoto2, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.rbPhoto2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(8);
                SIRSelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SIRSelectPhotoActivity.this.binding.rbPhoto2.setChecked(true);
                SIRSelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.animateCardElevation(sIRSelectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.animateCardElevation(sIRSelectPhotoActivity2.binding.cardMale, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.btnOk.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SIRSelectPhotoActivity.this.validate();
            }
        });
        this.binding.notOkPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SIRSelectPhotoActivity.this.binding.notOkPhoto.isChecked()) {
                    SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(0);
                    SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                    SIRSelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                    SIRSelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                } else {
                    SIRSelectPhotoActivity.this.binding.cardElector.setVisibility(8);
                    SIRSelectPhotoActivity.this.binding.btnOk.setVisibility(0);
                }
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.animateCardElevation(sIRSelectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.animateCardElevation(sIRSelectPhotoActivity2.binding.cardMale, 4.0f, 12.0f, 180L);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.uCropLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda15
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$onCreate$2((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            choosseCameraOption();
        } else {
            pickFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            Uri output = UCrop.getOutput(activityResult.getData());
            if (output != null) {
                onCropSuccess(output);
                return;
            } else {
                onCropError(new Throwable("UCrop returned null output Uri"));
                return;
            }
        }
        if (activityResult.getResultCode() == 96) {
            onCropError(UCrop.getError(activityResult.getData()));
        } else {
            onCropCancelled();
        }
    }

    private void deletePhoto() {
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.passPhoto.setVisibility(0);
        this.binding.passPhotoLayout.setVisibility(8);
        this.photoref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void validate() {
        if (!this.binding.rbPhoto1.isChecked() && !this.binding.rbPhoto2.isChecked() && !this.binding.notOkPhoto.isChecked()) {
            this.utils.infoDialog(this, "Alert", "Please select atleast one option");
            return;
        }
        if (this.binding.rbPhoto1.isChecked() && TextUtils.isEmpty(this.erollPhoto)) {
            this.utils.infoDialog(this, "Alert", "Selected photo is not valid, Please choose other photo.");
            return;
        }
        if (this.binding.notOkPhoto.isChecked() && TextUtils.isEmpty(this.photoref)) {
            this.utils.infoDialog(this, "Alert", "Please upload new photo");
        } else if (this.binding.notOkPhoto.isChecked() && !TextUtils.isEmpty(this.photoref)) {
            updatePhotoFlagInSurvey();
        } else {
            submit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void fillForm8(String category) {
        Intent intent = new Intent((Context) this, (Class<?>) VoterForms.class);
        intent.putExtra("flag", "selectPhoto");
        intent.putExtra("category", category);
        intent.putExtra("epic", this.verifyPayload.getEpicNo());
        intent.putExtra("epicId", this.verifyPayload.getEpicId());
        if (this.state.equalsIgnoreCase("S04")) {
            intent.putExtra("efbase64image", this.surveyPhoto);
            intent.putExtra("efPhoto", "");
        } else {
            File file = this.efImageFile;
            intent.putExtra("efPhoto", file != null ? file.getAbsolutePath() : "");
            intent.putExtra("efbase64image", "");
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit() {
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
        map2.put("epicId", this.verifyPayload.getEpicId());
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        if (this.binding.rbPhoto1.isChecked()) {
            map2.put("flag", "E");
        } else if ((this.binding.rbPhoto2.getVisibility() == 0 && this.binding.rbPhoto2.isChecked()) || this.binding.notOkPhoto.isChecked()) {
            map2.put("flag", "S");
        }
        this.service.updatePhotoFlagInEnum(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                SIRSelectPhotoActivity.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 401) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r5 = SIRSelectPhotoActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.showDialog1(sIRSelectPhotoActivity.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SIRSelectPhotoActivity.this.startActivity(new Intent(SIRSelectPhotoActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$3(DialogInterface dialogInterface, int i) {
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$4(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) SelectPhotoListActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$5(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, final String listCode) {
        final String str = this.state + this.acNo + this.partNo;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$6(charSequenceArr, str, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$6(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + str2;
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
            this.saveImageFileName = "pdf_document" + code + str + this.pdfTextBaseActivity;
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
            map2.put("epicNo", this.verifyPayload.getEpicNo());
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d("UncollectableTAG", map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass8(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$8, reason: invalid class name */
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
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r13 = SIRSelectPhotoActivity.this;
                String str = ((SIRSelectPhotoActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$8$$ExternalSyntheticLambda1
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
                        SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                        sIRSelectPhotoActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, sIRSelectPhotoActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = SIRSelectPhotoActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equalsIgnoreCase(SIRSelectPhotoActivity.this.photostr)) {
                        SIRSelectPhotoActivity.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        SIRSelectPhotoActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, SIRSelectPhotoActivity.this.photoref);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    Logger.d("UncollectableTAG", strValueOf);
                    return;
                } catch (Exception e) {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    SIRSelectPhotoActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                SIRSelectPhotoActivity.this.photo1countNew = 0;
            }
            SIRSelectPhotoActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.showDialog1(sIRSelectPhotoActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r2 = SIRSelectPhotoActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SIRSelectPhotoActivity.this.token = "Bearer " + str8;
            SIRSelectPhotoActivity.this.refreshToken = str9;
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
            sIRSelectPhotoActivity.uploadPhoto(str, str2, str3, str4, str5, sIRSelectPhotoActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SIRSelectPhotoActivity.this.startActivity(new Intent((Context) SIRSelectPhotoActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (SIRSelectPhotoActivity.this.photo1countNew < 2 && TextUtils.isEmpty(SIRSelectPhotoActivity.this.relativeDocument1UrlS)) {
                    SIRSelectPhotoActivity.this.photo1countNew++;
                    SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                    sIRSelectPhotoActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, sIRSelectPhotoActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                SIRSelectPhotoActivity.this.photo1countNew = 0;
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.showDialog1(sIRSelectPhotoActivity2.alertText, SIRSelectPhotoActivity.this.fileNotFoundMessage);
            }
        }
    }

    public void setValue(String iamge1, String image2) {
        if (!TextUtils.isEmpty(iamge1)) {
            getImageinBase64(iamge1, "eroll");
        } else {
            this.binding.ivMale.setImageResource(R.drawable.blo_dummy_image);
        }
        if (!TextUtils.isEmpty(image2)) {
            getFile1(image2);
        } else {
            this.binding.ivPhoto2.setImageResource(R.drawable.new_dummy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                SIRSelectPhotoActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.checkImageFromURL(sIRSelectPhotoActivity.preSignedurl1, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.9.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.DownloadCallback
                    public void onSuccess(File pdfFile) {
                        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(SIRSelectPhotoActivity.this);
                        circularProgressDrawable.setStrokeWidth(6.0f);
                        circularProgressDrawable.setCenterRadius(24.0f);
                        circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(SIRSelectPhotoActivity.this, R.color.blo_blue)});
                        circularProgressDrawable.start();
                        Glide.with(SIRSelectPhotoActivity.this).load(SIRSelectPhotoActivity.this.preSignedurl1).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(SIRSelectPhotoActivity.this.binding.ivPhoto2);
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.DownloadCallback
                    public void onError(String message, Throwable cause) {
                        SIRSelectPhotoActivity.this.resetImage("DOB", message);
                    }
                });
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                    ?? r6 = SIRSelectPhotoActivity.this;
                    String str = ((SIRSelectPhotoActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$9$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", SIRSelectPhotoActivity.this.comingTag);
                }
            } else {
                try {
                    SIRSelectPhotoActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$9$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(SIRSelectPhotoActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    SIRSelectPhotoActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            SIRSelectPhotoActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
            SIRSelectPhotoActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r5 = SIRSelectPhotoActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$9$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                SIRSelectPhotoActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                SIRSelectPhotoActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SIRSelectPhotoActivity.this.startActivity(new Intent((Context) SIRSelectPhotoActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", SIRSelectPhotoActivity.this.comingTag + t.getMessage());
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
            SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
            sIRSelectPhotoActivity.showDialog1(sIRSelectPhotoActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void resetImage(String imageType, String error) {
        if (imageType.equalsIgnoreCase("DOB")) {
            this.relativeDocument1UrlS = "";
            this.surveyPhoto = null;
            this.binding.ivPhoto2.setImageResource(R.drawable.new_dummy);
            if (TextUtils.isEmpty(this.surveyPhoto)) {
                this.binding.cardPhoto2.setVisibility(4);
                this.binding.surveyText.setVisibility(4);
            }
        } else if (imageType.equals(this.photostr)) {
            this.photoref = "";
            this.binding.image.setVisibility(8);
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("preSignedurl1", strReplace);
                    SIRSelectPhotoActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.10.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                                SIRSelectPhotoActivity.this.alertDialog.dismiss();
                            }
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(SIRSelectPhotoActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(SIRSelectPhotoActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            if (uploadType.equals(SIRSelectPhotoActivity.this.photostr)) {
                                SIRSelectPhotoActivity.this.binding.passPhotoLayout.setVisibility(0);
                                SIRSelectPhotoActivity.this.binding.passPhoto.setVisibility(8);
                                SIRSelectPhotoActivity.this.binding.cancel.setVisibility(0);
                                SIRSelectPhotoActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(SIRSelectPhotoActivity.this.greycolor));
                                SIRSelectPhotoActivity.this.binding.chooseFileTv.setEnabled(false);
                                SIRSelectPhotoActivity.this.binding.photoNameTv2.setVisibility(0);
                                SIRSelectPhotoActivity.this.binding.image.setVisibility(0);
                                Glide.with(SIRSelectPhotoActivity.this).load(strReplace).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(SIRSelectPhotoActivity.this.binding.image);
                            }
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                                SIRSelectPhotoActivity.this.alertDialog.dismiss();
                            }
                            SIRSelectPhotoActivity.this.resetImage(uploadType, message);
                        }
                    });
                } else {
                    if (response.code() == 401) {
                        if (SIRSelectPhotoActivity.this.alertDialog != null) {
                            SIRSelectPhotoActivity.this.alertDialog.dismiss();
                        }
                        SIRSelectPhotoActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                        return;
                    }
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(SIRSelectPhotoActivity.this.messageString);
                        Logger.e("UncollectableTAG", strOptString);
                        SIRSelectPhotoActivity.this.retryAPI(fileref, uploadType, strOptString);
                    } catch (Exception e) {
                        Logger.e("UncollectableTAG", e.getMessage());
                        SIRSelectPhotoActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                SIRSelectPhotoActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase("DOB")) {
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
        if (uploadType.equalsIgnoreCase(this.photostr)) {
            int i2 = this.getImage2Count;
            if (i2 < 2) {
                this.getImage2Count = i2 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.getImage2Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.11
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    SIRSelectPhotoActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equalsIgnoreCase("DOB")) {
                            SIRSelectPhotoActivity.this.displayFile(filereference, uploadtype);
                        } else if (uploadtype.equalsIgnoreCase(SIRSelectPhotoActivity.this.photostr)) {
                            SIRSelectPhotoActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getPhotoDetails() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("CurrentRole", "blo");
        map.put("state", this.state);
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", this.epicId);
        map2.put("state", this.state);
        map2.put("epicNo", this.epicNo);
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getPhotoByEpic(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass12());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<SelectPhotoRoot> {
        AnonymousClass12() {
        }

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
        public void onResponse(Call<SelectPhotoRoot> call, Response<SelectPhotoRoot> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("UncollectableTAG", "GetDistrict1 errorResponse --> " + strOptString);
                    SIRSelectPhotoActivity.this.commomUtility.showMessageWithTitleOK(SIRSelectPhotoActivity.this, "Alert", strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$12$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    SIRSelectPhotoActivity.this.commomUtility.showMessageWithTitleOK(SIRSelectPhotoActivity.this, "alert", "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$12$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d("UncollectableTAG", "getDistrict1 exception --> " + e.getMessage());
                }
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (((SelectPhotoRoot) response.body()).getPayload() == null) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
            SelectPhotoPayload payload = ((SelectPhotoRoot) response.body()).getPayload();
            SIRSelectPhotoActivity.this.binding.electorNamePendingSir.setText(TextUtils.isEmpty(payload.getEpicName()) ? "" : payload.getEpicName());
            SIRSelectPhotoActivity.this.binding.epicPendingSir.setText(TextUtils.isEmpty(payload.getEpicNo()) ? "" : payload.getEpicNo());
            SIRSelectPhotoActivity.this.binding.serialNoPendingSir.setText(payload.getPartSerialNo() == 0 ? "" : String.valueOf(payload.getPartSerialNo()));
            SIRSelectPhotoActivity.this.binding.textAge.setText(payload.getCurrentAge() != 0 ? String.valueOf(payload.getCurrentAge()) : "");
            SIRSelectPhotoActivity.this.erollPhoto = payload.getErollPhoto();
            SIRSelectPhotoActivity.this.surveyPhoto = payload.getSurveyPhoto();
            SIRSelectPhotoActivity.this.setValue(payload.getErollPhoto(), payload.getSurveyPhoto());
            if (TextUtils.isEmpty(SIRSelectPhotoActivity.this.surveyPhoto)) {
                SIRSelectPhotoActivity.this.binding.cardPhoto2.setVisibility(4);
                SIRSelectPhotoActivity.this.binding.surveyText.setVisibility(4);
            }
        }

        public void onFailure(Call<SelectPhotoRoot> call, Throwable t) {
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$8(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$8(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    public Uri getSaveImagePath1(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.logTagBaseActivity, "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.logTagBaseActivity, "filesize " + this.filesize);
        Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$12(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$12(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(XmlValidationError.UNDEFINED);
                    httpsURLConnection2.setReadTimeout(20000);
                    httpsURLConnection2.setInstanceFollowRedirects(true);
                    httpsURLConnection2.setRequestMethod("GET");
                    httpsURLConnection2.setRequestProperty("Accept", "application/pdf,*/*;q=0.8");
                    httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
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
                    int contentLength = httpsURLConnection2.getContentLength();
                    if (contentLength == 0) {
                        throw new IOException("Content-Length is zero. The PDF appears empty.");
                    }
                    InputStream inputStream = httpsURLConnection2.getInputStream();
                    if (inputStream == null) {
                        throw new IOException("Empty response body.");
                    }
                    final File fileCreateTempFile = File.createTempFile("temp_pdf", ".pdf", getCacheDir());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                        try {
                            byte[] bArr = new byte[8192];
                            bufferedInputStream.mark(16);
                            byte[] bArr2 = new byte[8];
                            int i = bufferedInputStream.read(bArr2);
                            bufferedInputStream.reset();
                            if (i <= 0) {
                                throw new IOException("No data received; PDF appears empty.");
                            }
                            if (!new String(bArr2, 0, i, StandardCharsets.US_ASCII).startsWith("%PDF")) {
                                throw new IOException("Not a valid PDF (missing %PDF header).");
                            }
                            int i2 = 0;
                            while (true) {
                                int i3 = bufferedInputStream.read(bArr);
                                if (i3 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i3);
                                i2 += i3;
                            }
                            fileOutputStream.flush();
                            if (contentLength > 0 && i2 != contentLength) {
                                throw new IOException("Download truncated. Expected " + contentLength + " bytes, got " + i2 + ".");
                            }
                            if (fileCreateTempFile.length() == 0) {
                                throw new IOException("Downloaded file size is zero.");
                            }
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda11
                                @Override // java.lang.Runnable
                                public final void run() {
                                    downloadCallback.onSuccess(fileCreateTempFile);
                                }
                            });
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Exception e) {
                    e = e;
                    httpsURLConnection = httpsURLConnection2;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            SIRSelectPhotoActivity.DownloadCallback downloadCallback2 = downloadCallback;
                            Exception exc = e;
                            downloadCallback2.onError(exc.getMessage(), exc);
                        }
                    });
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void animateCardElevation(final CardView cardView, float fromDp, float toDp, long durationMs) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(dpToPx(cardView.getContext(), fromDp), dpToPx(cardView.getContext(), toDp));
        valueAnimatorOfFloat.setDuration(durationMs);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                cardView.setCardElevation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    float dpToPx(Context ctx, float dp) {
        return dp * ctx.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getImageinBase64(String imageURL, final String imagecategory) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        CommomUtility commomUtility = new CommomUtility();
        this.commonUtilClass = commomUtility;
        Call<JsonObject> file = commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFile("objectstorage", imageURL, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB");
        this.activeCall = file;
        file.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity.13
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    return;
                }
                try {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    String asString = ((JsonObject) response.body()).get("file").getAsString();
                    if (TextUtils.isEmpty(asString)) {
                        return;
                    }
                    byte[] bArrDecode = Base64.decode(asString, 0);
                    if (imagecategory.equalsIgnoreCase("eroll")) {
                        SIRSelectPhotoActivity.this.binding.ivMale.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                    } else if (imagecategory.equalsIgnoreCase("survey")) {
                        SIRSelectPhotoActivity.this.binding.ivPhoto2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                    }
                } catch (Exception unused) {
                    if (SIRSelectPhotoActivity.this.alertDialog != null) {
                        SIRSelectPhotoActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$16(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$16(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        ?? r4 = 0;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection2.setConnectTimeout(XmlValidationError.UNDEFINED);
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda18
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                SIRSelectPhotoActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
        if (length >= 3 && (head[0] & UByte.MAX_VALUE) == 255 && (head[1] & UByte.MAX_VALUE) == 216 && (head[2] & UByte.MAX_VALUE) == 255) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$17(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$17(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.verifyPayload.getEpicNo().replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.verifyPayload.getEpicNo().replaceAll("/", "_") + "_voter_photo";
            Intent intent2 = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent2.putExtra("camera_type_configuration", "back");
            intent2.putExtra("temp", this.temp);
            startActivityForResult(intent2, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = "tempTest_voter_photo";
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$18(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$18(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).cropSquare().compress(512).maxResultSize(1028, 1028).cameraOnly().start(100);
            return;
        }
        if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = null;
        if (resultCode == -1) {
            Uri data2 = requestCode != 10001 ? data.getData() : null;
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.pdfbyteArray = byteArray;
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp);
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery.moveToFirst();
                String[] strArrSplit = saveImagePath.getPath().split("/");
                String str = strArrSplit[strArrSplit.length - 1];
                cursorQuery.close();
                uri = data2;
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        } else if (requestCode == 0) {
            Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(data), 0).show();
        } else {
            Toast.makeText((Context) this, (CharSequence) "No Image selected", 0).show();
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
        if ((requestCode == 100 || requestCode == 10001) && resultCode == -1) {
            try {
                if (requestCode == 10001) {
                    startCrop(Uri.parse(data.getStringExtra("file_uri")));
                    return;
                }
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                this.byteArray = byteArray2;
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(byteArray2, 0), this.img, this.temp);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                if (cursorQuery2.getCount() <= 0) {
                    cursorQuery2.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery2.moveToFirst();
                String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                Log.e("extract", strArrSplit2[strArrSplit2.length - 1]);
                long j = this.filesize;
                if (j < 1024) {
                    if (this.faceRecognition) {
                        faceRecognition(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        uploadPhoto(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    }
                    this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - 1]);
                    if (this.filesize != 0) {
                        this.binding.photoSize.setText(this.filesize + "KB");
                        this.binding.photoSize.setVisibility(0);
                    } else {
                        this.binding.photoSize.setVisibility(8);
                    }
                } else {
                    long j2 = j / 1024;
                    this.filesize = j2;
                    double dRound = Math.round(j2 * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.binding.passPhotoLayout.setVisibility(8);
                        this.binding.chooseFileTv.setEnabled(true);
                        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        if (this.faceRecognition) {
                            faceRecognition(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                        } else {
                            this.alertDialog.dismiss();
                            uploadPhoto(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                        }
                        this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - 1]);
                        if (dRound != 0.0d) {
                            this.binding.photoSize.setText(dRound + "KB");
                            this.binding.photoSize.setVisibility(0);
                        } else {
                            this.binding.photoSize.setVisibility(8);
                        }
                    }
                    cursorQuery2.close();
                }
                cursorQuery2 = cursorQuery2;
                cursorQuery2.close();
            } catch (Exception e2) {
                Logger.d("tag", e2.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        Call<JsonObject> callFaceRecognitionApi = restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType")));
        this.alertDialog.show();
        callFaceRecognitionApi.enqueue(new AnonymousClass14(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass14(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                Context applicationContext = SIRSelectPhotoActivity.this.getApplicationContext();
                String str = SIRSelectPhotoActivity.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$14$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(SIRSelectPhotoActivity.this.photostr)) {
                    SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                    sIRSelectPhotoActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, sIRSelectPhotoActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                SIRSelectPhotoActivity.this.binding.passPhotoLayout.setVisibility(8);
                SIRSelectPhotoActivity.this.binding.passPhoto.setVisibility(0);
                SIRSelectPhotoActivity.this.binding.chooseFileTv.setEnabled(true);
                SIRSelectPhotoActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(SIRSelectPhotoActivity.this.whitecolor));
                new JSONObject(response.errorBody().string());
                SIRSelectPhotoActivity sIRSelectPhotoActivity2 = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity2.showDialog1(sIRSelectPhotoActivity2.alertText, SIRSelectPhotoActivity.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r2 = SIRSelectPhotoActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$14$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
                return;
            }
            SIRSelectPhotoActivity.this.alertDialog.dismiss();
            SIRSelectPhotoActivity.this.token = "Bearer " + str8;
            SIRSelectPhotoActivity.this.refreshToken = str9;
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
            sIRSelectPhotoActivity.faceRecognition(str, str2, str3, str4, str5, sIRSelectPhotoActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SIRSelectPhotoActivity.this.startActivity(new Intent(SIRSelectPhotoActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            SIRSelectPhotoActivity.this.binding.passPhotoLayout.setVisibility(8);
            SIRSelectPhotoActivity.this.binding.passPhotoLayout.setVisibility(8);
            SIRSelectPhotoActivity.this.binding.passPhoto.setVisibility(0);
            SIRSelectPhotoActivity.this.binding.chooseFileTv.setEnabled(true);
            SIRSelectPhotoActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(SIRSelectPhotoActivity.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
            sIRSelectPhotoActivity.showDialog1(sIRSelectPhotoActivity.alertText, t.getMessage());
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
        }
    }

    private void updatePhotoFlagInSurvey() {
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
        map2.put("epicId", this.verifyPayload.getEpicId());
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        map2.put("photoUrl", this.photoref);
        this.service.updatePhotoFlagInSurvey(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass15());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        AnonymousClass15() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity] */
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
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                ((JsonObject) response.body()).get("message").toString();
                SIRSelectPhotoActivity.this.submit();
                return;
            }
            if (response.code() == 401) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = SIRSelectPhotoActivity.this.commomUtility;
                ?? r5 = SIRSelectPhotoActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SIRSelectPhotoActivity$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                SIRSelectPhotoActivity sIRSelectPhotoActivity = SIRSelectPhotoActivity.this;
                sIRSelectPhotoActivity.showDialog1(sIRSelectPhotoActivity.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (SIRSelectPhotoActivity.this.alertDialog != null) {
                    SIRSelectPhotoActivity.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRSelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SIRSelectPhotoActivity.this.startActivity(new Intent(SIRSelectPhotoActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SIRSelectPhotoActivity.this.alertDialog != null) {
                SIRSelectPhotoActivity.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableTAG", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startCrop(Uri sourceUri) {
        this.uCropLauncher.launch(UCrop.of(sourceUri, ImageUriUtils.createCacheImageUri(this, "cropped_" + System.currentTimeMillis() + ".jpg")).withOptions(buildUCropOptions()).withAspectRatio(1.0f, 1.0f).withMaxResultSize(1024, 1024).getIntent(this));
    }

    private UCrop.Options buildUCropOptions() {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setCompressionQuality(95);
        return options;
    }

    private void onCropSuccess(Uri croppedImageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), croppedImageUri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.pdfbyteArray = byteArray;
            String[] strArrSplit = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp).getPath().split("/");
            String str = strArrSplit[strArrSplit.length - 1];
            long j = this.filesize;
            if (j < 1024) {
                if (this.faceRecognition) {
                    faceRecognition(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                } else {
                    this.alertDialog.dismiss();
                    uploadPhoto(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                }
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                if (this.filesize != 0) {
                    this.binding.photoSize.setText(this.filesize + "KB");
                    this.binding.photoSize.setVisibility(0);
                    return;
                } else {
                    this.binding.photoSize.setVisibility(8);
                    return;
                }
            }
            long j2 = j / 1024;
            this.filesize = j2;
            double dRound = Math.round(j2 * 100.0d) / 100.0d;
            if (dRound > 2.0d) {
                this.binding.passPhotoLayout.setVisibility(8);
                this.binding.chooseFileTv.setEnabled(true);
                this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                showDialog1(this.alertText, this.imgmsg);
                return;
            }
            if (this.faceRecognition) {
                faceRecognition(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
            } else {
                this.alertDialog.dismiss();
                uploadPhoto(this.state, this.asmblyNO, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
            }
            this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
            if (dRound != 0.0d) {
                this.binding.photoSize.setText(dRound + "KB");
                this.binding.photoSize.setVisibility(0);
            } else {
                this.binding.photoSize.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onCropError(Throwable t) {
        if (t != null) {
            t.printStackTrace();
        }
        Toast.makeText((Context) this, (CharSequence) ("Crop failed: " + (t != null ? t.getMessage() : "unknown")), 1).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onCropCancelled() {
        Toast.makeText((Context) this, (CharSequence) "Crop cancelled", 0).show();
    }
}
