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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
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
import in.gov.eci.bloapp.databinding.ActivityUploadDocumentBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DocTypeRoot;
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
public class UploadDocumentActivity extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityUploadDocumentBinding binding;
    String currentDate;
    int docId1;
    int docId2;
    int docId3;
    int docId4;
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
    String stateCode;
    String temp;
    private String token;
    Utils utils;
    VerifyPayload verifyPayload;
    private boolean is_processing = false;
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
    String doc3Page1str = "Doc3Page1";
    String doc3Page2str = "Doc3Page2";
    String doc4Page1str = "Doc4Page1";
    String doc4Page2str = "Doc4Page2";
    String relativeDocument1UrlS = "";
    String doc4Page1Url = "";
    String doc4Page2URL = "";
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
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    String doc3Page1url = "";
    String doc3Page2Url = "";
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
        this.binding = ActivityUploadDocumentBinding.inflate(getLayoutInflater());
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
        this.binding.textView3.setText(getResources().getString(R.string.no_mapping));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        initializeSpinnerTouch();
        handleClick();
        getDocType();
    }

    private void handleClick() {
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UploadDocumentActivity.this.docId1 != 0) {
                    UploadDocumentActivity.this.pickPhoto(101, "enFormPage1");
                } else {
                    UploadDocumentActivity.this.showDialog1("Alert", "Select document type for document 1");
                }
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS)) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.showDialog1(uploadDocumentActivity.alertText, "Please upload front side of the selected document 1");
                } else {
                    UploadDocumentActivity.this.pickPhoto(102, "enFormPage2");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UploadDocumentActivity.this.docId2 != 0) {
                    UploadDocumentActivity.this.pickPhoto(103, "sDPage1");
                } else {
                    UploadDocumentActivity.this.showDialog1("Alert", "Select document type for document 2");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.showDialog1(uploadDocumentActivity.alertText, "Please upload front side of the selected document 2");
                } else {
                    UploadDocumentActivity.this.pickPhoto(104, "sDPage2");
                }
            }
        });
        this.binding.doc3uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (UploadDocumentActivity.this.docId3 != 0) {
                    UploadDocumentActivity.this.pickPhoto(105, "doc3Page1");
                } else {
                    UploadDocumentActivity.this.showDialog1("Alert", "Select document type for document 3");
                }
            }
        });
        this.binding.doc3uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(UploadDocumentActivity.this.doc3Page1url)) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.showDialog1(uploadDocumentActivity.alertText, "Please upload front side of the selected document 3");
                } else {
                    UploadDocumentActivity.this.pickPhoto(106, "doc3Page2");
                }
            }
        });
        this.binding.doc4uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (UploadDocumentActivity.this.docId4 != 0) {
                    UploadDocumentActivity.this.pickPhoto(107, "doc3Page1");
                } else {
                    UploadDocumentActivity.this.showDialog1("Alert", "Select document type for document 4");
                }
            }
        });
        this.binding.doc4uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(UploadDocumentActivity.this.doc4Page1Url)) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.showDialog1(uploadDocumentActivity.alertText, "Please upload front side of the selected document 4");
                } else {
                    UploadDocumentActivity.this.pickPhoto(108, "doc3Page2");
                }
            }
        });
        this.binding.submitDocument.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (UploadDocumentActivity.this.is_processing) {
                    return;
                }
                UploadDocumentActivity.this.is_processing = true;
                UploadDocumentActivity.this.binding.submitDocument.setEnabled(false);
                if (UploadDocumentActivity.this.docId1 == 0) {
                    UploadDocumentActivity.this.showDialog1("Alert", "Select document type for document 1");
                    UploadDocumentActivity.this.is_processing = false;
                    UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                    return;
                }
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS)) {
                    UploadDocumentActivity.this.showDialog1("Alert", "Please upload front side of the selected document 1");
                    UploadDocumentActivity.this.is_processing = false;
                    UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                    return;
                }
                if (UploadDocumentActivity.this.docId2 != 0 && TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    UploadDocumentActivity.this.showDialog1("Alert", "Please upload front side of the selected document 2");
                    UploadDocumentActivity.this.is_processing = false;
                    UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                } else if (UploadDocumentActivity.this.docId3 != 0 && TextUtils.isEmpty(UploadDocumentActivity.this.doc3Page1url)) {
                    UploadDocumentActivity.this.showDialog1("Alert", "Please upload front side of the selected document 3");
                    UploadDocumentActivity.this.is_processing = false;
                    UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                } else {
                    if (UploadDocumentActivity.this.docId4 != 0 && TextUtils.isEmpty(UploadDocumentActivity.this.doc4Page1Url)) {
                        UploadDocumentActivity.this.showDialog1("Alert", "Please upload front side of the selected document 4");
                        UploadDocumentActivity.this.is_processing = false;
                        UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                        return;
                    }
                    UploadDocumentActivity.this.submitNew();
                }
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$0(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$1(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$2(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$3(view);
            }
        });
        this.binding.doc3cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$4(view);
            }
        });
        this.binding.doc3cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$5(view);
            }
        });
        this.binding.doc4cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$6(view);
            }
        });
        this.binding.doc4cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$7(view);
            }
        });
        this.binding.documentSpinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (UploadDocumentActivity.this.isUserSelected && position == 0) {
                    UploadDocumentActivity.this.isUserSelected = false;
                    UploadDocumentActivity.this.docId1 = 0;
                    UploadDocumentActivity.this.deletePhoto(101);
                    UploadDocumentActivity.this.deletePhoto(102);
                    return;
                }
                if (UploadDocumentActivity.this.isUserSelected) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.docId1 = uploadDocumentActivity.docCodeist.get(position).intValue();
                    UploadDocumentActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.document2Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (UploadDocumentActivity.this.isUserSelected && position == 0) {
                    UploadDocumentActivity.this.docId2 = 0;
                    UploadDocumentActivity.this.deletePhoto(103);
                    UploadDocumentActivity.this.deletePhoto(104);
                    UploadDocumentActivity.this.isUserSelected = false;
                    return;
                }
                if (UploadDocumentActivity.this.isUserSelected) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.docId2 = uploadDocumentActivity.docCodeist.get(position).intValue();
                    UploadDocumentActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.document3Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (UploadDocumentActivity.this.isUserSelected && position == 0) {
                    UploadDocumentActivity.this.docId3 = 0;
                    UploadDocumentActivity.this.deletePhoto(105);
                    UploadDocumentActivity.this.deletePhoto(106);
                    UploadDocumentActivity.this.isUserSelected = false;
                    return;
                }
                if (UploadDocumentActivity.this.isUserSelected) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.docId3 = uploadDocumentActivity.docCodeist.get(position).intValue();
                    UploadDocumentActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.document4Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.13
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (UploadDocumentActivity.this.isUserSelected && position == 0) {
                    UploadDocumentActivity.this.docId4 = 0;
                    UploadDocumentActivity.this.deletePhoto(107);
                    UploadDocumentActivity.this.deletePhoto(108);
                    UploadDocumentActivity.this.isUserSelected = false;
                    return;
                }
                if (UploadDocumentActivity.this.isUserSelected) {
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.docId4 = uploadDocumentActivity.docCodeist.get(position).intValue();
                    UploadDocumentActivity.this.isUserSelected = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$0(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$1(View view) {
        deletePhoto(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$2(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$3(View view) {
        deletePhoto(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$4(View view) {
        deletePhoto(105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$5(View view) {
        deletePhoto(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$6(View view) {
        deletePhoto(107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$7(View view) {
        deletePhoto(108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNew() {
        this.alertDialog.show();
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
        map2.put("partSerialNo", Integer.valueOf(this.verifyPayload.getPartSerialNo()));
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        map2.put("epicId", this.verifyPayload.getEpicId());
        map2.put("stateCd", this.state);
        map2.put("docType1", Integer.valueOf(this.docId1));
        map2.put("docType2", Integer.valueOf(this.docId2));
        map2.put("docType3", Integer.valueOf(this.docId3));
        map2.put("docType4", Integer.valueOf(this.docId4));
        map2.put("doc1Front", this.relativeDocument1UrlS);
        map2.put("doc1Back", this.relativeDocument2UrlS);
        map2.put("doc2Front", this.relativeSupportingDocumentPage1UrlS);
        map2.put("doc2Back", this.relativeSupportingDocumentPage2UrlS);
        map2.put("doc3Front", this.doc3Page1url);
        map2.put("doc3Back", this.doc3Page2Url);
        map2.put("doc4Front", this.doc4Page1Url);
        map2.put("doc4Back", this.doc4Page2URL);
        map2.put("partNo", Integer.valueOf(this.partNo));
        String lowerCase = this.state.toLowerCase();
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        this.service.updateNACategoryByEpicID(lowerCase, map, map2).enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.14
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v16, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                    UploadDocumentActivity.this.is_processing = false;
                    try {
                        Utils utils = UploadDocumentActivity.this.utils;
                        ?? r0 = UploadDocumentActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.14.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                Intent intent = new Intent((Context) UploadDocumentActivity.this, (Class<?>) NoMappingFormsListActivity.class);
                                intent.setFlags(67108864);
                                UploadDocumentActivity.this.startActivity(intent);
                                UploadDocumentActivity.this.finish();
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (UploadDocumentActivity.this.alertDialog != null) {
                            UploadDocumentActivity.this.alertDialog.dismiss();
                        }
                        UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                        UploadDocumentActivity.this.is_processing = false;
                        return;
                    }
                }
                UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                UploadDocumentActivity.this.is_processing = false;
                try {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    UploadDocumentActivity.this.showDialog1("Alert", strOptString);
                    Logger.e("UncollectableTAG", strOptString);
                } catch (IOException | JSONException e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.binding.submitDocument.setEnabled(true);
                UploadDocumentActivity.this.is_processing = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$8(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$8(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$9(View view) {
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
            } else if (requestCode == 105) {
                long j9 = this.filesize;
                if (j9 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc3Page1str);
                    this.binding.doc3DocumentsPage1.setVisibility(0);
                    this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                    this.binding.doc3DocumentsPage1ImageName.setVisibility(0);
                    this.binding.doc3DocumentsPage1ImageSize.setVisibility(0);
                    this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                    this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(false);
                    this.binding.doc3DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.doc3DocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j9 > 2048) {
                    this.binding.doc3DocumentsPage1.setVisibility(8);
                    this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(8);
                    this.binding.doc3DocumentsPage1ImageName.setVisibility(8);
                    this.binding.doc3DocumentsPage1ImageSize.setVisibility(8);
                    this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(8);
                    this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.blackColor));
                    this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(true);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j10 = j9 / 1024;
                    this.filesize = j10;
                    double dRound5 = Math.round(j10 * 100.0d) / 100.0d;
                    if (dRound5 > 2.0d) {
                        this.binding.doc3DocumentsPage1.setVisibility(8);
                        this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc3Page1str);
                        this.binding.doc3DocumentsPage1.setVisibility(0);
                        this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                        this.binding.doc3DocumentsPage1ImageName.setVisibility(0);
                        this.binding.doc3DocumentsPage1ImageSize.setVisibility(0);
                        this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                        this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(false);
                        this.binding.doc3DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.doc3DocumentsPage1ImageSize.setText(dRound5 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 106) {
                long j11 = this.filesize;
                if (j11 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc3Page2str);
                    this.binding.doc3supportingDocumentsPage2.setVisibility(0);
                    this.binding.doc3cancelSupportingDocumentsPage2Image.setVisibility(0);
                    this.binding.doc3supportingDocumentsPage2ImageName.setVisibility(0);
                    this.binding.doc3supportingDocumentsPage2ImageSize.setVisibility(0);
                    this.binding.doc3supportingDocumentsPage2Image.setVisibility(0);
                    ImageView imageView3 = this.binding.doc3supportingDocumentsPage2Image;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(false);
                    this.binding.doc3supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.doc3supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j11 > 2048) {
                    this.binding.doc3supportingDocumentsPage2.setVisibility(8);
                    this.binding.doc3cancelSupportingDocumentsPage2Image.setVisibility(8);
                    this.binding.doc3supportingDocumentsPage2ImageName.setVisibility(8);
                    this.binding.doc3supportingDocumentsPage2ImageSize.setVisibility(8);
                    this.binding.doc3supportingDocumentsPage2Image.setVisibility(8);
                    this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.blackColor));
                    this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(true);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j12 = j11 / 1024;
                    this.filesize = j12;
                    double dRound6 = Math.round(j12 * 100.0d) / 100.0d;
                    if (dRound6 > 2.0d) {
                        this.binding.doc3supportingDocumentsPage2.setVisibility(8);
                        this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc3Page2str);
                        this.binding.doc3supportingDocumentsPage2.setVisibility(0);
                        this.binding.doc3cancelSupportingDocumentsPage2Image.setVisibility(0);
                        this.binding.doc3supportingDocumentsPage2ImageName.setVisibility(0);
                        this.binding.doc3supportingDocumentsPage2ImageSize.setVisibility(0);
                        this.binding.doc3supportingDocumentsPage2Image.setVisibility(0);
                        ImageView imageView4 = this.binding.doc3supportingDocumentsPage2Image;
                        byte[] bArr4 = this.pdfbyteArray;
                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                        this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(false);
                        this.binding.doc3supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.doc3supportingDocumentsPage2ImageSize.setText(dRound6 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 107) {
                long j13 = this.filesize;
                if (j13 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc4Page1str);
                    this.binding.doc4DocumentsPage1.setVisibility(0);
                    this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                    this.binding.doc4DocumentsPage1ImageName.setVisibility(0);
                    this.binding.doc4DocumentsPage1ImageSize.setVisibility(0);
                    this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                    this.binding.doc4uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(false);
                    this.binding.doc4DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.doc4DocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j13 > 2048) {
                    this.binding.doc4DocumentsPage1.setVisibility(8);
                    this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(8);
                    this.binding.doc4DocumentsPage1ImageName.setVisibility(8);
                    this.binding.doc4DocumentsPage1ImageSize.setVisibility(8);
                    this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(8);
                    this.binding.doc4uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.blackColor));
                    this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(true);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j14 = j13 / 1024;
                    this.filesize = j14;
                    double dRound7 = Math.round(j14 * 100.0d) / 100.0d;
                    if (dRound7 > 2.0d) {
                        this.binding.doc4DocumentsPage1.setVisibility(8);
                        this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc4Page1str);
                        this.binding.doc4DocumentsPage1.setVisibility(0);
                        this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                        this.binding.doc4DocumentsPage1ImageName.setVisibility(0);
                        this.binding.doc4DocumentsPage1ImageSize.setVisibility(0);
                        this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                        this.binding.doc4uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(false);
                        this.binding.doc4DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.doc4DocumentsPage1ImageSize.setText(dRound7 + getString(R.string.mbMsg));
                    }
                }
            } else if (requestCode == 108) {
                long j15 = this.filesize;
                if (j15 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc4Page2str);
                    this.binding.doc4supportingDocumentsPage2.setVisibility(0);
                    this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(0);
                    this.binding.doc4supportingDocumentsPage2ImageName.setVisibility(0);
                    this.binding.doc4supportingDocumentsPage2ImageSize.setVisibility(0);
                    this.binding.doc4supportingDocumentsPage2Image.setVisibility(0);
                    ImageView imageView5 = this.binding.doc4supportingDocumentsPage2Image;
                    byte[] bArr5 = this.pdfbyteArray;
                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                    this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(false);
                    this.binding.doc4supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.doc4supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                } else if (j15 > 2048) {
                    this.binding.doc4supportingDocumentsPage2.setVisibility(8);
                    this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(8);
                    this.binding.doc4supportingDocumentsPage2ImageName.setVisibility(8);
                    this.binding.doc4supportingDocumentsPage2ImageSize.setVisibility(8);
                    this.binding.doc4supportingDocumentsPage2Image.setVisibility(8);
                    this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.blackColor));
                    this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(true);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                } else {
                    long j16 = j15 / 1024;
                    this.filesize = j16;
                    double dRound8 = Math.round(j16 * 100.0d) / 100.0d;
                    if (dRound8 > 2.0d) {
                        this.binding.doc4supportingDocumentsPage2.setVisibility(8);
                        this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(true);
                        showDialog1(this.alertText, this.imgmsg);
                    } else {
                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc4Page2str);
                        this.binding.doc4supportingDocumentsPage2.setVisibility(0);
                        this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(0);
                        this.binding.doc4supportingDocumentsPage2ImageName.setVisibility(0);
                        this.binding.doc4supportingDocumentsPage2ImageSize.setVisibility(0);
                        this.binding.doc4supportingDocumentsPage2Image.setVisibility(0);
                        ImageView imageView6 = this.binding.doc4supportingDocumentsPage2Image;
                        byte[] bArr6 = this.pdfbyteArray;
                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                        this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(false);
                        this.binding.doc4supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.doc4supportingDocumentsPage2ImageSize.setText(dRound8 + getString(R.string.mbMsg));
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$10(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$10(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
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
                return;
            }
            return;
        }
        if (code == 105) {
            this.doc3Page1url = null;
            this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.doc3DocumentsPage1.setVisibility(8);
            this.binding.doc3DocumentsPage1Image.setVisibility(8);
            this.binding.doc3DocumentsPage1ImageSize.setText("");
            this.binding.doc3DocumentsPage1ImageName.setText("");
            this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc3Page1url) && TextUtils.isEmpty(this.doc3Page2Url)) {
                this.binding.doc3DocumentsPage1.setVisibility(8);
                this.binding.doc3supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 106) {
            this.doc3Page2Url = null;
            this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc3supportingDocumentsPage2.setVisibility(8);
            this.binding.doc3supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc3supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc3supportingDocumentsPage2ImageName.setText("");
            this.binding.doc3cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc3Page1url) && TextUtils.isEmpty(this.doc3Page2Url)) {
                this.binding.doc3DocumentsPage1.setVisibility(8);
                this.binding.doc3supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 107) {
            this.doc4Page1Url = null;
            this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc4supportingDocumentsPage2.setVisibility(8);
            this.binding.doc4supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc4supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc4supportingDocumentsPage2ImageName.setText("");
            this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc4Page1Url) && TextUtils.isEmpty(this.doc4Page2URL)) {
                this.binding.doc4DocumentsPage1.setVisibility(8);
                this.binding.doc4supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 108) {
            this.doc4Page2URL = null;
            this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc4supportingDocumentsPage2.setVisibility(8);
            this.binding.doc4supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc4supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc4supportingDocumentsPage2ImageName.setText("");
            this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc4Page1Url) && TextUtils.isEmpty(this.doc4Page2URL)) {
                this.binding.doc4DocumentsPage1.setVisibility(8);
                this.binding.doc4supportingDocumentsPage2.setVisibility(8);
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
            map2.put("epicNo", this.verifyPayload.getEpicNo());
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d("UncollectableTAG", map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass15(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass15(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r13 = UploadDocumentActivity.this;
                String str = ((UploadDocumentActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$15$$ExternalSyntheticLambda1
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
                        UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                        uploadDocumentActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadDocumentActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UploadDocumentActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo1strNew)) {
                        UploadDocumentActivity.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.relativeDocument1UrlS);
                    }
                    if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo2strNew)) {
                        UploadDocumentActivity.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.relativeDocument2UrlS);
                    }
                    if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo3strNew)) {
                        UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS);
                    }
                    if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo4strNew)) {
                        UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(UploadDocumentActivity.this.doc3Page1str)) {
                        UploadDocumentActivity.this.doc3Page1url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.doc3Page1url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(UploadDocumentActivity.this.doc3Page2str)) {
                        UploadDocumentActivity.this.doc3Page2Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.doc3Page2Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(UploadDocumentActivity.this.doc4Page1str)) {
                        UploadDocumentActivity.this.doc4Page1Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.doc4Page1Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(UploadDocumentActivity.this.doc4Page2str)) {
                        UploadDocumentActivity.this.doc4Page2URL = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UploadDocumentActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UploadDocumentActivity.this.doc4Page2URL);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo1strNew)) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.photo1countNew = 0;
                UploadDocumentActivity.this.binding.enumerationFormPage1.setVisibility(8);
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo2strNew)) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.photo2countNew = 0;
                UploadDocumentActivity.this.binding.enumerationFormPage2.setVisibility(8);
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo3strNew)) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.photo3countNew = 0;
                UploadDocumentActivity.this.binding.supportingDocumentsPage1.setVisibility(8);
                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo4strNew)) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.photo4countNew = 0;
                UploadDocumentActivity.this.binding.supportingDocumentsPage2.setVisibility(8);
                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            UploadDocumentActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                UploadDocumentActivity uploadDocumentActivity2 = UploadDocumentActivity.this;
                uploadDocumentActivity2.showDialog1(uploadDocumentActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r2 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UploadDocumentActivity.this.token = "Bearer " + str8;
            UploadDocumentActivity.this.refreshToken = str9;
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
            uploadDocumentActivity.uploadPhoto(str, str2, str3, str4, str5, uploadDocumentActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent((Context) UploadDocumentActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo1strNew)) {
                if (UploadDocumentActivity.this.photo1countNew < 2 && TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS)) {
                    UploadDocumentActivity.this.photo1countNew++;
                    UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
                    uploadDocumentActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadDocumentActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.photo1countNew = 0;
                    UploadDocumentActivity.this.binding.enumerationFormPage1.setVisibility(8);
                    UploadDocumentActivity uploadDocumentActivity2 = UploadDocumentActivity.this;
                    uploadDocumentActivity2.showDialog1(uploadDocumentActivity2.alertText, UploadDocumentActivity.this.fileNotFoundMessage);
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo2strNew)) {
                if (UploadDocumentActivity.this.photo2countNew < 2 && TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument2UrlS)) {
                    UploadDocumentActivity.this.photo2countNew++;
                    UploadDocumentActivity uploadDocumentActivity3 = UploadDocumentActivity.this;
                    uploadDocumentActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadDocumentActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.photo2countNew = 0;
                    UploadDocumentActivity.this.binding.enumerationFormPage2.setVisibility(8);
                    UploadDocumentActivity uploadDocumentActivity4 = UploadDocumentActivity.this;
                    uploadDocumentActivity4.showDialog1(uploadDocumentActivity4.alertText, UploadDocumentActivity.this.fileNotFoundMessage);
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo3strNew)) {
                if (UploadDocumentActivity.this.photo3countNew < 2 && TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    UploadDocumentActivity.this.photo3countNew++;
                    UploadDocumentActivity uploadDocumentActivity5 = UploadDocumentActivity.this;
                    uploadDocumentActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadDocumentActivity5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.photo3countNew = 0;
                    UploadDocumentActivity.this.binding.supportingDocumentsPage1.setVisibility(8);
                    UploadDocumentActivity uploadDocumentActivity6 = UploadDocumentActivity.this;
                    uploadDocumentActivity6.showDialog1(uploadDocumentActivity6.alertText, UploadDocumentActivity.this.fileNotFoundMessage);
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                    UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(UploadDocumentActivity.this.photo4strNew)) {
                if (UploadDocumentActivity.this.photo4countNew < 2 && TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    UploadDocumentActivity.this.photo4countNew++;
                    UploadDocumentActivity uploadDocumentActivity7 = UploadDocumentActivity.this;
                    uploadDocumentActivity7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, uploadDocumentActivity7.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.photo4countNew = 0;
                UploadDocumentActivity.this.binding.supportingDocumentsPage2.setVisibility(8);
                UploadDocumentActivity uploadDocumentActivity8 = UploadDocumentActivity.this;
                uploadDocumentActivity8.showDialog1(uploadDocumentActivity8.alertText, UploadDocumentActivity.this.fileNotFoundMessage);
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.whitecolor));
                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    private void handledeleteClick() {
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadDocumentActivity.this.binding.firstLL.setVisibility(8);
                UploadDocumentActivity.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                UploadDocumentActivity.this.binding.enumerationFormLayout.setVisibility(0);
                UploadDocumentActivity.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS) && TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument2UrlS)) {
                    UploadDocumentActivity.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                    UploadDocumentActivity.this.binding.fbImageLL.setVisibility(8);
                }
                if (UploadDocumentActivity.this.binding.secondLL.getVisibility() != 8 || TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument2UrlS)) {
                    return;
                }
                UploadDocumentActivity.this.binding.fbImageLL.setVisibility(8);
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadDocumentActivity.this.binding.secondLL.setVisibility(8);
                UploadDocumentActivity.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                UploadDocumentActivity.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS) && TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument2UrlS)) {
                    UploadDocumentActivity.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                    UploadDocumentActivity.this.binding.fbImageLL.setVisibility(8);
                }
                if (UploadDocumentActivity.this.binding.firstLL.getVisibility() == 8 && !TextUtils.isEmpty(UploadDocumentActivity.this.relativeDocument1UrlS)) {
                    UploadDocumentActivity.this.binding.fbImageLL.setVisibility(8);
                }
                UploadDocumentActivity.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadDocumentActivity.this.binding.firstLL1.setVisibility(8);
                UploadDocumentActivity.this.binding.lvSupportChoose1.setVisibility(0);
                UploadDocumentActivity.this.binding.supprtingDocumentsLayout.setVisibility(0);
                UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    UploadDocumentActivity.this.binding.lvSupportChoose2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UploadDocumentActivity.this.binding.secondLL1.setVisibility(8);
                UploadDocumentActivity.this.binding.lvSupportChoose2.setVisibility(0);
                UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(UploadDocumentActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    UploadDocumentActivity.this.binding.lvSupportChoose1.setVisibility(0);
                }
                UploadDocumentActivity.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass20(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass20(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadDocumentActivity.this).load(UploadDocumentActivity.this.preSignedurl1).into(UploadDocumentActivity.this.binding.frontImage);
                }
                if (TextUtils.isEmpty(UploadDocumentActivity.this.preSignedurl1)) {
                    UploadDocumentActivity.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(UploadDocumentActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                    ?? r6 = UploadDocumentActivity.this;
                    String str = ((UploadDocumentActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$20$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag);
                }
            } else {
                try {
                    UploadDocumentActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$20$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadDocumentActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadDocumentActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
            UploadDocumentActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r5 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$20$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadDocumentActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadDocumentActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent((Context) UploadDocumentActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag + t.getMessage());
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
            UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
            uploadDocumentActivity.showDialog1(uploadDocumentActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadDocumentActivity.this).load(UploadDocumentActivity.this.preSignedurl2).into(UploadDocumentActivity.this.binding.backImage);
                }
                if (TextUtils.isEmpty(UploadDocumentActivity.this.preSignedurl2)) {
                    UploadDocumentActivity.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(UploadDocumentActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                    ?? r6 = UploadDocumentActivity.this;
                    String str = ((UploadDocumentActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$21$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag);
                }
            } else {
                try {
                    UploadDocumentActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$21$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadDocumentActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadDocumentActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
            UploadDocumentActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r5 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$21$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadDocumentActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadDocumentActivity.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent((Context) UploadDocumentActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag + t.getMessage());
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
            UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
            uploadDocumentActivity.showDialog1(uploadDocumentActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadDocumentActivity.this).load(UploadDocumentActivity.this.preSignedurl3).into(UploadDocumentActivity.this.binding.frontImage1);
                }
                if (TextUtils.isEmpty(UploadDocumentActivity.this.preSignedurl3)) {
                    UploadDocumentActivity.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(UploadDocumentActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                    ?? r6 = UploadDocumentActivity.this;
                    String str = ((UploadDocumentActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag);
                }
            } else {
                try {
                    UploadDocumentActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$22$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadDocumentActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadDocumentActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
            UploadDocumentActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r5 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadDocumentActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadDocumentActivity.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent((Context) UploadDocumentActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag + t.getMessage());
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
            UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
            uploadDocumentActivity.showDialog1(uploadDocumentActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                UploadDocumentActivity.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(UploadDocumentActivity.this).load(UploadDocumentActivity.this.preSignedurl4).into(UploadDocumentActivity.this.binding.backImage1);
                }
                if (TextUtils.isEmpty(UploadDocumentActivity.this.preSignedurl4)) {
                    UploadDocumentActivity.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(UploadDocumentActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                    ?? r6 = UploadDocumentActivity.this;
                    String str = ((UploadDocumentActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$23$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag);
                }
            } else {
                try {
                    UploadDocumentActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$23$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e("UncollectableTAG", new JSONObject(response.errorBody().string()).optString(UploadDocumentActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UploadDocumentActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
            UploadDocumentActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r5 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$23$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadDocumentActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UploadDocumentActivity.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent((Context) UploadDocumentActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UploadDocumentActivity.this.comingTag + t.getMessage());
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
            UploadDocumentActivity uploadDocumentActivity = UploadDocumentActivity.this;
            uploadDocumentActivity.showDialog1(uploadDocumentActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
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
        if (imageType.equals(this.doc3Page1str)) {
            this.doc3Page1url = "";
            this.binding.doc3DocumentsLayout.setVisibility(0);
            this.binding.doc3DocumentsPage1.setVisibility(8);
            this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.doc3Page2str)) {
            this.doc3Page2Url = "";
            this.binding.doc3DocumentsLayout.setVisibility(0);
            this.binding.doc3supportingDocumentsPage2.setVisibility(8);
            this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(true);
        }
        if (imageType.equals(this.doc4Page1str)) {
            this.doc4Page1Url = "";
            this.binding.doc4DocumentsLayout.setVisibility(0);
            this.binding.doc4DocumentsPage1.setVisibility(8);
            this.binding.doc4uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.doc4Page2str)) {
            this.doc4Page2URL = "";
            this.binding.doc4DocumentsLayout.setVisibility(0);
            this.binding.doc4supportingDocumentsPage2.setVisibility(8);
            this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(UploadDocumentActivity.this.photo1strNew)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.enumerationFormPage1.setVisibility(0);
                                UploadDocumentActivity.this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.enumerationFormPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.photo2strNew)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.enumerationFormPage2.setVisibility(0);
                                UploadDocumentActivity.this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.enumerationFormPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.enumerationFormPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.photo3strNew)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.3
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.supportingDocumentsPage1.setVisibility(0);
                                UploadDocumentActivity.this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.supportingDocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equalsIgnoreCase(UploadDocumentActivity.this.photo4strNew)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.4
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.supportingDocumentsPage2.setVisibility(0);
                                UploadDocumentActivity.this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.supportingDocumentsPage2Image.setImageBitmap(BitmapFactory.decodeByteArray(UploadDocumentActivity.this.pdfbyteArray, 0, UploadDocumentActivity.this.pdfbyteArray.length));
                                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.doc3Page1str)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.5
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.doc3DocumentsPage1.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3DocumentsPage1ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3DocumentsPage1ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.doc3uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.doc3DocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.doc3Page2str)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.6
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.doc3supportingDocumentsPage2.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3cancelSupportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3supportingDocumentsPage2ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3supportingDocumentsPage2ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3supportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc3uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.doc3uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.doc3supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.doc4Page1str)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.7
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.doc4DocumentsPage1.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4DocumentsPage1ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4DocumentsPage1ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4cancelSupportingDocumentsPage1Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.doc4uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.doc4DocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(UploadDocumentActivity.this.doc4Page2str)) {
                        UploadDocumentActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.24.8
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.binding.doc4supportingDocumentsPage2.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4cancelSupportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4supportingDocumentsPage2ImageName.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4supportingDocumentsPage2ImageSize.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4supportingDocumentsPage2Image.setVisibility(0);
                                UploadDocumentActivity.this.binding.doc4uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(UploadDocumentActivity.this.greycolor));
                                UploadDocumentActivity.this.binding.doc4uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(UploadDocumentActivity.this).load(strReplace).into(UploadDocumentActivity.this.binding.doc4supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (UploadDocumentActivity.this.alertDialog != null) {
                                    UploadDocumentActivity.this.alertDialog.dismiss();
                                }
                                UploadDocumentActivity.this.resetImage(uploadType, message);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(UploadDocumentActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    UploadDocumentActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e("UncollectableTAG", e.getMessage());
                    UploadDocumentActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                UploadDocumentActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
            } else {
                AlertDialog alertDialog4 = this.alertDialog;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                this.getImage4Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc3Page1str)) {
            int i5 = this.doc3page1count;
            if (i5 < 2) {
                this.doc3page1count = i5 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog5 = this.alertDialog;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                }
                this.doc3page1count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc3Page2str)) {
            int i6 = this.doc3page2count;
            if (i6 < 2) {
                this.doc3page2count = i6 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog6 = this.alertDialog;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                }
                this.doc3page2count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc4Page1str)) {
            int i7 = this.doc4page1count;
            if (i7 < 2) {
                this.doc4page1count = i7 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog7 = this.alertDialog;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                }
                this.doc4page1count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc4Page2str)) {
            int i8 = this.doc4page2count;
            if (i8 < 2) {
                this.doc4page2count = i8 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog8 = this.alertDialog;
            if (alertDialog8 != null) {
                alertDialog8.dismiss();
            }
            this.doc4page2count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.25
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (UploadDocumentActivity.this.alertDialog != null) {
                        UploadDocumentActivity.this.alertDialog.dismiss();
                    }
                    UploadDocumentActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(UploadDocumentActivity.this.photo1strNew)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.photo2strNew)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.photo3strNew)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.photo4strNew)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.doc3Page1str)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.doc3Page2str)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.doc4Page1str)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(UploadDocumentActivity.this.doc4Page2str)) {
                            UploadDocumentActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$13(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$13(String str, final DownloadCallback downloadCallback) throws Throwable {
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda2
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                UploadDocumentActivity.DownloadCallback downloadCallback2 = downloadCallback;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getDocType() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getDocType(map).enqueue(new AnonymousClass26());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$26, reason: invalid class name */
    class AnonymousClass26 implements Callback<DocTypeRoot> {
        AnonymousClass26() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
        /* JADX WARN: Type inference failed for: r7v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
        /* JADX WARN: Type inference failed for: r7v23, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
        public void onResponse(Call<DocTypeRoot> call, Response<DocTypeRoot> response) {
            if (response.code() == 200) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                String string = UploadDocumentActivity.this.getString(R.string.relative_2003_documentSpinner);
                if (((DocTypeRoot) response.body()).getPayload().isEmpty()) {
                    return;
                }
                UploadDocumentActivity.this.documenttypeList.clear();
                UploadDocumentActivity.this.documenttypeList = (ArrayList) ((DocTypeRoot) response.body()).getPayload();
                UploadDocumentActivity.this.docnameList.clear();
                UploadDocumentActivity.this.docCodeist.clear();
                UploadDocumentActivity.this.docnameList.add(string);
                UploadDocumentActivity.this.docCodeist.add(0);
                for (int i = 0; i < UploadDocumentActivity.this.documenttypeList.size(); i++) {
                    UploadDocumentActivity.this.docnameList.add(UploadDocumentActivity.this.documenttypeList.get(i).getDocName());
                    UploadDocumentActivity.this.docCodeist.add(Integer.valueOf(UploadDocumentActivity.this.documenttypeList.get(i).getDocId()));
                }
                ?? r7 = UploadDocumentActivity.this;
                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r7, R.layout.blo_spinner_dropdown, r7.docnameList);
                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                UploadDocumentActivity.this.binding.documentSpinnerOne.setAdapter((SpinnerAdapter) arrayAdapter);
                UploadDocumentActivity.this.binding.document2Spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                UploadDocumentActivity.this.binding.document3Spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                UploadDocumentActivity.this.binding.document4Spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                return;
            }
            if (response.code() == 401) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                    ?? r8 = UploadDocumentActivity.this;
                    commomUtility.getRefreshToken(r8, ((UploadDocumentActivity) r8).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$26$$ExternalSyntheticLambda0
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
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Logger.e("", jSONObject.optString("message"));
                Utils utils = UploadDocumentActivity.this.utils;
                ?? r1 = UploadDocumentActivity.this;
                utils.infoDialog(r1, r1.getResources().getString(R.string.alertMsg), strOptString);
            } catch (IOException | JSONException e2) {
                if (UploadDocumentActivity.this.alertDialog != null) {
                    UploadDocumentActivity.this.alertDialog.dismiss();
                }
                Utils utils2 = UploadDocumentActivity.this.utils;
                ?? r2 = UploadDocumentActivity.this;
                utils2.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), UploadDocumentActivity.this.getResources().getString(R.string.something_went_wrong));
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
            UploadDocumentActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UploadDocumentActivity.this.commomUtility;
                ?? r5 = UploadDocumentActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity$26$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UploadDocumentActivity.this.token = "Bearer " + str;
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setToken("Bearer " + str);
                UploadDocumentActivity.this.getDocType();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UploadDocumentActivity.this.getApplicationContext()).setLocaleBool(false);
            UploadDocumentActivity.this.startActivity(new Intent(UploadDocumentActivity.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity] */
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
        public void onFailure(Call<DocTypeRoot> call, Throwable t) {
            if (UploadDocumentActivity.this.alertDialog != null) {
                UploadDocumentActivity.this.alertDialog.dismiss();
            }
            Utils utils = UploadDocumentActivity.this.utils;
            ?? r0 = UploadDocumentActivity.this;
            utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), UploadDocumentActivity.this.getResources().getString(R.string.something_went_wrong));
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }

    private void initializeSpinnerTouch() {
        this.binding.documentSpinnerOne.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UploadDocumentActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.document2Spinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UploadDocumentActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.document3Spinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UploadDocumentActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.document4Spinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.UploadDocumentActivity.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UploadDocumentActivity.this.isUserSelected = true;
                return false;
            }
        });
    }
}
