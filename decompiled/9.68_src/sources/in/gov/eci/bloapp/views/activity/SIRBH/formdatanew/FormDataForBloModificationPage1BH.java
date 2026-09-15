package in.gov.eci.bloapp.views.activity.SIRBH.formdatanew;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormDataForBloModificationPage1BhBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
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
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
public class FormDataForBloModificationPage1BH extends SuperBaseActivity {
    Date DoB;
    ArrayList<String> List8docCode;
    ArrayList<String> List8docName;
    String aadhar;
    String aadharNoS;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    private ActivityFormDataForBloModificationPage1BhBinding binding;
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
    String epicNoS;
    String fatherEpicNo;
    String fatherEpicS;
    String fatherName;
    String fatherNameS;
    protected long filesize;
    Intent intent;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isThisYou;
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
    int radioName;
    String referenceNo;
    private String refreshToken;
    ArrayList<String> relationCodeSpinnerVal;
    ArrayList<String> relationNameSpinnerVal;
    private String rtkband;
    protected String saveImageFileName;
    int selectedId;
    String selectedText;
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
    String filerefphoto = "";
    CommomUtility commomUtility = new CommomUtility();
    String objectStorageString = "objectstorage";
    String TAG = "FormDataForBloModificationPage1BH";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String SESSION = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String noDataString = "No Data Found";
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
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    Gson gson = new GsonBuilder().setLenient().create();
    String selectDocumentType = "";
    String relationCode = "";
    String list8code = "";
    boolean isUserAction = false;
    SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    SimpleDateFormat simple1 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFormDataForBloModificationPage1BhBinding activityFormDataForBloModificationPage1BhBindingInflate = ActivityFormDataForBloModificationPage1BhBinding.inflate(getLayoutInflater());
        this.binding = activityFormDataForBloModificationPage1BhBindingInflate;
        setContentView(activityFormDataForBloModificationPage1BhBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        setRelationList();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
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
        this.citizenshipCat = this.intent.getStringExtra("citizenshipTypeCat");
        this.documentUploadedFlg = this.intent.getStringExtra("documentUploadedFlg");
        this.electorName = this.intent.getStringExtra("electorName");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/YYYY");
        this.relativeDocument1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg1")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg1");
        this.relativeDocument2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg2")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg2");
        this.relativeSupportingDocumentPage1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage1")) ? "" : this.intent.getStringExtra("relationList8DocsPage1");
        this.relativeSupportingDocumentPage2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage2")) ? "" : this.intent.getStringExtra("relationList8DocsPage2");
        this.relationOldAcS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldAcNo")) ? "" : this.intent.getStringExtra("relationOldAcNo");
        this.relationOldPartS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartNo")) ? "" : this.intent.getStringExtra("relationOldPartNo");
        this.relationOldPSLS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartSerialNo")) ? "" : this.intent.getStringExtra("relationOldPartSerialNo");
        this.relationlist8DocS = TextUtils.isEmpty(this.intent.getStringExtra("relationListList8DocCode")) ? "" : this.intent.getStringExtra("relationListList8DocCode");
        this.relationIs2003 = TextUtils.isEmpty(this.intent.getStringExtra("relation2003YesOrNo")) ? "" : this.intent.getStringExtra("relation2003YesOrNo");
        String stringExtra = TextUtils.isEmpty(this.intent.getStringExtra("relationType")) ? "" : this.intent.getStringExtra("relationType");
        this.relationCode = stringExtra;
        if (stringExtra.equalsIgnoreCase("SELF")) {
            this.relationCode = "";
        }
        if (!TextUtils.isEmpty(this.relationOldAcS) && !TextUtils.isEmpty(this.relationOldPartS) && !TextUtils.isEmpty(this.relationOldPSLS)) {
            this.binding.txtVerifyButton.setVisibility(0);
            this.isOldAcNoEntered = true;
            this.isOldPartNoEntered = true;
            this.isOldPartSerialNoEntered = true;
        }
        this.List8docCode = SharedPref.getInstance(this).getList8Code(Constants.LIST8_CODE);
        this.List8docName = SharedPref.getInstance(this).getList8Name(Constants.LIST8_NAME);
        this.relationCodeSpinnerVal = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        this.relationNameSpinnerVal = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List8docName);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameSpinnerVal);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter2);
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
        if (this.relationIs2003.equals("Y")) {
            this.binding.relative2003Yes.setChecked(true);
            this.binding.relative2003LL.setVisibility(0);
            this.binding.oldACSerialPSLNoLL.setVisibility(0);
            this.binding.oldAcNo.setText(this.relationOldAcS);
            this.binding.oldPartNo.setText(this.relationOldPartS);
            this.binding.oldPslNo.setText(this.relationOldPSLS);
            this.binding.layoutChooseRelationType.setVisibility(0);
            this.binding.edtRelativeEpic.setText(this.intent.getStringExtra("relativeEpic"));
            this.binding.layoutVerifyDetails.setVisibility(0);
            this.binding.submitLayout.setVisibility(0);
        } else if (this.relationIs2003.equals("N")) {
            this.binding.relative2003No.setChecked(true);
            this.binding.relative2003Yes.setChecked(false);
            this.binding.layoutChooseRelationType.setVisibility(8);
            this.binding.relative2003LL.setVisibility(8);
            this.binding.oldACSerialPSLNoLL.setVisibility(8);
            this.binding.layoutVerifyDetails.setVisibility(8);
            this.binding.submitLayout.setVisibility(8);
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
            this.commomUtility.getaadhar1(this, this.state, this.token, this.aadharNoS, this.atkband, this.rtkband, "BH", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda27
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
        if (!TextUtils.isEmpty(this.citizenshipTypeS)) {
            if (this.citizenshipCat.equals("CAT-1")) {
                this.binding.indianWithPriorVoterID.setChecked(true);
                this.radioName = R.id.indianWithPriorVoterID;
            } else if (this.citizenshipCat.equals("CAT-2") || this.citizenshipCat.equals("CAT-3") || this.citizenshipCat.equals("CAT-4")) {
                this.binding.bornInIndia.setChecked(true);
                this.radioName = R.id.bornInIndia;
            } else if (this.citizenshipCat.equals("CAT-5")) {
                this.binding.notBornInIndia.setChecked(true);
                this.radioName = R.id.notBornInIndia;
            } else if (this.citizenshipCat.equals("CAT-6")) {
                this.binding.indianCitizen.setChecked(true);
                this.radioName = R.id.indianCitizen;
            }
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
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda9
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$1(datePicker, i, i2, i3);
            }
        };
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(onDateSetListener, time2, time, view);
            }
        });
        this.binding.selectDetails.getCheckedRadioButtonId();
        if (TextUtils.isEmpty(this.photoUrlS)) {
            this.binding.uploadElectorImage.setVisibility(0);
            this.binding.electorImageLL.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.photoUrlS)) {
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
            this.binding.annexPage1Layout.setVisibility(0);
            this.binding.photo1Name.setText(this.annexureCUrlS);
            if (this.annexureCUrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        } else {
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.fbUploadLL.setVisibility(0);
                this.binding.fbImageLL.setVisibility(8);
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.srFormPage1UrlS)) {
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.firstLL.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.uploadBackPhoto.setVisibility(0);
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
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    FormDataForBloModificationPage1BH.this.list8code = "";
                    return;
                }
                int i2 = i - 1;
                if (i2 < 0 || i2 >= FormDataForBloModificationPage1BH.this.List8docName.size()) {
                    return;
                }
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH.list8code = formDataForBloModificationPage1BH.List8docCode.get(i);
                Logger.d(Constants.LIST8_CODE, FormDataForBloModificationPage1BH.this.list8code);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass2());
        this.binding.electorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.frontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.backImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.deleteElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.electorImageLL.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setVisibility(0);
                FormDataForBloModificationPage1BH.this.photoUrlS = "";
            }
        });
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.firstLL.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setVisibility(0);
                FormDataForBloModificationPage1BH.this.binding.fbUploadLL.setVisibility(0);
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage2UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.annexureCUrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setVisibility(8);
                }
                FormDataForBloModificationPage1BH.this.srFormPage1UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.annexureCUrlS)) {
                    return;
                }
                FormDataForBloModificationPage1BH.this.annexureCUrlS = "";
                FormDataForBloModificationPage1BH.this.binding.secondLL.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setVisibility(0);
                FormDataForBloModificationPage1BH.this.binding.annexPage1Layout.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.photo1Name.setText("");
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.secondLL.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setVisibility(0);
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage2UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.annexureCUrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setVisibility(8);
                }
                FormDataForBloModificationPage1BH.this.binding.fbUploadLL.setVisibility(0);
                FormDataForBloModificationPage1BH.this.srFormPage2UrlS = "";
            }
        });
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FormDataForBloModificationPage1BH.this.validate()) {
                    FormDataForBloModificationPage1BH.this.sentDataToNext();
                }
            }
        });
        this.binding.uploadElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.photocount = 0;
                FormDataForBloModificationPage1BH.this.pickFile();
            }
        });
        this.binding.uploadFrontPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.pickPhoto(101, "photo1Form");
            }
        });
        this.binding.uploadBackPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.pickPhoto(102, "FormPhoto2photo1Form");
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.10
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if (FormDataForBloModificationPage1BH.this.binding.bornInIndia.isChecked()) {
                    if (FormDataForBloModificationPage1BH.this.binding.relative2003RG.getCheckedRadioButtonId() != -1 && FormDataForBloModificationPage1BH.this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.binding.dateOfBirth.getText().toString())) {
                        FormDataForBloModificationPage1BH.this.binding.radioLayout.setVisibility(0);
                        return;
                    } else {
                        FormDataForBloModificationPage1BH.this.binding.radioLayout.setVisibility(8);
                        return;
                    }
                }
                FormDataForBloModificationPage1BH.this.uploadFlag = "Y";
                FormDataForBloModificationPage1BH.this.newRadioId = checkedID;
                FormDataForBloModificationPage1BH.this.binding.radioLayout.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.nextButton.setVisibility(0);
                if (FormDataForBloModificationPage1BH.this.binding.relative2003Yes.isChecked()) {
                    FormDataForBloModificationPage1BH.this.binding.submitLayout.setVisibility(0);
                } else {
                    FormDataForBloModificationPage1BH.this.binding.submitLayout.setVisibility(8);
                }
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) && TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLLNew.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.firstLLNew.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
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
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
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
        this.binding.relative2003RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.11
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (FormDataForBloModificationPage1BH.this.binding.relative2003Yes.isChecked()) {
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.relative2003LL.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.oldACSerialPSLNoLL.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.layoutChooseRelationType.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.layoutReletiveEpic.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.submitLayout.setVisibility(0);
                }
                if (FormDataForBloModificationPage1BH.this.binding.relative2003No.isChecked()) {
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.relative2003LL.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.oldACSerialPSLNoLL.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.layoutChooseRelationType.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.layoutReletiveEpic.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.submitLayout.setVisibility(8);
                }
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.pickPhoto(201, "rDP1_");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.pickPhoto(202, "rDP2_");
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.list8code)) {
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.alertText, FormDataForBloModificationPage1BH.this.selectDocumentType);
                } else {
                    FormDataForBloModificationPage1BH.this.pickPhoto(203, "sDP1_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.list8code)) {
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.alertText, FormDataForBloModificationPage1BH.this.selectDocumentType);
                } else {
                    FormDataForBloModificationPage1BH.this.pickPhoto(204, "sDP2_");
                }
            }
        });
        this.binding.deleteFrontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.firstLLNew.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                FormDataForBloModificationPage1BH.this.binding.enumerationFormLayout.setVisibility(0);
                FormDataForBloModificationPage1BH.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.secondLLNew.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                FormDataForBloModificationPage1BH.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                }
                FormDataForBloModificationPage1BH.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.firstLL1.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                FormDataForBloModificationPage1BH.this.binding.supprtingDocumentsLayout.setVisibility(0);
                FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.secondLL1.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                }
                FormDataForBloModificationPage1BH.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$14(view, motionEvent);
            }
        });
        this.binding.spinnerRelation.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.20
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    FormDataForBloModificationPage1BH.this.isUserAction = true;
                }
            }
        });
        this.binding.spinnerRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.21
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage1BH.this.isUserAction) {
                    if (i == 0) {
                        FormDataForBloModificationPage1BH.this.relationCode = "";
                    } else {
                        int i2 = i - 1;
                        if (i2 >= 0 && i2 < FormDataForBloModificationPage1BH.this.relationNameSpinnerVal.size()) {
                            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                            formDataForBloModificationPage1BH.relationCode = formDataForBloModificationPage1BH.relationCodeSpinnerVal.get(i);
                            Logger.d("list1Code", FormDataForBloModificationPage1BH.this.relationCode);
                        }
                    }
                    FormDataForBloModificationPage1BH.this.deletePhoto(201);
                    FormDataForBloModificationPage1BH.this.deletePhoto(202);
                    FormDataForBloModificationPage1BH.this.deletePhoto(203);
                    FormDataForBloModificationPage1BH.this.deletePhoto(204);
                    FormDataForBloModificationPage1BH.this.binding.oldAcNo.setText("");
                    FormDataForBloModificationPage1BH.this.binding.oldPartNo.setText("");
                    FormDataForBloModificationPage1BH.this.binding.oldPslNo.setText("");
                    FormDataForBloModificationPage1BH.this.binding.firstLLNew.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.enumerationFormLayout.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.relativeDocument1UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument2UrlS)) {
                        FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    }
                    FormDataForBloModificationPage1BH.this.binding.secondLLNew.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.relativeDocument2UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument2UrlS)) {
                        FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    }
                    FormDataForBloModificationPage1BH.this.binding.enumerationFormLayout.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.firstLL1.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.binding.supprtingDocumentsLayout.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS)) {
                        FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    }
                    FormDataForBloModificationPage1BH.this.binding.secondLL1.setVisibility(8);
                    FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS = "";
                    if (TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS)) {
                        FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    }
                    FormDataForBloModificationPage1BH.this.binding.supprtingDocumentsLayout.setVisibility(0);
                }
            }
        });
        this.binding.frontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.backImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.frontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.backImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.oldAcNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.22
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (text.toString().trim().length() > 0) {
                    FormDataForBloModificationPage1BH.this.isOldAcNoEntered = true;
                } else {
                    FormDataForBloModificationPage1BH.this.isOldAcNoEntered = false;
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(8);
                }
                if (FormDataForBloModificationPage1BH.this.isOldAcNoEntered && FormDataForBloModificationPage1BH.this.isOldPartNoEntered && FormDataForBloModificationPage1BH.this.isOldPartSerialNoEntered) {
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(0);
                }
            }
        });
        this.binding.oldPartNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.23
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (text.toString().trim().length() > 0) {
                    FormDataForBloModificationPage1BH.this.isOldPartNoEntered = true;
                } else {
                    FormDataForBloModificationPage1BH.this.isOldPartNoEntered = false;
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(8);
                }
                if (FormDataForBloModificationPage1BH.this.isOldAcNoEntered && FormDataForBloModificationPage1BH.this.isOldPartNoEntered && FormDataForBloModificationPage1BH.this.isOldPartSerialNoEntered) {
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(0);
                }
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.24
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (text.toString().trim().length() > 0 && FormDataForBloModificationPage1BH.this.isOldAcNoEntered && FormDataForBloModificationPage1BH.this.isOldPartNoEntered) {
                    FormDataForBloModificationPage1BH.this.isOldPartSerialNoEntered = true;
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(0);
                } else {
                    FormDataForBloModificationPage1BH.this.isOldPartSerialNoEntered = false;
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(8);
                }
                if (FormDataForBloModificationPage1BH.this.isOldAcNoEntered && FormDataForBloModificationPage1BH.this.isOldPartNoEntered && FormDataForBloModificationPage1BH.this.isOldPartSerialNoEntered) {
                    FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(0);
                }
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FormDataForBloModificationPage1BH.this.binding.oldAcNo.getText().toString().trim().length() <= 0 || FormDataForBloModificationPage1BH.this.binding.oldPartNo.getText().toString().trim().length() <= 0 || FormDataForBloModificationPage1BH.this.binding.oldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                FormDataForBloModificationPage1BH.this.binding.relative2003LL.setVisibility(0);
                FormDataForBloModificationPage1BH.this.callVerifyRelativeApi();
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2, reason: invalid class name */
    class AnonymousClass2 implements TextWatcher {
        AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (FormDataForBloModificationPage1BH.this.binding.aadharNumber.getText().toString().length() != 12 || FormDataForBloModificationPage1BH.this.binding.aadharNumber.getText().toString().contains("xx")) {
                return;
            }
            FormDataForBloModificationPage1BH.this.alertDialog.show();
            try {
                String string = FormDataForBloModificationPage1BH.this.binding.aadharNumber.getText().toString();
                FormDataForBloModificationPage1BH.this.result = Verhoeff.validateVerhoeff(string);
                if (!FormDataForBloModificationPage1BH.this.result) {
                    FormDataForBloModificationPage1BH.this.binding.aadharNumber.setText("");
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1("", formDataForBloModificationPage1BH.getString(R.string.invalidAadharMsg2));
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                } else {
                    FormDataForBloModificationPage1BH.this.commomUtility.getaadharref(FormDataForBloModificationPage1BH.this.getApplicationContext(), FormDataForBloModificationPage1BH.this.state, FormDataForBloModificationPage1BH.this.token, FormDataForBloModificationPage1BH.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1BH.this.atkband, FormDataForBloModificationPage1BH.this.rtkband, "UpdateBLOBLAModuleBH", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda0
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

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$5(int i, String str, String str2) {
            if (i == 401) {
                FormDataForBloModificationPage1BH.this.commomUtility.getRefreshToken(FormDataForBloModificationPage1BH.this.getApplicationContext(), FormDataForBloModificationPage1BH.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.invalidaadhar, str2);
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    return;
                } else {
                    FormDataForBloModificationPage1BH.this.aadharref = str2;
                    FormDataForBloModificationPage1BH.this.aadharNoS = "";
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$4();
                        }
                    }, 2000L);
                    return;
                }
            }
            FormDataForBloModificationPage1BH.this.showDialog1(FormDataForBloModificationPage1BH.this.alertText + i, str2);
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$3(int i, String str, String str2) {
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                FormDataForBloModificationPage1BH.this.commomUtility.showMessageOK(FormDataForBloModificationPage1BH.this.getApplicationContext(), FormDataForBloModificationPage1BH.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1BH.this.token = "Bearer " + str;
            FormDataForBloModificationPage1BH.this.refreshToken = str2;
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str);
            FormDataForBloModificationPage1BH.this.commomUtility.getaadharref(FormDataForBloModificationPage1BH.this.getApplicationContext(), FormDataForBloModificationPage1BH.this.state, FormDataForBloModificationPage1BH.this.token, FormDataForBloModificationPage1BH.this.binding.aadharNumber.getText().toString(), FormDataForBloModificationPage1BH.this.atkband, FormDataForBloModificationPage1BH.this.rtkband, "UpdateBLOBLAModuleBH", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda3
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str3, String str4) {
                    this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent(FormDataForBloModificationPage1BH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.invalidaadhar, str2);
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    return;
                } else {
                    FormDataForBloModificationPage1BH.this.aadharref = str2;
                    FormDataForBloModificationPage1BH.this.aadharNoS = "";
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$1();
                        }
                    }, 2000L);
                    return;
                }
            }
            FormDataForBloModificationPage1BH.this.showDialog1(FormDataForBloModificationPage1BH.this.alertText + i, str2);
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        String str;
        if (this.photoUrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.photoUrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.photoUrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        String str;
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && this.srFormPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element2, this.srFormPage1UrlS);
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && !this.srFormPage1UrlS.endsWith(".pdf")) {
            String str2 = this.base64element2;
            if (str2 != null && !str2.isEmpty() && !this.base64element2.equals("null") && (str = this.base64element2) != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.srFormPage1UrlS);
            } else {
                showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
            }
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) || !this.annexureCUrlS.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element4, this.annexureCUrlS);
        } catch (IOException e2) {
            Log.d("Exception in displaying pdf= ", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        String str;
        if (this.srFormPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element3, this.srFormPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element3;
        if (str2 != null && !str2.isEmpty() && !this.base64element3.equals("null") && (str = this.base64element3) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.srFormPage2UrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS) && this.relativeDocument1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element11, this.relativeDocument1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element11;
        if (str2 != null && !str2.isEmpty() && !this.base64element11.equals("null") && (str = this.base64element11) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relativeDocument1UrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS) && this.relativeDocument2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element21, this.relativeDocument2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element21;
        if (str2 != null && !str2.isEmpty() && !this.base64element21.equals("null") && (str = this.base64element21) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relativeDocument2UrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element31, this.relativeSupportingDocumentPage1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element31;
        if (str2 != null && !str2.isEmpty() && !this.base64element31.equals("null") && (str = this.base64element31) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relativeSupportingDocumentPage1UrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS) && this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element41, this.relativeSupportingDocumentPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element41;
        if (str2 != null && !str2.isEmpty() && !this.base64element41.equals("null") && (str = this.base64element41) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relativeSupportingDocumentPage2UrlS);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getDetailsByEroll(Integer.parseInt(this.binding.oldAcNo.getText().toString().trim()), Integer.parseInt(this.binding.oldPartNo.getText().toString().trim()), Integer.parseInt(this.binding.oldPslNo.getText().toString().trim()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.26
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(FormDataForBloModificationPage1BH.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        String strOptString = jSONObject.optString("epic", null);
                        String strOptString2 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString3 = jSONObject.optString(Constants.LAST_NAME, null);
                        String strOptString4 = jSONObject.optString("relativeFName", null);
                        String strOptString5 = jSONObject.optString("relativeLName", null);
                        FormDataForBloModificationPage1BH.this.showVerifyDetailsDialog(strOptString2 + StringUtils.SPACE + strOptString3, strOptString4 + StringUtils.SPACE + strOptString5, jSONObject.optString("relationType", null), strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("ReverifyPage1", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    FormDataForBloModificationPage1BH.this.isThisYou = false;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.alertText, FormDataForBloModificationPage1BH.this.getString(R.string.no_record_found));
                    return;
                }
                FormDataForBloModificationPage1BH.this.isThisYou = false;
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String typeRelation, String epic) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_verify_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtTypeRelation);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtEpic);
        textView.setText(name);
        textView2.setText(relativeName);
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH")) {
                textView3.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH")) {
                textView3.setText("Grand Father");
            } else if (typeRelation.equals("MTHR")) {
                textView3.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F")) {
                textView3.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H")) {
                textView3.setText("Husband");
            } else if (typeRelation.equals("OTHR")) {
                textView3.setText("Other");
            } else {
                textView3.setText(typeRelation);
            }
        }
        textView4.setText(epic);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.relative2003LL.setVisibility(0);
                FormDataForBloModificationPage1BH.this.binding.layoutVerifyDetails.setVisibility(8);
                dialog.cancel();
                FormDataForBloModificationPage1BH.this.isThisYou = true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormDataForBloModificationPage1BH.this.binding.relative2003LL.setVisibility(0);
                dialog.cancel();
                FormDataForBloModificationPage1BH.this.isThisYou = false;
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda20
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda19
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

    /* JADX WARN: Code duplicated, block: B:271:0x0788  */
    /* JADX WARN: Code duplicated, block: B:272:0x078a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
    public void sentDataToNext() {
        String str;
        String str2;
        FormDataForBloModificationPage1BH formDataForBloModificationPage1BH;
        String stringExtra;
        ?? r0 = this;
        Intent intent = new Intent((Context) r0, (Class<?>) FormDataForBloModificationPage2BH.class);
        r0.selectedText = ((RadioButton) r0.findViewById(r0.selectedId)).getText().toString();
        if (r0.binding.indianWithPriorVoterID.isChecked()) {
            r0.selectedText = r0.binding.indianWithPriorVoterID.getText().toString();
        } else if (r0.binding.notBornInIndia.isChecked()) {
            r0.selectedText = r0.binding.notBornInIndia.getText().toString();
        } else if (r0.binding.indianCitizen.isChecked()) {
            r0.selectedText = r0.binding.indianCitizen.getText().toString();
        } else if (r0.binding.bornInIndia.isChecked()) {
            r0.selectedText = r0.binding.bornInIndia.getText().toString();
        }
        String stringExtra2 = r0.intent.getStringExtra("citizenshipTypeCat");
        intent.putExtra("aadharNo", !TextUtils.isEmpty(r0.aadharNoS) ? r0.aadharNoS : r0.aadharref);
        intent.putExtra("mobileNo", r0.mobile);
        intent.putExtra("dobverified", r0.dobVerified);
        intent.putExtra("fatherName", r0.fatherName);
        intent.putExtra("fatherEpic", r0.fatherEpicNo);
        intent.putExtra("motherEpic", r0.motherEpicNo);
        intent.putExtra("motherName", r0.motherName);
        intent.putExtra("spouseName", r0.spouseName);
        intent.putExtra("spouseEpic", r0.spouseEpicNo);
        intent.putExtra("annexure_url", r0.annexureCUrlS);
        intent.putExtra("photo1ref", r0.srFormPage1UrlS);
        intent.putExtra("photo2ref", r0.srFormPage2UrlS);
        intent.putExtra("photo-url", r0.photoUrlS);
        intent.putExtra("annexureCUrl", r0.annexureCUrlS);
        intent.putExtra("epicNo", r0.intent.getStringExtra("epic"));
        intent.putExtra("houseNo", r0.intent.getStringExtra("houseNo"));
        intent.putExtra("dob", r0.dobVerified);
        intent.putExtra("ActualDateOfBirth", r0.intent.getStringExtra("dob"));
        intent.putExtra("partSerialNo", r0.intent.getStringExtra("serialNo"));
        intent.putExtra("surveyChannel", r0.intent.getStringExtra("surveyChannel"));
        intent.putExtra("bloOverridenFlg", r0.intent.getStringExtra("bloOverridenFlg"));
        intent.putExtra("radio_choice", r0.selectedText);
        intent.putExtra("dobverified", r0.dobVerified);
        intent.putExtra("isRelative2003", r0.binding.relative2003Yes.isChecked() ? "Y" : "N");
        intent.putExtra("relationList8Code", (!r0.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(r0.list8code)) ? "" : r0.list8code);
        intent.putExtra("relationList8DocPage1", (!r0.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(r0.relativeSupportingDocumentPage1UrlS)) ? "" : r0.relativeSupportingDocumentPage1UrlS);
        intent.putExtra("relationList8DocPage2", (!r0.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(r0.relativeSupportingDocumentPage2UrlS)) ? "" : r0.relativeSupportingDocumentPage2UrlS);
        intent.putExtra("relationCode", r0.binding.relative2003Yes.isChecked() ? r0.relationCode : "");
        intent.putExtra("relationProofDocPage1", (!r0.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(r0.relativeDocument1UrlS)) ? "" : r0.relativeDocument1UrlS);
        intent.putExtra("relationProofDocPage2", (!r0.binding.relative2003Yes.isChecked() || TextUtils.isEmpty(r0.relativeDocument2UrlS)) ? "" : r0.relativeDocument2UrlS);
        intent.putExtra("relationOldAcNo", r0.binding.relative2003Yes.isChecked() ? r0.binding.oldAcNo.getText().toString() : "");
        intent.putExtra("relationOldPartNo", r0.binding.relative2003Yes.isChecked() ? r0.binding.oldPartNo.getText().toString() : "");
        intent.putExtra("relationOldPSLNo", r0.binding.relative2003Yes.isChecked() ? r0.binding.oldPslNo.getText().toString() : "");
        intent.putExtra("relativeEpic", r0.binding.edtRelativeEpic.getText().toString());
        intent.putExtra("isThisYouRel", r0.isThisYou ? "Y" : "N");
        if (!r0.selectedText.equalsIgnoreCase(r0.getString(R.string.indian_citizen_by)) || !stringExtra2.equals("CAT-1")) {
            str = "list7Doc";
            if ((!r0.selectedText.equalsIgnoreCase(r0.getString(R.string.born_india)) || TextUtils.isEmpty(stringExtra2) || ((!stringExtra2.equals("CAT-2") && !stringExtra2.equals("CAT-3") && !stringExtra2.equals("CAT-4")) || TextUtils.isEmpty(r0.dobVerified) || TextUtils.isEmpty(r0.intent.getStringExtra("dob")) || !r0.dobVerified.equals(r0.intent.getStringExtra("dob")))) && ((!r0.selectedText.equalsIgnoreCase(r0.getString(R.string.born_india)) || !TextUtils.isEmpty(r0.dobVerified) || !TextUtils.isEmpty(r0.intent.getStringExtra("dob")) || (!stringExtra2.equals("CAT-2") && !stringExtra2.equals("CAT-3") && !stringExtra2.equals("CAT-4"))) && ((!r0.selectedText.equalsIgnoreCase(r0.getString(R.string.not_born)) || !stringExtra2.equals("CAT-5")) && (!r0.selectedText.equalsIgnoreCase(r0.getString(R.string.registration_naturalization)) || !stringExtra2.equals("CAT-6"))))) {
                str2 = "";
                intent.putExtra("oldAcNo", str2);
                intent.putExtra("oldPartNo", str2);
                intent.putExtra("oldPslNo", str2);
                intent.putExtra("list6DocUrl", str2);
                intent.putExtra("list7DocUrl", str2);
                intent.putExtra("list8DocUrl", str2);
                intent.putExtra("list6DocUrlPg2", str2);
                intent.putExtra("list7DocUrlPg2", str2);
                intent.putExtra("list8DocUrlPg2", str2);
                intent.putExtra("list6Doc", str2);
                intent.putExtra(str, str2);
                intent.putExtra("list8Doc", str2);
                intent.putExtra("preRevisionVoterFlg", str2);
                intent.putExtra("preRevisionVoterDocUrl", str2);
                intent.putExtra("peRevisionVoterDocUrlPg2", str2);
                intent.putExtra("list1Doc", str2);
                intent.putExtra("list3Doc", str2);
                intent.putExtra("list4Doc", str2);
                intent.putExtra("list5Doc", str2);
                intent.putExtra("list1DocUrl", str2);
                intent.putExtra("list3DocUrl", str2);
                intent.putExtra("list4DocUrl", str2);
                intent.putExtra("list5DocUrl", str2);
                intent.putExtra("list1DocUrlPg2", str2);
                intent.putExtra("list3DocUrlPg2", str2);
                intent.putExtra("list4DocUrlPg2", str2);
                intent.putExtra("list5DocUrlPg2", str2);
                intent.putExtra("list5DocUrlPg3", str2);
                intent.putExtra("fathersNationality", str2);
                intent.putExtra("mothersNationality", str2);
                intent.putExtra("citizenshipTypeCat", str2);
                formDataForBloModificationPage1BH = this;
            }
            if (formDataForBloModificationPage1BH.intent.getStringExtra("createdBy") == null) {
                stringExtra = str2;
            } else {
                stringExtra = formDataForBloModificationPage1BH.intent.getStringExtra("createdBy");
            }
            intent.putExtra("createdByFlag", stringExtra);
            formDataForBloModificationPage1BH.startActivity(intent);
        }
        str = "list7Doc";
        intent.putExtra("oldAcNo", r0.intent.getStringExtra("oldAcNo") == null ? "" : r0.intent.getStringExtra("oldAcNo"));
        intent.putExtra("oldPartNo", r0.intent.getStringExtra("oldPartNo") == null ? "" : r0.intent.getStringExtra("oldPartNo"));
        intent.putExtra("oldPslNo", r0.intent.getStringExtra("oldPslNo") == null ? "" : r0.intent.getStringExtra("oldPslNo"));
        intent.putExtra("moldAcNo", r0.intent.getStringExtra("moldAcNo") == null ? "" : r0.intent.getStringExtra("moldAcNo"));
        intent.putExtra("moldPartNo", r0.intent.getStringExtra("moldPartNo") == null ? "" : r0.intent.getStringExtra("moldPartNo"));
        intent.putExtra("moldPslNo", r0.intent.getStringExtra("moldPslNo") == null ? "" : r0.intent.getStringExtra("moldPslNo"));
        intent.putExtra("foldAcNo", r0.intent.getStringExtra("foldAcNo") == null ? "" : r0.intent.getStringExtra("foldAcNo"));
        intent.putExtra("foldPartNo", r0.intent.getStringExtra("foldPartNo") == null ? "" : r0.intent.getStringExtra("foldPartNo"));
        intent.putExtra("foldPslNo", r0.intent.getStringExtra("foldPslNo") == null ? "" : r0.intent.getStringExtra("foldPslNo"));
        intent.putExtra("list6DocUrl", r0.intent.getStringExtra("list6DocUrl") == null ? "" : r0.intent.getStringExtra("list6DocUrl"));
        intent.putExtra("list7DocUrl", r0.intent.getStringExtra("list7DocUrl") == null ? "" : r0.intent.getStringExtra("list7DocUrl"));
        intent.putExtra("list8DocUrl", r0.intent.getStringExtra("list8DocUrl") == null ? "" : r0.intent.getStringExtra("list8DocUrl"));
        intent.putExtra("list6DocUrlPg2", r0.intent.getStringExtra("list6DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list6DocUrlPg2"));
        intent.putExtra("list7DocUrlPg2", r0.intent.getStringExtra("list7DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list7DocUrlPg2"));
        intent.putExtra("list8DocUrlPg2", r0.intent.getStringExtra("list8DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list8DocUrlPg2"));
        intent.putExtra("list6Doc", r0.intent.getStringExtra("list6Doc") == null ? "" : r0.intent.getStringExtra("list6Doc"));
        String str3 = str;
        intent.putExtra(str3, r0.intent.getStringExtra(str3) == null ? "" : r0.intent.getStringExtra(str3));
        intent.putExtra("list8Doc", r0.intent.getStringExtra("list8Doc") == null ? "" : r0.intent.getStringExtra("list8Doc"));
        intent.putExtra("preRevisionVoterFlg", r0.intent.getStringExtra("preRevisionVoterFlg") == null ? "" : r0.intent.getStringExtra("preRevisionVoterFlg"));
        intent.putExtra("preRevisionVoterDocUrl", r0.intent.getStringExtra("preRevisionVoterDocUrl") == null ? "" : r0.intent.getStringExtra("preRevisionVoterDocUrl"));
        intent.putExtra("peRevisionVoterDocUrlPg2", r0.intent.getStringExtra("peRevisionVoterDocUrlPg2") == null ? "" : r0.intent.getStringExtra("peRevisionVoterDocUrlPg2"));
        intent.putExtra("list1Doc", r0.intent.getStringExtra("list1Doc") == null ? "" : r0.intent.getStringExtra("list1Doc"));
        intent.putExtra("list3Doc", r0.intent.getStringExtra("list3Doc") == null ? "" : r0.intent.getStringExtra("list3Doc"));
        intent.putExtra("list4Doc", r0.intent.getStringExtra("list4Doc") == null ? "" : r0.intent.getStringExtra("list4Doc"));
        intent.putExtra("list5Doc", r0.intent.getStringExtra("list5Doc") == null ? "" : r0.intent.getStringExtra("list5Doc"));
        intent.putExtra("list1DocUrl", r0.intent.getStringExtra("list1DocUrl") == null ? "" : r0.intent.getStringExtra("list1DocUrl"));
        intent.putExtra("list3DocUrl", r0.intent.getStringExtra("list3DocUrl") == null ? "" : r0.intent.getStringExtra("list3DocUrl"));
        intent.putExtra("list4DocUrl", r0.intent.getStringExtra("list4DocUrl") == null ? "" : r0.intent.getStringExtra("list4DocUrl"));
        intent.putExtra("list5DocUrl", r0.intent.getStringExtra("list5DocUrl") == null ? "" : r0.intent.getStringExtra("list5DocUrl"));
        intent.putExtra("list1DocUrlPg2", r0.intent.getStringExtra("list1DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list1DocUrlPg2"));
        intent.putExtra("list3DocUrlPg2", r0.intent.getStringExtra("list3DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list3DocUrlPg2"));
        intent.putExtra("list4DocUrlPg2", r0.intent.getStringExtra("list4DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list4DocUrlPg2"));
        intent.putExtra("list5DocUrlPg2", r0.intent.getStringExtra("list5DocUrlPg2") == null ? "" : r0.intent.getStringExtra("list5DocUrlPg2"));
        intent.putExtra("list5DocUrlPg3", r0.intent.getStringExtra("list5DocUrlPg3") == null ? "" : r0.intent.getStringExtra("list5DocUrlPg3"));
        intent.putExtra("fathersNationality", r0.intent.getStringExtra("fathersNationality") == null ? "" : r0.intent.getStringExtra("fathersNationality"));
        intent.putExtra("mothersNationality", r0.intent.getStringExtra("mothersNationality") == null ? "" : r0.intent.getStringExtra("mothersNationality"));
        intent.putExtra("citizenshipTypeCat", r0.intent.getStringExtra("citizenshipTypeCat") == null ? "" : r0.intent.getStringExtra("citizenshipTypeCat"));
        str2 = "";
        formDataForBloModificationPage1BH = r0;
        if (formDataForBloModificationPage1BH.intent.getStringExtra("createdBy") == null) {
            stringExtra = str2;
        } else {
            stringExtra = formDataForBloModificationPage1BH.intent.getStringExtra("createdBy");
        }
        intent.putExtra("createdByFlag", stringExtra);
        formDataForBloModificationPage1BH.startActivity(intent);
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
        if (this.selectedId == -1) {
            showDialog1(this.alertText, getString(R.string.selectAnyOneMsg));
            return false;
        }
        if (checkedRadioButtonId == -1) {
            showDialog1(this.alertText, getString(R.string.relative_2003_relativeYesNoRadioCheck));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.binding.oldAcNo.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.relative_2003_OldAcError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.binding.oldPartNo.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPartNoError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.binding.oldPslNo.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.relative_2003_oldPSLError));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && TextUtils.isEmpty(this.relationCode)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_spinnerErroe));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && this.isThisYou && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_proof_2003));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && !this.isThisYou && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(this.alertText, getString(R.string.relative_proof_2003));
            return false;
        }
        if (checkedRadioButtonId != -1 && this.binding.relative2003Yes.isChecked() && !this.isThisYou && TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
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

    /* JADX WARN: Code duplicated, block: B:70:0x0215  */
    /* JADX WARN: Code duplicated, block: B:75:0x022d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0239  */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean submit() {
        String str;
        String string = this.binding.dateOfBirth.getText().toString();
        String string2 = this.binding.aadharNumber.getText().toString();
        String string3 = this.binding.mobileNumber.getText().toString();
        String string4 = this.binding.fatherName.getText().toString();
        String string5 = this.binding.fatherEpicNumber.getText().toString();
        String string6 = this.binding.motherName.getText().toString();
        String string7 = this.binding.motherEpicNumber.getText().toString();
        String string8 = this.binding.spouseName.getText().toString();
        String string9 = this.binding.spouseEpicNumber.getText().toString();
        int checkedRadioButtonId = this.binding.selectDetails.getCheckedRadioButtonId();
        try {
            this.dobVerified = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this.binding.dateOfBirth.getText().toString()));
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
        }
        if (!TextUtils.isEmpty(string2) && string2.length() < 12) {
            showDialog1(this.alertText, getString(R.string.invalidAadharMsg2));
            return false;
        }
        if (!TextUtils.isEmpty(string3) && string3.length() != 10) {
            showDialog1(this.alertText, getString(R.string.incorrecMobileMsg));
            return false;
        }
        if (checkedRadioButtonId == -1) {
            showDialog1(this.alertText, getString(R.string.selectAnyOneMsg));
            return false;
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) && TextUtils.isEmpty(this.srFormPage1UrlS)) {
            showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) && TextUtils.isEmpty(this.srFormPage2UrlS)) {
            showDialog1(this.alertText, getString(R.string.uploadBackPageMsg));
            return false;
        }
        if (!this.isThisYou) {
            if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) || !TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                return true;
            }
            showDialog1(this.alertText, getString(R.string.no_relative_doc));
            return false;
        }
        this.selectedText = ((RadioButton) findViewById(checkedRadioButtonId)).getText().toString();
        String stringExtra = this.intent.getStringExtra("preRevisionVoterFlg");
        if (string != null) {
            try {
                if (string.trim().length() > 0) {
                    this.DoB = this.simple1.parse(string.trim());
                }
            } catch (ParseException e2) {
                Logger.d("FormDataPage1BH", e2.toString());
                Logger.d("ReverifyPage1", e2.toString());
            }
        }
        this.dateBefore = this.simple1.parse("01/07/1987");
        this.dateAfter = this.simple1.parse("02/12/2004");
        String str2 = "";
        if (!TextUtils.isEmpty(this.selectedText)) {
            if (this.selectedText.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
                str2 = "CAT-1";
                stringExtra = "Y";
            } else {
                if (this.selectedText.equalsIgnoreCase(getString(R.string.not_born))) {
                    str = "CAT-5";
                } else if (this.selectedText.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                    str = "CAT-6";
                } else if (this.selectedText.equalsIgnoreCase(getString(R.string.born_india)) && !TextUtils.isEmpty(this.dobVerified)) {
                    if (this.DoB.before(this.dateBefore)) {
                        str2 = "CAT-2";
                    } else if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                        str2 = "CAT-3";
                    } else if (this.DoB.after(this.dateAfter)) {
                        str2 = "CAT-4";
                    }
                } else if (this.selectedText.equalsIgnoreCase(getString(R.string.born_india)) && TextUtils.isEmpty(this.dobVerified)) {
                    if (this.binding.selectDetailsBornIndia.getCheckedRadioButtonId() == -1) {
                        showDialog1(getString(R.string.alertMsg), getString(R.string.born_in_india_cat_msg));
                        return false;
                    }
                    if (this.binding.bornBefore1987rb.isChecked()) {
                        str2 = "CAT-2";
                    } else if (this.binding.bornBefore2004rb.isChecked()) {
                        str2 = "CAT-3";
                    } else if (this.binding.bornAfter2004rb.isChecked()) {
                        str2 = "CAT-4";
                    }
                }
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
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
        map2.put("epicNo", this.intent.getStringExtra("epic"));
        map2.put("stCode", this.state);
        map2.put("houseNo", this.intent.getStringExtra("houseNo"));
        map2.put("dobVerified", this.dobVerified);
        map2.put("erollDob", this.intent.getStringExtra("dob"));
        map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", this.intent.getStringExtra("serialNo"));
        map2.put("createdBy", this.intent.getStringExtra("createdBy"));
        map2.put("modifiedDttm", null);
        map2.put("modifiedBy", "BLO");
        map2.put("photoUrl", this.photoUrlS);
        map2.put("srFormPage1Url", TextUtils.isEmpty(this.srFormPage1UrlS) ? null : this.srFormPage1UrlS);
        map2.put("citizenshipType", this.selectedText);
        map2.put("citizenshipTypeCat", str2);
        map2.put("surveyChannel", this.intent.getStringExtra("surveyChannel"));
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
        map2.put("aadharNo", !TextUtils.isEmpty(this.aadharNoS) ? this.aadharNoS : this.aadharref);
        map2.put("mobileNo", string3);
        map2.put("fathersOrGuardianName", string4);
        map2.put("fathersOrGuardianEpicNo", string5);
        map2.put("mothersName", string6);
        if (TextUtils.isEmpty(string7)) {
            string7 = null;
        }
        map2.put("mothersEpicNo", string7);
        if (TextUtils.isEmpty(string8)) {
            string8 = null;
        }
        map2.put("spouseName", string8);
        if (TextUtils.isEmpty(string9)) {
            string9 = null;
        }
        map2.put("spouseEpicNo", string9);
        map2.put("annexureCUrl", TextUtils.isEmpty(this.annexureCUrlS) ? null : this.annexureCUrlS);
        map2.put("preRevisionVoterFlg", stringExtra);
        map2.put("preRevisionVoterDocUrl", null);
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", "Indian");
        map2.put("mothersNationality", "Indian");
        map2.put("srFormPage2Url", TextUtils.isEmpty(this.srFormPage2UrlS) ? null : this.srFormPage2UrlS);
        map2.put("oldAcNo", null);
        map2.put("oldPartNo", null);
        map2.put("oldPslNo", null);
        map2.put("list8Doc", null);
        map2.put("moldAcNo", null);
        map2.put("moldPslNo", null);
        map2.put("foldAcNo", null);
        map2.put("foldPartNo", null);
        map2.put("foldPslNo", null);
        map2.put("documentUploadedFlg", "Y");
        map2.put("bloOverridenFlg", this.intent.getStringExtra("bloOverridenFlg"));
        map2.put("relationOldAcNo", this.binding.oldAcNo.getText().toString());
        map2.put("relationOldPartNo", this.binding.oldPartNo.getText().toString());
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
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).updateSpecialRevision2(map, map2).enqueue(new AnonymousClass29());
        return true;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass29() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.showDialog3(formDataForBloModificationPage1BH.alertText, string);
                } else {
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH2 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH2.showDialog3("", formDataForBloModificationPage1BH2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("ReverifyPage1", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$29$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(Bitmap img, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        touchImageView.setImageBitmap(img);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0521 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:101:0x053a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:102:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:104:0x05c6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:106:0x05cc A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0656  */
    /* JADX WARN: Code duplicated, block: B:109:0x065a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:110:0x06a3 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x06b5 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:113:0x06ce A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0756  */
    /* JADX WARN: Code duplicated, block: B:116:0x075a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0760 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:119:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:121:0x07ee A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0837 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0849 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0862 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:126:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:128:0x08ee A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:130:0x08f4 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:131:0x097e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0982 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:134:0x09cb A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x09dd A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:137:0x09f6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0432 A[Catch: Exception -> 0x0a92, TRY_ENTER, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0438 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:95:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:97:0x04c6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:98:0x050f A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v113, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v156, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v189, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v195, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v208, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v232, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v260, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v266, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v279, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v303, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v331, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v337, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v350, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v374, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v402, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v408, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v421, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v445, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v469, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v47, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v514, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v10 */
    /* JADX WARN: Type inference failed for: r28v13 */
    /* JADX WARN: Type inference failed for: r28v14 */
    /* JADX WARN: Type inference failed for: r28v15 */
    /* JADX WARN: Type inference failed for: r28v16 */
    /* JADX WARN: Type inference failed for: r28v17 */
    /* JADX WARN: Type inference failed for: r28v18 */
    /* JADX WARN: Type inference failed for: r28v19 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v22 */
    /* JADX WARN: Type inference failed for: r28v24 */
    /* JADX WARN: Type inference failed for: r28v25 */
    /* JADX WARN: Type inference failed for: r28v26 */
    /* JADX WARN: Type inference failed for: r28v27 */
    /* JADX WARN: Type inference failed for: r28v28 */
    /* JADX WARN: Type inference failed for: r28v29 */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v30 */
    /* JADX WARN: Type inference failed for: r28v31 */
    /* JADX WARN: Type inference failed for: r28v32 */
    /* JADX WARN: Type inference failed for: r28v33 */
    /* JADX WARN: Type inference failed for: r28v34 */
    /* JADX WARN: Type inference failed for: r28v35 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Type inference failed for: r28v9 */
    /* JADX WARN: Type inference failed for: r2v103, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v115, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v133, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v145, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v163, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v175, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v193, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v206, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v220, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v73, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v85, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r31v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH, in.gov.eci.bloapp.views.activity.SuperBaseActivity] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        ?? r15;
        ?? r28;
        ?? r12;
        Exception exc;
        ?? r29;
        ?? r210;
        Exception exc2;
        ?? r211;
        ?? r16;
        ?? r14;
        long j;
        double dRound;
        long j2;
        double dRound2;
        long j3;
        double dRound3;
        long j4;
        double dRound4;
        boolean z;
        ?? r17;
        int i3 = i;
        int i4 = i2;
        super.onActivityResult(i, i2, intent);
        ?? r18 = "";
        if (i4 != -1) {
            obj = "/";
            Object obj2 = "";
            r15 = 1;
            r15 = 1;
            if (i3 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
                r12 = obj2;
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                this.alertDialog.dismiss();
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
                r12 = obj2;
            }
        } else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
                obj = null;
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    try {
                        if (i3 != 101) {
                            r14 = strArrSplit;
                            obj = "/";
                            r18 = "";
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            i4 = i;
                            if (i4 == 102) {
                                long j5 = this.filesize;
                                try {
                                    if (j5 < 1024) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
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
                                        this.binding.photo2Name.setText(r14[r14.length - 1]);
                                        this.binding.photo2Size.setText(this.filesize + getString(R.string.kbMsg));
                                        r14 = r14;
                                        r18 = r18;
                                    } else if (j5 > 2048) {
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.cancelPhoto2Annexure.setVisibility(8);
                                        this.binding.photo2Name.setVisibility(8);
                                        this.binding.photo2Size.setVisibility(8);
                                        this.binding.photo2.setVisibility(8);
                                        this.binding.uploadBackPhoto.setEnabled(true);
                                        this.binding.uploadFrontPhoto.setVisibility(0);
                                        this.binding.uploadBackPhoto.setVisibility(0);
                                        showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                        r14 = r14;
                                        r18 = r18;
                                    } else {
                                        long j6 = j5 / 1024;
                                        this.filesize = j6;
                                        double dRound5 = Math.round(j6 * 100.0d) / 100.0d;
                                        if (dRound5 > 2.0d) {
                                            this.binding.photo2Layout.setVisibility(8);
                                            this.binding.uploadBackPhoto.setEnabled(true);
                                            showDialog1(this.alertText, this.imgmsg);
                                            r14 = r14;
                                            r18 = r18;
                                        } else {
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
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
                                            this.binding.photo2Name.setText(r14[r14.length - 1]);
                                            this.binding.photo2Size.setText(dRound5 + getString(R.string.mbMsg));
                                            r14 = r14;
                                            r18 = r18;
                                        }
                                    }
                                } catch (Exception e2) {
                                    exc2 = e2;
                                    i3 = i4;
                                    r16 = r18;
                                    r211 = r18;
                                    ?? r13 = r211;
                                    Logger.d(r13, exc2.getMessage());
                                    r12 = r13;
                                    r15 = r16;
                                    r28 = r211;
                                }
                            }
                            i3 = i;
                            if (i3 == 201) {
                                j4 = this.filesize;
                                if (j4 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
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
                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j4 > 2048) {
                                    this.binding.enumerationFormPage1.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage1Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j7 = j4 / 1024;
                                    this.filesize = j7;
                                    dRound4 = Math.round(j7 * 100.0d) / 100.0d;
                                    if (dRound4 > 2.0d) {
                                        this.binding.enumerationFormPage1.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
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
                                        this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 202) {
                                j3 = this.filesize;
                                if (j3 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
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
                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j3 > 2048) {
                                    this.binding.enumerationFormPage2.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j8 = j3 / 1024;
                                    this.filesize = j8;
                                    dRound3 = Math.round(j8 * 100.0d) / 100.0d;
                                    if (dRound3 > 2.0d) {
                                        this.binding.enumerationFormPage2Image.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
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
                                        this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 203) {
                                j2 = this.filesize;
                                if (j2 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
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
                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j2 > 2048) {
                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j9 = j2 / 1024;
                                    this.filesize = j9;
                                    dRound2 = Math.round(j9 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
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
                                        this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 204) {
                                j = this.filesize;
                                if (j < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
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
                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j > 2048) {
                                    this.binding.supportingDocumentsPage2.setVisibility(8);
                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                    this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j10 = j / 1024;
                                    this.filesize = j10;
                                    dRound = Math.round(j10 * 100.0d) / 100.0d;
                                    if (dRound > 2.0d) {
                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
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
                                        this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                    }
                                }
                            }
                            cursorQuery.close();
                            r12 = r18;
                            r15 = r18;
                            r28 = r18;
                        } else {
                            obj = strArrSplit;
                            try {
                                long j11 = this.filesize;
                                try {
                                    if (j11 < 1024) {
                                        try {
                                            try {
                                                ?? r19 = obj;
                                                obj = "/";
                                                try {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                    this.binding.annexPage1Layout.setVisibility(0);
                                                    this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                    this.binding.photo1Name.setVisibility(0);
                                                    this.binding.photo1Size.setVisibility(0);
                                                    this.binding.photo1.setVisibility(0);
                                                    ImageView imageView11 = this.binding.photo1;
                                                    byte[] bArr11 = this.pdfbyteArray;
                                                    imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                                                    this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadFrontPhoto.setEnabled(false);
                                                    z = true;
                                                    try {
                                                        this.binding.photo1Name.setText(r19[r19.length - 1]);
                                                        this.binding.photo1Size.setText(this.filesize + getString(R.string.kbMsg));
                                                        r17 = r19;
                                                        r14 = r17;
                                                        r18 = z;
                                                        i3 = i;
                                                        if (i3 == 201) {
                                                            j4 = this.filesize;
                                                            if (j4 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                this.binding.enumerationFormPage1.setVisibility(0);
                                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                ImageView imageView12 = this.binding.enumerationFormPage1Image;
                                                                byte[] bArr12 = this.pdfbyteArray;
                                                                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                                                                this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j4 > 2048) {
                                                                this.binding.enumerationFormPage1.setVisibility(8);
                                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                                this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                                this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                                this.binding.enumerationFormPage1Image.setVisibility(8);
                                                                this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j12 = j4 / 1024;
                                                                this.filesize = j12;
                                                                dRound4 = Math.round(j12 * 100.0d) / 100.0d;
                                                                if (dRound4 > 2.0d) {
                                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                    ImageView imageView13 = this.binding.enumerationFormPage1Image;
                                                                    byte[] bArr13 = this.pdfbyteArray;
                                                                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 202) {
                                                            j3 = this.filesize;
                                                            if (j3 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                this.binding.enumerationFormPage2.setVisibility(0);
                                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                ImageView imageView14 = this.binding.enumerationFormPage2Image;
                                                                byte[] bArr14 = this.pdfbyteArray;
                                                                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                                                                this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j3 > 2048) {
                                                                this.binding.enumerationFormPage2.setVisibility(8);
                                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                                this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                                this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j13 = j3 / 1024;
                                                                this.filesize = j13;
                                                                dRound3 = Math.round(j13 * 100.0d) / 100.0d;
                                                                if (dRound3 > 2.0d) {
                                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    ImageView imageView15 = this.binding.enumerationFormPage2Image;
                                                                    byte[] bArr15 = this.pdfbyteArray;
                                                                    imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 203) {
                                                            j2 = this.filesize;
                                                            if (j2 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                ImageView imageView16 = this.binding.supportingDocumentsPage1Image;
                                                                byte[] bArr16 = this.pdfbyteArray;
                                                                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                                                                this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j2 > 2048) {
                                                                this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j14 = j2 / 1024;
                                                                this.filesize = j14;
                                                                dRound2 = Math.round(j14 * 100.0d) / 100.0d;
                                                                if (dRound2 > 2.0d) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                    ImageView imageView17 = this.binding.supportingDocumentsPage1Image;
                                                                    byte[] bArr17 = this.pdfbyteArray;
                                                                    imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
                                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 204) {
                                                            j = this.filesize;
                                                            if (j < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                ImageView imageView18 = this.binding.supportingDocumentsPage2Image;
                                                                byte[] bArr18 = this.pdfbyteArray;
                                                                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                                                                this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j > 2048) {
                                                                this.binding.supportingDocumentsPage2.setVisibility(8);
                                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j15 = j / 1024;
                                                                this.filesize = j15;
                                                                dRound = Math.round(j15 * 100.0d) / 100.0d;
                                                                if (dRound > 2.0d) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                    ImageView imageView19 = this.binding.supportingDocumentsPage2Image;
                                                                    byte[] bArr19 = this.pdfbyteArray;
                                                                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, 0, bArr19.length));
                                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        }
                                                        cursorQuery.close();
                                                        r12 = r18;
                                                        r15 = r18;
                                                        r28 = r18;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        exc2 = e;
                                                        r211 = "";
                                                        r16 = z;
                                                        ?? r110 = r211;
                                                        Logger.d(r110, exc2.getMessage());
                                                        r12 = r110;
                                                        r15 = r16;
                                                        r28 = r211;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    z = true;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                obj = "/";
                                                z = true;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            obj = "/";
                                            z = true;
                                        }
                                    } else {
                                        ?? r111 = obj;
                                        z = true;
                                        obj = "/";
                                        if (j11 > 2048) {
                                            try {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.cancelPhoto1Annexure.setVisibility(8);
                                                this.binding.photo1Name.setVisibility(8);
                                                this.binding.photo1Size.setVisibility(8);
                                                this.binding.photo1.setVisibility(8);
                                                this.binding.uploadFrontPhoto.setEnabled(true);
                                                this.binding.uploadFrontPhoto.setVisibility(0);
                                                this.binding.uploadBackPhoto.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                r17 = r111;
                                                r14 = r17;
                                            } catch (Exception e7) {
                                                e = e7;
                                                exc2 = e;
                                                r211 = "";
                                                r16 = z;
                                                ?? r112 = r211;
                                                Logger.d(r112, exc2.getMessage());
                                                r12 = r112;
                                                r15 = r16;
                                                r28 = r211;
                                            }
                                        } else {
                                            try {
                                                long j16 = j11 / 1024;
                                                this.filesize = j16;
                                                double dRound6 = Math.round(j16 * 100.0d) / 100.0d;
                                                if (dRound6 > 2.0d) {
                                                    this.binding.annexPage1Layout.setVisibility(8);
                                                    this.binding.uploadFrontPhoto.setEnabled(true);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                    r14 = r111;
                                                } else {
                                                    try {
                                                        r18 = "";
                                                        r18 = 1;
                                                        r18 = 1;
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            this.binding.annexPage1Layout.setVisibility(0);
                                                            this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                            this.binding.photo1Name.setVisibility(0);
                                                            this.binding.photo1Size.setVisibility(0);
                                                            this.binding.photo1.setVisibility(0);
                                                            ImageView imageView20 = this.binding.photo1;
                                                            byte[] bArr20 = this.pdfbyteArray;
                                                            imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, 0, bArr20.length));
                                                            this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                                            this.binding.uploadFrontPhoto.setEnabled(false);
                                                            this.binding.photo1Name.setText(r111[r111.length - 1]);
                                                            this.binding.photo1Size.setText(dRound6 + getString(R.string.mbMsg));
                                                            r14 = r111;
                                                            r18 = r18;
                                                            i3 = i;
                                                            if (i3 == 201) {
                                                                j4 = this.filesize;
                                                                if (j4 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                    ImageView imageView110 = this.binding.enumerationFormPage1Image;
                                                                    byte[] bArr110 = this.pdfbyteArray;
                                                                    imageView110.setImageBitmap(BitmapFactory.decodeByteArray(bArr110, 0, bArr110.length));
                                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j4 > 2048) {
                                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j17 = j4 / 1024;
                                                                    this.filesize = j17;
                                                                    dRound4 = Math.round(j17 * 100.0d) / 100.0d;
                                                                    if (dRound4 > 2.0d) {
                                                                        this.binding.enumerationFormPage1.setVisibility(8);
                                                                        this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                        this.binding.enumerationFormPage1.setVisibility(0);
                                                                        this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                        this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                        this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                        this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                        ImageView imageView111 = this.binding.enumerationFormPage1Image;
                                                                        byte[] bArr111 = this.pdfbyteArray;
                                                                        imageView111.setImageBitmap(BitmapFactory.decodeByteArray(bArr111, 0, bArr111.length));
                                                                        this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                        this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 202) {
                                                                j3 = this.filesize;
                                                                if (j3 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                    this.binding.enumerationFormPage2.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    ImageView imageView112 = this.binding.enumerationFormPage2Image;
                                                                    byte[] bArr112 = this.pdfbyteArray;
                                                                    imageView112.setImageBitmap(BitmapFactory.decodeByteArray(bArr112, 0, bArr112.length));
                                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j3 > 2048) {
                                                                    this.binding.enumerationFormPage2.setVisibility(8);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j18 = j3 / 1024;
                                                                    this.filesize = j18;
                                                                    dRound3 = Math.round(j18 * 100.0d) / 100.0d;
                                                                    if (dRound3 > 2.0d) {
                                                                        this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                        this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                        this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                        this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                        this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                        ImageView imageView113 = this.binding.enumerationFormPage2Image;
                                                                        byte[] bArr113 = this.pdfbyteArray;
                                                                        imageView113.setImageBitmap(BitmapFactory.decodeByteArray(bArr113, 0, bArr113.length));
                                                                        this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                        this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 203) {
                                                                j2 = this.filesize;
                                                                if (j2 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                    ImageView imageView114 = this.binding.supportingDocumentsPage1Image;
                                                                    byte[] bArr114 = this.pdfbyteArray;
                                                                    imageView114.setImageBitmap(BitmapFactory.decodeByteArray(bArr114, 0, bArr114.length));
                                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j2 > 2048) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j19 = j2 / 1024;
                                                                    this.filesize = j19;
                                                                    dRound2 = Math.round(j19 * 100.0d) / 100.0d;
                                                                    if (dRound2 > 2.0d) {
                                                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                        this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                        this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                        ImageView imageView115 = this.binding.supportingDocumentsPage1Image;
                                                                        byte[] bArr115 = this.pdfbyteArray;
                                                                        imageView115.setImageBitmap(BitmapFactory.decodeByteArray(bArr115, 0, bArr115.length));
                                                                        this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                        this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 204) {
                                                                j = this.filesize;
                                                                if (j < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                    ImageView imageView116 = this.binding.supportingDocumentsPage2Image;
                                                                    byte[] bArr116 = this.pdfbyteArray;
                                                                    imageView116.setImageBitmap(BitmapFactory.decodeByteArray(bArr116, 0, bArr116.length));
                                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j > 2048) {
                                                                    this.binding.supportingDocumentsPage2.setVisibility(8);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j110 = j / 1024;
                                                                    this.filesize = j110;
                                                                    dRound = Math.round(j110 * 100.0d) / 100.0d;
                                                                    if (dRound > 2.0d) {
                                                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                        this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                        ImageView imageView117 = this.binding.supportingDocumentsPage2Image;
                                                                        byte[] bArr117 = this.pdfbyteArray;
                                                                        imageView117.setImageBitmap(BitmapFactory.decodeByteArray(bArr117, 0, bArr117.length));
                                                                        this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                        this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            }
                                                            cursorQuery.close();
                                                            r12 = r18;
                                                            r15 = r18;
                                                            r28 = r18;
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            i3 = i;
                                                            r210 = r18;
                                                            exc2 = e;
                                                            r16 = r18;
                                                            r211 = r210;
                                                            ?? r113 = r211;
                                                            Logger.d(r113, exc2.getMessage());
                                                            r12 = r113;
                                                            r15 = r16;
                                                            r28 = r211;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        r18 = "";
                                                        r18 = 1;
                                                    }
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                r18 = "";
                                                r18 = 1;
                                            }
                                            i3 = i;
                                            r210 = r18;
                                        }
                                        r18 = z;
                                        i3 = i;
                                        if (i3 == 201) {
                                            j4 = this.filesize;
                                            if (j4 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                this.binding.enumerationFormPage1.setVisibility(0);
                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                this.binding.enumerationFormPage1Image.setVisibility(0);
                                                ImageView imageView118 = this.binding.enumerationFormPage1Image;
                                                byte[] bArr118 = this.pdfbyteArray;
                                                imageView118.setImageBitmap(BitmapFactory.decodeByteArray(bArr118, 0, bArr118.length));
                                                this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j4 > 2048) {
                                                this.binding.enumerationFormPage1.setVisibility(8);
                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                this.binding.enumerationFormPage1Image.setVisibility(8);
                                                this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j111 = j4 / 1024;
                                                this.filesize = j111;
                                                dRound4 = Math.round(j111 * 100.0d) / 100.0d;
                                                if (dRound4 > 2.0d) {
                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                    ImageView imageView119 = this.binding.enumerationFormPage1Image;
                                                    byte[] bArr119 = this.pdfbyteArray;
                                                    imageView119.setImageBitmap(BitmapFactory.decodeByteArray(bArr119, 0, bArr119.length));
                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 202) {
                                            j3 = this.filesize;
                                            if (j3 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                this.binding.enumerationFormPage2.setVisibility(0);
                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                this.binding.enumerationFormPage2Image.setVisibility(0);
                                                ImageView imageView1110 = this.binding.enumerationFormPage2Image;
                                                byte[] bArr1110 = this.pdfbyteArray;
                                                imageView1110.setImageBitmap(BitmapFactory.decodeByteArray(bArr1110, 0, bArr1110.length));
                                                this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j3 > 2048) {
                                                this.binding.enumerationFormPage2.setVisibility(8);
                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                                this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j112 = j3 / 1024;
                                                this.filesize = j112;
                                                dRound3 = Math.round(j112 * 100.0d) / 100.0d;
                                                if (dRound3 > 2.0d) {
                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                    ImageView imageView1111 = this.binding.enumerationFormPage2Image;
                                                    byte[] bArr1111 = this.pdfbyteArray;
                                                    imageView1111.setImageBitmap(BitmapFactory.decodeByteArray(bArr1111, 0, bArr1111.length));
                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 203) {
                                            j2 = this.filesize;
                                            if (j2 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                this.binding.supportingDocumentsPage1.setVisibility(0);
                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                ImageView imageView1112 = this.binding.supportingDocumentsPage1Image;
                                                byte[] bArr1112 = this.pdfbyteArray;
                                                imageView1112.setImageBitmap(BitmapFactory.decodeByteArray(bArr1112, 0, bArr1112.length));
                                                this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j2 > 2048) {
                                                this.binding.supportingDocumentsPage1.setVisibility(8);
                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j113 = j2 / 1024;
                                                this.filesize = j113;
                                                dRound2 = Math.round(j113 * 100.0d) / 100.0d;
                                                if (dRound2 > 2.0d) {
                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                    ImageView imageView1113 = this.binding.supportingDocumentsPage1Image;
                                                    byte[] bArr1113 = this.pdfbyteArray;
                                                    imageView1113.setImageBitmap(BitmapFactory.decodeByteArray(bArr1113, 0, bArr1113.length));
                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 204) {
                                            j = this.filesize;
                                            if (j < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                this.binding.supportingDocumentsPage2.setVisibility(0);
                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                ImageView imageView1114 = this.binding.supportingDocumentsPage2Image;
                                                byte[] bArr1114 = this.pdfbyteArray;
                                                imageView1114.setImageBitmap(BitmapFactory.decodeByteArray(bArr1114, 0, bArr1114.length));
                                                this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j > 2048) {
                                                this.binding.supportingDocumentsPage2.setVisibility(8);
                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j114 = j / 1024;
                                                this.filesize = j114;
                                                dRound = Math.round(j114 * 100.0d) / 100.0d;
                                                if (dRound > 2.0d) {
                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                    ImageView imageView1115 = this.binding.supportingDocumentsPage2Image;
                                                    byte[] bArr1115 = this.pdfbyteArray;
                                                    imageView1115.setImageBitmap(BitmapFactory.decodeByteArray(bArr1115, 0, bArr1115.length));
                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                }
                                            }
                                        }
                                        cursorQuery.close();
                                        r12 = r18;
                                        r15 = r18;
                                        r28 = r18;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                obj = "/";
                            }
                        }
                    } catch (Exception e13) {
                        e = e13;
                    }
                } catch (Exception e14) {
                    e = e14;
                }
            } catch (Exception e15) {
                e = e15;
                obj = "/";
                r210 = "";
                r18 = 1;
            }
            exc2 = e;
            r16 = r18;
            r211 = r210;
            ?? r114 = r211;
            Logger.d(r114, exc2.getMessage());
            r12 = r114;
            r15 = r16;
            r28 = r211;
        }
        if (i3 == 100 && i2 == -1) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                this.byteArray = byteArrayOutputStream2.toByteArray();
            } catch (Exception e16) {
                Logger.d(r12, e16.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.img, this.temp);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split(obj);
                    long j20 = this.filesize;
                    try {
                        if (j20 < 1024) {
                            faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                            this.binding.passPhotoLayout.setVisibility(0);
                            this.binding.cancel.setVisibility(0);
                            this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.uploadElectorImage.setEnabled(false);
                            this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                            this.binding.photoSize.setText(this.filesize + getString(R.string.kbMsg));
                            this.binding.photoSize.setVisibility(0);
                            this.binding.photoNameTv2.setVisibility(0);
                            this.binding.image.setVisibility(0);
                            ImageView imageView21 = this.binding.image;
                            byte[] bArr21 = this.byteArray;
                            imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, 0, bArr21.length));
                        } else {
                            long j21 = j20 / 1024;
                            this.filesize = j21;
                            double dRound7 = Math.round(j21 * 100.0d) / 100.0d;
                            if (dRound7 > 2.0d) {
                                this.binding.passPhotoLayout.setVisibility(8);
                                this.binding.uploadElectorImage.setEnabled(r15);
                                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.blackColor));
                                showDialog1(this.alertText, this.imgmsg);
                            } else {
                                faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                this.binding.passPhotoLayout.setVisibility(0);
                                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadElectorImage.setEnabled(false);
                                this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                                this.binding.photoSize.setText(dRound7 + getString(R.string.mbMsg));
                                ImageView imageView22 = this.binding.image;
                                byte[] bArr22 = this.byteArray;
                                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, 0, bArr22.length));
                            }
                            cursorQuery2.close();
                            return;
                        }
                        cursorQuery2.close();
                        return;
                    } catch (Exception e17) {
                        exc = e17;
                        r29 = r12;
                    }
                } catch (Exception e18) {
                    e = e18;
                    exc = e;
                    r29 = r28;
                }
            } catch (Exception e19) {
                e = e19;
                r28 = r12;
            }
            exc = e;
            r29 = r28;
            Logger.d(r29, exc.getMessage());
        }
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda26
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
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass30(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass30(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                Log.d("File Ref1= ", FormDataForBloModificationPage1BH.this.base64element1);
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.electorImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element1.isEmpty() || FormDataForBloModificationPage1BH.this.base64element1.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.electorImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$30$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$30$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass31(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass31(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element2 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element2.isEmpty() || FormDataForBloModificationPage1BH.this.base64element2.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$31$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1BH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$31$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$31$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass32(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$32, reason: invalid class name */
    class AnonymousClass32 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass32(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element3 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element3, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.backImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element3.isEmpty() || FormDataForBloModificationPage1BH.this.base64element3.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$32$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$32$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass33(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass33(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element4 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element4, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImage.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element4.isEmpty() || FormDataForBloModificationPage1BH.this.base64element4.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$33$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$33$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda23
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
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
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
        Logger.d(this.TAG, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), captureFileName);
        restClient.uploadImageWithSIR(this.token, "blo", "BLOAPP", partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass34(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass34(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v37, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r13 = FormDataForBloModificationPage1BH.this;
                String str = ((FormDataForBloModificationPage1BH) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$34$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photostr)) {
                    FormDataForBloModificationPage1BH.this.photoUrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1Str)) {
                    FormDataForBloModificationPage1BH.this.srFormPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2str)) {
                    FormDataForBloModificationPage1BH.this.srFormPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1strNew)) {
                    FormDataForBloModificationPage1BH.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2strNew)) {
                    FormDataForBloModificationPage1BH.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo3strNew)) {
                    FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo4strNew)) {
                    FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photostr)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photocount = 0;
                FormDataForBloModificationPage1BH.this.binding.passPhotoLayout.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1Str)) {
                Log.d("Here", "Photo1 Str");
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo1count = 0;
                FormDataForBloModificationPage1BH.this.binding.annexPage1Layout.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH2 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH2.showDialog1(formDataForBloModificationPage1BH2.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2str)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo2count = 0;
                FormDataForBloModificationPage1BH.this.binding.photo2Layout.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH3 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH3.showDialog1(formDataForBloModificationPage1BH3.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1strNew)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo1countNew = 0;
                FormDataForBloModificationPage1BH.this.binding.enumerationFormPage1.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH4 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH4.showDialog1(formDataForBloModificationPage1BH4.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2strNew)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo2countNew = 0;
                FormDataForBloModificationPage1BH.this.binding.enumerationFormPage2.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH5 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH5.showDialog1(formDataForBloModificationPage1BH5.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo3strNew)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo3countNew = 0;
                FormDataForBloModificationPage1BH.this.binding.supportingDocumentsPage1.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH6 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH6.showDialog1(formDataForBloModificationPage1BH6.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo4strNew)) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo4countNew = 0;
                FormDataForBloModificationPage1BH.this.binding.supportingDocumentsPage2.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH7 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH7.showDialog1(formDataForBloModificationPage1BH7.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r2 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$34$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1BH.this.token = "Bearer " + str8;
            FormDataForBloModificationPage1BH.this.refreshToken = str9;
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str8);
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.uploadPhoto(str, str2, str3, str4, str5, formDataForBloModificationPage1BH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photostr)) {
                if (FormDataForBloModificationPage1BH.this.photocount < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.photoUrlS)) {
                    FormDataForBloModificationPage1BH.this.photocount++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photocount = 0;
                    FormDataForBloModificationPage1BH.this.binding.passPhotoLayout.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH2 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH2.showDialog1(formDataForBloModificationPage1BH2.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1Str)) {
                if (FormDataForBloModificationPage1BH.this.photo1count < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage1UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo1count++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH3 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photo1count = 0;
                    FormDataForBloModificationPage1BH.this.binding.annexPage1Layout.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH4 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH4.showDialog1(formDataForBloModificationPage1BH4.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadFrontPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2str)) {
                if (FormDataForBloModificationPage1BH.this.photo2count < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.srFormPage2UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo2count++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH5 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photo2count = 0;
                    FormDataForBloModificationPage1BH.this.binding.photo2Layout.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH6 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH6.showDialog1(formDataForBloModificationPage1BH6.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadBackPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo1strNew)) {
                if (FormDataForBloModificationPage1BH.this.photo1countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument1UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo1countNew++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH7 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH7.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photo1countNew = 0;
                    FormDataForBloModificationPage1BH.this.binding.enumerationFormPage1.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH8 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH8.showDialog1(formDataForBloModificationPage1BH8.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo2strNew)) {
                if (FormDataForBloModificationPage1BH.this.photo2countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeDocument2UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo2countNew++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH9 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH9.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH9.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photo2countNew = 0;
                    FormDataForBloModificationPage1BH.this.binding.enumerationFormPage2.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH10 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH10.showDialog1(formDataForBloModificationPage1BH10.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo3strNew)) {
                if (FormDataForBloModificationPage1BH.this.photo3countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage1UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo3countNew++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH11 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH11.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH11.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage1BH.this.photo3countNew = 0;
                    FormDataForBloModificationPage1BH.this.binding.supportingDocumentsPage1.setVisibility(8);
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH12 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH12.showDialog1(formDataForBloModificationPage1BH12.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                    FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage1BH.this.photo4strNew)) {
                if (FormDataForBloModificationPage1BH.this.photo4countNew < 2 && TextUtils.isEmpty(FormDataForBloModificationPage1BH.this.relativeSupportingDocumentPage2UrlS)) {
                    FormDataForBloModificationPage1BH.this.photo4countNew++;
                    FormDataForBloModificationPage1BH formDataForBloModificationPage1BH13 = FormDataForBloModificationPage1BH.this;
                    formDataForBloModificationPage1BH13.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH13.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.photo4countNew = 0;
                FormDataForBloModificationPage1BH.this.binding.supportingDocumentsPage2.setVisibility(8);
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH14 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH14.showDialog1(formDataForBloModificationPage1BH14.alertText, FormDataForBloModificationPage1BH.this.fileNotFoundMessage);
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.whitecolor));
                FormDataForBloModificationPage1BH.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(getApplicationContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass35(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass35(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r13 = FormDataForBloModificationPage1BH.this;
                String str = ((FormDataForBloModificationPage1BH) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$35$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage1BH.token, this.val$reference, this.val$uploadtype);
                return;
            }
            try {
                FormDataForBloModificationPage1BH.this.binding.passPhotoLayout.setVisibility(8);
                FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setEnabled(true);
                FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.blackColor));
                new JSONObject(response.errorBody().string());
                FormDataForBloModificationPage1BH formDataForBloModificationPage1BH2 = FormDataForBloModificationPage1BH.this;
                formDataForBloModificationPage1BH2.showDialog1(formDataForBloModificationPage1BH2.alertText, FormDataForBloModificationPage1BH.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("ReverifyPage1", e.toString());
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r2 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$35$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage1BH.this.token = "Bearer " + str8;
            FormDataForBloModificationPage1BH.this.refreshToken = str9;
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str8);
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.faceRecognition(str, str2, str3, str4, str5, formDataForBloModificationPage1BH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            FormDataForBloModificationPage1BH.this.binding.passPhotoLayout.setVisibility(8);
            FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setEnabled(true);
            FormDataForBloModificationPage1BH.this.binding.uploadElectorImage.setTextColor(Color.parseColor(FormDataForBloModificationPage1BH.this.blackColor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.alertText, Constants.somethingWentWrong);
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
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
            this.binding.fbUploadLL.setVisibility(0);
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS) && TextUtils.isEmpty(this.annexureCUrlS)) {
                this.binding.uploadBackPhoto.setVisibility(0);
            }
            this.srFormPage1UrlS = "";
            if (!TextUtils.isEmpty(this.annexureCUrlS)) {
                this.annexureCUrlS = "";
                this.binding.secondLL.setVisibility(8);
                this.binding.uploadBackPhoto.setVisibility(0);
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
            }
            this.binding.fbUploadLL.setVisibility(0);
            this.srFormPage2UrlS = "";
        }
    }

    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(getApplicationContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.retryMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda22
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$25(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda25
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
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$26(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda21
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
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationListBH.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    private void showPersonPdfDialog(String base64elementValue, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        Uri saveImagePath = getSaveImagePath(base64elementValue, ".pdf");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + this.saveImageFileName);
        new File((String) Objects.requireNonNull(saveImagePath.getPath()));
        pDFViewFindViewById.fromFile(file).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$$ExternalSyntheticLambda11
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
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
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
        }
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
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass36(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass36(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
        /* JADX WARN: Type inference failed for: r9v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.payloadData1 = (JsonObject) response.body();
                if (FormDataForBloModificationPage1BH.this.payloadData1 != null) {
                    JsonArray asJsonArray = FormDataForBloModificationPage1BH.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage1BH.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-8") && FormDataForBloModificationPage1BH.this.List8docName.size() != size + 1) {
                            FormDataForBloModificationPage1BH.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage1BH.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage1BH.this.List8docName.contains(FormDataForBloModificationPage1BH.this.selectDocumentType)) {
                                FormDataForBloModificationPage1BH.this.List8docName.add(0, FormDataForBloModificationPage1BH.this.selectDocumentType);
                                FormDataForBloModificationPage1BH.this.List8docCode.add(0, null);
                            }
                            ?? r3 = FormDataForBloModificationPage1BH.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.List8docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage1BH.this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationListList8DocCode") == null || FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationListList8DocCode").equals("")) {
                                FormDataForBloModificationPage1BH.this.binding.spinnerIR.setSelection(0);
                            } else {
                                FormDataForBloModificationPage1BH.this.binding.spinnerIR.setSelection(FormDataForBloModificationPage1BH.this.List8docCode.indexOf(FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationListList8DocCode")));
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r9 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r9).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r9, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$36$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1BH.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$36$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getList1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent(FormDataForBloModificationPage1BH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            Logger.d(FormDataForBloModificationPage1BH.this.TAG, "OnFailure" + t.getMessage());
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
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getRelationDropdown(map).enqueue(new AnonymousClass37());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$37, reason: invalid class name */
    class AnonymousClass37 implements Callback<JsonObject> {
        AnonymousClass37() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
        /* JADX WARN: Type inference failed for: r9v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.payloadData1 = (JsonObject) response.body();
                if (FormDataForBloModificationPage1BH.this.payloadData1 != null) {
                    JsonArray asJsonArray = FormDataForBloModificationPage1BH.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage1BH.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormDataForBloModificationPage1BH.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormDataForBloModificationPage1BH.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        if (!FormDataForBloModificationPage1BH.this.relationNameSpinnerVal.contains(FormDataForBloModificationPage1BH.this.selectRelationType)) {
                            FormDataForBloModificationPage1BH.this.relationNameSpinnerVal.add(0, FormDataForBloModificationPage1BH.this.selectRelationType);
                            FormDataForBloModificationPage1BH.this.relationCodeSpinnerVal.add(0, null);
                        }
                        ?? r3 = FormDataForBloModificationPage1BH.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.relationNameSpinnerVal);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        FormDataForBloModificationPage1BH.this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter);
                        if (FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationType") == null || FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationType").equals("")) {
                            FormDataForBloModificationPage1BH.this.binding.spinnerRelation.setSelection(0);
                        } else {
                            FormDataForBloModificationPage1BH.this.binding.spinnerRelation.setSelection(FormDataForBloModificationPage1BH.this.relationCodeSpinnerVal.indexOf(FormDataForBloModificationPage1BH.this.intent.getStringExtra("relationType")));
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r9 = FormDataForBloModificationPage1BH.this;
                    commomUtility.getRefreshToken(r9, ((FormDataForBloModificationPage1BH) r9).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$37$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage1BH.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$37$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str);
                FormDataForBloModificationPage1BH.this.getRelationTypeDropdown();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent(FormDataForBloModificationPage1BH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            Logger.d(FormDataForBloModificationPage1BH.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass38(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$38, reason: invalid class name */
    class AnonymousClass38 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass38(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element11 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element11, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImageNew.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element11.isEmpty() || FormDataForBloModificationPage1BH.this.base64element11.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImageNew.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$38$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1BH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$38$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$38$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile21(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass39(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$39, reason: invalid class name */
    class AnonymousClass39 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass39(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element21 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element21, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.backImageNew.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element21.isEmpty() || FormDataForBloModificationPage1BH.this.base64element21.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.backImageNew.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$39$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1BH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$39$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$39$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile21(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile31(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass40(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$40, reason: invalid class name */
    class AnonymousClass40 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass40(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element31 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element31, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImage1.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element31.isEmpty() || FormDataForBloModificationPage1BH.this.base64element31.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$40$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1BH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$40$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$40$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile31(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile41(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass41(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$41, reason: invalid class name */
    class AnonymousClass41 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass41(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
                if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                    FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage1BH.this.base64element41 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FormDataForBloModificationPage1BH.this.base64element41, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDataForBloModificationPage1BH.this.binding.backImage1.setImageBitmap(bitmapDecodeByteArray);
                }
                if (FormDataForBloModificationPage1BH.this.base64element41.isEmpty() || FormDataForBloModificationPage1BH.this.base64element41.equals("null")) {
                    FormDataForBloModificationPage1BH.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage1BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage1BH.this;
                    String str = ((FormDataForBloModificationPage1BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$41$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag);
                }
            } else {
                try {
                    FormDataForBloModificationPage1BH.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$41$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage1BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                        FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage1BH.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH] */
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
            FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage1BH.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage1BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormDataForBloModificationPage1BH$41$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage1BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage1BH.this.getFile41(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage1BH.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage1BH.this.startActivity(new Intent((Context) FormDataForBloModificationPage1BH.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage1BH.this.TAG, FormDataForBloModificationPage1BH.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage1BH.this.alertDialog != null) {
                FormDataForBloModificationPage1BH.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage1BH formDataForBloModificationPage1BH = FormDataForBloModificationPage1BH.this;
            formDataForBloModificationPage1BH.showDialog1(formDataForBloModificationPage1BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }
}
