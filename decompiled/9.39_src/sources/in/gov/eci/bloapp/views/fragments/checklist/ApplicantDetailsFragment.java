package in.gov.eci.bloapp.views.fragments.checklist;

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
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.MyCallbackJson;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.databinding.BloFragmentApplicantDetailsBinding;
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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
public class ApplicantDetailsFragment extends Hilt_ApplicantDetailsFragment implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener, View.OnTouchListener {
    String SESSION;
    ActivityResultLauncher<Intent> activityResultLauncher1;
    String addressfield;
    String alert;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    private String base64element1;
    private BloFragmentApplicantDetailsBinding binding;
    private String birthDistrictCode;
    String birthStateCode;
    String birthTownText;
    Bitmap bitmapPassportImage;
    Bitmap bitmapPersonImage;
    String bloapp;
    Retrofit.Builder builder;
    private byte[] byteArray;
    String cancel;
    String choosegallery;
    String choosepdf;
    String color;
    private final CommomUtility commonUtilClass;
    private ArrayList<String> country;
    private String countryCode;
    private String countryRp;
    private String countryZipcode;
    private ArrayAdapter<String> countryadapter;
    String crosiCountryCd;
    private int currentStatusId;
    String data;
    String dateOfPassportIssue;
    String dateOfVisaExpiry;
    String dateOfVisaIssue;
    private String datetype;
    String declareApplCode;
    private ArrayList<String> district;
    private String districtCode;
    String districtName;
    private ArrayAdapter<String> districtadapter;
    private ArrayList<String> districtcode1;
    private String districtpd;
    private String dobQualifyingDate;
    String education;
    private String emaiTV;
    String email;
    String emailText;
    String employment;
    String encodedPersonImage;
    String english_code;
    String father;
    String filepathimg;
    String firstName;
    private String firstNamehin;
    private int form6aId;
    String formSubmissionDate;
    private ArrayList<String> gender;
    private String genderTv1;
    private ArrayAdapter<String> genderadapter;
    private String houseNo;
    private String houseno1;
    private String housenohin;
    String hsbn;
    String imagemsg;
    private String isIndia;
    private JsonObject jsonobjectForm6A;
    String lastName;
    String lastNameL1;
    String lastNameText;
    String lastNamehin;
    String mobileNumberText;
    private String mobilenotv;
    String mother;
    String name;
    String objectstorage;
    OkHttpClient okHttpClient;
    private String ordinarydateTv;
    private String oridistrict;
    String other;
    private String outsidePlaceOfBirth;
    String partLang;
    String partNo;
    String passport;
    private String passportdocuments;
    private String passportexpiry;
    private String passportissue;
    private String passportissueplace;
    private String passportno;
    private byte[] pdfbyteArray;
    private String photo;
    private String pincodetv;
    String placeOfPassportIssue;
    private String postoffice;
    private String postoffice1;
    String prevEpicNo;
    private int processMasterId;
    private int processingid;
    private String reason;
    private String reasonAbsent1;
    String reasonOfAbsenceOthersDesc;
    private String referenceNo;
    private String refreshToken;
    private ArrayList<String> relation;
    private String relation1;
    private ArrayAdapter<String> relationadapter;
    private String relationtype;
    private String relativefirstName;
    private String relativefirstNamehin;
    private String relativelastName;
    String relativelastNamehin;
    Retrofit retrofit;
    private String rtkband;
    private ArrayList<String> state;
    private String state1;
    String stateCode;
    private ArrayAdapter<String> stateadapter;
    private ArrayList<String> statecode1;
    private String statepd;
    private String street;
    private String streetArea;
    private String streethin;
    String takephoto;
    private String token;
    private String townname;
    String typeOfVisa;
    private CheckListViewModel viewModel;
    private String villageTown;
    private String villagetown1;
    private String villagetownhin;
    private String visaAuthority;
    String visaIssuingAuthority;
    String visaNumber;
    private String visaexpiry;
    private String visaissue;
    private String visano;
    private String visatype;
    String whitecolor;
    private String workflowid;
    String dateFormat = "dd/MM/yyyy";
    String dateFormat2 = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(this.dateFormat);
    SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(this.dateFormat2);
    final Calendar myCalendar = Calendar.getInstance();
    final Calendar myCalendarpassport = Calendar.getInstance();
    final Calendar myCalendarvisa = Calendar.getInstance();
    final Calendar myCalendarvisa1 = Calendar.getInstance();
    final Calendar myCalendaror = Calendar.getInstance();
    CommomUtility commonutils = new CommomUtility();

