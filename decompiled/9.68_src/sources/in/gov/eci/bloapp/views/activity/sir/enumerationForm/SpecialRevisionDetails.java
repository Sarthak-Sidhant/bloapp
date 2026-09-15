package in.gov.eci.bloapp.views.activity.sir.enumerationForm;

import android.app.DatePickerDialog;
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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallbackjsonTest;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySpecialRevisionDetailsBinding;
import in.gov.eci.bloapp.entity.ListData;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.AgeCategorizer;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SpecialRevisionDetails extends SuperBaseActivity {
    Date DoB;
    private String SESSION;
    String aadhar;
    private String abbrev;
    String acName2003;
    String acNo2003;
    int age;
    private String ageDeviation;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivitySpecialRevisionDetailsBinding binding;
    Bundle bundle;
    byte[] byteArray;
    Date dateAfter;
    Date dateBefore;
    DatePickerDialog datePickerDialog;
    Date dateRange;
    String distName2003;
    String distNo2003;
    String dob;
    Date dobElector;
    String dobVerified;
    Long epicId;
    String fatherEpicNo;
    protected long filesize;
    String firstName2003;
    boolean flag2003;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isThisYou;
    boolean isoldStateEntered;
    String lastName2003;
    String mime;
    String mobile;
    String motherEpicNo;
    String partName2003;
    private String partNo;
    String partNo2003;
    String partSerialNo2003;
    private byte[] pdfbyteArray;
    ProgressBar progressBar;
    String referenceNo;
    private String refreshToken;
    ArrayList<String> relationCodeSpinnerVal;
    ArrayList<String> relationNameSpinnerVal;
    String relationVoterFlag;
    String relativeEpic;
    private String rtkband;
    protected String saveImageFileName;
    String selectDocumentType;
    String selectRelationType;
    int selectedId;
    String selectedText;
    SIRDatabaseHelper sirDatabaseHelper;
    String spouseEpicNo;
    private String state;
    String temp;
    private String token;
    String uploadFlag;
    UserClient userClient;
    String takephoto = "Take Photo";
    String choose_front_camera = "Capture from Front Camera";
    String choose_back_camera = "Capture from Back Camera";
    String whitecolor = "#000000";
    private int currentImagePickerId = 0;
    String relationCode = null;
    String preRevisonFlag = "N";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String cancel = "Cancel";
    String relativeDocument1UrlS = null;
    String relativeDocument2UrlS = null;
    String relativeSupportingDocumentPage1UrlS = null;
    String relativeSupportingDocumentPage2UrlS = null;
    String relationOldAcS = null;
    String relationOldPartS = null;
    String relationOldPSLS = null;
    String relationlist8DocS = null;
    String relationIs2003 = "";
    String alertText = "";
    String TAG = "SpecialRevisionDetailsTAG";
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String isThisYouRelFlag = "N";
    String applicationpdf = "application/pdf";
    private String photoref = null;
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\n Weak network detected. Please check your connection and try again.";
    private String annexRef = null;
    String functionNameForLogBaseActivity = "";
    String citizenCat = null;
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private String submitFlag = null;
    private boolean result = false;
    boolean onlineStatus = false;
    String tabName = "fillTab";
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String garudaTextBaseActivity = "GARUDA";
    int lastCheckedId = -1;
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
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    String list8code = "";
    String img = "image";
    String jpgTextBaseActivity = ".jpg";
    String invalidaadhar = "Invalid aadhar";
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
    boolean isUserAction = false;
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    String isLegacy = null;
    SimpleDateFormat simple1 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    boolean isUserSelected = false;
    boolean issearchdetailsbuttonclicked = false;
    String messageString = "message";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    boolean isRequestOTPClicked = false;
    String otp = "";
    boolean isotpVerified = false;
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        ActivitySpecialRevisionDetailsBinding activitySpecialRevisionDetailsBindingInflate = ActivitySpecialRevisionDetailsBinding.inflate(getLayoutInflater());
        this.binding = activitySpecialRevisionDetailsBindingInflate;
        setContentView(activitySpecialRevisionDetailsBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(this);
        if (SharedPref.getInstance(getApplicationContext()).getOnlineStatusFlag().equalsIgnoreCase("Y")) {
            this.onlineStatus = true;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.epicNumber = extras.getString("epicNo");
            this.epicId = Long.valueOf(extras.getLong("epicId"));
            this.serial = extras.getString("partSerialNo");
            this.erollPhotoURL = extras.getString("photoURL");
            this.erollDoB = extras.getString("dob");
            this.houseNumber = extras.getString("houseNo");
            this.age = Integer.parseInt(extras.getString("age"));
        }
        if (this.erollDoB != null) {
            try {
                this.dobVerified = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this.erollDoB));
            } catch (Exception e) {
                Logger.d("Date replace", e.toString());
            }
            this.binding.dateOfBirth.setText(this.dobVerified);
        }
        initializeSpinnerTouch();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(1, -18);
        final long time2 = calendar2.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda18
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$0(datePicker, i, i2, i3);
            }
        };
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        if (extras != null) {
            this.epicNumber = extras.getString("epicNo");
            this.serial = extras.getString("partSerialNo");
            this.erollPhotoURL = extras.getString("photoURL");
            this.erollDoB = extras.getString("dob");
            this.houseNumber = extras.getString("houseNo");
            this.flag2003 = extras.getBoolean("flag2003");
            this.acNo2003 = extras.getString("acNo2003");
            this.acName2003 = extras.getString("acName2003");
            this.partNo2003 = extras.getString("partNo2003");
            this.partName2003 = extras.getString("partName2003");
            this.distNo2003 = extras.getString("distNo2003");
            this.distName2003 = extras.getString("distName2003");
            this.partSerialNo2003 = extras.getString("partSerialNo2003");
            this.firstName2003 = extras.getString("firstName2003");
            this.lastName2003 = extras.getString("lastName2003");
        }
        this.StateList = SharedPref.getInstance(getApplicationContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getApplicationContext()).getAcListName(Constants.STATE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldState.setAdapter((SpinnerAdapter) arrayAdapter);
        preSelectionOfCat();
        if (this.flag2003) {
            this.binding.header2003.setText(getString(R.string.header_2003, new Object[]{this.distNo2003, this.distName2003, this.acNo2003, this.acName2003, this.partNo2003, this.partName2003, this.partSerialNo2003, this.firstName2003, this.lastName2003}) + StringUtils.SPACE + getString(R.string.header_2003_sub));
            this.binding.mainLayout.setVisibility(8);
            this.binding.yesButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    SpecialRevisionDetails.this.binding.header2003.setText(specialRevisionDetails.getString(R.string.header_2003, new Object[]{specialRevisionDetails.distNo2003, SpecialRevisionDetails.this.distName2003, SpecialRevisionDetails.this.acNo2003, SpecialRevisionDetails.this.acName2003, SpecialRevisionDetails.this.partNo2003, SpecialRevisionDetails.this.partName2003, SpecialRevisionDetails.this.partSerialNo2003, SpecialRevisionDetails.this.firstName2003, SpecialRevisionDetails.this.lastName2003}));
                    SpecialRevisionDetails.this.isLegacy = "Y";
                    SpecialRevisionDetails.this.citizenCat = "CAT-1";
                    SpecialRevisionDetails.this.binding.yesButton.setVisibility(8);
                    SpecialRevisionDetails.this.binding.noButton.setVisibility(8);
                    SpecialRevisionDetails.this.binding.mainLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.dobLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.aadharLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.guardianLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.relative2003Layout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.selectOneLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.submitLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.nextButton.setVisibility(8);
                    SpecialRevisionDetails.this.binding.orText.setVisibility(8);
                }
            });
            this.binding.noButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SpecialRevisionDetails.this.isLegacy = "N";
                    SpecialRevisionDetails.this.binding.layout2003.setVisibility(8);
                    SpecialRevisionDetails.this.binding.mainLayout.setVisibility(0);
                }
            });
            z = false;
        } else {
            z = false;
            this.binding.mainLayout.setVisibility(0);
            this.binding.layout2003.setVisibility(8);
        }
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        boolean z2 = z;
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(onDateSetListener, time2, time, view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.relative2003Yes.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(8);
            }
        });
        this.binding.relative2003No.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(0);
                SpecialRevisionDetails.this.binding.relative2003No.setChecked(true);
            }
        });
        this.binding.bornInIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpecialRevisionDetails.this.lastCheckedId != -1 || SpecialRevisionDetails.this.age <= 0) {
                    return;
                }
                String category = AgeCategorizer.getCategory(SpecialRevisionDetails.this.age);
                if (category.equalsIgnoreCase("Born in India before 1987")) {
                    SpecialRevisionDetails.this.binding.bornBefore1987rb.setChecked(true);
                    SpecialRevisionDetails.this.citizenCat = "CAT-2";
                    SpecialRevisionDetails.this.selectedText = category;
                } else if (category.equalsIgnoreCase("Born in India between 01.07.1987 and 02.12.2004")) {
                    SpecialRevisionDetails.this.binding.bornBefore2004rb.setChecked(true);
                    SpecialRevisionDetails.this.citizenCat = "CAT-3";
                    SpecialRevisionDetails.this.selectedText = category;
                } else if (category.equalsIgnoreCase("Born in India after 03.12.2004")) {
                    SpecialRevisionDetails.this.binding.bornAfter2004rb.setChecked(true);
                    SpecialRevisionDetails.this.citizenCat = "CAT-4";
                    SpecialRevisionDetails.this.selectedText = category;
                }
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = SpecialRevisionDetails.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                SpecialRevisionDetails.this.isMotherEPICValid = false;
                SpecialRevisionDetails.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = SpecialRevisionDetails.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                SpecialRevisionDetails.this.isFatherEPICValid = false;
                SpecialRevisionDetails.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = SpecialRevisionDetails.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                SpecialRevisionDetails.this.isSpouseEPICValid = false;
                SpecialRevisionDetails.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.ivSearchRelative.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = SpecialRevisionDetails.this.binding.edtRelativeEpic.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                SpecialRevisionDetails.this.isRelativeEPICValid = false;
                SpecialRevisionDetails.this.checkEpicNumber(strTrim, "Relative");
            }
        });
        this.binding.submitLayout.setVisibility(8);
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SpecialRevisionDetails.this.validate()) {
                    SpecialRevisionDetails.this.sentDataToNext();
                }
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.11
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (SpecialRevisionDetails.this.binding.noDocument.isChecked()) {
                    SpecialRevisionDetails.this.uploadFlag = "N";
                    SpecialRevisionDetails.this.binding.nextButton.setVisibility(8);
                    SpecialRevisionDetails.this.binding.orText.setVisibility(8);
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog2("", specialRevisionDetails.getString(R.string.noDocUploadedMsg));
                }
                if (SpecialRevisionDetails.this.binding.bornInIndia.isChecked()) {
                    SpecialRevisionDetails.this.binding.relative2003Layout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.nextButton.setVisibility(0);
                    SpecialRevisionDetails.this.binding.radioLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.submitLayout.setVisibility(8);
                    if (SpecialRevisionDetails.this.binding.relative2003Yes.isChecked()) {
                        SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(8);
                        return;
                    } else {
                        SpecialRevisionDetails.this.binding.nextButton.setVisibility(0);
                        SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(0);
                        return;
                    }
                }
                SpecialRevisionDetails.this.uploadFlag = "Y";
                SpecialRevisionDetails.this.binding.radioLayout.setVisibility(8);
                SpecialRevisionDetails.this.binding.nextButton.setVisibility(0);
                SpecialRevisionDetails.this.binding.submitLayout.setVisibility(0);
                SpecialRevisionDetails.this.binding.relative2003Layout.setVisibility(0);
                SpecialRevisionDetails.this.binding.submitLayout.setVisibility(8);
                if (SpecialRevisionDetails.this.binding.relative2003Yes.isChecked()) {
                    SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(8);
                } else {
                    SpecialRevisionDetails.this.binding.nextButton.setVisibility(0);
                    SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(0);
                }
            }
        });
        this.binding.indianWithPriorVoterID.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setChecked(true);
                SpecialRevisionDetails.this.binding.relative2003Layout.setVisibility(8);
                SpecialRevisionDetails.this.binding.relative2003RG.clearCheck();
            }
        });
        this.binding.selectDetailsBornIndia.setOnCheckedChangeListener(new AnonymousClass13());
        this.binding.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.14
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SpecialRevisionDetails.this.isOldAcNoEntered = false;
                    if (SpecialRevisionDetails.this.isUserSelected) {
                        SpecialRevisionDetails.this.binding.oldPartNo.setSelection(0);
                        SpecialRevisionDetails.this.binding.oldState.setSelection(0);
                        SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                        SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                        SpecialRevisionDetails.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                SpecialRevisionDetails.this.isOldAcNoEntered = true;
                SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                specialRevisionDetails.oldAc = specialRevisionDetails.ACList.get(i);
                SpecialRevisionDetails.this.getPartByAc(Integer.parseInt(SpecialRevisionDetails.this.ACList.get(i)), "case1");
                if (SpecialRevisionDetails.this.isUserSelected) {
                    SpecialRevisionDetails.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.15
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SpecialRevisionDetails.this.isoldStateEntered = false;
                    if (SpecialRevisionDetails.this.isUserSelected) {
                        SpecialRevisionDetails.this.binding.oldPartNo.setSelection(0);
                        SpecialRevisionDetails.this.binding.oldAcNo.setSelection(0);
                        SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                        SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                        SpecialRevisionDetails.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                SpecialRevisionDetails.this.isoldStateEntered = true;
                SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                specialRevisionDetails.oldState = specialRevisionDetails.StateList.get(i);
                Log.d(SpecialRevisionDetails.this.TAG, "AClist " + SpecialRevisionDetails.this.StateList);
                Log.d(SpecialRevisionDetails.this.TAG, "Spinner value " + SpecialRevisionDetails.this.oldState);
                SpecialRevisionDetails specialRevisionDetails2 = SpecialRevisionDetails.this;
                specialRevisionDetails2.getAllAC(specialRevisionDetails2.oldState);
                if (SpecialRevisionDetails.this.isUserSelected) {
                    SpecialRevisionDetails.this.isUserSelected = false;
                    SpecialRevisionDetails.this.binding.oldPartNo.setSelection(0);
                    SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                }
            }
        });
        this.binding.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.16
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SpecialRevisionDetails.this.isOldPartNoEntered = false;
                    if (SpecialRevisionDetails.this.isUserSelected) {
                        SpecialRevisionDetails.this.binding.oldAcNo.setSelection(0);
                        SpecialRevisionDetails.this.binding.oldState.setSelection(0);
                        SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                        SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                        SpecialRevisionDetails.this.isUserSelected = false;
                    }
                    SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                    return;
                }
                SpecialRevisionDetails.this.isOldPartNoEntered = true;
                SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                specialRevisionDetails.OldPart = specialRevisionDetails.partList.get(i - 1).toString();
                if (SpecialRevisionDetails.this.isUserSelected) {
                    SpecialRevisionDetails.this.isUserSelected = false;
                }
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.mobileNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.17
            boolean hasShowMessage = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 10 && s.toString().matches("\\d{10}") && !this.hasShowMessage) {
                    Logger.d(SpecialRevisionDetails.this.TAG, s.toString());
                    this.hasShowMessage = true;
                    SpecialRevisionDetails.this.binding.tvRequestOtp.setVisibility(0);
                    SpecialRevisionDetails.this.binding.otpLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.pinView.setText("");
                    return;
                }
                if (s.length() > 10) {
                    this.hasShowMessage = false;
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.getString(R.string.mobilenoerror));
                } else {
                    this.hasShowMessage = false;
                    SpecialRevisionDetails.this.binding.tvRequestOtp.setVisibility(8);
                    SpecialRevisionDetails.this.binding.otpLayout.setVisibility(8);
                    SpecialRevisionDetails.this.isRequestOTPClicked = false;
                    SpecialRevisionDetails.this.isotpVerified = false;
                }
            }
        });
        this.binding.tvRequestOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.18
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                SpecialRevisionDetails.this.isotpVerified = false;
                SpecialRevisionDetails.this.alertDialog.show();
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r1 = SpecialRevisionDetails.this;
                commomUtility.sentOTP(r1, ((SpecialRevisionDetails) r1).token, SpecialRevisionDetails.this.atkband, SpecialRevisionDetails.this.rtkband, SpecialRevisionDetails.this.binding.mobileNumber.getText().toString(), new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.18.1
                    @Override // in.gov.eci.bloapp.MyCallbackjsonTest
                    public void onCallbacktest(int code, JsonArray value) {
                        if (SpecialRevisionDetails.this.alertDialog != null) {
                            SpecialRevisionDetails.this.alertDialog.dismiss();
                        }
                        if (code == 200) {
                            SpecialRevisionDetails.this.isRequestOTPClicked = true;
                            SpecialRevisionDetails.this.binding.otpLayout.setVisibility(0);
                            SpecialRevisionDetails.this.binding.tvRequestOtp.setVisibility(8);
                            Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) "OTP sent sucessfully.", 1).show();
                            return;
                        }
                        Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) "Either entered mobile number is incorrect or network issue, please try again", 1).show();
                    }
                });
            }
        });
        this.binding.tvVerifyOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.19
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                if (SpecialRevisionDetails.this.binding.pinView.length() == 6) {
                    SpecialRevisionDetails.this.alertDialog.show();
                    CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                    ?? r1 = SpecialRevisionDetails.this;
                    commomUtility.verifyOTP(r1, ((SpecialRevisionDetails) r1).token, SpecialRevisionDetails.this.atkband, SpecialRevisionDetails.this.rtkband, SpecialRevisionDetails.this.binding.mobileNumber.getText().toString(), SpecialRevisionDetails.this.binding.pinView.getText().toString(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.19.1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public void onCallBack(int code, String status, String message) {
                            if (SpecialRevisionDetails.this.alertDialog != null) {
                                SpecialRevisionDetails.this.alertDialog.dismiss();
                            }
                            if (code == 200) {
                                SpecialRevisionDetails.this.isotpVerified = true;
                                SpecialRevisionDetails.this.binding.otpLayout.setVisibility(8);
                                SpecialRevisionDetails.this.binding.tvRequestOtp.setVisibility(8);
                                SpecialRevisionDetails.this.binding.pinView.setText("");
                                Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) message, 1).show();
                                return;
                            }
                            Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) message, 1).show();
                        }
                    });
                    return;
                }
                SpecialRevisionDetails.this.commomUtility.displayAlertWithTitleAndMessage(SpecialRevisionDetails.this, "Enter OTP", "Please enter OTP");
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass20());
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(z2 ? 1 : 0));
        this.alertDialog.setCancelable(z2);
        this.alertDialog.setView(viewInflate);
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda20
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$11(view, motionEvent);
            }
        });
        this.binding.spinnerRelation.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.21
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    SpecialRevisionDetails.this.isUserAction = true;
                    SpecialRevisionDetails.this.isUserSelected = true;
                }
            }
        });
        this.binding.spinnerRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.22
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDetails.this.isUserSelected) {
                    SpecialRevisionDetails.this.deletePhoto(201);
                    SpecialRevisionDetails.this.deletePhoto(202);
                    SpecialRevisionDetails.this.deletePhoto(203);
                    SpecialRevisionDetails.this.deletePhoto(204);
                    SpecialRevisionDetails.this.isUserSelected = false;
                }
                if (SpecialRevisionDetails.this.isUserAction) {
                    if (i == 0) {
                        SpecialRevisionDetails.this.relationCode = "";
                    } else {
                        int i2 = i - 1;
                        if (i2 >= 0 && i2 < SpecialRevisionDetails.this.relationNameSpinnerVal.size()) {
                            SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                            specialRevisionDetails.relationCode = specialRevisionDetails.relationCodeSpinnerVal.get(i);
                            Logger.d("listRelationCode", SpecialRevisionDetails.this.relationCode);
                        }
                    }
                    SpecialRevisionDetails.this.binding.oldState.setSelection(0);
                    SpecialRevisionDetails.this.binding.oldAcNo.setSelection(0);
                    SpecialRevisionDetails.this.binding.oldPartNo.setSelection(0);
                    SpecialRevisionDetails.this.binding.oldPslNo.setText("");
                    SpecialRevisionDetails.this.binding.spinnerIR.setSelection(0);
                    SpecialRevisionDetails.this.binding.firstLLNew.setVisibility(8);
                    SpecialRevisionDetails.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    SpecialRevisionDetails.this.binding.enumerationFormLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(8);
                    SpecialRevisionDetails.this.relativeDocument1UrlS = "";
                    if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument2UrlS)) {
                        SpecialRevisionDetails.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    }
                    SpecialRevisionDetails.this.binding.secondLLNew.setVisibility(8);
                    SpecialRevisionDetails.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    SpecialRevisionDetails.this.relativeDocument2UrlS = "";
                    if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument2UrlS)) {
                        SpecialRevisionDetails.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    }
                    SpecialRevisionDetails.this.binding.enumerationFormLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.firstLL1.setVisibility(8);
                    SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    SpecialRevisionDetails.this.binding.supprtingDocumentsLayout.setVisibility(0);
                    SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS = "";
                    if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS)) {
                        SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    }
                    SpecialRevisionDetails.this.binding.secondLL1.setVisibility(8);
                    SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS = "";
                    if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS)) {
                        SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    }
                    SpecialRevisionDetails.this.binding.supprtingDocumentsLayout.setVisibility(0);
                }
            }
        });
        this.binding.relative2003RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.23
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (SpecialRevisionDetails.this.binding.relative2003Yes.isChecked()) {
                    SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(8);
                    SpecialRevisionDetails.this.binding.oldACSerialPSLNoLL.setVisibility(0);
                    SpecialRevisionDetails.this.binding.layoutChooseRelationType.setVisibility(0);
                    SpecialRevisionDetails.this.binding.layoutReletiveEpic.setVisibility(0);
                    SpecialRevisionDetails.this.binding.submitLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(8);
                    if (SpecialRevisionDetails.this.binding.oldState.getSelectedItemPosition() != 0 && SpecialRevisionDetails.this.binding.oldAcNo.getSelectedItemPosition() != 0 && SpecialRevisionDetails.this.binding.oldPartNo.getSelectedItemPosition() != 0 && SpecialRevisionDetails.this.binding.oldPslNo.getText().toString().trim().length() > 0) {
                        SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(0);
                    }
                }
                if (SpecialRevisionDetails.this.binding.relative2003No.isChecked()) {
                    SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(8);
                    SpecialRevisionDetails.this.binding.oldACSerialPSLNoLL.setVisibility(8);
                    SpecialRevisionDetails.this.binding.layoutChooseRelationType.setVisibility(8);
                    SpecialRevisionDetails.this.binding.layoutReletiveEpic.setVisibility(8);
                    SpecialRevisionDetails.this.binding.indianWithPriorVoterID.setVisibility(0);
                    SpecialRevisionDetails.this.binding.submitLayout.setVisibility(0);
                    SpecialRevisionDetails.this.binding.relative2003No.setChecked(true);
                    SpecialRevisionDetails.this.binding.submitLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                }
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.24
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (!text.toString().trim().isEmpty() && SpecialRevisionDetails.this.isoldStateEntered && SpecialRevisionDetails.this.isOldAcNoEntered && SpecialRevisionDetails.this.isOldPartNoEntered) {
                    SpecialRevisionDetails.this.isOldPartSerialNoEntered = true;
                } else {
                    SpecialRevisionDetails.this.isOldPartSerialNoEntered = false;
                    SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                }
                if (SpecialRevisionDetails.this.isoldStateEntered && SpecialRevisionDetails.this.isOldAcNoEntered && SpecialRevisionDetails.this.isOldPartNoEntered && SpecialRevisionDetails.this.isOldPartSerialNoEntered) {
                    SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(0);
                }
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.issearchdetailsbuttonclicked = true;
                if (SpecialRevisionDetails.this.binding.oldState.getSelectedItemPosition() == 0 || SpecialRevisionDetails.this.binding.oldAcNo.getSelectedItemPosition() == 0 || SpecialRevisionDetails.this.binding.oldPartNo.getSelectedItemPosition() == 0 || SpecialRevisionDetails.this.binding.oldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(0);
                SpecialRevisionDetails.this.callVerifyRelativeApi();
            }
        });
        setDataOffline("LIST-8");
        this.relationCodeSpinnerVal = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        this.relationNameSpinnerVal = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameSpinnerVal);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.26
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDetails.this.isUserSelected) {
                    SpecialRevisionDetails.this.deletePhoto(201);
                    SpecialRevisionDetails.this.deletePhoto(202);
                    SpecialRevisionDetails.this.deletePhoto(203);
                    SpecialRevisionDetails.this.deletePhoto(204);
                    SpecialRevisionDetails.this.isUserSelected = false;
                }
                if (i == 0) {
                    SpecialRevisionDetails.this.list8code = "";
                    return;
                }
                int i2 = i - 1;
                if (i2 < 0 || i2 >= SpecialRevisionDetails.this.List8docName.size()) {
                    return;
                }
                SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                specialRevisionDetails.list8code = specialRevisionDetails.List8docCode.get(i);
                Logger.d(Constants.LIST8_CODE, SpecialRevisionDetails.this.list8code);
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.pickPhoto(201, "rDP1_");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument1UrlS)) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.getString(R.string.uploadpage1error));
                } else {
                    SpecialRevisionDetails.this.pickPhoto(202, "rDP2_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.list8code)) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.selectDocumentType);
                } else {
                    SpecialRevisionDetails.this.pickPhoto(203, "sDP1_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.list8code)) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.selectDocumentType);
                } else if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS)) {
                    SpecialRevisionDetails specialRevisionDetails2 = SpecialRevisionDetails.this;
                    specialRevisionDetails2.showDialog1(specialRevisionDetails2.alertText, SpecialRevisionDetails.this.getString(R.string.uploadpage1error));
                } else {
                    SpecialRevisionDetails.this.pickPhoto(204, "sDP2_");
                }
            }
        });
        this.binding.deleteFrontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.firstLLNew.setVisibility(8);
                SpecialRevisionDetails.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                SpecialRevisionDetails.this.binding.enumerationFormLayout.setVisibility(0);
                SpecialRevisionDetails.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument2UrlS)) {
                    SpecialRevisionDetails.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.secondLLNew.setVisibility(8);
                SpecialRevisionDetails.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                SpecialRevisionDetails.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeDocument2UrlS)) {
                    SpecialRevisionDetails.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                }
                SpecialRevisionDetails.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.firstLL1.setVisibility(8);
                SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                SpecialRevisionDetails.this.binding.supprtingDocumentsLayout.setVisibility(0);
                SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS)) {
                    SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.secondLL1.setVisibility(8);
                SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(SpecialRevisionDetails.this.relativeSupportingDocumentPage2UrlS)) {
                    SpecialRevisionDetails.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                }
                SpecialRevisionDetails.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        initClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        pickPhoto(101, "photo1Form");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadfrontpagemsg));
        } else {
            pickPhoto(102, "Photo2Form");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            choosseCameraOption();
        } else {
            pickFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$13, reason: invalid class name */
    class AnonymousClass13 implements RadioGroup.OnCheckedChangeListener {
        AnonymousClass13() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, final int checkedId) {
            if (SpecialRevisionDetails.this.lastCheckedId != -1 && SpecialRevisionDetails.this.lastCheckedId != checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (radioButton.getText().toString().equalsIgnoreCase(AgeCategorizer.getCategory(SpecialRevisionDetails.this.age))) {
                    SpecialRevisionDetails.this.lastCheckedId = checkedId;
                    return;
                } else {
                    new AlertDialog.Builder(SpecialRevisionDetails.this).setTitle(SpecialRevisionDetails.this.alertText).setMessage("As per the system you don't qualify for category " + ((Object) radioButton.getText()) + ". Do you wish to continue?").setPositiveButton(SpecialRevisionDetails.this.getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$13$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$0(checkedId, dialogInterface, i);
                        }
                    }).setNegativeButton(SpecialRevisionDetails.this.getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$13$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$1(dialogInterface, i);
                        }
                    }).show();
                    return;
                }
            }
            SpecialRevisionDetails.this.lastCheckedId = checkedId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$0(int i, DialogInterface dialogInterface, int i2) {
            SpecialRevisionDetails.this.lastCheckedId = i;
            SpecialRevisionDetails.this.ageDeviation = "Y";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$1(DialogInterface dialogInterface, int i) {
            if (SpecialRevisionDetails.this.lastCheckedId == SpecialRevisionDetails.this.binding.bornBefore1987rb.getId()) {
                SpecialRevisionDetails.this.binding.bornBefore1987rb.setChecked(true);
            } else if (SpecialRevisionDetails.this.lastCheckedId == SpecialRevisionDetails.this.binding.bornBefore2004rb.getId()) {
                SpecialRevisionDetails.this.binding.bornBefore2004rb.setChecked(true);
            } else if (SpecialRevisionDetails.this.lastCheckedId == SpecialRevisionDetails.this.binding.bornAfter2004rb.getId()) {
                SpecialRevisionDetails.this.binding.bornAfter2004rb.setChecked(true);
            }
            SpecialRevisionDetails.this.ageDeviation = "N";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        this.submitFlag = "N";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        this.submitFlag = "Y";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20, reason: invalid class name */
    class AnonymousClass20 implements TextWatcher {
        AnonymousClass20() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
            if (SpecialRevisionDetails.this.binding.aadharNumber.getText().toString().length() == 12) {
                if (SpecialRevisionDetails.this.alertDialog != null) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                }
                try {
                    String string = SpecialRevisionDetails.this.binding.aadharNumber.getText().toString();
                    SpecialRevisionDetails.this.result = Verhoeff.validateVerhoeff(string);
                    if (!SpecialRevisionDetails.this.result) {
                        SpecialRevisionDetails.this.binding.aadharNumber.setText("");
                        SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                        specialRevisionDetails.showDialog1("", specialRevisionDetails.getString(R.string.aadhaarnoerror));
                        if (SpecialRevisionDetails.this.alertDialog != null) {
                            SpecialRevisionDetails.this.alertDialog.dismiss();
                        }
                    } else {
                        CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                        ?? r1 = SpecialRevisionDetails.this;
                        commomUtility.getaadharref(r1, ((SpecialRevisionDetails) r1).state, SpecialRevisionDetails.this.token, SpecialRevisionDetails.this.binding.aadharNumber.getText().toString(), SpecialRevisionDetails.this.atkband, SpecialRevisionDetails.this.rtkband, "EFForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda5
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
        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r4 = SpecialRevisionDetails.this;
                commomUtility.getRefreshToken(r4, ((SpecialRevisionDetails) r4).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.invalidaadhar, str2);
                    if (SpecialRevisionDetails.this.alertDialog != null) {
                        SpecialRevisionDetails.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                SpecialRevisionDetails.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            SpecialRevisionDetails.this.showDialog1(SpecialRevisionDetails.this.alertText + i, str2);
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r11 = SpecialRevisionDetails.this;
                commomUtility.showMessageOK(r11, ((SpecialRevisionDetails) r11).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
            } else {
                SpecialRevisionDetails.this.token = "Bearer " + str;
                SpecialRevisionDetails.this.refreshToken = str2;
                SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setToken("Bearer " + str);
                SpecialRevisionDetails.this.commomUtility.getaadharref(SpecialRevisionDetails.this.getApplicationContext(), SpecialRevisionDetails.this.state, SpecialRevisionDetails.this.token, SpecialRevisionDetails.this.binding.aadharNumber.getText().toString(), SpecialRevisionDetails.this.atkband, SpecialRevisionDetails.this.rtkband, "EFForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetails.this.startActivity(new Intent(SpecialRevisionDetails.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.invalidaadhar, str2);
                    if (SpecialRevisionDetails.this.alertDialog != null) {
                        SpecialRevisionDetails.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                SpecialRevisionDetails.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$20$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$1();
                    }
                }, 2000L);
                return;
            }
            SpecialRevisionDetails.this.showDialog1(SpecialRevisionDetails.this.alertText + i, str2);
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$11(View view, MotionEvent motionEvent) {
        this.isUserAction = true;
        this.isUserSelected = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        deletePhoto(201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        deletePhoto(202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        deletePhoto(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        deletePhoto(204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getPartByAc(int ac, final String partCase) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        Log.d(this.TAG, "getpartbyac " + ac);
        UserClient userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
        this.userClient = userClient;
        userClient.getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.35
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    SpecialRevisionDetails.this.partNameList.clear();
                    SpecialRevisionDetails.this.partList.clear();
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (SpecialRevisionDetails.this.partNameList.isEmpty()) {
                        SpecialRevisionDetails.this.partNameList.add(0, SpecialRevisionDetails.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        if (partCase.equalsIgnoreCase("case1")) {
                            SpecialRevisionDetails.this.partNameList.add(asInt + " - " + asString);
                            SpecialRevisionDetails.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = SpecialRevisionDetails.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDetails.this.binding.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) "Failed to get Part List", 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 201) {
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
            }
            if (TextUtils.isEmpty(this.relativeDocument1UrlS) && this.binding.enumerationFormPage2.getVisibility() == 0) {
                this.binding.enumerationFormPage1.setVisibility(4);
                return;
            }
            return;
        }
        if (code == 202) {
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
            }
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && this.binding.enumerationFormPage1.getVisibility() == 0) {
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 203) {
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
            }
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && this.binding.supportingDocumentsPage2.getVisibility() == 0) {
                this.binding.supportingDocumentsPage1.setVisibility(4);
                return;
            }
            return;
        }
        if (code == 204) {
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
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS) && this.binding.supportingDocumentsPage1.getVisibility() == 0) {
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
        }
    }

    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.oldState);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        this.userClient.getDetailsByEroll(Integer.parseInt(this.oldAc), Integer.parseInt(this.OldPart), Integer.parseInt(this.binding.oldPslNo.getText().toString().trim()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.36
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(SpecialRevisionDetails.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        String strOptString = jSONObject.optString("epic", null);
                        String strOptString2 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString3 = jSONObject.optString(Constants.LAST_NAME, null);
                        String strOptString4 = jSONObject.optString("relativeFName", null);
                        String strOptString5 = jSONObject.optString("relativeLName", null);
                        String strOptString6 = jSONObject.optString("relationType", null);
                        if (TextUtils.isEmpty(strOptString)) {
                            strOptString = "";
                        }
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        if (TextUtils.isEmpty(strOptString3)) {
                            strOptString3 = "";
                        }
                        if (TextUtils.isEmpty(strOptString4)) {
                            strOptString4 = "";
                        }
                        if (TextUtils.isEmpty(strOptString5)) {
                            strOptString5 = "";
                        }
                        if (TextUtils.isEmpty(strOptString6)) {
                            strOptString6 = "";
                        }
                        SpecialRevisionDetails.this.showVerifyDetailsDialog(strOptString2 + StringUtils.SPACE + strOptString3, strOptString4 + StringUtils.SPACE + strOptString5, strOptString6, strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("SpecialRevisionDetails", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                    SpecialRevisionDetails.this.isThisYou = false;
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.getString(R.string.no_record_found));
                    return;
                }
                SpecialRevisionDetails.this.isThisYou = false;
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String typeRelation, String epic) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_verify_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtTypeRelation);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtEpic);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.linearNameNew);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.linearNameNewRelative);
        LinearLayout linearLayout3 = (LinearLayout) dialog.findViewById(R.id.linearNameEpic);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtSureNew);
        linearLayout.setVisibility(8);
        linearLayout3.setVisibility(8);
        textView5.setVisibility(8);
        linearLayout2.setVisibility(8);
        textView.setText(name);
        textView2.setText(relativeName);
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH") || typeRelation.equalsIgnoreCase("Grand Mother")) {
                textView3.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH") || typeRelation.equalsIgnoreCase("Grand Father")) {
                textView3.setText("Grand Father");
            } else if (typeRelation.equals("MTHR") || typeRelation.equalsIgnoreCase("Mother") || typeRelation.equalsIgnoreCase("M")) {
                textView3.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F") || typeRelation.equalsIgnoreCase("Father")) {
                textView3.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H") || typeRelation.equalsIgnoreCase("Husband")) {
                textView3.setText("Husband");
            } else if (typeRelation.equals("OTHR") || typeRelation.equalsIgnoreCase("Other")) {
                textView3.setText("Other");
            } else if (TextUtils.isEmpty(typeRelation)) {
                textView3.setText("");
            }
        }
        textView4.setText(epic);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(0);
                SpecialRevisionDetails.this.binding.layoutVerifyDetails.setVisibility(8);
                dialog.cancel();
                SpecialRevisionDetails.this.isThisYou = true;
                SpecialRevisionDetails.this.isThisYouRelFlag = "Y";
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialRevisionDetails.this.binding.relative2003LL.setVisibility(0);
                dialog.cancel();
                SpecialRevisionDetails.this.isThisYou = false;
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean submit() {
        this.dob = this.binding.dateOfBirth.getText().toString();
        this.aadhar = this.binding.aadharNumber.getText().toString();
        this.mobile = this.binding.mobileNumber.getText().toString();
        this.fatherEpicNo = this.binding.fatherEpicNumber.getText().toString();
        this.motherEpicNo = this.binding.motherEpicNumber.getText().toString();
        this.spouseEpicNo = this.binding.spouseEpicNumber.getText().toString();
        this.relationOldPSLS = this.binding.oldPslNo.getText().toString();
        this.relativeEpic = this.binding.edtRelativeEpic.getText().toString();
        if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
            try {
                this.dobVerified = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this.binding.dateOfBirth.getText().toString()));
            } catch (Exception e) {
                Logger.d("Date replace", e.toString());
            }
        }
        if (this.binding.relative2003Yes.isChecked()) {
            this.relationVoterFlag = "Y";
        } else if (this.binding.relative2003No.isChecked()) {
            this.relationVoterFlag = "N";
        }
        int checkedRadioButtonId = this.binding.selectDetails.getCheckedRadioButtonId();
        this.selectedId = checkedRadioButtonId;
        String string = ((RadioButton) findViewById(checkedRadioButtonId)).getText().toString();
        this.selectedText = string;
        Log.d(this.TAG, string);
        try {
            String str = this.dob;
            if (str != null && str.trim().length() > 0) {
                this.DoB = this.simple1.parse(this.dob.trim());
            }
            this.dateBefore = this.simple1.parse("01/07/1987");
            this.dateAfter = this.simple1.parse("02/12/2004");
        } catch (ParseException e2) {
            Logger.d(this.TAG, e2.toString());
            Logger.d("SpecialRevisionDetails", e2.toString());
        }
        if (!TextUtils.isEmpty(this.selectedText)) {
            if (this.selectedText.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
                this.citizenCat = "CAT-1";
                this.preRevisonFlag = "Y";
            }
            if (this.binding.bornInIndia.isChecked()) {
                if (this.binding.bornBefore1987rb.isChecked()) {
                    this.citizenCat = "CAT-2";
                    this.selectedText = this.binding.bornBefore1987rb.getText().toString();
                } else if (this.binding.bornBefore2004rb.isChecked()) {
                    this.citizenCat = "CAT-3";
                    this.selectedText = this.binding.bornBefore2004rb.getText().toString();
                } else if (this.binding.bornAfter2004rb.isChecked()) {
                    this.citizenCat = "CAT-4";
                    this.selectedText = this.binding.bornAfter2004rb.getText().toString();
                }
            }
            if (this.selectedText.equalsIgnoreCase(getString(R.string.not_born))) {
                this.citizenCat = "CAT-5";
            }
            if (this.selectedText.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                this.citizenCat = "CAT-6";
            }
            if (this.binding.noDocument.getVisibility() == 0 && this.selectedText.equalsIgnoreCase(getString(R.string.no_document_uploaded))) {
                this.citizenCat = "";
            }
            if (this.binding.noDocument.getVisibility() == 0 && !this.binding.noDocument.isChecked() && TextUtils.isEmpty(this.citizenCat)) {
                showDialog1(getString(R.string.alertMsg), getString(R.string.selectcitizencatmsg));
                return false;
            }
            if (this.binding.noDocument.getVisibility() == 8 && TextUtils.isEmpty(this.citizenCat)) {
                showDialog1(getString(R.string.alertMsg), getString(R.string.selectcitizencatmsg));
                return false;
            }
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.epicNumber);
        map2.put("epicId", this.epicId);
        map2.put("stCode", this.state);
        map2.put("houseNo", this.houseNumber);
        map2.put("dobVerified", this.dobVerified);
        map2.put("erollDob", this.erollDoB);
        map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", this.serial);
        map2.put("createdBy", "BLO");
        map2.put("modifiedDttm", null);
        map2.put("modifiedBy", null);
        map2.put("photoUrl", this.photoref);
        map2.put("srFormPage1Url", this.photo1Ref);
        map2.put("citizenshipType", this.selectedText);
        map2.put("citizenshipTypeCat", this.citizenCat);
        map2.put("surveyChannel", "BLO");
        map2.put("list1Doc", null);
        map2.put("list2Doc", null);
        map2.put("list3Doc", null);
        map2.put("list4Doc", null);
        map2.put("list5Doc", null);
        map2.put("list6Doc", null);
        map2.put("list7Doc", null);
        map2.put("list1DocUrl", null);
        map2.put("list2DocUrl", null);
        map2.put("list3DocUrl", null);
        map2.put("list4DocUrl", null);
        map2.put("list5DocUrl", null);
        map2.put("list6DocUrl", null);
        map2.put("list7DocUrl", null);
        map2.put("aadharNo", this.aadharref);
        map2.put("mobileNo", this.mobile);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpicNo);
        map2.put("mothersEpicNo", this.motherEpicNo);
        map2.put("spouseEpicNo", this.spouseEpicNo);
        map2.put("annexureCUrl", null);
        map2.put("preRevisionVoterFlg", this.preRevisonFlag);
        map2.put("preRevisionVoterDocUrl", null);
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", "Indian");
        map2.put("mothersNationality", "Indian");
        map2.put("srFormPage2Url", this.photo2Ref);
        map2.put("oldAcNo", this.acNo2003);
        map2.put("oldPartNo", this.partNo2003);
        map2.put("oldPslNo", this.partSerialNo2003);
        map2.put("list8Doc", null);
        map2.put("moldAcNo", null);
        map2.put("moldPslNo", null);
        map2.put("foldAcNo", null);
        map2.put("foldPartNo", null);
        map2.put("foldPslNo", null);
        map2.put("documentUploadedFlg", this.uploadFlag);
        map2.put("isLegacyOpt", this.isLegacy);
        map2.put("relationOldStateCd", this.oldState);
        map2.put("relationOldAcNo", this.oldAc);
        map2.put("relationOldPartNo", this.OldPart);
        map2.put("relationOldPslNo", this.binding.oldPslNo.getText().toString());
        map2.put("relationDocType", this.list8code);
        map2.put("relationDocUrlPg1", this.relativeSupportingDocumentPage1UrlS);
        map2.put("relationDocUrlPg2", this.relativeSupportingDocumentPage2UrlS);
        map2.put("isRelativePreVoterFlg", this.binding.relative2003Yes.isChecked() ? "Y" : "N");
        map2.put("relationProofDocUrlPg1", this.relativeDocument1UrlS);
        map2.put("relationProofDocUrlPg2", this.relativeDocument2UrlS);
        map2.put("relationType", this.relationCode);
        map2.put("relationEpicNo", this.binding.edtRelativeEpic.getText().toString());
        map2.put("isThisYouRel", this.isThisYou ? "Y" : "N");
        Logger.d(this.TAG, map2.toString());
        if (this.onlineStatus) {
            ((UserClient) ApiClient.getClient(this).create(UserClient.class)).submitSpecialRevisionSIR(map, map2).enqueue(new AnonymousClass39());
            return false;
        }
        try {
            this.sirDatabaseHelper.SpecialRevisionDao().addSpecialSurveyRevisionDetails(new SpecialSurveyRevisionModel(this.epicId, this.state, this.epicNumber, this.houseNumber, this.dobVerified, this.erollDoB, SharedPref.getInstance(this).getDistrictCode(), this.asmblyNO, this.partNo, this.serial, null, "BLO", null, null, this.photoref, this.photo1Ref, this.selectedText, this.citizenCat, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BLO", this.aadharref, this.mobile, null, this.fatherEpicNo, null, this.motherEpicNo, null, this.spouseEpicNo, null, this.preRevisonFlag, null, this.submitFlag, "Indian", "Indian", this.photo2Ref, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.relationCode, this.list8code, this.relativeSupportingDocumentPage1UrlS, this.relationVoterFlag, this.relativeSupportingDocumentPage2UrlS, this.relativeDocument1UrlS, this.relativeDocument2UrlS, this.oldAc, this.OldPart, this.relationOldPSLS, this.relativeEpic, null, this.isThisYouRelFlag, this.tabName, this.oldState, null));
            showDialog3("", getString(R.string.form_saved_successfully));
            WorkManager.getInstance(this).enqueueUniqueWork("SIR_UPLOAD_WORK", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(SirUploadWorker.class).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10L, TimeUnit.SECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
        } catch (Exception e3) {
            Logger.d(this.TAG, "Offline" + e3);
            showDialog1("Error", getString(R.string.something_went_wrong));
        }
        return false;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$39, reason: invalid class name */
    class AnonymousClass39 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass39() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.showDialog3(specialRevisionDetails.alertText, string);
                } else {
                    SpecialRevisionDetails specialRevisionDetails2 = SpecialRevisionDetails.this;
                    specialRevisionDetails2.showDialog3("", specialRevisionDetails2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$39$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setDataOffline(String list) {
        for (ListData listData : this.sirDatabaseHelper.ListDataDao().getList(list)) {
            if (list.equalsIgnoreCase("LIST-8")) {
                this.List8docCode.add(listData.docCode);
                this.List8docName.add(listData.docName);
            }
        }
        if (list.equalsIgnoreCase("LIST-8")) {
            if (!this.List8docName.contains(this.selectDocumentType)) {
                this.List8docName.add(0, this.selectDocumentType);
                this.List8docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List8docName);
            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$16(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$16(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) specialRevisionActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
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
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$17(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$17(View view) {
        onBackPressed();
    }

    private boolean validateFields() {
        if (this.binding.selectDetails.getCheckedRadioButtonId() == -1) {
            showDialog1(this.alertText, getString(R.string.selectAnyOneMsg));
            return false;
        }
        if (this.photo1Ref != null && this.photo2Ref != null) {
            return true;
        }
        showDialog1(this.alertText, "Please upload Enumeration form for elector");
        return false;
    }

    private void getFieldsValue() {
        this.dobVerified = this.binding.dateOfBirth.getText().toString();
        String string = this.binding.mobileNumber.getText().toString();
        this.mobileNo = string;
        if (string.isEmpty()) {
            this.mobileNo = null;
        }
        String string2 = this.binding.fatherEpicNumber.getText().toString();
        this.fatherEpic = string2;
        if (string2.isEmpty()) {
            this.fatherEpic = null;
        }
        String string3 = this.binding.motherEpicNumber.getText().toString();
        this.motherEpic = string3;
        if (string3.isEmpty()) {
            this.motherEpic = null;
        }
        String string4 = this.binding.spouseEpicNumber.getText().toString();
        this.spouseEpic = string4;
        if (string4.isEmpty()) {
            this.spouseEpic = null;
        }
    }

    public boolean validate() {
        if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
            this.dob = this.binding.dateOfBirth.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.aadharNumber.getText().toString())) {
            this.aadhar = this.binding.aadharNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.mobileNumber.getText().toString())) {
            this.mobile = this.binding.mobileNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString())) {
            this.fatherEpicNo = this.binding.fatherEpicNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString())) {
            this.motherEpicNo = this.binding.motherEpicNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString())) {
            this.spouseEpicNo = this.binding.spouseEpicNumber.getText().toString();
        }
        this.selectedId = this.binding.selectDetails.getCheckedRadioButtonId();
        int checkedRadioButtonId = this.binding.relative2003RG.getCheckedRadioButtonId();
        if (TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if (TextUtils.isEmpty(this.photo2Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadBackPageMsg));
            return false;
        }
        if (!TextUtils.isEmpty(this.aadhar) && this.aadhar.length() < 12) {
            showDialog1(this.alertText, getString(R.string.invalidAadharMsg2));
            return false;
        }
        if (!TextUtils.isEmpty(this.mobile) && this.mobile.length() != 10) {
            showDialog1(this.alertText, getString(R.string.incorrecMobileMsg));
            return false;
        }
        if (this.binding.otpLayout.getVisibility() == 0 && !this.isotpVerified) {
            showDialog1(this.alertText, getString(R.string.error_otp_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString()) && !this.isFatherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_father_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString()) && !this.isMotherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_mother_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString()) && !this.isSpouseEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_Spouse_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.edtRelativeEpic.getText().toString()) && !this.isMotherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_Relative_verification));
            return false;
        }
        if (this.selectedId == -1) {
            showDialog1(this.alertText, getString(R.string.selectAnyOneMsg));
            return false;
        }
        if (!this.binding.indianWithPriorVoterID.isChecked() && checkedRadioButtonId == -1) {
            showDialog1(this.alertText, getString(R.string.relative_2003_relativeYesNoRadioCheck));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.relationCode)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_spinnerErroe));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.oldState)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_OldStateError));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.oldAc)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_OldAcError));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.OldPart)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPartNoError));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.binding.oldPslNo.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPSLError));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && !this.issearchdetailsbuttonclicked) {
            showDialog1(this.alertText, getString(R.string.validate_eroll_details));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && !this.isThisYou && TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_supporting_proof_2003));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && this.isThisYou && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_proof_2003));
            return false;
        }
        if (!this.binding.relative2003Yes.isChecked() || this.isThisYou || !TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.relative_proof_2003));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda11
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, String listCode) {
        this.currentImagePickerId = code;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.epicNumber.replaceAll("/", "_") + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$19(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$19(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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
        new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$20(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$20(DialogInterface dialogInterface, int i) {
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$21(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$22(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$21(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.binding.orText.setVisibility(8);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$22(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.binding.orText.setVisibility(8);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:195:0x0b17  */
    /* JADX WARN: Code duplicated, block: B:198:0x0b1c  */
    /* JADX WARN: Code duplicated, block: B:201:0x0b24  */
    /* JADX WARN: Code duplicated, block: B:203:0x0b28 A[Catch: Exception -> 0x0d52, TRY_ENTER, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0b76 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0b93 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0bd5 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0bf0 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x0bf4 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0c0a A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x0c89 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x0c9b A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0cc0 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0cc4 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x0ce1 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x0d47 A[Catch: Exception -> 0x0d52, TryCatch #8 {Exception -> 0x0d52, blocks: (B:203:0x0b28, B:205:0x0b76, B:206:0x0b7b, B:208:0x0bbe, B:210:0x0bd5, B:212:0x0bf0, B:214:0x0bf4, B:216:0x0c11, B:225:0x0d43, B:215:0x0c0a, B:217:0x0c89, B:219:0x0c9b, B:220:0x0cc0, B:222:0x0cc4, B:224:0x0cea, B:223:0x0ce1, B:226:0x0d47, B:227:0x0d51, B:207:0x0b93), top: B:246:0x0b26 }] */
    /* JADX WARN: Code duplicated, block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v41 */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v43 */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARN: Type inference failed for: r15v45 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v48 */
    /* JADX WARN: Type inference failed for: r15v49 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v50 */
    /* JADX WARN: Type inference failed for: r15v51 */
    /* JADX WARN: Type inference failed for: r15v52 */
    /* JADX WARN: Type inference failed for: r15v53 */
    /* JADX WARN: Type inference failed for: r15v54 */
    /* JADX WARN: Type inference failed for: r15v55 */
    /* JADX WARN: Type inference failed for: r15v56 */
    /* JADX WARN: Type inference failed for: r15v57 */
    /* JADX WARN: Type inference failed for: r15v58 */
    /* JADX WARN: Type inference failed for: r15v59 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v60 */
    /* JADX WARN: Type inference failed for: r15v61 */
    /* JADX WARN: Type inference failed for: r15v64 */
    /* JADX WARN: Type inference failed for: r15v65 */
    /* JADX WARN: Type inference failed for: r15v66 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v101, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v103, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v149, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v184, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v228, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v252, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v296, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v320, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v364, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v388, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v432, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v458, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v505, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v87, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v89, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v91, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v93, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v95, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v26 */
    /* JADX WARN: Type inference failed for: r22v27 */
    /* JADX WARN: Type inference failed for: r22v28 */
    /* JADX WARN: Type inference failed for: r22v29 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v30 */
    /* JADX WARN: Type inference failed for: r22v31 */
    /* JADX WARN: Type inference failed for: r22v32 */
    /* JADX WARN: Type inference failed for: r22v33 */
    /* JADX WARN: Type inference failed for: r22v34 */
    /* JADX WARN: Type inference failed for: r22v35 */
    /* JADX WARN: Type inference failed for: r22v36 */
    /* JADX WARN: Type inference failed for: r22v37 */
    /* JADX WARN: Type inference failed for: r22v38 */
    /* JADX WARN: Type inference failed for: r22v39 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v40 */
    /* JADX WARN: Type inference failed for: r22v41 */
    /* JADX WARN: Type inference failed for: r22v42 */
    /* JADX WARN: Type inference failed for: r22v43 */
    /* JADX WARN: Type inference failed for: r22v44 */
    /* JADX WARN: Type inference failed for: r22v45 */
    /* JADX WARN: Type inference failed for: r22v46 */
    /* JADX WARN: Type inference failed for: r22v47 */
    /* JADX WARN: Type inference failed for: r22v48 */
    /* JADX WARN: Type inference failed for: r22v49 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v50 */
    /* JADX WARN: Type inference failed for: r22v51 */
    /* JADX WARN: Type inference failed for: r22v52 */
    /* JADX WARN: Type inference failed for: r22v53 */
    /* JADX WARN: Type inference failed for: r22v54 */
    /* JADX WARN: Type inference failed for: r22v55 */
    /* JADX WARN: Type inference failed for: r22v56 */
    /* JADX WARN: Type inference failed for: r22v6, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r22v60 */
    /* JADX WARN: Type inference failed for: r22v61 */
    /* JADX WARN: Type inference failed for: r22v62 */
    /* JADX WARN: Type inference failed for: r22v63 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r2v111, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v122, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v141, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v152, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v171, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v182, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v201, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v216, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v236, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v238, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v45, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v61, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v69, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v81, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v93, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r42v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SuperBaseActivity, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v8 */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r15;
        ?? r22;
        ?? r6;
        Uri uri;
        int i3;
        ?? r12;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        String str;
        long j;
        double dRound;
        File file;
        ?? applicationContext;
        ?? r23;
        ?? r16;
        ?? r7;
        Exception exc;
        ?? r24;
        ?? r17;
        ?? r8;
        ?? r25;
        ?? r18;
        ?? r26;
        String str2;
        String str3;
        Object obj;
        ?? r14;
        String str4;
        String str5;
        ?? r27;
        char c;
        ?? r28;
        Object obj2;
        Object obj3;
        int i4;
        ?? r13;
        Object obj4;
        ?? r19;
        ?? r110;
        String str6 = "img_";
        super.onActivityResult(i, i2, intent);
        String str7 = "/";
        ?? r111 = 80;
        ?? r112 = 80;
        char c2 = 1;
        if (i2 != -1) {
            r15 = "KB";
            r22 = "img_";
            str7 = "/";
            r6 = 8;
            str6 = "MB";
            if (i == 0) {
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
                applicationContext = getApplicationContext();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.pdfbyteArray = byteArray;
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    ?? Split = saveImagePath2.getPath().split("/");
                    ?? r2 = Split[Split.length - 1];
                    try {
                        if (i != 101) {
                            data = data;
                            r111 = "KB";
                            applicationContext = "img_";
                            str7 = "/";
                            str6 = "MB";
                            if (i == 102) {
                                long j2 = this.filesize;
                                if (j2 < 1024) {
                                    if (this.onlineStatus) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.photo2Ref = r2;
                                        Log.d(this.TAG, this.photo2Ref + "exact");
                                    }
                                    this.binding.photo2Layout.setVisibility(0);
                                    this.binding.cancelPhoto2Annexure.setVisibility(0);
                                    this.binding.photo2Name.setVisibility(0);
                                    this.binding.photo2Size.setVisibility(0);
                                    this.binding.photo2.setVisibility(0);
                                    ImageView imageView = this.binding.photo2;
                                    byte[] bArr = this.pdfbyteArray;
                                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                    this.binding.photo2Annexure.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.photo2Annexure.setEnabled(false);
                                    this.binding.photo2Name.setText(Split[Split.length - 1]);
                                    this.binding.photo2Size.setText(new StringBuilder().append(this.filesize).append(r111).toString());
                                    r110 = r111;
                                    r27 = applicationContext;
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
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else {
                                    long j3 = j2 / 1024;
                                    this.filesize = j3;
                                    double dRound2 = Math.round(j3 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.photo2Annexure.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else {
                                        if (this.onlineStatus) {
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        } else {
                                            this.alertDialog.dismiss();
                                            this.photo2Ref = r2;
                                            Log.d(this.TAG, this.photo2Ref + "exact");
                                        }
                                        this.binding.photo2Layout.setVisibility(0);
                                        this.binding.cancelPhoto2Annexure.setVisibility(0);
                                        this.binding.photo2Name.setVisibility(0);
                                        this.binding.photo2Size.setVisibility(0);
                                        this.binding.photo2.setVisibility(0);
                                        ImageView imageView2 = this.binding.photo2;
                                        byte[] bArr2 = this.pdfbyteArray;
                                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                        this.binding.photo2Annexure.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.photo2Annexure.setEnabled(false);
                                        this.binding.photo2Name.setText(Split[Split.length - 1]);
                                        this.binding.photo2Size.setText(dRound2 + str6);
                                        r110 = r111;
                                        r27 = applicationContext;
                                    }
                                }
                            } else if (i == 201) {
                                long j4 = this.filesize;
                                if (j4 < 1024) {
                                    this.alertDialog.dismiss();
                                    this.relativeDocument1UrlS = r2;
                                    Log.d(this.TAG, "enumeration form page 1");
                                    this.binding.enumerationFormPage1.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                    ImageView imageView3 = this.binding.enumerationFormPage1Image;
                                    byte[] bArr3 = this.pdfbyteArray;
                                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                    this.binding.enumerationFormPage1ImageName.setText(Split[Split.length - 1]);
                                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else if (j4 > 2048) {
                                    this.binding.enumerationFormPage1.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage1Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage1.setEnabled(true);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else {
                                    long j5 = j4 / 1024;
                                    this.filesize = j5;
                                    double dRound3 = Math.round(j5 * 100.0d) / 100.0d;
                                    if (dRound3 > 2.0d) {
                                        this.binding.enumerationFormPage1.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage1.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeDocument1UrlS = r2;
                                        this.binding.enumerationFormPage1.setVisibility(0);
                                        this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                        this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                        this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                        this.binding.enumerationFormPage1Image.setVisibility(0);
                                        ImageView imageView4 = this.binding.enumerationFormPage1Image;
                                        byte[] bArr4 = this.pdfbyteArray;
                                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                        this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                        this.binding.enumerationFormPage1ImageName.setText(Split[Split.length - 1]);
                                        this.binding.enumerationFormPage1ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                        r110 = r111;
                                        r27 = applicationContext;
                                    }
                                }
                            } else if (i == 202) {
                                long j6 = this.filesize;
                                if (j6 < 1024) {
                                    this.alertDialog.dismiss();
                                    this.relativeDocument2UrlS = r2;
                                    Log.d(this.TAG, "enumeration form page 2");
                                    this.binding.enumerationFormPage2.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                    ImageView imageView5 = this.binding.enumerationFormPage2Image;
                                    byte[] bArr5 = this.pdfbyteArray;
                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                    this.binding.enumerationFormPage2ImageName.setText(Split[Split.length - 1]);
                                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else if (j6 > 2048) {
                                    this.binding.enumerationFormPage2.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage2.setEnabled(true);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else {
                                    long j7 = j6 / 1024;
                                    this.filesize = j7;
                                    double dRound4 = Math.round(j7 * 100.0d) / 100.0d;
                                    if (dRound4 > 2.0d) {
                                        this.binding.enumerationFormPage2Image.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage2.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeDocument2UrlS = r2;
                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                        this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                        this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                        this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                        ImageView imageView6 = this.binding.enumerationFormPage2Image;
                                        byte[] bArr6 = this.pdfbyteArray;
                                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                        this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                        this.binding.enumerationFormPage2ImageName.setText(Split[Split.length - 1]);
                                        this.binding.enumerationFormPage2ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                        r110 = r111;
                                        r27 = applicationContext;
                                    }
                                }
                            } else if (i == 203) {
                                long j8 = this.filesize;
                                if (j8 < 1024) {
                                    this.alertDialog.dismiss();
                                    this.relativeSupportingDocumentPage1UrlS = r2;
                                    Log.d(this.TAG, "proof of relation form page 1");
                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                    ImageView imageView7 = this.binding.supportingDocumentsPage1Image;
                                    byte[] bArr7 = this.pdfbyteArray;
                                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                    this.binding.supportingDocumentsPage1ImageName.setText(Split[Split.length - 1]);
                                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else if (j8 > 2048) {
                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                    r110 = r111;
                                    r27 = applicationContext;
                                } else {
                                    long j9 = j8 / 1024;
                                    this.filesize = j9;
                                    double dRound5 = Math.round(j9 * 100.0d) / 100.0d;
                                    if (dRound5 > 2.0d) {
                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeSupportingDocumentPage1UrlS = r2;
                                        this.binding.supportingDocumentsPage1.setVisibility(0);
                                        this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                        this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                        this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                        this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                        ImageView imageView8 = this.binding.supportingDocumentsPage1Image;
                                        byte[] bArr8 = this.pdfbyteArray;
                                        imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                                        this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                        this.binding.supportingDocumentsPage1ImageName.setText(Split[Split.length - 1]);
                                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound5 + getString(R.string.mbMsg));
                                        r110 = r111;
                                        r27 = applicationContext;
                                    }
                                }
                            } else if (i == 204) {
                                try {
                                    r110 = r111;
                                    r27 = applicationContext;
                                    long j10 = this.filesize;
                                    if (j10 < 1024) {
                                        this.alertDialog.dismiss();
                                        this.relativeSupportingDocumentPage2UrlS = r2;
                                        Log.d(this.TAG, "proof of relation form page 2");
                                        this.binding.supportingDocumentsPage2.setVisibility(0);
                                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                        this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                        this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                        ImageView imageView9 = this.binding.supportingDocumentsPage2Image;
                                        byte[] bArr9 = this.pdfbyteArray;
                                        imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                                        this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                        this.binding.supportingDocumentsPage2ImageName.setText(Split[Split.length - 1]);
                                        this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else if (j10 > 2048) {
                                        this.binding.supportingDocumentsPage2.setVisibility(8);
                                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                        this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                        this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
                                        this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                        this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                        showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                        r110 = r111;
                                        r27 = applicationContext;
                                    } else {
                                        long j11 = j10 / 1024;
                                        this.filesize = j11;
                                        double dRound6 = Math.round(j11 * 100.0d) / 100.0d;
                                        if (dRound6 > 2.0d) {
                                            c = '\b';
                                            this.binding.supportingDocumentsPage1.setVisibility(8);
                                            this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
                                            showDialog1(this.alertText, this.imgmsg);
                                            r19 = r111;
                                            r28 = applicationContext;
                                        } else {
                                            c = '\b';
                                            this.alertDialog.dismiss();
                                            this.relativeSupportingDocumentPage2UrlS = r2;
                                            this.binding.supportingDocumentsPage2.setVisibility(0);
                                            this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                            this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                            this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                            this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                            ImageView imageView10 = this.binding.supportingDocumentsPage2Image;
                                            byte[] bArr10 = this.pdfbyteArray;
                                            imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                                            this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                            this.binding.supportingDocumentsPage2ImageName.setText(Split[Split.length - 1]);
                                            this.binding.supportingDocumentsPage2ImageSize.setText(dRound6 + getString(R.string.mbMsg));
                                            r19 = r111;
                                            r28 = applicationContext;
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    c2 = '\b';
                                    exc = e;
                                    r7 = c2;
                                    r16 = r111;
                                    r23 = applicationContext;
                                    Logger.d("", exc.getMessage());
                                    r8 = r7;
                                    r17 = r16;
                                    r24 = r23;
                                }
                            }
                            r110 = r111;
                            r27 = applicationContext;
                            c = '\b';
                            r19 = r110;
                            r28 = r27;
                        } else {
                            try {
                                long j12 = this.filesize;
                                if (j12 >= 1024) {
                                    data = data;
                                    String str8 = "KB";
                                    str3 = "MB";
                                    str7 = "/";
                                    try {
                                        if (j12 > 2048) {
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
                                                c = '\b';
                                                r28 = "img_";
                                                str6 = str3;
                                                r19 = str8;
                                            } catch (Exception e2) {
                                                e = e2;
                                                Split = 8;
                                                exc = e;
                                                r7 = Split;
                                                r23 = "img_";
                                                str6 = str3;
                                                r16 = str8;
                                                Logger.d("", exc.getMessage());
                                                r8 = r7;
                                                r17 = r16;
                                                r24 = r23;
                                            }
                                        } else {
                                            try {
                                                long j13 = j12 / 1024;
                                                this.filesize = j13;
                                                double dRound7 = Math.round(j13 * 100.0d) / 100.0d;
                                                if (dRound7 > 2.0d) {
                                                    this.binding.annexPage1Layout.setVisibility(8);
                                                    this.binding.photo1Annexure.setEnabled(true);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                    str5 = str8;
                                                    r27 = "img_";
                                                    str6 = str3;
                                                    r110 = str5;
                                                } else {
                                                    if (this.onlineStatus) {
                                                        try {
                                                            try {
                                                                obj3 = "img_";
                                                                try {
                                                                    i4 = 1;
                                                                    r13 = Split;
                                                                    try {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                                        obj4 = obj3;
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        exc = e;
                                                                        str4 = str8;
                                                                        obj = obj3;
                                                                        str6 = str3;
                                                                        r18 = str4;
                                                                        r25 = obj;
                                                                        r7 = 8;
                                                                        r16 = r18;
                                                                        r23 = r25;
                                                                        Logger.d("", exc.getMessage());
                                                                        r8 = r7;
                                                                        r17 = r16;
                                                                        r24 = r23;
                                                                    }
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    exc = e;
                                                                    str4 = str8;
                                                                    obj = obj3;
                                                                    str6 = str3;
                                                                    r18 = str4;
                                                                    r25 = obj;
                                                                    r7 = 8;
                                                                    r16 = r18;
                                                                    r23 = r25;
                                                                    Logger.d("", exc.getMessage());
                                                                    r8 = r7;
                                                                    r17 = r16;
                                                                    r24 = r23;
                                                                    uri = data;
                                                                    r6 = r8;
                                                                    r15 = r17;
                                                                    r22 = r24;
                                                                    if (i != 100) {
                                                                        i3 = 10001;
                                                                        if (i != 10001) {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        i3 = 10001;
                                                                    }
                                                                    r12 = r6;
                                                                    if (i2 == -1) {
                                                                        try {
                                                                            if (i == i3) {
                                                                                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                                                this.saveImageFileName = ((String) r22) + this.temp + this.jpgTextBaseActivity;
                                                                                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                                                if (file.exists()) {
                                                                                    Log.e("extract", "extract true");
                                                                                }
                                                                                this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
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
                                                                            strArrSplit = saveImagePath.getPath().split(str7);
                                                                            str = strArrSplit[strArrSplit.length - 1];
                                                                            Log.e("extract", str);
                                                                            j = this.filesize;
                                                                            if (j < 1024) {
                                                                                if (this.onlineStatus) {
                                                                                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                                } else {
                                                                                    this.alertDialog.dismiss();
                                                                                    this.photoref = str;
                                                                                }
                                                                                this.binding.passPhotoLayout.setVisibility(0);
                                                                                this.binding.passPhoto.setVisibility(r12 == true ? 1 : 0);
                                                                                this.binding.cancel.setVisibility(0);
                                                                                this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                                                                                this.binding.chooseFileTv.setEnabled(false);
                                                                                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                                this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r15).toString());
                                                                                this.binding.photoSize.setVisibility(0);
                                                                                this.binding.photoNameTv2.setVisibility(0);
                                                                                this.binding.image.setVisibility(0);
                                                                                ImageView imageView11 = this.binding.image;
                                                                                byte[] bArr11 = this.byteArray;
                                                                                imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                                                                            } else {
                                                                                long j14 = j / 1024;
                                                                                this.filesize = j14;
                                                                                dRound = Math.round(j14 * 100.0d) / 100.0d;
                                                                                if (dRound > 2.0d) {
                                                                                    this.binding.passPhotoLayout.setVisibility(r12 == true ? 1 : 0);
                                                                                    this.binding.chooseFileTv.setEnabled(true);
                                                                                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                                } else {
                                                                                    if (this.onlineStatus) {
                                                                                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                                    } else {
                                                                                        this.alertDialog.dismiss();
                                                                                        this.photoref = str;
                                                                                    }
                                                                                    this.binding.passPhoto.setVisibility(r12 == true ? 1 : 0);
                                                                                    this.binding.passPhotoLayout.setVisibility(0);
                                                                                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                                                                                    this.binding.chooseFileTv.setEnabled(false);
                                                                                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                                    this.binding.photoSize.setText(dRound + str6);
                                                                                    ImageView imageView12 = this.binding.image;
                                                                                    byte[] bArr12 = this.byteArray;
                                                                                    imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                                                                                }
                                                                            }
                                                                            cursorQuery.close();
                                                                        } catch (Exception e5) {
                                                                            Logger.d("tag", e5.getMessage());
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Exception e6) {
                                                                e = e6;
                                                                obj3 = "img_";
                                                            }
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            obj3 = "img_";
                                                        }
                                                    } else {
                                                        i4 = 1;
                                                        r13 = Split;
                                                        obj4 = "img_";
                                                        try {
                                                            this.alertDialog.dismiss();
                                                            this.photo1Ref = r2;
                                                            obj4 = obj4;
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            obj2 = obj4;
                                                            str6 = str3;
                                                            r112 = str8;
                                                            r26 = obj2;
                                                            exc = e;
                                                            r18 = r112;
                                                            r25 = r26;
                                                            r7 = 8;
                                                            r16 = r18;
                                                            r23 = r25;
                                                            Logger.d("", exc.getMessage());
                                                            r8 = r7;
                                                            r17 = r16;
                                                            r24 = r23;
                                                        }
                                                    }
                                                    this.binding.annexPage1Layout.setVisibility(0);
                                                    this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                    this.binding.photo1Name.setVisibility(0);
                                                    this.binding.photo1Size.setVisibility(0);
                                                    this.binding.photo1.setVisibility(0);
                                                    ImageView imageView13 = this.binding.photo1;
                                                    byte[] bArr13 = this.pdfbyteArray;
                                                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                                                    this.binding.photo1Annexure.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.photo1Annexure.setEnabled(false);
                                                    this.binding.photo1Name.setText(r13[r13.length - i4]);
                                                    str6 = str3;
                                                    this.binding.photo1Size.setText(dRound7 + str6);
                                                    r110 = str8;
                                                    r27 = obj4;
                                                }
                                                r110 = r111;
                                                r27 = applicationContext;
                                                c = '\b';
                                                r19 = r110;
                                                r28 = r27;
                                            } catch (Exception e9) {
                                                e = e9;
                                                obj2 = "img_";
                                            }
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                    }
                                } else {
                                    try {
                                        if (this.onlineStatus) {
                                            try {
                                                try {
                                                    try {
                                                        data = data;
                                                        str7 = "/";
                                                        r14 = 0;
                                                        str2 = "KB";
                                                        str3 = "MB";
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            str2 = str2;
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            exc = e;
                                                            obj = "img_";
                                                            str4 = str2;
                                                            str6 = str3;
                                                            r18 = str4;
                                                            r25 = obj;
                                                            r7 = 8;
                                                            r16 = r18;
                                                            r23 = r25;
                                                            Logger.d("", exc.getMessage());
                                                            r8 = r7;
                                                            r17 = r16;
                                                            r24 = r23;
                                                        }
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        str2 = "KB";
                                                        str3 = "MB";
                                                        exc = e;
                                                        obj = "img_";
                                                        str4 = str2;
                                                        str6 = str3;
                                                        r18 = str4;
                                                        r25 = obj;
                                                        r7 = 8;
                                                        r16 = r18;
                                                        r23 = r25;
                                                        Logger.d("", exc.getMessage());
                                                        r8 = r7;
                                                        r17 = r16;
                                                        r24 = r23;
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    str3 = "MB";
                                                    str2 = "KB";
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                str2 = "KB";
                                                str3 = "MB";
                                            }
                                        } else {
                                            data = data;
                                            str2 = "KB";
                                            str3 = "MB";
                                            str7 = "/";
                                            r14 = 0;
                                            try {
                                                this.alertDialog.dismiss();
                                                this.photo1Ref = r2;
                                                str2 = str2;
                                            } catch (Exception e15) {
                                                e = e15;
                                                exc = e;
                                                obj = "img_";
                                                str4 = str2;
                                                str6 = str3;
                                                r18 = str4;
                                                r25 = obj;
                                                r7 = 8;
                                                r16 = r18;
                                                r23 = r25;
                                                Logger.d("", exc.getMessage());
                                                r8 = r7;
                                                r17 = r16;
                                                r24 = r23;
                                            }
                                        }
                                        this.binding.annexPage1Layout.setVisibility(r14);
                                        this.binding.cancelPhoto1Annexure.setVisibility(r14);
                                        this.binding.photo1Name.setVisibility(r14);
                                        this.binding.photo1Size.setVisibility(r14);
                                        this.binding.photo1.setVisibility(r14);
                                        ImageView imageView14 = this.binding.photo1;
                                        byte[] bArr14 = this.pdfbyteArray;
                                        imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, r14, bArr14.length));
                                        this.binding.photo1Annexure.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.photo1Annexure.setEnabled(r14);
                                        this.binding.photo1Name.setText(Split[Split.length - 1]);
                                        this.binding.photo1Size.setText(this.filesize + str2);
                                        str5 = str2;
                                        r27 = "img_";
                                        str6 = str3;
                                        r110 = str5;
                                        r110 = r111;
                                        r27 = applicationContext;
                                        c = '\b';
                                        r19 = r110;
                                        r28 = r27;
                                    } catch (Exception e16) {
                                        e = e16;
                                        str2 = "KB";
                                        str3 = "MB";
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                data = data;
                                r112 = "KB";
                                r26 = "img_";
                                str7 = "/";
                                str6 = "MB";
                            }
                        }
                        cursorQuery2.close();
                        r8 = c;
                        r17 = r19;
                        r24 = r28;
                    } catch (Exception e18) {
                        e = e18;
                        r26 = applicationContext;
                    }
                    uri = data;
                    r6 = r8;
                    r15 = r17;
                    r22 = r24;
                } catch (Exception e19) {
                    e = e19;
                }
            } catch (Exception e20) {
                e = e20;
                data = data;
                r111 = "KB";
                applicationContext = "img_";
                str7 = "/";
                c2 = '\b';
                str6 = "MB";
            }
            exc = e;
            r7 = c2;
            r16 = r111;
            r23 = applicationContext;
            Logger.d("", exc.getMessage());
            r8 = r7;
            r17 = r16;
            r24 = r23;
            uri = data;
            r6 = r8;
            r15 = r17;
            r22 = r24;
        }
        if (i != 100) {
            i3 = 10001;
            if (i != 10001) {
                return;
            }
        } else {
            i3 = 10001;
        }
        r12 = r6;
        if (i2 == -1) {
            if (i == i3) {
                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                this.saveImageFileName = ((String) r22) + this.temp + this.jpgTextBaseActivity;
                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                if (file.exists()) {
                    Log.e("extract", "extract true");
                }
                this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
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
            strArrSplit = saveImagePath.getPath().split(str7);
            str = strArrSplit[strArrSplit.length - 1];
            Log.e("extract", str);
            j = this.filesize;
            if (j < 1024) {
                if (this.onlineStatus) {
                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                } else {
                    this.alertDialog.dismiss();
                    this.photoref = str;
                }
                this.binding.passPhotoLayout.setVisibility(0);
                this.binding.passPhoto.setVisibility(r12 == true ? 1 : 0);
                this.binding.cancel.setVisibility(0);
                this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileTv.setEnabled(false);
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r15).toString());
                this.binding.photoSize.setVisibility(0);
                this.binding.photoNameTv2.setVisibility(0);
                this.binding.image.setVisibility(0);
                ImageView imageView15 = this.binding.image;
                byte[] bArr15 = this.byteArray;
                imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
            } else {
                long j15 = j / 1024;
                this.filesize = j15;
                dRound = Math.round(j15 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.passPhotoLayout.setVisibility(r12 == true ? 1 : 0);
                    this.binding.chooseFileTv.setEnabled(true);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                    showDialog1(this.alertText, this.imgmsg);
                } else {
                    if (this.onlineStatus) {
                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        this.photoref = str;
                    }
                    this.binding.passPhoto.setVisibility(r12 == true ? 1 : 0);
                    this.binding.passPhotoLayout.setVisibility(0);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileTv.setEnabled(false);
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photoSize.setText(dRound + str6);
                    ImageView imageView16 = this.binding.image;
                    byte[] bArr16 = this.byteArray;
                    imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                }
            }
            cursorQuery.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass40(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$40, reason: invalid class name */
    class AnonymousClass40 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass40(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                Context applicationContext = SpecialRevisionDetails.this.getApplicationContext();
                String str = SpecialRevisionDetails.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$40$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                if (this.val$uploadtype.equalsIgnoreCase(SpecialRevisionDetails.this.photostr)) {
                    SpecialRevisionDetails.this.photoref = this.val$captureFileName;
                    return;
                }
                return;
            }
            try {
                SpecialRevisionDetails.this.binding.passPhotoLayout.setVisibility(8);
                SpecialRevisionDetails.this.binding.passPhoto.setVisibility(0);
                SpecialRevisionDetails.this.binding.chooseFileTv.setEnabled(true);
                SpecialRevisionDetails.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetails.this.whitecolor));
                new JSONObject(response.errorBody().string());
                SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, SpecialRevisionDetails.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r2 = SpecialRevisionDetails.this;
                commomUtility.showMessageOK(r2, ((SpecialRevisionDetails) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$40$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDetails.this.token = "Bearer " + str8;
            SpecialRevisionDetails.this.refreshToken = str9;
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setToken("Bearer " + str8);
            SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
            specialRevisionDetails.faceRecognition(str, str2, str3, str4, str5, specialRevisionDetails.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetails.this.startActivity(new Intent(SpecialRevisionDetails.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            SpecialRevisionDetails.this.binding.passPhotoLayout.setVisibility(8);
            SpecialRevisionDetails.this.binding.chooseFileTv.setEnabled(true);
            SpecialRevisionDetails.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetails.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
            specialRevisionDetails.showDialog1(specialRevisionDetails.alertText, t.getMessage());
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
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
            ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass41(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$41, reason: invalid class name */
    class AnonymousClass41 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass41(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v18, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r13 = SpecialRevisionDetails.this;
                String str = ((SpecialRevisionDetails) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$41$$ExternalSyntheticLambda0
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
                        SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                        specialRevisionDetails.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetails.token, this.val$reference, this.val$uploadtype);
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
                    if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photostr)) {
                        SpecialRevisionDetails.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (SpecialRevisionDetails.this.alertDialog != null) {
                            SpecialRevisionDetails.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo1Str)) {
                        SpecialRevisionDetails.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (SpecialRevisionDetails.this.alertDialog != null) {
                            SpecialRevisionDetails.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo2str)) {
                        SpecialRevisionDetails.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (SpecialRevisionDetails.this.alertDialog != null) {
                            SpecialRevisionDetails.this.alertDialog.dismiss();
                        }
                    }
                    Logger.d(SpecialRevisionDetails.this.TAG, "Presigned URL : " + strDecryptUrl);
                    UploadWithPreSignedURL.uploadToS3(this.val$filepath + this.val$captureFileName, SpecialRevisionDetails.this.mime, strDecryptUrl, null);
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photostr)) {
                if (SpecialRevisionDetails.this.alertDialog != null) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                }
                SpecialRevisionDetails.this.photocount = 0;
                SpecialRevisionDetails.this.binding.chooseFileTv.setEnabled(true);
                SpecialRevisionDetails.this.binding.passPhotoLayout.setVisibility(8);
                SpecialRevisionDetails specialRevisionDetails2 = SpecialRevisionDetails.this;
                specialRevisionDetails2.showDialog1(specialRevisionDetails2.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo1Str)) {
                if (SpecialRevisionDetails.this.alertDialog != null) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                }
                SpecialRevisionDetails.this.photo1count = 0;
                SpecialRevisionDetails.this.binding.annexPage1Layout.setVisibility(8);
                SpecialRevisionDetails.this.binding.photo1Annexure.setEnabled(true);
                SpecialRevisionDetails specialRevisionDetails3 = SpecialRevisionDetails.this;
                specialRevisionDetails3.showDialog1(specialRevisionDetails3.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo2str)) {
                if (SpecialRevisionDetails.this.alertDialog != null) {
                    SpecialRevisionDetails.this.alertDialog.dismiss();
                }
                SpecialRevisionDetails.this.photo2count = 0;
                SpecialRevisionDetails.this.binding.photo2Annexure.setEnabled(true);
                SpecialRevisionDetails.this.binding.photo2Layout.setVisibility(8);
                SpecialRevisionDetails specialRevisionDetails4 = SpecialRevisionDetails.this;
                specialRevisionDetails4.showDialog1(specialRevisionDetails4.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
            }
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
                CommomUtility commomUtility = SpecialRevisionDetails.this.commomUtility;
                ?? r2 = SpecialRevisionDetails.this;
                commomUtility.showMessageOK(r2, ((SpecialRevisionDetails) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$41$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDetails.this.token = "Bearer " + str8;
            SpecialRevisionDetails.this.refreshToken = str9;
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setToken("Bearer " + str8);
            SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
            specialRevisionDetails.uploadPhoto(str, str2, str3, str4, str5, specialRevisionDetails.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetails.this.startActivity(new Intent((Context) SpecialRevisionDetails.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SpecialRevisionDetails.this.alertDialog != null) {
                SpecialRevisionDetails.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photostr)) {
                if (SpecialRevisionDetails.this.photocount < 2 && TextUtils.isEmpty(SpecialRevisionDetails.this.photoref)) {
                    SpecialRevisionDetails.this.photocount++;
                    SpecialRevisionDetails specialRevisionDetails = SpecialRevisionDetails.this;
                    specialRevisionDetails.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetails.token, this.val$reference, this.val$uploadtype);
                } else {
                    SpecialRevisionDetails.this.photocount = 0;
                    SpecialRevisionDetails.this.binding.passPhotoLayout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetails.this.whitecolor));
                    SpecialRevisionDetails.this.binding.chooseFileTv.setEnabled(true);
                    SpecialRevisionDetails specialRevisionDetails2 = SpecialRevisionDetails.this;
                    specialRevisionDetails2.showDialog1(specialRevisionDetails2.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo1Str)) {
                if (SpecialRevisionDetails.this.photo1count < 2 && TextUtils.isEmpty(SpecialRevisionDetails.this.photo1Ref)) {
                    SpecialRevisionDetails.this.photo1count++;
                    SpecialRevisionDetails specialRevisionDetails3 = SpecialRevisionDetails.this;
                    specialRevisionDetails3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetails3.token, this.val$reference, this.val$uploadtype);
                } else {
                    SpecialRevisionDetails.this.photo1count = 0;
                    SpecialRevisionDetails.this.binding.annexPage1Layout.setVisibility(8);
                    SpecialRevisionDetails.this.binding.photo1Annexure.setTextColor(Color.parseColor(SpecialRevisionDetails.this.blackColor));
                    SpecialRevisionDetails.this.binding.photo1Annexure.setEnabled(true);
                    SpecialRevisionDetails specialRevisionDetails4 = SpecialRevisionDetails.this;
                    specialRevisionDetails4.showDialog1(specialRevisionDetails4.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetails.this.photo2str)) {
                if (SpecialRevisionDetails.this.photo2count < 2 && TextUtils.isEmpty(SpecialRevisionDetails.this.photo2Ref)) {
                    SpecialRevisionDetails.this.photo2count++;
                    SpecialRevisionDetails specialRevisionDetails5 = SpecialRevisionDetails.this;
                    specialRevisionDetails5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetails5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                SpecialRevisionDetails.this.photo2count = 0;
                SpecialRevisionDetails.this.binding.photo2Layout.setVisibility(8);
                SpecialRevisionDetails.this.binding.photo2Annexure.setTextColor(Color.parseColor(SpecialRevisionDetails.this.blackColor));
                SpecialRevisionDetails.this.binding.photo2Annexure.setEnabled(true);
                SpecialRevisionDetails specialRevisionDetails6 = SpecialRevisionDetails.this;
                specialRevisionDetails6.showDialog1(specialRevisionDetails6.alertText, SpecialRevisionDetails.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("Retry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$23(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$23(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sentDataToNext() {
        Intent intent = new Intent((Context) this, (Class<?>) SpecialRevisionDocuments.class);
        this.selectedText = "";
        this.dobVerified = this.binding.dateOfBirth.getText().toString();
        if (this.binding.indianWithPriorVoterID.isChecked()) {
            this.selectedText = this.binding.indianWithPriorVoterID.getText().toString();
        } else if (this.binding.bornInIndia.isChecked()) {
            this.selectedText = this.binding.bornInIndia.getText().toString();
            if (this.binding.bornBefore1987rb.isChecked()) {
                this.selectedText = this.binding.bornBefore1987rb.getText().toString();
            } else if (this.binding.bornBefore2004rb.isChecked()) {
                this.selectedText = this.binding.bornBefore2004rb.getText().toString();
            } else if (this.binding.bornAfter2004rb.isChecked()) {
                this.selectedText = this.binding.bornAfter2004rb.getText().toString();
            }
        } else if (this.binding.notBornInIndia.isChecked()) {
            this.selectedText = this.binding.notBornInIndia.getText().toString();
        } else if (this.binding.indianCitizen.isChecked()) {
            this.selectedText = this.binding.indianCitizen.getText().toString();
        }
        intent.putExtra("aadharNo", this.aadharref);
        intent.putExtra("mobileNo", this.mobile);
        intent.putExtra("dobverified", this.dobVerified);
        intent.putExtra("fatherName", this.fatherName);
        intent.putExtra("fatherEpic", this.fatherEpicNo);
        intent.putExtra("motherEpic", this.motherEpicNo);
        intent.putExtra("motherName", this.motherName);
        intent.putExtra("spouseName", this.spouseName);
        intent.putExtra("spouseEpic", this.spouseEpicNo);
        intent.putExtra("photo1ref", this.photo1Ref);
        intent.putExtra("photo2ref", this.photo2Ref);
        intent.putExtra("photo-url", this.photoref);
        intent.putExtra("epicNo", this.epicNumber);
        intent.putExtra("epicId", this.epicId);
        intent.putExtra("houseNo", this.houseNumber);
        intent.putExtra("dob", this.erollDoB);
        intent.putExtra("partSerialNo", this.serial);
        intent.putExtra("surveyChannel", "BLO");
        intent.putExtra("radio_choice", this.selectedText);
        intent.putExtra("isRelative2003", this.binding.relative2003Yes.isChecked() ? "Y" : "N");
        intent.putExtra("relationList8Code", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.list8code)) ? "" : this.list8code);
        intent.putExtra("relationList8DocPage1", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) ? "" : this.relativeSupportingDocumentPage1UrlS);
        intent.putExtra("relationList8DocPage2", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) ? "" : this.relativeSupportingDocumentPage2UrlS);
        intent.putExtra("relationCode", this.binding.relative2003Yes.isChecked() ? this.relationCode : "");
        intent.putExtra("relationProofDocPage1", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeDocument1UrlS)) ? "" : this.relativeDocument1UrlS);
        intent.putExtra("relationProofDocPage2", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeDocument2UrlS)) ? "" : this.relativeDocument2UrlS);
        intent.putExtra("relationOldAcNo", this.binding.relative2003Yes.isChecked() ? this.oldAc : "");
        intent.putExtra("relationOldStateCd", this.binding.relative2003Yes.isChecked() ? this.oldState : "");
        intent.putExtra("relationOldPartNo", this.binding.relative2003Yes.isChecked() ? this.OldPart : "");
        intent.putExtra("relationOldPSLNo", this.binding.relative2003Yes.isChecked() ? this.binding.oldPslNo.getText().toString() : "");
        intent.putExtra("relativeEpic", this.binding.edtRelativeEpic.getText().toString());
        intent.putExtra("isThisYouRel", this.isThisYou ? "Y" : "N");
        intent.putExtra("AGE_DEVIATION_FLG", this.ageDeviation);
        Log.d(this.TAG, intent.toString());
        startActivity(intent);
    }

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.42
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    SpecialRevisionDetails.this.ACNameList.clear();
                    SpecialRevisionDetails.this.ACList.clear();
                    SpecialRevisionDetails.this.ACNameList.add(SpecialRevisionDetails.this.getString(R.string.select_assembly_constituency));
                    SpecialRevisionDetails.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = SpecialRevisionDetails.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        SpecialRevisionDetails.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        SpecialRevisionDetails.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = SpecialRevisionDetails.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        SpecialRevisionDetails.this.binding.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    return;
                }
                Logger.e("AC List error", String.valueOf(response.code()));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$24(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$24(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    private void initializeSpinnerTouch() {
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.43
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDetails.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldState.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDetails.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.45
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDetails.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.46
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDetails.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerIR.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails.47
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDetails.this.isUserSelected = true;
                return false;
            }
        });
    }

    private void preSelectionOfCat() {
        int i;
        if (this.lastCheckedId != -1 || (i = this.age) <= 0) {
            return;
        }
        String category = AgeCategorizer.getCategory(i);
        this.binding.bornInIndia.setChecked(true);
        this.binding.radioLayout.setVisibility(0);
        if (category.equalsIgnoreCase("Born in India before 1987")) {
            this.binding.bornBefore1987rb.setChecked(true);
            this.citizenCat = "CAT-2";
            this.selectedText = category;
            this.lastCheckedId = this.binding.bornBefore1987rb.getId();
            return;
        }
        if (category.equalsIgnoreCase("Born in India between 01.07.1987 and 02.12.2004")) {
            this.binding.bornBefore2004rb.setChecked(true);
            this.citizenCat = "CAT-3";
            this.selectedText = category;
            this.lastCheckedId = this.binding.bornBefore2004rb.getId();
            return;
        }
        if (category.equalsIgnoreCase("Born in India after 03.12.2004")) {
            this.binding.bornAfter2004rb.setChecked(true);
            this.citizenCat = "CAT-4";
            this.selectedText = category;
            this.lastCheckedId = this.binding.bornAfter2004rb.getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkEpicNumber(String epicEditText, String from) {
        HashMap map = new HashMap();
        map.put("epicNumber", epicEditText);
        CommomUtility commomUtility = new CommomUtility();
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass48(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$48, reason: invalid class name */
    class AnonymousClass48 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass48(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v24, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
        /* JADX WARN: Type inference failed for: r9v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
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
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                Logger.d(SpecialRevisionDetails.this.TAG, "getEpic : getByEpicForForm : payloadData : " + ((JsonArray) response.body()));
                Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    SpecialRevisionDetails.this.isMotherEPICValid = true;
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    SpecialRevisionDetails.this.isFatherEPICValid = true;
                    return;
                } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                    SpecialRevisionDetails.this.isSpouseEPICValid = true;
                    return;
                } else {
                    if (this.val$from.equalsIgnoreCase("Relative")) {
                        SpecialRevisionDetails.this.isRelativeEPICValid = true;
                        return;
                    }
                    return;
                }
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r9 = SpecialRevisionDetails.this;
                String str = ((SpecialRevisionDetails) r9).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str2 = this.val$epicEditText;
                final String str3 = this.val$from;
                commomUtility.getRefreshToken(r9, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$48$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str4, String str5) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str2, str3, i, str4, str5);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                SpecialRevisionDetails.this.binding.motherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                SpecialRevisionDetails.this.binding.fatherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                SpecialRevisionDetails.this.binding.spouseEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Relative")) {
                SpecialRevisionDetails.this.binding.edtRelativeEpic.setText("");
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(SpecialRevisionDetails.this.messageString);
                Logger.d(SpecialRevisionDetails.this.TAG, strOptString);
                Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(SpecialRevisionDetails.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) SpecialRevisionDetails.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r8 = SpecialRevisionDetails.this;
                    Toast.makeText((Context) r8, r8.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(SpecialRevisionDetails.this.TAG, SpecialRevisionDetails.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                ?? r5 = SpecialRevisionDetails.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDetails$48$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDetails.this.token = SpecialRevisionDetails.this.bearerText + str3;
            SpecialRevisionDetails.this.refreshToken = str4;
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setToken(SpecialRevisionDetails.this.bearerText + str3);
            SpecialRevisionDetails.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetails.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetails.this.startActivity(new Intent((Context) SpecialRevisionDetails.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(SpecialRevisionDetails.this.TAG, t.getMessage());
        }
    }
}
