package in.gov.eci.bloapp.views.fragments.checklist;

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
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentShiftingOfResidenceBinding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ShiftingOfResidenceOverseasFragment extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnFocusChangeListener {
    private static final String AADHAAR_CARD = "Aadhaar Card";
    private static final String AADHAR_REF_NO = "aadharRefNo";
    private static final String ADD_PHOTOGRAPH = "Add Photo!";
    private static final String ALERT = "Alert";
    private static final String APPLICANT_DATE = "applicantDate";
    private static final String APPLICANT_NAME = "applicantName";
    private static final String APPLICATION_FOR = "applicationFor";
    private static final String APPLICATION_PDF = "application/pdf";
    private static final String ASSEMBLY_NO = "assemblyNo";
    private static final String BEFORE_TEXT_CHANGED = "beforeTextChanged";
    private static final String BIRTH_CERTIFICATE_ISSUED_BY_COMPETENT_LOCAL_BODY_MUNICIPAL_AUTHORITY_REGISTRAR_OF_BIRTHS_DEATHS = "Birth certificate issued by Competent Local Body/Municipal Authority/Registrar of Births & Deaths";
    private static final String BLACK_COLOR = "#000000";
    private static final String BLOAPP = "BLOAPP";
    private static final String CANCEL = "Cancel";
    private static final String CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY = "Can't obtain file name, cursor is empty";
    private static final String CERTIFICATES_OF_CLASS_X_OR_CLASS_XII_ISSUED_BY_CBSE_ICSE_STATE_EDUCATION_BOARDS_IF_IT_CONTAINS_DATE_OF_BIRTH = "Certificates of Class X or Class XII issued by CBSE/ICSE/ State Education Boards, if it contains Date of Birth";
    private static final String CHOOSE_FILE = "Choose File";
    private static final String CHOOSE_IMAGE_FROM_GALLERY = "Choose Image from Gallery";
    private static final String CHOOSE_PDF_FROM_GALLERY = "Choose PDF from Gallery";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String CONTENT = "CONTENT";
    private static final String CORRECTION_OF_ADDRESS = "correctionOfAddress";
    private static final String CORRECTION_OF_AGE = "correctionOfAge";
    private static final String CORRECTION_OF_DOB = "correctionOfDob";
    private static final String CORRECTION_OF_GENDER = "correctionOfGender";
    private static final String CORRECTION_OF_MOBILE = "correctionOfMobile";
    private static final String CORRECTION_OF_NAME = "correctionOfName";
    private static final String CORRECTION_OF_PHOTOGRAPGH = "correctionOfPhotograpgh";
    private static final String CORRECTION_OF_RELATION = "correctionOfRelation";
    private static final String CORRECTION_OF_RELATIVE = "correctionOfRelative";
    private static final String CRIMSON_RED = "#99000000";
    private static final String CURRENT_PASSBOOK_OF_NATIONALIZED_SCHEDULED_BANK_POST_OFFICE = "Current passbook of Nationalized/Scheduled Bank/Post Office";
    private static final String DATE_OF_BIRTH = "dateOfBirth";
    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    private static final String DISTRICT_CD = "districtCd";
    private static final String DRIVING_LICENSE = "Driving License";
    private static final String EMAILD_RELATIVE = "emaildRelative";
    private static final String EMAILD_SELF = "emaildSelf";
    private static final String ENTRIES_CORRECTION_IN_EROLL = "entriesCorrectionInEroll";
    private static final String EPIC_ID = "epicId";
    private static final String EPIC_OF_FAMILY_MEMBER = "epicOfFamilyMember";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String FIRST_NAME = "firstName";
    private static final String FIRST_NAME_L_1 = "firstNameL1";
    private static final String FORM_SUBMISSION_CHANNEL = "formSubmissionChannel";
    private static final String FORM_SUBMISSION_DATE = "formSubmissionDate";
    private static final String FORM_SUBMISSION_MODE = "formSubmissionMode";
    private static final String FORM_SUBMISSION_PLACE = "formSubmissionPlace";
    private static final String GENDER21 = "gender";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_L_1 = "houseNumberL1";
    private static final String IMAGE = "image";
    private static final String IMAGE_SIZE_EXCEEDED_2_MB_LIMIT = "Image size exceeded 2MB limit.";
    private static final String INDIAN_PASSPORT = "Indian Passport";
    private static final String IS_DRAFT = "isDraft";
    private static final String LAST_NAME = "lastName";
    private static final String LAST_NAME_L_1 = "lastNameL1";
    private static final String LOCALITY_L_1 = "localityL1";
    private static final String LOCALITY_OR_STREET = "localityOrStreet";
    private static final String MARKING_OF_PWD = "markingOfPwd";
    private static final String MOBILE_NUMBER = "mobileNumber";
    private static final String MOBILE_NUMBER_OF_RELATIVE = "mobileNumberOfRelative";
    private static final String MOBILE_NUMBER_SELF = "mobileNumberSelf";
    private static final String NO_DOCUMENT_AVAILABLE = "No Document Available";
    private static final String OBJECTSTORAGE = "objectstorage";
    private static final String ON_NOTHING_SELECTED = "onNothingSelected";
    private static final String OTHERS_PLEASE_SPECIFY = "Others (Please Specify)";
    private static final String OTHRS = "OTHRS";
    private static final String PAN_CARD = "PAN Card";
    private static final String PART_NUMBER = "partNumber";
    private static final String PDF_SIZE_EXCEEDED_3_MB_LIMIT = "PDF size exceeded 3MB limit.";
    private static final String PIN_CODE = "pinCode";
    private static final String PLEASE_SELECT_A_DOCUMENT_TYPE = "Please Select a Document Type";
    private static final String PLEASE_SELECT_CORRECT_FORMAT_OF_FILE = "Please Select correct format of file.";
    private static final String POST_OFFICE = "postOffice";
    private static final String POST_OFFICE_L_1 = "postOfficeL1";
    private static final String PRVS_AC_NO = "prvsAcNo";
    private static final String PRVS_DISTRICT_CD = "prvsDistrictCd";
    private static final String PRVS_PART_NO = "prvsPartNo";
    private static final String PRVS_SL_NO = "prvsSlNo";
    private static final String PRVS_STATE_CD = "prvsStateCd";
    private static final String REFERENCE_NUMBER = "referenceNumber";
    private static final String REGISTERED_RENT_LEASE_DEED_IN_CASE_OF_TENANT = "Registered Rent Lease Deed (In case of tenant)";
    private static final String REGISTERED_SALE_DEED_IN_CASE_OF_OWN_HOUSE = "Registered Sale Deed (In case of own house)";
    private static final String RELATION_TYPE = "relationType";
    private static final String RELATIVE_NAME = "relativeName";
    private static final String RELATIVE_NAME_REGIONAL = "relativeNameRegional";
    private static final String RELATIVE_SURNAME = "relativeSurname";
    private static final String RELATIVE_SURNAME_REGIONAL = "relativeSurnameRegional";
    private static final String REPLACEMENT_OF_EPIC = "replacementOfEpic";
    private static final String REVENUE_DEPARTMENT_S_LAND_OWNING_RECORDS_INCLUDING_KISAN_BAHI = "Revenue Department's Land-Owning records including Kisan Bahi";
    private static final String SECTION_NO = "sectionNo";
    private static final String SELECT_ADDRESS_PROOF = "Select Address Proof";
    private static final String SELECT_DOCUMENT_TYPE = "Select Document type";
    private static final String SERIAL_NUMBER = "serialNumber";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String SHIFTING_OF_RESIDENCE1 = "shiftingOfResidence";
    private static final String STATE_CD = "stateCd";
    private static final String SUPPORT_DOC_DLN = "supportDocDLN";
    private static final String SUPPORT_DOC_DLN_2 = "supportDocDLN2";
    private static final String SUPPORT_DOC_DLN_3 = "supportDocDLN3";
    private static final String SUPPORT_DOC_DLN_4 = "supportDocDLN4";
    private static final String TAKE_PHOTO = "Take Photo";
    private static final String TALUKA_OR_TEHSIL_OR_MANDAL = "talukaOrTehsilOrMandal";
    private static final String TALUKA_OR_TEHSIL_OR_MANDAL_L_1 = "talukaOrTehsilOrMandalL1";
    private static final String TYPE_OF_DOC = "typeOfDoc";
    private static final String TYPE_OF_DOC_2 = "typeOfDoc2";
    private static final String TYPE_OF_DOC_3 = "typeOfDoc3";
    private static final String TYPE_OF_DOC_4 = "typeOfDoc4";
    private static final String VILLAGE_OR_TOWN = "villageOrTown";
    private static final String VILLAGE_OR_TOWN_L_1 = "villageOrTownL1";
    private static final String WATER_ELECTRICITY_GAS_CONNECTION_BILL_FOR_THAT_ADDRESS_AT_LEAST_1_YEAR = "Water/Electricity/Gas connection Bill for that address (at least 1 year)";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    ActivityResultLauncher<Intent> activityResultLauncher1;
    private int addproofpos1;
    private String addproofspinnercode;
    private String addressproofType;
    AlertDialog alertDialog;
    private String anyOtherDocumentNameSOR;
    private String asmblyNO;
    private String base64element1;
    BloFragmentShiftingOfResidenceBinding binding;
    Retrofit.Builder builder;
    private byte[] byteArray;
    private int currentStatusId;
    private String districtSor;
    private String documentCode;
    private String documentName1;
    String filepathimg;
    private int formProcessingDetailsId;
    private String housesor;
    private String housesore;
    Uri imageUri;
    private String orphotoref;
    private String partLang;
    private String partNo;
    private String photoref;
    private String pincodesor;
    private String postofficesor;
    private String postofficesore;
    private int processMasterId;
    private String referenceNo;
    private String refreshToken;
    Retrofit retrofit;
    private String stateCode;
    private String stateSor;
    private String streetsor;
    private String streetsore;
    private String tehsilsor;
    private String tehsilsore;
    private String token;
    private String villagesor;
    private String villagesore;
    String english_code = "en_in";
    CommomUtility commonutils = new CommomUtility();
    private final CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public ShiftingOfResidenceOverseasFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonutils.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.base64element1 = "";
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass14());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentShiftingOfResidenceBinding.inflate(inflater);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new AnonymousClass1());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.housesor = arguments.getString("houseNo");
            this.housesore = arguments.getString("houseNoL1");
            this.streetsor = arguments.getString("street");
            this.streetsore = arguments.getString("streetL1");
            this.villagesor = arguments.getString("village");
            this.villagesore = arguments.getString("villageL1");
            this.postofficesor = arguments.getString("postoffice");
            this.postofficesore = arguments.getString("postofficeL1");
            this.pincodesor = arguments.getString("pincode");
            this.tehsilsor = arguments.getString("tehsil");
            this.tehsilsore = arguments.getString("tehsilL1");
            this.photoref = arguments.getString("addressDoc");
            this.anyOtherDocumentNameSOR = arguments.getString("anyOtherDocumentNameSOR");
            this.addressproofType = arguments.getString("typeOfDocAddress");
            this.referenceNo = arguments.getString("referenceNo");
            this.stateSor = arguments.getString("stateSor");
            this.districtSor = arguments.getString("districtSor");
            this.formProcessingDetailsId = arguments.getInt("formProcessingId");
            this.currentStatusId = arguments.getInt("currentStatusid");
            this.processMasterId = arguments.getInt("processMasterId");
        }
        this.binding.refNoTv.setText(this.referenceNo);
        this.orphotoref = this.photoref;
        this.binding.preview.setVisibility(8);
        this.binding.chooseFileDeletion.setVisibility(8);
        this.binding.chooseFileName.setVisibility(8);
        this.binding.chooseFileNameSize.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        arrayList.add(SELECT_ADDRESS_PROOF);
        arrayList.add(WATER_ELECTRICITY_GAS_CONNECTION_BILL_FOR_THAT_ADDRESS_AT_LEAST_1_YEAR);
        arrayList.add(AADHAAR_CARD);
        arrayList.add(CURRENT_PASSBOOK_OF_NATIONALIZED_SCHEDULED_BANK_POST_OFFICE);
        arrayList.add(INDIAN_PASSPORT);
        arrayList.add(REVENUE_DEPARTMENT_S_LAND_OWNING_RECORDS_INCLUDING_KISAN_BAHI);
        arrayList.add(REGISTERED_RENT_LEASE_DEED_IN_CASE_OF_TENANT);
        arrayList.add(REGISTERED_SALE_DEED_IN_CASE_OF_OWN_HOUSE);
        arrayList.add(OTHERS_PLEASE_SPECIFY);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.addProofSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.binding.addProofSpinner.setSelection(0);
        this.binding.addProofSpinner.setOnItemSelectedListener(this);
        if (this.binding.addProofSpinner.getSelectedItem().equals(OTHERS_PLEASE_SPECIFY)) {
            this.binding.otherDocSorLl.setVisibility(0);
        }
        if (this.addressproofType.equals("WEGB")) {
            this.addproofpos1 = 1;
        }
        if (this.addressproofType.equals("ADHR")) {
            this.addproofpos1 = 2;
        }
        if (this.addressproofType.equals("CPNS")) {
            this.addproofpos1 = 3;
        }
        if (this.addressproofType.equals("IPSP")) {
            this.addproofpos1 = 4;
        }
        if (this.addressproofType.equals("RDLR")) {
            this.addproofpos1 = 5;
        }
        if (this.addressproofType.equals("RRLD")) {
            this.addproofpos1 = 6;
        }
        if (this.addressproofType.equals("RSD")) {
            this.addproofpos1 = 7;
        }
        if (this.addressproofType.equals(OTHRS)) {
            this.addproofpos1 = 8;
        }
        String str = this.photoref;
        if (str == null || str.equals(StringUtils.SPACE) || this.photoref.equals("") || this.photoref.equals("null")) {
            this.binding.preview.setVisibility(8);
            this.binding.chooseFileName.setVisibility(8);
            this.binding.chooseFileNameSize.setVisibility(8);
            this.binding.chooseFileDeletion.setVisibility(8);
            this.binding.addProofSpinner.setSelection(0);
        } else {
            try {
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileName.setVisibility(0);
                this.binding.chooseFileNameSize.setVisibility(0);
                this.binding.chooseFileDeletion.setVisibility(0);
                this.binding.chooseFileName.setText(this.photoref);
                this.binding.chooseFileNameSize.setText("");
                this.binding.addProofSpinner.setSelection(this.addproofpos1);
                if (this.photoref.contains(".pdf")) {
                    this.binding.preview.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blo_pfd_thumbnail));
                } else {
                    this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getFile(OBJECTSTORAGE, this.photoref, this.token, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass2());
                }
            } catch (Exception e) {
                Logger.e("", e.getMessage());
            }
        }
        this.binding.houseET.setText(this.housesor);
        this.binding.streetET.setText(this.streetsor);
        this.binding.townVillage.setText(this.villagesor);
        this.binding.postofficeSpinner.setText(this.postofficesor);
        this.binding.tehsilMandala.setText(this.tehsilsor);
        this.binding.pincodeET.setText(this.pincodesor);
        this.binding.houseEteng.setText(this.housesore);
        this.binding.streetETeng.setText(this.streetsore);
        this.binding.townVillageeng.setText(this.villagesore);
        this.binding.postofficeSpinnereng.setText(this.postofficesore);
        this.binding.tehsilMandalaeng.setText(this.tehsilsore);
        this.binding.OtherAddProof.setText(this.anyOtherDocumentNameSOR);
        this.binding.stateSorEditTv.setText(this.stateSor);
        this.binding.districtSorEditTv.setText(this.districtSor);
        this.binding.otherDocSorLl.setVisibility(8);
        this.binding.chooseFile.setEnabled(true);
        this.binding.houseEteng.setOnFocusChangeListener(this);
        this.binding.streetETeng.setOnFocusChangeListener(this);
        this.binding.townVillageeng.setOnFocusChangeListener(this);
        this.binding.postofficeSpinnereng.setOnFocusChangeListener(this);
        this.binding.tehsilMandalaeng.setOnFocusChangeListener(this);
        this.binding.houseET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.streetET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.townVillage.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.postofficeSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.pincodeET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.tehsilMandala.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.houseET.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.streetET.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.townVillage.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.postofficeSpinner.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.tehsilMandala.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.houseET.setInputType(532624);
        this.binding.streetET.setInputType(532624);
        this.binding.townVillage.setInputType(532624);
        this.binding.postofficeSpinner.setInputType(532624);
        this.binding.tehsilMandala.setInputType(532624);
        this.binding.houseET.setImportantForAutofill(2);
        this.binding.streetET.setImportantForAutofill(2);
        this.binding.townVillage.setImportantForAutofill(2);
        this.binding.postofficeSpinner.setImportantForAutofill(2);
        this.binding.tehsilMandala.setImportantForAutofill(2);
        String strSubstring = this.partLang.substring(0, 2);
        this.binding.houseEteng.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.houseEteng.setImportantForAutofill(2);
        this.binding.streetETeng.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.streetETeng.setImportantForAutofill(2);
        this.binding.townVillageeng.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.townVillageeng.setImportantForAutofill(2);
        this.binding.postofficeSpinnereng.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.postofficeSpinnereng.setImportantForAutofill(2);
        this.binding.tehsilMandalaeng.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.tehsilMandalaeng.setImportantForAutofill(2);
        this.binding.houseET.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ShiftingOfResidenceOverseasFragment.this.binding.houseET.getText().toString();
                if (ShiftingOfResidenceOverseasFragment.this.binding.houseET.getText().toString().matches(RegexMatcher.HOUSE_REGEX)) {
                    return;
                }
                try {
                    ShiftingOfResidenceOverseasFragment.this.binding.houseET.setText(string.substring(0, string.length() - 1));
                    ShiftingOfResidenceOverseasFragment.this.binding.houseET.setSelection(ShiftingOfResidenceOverseasFragment.this.binding.houseET.getText().toString().length());
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getText().clear();
                }
            }
        });
        this.binding.houseEteng.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getText().toString());
                    sb.charAt(ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getSelectionStart() - 1);
                    int selectionStart = ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getSelectionStart() - 1;
                    if (ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.getSelectionStart() - 1);
                        ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.setText(sb);
                        ShiftingOfResidenceOverseasFragment.this.binding.houseEteng.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }
        });
        this.binding.streetET.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ShiftingOfResidenceOverseasFragment.this.binding.streetET.getText().toString();
                if (ShiftingOfResidenceOverseasFragment.this.binding.streetET.getText().toString().matches("^(?![-]*$)(?![']*$)(?![.]*$)(?!\\[\\]*$)(?![,]*$)[\\sa-zA-Z0-9\\-.,']+$")) {
                    return;
                }
                try {
                    ShiftingOfResidenceOverseasFragment.this.binding.streetET.setText(string.substring(0, string.length() - 1));
                    ShiftingOfResidenceOverseasFragment.this.binding.streetET.setSelection(ShiftingOfResidenceOverseasFragment.this.binding.streetET.getText().toString().length());
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getText().clear();
                }
            }
        });
        this.binding.streetETeng.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getText().toString());
                    sb.charAt(ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getSelectionStart() - 1);
                    int selectionStart = ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getSelectionStart() - 1;
                    if (ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.getSelectionStart() - 1);
                        ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.setText(sb);
                        ShiftingOfResidenceOverseasFragment.this.binding.streetETeng.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }
        });
        this.binding.townVillage.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ShiftingOfResidenceOverseasFragment.this.binding.townVillage.getText().toString();
                if (ShiftingOfResidenceOverseasFragment.this.binding.townVillage.getText().toString().matches("^(?![-]*$)(?![']*$)(?![.]*$)(?!\\[\\]*$)(?![,]*$)[\\sa-zA-Z0-9\\-.,']+$")) {
                    return;
                }
                try {
                    ShiftingOfResidenceOverseasFragment.this.binding.townVillage.setText(string.substring(0, string.length() - 1));
                    ShiftingOfResidenceOverseasFragment.this.binding.townVillage.setSelection(ShiftingOfResidenceOverseasFragment.this.binding.townVillage.getText().toString().length());
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getText().clear();
                }
            }
        });
        this.binding.townVillageeng.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getText().toString());
                    sb.charAt(ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getSelectionStart() - 1);
                    int selectionStart = ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getSelectionStart() - 1;
                    if (ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.getSelectionStart() - 1);
                        ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.setText(sb);
                        ShiftingOfResidenceOverseasFragment.this.binding.townVillageeng.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }
        });
        this.binding.postofficeSpinner.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinner.getText().toString();
                if (ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinner.getText().toString().matches("^(?![-]*$)(?![']*$)(?![.]*$)(?!\\[\\]*$)(?![,]*$)[\\sa-zA-Z0-9\\-.,']+$")) {
                    return;
                }
                try {
                    ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinner.setText(string.substring(0, string.length() - 1));
                    ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinner.setSelection(ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinner.getText().toString().length());
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getText().clear();
                }
            }
        });
        this.binding.postofficeSpinnereng.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getText().toString());
                    sb.charAt(ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getSelectionStart() - 1);
                    int selectionStart = ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getSelectionStart() - 1;
                    if (ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.getSelectionStart() - 1);
                        ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.setText(sb);
                        ShiftingOfResidenceOverseasFragment.this.binding.postofficeSpinnereng.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }
        });
        this.binding.tehsilMandala.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandala.getText().toString();
                if (ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandala.getText().toString().matches("^(?![-]*$)(?![']*$)(?![.]*$)(?!\\[\\]*$)(?![,]*$)[\\sa-zA-Z0-9\\-.,']+$")) {
                    return;
                }
                try {
                    ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandala.setText(string.substring(0, string.length() - 1));
                    ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandala.setSelection(ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandala.getText().toString().length());
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == '@') {
                    Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
                } else {
                    if (s == null || !s.toString().isEmpty()) {
                        return;
                    }
                    ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getText().clear();
                }
            }
        });
        this.binding.tehsilMandalaeng.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment.12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getText().toString());
                    sb.charAt(ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getSelectionStart() - 1);
                    int selectionStart = ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getSelectionStart() - 1;
                    if (ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.getSelectionStart() - 1);
                        ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.setText(sb);
                        ShiftingOfResidenceOverseasFragment.this.binding.tehsilMandalaeng.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') {
                    return;
                }
                Logger.d(ShiftingOfResidenceOverseasFragment.BEFORE_TEXT_CHANGED, String.valueOf(s));
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.binding.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.submitTv2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.COR.setEnabled(false);
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$6(view);
            }
        });
        this.binding.chooseFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.binding.textView23.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShiftingOfResidenceOverseasFragment.this.alertDialog.show();
            Bundle bundle = new Bundle();
            bundle.putString("Flag", "NEW");
            bundle.putString("refNo", ShiftingOfResidenceOverseasFragment.this.referenceNo);
            bundle.putInt("formProcessingId", ShiftingOfResidenceOverseasFragment.this.formProcessingDetailsId);
            bundle.putInt("currentStatusid", ShiftingOfResidenceOverseasFragment.this.currentStatusId);
            bundle.putInt("processMasterId", ShiftingOfResidenceOverseasFragment.this.processMasterId);
            FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
            formsDetailsOverseasFragment.setArguments(bundle);
            ShiftingOfResidenceOverseasFragment.this.openFragment(formsDetailsOverseasFragment, "FormDetailsOverseasFragment");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            ShiftingOfResidenceOverseasFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ShiftingOfResidenceOverseasFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ShiftingOfResidenceOverseasFragment.this.base64element1.isEmpty() || ShiftingOfResidenceOverseasFragment.this.base64element1.equals("null")) {
                    return;
                }
                byte[] bArrDecode = Base64.decode(ShiftingOfResidenceOverseasFragment.this.base64element1, 0);
                ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                return;
            }
            if (response.code() == 401) {
                System.out.println("laieufbia");
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.getRefreshToken(ShiftingOfResidenceOverseasFragment.this.requireContext(), ShiftingOfResidenceOverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$2$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ShiftingOfResidenceOverseasFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
                System.out.println("labia");
            } catch (IOException | JSONException e) {
                System.out.println("ionpoi");
                Logger.e("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ShiftingOfResidenceOverseasFragment.this.alertDialog.dismiss();
            System.out.println("anudionap " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.showMessageOK(ShiftingOfResidenceOverseasFragment.this.requireContext(), ShiftingOfResidenceOverseasFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            System.out.println("sjfos");
            ShiftingOfResidenceOverseasFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setToken("Bearer " + str);
            Bundle bundle = new Bundle();
            bundle.putString("refNo", ShiftingOfResidenceOverseasFragment.this.referenceNo);
            bundle.putInt("formProcessingId", ShiftingOfResidenceOverseasFragment.this.formProcessingDetailsId);
            bundle.putInt("currentStatusid", ShiftingOfResidenceOverseasFragment.this.currentStatusId);
            bundle.putInt("processMasterId", ShiftingOfResidenceOverseasFragment.this.processMasterId);
            ShiftingOfResidenceOverseasFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.", bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setLocaleBool(false);
            ShiftingOfResidenceOverseasFragment.this.startActivity(new Intent((Context) ShiftingOfResidenceOverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ShiftingOfResidenceOverseasFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        this.alertDialog.show();
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW");
        bundle.putString("refNo", this.referenceNo);
        bundle.putInt("formProcessingId", this.formProcessingDetailsId);
        bundle.putInt("currentStatusid", this.currentStatusId);
        bundle.putInt("processMasterId", this.processMasterId);
        FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
        formsDetailsOverseasFragment.setArguments(bundle);
        openFragment(formsDetailsOverseasFragment, "FormsDetailsOverseasFragment");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        this.binding.houseET.setText(this.housesor);
        this.binding.streetET.setText(this.streetsor);
        this.binding.townVillage.setText(this.villagesor);
        this.binding.postofficeSpinner.setText(this.postofficesor);
        this.binding.tehsilMandala.setText(this.tehsilsor);
        this.binding.pincodeET.setText(this.pincodesor);
        this.binding.houseEteng.setText(this.housesore);
        this.binding.streetETeng.setText(this.streetsore);
        this.binding.townVillageeng.setText(this.villagesore);
        this.binding.postofficeSpinnereng.setText(this.postofficesore);
        this.binding.tehsilMandalaeng.setText(this.tehsilsore);
        this.binding.stateSorEditTv.setText(this.stateSor);
        this.binding.districtSorEditTv.setText(this.districtSor);
        this.binding.OtherAddProof.setText(this.anyOtherDocumentNameSOR);
        this.binding.chooseFileName.setText("");
        this.binding.houseEteng.setText(this.housesore);
        this.binding.streetETeng.setText(this.streetsore);
        this.binding.townVillageeng.setText(this.villagesore);
        this.binding.postofficeSpinnereng.setText(this.postofficesore);
        this.binding.tehsilMandalaeng.setText(this.tehsilsore);
        this.binding.otherDocSorLl.setVisibility(8);
        this.binding.OtherAddProof.setHint("");
        this.binding.OtherAddProof.setText("");
        this.binding.chooseFileName.setVisibility(0);
        this.binding.preview.setVisibility(0);
        this.binding.chooseFileDeletion.setVisibility(0);
        this.binding.chooseFileNameSize.setVisibility(0);
        this.binding.chooseFile.setEnabled(true);
        this.binding.addProofSpinner.setSelection(0);
        this.photoref = this.orphotoref;
        if (this.addressproofType.equals("WEGB")) {
            this.addproofpos1 = 1;
        }
        if (this.addressproofType.equals("ADHR")) {
            this.addproofpos1 = 2;
        }
        if (this.addressproofType.equals("CPNS")) {
            this.addproofpos1 = 3;
        }
        if (this.addressproofType.equals("IPSP")) {
            this.addproofpos1 = 4;
        }
        if (this.addressproofType.equals("RDLR")) {
            this.addproofpos1 = 5;
        }
        if (this.addressproofType.equals("RRLD")) {
            this.addproofpos1 = 6;
        }
        if (this.addressproofType.equals("RSD")) {
            this.addproofpos1 = 7;
        }
        if (this.addressproofType.equals(OTHRS)) {
            this.addproofpos1 = 8;
        }
        String str = this.photoref;
        if (str == null || str.equals(StringUtils.SPACE) || this.photoref.equals("") || this.photoref.equals("null")) {
            this.binding.preview.setVisibility(8);
            this.binding.chooseFileName.setVisibility(8);
            this.binding.chooseFileNameSize.setVisibility(8);
            this.binding.chooseFileDeletion.setVisibility(8);
            this.binding.addProofSpinner.setSelection(0);
        } else {
            try {
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileName.setVisibility(0);
                this.binding.chooseFileNameSize.setVisibility(0);
                this.binding.chooseFileDeletion.setVisibility(0);
                this.binding.chooseFileName.setText(this.photoref);
                this.binding.chooseFileNameSize.setText("");
                this.binding.addProofSpinner.setSelection(this.addproofpos1);
                if (this.photoref.contains(".pdf")) {
                    this.binding.preview.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.blo_pfd_thumbnail));
                } else {
                    this.commonutils.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getFile(OBJECTSTORAGE, this.photoref, this.token, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass13());
                }
            } catch (Exception e) {
                Logger.e("", e.getMessage());
            }
        }
        this.binding.houseET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.streetET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.townVillage.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.postofficeSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.pincodeET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        this.binding.tehsilMandala.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        AnonymousClass13() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ShiftingOfResidenceOverseasFragment.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ShiftingOfResidenceOverseasFragment.this.base64element1.isEmpty() || ShiftingOfResidenceOverseasFragment.this.base64element1.equals("null")) {
                    return;
                }
                byte[] bArrDecode = Base64.decode(ShiftingOfResidenceOverseasFragment.this.base64element1, 0);
                ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                return;
            }
            if (response.code() == 401) {
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.getRefreshToken(ShiftingOfResidenceOverseasFragment.this.requireContext(), ShiftingOfResidenceOverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$13$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ShiftingOfResidenceOverseasFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.e("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ShiftingOfResidenceOverseasFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.showMessageOK(ShiftingOfResidenceOverseasFragment.this.requireContext(), ShiftingOfResidenceOverseasFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$13$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ShiftingOfResidenceOverseasFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setToken("Bearer " + str);
            Bundle bundle = new Bundle();
            bundle.putString("refNo", ShiftingOfResidenceOverseasFragment.this.referenceNo);
            bundle.putInt("formProcessingId", ShiftingOfResidenceOverseasFragment.this.formProcessingDetailsId);
            bundle.putInt("currentStatusid", ShiftingOfResidenceOverseasFragment.this.currentStatusId);
            bundle.putInt("processMasterId", ShiftingOfResidenceOverseasFragment.this.processMasterId);
            ShiftingOfResidenceOverseasFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.", bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setLocaleBool(false);
            ShiftingOfResidenceOverseasFragment.this.startActivity(new Intent((Context) ShiftingOfResidenceOverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ShiftingOfResidenceOverseasFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        this.alertDialog.show();
        if (isShftingDataOk()) {
            Toast.makeText(getContext(), "Data Updated Successfully ", 0).show();
            String string = this.binding.houseET.getText().toString();
            String string2 = this.binding.houseEteng.getText().toString();
            String string3 = this.binding.streetET.getText().toString();
            String string4 = this.binding.streetETeng.getText().toString();
            String string5 = this.binding.townVillage.getText().toString();
            String string6 = this.binding.townVillageeng.getText().toString();
            String string7 = this.binding.postofficeSpinner.getText().toString();
            String string8 = this.binding.postofficeSpinnereng.getText().toString();
            String string9 = this.binding.tehsilMandala.getText().toString();
            String string10 = this.binding.tehsilMandalaeng.getText().toString();
            String string11 = this.binding.pincodeET.getText().toString();
            String string12 = this.binding.addProofSpinner.getSelectedItem().toString();
            this.documentName1 = string12;
            if (string12.equals(WATER_ELECTRICITY_GAS_CONNECTION_BILL_FOR_THAT_ADDRESS_AT_LEAST_1_YEAR)) {
                this.documentCode = "WEGB";
            } else if (this.documentName1.equals(AADHAAR_CARD)) {
                this.documentCode = "ADHR";
            } else if (this.documentName1.equals(CURRENT_PASSBOOK_OF_NATIONALIZED_SCHEDULED_BANK_POST_OFFICE)) {
                this.documentCode = "CPNS";
            } else if (this.documentName1.equals(INDIAN_PASSPORT)) {
                this.documentCode = "IPSP";
            } else if (this.documentName1.equals(REVENUE_DEPARTMENT_S_LAND_OWNING_RECORDS_INCLUDING_KISAN_BAHI)) {
                this.documentCode = "RDLR";
            } else if (this.documentName1.equals(REGISTERED_RENT_LEASE_DEED_IN_CASE_OF_TENANT)) {
                this.documentCode = "RRLD";
            } else if (this.documentName1.equals(REGISTERED_SALE_DEED_IN_CASE_OF_OWN_HOUSE)) {
                this.documentCode = "RSD";
            } else if (this.documentName1.equals(BIRTH_CERTIFICATE_ISSUED_BY_COMPETENT_LOCAL_BODY_MUNICIPAL_AUTHORITY_REGISTRAR_OF_BIRTHS_DEATHS)) {
                this.documentCode = "BCMR";
            } else if (this.documentName1.equals(PAN_CARD)) {
                this.documentCode = "PC";
            } else if (this.documentName1.equals(DRIVING_LICENSE)) {
                this.documentCode = "DL";
            } else if (this.documentName1.equals(CERTIFICATES_OF_CLASS_X_OR_CLASS_XII_ISSUED_BY_CBSE_ICSE_STATE_EDUCATION_BOARDS_IF_IT_CONTAINS_DATE_OF_BIRTH)) {
                this.documentCode = "CCIS";
            } else if (this.documentName1.equals(OTHERS_PLEASE_SPECIFY)) {
                this.documentCode = OTHRS;
            }
            Bundle bundle = new Bundle();
            bundle.putString("Flag", "UPDATED");
            bundle.putString("houseNo", string);
            bundle.putString("houseNoL1", string2);
            bundle.putString("street", string3);
            bundle.putString("streetL1", string4);
            bundle.putString("village", string5);
            bundle.putString("villageL1", string6);
            bundle.putString("postoffice", string7);
            bundle.putString("postofficeL1", string8);
            bundle.putString("pincode", string11);
            bundle.putString("tehsil", string9);
            bundle.putString("tehsilL1", string10);
            bundle.putString("addressDoc", this.photoref);
            bundle.putString("typeOfDocAddress", this.documentCode);
            bundle.putString("anyOtherDocumentNameSOR", this.binding.OtherAddProof.getText().toString());
            bundle.putString("refNo", this.referenceNo);
            bundle.putInt("formProcessingId", this.formProcessingDetailsId);
            bundle.putInt("currentStatusid", this.currentStatusId);
            bundle.putInt("processMasterId", this.processMasterId);
            FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
            formsDetailsOverseasFragment.setArguments(bundle);
            openFragment(formsDetailsOverseasFragment, "FormDetailsOverseasFragment");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$4();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(View view) {
        if (this.binding.addProofSpinner.getSelectedItem().toString().equals(SELECT_ADDRESS_PROOF)) {
            showdialog("Alert", PLEASE_SELECT_A_DOCUMENT_TYPE);
        } else if (this.binding.addProofSpinner.getSelectedItem().toString().equals(OTHERS_PLEASE_SPECIFY) && this.binding.OtherAddProof.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Document Name");
        } else {
            selectImage1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        this.binding.chooseFileName.setText("");
        this.binding.chooseFileName.setVisibility(8);
        this.binding.preview.setVisibility(8);
        this.binding.preview.setImageDrawable(null);
        this.binding.chooseFileDeletion.setVisibility(8);
        this.binding.chooseFileNameSize.setVisibility(8);
        this.binding.chooseFile.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        this.alertDialog.show();
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW");
        bundle.putString("refNo", this.referenceNo);
        bundle.putInt("formProcessingId", this.formProcessingDetailsId);
        bundle.putInt("currentStatusid", this.currentStatusId);
        bundle.putInt("processMasterId", this.processMasterId);
        FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
        formsDetailsOverseasFragment.setArguments(bundle);
        openFragment(formsDetailsOverseasFragment, "FormsDetailsOverseasFragment");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$8();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8() {
        this.alertDialog.dismiss();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == 2131364213 && hasFocus) {
            if (this.binding.houseET.getText().toString().isEmpty()) {
                this.binding.houseEteng.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseET.getText().toString().trim(), this.binding.houseEteng, this.partLang, Constants.transliterationAddress);
                } catch (Exception e) {
                    Logger.e("", e.getMessage());
                }
            }
        }
        if (v.getId() == 2131366098 && hasFocus) {
            if (this.binding.streetET.getText().toString().isEmpty()) {
                this.binding.streetETeng.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetET.getText().toString().trim(), this.binding.streetETeng, this.partLang, Constants.transliterationAddress);
                } catch (Exception e2) {
                    Logger.e("", e2.getMessage());
                }
            }
        }
        if (v.getId() == 2131366486 && hasFocus) {
            if (this.binding.townVillage.getText().toString().isEmpty()) {
                this.binding.townVillageeng.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.townVillage.getText().toString().trim(), this.binding.townVillageeng, this.partLang, Constants.transliterationAddress);
                } catch (Exception e3) {
                    Logger.e("", e3.getMessage());
                }
            }
        }
        if (v.getId() == 2131365410 && hasFocus) {
            if (this.binding.postofficeSpinner.getText().toString().isEmpty()) {
                this.binding.postofficeSpinnereng.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeSpinner.getText().toString().trim(), this.binding.postofficeSpinnereng, this.partLang, Constants.transliterationAddress);
                } catch (Exception e4) {
                    Logger.e("", e4.getMessage());
                }
            }
        }
        if (v.getId() == 2131366232 && hasFocus) {
            if (this.binding.tehsilMandala.getText().toString().isEmpty()) {
                this.binding.tehsilMandalaeng.setText("");
                return;
            }
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.tehsilMandala.getText().toString().trim(), this.binding.tehsilMandalaeng, this.partLang, Constants.transliterationAddress);
            } catch (Exception e5) {
                Logger.e("", e5.getMessage());
            }
        }
    }

    private boolean isShftingDataOk() {
        this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.townVillageeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.postofficeSpinnereng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.tehsilMandalaeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        if (this.binding.houseET.getText().toString().isEmpty()) {
            this.binding.houseET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.houseET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.streetET.getText().toString().isEmpty()) {
            this.binding.streetET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.streetET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.townVillage.getText().toString().isEmpty()) {
            this.binding.townVillage.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.townVillage.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.postofficeSpinner.getText().toString().isEmpty()) {
            this.binding.postofficeSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.postofficeSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.pincodeET.getText().toString().isEmpty()) {
            this.binding.pincodeET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.pincodeET.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.tehsilMandala.getText().toString().isEmpty()) {
            this.binding.tehsilMandala.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.tehsilMandala.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.houseET.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter House/Building/Apartment No.");
            return false;
        }
        if (this.binding.streetET.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Street/Area/Locality/Mohalla/Road");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.streetETeng.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            showdialog("Alert", "Street(" + this.binding.streetETeng.getText().toString() + ") should be in regional language.");
            return false;
        }
        if (this.binding.townVillage.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Town/Village");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.townVillageeng.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.townVillageeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            showdialog("Alert", "Village(" + this.binding.townVillageeng.getText().toString() + ") should be in regional language.");
            return false;
        }
        if (this.binding.postofficeSpinner.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Post Office");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.postofficeSpinnereng.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.townVillageeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeSpinnereng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            showdialog("Alert", "Postoffice(" + this.binding.postofficeSpinnereng.getText().toString() + ") should be in regional language.");
            return false;
        }
        if (this.binding.pincodeET.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Pin Code");
            return false;
        }
        if (this.binding.pincodeET.getText().toString().length() != 6 || (this.binding.pincodeET.getText().toString().length() == 6 && !this.binding.pincodeET.getText().toString().matches("^[1-9]{1}[0-9]{5}$"))) {
            showdialog("Alert", "Please enter correct pincode");
            return false;
        }
        if (this.binding.tehsilMandala.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Tehsil/Taluqa/Mandal");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.tehsilMandalaeng.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.townVillageeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeSpinnereng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.tehsilMandalaeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            showdialog("Alert", "Tehsil(" + this.binding.tehsilMandalaeng.getText().toString() + ") should be in regional language.");
            return false;
        }
        if (this.binding.addProofSpinner.getSelectedItem().toString().equals(SELECT_ADDRESS_PROOF)) {
            this.binding.houseEteng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetETeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.townVillageeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeSpinnereng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.tehsilMandalaeng.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            showdialog("Alert", PLEASE_SELECT_A_DOCUMENT_TYPE);
            return false;
        }
        if (this.binding.addProofSpinner.getSelectedItem().toString().equals(OTHERS_PLEASE_SPECIFY) && this.binding.OtherAddProof.getText().toString().equals("")) {
            showdialog("Alert", "Please Enter Document Name");
            return false;
        }
        if (this.binding.preview.getDrawable() != null) {
            return true;
        }
        showdialog("Alert", "Please Attach Document");
        return false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() != 2131362223) {
            return;
        }
        if (position == 1) {
            this.addproofspinnercode = "WEGB";
        }
        if (position == 2) {
            this.addproofspinnercode = "ADHR";
        }
        if (position == 3) {
            this.addproofspinnercode = "CPNS";
        }
        if (position == 4) {
            this.addproofspinnercode = "IPSP";
        }
        if (position == 5) {
            this.addproofspinnercode = "RDLR";
        }
        if (position == 6) {
            this.addproofspinnercode = "RRLD";
        }
        if (position == 7) {
            this.addproofspinnercode = "RSD";
        }
        if (position == 8) {
            this.addproofspinnercode = OTHRS;
        }
        if (this.binding.addProofSpinner.getSelectedItem().equals(OTHERS_PLEASE_SPECIFY)) {
            this.binding.otherDocSorLl.setVisibility(0);
            this.binding.OtherAddProof.setHint("Type here");
        } else {
            if (this.binding.addProofSpinner.getSelectedItem().equals(OTHERS_PLEASE_SPECIFY)) {
                return;
            }
            this.binding.otherDocSorLl.setVisibility(8);
            this.binding.OtherAddProof.setText("");
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        Logger.d(ON_NOTHING_SELECTED, ON_NOTHING_SELECTED);
    }

    private void selectImage1() {
        final CharSequence[] charSequenceArr = {TAKE_PHOTO, CHOOSE_IMAGE_FROM_GALLERY, CHOOSE_PDF_FROM_GALLERY, CANCEL};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle(ADD_PHOTOGRAPH);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage1$10(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage1$10(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(TAKE_PHOTO)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals(CHOOSE_IMAGE_FROM_GALLERY)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(CHOOSE_PDF_FROM_GALLERY)) {
            openfile1();
        } else if (charSequenceArr[i].equals(CANCEL)) {
            dialogInterface.dismiss();
        }
    }

    public void openfile1() {
        String[] strArr = {APPLICATION_PDF};
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        this.activityResultLauncher1.launch(Intent.createChooser(intent, CHOOSE_FILE));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14, reason: invalid class name */
    class AnonymousClass14 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass14() {
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0095 A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00ac A[Catch: Exception -> 0x0241, TRY_LEAVE, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: Exception -> 0x0241, TRY_ENTER, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:39:0x012e A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0176 A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x022e A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0236 A[Catch: Exception -> 0x0241, TryCatch #5 {Exception -> 0x0241, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x022e, B:45:0x0236, B:46:0x0240), top: B:58:0x006d }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Exception e;
            Cursor cursorQuery;
            String string;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            ShiftingOfResidenceOverseasFragment.this.imageUri = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = ShiftingOfResidenceOverseasFragment.this.getContext().getContentResolver().openInputStream(ShiftingOfResidenceOverseasFragment.this.imageUri);
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
                    } catch (Exception e2) {
                        e = e2;
                        Logger.e("", e.getMessage());
                        ShiftingOfResidenceOverseasFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                        cursorQuery = ShiftingOfResidenceOverseasFragment.this.getContext().getContentResolver().query(ShiftingOfResidenceOverseasFragment.this.getSaveImagePath(Base64.encodeToString(ShiftingOfResidenceOverseasFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ShiftingOfResidenceOverseasFragment.CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ShiftingOfResidenceOverseasFragment.this.filesize < 1024) {
                                double dRound2 = Math.round(ShiftingOfResidenceOverseasFragment.this.filesize * 100.0d) / 100.0d;
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setText(string);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFile.setTextColor(Color.parseColor(ShiftingOfResidenceOverseasFragment.CRIMSON_RED));
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setText(dRound2 + "KB");
                                ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ShiftingOfResidenceOverseasFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.showdialog("Alert", ShiftingOfResidenceOverseasFragment.PDF_SIZE_EXCEEDED_3_MB_LIMIT);
                                } else {
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setText(string);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFile.setTextColor(Color.parseColor(ShiftingOfResidenceOverseasFragment.CRIMSON_RED));
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setText(dRound + "MB");
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ShiftingOfResidenceOverseasFragment.this.commonUtilClass.uploadToServer2(ShiftingOfResidenceOverseasFragment.this.getContext(), ShiftingOfResidenceOverseasFragment.this.stateCode, ShiftingOfResidenceOverseasFragment.this.asmblyNO, ShiftingOfResidenceOverseasFragment.this.partNo, ShiftingOfResidenceOverseasFragment.this.filepathimg, ShiftingOfResidenceOverseasFragment.this.saveImageFileName, ShiftingOfResidenceOverseasFragment.this.token, ShiftingOfResidenceOverseasFragment.this.referenceNo, SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14$$ExternalSyntheticLambda2
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ShiftingOfResidenceOverseasFragment.this.showdialog("", "Please Select the correct format of file");
                    }
                    ShiftingOfResidenceOverseasFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        cursorQuery = ShiftingOfResidenceOverseasFragment.this.getContext().getContentResolver().query(ShiftingOfResidenceOverseasFragment.this.getSaveImagePath(Base64.encodeToString(ShiftingOfResidenceOverseasFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ShiftingOfResidenceOverseasFragment.CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ShiftingOfResidenceOverseasFragment.this.filesize < 1024) {
                                double dRound3 = Math.round(ShiftingOfResidenceOverseasFragment.this.filesize * 100.0d) / 100.0d;
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(0);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setText(string);
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFile.setTextColor(Color.parseColor(ShiftingOfResidenceOverseasFragment.CRIMSON_RED));
                                ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setText(dRound3 + "KB");
                                ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ShiftingOfResidenceOverseasFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(8);
                                    ShiftingOfResidenceOverseasFragment.this.showdialog("Alert", ShiftingOfResidenceOverseasFragment.PDF_SIZE_EXCEEDED_3_MB_LIMIT);
                                } else {
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileDeletion.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setVisibility(0);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileName.setText(string);
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFile.setTextColor(Color.parseColor(ShiftingOfResidenceOverseasFragment.CRIMSON_RED));
                                    ShiftingOfResidenceOverseasFragment.this.binding.chooseFileNameSize.setText(dRound + "MB");
                                    ShiftingOfResidenceOverseasFragment.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ShiftingOfResidenceOverseasFragment.this.commonUtilClass.uploadToServer2(ShiftingOfResidenceOverseasFragment.this.getContext(), ShiftingOfResidenceOverseasFragment.this.stateCode, ShiftingOfResidenceOverseasFragment.this.asmblyNO, ShiftingOfResidenceOverseasFragment.this.partNo, ShiftingOfResidenceOverseasFragment.this.filepathimg, ShiftingOfResidenceOverseasFragment.this.saveImageFileName, ShiftingOfResidenceOverseasFragment.this.token, ShiftingOfResidenceOverseasFragment.this.referenceNo, SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14$$ExternalSyntheticLambda2
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ShiftingOfResidenceOverseasFragment.this.showdialog("", "Please Select the correct format of file");
                    } catch (Exception e3) {
                        Logger.d(ShiftingOfResidenceOverseasFragment.CONTENT, e3.getMessage());
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th4;
                }
            } catch (Exception e4) {
                byteArrayOutputStream = byteArrayOutputStream2;
                e = e4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$3(int i, String str) {
            if (i == 401) {
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.getRefreshToken(ShiftingOfResidenceOverseasFragment.this.getContext(), ShiftingOfResidenceOverseasFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$2(i2, str2, str3);
                    }
                });
            } else {
                ShiftingOfResidenceOverseasFragment.this.photoref = str;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(int i, String str, String str2) {
            ShiftingOfResidenceOverseasFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                ShiftingOfResidenceOverseasFragment.this.commonUtilClass.showMessageOK(ShiftingOfResidenceOverseasFragment.this.requireContext(), ShiftingOfResidenceOverseasFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ShiftingOfResidenceOverseasFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setToken("Bearer " + str);
            ShiftingOfResidenceOverseasFragment.this.commonUtilClass.uploadToServer2(ShiftingOfResidenceOverseasFragment.this.getContext(), ShiftingOfResidenceOverseasFragment.this.stateCode, ShiftingOfResidenceOverseasFragment.this.asmblyNO, ShiftingOfResidenceOverseasFragment.this.partNo, ShiftingOfResidenceOverseasFragment.this.filepathimg, ShiftingOfResidenceOverseasFragment.this.saveImageFileName, ShiftingOfResidenceOverseasFragment.this.token, ShiftingOfResidenceOverseasFragment.this.referenceNo, SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$14$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onActivityResult$1(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ShiftingOfResidenceOverseasFragment.this.requireContext()).setLocaleBool(false);
            ShiftingOfResidenceOverseasFragment.this.startActivity(new Intent((Context) ShiftingOfResidenceOverseasFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1(int i, String str) {
            ShiftingOfResidenceOverseasFragment.this.photoref = str;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.e("", e.getMessage());
            }
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), IMAGE), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                }
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (this.filesize < 1024) {
                    this.binding.chooseFileName.setVisibility(0);
                    this.binding.chooseFileNameSize.setVisibility(0);
                    this.binding.chooseFileDeletion.setVisibility(0);
                    this.binding.preview.setVisibility(0);
                    this.binding.chooseFileName.setText(string);
                    this.binding.chooseFile.setTextColor(Color.parseColor(CRIMSON_RED));
                    this.binding.chooseFileNameSize.setText(this.filesize + "KB");
                    ImageView imageView = this.binding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } else {
                    double dRound = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.binding.preview.setVisibility(8);
                        this.binding.chooseFileDeletion.setVisibility(8);
                        this.binding.chooseFileNameSize.setVisibility(8);
                        this.binding.chooseFileName.setVisibility(8);
                        showdialog("Alert", IMAGE_SIZE_EXCEEDED_2_MB_LIMIT);
                    } else {
                        this.binding.chooseFileName.setVisibility(0);
                        this.binding.chooseFileNameSize.setVisibility(0);
                        this.binding.chooseFileDeletion.setVisibility(0);
                        this.binding.preview.setVisibility(0);
                        this.binding.chooseFileName.setText(string);
                        this.binding.chooseFile.setTextColor(Color.parseColor(CRIMSON_RED));
                        this.binding.chooseFileNameSize.setText(dRound + "MB");
                        ImageView imageView2 = this.binding.preview;
                        byte[] bArr2 = this.byteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    }
                }
                this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda9
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onActivityResult$14(i, str);
                    }
                });
                this.alertDialog.dismiss();
            } catch (Exception e2) {
                Logger.d(CONTENT, e2.getMessage());
            }
        } else {
            this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$14(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda13
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$13(i2, str2, str3);
                }
            });
        } else {
            this.photoref = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$13(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$11(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda8
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onActivityResult$12(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$11(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$12(int i, String str) {
        this.photoref = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg, final Bundle bundleList1) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.ShiftingOfResidenceOverseasFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$16(bundleList1, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$16(Bundle bundle, DialogInterface dialogInterface, int i) {
        FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
        formsDetailsOverseasFragment.setArguments(bundle);
        openFragment(formsDetailsOverseasFragment, "FormDetailsOverseasFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
