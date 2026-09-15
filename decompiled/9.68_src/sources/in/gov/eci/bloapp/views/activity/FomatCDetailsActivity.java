package in.gov.eci.bloapp.views.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormatcDetailsBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.callback.FormatCDetailsCallback;
import in.gov.eci.bloapp.views.activity.callback.FormatCListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.formatc.Content;
import in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FomatCDetailsActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private String acNo;
    String acNumner;
    AlertDialog alertDialog;
    String applicantSignature;
    String applicantStatus;
    private String atkband;
    ActivityFormatcDetailsBinding binding;
    Bitmap bitmapPersonImage;
    String bloComments;
    String bloSignature;
    Content content;
    String correctedName;
    DatePickerDialog.OnDateSetListener date;
    String dobOrAge;
    String epicNo;
    protected long filesize;
    Root form8data;
    String formRefNo;
    String formSubmissionDate;
    String formType;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private ArrayList<String> gender;
    private ArrayAdapter<String> genderadapter;
    ArrayList<String> gendercode;
    String gendervalue;
    String hasDataEntryError;
    String houseNo;
    String id;
    String isDetailsCorrect;
    private LocationRequest locationRequest;
    long maxDate;
    long minDate;
    String part;
    private String partNo;
    String partSerialNo;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
    String pinCode;
    String place;
    String postOffice;
    private String refreshToken;
    private ArrayList<String> relation;
    String relationName;
    String relationType;
    private ArrayAdapter<String> relationadapter;
    private ArrayList<String> relationcode;
    String remarks;
    private String rtkband;
    protected String saveImageFileName;
    private String state;
    String statusID;
    String streetArea;
    String tehsilTalukaMandal;
    private String token;
    String townVillage;
    Utils utils;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    String selectedTab = "";
    final Calendar dobcalendar = Calendar.getInstance();
    ActivityResultLauncher<Intent> activityResultLauncher14 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.1
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                FomatCDetailsActivity.this.HandlePdfFile(result.getData(), "BLO sign", 115);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher16 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.2
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                FomatCDetailsActivity.this.HandlePdfFile(result.getData(), "elector sign", 116);
            }
        }
    });
    String isNameVerified = "N";
    String isAddressVerified = "N";
    String isDOBVerified = "N";
    String isphotoAsPerSpec = "N";
    String isRelativeVerified = "N";
    String isRelationVerified = "N";
    String isAgeVerified = "N";
    String isMobileVerified = "N";
    String isGenderVerified = "N";
    String fieldVerificationAbsent = "N";
    String fieldVerificationDead = "N";
    String fieldVerificationNoSuchPerson = "N";
    String fieldVerificationPersonPresent = "N";
    String fieldVerificationShifted = "N";
    String agebydob = null;
    String mobilenumber = null;
    String objectStorage = "objectstorage";
    String message = "message";
    String channelidobo = "BLOAPP";
    String bloApp = "BLOAPP";
    String sessionTokenExpiredPleaseLogin = SESSION_TOKEN_EXPIRED_PLEASE_LOGIN;
    String chooseFile = "Choose File";
    String takephoto = "Take Photo";
    String choosegallery = "Choose Image from Gallery";
    String cancel = "Cancel";
    String choosepdf = "Choose PDF from Gallery";
    String applicationpdf = "application/pdf";
    String imgmsg = "Can't obtain file name, cursor is empty";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String pdf3 = "PDF size exceeded 3MB limit.";
    String functionNameForLogBaseActivity = "";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String jpgTextBaseActivity = ".jpg";
    String pdfTextBaseActivity = ".pdf";
    String img = "image";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String bloSignurl = null;
    String applicantSignurl = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityFormatcDetailsBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Intent intent = getIntent();
        if (intent != null) {
            this.content = (Content) intent.getParcelableExtra("item");
            this.selectedTab = intent.getStringExtra("tab");
        }
        if (!TextUtils.isEmpty(this.selectedTab) && this.selectedTab.equalsIgnoreCase("submitform")) {
            this.binding.cvChecklistBlo.setVisibility(8);
            this.binding.submitformCvChecklistBlo.setVisibility(0);
            if (this.content.getStatusID() == 3) {
                this.binding.noactionRb.setChecked(true);
                this.binding.generateRb.setChecked(false);
            } else if (this.content.getStatusID() == 4) {
                this.binding.noactionRb.setChecked(false);
                this.binding.generateRb.setChecked(true);
            }
            if (!TextUtils.isEmpty(this.content.getEroRemarks())) {
                this.binding.anyotherremarkSubmitForm.setText(this.content.getEroRemarks());
            }
        } else {
            this.binding.cvChecklistBlo.setVisibility(0);
            this.binding.submitformCvChecklistBlo.setVisibility(8);
        }
        getListOfNaCategory();
        this.alertDialog.show();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.textView3.setText(getResources().getString(R.string.format_c));
        this.binding.textView3.setTextSize(15.0f);
        this.formSubmissionDate = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        this.binding.verificationDateEd.setText(this.formSubmissionDate);
        this.binding.verificationDateEd.setEnabled(false);
        getCurrentLocation();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        this.minDate = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(1, -18);
        this.maxDate = calendar2.getTime().getTime();
        this.date = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda17
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$0(datePicker, i, i2, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$1(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$2(view);
            }
        });
        this.binding.commentRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FomatCDetailsActivity.this.isNameVerified = "N";
                FomatCDetailsActivity.this.isAddressVerified = "N";
                FomatCDetailsActivity.this.isDOBVerified = "N";
                FomatCDetailsActivity.this.isphotoAsPerSpec = "N";
                FomatCDetailsActivity.this.isRelativeVerified = "N";
                FomatCDetailsActivity.this.isRelationVerified = "N";
                FomatCDetailsActivity.this.isAgeVerified = "N";
                FomatCDetailsActivity.this.isMobileVerified = "N";
                FomatCDetailsActivity.this.isGenderVerified = "N";
                if (FomatCDetailsActivity.this.binding.correctRb.isChecked()) {
                    FomatCDetailsActivity.this.disableandCheck();
                    if (FomatCDetailsActivity.this.content.getFormType().equalsIgnoreCase("F8C")) {
                        FomatCDetailsActivity.this.binding.cvCorrection.setVisibility(0);
                        FomatCDetailsActivity.this.correctedName = null;
                        FomatCDetailsActivity.this.dobOrAge = null;
                        FomatCDetailsActivity.this.agebydob = null;
                        FomatCDetailsActivity.this.relationName = null;
                        FomatCDetailsActivity.this.houseNo = null;
                        FomatCDetailsActivity.this.streetArea = null;
                        FomatCDetailsActivity.this.townVillage = null;
                        FomatCDetailsActivity.this.postOffice = null;
                        FomatCDetailsActivity.this.tehsilTalukaMandal = null;
                        FomatCDetailsActivity.this.pinCode = null;
                        FomatCDetailsActivity.this.mobilenumber = null;
                        FomatCDetailsActivity.this.gendervalue = null;
                        FomatCDetailsActivity.this.relationType = null;
                        FomatCDetailsActivity.this.binding.genderSpinnerMig.setSelection(0);
                        FomatCDetailsActivity.this.binding.RelationTypeSpinner.setSelection(0);
                    }
                }
                if (FomatCDetailsActivity.this.binding.errorRb.isChecked()) {
                    FomatCDetailsActivity.this.enableandUncheck();
                    if (FomatCDetailsActivity.this.content.getFormType().equalsIgnoreCase("F8C")) {
                        FomatCDetailsActivity.this.binding.cvCorrection.setVisibility(0);
                    }
                }
            }
        });
        this.binding.chooseBloSignature.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$3(view);
            }
        });
        this.binding.chooseApplicantSignature.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FomatCDetailsActivity.this.pickFile(116, "elector sign");
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FomatCDetailsActivity.this.deletePhoto(115);
            }
        });
        this.binding.applicantCancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FomatCDetailsActivity.this.deletePhoto(116);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!TextUtils.isEmpty(FomatCDetailsActivity.this.selectedTab) && FomatCDetailsActivity.this.selectedTab.equalsIgnoreCase("submitform")) {
                    if (FomatCDetailsActivity.this.validateform()) {
                        FomatCDetailsActivity.this.submitform();
                    }
                } else if (FomatCDetailsActivity.this.validate()) {
                    FomatCDetailsActivity.this.submit();
                }
            }
        });
        this.binding.genderSpinnerMig.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (FomatCDetailsActivity.this.gendercode.get(position).equals("M")) {
                    FomatCDetailsActivity.this.gendervalue = "M";
                }
                if (FomatCDetailsActivity.this.gendercode.get(position).equals("F")) {
                    FomatCDetailsActivity.this.gendervalue = "F";
                }
                if (FomatCDetailsActivity.this.gendercode.get(position).equals("T")) {
                    FomatCDetailsActivity.this.gendervalue = "T";
                }
            }
        });
        this.binding.RelationTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FomatCDetailsActivity fomatCDetailsActivity = FomatCDetailsActivity.this;
                fomatCDetailsActivity.relationType = (String) fomatCDetailsActivity.relationcode.get(position);
            }
        });
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$2(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$3(View view) {
        pickFile(115, "BLO sign");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initClickListener$4(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this.date, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(this.maxDate);
        datePickerDialog.getDatePicker().setMinDate(this.minDate);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateform() {
        if (TextUtils.isEmpty(this.binding.etReferenceNumber.getText().toString())) {
            showdialog(this.alertText, "Please enter reference number");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.etRemark.getText().toString())) {
            return true;
        }
        showdialog(this.alertText, "Please enter remark");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableandUncheck() {
        this.binding.cbAddress.setChecked(false);
        this.binding.cbDob.setChecked(false);
        this.binding.cbPhoto.setChecked(false);
        this.binding.cbGender.setChecked(false);
        this.binding.cbMobile.setChecked(false);
        this.binding.cbRelationName.setChecked(false);
        this.binding.cbRelationtype.setChecked(false);
        this.binding.cbName.setChecked(false);
        this.binding.cbPhoto.setEnabled(true);
        this.binding.cbDob.setEnabled(true);
        this.binding.cbGender.setEnabled(true);
        this.binding.cbMobile.setEnabled(true);
        this.binding.cbRelationName.setEnabled(true);
        this.binding.cbRelationtype.setEnabled(true);
        this.binding.cbName.setEnabled(true);
        this.binding.cbAddress.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableandCheck() {
        this.binding.cbAddress.setChecked(true);
        this.binding.cbDob.setChecked(true);
        this.binding.cbPhoto.setChecked(true);
        this.binding.cbGender.setChecked(true);
        this.binding.cbMobile.setChecked(true);
        this.binding.cbRelationName.setChecked(true);
        this.binding.cbRelationtype.setChecked(true);
        this.binding.cbName.setChecked(true);
        this.binding.cbPhoto.setEnabled(false);
        this.binding.cbDob.setEnabled(false);
        this.binding.cbGender.setEnabled(false);
        this.binding.cbMobile.setEnabled(false);
        this.binding.cbRelationName.setEnabled(false);
        this.binding.cbRelationtype.setEnabled(false);
        this.binding.cbName.setEnabled(false);
        this.binding.cbAddress.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x0228  */
    /* JADX WARN: Code duplicated, block: B:106:0x022e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0240  */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:50:0x0102  */
    /* JADX WARN: Code duplicated, block: B:51:0x0105  */
    /* JADX WARN: Code duplicated, block: B:54:0x0116  */
    /* JADX WARN: Code duplicated, block: B:56:0x0120  */
    /* JADX WARN: Code duplicated, block: B:57:0x0123  */
    /* JADX WARN: Code duplicated, block: B:60:0x0134  */
    /* JADX WARN: Code duplicated, block: B:62:0x013e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    /* JADX WARN: Code duplicated, block: B:66:0x0152  */
    /* JADX WARN: Code duplicated, block: B:68:0x015c  */
    /* JADX WARN: Code duplicated, block: B:69:0x015f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0170  */
    /* JADX WARN: Code duplicated, block: B:74:0x017a  */
    /* JADX WARN: Code duplicated, block: B:75:0x017d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0188  */
    /* JADX WARN: Code duplicated, block: B:80:0x018e  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b4  */
    public boolean validate() {
        boolean z;
        boolean z2;
        if (this.content.getFormType().equalsIgnoreCase("F8S")) {
            if (this.binding.commentRg.getCheckedRadioButtonId() == -1) {
                showdialog(this.alertText, "Please select BLO comment");
                return false;
            }
            if (this.binding.errorRb.isChecked() && !this.binding.cbAddress.isChecked() && !this.binding.cbDob.isChecked() && !this.binding.cbPhoto.isChecked()) {
                showdialog(this.alertText, "Please check atleast one field verification option");
                return false;
            }
            if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                showdialog(this.alertText, "Please verify if applicant was present");
                return false;
            }
            if (TextUtils.isEmpty(this.binding.anyotherremark.getText().toString())) {
                showdialog(this.alertText, "Please enter remark");
                return false;
            }
            if (TextUtils.isEmpty(this.binding.verificationPlaceEd.getText().toString())) {
                showdialog(this.alertText, "Please enter place");
                return false;
            }
        } else if (this.content.getFormType().equalsIgnoreCase("F8C")) {
            if (this.form8data.getForm8DTO().getCorrectionOfName().equalsIgnoreCase("Y")) {
                if (this.binding.cbName.isChecked()) {
                    z = true;
                } else {
                    z2 = false;
                    z = true;
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelative().equalsIgnoreCase("Y")) {
                    if (this.binding.cbRelationName.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelation().equalsIgnoreCase("Y")) {
                    if (this.binding.cbRelationtype.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.form8data.getForm8DTO().getCorrectionOfDob().equalsIgnoreCase("Y")) {
                    if (this.binding.cbDob.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.form8data.getForm8DTO().getCorrectionOfMobile().equalsIgnoreCase("Y")) {
                    if (this.binding.cbMobile.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.form8data.getForm8DTO().getCorrectionOfGender().equalsIgnoreCase("Y")) {
                    if (this.binding.cbGender.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.form8data.getForm8DTO().getCorrectionOfAddress().equalsIgnoreCase("Y")) {
                    if (this.binding.cbAddress.isChecked()) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                    }
                }
                if (this.binding.commentRg.getCheckedRadioButtonId() == -1) {
                    showdialog(this.alertText, "Please select BLO comment");
                    return false;
                }
                if (!this.binding.errorRb.isChecked() && z && !z2) {
                    showdialog(this.alertText, "Please check at least one field verification option");
                    return false;
                }
                if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                    showdialog(this.alertText, "Please verify if applicant was present");
                    return false;
                }
                if (TextUtils.isEmpty(this.binding.etPincode.getText().toString().trim()) && this.binding.etPincode.getText().toString().length() < 6) {
                    showdialog(this.alertText, "pincode should not be less than 6 digit");
                    return false;
                }
                if (TextUtils.isEmpty(this.binding.etPincode.getText().toString().trim()) && this.binding.etPincode.getText().toString().length() >= 7) {
                    showdialog(this.alertText, "pincode should not be greater than 7 digit");
                    return false;
                }
                if (TextUtils.isEmpty(this.binding.anyotherremark.getText().toString())) {
                    showdialog(this.alertText, "Please enter remark");
                    return false;
                }
                if (TextUtils.isEmpty(this.binding.verificationPlaceEd.getText().toString())) {
                    showdialog(this.alertText, "Please enter place");
                    return false;
                }
            } else {
                z = false;
            }
            z2 = z;
            if (this.form8data.getForm8DTO().getCorrectionOfRelative().equalsIgnoreCase("Y")) {
                if (this.binding.cbRelationName.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.form8data.getForm8DTO().getCorrectionOfRelation().equalsIgnoreCase("Y")) {
                if (this.binding.cbRelationtype.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.form8data.getForm8DTO().getCorrectionOfDob().equalsIgnoreCase("Y")) {
                if (this.binding.cbDob.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.form8data.getForm8DTO().getCorrectionOfMobile().equalsIgnoreCase("Y")) {
                if (this.binding.cbMobile.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.form8data.getForm8DTO().getCorrectionOfGender().equalsIgnoreCase("Y")) {
                if (this.binding.cbGender.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.form8data.getForm8DTO().getCorrectionOfAddress().equalsIgnoreCase("Y")) {
                if (this.binding.cbAddress.isChecked()) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (this.binding.commentRg.getCheckedRadioButtonId() == -1) {
                showdialog(this.alertText, "Please select BLO comment");
                return false;
            }
            if (!this.binding.errorRb.isChecked()) {
            }
            if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                showdialog(this.alertText, "Please verify if applicant was present");
                return false;
            }
            if (TextUtils.isEmpty(this.binding.etPincode.getText().toString().trim())) {
            }
            if (TextUtils.isEmpty(this.binding.etPincode.getText().toString().trim())) {
            }
            if (TextUtils.isEmpty(this.binding.anyotherremark.getText().toString())) {
                showdialog(this.alertText, "Please enter remark");
                return false;
            }
            if (TextUtils.isEmpty(this.binding.verificationPlaceEd.getText().toString())) {
                showdialog(this.alertText, "Please enter place");
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submit() {
        this.acNumner = String.valueOf(this.content.getAcNo());
        this.part = String.valueOf(this.content.getPartNo());
        this.id = String.valueOf(this.content.getId());
        this.epicNo = this.content.getEpicNo();
        this.partSerialNo = String.valueOf(this.content.getPartSerialNo());
        this.formRefNo = this.content.getFormRefNo();
        this.formType = this.content.getFormType();
        this.statusID = String.valueOf(this.content.getStatusID());
        String str = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        Log.d("DATE_TIME", str);
        this.place = this.binding.verificationPlaceEd.getText().toString();
        if (this.binding.absentRb.isChecked()) {
            this.fieldVerificationAbsent = "Y";
        } else {
            this.fieldVerificationAbsent = "N";
        }
        if (this.binding.deadRb.isChecked()) {
            this.fieldVerificationDead = "Y";
        } else {
            this.fieldVerificationDead = "N";
        }
        if (this.binding.nosuchpersonRb.isChecked()) {
            this.fieldVerificationNoSuchPerson = "Y";
        } else {
            this.fieldVerificationNoSuchPerson = "N";
        }
        if (this.binding.availableRb.isChecked()) {
            this.fieldVerificationPersonPresent = "Y";
        } else {
            this.fieldVerificationPersonPresent = "N";
        }
        if (this.binding.shiftedRb.isChecked()) {
            this.fieldVerificationShifted = "Y";
        } else {
            this.fieldVerificationShifted = "N";
        }
        if (this.binding.correctRb.isChecked()) {
            this.bloComments = "Y";
            if (this.content.getFormType().equalsIgnoreCase("F8S")) {
                this.isAddressVerified = "Y";
                this.isphotoAsPerSpec = "Y";
                this.isDOBVerified = "Y";
                this.isAgeVerified = "Y";
                this.dobOrAge = null;
                this.agebydob = null;
            } else if (this.content.getFormType().equalsIgnoreCase("F8C")) {
                if (this.form8data.getForm8DTO().getCorrectionOfName().equalsIgnoreCase("Y")) {
                    this.isNameVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelative().equalsIgnoreCase("Y")) {
                    this.isRelativeVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelation().equalsIgnoreCase("Y")) {
                    this.isRelationVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfDob().equalsIgnoreCase("Y")) {
                    this.isDOBVerified = "Y";
                    this.isAgeVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfMobile().equalsIgnoreCase("Y")) {
                    this.isMobileVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfGender().equalsIgnoreCase("Y")) {
                    this.isGenderVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfAddress().equalsIgnoreCase("Y")) {
                    this.isAddressVerified = "Y";
                }
            }
        } else if (this.binding.errorRb.isChecked()) {
            this.bloComments = "N";
            if (this.content.getFormType().equalsIgnoreCase("F8S")) {
                if (this.binding.cbAddress.isChecked()) {
                    this.isAddressVerified = "Y";
                }
                if (this.binding.cbDob.isChecked()) {
                    this.isDOBVerified = "Y";
                    this.isAgeVerified = "Y";
                }
                if (this.binding.cbPhoto.isChecked()) {
                    this.isphotoAsPerSpec = "Y";
                }
            } else if (this.content.getFormType().equalsIgnoreCase("F8C")) {
                if (this.form8data.getForm8DTO().getCorrectionOfName().equalsIgnoreCase("Y") && this.binding.cbName.isChecked()) {
                    this.isNameVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelative().equalsIgnoreCase("Y") && this.binding.cbRelationName.isChecked()) {
                    this.isRelativeVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfRelation().equalsIgnoreCase("Y") && this.binding.cbRelationtype.isChecked()) {
                    this.isRelationVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfDob().equalsIgnoreCase("Y") && this.binding.cbDob.isChecked()) {
                    this.isDOBVerified = "Y";
                    this.isAgeVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfMobile().equalsIgnoreCase("Y") && this.binding.cbMobile.isChecked()) {
                    this.isMobileVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfGender().equalsIgnoreCase("Y") && this.binding.cbGender.isChecked()) {
                    this.isGenderVerified = "Y";
                }
                if (this.form8data.getForm8DTO().getCorrectionOfAddress().equalsIgnoreCase("Y") && this.binding.cbAddress.isChecked()) {
                    this.isAddressVerified = "Y";
                }
            }
        }
        this.remarks = this.binding.anyotherremark.getText().toString();
        if (this.content.getFormType().equalsIgnoreCase("F8C")) {
            this.correctedName = !TextUtils.isEmpty(this.binding.etApplicantName.getText().toString()) ? this.binding.etApplicantName.getText().toString() : null;
            if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
                String string = this.binding.dateOfBirth.getText().toString();
                try {
                    Log.d(this.TAG, "eroll dob" + string);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    if (!TextUtils.isEmpty(string)) {
                        String str2 = simpleDateFormat2.format(simpleDateFormat.parse(string));
                        this.dobOrAge = str2;
                        try {
                            Date date = simpleDateFormat2.parse(str2);
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(date);
                            Calendar calendar2 = Calendar.getInstance();
                            int i = calendar2.get(1) - calendar.get(1);
                            if (calendar2.get(6) < calendar.get(6)) {
                                i--;
                            }
                            this.agebydob = String.valueOf(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    Logger.d("Date replace", e2.toString());
                }
            }
            this.relationName = !TextUtils.isEmpty(this.binding.etRelationName.getText().toString()) ? this.binding.etRelationName.getText().toString() : null;
            this.houseNo = !TextUtils.isEmpty(this.binding.etHouseNumber.getText().toString()) ? this.binding.etHouseNumber.getText().toString() : null;
            this.streetArea = !TextUtils.isEmpty(this.binding.etStreet.getText().toString()) ? this.binding.etStreet.getText().toString() : null;
            this.townVillage = !TextUtils.isEmpty(this.binding.etTown.getText().toString()) ? this.binding.etTown.getText().toString() : null;
            this.postOffice = !TextUtils.isEmpty(this.binding.etPostoffice.getText().toString()) ? this.binding.etPostoffice.getText().toString() : null;
            this.tehsilTalukaMandal = !TextUtils.isEmpty(this.binding.etTehsil.getText().toString()) ? this.binding.etTehsil.getText().toString() : null;
            this.pinCode = !TextUtils.isEmpty(this.binding.etPincode.getText().toString()) ? this.binding.etPincode.getText().toString() : null;
            this.mobilenumber = TextUtils.isEmpty(this.binding.mobileNumber.getText().toString()) ? null : this.binding.mobileNumber.getText().toString();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("id", this.id);
        HashMap map2 = new HashMap();
        map2.put("isNameVerified", this.isNameVerified);
        map2.put("isAddressVerified", this.isAddressVerified);
        map2.put("isDOBVerified", this.isDOBVerified);
        map2.put("isphotoAsPerSpec", this.isphotoAsPerSpec);
        map2.put("isRelativeVerified", this.isRelativeVerified);
        map2.put("isRelationVerified", this.isRelationVerified);
        map2.put("isAgeVerified", this.isAgeVerified);
        map2.put("isMobileVerified", this.isMobileVerified);
        map2.put("isGenderVerified", this.isGenderVerified);
        map2.put("bloComments", this.bloComments);
        map2.put("fvrRemarks", this.remarks);
        map2.put("correctedName", this.correctedName);
        map2.put("dob", this.dobOrAge);
        map2.put("gender", this.gendervalue);
        map2.put("relationName", this.relationName);
        map2.put("relationType", this.relationType);
        map2.put("houseNo", this.houseNo);
        map2.put("streetArea", this.streetArea);
        map2.put("townVillage", this.townVillage);
        map2.put("postOffice", this.postOffice);
        map2.put("tehsilTalukaMandal", this.tehsilTalukaMandal);
        map2.put("pinCode", this.pinCode);
        map2.put("place", this.place);
        map2.put("epicID", this.content.getEpicID());
        map2.put("epicNo", this.epicNo);
        map2.put("acNo", this.acNumner);
        map2.put("partNo", this.partNo);
        map2.put("partSerialNo", this.partSerialNo);
        map2.put("formRefNo", this.formRefNo);
        map2.put("statusID", 2);
        map2.put("formType", this.formType);
        map2.put("verificationDate", str);
        map2.put("applicantSignature", this.applicantSignurl);
        map2.put("bloSignature", this.bloSignurl);
        map2.put("fieldVerificationAbsent", this.fieldVerificationAbsent.trim());
        map2.put("fieldVerificationDead", this.fieldVerificationDead.trim());
        map2.put("fieldVerificationNoSuchPerson", this.fieldVerificationNoSuchPerson.trim());
        map2.put("fieldVerificationPersonPresent", this.fieldVerificationPersonPresent.trim());
        map2.put("fieldVerificationShifted", this.fieldVerificationShifted.trim());
        map2.put("mobileNumber", this.mobilenumber);
        map2.put("age", this.agebydob);
        Log.d("REQUEST_JSON", new JSONObject(map2).toString());
        this.alertDialog.show();
        this.commomUtility.formatCSubmit(this, map, map2, new FormatCListCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.10
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.callback.FormatCListCallback
            public void onCallBack(int code, List<Content> formlist, String message) {
                if (code == 200) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                    Utils utils = FomatCDetailsActivity.this.utils;
                    ?? r4 = FomatCDetailsActivity.this;
                    utils.infoDialogAction(r4, r4.alertText, "Form submitted successfully", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.10.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FomatCDetailsActivity.this.finish();
                        }
                    });
                    return;
                }
                FomatCDetailsActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = FomatCDetailsActivity.this.utils;
                ?? r5 = FomatCDetailsActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getListOfNaCategory() {
        this.alertDialog.show();
        this.commomUtility.getDetailsByEpicOrRefno(this, this.token, this.atkband, this.rtkband, this.state, this.content.getFormType(), this.content.getFormRefNo(), "", new AnonymousClass11());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$11, reason: invalid class name */
    class AnonymousClass11 implements FormatCDetailsCallback {
        AnonymousClass11() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
        /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
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
        @Override // in.gov.eci.bloapp.views.activity.callback.FormatCDetailsCallback
        public void onCallBack(int code, final Root formlist, String message) {
            if (code == 200) {
                FomatCDetailsActivity.this.alertDialog.dismiss();
                if (formlist != null) {
                    FomatCDetailsActivity.this.form8data = formlist;
                    FomatCDetailsActivity.this.setFormDetails(formlist);
                    FomatCDetailsActivity.this.setElectorDetails(formlist);
                    if (FomatCDetailsActivity.this.content.getFormType().equalsIgnoreCase("F8S")) {
                        FomatCDetailsActivity.this.setForm8SData(formlist);
                        return;
                    } else {
                        if (FomatCDetailsActivity.this.content.getFormType().equalsIgnoreCase("F8C")) {
                            FomatCDetailsActivity.this.alertDialog.show();
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$11$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onCallBack$0(formlist);
                                }
                            }, 3000L);
                            return;
                        }
                        return;
                    }
                }
                FomatCDetailsActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils = FomatCDetailsActivity.this.utils;
                ?? r4 = FomatCDetailsActivity.this;
                utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                return;
            }
            FomatCDetailsActivity.this.alertDialog.dismiss();
            if (TextUtils.isEmpty(message)) {
                return;
            }
            Utils utils2 = FomatCDetailsActivity.this.utils;
            ?? r5 = FomatCDetailsActivity.this;
            utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallBack$0(Root root) {
            FomatCDetailsActivity.this.setForm8CData(root);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForm8CData(Root formlist) {
        String str = (!TextUtils.isEmpty(formlist.getForm8DTO().getFirstName()) ? formlist.getForm8DTO().getFirstName() : "") + StringUtils.SPACE + (!TextUtils.isEmpty(formlist.getForm8DTO().getLastName()) ? formlist.getForm8DTO().getLastName() : "");
        this.binding.form8cnameTv1.setText(str);
        if (formlist.getForm8DTO().getCorrectionOfName().equalsIgnoreCase("Y")) {
            this.binding.form8cnameTv.setVisibility(0);
            this.binding.form8cnameTv1.setVisibility(0);
            this.binding.cbName.setVisibility(0);
            this.binding.lvNameCorrection.setVisibility(0);
            this.binding.etApplicantName.setText(str);
        } else {
            this.binding.form8cnameTv.setVisibility(8);
            this.binding.form8cnameTv1.setVisibility(8);
            this.binding.cbName.setVisibility(8);
            this.binding.lvNameCorrection.setVisibility(8);
        }
        String relativeName = !TextUtils.isEmpty(formlist.getForm8DTO().getRelativeName()) ? formlist.getForm8DTO().getRelativeName() : "";
        this.binding.form8crelativenameTv1.setText(relativeName);
        if (formlist.getForm8DTO().getCorrectionOfRelative().equalsIgnoreCase("Y")) {
            this.binding.form8cRelativenameTv.setVisibility(0);
            this.binding.form8crelativenameTv1.setVisibility(0);
            this.binding.cbRelationName.setVisibility(0);
            this.binding.lvRelationnameCorrection.setVisibility(0);
            this.binding.etRelationName.setText(relativeName);
        } else {
            this.binding.form8cRelativenameTv.setVisibility(8);
            this.binding.form8crelativenameTv1.setVisibility(8);
            this.binding.cbRelationName.setVisibility(8);
            this.binding.lvRelationnameCorrection.setVisibility(8);
        }
        String relationType = !TextUtils.isEmpty(formlist.getForm8DTO().getRelationType()) ? formlist.getForm8DTO().getRelationType() : "";
        setRelativeType(relationType, this.binding.form8crelativetypeTv1);
        if (formlist.getForm8DTO().getCorrectionOfRelation().equalsIgnoreCase("Y")) {
            this.binding.form8cRelativetypeTv.setVisibility(0);
            this.binding.form8crelativetypeTv1.setVisibility(0);
            this.binding.cbRelationtype.setVisibility(0);
            this.binding.CorrectRelationTypeLayout.setVisibility(0);
            for (int i = 0; i < this.relationcode.size(); i++) {
                if (this.relationcode.get(i).equalsIgnoreCase(relationType)) {
                    this.binding.RelationTypeSpinner.setSelection(i);
                    break;
                }
            }
        } else {
            this.binding.form8cRelativetypeTv.setVisibility(8);
            this.binding.form8crelativetypeTv1.setVisibility(8);
            this.binding.cbRelationtype.setVisibility(8);
            this.binding.CorrectRelationTypeLayout.setVisibility(8);
        }
        String dateOfBirth = !TextUtils.isEmpty(formlist.getForm8DTO().getDateOfBirth()) ? formlist.getForm8DTO().getDateOfBirth() : "";
        this.binding.form8cdobTv1.setText(dateOfBirth + " / " + (formlist.getForm8DTO().getAge() != 0 ? String.valueOf(formlist.getForm8DTO().getAge()) : ""));
        if (formlist.getForm8DTO().getCorrectionOfDob().equalsIgnoreCase("Y") || formlist.getForm8DTO().getCorrectionOfAge().equalsIgnoreCase("Y")) {
            this.binding.form8cdobTv.setVisibility(0);
            this.binding.form8cdobTv1.setVisibility(0);
            this.binding.cbDob.setVisibility(0);
            this.binding.dobLayout.setVisibility(0);
            this.binding.dateOfBirth.setText(dateOfBirth);
        } else {
            this.binding.form8cdobTv.setVisibility(8);
            this.binding.form8cdobTv1.setVisibility(8);
            this.binding.cbDob.setVisibility(8);
            this.binding.dobLayout.setVisibility(8);
        }
        if (formlist.getForm8DTO().getCorrectionOfMobile().equalsIgnoreCase("Y")) {
            this.binding.form8cmobileTv.setVisibility(0);
            this.binding.form8cmobileTv1.setVisibility(0);
            this.binding.cbMobile.setVisibility(0);
            this.binding.mobilelayout.setVisibility(0);
            this.binding.mobileNumber.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getMobileNumber()) ? formlist.getForm8DTO().getMobileNumber() : "");
        } else {
            this.binding.form8cmobileTv.setVisibility(8);
            this.binding.form8cmobileTv1.setVisibility(8);
            this.binding.cbMobile.setVisibility(8);
            this.binding.mobilelayout.setVisibility(8);
        }
        this.binding.form8cmobileTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getMobileNumber()) ? formlist.getForm8DTO().getMobileNumber() : "");
        if (formlist.getForm8DTO().getCorrectionOfGender().equalsIgnoreCase("Y")) {
            this.binding.form8cgenderTv.setVisibility(0);
            this.binding.form8cgenderTv1.setVisibility(0);
            this.binding.cbGender.setVisibility(0);
            this.binding.CorrectGenderLayout.setVisibility(0);
            for (int i2 = 0; i2 < this.gendercode.size(); i2++) {
                if (this.gendercode.get(i2).equalsIgnoreCase(formlist.getForm8DTO().getGender())) {
                    this.binding.genderSpinnerMig.setSelection(i2);
                    break;
                }
            }
        } else {
            this.binding.form8cgenderTv.setVisibility(8);
            this.binding.form8cgenderTv1.setVisibility(8);
            this.binding.cbGender.setVisibility(8);
            this.binding.CorrectGenderLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(formlist.getForm8DTO().getGender())) {
            if (formlist.getForm8DTO().getGender().equalsIgnoreCase("M")) {
                this.binding.form8cgenderTv1.setText("Male");
            } else if (formlist.getForm8DTO().getGender().equalsIgnoreCase("F")) {
                this.binding.form8cgenderTv1.setText("Female");
            } else {
                this.binding.form8cgenderTv1.setText("Other");
            }
        }
        if (formlist.getForm8DTO().getCorrectionOfAddress().equalsIgnoreCase("Y")) {
            this.binding.form8chouseTv.setVisibility(0);
            this.binding.form8chouseTv1.setVisibility(0);
            this.binding.form8cstreetTv1.setVisibility(0);
            this.binding.form8cstreetTv.setVisibility(0);
            this.binding.form8ctownTv1.setVisibility(0);
            this.binding.form8ctownTv.setVisibility(0);
            this.binding.form8cpostofficeTv1.setVisibility(0);
            this.binding.form8cpostofficeTv.setVisibility(0);
            this.binding.form8cpincodeTv1.setVisibility(0);
            this.binding.form8cpincodeTv.setVisibility(0);
            this.binding.form8ctehsilTv1.setVisibility(0);
            this.binding.form8ctehsilTv.setVisibility(0);
            this.binding.cbAddress.setVisibility(0);
            this.binding.lvAddressCorrection.setVisibility(0);
            this.binding.etHouseNumber.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getHouseNumber()) ? formlist.getForm8DTO().getHouseNumber() : "");
            this.binding.etStreet.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getLocalityOrStreet()) ? formlist.getForm8DTO().getLocalityOrStreet() : "");
            this.binding.etTown.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getVillageOrTown()) ? formlist.getForm8DTO().getVillageOrTown() : "");
            this.binding.etPostoffice.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPostOffice()) ? formlist.getForm8DTO().getPostOffice() : "");
            this.binding.etPincode.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPinCode()) ? formlist.getForm8DTO().getPinCode() : "");
            this.binding.etTehsil.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getTalukaOrTehsilOrMandal()) ? formlist.getForm8DTO().getTalukaOrTehsilOrMandal() : "");
        } else {
            this.binding.form8chouseTv.setVisibility(8);
            this.binding.form8chouseTv1.setVisibility(8);
            this.binding.form8cstreetTv1.setVisibility(8);
            this.binding.form8cstreetTv.setVisibility(8);
            this.binding.form8ctownTv1.setVisibility(8);
            this.binding.form8ctownTv.setVisibility(8);
            this.binding.form8cpostofficeTv1.setVisibility(8);
            this.binding.form8cpostofficeTv.setVisibility(8);
            this.binding.form8cpincodeTv1.setVisibility(8);
            this.binding.form8cpincodeTv.setVisibility(8);
            this.binding.form8ctehsilTv1.setVisibility(8);
            this.binding.form8ctehsilTv.setVisibility(8);
            this.binding.cbAddress.setVisibility(8);
            this.binding.lvAddressCorrection.setVisibility(8);
        }
        this.binding.form8chouseTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getHouseNumber()) ? formlist.getForm8DTO().getHouseNumber() : "");
        this.binding.form8cstreetTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getLocalityOrStreet()) ? formlist.getForm8DTO().getLocalityOrStreet() : "");
        this.binding.form8ctownTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getVillageOrTown()) ? formlist.getForm8DTO().getVillageOrTown() : "");
        this.binding.form8cpostofficeTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPostOffice()) ? formlist.getForm8DTO().getPostOffice() : "");
        this.binding.form8cpincodeTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPinCode()) ? formlist.getForm8DTO().getPinCode() : "");
        this.binding.form8ctehsilTv1.setText(TextUtils.isEmpty(formlist.getForm8DTO().getTalukaOrTehsilOrMandal()) ? "" : formlist.getForm8DTO().getTalukaOrTehsilOrMandal());
        if (formlist.getForm8DTO().getCorrectionOfPhotograpgh().equalsIgnoreCase("Y")) {
            this.binding.form8csubBasicdetails2.setVisibility(8);
            this.binding.electorphotocorrect.setVisibility(8);
            this.binding.cbPhoto.setVisibility(8);
        } else {
            this.binding.form8csubBasicdetails2.setVisibility(8);
            this.binding.electorphotocorrect.setVisibility(8);
            this.binding.cbPhoto.setVisibility(8);
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForm8SData(Root formlist) {
        this.binding.formhouseTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getHouseNumber()) ? formlist.getForm8DTO().getHouseNumber() : "");
        this.binding.formstreetTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getLocalityOrStreet()) ? formlist.getForm8DTO().getLocalityOrStreet() : "");
        this.binding.formtownTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getVillageOrTown()) ? formlist.getForm8DTO().getVillageOrTown() : "");
        this.binding.formpostofficeTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPostOffice()) ? formlist.getForm8DTO().getPostOffice() : "");
        this.binding.formpincodeTv1.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getPinCode()) ? formlist.getForm8DTO().getPinCode() : "");
        this.binding.formtehsilTv1.setText(TextUtils.isEmpty(formlist.getForm8DTO().getTalukaOrTehsilOrMandal()) ? "" : formlist.getForm8DTO().getTalukaOrTehsilOrMandal());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElectorDetails(Root formlist) {
        this.binding.applicantNameTv1.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getApplicantFirstName()) ? formlist.getElectorEpicDTO().getApplicantFirstName() : "") + StringUtils.SPACE + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getApplicantLastName()) ? formlist.getElectorEpicDTO().getApplicantLastName() : ""));
        this.binding.epicTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getEpicNumber()) ? formlist.getElectorEpicDTO().getEpicNumber() : "");
        this.binding.acTv1.setText((formlist.getElectorEpicDTO().getAssemblyConstituencyNumber() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getAssemblyConstituencyNumber()) : "") + "-" + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getAssemblyName()) ? formlist.getElectorEpicDTO().getAssemblyName() : ""));
        this.binding.partTv1.setText(formlist.getElectorEpicDTO().getPartNumber() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getPartNumber()) : "");
        this.binding.sectionTv1.setText(formlist.getElectorEpicDTO().getSectionNo() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getSectionNo()) : "");
        this.binding.mobileTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getMobileNumber()) ? formlist.getElectorEpicDTO().getMobileNumber() : "");
        this.binding.emailTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getEmailId()) ? formlist.getElectorEpicDTO().getEmailId() : "");
        this.binding.houseTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getHouseNumber()) ? formlist.getElectorEpicDTO().getHouseNumber() : "");
        this.binding.streetTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getLocalityStreet()) ? formlist.getElectorEpicDTO().getLocalityStreet() : "");
        this.binding.townTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getBirthTown()) ? formlist.getElectorEpicDTO().getBirthTown() : "");
        this.binding.postofficeTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getPostOffice()) ? formlist.getElectorEpicDTO().getPostOffice() : "");
        this.binding.pincodeTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getPinCode()) ? formlist.getElectorEpicDTO().getPinCode() : "");
        this.binding.tehsilTv1.setText(TextUtils.isEmpty(formlist.getElectorEpicDTO().getTehsilTalukaMandal()) ? "" : formlist.getElectorEpicDTO().getTehsilTalukaMandal());
        if (TextUtils.isEmpty(formlist.getElectorEpicDTO().getPhoto())) {
            return;
        }
        getPersonImageUploadedfilePersonalDetials(formlist.getElectorEpicDTO().getPhoto(), this.binding.personImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFormDetails(Root formlist) {
        this.binding.formNumberValue.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getReferenceNumber()) ? formlist.getForm8DTO().getReferenceNumber() : "");
        if (!TextUtils.isEmpty(this.content.getFormType())) {
            if (this.content.getFormType().equalsIgnoreCase("F8S")) {
                this.binding.form8Value.setText("Shifting of Residence");
                this.binding.cvFormdata.setVisibility(0);
                this.binding.cvForm8cdata.setVisibility(8);
                this.binding.cbAddress.setVisibility(0);
                this.binding.cbDob.setVisibility(0);
                this.binding.cbPhoto.setVisibility(0);
                this.binding.cvCorrection.setVisibility(8);
            } else if (this.content.getFormType().equalsIgnoreCase("F8C")) {
                this.binding.form8Value.setText("Correction of Enteries");
                this.binding.cvFormdata.setVisibility(8);
                this.binding.cvForm8cdata.setVisibility(0);
                this.binding.cbAddress.setVisibility(8);
                this.binding.cvCorrection.setVisibility(0);
                getGender(this.form8data.getForm8DTO().getStateCd(), this.token);
            }
        }
        this.binding.formTypeValue.setText(!TextUtils.isEmpty(formlist.getForm8DTO().getFormSubmissionChannel()) ? formlist.getForm8DTO().getFormSubmissionChannel() : "");
        if (!TextUtils.isEmpty(formlist.getForm8DTO().getFormSubmissionDate())) {
            this.binding.submissionDateValue.setText(OffsetDateTime.parse(formlist.getForm8DTO().getFormSubmissionDate()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        }
        this.binding.stateValue.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getStateCd()) ? formlist.getElectorEpicDTO().getStateCd() : "") + "-" + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getStateName()) ? formlist.getElectorEpicDTO().getStateName() : ""));
        this.binding.districtValue.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getDistrictCd()) ? formlist.getElectorEpicDTO().getDistrictCd() : "") + "-" + (TextUtils.isEmpty(formlist.getElectorEpicDTO().getDistrictName()) ? "" : formlist.getElectorEpicDTO().getDistrictName()));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$5(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$6(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        startActivity(new Intent((Context) this, (Class<?>) FomatCListActivity.class));
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getPersonImageUploadedfilePersonalDetials(String fileName, ImageView imageView) {
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getFile(this.objectStorage, fileName, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass12(imageView));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ ImageView val$imageView;

        AnonymousClass12(final ImageView val$imageView) {
            this.val$imageView = val$imageView;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Log.d(FomatCDetailsActivity.this.TAG, "error in image" + jsonObject.get("file"));
                FomatCDetailsActivity.this.bitmapPersonImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(String.valueOf(jsonObject.get("file")).replace(RegexMatcher.JSON_STRING_REGEX, ""), 0)));
                this.val$imageView.setImageBitmap(FomatCDetailsActivity.this.bitmapPersonImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$12$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                FomatCDetailsActivity.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(FomatCDetailsActivity.this.TAG, "errorApi" + response.errorBody());
                Log.d(FomatCDetailsActivity.this.TAG, "imageError" + jSONObject.optString(FomatCDetailsActivity.this.message));
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$12$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
            } catch (IOException | JSONException e) {
                Logger.d(FomatCDetailsActivity.this.TAG, "exception" + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FomatCDetailsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            FomatCDetailsActivity.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(FomatCDetailsActivity.this.TAG, "comingInOnFailure" + t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void refreshTokenApi() {
        this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda7
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$9(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshTokenApi$9(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$7(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(this).setRefreshToken(str2);
        SharedPref.getInstance(this).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(this, this.alertText, "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$8(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshTokenApi$7(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$8(DialogInterface dialogInterface, int i) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickFile(final int code, String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(this.chooseFile);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$10(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$10(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
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
        if (code == 115) {
            this.activityResultLauncher14.launch(intentCreateChooser);
        } else if (code == 116) {
            this.activityResultLauncher16.launch(intentCreateChooser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x0072 A[Catch: Exception -> 0x0248, TRY_LEAVE, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008d  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:40:0x0107 A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x015e A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x016f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0173 A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x018c A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01b0 A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:54:0x01fc A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x023d A[Catch: Exception -> 0x0248, TryCatch #2 {Exception -> 0x0248, blocks: (B:29:0x0055, B:31:0x0072, B:35:0x008f, B:37:0x00ba, B:55:0x0239, B:40:0x0107, B:41:0x0146, B:44:0x015e, B:48:0x0183, B:47:0x0173, B:49:0x018c, B:51:0x01b0, B:54:0x01fc, B:56:0x023d, B:57:0x0247), top: B:65:0x0055 }] */
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
                            saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf");
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
                                this.alertDialog.show();
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), code);
                                if (requestcode == 115) {
                                    this.binding.bloSignatureLayout.setVisibility(0);
                                    this.binding.chooseBloSignature.setVisibility(8);
                                    this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.photo1Size.setText(this.filesize + "KB");
                                } else if (requestcode == 116) {
                                    this.binding.applicantLayout.setVisibility(0);
                                    this.binding.chooseApplicantSignature.setVisibility(8);
                                    this.binding.applicantPhoto1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.applicantPhoto1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
                                }
                            } else if (Math.round(((double) (j / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                                if (requestcode == 115) {
                                    this.binding.bloSignatureLayout.setVisibility(8);
                                    this.binding.chooseBloSignature.setVisibility(0);
                                } else if (requestcode == 116) {
                                    this.binding.applicantLayout.setVisibility(8);
                                    this.binding.chooseApplicantSignature.setVisibility(0);
                                }
                                showdialog(this.alertText, this.pdf3);
                            } else {
                                this.alertDialog.show();
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), code);
                                if (requestcode == 115) {
                                    this.binding.bloSignatureLayout.setVisibility(0);
                                    this.binding.chooseBloSignature.setVisibility(8);
                                    this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.photo1Size.setText(this.filesize + "KB");
                                } else if (requestcode == 116) {
                                    this.binding.applicantLayout.setVisibility(0);
                                    this.binding.chooseApplicantSignature.setVisibility(8);
                                    this.binding.applicantPhoto1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    this.binding.applicantPhoto1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
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
            saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf");
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
                this.alertDialog.show();
                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), code);
                if (requestcode == 115) {
                    this.binding.bloSignatureLayout.setVisibility(0);
                    this.binding.chooseBloSignature.setVisibility(8);
                    this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                } else if (requestcode == 116) {
                    this.binding.applicantLayout.setVisibility(0);
                    this.binding.chooseApplicantSignature.setVisibility(8);
                    this.binding.applicantPhoto1.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.applicantPhoto1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
                }
            } else if (Math.round(((double) (j / 1024.0f)) * 100.0d) / 100.0d > 3.0d) {
                if (requestcode == 115) {
                    this.binding.bloSignatureLayout.setVisibility(8);
                    this.binding.chooseBloSignature.setVisibility(0);
                } else if (requestcode == 116) {
                    this.binding.applicantLayout.setVisibility(8);
                    this.binding.chooseApplicantSignature.setVisibility(0);
                }
                showdialog(this.alertText, this.pdf3);
            } else {
                this.alertDialog.show();
                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), code);
                if (requestcode == 115) {
                    this.binding.bloSignatureLayout.setVisibility(0);
                    this.binding.chooseBloSignature.setVisibility(8);
                    this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                } else if (requestcode == 116) {
                    this.binding.applicantLayout.setVisibility(0);
                    this.binding.chooseApplicantSignature.setVisibility(8);
                    this.binding.applicantPhoto1.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.applicantPhoto1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
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
        } catch (Exception unused) {
        }
        this.filesize = file2.length() / 1024;
        return FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.alertDialog.dismiss();
        }
        if (requestCode == 115 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery.moveToFirst();
                String[] strArrSplit = saveImagePath.getPath().split("/");
                Logger.d(this.TAG, Arrays.toString(strArrSplit));
                long j = this.filesize;
                if (j < 1024) {
                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), "BLO sign");
                    this.binding.bloSignatureLayout.setVisibility(0);
                    this.binding.chooseBloSignature.setVisibility(8);
                    ImageView imageView = this.binding.photo1;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                    return;
                }
                if (j > 2048) {
                    this.binding.bloSignatureLayout.setVisibility(8);
                    this.binding.chooseBloSignature.setVisibility(0);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j2 = j / 1024;
                this.filesize = j2;
                if (Math.round(j2 * 100.0d) / 100.0d > 2.0d) {
                    this.binding.bloSignatureLayout.setVisibility(8);
                    this.binding.chooseBloSignature.setVisibility(0);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), "BLO sign");
                this.binding.bloSignatureLayout.setVisibility(0);
                this.binding.chooseBloSignature.setVisibility(8);
                ImageView imageView2 = this.binding.photo1;
                byte[] bArr2 = this.pdfbyteArray;
                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.photo1Size.setText(this.filesize + "KB");
                return;
            } catch (Exception e2) {
                Log.e(this.TAG, e2.toString());
                return;
            }
        }
        if (requestCode == 116 && resultCode == -1) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream2);
                this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                if (cursorQuery2.getCount() <= 0) {
                    cursorQuery2.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery2.moveToFirst();
                String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                Logger.d(this.TAG, Arrays.toString(strArrSplit2));
                long j3 = this.filesize;
                if (j3 < 1024) {
                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), "elector sign");
                    this.binding.applicantLayout.setVisibility(0);
                    this.binding.chooseApplicantSignature.setVisibility(8);
                    this.binding.applicantPhoto1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                    this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
                    ImageView imageView3 = this.binding.applicantPhoto1;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    return;
                }
                if (j3 > 2048) {
                    this.binding.applicantLayout.setVisibility(8);
                    this.binding.chooseApplicantSignature.setVisibility(0);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j4 = j3 / 1024;
                this.filesize = j4;
                if (Math.round(j4 * 100.0d) / 100.0d > 2.0d) {
                    this.binding.applicantLayout.setVisibility(8);
                    this.binding.chooseApplicantSignature.setVisibility(0);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), "elector sign");
                this.binding.applicantLayout.setVisibility(0);
                this.binding.chooseApplicantSignature.setVisibility(8);
                this.binding.applicantPhoto1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                this.binding.applicantPhoto1Size.setText(this.filesize + "KB");
                ImageView imageView4 = this.binding.applicantPhoto1;
                byte[] bArr4 = this.pdfbyteArray;
                imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
            } catch (Exception e4) {
                Log.e(this.TAG, e4.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$11(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$11(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(reference, MediaType.parse("fileName"));
        restClient.uploadImageWithData1(Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", partCreateFormData, RequestBody.create(this.applicationpdf, MediaType.parse("fileType")), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass13(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass13(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v8, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
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
                CommomUtility commomUtility = FomatCDetailsActivity.this.commomUtility;
                ?? r13 = FomatCDetailsActivity.this;
                String str = ((FomatCDetailsActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$13$$ExternalSyntheticLambda1
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
                handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$13$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2(str9, strValueOf);
                    }
                }, 2000L);
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            if (this.val$uploadtype.equals("BLO sign")) {
                if (FomatCDetailsActivity.this.alertDialog != null) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                }
                FomatCDetailsActivity.this.binding.bloSignatureLayout.setVisibility(8);
                FomatCDetailsActivity.this.binding.chooseBloSignature.setVisibility(0);
                FomatCDetailsActivity.this.binding.chooseBloSignature.setEnabled(true);
                FomatCDetailsActivity fomatCDetailsActivity = FomatCDetailsActivity.this;
                fomatCDetailsActivity.showDialog1(fomatCDetailsActivity.alertText, FomatCDetailsActivity.this.fileNotFoundMessage);
                return;
            }
            if (this.val$uploadtype.equals("elector sign")) {
                if (FomatCDetailsActivity.this.alertDialog != null) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                }
                FomatCDetailsActivity.this.binding.applicantLayout.setVisibility(8);
                FomatCDetailsActivity.this.binding.chooseApplicantSignature.setVisibility(0);
                FomatCDetailsActivity.this.binding.chooseApplicantSignature.setEnabled(true);
                FomatCDetailsActivity fomatCDetailsActivity2 = FomatCDetailsActivity.this;
                fomatCDetailsActivity2.showDialog1(fomatCDetailsActivity2.alertText, FomatCDetailsActivity.this.fileNotFoundMessage);
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
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                FomatCDetailsActivity.this.commomUtility.showMessageOK(FomatCDetailsActivity.this, FomatCDetailsActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$13$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FomatCDetailsActivity.this.token = "Bearer " + str8;
            FomatCDetailsActivity.this.refreshToken = str9;
            SharedPref.getInstance(FomatCDetailsActivity.this).setRefreshToken(str9);
            SharedPref.getInstance(FomatCDetailsActivity.this).setToken("Bearer " + str8);
            FomatCDetailsActivity fomatCDetailsActivity = FomatCDetailsActivity.this;
            fomatCDetailsActivity.uploadPhoto(str, str2, str3, str4, str5, fomatCDetailsActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FomatCDetailsActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(FomatCDetailsActivity.this).setLocaleBool(false);
            FomatCDetailsActivity.this.startActivity(new Intent((Context) FomatCDetailsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2) {
            if (str.equals("BLO sign")) {
                FomatCDetailsActivity.this.bloSignurl = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("anxDSignUrl", FomatCDetailsActivity.this.bloSignurl);
                if (FomatCDetailsActivity.this.alertDialog != null) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals("elector sign")) {
                FomatCDetailsActivity.this.applicantSignurl = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("applicantSignurl", FomatCDetailsActivity.this.applicantSignurl);
                if (FomatCDetailsActivity.this.alertDialog != null) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 115) {
            this.bloSignurl = null;
            this.binding.chooseBloSignature.setVisibility(0);
            this.binding.bloSignatureLayout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.binding.photo1Name.setText("");
            return;
        }
        if (code == 116) {
            this.applicantSignurl = null;
            this.binding.chooseApplicantSignature.setVisibility(0);
            this.binding.applicantLayout.setVisibility(8);
            this.binding.applicantPhoto1Size.setText("");
            this.binding.applicantPhoto1Name.setText("");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda12
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$12(task);
                    }
                });
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getCurrentLocation$12(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation.get(0).getLocality().isEmpty()) {
                    this.binding.verificationPlaceEd.setEnabled(true);
                    this.binding.verificationPlaceEd.setFocusable(true);
                    this.binding.verificationPlaceEd.setFocusableInTouchMode(true);
                } else {
                    this.binding.verificationPlaceEd.setText(fromLocation.get(0).getLocality());
                    this.binding.verificationPlaceEd.setEnabled(false);
                    this.binding.verificationPlaceEd.setFocusable(false);
                    this.binding.verificationPlaceEd.setFocusableInTouchMode(false);
                }
            } catch (Exception e) {
                Logger.d("aaa", e.getMessage());
                this.binding.verificationPlaceEd.setEnabled(true);
                this.binding.verificationPlaceEd.setFocusable(true);
                this.binding.verificationPlaceEd.setFocusableInTouchMode(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(this).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda16
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$13(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$13(Task task) {
        try {
            Logger.d("", ((LocationSettingsResponse) task.getResult(ApiException.class)).toString());
            Toast.makeText((Context) this, (CharSequence) "GPS is already turned on", 0).show();
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
        return ((LocationManager) ((FomatCDetailsActivity) Objects.requireNonNull(this)).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void setRelativeType(String relativeType, TextView textView) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void getGender(final String blostatecode, final String tokennew) {
        this.commomUtility.getGender(blostatecode, tokennew, this.atkband, this.rtkband, this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda10
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getGender$16(blostatecode, tokennew, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getGender$16(final String str, String str2, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda3
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str3, String str4) {
                    this.f$0.lambda$getGender$15(str, i2, str3, str4);
                }
            });
            return;
        }
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, (List<String>) this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderSpinnerMig.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderSpinnerMig.setSelection(0);
        getRelation(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getGender$15(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getGender$14(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(this).setRefreshToken(str3);
        SharedPref.getInstance(this).setToken("Bearer " + str2);
        getGender(str, this.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getGender$14(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getRelation(final String blostatecode, String tokennew) {
        this.commomUtility.getRelation(blostatecode, tokennew, this.atkband, this.rtkband, this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda18
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getRelation$19(blostatecode, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getRelation$19(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda19
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getRelation$18(str, i2, str2, str3);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, (List<String>) this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.RelationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.RelationTypeSpinner.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getRelation$18(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getRelation$17(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(this).setRefreshToken(str3);
        SharedPref.getInstance(this).setToken("Bearer " + str2);
        getRelation(str, this.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getRelation$17(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submitform() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("id", String.valueOf(this.content.getId()));
        HashMap map2 = new HashMap();
        map2.put("updateRefNoRemarks", this.binding.etRemark.getText().toString().trim());
        map2.put("updatedRefNo", this.binding.etReferenceNumber.getText().toString().trim());
        map2.put("statusID", 5);
        Log.d("REQUEST_JSON", new JSONObject(map2).toString());
        this.alertDialog.show();
        this.commomUtility.submitForm(this, map, map2, new FormatCListCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.14
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCDetailsActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.callback.FormatCListCallback
            public void onCallBack(int code, List<Content> formlist, String message) {
                if (code == 200) {
                    FomatCDetailsActivity.this.alertDialog.dismiss();
                    Utils utils = FomatCDetailsActivity.this.utils;
                    ?? r4 = FomatCDetailsActivity.this;
                    utils.infoDialogAction(r4, r4.alertText, "Form submitted successfully", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCDetailsActivity.14.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FomatCDetailsActivity.this.finish();
                        }
                    });
                    return;
                }
                FomatCDetailsActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = FomatCDetailsActivity.this.utils;
                ?? r5 = FomatCDetailsActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }
}