    public ApplicantDetailsFragment() {
        CommomUtility commomUtility = new CommomUtility();
        this.commonUtilClass = commomUtility;
        this.okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.photo = " ";
        this.passportdocuments = " ";
        this.relation1 = "";
        this.reasonAbsent1 = " ";
        this.SESSION = "";
        this.crosiCountryCd = "crosiCountryCd";
        this.reasonOfAbsenceOthersDesc = "reasonOfAbsenceOthersDesc";
        this.visaNumber = "visaNumber";
        this.dateOfVisaIssue = "dateOfVisaIssue";
        this.dateOfVisaExpiry = "dateOfVisaExpiry";
        this.typeOfVisa = "typeOfVisa";
        this.visaIssuingAuthority = "visaIssuingAuthority";
        this.passport = "passport";
        this.placeOfPassportIssue = "placeOfPassportIssue";
        this.dateOfPassportIssue = "dateOfPassportIssue";
        this.father = "FATHER";
        this.mother = "MOTHER";
        this.hsbn = "HUSBAND";
        this.lastNameText = Constants.LAST_NAME;
        this.lastNameL1 = "lastNameL1";
        this.prevEpicNo = "prevEpicNo";
        this.mobileNumberText = "mobileNumber";
        this.birthTownText = "birthTown";
        this.emailText = "email";
        this.bloapp = "BLOAPP";
        this.objectstorage = "objectstorage";
        this.whitecolor = "#000000";
        this.data = "Data Updated Successfully";
        this.addressfield = "ADDRESS";
        this.takephoto = "Take Photo";
        this.choosegallery = "Choose Image from Gallery";
        this.cancel = "Cancel";
        this.choosepdf = "Choose PDF from Gallery";
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
        this.alert = "Alert";
        this.imagemsg = "Can't obtain file name, cursor is empty";
        this.color = "#99000000";
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass30());
        this.employment = "Employment";
        this.education = "Education";
        this.other = "Other";
        this.formSubmissionDate = "formSubmissionDate";
        this.declareApplCode = "declareApplCode";
        this.english_code = "en_in";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentApplicantDetailsBinding.inflate(getLayoutInflater());
        this.viewModel = (CheckListViewModel) new ViewModelProvider(requireActivity()).get(CheckListViewModel.class);
        this.SESSION = getString(R.string.sessionMsg);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.name = SharedPref.getInstance(requireContext()).getName();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.email = SharedPref.getInstance(requireContext()).getEmail();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.dobQualifyingDate = SharedPref.getInstance(requireContext()).getDobQualifyingDate();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.1
            public void handleOnBackPressed() {
                ApplicantDetailsFragment.this.openFragment(new CheckListMain(), "Applicant Details");
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.referenceNo = arguments.getString("refNo");
            this.processingid = arguments.getInt("formProcessingId");
            this.currentStatusId = arguments.getInt("currentStatusid");
            this.processMasterId = arguments.getInt("processMasterId");
            this.binding.village.setText(this.districtName);
        }
        this.binding.refNoTv.setText(this.referenceNo);
        this.binding.formTypeTv.setText("Form 6A");
        this.binding.applicantNameTv1.setText(this.name);
        this.binding.emailTv.setText(this.email);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(true);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        getChecklistGorm6A();
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.nameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.lastnameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeNameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeLastnameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.houseNoEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.streetEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.postofficeEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.villageEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.nameEd.setInputType(532624);
        this.binding.lastnameEd.setInputType(532624);
        this.binding.relativeNameEd.setInputType(532624);
        this.binding.relativeLastnameEd.setInputType(532624);
        this.binding.houseNoEd.setInputType(532624);
        this.binding.postofficeEd.setInputType(532624);
        this.binding.streetEd.setInputType(532624);
        this.binding.villageEd.setInputType(532624);
        this.binding.nameEd.setImportantForAutofill(2);
        this.binding.lastnameEd.setImportantForAutofill(2);
        this.binding.relativeNameEd.setImportantForAutofill(2);
        this.binding.relativeLastnameEd.setImportantForAutofill(2);
        this.binding.houseNoEd.setImportantForAutofill(2);
        this.binding.postofficeEd.setImportantForAutofill(2);
        this.binding.streetEd.setImportantForAutofill(2);
        this.binding.villageEd.setImportantForAutofill(2);
        String strSubstring = this.partLang.substring(0, 2);
        this.binding.nameEd2.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.lastnameEd2.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.relativeLastnameEd2.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.relativeNameEd2.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.houseNoEdhindi.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.streetEdhindi.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.postOfficehin.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.villageEdhindi.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.nameEd2.setImportantForAutofill(2);
        this.binding.lastnameEd2.setImportantForAutofill(2);
        this.binding.relativeLastnameEd2.setImportantForAutofill(2);
        this.binding.relativeNameEd2.setImportantForAutofill(2);
        this.binding.houseNoEdhindi.setImportantForAutofill(2);
        this.binding.streetEdhindi.setImportantForAutofill(2);
        this.binding.postOfficehin.setImportantForAutofill(2);
        this.binding.villageEdhindi.setImportantForAutofill(2);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.verificationDateEd.setText(new SimpleDateFormat(this.dateFormat, Locale.getDefault()).format(new Date()));
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda89
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.nameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.nameEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.nameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.nameEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.nameEd.setSelection(ApplicantDetailsFragment.this.binding.nameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.nameEd2.getText().clear();
                }
            }
        });
        this.binding.nameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.3
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
        this.binding.nameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.4
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
        this.binding.relativeNameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.5
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
        this.binding.relativeLastnameEd2.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.6
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
        this.binding.relativeNameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.relativeNameEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.relativeNameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.relativeNameEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.relativeNameEd.setSelection(ApplicantDetailsFragment.this.binding.relativeNameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.relativeNameEd2.getText().clear();
                }
            }
        });
        this.binding.lastnameEd2.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.8
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
        this.binding.lastnameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.9
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
        this.binding.relativeLastnameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.relativeLastnameEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.relativeLastnameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.relativeLastnameEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.relativeLastnameEd.setSelection(ApplicantDetailsFragment.this.binding.relativeLastnameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getText().clear();
                }
            }
        });
        this.binding.lastnameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.lastnameEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.lastnameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.lastnameEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.lastnameEd.setSelection(ApplicantDetailsFragment.this.binding.lastnameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.lastnameEd2.getText().clear();
                }
            }
        });
        this.binding.nameEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.nameEd2.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.nameEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.nameEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.nameEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.nameEd2.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.nameEd2.setText(sb);
                        ApplicantDetailsFragment.this.binding.nameEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.relativeNameEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.relativeNameEd2.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.relativeNameEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.relativeNameEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.relativeNameEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.relativeNameEd2.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.relativeNameEd2.setText(sb);
                        ApplicantDetailsFragment.this.binding.relativeNameEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.lastnameEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.lastnameEd2.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.lastnameEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.lastnameEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.lastnameEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.lastnameEd2.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.lastnameEd2.setText(sb);
                        ApplicantDetailsFragment.this.binding.lastnameEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.relativeLastnameEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.15
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.relativeLastnameEd2.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.relativeLastnameEd2.setText(sb);
                        ApplicantDetailsFragment.this.binding.relativeLastnameEd2.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.houseNoEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.16
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.houseNoEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.houseNoEd.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.houseNoEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.houseNoEd.setSelection(ApplicantDetailsFragment.this.binding.houseNoEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.houseNoEdhindi.getText().clear();
                }
            }
        });
        this.binding.houseNoEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.17
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.houseNoEd2.getText().toString();
                if (ApplicantDetailsFragment.this.binding.houseNoEd2.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.houseNoEd2.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.houseNoEd2.setSelection(ApplicantDetailsFragment.this.binding.houseNoEd2.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.houseNoEdhindi.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.18
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.houseNoEdhindi.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.houseNoEdhindi.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.houseNoEdhindi.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.houseNoEdhindi.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.houseNoEdhindi.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.houseNoEdhindi.setText(sb);
                        ApplicantDetailsFragment.this.binding.houseNoEdhindi.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.streetEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.19
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.streetEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.streetEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.streetEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.streetEd.setSelection(ApplicantDetailsFragment.this.binding.streetEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.streetEdhindi.getText().clear();
                }
            }
        });
        this.binding.streetEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.20
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.streetEd2.getText().toString();
                if (ApplicantDetailsFragment.this.binding.streetEd2.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.streetEd2.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.streetEd2.setSelection(ApplicantDetailsFragment.this.binding.streetEd2.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.streetEdhindi.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.21
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.streetEdhindi.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.streetEdhindi.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.streetEdhindi.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.streetEdhindi.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.streetEdhindi.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.streetEdhindi.setText(sb);
                        ApplicantDetailsFragment.this.binding.streetEdhindi.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.villageEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.22
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.villageEd.getText().toString();
                if (ApplicantDetailsFragment.this.binding.villageEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.villageEd.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.villageEd.setSelection(ApplicantDetailsFragment.this.binding.villageEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d("", s.toString());
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ApplicantDetailsFragment.this.binding.villageEdhindi.getText().clear();
                }
            }
        });
        this.binding.villageSpinner2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.23
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ApplicantDetailsFragment.this.binding.villageSpinner2.getText().toString();
                if (ApplicantDetailsFragment.this.binding.villageSpinner2.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    ApplicantDetailsFragment.this.binding.villageSpinner2.setText(string.substring(0, string.length() - 1));
                    ApplicantDetailsFragment.this.binding.villageSpinner2.setSelection(ApplicantDetailsFragment.this.binding.villageSpinner2.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.villageHindi.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.24
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ApplicantDetailsFragment.this.binding.villageHindi.getText().toString());
                    sb.charAt(ApplicantDetailsFragment.this.binding.villageHindi.getSelectionStart() - 1);
                    int selectionStart = ApplicantDetailsFragment.this.binding.villageHindi.getSelectionStart() - 1;
                    if (ApplicantDetailsFragment.this.binding.villageHindi.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ApplicantDetailsFragment.this.binding.villageHindi.getSelectionStart() - 1);
                        ApplicantDetailsFragment.this.binding.villageHindi.setText(sb);
                        ApplicantDetailsFragment.this.binding.villageHindi.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d("", s.toString());
            }
        });
        this.binding.dobSelectBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.houseNoRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$4(radioGroup, i);
            }
        });
        this.binding.radioParent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$5(radioGroup, i);
            }
        });
        this.binding.addressRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$6(radioGroup, i);
            }
        });
        this.binding.passportRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$7(radioGroup, i);
            }
        });
        this.binding.visaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$8(radioGroup, i);
            }
        });
        this.binding.orRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda7
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$9(radioGroup, i);
            }
        });
        this.binding.outsideRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$10(radioGroup, i);
            }
        });
        this.binding.indiaRbEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ApplicantDetailsFragment.this.binding.indiaLayoutEd.setVisibility(0);
                ApplicantDetailsFragment.this.binding.outsideIndiaLayoutEd.setVisibility(8);
                ApplicantDetailsFragment.this.isIndia = "Y";
            }
        });
        this.binding.outsideRbEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$11(view);
            }
        });
        this.binding.outsideIndiaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.26
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    return;
                }
                ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
                applicantDetailsFragment.outsidePlaceOfBirth = (String) applicantDetailsFragment.country.get(i);
            }
        });
        initializingClicks();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        showImageDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        this.alertDialog.show();
        if (this.passportdocuments.contains(".jpg") || this.passportdocuments.contains(".jpeg") || this.passportdocuments.contains(".png") || this.passportdocuments.contains(".jfif")) {
            showPassportImageDialog();
        } else if (this.passportdocuments.contains(".pdf")) {
            showPersonPdfDialog(this.passportdocuments);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda66
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$2();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(RadioGroup radioGroup, int i) {
        if (i == 2131364963) {
            this.binding.pencilBtn1.setVisibility(0);
        } else {
            if (i != 2131365558) {
                return;
            }
            personalsame();
            this.binding.pencilBtn1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(RadioGroup radioGroup, int i) {
        this.reasonAbsent1 = (String) ((RadioButton) this.binding.radioParent.getChildAt(radioGroup.indexOfChild(this.binding.radioParent.findViewById(this.binding.radioParent.getCheckedRadioButtonId())))).getText();
        int checkedRadioButtonId = this.binding.radioParent.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131363529) {
            this.binding.employment.setChecked(false);
            this.binding.other.setChecked(false);
            this.binding.descEd.setText("");
            this.binding.desLayout.setVisibility(8);
            return;
        }
        if (checkedRadioButtonId == 2131363638) {
            this.binding.education.setChecked(false);
            this.binding.other.setChecked(false);
            this.binding.desLayout.setVisibility(8);
            this.binding.descEd.setText("");
            return;
        }
        if (checkedRadioButtonId != 2131364948) {
            return;
        }
        this.binding.employment.setChecked(false);
        this.binding.education.setChecked(false);
        this.binding.descEd.setText(this.reason);
        this.binding.desLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(RadioGroup radioGroup, int i) {
        if (i == 2131362230) {
            this.binding.pencilBtn2.setVisibility(0);
        } else {
            if (i != 2131362240) {
                return;
            }
            ordinarysame();
            this.binding.pencilBtn2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(RadioGroup radioGroup, int i) {
        if (i == 2131365066) {
            this.binding.pencilBtn3.setVisibility(0);
        } else {
            if (i != 2131365068) {
                return;
            }
            passportsame();
            this.binding.pencilBtn3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(RadioGroup radioGroup, int i) {
        if (i == 2131366702) {
            this.binding.pencilBtn4.setVisibility(0);
        } else {
            if (i != 2131366704) {
                return;
            }
            visasame();
            this.binding.pencilBtn4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(RadioGroup radioGroup, int i) {
        if (i == 2131364938) {
            this.binding.pencilBtn5.setVisibility(0);
        } else {
            if (i != 2131364940) {
                return;
            }
            reasonsame();
            this.binding.pencilBtn5.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(RadioGroup radioGroup, int i) {
        if (i == 2131364985) {
            this.binding.pencilBtn6.setVisibility(0);
        } else {
            if (i != 2131364990) {
                return;
            }
            outsidesame();
            this.binding.pencilBtn6.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(View view) {
        this.binding.outsideIndiaLayoutEd.setVisibility(0);
        this.binding.indiaLayoutEd.setVisibility(8);
        getCountry(this.binding.outsideIndiaSpinner);
        this.isIndia = "N";
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$27, reason: invalid class name */
    class AnonymousClass27 implements MyCallbackJson {
        AnonymousClass27() {
        }

        @Override // in.gov.eci.bloapp.MyCallbackJson
        public void onCallback(int code, JsonObject value) {
            if (code == 401) {
                ApplicantDetailsFragment.this.commonUtilClass.getRefreshToken(ApplicantDetailsFragment.this.requireContext(), ApplicantDetailsFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$27$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onCallback$1(i, str, str2);
                    }
                });
            } else if (code == 200) {
                ApplicantDetailsFragment.this.jsonobjectForm6A = value;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$27$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCallback$2();
                    }
                }, 2000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$1(int i, String str, String str2) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$27$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onCallback$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str;
            ApplicantDetailsFragment.this.refreshToken = str2;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str);
            ApplicantDetailsFragment.this.getChecklistGorm6A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$2() {
            ApplicantDetailsFragment.this.personalsame();
            ApplicantDetailsFragment.this.ordinarysame();
            ApplicantDetailsFragment.this.passportsame();
            ApplicantDetailsFragment.this.visasame();
            ApplicantDetailsFragment.this.reasonsame();
            ApplicantDetailsFragment.this.outsidesame();
            ApplicantDetailsFragment.this.loadData();
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getChecklistGorm6A() {
        this.commonutils.getchecklistdetailsform6a(getContext(), this.stateCode, this.referenceNo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new AnonymousClass27());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void outsidesame() {
        this.houseNo = String.valueOf(this.jsonobjectForm6A.get("crosiHouseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.form6aId = Integer.parseInt(String.valueOf(this.jsonobjectForm6A.get("form6aId")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
        if (this.houseNo.isEmpty() || this.houseNo.equals("null")) {
            this.binding.houseNo.setText("");
            this.houseNo = "";
        } else {
            this.binding.houseNo.setText(this.houseNo);
        }
        String strReplace = String.valueOf(this.jsonobjectForm6A.get("crosiLocalityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.streetArea = strReplace;
        if (strReplace.isEmpty() || this.streetArea.equals("null")) {
            this.binding.streetArea.setText("");
            this.streetArea = "";
        } else {
            this.binding.streetArea.setText(this.streetArea);
        }
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get("crosiVillageTown")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.villageTown = strReplace2;
        if (strReplace2.isEmpty() || this.villageTown.equals("null")) {
            this.binding.villagTown.setText("");
            this.villageTown = "";
        } else {
            this.binding.villagTown.setText(this.villageTown);
        }
        String strReplace3 = String.valueOf(this.jsonobjectForm6A.get("crosiState")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.state1 = strReplace3;
        if (strReplace3 != null || !strReplace3.equals("")) {
            this.binding.state.setText(this.state1);
        } else {
            this.state1 = "";
            this.binding.state.setText(this.state1);
        }
        this.countryCode = String.valueOf(this.jsonobjectForm6A.get(this.crosiCountryCd)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        String strReplace4 = String.valueOf(this.jsonobjectForm6A.get("countryName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.countryRp = strReplace4;
        if (strReplace4.isEmpty() || this.countryRp.equals("null")) {
            this.binding.countryRp.setText("");
            this.countryRp = "";
        } else {
            this.binding.countryRp.setText(this.countryRp);
        }
        String strReplace5 = String.valueOf(this.jsonobjectForm6A.get("crosiZipCode")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.countryZipcode = strReplace5;
        if (strReplace5.isEmpty() || this.countryZipcode.equals("null")) {
            this.binding.countryZipcode.setText("");
            this.countryZipcode = "";
        } else {
            this.binding.countryZipcode.setText(this.countryZipcode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reasonsame() {
        String strReplace = String.valueOf(this.jsonobjectForm6A.get("reasonOfAbsence")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (strReplace.equals("EMPL")) {
            String str = this.employment;
            this.reason = str;
            this.reasonAbsent1 = str;
        } else if (strReplace.equals("EDU")) {
            String str2 = this.education;
            this.reason = str2;
            this.reasonAbsent1 = str2;
        } else if (strReplace.equals("OTHR")) {
            this.reasonAbsent1 = this.other;
            this.reason = String.valueOf(this.jsonobjectForm6A.get(this.reasonOfAbsenceOthersDesc)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        }
        if (strReplace.isEmpty() || strReplace.equals("null")) {
            this.binding.reasonAbsent.setText("");
        } else {
            this.binding.reasonAbsent.setText(this.reason);
        }
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get("dateFromWhichAbsentOnOrdinaryResidence")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.ordinarydateTv = strReplace2;
        if (strReplace2.isEmpty() || this.ordinarydateTv.equals("null")) {
            this.binding.ordinarydateTv.setText("");
            this.ordinarydateTv = "";
        } else {
            try {
                this.binding.ordinarydateTv.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.ordinarydateTv)));
            } catch (ParseException e) {
                Logger.d("", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visasame() {
        String strReplace = String.valueOf(this.jsonobjectForm6A.get(this.visaNumber)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.visano = strReplace;
        if (strReplace.isEmpty() || this.visano.equals("null")) {
            this.binding.visaNo.setText("");
            this.visano = "";
        } else {
            this.binding.visaNo.setText(this.visano);
        }
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get(this.dateOfVisaIssue)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.visaissue = strReplace2;
        if (strReplace2.isEmpty() || this.visaissue.equals("null")) {
            this.binding.visaIssue.setText("");
            this.visaissue = "";
        } else {
            try {
                this.binding.visaIssue.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.visaissue)));
            } catch (ParseException unused) {
                this.binding.visaIssue.setText("");
            }
        }
        String strReplace3 = String.valueOf(this.jsonobjectForm6A.get(this.dateOfVisaExpiry)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.visaexpiry = strReplace3;
        Logger.d("visa expiry", strReplace3);
        if (this.visaexpiry.equals("null") || this.visaexpiry.isEmpty()) {
            this.binding.visaExpiry.setText("");
            this.visaexpiry = "";
        } else {
            try {
                String str = this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.visaexpiry));
                if (str != null) {
                    this.binding.visaExpiry.setText(str);
                } else {
                    this.binding.visaExpiry.setText("");
                }
            } catch (ParseException unused2) {
                this.binding.visaExpiry.setText("");
            }
        }
        String strReplace4 = String.valueOf(this.jsonobjectForm6A.get(this.typeOfVisa)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.visatype = strReplace4;
        if (strReplace4.isEmpty() || this.visatype.equals("null")) {
            this.binding.visaType.setText("");
            this.visatype = "";
        } else {
            this.binding.visaType.setText(this.visatype);
        }
        String strReplace5 = String.valueOf(this.jsonobjectForm6A.get(this.visaIssuingAuthority)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.visaAuthority = strReplace5;
        if (strReplace5.isEmpty() || this.visaAuthority.equals("null")) {
            this.binding.visaAuthority.setText("");
            this.visaAuthority = "";
        } else {
            this.binding.visaAuthority.setText(this.visaAuthority);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passportsame() {
        String strReplace = String.valueOf(this.jsonobjectForm6A.get(this.passport)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.passportdocuments = strReplace;
        if (!strReplace.equals("null")) {
            getFile2(this.passportdocuments);
        }
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get(this.placeOfPassportIssue)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.passportissueplace = strReplace2;
        if (strReplace2.isEmpty() || this.passportissueplace.equals("null")) {
            this.binding.passportissuePlace.setText("");
            this.passportissueplace = "";
        } else {
            this.binding.passportissuePlace.setText(this.passportissueplace);
        }
        String strReplace3 = String.valueOf(this.jsonobjectForm6A.get("passportExpiry")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.passportexpiry = strReplace3;
        if (strReplace3.isEmpty() || this.passportexpiry.equals("null")) {
            this.binding.passportExpiry.setText("");
            this.passportexpiry = "";
        } else {
            try {
                this.binding.passportExpiry.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.passportexpiry)));
            } catch (ParseException e) {
                Logger.d("", e.getMessage());
            }
        }
        String strReplace4 = String.valueOf(this.jsonobjectForm6A.get(this.dateOfPassportIssue)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.passportissue = strReplace4;
        if (strReplace4.isEmpty() || this.passportissue.equals("null")) {
            this.binding.passportIssue.setText("");
            this.passportissue = "";
        } else {
            try {
                this.binding.passportIssue.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.passportissue)));
            } catch (ParseException e2) {
                Logger.d("", e2.getMessage());
            }
        }
        String strReplace5 = String.valueOf(this.jsonobjectForm6A.get("passportNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.passportno = strReplace5;
        if (strReplace5.isEmpty() || this.passportno.equals("null")) {
            this.binding.passportNo.setText("");
            this.passportno = "";
        } else {
            this.binding.passportNo.setText(this.passportno);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ordinarysame() {
        String strReplace = String.valueOf(this.jsonobjectForm6A.get("oriHouseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.houseno1 = strReplace;
        if (strReplace.isEmpty() || this.houseno1.equals("null")) {
            this.binding.houseno.setText("");
            this.houseno1 = "";
        } else {
            this.binding.houseno.setText(this.houseno1);
        }
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get("oriHouseNumberL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.housenohin = strReplace2;
        if (strReplace2.isEmpty() || this.housenohin.equals("null")) {
            this.binding.housenohindi.setText("");
            this.housenohin = "";
        } else {
            this.binding.housenohindi.setText(this.housenohin);
        }
        String strReplace3 = String.valueOf(this.jsonobjectForm6A.get("oriVillageTown")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.villagetown1 = strReplace3;
        if (strReplace3.isEmpty() || this.villagetown1.equals("null")) {
            this.binding.villageTown.setText("");
            this.villagetown1 = "";
        } else {
            this.binding.villageTown.setText(this.villagetown1);
        }
        String strReplace4 = String.valueOf(this.jsonobjectForm6A.get("oriVillageTownL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.villagetownhin = strReplace4;
        if (strReplace4.isEmpty() || this.villagetownhin.equals("null")) {
            this.binding.villageHindi.setText("");
            this.villagetownhin = "";
        } else {
            this.binding.villageHindi.setText(this.villagetownhin);
        }
        String strReplace5 = String.valueOf(this.jsonobjectForm6A.get("oriPostOffice")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.postoffice = strReplace5;
        if (strReplace5.isEmpty() || this.postoffice.equals("null")) {
            this.binding.postoffice.setText("");
            this.postoffice = "";
        } else {
            this.binding.postoffice.setText(this.postoffice);
        }
        String strReplace6 = String.valueOf(this.jsonobjectForm6A.get("oriPostOfficeL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.postoffice1 = strReplace6;
        if (strReplace6.isEmpty() || this.postoffice1.equals("null")) {
            this.binding.postoffice1.setText("");
            this.postoffice1 = "";
        } else {
            this.binding.postoffice1.setText(this.postoffice1);
        }
        String strReplace7 = String.valueOf(this.jsonobjectForm6A.get("oriDistrictName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.oridistrict = strReplace7;
        if (strReplace7.isEmpty() || this.oridistrict.equals("null")) {
            this.binding.village.setText("");
            this.oridistrict = "";
        } else {
            this.binding.village.setText(this.oridistrict);
        }
        String strReplace8 = String.valueOf(this.jsonobjectForm6A.get("oriPinCode")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.pincodetv = strReplace8;
        if (strReplace8.isEmpty() || this.pincodetv.equals("null")) {
            this.binding.pincodeTv.setText("");
            this.pincodetv = "";
        } else {
            this.binding.pincodeTv.setText(this.pincodetv);
        }
        String strReplace9 = String.valueOf(this.jsonobjectForm6A.get("oriLocalityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.street = strReplace9;
        if (strReplace9.isEmpty() || this.street.equals("null")) {
            this.binding.street.setText("");
            this.street = "";
        } else {
            this.binding.street.setText(this.street);
        }
        String strReplace10 = String.valueOf(this.jsonobjectForm6A.get("oriLocalityL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.streethin = strReplace10;
        if (strReplace10.isEmpty() || this.streethin.equals("null")) {
            this.binding.streets.setText("");
            this.streethin = "";
        } else {
            this.binding.streets.setText(this.streethin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void personalsame() {
        Logger.d("Fom6A JSOn : ", this.jsonobjectForm6A.toString());
        String strReplace = String.valueOf(this.jsonobjectForm6A.get("photograph")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.photo = strReplace;
        if (strReplace != null || !strReplace.equals("") || !this.photo.equals("null")) {
            Logger.d("photo befor update : ", this.photo);
            getFile1(this.photo);
        }
        this.firstName = String.valueOf(this.jsonobjectForm6A.get(Constants.FIRST_NAME)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.lastName = String.valueOf(this.jsonobjectForm6A.get(this.lastNameText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (this.firstName.isEmpty() || this.firstName.equals("null")) {
            this.firstName = "";
        }
        if (this.lastName.isEmpty() || this.lastName.equals("null")) {
            this.lastName = "";
        }
        this.binding.applicantNameTv1.setText(this.firstName + " " + this.lastName);
        this.firstNamehin = String.valueOf(this.jsonobjectForm6A.get("firstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.lastNamehin = String.valueOf(this.jsonobjectForm6A.get(this.lastNameL1)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (this.firstNamehin.isEmpty() || this.firstNamehin.equals("null")) {
            this.firstNamehin = "";
        }
        if (this.lastNamehin.isEmpty() || this.lastNamehin.equals("null")) {
            this.lastNamehin = "";
        }
        this.binding.applicantHindiTv1.setText(this.firstNamehin + " " + this.lastNamehin);
        this.relativefirstName = String.valueOf(this.jsonobjectForm6A.get("applicantRelativeName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.relativelastName = String.valueOf(this.jsonobjectForm6A.get("applicantRelavtiveSurname")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (this.relativefirstName.isEmpty() || this.relativefirstName.equals("null")) {
            this.relativefirstName = " ";
        }
        if (this.relativelastName.isEmpty() || this.relativelastName.equals("null")) {
            this.relativelastName = "";
        }
        this.binding.relativeTv1.setText(this.relativefirstName + " " + this.relativelastName);
        this.relativefirstNamehin = String.valueOf(this.jsonobjectForm6A.get("applicantRelativeNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.relativelastNamehin = String.valueOf(this.jsonobjectForm6A.get("applicantRelativeSurnameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (this.relativefirstNamehin.isEmpty() || this.relativefirstNamehin.equals("null")) {
            this.relativefirstNamehin = " ";
        }
        if (this.relativelastNamehin.isEmpty() || this.relativelastNamehin.equals("null")) {
            this.relativelastNamehin = "";
        }
        this.binding.relativenameTv1.setText(this.relativefirstNamehin + " " + this.relativelastNamehin);
        String strReplace2 = String.valueOf(this.jsonobjectForm6A.get(this.prevEpicNo)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        if (strReplace2.isEmpty() || strReplace2.equals("null") || strReplace2 == null) {
            this.binding.epicNumberTv.setVisibility(8);
            this.binding.epicNumberTv1.setVisibility(8);
            this.binding.epicNumberTv1.setText(" ");
        } else {
            this.binding.epicNumberTv.setVisibility(0);
            this.binding.epicNumberTv1.setVisibility(0);
            this.binding.epicNumberTv1.setText(strReplace2);
        }
        String strReplace3 = String.valueOf(this.jsonobjectForm6A.get("genderDescription")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.genderTv1 = strReplace3;
        if (strReplace3.isEmpty() || this.genderTv1.equals("null")) {
            this.binding.genderTv1.setText("");
            this.genderTv1 = "";
        }
        this.binding.genderTv1.setText(this.genderTv1);
        String strReplace4 = String.valueOf(this.jsonobjectForm6A.get(this.mobileNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.mobilenotv = strReplace4;
        if (strReplace4.isEmpty() || this.mobilenotv.equals("null")) {
            this.binding.mobileNoTv.setText("");
            this.mobilenotv = "";
        } else {
            this.binding.mobileNoTv.setText(this.mobilenotv);
        }
        String strReplace5 = String.valueOf(this.jsonobjectForm6A.get(this.emailText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.emaiTV = strReplace5;
        if (strReplace5.isEmpty() || this.emaiTV.equals("null")) {
            this.binding.emailTv.setText("");
            this.emaiTV = "";
        } else {
            this.binding.emailTv.setText(this.emaiTV);
        }
        String strReplace6 = String.valueOf(this.jsonobjectForm6A.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.datetype = strReplace6;
        Logger.d("dateType", strReplace6);
        if (this.datetype.isEmpty() || this.datetype.equals("null")) {
            this.binding.datetype.setText("");
            this.datetype = "";
        } else {
            try {
                this.binding.datetype.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.datetype)));
            } catch (Exception e) {
                Logger.d("error@dob", e.getMessage());
            }
        }
        String strReplace7 = String.valueOf(this.jsonobjectForm6A.get("typeOfRelation")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.relationtype = strReplace7;
        if (strReplace7.equals("FTHR")) {
            this.relation1 = this.father;
        } else if (this.relationtype.equals("MTHR")) {
            this.relation1 = this.mother;
        } else if (this.relationtype.equals("HSBN")) {
            this.relation1 = this.hsbn;
        } else if (this.relationtype.equals("WIFE")) {
            this.relation1 = "WIFE";
        } else if (this.relationtype.equals("OTHR")) {
            this.relation1 = "OTHER";
        }
        if (this.relation1.isEmpty() || this.relation1.equals("null") || this.relation1 == null) {
            this.binding.relationtype.setText("");
            this.relation1 = "";
        } else {
            this.binding.relationtype.setText(this.relation1);
        }
        String strReplace8 = String.valueOf(this.jsonobjectForm6A.get("isIndia")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.isIndia = strReplace8;
        if (strReplace8 == null || strReplace8.equals("null") || this.isIndia.equalsIgnoreCase("Y")) {
            this.isIndia = "Y";
            this.binding.indiaRb.setChecked(true);
            this.binding.outsideRb.setEnabled(false);
            this.binding.indiaLayout.setVisibility(0);
            this.binding.outsideIndiaLayout.setVisibility(8);
        } else {
            this.isIndia = "N";
            this.binding.outsideRb.setChecked(true);
            this.binding.indiaRb.setEnabled(false);
            this.binding.indiaLayout.setVisibility(8);
            this.binding.outsideIndiaLayout.setVisibility(0);
            String strReplace9 = String.valueOf(this.jsonobjectForm6A.get("placeOfBirthOutsideIndia")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            this.outsidePlaceOfBirth = strReplace9;
            if (strReplace9 == null || strReplace9.equals("null") || this.outsidePlaceOfBirth.isEmpty()) {
                this.binding.countryName.setText("");
            } else {
                this.binding.countryName.setText(this.outsidePlaceOfBirth);
            }
        }
        String strReplace10 = String.valueOf(this.jsonobjectForm6A.get("birthStateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.statepd = strReplace10;
        if (strReplace10 == null || strReplace10.isEmpty() || this.statepd.equals("null")) {
            this.binding.statePd.setText("");
            this.statepd = "";
        } else {
            this.binding.statePd.setText(this.statepd);
        }
        this.districtpd = String.valueOf(this.jsonobjectForm6A.get("birthDistrictCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.birthDistrictCode = String.valueOf(this.jsonobjectForm6A.get("birthDistrictCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.district = new ArrayList<>();
        this.districtcode1 = new ArrayList<>();
        String strReplace11 = String.valueOf(this.jsonobjectForm6A.get("birthStateCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.birthStateCode = strReplace11;
        this.commonUtilClass.getDistrict(strReplace11, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda12
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$personalsame$13(i, arrayList, arrayList2);
            }
        });
        String strReplace12 = String.valueOf(this.jsonobjectForm6A.get(this.birthTownText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
        this.townname = strReplace12;
        if (strReplace12 == null || strReplace12.isEmpty() || this.townname.equals("null")) {
            this.binding.townName.setText("");
            this.townname = "";
        } else {
            this.binding.townName.setText(this.townname);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$personalsame$13(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda28
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$personalsame$12(dialogInterface, i2);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.districtcode1);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (this.district.size() > 1) {
            String str = this.districtpd;
            if (str != null && !str.equals("")) {
                int position = this.districtadapter.getPosition(this.districtpd);
                if (position == -1) {
                    this.districtpd = "";
                    this.binding.districtPd.setText("");
                    return;
                }
                this.districtpd = this.district.get(position);
                String str2 = this.districtcode1.get(position);
                this.birthDistrictCode = str2;
                Log.d("District code district pd", str2);
                this.binding.districtPd.setText(this.districtpd);
                return;
            }
            this.districtpd = "";
            this.binding.districtPd.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$personalsame$12(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    public void getFile1(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectstorage, fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.bloapp, "ANDROIDMOB").enqueue(new AnonymousClass28(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$28, reason: invalid class name */
    class AnonymousClass28 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass28(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ApplicantDetailsFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ApplicantDetailsFragment.this.base64element1, 0);
                ApplicantDetailsFragment.this.bitmapPersonImage = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                ApplicantDetailsFragment.this.binding.personImage.setImageBitmap(ApplicantDetailsFragment.this.bitmapPersonImage);
                ApplicantDetailsFragment.this.binding.chooseCorrectPhotoName.setText(this.val$fileref);
                ApplicantDetailsFragment.this.binding.previewPhoto.setImageBitmap(ApplicantDetailsFragment.this.bitmapPersonImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$28$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = ApplicantDetailsFragment.this.commonUtilClass;
                Context contextRequireContext = ApplicantDetailsFragment.this.requireContext();
                String str = ApplicantDetailsFragment.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$28$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$2(str2, i, str3, str4);
                    }
                });
                return;
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, int i, String str2, String str3) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$28$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str2;
            ApplicantDetailsFragment.this.refreshToken = str3;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str2);
            ApplicantDetailsFragment.this.getFile1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    public void getFile2(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectstorage, fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.bloapp, "ANDROIDMOB").enqueue(new AnonymousClass29(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass29(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ApplicantDetailsFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                ApplicantDetailsFragment.this.encodedPersonImage = String.valueOf(((JsonObject) response.body()).get("file"));
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(ApplicantDetailsFragment.this.encodedPersonImage, 0));
                Logger.d("vren", "inputStream " + byteArrayInputStream);
                ApplicantDetailsFragment.this.bitmapPassportImage = BitmapFactory.decodeStream(byteArrayInputStream);
                ApplicantDetailsFragment.this.binding.chooseFileName2.setText(this.val$fileref);
                ApplicantDetailsFragment.this.binding.preview2.setImageBitmap(ApplicantDetailsFragment.this.bitmapPassportImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$29$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = ApplicantDetailsFragment.this.commonUtilClass;
                Context contextRequireContext = ApplicantDetailsFragment.this.requireContext();
                String str = ApplicantDetailsFragment.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$29$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$2(str2, i, str3, str4);
                    }
                });
                return;
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, int i, String str2, String str3) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$29$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str2;
            ApplicantDetailsFragment.this.refreshToken = str3;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str2);
            ApplicantDetailsFragment.this.getFile2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.submitTv.setOnClickListener(this);
        this.binding.pencilBtn1.setOnClickListener(this);
        this.binding.pencilBtn2.setOnClickListener(this);
        this.binding.pencilBtn3.setOnClickListener(this);
        this.binding.pencilBtn4.setOnClickListener(this);
        this.binding.pencilBtn5.setOnClickListener(this);
        this.binding.pencilBtn6.setOnClickListener(this);
    }

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
    public void onClick(View view) {
        final ApplicantDetailsFragment applicantDetailsFragment;
        int i;
        String str;
        if (view.getId() == 2131362458) {
            openFragment(new CheckListMain(), "Applicant Details");
        }
        if (view.getId() == 2131365939 && isApplicantValidated()) {
            this.viewModel.updateVoterDetails(this.referenceNo);
            createcsv();
        }
        if (view.getId() == 2131365083) {
            this.binding.personalDetailsCv.setVisibility(8);
            this.binding.addressIndiaCv.setVisibility(8);
            this.binding.visaDetailsCv.setVisibility(8);
            this.binding.passportDetailsCv.setVisibility(8);
            this.binding.ordinoryResidenceCv.setVisibility(8);
            this.binding.outsideIndiaCv.setVisibility(8);
            this.binding.informationCv.setVisibility(8);
            this.binding.remarkCv.setVisibility(8);
            this.binding.personalDetailsEditcv.setVisibility(0);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(8);
            this.binding.nameEd.setText(this.firstName);
            this.binding.nameEd2.setText(this.firstNamehin);
            this.binding.lastnameEd.setText(this.lastName);
            this.binding.lastnameEd2.setText(this.lastNamehin);
            this.binding.relativeNameEd.setText(this.relativefirstName);
            this.binding.relativeNameEd2.setText(this.relativefirstNamehin);
            this.binding.relativeLastnameEd.setText(this.relativelastName);
            this.binding.relativeLastnameEd2.setText(this.relativelastNamehin);
            try {
                this.binding.dobEd.setText(this.simpleDateFormat4.format(this.simpleDateFormat5.parse(this.datetype)));
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            String str2 = this.isIndia;
            if (str2 == null || str2.equals("null") || this.isIndia.equals("Y")) {
                this.isIndia = "Y";
                this.binding.indiaRbEd.setChecked(true);
                this.binding.indiaLayoutEd.setVisibility(0);
                this.binding.outsideIndiaLayoutEd.setVisibility(8);
            } else {
                this.binding.outsideRbEd.setChecked(true);
                this.binding.indiaLayoutEd.setVisibility(8);
                this.binding.outsideIndiaLayoutEd.setVisibility(0);
                getCountry(this.binding.outsideIndiaSpinner);
            }
            this.binding.villagePersonalSpinner.setText(this.townname);
            if (this.emaiTV.equals("")) {
                this.binding.emailEd.setText("");
            } else {
                this.binding.emailEd.setText(this.emaiTV);
            }
            if (this.mobilenotv.equals("")) {
                this.binding.mobileNumEd.setText("");
            } else {
                this.binding.mobileNumEd.setText(this.mobilenotv);
            }
            this.binding.relativeNameEd2.setOnFocusChangeListener(this);
            this.binding.relativeLastnameEd2.setOnFocusChangeListener(this);
            this.binding.nameEd2.setOnFocusChangeListener(this);
            this.binding.lastnameEd2.setOnFocusChangeListener(this);
            this.binding.refNoTv.setText(this.referenceNo);
            this.binding.formTypeTv.setText("Form 6A");
            getRelationData();
            this.binding.relationSpinner.setOnItemSelectedListener(this);
            this.binding.statePersonalSpinner.setOnItemSelectedListener(this);
            this.binding.genderPersonalSpinner.setOnItemSelectedListener(this);
            this.binding.districtPersonalSpinner.setOnItemSelectedListener(this);
            this.binding.previewPhoto.setVisibility(0);
            this.binding.chooseCorrectPhotoFileDeletion.setVisibility(0);
            this.binding.choosePhotoSize.setVisibility(0);
            this.binding.chooseCorrectPhotoName.setVisibility(0);
            this.binding.chooseCorrectPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$14(view2);
                }
            });
            this.binding.chooseCorrectPhotoFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda41
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$15(view2);
                }
            });
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(1, -125);
            final long time = calendar.getTime().getTime();
            Date date2 = new Date();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
            String str3 = this.dobQualifyingDate;
            if (str3 != "") {
                try {
                    calendar2.setTime(simpleDateFormat.parse(str3));
                } catch (ParseException e2) {
                    Logger.d("", e2.getMessage());
                }
            } else {
                calendar2.setTime(date2);
                calendar2.set(2, 9);
                calendar2.set(5, 1);
                calendar2.set(1, 2005);
            }
            final long time2 = calendar2.getTime().getTime();
            final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda53
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    this.f$0.lambda$onClick$16(datePicker, i2, i3, i4);
                }
            };
            this.binding.dobageDatepickpd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda64
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$17(onDateSetListener, time2, time, view2);
                }
            });
            final String string = this.binding.nameEd.getText().toString();
            final String string2 = this.binding.lastnameEd.getText().toString();
            final String string3 = this.binding.relativeNameEd.getText().toString();
            final String string4 = this.binding.relativeLastnameEd.getText().toString();
            final String str4 = this.relation1;
            final String str5 = this.genderTv1;
            final String string5 = this.binding.dobEd.getText().toString();
            final String string6 = this.binding.villagePersonalSpinner.getText().toString();
            final String string7 = this.binding.emailEd.getText().toString();
            final String str6 = this.statepd;
            final String str7 = this.isIndia;
            final String str8 = this.outsidePlaceOfBirth;
            final String string8 = this.binding.mobileNumEd.getText().toString();
            final String string9 = this.binding.nameEd2.getText().toString();
            final String string10 = this.binding.lastnameEd2.getText().toString();
            final String string11 = this.binding.relativeNameEd2.getText().toString();
            final String string12 = this.binding.relativeLastnameEd2.getText().toString();
            this.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda65
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$18(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, str7, str8, str5, str4, str6, view2);
                }
            });
            final ApplicantDetailsFragment applicantDetailsFragment2 = this;
            applicantDetailsFragment2.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda67
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$19(view2);
                }
            });
            applicantDetailsFragment2.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda68
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$20(view2);
                }
            });
            applicantDetailsFragment2.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda69
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$22(view2);
                }
            });
            applicantDetailsFragment = applicantDetailsFragment2;
        } else {
            applicantDetailsFragment = this;
        }
        if (view.getId() == 2131365084) {
            i = 8;
            applicantDetailsFragment.binding.personalDetailsCv.setVisibility(8);
            applicantDetailsFragment.binding.addressIndiaCv.setVisibility(8);
            applicantDetailsFragment.binding.visaDetailsCv.setVisibility(8);
            applicantDetailsFragment.binding.passportDetailsCv.setVisibility(8);
            applicantDetailsFragment.binding.ordinoryResidenceCv.setVisibility(8);
            applicantDetailsFragment.binding.outsideIndiaCv.setVisibility(8);
            applicantDetailsFragment.binding.informationCv.setVisibility(8);
            applicantDetailsFragment.binding.remarkCv.setVisibility(8);
            applicantDetailsFragment.binding.personalDetailsEditcv.setVisibility(8);
            applicantDetailsFragment.binding.indiaAddressEditcv.setVisibility(0);
            applicantDetailsFragment.binding.visaDetailsEditcv.setVisibility(8);
            applicantDetailsFragment.binding.passportDetailsEditcv.setVisibility(8);
            applicantDetailsFragment.binding.noteEditcv.setVisibility(8);
            applicantDetailsFragment.binding.ordinaryResidenceEditcv.setVisibility(8);
            applicantDetailsFragment.binding.outsideIndiaEditcv.setVisibility(8);
            applicantDetailsFragment.binding.bottomSubmitLayout2.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout.setVisibility(8);
            applicantDetailsFragment.binding.houseNoEd.setText(applicantDetailsFragment.houseno1);
            applicantDetailsFragment.binding.houseNoEdhindi.setText(applicantDetailsFragment.housenohin);
            applicantDetailsFragment.binding.villageEd.setText(applicantDetailsFragment.villagetown1);
            applicantDetailsFragment.binding.villageEdhindi.setText(applicantDetailsFragment.villagetownhin);
            applicantDetailsFragment.binding.pincodeEd.setText(applicantDetailsFragment.pincodetv);
            applicantDetailsFragment.binding.streetEd.setText(applicantDetailsFragment.street);
            applicantDetailsFragment.binding.streetEdhindi.setText(applicantDetailsFragment.streethin);
            applicantDetailsFragment.binding.districtSpinner1.setText(applicantDetailsFragment.oridistrict);
            applicantDetailsFragment.binding.postofficeEd.setText(applicantDetailsFragment.postoffice);
            applicantDetailsFragment.binding.postOfficehin.setText(applicantDetailsFragment.postoffice1);
            applicantDetailsFragment.binding.houseNoEdhindi.setOnFocusChangeListener(applicantDetailsFragment);
            applicantDetailsFragment.binding.villageEdhindi.setOnFocusChangeListener(applicantDetailsFragment);
            applicantDetailsFragment.binding.streetEdhindi.setOnFocusChangeListener(applicantDetailsFragment);
            applicantDetailsFragment.binding.postOfficehin.setOnFocusChangeListener(applicantDetailsFragment);
            final String string13 = applicantDetailsFragment.binding.houseNoEd.getText().toString();
            final String string14 = applicantDetailsFragment.binding.houseNoEdhindi.getText().toString();
            final String string15 = applicantDetailsFragment.binding.streetEdhindi.getText().toString();
            final String string16 = applicantDetailsFragment.binding.villageEdhindi.getText().toString();
            final String string17 = applicantDetailsFragment.binding.postOfficehin.getText().toString();
            final String string18 = applicantDetailsFragment.binding.streetEd.getText().toString();
            final String string19 = applicantDetailsFragment.binding.villageEd.getText().toString();
            final String string20 = applicantDetailsFragment.binding.pincodeEd.getText().toString();
            final String string21 = applicantDetailsFragment.binding.postofficeEd.getText().toString();
            final String string22 = applicantDetailsFragment.binding.districtSpinner1.getText().toString();
            applicantDetailsFragment.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda70
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$23(string13, string18, string19, string20, string21, string22, string14, string15, string17, string16, view2);
                }
            });
            applicantDetailsFragment.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda71
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$24(view2);
                }
            });
            applicantDetailsFragment.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$25(view2);
                }
            });
            applicantDetailsFragment.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$27(view2);
                }
            });
        } else {
            i = 8;
        }
        if (view.getId() == 2131365085) {
            applicantDetailsFragment.binding.personalDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.addressIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.ordinoryResidenceCv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.informationCv.setVisibility(i);
            applicantDetailsFragment.binding.remarkCv.setVisibility(i);
            applicantDetailsFragment.binding.personalDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.indiaAddressEditcv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsEditcv.setVisibility(0);
            applicantDetailsFragment.binding.noteEditcv.setVisibility(i);
            applicantDetailsFragment.binding.ordinaryResidenceEditcv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaEditcv.setVisibility(i);
            applicantDetailsFragment.binding.bottomSubmitLayout2.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout.setVisibility(i);
            applicantDetailsFragment.binding.placeIssueEd.setText(applicantDetailsFragment.passportissueplace);
            applicantDetailsFragment.binding.passportEd.setText(applicantDetailsFragment.passportno);
            try {
                applicantDetailsFragment.binding.issueDateEd.setText(applicantDetailsFragment.simpleDateFormat4.format(applicantDetailsFragment.simpleDateFormat5.parse(applicantDetailsFragment.passportissue)));
                str = "";
            } catch (ParseException e3) {
                str = r11;
                Logger.d(str, e3.getMessage());
            }
            try {
                applicantDetailsFragment.binding.expiryDateEd.setText(applicantDetailsFragment.simpleDateFormat4.format(applicantDetailsFragment.simpleDateFormat5.parse(applicantDetailsFragment.passportexpiry)));
            } catch (ParseException e4) {
                Logger.d(str, e4.getMessage());
            }
            if (!applicantDetailsFragment.passportdocuments.equals("null")) {
                applicantDetailsFragment.getFile2(applicantDetailsFragment.passportdocuments);
            }
            final DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda32
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    this.f$0.lambda$onClick$28(datePicker, i2, i3, i4);
                }
            };
            applicantDetailsFragment.binding.dobageDatepicker1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$29(onDateSetListener2, view2);
                }
            });
            applicantDetailsFragment.binding.chooseFileName2.setText(str);
            applicantDetailsFragment.binding.chooseFileDeletion2.setVisibility(0);
            applicantDetailsFragment.binding.chooseFileName2.setVisibility(0);
            applicantDetailsFragment.binding.chooseFileName2Size.setVisibility(0);
            applicantDetailsFragment.binding.preview2.setVisibility(0);
            applicantDetailsFragment.binding.chooseFile2.setTextColor(Color.parseColor(applicantDetailsFragment.whitecolor));
            applicantDetailsFragment.binding.chooseFile2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$30(view2);
                }
            });
            applicantDetailsFragment.binding.chooseFileDeletion2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$31(view2);
                }
            });
            final String string23 = applicantDetailsFragment.binding.placeIssueEd.getText().toString();
            final String string24 = applicantDetailsFragment.binding.passportEd.getText().toString();
            final String string25 = applicantDetailsFragment.binding.issueDateEd.getText().toString();
            final String string26 = applicantDetailsFragment.binding.expiryDateEd.getText().toString();
            applicantDetailsFragment.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$32(string23, string24, string25, string26, view2);
                }
            });
            applicantDetailsFragment.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda38
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$33(view2);
                }
            });
            applicantDetailsFragment.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda39
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$34(view2);
                }
            });
            applicantDetailsFragment.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$35(view2);
                }
            });
        } else {
            str = r11;
        }
        if (view.getId() == 2131365086) {
            applicantDetailsFragment.binding.personalDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.addressIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.ordinoryResidenceCv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.informationCv.setVisibility(i);
            applicantDetailsFragment.binding.remarkCv.setVisibility(i);
            applicantDetailsFragment.binding.personalDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.indiaAddressEditcv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsEditcv.setVisibility(0);
            applicantDetailsFragment.binding.passportDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.noteEditcv.setVisibility(0);
            applicantDetailsFragment.binding.ordinaryResidenceEditcv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaEditcv.setVisibility(i);
            applicantDetailsFragment.binding.bottomSubmitLayout2.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout.setVisibility(i);
            applicantDetailsFragment.binding.visaNoEd.setText(applicantDetailsFragment.visano);
            try {
                applicantDetailsFragment.binding.issueDateEdVisa.setText(applicantDetailsFragment.simpleDateFormat4.format(applicantDetailsFragment.simpleDateFormat5.parse(applicantDetailsFragment.visaissue)));
            } catch (ParseException unused) {
                applicantDetailsFragment.binding.issueDateEdVisa.setText(str);
            }
            try {
                applicantDetailsFragment.binding.expiryDateEdVisa.setText(applicantDetailsFragment.simpleDateFormat4.format(applicantDetailsFragment.simpleDateFormat5.parse(applicantDetailsFragment.visaexpiry)));
            } catch (ParseException unused2) {
                applicantDetailsFragment.binding.expiryDateEdVisa.setText(str);
            }
            applicantDetailsFragment.binding.visaTypeEd.setText(applicantDetailsFragment.visatype);
            applicantDetailsFragment.binding.authorityEd.setText(applicantDetailsFragment.visaAuthority);
            final DatePickerDialog.OnDateSetListener onDateSetListener3 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda42
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    this.f$0.lambda$onClick$36(datePicker, i2, i3, i4);
                }
            };
            applicantDetailsFragment.binding.dobageDatepickervisa.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$37(onDateSetListener3, view2);
                }
            });
            final DatePickerDialog.OnDateSetListener onDateSetListener4 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda45
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    this.f$0.lambda$onClick$38(datePicker, i2, i3, i4);
                }
            };
            applicantDetailsFragment.binding.dobageDatepickervisa1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda46
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$39(onDateSetListener4, view2);
                }
            });
            final String string27 = applicantDetailsFragment.binding.visaNoEd.getText().toString();
            final String string28 = applicantDetailsFragment.binding.issueDateEdVisa.getText().toString();
            final String string29 = applicantDetailsFragment.binding.expiryDateEdVisa.getText().toString();
            final String string30 = applicantDetailsFragment.binding.visaTypeEd.getText().toString();
            final String string31 = applicantDetailsFragment.binding.authorityEd.getText().toString();
            applicantDetailsFragment.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda47
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$40(string27, string28, string29, string30, string31, view2);
                }
            });
            applicantDetailsFragment.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$41(view2);
                }
            });
            applicantDetailsFragment.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda49
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$42(view2);
                }
            });
            applicantDetailsFragment.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$43(view2);
                }
            });
        }
        if (view.getId() == 2131365087) {
            applicantDetailsFragment.binding.personalDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.addressIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.ordinoryResidenceCv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.informationCv.setVisibility(i);
            applicantDetailsFragment.binding.remarkCv.setVisibility(i);
            applicantDetailsFragment.binding.personalDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.indiaAddressEditcv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.noteEditcv.setVisibility(i);
            applicantDetailsFragment.binding.ordinaryResidenceEditcv.setVisibility(0);
            applicantDetailsFragment.binding.outsideIndiaEditcv.setVisibility(i);
            applicantDetailsFragment.binding.bottomSubmitLayout2.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout.setVisibility(i);
            try {
                applicantDetailsFragment.binding.dateEd.setText(applicantDetailsFragment.simpleDateFormat4.format(applicantDetailsFragment.simpleDateFormat5.parse(applicantDetailsFragment.ordinarydateTv)));
            } catch (ParseException e5) {
                Logger.d(str, e5.getMessage());
            }
            if (applicantDetailsFragment.reasonAbsent1.equals(applicantDetailsFragment.employment)) {
                applicantDetailsFragment.binding.employment.setChecked(true);
                applicantDetailsFragment.binding.desLayout.setVisibility(i);
            } else if (applicantDetailsFragment.reasonAbsent1.equals(applicantDetailsFragment.education)) {
                applicantDetailsFragment.binding.education.setChecked(true);
                applicantDetailsFragment.binding.desLayout.setVisibility(i);
            } else if (applicantDetailsFragment.reasonAbsent1.equals(applicantDetailsFragment.other)) {
                applicantDetailsFragment.binding.other.setChecked(true);
                applicantDetailsFragment.binding.descEd.setText(applicantDetailsFragment.reason);
                applicantDetailsFragment.binding.desLayout.setVisibility(0);
            }
            final DatePickerDialog.OnDateSetListener onDateSetListener5 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda51
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    this.f$0.lambda$onClick$44(datePicker, i2, i3, i4);
                }
            };
            applicantDetailsFragment.binding.dobageDatepickor.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda52
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$45(onDateSetListener5, view2);
                }
            });
            final String string32 = applicantDetailsFragment.binding.dateEd.getText().toString();
            final String str9 = applicantDetailsFragment.reasonAbsent1;
            final String string33 = applicantDetailsFragment.binding.descEd.getText().toString();
            applicantDetailsFragment.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda54
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$46(string32, str9, string33, view2);
                }
            });
            applicantDetailsFragment.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda56
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$47(view2);
                }
            });
            applicantDetailsFragment.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda57
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$48(view2);
                }
            });
            applicantDetailsFragment.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda58
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$49(view2);
                }
            });
        }
        if (view.getId() == 2131365088) {
            applicantDetailsFragment.binding.personalDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.addressIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsCv.setVisibility(i);
            applicantDetailsFragment.binding.ordinoryResidenceCv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaCv.setVisibility(i);
            applicantDetailsFragment.binding.informationCv.setVisibility(i);
            applicantDetailsFragment.binding.remarkCv.setVisibility(i);
            applicantDetailsFragment.binding.personalDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.indiaAddressEditcv.setVisibility(i);
            applicantDetailsFragment.binding.visaDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.passportDetailsEditcv.setVisibility(i);
            applicantDetailsFragment.binding.noteEditcv.setVisibility(i);
            applicantDetailsFragment.binding.ordinaryResidenceEditcv.setVisibility(i);
            applicantDetailsFragment.binding.outsideIndiaEditcv.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout2.setVisibility(0);
            applicantDetailsFragment.binding.bottomSubmitLayout.setVisibility(i);
            applicantDetailsFragment.binding.houseNoEd2.setText(applicantDetailsFragment.houseNo);
            applicantDetailsFragment.binding.streetEd2.setText(applicantDetailsFragment.streetArea);
            applicantDetailsFragment.binding.villageSpinner2.setText(applicantDetailsFragment.villageTown);
            applicantDetailsFragment.binding.zipEd.setText(applicantDetailsFragment.countryZipcode);
            applicantDetailsFragment.binding.stateOutsideSpinner.setText(applicantDetailsFragment.state1);
            applicantDetailsFragment.country = new ArrayList<>();
            applicantDetailsFragment.commonUtilClass.getCountry(applicantDetailsFragment.stateCode, applicantDetailsFragment.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda59
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$onClick$53(i2, arrayList, arrayList2);
                }
            });
            final String string34 = applicantDetailsFragment.binding.houseNoEd2.getText().toString();
            final String string35 = applicantDetailsFragment.binding.streetEd2.getText().toString();
            final String string36 = applicantDetailsFragment.binding.villageSpinner2.getText().toString();
            final String string37 = applicantDetailsFragment.binding.zipEd.getText().toString();
            final String string38 = applicantDetailsFragment.binding.stateOutsideSpinner.getText().toString();
            final String str10 = applicantDetailsFragment.countryCode;
            applicantDetailsFragment.binding.countrySpinner.setOnItemSelectedListener(applicantDetailsFragment);
            applicantDetailsFragment.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda60
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$54(string34, string35, string36, string37, str10, string38, view2);
                }
            });
            applicantDetailsFragment.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda61
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$55(view2);
                }
            });
            applicantDetailsFragment.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda62
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$56(view2);
                }
            });
            applicantDetailsFragment.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$onClick$57(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$14(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$15(View view) {
        this.binding.chooseCorrectPhotoName.setText("");
        this.binding.previewPhoto.setVisibility(8);
        this.binding.chooseCorrectPhotoFileDeletion.setVisibility(8);
        this.binding.choosePhotoSize.setVisibility(8);
        this.binding.chooseCorrectPhotoName.setVisibility(8);
        this.binding.chooseCorrectPhoto.setTextColor(Color.parseColor(this.whitecolor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$16(DatePicker datePicker, int i, int i2, int i3) {
        this.myCalendar.set(1, i);
        this.myCalendar.set(2, i2);
        this.myCalendar.set(5, i3);
        updateIssueDatedob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$17(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.myCalendar.get(1), this.myCalendar.get(2), this.myCalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$18(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, View view) {
        this.binding.nameEd.setText(str);
        this.binding.lastnameEd.setText(str2);
        this.binding.relativeNameEd.setText(str3);
        this.binding.relativeLastnameEd.setText(str4);
        this.binding.dobEd.setText(str5);
        this.binding.villagePersonalSpinner.setText(str6);
        this.binding.emailEd.setText(str7);
        this.binding.mobileNumEd.setText(str8);
        this.binding.nameEd2.setText(str9);
        this.binding.lastnameEd2.setText(str10);
        this.binding.relativeNameEd2.setText(str11);
        this.binding.relativeLastnameEd2.setText(str12);
        if (str13 == null || str13.equals("null") || str13.equals("Y")) {
            this.binding.indiaRbEd.setChecked(true);
            this.binding.indiaLayoutEd.setVisibility(0);
            this.isIndia = "Y";
            this.binding.outsideIndiaLayoutEd.setVisibility(8);
        } else {
            this.binding.outsideRbEd.setChecked(true);
            this.binding.indiaLayoutEd.setVisibility(8);
            this.isIndia = "N";
            this.binding.outsideIndiaLayoutEd.setVisibility(0);
            this.binding.outsideIndiaSpinner.setSelection(this.country.indexOf(str14));
        }
        getResetFunction(str15, str16, str17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$19(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$20(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$22(View view) {
        if (isShftingDataOk()) {
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.firstName = this.binding.nameEd.getText().toString();
            this.lastName = this.binding.lastnameEd.getText().toString();
            this.relativefirstName = this.binding.relativeNameEd.getText().toString();
            this.relativelastName = this.binding.relativeLastnameEd.getText().toString();
            this.datetype = this.binding.dobEd.getText().toString();
            if (this.binding.emailEd.getText().toString().isEmpty()) {
                this.emaiTV = "";
            } else {
                this.emaiTV = this.binding.emailEd.getText().toString();
            }
            if (this.binding.mobileNumEd.getText().toString().isEmpty()) {
                this.mobilenotv = "";
            } else {
                this.mobilenotv = this.binding.mobileNumEd.getText().toString();
            }
            this.relationtype = this.binding.relationSpinner.getSelectedItem().toString();
            this.genderTv1 = this.binding.genderPersonalSpinner.getSelectedItem().toString();
            String string = this.binding.nameEd2.getText().toString();
            String string2 = this.binding.lastnameEd2.getText().toString();
            String string3 = this.binding.relativeNameEd2.getText().toString();
            String string4 = this.binding.relativeLastnameEd2.getText().toString();
            String str = this.photo;
            if (str != null || !str.equals("") || !this.photo.equals("null")) {
                getFile1(this.photo);
            }
            this.binding.applicantNameTv1.setText(this.firstName + " " + this.lastName);
            this.binding.relativeTv1.setText(this.relativefirstName + " " + this.relativelastName);
            this.binding.applicantHindiTv1.setText(string + " " + string2);
            this.binding.relativenameTv1.setText(string3 + " " + string4);
            this.binding.datetype.setText(this.datetype);
            this.binding.placeOfBirthRGEd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda21
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    this.f$0.lambda$onClick$21(radioGroup, i);
                }
            });
            if (this.isIndia.equals("Y")) {
                this.binding.placeOfBirthRG.clearCheck();
                this.binding.indiaRb.setChecked(true);
                this.binding.outsideRb.setEnabled(false);
                this.binding.indiaLayout.setVisibility(0);
                this.binding.outsideIndiaLayout.setVisibility(8);
                this.outsidePlaceOfBirth = null;
                this.binding.outsideIndiaSpinner.setSelection(0);
                this.statepd = this.binding.statePersonalSpinner.getSelectedItem().toString();
                this.districtpd = this.binding.districtPersonalSpinner.getSelectedItem().toString();
                this.binding.statePd.setText(this.statepd);
                this.binding.districtPd.setText(this.districtpd);
                this.townname = this.binding.villagePersonalSpinner.getText().toString();
                this.binding.townName.setText(this.townname);
            } else if (this.isIndia.equals("N")) {
                this.binding.placeOfBirthRG.clearCheck();
                this.binding.outsideRb.setChecked(true);
                this.binding.indiaRb.setEnabled(false);
                this.binding.villagePersonalSpinner.setText("");
                this.birthDistrictCode = "";
                this.birthStateCode = "";
                this.binding.statePersonalSpinner.setSelection(0);
                this.binding.districtPersonalSpinner.setSelection(0);
                this.binding.outsideIndiaLayout.setVisibility(0);
                this.outsidePlaceOfBirth = this.binding.outsideIndiaSpinner.getSelectedItem().toString();
                this.binding.indiaLayout.setVisibility(8);
                this.binding.countryName.setText(this.outsidePlaceOfBirth);
            }
            this.binding.emailTv.setText(this.emaiTV);
            this.binding.mobileNoTv.setText(this.mobilenotv);
            this.binding.relationtype.setText(this.relationtype);
            this.binding.genderTv1.setText(this.genderTv1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$21(RadioGroup radioGroup, int i) {
        if (i == 2131364197) {
            this.isIndia = "Y";
        } else {
            if (i != 2131364987) {
                return;
            }
            this.isIndia = "N";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$23(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, View view) {
        this.binding.houseNoEd.setText(str);
        this.binding.streetEd.setText(str2);
        this.binding.villageEd.setText(str3);
        this.binding.pincodeEd.setText(str4);
        this.binding.postofficeEd.setText(str5);
        this.binding.districtSpinner1.setText(str6);
        this.binding.houseNoEdhindi.setText(str7);
        this.binding.streetEdhindi.setText(str8);
        this.binding.postOfficehin.setText(str9);
        this.binding.villageEdhindi.setText(str10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$24(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$25(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$27(View view) {
        if (indiaaddress()) {
            Toast.makeText(getContext(), this.data, 0).show();
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.houseno1 = this.binding.houseNoEd.getText().toString();
            this.housenohin = this.binding.houseNoEdhindi.getText().toString();
            this.street = this.binding.streetEd.getText().toString();
            this.streethin = this.binding.streetEdhindi.getText().toString();
            this.villagetown1 = this.binding.villageEd.getText().toString();
            this.villagetownhin = this.binding.villageEdhindi.getText().toString();
            this.pincodetv = this.binding.pincodeEd.getText().toString();
            this.oridistrict = this.binding.districtSpinner1.getText().toString();
            this.postoffice = this.binding.postofficeEd.getText().toString();
            this.postoffice1 = this.binding.postOfficehin.getText().toString();
            String string = this.binding.houseno.getText().toString();
            String string2 = this.binding.street.getText().toString();
            String string3 = this.binding.villageTown.getText().toString();
            String string4 = this.binding.postoffice.getText().toString();
            this.binding.houseno.setText(this.houseno1);
            this.binding.housenohindi.setText(this.housenohin);
            this.binding.street.setText(this.street);
            this.binding.streets.setText(this.streethin);
            this.binding.villageTown.setText(this.villagetown1);
            this.binding.villageHindi.setText(this.villagetownhin);
            this.binding.pincodeTv.setText(this.pincodetv);
            this.binding.village.setText(this.districtpd);
            this.binding.postoffice.setText(this.postoffice);
            this.binding.postoffice1.setText(this.postoffice1);
            try {
                if (!string.equals(this.houseno1)) {
                    FormsMethod.translitration(this.binding.houseNoEd.getText().toString().trim(), this.binding.housenohindi, this.partLang, this.addressfield);
                }
                if (!string2.equals(this.street)) {
                    FormsMethod.translitration(this.binding.streetEd.getText().toString().trim(), this.binding.streets, this.partLang, this.addressfield);
                }
                if (!string3.equals(this.villagetown1)) {
                    FormsMethod.translitration(this.binding.villageEd.getText().toString().trim(), this.binding.villageHindi, this.partLang, this.addressfield);
                }
                if (!string4.equals(this.postoffice)) {
                    FormsMethod.translitration(this.binding.postofficeEd.getText().toString().trim(), this.binding.postoffice1, this.partLang, this.addressfield);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onClick$26();
                    }
                }, 1000L);
            } catch (IOException e) {
                Logger.d("", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$26() {
        this.housenohin = this.binding.housenohindi.getText().toString();
        this.streethin = this.binding.streets.getText().toString();
        this.villagetownhin = this.binding.villageHindi.getText().toString();
        this.postoffice1 = this.binding.postoffice1.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$28(DatePicker datePicker, int i, int i2, int i3) {
        this.myCalendarpassport.set(1, i);
        this.myCalendarpassport.set(2, i2);
        this.myCalendarpassport.set(5, i3);
        updateIssueDatepassport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$29(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.myCalendarpassport.get(1), this.myCalendarpassport.get(2), this.myCalendarpassport.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$30(View view) {
        selectImage1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$31(View view) {
        this.binding.chooseFileName2.setText("");
        this.binding.chooseFileDeletion2.setVisibility(8);
        this.binding.chooseFileName2.setVisibility(8);
        this.binding.chooseFileName2Size.setVisibility(8);
        this.binding.preview2.setVisibility(8);
        this.binding.chooseFile2.setTextColor(Color.parseColor(this.whitecolor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$32(String str, String str2, String str3, String str4, View view) {
        this.binding.placeIssueEd.setText(str);
        this.binding.passportEd.setText(str2);
        this.binding.issueDateEd.setText(str3);
        this.binding.expiryDateEd.setText(str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$33(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$34(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$35(View view) {
        if (passportdetails()) {
            Toast.makeText(getContext(), this.data, 0).show();
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.passportissueplace = this.binding.placeIssueEd.getText().toString();
            this.passportno = this.binding.passportEd.getText().toString();
            this.passportissue = this.binding.issueDateEd.getText().toString();
            this.passportexpiry = this.binding.expiryDateEd.getText().toString();
            String str = this.passportdocuments;
            if (str != null || !str.equals("") || !this.passportdocuments.equals("null")) {
                getFile2(this.passportdocuments);
            }
            this.binding.passportissuePlace.setText(this.passportissueplace);
            this.binding.passportNo.setText(this.passportno);
            this.binding.passportIssue.setText(this.passportissue);
            this.binding.passportExpiry.setText(this.passportexpiry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$36(DatePicker datePicker, int i, int i2, int i3) {
        this.myCalendarvisa.set(1, i);
        this.myCalendarvisa.set(2, i2);
        this.myCalendarvisa.set(5, i3);
        updateIssueDatevisa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$37(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.myCalendarvisa.get(1), this.myCalendarvisa.get(2), this.myCalendarvisa.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$38(DatePicker datePicker, int i, int i2, int i3) {
        this.myCalendarvisa1.set(1, i);
        this.myCalendarvisa1.set(2, i2);
        this.myCalendarvisa1.set(5, i3);
        updateexpiryDatevisa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$39(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.myCalendarvisa1.get(1), this.myCalendarvisa1.get(2), this.myCalendarvisa1.get(5));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$40(String str, String str2, String str3, String str4, String str5, View view) {
        this.binding.visaNoEd.setText(str);
        this.binding.issueDateEdVisa.setText(str2);
        this.binding.expiryDateEdVisa.setText(str3);
        this.binding.visaTypeEd.setText(str4);
        this.binding.authorityEd.setText(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$41(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$42(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$43(View view) {
        if (visadetails()) {
            Toast.makeText(getContext(), this.data, 0).show();
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.visano = this.binding.visaNoEd.getText().toString();
            this.visaissue = this.binding.issueDateEdVisa.getText().toString();
            this.visaexpiry = this.binding.expiryDateEdVisa.getText().toString();
            this.visatype = this.binding.visaTypeEd.getText().toString();
            this.visaAuthority = this.binding.authorityEd.getText().toString();
            this.binding.visaNo.setText(this.visano);
            this.binding.visaIssue.setText(this.visaissue);
            this.binding.visaExpiry.setText(this.visaexpiry);
            this.binding.visaType.setText(this.visatype);
            this.binding.visaAuthority.setText(this.visaAuthority);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$44(DatePicker datePicker, int i, int i2, int i3) {
        this.myCalendaror.set(1, i);
        this.myCalendaror.set(2, i2);
        this.myCalendaror.set(5, i3);
        updateIssueDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$45(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.myCalendaror.get(1), this.myCalendaror.get(2), this.myCalendaror.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$46(String str, String str2, String str3, View view) {
        this.binding.dateEd.setText(str);
        if (str2.equals(this.employment)) {
            this.binding.employment.setChecked(true);
            this.binding.desLayout.setVisibility(8);
        } else {
            this.binding.employment.setChecked(false);
            this.binding.desLayout.setVisibility(8);
        }
        if (str2.equals(this.education)) {
            this.binding.education.setChecked(true);
            this.binding.desLayout.setVisibility(8);
        } else {
            this.binding.education.setChecked(false);
            this.binding.desLayout.setVisibility(8);
        }
        if (str2.equals(this.other)) {
            this.binding.other.setChecked(true);
            this.binding.descEd.setText(str3);
            this.binding.desLayout.setVisibility(0);
        } else {
            this.binding.other.setChecked(false);
            this.binding.descEd.setText("");
            this.binding.desLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$47(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$48(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$49(View view) {
        if (ordinaryresidence()) {
            Toast.makeText(getContext(), this.data, 0).show();
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.ordinarydateTv = this.binding.dateEd.getText().toString();
            if (this.reasonAbsent1.equals(this.other)) {
                this.binding.reasonAbsent.setText(this.binding.descEd.getText().toString());
            } else {
                this.binding.reasonAbsent.setText(this.reasonAbsent1);
            }
            this.binding.ordinarydateTv.setText(this.ordinarydateTv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$53(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda78
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onClick$52(i2, str, str2);
                }
            });
            return;
        }
        this.country = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(Constants.COUNTRYNAME1);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        String str = this.countryCode;
        if (str != null && !str.equals("")) {
            this.binding.countrySpinner.setSelection(this.countryadapter.getPosition(this.countryRp));
        } else {
            this.countryRp = "";
            this.binding.countrySpinner.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$52(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onClick$50(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$onClick$51(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$50(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$51(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(Constants.COUNTRYNAME1);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        String str = this.countryCode;
        if (str != null && !str.equals("")) {
            this.binding.countrySpinner.setSelection(this.countryadapter.getPosition(this.countryRp));
        } else {
            this.countryRp = "";
            this.binding.countrySpinner.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$54(String str, String str2, String str3, String str4, String str5, String str6, View view) {
        this.binding.houseNoEd2.setText(str);
        this.binding.streetEd2.setText(str2);
        this.binding.villageSpinner2.setText(str3);
        this.binding.zipEd.setText(str4);
        if (this.country != null) {
            this.binding.countrySpinner.setSelection(this.countryadapter.getPosition(str5));
        } else {
            this.countryRp = "";
            this.binding.countrySpinner.setSelection(0);
        }
        this.binding.stateOutsideSpinner.setText(str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$55(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
        this.binding.bottomSubmitLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$56(View view) {
        this.binding.personalDetailsCv.setVisibility(0);
        this.binding.addressIndiaCv.setVisibility(0);
        this.binding.visaDetailsCv.setVisibility(0);
        this.binding.passportDetailsCv.setVisibility(0);
        this.binding.ordinoryResidenceCv.setVisibility(0);
        this.binding.outsideIndiaCv.setVisibility(0);
        this.binding.informationCv.setVisibility(0);
        this.binding.remarkCv.setVisibility(0);
        this.binding.bottomSubmitLayout.setVisibility(0);
        this.binding.personalDetailsEditcv.setVisibility(8);
        this.binding.indiaAddressEditcv.setVisibility(8);
        this.binding.visaDetailsEditcv.setVisibility(8);
        this.binding.passportDetailsEditcv.setVisibility(8);
        this.binding.noteEditcv.setVisibility(8);
        this.binding.ordinaryResidenceEditcv.setVisibility(8);
        this.binding.outsideIndiaEditcv.setVisibility(8);
        this.binding.bottomSubmitLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$57(View view) {
        if (outsideindia()) {
            Toast.makeText(getContext(), this.data, 0).show();
            this.binding.personalDetailsCv.setVisibility(0);
            this.binding.addressIndiaCv.setVisibility(0);
            this.binding.visaDetailsCv.setVisibility(0);
            this.binding.passportDetailsCv.setVisibility(0);
            this.binding.ordinoryResidenceCv.setVisibility(0);
            this.binding.outsideIndiaCv.setVisibility(0);
            this.binding.informationCv.setVisibility(0);
            this.binding.remarkCv.setVisibility(0);
            this.binding.bottomSubmitLayout.setVisibility(0);
            this.binding.personalDetailsEditcv.setVisibility(8);
            this.binding.indiaAddressEditcv.setVisibility(8);
            this.binding.visaDetailsEditcv.setVisibility(8);
            this.binding.passportDetailsEditcv.setVisibility(8);
            this.binding.noteEditcv.setVisibility(8);
            this.binding.ordinaryResidenceEditcv.setVisibility(8);
            this.binding.outsideIndiaEditcv.setVisibility(8);
            this.binding.bottomSubmitLayout2.setVisibility(8);
            this.houseNo = this.binding.houseNoEd2.getText().toString();
            this.streetArea = this.binding.streetEd2.getText().toString();
            this.countryZipcode = this.binding.zipEd.getText().toString();
            this.state1 = this.binding.stateOutsideSpinner.getText().toString();
            this.countryRp = this.binding.countrySpinner.getSelectedItem().toString();
            this.villageTown = this.binding.villageSpinner2.getText().toString();
            this.binding.houseNo.setText(this.houseNo);
            this.binding.streetArea.setText(this.streetArea);
            this.binding.villagTown.setText(this.villageTown);
            this.binding.countryZipcode.setText(this.countryZipcode);
            this.binding.state.setText(this.state1);
            this.binding.countryRp.setText(this.countryRp);
        }
    }

    private void getResetFunction(final String resetGender, final String resetRelation, final String resetState) {
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda20
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getResetFunction$62(resetGender, resetRelation, resetState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getResetFunction$62(final String str, final String str2, final String str3, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda16
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str4, String str5) {
                    this.f$0.lambda$getResetFunction$59(str, str2, str3, i2, str4, str5);
                }
            });
            return;
        }
        this.state = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.state);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        if (str3 != null && !str3.equals("")) {
            this.binding.statePersonalSpinner.setSelection(this.stateadapter.getPosition(str3));
        } else {
            this.binding.statePersonalSpinner.setSelection(0);
        }
        this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda17
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$getResetFunction$60(str2, i2, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda18
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$getResetFunction$61(str, i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getResetFunction$59(String str, String str2, String str3, int i, String str4, String str5) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str4 + " " + str5);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda23
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getResetFunction$58(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str4;
        this.refreshToken = str5;
        SharedPref.getInstance(requireContext()).setRefreshToken(str5);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str4);
        getResetFunction(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getResetFunction$58(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getResetFunction$60(String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        this.relation = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        if (str != null && !str.equals("")) {
            this.binding.relationSpinner.setSelection(this.relationadapter.getPosition(str));
        } else {
            this.binding.relationSpinner.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getResetFunction$61(String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        if (!str.equals("")) {
            this.binding.genderPersonalSpinner.setSelection(this.genderadapter.getPosition(str));
        } else {
            this.binding.genderPersonalSpinner.setSelection(0);
        }
    }

    private void getRelationData() {
        this.relation = new ArrayList<>();
        this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda9
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getRelationData$67(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelationData$67(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda13
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$getRelationData$64(i2, str, str2);
                }
            });
            return;
        }
        this.relation = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        String str = this.relation1;
        if (str != null && !str.equals("")) {
            this.binding.relationSpinner.setSelection(this.relationadapter.getPosition(this.relation1));
        } else {
            this.binding.relationSpinner.setSelection(0);
        }
        this.state = new ArrayList<>();
        this.statecode1 = new ArrayList<>();
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda14
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$getRelationData$65(i2, arrayList3, arrayList4);
            }
        });
        this.gender = new ArrayList<>();
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda15
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$getRelationData$66(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelationData$64(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda73
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getRelationData$63(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        getRelationData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelationData$63(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelationData$65(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.state = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.state);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        String str = this.statepd;
        if (str != null && !str.equals("")) {
            int position = this.stateadapter.getPosition(this.statepd);
            if (position != -1) {
                this.binding.statePersonalSpinner.setSelection(position);
                return;
            } else {
                this.binding.statePersonalSpinner.setSelection(0);
                return;
            }
        }
        this.binding.statePersonalSpinner.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelationData$66(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        if (!this.genderTv1.equals("")) {
            this.binding.genderPersonalSpinner.setSelection(this.genderadapter.getPosition(this.genderTv1));
        } else {
            this.binding.genderPersonalSpinner.setSelection(0);
        }
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda82
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$68(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$68(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().cameraOnly().compress(512).start(101);
        } else if (charSequenceArr[i].equals(this.choosegallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void selectImage1() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda74
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage1$69(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage1$69(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(102);
        } else if (charSequenceArr[i].equals(this.choosegallery)) {
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(102);
        } else if (charSequenceArr[i].equals(this.choosepdf)) {
            openfile1();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r31v0, types: [in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment, in.gov.eci.bloapp.views.fragments.checklist.Hilt_ApplicantDetailsFragment] */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        ?? r28;
        ?? r14;
        Uri data;
        super.onActivityResult(i, i2, intent);
        String str2 = "MB";
        ?? r15 = "Image size exceeded 2MB limit.";
        String str3 = "image";
        if (i != 101 || i2 != -1 || (data = intent.getData()) == null) {
            str3 = str3;
            str = "/";
            str2 = "MB";
            r28 = "Image size exceeded 2MB limit.";
            str2 = "";
            r14 = -1;
        } else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), str3);
                str2 = null;
                Cursor cursorQuery = getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.imagemsg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    try {
                        if (this.filesize < 1024) {
                            this.binding.chooseCorrectPhotoFileDeletion.setVisibility(0);
                            this.binding.choosePhotoSize.setVisibility(0);
                            this.binding.chooseCorrectPhotoName.setVisibility(0);
                            this.binding.chooseCorrectPhoto.setTextColor(Color.parseColor(this.color));
                            this.binding.chooseCorrectPhotoName.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.choosePhotoSize.setText(this.filesize + "KB");
                            this.binding.previewPhoto.setVisibility(0);
                            ImageView imageView = this.binding.previewPhoto;
                            byte[] bArr = this.byteArray;
                            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                        } else if (this.filesize > 2048) {
                            this.binding.previewPhoto.setVisibility(8);
                            this.binding.chooseCorrectPhotoFileDeletion.setVisibility(8);
                            this.binding.choosePhotoSize.setVisibility(8);
                            this.binding.chooseCorrectPhotoName.setVisibility(8);
                            showdialog(this.alert, "Image size exceeded 2MB limit.");
                        } else {
                            this.filesize /= 1024;
                            double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                            this.binding.chooseCorrectPhotoFileDeletion.setVisibility(0);
                            this.binding.choosePhotoSize.setVisibility(0);
                            this.binding.chooseCorrectPhotoName.setVisibility(0);
                            this.binding.chooseCorrectPhoto.setTextColor(Color.parseColor(this.color));
                            this.binding.chooseCorrectPhotoName.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.choosePhotoSize.setText(dRound + "MB");
                            this.binding.previewPhoto.setVisibility(0);
                            ImageView imageView2 = this.binding.previewPhoto;
                            byte[] bArr2 = this.byteArray;
                            imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                        }
                        cursorQuery.close();
                        str2 = "MB";
                        str2 = "";
                        r28 = "Image size exceeded 2MB limit.";
                        r14 = -1;
                        str3 = str3;
                        str = "/";
                        faceRecognition(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo);
                    } catch (Exception e2) {
                        e = e2;
                        str = "/";
                        r15 = -1;
                        str2 = "";
                        Logger.d(str2, e.getMessage());
                        r14 = r15;
                        r28 = r15;
                    }
                } catch (Exception e3) {
                    e = e3;
                    Logger.d(str2, e.getMessage());
                    r14 = r15;
                    r28 = r15;
                }
            } catch (Exception e4) {
                e = e4;
                str = "/";
            }
            r15 = -1;
            str2 = "";
            Logger.d(str2, e.getMessage());
            r14 = r15;
            r28 = r15;
        }
        if (i == 102 && i2 == r14) {
            Logger.d("Camera ", "inside camera");
            Uri data2 = intent.getData();
            if (data2 != null) {
                try {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data2);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
                } catch (IOException e5) {
                    Logger.d(str2, e5.getMessage());
                }
                try {
                    Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), str3);
                    Cursor cursorQuery2 = getContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imagemsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split(str);
                    if (this.filesize < 1024) {
                        this.binding.chooseFileDeletion2.setVisibility(0);
                        this.binding.chooseFileName2.setVisibility(0);
                        this.binding.chooseFileName2Size.setVisibility(0);
                        this.binding.preview2.setVisibility(0);
                        ImageView imageView3 = this.binding.preview2;
                        byte[] bArr3 = this.pdfbyteArray;
                        imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                        this.binding.chooseFileName2.setTextColor(Color.parseColor(this.color));
                        this.binding.chooseFileName2.setText(strArrSplit2[strArrSplit2.length - 1]);
                        this.binding.chooseFileName2Size.setText(this.filesize + "KB");
                    } else if (this.filesize > 2048) {
                        this.binding.chooseFileDeletion2.setVisibility(8);
                        this.binding.chooseFileName2.setVisibility(8);
                        this.binding.chooseFileName2Size.setVisibility(8);
                        this.binding.preview2.setVisibility(8);
                        showdialog(this.alert, r28);
                    } else {
                        this.filesize /= 1024;
                        double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                        this.binding.chooseFileDeletion2.setVisibility(0);
                        this.binding.chooseFileName2.setVisibility(0);
                        this.binding.chooseFileName2Size.setVisibility(0);
                        this.binding.preview2.setVisibility(0);
                        ImageView imageView4 = this.binding.preview2;
                        byte[] bArr4 = this.pdfbyteArray;
                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                        this.binding.chooseFile2.setTextColor(Color.parseColor(this.color));
                        this.binding.chooseFileName2.setText(strArrSplit2[strArrSplit2.length - 1]);
                        this.binding.chooseFileName2Size.setText(dRound2 + str2);
                    }
                    this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda72
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i3, String str4) {
                            this.f$0.lambda$onActivityResult$73(i3, str4);
                        }
                    });
                } catch (Exception e6) {
                    Logger.d(str2, e6.getMessage());
                }
            }
            this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$73(int i, final String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda87
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$72(str, i2, str2, str3);
                }
            });
        } else {
            Logger.d(this.passport, str);
            this.passportdocuments = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$72(final String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda22
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$70(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda33
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str4) {
                this.f$0.lambda$onActivityResult$71(str, i2, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$70(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$71(String str, int i, String str2) {
        Logger.d(this.passport, str);
        this.passportdocuments = str;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30, reason: invalid class name */
    class AnonymousClass30 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass30() {
        }

        /* JADX WARN: Code duplicated, block: B:32:0x008e A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00ac A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x0134 A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x014c A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0184 A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0252 A[Catch: Exception -> 0x025f, TryCatch #1 {Exception -> 0x025f, blocks: (B:30:0x0063, B:32:0x008e, B:34:0x00ac, B:39:0x01fc, B:35:0x0134, B:37:0x014c, B:38:0x0184, B:40:0x0252, B:41:0x025e), top: B:47:0x0063 }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Uri saveImagePath;
            Cursor cursorQuery;
            String[] strArrSplit;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            Uri data = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                try {
                    InputStream inputStreamOpenInputStream = ApplicantDetailsFragment.this.getContext().getContentResolver().openInputStream(data);
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
                        Logger.d("", e.getMessage());
                        byteArrayOutputStream = byteArrayOutputStream2;
                        ApplicantDetailsFragment.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                        saveImagePath = ApplicantDetailsFragment.this.getSaveImagePath(Base64.encodeToString(ApplicantDetailsFragment.this.pdfbyteArray, 0), ".pdf");
                        cursorQuery = ApplicantDetailsFragment.this.getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ApplicantDetailsFragment.this.imagemsg);
                        }
                        cursorQuery.moveToFirst();
                        strArrSplit = saveImagePath.getPath().split("/");
                        if (ApplicantDetailsFragment.this.filesize < 1024) {
                            double dRound2 = Math.round(ApplicantDetailsFragment.this.filesize * 100.0d) / 100.0d;
                            ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(0);
                            ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(0);
                            ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(0);
                            ApplicantDetailsFragment.this.binding.preview2.setVisibility(0);
                            ApplicantDetailsFragment.this.binding.preview2.setImageResource(R.drawable.blo_pfd_thumbnail);
                            ApplicantDetailsFragment.this.binding.chooseFile2.setTextColor(Color.parseColor(ApplicantDetailsFragment.this.color));
                            ApplicantDetailsFragment.this.binding.chooseFileName2.setText(strArrSplit[strArrSplit.length - 1]);
                            ApplicantDetailsFragment.this.binding.chooseFileName2Size.setText(dRound2 + "KB");
                        } else {
                            dRound = Math.round(((double) (ApplicantDetailsFragment.this.filesize / 1024000.0f)) * 100.0d) / 100.0d;
                            if (dRound > 2.0d) {
                                ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(8);
                                ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(8);
                                ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(8);
                                ApplicantDetailsFragment.this.binding.preview2.setVisibility(8);
                                ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
                                applicantDetailsFragment.showdialog(applicantDetailsFragment.alert, "PDF size exceeded 3MB limit.");
                            } else {
                                ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(0);
                                ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(0);
                                ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(0);
                                ApplicantDetailsFragment.this.binding.preview2.setVisibility(0);
                                ApplicantDetailsFragment.this.binding.preview2.setImageResource(R.drawable.blo_pfd_thumbnail);
                                ApplicantDetailsFragment.this.binding.chooseFile2.setTextColor(Color.parseColor(ApplicantDetailsFragment.this.color));
                                ApplicantDetailsFragment.this.binding.chooseFileName2.setText(strArrSplit[strArrSplit.length - 1]);
                                ApplicantDetailsFragment.this.binding.chooseFileName2Size.setText(dRound + "MB");
                            }
                        }
                        ApplicantDetailsFragment.this.commonUtilClass.uploadToServer2(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.stateCode, ApplicantDetailsFragment.this.asmblyNO, ApplicantDetailsFragment.this.partNo, ApplicantDetailsFragment.this.filepathimg, ApplicantDetailsFragment.this.saveImageFileName, ApplicantDetailsFragment.this.token, ApplicantDetailsFragment.this.referenceNo, SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30$$ExternalSyntheticLambda3
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i2, String str) {
                                this.f$0.lambda$onActivityResult$3(i2, str);
                            }
                        });
                        cursorQuery.close();
                        return;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                saveImagePath = ApplicantDetailsFragment.this.getSaveImagePath(Base64.encodeToString(ApplicantDetailsFragment.this.pdfbyteArray, 0), ".pdf");
                cursorQuery = ApplicantDetailsFragment.this.getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(ApplicantDetailsFragment.this.imagemsg);
                }
                cursorQuery.moveToFirst();
                strArrSplit = saveImagePath.getPath().split("/");
                if (ApplicantDetailsFragment.this.filesize < 1024) {
                    double dRound3 = Math.round(ApplicantDetailsFragment.this.filesize * 100.0d) / 100.0d;
                    ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(0);
                    ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(0);
                    ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(0);
                    ApplicantDetailsFragment.this.binding.preview2.setVisibility(0);
                    ApplicantDetailsFragment.this.binding.preview2.setImageResource(R.drawable.blo_pfd_thumbnail);
                    ApplicantDetailsFragment.this.binding.chooseFile2.setTextColor(Color.parseColor(ApplicantDetailsFragment.this.color));
                    ApplicantDetailsFragment.this.binding.chooseFileName2.setText(strArrSplit[strArrSplit.length - 1]);
                    ApplicantDetailsFragment.this.binding.chooseFileName2Size.setText(dRound3 + "KB");
                } else {
                    dRound = Math.round(((double) (ApplicantDetailsFragment.this.filesize / 1024000.0f)) * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(8);
                        ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(8);
                        ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(8);
                        ApplicantDetailsFragment.this.binding.preview2.setVisibility(8);
                        ApplicantDetailsFragment applicantDetailsFragment2 = ApplicantDetailsFragment.this;
                        applicantDetailsFragment2.showdialog(applicantDetailsFragment2.alert, "PDF size exceeded 3MB limit.");
                    } else {
                        ApplicantDetailsFragment.this.binding.chooseFileDeletion2.setVisibility(0);
                        ApplicantDetailsFragment.this.binding.chooseFileName2.setVisibility(0);
                        ApplicantDetailsFragment.this.binding.chooseFileName2Size.setVisibility(0);
                        ApplicantDetailsFragment.this.binding.preview2.setVisibility(0);
                        ApplicantDetailsFragment.this.binding.preview2.setImageResource(R.drawable.blo_pfd_thumbnail);
                        ApplicantDetailsFragment.this.binding.chooseFile2.setTextColor(Color.parseColor(ApplicantDetailsFragment.this.color));
                        ApplicantDetailsFragment.this.binding.chooseFileName2.setText(strArrSplit[strArrSplit.length - 1]);
                        ApplicantDetailsFragment.this.binding.chooseFileName2Size.setText(dRound + "MB");
                    }
                }
                ApplicantDetailsFragment.this.commonUtilClass.uploadToServer2(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.stateCode, ApplicantDetailsFragment.this.asmblyNO, ApplicantDetailsFragment.this.partNo, ApplicantDetailsFragment.this.filepathimg, ApplicantDetailsFragment.this.saveImageFileName, ApplicantDetailsFragment.this.token, ApplicantDetailsFragment.this.referenceNo, SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i2, String str) {
                        this.f$0.lambda$onActivityResult$3(i2, str);
                    }
                });
                cursorQuery.close();
                return;
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
                return;
            }
            ApplicantDetailsFragment.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$3(int i, final String str) {
            if (i == 401) {
                ApplicantDetailsFragment.this.commonUtilClass.getRefreshToken(ApplicantDetailsFragment.this.requireContext(), ApplicantDetailsFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$2(str, i2, str2, str3);
                    }
                });
            } else {
                ApplicantDetailsFragment.this.passportdocuments = str;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(final String str, int i, String str2, String str3) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str2;
            ApplicantDetailsFragment.this.refreshToken = str3;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str2);
            ApplicantDetailsFragment.this.commonUtilClass.uploadToServer2(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.stateCode, ApplicantDetailsFragment.this.asmblyNO, ApplicantDetailsFragment.this.partNo, ApplicantDetailsFragment.this.filepathimg, ApplicantDetailsFragment.this.saveImageFileName, ApplicantDetailsFragment.this.token, ApplicantDetailsFragment.this.referenceNo, SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$30$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str4) {
                    this.f$0.lambda$onActivityResult$1(str, i2, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1(String str, int i, String str2) {
            ApplicantDetailsFragment.this.passportdocuments = str;
        }
    }

    private void showPersonPdfDialog(final String fileref) {
        this.alertDialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonPdfDialog$74(fileref);
            }
        }, 2000L);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonPdfDialog$75();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonPdfDialog$74(String str) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectstorage, str, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.bloapp, "ANDROIDMOB").enqueue(new AnonymousClass31(dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView), imageView, dialog));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<JsonObject> {
        final /* synthetic */ ImageView val$dialogcancelbtn;
        final /* synthetic */ PDFView val$pdfView;
        final /* synthetic */ Dialog val$pdfdialog;

        AnonymousClass31(final PDFView val$pdfView, final ImageView val$dialogcancelbtn, final Dialog val$pdfdialog) {
            this.val$pdfView = val$pdfView;
            this.val$dialogcancelbtn = val$dialogcancelbtn;
            this.val$pdfdialog = val$pdfdialog;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ApplicantDetailsFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                ApplicantDetailsFragment.this.encodedPersonImage = String.valueOf(((JsonObject) response.body()).get("file"));
                this.val$pdfView.fromBytes(Base64.decode(ApplicantDetailsFragment.this.encodedPersonImage, 0)).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
                ImageView imageView = this.val$dialogcancelbtn;
                final Dialog dialog = this.val$pdfdialog;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$31$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                this.val$pdfdialog.show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$31$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                return;
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonPdfDialog$75() {
        this.alertDialog.dismiss();
    }

    private void showImageDialog() {
        this.alertDialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda83
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showImageDialog$77();
            }
        }, 2000L);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda84
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showImageDialog$78();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showImageDialog$77() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.blo_person_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.person_image);
        if (this.photo.equals(" ")) {
            showdialog(this.alert, "Image not available.");
        } else {
            touchImageView.setImageBitmap(this.bitmapPersonImage);
        }
        ((ImageView) dialog.findViewById(R.id.person_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda86
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showImageDialog$78() {
        this.alertDialog.dismiss();
    }

    private void showPassportImageDialog() {
        this.alertDialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPassportImageDialog$80();
            }
        }, 2000L);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPassportImageDialog$81();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassportImageDialog$80() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.blo_age_image_dialog_layout);
        dialog.show();
        ((TouchImageView) dialog.findViewById(R.id.age_image)).setImageBitmap(this.bitmapPassportImage);
        ((ImageView) dialog.findViewById(R.id.age_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassportImageDialog$81() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda85
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$83(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$83(DialogInterface dialogInterface, int i) {
        openFragment(new CheckListMain(), "Totalist");
    }

    private void showpdfDialog(String pdfname, String name) {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.blo_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.pdf_card).findViewById(R.id.dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.pdf_card).findViewById(R.id.pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_pdf_name);
        pDFViewFindViewById.fromAsset(pdfname).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(1).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda76
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private boolean isApplicantValidated() {
        if (this.binding.placeOfBirthRG.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please select Place of birth details");
            return false;
        }
        if (this.binding.indiaRb.isChecked() && this.binding.statePd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter Place of birth state details");
            return false;
        }
        if (this.binding.outsideRb.isChecked() && this.binding.countryName.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter Place of birth country details");
            return false;
        }
        if (this.binding.houseNoRg.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please verify Applicant details");
            return false;
        }
        if (this.binding.addressRg.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please verify address in india");
            return false;
        }
        if (this.binding.informationRg.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please verify if all details matched");
            return false;
        }
        if (this.binding.applicantFoundRg.getCheckedRadioButtonId() != -1) {
            return true;
        }
        showdialog(this.alert, "Please verify if applicant was present");
        return false;
    }

    private boolean isShftingDataOk() {
        Date date;
        Date date2;
        this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.lastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.relativeNameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.relativeLastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        Date date3 = null;
        try {
            date = simpleDateFormat.parse(this.binding.dobEd.getText().toString());
            try {
                String str = this.dobQualifyingDate;
                if (str != "") {
                    date2 = simpleDateFormat.parse(str);
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
        if (this.binding.nameEd.getText().toString().isEmpty()) {
            this.binding.nameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.nameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.lastnameEd.getText().toString().isEmpty()) {
            this.binding.lastnameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.lastnameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.relativeNameEd.getText().toString().isEmpty()) {
            this.binding.relativeNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.relativeNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.relativeLastnameEd.getText().toString().isEmpty()) {
            this.binding.relativeLastnameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.relativeLastnameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            this.binding.dobEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.dobEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.villagePersonalSpinner.getText().toString().isEmpty()) {
            this.binding.villagePersonalSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.villagePersonalSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.emailEd.getText().toString().isEmpty()) {
            this.binding.emailEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.emailEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.mobileNumEd.getText().toString().isEmpty()) {
            this.binding.mobileNumEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.mobileNumEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.nameEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter name of applicant");
            return false;
        }
        if (this.binding.nameEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter first name in official language");
            return false;
        }
        if (!this.binding.nameEd2.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.nameEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "First Name(" + this.binding.nameEd2.getText().toString() + ") should be in regional language.");
            this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!this.binding.lastnameEd.getText().toString().isEmpty() && this.binding.lastnameEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter last name in official language");
            return false;
        }
        if (!this.binding.lastnameEd2.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.lastnameEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Last Name(" + this.binding.lastnameEd2.getText().toString() + ") should be in regional language.");
            this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.lastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.relativeNameEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in english");
            return false;
        }
        if (this.binding.relativeNameEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in official language");
            return false;
        }
        if (!this.binding.relativeNameEd2.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.relativeNameEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Relative first name(" + this.binding.relativeNameEd2.getText().toString() + ") should be in regional language.");
            this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.lastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!this.binding.relativeLastnameEd.getText().toString().isEmpty() && this.binding.relativeLastnameEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative last name in official language");
            return false;
        }
        if (!this.binding.relativeLastnameEd2.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.relativeLastnameEd2.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Relative last name(" + this.binding.relativeLastnameEd2.getText().toString() + ") should be in regional language.");
            this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.lastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeLastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.relationSpinner.getSelectedItem().toString().equals("")) {
            showdialog(this.alert, "Please select relation");
            this.binding.nameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.lastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeLastnameEd2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            return false;
        }
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please Enter date of birth");
            return false;
        }
        if (date.after(date3)) {
            showdialog(this.alert, "Date of birth should be less than " + this.dobQualifyingDate);
            return false;
        }
        int iCalculateAge = calculateAge(this.binding.dobEd.getText().toString(), this.dateFormat);
        if (iCalculateAge < 17) {
            showdialog(this.alert, "Age should be greater than or equal to 17 years");
            return false;
        }
        if (this.binding.placeOfBirthRGEd.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please select place of birth");
            return false;
        }
        if (this.binding.indiaRbEd.isChecked() && this.binding.statePersonalSpinner.getSelectedItem() != null && this.binding.statePersonalSpinner.getSelectedItem().toString().equalsIgnoreCase("Select State")) {
            showdialog(this.alert, "Please select state");
            return false;
        }
        if (this.binding.outsideRbEd.isChecked() && this.binding.outsideIndiaSpinner.getSelectedItem() != null && this.binding.outsideIndiaSpinner.getSelectedItem().toString().equalsIgnoreCase("Select Country")) {
            showdialog(this.alert, "Please select country");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("")) {
            showdialog(this.alert, "Please select gender");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("MALE") && this.binding.relationSpinner.getSelectedItem().toString().equals(this.hsbn)) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is male then relation type should not be husband. Please select correct relation type.");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("FEMALE") && this.binding.relationSpinner.getSelectedItem().toString().equals("WIFE")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is female then relation type should not be wife. Please select correct relation type.");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("THIRD GENDER") && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.father) && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.mother)) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is third gender then relation type should be Father or Mother. Please select correct relation type.");
            return false;
        }
        if (!this.binding.emailEd.getText().toString().matches(RegexMatcher.EMAIL_REGEX) && !this.binding.emailEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter correct Email ID");
            return false;
        }
        if (this.binding.mobileNumEd.getText().toString().length() != 10 && !this.binding.mobileNumEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter correct Mobile number");
            return false;
        }
        if (!this.binding.mobileNumEd.getText().toString().isEmpty() && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
            showdialog("", "Please Enter Correct Mobile Number");
            return false;
        }
        if (this.binding.chooseCorrectPhotoName.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select photo");
            return false;
        }
        if (iCalculateAge == 17) {
            showdialog(this.alert, "Your form will be submitted but it will enroll after 18 years");
        }
        return true;
    }

    public int calculateAge(String birthDate, String format) {
        int i = 0;
        try {
            Date date = new SimpleDateFormat(format).parse(birthDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            int i2 = calendar2.get(1) - calendar.get(1);
            if (calendar2.get(2) >= calendar.get(2) && (calendar2.get(2) != calendar.get(2) || calendar2.get(5) >= calendar.get(5))) {
                return i2;
            }
            i = i2 - 1;
            return i;
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
            return i;
        }
    }

    private boolean indiaaddress() {
        this.binding.houseNoEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.streetEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.villageEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.postOfficehin.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        if (this.binding.houseNoEd.getText().toString().isEmpty()) {
            this.binding.houseNoEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.houseNoEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.streetEd.getText().toString().isEmpty()) {
            this.binding.streetEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.streetEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.villageEd.getText().toString().isEmpty()) {
            this.binding.villageEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.villageEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.districtSpinner1.getText().toString().isEmpty()) {
            this.binding.districtSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.districtSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.pincodeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.pincodeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.houseNoEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter house no .");
            return false;
        }
        if (this.binding.houseNoEdhindi.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter house no in regional language.");
            return false;
        }
        if (this.binding.streetEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter street/area/locality");
            return false;
        }
        if (this.binding.streetEdhindi.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter street/area/locality in regional language.");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.streetEdhindi.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Street(" + this.binding.streetEdhindi.getText().toString() + ") should be in regional language.");
            this.binding.houseNoEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.villageEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter village/town ");
            return false;
        }
        if (this.binding.villageEdhindi.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter village/town in regional language.");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.villageEdhindi.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Village(" + this.binding.villageEdhindi.getText().toString() + ") should be in regional language.");
            this.binding.houseNoEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.postofficeEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter postoffice ");
            return false;
        }
        if (this.binding.postOfficehin.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter postoffice in regional language.");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.postOfficehin.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "PostOffice(" + this.binding.postOfficehin.getText().toString() + ") should be in regional language.");
            this.binding.houseNoEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postOfficehin.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.districtSpinner1.getText().toString().equals("")) {
            showdialog(this.alert, "Please select district");
            this.binding.houseNoEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageEdhindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postOfficehin.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            return false;
        }
        if (this.binding.pincodeEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter Pin Code");
            return false;
        }
        if (this.binding.pincodeEd.getText().toString().length() != 6 || this.binding.pincodeEd.getText().toString().matches("^[1-9]{1}[0-9]{5}$")) {
            return true;
        }
        showdialog(this.alert, "Please enter correct pincode");
        return false;
    }

    private boolean passportdetails() {
        if (this.binding.passportEd.getText().toString().isEmpty()) {
            this.binding.passportEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.passportEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty()) {
            this.binding.issueDateEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.issueDateEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.expiryDateEd.getText().toString().isEmpty()) {
            this.binding.expiryDateEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.expiryDateEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.placeIssueEd.getText().toString().isEmpty()) {
            this.binding.placeIssueEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.placeIssueEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.passportEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter passport number");
            return false;
        }
        if (!this.binding.passportEd.getText().toString().matches(RegexMatcher.PASSPORT_REGEX)) {
            showdialog(this.alert, "Please enter correct passport number");
            return false;
        }
        if (this.binding.chooseFileName2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please upload document");
            return false;
        }
        if (!this.binding.expiryDateEd.getText().toString().equals(this.binding.issueDateEd.getText().toString())) {
            return true;
        }
        showdialog(this.alert, "Please Enter correct expiry date");
        return false;
    }

    private boolean visadetails() {
        if (this.binding.visaNoEd.getText().toString().isEmpty()) {
            this.binding.visaNoEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.visaNoEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.issueDateEdVisa.getText().toString().isEmpty()) {
            this.binding.issueDateEdVisa.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.issueDateEdVisa.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.expiryDateEdVisa.getText().toString().isEmpty()) {
            this.binding.expiryDateEdVisa.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.expiryDateEdVisa.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.visaTypeEd.getText().toString().isEmpty()) {
            this.binding.visaTypeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.visaTypeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.authorityEd.getText().toString().isEmpty()) {
            this.binding.authorityEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.authorityEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.visaNoEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter visa no .");
            return false;
        }
        if (this.binding.issueDateEdVisa.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter issue date");
            return false;
        }
        if (this.binding.expiryDateEdVisa.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter expiry date");
            return false;
        }
        if (this.binding.expiryDateEdVisa.getText().toString().isEmpty()) {
            return true;
        }
        try {
            Date date = new SimpleDateFormat(this.dateFormat).parse(this.binding.issueDateEdVisa.getText().toString());
            if (((int) TimeUnit.MILLISECONDS.toDays(new SimpleDateFormat(this.dateFormat).parse(this.binding.expiryDateEdVisa.getText().toString()).getTime() - date.getTime())) >= 90) {
                return true;
            }
            showdialog(this.alert, "Please select correct expiry visa date");
            return false;
        } catch (NullPointerException | ParseException e) {
            Logger.d("", e.getMessage());
            return true;
        }
    }

    private boolean ordinaryresidence() {
        if (this.binding.dateEd.getText().toString().equals("")) {
            showdialog(this.alert, "Please select date.");
            return false;
        }
        if (!this.binding.other.isChecked() || !this.binding.descEd.getText().toString().isEmpty()) {
            return true;
        }
        showdialog(this.alert, "Please enter description");
        return false;
    }

    private boolean outsideindia() {
        if (this.binding.houseNoEd2.getText().toString().isEmpty()) {
            this.binding.houseNoEd2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.houseNoEd2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.streetEd2.getText().toString().isEmpty()) {
            this.binding.streetEd2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.streetEd2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.villageSpinner2.getText().toString().isEmpty()) {
            this.binding.villageSpinner2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.villageSpinner2.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.stateOutsideSpinner.getText().toString().isEmpty()) {
            this.binding.stateOutsideSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.stateOutsideSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.countrySpinner.getSelectedItem().toString().isEmpty()) {
            this.binding.countrySpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.countrySpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.zipEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.zipEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.houseNoEd2.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter house no .");
            return false;
        }
        if (this.binding.streetEd2.getText().toString().equals("")) {
            showdialog(this.alert, "Please Enter street/area/locality");
            return false;
        }
        if (this.binding.villageSpinner2.getText().toString().equals("")) {
            showdialog(this.alert, "Please enter village/town ");
            return false;
        }
        if (this.binding.stateOutsideSpinner.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter state");
            return false;
        }
        if (this.binding.countrySpinner.getSelectedItem().toString().equals("")) {
            showdialog(this.alert, "Please select country");
            return false;
        }
        if (!this.binding.zipEd.getText().toString().equals("")) {
            return true;
        }
        showdialog(this.alert, "Please enter zip code");
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$32] */
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
                    Logger.d("", e.getMessage());
                }
            } catch (IOException e2) {
                Logger.d("", e2.getMessage());
                inputStreamOpenRawResource.close();
                stringWriter.flush();
                stringWriter.close();
            }
            List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment.32
            }.getType());
            DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().insertStates((TState[]) list.toArray(new TState[list.size()]));
        } catch (Throwable th3) {
            try {
                inputStreamOpenRawResource.close();
                stringWriter.flush();
                stringWriter.close();
            } catch (IOException e3) {
                Logger.d("", e3.getMessage());
            }
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int id2 = parent.getId();
        if (id2 == 2131362969) {
            this.state = new ArrayList<>();
            this.statecode1 = new ArrayList<>();
        } else {
            if (id2 != 2131365832) {
                return;
            }
            this.district = new ArrayList<>();
            this.districtcode1 = new ArrayList<>();
            this.commonUtilClass.getDistrict(this.statecode1.get(this.binding.statePersonalSpinner.getSelectedItemPosition()), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda26
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$onItemSelected$88(i, arrayList, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$88(int i, final ArrayList arrayList, final ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda81
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onItemSelected$87(arrayList, arrayList2, i2, str, str2);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        if (this.binding.districtPd.getText().toString() != null && !this.binding.districtPd.getText().toString().equals("")) {
            this.binding.districtPersonalSpinner.setSelection(this.districtadapter.getPosition(this.binding.districtPd.getText().toString()));
        } else {
            this.binding.districtPersonalSpinner.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$87(final ArrayList arrayList, final ArrayList arrayList2, int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda79
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onItemSelected$85(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getDistrict(this.statecode1.get(this.binding.statePersonalSpinner.getSelectedItemPosition()), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda80
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$onItemSelected$86(arrayList, arrayList2, i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$85(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$86(ArrayList arrayList, ArrayList arrayList2, int i, ArrayList arrayList3, ArrayList arrayList4) {
        this.district = arrayList;
        this.districtcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        if (this.binding.districtPd.getText().toString() != null && !this.binding.districtPd.getText().toString().equals("")) {
            this.binding.districtPersonalSpinner.setSelection(this.districtadapter.getPosition(this.binding.districtPd.getText().toString()));
        } else {
            this.binding.districtPersonalSpinner.setSelection(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        Logger.d("", "");
    }

    public void updateIssueDate() {
        this.binding.dateEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.myCalendaror.getTime()));
    }

    public void updateIssueDatedob() {
        this.binding.dobEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.myCalendar.getTime()));
    }

    public void updateIssueDatepassport() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat, Locale.US);
        this.binding.issueDateEd.setText(simpleDateFormat.format(this.myCalendarpassport.getTime()));
        this.myCalendarpassport.add(1, 10);
        this.myCalendarpassport.add(5, -1);
        this.binding.expiryDateEd.setText(simpleDateFormat.format(this.myCalendarpassport.getTime()));
    }

    public void updateIssueDatevisa() {
        this.binding.issueDateEdVisa.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.myCalendarvisa.getTime()));
    }

    public void updateexpiryDatevisa() {
        this.binding.expiryDateEdVisa.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.myCalendarvisa1.getTime()));
    }

    public void createcsv() {
        String str;
        String str2;
        Exception exc;
        boolean z;
        boolean z2;
        boolean z3;
        this.alertDialog.show();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.dateFormat2);
        String string = this.binding.genderTv1.getText().toString();
        if (this.binding.reasonAbsent.getText().toString().equals(this.education)) {
            str = "EDU";
        } else if (this.binding.reasonAbsent.getText().toString().equals(this.employment)) {
            str = "EMPL";
        } else {
            str = this.binding.reasonAbsent.getText().toString().equals(this.other) ? "OTHR" : null;
        }
        if (string.equals("MALE")) {
            string = "M";
        } else if (string.equals("FEMALE")) {
            string = "F";
        } else if (string.equals("THIRD GENDER")) {
            string = "T";
        }
        String string2 = this.binding.relationtype.getText().toString();
        String str3 = str;
        if (string2.equals(this.father)) {
            string2 = "FTHR";
        } else if (string2.equals(this.mother)) {
            string2 = "MTHR";
        } else if (string2.equals(this.hsbn)) {
            string2 = "HSBN";
        } else if (string2.equals("WIFE")) {
            string2 = "WIFE";
        } else if (string2.equals("OTHER")) {
            string2 = "OTHR";
        }
        String str4 = new SimpleDateFormat(this.dateFormat2).format(new Date());
        HashMap map = new HashMap();
        try {
            map.put("residingInIndia", "N");
            map.put("stateCd", this.stateCode);
            map.put("districtCd", this.districtCode);
            map.put("asmblyConstituencyNo", this.asmblyNO);
            int iLastIndexOf = this.binding.applicantNameTv1.getText().toString().lastIndexOf(32);
            String str5 = string;
            map.put(Constants.FIRST_NAME, this.binding.applicantNameTv1.getText().toString().substring(0, iLastIndexOf).trim().replaceAll(" +", " "));
            int i = iLastIndexOf + 1;
            if (this.binding.applicantNameTv1.getText().toString().substring(i).isEmpty()) {
                map.put(this.lastNameText, null);
            } else {
                try {
                    map.put(this.lastNameText, this.binding.applicantNameTv1.getText().toString().substring(i).trim().replaceAll(" +", " "));
                } catch (Exception e) {
                    exc = e;
                    str2 = "";
                }
            }
            int iLastIndexOf2 = this.binding.relativeTv1.getText().toString().lastIndexOf(32);
            map.put("applicantRelativeName", this.binding.relativeTv1.getText().toString().substring(0, iLastIndexOf2).trim().replaceAll(" +", " "));
            int i2 = iLastIndexOf2 + 1;
            if (this.binding.relativeTv1.getText().toString().substring(i2).isEmpty()) {
                map.put("applicantRelativeSurname", null);
            } else {
                map.put("applicantRelativeSurname", this.binding.relativeTv1.getText().toString().substring(i2).trim().replaceAll(" +", " "));
            }
            map.put("typeOfRelation", string2);
            int iLastIndexOf3 = this.binding.applicantHindiTv1.getText().toString().lastIndexOf(32);
            if (!this.partLang.equals(this.english_code) && this.binding.applicantHindiTv1.getText().toString().substring(0, iLastIndexOf3).matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(this.alert, "First name(" + this.binding.applicantHindiTv1.getText().toString().substring(0, iLastIndexOf3) + ") should be in regional language");
                this.binding.applicantHindiTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                this.alertDialog.dismiss();
                return;
            }
            map.put("firstNameL1", this.binding.applicantHindiTv1.getText().toString().substring(0, iLastIndexOf3).trim().replaceAll(" +", " "));
            map.put("firstNameL2", null);
            int i3 = iLastIndexOf3 + 1;
            if (this.binding.applicantHindiTv1.getText().toString().substring(i3).isEmpty()) {
                z = false;
                map.put(this.lastNameL1, null);
            } else {
                if (!this.partLang.equals(this.english_code) && this.binding.applicantHindiTv1.getText().toString().substring(i3).matches(RegexMatcher.NAME_REGEX_CHECK)) {
                    showdialog(this.alert, "Last name(" + this.binding.applicantHindiTv1.getText().toString().substring(i3) + ") should be in regional language");
                    this.binding.applicantHindiTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                    this.alertDialog.dismiss();
                    return;
                }
                map.put(this.lastNameL1, this.binding.applicantHindiTv1.getText().toString().substring(i3).trim().replaceAll(" +", " "));
                z = false;
            }
            map.put("lastNameL2", z);
            int iLastIndexOf4 = this.binding.relativenameTv1.getText().toString().lastIndexOf(32);
            if (!this.partLang.equals(this.english_code) && this.binding.relativenameTv1.getText().toString().substring(0, iLastIndexOf4).matches(RegexMatcher.NAME_REGEX_CHECK)) {
                showdialog(this.alert, "Relative first name(" + this.binding.relativenameTv1.getText().toString().substring(0, iLastIndexOf4) + ") should be in regional language");
                this.binding.relativenameTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                this.alertDialog.dismiss();
                return;
            }
            map.put("applicantRelativeNameL1", this.binding.relativenameTv1.getText().toString().substring(0, iLastIndexOf4).trim().replaceAll(" +", " "));
            map.put("applicantRelativeNameL2", null);
            int i4 = iLastIndexOf4 + 1;
            if (this.binding.relativenameTv1.getText().toString().substring(i4).isEmpty()) {
                z2 = false;
                map.put("applicantRelativesurnameL1", null);
            } else {
                if (!this.partLang.equals(this.english_code) && this.binding.relativenameTv1.getText().toString().substring(i4).matches(RegexMatcher.NAME_REGEX_CHECK)) {
                    showdialog(this.alert, "Relative last name(" + this.binding.relativenameTv1.getText().toString().substring(i4) + ") should be in regional language");
                    this.binding.relativenameTv1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                    this.alertDialog.dismiss();
                    return;
                }
                map.put("applicantRelativesurnameL1", this.binding.relativenameTv1.getText().toString().substring(i4).trim().replaceAll(" +", " "));
                z2 = false;
            }
            map.put("applicantRelativeSurnameL2", z2);
            map.put("dob", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.datetype.getText().toString())));
            map.put("applicantGender", str5);
            str2 = "";
            try {
                if (this.binding.emailTv.getText().toString().equals(str2)) {
                    map.put(this.emailText, null);
                } else {
                    map.put(this.emailText, this.binding.emailTv.getText().toString().trim());
                }
                if (this.binding.mobileNoTv.getText().toString().equals(str2)) {
                    map.put(this.mobileNumberText, null);
                } else {
                    map.put(this.mobileNumberText, this.binding.mobileNoTv.getText().toString().trim());
                }
                if (this.binding.ordinarydateTv.getText().toString().isEmpty()) {
                    map.put("dateFromWhichAbsentOnOrdinaryResidence", null);
                } else {
                    map.put("dateFromWhichAbsentOnOrdinaryResidence", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.ordinarydateTv.getText().toString())));
                }
                map.put("formSubmissionPlace", this.jsonobjectForm6A.get("formSubmissionPlace").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                if (this.jsonobjectForm6A.get("applicantDate").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2).equals("null")) {
                    map.put("applicantDate", null);
                } else {
                    map.put("applicantDate", this.jsonobjectForm6A.get("applicantDate").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                }
                if (this.jsonobjectForm6A.get(this.formSubmissionDate).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2).equals("null")) {
                    map.put(this.formSubmissionDate, str4);
                } else {
                    String str6 = this.formSubmissionDate;
                    map.put(str6, this.jsonobjectForm6A.get(str6).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                }
                if (this.jsonobjectForm6A.get("formSubmissionChannel").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2).equals("null") && this.jsonobjectForm6A.get("formSubmissionChannel").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2).equals(str2)) {
                    map.put("formSubmissionChannel", "GARUDA");
                } else {
                    map.put("formSubmissionChannel", this.jsonobjectForm6A.get("formSubmissionChannel").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                }
                map.put("formSubmissionMode", "ONLINE");
                map.put("oriState", this.stateCode);
                map.put("oriDistrict", this.binding.village.getText().toString().trim().replaceAll(" +", " "));
                map.put("oriHouseNumber", this.binding.houseno.getText().toString().trim().replaceAll(" +", " "));
                map.put("localityStreet", this.binding.street.getText().toString().trim().replaceAll(" +", " "));
                map.put("oriVillageTown", this.binding.villageTown.getText().toString().trim().replaceAll(" +", " "));
                map.put("oriPostOffice", this.binding.postoffice.getText().toString().trim().replaceAll(" +", " "));
                if (!this.binding.housenohindi.getText().toString().isEmpty()) {
                    map.put("oriHouseNumberL1", this.binding.housenohindi.getText().toString().trim().replaceAll(" +", " "));
                }
                map.put("oriHouseNumberL2", null);
                if (!this.binding.streets.getText().toString().isEmpty()) {
                    if (!this.partLang.equals(this.english_code) && this.binding.streets.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                        showdialog(this.alert, "Street(" + this.binding.streets.getText().toString() + ") should be in regional language");
                        this.binding.streets.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                        this.alertDialog.dismiss();
                        return;
                    }
                    map.put("oriLocalityL1", this.binding.streets.getText().toString().trim().replaceAll(" +", " "));
                }
                map.put("oriLocalityL2", null);
                if (!this.binding.villageHindi.getText().toString().isEmpty()) {
                    if (!this.partLang.equals(this.english_code) && this.binding.villageHindi.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                        this.binding.villageHindi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                        showdialog(this.alert, "Village(" + this.binding.villageHindi.getText().toString() + ") should be in regional language");
                        this.alertDialog.dismiss();
                        return;
                    }
                    map.put("oriVillageTownL1", this.binding.villageHindi.getText().toString().trim().replaceAll(" +", " "));
                }
                map.put("oriVillageTownL2", null);
                if (!this.binding.postoffice1.getText().toString().isEmpty()) {
                    if (!this.partLang.equals(this.english_code) && this.binding.postoffice1.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
                        showdialog(this.alert, "PostOffice(" + this.binding.postoffice1.getText().toString() + ") should be in regional language");
                        this.binding.postoffice1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
                        this.alertDialog.dismiss();
                        return;
                    }
                    map.put("oriPostOfficeL1", this.binding.postoffice1.getText().toString().trim().replaceAll(" +", " "));
                }
                map.put("oriPostOfficeL2", null);
                map.put("oriPinCode", this.binding.pincodeTv.getText().toString().trim().replaceAll(" +", " "));
                map.put("oriCountryCd", "IN");
                map.put("crosiState", this.binding.state.getText().toString());
                map.put("crosiDistrict", null);
                map.put("crosiHouseNumber", this.binding.houseNo.getText().toString().trim().replaceAll(" +", " "));
                map.put("crosiLocalityStreet", this.binding.streetArea.getText().toString().trim().replaceAll(" +", " "));
                map.put("crosiVillageTown", this.binding.villagTown.getText().toString().trim().replaceAll(" +", " "));
                map.put("crosiPostOffice", null);
                map.put("crosiHouseNumberL1", str2);
                map.put("crosiHouseNumberL2", null);
                map.put("crosiLocalityL1", str2);
                map.put("crosiLocalityL2", null);
                map.put("crosiVillageTownL1", str2);
                map.put("crosiVillageTownL2", null);
                map.put("crosiPostOfficeL1", null);
                map.put("crosiPostOfficeL2", null);
                map.put("reasonOfAbsence", str3);
                map.put("crosiZipCode", this.binding.countryZipcode.getText().toString());
                String str7 = this.crosiCountryCd;
                map.put(str7, this.jsonobjectForm6A.get(str7).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                map.put("passportNumber", this.binding.passportNo.getText().toString().trim());
                if (this.binding.placeIssueEd.getText().toString().isEmpty() || this.binding.placeIssueEd.getText().toString().equals(str2)) {
                    map.put(this.placeOfPassportIssue, null);
                } else {
                    map.put(this.placeOfPassportIssue, this.binding.passportissuePlace.getText().toString().trim());
                }
                map.put(this.dateOfPassportIssue, simpleDateFormat2.format(simpleDateFormat.parse(this.binding.passportIssue.getText().toString())));
                map.put("passportExpiry", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.passportExpiry.getText().toString())));
                if (this.binding.visaNo.getText().toString().isEmpty() || this.binding.visaNo.getText().toString().equals(str2)) {
                    map.put(this.visaNumber, null);
                } else {
                    map.put(this.visaNumber, this.binding.visaNo.getText().toString().trim().replaceAll(" +", " "));
                }
                if (this.binding.visaType.getText().toString().isEmpty() || this.binding.visaType.getText().toString().equals(str2)) {
                    map.put(this.typeOfVisa, null);
                } else {
                    map.put(this.typeOfVisa, this.binding.visaType.getText().toString().trim().replaceAll(" +", " "));
                }
                if (this.binding.visaIssue.getText().toString().equals(str2)) {
                    map.put(this.dateOfVisaIssue, null);
                } else {
                    map.put(this.dateOfVisaIssue, simpleDateFormat2.format(simpleDateFormat.parse(this.binding.visaIssue.getText().toString())));
                }
                if (this.binding.visaExpiry.getText().toString().equals(str2)) {
                    map.put(this.dateOfVisaExpiry, null);
                } else {
                    map.put(this.dateOfVisaExpiry, simpleDateFormat2.format(simpleDateFormat.parse(this.binding.visaExpiry.getText().toString())));
                }
                String strReplace = this.jsonobjectForm6A.get("declConstituency").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2);
                if (strReplace == null || strReplace.equals("null")) {
                    map.put("declConstituency", 0);
                } else {
                    map.put("declConstituency", strReplace);
                }
                String strReplace2 = this.jsonobjectForm6A.get("declFullAddress").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2);
                if (strReplace2 == null || strReplace2.equals("null")) {
                    map.put("declFullAddress", null);
                } else {
                    map.put("declFullAddress", strReplace2);
                }
                String strReplace3 = this.jsonobjectForm6A.get("declState").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2);
                if (strReplace3 == null || strReplace3.equals("null")) {
                    map.put("declState", null);
                } else {
                    map.put("declState", strReplace3);
                }
                String str8 = this.declareApplCode;
                map.put(str8, this.jsonobjectForm6A.get(str8).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                if (this.binding.descEd.getText().toString().isEmpty()) {
                    map.put(this.reasonOfAbsenceOthersDesc, str2);
                } else {
                    map.put(this.reasonOfAbsenceOthersDesc, this.binding.descEd.getText().toString().trim().replaceAll(" +", " "));
                }
                if (this.binding.visaAuthority.getText().toString().isEmpty() || this.binding.visaAuthority.getText().toString().equals(str2)) {
                    map.put(this.visaIssuingAuthority, null);
                } else {
                    map.put(this.visaIssuingAuthority, this.binding.visaAuthority.getText().toString().trim().replaceAll(" +", " "));
                }
                String str9 = this.declareApplCode;
                map.put(str9, this.jsonobjectForm6A.get(str9).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                if (this.jsonobjectForm6A.get("prevEpicIssueDate").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2) == null) {
                    map.put("prevEpicIssueDate", null);
                } else {
                    map.put("prevEpicIssueDate", this.jsonobjectForm6A.get("prevEpicIssueDate").toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                }
                String str10 = this.prevEpicNo;
                map.put(str10, this.jsonobjectForm6A.get(str10).toString().replace(RegexMatcher.JSON_STRING_REGEX, str2));
                map.put("isDraft", "N");
                map.put("createdBy", "operator");
                map.put("formRefNumber", this.referenceNo);
                Logger.d("photo after update :", this.photo);
                map.put("photograph", this.photo);
                map.put(this.passport, this.passportdocuments);
                map.put("isReinitiated", "Y");
                map.put("form6aId", Integer.valueOf(this.form6aId));
                map.put("id", 0);
                map.put("partNumber", this.partNo);
                map.put("sectionNo", 0);
                map.put("isIndia", this.isIndia);
                String str11 = this.isIndia;
                if (str11 == null || str11.equals("null") || this.isIndia.equalsIgnoreCase("Y")) {
                    if (this.birthDistrictCode.equalsIgnoreCase("null")) {
                        map.put("birthDistrictCd", null);
                    } else {
                        map.put("birthDistrictCd", this.birthDistrictCode);
                    }
                    if (this.binding.townName.getText().toString().isEmpty() || this.binding.townName.getText().toString().equals(str2)) {
                        z3 = false;
                        map.put(this.birthTownText, null);
                    } else {
                        map.put(this.birthTownText, this.binding.townName.getText().toString().trim().replaceAll(" +", " "));
                        z3 = false;
                    }
                    if (this.birthStateCode.equalsIgnoreCase("null")) {
                        map.put("birthStateCd", z3);
                    } else {
                        map.put("birthStateCd", this.birthStateCode);
                    }
                    map.put("placeOfBirthOutsideIndia", null);
                } else {
                    map.put("birthDistrictCd", null);
                    map.put(this.birthTownText, null);
                    map.put("birthStateCd", null);
                    map.put("placeOfBirthOutsideIndia", this.outsidePlaceOfBirth);
                }
                Logger.d("From6A request body", new Gson().toJson(map));
                submitform6A(this.stateCode, this.token, map);
                return;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
        }
        exc = e;
        Logger.d(str2, exc.getMessage());
    }

    public void submitform6A(String stateCode, String Token, Map<String, Object> json) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).submitform6A(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", "ANDROIDMOB", json).enqueue(new AnonymousClass33(stateCode, json, Token));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        final /* synthetic */ String val$Token;
        final /* synthetic */ Map val$json;
        final /* synthetic */ String val$stateCode;

        AnonymousClass33(final String val$stateCode, final Map val$json, final String val$Token) {
            this.val$stateCode = val$stateCode;
            this.val$json = val$json;
            this.val$Token = val$Token;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = ApplicantDetailsFragment.this.commonUtilClass;
                Context contextRequireContext = ApplicantDetailsFragment.this.requireContext();
                String str = ApplicantDetailsFragment.this.refreshToken;
                final String str2 = this.val$stateCode;
                final Map map = this.val$json;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$33$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, map, i, str3, str4);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                CommomUtility commomUtility2 = ApplicantDetailsFragment.this.commonutils;
                Context context = ApplicantDetailsFragment.this.getContext();
                String str3 = this.val$stateCode;
                int i = ApplicantDetailsFragment.this.processMasterId;
                int i2 = ApplicantDetailsFragment.this.currentStatusId;
                String str4 = this.val$Token;
                String atknBnd = SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getAtknBnd();
                String rtknBnd = SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getRtknBnd();
                final String str5 = this.val$stateCode;
                final String str6 = this.val$Token;
                commomUtility2.getWorkflowid(context, str3, i, i2, str4, atknBnd, rtknBnd, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$33$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str7) {
                        this.f$0.lambda$onResponse$3(str5, str6, i3, str7);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                if (jSONObject.has("cause")) {
                    ApplicantDetailsFragment.this.showdialog(String.valueOf(response.code()), jSONObject.optString("cause"));
                } else {
                    ApplicantDetailsFragment.this.showdialog(String.valueOf(response.code()), jSONObject.optString("message"));
                }
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, Map map, int i, String str2, String str3) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$33$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str2;
            ApplicantDetailsFragment.this.refreshToken = str3;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str2);
            ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
            applicantDetailsFragment.submitform6A(str, applicantDetailsFragment.token, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(String str, String str2, int i, String str3) {
            if (i == 401) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$33$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.workflowid = str3;
            ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
            applicantDetailsFragment.fvrsubmission(str, applicantDetailsFragment.processingid, ApplicantDetailsFragment.this.workflowid, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fvrsubmission(String stateCode, int processingid, String s, String token) {
        HashMap map = new HashMap();
        if (this.binding.informationSame.isChecked()) {
            map.put("fieldVerificationVerifiedAndCorrect", "Y");
        } else {
            map.put("fieldVerificationVerifiedAndCorrect", "N");
        }
        map.put("fieldVerificationDataEntryErrors", "N");
        if (this.binding.informationSame.isChecked()) {
            map.put("fieldVerificationAddress", "Y");
        } else {
            map.put("fieldVerificationAddress", "N");
        }
        if (this.binding.informationSame.isChecked()) {
            map.put("fieldVerificationPhoto", "Y");
        } else {
            map.put("fieldVerificationPhoto", "N");
        }
        if (this.binding.informationSame.isChecked()) {
            map.put("fieldVerificationDobOrAge", "Y");
        } else {
            map.put("fieldVerificationDobOrAge", "N");
        }
        if (this.binding.absentRb.isChecked()) {
            map.put("fieldVerificationAbsent", "Y");
        } else {
            map.put("fieldVerificationAbsent", "N");
        }
        if (this.binding.shiftedRb.isChecked()) {
            map.put("fieldVerificationShifted", "Y");
        } else {
            map.put("fieldVerificationShifted", "N");
        }
        if (this.binding.deadRb.isChecked()) {
            map.put("fieldVerificationDead", "Y");
        } else {
            map.put("fieldVerificationDead", "N");
        }
        if (this.binding.nosuchpersonRb.isChecked()) {
            map.put("fieldVerificationNoSuchPerson", "Y");
        } else {
            map.put("fieldVerificationNoSuchPerson", "N");
        }
        if (this.binding.availableRb.isChecked()) {
            map.put("fieldVerificationPersonPresent", "Y");
        } else {
            map.put("fieldVerificationPersonPresent", "N");
        }
        map.put("fieldVerificationAlreadyAppliedCount", 0);
        map.put("fieldVerificationRemark", this.binding.remark1.getText().toString());
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
        map.put("fieldVerificationChecklist", null);
        this.commonutils.getRetrofitClient(getContext(), token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).formProcessingService(stateCode, "blo", Integer.parseInt(s), processingid, "ANDROIDMOB", map).enqueue(new AnonymousClass34());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<Void> {
        AnonymousClass34() {
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            if (response.code() == 401) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$34$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            if (response.isSuccessful()) {
                ApplicantDetailsFragment.this.showdialog1("Success", "Verified Successfully");
                ApplicantDetailsFragment.this.alertDialog.dismiss();
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
                applicantDetailsFragment.showdialog(applicantDetailsFragment.alert, strOptString);
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<Void> call, Throwable t) {
            ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
            applicantDetailsFragment.showdialog(applicantDetailsFragment.alert, "Please submit again");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == 2131364763) {
            this.binding.nameEd2.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.nameEd.getText().toString().trim(), this.binding.nameEd2, this.partLang, "NAME");
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131364288) {
            this.binding.lastnameEd2.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.lastnameEd.getText().toString().trim(), this.binding.lastnameEd2, this.partLang, "NAME");
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365432) {
            this.binding.relativeNameEd2.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeNameEd.getText().toString().trim(), this.binding.relativeNameEd2, this.partLang, "NAME");
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365427) {
            this.binding.relativeLastnameEd2.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeLastnameEd.getText().toString().trim(), this.binding.relativeLastnameEd2, this.partLang, "NAME");
            } catch (Exception e4) {
                Logger.d("", e4.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131364093) {
            this.binding.houseNoEdhindi.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseNoEdhindi, this.partLang, this.addressfield);
            } catch (Exception e5) {
                Logger.d("", e5.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365888) {
            this.binding.streetEdhindi.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetEdhindi, this.partLang, this.addressfield);
            } catch (Exception e6) {
                Logger.d("", e6.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131366679) {
            this.binding.villageEdhindi.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.villageEd.getText().toString().trim(), this.binding.villageEdhindi, this.partLang, this.addressfield);
            } catch (Exception e7) {
                Logger.d("", e7.getMessage());
            }
            return true;
        }
        if (v.getId() != 2131365195) {
            return false;
        }
        this.binding.postOfficehin.requestFocus();
        try {
            FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postOfficehin, this.partLang, this.addressfield);
        } catch (Exception e8) {
            Logger.d("", e8.getMessage());
        }
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == 2131364763 && hasFocus) {
            if (this.binding.applicantNameTv1.getText().toString().isEmpty()) {
                this.binding.nameEd.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.nameEd.getText().toString().trim(), this.binding.nameEd2, this.partLang, "NAME");
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }
        }
        if (v.getId() == 2131364288 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.lastnameEd.getText().toString().trim(), this.binding.lastnameEd2, this.partLang, "NAME");
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
        }
        if (v.getId() == 2131365432 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeNameEd.getText().toString().trim(), this.binding.relativeNameEd2, this.partLang, "NAME");
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
        }
        if (v.getId() == 2131365427 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeLastnameEd.getText().toString().trim(), this.binding.relativeLastnameEd2, this.partLang, "NAME");
            } catch (Exception e4) {
                Logger.d("", e4.getMessage());
            }
        }
        if (v.getId() == 2131364093 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseNoEdhindi, this.partLang, this.addressfield);
            } catch (Exception e5) {
                Logger.d("", e5.getMessage());
            }
        }
        if (v.getId() == 2131365195 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postOfficehin, this.partLang, this.addressfield);
            } catch (Exception e6) {
                Logger.d("", e6.getMessage());
            }
        }
        if (v.getId() == 2131365888 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetEdhindi, this.partLang, this.addressfield);
            } catch (Exception e7) {
                Logger.d("", e7.getMessage());
            }
        }
        if (v.getId() == 2131366679 && hasFocus) {
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.villageEd.getText().toString().trim(), this.binding.villageEdhindi, this.partLang, this.addressfield);
            } catch (Exception e8) {
                Logger.d("", e8.getMessage());
            }
        }
    }

    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference) {
        RestClient restClient = (RestClient) ApiClient.getClient1(getContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass35(statecode, asmblyNo, partno, filepath, captureFileName, reference));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;

        AnonymousClass35(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            System.out.println("responseCode " + response.code());
            if (response.code() == 401) {
                CommomUtility commomUtility = ApplicantDetailsFragment.this.commonUtilClass;
                Context contextRequireContext = ApplicantDetailsFragment.this.requireContext();
                String str = ApplicantDetailsFragment.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$35$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str8, String str9) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, i, str8, str9);
                    }
                });
                ApplicantDetailsFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 200) {
                ApplicantDetailsFragment.this.commonUtilClass.uploadToServer2(ApplicantDetailsFragment.this.getContext(), this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, ApplicantDetailsFragment.this.token, this.val$reference, SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$35$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str8) {
                        this.f$0.lambda$onResponse$3(i, str8);
                    }
                });
                return;
            }
            try {
                ApplicantDetailsFragment.this.binding.previewPhoto.setVisibility(8);
                ApplicantDetailsFragment.this.binding.chooseCorrectPhotoFileDeletion.setVisibility(8);
                ApplicantDetailsFragment.this.binding.choosePhotoSize.setVisibility(8);
                ApplicantDetailsFragment.this.binding.chooseCorrectPhotoName.setVisibility(8);
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
                applicantDetailsFragment.showdialog(applicantDetailsFragment.alert, jSONObject.optString("message"));
            } catch (IOException | JSONException e) {
                Logger.d("ApplicationDetsailsFragment", e.toString());
            }
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8) {
            ApplicantDetailsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str7 + " " + str8);
            if (i == 401 || i == 400) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$35$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ApplicantDetailsFragment.this.token = "Bearer " + str7;
            ApplicantDetailsFragment.this.refreshToken = str8;
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setRefreshToken(str8);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setToken("Bearer " + str7);
            ApplicantDetailsFragment applicantDetailsFragment = ApplicantDetailsFragment.this;
            applicantDetailsFragment.faceRecognition(str, str2, str3, str4, str5, applicantDetailsFragment.token, str6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, String str) {
            if (i == 401) {
                ApplicantDetailsFragment.this.commonUtilClass.showMessageOK(ApplicantDetailsFragment.this.getContext(), ApplicantDetailsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$35$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                ApplicantDetailsFragment.this.alertDialog.dismiss();
            } else {
                ApplicantDetailsFragment.this.photo = str;
                ApplicantDetailsFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ApplicantDetailsFragment.this.requireContext()).setLocaleBool(false);
            ApplicantDetailsFragment.this.startActivity(new Intent((Context) ApplicantDetailsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ApplicantDetailsFragment.this.binding.previewPhoto.setVisibility(8);
            ApplicantDetailsFragment.this.binding.chooseCorrectPhotoFileDeletion.setVisibility(8);
            ApplicantDetailsFragment.this.binding.choosePhotoSize.setVisibility(8);
            ApplicantDetailsFragment.this.binding.chooseCorrectPhotoName.setVisibility(8);
            Logger.d(" ", t.getMessage());
            ApplicantDetailsFragment.this.alertDialog.dismiss();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private void getCountry(final Spinner spinner) {
        this.country = new ArrayList<>();
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment$$ExternalSyntheticLambda75
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getCountry$89(spinner, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCountry$89(Spinner spinner, int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(Constants.COUNTRYNAME1);
        spinner.setAdapter((SpinnerAdapter) this.countryadapter);
        if (!TextUtils.isEmpty(this.outsidePlaceOfBirth)) {
            spinner.setSelection(this.country.indexOf(this.outsidePlaceOfBirth));
        } else {
            spinner.setSelection(0);
        }
    }
}
