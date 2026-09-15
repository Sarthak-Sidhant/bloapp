package in.gov.eci.bloapp.views.activity.sir.formdatanew;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityNoticeReceiptUploadBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ActivityNoticeUploadReceipt extends SuperBaseActivity {
    private static final String ALERT = "Alert";
    String SESSION;
    int acNo;
    AlertDialog alertDialog;
    String asmblyNo;
    String atkband;
    ActivityNoticeReceiptUploadBinding binding;
    String bloNoticeDelivered;
    String bloNoticeDeliveredReceipDoc;
    byte[] byteArray;
    String complaintId;
    String epicNo;
    Long epicid;
    File file1;
    File file2;
    protected long filesize;
    String mime;
    String noticeGeneratedDoc;
    int partNo;
    String partSerialNo;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
    private String preSignedurl1;
    String refreshToken;
    String relationcode;
    String rtkband;
    protected String saveImageFileName;
    String selectRelationType;
    UserClient service;
    String state;
    String temp;
    String token;
    Utils utils;
    String cancel = "Cancel";
    String takephoto = "Capture Photo";
    String pdf3 = "PDF size exceeded 3MB limit.";
    String functionNameForLogBaseActivity = "";
    String imgmsg = "";
    String TAG = "ActivityUploadReceipt";
    String alertText = "";
    String img = "image";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String chooseFile = "Choose File";
    String applicationpdf = "application/pdf";
    CommomUtility commomUtility = new CommomUtility();
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    HashMap<String, Object> json = new HashMap<>();
    String refid = null;
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    int photocount = 0;
    ActivityResultLauncher<Intent> activityResultLauncher16 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.5
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                ActivityNoticeUploadReceipt.this.HandlePdfFile(result.getData(), "UploadReceipt", 101);
            }
        }
    });
    boolean faceRecognition = true;
    String photostr = "Photo";
    String receipt = null;
    String generatedNotice = null;
    String electorref = null;
    String greycolor = "#99000000";
    String objectStorageString = "objectstorage";
    String imageUrl = "";
    int getImage1Count = 0;
    int getImage2Count = 0;
    String choose_front_camera = "";
    String choose_back_camera = "";
    String whitecolor = "#000000";
    Gson gson = new GsonBuilder().setLenient().create();

    public interface DownloadCallback {
        void downloaded(File file);

        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNoticeReceiptUploadBinding activityNoticeReceiptUploadBindingInflate = ActivityNoticeReceiptUploadBinding.inflate(getLayoutInflater());
        this.binding = activityNoticeReceiptUploadBindingInflate;
        setContentView(activityNoticeReceiptUploadBindingInflate.getRoot());
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        Bundle extras = getIntent().getExtras();
        initClickListener();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.asmblyNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
        this.utils = new Utils();
        this.choose_front_camera = getString(R.string.capture_from_front_camera);
        this.choose_back_camera = getString(R.string.capture_from_back_camera);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (extras != null) {
            this.acNo = extras.getInt("acNo");
            this.partNo = extras.getInt("partNo");
            this.partSerialNo = extras.getString("partSerialNo");
            this.epicNo = extras.getString("epicNo");
            this.complaintId = extras.getString("complaintId");
            this.noticeGeneratedDoc = extras.getString("noticeGeneratedDoc");
            this.bloNoticeDeliveredReceipDoc = extras.getString("bloNoticeDeliveredReceipDoc");
            this.bloNoticeDelivered = extras.getString("noticeDelivered");
        }
        this.selectRelationType = getString(R.string.selectRelationMsg);
        if (!TextUtils.isEmpty(this.noticeGeneratedDoc)) {
            displayFile(this.noticeGeneratedDoc, "noticeGenerated");
        } else {
            this.binding.generatedNoticeLL.setVisibility(8);
            this.binding.genertedDocName.setText(getString(R.string.blo_not_Available));
        }
        if (!TextUtils.isEmpty(this.bloNoticeDeliveredReceipDoc)) {
            displayFile(this.bloNoticeDeliveredReceipDoc, "receipt");
        } else {
            this.binding.generatedNoticeLL.setVisibility(8);
            this.binding.genertedDocName.setText(getString(R.string.blo_not_Available));
        }
        if (!TextUtils.isEmpty(this.bloNoticeDelivered) && this.bloNoticeDelivered.equalsIgnoreCase("1")) {
            this.binding.tvUploadReceipt.setVisibility(8);
        }
        this.binding.tvUploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc)) {
                    Toast.makeText((Context) ActivityNoticeUploadReceipt.this, (CharSequence) "Please Upload Receipt", 0).show();
                } else {
                    ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
                    activityNoticeUploadReceipt.uploadReceipt(activityNoticeUploadReceipt.state, ActivityNoticeUploadReceipt.this.asmblyNo, ActivityNoticeUploadReceipt.this.partSerialNo, String.valueOf(ActivityNoticeUploadReceipt.this.partNo), ActivityNoticeUploadReceipt.this.filepathimg, ActivityNoticeUploadReceipt.this.saveImageFileName, ActivityNoticeUploadReceipt.this.token, "", "receipt");
                }
            }
        });
        this.binding.deleteuploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc = null;
                ActivityNoticeUploadReceipt.this.binding.ivUploadReceipt.setImageBitmap(null);
                ActivityNoticeUploadReceipt.this.binding.ivUploadReceipt.setImageDrawable(null);
                ActivityNoticeUploadReceipt.this.binding.ivUploadReceipt.setImageResource(0);
                ActivityNoticeUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(8);
                ActivityNoticeUploadReceipt.this.binding.photo1Size.setVisibility(8);
                ActivityNoticeUploadReceipt.this.binding.photo1Name.setVisibility(8);
                ActivityNoticeUploadReceipt.this.binding.photo1Size.setText("");
                ActivityNoticeUploadReceipt.this.binding.photo1Name.setText("");
                ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setEnabled(true);
                ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setVisibility(0);
                ActivityNoticeUploadReceipt.this.binding.electorImageLL.setVisibility(8);
                ActivityNoticeUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
            }
        });
        this.binding.tvUploadImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityNoticeUploadReceipt.this.receipt = null;
                ActivityNoticeUploadReceipt.this.clusterDetsailsDialog(101, "photo1Form");
            }
        });
        if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
            this.faceRecognition = true;
        } else {
            this.faceRecognition = false;
        }
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.ivGenertedDocReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(ActivityNoticeUploadReceipt.this.noticeGeneratedDoc) || !ActivityNoticeUploadReceipt.this.noticeGeneratedDoc.endsWith("pdf")) {
                    return;
                }
                try {
                    ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
                    activityNoticeUploadReceipt.showPersonPdfDialog(activityNoticeUploadReceipt.file2, ActivityNoticeUploadReceipt.this.noticeGeneratedDoc);
                } catch (IOException e) {
                    Log.d("Exception in displaying pdf 2= ", e.getMessage());
                }
            }
        });
        this.binding.ivUploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (TextUtils.isEmpty(this.bloNoticeDeliveredReceipDoc) || !this.bloNoticeDeliveredReceipDoc.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.file1, this.bloNoticeDeliveredReceipDoc);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
        this.temp = this.epicNo.replaceAll("/", "_") + "_" + listCode;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(this.chooseFile);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$1(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$1(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.choosegallery)) {
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.choosepdf)) {
            openfileAnnxureD(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public void openfileAnnxureD(int code) {
        String[] strArr = {this.applicationpdf};
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        Intent intentCreateChooser = Intent.createChooser(intent, this.chooseFile);
        if (code == 101) {
            this.activityResultLauncher16.launch(intentCreateChooser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x0074 A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00af A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6 A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e8 A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f0 A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x010b A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0135 A[Catch: Exception -> 0x0140, TryCatch #1 {Exception -> 0x0140, blocks: (B:29:0x0055, B:31:0x0074, B:35:0x0091, B:37:0x00af, B:44:0x0131, B:38:0x00d6, B:40:0x00e8, B:41:0x00f0, B:43:0x010b, B:45:0x0135, B:46:0x013f), top: B:52:0x0055 }] */
    public void HandlePdfFile(Intent data, String code, int requestcode) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        long j;
        Uri data2 = data.getData();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(data2);
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
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            this.pdfbyteArray1 = byteArray;
                            saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf", this.temp);
                            cursorQuery = getContentResolver().query(saveImagePath, null, null, null, null);
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.close();
                                throw new IllegalArgumentException(this.imgmsg);
                            }
                            cursorQuery.moveToFirst();
                            strArrSplit = saveImagePath.getPath().split("/");
                            j = this.filesize;
                            if (j < 1024) {
                                Math.round(j * 100.0d);
                                uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "referenceNo", "receipt");
                                if (requestcode == 101) {
                                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.photo1Size.setText(this.filesize + "KB");
                                }
                            } else if (Math.round(((double) (j / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                                showdialog("Alert", this.pdf3);
                            } else {
                                uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "referenceNo", "receipt");
                                if (requestcode == 101) {
                                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.photo1Size.setText(this.filesize + "KB");
                                }
                            }
                            cursorQuery.close();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            Throwable th2 = th;
                            if (inputStreamOpenInputStream == null) {
                                throw th2;
                            }
                            try {
                                inputStreamOpenInputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                        Logger.d("", e.getMessage());
                        byteArrayOutputStream = byteArrayOutputStream2;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Exception e) {
                            e = e;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            Logger.d("", e.getMessage());
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
            }
            saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf", this.temp);
            cursorQuery = getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            strArrSplit = saveImagePath.getPath().split("/");
            j = this.filesize;
            if (j < 1024) {
                Math.round(j * 100.0d);
                uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "referenceNo", "receipt");
                if (requestcode == 101) {
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                }
            } else if (Math.round(((double) (j / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                showdialog("Alert", this.pdf3);
            } else {
                uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "referenceNo", "receipt");
                if (requestcode == 101) {
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                }
            }
            cursorQuery.close();
            return;
        } catch (Exception e3) {
            Logger.d("", e3.getMessage());
            return;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        this.pdfbyteArray1 = byteArray2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (requestCode == 0) {
                Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(data), 0).show();
                return;
            }
            Toast.makeText((Context) this, (CharSequence) "No Image selected", 0).show();
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), requestCode == 10001 ? null : data.getData());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        try {
            Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
            Cursor cursorQuery = getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            String[] strArrSplit = saveImagePath.getPath().split("/");
            if (requestCode == 101) {
                long j = this.filesize;
                if (j < 1024) {
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + getString(R.string.kbMsg));
                    uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", "receipt");
                } else if (j > 2048) {
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j2 = j / 1024;
                    this.filesize = j2;
                    if (Math.round(j2 * 100.0d) / 100.0d > 2.0d) {
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.photo1Size.setText(this.filesize + getString(R.string.mbMsg));
                        uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", "receipt");
                    }
                }
            }
            cursorQuery.close();
        } catch (Exception e2) {
            Logger.d("", e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d(this.TAG, str2);
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda5
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

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$4(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadReceipt(String statecode, String asmblyNo, String partSerialNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
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
        HashMap map2 = new HashMap();
        map2.put("complaintId", this.complaintId);
        map2.put("bloNoticeDeliveredReceipDoc", this.bloNoticeDeliveredReceipDoc);
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).saveAppealNoticeBlo(map, map2).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        AnonymousClass6() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt] */
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
                if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                    ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ActivityNoticeUploadReceipt.this.commomUtility;
                ?? r5 = ActivityNoticeUploadReceipt.this;
                commomUtility.getRefreshToken(r5, r5.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$6$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                    ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                }
                ActivityNoticeUploadReceipt.this.utils.infoDialogAction(ActivityNoticeUploadReceipt.this, "Alert", String.valueOf(((JsonObject) response.body()).get("message")), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.6.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        Intent intent = new Intent((Context) ActivityNoticeUploadReceipt.this, (Class<?>) ATModuleNoticeListActivity.class);
                        intent.setFlags(67108864);
                        ActivityNoticeUploadReceipt.this.startActivity(intent);
                        ActivityNoticeUploadReceipt.this.finish();
                    }
                });
                return;
            }
            if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt] */
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
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ActivityNoticeUploadReceipt.this.commomUtility;
                ?? r5 = ActivityNoticeUploadReceipt.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$6$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ActivityNoticeUploadReceipt.this.token = "Bearer " + str;
                ActivityNoticeUploadReceipt.this.refreshToken = str2;
                SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityNoticeUploadReceipt.this.startActivity(new Intent((Context) ActivityNoticeUploadReceipt.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
            }
            Toast.makeText((Context) ActivityNoticeUploadReceipt.this, (CharSequence) "onFailure", 0).show();
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
            map.put("userId", SharedPref.getInstance(getApplicationContext()).getBloPhone());
            String mD5Checksum = UploadWithPreSignedURL.getMD5Checksum(new File(filepath + captureFileName));
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.epicNo);
            map2.put("state", this.state);
            map2.put("acNo", asmblyNo);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass7(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            showDialog1(this.alertText, e.getMessage());
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass7(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v23, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt] */
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
                if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                    ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ActivityNoticeUploadReceipt.this.commomUtility;
                ?? r13 = ActivityNoticeUploadReceipt.this;
                String str = r13.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$7$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                    ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                }
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
                        ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
                        activityNoticeUploadReceipt.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, activityNoticeUploadReceipt.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = ActivityNoticeUploadReceipt.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals("receipt")) {
                        ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (!TextUtils.isEmpty(ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc) && ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc.endsWith(".pdf")) {
                            ActivityNoticeUploadReceipt.this.uploadPdfons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc);
                        } else {
                            ActivityNoticeUploadReceipt.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc);
                        }
                    }
                    if (this.val$uploadtype.equals(ActivityNoticeUploadReceipt.this.photostr)) {
                        ActivityNoticeUploadReceipt.this.electorref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        ActivityNoticeUploadReceipt.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityNoticeUploadReceipt.this.electorref);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityNoticeUploadReceipt activityNoticeUploadReceipt2 = ActivityNoticeUploadReceipt.this;
                    activityNoticeUploadReceipt2.showDialog1(activityNoticeUploadReceipt2.alertText, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
            }
            ActivityNoticeUploadReceipt activityNoticeUploadReceipt3 = ActivityNoticeUploadReceipt.this;
            activityNoticeUploadReceipt3.showDialog1(activityNoticeUploadReceipt3.alertText, ActivityNoticeUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
            ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt] */
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
                CommomUtility commomUtility = ActivityNoticeUploadReceipt.this.commomUtility;
                ?? r2 = ActivityNoticeUploadReceipt.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ActivityNoticeUploadReceipt.this.token = "Bearer " + str8;
            ActivityNoticeUploadReceipt.this.refreshToken = str9;
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str8);
            ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
            activityNoticeUploadReceipt.uploadPhoto(str, str2, str3, str4, str5, activityNoticeUploadReceipt.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityNoticeUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityNoticeUploadReceipt.this.startActivity(new Intent((Context) ActivityNoticeUploadReceipt.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
            }
            ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
            activityNoticeUploadReceipt.showDialog1(activityNoticeUploadReceipt.alertText, ActivityNoticeUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.8
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityNoticeUploadReceipt.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityNoticeUploadReceipt.this.displayFile(filereference, uploadtype);
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPdfons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCallerNewPdf().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.9
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityNoticeUploadReceipt.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityNoticeUploadReceipt.this.displayFile(filereference, uploadtype);
                    }
                }, 1000L);
            }
        });
    }

    public void resetImage(String imagetyype, String error) {
        if (imagetyype.equalsIgnoreCase(this.photostr)) {
            this.electorref = "";
        } else {
            this.bloNoticeDeliveredReceipDoc = "";
            this.binding.photo1Name.setVisibility(8);
            this.binding.photo1Size.setVisibility(8);
            this.binding.tvUploadImage.setEnabled(true);
            this.binding.tvUploadImage.setVisibility(0);
            this.binding.deleteuploadReceipt.setVisibility(8);
            this.binding.ivUploadReceipt.setVisibility(8);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equalsIgnoreCase("receipt")) {
                        if (ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc.endsWith(".pdf")) {
                            ActivityNoticeUploadReceipt.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.10.1
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.imageUrl = ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc;
                                    ActivityNoticeUploadReceipt.this.file1 = pdfFile;
                                    Log.e("GETFILE", "FILE1::" + ActivityNoticeUploadReceipt.this.file1);
                                    ActivityNoticeUploadReceipt.this.binding.photo1Name.setVisibility(8);
                                    ActivityNoticeUploadReceipt.this.binding.photo1Size.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.photo1Size.setText("");
                                    ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setEnabled(false);
                                    ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setVisibility(8);
                                    if (!TextUtils.isEmpty(ActivityNoticeUploadReceipt.this.bloNoticeDelivered) && ActivityNoticeUploadReceipt.this.bloNoticeDelivered.equalsIgnoreCase("1")) {
                                        ActivityNoticeUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(8);
                                        ActivityNoticeUploadReceipt.this.binding.tvUploadReceipt.setVisibility(8);
                                    } else {
                                        ActivityNoticeUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(0);
                                        ActivityNoticeUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
                                    }
                                    ActivityNoticeUploadReceipt.this.binding.electorImageLL.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.ivUploadReceipt.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.resetImage(uploadType, message);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void downloaded(File file) {
                                    ActivityNoticeUploadReceipt.this.imageUrl = ActivityNoticeUploadReceipt.this.bloNoticeDeliveredReceipDoc;
                                    ActivityNoticeUploadReceipt.this.file1 = file;
                                    Log.e("GETFILE", "FILE1::" + ActivityNoticeUploadReceipt.this.file1);
                                }
                            });
                        } else {
                            ActivityNoticeUploadReceipt.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.10.2
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void downloaded(File file) {
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.binding.photo1Name.setVisibility(8);
                                    ActivityNoticeUploadReceipt.this.binding.photo1Size.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.photo1Size.setText("");
                                    ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setEnabled(false);
                                    ActivityNoticeUploadReceipt.this.binding.tvUploadImage.setVisibility(8);
                                    if (!TextUtils.isEmpty(ActivityNoticeUploadReceipt.this.bloNoticeDelivered) && ActivityNoticeUploadReceipt.this.bloNoticeDelivered.equalsIgnoreCase("1")) {
                                        ActivityNoticeUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(8);
                                        ActivityNoticeUploadReceipt.this.binding.tvUploadReceipt.setVisibility(8);
                                    } else {
                                        ActivityNoticeUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(0);
                                        ActivityNoticeUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
                                    }
                                    ActivityNoticeUploadReceipt.this.binding.electorImageLL.setVisibility(0);
                                    Glide.with(ActivityNoticeUploadReceipt.this).load(strReplace).into(ActivityNoticeUploadReceipt.this.binding.ivUploadReceipt);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.resetImage(uploadType, message);
                                }
                            });
                        }
                    }
                    if (uploadType.equalsIgnoreCase("noticeGenerated")) {
                        if (ActivityNoticeUploadReceipt.this.noticeGeneratedDoc.endsWith(".pdf")) {
                            ActivityNoticeUploadReceipt.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.10.3
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.generatedNotice = ActivityNoticeUploadReceipt.this.noticeGeneratedDoc;
                                    ActivityNoticeUploadReceipt.this.file2 = pdfFile;
                                    Log.e("GETFILE", "FILE2::" + ActivityNoticeUploadReceipt.this.file2);
                                    ActivityNoticeUploadReceipt.this.binding.ivGenertedDocReceipt.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.generatedNoticeLL.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.genertedDocName.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.genertedDocName.setText(ActivityNoticeUploadReceipt.this.noticeGeneratedDoc);
                                    ActivityNoticeUploadReceipt.this.binding.ivGenertedDocReceipt.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.resetImage(uploadType, message);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void downloaded(File file) {
                                    ActivityNoticeUploadReceipt.this.noticeGeneratedDoc = ActivityNoticeUploadReceipt.this.generatedNotice;
                                    ActivityNoticeUploadReceipt.this.file2 = file;
                                    Log.e("GETFILE", "FILE2::" + ActivityNoticeUploadReceipt.this.file2);
                                }
                            });
                            return;
                        } else {
                            ActivityNoticeUploadReceipt.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.10.4
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void downloaded(File file) {
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.binding.ivGenertedDocReceipt.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.generatedNoticeLL.setVisibility(0);
                                    ActivityNoticeUploadReceipt.this.binding.genertedDocName.setVisibility(0);
                                    Glide.with(ActivityNoticeUploadReceipt.this).load(strReplace).into(ActivityNoticeUploadReceipt.this.binding.ivGenertedDocReceipt);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityNoticeUploadReceipt.this.resetImage(uploadType, message);
                                }
                            });
                            return;
                        }
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (ActivityNoticeUploadReceipt.this.alertDialog != null) {
                        ActivityNoticeUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityNoticeUploadReceipt activityNoticeUploadReceipt = ActivityNoticeUploadReceipt.this;
                    activityNoticeUploadReceipt.showDialog1(activityNoticeUploadReceipt.getString(R.string.alertMsg), Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.e(ActivityNoticeUploadReceipt.this.TAG, strOptString);
                    ActivityNoticeUploadReceipt.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(ActivityNoticeUploadReceipt.this.TAG, e.getMessage());
                    ActivityNoticeUploadReceipt.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                ActivityNoticeUploadReceipt.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase(this.photostr)) {
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
        if (uploadType.equalsIgnoreCase("receipt")) {
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
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$5(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$5(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.epicNo.replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.epicNo.replaceAll("/", "_") + "_voter_photo";
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

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$8(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$8(String str, final DownloadCallback downloadCallback) throws Throwable {
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda9
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            ActivityNoticeUploadReceipt.DownloadCallback downloadCallback2 = downloadCallback;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda0
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt] */
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda2
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                ActivityNoticeUploadReceipt.DownloadCallback downloadCallback2 = downloadCallback;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void clusterDetsailsDialog(final int code, String listCode) {
        this.temp = this.epicNo.replaceAll("/", "_") + "_" + listCode;
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(2131558800);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.layoutCapturePhoto);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.layoutGallery);
        LinearLayout linearLayout3 = (LinearLayout) dialog.findViewById(R.id.layoutPdf);
        TextView textView = (TextView) dialog.findViewById(R.id.cancel);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePicker.with(ActivityNoticeUploadReceipt.this).crop().compress(512).maxResultSize(1028, 1028).cameraOnly().start(code);
                dialog.dismiss();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePicker.with(ActivityNoticeUploadReceipt.this).crop().compress(512).galleryOnly().start(code);
                dialog.dismiss();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityNoticeUploadReceipt.this.openfileAnnxureD(code);
                dialog.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
