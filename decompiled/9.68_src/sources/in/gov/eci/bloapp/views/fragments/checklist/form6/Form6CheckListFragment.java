package in.gov.eci.bloapp.views.fragments.checklist.form6;

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
import android.os.LocaleList;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloForm6CheckListFragmentBinding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.model.check_list_form_6.AnnexureModel;
import in.gov.eci.bloapp.model.check_list_form_6.CheckListForm6Model;
import in.gov.eci.bloapp.model.check_list_form_6.CheckListForm6OrignalDataModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class Form6CheckListFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, TextWatcher, View.OnFocusChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ALERT = "Alert";
    private static final String SESSION = "Session Expired. Please Login again.";
    private static final String TAG = "Form6CheckListFragment";
    Date DoB;
    String age;
    AlertDialog alertDialog;
    AnnexureModel annexureModel;
    String asmblyNO;
    String atkbnd;
    BloForm6CheckListFragmentBinding binding;
    Bitmap bitmapPersonImage;
    CheckListForm6Model checkListForm6Model;
    CheckListForm6OrignalDataModel checkListForm6OrignalDataModel;
    String choice;
    String citizenshipTypeCat;
    String commonFileName;
    String ctDocOfFatherUrl;
    String ctDocOfMotherUrl;
    String ctDocOfSelfUrl;
    String ctDocTypeForFather;
    String ctDocTypeForMother;
    String ctDocTypeForSelf;
    Date dateAfter;
    Date dateBefore;
    String dateOfBirthPhotoPhotograph;
    int day;
    String decFormSignUrl;
    String declarationSignPhotograph;
    String disabilityDetailsPhotograph;
    String disablilityCertificateAttached;
    String districtName;
    private String dobQualifyingDate;
    ArrayAdapter<String> documentadapter;
    ArrayAdapter<String> documentadapter1;
    String emailIdRelationType;
    String encodedDeclarationImage;
    String encodedPersonImage;
    String father_relationType;
    String formType;
    FormverificationPayload formverificationPayload;
    String gender;
    String headerForProgenyRB;
    String headerForProgenyorNA;
    String headerForSelfRB;
    String imageFileName;
    String isExistingElector;
    String isParentsIndian;
    String langName;
    String langName2;
    String lastSirYear;
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
    String mSTATECODE;
    String mobileNumberRelaionType;
    int month;
    String partLang;
    String partLang2;
    private String partLangSubString;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
    String personalPhotograph;
    String progencyrelationType;
    String prvsEpic;
    String referenceNo;
    String relationCode;
    ArrayAdapter<String> relationadapter;
    String residenceProofPhotoPhotograph;
    boolean result;
    String rtkbnd;
    String selectedButton;
    String selectedType;
    String self_selfOldRlnType;
    String stateCode;
    String stateName;
    String submittedForRecommendation;
    String tempCategoty;
    String tempDOB;
    String token;
    String typeOfRelation;
    Utils utils;
    View view;
    int visitCount;
    int year;
    String typeRadioButton = SchedulerSupport.NONE;
    String alertText = "Alert";
    String enIn = "en_in";
    String partNo = "";
    String aadharref = "";
    String update = "Update";
    String selfStatus = "N";
    String progenyStatus = "N";
    boolean isFatherEPICValid = true;
    boolean isMotherEPICValid = true;
    boolean isSpouseEPICValid = true;
    boolean isRelativeEPICValid = true;
    String personalDetails = "Personal Details";
    String authentication = "Authentication";
    String dateOfBirth = "DateOfBirth";
    String residenceDetail = "ResidenceDetail";
    String categoryOfDisability = "CategoryOfDisability";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String refreshToken = "";
    String familyDetails = "FamilyDetails";
    String exception = "Exception --> ";
    String percentageOfDisability = "Please enter correct percentage of disability";
    String actionDate = "";
    String bloApp = "BLOAPP";
    CommomUtility commonUtilClass = new CommomUtility();
    String formTypeBundle = "formType";
    CommomUtility commomUtility = new CommomUtility();
    String anyOtherDocument = "Any Other Document";
    String checkListForm6ModelBundle = "CheckListForm6Model";
    String checkListForm6OriginalDataModelBundle = "checkListForm6OrignalDataModel";
    String refNo = "refNo";
    String yyformat = "yyyy-MM-dd";
    String dateFormat = "dd/MM/yyyy";
    String nothingToDo = "Nothing to do";
    String channelidobo = "BLOAPP";
    String referenceNumberString = "referenceNumber ";
    String color000000 = "#000000";
    String color99000000 = "#99000000";
    String chooseFromGallery = "Choose from Gallery";
    String fthr = "FTHR";
    String mthr = "MTHR";
    String hsbn = "HSBN";
    String wifeCode = "WIFE";
    String otherCode = "OTHR";
    String father = "Father";
    String mother = "Mother";
    String wife = "Wife";
    String husband = "Husband";
    String other = "OTHER";
    String cancel = "Cancel";
    String takePhoto = "";
    String reset = "Reset ";
    String invalidAadhaar = "Invalid aadhar";
    String dataResetSuccessfully = "Data reset successfully";
    final Calendar dobcalendar = Calendar.getInstance();
    String bearerText = "Bearer ";
    String fieldName = " ) should be in regional language.";
    String AnnexureDetails = "Annexure Details";
    String DeclarationDetails = "Declaration Details";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String preSignedurl1 = "";
    File file1 = null;
    String messageString = "message";
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda6
        public final void onActivityResult(Object obj) throws Throwable {
            this.f$0.lambda$new$21((ActivityResult) obj);
        }
    });
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
    String takephoto = "";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String chooseFile = "Choose File";
    String applicationpdf = "application/pdf";
    String imgmsg = "Can't obtain file name, cursor is empty";
    String selectDocumentType = "";
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
    String jpeg = ".jpeg";
    Gson gson = new GsonBuilder().setLenient().create();
    String upload = "Please upload file again.";
    ActivityResultLauncher<Intent> activityResultLauncher4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.38
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.after2004Str, 105);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.39
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list3Str, 106);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.40
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list4Str, 107);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher7 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.41
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list5Str, 108);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher8 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.42
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list6Str, 109);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher9 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.43
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list7Str, 110);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher10 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.44
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list4Str, 111);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher11 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.45
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.before1987Str, 112);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher12 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.46
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.before2004Str, 113);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher13 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.47
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.list3Str, 114);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher14 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.48
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.anxDSign, 115);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher15 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.49
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.HandlePdfFile(data, form6CheckListFragment.DeclarationDetails, 116);
            }
        }
    });
    int lastCheckedId = -1;
    int lastCheckedIdchoose = -1;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloForm6CheckListFragmentBinding.inflate(getLayoutInflater());
        Bundle arguments = getArguments();
        this.checkListForm6Model = (CheckListForm6Model) arguments.getSerializable(this.checkListForm6ModelBundle);
        this.annexureModel = (AnnexureModel) arguments.getSerializable("annexuredata");
        this.checkListForm6OrignalDataModel = (CheckListForm6OrignalDataModel) arguments.getSerializable(this.checkListForm6OriginalDataModelBundle);
        this.selectedType = arguments.getString("selectedType");
        this.referenceNo = arguments.getString(this.refNo);
        this.formType = arguments.getString(this.formTypeBundle);
        this.visitCount = arguments.getInt("visitCount");
        this.actionDate = arguments.getString("actionDate");
        this.binding.refNoTv.setText(this.referenceNo);
        this.binding.formTypeTv.setText(this.formType);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.partLang2 = SharedPref.getInstance(requireContext()).getPartNumberLanguageName2();
        this.langName2 = SharedPref.getInstance(requireContext()).getLanguageName2();
        this.dobQualifyingDate = SharedPref.getInstance(requireContext()).getDobQualifyingDate();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.atkbnd = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkbnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.lastSirYear = SharedPref.getInstance(requireContext()).getlastSIRYear();
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.takephoto = getString(R.string.takePhotoMsg1);
        this.takePhoto = getString(R.string.takePhotoMsg1);
        String str = this.partLang;
        if (str == null || str.trim().isEmpty()) {
            this.partLang = this.enIn;
        }
        String str2 = this.partLang2;
        if (str2 == null || str2.trim().isEmpty()) {
            this.partLang2 = this.enIn;
        }
        this.binding.documentSpinner.setOnItemSelectedListener(this);
        this.binding.documentSp.setOnItemSelectedListener(this);
        this.view = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(this.view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.checkListForm6Model.getAddressPoofList());
        this.documentadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.documentSp.setAdapter((SpinnerAdapter) this.documentadapter);
        this.binding.documentSp.setSelection(0);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.checkListForm6Model.getAgeProofList());
        this.documentadapter1 = arrayAdapter2;
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.documentSpinner.setAdapter((SpinnerAdapter) this.documentadapter1);
        this.binding.documentSpinner.setSelection(0);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.checkListForm6Model.getRelationList());
        this.relationadapter = arrayAdapter3;
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.familySp.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.familySp.setSelection(0);
        this.mSTATECODE = this.stateCode.toUpperCase();
        initializeAnnxureData();
        this.formverificationPayload = new FormverificationPayload();
        this.binding.chooseFilePersonalDetailsTv.setOnClickListener(this);
        this.binding.deleteUploadedPersonalDetailsIv.setOnClickListener(this);
        this.binding.chooseFileDateOfBirthTv.setOnClickListener(this);
        this.binding.deleteUploadedDateOfBirthPhotoIv.setOnClickListener(this);
        this.binding.chooseFileResidenceDetailsTv.setOnClickListener(this);
        this.binding.deleteResidenceDetailsIv.setOnClickListener(this);
        this.binding.chooseFileDisabilityDetailsTv.setOnClickListener(this);
        this.binding.deleteDisabilityDetailsIv.setOnClickListener(this);
        this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setOnClickListener(this);
        this.binding.declarationSirIncludedLayout.decFormImageSign.setOnClickListener(this);
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.cancelTv.setOnClickListener(this);
        this.binding.resetTv.setOnClickListener(this);
        this.binding.saveTv.setOnClickListener(this);
        this.binding.dobEd.setOnClickListener(this);
        this.binding.firstnameOfficial.setOnTouchListener(this);
        this.binding.firstnameOfficial2.setOnTouchListener(this);
        this.binding.surnameOfficial.setOnTouchListener(this);
        this.binding.surnameOfficial2.setOnTouchListener(this);
        this.binding.relativeNameOfficial.setOnTouchListener(this);
        this.binding.relativeNameOfficial2.setOnTouchListener(this);
        this.binding.houseNoEdOfficial.setOnTouchListener(this);
        this.binding.houseNoEdOfficial2.setOnTouchListener(this);
        this.binding.streetEdOfficial.setOnTouchListener(this);
        this.binding.streetEdOfficial2.setOnTouchListener(this);
        this.binding.postofficeOfficial.setOnTouchListener(this);
        this.binding.postofficeOfficial2.setOnTouchListener(this);
        this.binding.townEdOfficial.setOnTouchListener(this);
        this.binding.townEdOfficial2.setOnTouchListener(this);
        this.binding.tehsilEdofficial.setOnTouchListener(this);
        this.binding.tehsilEdofficial2.setOnTouchListener(this);
        this.binding.firstnameOfficial.setOnFocusChangeListener(this);
        this.binding.firstnameOfficial2.setOnFocusChangeListener(this);
        this.binding.surnameOfficial.setOnFocusChangeListener(this);
        this.binding.surnameOfficial2.setOnFocusChangeListener(this);
        this.binding.relativeNameOfficial.setOnFocusChangeListener(this);
        this.binding.relativeNameOfficial2.setOnFocusChangeListener(this);
        this.binding.relativeSurnameOfficial.setOnFocusChangeListener(this);
        this.binding.relativeSurnameOfficial2.setOnFocusChangeListener(this);
        this.binding.houseNoEdOfficial.setOnFocusChangeListener(this);
        this.binding.houseNoEdOfficial2.setOnFocusChangeListener(this);
        this.binding.streetEdOfficial.setOnFocusChangeListener(this);
        this.binding.streetEdOfficial2.setOnFocusChangeListener(this);
        this.binding.postofficeOfficial.setOnFocusChangeListener(this);
        this.binding.postofficeOfficial2.setOnFocusChangeListener(this);
        this.binding.townEdOfficial.setOnFocusChangeListener(this);
        this.binding.townEdOfficial2.setOnFocusChangeListener(this);
        this.binding.tehsilEdofficial.setOnFocusChangeListener(this);
        this.binding.tehsilEdofficial2.setOnFocusChangeListener(this);
        this.binding.firstnameOfficial.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.firstNameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.2
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.surNameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.3
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.surnameOfficial.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.4
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.relativeName.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.5
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.relativeNameOfficial.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.6
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.relativeSurname.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.7
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.relativeSurnameOfficial.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.8
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.binding.genderRg.setOnCheckedChangeListener(this);
        this.binding.familyRadioGroup.setOnCheckedChangeListener(this);
        this.binding.emailRg.setOnCheckedChangeListener(this);
        this.binding.mobNumRg.setOnCheckedChangeListener(this);
        this.binding.aadharRg.setOnCheckedChangeListener(this);
        this.binding.yesnoradio.setOnCheckedChangeListener(this);
        this.binding.firstNameEd.addTextChangedListener(this);
        this.binding.firstnameOfficial.addTextChangedListener(this);
        this.binding.firstnameOfficial2.addTextChangedListener(this);
        this.binding.surNameEd.addTextChangedListener(this);
        this.binding.surnameOfficial.addTextChangedListener(this);
        this.binding.surnameOfficial2.addTextChangedListener(this);
        this.binding.relativeName.addTextChangedListener(this);
        this.binding.relativeNameOfficial.addTextChangedListener(this);
        this.binding.relativeNameOfficial2.addTextChangedListener(this);
        this.binding.relativeSurname.addTextChangedListener(this);
        this.binding.relativeSurnameOfficial.addTextChangedListener(this);
        this.binding.relativeSurnameOfficial2.addTextChangedListener(this);
        this.binding.familyMemberName.addTextChangedListener(this);
        this.binding.houseNoEd.addTextChangedListener(this);
        this.binding.houseNoEdOfficial.addTextChangedListener(this);
        this.binding.houseNoEdOfficial2.addTextChangedListener(this);
        this.binding.streetEd.addTextChangedListener(this);
        this.binding.streetEdOfficial.addTextChangedListener(this);
        this.binding.streetEdOfficial2.addTextChangedListener(this);
        this.binding.townEd.addTextChangedListener(this);
        this.binding.townEdOfficial.addTextChangedListener(this);
        this.binding.townEdOfficial2.addTextChangedListener(this);
        this.binding.postofficeEd.addTextChangedListener(this);
        this.binding.postofficeOfficial.addTextChangedListener(this);
        this.binding.postofficeOfficial2.addTextChangedListener(this);
        this.binding.tehsilEd.addTextChangedListener(this);
        this.binding.tehsilEdofficial.addTextChangedListener(this);
        this.binding.tehsilEdofficial2.addTextChangedListener(this);
        this.binding.aadharEd.addTextChangedListener(this);
        selectedValue();
        this.binding.firstNameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.surNameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeName.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeSurname.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.houseNoEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.streetEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.postofficeEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.townEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.tehsilEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.firstNameEd.setInputType(532624);
        this.binding.surNameEd.setInputType(532624);
        this.binding.relativeName.setInputType(532624);
        this.binding.relativeSurname.setInputType(532624);
        this.binding.houseNoEd.setInputType(532624);
        this.binding.postofficeEd.setInputType(532624);
        this.binding.streetEd.setInputType(532624);
        this.binding.townEd.setInputType(532624);
        this.binding.tehsilEd.setInputType(532624);
        this.binding.firstNameEd.setImportantForAutofill(2);
        this.binding.surNameEd.setImportantForAutofill(2);
        this.binding.relativeName.setImportantForAutofill(2);
        this.binding.relativeSurname.setImportantForAutofill(2);
        this.binding.houseNoEd.setImportantForAutofill(2);
        this.binding.postofficeEd.setImportantForAutofill(2);
        this.binding.streetEd.setImportantForAutofill(2);
        this.binding.townEd.setImportantForAutofill(2);
        this.binding.tehsilEd.setImportantForAutofill(2);
        this.partLangSubString = this.partLang.substring(0, 2);
        Log.d(TAG, "partLang ---> " + this.partLangSubString);
        this.binding.firstnameOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.firstnameOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.surnameOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.surnameOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.relativeNameOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.relativeNameOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.relativeSurnameOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.relativeSurnameOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.houseNoEdOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.houseNoEdOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.streetEdOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.streetEdOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.postofficeOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.postofficeOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.townEdOfficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.townEdOfficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.tehsilEdofficial.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.tehsilEdofficial2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.firstnameOfficial.setImportantForAutofill(2);
        this.binding.surnameOfficial.setImportantForAutofill(2);
        this.binding.relativeNameOfficial.setImportantForAutofill(2);
        this.binding.relativeSurnameOfficial.setImportantForAutofill(2);
        this.binding.houseNoEdOfficial.setImportantForAutofill(2);
        this.binding.streetEdOfficial.setImportantForAutofill(2);
        this.binding.townEdOfficial.setImportantForAutofill(2);
        this.binding.tehsilEdofficial.setImportantForAutofill(2);
        this.binding.postofficeOfficial.setImportantForAutofill(2);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str3 = this.dobQualifyingDate;
        if (str3 != "") {
            try {
                calendar2.setTime(simpleDateFormat.parse(str3));
            } catch (ParseException e) {
                Logger.d("", e.getMessage());
            }
        } else {
            calendar2.setTime(date2);
            calendar2.set(2, 9);
            calendar2.set(5, 1);
            calendar2.set(1, 2005);
        }
        final long time2 = calendar2.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda13
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$0(datePicker, i, i2, i3);
            }
        };
        this.binding.dobEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(onDateSetListener, time2, time, view);
            }
        });
        this.binding.other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda15
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$onCreateView$2(compoundButton, z);
            }
        });
        getForm6CheckListData();
        this.alertDialog.dismiss();
        this.utils = new Utils();
        String str4 = SharedPref.getInstance(getContext()).getlastSIRYear();
        this.lastSirYear = str4;
        this.headerForProgenyorNA = getString(R.string.elector_tab_title, new Object[]{str4});
        this.headerForSelfRB = getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSirYear});
        this.headerForProgenyRB = getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSirYear});
        this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.declarationSirIncludedLayout.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                Form6CheckListFragment.this.isFatherEPICValid = false;
                Form6CheckListFragment.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.declarationSirIncludedLayout.fatherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Form6CheckListFragment.this.isFatherEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherName.setEnabled(true);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakFatherName.setClickable(true);
                } else {
                    if (TextUtils.isEmpty(Form6CheckListFragment.this.checkListForm6Model.getFatherorGuardianEpicNo()) || !Form6CheckListFragment.this.checkListForm6Model.getFatherorGuardianEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    Form6CheckListFragment.this.isFatherEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakFatherName.setClickable(false);
                }
            }
        });
        this.binding.declarationSirIncludedLayout.speakFatherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.setSpeakText(form6CheckListFragment.binding.declarationSirIncludedLayout.fatherName);
            }
        });
        this.binding.declarationSirIncludedLayout.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Form6CheckListFragment.this.isMotherEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(true);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(true);
                } else {
                    if (TextUtils.isEmpty(Form6CheckListFragment.this.checkListForm6Model.getMotherEpicNo()) || !Form6CheckListFragment.this.checkListForm6Model.getMotherEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    Form6CheckListFragment.this.isMotherEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(false);
                }
            }
        });
        this.binding.declarationSirIncludedLayout.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                Form6CheckListFragment.this.isMotherEPICValid = false;
                Form6CheckListFragment.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.declarationSirIncludedLayout.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Form6CheckListFragment.this.isMotherEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(true);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(true);
                } else {
                    if (TextUtils.isEmpty(Form6CheckListFragment.this.checkListForm6Model.getMotherEpicNo()) || !Form6CheckListFragment.this.checkListForm6Model.getMotherEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    Form6CheckListFragment.this.isMotherEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(false);
                }
            }
        });
        this.binding.declarationSirIncludedLayout.speakMotherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.setSpeakText(form6CheckListFragment.binding.declarationSirIncludedLayout.motherName);
            }
        });
        this.binding.declarationSirIncludedLayout.spouseEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.16
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Form6CheckListFragment.this.isSpouseEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseName.setEnabled(true);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakSpouseName.setClickable(true);
                } else {
                    if (TextUtils.isEmpty(Form6CheckListFragment.this.checkListForm6Model.getSpouseEpicNo()) || !Form6CheckListFragment.this.checkListForm6Model.getSpouseEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    Form6CheckListFragment.this.isSpouseEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakSpouseName.setClickable(false);
                }
            }
        });
        this.binding.declarationSirIncludedLayout.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                Form6CheckListFragment.this.isSpouseEPICValid = false;
                Form6CheckListFragment.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.declarationSirIncludedLayout.speakSpouseName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.setSpeakText(form6CheckListFragment.binding.declarationSirIncludedLayout.spouseName);
            }
        });
        this.binding.declarationSirIncludedLayout.searchRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.19
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Form6CheckListFragment.this.lastCheckedId != -1 && Form6CheckListFragment.this.lastCheckedId != checkedId) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.searchRG.getCheckedRadioButtonId();
                    if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.isChecked()) {
                        Log.d("typeRadioButton2", Form6CheckListFragment.this.typeRadioButton);
                        Form6CheckListFragment.this.showcategoryChangeDialog(checkedId, "self");
                    } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb.isChecked()) {
                        Form6CheckListFragment.this.showcategoryChangeDialog(checkedId, "progeny");
                    } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.neitherRb.isChecked()) {
                        Form6CheckListFragment.this.showcategoryChangeDialog(checkedId, "NA");
                    }
                } else {
                    Form6CheckListFragment.this.lastCheckedId = checkedId;
                    if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.isChecked()) {
                        Log.d("typeRadioButton2", Form6CheckListFragment.this.typeRadioButton);
                        Form6CheckListFragment.this.setSelfView(checkedId);
                    } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb.isChecked()) {
                        Form6CheckListFragment.this.setProgenyView(checkedId);
                    } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.neitherRb.isChecked()) {
                        Form6CheckListFragment.this.setNeitherView(checkedId);
                    }
                }
                if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb.isChecked()) {
                    Form6CheckListFragment.this.setProgenyView(checkedId);
                } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.neitherRb.isChecked()) {
                    Form6CheckListFragment.this.setNeitherView(checkedId);
                }
            }
        });
        this.binding.declarationSirIncludedLayout.chooseRG.setOnCheckedChangeListener(new AnonymousClass20());
        handleItemListner();
        this.relationCodeList = SharedPref.getInstance(getContext()).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        ArrayList<String> relativeListName = SharedPref.getInstance(getContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        this.relationNameList = relativeListName;
        Log.d("relationNameList spinner", String.valueOf(relativeListName));
        this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6CheckListFragment.this.showDialog2("Alert", "Are you sure you want to delete this relative details?");
            }
        });
        this.binding.declarationSirIncludedLayout.ivUpdateProgeny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setOnClickListener(new AnonymousClass22());
        this.binding.declarationSirIncludedLayout.llDfAddSelf.setOnClickListener(new AnonymousClass23());
        this.binding.declarationSirIncludedLayout.dfTvivUpdate.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$8(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        updateDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.binding.otherEdDetails.setVisibility(0);
        } else {
            this.binding.otherEdDetails.setVisibility(8);
            this.binding.otherEdDetails.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        pickFile(116, this.DeclarationDetails);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$20, reason: invalid class name */
    class AnonymousClass20 implements RadioGroup.OnCheckedChangeListener {
        AnonymousClass20() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, final int checkedId) {
            if (Form6CheckListFragment.this.lastCheckedIdchoose != -1 && Form6CheckListFragment.this.lastCheckedIdchoose != checkedId) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.chooseRG.getCheckedRadioButtonId();
                if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.isChecked()) {
                    new AlertDialog.Builder(Form6CheckListFragment.this.requireContext()).setTitle(Form6CheckListFragment.this.alertText).setMessage("Do you want to change the category type ?").setCancelable(false).setPositiveButton(Form6CheckListFragment.this.getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$20$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$0(checkedId, dialogInterface, i);
                        }
                    }).setNegativeButton(Form6CheckListFragment.this.getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$20$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$1(dialogInterface, i);
                        }
                    }).show();
                    return;
                } else {
                    if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.isChecked()) {
                        new AlertDialog.Builder(Form6CheckListFragment.this.requireContext()).setTitle(Form6CheckListFragment.this.alertText).setMessage("Do you want to change the category type ?").setCancelable(false).setPositiveButton(Form6CheckListFragment.this.getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$20$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onCheckedChanged$2(checkedId, dialogInterface, i);
                            }
                        }).setNegativeButton(Form6CheckListFragment.this.getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$20$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onCheckedChanged$3(dialogInterface, i);
                            }
                        }).show();
                        return;
                    }
                    return;
                }
            }
            Form6CheckListFragment.this.lastCheckedIdchoose = checkedId;
            if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.isChecked()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
                RadioButton radioButton = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb;
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                radioButton.setText(form6CheckListFragment.getString(R.string.ef_progeny_2003_text, new Object[]{form6CheckListFragment.lastSirYear}));
                TextView textView = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tabTV;
                Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                textView.setText(form6CheckListFragment2.getString(R.string.elector_tab_title, new Object[]{form6CheckListFragment2.lastSirYear}));
                Form6CheckListFragment.this.validateAgeWithSirAgeCutOff();
                if (Form6CheckListFragment.this.formverificationPayload != null) {
                    Form6CheckListFragment.this.formverificationPayload.setIs2003Selected("Y");
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.searchRG.clearCheck();
                Form6CheckListFragment.this.lastCheckedId = -1;
            }
            if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.isChecked()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb.setText(Form6CheckListFragment.this.getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tabTV.setText(Form6CheckListFragment.this.getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(Form6CheckListFragment.this.getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(true);
                if (Form6CheckListFragment.this.formverificationPayload != null) {
                    Form6CheckListFragment.this.formverificationPayload.setIs2003Selected("N");
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.searchRG.clearCheck();
                Form6CheckListFragment.this.lastCheckedId = -1;
            }
            Form6CheckListFragment.this.clearRelativeDetailsFromObj();
            Form6CheckListFragment.this.clearSelfDetailsFromObj();
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$0(int i, DialogInterface dialogInterface, int i2) {
            Form6CheckListFragment.this.lastCheckedIdchoose = i;
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
            RadioButton radioButton = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb;
            Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
            radioButton.setText(form6CheckListFragment.getString(R.string.ef_progeny_2003_text, new Object[]{form6CheckListFragment.lastSirYear}));
            TextView textView = Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tabTV;
            Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
            textView.setText(form6CheckListFragment2.getString(R.string.elector_tab_title, new Object[]{form6CheckListFragment2.lastSirYear}));
            Form6CheckListFragment.this.validateAgeWithSirAgeCutOff();
            if (Form6CheckListFragment.this.formverificationPayload != null) {
                Form6CheckListFragment.this.formverificationPayload.setIs2003Selected("Y");
            }
            Form6CheckListFragment.this.lastCheckedId = -1;
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.searchRG.clearCheck();
            Form6CheckListFragment.this.clearRelativeDetailsFromObj();
            Form6CheckListFragment.this.clearSelfDetailsFromObj();
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$1(DialogInterface dialogInterface, int i) {
            if (Form6CheckListFragment.this.lastCheckedIdchoose == Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.getId()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
            } else if (Form6CheckListFragment.this.lastCheckedIdchoose == Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.getId()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.setChecked(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$2(int i, DialogInterface dialogInterface, int i2) {
            Form6CheckListFragment.this.lastCheckedIdchoose = i;
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRb.setText(Form6CheckListFragment.this.getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tabTV.setText(Form6CheckListFragment.this.getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(Form6CheckListFragment.this.getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(true);
            if (Form6CheckListFragment.this.formverificationPayload != null) {
                Form6CheckListFragment.this.formverificationPayload.setIs2003Selected("N");
            }
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.searchRG.clearCheck();
            Form6CheckListFragment.this.lastCheckedId = -1;
            Form6CheckListFragment.this.clearRelativeDetailsFromObj();
            Form6CheckListFragment.this.clearSelfDetailsFromObj();
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$3(DialogInterface dialogInterface, int i) {
            if (Form6CheckListFragment.this.lastCheckedIdchoose == Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.getId()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
            } else if (Form6CheckListFragment.this.lastCheckedIdchoose == Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.getId()) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2025.setChecked(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = new DeclarationFormUpdateDialogFragment();
        declarationFormUpdateDialogFragment.setArguments(getBundle("progeny"));
        declarationFormUpdateDialogFragment.setOnDataReceivedListener(new DeclarationFormUpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda30
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                this.f$0.lambda$onCreateView$4(payload, mappingList, str);
            }
        });
        declarationFormUpdateDialogFragment.show(getChildFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(Payload payload, MappingList mappingList, String str) {
        if (str.equalsIgnoreCase("progeny")) {
            this.progenyStatus = "E";
            if (payload != null) {
                this.binding.declarationSirIncludedLayout.tvRlEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                this.binding.declarationSirIncludedLayout.tvRlName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                this.binding.declarationSirIncludedLayout.tvRlName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                if (!TextUtils.isEmpty(payload.getRelationType())) {
                    String relationType = payload.getRelationType();
                    this.father_relationType = relationType;
                    setRelativeType(relationType, this.binding.declarationSirIncludedLayout.tvRlRelation);
                }
                this.binding.declarationSirIncludedLayout.tvRlState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                this.binding.declarationSirIncludedLayout.tvRlAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                this.binding.declarationSirIncludedLayout.tvRlAcNo.setText(String.valueOf(payload.getOldAcNo()));
                this.binding.declarationSirIncludedLayout.tvRlPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                this.binding.declarationSirIncludedLayout.tvRlSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                setDataInModelRelative(payload);
                this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(0);
                return;
            }
            if (mappingList != null) {
                this.binding.declarationSirIncludedLayout.tvRlEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                this.binding.declarationSirIncludedLayout.tvRlName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                this.binding.declarationSirIncludedLayout.tvRlName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                    this.father_relationType = mappingList.getRelationType();
                    setRelativeType(this.self_selfOldRlnType, this.binding.declarationSirIncludedLayout.tvRlRelation);
                }
                this.binding.declarationSirIncludedLayout.tvRlState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                this.binding.declarationSirIncludedLayout.tvRlAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                this.binding.declarationSirIncludedLayout.tvRlAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                this.binding.declarationSirIncludedLayout.tvRlPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                this.binding.declarationSirIncludedLayout.tvRlSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                setDataInModelRelativeMaping(mappingList);
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$22, reason: invalid class name */
    class AnonymousClass22 implements View.OnClickListener {
        AnonymousClass22() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = new DeclarationFormUpdateDialogFragment();
            declarationFormUpdateDialogFragment.setArguments(Form6CheckListFragment.this.getBundle("progeny"));
            declarationFormUpdateDialogFragment.setOnDataReceivedListener(new DeclarationFormUpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$22$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.OnDataReceivedListener
                public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                    this.f$0.lambda$onClick$0(payload, mappingList, str);
                }
            });
            declarationFormUpdateDialogFragment.show(Form6CheckListFragment.this.getChildFragmentManager(), "CentralDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(Payload payload, MappingList mappingList, String str) {
            if (str.equalsIgnoreCase("progeny")) {
                Form6CheckListFragment.this.progenyStatus = "E";
                if (payload != null) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                    if (!TextUtils.isEmpty(payload.getRelationType())) {
                        Form6CheckListFragment.this.father_relationType = payload.getRelationType();
                        Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                        form6CheckListFragment.setRelativeType(form6CheckListFragment.father_relationType, Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlRelation);
                    }
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlAcNo.setText(String.valueOf(payload.getOldAcNo()));
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                    Form6CheckListFragment.this.setDataInModelRelative(payload);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(0);
                    return;
                }
                if (mappingList != null) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                    if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                        Form6CheckListFragment.this.father_relationType = mappingList.getRelationType();
                        Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                        form6CheckListFragment2.setRelativeType(form6CheckListFragment2.father_relationType, Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlRelation);
                    }
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlState.setText(TextUtils.isEmpty(mappingList.getOldStateCd()) ? "" : mappingList.getOldStateCd());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.tvRlSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                    Form6CheckListFragment.this.setDataInModelRelativeMaping(mappingList);
                }
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$23, reason: invalid class name */
    class AnonymousClass23 implements View.OnClickListener {
        AnonymousClass23() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = new DeclarationFormUpdateDialogFragment();
            declarationFormUpdateDialogFragment.setArguments(Form6CheckListFragment.this.getBundle("self"));
            declarationFormUpdateDialogFragment.setOnDataReceivedListener(new DeclarationFormUpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$23$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.OnDataReceivedListener
                public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                    this.f$0.lambda$onClick$0(payload, mappingList, str);
                }
            });
            declarationFormUpdateDialogFragment.show(Form6CheckListFragment.this.getParentFragmentManager(), "CentralDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(Payload payload, MappingList mappingList, String str) {
            if (str == null || !str.equalsIgnoreCase("self")) {
                return;
            }
            Form6CheckListFragment.this.selfStatus = "E";
            if (payload != null) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(0);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                if (!TextUtils.isEmpty(payload.getRelationType())) {
                    Form6CheckListFragment.this.self_selfOldRlnType = payload.getRelationType();
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.setRelativeType(form6CheckListFragment.self_selfOldRlnType, Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvRelation);
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText(String.valueOf(payload.getOldAcNo()));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                Form6CheckListFragment.this.setDataInModelSelf(payload);
                return;
            }
            if (mappingList != null) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(0);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                    Form6CheckListFragment.this.self_selfOldRlnType = mappingList.getRelationType();
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.setRelativeType(form6CheckListFragment2.self_selfOldRlnType, Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvRelation);
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                Form6CheckListFragment.this.setDataInModelSelfMapping(mappingList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = new DeclarationFormUpdateDialogFragment();
        declarationFormUpdateDialogFragment.setArguments(getBundle("self"));
        declarationFormUpdateDialogFragment.setOnDataReceivedListener(new DeclarationFormUpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda5
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                this.f$0.lambda$onCreateView$6(payload, mappingList, str);
            }
        });
        declarationFormUpdateDialogFragment.show(getChildFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(Payload payload, MappingList mappingList, String str) {
        if (str.equalsIgnoreCase("self")) {
            this.selfStatus = "E";
            if (payload != null) {
                this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                this.binding.declarationSirIncludedLayout.dfTvtvName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                this.binding.declarationSirIncludedLayout.dfTvtvName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                if (!TextUtils.isEmpty(payload.getRelationType())) {
                    String relationType = payload.getRelationType();
                    this.self_selfOldRlnType = relationType;
                    setRelativeType(relationType, this.binding.declarationSirIncludedLayout.dfTvtvRelation);
                }
                this.binding.declarationSirIncludedLayout.dfTvtvState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText(String.valueOf(payload.getOldAcNo()));
                this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                setDataInModelSelf(payload);
                return;
            }
            if (mappingList != null) {
                this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                this.binding.declarationSirIncludedLayout.dfTvtvName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                this.binding.declarationSirIncludedLayout.dfTvtvName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                    String relationType2 = mappingList.getRelationType();
                    this.self_selfOldRlnType = relationType2;
                    setRelativeType(relationType2, this.binding.declarationSirIncludedLayout.dfTvtvRelation);
                }
                this.binding.declarationSirIncludedLayout.dfTvtvState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                setDataInModelSelfMapping(mappingList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(View view) {
        pickFile(116, this.DeclarationDetails);
    }

    private void updateDisplay() {
        this.binding.dobEd.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(this.dobcalendar.getTime()));
        String[] strArrSplit = this.binding.dobEd.getText().toString().split("/");
        this.year = Integer.parseInt(strArrSplit[2]);
        this.month = Integer.parseInt(strArrSplit[1]);
        this.day = Integer.parseInt(strArrSplit[0]);
        String strValueOf = String.valueOf(this.month);
        String strValueOf2 = String.valueOf(this.day);
        if (strValueOf.length() == 1) {
            strValueOf = "0" + strValueOf;
        }
        if (strValueOf2.length() == 1) {
            strValueOf2 = "0" + strValueOf2;
        }
        this.binding.dobEd.setText(strValueOf2 + "/" + strValueOf + "/" + this.year);
        this.age = getAge(this.year, this.month, this.day);
        this.binding.age.setText(this.age);
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

    private void selectedValue() {
        if (this.selectedType.equals(this.personalDetails)) {
            this.binding.personalDetail.setVisibility(0);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(8);
            return;
        }
        if (this.selectedType.equals(this.authentication)) {
            this.binding.authentication.setVisibility(0);
            this.binding.personalDetail.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(8);
            this.binding.saveTv.setText(this.update);
            return;
        }
        if (this.selectedType.equals(this.dateOfBirth)) {
            this.binding.dateOfBirth.setVisibility(0);
            this.binding.declarationDetail.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.saveTv.setText(this.update);
            return;
        }
        if (this.selectedType.equals(this.residenceDetail)) {
            this.binding.residenceDetails.setVisibility(0);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(8);
            this.binding.saveTv.setText(this.update);
            return;
        }
        if (this.selectedType.equals(this.categoryOfDisability)) {
            this.binding.categoryLayout.setVisibility(0);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(8);
            this.binding.saveTv.setText(this.update);
            return;
        }
        if (this.selectedType.equals(this.familyDetails)) {
            this.binding.familyDetailsLayout.setVisibility(0);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(8);
            this.binding.saveTv.setText(this.update);
            return;
        }
        if (this.selectedType.equals(this.AnnexureDetails)) {
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
            this.binding.saveTv.setText(this.update);
            checkAnnexD();
            return;
        }
        if (this.selectedType.equals(this.DeclarationDetails)) {
            this.binding.familyDetailsLayout.setVisibility(8);
            this.binding.categoryLayout.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authentication.setVisibility(8);
            this.binding.dateOfBirth.setVisibility(8);
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.declarationDetail.setVisibility(0);
            this.binding.saveTv.setText(this.update);
            setDeclarationDetails();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131362490) {
            onCancelButton();
            return;
        }
        if (v.getId() == 2131362639) {
            onCancelButton();
            return;
        }
        if (v.getId() == 2131365711) {
            onResetButton();
            return;
        }
        if (v.getId() == 2131365778) {
            this.alertDialog.show();
            try {
                onSaveButton();
            } catch (Exception e) {
                Logger.d(TAG, "Exception " + e.getMessage());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$9();
                }
            }, 2000L);
            return;
        }
        if (v.getId() == 2131362812) {
            selectImage();
            return;
        }
        if (v.getId() == 2131363169) {
            this.personalPhotograph = "";
            this.binding.choosePhotoPersonalDetails.setText("");
            this.binding.passPhotoPersonalDetails.setVisibility(8);
            this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color000000));
            return;
        }
        if (v.getId() == 2131362808) {
            selectImage();
            return;
        }
        if (v.getId() == 2131363168) {
            this.dateOfBirthPhotoPhotograph = "";
            this.binding.choosePhotDateOfBirth.setText("");
            this.binding.passPhotoDateOfBirth.setVisibility(8);
            this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color000000));
            return;
        }
        if (v.getId() == 2131362813) {
            selectImage();
            return;
        }
        if (v.getId() == 2131363167) {
            this.residenceProofPhotoPhotograph = "";
            this.binding.choosePhotResidenceDetails.setText("");
            this.binding.passPhotoResidenceDetails.setVisibility(8);
            this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color000000));
            return;
        }
        if (v.getId() == 2131362809) {
            selectImage();
            return;
        }
        if (v.getId() == 2131363166) {
            this.disabilityDetailsPhotograph = "";
            this.binding.choosePhotDisabilityDetails.setText("");
            this.binding.passPhotoDisabilityDetails.setVisibility(8);
            this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
            return;
        }
        if (v.getId() == 2131363113) {
            this.declarationSignPhotograph = "";
            this.binding.declarationSirIncludedLayout.decFormSignName.setText("");
            this.binding.declarationSirIncludedLayout.decFormSignSize.setText("");
            this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(8);
            this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(8);
            this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setVisibility(0);
            this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(true);
            this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setTextColor(Color.parseColor(this.color000000));
            return;
        }
        if (v.getId() == 2131363111 && this.declarationSignPhotograph.endsWith(".pdf")) {
            try {
                showSignaturePdfDialog(this.encodedDeclarationImage);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$9() {
        this.alertDialog.dismiss();
    }

    private void selectImage() {
        if (this.selectedType.equals(this.personalDetails)) {
            final CharSequence[] charSequenceArr = {this.takePhoto, this.chooseFromGallery, this.cancel};
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
            builder.setTitle("Add Photo!");
            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda23
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$selectImage$11(charSequenceArr, dialogInterface, i);
                }
            });
            builder.show();
            return;
        }
        final CharSequence[] charSequenceArr2 = {this.takePhoto, this.chooseFromGallery, "Choose PDF from Gallery", this.cancel};
        android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder(getContext());
        builder2.setTitle("Add Photo!");
        builder2.setItems(charSequenceArr2, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$13(charSequenceArr2, dialogInterface, i);
            }
        });
        builder2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$11(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takePhoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals(this.chooseFromGallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(this.cancel)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$selectImage$10();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$10() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$13(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takePhoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
            return;
        }
        if (charSequenceArr[i].equals(this.chooseFromGallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            this.alertDialog.show();
            openfile();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$selectImage$12();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$12() {
        this.alertDialog.dismiss();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            if (data == null) {
                throw new AssertionError();
            }
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.d(TAG, this.exception + e.getMessage());
            }
            try {
                Cursor cursorQuery = requireContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image"), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                }
                cursorQuery.moveToFirst();
                if (this.filesize < 1024) {
                    if (this.selectedType.equals(this.personalDetails)) {
                        this.binding.passPhotoPersonalDetails.setVisibility(0);
                        ImageView imageView = this.binding.personalDetailPhoto;
                        byte[] bArr = this.pdfbyteArray;
                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                        this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        faceRecognition(this.stateCode, this.saveImageFileName);
                    } else if (this.selectedType.equals(this.dateOfBirth)) {
                        ImageView imageView2 = this.binding.dateOfBirthPhoto;
                        byte[] bArr2 = this.pdfbyteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                        this.binding.chooseFileDateOfBirthSizeTv.setText(this.filesize + "KB");
                        this.binding.passPhotoDateOfBirth.setVisibility(0);
                        this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    } else if (this.selectedType.equals(this.residenceDetail)) {
                        ImageView imageView3 = this.binding.residenceDetailsPhoto;
                        byte[] bArr3 = this.pdfbyteArray;
                        imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                        this.binding.chooseFileResidenceSizeTv.setText(this.filesize + "KB");
                        this.binding.passPhotoResidenceDetails.setVisibility(0);
                        this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    } else if (this.selectedType.equals(this.categoryOfDisability)) {
                        ImageView imageView4 = this.binding.disabilityDetailsPhoto;
                        byte[] bArr4 = this.pdfbyteArray;
                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                        this.binding.chooseFileDisablitySizeTv.setText(this.filesize + "KB");
                        this.binding.passPhotoDisabilityDetails.setVisibility(0);
                        this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    }
                } else if (this.filesize > 2048) {
                    if (this.selectedType.equals(this.personalDetails)) {
                        this.personalPhotograph = "";
                        this.binding.choosePhotoPersonalDetails.setText("");
                        this.binding.passPhotoPersonalDetails.setVisibility(8);
                        this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color000000));
                    } else if (this.selectedType.equals(this.dateOfBirth)) {
                        this.dateOfBirthPhotoPhotograph = "";
                        this.binding.choosePhotDateOfBirth.setText("");
                        this.binding.passPhotoDateOfBirth.setVisibility(8);
                        this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color000000));
                    } else if (this.selectedType.equals(this.residenceDetail)) {
                        this.residenceProofPhotoPhotograph = "";
                        this.binding.choosePhotResidenceDetails.setText("");
                        this.binding.passPhotoResidenceDetails.setVisibility(8);
                        this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color000000));
                    } else if (this.selectedType.equals(this.categoryOfDisability)) {
                        this.disabilityDetailsPhotograph = "";
                        this.binding.choosePhotDisabilityDetails.setText("");
                        this.binding.passPhotoDisabilityDetails.setVisibility(8);
                        this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda44
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onActivityResult$14();
                        }
                    }, 2000L);
                    this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Image size exceeded 2MB limit.");
                } else {
                    this.filesize /= 1024;
                    double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                    if (this.selectedType.equals(this.personalDetails)) {
                        this.binding.passPhotoPersonalDetails.setVisibility(0);
                        ImageView imageView5 = this.binding.personalDetailPhoto;
                        byte[] bArr5 = this.pdfbyteArray;
                        imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                        this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        faceRecognition(this.stateCode, this.saveImageFileName);
                    } else if (this.selectedType.equals(this.dateOfBirth)) {
                        ImageView imageView6 = this.binding.dateOfBirthPhoto;
                        byte[] bArr6 = this.pdfbyteArray;
                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                        this.binding.chooseFileDateOfBirthSizeTv.setText(dRound + "MB");
                        this.binding.passPhotoDateOfBirth.setVisibility(0);
                        this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    } else if (this.selectedType.equals(this.residenceDetail)) {
                        ImageView imageView7 = this.binding.residenceDetailsPhoto;
                        byte[] bArr7 = this.pdfbyteArray;
                        imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                        this.binding.chooseFileResidenceSizeTv.setText(dRound + "MB");
                        this.binding.passPhotoResidenceDetails.setVisibility(0);
                        this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    } else if (this.selectedType.equals(this.categoryOfDisability)) {
                        ImageView imageView8 = this.binding.disabilityDetailsPhoto;
                        byte[] bArr8 = this.pdfbyteArray;
                        imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                        this.binding.chooseFileDisablitySizeTv.setText(dRound + "MB");
                        this.binding.passPhotoDisabilityDetails.setVisibility(0);
                        this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                        uploadImage(this.saveImageFileName);
                    }
                }
                cursorQuery.close();
                return;
            } catch (Exception e2) {
                Logger.d("CONTENT", e2.getMessage());
                return;
            }
        }
        if (requestCode == 105 && resultCode == -1) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream2);
                this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery2 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery2.getCount() <= 0) {
                    cursorQuery2.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery2.moveToFirst();
                String[] strArrSplit = saveImagePath.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                    this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                    ImageView imageView9 = this.binding.annexureDIncludedLayout.imageAfter2004self;
                    byte[] bArr9 = this.pdfbyteArray;
                    imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                    this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.annexureDIncludedLayout.after2004selfSize.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(8);
                    this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(8);
                    this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound2 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelAfter2004self.setVisibility(0);
                this.binding.annexureDIncludedLayout.after2004selfName.setVisibility(0);
                this.binding.annexureDIncludedLayout.after2004selfSize.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                ImageView imageView10 = this.binding.annexureDIncludedLayout.imageAfter2004self;
                byte[] bArr10 = this.pdfbyteArray;
                imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
                this.binding.annexureDIncludedLayout.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.annexureDIncludedLayout.after2004selfSize.setText(dRound2 + "MB");
                return;
            } catch (Exception e4) {
                Log.e(TAG, e4.toString());
                return;
            }
        }
        if (requestCode == 106 && resultCode == -1) {
            try {
                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                bitmap3.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream3);
                this.pdfbyteArray = byteArrayOutputStream3.toByteArray();
            } catch (Exception e5) {
                Logger.d("", e5.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery3 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                if (cursorQuery3.getCount() <= 0) {
                    cursorQuery3.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery3.moveToFirst();
                String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit2));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                    ImageView imageView11 = this.binding.annexureDIncludedLayout.imageList3;
                    byte[] bArr11 = this.pdfbyteArray;
                    imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                    this.binding.annexureDIncludedLayout.list3Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList3.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list3Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list3Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound3 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                this.binding.annexureDIncludedLayout.list3Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list3Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                ImageView imageView12 = this.binding.annexureDIncludedLayout.imageList3;
                byte[] bArr12 = this.pdfbyteArray;
                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
                this.binding.annexureDIncludedLayout.list3Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                this.binding.annexureDIncludedLayout.list3Size.setText(dRound3 + "MB");
                return;
            } catch (Exception e6) {
                Log.e(TAG, e6.toString());
                return;
            }
        }
        if (requestCode == 107 && resultCode == -1) {
            try {
                Bitmap bitmap4 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                bitmap4.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream4);
                this.pdfbyteArray = byteArrayOutputStream4.toByteArray();
            } catch (Exception e7) {
                Logger.d("", e7.getMessage());
            }
            try {
                Uri saveImagePath3 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery4 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath3, null, null, null, null);
                if (cursorQuery4.getCount() <= 0) {
                    cursorQuery4.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery4.moveToFirst();
                String[] strArrSplit3 = saveImagePath3.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit3));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                    ImageView imageView13 = this.binding.annexureDIncludedLayout.imageList4;
                    byte[] bArr13 = this.pdfbyteArray;
                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit3[strArrSplit3.length - 1]);
                    this.binding.annexureDIncludedLayout.list4Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList4.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list4Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list4Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound4 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound4 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                this.binding.annexureDIncludedLayout.list4Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list4Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                ImageView imageView14 = this.binding.annexureDIncludedLayout.imageList4;
                byte[] bArr14 = this.pdfbyteArray;
                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
                this.binding.annexureDIncludedLayout.list4Name.setText(strArrSplit3[strArrSplit3.length - 1]);
                this.binding.annexureDIncludedLayout.list4Size.setText(dRound4 + "MB");
                return;
            } catch (Exception e8) {
                Log.e(TAG, e8.toString());
                return;
            }
        }
        if (requestCode == 108 && resultCode == -1) {
            try {
                Bitmap bitmap5 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                bitmap5.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream5);
                this.pdfbyteArray = byteArrayOutputStream5.toByteArray();
            } catch (Exception e9) {
                Logger.d("", e9.getMessage());
            }
            try {
                Uri saveImagePath4 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery5 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath4, null, null, null, null);
                if (cursorQuery5.getCount() <= 0) {
                    cursorQuery5.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery5.moveToFirst();
                String[] strArrSplit4 = saveImagePath4.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit4));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                    this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                    ImageView imageView15 = this.binding.annexureDIncludedLayout.imageList5;
                    byte[] bArr15 = this.pdfbyteArray;
                    imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit4[strArrSplit4.length - 1]);
                    this.binding.annexureDIncludedLayout.list5Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList5.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list5Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list5Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound5 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound5 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                this.binding.annexureDIncludedLayout.list5Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list5Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                ImageView imageView16 = this.binding.annexureDIncludedLayout.imageList5;
                byte[] bArr16 = this.pdfbyteArray;
                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
                this.binding.annexureDIncludedLayout.list5Name.setText(strArrSplit4[strArrSplit4.length - 1]);
                this.binding.annexureDIncludedLayout.list5Size.setText(dRound5 + "MB");
                return;
            } catch (Exception e10) {
                Log.e(TAG, e10.toString());
                return;
            }
        }
        if (requestCode == 109 && resultCode == -1) {
            try {
                Bitmap bitmap6 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                bitmap6.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream6);
                this.pdfbyteArray = byteArrayOutputStream6.toByteArray();
            } catch (Exception e11) {
                Logger.d("", e11.getMessage());
            }
            try {
                Uri saveImagePath5 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery6 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath5, null, null, null, null);
                if (cursorQuery6.getCount() <= 0) {
                    cursorQuery6.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery6.moveToFirst();
                String[] strArrSplit5 = saveImagePath5.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit5));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                    ImageView imageView17 = this.binding.annexureDIncludedLayout.imageList6;
                    byte[] bArr17 = this.pdfbyteArray;
                    imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
                    this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit5[strArrSplit5.length - 1]);
                    this.binding.annexureDIncludedLayout.list6Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList6.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list6Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list6Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound6 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound6 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.list6Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list6Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                ImageView imageView18 = this.binding.annexureDIncludedLayout.imageList6;
                byte[] bArr18 = this.pdfbyteArray;
                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(false);
                this.binding.annexureDIncludedLayout.list6Name.setText(strArrSplit5[strArrSplit5.length - 1]);
                this.binding.annexureDIncludedLayout.list6Size.setText(dRound6 + "MB");
                return;
            } catch (Exception e12) {
                Log.e(TAG, e12.toString());
                return;
            }
        }
        if (requestCode == 110 && resultCode == -1) {
            try {
                Bitmap bitmap7 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                bitmap7.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream7);
                this.pdfbyteArray = byteArrayOutputStream7.toByteArray();
            } catch (Exception e13) {
                Logger.d("", e13.getMessage());
            }
            try {
                Uri saveImagePath6 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery7 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath6, null, null, null, null);
                if (cursorQuery7.getCount() <= 0) {
                    cursorQuery7.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery7.moveToFirst();
                String[] strArrSplit6 = saveImagePath6.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit6));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                    ImageView imageView19 = this.binding.annexureDIncludedLayout.imageList7;
                    byte[] bArr19 = this.pdfbyteArray;
                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, 0, bArr19.length));
                    this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit6[strArrSplit6.length - 1]);
                    this.binding.annexureDIncludedLayout.list7Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList7.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list7Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list7Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound7 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound7 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.list7Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list7Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                ImageView imageView20 = this.binding.annexureDIncludedLayout.imageList7;
                byte[] bArr20 = this.pdfbyteArray;
                imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, 0, bArr20.length));
                this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
                this.binding.annexureDIncludedLayout.list7Name.setText(strArrSplit6[strArrSplit6.length - 1]);
                this.binding.annexureDIncludedLayout.list7Size.setText(dRound7 + "MB");
                return;
            } catch (Exception e14) {
                Log.e(TAG, e14.toString());
                return;
            }
        }
        if (requestCode == 111 && resultCode == -1) {
            try {
                Bitmap bitmap8 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream8 = new ByteArrayOutputStream();
                bitmap8.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream8);
                this.pdfbyteArray = byteArrayOutputStream8.toByteArray();
            } catch (Exception e15) {
                Logger.d("", e15.getMessage());
            }
            try {
                Uri saveImagePath7 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery8 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath7, null, null, null, null);
                if (cursorQuery8.getCount() <= 0) {
                    cursorQuery8.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery8.moveToFirst();
                String[] strArrSplit7 = saveImagePath7.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit7));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                    ImageView imageView21 = this.binding.annexureDIncludedLayout.imageList2;
                    byte[] bArr21 = this.pdfbyteArray;
                    imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, 0, bArr21.length));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit7[strArrSplit7.length - 1]);
                    this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound8 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound8 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                ImageView imageView22 = this.binding.annexureDIncludedLayout.imageList2;
                byte[] bArr22 = this.pdfbyteArray;
                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, 0, bArr22.length));
                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit7[strArrSplit7.length - 1]);
                this.binding.annexureDIncludedLayout.list2Size.setText(dRound8 + "MB");
                return;
            } catch (Exception e16) {
                Log.e(TAG, e16.toString());
                return;
            }
        }
        if (requestCode == 112 && resultCode == -1) {
            try {
                Bitmap bitmap9 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream9 = new ByteArrayOutputStream();
                bitmap9.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream9);
                this.pdfbyteArray = byteArrayOutputStream9.toByteArray();
            } catch (Exception e17) {
                Logger.d("", e17.getMessage());
            }
            try {
                Uri saveImagePath8 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery9 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath8, null, null, null, null);
                if (cursorQuery9.getCount() <= 0) {
                    cursorQuery9.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery9.moveToFirst();
                String[] strArrSplit8 = saveImagePath8.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit8));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                    ImageView imageView23 = this.binding.annexureDIncludedLayout.imageList1;
                    byte[] bArr23 = this.pdfbyteArray;
                    imageView23.setImageBitmap(BitmapFactory.decodeByteArray(bArr23, 0, bArr23.length));
                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit8[strArrSplit8.length - 1]);
                    this.binding.annexureDIncludedLayout.list1Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList1.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list1Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list1Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound9 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound9 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                this.binding.annexureDIncludedLayout.list1Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list1Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                ImageView imageView24 = this.binding.annexureDIncludedLayout.imageList1;
                byte[] bArr24 = this.pdfbyteArray;
                imageView24.setImageBitmap(BitmapFactory.decodeByteArray(bArr24, 0, bArr24.length));
                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
                this.binding.annexureDIncludedLayout.list1Name.setText(strArrSplit8[strArrSplit8.length - 1]);
                this.binding.annexureDIncludedLayout.list1Size.setText(dRound9 + "MB");
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (requestCode == 113 && resultCode == -1) {
            try {
                Bitmap bitmap10 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream10 = new ByteArrayOutputStream();
                bitmap10.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream10);
                this.pdfbyteArray = byteArrayOutputStream10.toByteArray();
            } catch (Exception e18) {
                Logger.d("", e18.getMessage());
            }
            try {
                Uri saveImagePath9 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery10 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath9, null, null, null, null);
                if (cursorQuery10.getCount() <= 0) {
                    cursorQuery10.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery10.moveToFirst();
                String[] strArrSplit9 = saveImagePath9.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit9));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                    this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                    ImageView imageView25 = this.binding.annexureDIncludedLayout.imageBefore2004Self;
                    byte[] bArr25 = this.pdfbyteArray;
                    imageView25.setImageBitmap(BitmapFactory.decodeByteArray(bArr25, 0, bArr25.length));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(false);
                    this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit9[strArrSplit9.length - 1]);
                    this.binding.annexureDIncludedLayout.before2004SelfSize.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(8);
                    this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(8);
                    this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound10 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound10 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                this.binding.annexureDIncludedLayout.before2004SelfName.setVisibility(0);
                this.binding.annexureDIncludedLayout.before2004SelfSize.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                ImageView imageView26 = this.binding.annexureDIncludedLayout.imageBefore2004Self;
                byte[] bArr26 = this.pdfbyteArray;
                imageView26.setImageBitmap(BitmapFactory.decodeByteArray(bArr26, 0, bArr26.length));
                this.binding.annexureDIncludedLayout.before2004SelfName.setText(strArrSplit9[strArrSplit9.length - 1]);
                this.binding.annexureDIncludedLayout.before2004SelfSize.setText(dRound10 + "MB");
                return;
            } catch (Exception e19) {
                Log.e(TAG, e19.toString());
                return;
            }
        }
        if (requestCode == 114 && resultCode == -1) {
            try {
                Bitmap bitmap11 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream11 = new ByteArrayOutputStream();
                bitmap11.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream11);
                this.pdfbyteArray = byteArrayOutputStream11.toByteArray();
            } catch (Exception e20) {
                Logger.d("", e20.getMessage());
            }
            try {
                Uri saveImagePath10 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery11 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath10, null, null, null, null);
                if (cursorQuery11.getCount() <= 0) {
                    cursorQuery11.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery11.moveToFirst();
                String[] strArrSplit10 = saveImagePath10.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit10));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                    ImageView imageView27 = this.binding.annexureDIncludedLayout.imageList2;
                    byte[] bArr27 = this.pdfbyteArray;
                    imageView27.setImageBitmap(BitmapFactory.decodeByteArray(bArr27, 0, bArr27.length));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit10[strArrSplit10.length - 1]);
                    this.binding.annexureDIncludedLayout.list2Size.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                    this.binding.annexureDIncludedLayout.cancelList2.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list2Name.setVisibility(8);
                    this.binding.annexureDIncludedLayout.list2Size.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                double dRound11 = Math.round(this.filesize * 100.0d) / 100.0d;
                if (dRound11 > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
                this.binding.annexureDIncludedLayout.list2Name.setVisibility(0);
                this.binding.annexureDIncludedLayout.list2Size.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                ImageView imageView28 = this.binding.annexureDIncludedLayout.imageList2;
                byte[] bArr28 = this.pdfbyteArray;
                imageView28.setImageBitmap(BitmapFactory.decodeByteArray(bArr28, 0, bArr28.length));
                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
                this.binding.annexureDIncludedLayout.list2Name.setText(strArrSplit10[strArrSplit10.length - 1]);
                this.binding.annexureDIncludedLayout.list2Size.setText(dRound11 + "MB");
                return;
            } catch (Exception e21) {
                Log.e(TAG, e21.toString());
                return;
            }
        }
        if (requestCode == 115 && resultCode == -1) {
            try {
                Bitmap bitmap12 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream12 = new ByteArrayOutputStream();
                bitmap12.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream12);
                this.pdfbyteArray = byteArrayOutputStream12.toByteArray();
            } catch (Exception e22) {
                Logger.d("", e22.getMessage());
            }
            try {
                Uri saveImagePath11 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery12 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath11, null, null, null, null);
                if (cursorQuery12.getCount() <= 0) {
                    cursorQuery12.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery12.moveToFirst();
                String[] strArrSplit11 = saveImagePath11.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit11));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.anxDSign);
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                    this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                    this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                    this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                    ImageView imageView29 = this.binding.annexureDIncludedLayout.imageSign;
                    byte[] bArr29 = this.pdfbyteArray;
                    imageView29.setImageBitmap(BitmapFactory.decodeByteArray(bArr29, 0, bArr29.length));
                    this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                    this.binding.annexureDIncludedLayout.signName.setText(strArrSplit11[strArrSplit11.length - 1]);
                    this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                    this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(8);
                    this.binding.annexureDIncludedLayout.signName.setVisibility(8);
                    this.binding.annexureDIncludedLayout.signSize.setVisibility(8);
                    this.binding.annexureDIncludedLayout.imageSign.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                if (Math.round(this.filesize * 100.0d) / 100.0d > 2.0d) {
                    this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.anxDSign);
                this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                this.binding.annexureDIncludedLayout.signSize.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                ImageView imageView30 = this.binding.annexureDIncludedLayout.imageSign;
                byte[] bArr30 = this.pdfbyteArray;
                imageView30.setImageBitmap(BitmapFactory.decodeByteArray(bArr30, 0, bArr30.length));
                this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
                this.binding.annexureDIncludedLayout.signName.setText(strArrSplit11[strArrSplit11.length - 1]);
                this.binding.annexureDIncludedLayout.signSize.setText(this.filesize + "KB");
                return;
            } catch (Exception e23) {
                Log.e(TAG, e23.toString());
                return;
            }
        }
        if (requestCode == 116 && resultCode == -1) {
            try {
                Bitmap bitmap13 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream13 = new ByteArrayOutputStream();
                bitmap13.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream13);
                this.pdfbyteArray = byteArrayOutputStream13.toByteArray();
            } catch (Exception e24) {
                Logger.d("", e24.getMessage());
            }
            try {
                Uri saveImagePath12 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery13 = getActivity().getApplicationContext().getContentResolver().query(saveImagePath12, null, null, null, null);
                if (cursorQuery13.getCount() <= 0) {
                    cursorQuery13.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery13.moveToFirst();
                String[] strArrSplit12 = saveImagePath12.getPath().split("/");
                Logger.d(TAG, Arrays.toString(strArrSplit12));
                if (this.filesize < 1024) {
                    uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.DeclarationDetails);
                    this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                    this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(0);
                    this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(0);
                    this.binding.declarationSirIncludedLayout.decFormSignSize.setVisibility(0);
                    this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                    ImageView imageView31 = this.binding.declarationSirIncludedLayout.decFormImageSign;
                    byte[] bArr31 = this.pdfbyteArray;
                    imageView31.setImageBitmap(BitmapFactory.decodeByteArray(bArr31, 0, bArr31.length));
                    this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(false);
                    this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit12[strArrSplit12.length - 1]);
                    this.declarationSignPhotograph = strArrSplit12[strArrSplit12.length - 1];
                    Logger.d("Declaration signature code 116 2", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
                    this.binding.declarationSirIncludedLayout.decFormSignName.setText(strArrSplit12[strArrSplit12.length - 1]);
                    this.binding.declarationSirIncludedLayout.decFormSignSize.setText(this.filesize + "KB");
                    return;
                }
                if (this.filesize > 2048) {
                    this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.decFormSignSize.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(8);
                    showDialog1("Alert", "Image size exceeded 2MB limit.");
                    return;
                }
                this.filesize /= 1024;
                if (Math.round(this.filesize * 100.0d) / 100.0d > 2.0d) {
                    this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(8);
                    showDialog1("Alert", this.imgmsg);
                    return;
                }
                uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.DeclarationDetails);
                this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(0);
                this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(0);
                this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(0);
                this.binding.declarationSirIncludedLayout.decFormSignSize.setVisibility(0);
                this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                ImageView imageView32 = this.binding.declarationSirIncludedLayout.decFormImageSign;
                byte[] bArr32 = this.pdfbyteArray;
                imageView32.setImageBitmap(BitmapFactory.decodeByteArray(bArr32, 0, bArr32.length));
                this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(false);
                this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit12[strArrSplit12.length - 1]);
                this.declarationSignPhotograph = strArrSplit12[strArrSplit12.length - 1];
                Logger.d("Declaration signature code 116 1", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
                this.binding.declarationSirIncludedLayout.decFormSignName.setText(strArrSplit12[strArrSplit12.length - 1]);
                this.binding.declarationSirIncludedLayout.decFormSignSize.setText(this.filesize + "KB");
                return;
            } catch (Exception e25) {
                Log.e(TAG, e25.toString());
                return;
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onActivityResult$15();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$14() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$15() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadImage(String fileName) {
        this.alertDialog.show();
        Log.d(TAG, "getting downloaded file");
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        Logger.d("Token_get_uploaded", this.token);
        userClient.getFile("objectstorage", fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass24(fileName));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileName;

        AnonymousClass24(final String val$fileName) {
            this.val$fileName = val$fileName;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            String str;
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Log.d(Form6CheckListFragment.TAG, "error in image" + jsonObject.get("file"));
                String strValueOf = String.valueOf(jsonObject.get("file"));
                byte[] bArrDecode = Base64.decode(strValueOf, 0);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrDecode);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                Form6CheckListFragment.this.bitmapPersonImage = BitmapFactory.decodeStream(byteArrayInputStream);
                Form6CheckListFragment.this.filesize = bArrDecode.length / 1024;
                if (Form6CheckListFragment.this.filesize < 1024) {
                    str = Form6CheckListFragment.this.filesize + "KB";
                } else {
                    Form6CheckListFragment.this.filesize /= 1024;
                    str = (Math.round(Form6CheckListFragment.this.filesize * 100.0d) / 100.0d) + "MB";
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.personalDetails)) {
                    Form6CheckListFragment.this.bitmapPersonImage = bitmapDecodeStream;
                    Form6CheckListFragment.this.encodedPersonImage = strValueOf;
                    Form6CheckListFragment.this.binding.passPhotoPersonalDetails.setVisibility(0);
                    Form6CheckListFragment.this.binding.choosePhotoPersonalDetails.setText(this.val$fileName);
                    if (this.val$fileName.toLowerCase().contains(".pdf")) {
                        Form6CheckListFragment.this.binding.personalDetailPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else {
                        Form6CheckListFragment.this.binding.personalDetailPhoto.setImageBitmap(bitmapDecodeStream);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.dateOfBirth)) {
                    Form6CheckListFragment.this.binding.passPhotoDateOfBirth.setVisibility(0);
                    Form6CheckListFragment.this.binding.choosePhotDateOfBirth.setText(this.val$fileName);
                    Form6CheckListFragment.this.binding.chooseFileDateOfBirthSizeTv.setText(str);
                    if (this.val$fileName.toLowerCase().contains(".pdf")) {
                        Form6CheckListFragment.this.binding.dateOfBirthPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else {
                        Form6CheckListFragment.this.binding.dateOfBirthPhoto.setImageBitmap(bitmapDecodeStream);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$1();
                        }
                    }, 2000L);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.residenceDetail)) {
                    Form6CheckListFragment.this.binding.passPhotoResidenceDetails.setVisibility(0);
                    Form6CheckListFragment.this.binding.choosePhotResidenceDetails.setText(this.val$fileName);
                    Form6CheckListFragment.this.binding.chooseFileResidenceSizeTv.setText(str);
                    if (this.val$fileName.toLowerCase().contains(".pdf")) {
                        Form6CheckListFragment.this.binding.residenceDetailsPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else {
                        Form6CheckListFragment.this.binding.residenceDetailsPhoto.setImageBitmap(bitmapDecodeStream);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    }, 2000L);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.categoryOfDisability)) {
                    Form6CheckListFragment.this.binding.passPhotoDisabilityDetails.setVisibility(0);
                    Form6CheckListFragment.this.binding.choosePhotDisabilityDetails.setText(this.val$fileName);
                    Form6CheckListFragment.this.binding.chooseFileDisablitySizeTv.setText(str);
                    if (this.val$fileName.toLowerCase().contains(".pdf")) {
                        Form6CheckListFragment.this.binding.disabilityDetailsPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else {
                        Form6CheckListFragment.this.binding.disabilityDetailsPhoto.setImageBitmap(bitmapDecodeStream);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$3();
                        }
                    }, 2000L);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.DeclarationDetails)) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormSignName.setText(this.val$fileName);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormSignSize.setText(str);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(0);
                    if (this.val$fileName.toLowerCase().contains(".pdf")) {
                        Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                        return;
                    } else {
                        Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setImageBitmap(bitmapDecodeStream);
                        return;
                    }
                }
                return;
            }
            if (response.code() == 401) {
                Form6CheckListFragment.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6CheckListFragment.TAG, "nisthaerror" + response.errorBody());
                String strOptString = jSONObject.optString("message");
                Log.d(Form6CheckListFragment.TAG, "Document Download Error" + strOptString);
                Form6CheckListFragment.this.commomUtility.showMessageWithTitleOK(Form6CheckListFragment.this.requireContext(), "Document download Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.exception + e.getMessage());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$5();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6CheckListFragment.TAG, "coming in onFailure " + t.getMessage());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$24$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$6();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$6() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTokenApi() {
        this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda21
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$18(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$18(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda73
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$16(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Page refreshed due to the token expiry, Please upload again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda74
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$17(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$16(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$17(DialogInterface dialogInterface, int i) {
        openFragment(new TotalListFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadImage(String captureFileName) {
        Logger.d(TAG, "uploadImage_captureFileName " + captureFileName);
        this.imageFileName = this.checkListForm6Model.getReferenceNumber();
        Log.d(TAG, "imageFileName.............................. " + this.imageFileName);
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("application/pdf", MediaType.parse("fileType")), RequestBody.create(this.imageFileName, MediaType.parse("fileName")), RequestBody.create(this.mSTATECODE, MediaType.parse("stateCode")), RequestBody.create(this.asmblyNO, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.bloApp, MediaType.parse("appName"))).enqueue(new AnonymousClass25());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$25, reason: invalid class name */
    class AnonymousClass25 implements Callback<JsonObject> {
        AnonymousClass25() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Log.d(Form6CheckListFragment.TAG, "Success_Uploaded");
                JsonElement jsonElement = ((JsonObject) response.body()).get("refId");
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.personalDetails)) {
                    Form6CheckListFragment.this.personalPhotograph = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.referenceNumberString + Form6CheckListFragment.this.personalPhotograph);
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.downloadImage(form6CheckListFragment.personalPhotograph);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.dateOfBirth)) {
                    Form6CheckListFragment.this.dateOfBirthPhotoPhotograph = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.referenceNumberString + Form6CheckListFragment.this.dateOfBirthPhotoPhotograph);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.downloadImage(form6CheckListFragment2.dateOfBirthPhotoPhotograph);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.residenceDetail)) {
                    Form6CheckListFragment.this.residenceProofPhotoPhotograph = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.referenceNumberString + Form6CheckListFragment.this.residenceProofPhotoPhotograph);
                    Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                    form6CheckListFragment3.downloadImage(form6CheckListFragment3.residenceProofPhotoPhotograph);
                    return;
                }
                if (Form6CheckListFragment.this.selectedType.equals(Form6CheckListFragment.this.categoryOfDisability)) {
                    Form6CheckListFragment.this.disabilityDetailsPhotograph = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.referenceNumberString + Form6CheckListFragment.this.disabilityDetailsPhotograph);
                    Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                    form6CheckListFragment4.downloadImage(form6CheckListFragment4.disabilityDetailsPhotograph);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                Form6CheckListFragment.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(Form6CheckListFragment.TAG, "nisthaerror" + response.errorBody());
                String strOptString = jSONObject.optString("message");
                Log.d(Form6CheckListFragment.TAG, "Error_ImageInUpload   " + strOptString);
                Form6CheckListFragment.this.commomUtility.displayAlertWithTitleAndMessage(Form6CheckListFragment.this.requireContext(), "Status " + response.code(), "Error Occur , please try again  " + strOptString);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$25$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
            } catch (IOException | JSONException e) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$25$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.exception + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6CheckListFragment.TAG, "Failed_Uploaded " + t.getMessage());
            Form6CheckListFragment.this.commomUtility.displayAlertWithTitleAndMessage(Form6CheckListFragment.this.requireContext(), "Status ", "Error Occur , please try again");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$25$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$2() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, "Application Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == 2131363989) {
            if (hasFocus) {
                if (this.binding.firstNameEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameOfficial, this.partLang, Constants.transliterationName);
                        return;
                    } catch (Exception e) {
                        Logger.d(TAG, this.exception + e.getMessage());
                        return;
                    }
                }
                this.binding.firstnameOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131363990) {
            if (hasFocus) {
                if (this.binding.firstNameEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameOfficial2, this.partLang2, Constants.transliterationName);
                        return;
                    } catch (Exception e2) {
                        Logger.d(TAG, this.exception + e2.getMessage());
                        return;
                    }
                }
                this.binding.firstnameOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366191) {
            if (hasFocus) {
                if (this.binding.surNameEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameOfficial, this.partLang, Constants.transliterationName);
                        return;
                    } catch (Exception e3) {
                        Logger.d(TAG, this.exception + e3.getMessage());
                        return;
                    }
                }
                this.binding.surnameOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366192) {
            if (hasFocus) {
                if (this.binding.surNameEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameOfficial2, this.partLang2, Constants.transliterationName);
                        return;
                    } catch (Exception e4) {
                        Logger.d(TAG, this.exception + e4.getMessage());
                        return;
                    }
                }
                this.binding.surnameOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131365647) {
            if (hasFocus) {
                if (this.binding.relativeName.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameOfficial, this.partLang, Constants.transliterationName);
                        return;
                    } catch (Exception e5) {
                        Logger.d(TAG, this.exception + e5.getMessage());
                        return;
                    }
                }
                this.binding.relativeNameOfficial.setText((CharSequence) null);
                return;
            }
            return;
        }
        if (v.getId() == 2131365648) {
            if (hasFocus) {
                if (this.binding.relativeName.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameOfficial2, this.partLang2, Constants.transliterationName);
                        return;
                    } catch (Exception e6) {
                        Logger.d(TAG, this.exception + e6.getMessage());
                        return;
                    }
                }
                this.binding.relativeNameOfficial2.setText((CharSequence) null);
                return;
            }
            return;
        }
        if (v.getId() == 2131365631) {
            if (hasFocus) {
                if (this.binding.relativeSurname.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeSurname.getText().toString().trim(), this.binding.relativeSurnameOfficial, this.partLang, Constants.transliterationName);
                        return;
                    } catch (Exception e7) {
                        Logger.d(TAG, this.exception + e7.getMessage());
                        return;
                    }
                }
                this.binding.relativeNameOfficial.setText((CharSequence) null);
                return;
            }
            return;
        }
        if (v.getId() == 2131365632) {
            if (hasFocus) {
                if (this.binding.relativeSurname.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeSurname.getText().toString().trim(), this.binding.relativeSurnameOfficial2, this.partLang2, Constants.transliterationName);
                        return;
                    } catch (Exception e8) {
                        Logger.d(TAG, this.exception + e8.getMessage());
                        return;
                    }
                }
                this.binding.relativeNameOfficial2.setText((CharSequence) null);
                return;
            }
            return;
        }
        if (v.getId() == 2131364223) {
            if (hasFocus) {
                if (this.binding.houseNoEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseNoEdOfficial, this.partLang, Constants.transliterationAddress);
                        return;
                    } catch (Exception e9) {
                        Logger.d(TAG, this.exception + e9.getMessage());
                        return;
                    }
                }
                this.binding.houseNoEdOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131364224) {
            if (hasFocus) {
                if (this.binding.houseNoEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseNoEdOfficial2, this.partLang2, Constants.transliterationAddress);
                        return;
                    } catch (Exception e10) {
                        Logger.d(TAG, this.exception + e10.getMessage());
                        return;
                    }
                }
                this.binding.houseNoEdOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366104) {
            if (hasFocus) {
                if (this.binding.streetEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetEdOfficial, this.partLang, Constants.transliterationAddress);
                        return;
                    } catch (Exception e11) {
                        Logger.d(TAG, this.exception + e11.getMessage());
                        return;
                    }
                }
                this.binding.streetEdOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366105) {
            if (hasFocus) {
                if (this.binding.streetEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetEdOfficial2, this.partLang2, Constants.transliterationAddress);
                        return;
                    } catch (Exception e12) {
                        Logger.d(TAG, this.exception + e12.getMessage());
                        return;
                    }
                }
                this.binding.streetEdOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366471) {
            if (hasFocus) {
                if (this.binding.townEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.townEd.getText().toString().trim(), this.binding.townEdOfficial, this.partLang, Constants.transliterationAddress);
                        return;
                    } catch (Exception e13) {
                        Logger.d(TAG, this.exception + e13.getMessage());
                        return;
                    }
                }
                this.binding.townEdOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366472) {
            if (hasFocus) {
                if (this.binding.townEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.townEd.getText().toString().trim(), this.binding.townEdOfficial2, this.partLang2, Constants.transliterationAddress);
                        return;
                    } catch (Exception e14) {
                        Logger.d(TAG, this.exception + e14.getMessage());
                        return;
                    }
                }
                this.binding.townEdOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131365403) {
            if (hasFocus) {
                if (this.binding.postofficeEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeOfficial, this.partLang, Constants.transliterationAddress);
                        return;
                    } catch (Exception e15) {
                        Logger.d(TAG, this.exception + e15.getMessage());
                        return;
                    }
                }
                this.binding.postofficeOfficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131365404) {
            if (hasFocus) {
                if (this.binding.postofficeEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeOfficial2, this.partLang2, Constants.transliterationAddress);
                        return;
                    } catch (Exception e16) {
                        Logger.d(TAG, this.exception + e16.getMessage());
                        return;
                    }
                }
                this.binding.postofficeOfficial2.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366228) {
            if (hasFocus) {
                if (this.binding.tehsilEd.length() != 0) {
                    try {
                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.tehsilEd.getText().toString().trim(), this.binding.tehsilEdofficial, this.partLang, Constants.transliterationAddress);
                        return;
                    } catch (Exception e17) {
                        Logger.d(TAG, this.exception + e17.getMessage());
                        return;
                    }
                }
                this.binding.tehsilEdofficial.setText("");
                return;
            }
            return;
        }
        if (v.getId() == 2131366229 && hasFocus) {
            if (this.binding.tehsilEd.length() != 0) {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.tehsilEd.getText().toString().trim(), this.binding.tehsilEdofficial2, this.partLang2, Constants.transliterationAddress);
                    return;
                } catch (Exception e18) {
                    Logger.d(TAG, this.exception + e18.getMessage());
                    return;
                }
            }
            this.binding.tehsilEdofficial2.setText("");
        }
    }

    public boolean validation() {
        Date date;
        Date date2;
        if (this.selectedType.equals(this.personalDetails)) {
            this.binding.firstnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.surnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeSurnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            if (!this.binding.firstnameOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.firstnameOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "First name ( " + this.binding.firstnameOfficial.getText().toString() + this.fieldName);
                this.binding.firstnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (!this.binding.surnameOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.surnameOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Last name ( " + this.binding.surnameOfficial.getText().toString() + this.fieldName);
                this.binding.surnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (!this.binding.relativeNameOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.relativeNameOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Relative first name ( " + this.binding.relativeNameOfficial.getText().toString() + this.fieldName);
                this.binding.relativeNameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (!this.binding.relativeSurnameOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.relativeSurnameOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Relative last name ( " + this.binding.relativeSurnameOfficial.getText().toString() + this.fieldName);
                this.binding.relativeSurnameOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            String str = this.personalPhotograph;
            if (str == null || str.isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Person Image cannot remain empty");
                return false;
            }
            if (this.binding.firstNameEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "First name cannot remain empty");
                return false;
            }
            if (this.binding.firstnameOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Regional first name cannot remain empty");
                return false;
            }
            if (this.binding.surNameEd.length() != 0 && this.binding.surnameOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Regional surname cannot remain empty");
                return false;
            }
            if (this.binding.genderRg.getCheckedRadioButtonId() == -1) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Gender cannot remain empty");
                return false;
            }
            if (this.binding.relativeName.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Relative name cannot remain empty");
                return false;
            }
            if (this.binding.relativeSurname.length() != 0 && this.binding.relativeSurnameOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Regional surname cannot remain empty");
                return false;
            }
            if (this.binding.familyRadioGroup.getCheckedRadioButtonId() == -1) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly select relation type");
                return false;
            }
            if (!this.binding.mobileNumEd.getText().toString().isEmpty() && this.binding.mobileNumEd.getText().toString().length() != 10) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please Enter Correct Mobile Number");
                return false;
            }
            if (!this.binding.mobileNumEd.getText().toString().isEmpty() && this.binding.mobileNumEd.getText().toString().length() == 10 && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please Enter Correct Mobile Number");
                return false;
            }
            if (this.binding.emailEd.length() == 0 || this.binding.emailEd.getText().toString().matches(RegexMatcher.EMAIL_REGEX) || this.binding.emailEd.getText().toString().isEmpty()) {
                return true;
            }
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please enter correct Email ID");
            return false;
        }
        if (this.selectedType.equals(this.authentication)) {
            this.alertDialog.show();
            if (this.binding.aadharRb.isChecked() && this.binding.aadharEd.length() != 12) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly enter valid aadhaar number of 12 digits");
                return false;
            }
            if (!this.binding.aadharRb.isChecked() || this.binding.aadharEd.length() != 12 || this.result) {
                return true;
            }
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly enter valid aadhaar number");
            return false;
        }
        if (this.selectedType.equals(this.dateOfBirth)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date3 = null;
            try {
                date = simpleDateFormat.parse(this.binding.dobEd.getText().toString());
                try {
                    String str2 = this.dobQualifyingDate;
                    if (str2 != "") {
                        date2 = simpleDateFormat.parse(str2);
                    } else {
                        this.dobQualifyingDate = "01/10/2005";
                        date2 = simpleDateFormat.parse("01/10/2005");
                    }
                    date3 = date2;
                } catch (ParseException e) {
                    e = e;
                    Logger.d("", e.getMessage());
                }
            } catch (ParseException e2) {
                e = e2;
                date = null;
            }
            String str3 = this.dateOfBirthPhotoPhotograph;
            if (str3 == null || str3.isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Date Of Birth Proof Image Cannot remain empty");
                return false;
            }
            if (date.after(date3)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Date of birth should be less than " + this.dobQualifyingDate);
                return false;
            }
            if (this.binding.documentSpinner.getSelectedItem().toString().equals("Select Document")) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly select document type");
                return false;
            }
            if (this.binding.age.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Age field can't remain empty");
                return false;
            }
            if (this.binding.age.length() == 0 || Integer.parseInt(this.binding.age.getText().toString()) >= 17) {
                return true;
            }
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Age field can't be less then 17");
            return false;
        }
        if (this.selectedType.equals(this.residenceDetail)) {
            this.binding.houseNoEdOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetEdOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.townEdOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.tehsilEdofficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            String str4 = this.residenceProofPhotoPhotograph;
            if (str4 == null || str4.isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Residence Proof document Cannot remain empty");
                return false;
            }
            if (this.binding.houseNoEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "House number can't remain empty");
                return false;
            }
            if (this.binding.houseNoEdOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "House regional number can't remain empty");
                return false;
            }
            if (this.binding.streetEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Street can't remain empty");
                return false;
            }
            if (this.binding.streetEdOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Street regional can't remain empty");
                return false;
            }
            if (!this.binding.streetEdOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.streetEdOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Street ( " + this.binding.streetEdOfficial.getText().toString() + this.fieldName);
                this.binding.streetEdOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (this.binding.townEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Town can't remain empty");
                return false;
            }
            if (this.binding.townEdOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Town regional can't remain empty");
                return false;
            }
            if (!this.binding.townEdOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.townEdOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Town ( " + this.binding.townEdOfficial.getText().toString() + this.fieldName);
                this.binding.townEdOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (this.binding.postofficeEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Post office can't remain empty");
                return false;
            }
            if (this.binding.postofficeOfficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Post office can't remain empty");
                return false;
            }
            if (!this.binding.postofficeOfficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.postofficeOfficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "PostOffice ( " + this.binding.postofficeOfficial.getText().toString() + this.fieldName);
                this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (this.binding.pincodeEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Pincode can't remain empty");
                return false;
            }
            if (this.binding.tehsilEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Tehsil can't remain empty");
                return false;
            }
            if (this.binding.tehsilEdofficial.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Tehsil regional can't remain empty");
                return false;
            }
            if (!this.binding.tehsilEdofficial.getText().toString().trim().isEmpty() && !Objects.equals(this.partLang, this.enIn) && this.binding.tehsilEdofficial.getText().toString().trim().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Tehsil ( " + this.binding.tehsilEdofficial.getText().toString() + this.fieldName);
                this.binding.tehsilEdofficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                return false;
            }
            if (this.binding.documentSp.getSelectedItem().equals("Select Document")) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly select document type or define other document");
                return false;
            }
            if (!this.binding.documentSp.getSelectedItem().equals(this.anyOtherDocument) || !this.binding.anyOtherEd.getText().toString().trim().isEmpty()) {
                return true;
            }
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Kindly enter document type");
            return false;
        }
        if (this.selectedType.equals(this.categoryOfDisability)) {
            if (this.binding.yes.isChecked() && this.disabilityDetailsPhotograph.isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Disability Certificate Cannot remain empty");
                return false;
            }
            if (this.binding.percentageEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Percentage of disability can't remain empty");
                return false;
            }
            if (Integer.parseInt(this.binding.percentageEd.getText().toString()) <= 0) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", this.percentageOfDisability);
                return false;
            }
            if (Integer.parseInt(this.binding.percentageEd.getText().toString()) > 100) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", this.percentageOfDisability);
                return false;
            }
            if (this.binding.other.isChecked() && this.binding.otherEdDetails.getText().toString().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please enter disability type");
                return false;
            }
            if (this.binding.yes.isChecked() && this.binding.percentageEd.getText().toString().trim().isEmpty()) {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", this.percentageOfDisability);
                return false;
            }
            if (Integer.parseInt(this.binding.percentageEd.getText().toString()) <= 0) {
                return true;
            }
            if (this.binding.loco.isChecked() || this.binding.deaf.isChecked() || (this.binding.visual.isChecked() | this.binding.other.isChecked())) {
                Log.d(TAG, this.nothingToDo);
                return true;
            }
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please select disability type");
            return false;
        }
        if (this.selectedType.equals(this.AnnexureDetails)) {
            if (TextUtils.isEmpty(this.choice)) {
                showdialog("Alert", "Please select atleast one category");
                return false;
            }
            if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
                if (this.cat.equalsIgnoreCase("CAT-2")) {
                    if (this.binding.annexureDIncludedLayout.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list1ref == null) {
                        showdialog("Alert", "Please select document for self.");
                        return false;
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                    if (this.binding.annexureDIncludedLayout.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list1ref == null) {
                        showdialog("Alert", "Please select document for self.");
                        return false;
                    }
                    if (this.flagcat3scenerio1.equalsIgnoreCase("") || this.flagcat3scenerio2.equalsIgnoreCase("")) {
                        showdialog("Alert", "Please select atleast one parent");
                        return false;
                    }
                    if (this.binding.annexureDIncludedLayout.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list3Ref == null && this.list4Ref == null) {
                        showdialog("Alert", "Please select document for Father or Mother.");
                        return false;
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                    if (this.binding.annexureDIncludedLayout.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list1ref == null) {
                        showdialog("Alert", "Please select document for self.");
                        return false;
                    }
                    if (this.flagcat4scenerio1.equalsIgnoreCase("")) {
                        showdialog("Alert", "Please select atleast one parent.");
                        return false;
                    }
                    if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list3Ref == null) {
                            showdialog("Alert", "Please select document for Father.");
                            return false;
                        }
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list4Ref == null) {
                            showdialog("Alert", "Please select document for Mother.");
                            return false;
                        }
                    }
                    if (this.flagcat4scenerio1.equalsIgnoreCase("N")) {
                        if (this.flagcat4scenerio2.equalsIgnoreCase("") || this.flagcat4scenerio3.equalsIgnoreCase("")) {
                            showdialog("Alert", "Please select atleast one parent nationality.");
                            return false;
                        }
                        if (this.flagcat4scenerio2.equalsIgnoreCase("Y")) {
                            if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                                showdialog("Alert", this.selectDocumentType);
                                return false;
                            }
                            if (this.list3Ref == null) {
                                showdialog("Alert", "Please select document for Father.");
                                return false;
                            }
                            if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                                showdialog("Alert", this.selectDocumentType);
                                return false;
                            }
                            if (this.list5Ref == null) {
                                showdialog("Alert", "Please select document for Mother.");
                                return false;
                            }
                        }
                        if (this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                            if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                                showdialog("Alert", this.selectDocumentType);
                                return false;
                            }
                            if (this.list4Ref == null) {
                                showdialog("Alert", "Please select document for Mother.");
                                return false;
                            }
                            if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                                showdialog("Alert", this.selectDocumentType);
                                return false;
                            }
                            if (this.list5Ref == null) {
                                showdialog("Alert", "Please select document for Father.");
                                return false;
                            }
                        }
                    }
                }
            } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
                if (this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list6ref == null) {
                    showdialog("Alert", "Please select document for self.");
                    return false;
                }
            } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                if (this.binding.annexureDIncludedLayout.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list7ref == null) {
                    showdialog("Alert", "Please select document for self.");
                    return false;
                }
            }
            if (this.anxDSignUrl != null) {
                return true;
            }
            showdialog("Alert", "Please upload signature.");
            return false;
        }
        if (!this.selectedType.equals(this.DeclarationDetails)) {
            return true;
        }
        if (TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.fatherName.getText().toString())) {
            showDialog1("Alert", getString(R.string.father_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString()) && !this.isFatherEPICValid) {
            showDialog1("Alert", getString(R.string.error_father_verification));
            return false;
        }
        if (TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.motherName.getText().toString())) {
            showDialog1("Alert", getString(R.string.mother_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString()) && !this.isMotherEPICValid) {
            showDialog1("Alert", getString(R.string.error_mother_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString()) && !this.isSpouseEPICValid) {
            showDialog1("Alert", getString(R.string.error_Spouse_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString()) && this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString())) {
            showDialog1("Alert", "Father and mother EPIC should be different");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString()) && this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString())) {
            showDialog1("Alert", "Father and spouse EPIC should be different");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString()) && this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString())) {
            showDialog1("Alert", "Mother and spouse EPIC should be different");
            return false;
        }
        if (this.binding.declarationSirIncludedLayout.chooseRG.getCheckedRadioButtonId() == -1) {
            showDialog1("Alert", "Please select any of above category");
            return false;
        }
        if (this.binding.declarationSirIncludedLayout.searchRG.getCheckedRadioButtonId() == -1) {
            showDialog1("Alert", "Please select any of above category");
            return false;
        }
        if (this.binding.declarationSirIncludedLayout.dfRBselfRb.isChecked() && checkSelfEmpty()) {
            showDialog1(this.alertText, "Please add self details");
            return false;
        }
        if (this.binding.declarationSirIncludedLayout.progenyRb.isChecked() && checkProgenyEmpty()) {
            showDialog1("Alert", "Please add progeny details");
            return false;
        }
        if (this.binding.declarationSirIncludedLayout.relationtypecardview.getVisibility() == 0 && TextUtils.isEmpty(this.relationCode)) {
            showDialog1("Alert", getString(R.string.relative_2003_spinnerErroe));
            return false;
        }
        if (!TextUtils.isEmpty(this.declarationSignPhotograph)) {
            return true;
        }
        showdialog("Alert", "Please upload signature.");
        return false;
    }

    public void openfile() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityLauncher.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae A[Catch: Exception -> 0x0371, TRY_LEAVE, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb A[Catch: Exception -> 0x0371, TRY_ENTER, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d5 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ee A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:42:0x010d A[Catch: Exception -> 0x0371, TRY_LEAVE, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0119 A[Catch: Exception -> 0x0371, TRY_ENTER, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0150 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:48:0x015a A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0191 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:51:0x019b A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01d2 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01dc A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:55:0x021b A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:57:0x022f A[Catch: Exception -> 0x0371, TRY_LEAVE, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x023d A[Catch: Exception -> 0x0371, TRY_ENTER, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0247 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0251 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:64:0x025b A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0265 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:67:0x026f A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0279 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:71:0x02a0 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:73:0x02af A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02ce A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:76:0x02d8 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:77:0x02f6 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0300 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:80:0x031e A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0328 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0346 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0366 A[Catch: Exception -> 0x0371, TryCatch #5 {Exception -> 0x0371, blocks: (B:32:0x008e, B:34:0x00ae, B:37:0x00cb, B:39:0x00d5, B:41:0x00ee, B:84:0x0362, B:42:0x010d, B:45:0x0119, B:46:0x0150, B:48:0x015a, B:49:0x0191, B:51:0x019b, B:52:0x01d2, B:54:0x01dc, B:55:0x021b, B:57:0x022f, B:60:0x023d, B:70:0x0282, B:61:0x0247, B:63:0x0251, B:64:0x025b, B:66:0x0265, B:67:0x026f, B:69:0x0279, B:71:0x02a0, B:73:0x02af, B:74:0x02ce, B:76:0x02d8, B:77:0x02f6, B:79:0x0300, B:80:0x031e, B:82:0x0328, B:83:0x0346, B:85:0x0366, B:86:0x0370), top: B:100:0x008e }] */
    public /* synthetic */ void lambda$new$21(ActivityResult activityResult) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Cursor cursorQuery;
        String string;
        double dRound;
        Throwable th;
        if (activityResult.getResultCode() != -1) {
            return;
        }
        this.alertDialog.show();
        Intent data = activityResult.getData();
        if (data == null) {
            throw new AssertionError();
        }
        Uri data2 = data.getData();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            InputStream inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(data2);
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
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    Logger.d(TAG, "Exception ---> " + e.getMessage());
                    byteArrayOutputStream = byteArrayOutputStream2;
                    this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                    Log.d(TAG, "pdfbyteArray " + Arrays.toString(this.pdfbyteArray));
                    cursorQuery = requireContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), ".pdf"), null, null, null, null);
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                    }
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    this.commonFileName = string;
                    if (string.toLowerCase().contains(".pdf")) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$20();
                            }
                        }, 2000L);
                        this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please Select the correct format of file");
                    } else if (this.filesize < 1024) {
                        uploadImage(this.saveImageFileName);
                        dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.binding.passPhotoPersonalDetails.setVisibility(0);
                            this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.binding.chooseFileDateOfBirthSizeTv.setText(dRound + "KB");
                            this.binding.passPhotoDateOfBirth.setVisibility(0);
                            this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDateOfBirth.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.binding.chooseFileResidenceSizeTv.setText(dRound + "KB");
                            this.binding.passPhotoResidenceDetails.setVisibility(0);
                            this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotResidenceDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.binding.chooseFileDisablitySizeTv.setText(dRound + "KB");
                            this.binding.passPhotoDisabilityDetails.setVisibility(0);
                            this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDisabilityDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.DeclarationDetails)) {
                            this.binding.declarationSirIncludedLayout.decFormSignSize.setText(dRound + "KB");
                            this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(0);
                            this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.declarationSirIncludedLayout.decFormSignName.setText(this.saveImageFileName);
                        }
                    } else if (Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.personalPhotograph = "";
                            this.binding.passPhotoPersonalDetails.setVisibility(8);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.dateOfBirthPhotoPhotograph = "";
                            this.binding.passPhotoDateOfBirth.setVisibility(8);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.residenceProofPhotoPhotograph = "";
                            this.binding.passPhotoResidenceDetails.setVisibility(8);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.disabilityDetailsPhotograph = "";
                            this.binding.passPhotoDisabilityDetails.setVisibility(8);
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$19();
                            }
                        }, 2000L);
                        this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "PDF size exceeded 3MB limit.");
                    } else {
                        uploadImage(this.saveImageFileName);
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.binding.passPhotoPersonalDetails.setVisibility(0);
                            this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.binding.passPhotoDateOfBirth.setVisibility(0);
                            this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDateOfBirth.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.binding.passPhotoResidenceDetails.setVisibility(0);
                            this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.binding.passPhotoDisabilityDetails.setVisibility(0);
                            this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDisabilityDetails.setText(this.saveImageFileName);
                        }
                    }
                    cursorQuery.close();
                }
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                Log.d(TAG, "pdfbyteArray " + Arrays.toString(this.pdfbyteArray));
                try {
                    cursorQuery = requireContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), ".pdf"), null, null, null, null);
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                    }
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    this.commonFileName = string;
                    if (string.toLowerCase().contains(".pdf")) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$20();
                            }
                        }, 2000L);
                        this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "Please Select the correct format of file");
                    } else if (this.filesize < 1024) {
                        uploadImage(this.saveImageFileName);
                        dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.binding.passPhotoPersonalDetails.setVisibility(0);
                            this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.binding.chooseFileDateOfBirthSizeTv.setText(dRound + "KB");
                            this.binding.passPhotoDateOfBirth.setVisibility(0);
                            this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDateOfBirth.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.binding.chooseFileResidenceSizeTv.setText(dRound + "KB");
                            this.binding.passPhotoResidenceDetails.setVisibility(0);
                            this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotResidenceDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.binding.chooseFileDisablitySizeTv.setText(dRound + "KB");
                            this.binding.passPhotoDisabilityDetails.setVisibility(0);
                            this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDisabilityDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.DeclarationDetails)) {
                            this.binding.declarationSirIncludedLayout.decFormSignSize.setText(dRound + "KB");
                            this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(0);
                            this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.declarationSirIncludedLayout.decFormSignName.setText(this.saveImageFileName);
                        }
                    } else if (Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.personalPhotograph = "";
                            this.binding.passPhotoPersonalDetails.setVisibility(8);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.dateOfBirthPhotoPhotograph = "";
                            this.binding.passPhotoDateOfBirth.setVisibility(8);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.residenceProofPhotoPhotograph = "";
                            this.binding.passPhotoResidenceDetails.setVisibility(8);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.disabilityDetailsPhotograph = "";
                            this.binding.passPhotoDisabilityDetails.setVisibility(8);
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$19();
                            }
                        }, 2000L);
                        this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), "Alert", "PDF size exceeded 3MB limit.");
                    } else {
                        uploadImage(this.saveImageFileName);
                        if (this.selectedType.equals(this.personalDetails)) {
                            this.binding.passPhotoPersonalDetails.setVisibility(0);
                            this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.dateOfBirth)) {
                            this.binding.passPhotoDateOfBirth.setVisibility(0);
                            this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDateOfBirth.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.residenceDetail)) {
                            this.binding.passPhotoResidenceDetails.setVisibility(0);
                            this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotoPersonalDetails.setText(this.saveImageFileName);
                        } else if (this.selectedType.equals(this.categoryOfDisability)) {
                            this.binding.passPhotoDisabilityDetails.setVisibility(0);
                            this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color99000000));
                            this.binding.choosePhotDisabilityDetails.setText(this.saveImageFileName);
                        }
                    }
                    cursorQuery.close();
                } catch (Exception e2) {
                    Logger.d("CONTENT", e2.getMessage());
                }
            } catch (Throwable th4) {
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th4;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$19() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$20() {
        this.alertDialog.dismiss();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == 2131363572) {
            if (this.binding.documentSpinner.getSelectedItem().toString().equals(this.anyOtherDocument)) {
                this.binding.dobProofTv.setVisibility(0);
                this.binding.otherEd.setVisibility(8);
                return;
            } else {
                this.binding.dobProofTv.setVisibility(8);
                this.binding.otherEd.setVisibility(8);
                this.binding.otherEd.setText("");
                return;
            }
        }
        if (parent.getId() == 2131363571) {
            if (this.binding.documentSp.getSelectedItem().toString().equals(this.anyOtherDocument)) {
                this.binding.anyTv.setVisibility(0);
                this.binding.anyOtherEd.setVisibility(0);
            } else {
                this.binding.anyTv.setVisibility(8);
                this.binding.anyOtherEd.setVisibility(8);
                this.binding.anyOtherEd.setText("");
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, this.nothingToDo);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group == this.binding.genderRg) {
            if (checkedId == 2131364740) {
                this.gender = "M";
                this.binding.husbandRadioBtn.setVisibility(8);
                this.binding.wifeRadioBtn.setVisibility(0);
                this.binding.legalGuardianRb.setVisibility(8);
                this.binding.otherRb.setVisibility(0);
            } else if (checkedId == 2131363939) {
                this.gender = "F";
                this.binding.husbandRadioBtn.setVisibility(0);
                this.binding.wifeRadioBtn.setVisibility(8);
                this.binding.legalGuardianRb.setVisibility(8);
                this.binding.otherRb.setVisibility(0);
            } else if (checkedId == 2131366414) {
                this.gender = "T";
                this.binding.legalGuardianRb.setVisibility(0);
                this.binding.husbandRadioBtn.setVisibility(8);
                this.binding.otherRb.setVisibility(8);
                this.binding.wifeRadioBtn.setVisibility(8);
            }
            Logger.d(TAG, "setGenderGroupSelected " + this.gender);
            return;
        }
        if (group == this.binding.familyRadioGroup) {
            if (checkedId == 2131363923) {
                this.typeOfRelation = this.fthr;
            } else if (checkedId == 2131364839) {
                this.typeOfRelation = this.mthr;
            } else if (checkedId == 2131364245) {
                this.typeOfRelation = this.hsbn;
            } else if (checkedId == 2131366996) {
                this.typeOfRelation = this.wifeCode;
            } else if (checkedId == 2131364470 || checkedId == 2131365132) {
                this.typeOfRelation = this.otherCode;
            }
            Logger.d(TAG, "typeOfRelation " + this.typeOfRelation);
            return;
        }
        if (group == this.binding.mobNumRg) {
            if (checkedId == 2131365879) {
                this.mobileNumberRelaionType = "Self";
            } else if (checkedId == 2131365613) {
                this.mobileNumberRelaionType = this.typeOfRelation;
            }
            Logger.d(TAG, "mobileNumberRelaionType " + this.mobileNumberRelaionType);
            return;
        }
        if (group == this.binding.emailRg) {
            if (checkedId == 2131365885) {
                this.emailIdRelationType = "Self";
            } else if (checkedId == 2131363744) {
                this.emailIdRelationType = this.typeOfRelation;
            }
            Logger.d(TAG, "emailIdRelationType " + this.emailIdRelationType);
            return;
        }
        if (group == this.binding.aadharRg) {
            if (checkedId == 2131362079) {
                this.binding.aadharEd.setEnabled(true);
                return;
            } else {
                if (checkedId == 2131365010) {
                    this.binding.aadharEd.setEnabled(false);
                    this.binding.aadharEd.setText((CharSequence) null);
                    return;
                }
                return;
            }
        }
        if (group == this.binding.yesnoradio) {
            if (checkedId == 2131367009) {
                if (this.disabilityDetailsPhotograph.length() > 0) {
                    this.binding.uploadTv1.setVisibility(0);
                    this.binding.document2.setVisibility(0);
                    this.binding.chooseFileDisabilityDetailsTv.setVisibility(0);
                    this.binding.passPhotoDisabilityDetails.setVisibility(0);
                    this.disablilityCertificateAttached = "Y";
                } else {
                    this.disabilityDetailsPhotograph = "";
                    this.disablilityCertificateAttached = "Y";
                    this.binding.choosePhotDisabilityDetails.setText("");
                    this.binding.chooseFileDisabilityDetailsTv.setVisibility(0);
                    this.binding.passPhotoDisabilityDetails.setVisibility(8);
                    this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
                }
            } else if (checkedId == 2131365001) {
                this.disabilityDetailsPhotograph = "";
                this.binding.uploadTv1.setVisibility(8);
                this.binding.document2.setVisibility(8);
                this.binding.chooseFileDisabilityDetailsTv.setVisibility(8);
                this.binding.passPhotoDisabilityDetails.setVisibility(8);
                this.disabilityDetailsPhotograph = "";
                this.binding.choosePhotDisabilityDetails.setText("");
                this.binding.passPhotoDisabilityDetails.setVisibility(8);
                this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
                this.disablilityCertificateAttached = "N";
            } else {
                this.disabilityDetailsPhotograph = "";
                this.binding.uploadTv1.setVisibility(8);
                this.binding.document2.setVisibility(8);
                this.binding.chooseFileDisabilityDetailsTv.setVisibility(8);
                this.binding.passPhotoDisabilityDetails.setVisibility(8);
                this.disablilityCertificateAttached = "N";
            }
            Logger.d(TAG, "disablilityCertificateAttached " + this.disablilityCertificateAttached);
        }
    }

    private void showPersonImageDialog() {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_person_image_dialog_layout);
        dialog.show();
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_image);
        ((TextView) dialog.findViewById(R.id.person_image_name)).setText(this.checkListForm6Model.getPhotograph().trim());
        imageView.setImageBitmap(this.bitmapPersonImage);
        ((ImageView) dialog.findViewById(R.id.person_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void showPersonPdfDialog() throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        Logger.d(TAG, "encodedPersonImage " + this.encodedPersonImage);
        pDFViewFindViewById.fromFile(new File((String) Objects.requireNonNull(getSaveImagePath(this.encodedPersonImage, ".pdf").getPath()))).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.personalPhotograph);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda76
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showSignaturePdfDialog(String signatureFile) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        Log.d("signature string name", signatureFile);
        Uri saveImagePath = getSaveImagePath(signatureFile, ".pdf");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + this.saveImageFileName);
        new File((String) Objects.requireNonNull(saveImagePath.getPath()));
        pDFViewFindViewById.fromFile(file).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(this.declarationSignPhotograph);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void getForm6CheckListData() {
        this.personalPhotograph = this.checkListForm6Model.getPhotograph();
        this.dateOfBirthPhotoPhotograph = this.checkListForm6Model.getAgeProofDocument();
        this.residenceProofPhotoPhotograph = this.checkListForm6Model.getCurrentAddressProofDocument();
        this.disabilityDetailsPhotograph = this.checkListForm6Model.getDisabilityCertificate();
        this.declarationSignPhotograph = this.checkListForm6Model.getDecsirf6DeclSignature();
        if (this.binding.emailRg.getCheckedRadioButtonId() == -1) {
            this.binding.selfRb.setChecked(true);
        }
        if (this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
            this.binding.self.setChecked(true);
        }
        if (this.selectedType.equals(this.personalDetails)) {
            if (this.personalPhotograph.trim().length() == 0) {
                this.personalPhotograph = "";
                this.binding.choosePhotoPersonalDetails.setText("");
                this.binding.passPhotoPersonalDetails.setVisibility(8);
                this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getPhotograph());
                this.binding.personalDetailPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda32
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$getForm6CheckListData$25(view);
                    }
                });
            }
        } else if (this.selectedType.equals(this.dateOfBirth)) {
            if (this.dateOfBirthPhotoPhotograph.trim().length() == 0) {
                this.dateOfBirthPhotoPhotograph = "";
                this.binding.choosePhotDateOfBirth.setText("");
                this.binding.passPhotoDateOfBirth.setVisibility(8);
                this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getAgeProofDocument());
            }
        } else if (this.selectedType.equals(this.residenceDetail)) {
            if (this.residenceProofPhotoPhotograph.trim().length() == 0) {
                this.residenceProofPhotoPhotograph = "";
                this.binding.choosePhotResidenceDetails.setText("");
                this.binding.passPhotoResidenceDetails.setVisibility(8);
                this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getCurrentAddressProofDocument());
            }
        } else if (this.selectedType.equals(this.categoryOfDisability)) {
            if (this.disabilityDetailsPhotograph.trim().length() == 0) {
                this.disabilityDetailsPhotograph = "";
                this.binding.choosePhotDisabilityDetails.setText("");
                this.binding.passPhotoDisabilityDetails.setVisibility(8);
                this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                this.binding.uploadTv1.setVisibility(0);
                this.binding.document2.setVisibility(0);
                this.binding.chooseFileDisabilityDetailsTv.setVisibility(0);
                this.binding.passPhotoDisabilityDetails.setVisibility(0);
                downloadImage(this.checkListForm6Model.getDisabilityCertificate());
            }
        } else if (this.selectedType.equals(this.DeclarationDetails)) {
            if (TextUtils.isEmpty(this.declarationSignPhotograph)) {
                this.declarationSignPhotograph = "";
                this.binding.declarationSirIncludedLayout.decFormSignName.setText("");
                this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(8);
                this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setTextColor(Color.parseColor(this.color000000));
            } else {
                this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(0);
                this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                downloadImage(this.declarationSignPhotograph);
            }
        }
        this.binding.firstNameEd.setText(this.checkListForm6Model.getFirstName().trim());
        this.binding.firstnameOfficial.setText(this.checkListForm6Model.getFirstNameL1().trim());
        this.binding.firstnameOfficial2.setText(this.checkListForm6Model.getFirstNameL2().trim());
        this.binding.surNameEd.setText(this.checkListForm6Model.getLastName().trim());
        this.binding.surnameOfficial.setText(this.checkListForm6Model.getLastNameL1().trim());
        this.binding.surnameOfficial2.setText(this.checkListForm6Model.getLastNameL2().trim());
        if (this.checkListForm6Model.getApplicantGender() != null) {
            String applicantGender = this.checkListForm6Model.getApplicantGender();
            applicantGender.hashCode();
            switch (applicantGender) {
                case "F":
                case "Female":
                    this.binding.genderRg.check(R.id.female_rb);
                    break;
                case "M":
                case "Male":
                    this.binding.genderRg.check(R.id.male_rb);
                    break;
                case "T":
                    this.binding.genderRg.check(R.id.third_gender_rb);
                    break;
            }
        }
        if (this.checkListForm6Model.getRelativeMobile().length() != 0 && this.checkListForm6Model.getMobileNumber().trim().length() != 0) {
            this.binding.self.setChecked(false);
            this.binding.relative.setChecked(true);
            this.mobileNumberRelaionType = this.checkListForm6Model.getTypeOfRelation();
            this.binding.mobileNumEd.setText(this.checkListForm6Model.getRelativeMobile().trim());
        } else if (this.checkListForm6Model.getMobileNumber().trim().length() != 0) {
            this.binding.self.setChecked(true);
            this.binding.relative.setChecked(false);
            this.mobileNumberRelaionType = "Self";
            this.binding.mobileNumEd.setText(this.checkListForm6Model.getMobileNumber().trim());
        }
        if (this.checkListForm6Model.getRelativeEmail().length() != 0 && this.checkListForm6Model.getEmail().trim().length() != 0) {
            this.binding.selfRb.setChecked(false);
            this.binding.emailRb.setChecked(true);
            this.emailIdRelationType = this.checkListForm6Model.getTypeOfRelation();
            this.binding.emailEd.setText(this.checkListForm6Model.getRelativeEmail().trim());
        } else if (this.checkListForm6Model.getEmail().trim().length() != 0) {
            this.binding.selfRb.setChecked(true);
            this.binding.emailRb.setChecked(false);
            this.emailIdRelationType = "Self";
            this.binding.emailEd.setText(this.checkListForm6Model.getEmail().trim());
        }
        this.binding.relativeName.setText(this.checkListForm6Model.getApplicantRelativeName().trim());
        this.binding.relativeNameOfficial.setText(this.checkListForm6Model.getApplicantRelativeNameL1().trim());
        this.binding.relativeNameOfficial2.setText(this.checkListForm6Model.getApplicantRelativeNameL2().trim());
        this.binding.relativeSurname.setText(this.checkListForm6Model.getApplicantRelativeSurname().trim());
        this.binding.relativeSurnameOfficial.setText(this.checkListForm6Model.getApplicantRelativeSurnameL1().trim());
        this.binding.relativeSurnameOfficial2.setText(this.checkListForm6Model.getApplicantRelativeSurnameL2().trim());
        Logger.d(TAG, "checkListForm6Model.getTypeOfRelation() -- > " + this.checkListForm6Model.getTypeOfRelation());
        if (this.checkListForm6Model.getTypeOfRelation() != null) {
            if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.father) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.fthr)) {
                this.binding.familyRadioGroup.check(R.id.father_radio_btn);
            } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.mother) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.mthr)) {
                this.binding.familyRadioGroup.check(R.id.mother_radio_btn);
            } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.husband) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.hsbn)) {
                this.binding.familyRadioGroup.check(R.id.husband_radio_btn);
            } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.wife) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.wifeCode)) {
                this.binding.familyRadioGroup.check(R.id.wife_radio_btn);
            } else if (this.checkListForm6Model.getApplicantGender().equalsIgnoreCase("T") && (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.other) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.otherCode))) {
                this.binding.familyRadioGroup.check(R.id.legal_guardian_rb);
            } else if (!this.checkListForm6Model.getApplicantGender().equalsIgnoreCase("T") && (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.other) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.otherCode))) {
                this.binding.familyRadioGroup.check(R.id.other_rb);
            }
        }
        if (this.checkListForm6Model.getAadharRefNo().length() == 0) {
            this.binding.aadharRb.setChecked(false);
            this.binding.noAadharRb.setChecked(true);
        } else {
            this.binding.aadharRb.setChecked(true);
            this.binding.noAadharRb.setChecked(false);
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentHouseNumber())) {
            this.binding.houseNoEd.setText("");
        } else {
            this.binding.houseNoEd.setText(this.checkListForm6Model.getCurrentHouseNumber().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentHouseNumberL1())) {
            this.binding.houseNoEdOfficial.setText("");
        } else {
            this.binding.houseNoEdOfficial.setText(this.checkListForm6Model.getCurrentHouseNumberL1().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentHouseNumberL2())) {
            this.binding.houseNoEdOfficial2.setText("");
        } else {
            this.binding.houseNoEdOfficial2.setText(this.checkListForm6Model.getCurrentHouseNumberL2().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentLocality())) {
            this.binding.streetEd.setText("");
        } else {
            this.binding.streetEd.setText(this.checkListForm6Model.getCurrentLocality());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentLocalityL1())) {
            this.binding.streetEdOfficial.setText("");
        } else {
            this.binding.streetEdOfficial.setText(this.checkListForm6Model.getCurrentLocalityL1().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentLocalityL2())) {
            this.binding.streetEdOfficial2.setText("");
        } else {
            this.binding.streetEdOfficial2.setText(this.checkListForm6Model.getCurrentLocalityL2().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentVillageOrTown())) {
            this.binding.townEd.setText("");
        } else {
            this.binding.townEd.setText(this.checkListForm6Model.getCurrentVillageOrTown().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentVillageOrTownL1())) {
            this.binding.townEdOfficial.setText("");
        } else {
            this.binding.townEdOfficial.setText(this.checkListForm6Model.getCurrentVillageOrTownL1().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentVillageOrTownL2())) {
            this.binding.townEdOfficial2.setText("");
        } else {
            this.binding.townEdOfficial2.setText(this.checkListForm6Model.getCurrentVillageOrTownL2().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentPostOffice())) {
            this.binding.postofficeEd.setText("");
        } else {
            this.binding.postofficeEd.setText(this.checkListForm6Model.getCurrentPostOffice().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentPostOfficeL1())) {
            this.binding.postofficeOfficial.setText("");
        } else {
            this.binding.postofficeOfficial.setText(this.checkListForm6Model.getCurrentPostOfficeL1().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentPostOfficeL2())) {
            this.binding.postofficeOfficial2.setText("");
        } else {
            this.binding.postofficeOfficial2.setText(this.checkListForm6Model.getCurrentPostOfficeL2().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentPinCode())) {
            this.binding.pincodeEd.setText("");
        } else {
            this.binding.pincodeEd.setText(this.checkListForm6Model.getCurrentPinCode().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentAddressTehTalMan())) {
            this.binding.tehsilEd.setText("");
        } else {
            this.binding.tehsilEd.setText(this.checkListForm6Model.getCurrentAddressTehTalMan().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentAddressTehL1())) {
            this.binding.tehsilEdofficial.setText("");
        } else {
            this.binding.tehsilEdofficial.setText(this.checkListForm6Model.getCurrentAddressTehL1().trim());
        }
        if (TextUtils.isEmpty(this.checkListForm6Model.getCurrentAddressTehL2())) {
            this.binding.tehsilEdofficial2.setText("");
        } else {
            this.binding.tehsilEdofficial2.setText(this.checkListForm6Model.getCurrentAddressTehL2().trim());
        }
        this.binding.districtTv.setText(this.districtName);
        this.binding.stateTv.setText(this.stateName);
        if (this.checkListForm6Model.getCurrentAddressProofType().length() > 0) {
            this.binding.documentSp.setSelection(this.documentadapter.getPosition(this.checkListForm6Model.getCurrentAddressProofType()));
        } else {
            this.binding.documentSp.setSelection(0);
        }
        if (this.checkListForm6Model.getAddressProofOthers().equals("Y")) {
            this.binding.documentSp.setSelection(this.documentadapter.getPosition(this.anyOtherDocument));
            this.binding.anyTv.setVisibility(0);
            this.binding.anyOtherEd.setVisibility(0);
            this.binding.anyOtherEd.setText(this.checkListForm6Model.getCurrentAddressProofType().trim());
        } else {
            this.binding.anyTv.setVisibility(8);
            this.binding.anyOtherEd.setVisibility(8);
            this.binding.anyOtherEd.setText("");
        }
        if (this.checkListForm6Model.getDob().contains("-")) {
            String[] strArrSplit = this.checkListForm6Model.getDob().split("-");
            String str = strArrSplit[1];
            String str2 = strArrSplit[2];
            if (str.length() == 1) {
                str = "0" + str;
            }
            if (str2.length() == 1) {
                str2 = "0" + str2;
            }
            int i = Integer.parseInt(strArrSplit[0]);
            this.checkListForm6Model.setAgeAtFormSubmission(getAge(i, Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2])));
            this.binding.dobEd.setText(str2 + "/" + str + "/" + i);
            this.binding.age.setText(this.checkListForm6Model.getAgeAtFormSubmission().trim());
        }
        if (this.checkListForm6Model.getAgeProofType().length() > 0) {
            this.binding.documentSpinner.setSelection(this.documentadapter1.getPosition(this.checkListForm6Model.getAgeProofType()));
        } else {
            this.binding.documentSpinner.setSelection(0);
        }
        if (this.checkListForm6Model.getAgeProofOthers().equals("Y")) {
            this.binding.documentSpinner.setSelection(this.documentadapter1.getPosition(this.anyOtherDocument));
            this.binding.dobProofTv.setVisibility(0);
            this.binding.otherEd.setVisibility(8);
            this.binding.otherEd.setText("OTHR");
        } else {
            this.binding.dobProofTv.setVisibility(8);
            this.binding.otherEd.setVisibility(8);
            this.binding.otherEd.setText("");
        }
        if (this.checkListForm6Model.getDisabilityTypeLocomotor().equals("Y")) {
            this.binding.loco.setChecked(true);
        }
        if (this.checkListForm6Model.getDisabilityTypeSh().equals("Y")) {
            this.binding.deaf.setChecked(true);
        }
        if (this.checkListForm6Model.getDisabilityTypeVi().equals("Y")) {
            this.binding.visual.setChecked(true);
        }
        if (this.checkListForm6Model.getDisabilityTypeOthers().equals("Y")) {
            this.binding.other.setChecked(true);
            this.binding.otherEdDetails.setText(this.checkListForm6Model.getDisability().trim().trim());
        }
        this.binding.percentageEd.setText(this.checkListForm6Model.getDisabilityPercentage().trim());
        if (this.checkListForm6Model.getDisabilityCertAttached().equals("Y")) {
            this.disablilityCertificateAttached = "Y";
            this.binding.yes.setChecked(true);
            this.binding.no.setChecked(false);
        } else {
            this.disablilityCertificateAttached = "N";
            this.binding.yes.setChecked(false);
            this.binding.no.setChecked(true);
        }
        this.binding.familyMemberName.setText(this.checkListForm6Model.getCurrentRelFullName().trim());
        this.binding.familyEpicEditText.setText(this.checkListForm6Model.getCurrentRelEpic().trim());
        if (this.checkListForm6Model.getCurrentRelRelationship().length() > 0) {
            this.binding.familySp.setSelection(this.relationadapter.getPosition(this.checkListForm6Model.getCurrentRelRelationship()));
        } else {
            this.binding.familySp.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getForm6CheckListData$25(View view) {
        if (this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jpg") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jpeg") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jfif") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".png")) {
            showPersonImageDialog();
            return;
        }
        if (this.checkListForm6Model.getPhotograph().toLowerCase().contains(".pdf")) {
            try {
                this.binding.personalDetailPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                showPersonPdfDialog();
            } catch (IOException e) {
                Logger.d(TAG, this.exception + e.getMessage());
            }
        }
    }

    private void onResetButton() {
        this.personalPhotograph = this.checkListForm6Model.getPhotograph();
        this.dateOfBirthPhotoPhotograph = this.checkListForm6Model.getAgeProofDocument();
        this.residenceProofPhotoPhotograph = this.checkListForm6Model.getCurrentAddressProofDocument();
        this.disabilityDetailsPhotograph = this.checkListForm6Model.getDisabilityCertificate();
        this.declarationSignPhotograph = this.checkListForm6Model.getDecsirf6DeclSignature();
        if (this.selectedType.equals(this.personalDetails)) {
            this.alertDialog.show();
            if (this.personalPhotograph.trim().length() == 0) {
                this.personalPhotograph = "";
                this.binding.choosePhotoPersonalDetails.setText("");
                this.binding.passPhotoPersonalDetails.setVisibility(8);
                this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getPhotograph());
                this.binding.personalDetailPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda66
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onResetButton$26(view);
                    }
                });
            }
            if (this.checkListForm6Model.getApplicantGender() != null) {
                String applicantGender = this.checkListForm6Model.getApplicantGender();
                applicantGender.hashCode();
                switch (applicantGender) {
                    case "F":
                    case "Female":
                        this.binding.genderRg.check(R.id.female_rb);
                        break;
                    case "M":
                    case "Male":
                        this.binding.genderRg.check(R.id.male_rb);
                        break;
                    case "T":
                        this.binding.genderRg.check(R.id.third_gender_rb);
                        break;
                }
            }
            if (this.checkListForm6Model.getTypeOfRelation() != null) {
                if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.father) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase("FTHR")) {
                    this.binding.familyRadioGroup.check(R.id.father_radio_btn);
                } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.mother) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.mthr)) {
                    this.binding.familyRadioGroup.check(R.id.mother_radio_btn);
                } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.husband) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.hsbn)) {
                    this.binding.familyRadioGroup.check(R.id.husband_radio_btn);
                } else if (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.wife) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.wifeCode)) {
                    this.binding.familyRadioGroup.check(R.id.wife_radio_btn);
                } else if (this.checkListForm6Model.getApplicantGender().equalsIgnoreCase("T") && (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.other) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.otherCode))) {
                    this.binding.familyRadioGroup.check(R.id.legal_guardian_rb);
                } else if (!this.checkListForm6Model.getApplicantGender().equalsIgnoreCase("T") && (this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.other) || this.checkListForm6Model.getTypeOfRelation().equalsIgnoreCase(this.otherCode))) {
                    this.binding.familyRadioGroup.check(R.id.other_rb);
                }
            }
            if (this.checkListForm6Model.getMobileNumber().length() != 0) {
                this.binding.self.setChecked(true);
                this.binding.relative.setChecked(false);
                this.mobileNumberRelaionType = "Self";
                this.binding.mobileNumEd.setText(this.checkListForm6Model.getMobileNumber().trim());
            } else if (this.checkListForm6Model.getRelativeMobile().length() != 0) {
                this.binding.self.setChecked(false);
                this.binding.relative.setChecked(true);
                this.mobileNumberRelaionType = this.checkListForm6Model.getTypeOfRelation();
                this.binding.mobileNumEd.setText(this.checkListForm6Model.getRelativeMobile().trim());
            }
            if (this.checkListForm6Model.getEmail().length() != 0) {
                this.binding.selfRb.setChecked(true);
                this.binding.emailRb.setChecked(false);
                this.emailIdRelationType = "Self";
                this.binding.emailEd.setText(this.checkListForm6Model.getEmail().trim());
            } else if (this.checkListForm6Model.getRelativeMobile().length() != 0) {
                this.binding.selfRb.setChecked(false);
                this.binding.emailRb.setChecked(true);
                this.emailIdRelationType = this.checkListForm6Model.getTypeOfRelation();
                this.binding.emailEd.setText(this.checkListForm6Model.getRelativeEmail().trim());
            }
            this.binding.relativeName.setText(this.checkListForm6Model.getApplicantRelativeName().trim());
            this.binding.relativeNameOfficial.setText(this.checkListForm6Model.getApplicantRelativeNameL1().trim());
            this.binding.relativeNameOfficial2.setText(this.checkListForm6Model.getApplicantRelativeNameL2().trim());
            this.binding.relativeSurname.setText(this.checkListForm6Model.getApplicantRelativeSurname().trim());
            this.binding.relativeSurnameOfficial.setText(this.checkListForm6Model.getApplicantRelativeSurnameL1().trim());
            this.binding.relativeSurnameOfficial2.setText(this.checkListForm6Model.getApplicantRelativeSurnameL2().trim());
            if (this.binding.emailRg.getCheckedRadioButtonId() == -1) {
                this.binding.selfRb.setChecked(true);
            }
            this.binding.firstNameEd.setText(this.checkListForm6Model.getFirstName().trim());
            this.binding.firstnameOfficial.setText(this.checkListForm6Model.getFirstNameL1().trim());
            this.binding.firstnameOfficial2.setText(this.checkListForm6Model.getFirstNameL2().trim());
            this.binding.surNameEd.setText(this.checkListForm6Model.getLastName().trim());
            this.binding.surnameOfficial.setText(this.checkListForm6Model.getLastNameL1().trim());
            this.binding.surnameOfficial2.setText(this.checkListForm6Model.getLastNameL2().trim());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda77
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$27();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.authentication)) {
            this.alertDialog.show();
            this.commonUtilClass.getaadhar(getContext(), this.stateCode, this.token, this.checkListForm6Model.getAadharRefNo(), SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "ChecklistForm6", new MultipleString() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda78
                @Override // in.gov.eci.bloapp.MultipleString
                public final void onCallBack(String str, String str2) {
                    this.f$0.lambda$onResetButton$28(str, str2);
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda79
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$29();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.dateOfBirth)) {
            if (this.dateOfBirthPhotoPhotograph.trim().length() == 0) {
                this.dateOfBirthPhotoPhotograph = "";
                this.binding.choosePhotDateOfBirth.setText("");
                this.binding.passPhotoDateOfBirth.setVisibility(8);
                this.binding.chooseFileDateOfBirthTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getAgeProofDocument());
            }
            if (this.checkListForm6Model.getDob().contains("-")) {
                String[] strArrSplit = this.checkListForm6Model.getDob().split("-");
                String str = strArrSplit[1];
                String str2 = strArrSplit[2];
                if (str.length() == 1) {
                    str = "0" + str;
                }
                if (str2.length() == 1) {
                    str2 = "0" + str2;
                }
                int i = Integer.parseInt(strArrSplit[0]);
                int i2 = Integer.parseInt(strArrSplit[1]);
                int i3 = Integer.parseInt(strArrSplit[2]);
                this.checkListForm6Model.setAgeAtFormSubmission(getAge(i, i2, i3));
                this.binding.dobEd.setText(i3 + "/" + str + "/" + str2);
                this.binding.age.setText(this.checkListForm6Model.getAgeAtFormSubmission().trim());
            }
            if (this.checkListForm6Model.getAgeProofType() != null) {
                this.binding.documentSpinner.setSelection(this.documentadapter1.getPosition(this.checkListForm6Model.getAgeProofType()));
            } else {
                this.binding.documentSpinner.setSelection(0);
            }
            if (this.checkListForm6Model.getAgeProofOthers().equals("Y")) {
                this.binding.documentSpinner.setSelection(this.documentadapter1.getPosition(this.anyOtherDocument));
                this.binding.dobProofTv.setVisibility(0);
                this.binding.otherEd.setVisibility(8);
                this.binding.otherEd.setText("OTHR");
            } else {
                this.binding.dobProofTv.setVisibility(8);
                this.binding.otherEd.setVisibility(8);
                this.binding.otherEd.setText("");
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$30();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.residenceDetail)) {
            this.alertDialog.show();
            if (this.residenceProofPhotoPhotograph.trim().length() == 0) {
                this.residenceProofPhotoPhotograph = "";
                this.binding.choosePhotResidenceDetails.setText("");
                this.binding.passPhotoResidenceDetails.setVisibility(8);
                this.binding.chooseFileResidenceDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getCurrentAddressProofDocument());
            }
            this.binding.houseNoEd.setText(this.checkListForm6Model.getCurrentHouseNumber().trim());
            this.binding.houseNoEdOfficial.setText(this.checkListForm6Model.getCurrentHouseNumberL1().trim());
            this.binding.houseNoEdOfficial2.setText(this.checkListForm6Model.getCurrentHouseNumberL2().trim());
            this.binding.streetEd.setText(this.checkListForm6Model.getCurrentLocality().trim());
            this.binding.streetEdOfficial.setText(this.checkListForm6Model.getCurrentLocalityL1().trim());
            this.binding.streetEdOfficial2.setText(this.checkListForm6Model.getCurrentLocalityL2().trim());
            this.binding.townEd.setText(this.checkListForm6Model.getCurrentVillageOrTown().trim());
            this.binding.townEdOfficial.setText(this.checkListForm6Model.getCurrentVillageOrTownL1().trim());
            this.binding.townEdOfficial2.setText(this.checkListForm6Model.getCurrentVillageOrTownL2().trim());
            this.binding.postofficeEd.setText(this.checkListForm6Model.getCurrentPostOffice().trim());
            this.binding.pincodeEd.setText(this.checkListForm6Model.getCurrentPinCode().trim());
            this.binding.tehsilEd.setText(this.checkListForm6Model.getCurrentAddressTehTalMan().trim());
            this.binding.tehsilEdofficial.setText(this.checkListForm6Model.getCurrentAddressTehL1().trim());
            this.binding.tehsilEdofficial2.setText(this.checkListForm6Model.getCurrentAddressTehL2().trim());
            this.binding.districtTv.setText(this.stateName);
            this.binding.stateTv.setText(this.districtName);
            if (this.checkListForm6Model.getCurrentAddressProofType() != null) {
                this.binding.documentSp.setSelection(this.documentadapter.getPosition(this.checkListForm6Model.getCurrentAddressProofType()));
            } else {
                this.binding.documentSp.setSelection(0);
            }
            if (this.checkListForm6Model.getAddressProofOthers().equals("Y")) {
                this.binding.documentSp.setSelection(this.documentadapter.getPosition(this.anyOtherDocument));
                this.binding.anyTv.setVisibility(0);
                this.binding.anyOtherEd.setVisibility(0);
                this.binding.anyOtherEd.setText(this.checkListForm6Model.getCurrentAddressProofType().trim());
            } else {
                this.binding.anyTv.setVisibility(8);
                this.binding.anyOtherEd.setVisibility(8);
                this.binding.anyOtherEd.setText("");
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$31();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.categoryOfDisability)) {
            this.alertDialog.show();
            if (this.disabilityDetailsPhotograph.trim().length() == 0) {
                this.disabilityDetailsPhotograph = "";
                this.binding.choosePhotDisabilityDetails.setText("");
                this.binding.passPhotoDisabilityDetails.setVisibility(8);
                this.binding.chooseFileDisabilityDetailsTv.setTextColor(Color.parseColor(this.color000000));
            } else {
                downloadImage(this.checkListForm6Model.getDisabilityCertificate());
            }
            this.binding.loco.setChecked(this.checkListForm6Model.getDisabilityTypeLocomotor().equals("Y"));
            this.binding.deaf.setChecked(this.checkListForm6Model.getDisabilityTypeSh().equals("Y"));
            this.binding.visual.setChecked(this.checkListForm6Model.getDisabilityTypeVi().equals("Y"));
            if (this.checkListForm6Model.getDisabilityTypeOthers().equals("Y")) {
                this.binding.other.setChecked(true);
                this.binding.otherEdDetails.setText(this.checkListForm6Model.getDisability().trim());
            } else {
                this.binding.other.setChecked(false);
                this.binding.otherEdDetails.setText("");
            }
            if (this.checkListForm6Model.getDisabilityCertAttached().equals("Y")) {
                this.binding.yes.setChecked(true);
                this.binding.no.setChecked(false);
            } else {
                this.binding.yes.setChecked(false);
                this.binding.no.setChecked(true);
            }
            this.binding.percentageEd.setText(this.checkListForm6Model.getDisabilityPercentage().trim());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$32();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.familyDetails)) {
            this.alertDialog.show();
            if (this.checkListForm6Model.getCurrentRelRelationship() != null) {
                this.binding.familySp.setSelection(this.relationadapter.getPosition(this.checkListForm6Model.getCurrentRelRelationship()));
            } else {
                this.binding.familySp.setSelection(0);
            }
            this.binding.familyMemberName.setText(this.checkListForm6Model.getCurrentRelFullName().trim());
            this.binding.familyEpicEditText.setText(this.checkListForm6Model.getCurrentRelEpic().trim());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResetButton$33();
                }
            }, 2000L);
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.reset, this.dataResetSuccessfully);
            return;
        }
        if (this.selectedType.equals(this.AnnexureDetails)) {
            resetAnnexure();
        } else if (this.selectedType.equals(this.DeclarationDetails)) {
            resetDeclaration();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$26(View view) {
        if (this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jpg") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jpeg") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".jfif") || this.checkListForm6Model.getPhotograph().toLowerCase().contains(".png")) {
            showPersonImageDialog();
            return;
        }
        if (this.checkListForm6Model.getPhotograph().toLowerCase().contains(".pdf")) {
            try {
                this.binding.personalDetailPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                showPersonPdfDialog();
            } catch (IOException e) {
                Logger.d(TAG, this.exception + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$27() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$28(String str, String str2) {
        if (str2.trim().length() == 12) {
            this.binding.aadharEd.setText(str2);
            this.binding.aadharRb.setChecked(true);
            this.binding.noAadharRb.setChecked(false);
        } else {
            this.binding.aadharRb.setChecked(false);
            this.binding.noAadharRb.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$29() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$30() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$31() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$32() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResetButton$33() {
        this.alertDialog.dismiss();
    }

    private void resetDeclaration() {
        this.progenyStatus = "D";
        this.binding.declarationSirIncludedLayout.fatherEpicNumber.setText("");
        this.binding.declarationSirIncludedLayout.fatherName.setText("");
        this.binding.declarationSirIncludedLayout.motherEpicNumber.setText("");
        this.binding.declarationSirIncludedLayout.motherName.setText("");
        this.binding.declarationSirIncludedLayout.spouseEpicNumber.setText("");
        this.binding.declarationSirIncludedLayout.spouseName.setText("");
        this.binding.declarationSirIncludedLayout.searchRG.clearCheck();
        this.binding.declarationSirIncludedLayout.chooseRG.clearCheck();
        this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setSelection(0);
        this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(8);
        this.binding.declarationSirIncludedLayout.tvRlState.setText("");
        this.binding.declarationSirIncludedLayout.tvRlAcName.setText("");
        this.binding.declarationSirIncludedLayout.tvRlPartNo.setText("");
        this.binding.declarationSirIncludedLayout.tvRlSrNo.setText("");
        this.binding.declarationSirIncludedLayout.tvRlAcNo.setText("");
        this.binding.declarationSirIncludedLayout.tvRlName.setText("");
        this.binding.declarationSirIncludedLayout.tvRlEpic.setText("");
        this.binding.declarationSirIncludedLayout.tvRlName1.setText("");
        this.binding.declarationSirIncludedLayout.tvRlRelation.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvName.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvRelation.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvName1.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvState.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvAcNo.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvAcName.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvEpic.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvPartNo.setText("");
        this.binding.declarationSirIncludedLayout.dfTvtvSrNo.setText("");
    }

    private void onCancelButton() {
        this.selectedButton = this.cancel;
        Bundle arguments = getArguments();
        arguments.putInt("visitCount", this.visitCount);
        arguments.putString("actionDate", this.actionDate);
        arguments.putString(this.refNo, this.referenceNo);
        arguments.putString("selectedButton", this.selectedButton);
        arguments.putString(this.formTypeBundle, this.formType);
        arguments.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        arguments.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        Form6 form6 = new Form6();
        form6.setArguments(arguments);
        openFragment(form6);
    }

    private void onSaveButton() {
        if (validation()) {
            this.selectedButton = "Save";
            if (this.selectedType.equals(this.personalDetails)) {
                Logger.d(TAG, "mobileNumberRelaionType " + this.mobileNumberRelaionType);
                Logger.d(TAG, "emailIdRelationType " + this.emailIdRelationType);
                this.checkListForm6Model.setPhotograph(this.personalPhotograph.trim());
                this.checkListForm6Model.setFirstName(this.binding.firstNameEd.getText().toString().trim());
                this.checkListForm6Model.setFirstNameL1(this.binding.firstnameOfficial.getText().toString().trim());
                this.checkListForm6Model.setFirstNameL2(this.binding.firstnameOfficial2.getText().toString().trim());
                this.checkListForm6Model.setLastName(this.binding.surNameEd.getText().toString().trim());
                this.checkListForm6Model.setLastNameL1(this.binding.surnameOfficial.getText().toString().trim());
                this.checkListForm6Model.setLastNameL2(this.binding.surnameOfficial2.getText().toString().trim());
                Logger.d(TAG, "savetypeOfRelation " + this.typeOfRelation);
                this.checkListForm6Model.setTypeOfRelation(this.typeOfRelation);
                this.checkListForm6Model.setApplicantGender(this.gender);
                this.checkListForm6Model.setRelativeMobile("");
                this.checkListForm6Model.setMobileNumber("");
                this.checkListForm6Model.setRelativeEmail("");
                this.checkListForm6Model.setEmail("");
                if (this.mobileNumberRelaionType.equals("Self")) {
                    this.checkListForm6Model.setMobileNumber(this.binding.mobileNumEd.getText().toString().trim());
                    this.checkListForm6Model.setRelativeMobile("");
                } else {
                    this.checkListForm6Model.setMobileNumber("");
                    this.checkListForm6Model.setRelativeMobile(this.binding.mobileNumEd.getText().toString().trim());
                    this.checkListForm6Model.setMobileNumber(this.binding.mobileNumEd.getText().toString().trim());
                }
                if (this.emailIdRelationType.equals("Self")) {
                    this.checkListForm6Model.setEmail(this.binding.emailEd.getText().toString().trim());
                } else {
                    this.checkListForm6Model.setRelativeEmail(this.binding.emailEd.getText().toString().trim());
                    this.checkListForm6Model.setEmail(this.binding.emailEd.getText().toString().trim());
                }
                this.checkListForm6Model.setApplicantRelativeName(this.binding.relativeName.getText().toString().trim());
                this.checkListForm6Model.setApplicantRelativeNameL1(this.binding.relativeNameOfficial.getText().toString().trim());
                this.checkListForm6Model.setApplicantRelativeNameL2(this.binding.relativeNameOfficial2.getText().toString().trim());
                this.checkListForm6Model.setApplicantRelativeSurname(this.binding.relativeSurname.getText().toString().trim());
                this.checkListForm6Model.setApplicantRelativeSurnameL1(this.binding.relativeSurnameOfficial.getText().toString().trim());
                this.checkListForm6Model.setApplicantRelativeSurnameL2(this.binding.relativeSurnameOfficial2.getText().toString().trim());
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda63
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onSaveButton$34(dialogInterface, i);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.authentication)) {
                if (this.binding.noAadharRb.isChecked()) {
                    this.checkListForm6Model.setAadharRefNo("null");
                } else {
                    this.checkListForm6Model.setAadharRefNo(this.aadharref);
                }
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda64
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onSaveButton$35(dialogInterface, i);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.dateOfBirth)) {
                this.checkListForm6Model.setAgeProofDocument(this.dateOfBirthPhotoPhotograph.trim());
                Logger.d(TAG, "AgeDATEoFbRTH " + this.binding.dobEd.getText().toString());
                if (this.binding.dobEd.getText().toString().contains("/")) {
                    String[] strArrSplit = this.binding.dobEd.getText().toString().split("/");
                    String str = strArrSplit[2];
                    String str2 = strArrSplit[1];
                    String str3 = strArrSplit[0];
                    Logger.d(TAG, "Year " + str + " Month " + str2 + " Day " + str3);
                    this.checkListForm6Model.setAgeAtFormSubmission(this.binding.age.getText().toString().trim());
                    this.checkListForm6Model.setDob(str + "-" + str2 + "-" + str3);
                }
                if (this.binding.documentSpinner.getSelectedItem().toString().length() > 0) {
                    for (int i = 0; i < this.checkListForm6Model.getAgeProofList().size(); i++) {
                        if (this.binding.documentSpinner.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getAgeProofList().get(i)) || this.binding.documentSpinner.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getAgeProofListCode().get(i))) {
                            CheckListForm6Model checkListForm6Model = this.checkListForm6Model;
                            checkListForm6Model.setAgeProofType(checkListForm6Model.getAgeProofListCode().get(i));
                        }
                    }
                }
                if (this.binding.documentSpinner.getSelectedItem().toString().equalsIgnoreCase(this.anyOtherDocument)) {
                    this.checkListForm6Model.setAgeProofType("OTHR");
                    this.checkListForm6Model.setAgeProofOthers("Y");
                } else {
                    this.checkListForm6Model.setAgeProofOthers("N");
                }
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda65
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onSaveButton$36(dialogInterface, i2);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.residenceDetail)) {
                this.checkListForm6Model.setCurrentAddressProofDocument(this.residenceProofPhotoPhotograph.trim());
                this.checkListForm6Model.setCurrentHouseNumber(this.binding.houseNoEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentHouseNumberL1(this.binding.houseNoEdOfficial.getText().toString().trim());
                this.checkListForm6Model.setCurrentHouseNumberL2(this.binding.houseNoEdOfficial2.getText().toString().trim());
                this.checkListForm6Model.setCurrentLocality(this.binding.streetEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentLocalityL1(this.binding.streetEdOfficial.getText().toString().trim());
                this.checkListForm6Model.setCurrentLocalityL2(this.binding.streetEdOfficial2.getText().toString().trim());
                this.checkListForm6Model.setCurrentVillageOrTown(this.binding.townEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentVillageOrTownL1(this.binding.townEdOfficial.getText().toString().trim());
                this.checkListForm6Model.setCurrentVillageOrTownL2(this.binding.townEdOfficial2.getText().toString().trim());
                this.checkListForm6Model.setCurrentPostOffice(this.binding.postofficeEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentPostOfficeL1(this.binding.postofficeOfficial.getText().toString().trim());
                this.checkListForm6Model.setCurrentPostOfficeL2(this.binding.postofficeOfficial2.getText().toString().trim());
                this.checkListForm6Model.setCurrentPinCode(this.binding.pincodeEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentAddressTehTalMan(this.binding.tehsilEd.getText().toString().trim());
                this.checkListForm6Model.setCurrentAddressTehL1(this.binding.tehsilEdofficial.getText().toString().trim());
                this.checkListForm6Model.setCurrentAddressTehL2(this.binding.tehsilEdofficial2.getText().toString().trim());
                if (this.binding.documentSp.getSelectedItem().toString().length() > 0) {
                    for (int i2 = 0; i2 < this.checkListForm6Model.getAddressPoofList().size(); i2++) {
                        if (this.binding.documentSp.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getAddressPoofList().get(i2)) || this.binding.documentSp.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getAddressPoofListCode().get(i2))) {
                            CheckListForm6Model checkListForm6Model2 = this.checkListForm6Model;
                            checkListForm6Model2.setCurrentAddressProofType(checkListForm6Model2.getAddressPoofListCode().get(i2));
                        }
                    }
                }
                if (this.binding.anyOtherEd.length() > 0) {
                    this.checkListForm6Model.setCurrentAddressProofType(this.binding.anyOtherEd.getText().toString().trim());
                    this.checkListForm6Model.setAddressProofOthers("Y");
                } else {
                    this.checkListForm6Model.setAddressProofOthers("N");
                }
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda67
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onSaveButton$37(dialogInterface, i3);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.categoryOfDisability)) {
                if (this.binding.loco.isChecked()) {
                    this.checkListForm6Model.setDisabilityTypeLocomotor("Y");
                } else {
                    this.checkListForm6Model.setDisabilityTypeLocomotor("N");
                }
                if (this.binding.deaf.isChecked()) {
                    this.checkListForm6Model.setDisabilityTypeSh("Y");
                } else {
                    this.checkListForm6Model.setDisabilityTypeSh("N");
                }
                if (this.binding.visual.isChecked()) {
                    this.checkListForm6Model.setDisabilityTypeVi("Y");
                } else {
                    this.checkListForm6Model.setDisabilityTypeVi("N");
                }
                if (this.binding.other.isChecked()) {
                    this.checkListForm6Model.setDisabilityTypeOthers("Y");
                    this.checkListForm6Model.setDisability(this.binding.otherEdDetails.getText().toString().trim());
                } else {
                    this.checkListForm6Model.setDisabilityTypeOthers("N");
                }
                this.checkListForm6Model.setDisabilityCertAttached(this.disablilityCertificateAttached.trim());
                this.checkListForm6Model.setDisabilityPercentage(this.binding.percentageEd.getText().toString().trim());
                if (this.checkListForm6Model.getDisabilityCertAttached().equals("Y")) {
                    this.checkListForm6Model.setDisabilityCertAttached("Y");
                    this.checkListForm6Model.setDisabilityCertificate(this.disabilityDetailsPhotograph.trim());
                } else if (this.checkListForm6Model.getDisabilityCertAttached().equals("N")) {
                    this.disabilityDetailsPhotograph = "";
                    this.checkListForm6Model.setDisabilityCertAttached("N");
                    this.checkListForm6Model.setDisabilityCertificate("");
                }
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda68
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onSaveButton$38(dialogInterface, i3);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.familyDetails)) {
                this.checkListForm6Model.setCurrentRelFullName(this.binding.familyMemberName.getText().toString().trim());
                if (this.binding.familySp.getSelectedItemPosition() > 0) {
                    for (int i3 = 0; i3 < this.checkListForm6Model.getRelationList().size(); i3++) {
                        if (this.binding.familySp.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getRelationList().get(i3)) || this.binding.familySp.getSelectedItem().toString().equalsIgnoreCase(this.checkListForm6Model.getRelationListCode().get(i3))) {
                            CheckListForm6Model checkListForm6Model3 = this.checkListForm6Model;
                            checkListForm6Model3.setCurrentRelRelationship(checkListForm6Model3.getRelationListCode().get(i3));
                        }
                    }
                } else {
                    this.checkListForm6Model.setCurrentRelRelationship("");
                }
                this.checkListForm6Model.setCurrentRelEpic(this.binding.familyEpicEditText.getText().toString().trim());
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda69
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$onSaveButton$39(dialogInterface, i4);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.AnnexureDetails)) {
                if (isBiharState() && !TextUtils.isEmpty(this.cat)) {
                    if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
                        this.checkListForm6Model.setCtDocOfSelfUrl(this.list1ref);
                        this.checkListForm6Model.setCtDocTypeForSelf(this.list1Code);
                        if (this.cat.equalsIgnoreCase("CAT-2")) {
                            this.checkListForm6Model.setIsParentsIndian(null);
                            this.checkListForm6Model.setCtDocTypeForFather(null);
                            this.checkListForm6Model.setCtDocTypeForMother(null);
                            this.checkListForm6Model.setCtDocOfFatherUrl(null);
                            this.checkListForm6Model.setCtDocOfMotherUrl(null);
                        } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                            if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                                this.checkListForm6Model.setIsParentsIndian("Y");
                                this.checkListForm6Model.setCtDocTypeForFather(this.list3code);
                                this.checkListForm6Model.setCtDocTypeForMother(null);
                                this.checkListForm6Model.setCtDocOfFatherUrl(this.list3Ref);
                                this.checkListForm6Model.setCtDocOfMotherUrl(null);
                            } else if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                                this.checkListForm6Model.setIsParentsIndian("Y");
                                this.checkListForm6Model.setCtDocTypeForFather(null);
                                this.checkListForm6Model.setCtDocTypeForMother(this.list4code);
                                this.checkListForm6Model.setCtDocOfFatherUrl(null);
                                this.checkListForm6Model.setCtDocOfMotherUrl(this.list4Ref);
                            }
                        } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                            if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                                this.checkListForm6Model.setIsParentsIndian(this.flagcat4scenerio1);
                                this.checkListForm6Model.setCtDocTypeForFather(this.list3code);
                                this.checkListForm6Model.setCtDocTypeForMother(this.list4code);
                                this.checkListForm6Model.setCtDocOfFatherUrl(this.list3Ref);
                                this.checkListForm6Model.setCtDocOfMotherUrl(this.list4Ref);
                            } else if (this.flagcat4scenerio1.equalsIgnoreCase("N") && (this.flagcat4scenerio2.equalsIgnoreCase("Y") || this.flagcat4scenerio3.equalsIgnoreCase("Y"))) {
                                this.checkListForm6Model.setIsParentsIndian("N");
                                if (this.motherNationality.equalsIgnoreCase("Non-Indian") && this.fatherNationality.equalsIgnoreCase("Indian")) {
                                    this.checkListForm6Model.setCtDocTypeForFather(this.list3code);
                                    this.checkListForm6Model.setCtDocTypeForMother(this.list5code);
                                    this.checkListForm6Model.setCtDocOfFatherUrl(this.list3Ref);
                                    this.checkListForm6Model.setCtDocOfMotherUrl(this.list5Ref);
                                } else if (this.fatherNationality.equalsIgnoreCase("Non-Indian") && this.motherNationality.equalsIgnoreCase("Indian")) {
                                    this.checkListForm6Model.setCtDocTypeForFather(this.list5code);
                                    this.checkListForm6Model.setCtDocTypeForMother(this.list4code);
                                    this.checkListForm6Model.setCtDocOfFatherUrl(this.list5Ref);
                                    this.checkListForm6Model.setCtDocOfMotherUrl(this.list4Ref);
                                }
                            }
                        }
                    } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
                        this.checkListForm6Model.setCtDocTypeForSelf(this.list6code);
                        this.checkListForm6Model.setCtDocOfSelfUrl(this.list6ref);
                        this.checkListForm6Model.setIsParentsIndian(null);
                        this.checkListForm6Model.setCtDocTypeForFather(null);
                        this.checkListForm6Model.setCtDocTypeForMother(null);
                        this.checkListForm6Model.setCtDocOfFatherUrl(null);
                        this.checkListForm6Model.setCtDocOfMotherUrl(null);
                    } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                        this.checkListForm6Model.setCtDocTypeForSelf(this.list7code);
                        this.checkListForm6Model.setCtDocOfSelfUrl(this.list7ref);
                        this.checkListForm6Model.setIsParentsIndian(null);
                        this.checkListForm6Model.setCtDocTypeForFather(null);
                        this.checkListForm6Model.setCtDocTypeForMother(null);
                        this.checkListForm6Model.setCtDocOfFatherUrl(null);
                        this.checkListForm6Model.setCtDocOfMotherUrl(null);
                    }
                    String str4 = this.anxDSignUrl;
                    if (str4 != null) {
                        this.checkListForm6Model.setAnxDSignUrl(str4);
                    } else {
                        this.checkListForm6Model.setAnxDSignUrl(null);
                    }
                    this.checkListForm6Model.setCitizenshipType(this.choice);
                    this.checkListForm6Model.setCitizenshipTypeCat(this.cat);
                }
                new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda70
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$onSaveButton$40(dialogInterface, i4);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
                return;
            }
            if (this.selectedType.equals(this.DeclarationDetails)) {
                if (in.gov.eci.bloapp.utils.Utils.isValideSIRState(this.stateCode) || in.gov.eci.bloapp.utils.Utils.isValide19SIRState(this.stateCode)) {
                    setDeclarationUI();
                    this.checkListForm6Model.setFatherorGuardianEpicNo(this.binding.declarationSirIncludedLayout.fatherEpicNumber.getText().toString());
                    this.checkListForm6Model.setFatherorGuardianname(this.binding.declarationSirIncludedLayout.fatherName.getText().toString());
                    this.checkListForm6Model.setMotherEpicNo(this.binding.declarationSirIncludedLayout.motherEpicNumber.getText().toString());
                    this.checkListForm6Model.setMotherName(this.binding.declarationSirIncludedLayout.motherName.getText().toString());
                    this.checkListForm6Model.setSpouseEpicNo(this.binding.declarationSirIncludedLayout.spouseEpicNumber.getText().toString());
                    this.checkListForm6Model.setSpouseName(this.binding.declarationSirIncludedLayout.spouseName.getText().toString());
                    if (this.binding.declarationSirIncludedLayout.dfRBselfRb.isChecked()) {
                        this.checkListForm6Model.setDecsirf6DeclCategory("self");
                    } else if (this.binding.declarationSirIncludedLayout.progenyRb.isChecked()) {
                        this.checkListForm6Model.setDecsirf6DeclCategory("Progeny");
                    } else if (this.binding.declarationSirIncludedLayout.neitherRb.isChecked()) {
                        this.checkListForm6Model.setDecsirf6DeclCategory("NA");
                    }
                    if (!TextUtils.isEmpty(this.relationCode)) {
                        this.checkListForm6Model.setElectorsRelation(this.relationCode);
                    }
                    if (this.binding.declarationSirIncludedLayout.rb2003.isChecked()) {
                        this.checkListForm6Model.setIsSir03("Y");
                        this.checkListForm6Model.setIsSir2526("N");
                    } else if (this.binding.declarationSirIncludedLayout.rb2025.isChecked()) {
                        this.checkListForm6Model.setIsSir03("N");
                        this.checkListForm6Model.setIsSir2526("Y");
                    }
                    Logger.d("declation signature final", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
                    new AlertDialog.Builder(requireContext()).setTitle("Status").setMessage("Data saved successfully").setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda71
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            this.f$0.lambda$onSaveButton$41(dialogInterface, i4);
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$34(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$35(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$36(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$37(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$38(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$39(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$40(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveButton$41(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("visitCount", this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        bundle.putSerializable(this.checkListForm6ModelBundle, this.checkListForm6Model);
        bundle.putSerializable(this.checkListForm6OriginalDataModelBundle, this.checkListForm6OrignalDataModel);
        bundle.putSerializable("annexuredata", this.annexureModel);
        bundle.putString("selectedButton", this.selectedButton);
        bundle.putString(this.refNo, this.referenceNo);
        bundle.putString(this.formTypeBundle, this.formType);
        Form6 form6 = new Form6();
        form6.setArguments(bundle);
        openFragment(form6);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TAG, this.nothingToDo);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.binding.firstNameEd.getText().hashCode() == s.hashCode()) {
            String string = this.binding.firstNameEd.getText().toString();
            if (this.binding.firstNameEd.getText().toString().matches(RegexMatcher.NAME_NEW_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.firstNameEd.setText(string.substring(0, string.length() - 1));
                this.binding.firstNameEd.setSelection(this.binding.firstNameEd.getText().toString().length());
                return;
            } catch (Exception e) {
                Logger.d(TAG, this.exception + e.getMessage());
                return;
            }
        }
        if (this.binding.firstnameOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb = new StringBuilder(this.binding.firstnameOfficial.getText().toString());
                sb.charAt(this.binding.firstnameOfficial.getSelectionStart() - 1);
                int selectionStart = this.binding.firstnameOfficial.getSelectionStart() - 1;
                if (this.binding.firstnameOfficial.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb.deleteCharAt(this.binding.firstnameOfficial.getSelectionStart() - 1);
                    this.binding.firstnameOfficial.setText(sb);
                    Log.d(TAG, String.valueOf(this.binding.firstnameOfficial.getSelectionStart() - 1));
                    this.binding.firstnameOfficial.setSelection(selectionStart);
                    return;
                }
                return;
            } catch (Exception e2) {
                Logger.d(TAG, this.exception + e2.getMessage());
                return;
            }
        }
        if (this.binding.firstnameOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb2 = new StringBuilder(this.binding.firstnameOfficial2.getText().toString());
                sb2.charAt(this.binding.firstnameOfficial2.getSelectionStart() - 1);
                int selectionStart2 = this.binding.firstnameOfficial2.getSelectionStart() - 1;
                if (this.binding.firstnameOfficial2.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb2.deleteCharAt(this.binding.firstnameOfficial2.getSelectionStart() - 1);
                    this.binding.firstnameOfficial2.setText(sb2);
                    Log.d(TAG, String.valueOf(this.binding.firstnameOfficial2.getSelectionStart() - 1));
                    this.binding.firstnameOfficial2.setSelection(selectionStart2);
                    return;
                }
                return;
            } catch (Exception e3) {
                Logger.d(TAG, this.exception + e3.getMessage());
                return;
            }
        }
        if (this.binding.surNameEd.getText().hashCode() == s.hashCode()) {
            String string2 = this.binding.surNameEd.getText().toString();
            if (this.binding.surNameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.surNameEd.setText(string2.substring(0, string2.length() - 1));
                this.binding.surNameEd.setSelection(this.binding.surNameEd.getText().toString().length());
                return;
            } catch (Exception e4) {
                Logger.d(TAG, this.exception + e4.getMessage());
                return;
            }
        }
        if (this.binding.surnameOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb3 = new StringBuilder(this.binding.surnameOfficial.getText().toString());
                sb3.charAt(this.binding.surnameOfficial.getSelectionStart() - 1);
                int selectionStart3 = this.binding.surnameOfficial.getSelectionStart() - 1;
                if (this.binding.surnameOfficial.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb3.deleteCharAt(this.binding.surnameOfficial.getSelectionStart() - 1);
                    this.binding.surnameOfficial.setText(sb3);
                    Log.d(TAG, String.valueOf(this.binding.surnameOfficial.getSelectionStart() - 1));
                    this.binding.surnameOfficial.setSelection(selectionStart3);
                    return;
                }
                return;
            } catch (Exception e5) {
                Logger.d(TAG, this.exception + e5.getMessage());
                return;
            }
        }
        if (this.binding.surnameOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb4 = new StringBuilder(this.binding.surnameOfficial2.getText().toString());
                sb4.charAt(this.binding.surnameOfficial2.getSelectionStart() - 1);
                int selectionStart4 = this.binding.surnameOfficial2.getSelectionStart() - 1;
                if (this.binding.surnameOfficial2.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb4.deleteCharAt(this.binding.surnameOfficial2.getSelectionStart() - 1);
                    this.binding.surnameOfficial2.setText(sb4);
                    Log.d(TAG, String.valueOf(this.binding.surnameOfficial2.getSelectionStart() - 1));
                    this.binding.surnameOfficial2.setSelection(selectionStart4);
                    return;
                }
                return;
            } catch (Exception e6) {
                Logger.d(TAG, this.exception + e6.getMessage());
                return;
            }
        }
        if (this.binding.relativeName.getText().hashCode() == s.hashCode()) {
            String string3 = this.binding.relativeName.getText().toString();
            if (this.binding.relativeName.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.relativeName.setText(string3.substring(0, string3.length() - 1));
                this.binding.relativeName.setSelection(this.binding.relativeName.getText().toString().length());
                return;
            } catch (Exception e7) {
                Logger.d(TAG, this.exception + e7.getMessage());
                return;
            }
        }
        if (this.binding.relativeNameOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb5 = new StringBuilder(this.binding.relativeNameOfficial.getText().toString());
                sb5.charAt(this.binding.relativeNameOfficial.getSelectionStart() - 1);
                int selectionStart5 = this.binding.relativeNameOfficial.getSelectionStart() - 1;
                if (this.binding.relativeNameOfficial.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb5.deleteCharAt(this.binding.relativeNameOfficial.getSelectionStart() - 1);
                    this.binding.relativeNameOfficial.setText(sb5);
                    Log.d(TAG, String.valueOf(this.binding.relativeNameOfficial.getSelectionStart() - 1));
                    this.binding.relativeNameOfficial.setSelection(selectionStart5);
                    return;
                }
                return;
            } catch (Exception e8) {
                Logger.d(TAG, this.exception + e8.getMessage());
                return;
            }
        }
        if (this.binding.relativeNameOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb6 = new StringBuilder(this.binding.relativeNameOfficial2.getText().toString());
                sb6.charAt(this.binding.relativeNameOfficial2.getSelectionStart() - 1);
                int selectionStart6 = this.binding.relativeNameOfficial2.getSelectionStart() - 1;
                if (this.binding.relativeNameOfficial2.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb6.deleteCharAt(this.binding.relativeNameOfficial2.getSelectionStart() - 1);
                    this.binding.relativeNameOfficial2.setText(sb6);
                    Log.d(TAG, String.valueOf(this.binding.relativeNameOfficial2.getSelectionStart() - 1));
                    this.binding.relativeNameOfficial2.setSelection(selectionStart6);
                    return;
                }
                return;
            } catch (Exception e9) {
                Logger.d(TAG, this.exception + e9.getMessage());
                return;
            }
        }
        if (this.binding.relativeSurname.getText().hashCode() == s.hashCode()) {
            String string4 = this.binding.relativeSurname.getText().toString();
            if (this.binding.relativeSurname.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.relativeSurname.setText(string4.substring(0, string4.length() - 1));
                this.binding.relativeSurname.setSelection(this.binding.relativeSurname.getText().toString().length());
                return;
            } catch (Exception e10) {
                Logger.d(TAG, this.exception + e10.getMessage());
                return;
            }
        }
        if (this.binding.relativeSurnameOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb7 = new StringBuilder(this.binding.relativeSurnameOfficial.getText().toString());
                sb7.charAt(this.binding.relativeSurnameOfficial.getSelectionStart() - 1);
                int selectionStart7 = this.binding.relativeSurnameOfficial.getSelectionStart() - 1;
                if (this.binding.relativeSurnameOfficial.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb7.deleteCharAt(this.binding.relativeSurnameOfficial.getSelectionStart() - 1);
                    this.binding.relativeSurnameOfficial.setText(sb7);
                    Log.d(TAG, String.valueOf(this.binding.relativeSurnameOfficial.getSelectionStart() - 1));
                    this.binding.relativeSurnameOfficial.setSelection(selectionStart7);
                    return;
                }
                return;
            } catch (Exception e11) {
                Logger.d(TAG, this.exception + e11.getMessage());
                return;
            }
        }
        if (this.binding.relativeSurnameOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb8 = new StringBuilder(this.binding.relativeSurnameOfficial2.getText().toString());
                sb8.charAt(this.binding.relativeSurnameOfficial2.getSelectionStart() - 1);
                int selectionStart8 = this.binding.relativeSurnameOfficial2.getSelectionStart() - 1;
                if (this.binding.relativeSurnameOfficial2.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                    sb8.deleteCharAt(this.binding.relativeSurnameOfficial2.getSelectionStart() - 1);
                    this.binding.relativeSurnameOfficial2.setText(sb8);
                    Log.d(TAG, String.valueOf(this.binding.relativeSurnameOfficial2.getSelectionStart() - 1));
                    this.binding.relativeSurnameOfficial2.setSelection(selectionStart8);
                    return;
                }
                return;
            } catch (Exception e12) {
                Logger.d(TAG, this.exception + e12.getMessage());
                return;
            }
        }
        if (this.binding.familyMemberName.getText().hashCode() == s.hashCode()) {
            String string5 = this.binding.familyMemberName.getText().toString();
            if (this.binding.familyMemberName.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.familyMemberName.setText(string5.substring(0, string5.length() - 1));
                this.binding.familyMemberName.setSelection(this.binding.familyMemberName.getText().toString().length());
                return;
            } catch (Exception e13) {
                Logger.d(TAG, this.exception + e13.getMessage());
                return;
            }
        }
        if (this.binding.houseNoEd.getText().hashCode() == s.hashCode()) {
            String string6 = this.binding.houseNoEd.getText().toString();
            if (this.binding.houseNoEd.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.houseNoEd.setText(string6.substring(0, string6.length() - 1));
                this.binding.houseNoEd.setSelection(this.binding.houseNoEd.getText().toString().length());
                return;
            } catch (Exception e14) {
                Logger.d(TAG, this.exception + e14.getMessage());
                return;
            }
        }
        if (this.binding.houseNoEdOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb9 = new StringBuilder(this.binding.houseNoEdOfficial.getText().toString());
                sb9.charAt(this.binding.houseNoEdOfficial.getSelectionStart() - 1);
                int selectionStart9 = this.binding.houseNoEdOfficial.getSelectionStart() - 1;
                if (this.binding.houseNoEdOfficial.getText().toString().matches(RegexMatcher.HOUSE_REGIONAL_REGEX)) {
                    sb9.deleteCharAt(this.binding.houseNoEdOfficial.getSelectionStart() - 1);
                    this.binding.houseNoEdOfficial.setText(sb9);
                    Log.d(TAG, String.valueOf(this.binding.houseNoEdOfficial.getSelectionStart() - 1));
                    this.binding.houseNoEdOfficial.setSelection(selectionStart9);
                    return;
                }
                return;
            } catch (Exception e15) {
                Logger.d(TAG, this.exception + e15.getMessage());
                return;
            }
        }
        if (this.binding.houseNoEdOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb10 = new StringBuilder(this.binding.houseNoEdOfficial2.getText().toString());
                sb10.charAt(this.binding.houseNoEdOfficial2.getSelectionStart() - 1);
                int selectionStart10 = this.binding.houseNoEdOfficial2.getSelectionStart() - 1;
                if (this.binding.houseNoEdOfficial2.getText().toString().matches(RegexMatcher.HOUSE_REGIONAL_REGEX)) {
                    sb10.deleteCharAt(this.binding.houseNoEdOfficial2.getSelectionStart() - 1);
                    this.binding.houseNoEdOfficial2.setText(sb10);
                    Log.d(TAG, String.valueOf(this.binding.houseNoEdOfficial2.getSelectionStart() - 1));
                    this.binding.houseNoEdOfficial2.setSelection(selectionStart10);
                    return;
                }
                return;
            } catch (Exception e16) {
                Logger.d(TAG, this.exception + e16.getMessage());
                return;
            }
        }
        if (this.binding.streetEd.getText().hashCode() == s.hashCode()) {
            String string7 = this.binding.streetEd.getText().toString();
            if (this.binding.streetEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.streetEd.setText(string7.substring(0, string7.length() - 1));
                this.binding.streetEd.setSelection(this.binding.streetEd.getText().toString().length());
                return;
            } catch (Exception e17) {
                Logger.d(TAG, this.exception + e17.getMessage());
                return;
            }
        }
        if (this.binding.streetEdOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb11 = new StringBuilder(this.binding.streetEdOfficial.getText().toString());
                sb11.charAt(this.binding.streetEdOfficial.getSelectionStart() - 1);
                int selectionStart11 = this.binding.streetEdOfficial.getSelectionStart() - 1;
                if (this.binding.streetEdOfficial.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                    sb11.deleteCharAt(this.binding.streetEdOfficial.getSelectionStart() - 1);
                    this.binding.streetEdOfficial.setText(sb11);
                    Log.d(TAG, String.valueOf(this.binding.streetEdOfficial.getSelectionStart() - 1));
                    this.binding.streetEdOfficial.setSelection(selectionStart11);
                    return;
                }
                return;
            } catch (Exception e18) {
                Logger.d(TAG, this.exception + e18.getMessage());
                return;
            }
        }
        if (this.binding.streetEdOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb12 = new StringBuilder(this.binding.streetEdOfficial2.getText().toString());
                sb12.charAt(this.binding.streetEdOfficial2.getSelectionStart() - 1);
                int selectionStart12 = this.binding.streetEdOfficial2.getSelectionStart() - 1;
                if (this.binding.streetEdOfficial2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                    sb12.deleteCharAt(this.binding.streetEdOfficial2.getSelectionStart() - 1);
                    this.binding.streetEdOfficial2.setText(sb12);
                    Log.d(TAG, String.valueOf(this.binding.streetEdOfficial2.getSelectionStart() - 1));
                    this.binding.streetEdOfficial2.setSelection(selectionStart12);
                    return;
                }
                return;
            } catch (Exception e19) {
                Logger.d(TAG, this.exception + e19.getMessage());
                return;
            }
        }
        if (this.binding.townEd.getText().hashCode() == s.hashCode()) {
            String string8 = this.binding.townEd.getText().toString();
            if (this.binding.townEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.townEd.setText(string8.substring(0, string8.length() - 1));
                this.binding.townEd.setSelection(this.binding.townEd.getText().toString().length());
                return;
            } catch (Exception e20) {
                Logger.d(TAG, this.exception + e20.getMessage());
                return;
            }
        }
        if (this.binding.townEdOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb13 = new StringBuilder(this.binding.townEdOfficial.getText().toString());
                sb13.charAt(this.binding.townEdOfficial.getSelectionStart() - 1);
                int selectionStart13 = this.binding.townEdOfficial.getSelectionStart() - 1;
                if (this.binding.townEdOfficial.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                    sb13.deleteCharAt(this.binding.townEdOfficial.getSelectionStart() - 1);
                    this.binding.townEdOfficial.setText(sb13);
                    Log.d(TAG, String.valueOf(this.binding.townEdOfficial.getSelectionStart() - 1));
                    this.binding.townEdOfficial.setSelection(selectionStart13);
                    return;
                }
                return;
            } catch (Exception e21) {
                Logger.d(TAG, this.exception + e21.getMessage());
                return;
            }
        }
        if (this.binding.townEdOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb14 = new StringBuilder(this.binding.townEdOfficial2.getText().toString());
                sb14.charAt(this.binding.townEdOfficial2.getSelectionStart() - 1);
                int selectionStart14 = this.binding.townEdOfficial2.getSelectionStart() - 1;
                if (this.binding.townEdOfficial2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                    sb14.deleteCharAt(this.binding.townEdOfficial2.getSelectionStart() - 1);
                    this.binding.townEdOfficial2.setText(sb14);
                    Log.d(TAG, String.valueOf(this.binding.townEdOfficial2.getSelectionStart() - 1));
                    this.binding.townEdOfficial2.setSelection(selectionStart14);
                    return;
                }
                return;
            } catch (Exception e22) {
                Logger.d(TAG, this.exception + e22.getMessage());
                return;
            }
        }
        if (this.binding.postofficeEd.getText().hashCode() == s.hashCode()) {
            String string9 = this.binding.postofficeEd.getText().toString();
            if (this.binding.postofficeEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.postofficeEd.setText(string9.substring(0, string9.length() - 1));
                this.binding.postofficeEd.setSelection(this.binding.postofficeEd.getText().toString().length());
                return;
            } catch (Exception e23) {
                Logger.d(TAG, this.exception + e23.getMessage());
                return;
            }
        }
        if (this.binding.postofficeOfficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb15 = new StringBuilder(this.binding.postofficeOfficial.getText().toString());
                sb15.charAt(this.binding.postofficeOfficial.getSelectionStart() - 1);
                int selectionStart15 = this.binding.postofficeOfficial.getSelectionStart() - 1;
                if (this.binding.postofficeOfficial.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                    sb15.deleteCharAt(this.binding.postofficeOfficial.getSelectionStart() - 1);
                    this.binding.postofficeOfficial.setText(sb15);
                    Log.d(TAG, String.valueOf(this.binding.postofficeOfficial.getSelectionStart() - 1));
                    this.binding.postofficeOfficial.setSelection(selectionStart15);
                    return;
                }
                return;
            } catch (Exception e24) {
                Logger.d(TAG, this.exception + e24.getMessage());
                return;
            }
        }
        if (this.binding.postofficeOfficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb16 = new StringBuilder(this.binding.postofficeOfficial2.getText().toString());
                sb16.charAt(this.binding.postofficeOfficial2.getSelectionStart() - 1);
                int selectionStart16 = this.binding.postofficeOfficial2.getSelectionStart() - 1;
                if (this.binding.postofficeOfficial2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                    sb16.deleteCharAt(this.binding.postofficeOfficial2.getSelectionStart() - 1);
                    this.binding.postofficeOfficial2.setText(sb16);
                    Log.d(TAG, String.valueOf(this.binding.postofficeOfficial2.getSelectionStart() - 1));
                    this.binding.postofficeOfficial2.setSelection(selectionStart16);
                    return;
                }
                return;
            } catch (Exception e25) {
                Logger.d(TAG, this.exception + e25.getMessage());
                return;
            }
        }
        if (this.binding.tehsilEd.getText().hashCode() == s.hashCode()) {
            String string10 = this.binding.tehsilEd.getText().toString();
            if (this.binding.tehsilEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                return;
            }
            try {
                this.binding.tehsilEd.setText(string10.substring(0, string10.length() - 1));
                this.binding.tehsilEd.setSelection(this.binding.tehsilEd.getText().toString().length());
                return;
            } catch (Exception e26) {
                Logger.d(TAG, this.exception + e26.getMessage());
                return;
            }
        }
        if (this.binding.tehsilEdofficial.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb17 = new StringBuilder(this.binding.tehsilEdofficial.getText().toString());
                sb17.charAt(this.binding.tehsilEdofficial.getSelectionStart() - 1);
                int selectionStart17 = this.binding.tehsilEdofficial.getSelectionStart() - 1;
                if (this.binding.tehsilEdofficial.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                    sb17.deleteCharAt(this.binding.tehsilEdofficial.getSelectionStart() - 1);
                    this.binding.tehsilEdofficial.setText(sb17);
                    Log.d(TAG, String.valueOf(this.binding.tehsilEdofficial.getSelectionStart() - 1));
                    this.binding.tehsilEdofficial.setSelection(selectionStart17);
                    return;
                }
                return;
            } catch (Exception e27) {
                Logger.d(TAG, this.exception + e27.getMessage());
                return;
            }
        }
        if (this.binding.tehsilEdofficial2.getText().hashCode() == s.hashCode()) {
            try {
                StringBuilder sb18 = new StringBuilder(this.binding.tehsilEdofficial2.getText().toString());
                sb18.charAt(this.binding.tehsilEdofficial2.getSelectionStart() - 1);
                int selectionStart18 = this.binding.tehsilEdofficial2.getSelectionStart() - 1;
                if (this.binding.tehsilEdofficial2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                    sb18.deleteCharAt(this.binding.tehsilEdofficial2.getSelectionStart() - 1);
                    this.binding.tehsilEdofficial2.setText(sb18);
                    Log.d(TAG, String.valueOf(this.binding.tehsilEdofficial2.getSelectionStart() - 1));
                    this.binding.tehsilEdofficial2.setSelection(selectionStart18);
                    return;
                }
                return;
            } catch (Exception e28) {
                Logger.d(TAG, this.exception + e28.getMessage());
                return;
            }
        }
        if (this.binding.aadharEd.getText().hashCode() == s.hashCode() && this.binding.aadharEd.getText().toString().length() == 12) {
            boolean zValidateVerhoeff = Verhoeff.validateVerhoeff(this.binding.aadharEd.getText().toString());
            this.result = zValidateVerhoeff;
            if (zValidateVerhoeff) {
                this.commonUtilClass.getaadharref(getContext(), this.stateCode, this.token, this.binding.aadharEd.getText().toString(), SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "ChecklistForm6", new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda62
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onTextChanged$42(i, str, str2);
                    }
                });
            } else {
                this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), this.invalidAadhaar, "Please Enter Correct Aadhar Number.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTextChanged$42(int i, String str, String str2) {
        if (i != 200) {
            if (i == 401) {
                refreshTokenApi();
            }
        } else if (str.equals("N") || str.equals("n")) {
            this.commonUtilClass.displayAlertWithTitleAndMessage(requireContext(), this.invalidAadhaar, str2);
        } else {
            this.aadharref = str2;
            Log.d(TAG, "aadharref " + this.aadharref);
        }
    }

    public void faceRecognition(String statecode, String captureFileName) {
        RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        restClient.faceRecognitionApi(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.26
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 401) {
                    Form6CheckListFragment.this.refreshTokenApi();
                    return;
                }
                if (response.code() != 200) {
                    try {
                        Form6CheckListFragment.this.personalPhotograph = "";
                        Form6CheckListFragment.this.binding.choosePhotoPersonalDetails.setText("");
                        Form6CheckListFragment.this.binding.passPhotoPersonalDetails.setVisibility(8);
                        Form6CheckListFragment.this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(Form6CheckListFragment.this.color000000));
                        Form6CheckListFragment.this.commonUtilClass.displayAlertWithTitleAndMessage(Form6CheckListFragment.this.requireContext(), "Alert", new JSONObject(response.errorBody().string()).optString("message"));
                    } catch (IOException | JSONException e) {
                        Logger.d("Form6ChecklistFragment", e.toString());
                    }
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.uploadImage(form6CheckListFragment.saveImageFileName);
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Form6CheckListFragment.this.personalPhotograph = "";
                Form6CheckListFragment.this.binding.choosePhotoPersonalDetails.setText("");
                Form6CheckListFragment.this.binding.passPhotoPersonalDetails.setVisibility(8);
                Form6CheckListFragment.this.binding.chooseFilePersonalDetailsTv.setTextColor(Color.parseColor(Form6CheckListFragment.this.color000000));
                Logger.d(StringUtils.SPACE, t.getMessage());
                Form6CheckListFragment.this.alertDialog.dismiss();
            }
        });
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (this.binding.firstNameEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.firstnameOfficial.getText().clear();
                    this.binding.firstnameOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.firstnameOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.firstnameOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.surNameEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.surnameOfficial.getText().clear();
                    this.binding.surnameOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.surnameOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.surnameOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.relativeName.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.relativeNameOfficial.getText().clear();
                    this.binding.relativeNameOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.relativeSurname.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.relativeSurnameOfficial.getText().clear();
                    this.binding.relativeSurnameOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.relativeSurnameOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.relativeSurnameOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.relativeNameOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.relativeNameOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.familyMemberName.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.houseNoEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.houseNoEdOfficial.getText().clear();
                    this.binding.houseNoEdOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.houseNoEdOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.houseNoEdOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.streetEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.streetEdOfficial.getText().clear();
                    this.binding.streetEdOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.streetEdOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.streetEdOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.townEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.townEdOfficial.getText().clear();
                    this.binding.townEdOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.townEdOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.townEdOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.postofficeEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.postofficeOfficial.getText().clear();
                    this.binding.postofficeOfficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.postofficeOfficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.postofficeOfficial2.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.tehsilEd.getText().hashCode() == s.hashCode()) {
            if (s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                Log.d(TAG, this.nothingToDo);
                return;
            } else {
                if (s.toString().isEmpty()) {
                    this.binding.tehsilEdofficial.getText().clear();
                    this.binding.tehsilEdofficial2.getText().clear();
                    return;
                }
                return;
            }
        }
        if (this.binding.tehsilEdofficial.getText().hashCode() == s.hashCode()) {
            if (s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                return;
            }
            Log.d(TAG, this.nothingToDo);
            return;
        }
        if (this.binding.tehsilEdofficial2.getText().hashCode() == s.hashCode() && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
            Log.d(TAG, this.nothingToDo);
        }
    }

    private void checkAnnexD() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            if (!TextUtils.isEmpty(this.checkListForm6Model.getDob())) {
                this.tempDOB = simpleDateFormat2.format(simpleDateFormat.parse(this.checkListForm6Model.getDob()));
            }
            if (!TextUtils.isEmpty(this.checkListForm6Model.getCitizenshipTypeCat())) {
                this.cat = this.checkListForm6Model.getCitizenshipTypeCat().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                this.citizenshipTypeCat = this.checkListForm6Model.getCitizenshipTypeCat().replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
            }
            if (isBiharState()) {
                if (!TextUtils.isEmpty(this.citizenshipTypeCat)) {
                    this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
                    getAnnexValue();
                    setSAnnexureDbData();
                    return;
                } else {
                    if (TextUtils.isEmpty(this.citizenshipTypeCat)) {
                        this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.binding.annexureDIncludedLayout.annexureD.setVisibility(8);
            this.binding.annexureDIncludedLayout.isExistingLl.setVisibility(8);
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
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
    }

    private void setSAnnexureDbData() {
        try {
            if (TextUtils.isEmpty(this.cat)) {
                return;
            }
            if (this.cat.equals("CAT-2") || this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) {
                this.binding.annexureDIncludedLayout.formAnnxBornIndia.setChecked(true);
                if (this.cat.equalsIgnoreCase("CAT-2")) {
                    String str = this.ctDocOfSelfUrl;
                    if (str != null) {
                        this.list1ref = str;
                        this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelList1.setVisibility(0);
                        DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList1, "self");
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                    String str2 = this.ctDocOfSelfUrl;
                    if (str2 != null) {
                        this.list1ref = str2;
                        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
                        DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageBefore2004Self, "self");
                        this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelList2.setVisibility(0);
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
                        getList1(this.list4);
                        DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList2, "mother");
                    }
                } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                    String str3 = this.ctDocOfSelfUrl;
                    if (str3 != null) {
                        this.list1ref = str3;
                        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setVisibility(0);
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
                            this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                            DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList3, "father");
                            this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
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
                                this.binding.annexureDIncludedLayout.cancelList3.setVisibility(0);
                                DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList3, "father");
                                this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                                this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
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
                            this.binding.annexureDIncludedLayout.cancelList4.setVisibility(0);
                            DisplayImage(this.ctDocOfMotherUrl, this.binding.annexureDIncludedLayout.imageList4, "mother");
                            this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                            this.binding.annexureDIncludedLayout.cancelList5.setVisibility(0);
                            DisplayImage(this.ctDocOfFatherUrl, this.binding.annexureDIncludedLayout.imageList5, "father");
                        }
                    }
                }
            } else if (this.cat.equalsIgnoreCase("CAT-5")) {
                this.binding.annexureDIncludedLayout.formAnnxNotBorn.setChecked(true);
                if (this.ctDocTypeForSelf != null && !TextUtils.isEmpty(this.ctDocOfSelfUrl)) {
                    this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                    DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList6, "self");
                }
            } else if (this.cat.equalsIgnoreCase("CAT-6")) {
                this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setChecked(true);
                if (!TextUtils.isEmpty(this.ctDocOfSelfUrl)) {
                    this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                    this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                    DisplayImage(this.ctDocOfSelfUrl, this.binding.annexureDIncludedLayout.imageList7, "self");
                }
            }
            if (this.anxDSignUrl != null) {
                this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
                this.binding.annexureDIncludedLayout.tvAnnexDUploadsign.setText("Uploaded signature");
                this.binding.annexureDIncludedLayout.signName.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
                this.binding.annexureDIncludedLayout.signDeleteList1.setVisibility(0);
                this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
                DisplayImage(this.anxDSignUrl, this.binding.annexureDIncludedLayout.imageSign, "annex");
            }
        } catch (Exception e) {
            Log.e("Form6 CheckList", e.toString());
        }
    }

    private void DisplayImage(final String url, final ImageView imageView, final String type) {
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda33
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i, String str) {
                this.f$0.lambda$DisplayImage$43(type, url, imageView, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$DisplayImage$43(String str, String str2, ImageView imageView, int i, String str3) {
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
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.32
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.33
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.34
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAcquired.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.35
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Form6CheckListFragment.this.isUserSelected = true;
                return false;
            }
        });
    }

    private boolean isBiharState() {
        return this.stateCode.equalsIgnoreCase("S04");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openBornInIndiaLayout(String dob) {
        Date date;
        this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
        if (this.List1docName.size() > 0 || this.List1docCode.size() > 0) {
            this.List1docName.clear();
            this.List1docCode.clear();
        }
        this.simple.setLenient(false);
        if (dob != null && !dob.isEmpty()) {
            try {
                this.DoB = this.simple.parse(dob.trim());
            } catch (ParseException e) {
                Logger.d("Form6ChecklistFragment", e.toString());
            }
            Date date2 = this.DoB;
            if (date2 == null || (date = this.dateBefore) == null) {
                return;
            }
            if (date2.before(date)) {
                this.cat = "CAT-2";
                this.list1 = "LIST-1";
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
        this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
        getList1(this.list7);
        this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAcquired.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
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
        ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass36(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass36(final String val$list) {
            this.val$list = val$list;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Form6CheckListFragment.this.alertDialog.dismiss();
                Form6CheckListFragment.this.payloadData1 = (JsonObject) response.body();
                if (Form6CheckListFragment.this.payloadData1 != null) {
                    JsonArray asJsonArray = Form6CheckListFragment.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = Form6CheckListFragment.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1")) {
                            Form6CheckListFragment.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List1docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List1docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List1docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List1docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                        } else if (this.val$list.equalsIgnoreCase("LIST-2")) {
                            Form6CheckListFragment.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List2docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List2docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List2docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                        } else if (this.val$list.equalsIgnoreCase("LIST-3")) {
                            Form6CheckListFragment.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List3docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List3docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List3docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                        } else if (this.val$list.equalsIgnoreCase("LIST-4")) {
                            Form6CheckListFragment.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List4docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List4docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List4docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                        } else if (this.val$list.equalsIgnoreCase("LIST-5")) {
                            Form6CheckListFragment.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List5docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List5docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List5docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                        } else if (this.val$list.equalsIgnoreCase("LIST-6")) {
                            Form6CheckListFragment.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List6docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List6docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List6docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                        } else if (this.val$list.equalsIgnoreCase("LIST-7")) {
                            Form6CheckListFragment.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List7docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List7docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List7docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) Form6CheckListFragment.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Form6CheckListFragment.this.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                        } else if (this.val$list.equalsIgnoreCase("LIST-8")) {
                            Form6CheckListFragment.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Form6CheckListFragment.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Form6CheckListFragment.this.List8docName.contains(Form6CheckListFragment.this.selectDocumentType)) {
                                Form6CheckListFragment.this.List8docName.add(0, Form6CheckListFragment.this.selectDocumentType);
                                Form6CheckListFragment.this.List8docCode.add(0, null);
                            }
                        }
                    }
                    if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-2") || Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-3") || Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-4")) {
                        if (Form6CheckListFragment.this.ctDocTypeForSelf != null && !Form6CheckListFragment.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                            for (int i2 = 0; i2 < Form6CheckListFragment.this.List1docCode.size(); i2++) {
                                try {
                                    if (Form6CheckListFragment.this.List1docCode.get(i2) != null && Form6CheckListFragment.this.List1docCode.get(i2).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForSelf)) {
                                        Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                                        form6CheckListFragment.list1Code = form6CheckListFragment.ctDocTypeForSelf;
                                        Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                                        form6CheckListFragment2.list1CodeName = form6CheckListFragment2.List1docName.get(i2);
                                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setSelection(i2);
                                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setSelection(i2);
                                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setSelection(i2);
                                    }
                                } catch (Exception e) {
                                    Log.e("errror@spinner", e.toString());
                                }
                            }
                        }
                        if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-3") && Form6CheckListFragment.this.ctDocOfFatherUrl != null && !Form6CheckListFragment.this.ctDocOfFatherUrl.equalsIgnoreCase("") && !TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather)) {
                            for (int i3 = 0; i3 < Form6CheckListFragment.this.List3docCode.size(); i3++) {
                                try {
                                    if (Form6CheckListFragment.this.List3docCode.get(i3) != null && Form6CheckListFragment.this.List3docCode.get(i3).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                        Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                                        form6CheckListFragment3.list3code = form6CheckListFragment3.ctDocTypeForFather;
                                        Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                                        form6CheckListFragment4.list3codeName = form6CheckListFragment4.List3docName.get(i3);
                                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i3);
                                        break;
                                    }
                                } catch (Exception e2) {
                                    Log.e("errror@spinner", e2.toString());
                                }
                            }
                        }
                        if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-3") && Form6CheckListFragment.this.ctDocOfMotherUrl != null && !Form6CheckListFragment.this.ctDocOfMotherUrl.equalsIgnoreCase("")) {
                            for (int i4 = 0; i4 < Form6CheckListFragment.this.List4docCode.size(); i4++) {
                                try {
                                    if (Form6CheckListFragment.this.List4docCode.get(i4) != null && Form6CheckListFragment.this.List4docCode.get(i4).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                        Form6CheckListFragment form6CheckListFragment5 = Form6CheckListFragment.this;
                                        form6CheckListFragment5.list4code = form6CheckListFragment5.ctDocTypeForMother;
                                        Form6CheckListFragment form6CheckListFragment6 = Form6CheckListFragment.this;
                                        form6CheckListFragment6.list4codeName = form6CheckListFragment6.List4docName.get(i4);
                                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i4);
                                        break;
                                    }
                                } catch (Exception e3) {
                                    Log.e("errror@spinner", e3.toString());
                                }
                            }
                        }
                        if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-4") && Form6CheckListFragment.this.isParentsIndian != null && Form6CheckListFragment.this.isParentsIndian.equalsIgnoreCase("Y")) {
                            if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather) && !TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                for (int i5 = 0; i5 < Form6CheckListFragment.this.List3docCode.size(); i5++) {
                                    try {
                                        if (Form6CheckListFragment.this.List3docCode.get(i5) != null && Form6CheckListFragment.this.List3docCode.get(i5).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                            Form6CheckListFragment form6CheckListFragment7 = Form6CheckListFragment.this;
                                            form6CheckListFragment7.list3code = form6CheckListFragment7.ctDocTypeForFather;
                                            Form6CheckListFragment form6CheckListFragment8 = Form6CheckListFragment.this;
                                            form6CheckListFragment8.list3codeName = form6CheckListFragment8.List3docName.get(i5);
                                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i5);
                                            break;
                                        }
                                    } catch (Exception e4) {
                                        Log.e("errror@spinner", e4.toString());
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForMother) && !TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                for (int i6 = 0; i6 < Form6CheckListFragment.this.List4docCode.size(); i6++) {
                                    try {
                                        if (Form6CheckListFragment.this.List4docCode.get(i6) != null && Form6CheckListFragment.this.List4docCode.get(i6).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                            Form6CheckListFragment form6CheckListFragment9 = Form6CheckListFragment.this;
                                            form6CheckListFragment9.list4code = form6CheckListFragment9.ctDocTypeForMother;
                                            Form6CheckListFragment form6CheckListFragment10 = Form6CheckListFragment.this;
                                            form6CheckListFragment10.list4codeName = form6CheckListFragment10.List4docName.get(i6);
                                            Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i6);
                                            break;
                                        }
                                    } catch (Exception e5) {
                                        Log.e("errror@spinner", e5.toString());
                                    }
                                }
                            }
                        } else if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-4") && Form6CheckListFragment.this.isParentsIndian != null && Form6CheckListFragment.this.isParentsIndian.equalsIgnoreCase("N")) {
                            if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather) && Form6CheckListFragment.this.ctDocTypeForFather.contains("L5")) {
                                if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                    for (int i7 = 0; i7 < Form6CheckListFragment.this.List5docCode.size(); i7++) {
                                        try {
                                            if (Form6CheckListFragment.this.List5docCode.get(i7) != null && Form6CheckListFragment.this.List5docCode.get(i7).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                                Form6CheckListFragment form6CheckListFragment11 = Form6CheckListFragment.this;
                                                form6CheckListFragment11.list5code = form6CheckListFragment11.ctDocTypeForFather;
                                                Form6CheckListFragment form6CheckListFragment12 = Form6CheckListFragment.this;
                                                form6CheckListFragment12.list5codeName = form6CheckListFragment12.List5docName.get(i7);
                                                Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i7);
                                                break;
                                            }
                                        } catch (Exception e6) {
                                            Log.e("errror@spinner", e6.toString());
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                    for (int i8 = 0; i8 < Form6CheckListFragment.this.List4docCode.size(); i8++) {
                                        try {
                                            if (Form6CheckListFragment.this.List4docCode.get(i8) != null && Form6CheckListFragment.this.List4docCode.get(i8).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                                Form6CheckListFragment form6CheckListFragment13 = Form6CheckListFragment.this;
                                                form6CheckListFragment13.list4code = form6CheckListFragment13.ctDocTypeForMother;
                                                Form6CheckListFragment form6CheckListFragment14 = Form6CheckListFragment.this;
                                                form6CheckListFragment14.list4codeName = form6CheckListFragment14.List4docName.get(i8);
                                                Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i8);
                                                break;
                                            }
                                        } catch (Exception e7) {
                                            Log.e("errror@spinner", e7.toString());
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForMother) && Form6CheckListFragment.this.ctDocTypeForMother.contains("L5")) {
                                if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                    for (int i9 = 0; i9 < Form6CheckListFragment.this.List3docCode.size(); i9++) {
                                        try {
                                            if (Form6CheckListFragment.this.List3docCode.get(i9) != null && Form6CheckListFragment.this.List3docCode.get(i9).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForFather)) {
                                                Form6CheckListFragment form6CheckListFragment15 = Form6CheckListFragment.this;
                                                form6CheckListFragment15.list3code = form6CheckListFragment15.ctDocTypeForFather;
                                                Form6CheckListFragment form6CheckListFragment16 = Form6CheckListFragment.this;
                                                form6CheckListFragment16.list3codeName = form6CheckListFragment16.List3docName.get(i9);
                                                Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i9);
                                                break;
                                            }
                                        } catch (Exception e8) {
                                            Log.e("errror@spinner", e8.toString());
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                    for (int i10 = 0; i10 < Form6CheckListFragment.this.List5docCode.size(); i10++) {
                                        try {
                                            if (Form6CheckListFragment.this.List5docCode.get(i10) != null && Form6CheckListFragment.this.List5docCode.get(i10).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForMother)) {
                                                Form6CheckListFragment form6CheckListFragment17 = Form6CheckListFragment.this;
                                                form6CheckListFragment17.list5code = form6CheckListFragment17.ctDocTypeForMother;
                                                Form6CheckListFragment form6CheckListFragment18 = Form6CheckListFragment.this;
                                                form6CheckListFragment18.list5codeName = form6CheckListFragment18.List5docName.get(i10);
                                                Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i10);
                                                break;
                                            }
                                        } catch (Exception e9) {
                                            Log.e("errror@spinner", e9.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-5") && Form6CheckListFragment.this.ctDocTypeForSelf != null && !Form6CheckListFragment.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                        for (int i11 = 0; i11 < Form6CheckListFragment.this.List6docCode.size(); i11++) {
                            try {
                                if (Form6CheckListFragment.this.List6docCode.get(i11) != null && Form6CheckListFragment.this.List6docCode.get(i11).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForSelf)) {
                                    Form6CheckListFragment form6CheckListFragment19 = Form6CheckListFragment.this;
                                    form6CheckListFragment19.list6code = form6CheckListFragment19.ctDocTypeForSelf;
                                    Form6CheckListFragment form6CheckListFragment20 = Form6CheckListFragment.this;
                                    form6CheckListFragment20.list6codeName = form6CheckListFragment20.List6docName.get(i11);
                                    Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setSelection(i11);
                                }
                            } catch (Exception e10) {
                                Log.e("errror@spinner", e10.toString());
                            }
                        }
                    }
                    if (!Form6CheckListFragment.this.cat.equalsIgnoreCase("CAT-6") || Form6CheckListFragment.this.ctDocTypeForSelf == null || Form6CheckListFragment.this.ctDocTypeForSelf.equalsIgnoreCase("")) {
                        return;
                    }
                    for (int i12 = 0; i12 < Form6CheckListFragment.this.List7docCode.size(); i12++) {
                        try {
                            if (Form6CheckListFragment.this.List7docCode.get(i12) != null && Form6CheckListFragment.this.List7docCode.get(i12).equalsIgnoreCase(Form6CheckListFragment.this.ctDocTypeForSelf)) {
                                Form6CheckListFragment form6CheckListFragment21 = Form6CheckListFragment.this;
                                form6CheckListFragment21.list7code = form6CheckListFragment21.ctDocTypeForSelf;
                                Form6CheckListFragment form6CheckListFragment22 = Form6CheckListFragment.this;
                                form6CheckListFragment22.list7codeName = form6CheckListFragment22.List7docName.get(i12);
                                Form6CheckListFragment.this.binding.annexureDIncludedLayout.spinnerAcquired.setSelection(i12);
                            }
                        } catch (Exception e11) {
                            Log.e("errror@spinner", e11.toString());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = Form6CheckListFragment.this.commomUtility;
                    FragmentActivity activity = Form6CheckListFragment.this.getActivity();
                    String str = Form6CheckListFragment.this.refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(activity, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$36$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i13, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i13, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e12) {
                    Logger.e(Form6CheckListFragment.TAG, e12.toString());
                    return;
                }
            }
            try {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Logger.e(Form6CheckListFragment.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e13) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Logger.e(Form6CheckListFragment.TAG, e13.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            if (Form6CheckListFragment.this.alertDialog != null) {
                Form6CheckListFragment.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                Form6CheckListFragment.this.commomUtility.showMessageOK(Form6CheckListFragment.this.getActivity(), Form6CheckListFragment.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$36$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Form6CheckListFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(Form6CheckListFragment.this.getActivity()).setRefreshToken(str3);
            SharedPref.getInstance(Form6CheckListFragment.this.getActivity()).setToken("Bearer " + str2);
            Form6CheckListFragment.this.getList1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Form6CheckListFragment.this.getActivity()).setIsLoggedIn(false);
            SharedPref.getInstance(Form6CheckListFragment.this.getActivity()).setLocaleBool(false);
            Form6CheckListFragment.this.startActivity(new Intent((Context) Form6CheckListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Form6CheckListFragment.TAG, "OnFailure" + t.getMessage());
        }
    }

    private boolean validateAnnexure() {
        if (TextUtils.isEmpty(this.choice)) {
            showdialog("Alert", "Please select atleast one category");
            return false;
        }
        if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
            if (this.cat.equalsIgnoreCase("CAT-2")) {
                if (this.binding.annexureDIncludedLayout.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("Alert", "Please select document for self.");
                    return false;
                }
            } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                if (this.binding.annexureDIncludedLayout.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("Alert", "Please select document for self.");
                    return false;
                }
                if (this.flagcat3scenerio1.equalsIgnoreCase("") || this.flagcat3scenerio2.equalsIgnoreCase("")) {
                    showdialog("Alert", "Please select atleast one parent");
                    return false;
                }
                if (this.binding.annexureDIncludedLayout.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list3Ref == null && this.list4Ref == null) {
                    showdialog("Alert", "Please select document for Father or Mother.");
                    return false;
                }
            } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                if (this.binding.annexureDIncludedLayout.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
                    showdialog("Alert", this.selectDocumentType);
                    return false;
                }
                if (this.list1ref == null) {
                    showdialog("Alert", "Please select document for self.");
                    return false;
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("")) {
                    showdialog("Alert", "Please select atleast one parent.");
                    return false;
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list3Ref == null) {
                        showdialog("Alert", "Please select document for Father.");
                        return false;
                    }
                    if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                        showdialog("Alert", this.selectDocumentType);
                        return false;
                    }
                    if (this.list4Ref == null) {
                        showdialog("Alert", "Please select document for Mother.");
                        return false;
                    }
                }
                if (this.flagcat4scenerio1.equalsIgnoreCase("N")) {
                    if (this.flagcat4scenerio2.equalsIgnoreCase("") || this.flagcat4scenerio3.equalsIgnoreCase("")) {
                        showdialog("Alert", "Please select atleast one parent nationality.");
                        return false;
                    }
                    if (this.flagcat4scenerio2.equalsIgnoreCase("Y")) {
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list3Ref == null) {
                            showdialog("Alert", "Please select document for Father.");
                            return false;
                        }
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list5Ref == null) {
                            showdialog("Alert", "Please select document for Mother.");
                            return false;
                        }
                    }
                    if (this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list4Ref == null) {
                            showdialog("Alert", "Please select document for Mother.");
                            return false;
                        }
                        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
                            showdialog("Alert", this.selectDocumentType);
                            return false;
                        }
                        if (this.list5Ref == null) {
                            showdialog("Alert", "Please select document for Father.");
                            return false;
                        }
                    }
                }
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
            if (this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
                showdialog("Alert", this.selectDocumentType);
                return false;
            }
            if (this.list6ref == null) {
                showdialog("Alert", "Please select document for self.");
                return false;
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
            if (this.binding.annexureDIncludedLayout.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
                showdialog("Alert", this.selectDocumentType);
                return false;
            }
            if (this.list7ref == null) {
                showdialog("Alert", "Please select document for self.");
                return false;
            }
        }
        if (this.anxDSignUrl != null) {
            return true;
        }
        showdialog("Alert", "Please upload signature.");
        return false;
    }

    private void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$44(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$44(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String ALERT2, String message) {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(getActivity()).setTitle(ALERT2).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda72
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$45(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$45(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void showdialog1(String success, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$46(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$46(DialogInterface dialogInterface, int i) {
        try {
            FileUtils.deleteDirectory(new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/"));
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void showdialog2(String success, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda31
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$47(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$47(DialogInterface dialogInterface, int i) {
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda75
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$48(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pickFile$48(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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
            return;
        }
        if (code == 114) {
            this.activityResultLauncher13.launch(intentCreateChooser);
        } else if (code == 115) {
            this.activityResultLauncher14.launch(intentCreateChooser);
        } else if (code == 116) {
            this.activityResultLauncher15.launch(intentCreateChooser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0785 A[Catch: Exception -> 0x0d44, TRY_LEAVE, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:103:0x07b9 A[Catch: Exception -> 0x0d44, TRY_ENTER, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0836  */
    /* JADX WARN: Code duplicated, block: B:106:0x083a A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:109:0x08bb A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0938 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x093a A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x09b7  */
    /* JADX WARN: Code duplicated, block: B:114:0x09bb A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:117:0x0a3c A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0ab9  */
    /* JADX WARN: Code duplicated, block: B:120:0x0abd A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0b3a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0b3e A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0bbb  */
    /* JADX WARN: Code duplicated, block: B:126:0x0bbf A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0c23  */
    /* JADX WARN: Code duplicated, block: B:129:0x0c27 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0ca4  */
    /* JADX WARN: Code duplicated, block: B:132:0x0ca8 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0d35 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[Catch: Exception -> 0x0d46, TRY_LEAVE, TryCatch #2 {Exception -> 0x0d46, blocks: (B:30:0x005c, B:32:0x007d), top: B:146:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:35:0x009f A[Catch: Exception -> 0x0d44, TRY_ENTER, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0145  */
    /* JADX WARN: Code duplicated, block: B:40:0x0149 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0245  */
    /* JADX WARN: Code duplicated, block: B:46:0x0249 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:47:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:49:0x02c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0345  */
    /* JADX WARN: Code duplicated, block: B:52:0x0349 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:55:0x03c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0445  */
    /* JADX WARN: Code duplicated, block: B:58:0x0449 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:61:0x04c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0545  */
    /* JADX WARN: Code duplicated, block: B:64:0x0549 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:65:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x05c9 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0636  */
    /* JADX WARN: Code duplicated, block: B:70:0x063a A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:71:0x06c7 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x06f3 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:76:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:78:0x0702 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:79:0x070d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0711 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:82:0x071b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x071d A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0727 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0729 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0733 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0735 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x073f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0741 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:90:0x074b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x074d A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0757 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0759 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0763 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0765 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:96:0x076f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0771 A[Catch: Exception -> 0x0d44, TryCatch #5 {Exception -> 0x0d44, blocks: (B:35:0x009f, B:37:0x00c9, B:133:0x0d31, B:40:0x0149, B:43:0x01c9, B:46:0x0249, B:49:0x02c9, B:52:0x0349, B:55:0x03c9, B:58:0x0449, B:61:0x04c9, B:64:0x0549, B:67:0x05c9, B:70:0x063a, B:71:0x06c7, B:75:0x06f3, B:98:0x077a, B:78:0x0702, B:81:0x0711, B:83:0x071d, B:85:0x0729, B:87:0x0735, B:89:0x0741, B:91:0x074d, B:93:0x0759, B:95:0x0765, B:97:0x0771, B:100:0x0785, B:103:0x07b9, B:106:0x083a, B:109:0x08bb, B:111:0x093a, B:114:0x09bb, B:117:0x0a3c, B:120:0x0abd, B:123:0x0b3e, B:126:0x0bbf, B:129:0x0c27, B:132:0x0ca8, B:134:0x0d35, B:135:0x0d43), top: B:152:0x007b }] */
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
                                    } else if (requestcode == 116) {
                                        this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(0);
                                        this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(0);
                                        this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(0);
                                        this.binding.declarationSirIncludedLayout.decFormSignSize.setVisibility(0);
                                        this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                                        this.binding.declarationSirIncludedLayout.decFormImageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(false);
                                        this.binding.declarationSirIncludedLayout.decFormSignName.setText(strArrSplit[strArrSplit.length - 1]);
                                        this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit[strArrSplit.length - 1]);
                                        this.declarationSignPhotograph = strArrSplit[strArrSplit.length - 1];
                                        Logger.d("Declaration signature code 116 pdf", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
                                        this.binding.declarationSirIncludedLayout.decFormSignSize.setText(this.filesize + "KB");
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
                                        showdialog("Alert", this.pdf3);
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
                                            this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit[strArrSplit.length - 1]);
                                            Logger.d("Declaration signature code 116 3", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
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
                            } else if (requestcode == 116) {
                                this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(0);
                                this.binding.declarationSirIncludedLayout.decFormSignDeleteList1.setVisibility(0);
                                this.binding.declarationSirIncludedLayout.decFormSignName.setVisibility(0);
                                this.binding.declarationSirIncludedLayout.decFormSignSize.setVisibility(0);
                                this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(0);
                                this.binding.declarationSirIncludedLayout.decFormImageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
                                this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(false);
                                this.binding.declarationSirIncludedLayout.decFormSignName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit[strArrSplit.length - 1]);
                                this.declarationSignPhotograph = strArrSplit[strArrSplit.length - 1];
                                Logger.d("Declaration signature code 116 pdf", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
                                this.binding.declarationSirIncludedLayout.decFormSignSize.setText(this.filesize + "KB");
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
                                showdialog("Alert", this.pdf3);
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
                                    this.checkListForm6Model.setDecsirf6DeclSignature(strArrSplit[strArrSplit.length - 1]);
                                    Logger.d("Declaration signature code 116 3", this.checkListForm6Model.getDecsirf6DeclSignature().toString());
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
        restClient.uploadImageWithData1(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", partCreateFormData, RequestBody.create(this.applicationpdf, MediaType.parse("fileType")), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass37(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$37, reason: invalid class name */
    class AnonymousClass37 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass37(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = Form6CheckListFragment.this.commonUtilClass;
                Context contextRequireContext = Form6CheckListFragment.this.requireContext();
                String str = Form6CheckListFragment.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$37$$ExternalSyntheticLambda0
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
                handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$37$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2(str9, strValueOf);
                    }
                }, 2000L);
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before1987Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(true);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.before1987count = 0;
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.showDialog1("Alert", form6CheckListFragment.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before2004Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(true);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.before1987count = 0;
                Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                form6CheckListFragment2.showDialog1("Alert", form6CheckListFragment2.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list2Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(true);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.list2count = 0;
                Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                form6CheckListFragment3.showDialog1("Alert", form6CheckListFragment3.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.after2004Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(true);
                Form6CheckListFragment.this.after2004count = 0;
                Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                form6CheckListFragment4.showDialog1("Alert", form6CheckListFragment4.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list3Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewList3.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(true);
                Form6CheckListFragment.this.list3count = 0;
                Form6CheckListFragment form6CheckListFragment5 = Form6CheckListFragment.this;
                form6CheckListFragment5.showDialog1("Alert", form6CheckListFragment5.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list4Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewList4.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(true);
                Form6CheckListFragment.this.list4coumt = 0;
                Form6CheckListFragment form6CheckListFragment6 = Form6CheckListFragment.this;
                form6CheckListFragment6.showDialog1("Alert", form6CheckListFragment6.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list5Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewList5.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(true);
                Form6CheckListFragment.this.list5count = 0;
                Form6CheckListFragment form6CheckListFragment7 = Form6CheckListFragment.this;
                form6CheckListFragment7.showDialog1("Alert", form6CheckListFragment7.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list6Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewList6.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(true);
                Form6CheckListFragment.this.list6count = 0;
                Form6CheckListFragment form6CheckListFragment8 = Form6CheckListFragment.this;
                form6CheckListFragment8.showDialog1("Alert", form6CheckListFragment8.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list7Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewList7.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(true);
                Form6CheckListFragment.this.list7count = 0;
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAcquired.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment form6CheckListFragment9 = Form6CheckListFragment.this;
                form6CheckListFragment9.showDialog1("Alert", form6CheckListFragment9.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.anxDSign)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageSign.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(true);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileSign.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment form6CheckListFragment10 = Form6CheckListFragment.this;
                form6CheckListFragment10.showDialog1("Alert", form6CheckListFragment10.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.DeclarationDetails)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormViewLayoutSign.setVisibility(8);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setVisibility(8);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setEnabled(true);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setTextColor(Color.parseColor(Form6CheckListFragment.this.whitecolor));
                Form6CheckListFragment form6CheckListFragment11 = Form6CheckListFragment.this;
                form6CheckListFragment11.showDialog1("Alert", form6CheckListFragment11.fileNotFoundMessage);
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                Form6CheckListFragment.this.commonUtilClass.showMessageOK(Form6CheckListFragment.this.getContext(), Form6CheckListFragment.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$37$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Form6CheckListFragment.this.token = "Bearer " + str8;
            Form6CheckListFragment.this.refreshToken = str9;
            SharedPref.getInstance(Form6CheckListFragment.this.requireContext()).setRefreshToken(str9);
            SharedPref.getInstance(Form6CheckListFragment.this.requireContext()).setToken("Bearer " + str8);
            Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
            form6CheckListFragment.uploadPhoto(str, str2, str3, str4, str5, form6CheckListFragment.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Form6CheckListFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Form6CheckListFragment.this.requireContext()).setLocaleBool(false);
            Form6CheckListFragment.this.startActivity(new Intent((Context) Form6CheckListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2) {
            if (str.equals(Form6CheckListFragment.this.before1987Str)) {
                Form6CheckListFragment.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List1ref1987", Form6CheckListFragment.this.list1ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.before2004Str)) {
                Form6CheckListFragment.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List1ref2004", Form6CheckListFragment.this.list1ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list2Str)) {
                Form6CheckListFragment.this.list2Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("list2ref", Form6CheckListFragment.this.list2Ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.after2004Str)) {
                Form6CheckListFragment.this.list1ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List1refafter2004", Form6CheckListFragment.this.list1ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list3Str)) {
                Form6CheckListFragment.this.list3Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("list3Ref", Form6CheckListFragment.this.list3Ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list4Str)) {
                Form6CheckListFragment.this.list4Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("list4Ref", Form6CheckListFragment.this.list4Ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list5Str)) {
                Form6CheckListFragment.this.list5Ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List5ref", Form6CheckListFragment.this.list5Ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list6Str)) {
                Form6CheckListFragment.this.list6ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("List6ref", Form6CheckListFragment.this.list6ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.list7Str)) {
                Form6CheckListFragment.this.list7ref = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("list7ref", Form6CheckListFragment.this.list7ref);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.IRStr2)) {
                Form6CheckListFragment.this.IRRef2 = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("IRRef2", Form6CheckListFragment.this.IRRef2);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.anxDSign)) {
                Form6CheckListFragment.this.anxDSignUrl = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("anxDSignUrl", Form6CheckListFragment.this.anxDSignUrl);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals(Form6CheckListFragment.this.DeclarationDetails)) {
                Form6CheckListFragment.this.declarationSignPhotograph = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Form6CheckListFragment.this.checkListForm6Model.setDecsirf6DeclSignature(Form6CheckListFragment.this.declarationSignPhotograph);
                Logger.d("decFormSignUrl", Form6CheckListFragment.this.declarationSignPhotograph);
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before1987Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.before1987count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list1ref)) {
                    Form6CheckListFragment.this.before1987count++;
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.showdialogref("Alert", form6CheckListFragment.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList1.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(true);
                Form6CheckListFragment.this.before1987count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before2004Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.before2004count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list1ref)) {
                    Form6CheckListFragment.this.before2004count++;
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.showdialogref("Alert", form6CheckListFragment2.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(true);
                Form6CheckListFragment.this.before1987count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list2Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list2count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list2Ref)) {
                    Form6CheckListFragment.this.list2count++;
                    Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                    form6CheckListFragment3.showdialogref("Alert", form6CheckListFragment3.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList2.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(true);
                Form6CheckListFragment.this.list2count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.after2004Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.after2004count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list1ref)) {
                    Form6CheckListFragment.this.after2004count++;
                    Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                    form6CheckListFragment4.showdialogref("Alert", form6CheckListFragment4.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(true);
                Form6CheckListFragment.this.after2004count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list3Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list3count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list3Ref)) {
                    Form6CheckListFragment.this.list3count++;
                    Form6CheckListFragment form6CheckListFragment5 = Form6CheckListFragment.this;
                    form6CheckListFragment5.showdialogref("Alert", form6CheckListFragment5.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList3.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(true);
                Form6CheckListFragment.this.list3count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list4Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list4coumt < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list4Ref)) {
                    Form6CheckListFragment.this.list4coumt++;
                    Form6CheckListFragment form6CheckListFragment6 = Form6CheckListFragment.this;
                    form6CheckListFragment6.showdialogref("Alert", form6CheckListFragment6.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList4.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(true);
                Form6CheckListFragment.this.list4coumt = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list5Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list5count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list5Ref)) {
                    Form6CheckListFragment.this.list5count++;
                    Form6CheckListFragment form6CheckListFragment7 = Form6CheckListFragment.this;
                    form6CheckListFragment7.showdialogref("Alert", form6CheckListFragment7.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList5.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(true);
                Form6CheckListFragment.this.list5count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list6Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list6count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list6ref)) {
                    Form6CheckListFragment.this.list6count++;
                    Form6CheckListFragment form6CheckListFragment8 = Form6CheckListFragment.this;
                    form6CheckListFragment8.showdialogref("Alert", form6CheckListFragment8.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList6.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setEnabled(true);
                Form6CheckListFragment.this.list6count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list7Str)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list7count < 1 && TextUtils.isEmpty(Form6CheckListFragment.this.list7ref)) {
                    Form6CheckListFragment.this.list7count++;
                    Form6CheckListFragment form6CheckListFragment9 = Form6CheckListFragment.this;
                    form6CheckListFragment9.showdialogref("Alert", form6CheckListFragment9.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                    return;
                }
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.imageList7.setVisibility(8);
                Form6CheckListFragment.this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(true);
                Form6CheckListFragment.this.list7count = 0;
                Form6CheckListFragment.this.showDialog1("Alert", "filenotuploaded");
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before1987Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.before1987count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list1ref2)) {
                    return;
                }
                Form6CheckListFragment.this.before1987count2++;
                Form6CheckListFragment form6CheckListFragment10 = Form6CheckListFragment.this;
                form6CheckListFragment10.showdialogref("Alert", form6CheckListFragment10.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.before2004Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.before2004count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list1ref2)) {
                    return;
                }
                Form6CheckListFragment.this.before2004count2++;
                Form6CheckListFragment form6CheckListFragment11 = Form6CheckListFragment.this;
                form6CheckListFragment11.showdialogref("Alert", form6CheckListFragment11.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list2Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list2count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list2Ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list2count2++;
                Form6CheckListFragment form6CheckListFragment12 = Form6CheckListFragment.this;
                form6CheckListFragment12.showdialogref("Alert", form6CheckListFragment12.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.after2004Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.after2004count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list1ref2)) {
                    return;
                }
                Form6CheckListFragment.this.after2004count2++;
                Form6CheckListFragment form6CheckListFragment13 = Form6CheckListFragment.this;
                form6CheckListFragment13.showdialogref("Alert", form6CheckListFragment13.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list3Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list3count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list3Ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list3count2++;
                Form6CheckListFragment form6CheckListFragment14 = Form6CheckListFragment.this;
                form6CheckListFragment14.showdialogref("Alert", form6CheckListFragment14.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list4Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list4coumt2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list4Ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list4coumt2++;
                Form6CheckListFragment form6CheckListFragment15 = Form6CheckListFragment.this;
                form6CheckListFragment15.showdialogref("Alert", form6CheckListFragment15.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list5Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list5count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list5Ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list5count2++;
                Form6CheckListFragment form6CheckListFragment16 = Form6CheckListFragment.this;
                form6CheckListFragment16.showdialogref("Alert", form6CheckListFragment16.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list5Str3)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list6Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list6count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list6ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list6count2++;
                Form6CheckListFragment form6CheckListFragment17 = Form6CheckListFragment.this;
                form6CheckListFragment17.showdialogref("Alert", form6CheckListFragment17.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
                return;
            }
            if (this.val$uploadtype.equals(Form6CheckListFragment.this.list7Str2)) {
                if (Form6CheckListFragment.this.alertDialog != null) {
                    Form6CheckListFragment.this.alertDialog.dismiss();
                }
                if (Form6CheckListFragment.this.list7count2 >= 1 || !TextUtils.isEmpty(Form6CheckListFragment.this.list7ref2)) {
                    return;
                }
                Form6CheckListFragment.this.list7count2++;
                Form6CheckListFragment form6CheckListFragment18 = Form6CheckListFragment.this;
                form6CheckListFragment18.showdialogref("Alert", form6CheckListFragment18.upload, this.val$uploadtype, this.val$filepath, this.val$captureFileName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("Retry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda25
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$49(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$49(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        dialogInterface.dismiss();
        uploadPhoto(this.stateCode, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    private void initializeAnnxureData() {
        try {
            this.dateBefore = this.simple.parse("01/07/1987");
            this.dateAfter = this.simple.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d("H2HDetails", e.toString());
        }
        initializeSpinnerTouch();
        this.binding.annexureDIncludedLayout.radioGroupAnnexure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.50
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (Form6CheckListFragment.this.binding.annexureDIncludedLayout.formAnnxBornIndia.isChecked()) {
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.choice = form6CheckListFragment.binding.annexureDIncludedLayout.formAnnxBornIndia.getText().toString();
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.openBornInIndiaLayout(form6CheckListFragment2.tempDOB);
                    return;
                }
                if (Form6CheckListFragment.this.binding.annexureDIncludedLayout.formAnnxNotBorn.isChecked()) {
                    Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                    form6CheckListFragment3.choice = form6CheckListFragment3.binding.annexureDIncludedLayout.formAnnxNotBorn.getText().toString();
                    Form6CheckListFragment.this.openLayoutForNotBornInIndia();
                } else if (Form6CheckListFragment.this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.isChecked()) {
                    Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                    form6CheckListFragment4.choice = form6CheckListFragment4.binding.annexureDIncludedLayout.formAnnxIndiaCitize.getText().toString();
                    Form6CheckListFragment.this.openLayoutForIndiaCitizen();
                }
            }
        });
        this.binding.annexureDIncludedLayout.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$50(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentNoRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$51(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$52(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$53(view);
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.51
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List1docName.size()) {
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(112);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list1Code = form6CheckListFragment.List1docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list1CodeName = form6CheckListFragment2.List1docName.get(i);
                    Logger.d("list1Code", Form6CheckListFragment.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.52
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List1docName.size()) {
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(113);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list1Code = form6CheckListFragment.List1docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list1CodeName = form6CheckListFragment2.List1docName.get(i);
                    Logger.d("list1Code", Form6CheckListFragment.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.53
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List1docName.size()) {
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list1Code = form6CheckListFragment.List1docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list1CodeName = form6CheckListFragment2.List1docName.get(i);
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(105);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    Logger.d("list1Code", Form6CheckListFragment.this.list1Code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.54
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                if (Form6CheckListFragment.this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    }
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list3code = form6CheckListFragment.List3docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list3codeName = form6CheckListFragment2.List3docName.get(i);
                    Logger.d("list3code", Form6CheckListFragment.this.list3code);
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(114);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    return;
                }
                if (Form6CheckListFragment.this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                    Form6CheckListFragment.this.deletePhoto(111);
                    Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                    form6CheckListFragment3.list4code = form6CheckListFragment3.List4docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment4 = Form6CheckListFragment.this;
                    form6CheckListFragment4.list4codeName = form6CheckListFragment4.List4docName.get(i);
                    Logger.d("list4code", Form6CheckListFragment.this.list4code);
                    if (i == 1) {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFather1OldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.55
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.list3code = form6CheckListFragment.List3docCode.get(i);
                Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                form6CheckListFragment2.list3codeName = form6CheckListFragment2.List3docName.get(i);
                if (Form6CheckListFragment.this.isUserSelected) {
                    Form6CheckListFragment.this.deletePhoto(106);
                }
                Form6CheckListFragment.this.isUserSelected = false;
                if (Form6CheckListFragment.this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                        return;
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                        return;
                    }
                }
                if (Form6CheckListFragment.this.flagcat4scenerio1.equalsIgnoreCase("N") && Form6CheckListFragment.this.binding.annexureDIncludedLayout.parentFatherRb.isChecked()) {
                    if (i == 1) {
                        Form6CheckListFragment.this.flagYes = "Y";
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.56
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                form6CheckListFragment.list4code = form6CheckListFragment.List4docCode.get(i);
                Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                form6CheckListFragment2.list4codeName = form6CheckListFragment2.List4docName.get(i);
                if (Form6CheckListFragment.this.isUserSelected) {
                    Form6CheckListFragment.this.deletePhoto(107);
                }
                Form6CheckListFragment.this.isUserSelected = false;
                if (Form6CheckListFragment.this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                        return;
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                        return;
                    }
                }
                if (Form6CheckListFragment.this.flagcat4scenerio1.equalsIgnoreCase("N") && Form6CheckListFragment.this.flagcat4scenerio3.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        Form6CheckListFragment.this.flagYes = "Y";
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                    } else {
                        Form6CheckListFragment.this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.57
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List5docName.size()) {
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list5code = form6CheckListFragment.List5docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list5codeName = form6CheckListFragment2.List5docName.get(i);
                    Logger.d("list5code", Form6CheckListFragment.this.list5code);
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(108);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.58
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List6docName.size()) {
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(109);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list6code = form6CheckListFragment.List6docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list6codeName = form6CheckListFragment2.List6docName.get(i);
                    Logger.d("list6code", Form6CheckListFragment.this.list6code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.spinnerAcquired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.59
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < Form6CheckListFragment.this.List7docName.size()) {
                    if (Form6CheckListFragment.this.isUserSelected) {
                        Form6CheckListFragment.this.deletePhoto(110);
                    }
                    Form6CheckListFragment.this.isUserSelected = false;
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.list7code = form6CheckListFragment.List7docCode.get(i);
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    form6CheckListFragment2.list7codeName = form6CheckListFragment2.List7docName.get(i);
                    Logger.d("list7code", Form6CheckListFragment.this.list7code);
                }
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$54(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$55(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$56(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda59
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$57(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$58(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$59(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$60(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileBornOutOfIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$61(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$62(view);
            }
        });
        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$63(view);
            }
        });
        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$64(view);
            }
        });
        this.binding.annexureDIncludedLayout.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$65(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$66(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$67(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$68(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$69(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$70(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$71(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$72(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$73(view);
            }
        });
        this.binding.annexureDIncludedLayout.cancelList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$74(view);
            }
        });
        this.binding.annexureDIncludedLayout.chooseFileSign.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializeAnnxureData$75(view);
            }
        });
        this.binding.annexureDIncludedLayout.signDeleteList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.60
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Form6CheckListFragment.this.deletePhoto(115);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$50(View view) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$51(View view) {
        this.flagcat4scenerio1 = "N";
        this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$52(View view) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$53(View view) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$54(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.after2004count = 0;
            pickFile(105, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$55(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.before1987count = 0;
            pickFile(112, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$56(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.before2004count = 0;
            pickFile(113, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$57(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
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
    public /* synthetic */ void lambda$initializeAnnxureData$58(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.list3count = 0;
            pickFile(106, this.list3code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$59(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.list4coumt = 0;
            pickFile(107, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$60(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.list5count = 0;
            pickFile(108, this.list5code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$61(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.list6count = 0;
            pickFile(109, this.list6code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$62(View view) {
        if (this.binding.annexureDIncludedLayout.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1("Alert", this.selectDocumentType);
        } else {
            this.list7count = 0;
            pickFile(110, this.list7code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$63(View view) {
        this.List3docName.clear();
        this.List3docCode.clear();
        this.flagcat3scenerio1 = "Y";
        this.flagcat3scenerio2 = "N";
        getList1(this.list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$64(View view) {
        this.List4docName.clear();
        this.List4docCode.clear();
        this.flagcat3scenerio2 = "Y";
        this.flagcat3scenerio1 = "N";
        getList1(this.list4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$65(View view) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$66(View view) {
        deletePhoto(112);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$67(View view) {
        deletePhoto(113);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$68(View view) {
        deletePhoto(111);
        deletePhoto(114);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$69(View view) {
        deletePhoto(105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$70(View view) {
        deletePhoto(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$71(View view) {
        deletePhoto(107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$72(View view) {
        deletePhoto(108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$73(View view) {
        deletePhoto(109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$74(View view) {
        deletePhoto(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeAnnxureData$75(View view) {
        pickFile(115, this.anxDSign);
    }

    private void resetAnnexure() {
        this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(8);
        this.choice = "";
        this.binding.annexureDIncludedLayout.radioGroupAnnexure.clearCheck();
        this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
        this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(8);
        deletePhoto(112);
        deletePhoto(113);
        deletePhoto(114);
        deletePhoto(105);
        deletePhoto(106);
        deletePhoto(107);
        deletePhoto(108);
        deletePhoto(109);
        deletePhoto(110);
        deletePhoto(111);
        deletePhoto(115);
        this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.betweenSelectParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.betweenparentRG.clearCheck();
        this.binding.annexureDIncludedLayout.parentRG.clearCheck();
        this.binding.annexureDIncludedLayout.indianparentRG.clearCheck();
        this.binding.annexureDIncludedLayout.father1OldAcNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.fatherOldAcNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.motherOldAcNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.father1OldPartNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.motherOldPartNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.fatherOldPartNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.father1OldPslNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.fatherOldPslNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.motherOldPslNo.setText((CharSequence) null);
        this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
        this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
        this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
        this.flagcat4scenerio1 = "N";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        this.flagcat4scenerio2 = "N";
        this.flagcat4scenerio3 = "N";
        this.flagcat3scenerio2 = "N";
        this.List1docName.clear();
        this.List2docName.clear();
        this.List3docName.clear();
        this.List4docName.clear();
        this.List5docName.clear();
        this.List6docName.clear();
        this.List7docName.clear();
        this.List8docName.clear();
        this.List1docCode.clear();
        this.List2docCode.clear();
        this.List3docCode.clear();
        this.List4docCode.clear();
        this.List5docCode.clear();
        this.List6docCode.clear();
        this.List7docCode.clear();
        this.List8docCode.clear();
        this.before2004count = 0;
        this.after2004count = 0;
        this.before2004count2 = 0;
        this.after2004count2 = 0;
        this.before1987count = 0;
        this.list2count = 0;
        this.list3count = 0;
        this.list4coumt = 0;
        this.list5count = 0;
        this.list6count = 0;
        this.list7count = 0;
        this.before1987count2 = 0;
        this.list2count2 = 0;
        this.list3count2 = 0;
        this.list4coumt2 = 0;
        this.list5count2 = 0;
        this.list6count2 = 0;
        this.list7count2 = 0;
        this.flagYes = "N";
        this.FlagNo = "N";
        this.list3Ref2 = null;
        this.list4Ref2 = null;
        this.list5Ref2 = null;
        this.list6ref2 = null;
        this.list7ref2 = null;
        this.list5ref3 = null;
        this.list2Ref2 = null;
        this.list1ref = null;
        this.list1ref2 = null;
        this.list2Ref = null;
        this.IRRef = null;
        this.IRRef2 = null;
        this.cat = "";
        this.list1 = "LIST-1";
        this.list2 = "LIST-2";
        this.list6 = "LIST-6";
        this.list7 = "LIST-7";
        this.list3 = "LIST-3";
        this.list4 = "LIST-4";
        this.list5 = "LIST-5";
        try {
            this.dateBefore = this.simple.parse("01/07/1987");
            this.dateAfter = this.simple.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d("H2HDetails", e.toString());
        }
        this.flagcat3scenerio1 = "N";
        this.list1Code = "";
        this.list2code = "";
        this.list3code = "";
        this.list4code = "";
        this.list5code = "";
        this.list6code = "";
        this.list7code = "";
        this.list8code = "";
        this.list3Ref = null;
        this.list4Ref = null;
        this.list5Ref = null;
        this.list6ref = null;
        this.list7ref = null;
    }

    public void setDeclarationDetails() {
        if (in.gov.eci.bloapp.utils.Utils.isValideSIRState(this.stateCode) || in.gov.eci.bloapp.utils.Utils.isValide19SIRState(this.stateCode)) {
            setDeclarationUI();
            if (!TextUtils.isEmpty(this.checkListForm6Model.getIsSir03()) && this.checkListForm6Model.getIsSir03().equalsIgnoreCase("Y")) {
                this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
                this.lastCheckedIdchoose = this.binding.declarationSirIncludedLayout.rb2003.getId();
                this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
                FormverificationPayload formverificationPayload = this.formverificationPayload;
                if (formverificationPayload != null) {
                    formverificationPayload.setIs2003Selected("Y");
                }
                validateAgeWithSirAgeCutOff();
                this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.progenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
            } else if (!TextUtils.isEmpty(this.checkListForm6Model.getIsSir2526()) && this.checkListForm6Model.getIsSir2526().equalsIgnoreCase("Y")) {
                this.binding.declarationSirIncludedLayout.rb2025.setChecked(true);
                this.lastCheckedIdchoose = this.binding.declarationSirIncludedLayout.rb2025.getId();
                this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
                FormverificationPayload formverificationPayload2 = this.formverificationPayload;
                if (formverificationPayload2 != null) {
                    formverificationPayload2.setIs2003Selected("N");
                }
                this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
                this.binding.declarationSirIncludedLayout.progenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
                this.binding.declarationSirIncludedLayout.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{"2025/2026"}));
                this.binding.declarationSirIncludedLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
            } else {
                this.binding.declarationSirIncludedLayout.rb2003.setChecked(true);
                this.lastCheckedIdchoose = this.binding.declarationSirIncludedLayout.rb2003.getId();
                this.binding.declarationSirIncludedLayout.radioCardView.setVisibility(0);
                FormverificationPayload formverificationPayload3 = this.formverificationPayload;
                if (formverificationPayload3 != null) {
                    formverificationPayload3.setIs2003Selected("Y");
                }
                validateAgeWithSirAgeCutOff();
                this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.progenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{this.lastSirYear}));
                this.binding.declarationSirIncludedLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
            }
            this.relationNameList = SharedPref.getInstance(requireContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME);
            this.relationCodeList = SharedPref.getInstance(requireContext()).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
            setRelationShipAdapter();
            this.tempCategoty = this.checkListForm6Model.getDecsirf6DeclCategory();
            if (this.checkListForm6Model.getFatherorGuardianEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.fatherEpicNumber.setText(this.checkListForm6Model.getFatherorGuardianEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.fatherEpicNumber.setText("");
            }
            if (this.checkListForm6Model.getFatherorGuardianname() != null) {
                this.binding.declarationSirIncludedLayout.fatherName.setText(this.checkListForm6Model.getFatherorGuardianname());
            } else {
                this.binding.declarationSirIncludedLayout.fatherName.setText("");
            }
            if (this.checkListForm6Model.getMotherEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.motherEpicNumber.setText(this.checkListForm6Model.getMotherEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.motherEpicNumber.setText("");
            }
            if (this.checkListForm6Model.getMotherName() != null) {
                this.binding.declarationSirIncludedLayout.motherName.setText(this.checkListForm6Model.getMotherName());
            } else {
                this.binding.declarationSirIncludedLayout.motherName.setText("");
            }
            if (this.checkListForm6Model.getSpouseEpicNo() != null) {
                this.binding.declarationSirIncludedLayout.spouseEpicNumber.setText(this.checkListForm6Model.getSpouseEpicNo());
            } else {
                this.binding.declarationSirIncludedLayout.spouseEpicNumber.setText("");
            }
            if (this.checkListForm6Model.getSpouseName() != null) {
                this.binding.declarationSirIncludedLayout.spouseName.setText(this.checkListForm6Model.getSpouseName());
            } else {
                this.binding.declarationSirIncludedLayout.spouseName.setText("");
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
                        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
                        this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(0);
                    }
                } else if (this.checkListForm6Model.getDecsirf6DeclCategory().trim().equalsIgnoreCase("Progeny")) {
                    this.binding.declarationSirIncludedLayout.progenyRb.setChecked(true);
                    clearSelfDetailsFromObj();
                    setProgenyData();
                } else if (this.checkListForm6Model.getDecsirf6DeclCategory().trim().equalsIgnoreCase("NA")) {
                    clearSelfDetailsFromObj();
                    clearRelativeDetailsFromObj();
                    this.binding.declarationSirIncludedLayout.neitherRb.setChecked(true);
                    this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
                    this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
                }
                if (this.checkListForm6Model.getDecsirf6DeclSignature() != null) {
                    this.binding.declarationSirIncludedLayout.bloSigncardview.setVisibility(0);
                    getDeclarationFormUploadedSign(this.checkListForm6Model.getDecsirf6DeclSignature());
                    return;
                }
                return;
            }
            this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
        }
    }

    private void setRelationShipAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.blo_spinner_dropdown, this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEpicNumber(String epicEditText, String from) {
        HashMap map = new HashMap();
        map.put("epicNumber", epicEditText);
        CommomUtility commomUtility = new CommomUtility();
        commomUtility.getRetrofitClient(getContext(), this.token, this.atkbnd, this.rtkbnd).getByEpicForForm(this.token, this.atkbnd, this.rtkbnd, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass61(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$61, reason: invalid class name */
    class AnonymousClass61 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass61(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

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
                Logger.d(Form6CheckListFragment.TAG, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                Toast.makeText(Form6CheckListFragment.this.getContext(), "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    Form6CheckListFragment.this.isMotherEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setText(str);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    Form6CheckListFragment.this.isFatherEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherName.setText(str);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakFatherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Spouse")) {
                    Form6CheckListFragment.this.isSpouseEPICValid = true;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseName.setText(str);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseName.setEnabled(false);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakSpouseName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Relative")) {
                    Form6CheckListFragment.this.isRelativeEPICValid = true;
                    return;
                }
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                Context context = Form6CheckListFragment.this.getContext();
                String str2 = Form6CheckListFragment.this.refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str3 = this.val$epicEditText;
                final String str4 = this.val$from;
                commomUtility.getRefreshToken(context, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$61$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str3, str4, i, str5, str6);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherEpicNumber.setText("");
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.motherName.setEnabled(true);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakMotherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherEpicNumber.setText("");
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.fatherName.setEnabled(true);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakFatherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseEpicNumber.setText("");
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.spouseName.setEnabled(true);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.speakSpouseName.setClickable(true);
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(Form6CheckListFragment.this.messageString);
                Logger.d(Form6CheckListFragment.TAG, strOptString);
                Toast.makeText(Form6CheckListFragment.this.getContext(), strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(Form6CheckListFragment.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText(Form6CheckListFragment.this.getContext(), response.message(), 1).show();
                } else {
                    Toast.makeText(Form6CheckListFragment.this.getContext(), Form6CheckListFragment.this.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(Form6CheckListFragment.TAG, "getRefreshTokenText" + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                commomUtility.showMessageOK(Form6CheckListFragment.this.getContext(), Form6CheckListFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$61$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Form6CheckListFragment.this.token = Form6CheckListFragment.this.bearerText + str3;
            Form6CheckListFragment.this.refreshToken = str4;
            SharedPref.getInstance(Form6CheckListFragment.this.getContext()).setRefreshToken(str4);
            SharedPref.getInstance(Form6CheckListFragment.this.getContext()).setToken(Form6CheckListFragment.this.bearerText + str3);
            Form6CheckListFragment.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Form6CheckListFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Form6CheckListFragment.this.getContext()).setLocaleBool(false);
            Form6CheckListFragment.this.startActivity(new Intent(Form6CheckListFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(Form6CheckListFragment.TAG, t.getMessage());
        }
    }

    public void setSpeakText(final EditText editText) {
        this.utils.showVoicePopup(getContext(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.62
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
            public void onCallBack(String result) {
                editText.setText(result);
            }
        });
    }

    private void getDeclarationFormUploadedSign(String fileName) {
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        Logger.d("Token ---> ", this.token);
        userClient.getFile("objectstorage", fileName, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass63());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$63, reason: invalid class name */
    class AnonymousClass63 implements Callback<JsonObject> {
        AnonymousClass63() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    Form6CheckListFragment.this.refreshTokenApi();
                    return;
                }
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setVisibility(0);
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    Log.d(Form6CheckListFragment.TAG, "Error From Api" + response.errorBody());
                    String strOptString = jSONObject.optString("message");
                    Log.d(Form6CheckListFragment.TAG, "imageError" + strOptString);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$63$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    Form6CheckListFragment.this.commomUtility.displayAlertWithTitleAndMessage(Form6CheckListFragment.this.requireContext(), "Form 6 Declaration Document Download Api Error - " + response.code(), strOptString);
                    return;
                } catch (IOException | JSONException e) {
                    Logger.d(Form6CheckListFragment.TAG, Form6CheckListFragment.this.exception + e.getMessage());
                    return;
                }
            }
            String strReplace = String.valueOf(((JsonObject) response.body()).get("file")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            if (Form6CheckListFragment.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains("jpg") || Form6CheckListFragment.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(Form6CheckListFragment.this.jpeg) || Form6CheckListFragment.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains("png") || Form6CheckListFragment.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains("jfif")) {
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setImageBitmap(BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(strReplace, 0))));
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setVisibility(8);
            } else if (Form6CheckListFragment.this.checkListForm6Model.getDecsirf6DeclSignature().toLowerCase().contains(".pdf")) {
                Form6CheckListFragment.this.encodedDeclarationImage = strReplace;
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormChooseFileSign.setVisibility(8);
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.decFormImageSign.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Form6CheckListFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(Form6CheckListFragment.TAG, "comingInOnFailure" + t.getMessage());
        }
    }

    public void setRelativeType(String relativeType, TextView textView) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            textView.setText("Grand Mother");
        } else if (relativeType.equals("GFTH")) {
            textView.setText("Grand Father");
        } else if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            textView.setText("Mother");
        } else if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            textView.setText("Father");
        } else if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            textView.setText("Husband");
        } else if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            textView.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            textView.setText("");
        } else {
            textView.setText(relativeType);
        }
        this.progencyrelationType = textView.getText().toString();
    }

    public void setProgenyView(int checkedId) {
        clearSelfDetailsFromObj();
        this.lastCheckedId = checkedId;
        this.selfStatus = "D";
        this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
        this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
        if (checkProgenyEmpty()) {
            this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(0);
        } else {
            this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivUpdateProgeny.setVisibility(0);
            this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
            this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
            this.binding.declarationSirIncludedLayout.dfIvAddSelf.setVisibility(8);
            this.binding.declarationSirIncludedLayout.dfTvivUpdate.setVisibility(8);
            this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
        }
        this.submittedForRecommendation = "Y";
    }

    public void setSelfView(int checkedId) {
        this.lastCheckedId = checkedId;
        this.binding.declarationSirIncludedLayout.dfTvivDelete.setVisibility(8);
        this.submittedForRecommendation = "Y";
        if (checkSelfEmpty() && checkProgenyEmpty()) {
            this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(0);
            this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
            this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            return;
        }
        if (checkSelfEmpty() && !checkProgenyEmpty()) {
            this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
            this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
            this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivUpdateProgeny.setVisibility(0);
            return;
        }
        if (!checkSelfEmpty() && checkProgenyEmpty()) {
            this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(0);
            this.binding.declarationSirIncludedLayout.dfTvivDelete.setVisibility(8);
            this.binding.declarationSirIncludedLayout.dfTvivUpdate.setVisibility(0);
            this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(0);
            this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
            this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
            return;
        }
        this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(0);
        this.binding.declarationSirIncludedLayout.dfTvivDelete.setVisibility(8);
        this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
        this.binding.declarationSirIncludedLayout.dfTvivUpdate.setVisibility(0);
        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
        this.binding.declarationSirIncludedLayout.ivDeleteProgeny.setVisibility(0);
        this.binding.declarationSirIncludedLayout.ivUpdateProgeny.setVisibility(0);
    }

    public void setNeitherView(int checkedId) {
        this.selfStatus = "D";
        this.progenyStatus = "D";
        clearRelativeDetailsFromObj();
        clearSelfDetailsFromObj();
        this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(8);
        this.binding.declarationSirIncludedLayout.llDfAddSelf.setVisibility(8);
        this.binding.declarationSirIncludedLayout.cdDfSelfCardView.setVisibility(8);
        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setVisibility(8);
        this.submittedForRecommendation = "N";
    }

    public void showcategoryChangeDialog(final int checkedId, final String type) {
        this.typeRadioButton = type;
        new AlertDialog.Builder(requireContext()).setTitle(this.alertText).setMessage("Do you want to change the category type ?").setCancelable(false).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showcategoryChangeDialog$76(type, checkedId, dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showcategoryChangeDialog$77(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showcategoryChangeDialog$76(String str, int i, DialogInterface dialogInterface, int i2) {
        this.tempCategoty = str;
        if (str.equalsIgnoreCase("self")) {
            setSelfView(i);
        } else if (str.equalsIgnoreCase("progeny")) {
            setProgenyView(i);
        } else if (str.equalsIgnoreCase("NA")) {
            setNeitherView(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showcategoryChangeDialog$77(DialogInterface dialogInterface, int i) {
        if (this.lastCheckedId == this.binding.declarationSirIncludedLayout.dfRBselfRb.getId()) {
            this.binding.declarationSirIncludedLayout.dfRBselfRb.setChecked(true);
        } else if (this.lastCheckedId == this.binding.declarationSirIncludedLayout.progenyRb.getId()) {
            this.binding.declarationSirIncludedLayout.progenyRb.setChecked(true);
        } else if (this.lastCheckedId == this.binding.declarationSirIncludedLayout.neitherRb.getId()) {
            this.binding.declarationSirIncludedLayout.neitherRb.setChecked(true);
        }
    }

    private boolean checkProgenyEmpty() {
        if (TextUtils.isEmpty(this.checkListForm6Model.getRelativeAcNo()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativePartNo()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativePartSerialNumber()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativeStateCd()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativeEpicNumber()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativeName()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativeRelativeName()) && TextUtils.isEmpty(this.checkListForm6Model.getRelativeRelationShip())) {
            Logger.d("check Progeny", BooleanUtils.TRUE);
            return true;
        }
        if (this.checkListForm6Model.getRelativeAcNo().equals("0") && this.checkListForm6Model.getRelativePartNo().equals("0") && this.checkListForm6Model.getRelativePartSerialNumber().equals("0")) {
            return true;
        }
        Logger.d("check Progeny", BooleanUtils.FALSE);
        return false;
    }

    private boolean checkSelfEmpty() {
        if (TextUtils.isEmpty(this.checkListForm6Model.getElectorAcNo()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorPartNumber()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorPartSerialNumber()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorStateCd()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorepicNumber()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorName()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorRelativeName()) && TextUtils.isEmpty(this.checkListForm6Model.getElectorRelationShip())) {
            Logger.d("check self", BooleanUtils.TRUE);
            return true;
        }
        if (this.checkListForm6Model.getElectorAcNo().equals("0") && this.checkListForm6Model.getElectorPartNumber().equals("0") && this.checkListForm6Model.getElectorPartSerialNumber().equals("0")) {
            return true;
        }
        Logger.d("check self", BooleanUtils.FALSE);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRelativeDetailsFromObj() {
        this.checkListForm6Model.setRelativeAcNo(null);
        this.checkListForm6Model.setRelativePartNo(null);
        this.checkListForm6Model.setRelativePartSerialNumber(null);
        this.checkListForm6Model.setRelativeStateCd(null);
        this.checkListForm6Model.setRelativeEpicNumber(null);
        this.checkListForm6Model.setRelativeName(null);
        this.checkListForm6Model.setRelativeRelativeName(null);
        this.checkListForm6Model.setRelativeRelationShip(null);
        this.checkListForm6Model.setElectorsRelation(null);
        this.checkListForm6Model.setRelativeDistrictCd(null);
        this.checkListForm6Model.setRelativeAcName(null);
        this.checkListForm6Model.setRelativeStateName(null);
        this.checkListForm6Model.setElectorsRelation(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelfDetailsFromObj() {
        this.checkListForm6Model.setElectorAcNo(null);
        this.checkListForm6Model.setElectorPartNumber(null);
        this.checkListForm6Model.setElectorPartSerialNumber(null);
        this.checkListForm6Model.setElectorStateCd(null);
        this.checkListForm6Model.setElectorepicNumber(null);
        this.checkListForm6Model.setElectorName(null);
        this.checkListForm6Model.setElectorRelativeName(null);
        this.checkListForm6Model.setElectorRelationShip(null);
        this.checkListForm6Model.setElectorDistrictCd(null);
        this.checkListForm6Model.setElectorAssemblyName(null);
        this.checkListForm6Model.setElectorStateName(null);
    }

    private void handleItemListner() {
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment.64
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    Form6CheckListFragment.this.relationCode = null;
                } else {
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    form6CheckListFragment.relationCode = form6CheckListFragment.relationCodeList.get(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$78(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$79(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$78(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        clearRelativeDetailsFromObj();
        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(8);
        this.binding.declarationSirIncludedLayout.ivAddProgenyLl.setVisibility(0);
        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(8);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$79(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle getBundle(String key) {
        Bundle bundle = new Bundle();
        bundle.putString("key", key);
        bundle.putString("currentName", this.binding.firstNameEd.getText().toString() + StringUtils.SPACE + this.binding.surNameEd.getText().toString());
        bundle.putInt("currentAc", Integer.parseInt(this.asmblyNO));
        bundle.putInt("currentPart", Integer.parseInt(this.partNo));
        bundle.putString("currentState", this.stateCode);
        bundle.putString("currentRelativeType", this.checkListForm6Model.getCurrRelRelation());
        bundle.putString("currentRelativeName", this.checkListForm6Model.getRelativeName());
        bundle.putString("is2003selected", this.formverificationPayload.getIs2003Selected());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelRelative(Payload searchModel) {
        this.checkListForm6Model.setRelativeAcNo(String.valueOf(searchModel.getOldAcNo()));
        this.checkListForm6Model.setRelativePartNo(String.valueOf(searchModel.getOldPartNumber()));
        this.checkListForm6Model.setRelativePartSerialNumber(String.valueOf(searchModel.getOldPartSerialNo()));
        this.checkListForm6Model.setRelativeStateCd(searchModel.getOldStateCd());
        this.checkListForm6Model.setRelativeEpicNumber(searchModel.getEpicNumber());
        this.checkListForm6Model.setRelativeName(searchModel.getOldFullName());
        this.checkListForm6Model.setRelativeRelativeName(searchModel.getOldRelativeFullName());
        this.checkListForm6Model.setRelativeRelationShip(searchModel.getRelationType());
        this.checkListForm6Model.setRelativeAcName(searchModel.getOldAcName());
        this.checkListForm6Model.setRelativeDistrictCd(String.valueOf(searchModel.getOldDistNo()));
        this.checkListForm6Model.setRelativeStateName(String.valueOf(searchModel.getOldStateName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelRelativeMaping(MappingList searchModel) {
        this.checkListForm6Model.setRelativeAcNo(String.valueOf(searchModel.getOldAcNo()));
        this.checkListForm6Model.setRelativePartNo(String.valueOf(searchModel.getOldPartNumber()));
        this.checkListForm6Model.setRelativePartSerialNumber(String.valueOf(searchModel.getOldPartSerialNo()));
        this.checkListForm6Model.setRelativeStateCd(searchModel.getOldStateCd());
        this.checkListForm6Model.setRelativeEpicNumber(searchModel.getOldEpicNumber());
        this.checkListForm6Model.setRelativeName(searchModel.getOldFullName());
        this.checkListForm6Model.setRelativeRelativeName(searchModel.getOldRelativeFullName());
        this.checkListForm6Model.setRelativeRelationShip(searchModel.getRelationType());
        this.checkListForm6Model.setRelativeAcName(searchModel.getOldAcName());
        this.checkListForm6Model.setRelativeDistrictCd(String.valueOf(searchModel.getOldDistNo()));
        this.checkListForm6Model.setRelativeStateName(String.valueOf(searchModel.getOldStateName()));
    }

    private void setSelfData() {
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
        this.binding.declarationSirIncludedLayout.relativeCardView.setVisibility(0);
        if (this.checkListForm6Model.getRelativeAcNo() != null) {
            this.binding.declarationSirIncludedLayout.tvRlAcNo.setText(this.checkListForm6Model.getRelativeAcNo());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlAcNo.setText("");
        }
        if (this.checkListForm6Model.getRelativeRelativeName() != null) {
            this.binding.declarationSirIncludedLayout.tvRlName1.setText(this.checkListForm6Model.getRelativeRelativeName());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlName1.setText("");
        }
        if (this.checkListForm6Model.getRelativeAcName() != null) {
            this.binding.declarationSirIncludedLayout.tvRlAcName.setText(this.checkListForm6Model.getRelativeAcName());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlAcName.setText("");
        }
        if (this.checkListForm6Model.getRelativeName() != null) {
            this.binding.declarationSirIncludedLayout.tvRlName.setText(this.checkListForm6Model.getRelativeName());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlName.setText("");
        }
        if (this.checkListForm6Model.getRelativeEpicNumber() != null) {
            this.binding.declarationSirIncludedLayout.tvRlEpic.setText(this.checkListForm6Model.getRelativeEpicNumber());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlEpic.setText("");
        }
        if (this.checkListForm6Model.getRelativeStateName() != null) {
            this.binding.declarationSirIncludedLayout.tvRlState.setText(this.checkListForm6Model.getRelativeStateName());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlState.setText("");
        }
        if (this.checkListForm6Model.getRelativePartNo() != null) {
            this.binding.declarationSirIncludedLayout.tvRlPartNo.setText(this.checkListForm6Model.getRelativePartNo());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlPartNo.setText("");
        }
        if (this.checkListForm6Model.getRelativePartSerialNumber() != null) {
            this.binding.declarationSirIncludedLayout.tvRlSrNo.setText(this.checkListForm6Model.getRelativePartSerialNumber());
        } else {
            this.binding.declarationSirIncludedLayout.tvRlSrNo.setText("");
        }
        this.binding.declarationSirIncludedLayout.relationtypecardview.setVisibility(0);
        this.binding.declarationSirIncludedLayout.progenyRelationSpinner.setSelection(this.relationCodeList.indexOf(this.checkListForm6Model.getElectorsRelation()));
        Logger.d("spinner value", String.valueOf(this.relationCodeList.indexOf(this.checkListForm6Model.getElectorsRelation())) + StringUtils.SPACE + this.checkListForm6Model.getElectorsRelation());
        setRelativeType(this.checkListForm6Model.getRelativeRelationShip(), this.binding.declarationSirIncludedLayout.tvRlRelation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelSelfMapping(MappingList searchModel) {
        this.checkListForm6Model.setElectorAcNo(String.valueOf(searchModel.getOldAcNo()));
        this.checkListForm6Model.setElectorAssemblyName(searchModel.getOldAcName());
        this.checkListForm6Model.setElectorPartNumber(String.valueOf(searchModel.getOldPartNumber()));
        this.checkListForm6Model.setElectorPartSerialNumber(String.valueOf(searchModel.getOldPartSerialNo()));
        this.checkListForm6Model.setElectorStateCd(searchModel.getOldStateCd());
        this.checkListForm6Model.setElectorDistrictCd(String.valueOf(searchModel.getOldDistNo()));
        this.checkListForm6Model.setElectorName(searchModel.getOldFullName());
        this.checkListForm6Model.setElectorepicNumber(searchModel.getOldEpicNumber());
        this.checkListForm6Model.setElectorRelativeName(searchModel.getOldRelativeFullName());
        this.checkListForm6Model.setElectorRelationShip(searchModel.getRelationType());
        this.checkListForm6Model.setElectorStateName(String.valueOf(searchModel.getOldStateName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelSelf(Payload searchModel) {
        this.checkListForm6Model.setElectorAcNo(String.valueOf(searchModel.getOldAcNo()));
        this.checkListForm6Model.setElectorAssemblyName(searchModel.getOldAcName());
        this.checkListForm6Model.setElectorPartNumber(String.valueOf(searchModel.getOldPartNumber()));
        this.checkListForm6Model.setElectorPartSerialNumber(String.valueOf(searchModel.getOldPartSerialNo()));
        this.checkListForm6Model.setElectorStateCd(searchModel.getOldStateCd());
        this.checkListForm6Model.setElectorDistrictCd(String.valueOf(searchModel.getOldDistNo()));
        this.checkListForm6Model.setElectorName(searchModel.getOldFullName());
        this.checkListForm6Model.setElectorepicNumber(searchModel.getEpicNumber());
        this.checkListForm6Model.setElectorRelativeName(searchModel.getOldRelativeFullName());
        this.checkListForm6Model.setElectorRelationShip(searchModel.getRelationType());
        this.checkListForm6Model.setElectorStateName(String.valueOf(searchModel.getOldStateName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateAgeWithSirAgeCutOff() {
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).validateAgeWithSirAgeCutOff(calculateage(), this.stateCode, this.token, "blo", "BLOAPP", SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", this.stateCode, "ANDROIDMOB").enqueue(new AnonymousClass65());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$65, reason: invalid class name */
    class AnonymousClass65 implements Callback<JsonObject> {
        AnonymousClass65() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (response.code() == 200) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(true);
                    Form6CheckListFragment form6CheckListFragment = Form6CheckListFragment.this;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(form6CheckListFragment.getString(R.string.ef_was_elector_2003_text, new Object[]{form6CheckListFragment.lastSirYear}));
                } else if (Form6CheckListFragment.this.binding.declarationSirIncludedLayout.rb2003.isChecked()) {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(false);
                    String string = new JSONObject(response.errorBody().string()).getString("msg");
                    Form6CheckListFragment form6CheckListFragment2 = Form6CheckListFragment.this;
                    String string2 = form6CheckListFragment2.getString(R.string.ef_was_elector_2003_text, new Object[]{form6CheckListFragment2.lastSirYear});
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) string2).append((CharSequence) StringUtils.SPACE);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) string);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(Form6CheckListFragment.this.getActivity(), android.R.color.holo_red_dark)), length, spannableStringBuilder.length(), 33);
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(spannableStringBuilder);
                } else {
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(true);
                    Form6CheckListFragment form6CheckListFragment3 = Form6CheckListFragment.this;
                    Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setText(form6CheckListFragment3.getString(R.string.ef_was_elector_2003_text, new Object[]{form6CheckListFragment3.lastSirYear}));
                }
            } catch (Exception e) {
                Logger.d("NewVoter", e.toString());
                Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(false);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.form6.Form6CheckListFragment$65$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            if (Form6CheckListFragment.this.alertDialog != null) {
                Form6CheckListFragment.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Form6CheckListFragment.this.binding.declarationSirIncludedLayout.dfRBselfRb.setEnabled(false);
            Log.e("onFailure", "Fail");
        }
    }

    private int calculateage() {
        if (TextUtils.isEmpty(this.checkListForm6Model.getDob())) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.yyformat);
        String dob = this.checkListForm6Model.getDob();
        try {
            dob = simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dobEd.getText().toString()));
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
        }
        LocalDate localDate = LocalDate.parse(dob);
        LocalDate localDateNow = LocalDate.now();
        if (localDate == null || localDateNow == null) {
            return 0;
        }
        return Period.between(localDate, localDateNow).getYears();
    }

    public void setDeclarationUI() {
        if (in.gov.eci.bloapp.utils.Utils.isValideSIRState(this.stateCode)) {
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.radiochooseCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.radioCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.lvGeneralDetails);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.cdDfSelfCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.llDfAddSelf);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.ivAddProgenyLl);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.relativeCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.relationtypecardview);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.bloSigncardview);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.lvGeneralDetails);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.radiochooseCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.radioCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.llDfAddSelf);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.ivAddProgenyLl);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.cdDfSelfCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.relativeCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.relationtypecardview);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.bloSigncardview);
            return;
        }
        if (in.gov.eci.bloapp.utils.Utils.isValide19SIRState(this.stateCode)) {
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.radiochooseCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.radioCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.lvGeneralDetails);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.cdDfSelfCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.llDfAddSelf);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.ivAddProgenyLl);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.relativeCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.relationtypecardview);
            this.binding.declarationSirIncludedLayout.mainLayout.removeView(this.binding.declarationSirIncludedLayout.bloSigncardview);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.radiochooseCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.radioCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.llDfAddSelf);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.ivAddProgenyLl);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.cdDfSelfCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.relativeCardView);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.relationtypecardview);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.lvGeneralDetails);
            this.binding.declarationSirIncludedLayout.mainLayout.addView(this.binding.declarationSirIncludedLayout.bloSigncardview);
        }
    }
}
