package in.gov.eci.bloapp.views.activity.newsir.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityMigrationFormBinding;
import in.gov.eci.bloapp.pdfDownloadCallback;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.EFPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.MigratedElectors;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
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
public class MigratedElectorsFormActivity extends AppCompatActivity {
    String No;
    private String SESSION;
    private String abbrev;
    int age;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivityMigrationFormBinding binding;
    Bundle bundle;
    byte[] byteArray;
    DatePickerDialog datePickerDialog;
    String dob;
    String dobVerified;
    EFPayload efPayload;
    Long epicId;
    String fatherEpicNo;
    String father_epicNumber;
    String father_oldAcName;
    int father_oldAcNo;
    String father_oldDistName;
    int father_oldDistNo;
    String father_oldFullName;
    String father_oldPartName;
    int father_oldPartNumber;
    int father_oldPartSerialNo;
    String father_oldRelativeFullName;
    String father_oldStateCd;
    String father_oldStateName;
    String father_relationType;
    protected long filesize;
    boolean flag2003;
    FormverificationPayload formverificationPayload;
    String lat;
    String list_epicName;
    String list_epicNo;
    String list_partSerialNo;
    String list_relation_type;
    String list_relation_type_name;
    String list_relationname;
    private LocationRequest locationRequest;
    String longi;
    String mappedType;
    String mime;
    String mobile;
    String motherEpicNo;
    int oldAge;
    private String partNo;
    private byte[] pdfbyteArray;
    ProgressBar progressBar;
    String referenceNo;
    private String refreshToken;
    String relationcode;
    int rlnprgnyoldage;
    private String rtkband;
    protected String saveImageFileName;
    String selectDocumentType;
    String selectRelationType;
    int selectedId;
    String selectedText;
    String self_OldStateCd;
    String self_categoryType;
    String self_oldAcName;
    int self_oldAcNo;
    String self_oldPartName;
    int self_oldPartNumber;
    int self_oldPartSerialNo;
    String self_oldStateName;
    String self_selfOldEpic;
    String self_selfOldName;
    String self_selfOldRlnName;
    String self_selfOldRlnType;
    int selfoldage;
    String sirYearProgeny;
    String sirYearSelf;
    String spinner_relation_type_name;
    String spouseEpicNo;
    private String state;
    String submittedForRecommendation;
    String temp;
    private String token;
    String uploadFlag;
    Utils utils;
    String takephoto = "";
    String choose_front_camera = "";
    String choose_back_camera = "";
    String whitecolor = "#000000";
    private int currentImagePickerId = 0;
    String preRevisonFlag = "N";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String cancel = "Cancel";
    String alertText = "";
    String TAG = "MigratedElectorsFormActivity";
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String isThisYouRelFlag = "N";
    String applicationpdf = "application/pdf";
    private String photoref = null;
    private String annexRef = null;
    String fileNotFoundMessage = "Something went wrong.";
    String functionNameForLogBaseActivity = "";
    String citizenCat = null;
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private String submitFlag = null;
    private boolean result = false;
    boolean onlineStatus = true;
    boolean faceRecognition = true;
    String tabName = "fillTab";
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String garudaTextBaseActivity = "GARUDA";
    private String aadharref = null;
    private String photo1Ref = null;
    private String photo2Ref = null;
    String imageTextBaseActivity = "image";
    String upload = "Please upload file again.";
    final Calendar dobcalendar = Calendar.getInstance();
    String annexureStr = "Annexure";
    String photo1Str = " Photo1 Annexure";
    String photo2str = "Photo2 Annexure";
    String pdfTextBaseActivity = ".pdf";
    String list8code = "";
    String img = "image";
    String jpgTextBaseActivity = ".jpg";
    String invalidaadhar = "";
    String fileNameTextBaseActivity = "fileName";
    String mobileNo = null;
    String fatherName = null;
    String fatherEpic = null;
    String motherName = null;
    String motherEpic = null;
    String spouseName = null;
    String spouseEpic = null;
    String epicNumber = null;
    String serial = null;
    String erollDoB = null;
    String houseNumber = null;
    String erollPhotoURL = null;
    String isLegacy = null;
    String messageString = "message";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    String sessionTokenExpiredPleaseLogin = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    boolean isRequestOTPClicked = false;
    String otp = "";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String from = "";
    String isselected2003 = "";
    boolean isfirsttimeenter = true;
    String view = "";
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;
    String objectStorageString = "objectstorage";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    String packageBundle = "package";
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    File file2 = null;
    File file1 = null;
    String preSignedurl2 = "";
    String preSignedurl1 = "";
    String preSignedurl3 = "";

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMigrationFormBinding activityMigrationFormBindingInflate = ActivityMigrationFormBinding.inflate(getLayoutInflater());
        this.binding = activityMigrationFormBindingInflate;
        setContentView(activityMigrationFormBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.choose_front_camera = getString(R.string.capture_from_front_camera);
        this.choose_back_camera = getString(R.string.capture_from_back_camera);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.utils = new Utils();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        this.isfirsttimeenter = true;
        getCurrentLocation();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        disableView();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda17
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
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = MigratedElectorsFormActivity.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                MigratedElectorsFormActivity.this.isMotherEPICValid = false;
                MigratedElectorsFormActivity.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = MigratedElectorsFormActivity.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                MigratedElectorsFormActivity.this.isFatherEPICValid = false;
                MigratedElectorsFormActivity.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = MigratedElectorsFormActivity.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                MigratedElectorsFormActivity.this.isSpouseEPICValid = false;
                MigratedElectorsFormActivity.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass4());
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.relationNameList = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        this.relationCodeList = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.binding.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    MigratedElectorsFormActivity.this.relationcode = null;
                    MigratedElectorsFormActivity.this.spinner_relation_type_name = "";
                } else {
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.relationcode = migratedElectorsFormActivity.relationCodeList.get(i);
                }
            }
        });
        this.binding.fatherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    MigratedElectorsFormActivity.this.isFatherEPICValid = false;
                    MigratedElectorsFormActivity.this.binding.fatherName.setEnabled(true);
                    MigratedElectorsFormActivity.this.binding.speakFatherName.setClickable(true);
                }
            }
        });
        this.binding.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    MigratedElectorsFormActivity.this.isMotherEPICValid = false;
                    MigratedElectorsFormActivity.this.binding.motherName.setEnabled(true);
                    MigratedElectorsFormActivity.this.binding.speakMotherName.setClickable(true);
                }
            }
        });
        this.binding.spouseEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    MigratedElectorsFormActivity.this.isSpouseEPICValid = false;
                    MigratedElectorsFormActivity.this.binding.spouseName.setEnabled(true);
                    MigratedElectorsFormActivity.this.binding.speakSpouseName.setClickable(true);
                }
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.efPayload = (EFPayload) intent.getParcelableExtra("migratedElectorspayload");
            this.view = intent.getStringExtra("view");
            this.epicNumber = this.efPayload.getEpicNo();
            this.StateList = SharedPref.getInstance(this).getAcListCode(Constants.STATE_LIST_CODE);
            this.StateNameList = SharedPref.getInstance(this).getAcListName(Constants.STATE_LIST_NAME);
            if (!TextUtils.isEmpty(this.view) && this.view.equalsIgnoreCase("Y")) {
                getVerifyCitizenFormListView("A");
            } else {
                getVerifyCitizenFormList("");
            }
        }
        this.binding.photo1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.formverificationPayload.getSrFormPage1Url())) {
                    return;
                }
                if (MigratedElectorsFormActivity.this.formverificationPayload.getSrFormPage1Url().endsWith(".pdf")) {
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.showPersonPdfDialog(migratedElectorsFormActivity.file1, "");
                } else {
                    MigratedElectorsFormActivity migratedElectorsFormActivity2 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity2.showImageDialog(migratedElectorsFormActivity2.preSignedurl1, "");
                }
            }
        });
        this.binding.image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.preSignedurl3)) {
                    return;
                }
                MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                migratedElectorsFormActivity.showImageDialog(migratedElectorsFormActivity.preSignedurl3, "");
            }
        });
        this.binding.photo2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.preSignedurl2)) {
                    return;
                }
                MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                migratedElectorsFormActivity.showImageDialog(migratedElectorsFormActivity.preSignedurl2, "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        initClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.isfirsttimeenter = false;
        this.alertDialog.show();
        getCurrentLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadfrontpagemsg));
        } else {
            pickPhoto(102, "Photo2Form");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            choosseCameraOption();
        } else {
            pickFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (validate()) {
            submit(0);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4, reason: invalid class name */
    class AnonymousClass4 implements TextWatcher {
        AnonymousClass4() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (MigratedElectorsFormActivity.this.binding.aadharNumber.getText().toString().length() == 12) {
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                try {
                    String string = MigratedElectorsFormActivity.this.binding.aadharNumber.getText().toString();
                    MigratedElectorsFormActivity.this.result = Verhoeff.validateVerhoeff(string);
                    if (!MigratedElectorsFormActivity.this.result) {
                        MigratedElectorsFormActivity.this.binding.aadharNumber.setText("");
                        MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                        migratedElectorsFormActivity.showDialog1("", migratedElectorsFormActivity.getString(R.string.aadhaarnoerror));
                        if (MigratedElectorsFormActivity.this.alertDialog != null) {
                            MigratedElectorsFormActivity.this.alertDialog.dismiss();
                        }
                    } else {
                        CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                        ?? r1 = MigratedElectorsFormActivity.this;
                        commomUtility.getaadharref(r1, ((MigratedElectorsFormActivity) r1).state, MigratedElectorsFormActivity.this.token, MigratedElectorsFormActivity.this.binding.aadharNumber.getText().toString(), MigratedElectorsFormActivity.this.atkband, MigratedElectorsFormActivity.this.rtkband, "EfMigration", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str, String str2) {
                                this.f$0.lambda$onTextChanged$5(i, str, str2);
                            }
                        });
                    }
                } catch (Exception e) {
                    Logger.d("", e.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
        public /* synthetic */ void lambda$onTextChanged$5(int i, String str, String str2) {
            if (i == 401) {
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r4 = MigratedElectorsFormActivity.this;
                commomUtility.getRefreshToken(r4, ((MigratedElectorsFormActivity) r4).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.invalidaadhar, str2);
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                MigratedElectorsFormActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            MigratedElectorsFormActivity.this.showDialog1(MigratedElectorsFormActivity.this.alertText + i, str2);
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
        public /* synthetic */ void lambda$onTextChanged$3(int i, String str, String str2) {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r11 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r11, ((MigratedElectorsFormActivity) r11).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
            } else {
                MigratedElectorsFormActivity.this.token = "Bearer " + str;
                MigratedElectorsFormActivity.this.refreshToken = str2;
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str);
                MigratedElectorsFormActivity.this.commomUtility.getaadharref(MigratedElectorsFormActivity.this.getApplicationContext(), MigratedElectorsFormActivity.this.state, MigratedElectorsFormActivity.this.token, MigratedElectorsFormActivity.this.binding.aadharNumber.getText().toString(), MigratedElectorsFormActivity.this.atkband, MigratedElectorsFormActivity.this.rtkband, "EfMigration", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent(MigratedElectorsFormActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.invalidaadhar, str2);
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                MigratedElectorsFormActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$4$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$1();
                    }
                }, 2000L);
                return;
            }
            MigratedElectorsFormActivity.this.showDialog1(MigratedElectorsFormActivity.this.alertText + i, str2);
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean submit(int status) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        this.binding.submitButtonRec.setEnabled(false);
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("self") || this.formverificationPayload.getCategoryType().equalsIgnoreCase("Progeny")) {
            this.submittedForRecommendation = "Y";
        } else if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("na")) {
            this.submittedForRecommendation = "N";
        }
        try {
            Log.d(this.TAG, "eroll dob" + this.dob);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
                this.formverificationPayload.setDobVerified(simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dateOfBirth.getText().toString())));
            }
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.binding.submitButtonRec.setEnabled(true);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.efPayload.getEpicNo());
        map2.put("epicId", this.efPayload.getEpicId());
        map2.put("stCode", this.state);
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", Integer.valueOf(this.efPayload.getPartSerialNo()));
        map2.put("selfOldName", this.formverificationPayload.getSelfOldName());
        map2.put("selfOldEpic", this.formverificationPayload.getSelfOldEpic());
        map2.put("selfOldRlnName", this.formverificationPayload.getSelfOldRlnName());
        map2.put("selfOldRlnType", this.formverificationPayload.getSelfOldRlnType());
        map2.put("rlnPrgyName", this.formverificationPayload.getRlnPrgyName());
        map2.put("rlnPrgyEpic", this.formverificationPayload.getRlnPrgyEpic());
        map2.put("rlnPrgyRlnName", this.formverificationPayload.getRlnPrgyRlnName());
        map2.put("rlnPrgyRlnType", this.formverificationPayload.getRlnPrgyRlnType());
        map2.put("mappingType", this.formverificationPayload.getMappingType());
        map2.put("oldStateCd", this.formverificationPayload.getOldStateCd());
        map2.put("relationOldStateCd", this.formverificationPayload.getRelationOldStateCd());
        map2.put("relationType", this.formverificationPayload.getRelationType());
        map2.put("relationOldAcNo", Integer.valueOf(this.formverificationPayload.getRelationOldAcNo()));
        map2.put("relationOldPartNo", Integer.valueOf(this.formverificationPayload.getRelationOldPartNo()));
        map2.put("relationOldPslNo", Integer.valueOf(this.formverificationPayload.getRelationOldPslNo()));
        map2.put("epicName", this.formverificationPayload.getEpicName());
        map2.put("submittedForRecommendation", this.submittedForRecommendation);
        map2.put("aadharNo", this.formverificationPayload.getAadharNo());
        map2.put("mobileNo", this.formverificationPayload.getMobileNo());
        map2.put("fathersOrGuardianName", this.formverificationPayload.getFatherOrGuardianName());
        map2.put("fathersOrGuardianEpicNo", this.formverificationPayload.getFatherOrGuardianEpicNo());
        map2.put("mothersName", this.formverificationPayload.getMothersName());
        map2.put("mothersEpicNo", this.formverificationPayload.getMothersEpicNo());
        map2.put("spouseName", this.formverificationPayload.getSpouseName());
        map2.put("spouseEpicNo", this.formverificationPayload.getSpouseEpicNo());
        if (!TextUtils.isEmpty(this.photoref)) {
            map2.put("photoUrl", this.photoref);
        } else {
            map2.put("photoUrl", this.formverificationPayload.getPhotoUrl());
        }
        map2.put("srFormPage1Url", this.photo1Ref);
        map2.put("srFormPage2Url", this.photo2Ref);
        map2.put("oldAcNo", Integer.valueOf(this.formverificationPayload.getOldAcNo()));
        map2.put("oldPartNo", Integer.valueOf(this.formverificationPayload.getOldPartNo()));
        map2.put("oldPslNo", Integer.valueOf(this.formverificationPayload.getOldPslNo()));
        map2.put("categoryType", this.formverificationPayload.getCategoryType());
        map2.put("dobVerified", this.formverificationPayload.getDobVerified());
        map2.put("ageValidationFlag", Integer.valueOf(status));
        if (this.formverificationPayload.getRelativeOldAge() != 0) {
            map2.put("relativeOldAge", Integer.valueOf(this.formverificationPayload.getRelativeOldAge()));
        }
        if (this.formverificationPayload.getOldAge() != 0) {
            map2.put("oldAge", Integer.valueOf(this.formverificationPayload.getOldAge()));
        }
        map2.put("sirYearSelf", this.formverificationPayload.getYearOfSirSelf());
        map2.put("sirYearProgeny", this.formverificationPayload.getYearOfSirProgeny());
        map2.put("eflatitude", this.lat);
        map2.put("eflongitude", this.longi);
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).submitSpecialRevisionSurveyPanIndia(this.state.toLowerCase(), map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.12
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        if (MigratedElectorsFormActivity.this.alertDialog != null) {
                            MigratedElectorsFormActivity.this.alertDialog.dismiss();
                        }
                        MigratedElectorsFormActivity.this.binding.submitButtonRec.setEnabled(true);
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                        migratedElectorsFormActivity.showDialog3(migratedElectorsFormActivity.alertText, string);
                        return;
                    }
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    MigratedElectorsFormActivity.this.binding.submitButtonRec.setEnabled(true);
                    MigratedElectorsFormActivity migratedElectorsFormActivity2 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity2.showDialog3("", migratedElectorsFormActivity2.getString(R.string.formSubmittedMsg));
                } catch (Exception e2) {
                    Logger.d("SpecialRevisionDetails", e2.toString());
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    MigratedElectorsFormActivity.this.binding.submitButtonRec.setEnabled(true);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.binding.submitButtonRec.setEnabled(true);
            }
        });
        return false;
    }

    private boolean checkSelfEmpty() {
        return this.self_oldAcNo == 0 || this.self_oldPartNumber == 0 || this.self_oldPartSerialNo == 0 || TextUtils.isEmpty(this.self_OldStateCd);
    }

    private boolean checkProgenyEmpty() {
        return this.father_oldAcNo == 0 || this.father_oldPartNumber == 0 || this.father_oldPartSerialNo == 0 || TextUtils.isEmpty(this.father_oldStateCd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$8(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$8(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) MigratedElectors.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
        finish();
    }

    private void deleteAnnexure(int code) {
        if (code == 102) {
            this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo1Annexure.setEnabled(true);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.photo1Ref = null;
            this.binding.photo1Name.setText("");
            this.binding.photo2Annexure.setVisibility(0);
        }
        if (code == 103) {
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
            this.binding.photo2Layout.setVisibility(8);
            this.photo2Ref = null;
            this.binding.photo2Size.setText("");
            this.binding.photo2Name.setText("");
            this.binding.photo1Annexure.setVisibility(0);
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

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$9(View view) {
        onBackPressed();
    }

    public boolean validate() {
        if (!TextUtils.isEmpty(this.photo1Ref)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = "tempTest_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$10(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$10(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, String listCode) {
        this.currentImagePickerId = code;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.epicNumber.replaceAll("/", "_") + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$11(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$11(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).crop().compress(512).maxResultSize(1028, 1028).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
        new Date();
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str = "img_" + code + this.jpgTextBaseActivity;
            this.saveImageFileName = str;
            Logger.d(this.TAG, str);
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + code + this.pdfTextBaseActivity;
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
        Logger.d(this.TAG, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$12(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$13(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$14(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$13(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$14(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialogSelfProgeny(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialogSelfProgeny$15(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogSelfProgeny$15(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        finish();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:115:0x03a3 A[Catch: Exception -> 0x0591, TRY_ENTER, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x03f1 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0406 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0448 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0463 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0467 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x047d A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x04a9 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x04cf A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x04da A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x04ee A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0514 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0518 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x052e A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0558 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0579 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0586 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v18 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v31 */
    /* JADX WARN: Type inference failed for: r27v32 */
    /* JADX WARN: Type inference failed for: r27v33 */
    /* JADX WARN: Type inference failed for: r27v34 */
    /* JADX WARN: Type inference failed for: r27v35 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r35v1 */
    /* JADX WARN: Type inference failed for: r35v11 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v13 */
    /* JADX WARN: Type inference failed for: r35v14 */
    /* JADX WARN: Type inference failed for: r35v15 */
    /* JADX WARN: Type inference failed for: r35v16 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v3 */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARN: Type inference failed for: r35v7 */
    /* JADX WARN: Type inference failed for: r35v8 */
    /* JADX WARN: Type inference failed for: r35v9 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.Context, androidx.appcompat.app.AppCompatActivity, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r35;
        ?? r27;
        String str;
        Uri uri;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        long j;
        ?? r13;
        double dRound;
        File file;
        Uri uri2;
        ?? r36;
        ?? r28;
        ?? r37;
        ?? r29;
        Object obj;
        ?? r15;
        Object obj2;
        ?? r16;
        ?? r38;
        Object obj3;
        ?? r17;
        String str2;
        Object obj4;
        int i3 = i2;
        super.onActivityResult(i, i2, intent);
        ?? r18 = 80;
        if (i3 != -1) {
            r35 = "KB";
            i3 = i;
            r27 = "img_";
            str = "/";
            if (i3 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.binding.photo1Annexure.setVisibility(0);
                this.binding.photo2Annexure.setVisibility(0);
            }
            uri = null;
        } else {
            Uri data = i == 10001 ? null : intent.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.pdfbyteArray = byteArray;
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp);
                r28 = saveImagePath2;
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(r28, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                    String str3 = strArrSplit2[strArrSplit2.length - 1];
                    if (i != 101) {
                        uri2 = data;
                        str2 = "KB";
                        obj4 = "img_";
                        str = "/";
                        i3 = i;
                        if (i3 == 102) {
                            try {
                                r17 = str2;
                                obj2 = obj4;
                                long j2 = this.filesize;
                                if (j2 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                    this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                    if (this.filesize != 0) {
                                        this.binding.photo2Size.setText(this.filesize + str2);
                                        r17 = str2;
                                        obj2 = obj4;
                                    } else {
                                        this.binding.photo2Size.setVisibility(8);
                                        r17 = str2;
                                        obj2 = obj4;
                                    }
                                } else if (j2 > 2048) {
                                    this.binding.photo2Layout.setVisibility(8);
                                    this.binding.cancelPhoto2Annexure.setVisibility(8);
                                    this.binding.photo2Name.setVisibility(8);
                                    this.binding.photo2Size.setVisibility(8);
                                    this.binding.photo2.setVisibility(8);
                                    this.binding.photo2Annexure.setEnabled(true);
                                    this.binding.photo1Annexure.setVisibility(0);
                                    this.binding.photo2Annexure.setVisibility(0);
                                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                                    r17 = str2;
                                    obj2 = obj4;
                                } else {
                                    long j3 = j2 / 1024;
                                    this.filesize = j3;
                                    double dRound2 = Math.round(j3 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.photo2Annexure.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r17 = str2;
                                        obj2 = obj4;
                                    } else {
                                        String str4 = str2;
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                        if (dRound2 != 0.0d) {
                                            this.binding.photo2Size.setText(dRound2 + "MB");
                                            obj3 = obj4;
                                            r38 = str4;
                                        } else {
                                            this.binding.photo2Size.setVisibility(8);
                                            obj3 = obj4;
                                            r38 = str4;
                                        }
                                    }
                                }
                                r17 = str2;
                                obj2 = obj4;
                                r38 = r17;
                                obj3 = obj2;
                            } catch (Exception e) {
                                e = e;
                                r16 = str2;
                                r28 = obj4;
                                r36 = r16;
                                Logger.d("", e.getMessage());
                                r29 = r28;
                                r37 = r36;
                            }
                        } else {
                            r17 = str2;
                            obj2 = obj4;
                            r38 = r17;
                            obj3 = obj2;
                        }
                        cursorQuery2.close();
                        r29 = obj3;
                        r37 = r38;
                    } else {
                        try {
                            long j4 = this.filesize;
                            try {
                                if (j4 < 1024) {
                                    try {
                                        uri2 = data;
                                        str = "/";
                                        String str5 = "KB";
                                        try {
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                            this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                            if (this.filesize != 0) {
                                                String str6 = str5;
                                                this.binding.photo1Size.setText(this.filesize + str6);
                                                r15 = str6;
                                            } else {
                                                r15 = str5;
                                                this.binding.photo1Size.setVisibility(8);
                                            }
                                            i3 = i;
                                            obj2 = "img_";
                                            r17 = r15;
                                        } catch (Exception e2) {
                                            e = e2;
                                            i3 = i;
                                            r28 = "img_";
                                            r36 = str5;
                                            Logger.d("", e.getMessage());
                                            r29 = r28;
                                            r37 = r36;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        uri2 = data;
                                        r18 = "KB";
                                        str = "/";
                                        i3 = i;
                                        r28 = "img_";
                                        r16 = r18;
                                        r36 = r16;
                                    }
                                } else {
                                    uri2 = data;
                                    r18 = "KB";
                                    str = "/";
                                    if (j4 > 2048) {
                                        try {
                                            this.binding.annexPage1Layout.setVisibility(8);
                                            this.binding.cancelPhoto1Annexure.setVisibility(8);
                                            this.binding.photo1Name.setVisibility(8);
                                            this.binding.photo1Size.setVisibility(8);
                                            this.binding.photo1.setVisibility(8);
                                            this.binding.photo1Annexure.setEnabled(true);
                                            this.binding.photo1Annexure.setVisibility(0);
                                            this.binding.photo2Annexure.setVisibility(0);
                                            showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                                            r15 = r18;
                                            i3 = i;
                                            obj2 = "img_";
                                            r17 = r15;
                                        } catch (Exception e4) {
                                            e = e4;
                                            i3 = i;
                                            r28 = "img_";
                                            r16 = r18;
                                            r36 = r16;
                                            Logger.d("", e.getMessage());
                                            r29 = r28;
                                            r37 = r36;
                                        }
                                    } else {
                                        try {
                                            long j5 = j4 / 1024;
                                            this.filesize = j5;
                                            double dRound3 = Math.round(j5 * 100.0d) / 100.0d;
                                            if (dRound3 > 2.0d) {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.photo1Annexure.setEnabled(true);
                                                showDialog1(this.alertText, this.imgmsg);
                                                obj = "img_";
                                            } else {
                                                try {
                                                    obj = "img_";
                                                    try {
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                            if (dRound3 != 0.0d) {
                                                                this.binding.photo1Size.setText(dRound3 + "MB");
                                                            } else {
                                                                this.binding.photo1Size.setVisibility(8);
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            i3 = i;
                                                            r16 = r18;
                                                            r28 = obj;
                                                            r36 = r16;
                                                            Logger.d("", e.getMessage());
                                                            r29 = r28;
                                                            r37 = r36;
                                                        }
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        i3 = i;
                                                        r16 = r18;
                                                        r28 = obj;
                                                        r36 = r16;
                                                        Logger.d("", e.getMessage());
                                                        r29 = r28;
                                                        r37 = r36;
                                                        uri = uri2;
                                                        r27 = r29;
                                                        r35 = r37;
                                                        if (i3 != 100) {
                                                        }
                                                        try {
                                                            if (i3 == 10001) {
                                                                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                                this.saveImageFileName = ((String) r27) + this.temp + this.jpgTextBaseActivity;
                                                                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                                if (file.exists()) {
                                                                    Log.e("extract", "extract true");
                                                                }
                                                                BitmapFactory.decodeFile(file.getAbsolutePath());
                                                                this.filesize = file.length() / 1024;
                                                            } else {
                                                                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                                                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                                bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                                                                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                                                this.byteArray = byteArray2;
                                                                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray2, 0), this.img, this.temp);
                                                            }
                                                            cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                            if (cursorQuery.getCount() > 0) {
                                                                cursorQuery.close();
                                                                throw new IllegalArgumentException(this.imgmsg);
                                                            }
                                                            cursorQuery.moveToFirst();
                                                            strArrSplit = saveImagePath.getPath().split(str);
                                                            Log.e("extract", strArrSplit[strArrSplit.length - 1]);
                                                            j = this.filesize;
                                                            if (j < 1024) {
                                                                if (this.faceRecognition) {
                                                                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                } else {
                                                                    this.alertDialog.dismiss();
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                }
                                                                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                if (this.filesize != 0) {
                                                                    this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                                                                    this.binding.photoSize.setVisibility(0);
                                                                } else {
                                                                    this.binding.photoSize.setVisibility(8);
                                                                }
                                                            } else {
                                                                r13 = r35;
                                                                long j6 = j / 1024;
                                                                this.filesize = j6;
                                                                dRound = Math.round(j6 * 100.0d) / 100.0d;
                                                                if (dRound > 2.0d) {
                                                                    this.binding.passPhotoLayout.setVisibility(8);
                                                                    this.binding.chooseFileTv.setEnabled(true);
                                                                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    if (this.faceRecognition) {
                                                                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    } else {
                                                                        this.alertDialog.dismiss();
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    }
                                                                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                    if (dRound != 0.0d) {
                                                                        this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r13).toString());
                                                                        this.binding.photoSize.setVisibility(0);
                                                                    } else {
                                                                        this.binding.photoSize.setVisibility(8);
                                                                    }
                                                                }
                                                            }
                                                            cursorQuery.close();
                                                        } catch (Exception e7) {
                                                            Logger.d("tag", e7.getMessage());
                                                            return;
                                                        }
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    obj = "img_";
                                                }
                                            }
                                            i3 = i;
                                            r17 = r18;
                                            obj2 = obj;
                                        } catch (Exception e9) {
                                            e = e9;
                                            obj = "img_";
                                        }
                                    }
                                }
                                r17 = str2;
                                obj2 = obj4;
                                r38 = r17;
                                obj3 = obj2;
                                cursorQuery2.close();
                                r29 = obj3;
                                r37 = r38;
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            uri2 = data;
                            r18 = "KB";
                            obj = "img_";
                            str = "/";
                        }
                    }
                    uri = uri2;
                    r27 = r29;
                    r35 = r37;
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                uri2 = data;
                r36 = "KB";
                i3 = i;
                r28 = "img_";
                str = "/";
            }
            Logger.d("", e.getMessage());
            r29 = r28;
            r37 = r36;
            uri = uri2;
            r27 = r29;
            r35 = r37;
        }
        if ((i3 != 100 || i3 == 10001) && i2 == -1) {
            if (i3 == 10001) {
                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                this.saveImageFileName = ((String) r27) + this.temp + this.jpgTextBaseActivity;
                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                if (file.exists()) {
                    Log.e("extract", "extract true");
                }
                BitmapFactory.decodeFile(file.getAbsolutePath());
                this.filesize = file.length() / 1024;
            } else {
                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                bitmap3.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream3);
                byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
                this.byteArray = byteArray3;
                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray3, 0), this.img, this.temp);
            }
            cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            strArrSplit = saveImagePath.getPath().split(str);
            Log.e("extract", strArrSplit[strArrSplit.length - 1]);
            j = this.filesize;
            if (j < 1024) {
                if (this.faceRecognition) {
                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                } else {
                    this.alertDialog.dismiss();
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                }
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                if (this.filesize != 0) {
                    this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                    this.binding.photoSize.setVisibility(0);
                } else {
                    this.binding.photoSize.setVisibility(8);
                }
            } else {
                r13 = r35;
                long j7 = j / 1024;
                this.filesize = j7;
                dRound = Math.round(j7 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.passPhotoLayout.setVisibility(8);
                    this.binding.chooseFileTv.setEnabled(true);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                    showDialog1(this.alertText, this.imgmsg);
                } else {
                    if (this.faceRecognition) {
                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    }
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    if (dRound != 0.0d) {
                        this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r13).toString());
                        this.binding.photoSize.setVisibility(0);
                    } else {
                        this.binding.photoSize.setVisibility(8);
                    }
                }
            }
            cursorQuery.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        Call<JsonObject> callFaceRecognitionApi = restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType")));
        this.alertDialog.show();
        callFaceRecognitionApi.enqueue(new AnonymousClass13(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass13(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                Context applicationContext = MigratedElectorsFormActivity.this.getApplicationContext();
                String str = MigratedElectorsFormActivity.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$13$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(MigratedElectorsFormActivity.this.photostr)) {
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, migratedElectorsFormActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(0);
                MigratedElectorsFormActivity.this.binding.chooseFileTv.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.whitecolor));
                new JSONObject(response.errorBody().string());
                MigratedElectorsFormActivity migratedElectorsFormActivity2 = MigratedElectorsFormActivity.this;
                migratedElectorsFormActivity2.showDialog1(migratedElectorsFormActivity2.alertText, MigratedElectorsFormActivity.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r2 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r2, ((MigratedElectorsFormActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
                return;
            }
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
            MigratedElectorsFormActivity.this.token = "Bearer " + str8;
            MigratedElectorsFormActivity.this.refreshToken = str9;
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.faceRecognition(str, str2, str3, str4, str5, migratedElectorsFormActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent(MigratedElectorsFormActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(8);
            MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(8);
            MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(0);
            MigratedElectorsFormActivity.this.binding.chooseFileTv.setEnabled(true);
            MigratedElectorsFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.alertText, t.getMessage());
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
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
            String mD5Checksum = UploadWithPreSignedURL.getMD5Checksum(new File(filepath + captureFileName));
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.epicNumber);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass14(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$14, reason: invalid class name */
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v26, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r13 = MigratedElectorsFormActivity.this;
                String str = ((MigratedElectorsFormActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$14$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
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
                        MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                        migratedElectorsFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, migratedElectorsFormActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UploadWithPreSignedURL.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photostr)) {
                        MigratedElectorsFormActivity.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        MigratedElectorsFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, MigratedElectorsFormActivity.this.photoref);
                    }
                    if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo1Str)) {
                        MigratedElectorsFormActivity.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        MigratedElectorsFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, MigratedElectorsFormActivity.this.photo1Ref);
                    }
                    if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo2str)) {
                        MigratedElectorsFormActivity.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        MigratedElectorsFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, MigratedElectorsFormActivity.this.photo2Ref);
                    }
                    Logger.d(MigratedElectorsFormActivity.this.TAG, "Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    MigratedElectorsFormActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photostr)) {
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.photocount = 0;
                MigratedElectorsFormActivity.this.binding.chooseFileTv.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(0);
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo1Str)) {
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.photo1count = 0;
                MigratedElectorsFormActivity.this.binding.annexPage1Layout.setVisibility(8);
                MigratedElectorsFormActivity.this.binding.photo1Annexure.setEnabled(true);
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo2str)) {
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.photo2count = 0;
                MigratedElectorsFormActivity.this.binding.photo2Annexure.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.photo2Layout.setVisibility(8);
            }
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                Logger.d("", jSONObject2.toString());
                String string = jSONObject2.getString("message");
                MigratedElectorsFormActivity migratedElectorsFormActivity2 = MigratedElectorsFormActivity.this;
                migratedElectorsFormActivity2.showDialog1(migratedElectorsFormActivity2.alertText, string);
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r2 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r2, ((MigratedElectorsFormActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$14$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
            MigratedElectorsFormActivity.this.token = "Bearer " + str8;
            MigratedElectorsFormActivity.this.refreshToken = str9;
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.uploadPhoto(str, str2, str3, str4, str5, migratedElectorsFormActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent((Context) MigratedElectorsFormActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photostr)) {
                if (MigratedElectorsFormActivity.this.photocount < 2 && TextUtils.isEmpty(MigratedElectorsFormActivity.this.photoref)) {
                    MigratedElectorsFormActivity.this.photocount++;
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, migratedElectorsFormActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    MigratedElectorsFormActivity.this.photocount = 0;
                    MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                    MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(0);
                    MigratedElectorsFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.whitecolor));
                    MigratedElectorsFormActivity.this.binding.chooseFileTv.setEnabled(true);
                    MigratedElectorsFormActivity migratedElectorsFormActivity2 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity2.showDialog1(migratedElectorsFormActivity2.alertText, MigratedElectorsFormActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo1Str)) {
                if (MigratedElectorsFormActivity.this.photo1count < 2 && TextUtils.isEmpty(MigratedElectorsFormActivity.this.photo1Ref)) {
                    MigratedElectorsFormActivity.this.photo1count++;
                    MigratedElectorsFormActivity migratedElectorsFormActivity3 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, migratedElectorsFormActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    MigratedElectorsFormActivity.this.photo1count = 0;
                    MigratedElectorsFormActivity.this.binding.annexPage1Layout.setVisibility(8);
                    MigratedElectorsFormActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.blackColor));
                    MigratedElectorsFormActivity.this.binding.photo1Annexure.setEnabled(true);
                    MigratedElectorsFormActivity migratedElectorsFormActivity4 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity4.showDialog1(migratedElectorsFormActivity4.alertText, MigratedElectorsFormActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(MigratedElectorsFormActivity.this.photo2str)) {
                if (MigratedElectorsFormActivity.this.photo2count < 2 && TextUtils.isEmpty(MigratedElectorsFormActivity.this.photo2Ref)) {
                    MigratedElectorsFormActivity.this.photo2count++;
                    MigratedElectorsFormActivity migratedElectorsFormActivity5 = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, migratedElectorsFormActivity5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                MigratedElectorsFormActivity.this.photo2count = 0;
                MigratedElectorsFormActivity.this.binding.photo2Layout.setVisibility(8);
                MigratedElectorsFormActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.blackColor));
                MigratedElectorsFormActivity.this.binding.photo2Annexure.setEnabled(true);
                MigratedElectorsFormActivity migratedElectorsFormActivity6 = MigratedElectorsFormActivity.this;
                migratedElectorsFormActivity6.showDialog1(migratedElectorsFormActivity6.alertText, MigratedElectorsFormActivity.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$16(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$16(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkEpicNumber(String epicEditText, String from) {
        HashMap map = new HashMap();
        map.put("epicNumber", epicEditText);
        CommomUtility commomUtility = new CommomUtility();
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass15(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass15(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v31, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
            String asString = "";
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                JsonArray jsonArray = (JsonArray) response.body();
                JsonElement jsonElement = jsonArray.get(0).getAsJsonObject().get("content");
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    return;
                }
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                String asString2 = (!asJsonObject.has("applicantFirstName") || asJsonObject.get("applicantFirstName").isJsonNull()) ? "" : asJsonObject.get("applicantFirstName").getAsString();
                if (asJsonObject.has("applicantLastName") && !asJsonObject.get("applicantLastName").isJsonNull()) {
                    asString = asJsonObject.get("applicantLastName").getAsString();
                }
                String str = asString2 + StringUtils.SPACE + asString;
                Logger.d(MigratedElectorsFormActivity.this.TAG, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                Toast.makeText((Context) MigratedElectorsFormActivity.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    MigratedElectorsFormActivity.this.isMotherEPICValid = true;
                    MigratedElectorsFormActivity.this.binding.motherName.setText(str);
                    MigratedElectorsFormActivity.this.binding.motherName.setEnabled(false);
                    MigratedElectorsFormActivity.this.binding.speakMotherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    MigratedElectorsFormActivity.this.isFatherEPICValid = true;
                    MigratedElectorsFormActivity.this.binding.fatherName.setText(str);
                    MigratedElectorsFormActivity.this.binding.fatherName.setEnabled(false);
                    MigratedElectorsFormActivity.this.binding.speakFatherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Spouse")) {
                    MigratedElectorsFormActivity.this.isSpouseEPICValid = true;
                    MigratedElectorsFormActivity.this.binding.spouseName.setText(str);
                    MigratedElectorsFormActivity.this.binding.spouseName.setEnabled(false);
                    MigratedElectorsFormActivity.this.binding.speakSpouseName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Relative")) {
                    MigratedElectorsFormActivity.this.isRelativeEPICValid = true;
                    return;
                }
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r11 = MigratedElectorsFormActivity.this;
                String str2 = ((MigratedElectorsFormActivity) r11).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str3 = this.val$epicEditText;
                final String str4 = this.val$from;
                commomUtility.getRefreshToken(r11, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$15$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str3, str4, i, str5, str6);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                MigratedElectorsFormActivity.this.binding.motherEpicNumber.setText("");
                MigratedElectorsFormActivity.this.binding.motherName.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.speakMotherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                MigratedElectorsFormActivity.this.binding.fatherEpicNumber.setText("");
                MigratedElectorsFormActivity.this.binding.fatherName.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.speakFatherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                MigratedElectorsFormActivity.this.binding.spouseEpicNumber.setText("");
                MigratedElectorsFormActivity.this.binding.spouseName.setEnabled(true);
                MigratedElectorsFormActivity.this.binding.speakSpouseName.setClickable(true);
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(MigratedElectorsFormActivity.this.messageString);
                Logger.d(MigratedElectorsFormActivity.this.TAG, strOptString);
                Toast.makeText((Context) MigratedElectorsFormActivity.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(MigratedElectorsFormActivity.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) MigratedElectorsFormActivity.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r10 = MigratedElectorsFormActivity.this;
                    Toast.makeText((Context) r10, r10.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(MigratedElectorsFormActivity.this.TAG, MigratedElectorsFormActivity.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                ?? r5 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$15$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            MigratedElectorsFormActivity.this.token = MigratedElectorsFormActivity.this.bearerText + str3;
            MigratedElectorsFormActivity.this.refreshToken = str4;
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken(MigratedElectorsFormActivity.this.bearerText + str3);
            MigratedElectorsFormActivity.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent((Context) MigratedElectorsFormActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(MigratedElectorsFormActivity.this.TAG, t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpeakText(final EditText editText) {
        this.utils.showVoicePopup(this, new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.16
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
            public void onCallBack(String result) {
                editText.setText(result);
            }
        });
    }

    public void resetImage(String imagetyype, String error) {
        if (imagetyype.equals(this.photostr)) {
            this.photoref = "";
            this.binding.image.setVisibility(8);
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
        }
        if (imagetyype.equals(this.photo1Str)) {
            this.photo1Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Annexure.setVisibility(0);
            this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo1Annexure.setEnabled(true);
        }
        if (imagetyype.equals(this.photo2str)) {
            this.photo2Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.photo2Layout.setVisibility(8);
            this.binding.photo2Annexure.setVisibility(0);
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.17
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(MigratedElectorsFormActivity.this.photostr)) {
                        MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(8);
                        MigratedElectorsFormActivity.this.binding.cancel.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.greycolor));
                        MigratedElectorsFormActivity.this.binding.chooseFileTv.setEnabled(false);
                        MigratedElectorsFormActivity.this.binding.photoNameTv2.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.image.setVisibility(0);
                        Glide.with(MigratedElectorsFormActivity.this).load(strReplace).into(MigratedElectorsFormActivity.this.binding.image);
                    }
                    if (uploadType.equals(MigratedElectorsFormActivity.this.photo1Str)) {
                        MigratedElectorsFormActivity.this.binding.annexPage1Layout.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.cancelPhoto1Annexure.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo1Name.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo1Size.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo1.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.greycolor));
                        MigratedElectorsFormActivity.this.binding.photo1Annexure.setEnabled(false);
                        Glide.with(MigratedElectorsFormActivity.this).load(strReplace).listener(new RequestListener<Drawable>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.17.1
                            public /* bridge */ /* synthetic */ boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                                return onResourceReady((Drawable) resource, model, (Target<Drawable>) target, dataSource, isFirstResource);
                            }

                            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                Log.e("Glide", "Load failed for: " + model, e);
                                if (e == null || e.getRootCauses() == null) {
                                    return false;
                                }
                                for (Throwable th : e.getRootCauses()) {
                                    Log.e("Glide", "Cause: " + th.getMessage(), th);
                                }
                                return false;
                            }

                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                Log.d("Glide", "Loaded OK from " + dataSource + " : " + model);
                                return false;
                            }
                        }).error(R.drawable.blo_ic_baseline_error_24).placeholder(R.drawable.blo_dummy_image).into(MigratedElectorsFormActivity.this.binding.photo1);
                    }
                    if (uploadType.equals(MigratedElectorsFormActivity.this.photo2str)) {
                        MigratedElectorsFormActivity.this.binding.photo2Layout.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.cancelPhoto2Annexure.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo2Name.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo2Size.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo2.setVisibility(0);
                        MigratedElectorsFormActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(MigratedElectorsFormActivity.this.greycolor));
                        MigratedElectorsFormActivity.this.binding.photo2Annexure.setEnabled(false);
                        Glide.with(MigratedElectorsFormActivity.this).load(strReplace).into(MigratedElectorsFormActivity.this.binding.photo2);
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(MigratedElectorsFormActivity.this.messageString);
                    Logger.e(MigratedElectorsFormActivity.this.TAG, strOptString);
                    MigratedElectorsFormActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e.getMessage());
                    MigratedElectorsFormActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                MigratedElectorsFormActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
        if (uploadType.equalsIgnoreCase(this.photo1Str)) {
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
        if (uploadType.equalsIgnoreCase(this.photo2str)) {
            int i3 = this.getImage3Count;
            if (i3 < 2) {
                this.getImage3Count = i3 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog3 = this.alertDialog;
            if (alertDialog3 != null) {
                alertDialog3.dismiss();
            }
            this.getImage3Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.18
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    MigratedElectorsFormActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(MigratedElectorsFormActivity.this.photostr)) {
                            MigratedElectorsFormActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(MigratedElectorsFormActivity.this.photo1Str)) {
                            MigratedElectorsFormActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(MigratedElectorsFormActivity.this.photo2str)) {
                            MigratedElectorsFormActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.19
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(MigratedElectorsFormActivity.this).removeLocationUpdates(this);
                        if (locationResult != null && !locationResult.getLocations().isEmpty()) {
                            int size = locationResult.getLocations().size() - 1;
                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                            MigratedElectorsFormActivity.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                            MigratedElectorsFormActivity.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                            Logger.d("latitude and longitudezz", MigratedElectorsFormActivity.this.lat + "  " + MigratedElectorsFormActivity.this.longi);
                            if (MigratedElectorsFormActivity.this.isfirsttimeenter) {
                                return;
                            }
                            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                                MigratedElectorsFormActivity.this.alertDialog.dismiss();
                            }
                            MigratedElectorsFormActivity.this.pickPhoto(101, "photo1Form");
                            return;
                        }
                        Toast.makeText((Context) MigratedElectorsFormActivity.this, (CharSequence) "Unable to fetch location. Please try again.", 0).show();
                    }
                }, Looper.getMainLooper());
                return;
            }
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            turnOnGPS();
            return;
        }
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda15
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$17(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$17(Task task) {
        try {
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException e2) {
                Logger.d("", e2.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == 0) {
            if (requestCode == 1) {
                this.isfirsttimeenter = false;
                this.alertDialog.show();
                getCurrentLocation();
                return;
            }
            return;
        }
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.isfirsttimeenter) {
            return;
        }
        checkLocationPermission();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkLocationPermission() {
        new android.app.AlertDialog.Builder(this).setTitle("request Permission").setMessage("Kindly Allow Location Permission").setCancelable(false).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkLocationPermission$18(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationPermission$18(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, getPackageName(), null));
        startActivity(intent);
    }

    public void disableView() {
        this.binding.dateOfBirth.setEnabled(false);
        this.binding.dateOfBirth.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.aadharNumber.setEnabled(false);
        this.binding.aadharNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.mobileNumber.setEnabled(false);
        this.binding.mobileNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.fatherEpicNumber.setEnabled(false);
        this.binding.fatherEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchFather.setEnabled(false);
        this.binding.ivSearchFather.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.fatherName.setEnabled(false);
        this.binding.fatherName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.motherEpicNumber.setEnabled(false);
        this.binding.motherEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchMother.setEnabled(false);
        this.binding.ivSearchMother.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.motherName.setEnabled(false);
        this.binding.motherName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.spouseEpicNumber.setEnabled(false);
        this.binding.spouseEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchSpouse.setEnabled(false);
        this.binding.ivSearchSpouse.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.spouseName.setEnabled(false);
        this.binding.spouseName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.progenyRelationSpinner.setEnabled(false);
        this.binding.progenyRelationSpinner.setBackgroundColor(getColor(R.color.disable_grey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setValues() {
        if (!TextUtils.isEmpty(this.view)) {
            if (this.view.equalsIgnoreCase("Y")) {
                this.binding.submitLayout.setVisibility(8);
                this.binding.photo1Annexure.setEnabled(false);
                this.binding.photo2Annexure.setEnabled(false);
                this.binding.chooseFileTv.setEnabled(false);
                if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url())) {
                    this.binding.annexPage1Layout.setVisibility(0);
                    this.binding.cancelPhoto1Annexure.setVisibility(8);
                    getFile1(this.formverificationPayload.getSrFormPage1Url());
                }
                if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage2Url())) {
                    this.binding.photo2Layout.setVisibility(0);
                    this.binding.cancelPhoto2Annexure.setVisibility(8);
                    getFilePage2(this.formverificationPayload.getSrFormPage2Url());
                }
                if (!TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl())) {
                    this.binding.cancel.setVisibility(8);
                    this.binding.photoNameTv2.setVisibility(8);
                    this.binding.photoSize.setVisibility(8);
                    getFile3(this.formverificationPayload.getPhotoUrl());
                } else {
                    this.binding.passPhoto.setVisibility(0);
                    this.binding.passPhotoLayout.setVisibility(8);
                }
            } else if (!TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl())) {
                this.binding.cancel.setVisibility(0);
                this.binding.photoNameTv2.setVisibility(8);
                this.binding.photoSize.setVisibility(8);
                getFile3(this.formverificationPayload.getPhotoUrl());
            } else {
                this.binding.passPhoto.setVisibility(0);
                this.binding.passPhotoLayout.setVisibility(8);
            }
        } else if (!TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl())) {
            this.binding.cancel.setVisibility(0);
            this.binding.photoNameTv2.setVisibility(8);
            this.binding.photoSize.setVisibility(8);
            getFile3(this.formverificationPayload.getPhotoUrl());
        } else {
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
        }
        this.binding.includeCurrentDetails.electorNamePendingSir.setText(TextUtils.isEmpty(this.efPayload.getName()) ? "" : this.efPayload.getName());
        this.binding.includeCurrentDetails.epicPendingSir.setText(TextUtils.isEmpty(this.efPayload.getEpicNo()) ? "" : this.efPayload.getEpicNo());
        this.binding.includeCurrentDetails.agePendingSir.setText(String.valueOf(this.efPayload.getCurrentAge()));
        this.binding.includeCurrentDetails.relativeNamePendingSir.setText(this.efPayload.getRelativeFullName());
        setRelativeType(this.efPayload.getRelationType(), this.binding.includeCurrentDetails.relativeTypePendingSir);
        this.binding.includeCurrentDetails.serialNoPendingSir.setText(String.valueOf(this.efPayload.getPartSerialNo()));
        if (!TextUtils.isEmpty(this.formverificationPayload.getDobVerified())) {
            try {
                String str = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this.formverificationPayload.getDobVerified()));
                this.dobVerified = str;
                this.formverificationPayload.setDobVerified(str);
            } catch (Exception e) {
                Logger.d("Date replace", e.toString());
            }
        }
        this.binding.dateOfBirth.setText(TextUtils.isEmpty(this.formverificationPayload.getDobVerified()) ? "" : this.formverificationPayload.getDobVerified());
        this.binding.mobileNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMobileNo()) ? "" : this.formverificationPayload.getMobileNo());
        this.binding.fatherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianEpicNo()) ? "" : this.formverificationPayload.getFatherOrGuardianEpicNo());
        this.binding.fatherName.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianName()) ? "" : this.formverificationPayload.getFatherOrGuardianName());
        this.binding.motherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersEpicNo()) ? "" : this.formverificationPayload.getMothersEpicNo());
        this.binding.motherName.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersName()) ? "" : this.formverificationPayload.getMothersName());
        this.binding.motherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersEpicNo()) ? "" : this.formverificationPayload.getMothersEpicNo());
        this.binding.spouseEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseEpicNo()) ? "" : this.formverificationPayload.getSpouseEpicNo());
        this.binding.spouseName.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseName()) ? "" : this.formverificationPayload.getSpouseName());
        this.binding.progenyRelationSpinner.setSelection(this.relationCodeList.indexOf(this.formverificationPayload.getRelationType()));
        if (TextUtils.isEmpty(this.formverificationPayload.getAadharNo())) {
            this.binding.aadharNumber.setText("");
        } else {
            this.commomUtility.getaadhar1(this, this.state, this.token, this.formverificationPayload.getAadharNo(), this.atkband, this.rtkband, "EfMigration", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.MultipleString
                public final void onCallBack(String str2, String str3) {
                    this.f$0.lambda$setValues$19(str2, str3);
                }
            });
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("progeny")) {
            this.binding.selfCardView.setVisibility(8);
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("NA")) {
            this.binding.selfCardView.setVisibility(8);
            this.binding.relativeCardView.setVisibility(8);
            this.binding.relationtypecardview.setVisibility(8);
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("self") && checkProgenyEmpty()) {
            this.binding.relativeCardView.setVisibility(8);
            this.binding.relationtypecardview.setVisibility(8);
        }
        this.binding.tvEpic.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldEpic()) ? "" : this.formverificationPayload.getSelfOldEpic());
        this.binding.tvName.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldName()) ? "" : this.formverificationPayload.getSelfOldName());
        this.binding.tvName1.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnName()) ? "" : this.formverificationPayload.getSelfOldRlnName());
        if (!TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnType())) {
            String selfOldRlnType = this.formverificationPayload.getSelfOldRlnType();
            this.self_selfOldRlnType = selfOldRlnType;
            setRelativeType(selfOldRlnType, this.binding.tvRelation);
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getOldStateCd()) && this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            for (int i = 0; i < this.StateList.size(); i++) {
                if (this.StateList.get(i).equalsIgnoreCase(this.formverificationPayload.getOldStateCd())) {
                    this.binding.tvState.setText(TextUtils.isEmpty(this.StateNameList.get(i)) ? "" : this.StateNameList.get(i));
                    break;
                }
            }
        }
        this.binding.tvAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getOldAcName()) ? "" : this.formverificationPayload.getOldAcName());
        if (this.formverificationPayload.getOldAcNo() != 0) {
            this.binding.tvAcNo.setText(String.valueOf(this.formverificationPayload.getOldAcNo()));
        }
        if (this.formverificationPayload.getOldPartNo() != 0) {
            this.binding.tvPartNo.setText(String.valueOf(this.formverificationPayload.getOldPartNo()));
        }
        if (this.formverificationPayload.getOldPslNo() != 0) {
            this.binding.tvSrNo.setText(String.valueOf(this.formverificationPayload.getOldPslNo()));
        }
        this.binding.tvRlEpic.setText(this.formverificationPayload.getRlnPrgyEpic());
        this.binding.tvRlName.setText(this.formverificationPayload.getRlnPrgyName());
        this.binding.tvRlName1.setText(this.formverificationPayload.getRlnPrgyRlnName());
        if (!TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType())) {
            setRelativeType(this.formverificationPayload.getRlnPrgyRlnType(), this.binding.tvRlRelation);
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            for (int i2 = 0; i2 < this.StateList.size(); i2++) {
                if (this.StateList.get(i2).equalsIgnoreCase(this.formverificationPayload.getRelationOldStateCd())) {
                    this.binding.tvRlState.setText(TextUtils.isEmpty(this.StateNameList.get(i2)) ? "" : this.StateNameList.get(i2));
                    break;
                }
            }
        }
        this.binding.tvRlAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getRelationOldAcName()) ? "" : this.formverificationPayload.getRelationOldAcName());
        if (this.formverificationPayload.getRelationOldAcNo() != 0) {
            this.binding.tvRlAcNo.setText(String.valueOf(this.formverificationPayload.getRelationOldAcNo()));
        }
        if (this.formverificationPayload.getRelationOldPartNo() != 0) {
            this.binding.tvRlPartNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPartNo()));
        }
        if (this.formverificationPayload.getRelationOldPslNo() != 0) {
            this.binding.tvRlSrNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPslNo()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$19(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            return;
        }
        if (str.equalsIgnoreCase("D")) {
            this.binding.aadharNumber.setText("");
        } else {
            this.binding.aadharNumber.setText(str2);
        }
    }

    public void setRelativeType(String relativeType, TextView textView) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        this.list_relation_type = relativeType;
        if (relativeType.equals("GMTH")) {
            textView.setText("Grand Mother");
            this.list_relation_type_name = "GrandMother";
            return;
        }
        if (relativeType.equals("GFTH")) {
            textView.setText("Grand Father");
            this.list_relation_type_name = "GrandFather";
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            textView.setText("Mother");
            this.list_relation_type_name = "Mother";
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            textView.setText("Father");
            this.list_relation_type_name = "Father";
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            textView.setText("Husband");
            this.list_relation_type_name = "Husband";
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            textView.setText("Other");
            this.list_relation_type_name = "other";
        } else if (TextUtils.isEmpty(relativeType)) {
            textView.setText("");
        } else {
            textView.setText(relativeType);
            this.list_relation_type_name = relativeType;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList(String key) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        this.commomUtility.getMigrationEfToBeVerifyByEpicId(this, this.token, this.efPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, key, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.20
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback
            public void onCallBack(int code, List<FormverificationPayload> datalist, String message) {
                if (code == 200) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        MigratedElectorsFormActivity.this.formverificationPayload = datalist.get(0);
                        MigratedElectorsFormActivity.this.setValues();
                        return;
                    }
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = MigratedElectorsFormActivity.this.utils;
                        ?? r4 = MigratedElectorsFormActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.20.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                MigratedElectorsFormActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = MigratedElectorsFormActivity.this.utils;
                        ?? r5 = MigratedElectorsFormActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), MigratedElectorsFormActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.20.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                MigratedElectorsFormActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = MigratedElectorsFormActivity.this.utils;
                    ?? r6 = MigratedElectorsFormActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.20.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            MigratedElectorsFormActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = MigratedElectorsFormActivity.this.utils;
                    ?? r7 = MigratedElectorsFormActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), MigratedElectorsFormActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.20.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            MigratedElectorsFormActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormListView(String key) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        this.commomUtility.getSpecialRevisionFormsPanIndiaByEpicId(this, this.token, this.efPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, key, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.21
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback
            public void onCallBack(int code, List<FormverificationPayload> datalist, String message) {
                if (code == 200) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        MigratedElectorsFormActivity.this.formverificationPayload = datalist.get(0);
                        MigratedElectorsFormActivity.this.setValues();
                        return;
                    }
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = MigratedElectorsFormActivity.this.utils;
                        ?? r4 = MigratedElectorsFormActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.21.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                MigratedElectorsFormActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = MigratedElectorsFormActivity.this.utils;
                        ?? r5 = MigratedElectorsFormActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), MigratedElectorsFormActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.21.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                MigratedElectorsFormActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = MigratedElectorsFormActivity.this.utils;
                    ?? r6 = MigratedElectorsFormActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.21.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            MigratedElectorsFormActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = MigratedElectorsFormActivity.this.utils;
                    ?? r7 = MigratedElectorsFormActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), MigratedElectorsFormActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.21.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            MigratedElectorsFormActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    public void redirecttolistScreen() {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFilePage2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(MigratedElectorsFormActivity.this);
                    circularProgressDrawable.setStrokeWidth(6.0f);
                    circularProgressDrawable.setCenterRadius(24.0f);
                    circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(MigratedElectorsFormActivity.this, R.color.blo_blue)});
                    circularProgressDrawable.start();
                    Glide.with(MigratedElectorsFormActivity.this).load(MigratedElectorsFormActivity.this.preSignedurl2).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(MigratedElectorsFormActivity.this.binding.photo2);
                } else {
                    MigratedElectorsFormActivity.this.binding.photo2.setImageDrawable(ContextCompat.getDrawable(MigratedElectorsFormActivity.this, R.drawable.blo_pdf_thumbnail));
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.downloadPdfToCache(migratedElectorsFormActivity.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.22.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            MigratedElectorsFormActivity.this.file2 = file;
                            Log.e("GETFILE", "FILE4::" + MigratedElectorsFormActivity.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.preSignedurl2)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(MigratedElectorsFormActivity.this.getResources(), R.drawable.blo_dummy_image);
                    MigratedElectorsFormActivity.this.binding.photo2Layout.setVisibility(0);
                    MigratedElectorsFormActivity.this.binding.photo2.setImageBitmap(bitmapDecodeResource);
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                    ?? r5 = MigratedElectorsFormActivity.this;
                    String str = ((MigratedElectorsFormActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$22$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception e) {
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e.getMessage());
                }
            } else if (response.code() != 404) {
                try {
                    MigratedElectorsFormActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$22$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(MigratedElectorsFormActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(MigratedElectorsFormActivity.this.messageString));
                } catch (IOException | JSONException e2) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e2.getMessage());
                }
            }
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r5 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r5, ((MigratedElectorsFormActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$22$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                MigratedElectorsFormActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                MigratedElectorsFormActivity.this.getFilePage2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent((Context) MigratedElectorsFormActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(MigratedElectorsFormActivity.this.TAG, "comingTag" + t.getMessage());
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$20(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$20(String str, pdfDownloadCallback pdfdownloadcallback) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf", ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    pdfdownloadcallback.downloaded(fileCreateTempFile);
                    Log.e("GETFILEq", "FILE119::" + fileCreateTempFile);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                if (MigratedElectorsFormActivity.this.alertDialog != null) {
                    MigratedElectorsFormActivity.this.alertDialog.dismiss();
                }
                MigratedElectorsFormActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(MigratedElectorsFormActivity.this);
                    circularProgressDrawable.setStrokeWidth(6.0f);
                    circularProgressDrawable.setCenterRadius(24.0f);
                    circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(MigratedElectorsFormActivity.this, R.color.blo_blue)});
                    circularProgressDrawable.start();
                    Glide.with(MigratedElectorsFormActivity.this).load(MigratedElectorsFormActivity.this.preSignedurl1).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(MigratedElectorsFormActivity.this.binding.photo1);
                } else {
                    MigratedElectorsFormActivity.this.binding.annexPage1Layout.setVisibility(0);
                    MigratedElectorsFormActivity.this.binding.photo1.setImageDrawable(ContextCompat.getDrawable(MigratedElectorsFormActivity.this, R.drawable.blo_pdf_thumbnail));
                    MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
                    migratedElectorsFormActivity.downloadPdfToCache(migratedElectorsFormActivity.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity.23.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            MigratedElectorsFormActivity.this.file1 = file;
                            Log.e("GETFILE", "FILE4::" + MigratedElectorsFormActivity.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.preSignedurl1)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(MigratedElectorsFormActivity.this.getResources(), R.drawable.blo_dummy_image);
                    MigratedElectorsFormActivity.this.binding.annexPage1Layout.setVisibility(0);
                    MigratedElectorsFormActivity.this.binding.photo1.setImageBitmap(bitmapDecodeResource);
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                    ?? r5 = MigratedElectorsFormActivity.this;
                    String str = ((MigratedElectorsFormActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$23$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception e) {
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e.getMessage());
                }
            } else {
                try {
                    MigratedElectorsFormActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$23$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(MigratedElectorsFormActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(MigratedElectorsFormActivity.this.messageString));
                } catch (IOException | JSONException e2) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e2.getMessage());
                }
            }
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r5 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r5, ((MigratedElectorsFormActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$23$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                MigratedElectorsFormActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                MigratedElectorsFormActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent((Context) MigratedElectorsFormActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(MigratedElectorsFormActivity.this.TAG, "comingTag" + t.getMessage());
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass24(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass24(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
                MigratedElectorsFormActivity.this.binding.passPhoto.setVisibility(8);
                MigratedElectorsFormActivity.this.binding.passPhotoLayout.setVisibility(0);
                MigratedElectorsFormActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(MigratedElectorsFormActivity.this);
                    circularProgressDrawable.setStrokeWidth(6.0f);
                    circularProgressDrawable.setCenterRadius(24.0f);
                    circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(MigratedElectorsFormActivity.this, R.color.blo_blue)});
                    circularProgressDrawable.start();
                    Glide.with(MigratedElectorsFormActivity.this).load(MigratedElectorsFormActivity.this.preSignedurl3).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(MigratedElectorsFormActivity.this.binding.image);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$24$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 1000L);
                }
                if (TextUtils.isEmpty(MigratedElectorsFormActivity.this.preSignedurl3)) {
                    MigratedElectorsFormActivity.this.binding.image.setImageBitmap(BitmapFactory.decodeResource(MigratedElectorsFormActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                    ?? r5 = MigratedElectorsFormActivity.this;
                    String str = ((MigratedElectorsFormActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$24$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$2(str2, i, str3, str4);
                        }
                    });
                } catch (Exception e) {
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e.getMessage());
                }
            } else {
                try {
                    MigratedElectorsFormActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$24$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$3();
                        }
                    });
                    Logger.e(MigratedElectorsFormActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(MigratedElectorsFormActivity.this.messageString));
                } catch (IOException | JSONException e2) {
                    if (MigratedElectorsFormActivity.this.alertDialog != null) {
                        MigratedElectorsFormActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(MigratedElectorsFormActivity.this.TAG, e2.getMessage());
                }
            }
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity] */
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
        public /* synthetic */ void lambda$onResponse$2(String str, int i, String str2, String str3) {
            MigratedElectorsFormActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = MigratedElectorsFormActivity.this.commomUtility;
                ?? r5 = MigratedElectorsFormActivity.this;
                commomUtility.showMessageOK(r5, ((MigratedElectorsFormActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$24$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            } else {
                MigratedElectorsFormActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                MigratedElectorsFormActivity.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MigratedElectorsFormActivity.this.getApplicationContext()).setLocaleBool(false);
            MigratedElectorsFormActivity.this.startActivity(new Intent((Context) MigratedElectorsFormActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(MigratedElectorsFormActivity.this.TAG, "comingTag" + t.getMessage());
            if (MigratedElectorsFormActivity.this.alertDialog != null) {
                MigratedElectorsFormActivity.this.alertDialog.dismiss();
            }
            MigratedElectorsFormActivity migratedElectorsFormActivity = MigratedElectorsFormActivity.this;
            migratedElectorsFormActivity.showDialog1(migratedElectorsFormActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        textView.setVisibility(8);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) {
        try {
            final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
            dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
            ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
            PDFView pDFView = (PDFView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
            TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
            textView.setVisibility(8);
            flattenPdf(preSignedUrl, pDFView);
            textView.setText(pdfNameFromObjectStorage);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.MigratedElectorsFormActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    private void flattenPdf(File inputFile, PDFView pdfView) {
        try {
            File file = new File(getCacheDir(), "flattened.pdf");
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputFile.getAbsolutePath()), new PdfWriter(file.getAbsolutePath()));
            PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);
            if (acroForm != null) {
                acroForm.flattenFields();
            }
            pdfDocument.close();
            pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(true).enableAnnotationRendering(true).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
