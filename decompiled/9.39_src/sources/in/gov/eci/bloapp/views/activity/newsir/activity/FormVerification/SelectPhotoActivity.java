package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
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
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySelectPhotoSimpleBinding;
import in.gov.eci.bloapp.databinding.DialogSelectphotoAlertBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.SelectPhotoPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.SelectPhotoRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf;
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
import java.time.LocalDate;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SelectPhotoActivity extends SuperBaseActivity {
    private int acNo;
    private Call<JsonObject> activeCall;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivitySelectPhotoSimpleBinding binding;
    CommomUtility commonUtilClass;
    String currentDate;
    private float dpprivate;
    private Long epicId;
    protected long filesize;
    String flag;
    String from;
    String image2;
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
    SelectPhotoPayload selectPhotoPayload;
    UserClient service;
    private String state;
    String stateCode;
    String temp;
    private String token;
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
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String messageString = "message";
    File efImageFile = null;
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;
    String erollPhoto = "";
    String surveyPhoto = "";
    ActivityResultLauncher<Intent> activityResultLauncher3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.13
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            if (result.getResultCode() == -1) {
                Uri data = result.getData().getData();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    InputStream inputStreamOpenInputStream = SelectPhotoActivity.this.getApplicationContext().getContentResolver().openInputStream(data);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int i = inputStreamOpenInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStreamOpenInputStream != null) {
                                        try {
                                            inputStreamOpenInputStream.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                        } catch (Throwable th4) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            th = th4;
                        }
                    } catch (Exception e) {
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        Logger.d("", e.getMessage());
                        byteArrayOutputStream = byteArrayOutputStream2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                SelectPhotoActivity.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                try {
                    String strEncodeToString = Base64.encodeToString(SelectPhotoActivity.this.pdfbyteArray, 0);
                    SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                    Uri saveImagePath = selectPhotoActivity.getSaveImagePath(strEncodeToString, ".pdf", selectPhotoActivity.temp);
                    Cursor cursorQuery = SelectPhotoActivity.this.getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(SelectPhotoActivity.this.imgmsg);
                    }
                    cursorQuery.moveToFirst();
                    saveImagePath.getPath().split("/");
                    if (SelectPhotoActivity.this.filesize < 1024) {
                        Math.round(SelectPhotoActivity.this.filesize * 100.0d);
                        cursorQuery.close();
                        SelectPhotoActivity.this.alertDialog.show();
                        SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                        selectPhotoActivity2.uploadPhoto(selectPhotoActivity2.stateCode, SelectPhotoActivity.this.asmblyNO, String.valueOf(SelectPhotoActivity.this.partNo), SelectPhotoActivity.this.filepathimg, SelectPhotoActivity.this.saveImageFileName, SelectPhotoActivity.this.token, SelectPhotoActivity.this.referenceNo, "DOB");
                    } else {
                        double dRound = Math.round(((double) (SelectPhotoActivity.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                        cursorQuery.close();
                        if (dRound > 11.0d) {
                            SelectPhotoActivity selectPhotoActivity3 = SelectPhotoActivity.this;
                            selectPhotoActivity3.showdialog(selectPhotoActivity3.alert, SelectPhotoActivity.this.pdf3);
                        } else {
                            SelectPhotoActivity.this.alertDialog.show();
                            SelectPhotoActivity selectPhotoActivity4 = SelectPhotoActivity.this;
                            selectPhotoActivity4.uploadPhoto(selectPhotoActivity4.stateCode, SelectPhotoActivity.this.asmblyNO, String.valueOf(SelectPhotoActivity.this.partNo), SelectPhotoActivity.this.filepathimg, SelectPhotoActivity.this.saveImageFileName, SelectPhotoActivity.this.token, SelectPhotoActivity.this.referenceNo, "DOB");
                        }
                    }
                    cursorQuery.close();
                } catch (Exception e3) {
                    Logger.d("", e3.getMessage());
                }
            }
        }
    });

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivitySelectPhotoSimpleBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
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
        getPhotoDetails();
        this.binding.textView3.setText(getResources().getString(R.string.select_photo));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        animateCardElevation(this.binding.cardMale, 4.0f, 12.0f, 180L);
        animateCardElevation(this.binding.cardPhoto2, 12.0f, 4.0f, 180L);
        this.binding.cardMale.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto1.setChecked(true);
                SelectPhotoActivity.this.binding.btnOk.setText("Submit");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.animateCardElevation(selectPhotoActivity.binding.cardMale, 4.0f, 12.0f, 180L);
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.animateCardElevation(selectPhotoActivity2.binding.cardPhoto2, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.cardPhoto2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto2.setChecked(true);
                SelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                SelectPhotoActivity.this.binding.btnOk.setText("Fill Form 8");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.animateCardElevation(selectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.animateCardElevation(selectPhotoActivity2.binding.cardMale, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.rbPhoto1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto1.setChecked(true);
                SelectPhotoActivity.this.binding.btnOk.setText("Submit");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.animateCardElevation(selectPhotoActivity.binding.cardMale, 4.0f, 12.0f, 180L);
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.animateCardElevation(selectPhotoActivity2.binding.cardPhoto2, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.rbPhoto2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.binding.notOkPhoto.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto2.setChecked(true);
                SelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                SelectPhotoActivity.this.binding.btnOk.setText("Fill Form 8");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.animateCardElevation(selectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.animateCardElevation(selectPhotoActivity2.binding.cardMale, 12.0f, 4.0f, 180L);
            }
        });
        this.binding.btnOk.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.validate();
            }
        });
        this.binding.notOkPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.binding.notOkPhoto.setChecked(true);
                SelectPhotoActivity.this.binding.rbPhoto2.setChecked(false);
                SelectPhotoActivity.this.binding.rbPhoto1.setChecked(false);
                SelectPhotoActivity.this.binding.btnOk.setText("Fill Form 8");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.animateCardElevation(selectPhotoActivity.binding.cardPhoto2, 4.0f, 12.0f, 180L);
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.animateCardElevation(selectPhotoActivity2.binding.cardMale, 4.0f, 12.0f, 180L);
            }
        });
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
        if (this.binding.rbPhoto2.isChecked()) {
            if (TextUtils.isEmpty(this.surveyPhoto)) {
                fillForm8("N");
                return;
            } else {
                fillForm8("N");
                return;
            }
        }
        if (this.binding.notOkPhoto.isChecked()) {
            fillForm8("N");
        } else if (this.binding.rbPhoto1.isChecked()) {
            submit("E");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void fillForm8(String category) {
        String str;
        String str2;
        SelectPhotoPayload selectPhotoPayload = this.selectPhotoPayload;
        if (selectPhotoPayload != null) {
            if (TextUtils.isEmpty(selectPhotoPayload.getErollUpdateDate())) {
                str = "";
            } else {
                try {
                    str = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.getDefault()).format(LocalDate.parse(this.selectPhotoPayload.getErollUpdateDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault())));
                } catch (Exception unused) {
                    str = "";
                }
            }
            if (!TextUtils.isEmpty(this.selectPhotoPayload.getFormStatus()) && this.selectPhotoPayload.getFormStatus().equalsIgnoreCase("Y")) {
                str2 = "Form 8 is already in process.";
            } else {
                str2 = (TextUtils.isEmpty(this.selectPhotoPayload.getFormCurrentStatus()) || !(this.selectPhotoPayload.getFormCurrentStatus().equalsIgnoreCase("EROLL UPDATED") || this.selectPhotoPayload.getFormCurrentStatus().equalsIgnoreCase("EROLL_UPDATED"))) ? "" : "Eroll has been updated for Photo correction on " + str + ", Do you want to still fill the form 8?";
            }
            if (!TextUtils.isEmpty(str2)) {
                displayDialog(str2);
                new Utils();
                return;
            }
            Intent intent = new Intent((Context) this, (Class<?>) VoterForms.class);
            intent.putExtra("flag", "selectPhoto");
            intent.putExtra("category", "F");
            intent.putExtra("epic", this.verifyPayload.getEpicNo());
            intent.putExtra("epicId", this.verifyPayload.getEpicId());
            intent.putExtra("efbase64image", this.surveyPhoto);
            intent.putExtra("efPhoto", "");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit(String category) {
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
        map2.put("flag", category);
        this.state.toLowerCase();
        this.service.updatePhotoFlagInEnum1(map, map2).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity] */
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
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                SelectPhotoActivity.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 401) {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = SelectPhotoActivity.this.commomUtility;
                ?? r5 = SelectPhotoActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.showDialog1(selectPhotoActivity.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SelectPhotoActivity.this.startActivity(new Intent(SelectPhotoActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SelectPhotoActivity.this.alertDialog != null) {
                SelectPhotoActivity.this.alertDialog.dismiss();
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda3
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda12
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
        Intent intent = new Intent((Context) this, (Class<?>) NonSirSelectPhotoListActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda0
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

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, final String listCode) {
        final String str = this.state + this.acNo + this.partNo;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$3(charSequenceArr, str, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$3(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
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
            map2.put("epicNo", this.temp);
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$8, reason: invalid class name */
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
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity] */
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
                CommomUtility commomUtility = SelectPhotoActivity.this.commomUtility;
                ?? r13 = SelectPhotoActivity.this;
                String str = ((SelectPhotoActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$8$$ExternalSyntheticLambda1
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
                        SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                        selectPhotoActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, selectPhotoActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = SelectPhotoActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                        SelectPhotoActivity.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        SelectPhotoActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, SelectPhotoActivity.this.relativeDocument1UrlS);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    Logger.d("UncollectableTAG", strValueOf);
                    return;
                } catch (Exception e) {
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    SelectPhotoActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                SelectPhotoActivity.this.photo1countNew = 0;
            }
            SelectPhotoActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.showDialog1(selectPhotoActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity] */
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
                CommomUtility commomUtility = SelectPhotoActivity.this.commomUtility;
                ?? r2 = SelectPhotoActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SelectPhotoActivity.this.token = "Bearer " + str8;
            SelectPhotoActivity.this.refreshToken = str9;
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
            selectPhotoActivity.uploadPhoto(str, str2, str3, str4, str5, selectPhotoActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SelectPhotoActivity.this.startActivity(new Intent((Context) SelectPhotoActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (SelectPhotoActivity.this.photo1countNew < 2 && TextUtils.isEmpty(SelectPhotoActivity.this.relativeDocument1UrlS)) {
                    SelectPhotoActivity.this.photo1countNew++;
                    SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                    selectPhotoActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, selectPhotoActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                SelectPhotoActivity.this.photo1countNew = 0;
                SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
                selectPhotoActivity2.showDialog1(selectPhotoActivity2.alertText, SelectPhotoActivity.this.fileNotFoundMessage);
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
            getImageinBase64(image2, "survey");
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity] */
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
                SelectPhotoActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
                SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                selectPhotoActivity.checkImageFromURL(selectPhotoActivity.preSignedurl1, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.9.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.DownloadCallback
                    public void onError(String message, Throwable cause) {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.DownloadCallback
                    public void onSuccess(File pdfFile) {
                        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(SelectPhotoActivity.this);
                        circularProgressDrawable.setStrokeWidth(6.0f);
                        circularProgressDrawable.setCenterRadius(24.0f);
                        circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(SelectPhotoActivity.this, R.color.blo_blue)});
                        circularProgressDrawable.start();
                        SelectPhotoActivity.this.efImageFile = pdfFile;
                        Glide.with(SelectPhotoActivity.this).load(SelectPhotoActivity.this.preSignedurl1).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(SelectPhotoActivity.this.binding.ivPhoto2);
                    }
                });
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = SelectPhotoActivity.this.commomUtility;
                    ?? r6 = SelectPhotoActivity.this;
                    String str = ((SelectPhotoActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$9$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", SelectPhotoActivity.this.comingTag);
                }
            } else {
                try {
                    SelectPhotoActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$9$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(SelectPhotoActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    SelectPhotoActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            SelectPhotoActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity] */
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
            SelectPhotoActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = SelectPhotoActivity.this.commomUtility;
                ?? r5 = SelectPhotoActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$9$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                SelectPhotoActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                SelectPhotoActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SelectPhotoActivity.this.getApplicationContext()).setLocaleBool(false);
            SelectPhotoActivity.this.startActivity(new Intent((Context) SelectPhotoActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (SelectPhotoActivity.this.alertDialog != null) {
                SelectPhotoActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", SelectPhotoActivity.this.comingTag + t.getMessage());
            if (SelectPhotoActivity.this.alertDialog != null) {
                SelectPhotoActivity.this.alertDialog.dismiss();
            }
            SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
            selectPhotoActivity.showDialog1(selectPhotoActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda5
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
                this.binding.notOkPhoto.setVisibility(8);
                this.binding.surveyText.setText("Upload new photo and fill form 8");
            }
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("preSignedurl1", strReplace);
                    SelectPhotoActivity.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.10.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (SelectPhotoActivity.this.alertDialog != null) {
                                SelectPhotoActivity.this.alertDialog.dismiss();
                            }
                            SelectPhotoActivity.this.file1 = pdfFile;
                            Log.e("GETFILE", "FILE1::" + SelectPhotoActivity.this.file1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (SelectPhotoActivity.this.alertDialog != null) {
                                SelectPhotoActivity.this.alertDialog.dismiss();
                            }
                            SelectPhotoActivity.this.resetImage(uploadType, message);
                        }
                    });
                } else {
                    if (response.code() == 401) {
                        if (SelectPhotoActivity.this.alertDialog != null) {
                            SelectPhotoActivity.this.alertDialog.dismiss();
                        }
                        SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
                        selectPhotoActivity.showDialog1(selectPhotoActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
                        return;
                    }
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(SelectPhotoActivity.this.messageString);
                        Logger.e("UncollectableTAG", strOptString);
                        SelectPhotoActivity.this.retryAPI(fileref, uploadType, strOptString);
                    } catch (Exception e) {
                        Logger.e("UncollectableTAG", e.getMessage());
                        SelectPhotoActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                SelectPhotoActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase("DOB")) {
            int i = this.getImage1Count;
            if (i < 2) {
                this.getImage1Count = i + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.getImage1Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCallerNewPdf().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.11
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    SelectPhotoActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equalsIgnoreCase("DOB")) {
                            SelectPhotoActivity.this.displayFile(filereference, uploadtype);
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
        this.state.toLowerCase();
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getPhotoByEpic1(map, map2).enqueue(new AnonymousClass12());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$12, reason: invalid class name */
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
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("UncollectableTAG", "GetDistrict1 errorResponse --> " + strOptString);
                    SelectPhotoActivity.this.commomUtility.showMessageWithTitleOK(SelectPhotoActivity.this, "Alert", strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$12$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    SelectPhotoActivity.this.commomUtility.showMessageWithTitleOK(SelectPhotoActivity.this, "alert", "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$12$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d("UncollectableTAG", "getDistrict1 exception --> " + e.getMessage());
                }
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (((SelectPhotoRoot) response.body()).getPayload() == null) {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (SelectPhotoActivity.this.alertDialog != null) {
                SelectPhotoActivity.this.alertDialog.dismiss();
            }
            SelectPhotoActivity.this.selectPhotoPayload = ((SelectPhotoRoot) response.body()).getPayload();
            SelectPhotoActivity.this.binding.electorNamePendingSir.setText(TextUtils.isEmpty(SelectPhotoActivity.this.selectPhotoPayload.getEpicName()) ? "" : SelectPhotoActivity.this.selectPhotoPayload.getEpicName());
            SelectPhotoActivity.this.binding.epicPendingSir.setText(TextUtils.isEmpty(SelectPhotoActivity.this.selectPhotoPayload.getEpicNo()) ? "" : SelectPhotoActivity.this.selectPhotoPayload.getEpicNo());
            SelectPhotoActivity.this.binding.serialNoPendingSir.setText(SelectPhotoActivity.this.selectPhotoPayload.getPartSerialNo() == 0 ? "" : String.valueOf(SelectPhotoActivity.this.selectPhotoPayload.getPartSerialNo()));
            SelectPhotoActivity.this.binding.textAge.setText(SelectPhotoActivity.this.selectPhotoPayload.getCurrentAge() == 0 ? "" : String.valueOf(SelectPhotoActivity.this.selectPhotoPayload.getCurrentAge()));
            SelectPhotoActivity selectPhotoActivity = SelectPhotoActivity.this;
            selectPhotoActivity.erollPhoto = selectPhotoActivity.selectPhotoPayload.getErollPhoto();
            SelectPhotoActivity selectPhotoActivity2 = SelectPhotoActivity.this;
            selectPhotoActivity2.surveyPhoto = selectPhotoActivity2.selectPhotoPayload.getSurveyPhoto();
            if (TextUtils.isEmpty(SelectPhotoActivity.this.selectPhotoPayload.getFormStatus()) || !SelectPhotoActivity.this.selectPhotoPayload.getFormStatus().equalsIgnoreCase("Y")) {
                if (!TextUtils.isEmpty(SelectPhotoActivity.this.surveyPhoto)) {
                    SelectPhotoActivity.this.surveyPhoto = "";
                }
                SelectPhotoActivity.this.binding.notOkPhoto.setVisibility(8);
                SelectPhotoActivity.this.binding.surveyText.setText("Upload new photo and fill form 8");
                SelectPhotoActivity.this.binding.tvFormstatus.setVisibility(8);
                SelectPhotoActivity.this.binding.lvSubmissionDate.setVisibility(8);
                SelectPhotoActivity.this.binding.lvStatus.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(SelectPhotoActivity.this.surveyPhoto)) {
                    SelectPhotoActivity.this.binding.notOkPhoto.setVisibility(8);
                    SelectPhotoActivity.this.binding.surveyText.setText("Upload new photo and fill form 8");
                } else {
                    SelectPhotoActivity.this.binding.surveyText.setText("Please collect FORM 8 for Photo correction and submit the Form in next Revision.");
                }
                SelectPhotoActivity.this.binding.tvFormstatus.setVisibility(0);
                SelectPhotoActivity.this.binding.tvFormstatus.setText("Note : Please collect FORM 8 for Photo correction and submit the Form in next Revision.");
                if (!TextUtils.isEmpty(SelectPhotoActivity.this.selectPhotoPayload.getFormSubmissionDate())) {
                    SelectPhotoActivity.this.binding.lvSubmissionDate.setVisibility(0);
                    try {
                        SelectPhotoActivity.this.binding.tvSubmissionDate.setText(DateTimeFormatter.ofPattern("dd/MM/yy", Locale.getDefault()).format(LocalDate.parse(SelectPhotoActivity.this.selectPhotoPayload.getFormSubmissionDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault()))));
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(SelectPhotoActivity.this.selectPhotoPayload.getFormCurrentStatus())) {
                    SelectPhotoActivity.this.binding.lvStatus.setVisibility(0);
                    SelectPhotoActivity.this.binding.status.setText(SelectPhotoActivity.this.selectPhotoPayload.getFormCurrentStatus());
                }
            }
            SelectPhotoActivity selectPhotoActivity3 = SelectPhotoActivity.this;
            selectPhotoActivity3.setValue(selectPhotoActivity3.selectPhotoPayload.getErollPhoto(), SelectPhotoActivity.this.surveyPhoto);
        }

        public void onFailure(Call<SelectPhotoRoot> call, Throwable t) {
            if (SelectPhotoActivity.this.alertDialog != null) {
                SelectPhotoActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void selectPDF() {
        final CharSequence[] charSequenceArr = {this.choosepdf, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.addPdf);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectPDF$5(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectPDF$5(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choosepdf)) {
            openfile3();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public void openfile3() {
        String[] strArr = {this.applicationpdf};
        this.temp = (this.state + this.acNo + this.partNo) + "pdf1";
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        this.activityResultLauncher3.launch(Intent.createChooser(intent, this.chooseFile));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$6(DialogInterface dialogInterface, int i) {
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$10(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$10(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(10000);
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda6
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            SelectPhotoActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda13
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
        file.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.14
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    return;
                }
                try {
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                    }
                    String asString = ((JsonObject) response.body()).get("file").getAsString();
                    if (TextUtils.isEmpty(asString)) {
                        return;
                    }
                    byte[] bArrDecode = Base64.decode(asString, 0);
                    if (imagecategory.equalsIgnoreCase("eroll")) {
                        SelectPhotoActivity.this.binding.ivMale.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                    } else if (imagecategory.equalsIgnoreCase("survey")) {
                        SelectPhotoActivity.this.binding.ivPhoto2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                    }
                } catch (Exception unused) {
                    if (SelectPhotoActivity.this.alertDialog != null) {
                        SelectPhotoActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (SelectPhotoActivity.this.alertDialog != null) {
                    SelectPhotoActivity.this.alertDialog.dismiss();
                }
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$14(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$checkImageFromURL$14(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection3.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection3.setConnectTimeout(10000);
                        httpsURLConnection3.setReadTimeout(20000);
                        httpsURLConnection3.setInstanceFollowRedirects(true);
                        httpsURLConnection3.setRequestMethod("GET");
                        httpsURLConnection3.setUseCaches(false);
                        httpsURLConnection3.setRequestProperty("Accept", "image/*,*/*;q=0.8");
                        httpsURLConnection3.connect();
                        int responseCode = httpsURLConnection3.getResponseCode();
                        if (responseCode != 200) {
                            if (responseCode != 403) {
                                str2 = responseCode != 404 ? "Server returned HTTP " + responseCode : "File not found (HTTP 404). The object may have been deleted or the URL is incorrect.";
                            } else {
                                str2 = "Link expired or invalid (HTTP 403). Please request a new presigned URL.";
                            }
                            throw new IOException(str2);
                        }
                        String contentType = httpsURLConnection3.getContentType();
                        String lowerCase = contentType == null ? "" : contentType.toLowerCase(Locale.US);
                        lowerCase.startsWith("image/");
                        if (httpsURLConnection3.getContentLength() == 0) {
                            throw new IOException("Content-Length is zero; image appears empty.");
                        }
                        final File fileCreateTempFile = File.createTempFile(this.verifyPayload.getEpicNo().replaceAll("/", "_") + "img", ".jpeg", getCacheDir());
                        InputStream inputStream = httpsURLConnection3.getInputStream();
                        if (inputStream == null) {
                            throw new IOException("Empty response body.");
                        }
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                            try {
                                byte[] bArr = new byte[8192];
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
                                while (true) {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                bufferedInputStream.close();
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda10
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        downloadCallback.onSuccess(fileCreateTempFile);
                                    }
                                });
                                httpsURLConnection = lowerCase;
                                if (httpsURLConnection3 != null) {
                                    httpsURLConnection3.disconnect();
                                    httpsURLConnection = lowerCase;
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
                        httpsURLConnection2 = httpsURLConnection3;
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity$$ExternalSyntheticLambda11
                            @Override // java.lang.Runnable
                            public final void run() {
                                SelectPhotoActivity.DownloadCallback downloadCallback2 = downloadCallback;
                                Exception exc = e;
                                downloadCallback2.onError(exc.getMessage(), exc);
                            }
                        });
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                            httpsURLConnection = httpsURLConnection2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpsURLConnection = httpsURLConnection3;
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
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

    /* JADX WARN: Multi-variable type inference failed */
    private void displayDialog(String message) {
        final Dialog dialog = new Dialog(this);
        DialogSelectphotoAlertBinding dialogSelectphotoAlertBindingInflate = DialogSelectphotoAlertBinding.inflate(getLayoutInflater());
        dialog.setContentView(dialogSelectphotoAlertBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        dialogSelectphotoAlertBindingInflate.tvWrongCate.setText(message);
        if (!TextUtils.isEmpty(this.selectPhotoPayload.getFormStatus()) && this.selectPhotoPayload.getFormStatus().equalsIgnoreCase("Y")) {
            dialogSelectphotoAlertBindingInflate.fillYes.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.selectPhotoPayload.getFormCurrentStatus()) && (this.selectPhotoPayload.getFormCurrentStatus().equalsIgnoreCase("EROLL UPDATED") || this.selectPhotoPayload.getFormCurrentStatus().equalsIgnoreCase("EROLL_UPDATED"))) {
            dialogSelectphotoAlertBindingInflate.fillYes.setVisibility(0);
        }
        dialogSelectphotoAlertBindingInflate.fillYes.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent((Context) SelectPhotoActivity.this, (Class<?>) VoterForms.class);
                intent.putExtra("flag", "selectPhoto");
                intent.putExtra("category", "F");
                intent.putExtra("epic", SelectPhotoActivity.this.verifyPayload.getEpicNo());
                intent.putExtra("epicId", SelectPhotoActivity.this.verifyPayload.getEpicId());
                intent.putExtra("efbase64image", SelectPhotoActivity.this.surveyPhoto);
                intent.putExtra("efPhoto", "");
                SelectPhotoActivity.this.startActivity(intent);
                dialog.dismiss();
            }
        });
        dialogSelectphotoAlertBindingInflate.tvNoAction.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SelectPhotoActivity.this.submit("N");
                dialog.dismiss();
            }
        });
        dialogSelectphotoAlertBindingInflate.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
