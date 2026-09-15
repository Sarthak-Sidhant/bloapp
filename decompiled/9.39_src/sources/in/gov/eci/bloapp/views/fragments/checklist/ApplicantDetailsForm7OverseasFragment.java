package in.gov.eci.bloapp.views.fragments.checklist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.LocaleList;
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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
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
import in.gov.eci.bloapp.databinding.BloFragmentApplicantDetailsForm7OverseasBinding;
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
import in.gov.eci.bloapp.views.fragments.BaseFragment;
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
public class ApplicantDetailsForm7OverseasFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    private static final String ABSENTPERMANENTLYSHIFTED = "Absent/Permanently shifted";
    private static final String ALREADYENROLLED = "Already Enrolled";
    private static final String CHECKLISTFORM7OVERSEAS = "CHECKLIST FORM7OVERSEAS";
    private static final String DEATHSTRING = "Death";
    private static final String NOTINDIANCITIZEN = "Not Indian Citizen";
    private static final String OBJECTIONSTRING = "objection";
    private static final String OTHERSTRING = "other";
    private static final String PERMANENTLYSHIFTED = "Permanently shifted";
    private static final String SAMESTRING = "same";
    private static final String UNDERAGE = "Under Age";
    static int spanExclusiveExclusive = 33;
    ActivityResultLauncher<Intent> activityResultLauncher;
    private String age;
    String alert;
    AlertDialog alertDialog;
    String appName;
    private String applicantPlace;
    private String asmblyNO;
    private BloFragmentApplicantDetailsForm7OverseasBinding binding;
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
    String message;
    private String mobileReset;
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
    String epicId = "epicid";
    String reasonForDeletionString = "reasonForDeletion";
    String english_code = "en_in";
    private String request = "";
    private String rejectionOption = "";
    private String rejectionOptionSubcategory = "";
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

    public ApplicantDetailsForm7OverseasFragment() {
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
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda11
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$15((ActivityResult) obj);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
        this.binding = BloFragmentApplicantDetailsForm7OverseasBinding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        String stateName = SharedPref.getInstance(requireContext()).getStateName();
        String districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
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
            this.epicId = arguments.getString("epicid");
        }
        this.binding.refNoTv.setText(this.referenceNo);
        this.binding.state.setText(stateName);
        this.binding.district.setText(districtName);
        this.reasonmap = new HashMap<>();
        this.commonutils.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda17
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
        this.binding.houseEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7OverseasFragment.this.binding.houseEd.getText().toString();
                if (ApplicantDetailsForm7OverseasFragment.this.binding.houseEd.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.binding.houseEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7OverseasFragment.this.binding.houseEd.setSelection(ApplicantDetailsForm7OverseasFragment.this.binding.houseEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getText().clear();
                }
            }
        });
        this.binding.houseEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getText().toString().matches(RegexMatcher.HOUSE_REGIONAL_REGEX)) {
                        sb.deleteCharAt(ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.setText(sb);
                        ApplicantDetailsForm7OverseasFragment.this.binding.houseEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
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
        this.binding.streetEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7OverseasFragment.this.binding.streetEd.getText().toString();
                if (ApplicantDetailsForm7OverseasFragment.this.binding.streetEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.binding.streetEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7OverseasFragment.this.binding.streetEd.setSelection(ApplicantDetailsForm7OverseasFragment.this.binding.streetEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getText().clear();
                }
            }
        });
        this.binding.streetEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.setText(sb);
                        ApplicantDetailsForm7OverseasFragment.this.binding.streetEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
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
        this.binding.villageEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7OverseasFragment.this.binding.villageEd.getText().toString();
                if (ApplicantDetailsForm7OverseasFragment.this.binding.villageEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.binding.villageEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7OverseasFragment.this.binding.villageEd.setSelection(ApplicantDetailsForm7OverseasFragment.this.binding.villageEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getText().clear();
                }
            }
        });
        this.binding.villageEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.setText(sb);
                        ApplicantDetailsForm7OverseasFragment.this.binding.villageEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
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
        this.binding.postofficeEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd.getText().toString();
                if (ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd.setSelection(ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getText().clear();
                }
            }
        });
        this.binding.postofficeEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.setText(sb);
                        ApplicantDetailsForm7OverseasFragment.this.binding.postofficeEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
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
        this.binding.tehsilEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd.getText().toString();
                if (ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd.setSelection(ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getText().clear();
                }
            }
        });
        this.binding.tehsilEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getText().toString());
                    sb.charAt(ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.getSelectionStart() - 1);
                        ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.setText(sb);
                        ApplicantDetailsForm7OverseasFragment.this.binding.tehsilEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
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
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.objecteeImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.mobNumRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$5(radioGroup, i);
            }
        });
        this.binding.personalDetailsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$6(radioGroup, i);
            }
        });
        this.binding.rejectionRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$7(radioGroup, i);
            }
        });
        this.binding.detailsOfpersonRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$8(radioGroup, i);
            }
        });
        this.binding.deathCertificateBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.rejectionOptionsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda7
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$10(radioGroup, i);
            }
        });
        this.binding.deathCertificateReg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda8
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
            this.commonutils.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda16
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
            getForm7ObyFormRefId(this.binding.refNoTv.getText().toString(), this.stateCode, this.token);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonutils.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda0
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
            return;
        }
        if (checkedRadioButtonId != 2131365555) {
            return;
        }
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
            Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.street.getText().toString().trim(), this.binding.streetEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e2) {
            Logger.e(CHECKLISTFORM7OVERSEAS, e2.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.village.getText().toString().trim(), this.binding.villageEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e3) {
            Logger.e(CHECKLISTFORM7OVERSEAS, e3.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.postoffice.getText().toString().trim(), this.binding.postofficeEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e4) {
            Logger.e(CHECKLISTFORM7OVERSEAS, e4.getMessage());
        }
        try {
            FormsMethod.translitration(this.binding.tehsil.getText().toString().trim(), this.binding.tehsilEd2, this.partLang, Constants.transliterationAddress);
        } catch (IOException e5) {
            Logger.e(CHECKLISTFORM7OVERSEAS, e5.getMessage());
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

    private void getForm7ObyFormRefId(String refno, String stateCode, String Token) {
        Logger.d(CHECKLISTFORM7OVERSEAS, "in getchecklistdetails..............................");
        this.commonutils.getRetrofitClient(getContext(), Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getForm7ObyFormRefId(refno, "blo", stateCode, "ANDROIDMOB").enqueue(new AnonymousClass11(Token, stateCode));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11, reason: invalid class name */
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
                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "Checklist Form7 Overseas incoming data: " + jsonObject);
                try {
                    ApplicantDetailsForm7OverseasFragment.this.id = "" + Math.round(jsonObject.get("form7OId").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "id: " + ApplicantDetailsForm7OverseasFragment.this.id);
                } catch (Exception e) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                    ApplicantDetailsForm7OverseasFragment.this.id = null;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.serialNumber = "" + Math.round(jsonObject.get("serialNumberApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "serialNumber: " + ApplicantDetailsForm7OverseasFragment.this.serialNumber);
                } catch (Exception e2) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e2.getMessage());
                    ApplicantDetailsForm7OverseasFragment.this.serialNumber = null;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.partNumberApplicant = "" + Math.round(jsonObject.get("partNumberApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "partNumberApplicant: " + ApplicantDetailsForm7OverseasFragment.this.partNumberApplicant);
                    if (ApplicantDetailsForm7OverseasFragment.this.partNumberApplicant.isEmpty()) {
                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                        applicantDetailsForm7OverseasFragment.partNumberApplicant = applicantDetailsForm7OverseasFragment.partNo;
                    }
                } catch (Exception e3) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e3.getMessage());
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment2.partNumberApplicant = applicantDetailsForm7OverseasFragment2.partNo;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.partNumberOfPersonToBeDeleted = "" + Math.round(jsonObject.get("partNumberOfPersonToBeDeleted").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "partNumberOfPersonToBeDeleted: " + ApplicantDetailsForm7OverseasFragment.this.partNumberOfPersonToBeDeleted);
                    if (ApplicantDetailsForm7OverseasFragment.this.partNumberOfPersonToBeDeleted.isEmpty()) {
                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment3 = ApplicantDetailsForm7OverseasFragment.this;
                        applicantDetailsForm7OverseasFragment3.partNumberOfPersonToBeDeleted = applicantDetailsForm7OverseasFragment3.partNo;
                    }
                } catch (Exception e4) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e4.getMessage());
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment4 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment4.partNumberOfPersonToBeDeleted = applicantDetailsForm7OverseasFragment4.partNo;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.serialNumberOfPersonToBeDeleted = "" + Math.round(jsonObject.get("serailNumberOfPersonToBeDeleted").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "serialNumberOfPersonToBeDeleted: " + ApplicantDetailsForm7OverseasFragment.this.serialNumberOfPersonToBeDeleted);
                } catch (Exception e5) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e5.getMessage());
                    ApplicantDetailsForm7OverseasFragment.this.serialNumberOfPersonToBeDeleted = null;
                }
                try {
                    ApplicantDetailsForm7OverseasFragment.this.sectionNo = "" + Math.round(jsonObject.get("sectionNoApplicant").getAsDouble());
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "sectionNo: " + ApplicantDetailsForm7OverseasFragment.this.sectionNo);
                } catch (Exception e6) {
                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e6.getMessage());
                    ApplicantDetailsForm7OverseasFragment.this.sectionNo = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.gender = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.gender.equals("null") || ApplicantDetailsForm7OverseasFragment.this.gender.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.gender = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.age = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.age.equals("null") || ApplicantDetailsForm7OverseasFragment.this.age.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.age = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.epicId = String.valueOf(jsonObject.get("epicid")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.epicId.equals("null") || ApplicantDetailsForm7OverseasFragment.this.epicId.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.epicId = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.applicantPlace = String.valueOf(jsonObject.get("applicantPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.applicantPlace.equals("null") || ApplicantDetailsForm7OverseasFragment.this.applicantPlace.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.applicantPlace = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.email = String.valueOf(jsonObject.get("emailApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.email.equals("null") || ApplicantDetailsForm7OverseasFragment.this.email.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.email = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.formSubmissionPlace = String.valueOf(jsonObject.get("formSubmissionPlace")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.formSubmissionPlace.equals("null") || ApplicantDetailsForm7OverseasFragment.this.formSubmissionPlace.isEmpty()) {
                    ApplicantDetailsForm7OverseasFragment.this.formSubmissionPlace = null;
                }
                ApplicantDetailsForm7OverseasFragment.this.firstNameApplicant = String.valueOf(jsonObject.get("firstNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                ApplicantDetailsForm7OverseasFragment.this.lastNameApplicant = String.valueOf(jsonObject.get("lastNameApplicant")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (ApplicantDetailsForm7OverseasFragment.this.lastNameApplicant.isEmpty() || ApplicantDetailsForm7OverseasFragment.this.lastNameApplicant.equals("null")) {
                    ApplicantDetailsForm7OverseasFragment.this.lastNameApplicant = "";
                }
                ApplicantDetailsForm7OverseasFragment.this.binding.applicantNameTv1.setText(ApplicantDetailsForm7OverseasFragment.this.firstNameApplicant + " " + ApplicantDetailsForm7OverseasFragment.this.lastNameApplicant);
                String strReplace = String.valueOf(jsonObject.get(ApplicantDetailsForm7OverseasFragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (strReplace.isEmpty() || strReplace.equals("null")) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.epicNumberTv1.setText("");
                } else {
                    ApplicantDetailsForm7OverseasFragment.this.binding.epicNumberTv1.setText(String.valueOf(jsonObject.get(ApplicantDetailsForm7OverseasFragment.this.epicNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " "));
                }
                if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7OverseasFragment.this.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment5 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment5.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7OverseasFragment5.mobileNumberApplicantString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7OverseasFragment.this.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment6 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment6.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7OverseasFragment6.mobileNumberSelfString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                } else if (!String.valueOf(jsonObject.get(ApplicantDetailsForm7OverseasFragment.this.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment7 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment7.mobileReset = String.valueOf(jsonObject.get(applicantDetailsForm7OverseasFragment7.mobileNumberOfRelativeString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                } else {
                    ApplicantDetailsForm7OverseasFragment.this.mobileReset = "";
                }
                if (ApplicantDetailsForm7OverseasFragment.this.mobileReset.isEmpty() || ApplicantDetailsForm7OverseasFragment.this.mobileReset.equals("null")) {
                    ApplicantDetailsForm7OverseasFragment.this.binding.mobileNoTv.setText("");
                    ApplicantDetailsForm7OverseasFragment.this.mobileReset = "";
                } else {
                    if (ApplicantDetailsForm7OverseasFragment.this.mobileReset.startsWith("+91-")) {
                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment8 = ApplicantDetailsForm7OverseasFragment.this;
                        applicantDetailsForm7OverseasFragment8.mobileReset = applicantDetailsForm7OverseasFragment8.mobileReset.substring(4);
                    } else if (ApplicantDetailsForm7OverseasFragment.this.mobileReset.startsWith("+91")) {
                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment9 = ApplicantDetailsForm7OverseasFragment.this;
                        applicantDetailsForm7OverseasFragment9.mobileReset = applicantDetailsForm7OverseasFragment9.mobileReset.substring(3);
                    }
                    ApplicantDetailsForm7OverseasFragment.this.binding.mobileNoTv.setText("+91-" + ApplicantDetailsForm7OverseasFragment.this.mobileReset);
                }
                if (String.valueOf(jsonObject.get("deletionOfSelf")).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    ApplicantDetailsForm7OverseasFragment.this.request = ApplicantDetailsForm7OverseasFragment.SAMESTRING;
                    ApplicantDetailsForm7OverseasFragment.this.optionRbReset = ApplicantDetailsForm7OverseasFragment.SAMESTRING;
                    ApplicantDetailsForm7OverseasFragment.this.isSelfMobile = "Y";
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb3.setChecked(true);
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb2.setEnabled(false);
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb1.setEnabled(false);
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment10 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment10.rejectionOption = applicantDetailsForm7OverseasFragment10.selfDeletionString;
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment11 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment11.rejectionOptionSubcategory = String.valueOf(jsonObject.get(applicantDetailsForm7OverseasFragment11.reasonForDeletionString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory.equals("null")) {
                        ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory = "";
                    }
                    String str = ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory;
                    str.hashCode();
                    switch (str) {
                        case "Not Indian Citizen":
                            ApplicantDetailsForm7OverseasFragment.this.binding.rejectionSpinner3.setSelection(3);
                            break;
                        case "Permanently shifted":
                            ApplicantDetailsForm7OverseasFragment.this.binding.rejectionSpinner3.setSelection(1);
                            break;
                        case "Already Enrolled":
                            ApplicantDetailsForm7OverseasFragment.this.binding.rejectionSpinner3.setSelection(2);
                            break;
                        default:
                            ApplicantDetailsForm7OverseasFragment.this.binding.rejectionSpinner3.setSelection(0);
                            break;
                    }
                    SpannableString spannableString = new SpannableString(ApplicantDetailsForm7OverseasFragment.this.selfDeletionString + " " + ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory);
                    spannableString.setSpan(new StyleSpan(1), 88, ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory.length() + 89, 33);
                    ApplicantDetailsForm7OverseasFragment.this.binding.firstText.setText(spannableString);
                    ApplicantDetailsForm7OverseasFragment.this.binding.self.setChecked(true);
                } else if (String.valueOf(jsonObject.get("deletionOfOther")).replace(RegexMatcher.JSON_STRING_REGEX, "").equals("Y")) {
                    ApplicantDetailsForm7OverseasFragment.this.request = ApplicantDetailsForm7OverseasFragment.OTHERSTRING;
                    ApplicantDetailsForm7OverseasFragment.this.optionRbReset = ApplicantDetailsForm7OverseasFragment.OTHERSTRING;
                    ApplicantDetailsForm7OverseasFragment.this.isSelfMobile = "N";
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb1.setChecked(true);
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb2.setEnabled(false);
                    ApplicantDetailsForm7OverseasFragment.this.binding.optionRb3.setEnabled(false);
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment12 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment12.rejectionOption = applicantDetailsForm7OverseasFragment12.otherDeletionString;
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment13 = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment13.rejectionOptionSubcategory = String.valueOf(jsonObject.get(applicantDetailsForm7OverseasFragment13.reasonForDeletionString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory.equals("null")) {
                        ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory = "";
                    }
                    String str2 = ApplicantDetailsForm7OverseasFragment.this.rejectionOptionSubcategory;
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -211366810:
                            if (str2.equals(ApplicantDetailsForm7OverseasFragment.ABSENTPERMANENTLYSHIFTED)) {
                            }
                            break;
                        case 65905236:
                            if (str2.equals(ApplicantDetailsForm7OverseasFragment.DEATHSTRING)) {
                            }
                            break;
                        case 448850796:
                            if (str2.equals(ApplicantDetailsForm7OverseasFragment.NOTINDIANCITIZEN)) {
                            }
                            break;
                        case 974701431:
                            if (str2.equals(ApplicantDetailsForm7OverseasFragment.UNDERAGE)) {
                            }
                            break;
                        case 1936672461:
                            if (str2.equals(ApplicantDetailsForm7OverseasFragment.ALREADYENROLLED)) {
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
                        Method dump skipped, instruction units count: 4268
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.AnonymousClass11.onResponse(retrofit2.Call, retrofit2.Response):void");
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$2, reason: invalid class name */
                class AnonymousClass2 implements Callback<JsonObject> {
                    AnonymousClass2() {
                    }

                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.code() == 200) {
                            Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7OverseasFragment.this.message)));
                            ApplicantDetailsForm7OverseasFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            if (ApplicantDetailsForm7OverseasFragment.this.base64element1.isEmpty() || ApplicantDetailsForm7OverseasFragment.this.base64element1.equals("null") || ApplicantDetailsForm7OverseasFragment.this.base64element1 == null) {
                                return;
                            }
                            byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7OverseasFragment.this.base64element1, 0);
                            ApplicantDetailsForm7OverseasFragment.this.byteArrayReset = Base64.decode(ApplicantDetailsForm7OverseasFragment.this.base64element1, 0);
                            ApplicantDetailsForm7OverseasFragment.this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                            return;
                        }
                        if (response.code() == 401) {
                            ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$2$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.aadharcallback
                                public final void onCallBack(int i, String str, String str2) {
                                    this.f$0.lambda$onResponse$1(i, str, str2);
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$2$$ExternalSyntheticLambda1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                }
                            });
                            return;
                        }
                        ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                        ApplicantDetailsForm7OverseasFragment.this.showdialogFinal(ApplicantDetailsForm7OverseasFragment.this.alert, "Page refreshed due to the token expiry");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                        ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }

                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                    }
                }

                /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$3, reason: invalid class name */
                class AnonymousClass3 implements Callback<JsonArray> {
                    AnonymousClass3() {
                    }

                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                            for (int i = 0; i < ((JsonArray) response.body()).size(); i++) {
                                JsonObject jsonObject = ((JsonArray) response.body()).get(i).get("content");
                                if (jsonObject.get("partNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(ApplicantDetailsForm7OverseasFragment.this.partNumberOfPersonToBeDeleted) && jsonObject.get("partSerialNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(ApplicantDetailsForm7OverseasFragment.this.serialNumberOfPersonToBeDeleted)) {
                                    ApplicantDetailsForm7OverseasFragment.this.photoref = jsonObject.get("photo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    ApplicantDetailsForm7OverseasFragment.this.getFile(ApplicantDetailsForm7OverseasFragment.this.photoref);
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "in getByEpicForForm........................photoref taken");
                                }
                            }
                            return;
                        }
                        if (response.code() == 401) {
                            ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$3$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.aadharcallback
                                public final void onCallBack(int i2, String str, String str2) {
                                    this.f$0.lambda$onResponse$1(i2, str, str2);
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                        if (i == 401 || i == 400) {
                            ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$3$$ExternalSyntheticLambda1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                }
                            });
                            return;
                        }
                        ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                        ApplicantDetailsForm7OverseasFragment.this.showdialogFinal(ApplicantDetailsForm7OverseasFragment.this.alert, "Page refreshed due to the token expiry");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                        SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                        ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                    }

                    public void onFailure(Call<JsonArray> call, Throwable t) {
                        Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                    if (i == 401 || i == 400) {
                        ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$11$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                            }
                        });
                        return;
                    }
                    ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment.showdialogFinal(applicantDetailsForm7OverseasFragment.alert, "Page refreshed due to the token expiry");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                    ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                    applicantDetailsForm7OverseasFragment.showdialogFinal(applicantDetailsForm7OverseasFragment.alert, "Data Not Found");
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
                this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda9
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
                            Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
                        }
                    }
                    this.binding.streetEd.setText(this.binding.street.getText().toString());
                    if (this.binding.streetEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.streetEd.getText().toString().trim(), this.binding.streetEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e2) {
                            Logger.e(CHECKLISTFORM7OVERSEAS, e2.getMessage());
                        }
                    }
                    this.binding.villageEd.setText(this.binding.village.getText().toString());
                    if (this.binding.villageEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.villageEd.getText().toString().trim(), this.binding.villageEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e3) {
                            Logger.e(CHECKLISTFORM7OVERSEAS, e3.getMessage());
                        }
                    }
                    this.binding.postofficeEd.setText(this.binding.postoffice.getText().toString());
                    if (this.binding.postofficeEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e4) {
                            Logger.e(CHECKLISTFORM7OVERSEAS, e4.getMessage());
                        }
                    }
                    this.binding.pincodeEd.setText(this.binding.pincode.getText().toString());
                    this.binding.tehsilEd.setText(this.binding.tehsil.getText().toString());
                    if (this.binding.tehsilEd2.getText().toString().isEmpty()) {
                        try {
                            FormsMethod.translitration(this.binding.tehsilEd.getText().toString().trim(), this.binding.tehsilEd2, this.partLang, Constants.transliterationAddress);
                        } catch (IOException e5) {
                            Logger.e(CHECKLISTFORM7OVERSEAS, e5.getMessage());
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e6.getMessage());
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
                                Method dump skipped, instruction units count: 2878
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.onClick(android.view.View):void");
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
                            Logger.d(CHECKLISTFORM7OVERSEAS, "in getFile..............................");
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass12(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$12, reason: invalid class name */
                        class AnonymousClass12 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass12(final String val$fileref) {
                                this.val$fileref = val$fileref;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.code() == 200) {
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7OverseasFragment.this.message)));
                                    ApplicantDetailsForm7OverseasFragment.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7OverseasFragment.this.base64element, 0);
                                    ApplicantDetailsForm7OverseasFragment.this.binding.objecteeImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                                    if (ApplicantDetailsForm7OverseasFragment.this.base64element.isEmpty() || ApplicantDetailsForm7OverseasFragment.this.base64element.equals("null") || ApplicantDetailsForm7OverseasFragment.this.base64element == null) {
                                        ApplicantDetailsForm7OverseasFragment.this.binding.objecteeImage.setImageBitmap(BitmapFactory.decodeResource(ApplicantDetailsForm7OverseasFragment.this.getResources(), R.drawable.blo_dummy_image));
                                    }
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7OverseasFragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7OverseasFragment.this.requireContext();
                                    String str = ApplicantDetailsForm7OverseasFragment.this.refreshToken;
                                    final String str2 = this.val$fileref;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$12$$ExternalSyntheticLambda0
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                                ApplicantDetailsForm7OverseasFragment.this.binding.imageEnlargeTv.setVisibility(8);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$12$$ExternalSyntheticLambda1
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str2;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str3);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str2);
                                ApplicantDetailsForm7OverseasFragment.this.getFile(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7OverseasFragment.this.binding.imageEnlargeTv.setVisibility(8);
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                            }
                        }

                        public void getFile1(String fileref) {
                            Logger.d(CHECKLISTFORM7OVERSEAS, "in getFile..............................");
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$13, reason: invalid class name */
                        class AnonymousClass13 implements Callback<JsonObject> {
                            final /* synthetic */ String val$fileref;

                            AnonymousClass13(final String val$fileref) {
                                this.val$fileref = val$fileref;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.code() == 200) {
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, String.valueOf(((JsonObject) response.body()).get(ApplicantDetailsForm7OverseasFragment.this.message)));
                                    ApplicantDetailsForm7OverseasFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    if (!ApplicantDetailsForm7OverseasFragment.this.base64element1.isEmpty() && !ApplicantDetailsForm7OverseasFragment.this.base64element1.equals("null")) {
                                        byte[] bArrDecode = Base64.decode(ApplicantDetailsForm7OverseasFragment.this.base64element1, 0);
                                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                                        if (ApplicantDetailsForm7OverseasFragment.this.docref.contains(".pdf")) {
                                            try {
                                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                                applicantDetailsForm7OverseasFragment.showpdfDialog(bArrDecode, applicantDetailsForm7OverseasFragment.docref);
                                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                                return;
                                            } catch (Exception e) {
                                                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ApplicantDetailsForm7OverseasFragment.this.getResources(), R.drawable.blo_pfd_thumbnail);
                                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = ApplicantDetailsForm7OverseasFragment.this;
                                                applicantDetailsForm7OverseasFragment2.showImageDialog(bitmapDecodeResource, applicantDetailsForm7OverseasFragment2.docref);
                                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                                Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                                                return;
                                            }
                                        }
                                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment3 = ApplicantDetailsForm7OverseasFragment.this;
                                        applicantDetailsForm7OverseasFragment3.showImageDialog(bitmapDecodeByteArray, applicantDetailsForm7OverseasFragment3.docref);
                                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                        return;
                                    }
                                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment4 = ApplicantDetailsForm7OverseasFragment.this;
                                    applicantDetailsForm7OverseasFragment4.showdialog(applicantDetailsForm7OverseasFragment4.alert, ApplicantDetailsForm7OverseasFragment.this.noDocumentAvailable);
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7OverseasFragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7OverseasFragment.this.requireContext();
                                    String str = ApplicantDetailsForm7OverseasFragment.this.refreshToken;
                                    final String str2 = this.val$fileref;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$13$$ExternalSyntheticLambda1
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment5 = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment5.showdialog(applicantDetailsForm7OverseasFragment5.alert, ApplicantDetailsForm7OverseasFragment.this.noDocumentAvailable);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$13$$ExternalSyntheticLambda0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str2;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str3);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str2);
                                ApplicantDetailsForm7OverseasFragment.this.getFile1(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment.showdialog(applicantDetailsForm7OverseasFragment.alert, ApplicantDetailsForm7OverseasFragment.this.noDocumentAvailable);
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                            }
                        }

                        /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$14] */
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
                                    }
                                } catch (UnsupportedEncodingException e2) {
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e2.getMessage());
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                } catch (IOException e3) {
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e3.getMessage());
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                }
                                List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment.14
                                }.getType());
                                DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().insertStates((TState[]) list.toArray(new TState[list.size()]));
                            } catch (Throwable th3) {
                                try {
                                    inputStreamOpenRawResource.close();
                                    stringWriter.flush();
                                    stringWriter.close();
                                } catch (IOException e4) {
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e4.getMessage());
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e2.getMessage());
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e3.getMessage());
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
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e4.getMessage());
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
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e5.getMessage());
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
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda15
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
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda10
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
                            Logger.d(CHECKLISTFORM7OVERSEAS, "in image upload api..............................");
                            File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
                            MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
                            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), this.referenceNo + "_document");
                            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.asmblyNO, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.appName, MediaType.parse("appName"))).enqueue(new AnonymousClass15(captureFileName));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$15, reason: invalid class name */
                        class AnonymousClass15 implements Callback<JsonObject> {
                            final /* synthetic */ String val$captureFileName;

                            AnonymousClass15(final String val$captureFileName) {
                                this.val$captureFileName = val$captureFileName;
                            }

                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.isSuccessful()) {
                                    ApplicantDetailsForm7OverseasFragment.this.docref = String.valueOf(((JsonObject) response.body()).get("refId")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "Success_Uploaded: " + ApplicantDetailsForm7OverseasFragment.this.docref);
                                    Log.d("document ", ApplicantDetailsForm7OverseasFragment.this.docref);
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                if (response.code() == 401) {
                                    CommomUtility commomUtility = ApplicantDetailsForm7OverseasFragment.this.commonutils;
                                    Context contextRequireContext = ApplicantDetailsForm7OverseasFragment.this.requireContext();
                                    String str = ApplicantDetailsForm7OverseasFragment.this.refreshToken;
                                    final String str2 = this.val$captureFileName;
                                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$15$$ExternalSyntheticLambda0
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                                        }
                                    });
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$15$$ExternalSyntheticLambda1
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str2;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str3);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str2);
                                ApplicantDetailsForm7OverseasFragment.this.saveimageapi(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "Failed_Uploaded " + t.getMessage());
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
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
                            if (this.binding.applicantFoundRg.getCheckedRadioButtonId() == -1) {
                                showdialog(this.alert, "Please verify if applicant was present");
                                return false;
                            }
                            if (this.binding.detailsCorrectRg.getCheckedRadioButtonId() != -1) {
                                return true;
                            }
                            showdialog(this.alert, "Please verify if all details matched");
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
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
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
                                    Logger.d(CHECKLISTFORM7OVERSEAS, e2.getMessage());
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
                                        Logger.d(CHECKLISTFORM7OVERSEAS, e.getMessage());
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
                            builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda12
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

                        /* JADX WARN: Code duplicated, block: B:101:0x0355  */
                        /* JADX WARN: Code duplicated, block: B:104:0x0364  */
                        /* JADX WARN: Code duplicated, block: B:108:0x0375  */
                        /* JADX WARN: Code duplicated, block: B:111:0x038d  */
                        /* JADX WARN: Code duplicated, block: B:116:0x03a4  */
                        /* JADX WARN: Code duplicated, block: B:121:0x03c7  */
                        /* JADX WARN: Code duplicated, block: B:122:0x03d9  */
                        /* JADX WARN: Code duplicated, block: B:124:0x03ed  */
                        /* JADX WARN: Code duplicated, block: B:125:0x03ff  */
                        /* JADX WARN: Code duplicated, block: B:128:0x040f  */
                        /* JADX WARN: Code duplicated, block: B:129:0x0415  */
                        /* JADX WARN: Code duplicated, block: B:132:0x0424  */
                        /* JADX WARN: Code duplicated, block: B:135:0x04b3  */
                        /* JADX WARN: Code duplicated, block: B:137:0x04b9  */
                        /* JADX WARN: Code duplicated, block: B:140:0x04d9  */
                        /* JADX WARN: Code duplicated, block: B:142:0x04df  */
                        /* JADX WARN: Code duplicated, block: B:145:0x04ff  */
                        /* JADX WARN: Code duplicated, block: B:147:0x0505  */
                        /* JADX WARN: Code duplicated, block: B:150:0x0525  */
                        /* JADX WARN: Code duplicated, block: B:152:0x052b  */
                        /* JADX WARN: Code duplicated, block: B:155:0x054b  */
                        /* JADX WARN: Code duplicated, block: B:157:0x0551  */
                        /* JADX WARN: Code duplicated, block: B:160:0x0571  */
                        /* JADX WARN: Code duplicated, block: B:162:0x0577  */
                        /* JADX WARN: Code duplicated, block: B:165:0x059c  */
                        /* JADX WARN: Code duplicated, block: B:167:0x05a2  */
                        /* JADX WARN: Code duplicated, block: B:170:0x05c2  */
                        /* JADX WARN: Code duplicated, block: B:172:0x05c8  */
                        /* JADX WARN: Code duplicated, block: B:175:0x05e8  */
                        /* JADX WARN: Code duplicated, block: B:177:0x05ee  */
                        /* JADX WARN: Code duplicated, block: B:180:0x060e  */
                        /* JADX WARN: Code duplicated, block: B:182:0x0614  */
                        /* JADX WARN: Code duplicated, block: B:185:0x0634  */
                        /* JADX WARN: Code duplicated, block: B:35:0x00a5 A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:193:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:37:0x00bb A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:193:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:39:0x00c5 A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:193:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:40:0x00da A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:193:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:42:0x00e4 A[Catch: Exception -> 0x00f9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00f9, blocks: (B:33:0x009b, B:35:0x00a5, B:37:0x00bb, B:39:0x00c5, B:40:0x00da, B:42:0x00e4), top: B:193:0x009b }] */
                        /* JADX WARN: Code duplicated, block: B:48:0x010b  */
                        /* JADX WARN: Code duplicated, block: B:49:0x010d  */
                        /* JADX WARN: Code duplicated, block: B:52:0x0118  */
                        /* JADX WARN: Code duplicated, block: B:54:0x0129  */
                        /* JADX WARN: Code duplicated, block: B:56:0x0133  */
                        /* JADX WARN: Code duplicated, block: B:58:0x0142  */
                        /* JADX WARN: Code duplicated, block: B:60:0x014c  */
                        /* JADX WARN: Code duplicated, block: B:62:0x0156  */
                        /* JADX WARN: Code duplicated, block: B:64:0x0160  */
                        /* JADX WARN: Code duplicated, block: B:65:0x0171  */
                        /* JADX WARN: Code duplicated, block: B:67:0x0183  */
                        /* JADX WARN: Code duplicated, block: B:70:0x0195  */
                        /* JADX WARN: Code duplicated, block: B:71:0x019a  */
                        /* JADX WARN: Code duplicated, block: B:83:0x02ad  */
                        /* JADX WARN: Code duplicated, block: B:87:0x02b9  */
                        /* JADX WARN: Code duplicated, block: B:90:0x02ed  */
                        /* JADX WARN: Code duplicated, block: B:94:0x02fe  */
                        /* JADX WARN: Code duplicated, block: B:97:0x0344  */
                        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
                        /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
                        public void submitForm7Overseas(String Token) {
                            String str;
                            String str2;
                            String str3;
                            String str4;
                            String str5;
                            String str6;
                            String str7;
                            String str8;
                            String str9;
                            Object obj;
                            boolean zIsChecked;
                            Object obj2;
                            String str10;
                            Object obj3;
                            Object obj4;
                            Object obj5;
                            Object obj6;
                            Object obj7;
                            Object obj8;
                            Object obj9;
                            String str11;
                            HashMap map;
                            String str12;
                            String strSubstring;
                            Object obj10;
                            String strReplace;
                            String str13;
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
                            String str14;
                            String string;
                            String str15;
                            String str16;
                            String str17;
                            this.alertDialog.show();
                            Logger.d(CHECKLISTFORM7OVERSEAS, "in Checklist submitForm7Overseas..............................");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                            String str18 = "";
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
                                                    Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
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
                                                        Logger.e(CHECKLISTFORM7OVERSEAS, e.getMessage());
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
                                                    if (this.binding.addressSame.isChecked()) {
                                                        obj = "Y";
                                                    } else {
                                                        obj = "N";
                                                    }
                                                    if (this.binding.notIndianCitizenRb.isChecked()) {
                                                        obj2 = OBJECTIONSTRING;
                                                        str10 = "NA";
                                                        obj6 = "Y";
                                                        obj3 = obj6;
                                                        obj4 = "N";
                                                        obj5 = obj4;
                                                        obj8 = obj5;
                                                    } else {
                                                        if (this.binding.absentRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            str10 = "NA";
                                                            obj5 = "Y";
                                                            obj3 = obj5;
                                                            obj4 = "N";
                                                            obj6 = obj4;
                                                        } else {
                                                            if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                str10 = "NA";
                                                                obj4 = "Y";
                                                                obj3 = obj4;
                                                                obj5 = "N";
                                                            } else {
                                                                if (this.binding.deadRb.isChecked()) {
                                                                    obj2 = OBJECTIONSTRING;
                                                                    str10 = "NA";
                                                                    obj3 = "Y";
                                                                    obj4 = "N";
                                                                    obj5 = obj4;
                                                                    obj6 = obj5;
                                                                    str18 = str18;
                                                                    str5 = str5;
                                                                    obj8 = obj3;
                                                                    obj7 = obj6;
                                                                } else {
                                                                    zIsChecked = this.binding.underageRb.isChecked();
                                                                    obj2 = OBJECTIONSTRING;
                                                                    str10 = "NA";
                                                                    obj3 = "Y";
                                                                    obj4 = "N";
                                                                    obj5 = obj4;
                                                                    if (zIsChecked) {
                                                                        obj6 = obj5;
                                                                        str18 = str18;
                                                                        str5 = str5;
                                                                        obj7 = obj3;
                                                                        obj8 = obj6;
                                                                    }
                                                                }
                                                                if (this.binding.detailsCorrect.isChecked()) {
                                                                    obj9 = obj3;
                                                                } else {
                                                                    obj9 = "N";
                                                                }
                                                                HashMap map2 = new HashMap();
                                                                String str19 = str7;
                                                                map2.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                                map2.put("fieldVerificationDataEntryErrors", "N");
                                                                map2.put("fieldVerificationAddress", obj);
                                                                map2.put("fieldVerificationDobOrAge", "N");
                                                                map2.put("fieldVerificationPhoto", "N");
                                                                map2.put("fieldVerificationAbsent", obj5);
                                                                map2.put("fieldVerificationDead", obj8);
                                                                map2.put("fieldVerificationNoSuchPerson", "N");
                                                                map2.put("fieldVerificationPersonPresent", "N");
                                                                map2.put("fieldVerificationShifted", "N");
                                                                map2.put("fieldVerificationAlreadyAppliedCount", 0);
                                                                map2.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                                map2.put("fieldVerificationUnderAge", obj7);
                                                                map2.put("fieldVerificationAlreadyEnrolled", obj4);
                                                                map2.put("fieldVerificationNotIndianCitizen", obj6);
                                                                map2.put("correctionOfAddress", "N");
                                                                map2.put("correctionOfDobAge", "N");
                                                                map2.put("correctionOfGender", "N");
                                                                map2.put("correctionOfMobile", "N");
                                                                map2.put("correctionOfName", "N");
                                                                map2.put("correctionOfPhotograpgh", "N");
                                                                map2.put("correctionOfRelation", "N");
                                                                map2.put("correctionOfRelative", "N");
                                                                str11 = null;
                                                                map2.put("fieldVerificationChecklist", null);
                                                                Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map2));
                                                                map = new HashMap();
                                                                map.put("applicantPlace", this.applicantPlace);
                                                                map.put("asemblyNo", this.asmblyNO);
                                                                map.put("createdBy", "operator");
                                                                map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                                map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                                if (!this.docref.isEmpty() || this.docref.equals("null")) {
                                                                    str12 = null;
                                                                } else {
                                                                    str12 = this.docref;
                                                                }
                                                                map.put("deathCertificateDln", str12);
                                                                map.put("deletionOfEpicNumberFor", str8);
                                                                map.put("deletionOfOther", str6);
                                                                map.put("deletionOfSelf", str19);
                                                                map.put("districtCode", this.districtCode);
                                                                map.put("emailApplicant", this.email);
                                                                map.put("epicid", this.epicId);
                                                                if (!this.districtCdOfPersonToBeDeleted.isEmpty() || this.districtCdOfPersonToBeDeleted.equals("null")) {
                                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                                } else {
                                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCdOfPersonToBeDeleted);
                                                                }
                                                                map.put("isSelfMobile", this.isSelfMobile);
                                                                map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                                map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                                map.put("firstNameApplicant", this.firstNameApplicant);
                                                                map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                                if (!this.formSubmissionChannel.equals("null") || this.formSubmissionChannel.isEmpty()) {
                                                                    map.put(this.formSubmissionChannelString, "GARUDA");
                                                                } else {
                                                                    map.put(this.formSubmissionChannelString, this.formSubmissionChannel);
                                                                }
                                                                if (!this.formSubmissionMode.equals("null") || this.formSubmissionMode.isEmpty()) {
                                                                    map.put(this.formSubmissionModeString, "ONLINE");
                                                                } else {
                                                                    map.put(this.formSubmissionModeString, this.formSubmissionMode);
                                                                }
                                                                map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                                if (!this.surname.equals(" ") && !this.surname.isEmpty()) {
                                                                    map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                                }
                                                                if (!this.lastNameApplicant.equals(" ") && !this.lastNameApplicant.isEmpty()) {
                                                                    map.put("lastnameApplicant", this.lastNameApplicant);
                                                                }
                                                                if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                                } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                                } else {
                                                                    strSubstring = null;
                                                                }
                                                                map.put(this.mobileNumberApplicantString, strSubstring);
                                                                obj10 = obj3;
                                                                if (this.isSelfMobile.equals(obj10)) {
                                                                    map.put(this.mobileNumberSelfString, strSubstring);
                                                                } else {
                                                                    map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                                }
                                                                if (this.request.equals(obj2)) {
                                                                    map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                                    map.put("objectToInclFormType", this.objectToInclFormType);
                                                                }
                                                                map.put("age", this.age);
                                                                map.put("gender", this.gender);
                                                                map.put("objectionOnInclusionOrDeletion", str5);
                                                                map.put("partNumberApplicant", this.partNumberApplicant);
                                                                map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                                map.put("serialNumberApplicant", this.serialNumber);
                                                                map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                                map.put("stateCode", this.stateCode);
                                                                map.put("sectionNoApplicant", this.sectionNo);
                                                                map.put("sectionNo", this.sectionNo);
                                                                map.put("isDraft", "N");
                                                                map.put(this.reasonForDeletionString, str18);
                                                                map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                                strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                                str13 = str10;
                                                                if (strReplace.equals(str13) || strReplace.isEmpty()) {
                                                                    strReplace = null;
                                                                }
                                                                map.put(this.townVillageString, strReplace);
                                                                strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace2.equals(str13) || strReplace2.isEmpty()) {
                                                                    strReplace2 = null;
                                                                }
                                                                map.put(this.tehsilTalukaMandalString, strReplace2);
                                                                strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace3.equals(str13) || strReplace3.isEmpty()) {
                                                                    strReplace3 = null;
                                                                }
                                                                map.put(this.postOfficeString, strReplace3);
                                                                strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace4.equals(str13) || strReplace4.isEmpty()) {
                                                                    strReplace4 = null;
                                                                }
                                                                map.put(this.localityStreetString, strReplace4);
                                                                strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace5.equals(str13) || strReplace5.isEmpty()) {
                                                                    strReplace5 = null;
                                                                }
                                                                map.put(this.houseNumberString, strReplace5);
                                                                strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace6.equals(str13) || strReplace6.isEmpty()) {
                                                                    strReplace6 = null;
                                                                }
                                                                map.put(this.pinCodeString, strReplace6);
                                                                map.put("pinCodeV1", strReplace6);
                                                                strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace7.equals("null") || strReplace7.isEmpty()) {
                                                                    strReplace7 = null;
                                                                }
                                                                map.put("houseNumberV1", strReplace7);
                                                                strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace8.equals("null") || strReplace8.isEmpty()) {
                                                                    strReplace8 = str13;
                                                                }
                                                                map.put("localityStreetV1", strReplace8);
                                                                strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace9.equals("null") || strReplace9.isEmpty()) {
                                                                    strReplace9 = null;
                                                                }
                                                                map.put("postOfficeV1", strReplace9);
                                                                strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                                if (strReplace10.equals("null") || strReplace10.isEmpty()) {
                                                                    strReplace10 = str13;
                                                                }
                                                                map.put("tehsilTalukaMandalV1", strReplace10);
                                                                strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                                if (!strReplace11.equals("null") && !strReplace11.isEmpty()) {
                                                                    str11 = strReplace11;
                                                                }
                                                                map.put("townVillageV1", str11);
                                                                map.put("form7OId", this.id);
                                                                map.put("isReinitiate", obj10);
                                                                Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                                this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map2));
                                                            }
                                                            obj6 = obj5;
                                                        }
                                                        obj8 = obj6;
                                                    }
                                                    obj7 = obj8;
                                                    if (this.binding.detailsCorrect.isChecked()) {
                                                        obj9 = obj3;
                                                    } else {
                                                        obj9 = "N";
                                                    }
                                                    HashMap map3 = new HashMap();
                                                    String str110 = str7;
                                                    map3.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                    map3.put("fieldVerificationDataEntryErrors", "N");
                                                    map3.put("fieldVerificationAddress", obj);
                                                    map3.put("fieldVerificationDobOrAge", "N");
                                                    map3.put("fieldVerificationPhoto", "N");
                                                    map3.put("fieldVerificationAbsent", obj5);
                                                    map3.put("fieldVerificationDead", obj8);
                                                    map3.put("fieldVerificationNoSuchPerson", "N");
                                                    map3.put("fieldVerificationPersonPresent", "N");
                                                    map3.put("fieldVerificationShifted", "N");
                                                    map3.put("fieldVerificationAlreadyAppliedCount", 0);
                                                    map3.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                    map3.put("fieldVerificationUnderAge", obj7);
                                                    map3.put("fieldVerificationAlreadyEnrolled", obj4);
                                                    map3.put("fieldVerificationNotIndianCitizen", obj6);
                                                    map3.put("correctionOfAddress", "N");
                                                    map3.put("correctionOfDobAge", "N");
                                                    map3.put("correctionOfGender", "N");
                                                    map3.put("correctionOfMobile", "N");
                                                    map3.put("correctionOfName", "N");
                                                    map3.put("correctionOfPhotograpgh", "N");
                                                    map3.put("correctionOfRelation", "N");
                                                    map3.put("correctionOfRelative", "N");
                                                    str11 = null;
                                                    map3.put("fieldVerificationChecklist", null);
                                                    Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map3));
                                                    map = new HashMap();
                                                    map.put("applicantPlace", this.applicantPlace);
                                                    map.put("asemblyNo", this.asmblyNO);
                                                    map.put("createdBy", "operator");
                                                    map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                    map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                    if (this.docref.isEmpty()) {
                                                        str12 = null;
                                                    } else {
                                                        str12 = null;
                                                    }
                                                    map.put("deathCertificateDln", str12);
                                                    map.put("deletionOfEpicNumberFor", str8);
                                                    map.put("deletionOfOther", str6);
                                                    map.put("deletionOfSelf", str110);
                                                    map.put("districtCode", this.districtCode);
                                                    map.put("emailApplicant", this.email);
                                                    map.put("epicid", this.epicId);
                                                    if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                        map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                    } else {
                                                        map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                    }
                                                    map.put("isSelfMobile", this.isSelfMobile);
                                                    map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                    map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                    map.put("firstNameApplicant", this.firstNameApplicant);
                                                    map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                    if (!this.formSubmissionChannel.equals("null")) {
                                                        map.put(this.formSubmissionChannelString, "GARUDA");
                                                    } else {
                                                        map.put(this.formSubmissionChannelString, "GARUDA");
                                                    }
                                                    if (!this.formSubmissionMode.equals("null")) {
                                                        map.put(this.formSubmissionModeString, "ONLINE");
                                                    } else {
                                                        map.put(this.formSubmissionModeString, "ONLINE");
                                                    }
                                                    map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                    if (!this.surname.equals(" ")) {
                                                        map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                    }
                                                    if (!this.lastNameApplicant.equals(" ")) {
                                                        map.put("lastnameApplicant", this.lastNameApplicant);
                                                    }
                                                    if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                        strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                    } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                        strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                    } else {
                                                        strSubstring = null;
                                                    }
                                                    map.put(this.mobileNumberApplicantString, strSubstring);
                                                    obj10 = obj3;
                                                    if (this.isSelfMobile.equals(obj10)) {
                                                        map.put(this.mobileNumberSelfString, strSubstring);
                                                    } else {
                                                        map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                    }
                                                    if (this.request.equals(obj2)) {
                                                        map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                        map.put("objectToInclFormType", this.objectToInclFormType);
                                                    }
                                                    map.put("age", this.age);
                                                    map.put("gender", this.gender);
                                                    map.put("objectionOnInclusionOrDeletion", str5);
                                                    map.put("partNumberApplicant", this.partNumberApplicant);
                                                    map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                    map.put("serialNumberApplicant", this.serialNumber);
                                                    map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                    map.put("stateCode", this.stateCode);
                                                    map.put("sectionNoApplicant", this.sectionNo);
                                                    map.put("sectionNo", this.sectionNo);
                                                    map.put("isDraft", "N");
                                                    map.put(this.reasonForDeletionString, str18);
                                                    map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                    strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                    str13 = str10;
                                                    if (strReplace.equals(str13)) {
                                                        strReplace = null;
                                                    } else {
                                                        strReplace = null;
                                                    }
                                                    map.put(this.townVillageString, strReplace);
                                                    strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace2.equals(str13)) {
                                                        strReplace2 = null;
                                                    } else {
                                                        strReplace2 = null;
                                                    }
                                                    map.put(this.tehsilTalukaMandalString, strReplace2);
                                                    strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace3.equals(str13)) {
                                                        strReplace3 = null;
                                                    } else {
                                                        strReplace3 = null;
                                                    }
                                                    map.put(this.postOfficeString, strReplace3);
                                                    strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace4.equals(str13)) {
                                                        strReplace4 = null;
                                                    } else {
                                                        strReplace4 = null;
                                                    }
                                                    map.put(this.localityStreetString, strReplace4);
                                                    strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace5.equals(str13)) {
                                                        strReplace5 = null;
                                                    } else {
                                                        strReplace5 = null;
                                                    }
                                                    map.put(this.houseNumberString, strReplace5);
                                                    strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace6.equals(str13)) {
                                                        strReplace6 = null;
                                                    } else {
                                                        strReplace6 = null;
                                                    }
                                                    map.put(this.pinCodeString, strReplace6);
                                                    map.put("pinCodeV1", strReplace6);
                                                    strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace7.equals("null")) {
                                                        strReplace7 = null;
                                                    } else {
                                                        strReplace7 = null;
                                                    }
                                                    map.put("houseNumberV1", strReplace7);
                                                    strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace8.equals("null")) {
                                                        strReplace8 = str13;
                                                    } else {
                                                        strReplace8 = str13;
                                                    }
                                                    map.put("localityStreetV1", strReplace8);
                                                    strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace9.equals("null")) {
                                                        strReplace9 = null;
                                                    } else {
                                                        strReplace9 = null;
                                                    }
                                                    map.put("postOfficeV1", strReplace9);
                                                    strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                    if (strReplace10.equals("null")) {
                                                        strReplace10 = str13;
                                                    } else {
                                                        strReplace10 = str13;
                                                    }
                                                    map.put("tehsilTalukaMandalV1", strReplace10);
                                                    strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                    if (!strReplace11.equals("null")) {
                                                        str11 = strReplace11;
                                                    }
                                                    map.put("townVillageV1", str11);
                                                    map.put("form7OId", this.id);
                                                    map.put("isReinitiate", obj10);
                                                    Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                    this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map3));
                                                }
                                                str18 = str14;
                                                if (this.binding.addressSame.isChecked()) {
                                                    obj = "Y";
                                                } else {
                                                    obj = "N";
                                                }
                                                if (this.binding.notIndianCitizenRb.isChecked()) {
                                                    obj2 = OBJECTIONSTRING;
                                                    str10 = "NA";
                                                    obj6 = "Y";
                                                    obj3 = obj6;
                                                    obj4 = "N";
                                                    obj5 = obj4;
                                                    obj8 = obj5;
                                                } else {
                                                    if (this.binding.absentRb.isChecked()) {
                                                        obj2 = OBJECTIONSTRING;
                                                        str10 = "NA";
                                                        obj5 = "Y";
                                                        obj3 = obj5;
                                                        obj4 = "N";
                                                        obj6 = obj4;
                                                    } else {
                                                        if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            str10 = "NA";
                                                            obj4 = "Y";
                                                            obj3 = obj4;
                                                            obj5 = "N";
                                                        } else {
                                                            if (this.binding.deadRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                str10 = "NA";
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                                obj5 = obj4;
                                                                obj6 = obj5;
                                                                str18 = str18;
                                                                str5 = str5;
                                                                obj8 = obj3;
                                                                obj7 = obj6;
                                                            } else {
                                                                zIsChecked = this.binding.underageRb.isChecked();
                                                                obj2 = OBJECTIONSTRING;
                                                                str10 = "NA";
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                                obj5 = obj4;
                                                                if (zIsChecked) {
                                                                    obj6 = obj5;
                                                                    str18 = str18;
                                                                    str5 = str5;
                                                                    obj7 = obj3;
                                                                    obj8 = obj6;
                                                                }
                                                            }
                                                            if (this.binding.detailsCorrect.isChecked()) {
                                                                obj9 = obj3;
                                                            } else {
                                                                obj9 = "N";
                                                            }
                                                            HashMap map4 = new HashMap();
                                                            String str111 = str7;
                                                            map4.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                            map4.put("fieldVerificationDataEntryErrors", "N");
                                                            map4.put("fieldVerificationAddress", obj);
                                                            map4.put("fieldVerificationDobOrAge", "N");
                                                            map4.put("fieldVerificationPhoto", "N");
                                                            map4.put("fieldVerificationAbsent", obj5);
                                                            map4.put("fieldVerificationDead", obj8);
                                                            map4.put("fieldVerificationNoSuchPerson", "N");
                                                            map4.put("fieldVerificationPersonPresent", "N");
                                                            map4.put("fieldVerificationShifted", "N");
                                                            map4.put("fieldVerificationAlreadyAppliedCount", 0);
                                                            map4.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                            map4.put("fieldVerificationUnderAge", obj7);
                                                            map4.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map4.put("fieldVerificationNotIndianCitizen", obj6);
                                                            map4.put("correctionOfAddress", "N");
                                                            map4.put("correctionOfDobAge", "N");
                                                            map4.put("correctionOfGender", "N");
                                                            map4.put("correctionOfMobile", "N");
                                                            map4.put("correctionOfName", "N");
                                                            map4.put("correctionOfPhotograpgh", "N");
                                                            map4.put("correctionOfRelation", "N");
                                                            map4.put("correctionOfRelative", "N");
                                                            str11 = null;
                                                            map4.put("fieldVerificationChecklist", null);
                                                            Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map4));
                                                            map = new HashMap();
                                                            map.put("applicantPlace", this.applicantPlace);
                                                            map.put("asemblyNo", this.asmblyNO);
                                                            map.put("createdBy", "operator");
                                                            map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                            map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                            if (this.docref.isEmpty()) {
                                                                str12 = null;
                                                            } else {
                                                                str12 = null;
                                                            }
                                                            map.put("deathCertificateDln", str12);
                                                            map.put("deletionOfEpicNumberFor", str8);
                                                            map.put("deletionOfOther", str6);
                                                            map.put("deletionOfSelf", str111);
                                                            map.put("districtCode", this.districtCode);
                                                            map.put("emailApplicant", this.email);
                                                            map.put("epicid", this.epicId);
                                                            if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                            } else {
                                                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                            }
                                                            map.put("isSelfMobile", this.isSelfMobile);
                                                            map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                            map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                            map.put("firstNameApplicant", this.firstNameApplicant);
                                                            map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                            if (!this.formSubmissionChannel.equals("null")) {
                                                                map.put(this.formSubmissionChannelString, "GARUDA");
                                                            } else {
                                                                map.put(this.formSubmissionChannelString, "GARUDA");
                                                            }
                                                            if (!this.formSubmissionMode.equals("null")) {
                                                                map.put(this.formSubmissionModeString, "ONLINE");
                                                            } else {
                                                                map.put(this.formSubmissionModeString, "ONLINE");
                                                            }
                                                            map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                            if (!this.surname.equals(" ")) {
                                                                map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                            }
                                                            if (!this.lastNameApplicant.equals(" ")) {
                                                                map.put("lastnameApplicant", this.lastNameApplicant);
                                                            }
                                                            if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                            } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                            } else {
                                                                strSubstring = null;
                                                            }
                                                            map.put(this.mobileNumberApplicantString, strSubstring);
                                                            obj10 = obj3;
                                                            if (this.isSelfMobile.equals(obj10)) {
                                                                map.put(this.mobileNumberSelfString, strSubstring);
                                                            } else {
                                                                map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                            }
                                                            if (this.request.equals(obj2)) {
                                                                map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                                map.put("objectToInclFormType", this.objectToInclFormType);
                                                            }
                                                            map.put("age", this.age);
                                                            map.put("gender", this.gender);
                                                            map.put("objectionOnInclusionOrDeletion", str5);
                                                            map.put("partNumberApplicant", this.partNumberApplicant);
                                                            map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                            map.put("serialNumberApplicant", this.serialNumber);
                                                            map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                            map.put("stateCode", this.stateCode);
                                                            map.put("sectionNoApplicant", this.sectionNo);
                                                            map.put("sectionNo", this.sectionNo);
                                                            map.put("isDraft", "N");
                                                            map.put(this.reasonForDeletionString, str18);
                                                            map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                            str13 = str10;
                                                            if (strReplace.equals(str13)) {
                                                                strReplace = null;
                                                            } else {
                                                                strReplace = null;
                                                            }
                                                            map.put(this.townVillageString, strReplace);
                                                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace2.equals(str13)) {
                                                                strReplace2 = null;
                                                            } else {
                                                                strReplace2 = null;
                                                            }
                                                            map.put(this.tehsilTalukaMandalString, strReplace2);
                                                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace3.equals(str13)) {
                                                                strReplace3 = null;
                                                            } else {
                                                                strReplace3 = null;
                                                            }
                                                            map.put(this.postOfficeString, strReplace3);
                                                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace4.equals(str13)) {
                                                                strReplace4 = null;
                                                            } else {
                                                                strReplace4 = null;
                                                            }
                                                            map.put(this.localityStreetString, strReplace4);
                                                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace5.equals(str13)) {
                                                                strReplace5 = null;
                                                            } else {
                                                                strReplace5 = null;
                                                            }
                                                            map.put(this.houseNumberString, strReplace5);
                                                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace6.equals(str13)) {
                                                                strReplace6 = null;
                                                            } else {
                                                                strReplace6 = null;
                                                            }
                                                            map.put(this.pinCodeString, strReplace6);
                                                            map.put("pinCodeV1", strReplace6);
                                                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace7.equals("null")) {
                                                                strReplace7 = null;
                                                            } else {
                                                                strReplace7 = null;
                                                            }
                                                            map.put("houseNumberV1", strReplace7);
                                                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace8.equals("null")) {
                                                                strReplace8 = str13;
                                                            } else {
                                                                strReplace8 = str13;
                                                            }
                                                            map.put("localityStreetV1", strReplace8);
                                                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace9.equals("null")) {
                                                                strReplace9 = null;
                                                            } else {
                                                                strReplace9 = null;
                                                            }
                                                            map.put("postOfficeV1", strReplace9);
                                                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace10.equals("null")) {
                                                                strReplace10 = str13;
                                                            } else {
                                                                strReplace10 = str13;
                                                            }
                                                            map.put("tehsilTalukaMandalV1", strReplace10);
                                                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (!strReplace11.equals("null")) {
                                                                str11 = strReplace11;
                                                            }
                                                            map.put("townVillageV1", str11);
                                                            map.put("form7OId", this.id);
                                                            map.put("isReinitiate", obj10);
                                                            Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map4));
                                                        }
                                                        obj6 = obj5;
                                                    }
                                                    obj8 = obj6;
                                                }
                                                obj7 = obj8;
                                                if (this.binding.detailsCorrect.isChecked()) {
                                                    obj9 = obj3;
                                                } else {
                                                    obj9 = "N";
                                                }
                                                HashMap map5 = new HashMap();
                                                String str112 = str7;
                                                map5.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                map5.put("fieldVerificationDataEntryErrors", "N");
                                                map5.put("fieldVerificationAddress", obj);
                                                map5.put("fieldVerificationDobOrAge", "N");
                                                map5.put("fieldVerificationPhoto", "N");
                                                map5.put("fieldVerificationAbsent", obj5);
                                                map5.put("fieldVerificationDead", obj8);
                                                map5.put("fieldVerificationNoSuchPerson", "N");
                                                map5.put("fieldVerificationPersonPresent", "N");
                                                map5.put("fieldVerificationShifted", "N");
                                                map5.put("fieldVerificationAlreadyAppliedCount", 0);
                                                map5.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                map5.put("fieldVerificationUnderAge", obj7);
                                                map5.put("fieldVerificationAlreadyEnrolled", obj4);
                                                map5.put("fieldVerificationNotIndianCitizen", obj6);
                                                map5.put("correctionOfAddress", "N");
                                                map5.put("correctionOfDobAge", "N");
                                                map5.put("correctionOfGender", "N");
                                                map5.put("correctionOfMobile", "N");
                                                map5.put("correctionOfName", "N");
                                                map5.put("correctionOfPhotograpgh", "N");
                                                map5.put("correctionOfRelation", "N");
                                                map5.put("correctionOfRelative", "N");
                                                str11 = null;
                                                map5.put("fieldVerificationChecklist", null);
                                                Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map5));
                                                map = new HashMap();
                                                map.put("applicantPlace", this.applicantPlace);
                                                map.put("asemblyNo", this.asmblyNO);
                                                map.put("createdBy", "operator");
                                                map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                if (this.docref.isEmpty()) {
                                                    str12 = null;
                                                } else {
                                                    str12 = null;
                                                }
                                                map.put("deathCertificateDln", str12);
                                                map.put("deletionOfEpicNumberFor", str8);
                                                map.put("deletionOfOther", str6);
                                                map.put("deletionOfSelf", str112);
                                                map.put("districtCode", this.districtCode);
                                                map.put("emailApplicant", this.email);
                                                map.put("epicid", this.epicId);
                                                if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                } else {
                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                }
                                                map.put("isSelfMobile", this.isSelfMobile);
                                                map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                map.put("firstNameApplicant", this.firstNameApplicant);
                                                map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                if (!this.formSubmissionChannel.equals("null")) {
                                                    map.put(this.formSubmissionChannelString, "GARUDA");
                                                } else {
                                                    map.put(this.formSubmissionChannelString, "GARUDA");
                                                }
                                                if (!this.formSubmissionMode.equals("null")) {
                                                    map.put(this.formSubmissionModeString, "ONLINE");
                                                } else {
                                                    map.put(this.formSubmissionModeString, "ONLINE");
                                                }
                                                map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                if (!this.surname.equals(" ")) {
                                                    map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                }
                                                if (!this.lastNameApplicant.equals(" ")) {
                                                    map.put("lastnameApplicant", this.lastNameApplicant);
                                                }
                                                if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                } else {
                                                    strSubstring = null;
                                                }
                                                map.put(this.mobileNumberApplicantString, strSubstring);
                                                obj10 = obj3;
                                                if (this.isSelfMobile.equals(obj10)) {
                                                    map.put(this.mobileNumberSelfString, strSubstring);
                                                } else {
                                                    map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                }
                                                if (this.request.equals(obj2)) {
                                                    map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                    map.put("objectToInclFormType", this.objectToInclFormType);
                                                }
                                                map.put("age", this.age);
                                                map.put("gender", this.gender);
                                                map.put("objectionOnInclusionOrDeletion", str5);
                                                map.put("partNumberApplicant", this.partNumberApplicant);
                                                map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                map.put("serialNumberApplicant", this.serialNumber);
                                                map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                map.put("stateCode", this.stateCode);
                                                map.put("sectionNoApplicant", this.sectionNo);
                                                map.put("sectionNo", this.sectionNo);
                                                map.put("isDraft", "N");
                                                map.put(this.reasonForDeletionString, str18);
                                                map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                str13 = str10;
                                                if (strReplace.equals(str13)) {
                                                    strReplace = null;
                                                } else {
                                                    strReplace = null;
                                                }
                                                map.put(this.townVillageString, strReplace);
                                                strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace2.equals(str13)) {
                                                    strReplace2 = null;
                                                } else {
                                                    strReplace2 = null;
                                                }
                                                map.put(this.tehsilTalukaMandalString, strReplace2);
                                                strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace3.equals(str13)) {
                                                    strReplace3 = null;
                                                } else {
                                                    strReplace3 = null;
                                                }
                                                map.put(this.postOfficeString, strReplace3);
                                                strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace4.equals(str13)) {
                                                    strReplace4 = null;
                                                } else {
                                                    strReplace4 = null;
                                                }
                                                map.put(this.localityStreetString, strReplace4);
                                                strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace5.equals(str13)) {
                                                    strReplace5 = null;
                                                } else {
                                                    strReplace5 = null;
                                                }
                                                map.put(this.houseNumberString, strReplace5);
                                                strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace6.equals(str13)) {
                                                    strReplace6 = null;
                                                } else {
                                                    strReplace6 = null;
                                                }
                                                map.put(this.pinCodeString, strReplace6);
                                                map.put("pinCodeV1", strReplace6);
                                                strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace7.equals("null")) {
                                                    strReplace7 = null;
                                                } else {
                                                    strReplace7 = null;
                                                }
                                                map.put("houseNumberV1", strReplace7);
                                                strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace8.equals("null")) {
                                                    strReplace8 = str13;
                                                } else {
                                                    strReplace8 = str13;
                                                }
                                                map.put("localityStreetV1", strReplace8);
                                                strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace9.equals("null")) {
                                                    strReplace9 = null;
                                                } else {
                                                    strReplace9 = null;
                                                }
                                                map.put("postOfficeV1", strReplace9);
                                                strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace10.equals("null")) {
                                                    strReplace10 = str13;
                                                } else {
                                                    strReplace10 = str13;
                                                }
                                                map.put("tehsilTalukaMandalV1", strReplace10);
                                                strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (!strReplace11.equals("null")) {
                                                    str11 = strReplace11;
                                                }
                                                map.put("townVillageV1", str11);
                                                map.put("form7OId", this.id);
                                                map.put("isReinitiate", obj10);
                                                Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map5));
                                            }
                                            if (this.binding.optionRb1.isChecked()) {
                                                str14 = this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString());
                                            } else if (this.binding.optionRb2.isChecked()) {
                                                str14 = this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString());
                                            } else {
                                                if (this.binding.optionRb3.isChecked()) {
                                                    str14 = this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString());
                                                }
                                                if (this.binding.addressSame.isChecked()) {
                                                    obj = "Y";
                                                } else {
                                                    obj = "N";
                                                }
                                                if (this.binding.notIndianCitizenRb.isChecked()) {
                                                    obj2 = OBJECTIONSTRING;
                                                    str10 = "NA";
                                                    obj6 = "Y";
                                                    obj3 = obj6;
                                                    obj4 = "N";
                                                    obj5 = obj4;
                                                    obj8 = obj5;
                                                } else {
                                                    if (this.binding.absentRb.isChecked()) {
                                                        obj2 = OBJECTIONSTRING;
                                                        str10 = "NA";
                                                        obj5 = "Y";
                                                        obj3 = obj5;
                                                        obj4 = "N";
                                                        obj6 = obj4;
                                                    } else {
                                                        if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            str10 = "NA";
                                                            obj4 = "Y";
                                                            obj3 = obj4;
                                                            obj5 = "N";
                                                        } else {
                                                            if (this.binding.deadRb.isChecked()) {
                                                                obj2 = OBJECTIONSTRING;
                                                                str10 = "NA";
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                                obj5 = obj4;
                                                                obj6 = obj5;
                                                                str18 = str18;
                                                                str5 = str5;
                                                                obj8 = obj3;
                                                                obj7 = obj6;
                                                            } else {
                                                                zIsChecked = this.binding.underageRb.isChecked();
                                                                obj2 = OBJECTIONSTRING;
                                                                str10 = "NA";
                                                                obj3 = "Y";
                                                                obj4 = "N";
                                                                obj5 = obj4;
                                                                if (zIsChecked) {
                                                                    obj6 = obj5;
                                                                    str18 = str18;
                                                                    str5 = str5;
                                                                    obj7 = obj3;
                                                                    obj8 = obj6;
                                                                }
                                                            }
                                                            if (this.binding.detailsCorrect.isChecked()) {
                                                                obj9 = obj3;
                                                            } else {
                                                                obj9 = "N";
                                                            }
                                                            HashMap map6 = new HashMap();
                                                            String str113 = str7;
                                                            map6.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                            map6.put("fieldVerificationDataEntryErrors", "N");
                                                            map6.put("fieldVerificationAddress", obj);
                                                            map6.put("fieldVerificationDobOrAge", "N");
                                                            map6.put("fieldVerificationPhoto", "N");
                                                            map6.put("fieldVerificationAbsent", obj5);
                                                            map6.put("fieldVerificationDead", obj8);
                                                            map6.put("fieldVerificationNoSuchPerson", "N");
                                                            map6.put("fieldVerificationPersonPresent", "N");
                                                            map6.put("fieldVerificationShifted", "N");
                                                            map6.put("fieldVerificationAlreadyAppliedCount", 0);
                                                            map6.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                            map6.put("fieldVerificationUnderAge", obj7);
                                                            map6.put("fieldVerificationAlreadyEnrolled", obj4);
                                                            map6.put("fieldVerificationNotIndianCitizen", obj6);
                                                            map6.put("correctionOfAddress", "N");
                                                            map6.put("correctionOfDobAge", "N");
                                                            map6.put("correctionOfGender", "N");
                                                            map6.put("correctionOfMobile", "N");
                                                            map6.put("correctionOfName", "N");
                                                            map6.put("correctionOfPhotograpgh", "N");
                                                            map6.put("correctionOfRelation", "N");
                                                            map6.put("correctionOfRelative", "N");
                                                            str11 = null;
                                                            map6.put("fieldVerificationChecklist", null);
                                                            Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map6));
                                                            map = new HashMap();
                                                            map.put("applicantPlace", this.applicantPlace);
                                                            map.put("asemblyNo", this.asmblyNO);
                                                            map.put("createdBy", "operator");
                                                            map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                            map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                            if (this.docref.isEmpty()) {
                                                                str12 = null;
                                                            } else {
                                                                str12 = null;
                                                            }
                                                            map.put("deathCertificateDln", str12);
                                                            map.put("deletionOfEpicNumberFor", str8);
                                                            map.put("deletionOfOther", str6);
                                                            map.put("deletionOfSelf", str113);
                                                            map.put("districtCode", this.districtCode);
                                                            map.put("emailApplicant", this.email);
                                                            map.put("epicid", this.epicId);
                                                            if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                            } else {
                                                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                            }
                                                            map.put("isSelfMobile", this.isSelfMobile);
                                                            map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                            map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                            map.put("firstNameApplicant", this.firstNameApplicant);
                                                            map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                            if (!this.formSubmissionChannel.equals("null")) {
                                                                map.put(this.formSubmissionChannelString, "GARUDA");
                                                            } else {
                                                                map.put(this.formSubmissionChannelString, "GARUDA");
                                                            }
                                                            if (!this.formSubmissionMode.equals("null")) {
                                                                map.put(this.formSubmissionModeString, "ONLINE");
                                                            } else {
                                                                map.put(this.formSubmissionModeString, "ONLINE");
                                                            }
                                                            map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                            if (!this.surname.equals(" ")) {
                                                                map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                            }
                                                            if (!this.lastNameApplicant.equals(" ")) {
                                                                map.put("lastnameApplicant", this.lastNameApplicant);
                                                            }
                                                            if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                            } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                            } else {
                                                                strSubstring = null;
                                                            }
                                                            map.put(this.mobileNumberApplicantString, strSubstring);
                                                            obj10 = obj3;
                                                            if (this.isSelfMobile.equals(obj10)) {
                                                                map.put(this.mobileNumberSelfString, strSubstring);
                                                            } else {
                                                                map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                            }
                                                            if (this.request.equals(obj2)) {
                                                                map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                                map.put("objectToInclFormType", this.objectToInclFormType);
                                                            }
                                                            map.put("age", this.age);
                                                            map.put("gender", this.gender);
                                                            map.put("objectionOnInclusionOrDeletion", str5);
                                                            map.put("partNumberApplicant", this.partNumberApplicant);
                                                            map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                            map.put("serialNumberApplicant", this.serialNumber);
                                                            map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                            map.put("stateCode", this.stateCode);
                                                            map.put("sectionNoApplicant", this.sectionNo);
                                                            map.put("sectionNo", this.sectionNo);
                                                            map.put("isDraft", "N");
                                                            map.put(this.reasonForDeletionString, str18);
                                                            map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                            str13 = str10;
                                                            if (strReplace.equals(str13)) {
                                                                strReplace = null;
                                                            } else {
                                                                strReplace = null;
                                                            }
                                                            map.put(this.townVillageString, strReplace);
                                                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace2.equals(str13)) {
                                                                strReplace2 = null;
                                                            } else {
                                                                strReplace2 = null;
                                                            }
                                                            map.put(this.tehsilTalukaMandalString, strReplace2);
                                                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace3.equals(str13)) {
                                                                strReplace3 = null;
                                                            } else {
                                                                strReplace3 = null;
                                                            }
                                                            map.put(this.postOfficeString, strReplace3);
                                                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace4.equals(str13)) {
                                                                strReplace4 = null;
                                                            } else {
                                                                strReplace4 = null;
                                                            }
                                                            map.put(this.localityStreetString, strReplace4);
                                                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace5.equals(str13)) {
                                                                strReplace5 = null;
                                                            } else {
                                                                strReplace5 = null;
                                                            }
                                                            map.put(this.houseNumberString, strReplace5);
                                                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace6.equals(str13)) {
                                                                strReplace6 = null;
                                                            } else {
                                                                strReplace6 = null;
                                                            }
                                                            map.put(this.pinCodeString, strReplace6);
                                                            map.put("pinCodeV1", strReplace6);
                                                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace7.equals("null")) {
                                                                strReplace7 = null;
                                                            } else {
                                                                strReplace7 = null;
                                                            }
                                                            map.put("houseNumberV1", strReplace7);
                                                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace8.equals("null")) {
                                                                strReplace8 = str13;
                                                            } else {
                                                                strReplace8 = str13;
                                                            }
                                                            map.put("localityStreetV1", strReplace8);
                                                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace9.equals("null")) {
                                                                strReplace9 = null;
                                                            } else {
                                                                strReplace9 = null;
                                                            }
                                                            map.put("postOfficeV1", strReplace9);
                                                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (strReplace10.equals("null")) {
                                                                strReplace10 = str13;
                                                            } else {
                                                                strReplace10 = str13;
                                                            }
                                                            map.put("tehsilTalukaMandalV1", strReplace10);
                                                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                            if (!strReplace11.equals("null")) {
                                                                str11 = strReplace11;
                                                            }
                                                            map.put("townVillageV1", str11);
                                                            map.put("form7OId", this.id);
                                                            map.put("isReinitiate", obj10);
                                                            Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map6));
                                                        }
                                                        obj6 = obj5;
                                                    }
                                                    obj8 = obj6;
                                                }
                                                obj7 = obj8;
                                                if (this.binding.detailsCorrect.isChecked()) {
                                                    obj9 = obj3;
                                                } else {
                                                    obj9 = "N";
                                                }
                                                HashMap map7 = new HashMap();
                                                String str114 = str7;
                                                map7.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                map7.put("fieldVerificationDataEntryErrors", "N");
                                                map7.put("fieldVerificationAddress", obj);
                                                map7.put("fieldVerificationDobOrAge", "N");
                                                map7.put("fieldVerificationPhoto", "N");
                                                map7.put("fieldVerificationAbsent", obj5);
                                                map7.put("fieldVerificationDead", obj8);
                                                map7.put("fieldVerificationNoSuchPerson", "N");
                                                map7.put("fieldVerificationPersonPresent", "N");
                                                map7.put("fieldVerificationShifted", "N");
                                                map7.put("fieldVerificationAlreadyAppliedCount", 0);
                                                map7.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                map7.put("fieldVerificationUnderAge", obj7);
                                                map7.put("fieldVerificationAlreadyEnrolled", obj4);
                                                map7.put("fieldVerificationNotIndianCitizen", obj6);
                                                map7.put("correctionOfAddress", "N");
                                                map7.put("correctionOfDobAge", "N");
                                                map7.put("correctionOfGender", "N");
                                                map7.put("correctionOfMobile", "N");
                                                map7.put("correctionOfName", "N");
                                                map7.put("correctionOfPhotograpgh", "N");
                                                map7.put("correctionOfRelation", "N");
                                                map7.put("correctionOfRelative", "N");
                                                str11 = null;
                                                map7.put("fieldVerificationChecklist", null);
                                                Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map7));
                                                map = new HashMap();
                                                map.put("applicantPlace", this.applicantPlace);
                                                map.put("asemblyNo", this.asmblyNO);
                                                map.put("createdBy", "operator");
                                                map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                if (this.docref.isEmpty()) {
                                                    str12 = null;
                                                } else {
                                                    str12 = null;
                                                }
                                                map.put("deathCertificateDln", str12);
                                                map.put("deletionOfEpicNumberFor", str8);
                                                map.put("deletionOfOther", str6);
                                                map.put("deletionOfSelf", str114);
                                                map.put("districtCode", this.districtCode);
                                                map.put("emailApplicant", this.email);
                                                map.put("epicid", this.epicId);
                                                if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                } else {
                                                    map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                }
                                                map.put("isSelfMobile", this.isSelfMobile);
                                                map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                map.put("firstNameApplicant", this.firstNameApplicant);
                                                map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                if (!this.formSubmissionChannel.equals("null")) {
                                                    map.put(this.formSubmissionChannelString, "GARUDA");
                                                } else {
                                                    map.put(this.formSubmissionChannelString, "GARUDA");
                                                }
                                                if (!this.formSubmissionMode.equals("null")) {
                                                    map.put(this.formSubmissionModeString, "ONLINE");
                                                } else {
                                                    map.put(this.formSubmissionModeString, "ONLINE");
                                                }
                                                map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                if (!this.surname.equals(" ")) {
                                                    map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                }
                                                if (!this.lastNameApplicant.equals(" ")) {
                                                    map.put("lastnameApplicant", this.lastNameApplicant);
                                                }
                                                if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                    strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                } else {
                                                    strSubstring = null;
                                                }
                                                map.put(this.mobileNumberApplicantString, strSubstring);
                                                obj10 = obj3;
                                                if (this.isSelfMobile.equals(obj10)) {
                                                    map.put(this.mobileNumberSelfString, strSubstring);
                                                } else {
                                                    map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                }
                                                if (this.request.equals(obj2)) {
                                                    map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                    map.put("objectToInclFormType", this.objectToInclFormType);
                                                }
                                                map.put("age", this.age);
                                                map.put("gender", this.gender);
                                                map.put("objectionOnInclusionOrDeletion", str5);
                                                map.put("partNumberApplicant", this.partNumberApplicant);
                                                map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                map.put("serialNumberApplicant", this.serialNumber);
                                                map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                map.put("stateCode", this.stateCode);
                                                map.put("sectionNoApplicant", this.sectionNo);
                                                map.put("sectionNo", this.sectionNo);
                                                map.put("isDraft", "N");
                                                map.put(this.reasonForDeletionString, str18);
                                                map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                str13 = str10;
                                                if (strReplace.equals(str13)) {
                                                    strReplace = null;
                                                } else {
                                                    strReplace = null;
                                                }
                                                map.put(this.townVillageString, strReplace);
                                                strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace2.equals(str13)) {
                                                    strReplace2 = null;
                                                } else {
                                                    strReplace2 = null;
                                                }
                                                map.put(this.tehsilTalukaMandalString, strReplace2);
                                                strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace3.equals(str13)) {
                                                    strReplace3 = null;
                                                } else {
                                                    strReplace3 = null;
                                                }
                                                map.put(this.postOfficeString, strReplace3);
                                                strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace4.equals(str13)) {
                                                    strReplace4 = null;
                                                } else {
                                                    strReplace4 = null;
                                                }
                                                map.put(this.localityStreetString, strReplace4);
                                                strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace5.equals(str13)) {
                                                    strReplace5 = null;
                                                } else {
                                                    strReplace5 = null;
                                                }
                                                map.put(this.houseNumberString, strReplace5);
                                                strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace6.equals(str13)) {
                                                    strReplace6 = null;
                                                } else {
                                                    strReplace6 = null;
                                                }
                                                map.put(this.pinCodeString, strReplace6);
                                                map.put("pinCodeV1", strReplace6);
                                                strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace7.equals("null")) {
                                                    strReplace7 = null;
                                                } else {
                                                    strReplace7 = null;
                                                }
                                                map.put("houseNumberV1", strReplace7);
                                                strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace8.equals("null")) {
                                                    strReplace8 = str13;
                                                } else {
                                                    strReplace8 = str13;
                                                }
                                                map.put("localityStreetV1", strReplace8);
                                                strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace9.equals("null")) {
                                                    strReplace9 = null;
                                                } else {
                                                    strReplace9 = null;
                                                }
                                                map.put("postOfficeV1", strReplace9);
                                                strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (strReplace10.equals("null")) {
                                                    strReplace10 = str13;
                                                } else {
                                                    strReplace10 = str13;
                                                }
                                                map.put("tehsilTalukaMandalV1", strReplace10);
                                                strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                if (!strReplace11.equals("null")) {
                                                    str11 = strReplace11;
                                                }
                                                map.put("townVillageV1", str11);
                                                map.put("form7OId", this.id);
                                                map.put("isReinitiate", obj10);
                                                Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map7));
                                            }
                                            if (this.binding.notIndianCitizenRb.isChecked()) {
                                                obj2 = OBJECTIONSTRING;
                                                str10 = "NA";
                                                obj6 = "Y";
                                                obj3 = obj6;
                                                obj4 = "N";
                                                obj5 = obj4;
                                                obj8 = obj5;
                                            } else {
                                                if (this.binding.absentRb.isChecked()) {
                                                    obj2 = OBJECTIONSTRING;
                                                    str10 = "NA";
                                                    obj5 = "Y";
                                                    obj3 = obj5;
                                                    obj4 = "N";
                                                    obj6 = obj4;
                                                } else {
                                                    if (this.binding.alreadyEnrolledRb.isChecked()) {
                                                        obj2 = OBJECTIONSTRING;
                                                        str10 = "NA";
                                                        obj4 = "Y";
                                                        obj3 = obj4;
                                                        obj5 = "N";
                                                    } else {
                                                        if (this.binding.deadRb.isChecked()) {
                                                            obj2 = OBJECTIONSTRING;
                                                            str10 = "NA";
                                                            obj3 = "Y";
                                                            obj4 = "N";
                                                            obj5 = obj4;
                                                            obj6 = obj5;
                                                            str18 = str18;
                                                            str5 = str5;
                                                            obj8 = obj3;
                                                            obj7 = obj6;
                                                        } else {
                                                            zIsChecked = this.binding.underageRb.isChecked();
                                                            obj2 = OBJECTIONSTRING;
                                                            str10 = "NA";
                                                            obj3 = "Y";
                                                            obj4 = "N";
                                                            obj5 = obj4;
                                                            if (zIsChecked) {
                                                                obj6 = obj5;
                                                                str18 = str18;
                                                                str5 = str5;
                                                                obj7 = obj3;
                                                                obj8 = obj6;
                                                            }
                                                        }
                                                        if (this.binding.detailsCorrect.isChecked()) {
                                                            obj9 = obj3;
                                                        } else {
                                                            obj9 = "N";
                                                        }
                                                        HashMap map8 = new HashMap();
                                                        String str115 = str7;
                                                        map8.put("fieldVerificationVerifiedAndCorrect", obj9);
                                                        map8.put("fieldVerificationDataEntryErrors", "N");
                                                        map8.put("fieldVerificationAddress", obj);
                                                        map8.put("fieldVerificationDobOrAge", "N");
                                                        map8.put("fieldVerificationPhoto", "N");
                                                        map8.put("fieldVerificationAbsent", obj5);
                                                        map8.put("fieldVerificationDead", obj8);
                                                        map8.put("fieldVerificationNoSuchPerson", "N");
                                                        map8.put("fieldVerificationPersonPresent", "N");
                                                        map8.put("fieldVerificationShifted", "N");
                                                        map8.put("fieldVerificationAlreadyAppliedCount", 0);
                                                        map8.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                                                        map8.put("fieldVerificationUnderAge", obj7);
                                                        map8.put("fieldVerificationAlreadyEnrolled", obj4);
                                                        map8.put("fieldVerificationNotIndianCitizen", obj6);
                                                        map8.put("correctionOfAddress", "N");
                                                        map8.put("correctionOfDobAge", "N");
                                                        map8.put("correctionOfGender", "N");
                                                        map8.put("correctionOfMobile", "N");
                                                        map8.put("correctionOfName", "N");
                                                        map8.put("correctionOfPhotograpgh", "N");
                                                        map8.put("correctionOfRelation", "N");
                                                        map8.put("correctionOfRelative", "N");
                                                        str11 = null;
                                                        map8.put("fieldVerificationChecklist", null);
                                                        Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map8));
                                                        map = new HashMap();
                                                        map.put("applicantPlace", this.applicantPlace);
                                                        map.put("asemblyNo", this.asmblyNO);
                                                        map.put("createdBy", "operator");
                                                        map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                        map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                                        if (this.docref.isEmpty()) {
                                                            str12 = null;
                                                        } else {
                                                            str12 = null;
                                                        }
                                                        map.put("deathCertificateDln", str12);
                                                        map.put("deletionOfEpicNumberFor", str8);
                                                        map.put("deletionOfOther", str6);
                                                        map.put("deletionOfSelf", str115);
                                                        map.put("districtCode", this.districtCode);
                                                        map.put("emailApplicant", this.email);
                                                        map.put("epicid", this.epicId);
                                                        if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                                            map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        } else {
                                                            map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                                                        }
                                                        map.put("isSelfMobile", this.isSelfMobile);
                                                        map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                                                        map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                                                        map.put("firstNameApplicant", this.firstNameApplicant);
                                                        map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                                                        if (!this.formSubmissionChannel.equals("null")) {
                                                            map.put(this.formSubmissionChannelString, "GARUDA");
                                                        } else {
                                                            map.put(this.formSubmissionChannelString, "GARUDA");
                                                        }
                                                        if (!this.formSubmissionMode.equals("null")) {
                                                            map.put(this.formSubmissionModeString, "ONLINE");
                                                        } else {
                                                            map.put(this.formSubmissionModeString, "ONLINE");
                                                        }
                                                        map.put("formSubmissionPlace", this.formSubmissionPlace);
                                                        if (!this.surname.equals(" ")) {
                                                            map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                                                        }
                                                        if (!this.lastNameApplicant.equals(" ")) {
                                                            map.put("lastnameApplicant", this.lastNameApplicant);
                                                        }
                                                        if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                                                        } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                                            strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                                                        } else {
                                                            strSubstring = null;
                                                        }
                                                        map.put(this.mobileNumberApplicantString, strSubstring);
                                                        obj10 = obj3;
                                                        if (this.isSelfMobile.equals(obj10)) {
                                                            map.put(this.mobileNumberSelfString, strSubstring);
                                                        } else {
                                                            map.put(this.mobileNumberOfRelativeString, strSubstring);
                                                        }
                                                        if (this.request.equals(obj2)) {
                                                            map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                                            map.put("objectToInclFormType", this.objectToInclFormType);
                                                        }
                                                        map.put("age", this.age);
                                                        map.put("gender", this.gender);
                                                        map.put("objectionOnInclusionOrDeletion", str5);
                                                        map.put("partNumberApplicant", this.partNumberApplicant);
                                                        map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                                                        map.put("serialNumberApplicant", this.serialNumber);
                                                        map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                                                        map.put("stateCode", this.stateCode);
                                                        map.put("sectionNoApplicant", this.sectionNo);
                                                        map.put("sectionNo", this.sectionNo);
                                                        map.put("isDraft", "N");
                                                        map.put(this.reasonForDeletionString, str18);
                                                        map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                                                        strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                                                        str13 = str10;
                                                        if (strReplace.equals(str13)) {
                                                            strReplace = null;
                                                        } else {
                                                            strReplace = null;
                                                        }
                                                        map.put(this.townVillageString, strReplace);
                                                        strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace2.equals(str13)) {
                                                            strReplace2 = null;
                                                        } else {
                                                            strReplace2 = null;
                                                        }
                                                        map.put(this.tehsilTalukaMandalString, strReplace2);
                                                        strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace3.equals(str13)) {
                                                            strReplace3 = null;
                                                        } else {
                                                            strReplace3 = null;
                                                        }
                                                        map.put(this.postOfficeString, strReplace3);
                                                        strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace4.equals(str13)) {
                                                            strReplace4 = null;
                                                        } else {
                                                            strReplace4 = null;
                                                        }
                                                        map.put(this.localityStreetString, strReplace4);
                                                        strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace5.equals(str13)) {
                                                            strReplace5 = null;
                                                        } else {
                                                            strReplace5 = null;
                                                        }
                                                        map.put(this.houseNumberString, strReplace5);
                                                        strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace6.equals(str13)) {
                                                            strReplace6 = null;
                                                        } else {
                                                            strReplace6 = null;
                                                        }
                                                        map.put(this.pinCodeString, strReplace6);
                                                        map.put("pinCodeV1", strReplace6);
                                                        strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace7.equals("null")) {
                                                            strReplace7 = null;
                                                        } else {
                                                            strReplace7 = null;
                                                        }
                                                        map.put("houseNumberV1", strReplace7);
                                                        strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace8.equals("null")) {
                                                            strReplace8 = str13;
                                                        } else {
                                                            strReplace8 = str13;
                                                        }
                                                        map.put("localityStreetV1", strReplace8);
                                                        strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace9.equals("null")) {
                                                            strReplace9 = null;
                                                        } else {
                                                            strReplace9 = null;
                                                        }
                                                        map.put("postOfficeV1", strReplace9);
                                                        strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (strReplace10.equals("null")) {
                                                            strReplace10 = str13;
                                                        } else {
                                                            strReplace10 = str13;
                                                        }
                                                        map.put("tehsilTalukaMandalV1", strReplace10);
                                                        strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                                                        if (!strReplace11.equals("null")) {
                                                            str11 = strReplace11;
                                                        }
                                                        map.put("townVillageV1", str11);
                                                        map.put("form7OId", this.id);
                                                        map.put("isReinitiate", obj10);
                                                        Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                                                        this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map8));
                                                    }
                                                    obj6 = obj5;
                                                }
                                                obj8 = obj6;
                                            }
                                            map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                        } catch (ParseException e3) {
                                            Logger.e(CHECKLISTFORM7OVERSEAS, e3.getMessage());
                                        }
                                        map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString())));
                                    } catch (ParseException e4) {
                                        Logger.e(CHECKLISTFORM7OVERSEAS, e4.getMessage());
                                    }
                                    str18 = str14;
                                } catch (Exception e5) {
                                    Logger.e(CHECKLISTFORM7OVERSEAS, e5.getMessage());
                                }
                                str17 = str16;
                                str5 = str17;
                                str6 = str16;
                                str7 = str15;
                                str8 = str;
                                str9 = string;
                            } catch (Exception e6) {
                                e = e6;
                                str = "";
                                str2 = str;
                                str3 = str2;
                            }
                            if (this.binding.addressSame.isChecked()) {
                                obj = "Y";
                            } else {
                                obj = "N";
                            }
                            obj7 = obj8;
                            if (this.binding.detailsCorrect.isChecked()) {
                                obj9 = obj3;
                            } else {
                                obj9 = "N";
                            }
                            HashMap map9 = new HashMap();
                            String str116 = str7;
                            map9.put("fieldVerificationVerifiedAndCorrect", obj9);
                            map9.put("fieldVerificationDataEntryErrors", "N");
                            map9.put("fieldVerificationAddress", obj);
                            map9.put("fieldVerificationDobOrAge", "N");
                            map9.put("fieldVerificationPhoto", "N");
                            map9.put("fieldVerificationAbsent", obj5);
                            map9.put("fieldVerificationDead", obj8);
                            map9.put("fieldVerificationNoSuchPerson", "N");
                            map9.put("fieldVerificationPersonPresent", "N");
                            map9.put("fieldVerificationShifted", "N");
                            map9.put("fieldVerificationAlreadyAppliedCount", 0);
                            map9.put("fieldVerificationRemark", this.binding.remarkEd.getText().toString());
                            map9.put("fieldVerificationUnderAge", obj7);
                            map9.put("fieldVerificationAlreadyEnrolled", obj4);
                            map9.put("fieldVerificationNotIndianCitizen", obj6);
                            map9.put("correctionOfAddress", "N");
                            map9.put("correctionOfDobAge", "N");
                            map9.put("correctionOfGender", "N");
                            map9.put("correctionOfMobile", "N");
                            map9.put("correctionOfName", "N");
                            map9.put("correctionOfPhotograpgh", "N");
                            map9.put("correctionOfRelation", "N");
                            map9.put("correctionOfRelative", "N");
                            str11 = null;
                            map9.put("fieldVerificationChecklist", null);
                            Logger.d(CHECKLISTFORM7OVERSEAS, "FVR form 7 " + new JSONObject(map9));
                            map = new HashMap();
                            map.put("applicantPlace", this.applicantPlace);
                            map.put("asemblyNo", this.asmblyNO);
                            map.put("createdBy", "operator");
                            if (this.docref.isEmpty()) {
                                str12 = null;
                            } else {
                                str12 = null;
                            }
                            map.put("deathCertificateDln", str12);
                            map.put("deletionOfEpicNumberFor", str8);
                            map.put("deletionOfOther", str6);
                            map.put("deletionOfSelf", str116);
                            map.put("districtCode", this.districtCode);
                            map.put("emailApplicant", this.email);
                            map.put("epicid", this.epicId);
                            if (!this.districtCdOfPersonToBeDeleted.isEmpty()) {
                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                            } else {
                                map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
                            }
                            map.put("isSelfMobile", this.isSelfMobile);
                            map.put(this.epicNumberApplicantString, this.binding.epicNumberTv1.getText().toString());
                            map.put(this.epicNumberOfPersonToBeDeletedString, str9);
                            map.put("firstNameApplicant", this.firstNameApplicant);
                            map.put("firstNameOfPersonToBeDeleted", this.binding.name.getText().toString());
                            if (!this.formSubmissionChannel.equals("null")) {
                                map.put(this.formSubmissionChannelString, "GARUDA");
                            } else {
                                map.put(this.formSubmissionChannelString, "GARUDA");
                            }
                            if (!this.formSubmissionMode.equals("null")) {
                                map.put(this.formSubmissionModeString, "ONLINE");
                            } else {
                                map.put(this.formSubmissionModeString, "ONLINE");
                            }
                            map.put("formSubmissionPlace", this.formSubmissionPlace);
                            if (!this.surname.equals(" ")) {
                                map.put(this.lastNameOfPersonToBeDeletedString, this.surname);
                            }
                            if (!this.lastNameApplicant.equals(" ")) {
                                map.put("lastnameApplicant", this.lastNameApplicant);
                            }
                            if (this.binding.mobileNoTv.getText().toString().startsWith("+91-")) {
                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(4);
                            } else if (this.binding.mobileNoTv.getText().toString().startsWith("+91")) {
                                strSubstring = this.binding.mobileNoTv.getText().toString().substring(3);
                            } else {
                                strSubstring = null;
                            }
                            map.put(this.mobileNumberApplicantString, strSubstring);
                            obj10 = obj3;
                            if (this.isSelfMobile.equals(obj10)) {
                                map.put(this.mobileNumberSelfString, strSubstring);
                            } else {
                                map.put(this.mobileNumberOfRelativeString, strSubstring);
                            }
                            if (this.request.equals(obj2)) {
                                map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
                                map.put("objectToInclFormType", this.objectToInclFormType);
                            }
                            map.put("age", this.age);
                            map.put("gender", this.gender);
                            map.put("objectionOnInclusionOrDeletion", str5);
                            map.put("partNumberApplicant", this.partNumberApplicant);
                            map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
                            map.put("serialNumberApplicant", this.serialNumber);
                            map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
                            map.put("stateCode", this.stateCode);
                            map.put("sectionNoApplicant", this.sectionNo);
                            map.put("sectionNo", this.sectionNo);
                            map.put("isDraft", "N");
                            map.put(this.reasonForDeletionString, str18);
                            map.put("formSubmissionReferenceNumber", this.binding.refNoTv.getText().toString());
                            strReplace = this.binding.village.getText().toString().trim().replace("[ ]+", " ");
                            str13 = str10;
                            if (strReplace.equals(str13)) {
                                strReplace = null;
                            } else {
                                strReplace = null;
                            }
                            map.put(this.townVillageString, strReplace);
                            strReplace2 = this.binding.tehsil.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace2.equals(str13)) {
                                strReplace2 = null;
                            } else {
                                strReplace2 = null;
                            }
                            map.put(this.tehsilTalukaMandalString, strReplace2);
                            strReplace3 = this.binding.postoffice.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace3.equals(str13)) {
                                strReplace3 = null;
                            } else {
                                strReplace3 = null;
                            }
                            map.put(this.postOfficeString, strReplace3);
                            strReplace4 = this.binding.street.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace4.equals(str13)) {
                                strReplace4 = null;
                            } else {
                                strReplace4 = null;
                            }
                            map.put(this.localityStreetString, strReplace4);
                            strReplace5 = this.binding.houseno.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace5.equals(str13)) {
                                strReplace5 = null;
                            } else {
                                strReplace5 = null;
                            }
                            map.put(this.houseNumberString, strReplace5);
                            strReplace6 = this.binding.pincode.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace6.equals(str13)) {
                                strReplace6 = null;
                            } else {
                                strReplace6 = null;
                            }
                            map.put(this.pinCodeString, strReplace6);
                            map.put("pinCodeV1", strReplace6);
                            strReplace7 = this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace7.equals("null")) {
                                strReplace7 = null;
                            } else {
                                strReplace7 = null;
                            }
                            map.put("houseNumberV1", strReplace7);
                            strReplace8 = this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace8.equals("null")) {
                                strReplace8 = str13;
                            } else {
                                strReplace8 = str13;
                            }
                            map.put("localityStreetV1", strReplace8);
                            strReplace9 = this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace9.equals("null")) {
                                strReplace9 = null;
                            } else {
                                strReplace9 = null;
                            }
                            map.put("postOfficeV1", strReplace9);
                            strReplace10 = this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (strReplace10.equals("null")) {
                                strReplace10 = str13;
                            } else {
                                strReplace10 = str13;
                            }
                            map.put("tehsilTalukaMandalV1", strReplace10);
                            strReplace11 = this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " ");
                            if (!strReplace11.equals("null")) {
                                str11 = strReplace11;
                            }
                            map.put("townVillageV1", str11);
                            map.put("form7OId", this.id);
                            map.put("isReinitiate", obj10);
                            Logger.d(CHECKLISTFORM7OVERSEAS, "Form 7O Submission: " + new JSONObject(map));
                            this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).submitForm7Overseas(Token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass16(map, Token, map9));
                        }

                        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16, reason: invalid class name */
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
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "Form 7 Overseas Submission: " + this.val$map);
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "Form 7 Overseas Checklist submitted successfully");
                                    CommomUtility commomUtility = ApplicantDetailsForm7OverseasFragment.this.commonutils;
                                    Context context = ApplicantDetailsForm7OverseasFragment.this.getContext();
                                    String str = ApplicantDetailsForm7OverseasFragment.this.stateCode;
                                    int i = ApplicantDetailsForm7OverseasFragment.this.processMasterId;
                                    int i2 = ApplicantDetailsForm7OverseasFragment.this.currentStatusId;
                                    String str2 = this.val$Token;
                                    String atknBnd = SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.getContext()).getAtknBnd();
                                    String rtknBnd = SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.getContext()).getRtknBnd();
                                    final String str3 = this.val$Token;
                                    final HashMap map = this.val$map2;
                                    commomUtility.getWorkflowid(context, str, i, i2, str2, atknBnd, rtknBnd, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda0
                                        @Override // in.gov.eci.bloapp.MyCallback
                                        public final void onCallback(int i3, String str4) {
                                            this.f$0.lambda$onResponse$2(str3, map, i3, str4);
                                        }
                                    });
                                    return;
                                }
                                try {
                                    if (response.code() == 401) {
                                        ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda1
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i3, String str4, String str5) {
                                                this.f$0.lambda$onResponse$4(i3, str4, str5);
                                            }
                                        });
                                    } else {
                                        JSONObject jSONObject = new JSONObject(response.errorBody().string());
                                        String strOptString = jSONObject.optString(ApplicantDetailsForm7OverseasFragment.this.message);
                                        String strOptString2 = jSONObject.optString("cause");
                                        Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, strOptString);
                                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                        if (strOptString.equals("null")) {
                                            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                            applicantDetailsForm7OverseasFragment.showdialog(applicantDetailsForm7OverseasFragment.alert, strOptString2);
                                        } else {
                                            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = ApplicantDetailsForm7OverseasFragment.this;
                                            applicantDetailsForm7OverseasFragment2.showdialog(applicantDetailsForm7OverseasFragment2.alert, strOptString);
                                        }
                                    }
                                } catch (Exception e) {
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    if (response.code() == 401) {
                                        ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda2
                                            @Override // in.gov.eci.bloapp.aadharcallback
                                            public final void onCallBack(int i3, String str4, String str5) {
                                                this.f$0.lambda$onResponse$6(i3, str4, str5);
                                            }
                                        });
                                    } else if (response != null && response.message() != null) {
                                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment3 = ApplicantDetailsForm7OverseasFragment.this;
                                        applicantDetailsForm7OverseasFragment3.showdialog(applicantDetailsForm7OverseasFragment3.alert, response.message());
                                    } else {
                                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment4 = ApplicantDetailsForm7OverseasFragment.this;
                                        applicantDetailsForm7OverseasFragment4.showdialog(applicantDetailsForm7OverseasFragment4.alert, ApplicantDetailsForm7OverseasFragment.this.pleaseSubmitAgain);
                                    }
                                    Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$2(String str, HashMap map, int i, String str2) {
                                if (i == 401) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda6
                                        @Override // in.gov.eci.bloapp.aadharcallback
                                        public final void onCallBack(int i2, String str3, String str4) {
                                            this.f$0.lambda$onResponse$1(i2, str3, str4);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.workflowConfigId = Integer.parseInt(str2);
                                Call<Void> callFormProcessingService = ApplicantDetailsForm7OverseasFragment.this.commonutils.getRetrofitClient(ApplicantDetailsForm7OverseasFragment.this.getContext(), str, SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.getContext()).getRtknBnd()).formProcessingService(ApplicantDetailsForm7OverseasFragment.this.stateCode, "blo", ApplicantDetailsForm7OverseasFragment.this.workflowConfigId, ApplicantDetailsForm7OverseasFragment.this.formProcessingDetailsId, "ANDROIDMOB", map);
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "formProcessingDetailsId : " + ApplicantDetailsForm7OverseasFragment.this.formProcessingDetailsId);
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "workflowConfigId : " + ApplicantDetailsForm7OverseasFragment.this.workflowConfigId);
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, "FVR Submission: " + map);
                                callFormProcessingService.enqueue(new AnonymousClass1());
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda5
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment.submitForm7Overseas(applicantDetailsForm7OverseasFragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$1, reason: invalid class name */
                            class AnonymousClass1 implements Callback<Void> {
                                AnonymousClass1() {
                                }

                                public void onResponse(Call<Void> call1, Response<Void> response1) {
                                    if (response1.isSuccessful()) {
                                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                        ApplicantDetailsForm7OverseasFragment.this.showdialogFinal("Success", "Verified Successfully");
                                        return;
                                    }
                                    try {
                                        if (response1.code() == 401) {
                                            ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$1$$ExternalSyntheticLambda1
                                                @Override // in.gov.eci.bloapp.aadharcallback
                                                public final void onCallBack(int i, String str, String str2) {
                                                    this.f$0.lambda$onResponse$1(i, str, str2);
                                                }
                                            });
                                        } else {
                                            String strOptString = new JSONObject(response1.errorBody().string()).optString("error");
                                            Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, strOptString);
                                            ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                            ApplicantDetailsForm7OverseasFragment.this.showdialog(ApplicantDetailsForm7OverseasFragment.this.alert, strOptString);
                                        }
                                    } catch (Exception e) {
                                        ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                        if (response1.code() == 401) {
                                            ApplicantDetailsForm7OverseasFragment.this.commonutils.getRefreshToken(ApplicantDetailsForm7OverseasFragment.this.requireContext(), ApplicantDetailsForm7OverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$1$$ExternalSyntheticLambda2
                                                @Override // in.gov.eci.bloapp.aadharcallback
                                                public final void onCallBack(int i, String str, String str2) {
                                                    this.f$0.lambda$onResponse$3(i, str, str2);
                                                }
                                            });
                                        } else if (response1 != null && response1.message() != null) {
                                            ApplicantDetailsForm7OverseasFragment.this.showdialog(ApplicantDetailsForm7OverseasFragment.this.alert, response1.message());
                                        } else {
                                            ApplicantDetailsForm7OverseasFragment.this.showdialog(ApplicantDetailsForm7OverseasFragment.this.alert, ApplicantDetailsForm7OverseasFragment.this.pleaseSubmitAgain);
                                        }
                                        Logger.e(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, e.getMessage());
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$1$$ExternalSyntheticLambda3
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                                            }
                                        });
                                        return;
                                    }
                                    ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                                    ApplicantDetailsForm7OverseasFragment.this.submitForm7Overseas(ApplicantDetailsForm7OverseasFragment.this.token);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                    ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                    if (i == 401 || i == 400) {
                                        ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$1$$ExternalSyntheticLambda0
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                this.f$0.lambda$onResponse$2(dialogInterface, i2);
                                            }
                                        });
                                        return;
                                    }
                                    ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                                    ApplicantDetailsForm7OverseasFragment.this.submitForm7Overseas(ApplicantDetailsForm7OverseasFragment.this.token);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                    SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                    ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                                }

                                public void onFailure(Call<Void> call1, Throwable t) {
                                    Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                                    ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                    ApplicantDetailsForm7OverseasFragment.this.showdialog(ApplicantDetailsForm7OverseasFragment.this.alert, ApplicantDetailsForm7OverseasFragment.this.pleaseSubmitAgain);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$4(int i, String str, String str2) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda4
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$3(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment.submitForm7Overseas(applicantDetailsForm7OverseasFragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$6(int i, String str, String str2) {
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                                if (i == 401 || i == 400) {
                                    ApplicantDetailsForm7OverseasFragment.this.commonutils.showMessageOK(ApplicantDetailsForm7OverseasFragment.this.getContext(), ApplicantDetailsForm7OverseasFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$16$$ExternalSyntheticLambda3
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            this.f$0.lambda$onResponse$5(dialogInterface, i2);
                                        }
                                    });
                                    return;
                                }
                                ApplicantDetailsForm7OverseasFragment.this.token = "Bearer " + str;
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setRefreshToken(str2);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setToken("Bearer " + str);
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment.submitForm7Overseas(applicantDetailsForm7OverseasFragment.token);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setIsLoggedIn(false);
                                SharedPref.getInstance(ApplicantDetailsForm7OverseasFragment.this.requireContext()).setLocaleBool(false);
                                ApplicantDetailsForm7OverseasFragment.this.startActivity(new Intent((Context) ApplicantDetailsForm7OverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
                            }

                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Logger.d(ApplicantDetailsForm7OverseasFragment.CHECKLISTFORM7OVERSEAS, ApplicantDetailsForm7OverseasFragment.this.comingInOnFailure + t.getMessage());
                                ApplicantDetailsForm7OverseasFragment.this.alertDialog.dismiss();
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = ApplicantDetailsForm7OverseasFragment.this;
                                applicantDetailsForm7OverseasFragment.showdialog(applicantDetailsForm7OverseasFragment.alert, ApplicantDetailsForm7OverseasFragment.this.pleaseSubmitAgain);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showdialogFinal(String title, String msg) {
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda14
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$showdialogFinal$17(dialogInterface, i);
                                }
                            }).create().show();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$showdialogFinal$17(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            openFragment(new CheckListMain(), "Applicant Details Form 7O");
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void showdialog(String title, String msg) {
                            new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7OverseasFragment$$ExternalSyntheticLambda13
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            }).create().show();
                        }

                        public void onDestroy() {
                            super.onDestroy();
                        }
                    }
