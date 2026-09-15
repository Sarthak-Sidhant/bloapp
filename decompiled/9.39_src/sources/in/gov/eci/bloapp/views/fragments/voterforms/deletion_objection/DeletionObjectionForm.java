package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.FormData;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.customadapter.CustomSpinnerAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentDeletionObjectionBinding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.languagetransliteration.db.DBClient;
import in.gov.eci.bloapp.languagetransliteration.db.TState;
import in.gov.eci.bloapp.model.app_model.DeletionObjectionDraftModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeletionObjectionForm extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnClickListener, View.OnFocusChangeListener {
    private static final String DELETIONOBJECTION = "Deletion Objection";
    private static final String OTHERSTRING = "other";
    static String absentPermanentlyShifted = "Absent/Permanently shifted";
    static String alertString = "Alert";
    static String alreadyEnrolled = "Already Enrolled";
    static String death = "Death";
    static String deletionOfEpicNumberFor = "deletionOfEpicNumberFor";
    static String epicNumberString = "epicNumber";
    static String errorString = "Error";
    static String inclusionString = "I object to proposed inclusion of name of the person mentioned below due to any one of the following reasons,";
    static String notIndianCitizen = "Not Indian Citizen";
    static String objectToInclFormTypeString = "objectToInclFormType";
    static String objection = "objection";
    static String otherDeletionString = "I request to delete name of the person mentioned below already included in the current roll due to any one of the following reasons,";
    static String partNumberOfPersonToBeDeletedString = "partNumberOfPersonToBeDeleted";
    static String partSerialNumberString = "partSerialNumber";
    static String permanentlyShifted = "Permanently shifted";
    static String reasonForDeletion = "reasonForDeletion";
    static String refIdString = "refId";
    static String rejected = "Rejected";
    static String relativeMentionedAbove = "Relative mentioned above";
    static String selectReason = "Select Reason";
    static String selfDeletionString = "I request to delete my name from electoral roll due to any one of the following reasons,";
    static String serialNumberApplicantString = "serialNumberApplicant";
    static String sessionExpiredString = "Session token expired please Login";
    static int spanExclusiveExclusive = 33;
    static String underAge = "Under Age";
    private String acNo;
    ActivityResultLauncher<Intent> activityResultLauncher;
    private String age;
    AlertDialog alertDialog;
    String applicantEpicDetailsArray;
    LinearLayout backStack;
    private BloFragmentDeletionObjectionBinding binding;
    private String bloOutput;
    Retrofit.Builder builder2;
    private byte[] byteArray;
    private String certificateName;
    private String certificateSize;
    private String createdOn;
    private View currentSelectedView;
    String dbfetchepic;
    String dbfetchepic2;
    String deathCertiAttach;
    private String deletion;
    private String districtCdOfPersonToBeDeleted;
    private String docref;
    String english_code;
    String epicEd2;
    private String epicId;
    private String epicNameRv;
    String epicOther;
    private String firstNameApplicant;
    String firstnameRv;
    private String flag;
    private String form;
    private String formOrigin;
    private boolean fromDraft;
    String fromPreview;
    FusedLocationProviderClient fusedLocationProviderClient;
    private String gender;
    private String lastNameApplicant;
    String lastnameRv;
    private LocationRequest locationRequest;
    String mobileType;
    String mobileforReset;
    String nameOther;
    private String objectToInclFormRefNum;
    private String objectToInclFormType;
    private String partLang;
    private String partLangSubString;
    private String partNo;
    private String partNumberApplicant;
    private String partNumberOfPersonToBeDeleted;
    private String pseAcNo;
    private String pseId;
    private String psePartNo;
    private String psePreferredUsername;
    private ArrayList<String> reasonCode1;
    private ArrayList<String> reasonCode2;
    private ArrayList<String> reasonCode3;
    private HashMap<String, String> reasonmap;
    private String referenceNumber;
    private String refreshToken;
    private JSONObject rejectedJson;
    String rejectionOption;
    String rejectionOptionSubcategory;
    private ArrayList<String> rejectionOptions;
    private ArrayList<String> rejectionOptions1;
    private ArrayList<String> rejectionOptions2;
    private ArrayList<String> rejectionOptions3;
    String request;
    Retrofit retrofit;
    private String sectionNoApplicant;
    private String serialNumberApplicant;
    private String serialNumberOfPersonToBeDeleted;
    private CustomSpinnerAdapter spinnerAdapter1;
    private CustomSpinnerAdapter spinnerAdapter2;
    private CustomSpinnerAdapter spinnerAdapter3;
    private String stateCode;
    String surnameOther;
    private String token;
    private DeletionObjectionViewModel viewModel;
    String appName = "BLOAPP";
    String serialNumberOfPersonToBeDeletedString = "serialNumberOfPersonToBeDeleted";
    String pleaseFillOption = "Please fill Option of application/objection tab completely";
    String form7 = "Form 7";
    String somethingWentWrong = "Something went wrong, Please Try Again";
    String cominginOnFailure = "coming in onFailure ";
    String colorStringBlue = "#1C77FF";
    CommomUtility commonUtilClass = new CommomUtility();
    String delimeter = "‡";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public DeletionObjectionForm() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder2 = builderClient;
        this.retrofit = builderClient.build();
        this.fromDraft = false;
        this.formOrigin = "NEW";
        this.english_code = "en_in";
        this.age = "";
        this.gender = "";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda1
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$17((ActivityResult) obj);
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.rejection_spinner1 /* 2131365361 */:
                if (parent.getItemAtPosition(position).toString().equals(death)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRg.setChecked(true);
                }
                break;
            case R.id.rejection_spinner2 /* 2131365362 */:
                if (parent.getItemAtPosition(position).toString().equals(death)) {
                    this.binding.deathLayout.setVisibility(0);
                } else {
                    this.binding.deathLayout.setVisibility(8);
                    this.binding.noRg.setChecked(true);
                }
                break;
            case R.id.rejection_spinner3 /* 2131365363 */:
                this.binding.deathLayout.setVisibility(8);
                this.binding.noRg.setChecked(true);
                break;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentDeletionObjectionBinding.inflate(getLayoutInflater());
        this.viewModel = (DeletionObjectionViewModel) new ViewModelProvider(requireActivity()).get(DeletionObjectionViewModel.class);
        boolean z = false;
        this.binding.selectStateLayout.setEnabled(false);
        this.binding.personalDetailLayout.setEnabled(false);
        this.binding.rejectionOptionsLayout.setEnabled(false);
        this.binding.personDetailsLayout.setEnabled(false);
        this.binding.declarationLayout.setEnabled(false);
        this.binding.personalDetailsFormLayout.setVisibility(8);
        this.binding.rejectionOptionsFormLayout.setVisibility(8);
        this.binding.personDetailsFormLayout.setVisibility(8);
        this.binding.declarationFormLayout.setVisibility(8);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        getCurrentLocation();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        String districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        String stateName = SharedPref.getInstance(requireContext()).getStateName();
        String districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        String assemblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d("Token Deletion/Objecion", this.token);
        this.rejectionOptions = new ArrayList<>();
        this.reasonmap = new HashMap<>();
        this.rejectionOptions1 = new ArrayList<>();
        this.rejectionOptions2 = new ArrayList<>();
        this.rejectionOptions3 = new ArrayList<>();
        this.reasonCode1 = new ArrayList<>();
        this.reasonCode2 = new ArrayList<>();
        this.reasonCode3 = new ArrayList<>();
        this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
        this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
        this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("flag");
            this.flag = string;
            this.flag = nullChecker(string);
            String string2 = arguments.getString("epicId");
            this.epicId = string2;
            this.epicId = nullChecker(string2);
            String string3 = arguments.getString("fromH2h");
            this.formOrigin = string3;
            this.formOrigin = nullCheckerFormOrigin(string3);
            String string4 = arguments.getString("request");
            this.request = string4;
            this.request = nullChecker(string4);
            String string5 = arguments.getString("form");
            this.form = string5;
            this.form = nullChecker(string5);
            String string6 = arguments.getString("Deletion");
            this.deletion = string6;
            this.deletion = nullChecker(string6);
            String string7 = arguments.getString("voterId");
            this.dbfetchepic = string7;
            this.dbfetchepic = nullChecker(string7);
            String string8 = arguments.getString("voterId2");
            this.dbfetchepic2 = string8;
            this.dbfetchepic2 = nullChecker(string8);
            String string9 = arguments.getString("firstnamefromdb");
            this.firstnameRv = string9;
            this.firstnameRv = nullChecker(string9);
            String string10 = arguments.getString("lastnamefromdb");
            this.lastnameRv = string10;
            this.lastnameRv = nullChecker(string10);
            String string11 = arguments.getString("epic");
            this.epicNameRv = string11;
            this.epicNameRv = nullChecker(string11);
            String string12 = arguments.getString("fromPreview");
            this.fromPreview = string12;
            this.fromPreview = nullChecker(string12);
            String string13 = arguments.getString("nameOther");
            this.nameOther = string13;
            this.nameOther = nullChecker(string13);
            String string14 = arguments.getString("surnameOther");
            this.surnameOther = string14;
            this.surnameOther = nullChecker(string14);
            String string15 = arguments.getString("epicOther");
            this.epicOther = string15;
            this.epicOther = nullChecker(string15);
            String string16 = arguments.getString("districtCdOfPersonToBeDeleted");
            this.districtCdOfPersonToBeDeleted = string16;
            this.districtCdOfPersonToBeDeleted = nullChecker(string16);
            String string17 = arguments.getString("fdreferenceNumber");
            this.objectToInclFormRefNum = string17;
            this.objectToInclFormRefNum = nullChecker(string17);
            String string18 = arguments.getString(objectToInclFormTypeString);
            this.objectToInclFormType = string18;
            this.objectToInclFormType = nullChecker(string18);
            String string19 = arguments.getString("pseAcNo");
            this.pseAcNo = string19;
            this.pseAcNo = nullChecker(string19);
            String string20 = arguments.getString("pseId");
            this.pseId = string20;
            this.pseId = nullChecker(string20);
            String string21 = arguments.getString("psePartNo");
            this.psePartNo = string21;
            this.psePartNo = nullChecker(string21);
            String string22 = arguments.getString("psePreferredUsername");
            this.psePreferredUsername = string22;
            this.psePreferredUsername = nullChecker(string22);
            String string23 = arguments.getString("bloOutput");
            this.bloOutput = string23;
            this.bloOutput = nullChecker(string23);
            String string24 = arguments.getString(serialNumberApplicantString);
            this.serialNumberApplicant = string24;
            this.serialNumberApplicant = nullChecker2(string24);
            String string25 = arguments.getString("partNumberApplicant");
            this.partNumberApplicant = string25;
            this.partNumberApplicant = nullCheckerPartNumber(string25);
            String string26 = arguments.getString(this.serialNumberOfPersonToBeDeletedString);
            this.serialNumberOfPersonToBeDeleted = string26;
            this.serialNumberOfPersonToBeDeleted = nullChecker2(string26);
            String string27 = arguments.getString(partNumberOfPersonToBeDeletedString);
            this.partNumberOfPersonToBeDeleted = string27;
            this.partNumberOfPersonToBeDeleted = nullCheckerPartNumber(string27);
            this.applicantEpicDetailsArray = arguments.getString("applicantEpicDetailsArray");
        }
        this.alertDialog.show();
        boolean z2 = true;
        if (this.request.equals("same")) {
            getRefNum("S");
            getByEpicForFormSelf((JsonArray) new JsonParser().parse(this.applicantEpicDetailsArray));
            this.districtCdOfPersonToBeDeleted = districtCode;
            this.binding.stateEd.setText(stateName);
            this.binding.districtEd.setText(districtName);
            this.binding.constituencyEd.setText(assemblyName);
            this.binding.constituencynoEd.setText(this.acNo);
            this.binding.nameEd.setText(this.firstnameRv);
            this.binding.surNameEd2.setText(this.lastnameRv);
            this.binding.epicEd2.setText(this.epicNameRv);
            this.binding.stateEd1.setText(stateName);
            this.binding.districtEd1.setText(districtName);
            this.binding.self.setChecked(true);
            this.binding.optionRb3.setChecked(true);
            this.binding.optionRb2.setEnabled(false);
            this.binding.optionRb1.setEnabled(false);
            this.binding.rejectionSpinnerLayout1.setVisibility(8);
            this.binding.rejectionSpinner1.setSelection(0);
            this.binding.rejectionSpinnerLayout2.setVisibility(8);
            this.binding.rejectionSpinner2.setSelection(0);
            this.binding.rejectionSpinnerLayout3.setVisibility(0);
            this.rejectionOption = selfDeletionString;
        } else if (this.request.equals(OTHERSTRING)) {
            getRefNum("O");
            getByEpicForForm((JsonArray) new JsonParser().parse(this.applicantEpicDetailsArray));
            this.binding.nameEd.setText(this.firstnameRv);
            this.binding.surNameEd2.setText(this.lastnameRv);
            this.binding.epicEd2.setText(this.epicNameRv);
            this.binding.relative.setChecked(true);
            this.binding.stateEd.setText(stateName);
            this.binding.districtEd.setText(districtName);
            this.binding.constituencyEd.setText(assemblyName);
            this.binding.constituencynoEd.setText(this.acNo);
            this.binding.stateEd1.setText(stateName);
            this.binding.districtEd1.setText(districtName);
            this.binding.optionRb1.setChecked(true);
            this.binding.optionRb2.setEnabled(false);
            this.binding.optionRb3.setEnabled(false);
            this.binding.rejectionSpinnerLayout1.setVisibility(0);
            this.binding.rejectionSpinnerLayout2.setVisibility(8);
            this.binding.rejectionSpinner2.setSelection(0);
            this.binding.rejectionSpinnerLayout3.setVisibility(8);
            this.binding.rejectionSpinner3.setSelection(0);
            this.rejectionOption = otherDeletionString;
        } else if (this.request.equals(objection)) {
            getRefNum("I");
            getByEpicForForm((JsonArray) new JsonParser().parse(this.applicantEpicDetailsArray));
            this.binding.nameEd.setText(this.firstnameRv);
            this.binding.surNameEd2.setText(this.lastnameRv);
            this.binding.relative.setChecked(true);
            this.binding.stateEd.setText(stateName);
            this.binding.districtEd.setText(districtName);
            this.binding.constituencyEd.setText(assemblyName);
            this.binding.constituencynoEd.setText(this.acNo);
            this.binding.stateEd1.setText(stateName);
            this.binding.districtEd1.setText(districtName);
            this.binding.optionRb2.setChecked(true);
            this.binding.optionRb3.setEnabled(false);
            this.binding.optionRb1.setEnabled(false);
            this.binding.rejectionSpinnerLayout1.setVisibility(8);
            this.binding.rejectionSpinner1.setSelection(0);
            this.binding.rejectionSpinnerLayout2.setVisibility(0);
            this.binding.rejectionSpinnerLayout3.setVisibility(8);
            this.binding.rejectionSpinner3.setSelection(0);
            this.rejectionOption = inclusionString;
        }
        this.createdOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
        this.backStack = this.binding.deletionObjectionFormLayout;
        this.currentSelectedView = this.binding.selectStateLayout;
        starMarkerAndRemover();
        this.binding.previousTv.setEnabled(false);
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_line));
        loadData();
        this.binding.houseEd2.setOnFocusChangeListener(this);
        this.binding.streetEd2.setOnFocusChangeListener(this);
        this.binding.villageEd2.setOnFocusChangeListener(this);
        this.binding.postofficeEd2.setOnFocusChangeListener(this);
        this.binding.tehsilEd2.setOnFocusChangeListener(this);
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
        textWatcher(this.binding.houseEd, this.binding.houseEd2, RegexMatcher.HOUSENO_OFFICIAL_REGEX);
        textWatcher(this.binding.streetEd, this.binding.streetEd2, RegexMatcher.ADDRESS_OFFICIAL_REGEX);
        textWatcher(this.binding.villageEd, this.binding.villageEd2, RegexMatcher.ADDRESS_OFFICIAL_REGEX);
        textWatcher(this.binding.postofficeEd, this.binding.postofficeEd2, RegexMatcher.ADDRESS_OFFICIAL_REGEX);
        textWatcher(this.binding.tehsilEd, this.binding.tehsilEd2, RegexMatcher.ADDRESS_OFFICIAL_REGEX);
        textWatcherRegional(this.binding.houseEd2, RegexMatcher.HOUSE_REGIONAL_REGEX);
        textWatcherRegional(this.binding.streetEd2, ".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*");
        textWatcherRegional(this.binding.villageEd2, ".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*");
        textWatcherRegional(this.binding.postofficeEd2, ".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*");
        textWatcherRegional(this.binding.tehsilEd2, ".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;0-9\"{}\\[\\]].*");
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.mobNumRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda12
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$1(radioGroup, i);
            }
        });
        this.binding.rejectionOptionsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda13
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$2(radioGroup, i);
            }
        });
        this.binding.deathCertificateReg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda14
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$3(radioGroup, i);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z2) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm.1
            public void handleOnBackPressed() {
                if (DeletionObjectionForm.this.formOrigin.equals("NEW")) {
                    Intent intent = new Intent((Context) DeletionObjectionForm.this.getActivity(), (Class<?>) VoterForms.class);
                    intent.setFlags(268468224);
                    DeletionObjectionForm.this.startActivity(intent);
                    return;
                }
                DeletionObjectionForm.this.requireActivity().finish();
            }
        });
        initializingClicks();
        initClickListener();
        if (arguments != null) {
            dataoneditbutton(arguments.getString("name"), arguments.getString("date"), this.form7);
            if (arguments.getString("form") != null && arguments.getString("form").equals("draftform")) {
                z = true;
            }
            this.fromDraft = z;
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.mobNumRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131365402) {
            this.mobileType = relativeMentionedAbove;
        } else {
            if (checkedRadioButtonId != 2131365664) {
                return;
            }
            this.mobileType = "Self";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(RadioGroup radioGroup, int i) {
        switch (this.binding.rejectionOptionsRg.getCheckedRadioButtonId()) {
            case R.id.option_rb1 /* 2131364928 */:
                this.request = OTHERSTRING;
                this.rejectionOption = otherDeletionString;
                this.binding.rejectionSpinnerLayout1.setVisibility(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb2 /* 2131364929 */:
                this.request = objection;
                this.rejectionOption = inclusionString;
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner3.setSelection(0);
                break;
            case R.id.option_rb3 /* 2131364930 */:
                this.request = "same";
                this.rejectionOption = selfDeletionString;
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinnerLayout3.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.deathCertificateReg.getCheckedRadioButtonId();
        if (checkedRadioButtonId != 2131364848) {
            if (checkedRadioButtonId != 2131366738) {
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

    private String nullCheckerFormOrigin(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "NEW" : bundleObject;
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    private String nullChecker2(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null") || bundleObject.isEmpty()) ? "0" : bundleObject;
    }

    private String nullCheckerPartNumber(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null") || bundleObject.isEmpty()) ? this.partNo : bundleObject;
    }

    private void textWatcher(final EditText editText, final AutoCompleteTextView editTextRegional, final String regex) {
        editText.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(DeletionObjectionForm.DELETIONOBJECTION, count + "");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = editText.getText().toString();
                if (editText.getText().toString().matches(regex)) {
                    return;
                }
                try {
                    editText.setText(string.substring(0, string.length() - 1));
                    EditText editText2 = editText;
                    editText2.setSelection(editText2.getText().toString().length());
                } catch (Exception e) {
                    Logger.d(DeletionObjectionForm.DELETIONOBJECTION, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || !s.toString().isEmpty()) {
                    return;
                }
                editTextRegional.getText().clear();
            }
        });
    }

    private void textWatcherRegional(final AutoCompleteTextView editTextRegional, final String regexRegional) {
        editTextRegional.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(DeletionObjectionForm.DELETIONOBJECTION, count + "");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(editTextRegional.getText().toString());
                    sb.charAt(editTextRegional.getSelectionStart() - 1);
                    int selectionStart = editTextRegional.getSelectionStart() - 1;
                    if (editTextRegional.getText().toString().matches(regexRegional)) {
                        sb.deleteCharAt(editTextRegional.getSelectionStart() - 1);
                        editTextRegional.setText(sb);
                        editTextRegional.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d(DeletionObjectionForm.DELETIONOBJECTION, e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.e(DeletionObjectionForm.DELETIONOBJECTION, "");
            }
        });
    }

    private void starMarkerAndRemover() {
        this.binding.textView15.setText(mandatorymarker(this.binding.textView15.getText().toString()));
        this.binding.textView21.setText(mandatorymarker(this.binding.textView21.getText().toString()));
        this.binding.textView22.setText(mandatorymarker(this.binding.textView22.getText().toString()));
        this.binding.villageTv.setText(mandatorymarker(this.binding.villageTv.getText().toString()));
        this.binding.postofficeTv.setText(mandatorymarker(this.binding.postofficeTv.getText().toString()));
        this.binding.textView25.setText(mandatorymarker(this.binding.textView25.getText().toString()));
        this.binding.tehsilTv.setText(mandatorymarker(this.binding.tehsilTv.getText().toString()));
        this.binding.textView32.setText(mandatorymarker(this.binding.textView32.getText().toString()));
        this.binding.stateTv.setText(mandatoryremover(this.binding.stateTv.getText().toString()));
        this.binding.constituencyTv.setText(mandatoryremover(this.binding.constituencyTv.getText().toString()));
        this.binding.textView13.setText(mandatoryremover(this.binding.textView13.getText().toString()));
        this.binding.textView12.setText(mandatoryremover(this.binding.textView12.getText().toString()));
        this.binding.textView9.setText(mandatoryremover(this.binding.textView9.getText().toString()));
        this.binding.districtTv.setText(mandatoryremover(this.binding.districtTv.getText().toString()));
        this.binding.textView17.setText(mandatoryremover(this.binding.textView17.getText().toString()));
        this.binding.textView18.setText(mandatoryremover(this.binding.textView18.getText().toString()));
        this.binding.textView19.setText(mandatoryremover(this.binding.textView19.getText().toString()));
        this.binding.stateTv1.setText(mandatoryremover(this.binding.stateTv1.getText().toString()));
        this.binding.districtTv1.setText(mandatoryremover(this.binding.districtTv1.getText().toString()));
        this.binding.textView31.setText(mandatoryremover(this.binding.textView31.getText().toString()));
    }

    static String getValue(HashMap<String, String> inputMap, String key) {
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if (Objects.equals(entry.getValue(), key)) {
                return entry.getKey();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRefNum(String form7SelfOtherInclusion) {
        Logger.d("form7SelfOtherInclusion ", form7SelfOtherInclusion);
        UserClient retrofitClient = this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd());
        int i = Integer.parseInt(this.acNo);
        String str = this.stateCode;
        retrofitClient.eroRefNumform7(i, str, "G", "7", form7SelfOtherInclusion, "blo", str).enqueue(new AnonymousClass4(form7SelfOtherInclusion));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$form7SelfOtherInclusion;

        AnonymousClass4(final String val$form7SelfOtherInclusion) {
            this.val$form7SelfOtherInclusion = val$form7SelfOtherInclusion;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                DeletionObjectionForm.this.alertDialog.dismiss();
                JsonObject jsonObject = (JsonObject) response.body();
                Logger.d("Reference Id", String.valueOf(jsonObject.get(DeletionObjectionForm.refIdString)));
                DeletionObjectionForm.this.referenceNumber = String.valueOf(jsonObject.get(DeletionObjectionForm.refIdString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                CommomUtility commomUtility = DeletionObjectionForm.this.commonUtilClass;
                Context context = DeletionObjectionForm.this.getContext();
                String str = DeletionObjectionForm.this.token;
                String atknBnd = SharedPref.getInstance(DeletionObjectionForm.this.getContext()).getAtknBnd();
                String rtknBnd = SharedPref.getInstance(DeletionObjectionForm.this.getContext()).getRtknBnd();
                final String str2 = this.val$form7SelfOtherInclusion;
                commomUtility.getReasonForObjection(context, str, atknBnd, rtknBnd, new FormData() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.FormData
                    public final void onCallback(ArrayList arrayList, HashMap map, int i) {
                        this.f$0.lambda$onResponse$2(str2, arrayList, map, i);
                    }
                });
                return;
            }
            DeletionObjectionForm.this.alertDialog.dismiss();
            Logger.d(DeletionObjectionForm.DELETIONOBJECTION, "In getRefNum() -> else part ----> Response Body is null .............................");
            if (response.code() == 401) {
                CommomUtility commomUtility2 = DeletionObjectionForm.this.commonUtilClass;
                Context contextRequireContext = DeletionObjectionForm.this.requireContext();
                String str3 = DeletionObjectionForm.this.refreshToken;
                final String str4 = this.val$form7SelfOtherInclusion;
                commomUtility2.getRefreshToken(contextRequireContext, str3, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$4(str4, i, str5, str6);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("status");
                String strOptString2 = jSONObject.optString("message");
                if (!Objects.equals(strOptString2, null) && strOptString2.isEmpty()) {
                    String strOptString3 = jSONObject.optString("error");
                    DeletionObjectionForm.this.showdialog(DeletionObjectionForm.errorString, strOptString + " - " + strOptString3);
                    Logger.d(DeletionObjectionForm.DELETIONOBJECTION, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString3);
                } else {
                    Logger.d(DeletionObjectionForm.DELETIONOBJECTION, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString2);
                    DeletionObjectionForm.this.showdialog(DeletionObjectionForm.errorString, strOptString + " - " + strOptString2);
                }
            } catch (IOException | JSONException e) {
                Logger.e(DeletionObjectionForm.DELETIONOBJECTION, e.getMessage());
                if (response.code() == 401) {
                    DeletionObjectionForm.this.commonUtilClass.showMessageWithTitleOK(DeletionObjectionForm.this.requireContext(), DeletionObjectionForm.alertString, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$5(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(final String str, ArrayList arrayList, HashMap map, int i) {
            if (i == 401) {
                DeletionObjectionForm.this.commonUtilClass.getRefreshToken(DeletionObjectionForm.this.requireContext(), DeletionObjectionForm.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(str, i2, str2, str3);
                    }
                });
                return;
            }
            DeletionObjectionForm.this.alertDialog.dismiss();
            if (Objects.equals(arrayList, null)) {
                return;
            }
            DeletionObjectionForm.this.rejectionOptions = arrayList;
            DeletionObjectionForm.this.reasonmap = map;
            DeletionObjectionForm.this.rejectionOptions1.clear();
            DeletionObjectionForm.this.rejectionOptions2.clear();
            DeletionObjectionForm.this.rejectionOptions3.clear();
            DeletionObjectionForm.this.reasonCode1.clear();
            DeletionObjectionForm.this.reasonCode2.clear();
            DeletionObjectionForm.this.reasonCode3.clear();
            DeletionObjectionForm.this.rejectionOptions1.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.rejectionOptions2.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.rejectionOptions3.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.rejectionOptions3.add("1");
            DeletionObjectionForm.this.rejectionOptions3.add("2");
            DeletionObjectionForm.this.rejectionOptions3.add("3");
            DeletionObjectionForm.this.reasonCode1.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.reasonCode2.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.reasonCode3.add(DeletionObjectionForm.selectReason);
            DeletionObjectionForm.this.reasonCode3.add("1");
            DeletionObjectionForm.this.reasonCode3.add("2");
            DeletionObjectionForm.this.reasonCode3.add("3");
            for (String str2 : DeletionObjectionForm.this.rejectionOptions) {
                if (str2.contains(DeletionObjectionForm.death)) {
                    DeletionObjectionForm.this.rejectionOptions1.add(str2);
                    DeletionObjectionForm.this.rejectionOptions2.add(str2);
                    DeletionObjectionForm.this.reasonCode1.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode2.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
                if (str2.contains(DeletionObjectionForm.underAge)) {
                    DeletionObjectionForm.this.rejectionOptions1.add(str2);
                    DeletionObjectionForm.this.rejectionOptions2.add(str2);
                    DeletionObjectionForm.this.reasonCode1.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode2.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
                if (str2.contains(DeletionObjectionForm.absentPermanentlyShifted)) {
                    DeletionObjectionForm.this.rejectionOptions1.add(str2);
                    DeletionObjectionForm.this.rejectionOptions2.add(str2);
                    DeletionObjectionForm.this.reasonCode1.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode2.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
                if (str2.contains(DeletionObjectionForm.alreadyEnrolled)) {
                    DeletionObjectionForm.this.rejectionOptions1.add(str2);
                    DeletionObjectionForm.this.rejectionOptions2.add(str2);
                    DeletionObjectionForm.this.rejectionOptions3.set(2, str2);
                    DeletionObjectionForm.this.reasonCode1.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode2.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode3.set(2, (String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
                if (str2.contains(DeletionObjectionForm.notIndianCitizen)) {
                    DeletionObjectionForm.this.rejectionOptions1.add(str2);
                    DeletionObjectionForm.this.rejectionOptions2.add(str2);
                    DeletionObjectionForm.this.rejectionOptions3.set(3, str2);
                    DeletionObjectionForm.this.reasonCode1.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode2.add((String) DeletionObjectionForm.this.reasonmap.get(str2));
                    DeletionObjectionForm.this.reasonCode3.set(3, (String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
                if (str2.equals(DeletionObjectionForm.permanentlyShifted)) {
                    DeletionObjectionForm.this.rejectionOptions3.set(1, str2);
                    DeletionObjectionForm.this.reasonCode3.set(1, (String) DeletionObjectionForm.this.reasonmap.get(str2));
                }
            }
            DeletionObjectionForm.this.spinnerAdapter1 = new CustomSpinnerAdapter(DeletionObjectionForm.this.getContext(), android.R.layout.simple_spinner_item, DeletionObjectionForm.this.rejectionOptions1);
            DeletionObjectionForm.this.spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            DeletionObjectionForm.this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) DeletionObjectionForm.this.spinnerAdapter1);
            DeletionObjectionForm.this.binding.rejectionSpinner1.setSelection(0);
            DeletionObjectionForm.this.spinnerAdapter2 = new CustomSpinnerAdapter(DeletionObjectionForm.this.getContext(), android.R.layout.simple_spinner_item, DeletionObjectionForm.this.rejectionOptions2);
            DeletionObjectionForm.this.spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            DeletionObjectionForm.this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) DeletionObjectionForm.this.spinnerAdapter2);
            DeletionObjectionForm.this.binding.rejectionSpinner2.setSelection(0);
            DeletionObjectionForm.this.spinnerAdapter3 = new CustomSpinnerAdapter(DeletionObjectionForm.this.getContext(), android.R.layout.simple_spinner_item, DeletionObjectionForm.this.rejectionOptions3);
            DeletionObjectionForm.this.spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            DeletionObjectionForm.this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) DeletionObjectionForm.this.spinnerAdapter3);
            DeletionObjectionForm.this.binding.rejectionSpinner3.setSelection(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            DeletionObjectionForm.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                DeletionObjectionForm.this.commonUtilClass.showMessageOK(DeletionObjectionForm.this.getContext(), DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DeletionObjectionForm.this.token = "Bearer " + str2;
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setToken("Bearer " + str2);
            DeletionObjectionForm.this.getRefNum(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setLocaleBool(false);
            DeletionObjectionForm.this.startActivity(new Intent((Context) DeletionObjectionForm.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(String str, int i, String str2, String str3) {
            DeletionObjectionForm.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                DeletionObjectionForm.this.commonUtilClass.showMessageOK(DeletionObjectionForm.this.getContext(), DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$3(dialogInterface, i2);
                    }
                });
                return;
            }
            DeletionObjectionForm.this.token = "Bearer " + str2;
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setToken("Bearer " + str2);
            DeletionObjectionForm.this.getRefNum(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setLocaleBool(false);
            DeletionObjectionForm.this.startActivity(new Intent((Context) DeletionObjectionForm.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DeletionObjectionForm.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DeletionObjectionForm.this.getContext()).setLocaleBool(false);
            DeletionObjectionForm.this.startActivity(new Intent((Context) DeletionObjectionForm.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            DeletionObjectionForm.this.alertDialog.dismiss();
            Logger.e(DeletionObjectionForm.DELETIONOBJECTION, "In onFailure of Reference Api");
        }
    }

    public void getByEpicForFormSelf(JsonArray applicantEpicDetailsArray) {
        Logger.d(DELETIONOBJECTION, "in getForm7byEpic..............................");
        for (int i = 0; i < applicantEpicDetailsArray.size(); i++) {
            JsonObject jsonObject = applicantEpicDetailsArray.get(i).get("content");
            if (jsonObject.get("partNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(this.partNumberOfPersonToBeDeleted) && jsonObject.get(partSerialNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(this.serialNumberOfPersonToBeDeleted)) {
                this.age = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.gender = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.firstNameApplicant = jsonObject.get("applicantFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                String strReplace = jsonObject.get("applicantLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.lastNameApplicant = strReplace;
                if (strReplace.equals("null") || this.lastNameApplicant.isEmpty()) {
                    this.binding.firstNameEd.setText(this.firstNameApplicant);
                } else {
                    this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
                }
                this.binding.epicEd.setText(jsonObject.get(epicNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " "));
                String strReplace2 = String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (strReplace2.isEmpty() || strReplace2.equals("null")) {
                    this.binding.mobileNumEd.setText("");
                    this.mobileforReset = "";
                } else {
                    if (strReplace2.startsWith("+91-")) {
                        strReplace2 = strReplace2.substring(4);
                    } else if (strReplace2.startsWith("+91")) {
                        strReplace2 = strReplace2.substring(3);
                    }
                    this.binding.mobileNumEd.setText(strReplace2);
                }
                this.mobileforReset = this.binding.mobileNumEd.getText().toString();
                this.serialNumberApplicant = jsonObject.get(partSerialNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.sectionNoApplicant = jsonObject.get("sectionNo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
            }
        }
        Logger.d(DELETIONOBJECTION, "in getForm7byEpic........................Data Updated");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getByEpicForFormSelf$4();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getByEpicForFormSelf$4() {
        this.alertDialog.dismiss();
    }

    public void getByEpicForForm(JsonArray applicantEpicDetailsArray) {
        Logger.d(DELETIONOBJECTION, "in getForm7byEpic..............................");
        for (int i = 0; i < applicantEpicDetailsArray.size(); i++) {
            JsonObject jsonObject = applicantEpicDetailsArray.get(i).get("content");
            if (jsonObject.get("partNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(this.partNumberApplicant) && jsonObject.get(partSerialNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ").equals(this.serialNumberApplicant)) {
                this.age = String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.gender = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.firstNameApplicant = jsonObject.get("applicantFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                String strReplace = jsonObject.get("applicantLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.lastNameApplicant = strReplace;
                if (strReplace.equals("null") || this.lastNameApplicant.isEmpty()) {
                    this.binding.firstNameEd.setText(this.firstNameApplicant);
                } else {
                    this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
                }
                this.binding.epicEd.setText(jsonObject.get(epicNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " "));
                String strReplace2 = String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                if (strReplace2.isEmpty() || strReplace2.equals("null")) {
                    this.binding.mobileNumEd.setText("");
                    this.mobileforReset = "";
                } else {
                    if (strReplace2.startsWith("+91-")) {
                        strReplace2 = strReplace2.substring(4);
                    } else if (strReplace2.startsWith("+91")) {
                        strReplace2 = strReplace2.substring(3);
                    }
                    this.binding.mobileNumEd.setText(strReplace2);
                }
                this.mobileforReset = this.binding.mobileNumEd.getText().toString();
                this.serialNumberApplicant = jsonObject.get(partSerialNumberString).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                this.sectionNoApplicant = jsonObject.get("sectionNo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
            }
        }
        Logger.d(DELETIONOBJECTION, "in getForm7byEpic........................Data Updated");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getByEpicForForm$5();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getByEpicForForm$5() {
        this.alertDialog.dismiss();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$5] */
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
                } catch (Exception e) {
                    Logger.e(DELETIONOBJECTION, e.getMessage());
                    inputStreamOpenRawResource.close();
                    stringWriter.flush();
                    stringWriter.close();
                }
                List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm.5
                }.getType());
                DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().insertStates((TState[]) list.toArray(new TState[list.size()]));
            } catch (Throwable th3) {
                try {
                    inputStreamOpenRawResource.close();
                    stringWriter.flush();
                    stringWriter.close();
                } catch (Exception e2) {
                    Logger.e(DELETIONOBJECTION, e2.getMessage());
                }
                throw th3;
            }
        } catch (Exception e3) {
            Logger.e(DELETIONOBJECTION, e3.getMessage());
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
                    Logger.e(DELETIONOBJECTION, e.getMessage());
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
                    Logger.e(DELETIONOBJECTION, e2.getMessage());
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
                    Logger.e(DELETIONOBJECTION, e3.getMessage());
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
                    Logger.e(DELETIONOBJECTION, e4.getMessage());
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
                Logger.e(DELETIONOBJECTION, e5.getMessage());
            }
        }
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
        this.binding.selectStateLayout.setOnClickListener(this);
        this.binding.personalDetailLayout.setOnClickListener(this);
        this.binding.rejectionOptionsLayout.setOnClickListener(this);
        this.binding.personDetailsLayout.setOnClickListener(this);
        this.binding.declarationLayout.setOnClickListener(this);
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.homeBtnIv.setOnClickListener(this);
        this.binding.saveNextTv.setOnClickListener(this);
        this.binding.previousTv.setOnClickListener(this);
        this.binding.resetTv.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131365655) {
            tab1();
        }
        if (v.getId() == 2131365122) {
            tab2();
        }
        if (v.getId() == 2131365358) {
            tab3();
        }
        if (v.getId() == 2131365109) {
            tab4();
        }
        if (v.getId() == 2131363077) {
            tab5();
        }
        if (v.getId() == 2131362458) {
            if (this.formOrigin.equals("NEW")) {
                Intent intent = new Intent((Context) getActivity(), (Class<?>) VoterForms.class);
                intent.setFlags(268468224);
                startActivity(intent);
            } else {
                requireActivity().finish();
            }
        }
        if (v.getId() == 2131364065) {
            Intent intent2 = new Intent(requireContext(), (Class<?>) MainActivity.class);
            intent2.setFlags(268468224);
            startActivity(intent2);
        }
        if (v.getId() == 2131365248) {
            prevFragment();
        }
        if (v.getId() == 2131365497) {
            if (this.currentSelectedView == this.binding.personalDetailLayout) {
                this.binding.mobileNumEd.setText(this.mobileforReset);
            } else if (this.currentSelectedView == this.binding.rejectionOptionsLayout) {
                this.binding.rejectionOptionsRg.clearCheck();
                this.binding.rejectionSpinnerLayout1.setVisibility(8);
                this.binding.rejectionSpinnerLayout2.setVisibility(8);
                this.binding.rejectionSpinnerLayout3.setVisibility(8);
                this.binding.rejectionSpinner1.setSelection(0);
                this.binding.rejectionSpinner2.setSelection(0);
                this.binding.rejectionSpinner3.setSelection(0);
                this.binding.deathCertificateReg.clearCheck();
                this.binding.upload.setVisibility(8);
                this.binding.uploadSpecifications.setVisibility(8);
                this.binding.uploadLayout.setVisibility(8);
            } else if (this.currentSelectedView == this.binding.personDetailsLayout) {
                this.binding.houseEd.setText("");
                this.binding.houseEd2.setText("");
                this.binding.streetEd.setText("");
                this.binding.streetEd2.setText("");
                this.binding.villageEd.setText("");
                this.binding.villageEd2.setText("");
                this.binding.postofficeEd.setText("");
                this.binding.postofficeEd2.setText("");
                this.binding.pincodeEd.setText("");
                this.binding.tehsilEd.setText("");
                this.binding.tehsilEd2.setText("");
            }
        }
        if (v.getId() == 2131365561) {
            nextFragment();
        }
    }

    private void initClickListener() {
        this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$6(View view) {
        this.binding.preview.setVisibility(8);
        this.binding.chooseFileItems.setVisibility(4);
        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
    }

    private void dataoneditbutton(String name, String date, String formtype) {
        this.viewModel.dataoneditbutton(name, date, formtype).observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda22
            public final void onChanged(Object obj) {
                this.f$0.lambda$dataoneditbutton$7((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dataoneditbutton$7(List list) {
        if (list.size() != 0) {
            String state = ((DeletionObjectionDraftModel) list.get(0)).getState();
            String personal = ((DeletionObjectionDraftModel) list.get(0)).getPersonal();
            String rejection = ((DeletionObjectionDraftModel) list.get(0)).getRejection();
            String requestdetails = ((DeletionObjectionDraftModel) list.get(0)).getRequestdetails();
            int i = Integer.parseInt(((DeletionObjectionDraftModel) list.get(0)).getStepseq());
            this.referenceNumber = ((DeletionObjectionDraftModel) list.get(0)).getReference();
            edit(state, personal, rejection, requestdetails, i, ((DeletionObjectionDraftModel) list.get(0)).getPhoto());
        }
    }

    private void edit(final String statedata, final String personaldata, final String rejectiondata, final String requestdetailsdata, final int stepseq, final byte[] photo) {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i2;
        if (stepseq == 2) {
            this.currentSelectedView = this.binding.rejectionOptionsLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 875, this.binding.horizontal.getScrollY());
            String[] strArrSplit = statedata.split(this.delimeter);
            this.binding.stateEd.setText(strArrSplit[0]);
            this.binding.districtEd.setText(strArrSplit[1]);
            this.binding.constituencynoEd.setText(strArrSplit[2]);
            this.binding.constituencyEd.setText(strArrSplit[3]);
            this.serialNumberApplicant = strArrSplit[4];
            this.serialNumberOfPersonToBeDeleted = strArrSplit[5];
            this.sectionNoApplicant = strArrSplit[6];
            this.partNumberOfPersonToBeDeleted = strArrSplit[7];
            try {
                this.objectToInclFormRefNum = strArrSplit[8];
                this.objectToInclFormType = strArrSplit[9];
            } catch (Exception e) {
                Logger.e(DELETIONOBJECTION, e.getMessage());
            }
            this.binding.deletionObjectionFormLayout.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit2 = personaldata.split(this.delimeter);
            this.firstNameApplicant = strArrSplit2[0];
            this.lastNameApplicant = strArrSplit2[1];
            this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
            this.binding.epicEd.setText(strArrSplit2[2]);
            if (strArrSplit2[3].equals("Self")) {
                this.binding.self.setChecked(true);
            } else {
                this.binding.relative.setChecked(true);
            }
            if (strArrSplit2[4].equals("NA")) {
                this.binding.mobileNumEd.setText("");
            } else {
                this.binding.mobileNumEd.setText(strArrSplit2[4]);
            }
            this.age = strArrSplit2[5];
            this.gender = strArrSplit2[6];
            String[] strArrSplit3 = requestdetailsdata.split(this.delimeter);
            this.binding.nameEd.setText(strArrSplit3[0]);
            this.binding.surNameEd2.setText(strArrSplit3[1]);
            this.binding.epicEd2.setText(strArrSplit3[2]);
            this.binding.districtEd1.setText(strArrSplit3[3]);
            this.binding.stateEd1.setText(strArrSplit3[4]);
            this.rejectionOptions = new ArrayList<>();
            this.reasonmap = new HashMap<>();
            this.rejectionOptions1 = new ArrayList<>();
            this.rejectionOptions2 = new ArrayList<>();
            this.rejectionOptions3 = new ArrayList<>();
            this.reasonCode1 = new ArrayList<>();
            this.reasonCode2 = new ArrayList<>();
            this.reasonCode3 = new ArrayList<>();
            this.commonUtilClass.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda15
                @Override // in.gov.eci.bloapp.FormData
                public final void onCallback(ArrayList arrayList, HashMap map, int i3) {
                    this.f$0.lambda$edit$10(statedata, personaldata, rejectiondata, requestdetailsdata, stepseq, photo, arrayList, map, i3);
                }
            });
            this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
            try {
                String[] strArrSplit4 = rejectiondata.split(this.delimeter);
                String str = strArrSplit4[0];
                this.rejectionOption = str;
                if (str.equals(otherDeletionString)) {
                    this.binding.optionRb1.setChecked(true);
                    this.binding.optionRb2.setEnabled(false);
                    this.binding.optionRb3.setEnabled(false);
                    this.request = OTHERSTRING;
                } else if (strArrSplit4[0].equals(inclusionString)) {
                    this.binding.optionRb2.setChecked(true);
                    this.binding.optionRb1.setEnabled(false);
                    this.binding.optionRb3.setEnabled(false);
                    this.request = objection;
                } else if (strArrSplit4[0].equals(selfDeletionString)) {
                    this.binding.optionRb3.setChecked(true);
                    this.binding.optionRb2.setEnabled(false);
                    this.binding.optionRb1.setEnabled(false);
                    this.request = "same";
                }
            } catch (Exception e2) {
                Logger.e(DELETIONOBJECTION, e2.getMessage());
            }
            this.binding.personalDetailsFormLayout.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.rejectionOptionsFormLayout.setVisibility(0);
            this.binding.rejectionOptionsLayout.setEnabled(true);
            this.binding.previousTv.setTextColor(Color.parseColor(this.colorStringBlue));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            return;
        }
        if (stepseq == 3) {
            String[] strArrSplit5 = rejectiondata.split(this.delimeter);
            this.rejectionOption = strArrSplit5[0];
            this.rejectionOptionSubcategory = strArrSplit5[1];
            this.rejectionOptions = new ArrayList<>();
            this.reasonmap = new HashMap<>();
            this.rejectionOptions1 = new ArrayList<>();
            this.rejectionOptions2 = new ArrayList<>();
            this.rejectionOptions3 = new ArrayList<>();
            this.reasonCode1 = new ArrayList<>();
            this.reasonCode2 = new ArrayList<>();
            this.reasonCode3 = new ArrayList<>();
            this.commonUtilClass.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda16
                @Override // in.gov.eci.bloapp.FormData
                public final void onCallback(ArrayList arrayList, HashMap map, int i3) {
                    this.f$0.lambda$edit$13(statedata, personaldata, rejectiondata, requestdetailsdata, stepseq, photo, arrayList, map, i3);
                }
            });
            this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
            this.currentSelectedView = this.binding.personDetailsLayout;
            String[] strArrSplit6 = statedata.split(this.delimeter);
            this.binding.stateEd.setText(strArrSplit6[0]);
            this.binding.districtEd.setText(strArrSplit6[1]);
            this.binding.constituencynoEd.setText(strArrSplit6[2]);
            this.binding.constituencyEd.setText(strArrSplit6[3]);
            this.serialNumberApplicant = strArrSplit6[4];
            this.serialNumberOfPersonToBeDeleted = strArrSplit6[5];
            this.sectionNoApplicant = strArrSplit6[6];
            this.partNumberOfPersonToBeDeleted = strArrSplit6[7];
            try {
                this.objectToInclFormRefNum = strArrSplit6[8];
                this.objectToInclFormType = strArrSplit6[9];
            } catch (Exception e3) {
                Logger.e(DELETIONOBJECTION, e3.getMessage());
            }
            this.binding.deletionObjectionFormLayout.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit7 = personaldata.split(this.delimeter);
            this.firstNameApplicant = strArrSplit7[0];
            this.lastNameApplicant = strArrSplit7[1];
            this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
            this.binding.epicEd.setText(strArrSplit7[2]);
            if (strArrSplit7[3].equals("Self")) {
                this.binding.self.setChecked(true);
            } else {
                this.binding.relative.setChecked(true);
            }
            if (strArrSplit7[4].equals("NA")) {
                this.binding.mobileNumEd.setText("");
            } else {
                this.binding.mobileNumEd.setText(strArrSplit7[4]);
            }
            this.age = strArrSplit7[5];
            this.gender = strArrSplit7[6];
            this.binding.personalDetailsFormLayout.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsFormLayout.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.colorStringBlue));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.rejectionOptionsLayout.setEnabled(true);
            this.binding.personDetailsLayout.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1900, this.binding.horizontal.getScrollY());
            if (strArrSplit5[0].equals(otherDeletionString)) {
                this.binding.optionRb1.setChecked(true);
                this.binding.optionRb2.setEnabled(false);
                this.binding.optionRb3.setEnabled(false);
                this.request = OTHERSTRING;
            } else if (strArrSplit5[0].equals(inclusionString)) {
                this.binding.optionRb2.setChecked(true);
                this.binding.optionRb1.setEnabled(false);
                this.binding.optionRb3.setEnabled(false);
                this.request = objection;
            } else if (strArrSplit5[0].equals(selfDeletionString)) {
                this.binding.optionRb3.setChecked(true);
                this.binding.optionRb2.setEnabled(false);
                this.binding.optionRb1.setEnabled(false);
                this.request = "same";
            }
            if (strArrSplit5[2].equals("Yes")) {
                this.binding.yesRg.setChecked(true);
                if (strArrSplit5[3].contains(".pdf")) {
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    bArr2 = photo;
                    i2 = 0;
                } else {
                    bArr2 = photo;
                    i2 = 0;
                    this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                }
                this.binding.chooseFileItems.setVisibility(i2);
                this.binding.upload.setVisibility(i2);
                this.binding.uploadSpecifications.setVisibility(i2);
                this.binding.uploadLayout.setVisibility(i2);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                this.binding.selectName.setText(strArrSplit5[3]);
                this.binding.selectSize.setText(strArrSplit5[4]);
                this.docref = strArrSplit5[5];
                this.certificateName = strArrSplit5[3];
                this.byteArray = bArr2;
            } else {
                this.binding.noRg.setChecked(true);
                this.binding.upload.setVisibility(8);
                this.binding.uploadSpecifications.setVisibility(8);
                this.binding.uploadLayout.setVisibility(8);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            }
            String[] strArrSplit8 = requestdetailsdata.split(this.delimeter);
            this.binding.nameEd.setText(strArrSplit8[0]);
            this.binding.surNameEd2.setText(strArrSplit8[1]);
            this.binding.epicEd2.setText(strArrSplit8[2]);
            this.binding.districtEd1.setText(strArrSplit6[1]);
            this.binding.stateEd1.setText(strArrSplit6[0]);
            this.binding.nameEd.setEnabled(false);
            this.binding.surNameEd2.setEnabled(false);
            this.binding.epicEd2.setEnabled(false);
            this.binding.districtEd1.setEnabled(false);
            this.binding.stateEd1.setEnabled(false);
            this.binding.personDetailsFormLayout.setVisibility(0);
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            return;
        }
        if (stepseq == 4) {
            String[] strArrSplit9 = rejectiondata.split(this.delimeter);
            this.rejectionOption = strArrSplit9[0];
            this.rejectionOptionSubcategory = strArrSplit9[1];
            this.rejectionOptions = new ArrayList<>();
            this.reasonmap = new HashMap<>();
            this.rejectionOptions1 = new ArrayList<>();
            this.rejectionOptions2 = new ArrayList<>();
            this.rejectionOptions3 = new ArrayList<>();
            this.reasonCode1 = new ArrayList<>();
            this.reasonCode2 = new ArrayList<>();
            this.reasonCode3 = new ArrayList<>();
            this.commonUtilClass.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda17
                @Override // in.gov.eci.bloapp.FormData
                public final void onCallback(ArrayList arrayList, HashMap map, int i3) {
                    this.f$0.lambda$edit$16(statedata, personaldata, rejectiondata, requestdetailsdata, stepseq, photo, arrayList, map, i3);
                }
            });
            this.binding.rejectionSpinner1.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner2.setOnItemSelectedListener(this);
            this.binding.rejectionSpinner3.setOnItemSelectedListener(this);
            this.currentSelectedView = this.binding.declarationLayout;
            String[] strArrSplit10 = statedata.split(this.delimeter);
            this.binding.stateEd.setText(strArrSplit10[0]);
            this.binding.districtEd.setText(strArrSplit10[1]);
            this.binding.constituencynoEd.setText(strArrSplit10[2]);
            this.binding.constituencyEd.setText(strArrSplit10[3]);
            this.serialNumberApplicant = strArrSplit10[4];
            this.serialNumberOfPersonToBeDeleted = strArrSplit10[5];
            this.sectionNoApplicant = strArrSplit10[6];
            this.partNumberOfPersonToBeDeleted = strArrSplit10[7];
            try {
                this.objectToInclFormRefNum = strArrSplit10[8];
                this.objectToInclFormType = strArrSplit10[9];
            } catch (Exception e4) {
                Logger.e(DELETIONOBJECTION, e4.getMessage());
            }
            this.binding.deletionObjectionFormLayout.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit11 = personaldata.split(this.delimeter);
            this.firstNameApplicant = strArrSplit11[0];
            this.lastNameApplicant = strArrSplit11[1];
            this.binding.firstNameEd.setText(this.firstNameApplicant + " " + this.lastNameApplicant);
            this.binding.epicEd.setText(strArrSplit11[2]);
            if (strArrSplit11[3].equals("Self")) {
                this.binding.self.setChecked(true);
            } else {
                this.binding.relative.setChecked(true);
            }
            if (strArrSplit11[4].equals("NA")) {
                this.binding.mobileNumEd.setText("");
            } else {
                this.binding.mobileNumEd.setText(strArrSplit11[4]);
            }
            this.age = strArrSplit11[5];
            this.gender = strArrSplit11[6];
            this.binding.personalDetailsFormLayout.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsFormLayout.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.colorStringBlue));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.rejectionOptionsLayout.setEnabled(true);
            this.binding.personDetailsLayout.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1900, this.binding.horizontal.getScrollY());
            if (strArrSplit9[0].equals(otherDeletionString)) {
                this.binding.optionRb1.setChecked(true);
                this.binding.optionRb2.setEnabled(false);
                this.binding.optionRb3.setEnabled(false);
                this.request = OTHERSTRING;
            } else if (strArrSplit9[0].equals(inclusionString)) {
                this.binding.optionRb2.setChecked(true);
                this.binding.optionRb1.setEnabled(false);
                this.binding.optionRb3.setEnabled(false);
                this.request = objection;
            } else if (strArrSplit9[0].equals(selfDeletionString)) {
                this.binding.optionRb3.setChecked(true);
                this.binding.optionRb2.setEnabled(false);
                this.binding.optionRb1.setEnabled(false);
                this.request = "same";
            }
            if (strArrSplit9[2].equals("Yes")) {
                this.binding.yesRg.setChecked(true);
                if (strArrSplit9[3].contains(".pdf")) {
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    bArr = photo;
                    i = 0;
                } else {
                    bArr = photo;
                    i = 0;
                    this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                this.binding.chooseFileItems.setVisibility(i);
                this.binding.selectName.setText(strArrSplit9[3]);
                this.binding.selectSize.setText(strArrSplit9[4]);
                this.docref = strArrSplit9[5];
                this.certificateName = strArrSplit9[3];
                this.byteArray = bArr;
                this.binding.upload.setVisibility(0);
                this.binding.uploadSpecifications.setVisibility(0);
                this.binding.uploadLayout.setVisibility(0);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
            } else {
                this.binding.noRg.setChecked(true);
                this.binding.upload.setVisibility(8);
                this.binding.uploadSpecifications.setVisibility(8);
                this.binding.uploadLayout.setVisibility(8);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            }
            String[] strArrSplit12 = requestdetailsdata.split(this.delimeter);
            this.binding.nameEd.setText(strArrSplit12[0]);
            this.binding.surNameEd2.setText(strArrSplit12[1]);
            this.binding.epicEd2.setText(strArrSplit12[2]);
            this.binding.houseEd.setText(strArrSplit12[3]);
            this.binding.streetEd.setText(strArrSplit12[4]);
            this.binding.villageEd.setText(strArrSplit12[5]);
            this.binding.postofficeEd.setText(strArrSplit12[6]);
            this.binding.pincodeEd.setText(strArrSplit12[7]);
            this.binding.tehsilEd.setText(strArrSplit12[8]);
            this.binding.districtEd1.setText(strArrSplit10[1]);
            this.binding.stateEd1.setText(strArrSplit10[0]);
            this.binding.houseEd2.setText(strArrSplit12[11]);
            this.binding.streetEd2.setText(strArrSplit12[12]);
            this.binding.villageEd2.setText(strArrSplit12[13]);
            this.binding.postofficeEd2.setText(strArrSplit12[14]);
            this.binding.tehsilEd2.setText(strArrSplit12[15]);
            this.binding.nameEd.setEnabled(false);
            this.binding.surNameEd2.setEnabled(false);
            this.binding.epicEd2.setEnabled(false);
            this.binding.districtEd1.setEnabled(false);
            this.binding.stateEd1.setEnabled(false);
            this.binding.issueDateEd.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
            if (!this.binding.issueDateEd.getText().toString().isEmpty()) {
                this.binding.declarationLayout.setEnabled(true);
            }
            this.binding.personDetailsFormLayout.setVisibility(8);
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.declarationFormLayout.setVisibility(0);
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$10(final String str, final String str2, final String str3, final String str4, final int i, final byte[] bArr, ArrayList arrayList, HashMap map, int i2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda20
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str5, String str6) {
                    this.f$0.lambda$edit$9(str, str2, str3, str4, i, bArr, i3, str5, str6);
                }
            });
            return;
        }
        this.rejectionOptions = arrayList;
        this.reasonmap = map;
        this.rejectionOptions1.clear();
        this.rejectionOptions2.clear();
        this.rejectionOptions3.clear();
        this.reasonCode1.clear();
        this.reasonCode2.clear();
        this.reasonCode3.clear();
        this.rejectionOptions1.add(selectReason);
        this.rejectionOptions2.add(selectReason);
        this.rejectionOptions3.add(selectReason);
        this.rejectionOptions3.add("1");
        this.rejectionOptions3.add("2");
        this.rejectionOptions3.add("3");
        this.reasonCode1.add(selectReason);
        this.reasonCode2.add(selectReason);
        this.reasonCode3.add(selectReason);
        this.reasonCode3.add("1");
        this.reasonCode3.add("2");
        this.reasonCode3.add("3");
        for (String str5 : this.rejectionOptions) {
            if (str5.contains(death)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(underAge)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(absentPermanentlyShifted)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(alreadyEnrolled)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(2, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(2, this.reasonmap.get(str5));
            }
            if (str5.contains(notIndianCitizen)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(3, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(3, this.reasonmap.get(str5));
            }
            if (str5.equals(permanentlyShifted)) {
                this.rejectionOptions3.set(1, str5);
                this.reasonCode3.set(1, this.reasonmap.get(str5));
            }
        }
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions1);
        this.spinnerAdapter1 = customSpinnerAdapter;
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) this.spinnerAdapter1);
        this.binding.rejectionSpinner1.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions2);
        this.spinnerAdapter2 = customSpinnerAdapter2;
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) this.spinnerAdapter2);
        this.binding.rejectionSpinner2.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions3);
        this.spinnerAdapter3 = customSpinnerAdapter3;
        customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) this.spinnerAdapter3);
        this.binding.rejectionSpinner3.setSelection(0);
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$9(String str, String str2, String str3, String str4, int i, byte[] bArr, int i2, String str5, String str6) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i2 + " " + str5 + " " + str6);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$8(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str5;
        SharedPref.getInstance(requireContext()).setRefreshToken(str6);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str5);
        edit(str, str2, str3, str4, i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$13(final String str, final String str2, final String str3, final String str4, final int i, final byte[] bArr, ArrayList arrayList, HashMap map, int i2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda3
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str5, String str6) {
                    this.f$0.lambda$edit$12(str, str2, str3, str4, i, bArr, i3, str5, str6);
                }
            });
            return;
        }
        System.out.println();
        this.rejectionOptions = arrayList;
        this.reasonmap = map;
        this.rejectionOptions1.clear();
        this.rejectionOptions2.clear();
        this.rejectionOptions3.clear();
        this.reasonCode1.clear();
        this.reasonCode2.clear();
        this.reasonCode3.clear();
        this.rejectionOptions1.add(selectReason);
        this.rejectionOptions2.add(selectReason);
        this.rejectionOptions3.add(selectReason);
        this.rejectionOptions3.add("1");
        this.rejectionOptions3.add("2");
        this.rejectionOptions3.add("3");
        this.reasonCode1.add(selectReason);
        this.reasonCode2.add(selectReason);
        this.reasonCode3.add(selectReason);
        this.reasonCode3.add("1");
        this.reasonCode3.add("2");
        this.reasonCode3.add("3");
        for (String str5 : this.rejectionOptions) {
            if (str5.contains(death)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(underAge)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(absentPermanentlyShifted)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(alreadyEnrolled)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(2, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(2, this.reasonmap.get(str5));
            }
            if (str5.contains(notIndianCitizen)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(3, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(3, this.reasonmap.get(str5));
            }
            if (str5.equals(permanentlyShifted)) {
                this.rejectionOptions3.set(1, str5);
                this.reasonCode3.set(1, this.reasonmap.get(str5));
            }
        }
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions1);
        this.spinnerAdapter1 = customSpinnerAdapter;
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) this.spinnerAdapter1);
        this.binding.rejectionSpinner1.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions2);
        this.spinnerAdapter2 = customSpinnerAdapter2;
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) this.spinnerAdapter2);
        this.binding.rejectionSpinner2.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions3);
        this.spinnerAdapter3 = customSpinnerAdapter3;
        customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) this.spinnerAdapter3);
        this.binding.rejectionSpinner3.setSelection(0);
        this.binding.deathLayout.setVisibility(8);
        if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner1.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner1.setSelection(2);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner1.setSelection(3);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner1.setSelection(4);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner1.setSelection(5);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner2.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner2.setSelection(2);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner2.setSelection(3);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner2.setSelection(4);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner2.setSelection(5);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(permanentlyShifted)) {
            this.binding.rejectionSpinner3.setSelection(1);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner3.setSelection(2);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner3.setSelection(3);
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$12(String str, String str2, String str3, String str4, int i, byte[] bArr, int i2, String str5, String str6) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i2 + " " + str5 + " " + str6);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$11(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str5;
        SharedPref.getInstance(requireContext()).setRefreshToken(str6);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str5);
        edit(str, str2, str3, str4, i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$11(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$16(final String str, final String str2, final String str3, final String str4, final int i, final byte[] bArr, ArrayList arrayList, HashMap map, int i2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str5, String str6) {
                    this.f$0.lambda$edit$15(str, str2, str3, str4, i, bArr, i3, str5, str6);
                }
            });
            return;
        }
        this.rejectionOptions = arrayList;
        this.reasonmap = map;
        this.rejectionOptions1.clear();
        this.rejectionOptions2.clear();
        this.rejectionOptions3.clear();
        this.reasonCode1.clear();
        this.reasonCode2.clear();
        this.reasonCode3.clear();
        this.rejectionOptions1.add(selectReason);
        this.rejectionOptions2.add(selectReason);
        this.rejectionOptions3.add(selectReason);
        this.rejectionOptions3.add("1");
        this.rejectionOptions3.add("2");
        this.rejectionOptions3.add("3");
        this.reasonCode1.add(selectReason);
        this.reasonCode2.add(selectReason);
        this.reasonCode3.add(selectReason);
        this.reasonCode3.add("1");
        this.reasonCode3.add("2");
        this.reasonCode3.add("3");
        for (String str5 : this.rejectionOptions) {
            if (str5.contains(death)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(underAge)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(absentPermanentlyShifted)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
            }
            if (str5.contains(alreadyEnrolled)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(2, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(2, this.reasonmap.get(str5));
            }
            if (str5.contains(notIndianCitizen)) {
                this.rejectionOptions1.add(str5);
                this.rejectionOptions2.add(str5);
                this.rejectionOptions3.set(3, str5);
                this.reasonCode1.add(this.reasonmap.get(str5));
                this.reasonCode2.add(this.reasonmap.get(str5));
                this.reasonCode3.set(3, this.reasonmap.get(str5));
            }
            if (str5.equals(permanentlyShifted)) {
                this.rejectionOptions3.set(1, str5);
                this.reasonCode3.set(1, this.reasonmap.get(str5));
            }
        }
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions1);
        this.spinnerAdapter1 = customSpinnerAdapter;
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) this.spinnerAdapter1);
        this.binding.rejectionSpinner1.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions2);
        this.spinnerAdapter2 = customSpinnerAdapter2;
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) this.spinnerAdapter2);
        this.binding.rejectionSpinner2.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions3);
        this.spinnerAdapter3 = customSpinnerAdapter3;
        customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) this.spinnerAdapter3);
        this.binding.rejectionSpinner3.setSelection(0);
        this.binding.deathLayout.setVisibility(8);
        if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner1.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner1.setSelection(2);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner1.setSelection(3);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner1.setSelection(4);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner1.setSelection(5);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner2.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner2.setSelection(2);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner2.setSelection(3);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner2.setSelection(4);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner2.setSelection(5);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(permanentlyShifted)) {
            this.binding.rejectionSpinner3.setSelection(1);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner3.setSelection(2);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner3.setSelection(3);
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$15(String str, String str2, String str3, String str4, int i, byte[] bArr, int i2, String str5, String str6) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i2 + " " + str5 + " " + str6);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda21
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$14(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str5;
        SharedPref.getInstance(requireContext()).setRefreshToken(str6);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str5);
        edit(str, str2, str3, str4, i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$14(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    public void updateData() {
        this.viewModel.updateData(this.rejectionOption, this.rejectionOptionSubcategory, this.dbfetchepic, this.binding.issueDateEd.getText().toString(), this.binding.placeEd.getText().toString(), this.byteArray, this.referenceNumber, this.createdOn, "Opened", this.form7);
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
            } catch (Exception e) {
                Logger.e(DELETIONOBJECTION, e.getMessage());
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
                    this.certificateName = string;
                    this.certificateSize = this.filesize + "KB";
                    this.binding.selectSize.setText(this.filesize + "KB");
                    ImageView imageView = this.binding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    saveimageapi(this.saveImageFileName);
                    return;
                }
                if (this.filesize > 2048) {
                    this.alertDialog.dismiss();
                    showdialog(alertString, "Image size exceeds the limit of 2MB, Please retry.");
                    return;
                }
                float f = this.filesize / 1024.0f;
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileItems.setVisibility(0);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                this.binding.selectName.setText(string);
                this.certificateName = string;
                this.certificateSize = String.format("%.2f", Float.valueOf(f)) + "MB";
                this.binding.selectSize.setText(String.format("%.2f", Float.valueOf(f)) + "MB");
                ImageView imageView2 = this.binding.preview;
                byte[] bArr2 = this.byteArray;
                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                saveimageapi(this.saveImageFileName);
            } catch (Exception e2) {
                Logger.d(DELETIONOBJECTION, e2.getMessage());
                string = "";
            }
        } else {
            this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$17(ActivityResult activityResult) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        if (activityResult.getResultCode() == -1) {
            Uri data = activityResult.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(data);
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
                    } catch (Exception e) {
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        Logger.d(DELETIONOBJECTION, e.getMessage());
                        byteArrayOutputStream = byteArrayOutputStream2;
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.byteArray = byteArray;
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf"), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                }
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (!string.contains(".pdf")) {
                    showdialog("", "Please Select the correct format of file");
                } else if (this.filesize < 1024) {
                    double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                    this.binding.preview.setVisibility(0);
                    this.binding.chooseFileItems.setVisibility(0);
                    this.binding.selectName.setText(string);
                    this.certificateName = string;
                    this.certificateSize = dRound + "KB";
                    this.binding.selectSize.setText(dRound + "KB");
                    this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    saveimageapi(this.saveImageFileName);
                } else {
                    double dRound2 = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                    if (dRound2 > 3.0d) {
                        showdialog(alertString, "PDF size exceeded 3MB limit.");
                    } else {
                        this.binding.preview.setVisibility(0);
                        this.binding.chooseFileItems.setVisibility(0);
                        this.binding.selectName.setText(string);
                        this.certificateSize = dRound2 + "MB";
                        this.certificateName = string;
                        this.binding.selectSize.setText(dRound2 + "MB");
                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                        this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        saveimageapi(this.saveImageFileName);
                    }
                }
                cursorQuery.close();
            } catch (Exception e3) {
                Logger.d("CONTENT", e3.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveimageapi(String captureFileName) {
        this.alertDialog.show();
        Logger.d(DELETIONOBJECTION, "in image upload api..............................");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), this.referenceNumber + "_document");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.acNo, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.appName, MediaType.parse("appName"))).enqueue(new AnonymousClass6(captureFileName));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$captureFileName;

        AnonymousClass6(final String val$captureFileName) {
            this.val$captureFileName = val$captureFileName;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.isSuccessful()) {
                Logger.d(DeletionObjectionForm.DELETIONOBJECTION, "Success_Uploaded");
                JsonElement jsonElement = ((JsonObject) response.body()).get(DeletionObjectionForm.refIdString);
                DeletionObjectionForm.this.docref = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("document ", DeletionObjectionForm.this.docref);
                DeletionObjectionForm.this.alertDialog.dismiss();
                return;
            }
            DeletionObjectionForm.this.alertDialog.dismiss();
            if (response.code() == 401) {
                CommomUtility commomUtility = DeletionObjectionForm.this.commonUtilClass;
                Context contextRequireContext = DeletionObjectionForm.this.requireContext();
                String str = DeletionObjectionForm.this.refreshToken;
                final String str2 = this.val$captureFileName;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$6$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            DeletionObjectionForm.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                DeletionObjectionForm.this.commonUtilClass.showMessageOK(DeletionObjectionForm.this.getContext(), DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DeletionObjectionForm.this.token = "Bearer " + str2;
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setToken("Bearer " + str2);
            Toast.makeText(DeletionObjectionForm.this.requireContext(), "Page refreshed due to the token expiry", 1).show();
            DeletionObjectionForm.this.saveimageapi(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DeletionObjectionForm.this.requireContext()).setLocaleBool(false);
            DeletionObjectionForm.this.startActivity(new Intent((Context) DeletionObjectionForm.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(DeletionObjectionForm.DELETIONOBJECTION, "Failed_Uploaded " + t.getMessage());
            DeletionObjectionForm.this.alertDialog.dismiss();
        }
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Choose PDF from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda25
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$18(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$18(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    private void tab1() {
        this.binding.deletionObjectionFormLayout.setVisibility(0);
        this.binding.personalDetailsFormLayout.setVisibility(8);
        this.binding.rejectionOptionsFormLayout.setVisibility(8);
        this.binding.personDetailsFormLayout.setVisibility(8);
        this.binding.declarationFormLayout.setVisibility(8);
        this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.firstNameEd.getText().toString().isEmpty() || this.binding.epicEd.getText().toString().isEmpty() || this.binding.epicEd.getText().length() != 10 || this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) || this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1 || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0))))) {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.nameEd.getText().toString().isEmpty() || this.binding.surNameEd2.getText().toString().isEmpty() || ((!this.binding.epicEd2.getText().toString().isEmpty() && this.binding.epicEd2.getText().length() != 10) || this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty())) {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty() || this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        this.currentSelectedView = this.binding.selectStateLayout;
        this.backStack = this.binding.deletionObjectionFormLayout;
    }

    private void tab2() {
        this.binding.deletionObjectionFormLayout.setVisibility(8);
        this.binding.personalDetailsFormLayout.setVisibility(0);
        this.binding.rejectionOptionsFormLayout.setVisibility(8);
        this.binding.personDetailsFormLayout.setVisibility(8);
        this.binding.declarationFormLayout.setVisibility(8);
        this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateEd.getText().toString().isEmpty() || this.binding.constituencynoEd.getText().toString().isEmpty() || this.binding.constituencyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) || this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1 || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0))))) {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.nameEd.getText().toString().isEmpty() || this.binding.surNameEd2.getText().toString().isEmpty() || ((!this.binding.epicEd2.getText().toString().isEmpty() && this.binding.epicEd2.getText().length() != 10) || this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty())) {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty() || this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        this.currentSelectedView = this.binding.personalDetailLayout;
        this.backStack = this.binding.personalDetailsFormLayout;
    }

    private void tab3() {
        this.binding.deletionObjectionFormLayout.setVisibility(8);
        this.binding.personalDetailsFormLayout.setVisibility(8);
        this.binding.rejectionOptionsFormLayout.setVisibility(0);
        this.binding.personDetailsFormLayout.setVisibility(8);
        this.binding.declarationFormLayout.setVisibility(8);
        this.commonUtilClass.getReasonForObjection(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), new FormData() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda19
            @Override // in.gov.eci.bloapp.FormData
            public final void onCallback(ArrayList arrayList, HashMap map, int i) {
                this.f$0.lambda$tab3$21(arrayList, map, i);
            }
        });
        this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateEd.getText().toString().isEmpty() || this.binding.constituencynoEd.getText().toString().isEmpty() || this.binding.constituencyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty() || this.binding.epicEd.getText().toString().isEmpty() || this.binding.epicEd.getText().length() != 10 || this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.nameEd.getText().toString().isEmpty() || this.binding.surNameEd2.getText().toString().isEmpty() || ((!this.binding.epicEd2.getText().toString().isEmpty() && this.binding.epicEd2.getText().length() != 10) || this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty())) {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty() || this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        this.currentSelectedView = this.binding.rejectionOptionsLayout;
        this.backStack = this.binding.rejectionOptionsFormLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tab3$21(ArrayList arrayList, HashMap map, int i) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$tab3$20(i2, str, str2);
                }
            });
            return;
        }
        this.alertDialog.show();
        this.rejectionOptions = arrayList;
        this.reasonmap = map;
        this.rejectionOptions1.clear();
        this.rejectionOptions2.clear();
        this.rejectionOptions3.clear();
        this.reasonCode1.clear();
        this.reasonCode2.clear();
        this.reasonCode3.clear();
        this.rejectionOptions1.add(selectReason);
        this.rejectionOptions2.add(selectReason);
        this.rejectionOptions3.add(selectReason);
        this.rejectionOptions3.add("1");
        this.rejectionOptions3.add("2");
        this.rejectionOptions3.add("3");
        this.reasonCode1.add(selectReason);
        this.reasonCode2.add(selectReason);
        this.reasonCode3.add(selectReason);
        this.reasonCode3.add("1");
        this.reasonCode3.add("2");
        this.reasonCode3.add("3");
        for (String str : this.rejectionOptions) {
            if (str.contains(death)) {
                this.rejectionOptions1.add(str);
                this.rejectionOptions2.add(str);
                this.reasonCode1.add(this.reasonmap.get(str));
                this.reasonCode2.add(this.reasonmap.get(str));
            }
            if (str.contains(underAge)) {
                this.rejectionOptions1.add(str);
                this.rejectionOptions2.add(str);
                this.reasonCode1.add(this.reasonmap.get(str));
                this.reasonCode2.add(this.reasonmap.get(str));
            }
            if (str.contains(absentPermanentlyShifted)) {
                this.rejectionOptions1.add(str);
                this.rejectionOptions2.add(str);
                this.reasonCode1.add(this.reasonmap.get(str));
                this.reasonCode2.add(this.reasonmap.get(str));
            }
            if (str.contains(alreadyEnrolled)) {
                this.rejectionOptions1.add(str);
                this.rejectionOptions2.add(str);
                this.rejectionOptions3.set(2, str);
                this.reasonCode1.add(this.reasonmap.get(str));
                this.reasonCode2.add(this.reasonmap.get(str));
                this.reasonCode3.set(2, this.reasonmap.get(str));
            }
            if (str.contains(notIndianCitizen)) {
                this.rejectionOptions1.add(str);
                this.rejectionOptions2.add(str);
                this.rejectionOptions3.set(3, str);
                this.reasonCode1.add(this.reasonmap.get(str));
                this.reasonCode2.add(this.reasonmap.get(str));
                this.reasonCode3.set(3, this.reasonmap.get(str));
            }
            if (str.equals(permanentlyShifted)) {
                this.rejectionOptions3.set(1, str);
                this.reasonCode3.set(1, this.reasonmap.get(str));
            }
        }
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions1);
        this.spinnerAdapter1 = customSpinnerAdapter;
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) this.spinnerAdapter1);
        this.binding.rejectionSpinner1.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions2);
        this.spinnerAdapter2 = customSpinnerAdapter2;
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) this.spinnerAdapter2);
        this.binding.rejectionSpinner2.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions3);
        this.spinnerAdapter3 = customSpinnerAdapter3;
        customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) this.spinnerAdapter3);
        this.binding.rejectionSpinner3.setSelection(0);
        this.binding.deathLayout.setVisibility(8);
        if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner1.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner1.setSelection(2);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner1.setSelection(3);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner1.setSelection(4);
        } else if (this.binding.optionRb1.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner1.setSelection(5);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(death)) {
            this.binding.rejectionSpinner2.setSelection(1);
            this.binding.deathLayout.setVisibility(0);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(underAge)) {
            this.binding.rejectionSpinner2.setSelection(2);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(absentPermanentlyShifted)) {
            this.binding.rejectionSpinner2.setSelection(3);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner2.setSelection(4);
        } else if (this.binding.optionRb2.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner2.setSelection(5);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(permanentlyShifted)) {
            this.binding.rejectionSpinner3.setSelection(1);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(alreadyEnrolled)) {
            this.binding.rejectionSpinner3.setSelection(2);
        } else if (this.binding.optionRb3.isChecked() && this.rejectionOptionSubcategory.equals(notIndianCitizen)) {
            this.binding.rejectionSpinner3.setSelection(3);
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tab3$20(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$tab3$19(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        tab3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tab3$19(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void tab4() {
        this.binding.deletionObjectionFormLayout.setVisibility(8);
        this.binding.personalDetailsFormLayout.setVisibility(8);
        this.binding.rejectionOptionsFormLayout.setVisibility(8);
        this.binding.personDetailsFormLayout.setVisibility(0);
        this.binding.declarationFormLayout.setVisibility(8);
        this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateEd.getText().toString().isEmpty() || this.binding.constituencynoEd.getText().toString().isEmpty() || this.binding.constituencyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty() || this.binding.epicEd.getText().toString().isEmpty() || this.binding.epicEd.getText().length() != 10 || this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) || this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1 || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0))))) {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty() || this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        this.currentSelectedView = this.binding.personDetailsLayout;
        this.backStack = this.binding.personDetailsFormLayout;
    }

    private void tab5() {
        this.binding.deletionObjectionFormLayout.setVisibility(8);
        this.binding.personalDetailsFormLayout.setVisibility(8);
        this.binding.rejectionOptionsFormLayout.setVisibility(8);
        this.binding.personDetailsFormLayout.setVisibility(8);
        this.binding.declarationFormLayout.setVisibility(0);
        this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateEd.getText().toString().isEmpty() || this.binding.constituencynoEd.getText().toString().isEmpty() || this.binding.constituencyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty() || this.binding.epicEd.getText().toString().isEmpty() || this.binding.epicEd.getText().length() != 10 || this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) || this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1 || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0))))) {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.nameEd.getText().toString().isEmpty() || this.binding.surNameEd2.getText().toString().isEmpty() || ((!this.binding.epicEd2.getText().toString().isEmpty() && this.binding.epicEd2.getText().length() != 10) || this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty())) {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        this.currentSelectedView = this.binding.declarationLayout;
        this.backStack = this.binding.declarationFormLayout;
    }

    private void nextFragment() {
        String string;
        int i;
        String str;
        int i2;
        if (this.currentSelectedView == this.binding.selectStateLayout) {
            if (this.binding.stateEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter State");
                return;
            }
            if (this.binding.constituencynoEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter No. of Constituency");
                return;
            }
            if (this.binding.constituencyEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter Constituency");
                return;
            }
            this.currentSelectedView = this.binding.personalDetailLayout;
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.deletionObjectionFormLayout.setVisibility(8);
            this.binding.personalDetailsFormLayout.setVisibility(0);
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 425, this.binding.horizontal.getScrollY());
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            return;
        }
        if (this.currentSelectedView == this.binding.personalDetailLayout) {
            if (!this.binding.mobileNumEd.getText().toString().isEmpty() && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
                showdialog(alertString, "Please enter correct Mobile number");
                this.binding.mobileNumEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (Objects.equals(this.referenceNumber, null)) {
                this.alertDialog.show();
                String str2 = this.request;
                str2.hashCode();
                switch (str2) {
                    case "objection":
                        getRefNum("I");
                        break;
                    case "same":
                        getRefNum("S");
                        break;
                    case "other":
                        getRefNum("O");
                        break;
                }
                return;
            }
            this.binding.mobileNum91.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            this.binding.mobileNumEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            if (this.binding.self.isChecked()) {
                this.mobileType = "Self";
            } else {
                this.mobileType = "Relative";
            }
            String string2 = this.binding.mobileNumEd.getText().toString().isEmpty() ? "NA" : this.binding.mobileNumEd.getText().toString();
            if (this.lastNameApplicant.isEmpty()) {
                this.lastNameApplicant = " ";
            }
            String string3 = this.binding.surNameEd2.getText().toString().isEmpty() ? " " : this.binding.surNameEd2.getText().toString();
            String string4 = this.binding.epicEd2.getText().toString().isEmpty() ? " " : this.binding.epicEd2.getText().toString();
            if (this.binding.rejectionSpinner1.getSelectedItem() == null || this.binding.rejectionSpinner2.getSelectedItem() == null || this.binding.rejectionSpinner3.getSelectedItem() == null) {
                Logger.e("Spinner Error", "Spinner is data is not available");
                this.rejectionOptions1.add(selectReason);
                CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions1);
                this.spinnerAdapter1 = customSpinnerAdapter;
                customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.binding.rejectionSpinner1.setAdapter((SpinnerAdapter) this.spinnerAdapter1);
                this.binding.rejectionSpinner1.setSelection(0);
                ArrayList<String> arrayList = new ArrayList<>();
                this.rejectionOptions2 = arrayList;
                arrayList.add(selectReason);
                CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions2);
                this.spinnerAdapter2 = customSpinnerAdapter2;
                customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.binding.rejectionSpinner2.setAdapter((SpinnerAdapter) this.spinnerAdapter2);
                this.binding.rejectionSpinner2.setSelection(0);
                ArrayList<String> arrayList2 = new ArrayList<>();
                this.rejectionOptions3 = arrayList2;
                arrayList2.add(selectReason);
                CustomSpinnerAdapter customSpinnerAdapter3 = new CustomSpinnerAdapter(getContext(), android.R.layout.simple_spinner_item, this.rejectionOptions3);
                this.spinnerAdapter3 = customSpinnerAdapter3;
                customSpinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.binding.rejectionSpinner3.setAdapter((SpinnerAdapter) this.spinnerAdapter3);
                this.binding.rejectionSpinner3.setSelection(0);
            }
            if (this.form.equals(rejected)) {
                i = 0;
            } else {
                String str3 = this.binding.stateEd.getText().toString() + this.delimeter + this.binding.districtEd.getText().toString() + this.delimeter + this.binding.constituencynoEd.getText().toString() + this.delimeter + this.binding.constituencyEd.getText().toString() + this.delimeter + this.serialNumberApplicant + this.delimeter + this.serialNumberOfPersonToBeDeleted + this.delimeter + this.sectionNoApplicant + this.delimeter + this.partNumberOfPersonToBeDeleted + this.delimeter + this.objectToInclFormRefNum + this.delimeter + this.objectToInclFormType;
                String str4 = this.firstNameApplicant + this.delimeter + this.lastNameApplicant + this.delimeter + this.binding.epicEd.getText().toString() + this.delimeter + this.mobileType + this.delimeter + string2 + this.delimeter + this.age + this.delimeter + this.gender;
                String str5 = new SimpleDateFormat("dd/MM/yyyy HH:mm aaa", Locale.getDefault()).format(Calendar.getInstance().getTime());
                String string5 = this.binding.epicEd2.getText().toString();
                if (this.fromDraft) {
                    updatepersonaldetails(this.referenceNumber, str4, 2);
                    str = string3;
                    i2 = 2;
                    i = 0;
                } else {
                    str = string3;
                    i2 = 2;
                    i = 0;
                    insertforms(this.binding.firstNameEd.getText().toString(), str3, str4, 2, this.form7, this.referenceNumber, str5, this.formOrigin, string5.isEmpty() ? "NA" : string5);
                }
                updaterejectionoptions(this.referenceNumber, this.rejectionOption, "No", null, 2);
                updaterequestraisedetails(this.referenceNumber, this.binding.nameEd.getText().toString() + this.delimeter + str + this.delimeter + string4 + this.delimeter + this.binding.districtEd1.getText().toString() + this.delimeter + this.binding.stateEd1.getText().toString(), i2);
            }
            this.currentSelectedView = this.binding.rejectionOptionsLayout;
            this.binding.personalDetailsFormLayout.setVisibility(8);
            this.binding.rejectionOptionsFormLayout.setVisibility(i);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 450, this.binding.horizontal.getScrollY());
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            return;
        }
        if (this.currentSelectedView == this.binding.rejectionOptionsLayout) {
            if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1) {
                showdialog(alertString, "Please select Option of application/objection");
                return;
            }
            if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem() != null && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) {
                showdialog(alertString, "Please choose one of the reasons for deletion of name of the person");
                return;
            }
            if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem() != null && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) {
                showdialog(alertString, "Please choose one of the reasons for objection of name of the person");
                return;
            }
            if (this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner2.getSelectedItem() != null && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) {
                showdialog(alertString, "Please choose one of the reasons for deletion of your name");
                return;
            }
            if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(death) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) {
                showdialog(alertString, "Please select Yes or No");
                return;
            }
            if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(death) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) {
                showdialog(alertString, "Please select Yes or No");
                return;
            }
            if (this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(death) && this.binding.yesRg.isChecked() && this.binding.chooseFileItems.getVisibility() != 0) {
                showdialog(alertString, "Please select a file");
                return;
            }
            if (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(death) && this.binding.yesRg.isChecked() && this.binding.chooseFileItems.getVisibility() != 0) {
                showdialog(alertString, "Please select a file");
                return;
            }
            if (this.binding.optionRb1.isChecked()) {
                this.rejectionOptionSubcategory = this.binding.rejectionSpinner1.getSelectedItem().toString();
            } else if (this.binding.optionRb2.isChecked()) {
                this.rejectionOptionSubcategory = this.binding.rejectionSpinner2.getSelectedItem().toString();
            } else if (this.binding.optionRb3.isChecked()) {
                this.rejectionOptionSubcategory = this.binding.rejectionSpinner3.getSelectedItem().toString();
            }
            if (((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(death)) || (this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(death))) && this.binding.yesRg.isChecked()) {
                this.deathCertiAttach = "Yes";
            } else {
                this.deathCertiAttach = "No";
            }
            if (this.binding.epicEd2.getText().toString().isEmpty()) {
                this.epicEd2 = "";
            } else {
                this.epicEd2 = this.binding.epicEd2.getText().toString();
            }
            if (!this.form.equals(rejected)) {
                updaterejectionoptions(this.referenceNumber, this.rejectionOption + this.delimeter + this.rejectionOptionSubcategory + this.delimeter + this.deathCertiAttach + this.delimeter + this.binding.selectName.getText().toString() + this.delimeter + this.binding.selectSize.getText().toString() + this.delimeter + this.docref, this.deathCertiAttach, this.byteArray, 3);
            }
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            this.binding.nameEd.setEnabled(false);
            this.binding.surNameEd2.setEnabled(false);
            this.binding.epicEd2.setEnabled(false);
            this.binding.districtEd1.setEnabled(false);
            this.binding.stateEd1.setEnabled(false);
            this.currentSelectedView = this.binding.personDetailsLayout;
            this.binding.rejectionOptionsFormLayout.setVisibility(8);
            this.binding.personDetailsFormLayout.setVisibility(0);
            this.binding.rejectionOptionsLayout.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 475, this.binding.horizontal.getScrollY());
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            return;
        }
        if (this.currentSelectedView == this.binding.personDetailsLayout) {
            if (this.binding.houseEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter House/Building/Apartment No.");
                this.binding.houseEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.houseEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter House/Building/Apartment No. in regional");
                return;
            }
            if (this.binding.streetEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter Street/Area/Locality/Mohalla/Road");
                this.binding.streetEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.streetEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter Street/Area/Locality/Mohalla/Road in regional");
                return;
            }
            if (!this.partLang.equals(this.english_code) && this.binding.streetEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(alertString, "Street/Area/Locality/Mohalla/Road (" + this.binding.streetEd2.getText().toString() + ") should be in regional language");
                this.binding.houseEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.streetEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                this.binding.villageEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.postofficeEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.tehsilEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                return;
            }
            if (this.binding.villageEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Village/Town");
                this.binding.villageEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.villageEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Village/Town  in regional");
                return;
            }
            if (!this.partLang.equals(this.english_code) && this.binding.villageEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(alertString, "Village/Town (" + this.binding.villageEd2.getText().toString() + ") should be in regional language");
                this.binding.houseEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.streetEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.villageEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                this.binding.postofficeEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.tehsilEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                return;
            }
            if (this.binding.postofficeEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Post Office");
                this.binding.postofficeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.postofficeEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Post Office in regional");
                return;
            }
            if (!this.partLang.equals(this.english_code) && this.binding.postofficeEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(alertString, "Post Office (" + this.binding.postofficeEd2.getText().toString() + ") should be in regional language");
                this.binding.houseEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.streetEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.villageEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.postofficeEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                this.binding.tehsilEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                return;
            }
            if (this.binding.pincodeEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter Pin Code");
                this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.pincodeEd.getText().toString().length() == 6 && !this.binding.pincodeEd.getText().toString().matches("^[1-9]{1}[0-9]{5}$")) {
                showdialog(alertString, "Please enter correct pincode");
                this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.pincodeEd.getText().length() != 6) {
                showdialog(alertString, "Please enter a valid Pin Code");
                this.binding.pincodeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.tehsilEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Tehsil/Taluqa/Mandal");
                this.binding.tehsilEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.tehsilEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please select Tehsil/Taluqa/Mandal in regional");
                return;
            }
            if (!this.partLang.equals(this.english_code) && this.binding.tehsilEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(alertString, "Tehsil/Taluqa/Mandal (" + this.binding.tehsilEd2.getText().toString() + ") should be in regional language");
                this.binding.houseEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.streetEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.villageEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.postofficeEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                this.binding.tehsilEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
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
            if (this.binding.epicEd2.getText().toString().isEmpty()) {
                this.epicEd2 = " ";
            } else {
                this.epicEd2 = this.binding.epicEd2.getText().toString();
            }
            string = this.binding.surNameEd2.getText().toString().isEmpty() ? " " : this.binding.surNameEd2.getText().toString();
            if (!this.form.equals(rejected)) {
                updaterequestraisedetails(this.referenceNumber, this.binding.nameEd.getText().toString() + this.delimeter + string + this.delimeter + this.epicEd2 + this.delimeter + this.binding.houseEd.getText().toString() + this.delimeter + this.binding.streetEd.getText().toString() + this.delimeter + this.binding.villageEd.getText().toString() + this.delimeter + this.binding.postofficeEd.getText().toString() + this.delimeter + this.binding.pincodeEd.getText().toString() + this.delimeter + this.binding.tehsilEd.getText().toString() + this.delimeter + this.binding.districtEd1.getText().toString() + this.delimeter + this.binding.stateEd1.getText().toString() + this.delimeter + this.binding.houseEd2.getText().toString() + this.delimeter + this.binding.streetEd2.getText().toString() + this.delimeter + this.binding.villageEd2.getText().toString() + this.delimeter + this.binding.postofficeEd2.getText().toString() + this.delimeter + this.binding.tehsilEd2.getText().toString(), 4);
            }
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            this.currentSelectedView = this.binding.declarationLayout;
            this.binding.personDetailsFormLayout.setVisibility(8);
            this.binding.declarationFormLayout.setVisibility(0);
            this.binding.personDetailsLayout.setEnabled(true);
            this.binding.declarationLayout.setEnabled(true);
            this.binding.issueDateEd.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 425, this.binding.horizontal.getScrollY());
            this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            return;
        }
        if (this.currentSelectedView == this.binding.declarationLayout) {
            if (this.binding.placeEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please enter Place");
                this.binding.placeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (!this.binding.placeEd.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().matches(RegexMatcher.PLACE_REGEX2)) {
                showdialog(alertString, "Please enter correct Place");
                this.binding.placeEd.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
                return;
            }
            if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || (this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason))))) {
                showdialog(alertString, this.pleaseFillOption);
                return;
            }
            if ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(death) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0)) {
                showdialog(alertString, this.pleaseFillOption);
                return;
            }
            if ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(death) && this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1) || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0)) {
                showdialog(alertString, this.pleaseFillOption);
                return;
            }
            if (this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty()) {
                showdialog(alertString, "Please fill Details of the Person tab completely");
                return;
            }
            if (this.binding.houseEd2.getText().toString().isEmpty() || this.binding.streetEd2.getText().toString().isEmpty() || this.binding.villageEd2.getText().toString().isEmpty() || this.binding.postofficeEd2.getText().toString().isEmpty() || this.binding.tehsilEd2.getText().toString().isEmpty()) {
                showdialog(alertString, "Please fill Details of the Person tab completely");
                return;
            }
            if (this.binding.epicEd2.getText().toString().isEmpty()) {
                this.epicEd2 = " ";
            } else {
                this.epicEd2 = this.binding.epicEd2.getText().toString();
            }
            string = this.binding.surNameEd2.getText().toString().isEmpty() ? " " : this.binding.surNameEd2.getText().toString();
            if (!this.form.equals(rejected)) {
                updaterequestraisedetails(this.referenceNumber, this.binding.nameEd.getText().toString() + this.delimeter + string + this.delimeter + this.epicEd2 + this.delimeter + this.binding.houseEd.getText().toString() + this.delimeter + this.binding.streetEd.getText().toString() + this.delimeter + this.binding.villageEd.getText().toString() + this.delimeter + this.binding.postofficeEd.getText().toString() + this.delimeter + this.binding.pincodeEd.getText().toString() + this.delimeter + this.binding.tehsilEd.getText().toString() + this.delimeter + this.binding.districtEd1.getText().toString() + this.delimeter + this.binding.stateEd1.getText().toString() + this.delimeter + this.binding.houseEd2.getText().toString() + this.delimeter + this.binding.streetEd2.getText().toString() + this.delimeter + this.binding.villageEd2.getText().toString() + this.delimeter + this.binding.postofficeEd2.getText().toString() + this.delimeter + this.binding.tehsilEd2.getText().toString(), 4);
            }
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            previewActivity();
        }
    }

    private void previewActivity() {
        String str;
        Intent intent = new Intent((Context) requireActivity(), (Class<?>) PreviewForm7Activity.class);
        intent.putExtra("request", this.request);
        intent.putExtra("formOrigin", this.formOrigin);
        intent.putExtra("REFERENCE_NUMBER", this.referenceNumber);
        intent.putExtra("partNumberApplicant", this.partNumberApplicant);
        intent.putExtra(serialNumberApplicantString, this.serialNumberApplicant);
        intent.putExtra(this.serialNumberOfPersonToBeDeletedString, this.serialNumberOfPersonToBeDeleted);
        intent.putExtra(partNumberOfPersonToBeDeletedString, this.partNumberOfPersonToBeDeleted);
        intent.putExtra("sectionNoApplicant", this.sectionNoApplicant);
        intent.putExtra("state", this.binding.stateEd.getText().toString());
        intent.putExtra("district", this.binding.districtEd.getText().toString());
        intent.putExtra("assemblyno", this.binding.constituencynoEd.getText().toString());
        intent.putExtra("assembly", this.binding.constituencyEd.getText().toString());
        intent.putExtra("firstNameApplicant", this.firstNameApplicant);
        intent.putExtra("lastNameApplicant", this.lastNameApplicant);
        intent.putExtra("applicantEpic", this.binding.epicEd.getText().toString());
        intent.putExtra("mobileType", this.mobileType);
        intent.putExtra("mobilenum", this.binding.mobileNumEd.getText().toString());
        intent.putExtra("rejection", this.rejectionOption);
        intent.putExtra("subrejection", this.rejectionOptionSubcategory);
        intent.putExtra("flag", this.flag);
        intent.putExtra("epicId", this.epicId);
        try {
            if (this.binding.optionRb1.isChecked()) {
                intent.putExtra(reasonForDeletion, this.reasonmap.get(this.binding.rejectionSpinner1.getSelectedItem().toString()));
            } else if (this.binding.optionRb2.isChecked()) {
                intent.putExtra(reasonForDeletion, this.reasonmap.get(this.binding.rejectionSpinner2.getSelectedItem().toString()));
            } else if (this.binding.optionRb3.isChecked()) {
                intent.putExtra(reasonForDeletion, this.reasonmap.get(this.binding.rejectionSpinner3.getSelectedItem().toString()));
            }
        } catch (Exception e) {
            Logger.e(DELETIONOBJECTION, e.getMessage());
        }
        if (this.binding.yesRg.isChecked()) {
            str = "Yes";
        } else {
            str = "No";
        }
        intent.putExtra("certificateAttached", str);
        intent.putExtra("docref", this.docref);
        intent.putExtra("certificateName", this.certificateName);
        intent.putExtra("certificateSize", this.certificateSize);
        intent.putExtra("name", this.binding.nameEd.getText().toString());
        intent.putExtra("surname", this.binding.surNameEd2.getText().toString());
        intent.putExtra("epic", this.binding.epicEd2.getText().toString());
        intent.putExtra("objectToInclFormRefNum", this.objectToInclFormRefNum);
        intent.putExtra(objectToInclFormTypeString, this.objectToInclFormType);
        intent.putExtra("house", this.binding.houseEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("houseRegional", this.binding.houseEd2.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("street", this.binding.streetEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("streetRegional", this.binding.streetEd2.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("village", this.binding.villageEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("villageRegional", this.binding.villageEd2.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("postoffice", this.binding.postofficeEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("postofficeRegional", this.binding.postofficeEd2.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("pincode", this.binding.pincodeEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("tehsil", this.binding.tehsilEd.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("tehsilRegional", this.binding.tehsilEd2.getText().toString().trim().replace("[ ]+", " "));
        intent.putExtra("districtCdOfPersonToBeDeleted", this.districtCdOfPersonToBeDeleted);
        intent.putExtra("date", this.binding.issueDateEd.getText().toString());
        intent.putExtra("place", this.binding.placeEd.getText().toString().trim().replace("[ ]+", " "));
        String str2 = null;
        intent.putExtra("age", (this.age.equals("null") || this.age.isEmpty()) ? null : this.age);
        if (!this.gender.equals("null") && !this.gender.isEmpty()) {
            str2 = this.gender;
        }
        intent.putExtra("gender", str2);
        intent.putExtra("pseAcNo", this.pseAcNo);
        intent.putExtra("pseId", this.pseId);
        intent.putExtra("psePartNo", this.psePartNo);
        intent.putExtra("psePreferredUsername", this.psePreferredUsername);
        intent.putExtra("bloOutput", this.bloOutput);
        startActivity(intent);
    }

    private void prevFragment() {
        if (this.currentSelectedView == this.binding.selectStateLayout) {
            this.binding.previousTv.setEnabled(false);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_line));
            return;
        }
        if (this.currentSelectedView == this.binding.personalDetailLayout) {
            this.currentSelectedView = this.binding.selectStateLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 500, this.binding.horizontal.getScrollY());
            this.binding.previousTv.setEnabled(false);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_line));
            this.binding.deletionObjectionFormLayout.setVisibility(0);
            this.binding.personalDetailsFormLayout.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.firstNameEd.getText().toString().isEmpty() || this.binding.epicEd.getText().toString().isEmpty() || this.binding.epicEd.getText().length() != 10 || this.binding.mobNumRg.getCheckedRadioButtonId() == -1) {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
                return;
            } else {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                return;
            }
        }
        if (this.currentSelectedView == this.binding.rejectionOptionsLayout) {
            this.currentSelectedView = this.binding.personalDetailLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 500, this.binding.horizontal.getScrollY());
            this.binding.personalDetailsFormLayout.setVisibility(0);
            this.binding.rejectionOptionsFormLayout.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.rejectionOptionsRg.getCheckedRadioButtonId() == -1 || this.binding.deathCertificateReg.getCheckedRadioButtonId() == -1 || ((this.binding.optionRb1.isChecked() && this.binding.rejectionSpinner1.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb2.isChecked() && this.binding.rejectionSpinner2.getSelectedItem().toString().equals(selectReason)) || ((this.binding.optionRb3.isChecked() && this.binding.rejectionSpinner3.getSelectedItem().toString().equals(selectReason)) || (this.binding.deathCertificateReg.getCheckedRadioButtonId() == this.binding.yesRg.getId() && this.binding.chooseFileItems.getVisibility() != 0))))) {
                this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
                return;
            } else {
                this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                return;
            }
        }
        if (this.currentSelectedView == this.binding.personDetailsLayout) {
            this.currentSelectedView = this.binding.rejectionOptionsLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 500, this.binding.horizontal.getScrollY());
            this.binding.rejectionOptionsFormLayout.setVisibility(0);
            this.binding.personDetailsFormLayout.setVisibility(8);
            this.binding.rejectionOptionsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.nameEd.getText().toString().isEmpty() || this.binding.surNameEd2.getText().toString().isEmpty() || ((!this.binding.epicEd2.getText().toString().isEmpty() && this.binding.epicEd2.getText().length() != 10) || this.binding.houseEd.getText().toString().isEmpty() || this.binding.streetEd.getText().toString().isEmpty() || this.binding.villageEd.getText().toString().isEmpty() || this.binding.postofficeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.tehsilEd.getText().toString().isEmpty())) {
                this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
                return;
            } else {
                this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                return;
            }
        }
        this.currentSelectedView = this.binding.personDetailsLayout;
        this.binding.personDetailsFormLayout.setVisibility(0);
        this.binding.declarationFormLayout.setVisibility(8);
        this.binding.personDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
    }

    private void insertforms(String name, String insertState, String personal, int seq, String formtype, String referencenumber, String createdOn, String formOrigin, String epicNumber) {
        this.viewModel.insertforms(name, insertState, personal, seq, formtype, referencenumber, createdOn, formOrigin, epicNumber);
    }

    public void updatepersonaldetails(String referencenumber, String personalDetails, int seq) {
        this.viewModel.updatepersonaldetails(referencenumber, personalDetails, seq);
    }

    public void updaterejectionoptions(String referencenumber, String rejectionOptions, String deathCertiAttach, byte[] photo, int seq) {
        this.viewModel.updaterejectionoptions(referencenumber, rejectionOptions, deathCertiAttach, photo, seq);
    }

    public void updaterequestraisedetails(String referencenumber, String requestDetails, int seq) {
        this.viewModel.updaterequestraisedetails(referencenumber, requestDetails, seq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private void showdialogFinal(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogFinal$23(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogFinal$23(DialogInterface dialogInterface, int i) {
        requireActivity().finish();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda11
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$24(task);
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
    public /* synthetic */ void lambda$getCurrentLocation$24(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                Logger.d(DELETIONOBJECTION, fromLocation.get(0).getLocality());
                if (fromLocation.get(0).getLocality().isEmpty()) {
                    return;
                }
                Logger.d(DELETIONOBJECTION, fromLocation.get(0).getLocality());
                this.binding.placeEd.setText(fromLocation.get(0).getLocality());
            } catch (Exception e) {
                Logger.d("Content : ", e.getMessage());
            }
        }
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm$$ExternalSyntheticLambda8
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$25(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$25(Task task) {
        try {
            Toast.makeText(getContext(), "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(getActivity(), 2);
            } catch (IntentSender.SendIntentException unused) {
                Logger.e(DELETIONOBJECTION, e.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
