package in.gov.eci.bloapp.views.fragments.checklist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
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
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
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
    String otherDeletionString;
    private String partLang;
    private String partLangSubString;
    private String partNo;
    private String partNumberApplicant;
    private String partNumberOfPersonToBeDeleted;
    private String photoref;
    private String pincodeReset;
    private String postofficeReset;
    private int processMasterId;
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
    private CheckListViewModel viewModel;
    private String villageReset;
    int visitCountId;
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
    CommomUtility commonutils = new CommomUtility();
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
        this.sessionTokenExpiredPleaseLogin = "Session token expired please Login";
        this.comingInOnFailure = "coming in onFailure ";
        this.visitCountId = 0;
        this.notSamedob = "N";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda11
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$15((ActivityResult) obj);
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.rejection_spinner1 /* 2131365361 */:
                if (parent.getItemAtPosition(position).toString().equals(DEATHSTRING)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRb.setChecked(true);
                }
                break;
            case R.id.rejection_spinner2 /* 2131365362 */:
                if (parent.getItemAtPosition(position).toString().equals(DEATHSTRING)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRb.setChecked(true);
                }
                break;
            case R.id.rejection_spinner3 /* 2131365363 */:
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
        this.commonutils.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda14
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
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.objecteeImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.mobNumRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda17
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$5(radioGroup, i);
            }
        });
        this.binding.personalDetailsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda18
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$6(radioGroup, i);
            }
        });
        this.binding.rejectionRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda19
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$7(radioGroup, i);
            }
        });
        this.binding.detailsOfpersonRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$8(radioGroup, i);
            }
        });
        this.binding.deathCertificateBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.rejectionOptionsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$10(radioGroup, i);
            }
        });
        this.binding.deathCertificateReg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$11(radioGroup, i);
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
            this.commonutils.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda9
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
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
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
        if (checkedRadioButtonId == 2131365402) {
            this.isSelfMobile = "N";
        } else {
            if (checkedRadioButtonId != 2131365664) {
                return;
            }
            this.isSelfMobile = "Y";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.personalDetailsRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131364870) {
            this.binding.personalEdit.setVisibility(0);
            return;
        }
        if (checkedRadioButtonId != 2131365554) {
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
        if (checkedRadioButtonId == 2131364871) {
            this.binding.optionsEdit.setVisibility(0);
            this.binding.remarkTv.setText(R.string.blo_remarkPse);
            this.notSamedob = "Y";
            return;
        }
        if (checkedRadioButtonId != 2131365555) {
            return;
        }
        this.binding.remarkTv.setText(R.string.blo_remark);
        this.notSamedob = "N";
        this.binding.optionsEdit.setVisibility(8);
        String str = this.optionRbReset;
        str.hashCode();
        switch (str) {
            case "objection":
                SpannableString spannableString = new SpannableString(this.inclusionString + " " + this.subOptionReset);
                spannableString.setSpan(new StyleSpan(1), 109, this.subOptionReset.length() + 110, 33);
                this.binding.firstText.setText(spannableString);
                this.rejectionOption = this.inclusionString;
                this.rejectionOptionSubcategory = this.subOptionReset;
                break;
            case "same":
                SpannableString spannableString2 = new SpannableString(this.selfDeletionString + " " + this.subOptionReset);
                spannableString2.setSpan(new StyleSpan(1), 88, this.subOptionReset.length() + 89, 33);
                this.binding.firstText.setText(spannableString2);
                this.rejectionOption = this.selfDeletionString;
                this.rejectionOptionSubcategory = this.subOptionReset;
                break;
            case "other":
                SpannableString spannableString3 = new SpannableString(this.otherDeletionString + " " + this.subOptionReset);
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
        if (checkedRadioButtonId == 2131362219) {
            this.binding.detailsofpersonEdit.setVisibility(0);
            return;
        }
        if (checkedRadioButtonId != 2131362223) {
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
            case R.id.option_rb1 /* 2131364928 */:
                this.binding.rejectionSpinnerLayout1.setVisibility(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb2 /* 2131364929 */:
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb3 /* 2131364930 */:
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
        if (checkedRadioButtonId != 2131364847) {
            if (checkedRadioButtonId != 2131366737) {
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
        this.commonutils.getRetrofitClient(getContext(), Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getForm7byFormRefId(refno, "blo", stateCode, "ANDROIDMOB").enqueue(new AnonymousClass11(Token, stateCode));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$Token;
        final /* synthetic */ String val$stateCode;

        AnonymousClass11(final String val$Token, final String val$stateCode) {
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
                ApplicantDetailsForm7Fragment.this.gender = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.gender.equals("null") || ApplicantDetailsForm7Fragment.this.gender.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.gender = null;
                }
                ApplicantDetailsForm7Fragment.this.age = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.age.equals("null") || ApplicantDetailsForm7Fragment.this.age.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.age = null;
                }
                ApplicantDetailsForm7Fragment.this.applicantPlace = String.valueOf(jsonObject.get("applicantPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.applicantPlace.equals("null") || ApplicantDetailsForm7Fragment.this.applicantPlace.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.applicantPlace = null;
                }
                ApplicantDetailsForm7Fragment.this.email = String.valueOf(jsonObject.get("emailApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.email.equals("null") || ApplicantDetailsForm7Fragment.this.email.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.email = null;
                }
                ApplicantDetailsForm7Fragment.this.formSubmissionPlace = String.valueOf(jsonObject.get("formSubmissionPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.formSubmissionPlace.equals("null") || ApplicantDetailsForm7Fragment.this.formSubmissionPlace.isEmpty()) {
                    ApplicantDetailsForm7Fragment.this.formSubmissionPlace = null;
                }
                ApplicantDetailsForm7Fragment.this.firstNameApplicant = String.valueOf(jsonObject.get("firstNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                ApplicantDetailsForm7Fragment.this.lastNameApplicant = String.valueOf(jsonObject.get("lastNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7Fragment.this.lastNameApplicant.isEmpty() || ApplicantDetailsForm7Fragment.this.lastNameApplicant.equals("null")) {
                    ApplicantDetailsForm7Fragment.this.lastNameApplicant = "";
                }
                ApplicantDetailsForm7Fragment.this.binding.applicantNameTv1.setText(ApplicantDetailsForm7Fragment.this.firstNameApplicant + " " + ApplicantDetailsForm7Fragment.this.lastNameApplicant);
                String strReplace = String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                ApplicantDetailsForm7Fragment.this.binding.epicNumberTv1.setText(String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " "));
                if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment5 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment5.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment5.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment6 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment6.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment6.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7Fragment.this.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment7 = ApplicantDetailsForm7Fragment.this;
                    applicantDetailsForm7Fragment7.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7Fragment7.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
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
                    SpannableString spannableString = new SpannableString(ApplicantDetailsForm7Fragment.this.selfDeletionString + " " + ApplicantDetailsForm7Fragment.this.rejectionOptionSubcategory);
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
                        Method dump skipped, instruction units count: 4434
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.AnonymousClass11.onResponse(retrofit2.Call, retrofit2.Response):void");
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$2, reason: invalid class name */
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
                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$2$$ExternalSyntheticLambda0
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
                        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$2$$ExternalSyntheticLambda1
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

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$3, reason: invalid class name */
                class AnonymousClass3 implements Callback<JsonArray> {
                    AnonymousClass3() {
                    }

                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                            for (int i = 0; i < ((JsonArray) response.body()).size(); i++) {
                                JsonObject jsonObject = ((JsonArray) response.body()).get(i).get("content");
                                if (jsonObject.get("partNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(ApplicantDetailsForm7Fragment.this.partNumberOfPersonToBeDeleted) && jsonObject.get("partSerialNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(ApplicantDetailsForm7Fragment.this.serialNumberOfPersonToBeDeleted)) {
                                    ApplicantDetailsForm7Fragment.this.photoref = jsonObject.get("photo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    ApplicantDetailsForm7Fragment.this.getFile(ApplicantDetailsForm7Fragment.this.photoref);
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "in getByEpicForForm........................photoref taken");
                                }
                            }
                            return;
                        }
                        if (response.code() == 401) {
                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$3$$ExternalSyntheticLambda1
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
                        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$3$$ExternalSyntheticLambda0
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
                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                    if (i == 401 || i == 400) {
                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$11$$ExternalSyntheticLambda0
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
                    applicantDetailsForm7Fragment.showdialogFinal(applicantDetailsForm7Fragment.alert, "Page refreshed due to the token expiry");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
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
                this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda13
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
                if (v.getId() == 2131362458) {
                    openFragment(new CheckListMain(), "Applicant Details");
                }
                if (v.getId() == 2131364065) {
                    Intent intent = new Intent(requireContext(), (Class<?>) MainActivity.class);
                    intent.setFlags(268468224);
                    startActivity(intent);
                }
                if (v.getId() == 2131365129) {
                    this.binding.nestedScrollView2.setVisibility(0);
                    this.binding.nestedScrollView.setVisibility(8);
                    this.binding.cardView2.setVisibility(0);
                    this.binding.cardView.setVisibility(8);
                    this.currentSelectedView = this.binding.personalDetailsFormLayout;
                    this.binding.personalDetailsFormLayout.setVisibility(0);
                    this.binding.rejectionOptionsFormLayout.setVisibility(8);
                    this.binding.personDetailsFormLayout.setVisibility(8);
                    this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
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
                if (v.getId() == 2131364933) {
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
                if (v.getId() == 2131363151) {
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
                        this.binding.epicEd2.setText(" ");
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
                if (v.getId() == 2131362600) {
                    this.binding.nestedScrollView2.setVisibility(8);
                    this.binding.nestedScrollView.setVisibility(0);
                    this.binding.cardView2.setVisibility(8);
                    this.binding.cardView.setVisibility(0);
                }
                if (v.getId() == 2131365497) {
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
                                Method dump skipped, instruction units count: 2908
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
                                    SpannableString spannableString = new SpannableString(this.otherDeletionString + " " + this.rejectionOptionSubcategory);
                                    spannableString.setSpan(new StyleSpan(1), 132, this.rejectionOptionSubcategory.length() + 133, 33);
                                    this.binding.firstText.setText(spannableString);
                                } else if (this.binding.optionRb2.isChecked()) {
                                    this.request = OBJECTIONSTRING;
                                    this.rejectionOption = this.inclusionString;
                                    this.rejectionOptionSubcategory = this.binding.rejectionSpinner2.getSelectedItem().toString();
                                    SpannableString spannableString2 = new SpannableString(this.inclusionString + " " + this.rejectionOptionSubcategory);
                                    spannableString2.setSpan(new StyleSpan(1), 109, this.rejectionOptionSubcategory.length() + 110, 33);
                                    this.binding.firstText.setText(spannableString2);
                                } else if (this.binding.optionRb3.isChecked()) {
                                    this.request = SAMESTRING;
                                    this.rejectionOption = this.selfDeletionString;
                                    this.rejectionOptionSubcategory = this.binding.rejectionSpinner3.getSelectedItem().toString();
                                    SpannableString spannableString3 = new SpannableString(this.selfDeletionString + " " + this.rejectionOptionSubcategory);
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
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass12(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$12, reason: invalid class name */
                        class AnonymousClass12 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass12(final String val$fileref) {
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
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$12$$ExternalSyntheticLambda1
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
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$12$$ExternalSyntheticLambda0
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
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$13, reason: invalid class name */
                        class AnonymousClass13 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass13(final String val$fileref) {
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
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$13$$ExternalSyntheticLambda1
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
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$13$$ExternalSyntheticLambda0
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

                        /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$14] */
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
                                List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.14
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
                            if (v.getId() == 2131364086 && hasFocus) {
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
                            if (v.getId() == 2131365885 && hasFocus) {
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
                            if (v.getId() == 2131366678 && hasFocus) {
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
                            if (v.getId() == 2131365206 && hasFocus) {
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
                            if (v.getId() == 2131366007 && hasFocus) {
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
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda8
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
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda10
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void saveimageapi(String captureFileName) {
                            this.alertDialog.show();
                            Logger.d(CHECKLISTFORM7, "in image upload api..............................");
                            File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
                            MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
                            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), this.referenceNo + "_document");
                            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.asmblyNO, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.appName, MediaType.parse("appName"))).enqueue(new AnonymousClass15(captureFileName));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$15, reason: invalid class name */
                        class AnonymousClass15 implements Callback<JsonObject> {
                            final /* synthetic */ String val$captureFileName;

                            AnonymousClass15(final String val$captureFileName) {
                                this.val$captureFileName = val$captureFileName;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.isSuccessful()) {
                                    ApplicantDetailsForm7Fragment.this.docref = String.valueOf(((JsonObject) response.body()).get("refId")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Success_Uploaded: " + ApplicantDetailsForm7Fragment.this.docref);
                                    Log.d("document ", ApplicantDetailsForm7Fragment.this.docref);
                                    ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7Fragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7Fragment.this.requireContext();
                                    String str = ApplicantDetailsForm7Fragment.this.refreshToken;
                                    final String str2 = this.val$captureFileName;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$15$$ExternalSyntheticLambda1
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$15$$ExternalSyntheticLambda0
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
                                ApplicantDetailsForm7Fragment.this.saveimageapi(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7Fragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7Fragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7Fragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7Fragment.CHECKLISTFORM7, "Failed_Uploaded " + t.getMessage());
                                ApplicantDetailsForm7Fragment.this.alertDialog.dismiss();
                            }
                        }

                        private boolean isApplicantValidated() {
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
                            if (!this.notSamedob.equals("Y") || !this.binding.remarkEd.getText().toString().isEmpty()) {
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
                            String string;
                            super.onActivityResult(requestCode, resultCode, data);
                            if (requestCode == 101 && resultCode == -1) {
                                try {
                                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data != null ? data.getData() : null);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                    this.byteArray = byteArrayOutputStream.toByteArray();
                                } catch (IOException e) {
                                    Logger.e(CHECKLISTFORM7, e.getMessage());
                                }
                                try {
                                    Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
                                    if (cursorQuery.getCount() <= 0) {
                                        cursorQuery.close();
                                        throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                                    }
                                    cursorQuery.moveToFirst();
                                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                                    if (this.filesize < 1024) {
                                        this.binding.preview.setVisibility(0);
                                        this.binding.chooseFileItems.setVisibility(0);
                                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                        this.binding.selectName.setText(string);
                                        this.binding.selectSize.setText(this.filesize + "KB");
                                        ImageView imageView = this.binding.preview;
                                        byte[] bArr = this.byteArray;
                                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                        saveimageapi(this.saveImageFileName);
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
                                    ImageView imageView2 = this.binding.preview;
                                    byte[] bArr2 = this.byteArray;
                                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                    saveimageapi(this.saveImageFileName);
                                } catch (Exception e2) {
                                    Logger.d(CHECKLISTFORM7, e2.getMessage());
                                    string = "";
                                }
                            } else {
                                this.alertDialog.dismiss();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Code duplicated, block: B:32:0x007e A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:34:0x0091 A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:37:0x00f6 A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:39:0x010a A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:40:0x0112 A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:41:0x015d A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        /* JADX WARN: Code duplicated, block: B:43:0x0168 A[Catch: Exception -> 0x0173, TryCatch #3 {Exception -> 0x0173, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x0164, B:37:0x00f6, B:39:0x010a, B:40:0x0112, B:41:0x015d, B:43:0x0168, B:44:0x0172), top: B:54:0x0060 }] */
                        public /* synthetic */ void lambda$new$15(ActivityResult activityResult) throws Throwable {
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
                                            saveimageapi(this.saveImageFileName);
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
                                                saveimageapi(this.saveImageFileName);
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
                                        saveimageapi(this.saveImageFileName);
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
                                            saveimageapi(this.saveImageFileName);
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
                            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda6
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$selectImage$16(charSequenceArr, dialogInterface, i);
                                }
                            });
                            builder.show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$selectImage$16(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

                        /* JADX WARN: Code duplicated, block: B:117:0x0383  */
                        /* JADX WARN: Code duplicated, block: B:121:0x038f  */
                        /* JADX WARN: Code duplicated, block: B:124:0x03c0  */
                        /* JADX WARN: Code duplicated, block: B:128:0x03d1  */
                        /* JADX WARN: Code duplicated, block: B:131:0x0417  */
                        /* JADX WARN: Code duplicated, block: B:135:0x0428  */
                        /* JADX WARN: Code duplicated, block: B:138:0x0437  */
                        /* JADX WARN: Code duplicated, block: B:142:0x0448  */
                        /* JADX WARN: Code duplicated, block: B:145:0x0460  */
                        /* JADX WARN: Code duplicated, block: B:150:0x0477  */
                        /* JADX WARN: Code duplicated, block: B:155:0x049a  */
                        /* JADX WARN: Code duplicated, block: B:156:0x04ac  */
                        /* JADX WARN: Code duplicated, block: B:158:0x04c0  */
                        /* JADX WARN: Code duplicated, block: B:159:0x04d2  */
                        /* JADX WARN: Code duplicated, block: B:162:0x04e2  */
                        /* JADX WARN: Code duplicated, block: B:163:0x04e8  */
                        /* JADX WARN: Code duplicated, block: B:166:0x04f7  */
                        /* JADX WARN: Code duplicated, block: B:169:0x058d  */
                        /* JADX WARN: Code duplicated, block: B:171:0x0593  */
                        /* JADX WARN: Code duplicated, block: B:174:0x05b3  */
                        /* JADX WARN: Code duplicated, block: B:176:0x05b9  */
                        /* JADX WARN: Code duplicated, block: B:179:0x05d9  */
                        /* JADX WARN: Code duplicated, block: B:181:0x05df  */
                        /* JADX WARN: Code duplicated, block: B:184:0x05ff  */
                        /* JADX WARN: Code duplicated, block: B:186:0x0605  */
                        /* JADX WARN: Code duplicated, block: B:189:0x0625  */
                        /* JADX WARN: Code duplicated, block: B:191:0x062b  */
                        /* JADX WARN: Code duplicated, block: B:194:0x064b  */
                        /* JADX WARN: Code duplicated, block: B:196:0x0651  */
                        /* JADX WARN: Code duplicated, block: B:199:0x0676  */
                        /* JADX WARN: Code duplicated, block: B:201:0x067c  */
                        /* JADX WARN: Code duplicated, block: B:204:0x069c  */
                        /* JADX WARN: Code duplicated, block: B:206:0x06a2  */
                        /* JADX WARN: Code duplicated, block: B:209:0x06c2  */
                        /* JADX WARN: Code duplicated, block: B:211:0x06c8  */
                        /* JADX WARN: Code duplicated, block: B:214:0x06e8  */
                        /* JADX WARN: Code duplicated, block: B:216:0x06ee  */
                        /* JADX WARN: Code duplicated, block: B:219:0x070e  */
                        /* JADX WARN: Code duplicated, block: B:223:0x0717  */
                        /* JADX WARN: Code duplicated, block: B:35:0x00a5 A[Catch: Exception -> 0x00f9, TryCatch #3 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:232:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:37:0x00bb A[Catch: Exception -> 0x00f9, TryCatch #3 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:232:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:39:0x00c5 A[Catch: Exception -> 0x00f9, TryCatch #3 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:232:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:40:0x00da A[Catch: Exception -> 0x00f9, TryCatch #3 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:232:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:42:0x00e4 A[Catch: Exception -> 0x00f9, TRY_LEAVE, TryCatch #3 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:232:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:48:0x010b  */
                        /* JADX WARN: Code duplicated, block: B:51:0x0119 A[ADDED_TO_REGION, Catch: Exception -> 0x0151, REMOVE, TryCatch #7 {Exception -> 0x0151, blocks: (B:49:0x010f, B:51:0x0119, B:52:0x0124, B:54:0x012e, B:55:0x0139, B:57:0x0143), top: B:239:0x010f }] */
                        /* JADX WARN: Code duplicated, block: B:52:0x0124 A[Catch: Exception -> 0x0151, TryCatch #7 {Exception -> 0x0151, blocks: (B:49:0x010f, B:51:0x0119, B:52:0x0124, B:54:0x012e, B:55:0x0139, B:57:0x0143), top: B:239:0x010f }] */
                        /* JADX WARN: Code duplicated, block: B:63:0x0159  */
                        /* JADX WARN: Code duplicated, block: B:66:0x0166  */
                        /* JADX WARN: Code duplicated, block: B:67:0x0168  */
                        /* JADX WARN: Code duplicated, block: B:70:0x0173  */
                        /* JADX WARN: Code duplicated, block: B:71:0x0184  */
                        /* JADX WARN: Code duplicated, block: B:73:0x018e  */
                        /* JADX WARN: Code duplicated, block: B:75:0x019f  */
                        /* JADX WARN: Code duplicated, block: B:77:0x01a9  */
                        /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
                        /* JADX WARN: Code duplicated, block: B:81:0x01c2  */
                        /* JADX WARN: Code duplicated, block: B:82:0x01d2  */
                        /* JADX WARN: Code duplicated, block: B:84:0x01de  */
                        /* JADX WARN: Code duplicated, block: B:85:0x01e1  */
                        /* JADX WARN: Code duplicated, block: B:89:0x01f7  */
                        /* JADX WARN: Code duplicated, block: B:90:0x01f9  */
                        /* JADX WARN: Code duplicated, block: B:93:0x022b  */
                        /* JADX WARN: Code duplicated, block: B:96:0x0250  */
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
                            Object obj2;
                            Object obj3;
                            Object obj4;
                            Object obj5;
                            Object obj6;
                            Object obj7;
                            HashMap map;
                            Object obj8;
                            HashMap map2;
                            SimpleDateFormat simpleDateFormat;
                            SimpleDateFormat simpleDateFormat2;
                            String str11;
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
                            String str12;
                            String str13;
                            String str14;
                            String string;
                            String str15;
                            String str16;
                            String str17;
                            String str18 = OBJECTIONSTRING;
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
                                                            str15 = "Y";
                                                            str16 = "N";
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
                                                                str15 = str;
                                                                str16 = str15;
                                                            } else {
                                                                str = "INCLUSION";
                                                                string = "NA";
                                                                str17 = "Y";
                                                                str15 = "N";
                                                                str16 = str15;
                                                            }
                                                        } else {
                                                            str = "OTHER";
                                                            try {
                                                                string = this.binding.epic.getText().toString();
                                                                str16 = "Y";
                                                                str15 = "N";
                                                                str17 = str15;
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
                                                        str5 = str17;
                                                        str6 = str16;
                                                        str7 = str15;
                                                        str8 = str;
                                                        str9 = string;
                                                        if (this.binding.optionRb1.isChecked()) {
                                                            str14 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                                        } else if (this.binding.optionRb2.isChecked()) {
                                                            str14 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                                        } else {
                                                            if (this.binding.optionRb3.isChecked()) {
                                                                str14 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                                            }
                                                            if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                                str10 = null;
                                                            } else {
                                                                this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                                try {
                                                                    str13 = (!this.binding.optionRb1.isChecked() || this.binding.optionRb2.isChecked() || this.binding.optionRb3.isChecked()) ? this.reasonmap.get(this.prvsReasonForDeletion) : null;
                                                                    str10 = str13;
                                                                } catch (Exception e3) {
                                                                    Logger.e(CHECKLISTFORM7, e3.getMessage());
                                                                    str10 = null;
                                                                }
                                                            }
                                                            if (this.binding.addressSame.isChecked()) {
                                                                obj = "Y";
                                                            } else {
                                                                obj = "N";
                                                            }
                                                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                                                str18 = OBJECTIONSTRING;
                                                                obj2 = "N";
                                                                obj3 = obj2;
                                                                str19 = str19;
                                                                str9 = str9;
                                                                str5 = str5;
                                                                str10 = str10;
                                                                obj6 = "Y";
                                                                obj4 = obj3;
                                                                obj5 = obj4;
                                                            } else {
                                                                if (this.binding.absentRb.isChecked()) {
                                                                    str18 = OBJECTIONSTRING;
                                                                    obj2 = "N";
                                                                    obj3 = obj2;
                                                                    str19 = str19;
                                                                    str9 = str9;
                                                                    str5 = str5;
                                                                    str10 = str10;
                                                                    obj4 = "Y";
                                                                    obj5 = obj3;
                                                                } else {
                                                                    if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                        obj3 = "Y";
                                                                        obj2 = "N";
                                                                        obj4 = obj2;
                                                                    } else if (this.binding.deadRb.isChecked()) {
                                                                        str18 = OBJECTIONSTRING;
                                                                        obj2 = "N";
                                                                        obj3 = obj2;
                                                                        str19 = str19;
                                                                        str9 = str9;
                                                                        str5 = str5;
                                                                        str10 = str10;
                                                                        obj5 = "Y";
                                                                        obj4 = obj3;
                                                                        obj6 = obj4;
                                                                    } else {
                                                                        if (this.binding.underageRb.isChecked()) {
                                                                            obj2 = "Y";
                                                                            obj3 = "N";
                                                                        } else {
                                                                            obj2 = "N";
                                                                            obj3 = obj2;
                                                                        }
                                                                        obj4 = obj3;
                                                                    }
                                                                    obj5 = obj4;
                                                                }
                                                                obj6 = obj5;
                                                            }
                                                            if (this.binding.detailsCorrect.isChecked()) {
                                                                obj7 = "Y";
                                                            } else {
                                                                obj7 = "N";
                                                            }
                                                            String str20 = str7;
                                                            map = new HashMap();
                                                            String str21 = str6;
                                                            String str22 = str8;
                                                            Object obj9 = obj;
                                                            Object obj10 = obj7;
                                                            obj8 = obj6;
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
                                                                map.put("fieldVerificationAbsent", obj4);
                                                                map.put("fieldVerificationDead", obj5);
                                                                map.put("fieldVerificationNoSuchPerson", "N");
                                                                map.put("fieldVerificationPersonPresent", "N");
                                                                map.put("fieldVerificationShifted", "N");
                                                                map.put("fieldVerificationUnderAge", obj2);
                                                                map.put("fieldVerificationAlreadyEnrolled", obj3);
                                                                map.put("fieldVerificationNotIndianCitizen", obj8);
                                                            }
                                                            map.put("fieldVerificationVerifiedAndCorrect", obj10);
                                                            map.put("fieldVerificationDataEntryErrors", "N");
                                                            map.put("fieldVerificationAddress", obj9);
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
                                                                str11 = null;
                                                            } else {
                                                                str11 = this.docref;
                                                            }
                                                            map2.put("deathCertificateDln", str11);
                                                            map2.put("deletionOfEpicNumberFor", str22);
                                                            map2.put("deletionOfOther", str21);
                                                            map2.put("deletionOfSelf", str20);
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
                                                            if (!this.surname.equals(" ") && !this.surname.isEmpty()) {
                                                                map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                            }
                                                            if (!this.lastNameApplicant.equals(" ") && !this.lastNameApplicant.isEmpty()) {
                                                                map2.put("lastnameApplicant", this.lastNameApplicant);
                                                            }
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
                                                            if (this.request.equals(str18)) {
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
                                                            map2.put(this.reasonForDeletionString, str19);
                                                            map2.put("prvsReasonForDeletion", str10);
                                                            map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace.equals("NA") || strReplace.isEmpty()) {
                                                                strReplace = null;
                                                            }
                                                            map2.put(this.townVillageString, strReplace);
                                                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace2.equals("NA") || strReplace2.isEmpty()) {
                                                                strReplace2 = null;
                                                            }
                                                            map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace3.equals("NA") || strReplace3.isEmpty()) {
                                                                strReplace3 = null;
                                                            }
                                                            map2.put(this.postOfficeString, strReplace3);
                                                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace4.equals("NA") || strReplace4.isEmpty()) {
                                                                strReplace4 = null;
                                                            }
                                                            map2.put(this.localityStreetString, strReplace4);
                                                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace5.equals("NA") || strReplace5.isEmpty()) {
                                                                strReplace5 = null;
                                                            }
                                                            map2.put(this.houseNumberString, strReplace5);
                                                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace6.equals("NA") || strReplace6.isEmpty()) {
                                                                strReplace6 = null;
                                                            }
                                                            map2.put(this.pinCodeString, strReplace6);
                                                            map2.put("pinCodeV1", strReplace6);
                                                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace7.equals("null") || strReplace7.isEmpty()) {
                                                                strReplace7 = null;
                                                            }
                                                            map2.put("houseNumberV1", strReplace7);
                                                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace8.equals("null") || strReplace8.isEmpty()) {
                                                                strReplace8 = "NA";
                                                            }
                                                            map2.put("localityStreetV1", strReplace8);
                                                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace9.equals("null") || strReplace9.isEmpty()) {
                                                                strReplace9 = null;
                                                            }
                                                            map2.put("postOfficeV1", strReplace9);
                                                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace10.equals("null") || strReplace10.isEmpty()) {
                                                                strReplace10 = "NA";
                                                            }
                                                            map2.put("tehsilTalukaMandalV1", strReplace10);
                                                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (!strReplace11.equals("null") || strReplace11.isEmpty()) {
                                                                str12 = null;
                                                            } else {
                                                                str12 = strReplace11;
                                                            }
                                                            map2.put("townVillageV1", str12);
                                                            map2.put("form7Id", this.id);
                                                            map2.put("isReinitiate", "Y");
                                                            Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass16(map2, Token, map));
                                                        }
                                                        str19 = str14;
                                                        if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                            this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                            if (!this.binding.optionRb1.isChecked()) {
                                                                str13 = this.reasonmap.get(this.prvsReasonForDeletion);
                                                            }
                                                            str10 = str13;
                                                        } else {
                                                            str10 = null;
                                                        }
                                                        if (this.binding.addressSame.isChecked()) {
                                                            obj = "Y";
                                                        } else {
                                                            obj = "N";
                                                        }
                                                        if (this.binding.notIndianCitizenRb.isChecked()) {
                                                            str18 = OBJECTIONSTRING;
                                                            obj2 = "N";
                                                            obj3 = obj2;
                                                            str19 = str19;
                                                            str9 = str9;
                                                            str5 = str5;
                                                            str10 = str10;
                                                            obj6 = "Y";
                                                            obj4 = obj3;
                                                            obj5 = obj4;
                                                        } else {
                                                            if (this.binding.absentRb.isChecked()) {
                                                                str18 = OBJECTIONSTRING;
                                                                obj2 = "N";
                                                                obj3 = obj2;
                                                                str19 = str19;
                                                                str9 = str9;
                                                                str5 = str5;
                                                                str10 = str10;
                                                                obj4 = "Y";
                                                                obj5 = obj3;
                                                            } else {
                                                                if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                    obj3 = "Y";
                                                                    obj2 = "N";
                                                                    obj4 = obj2;
                                                                } else if (this.binding.deadRb.isChecked()) {
                                                                    str18 = OBJECTIONSTRING;
                                                                    obj2 = "N";
                                                                    obj3 = obj2;
                                                                    str19 = str19;
                                                                    str9 = str9;
                                                                    str5 = str5;
                                                                    str10 = str10;
                                                                    obj5 = "Y";
                                                                    obj4 = obj3;
                                                                    obj6 = obj4;
                                                                } else {
                                                                    if (this.binding.underageRb.isChecked()) {
                                                                        obj2 = "Y";
                                                                        obj3 = "N";
                                                                    } else {
                                                                        obj2 = "N";
                                                                        obj3 = obj2;
                                                                    }
                                                                    obj4 = obj3;
                                                                }
                                                                obj5 = obj4;
                                                            }
                                                            obj6 = obj5;
                                                        }
                                                        if (this.binding.detailsCorrect.isChecked()) {
                                                            obj7 = "Y";
                                                        } else {
                                                            obj7 = "N";
                                                        }
                                                        String str23 = str7;
                                                        map = new HashMap();
                                                        String str24 = str6;
                                                        String str25 = str8;
                                                        Object obj11 = obj;
                                                        Object obj12 = obj7;
                                                        obj8 = obj6;
                                                        if (!this.notSamedob.equals("Y")) {
                                                            map.put("fieldVerificationAbsent", obj4);
                                                            map.put("fieldVerificationDead", obj5);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj2);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj3);
                                                            map.put("fieldVerificationNotIndianCitizen", obj8);
                                                        } else {
                                                            map.put("fieldVerificationAbsent", obj4);
                                                            map.put("fieldVerificationDead", obj5);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj2);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj3);
                                                            map.put("fieldVerificationNotIndianCitizen", obj8);
                                                        }
                                                        map.put("fieldVerificationVerifiedAndCorrect", obj12);
                                                        map.put("fieldVerificationDataEntryErrors", "N");
                                                        map.put("fieldVerificationAddress", obj11);
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
                                                            str11 = null;
                                                        } else {
                                                            str11 = null;
                                                        }
                                                        map2.put("deathCertificateDln", str11);
                                                        map2.put("deletionOfEpicNumberFor", str25);
                                                        map2.put("deletionOfOther", str24);
                                                        map2.put("deletionOfSelf", str23);
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
                                                        if (!this.surname.equals(" ")) {
                                                            map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                        }
                                                        if (!this.lastNameApplicant.equals(" ")) {
                                                            map2.put("lastnameApplicant", this.lastNameApplicant);
                                                        }
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
                                                        if (this.request.equals(str18)) {
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
                                                        map2.put(this.reasonForDeletionString, str19);
                                                        map2.put("prvsReasonForDeletion", str10);
                                                        map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace.equals("NA")) {
                                                            strReplace = null;
                                                        } else {
                                                            strReplace = null;
                                                        }
                                                        map2.put(this.townVillageString, strReplace);
                                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace2.equals("NA")) {
                                                            strReplace2 = null;
                                                        } else {
                                                            strReplace2 = null;
                                                        }
                                                        map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace3.equals("NA")) {
                                                            strReplace3 = null;
                                                        } else {
                                                            strReplace3 = null;
                                                        }
                                                        map2.put(this.postOfficeString, strReplace3);
                                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace4.equals("NA")) {
                                                            strReplace4 = null;
                                                        } else {
                                                            strReplace4 = null;
                                                        }
                                                        map2.put(this.localityStreetString, strReplace4);
                                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace5.equals("NA")) {
                                                            strReplace5 = null;
                                                        } else {
                                                            strReplace5 = null;
                                                        }
                                                        map2.put(this.houseNumberString, strReplace5);
                                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace6.equals("NA")) {
                                                            strReplace6 = null;
                                                        } else {
                                                            strReplace6 = null;
                                                        }
                                                        map2.put(this.pinCodeString, strReplace6);
                                                        map2.put("pinCodeV1", strReplace6);
                                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace7.equals("null")) {
                                                            strReplace7 = null;
                                                        } else {
                                                            strReplace7 = null;
                                                        }
                                                        map2.put("houseNumberV1", strReplace7);
                                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace8.equals("null")) {
                                                            strReplace8 = "NA";
                                                        } else {
                                                            strReplace8 = "NA";
                                                        }
                                                        map2.put("localityStreetV1", strReplace8);
                                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace9.equals("null")) {
                                                            strReplace9 = null;
                                                        } else {
                                                            strReplace9 = null;
                                                        }
                                                        map2.put("postOfficeV1", strReplace9);
                                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace10.equals("null")) {
                                                            strReplace10 = "NA";
                                                        } else {
                                                            strReplace10 = "NA";
                                                        }
                                                        map2.put("tehsilTalukaMandalV1", strReplace10);
                                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace11.equals("null")) {
                                                            str12 = null;
                                                        } else {
                                                            str12 = null;
                                                        }
                                                        map2.put("townVillageV1", str12);
                                                        map2.put("form7Id", this.id);
                                                        map2.put("isReinitiate", "Y");
                                                        Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass16(map2, Token, map));
                                                    }
                                                    if (this.binding.optionRb1.isChecked()) {
                                                        str14 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                                    } else if (this.binding.optionRb2.isChecked()) {
                                                        str14 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                                    } else {
                                                        if (this.binding.optionRb3.isChecked()) {
                                                            str14 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                                        }
                                                        if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                                            this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                                            if (!this.binding.optionRb1.isChecked()) {
                                                                str13 = this.reasonmap.get(this.prvsReasonForDeletion);
                                                            }
                                                            str10 = str13;
                                                        } else {
                                                            str10 = null;
                                                        }
                                                        if (this.binding.addressSame.isChecked()) {
                                                            obj = "Y";
                                                        } else {
                                                            obj = "N";
                                                        }
                                                        if (this.binding.notIndianCitizenRb.isChecked()) {
                                                            str18 = OBJECTIONSTRING;
                                                            obj2 = "N";
                                                            obj3 = obj2;
                                                            str19 = str19;
                                                            str9 = str9;
                                                            str5 = str5;
                                                            str10 = str10;
                                                            obj6 = "Y";
                                                            obj4 = obj3;
                                                            obj5 = obj4;
                                                        } else {
                                                            if (this.binding.absentRb.isChecked()) {
                                                                str18 = OBJECTIONSTRING;
                                                                obj2 = "N";
                                                                obj3 = obj2;
                                                                str19 = str19;
                                                                str9 = str9;
                                                                str5 = str5;
                                                                str10 = str10;
                                                                obj4 = "Y";
                                                                obj5 = obj3;
                                                            } else {
                                                                if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                    obj3 = "Y";
                                                                    obj2 = "N";
                                                                    obj4 = obj2;
                                                                } else if (this.binding.deadRb.isChecked()) {
                                                                    str18 = OBJECTIONSTRING;
                                                                    obj2 = "N";
                                                                    obj3 = obj2;
                                                                    str19 = str19;
                                                                    str9 = str9;
                                                                    str5 = str5;
                                                                    str10 = str10;
                                                                    obj5 = "Y";
                                                                    obj4 = obj3;
                                                                    obj6 = obj4;
                                                                } else {
                                                                    if (this.binding.underageRb.isChecked()) {
                                                                        obj2 = "Y";
                                                                        obj3 = "N";
                                                                    } else {
                                                                        obj2 = "N";
                                                                        obj3 = obj2;
                                                                    }
                                                                    obj4 = obj3;
                                                                }
                                                                obj5 = obj4;
                                                            }
                                                            obj6 = obj5;
                                                        }
                                                        if (this.binding.detailsCorrect.isChecked()) {
                                                            obj7 = "Y";
                                                        } else {
                                                            obj7 = "N";
                                                        }
                                                        String str26 = str7;
                                                        map = new HashMap();
                                                        String str27 = str6;
                                                        String str28 = str8;
                                                        Object obj13 = obj;
                                                        Object obj14 = obj7;
                                                        obj8 = obj6;
                                                        if (!this.notSamedob.equals("Y")) {
                                                            map.put("fieldVerificationAbsent", obj4);
                                                            map.put("fieldVerificationDead", obj5);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj2);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj3);
                                                            map.put("fieldVerificationNotIndianCitizen", obj8);
                                                        } else {
                                                            map.put("fieldVerificationAbsent", obj4);
                                                            map.put("fieldVerificationDead", obj5);
                                                            map.put("fieldVerificationNoSuchPerson", "N");
                                                            map.put("fieldVerificationPersonPresent", "N");
                                                            map.put("fieldVerificationShifted", "N");
                                                            map.put("fieldVerificationUnderAge", obj2);
                                                            map.put("fieldVerificationAlreadyEnrolled", obj3);
                                                            map.put("fieldVerificationNotIndianCitizen", obj8);
                                                        }
                                                        map.put("fieldVerificationVerifiedAndCorrect", obj14);
                                                        map.put("fieldVerificationDataEntryErrors", "N");
                                                        map.put("fieldVerificationAddress", obj13);
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
                                                            str11 = null;
                                                        } else {
                                                            str11 = null;
                                                        }
                                                        map2.put("deathCertificateDln", str11);
                                                        map2.put("deletionOfEpicNumberFor", str28);
                                                        map2.put("deletionOfOther", str27);
                                                        map2.put("deletionOfSelf", str26);
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
                                                        if (!this.surname.equals(" ")) {
                                                            map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                        }
                                                        if (!this.lastNameApplicant.equals(" ")) {
                                                            map2.put("lastnameApplicant", this.lastNameApplicant);
                                                        }
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
                                                        if (this.request.equals(str18)) {
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
                                                        map2.put(this.reasonForDeletionString, str19);
                                                        map2.put("prvsReasonForDeletion", str10);
                                                        map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace.equals("NA")) {
                                                            strReplace = null;
                                                        } else {
                                                            strReplace = null;
                                                        }
                                                        map2.put(this.townVillageString, strReplace);
                                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace2.equals("NA")) {
                                                            strReplace2 = null;
                                                        } else {
                                                            strReplace2 = null;
                                                        }
                                                        map2.put(this.tehsilTalukaMandalString, strReplace2);
                                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace3.equals("NA")) {
                                                            strReplace3 = null;
                                                        } else {
                                                            strReplace3 = null;
                                                        }
                                                        map2.put(this.postOfficeString, strReplace3);
                                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace4.equals("NA")) {
                                                            strReplace4 = null;
                                                        } else {
                                                            strReplace4 = null;
                                                        }
                                                        map2.put(this.localityStreetString, strReplace4);
                                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace5.equals("NA")) {
                                                            strReplace5 = null;
                                                        } else {
                                                            strReplace5 = null;
                                                        }
                                                        map2.put(this.houseNumberString, strReplace5);
                                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace6.equals("NA")) {
                                                            strReplace6 = null;
                                                        } else {
                                                            strReplace6 = null;
                                                        }
                                                        map2.put(this.pinCodeString, strReplace6);
                                                        map2.put("pinCodeV1", strReplace6);
                                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace7.equals("null")) {
                                                            strReplace7 = null;
                                                        } else {
                                                            strReplace7 = null;
                                                        }
                                                        map2.put("houseNumberV1", strReplace7);
                                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace8.equals("null")) {
                                                            strReplace8 = "NA";
                                                        } else {
                                                            strReplace8 = "NA";
                                                        }
                                                        map2.put("localityStreetV1", strReplace8);
                                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace9.equals("null")) {
                                                            strReplace9 = null;
                                                        } else {
                                                            strReplace9 = null;
                                                        }
                                                        map2.put("postOfficeV1", strReplace9);
                                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace10.equals("null")) {
                                                            strReplace10 = "NA";
                                                        } else {
                                                            strReplace10 = "NA";
                                                        }
                                                        map2.put("tehsilTalukaMandalV1", strReplace10);
                                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace11.equals("null")) {
                                                            str12 = null;
                                                        } else {
                                                            str12 = null;
                                                        }
                                                        map2.put("townVillageV1", str12);
                                                        map2.put("form7Id", this.id);
                                                        map2.put("isReinitiate", "Y");
                                                        Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass16(map2, Token, map));
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
                                        str19 = str14;
                                    } catch (Exception e7) {
                                        Logger.e(CHECKLISTFORM7, e7.getMessage());
                                    }
                                    str17 = str16;
                                    str5 = str17;
                                    str6 = str16;
                                    str7 = str15;
                                    str8 = str;
                                    str9 = string;
                                } catch (Exception e8) {
                                    e = e8;
                                    str = "";
                                    str2 = str;
                                    str3 = str2;
                                }
                                map2.put("formSubmissionDate", simpleDateFormat.format(simpleDateFormat2.parse(this.binding.verificationDateEd.getText().toString())));
                            } catch (ParseException e9) {
                                Logger.e(CHECKLISTFORM7, e9.getMessage());
                            }
                            if (this.originalReasonforDeletion.equalsIgnoreCase(this.rejectionOptionSubcategory)) {
                                this.prvsReasonForDeletion = this.originalReasonforDeletion;
                                if (!this.binding.optionRb1.isChecked()) {
                                    str13 = this.reasonmap.get(this.prvsReasonForDeletion);
                                }
                                str10 = str13;
                            } else {
                                str10 = null;
                            }
                            if (this.binding.addressSame.isChecked()) {
                                obj = "Y";
                            } else {
                                obj = "N";
                            }
                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                str18 = OBJECTIONSTRING;
                                obj2 = "N";
                                obj3 = obj2;
                                str19 = str19;
                                str9 = str9;
                                str5 = str5;
                                str10 = str10;
                                obj6 = "Y";
                                obj4 = obj3;
                                obj5 = obj4;
                            } else {
                                if (this.binding.absentRb.isChecked()) {
                                    str18 = OBJECTIONSTRING;
                                    obj2 = "N";
                                    obj3 = obj2;
                                    str19 = str19;
                                    str9 = str9;
                                    str5 = str5;
                                    str10 = str10;
                                    obj4 = "Y";
                                    obj5 = obj3;
                                } else {
                                    if (this.binding.alreadyEnrolledRb.isChecked()) {
                                        obj3 = "Y";
                                        obj2 = "N";
                                        obj4 = obj2;
                                    } else if (this.binding.deadRb.isChecked()) {
                                        str18 = OBJECTIONSTRING;
                                        obj2 = "N";
                                        obj3 = obj2;
                                        str19 = str19;
                                        str9 = str9;
                                        str5 = str5;
                                        str10 = str10;
                                        obj5 = "Y";
                                        obj4 = obj3;
                                        obj6 = obj4;
                                    } else {
                                        if (this.binding.underageRb.isChecked()) {
                                            obj2 = "Y";
                                            obj3 = "N";
                                        } else {
                                            obj2 = "N";
                                            obj3 = obj2;
                                        }
                                        obj4 = obj3;
                                    }
                                    obj5 = obj4;
                                }
                                obj6 = obj5;
                            }
                            if (this.binding.detailsCorrect.isChecked()) {
                                obj7 = "Y";
                            } else {
                                obj7 = "N";
                            }
                            String str29 = str7;
                            map = new HashMap();
                            String str210 = str6;
                            String str211 = str8;
                            Object obj15 = obj;
                            Object obj16 = obj7;
                            obj8 = obj6;
                            if (!this.notSamedob.equals("Y")) {
                                map.put("fieldVerificationAbsent", obj4);
                                map.put("fieldVerificationDead", obj5);
                                map.put("fieldVerificationNoSuchPerson", "N");
                                map.put("fieldVerificationPersonPresent", "N");
                                map.put("fieldVerificationShifted", "N");
                                map.put("fieldVerificationUnderAge", obj2);
                                map.put("fieldVerificationAlreadyEnrolled", obj3);
                                map.put("fieldVerificationNotIndianCitizen", obj8);
                            } else {
                                map.put("fieldVerificationAbsent", obj4);
                                map.put("fieldVerificationDead", obj5);
                                map.put("fieldVerificationNoSuchPerson", "N");
                                map.put("fieldVerificationPersonPresent", "N");
                                map.put("fieldVerificationShifted", "N");
                                map.put("fieldVerificationUnderAge", obj2);
                                map.put("fieldVerificationAlreadyEnrolled", obj3);
                                map.put("fieldVerificationNotIndianCitizen", obj8);
                            }
                            map.put("fieldVerificationVerifiedAndCorrect", obj16);
                            map.put("fieldVerificationDataEntryErrors", "N");
                            map.put("fieldVerificationAddress", obj15);
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
                            Logger.d(CHECKLISTFORM7, "FVR form 7 " + new JSONObject(map));
                            map2 = new HashMap();
                            map2.put("applicantPlace", this.applicantPlace);
                            map2.put("asemblyNo", this.asmblyNO);
                            map2.put("createdBy", "operator");
                            if (this.docref.isEmpty()) {
                                str11 = null;
                            } else {
                                str11 = null;
                            }
                            map2.put("deathCertificateDln", str11);
                            map2.put("deletionOfEpicNumberFor", str211);
                            map2.put("deletionOfOther", str210);
                            map2.put("deletionOfSelf", str29);
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
                            if (!this.surname.equals(" ")) {
                                map2.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                            }
                            if (!this.lastNameApplicant.equals(" ")) {
                                map2.put("lastnameApplicant", this.lastNameApplicant);
                            }
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
                            if (this.request.equals(str18)) {
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
                            map2.put(this.reasonForDeletionString, str19);
                            map2.put("prvsReasonForDeletion", str10);
                            map2.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace.equals("NA")) {
                                strReplace = null;
                            } else {
                                strReplace = null;
                            }
                            map2.put(this.townVillageString, strReplace);
                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace2.equals("NA")) {
                                strReplace2 = null;
                            } else {
                                strReplace2 = null;
                            }
                            map2.put(this.tehsilTalukaMandalString, strReplace2);
                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace3.equals("NA")) {
                                strReplace3 = null;
                            } else {
                                strReplace3 = null;
                            }
                            map2.put(this.postOfficeString, strReplace3);
                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace4.equals("NA")) {
                                strReplace4 = null;
                            } else {
                                strReplace4 = null;
                            }
                            map2.put(this.localityStreetString, strReplace4);
                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace5.equals("NA")) {
                                strReplace5 = null;
                            } else {
                                strReplace5 = null;
                            }
                            map2.put(this.houseNumberString, strReplace5);
                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace6.equals("NA")) {
                                strReplace6 = null;
                            } else {
                                strReplace6 = null;
                            }
                            map2.put(this.pinCodeString, strReplace6);
                            map2.put("pinCodeV1", strReplace6);
                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace7.equals("null")) {
                                strReplace7 = null;
                            } else {
                                strReplace7 = null;
                            }
                            map2.put("houseNumberV1", strReplace7);
                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace8.equals("null")) {
                                strReplace8 = "NA";
                            } else {
                                strReplace8 = "NA";
                            }
                            map2.put("localityStreetV1", strReplace8);
                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace9.equals("null")) {
                                strReplace9 = null;
                            } else {
                                strReplace9 = null;
                            }
                            map2.put("postOfficeV1", strReplace9);
                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace10.equals("null")) {
                                strReplace10 = "NA";
                            } else {
                                strReplace10 = "NA";
                            }
                            map2.put("tehsilTalukaMandalV1", strReplace10);
                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace11.equals("null")) {
                                str12 = null;
                            } else {
                                str12 = null;
                            }
                            map2.put("townVillageV1", str12);
                            map2.put("form7Id", this.id);
                            map2.put("isReinitiate", "Y");
                            Logger.d(CHECKLISTFORM7, "Form 7 Submission: " + new JSONObject(map2));
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map2).enqueue(new AnonymousClass16(map2, Token, map));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16, reason: invalid class name */
                        class AnonymousClass16 implements Callback<JsonObject> {
                            final /* synthetic */ String val$Token;
                            final /* synthetic */ HashMap val$map;
                            final /* synthetic */ HashMap val$map2;

                            AnonymousClass16(final HashMap val$map, final String val$Token, final HashMap val$map2) {
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
                                    commomUtility.getWorkflowid(context, str, i, i2, str2, atknBnd, rtknBnd, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda0
                                        @Override // in.gov.eci.bloapp.MyCallback
                                        public final void onCallback(int i3, String str4) {
                                            this.f$0.lambda$onResponse$2(str3, map, i3, str4);
                                        }
                                    });
                                    return;
                                }
                                try {
                                    if (response.code() == 401) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda1
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
                                        ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda2
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
                                    ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda5
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
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda4
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

                            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$1, reason: invalid class name */
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
                                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$1$$ExternalSyntheticLambda1
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
                                            ApplicantDetailsForm7Fragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7Fragment.this.requireContext(), ApplicantDetailsForm7Fragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$1$$ExternalSyntheticLambda2
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
                                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$1$$ExternalSyntheticLambda3
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
                                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$1$$ExternalSyntheticLambda0
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
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda3
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
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7Fragment.this.commonutils.showMessageOK(ApplicantDetailsForm7Fragment.this.getContext(), ApplicantDetailsForm7Fragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$16$$ExternalSyntheticLambda6
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
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda12
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$showdialogFinal$17(dialogInterface, i);
                                }
                            }).create().show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$showdialogFinal$17(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            openFragment(new CheckListMain(), "Applicant Details Form 7");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showdialog(String title, String msg) {
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda7
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
                                    LocationServices.getFusedLocationProviderClient(requireContext()).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment.17
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
                            LocationServices.getSettingsClient(requireContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment$$ExternalSyntheticLambda5
                                public final void onComplete(Task task) {
                                    this.f$0.lambda$turnOnGPS$19(task);
                                }
                            });
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$turnOnGPS$19(Task task) {
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
                    }
