package in.gov.eci.bloapp.views.activity;

import android.app.Activity;
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
import android.widget.ImageView;
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
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormatc7DetailsBinding;
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
import java.util.Arrays;
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
public class FomatC7DetailsActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    String acNumner;
    AlertDialog alertDialog;
    String applicantSignature;
    String applicantStatus;
    private String atkband;
    ActivityFormatc7DetailsBinding binding;
    Bitmap bitmapPersonImage;
    String bloComments;
    String bloSignature;
    Content content;
    String correctedName;
    String dobOrAge;
    String epicNo;
    protected long filesize;
    Root form7data;
    String formRefNo;
    String formSubmissionDate;
    String formType;
    FusedLocationProviderClient fusedLocationProviderClient;
    String gender;
    String hasDataEntryError;
    String houseNo;
    String id;
    String isDetailsCorrect;
    private LocationRequest locationRequest;
    String mobile;
    String part;
    private String partNo;
    String partSerialNo;
    private byte[] pdfbyteArray;
    private byte[] pdfbyteArray1;
    String pinCode;
    String place;
    String postOffice;
    private String refreshToken;
    String relationName;
    String relationType;
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
    ActivityResultLauncher<Intent> activityResultLauncher16 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.1
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                FomatC7DetailsActivity.this.HandlePdfFile(result.getData(), "elector sign", 116);
            }
        }
    });
    ActivityResultLauncher<Intent> activityResultLauncher14 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.5
        public void onActivityResult(ActivityResult result) throws Throwable {
            if (result.getResultCode() == -1) {
                FomatC7DetailsActivity.this.HandlePdfFile(result.getData(), "BLO sign", 115);
            }
        }
    });
    String objectStorage = "objectstorage";
    String message = "message";
    String channelidobo = "BLOAPP";
    String bloApp = "BLOAPP";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
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
    String isNameVerified = "N";
    String isAddressVerified = "N";
    String isDOBVerified = "N";
    String isGenderVerified = "N";
    String isRelativeVerified = "N";
    String isRelationVerified = "N";
    String isMobileVerified = "N";
    String isAgeVerified = "N";
    String isphotoAsPerSpec = "N";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityFormatc7DetailsBinding.inflate(getLayoutInflater());
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
            this.binding.cvApplicantSign.setVisibility(8);
            this.binding.cvBloSign.setVisibility(8);
            this.binding.cvBloComment.setVisibility(8);
            this.binding.cvDovPlace.setVisibility(8);
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
            this.binding.cvApplicantSign.setVisibility(0);
            this.binding.cvBloSign.setVisibility(0);
            this.binding.cvBloComment.setVisibility(0);
            this.binding.cvDovPlace.setVisibility(0);
            this.binding.submitformCvChecklistBlo.setVisibility(8);
        }
        getListOfNaCategory();
        this.alertDialog.show();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.textView3.setText(getResources().getString(R.string.format_c));
        this.binding.textView3.setTextSize(15.0f);
        this.formSubmissionDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        this.binding.verificationDateEd.setText(this.formSubmissionDate);
        this.binding.verificationDateEd.setEnabled(false);
        this.binding.chooseBloSignature.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.chooseApplicantSignature.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FomatC7DetailsActivity.this.deletePhoto(115);
            }
        });
        this.binding.applicantCancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FomatC7DetailsActivity.this.deletePhoto(116);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!TextUtils.isEmpty(FomatC7DetailsActivity.this.selectedTab) && FomatC7DetailsActivity.this.selectedTab.equalsIgnoreCase("submitform")) {
                    if (FomatC7DetailsActivity.this.validateform()) {
                        FomatC7DetailsActivity.this.submitform();
                    }
                } else if (FomatC7DetailsActivity.this.validate()) {
                    FomatC7DetailsActivity.this.submit();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        pickFile(115, "BLO sign");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        pickFile(116, "elector sign");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$2(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$3(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getListOfNaCategory() {
        this.alertDialog.show();
        this.commomUtility.getDetailsByEpicOrRefno(this, this.token, this.atkband, this.rtkband, this.state, this.content.getFormType(), this.content.getFormRefNo(), "", new FormatCDetailsCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.6
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
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
            public void onCallBack(int code, Root formlist, String message) {
                if (code == 200) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    if (formlist != null) {
                        FomatC7DetailsActivity.this.form7data = formlist;
                        FomatC7DetailsActivity.this.setFormDetails(formlist);
                        FomatC7DetailsActivity.this.setElectorDetails(formlist);
                        FomatC7DetailsActivity.this.setApplicantDetails(formlist);
                        return;
                    }
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = FomatC7DetailsActivity.this.utils;
                    ?? r4 = FomatC7DetailsActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                FomatC7DetailsActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = FomatC7DetailsActivity.this.utils;
                ?? r5 = FomatC7DetailsActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElectorDetails(Root formlist) {
        this.binding.electorNameTv1.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getApplicantFirstName()) ? formlist.getElectorEpicDTO().getApplicantFirstName() : "") + StringUtils.SPACE + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getApplicantLastName()) ? formlist.getElectorEpicDTO().getApplicantLastName() : ""));
        this.binding.electorEpicTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getEpicNumber()) ? formlist.getElectorEpicDTO().getEpicNumber() : "");
        this.binding.electorAcTv1.setText((formlist.getElectorEpicDTO().getAssemblyConstituencyNumber() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getAssemblyConstituencyNumber()) : "") + "-" + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getAssemblyName()) ? formlist.getElectorEpicDTO().getAssemblyName() : ""));
        this.binding.electorPartTv1.setText(formlist.getElectorEpicDTO().getPartNumber() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getPartNumber()) : "");
        this.binding.electorSrNoTv1.setText(formlist.getElectorEpicDTO().getPartSerialNumber() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getPartSerialNumber()) : "");
        this.binding.electorSectionTv1.setText(formlist.getElectorEpicDTO().getSectionNo() != 0 ? String.valueOf(formlist.getElectorEpicDTO().getSectionNo()) : "");
        this.binding.electorMobileTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getMobileNumber()) ? formlist.getElectorEpicDTO().getMobileNumber() : "");
        this.binding.electorEmailTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getEmailId()) ? formlist.getElectorEpicDTO().getEmailId() : "");
        this.binding.electorHouseTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getHouseNumber()) ? formlist.getElectorEpicDTO().getHouseNumber() : "");
        this.binding.electorStreetTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getLocalityStreet()) ? formlist.getElectorEpicDTO().getLocalityStreet() : "");
        this.binding.electorTownTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getBirthTown()) ? formlist.getElectorEpicDTO().getBirthTown() : "");
        this.binding.electorPostofficeTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getPostOffice()) ? formlist.getElectorEpicDTO().getPostOffice() : "");
        this.binding.electorPincodeTv1.setText(!TextUtils.isEmpty(formlist.getElectorEpicDTO().getPinCode()) ? formlist.getElectorEpicDTO().getPinCode() : "");
        this.binding.electorTehsilTv1.setText(TextUtils.isEmpty(formlist.getElectorEpicDTO().getTehsilTalukaMandal()) ? "" : formlist.getElectorEpicDTO().getTehsilTalukaMandal());
        if (TextUtils.isEmpty(formlist.getElectorEpicDTO().getPhoto())) {
            return;
        }
        getPersonImageUploadedfilePersonalDetials(formlist.getElectorEpicDTO().getPhoto(), this.binding.electorPersonImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApplicantDetails(Root formlist) {
        this.binding.applicantNameTv1.setText((!TextUtils.isEmpty(formlist.getApplicantEpicDto().getApplicantFirstName()) ? formlist.getApplicantEpicDto().getApplicantFirstName() : "") + StringUtils.SPACE + (!TextUtils.isEmpty(formlist.getApplicantEpicDto().getApplicantLastName()) ? formlist.getApplicantEpicDto().getApplicantLastName() : ""));
        this.binding.epicTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getEpicNumber()) ? formlist.getApplicantEpicDto().getEpicNumber() : "");
        this.binding.acTv1.setText(formlist.getApplicantEpicDto().getAssemblyConstituencyNumber() != 0 ? String.valueOf(formlist.getApplicantEpicDto().getAssemblyConstituencyNumber()) : "");
        this.binding.partTv1.setText(formlist.getApplicantEpicDto().getPartNumber() != 0 ? String.valueOf(formlist.getApplicantEpicDto().getPartNumber()) : "");
        this.binding.srNoTv1.setText(formlist.getApplicantEpicDto().getPartSerialNumber() != 0 ? String.valueOf(formlist.getApplicantEpicDto().getPartSerialNumber()) : "");
        this.binding.sectionTv1.setText(formlist.getApplicantEpicDto().getSectionNo() != 0 ? String.valueOf(formlist.getApplicantEpicDto().getSectionNo()) : "");
        this.binding.mobileTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getMobileNumber()) ? formlist.getApplicantEpicDto().getMobileNumber() : "");
        this.binding.emailTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getEmailId()) ? formlist.getApplicantEpicDto().getEmailId() : "");
        this.binding.houseTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getHouseNumber()) ? formlist.getApplicantEpicDto().getHouseNumber() : "");
        this.binding.streetTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getLocalityStreet()) ? formlist.getApplicantEpicDto().getLocalityStreet() : "");
        this.binding.townTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getBirthTown()) ? formlist.getApplicantEpicDto().getBirthTown() : "");
        this.binding.postofficeTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getPostOffice()) ? formlist.getApplicantEpicDto().getPostOffice() : "");
        this.binding.pincodeTv1.setText(!TextUtils.isEmpty(formlist.getApplicantEpicDto().getPinCode()) ? formlist.getApplicantEpicDto().getPinCode() : "");
        this.binding.tehsilTv1.setText(TextUtils.isEmpty(formlist.getApplicantEpicDto().getTehsilTalukaMandal()) ? "" : formlist.getApplicantEpicDto().getTehsilTalukaMandal());
        if (TextUtils.isEmpty(formlist.getApplicantEpicDto().getPhoto())) {
            return;
        }
        getPersonImageUploadedfilePersonalDetials(formlist.getApplicantEpicDto().getPhoto(), this.binding.personImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFormDetails(Root formlist) {
        this.binding.formNumberValue.setText(!TextUtils.isEmpty(formlist.getForm7ReferenceNumber()) ? formlist.getForm7ReferenceNumber() : "");
        this.binding.form7Value.setText(!TextUtils.isEmpty(formlist.getForm7ReasonForDeletion()) ? formlist.getForm7ReasonForDeletion() : "");
        this.binding.electorReasonTv1.setText(!TextUtils.isEmpty(formlist.getForm7ReasonForDeletion()) ? formlist.getForm7ReasonForDeletion() : "");
        this.binding.formTypeValue.setText(!TextUtils.isEmpty(formlist.getForm7SubmissionChannel()) ? formlist.getForm7SubmissionChannel() : "");
        if (!TextUtils.isEmpty(formlist.getForm7SubmissionDate())) {
            this.binding.submissionDateValue.setText(OffsetDateTime.parse(formlist.getForm7SubmissionDate()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        }
        this.binding.stateValue.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getStateCd()) ? formlist.getElectorEpicDTO().getStateCd() : "") + "-" + (!TextUtils.isEmpty(formlist.getElectorEpicDTO().getStateName()) ? formlist.getElectorEpicDTO().getStateName() : ""));
        this.binding.districtValue.setText((!TextUtils.isEmpty(formlist.getElectorEpicDTO().getDistrictCd()) ? formlist.getElectorEpicDTO().getDistrictCd() : "") + "-" + (TextUtils.isEmpty(formlist.getElectorEpicDTO().getDistrictName()) ? "" : formlist.getElectorEpicDTO().getDistrictName()));
        getCurrentLocation();
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$4(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog3$5(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getPersonImageUploadedfilePersonalDetials(String fileName, ImageView personImage) {
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getFile(this.objectStorage, fileName, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this.channelidobo, "blo", this.bloApp, "ANDROIMOB").enqueue(new AnonymousClass7(personImage));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ ImageView val$personImage;

        AnonymousClass7(final ImageView val$personImage) {
            this.val$personImage = val$personImage;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Log.d(FomatC7DetailsActivity.this.TAG, "error in image" + jsonObject.get("file"));
                FomatC7DetailsActivity.this.bitmapPersonImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(String.valueOf(jsonObject.get("file")).replace(RegexMatcher.JSON_STRING_REGEX, ""), 0)));
                this.val$personImage.setImageBitmap(FomatC7DetailsActivity.this.bitmapPersonImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                FomatC7DetailsActivity.this.refreshTokenApi();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Log.d(FomatC7DetailsActivity.this.TAG, "errorApi" + response.errorBody());
                Log.d(FomatC7DetailsActivity.this.TAG, "imageError" + jSONObject.optString(FomatC7DetailsActivity.this.message));
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$7$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
            } catch (IOException | JSONException e) {
                Logger.d(FomatC7DetailsActivity.this.TAG, "exception" + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FomatC7DetailsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            FomatC7DetailsActivity.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.d(FomatC7DetailsActivity.this.TAG, "comingInOnFailure" + t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void refreshTokenApi() {
        this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda0
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$8(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshTokenApi$8(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$6(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(this).setRefreshToken(str2);
        SharedPref.getInstance(this).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(this, this.alertText, "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$7(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshTokenApi$6(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$7(DialogInterface dialogInterface, int i) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile(final int code, String listCode) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(this.chooseFile);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$9(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$9(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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
                    this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
                    ImageView imageView = this.binding.photo1;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photo1Size.setText(this.filesize + "KB");
                    return;
                }
                if (j > 2048) {
                    this.binding.bloSignatureLayout.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                    return;
                }
                long j2 = j / 1024;
                this.filesize = j2;
                if (Math.round(j2 * 100.0d) / 100.0d > 2.0d) {
                    this.binding.bloSignatureLayout.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.content.getFormRefNo(), "BLO sign");
                this.binding.bloSignatureLayout.setVisibility(0);
                this.binding.chooseBloSignature.setVisibility(8);
                this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
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
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$10(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$10(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(reference, MediaType.parse("fileName"));
        restClient.uploadImageWithData1(Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", partCreateFormData, RequestBody.create(this.applicationpdf, MediaType.parse("fileType")), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass8(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass8(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v8, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
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
                CommomUtility commomUtility = FomatC7DetailsActivity.this.commomUtility;
                ?? r13 = FomatC7DetailsActivity.this;
                String str = ((FomatC7DetailsActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$8$$ExternalSyntheticLambda0
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
                handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$8$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2(str9, strValueOf);
                    }
                }, 2000L);
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            if (this.val$uploadtype.equals("BLO sign")) {
                if (FomatC7DetailsActivity.this.alertDialog != null) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                }
                FomatC7DetailsActivity.this.binding.bloSignatureLayout.setVisibility(8);
                FomatC7DetailsActivity.this.binding.chooseBloSignature.setVisibility(0);
                FomatC7DetailsActivity.this.binding.chooseBloSignature.setEnabled(true);
                FomatC7DetailsActivity fomatC7DetailsActivity = FomatC7DetailsActivity.this;
                fomatC7DetailsActivity.showDialog1(fomatC7DetailsActivity.alertText, FomatC7DetailsActivity.this.fileNotFoundMessage);
                return;
            }
            if (this.val$uploadtype.equals("elector sign")) {
                if (FomatC7DetailsActivity.this.alertDialog != null) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                }
                FomatC7DetailsActivity.this.binding.applicantLayout.setVisibility(8);
                FomatC7DetailsActivity.this.binding.chooseApplicantSignature.setVisibility(0);
                FomatC7DetailsActivity.this.binding.chooseApplicantSignature.setEnabled(true);
                FomatC7DetailsActivity fomatC7DetailsActivity2 = FomatC7DetailsActivity.this;
                fomatC7DetailsActivity2.showDialog1(fomatC7DetailsActivity2.alertText, FomatC7DetailsActivity.this.fileNotFoundMessage);
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
                FomatC7DetailsActivity.this.commomUtility.showMessageOK(FomatC7DetailsActivity.this, FomatC7DetailsActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$8$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FomatC7DetailsActivity.this.token = "Bearer " + str8;
            FomatC7DetailsActivity.this.refreshToken = str9;
            SharedPref.getInstance(FomatC7DetailsActivity.this).setRefreshToken(str9);
            SharedPref.getInstance(FomatC7DetailsActivity.this).setToken("Bearer " + str8);
            FomatC7DetailsActivity fomatC7DetailsActivity = FomatC7DetailsActivity.this;
            fomatC7DetailsActivity.uploadPhoto(str, str2, str3, str4, str5, fomatC7DetailsActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FomatC7DetailsActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(FomatC7DetailsActivity.this).setLocaleBool(false);
            FomatC7DetailsActivity.this.startActivity(new Intent((Context) FomatC7DetailsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2) {
            if (str.equals("BLO sign")) {
                FomatC7DetailsActivity.this.bloSignature = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("bloSignUrl", FomatC7DetailsActivity.this.bloSignature);
                if (FomatC7DetailsActivity.this.alertDialog != null) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (str.equals("elector sign")) {
                FomatC7DetailsActivity.this.applicantSignature = str2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("applicantSignurl", FomatC7DetailsActivity.this.applicantSignature);
                if (FomatC7DetailsActivity.this.alertDialog != null) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda10
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$11(task);
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
    public /* synthetic */ void lambda$getCurrentLocation$11(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                Logger.d("place gps", fromLocation.get(0).getLocality());
                if (fromLocation.get(0).getLocality().isEmpty()) {
                    this.binding.verificationPlaceEd.setEnabled(true);
                    this.binding.verificationPlaceEd.setFocusable(true);
                    this.binding.verificationPlaceEd.setFocusableInTouchMode(true);
                } else {
                    this.binding.verificationPlaceEd.setText(fromLocation.get(0).getLocality());
                    this.binding.verificationPlaceEd.setEnabled(false);
                }
            } catch (Exception e) {
                Logger.d("place exception", e.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FomatC7DetailsActivity) Objects.requireNonNull(this)).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient((Activity) Objects.requireNonNull(this)).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity$$ExternalSyntheticLambda2
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$12(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$12(Task task) {
        try {
            Log.d(this.TAG, "LocationSettingsResponse ---> " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    Log.d(this.TAG, "Device does not have location");
                }
            } else {
                try {
                    e.startResolutionForResult(this, 2);
                } catch (IntentSender.SendIntentException e2) {
                    Logger.d(this.TAG, "Exception turnOnGPS ---> " + e2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validate() {
        if (!this.content.getFormType().equalsIgnoreCase("F7")) {
            return true;
        }
        if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
            showdialog(this.alertText, "Please verify if applicant was present");
            return false;
        }
        if (this.binding.commentRg.getCheckedRadioButtonId() == -1) {
            showdialog(this.alertText, "Please select BLO comment");
            return false;
        }
        if (TextUtils.isEmpty(this.binding.anyotherremark.getText().toString())) {
            showdialog(this.alertText, "Please enter remark");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.verificationPlaceEd.getText().toString())) {
            return true;
        }
        showdialog(this.alertText, "Please enter place");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submit() {
        this.acNumner = String.valueOf(this.content.getAcNo());
        this.part = String.valueOf(this.content.getPartNo());
        this.id = String.valueOf(this.content.getId());
        this.epicNo = this.content.getEpicNo();
        this.partSerialNo = String.valueOf(this.content.getPartSerialNo());
        this.formRefNo = this.form7data.getForm7ReferenceNumber();
        this.formType = this.content.getFormType();
        this.statusID = String.valueOf(this.content.getStatusID());
        String str = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        Log.d("DATE_TIME", str);
        this.place = this.binding.verificationPlaceEd.getText().toString();
        this.mobile = this.binding.mobileTv1.getText().toString();
        String str2 = this.binding.absentRb.isChecked() ? "Y" : "N";
        String str3 = this.binding.underAgeRb.isChecked() ? "Y" : "N";
        String str4 = this.binding.deadRb.isChecked() ? "Y" : "N";
        String str5 = this.binding.alreadyEnrolledRb.isChecked() ? "Y" : "N";
        String str6 = this.binding.notIndianCitizenRb.isChecked() ? "Y" : "N";
        if (this.content.getFormType().equalsIgnoreCase("F7")) {
            this.remarks = this.binding.anyotherremark.getText().toString();
            if (this.binding.correctRb.isChecked()) {
                this.isDetailsCorrect = "Y";
                this.hasDataEntryError = "N";
                this.bloComments = "Y";
            } else {
                this.isDetailsCorrect = "N";
                this.hasDataEntryError = "Y";
                this.bloComments = "N";
            }
        }
        this.alertDialog.show();
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
        map2.put("isNameVerified", String.valueOf(this.isNameVerified));
        map2.put("isAddressVerified", String.valueOf(this.isAddressVerified));
        map2.put("isDOBVerified", String.valueOf(this.isDOBVerified));
        map2.put("isphotoAsPerSpec", String.valueOf(this.isphotoAsPerSpec));
        map2.put("isMobileVerified", this.isMobileVerified);
        map2.put("isAgeVerified", this.isAgeVerified);
        map2.put("isGenderVerified", this.isGenderVerified);
        map2.put("isRelativeVerified", this.isRelativeVerified);
        map2.put("isRelationVerified", this.isRelationVerified);
        map2.put("fieldVerificationAbsent", str2.trim());
        map2.put("fieldVerificationDead", str4.trim());
        map2.put("fieldVerificationUnderAge", str3.trim());
        map2.put("fieldVerificationAlreadyEnrolled", str5.trim());
        map2.put("fieldVerificationNotIndianCitizen", str6.trim());
        map2.put("fieldVerificationShifted", "N");
        map2.put("fieldVerificationNoSuchPerson", "N");
        map2.put("fieldVerificationPersonPresent", "N");
        map2.put("bloComments", this.bloComments);
        map2.put("fvrRemarks", this.remarks);
        map2.put("correctedName", this.correctedName);
        map2.put("dobOrAge", this.dobOrAge);
        map2.put("gender", this.gender);
        map2.put("relationName", this.relationName);
        map2.put("relationType", this.relationType);
        map2.put("houseNo", this.houseNo);
        map2.put("streetArea", this.streetArea);
        map2.put("townVillage", this.townVillage);
        map2.put("postOffice", this.postOffice);
        map2.put("tehsilTalukaMandal", this.tehsilTalukaMandal);
        map2.put("pinCode", this.pinCode);
        map2.put("place", this.place);
        map2.put("dob", null);
        map2.put("age", null);
        map2.put("epicID", null);
        map2.put("mobileNumber", this.mobile);
        map2.put("epicNo", this.epicNo);
        map2.put("acNo", this.acNumner);
        map2.put("partNo", this.part);
        map2.put("partSerialNo", this.partSerialNo);
        map2.put("formRefNo", this.formRefNo);
        map2.put("statusID", 2);
        map2.put("formType", this.formType);
        map2.put("verificationDate", str);
        map2.put("applicantSignature", this.applicantSignature);
        map2.put("bloSignature", this.bloSignature);
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).formatCSubmit(map, map2).enqueue(new Callback<Void>() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.9
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
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
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    FomatC7DetailsActivity fomatC7DetailsActivity = FomatC7DetailsActivity.this;
                    fomatC7DetailsActivity.showDialog3(fomatC7DetailsActivity.alertText, "Form submitted successfully");
                    return;
                }
                FomatC7DetailsActivity.this.alertDialog.dismiss();
                try {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    Utils utils = FomatC7DetailsActivity.this.utils;
                    ?? r0 = FomatC7DetailsActivity.this;
                    utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), string);
                } catch (Exception e) {
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    Logger.d("TAG", e.toString());
                }
            }

            public void onFailure(Call<Void> call, Throwable t) {
                Logger.d("TAG", t.toString());
                FomatC7DetailsActivity.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 115) {
            this.bloSignature = null;
            this.binding.chooseBloSignature.setVisibility(0);
            this.binding.bloSignatureLayout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.binding.photo1Name.setText("");
            return;
        }
        if (code == 116) {
            this.applicantSignature = null;
            this.binding.chooseApplicantSignature.setVisibility(0);
            this.binding.applicantLayout.setVisibility(8);
            this.binding.applicantPhoto1Size.setText("");
            this.binding.applicantPhoto1Name.setText("");
        }
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
        this.commomUtility.submitForm(this, map, map2, new FormatCListCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.10
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity] */
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
                    FomatC7DetailsActivity.this.alertDialog.dismiss();
                    Utils utils = FomatC7DetailsActivity.this.utils;
                    ?? r4 = FomatC7DetailsActivity.this;
                    utils.infoDialogAction(r4, r4.alertText, "Form submitted successfully", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity.10.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FomatC7DetailsActivity.this.finish();
                        }
                    });
                    return;
                }
                FomatC7DetailsActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = FomatC7DetailsActivity.this.utils;
                ?? r5 = FomatC7DetailsActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }
}
