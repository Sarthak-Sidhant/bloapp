package in.gov.eci.bloapp.views.activity.sir.formdatanew;

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
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityReceiptUploadBinding;
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
public class ActivityUploadReceipt extends SuperBaseActivity {
    private static final String ALERT = "Alert";
    String SESSION;
    int acNo;
    AlertDialog alertDialog;
    String asmblyNo;
    String atkband;
    ActivityReceiptUploadBinding binding;
    byte[] byteArray;
    String deliveredTo;
    String epicNo;
    Long epicid;
    File file1;
    protected long filesize;
    String mime;
    int partNo;
    String partSerialNo;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
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
    ActivityResultLauncher<Intent> activityResultLauncher16 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.5
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                ActivityUploadReceipt.this.HandlePdfFile(result.getData(), "UploadReceipt", 101);
            }
        }
    });
    boolean faceRecognition = true;
    String photostr = "Photo";
    String receipt = null;
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
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReceiptUploadBinding activityReceiptUploadBindingInflate = ActivityReceiptUploadBinding.inflate(getLayoutInflater());
        this.binding = activityReceiptUploadBindingInflate;
        setContentView(activityReceiptUploadBindingInflate.getRoot());
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
            this.epicid = Long.valueOf(extras.getLong("epicid"));
            this.receipt = extras.getString("receipt");
            this.relationcode = extras.getString("deliveredTo");
        }
        this.selectRelationType = getString(R.string.selectRelationMsg);
        getRelationDropdownRecepit();
        if (!TextUtils.isEmpty(this.receipt)) {
            displayFile(this.receipt, "receipt");
        }
        this.binding.tvUploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(ActivityUploadReceipt.this.receipt)) {
                    Toast.makeText((Context) ActivityUploadReceipt.this, (CharSequence) "Please Select Receipt", 0).show();
                    return;
                }
                if (TextUtils.isEmpty(ActivityUploadReceipt.this.relationcode)) {
                    Toast.makeText((Context) ActivityUploadReceipt.this, (CharSequence) "Please Select deliver to", 0).show();
                } else if (ActivityUploadReceipt.this.binding.othername.getVisibility() == 0 && TextUtils.isEmpty(ActivityUploadReceipt.this.binding.othername.getText().toString())) {
                    Toast.makeText((Context) ActivityUploadReceipt.this, (CharSequence) "Please enter other person name", 0).show();
                } else {
                    ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
                    activityUploadReceipt.uploadReceipt(activityUploadReceipt.state, ActivityUploadReceipt.this.asmblyNo, ActivityUploadReceipt.this.partSerialNo, String.valueOf(ActivityUploadReceipt.this.partNo), ActivityUploadReceipt.this.filepathimg, ActivityUploadReceipt.this.saveImageFileName, ActivityUploadReceipt.this.token, "", "receipt");
                }
            }
        });
        this.binding.deleteuploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityUploadReceipt.this.receipt = null;
                ActivityUploadReceipt.this.binding.ivUploadReceipt.setImageBitmap(null);
                ActivityUploadReceipt.this.binding.ivUploadReceipt.setImageDrawable(null);
                ActivityUploadReceipt.this.binding.ivUploadReceipt.setImageResource(0);
                ActivityUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(8);
                ActivityUploadReceipt.this.binding.photo1Size.setVisibility(8);
                ActivityUploadReceipt.this.binding.photo1Name.setVisibility(8);
                ActivityUploadReceipt.this.binding.photo1Size.setText("");
                ActivityUploadReceipt.this.binding.photo1Name.setText("");
                ActivityUploadReceipt.this.binding.tvUploadImage.setEnabled(true);
                ActivityUploadReceipt.this.binding.tvUploadImage.setVisibility(0);
                ActivityUploadReceipt.this.binding.electorImageLL.setVisibility(8);
                ActivityUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
            }
        });
        this.binding.tvUploadImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityUploadReceipt.this.receipt = null;
                ActivityUploadReceipt.this.clusterDetsailsDialog(101, "photo1Form");
            }
        });
        this.binding.deliverSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    ActivityUploadReceipt.this.relationcode = null;
                    ActivityUploadReceipt.this.binding.tvOtherNameLable.setVisibility(8);
                    ActivityUploadReceipt.this.binding.othername.setVisibility(8);
                    return;
                }
                ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
                activityUploadReceipt.relationcode = activityUploadReceipt.relationCodeList.get(i);
                ActivityUploadReceipt.this.deletePhoto();
                if (!TextUtils.isEmpty(ActivityUploadReceipt.this.relationcode) && ActivityUploadReceipt.this.relationcode.equalsIgnoreCase("DTH")) {
                    ActivityUploadReceipt.this.faceRecognition = false;
                    ActivityUploadReceipt.this.binding.labelPhoto.setText(ActivityUploadReceipt.this.getString(R.string.blo_upload_death_certificate));
                    ActivityUploadReceipt.this.binding.tvOtherNameLable.setVisibility(8);
                    ActivityUploadReceipt.this.binding.othername.setVisibility(8);
                    return;
                }
                if (!TextUtils.isEmpty(ActivityUploadReceipt.this.relationcode) && ActivityUploadReceipt.this.relationcode.equalsIgnoreCase("OTHR")) {
                    ActivityUploadReceipt.this.binding.tvOtherNameLable.setVisibility(0);
                    ActivityUploadReceipt.this.binding.othername.setVisibility(0);
                    return;
                }
                ActivityUploadReceipt.this.binding.labelPhoto.setText(ActivityUploadReceipt.this.getString(R.string.upload_photo_receipt));
                if (SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
                    ActivityUploadReceipt.this.faceRecognition = true;
                } else {
                    ActivityUploadReceipt.this.faceRecognition = false;
                }
                ActivityUploadReceipt.this.binding.tvOtherNameLable.setVisibility(8);
                ActivityUploadReceipt.this.binding.othername.setVisibility(8);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
            this.faceRecognition = true;
        } else {
            this.faceRecognition = false;
        }
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.ivUploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            if (!TextUtils.isEmpty(this.relationcode) && this.relationcode.equalsIgnoreCase("DTH")) {
                pickPhoto(100, "photo1Form");
                return;
            } else {
                choosseCameraOption();
                return;
            }
        }
        if (!TextUtils.isEmpty(this.relationcode) && this.relationcode.equalsIgnoreCase("DTH")) {
            pickPhoto(100, "photo1Form");
        } else {
            pickFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (TextUtils.isEmpty(this.imageUrl) || !this.imageUrl.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.file1, this.imageUrl);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto() {
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.passPhoto.setVisibility(0);
        this.binding.passPhotoLayout.setVisibility(8);
        this.electorref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.cancel};
        this.temp = this.epicNo.replaceAll("/", "_") + "_" + listCode;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(this.chooseFile);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$3(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$3(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = "tempTest_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$4(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$4(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v9 */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r15;
        String str;
        int i3;
        Uri uri;
        Uri saveImagePath;
        Uri uri2;
        ?? r16;
        boolean z;
        super.onActivityResult(i, i2, intent);
        ?? r17 = 4611686018427387904;
        if (i2 == -1) {
            Uri data = i == 10001 ? null : intent.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
                Cursor cursorQuery = getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath2.getPath().split("/");
                    if (i == 101) {
                        long j = this.filesize;
                        try {
                            if (j < 1024) {
                                try {
                                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.photo1Size.setText(this.filesize + getString(R.string.kbMsg));
                                    uri2 = data;
                                    str = "/";
                                    uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", "receipt");
                                } catch (Exception e2) {
                                    e = e2;
                                    uri2 = data;
                                    str = "/";
                                    r17 = 1;
                                    Logger.d("", e.getMessage());
                                    r16 = r17;
                                }
                            } else {
                                uri2 = data;
                                str = "/";
                                if (j > 2048) {
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j2 = j / 1024;
                                    this.filesize = j2;
                                    if (Math.round(j2 * 100.0d) / 100.0d > 2.0d) {
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        try {
                                            this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.photo1Size.setText(this.filesize + getString(R.string.mbMsg));
                                            z = true;
                                            uploadPhoto(this.state, this.asmblyNo, String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", "receipt");
                                        } catch (Exception e3) {
                                            e = e3;
                                            r17 = 1;
                                            Logger.d("", e.getMessage());
                                            r16 = r17;
                                        }
                                    }
                                }
                            }
                            z = true;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } else {
                        uri2 = data;
                        z = true;
                        str = "/";
                    }
                    cursorQuery.close();
                    r16 = z;
                    uri = uri2;
                    i3 = 0;
                    r15 = r16;
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
                uri2 = data;
                r17 = 1;
                str = "/";
            }
            Logger.d("", e.getMessage());
            r16 = r17;
            uri = uri2;
            i3 = 0;
            r15 = r16;
        } else {
            r15 = 1;
            str = "/";
            if (i == 0) {
                i3 = 0;
                Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(intent), 0).show();
            } else {
                i3 = 0;
                Toast.makeText((Context) this, (CharSequence) "No Image selected", 0).show();
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
            uri = null;
        }
        if ((i == 100 || i == 10001) && i2 == -1) {
            try {
                if (i == 10001) {
                    saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                    this.saveImageFileName = "img_" + this.temp + this.jpgTextBaseActivity;
                    File file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                    if (file.exists()) {
                        Log.e("extract", "extract true");
                    }
                    BitmapFactory.decodeFile(file.getAbsolutePath());
                    this.filesize = file.length() / 1024;
                } else {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    this.byteArray = byteArray;
                    saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, i3), this.img, this.temp);
                }
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery2.getCount() <= 0) {
                    cursorQuery2.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery2.moveToFirst();
                String[] strArrSplit2 = saveImagePath.getPath().split(str);
                Log.e("extract", strArrSplit2[strArrSplit2.length - r15]);
                long j3 = this.filesize;
                if (j3 < 1024) {
                    if (this.faceRecognition) {
                        faceRecognition(this.state, String.valueOf(this.acNo), String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        uploadPhoto(this.state, String.valueOf(this.acNo), String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", this.photostr);
                    }
                    this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                    if (this.filesize != 0) {
                        this.binding.photoSize.setText(this.filesize + "KB");
                        this.binding.photoSize.setVisibility(i3);
                    } else {
                        this.binding.photoSize.setVisibility(8);
                    }
                } else {
                    long j4 = j3 / 1024;
                    this.filesize = j4;
                    double dRound = Math.round(j4 * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.binding.passPhotoLayout.setVisibility(8);
                        this.binding.chooseFileTv.setEnabled(r15);
                        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        if (this.faceRecognition) {
                            faceRecognition(this.state, String.valueOf(this.acNo), String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", this.photostr);
                        } else {
                            this.alertDialog.dismiss();
                            uploadPhoto(this.state, String.valueOf(this.acNo), String.valueOf(this.partNo), this.filepathimg, this.saveImageFileName, this.token, "", this.photostr);
                        }
                        this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                        if (dRound != 0.0d) {
                            this.binding.photoSize.setText(dRound + "MB");
                            this.binding.photoSize.setVisibility(0);
                        } else {
                            this.binding.photoSize.setVisibility(8);
                        }
                    }
                }
                cursorQuery2.close();
            } catch (Exception e7) {
                Logger.d("tag", e7.getMessage());
            }
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$6(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda1
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
    public void uploadReceipt(String statecode, String asmblyNo, String partSerialNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        ArrayList arrayList = new ArrayList();
        Log.d("listepicId", String.valueOf(arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.epicNo);
        arrayList.add(this.epicid);
        this.json.put("acNo", Integer.valueOf(this.acNo));
        this.json.put("epicId", arrayList);
        this.json.put("epicNo", arrayList2);
        this.json.put("partNo", Integer.valueOf(this.partNo));
        this.json.put("deliveredTo", this.relationcode);
        this.json.put("deliveredToPhoto", this.electorref);
        this.json.put("uploadHearingReceipt", this.receipt);
        if (this.binding.othername.getVisibility() == 0 && !TextUtils.isEmpty(this.binding.othername.getText().toString())) {
            this.json.put("otherName", this.binding.othername.getText().toString());
        } else {
            this.json.put("otherName", null);
        }
        ((RestClient) ApiClient.getClient2(this).create(RestClient.class)).updateImageUploadRecept(this.state.toLowerCase(), this.token, "application/json", this.atkband, this.rtkband, "BLOAPP", "blo", statecode, this.json).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        AnonymousClass6() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
            Log.d("refid--->", "" + response.code());
            if (response.code() == 401) {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r5 = ActivityUploadReceipt.this;
                commomUtility.getRefreshToken(r5, r5.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$6$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                ActivityUploadReceipt.this.utils.infoDialogAction(ActivityUploadReceipt.this, "Alert", String.valueOf(((JsonObject) response.body()).get("message")), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.6.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        Intent intent = new Intent((Context) ActivityUploadReceipt.this, (Class<?>) ScheduldeHearingNoticeListActivity.class);
                        intent.setFlags(67108864);
                        ActivityUploadReceipt.this.startActivity(intent);
                        ActivityUploadReceipt.this.finish();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r5 = ActivityUploadReceipt.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$6$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ActivityUploadReceipt.this.token = "Bearer " + str;
                ActivityUploadReceipt.this.refreshToken = str2;
                SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityUploadReceipt.this.startActivity(new Intent((Context) ActivityUploadReceipt.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
            Toast.makeText((Context) ActivityUploadReceipt.this, (CharSequence) "onFailure", 0).show();
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$7, reason: invalid class name */
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
        /* JADX WARN: Type inference failed for: r13v23, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r13 = ActivityUploadReceipt.this;
                String str = r13.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$7$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
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
                        ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
                        activityUploadReceipt.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, activityUploadReceipt.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = ActivityUploadReceipt.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals("receipt")) {
                        ActivityUploadReceipt.this.receipt = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (!TextUtils.isEmpty(ActivityUploadReceipt.this.receipt) && ActivityUploadReceipt.this.receipt.endsWith(".pdf")) {
                            ActivityUploadReceipt.this.uploadPdfons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityUploadReceipt.this.receipt);
                        } else {
                            ActivityUploadReceipt.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityUploadReceipt.this.receipt);
                        }
                    }
                    if (this.val$uploadtype.equals(ActivityUploadReceipt.this.photostr)) {
                        ActivityUploadReceipt.this.electorref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        ActivityUploadReceipt.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, ActivityUploadReceipt.this.electorref);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (ActivityUploadReceipt.this.alertDialog != null) {
                        ActivityUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityUploadReceipt activityUploadReceipt2 = ActivityUploadReceipt.this;
                    activityUploadReceipt2.showDialog1(activityUploadReceipt2.alertText, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
            ActivityUploadReceipt activityUploadReceipt3 = ActivityUploadReceipt.this;
            activityUploadReceipt3.showDialog1(activityUploadReceipt3.alertText, ActivityUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
            ActivityUploadReceipt.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r2 = ActivityUploadReceipt.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ActivityUploadReceipt.this.token = "Bearer " + str8;
            ActivityUploadReceipt.this.refreshToken = str9;
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str8);
            ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
            activityUploadReceipt.uploadPhoto(str, str2, str3, str4, str5, activityUploadReceipt.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityUploadReceipt.this.startActivity(new Intent((Context) ActivityUploadReceipt.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
            ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
            activityUploadReceipt.showDialog1(activityUploadReceipt.alertText, ActivityUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.8
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (ActivityUploadReceipt.this.alertDialog != null) {
                        ActivityUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityUploadReceipt.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityUploadReceipt.this.displayFile(filereference, uploadtype);
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPdfons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCallerNewPdf().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.9
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (ActivityUploadReceipt.this.alertDialog != null) {
                        ActivityUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityUploadReceipt.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityUploadReceipt.this.displayFile(filereference, uploadtype);
                    }
                }, 1000L);
            }
        });
    }

    public void resetImage(String imagetyype, String error) {
        if (imagetyype.equalsIgnoreCase(this.photostr)) {
            this.electorref = "";
            this.binding.image.setVisibility(8);
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
        } else {
            this.receipt = "";
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
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(ActivityUploadReceipt.this.photostr)) {
                        if (ActivityUploadReceipt.this.alertDialog != null) {
                            ActivityUploadReceipt.this.alertDialog.dismiss();
                        }
                        ActivityUploadReceipt.this.binding.passPhotoLayout.setVisibility(0);
                        ActivityUploadReceipt.this.binding.passPhoto.setVisibility(8);
                        ActivityUploadReceipt.this.binding.cancel.setVisibility(0);
                        ActivityUploadReceipt.this.binding.chooseFileTv.setTextColor(Color.parseColor(ActivityUploadReceipt.this.greycolor));
                        ActivityUploadReceipt.this.binding.chooseFileTv.setEnabled(false);
                        ActivityUploadReceipt.this.binding.photoNameTv2.setVisibility(0);
                        ActivityUploadReceipt.this.binding.image.setVisibility(0);
                        Glide.with(ActivityUploadReceipt.this).load(strReplace).into(ActivityUploadReceipt.this.binding.image);
                    }
                    if (uploadType.equalsIgnoreCase("receipt")) {
                        if (ActivityUploadReceipt.this.receipt.endsWith(".pdf")) {
                            ActivityUploadReceipt.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.10.1
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityUploadReceipt.this.alertDialog != null) {
                                        ActivityUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityUploadReceipt.this.imageUrl = ActivityUploadReceipt.this.receipt;
                                    ActivityUploadReceipt.this.file1 = pdfFile;
                                    Log.e("GETFILE", "FILE1::" + ActivityUploadReceipt.this.file1);
                                    ActivityUploadReceipt.this.binding.photo1Name.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.photo1Size.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.tvUploadImage.setEnabled(false);
                                    ActivityUploadReceipt.this.binding.tvUploadImage.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(0);
                                    ActivityUploadReceipt.this.binding.electorImageLL.setVisibility(0);
                                    ActivityUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
                                    ActivityUploadReceipt.this.binding.ivUploadReceipt.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityUploadReceipt.this.alertDialog != null) {
                                        ActivityUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityUploadReceipt.this.resetImage(uploadType, message);
                                }
                            });
                            return;
                        } else {
                            ActivityUploadReceipt.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.10.2
                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.DownloadCallback
                                public void onSuccess(File pdfFile) {
                                    if (ActivityUploadReceipt.this.alertDialog != null) {
                                        ActivityUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityUploadReceipt.this.binding.photo1Name.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.photo1Size.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.tvUploadImage.setEnabled(false);
                                    ActivityUploadReceipt.this.binding.tvUploadImage.setVisibility(8);
                                    ActivityUploadReceipt.this.binding.deleteuploadReceipt.setVisibility(0);
                                    ActivityUploadReceipt.this.binding.electorImageLL.setVisibility(0);
                                    ActivityUploadReceipt.this.binding.tvUploadReceipt.setVisibility(0);
                                    Glide.with(ActivityUploadReceipt.this).load(strReplace).into(ActivityUploadReceipt.this.binding.ivUploadReceipt);
                                }

                                @Override // in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.DownloadCallback
                                public void onError(String message, Throwable cause) {
                                    if (ActivityUploadReceipt.this.alertDialog != null) {
                                        ActivityUploadReceipt.this.alertDialog.dismiss();
                                    }
                                    ActivityUploadReceipt.this.resetImage(uploadType, message);
                                }
                            });
                            return;
                        }
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (ActivityUploadReceipt.this.alertDialog != null) {
                        ActivityUploadReceipt.this.alertDialog.dismiss();
                    }
                    ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
                    activityUploadReceipt.showDialog1(activityUploadReceipt.getString(R.string.alertMsg), Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.e(ActivityUploadReceipt.this.TAG, strOptString);
                    ActivityUploadReceipt.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(ActivityUploadReceipt.this.TAG, e.getMessage());
                    ActivityUploadReceipt.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                ActivityUploadReceipt.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$8(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$8(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        Call<JsonObject> callFaceRecognitionApi = restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType")));
        this.alertDialog.show();
        callFaceRecognitionApi.enqueue(new AnonymousClass11(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass11(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                Context applicationContext = ActivityUploadReceipt.this.getApplicationContext();
                String str = ActivityUploadReceipt.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$11$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(ActivityUploadReceipt.this.photostr)) {
                    ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
                    activityUploadReceipt.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, activityUploadReceipt.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                ActivityUploadReceipt.this.binding.passPhotoLayout.setVisibility(8);
                ActivityUploadReceipt.this.binding.passPhoto.setVisibility(0);
                ActivityUploadReceipt.this.binding.chooseFileTv.setEnabled(true);
                ActivityUploadReceipt.this.binding.chooseFileTv.setTextColor(Color.parseColor(ActivityUploadReceipt.this.whitecolor));
                new JSONObject(response.errorBody().string());
                ActivityUploadReceipt activityUploadReceipt2 = ActivityUploadReceipt.this;
                activityUploadReceipt2.showDialog1(activityUploadReceipt2.alertText, ActivityUploadReceipt.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r2 = ActivityUploadReceipt.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                ActivityUploadReceipt.this.alertDialog.dismiss();
                return;
            }
            ActivityUploadReceipt.this.alertDialog.dismiss();
            ActivityUploadReceipt.this.token = "Bearer " + str8;
            ActivityUploadReceipt.this.refreshToken = str9;
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str8);
            ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
            activityUploadReceipt.faceRecognition(str, str2, str3, str4, str5, activityUploadReceipt.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityUploadReceipt.this.startActivity(new Intent(ActivityUploadReceipt.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ActivityUploadReceipt.this.binding.passPhotoLayout.setVisibility(8);
            ActivityUploadReceipt.this.binding.passPhotoLayout.setVisibility(8);
            ActivityUploadReceipt.this.binding.passPhoto.setVisibility(0);
            ActivityUploadReceipt.this.binding.chooseFileTv.setEnabled(true);
            ActivityUploadReceipt.this.binding.chooseFileTv.setTextColor(Color.parseColor(ActivityUploadReceipt.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            ActivityUploadReceipt activityUploadReceipt = ActivityUploadReceipt.this;
            activityUploadReceipt.showDialog1(activityUploadReceipt.alertText, t.getMessage());
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$11(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$11(String str, final DownloadCallback downloadCallback) throws Throwable {
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda11
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            ActivityUploadReceipt.DownloadCallback downloadCallback2 = downloadCallback;
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

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$15(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
    public /* synthetic */ void lambda$checkImageFromURL$15(String str, final DownloadCallback downloadCallback) throws Throwable {
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda7
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                ActivityUploadReceipt.DownloadCallback downloadCallback2 = downloadCallback;
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
    public void getRelationDropdownRecepit() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getRelationHearing(map).enqueue(new AnonymousClass12());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        AnonymousClass12() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
        /* JADX WARN: Type inference failed for: r8v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
        /* JADX WARN: Type inference failed for: r8v21, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    ActivityUploadReceipt.this.relationNameList.clear();
                    ActivityUploadReceipt.this.relationCodeList.clear();
                    ActivityUploadReceipt.this.relationNameList.add(ActivityUploadReceipt.this.selectRelationType);
                    ActivityUploadReceipt.this.relationCodeList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = ActivityUploadReceipt.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        ActivityUploadReceipt.this.relationNameList.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ActivityUploadReceipt.this.relationCodeList.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    ?? r8 = ActivityUploadReceipt.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r8, R.layout.blo_spinner_dropdown, r8.relationNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ActivityUploadReceipt.this.binding.deliverSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    int position = arrayAdapter.getPosition("Death");
                    if (TextUtils.isEmpty(ActivityUploadReceipt.this.relationcode) || !ActivityUploadReceipt.this.relationcode.equalsIgnoreCase("DTH")) {
                        return;
                    }
                    ActivityUploadReceipt.this.binding.deliverSpinner.setSelection(position);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                    ?? r9 = ActivityUploadReceipt.this;
                    commomUtility.getRefreshToken(r9, r9.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$12$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e("", e.toString());
                    return;
                }
            }
            try {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Logger.e("", jSONObject.optString("message"));
                Utils utils = ActivityUploadReceipt.this.utils;
                ?? r1 = ActivityUploadReceipt.this;
                utils.infoDialog(r1, r1.getResources().getString(R.string.alertMsg), strOptString);
            } catch (IOException | JSONException e2) {
                if (ActivityUploadReceipt.this.alertDialog != null) {
                    ActivityUploadReceipt.this.alertDialog.dismiss();
                }
                Utils utils2 = ActivityUploadReceipt.this.utils;
                ?? r2 = ActivityUploadReceipt.this;
                utils2.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), ActivityUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
            ActivityUploadReceipt.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ActivityUploadReceipt.this.commomUtility;
                ?? r5 = ActivityUploadReceipt.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt$12$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ActivityUploadReceipt.this.token = "Bearer " + str;
                SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setToken("Bearer " + str);
                ActivityUploadReceipt.this.getRelationDropdownRecepit();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ActivityUploadReceipt.this.getApplicationContext()).setLocaleBool(false);
            ActivityUploadReceipt.this.startActivity(new Intent(ActivityUploadReceipt.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt] */
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
        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ActivityUploadReceipt.this.alertDialog != null) {
                ActivityUploadReceipt.this.alertDialog.dismiss();
            }
            Utils utils = ActivityUploadReceipt.this.utils;
            ?? r0 = ActivityUploadReceipt.this;
            utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), ActivityUploadReceipt.this.getResources().getString(R.string.something_went_wrong));
            Logger.d("", "OnFailure" + t.getMessage());
        }
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
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePicker.with(ActivityUploadReceipt.this).crop().compress(512).maxResultSize(1028, 1028).cameraOnly().start(code);
                dialog.dismiss();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePicker.with(ActivityUploadReceipt.this).crop().compress(512).galleryOnly().start(code);
                dialog.dismiss();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityUploadReceipt.this.openfileAnnxureD(code);
                dialog.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
