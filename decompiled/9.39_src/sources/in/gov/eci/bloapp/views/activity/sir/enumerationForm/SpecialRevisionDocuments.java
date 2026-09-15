package in.gov.eci.bloapp.views.activity.sir.enumerationForm;

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
import android.telephony.CellSignalStrength;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.work.BackoffPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySpecialRevisionDocumentsBinding;
import in.gov.eci.bloapp.entity.ListData;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.sir.pendingElectors;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SpecialRevisionDocuments extends SuperBaseActivity {
    private static final int PERMISSION_REQUEST_SIGNAL = 1001;
    private static String SESSION = "";
    Date DoB;
    String aadharNo;
    AlertDialog alertDialog;
    String annexref;
    private String asmblyNO;
    private String atkband;
    ActivitySpecialRevisionDocumentsBinding binding;
    String choice;
    Date dateAfter;
    Date dateBefore;
    String dob;
    Long epicId;
    String epicNumber;
    String erollDoB;
    String fatherEpic;
    String fatherName;
    protected long filesize;
    String functionNameForLogBaseActivity;
    String houseNumber;
    boolean isThisYou;
    String isThisYouRel;
    String list1Code;
    String list2;
    String list2code;
    String list3code;
    String list4code;
    String list5code;
    String list6code;
    String list7code;
    String mime;
    String mobileNo;
    String motherEpic;
    String motherName;
    int oldacNo;
    int oldpartno;
    private String partNo;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    String photo1ref;
    String photo2ref;
    String photoref;
    ProgressBar progressBar;
    String referenceNo;
    private String refreshToken;
    String relationIs2003;
    String relationOldAcS;
    String relationOldPSLS;
    String relationOldPartS;
    String relationOldState;
    String relationType;
    String relationlist8DocS;
    String relativeEpic;
    private String rtkband;
    protected String saveImageFileName;
    String selectParent;
    String serial;
    SIRDatabaseHelper sirDatabaseHelper;
    String spouseEpic;
    String spouseName;
    private String state;
    String temp;
    private String token;
    UserClient userClient;
    String list8code = "";
    String tabName = "fillTab";
    CommomUtility commomUtility = new CommomUtility();
    String TAG = "SpecialRevisionDocumentsTAG";
    boolean onlineStatus = false;
    String takephoto = "";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String oldAc = null;
    String OldPart = null;
    String OldPsl = null;
    String fatherOldAc = null;
    String motherOldAc = null;
    String fatherOldPart = null;
    String oldstatecd = null;
    String fatherOldPsl = null;
    String motherOldPart = null;
    String motherOldPsl = null;
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String cancel = "Cancel";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String imgmsg = "";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String upload = "";
    boolean pdf = false;
    Gson gson = new GsonBuilder().setLenient().create();
    String pdfTextBaseActivity = ".pdf";
    String IRStr = "Intensive Revision";
    String before1987Str = "Before 1987 self";
    String before2004Str = "Before 2004 Self";
    String list2Str = "Before 2004 Father or Mother";
    String list3Str = "After 2004 Father";
    String after2004Str = "After 2004 Self";
    String list4Str = "After 2004 Mother";
    String list5Str = "Not Indian Parent";
    String list6Str = "Born out of India";
    String list7Str = "Acquired Indian Citizenship";
    String IRStr2 = "Intensive Revision 2";
    String before1987Str2 = "Before 1987 self 2";
    String before2004Str2 = "Before 2004 Self 2";
    String list2Str2 = "Before 2004 Father or Mother 2";
    String list3Str2 = " Father  page 2";
    String after2004Str2 = "After 2004 Self 2";
    String list4Str2 = " Mother  page 2";
    String list5Str2 = "Not Indian Parent 2";
    String list5Str3 = "Not Indian Parent 3";
    String list6Str2 = "Born out of India 2";
    String list7Str2 = "Acquired Indian Citizenship 2";
    String img = "image";
    String cat = "";
    String jpgTextBaseActivity = ".jpg";
    String fileNameTextBaseActivity = "fileName";
    String alertText = "";
    private String motherNationality = "Indian";
    private String fatherNationality = "Indian";
    String flagYes = "N";
    String FlagNo = "N";
    String IRRef = null;
    String IRRef2 = null;
    String list1ref = null;
    String list1ref2 = null;
    String list2Ref = null;
    String selectDocumentType = "";
    String list3Ref = null;
    String list4Ref = null;
    String list5Ref = null;
    String list6ref = null;
    String list7ref = null;
    String list3Ref2 = null;
    String list4Ref2 = null;
    String list5Ref2 = null;
    String list6ref2 = null;
    String list7ref2 = null;
    String list5ref3 = null;
    String list2Ref2 = null;
    String IRFlag = "N";
    int IRcount = 0;
    int IRcount2 = 0;
    int list5count3 = 0;
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    ArrayList<String> betweenFatherPartNameList = new ArrayList<>();
    ArrayList<String> fatherPartNameList = new ArrayList<>();
    ArrayList<String> motherPartNameList = new ArrayList<>();
    ArrayList<Integer> motherPartList = new ArrayList<>();
    ArrayList<Integer> fatherPartList = new ArrayList<>();
    ArrayList<Integer> betweenFatherPartList = new ArrayList<>();
    int before2004count = 0;
    int after2004count = 0;
    int before2004count2 = 0;
    int after2004count2 = 0;
    int before1987count = 0;
    int list2count = 0;
    int list3count = 0;
    int list4coumt = 0;
    int list5count = 0;
    int list6count = 0;
    int list7count = 0;
    int before1987count2 = 0;
    int list2count2 = 0;
    int list3count2 = 0;
    int list4coumt2 = 0;
    int list5count2 = 0;
    int list6count2 = 0;
    int list7count2 = 0;
    private String submitFlag = null;
    String list1 = "LIST-1";
    String list3 = "LIST-3";
    String list4 = "LIST-4";
    String list5 = "LIST-5";
    String list6 = "LIST-6";
    String list7 = "LIST-7";
    String list8 = "LIST-8";
    ArrayList<String> List1docName = new ArrayList<>();
    ArrayList<String> List1docCode = new ArrayList<>();
    ArrayList<String> List2docName = new ArrayList<>();
    ArrayList<String> List2docCode = new ArrayList<>();
    ArrayList<String> List3docName = new ArrayList<>();
    ArrayList<String> List3docCode = new ArrayList<>();
    ArrayList<String> List4docName = new ArrayList<>();
    ArrayList<String> List4docCode = new ArrayList<>();
    ArrayList<String> List5docName = new ArrayList<>();
    ArrayList<String> List5docCode = new ArrayList<>();
    ArrayList<String> List6docName = new ArrayList<>();
    ArrayList<String> List6docCode = new ArrayList<>();
    ArrayList<String> List7docName = new ArrayList<>();
    ArrayList<String> List7docCode = new ArrayList<>();
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    String flagcat4scenerio1 = "N";
    String flagcat4scenerio2 = "N";
    String flagcat4scenerio3 = "N";
    String flagcat3scenerio1 = "N";
    String flagcat3scenerio2 = "N";
    String relativeDocument1UrlS = null;
    String relativeDocument2UrlS = null;
    String relativeSupportingDocumentPage1UrlS = null;
    String relativeSupportingDocumentPage2UrlS = null;
    String isThisYouFlag = "N";
    SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    boolean isUserSelected = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(getApplicationContext()).getToken();
        SharedPref.getInstance(getApplicationContext()).getStateCode();
        ActivitySpecialRevisionDocumentsBinding activitySpecialRevisionDocumentsBindingInflate = ActivitySpecialRevisionDocumentsBinding.inflate(getLayoutInflater());
        this.binding = activitySpecialRevisionDocumentsBindingInflate;
        setContentView(activitySpecialRevisionDocumentsBindingInflate.getRoot());
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectParent = getString(R.string.selectparentMsg);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(this);
        this.userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
        this.StateList = SharedPref.getInstance(getApplicationContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getApplicationContext()).getAcListName(Constants.STATE_LIST_NAME);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.takephoto = getString(R.string.takePhotoMsg1);
        this.upload = getString(R.string.uploadAgainMsg);
        SESSION = getString(R.string.sessionMsg);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldState.setAdapter((SpinnerAdapter) arrayAdapter);
        this.alertText = getString(R.string.alertMsg);
        try {
            this.dateBefore = this.simple.parse("01/07/1987");
            this.dateAfter = this.simple.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d(this.TAG, e.toString());
        }
        if (SharedPref.getInstance(getApplicationContext()).getOnlineStatusFlag().equalsIgnoreCase("Y")) {
            this.onlineStatus = true;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.epicId = Long.valueOf(extras.getLong("epicId"));
            this.choice = extras.getString("radio_choice");
            this.dob = extras.getString("dobverified");
            String str = this.choice;
            if (str != null) {
                if (str.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
                    this.List1docName.clear();
                    this.List1docCode.clear();
                    this.IRFlag = "Y";
                    this.cat = "CAT-1";
                    if (this.onlineStatus) {
                        getList1("LIST-8");
                    } else {
                        setDataOffline(this.list8);
                    }
                    this.binding.radioLayout.setVisibility(8);
                    this.binding.intensiveRevisionLayout.setVisibility(0);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_before_1987))) {
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.cat = "CAT-2";
                    this.binding.llBefore1987.setVisibility(0);
                    this.binding.radioLayout.setVisibility(8);
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_before_2004))) {
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.cat = "CAT-3";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(0);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                    this.binding.radioLayout.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_after_2004))) {
                    this.cat = "CAT-4";
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llParentLayout.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(0);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                    this.binding.radioLayout.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
                    this.List6docName.clear();
                    this.List6docCode.clear();
                    this.binding.radioLayout.setVisibility(8);
                    this.cat = "CAT-5";
                    this.list6 = "LIST-6";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    if (this.onlineStatus) {
                        getList1(this.list6);
                    } else {
                        setDataOffline(this.list6);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(0);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                    this.binding.radioLayout.setVisibility(8);
                    this.List7docName.clear();
                    this.List7docCode.clear();
                    this.cat = "CAT-6";
                    this.list7 = "LIST-7";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    if (this.onlineStatus) {
                        getList1(this.list7);
                    } else {
                        setDataOffline(this.list7);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(0);
                }
            }
        }
        initializeSpinnerTouch();
        this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda33
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreate$0(radioGroup, i);
            }
        });
        this.epicNumber = extras.getString("epicNo");
        this.serial = extras.getString("partSerialNo");
        this.erollDoB = extras.getString("dob");
        this.houseNumber = extras.getString("houseNo");
        this.aadharNo = extras.getString("aadharNo");
        this.mobileNo = extras.getString("mobileNo");
        this.fatherName = extras.getString("fatherName");
        this.fatherEpic = extras.getString("fatherEpic");
        this.motherEpic = extras.getString("motherEpic");
        this.motherName = extras.getString("motherName");
        this.spouseName = extras.getString("spouseName");
        this.spouseEpic = extras.getString("spouseEpic");
        this.photoref = extras.getString("photo-url");
        this.annexref = extras.getString("annexure_url");
        this.photo1ref = extras.getString("photo1ref");
        this.photo2ref = extras.getString("photo2ref");
        if (TextUtils.isEmpty(extras.getString("relationOldStateCd"))) {
            this.binding.oldState.setSelection(0);
            this.binding.SpinnerIROldAcNo.setSelection(0);
            this.binding.SpinnerIROldPartNo.setSelection(0);
        }
        if (TextUtils.isEmpty(extras.getString("relationOldAcNo"))) {
            this.binding.oldState.setSelection(0);
            this.binding.SpinnerIROldAcNo.setSelection(0);
            this.binding.SpinnerIROldPartNo.setSelection(0);
        }
        this.relationOldState = extras.getString("relationOldStateCd");
        this.relationOldAcS = extras.getString("relationOldAcNo");
        this.relationOldPartS = extras.getString("relationOldPartNo");
        this.relationOldPSLS = extras.getString("relationOldPSLNo");
        this.relationIs2003 = extras.getString("isRelative2003");
        this.relativeSupportingDocumentPage1UrlS = extras.getString("relationList8DocPage1");
        this.relativeSupportingDocumentPage2UrlS = extras.getString("relationList8DocPage2");
        this.relativeDocument1UrlS = extras.getString("relationProofDocPage1");
        this.relativeDocument2UrlS = extras.getString("relationProofDocPage2");
        this.relationlist8DocS = extras.getString("relationList8Code");
        this.relativeEpic = extras.getString("relativeEpic");
        this.relationType = extras.getString("relationCode");
        this.isThisYouRel = extras.getString("isThisYouRel");
        this.binding.SpinnerIROldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                specialRevisionDocuments.oldAc = specialRevisionDocuments.ACList.get(i);
                Log.d(SpecialRevisionDocuments.this.TAG, "AClist " + SpecialRevisionDocuments.this.ACList);
                Log.d(SpecialRevisionDocuments.this.TAG, "Spinner value " + SpecialRevisionDocuments.this.oldAc);
                SpecialRevisionDocuments.this.getPartByAc(Integer.parseInt(SpecialRevisionDocuments.this.ACList.get(i)), "case1");
            }
        });
        this.binding.oldState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                specialRevisionDocuments.oldstatecd = specialRevisionDocuments.StateList.get(i);
                Log.d(SpecialRevisionDocuments.this.TAG, "AClist " + SpecialRevisionDocuments.this.StateList);
                Log.d(SpecialRevisionDocuments.this.TAG, "Spinner value " + SpecialRevisionDocuments.this.oldstatecd);
                SpecialRevisionDocuments specialRevisionDocuments2 = SpecialRevisionDocuments.this;
                specialRevisionDocuments2.getAllAC(specialRevisionDocuments2.oldstatecd);
            }
        });
        this.binding.SpinnerIROldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                specialRevisionDocuments.OldPart = specialRevisionDocuments.partList.get(i - 1).toString();
            }
        });
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list8code = "";
                    SpecialRevisionDocuments.this.deletePhoto(101);
                    SpecialRevisionDocuments.this.deletePhoto(201);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List8docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list8code = specialRevisionDocuments.List8docCode.get(i);
                    Logger.d(Constants.LIST8_CODE, SpecialRevisionDocuments.this.list8code);
                }
            }
        });
        this.binding.spinnerBefore1987Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list1Code = "";
                    SpecialRevisionDocuments.this.deletePhoto(102);
                    SpecialRevisionDocuments.this.deletePhoto(202);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List1docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list1Code = specialRevisionDocuments.List1docCode.get(i);
                    Logger.d("list1Code", SpecialRevisionDocuments.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list1Code = "";
                    SpecialRevisionDocuments.this.deletePhoto(103);
                    SpecialRevisionDocuments.this.deletePhoto(203);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List1docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list1Code = specialRevisionDocuments.List1docCode.get(i);
                    Logger.d("list1Code", SpecialRevisionDocuments.this.list1Code);
                }
            }
        });
        this.binding.spinnerAfter2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list1Code = "";
                    SpecialRevisionDocuments.this.deletePhoto(105);
                    SpecialRevisionDocuments.this.deletePhoto(205);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List1docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list1Code = specialRevisionDocuments.List1docCode.get(i);
                    Logger.d("list1Code", SpecialRevisionDocuments.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDocuments.this.binding.betweenParentFatherRb.isChecked()) {
                    if (SpecialRevisionDocuments.this.isUserSelected) {
                        SpecialRevisionDocuments.this.list3code = "";
                        SpecialRevisionDocuments.this.deletePhoto(104);
                        SpecialRevisionDocuments.this.deletePhoto(204);
                        SpecialRevisionDocuments.this.isUserSelected = false;
                    }
                } else if (SpecialRevisionDocuments.this.binding.betweenParentMotherRb.isChecked() && SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list4code = "";
                    SpecialRevisionDocuments.this.deletePhoto(111);
                    SpecialRevisionDocuments.this.deletePhoto(211);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i == 0) {
                    return;
                }
                if (SpecialRevisionDocuments.this.binding.betweenParentFatherRb.isChecked()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list3code = specialRevisionDocuments.List3docCode.get(i);
                    Logger.d("list3code", SpecialRevisionDocuments.this.list3code);
                } else if (SpecialRevisionDocuments.this.binding.betweenParentMotherRb.isChecked()) {
                    SpecialRevisionDocuments specialRevisionDocuments2 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments2.list4code = specialRevisionDocuments2.List4docCode.get(i);
                    Logger.d("list4code", SpecialRevisionDocuments.this.list4code);
                }
            }
        });
        this.binding.spinnerAfter2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list3code = "";
                    SpecialRevisionDocuments.this.deletePhoto(106);
                    SpecialRevisionDocuments.this.deletePhoto(206);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i == 0) {
                    return;
                }
                SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                specialRevisionDocuments.list3code = specialRevisionDocuments.List3docCode.get(i);
            }
        });
        this.binding.spinnerAfter2004Mother.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list4code = "";
                    SpecialRevisionDocuments.this.deletePhoto(107);
                    SpecialRevisionDocuments.this.deletePhoto(207);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i == 0) {
                    return;
                }
                SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                specialRevisionDocuments.list4code = specialRevisionDocuments.List4docCode.get(i);
            }
        });
        this.binding.spinnerAfter2004NotIndian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list5code = "";
                    SpecialRevisionDocuments.this.deletePhoto(108);
                    SpecialRevisionDocuments.this.deletePhoto(208);
                    SpecialRevisionDocuments.this.deletePhoto(212);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i == 0) {
                    return;
                }
                int i2 = i - 1;
                if (i2 >= 0 && i2 < SpecialRevisionDocuments.this.List5docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list5code = specialRevisionDocuments.List5docCode.get(i);
                    Logger.d("list5code", SpecialRevisionDocuments.this.list5code);
                }
                if (i == 1) {
                    SpecialRevisionDocuments.this.binding.page3LL.setVisibility(0);
                } else {
                    SpecialRevisionDocuments.this.binding.page3LL.setVisibility(8);
                }
            }
        });
        this.binding.spinnerBornOutOfIndia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list6code = "";
                    SpecialRevisionDocuments.this.deletePhoto(109);
                    SpecialRevisionDocuments.this.deletePhoto(209);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List6docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list6code = specialRevisionDocuments.List6docCode.get(i);
                    Logger.d("list6code", SpecialRevisionDocuments.this.list6code);
                }
            }
        });
        this.binding.spinnerAcquired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.13
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (SpecialRevisionDocuments.this.isUserSelected) {
                    SpecialRevisionDocuments.this.list7code = "";
                    SpecialRevisionDocuments.this.deletePhoto(110);
                    SpecialRevisionDocuments.this.deletePhoto(210);
                    SpecialRevisionDocuments.this.isUserSelected = false;
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < SpecialRevisionDocuments.this.List7docName.size()) {
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.list7code = specialRevisionDocuments.List7docCode.get(i);
                    Logger.d("list7code", SpecialRevisionDocuments.this.list7code);
                }
            }
        });
        this.binding.chooseFileIR2003.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.chooseFileIR2003Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.chooseFileBefore1987.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.chooseFileBefore1987Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.chooseFileBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.chooseFileBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.chooseFileBefore2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.chooseFileBefore2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.chooseFileAfter2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.chooseFileAfter2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.chooseFileAfter2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.chooseFileAfter2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.chooseFileAfter2004Mother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.chooseFileAfter2004MotherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndian.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.chooseFileBornOutOfIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.chooseFileBornOutOfIndiaPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.chooseFileAcquired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.chooseFileAcquiredPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.cancelIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$22(view);
            }
        });
        this.binding.cancelList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$23(view);
            }
        });
        this.binding.cancelBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$24(view);
            }
        });
        this.binding.cancelList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$25(view);
            }
        });
        this.binding.cancelAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$26(view);
            }
        });
        this.binding.cancelList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$27(view);
            }
        });
        this.binding.cancelList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$28(view);
            }
        });
        this.binding.cancelList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$29(view);
            }
        });
        this.binding.cancelList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$30(view);
            }
        });
        this.binding.cancelList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$31(view);
            }
        });
        this.binding.cancelIRPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$32(view);
            }
        });
        this.binding.cancelList1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$33(view);
            }
        });
        this.binding.cancelBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$34(view);
            }
        });
        this.binding.cancelList2Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$35(view);
            }
        });
        this.binding.cancelAfter2004selfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$36(view);
            }
        });
        this.binding.cancelList3Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$37(view);
            }
        });
        this.binding.cancelList4Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$38(view);
            }
        });
        this.binding.cancelList5Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$39(view);
            }
        });
        this.binding.cancelList6Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$40(view);
            }
        });
        this.binding.cancelList7Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$41(view);
            }
        });
        this.binding.cancelList5Page3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$42(view);
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$43(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$44(view);
            }
        });
        this.binding.betweenParentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$45(view);
            }
        });
        this.binding.betweenParentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$46(view);
            }
        });
        this.binding.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$47(view);
            }
        });
        this.binding.parentNoRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$48(view);
            }
        });
        this.binding.parentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$49(view);
            }
        });
        this.binding.parentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$50(view);
            }
        });
        initClickListener();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SpecialRevisionDocuments.this.binding.oldState.getSelectedItemPosition() == 0 || SpecialRevisionDocuments.this.binding.SpinnerIROldAcNo.getSelectedItemPosition() == 0 || SpecialRevisionDocuments.this.binding.SpinnerIROldPartNo.getSelectedItemPosition() == 0 || SpecialRevisionDocuments.this.binding.IROldPslNo.getText().toString().trim().isEmpty()) {
                    return;
                }
                SpecialRevisionDocuments.this.callVerifyRelativeApi();
            }
        });
        this.binding.IROldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.15
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (SpecialRevisionDocuments.this.binding.oldState.getSelectedItemPosition() != 0 && SpecialRevisionDocuments.this.binding.SpinnerIROldAcNo.getSelectedItemPosition() != 0 && SpecialRevisionDocuments.this.binding.SpinnerIROldPartNo.getSelectedItemPosition() != 0 && !SpecialRevisionDocuments.this.binding.IROldPslNo.getText().toString().trim().isEmpty()) {
                    SpecialRevisionDocuments.this.binding.layoutVerifyDetails.setVisibility(0);
                } else {
                    SpecialRevisionDocuments.this.binding.layoutVerifyDetails.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(RadioGroup radioGroup, int i) {
        if (i == 2131362505) {
            this.cat = "CAT-2";
            this.list1 = "LIST-1";
            this.binding.intensiveRevisionLayout.setVisibility(8);
            this.binding.llBefore1987.setVisibility(0);
            if (this.onlineStatus) {
                getList1(this.list1);
            } else {
                setDataOffline(this.list1);
            }
            this.binding.llBefore2004.setVisibility(8);
            this.binding.llAfter2004.setVisibility(8);
            this.binding.llBornOutOfIndia.setVisibility(8);
            this.binding.llAcquired.setVisibility(8);
            return;
        }
        if (i == 2131362506) {
            this.cat = "CAT-3";
            this.list1 = "LIST-1";
            this.binding.intensiveRevisionLayout.setVisibility(8);
            this.binding.llBefore1987.setVisibility(8);
            if (this.onlineStatus) {
                getList1(this.list1);
            } else {
                setDataOffline(this.list1);
            }
            this.binding.llBefore2004.setVisibility(0);
            this.binding.llAfter2004.setVisibility(8);
            this.binding.llBornOutOfIndia.setVisibility(8);
            this.binding.llAcquired.setVisibility(8);
            return;
        }
        if (i == 2131362504) {
            this.cat = "CAT-4";
            this.list1 = "LIST-1";
            this.binding.intensiveRevisionLayout.setVisibility(8);
            this.binding.llBefore1987.setVisibility(8);
            if (this.onlineStatus) {
                getList1(this.list1);
            } else {
                setDataOffline(this.list1);
            }
            this.binding.llParentLayout.setVisibility(8);
            this.binding.llBefore2004.setVisibility(8);
            this.binding.llAfter2004.setVisibility(0);
            this.binding.llBornOutOfIndia.setVisibility(8);
            this.binding.llAcquired.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (this.binding.spinnerIR.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.IRcount = 0;
            pickFileIntensiveRevision(101, this.list8code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (this.binding.spinnerIR.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.IRcount2 = 0;
        if (TextUtils.isEmpty(this.IRRef)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(201, this.list8code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.binding.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.before1987count = 0;
            pickFileIntensiveRevision(102, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (this.binding.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.before1987count2 = 0;
        this.IRcount2 = 0;
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(202, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        if (this.binding.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.before2004count = 0;
            pickFileIntensiveRevision(103, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (this.binding.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.before2004count2 = 0;
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(203, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (this.binding.spinnerBefore2004Father.getSelectedItemPosition() == -1) {
            showDialog1(this.alertText, this.selectParent);
            return;
        }
        if (this.binding.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list2count = 0;
        if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
            pickFileIntensiveRevision(104, this.list3code);
        } else if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
            pickFileIntensiveRevision(111, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        if (this.binding.spinnerBefore2004Father.getSelectedItemPosition() == -1) {
            showDialog1(this.alertText, this.selectParent);
            return;
        }
        if (this.binding.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list2count2 = 0;
        if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
            if (TextUtils.isEmpty(this.list3Ref)) {
                showDialog1(this.alertText, getString(R.string.uploadpage1error));
                return;
            } else {
                pickFileIntensiveRevision(204, this.list3code + "_page2_");
                return;
            }
        }
        if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
            if (TextUtils.isEmpty(this.list4Ref)) {
                showDialog1(this.alertText, getString(R.string.uploadpage1error));
            } else {
                pickFileIntensiveRevision(211, this.list4code + "_page2_");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        if (this.binding.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.after2004count = 0;
            pickFileIntensiveRevision(105, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        if (this.binding.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.after2004count2 = 0;
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(205, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        if (this.binding.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list3count = 0;
            pickFileIntensiveRevision(106, this.list3code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        if (this.binding.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list3count2 = 0;
        if (TextUtils.isEmpty(this.list3Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(206, this.list3code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        if (this.binding.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list4coumt = 0;
            pickFileIntensiveRevision(107, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        if (this.binding.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list4coumt2 = 0;
        if (TextUtils.isEmpty(this.list4Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(207, this.list4code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        if (this.binding.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list5count = 0;
            pickFileIntensiveRevision(108, this.list5code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        if (this.binding.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list5count2 = 0;
        if (TextUtils.isEmpty(this.list5Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(208, this.list5code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        if (this.binding.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list6count = 0;
            pickFileIntensiveRevision(109, this.list6code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        if (this.binding.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list6count2 = 0;
        if (TextUtils.isEmpty(this.list6ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(209, this.list6code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        if (this.binding.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list7count = 0;
            pickFileIntensiveRevision(110, this.list7code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        if (this.binding.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list7count2 = 0;
        if (TextUtils.isEmpty(this.list7ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(210, this.list7code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        if (this.binding.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list5count3 = 0;
        if (TextUtils.isEmpty(this.list5Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else if (TextUtils.isEmpty(this.list5Ref2)) {
            showDialog1(this.alertText, getString(R.string.uploadpage2error));
        } else {
            pickFileIntensiveRevision(212, this.list5code + "_page3_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$23(View view) {
        deletePhoto(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$24(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$25(View view) {
        deletePhoto(111);
        deletePhoto(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$26(View view) {
        deletePhoto(105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$27(View view) {
        deletePhoto(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$28(View view) {
        deletePhoto(107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$29(View view) {
        deletePhoto(108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$30(View view) {
        deletePhoto(109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$31(View view) {
        deletePhoto(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$32(View view) {
        deletePhoto(201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$33(View view) {
        deletePhoto(202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$34(View view) {
        deletePhoto(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$35(View view) {
        deletePhoto(211);
        deletePhoto(204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$36(View view) {
        deletePhoto(205);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$37(View view) {
        deletePhoto(206);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$38(View view) {
        deletePhoto(207);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$39(View view) {
        deletePhoto(208);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$40(View view) {
        deletePhoto(209);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$41(View view) {
        deletePhoto(210);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$42(View view) {
        deletePhoto(212);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$43(View view) {
        this.submitFlag = "N";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$44(View view) {
        this.submitFlag = "Y";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$45(View view) {
        this.binding.before2004ParentDoc.setVisibility(0);
        this.List3docName.clear();
        this.List3docCode.clear();
        this.flagcat3scenerio1 = "Y";
        if (this.onlineStatus) {
            getList1(this.list3);
        } else {
            setDataOffline(this.list3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$46(View view) {
        this.binding.before2004ParentDoc.setVisibility(0);
        this.List4docName.clear();
        this.List4docCode.clear();
        this.flagcat3scenerio2 = "Y";
        if (this.onlineStatus) {
            getList1(this.list4);
        } else {
            setDataOffline(this.list4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$47(View view) {
        this.List3docName.clear();
        this.List4docName.clear();
        this.List3docCode.clear();
        this.List4docCode.clear();
        this.flagcat4scenerio1 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        if (this.onlineStatus) {
            getList1(this.list3);
            getList1(this.list4);
        } else {
            setDataOffline(this.list3);
            setDataOffline(this.list4);
        }
        this.binding.viewFatherOldLayout.setVisibility(8);
        this.binding.viewMotherOldLayout.setVisibility(8);
        this.binding.llParentLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(0);
        this.binding.motherLayout.setVisibility(0);
        this.binding.forIndianParentLayout.setVisibility(8);
        this.binding.selectParentLayout.setVisibility(8);
        this.binding.llNotIndianLayout.setVisibility(8);
        this.binding.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$48(View view) {
        this.flagcat4scenerio1 = "N";
        this.binding.selectParentLayout.setVisibility(0);
        this.binding.llParentLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(8);
        this.binding.motherLayout.setVisibility(8);
        this.binding.llNotIndianLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(8);
        this.binding.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$49(View view) {
        this.List3docName.clear();
        this.List5docName.clear();
        this.List3docCode.clear();
        this.List5docCode.clear();
        this.flagcat4scenerio2 = "Y";
        this.motherNationality = "Non-Indian";
        this.fatherNationality = "Indian";
        if (this.onlineStatus) {
            getList1(this.list3);
            getList1(this.list5);
        } else {
            setDataOffline(this.list3);
            setDataOffline(this.list5);
        }
        this.binding.fatherLayout.setVisibility(0);
        this.binding.motherLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(0);
        this.binding.indianParentTv2.setText(getString(R.string.father_sr));
        this.binding.llNotIndianLayout.setVisibility(0);
        this.binding.nonIndianParentTv2.setText(R.string.mother_sr);
        this.binding.forNonIndianParentLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$50(View view) {
        this.List4docName.clear();
        this.List5docName.clear();
        this.List4docCode.clear();
        this.List5docCode.clear();
        this.flagcat4scenerio3 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Non-Indian";
        if (this.onlineStatus) {
            getList1(this.list4);
            getList1(this.list5);
        } else {
            setDataOffline(this.list4);
            setDataOffline(this.list5);
        }
        this.binding.motherLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(0);
        this.binding.indianParentTv2.setText(R.string.mother_sr);
        this.binding.llNotIndianLayout.setVisibility(0);
        this.binding.nonIndianParentTv2.setText(R.string.father_sr);
        this.binding.forNonIndianParentLayout.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkAndRequestPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") != 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"}, PERMISSION_REQUEST_SIGNAL);
        } else {
            startSignalListener();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_SIGNAL) {
            for (int i : grantResults) {
                if (i != 0) {
                    Toast.makeText((Context) this, (CharSequence) "Permission denied", 0).show();
                    return;
                }
            }
            startSignalListener();
        }
    }

    private void startSignalListener() {
        ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.16
            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);
                Logger.d("SignalStrength", String.valueOf(signalStrength.getLevel()));
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        Iterator<CellSignalStrength> it = signalStrength.getCellSignalStrengths().iterator();
                        while (it.hasNext()) {
                            Logger.d("Signal", "dBm" + it.next().getDbm());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 101) {
            this.IRRef = null;
            this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileIR2003.setEnabled(true);
            this.binding.imageIR.setVisibility(8);
            this.binding.IRSize.setText("");
            this.binding.IRName.setText("");
            this.binding.cancelIR.setVisibility(8);
            this.binding.viewLayoutIR.setVisibility(8);
            return;
        }
        if (code == 102) {
            this.list1ref = null;
            this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore1987.setEnabled(true);
            this.binding.imageList1.setVisibility(8);
            this.binding.list1Size.setText("");
            this.binding.list1Name.setText("");
            this.binding.cancelList1.setVisibility(8);
            this.binding.viewLayoutList1.setVisibility(8);
            return;
        }
        if (code == 103) {
            this.list1ref = null;
            this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004Self.setEnabled(true);
            this.binding.imageBefore2004Self.setVisibility(8);
            this.binding.before2004SelfSize.setText("");
            this.binding.before2004SelfName.setText("");
            this.binding.cancelBefore2004Self.setVisibility(8);
            this.binding.viewLayoutBefore2004Self.setVisibility(8);
            return;
        }
        if (code == 104) {
            this.list3Ref = null;
            this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004Father.setEnabled(true);
            this.binding.imageList2.setVisibility(8);
            this.binding.list2Size.setText("");
            this.binding.list2Name.setText("");
            this.binding.cancelList2.setVisibility(8);
            this.binding.viewLayoutList2.setVisibility(8);
            return;
        }
        if (code == 105) {
            this.list1ref = null;
            this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Self.setEnabled(true);
            this.binding.imageAfter2004self.setVisibility(8);
            this.binding.after2004selfSize.setText("");
            this.binding.after2004selfName.setText("");
            this.binding.cancelAfter2004self.setVisibility(8);
            this.binding.viewLayoutAfter2004self.setVisibility(8);
            return;
        }
        if (code == 106) {
            this.list3Ref = null;
            this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Father.setEnabled(true);
            this.binding.imageList3.setVisibility(8);
            this.binding.list3Size.setText("");
            this.binding.list3Name.setText("");
            this.binding.cancelList3.setVisibility(8);
            this.binding.viewList3.setVisibility(8);
            return;
        }
        if (code == 107 || code == 111) {
            this.list4Ref = null;
            this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Mother.setEnabled(true);
            this.binding.imageList4.setVisibility(8);
            this.binding.list4Size.setText("");
            this.binding.list4Name.setText("");
            this.binding.cancelList4.setVisibility(8);
            this.binding.viewList4.setVisibility(8);
            return;
        }
        if (code == 108) {
            this.list5Ref = null;
            this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
            this.binding.imageList5.setVisibility(8);
            this.binding.list5Size.setText("");
            this.binding.list5Name.setText("");
            this.binding.cancelList5.setVisibility(8);
            this.binding.viewList5.setVisibility(8);
            return;
        }
        if (code == 109) {
            this.list6ref = null;
            this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBornOutOfIndia.setEnabled(true);
            this.binding.imageList6.setVisibility(8);
            this.binding.list6Size.setText("");
            this.binding.list6Name.setText("");
            this.binding.cancelList6.setVisibility(8);
            this.binding.viewList6.setVisibility(8);
            return;
        }
        if (code == 110) {
            this.list7ref = null;
            this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAcquired.setEnabled(true);
            this.binding.imageList7.setVisibility(8);
            this.binding.list7Size.setText("");
            this.binding.list7Name.setText("");
            this.binding.cancelList7.setVisibility(8);
            this.binding.viewList7.setVisibility(8);
            return;
        }
        if (code == 201) {
            this.IRRef2 = null;
            this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileIR2003Page2.setEnabled(true);
            this.binding.imageIRPage2.setVisibility(8);
            this.binding.IRSizePage2.setText("");
            this.binding.IRNamePage2.setText("");
            this.binding.cancelIRPage2.setVisibility(8);
            this.binding.viewLayoutIRPage2.setVisibility(8);
            return;
        }
        if (code == 202) {
            this.list1ref2 = null;
            this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore1987Page2.setEnabled(true);
            this.binding.imageList1Page2.setVisibility(8);
            this.binding.list1SizePage2.setText("");
            this.binding.list1NamePage2.setText("");
            this.binding.cancelList1Page2.setVisibility(8);
            this.binding.viewLayoutList1Page2.setVisibility(8);
            return;
        }
        if (code == 203) {
            this.list1ref2 = null;
            this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
            this.binding.imageBefore2004SelfPage2.setVisibility(8);
            this.binding.before2004SelfSizePage2.setText("");
            this.binding.before2004SelfNamePage2.setText("");
            this.binding.cancelBefore2004SelfPage2.setVisibility(8);
            this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
            return;
        }
        if (code == 204) {
            this.list3Ref2 = null;
            this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
            this.binding.imageList2Page2.setVisibility(8);
            this.binding.list2SizePage2.setText("");
            this.binding.list2NamePage2.setText("");
            this.binding.cancelList2Page2.setVisibility(8);
            this.binding.viewLayoutList2Page2.setVisibility(8);
            return;
        }
        if (code == 205) {
            this.list1ref2 = null;
            this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
            this.binding.imageAfter2004selfPage2.setVisibility(8);
            this.binding.after2004selfSizePage2.setText("");
            this.binding.after2004selfNamePage2.setText("");
            this.binding.cancelAfter2004selfPage2.setVisibility(8);
            this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
            return;
        }
        if (code == 206) {
            this.list3Ref2 = null;
            this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
            this.binding.imageList3Page2.setVisibility(8);
            this.binding.list3SizePage2.setText("");
            this.binding.list3NamePage2.setText("");
            this.binding.cancelList3Page2.setVisibility(8);
            this.binding.viewList3Page2.setVisibility(8);
            return;
        }
        if (code == 207 || code == 211) {
            this.list4Ref2 = null;
            this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
            this.binding.imageList4Page2.setVisibility(8);
            this.binding.list4SizePage2.setText("");
            this.binding.list4NamePage2.setText("");
            this.binding.cancelList4Page2.setVisibility(8);
            this.binding.viewList4Page2.setVisibility(8);
            return;
        }
        if (code == 208) {
            this.list5Ref2 = null;
            this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
            this.binding.imageList5Page2.setVisibility(8);
            this.binding.list5SizePage2.setText("");
            this.binding.list5NamePage2.setText("");
            this.binding.cancelList5Page2.setVisibility(8);
            this.binding.viewList5Page2.setVisibility(8);
            return;
        }
        if (code == 209) {
            this.list6ref2 = null;
            this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
            this.binding.imageList6Page2.setVisibility(8);
            this.binding.list6SizePage2.setText("");
            this.binding.list6NamePage2.setText("");
            this.binding.cancelList6Page2.setVisibility(8);
            this.binding.viewList6Page2.setVisibility(8);
            return;
        }
        if (code == 210) {
            this.list7ref2 = null;
            this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAcquiredPage2.setEnabled(true);
            this.binding.imageList7Page2.setVisibility(8);
            this.binding.list7SizePage2.setText("");
            this.binding.list7NamePage2.setText("");
            this.binding.cancelList7Page2.setVisibility(8);
            this.binding.viewList7Page2.setVisibility(8);
            return;
        }
        if (code == 212) {
            this.list5ref3 = null;
            this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
            this.binding.imageList5Page3.setVisibility(8);
            this.binding.list5SizePage3.setText("");
            this.binding.list5NamePage3.setText("");
            this.binding.cancelList5Page3.setVisibility(8);
            this.binding.viewList5Page3.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit() {
        String str;
        String[] strArr;
        int i;
        String str2;
        try {
            Log.d(this.TAG, "eroll dob" + this.dob);
            str = !TextUtils.isEmpty(this.dob) ? new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this.dob)) : null;
            while (true) {
                if (i >= 17) {
                    str2 = "N";
                    break;
                } else {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        str2 = "Y";
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
            str = null;
        }
        i = 0;
        strArr = new String[]{this.list1ref, this.list1ref2, this.list2Ref, this.list2Ref2, this.list3Ref, this.list3Ref2, this.list4Ref, this.list4Ref2, this.list5Ref, this.list5Ref2, this.list5ref3, this.list6ref, this.list6ref2, this.list7ref, this.list7ref2, this.IRRef, this.IRRef2};
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
        map2.put("dobVerified", str);
        map2.put("erollDob", this.erollDoB);
        map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", this.serial);
        map2.put("createdBy", "BLO");
        map2.put("modifiedDttm", null);
        map2.put("modifiedBy", null);
        map2.put("photoUrl", this.photoref);
        map2.put("srFormPage1Url", this.photo1ref);
        map2.put("citizenshipType", this.choice);
        map2.put("citizenshipTypeCat", this.cat);
        map2.put("surveyChannel", "BLO");
        map2.put("list1Doc", this.list1Code);
        map2.put("list2Doc", this.list2code);
        map2.put("list3Doc", this.list3code);
        map2.put("list4Doc", this.list4code);
        map2.put("list5Doc", this.list5code);
        map2.put("list6Doc", this.list6code);
        map2.put("list7Doc", this.list7code);
        map2.put("list1DocUrl", this.list1ref);
        map2.put("list2DocUrl", this.list2Ref);
        map2.put("list3DocUrl", this.list3Ref);
        map2.put("list4DocUrl", this.list4Ref);
        map2.put("list5DocUrl", this.list5Ref);
        map2.put("list6DocUrl", this.list6ref);
        map2.put("list7DocUrl", this.list7ref);
        map2.put("list1docUrlPg2", this.list1ref2);
        map2.put("list2docUrlPg2", this.list2Ref2);
        map2.put("list3docUrlPg2", this.list3Ref2);
        map2.put("list4docUrlPg2", this.list4Ref2);
        map2.put("list5docUrlPg2", this.list5Ref2);
        map2.put("list6docUrlPg2", this.list6ref2);
        map2.put("list7docUrlPg2", this.list7ref2);
        map2.put("list5docUrlPg3", this.list5ref3);
        map2.put("aadharNo", this.aadharNo);
        map2.put("mobileNo", this.mobileNo);
        map2.put("fathersOrGuardianName", this.fatherName);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpic);
        map2.put("mothersName", this.motherName);
        map2.put("mothersEpicNo", this.motherEpic);
        map2.put("spouseName", this.spouseName);
        map2.put("spouseEpicNo", this.spouseEpic);
        map2.put("annexureCUrl", this.annexref);
        map2.put("preRevisionVoterFlg", this.IRFlag);
        map2.put("preRevisionVoterDocUrl", this.IRRef);
        map2.put("preRevisionVoterDocUrlPg2", this.IRRef2);
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", this.fatherNationality);
        map2.put("mothersNationality", this.motherNationality);
        map2.put("srFormPage2Url", this.photo2ref);
        map2.put("oldAcNo", this.oldAc);
        map2.put("oldPartNo", this.OldPart);
        map2.put("oldPslNo", this.OldPsl);
        map2.put("list8Doc", this.list8code);
        map2.put("moldAcNo", this.motherOldAc);
        map2.put("moldPartNo", this.motherOldPart);
        map2.put("moldPslNo", this.motherOldPsl);
        map2.put("foldAcNo", this.fatherOldAc);
        map2.put("foldPartNo", this.fatherOldPart);
        map2.put("foldPslNo", this.fatherOldPsl);
        map2.put("documentUploadedFlg", str2);
        map2.put("relationOldAcNo", String.valueOf(this.relationOldAcS));
        map2.put("relationOldPartNo", String.valueOf(this.relationOldPartS));
        map2.put("relationOldPslNo", String.valueOf(this.relationOldPSLS));
        map2.put("relationDocType", this.relationlist8DocS);
        map2.put("relationDocUrlPg1", this.relativeSupportingDocumentPage1UrlS);
        map2.put("relationDocUrlPg2", this.relativeSupportingDocumentPage2UrlS);
        map2.put("isRelativePreVoterFlg", this.relationIs2003);
        map2.put("relationProofDocUrlPg1", this.relativeDocument1UrlS);
        map2.put("relationProofDocUrlPg2", this.relativeDocument2UrlS);
        map2.put("relationType", this.relationType);
        map2.put("relationEpicNo", this.relativeEpic);
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou ? "Y" : "N");
        map2.put("relationOldStateCd", this.relationOldState);
        map2.put("oldStateCd", this.oldstatecd);
        Logger.d(this.TAG, map2.toString());
        if (this.onlineStatus) {
            this.userClient.submitSpecialRevisionSIR(map, map2).enqueue(new AnonymousClass17());
            return;
        }
        try {
            this.sirDatabaseHelper.SpecialRevisionDao().addSpecialSurveyRevisionDetails(new SpecialSurveyRevisionModel(this.epicId, this.state, this.epicNumber, this.houseNumber, str, this.erollDoB, SharedPref.getInstance(this).getDistrictCode(), this.asmblyNO, this.partNo, this.serial, null, "BLO", null, null, this.photoref, this.photo1ref, this.choice, this.cat, this.list1Code, this.list2code, this.list3code, this.list4code, this.list5code, this.list6code, this.list7code, this.list1ref, this.list2Ref, this.list3Ref, this.list4Ref, this.list5Ref, this.list6ref, this.list7ref, "BLO", this.aadharNo, this.mobileNo, null, this.fatherEpic, null, this.motherEpic, null, this.spouseEpic, null, this.IRFlag, this.IRRef, this.submitFlag, this.fatherNationality, this.motherNationality, this.photo2ref, this.oldAc, this.OldPart, this.binding.IROldPslNo.getText().toString(), this.fatherOldAc, this.fatherOldPart, this.fatherOldPsl, this.motherOldAc, this.motherOldPart, this.motherOldPsl, this.list8code, str2, null, null, this.list1ref2, this.list2Ref2, this.list3Ref2, this.list4Ref2, this.list5Ref2, this.list5ref3, this.list6ref2, this.list7ref2, this.IRRef2, null, null, null, null, null, null, null, null, null, this.relationType, this.relationlist8DocS, this.relativeSupportingDocumentPage1UrlS, this.relationIs2003, this.relativeSupportingDocumentPage2UrlS, this.relativeDocument1UrlS, this.relativeDocument2UrlS, this.relationOldAcS, this.relationOldPartS, this.relationOldPSLS, this.relativeEpic, this.isThisYouFlag, this.isThisYouRel, this.tabName, this.relationOldState, this.oldstatecd));
            showDialog3("", getString(R.string.form_saved_successfully));
            WorkManager.getInstance(this).enqueueUniqueWork("SIR_UPLOAD_WORK", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(SirUploadWorker.class).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10L, TimeUnit.SECONDS).build());
        } catch (Exception e2) {
            Logger.d(this.TAG, e2.toString());
            showDialog1("Error", getString(R.string.something_went_wrong));
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass17() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.showDialog2(specialRevisionDocuments.alertText, string);
                } else {
                    SpecialRevisionDocuments specialRevisionDocuments2 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments2.showDialog2("", specialRevisionDocuments2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("SpecialRevisionDocuments", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$17$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            SpecialRevisionDocuments.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPartByAc(int ac, final String partCase) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        this.userClient.getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.18
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v12, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
            /* JADX WARN: Type inference failed for: r0v14, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
            /* JADX WARN: Type inference failed for: r0v16, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
            /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (SpecialRevisionDocuments.this.partNameList.isEmpty()) {
                        SpecialRevisionDocuments.this.partNameList.add(0, SpecialRevisionDocuments.this.getString(R.string.select_part));
                    }
                    if (SpecialRevisionDocuments.this.betweenFatherPartNameList.isEmpty()) {
                        SpecialRevisionDocuments.this.betweenFatherPartNameList.add(0, SpecialRevisionDocuments.this.getString(R.string.select_part));
                    }
                    if (SpecialRevisionDocuments.this.fatherPartNameList.isEmpty()) {
                        SpecialRevisionDocuments.this.fatherPartNameList.add(0, SpecialRevisionDocuments.this.getString(R.string.select_part));
                    }
                    if (SpecialRevisionDocuments.this.motherPartNameList.isEmpty()) {
                        SpecialRevisionDocuments.this.motherPartNameList.add(0, SpecialRevisionDocuments.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        SpecialRevisionDocuments.this.motherPartNameList.add(asInt + " - " + asString);
                        if (partCase.equalsIgnoreCase("case1")) {
                            SpecialRevisionDocuments.this.partNameList.add(asInt + " - " + asString);
                            SpecialRevisionDocuments.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.SpinnerIROldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                        } else if (partCase.equalsIgnoreCase("between")) {
                            SpecialRevisionDocuments.this.betweenFatherPartNameList.add(asInt + " - " + asString);
                            SpecialRevisionDocuments.this.betweenFatherPartList.add(Integer.valueOf(asInt));
                            ?? r1 = SpecialRevisionDocuments.this;
                            new ArrayAdapter((Context) r1, R.layout.blo_spinner_dropdown, r1.betweenFatherPartNameList).setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        } else if (partCase.equalsIgnoreCase("father")) {
                            SpecialRevisionDocuments.this.fatherPartNameList.add(asInt + " - " + asString);
                            SpecialRevisionDocuments.this.fatherPartList.add(Integer.valueOf(asInt));
                            ?? r2 = SpecialRevisionDocuments.this;
                            new ArrayAdapter((Context) r2, R.layout.blo_spinner_dropdown, r2.fatherPartNameList).setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        } else if (partCase.equalsIgnoreCase("mother")) {
                            SpecialRevisionDocuments.this.motherPartNameList.add(asInt + " - " + asString);
                            SpecialRevisionDocuments.this.motherPartList.add(Integer.valueOf(asInt));
                            ?? r3 = SpecialRevisionDocuments.this;
                            new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.motherPartNameList).setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) SpecialRevisionDocuments.this, (CharSequence) "Failed to get Part List", 1).show();
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
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                SpecialRevisionDocuments.this.isThisYou = true;
                SpecialRevisionDocuments.this.isThisYouFlag = "Y";
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                SpecialRevisionDocuments.this.isThisYou = false;
                SpecialRevisionDocuments.this.isThisYouFlag = "N";
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.oldstatecd);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        UserClient userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
        Log.d(this.TAG, "oldac" + this.oldAc + "oldpart" + this.OldPart + "oldPsl" + this.binding.IROldPslNo.getText().toString());
        userClient.getDetailsByEroll(Integer.parseInt(this.oldAc), Integer.parseInt(this.OldPart), Integer.parseInt(this.binding.IROldPslNo.getText().toString().trim()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.21
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(SpecialRevisionDocuments.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
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
                        SpecialRevisionDocuments.this.showVerifyDetailsDialog(!TextUtils.isEmpty(strOptString2) ? strOptString2 + " " + strOptString3 : "", TextUtils.isEmpty(strOptString4) ? "" : strOptString4 + " " + strOptString5, strOptString6, strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("SpecialRevisionDocuments", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                    SpecialRevisionDocuments.this.isThisYou = false;
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.showDialog1(specialRevisionDocuments.alertText, SpecialRevisionDocuments.this.getString(R.string.no_record_found));
                    return;
                }
                SpecialRevisionDocuments.this.isThisYou = false;
                SpecialRevisionDocuments.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                SpecialRevisionDocuments.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$51(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$51(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) pendingElectors.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    private boolean validate() {
        if (!this.cat.equalsIgnoreCase("CAT-1")) {
            return true;
        }
        if (TextUtils.isEmpty(this.oldstatecd)) {
            showDialog1(this.alertText, getString(R.string.please_select_previous_sir_state));
            return false;
        }
        if (TextUtils.isEmpty(this.oldAc)) {
            showDialog1(this.alertText, getString(R.string.please_select_previous_sir_ac));
            return false;
        }
        if (TextUtils.isEmpty(this.OldPart)) {
            showDialog1(this.alertText, getString(R.string.please_select_previous_sir_part));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.IROldPslNo.getText().toString())) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.please_enter_previous_sir_part_serial_no));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("lists", list);
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionListSIR(map, map2).enqueue(new AnonymousClass22(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass22(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v101, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v113, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v23, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v35, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v47, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v59, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v71, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
        /* JADX WARN: Type inference failed for: r3v86, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
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
                SpecialRevisionDocuments.this.payloadData1 = (JsonObject) response.body();
                if (SpecialRevisionDocuments.this.payloadData1 != null) {
                    JsonArray asJsonArray = SpecialRevisionDocuments.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = SpecialRevisionDocuments.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1")) {
                            SpecialRevisionDocuments.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List1docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List1docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List1docCode.add(0, null);
                            }
                            ?? r3 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.List1docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            SpecialRevisionDocuments.this.binding.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            SpecialRevisionDocuments.this.binding.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                        } else if (this.val$list.equalsIgnoreCase("LIST-2")) {
                            SpecialRevisionDocuments.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List2docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List2docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List2docCode.add(0, null);
                            }
                            ?? r4 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) r4, R.layout.blo_spinner_dropdown, r4.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                        } else if (this.val$list.equalsIgnoreCase("LIST-3")) {
                            SpecialRevisionDocuments.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List3docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List3docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List3docCode.add(0, null);
                            }
                            ?? r5 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) r5, R.layout.blo_spinner_dropdown, r5.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            SpecialRevisionDocuments.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                        } else if (this.val$list.equalsIgnoreCase("LIST-4")) {
                            SpecialRevisionDocuments.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List4docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List4docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List4docCode.add(0, null);
                            }
                            ?? r6 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) r6, R.layout.blo_spinner_dropdown, r6.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            SpecialRevisionDocuments.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                        } else if (this.val$list.equalsIgnoreCase("LIST-5")) {
                            SpecialRevisionDocuments.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List5docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List5docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List5docCode.add(0, null);
                            }
                            ?? r7 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) r7, R.layout.blo_spinner_dropdown, r7.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                        } else if (this.val$list.equalsIgnoreCase("LIST-6")) {
                            SpecialRevisionDocuments.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List6docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List6docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List6docCode.add(0, null);
                            }
                            ?? r8 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) r8, R.layout.blo_spinner_dropdown, r8.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                        } else if (this.val$list.equalsIgnoreCase("LIST-7")) {
                            SpecialRevisionDocuments.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List7docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List7docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List7docCode.add(0, null);
                            }
                            ?? r9 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) r9, R.layout.blo_spinner_dropdown, r9.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                        } else if (this.val$list.equalsIgnoreCase("LIST-8")) {
                            SpecialRevisionDocuments.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            SpecialRevisionDocuments.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!SpecialRevisionDocuments.this.List8docName.contains(SpecialRevisionDocuments.this.selectDocumentType)) {
                                SpecialRevisionDocuments.this.List8docName.add(0, SpecialRevisionDocuments.this.selectDocumentType);
                                SpecialRevisionDocuments.this.List8docCode.add(0, null);
                            }
                            ?? r10 = SpecialRevisionDocuments.this;
                            ArrayAdapter arrayAdapter8 = new ArrayAdapter((Context) r10, R.layout.blo_spinner_dropdown, r10.List8docName);
                            arrayAdapter8.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SpecialRevisionDocuments.this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter8);
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = SpecialRevisionDocuments.this.commomUtility;
                    ?? r14 = SpecialRevisionDocuments.this;
                    String str = ((SpecialRevisionDocuments) r14).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r14, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(SpecialRevisionDocuments.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                Logger.e(SpecialRevisionDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                Logger.e(SpecialRevisionDocuments.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            if (SpecialRevisionDocuments.this.alertDialog != null) {
                SpecialRevisionDocuments.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                SpecialRevisionDocuments.this.commomUtility.showMessageOK(SpecialRevisionDocuments.this, SpecialRevisionDocuments.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDocuments.this.token = "Bearer " + str2;
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
            SpecialRevisionDocuments.this.getList1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDocuments.this.startActivity(new Intent(SpecialRevisionDocuments.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(SpecialRevisionDocuments.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFileIntensiveRevision(final int code, final String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        final String strReplaceAll = this.epicNumber.replaceAll("/", "_");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Document!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$52(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$52(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            this.pdf = false;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFileIntensiveRevision(final int code) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Document!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda51
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$53(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$53(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.pdf = false;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$54(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$54(View view) {
        onBackPressed();
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
            this.saveImageFileName = "img_" + code + this.jpgTextBaseActivity;
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
            Logger.d(this.TAG, this.TAG + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.TAG + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
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
            ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass23(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass23(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v18, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
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
                CommomUtility commomUtility = SpecialRevisionDocuments.this.commomUtility;
                ?? r13 = SpecialRevisionDocuments.this;
                String str = ((SpecialRevisionDocuments) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$23$$ExternalSyntheticLambda0
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
                        SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                        specialRevisionDocuments.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDocuments.token, this.val$reference, this.val$uploadtype);
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
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr)) {
                        SpecialRevisionDocuments.this.IRRef = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("IRRef", SpecialRevisionDocuments.this.IRRef);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str)) {
                        SpecialRevisionDocuments.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref1987", SpecialRevisionDocuments.this.list1ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str)) {
                        SpecialRevisionDocuments.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref2004", SpecialRevisionDocuments.this.list1ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str)) {
                        SpecialRevisionDocuments.this.list2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list2ref", SpecialRevisionDocuments.this.list2Ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str)) {
                        SpecialRevisionDocuments.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1refafter2004", SpecialRevisionDocuments.this.list1ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str)) {
                        SpecialRevisionDocuments.this.list3Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list3Ref", SpecialRevisionDocuments.this.list3Ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str)) {
                        SpecialRevisionDocuments.this.list4Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list4Ref", SpecialRevisionDocuments.this.list4Ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str)) {
                        SpecialRevisionDocuments.this.list5Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref", SpecialRevisionDocuments.this.list5Ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str)) {
                        SpecialRevisionDocuments.this.list6ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List6ref", SpecialRevisionDocuments.this.list6ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str)) {
                        SpecialRevisionDocuments.this.list7ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list7ref", SpecialRevisionDocuments.this.list7ref);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr2)) {
                        SpecialRevisionDocuments.this.IRRef2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("IRRef2", SpecialRevisionDocuments.this.IRRef2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str2)) {
                        SpecialRevisionDocuments.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref21987", SpecialRevisionDocuments.this.list1ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str2)) {
                        SpecialRevisionDocuments.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref22004", SpecialRevisionDocuments.this.list1ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str2)) {
                        SpecialRevisionDocuments.this.list2Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list2ref2", SpecialRevisionDocuments.this.list2Ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str2)) {
                        SpecialRevisionDocuments.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref2after2004", SpecialRevisionDocuments.this.list1ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str2)) {
                        SpecialRevisionDocuments.this.list3Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list3Ref2", SpecialRevisionDocuments.this.list3Ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str2)) {
                        SpecialRevisionDocuments.this.list4Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list4Ref2", SpecialRevisionDocuments.this.list4Ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str2)) {
                        SpecialRevisionDocuments.this.list5Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref", SpecialRevisionDocuments.this.list5Ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str3)) {
                        SpecialRevisionDocuments.this.list5ref3 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref3", SpecialRevisionDocuments.this.list5ref3);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str2)) {
                        SpecialRevisionDocuments.this.list6ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List6ref2", SpecialRevisionDocuments.this.list6ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str2)) {
                        SpecialRevisionDocuments.this.list7ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list7ref2", SpecialRevisionDocuments.this.list7ref2);
                        if (SpecialRevisionDocuments.this.alertDialog != null) {
                            SpecialRevisionDocuments.this.alertDialog.dismiss();
                        }
                    }
                    Logger.d(SpecialRevisionDocuments.this.TAG, "Presigned URL : " + strDecryptUrl);
                    UploadWithPreSignedURL.uploadToS3(this.val$filepath + this.val$captureFileName, SpecialRevisionDocuments.this.mime, strDecryptUrl, null);
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.imageIRlayout.setVisibility(8);
                SpecialRevisionDocuments.this.binding.viewLayoutIR.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileIR2003.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileIR2003.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.IRcount = 0;
                SpecialRevisionDocuments specialRevisionDocuments2 = SpecialRevisionDocuments.this;
                specialRevisionDocuments2.showDialog1(specialRevisionDocuments2.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutList1.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList1.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore1987.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.before1987count = 0;
                SpecialRevisionDocuments specialRevisionDocuments3 = SpecialRevisionDocuments.this;
                specialRevisionDocuments3.showDialog1(specialRevisionDocuments3.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutBefore2004Self.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageBefore2004Self.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004Self.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.before1987count = 0;
                SpecialRevisionDocuments specialRevisionDocuments4 = SpecialRevisionDocuments.this;
                specialRevisionDocuments4.showDialog1(specialRevisionDocuments4.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutList2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004Father.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.list2count = 0;
                SpecialRevisionDocuments specialRevisionDocuments5 = SpecialRevisionDocuments.this;
                specialRevisionDocuments5.showDialog1(specialRevisionDocuments5.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutAfter2004self.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageAfter2004self.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Self.setEnabled(true);
                SpecialRevisionDocuments.this.after2004count = 0;
                SpecialRevisionDocuments specialRevisionDocuments6 = SpecialRevisionDocuments.this;
                specialRevisionDocuments6.showDialog1(specialRevisionDocuments6.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList3.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList3.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Father.setEnabled(true);
                SpecialRevisionDocuments.this.list3count = 0;
                SpecialRevisionDocuments specialRevisionDocuments7 = SpecialRevisionDocuments.this;
                specialRevisionDocuments7.showDialog1(specialRevisionDocuments7.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList4.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList4.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                SpecialRevisionDocuments.this.list4coumt = 0;
                SpecialRevisionDocuments specialRevisionDocuments8 = SpecialRevisionDocuments.this;
                specialRevisionDocuments8.showDialog1(specialRevisionDocuments8.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList5.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList5.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                SpecialRevisionDocuments.this.list5count = 0;
                SpecialRevisionDocuments specialRevisionDocuments9 = SpecialRevisionDocuments.this;
                specialRevisionDocuments9.showDialog1(specialRevisionDocuments9.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList6.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList6.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                SpecialRevisionDocuments.this.list6count = 0;
                SpecialRevisionDocuments specialRevisionDocuments10 = SpecialRevisionDocuments.this;
                specialRevisionDocuments10.showDialog1(specialRevisionDocuments10.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList7.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList7.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAcquired.setEnabled(true);
                SpecialRevisionDocuments.this.list7count = 0;
                SpecialRevisionDocuments.this.binding.chooseFileAcquired.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments specialRevisionDocuments11 = SpecialRevisionDocuments.this;
                specialRevisionDocuments11.showDialog1(specialRevisionDocuments11.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutIRPage2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageIR2layout.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileIR2003Page2.setEnabled(true);
                SpecialRevisionDocuments.this.IRcount2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments12 = SpecialRevisionDocuments.this;
                specialRevisionDocuments12.showDialog1(specialRevisionDocuments12.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutList1Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList1Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                SpecialRevisionDocuments.this.before1987count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments13 = SpecialRevisionDocuments.this;
                specialRevisionDocuments13.showDialog1(specialRevisionDocuments13.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                SpecialRevisionDocuments.this.before1987count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments14 = SpecialRevisionDocuments.this;
                specialRevisionDocuments14.showDialog1(specialRevisionDocuments14.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutList2Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList2Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list2count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments15 = SpecialRevisionDocuments.this;
                specialRevisionDocuments15.showDialog1(specialRevisionDocuments15.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageAfter2004selfPage2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.after2004count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments16 = SpecialRevisionDocuments.this;
                specialRevisionDocuments16.showDialog1(specialRevisionDocuments16.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList3Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList3Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list3count2 = 0;
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments specialRevisionDocuments17 = SpecialRevisionDocuments.this;
                specialRevisionDocuments17.showDialog1(specialRevisionDocuments17.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList4Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList4Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list4coumt2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments18 = SpecialRevisionDocuments.this;
                specialRevisionDocuments18.showDialog1(specialRevisionDocuments18.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList5Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList5Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list5count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments19 = SpecialRevisionDocuments.this;
                specialRevisionDocuments19.showDialog1(specialRevisionDocuments19.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str3)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList5Page3.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList5Page3.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                SpecialRevisionDocuments.this.list5count3 = 0;
                SpecialRevisionDocuments specialRevisionDocuments20 = SpecialRevisionDocuments.this;
                specialRevisionDocuments20.showDialog1(specialRevisionDocuments20.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList6Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList6Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list6count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments21 = SpecialRevisionDocuments.this;
                specialRevisionDocuments21.showDialog1(specialRevisionDocuments21.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                SpecialRevisionDocuments.this.binding.viewList7Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.imageList7Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                SpecialRevisionDocuments.this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(SpecialRevisionDocuments.this.whitecolor));
                SpecialRevisionDocuments.this.list7count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments22 = SpecialRevisionDocuments.this;
                specialRevisionDocuments22.showDialog1(specialRevisionDocuments22.alertText, SpecialRevisionDocuments.this.fileNotFoundMessage);
            }
            if (SpecialRevisionDocuments.this.alertDialog != null) {
                SpecialRevisionDocuments.this.alertDialog.dismiss();
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
                SpecialRevisionDocuments.this.commomUtility.showMessageOK(SpecialRevisionDocuments.this, SpecialRevisionDocuments.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$23$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDocuments.this.token = "Bearer " + str8;
            SpecialRevisionDocuments.this.refreshToken = str9;
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setToken("Bearer " + str8);
            SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
            specialRevisionDocuments.uploadPhoto(str, str2, str3, str4, str5, specialRevisionDocuments.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDocuments.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDocuments.this.startActivity(new Intent((Context) SpecialRevisionDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.IRcount < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.IRRef)) {
                    SpecialRevisionDocuments.this.IRcount++;
                    SpecialRevisionDocuments specialRevisionDocuments = SpecialRevisionDocuments.this;
                    specialRevisionDocuments.showdialogref(specialRevisionDocuments.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageIRlayout.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileIR2003.setEnabled(true);
                    SpecialRevisionDocuments.this.IRcount = 0;
                    SpecialRevisionDocuments specialRevisionDocuments2 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments2.showDialog1(specialRevisionDocuments2.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.before1987count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref)) {
                    SpecialRevisionDocuments.this.before1987count++;
                    SpecialRevisionDocuments specialRevisionDocuments3 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments3.showdialogref(specialRevisionDocuments3.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList1.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore1987.setEnabled(true);
                    SpecialRevisionDocuments.this.before1987count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments4 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments4.showDialog1(specialRevisionDocuments4.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.before2004count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref)) {
                    SpecialRevisionDocuments.this.before2004count++;
                    SpecialRevisionDocuments specialRevisionDocuments5 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments5.showdialogref(specialRevisionDocuments5.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageBefore2004Self.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore2004Self.setEnabled(true);
                    SpecialRevisionDocuments.this.before1987count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments6 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments6.showDialog1(specialRevisionDocuments6.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list2count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list2Ref)) {
                    SpecialRevisionDocuments.this.list2count++;
                    SpecialRevisionDocuments specialRevisionDocuments7 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments7.showdialogref(specialRevisionDocuments7.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore2004Father.setEnabled(true);
                    SpecialRevisionDocuments.this.list2count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments8 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments8.showDialog1(specialRevisionDocuments8.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.after2004count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref)) {
                    SpecialRevisionDocuments.this.after2004count++;
                    SpecialRevisionDocuments specialRevisionDocuments9 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments9.showdialogref(specialRevisionDocuments9.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageAfter2004self.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004Self.setEnabled(true);
                    SpecialRevisionDocuments.this.after2004count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments10 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments10.showDialog1(specialRevisionDocuments10.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list3count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list3Ref)) {
                    SpecialRevisionDocuments.this.list3count++;
                    SpecialRevisionDocuments specialRevisionDocuments11 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments11.showdialogref(specialRevisionDocuments11.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList3.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004Father.setEnabled(true);
                    SpecialRevisionDocuments.this.list3count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments12 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments12.showDialog1(specialRevisionDocuments12.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list4coumt < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list4Ref)) {
                    SpecialRevisionDocuments.this.list4coumt++;
                    SpecialRevisionDocuments specialRevisionDocuments13 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments13.showdialogref(specialRevisionDocuments13.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList4.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                    SpecialRevisionDocuments.this.list4coumt = 0;
                    SpecialRevisionDocuments specialRevisionDocuments14 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments14.showDialog1(specialRevisionDocuments14.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list5count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list5Ref)) {
                    SpecialRevisionDocuments.this.list5count++;
                    SpecialRevisionDocuments specialRevisionDocuments15 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments15.showdialogref(specialRevisionDocuments15.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList5.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                    SpecialRevisionDocuments.this.list5count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments16 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments16.showDialog1(specialRevisionDocuments16.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list6count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list6ref)) {
                    SpecialRevisionDocuments.this.list6count++;
                    SpecialRevisionDocuments specialRevisionDocuments17 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments17.showdialogref(specialRevisionDocuments17.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList6.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                    SpecialRevisionDocuments.this.list6count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments18 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments18.showDialog1(specialRevisionDocuments18.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list7count < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list7ref)) {
                    SpecialRevisionDocuments.this.list7count++;
                    SpecialRevisionDocuments specialRevisionDocuments19 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments19.showdialogref(specialRevisionDocuments19.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList7.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAcquired.setEnabled(true);
                    SpecialRevisionDocuments.this.list7count = 0;
                    SpecialRevisionDocuments specialRevisionDocuments20 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments20.showDialog1(specialRevisionDocuments20.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.IRStr2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.IRcount2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.IRRef2)) {
                    SpecialRevisionDocuments.this.IRcount2++;
                    SpecialRevisionDocuments specialRevisionDocuments21 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments21.showdialogref(specialRevisionDocuments21.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageIR2layout.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileIR2003Page2.setEnabled(true);
                    SpecialRevisionDocuments.this.IRcount2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments22 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments22.showDialog1(specialRevisionDocuments22.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before1987Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.before1987count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref2)) {
                    SpecialRevisionDocuments.this.before1987count2++;
                    SpecialRevisionDocuments specialRevisionDocuments23 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments23.showdialogref(specialRevisionDocuments23.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList1Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                    SpecialRevisionDocuments.this.before1987count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments24 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments24.showDialog1(specialRevisionDocuments24.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.before2004Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.before2004count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref2)) {
                    SpecialRevisionDocuments.this.before2004count2++;
                    SpecialRevisionDocuments specialRevisionDocuments25 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments25.showdialogref(specialRevisionDocuments25.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.before1987count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments26 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments26.showDialog1(specialRevisionDocuments26.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list2Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list2count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list2Ref2)) {
                    SpecialRevisionDocuments.this.list2count2++;
                    SpecialRevisionDocuments specialRevisionDocuments27 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments27.showdialogref(specialRevisionDocuments27.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList2Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.list2count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments28 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments28.showDialog1(specialRevisionDocuments28.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.after2004Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.after2004count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list1ref2)) {
                    SpecialRevisionDocuments.this.after2004count2++;
                    SpecialRevisionDocuments specialRevisionDocuments29 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments29.showdialogref(specialRevisionDocuments29.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageAfter2004selfPage2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.after2004count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments30 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments30.showDialog1(specialRevisionDocuments30.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list3Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list3count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list3Ref2)) {
                    SpecialRevisionDocuments.this.list3count2++;
                    SpecialRevisionDocuments specialRevisionDocuments31 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments31.showdialogref(specialRevisionDocuments31.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList3Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.list3count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments32 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments32.showDialog1(specialRevisionDocuments32.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list4Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list4coumt2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list4Ref2)) {
                    SpecialRevisionDocuments.this.list4coumt2++;
                    SpecialRevisionDocuments specialRevisionDocuments33 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments33.showdialogref(specialRevisionDocuments33.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList4Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.list4coumt2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments34 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments34.showDialog1(specialRevisionDocuments34.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list5count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list5Ref2)) {
                    SpecialRevisionDocuments.this.list5count2++;
                    SpecialRevisionDocuments specialRevisionDocuments35 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments35.showdialogref(specialRevisionDocuments35.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList5Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.list5count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments36 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments36.showDialog1(specialRevisionDocuments36.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list5Str3)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list5count3 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list5ref3)) {
                    SpecialRevisionDocuments.this.list5count3++;
                    SpecialRevisionDocuments specialRevisionDocuments37 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments37.showdialogref(specialRevisionDocuments37.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList5Page3.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                    SpecialRevisionDocuments.this.list5count3 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments38 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments38.showDialog1(specialRevisionDocuments38.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list6Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list6count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list6ref2)) {
                    SpecialRevisionDocuments.this.list6count2++;
                    SpecialRevisionDocuments specialRevisionDocuments39 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments39.showdialogref(specialRevisionDocuments39.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                } else {
                    SpecialRevisionDocuments.this.binding.imageList6Page2.setVisibility(8);
                    SpecialRevisionDocuments.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                    SpecialRevisionDocuments.this.list6count2 = 0;
                    SpecialRevisionDocuments specialRevisionDocuments40 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments40.showDialog1(specialRevisionDocuments40.alertText, "filenotuploaded");
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDocuments.this.list7Str2)) {
                if (SpecialRevisionDocuments.this.alertDialog != null) {
                    SpecialRevisionDocuments.this.alertDialog.dismiss();
                }
                if (SpecialRevisionDocuments.this.list7count2 < 1 && TextUtils.isEmpty(SpecialRevisionDocuments.this.list7ref2)) {
                    SpecialRevisionDocuments.this.list7count2++;
                    SpecialRevisionDocuments specialRevisionDocuments41 = SpecialRevisionDocuments.this;
                    specialRevisionDocuments41.showdialogref(specialRevisionDocuments41.alertText, SpecialRevisionDocuments.this.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                SpecialRevisionDocuments.this.binding.imageList7Page2.setVisibility(8);
                SpecialRevisionDocuments.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                SpecialRevisionDocuments.this.list7count2 = 0;
                SpecialRevisionDocuments specialRevisionDocuments42 = SpecialRevisionDocuments.this;
                specialRevisionDocuments42.showDialog1(specialRevisionDocuments42.alertText, "filenotuploaded");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda52
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$55(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$55(DialogInterface dialogInterface, int i) {
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda49
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$56(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$56(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) pendingElectors.class);
        intent.addFlags(335544320);
        intent.putExtra("restart", true);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("Retry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$57(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$57(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (requestCode == 0) {
                Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(data), 0).show();
                return;
            }
            Toast.makeText((Context) this, (CharSequence) "Uploading cancelled", 0).show();
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
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
            String str = strArrSplit[strArrSplit.length - 1];
            Logger.d(this.TAG, Arrays.toString(strArrSplit));
            if (requestCode == 101) {
                long j = this.filesize;
                if (j < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
                    } else {
                        this.alertDialog.dismiss();
                        this.IRRef = str;
                    }
                    this.binding.viewLayoutIR.setVisibility(0);
                    this.binding.imageIRlayout.setVisibility(0);
                    this.binding.cancelIR.setVisibility(0);
                    this.binding.IRName.setVisibility(0);
                    this.binding.IRSize.setVisibility(0);
                    this.binding.imageIR.setVisibility(0);
                    ImageView imageView = this.binding.imageIR;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileIR2003.setEnabled(false);
                    this.binding.IRName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.IRSize.setText(this.filesize + "KB");
                    return;
                }
                if (j > 2048) {
                    this.binding.viewLayoutIR.setVisibility(8);
                    this.binding.cancelIR.setVisibility(8);
                    this.binding.IRName.setVisibility(8);
                    this.binding.IRSize.setVisibility(8);
                    this.binding.imageIR.setVisibility(8);
                    this.binding.imageIRlayout.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j2 = j / 1024;
                this.filesize = j2;
                double dRound = Math.round(j2 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.viewLayoutIR.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
                } else {
                    this.alertDialog.dismiss();
                    this.IRRef = str;
                }
                this.binding.imageIRlayout.setVisibility(0);
                this.binding.viewLayoutIR.setVisibility(0);
                this.binding.cancelIR.setVisibility(0);
                this.binding.IRName.setVisibility(0);
                this.binding.IRSize.setVisibility(0);
                this.binding.imageIR.setVisibility(0);
                ImageView imageView2 = this.binding.imageIR;
                byte[] bArr2 = this.pdfbyteArray;
                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.IRName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.IRSize.setText(dRound + "MB");
                return;
            }
            if (requestCode == 102) {
                long j3 = this.filesize;
                if (j3 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutList1.setVisibility(0);
                    this.binding.cancelList1.setVisibility(0);
                    this.binding.list1Name.setVisibility(0);
                    this.binding.list1Size.setVisibility(0);
                    this.binding.imageList1.setVisibility(0);
                    ImageView imageView3 = this.binding.imageList1;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore1987.setEnabled(false);
                    this.binding.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list1Size.setText(this.filesize + "KB");
                    return;
                }
                if (j3 > 2048) {
                    this.binding.viewLayoutList1.setVisibility(8);
                    this.binding.cancelList1.setVisibility(8);
                    this.binding.list1Name.setVisibility(8);
                    this.binding.list1Size.setVisibility(8);
                    this.binding.imageList1.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j4 = j3 / 1024;
                this.filesize = j4;
                double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                if (dRound2 > 2.0d) {
                    this.binding.viewLayoutList1.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutList1.setVisibility(0);
                this.binding.cancelList1.setVisibility(0);
                this.binding.list1Name.setVisibility(0);
                this.binding.list1Size.setVisibility(0);
                this.binding.imageList1.setVisibility(0);
                ImageView imageView4 = this.binding.imageList1;
                byte[] bArr4 = this.pdfbyteArray;
                imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore1987.setEnabled(false);
                this.binding.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list1Size.setText(dRound2 + "MB");
                return;
            }
            if (requestCode == 104) {
                long j5 = this.filesize;
                if (j5 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref = str;
                    }
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView5 = this.binding.imageList2;
                    byte[] bArr5 = this.pdfbyteArray;
                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2Size.setText(this.filesize + "KB");
                    return;
                }
                if (j5 > 2048) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    this.binding.cancelList2.setVisibility(8);
                    this.binding.list2Name.setVisibility(8);
                    this.binding.list2Size.setVisibility(8);
                    this.binding.imageList2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j6 = j5 / 1024;
                this.filesize = j6;
                double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                if (dRound3 > 2.0d) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref = str;
                }
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView6 = this.binding.imageList2;
                byte[] bArr6 = this.pdfbyteArray;
                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound3 + "MB");
                return;
            }
            if (requestCode == 111) {
                long j7 = this.filesize;
                if (j7 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref = str;
                    }
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView7 = this.binding.imageList2;
                    byte[] bArr7 = this.pdfbyteArray;
                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2Size.setText(this.filesize + "KB");
                    return;
                }
                if (j7 > 2048) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    this.binding.cancelList2.setVisibility(8);
                    this.binding.list2Name.setVisibility(8);
                    this.binding.list2Size.setVisibility(8);
                    this.binding.imageList2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j8 = j7 / 1024;
                this.filesize = j8;
                double dRound4 = Math.round(j8 * 100.0d) / 100.0d;
                if (dRound4 > 2.0d) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref = str;
                }
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView8 = this.binding.imageList2;
                byte[] bArr8 = this.pdfbyteArray;
                imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound4 + "MB");
                return;
            }
            if (requestCode == 103) {
                long j9 = this.filesize;
                if (j9 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    this.binding.cancelBefore2004Self.setVisibility(0);
                    this.binding.before2004SelfName.setVisibility(0);
                    this.binding.before2004SelfSize.setVisibility(0);
                    this.binding.imageBefore2004Self.setVisibility(0);
                    ImageView imageView9 = this.binding.imageBefore2004Self;
                    byte[] bArr9 = this.pdfbyteArray;
                    imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                    this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004Self.setEnabled(false);
                    this.binding.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.before2004SelfSize.setText(this.filesize + "KB");
                    return;
                }
                if (j9 > 2048) {
                    this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    this.binding.cancelBefore2004Self.setVisibility(8);
                    this.binding.before2004SelfName.setVisibility(8);
                    this.binding.before2004SelfSize.setVisibility(8);
                    this.binding.imageBefore2004Self.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j10 = j9 / 1024;
                this.filesize = j10;
                double dRound5 = Math.round(j10 * 100.0d) / 100.0d;
                if (dRound5 > 2.0d) {
                    this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutBefore2004Self.setVisibility(0);
                this.binding.cancelBefore2004Self.setVisibility(0);
                this.binding.before2004SelfName.setVisibility(0);
                this.binding.before2004SelfSize.setVisibility(0);
                this.binding.imageBefore2004Self.setVisibility(0);
                ImageView imageView10 = this.binding.imageBefore2004Self;
                byte[] bArr10 = this.pdfbyteArray;
                imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.before2004SelfSize.setText(dRound5 + "MB");
                return;
            }
            if (requestCode == 105) {
                long j11 = this.filesize;
                if (j11 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutAfter2004self.setVisibility(0);
                    this.binding.cancelAfter2004self.setVisibility(0);
                    this.binding.after2004selfName.setVisibility(0);
                    this.binding.after2004selfSize.setVisibility(0);
                    this.binding.imageAfter2004self.setVisibility(0);
                    ImageView imageView11 = this.binding.imageAfter2004self;
                    byte[] bArr11 = this.pdfbyteArray;
                    imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                    this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Self.setEnabled(false);
                    this.binding.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.after2004selfSize.setText(this.filesize + "KB");
                    return;
                }
                if (j11 > 2048) {
                    this.binding.viewLayoutAfter2004self.setVisibility(8);
                    this.binding.cancelAfter2004self.setVisibility(8);
                    this.binding.after2004selfName.setVisibility(8);
                    this.binding.after2004selfSize.setVisibility(8);
                    this.binding.imageAfter2004self.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j12 = j11 / 1024;
                this.filesize = j12;
                double dRound6 = Math.round(j12 * 100.0d) / 100.0d;
                if (dRound6 > 2.0d) {
                    this.binding.viewLayoutAfter2004self.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutAfter2004self.setVisibility(0);
                this.binding.cancelAfter2004self.setVisibility(0);
                this.binding.after2004selfName.setVisibility(0);
                this.binding.after2004selfSize.setVisibility(0);
                this.binding.imageAfter2004self.setVisibility(0);
                ImageView imageView12 = this.binding.imageAfter2004self;
                byte[] bArr12 = this.pdfbyteArray;
                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Self.setEnabled(false);
                this.binding.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.after2004selfSize.setText(dRound6 + "MB");
                return;
            }
            if (requestCode == 106) {
                long j13 = this.filesize;
                if (j13 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref = str;
                    }
                    this.binding.viewList3.setVisibility(0);
                    this.binding.cancelList3.setVisibility(0);
                    this.binding.list3Name.setVisibility(0);
                    this.binding.list3Size.setVisibility(0);
                    this.binding.imageList3.setVisibility(0);
                    ImageView imageView13 = this.binding.imageList3;
                    byte[] bArr13 = this.pdfbyteArray;
                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                    this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Father.setEnabled(false);
                    this.binding.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list3Size.setText(this.filesize + "KB");
                    return;
                }
                if (j13 > 2048) {
                    this.binding.viewList3.setVisibility(8);
                    this.binding.cancelList3.setVisibility(8);
                    this.binding.list3Name.setVisibility(8);
                    this.binding.list3Size.setVisibility(8);
                    this.binding.imageList3.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j14 = j13 / 1024;
                this.filesize = j14;
                double dRound7 = Math.round(j14 * 100.0d) / 100.0d;
                if (dRound7 > 2.0d) {
                    this.binding.viewList3.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref = str;
                }
                this.binding.viewList3.setVisibility(0);
                this.binding.cancelList3.setVisibility(0);
                this.binding.list3Name.setVisibility(0);
                this.binding.list3Size.setVisibility(0);
                this.binding.imageList3.setVisibility(0);
                ImageView imageView14 = this.binding.imageList3;
                byte[] bArr14 = this.pdfbyteArray;
                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Father.setEnabled(false);
                this.binding.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list3Size.setText(dRound7 + "MB");
                return;
            }
            if (requestCode == 107) {
                long j15 = this.filesize;
                if (j15 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref = str;
                    }
                    this.binding.viewList4.setVisibility(0);
                    this.binding.cancelList4.setVisibility(0);
                    this.binding.list4Name.setVisibility(0);
                    this.binding.list4Size.setVisibility(0);
                    this.binding.imageList4.setVisibility(0);
                    ImageView imageView15 = this.binding.imageList4;
                    byte[] bArr15 = this.pdfbyteArray;
                    imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                    this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Mother.setEnabled(false);
                    this.binding.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list4Size.setText(this.filesize + "KB");
                    return;
                }
                if (j15 > 2048) {
                    this.binding.viewList4.setVisibility(8);
                    this.binding.cancelList4.setVisibility(8);
                    this.binding.list4Name.setVisibility(8);
                    this.binding.list4Size.setVisibility(8);
                    this.binding.imageList4.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j16 = j15 / 1024;
                this.filesize = j16;
                double dRound8 = Math.round(j16 * 100.0d) / 100.0d;
                if (dRound8 > 2.0d) {
                    this.binding.viewList4.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref = str;
                }
                this.binding.viewList4.setVisibility(0);
                this.binding.cancelList4.setVisibility(0);
                this.binding.list4Name.setVisibility(0);
                this.binding.list4Size.setVisibility(0);
                this.binding.imageList4.setVisibility(0);
                ImageView imageView16 = this.binding.imageList4;
                byte[] bArr16 = this.pdfbyteArray;
                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Mother.setEnabled(false);
                this.binding.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list4Size.setText(dRound8 + "MB");
                return;
            }
            if (requestCode == 108) {
                long j17 = this.filesize;
                if (j17 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list5Ref = str;
                    }
                    this.binding.viewList5.setVisibility(0);
                    this.binding.cancelList5.setVisibility(0);
                    this.binding.list5Name.setVisibility(0);
                    this.binding.list5Size.setVisibility(0);
                    this.binding.imageList5.setVisibility(0);
                    ImageView imageView17 = this.binding.imageList5;
                    byte[] bArr17 = this.pdfbyteArray;
                    imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
                    this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                    this.binding.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5Size.setText(this.filesize + "KB");
                    return;
                }
                if (j17 > 2048) {
                    this.binding.viewList5.setVisibility(8);
                    this.binding.cancelList5.setVisibility(8);
                    this.binding.list5Name.setVisibility(8);
                    this.binding.list5Size.setVisibility(8);
                    this.binding.imageList5.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j18 = j17 / 1024;
                this.filesize = j18;
                double dRound9 = Math.round(j18 * 100.0d) / 100.0d;
                if (dRound9 > 2.0d) {
                    this.binding.viewList5.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list5Ref = str;
                }
                this.binding.viewList5.setVisibility(0);
                this.binding.cancelList5.setVisibility(0);
                this.binding.list5Name.setVisibility(0);
                this.binding.list5Size.setVisibility(0);
                this.binding.imageList5.setVisibility(0);
                ImageView imageView18 = this.binding.imageList5;
                byte[] bArr18 = this.pdfbyteArray;
                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                this.binding.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5Size.setText(dRound9 + "MB");
                return;
            }
            if (requestCode == 109) {
                long j19 = this.filesize;
                if (j19 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list6ref = str;
                    }
                    this.binding.viewList6.setVisibility(0);
                    this.binding.cancelList6.setVisibility(0);
                    this.binding.list6Name.setVisibility(0);
                    this.binding.list6Size.setVisibility(0);
                    this.binding.imageList6.setVisibility(0);
                    ImageView imageView19 = this.binding.imageList6;
                    byte[] bArr19 = this.pdfbyteArray;
                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, 0, bArr19.length));
                    this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                    this.binding.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list6Size.setText(this.filesize + "KB");
                    return;
                }
                if (j19 > 2048) {
                    this.binding.viewList6.setVisibility(8);
                    this.binding.cancelList6.setVisibility(8);
                    this.binding.list6Name.setVisibility(8);
                    this.binding.list6Size.setVisibility(8);
                    this.binding.imageList6.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j20 = j19 / 1024;
                this.filesize = j20;
                double dRound10 = Math.round(j20 * 100.0d) / 100.0d;
                if (dRound10 > 2.0d) {
                    this.binding.viewList6.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list6ref = str;
                }
                this.binding.viewList6.setVisibility(0);
                this.binding.cancelList6.setVisibility(0);
                this.binding.list6Name.setVisibility(0);
                this.binding.list6Size.setVisibility(0);
                this.binding.imageList6.setVisibility(0);
                ImageView imageView20 = this.binding.imageList6;
                byte[] bArr20 = this.pdfbyteArray;
                imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, 0, bArr20.length));
                this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                this.binding.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list6Size.setText(dRound10 + "MB");
                return;
            }
            if (requestCode == 110) {
                long j21 = this.filesize;
                if (j21 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list7ref = str;
                    }
                    this.binding.viewList7.setVisibility(0);
                    this.binding.cancelList7.setVisibility(0);
                    this.binding.list7Name.setVisibility(0);
                    this.binding.list7Size.setVisibility(0);
                    this.binding.imageList7.setVisibility(0);
                    ImageView imageView21 = this.binding.imageList7;
                    byte[] bArr21 = this.pdfbyteArray;
                    imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, 0, bArr21.length));
                    this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAcquired.setEnabled(false);
                    this.binding.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list7Size.setText(this.filesize + "KB");
                    return;
                }
                if (j21 > 2048) {
                    this.binding.viewList7.setVisibility(8);
                    this.binding.cancelList7.setVisibility(8);
                    this.binding.list7Name.setVisibility(8);
                    this.binding.list7Size.setVisibility(8);
                    this.binding.imageList7.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j22 = j21 / 1024;
                this.filesize = j22;
                double dRound11 = Math.round(j22 * 100.0d) / 100.0d;
                if (dRound11 > 2.0d) {
                    this.binding.viewList7.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list7ref = str;
                }
                this.binding.viewList7.setVisibility(0);
                this.binding.cancelList7.setVisibility(0);
                this.binding.list7Name.setVisibility(0);
                this.binding.list7Size.setVisibility(0);
                this.binding.imageList7.setVisibility(0);
                ImageView imageView22 = this.binding.imageList7;
                byte[] bArr22 = this.pdfbyteArray;
                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, 0, bArr22.length));
                this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAcquired.setEnabled(false);
                this.binding.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list7Size.setText(dRound11 + "MB");
                return;
            }
            if (requestCode == 201) {
                long j23 = this.filesize;
                if (j23 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
                    } else {
                        this.alertDialog.dismiss();
                        this.IRRef2 = str;
                    }
                    this.binding.imageIR2layout.setVisibility(0);
                    this.binding.viewLayoutIRPage2.setVisibility(0);
                    this.binding.cancelIRPage2.setVisibility(0);
                    this.binding.IRNamePage2.setVisibility(0);
                    this.binding.IRSizePage2.setVisibility(0);
                    this.binding.imageIRPage2.setVisibility(0);
                    ImageView imageView23 = this.binding.imageIRPage2;
                    byte[] bArr23 = this.pdfbyteArray;
                    imageView23.setImageBitmap(BitmapFactory.decodeByteArray(bArr23, 0, bArr23.length));
                    this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileIR2003Page2.setEnabled(false);
                    this.binding.IRNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.IRSizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j23 > 2048) {
                    this.binding.imageIR2layout.setVisibility(8);
                    this.binding.viewLayoutIRPage2.setVisibility(8);
                    this.binding.cancelIRPage2.setVisibility(8);
                    this.binding.IRNamePage2.setVisibility(8);
                    this.binding.IRSizePage2.setVisibility(8);
                    this.binding.imageIRPage2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j24 = j23 / 1024;
                this.filesize = j24;
                double dRound12 = Math.round(j24 * 100.0d) / 100.0d;
                if (dRound12 > 2.0d) {
                    this.binding.viewLayoutIRPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
                } else {
                    this.alertDialog.dismiss();
                    this.IRRef2 = str;
                }
                this.binding.imageIR2layout.setVisibility(0);
                this.binding.viewLayoutIRPage2.setVisibility(0);
                this.binding.cancelIRPage2.setVisibility(0);
                this.binding.IRNamePage2.setVisibility(0);
                this.binding.IRSizePage2.setVisibility(0);
                this.binding.imageIRPage2.setVisibility(0);
                ImageView imageView24 = this.binding.imageIRPage2;
                byte[] bArr24 = this.pdfbyteArray;
                imageView24.setImageBitmap(BitmapFactory.decodeByteArray(bArr24, 0, bArr24.length));
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.IRNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.IRSizePage2.setText(dRound12 + "MB");
                return;
            }
            if (requestCode == 202) {
                long j25 = this.filesize;
                if (j25 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutList1Page2.setVisibility(0);
                    this.binding.cancelList1Page2.setVisibility(0);
                    this.binding.list1NamePage2.setVisibility(0);
                    this.binding.list1SizePage2.setVisibility(0);
                    this.binding.imageList1Page2.setVisibility(0);
                    ImageView imageView25 = this.binding.imageList1Page2;
                    byte[] bArr25 = this.pdfbyteArray;
                    imageView25.setImageBitmap(BitmapFactory.decodeByteArray(bArr25, 0, bArr25.length));
                    this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    this.binding.list1NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list1SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j25 > 2048) {
                    this.binding.viewLayoutList1Page2.setVisibility(8);
                    this.binding.cancelList1Page2.setVisibility(8);
                    this.binding.list1NamePage2.setVisibility(8);
                    this.binding.list1SizePage2.setVisibility(8);
                    this.binding.imageList1Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j26 = j25 / 1024;
                this.filesize = j26;
                double dRound13 = Math.round(j26 * 100.0d) / 100.0d;
                if (dRound13 > 2.0d) {
                    this.binding.viewLayoutList1Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutList1Page2.setVisibility(0);
                this.binding.cancelList1Page2.setVisibility(0);
                this.binding.list1NamePage2.setVisibility(0);
                this.binding.list1SizePage2.setVisibility(0);
                this.binding.imageList1Page2.setVisibility(0);
                ImageView imageView26 = this.binding.imageList1Page2;
                byte[] bArr26 = this.pdfbyteArray;
                imageView26.setImageBitmap(BitmapFactory.decodeByteArray(bArr26, 0, bArr26.length));
                this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore1987Page2.setEnabled(false);
                this.binding.list1NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list1SizePage2.setText(dRound13 + "MB");
                return;
            }
            if (requestCode == 204) {
                long j27 = this.filesize;
                if (j27 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref2 = str;
                    }
                    this.binding.viewLayoutList2Page2.setVisibility(0);
                    this.binding.cancelList2Page2.setVisibility(0);
                    this.binding.list2NamePage2.setVisibility(0);
                    this.binding.list2SizePage2.setVisibility(0);
                    this.binding.imageList2Page2.setVisibility(0);
                    ImageView imageView27 = this.binding.imageList2Page2;
                    byte[] bArr27 = this.pdfbyteArray;
                    imageView27.setImageBitmap(BitmapFactory.decodeByteArray(bArr27, 0, bArr27.length));
                    this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                    this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j27 > 2048) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    this.binding.cancelList2Page2.setVisibility(8);
                    this.binding.list2NamePage2.setVisibility(8);
                    this.binding.list2SizePage2.setVisibility(8);
                    this.binding.imageList2Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j28 = j27 / 1024;
                this.filesize = j28;
                double dRound14 = Math.round(j28 * 100.0d) / 100.0d;
                if (dRound14 > 2.0d) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref2 = str;
                }
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                ImageView imageView28 = this.binding.imageList2Page2;
                byte[] bArr28 = this.pdfbyteArray;
                imageView28.setImageBitmap(BitmapFactory.decodeByteArray(bArr28, 0, bArr28.length));
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2SizePage2.setText(dRound14 + "MB");
                return;
            }
            if (requestCode == 211) {
                long j29 = this.filesize;
                if (j29 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref2 = str;
                    }
                    this.binding.viewLayoutList2Page2.setVisibility(0);
                    this.binding.cancelList2Page2.setVisibility(0);
                    this.binding.list2NamePage2.setVisibility(0);
                    this.binding.list2SizePage2.setVisibility(0);
                    this.binding.imageList2Page2.setVisibility(0);
                    ImageView imageView29 = this.binding.imageList2Page2;
                    byte[] bArr29 = this.pdfbyteArray;
                    imageView29.setImageBitmap(BitmapFactory.decodeByteArray(bArr29, 0, bArr29.length));
                    this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                    this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j29 > 2048) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    this.binding.cancelList2Page2.setVisibility(8);
                    this.binding.list2NamePage2.setVisibility(8);
                    this.binding.list2SizePage2.setVisibility(8);
                    this.binding.imageList2Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j30 = j29 / 1024;
                this.filesize = j30;
                double dRound15 = Math.round(j30 * 100.0d) / 100.0d;
                if (dRound15 > 2.0d) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref2 = str;
                }
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                ImageView imageView30 = this.binding.imageList2Page2;
                byte[] bArr30 = this.pdfbyteArray;
                imageView30.setImageBitmap(BitmapFactory.decodeByteArray(bArr30, 0, bArr30.length));
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2SizePage2.setText(dRound15 + "MB");
                return;
            }
            if (requestCode == 203) {
                long j31 = this.filesize;
                if (j31 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    this.binding.before2004SelfNamePage2.setVisibility(0);
                    this.binding.before2004SelfSizePage2.setVisibility(0);
                    this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    ImageView imageView31 = this.binding.imageBefore2004SelfPage2;
                    byte[] bArr31 = this.pdfbyteArray;
                    imageView31.setImageBitmap(BitmapFactory.decodeByteArray(bArr31, 0, bArr31.length));
                    this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    this.binding.before2004SelfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.before2004SelfSizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j31 > 2048) {
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    this.binding.cancelBefore2004SelfPage2.setVisibility(8);
                    this.binding.before2004SelfNamePage2.setVisibility(8);
                    this.binding.before2004SelfSizePage2.setVisibility(8);
                    this.binding.imageBefore2004SelfPage2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j32 = j31 / 1024;
                this.filesize = j32;
                double dRound16 = Math.round(j32 * 100.0d) / 100.0d;
                if (dRound16 > 2.0d) {
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                this.binding.before2004SelfNamePage2.setVisibility(0);
                this.binding.before2004SelfSizePage2.setVisibility(0);
                this.binding.imageBefore2004SelfPage2.setVisibility(0);
                ImageView imageView32 = this.binding.imageBefore2004SelfPage2;
                byte[] bArr32 = this.pdfbyteArray;
                imageView32.setImageBitmap(BitmapFactory.decodeByteArray(bArr32, 0, bArr32.length));
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.before2004SelfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.before2004SelfSizePage2.setText(dRound16 + "MB");
                return;
            }
            if (requestCode == 205) {
                long j33 = this.filesize;
                if (j33 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    this.binding.after2004selfNamePage2.setVisibility(0);
                    this.binding.after2004selfSizePage2.setVisibility(0);
                    this.binding.imageAfter2004selfPage2.setVisibility(0);
                    ImageView imageView33 = this.binding.imageAfter2004selfPage2;
                    byte[] bArr33 = this.pdfbyteArray;
                    imageView33.setImageBitmap(BitmapFactory.decodeByteArray(bArr33, 0, bArr33.length));
                    this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    this.binding.after2004selfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.after2004selfSizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j33 > 2048) {
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    this.binding.cancelAfter2004selfPage2.setVisibility(8);
                    this.binding.after2004selfNamePage2.setVisibility(8);
                    this.binding.after2004selfSizePage2.setVisibility(8);
                    this.binding.imageAfter2004selfPage2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j34 = j33 / 1024;
                this.filesize = j34;
                double dRound17 = Math.round(j34 * 100.0d) / 100.0d;
                if (dRound17 > 2.0d) {
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                this.binding.cancelAfter2004selfPage2.setVisibility(0);
                this.binding.after2004selfNamePage2.setVisibility(0);
                this.binding.after2004selfSizePage2.setVisibility(0);
                this.binding.imageAfter2004selfPage2.setVisibility(0);
                ImageView imageView34 = this.binding.imageAfter2004selfPage2;
                byte[] bArr34 = this.pdfbyteArray;
                imageView34.setImageBitmap(BitmapFactory.decodeByteArray(bArr34, 0, bArr34.length));
                this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                this.binding.after2004selfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.after2004selfSizePage2.setText(dRound17 + "MB");
                return;
            }
            if (requestCode == 206) {
                long j35 = this.filesize;
                if (j35 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref2 = str;
                    }
                    this.binding.viewList3Page2.setVisibility(0);
                    this.binding.cancelList3Page2.setVisibility(0);
                    this.binding.list3NamePage2.setVisibility(0);
                    this.binding.list3SizePage2.setVisibility(0);
                    this.binding.imageList3Page2.setVisibility(0);
                    ImageView imageView35 = this.binding.imageList3Page2;
                    byte[] bArr35 = this.pdfbyteArray;
                    imageView35.setImageBitmap(BitmapFactory.decodeByteArray(bArr35, 0, bArr35.length));
                    this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                    this.binding.list3NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list3SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j35 > 2048) {
                    this.binding.viewList3Page2.setVisibility(8);
                    this.binding.cancelList3Page2.setVisibility(8);
                    this.binding.list3NamePage2.setVisibility(8);
                    this.binding.list3SizePage2.setVisibility(8);
                    this.binding.imageList3Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j36 = j35 / 1024;
                this.filesize = j36;
                double dRound18 = Math.round(j36 * 100.0d) / 100.0d;
                if (dRound18 > 2.0d) {
                    this.binding.viewList3Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref2 = str;
                }
                this.binding.viewList3Page2.setVisibility(0);
                this.binding.cancelList3Page2.setVisibility(0);
                this.binding.list3NamePage2.setVisibility(0);
                this.binding.list3SizePage2.setVisibility(0);
                this.binding.imageList3Page2.setVisibility(0);
                ImageView imageView36 = this.binding.imageList3Page2;
                byte[] bArr36 = this.pdfbyteArray;
                imageView36.setImageBitmap(BitmapFactory.decodeByteArray(bArr36, 0, bArr36.length));
                this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                this.binding.list3NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list3SizePage2.setText(dRound18 + "MB");
                return;
            }
            if (requestCode == 207) {
                long j37 = this.filesize;
                if (j37 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref2 = str;
                    }
                    this.binding.viewList4Page2.setVisibility(0);
                    this.binding.cancelList4Page2.setVisibility(0);
                    this.binding.list4NamePage2.setVisibility(0);
                    this.binding.list4SizePage2.setVisibility(0);
                    this.binding.imageList4Page2.setVisibility(0);
                    ImageView imageView37 = this.binding.imageList4Page2;
                    byte[] bArr37 = this.pdfbyteArray;
                    imageView37.setImageBitmap(BitmapFactory.decodeByteArray(bArr37, 0, bArr37.length));
                    this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                    this.binding.list4NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list4SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j37 > 2048) {
                    this.binding.viewList4Page2.setVisibility(8);
                    this.binding.cancelList4Page2.setVisibility(8);
                    this.binding.list4NamePage2.setVisibility(8);
                    this.binding.list4SizePage2.setVisibility(8);
                    this.binding.imageList4Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j38 = j37 / 1024;
                this.filesize = j38;
                double dRound19 = Math.round(j38 * 100.0d) / 100.0d;
                if (dRound19 > 2.0d) {
                    this.binding.viewList4Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref2 = str;
                }
                this.binding.viewList4Page2.setVisibility(0);
                this.binding.cancelList4Page2.setVisibility(0);
                this.binding.list4NamePage2.setVisibility(0);
                this.binding.list4SizePage2.setVisibility(0);
                this.binding.imageList4Page2.setVisibility(0);
                ImageView imageView38 = this.binding.imageList4Page2;
                byte[] bArr38 = this.pdfbyteArray;
                imageView38.setImageBitmap(BitmapFactory.decodeByteArray(bArr38, 0, bArr38.length));
                this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                this.binding.list4NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list4SizePage2.setText(dRound19 + "MB");
                return;
            }
            if (requestCode == 208) {
                long j39 = this.filesize;
                if (j39 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list5Ref2 = str;
                    }
                    this.binding.viewList5Page2.setVisibility(0);
                    this.binding.cancelList5Page2.setVisibility(0);
                    this.binding.list5NamePage2.setVisibility(0);
                    this.binding.list5SizePage2.setVisibility(0);
                    this.binding.imageList5Page2.setVisibility(0);
                    ImageView imageView39 = this.binding.imageList5Page2;
                    byte[] bArr39 = this.pdfbyteArray;
                    imageView39.setImageBitmap(BitmapFactory.decodeByteArray(bArr39, 0, bArr39.length));
                    this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                    this.binding.list5NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j39 > 2048) {
                    this.binding.viewList5Page2.setVisibility(8);
                    this.binding.cancelList5Page2.setVisibility(8);
                    this.binding.list5NamePage2.setVisibility(8);
                    this.binding.list5SizePage2.setVisibility(8);
                    this.binding.imageList5Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j40 = j39 / 1024;
                this.filesize = j40;
                double dRound20 = Math.round(j40 * 100.0d) / 100.0d;
                if (dRound20 > 2.0d) {
                    this.binding.viewList5Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list5Ref2 = str;
                }
                this.binding.viewList5Page2.setVisibility(0);
                this.binding.cancelList5Page2.setVisibility(0);
                this.binding.list5NamePage2.setVisibility(0);
                this.binding.list5SizePage2.setVisibility(0);
                this.binding.imageList5Page2.setVisibility(0);
                ImageView imageView40 = this.binding.imageList5Page2;
                byte[] bArr40 = this.pdfbyteArray;
                imageView40.setImageBitmap(BitmapFactory.decodeByteArray(bArr40, 0, bArr40.length));
                this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                this.binding.list5NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5SizePage2.setText(dRound20 + "MB");
                return;
            }
            if (requestCode == 209) {
                long j41 = this.filesize;
                if (j41 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list6ref2 = str;
                    }
                    this.binding.viewList6Page2.setVisibility(0);
                    this.binding.cancelList6Page2.setVisibility(0);
                    this.binding.list6NamePage2.setVisibility(0);
                    this.binding.list6SizePage2.setVisibility(0);
                    this.binding.imageList6Page2.setVisibility(0);
                    ImageView imageView41 = this.binding.imageList6Page2;
                    byte[] bArr41 = this.pdfbyteArray;
                    imageView41.setImageBitmap(BitmapFactory.decodeByteArray(bArr41, 0, bArr41.length));
                    this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                    this.binding.list6NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list6SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j41 > 2048) {
                    this.binding.viewList6Page2.setVisibility(8);
                    this.binding.cancelList6Page2.setVisibility(8);
                    this.binding.list6NamePage2.setVisibility(8);
                    this.binding.list6SizePage2.setVisibility(8);
                    this.binding.imageList6Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j42 = j41 / 1024;
                this.filesize = j42;
                double dRound21 = Math.round(j42 * 100.0d) / 100.0d;
                if (dRound21 > 2.0d) {
                    this.binding.viewList6Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list6ref2 = str;
                }
                this.binding.viewList6Page2.setVisibility(0);
                this.binding.cancelList6Page2.setVisibility(0);
                this.binding.list6NamePage2.setVisibility(0);
                this.binding.list6SizePage2.setVisibility(0);
                this.binding.imageList6Page2.setVisibility(0);
                ImageView imageView42 = this.binding.imageList6Page2;
                byte[] bArr42 = this.pdfbyteArray;
                imageView42.setImageBitmap(BitmapFactory.decodeByteArray(bArr42, 0, bArr42.length));
                this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                this.binding.list6NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list6SizePage2.setText(dRound21 + "MB");
                return;
            }
            if (requestCode == 210) {
                long j43 = this.filesize;
                if (j43 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list7ref2 = str;
                    }
                    this.binding.viewList7Page2.setVisibility(0);
                    this.binding.cancelList7Page2.setVisibility(0);
                    this.binding.list7NamePage2.setVisibility(0);
                    this.binding.list7SizePage2.setVisibility(0);
                    this.binding.imageList7Page2.setVisibility(0);
                    ImageView imageView43 = this.binding.imageList7Page2;
                    byte[] bArr43 = this.pdfbyteArray;
                    imageView43.setImageBitmap(BitmapFactory.decodeByteArray(bArr43, 0, bArr43.length));
                    this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAcquiredPage2.setEnabled(false);
                    this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list7SizePage2.setText(this.filesize + "KB");
                    return;
                }
                if (j43 > 2048) {
                    this.binding.viewList7Page2.setVisibility(8);
                    this.binding.cancelList7Page2.setVisibility(8);
                    this.binding.list7NamePage2.setVisibility(8);
                    this.binding.list7SizePage2.setVisibility(8);
                    this.binding.imageList7Page2.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j44 = j43 / 1024;
                this.filesize = j44;
                double dRound22 = Math.round(j44 * 100.0d) / 100.0d;
                if (dRound22 > 2.0d) {
                    this.binding.viewList7Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list7ref2 = str;
                }
                this.binding.viewList7Page2.setVisibility(0);
                this.binding.cancelList7Page2.setVisibility(0);
                this.binding.list7NamePage2.setVisibility(0);
                this.binding.list7SizePage2.setVisibility(0);
                this.binding.imageList7Page2.setVisibility(0);
                ImageView imageView44 = this.binding.imageList7Page2;
                byte[] bArr44 = this.pdfbyteArray;
                imageView44.setImageBitmap(BitmapFactory.decodeByteArray(bArr44, 0, bArr44.length));
                this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAcquiredPage2.setEnabled(false);
                this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list7SizePage2.setText(dRound22 + "MB");
                return;
            }
            if (requestCode == 212) {
                long j45 = this.filesize;
                if (j45 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str3);
                    } else {
                        this.alertDialog.dismiss();
                        this.list5ref3 = str;
                    }
                    this.binding.viewList5Page3.setVisibility(0);
                    this.binding.cancelList5Page3.setVisibility(0);
                    this.binding.list5NamePage3.setVisibility(0);
                    this.binding.list5SizePage3.setVisibility(0);
                    this.binding.imageList5Page3.setVisibility(0);
                    ImageView imageView45 = this.binding.imageList5Page3;
                    byte[] bArr45 = this.pdfbyteArray;
                    imageView45.setImageBitmap(BitmapFactory.decodeByteArray(bArr45, 0, bArr45.length));
                    this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                    this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5SizePage3.setText(this.filesize + "KB");
                    return;
                }
                if (j45 > 2048) {
                    this.binding.viewList5Page3.setVisibility(8);
                    this.binding.cancelList5Page3.setVisibility(8);
                    this.binding.list5NamePage3.setVisibility(8);
                    this.binding.list5SizePage3.setVisibility(8);
                    this.binding.imageList5Page3.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j46 = j45 / 1024;
                this.filesize = j46;
                double dRound23 = Math.round(j46 * 100.0d) / 100.0d;
                if (dRound23 > 2.0d) {
                    this.binding.viewList5Page3.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str3);
                } else {
                    this.alertDialog.dismiss();
                    this.list5ref3 = str;
                }
                this.binding.viewList5Page3.setVisibility(0);
                this.binding.cancelList5Page3.setVisibility(0);
                this.binding.list5NamePage3.setVisibility(0);
                this.binding.list5SizePage3.setVisibility(0);
                this.binding.imageList5Page3.setVisibility(0);
                ImageView imageView46 = this.binding.imageList5Page3;
                byte[] bArr46 = this.pdfbyteArray;
                imageView46.setImageBitmap(BitmapFactory.decodeByteArray(bArr46, 0, bArr46.length));
                this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5SizePage3.setText(dRound23 + "MB");
            }
        } catch (Exception e2) {
            Logger.d("", e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setDataOffline(String list) {
        for (ListData listData : this.sirDatabaseHelper.ListDataDao().getList(list)) {
            if (list.equalsIgnoreCase(this.list1)) {
                this.List1docCode.add(listData.docCode);
                this.List1docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list2)) {
                this.List2docCode.add(listData.docCode);
                this.List2docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list3)) {
                this.List3docCode.add(listData.docCode);
                this.List3docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list4)) {
                this.List4docCode.add(listData.docCode);
                this.List4docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list5)) {
                this.List5docCode.add(listData.docCode);
                this.List5docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list6)) {
                this.List6docCode.add(listData.docCode);
                this.List6docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list7)) {
                this.List7docCode.add(listData.docCode);
                this.List7docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list8)) {
                this.List8docCode.add(listData.docCode);
                this.List8docName.add(listData.docName);
            }
        }
        if (list.equalsIgnoreCase(this.list1)) {
            if (!this.List1docName.contains(this.selectDocumentType)) {
                this.List1docName.add(0, this.selectDocumentType);
                this.List1docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List1docName);
            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
            this.binding.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
            this.binding.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
            return;
        }
        if (list.equalsIgnoreCase(this.list3)) {
            if (!this.List3docName.contains(this.selectDocumentType)) {
                this.List3docName.add(0, this.selectDocumentType);
                this.List3docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List3docName);
            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
            this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
            return;
        }
        if (list.equalsIgnoreCase(this.list4)) {
            if (!this.List4docName.contains(this.selectDocumentType)) {
                this.List4docName.add(0, this.selectDocumentType);
                this.List4docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List4docName);
            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter3);
            this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
            return;
        }
        if (list.equalsIgnoreCase(this.list5)) {
            if (!this.List5docName.contains(this.selectDocumentType)) {
                this.List5docName.add(0, this.selectDocumentType);
                this.List5docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List5docName);
            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter4);
            return;
        }
        if (list.equalsIgnoreCase(this.list6)) {
            if (!this.List6docName.contains(this.selectDocumentType)) {
                this.List6docName.add(0, this.selectDocumentType);
                this.List6docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List6docName);
            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter5);
            return;
        }
        if (list.equalsIgnoreCase(this.list7)) {
            if (!this.List7docName.contains(this.selectDocumentType)) {
                this.List7docName.add(0, this.selectDocumentType);
                this.List7docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List7docName);
            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter6);
            return;
        }
        if (list.equalsIgnoreCase(this.list8)) {
            if (!this.List8docName.contains(this.selectDocumentType)) {
                this.List8docName.add(0, this.selectDocumentType);
                this.List8docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List8docName);
            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter7);
        }
    }

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.24
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    SpecialRevisionDocuments.this.ACNameList.clear();
                    SpecialRevisionDocuments.this.ACList.clear();
                    SpecialRevisionDocuments.this.ACNameList.add(SpecialRevisionDocuments.this.getString(R.string.select_assembly_constituency));
                    SpecialRevisionDocuments.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = SpecialRevisionDocuments.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        SpecialRevisionDocuments.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        SpecialRevisionDocuments.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = SpecialRevisionDocuments.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        SpecialRevisionDocuments.this.binding.SpinnerIROldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
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

    private void initializeSpinnerTouch() {
        this.binding.spinnerIR.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore1987Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Mother.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004NotIndian.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.32
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBornOutOfIndia.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.33
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAcquired.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SpecialRevisionDocuments.34
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpecialRevisionDocuments.this.isUserSelected = true;
                return false;
            }
        });
    }
}
