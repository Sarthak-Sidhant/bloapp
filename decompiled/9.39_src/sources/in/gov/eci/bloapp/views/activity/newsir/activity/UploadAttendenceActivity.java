package in.gov.eci.bloapp.views.activity.newsir.activity;

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
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
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
import in.gov.eci.bloapp.databinding.ActivityUploadAttendenceBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DocumentPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
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
public class UploadAttendenceActivity extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityUploadAttendenceBinding binding;
    String currentDate;
    private Long epicId;
    protected long filesize;
    String mime;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private byte[] pdfbyteArray;
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
    String photo3strNew = "SupportingDocumentPage1";
    String uploadGroupPhotoUrl = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    String uploadAttendenceUrl = "";
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String blackColor = "#000000";
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
    int doc3page1count = 0;
    int doc3page2count = 0;
    int doc4page1count = 0;
    int doc4page2count = 0;
    ArrayList<String> docnameList = new ArrayList<>();
    ArrayList<Integer> docCodeist = new ArrayList<>();
    ArrayList<DocumentPayload> documenttypeList = new ArrayList<>();
    boolean isUserSelected = false;

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityUploadAttendenceBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
            this.binding.electorNamePendingSir.setText(TextUtils.isEmpty(this.verifyPayload.getEpicName()) ? "" : this.verifyPayload.getEpicName());
            this.binding.epicPendingSir.setText(TextUtils.isEmpty(this.verifyPayload.getEpicNo()) ? "" : this.verifyPayload.getEpicNo());
            this.binding.serialNoPendingSir.setText(this.verifyPayload.getPartSerialNo() != 0 ? String.valueOf(this.verifyPayload.getPartSerialNo()) : "");
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
        this.binding.textView3.setText(getResources().getString(R.string.upload_attendence));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.textView3.setTextSize(15.0f);
        handleClick();
    }

    private void handleClick() {
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadAttendenceActivity.this.pickPhoto(101, "enFormPage1");
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadAttendenceActivity.this.pickPhoto(103, "sDPage1");
            }
        });
        this.binding.submitDocument.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(UploadAttendenceActivity.this.uploadGroupPhotoUrl)) {
                    UploadAttendenceActivity.this.showDialog1("Alert", "Please upload group photo for hearing");
                } else if (TextUtils.isEmpty(UploadAttendenceActivity.this.uploadAttendenceUrl)) {
                    UploadAttendenceActivity.this.showDialog1("Alert", "Please upload attendance sheet for hearing");
                } else {
                    UploadAttendenceActivity.this.submitNew();
                }
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$0(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$0(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$1(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNew() {
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
        map2.put("epicId", this.verifyPayload.getEpicId());
        map2.put("state", this.state);
        map2.put("hearingPhoto", this.uploadGroupPhotoUrl);
        map2.put("attendenceSheet", this.uploadAttendenceUrl);
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        Call<AsdActionrRoot> callUpdateAttendenceByEpicID = this.service.updateAttendenceByEpicID(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        callUpdateAttendenceByEpicID.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
            public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = UploadAttendenceActivity.this.utils;
                        ?? r0 = UploadAttendenceActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.4.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                Intent intent = new Intent((Context) UploadAttendenceActivity.this, (Class<?>) UploadAttendenceListActivity.class);
                                intent.setFlags(67108864);
                                UploadAttendenceActivity.this.startActivity(intent);
                                UploadAttendenceActivity.this.finish();
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (UploadAttendenceActivity.this.alertDialog != null) {
                            UploadAttendenceActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    UploadAttendenceActivity.this.showDialog1("Alert", strOptString);
                    Logger.e("UncollectableTAG", strOptString);
                } catch (IOException | JSONException e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$3(View view) {
        finish();
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
            } else if (requestCode == 103) {
                long j3 = this.filesize;
                if (j3 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                    this.binding.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j3 > 2048) {
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
                    long j4 = j3 / 1024;
                    this.filesize = j4;
                    double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                    if (dRound2 > 2.0d) {
                        this.binding.supportingDocumentsPage1.setVisibility(8);
                        this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                        this.binding.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
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
        final String strReplaceAll = this.verifyPayload.getEpicNo().replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$4(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$4(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
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
            this.uploadGroupPhotoUrl = null;
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
            this.binding.enumerationFormPage1Image.setVisibility(8);
            this.binding.enumerationFormPage1.setVisibility(8);
            this.binding.enumerationFormPage1ImageSize.setText("");
            this.binding.enumerationFormPage1ImageName.setText("");
            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
            return;
        }
        if (code == 103) {
            this.uploadAttendenceUrl = null;
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.supportingDocumentsPage1Image.setVisibility(8);
            this.binding.supportingDocumentsPage1.setVisibility(8);
            this.binding.supportingDocumentsPage1ImageName.setText("");
            this.binding.supportingDocumentsPage1ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
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
            map2.put("epicNo", this.verifyPayload.getEpicNo());
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d("UncollectableTAG", map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass5(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass5(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r13 = UploadAttendenceActivity.this;
                String str = ((UploadAttendenceActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$5$$ExternalSyntheticLambda1
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
                        UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
                        uploadAttendenceActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadAttendenceActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UploadAttendenceActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo1strNew)) {
                        UploadAttendenceActivity.this.uploadGroupPhotoUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadAttendenceActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadAttendenceActivity.this.uploadGroupPhotoUrl);
                    }
                    if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo3strNew)) {
                        UploadAttendenceActivity.this.uploadAttendenceUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadAttendenceActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadAttendenceActivity.this.uploadAttendenceUrl);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    UploadAttendenceActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo1strNew)) {
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.photo1countNew = 0;
                UploadAttendenceActivity.this.binding.enumerationFormPage1.setVisibility(8);
                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.whitecolor));
                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo3strNew)) {
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.photo3countNew = 0;
                UploadAttendenceActivity.this.binding.supportingDocumentsPage1.setVisibility(8);
                UploadAttendenceActivity.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.whitecolor));
                UploadAttendenceActivity.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            UploadAttendenceActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                UploadAttendenceActivity uploadAttendenceActivity2 = UploadAttendenceActivity.this;
                uploadAttendenceActivity2.showDialog1(uploadAttendenceActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r2 = UploadAttendenceActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UploadAttendenceActivity.this.token = "Bearer " + str8;
            UploadAttendenceActivity.this.refreshToken = str9;
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
            uploadAttendenceActivity.uploadPhoto(str, str2, str3, str4, str5, uploadAttendenceActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadAttendenceActivity.this.startActivity(new Intent((Context) UploadAttendenceActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo1strNew)) {
                if (UploadAttendenceActivity.this.photo1countNew < 2 && TextUtils.isEmpty(UploadAttendenceActivity.this.uploadGroupPhotoUrl)) {
                    UploadAttendenceActivity.this.photo1countNew++;
                    UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
                    uploadAttendenceActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadAttendenceActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    UploadAttendenceActivity.this.photo1countNew = 0;
                    UploadAttendenceActivity.this.binding.enumerationFormPage1.setVisibility(8);
                    UploadAttendenceActivity uploadAttendenceActivity2 = UploadAttendenceActivity.this;
                    uploadAttendenceActivity2.showDialog1(uploadAttendenceActivity2.alertText, UploadAttendenceActivity.this.fileNotFoundMessage);
                    UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.whitecolor));
                    UploadAttendenceActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UploadAttendenceActivity.this.photo3strNew)) {
                if (UploadAttendenceActivity.this.photo3countNew < 2 && TextUtils.isEmpty(UploadAttendenceActivity.this.uploadAttendenceUrl)) {
                    UploadAttendenceActivity.this.photo3countNew++;
                    UploadAttendenceActivity uploadAttendenceActivity3 = UploadAttendenceActivity.this;
                    uploadAttendenceActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadAttendenceActivity3.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.photo3countNew = 0;
                UploadAttendenceActivity.this.binding.supportingDocumentsPage1.setVisibility(8);
                UploadAttendenceActivity uploadAttendenceActivity4 = UploadAttendenceActivity.this;
                uploadAttendenceActivity4.showDialog1(uploadAttendenceActivity4.alertText, UploadAttendenceActivity.this.fileNotFoundMessage);
                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.whitecolor));
                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadAttendenceActivity.this).load(UploadAttendenceActivity.this.preSignedurl1).into(UploadAttendenceActivity.this.binding.frontImage);
                }
                if (TextUtils.isEmpty(UploadAttendenceActivity.this.preSignedurl1)) {
                    UploadAttendenceActivity.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(UploadAttendenceActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                    ?? r6 = UploadAttendenceActivity.this;
                    String str = ((UploadAttendenceActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$6$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag);
                }
            } else {
                try {
                    UploadAttendenceActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$6$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadAttendenceActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadAttendenceActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
            UploadAttendenceActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r5 = UploadAttendenceActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadAttendenceActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadAttendenceActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadAttendenceActivity.this.startActivity(new Intent((Context) UploadAttendenceActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag + t.getMessage());
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
            UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
            uploadAttendenceActivity.showDialog1(uploadAttendenceActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass7(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass7(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadAttendenceActivity.this).load(UploadAttendenceActivity.this.preSignedurl2).into(UploadAttendenceActivity.this.binding.backImage);
                }
                if (TextUtils.isEmpty(UploadAttendenceActivity.this.preSignedurl2)) {
                    UploadAttendenceActivity.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(UploadAttendenceActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                    ?? r6 = UploadAttendenceActivity.this;
                    String str = ((UploadAttendenceActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$7$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag);
                }
            } else {
                try {
                    UploadAttendenceActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$7$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadAttendenceActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadAttendenceActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
            UploadAttendenceActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r5 = UploadAttendenceActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadAttendenceActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadAttendenceActivity.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadAttendenceActivity.this.startActivity(new Intent((Context) UploadAttendenceActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag + t.getMessage());
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
            UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
            uploadAttendenceActivity.showDialog1(uploadAttendenceActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass8(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass8(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadAttendenceActivity.this).load(UploadAttendenceActivity.this.preSignedurl3).into(UploadAttendenceActivity.this.binding.frontImage1);
                }
                if (TextUtils.isEmpty(UploadAttendenceActivity.this.preSignedurl3)) {
                    UploadAttendenceActivity.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(UploadAttendenceActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                    ?? r6 = UploadAttendenceActivity.this;
                    String str = ((UploadAttendenceActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$8$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag);
                }
            } else {
                try {
                    UploadAttendenceActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$8$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadAttendenceActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadAttendenceActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
            UploadAttendenceActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r5 = UploadAttendenceActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$8$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadAttendenceActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadAttendenceActivity.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadAttendenceActivity.this.startActivity(new Intent((Context) UploadAttendenceActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag + t.getMessage());
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
            UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
            uploadAttendenceActivity.showDialog1(uploadAttendenceActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
                if (UploadAttendenceActivity.this.alertDialog != null) {
                    UploadAttendenceActivity.this.alertDialog.dismiss();
                }
                UploadAttendenceActivity.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadAttendenceActivity.this).load(UploadAttendenceActivity.this.preSignedurl4).into(UploadAttendenceActivity.this.binding.backImage1);
                }
                if (TextUtils.isEmpty(UploadAttendenceActivity.this.preSignedurl4)) {
                    UploadAttendenceActivity.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(UploadAttendenceActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                    ?? r6 = UploadAttendenceActivity.this;
                    String str = ((UploadAttendenceActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$9$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag);
                }
            } else {
                try {
                    UploadAttendenceActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$9$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadAttendenceActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadAttendenceActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
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
            UploadAttendenceActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadAttendenceActivity.this.commomUtility;
                ?? r5 = UploadAttendenceActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$9$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadAttendenceActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadAttendenceActivity.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadAttendenceActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadAttendenceActivity.this.startActivity(new Intent((Context) UploadAttendenceActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadAttendenceActivity.this.comingTag + t.getMessage());
            if (UploadAttendenceActivity.this.alertDialog != null) {
                UploadAttendenceActivity.this.alertDialog.dismiss();
            }
            UploadAttendenceActivity uploadAttendenceActivity = UploadAttendenceActivity.this;
            uploadAttendenceActivity.showDialog1(uploadAttendenceActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void resetImage(String imageType, String error) {
        if (imageType.equals(this.photo1strNew)) {
            this.uploadGroupPhotoUrl = "";
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.enumerationFormPage1.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
        }
        if (imageType.equals(this.photo3strNew)) {
            this.uploadAttendenceUrl = "";
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.supportingDocumentsPage1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(UploadAttendenceActivity.this.photo1strNew)) {
                        UploadAttendenceActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.10.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadAttendenceActivity.this.alertDialog != null) {
                                    UploadAttendenceActivity.this.alertDialog.dismiss();
                                }
                                UploadAttendenceActivity.this.binding.enumerationFormPage1.setVisibility(0);
                                UploadAttendenceActivity.this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                UploadAttendenceActivity.this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                UploadAttendenceActivity.this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                UploadAttendenceActivity.this.binding.enumerationFormPage1Image.setVisibility(0);
                                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.greycolor));
                                UploadAttendenceActivity.this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                Glide.with(UploadAttendenceActivity.this).load(strReplace).into(UploadAttendenceActivity.this.binding.enumerationFormPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadAttendenceActivity.this.alertDialog != null) {
                                    UploadAttendenceActivity.this.alertDialog.dismiss();
                                }
                                UploadAttendenceActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadAttendenceActivity.this.photo3strNew)) {
                        UploadAttendenceActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.10.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadAttendenceActivity.this.alertDialog != null) {
                                    UploadAttendenceActivity.this.alertDialog.dismiss();
                                }
                                UploadAttendenceActivity.this.binding.supportingDocumentsPage1.setVisibility(0);
                                UploadAttendenceActivity.this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadAttendenceActivity.this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                UploadAttendenceActivity.this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                UploadAttendenceActivity.this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                UploadAttendenceActivity.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadAttendenceActivity.this.greycolor));
                                UploadAttendenceActivity.this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(UploadAttendenceActivity.this).load(strReplace).into(UploadAttendenceActivity.this.binding.supportingDocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadAttendenceActivity.this.alertDialog != null) {
                                    UploadAttendenceActivity.this.alertDialog.dismiss();
                                }
                                UploadAttendenceActivity.this.resetImage(uploadType, message);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    UploadAttendenceActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(UploadAttendenceActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    UploadAttendenceActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e("UncollectableTAG", e.getMessage());
                    UploadAttendenceActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                UploadAttendenceActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
        if (uploadType.equalsIgnoreCase(this.photo3strNew)) {
            int i2 = this.getImage3Count;
            if (i2 < 2) {
                this.getImage3Count = i2 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.getImage3Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.11
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (UploadAttendenceActivity.this.alertDialog != null) {
                        UploadAttendenceActivity.this.alertDialog.dismiss();
                    }
                    UploadAttendenceActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(UploadAttendenceActivity.this.photo1strNew)) {
                            UploadAttendenceActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadAttendenceActivity.this.photo3strNew)) {
                            UploadAttendenceActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$7(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$7(String str, final DownloadCallback downloadCallback) throws Throwable {
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda0
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                UploadAttendenceActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
