package in.gov.eci.bloapp.views.fragments.checklist;

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
import android.os.LocaleList;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
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
import androidx.lifecycle.ViewModelProvider;
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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.FormData;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.customadapter.CustomSpinnerAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentApplicantDetailsForm7Binding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.languagetransliteration.db.DBClient;
import in.gov.eci.bloapp.languagetransliteration.db.TState;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ApplicantDetailsForm7Fragment extends Hilt_ApplicantDetailsForm7Fragment implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    private static final String ABSENTPERMANENTLYSHIFTED = "Absent/Permanently shifted";
    private static final String ALREADYENROLLED = "Already Enrolled";
    private static final String CHECKLISTFORM7 = "CHECKLIST FORM7";
    private static final String DEATHSTRING = "Death";
    private static final String NOTINDIANCITIZEN = "Not Indian Citizen";
    private static final String OBJECTIONSTRING = "objection";
    private static final String OTHERSTRING = "other";
    private static final String PERMANENTLYSHIFTED = "Permanently shifted";
    private static final String SAMESTRING = "same";
    private static final String UNDERAGE = "Under Age";
    static int spanExclusiveExclusive = 33;
    String actionDate;
    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<Intent> activityResultLauncher480;
    ActivityResultLauncher<Intent> activityResultLauncher481;
    private String age;
    String alert;
    AlertDialog alertDialog;
    String appName;
    private String applicantPlace;
    private String asmblyNO;
    private BloFragmentApplicantDetailsForm7Binding binding;
    String bucketName;
    private byte[] byteArray;
    private byte[] byteArrayReset;
    String comingInOnFailure;
    private View currentSelectedView;
    private int currentStatusId;
    private String districtCdOfPersonToBeDeleted;
    private String districtCode;
    private String docref;
    private String email;
    String epicNumber;
    private String firstNameApplicant;
    private int formProcessingDetailsId;
    private String formSubmissionChannel;
    private String formSubmissionMode;
    private String formSubmissionPlace;
    private String gender;
    private String houseReset;
    private String id;
    String inclusionString;
    private String isSelfMobile;
    private String lastNameApplicant;
    String lat;
    private LocationRequest locationRequest;
    String longi;
    String message;
    private String mobileReset;
    private String modifieddttm;
    private String notSamedob;
    String objectToInclFormRefNum;
    String objectToInclFormType;
    private String offlineSignedPage1Url;
    private String offlineSignedPage2Url;
    String otherDeletionString;
    private String partLang;
    private String partLangSubString;
    private String partNo;
    private String partNumberApplicant;
    private String partNumberOfPersonToBeDeleted;
    String pdf3;
    private byte[] pdfbyteArray;
    String pestatecd;
    private String photoref;
    private String pincodeReset;
    private String postofficeReset;
    private int processMasterId;
    String prvsAcNo;
    int prvsEpicId;
    String prvsPartNumber;
    String prvsSLNo;
    private HashMap<String, String> reasonmap;
    private String referenceNo;
    private String refreshToken;
    Retrofit.Builder retroFitBuilder;
    Retrofit retrofit;
    private String sectionNo;
    String selectReason;
    String selfDeletionString;
    private String serialNumber;
    private String serialNumberOfPersonToBeDeleted;
    String sessionTokenExpiredPleaseLogin;
    private String stateCode;
    private String streetReset;
    private String surname;
    private String tehsilReset;
    private String token;
    String uploadDoc1DocumentEncoded;
    String uploadDoc2DocumentEncoded;
    private CheckListViewModel viewModel;
    private String villageReset;
    int visitCountId;
    String whitecolor;
    private int workflowConfigId;
    String mobileNumberApplicantString = "mobileNumberApplicant";
    String mobileNumberSelfString = "mobileNumberSelf";
    String mobileNumberOfRelativeString = "mobileNumberOfRelative";
    String lastNameOfPersonToBeDeletedString = "lastNameOfPersonToBeDeleted";
    String epicNumberOfPersonToBeDeletedString = "epicNumberOfPersonToBeDeleted";
    String pleaseSubmitAgain = "Please submit again";
    String noDocumentAvailable = "No Document Available";
    String formSubmissionChannelString = "formSubmissionChannel";
    String formSubmissionModeString = "formSubmissionMode";
    String districtCdOfPersonToBeDeletedString = "districtCdOfPersonToBeDeleted";
    String tehsilTalukaMandalString = "tehsilTalukaMandal";
    String pinCodeString = "pinCode";
    String postOfficeString = "postOffice";
    String townVillageString = "townVillage";
    String localityStreetString = "localityStreet";
    String houseNumberString = "houseNumber";
    String epicNumberApplicantString = "epicNumberApplicant";
    String reasonForDeletionString = "reasonForDeletion";
    String english_code = "en_in";
    private String request = "";
    private String rejectionOption = "";
    private String rejectionOptionSubcategory = "";
    private String originalReasonforDeletion = "";
    private String prvsReasonForDeletion = "";
    private String base64element = "";
    private String base64element1 = "";
    private String isCertiAttachReset = "";
    private String optionRbReset = "";
    private String subOptionReset = "";
    Boolean checkEpic = false;
    CommomUtility commonutils = new CommomUtility();
    String img = "image";
    String imgmsg = "Can't obtain file name, cursor is empty";
    String greycolor = "#99000000";
    String takephoto = "Take Photo";
    String choosegallery = "Choose Image from Gallery";
    String cancel = "Cancel";
    String choosepdf = "Choose PDF from Gallery";
    String chooseFile = "Choose File";
    String applicationpdf = "application/pdf";
    String addphoto = "Add Photo!";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public ApplicantDetailsForm7Fragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonutils.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.retroFitBuilder = builderClient;
        this.retrofit = builderClient.build();
        this.alert = "Alert";
        this.selectReason = "Select Reason";
        this.otherDeletionString = "I request to delete name of the person mentioned below already included in the current roll due to any one of the following reasons,";
        this.inclusionString = "I object to proposed inclusion of name of the person mentioned below due to any one of the following reasons,";
        this.selfDeletionString = "I request to delete my name from electoral roll due to any one of the following reasons,";
        this.bucketName = "objectstorage";
        this.appName = "BLOAPP";
        this.message = "message";
        this.pdf3 = "PDF size exceeded 3MB limit.";
        this.sessionTokenExpiredPleaseLogin = "Session token expired please Login";
        this.comingInOnFailure = "coming in onFailure ";
        this.visitCountId = 0;
        this.whitecolor = "#000000";
        this.notSamedob = "N";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda11
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$18((ActivityResult) obj);
            }
        });
        this.activityResultLauncher481 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.28
            public void onActivityResult(ActivityResult result) throws Throwable {
                ByteArrayOutputStream byteArrayOutputStream;
                Throwable th;
                if (result.getResultCode() == -1) {
                    Uri data = result.getData().getData();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        InputStream inputStreamOpenInputStream = ApplicantDetailsForm7Fragment.this.getContext().getContentResolver().openInputStream(data);
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
                            } catch (Throwable th4) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                th = th4;
                            }
                        } catch (Exception e) {
                            e = e;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            Logger.d("", e.getMessage());
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    ApplicantDetailsForm7Fragment.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                    try {
                        Uri saveImagePath = ApplicantDetailsForm7Fragment.this.getSaveImagePath(Base64.encodeToString(ApplicantDetailsForm7Fragment.this.pdfbyteArray, 0), ".pdf");
                        Cursor cursorQuery = ApplicantDetailsForm7Fragment.this.getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                        if (cursorQuery.getCount() <= 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ApplicantDetailsForm7Fragment.this.imgmsg);
                        }
                        cursorQuery.moveToFirst();
                        String[] strArrSplit = saveImagePath.getPath().split("/");
                        if (ApplicantDetailsForm7Fragment.this.filesize < 1024) {
                            double dRound = Math.round(ApplicantDetailsForm7Fragment.this.filesize * 100.0d) / 100.0d;
                            cursorQuery.close();
                            ApplicantDetailsForm7Fragment.this.alertDialog.show();
                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                            applicantDetailsForm7Fragment.saveimageapi(applicantDetailsForm7Fragment.saveImageFileName, "UploadForm6Page2");
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Certi.setVisibility(0);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc2ChooseFile.setTextColor(Color.parseColor(ApplicantDetailsForm7Fragment.this.greycolor));
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Size.setText(dRound + "KB");
                        } else {
                            double dRound2 = Math.round(((double) (ApplicantDetailsForm7Fragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                            cursorQuery.close();
                            if (dRound2 > 3.0d) {
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment2.showdialog("ALERT", applicantDetailsForm7Fragment2.pdf3);
                            } else {
                                ApplicantDetailsForm7Fragment.this.alertDialog.show();
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment3.saveimageapi(applicantDetailsForm7Fragment3.saveImageFileName, "UploadForm6Page2");
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Certi.setVisibility(0);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2ChooseFile.setTextColor(Color.parseColor(ApplicantDetailsForm7Fragment.this.greycolor));
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Size.setText(dRound2 + "MB");
                            }
                        }
                        cursorQuery.close();
                    } catch (Exception e3) {
                        Logger.d("", e3.getMessage());
                    }
                }
            }
        });
        this.activityResultLauncher480 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.29
            public void onActivityResult(ActivityResult result) throws Throwable {
                ByteArrayOutputStream byteArrayOutputStream;
                Throwable th;
                if (result.getResultCode() == -1) {
                    Uri data = result.getData().getData();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        InputStream inputStreamOpenInputStream = ApplicantDetailsForm7Fragment.this.getContext().getContentResolver().openInputStream(data);
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
                            } catch (Throwable th4) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                th = th4;
                            }
                        } catch (Exception e) {
                            e = e;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            Logger.d("", e.getMessage());
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    ApplicantDetailsForm7Fragment.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                    try {
                        Uri saveImagePath = ApplicantDetailsForm7Fragment.this.getSaveImagePath(Base64.encodeToString(ApplicantDetailsForm7Fragment.this.pdfbyteArray, 0), ".pdf");
                        Cursor cursorQuery = ApplicantDetailsForm7Fragment.this.getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                        if (cursorQuery.getCount() <= 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ApplicantDetailsForm7Fragment.this.imgmsg);
                        }
                        cursorQuery.moveToFirst();
                        String[] strArrSplit = saveImagePath.getPath().split("/");
                        if (ApplicantDetailsForm7Fragment.this.filesize < 1024) {
                            double dRound = Math.round(ApplicantDetailsForm7Fragment.this.filesize * 100.0d) / 100.0d;
                            cursorQuery.close();
                            ApplicantDetailsForm7Fragment.this.alertDialog.show();
                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                            applicantDetailsForm7Fragment.saveimageapi(applicantDetailsForm7Fragment.saveImageFileName, "UploadForm6Page1");
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Certi.setVisibility(0);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc1ChooseFile.setTextColor(Color.parseColor(ApplicantDetailsForm7Fragment.this.greycolor));
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                            ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Size.setText(dRound + "KB");
                        } else {
                            double dRound2 = Math.round(((double) (ApplicantDetailsForm7Fragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                            cursorQuery.close();
                            if (dRound2 > 3.0d) {
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment2.showdialog("ALERT", applicantDetailsForm7Fragment2.pdf3);
                            } else {
                                ApplicantDetailsForm7Fragment.this.alertDialog.show();
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment3.saveimageapi(applicantDetailsForm7Fragment3.saveImageFileName, "UploadForm6Page1");
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Certi.setVisibility(0);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1ChooseFile.setTextColor(Color.parseColor(ApplicantDetailsForm7Fragment.this.greycolor));
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Size.setText(dRound2 + "MB");
                            }
                        }
                        cursorQuery.close();
                    } catch (Exception e3) {
                        Logger.d("", e3.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.rejection_spinner1 /* 2131365568 */:
                if (parent.getItemAtPosition(position).toString().equals(DEATHSTRING)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRb.setChecked(true);
                }
                break;
            case R.id.rejection_spinner2 /* 2131365569 */:
                if (parent.getItemAtPosition(position).toString().equals(DEATHSTRING)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRb.setChecked(true);
                }
                break;
            case R.id.rejection_spinner3 /* 2131365570 */:
                this.binding.deathLayout.setVisibility(8);
                this.binding.noRb.setChecked(true);
                break;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentApplicantDetailsForm7Binding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        String stateName = SharedPref.getInstance(requireContext()).getStateName();
        String districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.textView33.setText(getResources().getString(R.string.blo_form_type) + "  v" + new CommomUtility().appversion);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        this.viewModel = (CheckListViewModel) new ViewModelProvider(requireActivity()).get(CheckListViewModel.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.referenceNo = arguments.getString("refNo");
            this.formProcessingDetailsId = arguments.getInt("formProcessingId");
            this.currentStatusId = arguments.getInt("currentStatusid");
            this.photoref = arguments.getString("photo");
            this.processMasterId = arguments.getInt("processMasterId");
            this.visitCountId = arguments.getInt("visitCount");
            this.actionDate = arguments.getString("actionDate");
            Log.d("TAG", "actionDate by bundle" + this.actionDate);
            Log.d("TAG", "visitCountId by bundle" + this.visitCountId);
            if (this.visitCountId > 0) {
                this.binding.totalVisitCount.setVisibility(0);
                this.binding.totalVisitCount.setText("Visit count : " + this.visitCountId);
            } else {
                this.binding.totalVisitCount.setVisibility(8);
            }
        }
        this.binding.refNoTv.setText(this.referenceNo);
        this.binding.state.setText(stateName);
        this.binding.district.setText(districtName);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        getCurrentLocation();
        this.reasonmap = new HashMap<>();
        this.commonutils.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda24
            @Override // in.gov.eci.bloapp.FormData
            public final void onCallback(ArrayList arrayList, HashMap map, int i) {
                this.f$0.lambda$onCreateView$2(arrayList, map, i);
            }
        });
        this.binding.personalEdit.setVisibility(8);
        this.binding.optionsEdit.setVisibility(8);
        this.binding.detailsofpersonEdit.setVisibility(8);
        this.binding.samePDRb.setChecked(true);
        this.binding.sameDobRb.setChecked(true);
        this.binding.addressSame.setChecked(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.selectReason);
        arrayList.add(DEATHSTRING);
        arrayList.add(UNDERAGE);
        arrayList.add(ABSENTPERMANENTLYSHIFTED);
        arrayList.add(ALREADYENROLLED);
        arrayList.add(NOTINDIANCITIZEN);
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, arrayList);
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) customSpinnerAdapter);
        this.binding.rejectionSpinner1.setSelection(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.selectReason);
        arrayList2.add(DEATHSTRING);
        arrayList2.add(UNDERAGE);
        arrayList2.add(ABSENTPERMANENTLYSHIFTED);
        arrayList2.add(ALREADYENROLLED);
        arrayList2.add(NOTINDIANCITIZEN);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, arrayList2);
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) customSpinnerAdapter2);
        this.binding.rejectionSpinner2.setSelection(0);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(this.selectReason);
        arrayList3.add(PERMANENTLYSHIFTED);
        arrayList3.add(ALREADYENROLLED);
        arrayList3.add(NOTINDIANCITIZEN);
        CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, arrayList3);
        customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) customSpinnerAdapter3);
        this.binding.rejectionSpinner3.setSelection(0);
        this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
        this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
        this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
        loadData();
        this.binding.houseEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.streetEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.villageEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.postofficeEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.tehsilEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.houseEd.setInputType(532624);
        this.binding.streetEd.setInputType(532624);
        this.binding.villageEd.setInputType(532624);
        this.binding.postofficeEd.setInputType(532624);
        this.binding.tehsilEd.setInputType(532624);
        this.partLangSubString = this.partLang.substring(0, 2);
        Log.d("TAG", "partLang ---> " + this.partLangSubString);
        this.binding.houseEd2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.streetEd2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.villageEd2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.postofficeEd2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.tehsilEd2.setImeHintLocales(new LocaleList(new Locale(this.partLangSubString, Constants.COUNTRYNAME1)));
        this.binding.houseEd.setImportantForAutofill(2);
        this.binding.streetEd.setImportantForAutofill(2);
        this.binding.villageEd.setImportantForAutofill(2);
        this.binding.postofficeEd.setImportantForAutofill(2);
        this.binding.tehsilEd.setImportantForAutofill(2);
        this.binding.houseEd2.setImportantForAutofill(2);
        this.binding.streetEd2.setImportantForAutofill(2);
        this.binding.villageEd2.setImportantForAutofill(2);
        this.binding.postofficeEd2.setImportantForAutofill(2);
        this.binding.tehsilEd2.setImportantForAutofill(2);
        this.binding.houseEd2.setOnFocusChangeListener(this);
        this.binding.streetEd2.setOnFocusChangeListener(this);
        this.binding.villageEd2.setOnFocusChangeListener(this);
        this.binding.postofficeEd2.setOnFocusChangeListener(this);
        this.binding.tehsilEd2.setOnFocusChangeListener(this);
        this.binding.houseEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7Fragment.this.binding.houseEd.getText().toString();
                if (ApplicantDetailsForm7Fragment.this.binding.houseEd.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.binding.houseEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7Fragment.this.binding.houseEd.setSelection(ApplicantDetailsForm7Fragment.this.binding.houseEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.binding.houseEd2.getText().clear();
                }
            }
        });
        this.binding.houseEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7Fragment.this.binding.houseEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7Fragment.this.binding.houseEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7Fragment.this.binding.houseEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7Fragment.this.binding.houseEd2.getText().toString().matches(RegexMatcher.HOUSE_REGIONAL_REGEX)) {
                        sb.deleteCharAt(ApplicantDetailsForm7Fragment.this.binding.houseEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7Fragment.this.binding.houseEd2.setText(sb);
                        ApplicantDetailsForm7Fragment.this.binding.houseEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.streetEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7Fragment.this.binding.streetEd.getText().toString();
                if (ApplicantDetailsForm7Fragment.this.binding.streetEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.binding.streetEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7Fragment.this.binding.streetEd.setSelection(ApplicantDetailsForm7Fragment.this.binding.streetEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.binding.streetEd2.getText().clear();
                }
            }
        });
        this.binding.streetEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7Fragment.this.binding.streetEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7Fragment.this.binding.streetEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7Fragment.this.binding.streetEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7Fragment.this.binding.streetEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7Fragment.this.binding.streetEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7Fragment.this.binding.streetEd2.setText(sb);
                        ApplicantDetailsForm7Fragment.this.binding.streetEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.villageEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7Fragment.this.binding.villageEd.getText().toString();
                if (ApplicantDetailsForm7Fragment.this.binding.villageEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.binding.villageEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7Fragment.this.binding.villageEd.setSelection(ApplicantDetailsForm7Fragment.this.binding.villageEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.binding.villageEd2.getText().clear();
                }
            }
        });
        this.binding.villageEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7Fragment.this.binding.villageEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7Fragment.this.binding.villageEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7Fragment.this.binding.villageEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7Fragment.this.binding.villageEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7Fragment.this.binding.villageEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7Fragment.this.binding.villageEd2.setText(sb);
                        ApplicantDetailsForm7Fragment.this.binding.villageEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.postofficeEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7Fragment.this.binding.postofficeEd.getText().toString();
                if (ApplicantDetailsForm7Fragment.this.binding.postofficeEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.binding.postofficeEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7Fragment.this.binding.postofficeEd.setSelection(ApplicantDetailsForm7Fragment.this.binding.postofficeEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getText().clear();
                }
            }
        });
        this.binding.postofficeEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.setText(sb);
                        ApplicantDetailsForm7Fragment.this.binding.postofficeEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.tehsilEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7Fragment.this.binding.tehsilEd.getText().toString();
                if (ApplicantDetailsForm7Fragment.this.binding.tehsilEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.binding.tehsilEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7Fragment.this.binding.tehsilEd.setSelection(ApplicantDetailsForm7Fragment.this.binding.tehsilEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getText().clear();
                }
            }
        });
        this.binding.tehsilEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.setText(sb);
                        ApplicantDetailsForm7Fragment.this.binding.tehsilEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.verificationDateEd.setText(new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date()));
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.objecteeImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.mobNumRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda27
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$5(radioGroup, i);
            }
        });
        this.binding.personalDetailsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$6(radioGroup, i);
            }
        });
        this.binding.rejectionRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$7(radioGroup, i);
            }
        });
        this.binding.detailsOfpersonRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$8(radioGroup, i);
            }
        });
        this.binding.deathCertificateBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.rejectionOptionsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$10(radioGroup, i);
            }
        });
        this.binding.deathCertificateReg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$11(radioGroup, i);
            }
        });
        this.binding.uploadDoc1ChooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.selectImage5();
            }
        });
        this.binding.uploadDoc2ChooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.selectImage6();
            }
        });
        this.binding.uploadDoc1Delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.deleteuploadDocPage1();
            }
        });
        this.binding.uploadDoc2Delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.deleteuploadDocPage2();
            }
        });
        this.binding.tvUploadformDocEditTextview.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Delete.setVisibility(0);
                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Delete.setVisibility(0);
            }
        });
        this.binding.uploadformDocButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Delete.setVisibility(0);
                ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Delete.setVisibility(0);
            }
        });
        starMarkerAndRemover();
        initializingClicks();
        initClickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(ArrayList arrayList, HashMap map, int i) {
        if (i == 401) {
            this.commonutils.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda16
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onCreateView$1(i2, str, str2);
                }
            });
        } else if (map == null) {
            this.alertDialog.dismiss();
            showdialogFinal(this.alert, "Please try again after some time");
        } else {
            this.reasonmap = map;
            getForm7byFormRefId(this.binding.refNoTv.getText().toString(), this.stateCode, this.token);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonutils.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$0(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        showdialogFinal(this.alert, "Page refreshed due to the token expiry");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        String str;
        if (!this.base64element.isEmpty() && !this.base64element.equals("null") && (str = this.base64element) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.photoref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.mobNumRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131365613) {
            this.isSelfMobile = "N";
        } else {
            if (checkedRadioButtonId != 2131365879) {
                return;
            }
            this.isSelfMobile = "Y";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.personalDetailsRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131365037) {
            this.binding.personalEdit.setVisibility(0);
            return;
        }
        if (checkedRadioButtonId != 2131365768) {
            return;
        }
        this.binding.personalEdit.setVisibility(8);
        if (this.mobileReset.equals("NA") || this.mobileReset.isEmpty()) {
            this.binding.mobileNoTv.setText("");
        } else {
            this.binding.mobileNoTv.setText("+91-" + this.mobileReset);
        }
        if (this.optionRbReset.equals(SAMESTRING)) {
            this.binding.self.setChecked(true);
        } else {
            this.binding.relative.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.rejectionRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131365038) {
            this.binding.optionsEdit.setVisibility(0);
            this.binding.remarkTv.setText(R.string.blo_remarkPse);
            this.notSamedob = "Y";
            return;
        }
        if (checkedRadioButtonId != 2131365769) {
            return;
        }
        this.binding.remarkTv.setText(R.string.blo_remark);
        this.notSamedob = "N";
        this.binding.optionsEdit.setVisibility(8);
        String str = this.optionRbReset;
        str.hashCode();
        switch (str) {
            case "objection":
                SpannableString spannableString = new SpannableString(this.inclusionString + StringUtils.SPACE + this.subOptionReset);
                spannableString.setSpan(new StyleSpan(1), 109, this.subOptionReset.length() + 110, 33);
                this.binding.firstText.setText(spannableString);
                this.rejectionOption = this.inclusionString;
                this.rejectionOptionSubcategory = this.subOptionReset;
                break;
            case "same":
                SpannableString spannableString2 = new SpannableString(this.selfDeletionString + StringUtils.SPACE + this.subOptionReset);
                spannableString2.setSpan(new StyleSpan(1), 88, this.subOptionReset.length() + 89, 33);
                this.binding.firstText.setText(spannableString2);
                this.rejectionOption = this.selfDeletionString;
                this.rejectionOptionSubcategory = this.subOptionReset;
                break;
            case "other":
                SpannableString spannableString3 = new SpannableString(this.otherDeletionString + StringUtils.SPACE + this.subOptionReset);
                spannableString3.setSpan(new StyleSpan(1), 132, this.subOptionReset.length() + 133, 33);
                this.binding.firstText.setText(spannableString3);
                this.rejectionOption = this.otherDeletionString;
                this.rejectionOptionSubcategory = this.subOptionReset;
                break;
            default:
                this.binding.firstText.setText("");
                break;
        }
        this.binding.certificateAttached.setText(this.isCertiAttachReset);
        if (this.isCertiAttachReset.equals("No")) {
            this.binding.deathCertiAttachedTv.setVisibility(8);
            this.binding.certificateAttached.setVisibility(8);
            this.binding.deathCertificateBtn.setVisibility(8);
            this.binding.deathLayout.setVisibility(8);
            return;
        }
        if (this.isCertiAttachReset.equals("Yes")) {
            this.binding.deathCertiAttachedTv.setVisibility(0);
            this.binding.certificateAttached.setVisibility(0);
            this.binding.deathCertificateBtn.setVisibility(0);
            this.binding.deathLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.detailsOfpersonRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131362248) {
            this.binding.detailsofpersonEdit.setVisibility(0);
            return;
        }
        if (checkedRadioButtonId != 2131362252) {
            return;
        }
        this.binding.detailsofpersonEdit.setVisibility(8);
        this.binding.houseno.setText(this.houseReset);
        this.binding.street.setText(this.streetReset);
        this.binding.village.setText(this.villageReset);
        this.binding.postoffice.setText(this.postofficeReset);
        this.binding.pincode.setText(this.pincodeReset);
        this.binding.tehsil.setText(this.tehsilReset);
        try {
            FormsMethod.translitration(this.binding.houseno.getText().toString().trim(), this.binding.houseEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e) {
            Logger.e(CHECKLISTFORM7, e.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.street.getText().toString().trim(), this.binding.streetEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e2) {
            Logger.e(CHECKLISTFORM7, e2.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.village.getText().toString().trim(), this.binding.villageEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e3) {
            Logger.e(CHECKLISTFORM7, e3.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.postoffice.getText().toString().trim(), this.binding.postofficeEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e4) {
            Logger.e(CHECKLISTFORM7, e4.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.tehsil.getText().toString().trim(), this.binding.tehsilEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e5) {
            Logger.e(CHECKLISTFORM7, e5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        String str;
        this.alertDialog.show();
        if (this.docref.isEmpty() || this.docref.equals("null") || (str = this.docref) == null) {
            showdialog(this.alert, "No document Available");
            this.alertDialog.dismiss();
        } else {
            getFile1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(RadioGroup radioGroup, int i) {
        switch (this.binding.rejectionOptionsRg.getCheckedRadioButtonId()) {
            case R.id.option_rb1 /* 2131365097 */:
                this.binding.rejectionSpinnerLayout1.setVisibility(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb2 /* 2131365098 */:
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb3 /* 2131365099 */:
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.deathCertificateReg.getCheckedRadioButtonId();
        if (checkedRadioButtonId != 2131365014) {
            if (checkedRadioButtonId != 2131367013) {
                return;
            }
            this.binding.upload.setVisibility(0);
            this.binding.uploadSpecifications.setVisibility(0);
            this.binding.uploadLayout.setVisibility(0);
            return;
        }
        this.binding.upload.setVisibility(8);
        this.binding.uploadSpecifications.setVisibility(8);
        this.binding.uploadLayout.setVisibility(8);
        this.binding.preview.setVisibility(4);
        this.binding.chooseFileItems.setVisibility(8);
        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
    }

    private void getForm7byFormRefId(String refno, String stateCode, String Token) {
        Logger.d(CHECKLISTFORM7, "in getchecklistdetails..............................");
        this.commonutils.getRetrofitClient(getContext(), Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getForm7byFormRefId(refno, "blo", stateCode, "ANDROIDMOB").enqueue(new AnonymousClass17(Token, stateCode));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$Token;
        final /* synthetic */ String val$stateCode;

        AnonymousClass17(final String val$Token, final String val$stateCode) {
            this.val$Token = val$Token;
            this.val$stateCode = val$stateCode;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Checklist Form7 incoming data: " + jsonObject);
                try {
                    ApplicantDetailsForm7Fragment.this.id = "" + Math.round(jsonObject.get("form7Id").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "id: " + ApplicantDetailsForm7Fragment.this.id);
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                    ApplicantDetailsForm7Fragment.this.id = null;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.serialNumber = "" + Math.round(jsonObject.get("serialNumberApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "serialNumber: " + ApplicantDetailsForm7Fragment.this.serialNumber);
                } catch (Exception e2) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e2.getMessage());
                    ApplicantDetailsForm7Fragment.this.serialNumber = null;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.partNumberApplicant = "" + Math.round(jsonObject.get("partNumberApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "partNumberApplicant: " + ApplicantDetailsForm7Fragment.this.partNumberApplicant);
                    if (ApplicantDetailsForm7Fragment.this.partNumberApplicant.isEmpty()) {
                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                        applicantDetailsForm7Fragment.partNumberApplicant = applicantDetailsForm7Fragment.partNo;
                    }
                } catch (Exception e3) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e3.getMessage());
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment2.partNumberApplicant = applicantDetailsForm7Fragment2.partNo;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.partNumberOfPersonToBeDeleted = "" + Math.round(jsonObject.get("partNumberOfPersonToBeDeleted").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "partNumberOfPersonToBeDeleted: " + ApplicantDetailsForm7Fragment.this.partNumberOfPersonToBeDeleted);
                    if (ApplicantDetailsForm7Fragment.this.partNumberOfPersonToBeDeleted.isEmpty()) {
                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                        applicantDetailsForm7Fragment3.partNumberOfPersonToBeDeleted = applicantDetailsForm7Fragment3.partNo;
                    }
                } catch (Exception e4) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e4.getMessage());
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment4 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment4.partNumberOfPersonToBeDeleted = applicantDetailsForm7Fragment4.partNo;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.serialNumberOfPersonToBeDeleted = "" + Math.round(jsonObject.get("serailNumberOfPersonToBeDeleted").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "serialNumberOfPersonToBeDeleted: " + ApplicantDetailsForm7Fragment.this.serialNumberOfPersonToBeDeleted);
                } catch (Exception e5) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e5.getMessage());
                    ApplicantDetailsForm7Fragment.this.serialNumberOfPersonToBeDeleted = null;
                }
                try {
                    ApplicantDetailsForm7Fragment.this.sectionNo = "" + Math.round(jsonObject.get("sectionNoApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "sectionNo: " + ApplicantDetailsForm7Fragment.this.sectionNo);
                } catch (Exception e6) {
                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e6.getMessage());
                    ApplicantDetailsForm7Fragment.this.sectionNo = null;
                }
                ApplicantDetailsForm7Fragment.this.gender = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.gender.equals("null") || ApplicantDetailsForm7Fragment.this.gender.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.gender = null;
                }
                ApplicantDetailsForm7Fragment.this.age = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.age.equals("null") || ApplicantDetailsForm7Fragment.this.age.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.age = null;
                }
                ApplicantDetailsForm7Fragment.this.applicantPlace = String.valueOf(jsonObject.get("applicantPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.applicantPlace.equals("null") || ApplicantDetailsForm7Fragment.this.applicantPlace.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.applicantPlace = null;
                }
                ApplicantDetailsForm7Fragment.this.email = String.valueOf(jsonObject.get("emailApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.email.equals("null") || ApplicantDetailsForm7Fragment.this.email.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.email = null;
                }
                ApplicantDetailsForm7Fragment.this.formSubmissionPlace = String.valueOf(jsonObject.get("formSubmissionPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.formSubmissionPlace.equals("null") || ApplicantDetailsForm7Fragment.this.formSubmissionPlace.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.formSubmissionPlace = null;
                }
                ApplicantDetailsForm7Fragment.this.firstNameApplicant = String.valueOf(jsonObject.get("firstNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                ApplicantDetailsForm7Fragment.this.lastNameApplicant = String.valueOf(jsonObject.get("lastNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                if (ApplicantDetailsForm7Fragment.this.lastNameApplicant.isEmpty() || ApplicantDetailsForm7Fragment.this.lastNameApplicant.equals("null")) {
                    ApplicantDetailsForm7Fragment.this.lastNameApplicant = "";
                }
                ApplicantDetailsForm7Fragment.this.binding.applicantNameTv1.setText(ApplicantDetailsForm7Fragment.this.firstNameApplicant + StringUtils.SPACE + ApplicantDetailsForm7Fragment.this.lastNameApplicant);
                String strReplace = String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                ApplicantDetailsForm7Fragment.this.binding.epicNumberTv1.setText(String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE));
                if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment5 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment5.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment5.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment6 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment6.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment6.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment7 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment7.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment7.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                } else {
                    ApplicantDetailsForm7Fragment.this.mobileReset = "";
                }
                if (ApplicantDetailsForm7Fragment.this.mobileReset.isEmpty() || ApplicantDetailsForm7Fragment.this.mobileReset.equals("null")) {
                    ApplicantDetailsForm7Fragment.this.binding.mobileNoTv.setText("");
                    ApplicantDetailsForm7Fragment.this.mobileReset = "";
                } else {
                    if (ApplicantDetailsForm7Fragment.this.mobileReset.startsWith("+91-")) {
                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment8 = ApplicantDetailsForm7Fragment.this;
                        applicantDetailsForm7Fragment8.mobileReset = applicantDetailsForm7Fragment8.mobileReset.substring(4);
                    } else if (ApplicantDetailsForm7Fragment.this.mobileReset.startsWith("+91")) {
                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment9 = ApplicantDetailsForm7Fragment.this;
                        applicantDetailsForm7Fragment9.mobileReset = applicantDetailsForm7Fragment9.mobileReset.substring(3);
                    }
                    ApplicantDetailsForm7Fragment.this.binding.mobileNoTv.setText("+91-" + ApplicantDetailsForm7Fragment.this.mobileReset);
                }
                if (String.valueOf(jsonObject.get("deletionOfSelf")).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    ApplicantDetailsForm7Fragment.this.request = ApplicantDetailsForm7Fragment.SAMESTRING;
                    ApplicantDetailsForm7Fragment.this.optionRbReset = ApplicantDetailsForm7Fragment.SAMESTRING;
                    ApplicantDetailsForm7Fragment.this.isSelfMobile = "Y";
                    ApplicantDetailsForm7Fragment.this.binding.optionRb3.setChecked(true);
                    ApplicantDetailsForm7Fragment.this.binding.optionRb2.setEnabled(false);
                    ApplicantDetailsForm7Fragment.this.binding.optionRb1.setEnabled(false);
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment10 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment10.rejectionOption = applicantDetailsForm7Fragment10.selfDeletionString;
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment11 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment11.rejectionOptionSubcategory = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment11.reasonForDeletionString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment12 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment12.originalReasonforDeletion = applicantDetailsForm7Fragment12.rejectionOptionSubcategory;
                    ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion = String.valueOf(jsonObject.get("prvsReasonForDeletion")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion.equals("null")) {
                        ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion = null;
                    }
                    if (ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory.equals("null")) {
                        ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory = "";
                    }
                    String str = ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory;
                    str.hashCode();
                    switch (str) {
                        case "Not Indian Citizen":
                            ApplicantDetailsForm7Fragment.this.binding.rejectionSpinner3.setSelection(3);
                            break;
                        case "Permanently shifted":
                            ApplicantDetailsForm7Fragment.this.binding.rejectionSpinner3.setSelection(1);
                            break;
                        case "Already Enrolled":
                            ApplicantDetailsForm7Fragment.this.binding.rejectionSpinner3.setSelection(2);
                            break;
                        default:
                            ApplicantDetailsForm7Fragment.this.binding.rejectionSpinner3.setSelection(0);
                            break;
                    }
                    SpannableString spannableString = new SpannableString(ApplicantDetailsForm7Fragment.this.selfDeletionString + StringUtils.SPACE + ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory);
                    spannableString.setSpan(new StyleSpan(1), 88, ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory.length() + 89, 33);
                    ApplicantDetailsForm7Fragment.this.binding.firstText.setText(spannableString);
                    ApplicantDetailsForm7Fragment.this.binding.self.setChecked(true);
                } else if (String.valueOf(jsonObject.get("deletionOfOther")).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    ApplicantDetailsForm7Fragment.this.request = ApplicantDetailsForm7Fragment.OTHERSTRING;
                    ApplicantDetailsForm7Fragment.this.optionRbReset = ApplicantDetailsForm7Fragment.OTHERSTRING;
                    ApplicantDetailsForm7Fragment.this.isSelfMobile = "N";
                    ApplicantDetailsForm7Fragment.this.binding.optionRb1.setChecked(true);
                    ApplicantDetailsForm7Fragment.this.binding.optionRb2.setEnabled(false);
                    ApplicantDetailsForm7Fragment.this.binding.optionRb3.setEnabled(false);
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment13 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment13.rejectionOption = applicantDetailsForm7Fragment13.otherDeletionString;
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment14 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment14.rejectionOptionSubcategory = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment14.reasonForDeletionString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment15 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment15.originalReasonforDeletion = applicantDetailsForm7Fragment15.rejectionOptionSubcategory;
                    ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion = String.valueOf(jsonObject.get("prvsReasonForDeletion")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion.equals("null")) {
                        ApplicantDetailsForm7Fragment.this.prvsReasonForDeletion = null;
                    }
                    if (ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory.equals("null")) {
                        ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory = "";
                    }
                    String str2 = ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory;
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -211366810:
                            if (str2.equals(ApplicantDetailsForm7Fragment.ABSENTPERMANENTLYSHIFTED)) {
                            }
                            break;
                        case 65905236:
                            if (str2.equals(ApplicantDetailsForm7Fragment.DEATHSTRING)) {
                            }
                            break;
                        case 448850796:
                            if (str2.equals(ApplicantDetailsForm7Fragment.NOTINDIANCITIZEN)) {
                            }
                            break;
                        case 974701431:
                            if (str2.equals(ApplicantDetailsForm7Fragment.UNDERAGE)) {
                            }
                            break;
                        case 1936672461:
                            if (str2.equals(ApplicantDetailsForm7Fragment.ALREADYENROLLED)) {
                            }
                            break;
                    }
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Switch insn not found in header
                        	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        */
                    /*
                        Method dump skipped, instruction units count: 5084
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.AnonymousClass17.onResponse(retrofit2.Call, retrofit2.Response):void");
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$2, reason: invalid class name */
                class AnonymousClass2 implements Callback<JsonObject> {
                    AnonymousClass2() {
                    }

                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.code() == 200) {
                            Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7Fragment.this.message)));
                            ApplicantDetailsForm7Fragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            if (ApplicantDetailsForm7Fragment.this.base64element1.isEmpty() || ApplicantDetailsForm7Fragment.this.base64element1.equals("null") || ApplicantDetailsForm7Fragment.this.base64element1 == null) {
                                return;
                            }
                            byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7Fragment.this.base64element1, 0);
                            ApplicantDetailsForm7Fragment.this.byteArrayReset = Base64.decode(ApplicantDetailsForm7Fragment.this.base64element1, 0);
                            ApplicantDetailsForm7Fragment.this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                            return;
                        }
                        if (response.code() == 401) {
                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$2$$ExternalSyntheticLambda1
                                @Override // in.gov.eci.bloapp.aadharcallback
                                public final void onCallBack(int i, String str, String str2) {
                                    this.f$0.lambda$onResponse$1(i, str, str2);
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$2$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                }
                            });
                            return;
                        }
                        ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                        ApplicantDetailsForm7Fragment.this.showdialogFinal(ApplicantDetailsForm7Fragment.this.alert, "Page refreshed due to the token expiry");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                        ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }

                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                    }
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$3, reason: invalid class name */
                class AnonymousClass3 implements Callback<JsonArray> {
                    AnonymousClass3() {
                    }

                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                            for (int i = 0; i < ((JsonArray) response.body()).size(); i++) {
                                JsonObject jsonObject = ((JsonArray) response.body()).get(i).get("content");
                                if (jsonObject.get("partNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE).equals(ApplicantDetailsForm7Fragment.this.partNumberOfPersonToBeDeleted) && jsonObject.get("partSerialNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE).equals(ApplicantDetailsForm7Fragment.this.serialNumberOfPersonToBeDeleted)) {
                                    ApplicantDetailsForm7Fragment.this.photoref = jsonObject.get("photo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    ApplicantDetailsForm7Fragment.this.getFile(ApplicantDetailsForm7Fragment.this.photoref);
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "in getByEpicForForm........................photoref taken");
                                }
                            }
                            return;
                        }
                        if (response.code() == 401) {
                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$3$$ExternalSyntheticLambda1
                                @Override // in.gov.eci.bloapp.aadharcallback
                                public final void onCallBack(int i2, String str, String str2) {
                                    this.f$0.lambda$onResponse$1(i2, str, str2);
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$3$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                }
                            });
                            return;
                        }
                        ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                        ApplicantDetailsForm7Fragment.this.showdialogFinal(ApplicantDetailsForm7Fragment.this.alert, "Page refreshed due to the token expiry");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                        ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }

                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$2(int i, String str) {
                    if (i == 401) {
                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$$ExternalSyntheticLambda2
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str2, String str3) {
                                this.f$0.lambda$onResponse$1(i2, str2, str3);
                            }
                        });
                        return;
                    }
                    byte[] bArrDecode = Base64.decode(str, 0);
                    ApplicantDetailsForm7Fragment.this.uploadDoc1DocumentEncoded = str;
                    ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photo.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                    System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                    if (i == 401 || i == 400) {
                        return;
                    }
                    ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                    ApplicantDetailsForm7Fragment.this.refreshToken = str2;
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                    ApplicantDetailsForm7Fragment.this.commonutils.getuploadedfile(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.token, SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).getRtknBnd(), ApplicantDetailsForm7Fragment.this.offlineSignedPage1Url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str3) {
                            this.f$0.lambda$onResponse$0(i2, str3);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(int i, String str) {
                    byte[] bArrDecode = Base64.decode(str, 0);
                    ApplicantDetailsForm7Fragment.this.uploadDoc1DocumentEncoded = str;
                    ApplicantDetailsForm7Fragment.this.binding.uploadDoc1Photo.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$5(int i, String str) {
                    if (i == 401) {
                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$$ExternalSyntheticLambda3
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str2, String str3) {
                                this.f$0.lambda$onResponse$4(i2, str2, str3);
                            }
                        });
                        return;
                    }
                    byte[] bArrDecode = Base64.decode(str, 0);
                    ApplicantDetailsForm7Fragment.this.uploadDoc2DocumentEncoded = str;
                    ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photo.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$4(int i, String str, String str2) {
                    System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                    if (i == 401 || i == 400) {
                        return;
                    }
                    ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                    ApplicantDetailsForm7Fragment.this.refreshToken = str2;
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                    ApplicantDetailsForm7Fragment.this.commonutils.getuploadedfile(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.token, SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).getRtknBnd(), ApplicantDetailsForm7Fragment.this.offlineSignedPage2Url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$$ExternalSyntheticLambda4
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str3) {
                            this.f$0.lambda$onResponse$3(i2, str3);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$3(int i, String str) {
                    byte[] bArrDecode = Base64.decode(str, 0);
                    ApplicantDetailsForm7Fragment.this.uploadDoc2DocumentEncoded = str;
                    ApplicantDetailsForm7Fragment.this.binding.uploadDoc2Photo.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$7(int i, String str, String str2) {
                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                    System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                    if (i == 401 || i == 400) {
                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$17$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.f$0.lambda$onResponse$6(dialogInterface, i2);
                            }
                        });
                        return;
                    }
                    ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment.showdialogFinal(applicantDetailsForm7Fragment.alert, "Page refreshed due to the token expiry");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$6(DialogInterface dialogInterface, int i) {
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                    ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment.showdialogFinal(applicantDetailsForm7Fragment.alert, "Data Not Found");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void disableAllData() {
                this.binding.cvPersonalDetails.setVisibility(8);
                this.binding.sameDobRb.setChecked(true);
                this.binding.sameDobRb.setEnabled(false);
                this.binding.notSameDobRb.setEnabled(false);
                this.binding.addressSame.setEnabled(false);
                this.binding.addressSame.setChecked(true);
                this.binding.addressNotSame.setEnabled(false);
                this.binding.cvUploadDoc.setVisibility(8);
                this.binding.tvAddressLable.setVisibility(8);
                this.binding.lvAddress.setVisibility(8);
                this.binding.tvDeclaration.setVisibility(8);
                this.binding.remarkTv.setText(R.string.blo_remarkPse);
                SpannableString spannableString = new SpannableString(ALREADYENROLLED);
                spannableString.setSpan(new StyleSpan(1), 0, 16, 33);
                this.binding.firstText.setText(spannableString);
            }

            private void starMarkerAndRemover() {
                this.binding.textView15.setText(mandatorymarker(this.binding.textView15.getText().toString()));
                this.binding.textView21.setText(mandatorymarker(this.binding.textView21.getText().toString()));
                this.binding.textView22.setText(mandatorymarker(this.binding.textView22.getText().toString()));
                this.binding.villageTv.setText(mandatorymarker(this.binding.villageTv.getText().toString()));
                this.binding.postofficeTv.setText(mandatorymarker(this.binding.postofficeTv.getText().toString()));
                this.binding.textView25.setText(mandatorymarker(this.binding.textView25.getText().toString()));
                this.binding.tehsilTv.setText(mandatorymarker(this.binding.tehsilTv.getText().toString()));
                this.binding.textView13.setText(mandatoryremover(this.binding.textView13.getText().toString()));
                this.binding.textView12.setText(mandatoryremover(this.binding.textView12.getText().toString()));
                this.binding.textView9.setText(mandatoryremover(this.binding.textView9.getText().toString()));
                this.binding.textView17.setText(mandatoryremover(this.binding.textView17.getText().toString()));
                this.binding.textView18.setText(mandatoryremover(this.binding.textView18.getText().toString()));
                this.binding.textView19.setText(mandatoryremover(this.binding.textView19.getText().toString()));
                this.binding.stateTv1.setText(mandatoryremover(this.binding.stateTv1.getText().toString()));
                this.binding.districtTv1.setText(mandatoryremover(this.binding.districtTv1.getText().toString()));
            }

            public SpannableStringBuilder mandatorymarker(String simple) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (simple.endsWith("*")) {
                    simple = simple.substring(0, simple.length() - 1);
                }
                spannableStringBuilder.append((CharSequence) simple);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " *");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), length, spannableStringBuilder.length(), spanExclusiveExclusive);
                return spannableStringBuilder;
            }

            public String mandatoryremover(String simple) {
                return simple.endsWith("*") ? simple.substring(0, simple.length() - 1) : simple;
            }

            private void initializingClicks() {
                this.binding.backBtnIv.setOnClickListener(this);
                this.binding.homeBtnIv.setOnClickListener(this);
                this.binding.submitTv.setOnClickListener(this);
                this.binding.personalEdit.setOnClickListener(this);
                this.binding.optionsEdit.setOnClickListener(this);
                this.binding.detailsofpersonEdit.setOnClickListener(this);
                this.binding.resetTv.setOnClickListener(this);
                this.binding.cancelTv.setOnClickListener(this);
                this.binding.updateTv.setOnClickListener(this);
            }

            private void initClickListener() {
                this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda21
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$initClickListener$12(view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$initClickListener$12(View view) {
                this.binding.preview.setVisibility(8);
                this.binding.chooseFileItems.setVisibility(4);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.getId() == 2131362490) {
                    openFragment(new CheckListMain(), "Applicant Details");
                }
                if (v.getId() == 2131364196) {
                    Intent intent = new Intent(requireContext(), (Class<?>) MainActivity.class);
                    intent.setFlags(268468224);
                    startActivity(intent);
                }
                if (v.getId() == 2131365324) {
                    this.binding.nestedScrollView2.setVisibility(0);
                    this.binding.nestedScrollView.setVisibility(8);
                    this.binding.cardView2.setVisibility(0);
                    this.binding.cardView.setVisibility(8);
                    this.currentSelectedView = this.binding.personalDetailsFormLayout;
                    this.binding.personalDetailsFormLayout.setVisibility(0);
                    this.binding.rejectionOptionsFormLayout.setVisibility(8);
                    this.binding.personDetailsFormLayout.setVisibility(8);
                    this.binding.firstNameEd.setText(this.firstNameApplicant + StringUtils.SPACE + this.lastNameApplicant);
                    this.binding.epicEd.setText(this.binding.epicNumberTv1.getText().toString());
                    if (this.isSelfMobile.equals("Y")) {
                        this.binding.self.setChecked(true);
                    } else {
                        this.binding.relative.setChecked(true);
                    }
                    String string = this.binding.mobileNoTv.getText().toString();
                    if (string.startsWith("+91")) {
                        string = string.substring(4);
                    }
                    this.binding.mobileNumEd.setText(string);
                }
                if (v.getId() == 2131365102) {
                    this.binding.nestedScrollView2.setVisibility(0);
                    this.binding.nestedScrollView.setVisibility(8);
                    this.binding.cardView2.setVisibility(0);
                    this.binding.cardView.setVisibility(8);
                    this.currentSelectedView = this.binding.rejectionOptionsFormLayout;
                    this.binding.personalDetailsFormLayout.setVisibility(8);
                    this.binding.rejectionOptionsFormLayout.setVisibility(0);
                    this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
                    this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
                    this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
                    if (this.rejectionOption.equals(this.otherDeletionString)) {
                        this.request = OTHERSTRING;
                        this.binding.optionRb1.setChecked(true);
                        this.binding.rejectionSpinnerLayout1.setVisibility(0);
                        String str = this.rejectionOptionSubcategory;
                        str.hashCode();
                        switch (str) {
                            case "Absent/Permanently shifted":
                                this.binding.rejectionSpinner1.setSelection(3);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Death":
                                this.binding.rejectionSpinner1.setSelection(1);
                                break;
                            case "Not Indian Citizen":
                                this.binding.rejectionSpinner1.setSelection(5);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Under Age":
                                this.binding.rejectionSpinner1.setSelection(2);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Already Enrolled":
                                this.binding.rejectionSpinner1.setSelection(4);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            default:
                                this.binding.rejectionSpinner1.setSelection(0);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                        }
                    } else if (this.rejectionOption.equals(this.inclusionString)) {
                        this.request = OBJECTIONSTRING;
                        this.binding.optionRb2.setChecked(true);
                        this.binding.rejectionSpinnerLayout2.setVisibility(0);
                        String str2 = this.rejectionOptionSubcategory;
                        str2.hashCode();
                        switch (str2) {
                            case "Absent/Permanently shifted":
                                this.binding.rejectionSpinner2.setSelection(3);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Death":
                                this.binding.rejectionSpinner2.setSelection(1);
                                break;
                            case "Not Indian Citizen":
                                this.binding.rejectionSpinner2.setSelection(5);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Under Age":
                                this.binding.rejectionSpinner2.setSelection(2);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Already Enrolled":
                                this.binding.rejectionSpinner2.setSelection(4);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            default:
                                this.binding.rejectionSpinner2.setSelection(0);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                        }
                    } else {
                        this.request = SAMESTRING;
                        this.binding.optionRb3.setChecked(true);
                        this.binding.rejectionSpinnerLayout3.setVisibility(0);
                        String str3 = this.rejectionOptionSubcategory;
                        str3.hashCode();
                        switch (str3) {
                            case "Not Indian Citizen":
                                this.binding.rejectionSpinner3.setSelection(3);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Permanently shifted":
                                this.binding.rejectionSpinner3.setSelection(1);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            case "Already Enrolled":
                                this.binding.rejectionSpinner3.setSelection(2);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                            default:
                                this.binding.rejectionSpinner3.setSelection(0);
                                this.binding.deathLayout.setVisibility(8);
                                break;
                        }
                    }
                    if (this.binding.certificateAttached.getText().toString().equals("Yes")) {
                        this.binding.yesRb.setChecked(true);
                        this.binding.upload.setVisibility(0);
                        this.binding.uploadSpecifications.setVisibility(0);
                        this.binding.uploadLayout.setVisibility(0);
                    } else {
                        this.binding.noRb.setChecked(true);
                        this.binding.upload.setVisibility(8);
                        this.binding.uploadSpecifications.setVisibility(8);
                        this.binding.uploadLayout.setVisibility(8);
                    }
                    this.binding.personDetailsFormLayout.setVisibility(8);
                }
                if (v.getId() == 2131363215) {
                    this.binding.nestedScrollView2.setVisibility(0);
                    this.binding.nestedScrollView.setVisibility(8);
                    this.binding.cardView2.setVisibility(0);
                    this.binding.cardView.setVisibility(8);
                    this.currentSelectedView = this.binding.personDetailsFormLayout;
                    this.binding.personalDetailsFormLayout.setVisibility(8);
                    this.binding.rejectionOptionsFormLayout.setVisibility(8);
                    this.binding.personDetailsFormLayout.setVisibility(0);
                    this.binding.nameEd.setText(this.binding.name.getText().toString());
                    this.binding.surNameEd2.setText(this.surname);
                    if (this.binding.epic.getText().toString().equals("")) {
                        this.binding.epicEd2.setText(StringUtils.SPACE);
                    } else {
                        this.binding.epicEd2.setText(this.binding.epic.getText().toString());
                    }
                    this.binding.houseEd.setText(this.binding.houseno.getText().toString());
                    if (this.binding.houseEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.houseEd.getText().toString().trim(), this.binding.houseEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e) {
                            Logger.e(CHECKLISTFORM7, e.getMessage());
                        }
                    }
                    this.binding.streetEd.setText(this.binding.street.getText().toString());
                    if (this.binding.streetEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.streetEd.getText().toString().trim(), this.binding.streetEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e2) {
                            Logger.e(CHECKLISTFORM7, e2.getMessage());
                        }
                    }
                    this.binding.villageEd.setText(this.binding.village.getText().toString());
                    if (this.binding.villageEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.villageEd.getText().toString().trim(), this.binding.villageEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e3) {
                            Logger.e(CHECKLISTFORM7, e3.getMessage());
                        }
                    }
                    this.binding.postofficeEd.setText(this.binding.postoffice.getText().toString());
                    if (this.binding.postofficeEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e4) {
                            Logger.e(CHECKLISTFORM7, e4.getMessage());
                        }
                    }
                    this.binding.pincodeEd.setText(this.binding.pincode.getText().toString());
                    this.binding.tehsilEd.setText(this.binding.tehsil.getText().toString());
                    if (this.binding.tehsilEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.tehsilEd.getText().toString().trim(), this.binding.tehsilEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e5) {
                            Logger.e(CHECKLISTFORM7, e5.getMessage());
                        }
                    }
                    this.binding.districtEd1.setText(this.binding.district.getText().toString());
                    this.binding.stateEd1.setText(this.binding.state.getText().toString());
                }
                if (v.getId() == 2131362639) {
                    this.binding.nestedScrollView2.setVisibility(8);
                    this.binding.nestedScrollView.setVisibility(0);
                    this.binding.cardView2.setVisibility(8);
                    this.binding.cardView.setVisibility(0);
                }
                if (v.getId() == 2131365711) {
                    this.binding.mobileNumEd.setText(this.mobileReset);
                    this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
                    this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
                    this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
                    String str4 = this.optionRbReset;
                    str4.hashCode();
                    switch (str4) {
                        case "objection":
                            this.binding.optionRb2.setChecked(true);
                            this.binding.rejectionSpinnerLayout1.setVisibility(8);
                            this.binding.rejectionSpinner1.setSelection(0);
                            this.binding.rejectionSpinnerLayout2.setVisibility(0);
                            this.binding.rejectionSpinnerLayout3.setVisibility(8);
                            this.binding.rejectionSpinner3.setSelection(0);
                            String str5 = this.subOptionReset;
                            str5.hashCode();
                            switch (str5) {
                                case "Absent/Permanently shifted":
                                    this.binding.rejectionSpinner2.setSelection(3);
                                    break;
                                case "Death":
                                    this.binding.rejectionSpinner2.setSelection(1);
                                    try {
                                        this.binding.yesRb.setChecked(true);
                                        this.binding.deathLayout.setVisibility(0);
                                        this.binding.preview.setVisibility(0);
                                        this.binding.upload.setVisibility(0);
                                        this.binding.uploadSpecifications.setVisibility(0);
                                        this.binding.uploadLayout.setVisibility(0);
                                        this.binding.chooseFileItems.setVisibility(0);
                                        this.binding.selectName.setText(this.docref);
                                        this.binding.selectSize.setText("");
                                        if (this.docref.contains(".pdf")) {
                                            this.binding.preview.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blo_pfd_thumbnail));
                                        } else {
                                            byte[] bArrDecode = Base64.decode(this.base64element1, 0);
                                            this.byteArrayReset = bArrDecode;
                                            this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                                        }
                                        break;
                                    } catch (Exception e6) {
                                        Logger.e(CHECKLISTFORM7, e6.getMessage());
                                        break;
                                    }
                                    break;
                                case "Not Indian Citizen":
                                    this.binding.rejectionSpinner2.setSelection(5);
                                    break;
                                case "Under Age":
                                    this.binding.rejectionSpinner2.setSelection(2);
                                    break;
                                case "Already Enrolled":
                                    this.binding.rejectionSpinner2.setSelection(4);
                                    break;
                                default:
                                    this.binding.rejectionSpinner2.setSelection(0);
                                    break;
                            }
                            break;
                        case "same":
                            this.binding.optionRb3.setChecked(true);
                            this.binding.rejectionSpinnerLayout1.setVisibility(8);
                            this.binding.rejectionSpinner1.setSelection(0);
                            this.binding.rejectionSpinnerLayout2.setVisibility(8);
                            this.binding.rejectionSpinner2.setSelection(0);
                            this.binding.rejectionSpinnerLayout3.setVisibility(0);
                            String str6 = this.subOptionReset;
                            str6.hashCode();
                            switch (str6.hashCode()) {
                                case 448850796:
                                    if (str6.equals(NOTINDIANCITIZEN)) {
                                    }
                                    break;
                                case 1559939100:
                                    if (str6.equals(PERMANENTLYSHIFTED)) {
                                    }
                                    break;
                                case 1936672461:
                                    if (str6.equals(ALREADYENROLLED)) {
                                    }
                                    break;
                            }
                            /*  JADX ERROR: Method code generation error
                                java.lang.NullPointerException: Switch insn not found in header
                                	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                */
                            /*
                                Method dump skipped, instruction units count: 2956
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.onClick(android.view.View):void");
                        }

                        private void nextFragment() {
                            String str;
                            if (this.currentSelectedView == this.binding.personalDetailsFormLayout) {
                                if (!this.binding.mobileNumEd.getText().toString().isEmpty() && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
                                    showdialog(this.alert, "Please enter correct Mobile number");
                                    this.binding.mobileNumEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                this.binding.mobileNum91.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.mobileNumEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.mobileNoTv.setText(this.binding.mobileNumEd.getText().toString().isEmpty() ? "" : "+91-" + this.binding.mobileNumEd.getText().toString());
                                this.binding.nestedScrollView2.setVisibility(8);
                                this.binding.nestedScrollView.setVisibility(0);
                                this.binding.cardView2.setVisibility(8);
                                this.binding.cardView.setVisibility(0);
                                return;
                            }
                            if (this.currentSelectedView == this.binding.rejectionOptionsFormLayout) {
                                if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(this.selectReason)) {
                                    showdialog(this.alert, "Please choose one of the reasons for deletion of name of the person");
                                    return;
                                }
                                if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(this.selectReason)) {
                                    showdialog(this.alert, "Please choose one of the reasons for objection of name of the person");
                                    return;
                                }
                                if (this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(this.selectReason)) {
                                    showdialog(this.alert, "Please choose one of the reasons for deletion of your name");
                                    return;
                                }
                                if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(DEATHSTRING) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please select Yes or No");
                                    return;
                                }
                                if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(DEATHSTRING) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please select Yes or No");
                                    return;
                                }
                                if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(DEATHSTRING) && this.binding.yesRb.isChecked() && this.binding.chooseFileItems.getVisibility() != 0) {
                                    showdialog(this.alert, "Please select a file");
                                    return;
                                }
                                if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(DEATHSTRING) && this.binding.yesRb.isChecked() && this.binding.chooseFileItems.getVisibility() != 0) {
                                    showdialog(this.alert, "Please select a file");
                                    return;
                                }
                                if (this.binding.optionRb1.isChecked()) {
                                    this.request = OTHERSTRING;
                                    this.rejectionOption = this.otherDeletionString;
                                    this.rejectionOptionSubcategory = this.binding.rejectionSpinner1.getSelectedItem().toString();
                                    SpannableString spannableString = new SpannableString(this.otherDeletionString + StringUtils.SPACE + this.rejectionOptionSubcategory);
                                    spannableString.setSpan(new StyleSpan(1), 132, this.rejectionOptionSubcategory.length() + 133, 33);
                                    this.binding.firstText.setText(spannableString);
                                } else if (this.binding.optionRb2.isChecked()) {
                                    this.request = OBJECTIONSTRING;
                                    this.rejectionOption = this.inclusionString;
                                    this.rejectionOptionSubcategory = this.binding.rejectionSpinner2.getSelectedItem().toString();
                                    SpannableString spannableString2 = new SpannableString(this.inclusionString + StringUtils.SPACE + this.rejectionOptionSubcategory);
                                    spannableString2.setSpan(new StyleSpan(1), 109, this.rejectionOptionSubcategory.length() + 110, 33);
                                    this.binding.firstText.setText(spannableString2);
                                } else if (this.binding.optionRb3.isChecked()) {
                                    this.request = SAMESTRING;
                                    this.rejectionOption = this.selfDeletionString;
                                    this.rejectionOptionSubcategory = this.binding.rejectionSpinner3.getSelectedItem().toString();
                                    SpannableString spannableString3 = new SpannableString(this.selfDeletionString + StringUtils.SPACE + this.rejectionOptionSubcategory);
                                    spannableString3.setSpan(new StyleSpan(1), 88, this.rejectionOptionSubcategory.length() + 89, 33);
                                    this.binding.firstText.setText(spannableString3);
                                }
                                if (((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(DEATHSTRING)) || (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(DEATHSTRING))) && this.binding.yesRb.isChecked()) {
                                    this.binding.deathCertiAttachedTv.setVisibility(0);
                                    this.binding.certificateAttached.setVisibility(0);
                                    this.binding.deathCertificateBtn.setVisibility(0);
                                    str = "Yes";
                                } else {
                                    this.binding.deathCertiAttachedTv.setVisibility(8);
                                    this.binding.certificateAttached.setVisibility(8);
                                    this.binding.deathCertificateBtn.setVisibility(8);
                                    str = "No";
                                }
                                this.binding.certificateAttached.setText(str);
                                this.binding.nestedScrollView2.setVisibility(8);
                                this.binding.nestedScrollView.setVisibility(0);
                                this.binding.cardView2.setVisibility(8);
                                this.binding.cardView.setVisibility(0);
                                return;
                            }
                            if (this.currentSelectedView == this.binding.personDetailsFormLayout) {
                                if (this.binding.houseEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter House/Building/Apartment No.");
                                    this.binding.houseEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.houseEd2.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter House/Building/Apartment No. in regional");
                                    return;
                                }
                                if (this.binding.streetEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter Street/Area/Locality/Mohalla/Road");
                                    this.binding.streetEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.streetEd2.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter Street/Area/Locality/Mohalla/Road in regional");
                                    return;
                                }
                                if (this.binding.villageEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Village/Town");
                                    this.binding.villageEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.villageEd2.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Village/Town in regional");
                                    return;
                                }
                                if (this.binding.postofficeEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Post Office");
                                    this.binding.postofficeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.postofficeEd2.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Post Office in regional");
                                    return;
                                }
                                if (this.binding.pincodeEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter Pin Code");
                                    this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.pincodeEd.getText().toString().length() == 6 && !this.binding.pincodeEd.getText().toString().matches("^[1-9]{1}[0-9]{5}$")) {
                                    showdialog(this.alert, "Please enter correct pincode");
                                    this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.pincodeEd.getText().length() != 6) {
                                    showdialog(this.alert, "Please enter a valid Pin Code");
                                    this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.tehsilEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Tehsil/Taluqa/Mandal");
                                    this.binding.tehsilEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                                    return;
                                }
                                if (this.binding.tehsilEd2.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please select Tehsil/Taluqa/Mandal in regional");
                                    return;
                                }
                                this.binding.houseEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.streetEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.villageEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.postofficeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.tehsilEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
                                this.binding.houseEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                                this.binding.streetEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                                this.binding.villageEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                                this.binding.postofficeEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                                this.binding.tehsilEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                                this.binding.houseno.setText(this.binding.houseEd.getText().toString());
                                this.binding.street.setText(this.binding.streetEd.getText().toString());
                                this.binding.village.setText(this.binding.villageEd.getText().toString());
                                this.binding.postoffice.setText(this.binding.postofficeEd.getText().toString());
                                this.binding.pincode.setText(this.binding.pincodeEd.getText().toString());
                                this.binding.tehsil.setText(this.binding.tehsilEd.getText().toString());
                                this.binding.nestedScrollView2.setVisibility(8);
                                this.binding.nestedScrollView.setVisibility(0);
                                this.binding.cardView2.setVisibility(8);
                                this.binding.cardView.setVisibility(0);
                            }
                        }

                        public void getFile(String fileref) {
                            Logger.d(CHECKLISTFORM7, "in getFile..............................");
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass18(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$18, reason: invalid class name */
                        class AnonymousClass18 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass18(final String val$fileref) {
                                this.val$fileref = val$fileref;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.code() == 200) {
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7Fragment.this.message)));
                                    ApplicantDetailsForm7Fragment.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7Fragment.this.base64element, 0);
                                    ApplicantDetailsForm7Fragment.this.binding.objecteeImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                                    if (ApplicantDetailsForm7Fragment.this.base64element.isEmpty() || ApplicantDetailsForm7Fragment.this.base64element.equals("null") || ApplicantDetailsForm7Fragment.this.base64element == null) {
                                        ApplicantDetailsForm7Fragment.this.binding.objecteeImage.setImageBitmap(BitmapFactory.decodeResource(ApplicantDetailsForm7Fragment.this.getResources(), R.drawable.blo_dummy_image));
                                    }
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7Fragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7Fragment.this.requireContext();
                                    String str = ApplicantDetailsForm7Fragment.this.refreshToken;
                                    final String str2 = this.val$fileref;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$18$$ExternalSyntheticLambda1
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                                ApplicantDetailsForm7Fragment.this.binding.imageEnlargeTv.setVisibility(8);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$18$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str2;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str3);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str2);
                                ApplicantDetailsForm7Fragment.this.getFile(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7Fragment.this.binding.imageEnlargeTv.setVisibility(8);
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                            }
                        }

                        public void getFile1(String fileref) {
                            Logger.d(CHECKLISTFORM7, "in getFile..............................");
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass19(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$19, reason: invalid class name */
                        class AnonymousClass19 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass19(final String val$fileref) {
                                this.val$fileref = val$fileref;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.code() == 200) {
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7Fragment.this.message)));
                                    ApplicantDetailsForm7Fragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    if (!ApplicantDetailsForm7Fragment.this.base64element1.isEmpty() && !ApplicantDetailsForm7Fragment.this.base64element1.equals("null")) {
                                        byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7Fragment.this.base64element1, 0);
                                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                                        if (ApplicantDetailsForm7Fragment.this.docref.contains(".pdf")) {
                                            try {
                                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                                applicantDetailsForm7Fragment.showpdfDialog(bArrDecode, applicantDetailsForm7Fragment.docref);
                                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                                return;
                                            } catch (Exception e) {
                                                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ApplicantDetailsForm7Fragment.this.getResources(), R.drawable.blo_pfd_thumbnail);
                                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                                                applicantDetailsForm7Fragment2.showImageDialog(bitmapDecodeResource, applicantDetailsForm7Fragment2.docref);
                                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                                Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                                                return;
                                            }
                                        }
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment3.showImageDialog(bitmapDecodeByteArray, applicantDetailsForm7Fragment3.docref);
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        return;
                                    }
                                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment4 = ApplicantDetailsForm7Fragment.this;
                                    applicantDetailsForm7Fragment4.showdialog(applicantDetailsForm7Fragment4.alert, ApplicantDetailsForm7Fragment.this.noDocumentAvailable);
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7Fragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7Fragment.this.requireContext();
                                    String str = ApplicantDetailsForm7Fragment.this.refreshToken;
                                    final String str2 = this.val$fileref;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$19$$ExternalSyntheticLambda1
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment5 = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment5.showdialog(applicantDetailsForm7Fragment5.alert, ApplicantDetailsForm7Fragment.this.noDocumentAvailable);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$19$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str2;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str3);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str2);
                                ApplicantDetailsForm7Fragment.this.getFile1(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.showdialog(applicantDetailsForm7Fragment.alert, ApplicantDetailsForm7Fragment.this.noDocumentAvailable);
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                            }
                        }

                        /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$20] */
                        public void loadData() {
                            DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().deleteStates();
                            DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().deleteDists();
                            DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().deleteAcs();
                            InputStream inputStreamOpenRawResource = getResources().openRawResource(R.raw.states);
                            StringWriter stringWriter = new StringWriter();
                            char[] cArr = new char[1024];
                            try {
                                try {
                                    try {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, StandardCharsets.UTF_8));
                                        while (true) {
                                            try {
                                                int i = bufferedReader.read(cArr);
                                                if (i == -1) {
                                                    break;
                                                } else {
                                                    stringWriter.write(cArr, 0, i);
                                                }
                                            } catch (Throwable th) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                                throw th;
                                            }
                                        }
                                        bufferedReader.close();
                                        inputStreamOpenRawResource.close();
                                        stringWriter.flush();
                                        stringWriter.close();
                                    } catch (IOException e) {
                                        Logger.e(CHECKLISTFORM7, e.getMessage());
                                    }
                                } catch (UnsupportedEncodingException e2) {
                                    Logger.e(CHECKLISTFORM7, e2.getMessage());
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                } catch (IOException e3) {
                                    Logger.e(CHECKLISTFORM7, e3.getMessage());
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                }
                                List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.20
                                }.getType());
                                DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().insertStates((TState[]) list.toArray(new TState[list.size()]));
                            } catch (Throwable th3) {
                                try {
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                } catch (IOException e4) {
                                    Logger.e(CHECKLISTFORM7, e4.getMessage());
                                }
                                throw th3;
                            }
                        }

                        @Override // android.view.View.OnFocusChangeListener
                        public void onFocusChange(View v, boolean hasFocus) {
                            if (v.getId() == 2131364218 && hasFocus) {
                                if (this.binding.houseEd.getText().toString().isEmpty()) {
                                    this.binding.houseEd2.setText("");
                                } else {
                                    try {
                                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseEd.getText().toString().trim(), this.binding.houseEd2, this.partLang, Constants.transliterationAddress);
                                    } catch (Exception e) {
                                        Logger.e(CHECKLISTFORM7, e.getMessage());
                                    }
                                }
                            }
                            if (v.getId() == 2131366103 && hasFocus) {
                                if (this.binding.streetEd.getText().toString().isEmpty()) {
                                    this.binding.streetEd2.setText("");
                                } else {
                                    try {
                                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetEd2, this.partLang, Constants.transliterationAddress);
                                    } catch (Exception e2) {
                                        Logger.e(CHECKLISTFORM7, e2.getMessage());
                                    }
                                }
                            }
                            if (v.getId() == 2131366954 && hasFocus) {
                                if (this.binding.villageEd.getText().toString().isEmpty()) {
                                    this.binding.villageEd2.setText("");
                                } else {
                                    try {
                                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.villageEd.getText().toString().trim(), this.binding.villageEd2, this.partLang, Constants.transliterationAddress);
                                    } catch (Exception e3) {
                                        Logger.e(CHECKLISTFORM7, e3.getMessage());
                                    }
                                }
                            }
                            if (v.getId() == 2131365402 && hasFocus) {
                                if (this.binding.postofficeEd.getText().toString().isEmpty()) {
                                    this.binding.postofficeEd2.setText("");
                                } else {
                                    try {
                                        FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeEd2, this.partLang, Constants.transliterationAddress);
                                    } catch (Exception e4) {
                                        Logger.e(CHECKLISTFORM7, e4.getMessage());
                                    }
                                }
                            }
                            if (v.getId() == 2131366226 && hasFocus) {
                                if (this.binding.tehsilEd.getText().toString().isEmpty()) {
                                    this.binding.tehsilEd2.setText("");
                                    return;
                                }
                                try {
                                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.tehsilEd.getText().toString().trim(), this.binding.tehsilEd2, this.partLang, Constants.transliterationAddress);
                                } catch (Exception e5) {
                                    Logger.e(CHECKLISTFORM7, e5.getMessage());
                                }
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showImageDialog(Bitmap img, String name) {
                            final Dialog dialog = new Dialog(getContext());
                            dialog.setContentView(R.layout.blo_image_dialog_layout);
                            ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
                            TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
                            TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
                            touchImageView.setImageBitmap(img);
                            textView.setText(name);
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda14
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showpdfDialog(byte[] pdf, String name) {
                            final Dialog dialog = new Dialog(getContext());
                            dialog.setContentView(R.layout.blo_pdf_dialog_layout);
                            ImageView imageView = (ImageView) dialog.findViewById(R.id.pdf_card).findViewById(R.id.dialog_cancel_button);
                            PDFView pDFViewFindViewById = dialog.findViewById(R.id.pdf_card).findViewById(R.id.pdfView);
                            TextView textView = (TextView) dialog.findViewById(R.id.dialog_pdf_name);
                            pDFViewFindViewById.fromBytes(pdf).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
                            textView.setText(name);
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda19
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void saveimageapi(String captureFileName, String uploadtype) {
                            this.alertDialog.show();
                            Logger.d(CHECKLISTFORM7, "in image upload api..............................");
                            File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
                            MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
                            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), this.referenceNo + "_document");
                            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.asmblyNO, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.appName, MediaType.parse("appName"))).enqueue(new AnonymousClass21(uploadtype, captureFileName));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$21, reason: invalid class name */
                        class AnonymousClass21 implements Callback<JsonObject> {
                            final /* synthetic */ String val$captureFileName;
                            final /* synthetic */ String val$uploadtype;

                            AnonymousClass21(final String val$uploadtype, final String val$captureFileName) {
                                this.val$uploadtype = val$uploadtype;
                                this.val$captureFileName = val$captureFileName;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.isSuccessful()) {
                                    final JsonElement jsonElement = ((JsonObject) response.body()).get("refId");
                                    Handler handler = new Handler(Looper.getMainLooper());
                                    final String str = this.val$uploadtype;
                                    handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$21$$ExternalSyntheticLambda1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$onResponse$0(str, jsonElement);
                                        }
                                    }, 2000L);
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7Fragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7Fragment.this.requireContext();
                                    String str2 = ApplicantDetailsForm7Fragment.this.refreshToken;
                                    final String str3 = this.val$captureFileName;
                                    final String str4 = this.val$uploadtype;
                                    commomUtility.getRefreshToken(contextRequireContext, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$21$$ExternalSyntheticLambda2
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str5, String str6) {
                                            this.f$0.lambda$onResponse$2(str3, str4, i, str5, str6);
                                        }
                                    });
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(String str, JsonElement jsonElement) {
                                if (str.equals("deathCerti")) {
                                    ApplicantDetailsForm7Fragment.this.docref = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Success_Uploaded: " + ApplicantDetailsForm7Fragment.this.docref);
                                    Log.d("document ", ApplicantDetailsForm7Fragment.this.docref);
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    return;
                                }
                                if (str.equalsIgnoreCase("UploadForm6Page1")) {
                                    ApplicantDetailsForm7Fragment.this.offlineSignedPage1Url = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    if (ApplicantDetailsForm7Fragment.this.alertDialog != null) {
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        return;
                                    }
                                    return;
                                }
                                if (str.equalsIgnoreCase("UploadForm6Page2")) {
                                    ApplicantDetailsForm7Fragment.this.offlineSignedPage2Url = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    if (ApplicantDetailsForm7Fragment.this.alertDialog != null) {
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    }
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$2(String str, String str2, int i, String str3, String str4) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$21$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$1(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str3;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str4);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str3);
                                ApplicantDetailsForm7Fragment.this.saveimageapi(str, str2);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Failed_Uploaded " + t.getMessage());
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                            }
                        }

                        private void showAerlDialog() {
                            this.checkEpic = false;
                            final Dialog dialog = new Dialog(requireContext());
                            dialog.setContentView(R.layout.aerl_view_epic);
                            dialog.getWindow().setLayout(-1, -2);
                            dialog.setCancelable(false);
                            Button button = (Button) dialog.findViewById(R.id.btnsubmit);
                            final Button button2 = (Button) dialog.findViewById(R.id.btncancel);
                            final EditText editText = (EditText) dialog.findViewById(R.id.search);
                            ImageView imageView = (ImageView) dialog.findViewById(R.id.cross);
                            final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.cb_alreadyenrolled);
                            final LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.lv_verify_details);
                            final TextView textView = (TextView) dialog.findViewById(R.id.tv_elector_name);
                            final TextView textView2 = (TextView) dialog.findViewById(R.id.tv_elector_age);
                            final TextView textView3 = (TextView) dialog.findViewById(R.id.tv_elector_gender);
                            final TextView textView4 = (TextView) dialog.findViewById(R.id.tv_elector_acNo);
                            final TextView textView5 = (TextView) dialog.findViewById(R.id.tv_elector_acName);
                            final TextView textView6 = (TextView) dialog.findViewById(R.id.tv_elector_partNo);
                            final TextView textView7 = (TextView) dialog.findViewById(R.id.tv_elector_state);
                            final TextView textView8 = (TextView) dialog.findViewById(R.id.tv_elector_relation_type);
                            final TextView textView9 = (TextView) dialog.findViewById(R.id.tv_elector_relative_fullname);
                            button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda23
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    this.f$0.lambda$showAerlDialog$16(editText, textView, textView2, textView3, textView8, textView9, linearLayout, button2, checkBox, textView4, textView5, textView6, textView7, view);
                                }
                            });
                            button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.22
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    ApplicantDetailsForm7Fragment.this.checkEpic = false;
                                }
                            });
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.23
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    ApplicantDetailsForm7Fragment.this.checkEpic = false;
                                }
                            });
                            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.24
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if (isChecked) {
                                        ApplicantDetailsForm7Fragment.this.checkEpic = true;
                                        dialog.dismiss();
                                    } else {
                                        ApplicantDetailsForm7Fragment.this.checkEpic = false;
                                    }
                                }
                            });
                            dialog.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$showAerlDialog$16(final EditText editText, final TextView textView, final TextView textView2, final TextView textView3, final TextView textView4, final TextView textView5, final LinearLayout linearLayout, final Button button, final CheckBox checkBox, final TextView textView6, final TextView textView7, final TextView textView8, final TextView textView9, View view) {
                            new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda10
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$showAerlDialog$15(editText, textView, textView2, textView3, textView4, textView5, linearLayout, button, checkBox, textView6, textView7, textView8, textView9);
                                }
                            }, 200L);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$showAerlDialog$15(EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, Button button, CheckBox checkBox, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
                            if (!TextUtils.isEmpty(editText.getText().toString())) {
                                checkEpicNumber(editText.getText().toString(), textView, textView2, textView3, textView4, textView5, linearLayout, button, checkBox, textView6, textView7, textView8, textView9);
                            } else {
                                Toast.makeText(requireContext(), "Please enter EPIC number", 0).show();
                            }
                        }

                        private void checkEpicNumber(String epic, TextView tv_elector_name, TextView tv_elector_age, TextView tv_elector_gender, TextView tv_elector_relation_type, TextView tv_elector_relative_fullname, LinearLayout lv_verify_details, Button btncancel, CheckBox alreadyEnrolled, TextView tv_elector_acNo, TextView tv_elector_acName, TextView tv_elector_partNo, TextView tv_elector_state) {
                            CommomUtility commomUtility = new CommomUtility();
                            HashMap map = new HashMap();
                            map.put("epicNumber", epic);
                            map.put("isActive", "Y");
                            ((UserClient) ApiClient.getClient(requireContext()).create(UserClient.class)).getEpicForForm8(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass25(tv_elector_name, tv_elector_age, tv_elector_gender, tv_elector_relative_fullname, tv_elector_relation_type, tv_elector_acNo, tv_elector_partNo, tv_elector_state, tv_elector_acName, lv_verify_details, btncancel, alreadyEnrolled, commomUtility));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$25, reason: invalid class name */
                        class AnonymousClass25 implements Callback<JsonArray> {
                            final /* synthetic */ CheckBox val$alreadyEnrolled;
                            final /* synthetic */ Button val$btncancel;
                            final /* synthetic */ CommomUtility val$commonUtilClass;
                            final /* synthetic */ LinearLayout val$lv_verify_details;
                            final /* synthetic */ TextView val$tv_elector_acName;
                            final /* synthetic */ TextView val$tv_elector_acNo;
                            final /* synthetic */ TextView val$tv_elector_age;
                            final /* synthetic */ TextView val$tv_elector_gender;
                            final /* synthetic */ TextView val$tv_elector_name;
                            final /* synthetic */ TextView val$tv_elector_partNo;
                            final /* synthetic */ TextView val$tv_elector_relation_type;
                            final /* synthetic */ TextView val$tv_elector_relative_fullname;
                            final /* synthetic */ TextView val$tv_elector_state;

                            public void onFailure(Call<JsonArray> call, Throwable t) {
                            }

                            AnonymousClass25(final TextView val$tv_elector_name, final TextView val$tv_elector_age, final TextView val$tv_elector_gender, final TextView val$tv_elector_relative_fullname, final TextView val$tv_elector_relation_type, final TextView val$tv_elector_acNo, final TextView val$tv_elector_partNo, final TextView val$tv_elector_state, final TextView val$tv_elector_acName, final LinearLayout val$lv_verify_details, final Button val$btncancel, final CheckBox val$alreadyEnrolled, final CommomUtility val$commonUtilClass) {
                                this.val$tv_elector_name = val$tv_elector_name;
                                this.val$tv_elector_age = val$tv_elector_age;
                                this.val$tv_elector_gender = val$tv_elector_gender;
                                this.val$tv_elector_relative_fullname = val$tv_elector_relative_fullname;
                                this.val$tv_elector_relation_type = val$tv_elector_relation_type;
                                this.val$tv_elector_acNo = val$tv_elector_acNo;
                                this.val$tv_elector_partNo = val$tv_elector_partNo;
                                this.val$tv_elector_state = val$tv_elector_state;
                                this.val$tv_elector_acName = val$tv_elector_acName;
                                this.val$lv_verify_details = val$lv_verify_details;
                                this.val$btncancel = val$btncancel;
                                this.val$alreadyEnrolled = val$alreadyEnrolled;
                                this.val$commonUtilClass = val$commonUtilClass;
                            }

                            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                                if (response.code() == 200 && response.body() != null) {
                                    JsonArray jsonArray = (JsonArray) response.body();
                                    if (!jsonArray.isEmpty()) {
                                        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject().get("content");
                                        ApplicantDetailsForm7Fragment.this.pestatecd = String.valueOf(jsonObject.get("stateCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        ApplicantDetailsForm7Fragment.this.prvsPartNumber = String.valueOf(jsonObject.get("partNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        ApplicantDetailsForm7Fragment.this.prvsAcNo = String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace = String.valueOf(jsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace2 = String.valueOf(jsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        ApplicantDetailsForm7Fragment.this.prvsSLNo = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        ApplicantDetailsForm7Fragment.this.epicNumber = String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace3 = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace4 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace5 = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace6 = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace7 = String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        String strReplace8 = String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                        ApplicantDetailsForm7Fragment.this.prvsEpicId = Integer.parseInt(String.valueOf(jsonObject.get("epicId")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                        if (strReplace7.equals("null")) {
                                            strReplace7 = "";
                                        }
                                        if (strReplace6.equals("null")) {
                                            strReplace6 = "";
                                        } else {
                                            if (strReplace6.equalsIgnoreCase("M")) {
                                                strReplace6 = "Male";
                                            }
                                            if (strReplace6.equalsIgnoreCase("F")) {
                                                strReplace6 = "Female";
                                            }
                                            if (strReplace6.equalsIgnoreCase("T")) {
                                                strReplace6 = "Third gender";
                                            }
                                        }
                                        if (strReplace3.equals("null")) {
                                            strReplace3 = "";
                                        }
                                        if (strReplace4.equals("null")) {
                                            strReplace4 = "";
                                        }
                                        String str = strReplace3 + StringUtils.SPACE + strReplace4;
                                        if (strReplace5.equals("null")) {
                                            strReplace5 = "";
                                        }
                                        if (strReplace8.equals("null")) {
                                            strReplace8 = "";
                                        } else if (strReplace8.equalsIgnoreCase("GMTH")) {
                                            strReplace8 = "Grand Mother";
                                        } else if (strReplace8.equalsIgnoreCase("GFTH")) {
                                            strReplace8 = "Grand Father";
                                        } else if (strReplace8.equalsIgnoreCase("MTHR")) {
                                            strReplace8 = "Mother";
                                        } else if (strReplace8.equalsIgnoreCase("FTHR") || strReplace8.equalsIgnoreCase("F") || strReplace8.equalsIgnoreCase("FATHER")) {
                                            strReplace8 = "Father";
                                        } else if (strReplace8.equals("HSBN") || strReplace8.equals("H") || strReplace8.equalsIgnoreCase("HUSBAND")) {
                                            strReplace8 = "Husband";
                                        } else if (strReplace8.equalsIgnoreCase("OTHR")) {
                                            strReplace8 = "Other";
                                        }
                                        if (ApplicantDetailsForm7Fragment.this.prvsAcNo.equals("null")) {
                                            ApplicantDetailsForm7Fragment.this.prvsAcNo = "";
                                        }
                                        if (ApplicantDetailsForm7Fragment.this.prvsPartNumber.equals("null")) {
                                            ApplicantDetailsForm7Fragment.this.prvsPartNumber = "";
                                        }
                                        if (strReplace2.equals("null")) {
                                            strReplace2 = "";
                                        }
                                        String str2 = strReplace.equals("null") ? "" : strReplace;
                                        this.val$tv_elector_name.setText(str);
                                        this.val$tv_elector_age.setText(strReplace5);
                                        this.val$tv_elector_gender.setText(strReplace6);
                                        this.val$tv_elector_relative_fullname.setText(strReplace7);
                                        this.val$tv_elector_relation_type.setText(strReplace8);
                                        this.val$tv_elector_acNo.setText(ApplicantDetailsForm7Fragment.this.prvsAcNo);
                                        this.val$tv_elector_partNo.setText(ApplicantDetailsForm7Fragment.this.prvsPartNumber);
                                        this.val$tv_elector_state.setText(strReplace2);
                                        this.val$tv_elector_acName.setText(str2);
                                        this.val$lv_verify_details.setVisibility(0);
                                        this.val$btncancel.setVisibility(8);
                                        this.val$alreadyEnrolled.setVisibility(0);
                                        return;
                                    }
                                    Toast.makeText(ApplicantDetailsForm7Fragment.this.requireContext(), "Please check EPIC number", 0).show();
                                    this.val$lv_verify_details.setVisibility(8);
                                    this.val$alreadyEnrolled.setVisibility(8);
                                    ApplicantDetailsForm7Fragment.this.checkEpic = false;
                                    return;
                                }
                                if (response.code() == 401) {
                                    this.val$commonUtilClass.showMessageOK(ApplicantDetailsForm7Fragment.this.requireContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$25$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                                        }
                                    });
                                } else if (response.code() == 400) {
                                    ApplicantDetailsForm7Fragment.this.showAlertDialog("Alert", "Bad Request");
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.requireContext().startActivity(new Intent(ApplicantDetailsForm7Fragment.this.requireContext(), (Class<?>) LoginActivity.class));
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showAlertDialog(String alertText, String message) {
                            new android.app.AlertDialog.Builder(requireContext()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(requireContext().getResources().getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda17
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).create().show();
                        }

                        private boolean isApplicantValidated() {
                            if (!isAutoDse()) {
                                if (this.binding.personalDetailsRg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please verify Personal Details");
                                    return false;
                                }
                                if (this.request.isEmpty() || Objects.equals(this.request, null)) {
                                    showdialog(this.alert, "Please verify Option of application/objection");
                                    return false;
                                }
                                if (this.binding.rejectionRg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please verify Option of application/objection");
                                    return false;
                                }
                                if (this.binding.detailsOfpersonRg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please verify Details of the person");
                                    return false;
                                }
                                if (this.notSamedob.equals("N") && this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please verify if applicant was present");
                                    return false;
                                }
                                if (this.binding.detailsCorrectRg.getCheckedRadioButtonId() == -1) {
                                    showdialog(this.alert, "Please verify if all details matched");
                                    return false;
                                }
                                if (this.notSamedob.equals("Y") && this.binding.remarkEd.getText().toString().isEmpty()) {
                                    showdialog(this.alert, "Please enter remarks");
                                    return false;
                                }
                                if (this.binding.cvUploadDoc.getVisibility() == 0 && TextUtils.isEmpty(this.offlineSignedPage1Url)) {
                                    showdialog(this.alert, "Please upload page 1 of Form");
                                    return false;
                                }
                                if (this.binding.cvUploadDoc.getVisibility() != 0 || !TextUtils.isEmpty(this.offlineSignedPage2Url)) {
                                    return true;
                                }
                                showdialog(this.alert, "Please upload page 2 of Form");
                                return false;
                            }
                            if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                                showdialog(this.alert, "Please verify if applicant was present");
                                return false;
                            }
                            if (this.binding.detailsCorrectRg.getCheckedRadioButtonId() == -1) {
                                showdialog(this.alert, "Please verify if all details matched");
                                return false;
                            }
                            if (!this.binding.remarkEd.getText().toString().isEmpty()) {
                                return true;
                            }
                            showdialog(this.alert, "Please enter remarks");
                            return false;
                        }

                        public void openfile1() {
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("*/*");
                            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
                            this.activityResultLauncher.launch(Intent.createChooser(intent, "Choose File"));
                        }

                        @Deprecated
                        public void onActivityResult(int requestCode, int resultCode, Intent data) {
                            super.onActivityResult(requestCode, resultCode, data);
                            String string = "";
                            if (requestCode != 101 || resultCode != -1) {
                                if (requestCode == 880 && resultCode == -1) {
                                    try {
                                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                        this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                                    } catch (Exception e) {
                                        Logger.d("", e.getMessage());
                                    }
                                    try {
                                        Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                                        Cursor cursorQuery = getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                        if (cursorQuery.getCount() <= 0) {
                                            cursorQuery.close();
                                            throw new IllegalArgumentException(this.imgmsg);
                                        }
                                        cursorQuery.moveToFirst();
                                        String[] strArrSplit = saveImagePath.getPath().split("/");
                                        if (this.filesize < 1024) {
                                            saveimageapi(this.saveImageFileName, "UploadForm6Page1");
                                            double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                                            ImageView imageView = this.binding.uploadDoc1Photo;
                                            byte[] bArr = this.pdfbyteArray;
                                            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                            this.binding.uploadDoc1Certi.setVisibility(0);
                                            this.binding.uploadDoc1ChooseFile.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.uploadDoc1Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.uploadDoc1Size.setText(dRound + "KB");
                                            this.binding.uploadDoc1Photo.setVisibility(0);
                                            this.binding.uploadDoc1Photoname.setVisibility(0);
                                            this.binding.uploadDoc1Size.setVisibility(0);
                                            this.binding.uploadDoc1Delete.setVisibility(0);
                                        } else {
                                            cursorQuery.close();
                                            if (this.filesize > 2048) {
                                                this.binding.uploadDoc1Certi.setVisibility(8);
                                                showdialog("ALERT", "Image size exceeded 2MB limit.");
                                            } else {
                                                saveimageapi(this.saveImageFileName, "UploadForm6Page1");
                                                this.filesize /= 1024;
                                                double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                                                this.binding.uploadDoc1Certi.setVisibility(0);
                                                ImageView imageView2 = this.binding.uploadDoc1Photo;
                                                byte[] bArr2 = this.pdfbyteArray;
                                                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                                this.binding.uploadDoc1ChooseFile.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadDoc1Photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                                this.binding.uploadDoc1Size.setText(dRound2 + "MB");
                                                this.binding.uploadDoc1Photo.setVisibility(0);
                                                this.binding.uploadDoc1Photoname.setVisibility(0);
                                                this.binding.uploadDoc1Size.setVisibility(0);
                                                this.binding.uploadDoc1Delete.setVisibility(0);
                                            }
                                        }
                                        cursorQuery.close();
                                        return;
                                    } catch (Exception e2) {
                                        Logger.d("", e2.getMessage());
                                        return;
                                    }
                                }
                                if (requestCode == 881 && resultCode == -1) {
                                    try {
                                        Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                        bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                                        this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
                                    } catch (Exception e3) {
                                        Logger.d("", e3.getMessage());
                                    }
                                    try {
                                        Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), this.img);
                                        Cursor cursorQuery2 = getContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                                        if (cursorQuery2.getCount() <= 0) {
                                            cursorQuery2.close();
                                            throw new IllegalArgumentException(this.imgmsg);
                                        }
                                        cursorQuery2.moveToFirst();
                                        String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                                        if (this.filesize < 1024) {
                                            saveimageapi(this.saveImageFileName, "UploadForm6Page2");
                                            double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                                            ImageView imageView3 = this.binding.uploadDoc2Photo;
                                            byte[] bArr3 = this.pdfbyteArray;
                                            imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                            this.binding.uploadDoc2Certi.setVisibility(0);
                                            this.binding.uploadDoc2ChooseFile.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.uploadDoc2Photoname.setText(strArrSplit2[strArrSplit2.length - 1]);
                                            this.binding.uploadDoc2Size.setText(dRound3 + "KB");
                                            this.binding.uploadDoc2Photo.setVisibility(0);
                                            this.binding.uploadDoc2Photoname.setVisibility(0);
                                            this.binding.uploadDoc2Size.setVisibility(0);
                                            this.binding.uploadDoc2Delete.setVisibility(0);
                                        } else {
                                            cursorQuery2.close();
                                            if (this.filesize > 2048) {
                                                this.binding.uploadDoc2Certi.setVisibility(8);
                                                showdialog("ALERT", "Image size exceeded 2MB limit.");
                                            } else {
                                                saveimageapi(this.saveImageFileName, "UploadForm6Page2");
                                                this.filesize /= 1024;
                                                double dRound4 = Math.round(this.filesize * 100.0d) / 100.0d;
                                                this.binding.uploadDoc2Certi.setVisibility(0);
                                                ImageView imageView4 = this.binding.uploadDoc2Photo;
                                                byte[] bArr4 = this.pdfbyteArray;
                                                imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                                this.binding.uploadDoc2ChooseFile.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadDoc2Photoname.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                this.binding.uploadDoc2Size.setText(dRound4 + "MB");
                                                this.binding.uploadDoc2Photo.setVisibility(0);
                                                this.binding.uploadDoc2Photoname.setVisibility(0);
                                                this.binding.uploadDoc2Size.setVisibility(0);
                                                this.binding.uploadDoc2Delete.setVisibility(0);
                                            }
                                        }
                                        cursorQuery2.close();
                                        return;
                                    } catch (Exception e4) {
                                        Logger.d("", e4.getMessage());
                                        return;
                                    }
                                }
                                this.alertDialog.dismiss();
                                return;
                            }
                            try {
                                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data != null ? data.getData() : null);
                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                bitmap3.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream3);
                                this.byteArray = byteArrayOutputStream3.toByteArray();
                            } catch (IOException e5) {
                                Logger.e(CHECKLISTFORM7, e5.getMessage());
                            }
                            try {
                                Cursor cursorQuery3 = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
                                if (cursorQuery3.getCount() <= 0) {
                                    cursorQuery3.close();
                                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                                }
                                cursorQuery3.moveToFirst();
                                string = cursorQuery3.getString(cursorQuery3.getColumnIndexOrThrow("_display_name"));
                                if (this.filesize < 1024) {
                                    this.binding.preview.setVisibility(0);
                                    this.binding.chooseFileItems.setVisibility(0);
                                    this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                    this.binding.selectName.setText(string);
                                    this.binding.selectSize.setText(this.filesize + "KB");
                                    ImageView imageView5 = this.binding.preview;
                                    byte[] bArr5 = this.byteArray;
                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                    saveimageapi(this.saveImageFileName, "deathCerti");
                                    return;
                                }
                                if (this.filesize > 2048) {
                                    this.alertDialog.dismiss();
                                    showdialog(this.alert, "Image size exceeds the limit of 2MB, Please retry.");
                                    return;
                                }
                                float f = this.filesize / 1024.0f;
                                this.binding.preview.setVisibility(0);
                                this.binding.chooseFileItems.setVisibility(0);
                                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                this.binding.selectName.setText(string);
                                this.binding.selectSize.setText(String.format("%.2f", Float.valueOf(f)) + "MB");
                                ImageView imageView6 = this.binding.preview;
                                byte[] bArr6 = this.byteArray;
                                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                saveimageapi(this.saveImageFileName, "deathCerti");
                            } catch (Exception e6) {
                                Logger.d(CHECKLISTFORM7, e6.getMessage());
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Code duplicated, block: B:32:0x007e A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:34:0x0091 A[Catch: Exception -> 0x0175, TRY_LEAVE, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:37:0x00a3 A[Catch: Exception -> 0x0175, TRY_ENTER, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:38:0x00f8 A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:40:0x010c A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:41:0x0114 A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:42:0x015f A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:44:0x016a A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:37:0x00a3, B:43:0x0166, B:38:0x00f8, B:40:0x010c, B:41:0x0114, B:42:0x015f, B:44:0x016a, B:45:0x0174), top: B:53:0x0060 }] */
                        public /* synthetic */ void lambda$new$18(ActivityResult activityResult) throws Throwable {
                            ByteArrayOutputStream byteArrayOutputStream;
                            Cursor cursorQuery;
                            String string;
                            double dRound;
                            Throwable th;
                            if (activityResult.getResultCode() != -1) {
                                return;
                            }
                            Uri data = activityResult.getData().getData();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(data);
                                try {
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
                                        } catch (Throwable th4) {
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            th = th4;
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        Logger.d(CHECKLISTFORM7, e.getMessage());
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        this.byteArray = byteArray;
                                        cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf"), null, null, null, null);
                                        if (cursorQuery.getCount() > 0) {
                                            cursorQuery.close();
                                            throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                                        }
                                        cursorQuery.moveToFirst();
                                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                                        if (string.contains(".pdf")) {
                                            showdialog("", "Please Select the correct format of file");
                                        } else if (this.filesize < 1024) {
                                            double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                                            this.binding.preview.setVisibility(0);
                                            this.binding.chooseFileItems.setVisibility(0);
                                            this.binding.selectName.setText(string);
                                            this.binding.selectSize.setText(dRound2 + "KB");
                                            this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            saveimageapi(this.saveImageFileName, "deathCerti");
                                        } else {
                                            dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                            if (dRound > 3.0d) {
                                                showdialog(this.alert, "Image size exceeded 3MB limit.");
                                            } else {
                                                this.binding.preview.setVisibility(0);
                                                this.binding.chooseFileItems.setVisibility(0);
                                                this.binding.selectName.setText(string);
                                                this.binding.selectSize.setText(dRound + "MB");
                                                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                                this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                                saveimageapi(this.saveImageFileName, "deathCerti");
                                            }
                                        }
                                        cursorQuery.close();
                                        return;
                                    }
                                    cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf"), null, null, null, null);
                                    if (cursorQuery.getCount() > 0) {
                                        cursorQuery.close();
                                        throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                                    }
                                    cursorQuery.moveToFirst();
                                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                                    if (string.contains(".pdf")) {
                                        showdialog("", "Please Select the correct format of file");
                                    } else if (this.filesize < 1024) {
                                        double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                                        this.binding.preview.setVisibility(0);
                                        this.binding.chooseFileItems.setVisibility(0);
                                        this.binding.selectName.setText(string);
                                        this.binding.selectSize.setText(dRound3 + "KB");
                                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                        this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                        saveimageapi(this.saveImageFileName, "deathCerti");
                                    } else {
                                        dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                        if (dRound > 3.0d) {
                                            showdialog(this.alert, "Image size exceeded 3MB limit.");
                                        } else {
                                            this.binding.preview.setVisibility(0);
                                            this.binding.chooseFileItems.setVisibility(0);
                                            this.binding.selectName.setText(string);
                                            this.binding.selectSize.setText(dRound + "MB");
                                            this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                            saveimageapi(this.saveImageFileName, "deathCerti");
                                        }
                                    }
                                    cursorQuery.close();
                                    return;
                                } catch (Exception e2) {
                                    Log.d("CONTENT", e2.getMessage());
                                    return;
                                }
                            } catch (IOException e3) {
                                e = e3;
                            }
                            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                            this.byteArray = byteArray2;
                        }

                        private void selectImage() {
                            final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Choose PDF from Gallery", "Cancel"};
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Add Photo!");
                            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda8
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$selectImage$19(charSequenceArr, dialogInterface, i);
                                }
                            });
                            builder.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$selectImage$19(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
                            if (charSequenceArr[i].equals("Take Photo")) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
                            } else if (charSequenceArr[i].equals("Choose from Gallery")) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
                            } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
                                openfile1();
                            } else if (charSequenceArr[i].equals("Cancel")) {
                                dialogInterface.dismiss();
                            }
                        }

                        private void openFragment(Fragment fragment, String selectedFragment) {
                            FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransactionBeginTransaction.replace(R.id.main, fragment, selectedFragment);
                            fragmentTransactionBeginTransaction.setTransition(4099);
                            fragmentTransactionBeginTransaction.commit();
                        }

                        /* JADX WARN: Code duplicated, block: B:102:0x026d  */
                        /* JADX WARN: Code duplicated, block: B:105:0x031b  */
                        /* JADX WARN: Code duplicated, block: B:126:0x03c6  */
                        /* JADX WARN: Code duplicated, block: B:130:0x03d2  */
                        /* JADX WARN: Code duplicated, block: B:133:0x0403  */
                        /* JADX WARN: Code duplicated, block: B:137:0x0414  */
                        /* JADX WARN: Code duplicated, block: B:140:0x045a  */
                        /* JADX WARN: Code duplicated, block: B:144:0x046b  */
                        /* JADX WARN: Code duplicated, block: B:147:0x047a  */
                        /* JADX WARN: Code duplicated, block: B:151:0x048b  */
                        /* JADX WARN: Code duplicated, block: B:154:0x04a3  */
                        /* JADX WARN: Code duplicated, block: B:159:0x04ba  */
                        /* JADX WARN: Code duplicated, block: B:164:0x04eb  */
                        /* JADX WARN: Code duplicated, block: B:165:0x04fd  */
                        /* JADX WARN: Code duplicated, block: B:167:0x0511  */
                        /* JADX WARN: Code duplicated, block: B:168:0x0523  */
                        /* JADX WARN: Code duplicated, block: B:171:0x0533  */
                        /* JADX WARN: Code duplicated, block: B:172:0x0539  */
                        /* JADX WARN: Code duplicated, block: B:175:0x0548  */
                        /* JADX WARN: Code duplicated, block: B:178:0x05dc  */
                        /* JADX WARN: Code duplicated, block: B:180:0x05e2  */
                        /* JADX WARN: Code duplicated, block: B:183:0x0602  */
                        /* JADX WARN: Code duplicated, block: B:185:0x0608  */
                        /* JADX WARN: Code duplicated, block: B:188:0x0628  */
                        /* JADX WARN: Code duplicated, block: B:190:0x062e  */
                        /* JADX WARN: Code duplicated, block: B:193:0x064e  */
                        /* JADX WARN: Code duplicated, block: B:195:0x0654  */
                        /* JADX WARN: Code duplicated, block: B:198:0x0674  */
                        /* JADX WARN: Code duplicated, block: B:200:0x067a  */
                        /* JADX WARN: Code duplicated, block: B:203:0x069a  */
                        /* JADX WARN: Code duplicated, block: B:205:0x06a0  */
                        /* JADX WARN: Code duplicated, block: B:208:0x06c5  */
                        /* JADX WARN: Code duplicated, block: B:210:0x06cb  */
                        /* JADX WARN: Code duplicated, block: B:213:0x06eb  */
                        /* JADX WARN: Code duplicated, block: B:215:0x06f1  */
                        /* JADX WARN: Code duplicated, block: B:218:0x0711  */
                        /* JADX WARN: Code duplicated, block: B:220:0x0717  */
                        /* JADX WARN: Code duplicated, block: B:223:0x0737  */
                        /* JADX WARN: Code duplicated, block: B:225:0x073d  */
                        /* JADX WARN: Code duplicated, block: B:228:0x075d  */
                        /* JADX WARN: Code duplicated, block: B:232:0x0766  */
                        /* JADX WARN: Code duplicated, block: B:35:0x00a5 A[Catch: Exception -> 0x00f9, TryCatch #2 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:239:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:37:0x00bb A[Catch: Exception -> 0x00f9, TryCatch #2 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:239:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:39:0x00c5 A[Catch: Exception -> 0x00f9, TryCatch #2 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:239:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:40:0x00da A[Catch: Exception -> 0x00f9, TryCatch #2 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:239:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:42:0x00e4 A[Catch: Exception -> 0x00f9, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:239:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:48:0x010b  */
                        /* JADX WARN: Code duplicated, block: B:51:0x0119 A[ADDED_TO_REGION, Catch: Exception -> 0x0151, REMOVE, TryCatch #7 {Exception -> 0x0151, blocks: (B:49:0x010f, B:51:0x0119, B:52:0x0124, B:54:0x012e, B:55:0x0139, B:57:0x0143), top: B:248:0x010f }] */
                        /* JADX WARN: Code duplicated, block: B:52:0x0124 A[Catch: Exception -> 0x0151, TryCatch #7 {Exception -> 0x0151, blocks: (B:49:0x010f, B:51:0x0119, B:52:0x0124, B:54:0x012e, B:55:0x0139, B:57:0x0143), top: B:248:0x010f }] */
                        /* JADX WARN: Code duplicated, block: B:63:0x0159  */
                        /* JADX WARN: Code duplicated, block: B:66:0x0162  */
                        /* JADX WARN: Code duplicated, block: B:69:0x0176 A[ADDED_TO_REGION] */
                        /* JADX WARN: Code duplicated, block: B:72:0x0182  */
                        /* JADX WARN: Code duplicated, block: B:73:0x0184  */
                        /* JADX WARN: Code duplicated, block: B:76:0x0191  */
                        /* JADX WARN: Code duplicated, block: B:77:0x01a2  */
                        /* JADX WARN: Code duplicated, block: B:79:0x01ac  */
                        /* JADX WARN: Code duplicated, block: B:83:0x01bd  */
                        /* JADX WARN: Code duplicated, block: B:85:0x01c7  */
                        /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
                        /* JADX WARN: Code duplicated, block: B:88:0x01df  */
                        /* JADX WARN: Code duplicated, block: B:89:0x01ee  */
                        /* JADX WARN: Code duplicated, block: B:91:0x01fb  */
                        /* JADX WARN: Code duplicated, block: B:92:0x0208  */
                        /* JADX WARN: Code duplicated, block: B:95:0x0214  */
                        /* JADX WARN: Code duplicated, block: B:96:0x0216  */
                        /* JADX WARN: Code duplicated, block: B:99:0x0248  */
                        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
                        /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
                        public void submitForm7(String Token) {
                            String str;
                            String str2;
                            String str3;
                            String str4;
                            String str5;
                            String str6;
                            String str7;
                            String str8;
                            String str9;
                            String str10;
                            Object obj;
                            boolean zIsChecked;
                            Object obj2;
                            Object obj3;
                            Object obj4;
                            Object obj5;
                            Object obj6;
                            Object obj7;
                            Object obj8;
                            HashMap map;
                            String str11;
                            Object obj9;
                            HashMap map2;
                            SimpleDateFormat simpleDateFormat;
                            SimpleDateFormat simpleDateFormat2;
                            String str12;
                            String strSubstring;
                            String strReplace;
                            String strReplace2;
                            String strReplace3;
                            String strReplace4;
                            String strReplace5;
                            String strReplace6;
                            String strReplace7;
                            String strReplace8;
                            String strReplace9;
                            String strReplace10;
                            String strReplace11;
                            String str13;
                            String str14;
                            String str15;
                            String string;
                            String str16;
                            String str17;
                            String str18;
                            this.alertDialog.show();
                            Logger.d(CHECKLISTFORM7, "in Checklist submitForm7..............................");
                            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd/MM/yy");
                            SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
                            String str19 = "";
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    if (this.request.equals(SAMESTRING)) {
                                                        str = "SELF";
                                                        try {
                                                            string = this.binding.epic.getText().toString();
                                                            str16 = "Y";
                                                            str17 = "N";
                                                        } catch (Exception e) {
                                                            e = e;
                                                            str2 = "Y";
                                                            str3 = "N";
                                                            str4 = str3;
                                                            Logger.e(CHECKLISTFORM7, e.getMessage());
                                                            str5 = str4;
                                                            str6 = str3;
                                                            str7 = str2;
                                                            str8 = str;
                                                            str9 = "";
                                                        }
                                                    } else {
                                                        if (!this.request.equals(OTHERSTRING)) {
                                                            if (!this.request.equals(OBJECTIONSTRING)) {
                                                                string = "";
                                                                str = string;
                                                                str16 = str;
                                                                str17 = str16;
                                                            } else {
                                                                str = "INCLUSION";
                                                                string = "NA";
                                                                str18 = "Y";
                                                                str16 = "N";
                                                                str17 = str16;
                                                            }
                                                        } else {
                                                            str = "OTHER";
                                                            try {
                                                                string = this.binding.epic.getText().toString();
                                                                str17 = "Y";
                                                                str16 = "N";
                                                                str18 = str16;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                str3 = "Y";
                                                                str2 = "N";
                                                                str4 = str2;
                                                                Logger.e(CHECKLISTFORM7, e.getMessage());
                                                                str5 = str4;
                                                                str6 = str3;
                                                                str7 = str2;
                                                                str8 = str;
                                                                str9 = "";
                                                            }
                                                        }
                                                        str5 = str18;
                                                        str6 = str17;
                                                        str7 = str16;
                                                        str8 = str;
                                                        str9 = string;
                                                        if (this.binding.optionRb1.isChecked()) {
                                                            str15 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                                        } else if (this.binding.optionRb2.isChecked()) {
                                                            str15 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                                        } else {
                                                            if (this.binding.optionRb3.isChecked()) {
                                                                str15 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                                            }
                                                            if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                                str10 = null;
                                                            } else {
                                                                this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                                try {
                                                                    str14 = (!this.binding.optionRb1.isChecked() || this.binding.optionRb2.isChecked() || this.binding.optionRb3.isChecked()) ? this.reasonmap.get(this.prvsReasonForDeletion) : null;
                                                                    str10 = str14;
                                                                } catch (Exception e3) {
                                                                    Logger.e(CHECKLISTFORM7, e3.getMessage());
                                                                    str10 = null;
                                                                }
                                                            }
                                                            if (str19.equalsIgnoreCase("aerl") && !this.checkEpic.booleanValue()) {
                                                                showAerlDialog();
                                                                this.alertDialog.dismiss();
                                                                return;
                                                            }
                                                            if (this.binding.addressSame.isChecked()) {
                                                                obj = "Y";
                                                            } else {
                                                                obj = "N";
                                                            }
                                                            String str20 = str10;
                                                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "N";
                                                                obj4 = obj3;
                                                                str9 = str9;
                                                                str7 = str7;
                                                                str6 = str6;
                                                                str5 = str5;
                                                                obj7 = "Y";
                                                                obj6 = obj4;
                                                                obj5 = obj6;
                                                            } else {
                                                                if (this.binding.absentRb.isChecked()) {
                                                                    obj2 = OBJECTIONSTRING;
                                                                    obj3 = "Y";
                                                                    obj4 = "N";
                                                                } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                    obj2 = OBJECTIONSTRING;
                                                                    obj4 = "Y";
                                                                    obj3 = "N";
                                                                    obj6 = obj3;
                                                                    obj5 = obj6;
                                                                    obj7 = obj5;
                                                                } else if (this.binding.deadRb.isChecked()) {
                                                                    obj2 = OBJECTIONSTRING;
                                                                    obj3 = "N";
                                                                    obj4 = obj3;
                                                                    str9 = str9;
                                                                    str7 = str7;
                                                                    str6 = str6;
                                                                    str5 = str5;
                                                                    obj6 = "Y";
                                                                    obj5 = obj4;
                                                                    obj7 = obj5;
                                                                } else {
                                                                    zIsChecked = this.binding.underageRb.isChecked();
                                                                    obj2 = OBJECTIONSTRING;
                                                                    obj3 = "N";
                                                                    if (zIsChecked) {
                                                                        obj4 = obj3;
                                                                        str9 = str9;
                                                                        str7 = str7;
                                                                        str6 = str6;
                                                                        str5 = str5;
                                                                        obj5 = "Y";
                                                                        obj6 = obj4;
                                                                        obj7 = obj6;
                                                                    } else {
                                                                        obj4 = obj3;
                                                                    }
                                                                }
                                                                obj6 = obj4;
                                                                obj5 = obj6;
                                                                obj7 = obj5;
                                                            }
                                                            if (this.binding.detailsCorrect.isChecked()) {
                                                                obj8 = "Y";
                                                            } else {
                                                                obj8 = "N";
                                                            }
                                                            String str21 = str8;
                                                            map = new HashMap();
                                                            str11 = str19;
                                                            Object obj10 = obj;
                                                            Object obj11 = obj8;
                                                            obj9 = obj7;
                                                            if (!this.notSamedob.equals("Y") && this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                                                                map.put("fieldVerificationAbsent", null);
                                                                map.put("fieldVerificationDead", null);
                                                                map.put("fieldVerificationNoSuchPerson", null);
                                                                map.put("fieldVerificationPersonPresent", null);
                                                                map.put("fieldVerificationShifted", null);
                                                                map.put("fieldVerificationUnderAge", null);
                                                                map.put("fieldVerificationAlreadyEnrolled", null);
                                                                map.put("fieldVerificationNotIndianCitizen", null);
                                                            } else {
                                                                map.put("fieldVerificationAbsent", obj3);
                                                                map.put("fieldVerificationDead", obj6);
                                                                map.put("fieldVerificationNoSuchPerson", "N");
                                                                map.put("fieldVerificationPersonPresent", "N");
                                                                map.put("fieldVerificationShifted", "N");
                                                                map.put("fieldVerificationUnderAge", obj5);
                                                                map.put("fieldVerificationAlreadyEnrolled", obj4);
                                                                map.put("fieldVerificationNotIndianCitizen", obj9);
                                                            }
                                                            map.put("fieldVerificationVerifiedAndCorrect", obj11);
                                                            map.put("fieldVerificationDataEntryErrors", "N");
                                                            map.put("fieldVerificationAddress", obj10);
                                                            map.put("fieldVerificationDobOrAge", "N");
                                                            map.put("fieldVerificationPhoto", "N");
                                                            map.put("fieldVerificationAlreadyAppliedCount", 0);
                                                            map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                            map.put("correctionOfAddress", "N");
                                                            map.put("correctionOfDobAge", "N");
                                                            map.put("correctionOfGender", "N");
                                                            map.put("correctionOfMobile", "N");
                                                            map.put("correctionOfName", "N");
                                                            map.put("correctionOfPhotograpgh", "N");
                                                            map.put("correctionOfRelation", "N");
                                                            map.put("correctionOfRelative", "N");
                                                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                            map.put("fieldVerificationChecklist", null);
                                                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                            map.put("latitude", this.lat);
                                                            map.put("longitude", this.longi);
                                                            if (str11.equalsIgnoreCase("aerl")) {
                                                                map.put("aerlState", this.pestatecd);
                                                                map.put("aerlAcNo", this.prvsAcNo);
                                                                map.put("aerlPartNo", this.prvsPartNumber);
                                                                map.put("aerlEpic", this.epicNumber);
                                                            }
                                                            Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                                            map2 = new HashMap();
                                                            map2.put("applicantPlace", this.applicantPlace);
                                                            map2.put("asemblyNo", this.asmblyNO);
                                                            map2.put("createdBy", "operator");
                                                            simpleDateFormat2 = simpleDateFormat3;
                                                            simpleDateFormat = simpleDateFormat4;
                                                            map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                            map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                            if (!this.docref.isEmpty() || this.docref.equals("null")) {
                                                                str12 = null;
                                                            } else {
                                                                str12 = this.docref;
                                                            }
                                                            map2.put("deathCertificateDln", str12);
                                                            map2.put("deletionOfEpicNumberFor", str21);
                                                            map2.put("deletionOfOther", str6);
                                                            map2.put("deletionOfSelf", str7);
                                                            map2.put("districtCode", this.districtCode);
                                                            map2.put("emailApplicant", this.email);
                                                            if (!this.districtCdOfPersonToBeDeleted.isEmpty() || this.districtCdOfPersonToBeDeleted.equals("null")) {
                                                                map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                            } else {
                                                                map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCdOfPersonToBeDeleted);
                                                            }
                                                            map2.put("isSelfMobile", this.isSelfMobile);
                                                            map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                            map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                            map2.put("firstNameApplicant", this.firstNameApplicant);
                                                            map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                            if (!this.formSubmissionChannel.equals("null") || this.formSubmissionChannel.isEmpty()) {
                                                                map2.put(this.formSubmissionChannelString, "GARUDA");
                                                            } else {
                                                                map2.put(this.formSubmissionChannelString, this.formSubmissionChannel);
                                                            }
                                                            if (!this.formSubmissionMode.equals("null") || this.formSubmissionMode.isEmpty()) {
                                                                map2.put(this.formSubmissionModeString, "ONLINE");
                                                            } else {
                                                                map2.put(this.formSubmissionModeString, this.formSubmissionMode);
                                                            }
                                                            map2.put("formSubmissionPlace", this.formSubmissionPlace);
                                                            if (!this.surname.equals(StringUtils.SPACE) && !this.surname.isEmpty()) {
                                                                map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                            }
                                                            if (!this.lastNameApplicant.equals(StringUtils.SPACE) && !this.lastNameApplicant.isEmpty()) {
                                                                map2.put("lastnameApplicant", this.lastNameApplicant);
                                                            }
                                                            map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                                                            map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                                                            if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                            } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                            } else {
                                                                strSubstring = null;
                                                            }
                                                            map2.put(this.mobileNumberApplicantString, strSubstring);
                                                            if (this.isSelfMobile.equals("Y")) {
                                                                map2.put(this.mobileNumberSelfString, strSubstring);
                                                            } else {
                                                                map2.put(this.mobileNumberOfRelativeString, strSubstring);
                                                            }
                                                            if (this.request.equals(obj2)) {
                                                                map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                                map2.put("objectToInclFormType", this.objectToInclFormType);
                                                            }
                                                            map2.put("age", this.age);
                                                            map2.put("gender", this.gender);
                                                            map2.put("objectionOnInclusionOrDeletion", str5);
                                                            map2.put("partNumberApplicant", this.partNumberApplicant);
                                                            map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                            map2.put("serialNumberApplicant", this.serialNumber);
                                                            map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                            map2.put("stateCode", this.stateCode);
                                                            map2.put("sectionNoApplicant", this.sectionNo);
                                                            map2.put("sectionNo", this.sectionNo);
                                                            map2.put("isDraft", "N");
                                                            map2.put(this.reasonForDeletionString, str11);
                                                            map2.put("prvsReasonForDeletion", str20);
                                                            map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace.equals("NA") || strReplace.isEmpty()) {
                                                                strReplace = null;
                                                            }
                                                            map2.put(this.townVillageString, strReplace);
                                                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace2.equals("NA") || strReplace2.isEmpty()) {
                                                                strReplace2 = null;
                                                            }
                                                            map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace3.equals("NA") || strReplace3.isEmpty()) {
                                                                strReplace3 = null;
                                                            }
                                                            map2.put(this.postOfficeString, strReplace3);
                                                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace4.equals("NA") || strReplace4.isEmpty()) {
                                                                strReplace4 = null;
                                                            }
                                                            map2.put(this.localityStreetString, strReplace4);
                                                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace5.equals("NA") || strReplace5.isEmpty()) {
                                                                strReplace5 = null;
                                                            }
                                                            map2.put(this.houseNumberString, strReplace5);
                                                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace6.equals("NA") || strReplace6.isEmpty()) {
                                                                strReplace6 = null;
                                                            }
                                                            map2.put(this.pinCodeString, strReplace6);
                                                            map2.put("pinCodeV1", strReplace6);
                                                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace7.equals("null") || strReplace7.isEmpty()) {
                                                                strReplace7 = null;
                                                            }
                                                            map2.put("houseNumberV1", strReplace7);
                                                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace8.equals("null") || strReplace8.isEmpty()) {
                                                                strReplace8 = "NA";
                                                            }
                                                            map2.put("localityStreetV1", strReplace8);
                                                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace9.equals("null") || strReplace9.isEmpty()) {
                                                                strReplace9 = null;
                                                            }
                                                            map2.put("postOfficeV1", strReplace9);
                                                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (strReplace10.equals("null") || strReplace10.isEmpty()) {
                                                                strReplace10 = "NA";
                                                            }
                                                            map2.put("tehsilTalukaMandalV1", strReplace10);
                                                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                            if (!strReplace11.equals("null") || strReplace11.isEmpty()) {
                                                                str13 = null;
                                                            } else {
                                                                str13 = strReplace11;
                                                            }
                                                            map2.put("townVillageV1", str13);
                                                            map2.put("form7Id", this.id);
                                                            map2.put("isReinitiate", "Y");
                                                            Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                                                        }
                                                        str19 = str15;
                                                        if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                            this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                            if (!this.binding.optionRb1.isChecked()) {
                                                                str14 = this.reasonmap.get(this.prvsReasonForDeletion);
                                                            }
                                                            str10 = str14;
                                                        } else {
                                                            str10 = null;
                                                        }
                                                        if (str19.equalsIgnoreCase("aerl")) {
                                                            showAerlDialog();
                                                            this.alertDialog.dismiss();
                                                            return;
                                                        }
                                                        if (this.binding.addressSame.isChecked()) {
                                                            obj = "Y";
                                                        } else {
                                                            obj = "N";
                                                        }
                                                        String str22 = str10;
                                                        if (this.binding.notIndianCitizenRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            obj3 = "N";
                                                            obj4 = obj3;
                                                            str9 = str9;
                                                            str7 = str7;
                                                            str6 = str6;
                                                            str5 = str5;
                                                            obj7 = "Y";
                                                            obj6 = obj4;
                                                            obj5 = obj6;
                                                        } else {
                                                            if (this.binding.absentRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                            } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj4 = "Y";
                                                                obj3 = "N";
                                                                obj6 = obj3;
                                                                obj5 = obj6;
                                                                obj7 = obj5;
                                                            } else if (this.binding.deadRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "N";
                                                                obj4 = obj3;
                                                                str9 = str9;
                                                                str7 = str7;
                                                                str6 = str6;
                                                                str5 = str5;
                                                                obj6 = "Y";
                                                                obj5 = obj4;
                                                                obj7 = obj5;
                                                            } else {
                                                                zIsChecked = this.binding.underageRb.isChecked();
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "N";
                                                                if (zIsChecked) {
                                                                    obj4 = obj3;
                                                                    str9 = str9;
                                                                    str7 = str7;
                                                                    str6 = str6;
                                                                    str5 = str5;
                                                                    obj5 = "Y";
                                                                    obj6 = obj4;
                                                                    obj7 = obj6;
                                                                } else {
                                                                    obj4 = obj3;
                                                                }
                                                            }
                                                            obj6 = obj4;
                                                            obj5 = obj6;
                                                            obj7 = obj5;
                                                        }
                                                        if (this.binding.detailsCorrect.isChecked()) {
                                                            obj8 = "Y";
                                                        } else {
                                                            obj8 = "N";
                                                        }
                                                        String str23 = str8;
                                                        map = new HashMap();
                                                        str11 = str19;
                                                        Object obj12 = obj;
                                                        Object obj13 = obj8;
                                                        obj9 = obj7;
                                                        if (!this.notSamedob.equals("Y")) {
                                                            map.put("fieldVerificationAbsent", obj3);
                                                            map.put("fieldVerificationDead", obj6);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj5);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                                        } else {
                                                            map.put("fieldVerificationAbsent", obj3);
                                                            map.put("fieldVerificationDead", obj6);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj5);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                                        }
                                                        map.put("fieldVerificationVerifiedAndCorrect", obj13);
                                                        map.put("fieldVerificationDataEntryErrors", "N");
                                                        map.put("fieldVerificationAddress", obj12);
                                                        map.put("fieldVerificationDobOrAge", "N");
                                                        map.put("fieldVerificationPhoto", "N");
                                                        map.put("fieldVerificationAlreadyAppliedCount", 0);
                                                        map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                        map.put("correctionOfAddress", "N");
                                                        map.put("correctionOfDobAge", "N");
                                                        map.put("correctionOfGender", "N");
                                                        map.put("correctionOfMobile", "N");
                                                        map.put("correctionOfName", "N");
                                                        map.put("correctionOfPhotograpgh", "N");
                                                        map.put("correctionOfRelation", "N");
                                                        map.put("correctionOfRelative", "N");
                                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                        map.put("fieldVerificationChecklist", null);
                                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                        map.put("latitude", this.lat);
                                                        map.put("longitude", this.longi);
                                                        if (str11.equalsIgnoreCase("aerl")) {
                                                            map.put("aerlState", this.pestatecd);
                                                            map.put("aerlAcNo", this.prvsAcNo);
                                                            map.put("aerlPartNo", this.prvsPartNumber);
                                                            map.put("aerlEpic", this.epicNumber);
                                                        }
                                                        Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                                        map2 = new HashMap();
                                                        map2.put("applicantPlace", this.applicantPlace);
                                                        map2.put("asemblyNo", this.asmblyNO);
                                                        map2.put("createdBy", "operator");
                                                        simpleDateFormat2 = simpleDateFormat3;
                                                        simpleDateFormat = simpleDateFormat4;
                                                        map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                        map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                        if (this.docref.isEmpty()) {
                                                            str12 = null;
                                                        } else {
                                                            str12 = null;
                                                        }
                                                        map2.put("deathCertificateDln", str12);
                                                        map2.put("deletionOfEpicNumberFor", str23);
                                                        map2.put("deletionOfOther", str6);
                                                        map2.put("deletionOfSelf", str7);
                                                        map2.put("districtCode", this.districtCode);
                                                        map2.put("emailApplicant", this.email);
                                                        if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        } else {
                                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        }
                                                        map2.put("isSelfMobile", this.isSelfMobile);
                                                        map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                        map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                        map2.put("firstNameApplicant", this.firstNameApplicant);
                                                        map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                        if (!this.formSubmissionChannel.equals("null")) {
                                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                                        } else {
                                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                                        }
                                                        if (!this.formSubmissionMode.equals("null")) {
                                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                                        } else {
                                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                                        }
                                                        map2.put("formSubmissionPlace", this.formSubmissionPlace);
                                                        if (!this.surname.equals(StringUtils.SPACE)) {
                                                            map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                        }
                                                        if (!this.lastNameApplicant.equals(StringUtils.SPACE)) {
                                                            map2.put("lastnameApplicant", this.lastNameApplicant);
                                                        }
                                                        map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                                                        map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                                                        if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                        } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                        } else {
                                                            strSubstring = null;
                                                        }
                                                        map2.put(this.mobileNumberApplicantString, strSubstring);
                                                        if (this.isSelfMobile.equals("Y")) {
                                                            map2.put(this.mobileNumberSelfString, strSubstring);
                                                        } else {
                                                            map2.put(this.mobileNumberOfRelativeString, strSubstring);
                                                        }
                                                        if (this.request.equals(obj2)) {
                                                            map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                            map2.put("objectToInclFormType", this.objectToInclFormType);
                                                        }
                                                        map2.put("age", this.age);
                                                        map2.put("gender", this.gender);
                                                        map2.put("objectionOnInclusionOrDeletion", str5);
                                                        map2.put("partNumberApplicant", this.partNumberApplicant);
                                                        map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                        map2.put("serialNumberApplicant", this.serialNumber);
                                                        map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                        map2.put("stateCode", this.stateCode);
                                                        map2.put("sectionNoApplicant", this.sectionNo);
                                                        map2.put("sectionNo", this.sectionNo);
                                                        map2.put("isDraft", "N");
                                                        map2.put(this.reasonForDeletionString, str11);
                                                        map2.put("prvsReasonForDeletion", str22);
                                                        map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace.equals("NA")) {
                                                            strReplace = null;
                                                        } else {
                                                            strReplace = null;
                                                        }
                                                        map2.put(this.townVillageString, strReplace);
                                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace2.equals("NA")) {
                                                            strReplace2 = null;
                                                        } else {
                                                            strReplace2 = null;
                                                        }
                                                        map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace3.equals("NA")) {
                                                            strReplace3 = null;
                                                        } else {
                                                            strReplace3 = null;
                                                        }
                                                        map2.put(this.postOfficeString, strReplace3);
                                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace4.equals("NA")) {
                                                            strReplace4 = null;
                                                        } else {
                                                            strReplace4 = null;
                                                        }
                                                        map2.put(this.localityStreetString, strReplace4);
                                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace5.equals("NA")) {
                                                            strReplace5 = null;
                                                        } else {
                                                            strReplace5 = null;
                                                        }
                                                        map2.put(this.houseNumberString, strReplace5);
                                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace6.equals("NA")) {
                                                            strReplace6 = null;
                                                        } else {
                                                            strReplace6 = null;
                                                        }
                                                        map2.put(this.pinCodeString, strReplace6);
                                                        map2.put("pinCodeV1", strReplace6);
                                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace7.equals("null")) {
                                                            strReplace7 = null;
                                                        } else {
                                                            strReplace7 = null;
                                                        }
                                                        map2.put("houseNumberV1", strReplace7);
                                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace8.equals("null")) {
                                                            strReplace8 = "NA";
                                                        } else {
                                                            strReplace8 = "NA";
                                                        }
                                                        map2.put("localityStreetV1", strReplace8);
                                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace9.equals("null")) {
                                                            strReplace9 = null;
                                                        } else {
                                                            strReplace9 = null;
                                                        }
                                                        map2.put("postOfficeV1", strReplace9);
                                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace10.equals("null")) {
                                                            strReplace10 = "NA";
                                                        } else {
                                                            strReplace10 = "NA";
                                                        }
                                                        map2.put("tehsilTalukaMandalV1", strReplace10);
                                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace11.equals("null")) {
                                                            str13 = null;
                                                        } else {
                                                            str13 = null;
                                                        }
                                                        map2.put("townVillageV1", str13);
                                                        map2.put("form7Id", this.id);
                                                        map2.put("isReinitiate", "Y");
                                                        Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                                                    }
                                                    if (this.binding.optionRb1.isChecked()) {
                                                        str15 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                                    } else if (this.binding.optionRb2.isChecked()) {
                                                        str15 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                                    } else {
                                                        if (this.binding.optionRb3.isChecked()) {
                                                            str15 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                                        }
                                                        if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                            this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                            if (!this.binding.optionRb1.isChecked()) {
                                                                str14 = this.reasonmap.get(this.prvsReasonForDeletion);
                                                            }
                                                            str10 = str14;
                                                        } else {
                                                            str10 = null;
                                                        }
                                                        if (str19.equalsIgnoreCase("aerl")) {
                                                            showAerlDialog();
                                                            this.alertDialog.dismiss();
                                                            return;
                                                        }
                                                        if (this.binding.addressSame.isChecked()) {
                                                            obj = "Y";
                                                        } else {
                                                            obj = "N";
                                                        }
                                                        String str24 = str10;
                                                        if (this.binding.notIndianCitizenRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            obj3 = "N";
                                                            obj4 = obj3;
                                                            str9 = str9;
                                                            str7 = str7;
                                                            str6 = str6;
                                                            str5 = str5;
                                                            obj7 = "Y";
                                                            obj6 = obj4;
                                                            obj5 = obj6;
                                                        } else {
                                                            if (this.binding.absentRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                            } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj4 = "Y";
                                                                obj3 = "N";
                                                                obj6 = obj3;
                                                                obj5 = obj6;
                                                                obj7 = obj5;
                                                            } else if (this.binding.deadRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "N";
                                                                obj4 = obj3;
                                                                str9 = str9;
                                                                str7 = str7;
                                                                str6 = str6;
                                                                str5 = str5;
                                                                obj6 = "Y";
                                                                obj5 = obj4;
                                                                obj7 = obj5;
                                                            } else {
                                                                zIsChecked = this.binding.underageRb.isChecked();
                                                                obj2 = OBJECTIONSTRING;
                                                                obj3 = "N";
                                                                if (zIsChecked) {
                                                                    obj4 = obj3;
                                                                    str9 = str9;
                                                                    str7 = str7;
                                                                    str6 = str6;
                                                                    str5 = str5;
                                                                    obj5 = "Y";
                                                                    obj6 = obj4;
                                                                    obj7 = obj6;
                                                                } else {
                                                                    obj4 = obj3;
                                                                }
                                                            }
                                                            obj6 = obj4;
                                                            obj5 = obj6;
                                                            obj7 = obj5;
                                                        }
                                                        if (this.binding.detailsCorrect.isChecked()) {
                                                            obj8 = "Y";
                                                        } else {
                                                            obj8 = "N";
                                                        }
                                                        String str25 = str8;
                                                        map = new HashMap();
                                                        str11 = str19;
                                                        Object obj14 = obj;
                                                        Object obj15 = obj8;
                                                        obj9 = obj7;
                                                        if (!this.notSamedob.equals("Y")) {
                                                            map.put("fieldVerificationAbsent", obj3);
                                                            map.put("fieldVerificationDead", obj6);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj5);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                                        } else {
                                                            map.put("fieldVerificationAbsent", obj3);
                                                            map.put("fieldVerificationDead", obj6);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj5);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                                        }
                                                        map.put("fieldVerificationVerifiedAndCorrect", obj15);
                                                        map.put("fieldVerificationDataEntryErrors", "N");
                                                        map.put("fieldVerificationAddress", obj14);
                                                        map.put("fieldVerificationDobOrAge", "N");
                                                        map.put("fieldVerificationPhoto", "N");
                                                        map.put("fieldVerificationAlreadyAppliedCount", 0);
                                                        map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                        map.put("correctionOfAddress", "N");
                                                        map.put("correctionOfDobAge", "N");
                                                        map.put("correctionOfGender", "N");
                                                        map.put("correctionOfMobile", "N");
                                                        map.put("correctionOfName", "N");
                                                        map.put("correctionOfPhotograpgh", "N");
                                                        map.put("correctionOfRelation", "N");
                                                        map.put("correctionOfRelative", "N");
                                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                        map.put("fieldVerificationChecklist", null);
                                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                                        map.put("latitude", this.lat);
                                                        map.put("longitude", this.longi);
                                                        if (str11.equalsIgnoreCase("aerl")) {
                                                            map.put("aerlState", this.pestatecd);
                                                            map.put("aerlAcNo", this.prvsAcNo);
                                                            map.put("aerlPartNo", this.prvsPartNumber);
                                                            map.put("aerlEpic", this.epicNumber);
                                                        }
                                                        Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                                        map2 = new HashMap();
                                                        map2.put("applicantPlace", this.applicantPlace);
                                                        map2.put("asemblyNo", this.asmblyNO);
                                                        map2.put("createdBy", "operator");
                                                        simpleDateFormat2 = simpleDateFormat3;
                                                        simpleDateFormat = simpleDateFormat4;
                                                        map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                        map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                        if (this.docref.isEmpty()) {
                                                            str12 = null;
                                                        } else {
                                                            str12 = null;
                                                        }
                                                        map2.put("deathCertificateDln", str12);
                                                        map2.put("deletionOfEpicNumberFor", str25);
                                                        map2.put("deletionOfOther", str6);
                                                        map2.put("deletionOfSelf", str7);
                                                        map2.put("districtCode", this.districtCode);
                                                        map2.put("emailApplicant", this.email);
                                                        if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        } else {
                                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        }
                                                        map2.put("isSelfMobile", this.isSelfMobile);
                                                        map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                        map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                        map2.put("firstNameApplicant", this.firstNameApplicant);
                                                        map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                        if (!this.formSubmissionChannel.equals("null")) {
                                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                                        } else {
                                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                                        }
                                                        if (!this.formSubmissionMode.equals("null")) {
                                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                                        } else {
                                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                                        }
                                                        map2.put("formSubmissionPlace", this.formSubmissionPlace);
                                                        if (!this.surname.equals(StringUtils.SPACE)) {
                                                            map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                        }
                                                        if (!this.lastNameApplicant.equals(StringUtils.SPACE)) {
                                                            map2.put("lastnameApplicant", this.lastNameApplicant);
                                                        }
                                                        map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                                                        map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                                                        if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                        } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                        } else {
                                                            strSubstring = null;
                                                        }
                                                        map2.put(this.mobileNumberApplicantString, strSubstring);
                                                        if (this.isSelfMobile.equals("Y")) {
                                                            map2.put(this.mobileNumberSelfString, strSubstring);
                                                        } else {
                                                            map2.put(this.mobileNumberOfRelativeString, strSubstring);
                                                        }
                                                        if (this.request.equals(obj2)) {
                                                            map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                            map2.put("objectToInclFormType", this.objectToInclFormType);
                                                        }
                                                        map2.put("age", this.age);
                                                        map2.put("gender", this.gender);
                                                        map2.put("objectionOnInclusionOrDeletion", str5);
                                                        map2.put("partNumberApplicant", this.partNumberApplicant);
                                                        map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                        map2.put("serialNumberApplicant", this.serialNumber);
                                                        map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                        map2.put("stateCode", this.stateCode);
                                                        map2.put("sectionNoApplicant", this.sectionNo);
                                                        map2.put("sectionNo", this.sectionNo);
                                                        map2.put("isDraft", "N");
                                                        map2.put(this.reasonForDeletionString, str11);
                                                        map2.put("prvsReasonForDeletion", str24);
                                                        map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace.equals("NA")) {
                                                            strReplace = null;
                                                        } else {
                                                            strReplace = null;
                                                        }
                                                        map2.put(this.townVillageString, strReplace);
                                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace2.equals("NA")) {
                                                            strReplace2 = null;
                                                        } else {
                                                            strReplace2 = null;
                                                        }
                                                        map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace3.equals("NA")) {
                                                            strReplace3 = null;
                                                        } else {
                                                            strReplace3 = null;
                                                        }
                                                        map2.put(this.postOfficeString, strReplace3);
                                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace4.equals("NA")) {
                                                            strReplace4 = null;
                                                        } else {
                                                            strReplace4 = null;
                                                        }
                                                        map2.put(this.localityStreetString, strReplace4);
                                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace5.equals("NA")) {
                                                            strReplace5 = null;
                                                        } else {
                                                            strReplace5 = null;
                                                        }
                                                        map2.put(this.houseNumberString, strReplace5);
                                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace6.equals("NA")) {
                                                            strReplace6 = null;
                                                        } else {
                                                            strReplace6 = null;
                                                        }
                                                        map2.put(this.pinCodeString, strReplace6);
                                                        map2.put("pinCodeV1", strReplace6);
                                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace7.equals("null")) {
                                                            strReplace7 = null;
                                                        } else {
                                                            strReplace7 = null;
                                                        }
                                                        map2.put("houseNumberV1", strReplace7);
                                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace8.equals("null")) {
                                                            strReplace8 = "NA";
                                                        } else {
                                                            strReplace8 = "NA";
                                                        }
                                                        map2.put("localityStreetV1", strReplace8);
                                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace9.equals("null")) {
                                                            strReplace9 = null;
                                                        } else {
                                                            strReplace9 = null;
                                                        }
                                                        map2.put("postOfficeV1", strReplace9);
                                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace10.equals("null")) {
                                                            strReplace10 = "NA";
                                                        } else {
                                                            strReplace10 = "NA";
                                                        }
                                                        map2.put("tehsilTalukaMandalV1", strReplace10);
                                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                                        if (strReplace11.equals("null")) {
                                                            str13 = null;
                                                        } else {
                                                            str13 = null;
                                                        }
                                                        map2.put("townVillageV1", str13);
                                                        map2.put("form7Id", this.id);
                                                        map2.put("isReinitiate", "Y");
                                                        Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                                                    }
                                                    map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                                } catch (ParseException e4) {
                                                    e = e4;
                                                    Logger.e(CHECKLISTFORM7, e.getMessage());
                                                }
                                                simpleDateFormat = simpleDateFormat4;
                                            } catch (ParseException e5) {
                                                e = e5;
                                                simpleDateFormat = simpleDateFormat4;
                                            }
                                            simpleDateFormat2 = simpleDateFormat3;
                                        } catch (ParseException e6) {
                                            e = e6;
                                            simpleDateFormat = simpleDateFormat4;
                                            simpleDateFormat2 = simpleDateFormat3;
                                        }
                                        str19 = str15;
                                    } catch (Exception e7) {
                                        Logger.e(CHECKLISTFORM7, e7.getMessage());
                                    }
                                    str18 = str17;
                                    str5 = str18;
                                    str6 = str17;
                                    str7 = str16;
                                    str8 = str;
                                    str9 = string;
                                } catch (Exception e8) {
                                    e = e8;
                                    str = "";
                                    str2 = str;
                                    str3 = str2;
                                    str4 = str3;
                                    Logger.e(CHECKLISTFORM7, e.getMessage());
                                    str5 = str4;
                                    str6 = str3;
                                    str7 = str2;
                                    str8 = str;
                                    str9 = "";
                                    if (this.binding.optionRb1.isChecked()) {
                                        str15 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                    } else if (this.binding.optionRb2.isChecked()) {
                                        str15 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                    } else {
                                        if (this.binding.optionRb3.isChecked()) {
                                            str15 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                        }
                                        if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                            this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                            if (!this.binding.optionRb1.isChecked()) {
                                                str14 = this.reasonmap.get(this.prvsReasonForDeletion);
                                            }
                                            str10 = str14;
                                        } else {
                                            str10 = null;
                                        }
                                        if (str19.equalsIgnoreCase("aerl")) {
                                            showAerlDialog();
                                            this.alertDialog.dismiss();
                                            return;
                                        }
                                        if (this.binding.addressSame.isChecked()) {
                                            obj = "Y";
                                        } else {
                                            obj = "N";
                                        }
                                        String str26 = str10;
                                        if (this.binding.notIndianCitizenRb.isChecked()) {
                                            obj2 = OBJECTIONSTRING;
                                            obj3 = "N";
                                            obj4 = obj3;
                                            str9 = str9;
                                            str7 = str7;
                                            str6 = str6;
                                            str5 = str5;
                                            obj7 = "Y";
                                            obj6 = obj4;
                                            obj5 = obj6;
                                        } else {
                                            if (this.binding.absentRb.isChecked()) {
                                                obj2 = OBJECTIONSTRING;
                                                obj3 = "Y";
                                                obj4 = "N";
                                            } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                obj2 = OBJECTIONSTRING;
                                                obj4 = "Y";
                                                obj3 = "N";
                                                obj6 = obj3;
                                                obj5 = obj6;
                                                obj7 = obj5;
                                            } else if (this.binding.deadRb.isChecked()) {
                                                obj2 = OBJECTIONSTRING;
                                                obj3 = "N";
                                                obj4 = obj3;
                                                str9 = str9;
                                                str7 = str7;
                                                str6 = str6;
                                                str5 = str5;
                                                obj6 = "Y";
                                                obj5 = obj4;
                                                obj7 = obj5;
                                            } else {
                                                zIsChecked = this.binding.underageRb.isChecked();
                                                obj2 = OBJECTIONSTRING;
                                                obj3 = "N";
                                                if (zIsChecked) {
                                                    obj4 = obj3;
                                                    str9 = str9;
                                                    str7 = str7;
                                                    str6 = str6;
                                                    str5 = str5;
                                                    obj5 = "Y";
                                                    obj6 = obj4;
                                                    obj7 = obj6;
                                                } else {
                                                    obj4 = obj3;
                                                }
                                            }
                                            obj6 = obj4;
                                            obj5 = obj6;
                                            obj7 = obj5;
                                        }
                                        if (this.binding.detailsCorrect.isChecked()) {
                                            obj8 = "Y";
                                        } else {
                                            obj8 = "N";
                                        }
                                        String str27 = str8;
                                        map = new HashMap();
                                        str11 = str19;
                                        Object obj16 = obj;
                                        Object obj17 = obj8;
                                        obj9 = obj7;
                                        if (!this.notSamedob.equals("Y")) {
                                            map.put("fieldVerificationAbsent", obj3);
                                            map.put("fieldVerificationDead", obj6);
                                            map.put("fieldVerificationNoSuchPerson", "N");
                                            map.put("fieldVerificationPersonPresent", "N");
                                            map.put("fieldVerificationShifted", "N");
                                            map.put("fieldVerificationUnderAge", obj5);
                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                        } else {
                                            map.put("fieldVerificationAbsent", obj3);
                                            map.put("fieldVerificationDead", obj6);
                                            map.put("fieldVerificationNoSuchPerson", "N");
                                            map.put("fieldVerificationPersonPresent", "N");
                                            map.put("fieldVerificationShifted", "N");
                                            map.put("fieldVerificationUnderAge", obj5);
                                            map.put("fieldVerificationAlreadyEnrolled", obj4);
                                            map.put("fieldVerificationNotIndianCitizen", obj9);
                                        }
                                        map.put("fieldVerificationVerifiedAndCorrect", obj17);
                                        map.put("fieldVerificationDataEntryErrors", "N");
                                        map.put("fieldVerificationAddress", obj16);
                                        map.put("fieldVerificationDobOrAge", "N");
                                        map.put("fieldVerificationPhoto", "N");
                                        map.put("fieldVerificationAlreadyAppliedCount", 0);
                                        map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                        map.put("correctionOfAddress", "N");
                                        map.put("correctionOfDobAge", "N");
                                        map.put("correctionOfGender", "N");
                                        map.put("correctionOfMobile", "N");
                                        map.put("correctionOfName", "N");
                                        map.put("correctionOfPhotograpgh", "N");
                                        map.put("correctionOfRelation", "N");
                                        map.put("correctionOfRelative", "N");
                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                        map.put("fieldVerificationChecklist", null);
                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                        map.put("latitude", this.lat);
                                        map.put("longitude", this.longi);
                                        if (str11.equalsIgnoreCase("aerl")) {
                                            map.put("aerlState", this.pestatecd);
                                            map.put("aerlAcNo", this.prvsAcNo);
                                            map.put("aerlPartNo", this.prvsPartNumber);
                                            map.put("aerlEpic", this.epicNumber);
                                        }
                                        Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                        map2 = new HashMap();
                                        map2.put("applicantPlace", this.applicantPlace);
                                        map2.put("asemblyNo", this.asmblyNO);
                                        map2.put("createdBy", "operator");
                                        simpleDateFormat2 = simpleDateFormat3;
                                        simpleDateFormat = simpleDateFormat4;
                                        map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                        map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                        if (this.docref.isEmpty()) {
                                            str12 = null;
                                        } else {
                                            str12 = null;
                                        }
                                        map2.put("deathCertificateDln", str12);
                                        map2.put("deletionOfEpicNumberFor", str27);
                                        map2.put("deletionOfOther", str6);
                                        map2.put("deletionOfSelf", str7);
                                        map2.put("districtCode", this.districtCode);
                                        map2.put("emailApplicant", this.email);
                                        if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                        } else {
                                            map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                        }
                                        map2.put("isSelfMobile", this.isSelfMobile);
                                        map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                        map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                        map2.put("firstNameApplicant", this.firstNameApplicant);
                                        map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                        if (!this.formSubmissionChannel.equals("null")) {
                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                        } else {
                                            map2.put(this.formSubmissionChannelString, "GARUDA");
                                        }
                                        if (!this.formSubmissionMode.equals("null")) {
                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                        } else {
                                            map2.put(this.formSubmissionModeString, "ONLINE");
                                        }
                                        map2.put("formSubmissionPlace", this.formSubmissionPlace);
                                        if (!this.surname.equals(StringUtils.SPACE)) {
                                            map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                        }
                                        if (!this.lastNameApplicant.equals(StringUtils.SPACE)) {
                                            map2.put("lastnameApplicant", this.lastNameApplicant);
                                        }
                                        map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                                        map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                                        if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                        } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                        } else {
                                            strSubstring = null;
                                        }
                                        map2.put(this.mobileNumberApplicantString, strSubstring);
                                        if (this.isSelfMobile.equals("Y")) {
                                            map2.put(this.mobileNumberSelfString, strSubstring);
                                        } else {
                                            map2.put(this.mobileNumberOfRelativeString, strSubstring);
                                        }
                                        if (this.request.equals(obj2)) {
                                            map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                            map2.put("objectToInclFormType", this.objectToInclFormType);
                                        }
                                        map2.put("age", this.age);
                                        map2.put("gender", this.gender);
                                        map2.put("objectionOnInclusionOrDeletion", str5);
                                        map2.put("partNumberApplicant", this.partNumberApplicant);
                                        map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                        map2.put("serialNumberApplicant", this.serialNumber);
                                        map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                        map2.put("stateCode", this.stateCode);
                                        map2.put("sectionNoApplicant", this.sectionNo);
                                        map2.put("sectionNo", this.sectionNo);
                                        map2.put("isDraft", "N");
                                        map2.put(this.reasonForDeletionString, str11);
                                        map2.put("prvsReasonForDeletion", str26);
                                        map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace.equals("NA")) {
                                            strReplace = null;
                                        } else {
                                            strReplace = null;
                                        }
                                        map2.put(this.townVillageString, strReplace);
                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace2.equals("NA")) {
                                            strReplace2 = null;
                                        } else {
                                            strReplace2 = null;
                                        }
                                        map2.put(this.tehsilTalukaMandalString, strReplace2);
                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace3.equals("NA")) {
                                            strReplace3 = null;
                                        } else {
                                            strReplace3 = null;
                                        }
                                        map2.put(this.postOfficeString, strReplace3);
                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace4.equals("NA")) {
                                            strReplace4 = null;
                                        } else {
                                            strReplace4 = null;
                                        }
                                        map2.put(this.localityStreetString, strReplace4);
                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace5.equals("NA")) {
                                            strReplace5 = null;
                                        } else {
                                            strReplace5 = null;
                                        }
                                        map2.put(this.houseNumberString, strReplace5);
                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace6.equals("NA")) {
                                            strReplace6 = null;
                                        } else {
                                            strReplace6 = null;
                                        }
                                        map2.put(this.pinCodeString, strReplace6);
                                        map2.put("pinCodeV1", strReplace6);
                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace7.equals("null")) {
                                            strReplace7 = null;
                                        } else {
                                            strReplace7 = null;
                                        }
                                        map2.put("houseNumberV1", strReplace7);
                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace8.equals("null")) {
                                            strReplace8 = "NA";
                                        } else {
                                            strReplace8 = "NA";
                                        }
                                        map2.put("localityStreetV1", strReplace8);
                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace9.equals("null")) {
                                            strReplace9 = null;
                                        } else {
                                            strReplace9 = null;
                                        }
                                        map2.put("postOfficeV1", strReplace9);
                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace10.equals("null")) {
                                            strReplace10 = "NA";
                                        } else {
                                            strReplace10 = "NA";
                                        }
                                        map2.put("tehsilTalukaMandalV1", strReplace10);
                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                        if (strReplace11.equals("null")) {
                                            str13 = null;
                                        } else {
                                            str13 = null;
                                        }
                                        map2.put("townVillageV1", str13);
                                        map2.put("form7Id", this.id);
                                        map2.put("isReinitiate", "Y");
                                        Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                                    }
                                    str19 = str15;
                                    if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                        this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                        if (!this.binding.optionRb1.isChecked()) {
                                            str14 = this.reasonmap.get(this.prvsReasonForDeletion);
                                        }
                                        str10 = str14;
                                    } else {
                                        str10 = null;
                                    }
                                    if (str19.equalsIgnoreCase("aerl")) {
                                        showAerlDialog();
                                        this.alertDialog.dismiss();
                                        return;
                                    }
                                    if (this.binding.addressSame.isChecked()) {
                                        obj = "Y";
                                    } else {
                                        obj = "N";
                                    }
                                    String str28 = str10;
                                    if (this.binding.notIndianCitizenRb.isChecked()) {
                                        obj2 = OBJECTIONSTRING;
                                        obj3 = "N";
                                        obj4 = obj3;
                                        str9 = str9;
                                        str7 = str7;
                                        str6 = str6;
                                        str5 = str5;
                                        obj7 = "Y";
                                        obj6 = obj4;
                                        obj5 = obj6;
                                    } else {
                                        if (this.binding.absentRb.isChecked()) {
                                            obj2 = OBJECTIONSTRING;
                                            obj3 = "Y";
                                            obj4 = "N";
                                        } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                            obj2 = OBJECTIONSTRING;
                                            obj4 = "Y";
                                            obj3 = "N";
                                            obj6 = obj3;
                                            obj5 = obj6;
                                            obj7 = obj5;
                                        } else if (this.binding.deadRb.isChecked()) {
                                            obj2 = OBJECTIONSTRING;
                                            obj3 = "N";
                                            obj4 = obj3;
                                            str9 = str9;
                                            str7 = str7;
                                            str6 = str6;
                                            str5 = str5;
                                            obj6 = "Y";
                                            obj5 = obj4;
                                            obj7 = obj5;
                                        } else {
                                            zIsChecked = this.binding.underageRb.isChecked();
                                            obj2 = OBJECTIONSTRING;
                                            obj3 = "N";
                                            if (zIsChecked) {
                                                obj4 = obj3;
                                                str9 = str9;
                                                str7 = str7;
                                                str6 = str6;
                                                str5 = str5;
                                                obj5 = "Y";
                                                obj6 = obj4;
                                                obj7 = obj6;
                                            } else {
                                                obj4 = obj3;
                                            }
                                        }
                                        obj6 = obj4;
                                        obj5 = obj6;
                                        obj7 = obj5;
                                    }
                                    if (this.binding.detailsCorrect.isChecked()) {
                                        obj8 = "Y";
                                    } else {
                                        obj8 = "N";
                                    }
                                    String str29 = str8;
                                    map = new HashMap();
                                    str11 = str19;
                                    Object obj18 = obj;
                                    Object obj19 = obj8;
                                    obj9 = obj7;
                                    if (!this.notSamedob.equals("Y")) {
                                        map.put("fieldVerificationAbsent", obj3);
                                        map.put("fieldVerificationDead", obj6);
                                        map.put("fieldVerificationNoSuchPerson", "N");
                                        map.put("fieldVerificationPersonPresent", "N");
                                        map.put("fieldVerificationShifted", "N");
                                        map.put("fieldVerificationUnderAge", obj5);
                                        map.put("fieldVerificationAlreadyEnrolled", obj4);
                                        map.put("fieldVerificationNotIndianCitizen", obj9);
                                    } else {
                                        map.put("fieldVerificationAbsent", obj3);
                                        map.put("fieldVerificationDead", obj6);
                                        map.put("fieldVerificationNoSuchPerson", "N");
                                        map.put("fieldVerificationPersonPresent", "N");
                                        map.put("fieldVerificationShifted", "N");
                                        map.put("fieldVerificationUnderAge", obj5);
                                        map.put("fieldVerificationAlreadyEnrolled", obj4);
                                        map.put("fieldVerificationNotIndianCitizen", obj9);
                                    }
                                    map.put("fieldVerificationVerifiedAndCorrect", obj19);
                                    map.put("fieldVerificationDataEntryErrors", "N");
                                    map.put("fieldVerificationAddress", obj18);
                                    map.put("fieldVerificationDobOrAge", "N");
                                    map.put("fieldVerificationPhoto", "N");
                                    map.put("fieldVerificationAlreadyAppliedCount", 0);
                                    map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                    map.put("correctionOfAddress", "N");
                                    map.put("correctionOfDobAge", "N");
                                    map.put("correctionOfGender", "N");
                                    map.put("correctionOfMobile", "N");
                                    map.put("correctionOfName", "N");
                                    map.put("correctionOfPhotograpgh", "N");
                                    map.put("correctionOfRelation", "N");
                                    map.put("correctionOfRelative", "N");
                                    map.put("visitCount", Integer.valueOf(this.visitCountId));
                                    map.put("fieldVerificationChecklist", null);
                                    map.put("visitCount", Integer.valueOf(this.visitCountId));
                                    map.put("latitude", this.lat);
                                    map.put("longitude", this.longi);
                                    if (str11.equalsIgnoreCase("aerl")) {
                                        map.put("aerlState", this.pestatecd);
                                        map.put("aerlAcNo", this.prvsAcNo);
                                        map.put("aerlPartNo", this.prvsPartNumber);
                                        map.put("aerlEpic", this.epicNumber);
                                    }
                                    Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                    map2 = new HashMap();
                                    map2.put("applicantPlace", this.applicantPlace);
                                    map2.put("asemblyNo", this.asmblyNO);
                                    map2.put("createdBy", "operator");
                                    simpleDateFormat2 = simpleDateFormat3;
                                    simpleDateFormat = simpleDateFormat4;
                                    map2.put("createdDttm", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                    map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                                    if (this.docref.isEmpty()) {
                                        str12 = null;
                                    } else {
                                        str12 = null;
                                    }
                                    map2.put("deathCertificateDln", str12);
                                    map2.put("deletionOfEpicNumberFor", str29);
                                    map2.put("deletionOfOther", str6);
                                    map2.put("deletionOfSelf", str7);
                                    map2.put("districtCode", this.districtCode);
                                    map2.put("emailApplicant", this.email);
                                    if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                        map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                    } else {
                                        map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                    }
                                    map2.put("isSelfMobile", this.isSelfMobile);
                                    map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                    map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                    map2.put("firstNameApplicant", this.firstNameApplicant);
                                    map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                    if (!this.formSubmissionChannel.equals("null")) {
                                        map2.put(this.formSubmissionChannelString, "GARUDA");
                                    } else {
                                        map2.put(this.formSubmissionChannelString, "GARUDA");
                                    }
                                    if (!this.formSubmissionMode.equals("null")) {
                                        map2.put(this.formSubmissionModeString, "ONLINE");
                                    } else {
                                        map2.put(this.formSubmissionModeString, "ONLINE");
                                    }
                                    map2.put("formSubmissionPlace", this.formSubmissionPlace);
                                    if (!this.surname.equals(StringUtils.SPACE)) {
                                        map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                    }
                                    if (!this.lastNameApplicant.equals(StringUtils.SPACE)) {
                                        map2.put("lastnameApplicant", this.lastNameApplicant);
                                    }
                                    map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                                    map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                                    if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                        strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                    } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                        strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                    } else {
                                        strSubstring = null;
                                    }
                                    map2.put(this.mobileNumberApplicantString, strSubstring);
                                    if (this.isSelfMobile.equals("Y")) {
                                        map2.put(this.mobileNumberSelfString, strSubstring);
                                    } else {
                                        map2.put(this.mobileNumberOfRelativeString, strSubstring);
                                    }
                                    if (this.request.equals(obj2)) {
                                        map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                        map2.put("objectToInclFormType", this.objectToInclFormType);
                                    }
                                    map2.put("age", this.age);
                                    map2.put("gender", this.gender);
                                    map2.put("objectionOnInclusionOrDeletion", str5);
                                    map2.put("partNumberApplicant", this.partNumberApplicant);
                                    map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                    map2.put("serialNumberApplicant", this.serialNumber);
                                    map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                    map2.put("stateCode", this.stateCode);
                                    map2.put("sectionNoApplicant", this.sectionNo);
                                    map2.put("sectionNo", this.sectionNo);
                                    map2.put("isDraft", "N");
                                    map2.put(this.reasonForDeletionString, str11);
                                    map2.put("prvsReasonForDeletion", str28);
                                    map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                    strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace.equals("NA")) {
                                        strReplace = null;
                                    } else {
                                        strReplace = null;
                                    }
                                    map2.put(this.townVillageString, strReplace);
                                    strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace2.equals("NA")) {
                                        strReplace2 = null;
                                    } else {
                                        strReplace2 = null;
                                    }
                                    map2.put(this.tehsilTalukaMandalString, strReplace2);
                                    strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace3.equals("NA")) {
                                        strReplace3 = null;
                                    } else {
                                        strReplace3 = null;
                                    }
                                    map2.put(this.postOfficeString, strReplace3);
                                    strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace4.equals("NA")) {
                                        strReplace4 = null;
                                    } else {
                                        strReplace4 = null;
                                    }
                                    map2.put(this.localityStreetString, strReplace4);
                                    strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace5.equals("NA")) {
                                        strReplace5 = null;
                                    } else {
                                        strReplace5 = null;
                                    }
                                    map2.put(this.houseNumberString, strReplace5);
                                    strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace6.equals("NA")) {
                                        strReplace6 = null;
                                    } else {
                                        strReplace6 = null;
                                    }
                                    map2.put(this.pinCodeString, strReplace6);
                                    map2.put("pinCodeV1", strReplace6);
                                    strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace7.equals("null")) {
                                        strReplace7 = null;
                                    } else {
                                        strReplace7 = null;
                                    }
                                    map2.put("houseNumberV1", strReplace7);
                                    strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace8.equals("null")) {
                                        strReplace8 = "NA";
                                    } else {
                                        strReplace8 = "NA";
                                    }
                                    map2.put("localityStreetV1", strReplace8);
                                    strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace9.equals("null")) {
                                        strReplace9 = null;
                                    } else {
                                        strReplace9 = null;
                                    }
                                    map2.put("postOfficeV1", strReplace9);
                                    strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace10.equals("null")) {
                                        strReplace10 = "NA";
                                    } else {
                                        strReplace10 = "NA";
                                    }
                                    map2.put("tehsilTalukaMandalV1", strReplace10);
                                    strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                                    if (strReplace11.equals("null")) {
                                        str13 = null;
                                    } else {
                                        str13 = null;
                                    }
                                    map2.put("townVillageV1", str13);
                                    map2.put("form7Id", this.id);
                                    map2.put("isReinitiate", "Y");
                                    Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                    this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                                }
                                map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                            } catch (ParseException e9) {
                                Logger.e(CHECKLISTFORM7, e9.getMessage());
                            }
                            if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                if (!this.binding.optionRb1.isChecked()) {
                                    str14 = this.reasonmap.get(this.prvsReasonForDeletion);
                                }
                                str10 = str14;
                            } else {
                                str10 = null;
                            }
                            if (str19.equalsIgnoreCase("aerl")) {
                                showAerlDialog();
                                this.alertDialog.dismiss();
                                return;
                            }
                            if (this.binding.addressSame.isChecked()) {
                                obj = "Y";
                            } else {
                                obj = "N";
                            }
                            String str210 = str10;
                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                obj2 = OBJECTIONSTRING;
                                obj3 = "N";
                                obj4 = obj3;
                                str9 = str9;
                                str7 = str7;
                                str6 = str6;
                                str5 = str5;
                                obj7 = "Y";
                                obj6 = obj4;
                                obj5 = obj6;
                            } else {
                                if (this.binding.absentRb.isChecked()) {
                                    obj2 = OBJECTIONSTRING;
                                    obj3 = "Y";
                                    obj4 = "N";
                                } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                    obj2 = OBJECTIONSTRING;
                                    obj4 = "Y";
                                    obj3 = "N";
                                    obj6 = obj3;
                                    obj5 = obj6;
                                    obj7 = obj5;
                                } else if (this.binding.deadRb.isChecked()) {
                                    obj2 = OBJECTIONSTRING;
                                    obj3 = "N";
                                    obj4 = obj3;
                                    str9 = str9;
                                    str7 = str7;
                                    str6 = str6;
                                    str5 = str5;
                                    obj6 = "Y";
                                    obj5 = obj4;
                                    obj7 = obj5;
                                } else {
                                    zIsChecked = this.binding.underageRb.isChecked();
                                    obj2 = OBJECTIONSTRING;
                                    obj3 = "N";
                                    if (zIsChecked) {
                                        obj4 = obj3;
                                        str9 = str9;
                                        str7 = str7;
                                        str6 = str6;
                                        str5 = str5;
                                        obj5 = "Y";
                                        obj6 = obj4;
                                        obj7 = obj6;
                                    } else {
                                        obj4 = obj3;
                                    }
                                }
                                obj6 = obj4;
                                obj5 = obj6;
                                obj7 = obj5;
                            }
                            if (this.binding.detailsCorrect.isChecked()) {
                                obj8 = "Y";
                            } else {
                                obj8 = "N";
                            }
                            String str211 = str8;
                            map = new HashMap();
                            str11 = str19;
                            Object obj110 = obj;
                            Object obj111 = obj8;
                            obj9 = obj7;
                            if (!this.notSamedob.equals("Y")) {
                                map.put("fieldVerificationAbsent", obj3);
                                map.put("fieldVerificationDead", obj6);
                                map.put("fieldVerificationNoSuchPerson", "N");
                                map.put("fieldVerificationPersonPresent", "N");
                                map.put("fieldVerificationShifted", "N");
                                map.put("fieldVerificationUnderAge", obj5);
                                map.put("fieldVerificationAlreadyEnrolled", obj4);
                                map.put("fieldVerificationNotIndianCitizen", obj9);
                            } else {
                                map.put("fieldVerificationAbsent", obj3);
                                map.put("fieldVerificationDead", obj6);
                                map.put("fieldVerificationNoSuchPerson", "N");
                                map.put("fieldVerificationPersonPresent", "N");
                                map.put("fieldVerificationShifted", "N");
                                map.put("fieldVerificationUnderAge", obj5);
                                map.put("fieldVerificationAlreadyEnrolled", obj4);
                                map.put("fieldVerificationNotIndianCitizen", obj9);
                            }
                            map.put("fieldVerificationVerifiedAndCorrect", obj111);
                            map.put("fieldVerificationDataEntryErrors", "N");
                            map.put("fieldVerificationAddress", obj110);
                            map.put("fieldVerificationDobOrAge", "N");
                            map.put("fieldVerificationPhoto", "N");
                            map.put("fieldVerificationAlreadyAppliedCount", 0);
                            map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                            map.put("correctionOfAddress", "N");
                            map.put("correctionOfDobAge", "N");
                            map.put("correctionOfGender", "N");
                            map.put("correctionOfMobile", "N");
                            map.put("correctionOfName", "N");
                            map.put("correctionOfPhotograpgh", "N");
                            map.put("correctionOfRelation", "N");
                            map.put("correctionOfRelative", "N");
                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                            map.put("fieldVerificationChecklist", null);
                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                            map.put("latitude", this.lat);
                            map.put("longitude", this.longi);
                            if (str11.equalsIgnoreCase("aerl")) {
                                map.put("aerlState", this.pestatecd);
                                map.put("aerlAcNo", this.prvsAcNo);
                                map.put("aerlPartNo", this.prvsPartNumber);
                                map.put("aerlEpic", this.epicNumber);
                            }
                            Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                            map2 = new HashMap();
                            map2.put("applicantPlace", this.applicantPlace);
                            map2.put("asemblyNo", this.asmblyNO);
                            map2.put("createdBy", "operator");
                            if (this.docref.isEmpty()) {
                                str12 = null;
                            } else {
                                str12 = null;
                            }
                            map2.put("deathCertificateDln", str12);
                            map2.put("deletionOfEpicNumberFor", str211);
                            map2.put("deletionOfOther", str6);
                            map2.put("deletionOfSelf", str7);
                            map2.put("districtCode", this.districtCode);
                            map2.put("emailApplicant", this.email);
                            if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                            } else {
                                map2.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                            }
                            map2.put("isSelfMobile", this.isSelfMobile);
                            map2.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                            map2.put(this.epicNumberOfPersonToBeDeletedString, str9);
                            map2.put("firstNameApplicant", this.firstNameApplicant);
                            map2.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                            if (!this.formSubmissionChannel.equals("null")) {
                                map2.put(this.formSubmissionChannelString, "GARUDA");
                            } else {
                                map2.put(this.formSubmissionChannelString, "GARUDA");
                            }
                            if (!this.formSubmissionMode.equals("null")) {
                                map2.put(this.formSubmissionModeString, "ONLINE");
                            } else {
                                map2.put(this.formSubmissionModeString, "ONLINE");
                            }
                            map2.put("formSubmissionPlace", this.formSubmissionPlace);
                            if (!this.surname.equals(StringUtils.SPACE)) {
                                map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                            }
                            if (!this.lastNameApplicant.equals(StringUtils.SPACE)) {
                                map2.put("lastnameApplicant", this.lastNameApplicant);
                            }
                            map2.put("offlineSignedPage1Url", this.offlineSignedPage1Url);
                            map2.put("offlineSignedPage2Url", this.offlineSignedPage2Url);
                            if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                            } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                            } else {
                                strSubstring = null;
                            }
                            map2.put(this.mobileNumberApplicantString, strSubstring);
                            if (this.isSelfMobile.equals("Y")) {
                                map2.put(this.mobileNumberSelfString, strSubstring);
                            } else {
                                map2.put(this.mobileNumberOfRelativeString, strSubstring);
                            }
                            if (this.request.equals(obj2)) {
                                map2.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                map2.put("objectToInclFormType", this.objectToInclFormType);
                            }
                            map2.put("age", this.age);
                            map2.put("gender", this.gender);
                            map2.put("objectionOnInclusionOrDeletion", str5);
                            map2.put("partNumberApplicant", this.partNumberApplicant);
                            map2.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                            map2.put("serialNumberApplicant", this.serialNumber);
                            map2.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                            map2.put("stateCode", this.stateCode);
                            map2.put("sectionNoApplicant", this.sectionNo);
                            map2.put("sectionNo", this.sectionNo);
                            map2.put("isDraft", "N");
                            map2.put(this.reasonForDeletionString, str11);
                            map2.put("prvsReasonForDeletion", str210);
                            map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace.equals("NA")) {
                                strReplace = null;
                            } else {
                                strReplace = null;
                            }
                            map2.put(this.townVillageString, strReplace);
                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace2.equals("NA")) {
                                strReplace2 = null;
                            } else {
                                strReplace2 = null;
                            }
                            map2.put(this.tehsilTalukaMandalString, strReplace2);
                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace3.equals("NA")) {
                                strReplace3 = null;
                            } else {
                                strReplace3 = null;
                            }
                            map2.put(this.postOfficeString, strReplace3);
                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace4.equals("NA")) {
                                strReplace4 = null;
                            } else {
                                strReplace4 = null;
                            }
                            map2.put(this.localityStreetString, strReplace4);
                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace5.equals("NA")) {
                                strReplace5 = null;
                            } else {
                                strReplace5 = null;
                            }
                            map2.put(this.houseNumberString, strReplace5);
                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace6.equals("NA")) {
                                strReplace6 = null;
                            } else {
                                strReplace6 = null;
                            }
                            map2.put(this.pinCodeString, strReplace6);
                            map2.put("pinCodeV1", strReplace6);
                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace7.equals("null")) {
                                strReplace7 = null;
                            } else {
                                strReplace7 = null;
                            }
                            map2.put("houseNumberV1", strReplace7);
                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace8.equals("null")) {
                                strReplace8 = "NA";
                            } else {
                                strReplace8 = "NA";
                            }
                            map2.put("localityStreetV1", strReplace8);
                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace9.equals("null")) {
                                strReplace9 = null;
                            } else {
                                strReplace9 = null;
                            }
                            map2.put("postOfficeV1", strReplace9);
                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace10.equals("null")) {
                                strReplace10 = "NA";
                            } else {
                                strReplace10 = "NA";
                            }
                            map2.put("tehsilTalukaMandalV1", strReplace10);
                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", StringUtils.SPACE);
                            if (strReplace11.equals("null")) {
                                str13 = null;
                            } else {
                                str13 = null;
                            }
                            map2.put("townVillageV1", str13);
                            map2.put("form7Id", this.id);
                            map2.put("isReinitiate", "Y");
                            Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass26(map2, Token, map));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26, reason: invalid class name */
                        class AnonymousClass26 implements Callback<JsonObject> {
                            final /* synthetic */ String val$Token;
                            final /* synthetic */ HashMap val$map;
                            final /* synthetic */ HashMap val$map2;

                            AnonymousClass26(final HashMap val$map, final String val$Token, final HashMap val$map2) {
                                this.val$map = val$map;
                                this.val$Token = val$Token;
                                this.val$map2 = val$map2;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.isSuccessful()) {
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Form 7 Submission: " + this.val$map);
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Form 7 Checklist submitted successfully");
                                    CommomUtility commomUtility = ApplicantDetailsForm7Fragment.this.commonutils;
                                    Context context = ApplicantDetailsForm7Fragment.this.getContext();
                                    String str = ApplicantDetailsForm7Fragment.this.stateCode;
                                    int i = ApplicantDetailsForm7Fragment.this.processMasterId;
                                    int i2 = ApplicantDetailsForm7Fragment.this.currentStatusId;
                                    String str2 = this.val$Token;
                                    String atknBnd = SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.getContext()).getAtknBnd();
                                    String rtknBnd = SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.getContext()).getRtknBnd();
                                    final String str3 = this.val$Token;
                                    final HashMap map = this.val$map2;
                                    commomUtility.getWorkflowid(context, str, i, i2, str2, atknBnd, rtknBnd, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda2
                                        @Override // in.gov.eci.bloapp.MyCallback
                                        public final void onCallback(int i3, String str4) {
                                            this.f$0.lambda$onResponse$2(str3, map, i3, str4);
                                        }
                                    });
                                    return;
                                }
                                try {
                                    if (response.code() == 401) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda3
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i3, String str4, String str5) {
                                                this.f$0.lambda$onResponse$4(i3, str4, str5);
                                            }
                                        });
                                    } else {
                                        JSONObject jSONObject = new JSONObject(response.errorBody().string());
                                        String strOptString = jSONObject.optString(ApplicantDetailsForm7Fragment.this.message);
                                        String strOptString2 = jSONObject.optString("cause");
                                        Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, strOptString);
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        if (strOptString.equals("null")) {
                                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                            applicantDetailsForm7Fragment.showdialog(applicantDetailsForm7Fragment.alert, strOptString2);
                                        } else {
                                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                                            applicantDetailsForm7Fragment2.showdialog(applicantDetailsForm7Fragment2.alert, strOptString);
                                        }
                                    }
                                } catch (Exception e) {
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    if (response.code() == 401) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda4
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i3, String str4, String str5) {
                                                this.f$0.lambda$onResponse$6(i3, str4, str5);
                                            }
                                        });
                                    } else if (response != null && response.message() != null) {
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment3.showdialog(applicantDetailsForm7Fragment3.alert, response.message());
                                    } else {
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment4 = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment4.showdialog(applicantDetailsForm7Fragment4.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                                    }
                                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$2(String str, HashMap map, int i, String str2) {
                                if (i == 401) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda5
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i2, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(i2, str3, str4);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.workflowConfigId = Integer.parseInt(str2);
                                Call<Void> callFormProcessingService = ApplicantDetailsForm7Fragment.this.commonutils.getRetrofitClient(ApplicantDetailsForm7Fragment.this.getContext(), str, SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.getContext()).getRtknBnd()).formProcessingService(ApplicantDetailsForm7Fragment.this.stateCode, "blo", ApplicantDetailsForm7Fragment.this.workflowConfigId, ApplicantDetailsForm7Fragment.this.formProcessingDetailsId, "ANDROIDMOB", map);
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "formProcessingDetailsId : " + ApplicantDetailsForm7Fragment.this.formProcessingDetailsId);
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "workflowConfigId : " + ApplicantDetailsForm7Fragment.this.workflowConfigId);
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "FVR Submission: " + map);
                                callFormProcessingService.enqueue(new AnonymousClass1());
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.submitForm7(applicantDetailsForm7Fragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$1, reason: invalid class name */
                            class AnonymousClass1 implements Callback<Void> {
                                AnonymousClass1() {
                                }

                                public void onResponse(Call<Void> call1, Response<Void> response1) {
                                    if (response1.isSuccessful()) {
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        ApplicantDetailsForm7Fragment.this.showdialogFinal("Success", "Verified Successfully");
                                        return;
                                    }
                                    try {
                                        if (response1.code() == 401) {
                                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$1$$ExternalSyntheticLambda1
                                                @Override // in.gov.eci.bloapp.aadharcallback
                                                public final void onCallBack(int i, String str, String str2) {
                                                    this.f$0.lambda$onResponse$1(i, str, str2);
                                                }
                                            });
                                        } else {
                                            String strOptString = new JSONObject(response1.errorBody().string()).optString("error");
                                            Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, strOptString);
                                            ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                            ApplicantDetailsForm7Fragment.this.showdialog(ApplicantDetailsForm7Fragment.this.alert, strOptString);
                                        }
                                    } catch (Exception e) {
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        if (response1.code() == 401) {
                                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$1$$ExternalSyntheticLambda2
                                                @Override // in.gov.eci.bloapp.aadharcallback
                                                public final void onCallBack(int i, String str, String str2) {
                                                    this.f$0.lambda$onResponse$3(i, str, str2);
                                                }
                                            });
                                        } else if (response1 != null && response1.message() != null) {
                                            ApplicantDetailsForm7Fragment.this.showdialog(ApplicantDetailsForm7Fragment.this.alert, response1.message());
                                        } else {
                                            ApplicantDetailsForm7Fragment.this.showdialog(ApplicantDetailsForm7Fragment.this.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                                        }
                                        Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$1$$ExternalSyntheticLambda3
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                            }
                                        });
                                        return;
                                    }
                                    ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                    ApplicantDetailsForm7Fragment.this.submitForm7(ApplicantDetailsForm7Fragment.this.token);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                    ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$1$$ExternalSyntheticLambda0
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                this.f$0.lambda$onResponse$2(dialogInterface, i2);
                                            }
                                        });
                                        return;
                                    }
                                    ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                    ApplicantDetailsForm7Fragment.this.submitForm7(ApplicantDetailsForm7Fragment.this.token);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                    SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                    ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                                }

                                public void onFailure(Call<Void> call1, Throwable t) {
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    ApplicantDetailsForm7Fragment.this.showdialog(ApplicantDetailsForm7Fragment.this.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$4(int i, String str, String str2) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda1
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$3(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.submitForm7(applicantDetailsForm7Fragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$6(int i, String str, String str2) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$26$$ExternalSyntheticLambda6
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$5(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.submitForm7(applicantDetailsForm7Fragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.showdialog(applicantDetailsForm7Fragment.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showdialogFinal(String title, String msg) {
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda20
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$showdialogFinal$20(dialogInterface, i);
                                }
                            }).create().show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$showdialogFinal$20(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            openFragment(new CheckListMain(), "Applicant Details Form 7");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showdialog(String title, String msg) {
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda13
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            }).create().show();
                        }

                        public void onDestroy() {
                            super.onDestroy();
                        }

                        private boolean validateDateTime() {
                            int i = this.visitCountId;
                            if (i == 0) {
                                this.visitCountId = i + 1;
                                Log.d("TAG", "Form8_visitCountId" + this.visitCountId);
                                return true;
                            }
                            if (i > 0) {
                                try {
                                    DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                    if (!this.actionDate.isEmpty() && !this.actionDate.equalsIgnoreCase("null")) {
                                        String str = this.actionDate;
                                        Logger.d("TAG", "Form8_startDateTime" + str);
                                        LocalDateTime localDateTime = LocalDateTime.parse(str, dateTimeFormatterOfPattern);
                                        Log.d("TAG", "Form8_startTime" + localDateTime);
                                        String str2 = LocalDateTime.now().format(dateTimeFormatterOfPattern);
                                        Logger.d("TAG", "Form8_currentDateTime" + str2);
                                        LocalDateTime localDateTime2 = LocalDateTime.parse(str2, dateTimeFormatterOfPattern);
                                        Log.d("TAG", "Form8_endTime" + localDateTime2);
                                        Duration durationBetween = Duration.between(localDateTime, localDateTime2);
                                        Log.d("TAG", "Form8_duration" + durationBetween);
                                        if (durationBetween.toHours() > 24) {
                                            this.visitCountId++;
                                            return true;
                                        }
                                        showdialog(this.alert, "Elector was found absent today, please plan next visit tomorrow");
                                        return false;
                                    }
                                } catch (Exception e) {
                                    Log.d("parsing error", e.toString());
                                }
                            }
                            return false;
                        }

                        private void getCurrentLocation() {
                            if (ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                if (isGPSEnabled()) {
                                    LocationServices.getFusedLocationProviderClient(requireContext()).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.27
                                        public void onLocationResult(LocationResult locationResult) {
                                            super.onLocationResult(locationResult);
                                            LocationServices.getFusedLocationProviderClient(ApplicantDetailsForm7Fragment.this.requireContext()).removeLocationUpdates(this);
                                            if (locationResult == null || locationResult.getLocations().isEmpty()) {
                                                return;
                                            }
                                            int size = locationResult.getLocations().size() - 1;
                                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                                            ApplicantDetailsForm7Fragment.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                                            ApplicantDetailsForm7Fragment.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                                            Logger.d("latitude and longitudezz", ApplicantDetailsForm7Fragment.this.lat + "  " + ApplicantDetailsForm7Fragment.this.longi);
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
                            LocationServices.getSettingsClient(requireContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda7
                                public final void onComplete(Task task) {
                                    this.f$0.lambda$turnOnGPS$22(task);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$turnOnGPS$22(Task task) {
                            try {
                                Log.d("TAG", "LocationSettingsResponse ---> " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
                                Toast.makeText((Context) requireActivity(), (CharSequence) "GPS is already turned on", 0).show();
                            } catch (ApiException e) {
                                int statusCode = e.getStatusCode();
                                if (statusCode != 6) {
                                    if (statusCode == 8502) {
                                        Log.d("TAG", "Device does not have location");
                                    }
                                } else {
                                    try {
                                        e.startResolutionForResult(requireActivity(), 2);
                                    } catch (IntentSender.SendIntentException e2) {
                                        Logger.d("TAG", "turnOnGPS exception --> " + e2.getMessage());
                                    }
                                }
                            }
                        }

                        private boolean isGPSEnabled() {
                            return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void selectImage5() {
                            final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
                            builder.setTitle(this.addphoto);
                            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda22
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$selectImage5$23(charSequenceArr, dialogInterface, i);
                                }
                            });
                            builder.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$selectImage5$23(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
                            if (charSequenceArr[i].equals(this.takephoto)) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).cameraOnly().start(880);
                            } else if (charSequenceArr[i].equals(this.choosegallery)) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).galleryOnly().start(880);
                            } else if (charSequenceArr[i].equals(this.choosepdf)) {
                                openfile5();
                            } else if (charSequenceArr[i].equals(this.cancel)) {
                                dialogInterface.dismiss();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void selectImage6() {
                            final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
                            builder.setTitle(this.addphoto);
                            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda12
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$selectImage6$24(charSequenceArr, dialogInterface, i);
                                }
                            });
                            builder.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$selectImage6$24(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
                            if (charSequenceArr[i].equals(this.takephoto)) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).cameraOnly().start(881);
                            } else if (charSequenceArr[i].equals(this.choosegallery)) {
                                this.alertDialog.show();
                                ImagePicker.with(this).crop().compress(512).galleryOnly().start(881);
                            } else if (charSequenceArr[i].equals(this.choosepdf)) {
                                openfile6();
                            } else if (charSequenceArr[i].equals(this.cancel)) {
                                dialogInterface.dismiss();
                            }
                        }

                        public void openfile5() {
                            String[] strArr = {this.applicationpdf};
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("*/*");
                            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                            this.activityResultLauncher480.launch(Intent.createChooser(intent, this.chooseFile));
                        }

                        public void openfile6() {
                            String[] strArr = {this.applicationpdf};
                            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("*/*");
                            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                            this.activityResultLauncher481.launch(Intent.createChooser(intent, this.chooseFile));
                        }

                        public void deleteuploadDocPage1() {
                            this.offlineSignedPage1Url = "";
                            this.binding.uploadDoc1Photoname.setText("");
                            this.binding.uploadDoc1Size.setText("");
                            this.binding.uploadDoc1ChooseFile.setEnabled(true);
                            this.binding.uploadDoc1Certi.setVisibility(8);
                            this.binding.uploadDoc1ChooseFile.setTextColor(Color.parseColor(this.whitecolor));
                            this.binding.uploadDoc1ChooseFile.setVisibility(0);
                        }

                        public void deleteuploadDocPage2() {
                            this.offlineSignedPage2Url = "";
                            this.binding.uploadDoc2Photoname.setText("");
                            this.binding.uploadDoc2Size.setText("");
                            this.binding.uploadDoc2ChooseFile.setEnabled(true);
                            this.binding.uploadDoc2Certi.setVisibility(8);
                            this.binding.uploadDoc2ChooseFile.setTextColor(Color.parseColor(this.whitecolor));
                            this.binding.uploadDoc2ChooseFile.setVisibility(0);
                        }

                        public boolean isAutoDse() {
                            return !TextUtils.isEmpty(this.formSubmissionChannel) && this.formSubmissionChannel.equalsIgnoreCase("GARUDA") && !TextUtils.isEmpty(this.formSubmissionMode) && this.formSubmissionMode.equalsIgnoreCase("AUTO-DSE");
                        }

                        /* JADX WARN: Code duplicated, block: B:23:0x00aa  */
                        /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
                        /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
                        /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
                        /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
                        /* JADX WARN: Code duplicated, block: B:34:0x00cb  */
                        /* JADX WARN: Code duplicated, block: B:36:0x00d5  */
                        /* JADX WARN: Code duplicated, block: B:37:0x00db  */
                        /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
                        /* JADX WARN: Code duplicated, block: B:40:0x00ea  */
                        /* JADX WARN: Code duplicated, block: B:42:0x00f4  */
                        /* JADX WARN: Code duplicated, block: B:43:0x00fa  */
                        /* JADX WARN: Code duplicated, block: B:47:0x0108  */
                        /* JADX WARN: Code duplicated, block: B:50:0x01c0  */
                        public void submitForm7FVR(final String Token) {
                            Object obj;
                            Object obj2;
                            Object obj3;
                            Object obj4;
                            Object obj5;
                            Object obj6;
                            final HashMap map;
                            String str;
                            this.alertDialog.show();
                            Logger.d(CHECKLISTFORM7, "in Checklist submitForm7..............................");
                            new SimpleDateFormat("dd/MM/yy");
                            new SimpleDateFormat("yyyy-MM-dd");
                            String str2 = "";
                            try {
                                if (this.binding.optionRb1.isChecked()) {
                                    str = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                } else if (this.binding.optionRb2.isChecked()) {
                                    str = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                } else {
                                    if (this.binding.optionRb3.isChecked()) {
                                        str = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                    }
                                    if (!str2.equalsIgnoreCase("aerl") && !this.checkEpic.booleanValue()) {
                                        showAerlDialog();
                                        this.alertDialog.dismiss();
                                        return;
                                    }
                                    if (this.binding.addressSame.isChecked()) {
                                        obj = "Y";
                                    } else {
                                        obj = "N";
                                    }
                                    if (this.binding.notIndianCitizenRb.isChecked()) {
                                        if (this.binding.absentRb.isChecked()) {
                                            obj3 = "Y";
                                            obj2 = "N";
                                            obj5 = obj2;
                                            obj4 = obj5;
                                            obj6 = obj4;
                                        } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                            obj6 = "Y";
                                            obj2 = "N";
                                            obj3 = obj2;
                                            obj5 = obj3;
                                            obj4 = obj5;
                                        } else if (this.binding.deadRb.isChecked()) {
                                            obj5 = "Y";
                                            obj2 = "N";
                                            obj3 = obj2;
                                            obj4 = obj3;
                                            obj6 = obj4;
                                        } else if (this.binding.underageRb.isChecked()) {
                                            obj4 = "Y";
                                            obj2 = "N";
                                            obj3 = obj2;
                                            obj5 = obj3;
                                            obj6 = obj5;
                                        } else {
                                            obj2 = "N";
                                            obj3 = obj2;
                                        }
                                        String str3 = this.binding.detailsCorrect.isChecked() ? "Y" : "N";
                                        map = new HashMap();
                                        map.put("fieldVerificationAbsent", obj3);
                                        map.put("fieldVerificationDead", obj5);
                                        map.put("fieldVerificationNoSuchPerson", "N");
                                        map.put("fieldVerificationPersonPresent", "N");
                                        map.put("fieldVerificationShifted", "N");
                                        map.put("fieldVerificationUnderAge", obj4);
                                        map.put("fieldVerificationAlreadyEnrolled", obj6);
                                        map.put("fieldVerificationNotIndianCitizen", obj2);
                                        map.put("fieldVerificationVerifiedAndCorrect", str3);
                                        map.put("fieldVerificationDataEntryErrors", "N");
                                        map.put("fieldVerificationAddress", obj);
                                        map.put("fieldVerificationDobOrAge", "N");
                                        map.put("fieldVerificationPhoto", "N");
                                        map.put("fieldVerificationAlreadyAppliedCount", 0);
                                        map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                        map.put("correctionOfAddress", "N");
                                        map.put("correctionOfDobAge", "N");
                                        map.put("correctionOfGender", "N");
                                        map.put("correctionOfMobile", "N");
                                        map.put("correctionOfName", "N");
                                        map.put("correctionOfPhotograpgh", "N");
                                        map.put("correctionOfRelation", "N");
                                        map.put("correctionOfRelative", "N");
                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                        map.put("fieldVerificationChecklist", null);
                                        map.put("visitCount", Integer.valueOf(this.visitCountId));
                                        map.put("latitude", this.lat);
                                        map.put("longitude", this.longi);
                                        if (str2.equalsIgnoreCase("aerl")) {
                                            map.put("aerlState", this.pestatecd);
                                            map.put("aerlAcNo", this.prvsAcNo);
                                            map.put("aerlPartNo", this.prvsPartNumber);
                                            map.put("aerlEpic", this.epicNumber);
                                        }
                                        Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                        this.commonutils.getWorkflowid(getContext(), this.stateCode, this.processMasterId, this.currentStatusId, Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda15
                                            @Override // in.gov.eci.bloapp.MyCallback
                                            public final void onCallback(int i, String str4) {
                                                this.f$0.lambda$submitForm7FVR$27(Token, map, i, str4);
                                            }
                                        });
                                    }
                                    obj2 = "Y";
                                    obj3 = "N";
                                    obj5 = obj3;
                                    obj4 = obj5;
                                    obj6 = obj4;
                                    if (this.binding.detailsCorrect.isChecked()) {
                                    }
                                    map = new HashMap();
                                    map.put("fieldVerificationAbsent", obj3);
                                    map.put("fieldVerificationDead", obj5);
                                    map.put("fieldVerificationNoSuchPerson", "N");
                                    map.put("fieldVerificationPersonPresent", "N");
                                    map.put("fieldVerificationShifted", "N");
                                    map.put("fieldVerificationUnderAge", obj4);
                                    map.put("fieldVerificationAlreadyEnrolled", obj6);
                                    map.put("fieldVerificationNotIndianCitizen", obj2);
                                    map.put("fieldVerificationVerifiedAndCorrect", str3);
                                    map.put("fieldVerificationDataEntryErrors", "N");
                                    map.put("fieldVerificationAddress", obj);
                                    map.put("fieldVerificationDobOrAge", "N");
                                    map.put("fieldVerificationPhoto", "N");
                                    map.put("fieldVerificationAlreadyAppliedCount", 0);
                                    map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                    map.put("correctionOfAddress", "N");
                                    map.put("correctionOfDobAge", "N");
                                    map.put("correctionOfGender", "N");
                                    map.put("correctionOfMobile", "N");
                                    map.put("correctionOfName", "N");
                                    map.put("correctionOfPhotograpgh", "N");
                                    map.put("correctionOfRelation", "N");
                                    map.put("correctionOfRelative", "N");
                                    map.put("visitCount", Integer.valueOf(this.visitCountId));
                                    map.put("fieldVerificationChecklist", null);
                                    map.put("visitCount", Integer.valueOf(this.visitCountId));
                                    map.put("latitude", this.lat);
                                    map.put("longitude", this.longi);
                                    if (str2.equalsIgnoreCase("aerl")) {
                                        map.put("aerlState", this.pestatecd);
                                        map.put("aerlAcNo", this.prvsAcNo);
                                        map.put("aerlPartNo", this.prvsPartNumber);
                                        map.put("aerlEpic", this.epicNumber);
                                    }
                                    Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                    this.commonutils.getWorkflowid(getContext(), this.stateCode, this.processMasterId, this.currentStatusId, Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda15
                                        @Override // in.gov.eci.bloapp.MyCallback
                                        public final void onCallback(int i, String str4) {
                                            this.f$0.lambda$submitForm7FVR$27(Token, map, i, str4);
                                        }
                                    });
                                }
                                str2 = str;
                            } catch (Exception e) {
                                Logger.e(CHECKLISTFORM7, e.getMessage());
                            }
                            if (!str2.equalsIgnoreCase("aerl")) {
                            }
                            if (this.binding.addressSame.isChecked()) {
                                obj = "Y";
                            } else {
                                obj = "N";
                            }
                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                if (this.binding.absentRb.isChecked()) {
                                    obj3 = "Y";
                                    obj2 = "N";
                                    obj5 = obj2;
                                    obj4 = obj5;
                                    obj6 = obj4;
                                } else if (this.binding.alreadyEnrolledRb.isChecked()) {
                                    obj6 = "Y";
                                    obj2 = "N";
                                    obj3 = obj2;
                                    obj5 = obj3;
                                    obj4 = obj5;
                                } else if (this.binding.deadRb.isChecked()) {
                                    obj5 = "Y";
                                    obj2 = "N";
                                    obj3 = obj2;
                                    obj4 = obj3;
                                    obj6 = obj4;
                                } else if (this.binding.underageRb.isChecked()) {
                                    obj4 = "Y";
                                    obj2 = "N";
                                    obj3 = obj2;
                                    obj5 = obj3;
                                    obj6 = obj5;
                                } else {
                                    obj2 = "N";
                                    obj3 = obj2;
                                }
                                if (this.binding.detailsCorrect.isChecked()) {
                                }
                                map = new HashMap();
                                map.put("fieldVerificationAbsent", obj3);
                                map.put("fieldVerificationDead", obj5);
                                map.put("fieldVerificationNoSuchPerson", "N");
                                map.put("fieldVerificationPersonPresent", "N");
                                map.put("fieldVerificationShifted", "N");
                                map.put("fieldVerificationUnderAge", obj4);
                                map.put("fieldVerificationAlreadyEnrolled", obj6);
                                map.put("fieldVerificationNotIndianCitizen", obj2);
                                map.put("fieldVerificationVerifiedAndCorrect", str3);
                                map.put("fieldVerificationDataEntryErrors", "N");
                                map.put("fieldVerificationAddress", obj);
                                map.put("fieldVerificationDobOrAge", "N");
                                map.put("fieldVerificationPhoto", "N");
                                map.put("fieldVerificationAlreadyAppliedCount", 0);
                                map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                map.put("correctionOfAddress", "N");
                                map.put("correctionOfDobAge", "N");
                                map.put("correctionOfGender", "N");
                                map.put("correctionOfMobile", "N");
                                map.put("correctionOfName", "N");
                                map.put("correctionOfPhotograpgh", "N");
                                map.put("correctionOfRelation", "N");
                                map.put("correctionOfRelative", "N");
                                map.put("visitCount", Integer.valueOf(this.visitCountId));
                                map.put("fieldVerificationChecklist", null);
                                map.put("visitCount", Integer.valueOf(this.visitCountId));
                                map.put("latitude", this.lat);
                                map.put("longitude", this.longi);
                                if (str2.equalsIgnoreCase("aerl")) {
                                    map.put("aerlState", this.pestatecd);
                                    map.put("aerlAcNo", this.prvsAcNo);
                                    map.put("aerlPartNo", this.prvsPartNumber);
                                    map.put("aerlEpic", this.epicNumber);
                                }
                                Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                                this.commonutils.getWorkflowid(getContext(), this.stateCode, this.processMasterId, this.currentStatusId, Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda15
                                    @Override // in.gov.eci.bloapp.MyCallback
                                    public final void onCallback(int i, String str4) {
                                        this.f$0.lambda$submitForm7FVR$27(Token, map, i, str4);
                                    }
                                });
                            }
                            obj2 = "Y";
                            obj3 = "N";
                            obj5 = obj3;
                            obj4 = obj5;
                            obj6 = obj4;
                            if (this.binding.detailsCorrect.isChecked()) {
                            }
                            map = new HashMap();
                            map.put("fieldVerificationAbsent", obj3);
                            map.put("fieldVerificationDead", obj5);
                            map.put("fieldVerificationNoSuchPerson", "N");
                            map.put("fieldVerificationPersonPresent", "N");
                            map.put("fieldVerificationShifted", "N");
                            map.put("fieldVerificationUnderAge", obj4);
                            map.put("fieldVerificationAlreadyEnrolled", obj6);
                            map.put("fieldVerificationNotIndianCitizen", obj2);
                            map.put("fieldVerificationVerifiedAndCorrect", str3);
                            map.put("fieldVerificationDataEntryErrors", "N");
                            map.put("fieldVerificationAddress", obj);
                            map.put("fieldVerificationDobOrAge", "N");
                            map.put("fieldVerificationPhoto", "N");
                            map.put("fieldVerificationAlreadyAppliedCount", 0);
                            map.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                            map.put("correctionOfAddress", "N");
                            map.put("correctionOfDobAge", "N");
                            map.put("correctionOfGender", "N");
                            map.put("correctionOfMobile", "N");
                            map.put("correctionOfName", "N");
                            map.put("correctionOfPhotograpgh", "N");
                            map.put("correctionOfRelation", "N");
                            map.put("correctionOfRelative", "N");
                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                            map.put("fieldVerificationChecklist", null);
                            map.put("visitCount", Integer.valueOf(this.visitCountId));
                            map.put("latitude", this.lat);
                            map.put("longitude", this.longi);
                            if (str2.equalsIgnoreCase("aerl")) {
                                map.put("aerlState", this.pestatecd);
                                map.put("aerlAcNo", this.prvsAcNo);
                                map.put("aerlPartNo", this.prvsPartNumber);
                                map.put("aerlEpic", this.epicNumber);
                            }
                            Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                            this.commonutils.getWorkflowid(getContext(), this.stateCode, this.processMasterId, this.currentStatusId, Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda15
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str4) {
                                    this.f$0.lambda$submitForm7FVR$27(Token, map, i, str4);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$submitForm7FVR$27(String str, HashMap map, int i, String str2) {
                            if (i == 401) {
                                this.commonutils.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda18
                                    @Override // in.gov.eci.bloapp.aadharcallback
                                    public final void onCallBack(int i2, String str3, String str4) {
                                        this.f$0.lambda$submitForm7FVR$26(i2, str3, str4);
                                    }
                                });
                                return;
                            }
                            this.workflowConfigId = Integer.parseInt(str2);
                            Call<Void> callFormProcessingService = this.commonutils.getRetrofitClient(getContext(), str, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).formProcessingService(this.stateCode, "blo", this.workflowConfigId, this.formProcessingDetailsId, "ANDROIDMOB", map);
                            Logger.d(CHECKLISTFORM7, "formProcessingDetailsId : " + this.formProcessingDetailsId);
                            Logger.d(CHECKLISTFORM7, "workflowConfigId : " + this.workflowConfigId);
                            Logger.d(CHECKLISTFORM7, "FVR Submission: " + map);
                            callFormProcessingService.enqueue(new AnonymousClass30());
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$submitForm7FVR$26(int i, String str, String str2) {
                            this.alertDialog.dismiss();
                            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                            if (i == 401 || i == 400) {
                                this.commonutils.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda9
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        this.f$0.lambda$submitForm7FVR$25(dialogInterface, i2);
                                    }
                                });
                                return;
                            }
                            this.token = "Bearer " + str;
                            SharedPref.getInstance(requireContext()).setRefreshToken(str2);
                            SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
                            submitForm7FVR(this.token);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$submitForm7FVR$25(DialogInterface dialogInterface, int i) {
                            SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
                            SharedPref.getInstance(requireContext()).setLocaleBool(false);
                            startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$30, reason: invalid class name */
                        class AnonymousClass30 implements Callback<Void> {
                            AnonymousClass30() {
                            }

                            public void onResponse(Call<Void> call1, Response<Void> response1) {
                                if (response1.isSuccessful()) {
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    ApplicantDetailsForm7Fragment.this.showdialogFinal("Success", "Verified Successfully");
                                    return;
                                }
                                try {
                                    if (response1.code() == 401) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$30$$ExternalSyntheticLambda2
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i, String str, String str2) {
                                                this.f$0.lambda$onResponse$1(i, str, str2);
                                            }
                                        });
                                    } else {
                                        String strOptString = new JSONObject(response1.errorBody().string()).optString("error");
                                        Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, strOptString);
                                        ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment.showdialog(applicantDetailsForm7Fragment.alert, strOptString);
                                    }
                                } catch (Exception e) {
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    if (response1.code() == 401) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$30$$ExternalSyntheticLambda3
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i, String str, String str2) {
                                                this.f$0.lambda$onResponse$3(i, str, str2);
                                            }
                                        });
                                    } else if (response1 != null && response1.message() != null) {
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment2.showdialog(applicantDetailsForm7Fragment2.alert, response1.message());
                                    } else {
                                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment3 = ApplicantDetailsForm7Fragment.this;
                                        applicantDetailsForm7Fragment3.showdialog(applicantDetailsForm7Fragment3.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                                    }
                                    Logger.e(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, e.getMessage());
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$30$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.submitForm7FVR(applicantDetailsForm7Fragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$30$$ExternalSyntheticLambda1
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$2(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.submitForm7FVR(applicantDetailsForm7Fragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<Void> call1, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, ApplicantDetailsForm7Fragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = ApplicantDetailsForm7Fragment.this;
                                applicantDetailsForm7Fragment.showdialog(applicantDetailsForm7Fragment.alert, ApplicantDetailsForm7Fragment.this.pleaseSubmitAgain);
                            }
                        }
                    }
