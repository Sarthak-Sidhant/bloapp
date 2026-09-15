package in.gov.eci.bloapp.views.activity.sir.formdatanew;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.MyCallbackjsonTest;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormDataForBloModificationPage1Binding;
import in.gov.eci.bloapp.entity.ListData;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.pdfDownloadCallback;
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
import in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormDataForBloModificationPage1 extends SuperBaseActivity {
    Date DoB;
    String aadhar;
    String aadharNoS;
    private String ageDeviation;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    private ActivityFormDataForBloModificationPage1Binding binding;
    byte[] byteArray;
    String citizenshipCat;
    String citizenshipTypeS;
    Date dateAfter;
    Date dateBefore;
    Date dateRange;
    String dob;
    Date dobElector;
    String dobVerified;
    String documentUploadedFlg;
    String electorName;
    Long epicId;
    String epicNoS;
    String erollAge;
    String fatherEpicNo;
    String fatherEpicS;
    String fatherName;
    String fatherNameS;
    protected long filesize;
    Intent intent;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    String isThisYou;
    boolean isThisYouRel;
    boolean isoldStateEntered;
    String mime;
    String mobile;
    String mobileNoS;
    String motherEpicNo;
    String motherEpicS;
    String motherName;
    String motherNameS;
    int newRadioId;
    String partNo;
    String partNoS;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    boolean preFlag;
    int radioName;
    String referenceNo;
    private String refreshToken;
    ArrayList<String> relationCodeSpinnerVal;
    ArrayList<String> relationNameSpinnerVal;
    private String rtkband;
    protected String saveImageFileName;
    int selectedId;
    String selectedText;
    SIRDatabaseHelper sirDatabaseHelper;
    String sirFlag;
    String spouseEpicNo;
    String spouseEpicS;
    String spouseName;
    String spouseNameS;
    String state;
    String temp;
    private String token;
    String uploadFlag;
    final Calendar dobcalendar = Calendar.getInstance();
    String base64element1 = "";
    String base64element2 = "";
    String base64element3 = "";
    String base64element4 = "";
    String base64element11 = "";
    String base64element21 = "";
    String base64element31 = "";
    String base64element41 = "";
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String preSignedurl11 = "";
    String preSignedurl21 = "";
    String preSignedurl31 = "";
    String preSignedurl41 = "";
    String filerefphoto = "";
    boolean onlineStatus = false;
    String messageString = "message";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    String tabName = "Reverify";
    CommomUtility commomUtility = new CommomUtility();
    String objectStorageString = "objectstorage";
    String TAG = "FormDataForBloModificationPage1";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String SESSION = "";
    String comingTag = "coming in onFailure";
    String alertText = "";
    String cancel = "";
    String takephoto = "";
    String upload = "Please upload file again.";
    String imageTextBaseActivity = "image";
    String garudaTextBaseActivity = "GARUDA";
    String invalidaadhar = "";
    private String aadharref = null;
    private boolean result = false;
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String whitecolor = "#000000";
    private String photoref = null;
    private String annexRef = null;
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String img = "image";
    private String submitFlag = null;
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    String imgmsg = "";
    String annexureStr = "Annexure";
    String photo1Str = " Photo1 Annexure";
    String photo2str = "Photo2 Annexure";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String functionNameForLogBaseActivity = "";
    String photoUrlS = "";
    String srFormPage1UrlS = "";
    String srFormPage2UrlS = "";
    String relationType = "";
    String annexureCUrlS = "";
    String bloOverridenFlgS = "";
    String supportingDocumentPage1UrlS = "";
    String supportingDocumentPage2UrlS = "";
    ArrayList<String> relationList = new ArrayList<>();
    String selectRelationType = "";
    String photo1strNew = "EnumerationFormPage1";
    String photo2strNew = "EnumerationFormPage2";
    String photo3strNew = "SupportingDocumentPage1";
    String photo4strNew = "SupportingDocumentPage2";
    String relativeDocument1UrlS = "";
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    String relationOldAcS = "";
    String relationOldPartS = "";
    String relationOldPSLS = "";
    String relationlist8DocS = "";
    String relationIs2003 = "";
    String relationOldStateCd = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    Gson gson = new GsonBuilder().setLenient().create();
    String selectDocumentType = "";
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    String relationCode = "";
    String list8code = "";
    boolean isUserAction = false;
    SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    SimpleDateFormat simple1 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    String oldAc = null;
    String OldPart = null;
    String releationstate = null;
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    File file1 = null;
    File file2 = null;
    File file3 = null;
    File file4 = null;
    File file11 = null;
    File file21 = null;
    File file31 = null;
    File file41 = null;
    int lastCheckedId = -1;
    boolean isUserSelected = false;
    boolean isRequestOTPClicked = false;
    boolean isotpVerified = false;
    boolean issearchdetailsbuttonclicked = false;
    String choose_front_camera = "Capture from Front Camera";
    String choose_back_camera = "Capture from Back Camera";
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFormDataForBloModificationPage1Binding activityFormDataForBloModificationPage1BindingInflate = ActivityFormDataForBloModificationPage1Binding.inflate(getLayoutInflater());
        this.binding = activityFormDataForBloModificationPage1BindingInflate;
        setContentView(activityFormDataForBloModificationPage1BindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        setRelationList();
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(this);
        if (SharedPref.getInstance(getApplicationContext()).getOnlineStatusFlag().equalsIgnoreCase("Y")) {
            this.onlineStatus = true;
        }
        String sirFlag = SharedPref.getInstance(getApplicationContext()).getSirFlag();
        this.sirFlag = sirFlag;
        if (!TextUtils.isEmpty(sirFlag) && this.sirFlag.equalsIgnoreCase("Pre")) {
            this.preFlag = true;
        } else if (!TextUtils.isEmpty(this.sirFlag) && this.sirFlag.equalsIgnoreCase("Post")) {
            this.preFlag = false;
        }
        if (!this.preFlag) {
            this.binding.noDocument.setVisibility(8);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        initializeSpinnerTouch();
        initClickListener();
        this.binding.submitLayout.setVisibility(8);
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.partNoS = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        Intent intent = getIntent();
        this.intent = intent;
        this.dob = intent.getStringExtra("dob");
        this.epicNoS = this.intent.getStringExtra("epic");
        this.epicId = Long.valueOf(this.intent.getLongExtra("epicId", 0L));
        this.aadharNoS = this.intent.getStringExtra("aadharNo");
        this.mobileNoS = this.intent.getStringExtra("mobileNo");
        this.fatherNameS = this.intent.getStringExtra("fatherName");
        this.fatherEpicS = this.intent.getStringExtra("fatherEpic");
        this.motherNameS = this.intent.getStringExtra("motherName");
        this.motherEpicS = this.intent.getStringExtra("motherEpic");
        this.spouseNameS = this.intent.getStringExtra("spouseName");
        this.spouseEpicS = this.intent.getStringExtra("spouseEpic");
        this.photoUrlS = this.intent.getStringExtra("photoUrl");
        this.annexureCUrlS = this.intent.getStringExtra("annexureCUrl");
        this.srFormPage1UrlS = this.intent.getStringExtra("srFormPage1Url");
        this.srFormPage2UrlS = this.intent.getStringExtra("srFormPage2Url");
        this.citizenshipTypeS = this.intent.getStringExtra("citizenshipType");
        this.erollAge = this.intent.getStringExtra("erollAge");
        this.citizenshipCat = this.intent.getStringExtra("citizenshipTypeCat");
        this.documentUploadedFlg = this.intent.getStringExtra("documentUploadedFlg");
        this.electorName = this.intent.getStringExtra("electorName");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/YYYY");
        this.relativeDocument1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg1")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg1");
        this.relativeDocument2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg2")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg2");
        this.relativeSupportingDocumentPage1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage1")) ? "" : this.intent.getStringExtra("relationList8DocsPage1");
        this.relativeSupportingDocumentPage2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage2")) ? "" : this.intent.getStringExtra("relationList8DocsPage2");
        this.relationOldStateCd = TextUtils.isEmpty(this.intent.getStringExtra("relationOldStateCd")) ? "" : this.intent.getStringExtra("relationOldStateCd");
        this.relationOldAcS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldAcNo")) ? "" : this.intent.getStringExtra("relationOldAcNo");
        this.relationOldPartS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartNo")) ? "" : this.intent.getStringExtra("relationOldPartNo");
        this.relationOldPSLS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartSerialNo")) ? "" : this.intent.getStringExtra("relationOldPartSerialNo");
        this.relationlist8DocS = TextUtils.isEmpty(this.intent.getStringExtra("relationListList8DocCode")) ? "" : this.intent.getStringExtra("relationListList8DocCode");
        this.relationIs2003 = TextUtils.isEmpty(this.intent.getStringExtra("relation2003YesOrNo")) ? "" : this.intent.getStringExtra("relation2003YesOrNo");
        this.relationCode = TextUtils.isEmpty(this.intent.getStringExtra("relationType")) ? "" : this.intent.getStringExtra("relationType");
        String stringExtra = TextUtils.isEmpty(this.intent.getStringExtra("isThisYouRel")) ? "" : this.intent.getStringExtra("isThisYouRel");
        this.isThisYou = TextUtils.isEmpty(this.intent.getStringExtra("isThisYou")) ? "" : this.intent.getStringExtra("isThisYou");
        this.isThisYouRel = !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase("Y");
        if (this.relationCode.equalsIgnoreCase("SELF")) {
            this.relationCode = "";
        }
        if (!TextUtils.isEmpty(this.relationOldStateCd) && !TextUtils.isEmpty(this.relationOldAcS) && !TextUtils.isEmpty(this.relationOldPartS) && !TextUtils.isEmpty(this.relationOldPSLS)) {
            this.binding.txtVerifyButton.setVisibility(0);
            this.isOldAcNoEntered = true;
            this.isOldPartNoEntered = true;
            this.isOldPartSerialNoEntered = true;
            this.isoldStateEntered = true;
        }
        setDataOffline("LIST-8");
        this.relationCodeSpinnerVal = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        this.relationNameSpinnerVal = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameSpinnerVal);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter);
        if (this.intent.getStringExtra("relationType") == null || this.intent.getStringExtra("relationType").equals("") || this.intent.getStringExtra("relationType").equalsIgnoreCase("Self")) {
            this.binding.spinnerRelation.setSelection(0);
        } else {
            this.binding.spinnerRelation.setSelection(this.relationCodeSpinnerVal.indexOf(this.intent.getStringExtra("relationType")));
        }
        if (this.intent.getStringExtra("relationListList8DocCode") == null || this.intent.getStringExtra("relationListList8DocCode").equals("")) {
            this.binding.spinnerIR.setSelection(0);
        } else {
            this.binding.spinnerIR.setSelection(this.List8docCode.indexOf(this.intent.getStringExtra("relationListList8DocCode")));
        }
        this.StateList = SharedPref.getInstance(getApplicationContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getApplicationContext()).getAcListName(Constants.STATE_LIST_NAME);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldState.setAdapter((SpinnerAdapter) arrayAdapter2);
        if (this.relationIs2003.equals("Y")) {
            this.binding.relative2003Yes.setChecked(true);
            this.binding.indianWithPriorVoterID.setVisibility(8);
            this.binding.relative2003LL.setVisibility(0);
            this.binding.oldACSerialPSLNoLL.setVisibility(0);
            if (!TextUtils.isEmpty(this.relationOldStateCd)) {
                this.binding.oldState.setSelection(this.StateList.indexOf(this.relationOldStateCd));
            }
            this.binding.oldPslNo.setText(this.relationOldPSLS);
            this.binding.layoutChooseRelationType.setVisibility(0);
            this.binding.edtRelativeEpic.setText(this.intent.getStringExtra("relativeEpic"));
            if (!TextUtils.isEmpty(this.relationOldPSLS)) {
                this.binding.layoutVerifyDetails.setVisibility(0);
            }
            this.binding.submitLayout.setVisibility(8);
        } else if (this.relationIs2003.equals("N")) {
            this.binding.relative2003No.setChecked(true);
            this.binding.relative2003Yes.setChecked(false);
            this.binding.indianWithPriorVoterID.setVisibility(0);
            this.binding.layoutChooseRelationType.setVisibility(8);
            this.binding.relative2003LL.setVisibility(8);
            this.binding.oldACSerialPSLNoLL.setVisibility(8);
            this.binding.layoutVerifyDetails.setVisibility(8);
            this.binding.submitLayout.setVisibility(8);
            this.binding.radioLayout.setVisibility(8);
        }
        this.binding.formCreatedBy.setText(TextUtils.isEmpty(this.electorName) ? "" : this.intent.getStringExtra("electorName"));
        try {
            String str = this.dob;
            if (str != null) {
                this.dob = simpleDateFormat2.format(simpleDateFormat.parse(str));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.aadharNoS)) {
            this.binding.aadharNumber.setText("");
        } else {
            this.commomUtility.getaadhar1(this, this.state, this.token, this.aadharNoS, this.atkband, this.rtkband, "VerifyEF", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.MultipleString
                public final void onCallBack(String str2, String str3) {
                    this.f$0.lambda$onCreate$0(str2, str3);
                }
            });
        }
        if (TextUtils.isEmpty(this.mobileNoS)) {
            this.binding.mobileNumber.setText("");
        } else {
            this.binding.mobileNumber.setText(this.mobileNoS);
        }
        if (TextUtils.isEmpty(this.fatherNameS)) {
            this.binding.fatherName.setText("");
        } else {
            this.binding.fatherName.setText(this.fatherNameS);
        }
        if (TextUtils.isEmpty(this.fatherEpicS)) {
            this.binding.fatherEpicNumber.setText("");
        } else {
            this.binding.fatherEpicNumber.setText(this.fatherEpicS);
        }
        if (TextUtils.isEmpty(this.motherNameS)) {
            this.binding.motherName.setText("");
        } else {
            this.binding.motherName.setText(this.motherNameS);
        }
        if (TextUtils.isEmpty(this.motherEpicS)) {
            this.binding.motherEpicNumber.setText("");
        } else {
            this.binding.motherEpicNumber.setText(this.motherEpicS);
        }
        if (TextUtils.isEmpty(this.spouseNameS)) {
            this.binding.spouseName.setText("");
        } else {
            this.binding.spouseName.setText(this.spouseNameS);
        }
        if (TextUtils.isEmpty(this.spouseEpicS)) {
            this.binding.spouseEpicNumber.setText("");
        } else {
            this.binding.spouseEpicNumber.setText(this.spouseEpicS);
        }
        if (this.dob == null) {
            this.binding.dateOfBirth.setText("");
        } else {
            this.binding.dateOfBirth.setText(this.dob);
        }
        if (TextUtils.isEmpty(this.citizenshipTypeS)) {
            preSelectionOfCat();
        } else if (this.citizenshipCat.equals("CAT-1")) {
            this.binding.indianWithPriorVoterID.setChecked(true);
            this.binding.relative2003Layout.setVisibility(8);
            this.radioName = R.id.indianWithPriorVoterID;
            this.binding.relative2003RG.clearCheck();
        } else if (this.citizenshipCat.equals("CAT-2") || this.citizenshipCat.equals("CAT-3") || this.citizenshipCat.equals("CAT-4")) {
            this.binding.bornInIndia.setChecked(true);
            this.binding.radioLayout.setVisibility(0);
            if (this.citizenshipCat.equals("CAT-2")) {
                this.binding.bornBefore1987rb.setChecked(true);
                this.lastCheckedId = this.binding.bornBefore1987rb.getId();
            }
            if (this.citizenshipCat.equals("CAT-3")) {
                this.binding.bornBefore2004rb.setChecked(true);
                this.lastCheckedId = this.binding.bornBefore2004rb.getId();
            }
            if (this.citizenshipCat.equals("CAT-4")) {
                this.binding.bornAfter2004rb.setChecked(true);
                this.lastCheckedId = this.binding.bornAfter2004rb.getId();
            }
            this.radioName = R.id.bornInIndia;
        } else if (this.citizenshipCat.equals("CAT-5")) {
            this.binding.notBornInIndia.setChecked(true);
            this.radioName = R.id.notBornInIndia;
        } else if (this.citizenshipCat.equals("CAT-6")) {
            this.binding.indianCitizen.setChecked(true);
            this.radioName = R.id.indianCitizen;
        } else if (this.documentUploadedFlg.equals("N") && this.preFlag) {
            this.binding.noDocument.setChecked(true);
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(1, -18);
        final long time2 = calendar2.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda12
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$1(datePicker, i, i2, i3);
            }
        };
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(onDateSetListener, time2, time, view);
            }
        });
        this.binding.selectDetails.getCheckedRadioButtonId();
        if (TextUtils.isEmpty(this.photoUrlS)) {
            this.binding.passPhoto.setVisibility(0);
            this.binding.uploadElectorImage.setVisibility(0);
            this.binding.electorImageLL.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.photoUrlS)) {
            this.binding.passPhoto.setVisibility(8);
            getFile1(this.photoUrlS);
            if (this.photoUrlS.endsWith(".pdf")) {
                this.binding.electorImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
            this.binding.electorImageLL.setVisibility(0);
            this.binding.uploadElectorImage.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.annexureCUrlS)) {
            getFile4(this.annexureCUrlS);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.fbUploadLL.setVisibility(8);
            this.binding.deleteBackImage.setVisibility(8);
            this.binding.annexPage1Layout.setVisibility(8);
            if (this.annexureCUrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
            if (!TextUtils.isEmpty(this.srFormPage1UrlS) && !TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.secondLL.setVisibility(0);
            } else {
                this.binding.secondLL.setVisibility(8);
                this.binding.firstLL.setGravity(17);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.binding.firstLL.getLayoutParams();
                layoutParams.width = -1;
                this.binding.firstLL.setLayoutParams(layoutParams);
            }
        } else {
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.fbUploadLL.setVisibility(0);
                this.binding.fbImageLL.setVisibility(8);
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.srFormPage1UrlS)) {
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.firstLL.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.uploadBackPhoto.setVisibility(0);
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
                this.binding.secondLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.srFormPage1UrlS)) {
                getFile2(this.srFormPage1UrlS);
                this.binding.fbImageLL.setVisibility(0);
                this.binding.fbUploadLL.setVisibility(8);
                if (this.srFormPage1UrlS.endsWith(".pdf")) {
                    this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
            if (!TextUtils.isEmpty(this.srFormPage2UrlS)) {
                getFile3(this.srFormPage2UrlS);
                this.binding.fbImageLL.setVisibility(0);
                this.binding.fbUploadLL.setVisibility(8);
                if (this.srFormPage2UrlS.endsWith(".pdf")) {
                    this.binding.backImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        }
        this.binding.relative2003Yes.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormDataForBloModificationPage1.this.binding.indianWithPriorVoterID.setVisibility(8);
            }
        });
        this.binding.relative2003No.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormDataForBloModificationPage1.this.binding.indianWithPriorVoterID.setVisibility(0);
            }
        });
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage1.this.isUserSelected) {
                    FormDataForBloModificationPage1.this.deletePhoto(201);
                    FormDataForBloModificationPage1.this.deletePhoto(202);
                    FormDataForBloModificationPage1.this.deletePhoto(203);
                    FormDataForBloModificationPage1.this.deletePhoto(204);
                    FormDataForBloModificationPage1.this.isUserSelected = false;
                }
                if (i == 0) {
                    FormDataForBloModificationPage1.this.relationlist8DocS = "";
                    return;
                }
                int i2 = i - 1;
                if (i2 < 0 || i2 >= FormDataForBloModificationPage1.this.List8docName.size()) {
                    return;
                }
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.relationlist8DocS = formDataForBloModificationPage1.List8docCode.get(i);
                Logger.d(Constants.LIST8_CODE, FormDataForBloModificationPage1.this.relationlist8DocS);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass4());
        this.binding.electorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.frontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.backImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.deleteElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.electorImageLL.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.electorImageMainLL.setVisibility(0);
                FormDataForBloModificationPage1.this.photoUrlS = "";
                FormDataForBloModificationPage1.this.binding.passPhoto.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setVisibility(0);
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.electorImageLL.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.electorImageMainLL.setVisibility(0);
                FormDataForBloModificationPage1.this.photoUrlS = "";
                FormDataForBloModificationPage1.this.binding.passPhoto.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.passPhotoLayout.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setEnabled(true);
            }
        });
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.srFormPage1UrlS = "";
                FormDataForBloModificationPage1.this.binding.firstLL.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.fbUploadLL.setVisibility(0);
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage2UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.annexureCUrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.fbImageLL.setVisibility(8);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.annexureCUrlS)) {
                    return;
                }
                FormDataForBloModificationPage1.this.annexureCUrlS = "";
                FormDataForBloModificationPage1.this.binding.secondLL.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.annexPage1Layout.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.photo1Name.setText("");
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.secondLL.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage2UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.annexureCUrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                }
                if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) || !TextUtils.isEmpty(FormDataForBloModificationPage1.this.annexureCUrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.lvPage1EnumrationChoose.setVisibility(8);
                }
                FormDataForBloModificationPage1.this.binding.fbUploadLL.setVisibility(0);
                FormDataForBloModificationPage1.this.srFormPage2UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage2UrlS)) {
                    FormDataForBloModificationPage1.this.binding.fbImageLL.setVisibility(8);
                }
                if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) && FormDataForBloModificationPage1.this.binding.annexPage1Layout.getVisibility() == 0) {
                    FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                }
                if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage2UrlS) && FormDataForBloModificationPage1.this.binding.annexPage1Layout.getVisibility() == 0) {
                    FormDataForBloModificationPage1.this.binding.fbImageLL.setVisibility(8);
                }
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormDataForBloModificationPage1.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormDataForBloModificationPage1.this.isMotherEPICValid = false;
                FormDataForBloModificationPage1.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormDataForBloModificationPage1.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormDataForBloModificationPage1.this.isFatherEPICValid = false;
                FormDataForBloModificationPage1.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormDataForBloModificationPage1.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormDataForBloModificationPage1.this.isSpouseEPICValid = false;
                FormDataForBloModificationPage1.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.ivSearchRelative.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormDataForBloModificationPage1.this.binding.edtRelativeEpic.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormDataForBloModificationPage1.this.isRelativeEPICValid = false;
                FormDataForBloModificationPage1.this.checkEpicNumber(strTrim, "Relative");
            }
        });
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FormDataForBloModificationPage1.this.validate()) {
                    FormDataForBloModificationPage1.this.sentDataToNext();
                }
            }
        });
        this.binding.uploadElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.photocount = 0;
                if (SharedPref.getInstance(FormDataForBloModificationPage1.this).getisElectorUpload().equalsIgnoreCase("Y")) {
                    FormDataForBloModificationPage1.this.choosseCameraOption();
                } else {
                    FormDataForBloModificationPage1.this.pickFile();
                }
            }
        });
        this.binding.uploadFrontPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.pickPhoto(101, "photo1Form");
            }
        });
        this.binding.uploadBackPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS)) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.getString(R.string.uploadfrontpagemsg));
                } else {
                    FormDataForBloModificationPage1.this.pickPhoto(102, "FormPhoto2photo1Form");
                }
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.17
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (FormDataForBloModificationPage1.this.binding.noDocument.isChecked()) {
                    FormDataForBloModificationPage1.this.uploadFlag = "N";
                    FormDataForBloModificationPage1.this.binding.nextButton.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.submitLayout.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.radioLayout.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog2("", formDataForBloModificationPage1.getString(R.string.noDocUploadedMsg));
                }
                if (FormDataForBloModificationPage1.this.binding.bornInIndia.isChecked()) {
                    FormDataForBloModificationPage1.this.binding.relative2003Layout.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.radioLayout.setVisibility(0);
                    if (FormDataForBloModificationPage1.this.binding.bornBefore1987rb.isChecked()) {
                        FormDataForBloModificationPage1.this.binding.bornBefore1987rb.setChecked(true);
                    } else if (FormDataForBloModificationPage1.this.binding.bornBefore2004rb.isChecked()) {
                        FormDataForBloModificationPage1.this.binding.bornBefore2004rb.setChecked(true);
                    } else if (FormDataForBloModificationPage1.this.binding.bornAfter2004rb.isChecked()) {
                        FormDataForBloModificationPage1.this.binding.bornAfter2004rb.setChecked(true);
                    }
                    FormDataForBloModificationPage1.this.binding.nextButton.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.submitLayout.setVisibility(8);
                    return;
                }
                if (FormDataForBloModificationPage1.this.binding.indianWithPriorVoterID.isChecked()) {
                    FormDataForBloModificationPage1.this.binding.relative2003Layout.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.relative2003RG.clearCheck();
                } else {
                    FormDataForBloModificationPage1.this.binding.relative2003Layout.setVisibility(0);
                }
                FormDataForBloModificationPage1.this.binding.radioLayout.setVisibility(8);
                FormDataForBloModificationPage1.this.uploadFlag = "Y";
                FormDataForBloModificationPage1.this.binding.radioLayout.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.nextButton.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.submitLayout.setVisibility(8);
            }
        });
        this.binding.selectDetailsBornIndia.setOnCheckedChangeListener(new AnonymousClass18());
        this.binding.bornInIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.erollAge) || FormDataForBloModificationPage1.this.lastCheckedId != -1) {
                    return;
                }
                String category = AgeCategorizer.getCategory(Integer.parseInt(FormDataForBloModificationPage1.this.erollAge));
                if (category.equalsIgnoreCase("Born in India before 1987")) {
                    FormDataForBloModificationPage1.this.binding.bornBefore1987rb.setChecked(true);
                } else if (category.equalsIgnoreCase("Born in India between 01.07.1987 and 02.12.2004")) {
                    FormDataForBloModificationPage1.this.binding.bornBefore2004rb.setChecked(true);
                } else if (category.equalsIgnoreCase("Born in India after 03.12.2004")) {
                    FormDataForBloModificationPage1.this.binding.bornAfter2004rb.setChecked(true);
                }
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) && TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLLNew.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.linearLayoutPage1Relation.setVisibility(0);
            this.binding.linearLayoutPage2Relation.setVisibility(0);
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.enumerationFormLayout.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
            this.binding.linearLayoutPage2Relation.setVisibility(0);
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.secondLLNew.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            getFile11(this.relativeDocument1UrlS);
            this.binding.fbImageLLNew.setVisibility(0);
            if (this.relativeDocument1UrlS.endsWith(".pdf")) {
                this.binding.frontImageNew.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            getFile21(this.relativeDocument2UrlS);
            this.binding.fbImageLLNew.setVisibility(0);
            if (this.relativeDocument2UrlS.endsWith(".pdf")) {
                this.binding.backImageNew.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.fbImageLL1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.linearLayoutPage1.setVisibility(0);
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
            this.binding.linearLayoutPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.linearLayoutPage1.setVisibility(0);
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
            this.binding.linearLayoutPage2.setVisibility(0);
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            getFile31(this.relativeSupportingDocumentPage1UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            if (this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
                this.binding.frontImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            getFile41(this.relativeSupportingDocumentPage2UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            if (this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
                this.binding.backImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        this.binding.relative2003RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.20
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (FormDataForBloModificationPage1.this.binding.relative2003Yes.isChecked()) {
                    FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.oldACSerialPSLNoLL.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.layoutChooseRelationType.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.layoutReletiveEpic.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.submitLayout.setVisibility(8);
                    if (FormDataForBloModificationPage1.this.binding.oldState.getSelectedItemPosition() != 0 && FormDataForBloModificationPage1.this.binding.oldAcNo.getSelectedItemPosition() != 0 && FormDataForBloModificationPage1.this.binding.oldPartNo.getSelectedItemPosition() != 0 && FormDataForBloModificationPage1.this.binding.oldPslNo.getText().toString().trim().length() > 0) {
                        FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(0);
                    }
                }
                if (FormDataForBloModificationPage1.this.binding.relative2003No.isChecked()) {
                    FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.oldACSerialPSLNoLL.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.layoutChooseRelationType.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.layoutReletiveEpic.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.submitLayout.setVisibility(8);
                }
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.pickPhoto(201, "rDP1_");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS)) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.getString(R.string.uploadpage1error));
                } else {
                    FormDataForBloModificationPage1.this.pickPhoto(202, "rDP2_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationlist8DocS)) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.selectDocumentType);
                } else {
                    FormDataForBloModificationPage1.this.pickPhoto(203, "sDP1_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationlist8DocS)) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.selectDocumentType);
                } else if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS)) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.alertText, FormDataForBloModificationPage1.this.getString(R.string.uploadpage1error));
                } else {
                    FormDataForBloModificationPage1.this.pickPhoto(204, "sDP2_");
                }
            }
        });
        this.binding.deleteFrontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.firstLLNew.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.linearLayoutPage1Relation.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.enumerationFormLayout.setVisibility(0);
                FormDataForBloModificationPage1.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage2Relation.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.secondLLNew.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.linearLayoutPage2Relation.setVisibility(0);
                FormDataForBloModificationPage1.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage1Relation.setVisibility(0);
                }
                FormDataForBloModificationPage1.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.firstLL1.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.linearLayoutPage1.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.fbImageLL1.setVisibility(8);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.secondLL1.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.linearLayoutPage2.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.fbImageLL1.setVisibility(8);
                }
                FormDataForBloModificationPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$14(view, motionEvent);
            }
        });
        this.binding.spinnerRelation.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.29
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    FormDataForBloModificationPage1.this.isUserAction = true;
                    FormDataForBloModificationPage1.this.isUserSelected = true;
                }
            }
        });
        this.binding.spinnerRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.30
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage1.this.isUserSelected) {
                    FormDataForBloModificationPage1.this.deletePhoto(201);
                    FormDataForBloModificationPage1.this.deletePhoto(202);
                    FormDataForBloModificationPage1.this.deletePhoto(203);
                    FormDataForBloModificationPage1.this.deletePhoto(204);
                    FormDataForBloModificationPage1.this.isUserSelected = false;
                }
                if (FormDataForBloModificationPage1.this.isUserAction) {
                    if (i == 0) {
                        FormDataForBloModificationPage1.this.relationCode = "";
                    } else {
                        int i2 = i - 1;
                        if (i2 >= 0 && i2 < FormDataForBloModificationPage1.this.relationNameSpinnerVal.size()) {
                            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                            formDataForBloModificationPage1.relationCode = formDataForBloModificationPage1.relationCodeSpinnerVal.get(i);
                            Logger.d("relationcode", FormDataForBloModificationPage1.this.relationCode);
                        }
                    }
                    FormDataForBloModificationPage1.this.binding.oldState.setSelection(0);
                    FormDataForBloModificationPage1.this.binding.oldAcNo.setSelection(0);
                    FormDataForBloModificationPage1.this.binding.oldPartNo.setSelection(0);
                    FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                    FormDataForBloModificationPage1.this.binding.spinnerIR.setSelection(0);
                    FormDataForBloModificationPage1.this.binding.firstLLNew.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage1Relation.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.enumerationFormLayout.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(8);
                    FormDataForBloModificationPage1.this.relativeDocument1UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument2UrlS)) {
                        FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                        FormDataForBloModificationPage1.this.binding.linearLayoutPage2Relation.setVisibility(0);
                    }
                    FormDataForBloModificationPage1.this.binding.secondLLNew.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage2Relation.setVisibility(0);
                    FormDataForBloModificationPage1.this.relativeDocument2UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument2UrlS)) {
                        FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    }
                    FormDataForBloModificationPage1.this.binding.enumerationFormLayout.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.firstLL1.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage1.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                    FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS)) {
                        FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                        FormDataForBloModificationPage1.this.binding.linearLayoutPage2.setVisibility(0);
                    }
                    FormDataForBloModificationPage1.this.binding.secondLL1.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.linearLayoutPage2.setVisibility(0);
                    FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS)) {
                        FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                        FormDataForBloModificationPage1.this.binding.linearLayoutPage1.setVisibility(0);
                    }
                    FormDataForBloModificationPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                }
            }
        });
        this.binding.oldState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.31
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    FormDataForBloModificationPage1.this.isoldStateEntered = false;
                    if (FormDataForBloModificationPage1.this.isUserSelected) {
                        FormDataForBloModificationPage1.this.binding.oldPartNo.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.oldAcNo.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                        FormDataForBloModificationPage1.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                FormDataForBloModificationPage1.this.isoldStateEntered = true;
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.releationstate = formDataForBloModificationPage1.StateList.get(i);
                Log.d(FormDataForBloModificationPage1.this.TAG, "AClist " + FormDataForBloModificationPage1.this.StateList);
                Log.d(FormDataForBloModificationPage1.this.TAG, "Spinner value " + FormDataForBloModificationPage1.this.releationstate);
                FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage2.getAllAC(formDataForBloModificationPage2.releationstate);
                if (FormDataForBloModificationPage1.this.isUserSelected) {
                    FormDataForBloModificationPage1.this.isUserSelected = false;
                    FormDataForBloModificationPage1.this.binding.oldPartNo.setSelection(0);
                    FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                }
            }
        });
        this.binding.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    FormDataForBloModificationPage1.this.isOldAcNoEntered = false;
                    if (FormDataForBloModificationPage1.this.isUserSelected) {
                        FormDataForBloModificationPage1.this.binding.oldPartNo.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.oldState.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                        FormDataForBloModificationPage1.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                FormDataForBloModificationPage1.this.isOldAcNoEntered = true;
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.oldAc = formDataForBloModificationPage1.ACList.get(i).toString();
                Log.d(FormDataForBloModificationPage1.this.TAG, "AClist " + FormDataForBloModificationPage1.this.ACList);
                Log.d(FormDataForBloModificationPage1.this.TAG, "Spinner value " + FormDataForBloModificationPage1.this.oldAc);
                int i2 = Integer.parseInt(FormDataForBloModificationPage1.this.ACList.get(i));
                Log.d(FormDataForBloModificationPage1.this.TAG, "acForPart " + i2);
                FormDataForBloModificationPage1.this.getPartByAc(i2, "case1");
                if (FormDataForBloModificationPage1.this.isUserSelected) {
                    FormDataForBloModificationPage1.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.33
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    FormDataForBloModificationPage1.this.isOldPartNoEntered = false;
                    if (FormDataForBloModificationPage1.this.isUserSelected) {
                        FormDataForBloModificationPage1.this.binding.oldAcNo.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.oldState.setSelection(0);
                        FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                        FormDataForBloModificationPage1.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                FormDataForBloModificationPage1.this.isOldPartNoEntered = true;
                if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldPartS) && Integer.parseInt(FormDataForBloModificationPage1.this.relationOldPartS) != Integer.parseInt(String.valueOf(FormDataForBloModificationPage1.this.partList.get(i - 1)))) {
                    Log.d(FormDataForBloModificationPage1.this.TAG, "Spinner part value " + FormDataForBloModificationPage1.this.partList.get(i).toString());
                    FormDataForBloModificationPage1.this.binding.oldPslNo.setText("");
                } else {
                    FormDataForBloModificationPage1.this.binding.oldPslNo.setText(FormDataForBloModificationPage1.this.relationOldPSLS);
                }
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.OldPart = formDataForBloModificationPage1.partList.get(i - 1).toString();
                if (FormDataForBloModificationPage1.this.isUserSelected) {
                    FormDataForBloModificationPage1.this.isUserSelected = false;
                }
            }
        });
        this.binding.frontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.backImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.frontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.backImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.34
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (text.toString().trim().length() > 0 && FormDataForBloModificationPage1.this.isOldAcNoEntered && FormDataForBloModificationPage1.this.isOldPartNoEntered) {
                    FormDataForBloModificationPage1.this.isOldPartSerialNoEntered = true;
                } else {
                    FormDataForBloModificationPage1.this.isOldPartSerialNoEntered = false;
                    FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                }
                if (FormDataForBloModificationPage1.this.isOldAcNoEntered && FormDataForBloModificationPage1.this.isOldPartNoEntered && FormDataForBloModificationPage1.this.isOldPartSerialNoEntered) {
                    FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(0);
                }
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.issearchdetailsbuttonclicked = true;
                if (FormDataForBloModificationPage1.this.releationstate.trim().length() <= 0 || FormDataForBloModificationPage1.this.oldAc.trim().length() <= 0 || FormDataForBloModificationPage1.this.OldPart.trim().length() <= 0 || FormDataForBloModificationPage1.this.binding.oldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(0);
                FormDataForBloModificationPage1.this.callVerifyRelativeApi();
            }
        });
        this.binding.mobileNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.36
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
                    Logger.d(FormDataForBloModificationPage1.this.TAG, s.toString());
                    this.hasShowMessage = true;
                    FormDataForBloModificationPage1.this.binding.tvRequestOtp.setVisibility(0);
                    FormDataForBloModificationPage1.this.binding.otpLayout.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.pinView.setText("");
                    return;
                }
                if (s.length() > 10) {
                    this.hasShowMessage = false;
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.getString(R.string.mobilenoerror));
                } else {
                    this.hasShowMessage = false;
                    FormDataForBloModificationPage1.this.binding.tvRequestOtp.setVisibility(8);
                    FormDataForBloModificationPage1.this.binding.otpLayout.setVisibility(8);
                    FormDataForBloModificationPage1.this.isRequestOTPClicked = false;
                    FormDataForBloModificationPage1.this.isotpVerified = false;
                }
            }
        });
        this.binding.tvRequestOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.37
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                FormDataForBloModificationPage1.this.isotpVerified = false;
                FormDataForBloModificationPage1.this.alertDialog.show();
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r1 = FormDataForBloModificationPage1.this;
                commomUtility.sentOTP(r1, ((FormDataForBloModificationPage1) r1).token, FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, FormDataForBloModificationPage1.this.binding.mobileNumber.getText().toString(), new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.37.1
                    @Override // in.gov.eci.bloapp.MyCallbackjsonTest
                    public void onCallbacktest(int code, JsonArray value) {
                        if (FormDataForBloModificationPage1.this.alertDialog != null) {
                            FormDataForBloModificationPage1.this.alertDialog.dismiss();
                        }
                        if (code == 200) {
                            FormDataForBloModificationPage1.this.isRequestOTPClicked = true;
                            FormDataForBloModificationPage1.this.binding.otpLayout.setVisibility(0);
                            FormDataForBloModificationPage1.this.binding.tvRequestOtp.setVisibility(8);
                            Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) "OTP sent sucessfully.", 1).show();
                            return;
                        }
                        Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) "Either entered mobile number is incorrect or network issue, please try again", 1).show();
                    }
                });
            }
        });
        this.binding.tvVerifyOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.38
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.binding.pinView.length() == 6) {
                    FormDataForBloModificationPage1.this.alertDialog.show();
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r1 = FormDataForBloModificationPage1.this;
                    commomUtility.verifyOTP(r1, ((FormDataForBloModificationPage1) r1).token, FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, FormDataForBloModificationPage1.this.binding.mobileNumber.getText().toString(), FormDataForBloModificationPage1.this.binding.pinView.getText().toString(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.38.1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public void onCallBack(int code, String status, String message) {
                            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                                FormDataForBloModificationPage1.this.alertDialog.dismiss();
                            }
                            if (code == 200) {
                                FormDataForBloModificationPage1.this.isotpVerified = true;
                                FormDataForBloModificationPage1.this.binding.otpLayout.setVisibility(8);
                                FormDataForBloModificationPage1.this.binding.tvRequestOtp.setVisibility(8);
                                FormDataForBloModificationPage1.this.binding.pinView.setText("");
                                Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) message, 1).show();
                                return;
                            }
                            Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) message, 1).show();
                        }
                    });
                    return;
                }
                FormDataForBloModificationPage1.this.commomUtility.displayAlertWithTitleAndMessage(FormDataForBloModificationPage1.this, "Enter OTP", "Please enter OTP");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            showDialog1(this.invalidaadhar, str2);
        } else if (str.equalsIgnoreCase("D")) {
            this.binding.aadharNumber.setText("");
        } else {
            this.aadharref = this.aadharNoS;
            this.binding.aadharNumber.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4, reason: invalid class name */
    class AnonymousClass4 implements TextWatcher {
        AnonymousClass4() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString().length() != 12 || FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString().contains("xx")) {
                return;
            }
            FormDataForBloModificationPage1.this.alertDialog.show();
            try {
                String string = FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString();
                FormDataForBloModificationPage1.this.result = Verhoeff.validateVerhoeff(string);
                if (!FormDataForBloModificationPage1.this.result) {
                    FormDataForBloModificationPage1.this.binding.aadharNumber.setText("");
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1("", formDataForBloModificationPage1.getString(R.string.invalidAadharMsg2));
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                } else {
                    FormDataForBloModificationPage1.this.commomUtility.getaadharref(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onTextChanged$11(i, str, str2);
                        }
                    });
                }
            } catch (Exception e) {
                Logger.d("", e.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$11(int i, String str, String str2) {
            if (i == 401) {
                FormDataForBloModificationPage1.this.commomUtility.getRefreshToken(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$6(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1.this.commomUtility.storeaadhar(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda4
                        @Override // in.gov.eci.bloapp.MultipleString
                        public final void onCallBack(String str3, String str4) {
                            this.f$0.lambda$onTextChanged$9(str3, str4);
                        }
                    });
                    return;
                }
                FormDataForBloModificationPage1.this.aadharref = str2;
                FormDataForBloModificationPage1.this.aadharNoS = "";
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$10();
                    }
                }, 2000L);
                return;
            }
            FormDataForBloModificationPage1.this.showDialog1(FormDataForBloModificationPage1.this.alertText + i, str2);
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$6(int i, String str, String str2) {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                FormDataForBloModificationPage1.this.commomUtility.showMessageOK(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda11
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1.this.token = "Bearer " + str;
            FormDataForBloModificationPage1.this.refreshToken = str2;
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str);
            FormDataForBloModificationPage1.this.commomUtility.getaadharref(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str3, String str4) {
                    this.f$0.lambda$onTextChanged$5(i2, str3, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent(FormDataForBloModificationPage1.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$5(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1.this.commomUtility.storeaadhar(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, FormDataForBloModificationPage1.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda7
                        @Override // in.gov.eci.bloapp.MultipleString
                        public final void onCallBack(String str3, String str4) {
                            this.f$0.lambda$onTextChanged$3(str3, str4);
                        }
                    });
                    return;
                }
                FormDataForBloModificationPage1.this.aadharref = str2;
                FormDataForBloModificationPage1.this.aadharNoS = "";
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            FormDataForBloModificationPage1.this.showDialog1(FormDataForBloModificationPage1.this.alertText + i, str2);
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$3(String str, String str2) {
            if (str.equals("N") || str.equals("n")) {
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.invalidaadhar, str2);
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
                return;
            }
            FormDataForBloModificationPage1.this.commomUtility.getaadharref(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, str2, FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i, String str3, String str4) {
                    this.f$0.lambda$onTextChanged$2(i, str3, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.invalidaadhar, str2);
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    return;
                } else {
                    FormDataForBloModificationPage1.this.aadharref = str2;
                    FormDataForBloModificationPage1.this.aadharNoS = "";
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$1();
                        }
                    }, 2000L);
                    return;
                }
            }
            FormDataForBloModificationPage1.this.showDialog1(FormDataForBloModificationPage1.this.alertText + i, str2);
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$9(String str, String str2) {
            if (str.equals("N") || str.equals("n")) {
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.invalidaadhar, str2);
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
                return;
            }
            FormDataForBloModificationPage1.this.commomUtility.getaadharref(FormDataForBloModificationPage1.this.getApplicationContext(), FormDataForBloModificationPage1.this.state, FormDataForBloModificationPage1.this.token, str2, FormDataForBloModificationPage1.this.atkband, FormDataForBloModificationPage1.this.rtkband, "VerifyForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda10
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i, String str3, String str4) {
                    this.f$0.lambda$onTextChanged$8(i, str3, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$8(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.invalidaadhar, str2);
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    return;
                } else {
                    FormDataForBloModificationPage1.this.aadharref = str2;
                    FormDataForBloModificationPage1.this.aadharNoS = "";
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$4$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$7();
                        }
                    }, 2000L);
                    return;
                }
            }
            FormDataForBloModificationPage1.this.showDialog1(FormDataForBloModificationPage1.this.alertText + i, str2);
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$7() {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$10() {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.photoUrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file1, this.photoUrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl1)) {
            showImageDialog(this.preSignedurl1, this.photoUrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && this.srFormPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file2, this.srFormPage1UrlS);
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && !this.srFormPage1UrlS.endsWith(".pdf")) {
            if (!TextUtils.isEmpty(this.preSignedurl2)) {
                showImageDialog(this.preSignedurl2, this.srFormPage1UrlS);
            } else {
                showImageDialog("", "");
            }
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) || !this.annexureCUrlS.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.file4, this.annexureCUrlS);
        } catch (IOException e2) {
            Log.d("Exception in displaying pdf= ", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        if (this.srFormPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file3, this.srFormPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl3, this.srFormPage2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$18, reason: invalid class name */
    class AnonymousClass18 implements RadioGroup.OnCheckedChangeListener {
        AnonymousClass18() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, final int checkedId) {
            if (FormDataForBloModificationPage1.this.lastCheckedId != -1 && FormDataForBloModificationPage1.this.lastCheckedId != checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.erollAge)) {
                    return;
                }
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                if (TextUtils.isEmpty(formDataForBloModificationPage1.getcategoryFromAge(Integer.parseInt(formDataForBloModificationPage1.erollAge)))) {
                    return;
                }
                FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                String str = formDataForBloModificationPage2.getcategoryFromAge(Integer.parseInt(formDataForBloModificationPage2.erollAge));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.equalsIgnoreCase(radioButton.getText().toString())) {
                    FormDataForBloModificationPage1.this.lastCheckedId = checkedId;
                    FormDataForBloModificationPage1.this.ageDeviation = "Y";
                    return;
                } else {
                    new AlertDialog.Builder(FormDataForBloModificationPage1.this).setTitle(FormDataForBloModificationPage1.this.alertText).setMessage("As per the system you don't qualify for category " + ((Object) radioButton.getText()) + ". Do you wish to continue?").setCancelable(false).setPositiveButton(FormDataForBloModificationPage1.this.getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$18$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$0(checkedId, dialogInterface, i);
                        }
                    }).setNegativeButton(FormDataForBloModificationPage1.this.getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$18$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCheckedChanged$1(dialogInterface, i);
                        }
                    }).show();
                    return;
                }
            }
            FormDataForBloModificationPage1.this.lastCheckedId = checkedId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$0(int i, DialogInterface dialogInterface, int i2) {
            FormDataForBloModificationPage1.this.lastCheckedId = i;
            FormDataForBloModificationPage1.this.ageDeviation = "Y";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckedChanged$1(DialogInterface dialogInterface, int i) {
            if (FormDataForBloModificationPage1.this.lastCheckedId == FormDataForBloModificationPage1.this.binding.bornBefore1987rb.getId()) {
                FormDataForBloModificationPage1.this.binding.bornBefore1987rb.setChecked(true);
            } else if (FormDataForBloModificationPage1.this.lastCheckedId == FormDataForBloModificationPage1.this.binding.bornBefore2004rb.getId()) {
                FormDataForBloModificationPage1.this.binding.bornBefore2004rb.setChecked(true);
            } else if (FormDataForBloModificationPage1.this.lastCheckedId == FormDataForBloModificationPage1.this.binding.bornAfter2004rb.getId()) {
                FormDataForBloModificationPage1.this.binding.bornAfter2004rb.setChecked(true);
            }
            FormDataForBloModificationPage1.this.ageDeviation = "N";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        this.submitFlag = "N";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        this.submitFlag = "Y";
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        deletePhoto(201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        deletePhoto(202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        deletePhoto(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        deletePhoto(204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$14(View view, MotionEvent motionEvent) {
        this.isUserAction = true;
        this.isUserSelected = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS) && this.relativeDocument1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file11, this.relativeDocument1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl11, this.relativeDocument1UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS) && this.relativeDocument2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file21, this.relativeDocument2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl21)) {
            showImageDialog(this.preSignedurl21, this.relativeDocument2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file31, this.relativeSupportingDocumentPage1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl31)) {
            showImageDialog(this.preSignedurl31, this.relativeSupportingDocumentPage1UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS) && this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file41, this.relativeSupportingDocumentPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl41)) {
            showImageDialog(this.preSignedurl41, this.relativeSupportingDocumentPage2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.releationstate);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getDetailsByEroll(Integer.parseInt(this.oldAc.trim()), Integer.parseInt(this.OldPart.trim()), Integer.parseInt(this.binding.oldPslNo.getText().toString()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.39
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(FormDataForBloModificationPage1.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
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
                        FormDataForBloModificationPage1.this.showVerifyDetailsDialog(strOptString2 + " " + strOptString3, strOptString4 + " " + strOptString5, strOptString6, strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("ReverifyPage1", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    FormDataForBloModificationPage1.this.isThisYouRel = false;
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, FormDataForBloModificationPage1.this.getString(R.string.no_record_found));
                    return;
                }
                FormDataForBloModificationPage1.this.isThisYouRel = false;
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
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
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.40
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(0);
                FormDataForBloModificationPage1.this.binding.layoutVerifyDetails.setVisibility(8);
                dialog.cancel();
                FormDataForBloModificationPage1.this.isThisYouRel = true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1.this.binding.relative2003LL.setVisibility(0);
                dialog.cancel();
                FormDataForBloModificationPage1.this.isThisYouRel = false;
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        final String strReplaceAll = this.epicNoS.replaceAll("/", "_");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$19(charSequenceArr, strReplaceAll, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$19(CharSequence[] charSequenceArr, String str, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.temp = str + "_voter_photo";
            this.alertDialog.show();
            ImagePicker.with(this).cropSquare().compress(512).cameraOnly().start(100);
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, final String listCode) {
        final String strReplaceAll = this.epicNoS.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$20(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$20(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00c8  */
    /* JADX WARN: Multi-variable type inference failed */
    public void sentDataToNext() {
        String str;
        String stringExtra;
        FormDataForBloModificationPage1 formDataForBloModificationPage1;
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationPage2.class);
        this.selectedText = "";
        if (this.binding.indianWithPriorVoterID.isChecked()) {
            this.selectedText = this.binding.indianWithPriorVoterID.getText().toString();
            str = "CAT-1";
        } else if (this.binding.bornInIndia.isChecked()) {
            this.selectedText = this.binding.bornInIndia.getText().toString();
            if (this.binding.bornBefore1987rb.isChecked()) {
                this.selectedText = this.binding.bornBefore1987rb.getText().toString();
                str = "CAT-2";
            } else if (this.binding.bornBefore2004rb.isChecked()) {
                this.selectedText = this.binding.bornBefore2004rb.getText().toString();
                str = "CAT-3";
            } else if (!this.binding.bornAfter2004rb.isChecked()) {
                str = "";
            } else {
                this.selectedText = this.binding.bornAfter2004rb.getText().toString();
                str = "CAT-4";
            }
        } else if (this.binding.notBornInIndia.isChecked()) {
            this.selectedText = this.binding.notBornInIndia.getText().toString();
            str = "CAT-5";
        } else if (!this.binding.indianCitizen.isChecked()) {
            str = "";
        } else {
            this.selectedText = this.binding.indianCitizen.getText().toString();
            str = "CAT-6";
        }
        if (TextUtils.isEmpty(this.selectedText)) {
            showDialog1(getString(R.string.alertMsg), "Please select citizenship category");
            return;
        }
        String stringExtra2 = this.intent.getStringExtra("citizenshipTypeCat");
        intent.putExtra("aadharNo", !TextUtils.isEmpty(this.aadharNoS) ? this.aadharNoS : this.aadharref);
        intent.putExtra("mobileNo", this.mobile);
        intent.putExtra("dobverified", this.dobVerified);
        intent.putExtra("fatherName", this.fatherName);
        intent.putExtra("fatherEpic", this.fatherEpicNo);
        intent.putExtra("epicId", this.epicId);
        intent.putExtra("motherEpic", this.motherEpicNo);
        intent.putExtra("motherName", this.motherName);
        intent.putExtra("spouseName", this.spouseName);
        intent.putExtra("spouseEpic", this.spouseEpicNo);
        intent.putExtra("annexure_url", this.annexureCUrlS);
        intent.putExtra("photo1ref", this.srFormPage1UrlS);
        intent.putExtra("photo2ref", this.srFormPage2UrlS);
        intent.putExtra("photo-url", this.photoUrlS);
        intent.putExtra("annexureCUrl", this.annexureCUrlS);
        intent.putExtra("epicNo", this.intent.getStringExtra("epic"));
        intent.putExtra("houseNo", this.intent.getStringExtra("houseNo"));
        intent.putExtra("dob", this.dobVerified);
        intent.putExtra("ActualDateOfBirth", this.intent.getStringExtra("dob"));
        intent.putExtra("partSerialNo", this.intent.getStringExtra("serialNo"));
        intent.putExtra("surveyChannel", this.intent.getStringExtra("surveyChannel"));
        intent.putExtra("bloOverridenFlg", this.intent.getStringExtra("bloOverridenFlg"));
        intent.putExtra("radio_choice", this.selectedText);
        intent.putExtra("dobverified", this.dobVerified);
        intent.putExtra("isRelative2003", this.binding.relative2003Yes.isChecked() ? "Y" : "N");
        intent.putExtra("relationList8Code", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relationlist8DocS)) ? "" : this.relationlist8DocS);
        intent.putExtra("relationList8DocPage1", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) ? "" : this.relativeSupportingDocumentPage1UrlS);
        intent.putExtra("relationList8DocPage2", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) ? "" : this.relativeSupportingDocumentPage2UrlS);
        intent.putExtra("relationCode", this.binding.relative2003Yes.isChecked() ? this.relationCode : "");
        intent.putExtra("relationProofDocPage1", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeDocument1UrlS)) ? "" : this.relativeDocument1UrlS);
        intent.putExtra("relationProofDocPage2", (!this.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(this.relativeDocument2UrlS)) ? "" : this.relativeDocument2UrlS);
        intent.putExtra("relationOldAcNo", this.binding.relative2003Yes.isChecked() ? this.oldAc : "");
        intent.putExtra("relationOldStateCd", this.binding.relative2003Yes.isChecked() ? this.releationstate : "");
        intent.putExtra("relationOldPartNo", this.binding.relative2003Yes.isChecked() ? this.OldPart : "");
        intent.putExtra("relationOldPSLNo", this.binding.relative2003Yes.isChecked() ? this.binding.oldPslNo.getText().toString() : "");
        intent.putExtra("relativeEpic", this.binding.edtRelativeEpic.getText().toString());
        intent.putExtra("isThisYouRel", this.isThisYouRel ? "Y" : "N");
        intent.putExtra("isThisYou", this.isThisYou);
        if (!str.equalsIgnoreCase(stringExtra2)) {
            stringExtra = "";
            intent.putExtra("oldAcNo", stringExtra);
            intent.putExtra("oldPartNo", stringExtra);
            intent.putExtra("oldPslNo", stringExtra);
            intent.putExtra("oldStateCd", stringExtra);
            intent.putExtra("list6DocUrl", stringExtra);
            intent.putExtra("list7DocUrl", stringExtra);
            intent.putExtra("list8DocUrl", stringExtra);
            intent.putExtra("list6DocUrlPg2", stringExtra);
            intent.putExtra("list7DocUrlPg2", stringExtra);
            intent.putExtra("list8DocUrlPg2", stringExtra);
            intent.putExtra("list6Doc", stringExtra);
            intent.putExtra("list7Doc", stringExtra);
            intent.putExtra("list8Doc", stringExtra);
            intent.putExtra("preRevisionVoterFlg", stringExtra);
            intent.putExtra("preRevisionVoterDocUrl", stringExtra);
            intent.putExtra("peRevisionVoterDocUrlPg2", stringExtra);
            intent.putExtra("list1Doc", stringExtra);
            intent.putExtra("list3Doc", stringExtra);
            intent.putExtra("list4Doc", stringExtra);
            intent.putExtra("list5Doc", stringExtra);
            intent.putExtra("list1DocUrl", stringExtra);
            intent.putExtra("list3DocUrl", stringExtra);
            intent.putExtra("list4DocUrl", stringExtra);
            intent.putExtra("list5DocUrl", stringExtra);
            intent.putExtra("list1DocUrlPg2", stringExtra);
            intent.putExtra("list3DocUrlPg2", stringExtra);
            intent.putExtra("list4DocUrlPg2", stringExtra);
            intent.putExtra("list5DocUrlPg2", stringExtra);
            intent.putExtra("list5DocUrlPg3", stringExtra);
            intent.putExtra("fathersNationality", stringExtra);
            intent.putExtra("mothersNationality", stringExtra);
            intent.putExtra("citizenshipTypeCat", stringExtra);
            formDataForBloModificationPage1 = this;
        } else {
            intent.putExtra("oldAcNo", this.intent.getStringExtra("oldAcNo") == null ? "" : this.intent.getStringExtra("oldAcNo"));
            intent.putExtra("oldPartNo", this.intent.getStringExtra("oldPartNo") == null ? "" : this.intent.getStringExtra("oldPartNo"));
            intent.putExtra("oldPslNo", this.intent.getStringExtra("oldPslNo") == null ? "" : this.intent.getStringExtra("oldPslNo"));
            intent.putExtra("oldStateCd", this.intent.getStringExtra("oldStateCd") == null ? "" : this.intent.getStringExtra("oldStateCd"));
            intent.putExtra("moldAcNo", this.intent.getStringExtra("moldAcNo") == null ? "" : this.intent.getStringExtra("moldAcNo"));
            intent.putExtra("moldPartNo", this.intent.getStringExtra("moldPartNo") == null ? "" : this.intent.getStringExtra("moldPartNo"));
            intent.putExtra("moldPslNo", this.intent.getStringExtra("moldPslNo") == null ? "" : this.intent.getStringExtra("moldPslNo"));
            intent.putExtra("foldAcNo", this.intent.getStringExtra("foldAcNo") == null ? "" : this.intent.getStringExtra("foldAcNo"));
            intent.putExtra("foldPartNo", this.intent.getStringExtra("foldPartNo") == null ? "" : this.intent.getStringExtra("foldPartNo"));
            intent.putExtra("foldPslNo", this.intent.getStringExtra("foldPslNo") == null ? "" : this.intent.getStringExtra("foldPslNo"));
            intent.putExtra("list6DocUrl", this.intent.getStringExtra("list6DocUrl") == null ? "" : this.intent.getStringExtra("list6DocUrl"));
            intent.putExtra("list7DocUrl", this.intent.getStringExtra("list7DocUrl") == null ? "" : this.intent.getStringExtra("list7DocUrl"));
            intent.putExtra("list8DocUrl", this.intent.getStringExtra("list8DocUrl") == null ? "" : this.intent.getStringExtra("list8DocUrl"));
            intent.putExtra("list6DocUrlPg2", this.intent.getStringExtra("list6DocUrlPg2") == null ? "" : this.intent.getStringExtra("list6DocUrlPg2"));
            intent.putExtra("list7DocUrlPg2", this.intent.getStringExtra("list7DocUrlPg2") == null ? "" : this.intent.getStringExtra("list7DocUrlPg2"));
            intent.putExtra("list8DocUrlPg2", this.intent.getStringExtra("list8DocUrlPg2") == null ? "" : this.intent.getStringExtra("list8DocUrlPg2"));
            intent.putExtra("list6Doc", this.intent.getStringExtra("list6Doc") == null ? "" : this.intent.getStringExtra("list6Doc"));
            intent.putExtra("list7Doc", this.intent.getStringExtra("list7Doc") == null ? "" : this.intent.getStringExtra("list7Doc"));
            intent.putExtra("list8Doc", this.intent.getStringExtra("list8Doc") == null ? "" : this.intent.getStringExtra("list8Doc"));
            intent.putExtra("preRevisionVoterFlg", this.intent.getStringExtra("preRevisionVoterFlg") == null ? "" : this.intent.getStringExtra("preRevisionVoterFlg"));
            intent.putExtra("preRevisionVoterDocUrl", this.intent.getStringExtra("preRevisionVoterDocUrl") == null ? "" : this.intent.getStringExtra("preRevisionVoterDocUrl"));
            intent.putExtra("peRevisionVoterDocUrlPg2", this.intent.getStringExtra("peRevisionVoterDocUrlPg2") == null ? "" : this.intent.getStringExtra("peRevisionVoterDocUrlPg2"));
            intent.putExtra("list1Doc", this.intent.getStringExtra("list1Doc") == null ? "" : this.intent.getStringExtra("list1Doc"));
            intent.putExtra("list3Doc", this.intent.getStringExtra("list3Doc") == null ? "" : this.intent.getStringExtra("list3Doc"));
            intent.putExtra("list4Doc", this.intent.getStringExtra("list4Doc") == null ? "" : this.intent.getStringExtra("list4Doc"));
            intent.putExtra("list5Doc", this.intent.getStringExtra("list5Doc") == null ? "" : this.intent.getStringExtra("list5Doc"));
            intent.putExtra("list1DocUrl", this.intent.getStringExtra("list1DocUrl") == null ? "" : this.intent.getStringExtra("list1DocUrl"));
            intent.putExtra("list3DocUrl", this.intent.getStringExtra("list3DocUrl") == null ? "" : this.intent.getStringExtra("list3DocUrl"));
            intent.putExtra("list4DocUrl", this.intent.getStringExtra("list4DocUrl") == null ? "" : this.intent.getStringExtra("list4DocUrl"));
            intent.putExtra("list5DocUrl", this.intent.getStringExtra("list5DocUrl") == null ? "" : this.intent.getStringExtra("list5DocUrl"));
            intent.putExtra("list1DocUrlPg2", this.intent.getStringExtra("list1DocUrlPg2") == null ? "" : this.intent.getStringExtra("list1DocUrlPg2"));
            intent.putExtra("list3DocUrlPg2", this.intent.getStringExtra("list3DocUrlPg2") == null ? "" : this.intent.getStringExtra("list3DocUrlPg2"));
            intent.putExtra("list4DocUrlPg2", this.intent.getStringExtra("list4DocUrlPg2") == null ? "" : this.intent.getStringExtra("list4DocUrlPg2"));
            intent.putExtra("list5DocUrlPg2", this.intent.getStringExtra("list5DocUrlPg2") == null ? "" : this.intent.getStringExtra("list5DocUrlPg2"));
            intent.putExtra("list5DocUrlPg3", this.intent.getStringExtra("list5DocUrlPg3") == null ? "" : this.intent.getStringExtra("list5DocUrlPg3"));
            intent.putExtra("fathersNationality", this.intent.getStringExtra("fathersNationality") == null ? "" : this.intent.getStringExtra("fathersNationality"));
            intent.putExtra("mothersNationality", this.intent.getStringExtra("mothersNationality") == null ? "" : this.intent.getStringExtra("mothersNationality"));
            intent.putExtra("citizenshipTypeCat", this.intent.getStringExtra("citizenshipTypeCat") == null ? "" : this.intent.getStringExtra("citizenshipTypeCat"));
            formDataForBloModificationPage1 = this;
            stringExtra = "";
        }
        if (formDataForBloModificationPage1.intent.getStringExtra("createdBy") != null) {
            stringExtra = formDataForBloModificationPage1.intent.getStringExtra("createdBy");
        }
        intent.putExtra("createdByFlag", stringExtra);
        formDataForBloModificationPage1.startActivity(intent);
    }

    public boolean validate() {
        this.dob = this.binding.dateOfBirth.getText().toString();
        this.aadhar = this.binding.aadharNumber.getText().toString();
        this.mobile = this.binding.mobileNumber.getText().toString();
        this.fatherName = this.binding.fatherName.getText().toString();
        this.fatherEpicNo = this.binding.fatherEpicNumber.getText().toString();
        this.motherName = this.binding.motherName.getText().toString();
        this.motherEpicNo = this.binding.motherEpicNumber.getText().toString();
        this.spouseName = this.binding.spouseName.getText().toString();
        this.spouseEpicNo = this.binding.spouseEpicNumber.getText().toString();
        this.selectedId = this.binding.selectDetails.getCheckedRadioButtonId();
        int checkedRadioButtonId = this.binding.relative2003RG.getCheckedRadioButtonId();
        try {
            String string = this.binding.dateOfBirth.getText().toString();
            this.dobVerified = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(string));
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
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
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.releationstate)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_OldStateError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.oldAc)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_OldAcError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.OldPart)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPartNoError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.binding.oldPslNo.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPSLError));
            return false;
        }
        if (this.binding.relative2003Yes.isChecked() && !this.issearchdetailsbuttonclicked) {
            showDialog1(this.alertText, getString(R.string.validate_eroll_details));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.relationCode)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_spinnerErroe));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && this.isThisYouRel && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_proof_2003));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && !this.isThisYouRel && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_proof_2003));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && !this.isThisYouRel && TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_supporting_proof_2003));
            return false;
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) && TextUtils.isEmpty(this.srFormPage1UrlS)) {
            showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if (!TextUtils.isEmpty(this.annexureCUrlS) || !TextUtils.isEmpty(this.srFormPage2UrlS)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.uploadBackPageMsg));
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0226  */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean submit() {
        String str;
        FormDataForBloModificationPage1 formDataForBloModificationPage1 = this;
        String string = formDataForBloModificationPage1.binding.dateOfBirth.getText().toString();
        String string2 = formDataForBloModificationPage1.binding.aadharNumber.getText().toString();
        String string3 = formDataForBloModificationPage1.binding.mobileNumber.getText().toString();
        String string4 = formDataForBloModificationPage1.binding.fatherName.getText().toString();
        String string5 = formDataForBloModificationPage1.binding.fatherEpicNumber.getText().toString();
        String string6 = formDataForBloModificationPage1.binding.motherName.getText().toString();
        String string7 = formDataForBloModificationPage1.binding.motherEpicNumber.getText().toString();
        String string8 = formDataForBloModificationPage1.binding.spouseName.getText().toString();
        String string9 = formDataForBloModificationPage1.binding.spouseEpicNumber.getText().toString();
        int checkedRadioButtonId = formDataForBloModificationPage1.binding.selectDetails.getCheckedRadioButtonId();
        try {
            formDataForBloModificationPage1.dobVerified = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(formDataForBloModificationPage1.binding.dateOfBirth.getText().toString()));
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
        }
        if (!TextUtils.isEmpty(string2) && string2.length() < 12) {
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, formDataForBloModificationPage1.getString(R.string.invalidAadharMsg2));
            return false;
        }
        if (!TextUtils.isEmpty(string3) && string3.length() != 10) {
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, formDataForBloModificationPage1.getString(R.string.incorrecMobileMsg));
            return false;
        }
        if (checkedRadioButtonId == -1) {
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, formDataForBloModificationPage1.getString(R.string.selectAnyOneMsg));
            return false;
        }
        if (TextUtils.isEmpty(formDataForBloModificationPage1.annexureCUrlS) && TextUtils.isEmpty(formDataForBloModificationPage1.srFormPage1UrlS)) {
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, formDataForBloModificationPage1.getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if (TextUtils.isEmpty(formDataForBloModificationPage1.annexureCUrlS) && TextUtils.isEmpty(formDataForBloModificationPage1.srFormPage2UrlS)) {
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, formDataForBloModificationPage1.getString(R.string.uploadBackPageMsg));
            return false;
        }
        formDataForBloModificationPage1.selectedText = ((RadioButton) formDataForBloModificationPage1.findViewById(checkedRadioButtonId)).getText().toString();
        String stringExtra = formDataForBloModificationPage1.intent.getStringExtra("preRevisionVoterFlg");
        if (string != null) {
            try {
                if (string.trim().length() > 0) {
                    formDataForBloModificationPage1.DoB = formDataForBloModificationPage1.simple1.parse(string.trim());
                }
            } catch (ParseException e2) {
                Logger.d("FormDataForBloModificationPage1", e2.toString());
                Logger.d("ReverifyPage1", e2.toString());
            }
        }
        formDataForBloModificationPage1.dateBefore = formDataForBloModificationPage1.simple1.parse("01/07/1987");
        formDataForBloModificationPage1.dateAfter = formDataForBloModificationPage1.simple1.parse("02/12/2004");
        if (TextUtils.isEmpty(formDataForBloModificationPage1.selectedText)) {
            str = "";
        } else {
            if (formDataForBloModificationPage1.selectedText.equalsIgnoreCase(formDataForBloModificationPage1.getString(R.string.indian_citizen_by))) {
                str = "CAT-1";
                stringExtra = "Y";
            } else if (formDataForBloModificationPage1.selectedText.equalsIgnoreCase(formDataForBloModificationPage1.getString(R.string.not_born))) {
                str = "CAT-5";
            } else if (formDataForBloModificationPage1.selectedText.equalsIgnoreCase(formDataForBloModificationPage1.getString(R.string.registration_naturalization))) {
                str = "CAT-6";
            } else if (!formDataForBloModificationPage1.binding.bornInIndia.isChecked()) {
                str = "";
            } else if (formDataForBloModificationPage1.binding.bornBefore1987rb.isChecked()) {
                formDataForBloModificationPage1.selectedText = formDataForBloModificationPage1.binding.bornBefore1987rb.getText().toString();
                str = "CAT-2";
            } else if (formDataForBloModificationPage1.binding.bornBefore2004rb.isChecked()) {
                formDataForBloModificationPage1.selectedText = formDataForBloModificationPage1.binding.bornBefore2004rb.getText().toString();
                str = "CAT-3";
            } else if (formDataForBloModificationPage1.binding.bornAfter2004rb.isChecked()) {
                formDataForBloModificationPage1.selectedText = formDataForBloModificationPage1.binding.bornAfter2004rb.getText().toString();
                str = "CAT-4";
            } else {
                str = "";
            }
            if (formDataForBloModificationPage1.binding.noDocument.getVisibility() == 0 && formDataForBloModificationPage1.selectedText.equalsIgnoreCase(formDataForBloModificationPage1.getString(R.string.no_document_uploaded))) {
                str = "";
            }
            if (formDataForBloModificationPage1.binding.noDocument.getVisibility() == 0 && !formDataForBloModificationPage1.binding.noDocument.isChecked() && TextUtils.isEmpty(str)) {
                formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), formDataForBloModificationPage1.getString(R.string.selectcitizencatmsg));
                return false;
            }
            if (formDataForBloModificationPage1.binding.noDocument.getVisibility() == 8 && TextUtils.isEmpty(str)) {
                formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), formDataForBloModificationPage1.getString(R.string.selectcitizencatmsg));
                return false;
            }
        }
        String str2 = stringExtra;
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", formDataForBloModificationPage1.token);
        map.put("currentRole", "blo");
        map.put("state", formDataForBloModificationPage1.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", formDataForBloModificationPage1.intent.getStringExtra("epic"));
        map2.put("epicId", formDataForBloModificationPage1.epicId);
        map2.put("stCode", formDataForBloModificationPage1.state);
        map2.put("houseNo", formDataForBloModificationPage1.intent.getStringExtra("houseNo"));
        map2.put("dobVerified", formDataForBloModificationPage1.dobVerified);
        map2.put("erollDob", formDataForBloModificationPage1.intent.getStringExtra("dob"));
        map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", formDataForBloModificationPage1.intent.getStringExtra("serialNo"));
        map2.put("createdBy", formDataForBloModificationPage1.intent.getStringExtra("createdBy"));
        map2.put("modifiedDttm", null);
        map2.put("modifiedBy", "BLO");
        map2.put("photoUrl", formDataForBloModificationPage1.photoUrlS);
        map2.put("srFormPage1Url", TextUtils.isEmpty(formDataForBloModificationPage1.srFormPage1UrlS) ? null : formDataForBloModificationPage1.srFormPage1UrlS);
        map2.put("citizenshipType", formDataForBloModificationPage1.selectedText);
        map2.put("citizenshipTypeCat", str);
        map2.put("surveyChannel", formDataForBloModificationPage1.intent.getStringExtra("surveyChannel"));
        String str3 = str;
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
        map2.put("aadharNo", !TextUtils.isEmpty(formDataForBloModificationPage1.aadharNoS) ? formDataForBloModificationPage1.aadharNoS : formDataForBloModificationPage1.aadharref);
        map2.put("mobileNo", string3);
        map2.put("fathersOrGuardianName", string4);
        map2.put("fathersOrGuardianEpicNo", string5);
        map2.put("mothersName", string6);
        map2.put("mothersEpicNo", TextUtils.isEmpty(string7) ? null : string7);
        if (TextUtils.isEmpty(string8)) {
            string8 = null;
        }
        map2.put("spouseName", string8);
        map2.put("spouseEpicNo", TextUtils.isEmpty(string9) ? null : string9);
        map2.put("annexureCUrl", TextUtils.isEmpty(formDataForBloModificationPage1.annexureCUrlS) ? null : formDataForBloModificationPage1.annexureCUrlS);
        map2.put("preRevisionVoterFlg", str2);
        map2.put("preRevisionVoterDocUrl", null);
        map2.put("submittedForRecommendation", formDataForBloModificationPage1.submitFlag);
        map2.put("fathersNationality", "Indian");
        map2.put("mothersNationality", "Indian");
        map2.put("srFormPage2Url", TextUtils.isEmpty(formDataForBloModificationPage1.srFormPage2UrlS) ? null : formDataForBloModificationPage1.srFormPage2UrlS);
        map2.put("oldAcNo", null);
        map2.put("oldStateCd", formDataForBloModificationPage1.intent.getStringExtra("oldStateCd"));
        map2.put("oldPartNo", null);
        map2.put("oldPslNo", null);
        map2.put("list8Doc", null);
        map2.put("moldAcNo", null);
        map2.put("moldPslNo", null);
        map2.put("foldAcNo", null);
        map2.put("foldPartNo", null);
        map2.put("foldPslNo", null);
        map2.put("documentUploadedFlg", "Y");
        map2.put("bloOverridenFlg", formDataForBloModificationPage1.intent.getStringExtra("bloOverridenFlg"));
        map2.put("relationOldStateCd", formDataForBloModificationPage1.releationstate);
        map2.put("relationOldAcNo", formDataForBloModificationPage1.oldAc);
        map2.put("relationOldPartNo", formDataForBloModificationPage1.OldPart);
        map2.put("relationOldPslNo", formDataForBloModificationPage1.binding.oldPslNo.getText().toString());
        map2.put("relationDocType", formDataForBloModificationPage1.relationlist8DocS);
        map2.put("relationDocUrlPg1", formDataForBloModificationPage1.relativeSupportingDocumentPage1UrlS);
        map2.put("relationDocUrlPg2", formDataForBloModificationPage1.relativeSupportingDocumentPage2UrlS);
        map2.put("isRelativePreVoterFlg", formDataForBloModificationPage1.binding.relative2003Yes.isChecked() ? "Y" : "N");
        map2.put("relationProofDocUrlPg1", formDataForBloModificationPage1.relativeDocument1UrlS);
        map2.put("relationProofDocUrlPg2", formDataForBloModificationPage1.relativeDocument2UrlS);
        map2.put("relationType", formDataForBloModificationPage1.relationCode);
        map2.put("relationEpicNo", formDataForBloModificationPage1.binding.edtRelativeEpic.getText().toString());
        map2.put("isThisYouRel", formDataForBloModificationPage1.isThisYouRel ? "Y" : "N");
        Logger.d(formDataForBloModificationPage1.TAG, map2.toString());
        if (formDataForBloModificationPage1.onlineStatus) {
            ((UserClient) ApiClient.getClient(this).create(UserClient.class)).updateSpecialRevision2SIR(map, map2).enqueue(formDataForBloModificationPage1.new AnonymousClass42());
            return true;
        }
        try {
            try {
                formDataForBloModificationPage1.sirDatabaseHelper.SpecialRevisionDao().addSpecialSurveyRevisionDetails(new SpecialSurveyRevisionModel(formDataForBloModificationPage1.epicId, formDataForBloModificationPage1.state, formDataForBloModificationPage1.epicNoS, formDataForBloModificationPage1.intent.getStringExtra("houseNo"), formDataForBloModificationPage1.dobVerified, formDataForBloModificationPage1.intent.getStringExtra("dob"), SharedPref.getInstance(this).getDistrictCode(), formDataForBloModificationPage1.asmblyNO, formDataForBloModificationPage1.partNo, formDataForBloModificationPage1.intent.getStringExtra("serialNo"), "", formDataForBloModificationPage1.intent.getStringExtra("createdBy"), null, "BLO", formDataForBloModificationPage1.photoUrlS, formDataForBloModificationPage1.srFormPage1UrlS, formDataForBloModificationPage1.selectedText, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, formDataForBloModificationPage1.intent.getStringExtra("surveyChannel"), !TextUtils.isEmpty(formDataForBloModificationPage1.aadharNoS) ? formDataForBloModificationPage1.aadharNoS : formDataForBloModificationPage1.aadharref, string3, "", string5, "", TextUtils.isEmpty(string7) ? null : string7, "", TextUtils.isEmpty(string9) ? null : string9, null, str2, null, formDataForBloModificationPage1.submitFlag, "Indian", "Indian", TextUtils.isEmpty(formDataForBloModificationPage1.srFormPage2UrlS) ? null : formDataForBloModificationPage1.srFormPage2UrlS, null, null, null, null, null, null, null, null, null, null, "Y", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, formDataForBloModificationPage1.intent.getStringExtra("bloOverridenFlg"), null, null, null, null, formDataForBloModificationPage1.relationCode, formDataForBloModificationPage1.relationlist8DocS, formDataForBloModificationPage1.relativeSupportingDocumentPage1UrlS, formDataForBloModificationPage1.binding.relative2003Yes.isChecked() ? "Y" : "N", formDataForBloModificationPage1.relativeSupportingDocumentPage2UrlS, formDataForBloModificationPage1.relativeDocument1UrlS, formDataForBloModificationPage1.relativeDocument2UrlS, formDataForBloModificationPage1.oldAc, formDataForBloModificationPage1.OldPart, formDataForBloModificationPage1.binding.oldPslNo.getText().toString(), formDataForBloModificationPage1.binding.edtRelativeEpic.getText().toString(), null, formDataForBloModificationPage1.isThisYouRel ? "Y" : "N", formDataForBloModificationPage1.tabName, formDataForBloModificationPage1.releationstate, formDataForBloModificationPage1.intent.getStringExtra("oldStateCd")));
                formDataForBloModificationPage1 = this;
                formDataForBloModificationPage1.showDialog3("", formDataForBloModificationPage1.getString(R.string.form_saved_successfully));
                WorkManager.getInstance(this).enqueueUniqueWork("SIR_UPLOAD_WORK", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(SirUploadWorker.class).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10L, TimeUnit.SECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
                return true;
            } catch (Exception e3) {
                e = e3;
                formDataForBloModificationPage1 = this;
                Logger.d(formDataForBloModificationPage1.TAG, "Offline" + e);
                formDataForBloModificationPage1.showDialog1("Error", formDataForBloModificationPage1.getString(R.string.something_went_wrong));
                return true;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$42, reason: invalid class name */
    class AnonymousClass42 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass42() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.showDialog3(formDataForBloModificationPage1.alertText, string);
                } else {
                    FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage2.showDialog3("", formDataForBloModificationPage2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("ReverifyPage1", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$42$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Code duplicated, block: B:211:0x0c6b  */
    /* JADX WARN: Code duplicated, block: B:214:0x0c70  */
    /* JADX WARN: Code duplicated, block: B:217:0x0c77 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:220:0x0cc7 A[Catch: Exception -> 0x0ce6, TryCatch #17 {Exception -> 0x0ce6, blocks: (B:218:0x0c79, B:220:0x0cc7, B:221:0x0cce, B:231:0x0d45, B:233:0x0d49, B:235:0x0d66, B:234:0x0d5f, B:240:0x0ded), top: B:290:0x0c79 }] */
    /* JADX WARN: Code duplicated, block: B:228:0x0d2e A[Catch: Exception -> 0x0eb2, TRY_LEAVE, TryCatch #12 {Exception -> 0x0eb2, blocks: (B:226:0x0d17, B:228:0x0d2e, B:237:0x0ddb, B:242:0x0e17, B:244:0x0e1b, B:225:0x0cec), top: B:280:0x0cec }] */
    /* JADX WARN: Code duplicated, block: B:231:0x0d45 A[Catch: Exception -> 0x0ce6, TRY_ENTER, TryCatch #17 {Exception -> 0x0ce6, blocks: (B:218:0x0c79, B:220:0x0cc7, B:221:0x0cce, B:231:0x0d45, B:233:0x0d49, B:235:0x0d66, B:234:0x0d5f, B:240:0x0ded), top: B:290:0x0c79 }] */
    /* JADX WARN: Code duplicated, block: B:233:0x0d49 A[Catch: Exception -> 0x0ce6, TryCatch #17 {Exception -> 0x0ce6, blocks: (B:218:0x0c79, B:220:0x0cc7, B:221:0x0cce, B:231:0x0d45, B:233:0x0d49, B:235:0x0d66, B:234:0x0d5f, B:240:0x0ded), top: B:290:0x0c79 }] */
    /* JADX WARN: Code duplicated, block: B:234:0x0d5f A[Catch: Exception -> 0x0ce6, TryCatch #17 {Exception -> 0x0ce6, blocks: (B:218:0x0c79, B:220:0x0cc7, B:221:0x0cce, B:231:0x0d45, B:233:0x0d49, B:235:0x0d66, B:234:0x0d5f, B:240:0x0ded), top: B:290:0x0c79 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0ddb A[Catch: Exception -> 0x0eb2, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0eb2, blocks: (B:226:0x0d17, B:228:0x0d2e, B:237:0x0ddb, B:242:0x0e17, B:244:0x0e1b, B:225:0x0cec), top: B:280:0x0cec }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0ded A[Catch: Exception -> 0x0ce6, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x0ce6, blocks: (B:218:0x0c79, B:220:0x0cc7, B:221:0x0cce, B:231:0x0d45, B:233:0x0d49, B:235:0x0d66, B:234:0x0d5f, B:240:0x0ded), top: B:290:0x0c79 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0e17 A[Catch: Exception -> 0x0eb2, TRY_ENTER, TryCatch #12 {Exception -> 0x0eb2, blocks: (B:226:0x0d17, B:228:0x0d2e, B:237:0x0ddb, B:242:0x0e17, B:244:0x0e1b, B:225:0x0cec), top: B:280:0x0cec }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0e1b A[Catch: Exception -> 0x0eb2, TRY_LEAVE, TryCatch #12 {Exception -> 0x0eb2, blocks: (B:226:0x0d17, B:228:0x0d2e, B:237:0x0ddb, B:242:0x0e17, B:244:0x0e1b, B:225:0x0cec), top: B:280:0x0cec }] */
    /* JADX WARN: Code duplicated, block: B:247:0x0e3b A[Catch: Exception -> 0x0eb0, TryCatch #0 {Exception -> 0x0eb0, blocks: (B:249:0x0e9d, B:246:0x0e37, B:248:0x0e47, B:247:0x0e3b, B:250:0x0ea1, B:251:0x0eaf), top: B:259:0x0d2c }] */
    /* JADX WARN: Code duplicated, block: B:250:0x0ea1 A[Catch: Exception -> 0x0eb0, TryCatch #0 {Exception -> 0x0eb0, blocks: (B:249:0x0e9d, B:246:0x0e37, B:248:0x0e47, B:247:0x0e3b, B:250:0x0ea1, B:251:0x0eaf), top: B:259:0x0d2c }] */
    /* JADX WARN: Code duplicated, block: B:280:0x0cec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x0c79 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v50 */
    /* JADX WARN: Type inference failed for: r15v51 */
    /* JADX WARN: Type inference failed for: r15v52 */
    /* JADX WARN: Type inference failed for: r15v53 */
    /* JADX WARN: Type inference failed for: r15v54 */
    /* JADX WARN: Type inference failed for: r15v55 */
    /* JADX WARN: Type inference failed for: r15v56 */
    /* JADX WARN: Type inference failed for: r15v57 */
    /* JADX WARN: Type inference failed for: r15v58 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v61 */
    /* JADX WARN: Type inference failed for: r15v62 */
    /* JADX WARN: Type inference failed for: r15v63 */
    /* JADX WARN: Type inference failed for: r15v64 */
    /* JADX WARN: Type inference failed for: r1v210, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v223, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v289, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v302, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v368, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v381, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v447, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v460, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v47, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v502, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v504, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v506, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v508, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v510, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v516, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v11 */
    /* JADX WARN: Type inference failed for: r23v12 */
    /* JADX WARN: Type inference failed for: r23v18 */
    /* JADX WARN: Type inference failed for: r23v19 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v20 */
    /* JADX WARN: Type inference failed for: r23v21 */
    /* JADX WARN: Type inference failed for: r23v22 */
    /* JADX WARN: Type inference failed for: r23v23 */
    /* JADX WARN: Type inference failed for: r23v24 */
    /* JADX WARN: Type inference failed for: r23v25 */
    /* JADX WARN: Type inference failed for: r23v26 */
    /* JADX WARN: Type inference failed for: r23v27 */
    /* JADX WARN: Type inference failed for: r23v28 */
    /* JADX WARN: Type inference failed for: r23v29 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v30 */
    /* JADX WARN: Type inference failed for: r23v31 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v33 */
    /* JADX WARN: Type inference failed for: r23v34 */
    /* JADX WARN: Type inference failed for: r23v35 */
    /* JADX WARN: Type inference failed for: r23v36 */
    /* JADX WARN: Type inference failed for: r23v37 */
    /* JADX WARN: Type inference failed for: r23v38 */
    /* JADX WARN: Type inference failed for: r23v39 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52, types: [int] */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r31v10 */
    /* JADX WARN: Type inference failed for: r31v11 */
    /* JADX WARN: Type inference failed for: r31v12 */
    /* JADX WARN: Type inference failed for: r31v14 */
    /* JADX WARN: Type inference failed for: r31v16 */
    /* JADX WARN: Type inference failed for: r31v17 */
    /* JADX WARN: Type inference failed for: r31v18 */
    /* JADX WARN: Type inference failed for: r31v19 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r31v23 */
    /* JADX WARN: Type inference failed for: r31v27 */
    /* JADX WARN: Type inference failed for: r31v28 */
    /* JADX WARN: Type inference failed for: r31v29 */
    /* JADX WARN: Type inference failed for: r31v3 */
    /* JADX WARN: Type inference failed for: r31v30 */
    /* JADX WARN: Type inference failed for: r31v31 */
    /* JADX WARN: Type inference failed for: r31v32 */
    /* JADX WARN: Type inference failed for: r31v33 */
    /* JADX WARN: Type inference failed for: r31v34 */
    /* JADX WARN: Type inference failed for: r31v35 */
    /* JADX WARN: Type inference failed for: r31v36 */
    /* JADX WARN: Type inference failed for: r31v37 */
    /* JADX WARN: Type inference failed for: r31v38 */
    /* JADX WARN: Type inference failed for: r31v39 */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r31v40 */
    /* JADX WARN: Type inference failed for: r31v41 */
    /* JADX WARN: Type inference failed for: r31v42 */
    /* JADX WARN: Type inference failed for: r31v43 */
    /* JADX WARN: Type inference failed for: r31v44 */
    /* JADX WARN: Type inference failed for: r31v45 */
    /* JADX WARN: Type inference failed for: r31v46 */
    /* JADX WARN: Type inference failed for: r31v47 */
    /* JADX WARN: Type inference failed for: r31v48 */
    /* JADX WARN: Type inference failed for: r31v49 */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r31v6 */
    /* JADX WARN: Type inference failed for: r31v7 */
    /* JADX WARN: Type inference failed for: r31v8 */
    /* JADX WARN: Type inference failed for: r31v9 */
    /* JADX WARN: Type inference failed for: r45v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SuperBaseActivity, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        String str2;
        ?? r15;
        ?? r11;
        ?? r2;
        int i3;
        Exception exc;
        ?? r31;
        Uri saveImagePath;
        File file;
        ?? r32;
        Cursor cursorQuery;
        String[] strArrSplit;
        String str3;
        long j;
        double dRound;
        ?? r23;
        ?? r33;
        ?? r34;
        ?? r24;
        char c;
        Exception exc2;
        ?? r25;
        ?? r16;
        ?? r12;
        Object obj;
        boolean z;
        String str4;
        String[] strArr;
        Uri uri;
        ?? r35;
        ?? r26;
        ?? r17;
        Uri uri2;
        Object obj2;
        Object obj3;
        Uri uri3;
        ?? r13;
        String[] strArr2;
        ?? r27;
        ?? r18;
        ?? r36;
        char c2;
        int i4 = i;
        i4 = i2;
        super.onActivityResult(i, i2, intent);
        char c3 = 'P';
        ?? r37 = 80;
        char c4 = 10001;
        if (i4 != -1) {
            i4 = i4;
            str = "img_";
            str2 = "/";
            r15 = 1;
            r11 = "";
            if (i4 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                this.alertDialog.dismiss();
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
            }
            r2 = 0;
        } else {
            Uri data = i4 == 10001 ? null : intent.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
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
                    String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                    ?? r28 = 1;
                    try {
                        String str5 = strArrSplit2[strArrSplit2.length - 1];
                        if (i4 != 101) {
                            obj = "";
                            str = "img_";
                            str2 = "/";
                            z = true;
                            str4 = str5;
                            strArr = strArrSplit2;
                            uri = data;
                            i4 = i;
                            if (i4 == 102) {
                                long j2 = this.filesize;
                                if (j2 < 1024) {
                                    if (this.onlineStatus) {
                                        r17 = z;
                                        r26 = uri;
                                        r35 = obj;
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                    } else {
                                        r17 = z;
                                        r26 = uri;
                                        r35 = obj;
                                        this.alertDialog.dismiss();
                                        this.srFormPage2UrlS = str4;
                                    }
                                    this.binding.photo2Layout.setVisibility(0);
                                    this.binding.cancelPhoto2Annexure.setVisibility(0);
                                    this.binding.photo2Name.setVisibility(0);
                                    this.binding.photo2Size.setVisibility(0);
                                    this.binding.photo2.setVisibility(0);
                                    ImageView imageView = this.binding.photo2;
                                    byte[] bArr = this.pdfbyteArray;
                                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                    this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadBackPhoto.setEnabled(false);
                                    this.binding.photo2Name.setText(strArr[strArr.length - 1]);
                                    this.binding.photo2Size.setText(this.filesize + getString(R.string.kbMsg));
                                    r17 = z;
                                    r26 = uri;
                                    r35 = obj;
                                } else if (j2 > 2048) {
                                    r17 = z;
                                    r26 = uri;
                                    r35 = obj;
                                    this.binding.photo2Layout.setVisibility(8);
                                    this.binding.cancelPhoto2Annexure.setVisibility(8);
                                    this.binding.photo2Name.setVisibility(8);
                                    this.binding.photo2Size.setVisibility(8);
                                    this.binding.photo2.setVisibility(8);
                                    this.binding.uploadBackPhoto.setEnabled(true);
                                    this.binding.uploadFrontPhoto.setVisibility(0);
                                    this.binding.lvPage1EnumrationChoose.setVisibility(0);
                                    this.binding.uploadBackPhoto.setVisibility(0);
                                    this.binding.lvPage2EnumrationChoose.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                    r17 = z;
                                    r26 = uri;
                                    r35 = obj;
                                } else {
                                    long j3 = j2 / 1024;
                                    this.filesize = j3;
                                    double dRound2 = Math.round(j3 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        r17 = z;
                                        r26 = uri;
                                        r35 = obj;
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.uploadBackPhoto.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r17 = z;
                                        r26 = uri;
                                        r35 = obj;
                                    } else {
                                        if (this.onlineStatus) {
                                            r17 = z;
                                            r26 = uri;
                                            r35 = obj;
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        } else {
                                            r17 = z;
                                            r26 = uri;
                                            r35 = obj;
                                            this.alertDialog.dismiss();
                                            this.srFormPage2UrlS = str4;
                                        }
                                        this.binding.photo2Layout.setVisibility(0);
                                        this.binding.cancelPhoto2Annexure.setVisibility(0);
                                        this.binding.photo2Name.setVisibility(0);
                                        this.binding.photo2Size.setVisibility(0);
                                        this.binding.photo2.setVisibility(0);
                                        ImageView imageView2 = this.binding.photo2;
                                        byte[] bArr2 = this.pdfbyteArray;
                                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                        this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadBackPhoto.setEnabled(false);
                                        this.binding.photo2Name.setText(strArr[strArr.length - 1]);
                                        this.binding.photo2Size.setText(dRound2 + getString(R.string.mbMsg));
                                        r17 = z;
                                        r26 = uri;
                                        r35 = obj;
                                    }
                                }
                            }
                        } else {
                            try {
                                long j4 = this.filesize;
                                try {
                                    if (j4 >= 1024) {
                                        r37 = "";
                                        str = "img_";
                                        str2 = "/";
                                        c4 = 1;
                                        strArr2 = strArrSplit2;
                                        str4 = str5;
                                        r28 = data;
                                        if (j4 > 2048) {
                                            try {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.cancelPhoto1Annexure.setVisibility(8);
                                                this.binding.photo1Name.setVisibility(8);
                                                this.binding.photo1Size.setVisibility(8);
                                                this.binding.photo1.setVisibility(8);
                                                this.binding.uploadFrontPhoto.setEnabled(true);
                                                this.binding.uploadFrontPhoto.setVisibility(0);
                                                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                                                this.binding.uploadBackPhoto.setVisibility(0);
                                                this.binding.lvPage2EnumrationChoose.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                r18 = r37;
                                                r27 = r28;
                                                strArr = strArr2;
                                                i4 = i4;
                                                r35 = r18;
                                                r17 = c4;
                                                r26 = r27;
                                            } catch (Exception e) {
                                                e = e;
                                                exc2 = e;
                                                i4 = i4;
                                                r34 = r37;
                                                c = c4;
                                                r24 = r28;
                                                ?? r14 = r34;
                                                Logger.d(r14, exc2.getMessage());
                                                r12 = r14;
                                                r16 = c;
                                                r25 = r24;
                                                r32 = r34;
                                            }
                                        } else {
                                            try {
                                                long j5 = j4 / 1024;
                                                this.filesize = j5;
                                                double dRound3 = Math.round(j5 * 100.0d) / 100.0d;
                                                if (dRound3 > 2.0d) {
                                                    this.binding.annexPage1Layout.setVisibility(8);
                                                    this.binding.uploadFrontPhoto.setEnabled(true);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                    strArr = strArr2;
                                                    r36 = r37;
                                                    c2 = 1;
                                                } else {
                                                    if (this.onlineStatus) {
                                                        try {
                                                            try {
                                                                r37 = r37;
                                                                c3 = 1;
                                                                c3 = 1;
                                                                strArr = strArr2;
                                                                try {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                                    r37 = r37;
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    i4 = i;
                                                                    r23 = r28;
                                                                    r33 = r37;
                                                                    exc2 = e;
                                                                    c = c3;
                                                                    r24 = r23;
                                                                    r34 = r33;
                                                                    ?? r19 = r34;
                                                                    Logger.d(r19, exc2.getMessage());
                                                                    r12 = r19;
                                                                    r16 = c;
                                                                    r25 = r24;
                                                                    r32 = r34;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                r37 = r37;
                                                                c3 = 1;
                                                                i4 = i;
                                                                r23 = r28;
                                                                r33 = r37;
                                                                exc2 = e;
                                                                c = c3;
                                                                r24 = r23;
                                                                r34 = r33;
                                                                ?? r110 = r34;
                                                                Logger.d(r110, exc2.getMessage());
                                                                r12 = r110;
                                                                r16 = c;
                                                                r25 = r24;
                                                                r32 = r34;
                                                            }
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            c3 = 1;
                                                            i4 = i;
                                                            r23 = r28;
                                                            r33 = r37;
                                                            exc2 = e;
                                                            c = c3;
                                                            r24 = r23;
                                                            r34 = r33;
                                                            ?? r111 = r34;
                                                            Logger.d(r111, exc2.getMessage());
                                                            r12 = r111;
                                                            r16 = c;
                                                            r25 = r24;
                                                            r32 = r34;
                                                            r2 = r25;
                                                            r11 = r12;
                                                            r15 = r16;
                                                            if (i4 != 100) {
                                                                i3 = 10001;
                                                                if (i4 != 10001) {
                                                                    return;
                                                                }
                                                            } else {
                                                                i3 = 10001;
                                                            }
                                                            if (i2 == -1) {
                                                                if (i4 == i3) {
                                                                    saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                                    this.saveImageFileName = str + this.temp + this.jpgTextBaseActivity;
                                                                    file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                                    if (file.exists()) {
                                                                        Log.e("extract", "extract true");
                                                                    }
                                                                    this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                                                                    this.filesize = file.length() / 1024;
                                                                } else {
                                                                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), r2);
                                                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                                    bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                                                                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                                                    this.byteArray = byteArray2;
                                                                    saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray2, 0), this.img, this.temp);
                                                                }
                                                                cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                                if (cursorQuery.getCount() <= 0) {
                                                                    cursorQuery.close();
                                                                    throw new IllegalArgumentException(this.imgmsg);
                                                                }
                                                                cursorQuery.moveToFirst();
                                                                strArrSplit = saveImagePath.getPath().split(str2);
                                                                str3 = strArrSplit[strArrSplit.length - r15];
                                                                j = this.filesize;
                                                                if (j < 1024) {
                                                                    if (this.onlineStatus) {
                                                                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    } else {
                                                                        this.alertDialog.dismiss();
                                                                        this.photoUrlS = str3;
                                                                    }
                                                                    this.binding.passPhotoLayout.setVisibility(0);
                                                                    this.binding.cancel.setVisibility(0);
                                                                    this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadElectorImage.setEnabled(false);
                                                                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                                                                    this.binding.photoSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                    this.binding.photoSize.setVisibility(0);
                                                                    this.binding.photoNameTv2.setVisibility(0);
                                                                    this.binding.image.setVisibility(0);
                                                                    ImageView imageView3 = this.binding.image;
                                                                    byte[] bArr3 = this.byteArray;
                                                                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                                                } else {
                                                                    long j6 = j / 1024;
                                                                    this.filesize = j6;
                                                                    dRound = Math.round(j6 * 100.0d) / 100.0d;
                                                                    if (dRound > 2.0d) {
                                                                        this.binding.passPhotoLayout.setVisibility(8);
                                                                        this.binding.uploadElectorImage.setEnabled(r15);
                                                                        this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.blackColor));
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        if (this.onlineStatus) {
                                                                            faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                        } else {
                                                                            this.alertDialog.dismiss();
                                                                            this.photoUrlS = str3;
                                                                        }
                                                                        this.binding.passPhotoLayout.setVisibility(0);
                                                                        this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadElectorImage.setEnabled(false);
                                                                        this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                                                                        this.binding.photoSize.setText(dRound + getString(R.string.mbMsg));
                                                                        ImageView imageView4 = this.binding.image;
                                                                        byte[] bArr4 = this.byteArray;
                                                                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                                                    }
                                                                    cursorQuery.close();
                                                                }
                                                                cursorQuery = cursorQuery;
                                                                cursorQuery.close();
                                                            }
                                                        }
                                                    } else {
                                                        strArr = strArr2;
                                                        r37 = r37;
                                                        c3 = 1;
                                                        try {
                                                            this.alertDialog.dismiss();
                                                            this.srFormPage1UrlS = str4;
                                                            c3 = c3;
                                                            r37 = r37;
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            i4 = i;
                                                            r23 = r28;
                                                            r33 = r37;
                                                            exc2 = e;
                                                            c = c3;
                                                            r24 = r23;
                                                            r34 = r33;
                                                            ?? r112 = r34;
                                                            Logger.d(r112, exc2.getMessage());
                                                            r12 = r112;
                                                            r16 = c;
                                                            r25 = r24;
                                                            r32 = r34;
                                                        }
                                                    }
                                                    this.binding.annexPage1Layout.setVisibility(0);
                                                    this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                    this.binding.photo1Name.setVisibility(0);
                                                    this.binding.photo1Size.setVisibility(0);
                                                    this.binding.photo1.setVisibility(0);
                                                    ImageView imageView5 = this.binding.photo1;
                                                    byte[] bArr5 = this.pdfbyteArray;
                                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                                    this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadFrontPhoto.setEnabled(false);
                                                    this.binding.photo1Name.setText(strArr[strArr.length - c3]);
                                                    this.binding.photo1Size.setText(dRound3 + getString(R.string.mbMsg));
                                                    c2 = c3;
                                                    r36 = r37;
                                                }
                                                i4 = i;
                                                r17 = c2;
                                                r26 = r28;
                                                r35 = r36;
                                            } catch (Exception e6) {
                                                e = e6;
                                            }
                                        }
                                    } else {
                                        try {
                                            if (this.onlineStatus) {
                                                try {
                                                    Object obj4 = "";
                                                    try {
                                                        str2 = "/";
                                                        str4 = str5;
                                                        str = "img_";
                                                        r13 = 0;
                                                        uri2 = data;
                                                        obj2 = obj4;
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            r37 = obj2;
                                                            r28 = uri2;
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            exc2 = e;
                                                            obj3 = obj2;
                                                            uri3 = uri2;
                                                            c = 1;
                                                            r24 = uri3;
                                                            r34 = obj3;
                                                            ?? r113 = r34;
                                                            Logger.d(r113, exc2.getMessage());
                                                            r12 = r113;
                                                            r16 = c;
                                                            r25 = r24;
                                                            r32 = r34;
                                                        }
                                                    } catch (Exception e8) {
                                                        uri3 = data;
                                                        str = "img_";
                                                        str2 = "/";
                                                        exc2 = e8;
                                                        obj3 = obj4;
                                                        c = 1;
                                                        r24 = uri3;
                                                        r34 = obj3;
                                                        ?? r114 = r34;
                                                        Logger.d(r114, exc2.getMessage());
                                                        r12 = r114;
                                                        r16 = c;
                                                        r25 = r24;
                                                        r32 = r34;
                                                    }
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    uri2 = data;
                                                    obj2 = "";
                                                    str = "img_";
                                                    str2 = "/";
                                                }
                                            } else {
                                                r28 = data;
                                                r37 = "";
                                                str = "img_";
                                                str2 = "/";
                                                r13 = 0;
                                                str4 = str5;
                                                try {
                                                    this.alertDialog.dismiss();
                                                    this.srFormPage1UrlS = str4;
                                                    r37 = r37;
                                                    r28 = r28;
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    c4 = 1;
                                                    exc2 = e;
                                                    i4 = i4;
                                                    r34 = r37;
                                                    c = c4;
                                                    r24 = r28;
                                                    ?? r115 = r34;
                                                    Logger.d(r115, exc2.getMessage());
                                                    r12 = r115;
                                                    r16 = c;
                                                    r25 = r24;
                                                    r32 = r34;
                                                    r2 = r25;
                                                    r11 = r12;
                                                    r15 = r16;
                                                    if (i4 != 100) {
                                                        i3 = 10001;
                                                        if (i4 != 10001) {
                                                            return;
                                                        }
                                                    } else {
                                                        i3 = 10001;
                                                    }
                                                    if (i2 == -1) {
                                                        if (i4 == i3) {
                                                            try {
                                                                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                                this.saveImageFileName = str + this.temp + this.jpgTextBaseActivity;
                                                                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                                if (file.exists()) {
                                                                    Log.e("extract", "extract true");
                                                                }
                                                                this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                                                                this.filesize = file.length() / 1024;
                                                            } catch (Exception e11) {
                                                                exc = e11;
                                                                r31 = r11;
                                                                Logger.d(r31, exc.getMessage());
                                                                return;
                                                            }
                                                        } else {
                                                            try {
                                                                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), r2);
                                                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                                                bitmap3.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream3);
                                                                byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
                                                                this.byteArray = byteArray3;
                                                                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray3, 0), this.img, this.temp);
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                r32 = r11;
                                                                exc = e;
                                                                r31 = r32;
                                                                Logger.d(r31, exc.getMessage());
                                                                return;
                                                            }
                                                        }
                                                        cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                        try {
                                                            if (cursorQuery.getCount() <= 0) {
                                                                cursorQuery.close();
                                                                throw new IllegalArgumentException(this.imgmsg);
                                                            }
                                                            cursorQuery.moveToFirst();
                                                            strArrSplit = saveImagePath.getPath().split(str2);
                                                            str3 = strArrSplit[strArrSplit.length - r15];
                                                            j = this.filesize;
                                                            if (j < 1024) {
                                                                if (this.onlineStatus) {
                                                                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                } else {
                                                                    this.alertDialog.dismiss();
                                                                    this.photoUrlS = str3;
                                                                }
                                                                this.binding.passPhotoLayout.setVisibility(0);
                                                                this.binding.cancel.setVisibility(0);
                                                                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadElectorImage.setEnabled(false);
                                                                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                                                                this.binding.photoSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                this.binding.photoSize.setVisibility(0);
                                                                this.binding.photoNameTv2.setVisibility(0);
                                                                this.binding.image.setVisibility(0);
                                                                ImageView imageView6 = this.binding.image;
                                                                byte[] bArr6 = this.byteArray;
                                                                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                                            } else {
                                                                long j7 = j / 1024;
                                                                this.filesize = j7;
                                                                dRound = Math.round(j7 * 100.0d) / 100.0d;
                                                                if (dRound > 2.0d) {
                                                                    this.binding.passPhotoLayout.setVisibility(8);
                                                                    this.binding.uploadElectorImage.setEnabled(r15);
                                                                    this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.blackColor));
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    if (this.onlineStatus) {
                                                                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    } else {
                                                                        this.alertDialog.dismiss();
                                                                        this.photoUrlS = str3;
                                                                    }
                                                                    this.binding.passPhotoLayout.setVisibility(0);
                                                                    this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadElectorImage.setEnabled(false);
                                                                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                                                                    this.binding.photoSize.setText(dRound + getString(R.string.mbMsg));
                                                                    ImageView imageView7 = this.binding.image;
                                                                    byte[] bArr7 = this.byteArray;
                                                                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                                                                }
                                                                cursorQuery.close();
                                                            }
                                                            cursorQuery = cursorQuery;
                                                            cursorQuery.close();
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            exc = e;
                                                            r31 = r32;
                                                            Logger.d(r31, exc.getMessage());
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                            this.binding.annexPage1Layout.setVisibility(r13);
                                            this.binding.cancelPhoto1Annexure.setVisibility(r13);
                                            this.binding.photo1Name.setVisibility(r13);
                                            this.binding.photo1Size.setVisibility(r13);
                                            this.binding.photo1.setVisibility(r13);
                                            ImageView imageView8 = this.binding.photo1;
                                            byte[] bArr8 = this.pdfbyteArray;
                                            imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, r13, bArr8.length));
                                            this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.uploadFrontPhoto.setEnabled(r13);
                                            strArr2 = strArrSplit2;
                                            c4 = 1;
                                            try {
                                                this.binding.photo1Name.setText(strArr2[strArr2.length - 1]);
                                                this.binding.photo1Size.setText(this.filesize + getString(R.string.kbMsg));
                                                r18 = r37;
                                                r27 = r28;
                                                strArr = strArr2;
                                                i4 = i4;
                                                r35 = r18;
                                                r17 = c4;
                                                r26 = r27;
                                            } catch (Exception e14) {
                                                e = e14;
                                                exc2 = e;
                                                i4 = i4;
                                                r34 = r37;
                                                c = c4;
                                                r24 = r28;
                                                ?? r116 = r34;
                                                Logger.d(r116, exc2.getMessage());
                                                r12 = r116;
                                                r16 = c;
                                                r25 = r24;
                                                r32 = r34;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                            r37 = "";
                                            str = "img_";
                                            str2 = "/";
                                            c4 = 1;
                                            r28 = data;
                                        }
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                r37 = "";
                                str = "img_";
                                str2 = "/";
                                c3 = 1;
                                r28 = data;
                            }
                            r2 = r25;
                            r11 = r12;
                            r15 = r16;
                        }
                        r17 = z;
                        r26 = uri;
                        r35 = obj;
                        if (i4 == 201) {
                            long j8 = this.filesize;
                            if (j8 < 1024) {
                                if (this.onlineStatus) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                } else {
                                    this.alertDialog.dismiss();
                                    this.relativeDocument1UrlS = str4;
                                }
                                this.binding.enumerationFormPage1.setVisibility(0);
                                this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                this.binding.enumerationFormPage1Image.setVisibility(0);
                                ImageView imageView9 = this.binding.enumerationFormPage1Image;
                                byte[] bArr9 = this.pdfbyteArray;
                                imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                                this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                this.binding.enumerationFormPage1ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j8 > 2048) {
                                this.binding.enumerationFormPage1.setVisibility(8);
                                this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                this.binding.enumerationFormPage1Image.setVisibility(8);
                                this.binding.uploadEnumerationFormPage1.setEnabled(r17);
                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                this.binding.linearLayoutPage1Relation.setVisibility(0);
                                this.binding.linearLayoutPage2Relation.setVisibility(0);
                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j9 = j8 / 1024;
                                this.filesize = j9;
                                double dRound4 = Math.round(j9 * 100.0d) / 100.0d;
                                if (dRound4 > 2.0d) {
                                    this.binding.enumerationFormPage1.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage1.setEnabled(r17);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    if (this.onlineStatus) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeDocument1UrlS = str4;
                                    }
                                    this.binding.enumerationFormPage1.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                    ImageView imageView10 = this.binding.enumerationFormPage1Image;
                                    byte[] bArr10 = this.pdfbyteArray;
                                    imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                    this.binding.enumerationFormPage1ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (i4 == 202) {
                            long j10 = this.filesize;
                            if (j10 < 1024) {
                                if (this.onlineStatus) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                } else {
                                    this.alertDialog.dismiss();
                                    this.relativeDocument2UrlS = str4;
                                }
                                this.binding.enumerationFormPage2.setVisibility(0);
                                this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                this.binding.enumerationFormPage2Image.setVisibility(0);
                                ImageView imageView11 = this.binding.enumerationFormPage2Image;
                                byte[] bArr11 = this.pdfbyteArray;
                                imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                                this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                this.binding.enumerationFormPage2ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j10 > 2048) {
                                this.binding.enumerationFormPage2.setVisibility(8);
                                this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                this.binding.uploadEnumerationFormPage2.setEnabled(r17);
                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                this.binding.linearLayoutPage1Relation.setVisibility(0);
                                this.binding.linearLayoutPage2Relation.setVisibility(0);
                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j11 = j10 / 1024;
                                this.filesize = j11;
                                double dRound5 = Math.round(j11 * 100.0d) / 100.0d;
                                if (dRound5 > 2.0d) {
                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage2.setEnabled(r17);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    if (this.onlineStatus) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeDocument2UrlS = str4;
                                    }
                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                    ImageView imageView12 = this.binding.enumerationFormPage2Image;
                                    byte[] bArr12 = this.pdfbyteArray;
                                    imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                    this.binding.enumerationFormPage2ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage2ImageSize.setText(dRound5 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (i4 == 203) {
                            long j12 = this.filesize;
                            if (j12 < 1024) {
                                if (this.onlineStatus) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                } else {
                                    this.alertDialog.dismiss();
                                    this.relativeSupportingDocumentPage1UrlS = str4;
                                }
                                this.binding.supportingDocumentsPage1.setVisibility(0);
                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                ImageView imageView13 = this.binding.supportingDocumentsPage1Image;
                                byte[] bArr13 = this.pdfbyteArray;
                                imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                                this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                this.binding.supportingDocumentsPage1ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j12 > 2048) {
                                this.binding.supportingDocumentsPage1.setVisibility(8);
                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                this.binding.uploadSupportingDocumentsPage1.setEnabled(r17);
                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                this.binding.linearLayoutPage1.setVisibility(0);
                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                this.binding.linearLayoutPage2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j13 = j12 / 1024;
                                this.filesize = j13;
                                double dRound6 = Math.round(j13 * 100.0d) / 100.0d;
                                if (dRound6 > 2.0d) {
                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r17);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    if (this.onlineStatus) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeSupportingDocumentPage1UrlS = str4;
                                    }
                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                    ImageView imageView14 = this.binding.supportingDocumentsPage1Image;
                                    byte[] bArr14 = this.pdfbyteArray;
                                    imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                    this.binding.supportingDocumentsPage1ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage1ImageSize.setText(dRound6 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (i4 == 204) {
                            long j14 = this.filesize;
                            if (j14 < 1024) {
                                if (this.onlineStatus) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                } else {
                                    this.alertDialog.dismiss();
                                    this.relativeSupportingDocumentPage2UrlS = str4;
                                }
                                this.binding.supportingDocumentsPage2.setVisibility(0);
                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                ImageView imageView15 = this.binding.supportingDocumentsPage2Image;
                                byte[] bArr15 = this.pdfbyteArray;
                                imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                                this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                this.binding.supportingDocumentsPage2ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j14 > 2048) {
                                this.binding.supportingDocumentsPage2.setVisibility(8);
                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                this.binding.uploadSupportingDocumentsPage2.setEnabled(r17);
                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                this.binding.linearLayoutPage2.setVisibility(0);
                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                this.binding.linearLayoutPage1.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j15 = j14 / 1024;
                                this.filesize = j15;
                                double dRound7 = Math.round(j15 * 100.0d) / 100.0d;
                                if (dRound7 > 2.0d) {
                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r17);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    if (this.onlineStatus) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                    } else {
                                        this.alertDialog.dismiss();
                                        this.relativeSupportingDocumentPage2UrlS = str4;
                                    }
                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                    ImageView imageView16 = this.binding.supportingDocumentsPage2Image;
                                    byte[] bArr16 = this.pdfbyteArray;
                                    imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                    this.binding.supportingDocumentsPage2ImageName.setText(strArr[strArr.length - (r17 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage2ImageSize.setText(dRound7 + getString(R.string.mbMsg));
                                }
                            }
                        }
                        cursorQuery2.close();
                        r12 = r35;
                        r16 = r17;
                        r25 = r26;
                        r32 = r35;
                    } catch (Exception e18) {
                        e = e18;
                        r33 = "";
                        i4 = i4;
                        str = "img_";
                        str2 = "/";
                        c3 = 1;
                        r23 = data;
                    }
                    r2 = r25;
                    r11 = r12;
                    r15 = r16;
                } catch (Exception e19) {
                    e = e19;
                }
            } catch (Exception e20) {
                e = e20;
                r23 = data;
                r33 = "";
                i4 = i4;
                str = "img_";
                str2 = "/";
                c3 = 1;
            }
            exc2 = e;
            c = c3;
            r24 = r23;
            r34 = r33;
            ?? r117 = r34;
            Logger.d(r117, exc2.getMessage());
            r12 = r117;
            r16 = c;
            r25 = r24;
            r32 = r34;
            r2 = r25;
            r11 = r12;
            r15 = r16;
        }
        if (i4 != 100) {
            i3 = 10001;
            if (i4 != 10001) {
                return;
            }
        } else {
            i3 = 10001;
        }
        if (i2 == -1) {
            if (i4 == i3) {
                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                this.saveImageFileName = str + this.temp + this.jpgTextBaseActivity;
                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                if (file.exists()) {
                    Log.e("extract", "extract true");
                }
                this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                this.filesize = file.length() / 1024;
            } else {
                Bitmap bitmap4 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), r2);
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                bitmap4.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream4);
                byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                this.byteArray = byteArray4;
                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray4, 0), this.img, this.temp);
            }
            cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            strArrSplit = saveImagePath.getPath().split(str2);
            str3 = strArrSplit[strArrSplit.length - r15];
            j = this.filesize;
            if (j < 1024) {
                if (this.onlineStatus) {
                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                } else {
                    this.alertDialog.dismiss();
                    this.photoUrlS = str3;
                }
                this.binding.passPhotoLayout.setVisibility(0);
                this.binding.cancel.setVisibility(0);
                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                this.binding.uploadElectorImage.setEnabled(false);
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                this.binding.photoSize.setText(this.filesize + getString(R.string.kbMsg));
                this.binding.photoSize.setVisibility(0);
                this.binding.photoNameTv2.setVisibility(0);
                this.binding.image.setVisibility(0);
                ImageView imageView17 = this.binding.image;
                byte[] bArr17 = this.byteArray;
                imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
            } else {
                long j16 = j / 1024;
                this.filesize = j16;
                dRound = Math.round(j16 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.passPhotoLayout.setVisibility(8);
                    this.binding.uploadElectorImage.setEnabled(r15);
                    this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.blackColor));
                    showDialog1(this.alertText, this.imgmsg);
                } else {
                    if (this.onlineStatus) {
                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        this.photoUrlS = str3;
                    }
                    this.binding.passPhotoLayout.setVisibility(0);
                    this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.uploadElectorImage.setEnabled(false);
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - r15]);
                    this.binding.photoSize.setText(dRound + getString(R.string.mbMsg));
                    ImageView imageView18 = this.binding.image;
                    byte[] bArr18 = this.byteArray;
                    imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                }
                cursorQuery.close();
            }
            cursorQuery = cursorQuery;
            cursorQuery.close();
        }
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$22(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$22(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        Log.d("File Ref1= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass43(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$43, reason: invalid class name */
    class AnonymousClass43 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass43(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl1).into(FormDataForBloModificationPage1.this.binding.electorImage);
                } else {
                    FormDataForBloModificationPage1.this.binding.electorImage.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.43.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file1 = file;
                            Log.e("GETFILE", "FILE1::" + FormDataForBloModificationPage1.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl1)) {
                    FormDataForBloModificationPage1.this.binding.electorImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$43$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$43$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass44(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$44, reason: invalid class name */
    class AnonymousClass44 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass44(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl2).into(FormDataForBloModificationPage1.this.binding.frontImage);
                } else {
                    FormDataForBloModificationPage1.this.binding.frontImage.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.44.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file2 = file;
                            Log.e("GETFILE", "FILE2::" + FormDataForBloModificationPage1.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl2)) {
                    FormDataForBloModificationPage1.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$44$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$44$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$44$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass45(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$45, reason: invalid class name */
    class AnonymousClass45 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass45(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl3).into(FormDataForBloModificationPage1.this.binding.backImage);
                } else {
                    FormDataForBloModificationPage1.this.binding.backImage.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl3, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.45.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file3 = file;
                            Log.e("GETFILE", "FILE3::" + FormDataForBloModificationPage1.this.file3);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl3)) {
                    FormDataForBloModificationPage1.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$45$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$45$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass46(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$46, reason: invalid class name */
    class AnonymousClass46 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass46(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl4).into(FormDataForBloModificationPage1.this.binding.frontImage);
                } else {
                    FormDataForBloModificationPage1.this.binding.frontImage.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl4, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.46.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file4 = file;
                            Log.e("GETFILE", "FILE4::" + FormDataForBloModificationPage1.this.file4);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl4)) {
                    FormDataForBloModificationPage1.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$46$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$46$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda30
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$23(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$23(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
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
            map2.put("epicNo", this.epicNoS);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass47(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$47, reason: invalid class name */
    class AnonymousClass47 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass47(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v18, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r13 = FormDataForBloModificationPage1.this;
                String str = ((FormDataForBloModificationPage1) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$47$$ExternalSyntheticLambda0
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
                        FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                        formDataForBloModificationPage1.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1.token, this.val$reference, this.val$uploadtype);
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
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photostr)) {
                        FormDataForBloModificationPage1.this.photoUrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1Str)) {
                        FormDataForBloModificationPage1.this.srFormPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2str)) {
                        FormDataForBloModificationPage1.this.srFormPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1strNew)) {
                        FormDataForBloModificationPage1.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2strNew)) {
                        FormDataForBloModificationPage1.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo3strNew)) {
                        FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo4strNew)) {
                        FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.d(FormDataForBloModificationPage1.this.TAG, "Presigned URL : " + strDecryptUrl);
                    UploadWithPreSignedURL.uploadToS3(this.val$filepath + this.val$captureFileName, FormDataForBloModificationPage1.this.mime, strDecryptUrl, null);
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photostr)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photocount = 0;
                FormDataForBloModificationPage1.this.binding.passPhotoLayout.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1Str)) {
                Log.d("Here", "Photo1 Str");
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo1count = 0;
                FormDataForBloModificationPage1.this.binding.annexPage1Layout.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage3 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage3.showDialog1(formDataForBloModificationPage3.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2str)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo2count = 0;
                FormDataForBloModificationPage1.this.binding.photo2Layout.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage4 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage4.showDialog1(formDataForBloModificationPage4.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1strNew)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo1countNew = 0;
                FormDataForBloModificationPage1.this.binding.enumerationFormPage1.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage5 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage5.showDialog1(formDataForBloModificationPage5.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2strNew)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo2countNew = 0;
                FormDataForBloModificationPage1.this.binding.enumerationFormPage2.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage6 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage6.showDialog1(formDataForBloModificationPage6.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo3strNew)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo3countNew = 0;
                FormDataForBloModificationPage1.this.binding.supportingDocumentsPage1.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage7 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage7.showDialog1(formDataForBloModificationPage7.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo4strNew)) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo4countNew = 0;
                FormDataForBloModificationPage1.this.binding.supportingDocumentsPage2.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage8 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage8.showDialog1(formDataForBloModificationPage8.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r2 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$47$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1.this.token = "Bearer " + str8;
            FormDataForBloModificationPage1.this.refreshToken = str9;
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str8);
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.uploadPhoto(str, str2, str3, str4, str5, formDataForBloModificationPage1.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photostr)) {
                if (FormDataForBloModificationPage1.this.photocount < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.photoUrlS)) {
                    FormDataForBloModificationPage1.this.photocount++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photocount = 0;
                    FormDataForBloModificationPage1.this.binding.passPhotoLayout.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadElectorImage.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1Str)) {
                if (FormDataForBloModificationPage1.this.photo1count < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage1UrlS)) {
                    FormDataForBloModificationPage1.this.photo1count++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage3 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photo1count = 0;
                    FormDataForBloModificationPage1.this.binding.annexPage1Layout.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage4 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage4.showDialog1(formDataForBloModificationPage4.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadFrontPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2str)) {
                if (FormDataForBloModificationPage1.this.photo2count < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.srFormPage2UrlS)) {
                    FormDataForBloModificationPage1.this.photo2count++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage5 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photo2count = 0;
                    FormDataForBloModificationPage1.this.binding.photo2Layout.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage6 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage6.showDialog1(formDataForBloModificationPage6.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadBackPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo1strNew)) {
                if (FormDataForBloModificationPage1.this.photo1countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument1UrlS)) {
                    FormDataForBloModificationPage1.this.photo1countNew++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage7 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage7.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photo1countNew = 0;
                    FormDataForBloModificationPage1.this.binding.enumerationFormPage1.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage8 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage8.showDialog1(formDataForBloModificationPage8.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo2strNew)) {
                if (FormDataForBloModificationPage1.this.photo2countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1.this.photo2countNew++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage9 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage9.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage9.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photo2countNew = 0;
                    FormDataForBloModificationPage1.this.binding.enumerationFormPage2.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage10 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage10.showDialog1(formDataForBloModificationPage10.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo3strNew)) {
                if (FormDataForBloModificationPage1.this.photo3countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage1UrlS)) {
                    FormDataForBloModificationPage1.this.photo3countNew++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage11 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage11.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage11.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1.this.photo3countNew = 0;
                    FormDataForBloModificationPage1.this.binding.supportingDocumentsPage1.setVisibility(8);
                    FormDataForBloModificationPage1 formDataForBloModificationPage12 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage12.showDialog1(formDataForBloModificationPage12.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                    FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1.this.photo4strNew)) {
                if (FormDataForBloModificationPage1.this.photo4countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1.this.photo4countNew++;
                    FormDataForBloModificationPage1 formDataForBloModificationPage13 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage13.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage13.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.photo4countNew = 0;
                FormDataForBloModificationPage1.this.binding.supportingDocumentsPage2.setVisibility(8);
                FormDataForBloModificationPage1 formDataForBloModificationPage14 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage14.showDialog1(formDataForBloModificationPage14.alertText, FormDataForBloModificationPage1.this.fileNotFoundMessage);
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.whitecolor));
                FormDataForBloModificationPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(getApplicationContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass48(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$48, reason: invalid class name */
    class AnonymousClass48 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass48(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r13 = FormDataForBloModificationPage1.this;
                String str = ((FormDataForBloModificationPage1) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$48$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage1.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1.token, this.val$reference, this.val$uploadtype);
                return;
            }
            try {
                FormDataForBloModificationPage1.this.binding.passPhotoLayout.setVisibility(8);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setEnabled(true);
                FormDataForBloModificationPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.blackColor));
                new JSONObject(response.errorBody().string());
                FormDataForBloModificationPage1 formDataForBloModificationPage2 = FormDataForBloModificationPage1.this;
                formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.alertText, FormDataForBloModificationPage1.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("ReverifyPage1", e.toString());
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r2 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$48$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1.this.token = "Bearer " + str8;
            FormDataForBloModificationPage1.this.refreshToken = str9;
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str8);
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.faceRecognition(str, str2, str3, str4, str5, formDataForBloModificationPage1.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            FormDataForBloModificationPage1.this.binding.passPhotoLayout.setVisibility(8);
            FormDataForBloModificationPage1.this.binding.uploadElectorImage.setEnabled(true);
            FormDataForBloModificationPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1.this.blackColor));
            Logger.d(" ", t.getMessage());
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.alertText, t.getMessage());
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }
    }

    private void deleteAnnexure(int code) {
        if (code == 102) {
            this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadFrontPhoto.setEnabled(true);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.srFormPage1UrlS = "";
            this.binding.photo1Name.setText("");
            this.binding.firstLL.setVisibility(8);
            this.binding.uploadFrontPhoto.setVisibility(0);
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.fbUploadLL.setVisibility(0);
            if (!TextUtils.isEmpty(this.annexureCUrlS)) {
                this.annexureCUrlS = "";
                this.binding.secondLL.setVisibility(8);
                this.binding.uploadBackPhoto.setVisibility(0);
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS) && TextUtils.isEmpty(this.annexureCUrlS)) {
                this.binding.uploadBackPhoto.setVisibility(0);
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
                this.binding.annexPage1Layout.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.srFormPage1UrlS) && this.binding.annexPage1Layout.getVisibility() == 4) {
                this.binding.annexPage1Layout.setVisibility(8);
            }
        }
        if (code == 103) {
            this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadBackPhoto.setEnabled(true);
            this.binding.photo2Layout.setVisibility(8);
            this.srFormPage2UrlS = "";
            this.binding.photo2Size.setText("");
            this.binding.photo2Name.setText("");
            this.binding.secondLL.setVisibility(8);
            this.binding.uploadBackPhoto.setVisibility(0);
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS) && TextUtils.isEmpty(this.annexureCUrlS)) {
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.annexPage1Layout.setVisibility(8);
            }
            this.binding.fbUploadLL.setVisibility(0);
            this.srFormPage2UrlS = "";
        }
    }

    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(getApplicationContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.retryMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$24(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$24(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$25(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda27
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$26(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$25(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.binding.orText.setVisibility(8);
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$26(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.binding.orText.setVisibility(8);
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$27(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$27(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationList.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
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
            Log.d("Value3", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("Test1= ", "filesize " + this.filesize);
        Logger.d("Test2= ", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2);
    }

    private void setRelationList() {
        this.relationList.add(this.selectRelationType);
        this.relationList.add("Self");
        this.relationList.add("Mother");
        this.relationList.add("Father");
        this.relationList.add("Spouse");
        this.relationList.add("Grand Father");
        this.relationList.add("Grand Mother");
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
            this.binding.enumerationFormPage1.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
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
            this.binding.enumerationFormPage2.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.relativeDocument1UrlS) || this.binding.enumerationFormPage1.getVisibility() != 4) {
                return;
            }
            this.binding.enumerationFormPage1.setVisibility(8);
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
            this.binding.supportingDocumentsPage1.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
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
            this.binding.supportingDocumentsPage2.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) || this.binding.supportingDocumentsPage1.getVisibility() != 4) {
                return;
            }
            this.binding.supportingDocumentsPage1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getRelationDropdown(map).enqueue(new AnonymousClass49());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$49, reason: invalid class name */
    class AnonymousClass49 implements Callback<JsonObject> {
        AnonymousClass49() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
        /* JADX WARN: Type inference failed for: r9v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.payloadData1 = (JsonObject) response.body();
                if (FormDataForBloModificationPage1.this.payloadData1 != null) {
                    JsonArray asJsonArray = FormDataForBloModificationPage1.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage1.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormDataForBloModificationPage1.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormDataForBloModificationPage1.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        if (!FormDataForBloModificationPage1.this.relationNameSpinnerVal.contains(FormDataForBloModificationPage1.this.selectRelationType)) {
                            FormDataForBloModificationPage1.this.relationNameSpinnerVal.add(0, FormDataForBloModificationPage1.this.selectRelationType);
                            FormDataForBloModificationPage1.this.relationCodeSpinnerVal.add(0, null);
                        }
                        ?? r3 = FormDataForBloModificationPage1.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.relationNameSpinnerVal);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        FormDataForBloModificationPage1.this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter);
                        if (FormDataForBloModificationPage1.this.intent.getStringExtra("relationType") == null || FormDataForBloModificationPage1.this.intent.getStringExtra("relationType").equals("")) {
                            FormDataForBloModificationPage1.this.binding.spinnerRelation.setSelection(0);
                        } else {
                            FormDataForBloModificationPage1.this.binding.spinnerRelation.setSelection(FormDataForBloModificationPage1.this.relationCodeSpinnerVal.indexOf(FormDataForBloModificationPage1.this.intent.getStringExtra("relationType")));
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r9 = FormDataForBloModificationPage1.this;
                    commomUtility.getRefreshToken(r9, ((FormDataForBloModificationPage1) r9).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$49$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$49$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str);
                FormDataForBloModificationPage1.this.getRelationTypeDropdown();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent(FormDataForBloModificationPage1.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            Logger.d(FormDataForBloModificationPage1.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass50(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$50, reason: invalid class name */
    class AnonymousClass50 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass50(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl11).into(FormDataForBloModificationPage1.this.binding.frontImageNew);
                } else {
                    FormDataForBloModificationPage1.this.binding.frontImageNew.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl11, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.50.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file11 = file;
                            Log.e("GETFILE", "FILE11::" + FormDataForBloModificationPage1.this.file11);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl11)) {
                    FormDataForBloModificationPage1.this.binding.frontImageNew.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$50$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$50$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$50$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile21(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass51(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$51, reason: invalid class name */
    class AnonymousClass51 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass51(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl21 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl21).into(FormDataForBloModificationPage1.this.binding.backImageNew);
                } else {
                    FormDataForBloModificationPage1.this.binding.backImageNew.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl21, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.51.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file21 = file;
                            Log.e("GETFILE", "FILE21::" + FormDataForBloModificationPage1.this.file21);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl21)) {
                    FormDataForBloModificationPage1.this.binding.backImageNew.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$51$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$51$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$51$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile21(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile31(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass52(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$52, reason: invalid class name */
    class AnonymousClass52 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass52(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl31 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl31).into(FormDataForBloModificationPage1.this.binding.frontImage1);
                } else {
                    FormDataForBloModificationPage1.this.binding.frontImage1.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl31, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.52.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file31 = file;
                            Log.e("GETFILE", "FILE31::" + FormDataForBloModificationPage1.this.file31);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl31)) {
                    FormDataForBloModificationPage1.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$52$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$52$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$52$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile31(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile41(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass53(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$53, reason: invalid class name */
    class AnonymousClass53 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass53(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                if (FormDataForBloModificationPage1.this.alertDialog != null) {
                    FormDataForBloModificationPage1.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1.this.preSignedurl41 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage1.this).load(FormDataForBloModificationPage1.this.preSignedurl41).into(FormDataForBloModificationPage1.this.binding.backImage1);
                } else {
                    FormDataForBloModificationPage1.this.binding.backImage1.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage1.this, R.drawable.blo_pdf_thumbnail));
                    FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
                    formDataForBloModificationPage1.downloadPdfToCache(formDataForBloModificationPage1.preSignedurl41, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.53.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDataForBloModificationPage1.this.file41 = file;
                            Log.e("GETFILE", "FILE41::" + FormDataForBloModificationPage1.this.file41);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage1.this.preSignedurl41)) {
                    FormDataForBloModificationPage1.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1.this;
                    String str = ((FormDataForBloModificationPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$53$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$53$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1.this.alertDialog != null) {
                        FormDataForBloModificationPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
            FormDataForBloModificationPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$53$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1.this.getFile41(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1.this.alertDialog != null) {
                FormDataForBloModificationPage1.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1 formDataForBloModificationPage1 = FormDataForBloModificationPage1.this;
            formDataForBloModificationPage1.showDialog1(formDataForBloModificationPage1.getString(R.string.alertMsg), t.getMessage());
        }
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
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.54
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (FormDataForBloModificationPage1.this.partNameList.isEmpty()) {
                        FormDataForBloModificationPage1.this.partNameList.add(0, FormDataForBloModificationPage1.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        if (partCase.equalsIgnoreCase("case1")) {
                            FormDataForBloModificationPage1.this.partNameList.add(asInt + " - " + asString);
                            FormDataForBloModificationPage1.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = FormDataForBloModificationPage1.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage1.this.binding.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldStateCd) && !TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldPartS) && Integer.parseInt(FormDataForBloModificationPage1.this.relationOldPartS) < FormDataForBloModificationPage1.this.partList.size()) {
                                FormDataForBloModificationPage1.this.binding.oldPartNo.setSelection(Integer.parseInt(FormDataForBloModificationPage1.this.relationOldPartS));
                            }
                            if (!TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldPSLS)) {
                                FormDataForBloModificationPage1.this.binding.oldPslNo.setText(FormDataForBloModificationPage1.this.relationOldPSLS);
                            }
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) "Failed to get Part List", 1).show();
            }
        });
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$29(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$29(String str, pdfDownloadCallback pdfdownloadcallback) {
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

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.55
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    FormDataForBloModificationPage1.this.ACNameList.clear();
                    FormDataForBloModificationPage1.this.ACList.clear();
                    FormDataForBloModificationPage1.this.ACNameList.add(FormDataForBloModificationPage1.this.getString(R.string.select_assembly_constituency));
                    FormDataForBloModificationPage1.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage1.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormDataForBloModificationPage1.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormDataForBloModificationPage1.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = FormDataForBloModificationPage1.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        FormDataForBloModificationPage1.this.binding.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    if (!FormDataForBloModificationPage1.this.relationIs2003.equals("Y") || TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldStateCd) || TextUtils.isEmpty(FormDataForBloModificationPage1.this.relationOldAcS)) {
                        return;
                    }
                    FormDataForBloModificationPage1.this.binding.oldAcNo.setSelection(Integer.parseInt(FormDataForBloModificationPage1.this.relationOldAcS));
                    return;
                }
                Logger.e("AC List error", String.valueOf(response.code()));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    public String getcategoryFromAge(int age) {
        if (age <= 0) {
            return "";
        }
        return AgeCategorizer.getCategory(age);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$$ExternalSyntheticLambda23
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$30(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$30(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.epicNoS.replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.epicNoS.replaceAll("/", "_") + "_voter_photo";
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
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.56
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage1.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldState.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.57
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage1.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.58
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage1.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.59
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage1.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerIR.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1.60
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage1.this.isUserSelected = true;
                return false;
            }
        });
    }

    private void preSelectionOfCat() {
        if (this.lastCheckedId != -1 || Integer.parseInt(this.erollAge) <= 0) {
            return;
        }
        String category = AgeCategorizer.getCategory(Integer.parseInt(this.erollAge));
        this.binding.bornInIndia.setChecked(true);
        this.binding.radioLayout.setVisibility(0);
        if (category.equalsIgnoreCase("Born in India before 1987")) {
            this.binding.bornBefore1987rb.setChecked(true);
            this.citizenshipCat = "CAT-2";
            this.selectedText = category;
            this.lastCheckedId = this.binding.bornBefore1987rb.getId();
            return;
        }
        if (category.equalsIgnoreCase("Born in India between 01.07.1987 and 02.12.2004")) {
            this.binding.bornBefore2004rb.setChecked(true);
            this.citizenshipCat = "CAT-3";
            this.selectedText = category;
            this.lastCheckedId = this.binding.bornBefore2004rb.getId();
            return;
        }
        if (category.equalsIgnoreCase("Born in India after 03.12.2004")) {
            this.binding.bornAfter2004rb.setChecked(true);
            this.citizenshipCat = "CAT-4";
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
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass61(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$61, reason: invalid class name */
    class AnonymousClass61 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass61(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v24, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
        /* JADX WARN: Type inference failed for: r9v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
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
                Logger.d(FormDataForBloModificationPage1.this.TAG, "getEpic : getByEpicForForm : payloadData : " + ((JsonArray) response.body()));
                Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    FormDataForBloModificationPage1.this.isMotherEPICValid = true;
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    FormDataForBloModificationPage1.this.isFatherEPICValid = true;
                    return;
                } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                    FormDataForBloModificationPage1.this.isSpouseEPICValid = true;
                    return;
                } else {
                    if (this.val$from.equalsIgnoreCase("Relative")) {
                        FormDataForBloModificationPage1.this.isRelativeEPICValid = true;
                        return;
                    }
                    return;
                }
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r9 = FormDataForBloModificationPage1.this;
                String str = ((FormDataForBloModificationPage1) r9).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str2 = this.val$epicEditText;
                final String str3 = this.val$from;
                commomUtility.getRefreshToken(r9, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$61$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str4, String str5) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str2, str3, i, str4, str5);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                FormDataForBloModificationPage1.this.binding.motherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                FormDataForBloModificationPage1.this.binding.fatherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                FormDataForBloModificationPage1.this.binding.spouseEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Relative")) {
                FormDataForBloModificationPage1.this.binding.edtRelativeEpic.setText("");
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1.this.messageString);
                Logger.d(FormDataForBloModificationPage1.this.TAG, strOptString);
                Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(FormDataForBloModificationPage1.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) FormDataForBloModificationPage1.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r8 = FormDataForBloModificationPage1.this;
                    Toast.makeText((Context) r8, r8.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(FormDataForBloModificationPage1.this.TAG, FormDataForBloModificationPage1.this.getRefreshTokenText + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                ?? r5 = FormDataForBloModificationPage1.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage1$61$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1.this.token = FormDataForBloModificationPage1.this.bearerText + str3;
            FormDataForBloModificationPage1.this.refreshToken = str4;
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setToken(FormDataForBloModificationPage1.this.bearerText + str3);
            FormDataForBloModificationPage1.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1.this.startActivity(new Intent((Context) FormDataForBloModificationPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(FormDataForBloModificationPage1.this.TAG, t.getMessage());
        }
    }
}
