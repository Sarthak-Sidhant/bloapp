package in.gov.eci.bloapp.views.fragments.checklist.form6;

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
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentForm6Binding;
import in.gov.eci.bloapp.model.check_list_form_6.AnnexureModel;
import in.gov.eci.bloapp.model.check_list_form_6.CheckListForm6Model;
import in.gov.eci.bloapp.model.check_list_form_6.CheckListForm6OrignalDataModel;
import in.gov.eci.bloapp.model.check_list_form_6.SectionNumberModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.CheckDSEDetailsListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckDSEDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckDSESDetailsRoot;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import in.gov.eci.bloapp.views.fragments.checklist.CheckListMain;
import in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.ToIntFunction;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Form6 extends Hilt_Form6 implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ALERT = "ALERT";
    private static final String SESSION = "Session Expired. Please Login again.";
    private static final String TAG = "CheckListForm6Activity";
    Date DoB;
    String after2004docURLFather;
    String after2004docURLMother;
    String after2004doctypeFather;
    String after2004doctypeMother;
    AlertDialog alertDialog;
    AnnexureModel annexureModel;
    String asmblyNO;
    String atkbnd;
    private BloFragmentForm6Binding binding;
    Bitmap bitmapAddressProofImage;
    Bitmap bitmapAgeProofImage;
    Bitmap bitmapDeclarationFormImage;
    Bitmap bitmapDisabilityImage;
    Bitmap bitmapPersonImage;
    String bornOutofIndiadocURL;
    String bornOutofIndiadoctype;
    CheckListForm6Model checkListForm6Model;
    CheckListForm6OrignalDataModel checkListForm6OrignalDataModel;
    String choice;
    String citizenAquuireddocURL;
    String citizenAquuireddoctype;
    String citizenshipTypeCat;
    String ctDocOfFatherUrl;
    String ctDocOfMotherUrl;
    String ctDocOfSelfUrl;
    String ctDocTypeForFather;
    String ctDocTypeForMother;
    String ctDocTypeForSelf;
    Date dateAfter;
    Date dateBefore;
    String districtName;
    String docURLFather;
    String docURLMother;
    String doctypeFather;
    String doctypeMother;
    String doctypeself;
    String doctypeselfURL;
    String encodedAddressProofImage;
    String encodedAgeProofImage;
    String encodedDeclarationImage;
    String encodedDisabilityProofImage;
    int formProcessingDetailsId;
    String formSubmissionDate;
    String formType;
    String generatedReferenceNumber;
    String isExistingElector;
    String isParentsIndian;
    String lastSirYear;
    String lat;
    String list1;
    String list1Code;
    String list1CodeName;
    String list2;
    String list2code;
    String list2codeName;
    String list3code;
    String list3codeName;
    String list4code;
    String list4codeName;
    String list5code;
    String list5codeName;
    String list6;
    String list6code;
    String list6codeName;
    String list7;
    String list7code;
    String list7codeName;
    String list8code;
    String list8codeName;
    private LocationRequest locationRequest;
    String longi;
    String partLang;
    String partLang2;
    String partNo;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
    int processMasterId;
    String prvsEpic;
    String referenceNo;
    String relationcode;
    String rtkbnd;
    SectionNumberModel.Root sectionModel;
    CheckDSEDetailsPayload selectedDataItem;
    String selectedType;
    String stateCode;
    String stateName;
    String tempDOB;
    String token;
    private final CommomUtility commonUtilClass = new CommomUtility();
    String upload = "Please upload file again.";
    int list5count3 = 0;
    String enIn = "en_in";
    String dse_undertaking = null;
    String empty = "";
    String errorApi = "Error From Api";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String channelidobo = "BLOAPP";
    int selectionSelectedPosition = 0;
    String emailString = "email";
    String objectStorage = "objectstorage";
    String mobileNumberString = "mobileNumber";
    CommomUtility commomUtility = new CommomUtility();
    String fieldName = " ) should be in regional language.";
    String selectedButton = "";
    String mSTATECODE = "";
    String mDISTRICTCODE = "";
    String getToken = "Token ---> ";
    String bloApp = "BLOAPP";
    Boolean isCheckDSE = false;
    String errorResponse = "";
    String disabilityType = "";
    int formProcessingId = 0;
    int currentStatusId = 0;
    int workflowConfigId = 0;
    boolean isSelectedDSE = false;
    String checkListForm6OriginalDataModelBundle = "checkListForm6OrignalDataModel";
    String checkListForm6ModelBundle = "CheckListForm6Model";
    String codeDesc = "codeDesc";
    String objectStorageString = "objectstorage";
    String form6Error = "Form 6 Error ";
    String exception = "Exception --> ";
    String sectionNo = "sectionNo";
    String imageError = "imageError";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String refreshToken = "";
    String selectSectionNumber = "Select Section Number";
    String comingInOnFailure = "coming in onFailure ";
    String jpeg = ".jpeg";
    String jpg = ".jpg";
    String jfif = ".jfif";
    String png = ".png";
    String message = "message";
    String nothingToDo = "Nothing to do";
    String anyOtherDocument = "Any other document";
    String relative = "Relative";
    String selectedTypeBundle = "selectedType";
    String statusText = "Status";
    String exceptionText = "Exception ";
    String noDocumentAttached = "No document attached";
    Gson gson = new GsonBuilder().setLenient().create();
    ArrayList<String> relationList = new ArrayList<>();
    ArrayList<String> relationListCode = new ArrayList<>();
    ArrayList<String> addressPoofList = new ArrayList<>();
    ArrayList<String> addressPoofListCode = new ArrayList<>();
    ArrayList<String> ageProofList = new ArrayList<>();
    ArrayList<String> ageProofListCode = new ArrayList<>();
    ArrayList<String> sectionNameAndNumber = new ArrayList<>();
    Set<SectionNumberModel.Root> sectionModelArrayList = new HashSet();
    private String addref = "";
    String list3Ref2 = null;
    String list4Ref2 = null;
    String list5Ref2 = null;
    String list6ref2 = null;
    String list7ref2 = null;
    String list5ref3 = null;
    String list2Ref2 = null;
    String IRStr2 = "Intensive Revision 2";
    String IRRef = null;
    String IRRef2 = null;
    String preSignedurl1 = "";
    File file1 = null;
    String messageString = "message";
    String comingTag = "coming in onFailure";
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
    String pdf3 = "PDF size exceeded 3MB limit.";
    String before1987Str = "Before 1987 self";
    String before2004Str = "Before 2004 Self";
    String list2Str = "Before 2004 Father or Mother";
    String list3Str = "After 2004 Father";
    String after2004Str = "After 2004 Self";
    String list4Str = "After 2004 Mother";
    String list5Str = "Not Indian Parent";
    String list6Str = "Born out of India";
    String list7Str = "Acquired Indian Citizenship";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String greycolor = "#99000000";
    List<CheckDSEDetailsPayload> verifyPayloads = new ArrayList();
    String img = "image";
    String cat = "";
    String list3 = "LIST-3";
    String list4 = "LIST-4";
    String list5 = "LIST-5";
    SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    String flagcat4scenerio1 = "";
    String flagcat4scenerio2 = "";
    String flagcat4scenerio3 = "";
    String flagcat3scenerio1 = "";
    String flagcat3scenerio2 = "";
    private String motherNationality = "Indian";
    private String fatherNationality = "Indian";
    String anxDSign = "BLO Sign";
    String list3Ref = null;
    String list4Ref = null;
    String list5Ref = null;
    String list6ref = null;
    String list7ref = null;
    String anxDSignUrl = null;
    String flagYes = "N";
    String FlagNo = "N";
    String whitecolor = "#000000";
    String takephoto = "Take Photo";
    String choosegallery = "Choose Image from Gallery";
    String cancel = "Cancel";
    String choosepdf = "Choose PDF from Gallery";
    String chooseFile = "Choose File";
    String applicationpdf = "application/pdf";
    String imgmsg = "Can't obtain file name, cursor is empty";
    String selectDocumentType = "Please Select Document Type";
    String list1ref = null;
    String list1ref2 = null;
    String list2Ref = null;
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
    String uncollectableSir = null;
    boolean isUserSelected = false;
    String base64element1 = "";
    String base64element2 = "";
    String base64element3 = "";
    String base64element4 = "";
    int visitCountId = 0;
    ActivityResultLauncher<Intent> activityResultLauncher4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.1
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.after2004Str, 105);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.2
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list3Str, 106);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.3
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list4Str, 107);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher7 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.4
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list5Str, 108);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher8 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.5
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list6Str, 109);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher9 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.6
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list7Str, 110);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher10 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.7
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list4Str, 111);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher11 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.8
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.before1987Str, 112);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher12 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.9
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.before2004Str, 113);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher13 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.10
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.list3Str, 114);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher14 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.11
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6 form6 = Form6.this;
                form6.HandlePdfFile(data, form6.anxDSign, 115);
            }
        }
    });
    private String actionDate = "";
    private String fieldPertainingPolling = "";
    private String fieldDeclarationForm = "Y";
    private String fieldVerificationPhoto = "Y";
    private String fieldVerificationDobOrAge = "Y";
    private String fieldVerificationAddress = "Y";
    private String fieldCategoryDisability = "Y";
    private String fieldFamilyDetails = "Y";
    private String fieldVerificationVerifiedAndCorrect = "";
    String doctypeselfFileName = "";
    String doctypeselFileSize = "";
    String before2004docFileName = "";
    String before2004docFileSize = "";
    String after2004FatherFileName = "";
    String after2004FatherFileSize = "";
    String after2004MotherFileName = "";
    String after2004MotherFileSize = "";
    String bornOutofIndiaFileName = "";
    String bornOutofIndiaFileSize = "";
    String citizenAquuiredFileName = "";
    String citizenAquuiredFileSize = "";
    String anexSignFileName = "";
    String anexSignFileSize = "";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentForm6Binding.inflate(getLayoutInflater());
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.12
            public void handleOnBackPressed() {
            }
        };
        try {
            this.dateBefore = this.simple.parse("01/07/1987");
            this.dateAfter = this.simple.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d("H2HDetails", e.toString());
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), onBackPressedCallback);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partLang2 = SharedPref.getInstance(requireContext()).getPartNumberLanguageName2();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.atkbnd = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkbnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.lastSirYear = SharedPref.getInstance(requireContext()).getlastSIRYear();
        this.binding.textView33.setText(getResources().getString(R.string.blo_form_type) + "  v" + new CommomUtility().appversion);
        String str = this.partLang;
        if (str == null || str.trim().isEmpty()) {
            this.partLang = this.enIn;
        }
        String str2 = this.partLang2;
        if (str2 == null || str2.trim().isEmpty()) {
            this.partLang2 = this.enIn;
        }
        Logger.d(TAG, "asmblyNO " + this.asmblyNO);
        Logger.d(TAG, "partNo " + this.partNo);
        Logger.d(TAG, "token_Device_comp " + this.token);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.checkListForm6Model = (CheckListForm6Model) arguments.getSerializable(this.checkListForm6ModelBundle);
            this.checkListForm6OrignalDataModel = (CheckListForm6OrignalDataModel) arguments.getSerializable(this.checkListForm6OriginalDataModelBundle);
            if (arguments.containsKey("annexuredata")) {
                this.annexureModel = (AnnexureModel) arguments.getSerializable("annexuredata");
            } else {
                this.annexureModel = new AnnexureModel();
            }
            this.selectedButton = arguments.getString("selectedButton");
            this.referenceNo = arguments.getString("refNo");
            this.formProcessingId = arguments.getInt("formProcessingId");
            this.currentStatusId = arguments.getInt("currentStatusid");
            this.processMasterId = arguments.getInt("processMasterId");
            this.actionDate = arguments.getString("actionDate");
            Log.d(TAG, "actionDate by bundle" + this.actionDate);
            this.visitCountId = arguments.getInt("visitCount");
            Log.d(TAG, "visitCountId by bundle" + this.visitCountId);
            if (this.visitCountId > 0) {
                this.binding.totalVisitCount.setVisibility(0);
                this.binding.totalVisitCount.setText("Visit count : " + this.visitCountId);
            } else {
                this.binding.totalVisitCount.setVisibility(8);
            }
        }
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.formType = "Form 6";
        Logger.d(TAG, "formProcessingId " + this.formProcessingId);
        Logger.d(TAG, "processMasterId  " + this.processMasterId);
        Logger.d(TAG, "currentStatusId " + this.currentStatusId);
        this.binding.partDetailRg.setOnCheckedChangeListener(this);
        this.binding.personalDetailRg.setOnCheckedChangeListener(this);
        this.binding.authenticationRadiogroup.setOnCheckedChangeListener(this);
        this.binding.addressRg.setOnCheckedChangeListener(this);
        this.binding.dobRg.setOnCheckedChangeListener(this);
        this.binding.familyDetailsRg.setOnCheckedChangeListener(this);
        this.binding.disabilityDetailsRg.setOnCheckedChangeListener(this);
        this.binding.annexureDetailRg.setOnCheckedChangeListener(this);
        this.binding.declarationDetailRg.setOnCheckedChangeListener(this);
        this.mSTATECODE = this.stateCode.toUpperCase();
        this.mDISTRICTCODE = SharedPref.getInstance(requireContext()).getDistrictCode().toUpperCase().toUpperCase();
        Logger.d(TAG, "mSTATECODE " + this.mSTATECODE);
        Logger.d(TAG, "mDISTRICTCODE " + this.mDISTRICTCODE);
        this.binding.refNoTv.setText(this.referenceNo);
        this.binding.formTypeTv.setText(this.formType);
        this.formSubmissionDate = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        this.binding.verificationDateEd.setText(this.formSubmissionDate);
        this.binding.verificationDateEd.setEnabled(false);
        this.binding.noRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        initializingClicks();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        getCurrentLocation();
        if (isValideSIRState()) {
            this.binding.declarationSirIncludedLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
            this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSirYear}));
            this.binding.declarationSirIncludedLayout.prevprogenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSirYear}));
            this.binding.declarationSirIncludedLayout.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{this.lastSirYear}));
            this.binding.declarationSirIncludedLayout.llAnxureDeclaration.setVisibility(0);
            this.binding.declarationVerification.setVisibility(0);
        }
        if (this.selectedButton == null) {
            this.selectedButton = "";
        }
        if (this.selectedButton.trim().equals("Save")) {
            this.alertDialog.show();
            try {
                this.binding.form6Layout.setVisibility(0);
                this.selectionSelectedPosition = 0;
                this.binding.sectionNoName.setSelection(0);
                checkAnnexD();
                markSame();
                setTextValues();
            } catch (Exception e2) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda54
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCreateView$1();
                    }
                }, 2000L);
                Logger.d(TAG, this.exceptionText + e2.getMessage());
            }
        } else if (this.selectedButton.trim().equals("Cancel")) {
            this.alertDialog.show();
            try {
                this.binding.form6Layout.setVisibility(0);
                this.selectionSelectedPosition = 0;
                this.binding.sectionNoName.setSelection(0);
                checkAnnexD();
                markSame();
                setTextValues();
            } catch (Exception e3) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda67
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCreateView$2();
                    }
                }, 2000L);
                Logger.d(TAG, this.exceptionText + e3.getMessage());
            }
        } else {
            this.alertDialog.show();
            this.selectionSelectedPosition = 0;
            this.binding.sectionNoName.setSelection(0);
            if (this.formProcessingId == 0) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), this.form6Error, "Form Processing Id can't be zero", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda79
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onCreateView$3(dialogInterface, i);
                    }
                });
            } else if (this.processMasterId == 0) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), this.form6Error, "Form Master Id can't be zero", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda82
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onCreateView$4(dialogInterface, i);
                    }
                });
            } else if (this.currentStatusId == 0) {
                this.commomUtility.showMessageWithTitleOK(requireContext(), this.form6Error, "Form Current Status Id can't be zero", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda83
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onCreateView$5(dialogInterface, i);
                    }
                });
            } else {
                fetchDataFromForm6Api();
            }
        }
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.13
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    Form6.this.relationcode = null;
                } else {
                    Form6 form6 = Form6.this;
                    form6.relationcode = form6.relationCodeList.get(i);
                }
            }
        });
        initializeSpinnerTouch();
        this.binding.annexureDIncludedLayout.imageList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda84
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$6(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda86
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$8(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda87
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$10(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$11(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$12(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageSign.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$13(view);
            }
        });
        this.binding.annexureDIncludedLayout.imageList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$14(view);
            }
        });
        this.binding.partDetailRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.14
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Form6.this.binding.noRb.isChecked()) {
                    Form6.this.fieldPertainingPolling = "N";
                    Form6.this.binding.personalDetailRg.setEnabled(false);
                    Form6.this.binding.sameRb.setEnabled(false);
                    Form6.this.binding.otherRb.setEnabled(false);
                    Form6.this.binding.sameRadiobutton.setEnabled(false);
                    Form6.this.binding.otherRadiobutton.setEnabled(false);
                    Form6.this.binding.sameDobRb.setEnabled(false);
                    Form6.this.binding.otherDobRb.setEnabled(false);
                    Form6.this.binding.addressRbSame.setEnabled(false);
                    Form6.this.binding.addressRbNotSame.setEnabled(false);
                    Form6.this.binding.disabilityDetailsSameRb.setEnabled(false);
                    Form6.this.binding.disabilityDetailsOtherRb.setEnabled(false);
                    Form6.this.binding.familyDetailsSameRb.setEnabled(false);
                    Form6.this.binding.familyDetailsOtherRb.setEnabled(false);
                    Form6.this.binding.availableRb.setEnabled(false);
                    Form6.this.binding.absentRb.setEnabled(false);
                    Form6.this.binding.shiftedRb.setEnabled(false);
                    Form6.this.binding.deadRb.setEnabled(false);
                    Form6.this.binding.nosuchpersonRb.setEnabled(false);
                    Form6.this.binding.correctDetailsRb.setEnabled(false);
                    Form6.this.binding.detailsNotCorrectRb.setEnabled(false);
                    Form6.this.binding.annexureVerification.setVisibility(8);
                    Form6.this.binding.formRmark.setEnabled(false);
                    Form6.this.binding.remark.setEnabled(false);
                    Form6.this.binding.remark.setText("");
                    Form6.this.binding.declarationVerification.setEnabled(false);
                    Form6.this.binding.declarationSameRb.setEnabled(false);
                    Form6.this.binding.declarationOtherRb.setEnabled(false);
                    Form6.this.binding.yesInfoRb.setEnabled(false);
                    Form6.this.binding.noInfoRb.setEnabled(false);
                    Form6.this.binding.infoRg.setEnabled(false);
                    Form6.this.binding.remark.setFocusable(false);
                    Form6.this.binding.declarationSirIncludedLayout.decFormSignImage.setClickable(false);
                }
                if (Form6.this.binding.yesRb.isChecked()) {
                    Form6.this.fieldPertainingPolling = "Y";
                    Form6.this.binding.personalDetailRg.setEnabled(true);
                    Form6.this.binding.sameRb.setEnabled(true);
                    Form6.this.binding.otherRb.setEnabled(true);
                    Form6.this.binding.sameRadiobutton.setEnabled(true);
                    Form6.this.binding.otherRadiobutton.setEnabled(true);
                    Form6.this.binding.yesInfoRb.setEnabled(true);
                    Form6.this.binding.noInfoRb.setEnabled(true);
                    Form6.this.binding.infoRg.setEnabled(true);
                    Form6.this.binding.sameDobRb.setEnabled(true);
                    Form6.this.binding.otherDobRb.setEnabled(true);
                    Form6.this.binding.addressRbSame.setEnabled(true);
                    Form6.this.binding.addressRbNotSame.setEnabled(true);
                    Form6.this.binding.disabilityDetailsSameRb.setEnabled(true);
                    Form6.this.binding.disabilityDetailsOtherRb.setEnabled(true);
                    Form6.this.binding.familyDetailsSameRb.setEnabled(true);
                    Form6.this.binding.familyDetailsOtherRb.setEnabled(true);
                    Form6.this.binding.availableRb.setEnabled(true);
                    Form6.this.binding.absentRb.setEnabled(true);
                    Form6.this.binding.shiftedRb.setEnabled(true);
                    Form6.this.binding.deadRb.setEnabled(true);
                    Form6.this.binding.remark.setEnabled(true);
                    Form6.this.binding.nosuchpersonRb.setEnabled(true);
                    Form6.this.binding.correctDetailsRb.setEnabled(true);
                    Form6.this.binding.detailsNotCorrectRb.setEnabled(true);
                    Form6.this.binding.formRmark.setEnabled(true);
                    Form6.this.binding.declarationVerification.setEnabled(true);
                    Form6.this.binding.declarationSameRb.setEnabled(true);
                    Form6.this.binding.declarationOtherRb.setEnabled(true);
                }
            }
        });
        this.binding.infoRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.15
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Form6.this.binding.yesInfoRb.isChecked()) {
                    Form6.this.binding.applicantFoundRg.setVisibility(0);
                    Form6.this.binding.availableRb.setVisibility(0);
                    Form6.this.binding.deadRb.setVisibility(8);
                    Form6.this.binding.absentRb.setVisibility(8);
                    Form6.this.binding.shiftedRb.setVisibility(8);
                    Form6.this.binding.nosuchpersonRb.setVisibility(8);
                }
                if (Form6.this.binding.noInfoRb.isChecked()) {
                    Form6.this.binding.applicantFoundRg.setVisibility(0);
                    Form6.this.binding.availableRb.setVisibility(8);
                    Form6.this.binding.deadRb.setVisibility(0);
                    Form6.this.binding.absentRb.setVisibility(0);
                    Form6.this.binding.shiftedRb.setVisibility(0);
                    Form6.this.binding.nosuchpersonRb.setVisibility(0);
                }
            }
        });
        this.binding.detailsCorrectRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.16
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Form6.this.binding.correctDetailsRb.isChecked()) {
                    Form6.this.fieldVerificationVerifiedAndCorrect = "Y";
                    Form6.this.binding.remarkNo.setVisibility(8);
                    Form6.this.binding.noremark.setText("");
                    Form6.this.checkRemarkVisibility();
                }
                if (Form6.this.binding.detailsNotCorrectRb.isChecked()) {
                    Form6.this.fieldVerificationVerifiedAndCorrect = "N";
                    Form6.this.binding.remarkll.setVisibility(0);
                    Form6.this.binding.remarkNo.setVisibility(0);
                    Form6.this.binding.remark.setText(Constants.FOUND_INCORRECT);
                    Form6.this.binding.remark.setEnabled(false);
                }
            }
        });
        this.binding.annexureDIncludedLayout.radioGroupAnnexure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.17
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (Form6.this.binding.annexureDIncludedLayout.formAnnxBornIndia.isChecked()) {
                    Form6 form6 = Form6.this;
                    form6.choice = form6.binding.annexureDIncludedLayout.formAnnxBornIndia.getText().toString();
                    Form6.this.annexureModel.setChoice(Form6.this.choice);
                    Form6 form7 = Form6.this;
                    form7.openBornInIndiaLayout(form7.tempDOB);
                    return;
                }
                if (Form6.this.binding.annexureDIncludedLayout.formAnnxNotBorn.isChecked()) {
                    Form6 form8 = Form6.this;
                    form8.choice = form8.binding.annexureDIncludedLayout.formAnnxNotBorn.getText().toString();
                    Form6.this.annexureModel.setChoice(Form6.this.choice);
                    Form6.this.openLayoutForNotBornInIndia();
                    return;
                }
                if (Form6.this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.isChecked()) {
                    Form6 form9 = Form6.this;
                    form9.choice = form9.binding.annexureDIncludedLayout.formAnnxIndiaCitize.getText().toString();
                    Form6.this.annexureModel.setChoice(Form6.this.choice);
                    Form6.this.openLayoutForIndiaCitizen();
                }
            }
        });
        this.binding.annexureDIncludedLayout.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$15(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentNoRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$16(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$17(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$18(view);
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.18
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List1docName.size()) {
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(112);
                    }
                    Form6.this.isUserSelected = false;
                    Form6 form6 = Form6.this;
                    form6.list1Code = form6.List1docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list1CodeName = form7.List1docName.get(i);
                    Form6.this.annexureModel.setList1Code(Form6.this.list1Code);
                    Form6.this.annexureModel.setList1CodeName(Form6.this.list1CodeName);
                    Logger.d("list1Code", Form6.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.19
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                Log.e("error@spinnerBefore2004Father", "spinnerBefore2004Self");
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List1docName.size()) {
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(113);
                    }
                    Form6.this.isUserSelected = false;
                    Form6 form6 = Form6.this;
                    form6.list1Code = form6.List1docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list1CodeName = form7.List1docName.get(i);
                    Form6.this.annexureModel.setList1Code(Form6.this.list1Code);
                    Form6.this.annexureModel.setList1CodeName(Form6.this.list1CodeName);
                    Logger.d("list1Code", Form6.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.20
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List1docName.size()) {
                    Form6 form6 = Form6.this;
                    form6.list1Code = form6.List1docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list1CodeName = form7.List1docName.get(i);
                    Form6.this.annexureModel.setList1Code(Form6.this.list1Code);
                    Form6.this.annexureModel.setList1CodeName(Form6.this.list1CodeName);
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(105);
                    }
                    Form6.this.isUserSelected = false;
                    Logger.d("list1Code", Form6.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.21
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("error@spinnerBefore2004Father", "spinnerBefore2004Father");
                if (i == 0) {
                    return;
                }
                if (Form6.this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    }
                    Form6 form6 = Form6.this;
                    form6.list3code = form6.List3docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list3codeName = form7.List3docName.get(i);
                    Form6.this.annexureModel.setList3code(Form6.this.list3code);
                    Form6.this.annexureModel.setList3codeName(Form6.this.list3codeName);
                    Logger.d("list3code", Form6.this.list3code);
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(114);
                    }
                    Form6.this.isUserSelected = false;
                    return;
                }
                if (Form6.this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                    Form6.this.deletePhoto(111);
                    Form6 form8 = Form6.this;
                    form8.list4code = form8.List4docCode.get(i);
                    Form6 form9 = Form6.this;
                    form9.list4codeName = form9.List4docName.get(i);
                    Form6.this.annexureModel.setList4code(Form6.this.list4code);
                    Form6.this.annexureModel.setList4codeName(Form6.this.list4codeName);
                    Logger.d("list4code", Form6.this.list4code);
                    if (i == 1) {
                        Form6.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.22
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                Form6 form6 = Form6.this;
                form6.list3code = form6.List3docCode.get(i);
                Form6 form7 = Form6.this;
                form7.list3codeName = form7.List3docName.get(i);
                Form6.this.annexureModel.setList3code(Form6.this.list3code);
                Form6.this.annexureModel.setList3codeName(Form6.this.list3codeName);
                if (Form6.this.isUserSelected) {
                    Form6.this.deletePhoto(106);
                }
                Form6.this.isUserSelected = false;
                if (Form6.this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                        return;
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                        return;
                    }
                }
                if (Form6.this.flagcat4scenerio1.equalsIgnoreCase("N") && Form6.this.binding.annexureDIncludedLayout.parentFatherRb.isChecked()) {
                    if (i == 1) {
                        Form6.this.flagYes = "Y";
                        Form6.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.23
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                Form6 form6 = Form6.this;
                form6.list4code = form6.List4docCode.get(i);
                Form6 form7 = Form6.this;
                form7.list4codeName = form7.List4docName.get(i);
                Form6.this.annexureModel.setList4code(Form6.this.list4code);
                Form6.this.annexureModel.setList4codeName(Form6.this.list4codeName);
                if (Form6.this.isUserSelected) {
                    Form6.this.deletePhoto(107);
                }
                Form6.this.isUserSelected = false;
                if (Form6.this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                        return;
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                        return;
                    }
                }
                if (Form6.this.flagcat4scenerio1.equalsIgnoreCase("N") && Form6.this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6.this.flagYes = "Y";
                        Form6.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                    } else {
                        Form6.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.24
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List5docName.size()) {
                    Form6 form6 = Form6.this;
                    form6.list5code = form6.List5docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list5codeName = form7.List5docName.get(i);
                    Form6.this.annexureModel.setList5code(Form6.this.list5code);
                    Form6.this.annexureModel.setList5codeName(Form6.this.list5codeName);
                    Logger.d("list5code", Form6.this.list5code);
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(108);
                    }
                    Form6.this.isUserSelected = false;
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.25
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List6docName.size()) {
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(109);
                    }
                    Form6.this.isUserSelected = false;
                    Form6 form6 = Form6.this;
                    form6.list6code = form6.List6docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list6codeName = form7.List6docName.get(i);
                    Form6.this.annexureModel.setList6code(Form6.this.list6code);
                    Form6.this.annexureModel.setList6codeName(Form6.this.list6codeName);
                    Logger.d("list6code", Form6.this.list6code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAcquired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.26
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6.this.List7docName.size()) {
                    if (Form6.this.isUserSelected) {
                        Form6.this.deletePhoto(110);
                    }
                    Form6.this.isUserSelected = false;
                    Form6 form6 = Form6.this;
                    form6.list7code = form6.List7docCode.get(i);
                    Form6 form7 = Form6.this;
                    form7.list7codeName = form7.List7docName.get(i);
                    Form6.this.annexureModel.setList7code(Form6.this.list7code);
                    Form6.this.annexureModel.setList7codeName(Form6.this.list7codeName);
                    Logger.d("list7code", Form6.this.list7code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$19(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$20(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$21(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$22(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda59
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$23(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$24(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$25(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$26(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$27(view);
            }
        });
        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda64
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$28(view);
            }
        });
        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$29(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$30(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda69
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$31(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$32(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda71
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$33(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$34(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$35(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda74
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$36(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$37(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda76
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$38(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda78
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$39(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileSign.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$40(view);
            }
        });
        this.binding.annexureDIncludedLayout.signDeleteList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6.this.deletePhoto(115);
            }
        });
        this.binding.checkDseButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda81
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$41(view);
            }
        });
        arguments.putString("selectedButton", "");
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        this.binding.personalDetailRg.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(DialogInterface dialogInterface, int i) {
        openFragment(new CheckListMain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(DialogInterface dialogInterface, int i) {
        openFragment(new CheckListMain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(DialogInterface dialogInterface, int i) {
        openFragment(new CheckListMain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(View view) {
        String str;
        if (this.ctDocOfSelfUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.ctDocOfSelfUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfSelfUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        String str;
        if (this.ctDocOfSelfUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.ctDocOfSelfUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfSelfUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(View view) {
        String str;
        if (this.ctDocOfSelfUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.ctDocOfSelfUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfSelfUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.ctDocOfFatherUrl)) {
            if (this.ctDocOfFatherUrl.endsWith(".pdf")) {
                try {
                    showPersonPdfDialog(this.base64element2, this.ctDocOfFatherUrl);
                    return;
                } catch (IOException e) {
                    Log.d("Exception in displaying pdf= ", e.getMessage());
                    return;
                }
            }
            String str3 = this.base64element2;
            if (str3 != null && !str3.isEmpty() && !this.base64element2.equals("null") && (str2 = this.base64element2) != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfFatherUrl);
                return;
            } else {
                showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
                return;
            }
        }
        if (TextUtils.isEmpty(this.ctDocOfMotherUrl)) {
            return;
        }
        if (this.ctDocOfMotherUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element3, this.ctDocOfMotherUrl);
                return;
            } catch (IOException e2) {
                Log.d("Exception in displaying pdf= ", e2.getMessage());
                return;
            }
        }
        String str4 = this.base64element3;
        if (str4 != null && !str4.isEmpty() && !this.base64element3.equals("null") && (str = this.base64element3) != null) {
            byte[] bArrDecode2 = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode2, 0, bArrDecode2.length), this.ctDocOfMotherUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(View view) {
        String str;
        if (TextUtils.isEmpty(this.ctDocOfFatherUrl)) {
            return;
        }
        if (this.ctDocOfFatherUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element2, this.ctDocOfFatherUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element2;
        if (str2 != null && !str2.isEmpty() && !this.base64element2.equals("null") && (str = this.base64element2) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfFatherUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(View view) {
        String str;
        if (this.ctDocOfSelfUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.ctDocOfSelfUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfSelfUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$12(View view) {
        String str;
        if (this.ctDocOfSelfUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.ctDocOfSelfUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfSelfUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(View view) {
        String str;
        if (this.anxDSignUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element4, this.anxDSignUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element4;
        if (str2 != null && !str2.isEmpty() && !this.base64element4.equals("null") && (str = this.base64element4) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.anxDSignUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(View view) {
        String str;
        if (TextUtils.isEmpty(this.ctDocOfMotherUrl)) {
            return;
        }
        if (this.ctDocOfMotherUrl.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element3, this.ctDocOfMotherUrl);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element3;
        if (str2 != null && !str2.isEmpty() && !this.base64element3.equals("null") && (str = this.base64element3) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.ctDocOfMotherUrl);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(View view) {
        this.List3docName.clear();
        this.List4docName.clear();
        this.List3docCode.clear();
        this.List4docCode.clear();
        this.flagcat4scenerio1 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        this.annexureModel.setFlagcat4scenerio1("Y");
        this.annexureModel.setFatherNationality(this.fatherNationality);
        this.annexureModel.setMotherNationality(this.motherNationality);
        getList1(this.list3);
        getList1(this.list4);
        this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$16(View view) {
        this.flagcat4scenerio1 = "N";
        this.annexureModel.setFlagcat4scenerio1("N");
        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$17(View view) {
        this.List3docName.clear();
        this.List5docName.clear();
        this.List3docCode.clear();
        this.List5docCode.clear();
        this.flagcat4scenerio2 = "Y";
        this.flagcat4scenerio3 = "N";
        this.motherNationality = "Non-Indian";
        this.fatherNationality = "Indian";
        this.annexureModel.setFlagcat4scenerio2("Y");
        this.annexureModel.setFlagcat4scenerio3(this.flagcat4scenerio3);
        this.annexureModel.setFatherNationality(this.fatherNationality);
        this.annexureModel.setMotherNationality(this.motherNationality);
        getList1(this.list3);
        getList1(this.list5);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.indianParentTv2.setText(getString(R.string.father_sr));
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.mother_sr);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$18(View view) {
        this.List4docName.clear();
        this.List5docName.clear();
        this.List4docCode.clear();
        this.List5docCode.clear();
        this.flagcat4scenerio3 = "Y";
        this.flagcat4scenerio2 = "N";
        this.motherNationality = "Indian";
        this.fatherNationality = "Non-Indian";
        this.annexureModel.setFlagcat4scenerio2("N");
        this.annexureModel.setFlagcat4scenerio3(this.flagcat4scenerio3);
        this.annexureModel.setFatherNationality(this.fatherNationality);
        this.annexureModel.setMotherNationality(this.motherNationality);
        getList1(this.list4);
        getList1(this.list5);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.indianParentTv2.setText(R.string.mother_sr);
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.father_sr);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$19(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.after2004count = 0;
            pickFile(105, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$20(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.before1987count = 0;
            pickFile(112, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$21(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.before2004count = 0;
            pickFile(113, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$22(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
            return;
        }
        this.list2count = 0;
        if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
            pickFile(114, this.list3code);
        } else if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
            pickFile(111, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$23(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.list3count = 0;
            pickFile(106, this.list3code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$24(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.list4coumt = 0;
            pickFile(107, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$25(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.list5count = 0;
            pickFile(108, this.list5code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$26(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.list6count = 0;
            pickFile(109, this.list6code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$27(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("ALERT", this.selectDocumentType);
        } else {
            this.list7count = 0;
            pickFile(110, this.list7code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$28(View view) {
        this.List3docName.clear();
        this.List3docCode.clear();
        this.flagcat3scenerio1 = "Y";
        this.flagcat3scenerio2 = "N";
        this.annexureModel.setFlagcat3scenerio1("Y");
        this.annexureModel.setFlagcat3scenerio2(this.flagcat3scenerio2);
        getList1(this.list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$29(View view) {
        this.List4docName.clear();
        this.List4docCode.clear();
        this.flagcat3scenerio2 = "Y";
        this.flagcat3scenerio1 = "N";
        this.annexureModel.setFlagcat3scenerio1("N");
        this.annexureModel.setFlagcat3scenerio2(this.flagcat3scenerio2);
        getList1(this.list4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$30(View view) {
        this.List3docName.clear();
        this.List4docName.clear();
        this.List3docCode.clear();
        this.List4docCode.clear();
        this.flagcat4scenerio1 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        this.annexureModel.setFlagcat4scenerio1("Y");
        this.annexureModel.setFatherNationality(this.fatherNationality);
        this.annexureModel.setMotherNationality(this.motherNationality);
        getList1(this.list3);
        getList1(this.list4);
        this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$31(View view) {
        deletePhoto(112);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$32(View view) {
        deletePhoto(113);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$33(View view) {
        deletePhoto(111);
        deletePhoto(114);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$34(View view) {
        deletePhoto(105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$35(View view) {
        deletePhoto(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$36(View view) {
        deletePhoto(107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$37(View view) {
        deletePhoto(108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$38(View view) {
        deletePhoto(109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$39(View view) {
        deletePhoto(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$40(View view) {
        pickFile(115, this.anxDSign);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$41(View view) {
        this.isCheckDSE = true;
        this.selectedDataItem = null;
        callCheckDSE();
    }

    private void callCheckDSE() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtknC_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("platform-type", "ANDROIDMOB");
        map.put("Authorization", this.token);
        Log.d(TAG, map.toString());
        String str = this.checkListForm6Model.getFirstName() + " " + this.checkListForm6Model.getLastName();
        String str2 = this.checkListForm6Model.getApplicantRelativeName() + " " + this.checkListForm6Model.getApplicantRelativeSurname();
        HashMap map2 = new HashMap();
        map2.put("stateCd", this.stateCode);
        map2.put("name", str);
        map2.put("gender", this.checkListForm6Model.getApplicantGender());
        map2.put("age", Integer.valueOf(Integer.parseInt(this.checkListForm6Model.getAgeAtFormSubmission())));
        map2.put("rlnName", str2);
        map2.put("rlnType", this.checkListForm6Model.getTypeOfRelation());
        ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).checkDSEinState(map, map2).enqueue(new Callback<CheckDSESDetailsRoot>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.28
            public void onResponse(Call<CheckDSESDetailsRoot> call, Response<CheckDSESDetailsRoot> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    return;
                }
                Form6.this.verifyPayloads = ((CheckDSESDetailsRoot) response.body()).getPayload();
                if (Form6.this.verifyPayloads != null && !Form6.this.verifyPayloads.isEmpty()) {
                    Form6 form6 = Form6.this;
                    form6.getDetailByClusterId(form6.verifyPayloads);
                } else {
                    Form6.this.dse_undertaking = null;
                    Form6.this.showdialog("Alert", "No data found");
                }
            }

            public void onFailure(Call<CheckDSESDetailsRoot> call, Throwable t) {
                Logger.d(Form6.TAG, t.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDetailByClusterId(final List<CheckDSEDetailsPayload> verifyPayload) {
        final Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.check_dse_details_dialog);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        TextView textView = (TextView) dialog.findViewById(R.id.electorName_pending_sir);
        TextView textView2 = (TextView) dialog.findViewById(R.id.relativeName_pending_sir);
        TextView textView3 = (TextView) dialog.findViewById(R.id.gender);
        TextView textView4 = (TextView) dialog.findViewById(R.id.age_pending_sir);
        RecyclerView recyclerViewFindViewById = dialog.findViewById(R.id.recyclerView_cluser);
        final RadioButton radioButton = (RadioButton) dialog.findViewById(R.id.dse_undertaking_yes);
        final RadioButton radioButton2 = (RadioButton) dialog.findViewById(R.id.dse_undertaking_no);
        String fullName = TextUtils.isEmpty(verifyPayload.get(0).getFullName()) ? "" : verifyPayload.get(0).getFullName();
        String relativeFullName = TextUtils.isEmpty(verifyPayload.get(0).getRelativeFullName()) ? "" : verifyPayload.get(0).getRelativeFullName();
        textView.setText(fullName);
        textView2.setText(relativeFullName);
        if (!TextUtils.isEmpty(verifyPayload.get(0).getGender())) {
            if (verifyPayload.get(0).getGender().equalsIgnoreCase("M")) {
                textView3.setText(TextUtils.isEmpty(verifyPayload.get(0).getGender()) ? "" : "Male");
            } else if (verifyPayload.get(0).getGender().equalsIgnoreCase("F")) {
                textView3.setText(TextUtils.isEmpty(verifyPayload.get(0).getGender()) ? "" : "Female");
            } else {
                textView3.setText(TextUtils.isEmpty(verifyPayload.get(0).getGender()) ? "" : verifyPayload.get(0).getGender());
            }
        }
        textView4.setText(verifyPayload.get(0).getAge() != 0 ? String.valueOf(verifyPayload.get(0).getAge()) : "");
        recyclerViewFindViewById.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewFindViewById.setAdapter(new CheckDSEDetailsListAdapter(verifyPayload, requireContext(), new CheckDSEDetailsListAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda36
            @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.CheckDSEDetailsListAdapter.OnItemSelectedListener
            public final void onItemSelected() {
                radioButton2.setEnabled(false);
            }
        }));
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$getDetailByClusterId$43(verifyPayload, radioButton, radioButton2, dialog, view);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$getDetailByClusterId$44(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDetailByClusterId$43(List list, RadioButton radioButton, RadioButton radioButton2, Dialog dialog, View view) {
        this.dse_undertaking = "Y";
        getitemSelectedData(list);
        if (!list.isEmpty() && this.selectedDataItem == null) {
            showdialog("", "Kindly select DSE record ");
            radioButton.setChecked(false);
        } else {
            radioButton2.setVisibility(8);
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDetailByClusterId$44(Dialog dialog, View view) {
        this.dse_undertaking = "N";
        this.selectedDataItem = null;
        dialog.dismiss();
    }

    private void getitemSelectedData(List<CheckDSEDetailsPayload> verifyPayload) {
        for (CheckDSEDetailsPayload checkDSEDetailsPayload : verifyPayload) {
            if (checkDSEDetailsPayload.isSelected()) {
                this.isSelectedDSE = true;
                this.selectedDataItem = checkDSEDetailsPayload;
                return;
            }
        }
    }

    private void fetchDataFromForm6Api() {
        if (isNetworkAvailable(requireContext())) {
            fetchDataFromForm6Data();
        } else {
            Toast.makeText(getContext(), "Please check network", 1).show();
        }
    }

    private void fetchDataFromForm6Data() {
        Logger.d(TAG, "formType " + this.formType);
        Logger.d(TAG, "Reference_Number " + this.referenceNo);
        Logger.d(TAG, "stateCode " + this.stateCode);
        Logger.d(TAG, "token " + this.token);
        Logger.d(TAG, "formProcessing_Id " + this.formProcessingId);
        Logger.d(TAG, "processMasterId " + this.processMasterId);
        Logger.d(TAG, "currentStatus_Id " + this.currentStatusId);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getForm6Data(this.referenceNo, "blo", this.stateCode, "ANDROIDMOB").enqueue(new AnonymousClass29());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        AnonymousClass29() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() != 200 || Form6.this.formProcessingId == 0 || Form6.this.processMasterId == 0 || Form6.this.currentStatusId == 0) {
                if (response.code() == 401) {
                    Form6.this.refreshTokenApi();
                    return;
                }
                Log.d(Form6.TAG, "In fetchLanguageData() -> else part ----> Response Body is null .............................");
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    Form6 form6 = Form6.this;
                    form6.errorResponse = jSONObject.optString(form6.message);
                    Log.d(Form6.TAG, "In fetchLanguageData() -> AMF EMF Facility Data from API -> errorResponse : " + Form6.this.errorResponse);
                } catch (IOException | JSONException e) {
                    Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(String.valueOf(response.body()));
                Form6 form7 = Form6.this;
                form7.checkListForm6Model = (CheckListForm6Model) Objects.requireNonNull((CheckListForm6Model) form7.gson.fromJson(String.valueOf(jSONObject2), CheckListForm6Model.class));
                Form6 form8 = Form6.this;
                form8.checkListForm6OrignalDataModel = (CheckListForm6OrignalDataModel) form8.gson.fromJson(String.valueOf(jSONObject2), CheckListForm6OrignalDataModel.class);
                Form6.this.checkListForm6OrignalDataModel.setDobcopy(Form6.this.checkListForm6OrignalDataModel.getDob());
                Form6.this.checkAnnexD();
                if (Form6.this.isValideSIRState()) {
                    TextView textView = Form6.this.binding.declarationSirIncludedLayout.tabTV;
                    Form6 form9 = Form6.this;
                    textView.setText(form9.getString(R.string.elector_tab_title, new Object[]{form9.lastSirYear}));
                    RadioButton radioButton = Form6.this.binding.declarationSirIncludedLayout.prevprogenyRb;
                    Form6 form10 = Form6.this;
                    radioButton.setText(form10.getString(R.string.ef_progeny_2003_text, new Object[]{form10.lastSirYear}));
                    RadioButton radioButton2 = Form6.this.binding.declarationSirIncludedLayout.neitherRb;
                    Form6 form11 = Form6.this;
                    radioButton2.setText(form11.getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{form11.lastSirYear}));
                    Form6.this.binding.declarationSirIncludedLayout.llAnxureDeclaration.setVisibility(0);
                    Form6.this.binding.declarationVerification.setVisibility(0);
                    Form6.this.binding.declarationSirIncludedLayout.rb2003.setEnabled(false);
                    Form6.this.binding.declarationSirIncludedLayout.rb2025.setEnabled(false);
                    if ((TextUtils.isEmpty(Form6.this.checkListForm6OrignalDataModel.getIsSir03()) || !Form6.this.checkListForm6OrignalDataModel.getIsSir03().equalsIgnoreCase("Y")) && !TextUtils.isEmpty(Form6.this.checkListForm6OrignalDataModel.getIsSir2526()) && Form6.this.checkListForm6OrignalDataModel.getIsSir2526().equalsIgnoreCase("Y")) {
                        Form6.this.binding.declarationSirIncludedLayout.rb2025.setChecked(true);
                        Form6.this.binding.declarationSirIncludedLayout.lvCategoryRadio.setVisibility(0);
                        Form6.this.binding.declarationSirIncludedLayout.tabTV.setText(Form6.this.getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
                        Form6.this.binding.declarationSirIncludedLayout.prevprogenyRb.setText(Form6.this.getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
                        Form6.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(Form6.this.getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
                    } else {
                        Form6.this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
                        Form6.this.binding.declarationSirIncludedLayout.lvCategoryRadio.setVisibility(0);
                    }
                }
                UserClient userClient = (UserClient) ApiClient.getClient(Form6.this.getContext()).create(UserClient.class);
                userClient.getRelation(Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd(), Form6.this.channelidobo, "blo", Form6.this.stateCode, "ANDROIDMOB").enqueue(new AnonymousClass1(userClient));
            } catch (Exception e2) {
                Logger.d(Form6.TAG, Form6.this.exceptionText + e2.getMessage());
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JSONArray> {
            final /* synthetic */ UserClient val$userClient;

            AnonymousClass1(final UserClient val$userClient) {
                this.val$userClient = val$userClient;
            }

            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    Form6.this.relationList.add("Select Relation Type");
                    Form6.this.relationListCode.add("‡");
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = Form6.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        Form6.this.relationList.add(String.valueOf(asJsonObject.get(Form6.this.codeDesc)).substring(1, String.valueOf(asJsonObject.get(Form6.this.codeDesc)).length() - 1));
                        Form6.this.relationListCode.add(String.valueOf(asJsonObject.get("code")).substring(1, String.valueOf(asJsonObject.get("code")).length() - 1));
                    }
                    Form6.this.checkListForm6Model.setRelationList(Form6.this.relationList);
                    Form6.this.checkListForm6Model.setRelationListCode(Form6.this.relationListCode);
                    Logger.d(Form6.TAG, "RelationListAPI --- > " + Form6.this.relationList);
                    Logger.d(Form6.TAG, "RelationListCodeAPI --- > " + Form6.this.relationListCode);
                    this.val$userClient.getaddproof(Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd(), Form6.this.channelidobo, "blo", "ANDROIDMOB").enqueue(new C00391());
                    return;
                }
                if (response.code() == 401) {
                    Form6.this.refreshTokenApi();
                    return;
                }
                try {
                    Form6.this.errorResponse = new JSONObject(response.errorBody().string()).optString(Form6.this.message);
                    Log.d(Form6.TAG, Form6.this.errorResponse);
                } catch (IOException | JSONException e) {
                    Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Relation Type List - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            }

            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1, reason: invalid class name and collision with other inner class name */
            class C00391 implements Callback<JSONArray> {
                C00391() {
                }

                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        Form6.this.addressPoofList.add("Select Document");
                        Form6.this.addressPoofListCode.add("‡");
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Form6.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Form6.this.addressPoofList.add(String.valueOf(asJsonObject.get(Form6.this.codeDesc)).substring(1, String.valueOf(asJsonObject.get(Form6.this.codeDesc)).length() - 1));
                            Form6.this.addressPoofListCode.add(String.valueOf(asJsonObject.get("code")).substring(1, String.valueOf(asJsonObject.get("code")).length() - 1));
                        }
                        Form6.this.addressPoofList.add("Any Other Document");
                        Form6.this.addressPoofListCode.add("OTHR");
                        Form6.this.checkListForm6Model.setAddressPoofList(Form6.this.addressPoofList);
                        Form6.this.checkListForm6Model.setAddressPoofListCode(Form6.this.addressPoofListCode);
                        Logger.d(Form6.TAG, "AddressPoofListAPI --- > " + Form6.this.addressPoofList);
                        Logger.d(Form6.TAG, "AddressPoofListCodeAPI --- > " + Form6.this.addressPoofListCode);
                        AnonymousClass1.this.val$userClient.getageproof(Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd(), Form6.this.channelidobo, "blo", "ANDROIMOB").enqueue(new C00401());
                        return;
                    }
                    if (response.code() == 401) {
                        Form6.this.refreshTokenApi();
                        return;
                    }
                    try {
                        Form6.this.errorResponse = new JSONObject(response.errorBody().string()).optString(Form6.this.message);
                        Log.d(Form6.TAG, Form6.this.errorResponse);
                    } catch (IOException | JSONException e) {
                        Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Address Proof List - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$1(dialogInterface, i2);
                        }
                    });
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1, reason: invalid class name and collision with other inner class name */
                class C00401 implements Callback<JSONArray> {
                    C00401() {
                    }

                    public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                        if (response.code() == 200) {
                            JSONArray jSONArray = (JSONArray) response.body();
                            Form6.this.ageProofList.add("Select Document");
                            Form6.this.ageProofListCode.add("‡");
                            for (int i = 0; i < jSONArray.size(); i++) {
                                JsonObject asJsonObject = Form6.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                                Form6.this.ageProofList.add(String.valueOf(asJsonObject.get(Form6.this.codeDesc)).substring(1, String.valueOf(asJsonObject.get(Form6.this.codeDesc)).length() - 1));
                                Form6.this.ageProofListCode.add(String.valueOf(asJsonObject.get("code")).substring(1, String.valueOf(asJsonObject.get("code")).length() - 1));
                            }
                            Form6.this.ageProofList.add("Any Other Document");
                            Form6.this.ageProofListCode.add("OTHR");
                            Form6.this.checkListForm6Model.setAgeProofList(Form6.this.ageProofList);
                            Form6.this.checkListForm6Model.setAgeProofListCode(Form6.this.ageProofListCode);
                            Logger.d(Form6.TAG, "AgePoofListAPI --- > " + Form6.this.ageProofList);
                            Logger.d(Form6.TAG, "AgePoofListCodeAPI --- > " + Form6.this.ageProofListCode);
                            if (!SharedPref.getInstance(Form6.this.requireContext()).getSectionData().equals("")) {
                                Form6.this.sectionNameAndNumber.clear();
                                Form6.this.sectionNameAndNumber.add(0, String.valueOf(0));
                                try {
                                    JSONArray jSONArray2 = (JSONArray) new JSONParser().parse(SharedPref.getInstance(Form6.this.requireContext()).getSectionData());
                                    Form6.this.sectionModelArrayList.clear();
                                    for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                                        JsonObject asJsonObject2 = Form6.this.gson.toJsonTree(jSONArray2.get(i2)).getAsJsonObject();
                                        JsonElement jsonElement = asJsonObject2.get("sectionName");
                                        if (jsonElement != null && !String.valueOf(jsonElement).equals("null")) {
                                            Form6.this.sectionModel = new SectionNumberModel.Root(asJsonObject2.get(Form6.this.sectionNo).getAsInt(), asJsonObject2.get("sectionName").getAsString());
                                            Form6.this.sectionModelArrayList.add(Form6.this.sectionModel);
                                        } else {
                                            Form6.this.sectionModel = new SectionNumberModel.Root(asJsonObject2.get(Form6.this.sectionNo).getAsInt(), "");
                                            Form6.this.sectionModelArrayList.add(Form6.this.sectionModel);
                                        }
                                    }
                                    Log.d(Form6.TAG, "sectionModelArrayList ---> " + Form6.this.sectionModelArrayList);
                                    Form6.this.checkListForm6Model.setSectionNameAndNumberModel(new ArrayList<>(Form6.this.sectionModelArrayList));
                                    Form6.this.checkListForm6Model.getSectionNameAndNumberModel().sort(Comparator.comparingInt(new Form6$29$1$1$1$$ExternalSyntheticLambda0()));
                                } catch (ParseException e) {
                                    Logger.d("", e.getMessage());
                                }
                                Form6.this.sectionNameAndNumber.sort(Comparator.comparingInt(new ToIntFunction() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$$ExternalSyntheticLambda1
                                    @Override // java.util.function.ToIntFunction
                                    public final int applyAsInt(Object obj) {
                                        return Integer.parseInt(((String) obj).split("-")[0].trim());
                                    }
                                }));
                                for (int i3 = 0; i3 < Form6.this.checkListForm6Model.getSectionNameAndNumberModel().size(); i3++) {
                                    if (Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i3).getSectionName() == null || Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i3).getSectionName().equals("null")) {
                                        Form6.this.sectionNameAndNumber.add(String.valueOf(Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i3).getSectionNo()));
                                    } else {
                                        Form6.this.sectionNameAndNumber.add(Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i3).getSectionNo() + " - " + Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i3).getSectionName());
                                    }
                                }
                                Form6.this.sectionNameAndNumber.remove(0);
                                Form6.this.sectionNameAndNumber.add(0, Form6.this.selectSectionNumber);
                                Log.d(Form6.TAG, "sectionNameAndNumber ---> " + Form6.this.sectionNameAndNumber);
                                Form6.this.checkListForm6Model.setSectionNameAndNumber(Form6.this.sectionNameAndNumber);
                                Form6.this.checkListForm6Model.setPersonalDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setAuthenticationSameOrNot("Y");
                                Form6.this.checkListForm6Model.setDateOfBirthSameOrNot("Y");
                                Form6.this.checkListForm6Model.setAddressSameOrNot("Y");
                                Form6.this.checkListForm6Model.setFamilyDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setDisabilityDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setAnnexuredetsilsSameorNot("Y");
                                Form6.this.checkListForm6Model.setSetDeclarationSameOrNot("Y");
                                Form6.this.checkListForm6Model.setFormProcessingId(Form6.this.formProcessingId);
                                Form6.this.checkListForm6Model.setCurrentStatusId(Form6.this.currentStatusId);
                                Form6.this.checkListForm6Model.setProcessMasterId(Form6.this.processMasterId);
                                Form6.this.binding.form6Layout.setVisibility(0);
                                Form6.this.setTextValues();
                                return;
                            }
                            AnonymousClass1.this.val$userClient.getSectionForm6(Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd(), Form6.this.channelidobo, "blo", Form6.this.stateCode, "application/json", "ANDROIMOB", Form6.this.asmblyNO, Form6.this.partNo).enqueue(new C00411());
                            return;
                        }
                        if (response.code() == 401) {
                            Form6.this.refreshTokenApi();
                            return;
                        }
                        try {
                            Form6.this.errorResponse = new JSONObject(response.errorBody().string()).optString(Form6.this.message);
                            Log.d(Form6.TAG, Form6.this.errorResponse);
                        } catch (IOException | JSONException e2) {
                            Logger.d(Form6.TAG, Form6.this.exception + e2.getMessage());
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onResponse$1();
                            }
                        }, 2000L);
                        Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Age Proof List - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                this.f$0.lambda$onResponse$2(dialogInterface, i4);
                            }
                        });
                    }

                    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    class C00411 implements Callback<List<SectionNumberModel.Root>> {
                        C00411() {
                        }

                        public void onResponse(Call<List<SectionNumberModel.Root>> call, Response<List<SectionNumberModel.Root>> response) {
                            if (response.code() == 200) {
                                Form6.this.sectionNameAndNumber.clear();
                                Form6.this.sectionNameAndNumber.add(Form6.this.selectSectionNumber);
                                Form6.this.checkListForm6Model.getSectionNameAndNumberModel().clear();
                                Form6.this.checkListForm6Model.setSectionNameAndNumberModel((ArrayList) response.body());
                                Form6.this.checkListForm6Model.getSectionNameAndNumberModel().sort(Comparator.comparingInt(new Form6$29$1$1$1$$ExternalSyntheticLambda0()));
                                for (int i = 0; i < Form6.this.checkListForm6Model.getSectionNameAndNumberModel().size(); i++) {
                                    if (Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i).getSectionName() == null || Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i).getSectionName().equals("null")) {
                                        Form6.this.sectionNameAndNumber.add(String.valueOf(Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i).getSectionNo()));
                                    } else {
                                        Form6.this.sectionNameAndNumber.add(Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i).getSectionNo() + " - " + Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(i).getSectionName());
                                    }
                                }
                                Form6.this.checkListForm6Model.setSectionNameAndNumber(Form6.this.sectionNameAndNumber);
                                Form6.this.checkListForm6Model.setPersonalDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setAuthenticationSameOrNot("Y");
                                Form6.this.checkListForm6Model.setDateOfBirthSameOrNot("Y");
                                Form6.this.checkListForm6Model.setAddressSameOrNot("Y");
                                Form6.this.checkListForm6Model.setFamilyDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setDisabilityDetailsSameOrNot("Y");
                                Form6.this.checkListForm6Model.setSetDeclarationSameOrNot("Y");
                                Form6.this.checkListForm6Model.setFormProcessingId(Form6.this.formProcessingId);
                                Form6.this.checkListForm6Model.setCurrentStatusId(Form6.this.currentStatusId);
                                Form6.this.checkListForm6Model.setProcessMasterId(Form6.this.processMasterId);
                                Form6.this.binding.form6Layout.setVisibility(0);
                                Form6.this.setTextValues();
                                return;
                            }
                            if (response.code() == 401) {
                                Form6.this.refreshTokenApi();
                                return;
                            }
                            try {
                                Form6.this.errorResponse = new JSONObject(response.errorBody().string()).optString(Form6.this.message);
                                Log.d(Form6.TAG, Form6.this.errorResponse);
                            } catch (IOException | JSONException e) {
                                Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            }, 2000L);
                            Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Section Number - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$1$$ExternalSyntheticLambda1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$onResponse$1(dialogInterface, i2);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onResponse$0() {
                            Form6.this.alertDialog.dismiss();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
                            Form6.this.openFragment(new CheckListMain());
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onFailure$2() {
                            Form6.this.alertDialog.dismiss();
                        }

                        public void onFailure(Call<List<SectionNumberModel.Root>> call, Throwable t) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$1$$ExternalSyntheticLambda2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onFailure$2();
                                }
                            }, 2000L);
                            Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Section Number OnFailure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$1$$ExternalSyntheticLambda3
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$onFailure$3(dialogInterface, i);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onFailure$3(DialogInterface dialogInterface, int i) {
                            Form6.this.openFragment(new CheckListMain());
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$1() {
                        Form6.this.alertDialog.dismiss();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                        Form6.this.openFragment(new CheckListMain());
                    }

                    public void onFailure(Call<JSONArray> call, Throwable t) {
                        Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onFailure$3();
                            }
                        }, 2000L);
                        Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Age Proof List OnFailure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$1$$ExternalSyntheticLambda5
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onFailure$4(dialogInterface, i);
                            }
                        });
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onFailure$3() {
                        Form6.this.alertDialog.dismiss();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onFailure$4(DialogInterface dialogInterface, int i) {
                        Form6.this.openFragment(new CheckListMain());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0() {
                    Form6.this.alertDialog.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
                    Form6.this.openFragment(new CheckListMain());
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onFailure$2();
                        }
                    }, 2000L);
                    Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Address Proof List OnFailure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onFailure$3(dialogInterface, i);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onFailure$2() {
                    Form6.this.alertDialog.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onFailure$3(DialogInterface dialogInterface, int i) {
                    Form6.this.openFragment(new CheckListMain());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onFailure$2();
                    }
                }, 2000L);
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Error Relation Type List OnFailure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onFailure$3(dialogInterface, i);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onFailure$2() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onFailure$3(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$2() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$2();
                }
            }, 2000L);
            Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 OnFailure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$29$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onFailure$3(dialogInterface, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$3(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTokenApi() {
        this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda31
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$47(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$47(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda89
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$45(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(requireContext(), "ALERT", "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda90
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$46(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$45(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$46(DialogInterface dialogInterface, int i) {
        openFragment(new TotalListFragment());
    }

    private String getAge(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);
        int i = calendar2.get(1) - calendar.get(1);
        int i2 = calendar2.get(2);
        int i3 = calendar.get(2);
        if (i2 < i3 || (i2 == i3 && calendar2.get(5) < calendar.get(5))) {
            i--;
        }
        return Integer.toString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextValues() {
        if (this.checkListForm6Model.getPersonalDetailsSameOrNot().trim().equals("Y")) {
            this.binding.sameRb.setChecked(true);
            this.binding.personalDetailButton.setVisibility(8);
            this.binding.tvPersonalEditTextview.setVisibility(8);
        } else if (this.checkListForm6Model.getPersonalDetailsSameOrNot().trim().equals("N")) {
            this.binding.personalDetailButton.setVisibility(0);
            this.binding.tvPersonalEditTextview.setVisibility(0);
            this.binding.otherRb.setChecked(true);
        }
        if ((this.checkListForm6Model.getAnnexuredetsilsSameorNot() == null || !this.checkListForm6Model.getAnnexuredetsilsSameorNot().trim().equals("Y")) && this.binding.annexureVerification.getVisibility() == 0 && this.checkListForm6Model.getAnnexuredetsilsSameorNot() != null && this.checkListForm6Model.getAnnexuredetsilsSameorNot().trim().equals("N")) {
            this.binding.annexureDIncludedLayout.annxureEditDetailButton.setVisibility(0);
            this.binding.annexureDIncludedLayout.tvAnnxureEditTextview.setVisibility(0);
            this.binding.annexureOtherRb.setChecked(true);
        }
        if (this.checkListForm6Model.getSetDeclarationSameOrNot() != null && this.checkListForm6Model.getSetDeclarationSameOrNot().trim().equals("Y")) {
            this.binding.declarationSameRb.setChecked(true);
        } else if (this.binding.declarationVerification.getVisibility() == 0 && this.checkListForm6Model.getSetDeclarationSameOrNot() != null && this.checkListForm6Model.getSetDeclarationSameOrNot().trim().equals("N")) {
            this.binding.declarationSirIncludedLayout.tvDeclarationEditTextview.setVisibility(0);
            this.binding.declarationSirIncludedLayout.declarationEditDetailButton.setVisibility(0);
            this.binding.declarationOtherRb.setChecked(true);
        }
        if (this.checkListForm6Model.getAuthenticationSameOrNot() != null && this.checkListForm6Model.getAuthenticationSameOrNot().trim().equals("Y")) {
            this.binding.authenticationButton.setVisibility(8);
            this.binding.tvAuthenticationEditTextview.setVisibility(8);
            this.binding.sameRadiobutton.setChecked(true);
        } else if (this.checkListForm6Model.getAuthenticationSameOrNot() != null && this.checkListForm6Model.getAuthenticationSameOrNot().trim().equals("N")) {
            this.binding.authenticationButton.setVisibility(0);
            this.binding.tvAuthenticationEditTextview.setVisibility(0);
            this.binding.otherRadiobutton.setChecked(true);
        }
        if (this.checkListForm6Model.getDateOfBirthSameOrNot() != null && this.checkListForm6Model.getDateOfBirthSameOrNot().trim().equals("Y")) {
            this.binding.dateOfBirthButton.setVisibility(8);
            this.binding.tvDobEditTextview.setVisibility(8);
            this.binding.sameDobRb.setChecked(true);
        } else if (this.checkListForm6Model.getDateOfBirthSameOrNot() != null && this.checkListForm6Model.getDateOfBirthSameOrNot().trim().equals("N")) {
            this.binding.otherDobRb.setChecked(true);
            this.binding.dateOfBirthButton.setVisibility(0);
            this.binding.tvDobEditTextview.setVisibility(0);
        }
        if (this.checkListForm6Model.getAddressSameOrNot() != null && this.checkListForm6Model.getAddressSameOrNot().trim().equals("Y")) {
            this.binding.residenceDetailButton.setVisibility(8);
            this.binding.tvReferenceEditTextview.setVisibility(8);
            this.binding.addressRbSame.setChecked(true);
        } else if (this.checkListForm6Model.getAddressSameOrNot() != null && this.checkListForm6Model.getAddressSameOrNot().trim().equals("N")) {
            this.binding.addressRbNotSame.setChecked(true);
            this.binding.residenceDetailButton.setVisibility(0);
            this.binding.tvReferenceEditTextview.setVisibility(0);
        }
        if (this.checkListForm6Model.getFamilyDetailsSameOrNot() != null && this.checkListForm6Model.getFamilyDetailsSameOrNot().trim().equals("Y")) {
            this.binding.familyDetailsButton.setVisibility(8);
            this.binding.tvFamilyEditTextview.setVisibility(8);
            this.binding.familyDetailsSameRb.setChecked(true);
        } else if (this.checkListForm6Model.getFamilyDetailsSameOrNot() != null && this.checkListForm6Model.getFamilyDetailsSameOrNot().trim().equals("N")) {
            this.binding.familyDetailsOtherRb.setChecked(true);
            this.binding.familyDetailsButton.setVisibility(0);
            this.binding.tvFamilyEditTextview.setVisibility(0);
        }
        if (this.checkListForm6Model.getDisabilityDetailsSameOrNot() != null && this.checkListForm6Model.getDisabilityDetailsSameOrNot().trim().equals("Y")) {
            this.binding.categoryOfDisabilityButton.setVisibility(8);
            this.binding.tvDisabilityEditTextview.setVisibility(8);
            this.binding.disabilityDetailsSameRb.setChecked(true);
        } else if (this.checkListForm6Model.getDisabilityDetailsSameOrNot() != null && this.checkListForm6Model.getDisabilityDetailsSameOrNot().trim().equals("N")) {
            this.binding.disabilityDetailsOtherRb.setChecked(true);
            this.binding.categoryOfDisabilityButton.setVisibility(0);
            this.binding.tvDisabilityEditTextview.setVisibility(0);
        }
        this.checkListForm6Model.setDisabilityDetailsSameOrNot("Y");
        this.binding.applicantNameOfficialTv1.setEnabled(false);
        if (this.checkListForm6Model.getStateCd() == null || this.checkListForm6Model.getStateCd().trim().equals("null") || this.checkListForm6Model.getStateCd().trim().isEmpty()) {
            this.checkListForm6Model.setStateCd(this.mSTATECODE);
        }
        if (this.checkListForm6Model.getCurrentStateCd() == null || this.checkListForm6Model.getCurrentStateCd().trim().equals("null")) {
            this.checkListForm6Model.setCurrentStateCd(this.mSTATECODE);
        }
        if (this.checkListForm6Model.getDistrictCd() == null || this.checkListForm6Model.getDistrictCd().trim().equals("null") || this.checkListForm6Model.getDistrictCd().trim().isEmpty()) {
            this.checkListForm6Model.setDistrictCd(this.mDISTRICTCODE);
        }
        if (this.checkListForm6Model.getCurrentDistrictCd() == null || this.checkListForm6Model.getCurrentDistrictCd().trim().equals("null") || this.checkListForm6Model.getCurrentDistrictCd().trim().isEmpty()) {
            this.checkListForm6Model.setCurrentDistrictCd(this.mDISTRICTCODE);
        }
        if (this.checkListForm6Model.getFirstName() == null || this.checkListForm6Model.getFirstName().trim().equals("null")) {
            this.checkListForm6Model.setFirstName("");
        }
        if (this.checkListForm6Model.getFirstNameL1() == null || this.checkListForm6Model.getFirstNameL1().trim().equals("null")) {
            this.checkListForm6Model.setFirstNameL1("");
        }
        if (this.checkListForm6Model.getFirstNameL2() == null || this.checkListForm6Model.getFirstNameL2().trim().equals("null")) {
            this.checkListForm6Model.setFirstNameL2("");
        }
        if (this.checkListForm6Model.getLastName() == null || this.checkListForm6Model.getLastName().trim().equals("null")) {
            this.checkListForm6Model.setLastName("");
        }
        if (this.checkListForm6Model.getLastNameL1() == null || this.checkListForm6Model.getLastNameL1().trim().equals("null")) {
            this.checkListForm6Model.setLastNameL1("");
        }
        if (this.checkListForm6Model.getLastNameL2() == null || this.checkListForm6Model.getLastNameL2().trim().equals("null")) {
            this.checkListForm6Model.setLastNameL2("");
        }
        if (this.checkListForm6Model.getRelativeMobile() == null || this.checkListForm6Model.getRelativeMobile().trim().equals("null")) {
            this.checkListForm6Model.setRelativeMobile("");
        }
        if (this.checkListForm6Model.getDeclrBirthDocName() == null || this.checkListForm6Model.getDeclrBirthDocName().trim().equals("null")) {
            this.checkListForm6Model.setDeclrBirthDocName("");
        }
        if (this.checkListForm6Model.getRelativeEmail() == null || this.checkListForm6Model.getRelativeEmail().trim().equals("null")) {
            this.checkListForm6Model.setRelativeEmail("");
        }
        if (this.checkListForm6Model.getApplicantRelativeName() == null || this.checkListForm6Model.getApplicantRelativeName().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeName("");
        }
        if (this.checkListForm6Model.getApplicantRelativeNameL1() == null || this.checkListForm6Model.getApplicantRelativeNameL1().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeNameL1("");
        }
        if (this.checkListForm6Model.getApplicantRelativeNameL2() == null || this.checkListForm6Model.getApplicantRelativeNameL2().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeNameL2("");
        }
        if (this.checkListForm6Model.getApplicantRelativeSurname() == null || this.checkListForm6Model.getApplicantRelativeSurname().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeSurname("");
        }
        if (this.checkListForm6Model.getApplicantRelativeSurnameL1() == null || this.checkListForm6Model.getApplicantRelativeSurnameL1().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeSurnameL1("");
        }
        if (this.checkListForm6Model.getApplicantRelativeSurnameL2() == null || this.checkListForm6Model.getApplicantRelativeSurnameL2().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRelativeSurnameL2("");
        }
        if (this.checkListForm6Model.getMobileNumber() == null || this.checkListForm6Model.getMobileNumber().trim().equals("null")) {
            this.checkListForm6Model.setMobileNumber("");
        }
        if (this.checkListForm6Model.getEmail() == null || this.checkListForm6Model.getEmail().trim().equals("null")) {
            this.checkListForm6Model.setEmail("");
        }
        if (this.checkListForm6Model.getAadharRefNo() == null || this.checkListForm6Model.getAadharRefNo().trim().equals("null")) {
            this.checkListForm6Model.setAadharRefNo("");
        }
        if (this.checkListForm6Model.getAgeAtFormSubmission() == null || this.checkListForm6Model.getAgeAtFormSubmission().trim().equals("null") || this.checkListForm6Model.getAgeAtFormSubmission().isEmpty()) {
            this.checkListForm6Model.setAgeAtFormSubmission("");
        }
        if (this.checkListForm6Model.getDob() == null || this.checkListForm6Model.getDob().trim().equals("null")) {
            this.checkListForm6Model.setDob("");
        }
        if (this.checkListForm6Model.getFormSubmissionPlace() == null || this.checkListForm6Model.getFormSubmissionPlace().trim().equals("null")) {
            this.checkListForm6Model.setFormSubmissionPlace("");
        }
        if (this.checkListForm6Model.getCurrentHouseNumber() == null || this.checkListForm6Model.getCurrentHouseNumber().trim().equals("null")) {
            this.checkListForm6Model.setCurrentHouseNumber("");
        }
        if (this.checkListForm6Model.getCurrentHouseNumberL1() == null || this.checkListForm6Model.getCurrentHouseNumberL1().trim().equals("null")) {
            this.checkListForm6Model.setCurrentHouseNumberL1("");
        }
        if (this.checkListForm6Model.getCurrentHouseNumberL2() == null || this.checkListForm6Model.getCurrentHouseNumberL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentHouseNumberL2("");
        }
        if (this.checkListForm6Model.getCurrentLocality() == null || this.checkListForm6Model.getCurrentLocality().trim().equals("null")) {
            this.checkListForm6Model.setCurrentLocality("");
        }
        if (this.checkListForm6Model.getCurrentLocalityL2() == null || this.checkListForm6Model.getCurrentLocalityL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentLocalityL2("");
        }
        if (this.checkListForm6Model.getCurrentVillageOrTown() == null || this.checkListForm6Model.getCurrentVillageOrTown().trim().equals("null")) {
            this.checkListForm6Model.setCurrentVillageOrTown("");
        }
        if (this.checkListForm6Model.getCurrentVillageOrTownL1() == null || this.checkListForm6Model.getCurrentVillageOrTownL1().trim().equals("null")) {
            this.checkListForm6Model.setCurrentVillageOrTownL1("");
        }
        if (this.checkListForm6Model.getCurrentVillageOrTownL2() == null || this.checkListForm6Model.getCurrentVillageOrTownL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentVillageOrTownL2("");
        }
        if (this.checkListForm6Model.getCurrentPostOffice() == null || this.checkListForm6Model.getCurrentPostOffice().trim().equals("null")) {
            this.checkListForm6Model.setCurrentPostOffice("");
        }
        if (this.checkListForm6Model.getCurrentPostOfficeL1() == null || this.checkListForm6Model.getCurrentPostOfficeL1().trim().equals("null")) {
            this.checkListForm6Model.setCurrentPostOfficeL1("");
        }
        if (this.checkListForm6Model.getCurrentPostOfficeL2() == null || this.checkListForm6Model.getCurrentPostOfficeL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentPostOfficeL2("");
        }
        if (this.checkListForm6Model.getCurrentPinCode() == null || this.checkListForm6Model.getCurrentPinCode().trim().equals("null")) {
            this.checkListForm6Model.setCurrentPinCode("");
        }
        if (this.checkListForm6Model.getCurrentAddressTehTalMan() == null || this.checkListForm6Model.getCurrentAddressTehTalMan().trim().equals("null")) {
            this.checkListForm6Model.setCurrentAddressTehTalMan("");
        }
        if (this.checkListForm6Model.getCurrentAddressTehL1() == null || this.checkListForm6Model.getCurrentAddressTehL1().trim().equals("null")) {
            this.checkListForm6Model.setCurrentAddressTehL1("");
        }
        if (this.checkListForm6Model.getCurrentAddressTehL2() == null || this.checkListForm6Model.getCurrentAddressTehL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentAddressTehL2("");
        }
        if (this.checkListForm6Model.getDisabilityPercentage() == null || this.checkListForm6Model.getDisabilityPercentage().trim().equals("null") || this.checkListForm6Model.getDisabilityPercentage().isEmpty()) {
            this.checkListForm6Model.setDisabilityPercentage("");
        }
        if (this.checkListForm6Model.getCurrentRelFullName() == null || this.checkListForm6Model.getCurrentRelFullName().trim().equals("null")) {
            this.checkListForm6Model.setCurrentRelFullName("");
        }
        if (this.checkListForm6Model.getCurrentRelEpic() == null || this.checkListForm6Model.getCurrentRelEpic().isEmpty() || this.checkListForm6Model.getCurrentRelEpic().trim().equals("null")) {
            this.checkListForm6Model.setCurrentRelEpic("");
        }
        if (this.checkListForm6Model.getCurrentRelRelationship() == null || this.checkListForm6Model.getCurrentRelRelationship().trim().equals("null")) {
            this.checkListForm6Model.setCurrentRelRelationship("");
        }
        if (this.checkListForm6Model.getFormSubmissionMode() == null || this.checkListForm6Model.getFormSubmissionMode().trim().equals("null")) {
            this.checkListForm6Model.setFormSubmissionMode("ONLINE");
        }
        if (this.checkListForm6Model.getFormSubmissionChannel() == null || this.checkListForm6Model.getFormSubmissionChannel().trim().equals("null")) {
            this.checkListForm6Model.setFormSubmissionChannel("GARUDA");
        }
        if (this.checkListForm6Model.getDisabilityTypeLocomotor() == null || this.checkListForm6Model.getDisabilityTypeLocomotor().trim().equals("null")) {
            this.checkListForm6Model.setDisabilityTypeLocomotor("");
        }
        if (this.checkListForm6Model.getDisabilityTypeOthers() == null || this.checkListForm6Model.getDisabilityTypeOthers().trim().equals("null")) {
            this.checkListForm6Model.setDisabilityTypeOthers("");
        }
        if (this.checkListForm6Model.getDisabilityTypeSh() == null || this.checkListForm6Model.getDisabilityTypeSh().trim().equals("null")) {
            this.checkListForm6Model.setDisabilityTypeSh("");
        }
        if (this.checkListForm6Model.getDisabilityTypeVi() == null || this.checkListForm6Model.getDisabilityTypeVi().trim().equals("null")) {
            this.checkListForm6Model.setDisabilityTypeVi("");
        }
        if (this.checkListForm6Model.getPhotograph() != null) {
            if (this.checkListForm6Model.getPhotograph().toLowerCase().contains(this.jpg) || this.checkListForm6Model.getPhotograph().toLowerCase().contains(this.jpeg) || this.checkListForm6Model.getPhotograph().toLowerCase().contains(this.png) || this.checkListForm6Model.getPhotograph().toLowerCase().contains(this.jfif)) {
                Log.d(TAG, this.nothingToDo);
            } else {
                this.checkListForm6Model.setPhotograph("");
            }
        } else {
            this.checkListForm6Model.setPhotograph("");
        }
        if (this.checkListForm6Model.getAgeProofDocument() != null) {
            if (this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(this.jpg) || this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(this.jpeg) || this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(this.png) || this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(this.jfif) || this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(".pdf")) {
                Log.d(TAG, this.nothingToDo);
            } else {
                this.checkListForm6Model.setAgeProofDocument("");
            }
        } else {
            this.checkListForm6Model.setAgeProofDocument("");
        }
        if (this.checkListForm6Model.getCurrentAddressProofDocument() != null) {
            if (this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(this.jpg) || this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(this.jpeg) || this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(this.png) || this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(this.jfif) || this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(".pdf")) {
                Log.d(TAG, this.nothingToDo);
            } else {
                this.checkListForm6Model.setCurrentAddressProofDocument("");
            }
        } else {
            this.checkListForm6Model.setCurrentAddressProofDocument("");
        }
        if (this.checkListForm6Model.getDisabilityCertificate() != null) {
            if (this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(this.jpg) || this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(this.jpeg) || this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(this.png) || this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(this.jfif) || this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(".pdf")) {
                Log.d(TAG, this.nothingToDo);
            } else {
                this.checkListForm6Model.setDisabilityCertificate("");
            }
        } else {
            this.checkListForm6Model.setDisabilityCertificate("");
        }
        if (this.checkListForm6Model.getDisabilityCertAttached() == null || this.checkListForm6Model.getDisabilityCertAttached().trim().equals("null")) {
            this.checkListForm6Model.setDisabilityCertAttached("");
        }
        if (this.checkListForm6Model.getAcNAme() == null || this.checkListForm6Model.getAcNAme().trim().equals("null")) {
            this.checkListForm6Model.setAcNAme("");
        }
        if (this.checkListForm6Model.getPcNo() == null || this.checkListForm6Model.getPcNo().trim().equals("null")) {
            this.checkListForm6Model.setPcNo("");
        }
        if (this.checkListForm6Model.getPcNo() == null || this.checkListForm6Model.getPcNo().trim().equals("null")) {
            this.checkListForm6Model.setPcNo("");
        }
        if (this.checkListForm6Model.getPcName() == null || this.checkListForm6Model.getPcName().trim().equals("null")) {
            this.checkListForm6Model.setPcName("");
        }
        if (this.checkListForm6Model.getAgeProofOthers() == null || this.checkListForm6Model.getAgeProofOthers().trim().equals("null")) {
            this.checkListForm6Model.setAgeProofOthers("");
        }
        if (this.checkListForm6Model.getAddressProofOthers() == null || this.checkListForm6Model.getAddressProofOthers().trim().equals("null")) {
            this.checkListForm6Model.setAddressProofOthers("");
        }
        if (this.checkListForm6Model.getPrevAcNo() == null || this.checkListForm6Model.getPrevAcNo().trim().equals("null")) {
            this.checkListForm6Model.setPrevAcNo("");
        }
        if (this.checkListForm6Model.getIsVip() == null || this.checkListForm6Model.getIsVip().trim().equals("null")) {
            this.checkListForm6Model.setIsVip("");
        }
        if (this.checkListForm6Model.getPrmntAddressProofDocument() == null || this.checkListForm6Model.getPrmntAddressProofDocument().trim().equals("null")) {
            this.checkListForm6Model.setPrmntAddressProofDocument("");
        }
        if (this.checkListForm6Model.getPrmntAddressProofType() == null || this.checkListForm6Model.getPrmntAddressProofType().trim().equals("null")) {
            this.checkListForm6Model.setPrmntAddressProofType("");
        }
        if (this.checkListForm6Model.getNationalityProof() == null || this.checkListForm6Model.getNationalityProof().trim().equals("null")) {
            this.checkListForm6Model.setNationalityProof("");
        }
        if (this.checkListForm6Model.getMiddleName() == null || this.checkListForm6Model.getMiddleName().trim().equals("null")) {
            this.checkListForm6Model.setMiddleName("");
        }
        if (this.checkListForm6Model.getScannedChecklist1() == null || this.checkListForm6Model.getScannedChecklist1().trim().equals("null")) {
            this.checkListForm6Model.setScannedChecklist1("");
        }
        if (this.checkListForm6Model.getScannedChecklist2() == null || this.checkListForm6Model.getScannedChecklist2().trim().equals("null")) {
            this.checkListForm6Model.setScannedChecklist2("");
        }
        if (this.checkListForm6Model.getNameChangeDoc() == null || this.checkListForm6Model.getNameChangeDoc().trim().equals("null")) {
            this.checkListForm6Model.setNameChangeDoc("");
        }
        if (this.checkListForm6Model.getPrevHouseNo() == null || this.checkListForm6Model.getPrevHouseNo().trim().equals("null")) {
            this.checkListForm6Model.setPrevHouseNo("");
        }
        if (this.checkListForm6Model.getPrevHouseNoV1() == null || this.checkListForm6Model.getPrevHouseNoV1().trim().equals("null")) {
            this.checkListForm6Model.setPrevHouseNoV1("");
        }
        if (this.checkListForm6Model.getPrevStreetArea() == null || this.checkListForm6Model.getPrevStreetArea().trim().equals("null")) {
            this.checkListForm6Model.setPrevStreetArea("");
        }
        if (this.checkListForm6Model.getPrevVillage() == null || this.checkListForm6Model.getPrevVillage().trim().equals("null")) {
            this.checkListForm6Model.setPrevVillage("");
        }
        if (this.checkListForm6Model.getPrevPostOffice() == null || this.checkListForm6Model.getPrevPostOffice().trim().equals("null")) {
            this.checkListForm6Model.setPrevPostOffice("");
        }
        if (this.checkListForm6Model.getModifiedDttm() == null || this.checkListForm6Model.getModifiedDttm().trim().equals("null")) {
            this.checkListForm6Model.setModifiedDttm("");
        }
        if (this.checkListForm6Model.getAdharLinkedMobileNumber() == null || this.checkListForm6Model.getAdharLinkedMobileNumber().trim().equals("null")) {
            this.checkListForm6Model.setAdharLinkedMobileNumber("");
        }
        if (this.checkListForm6Model.getPrmntLocality() == null || this.checkListForm6Model.getPrmntLocality().trim().equals("null")) {
            this.checkListForm6Model.setPrmntLocality("");
        }
        if (this.checkListForm6Model.getPrmntVillageOrTown() == null || this.checkListForm6Model.getPrmntVillageOrTown().trim().equals("null")) {
            this.checkListForm6Model.setPrmntVillageOrTown("");
        }
        if (this.checkListForm6Model.getPrmntPostOffice() == null || this.checkListForm6Model.getPrmntPostOffice().trim().equals("null")) {
            this.checkListForm6Model.setPrmntPostOffice("");
        }
        if (this.checkListForm6Model.getCurrentPostOfficeL2() == null || this.checkListForm6Model.getCurrentPostOfficeL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentPostOfficeL2("");
        }
        if (this.checkListForm6Model.getPrmntHouseNumberL2() == null || this.checkListForm6Model.getPrmntHouseNumberL2().trim().equals("null")) {
            this.checkListForm6Model.setPrmntHouseNumberL2("");
        }
        if (this.checkListForm6Model.getPrmntLocalityL1() == null || this.checkListForm6Model.getPrmntLocalityL1().trim().equals("null")) {
            this.checkListForm6Model.setPrmntLocalityL1("");
        }
        if (this.checkListForm6Model.getPrmntLocalityL2() == null || this.checkListForm6Model.getPrmntLocalityL2().trim().equals("null")) {
            this.checkListForm6Model.setPrmntLocalityL2("");
        }
        if (this.checkListForm6Model.getSelfOrOtherMember() == null || this.checkListForm6Model.getSelfOrOtherMember().trim().equals("null")) {
            this.checkListForm6Model.setSelfOrOtherMember("");
        }
        if (this.checkListForm6Model.getApplicantRlnWithMember() == null || this.checkListForm6Model.getApplicantRlnWithMember().trim().equals("null")) {
            this.checkListForm6Model.setApplicantRlnWithMember("");
        }
        if (this.checkListForm6Model.getBirthStateName() == null || this.checkListForm6Model.getBirthStateName().trim().equals("null")) {
            this.checkListForm6Model.setBirthStateName("");
        }
        if (this.checkListForm6Model.getGenderDesc() == null || this.checkListForm6Model.getGenderDesc().trim().equals("null")) {
            this.checkListForm6Model.setGenderDesc("");
        }
        if (this.checkListForm6Model.getRelationDesc() == null || this.checkListForm6Model.getGenderDesc().trim().equals("null")) {
            this.checkListForm6Model.setRelationDesc("");
        }
        if (this.checkListForm6Model.getCurrRelRelation() == null || this.checkListForm6Model.getCurrRelRelation().trim().equals("null")) {
            this.checkListForm6Model.setCurrRelRelation("");
        }
        if (this.checkListForm6Model.getDeclVillage() == null || this.checkListForm6Model.getDeclVillage().trim().equals("null")) {
            this.checkListForm6Model.setDeclVillage("");
        }
        if (this.checkListForm6Model.getDeclDistrict() == null || this.checkListForm6Model.getDeclDistrict().trim().equals("null")) {
            this.checkListForm6Model.setDeclDistrict("");
        }
        if (this.checkListForm6Model.getAgeDecl() == null || this.checkListForm6Model.getAgeDecl().trim().equals("null")) {
            this.checkListForm6Model.setAgeDecl("");
        }
        if (this.checkListForm6Model.getScannedFromPage1() == null || this.checkListForm6Model.getScannedFromPage1().trim().equals("null")) {
            this.checkListForm6Model.setScannedFromPage1("");
        }
        if (this.checkListForm6Model.getScannedFromPage2() == null || this.checkListForm6Model.getScannedFromPage2().trim().equals("null")) {
            this.checkListForm6Model.setScannedFromPage2("");
        }
        if (this.checkListForm6Model.getConsentToLinkAadhar() == null || this.checkListForm6Model.getConsentToLinkAadhar().trim().equals("null")) {
            this.checkListForm6Model.setConsentToLinkAadhar("");
        }
        if (this.checkListForm6Model.getValidationOfAadhar() == null || this.checkListForm6Model.getValidationOfAadhar().trim().equals("null")) {
            this.checkListForm6Model.setValidationOfAadhar("");
        }
        if (this.checkListForm6Model.getFirstTimeVoter() == null || this.checkListForm6Model.getFirstTimeVoter().trim().equals("null")) {
            this.checkListForm6Model.setFirstTimeVoter("");
        }
        if (this.checkListForm6Model.getShiftingFromConstituency() == null || this.checkListForm6Model.getShiftingFromConstituency().trim().equals("null")) {
            this.checkListForm6Model.setShiftingFromConstituency("");
        }
        if (this.checkListForm6Model.getCurrentVillageOrTownL2() == null || this.checkListForm6Model.getCurrentVillageOrTownL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentVillageOrTownL2("");
        }
        if (this.checkListForm6Model.getCurrentHouseNumberL2() == null || this.checkListForm6Model.getCurrentHouseNumberL2().trim().equals("null")) {
            this.checkListForm6Model.setCurrentHouseNumberL2("");
        }
        if (this.checkListForm6Model.getCurrentAddressStayDate() == null || this.checkListForm6Model.getCurrentAddressStayDate().trim().equals("null")) {
            this.checkListForm6Model.setCurrentAddressStayDate("");
        }
        if (this.checkListForm6Model.getPrmntStateCd() == null || this.checkListForm6Model.getPrmntStateCd().trim().equals("null")) {
            this.checkListForm6Model.setPrmntStateCd("");
        }
        if (this.checkListForm6Model.getPrmntDistrictCd() == null || this.checkListForm6Model.getPrmntDistrictCd().trim().equals("null")) {
            this.checkListForm6Model.setPrmntDistrictCd("");
        }
        if (this.checkListForm6Model.getPrmntHouseNumber() == null || this.checkListForm6Model.getPrmntHouseNumber().trim().equals("null")) {
            this.checkListForm6Model.setPrmntHouseNumber("");
        }
        if (this.checkListForm6Model.getBirthDistrictName() == null || this.checkListForm6Model.getBirthDistrictName().trim().equals("null")) {
            this.checkListForm6Model.setBirthDistrictName("");
        }
        if (this.checkListForm6Model.getPrmntPostOfficeL2() == null || this.checkListForm6Model.getPrmntPostOfficeL2().trim().equals("null")) {
            this.checkListForm6Model.setPrmntPostOfficeL2("");
        }
        if (this.checkListForm6Model.getPrmntPinCode() == null || this.checkListForm6Model.getPrmntPinCode().trim().equals("null")) {
            this.checkListForm6Model.setPrmntPinCode("");
        }
        if (this.checkListForm6Model.getPrmntVillageOrTownL1() == null || this.checkListForm6Model.getPrmntVillageOrTownL1().trim().equals("null")) {
            this.checkListForm6Model.setPrmntVillageOrTownL1("");
        }
        if (this.checkListForm6Model.getPrmntVillageOrTownL2() == null || this.checkListForm6Model.getPrmntVillageOrTownL2().trim().equals("null")) {
            this.checkListForm6Model.setPrmntVillageOrTownL2("");
        }
        if (this.checkListForm6Model.getPrmntPostOfficeL1() == null || this.checkListForm6Model.getPrmntPostOfficeL1().trim().equals("null")) {
            this.checkListForm6Model.setPrmntPostOfficeL1("");
        }
        if (this.checkListForm6Model.getCreationDttm() == null || this.checkListForm6Model.getCreationDttm().trim().equals("null")) {
            this.checkListForm6Model.setCreationDttm("");
        }
        if (this.checkListForm6Model.getModifiedBy() == null || this.checkListForm6Model.getModifiedBy().trim().equals("null")) {
            this.checkListForm6Model.setModifiedBy("");
        }
        if (this.checkListForm6Model.getForm6Id() == null || this.checkListForm6Model.getForm6Id().trim().equals("null")) {
            this.checkListForm6Model.setForm6Id("");
        }
        if (this.checkListForm6Model.getOrdinaryResDate() == null || this.checkListForm6Model.getOrdinaryResDate().trim().equals("null")) {
            this.checkListForm6Model.setOrdinaryResDate("");
        }
        if (this.checkListForm6Model.getDeclrBirthDocName() == null || this.checkListForm6Model.getDeclrBirthDocName().trim().equals("null")) {
            this.checkListForm6Model.setDeclrBirthDocName("");
        }
        if (this.checkListForm6Model.getPrevStateCode() == null || this.checkListForm6Model.getPrevStateCode().trim().equals("null")) {
            this.checkListForm6Model.setPrevStateCode("");
        }
        if (this.checkListForm6Model.getBirthVillage() == null || this.checkListForm6Model.getBirthVillage().trim().equals("null")) {
            this.checkListForm6Model.setBirthVillage("null");
        }
        if (this.checkListForm6Model.getPrevEpicExists() == null || this.checkListForm6Model.getPrevEpicExists().trim().equals("null")) {
            this.checkListForm6Model.setPrevEpicExists("");
        }
        if (this.checkListForm6Model.getDeathCertificate() == null || this.checkListForm6Model.getDeathCertificate().trim().equals("null")) {
            this.checkListForm6Model.setDeathCertificate("");
        }
        if (this.checkListForm6Model.getPrevStreetArea() == null || this.checkListForm6Model.getPrevStreetArea().trim().equals("null")) {
            this.checkListForm6Model.setPrevStreetArea("");
        }
        if (this.checkListForm6Model.getPrevVillage() == null || this.checkListForm6Model.getPrevVillage().trim().equals("null")) {
            this.checkListForm6Model.setPrevVillage("");
        }
        if (this.checkListForm6Model.getPrevPostOffice() == null || this.checkListForm6Model.getPrevPostOffice().trim().equals("null")) {
            this.checkListForm6Model.setPrevPostOffice("");
        }
        if (this.checkListForm6Model.getModifiedDttm() == null || this.checkListForm6Model.getModifiedDttm().trim().equals("null")) {
            this.checkListForm6Model.setModifiedDttm("");
        }
        if (this.checkListForm6Model.getAdharLinkedMobileNumber() == null || this.checkListForm6Model.getAdharLinkedMobileNumber().trim().equals("null")) {
            this.checkListForm6Model.setAdharLinkedMobileNumber("");
        }
        if (this.checkListForm6Model.getFamilOrNeighbourAadharNumber() == null || this.checkListForm6Model.getFamilOrNeighbourAadharNumber().trim().equals("null")) {
            this.checkListForm6Model.setFamilOrNeighbourAadharNumber("");
        }
        if (this.checkListForm6Model.getPrmntLocality() == null || this.checkListForm6Model.getPrmntLocality().trim().equals("null")) {
            this.checkListForm6Model.setPrmntLocality("");
        }
        if (this.checkListForm6Model.getPrmntVillageOrTown() == null || this.checkListForm6Model.getPrmntVillageOrTown().trim().equals("null")) {
            this.checkListForm6Model.setPrmntVillageOrTown("");
        }
        if (this.checkListForm6Model.getCurrentAddressProofType() == null || this.checkListForm6Model.getCurrentAddressProofType().trim().equals("null")) {
            this.checkListForm6Model.setCurrentAddressProofType("");
        }
        if (this.checkListForm6Model.getBirthDistrictNo() == null || this.checkListForm6Model.getBirthDistrictNo().trim().equals("null")) {
            this.checkListForm6Model.setBirthDistrictNo("");
        }
        if (this.checkListForm6Model.getBirthDistrictNo() == null || this.checkListForm6Model.getBirthDistrictNo().trim().equals("null")) {
            this.checkListForm6Model.setBirthDistrictNo("");
        }
        if (this.checkListForm6Model.getPrmntHouseNumberL1() == null || this.checkListForm6Model.getPrmntHouseNumberL1().trim().equals("null")) {
            this.checkListForm6Model.setPrmntHouseNumberL1("");
        }
        if (this.checkListForm6Model.getPartNumber() == null || this.checkListForm6Model.getPartNumber().trim().equals("null")) {
            this.checkListForm6Model.setPartNumber(this.partNo);
        }
        if (this.checkListForm6Model.getDeclState() == null || this.checkListForm6Model.getDeclState().trim().equals("null")) {
            this.checkListForm6Model.setDeclState("");
        }
        if (this.checkListForm6Model.getAgeProofOthers() == null || this.checkListForm6Model.getAgeProofOthers().trim().equals("null")) {
            this.checkListForm6Model.setAgeProofOthers("");
        }
        if (this.checkListForm6Model.getAddressProofOthers() == null || this.checkListForm6Model.getAddressProofOthers().trim().equals("null")) {
            this.checkListForm6Model.setAddressProofOthers("");
        }
        if (this.checkListForm6Model.getDisability() == null || this.checkListForm6Model.getDisability().trim().equals("null")) {
            this.checkListForm6Model.setDisability("");
        }
        if (this.checkListForm6Model.getAgeProofType() == null || this.checkListForm6Model.getAgeProofType().trim().equals("null")) {
            this.checkListForm6Model.setAgeProofType("");
        }
        if (this.checkListForm6Model.getApplicantDate() == null || this.checkListForm6Model.getApplicantDate().trim().equals("null")) {
            this.checkListForm6Model.setApplicantDate("");
        }
        if (this.checkListForm6Model.getCurrentStateCd() == null || this.checkListForm6Model.getCurrentStateCd().trim().equals("null")) {
            this.checkListForm6Model.setCurrentStateCd(this.stateCode);
        }
        if (this.checkListForm6Model.getSectionNo() == null || Objects.equals(this.checkListForm6Model.getSectionNo(), "null") || this.checkListForm6Model.getSectionNo().isEmpty()) {
            this.checkListForm6Model.setSectionNo("0");
        }
        if (this.checkListForm6Model.getTypeOfRelation() == null || Objects.equals(this.checkListForm6Model.getTypeOfRelation(), "null") || this.checkListForm6Model.getTypeOfRelation().isEmpty()) {
            this.checkListForm6Model.setTypeOfRelation("");
        }
        this.disabilityType = "";
        if (this.checkListForm6Model.getDisabilityTypeLocomotor().trim().equals("Y")) {
            this.disabilityType += "Locomotive , ";
        }
        if (this.checkListForm6Model.getDisabilityTypeSh().trim().equals("Y")) {
            this.disabilityType += "Deaf & Dumb , ";
        }
        if (this.checkListForm6Model.getDisabilityTypeVi().trim().equals("Y")) {
            this.disabilityType += "Visual , ";
        }
        if (this.checkListForm6Model.getDisabilityTypeOthers().trim().equals("Y")) {
            this.disabilityType += "Other(" + this.checkListForm6Model.getDisability() + ") , ";
        }
        Log.d(TAG, "disabilityType ---> " + this.disabilityType);
        if (this.disabilityType.length() > 0) {
            String str = this.disabilityType;
            this.disabilityType = str.substring(0, str.length() - 2);
        }
        if (this.disabilityType.length() > 0) {
            this.binding.categoryOfDisabilityTv.setText(this.disabilityType);
        } else {
            this.binding.categoryOfDisabilityTv.setText(this.empty);
        }
        if (this.checkListForm6Model.getDisabilityPercentage().trim().length() > 0) {
            this.binding.percentageOfDisabilityTv.setText(this.checkListForm6Model.getDisabilityPercentage());
        } else {
            this.binding.percentageOfDisabilityTv.setText(this.empty);
        }
        this.binding.applicantNameTv1.setText(this.checkListForm6Model.getFirstName() + " " + this.checkListForm6Model.getLastName());
        this.binding.applicantNameOfficialTv1.setText(this.checkListForm6Model.getFirstNameL1() + " " + this.checkListForm6Model.getLastNameL1());
        this.binding.applicantNameOfficialTv2.setText(this.checkListForm6Model.getFirstNameL2() + " " + this.checkListForm6Model.getLastNameL2());
        if (this.checkListForm6Model.getAgeProofType().length() > 0) {
            for (int i = 0; i < this.checkListForm6Model.getAgeProofList().size(); i++) {
                if (this.checkListForm6Model.getAgeProofType().equals(this.checkListForm6Model.getAgeProofList().get(i)) || this.checkListForm6Model.getAgeProofType().equals(this.checkListForm6Model.getAgeProofListCode().get(i))) {
                    CheckListForm6Model checkListForm6Model = this.checkListForm6Model;
                    checkListForm6Model.setAgeProofType(checkListForm6Model.getAgeProofList().get(i));
                    this.binding.proofForDateOfBirth.setText(this.checkListForm6Model.getAgeProofType());
                }
            }
        } else {
            this.binding.proofForDateOfBirth.setText(this.empty);
        }
        if (this.checkListForm6Model.getTypeOfRelation().length() > 0) {
            for (int i2 = 0; i2 < this.checkListForm6Model.getRelationList().size(); i2++) {
                if (this.checkListForm6Model.getTypeOfRelation().equals(this.checkListForm6Model.getRelationList().get(i2)) || this.checkListForm6Model.getTypeOfRelation().equals(this.checkListForm6Model.getRelationListCode().get(i2))) {
                    CheckListForm6Model checkListForm6Model2 = this.checkListForm6Model;
                    checkListForm6Model2.setTypeOfRelation(checkListForm6Model2.getRelationListCode().get(i2));
                    this.binding.relationtype.setText(this.checkListForm6Model.getRelationList().get(i2));
                }
            }
        } else {
            this.binding.relationtype.setText(this.empty);
        }
        if (this.binding.relationtype.getText().toString().isEmpty()) {
            this.checkListForm6Model.setTypeOfRelation("");
            this.binding.relationtype.setText(this.empty);
        }
        if (this.checkListForm6Model.getCurrentRelRelationship().length() > 0) {
            for (int i3 = 0; i3 < this.checkListForm6Model.getRelationList().size(); i3++) {
                if (this.checkListForm6Model.getCurrentRelRelationship().equals(this.checkListForm6Model.getRelationList().get(i3)) || this.checkListForm6Model.getCurrentRelRelationship().equals(this.checkListForm6Model.getRelationListCode().get(i3))) {
                    CheckListForm6Model checkListForm6Model3 = this.checkListForm6Model;
                    checkListForm6Model3.setCurrentRelRelationship(checkListForm6Model3.getRelationList().get(i3));
                    this.binding.relationshipWithApplicantTv.setText(this.checkListForm6Model.getCurrentRelRelationship());
                }
            }
        } else {
            this.binding.relationshipWithApplicantTv.setText(this.empty);
        }
        if (this.binding.relationshipWithApplicantTv.getText().toString().isEmpty()) {
            this.checkListForm6Model.setCurrentRelRelationship("");
            this.binding.relationshipWithApplicantTv.setText(this.empty);
        }
        if (this.checkListForm6Model.getCurrentAddressProofType().length() > 0) {
            for (int i4 = 0; i4 < this.checkListForm6Model.getAddressPoofList().size(); i4++) {
                if (this.checkListForm6Model.getCurrentAddressProofType().equals(this.checkListForm6Model.getAddressPoofList().get(i4)) || this.checkListForm6Model.getCurrentAddressProofType().equals(this.checkListForm6Model.getAddressPoofListCode().get(i4))) {
                    CheckListForm6Model checkListForm6Model4 = this.checkListForm6Model;
                    checkListForm6Model4.setCurrentAddressProofType(checkListForm6Model4.getAddressPoofList().get(i4));
                    this.binding.proofOfResidence.setText(this.checkListForm6Model.getCurrentAddressProofType());
                }
            }
        } else {
            this.binding.proofOfResidence.setText(this.empty);
        }
        Log.d(TAG, "getAddressProofOthersAPI --->  " + this.checkListForm6Model.getAddressProofOthers());
        Log.d(TAG, "getCurrentAddressProofTypeAPI --->  " + this.checkListForm6Model.getCurrentAddressProofType());
        if (this.checkListForm6Model.getAgeProofOthers().equals("Y")) {
            this.binding.proofForDateOfBirth.setText(this.anyOtherDocument);
            this.binding.ageProofTypeOthertext.setVisibility(0);
            this.binding.ageProofTypeOther.setVisibility(0);
            this.binding.ageProofTypeOther.setText(this.checkListForm6Model.getAgeProofType());
        } else {
            this.binding.ageProofTypeOthertext.setVisibility(8);
            this.binding.ageProofTypeOther.setVisibility(8);
            this.binding.ageProofTypeOther.setText("");
        }
        if (this.checkListForm6Model.getAddressProofOthers().equals("Y")) {
            this.binding.proofOfResidence.setText(this.anyOtherDocument);
            this.binding.addressProofTypeOtherText.setVisibility(0);
            this.binding.addressProofTypeOther.setVisibility(0);
            this.binding.addressProofTypeOther.setText(this.checkListForm6Model.getCurrentAddressProofType());
        } else {
            this.binding.addressProofTypeOtherText.setVisibility(8);
            this.binding.addressProofTypeOther.setVisibility(8);
            this.binding.addressProofTypeOther.setText("");
        }
        if (this.checkListForm6Model.getApplicantGender().trim().equals("M") || this.checkListForm6Model.getApplicantGender().equalsIgnoreCase("Male")) {
            this.binding.genderTv1.setText("Male");
        } else if (this.checkListForm6Model.getApplicantGender().trim().equals("F")) {
            this.binding.genderTv1.setText("Female");
        } else if (this.checkListForm6Model.getApplicantGender().trim().equals("T")) {
            this.binding.genderTv1.setText("Third Gender");
        }
        if (this.checkListForm6Model.getMobileNumber().startsWith("+91-")) {
            CheckListForm6Model checkListForm6Model5 = this.checkListForm6Model;
            checkListForm6Model5.setMobileNumber(checkListForm6Model5.getMobileNumber().substring(4));
        } else if (this.checkListForm6Model.getMobileNumber().startsWith("+91")) {
            CheckListForm6Model checkListForm6Model6 = this.checkListForm6Model;
            checkListForm6Model6.setMobileNumber(checkListForm6Model6.getMobileNumber().substring(3));
        }
        if (this.checkListForm6Model.getRelativeMobile().startsWith("+91-")) {
            CheckListForm6Model checkListForm6Model7 = this.checkListForm6Model;
            checkListForm6Model7.setRelativeMobile(checkListForm6Model7.getRelativeMobile().substring(4));
        } else if (this.checkListForm6Model.getRelativeMobile().startsWith("+91")) {
            CheckListForm6Model checkListForm6Model8 = this.checkListForm6Model;
            checkListForm6Model8.setRelativeMobile(checkListForm6Model8.getRelativeMobile().substring(3));
        }
        this.binding.relativeTv1.setText(this.checkListForm6Model.getApplicantRelativeName() + " " + this.checkListForm6Model.getApplicantRelativeSurname());
        this.binding.relativeOfficialTv1.setText(this.checkListForm6Model.getApplicantRelativeNameL1() + " " + this.checkListForm6Model.getApplicantRelativeSurnameL1());
        this.binding.relativeOfficialTv2.setText(this.checkListForm6Model.getApplicantRelativeNameL2() + " " + this.checkListForm6Model.getApplicantRelativeSurnameL2());
        if (this.checkListForm6Model.getRelativeMobile().trim().length() != 0 && this.checkListForm6Model.getMobileNumber().trim().length() != 0) {
            this.binding.relationTypeMobile.setText(this.relative);
            this.binding.mobileNoTv.setText(this.checkListForm6Model.getMobileNumber());
        } else if (this.checkListForm6Model.getMobileNumber().trim().length() != 0) {
            this.binding.relationTypeMobile.setText("Self");
            this.binding.mobileNoTv.setText(this.checkListForm6Model.getMobileNumber());
        } else {
            this.binding.relationTypeMobile.setText("Self");
            this.binding.mobileNoTv.setText("");
        }
        if (this.checkListForm6Model.getRelativeEmail().trim().length() != 0 && this.checkListForm6Model.getEmail().trim().length() != 0) {
            this.binding.relationTypeMobileEmail.setText(this.relative);
            this.binding.emailTv.setText(this.checkListForm6Model.getEmail());
        } else if (this.checkListForm6Model.getEmail().trim().length() != 0) {
            this.binding.relationTypeMobileEmail.setText("Self");
            this.binding.emailTv.setText(this.checkListForm6Model.getEmail());
        } else {
            this.binding.relationTypeMobileEmail.setText("Self");
            this.binding.emailTv.setText("");
        }
        Logger.d(TAG, "Aadhaar Reference Number " + this.checkListForm6Model.getAadharRefNo());
        if (this.checkListForm6Model.getDob().length() != 0 && this.checkListForm6Model.getDob().contains("-")) {
            String[] strArrSplit = this.checkListForm6Model.getDob().split("-");
            String str2 = strArrSplit[1];
            String str3 = strArrSplit[2];
            if (str2.length() == 1) {
                str2 = "0" + str2;
            }
            if (str3.length() == 1) {
                str3 = "0" + str2;
            }
            int i5 = Integer.parseInt(strArrSplit[0]);
            this.checkListForm6Model.setAgeAtFormSubmission(getAge(i5, Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2])));
            this.binding.dob.setText(str3 + "/" + str2 + "/" + i5);
            this.binding.age.setText(this.checkListForm6Model.getAgeAtFormSubmission());
        }
        this.binding.houseno.setText(this.checkListForm6Model.getCurrentHouseNumber());
        this.binding.housenoOfficial.setText(this.checkListForm6Model.getCurrentHouseNumberL1());
        this.binding.housenoOfficial2.setText(this.checkListForm6Model.getCurrentHouseNumberL2());
        this.binding.street.setText(this.checkListForm6Model.getCurrentLocality());
        this.binding.streetOfficial.setText(this.checkListForm6Model.getCurrentLocalityL1());
        this.binding.streetOfficial2.setText(this.checkListForm6Model.getCurrentLocalityL2());
        this.binding.town.setText(this.checkListForm6Model.getCurrentVillageOrTown());
        this.binding.townOfficial.setText(this.checkListForm6Model.getCurrentVillageOrTownL1());
        this.binding.townOfficial2.setText(this.checkListForm6Model.getCurrentVillageOrTownL2());
        this.binding.postoffice.setText(this.checkListForm6Model.getCurrentPostOffice());
        this.binding.postofficeOfficial.setText(this.checkListForm6Model.getCurrentPostOfficeL1());
        this.binding.postofficeOfficial2.setText(this.checkListForm6Model.getCurrentPostOfficeL2());
        this.binding.pinCode.setText(this.checkListForm6Model.getCurrentPinCode());
        this.binding.tehsil.setText(this.checkListForm6Model.getCurrentAddressTehTalMan());
        this.binding.tehsilOfficial.setText(this.checkListForm6Model.getCurrentAddressTehL1());
        this.binding.tehsilOfficial2.setText(this.checkListForm6Model.getCurrentAddressTehL2());
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.checkListForm6Model.getSectionNameAndNumber());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.sectionNoName.setAdapter(arrayAdapter);
        if (this.checkListForm6Model.getSectionNo().length() == 0 || Integer.parseInt(this.checkListForm6Model.getSectionNo()) == 0) {
            this.binding.sectionNoName.setSelection(0);
            this.binding.sectionNoName.setEnabled(true);
            this.binding.sectionNoName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.30
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long l) {
                    if (i6 != 0) {
                        Form6.this.selectionSelectedPosition = i6 - 1;
                        Log.d(Form6.TAG, "Section selectionSelectedPosition ---> " + Form6.this.selectionSelectedPosition);
                        Form6.this.checkListForm6Model.setSectionNo(String.valueOf(Form6.this.checkListForm6Model.getSectionNameAndNumberModel().get(Form6.this.selectionSelectedPosition).getSectionNo()));
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Log.d(Form6.TAG, Form6.this.nothingToDo);
                }
            });
        } else {
            for (int i6 = 0; i6 < this.checkListForm6Model.getSectionNameAndNumberModel().size(); i6++) {
                if (this.checkListForm6Model.getSectionNameAndNumberModel().get(i6).getSectionNo() == Integer.parseInt(this.checkListForm6Model.getSectionNo())) {
                    this.binding.sectionNoName.setSelection(i6 + 1);
                    this.selectionSelectedPosition = this.checkListForm6Model.getSectionNameAndNumberModel().get(i6).getSectionNo() - 1;
                    Log.d(TAG, "Section selectionSelectedPosition ---> " + this.selectionSelectedPosition);
                    CheckListForm6Model checkListForm6Model9 = this.checkListForm6Model;
                    checkListForm6Model9.setSectionNo(String.valueOf(checkListForm6Model9.getSectionNo()));
                    this.binding.sectionNoName.setEnabled(false);
                }
            }
        }
        this.binding.state.setText(this.stateName);
        if (this.binding.district.getText().toString().isEmpty()) {
            this.districtName = "";
            this.binding.district.setText(this.districtName);
        }
        if (this.checkListForm6Model.getDisabilityPercentage().length() == 0 || this.checkListForm6Model.getDisabilityPercentage().isEmpty()) {
            this.checkListForm6Model.setDisabilityPercentage("0");
        }
        if (this.checkListForm6Model.getCurrentRelFullName().trim().length() > 0) {
            this.binding.nameOfFamilyMember.setText(this.checkListForm6Model.getCurrentRelFullName());
        } else {
            this.binding.nameOfFamilyMember.setText(this.empty);
        }
        if (this.checkListForm6Model.getCurrentRelEpic() != null && this.checkListForm6Model.getCurrentRelEpic().trim().length() > 0) {
            this.binding.epicNumberEd.setText(this.checkListForm6Model.getCurrentRelEpic());
        } else {
            this.binding.epicNumberEd.setText(this.empty);
        }
        getPersonImageUploadedfilePersonalDetials(this.checkListForm6Model.getPhotograph());
        if (isValideSIRState()) {
            this.relationNameList = SharedPref.getInstance(requireContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME);
            this.relationCodeList = SharedPref.getInstance(requireContext()).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
            setRelationShipAdapter();
            if (this.checkListForm6Model.getFatherorGuardianEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.prevfatherEpicNumber.setText(this.checkListForm6Model.getFatherorGuardianEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.prevfatherEpicNumber.setText(this.empty);
            }
            if (this.checkListForm6Model.getFatherorGuardianname() != null) {
                this.binding.declarationSirIncludedLayout.prevfatherName.setText(this.checkListForm6Model.getFatherorGuardianname());
            } else {
                this.binding.declarationSirIncludedLayout.prevfatherName.setText(this.empty);
            }
            if (this.checkListForm6Model.getMotherEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.prevmotherEpicNumber.setText(this.checkListForm6Model.getMotherEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.prevmotherEpicNumber.setText(this.empty);
            }
            if (this.checkListForm6Model.getMotherName() != null) {
                this.binding.declarationSirIncludedLayout.prevmotherName.setText(this.checkListForm6Model.getMotherName());
            } else {
                this.binding.declarationSirIncludedLayout.prevmotherName.setText(this.empty);
            }
            if (this.checkListForm6Model.getSpouseEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.prevspouseEpicNumber.setText(this.checkListForm6Model.getSpouseEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.prevspouseEpicNumber.setText(this.empty);
            }
            if (this.checkListForm6Model.getSpouseName() != null) {
                this.binding.declarationSirIncludedLayout.prevsspouseName.setText(this.checkListForm6Model.getSpouseName());
            } else {
                this.binding.declarationSirIncludedLayout.prevsspouseName.setText(this.empty);
            }
            if (this.checkListForm6Model.getDecsirf6DeclCategory() != null) {
                if (this.checkListForm6Model.getDecsirf6DeclCategory().trim().equalsIgnoreCase("self")) {
                    this.binding.declarationSirIncludedLayout.dfRBselfRb.setChecked(true);
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorName())) {
                        setSelfData();
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeName())) {
                        setProgenyData();
                    } else {
                        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
                        this.binding.declarationSirIncludedLayout.prevrelativeCardView.setVisibility(8);
                    }
                }
                if (this.checkListForm6Model.getDecsirf6DeclCategory().trim().equalsIgnoreCase("Progeny")) {
                    this.binding.declarationSirIncludedLayout.prevprogenyRb.setChecked(true);
                    setProgenyData();
                } else if (this.checkListForm6Model.getDecsirf6DeclCategory().trim().equalsIgnoreCase("NA")) {
                    this.binding.declarationSirIncludedLayout.neitherRb.setChecked(true);
                    this.binding.declarationSirIncludedLayout.prevrelativeCardView.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(8);
                }
                if (this.checkListForm6Model.getDecsirf6DeclSignature() != null) {
                    this.binding.declarationSirIncludedLayout.prevBloSignCardView.setVisibility(0);
                    getDeclarationFormUploadedSign(this.checkListForm6Model.getDecsirf6DeclSignature());
                    this.binding.declarationSirIncludedLayout.decFormSignName.setText(this.checkListForm6Model.getDecsirf6DeclSignature().trim());
                }
            } else {
                this.binding.declarationSirIncludedLayout.prevrelativeCardView.setVisibility(8);
                this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            }
            this.binding.declarationSirIncludedLayout.rb2003.setEnabled(false);
            this.binding.declarationSirIncludedLayout.rb2025.setEnabled(false);
            if (!TextUtils.isEmpty(this.checkListForm6Model.getIsSir03()) && this.checkListForm6Model.getIsSir03().equalsIgnoreCase("Y")) {
                this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
                this.binding.declarationSirIncludedLayout.lvCategoryRadio.setVisibility(0);
            } else {
                if (!TextUtils.isEmpty(this.checkListForm6Model.getIsSir2526()) && this.checkListForm6Model.getIsSir2526().equalsIgnoreCase("Y")) {
                    this.binding.declarationSirIncludedLayout.rb2025.setChecked(true);
                    this.binding.declarationSirIncludedLayout.lvCategoryRadio.setVisibility(0);
                    this.binding.declarationSirIncludedLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
                    this.binding.declarationSirIncludedLayout.prevprogenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
                    this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
                    return;
                }
                this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
                this.binding.declarationSirIncludedLayout.lvCategoryRadio.setVisibility(0);
            }
        }
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.homeImageView.setOnClickListener(this);
        this.binding.submitTv.setOnClickListener(this);
        this.binding.personalDetailButton.setOnClickListener(this);
        this.binding.authenticationButton.setOnClickListener(this);
        this.binding.dateOfBirthButton.setOnClickListener(this);
        this.binding.residenceDetailButton.setOnClickListener(this);
        this.binding.categoryOfDisabilityButton.setOnClickListener(this);
        this.binding.familyDetailsButton.setOnClickListener(this);
        this.binding.personImage.setOnClickListener(this);
        this.binding.dobSelectBtn.setOnClickListener(this);
        this.binding.addressSelectBtn.setOnClickListener(this);
        this.binding.categoryOfDisabilityCertificate.setOnClickListener(this);
        this.binding.annexureDIncludedLayout.annxureEditDetailButton.setOnClickListener(this);
        this.binding.declarationSirIncludedLayout.declarationEditDetailButton.setOnClickListener(this);
        this.binding.declarationSirIncludedLayout.decFormSignImage.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("refNo", this.referenceNo);
        bundle.putString("formType", this.formType);
        bundle.putInt("visitCount", this.visitCountId);
        bundle.putString("actionDate", this.actionDate);
        if (v.getId() == 2131362458) {
            openFragment(new CheckListMain());
            return;
        }
        if (v.getId() == 2131364064) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
            return;
        }
        if (v.getId() == 2131365939) {
            if (this.binding.noRb.isChecked()) {
                this.alertDialog.dismiss();
                getWorkFlowID();
                return;
            }
            if (isApplicantValidated()) {
                if (this.binding.absentRb.isChecked()) {
                    if (validateDateTime()) {
                        this.alertDialog.show();
                        json();
                        return;
                    }
                    return;
                }
                if (isBiharState() && TextUtils.isEmpty(this.citizenshipTypeCat) && validateAnnexure()) {
                    this.alertDialog.show();
                    json();
                    return;
                }
                if (isBiharState() && !TextUtils.isEmpty(this.citizenshipTypeCat)) {
                    this.alertDialog.show();
                    json();
                    return;
                } else if (!isBiharState()) {
                    this.alertDialog.show();
                    json();
                    return;
                } else {
                    if (isValideSIRState()) {
                        json();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (v.getId() == 2131365120) {
            this.selectedType = "Personal Details";
            Form6CheckListFragment form6CheckListFragment = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment.setArguments(bundle);
            openFragment(form6CheckListFragment);
            return;
        }
        if (v.getId() == 2131362440) {
            this.selectedType = "Authentication";
            Form6CheckListFragment form6CheckListFragment2 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment2.setArguments(bundle);
            openFragment(form6CheckListFragment2);
            return;
        }
        if (v.getId() == 2131363017) {
            this.selectedType = "DateOfBirth";
            Form6CheckListFragment form6CheckListFragment3 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment3.setArguments(bundle);
            openFragment(form6CheckListFragment3);
            return;
        }
        if (v.getId() == 2131365498) {
            this.selectedType = "ResidenceDetail";
            Form6CheckListFragment form6CheckListFragment4 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment4.setArguments(bundle);
            openFragment(form6CheckListFragment4);
            return;
        }
        if (v.getId() == 2131362674) {
            this.selectedType = "CategoryOfDisability";
            Form6CheckListFragment form6CheckListFragment5 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment5.setArguments(bundle);
            openFragment(form6CheckListFragment5);
            return;
        }
        if (v.getId() == 2131363779) {
            this.selectedType = "FamilyDetails";
            Form6CheckListFragment form6CheckListFragment6 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment6.setArguments(bundle);
            openFragment(form6CheckListFragment6);
            return;
        }
        if (v.getId() == 2131362370) {
            this.selectedType = "Annexure Details";
            Form6CheckListFragment form6CheckListFragment7 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment7.setArguments(bundle);
            openFragment(form6CheckListFragment7);
            return;
        }
        if (v.getId() == 2131363073) {
            this.selectedType = "Declaration Details";
            Form6CheckListFragment form6CheckListFragment8 = new Form6CheckListFragment();
            bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
            bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
            bundle.putSerializable("annexuredata", this.annexureModel);
            bundle.putString(this.selectedTypeBundle, this.selectedType);
            form6CheckListFragment8.setArguments(bundle);
            openFragment(form6CheckListFragment8);
            return;
        }
        if (v.getId() == 2131365112) {
            this.alertDialog.show();
            if (!this.checkListForm6Model.getPhotograph().trim().isEmpty()) {
                showPersonImageDialog(this.bitmapPersonImage);
                return;
            } else {
                this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.statusText, this.noDocumentAttached);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$48();
                    }
                }, 2000L);
                return;
            }
        }
        if (v.getId() == 2131363295) {
            if (!this.checkListForm6Model.getAgeProofDocument().trim().isEmpty()) {
                this.alertDialog.show();
                getAgeProffUploadedfilePersonalDetials(this.checkListForm6Model.getAgeProofDocument());
                return;
            } else {
                this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.statusText, this.noDocumentAttached);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$49();
                    }
                }, 2000L);
                return;
            }
        }
        if (v.getId() == 2131362241) {
            if (!this.checkListForm6Model.getCurrentAddressProofDocument().trim().isEmpty()) {
                this.alertDialog.show();
                getAddressProofUploadedfilePersonalDetials(this.checkListForm6Model.getCurrentAddressProofDocument());
                return;
            } else {
                this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.statusText, this.noDocumentAttached);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$50();
                    }
                }, 2000L);
                return;
            }
        }
        if (v.getId() == 2131362676) {
            if (!this.checkListForm6Model.getDisabilityCertificate().trim().isEmpty()) {
                this.alertDialog.show();
                getDisabilityCertificateDetials(this.checkListForm6Model.getDisabilityCertificate());
                return;
            } else {
                this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.statusText, this.noDocumentAttached);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$51();
                    }
                }, 2000L);
                return;
            }
        }
        if (v.getId() == 2131363041) {
            if (this.checkListForm6Model.getDecsirf6DeclSignature() != null && !this.checkListForm6Model.getDecsirf6DeclSignature().isEmpty()) {
                this.alertDialog.show();
                if (this.checkListForm6Model.getDecsirf6DeclSignature().endsWith(".pdf")) {
                    try {
                        showDeclarationPdfDialog(this.encodedDeclarationImage);
                        return;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                showDeclarationImageDialog(this.bitmapDeclarationFormImage);
                return;
            }
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.statusText, this.noDocumentAttached);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$52();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$48() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$49() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$50() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$51() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$52() {
        this.alertDialog.dismiss();
    }

    private void getWorkFlowID() {
        HashMap map = new HashMap();
        map.put("roleCode", "blo");
        map.put("formTypeMasterId", Integer.valueOf(this.checkListForm6Model.getProcessMasterId()));
        map.put("currentStatusId", Integer.valueOf(this.checkListForm6Model.getCurrentStatusId()));
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getWorkflowid("blo", this.stateCode, map).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.31
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = Form6.this.gson.toJsonTree(((JSONArray) response.body()).get(i)).getAsJsonObject();
                        String asString = asJsonObject.get("actionBtn").getAsString();
                        if (asString.equals("reinitiateToAero")) {
                            Logger.d(Form6.TAG, "workflow id : " + asJsonObject.get("workflowConfigId").getAsInt());
                            Form6.this.workflowConfigId = asJsonObject.get("workflowConfigId").getAsInt();
                            Form6.this.checkListForm6Model.setWorkflowConfigId(Form6.this.workflowConfigId);
                            Form6.this.reInitiateToAero();
                        } else if (!asString.equals("uploadFvr")) {
                            Form6.this.showdialog("Alert", "Something went wrong during reinitiate to Aero");
                        }
                    }
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(Form6.TAG, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(Form6.TAG, e2.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(Form6.TAG, "onFailureText" + t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reInitiateToAero() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtknC_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("formprocessingdetailsid", String.valueOf(this.formProcessingId));
        map.put("workflowconfigid", String.valueOf(this.checkListForm6Model.getWorkflowConfigId()));
        map.put("platform-type", "ANDROIDMOB");
        map.put("Authorization", this.token);
        Log.d(TAG, map.toString());
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("reInitiateToAero", "Y");
        map2.put("reInitiateRemark", "Blo assigned to wrong part");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).reInitiateToAero("blo", this.stateCode, this.formProcessingId, this.workflowConfigId, "ANDROIDMOB", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), map2).enqueue(new AnonymousClass32());
        this.commomUtility.showMessageWithTitleOK(requireContext(), this.statusText, "Form reInitated to AERO successfully.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda32
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$reInitiateToAero$53(dialogInterface, i);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$32, reason: invalid class name */
    class AnonymousClass32 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass32() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.isSuccessful()) {
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), Form6.this.statusText, "Form reInitated to AERO successfully.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$32$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reInitiateToAero$53(DialogInterface dialogInterface, int i) {
        openFragment(new CheckListMain());
    }

    private void showPersonImageDialog(Bitmap bitmapPersonImage) {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_person_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.person_image);
        ((TextView) dialog.findViewById(R.id.person_image_name)).setText(this.checkListForm6Model.getPhotograph());
        touchImageView.setImageBitmap(bitmapPersonImage);
        ((ImageView) dialog.findViewById(R.id.person_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonImageDialog$55();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonImageDialog$55() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAgeProofImageDialog(Bitmap bitmapAgeProofImage) {
        Logger.d(TAG, "bitmapAgeProofImagInShowImage " + bitmapAgeProofImage);
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_age_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.age_image);
        ((TextView) dialog.findViewById(R.id.age_image_name)).setText(this.checkListForm6Model.getAgeProofDocument());
        touchImageView.setImageBitmap(bitmapAgeProofImage);
        ((ImageView) dialog.findViewById(R.id.age_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAgeProofImageDialog$57();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAgeProofImageDialog$57() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAgeProofPdfDialog(String encodedAgeProofImage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_age_proof_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.age_proof_pdf_card).findViewById(R.id.age_proof_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.age_proof_pdf_card).findViewById(R.id.age_proof_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.age_proof_dialog_pdf_name);
        Logger.d(TAG, "encodedAgeProofImage " + encodedAgeProofImage);
        pDFViewFindViewById.fromBytes(Base64.decode(encodedAgeProofImage, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.checkListForm6Model.getAgeProofDocument().trim());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAgeProofPdfDialog$59();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAgeProofPdfDialog$59() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddressImageDialog(Bitmap bitmapAddressProofImage) {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_address_proof_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.address_proof_image);
        ((TextView) dialog.findViewById(R.id.address_proof_image_name)).setText(this.checkListForm6Model.getCurrentAddressProofDocument().trim());
        touchImageView.setImageBitmap(bitmapAddressProofImage);
        ((ImageView) dialog.findViewById(R.id.address_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAddressImageDialog$61();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddressImageDialog$61() {
        this.alertDialog.dismiss();
    }

    private void showDeclarationImageDialog(Bitmap bitmapDeclarationImage) {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_declaration_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.declaration_sign_image);
        ((TextView) dialog.findViewById(R.id.declaration_image_name)).setText(this.checkListForm6Model.getDecsirf6DeclSignature().trim());
        touchImageView.setImageBitmap(bitmapDeclarationImage);
        ((ImageView) dialog.findViewById(R.id.declaration_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDeclarationImageDialog$63();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeclarationImageDialog$63() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddressPdfDialog(String encodedAddressProofImage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_address_proof_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.address_proof_pdf_card).findViewById(R.id.address_proof_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.address_proof_pdf_card).findViewById(R.id.address_proof_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.address_proof_dialog_pdf_name);
        Logger.d(TAG, "encodedAddressProofImage " + encodedAddressProofImage);
        pDFViewFindViewById.fromBytes(Base64.decode(encodedAddressProofImage, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.checkListForm6Model.getCurrentAddressProofDocument().trim());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAddressPdfDialog$65();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddressPdfDialog$65() {
        this.alertDialog.dismiss();
    }

    private void showDeclarationPdfDialog(String encodedDeclarationImage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_declaration_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.declaration_pdf_card).findViewById(R.id.declaration_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.declaration_pdf_card).findViewById(R.id.declaration_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.declaration_dialog_pdf_name);
        Logger.d(TAG, "encodedDeclarationImage " + encodedDeclarationImage);
        pDFViewFindViewById.fromBytes(Base64.decode(encodedDeclarationImage, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.checkListForm6Model.getDecsirf6DeclSignature().trim());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDeclarationPdfDialog$67();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeclarationPdfDialog$67() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDisabilityImageDialog(Bitmap bitmapDisabilityImage) {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_disability_proof_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.disability_proof_image);
        ((TextView) dialog.findViewById(R.id.disability_proof_image_name)).setText(this.checkListForm6Model.getDisabilityCertificate().trim());
        touchImageView.setImageBitmap(bitmapDisabilityImage);
        ((ImageView) dialog.findViewById(R.id.disability_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDisabilityImageDialog$69();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDisabilityImageDialog$69() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRemarkVisibility() {
        if (this.checkListForm6Model.getPersonalDetailsSameOrNot() != null && this.checkListForm6Model.getPersonalDetailsSameOrNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getDateOfBirthSameOrNot() != null && this.checkListForm6Model.getDateOfBirthSameOrNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getAddressSameOrNot() != null && this.checkListForm6Model.getAddressSameOrNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getFamilyDetailsSameOrNot() != null && this.checkListForm6Model.getFamilyDetailsSameOrNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getDisabilityDetailsSameOrNot() != null && this.checkListForm6Model.getDisabilityDetailsSameOrNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getAnnexuredetsilsSameorNot() != null && this.checkListForm6Model.getAnnexuredetsilsSameorNot().equalsIgnoreCase("Y") && this.checkListForm6Model.getSetDeclarationSameOrNot() != null && this.checkListForm6Model.getSetDeclarationSameOrNot().equalsIgnoreCase("Y")) {
            this.binding.remark.setEnabled(true);
            this.binding.remarkll.setVisibility(8);
            this.binding.remark.setText(Constants.FOUND_CORRECT);
        } else {
            this.binding.remarkll.setVisibility(0);
            this.binding.remark.setText(Constants.FOUND_INCORRECT);
            this.binding.remark.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDisabilityPdfDialog(String encodedDisabilityProofImage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_disability_proof_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.disability_proof_pdf_card).findViewById(R.id.disability_proof_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.disability_proof_pdf_card).findViewById(R.id.disability_proof_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.disability_proof_dialog_pdf_name);
        Logger.d(TAG, "encodedDisabilityProofImage " + encodedDisabilityProofImage);
        pDFViewFindViewById.fromBytes(Base64.decode(encodedDisabilityProofImage, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.checkListForm6Model.getDisabilityCertificate().trim());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showDisabilityPdfDialog$71();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDisabilityPdfDialog$71() {
        this.alertDialog.dismiss();
    }

    private boolean isApplicantValidated() {
        this.binding.applicantNameOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.relativeOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.housenoOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.streetOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.townOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.tehsilOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        if (this.binding.partDetailRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify Pooling Station Details");
            return false;
        }
        if (!this.isCheckDSE.booleanValue()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please check DSE details matched or not");
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getFirstNameL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getFirstNameL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "First name ( " + this.checkListForm6Model.getFirstNameL1() + this.fieldName);
            this.binding.applicantNameOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getLastNameL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getLastNameL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Last name ( " + this.checkListForm6Model.getLastNameL1() + this.fieldName);
            this.binding.applicantNameOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getApplicantRelativeNameL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getApplicantRelativeNameL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Relative first name ( " + this.checkListForm6Model.getApplicantRelativeNameL1() + this.fieldName);
            this.binding.relativeOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getApplicantRelativeSurnameL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getApplicantRelativeSurnameL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Relative last name ( " + this.checkListForm6Model.getApplicantRelativeSurnameL1() + this.fieldName);
            this.binding.relativeOfficialTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.checkListForm6Model.getPhotograph() == null || this.checkListForm6Model.getPhotograph().trim().equals("null") || this.checkListForm6Model.getPhotograph().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please upload photograph.");
            return false;
        }
        if (this.checkListForm6Model.getAgeProofDocument() == null || this.checkListForm6Model.getAgeProofDocument().equals("null") || this.checkListForm6Model.getAgeProofDocument().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please upload proof of DOB.");
            return false;
        }
        if (this.checkListForm6Model.getAgeProofDocument().length() > 0 && this.checkListForm6Model.getAgeProofType().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please select Age Proof Document Type");
            return false;
        }
        if (this.checkListForm6Model.getAgeProofOthers().equals("Y") && this.checkListForm6Model.getAgeProofType().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please select Age Proof Document Type");
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getCurrentLocalityL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getCurrentLocalityL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Street ( " + this.fieldName + this.checkListForm6Model.getCurrentLocalityL1() + this.fieldName);
            this.binding.streetOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getCurrentVillageOrTownL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getCurrentVillageOrTownL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Village ( " + this.checkListForm6Model.getCurrentVillageOrTownL1() + this.fieldName);
            this.binding.townOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getCurrentPostOfficeL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getCurrentPostOfficeL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "PostOffice ( " + this.checkListForm6Model.getCurrentPostOfficeL1() + this.fieldName);
            this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getCurrentAddressTehL1()) && !Objects.equals(this.partLang, this.enIn) && this.checkListForm6Model.getCurrentAddressTehL1().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Tehsil ( " + this.checkListForm6Model.getCurrentAddressTehL1() + this.fieldName);
            this.binding.tehsilOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.checkListForm6Model.getCurrentAddressProofDocument() == null || this.checkListForm6Model.getCurrentAddressProofDocument().equals("null") || this.checkListForm6Model.getCurrentAddressProofDocument().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please upload address proof");
            return false;
        }
        if (this.checkListForm6Model.getCurrentAddressProofDocument().length() > 0 && this.checkListForm6Model.getCurrentAddressProofType().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please select Address Proof Document Type");
            return false;
        }
        if (this.checkListForm6Model.getAddressProofOthers().equals("Y") && this.checkListForm6Model.getCurrentAddressProofType().trim().isEmpty()) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please select Address Proof Document Type");
            return false;
        }
        if (this.binding.personalDetailRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please Verify Personal Details");
            return false;
        }
        if (this.binding.authenticationRadiogroup.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify Aadhaar Number");
            return false;
        }
        if (this.binding.dobRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify Date of Birth");
            return false;
        }
        if (this.binding.addressRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify house number");
            return false;
        }
        if (this.binding.familyDetailsRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify Family Details");
            return false;
        }
        if (this.checkListForm6Model.getDisabilityCertAttached().equals("Y") && this.checkListForm6Model.getDisabilityCertificate().trim().length() == 0) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please upload disability certificate");
            return false;
        }
        if (this.binding.infoRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify if applicant information matched");
            return false;
        }
        if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify if applicant was present");
            return false;
        }
        if (this.binding.detailsCorrectRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify if all details matched");
            return false;
        }
        if (this.binding.annexureVerification.getVisibility() == 0 && this.binding.annexureDetailRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify if all details matched");
            return false;
        }
        if (this.binding.annexureVerification.getVisibility() == 0 && this.anxDSignUrl == null) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please fill Annexure D details.");
            return false;
        }
        if (this.binding.sectionNoName.getSelectedItem().toString().equals(this.selectSectionNumber)) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", this.selectSectionNumber);
            return false;
        }
        if (this.binding.declarationVerification.getVisibility() == 0 && this.binding.declarationDetailRg.getCheckedRadioButtonId() == -1) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please verify if all details matched");
            return false;
        }
        if (this.binding.declarationVerification.getVisibility() == 0 && this.checkListForm6Model.getDecsirf6DeclSignature() == null) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please add signature in declaration form.");
            return false;
        }
        if (this.binding.declarationVerification.getVisibility() == 0 && this.checkListForm6Model.getDecsirf6DeclCategory() == null) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please add category in declaration form.");
            return false;
        }
        if (this.binding.declarationVerification.getVisibility() == 0 && this.checkListForm6Model.getFatherorGuardianname() == null) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please enter father name in declaration form.");
            return false;
        }
        if (this.binding.declarationVerification.getVisibility() == 0 && this.checkListForm6Model.getMotherName() == null) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please enter mother name in declaration form.");
            return false;
        }
        if (!this.binding.detailsNotCorrectRb.isChecked() || this.binding.remarkNo.getVisibility() != 0 || !this.binding.noremark.getText().toString().isEmpty()) {
            return true;
        }
        this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "ALERT", "Please enter remark and mention mismatch information.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, "Applicant Details");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void json() {
        Exception exc;
        String str;
        String str2;
        boolean z;
        Log.d(TAG, "SelectedSectionNameAndNumberModel ---> " + this.checkListForm6Model.getSectionNo());
        Log.d(TAG, "Section NumberJson ---> " + this.checkListForm6Model.getSectionNo());
        this.checkListForm6Model.setAsmblyConstituencyNo(this.asmblyNO);
        if (this.checkListForm6Model.getPrevDistrictNo() == null || Objects.equals(this.checkListForm6Model.getPrevDistrictNo(), "null") || this.checkListForm6Model.getPrevDistrictNo().isEmpty()) {
            this.checkListForm6Model.setPrevDistrictNo("0");
        }
        if (this.checkListForm6Model.getPrevPinCode() == null || Objects.equals(this.checkListForm6Model.getPrevPinCode(), "null") || this.checkListForm6Model.getPrevPinCode().isEmpty()) {
            this.checkListForm6Model.setPrevPinCode("000000");
        }
        this.checkListForm6Model.setReferenceNumber(this.referenceNo);
        this.checkListForm6Model.setIsReinitiated("Y");
        if (this.checkListForm6Model.getAgeProofType().length() > 0) {
            for (int i = 0; i < this.checkListForm6Model.getAgeProofList().size(); i++) {
                if (this.checkListForm6Model.getAgeProofType().equals(this.checkListForm6Model.getAgeProofList().get(i)) || this.checkListForm6Model.getAgeProofType().equals(this.checkListForm6Model.getAgeProofListCode().get(i))) {
                    CheckListForm6Model checkListForm6Model = this.checkListForm6Model;
                    checkListForm6Model.setAgeProofType(checkListForm6Model.getAgeProofListCode().get(i));
                }
            }
        }
        if (this.checkListForm6Model.getCurrentRelRelationship().length() > 0) {
            for (int i2 = 0; i2 < this.checkListForm6Model.getRelationList().size(); i2++) {
                if (this.checkListForm6Model.getCurrentRelRelationship().equals(this.checkListForm6Model.getRelationList().get(i2)) || this.checkListForm6Model.getCurrentRelRelationship().equals(this.checkListForm6Model.getRelationListCode().get(i2))) {
                    CheckListForm6Model checkListForm6Model2 = this.checkListForm6Model;
                    checkListForm6Model2.setCurrentRelRelationship(checkListForm6Model2.getRelationListCode().get(i2));
                }
            }
        }
        if (this.checkListForm6Model.getTypeOfRelation().length() > 0) {
            for (int i3 = 0; i3 < this.checkListForm6Model.getRelationList().size(); i3++) {
                if (this.checkListForm6Model.getTypeOfRelation().equals(this.checkListForm6Model.getRelationList().get(i3)) || this.checkListForm6Model.getTypeOfRelation().equals(this.checkListForm6Model.getRelationListCode().get(i3))) {
                    CheckListForm6Model checkListForm6Model3 = this.checkListForm6Model;
                    checkListForm6Model3.setTypeOfRelation(checkListForm6Model3.getRelationListCode().get(i3));
                }
            }
        }
        if (this.checkListForm6Model.getCurrentAddressProofType().length() > 0) {
            for (int i4 = 0; i4 < this.checkListForm6Model.getAddressPoofList().size(); i4++) {
                if (this.checkListForm6Model.getCurrentAddressProofType().equals(this.checkListForm6Model.getAddressPoofList().get(i4)) || this.checkListForm6Model.getCurrentAddressProofType().equals(this.checkListForm6Model.getAddressPoofListCode().get(i4))) {
                    CheckListForm6Model checkListForm6Model4 = this.checkListForm6Model;
                    checkListForm6Model4.setCurrentAddressProofType(checkListForm6Model4.getAddressPoofListCode().get(i4));
                }
            }
        }
        if (this.checkListForm6Model.getDisability().length() == 0) {
            this.checkListForm6Model.setDisability("N");
        }
        HashMap map = new HashMap();
        try {
            if (!this.checkListForm6Model.getAadharRefNo().trim().isEmpty()) {
                try {
                    map.put("aadharRefNo", this.checkListForm6Model.getAadharRefNo().trim());
                } catch (Exception e) {
                    exc = e;
                    String str3 = "ChecklistForm6JsonError ---> " + exc.getMessage();
                    str = TAG;
                    Logger.d(str, str3);
                    Logger.d(str, this.exception + exc.getMessage());
                }
            } else {
                map.put("aadharRefNo", null);
            }
            if (!this.checkListForm6Model.getAgeProofType().trim().isEmpty()) {
                map.put("ageProofType", this.checkListForm6Model.getAgeProofType().trim());
            } else {
                map.put("ageProofType", null);
            }
            if (!this.checkListForm6Model.getAgeProofOthers().trim().isEmpty()) {
                map.put("ageProofOthers", this.checkListForm6Model.getAgeProofOthers().trim());
            } else {
                map.put("ageProofOthers", null);
            }
            if (!this.checkListForm6Model.getApplicantGender().trim().isEmpty()) {
                map.put("applicantGender", this.checkListForm6Model.getApplicantGender().trim());
            } else {
                map.put("applicantGender", null);
            }
            if (!this.checkListForm6Model.getApplicantRelativeName().trim().isEmpty()) {
                map.put("applicantRelativeName", this.checkListForm6Model.getApplicantRelativeName().trim());
            } else {
                map.put("applicantRelativeName", null);
            }
            if (!this.checkListForm6Model.getApplicantRelativeSurname().trim().isEmpty()) {
                map.put("applicantRelativeSurname", this.checkListForm6Model.getApplicantRelativeSurname().trim());
            } else {
                map.put("applicantRelativeSurname", null);
            }
            if (!this.checkListForm6Model.getApplicantRelativeSurnameL1().trim().isEmpty()) {
                map.put("applicantRelativeSurnameL1", this.checkListForm6Model.getApplicantRelativeSurnameL1().trim().trim());
            } else {
                map.put("applicantRelativeSurnameL1", null);
            }
            if (!this.checkListForm6Model.getApplicantRelativeNameL1().trim().isEmpty()) {
                map.put("applicantRelativeNameL1", this.checkListForm6Model.getApplicantRelativeNameL1().trim());
            } else {
                map.put("applicantRelativeNameL1", null);
            }
            if (!this.checkListForm6Model.getAsmblyConstituencyNo().trim().isEmpty()) {
                map.put("asmblyConstituencyNo", this.checkListForm6Model.getAsmblyConstituencyNo().trim());
            } else {
                map.put("asmblyConstituencyNo", null);
            }
            if (!this.checkListForm6Model.getAgeProofDocument().trim().isEmpty()) {
                map.put("ageProofDocument", this.checkListForm6Model.getAgeProofDocument().trim());
            } else {
                map.put("ageProofDocument", null);
            }
            if (!this.checkListForm6Model.getApplicantDate().trim().isEmpty()) {
                map.put("applicantDate", this.checkListForm6Model.getApplicantDate().trim());
            } else {
                map.put("applicantDate", null);
            }
            if (!this.checkListForm6Model.getCurrentAddressProofDocument().trim().isEmpty()) {
                map.put("currentAddressProofDocument", this.checkListForm6Model.getCurrentAddressProofDocument().trim());
            } else {
                map.put("currentAddressProofDocument", null);
            }
            if (!this.checkListForm6Model.getCurrentAddressProofType().trim().isEmpty()) {
                map.put("currentAddressProofType", this.checkListForm6Model.getCurrentAddressProofType().trim());
            } else {
                map.put("currentAddressProofType", null);
            }
            if (!this.checkListForm6Model.getAddressProofOthers().trim().isEmpty()) {
                map.put("addressProofOthers", this.checkListForm6Model.getAddressProofOthers().trim());
            } else {
                map.put("addressProofOthers", null);
            }
            if (!this.checkListForm6Model.getCurrentAddressStayDate().trim().isEmpty()) {
                map.put("currentAddressStayDate", this.checkListForm6Model.getCurrentAddressStayDate().trim());
            } else {
                map.put("currentAddressStayDate", null);
            }
            if (!this.checkListForm6Model.getCurrentHouseNumber().trim().isEmpty()) {
                map.put("currentHouseNumber", this.checkListForm6Model.getCurrentHouseNumber().trim());
            } else {
                map.put("currentHouseNumber", null);
            }
            if (!this.checkListForm6Model.getCurrentHouseNumberL1().trim().isEmpty()) {
                map.put("currentHouseNumberL1", this.checkListForm6Model.getCurrentHouseNumberL1().trim().trim());
            } else {
                map.put("currentHouseNumberL1", null);
            }
            if (!this.checkListForm6Model.getCurrentLocality().trim().isEmpty()) {
                map.put("currentLocality", this.checkListForm6Model.getCurrentLocality().trim());
            } else {
                map.put("currentLocality", "NA");
            }
            if (!this.checkListForm6Model.getCurrentLocalityL1().trim().isEmpty()) {
                map.put("currentLocalityL1", this.checkListForm6Model.getCurrentLocalityL1().trim().trim());
            } else {
                map.put("currentLocalityL1", "NA");
            }
            if (!this.checkListForm6Model.getCurrentPinCode().trim().isEmpty()) {
                map.put("currentPinCode", this.checkListForm6Model.getCurrentPinCode().trim());
            } else {
                map.put("currentPinCode", null);
            }
            if (!this.checkListForm6Model.getCurrentPostOffice().trim().isEmpty()) {
                map.put("currentPostOffice", this.checkListForm6Model.getCurrentPostOffice().trim());
            } else {
                map.put("currentPostOffice", null);
            }
            if (!this.checkListForm6Model.getCurrentPostOfficeL1().trim().isEmpty()) {
                map.put("currentPostOfficeL1", this.checkListForm6Model.getCurrentPostOfficeL1().trim());
            } else {
                map.put("currentPostOfficeL1", null);
            }
            if (!this.checkListForm6Model.getCurrentStateCd().trim().isEmpty()) {
                map.put("currentStateCd", this.checkListForm6Model.getCurrentStateCd().trim());
            } else {
                map.put("currentStateCd", null);
            }
            if (!this.checkListForm6Model.getCurrentDistrictCd().trim().isEmpty()) {
                map.put("currentDistrictCd", this.checkListForm6Model.getCurrentDistrictCd().trim());
            } else {
                map.put("currentDistrictCd", null);
            }
            if (!this.checkListForm6Model.getCurrentVillageOrTown().trim().isEmpty()) {
                map.put("currentVillageOrTown", this.checkListForm6Model.getCurrentVillageOrTown().trim());
            } else {
                map.put("currentVillageOrTown", null);
            }
            if (!this.checkListForm6Model.getCurrentVillageOrTownL1().trim().isEmpty()) {
                map.put("currentVillageOrTownL1", this.checkListForm6Model.getCurrentVillageOrTownL1().trim());
            } else {
                map.put("currentVillageOrTownL1", null);
            }
            if (!this.checkListForm6Model.getCurrentRelRelationship().trim().isEmpty()) {
                map.put("currentRelRelationship", this.checkListForm6Model.getCurrentRelRelationship().trim());
            } else {
                map.put("currentRelRelationship", null);
            }
            if (!this.checkListForm6Model.getCurrentAddressTehTalMan().trim().isEmpty()) {
                map.put("currentAddressTeh", this.checkListForm6Model.getCurrentAddressTehTalMan().trim());
            } else {
                map.put("currentAddressTeh", null);
            }
            if (!this.checkListForm6Model.getCurrentAddressTehL1().trim().isEmpty()) {
                map.put("currentAddressTehL1", this.checkListForm6Model.getCurrentAddressTehL1().trim());
            } else {
                map.put("currentAddressTehL1", null);
            }
            if (!this.checkListForm6Model.getCurrentRelFullName().trim().isEmpty()) {
                map.put("currentRelFullName", this.checkListForm6Model.getCurrentRelFullName().trim());
            } else {
                map.put("currentRelFullName", null);
            }
            if (!this.checkListForm6Model.getCurrentRelEpic().trim().isEmpty()) {
                map.put("currentRelEpic", this.checkListForm6Model.getCurrentRelEpic().trim());
            } else {
                map.put("currentRelEpic", null);
            }
            if (!this.checkListForm6Model.getDeclrBirthDocName().trim().isEmpty()) {
                map.put("declrBirthDocName", this.checkListForm6Model.getDeclrBirthDocName().trim());
            } else {
                map.put("declrBirthDocName", null);
            }
            if (!this.checkListForm6Model.getDisabilityPercentage().trim().isEmpty()) {
                map.put("disabilityPercentage", this.checkListForm6Model.getDisabilityPercentage().trim());
            } else {
                map.put("disabilityPercentage", null);
            }
            if (!this.checkListForm6Model.getDisabilityCertificate().trim().isEmpty()) {
                map.put("disabilityCertificate", this.checkListForm6Model.getDisabilityCertificate().trim());
            } else {
                map.put("disabilityCertificate", null);
            }
            if (!this.checkListForm6Model.getDeclState().trim().isEmpty()) {
                map.put("declState", this.checkListForm6Model.getDeclState().trim());
            } else {
                map.put("declState", null);
            }
            if (!this.checkListForm6Model.getDisabilityTypeOthers().trim().isEmpty()) {
                map.put("disabilityTypeOthers", this.checkListForm6Model.getDisabilityTypeOthers().trim());
            } else {
                map.put("disabilityTypeOthers", null);
            }
            if (!this.checkListForm6Model.getDisabilityTypeLocomotor().trim().isEmpty()) {
                map.put("disabilityTypeLocomotor", this.checkListForm6Model.getDisabilityTypeLocomotor().trim());
            } else {
                map.put("disabilityTypeLocomotor", null);
            }
            if (!this.checkListForm6Model.getDisabilityTypeSh().trim().isEmpty()) {
                map.put("disabilityTypeSh", this.checkListForm6Model.getDisabilityTypeSh().trim());
            } else {
                map.put("disabilityTypeSh", null);
            }
            if (!this.checkListForm6Model.getDisabilityTypeVi().trim().isEmpty()) {
                map.put("disabilityTypeVi", this.checkListForm6Model.getDisabilityTypeVi().trim());
            } else {
                map.put("disabilityTypeVi", null);
            }
            if (!this.checkListForm6Model.getDisability().trim().isEmpty()) {
                map.put("disability", this.checkListForm6Model.getDisability().trim());
            } else {
                map.put("disability", "N");
            }
            if (!this.checkListForm6Model.getDisabilityCertAttached().trim().isEmpty()) {
                map.put("disabilityCertAttached", this.checkListForm6Model.getDisabilityCertAttached().trim());
            } else {
                map.put("disabilityCertAttached", null);
            }
            if (!this.checkListForm6Model.getDistrictCd().trim().isEmpty()) {
                map.put("districtCd", this.checkListForm6Model.getDistrictCd().trim());
            } else {
                map.put("districtCd", null);
            }
            if (!this.checkListForm6Model.getDob().trim().isEmpty()) {
                map.put("dob", this.checkListForm6Model.getDob().trim());
            } else {
                map.put("dob", null);
            }
            if (!this.checkListForm6Model.getOrdinaryResDate().trim().isEmpty()) {
                map.put("ordinaryResDate", this.checkListForm6Model.getOrdinaryResDate().trim());
            } else {
                map.put("ordinaryResDate", null);
            }
            if (!this.checkListForm6Model.getEmail().trim().isEmpty()) {
                map.put("emaildSelf", this.checkListForm6Model.getEmail().trim());
                map.put(this.emailString, this.checkListForm6Model.getEmail());
            } else {
                map.put("emaildSelf", null);
                map.put(this.emailString, this.checkListForm6Model.getEmail());
            }
            if (!this.checkListForm6Model.getFirstName().trim().isEmpty()) {
                map.put(Constants.FIRST_NAME, this.checkListForm6Model.getFirstName().trim());
            } else {
                map.put(Constants.FIRST_NAME, null);
            }
            if (!this.checkListForm6Model.getFirstNameL1().trim().isEmpty()) {
                map.put("firstNameL1", this.checkListForm6Model.getFirstNameL1().trim().trim());
            } else {
                map.put("firstNameL1", null);
            }
            if (!this.checkListForm6Model.getForm6Id().trim().isEmpty()) {
                map.put("form6Id", this.checkListForm6Model.getForm6Id().trim());
            } else {
                map.put("form6Id", null);
            }
            if (!this.checkListForm6Model.getFormSubmissionChannel().trim().isEmpty()) {
                map.put("formSubmissionChannel", this.checkListForm6Model.getFormSubmissionChannel().trim());
            } else {
                map.put("formSubmissionChannel", "BLOAPP");
            }
            if (!this.checkListForm6Model.getFormSubmissionMode().trim().isEmpty()) {
                map.put("formSubmissionMode", this.checkListForm6Model.getFormSubmissionMode().trim());
            } else {
                map.put("formSubmissionMode", "ONLINE");
            }
            if (!this.checkListForm6Model.getFormSubmissionDate().trim().isEmpty()) {
                map.put("formSubmissionDate", this.checkListForm6Model.getFormSubmissionDate().trim());
            } else {
                map.put("formSubmissionDate", null);
            }
            if (!this.checkListForm6Model.getFormSubmissionPlace().trim().isEmpty()) {
                map.put("formSubmissionPlace", this.checkListForm6Model.getFormSubmissionPlace().trim());
            } else {
                map.put("formSubmissionPlace", "N.A");
            }
            if (!this.checkListForm6Model.getIsDraft().trim().isEmpty()) {
                map.put("isDraft", this.checkListForm6Model.getIsDraft().trim());
            } else {
                map.put("isDraft", null);
            }
            if (!this.checkListForm6Model.getLastName().trim().isEmpty()) {
                map.put(Constants.LAST_NAME, this.checkListForm6Model.getLastName().trim());
            } else {
                map.put(Constants.LAST_NAME, null);
            }
            if (!this.checkListForm6Model.getLastNameL1().trim().isEmpty()) {
                map.put("lastNameL1", this.checkListForm6Model.getLastNameL1().trim());
            } else {
                map.put("lastNameL1", null);
            }
            if (!this.checkListForm6Model.getMobileNumber().trim().isEmpty()) {
                map.put("mobileNumberSelf", this.checkListForm6Model.getMobileNumber().trim());
                map.put(this.mobileNumberString, this.checkListForm6Model.getMobileNumber().trim());
            } else {
                map.put("mobileNumberSelf", null);
                map.put(this.mobileNumberString, null);
            }
            if (!this.checkListForm6Model.getPhotograph().trim().isEmpty()) {
                map.put("photograph", this.checkListForm6Model.getPhotograph().trim());
            } else {
                map.put("photograph", null);
            }
            if (!this.checkListForm6Model.getRelativeEmail().trim().isEmpty()) {
                map.put("emaildRelative", this.checkListForm6Model.getRelativeEmail().trim());
                map.put("relativeEmail", this.checkListForm6Model.getRelativeEmail().trim());
                map.put(this.emailString, this.checkListForm6Model.getRelativeEmail().trim());
            } else {
                map.put("emaildRelative", null);
                map.put("relativeEmail", null);
            }
            if (!this.checkListForm6Model.getStateCd().trim().isEmpty()) {
                map.put("stateCd", this.checkListForm6Model.getStateCd().trim());
            } else {
                map.put("stateCd", this.mSTATECODE);
            }
            if (!this.checkListForm6Model.getTypeOfRelation().trim().isEmpty()) {
                map.put("typeOfRelation", this.checkListForm6Model.getTypeOfRelation().trim());
            } else {
                map.put("typeOfRelation", null);
            }
            if (!this.checkListForm6Model.getReferenceNumber().trim().isEmpty()) {
                map.put("formRefNumber", this.checkListForm6Model.getReferenceNumber().trim());
            } else {
                map.put("formRefNumber", null);
            }
            if (!this.checkListForm6Model.getRelativeMobile().trim().isEmpty()) {
                map.put("mobileNumberOfRelative", this.checkListForm6Model.getRelativeMobile().trim());
                map.put("relativeMobile", this.checkListForm6Model.getRelativeMobile().trim());
                map.put(this.mobileNumberString, this.checkListForm6Model.getRelativeMobile().trim());
            } else {
                map.put("mobileNumberOfRelative", null);
                map.put("relativeMobile", null);
            }
            if (!this.checkListForm6Model.getIsReinitiated().trim().isEmpty()) {
                map.put("isReinitiated", this.checkListForm6Model.getIsReinitiated().trim());
            } else {
                map.put("isReinitiated", null);
            }
            map.put("isReinitiatedBy", "blo");
            if (!this.checkListForm6Model.getPartNumber().trim().isEmpty()) {
                map.put("partNumber", String.valueOf((int) Double.parseDouble(this.checkListForm6Model.getPartNumber())).trim());
            } else {
                map.put("partNumber", null);
            }
            if (!this.checkListForm6Model.getSectionNo().trim().isEmpty()) {
                map.put(this.sectionNo, Integer.valueOf(Integer.parseInt(this.checkListForm6Model.getSectionNo().trim())));
            } else {
                map.put(this.sectionNo, null);
            }
            try {
                if (isBiharState() && TextUtils.isEmpty(this.citizenshipTypeCat)) {
                    if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
                        map.put("ctDocOfSelfUrl", this.list1ref);
                        map.put("ctDocTypeForSelf", this.list1Code);
                        if (this.cat.equalsIgnoreCase("CAT-2")) {
                            map.put("isParentsIndian", "");
                            map.put("ctDocTypeForFather", "");
                            map.put("ctDocTypeForMother", "");
                            map.put("ctDocOfFatherUrl", "");
                            map.put("ctDocOfMotherUrl", "");
                        } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                            if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                                map.put("isParentsIndian", "Y");
                                map.put("ctDocTypeForFather", this.list3code);
                                map.put("ctDocTypeForMother", "");
                                map.put("ctDocOfFatherUrl", this.list3Ref);
                                map.put("ctDocOfMotherUrl", "");
                            } else if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                                map.put("isParentsIndian", "Y");
                                map.put("ctDocTypeForFather", "");
                                map.put("ctDocTypeForMother", this.list4code);
                                map.put("ctDocOfFatherUrl", "");
                                map.put("ctDocOfMotherUrl", this.list4Ref);
                            }
                        } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                            if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                                map.put("ctDocTypeForFather", this.list3code);
                                map.put("ctDocTypeForMother", this.list4code);
                                map.put("ctDocOfFatherUrl", this.list3Ref);
                                map.put("ctDocOfMotherUrl", this.list4Ref);
                                map.put("isParentsIndian", this.flagcat4scenerio1);
                            } else if (this.flagcat4scenerio1.equalsIgnoreCase("N") && (this.flagcat4scenerio2.equalsIgnoreCase("Y") || this.flagcat4scenerio3.equalsIgnoreCase("Y"))) {
                                map.put("isParentsIndian", "N");
                                if (this.motherNationality.equalsIgnoreCase("Non-Indian") && this.fatherNationality.equalsIgnoreCase("Indian")) {
                                    map.put("ctDocTypeForFather", this.list3code);
                                    map.put("ctDocTypeForMother", this.list5code);
                                    map.put("ctDocOfFatherUrl", this.list3Ref);
                                    map.put("ctDocOfMotherUrl", this.list5Ref);
                                } else if (this.fatherNationality.equalsIgnoreCase("Non-Indian") && this.motherNationality.equalsIgnoreCase("Indian")) {
                                    map.put("ctDocTypeForFather", this.list5code);
                                    map.put("ctDocTypeForMother", this.list4code);
                                    map.put("ctDocOfFatherUrl", this.list5Ref);
                                    map.put("ctDocOfMotherUrl", this.list4Ref);
                                }
                            }
                        }
                        str2 = TAG;
                    } else {
                        String str4 = this.choice;
                        str2 = TAG;
                        if (str4.equalsIgnoreCase(getString(R.string.not_born))) {
                            map.put("ctDocOfSelfUrl", this.list6ref);
                            map.put("ctDocTypeForSelf", this.list6code);
                            map.put("isParentsIndian", "");
                            map.put("ctDocTypeForFather", "");
                            map.put("ctDocTypeForMother", "");
                            map.put("ctDocOfFatherUrl", "");
                            map.put("ctDocOfMotherUrl", "");
                        } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                            map.put("ctDocOfSelfUrl", this.list7ref);
                            map.put("ctDocTypeForSelf", this.list7code);
                            map.put("isParentsIndian", "");
                            map.put("ctDocTypeForFather", "");
                            map.put("ctDocTypeForMother", "");
                            map.put("ctDocOfFatherUrl", "");
                            map.put("ctDocOfMotherUrl", "");
                        }
                    }
                    String str5 = this.anxDSignUrl;
                    if (str5 != null) {
                        map.put("anxDSignUrl", str5);
                    } else {
                        map.put("anxDSignUrl", "");
                    }
                    map.put("citizenshipType", this.choice);
                    map.put("citizenshipTypeCat", this.cat);
                } else {
                    str2 = TAG;
                    if (isBiharState() && !TextUtils.isEmpty(this.citizenshipTypeCat)) {
                        map.put("ctDocTypeForSelf", this.ctDocTypeForSelf);
                        map.put("isParentsIndian", this.isParentsIndian);
                        map.put("ctDocTypeForFather", this.ctDocTypeForFather);
                        map.put("ctDocTypeForMother", this.ctDocTypeForMother);
                        map.put("ctDocOfFatherUrl", this.ctDocOfFatherUrl);
                        map.put("ctDocOfMotherUrl", this.ctDocOfMotherUrl);
                        map.put("anxDSignUrl", this.anxDSignUrl);
                        map.put("citizenshipType", this.choice);
                        map.put("citizenshipTypeCat", this.cat);
                        map.put("ctDocOfSelfUrl", this.ctDocOfSelfUrl);
                    }
                }
                if (isValideSIRState()) {
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorStateCd())) {
                        map.put("electorStateCd", this.checkListForm6Model.getElectorStateCd());
                    } else {
                        map.put("electorStateCd", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorDistrictCd())) {
                        map.put("electorDistrictCd", this.checkListForm6Model.getElectorDistrictCd());
                    } else {
                        map.put("electorDistrictCd", null);
                    }
                    map.put("electorAcNo", this.checkListForm6Model.getElectorAcNo());
                    map.put("electorAssemblyName", this.checkListForm6Model.getElectorAssemblyName());
                    map.put("electorRelationShip", this.checkListForm6Model.getElectorRelationShip());
                    map.put("electorRelativeName", this.checkListForm6Model.getElectorRelativeName());
                    map.put("electorepicNumber", this.checkListForm6Model.getElectorepicNumber());
                    map.put("electorName", this.checkListForm6Model.getElectorName());
                    map.put("electorPartNumber", this.checkListForm6Model.getElectorPartNumber());
                    map.put("electorPartSerialNumber", this.checkListForm6Model.getElectorPartSerialNumber());
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeName())) {
                        map.put("relativeName", this.checkListForm6Model.getRelativeName());
                    } else {
                        map.put("relativeName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeEpicNumber())) {
                        map.put("relativeEpicNumber", this.checkListForm6Model.getRelativeEpicNumber());
                    } else {
                        map.put("relativeEpicNumber", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeRelativeName())) {
                        map.put("relativeRelativeName", this.checkListForm6Model.getRelativeRelativeName());
                    } else {
                        map.put("relativeRelativeName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeRelationShip())) {
                        map.put("relativeRelationShip", this.checkListForm6Model.getRelativeRelationShip());
                    } else {
                        map.put("relativeRelationShip", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeAcName())) {
                        map.put("relativeAcName", this.checkListForm6Model.getRelativeAcName());
                    } else {
                        map.put("relativeAcName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeAcNo())) {
                        map.put("relativeAcNo", this.checkListForm6Model.getRelativeAcNo());
                    } else {
                        map.put("relativeAcNo", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativePartNo())) {
                        map.put("relativePartNo", this.checkListForm6Model.getRelativePartNo());
                    } else {
                        map.put("relativePartNo", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativePartSerialNumber())) {
                        map.put("relativePartSerialNumber", this.checkListForm6Model.getRelativePartSerialNumber());
                    } else {
                        map.put("relativePartSerialNumber", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeStateCd())) {
                        map.put("relativeStateCd", this.checkListForm6Model.getRelativeStateCd());
                    } else {
                        map.put("relativeStateCd", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getRelativeDistrictCd())) {
                        map.put("relativeDistrictCd", this.checkListForm6Model.getRelativeDistrictCd());
                    } else {
                        map.put("relativeDistrictCd", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getFatherorGuardianname())) {
                        map.put("fatherOrGaurdianName", this.checkListForm6Model.getFatherorGuardianname());
                    } else {
                        map.put("fatherOrGaurdianName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getFatherorGuardianEpicNo())) {
                        map.put("fatherOrGaurdianEpicNumber", this.checkListForm6Model.getFatherorGuardianEpicNo());
                    } else {
                        map.put("fatherOrGaurdianEpicNumber", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getMotherName())) {
                        map.put("motherName", this.checkListForm6Model.getMotherName());
                    } else {
                        map.put("motherName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getMotherEpicNo())) {
                        map.put("motherEpicNumber", this.checkListForm6Model.getMotherEpicNo());
                    } else {
                        map.put("motherEpicNumber", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getSpouseEpicNo())) {
                        map.put("spouseEpicNumber", this.checkListForm6Model.getSpouseEpicNo());
                    } else {
                        map.put("spouseEpicNumber", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getSpouseName())) {
                        map.put("spouseName", this.checkListForm6Model.getSpouseName());
                    } else {
                        map.put("spouseName", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getDecsirf6DeclCategory())) {
                        map.put("declarationCategory", this.checkListForm6Model.getDecsirf6DeclCategory());
                    } else {
                        map.put("declarationCategory", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getDecsirf6DeclSignature())) {
                        map.put("declarationSignature", this.checkListForm6Model.getDecsirf6DeclSignature());
                    } else {
                        map.put("declarationSignature", null);
                    }
                    if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorsRelation())) {
                        map.put("electorsRelation", this.checkListForm6Model.getElectorsRelation());
                    } else {
                        map.put("electorsRelation", null);
                    }
                    map.put("isSir03", this.checkListForm6Model.getIsSir03());
                    map.put("isSir2526", this.checkListForm6Model.getIsSir2526());
                    map.put("isIndia", this.checkListForm6Model.getIsIndia());
                    if (this.checkListForm6Model.getIsIndia() != null && this.checkListForm6Model.getIsIndia().equalsIgnoreCase("Y")) {
                        if (!this.checkListForm6Model.getBirthStateCd().trim().isEmpty()) {
                            map.put("birthStateCd", this.checkListForm6Model.getBirthStateCd().trim());
                        } else {
                            map.put("birthStateCd", null);
                        }
                        if (!this.checkListForm6Model.getBirthDistrictNo().trim().isEmpty()) {
                            map.put("birthDistrictNo", this.checkListForm6Model.getBirthDistrictNo().trim());
                        } else {
                            map.put("birthDistrictNo", null);
                        }
                        if (!this.checkListForm6Model.getBirthVillage().trim().isEmpty()) {
                            map.put("birthVillage", this.checkListForm6Model.getBirthVillage().trim());
                            z = false;
                        } else {
                            z = false;
                            map.put("birthVillage", null);
                        }
                        map.put("placeOfBirthOutsideIndia", z);
                    } else if (this.checkListForm6Model.getIsIndia() != null && this.checkListForm6Model.getIsIndia().equalsIgnoreCase("N")) {
                        map.put("placeOfBirthOutsideIndia", this.checkListForm6Model.getPlaceOfBirthOutsideIndia());
                    } else {
                        if (!this.checkListForm6Model.getBirthStateCd().trim().isEmpty()) {
                            map.put("birthStateCd", this.checkListForm6Model.getBirthStateCd().trim());
                        } else {
                            map.put("birthStateCd", null);
                        }
                        if (!this.checkListForm6Model.getBirthDistrictNo().trim().isEmpty()) {
                            map.put("birthDistrictNo", this.checkListForm6Model.getBirthDistrictNo().trim());
                        } else {
                            map.put("birthDistrictNo", null);
                        }
                        if (!this.checkListForm6Model.getBirthVillage().trim().isEmpty()) {
                            map.put("birthVillage", this.checkListForm6Model.getBirthVillage().trim());
                        } else {
                            map.put("birthVillage", null);
                        }
                    }
                }
                str = str2;
            } catch (Exception e2) {
                e = e2;
                exc = e;
                String str6 = "ChecklistForm6JsonError ---> " + exc.getMessage();
                str = TAG;
                Logger.d(str, str6);
                Logger.d(str, this.exception + exc.getMessage());
            }
        } catch (Exception e3) {
            e = e3;
        }
        Logger.d(str, "Form6CheckListDataJsonObject " + new JSONObject(map));
        Logger.d(str, "token " + this.token);
        Logger.d(str, "atkn_bnd " + SharedPref.getInstance(requireContext()).getAtknBnd());
        Logger.d(str, "rtkn_bnd " + SharedPref.getInstance(requireContext()).getRtknBnd());
        Logger.d(str, "channelidobo " + this.channelidobo);
        Logger.d(str, "state " + this.stateCode);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).submitform6(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.stateCode, "application/json", "ANDROIMOB", map).enqueue(new AnonymousClass33());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        AnonymousClass33() {
        }

        public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
            if (response.code() == 200) {
                Logger.d(Form6.TAG, "Form_Submitted_SuccessFully_1");
                Form6.this.generatedReferenceNumber = String.valueOf(((JsonObject) response.body()).get("referenceNo"));
                Logger.d(Form6.TAG, "PayloadOFChecklistAfterSumision  " + response.body());
                Log.d(Form6.TAG, "generatedReferenceNumber_Form " + Form6.this.generatedReferenceNumber);
                String str = Form6.this.binding.absentRb.isChecked() ? "Y" : "N";
                String str2 = Form6.this.binding.deadRb.isChecked() ? "Y" : "N";
                String str3 = Form6.this.binding.nosuchpersonRb.isChecked() ? "Y" : "N";
                String str4 = Form6.this.binding.availableRb.isChecked() ? "Y" : "N";
                String str5 = Form6.this.binding.shiftedRb.isChecked() ? "Y" : "N";
                final HashMap map = new HashMap();
                map.put("fieldVerificationVerifiedAndCorrect", Form6.this.fieldVerificationVerifiedAndCorrect);
                map.put("fieldVerificationDataEntryErrors", "N");
                map.put("fieldVerificationAddress", Form6.this.fieldVerificationAddress);
                map.put("fieldVerificationDobOrAge", Form6.this.fieldVerificationDobOrAge);
                map.put("fieldVerificationPhoto", Form6.this.fieldVerificationPhoto);
                map.put("fieldVerificationAbsent", str.trim());
                map.put("fieldVerificationDead", str2.trim());
                map.put("fieldVerificationNoSuchPerson", str3.trim());
                map.put("fieldVerificationPersonPresent", str4.trim());
                map.put("fieldVerificationShifted", str5.trim());
                map.put("fieldVerificationAlreadyAppliedCount", 0);
                map.put("fieldPertainingPolling", Form6.this.fieldPertainingPolling);
                map.put("fieldDeclarationForm", Form6.this.fieldDeclarationForm);
                map.put("fieldCategoryDisability", Form6.this.fieldCategoryDisability);
                map.put("fieldFamilyDetails", Form6.this.fieldFamilyDetails);
                if (Form6.this.binding.remarkll.getVisibility() == 0) {
                    map.put("fieldVerificationRemark", Form6.this.binding.remark.getText().toString().trim() + " " + Form6.this.binding.anyotherremark.getText().toString());
                } else {
                    map.put("fieldVerificationRemark", Form6.this.binding.remark.getText().toString().trim());
                }
                map.put("fieldVerificationUnderAge", "N");
                map.put("fieldVerificationAlreadyEnrolled", "N");
                map.put("fieldVerificationNotIndianCitizen", "N");
                map.put("correctionOfAddress", "N");
                map.put("correctionOfDobAge", "N");
                map.put("correctionOfGender", "N");
                map.put("correctionOfMobile", "N");
                map.put("correctionOfName", "N");
                map.put("correctionOfPhotograpgh", "N");
                map.put("correctionOfRelation", "N");
                map.put("correctionOfRelative", "N");
                map.put(Form6.this.sectionNo, Form6.this.checkListForm6Model.getSectionNo().trim());
                map.put("fieldVerificationChecklist", null);
                if (Form6.this.binding.remarkNo.getVisibility() == 0) {
                    map.put("docMismatchRemark", Form6.this.binding.noremark.getText().toString().trim());
                } else {
                    map.put("docMismatchRemark", null);
                }
                map.put("visitCount", Integer.valueOf(Form6.this.visitCountId));
                map.put("bloVerifiedDSE", Form6.this.dse_undertaking);
                if (Form6.this.selectedDataItem != null) {
                    map.put("dseMatchedAc", Integer.valueOf(Form6.this.selectedDataItem.getAcNumber()));
                    map.put("dseMatchedEpic", Form6.this.selectedDataItem.getEpicNumber());
                    map.put("dseMatchedPart", Integer.valueOf(Form6.this.selectedDataItem.getPartNumber()));
                    map.put("dseMatchedPhotoUrl", Form6.this.selectedDataItem.getPhoto());
                    map.put("dseMatchedStateCd", Form6.this.selectedDataItem.getStateCd());
                    if (Form6.this.selectedDataItem.getUnderJo() > 0) {
                        map.put("underJo", Integer.valueOf(Form6.this.selectedDataItem.getUnderJo()));
                    } else {
                        map.put("underJo", null);
                    }
                } else {
                    map.put("dseMatchedAc", null);
                    map.put("dseMatchedEpic", null);
                    map.put("dseMatchedPart", null);
                    map.put("dseMatchedPhotoUrl", null);
                    map.put("dseMatchedStateCd", null);
                    map.put("underJo", null);
                }
                map.put("latitude", Form6.this.lat);
                map.put("longitude", Form6.this.longi);
                Log.d(Form6.TAG, "checkListForm6Model_visitCount" + Form6.this.visitCountId);
                Logger.d(Form6.TAG, "FVR stateCode " + Form6.this.stateCode + " processMasterId " + Form6.this.checkListForm6Model.getProcessMasterId() + " currentStatus_Id " + Form6.this.checkListForm6Model.getCurrentStatusId());
                Form6.this.commomUtility.getWorkflowid(Form6.this.getContext(), Form6.this.stateCode, Form6.this.checkListForm6Model.getProcessMasterId(), Form6.this.checkListForm6Model.getCurrentStatusId(), Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str6) {
                        this.f$0.lambda$onResponse$0(map, response, i, str6);
                    }
                });
                return;
            }
            if (response.code() == 401) {
                Form6.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Form6 form6 = Form6.this;
                form6.errorResponse = jSONObject.optString(form6.message);
                Log.d(Form6.TAG, "Form 6 Error" + Form6.this.errorResponse);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Submission Error - " + response.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i);
                    }
                });
            } catch (IOException | JSONException e) {
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Submission Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$3(dialogInterface, i);
                    }
                });
                Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(HashMap map, Response response, int i, String str) {
            Form6.this.workflowConfigId = Integer.parseInt(str);
            Form6.this.checkListForm6Model.setWorkflowConfigId(Form6.this.workflowConfigId);
            Log.d(Form6.TAG, "Form6CheckListDataJsonObject_FVR " + new JSONObject(map));
            Logger.d(Form6.TAG, "workflowConfigId " + Form6.this.checkListForm6Model.getWorkflowConfigId() + " formProcessingId " + Form6.this.checkListForm6Model.getFormProcessingId());
            Form6.this.commomUtility.getRetrofitClient(Form6.this.getContext(), Form6.this.token, SharedPref.getInstance(Form6.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Form6.this.requireContext()).getRtknBnd()).formProcessingService(Form6.this.mSTATECODE, "blo", Form6.this.workflowConfigId, Form6.this.checkListForm6Model.getFormProcessingId(), "ANDROIDMOB", map).enqueue(new AnonymousClass1(response));
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<Void> {
            final /* synthetic */ Response val$response;

            AnonymousClass1(final Response val$response) {
                this.val$response = val$response;
            }

            public void onResponse(Call<Void> call1, Response<Void> response1) {
                if (response1.code() == 200) {
                    Logger.d(Form6.TAG, "Form_Submitted_SuccessFully_2");
                    Logger.d(Form6.TAG, "FVR_Form_Submitted_SuccessFully_2");
                    try {
                        FileUtils.deleteDirectory(new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/"));
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onResponse$0();
                            }
                        }, 2000L);
                    } catch (IOException e) {
                        Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onResponse$1();
                            }
                        }, 2000L);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    }, 2000L);
                    Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), Form6.this.statusText, "Verified Successfully.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$3(dialogInterface, i);
                        }
                    });
                    return;
                }
                if (this.val$response.code() == 401) {
                    Form6.this.refreshTokenApi();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response1.errorBody().string());
                    Form6.this.errorResponse = jSONObject.optString(Form6.this.message);
                    Log.d(Form6.TAG, "jsonObject :" + jSONObject);
                    Log.d(Form6.TAG, "Form_6_FVR_FORM_SUBMITTION_Error" + Form6.this.errorResponse);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$4();
                        }
                    }, 2000L);
                    Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 FVR Submission Error - " + response1.code(), Form6.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$5(dialogInterface, i);
                        }
                    });
                } catch (IOException | JSONException e2) {
                    Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 FVR Submission Error - " + response1.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda6
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$6(dialogInterface, i);
                        }
                    });
                    Logger.d(Form6.TAG, Form6.this.exception + e2.getMessage());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$2() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$4() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$6(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }

            public void onFailure(Call<Void> call1, Throwable t) {
                Logger.d(Form6.TAG, "OnFailure_of_rev_response " + t.getMessage());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onFailure$7();
                    }
                }, 2000L);
                Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 FVR Submission Error ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$1$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onFailure$8(dialogInterface, i);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onFailure$7() {
                Form6.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onFailure$8(DialogInterface dialogInterface, int i) {
                Form6.this.openFragment(new CheckListMain());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            Form6.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$4() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$4();
                }
            }, 2000L);
            Form6.this.commomUtility.showMessageWithTitleOK(Form6.this.requireContext(), "Form 6 Submission Error", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$33$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onFailure$5(dialogInterface, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$5(DialogInterface dialogInterface, int i) {
            Form6.this.openFragment(new CheckListMain());
        }
    }

    private void getPersonImageUploadedfilePersonalDetials(String fileName) {
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        String str = this.objectStorage;
        Logger.d(this.getToken, this.token);
        userClient.getFile(str, fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass34());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<JsonObject> {
        AnonymousClass34() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Log.d(Form6.TAG, "error in image" + jsonObject.get("file"));
                Form6.this.bitmapPersonImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(String.valueOf(jsonObject.get("file")).replace(RegexMatcher.JSON_STRING_REGEX, ""), 0)));
                Form6.this.binding.personImage.setImageBitmap(Form6.this.bitmapPersonImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$34$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                Form6.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6.TAG, Form6.this.errorApi + response.errorBody());
                Form6 form6 = Form6.this;
                form6.errorResponse = jSONObject.optString(form6.message);
                Log.d(Form6.TAG, Form6.this.imageError + Form6.this.errorResponse);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$34$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
            } catch (IOException | JSONException e) {
                Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
        }
    }

    private void getAgeProffUploadedfilePersonalDetials(String fileName) {
        Logger.d(TAG, "AgeProofDocumentNameFromAPI --- >" + fileName);
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        String str = this.objectStorage;
        Logger.d(this.getToken, this.token);
        userClient.getFile(str, fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass35());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        AnonymousClass35() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                String strReplace = String.valueOf(((JsonObject) response.body()).get("file")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (Form6.this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(Form6.this.jpg) || Form6.this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(Form6.this.jpeg) || Form6.this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(Form6.this.png) || Form6.this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(Form6.this.jfif)) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(strReplace, 0));
                    Logger.d(Form6.TAG, "inputStream " + byteArrayInputStream);
                    Form6.this.bitmapAgeProofImage = BitmapFactory.decodeStream(byteArrayInputStream);
                    Form6 form6 = Form6.this;
                    form6.showAgeProofImageDialog(form6.bitmapAgeProofImage);
                    Logger.d(Form6.TAG, "bitmapAgeProofImagInApi " + Form6.this.bitmapAgeProofImage);
                    return;
                }
                if (Form6.this.checkListForm6Model.getAgeProofDocument().toLowerCase().contains(".pdf")) {
                    Form6.this.encodedAgeProofImage = strReplace;
                    try {
                        Form6 form7 = Form6.this;
                        form7.showAgeProofPdfDialog(form7.encodedAgeProofImage);
                        return;
                    } catch (IOException e) {
                        Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                        return;
                    }
                }
                return;
            }
            if (response.code() == 401) {
                Form6.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6.TAG, Form6.this.errorApi + response.errorBody());
                Form6 form8 = Form6.this;
                form8.errorResponse = jSONObject.optString(form8.message);
                Log.d(Form6.TAG, Form6.this.imageError + Form6.this.errorResponse);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$35$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Form6.this.commomUtility.displayAlertWithTitleAndMessage(Form6.this.requireContext(), "Form 6 Age Document Download Api Error - " + response.code(), Form6.this.errorResponse);
            } catch (IOException | JSONException e2) {
                Logger.d(Form6.TAG, Form6.this.exception + e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
        }
    }

    private void getDisabilityCertificateDetials(String fileName) {
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        String str = this.objectStorage;
        Logger.d(this.getToken, this.token);
        userClient.getFile(str, fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass36());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        AnonymousClass36() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                String strReplace = String.valueOf(((JsonObject) response.body()).get("file")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (Form6.this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(Form6.this.jpg) || Form6.this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(Form6.this.jpeg) || Form6.this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(Form6.this.png) || Form6.this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(Form6.this.jfif)) {
                    Form6.this.bitmapDisabilityImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(strReplace, 0)));
                    Form6 form6 = Form6.this;
                    form6.showDisabilityImageDialog(form6.bitmapDisabilityImage);
                    return;
                }
                if (Form6.this.checkListForm6Model.getDisabilityCertificate().toLowerCase().contains(".pdf")) {
                    Form6.this.encodedDisabilityProofImage = strReplace;
                    try {
                        Form6 form7 = Form6.this;
                        form7.showDisabilityPdfDialog(form7.encodedDisabilityProofImage);
                        return;
                    } catch (IOException e) {
                        Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                        return;
                    }
                }
                return;
            }
            if (response.code() == 401) {
                Form6.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6.TAG, Form6.this.errorApi + response.errorBody());
                Form6 form8 = Form6.this;
                form8.errorResponse = jSONObject.optString(form8.message);
                Log.d(Form6.TAG, Form6.this.imageError + Form6.this.errorResponse);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$36$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Form6.this.commomUtility.displayAlertWithTitleAndMessage(Form6.this.requireContext(), "Form 6 Disability Document Download Api Error - " + response.code(), Form6.this.errorResponse);
            } catch (IOException | JSONException e2) {
                Logger.d(Form6.TAG, Form6.this.exception + e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
        }
    }

    private void getAddressProofUploadedfilePersonalDetials(String fileName) {
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        String str = this.objectStorage;
        Logger.d(this.getToken, this.token);
        userClient.getFile(str, fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass37());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$37, reason: invalid class name */
    class AnonymousClass37 implements Callback<JsonObject> {
        AnonymousClass37() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                String strReplace = String.valueOf(((JsonObject) response.body()).get("file")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (Form6.this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(Form6.this.jpg) || Form6.this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(Form6.this.jpeg) || Form6.this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(Form6.this.png) || Form6.this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(Form6.this.jfif)) {
                    Form6.this.bitmapAddressProofImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(strReplace, 0)));
                    Form6 form6 = Form6.this;
                    form6.showAddressImageDialog(form6.bitmapAddressProofImage);
                    return;
                }
                if (Form6.this.checkListForm6Model.getCurrentAddressProofDocument().toLowerCase().contains(".pdf")) {
                    Form6.this.encodedAddressProofImage = strReplace;
                    try {
                        Form6 form7 = Form6.this;
                        form7.showAddressPdfDialog(form7.encodedAddressProofImage);
                        return;
                    } catch (IOException e) {
                        Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                        return;
                    }
                }
                return;
            }
            if (response.code() == 401) {
                Form6.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6.TAG, Form6.this.errorApi + response.errorBody());
                Form6 form8 = Form6.this;
                form8.errorResponse = jSONObject.optString(form8.message);
                Log.d(Form6.TAG, Form6.this.imageError + Form6.this.errorResponse);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$37$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Form6.this.commomUtility.displayAlertWithTitleAndMessage(Form6.this.requireContext(), "Form 6 Address Document Download Api Error - " + response.code(), Form6.this.errorResponse);
            } catch (IOException | JSONException e2) {
                Logger.d(Form6.TAG, Form6.this.exception + e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
        }
    }

    private void getDeclarationFormUploadedSign(String fileName) {
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        String str = this.objectStorage;
        Logger.d(this.getToken, this.token);
        userClient.getFile(str, fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass38());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$38, reason: invalid class name */
    class AnonymousClass38 implements Callback<JsonObject> {
        AnonymousClass38() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    Form6.this.refreshTokenApi();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    Log.d(Form6.TAG, Form6.this.errorApi + response.errorBody());
                    Form6 form6 = Form6.this;
                    form6.errorResponse = jSONObject.optString(form6.message);
                    Log.d(Form6.TAG, Form6.this.imageError + Form6.this.errorResponse);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$38$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    Form6.this.commomUtility.displayAlertWithTitleAndMessage(Form6.this.requireContext(), "Form 6 Declaration Document Download Api Error - " + response.code(), Form6.this.errorResponse);
                    return;
                } catch (IOException | JSONException e) {
                    Logger.d(Form6.TAG, Form6.this.exception + e.getMessage());
                    return;
                }
            }
            String strReplace = String.valueOf(((JsonObject) response.body()).get("file")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            if (Form6.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(Form6.this.jpg) || Form6.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(Form6.this.jpeg) || Form6.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(Form6.this.png) || Form6.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(Form6.this.jfif)) {
                Form6.this.bitmapDeclarationFormImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(strReplace, 0)));
                Form6.this.binding.declarationSirIncludedLayout.decFormSignImage.setImageBitmap(Form6.this.bitmapDeclarationFormImage);
                return;
            }
            if (Form6.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(".pdf")) {
                Form6.this.encodedDeclarationImage = strReplace;
                Form6.this.binding.declarationSirIncludedLayout.decFormSignImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6.TAG, Form6.this.comingInOnFailure + t.getMessage());
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        CheckListForm6OrignalDataModel checkListForm6OrignalDataModel = this.checkListForm6OrignalDataModel;
        if (checkListForm6OrignalDataModel != null) {
            if (checkListForm6OrignalDataModel.getFirstName() == null || this.checkListForm6OrignalDataModel.getFirstName().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setFirstName("");
            }
            if (this.checkListForm6OrignalDataModel.getFirstNameL1() == null || this.checkListForm6OrignalDataModel.getFirstNameL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setFirstNameL1("");
            }
            if (this.checkListForm6OrignalDataModel.getFirstNameL2() == null || this.checkListForm6OrignalDataModel.getFirstNameL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setFirstNameL2("");
            }
            if (this.checkListForm6OrignalDataModel.getLastName() == null || this.checkListForm6OrignalDataModel.getLastName().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setLastName("");
            }
            if (this.checkListForm6OrignalDataModel.getLastNameL1() == null || this.checkListForm6OrignalDataModel.getLastNameL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setLastNameL1("");
            }
            if (this.checkListForm6OrignalDataModel.getLastNameL2() == null || this.checkListForm6OrignalDataModel.getLastNameL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setLastNameL2("");
            }
            if (this.checkListForm6OrignalDataModel.getRelativeMobile() == null || this.checkListForm6OrignalDataModel.getRelativeMobile().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setRelativeMobile("");
            }
            if (this.checkListForm6OrignalDataModel.getRelativeEmail() == null || this.checkListForm6OrignalDataModel.getRelativeEmail().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setRelativeEmail("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeName() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeName().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeName("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeSurname() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeSurname().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeSurname("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL1() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeSurnameL1("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL2() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeSurnameL2("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeNameL1() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeNameL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeNameL1("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeNameL2() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeNameL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeNameL2("");
            }
            if (this.checkListForm6OrignalDataModel.getMobileNumber() == null || this.checkListForm6OrignalDataModel.getMobileNumber().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setMobileNumber("");
            }
            if (this.checkListForm6OrignalDataModel.getEmail() == null || this.checkListForm6OrignalDataModel.getEmail().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setEmail("");
            }
            if (this.checkListForm6OrignalDataModel.getAadharNumber() == null || this.checkListForm6OrignalDataModel.getAadharNumber().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setAadharNumber("");
            }
            if (this.checkListForm6OrignalDataModel.getAadharRefNo() == null || this.checkListForm6OrignalDataModel.getAadharRefNo().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setAadharRefNo("");
            }
            if (this.checkListForm6OrignalDataModel.getAgeAtFormSubmission() == null || this.checkListForm6OrignalDataModel.getAgeAtFormSubmission().trim().equals("null") || this.checkListForm6OrignalDataModel.getAgeAtFormSubmission().isEmpty()) {
                this.checkListForm6OrignalDataModel.setAgeAtFormSubmission("");
            }
            if (this.checkListForm6OrignalDataModel.getDob() == null || this.checkListForm6OrignalDataModel.getDob().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDob("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentHouseNumber() == null || this.checkListForm6OrignalDataModel.getCurrentHouseNumber().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentHouseNumber("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentHouseNumberL1() == null || this.checkListForm6OrignalDataModel.getCurrentHouseNumberL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentHouseNumberL1("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentHouseNumberL2() == null || this.checkListForm6OrignalDataModel.getCurrentHouseNumberL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentHouseNumberL2("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentLocality() == null || this.checkListForm6OrignalDataModel.getCurrentLocality().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentLocality("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentLocalityL1() == null || this.checkListForm6OrignalDataModel.getCurrentLocalityL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentLocalityL1("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentLocalityL2() == null || this.checkListForm6OrignalDataModel.getCurrentLocalityL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentLocalityL2("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentVillageOrTown() == null || this.checkListForm6OrignalDataModel.getCurrentVillageOrTown().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentVillageOrTown("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentVillageOrTownL1() == null || this.checkListForm6OrignalDataModel.getCurrentVillageOrTownL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentVillageOrTownL1("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentVillageOrTownL2() == null || this.checkListForm6OrignalDataModel.getCurrentVillageOrTownL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentVillageOrTownL2("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentPostOffice() == null || this.checkListForm6OrignalDataModel.getCurrentPostOffice().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentPostOffice("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentPostOfficeL1() == null || this.checkListForm6OrignalDataModel.getCurrentPostOfficeL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentPostOfficeL1("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentPostOfficeL2() == null || this.checkListForm6OrignalDataModel.getCurrentPostOfficeL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentPostOfficeL2("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentPinCode() == null || this.checkListForm6OrignalDataModel.getCurrentPinCode().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentPinCode("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentAddressTehTalMan() == null || this.checkListForm6OrignalDataModel.getCurrentAddressTehTalMan().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentAddressTehTalMan("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentAddressTehL1() == null || this.checkListForm6OrignalDataModel.getCurrentAddressTehL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentAddressTehL1("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentAddressTehL2() == null || this.checkListForm6OrignalDataModel.getCurrentAddressTehL2().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentAddressTehL2("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityPercentage() == null || this.checkListForm6OrignalDataModel.getDisabilityPercentage().trim().equals("null") || this.checkListForm6OrignalDataModel.getDisabilityPercentage().isEmpty()) {
                this.checkListForm6OrignalDataModel.setDisabilityPercentage("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentRelFullName() == null || this.checkListForm6OrignalDataModel.getCurrentRelFullName().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentRelFullName("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentRelEpic() == null || this.checkListForm6OrignalDataModel.getCurrentRelEpic().isEmpty() || this.checkListForm6OrignalDataModel.getCurrentRelEpic().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentRelEpic("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentRelRelationship() == null || this.checkListForm6OrignalDataModel.getCurrentRelRelationship().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentRelRelationship("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityTypeLocomotor() == null || this.checkListForm6OrignalDataModel.getDisabilityTypeLocomotor().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisabilityTypeLocomotor("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityTypeOthers() == null || this.checkListForm6OrignalDataModel.getDisabilityTypeOthers().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisabilityTypeOthers("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityTypeSh() == null || this.checkListForm6OrignalDataModel.getDisabilityTypeSh().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisabilityTypeSh("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentAddressProofType() == null || this.checkListForm6OrignalDataModel.getCurrentAddressProofType().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setCurrentAddressProofType("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityTypeVi() == null || this.checkListForm6OrignalDataModel.getDisabilityTypeVi().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisabilityTypeVi("");
            }
            if (this.checkListForm6OrignalDataModel.getTypeOfRelation() == null || this.checkListForm6OrignalDataModel.getTypeOfRelation().trim().equals("null") || this.checkListForm6OrignalDataModel.getTypeOfRelation().isEmpty()) {
                this.checkListForm6OrignalDataModel.setTypeOfRelation("");
            }
            if (this.checkListForm6OrignalDataModel.getPhotograph() != null) {
                if (this.checkListForm6OrignalDataModel.getPhotograph().toLowerCase().contains(this.jpg) || this.checkListForm6OrignalDataModel.getPhotograph().toLowerCase().contains(this.jpeg) || this.checkListForm6OrignalDataModel.getPhotograph().toLowerCase().contains(this.png) || this.checkListForm6OrignalDataModel.getPhotograph().toLowerCase().contains(this.jfif)) {
                    Log.d(TAG, this.nothingToDo);
                } else {
                    this.checkListForm6OrignalDataModel.setPhotograph("");
                }
            } else {
                this.checkListForm6OrignalDataModel.setPhotograph("");
            }
            if (this.checkListForm6OrignalDataModel.getAgeProofDocument() != null) {
                if (this.checkListForm6OrignalDataModel.getAgeProofDocument().toLowerCase().contains(this.jpg) || this.checkListForm6OrignalDataModel.getAgeProofDocument().toLowerCase().contains(this.jpeg) || this.checkListForm6OrignalDataModel.getAgeProofDocument().toLowerCase().contains(this.png) || this.checkListForm6OrignalDataModel.getAgeProofDocument().toLowerCase().contains(this.jfif) || this.checkListForm6OrignalDataModel.getAgeProofDocument().toLowerCase().contains(".pdf")) {
                    Log.d(TAG, this.nothingToDo);
                } else {
                    this.checkListForm6OrignalDataModel.setAgeProofDocument("");
                }
            } else {
                this.checkListForm6OrignalDataModel.setAgeProofDocument("");
            }
            if (this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument() != null) {
                if (this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument().toLowerCase().contains(this.jpg) || this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument().toLowerCase().contains(this.jpeg) || this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument().toLowerCase().contains(this.png) || this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument().toLowerCase().contains(this.jfif) || this.checkListForm6OrignalDataModel.getCurrentAddressProofDocument().toLowerCase().contains(".pdf")) {
                    Log.d(TAG, this.nothingToDo);
                } else {
                    this.checkListForm6OrignalDataModel.setCurrentAddressProofDocument("");
                }
            } else {
                this.checkListForm6OrignalDataModel.setCurrentAddressProofDocument("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityCertificate() != null) {
                if (this.checkListForm6OrignalDataModel.getDisabilityCertificate().toLowerCase().contains(this.jpg) || this.checkListForm6OrignalDataModel.getDisabilityCertificate().toLowerCase().contains(this.jpeg) || this.checkListForm6OrignalDataModel.getDisabilityCertificate().toLowerCase().contains(this.png) || this.checkListForm6OrignalDataModel.getDisabilityCertificate().toLowerCase().contains(this.jfif) || this.checkListForm6OrignalDataModel.getDisabilityCertificate().toLowerCase().contains(".pdf")) {
                    Log.d(TAG, this.nothingToDo);
                } else {
                    this.checkListForm6OrignalDataModel.setDisabilityCertificate("");
                }
            } else {
                this.checkListForm6OrignalDataModel.setDisabilityCertificate("");
            }
            if (this.checkListForm6OrignalDataModel.getDisabilityCertAttached() == null || this.checkListForm6OrignalDataModel.getDisabilityCertAttached().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisabilityCertAttached("");
            }
            if (this.checkListForm6OrignalDataModel.getRelativeMobile() == null || this.checkListForm6OrignalDataModel.getRelativeMobile().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setRelativeMobile("");
            }
            if (this.checkListForm6OrignalDataModel.getRelativeEmail() == null || this.checkListForm6OrignalDataModel.getRelativeEmail().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setRelativeEmail("");
            }
            if (this.checkListForm6OrignalDataModel.getMobileNumber() == null || this.checkListForm6OrignalDataModel.getMobileNumber().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setMobileNumber("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeSurname() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeSurname().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeSurname("");
            }
            if (this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL1() == null || this.checkListForm6OrignalDataModel.getApplicantRelativeSurnameL1().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setApplicantRelativeSurnameL1("");
            }
            if (this.checkListForm6OrignalDataModel.getAgeProofOthers() == null || this.checkListForm6OrignalDataModel.getAgeProofOthers().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setAgeProofOthers("");
            }
            if (this.checkListForm6OrignalDataModel.getAddressProofOthers() == null || this.checkListForm6OrignalDataModel.getAddressProofOthers().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setAddressProofOthers("");
            }
            if (this.checkListForm6OrignalDataModel.getAgeProofType() == null || this.checkListForm6OrignalDataModel.getAgeProofType().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setAgeProofType("");
            }
            if (this.checkListForm6OrignalDataModel.getDisability() == null || this.checkListForm6OrignalDataModel.getDisability().trim().equals("null")) {
                this.checkListForm6OrignalDataModel.setDisability("");
            }
        }
        if (group == this.binding.personalDetailRg) {
            if (checkedId == 2131365558) {
                this.fieldVerificationPhoto = "Y";
                this.alertDialog.show();
                checkRemarkVisibility();
                this.binding.personalDetailButton.setVisibility(8);
                this.binding.tvPersonalEditTextview.setVisibility(8);
                this.checkListForm6Model.setPersonalDetailsSameOrNot("Y");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda77
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$72();
                    }
                }, 2000L);
            } else if (checkedId == 2131364963) {
                this.fieldVerificationPhoto = "N";
                this.binding.personalDetailButton.setVisibility(0);
                this.binding.tvPersonalEditTextview.setVisibility(0);
                this.checkListForm6Model.setPersonalDetailsSameOrNot("N");
                checkRemarkVisibility();
            }
        } else if (group == this.binding.authenticationRadiogroup) {
            if (checkedId == 2131365557) {
                this.alertDialog.show();
                this.binding.authenticationButton.setVisibility(8);
                this.binding.tvAuthenticationEditTextview.setVisibility(8);
                this.checkListForm6Model.setAuthenticationSameOrNot("Y");
                checkRemarkVisibility();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda88
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$73();
                    }
                }, 2000L);
            } else if (checkedId == 2131364962) {
                this.binding.authenticationButton.setVisibility(0);
                this.binding.tvAuthenticationEditTextview.setVisibility(0);
                this.checkListForm6Model.setAuthenticationSameOrNot("N");
                checkRemarkVisibility();
            }
        } else if (group == this.binding.dobRg) {
            if (checkedId == 2131365555) {
                this.alertDialog.show();
                this.fieldVerificationDobOrAge = "Y";
                this.binding.dateOfBirthButton.setVisibility(8);
                this.binding.tvDobEditTextview.setVisibility(8);
                this.checkListForm6Model.setDateOfBirthSameOrNot("Y");
                checkRemarkVisibility();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda92
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$74();
                    }
                }, 2000L);
            } else if (checkedId == 2131364952) {
                this.fieldVerificationDobOrAge = "N";
                this.binding.dateOfBirthButton.setVisibility(0);
                this.binding.tvDobEditTextview.setVisibility(0);
                this.checkListForm6Model.setDateOfBirthSameOrNot("N");
                checkRemarkVisibility();
            }
        } else if (group == this.binding.addressRg) {
            if (checkedId == 2131362238) {
                this.alertDialog.show();
                this.fieldVerificationAddress = "Y";
                this.binding.residenceDetailButton.setVisibility(8);
                this.binding.tvReferenceEditTextview.setVisibility(8);
                this.checkListForm6Model.setAddressSameOrNot("Y");
                checkRemarkVisibility();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$75();
                    }
                }, 2000L);
            } else if (checkedId == 2131362237) {
                this.fieldVerificationAddress = "N";
                this.binding.residenceDetailButton.setVisibility(0);
                this.binding.tvReferenceEditTextview.setVisibility(0);
                this.checkListForm6Model.setAddressSameOrNot("N");
                checkRemarkVisibility();
            }
        } else if (group == this.binding.familyDetailsRg) {
            if (checkedId == 2131363783) {
                this.alertDialog.show();
                this.fieldFamilyDetails = "Y";
                this.binding.familyDetailsButton.setVisibility(8);
                this.binding.tvFamilyEditTextview.setVisibility(8);
                this.checkListForm6Model.setFamilyDetailsSameOrNot("Y");
                checkRemarkVisibility();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$76();
                    }
                }, 2000L);
            } else if (checkedId == 2131363781) {
                this.fieldFamilyDetails = "N";
                this.binding.familyDetailsButton.setVisibility(0);
                this.binding.tvFamilyEditTextview.setVisibility(0);
                this.checkListForm6Model.setFamilyDetailsSameOrNot("N");
                checkRemarkVisibility();
            }
        } else if (group == this.binding.disabilityDetailsRg) {
            if (checkedId == 2131363218) {
                this.fieldCategoryDisability = "Y";
                this.binding.categoryOfDisabilityButton.setVisibility(8);
                this.binding.tvDisabilityEditTextview.setVisibility(8);
                this.checkListForm6Model.setDisabilityDetailsSameOrNot("Y");
                checkRemarkVisibility();
                this.alertDialog.show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$77();
                    }
                }, 2000L);
            } else if (checkedId == 2131363216) {
                this.fieldCategoryDisability = "N";
                this.binding.categoryOfDisabilityButton.setVisibility(0);
                this.binding.tvDisabilityEditTextview.setVisibility(0);
                this.checkListForm6Model.setDisabilityDetailsSameOrNot("N");
                checkRemarkVisibility();
            }
        }
        if (group == this.binding.annexureDetailRg) {
            if (checkedId == 2131362368) {
                this.checkListForm6Model.setAnnexuredetsilsSameorNot("Y");
                checkRemarkVisibility();
                this.alertDialog.show();
                this.binding.annexureDIncludedLayout.annxureEditDetailButton.setVisibility(8);
                this.binding.annexureDIncludedLayout.tvAnnxureEditTextview.setVisibility(8);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$78();
                    }
                }, 2000L);
            } else if (checkedId == 2131362366) {
                this.binding.annexureDIncludedLayout.annxureEditDetailButton.setVisibility(0);
                this.binding.annexureDIncludedLayout.tvAnnxureEditTextview.setVisibility(0);
                this.checkListForm6Model.setAnnexuredetsilsSameorNot("N");
                checkRemarkVisibility();
            }
        }
        if (group == this.binding.declarationDetailRg) {
            if (checkedId == 2131363081) {
                this.fieldDeclarationForm = "Y";
                this.checkListForm6Model.setSetDeclarationSameOrNot("Y");
                checkRemarkVisibility();
                this.alertDialog.show();
                this.binding.declarationSirIncludedLayout.declarationEditDetailButton.setVisibility(8);
                this.binding.declarationSirIncludedLayout.tvDeclarationEditTextview.setVisibility(8);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCheckedChanged$79();
                    }
                }, 2000L);
                return;
            }
            if (checkedId == 2131363078) {
                this.fieldDeclarationForm = "N";
                this.binding.declarationSirIncludedLayout.declarationEditDetailButton.setVisibility(0);
                this.binding.declarationSirIncludedLayout.tvDeclarationEditTextview.setVisibility(0);
                this.checkListForm6Model.setSetDeclarationSameOrNot("N");
                checkRemarkVisibility();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$72() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$73() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$74() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$75() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$76() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$77() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$78() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckedChanged$79() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openBornInIndiaLayout(String dob) {
        Date date;
        this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
        this.simple.setLenient(false);
        if (dob != null && !dob.isEmpty()) {
            try {
                this.DoB = this.simple.parse(dob.trim());
            } catch (java.text.ParseException e) {
                Logger.d("Form6", e.toString());
            }
            Date date2 = this.DoB;
            if (date2 == null || (date = this.dateBefore) == null) {
                return;
            }
            if (date2.before(date)) {
                this.cat = "CAT-2";
                this.list1 = "LIST-1";
                this.annexureModel.setCat("CAT-2");
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(0);
                getList1(this.list1);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                return;
            }
            if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                this.cat = "CAT-3";
                this.list1 = "LIST-1";
                this.annexureModel.setCat("CAT-3");
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
                getList1(this.list1);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(0);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                return;
            }
            if (this.DoB.after(this.dateAfter)) {
                this.cat = "CAT-4";
                this.list1 = "LIST-1";
                this.annexureModel.setCat("CAT-4");
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
                getList1(this.list1);
                this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(0);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                return;
            }
            return;
        }
        this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLayoutForNotBornInIndia() {
        this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
        this.List6docName.clear();
        this.List6docCode.clear();
        this.cat = "CAT-5";
        this.list6 = "LIST-6";
        this.annexureModel.setCat("CAT-5");
        this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
        getList1(this.list6);
        this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(0);
        this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLayoutForIndiaCitizen() {
        this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
        this.List7docName.clear();
        this.List7docCode.clear();
        this.cat = "CAT-6";
        this.list7 = "LIST-7";
        this.annexureModel.setCat("CAT-6");
        this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
        getList1(this.list7);
        this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAcquired.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        try {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("Content-Type", "application/json");
            map.put("state", this.stateCode);
            map.put("currentRole", "blo");
            map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
            map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
            map.put("channelidobo", "BLOAPP");
            HashMap map2 = new HashMap();
            map2.put("lists", list);
            ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass39(list));
        } catch (Exception e) {
            Log.e("error@getList1", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$39, reason: invalid class name */
    class AnonymousClass39 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass39(final String val$list) {
            this.val$list = val$list;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Log.e("GetLIST1", "RESPONSE ARRIVED");
                Form6.this.alertDialog.dismiss();
                Form6.this.payloadData1 = (JsonObject) response.body();
                if (Form6.this.payloadData1 != null) {
                    JsonArray asJsonArray = Form6.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = Form6.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1")) {
                            Form6.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List1docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List1docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List1docCode.add(0, null);
                            }
                            try {
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List1docName);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                Form6.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                                Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                                Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            } catch (Exception e) {
                                Log.e("GetLIST1", e.toString());
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-2")) {
                            Form6.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List2docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List2docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List2docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                        } else if (this.val$list.equalsIgnoreCase("LIST-3")) {
                            Form6.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List3docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List3docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List3docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                        } else if (this.val$list.equalsIgnoreCase("LIST-4")) {
                            Form6.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List4docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List4docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List4docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                        } else if (this.val$list.equalsIgnoreCase("LIST-5")) {
                            Form6.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List5docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List5docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List5docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                        } else if (this.val$list.equalsIgnoreCase("LIST-6")) {
                            Form6.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List6docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List6docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List6docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                        } else if (this.val$list.equalsIgnoreCase("LIST-7")) {
                            Form6.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List7docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List7docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List7docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) Form6.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6.this.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6.this.binding.annexureDIncludedLayout.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                        } else if (this.val$list.equalsIgnoreCase("LIST-8")) {
                            Form6.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6.this.List8docName.contains(Form6.this.selectDocumentType)) {
                                Form6.this.List8docName.add(0, Form6.this.selectDocumentType);
                                Form6.this.List8docCode.add(0, null);
                            }
                        }
                    }
                    if (Form6.this.cat.equalsIgnoreCase("CAT-2") || Form6.this.cat.equalsIgnoreCase("CAT-3") || Form6.this.cat.equalsIgnoreCase("CAT-4")) {
                        if (Form6.this.ctDocTypeForSelf != null && !Form6.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                            try {
                                if (Form6.this.List1docCode != null && Form6.this.List1docCode.size() > 0) {
                                    for (int i2 = 0; i2 < Form6.this.List1docCode.size(); i2++) {
                                        if (Form6.this.List1docCode.get(i2) != null && Form6.this.List1docCode.get(i2).equalsIgnoreCase(Form6.this.ctDocTypeForSelf)) {
                                            Form6 form6 = Form6.this;
                                            form6.list1Code = form6.ctDocTypeForSelf;
                                            Form6 form7 = Form6.this;
                                            form7.list1CodeName = form7.List1docName.get(i2);
                                            Form6.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setSelection(i2);
                                            Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setSelection(i2);
                                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setSelection(i2);
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                Log.e("errror@spinner", e2.toString());
                            }
                        }
                        if (Form6.this.cat.equalsIgnoreCase("CAT-3") && Form6.this.ctDocOfFatherUrl != null && !Form6.this.ctDocOfFatherUrl.equalsIgnoreCase("") && !TextUtils.isEmpty(Form6.this.ctDocTypeForFather)) {
                            for (int i3 = 0; i3 < Form6.this.List3docCode.size(); i3++) {
                                try {
                                    if (Form6.this.List3docCode.get(i3) != null && Form6.this.List3docCode.get(i3).equalsIgnoreCase(Form6.this.ctDocTypeForFather)) {
                                        Form6 form8 = Form6.this;
                                        form8.list3code = form8.ctDocTypeForFather;
                                        Form6 form9 = Form6.this;
                                        form9.list3codeName = form9.List3docName.get(i3);
                                        Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i3);
                                        break;
                                    }
                                } catch (Exception e3) {
                                    Log.e("errror@spinner", e3.toString());
                                }
                            }
                        }
                        if (Form6.this.cat.equalsIgnoreCase("CAT-3") && Form6.this.ctDocOfMotherUrl != null && !Form6.this.ctDocOfMotherUrl.equalsIgnoreCase("")) {
                            for (int i4 = 0; i4 < Form6.this.List4docCode.size(); i4++) {
                                try {
                                    if (Form6.this.List4docCode.get(i4) != null && Form6.this.List4docCode.get(i4).equalsIgnoreCase(Form6.this.ctDocTypeForMother)) {
                                        Form6 form10 = Form6.this;
                                        form10.list4code = form10.ctDocTypeForMother;
                                        Form6 form11 = Form6.this;
                                        form11.list4codeName = form11.List4docName.get(i4);
                                        Form6.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i4);
                                        break;
                                    }
                                } catch (Exception e4) {
                                    Log.e("errror@spinner", e4.toString());
                                }
                            }
                        }
                        if (Form6.this.cat.equalsIgnoreCase("CAT-4") && Form6.this.isParentsIndian != null && Form6.this.isParentsIndian.equalsIgnoreCase("Y")) {
                            if (!TextUtils.isEmpty(Form6.this.ctDocTypeForFather) && !TextUtils.isEmpty(Form6.this.ctDocTypeForFather)) {
                                for (int i5 = 0; i5 < Form6.this.List3docCode.size(); i5++) {
                                    try {
                                        if (Form6.this.List3docCode.get(i5) != null && Form6.this.List3docCode.get(i5).equalsIgnoreCase(Form6.this.ctDocTypeForFather)) {
                                            Form6 form12 = Form6.this;
                                            form12.list3code = form12.ctDocTypeForFather;
                                            Form6 form13 = Form6.this;
                                            form13.list3codeName = form13.List3docName.get(i5);
                                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i5);
                                            break;
                                        }
                                    } catch (Exception e5) {
                                        Log.e("errror@spinner", e5.toString());
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(Form6.this.ctDocTypeForMother) && !TextUtils.isEmpty(Form6.this.ctDocTypeForMother)) {
                                for (int i6 = 0; i6 < Form6.this.List4docCode.size(); i6++) {
                                    try {
                                        if (Form6.this.List4docCode.get(i6) != null && Form6.this.List4docCode.get(i6).equalsIgnoreCase(Form6.this.ctDocTypeForMother)) {
                                            Form6 form14 = Form6.this;
                                            form14.list4code = form14.ctDocTypeForMother;
                                            Form6 form15 = Form6.this;
                                            form15.list4codeName = form15.List4docName.get(i6);
                                            Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i6);
                                            break;
                                        }
                                    } catch (Exception e6) {
                                        Log.e("errror@spinner", e6.toString());
                                    }
                                }
                            }
                        } else if (Form6.this.cat.equalsIgnoreCase("CAT-4") && Form6.this.isParentsIndian != null && Form6.this.isParentsIndian.equalsIgnoreCase("N")) {
                            if (!TextUtils.isEmpty(Form6.this.ctDocTypeForFather) && Form6.this.ctDocTypeForFather.contains("L5")) {
                                if (!TextUtils.isEmpty(Form6.this.ctDocTypeForFather)) {
                                    for (int i7 = 0; i7 < Form6.this.List5docCode.size(); i7++) {
                                        try {
                                            if (Form6.this.List5docCode.get(i7) != null && Form6.this.List5docCode.get(i7).equalsIgnoreCase(Form6.this.ctDocTypeForFather)) {
                                                Form6 form16 = Form6.this;
                                                form16.list5code = form16.ctDocTypeForFather;
                                                Form6 form17 = Form6.this;
                                                form17.list5codeName = form17.List5docName.get(i7);
                                                Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i7);
                                                break;
                                            }
                                        } catch (Exception e7) {
                                            Log.e("errror@spinner", e7.toString());
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(Form6.this.ctDocTypeForMother)) {
                                    for (int i8 = 0; i8 < Form6.this.List4docCode.size(); i8++) {
                                        try {
                                            if (Form6.this.List4docCode.get(i8) != null && Form6.this.List4docCode.get(i8).equalsIgnoreCase(Form6.this.ctDocTypeForMother)) {
                                                Form6 form18 = Form6.this;
                                                form18.list4code = form18.ctDocTypeForMother;
                                                Form6 form19 = Form6.this;
                                                form19.list4codeName = form19.List4docName.get(i8);
                                                Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i8);
                                                break;
                                            }
                                        } catch (Exception e8) {
                                            Log.e("errror@spinner", e8.toString());
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(Form6.this.ctDocTypeForMother) && Form6.this.ctDocTypeForMother.contains("L5")) {
                                if (!TextUtils.isEmpty(Form6.this.ctDocTypeForFather)) {
                                    for (int i9 = 0; i9 < Form6.this.List3docCode.size(); i9++) {
                                        try {
                                            if (Form6.this.List3docCode.get(i9) != null && Form6.this.List3docCode.get(i9).equalsIgnoreCase(Form6.this.ctDocTypeForFather)) {
                                                Form6 form20 = Form6.this;
                                                form20.list3code = form20.ctDocTypeForFather;
                                                Form6 form21 = Form6.this;
                                                form21.list3codeName = form21.List3docName.get(i9);
                                                Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i9);
                                                break;
                                            }
                                        } catch (Exception e9) {
                                            Log.e("errror@spinner", e9.toString());
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(Form6.this.ctDocTypeForMother)) {
                                    for (int i10 = 0; i10 < Form6.this.List5docCode.size(); i10++) {
                                        try {
                                            if (Form6.this.List5docCode.get(i10) != null && Form6.this.List5docCode.get(i10).equalsIgnoreCase(Form6.this.ctDocTypeForMother)) {
                                                Form6 form22 = Form6.this;
                                                form22.list5code = form22.ctDocTypeForMother;
                                                Form6 form23 = Form6.this;
                                                form23.list5codeName = form23.List5docName.get(i10);
                                                Form6.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i10);
                                                break;
                                            }
                                        } catch (Exception e10) {
                                            Log.e("errror@spinner", e10.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (Form6.this.cat.equalsIgnoreCase("CAT-5") && Form6.this.ctDocTypeForSelf != null && !Form6.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                        for (int i11 = 0; i11 < Form6.this.List6docCode.size(); i11++) {
                            try {
                                if (Form6.this.List6docCode.get(i11) != null && Form6.this.List6docCode.get(i11).equalsIgnoreCase(Form6.this.ctDocTypeForSelf)) {
                                    Form6 form24 = Form6.this;
                                    form24.list6code = form24.ctDocTypeForSelf;
                                    Form6 form25 = Form6.this;
                                    form25.list6codeName = form25.List6docName.get(i11);
                                    Form6.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setSelection(i11);
                                }
                            } catch (Exception e11) {
                                Log.e("errror@spinner", e11.toString());
                            }
                        }
                    }
                    if (!Form6.this.cat.equalsIgnoreCase("CAT-6") || Form6.this.ctDocTypeForSelf == null || Form6.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                        return;
                    }
                    for (int i12 = 0; i12 < Form6.this.List7docCode.size(); i12++) {
                        try {
                            if (Form6.this.List7docCode.get(i12) != null && Form6.this.List7docCode.get(i12).equalsIgnoreCase(Form6.this.ctDocTypeForSelf)) {
                                Form6 form26 = Form6.this;
                                form26.list7code = form26.ctDocTypeForSelf;
                                Form6 form27 = Form6.this;
                                form27.list7codeName = form27.List7docName.get(i12);
                                Form6.this.binding.annexureDIncludedLayout.spinnerAcquired.setSelection(i12);
                            }
                        } catch (Exception e12) {
                            Log.e("errror@spinner", e12.toString());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = Form6.this.commomUtility;
                    FragmentActivity activity = Form6.this.getActivity();
                    String str = Form6.this.refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(activity, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$39$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i13, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i13, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e13) {
                    Logger.e(Form6.TAG, e13.toString());
                    return;
                }
            }
            try {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Logger.e(Form6.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e14) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Logger.e(Form6.TAG, e14.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            if (Form6.this.alertDialog != null) {
                Form6.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Form6.this.commomUtility.showMessageOK(Form6.this.getActivity(), Form6.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$39$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Form6.this.token = "Bearer " + str2;
            SharedPref.getInstance(Form6.this.getActivity()).setRefreshToken(str3);
            SharedPref.getInstance(Form6.this.getActivity()).setToken("Bearer " + str2);
            Form6.this.getList1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Form6.this.getActivity()).setIsLoggedIn(false);
            SharedPref.getInstance(Form6.this.getActivity()).setLocaleBool(false);
            Form6.this.startActivity(new Intent((Context) Form6.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Form6.TAG, "OnFailure" + t.getMessage());
        }
    }

    private boolean validateAnnexure() {
        if (TextUtils.isEmpty(this.choice)) {
            showdialog("ALERT", "Please select atleast one category");
            return false;
        }
        if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
            if (this.cat.equalsIgnoreCase("CAT-2")) {
                if (this.binding.annexureDIncludedLayout.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("ALERT", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("ALERT", "Please select document for self.");
                    return false;
                }
            } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                if (this.binding.annexureDIncludedLayout.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("ALERT", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("ALERT", "Please select document for self.");
                    return false;
                }
                if (this.flagcat3scenerio1.equalsIgnoreCase("") || this.flagcat3scenerio2.equalsIgnoreCase("")) {
                    showdialog("ALERT", "Please select atleast one parent");
                    return false;
                }
                if (this.binding.annexureDIncludedLayout.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("ALERT", this.selectDocumentType);
                    return false;
                }
                if (this.list3Ref == null && this.list4Ref == null) {
                    showdialog("ALERT", "Please select document for Father or Mother.");
                    return false;
                }
            } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                if (this.binding.annexureDIncludedLayout.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("ALERT", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("ALERT", "Please select document for self.");
                    return false;
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("")) {
                    showdialog("ALERT", "Please select atleast one parent.");
                    return false;
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("ALERT", this.selectDocumentType);
                        return false;
                    }
                    if (this.list3Ref == null) {
                        showdialog("ALERT", "Please select document for Father.");
                        return false;
                    }
                    if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("ALERT", this.selectDocumentType);
                        return false;
                    }
                    if (this.list4Ref == null) {
                        showdialog("ALERT", "Please select document for Mother.");
                        return false;
                    }
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("N")) {
                    if (this.flagcat4scenerio2.equalsIgnoreCase("") || this.flagcat4scenerio3.equalsIgnoreCase("")) {
                        showdialog("ALERT", "Please select atleast one parent nationality.");
                        return false;
                    }
                    if (this.flagcat4scenerio2.equalsIgnoreCase("Y")) {
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("ALERT", this.selectDocumentType);
                            return false;
                        }
                        if (this.list3Ref == null) {
                            showdialog("ALERT", "Please select document for Father.");
                            return false;
                        }
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("ALERT", this.selectDocumentType);
                            return false;
                        }
                        if (this.list5Ref == null) {
                            showdialog("ALERT", "Please select document for Mother.");
                            return false;
                        }
                    }
                    if (this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("ALERT", this.selectDocumentType);
                            return false;
                        }
                        if (this.list4Ref == null) {
                            showdialog("ALERT", "Please select document for Mother.");
                            return false;
                        }
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("ALERT", this.selectDocumentType);
                            return false;
                        }
                        if (this.list5Ref == null) {
                            showdialog("ALERT", "Please select document for Father.");
                            return false;
                        }
                    }
                }
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
            if (this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
                showdialog("ALERT", this.selectDocumentType);
                return false;
            }
            if (this.list6ref == null) {
                showdialog("ALERT", "Please select document for self.");
                return false;
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
            if (this.binding.annexureDIncludedLayout.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
                showdialog("ALERT", this.selectDocumentType);
                return false;
            }
            if (this.list7ref == null) {
                showdialog("ALERT", "Please select document for self.");
                return false;
            }
        }
        if (this.anxDSignUrl != null) {
            return true;
        }
        showdialog("ALERT", "Please upload signature.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$80(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$80(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String ALERT2, String message) {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(getActivity()).setTitle(ALERT2).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda23
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$81(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$81(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void showdialog1(String success, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$82(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$82(DialogInterface dialogInterface, int i) {
        try {
            FileUtils.deleteDirectory(new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/"));
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void showdialog2(String success, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda91
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$83(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$83(DialogInterface dialogInterface, int i) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 112) {
            this.list1ref = null;
            this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
            this.binding.annexureDIncludedLayout.list1Size.setText("");
            this.binding.annexureDIncludedLayout.list1Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList1.setVisibility(8);
            return;
        }
        if (code == 113) {
            this.list1ref = null;
            this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
            this.binding.annexureDIncludedLayout.before2004SelfSize.setText("");
            this.binding.annexureDIncludedLayout.before2004SelfName.setText("");
            this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(8);
            return;
        }
        if (code == 114) {
            this.list3Ref = null;
            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
            this.binding.annexureDIncludedLayout.list2Size.setText("");
            this.binding.annexureDIncludedLayout.list2Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(8);
            return;
        }
        if (code == 105) {
            this.list1ref = null;
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
            this.binding.annexureDIncludedLayout.after2004selfSize.setText("");
            this.binding.annexureDIncludedLayout.after2004selfName.setText("");
            this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(8);
            return;
        }
        if (code == 106) {
            this.list3Ref = null;
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
            this.binding.annexureDIncludedLayout.list3Size.setText("");
            this.binding.annexureDIncludedLayout.list3Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList3.setVisibility(8);
            return;
        }
        if (code == 107 || code == 111) {
            this.list4Ref = null;
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
            this.binding.annexureDIncludedLayout.list4Size.setText("");
            this.binding.annexureDIncludedLayout.list4Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(8);
            return;
        }
        if (code == 108) {
            this.list5Ref = null;
            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
            this.binding.annexureDIncludedLayout.list5Size.setText("");
            this.binding.annexureDIncludedLayout.list5Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(8);
            return;
        }
        if (code == 109) {
            this.list6ref = null;
            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
            this.binding.annexureDIncludedLayout.list6Size.setText("");
            this.binding.annexureDIncludedLayout.list6Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList6.setVisibility(8);
            return;
        }
        if (code == 110) {
            this.list7ref = null;
            this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
            this.binding.annexureDIncludedLayout.list7Size.setText("");
            this.binding.annexureDIncludedLayout.list7Name.setText("");
            this.binding.annexureDIncludedLayout.cancelList7.setVisibility(8);
            return;
        }
        if (code == 115) {
            this.anxDSignUrl = null;
            this.binding.annexureDIncludedLayout.chooseFileSign.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(true);
            this.binding.annexureDIncludedLayout.imageSign.setVisibility(8);
            this.binding.annexureDIncludedLayout.signSize.setText("");
            this.binding.annexureDIncludedLayout.signName.setText("");
            this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(8);
        }
    }

    private void pickFile(final int code, String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle(this.chooseFile);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda66
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$84(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pickFile$84(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.choosegallery)) {
            this.alertDialog.show();
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
        if (code == 105) {
            this.activityResultLauncher4.launch(intentCreateChooser);
            return;
        }
        if (code == 106) {
            this.activityResultLauncher5.launch(intentCreateChooser);
            return;
        }
        if (code == 107) {
            this.activityResultLauncher6.launch(intentCreateChooser);
            return;
        }
        if (code == 108) {
            this.activityResultLauncher7.launch(intentCreateChooser);
            return;
        }
        if (code == 109) {
            this.activityResultLauncher8.launch(intentCreateChooser);
            return;
        }
        if (code == 110) {
            this.activityResultLauncher9.launch(intentCreateChooser);
            return;
        }
        if (code == 111) {
            this.activityResultLauncher10.launch(intentCreateChooser);
            return;
        }
        if (code == 112) {
            this.activityResultLauncher11.launch(intentCreateChooser);
            return;
        }
        if (code == 113) {
            this.activityResultLauncher12.launch(intentCreateChooser);
        } else if (code == 114) {
            this.activityResultLauncher13.launch(intentCreateChooser);
        } else if (code == 115) {
            this.activityResultLauncher14.launch(intentCreateChooser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0728 A[Catch: Exception -> 0x0c99, TRY_ENTER, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:101:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:103:0x07a9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0826  */
    /* JADX WARN: Code duplicated, block: B:106:0x082a A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x08a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x08a9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0926  */
    /* JADX WARN: Code duplicated, block: B:111:0x092a A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x09a7  */
    /* JADX WARN: Code duplicated, block: B:114:0x09ab A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0a28  */
    /* JADX WARN: Code duplicated, block: B:117:0x0a2c A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:120:0x0aad A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0b2a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0b2e A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0b92  */
    /* JADX WARN: Code duplicated, block: B:126:0x0b96 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0c12  */
    /* JADX WARN: Code duplicated, block: B:129:0x0c16 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0c8a A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[Catch: Exception -> 0x0c9b, TRY_LEAVE, TryCatch #1 {Exception -> 0x0c9b, blocks: (B:30:0x005c, B:32:0x007d), top: B:141:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:35:0x009f A[Catch: Exception -> 0x0c99, TRY_ENTER, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0145  */
    /* JADX WARN: Code duplicated, block: B:40:0x0149 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0245  */
    /* JADX WARN: Code duplicated, block: B:46:0x0249 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:47:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:49:0x02c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0345  */
    /* JADX WARN: Code duplicated, block: B:52:0x0349 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:55:0x03c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0445  */
    /* JADX WARN: Code duplicated, block: B:58:0x0449 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:61:0x04c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0545  */
    /* JADX WARN: Code duplicated, block: B:64:0x0549 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:65:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x05c9 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0636 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:70:0x065c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0662 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x066d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0671 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:76:0x067c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0680 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:79:0x068a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x068c A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0696 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0698 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:83:0x06a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x06a4 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:85:0x06ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x06b0 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:87:0x06ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x06bc A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:89:0x06c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x06c8 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:91:0x06d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x06d4 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:93:0x06de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x06e0 A[Catch: Exception -> 0x0c99, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:97:0x06f4 A[Catch: Exception -> 0x0c99, TRY_LEAVE, TryCatch #3 {Exception -> 0x0c99, blocks: (B:35:0x009f, B:37:0x00c9, B:130:0x0c86, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:68:0x0636, B:72:0x0662, B:95:0x06e9, B:75:0x0671, B:78:0x0680, B:80:0x068c, B:82:0x0698, B:84:0x06a4, B:86:0x06b0, B:88:0x06bc, B:90:0x06c8, B:92:0x06d4, B:94:0x06e0, B:97:0x06f4, B:100:0x0728, B:103:0x07a9, B:106:0x082a, B:108:0x08a9, B:111:0x092a, B:114:0x09ab, B:117:0x0a2c, B:120:0x0aad, B:123:0x0b2e, B:126:0x0b96, B:129:0x0c16, B:131:0x0c8a, B:132:0x0c98), top: B:145:0x007b }] */
    public void HandlePdfFile(Intent data, String code, int requestcode) throws Throwable {
        Exception exc;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        double dRound;
        Cursor cursor;
        Throwable th;
        Uri data2 = data.getData();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(data2);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    try {
                        while (true) {
                            try {
                                int i = inputStreamOpenInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr, 0, i);
                                }
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                this.pdfbyteArray1 = byteArray;
                                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf");
                                cursorQuery = getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                if (cursorQuery.getCount() > 0) {
                                    cursorQuery.close();
                                    throw new IllegalArgumentException(this.imgmsg);
                                }
                                cursorQuery.moveToFirst();
                                strArrSplit = saveImagePath.getPath().split("/");
                                if (this.filesize < 1024) {
                                    Math.round(this.filesize * 100.0d);
                                    this.alertDialog.show();
                                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, code);
                                    if (requestcode == 105) {
                                        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageAfter2004self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.after2004selfSize.setText(this.filesize + "KB");
                                    } else if (requestcode == 106) {
                                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList3.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list3Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 107) {
                                        this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList4.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list4Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 108) {
                                        this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList5.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list5Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 109) {
                                        this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList6.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list6Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 110) {
                                        this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList7.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list7Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 111) {
                                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 112) {
                                        this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list1Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 113) {
                                        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageBefore2004Self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.before2004SelfSize.setText(this.filesize + "KB");
                                    } else if (requestcode == 114) {
                                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                                    } else if (requestcode == 115) {
                                        this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                                        this.binding.annexureDIncludedLayout.imageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                                        this.binding.annexureDIncludedLayout.signName.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                                    }
                                } else {
                                    dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                    if (dRound > 3.0d) {
                                        if (requestcode == 105) {
                                            this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                                        } else if (requestcode == 106) {
                                            this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                                        } else if (requestcode == 107) {
                                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                                        } else if (requestcode == 108) {
                                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                                        } else if (requestcode == 109) {
                                            this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                                        } else if (requestcode == 110) {
                                            this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                                        } else if (requestcode == 111) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                                        } else if (requestcode == 112) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                                        } else if (requestcode == 113) {
                                            this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                                        } else if (requestcode == 114) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                                        } else if (requestcode == 115) {
                                            this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                                        }
                                        showdialog("ALERT", this.pdf3);
                                    } else {
                                        this.alertDialog.show();
                                        cursor = cursorQuery;
                                        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, code);
                                        if (requestcode == 105) {
                                            this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageAfter2004self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.after2004selfSize.setText(dRound + "MB");
                                        } else if (requestcode == 106) {
                                            this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList3.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list3Size.setText(dRound + "MB");
                                        } else if (requestcode == 107) {
                                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList4.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list4Size.setText(dRound + "MB");
                                        } else if (requestcode == 108) {
                                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList5.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list5Size.setText(dRound + "MB");
                                        } else if (requestcode == 109) {
                                            this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList6.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list6Size.setText(dRound + "MB");
                                        } else if (requestcode == 110) {
                                            this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList7.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list7Size.setText(dRound + "MB");
                                        } else if (requestcode == 111) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list2Size.setText(dRound + "MB");
                                        } else if (requestcode == 112) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list1Size.setText(dRound + "MB");
                                        } else if (requestcode == 113) {
                                            this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageBefore2004Self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.before2004SelfSize.setText(dRound + "MB");
                                        } else if (requestcode == 114) {
                                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.list2Size.setText(dRound + "MB");
                                        } else if (requestcode == 115) {
                                            this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                                            this.binding.annexureDIncludedLayout.imageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                                            this.binding.annexureDIncludedLayout.signName.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                                        }
                                    }
                                    cursor.close();
                                    return;
                                }
                                cursor = cursorQuery;
                                cursor.close();
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (inputStreamOpenInputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStreamOpenInputStream.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                            Logger.d("", exc.getMessage());
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        }
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(this.imgmsg);
                        }
                        cursorQuery.moveToFirst();
                        strArrSplit = saveImagePath.getPath().split("/");
                        if (this.filesize < 1024) {
                            Math.round(this.filesize * 100.0d);
                            this.alertDialog.show();
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, code);
                            if (requestcode == 105) {
                                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageAfter2004self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.after2004selfSize.setText(this.filesize + "KB");
                            } else if (requestcode == 106) {
                                this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList3.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list3Size.setText(this.filesize + "KB");
                            } else if (requestcode == 107) {
                                this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList4.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list4Size.setText(this.filesize + "KB");
                            } else if (requestcode == 108) {
                                this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList5.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list5Size.setText(this.filesize + "KB");
                            } else if (requestcode == 109) {
                                this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList6.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list6Size.setText(this.filesize + "KB");
                            } else if (requestcode == 110) {
                                this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList7.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list7Size.setText(this.filesize + "KB");
                            } else if (requestcode == 111) {
                                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                            } else if (requestcode == 112) {
                                this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list1Size.setText(this.filesize + "KB");
                            } else if (requestcode == 113) {
                                this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                                this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageBefore2004Self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(false);
                                this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.before2004SelfSize.setText(this.filesize + "KB");
                            } else if (requestcode == 114) {
                                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                            } else if (requestcode == 115) {
                                this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                                this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                                this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                                this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                                this.binding.annexureDIncludedLayout.signName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                            }
                        } else {
                            dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                            if (dRound > 3.0d) {
                                if (requestcode == 105) {
                                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                                } else if (requestcode == 106) {
                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                                } else if (requestcode == 107) {
                                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                                } else if (requestcode == 108) {
                                    this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                                } else if (requestcode == 109) {
                                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                                } else if (requestcode == 110) {
                                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                                } else if (requestcode == 111) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                                } else if (requestcode == 112) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                                } else if (requestcode == 113) {
                                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                                } else if (requestcode == 114) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                                } else if (requestcode == 115) {
                                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                                }
                                showdialog("ALERT", this.pdf3);
                            } else {
                                this.alertDialog.show();
                                cursor = cursorQuery;
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, code);
                                if (requestcode == 105) {
                                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageAfter2004self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.after2004selfSize.setText(dRound + "MB");
                                } else if (requestcode == 106) {
                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList3.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list3Size.setText(dRound + "MB");
                                } else if (requestcode == 107) {
                                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList4.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list4Size.setText(dRound + "MB");
                                } else if (requestcode == 108) {
                                    this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList5.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list5Size.setText(dRound + "MB");
                                } else if (requestcode == 109) {
                                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList6.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list6Size.setText(dRound + "MB");
                                } else if (requestcode == 110) {
                                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList7.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list7Size.setText(dRound + "MB");
                                } else if (requestcode == 111) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list2Size.setText(dRound + "MB");
                                } else if (requestcode == 112) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list1Size.setText(dRound + "MB");
                                } else if (requestcode == 113) {
                                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageBefore2004Self.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.before2004SelfSize.setText(dRound + "MB");
                                } else if (requestcode == 114) {
                                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageList2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.list2Size.setText(dRound + "MB");
                                } else if (requestcode == 115) {
                                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                                    this.binding.annexureDIncludedLayout.imageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                                    this.binding.annexureDIncludedLayout.signName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                                }
                            }
                            cursor.close();
                            return;
                        }
                        cursor = cursorQuery;
                        cursor.close();
                        return;
                    } catch (Exception e) {
                        e = e;
                    }
                    saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf");
                    cursorQuery = getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                } catch (Exception e2) {
                    e = e2;
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception e3) {
                        exc = e3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        Logger.d("", exc.getMessage());
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    }
                }
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                this.pdfbyteArray1 = byteArray2;
                Logger.d("", e.getMessage());
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e4) {
            exc = e4;
        }
    }

    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(getContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(reference, MediaType.parse("fileName"));
        restClient.uploadImageWithData1(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", partCreateFormData, RequestBody.create(this.applicationpdf, MediaType.parse("fileType")), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass40(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$40, reason: invalid class name */
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
                CommomUtility commomUtility = Form6.this.commonUtilClass;
                Context contextRequireContext = Form6.this.requireContext();
                String str = Form6.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$40$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                final String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                Handler handler = new Handler(Looper.getMainLooper());
                final String str9 = this.val$uploadtype;
                handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$40$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2(str9, strValueOf);
                    }
                }, 2000L);
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.before1987Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(true);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.before1987count = 0;
                Form6 form6 = Form6.this;
                form6.showDialog1("ALERT", form6.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.before2004Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(true);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.before1987count = 0;
                Form6 form7 = Form6.this;
                form7.showDialog1("ALERT", form7.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list2Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(true);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.list2count = 0;
                Form6 form8 = Form6.this;
                form8.showDialog1("ALERT", form8.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.after2004Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(true);
                Form6.this.after2004count = 0;
                Form6 form9 = Form6.this;
                form9.showDialog1("ALERT", form9.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list3Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(true);
                Form6.this.list3count = 0;
                Form6 form10 = Form6.this;
                form10.showDialog1("ALERT", form10.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list4Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(true);
                Form6.this.list4coumt = 0;
                Form6 form11 = Form6.this;
                form11.showDialog1("ALERT", form11.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list5Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(true);
                Form6.this.list5count = 0;
                Form6 form12 = Form6.this;
                form12.showDialog1("ALERT", form12.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list6Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(true);
                Form6.this.list6count = 0;
                Form6 form13 = Form6.this;
                form13.showDialog1("ALERT", form13.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.list7Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(true);
                Form6.this.list7count = 0;
                Form6.this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6 form14 = Form6.this;
                form14.showDialog1("ALERT", form14.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6.this.anxDSign)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                Form6.this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.imageSign.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(true);
                Form6.this.binding.annexureDIncludedLayout.chooseFileSign.setTextColor(Color.parseColor(Form6.this.whitecolor));
                Form6 form15 = Form6.this;
                form15.showDialog1("ALERT", form15.fileNotFoundMessage);
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str8 + " " + str9);
            if (i == 401 || i == 400) {
                Form6.this.commonUtilClass.showMessageOK(Form6.this.getContext(), Form6.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$40$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Form6.this.token = "Bearer " + str8;
            Form6.this.refreshToken = str9;
            SharedPref.getInstance(Form6.this.requireContext()).setRefreshToken(str9);
            SharedPref.getInstance(Form6.this.requireContext()).setToken("Bearer " + str8);
            Form6 form6 = Form6.this;
            form6.uploadPhoto(str, str2, str3, str4, str5, form6.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Form6.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Form6.this.requireContext()).setLocaleBool(false);
            Form6.this.startActivity(new Intent((Context) Form6.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2) {
            if (str.equals(Form6.this.before1987Str)) {
                Form6.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList1ref(Form6.this.list1ref);
                Logger.d("List1ref1987", Form6.this.list1ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.before2004Str)) {
                Form6.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList1ref(Form6.this.list1ref);
                Logger.d("List1ref2004", Form6.this.list1ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list2Str)) {
                Form6.this.list2Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList2Ref(Form6.this.list2Ref);
                Logger.d("list2ref", Form6.this.list2Ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.after2004Str)) {
                Form6.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList1ref(Form6.this.list1ref);
                Logger.d("List1refafter2004", Form6.this.list1ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list3Str)) {
                Form6.this.list3Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList3Ref(Form6.this.list3Ref);
                Logger.d("list3Ref", Form6.this.list3Ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list4Str)) {
                Form6.this.list4Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList4Ref(Form6.this.list4Ref);
                Logger.d("list4Ref", Form6.this.list4Ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list5Str)) {
                Form6.this.list5Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List5ref", Form6.this.list5Ref);
                Form6.this.annexureModel.setList5Ref(Form6.this.list5Ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list6Str)) {
                Form6.this.list6ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList6ref(Form6.this.list6ref);
                Logger.d("List6ref", Form6.this.list6ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.list7Str)) {
                Form6.this.list7ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setList7ref(Form6.this.list7ref);
                Logger.d("list7ref", Form6.this.list7ref);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.IRStr2)) {
                Form6.this.IRRef2 = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("IRRef2", Form6.this.IRRef2);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6.this.anxDSign)) {
                Form6.this.anxDSignUrl = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6.this.annexureModel.setAnxDSignUrl(Form6.this.anxDSignUrl);
                Logger.d("anxDSignUrl", Form6.this.anxDSignUrl);
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(Form6.this.before1987Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.before1987count < 1 && TextUtils.isEmpty(Form6.this.list1ref)) {
                    Form6.this.before1987count++;
                    Form6 form6 = Form6.this;
                    form6.showdialogref("ALERT", form6.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(true);
                Form6.this.before1987count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.before2004Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.before2004count < 1 && TextUtils.isEmpty(Form6.this.list1ref)) {
                    Form6.this.before2004count++;
                    Form6 form7 = Form6.this;
                    form7.showdialogref("ALERT", form7.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(true);
                Form6.this.before1987count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list2Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list2count < 1 && TextUtils.isEmpty(Form6.this.list2Ref)) {
                    Form6.this.list2count++;
                    Form6 form8 = Form6.this;
                    form8.showdialogref("ALERT", form8.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(true);
                Form6.this.list2count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.after2004Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.after2004count < 1 && TextUtils.isEmpty(Form6.this.list1ref)) {
                    Form6.this.after2004count++;
                    Form6 form9 = Form6.this;
                    form9.showdialogref("ALERT", form9.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(true);
                Form6.this.after2004count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list3Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list3count < 1 && TextUtils.isEmpty(Form6.this.list3Ref)) {
                    Form6.this.list3count++;
                    Form6 form10 = Form6.this;
                    form10.showdialogref("ALERT", form10.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(true);
                Form6.this.list3count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list4Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list4coumt < 1 && TextUtils.isEmpty(Form6.this.list4Ref)) {
                    Form6.this.list4coumt++;
                    Form6 form11 = Form6.this;
                    form11.showdialogref("ALERT", form11.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(true);
                Form6.this.list4coumt = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list5Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list5count < 1 && TextUtils.isEmpty(Form6.this.list5Ref)) {
                    Form6.this.list5count++;
                    Form6 form12 = Form6.this;
                    form12.showdialogref("ALERT", form12.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(true);
                Form6.this.list5count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list6Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list6count < 1 && TextUtils.isEmpty(Form6.this.list6ref)) {
                    Form6.this.list6count++;
                    Form6 form13 = Form6.this;
                    form13.showdialogref("ALERT", form13.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(true);
                Form6.this.list6count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list7Str)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list7count < 1 && TextUtils.isEmpty(Form6.this.list7ref)) {
                    Form6.this.list7count++;
                    Form6 form14 = Form6.this;
                    form14.showdialogref("ALERT", form14.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6.this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
                Form6.this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(true);
                Form6.this.list7count = 0;
                Form6.this.showDialog1("ALERT", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.before1987Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.before1987count2 >= 1 || !TextUtils.isEmpty(Form6.this.list1ref2)) {
                    return;
                }
                Form6.this.before1987count2++;
                Form6 form15 = Form6.this;
                form15.showdialogref("ALERT", form15.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.before2004Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.before2004count2 >= 1 || !TextUtils.isEmpty(Form6.this.list1ref2)) {
                    return;
                }
                Form6.this.before2004count2++;
                Form6 form16 = Form6.this;
                form16.showdialogref("ALERT", form16.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list2Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list2count2 >= 1 || !TextUtils.isEmpty(Form6.this.list2Ref2)) {
                    return;
                }
                Form6.this.list2count2++;
                Form6 form17 = Form6.this;
                form17.showdialogref("ALERT", form17.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.after2004Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.after2004count2 >= 1 || !TextUtils.isEmpty(Form6.this.list1ref2)) {
                    return;
                }
                Form6.this.after2004count2++;
                Form6 form18 = Form6.this;
                form18.showdialogref("ALERT", form18.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list3Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list3count2 >= 1 || !TextUtils.isEmpty(Form6.this.list3Ref2)) {
                    return;
                }
                Form6.this.list3count2++;
                Form6 form19 = Form6.this;
                form19.showdialogref("ALERT", form19.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list4Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list4coumt2 >= 1 || !TextUtils.isEmpty(Form6.this.list4Ref2)) {
                    return;
                }
                Form6.this.list4coumt2++;
                Form6 form20 = Form6.this;
                form20.showdialogref("ALERT", form20.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list5Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list5count2 >= 1 || !TextUtils.isEmpty(Form6.this.list5Ref2)) {
                    return;
                }
                Form6.this.list5count2++;
                Form6 form21 = Form6.this;
                form21.showdialogref("ALERT", form21.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list5Str3)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list5count3 >= 1 || !TextUtils.isEmpty(Form6.this.list5ref3)) {
                    return;
                }
                Form6.this.list5count3++;
                Form6 form22 = Form6.this;
                form22.showdialogref("ALERT", form22.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list6Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list6count2 >= 1 || !TextUtils.isEmpty(Form6.this.list6ref2)) {
                    return;
                }
                Form6.this.list6count2++;
                Form6 form23 = Form6.this;
                form23.showdialogref("ALERT", form23.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6.this.list7Str2)) {
                if (Form6.this.alertDialog != null) {
                    Form6.this.alertDialog.dismiss();
                }
                if (Form6.this.list7count2 >= 1 || !TextUtils.isEmpty(Form6.this.list7ref2)) {
                    return;
                }
                Form6.this.list7count2++;
                Form6 form24 = Form6.this;
                form24.showdialogref("ALERT", form24.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("Retry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda44
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$85(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$85(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        dialogInterface.dismiss();
        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0339  */
    /* JADX WARN: Code duplicated, block: B:118:0x033e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0393 A[Catch: Exception -> 0x055f, TRY_LEAVE, TryCatch #4 {Exception -> 0x055f, blocks: (B:123:0x036c, B:125:0x0393, B:133:0x044c, B:139:0x048a, B:144:0x04b0), top: B:495:0x036c }] */
    /* JADX WARN: Code duplicated, block: B:128:0x03ad A[Catch: Exception -> 0x0445, TRY_ENTER, TRY_LEAVE, TryCatch #55 {Exception -> 0x0445, blocks: (B:128:0x03ad, B:136:0x0452, B:142:0x04a0), top: B:593:0x03ab }] */
    /* JADX WARN: Code duplicated, block: B:132:0x044b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0452 A[Catch: Exception -> 0x0445, TRY_ENTER, TRY_LEAVE, TryCatch #55 {Exception -> 0x0445, blocks: (B:128:0x03ad, B:136:0x0452, B:142:0x04a0), top: B:593:0x03ab }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0488  */
    /* JADX WARN: Code duplicated, block: B:142:0x04a0 A[Catch: Exception -> 0x0445, TRY_ENTER, TRY_LEAVE, TryCatch #55 {Exception -> 0x0445, blocks: (B:128:0x03ad, B:136:0x0452, B:142:0x04a0), top: B:593:0x03ab }] */
    /* JADX WARN: Code duplicated, block: B:144:0x04b0 A[Catch: Exception -> 0x055f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x055f, blocks: (B:123:0x036c, B:125:0x0393, B:133:0x044c, B:139:0x048a, B:144:0x04b0), top: B:495:0x036c }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0550 A[Catch: Exception -> 0x055d, TryCatch #6 {Exception -> 0x055d, blocks: (B:146:0x04cc, B:147:0x0550, B:148:0x055c), top: B:498:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x056e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0583  */
    /* JADX WARN: Code duplicated, block: B:198:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:238:0x09e3  */
    /* JADX WARN: Code duplicated, block: B:278:0x0c13  */
    /* JADX WARN: Code duplicated, block: B:318:0x0e43  */
    /* JADX WARN: Code duplicated, block: B:358:0x1073  */
    /* JADX WARN: Code duplicated, block: B:381:0x1284  */
    /* JADX WARN: Code duplicated, block: B:421:0x149c  */
    /* JADX WARN: Code duplicated, block: B:461:0x16cd  */
    /* JADX WARN: Code duplicated, block: B:623:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1017, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v1026, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v1030, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v1033, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v1036, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v1039, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v1042, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v1067, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v155, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v164, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v168, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v171, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v174, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v177, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v180, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v205, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v267, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v271, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v274, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v277, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v280, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v283, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v308, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v362, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v371, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v375, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v378, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v381, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v384, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v387, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v412, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v471, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v480, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v484, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v487, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v49, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v490, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v493, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v496, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v521, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v58, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v580, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v589, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v593, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v596, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v599, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v602, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v605, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v62, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v630, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v65, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v68, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v689, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v698, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v702, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v705, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v708, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v71, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v711, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v714, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v739, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v74, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v798, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v807, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v811, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v814, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v817, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v820, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v823, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v848, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v907, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v916, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v920, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v923, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v926, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v929, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v932, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v957, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v96, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v120, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v152, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v184, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v216, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v248, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v280, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v312, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v320 */
    /* JADX WARN: Type inference failed for: r2v324 */
    /* JADX WARN: Type inference failed for: r2v340 */
    /* JADX WARN: Type inference failed for: r2v354 */
    /* JADX WARN: Type inference failed for: r2v355 */
    /* JADX WARN: Type inference failed for: r2v356 */
    /* JADX WARN: Type inference failed for: r2v58, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v88, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v21 */
    /* JADX WARN: Type inference failed for: r32v22 */
    /* JADX WARN: Type inference failed for: r32v23 */
    /* JADX WARN: Type inference failed for: r32v29 */
    /* JADX WARN: Type inference failed for: r32v30 */
    /* JADX WARN: Type inference failed for: r32v31 */
    /* JADX WARN: Type inference failed for: r32v32 */
    /* JADX WARN: Type inference failed for: r32v36 */
    /* JADX WARN: Type inference failed for: r32v37 */
    /* JADX WARN: Type inference failed for: r32v38 */
    /* JADX WARN: Type inference failed for: r32v43 */
    /* JADX WARN: Type inference failed for: r32v5 */
    /* JADX WARN: Type inference failed for: r42v0, types: [in.gov.eci.bloapp.views.fragments.checklist.form6.Form6, in.gov.eci.bloapp.views.fragments.checklist.form6.Hilt_Form6] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v60 */
    /* JADX WARN: Type inference failed for: r8v64 */
    /* JADX WARN: Type inference failed for: r8v66 */
    /* JADX WARN: Type inference failed for: r8v67 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42 */
    public void onActivityResult(int i, int i2, Intent intent) {
        ?? r32;
        String str;
        ?? r12;
        String str2;
        String str3;
        String str4;
        ?? r11;
        ?? r15;
        int i3;
        Exception exc;
        Exception exc2;
        Exception exc3;
        Exception exc4;
        Exception exc5;
        Exception exc6;
        Exception exc7;
        Exception exc8;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        ?? r7;
        double dRound;
        String str5;
        ?? r13;
        String str6;
        ?? r33;
        ?? r14;
        ?? r16;
        ?? r2;
        Exception exc9;
        String str7;
        String str8;
        ?? r17;
        String str9;
        ?? r18;
        String str10;
        boolean z;
        boolean z2;
        ?? r19;
        ?? r34;
        ?? r110;
        ?? r35;
        ?? r9;
        char c;
        int i4 = i;
        ?? r111 = i2;
        super.onActivityResult(i, i2, intent);
        if (r111 != -1) {
            this.alertDialog.dismiss();
        }
        ?? r10 = "/";
        ?? r8 = 80;
        String str11 = TAG;
        String str12 = "ALERT";
        ?? r3 = 0;
        boolean z3 = false;
        boolean z4 = false;
        if (i4 == 105 && r111 == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery2 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                    Logger.d(TAG, Arrays.toString(strArrSplit2));
                    try {
                        if (this.filesize < 1024) {
                            try {
                                String str13 = this.stateCode;
                                String str14 = this.asmblyNO;
                                String str15 = this.partNo;
                                String str16 = this.filepathimg;
                                try {
                                    String str17 = this.saveImageFileName;
                                    try {
                                        String str18 = this.token;
                                        try {
                                            String str19 = this.referenceNo;
                                            String str20 = this.after2004Str;
                                            z = false;
                                            str12 = "ALERT";
                                            str11 = TAG;
                                            str2 = "";
                                            str3 = "/";
                                            try {
                                                uploadPhoto(str13, str14, str15, str16, str17, str18, str19, str20);
                                                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                                this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                                this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                                this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                                this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                                ImageView imageView = this.binding.annexureDIncludedLayout.imageAfter2004self;
                                                byte[] bArr = this.pdfbyteArray;
                                                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                                this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                str10 = "KB";
                                                try {
                                                    this.binding.annexureDIncludedLayout.after2004selfSize.setText(this.filesize + str10);
                                                    z2 = false;
                                                    str4 = "Image size exceeded 2MB limit.";
                                                    r19 = 8;
                                                    r110 = str10;
                                                    r34 = str12;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    exc9 = e;
                                                    r2 = z;
                                                    str4 = "Image size exceeded 2MB limit.";
                                                    r16 = 8;
                                                    r14 = str10;
                                                    r33 = str12;
                                                    str = str11;
                                                    Log.e(str, exc9.toString());
                                                    r3 = r2;
                                                    r11 = r16;
                                                    r12 = r14;
                                                    r32 = r33;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str10 = "KB";
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            str10 = "KB";
                                            str2 = "";
                                            str3 = "/";
                                            z = false;
                                            exc9 = e;
                                            r2 = z;
                                            str4 = "Image size exceeded 2MB limit.";
                                            r16 = 8;
                                            r14 = str10;
                                            r33 = str12;
                                            str = str11;
                                            Log.e(str, exc9.toString());
                                            r3 = r2;
                                            r11 = r16;
                                            r12 = r14;
                                            r32 = r33;
                                            r15 = r3;
                                            if (i == 106) {
                                                i3 = i2;
                                                if (i3 == -1) {
                                                    try {
                                                        Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream2);
                                                        this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
                                                    } catch (Exception e5) {
                                                        Logger.d(str2, e5.getMessage());
                                                    }
                                                    try {
                                                        saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                                                        cursorQuery = getActivity().getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                        try {
                                                            if (cursorQuery.getCount() <= 0) {
                                                                cursorQuery.close();
                                                                throw new IllegalArgumentException(this.imgmsg);
                                                            }
                                                            cursorQuery.moveToFirst();
                                                            strArrSplit = saveImagePath.getPath().split(str3);
                                                            Logger.d(str, Arrays.toString(strArrSplit));
                                                            try {
                                                                if (this.filesize < 1024) {
                                                                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                                                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                                                                    ImageView imageView2 = this.binding.annexureDIncludedLayout.imageList3;
                                                                    byte[] bArr2 = this.pdfbyteArray;
                                                                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, r15 == true ? 1 : 0, bArr2.length));
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                                                                } else if (this.filesize > 2048) {
                                                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r11);
                                                                    showDialog1(r32, str4);
                                                                } else {
                                                                    r7 = r32;
                                                                    this.filesize /= 1024;
                                                                    dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                                                                    if (dRound > 2.0d) {
                                                                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                                                                        showDialog1(r7, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                                                                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                                                                        ImageView imageView3 = this.binding.annexureDIncludedLayout.imageList3;
                                                                        byte[] bArr3 = this.pdfbyteArray;
                                                                        imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, r15 == true ? 1 : 0, bArr3.length));
                                                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                                                                        this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                                        this.binding.annexureDIncludedLayout.list3Size.setText(dRound + "MB");
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } catch (Exception e6) {
                                                                exc8 = e6;
                                                                str11 = str;
                                                            }
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            exc8 = e;
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        str11 = str;
                                                    }
                                                    exc8 = e;
                                                    Log.e(str11, exc8.toString());
                                                    return;
                                                }
                                            } else {
                                                i3 = i2;
                                            }
                                            String str21 = str4;
                                            ?? r20 = r32;
                                            String str22 = str2;
                                            String str23 = str3;
                                            String str24 = str;
                                            if (i != 107) {
                                            }
                                            if (i != 108) {
                                            }
                                            if (i != 109) {
                                            }
                                            if (i != 110) {
                                            }
                                            if (i != 111) {
                                            }
                                            if (i != 112) {
                                            }
                                            if (i != 113) {
                                            }
                                            if (i == 114) {
                                            }
                                            if (i == 115) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        str3 = "/";
                                        str10 = "KB";
                                        str2 = "";
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    str2 = "";
                                    str3 = "/";
                                    str10 = "KB";
                                }
                            } catch (Exception e11) {
                                e = e11;
                                str10 = "KB";
                                str2 = "";
                                str3 = "/";
                            }
                        } else {
                            String str25 = "ALERT";
                            str11 = TAG;
                            r111 = "KB";
                            str2 = "";
                            str3 = "/";
                            ?? r112 = 0;
                            ?? r113 = 0;
                            try {
                                try {
                                    if (this.filesize > 2048) {
                                        try {
                                            c = '\b';
                                            r10 = 8;
                                            try {
                                                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                                                this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(8);
                                                this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(8);
                                                this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(8);
                                                this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                                                String str26 = str25;
                                                showDialog1(str26, "Image size exceeded 2MB limit.");
                                                r8 = str26;
                                            } catch (Exception e12) {
                                                e = e12;
                                                exc9 = e;
                                                r9 = c;
                                                r35 = str25;
                                                r2 = r113;
                                                str4 = "Image size exceeded 2MB limit.";
                                                r16 = r9;
                                                r14 = r111;
                                                r33 = r35;
                                                str = str11;
                                                Log.e(str, exc9.toString());
                                                r3 = r2;
                                                r11 = r16;
                                                r12 = r14;
                                                r32 = r33;
                                            }
                                        } catch (Exception e13) {
                                            e = e13;
                                            c = '\b';
                                        }
                                    } else {
                                        String str27 = str25;
                                        r10 = 8;
                                        try {
                                            this.filesize /= 1024;
                                            double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                                            if (dRound2 > 2.0d) {
                                                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                                                showDialog1(str27, this.imgmsg);
                                                r8 = str27;
                                            } else {
                                                try {
                                                    try {
                                                        str4 = "Image size exceeded 2MB limit.";
                                                        try {
                                                            String str28 = str27;
                                                            i4 = 8;
                                                            r19 = 8;
                                                            i4 = 8;
                                                            try {
                                                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                                                                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                                                                this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                                                                this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                                                                this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                                                                this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                                                                ImageView imageView4 = this.binding.annexureDIncludedLayout.imageAfter2004self;
                                                                byte[] bArr4 = this.pdfbyteArray;
                                                                try {
                                                                    imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                                                                    z2 = false;
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                                                                    this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                                    this.binding.annexureDIncludedLayout.after2004selfSize.setText(dRound2 + "MB");
                                                                    r110 = r111;
                                                                    r34 = str28;
                                                                } catch (Exception e14) {
                                                                    e = e14;
                                                                    z3 = false;
                                                                    str7 = str28;
                                                                    exc9 = e;
                                                                    r2 = z3;
                                                                    r16 = i4;
                                                                    r14 = r111;
                                                                    r33 = str7;
                                                                    str = str11;
                                                                    Log.e(str, exc9.toString());
                                                                    r3 = r2;
                                                                    r11 = r16;
                                                                    r12 = r14;
                                                                    r32 = r33;
                                                                }
                                                            } catch (Exception e15) {
                                                                e = e15;
                                                                z3 = false;
                                                                str7 = str28;
                                                            }
                                                        } catch (Exception e16) {
                                                            e = e16;
                                                            str9 = str27;
                                                            r18 = r111;
                                                            z3 = false;
                                                            r111 = r18;
                                                            str6 = str9;
                                                            i4 = 8;
                                                            str7 = str6;
                                                        }
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        str8 = str27;
                                                        r17 = r111;
                                                        str4 = "Image size exceeded 2MB limit.";
                                                        r18 = r17;
                                                        str9 = str8;
                                                        z3 = false;
                                                        r111 = r18;
                                                        str6 = str9;
                                                        i4 = 8;
                                                        str7 = str6;
                                                        exc9 = e;
                                                        r2 = z3;
                                                        r16 = i4;
                                                        r14 = r111;
                                                        r33 = str7;
                                                        str = str11;
                                                        Log.e(str, exc9.toString());
                                                        r3 = r2;
                                                        r11 = r16;
                                                        r12 = r14;
                                                        r32 = r33;
                                                        r15 = r3;
                                                        if (i == 106) {
                                                            i3 = i2;
                                                            if (i3 == -1) {
                                                                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                                                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                                                bitmap3.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream3);
                                                                this.pdfbyteArray = byteArrayOutputStream3.toByteArray();
                                                                saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                                                                cursorQuery = getActivity().getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                                if (cursorQuery.getCount() <= 0) {
                                                                    cursorQuery.close();
                                                                    throw new IllegalArgumentException(this.imgmsg);
                                                                }
                                                                cursorQuery.moveToFirst();
                                                                strArrSplit = saveImagePath.getPath().split(str3);
                                                                Logger.d(str, Arrays.toString(strArrSplit));
                                                                if (this.filesize < 1024) {
                                                                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                                                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                                                                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                                                                    ImageView imageView5 = this.binding.annexureDIncludedLayout.imageList3;
                                                                    byte[] bArr5 = this.pdfbyteArray;
                                                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, r15 == true ? 1 : 0, bArr5.length));
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                                                                } else if (this.filesize > 2048) {
                                                                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r11);
                                                                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r11);
                                                                    showDialog1(r32, str4);
                                                                } else {
                                                                    r7 = r32;
                                                                    this.filesize /= 1024;
                                                                    dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                                                                    if (dRound > 2.0d) {
                                                                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                                                                        showDialog1(r7, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                                                                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                                                                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                                                                        ImageView imageView6 = this.binding.annexureDIncludedLayout.imageList3;
                                                                        byte[] bArr6 = this.pdfbyteArray;
                                                                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, r15 == true ? 1 : 0, bArr6.length));
                                                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                                                                        this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                                        this.binding.annexureDIncludedLayout.list3Size.setText(dRound + "MB");
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                                exc8 = e;
                                                                Log.e(str11, exc8.toString());
                                                                return;
                                                            }
                                                        } else {
                                                            i3 = i2;
                                                        }
                                                        String str29 = str4;
                                                        ?? r21 = r32;
                                                        String str210 = str2;
                                                        String str211 = str3;
                                                        String str212 = str;
                                                        if (i != 107) {
                                                        }
                                                        if (i != 108) {
                                                        }
                                                        if (i != 109) {
                                                        }
                                                        if (i != 110) {
                                                        }
                                                        if (i != 111) {
                                                        }
                                                        if (i != 112) {
                                                        }
                                                        if (i != 113) {
                                                        }
                                                        if (i == 114) {
                                                        }
                                                        if (i == 115) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    str25 = str27;
                                                    z4 = false;
                                                    r13 = r111;
                                                    str5 = str25;
                                                    str4 = "Image size exceeded 2MB limit.";
                                                    z3 = z4;
                                                    r111 = r13;
                                                    str6 = str5;
                                                    i4 = 8;
                                                    str7 = str6;
                                                }
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            str7 = str27;
                                            z3 = false;
                                            str4 = "Image size exceeded 2MB limit.";
                                            i4 = 8;
                                        }
                                    }
                                    r34 = r8;
                                    z2 = false;
                                    str4 = "Image size exceeded 2MB limit.";
                                    r112 = r10;
                                    r19 = r112;
                                    r110 = r111;
                                } catch (Exception e20) {
                                    exc9 = e20;
                                    r35 = r8;
                                    r9 = r10;
                                    r113 = r112;
                                }
                            } catch (Exception e21) {
                                e = e21;
                            }
                        }
                        str = str11;
                        r3 = z2;
                        r11 = r19;
                        r12 = r110;
                        r32 = r34;
                    } catch (Exception e22) {
                        e = e22;
                        str8 = "ALERT";
                        str11 = TAG;
                        r17 = "KB";
                        str2 = "";
                        str3 = "/";
                    }
                } catch (Exception e23) {
                    e = e23;
                }
            } catch (Exception e24) {
                e = e24;
                str5 = "ALERT";
                str11 = TAG;
                r13 = "KB";
                str2 = "";
                str3 = "/";
            }
            str4 = "Image size exceeded 2MB limit.";
            z3 = z4;
            r111 = r13;
            str6 = str5;
            i4 = 8;
            str7 = str6;
            exc9 = e;
            r2 = z3;
            r16 = i4;
            r14 = r111;
            r33 = str7;
            str = str11;
            Log.e(str, exc9.toString());
            r3 = r2;
            r11 = r16;
            r12 = r14;
            r32 = r33;
        } else {
            r32 = "ALERT";
            str = TAG;
            r12 = "KB";
            str2 = "";
            str3 = "/";
            str4 = "Image size exceeded 2MB limit.";
            r11 = 8;
        }
        r15 = r3;
        if (i == 106) {
            i3 = i2;
            if (i3 == -1) {
                Bitmap bitmap4 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                bitmap4.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream4);
                this.pdfbyteArray = byteArrayOutputStream4.toByteArray();
                saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                cursorQuery = getActivity().getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery.moveToFirst();
                strArrSplit = saveImagePath.getPath().split(str3);
                Logger.d(str, Arrays.toString(strArrSplit));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                    ImageView imageView7 = this.binding.annexureDIncludedLayout.imageList3;
                    byte[] bArr7 = this.pdfbyteArray;
                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, r15 == true ? 1 : 0, bArr7.length));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                    this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.annexureDIncludedLayout.list3Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                } else if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(r11);
                    showDialog1(r32, str4);
                } else {
                    r7 = r32;
                    this.filesize /= 1024;
                    dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r11);
                        showDialog1(r7, this.imgmsg);
                    } else {
                        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.list3Name.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.list3Size.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(r15 == true ? 1 : 0);
                        ImageView imageView8 = this.binding.annexureDIncludedLayout.imageList3;
                        byte[] bArr8 = this.pdfbyteArray;
                        imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, r15 == true ? 1 : 0, bArr8.length));
                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(r15);
                        this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.annexureDIncludedLayout.list3Size.setText(dRound + "MB");
                        return;
                    }
                }
                return;
                exc8 = e;
                Log.e(str11, exc8.toString());
                return;
            }
        } else {
            i3 = i2;
        }
        String str213 = str4;
        ?? r22 = r32;
        String str214 = str2;
        String str215 = str3;
        String str216 = str;
        if (i != 107 && i3 == -1) {
            try {
                Bitmap bitmap5 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                bitmap5.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream5);
                this.pdfbyteArray = byteArrayOutputStream5.toByteArray();
            } catch (Exception e25) {
                Logger.d(str214, e25.getMessage());
            }
            try {
                Uri saveImagePath3 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery3 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath3, null, null, null, null);
                try {
                    if (cursorQuery3.getCount() <= 0) {
                        cursorQuery3.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery3.moveToFirst();
                    String[] strArrSplit3 = saveImagePath3.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit3));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list4Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list4Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView9 = this.binding.annexureDIncludedLayout.imageList4;
                            byte[] bArr9 = this.pdfbyteArray;
                            imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, r15 == true ? 1 : 0, bArr9.length));
                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit3[strArrSplit3.length - 1]);
                            this.binding.annexureDIncludedLayout.list4Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list4Name.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list4Size.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound3 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewList4.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                                this.binding.annexureDIncludedLayout.viewList4.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelList4.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list4Name.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list4Size.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageList4.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView10 = this.binding.annexureDIncludedLayout.imageList4;
                                byte[] bArr10 = this.pdfbyteArray;
                                imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, r15 == true ? 1 : 0, bArr10.length));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(r15);
                                this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit3[strArrSplit3.length - 1]);
                                this.binding.annexureDIncludedLayout.list4Size.setText(dRound3 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e26) {
                        exc7 = e26;
                        str11 = str216;
                    }
                } catch (Exception e27) {
                    e = e27;
                    exc7 = e;
                }
            } catch (Exception e28) {
                e = e28;
                str11 = str216;
            }
            exc7 = e;
            Log.e(str11, exc7.toString());
            return;
        }
        if (i != 108 && i3 == -1) {
            try {
                Bitmap bitmap6 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                bitmap6.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream6);
                this.pdfbyteArray = byteArrayOutputStream6.toByteArray();
            } catch (Exception e29) {
                Logger.d(str214, e29.getMessage());
            }
            try {
                Uri saveImagePath4 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery4 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath4, null, null, null, null);
                try {
                    if (cursorQuery4.getCount() <= 0) {
                        cursorQuery4.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery4.moveToFirst();
                    String[] strArrSplit4 = saveImagePath4.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit4));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list5Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list5Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView11 = this.binding.annexureDIncludedLayout.imageList5;
                            byte[] bArr11 = this.pdfbyteArray;
                            imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, r15 == true ? 1 : 0, bArr11.length));
                            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit4[strArrSplit4.length - 1]);
                            this.binding.annexureDIncludedLayout.list5Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list5Name.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list5Size.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound4 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound4 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewList5.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                                this.binding.annexureDIncludedLayout.viewList5.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelList5.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list5Name.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list5Size.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageList5.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView12 = this.binding.annexureDIncludedLayout.imageList5;
                                byte[] bArr12 = this.pdfbyteArray;
                                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, r15 == true ? 1 : 0, bArr12.length));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(r15);
                                this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit4[strArrSplit4.length - 1]);
                                this.binding.annexureDIncludedLayout.list5Size.setText(dRound4 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e30) {
                        exc6 = e30;
                        str11 = str216;
                    }
                } catch (Exception e31) {
                    e = e31;
                    exc6 = e;
                }
            } catch (Exception e32) {
                e = e32;
                str11 = str216;
            }
            exc6 = e;
            Log.e(str11, exc6.toString());
            return;
        }
        if (i != 109 && i3 == -1) {
            try {
                Bitmap bitmap7 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                bitmap7.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream7);
                this.pdfbyteArray = byteArrayOutputStream7.toByteArray();
            } catch (Exception e33) {
                Logger.d(str214, e33.getMessage());
            }
            try {
                Uri saveImagePath5 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery5 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath5, null, null, null, null);
                try {
                    if (cursorQuery5.getCount() <= 0) {
                        cursorQuery5.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery5.moveToFirst();
                    String[] strArrSplit5 = saveImagePath5.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit5));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                            this.binding.annexureDIncludedLayout.viewList6.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList6.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list6Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list6Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList6.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView13 = this.binding.annexureDIncludedLayout.imageList6;
                            byte[] bArr13 = this.pdfbyteArray;
                            imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, r15 == true ? 1 : 0, bArr13.length));
                            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit5[strArrSplit5.length - 1]);
                            this.binding.annexureDIncludedLayout.list6Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewList6.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelList6.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list6Name.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list6Size.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageList6.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound5 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound5 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewList6.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                                this.binding.annexureDIncludedLayout.viewList6.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelList6.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list6Name.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list6Size.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageList6.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView14 = this.binding.annexureDIncludedLayout.imageList6;
                                byte[] bArr14 = this.pdfbyteArray;
                                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, r15 == true ? 1 : 0, bArr14.length));
                                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(r15);
                                this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit5[strArrSplit5.length - 1]);
                                this.binding.annexureDIncludedLayout.list6Size.setText(dRound5 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e34) {
                        exc5 = e34;
                        str11 = str216;
                    }
                } catch (Exception e35) {
                    e = e35;
                    exc5 = e;
                }
            } catch (Exception e36) {
                e = e36;
                str11 = str216;
            }
            exc5 = e;
            Log.e(str11, exc5.toString());
            return;
        }
        if (i != 110 && i3 == -1) {
            try {
                Bitmap bitmap8 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream8 = new ByteArrayOutputStream();
                bitmap8.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream8);
                this.pdfbyteArray = byteArrayOutputStream8.toByteArray();
            } catch (Exception e37) {
                Logger.d(str214, e37.getMessage());
            }
            try {
                Uri saveImagePath6 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery6 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath6, null, null, null, null);
                try {
                    if (cursorQuery6.getCount() <= 0) {
                        cursorQuery6.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery6.moveToFirst();
                    String[] strArrSplit6 = saveImagePath6.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit6));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                            this.binding.annexureDIncludedLayout.viewList7.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList7.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list7Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list7Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList7.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView15 = this.binding.annexureDIncludedLayout.imageList7;
                            byte[] bArr15 = this.pdfbyteArray;
                            imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, r15 == true ? 1 : 0, bArr15.length));
                            this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit6[strArrSplit6.length - 1]);
                            this.binding.annexureDIncludedLayout.list7Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewList7.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelList7.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list7Name.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list7Size.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageList7.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound6 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound6 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewList7.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                                this.binding.annexureDIncludedLayout.viewList7.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelList7.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list7Name.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list7Size.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageList7.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView16 = this.binding.annexureDIncludedLayout.imageList7;
                                byte[] bArr16 = this.pdfbyteArray;
                                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, r15 == true ? 1 : 0, bArr16.length));
                                this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(r15);
                                this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit6[strArrSplit6.length - 1]);
                                this.binding.annexureDIncludedLayout.list7Size.setText(dRound6 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e38) {
                        exc4 = e38;
                        str11 = str216;
                    }
                } catch (Exception e39) {
                    e = e39;
                    exc4 = e;
                }
            } catch (Exception e40) {
                e = e40;
                str11 = str216;
            }
            exc4 = e;
            Log.e(str11, exc4.toString());
            return;
        }
        if (i != 111 && i3 == -1) {
            try {
                Bitmap bitmap9 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream9 = new ByteArrayOutputStream();
                bitmap9.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream9);
                this.pdfbyteArray = byteArrayOutputStream9.toByteArray();
            } catch (Exception e41) {
                Logger.d(str214, e41.getMessage());
            }
            try {
                Uri saveImagePath7 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery7 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath7, null, null, null, null);
                try {
                    if (cursorQuery7.getCount() <= 0) {
                        cursorQuery7.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery7.moveToFirst();
                    String[] strArrSplit7 = saveImagePath7.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit7));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list2Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list2Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView17 = this.binding.annexureDIncludedLayout.imageList2;
                            byte[] bArr17 = this.pdfbyteArray;
                            imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, r15 == true ? 1 : 0, bArr17.length));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit7[strArrSplit7.length - 1]);
                            this.binding.annexureDIncludedLayout.list2Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list2Name.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.list2Size.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound7 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound7 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list2Name.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.list2Size.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageList2.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView18 = this.binding.annexureDIncludedLayout.imageList2;
                                byte[] bArr18 = this.pdfbyteArray;
                                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, r15 == true ? 1 : 0, bArr18.length));
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(r15);
                                this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit7[strArrSplit7.length - 1]);
                                this.binding.annexureDIncludedLayout.list2Size.setText(dRound7 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e42) {
                        exc3 = e42;
                        str11 = str216;
                    }
                } catch (Exception e43) {
                    e = e43;
                    exc3 = e;
                }
            } catch (Exception e44) {
                e = e44;
                str11 = str216;
            }
            exc3 = e;
            Log.e(str11, exc3.toString());
            return;
        }
        if (i != 112 && i3 == -1) {
            try {
                Bitmap bitmap10 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream10 = new ByteArrayOutputStream();
                bitmap10.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream10);
                this.pdfbyteArray = byteArrayOutputStream10.toByteArray();
            } catch (Exception e45) {
                Logger.d(str214, e45.getMessage());
            }
            try {
                Uri saveImagePath8 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery8 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath8, null, null, null, null);
                if (cursorQuery8.getCount() <= 0) {
                    cursorQuery8.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery8.moveToFirst();
                String[] strArrSplit8 = saveImagePath8.getPath().split(str215);
                Logger.d(str216, Arrays.toString(strArrSplit8));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.cancelList1.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.list1Name.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.list1Size.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(r15 == true ? 1 : 0);
                    ImageView imageView19 = this.binding.annexureDIncludedLayout.imageList1;
                    byte[] bArr19 = this.pdfbyteArray;
                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, r15 == true ? 1 : 0, bArr19.length));
                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(r15);
                    this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit8[strArrSplit8.length - 1]);
                    this.binding.annexureDIncludedLayout.list1Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.cancelList1.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.list1Name.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.list1Size.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(r11);
                    showDialog1(r22, str213);
                    return;
                }
                this.filesize /= 1024;
                double dRound8 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound8 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(r11);
                    showDialog1(r22, this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.cancelList1.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.list1Name.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.list1Size.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.imageList1.setVisibility(r15 == true ? 1 : 0);
                ImageView imageView20 = this.binding.annexureDIncludedLayout.imageList1;
                byte[] bArr20 = this.pdfbyteArray;
                imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, r15 == true ? 1 : 0, bArr20.length));
                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(r15);
                this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit8[strArrSplit8.length - 1]);
                this.binding.annexureDIncludedLayout.list1Size.setText(dRound8 + "MB");
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (i != 113 && i3 == -1) {
            try {
                Bitmap bitmap11 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream11 = new ByteArrayOutputStream();
                bitmap11.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream11);
                this.pdfbyteArray = byteArrayOutputStream11.toByteArray();
            } catch (Exception e46) {
                Logger.d(str214, e46.getMessage());
            }
            try {
                Uri saveImagePath9 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery9 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath9, null, null, null, null);
                try {
                    if (cursorQuery9.getCount() <= 0) {
                        cursorQuery9.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery9.moveToFirst();
                    String[] strArrSplit9 = saveImagePath9.getPath().split(str215);
                    Logger.d(str216, Arrays.toString(strArrSplit9));
                    try {
                        if (this.filesize < 1024) {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                            this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView21 = this.binding.annexureDIncludedLayout.imageBefore2004Self;
                            byte[] bArr21 = this.pdfbyteArray;
                            imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, r15 == true ? 1 : 0, bArr21.length));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit9[strArrSplit9.length - 1]);
                            this.binding.annexureDIncludedLayout.before2004SelfSize.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                        } else if (this.filesize > 2048) {
                            this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(r11);
                            this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(r11);
                            showDialog1(r22, str213);
                        } else {
                            this.filesize /= 1024;
                            double dRound9 = Math.round(this.filesize * 100.0d) / 100.0d;
                            if (dRound9 > 2.0d) {
                                this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(r11);
                                showDialog1(r22, this.imgmsg);
                            } else {
                                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                                this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(r15 == true ? 1 : 0);
                                this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(r15 == true ? 1 : 0);
                                ImageView imageView22 = this.binding.annexureDIncludedLayout.imageBefore2004Self;
                                byte[] bArr22 = this.pdfbyteArray;
                                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, r15 == true ? 1 : 0, bArr22.length));
                                this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit9[strArrSplit9.length - 1]);
                                this.binding.annexureDIncludedLayout.before2004SelfSize.setText(dRound9 + "MB");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e47) {
                        exc2 = e47;
                        str11 = str216;
                    }
                } catch (Exception e48) {
                    e = e48;
                    exc2 = e;
                }
            } catch (Exception e49) {
                e = e49;
                str11 = str216;
            }
            exc2 = e;
            Log.e(str11, exc2.toString());
            return;
        }
        if (i == 114 || i3 != -1) {
            if (i == 115 || i3 != -1) {
                return;
            }
            try {
                Bitmap bitmap12 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream12 = new ByteArrayOutputStream();
                bitmap12.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream12);
                this.pdfbyteArray = byteArrayOutputStream12.toByteArray();
            } catch (Exception e50) {
                Logger.d(str214, e50.getMessage());
            }
            try {
                Uri saveImagePath10 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
                Cursor cursorQuery10 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath10, null, null, null, null);
                if (cursorQuery10.getCount() <= 0) {
                    cursorQuery10.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery10.moveToFirst();
                String[] strArrSplit10 = saveImagePath10.getPath().split(str215);
                Logger.d(str216, Arrays.toString(strArrSplit10));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.anxDSign);
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.signName.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.signSize.setVisibility(r15 == true ? 1 : 0);
                    this.binding.annexureDIncludedLayout.imageSign.setVisibility(r15 == true ? 1 : 0);
                    ImageView imageView23 = this.binding.annexureDIncludedLayout.imageSign;
                    byte[] bArr23 = this.pdfbyteArray;
                    imageView23.setImageBitmap(BitmapFactory.decodeByteArray(bArr23, r15 == true ? 1 : 0, bArr23.length));
                    this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(r15);
                    this.binding.annexureDIncludedLayout.signName.setText(strArrSplit10[strArrSplit10.length - 1]);
                    this.binding.annexureDIncludedLayout.signSize.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.signName.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.signSize.setVisibility(r11);
                    this.binding.annexureDIncludedLayout.imageSign.setVisibility(r11);
                    showDialog1(r22, str213);
                    return;
                }
                this.filesize /= 1024;
                if (Math.round(this.filesize * 100.0d) / 100.0d > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(r11);
                    showDialog1(r22, this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.anxDSign);
                this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.signName.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.signSize.setVisibility(r15 == true ? 1 : 0);
                this.binding.annexureDIncludedLayout.imageSign.setVisibility(r15 == true ? 1 : 0);
                ImageView imageView24 = this.binding.annexureDIncludedLayout.imageSign;
                byte[] bArr24 = this.pdfbyteArray;
                imageView24.setImageBitmap(BitmapFactory.decodeByteArray(bArr24, r15 == true ? 1 : 0, bArr24.length));
                this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(r15);
                this.binding.annexureDIncludedLayout.signName.setText(strArrSplit10[strArrSplit10.length - 1]);
                this.binding.annexureDIncludedLayout.signSize.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                return;
            } catch (Exception e51) {
                Log.e(str216, e51.toString());
                return;
            }
        }
        try {
            Bitmap bitmap13 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
            ByteArrayOutputStream byteArrayOutputStream13 = new ByteArrayOutputStream();
            bitmap13.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream13);
            this.pdfbyteArray = byteArrayOutputStream13.toByteArray();
        } catch (Exception e52) {
            Logger.d(str214, e52.getMessage());
        }
        try {
            Uri saveImagePath11 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, r15 == true ? 1 : 0), this.img);
            Cursor cursorQuery11 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath11, null, null, null, null);
            try {
                if (cursorQuery11.getCount() <= 0) {
                    cursorQuery11.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery11.moveToFirst();
                String[] strArrSplit11 = saveImagePath11.getPath().split(str215);
                Logger.d(str216, Arrays.toString(strArrSplit11));
                try {
                    if (this.filesize < 1024) {
                        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.list2Name.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.list2Size.setVisibility(r15 == true ? 1 : 0);
                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(r15 == true ? 1 : 0);
                        ImageView imageView25 = this.binding.annexureDIncludedLayout.imageList2;
                        byte[] bArr25 = this.pdfbyteArray;
                        imageView25.setImageBitmap(BitmapFactory.decodeByteArray(bArr25, r15 == true ? 1 : 0, bArr25.length));
                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(r15);
                        this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit11[strArrSplit11.length - 1]);
                        this.binding.annexureDIncludedLayout.list2Size.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                    } else if (this.filesize > 2048) {
                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r11);
                        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r11);
                        this.binding.annexureDIncludedLayout.list2Name.setVisibility(r11);
                        this.binding.annexureDIncludedLayout.list2Size.setVisibility(r11);
                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(r11);
                        showDialog1(r22, str213);
                    } else {
                        this.filesize /= 1024;
                        double dRound10 = Math.round(this.filesize * 100.0d) / 100.0d;
                        if (dRound10 > 2.0d) {
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r11);
                            showDialog1(r22, this.imgmsg);
                        } else {
                            uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list2Name.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.list2Size.setVisibility(r15 == true ? 1 : 0);
                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(r15 == true ? 1 : 0);
                            ImageView imageView26 = this.binding.annexureDIncludedLayout.imageList2;
                            byte[] bArr26 = this.pdfbyteArray;
                            imageView26.setImageBitmap(BitmapFactory.decodeByteArray(bArr26, r15 == true ? 1 : 0, bArr26.length));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(r15);
                            this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit11[strArrSplit11.length - 1]);
                            this.binding.annexureDIncludedLayout.list2Size.setText(dRound10 + "MB");
                            return;
                        }
                    }
                    return;
                } catch (Exception e53) {
                    exc = e53;
                    str11 = str216;
                }
            } catch (Exception e54) {
                e = e54;
                exc = e;
            }
        } catch (Exception e55) {
            e = e55;
            str11 = str216;
        }
        exc = e;
        Log.e(str11, exc.toString());
    }

    private boolean isBiharState() {
        return this.stateCode.equalsIgnoreCase("S04");
    }

    private void setSAnnexureDbData() {
        try {
            disbleView();
            if (TextUtils.isEmpty(this.cat)) {
                return;
            }
            if (this.cat.equals("CAT-2") || this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) {
                if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                    openBornInIndiaLayout(this.tempDOB);
                }
                this.binding.annexureDIncludedLayout.formAnnxBornIndia.setChecked(true);
                if (this.cat.equalsIgnoreCase("CAT-2")) {
                    String str = this.ctDocOfSelfUrl;
                    if (str != null) {
                        this.list1ref = str;
                        this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                        DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList1, "self");
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                    String str2 = this.ctDocOfSelfUrl;
                    if (str2 != null) {
                        this.list1ref = str2;
                        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                        DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageBefore2004Self, "self");
                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(this.ctDocOfFatherUrl) && !this.ctDocOfFatherUrl.trim().equalsIgnoreCase("null")) {
                        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setChecked(true);
                        this.List3docName.clear();
                        this.List3docCode.clear();
                        this.flagcat3scenerio1 = "Y";
                        this.flagcat3scenerio2 = "N";
                        getList1(this.list3);
                        DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList2, "father");
                    } else if (!TextUtils.isEmpty(this.ctDocOfMotherUrl) && !this.ctDocOfMotherUrl.trim().equalsIgnoreCase("null")) {
                        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setChecked(true);
                        this.List4docName.clear();
                        this.List4docCode.clear();
                        this.flagcat3scenerio2 = "Y";
                        this.flagcat3scenerio1 = "N";
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda16
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setSAnnexureDbData$86();
                            }
                        }, 2500L);
                        DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList2, "mother");
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                    String str3 = this.ctDocOfSelfUrl;
                    if (str3 != null) {
                        this.list1ref = str3;
                        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                        DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageAfter2004self, "self");
                    }
                    if (!TextUtils.isEmpty(this.isParentsIndian) && this.isParentsIndian.equalsIgnoreCase("Y")) {
                        if (!TextUtils.isEmpty(this.ctDocOfFatherUrl) && !TextUtils.isEmpty(this.ctDocOfMotherUrl)) {
                            this.binding.annexureDIncludedLayout.parentYesRb.setChecked(true);
                            this.List3docName.clear();
                            this.List4docName.clear();
                            this.List3docCode.clear();
                            this.List4docCode.clear();
                            this.flagcat4scenerio1 = "Y";
                            this.motherNationality = "Indian";
                            this.fatherNationality = "Indian";
                            getList1(this.list3);
                            getList1(this.list4);
                            this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                            DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList3, "father");
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                            DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList4, "mother");
                        }
                    } else if (!TextUtils.isEmpty(this.isParentsIndian) && this.isParentsIndian.equalsIgnoreCase("N") && !TextUtils.isEmpty(this.ctDocOfFatherUrl) && !TextUtils.isEmpty(this.ctDocOfMotherUrl)) {
                        this.binding.annexureDIncludedLayout.parentNoRb.setChecked(true);
                        this.flagcat4scenerio1 = "N";
                        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                        if (!this.ctDocTypeForFather.contains("L5")) {
                            if (this.ctDocTypeForMother.contains("L5")) {
                                this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(true);
                                this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(false);
                                this.List3docName.clear();
                                this.List5docName.clear();
                                this.List3docCode.clear();
                                this.List5docCode.clear();
                                this.flagcat4scenerio2 = "Y";
                                this.flagcat4scenerio3 = "N";
                                this.motherNationality = "Non-Indian";
                                this.fatherNationality = "Indian";
                                getList1(this.list3);
                                getList1(this.list5);
                                this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                                this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                                this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                                this.binding.annexureDIncludedLayout.indianParentTv2.setText(getString(R.string.father_sr));
                                this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                                this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.mother_sr);
                                this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                                this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                                DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList3, "father");
                                this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList5, "mother");
                            }
                        } else {
                            this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(false);
                            this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(true);
                            this.List4docName.clear();
                            this.List5docName.clear();
                            this.List4docCode.clear();
                            this.List5docCode.clear();
                            this.flagcat4scenerio3 = "Y";
                            this.flagcat4scenerio2 = "N";
                            this.motherNationality = "Indian";
                            this.fatherNationality = "Non-Indian";
                            getList1(this.list4);
                            getList1(this.list5);
                            this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.indianParentTv2.setText(R.string.mother_sr);
                            this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.father_sr);
                            this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                            DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList4, "mother");
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                            DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList5, "father");
                        }
                    }
                }
            } else if (this.cat.equalsIgnoreCase("CAT-5")) {
                if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                    openLayoutForNotBornInIndia();
                }
                this.binding.annexureDIncludedLayout.formAnnxNotBorn.setChecked(true);
                if (this.ctDocTypeForSelf != null) {
                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                    DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList6, "self");
                }
            } else if (this.cat.equalsIgnoreCase("CAT-6")) {
                if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                    openLayoutForIndiaCitizen();
                }
                this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setChecked(true);
                if (!TextUtils.isEmpty(this.ctDocOfSelfUrl)) {
                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                    DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList7, "self");
                }
            }
            if (this.anxDSignUrl != null) {
                this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
                this.binding.annexureDIncludedLayout.tvAnnexDUploadsign.setText("Uploaded signature");
                this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                DisplayImage(this.anxDSignUrl, this.binding.annexureDIncludedLayout.imageSign, "annex");
            }
        } catch (Exception e) {
            Log.e("Form6 CheckList", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSAnnexureDbData$86() {
        try {
            getList1(this.list4);
        } catch (Exception e) {
            Logger.d("Form6", e.toString());
        }
    }

    private void DisplayImage(final String url, final ImageView imageView, final String type) {
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda21
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i, String str) {
                this.f$0.lambda$DisplayImage$87(type, url, imageView, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$DisplayImage$87(String str, String str2, ImageView imageView, int i, String str3) {
        if (str.equalsIgnoreCase("self")) {
            this.base64element1 = str3;
        } else if (str.equalsIgnoreCase("father")) {
            this.base64element2 = str3;
        } else if (str.equalsIgnoreCase("mother")) {
            this.base64element3 = str3;
        } else if (str.equalsIgnoreCase("annex")) {
            this.base64element4 = str3;
        }
        if (str2.contains(".jpg") || str2.contains(this.jpeg) || str2.contains(".png")) {
            byte[] bArrDecode = Base64.decode(str3, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.blo_pdf_thumbnail));
        }
    }

    private void initializeSpinnerTouch() {
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.41
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.42
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.43
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.45
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.46
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.47
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.48
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAcquired.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.49
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6.this.isUserSelected = true;
                return false;
            }
        });
    }

    private void disbleView() {
        this.binding.annexureDIncludedLayout.formAnnxBornIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.formAnnxNotBorn.setEnabled(false);
        this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBefore1987.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutList1.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList1.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList1.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBefore2004.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenSelectParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutList2.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList2.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewFather1OldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.llAfter2004.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelAfter2004self.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentYesRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentNoRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.llParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.selectParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentFatherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentMotherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList3.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewFatherOldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList4.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList4.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewMotherOldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList5.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList5.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList6.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList6.setEnabled(false);
        this.binding.annexureDIncludedLayout.llAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList7.setVisibility(8);
        this.binding.annexureDIncludedLayout.cancelList7.setEnabled(false);
        this.binding.annexureDIncludedLayout.annexureDSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileSign.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(8);
        this.binding.annexureDIncludedLayout.signDeleteList1.setEnabled(false);
    }

    private void showImageDialog(Bitmap img, String name) {
        final Dialog dialog = new Dialog(requireActivity());
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        touchImageView.setImageBitmap(img);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showPersonPdfDialog(String base64elementValue, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_disability_proof_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.disability_proof_pdf_card).findViewById(R.id.disability_proof_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.disability_proof_pdf_card).findViewById(R.id.disability_proof_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.disability_proof_dialog_pdf_name);
        Logger.d(TAG, "base64elementValue " + base64elementValue);
        pDFViewFindViewById.fromBytes(Base64.decode(base64elementValue, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonPdfDialog$90();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonPdfDialog$90() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAnnexD() throws java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        if (!TextUtils.isEmpty(this.checkListForm6Model.getDob())) {
            this.tempDOB = simpleDateFormat2.format(simpleDateFormat.parse(this.checkListForm6Model.getDob()));
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getUncollectableSir())) {
            this.uncollectableSir = this.checkListForm6Model.getUncollectableSir().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getIsExistingElector())) {
            this.isExistingElector = this.checkListForm6Model.getIsExistingElector().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getPrvsEpic())) {
            this.prvsEpic = this.checkListForm6Model.getPrvsEpic().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getCitizenshipTypeCat())) {
            this.cat = this.checkListForm6Model.getCitizenshipTypeCat().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
            this.citizenshipTypeCat = this.checkListForm6Model.getCitizenshipTypeCat().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
        }
        if (isBiharState()) {
            this.binding.declarationSirIncludedLayout.llAnxureDeclaration.setVisibility(8);
            if (!TextUtils.isEmpty(this.checkListForm6Model.getIsExistingElector()) && this.checkListForm6Model.getIsExistingElector().equalsIgnoreCase("Y") && !TextUtils.isEmpty(this.uncollectableSir) && this.checkListForm6Model.getUncollectableSir().equalsIgnoreCase("Y")) {
                this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
                this.binding.annexureDIncludedLayout.isExistingLl.setVisibility(0);
                this.binding.annexureDIncludedLayout.tvIsexisting.setText("Is Existing Elector : Yes");
                this.binding.annexureDIncludedLayout.tvPrevEpic.setText("Previous EPIC : " + (!TextUtils.isEmpty(this.checkListForm6Model.getPrvsEpic()) ? this.checkListForm6Model.getPrvsEpic() : "NA"));
                this.binding.constraintLayout2.setBackgroundColor(Color.parseColor("#FDE2F5"));
            }
            if (!TextUtils.isEmpty(this.citizenshipTypeCat)) {
                this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
                getAnnexValue();
                if (this.selectedButton.trim().equals("Save")) {
                    if (this.checkListForm6Model.getCitizenshipTypeCat().equals("CAT-5") || this.checkListForm6Model.getCitizenshipTypeCat().equals("CAT-6")) {
                        if (!this.checkListForm6Model.getDob().equals(this.checkListForm6OrignalDataModel.getDob())) {
                            this.checkListForm6OrignalDataModel.setDob(this.checkListForm6Model.getDob());
                        }
                    } else if (!this.checkListForm6Model.getDob().equals(this.checkListForm6OrignalDataModel.getDob()) && !checkCategory(this.checkListForm6Model.getDob(), this.checkListForm6OrignalDataModel.getDob())) {
                        this.checkListForm6OrignalDataModel.setDob(this.checkListForm6Model.getDob());
                        this.anxDSignUrl = null;
                        this.choice = null;
                        this.cat = null;
                        this.ctDocOfFatherUrl = null;
                        this.ctDocOfMotherUrl = null;
                        this.ctDocOfSelfUrl = null;
                        this.ctDocTypeForFather = null;
                        this.ctDocTypeForMother = null;
                        this.ctDocTypeForSelf = null;
                        this.isParentsIndian = null;
                        this.checkListForm6Model.setAnxDSignUrl(null);
                        this.checkListForm6Model.setCitizenshipType(this.choice);
                        this.checkListForm6Model.setCtDocOfFatherUrl(this.ctDocOfFatherUrl);
                        this.checkListForm6Model.setCtDocOfMotherUrl(this.ctDocOfMotherUrl);
                        this.checkListForm6Model.setCtDocOfSelfUrl(this.ctDocOfSelfUrl);
                        this.checkListForm6Model.setCtDocTypeForFather(this.ctDocTypeForFather);
                        this.checkListForm6Model.setCtDocTypeForMother(this.ctDocTypeForMother);
                        this.checkListForm6Model.setCtDocTypeForSelf(this.ctDocTypeForSelf);
                        this.checkListForm6Model.setIsParentsIndian(this.isParentsIndian);
                        this.cat = checkcategorywithdob(this.checkListForm6Model.getDob());
                    }
                }
                setSAnnexureDbData();
                this.binding.annexureVerification.setVisibility(0);
                return;
            }
            if (TextUtils.isEmpty(this.citizenshipTypeCat)) {
                this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
                this.binding.annexureVerification.setVisibility(8);
                if (this.selectedButton.trim().equals("Save")) {
                    getBundleAnnexureData();
                    return;
                } else {
                    if (this.selectedButton.trim().equals("Cancel")) {
                        getBundleAnnexureData();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
        this.binding.annexureDIncludedLayout.isExistingLl.setVisibility(8);
    }

    private void getAnnexValue() {
        this.anxDSignUrl = this.checkListForm6Model.getAnxDSignUrl();
        this.choice = this.checkListForm6Model.getCitizenshipType();
        this.cat = this.checkListForm6Model.getCitizenshipTypeCat();
        this.ctDocOfFatherUrl = this.checkListForm6Model.getCtDocOfFatherUrl();
        this.ctDocOfMotherUrl = this.checkListForm6Model.getCtDocOfMotherUrl();
        this.ctDocOfSelfUrl = this.checkListForm6Model.getCtDocOfSelfUrl();
        this.ctDocTypeForFather = this.checkListForm6Model.getCtDocTypeForFather();
        this.ctDocTypeForMother = this.checkListForm6Model.getCtDocTypeForMother();
        this.ctDocTypeForSelf = this.checkListForm6Model.getCtDocTypeForSelf();
        this.isParentsIndian = this.checkListForm6Model.getIsParentsIndian();
        this.uncollectableSir = this.checkListForm6Model.getUncollectableSir();
        this.isExistingElector = this.checkListForm6Model.getIsExistingElector();
        this.prvsEpic = this.checkListForm6Model.getPrvsEpic();
    }

    private void getBundleAnnexureData() {
        this.doctypeselfURL = this.annexureModel.getList1ref();
        this.cat = this.annexureModel.getCat();
        this.choice = this.annexureModel.getChoice();
        this.flagcat3scenerio1 = this.annexureModel.getFlagcat3scenerio1();
        this.flagcat3scenerio2 = this.annexureModel.getFlagcat3scenerio2();
        this.docURLFather = this.annexureModel.getList3Ref();
        this.after2004docURLFather = this.annexureModel.getList3Ref();
        this.docURLMother = this.annexureModel.getList4Ref();
        this.after2004docURLMother = this.annexureModel.getList4Ref();
        this.flagcat4scenerio1 = this.annexureModel.getFlagcat4scenerio1();
        this.flagcat4scenerio3 = this.annexureModel.getFlagcat4scenerio3();
        this.flagcat4scenerio2 = this.annexureModel.getFlagcat4scenerio2();
        this.bornOutofIndiadocURL = this.annexureModel.getList6ref();
        this.citizenAquuireddocURL = this.annexureModel.getList7ref();
        this.anxDSignUrl = this.annexureModel.getAnxDSignUrl();
        if (this.cat.equalsIgnoreCase("CAT-2")) {
            String list1Code = this.annexureModel.getList1Code();
            this.doctypeself = list1Code;
            this.ctDocTypeForSelf = list1Code;
        }
        if (this.cat.equalsIgnoreCase("CAT-3")) {
            String list1Code2 = this.annexureModel.getList1Code();
            this.doctypeself = list1Code2;
            this.ctDocTypeForSelf = list1Code2;
            String list3code = this.annexureModel.getList3code();
            this.doctypeFather = list3code;
            this.ctDocTypeForFather = list3code;
            String list4code = this.annexureModel.getList4code();
            this.doctypeMother = list4code;
            this.ctDocTypeForMother = list4code;
        }
        if (this.cat.equalsIgnoreCase("CAT-4")) {
            String list1Code3 = this.annexureModel.getList1Code();
            this.doctypeself = list1Code3;
            this.ctDocTypeForSelf = list1Code3;
            if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                this.after2004doctypeFather = this.annexureModel.getList3code();
                String list4code2 = this.annexureModel.getList4code();
                this.after2004doctypeMother = list4code2;
                this.ctDocTypeForFather = this.after2004doctypeFather;
                this.ctDocTypeForMother = list4code2;
            } else if (this.flagcat4scenerio1.equalsIgnoreCase("N")) {
                if (this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                    this.after2004doctypeFather = this.annexureModel.getList5code();
                    String list4code3 = this.annexureModel.getList4code();
                    this.after2004doctypeMother = list4code3;
                    this.ctDocTypeForFather = this.after2004doctypeFather;
                    this.ctDocTypeForMother = list4code3;
                } else if (this.flagcat4scenerio2.equalsIgnoreCase("Y")) {
                    this.after2004doctypeFather = this.annexureModel.getList3code();
                    String list5code = this.annexureModel.getList5code();
                    this.after2004doctypeMother = list5code;
                    this.ctDocTypeForFather = this.after2004doctypeFather;
                    this.ctDocTypeForMother = list5code;
                }
            }
        }
        if (this.cat.equalsIgnoreCase("CAT-5")) {
            String list6code = this.annexureModel.getList6code();
            this.bornOutofIndiadoctype = list6code;
            this.ctDocTypeForSelf = list6code;
        }
        if (this.cat.equalsIgnoreCase("CAT-6")) {
            String list7code = this.annexureModel.getList7code();
            this.citizenAquuireddoctype = list7code;
            this.ctDocTypeForSelf = list7code;
        }
        setSAnnexureBundleData();
    }

    private void setSAnnexureBundleData() {
        if (TextUtils.isEmpty(this.choice)) {
            return;
        }
        if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
            if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                openBornInIndiaLayout(this.tempDOB);
            }
            this.binding.annexureDIncludedLayout.formAnnxBornIndia.setChecked(true);
            if (!TextUtils.isEmpty(this.cat)) {
                if (this.cat.equalsIgnoreCase("CAT-2")) {
                    if (!TextUtils.isEmpty(this.doctypeselfURL)) {
                        this.list1ref = this.doctypeselfURL;
                        this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                        DisplayImagebundleData(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageList1, this.binding.annexureDIncludedLayout.list1Name, this.binding.annexureDIncludedLayout.list1Size);
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                    if (!TextUtils.isEmpty(this.doctypeselfURL)) {
                        this.list1ref = this.doctypeselfURL;
                        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                        DisplayImagebundleData(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageBefore2004Self, this.binding.annexureDIncludedLayout.before2004SelfName, this.binding.annexureDIncludedLayout.before2004SelfSize);
                        if (!TextUtils.isEmpty(this.flagcat3scenerio1) && this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                            this.binding.annexureDIncludedLayout.betweenParentFatherRb.setChecked(true);
                            this.List3docName.clear();
                            this.List3docCode.clear();
                            this.flagcat3scenerio1 = "Y";
                            this.flagcat3scenerio2 = "N";
                            String str = this.docURLFather;
                            this.list3Ref = str;
                            this.ctDocOfFatherUrl = str;
                            getList1(this.list3);
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                            DisplayImagebundleData(this.docURLFather, this.before2004docFileName, this.before2004docFileSize, this.binding.annexureDIncludedLayout.imageList2, this.binding.annexureDIncludedLayout.list2Name, this.binding.annexureDIncludedLayout.list2Size);
                        } else if (!TextUtils.isEmpty(this.flagcat3scenerio2) && this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                            this.binding.annexureDIncludedLayout.betweenParentMotherRb.setChecked(true);
                            this.List4docName.clear();
                            this.List4docCode.clear();
                            this.flagcat3scenerio2 = "Y";
                            this.flagcat3scenerio1 = "N";
                            String str2 = this.docURLMother;
                            this.list4Ref = str2;
                            this.ctDocOfMotherUrl = str2;
                            getList1(this.list4);
                            this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                            DisplayImagebundleData(this.docURLMother, this.before2004docFileName, this.before2004docFileSize, this.binding.annexureDIncludedLayout.imageList2, this.binding.annexureDIncludedLayout.list2Name, this.binding.annexureDIncludedLayout.list2Size);
                        }
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                    String str3 = this.doctypeselfURL;
                    if (str3 != null) {
                        this.list1ref = str3;
                        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                        DisplayImagebundleData(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageAfter2004self, this.binding.annexureDIncludedLayout.after2004selfName, this.binding.annexureDIncludedLayout.after2004selfSize);
                    }
                    if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                        this.binding.annexureDIncludedLayout.parentYesRb.setChecked(true);
                        this.List3docName.clear();
                        this.List4docName.clear();
                        this.List3docCode.clear();
                        this.List4docCode.clear();
                        this.flagcat4scenerio1 = "Y";
                        this.motherNationality = "Indian";
                        this.fatherNationality = "Indian";
                        String str4 = this.after2004docURLFather;
                        this.list3Ref = str4;
                        String str5 = this.after2004docURLMother;
                        this.list4Ref = str5;
                        this.ctDocOfMotherUrl = str5;
                        this.ctDocOfFatherUrl = str4;
                        getList1(this.list3);
                        getList1(this.list4);
                        this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                        DisplayImagebundleData(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList3, this.binding.annexureDIncludedLayout.list3Name, this.binding.annexureDIncludedLayout.list3Size);
                        this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                        DisplayImagebundleData(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList4, this.binding.annexureDIncludedLayout.list4Name, this.binding.annexureDIncludedLayout.list4Size);
                    } else if (this.flagcat4scenerio1.equalsIgnoreCase("N")) {
                        this.binding.annexureDIncludedLayout.parentNoRb.setChecked(true);
                        this.flagcat4scenerio1 = "N";
                        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                        if (this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                            this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(false);
                            this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(true);
                            this.List4docName.clear();
                            this.List5docName.clear();
                            this.List4docCode.clear();
                            this.List5docCode.clear();
                            this.flagcat4scenerio3 = "Y";
                            this.flagcat4scenerio2 = "N";
                            this.motherNationality = "Indian";
                            this.fatherNationality = "Non-Indian";
                            String str6 = this.after2004docURLFather;
                            this.list5Ref = str6;
                            String str7 = this.after2004docURLMother;
                            this.list4Ref = str7;
                            this.ctDocOfMotherUrl = str7;
                            this.ctDocOfFatherUrl = str6;
                            getList1(this.list4);
                            getList1(this.list5);
                            this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.indianParentTv2.setText(R.string.mother_sr);
                            this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.father_sr);
                            this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                            DisplayImagebundleData(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList4, this.binding.annexureDIncludedLayout.list4Name, this.binding.annexureDIncludedLayout.list4Size);
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                            DisplayImagebundleData(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList5, this.binding.annexureDIncludedLayout.list5Name, this.binding.annexureDIncludedLayout.list5Size);
                        } else if (this.flagcat4scenerio2.equalsIgnoreCase("Y")) {
                            this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(true);
                            this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(false);
                            this.List3docName.clear();
                            this.List5docName.clear();
                            this.List3docCode.clear();
                            this.List5docCode.clear();
                            this.flagcat4scenerio2 = "Y";
                            this.flagcat4scenerio3 = "N";
                            this.motherNationality = "Non-Indian";
                            this.fatherNationality = "Indian";
                            String str8 = this.after2004docURLFather;
                            this.list3Ref = str8;
                            String str9 = this.after2004docURLMother;
                            this.list5Ref = str9;
                            this.ctDocOfFatherUrl = str8;
                            this.ctDocOfMotherUrl = str9;
                            getList1(this.list3);
                            getList1(this.list5);
                            this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                            this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.indianParentTv2.setText(getString(R.string.father_sr));
                            this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.mother_sr);
                            this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                            this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                            DisplayImagebundleData(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList3, this.binding.annexureDIncludedLayout.list3Name, this.binding.annexureDIncludedLayout.list3Size);
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                            DisplayImagebundleData(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList5, this.binding.annexureDIncludedLayout.list5Name, this.binding.annexureDIncludedLayout.list5Size);
                        }
                    }
                }
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
            if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                openLayoutForNotBornInIndia();
            }
            this.binding.annexureDIncludedLayout.formAnnxNotBorn.setChecked(true);
            if (this.bornOutofIndiadoctype != null) {
                this.list6ref = this.bornOutofIndiadocURL;
                this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                DisplayImagebundleData(this.bornOutofIndiadocURL, this.bornOutofIndiaFileName, this.bornOutofIndiaFileSize, this.binding.annexureDIncludedLayout.imageList6, this.binding.annexureDIncludedLayout.list6Name, this.binding.annexureDIncludedLayout.list6Size);
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
            if (this.selectedButton.trim().equals("Save") || this.selectedButton.trim().equals("Cancel")) {
                openLayoutForIndiaCitizen();
            }
            this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setChecked(true);
            if (this.citizenAquuireddoctype != null) {
                this.list7ref = this.citizenAquuireddocURL;
                this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                DisplayImagebundleData(this.citizenAquuireddocURL, this.citizenAquuiredFileName, this.citizenAquuiredFileSize, this.binding.annexureDIncludedLayout.imageList7, this.binding.annexureDIncludedLayout.list7Name, this.binding.annexureDIncludedLayout.list7Size);
            }
        }
        if (this.anxDSignUrl != null) {
            this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
            this.binding.annexureDIncludedLayout.signName.setVisibility(0);
            this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
            this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
            this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
            DisplayImagebundleData(this.anxDSignUrl, this.anexSignFileName, this.anexSignFileSize, this.binding.annexureDIncludedLayout.imageSign, this.binding.annexureDIncludedLayout.signName, this.binding.annexureDIncludedLayout.signSize);
        }
    }

    private void DisplayImagebundleData(String url, final String filename, final String fileSize, final ImageView imageView, final TextView Filename, final TextView FileSize) {
        if (url == null && url.equals("") && url.equals("null")) {
            return;
        }
        if (url.contains(".jpg") || url.contains(this.jpeg) || url.contains(".png")) {
            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda8
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str) {
                    Form6.lambda$DisplayImagebundleData$91(imageView, Filename, filename, FileSize, fileSize, i, str);
                }
            });
            return;
        }
        imageView.setImageResource(R.drawable.blo_pfd_thumbnail);
        Filename.setText(filename);
        FileSize.setText(fileSize);
    }

    static /* synthetic */ void lambda$DisplayImagebundleData$91(ImageView imageView, TextView textView, String str, TextView textView2, String str2, int i, String str3) {
        byte[] bArrDecode = Base64.decode(str3, 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        textView.setText(str);
        textView2.setText(str2);
    }

    private String checkcategorywithdob(String dob) {
        Date date;
        if (dob != null && !dob.isEmpty()) {
            try {
                Date date2 = this.simple.parse(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dob)).trim());
                if (date2 != null && (date = this.dateBefore) != null) {
                    if (date2.before(date)) {
                        return "CAT-2";
                    }
                    if (date2.before(this.dateAfter) && date2.after(this.dateBefore)) {
                        return "CAT-3";
                    }
                    if (date2.after(this.dateAfter)) {
                        return "CAT-4";
                    }
                    return "";
                }
                return "";
            } catch (java.text.ParseException e) {
                Logger.d("Form6", e.toString());
                return "";
            }
        }
        return "";
    }

    public boolean checkSameCategoryofAnnexure() {
        return this.citizenshipTypeCat.equals("CAT-5") || this.citizenshipTypeCat.equals("CAT-6") || checkcategorywithdob(this.checkListForm6Model.getDob()).equals(this.citizenshipTypeCat);
    }

    private boolean checkCategory(String modifiedDOB, String origionalDOB) {
        return checkcategorywithdob(modifiedDOB).equalsIgnoreCase(checkcategorywithdob(origionalDOB));
    }

    private boolean validateDateTime() {
        int i = this.visitCountId;
        if (i == 0) {
            this.visitCountId = i + 1;
            Log.d(TAG, "Form8_visitCountId" + this.visitCountId);
            return true;
        }
        if (i > 0) {
            try {
                DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                if (!this.actionDate.isEmpty() && !this.actionDate.equalsIgnoreCase("null")) {
                    String str = this.actionDate;
                    Logger.d(TAG, "Form8_startDateTime" + str);
                    LocalDateTime localDateTime = LocalDateTime.parse(str, dateTimeFormatterOfPattern);
                    Log.d(TAG, "Form8_startTime" + localDateTime);
                    String str2 = LocalDateTime.now().format(dateTimeFormatterOfPattern);
                    Logger.d(TAG, "Form8_currentDateTime" + str2);
                    LocalDateTime localDateTime2 = LocalDateTime.parse(str2, dateTimeFormatterOfPattern);
                    Log.d(TAG, "Form8_endTime" + localDateTime2);
                    Duration durationBetween = Duration.between(localDateTime, localDateTime2);
                    Log.d(TAG, "Form8_duration" + durationBetween);
                    if (durationBetween.toHours() > 24) {
                        this.visitCountId++;
                        return true;
                    }
                    showdialog("ALERT", "Elector was found absent today, please plan next visit tomorrow");
                    return false;
                }
            } catch (Exception e) {
                Log.d("parsing error", e.toString());
            }
        }
        return false;
    }

    public boolean isValideSIRState() {
        return this.stateCode.equalsIgnoreCase("U01") || this.stateCode.equalsIgnoreCase("S05") || this.stateCode.equalsIgnoreCase("U07") || this.stateCode.equalsIgnoreCase("S26") || this.stateCode.equalsIgnoreCase("S06") || this.stateCode.equalsIgnoreCase("S11") || this.stateCode.equalsIgnoreCase("S12") || this.stateCode.equalsIgnoreCase("S24") || this.stateCode.equalsIgnoreCase("S20") || this.stateCode.equalsIgnoreCase("S25") || this.stateCode.equalsIgnoreCase("S22") || this.stateCode.equalsIgnoreCase("U06");
    }

    public void setRelativeType(String relativeType) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Grand Mother");
            return;
        }
        if (relativeType.equals("GFTH")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Grand Father");
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Mother");
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Father");
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Husband");
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText("");
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlRelation.setText(relativeType);
        }
    }

    private void setRelationShipAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.blo_spinner_dropdown, this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    public boolean isValide11SIRState() {
        return this.stateCode.equalsIgnoreCase("S24");
    }

    private void setSelfData() {
        this.binding.declarationSirIncludedLayout.dfRBselfRb.setChecked(true);
        this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(0);
        this.binding.declarationSirIncludedLayout.dfTvtvName.setText(this.checkListForm6Model.getElectorName());
        if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorepicNumber())) {
            this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText(this.checkListForm6Model.getElectorepicNumber());
        } else {
            this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText("");
        }
        if (!TextUtils.isEmpty(this.checkListForm6Model.getElectorRelativeName())) {
            this.binding.declarationSirIncludedLayout.dfTvtvName1.setText(this.checkListForm6Model.getElectorRelativeName());
        }
        setRelativeType1(this.checkListForm6Model.getElectorRelationShip(), this.binding.declarationSirIncludedLayout.dfTvtvRelation);
        this.binding.declarationSirIncludedLayout.dfTvtvState.setText(this.checkListForm6Model.getElectorStateName());
        this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText(this.checkListForm6Model.getElectorAssemblyName());
        this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText(this.checkListForm6Model.getElectorAcNo());
        this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText(this.checkListForm6Model.getElectorPartNumber());
        this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText(this.checkListForm6Model.getElectorPartSerialNumber());
        if (TextUtils.isEmpty(this.checkListForm6Model.getElectorsRelation())) {
            return;
        }
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setSelection(this.relationCodeList.indexOf(this.checkListForm6Model.getElectorsRelation()));
    }

    public void setRelativeType1(String relativeType, TextView textView) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            textView.setText("Grand Mother");
            return;
        }
        if (relativeType.equals("GFTH")) {
            textView.setText("Grand Father");
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            textView.setText("Mother");
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            textView.setText("Father");
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            textView.setText("Husband");
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            textView.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            textView.setText("");
        } else {
            textView.setText(relativeType);
        }
    }

    private void setProgenyData() {
        this.binding.declarationSirIncludedLayout.prevrelativeCardView.setVisibility(0);
        if (this.checkListForm6Model.getRelativeAcNo() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlAcNo.setText(this.checkListForm6Model.getRelativeAcNo());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlAcNo.setText("");
        }
        if (this.checkListForm6Model.getRelativeRelativeName() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlName1.setText(this.checkListForm6Model.getRelativeRelativeName());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlName1.setText("");
        }
        if (this.checkListForm6Model.getRelativeAcName() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlAcName.setText(this.checkListForm6Model.getRelativeAcName());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlAcName.setText("");
        }
        if (this.checkListForm6Model.getRelativeName() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlName.setText(this.checkListForm6Model.getRelativeName());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlName.setText("");
        }
        if (this.checkListForm6Model.getRelativeEpicNumber() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlEpic.setText(this.checkListForm6Model.getRelativeEpicNumber());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlEpic.setText("");
        }
        if (this.checkListForm6Model.getRelativeStateName() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlState.setText(this.checkListForm6Model.getRelativeStateName());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlState.setText("");
        }
        if (this.checkListForm6Model.getRelativePartNo() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlPartNo.setText(this.checkListForm6Model.getRelativePartNo());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlPartNo.setText("");
        }
        if (this.checkListForm6Model.getRelativePartSerialNumber() != null) {
            this.binding.declarationSirIncludedLayout.prevtvRlSrNo.setText(this.checkListForm6Model.getRelativePartSerialNumber());
        } else {
            this.binding.declarationSirIncludedLayout.prevtvRlSrNo.setText("");
        }
        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setSelection(this.relationCodeList.indexOf(this.checkListForm6Model.getElectorsRelation()));
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setEnabled(false);
        setRelativeType(this.checkListForm6Model.getRelativeRelationShip());
    }

    public void markSame() {
        this.checkListForm6Model.setPersonalDetailsSameOrNot("Y");
        this.checkListForm6Model.setAuthenticationSameOrNot("Y");
        this.checkListForm6Model.setDateOfBirthSameOrNot("Y");
        this.checkListForm6Model.setAddressSameOrNot("Y");
        this.checkListForm6Model.setFamilyDetailsSameOrNot("Y");
        this.checkListForm6Model.setDisabilityDetailsSameOrNot("Y");
        this.checkListForm6Model.setAnnexuredetsilsSameorNot("Y");
        this.checkListForm6Model.setSetDeclarationSameOrNot("Y");
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(requireContext()).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6.50
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(Form6.this.requireContext()).removeLocationUpdates(this);
                        if (locationResult == null || locationResult.getLocations().isEmpty()) {
                            return;
                        }
                        int size = locationResult.getLocations().size() - 1;
                        Double.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                        Double.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                        Form6.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                        Form6.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                        Logger.d("latitude and longitudezz", Form6.this.lat + "  " + Form6.this.longi);
                    }
                }, Looper.getMainLooper());
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(requireContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6$$ExternalSyntheticLambda55
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$92(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$92(Task task) {
        try {
            Log.d(TAG, "LocationSettingsResponse ---> " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
            Toast.makeText((Context) requireActivity(), (CharSequence) "GPS is already turned on", 0).show();
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    Log.d(TAG, "Device does not have location");
                }
            } else {
                try {
                    e.startResolutionForResult(requireActivity(), 2);
                } catch (IntentSender.SendIntentException e2) {
                    Logger.d(TAG, "turnOnGPS exception --> " + e2.getMessage());
                }
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }
}
