package in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
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
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentAadhaarAuthenticationBinding;
import in.gov.eci.bloapp.model.app_model.FormsinDraftModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel;
import in.gov.eci.bloapp.views.ArraylistReturn1;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AadhaarAuthenticationFormFragment extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String aadhaarText;
    String acName;
    String acNoText;
    ActivityResultLauncher<Intent> activityResultLauncher;
    AlertDialog alertDialog;
    String alertText;
    ArrayAdapter<String> alternateIdAdapter;
    String apiIdNum;
    String apiImage;
    String applicantLastNameText;
    String applicationPdfText;
    String asmblyNO;
    String asmblyName;
    String assemblyNo;
    String[] authDetails;
    String bearerText;
    BloFragmentAadhaarAuthenticationBinding binding;
    String bloAppText;
    String blueColourTag;
    Retrofit.Builder builder;
    byte[] byteArray;
    String cameraText;
    String cancelText;
    String channelidobo;
    String createdOn;
    String currentRole;
    Date date;
    DateFormat dateFormat;
    DateFormat dateFormat1;
    String districtCdText;
    String districtCode;
    String districtName;
    String districtName1;
    ArrayList<String> document;
    String emailId;
    String emailIdText;
    String emptyCursorText;
    String epicId;
    String errorText;
    String fileName;
    String firstName;
    String form;
    String form6BText;
    String formText;
    FusedLocationProviderClient fusedLocationProviderClient;
    String getRefreshTokenText;
    String grayColourTag;
    String idNumber;
    int idPos;
    String idType;
    String imageText;
    String insideCameraText;
    String isAdhar;
    String kbText;
    String langName;
    String lastName;
    String layoutSelected;
    String layoutVisited;
    LayoutInflater layoutinflater;
    LocationRequest locationRequest;
    String logTag;
    String mbText;
    String messageText;
    String mobileNo;
    String msg;
    String nullText;
    String okText;
    String[] otherDetails;
    String partLang;
    String partName;
    String partNo;
    String partNumberText;
    String password;
    String pdfText;
    String[] personaldetails;
    String proofDocumentTypeText;
    String proofOfDoc;
    String redColourTag;
    String refIdText;
    String referenceLinkSor;
    String referenceNumber;
    String refreshToken;
    Retrofit retrofit;
    SimpleDateFormat sdf;
    String selectAadharText;
    String selectAlternateIdText;
    String selectCorrectAadharText;
    String selectDocumentText;
    String selectIdText;
    String selectedType;
    String sessionExpiredText;
    String sessionExpiredTextForRefresh;
    String stateCd;
    String stateCdText;
    String stateCode;
    String stateName;
    String stateName1;
    String[] statedetails;
    String successUploadedText;
    String takePdfTextFromGallery;
    String takePhotoText;
    String takePhotoTextFromGallery;
    String textForA;
    String textForB;
    String totalPartNumber;
    String town;
    String trueText;
    String trxDate;
    String uploadAgainTextForRefresh;
    String uploadDocumentText;
    String userName;
    AadharAuthViewModel viewModel;
    String voterIdNumber;
    String voterIdText;
    CommomUtility commonUtilClass = new CommomUtility();
    String delimeter = "‡";
    JsonObject payLoad = null;
    JsonObject refNum = null;
    HashMap<String, Object> submitMap = new HashMap<>();
    String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public AadhaarAuthenticationFormFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.date = new Date();
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        this.logTag = "AadharAuthentication";
        this.form = " ";
        this.formText = "form";
        this.voterIdText = "voterId";
        this.form6BText = "Form 6B";
        this.currentRole = "blo";
        this.bloAppText = "BLOAPP";
        this.applicantLastNameText = "applicantLastName";
        this.emailIdText = Constants.EMAIL_ID;
        this.stateCdText = "stateCd";
        this.nullText = "null";
        this.okText = "Ok";
        this.alertText = "Alert";
        this.sessionExpiredText = "Session Expired. Please Login again..";
        this.sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
        this.uploadAgainTextForRefresh = "Page refreshed due to the token expiry, Please upload again.";
        this.refIdText = "refId";
        this.messageText = "message";
        this.errorText = "Error";
        this.aadhaarText = "Aadhaar";
        this.pdfText = ".pdf";
        this.textForA = "A";
        this.textForB = "B";
        this.selectIdText = "Please Select Id";
        this.selectAadharText = "Please enter Aadhar number";
        this.trueText = "true";
        this.selectCorrectAadharText = "Please Enter Correct Aadhaar Number";
        this.emptyCursorText = "Can't obtain file name, cursor is empty";
        this.kbText = "KB";
        this.mbText = "MB";
        this.takePhotoText = "Take Photo";
        this.takePhotoTextFromGallery = "Choose Image from Gallery";
        this.takePdfTextFromGallery = "Choose PDF from Gallery";
        this.cancelText = "Cancel";
        this.applicationPdfText = "application/pdf";
        this.acNoText = "acNo";
        this.successUploadedText = "Success_Uploaded";
        this.selectAlternateIdText = "Please Select Alternate Id";
        this.selectDocumentText = "Select Document";
        this.uploadDocumentText = "Please Upload Document";
        this.districtCdText = "districtCd";
        this.proofDocumentTypeText = "proofDocumentType";
        this.blueColourTag = "#1C77FF";
        this.redColourTag = "#DE000000";
        this.grayColourTag = "#D9D9D9";
        this.partNumberText = "partNumber";
        this.cameraText = "Camera ";
        this.insideCameraText = "inside camera";
        this.imageText = "image";
        this.bearerText = "Bearer ";
        this.getRefreshTokenText = "getRefreshToken : ";
        this.channelidobo = "BLOAPP";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda37
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$25((ActivityResult) obj);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentAadhaarAuthenticationBinding.inflate(getLayoutInflater());
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.layoutinflater = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.viewModel = (AadharAuthViewModel) new ViewModelProvider(requireActivity()).get(AadharAuthViewModel.class);
        this.createdOn = this.sdf.format(this.date);
        this.trxDate = this.dateFormat.format(Calendar.getInstance().getTime());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.userName = SharedPref.getInstance(requireContext()).getUserName();
        this.password = SharedPref.getInstance(requireContext()).getPassword();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.partName = SharedPref.getInstance(requireContext()).getPartName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(this.logTag, "token -- > " + this.token);
        Logger.d(this.logTag, "stateCode -- > " + this.stateCode);
        Logger.d(this.logTag, "districtCode -- > " + this.districtCode);
        Logger.d(this.logTag, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(this.logTag, "totalPartNumber -- > " + this.totalPartNumber);
        Logger.d(this.logTag, "stateName -- > " + this.stateName);
        Logger.d(this.logTag, "districtName -- > " + this.districtName);
        Logger.d(this.logTag, "asmblyName -- > " + this.asmblyName);
        Logger.d(this.logTag, "partName -- > " + this.partName);
        Logger.d(this.logTag, "langName -- > " + this.langName);
        Logger.d(this.logTag, "partLang -- > " + this.partLang);
        Logger.d(this.logTag, "partNo -- > " + this.partNo);
        Logger.d(this.logTag, "refreshToken -- > " + this.refreshToken);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        Bundle arguments = getArguments();
        String string = arguments.getString(this.formText);
        this.form = string;
        if (arguments != null && string.equals("Voter Forms")) {
            this.voterIdNumber = arguments.getString(this.voterIdText);
            this.stateName1 = arguments.getString("stateNameForForm6B");
            this.districtName1 = arguments.getString("districtNameForForm6B");
            this.acName = arguments.getString("acNameForForm6B");
            this.assemblyNo = arguments.getString("assemblyNoForForm6B");
            this.firstName = arguments.getString("firstNameForForm6B");
            this.lastName = arguments.getString("lastNameForForm6B");
            this.epicId = arguments.getString(this.voterIdText);
            this.mobileNo = arguments.getString("mobileNoForForm6B");
            this.emailId = arguments.getString("emailIdForForm6B");
            this.stateCd = arguments.getString("stateCdForForm6B");
            if (isNetworkAvailable(requireContext())) {
                this.alertDialog.show();
                getVoterData();
            } else {
                Toast.makeText(requireContext(), "Please check network", 1).show();
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && !this.form.equals("Voter Forms")) {
            dataoneditbutton(arguments2.getString("name"), arguments2.getString("date"), this.form6BText);
            this.binding.dateEt.setText(this.trxDate);
        }
        this.binding.selectState.setVisibility(0);
        this.layoutSelected = "1";
        this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        this.binding.personalDetail.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.finalPreview.setVisibility(8);
        this.binding.otherDetails.setVisibility(8);
        this.binding.delete.setVisibility(8);
        this.binding.linearLayout9.setVisibility(8);
        this.binding.linearLayout4.setVisibility(8);
        this.binding.uploadDoc.setVisibility(8);
        this.binding.alternateIdDropDown.setEnabled(false);
        this.binding.typeAadhaarNo.setEnabled(false);
        this.binding.authInfoLayout.setEnabled(false);
        this.binding.otherDetailsLayout.setEnabled(false);
        initClickListener();
        saveData();
        return this.binding.getRoot();
    }

    private void getVoterData() {
        this.binding.stateDropDown.setText(this.stateName);
        this.binding.districtDropDown.setText(this.districtName);
        this.binding.assemblyNo.setText(this.asmblyNO);
        this.binding.acDropDown.setText(this.asmblyName);
        this.binding.parliamentNo.setText(this.asmblyNO);
        this.binding.pcDropDown.setText(this.asmblyName);
        this.binding.typeName.setText(this.firstName);
        if (this.lastName.equals(this.nullText)) {
            this.binding.typeSurname.setText(" ");
        } else {
            this.binding.typeSurname.setText(this.lastName);
        }
        this.binding.typeEpicNumber.setText(this.epicId);
        Logger.d(this.logTag, "Mobile No : " + this.mobileNo);
        if (this.mobileNo.equals(this.nullText) && this.mobileNo != null) {
            this.binding.mobileNumberEt.setText("");
        } else if (this.mobileNo.startsWith("+91-")) {
            this.mobileNo = this.mobileNo.substring(4);
            this.binding.mobileNumberEt.setText(this.mobileNo);
        } else if (this.mobileNo.startsWith("+91")) {
            this.mobileNo = this.mobileNo.substring(3);
            this.binding.mobileNumberEt.setText(this.mobileNo);
        } else {
            this.mobileNo = null;
            this.binding.mobileNumberEt.setText("");
        }
        if (this.emailId.equals(this.nullText)) {
            this.binding.emailIdEt.setText("");
        } else {
            this.binding.emailIdEt.setText(this.emailId);
        }
        getRefNum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRefNum() {
        Logger.d(this.logTag, "inside getRefNum");
        UserClient retrofitClient = this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd());
        int i = Integer.parseInt(this.asmblyNO);
        String str = this.stateCode;
        retrofitClient.eroRefNum(i, str, "G", "6B", this.currentRole, str).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                AadhaarAuthenticationFormFragment.this.refNum = (JsonObject) response.body();
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "Reference Id" + AadhaarAuthenticationFormFragment.this.refNum.get(AadhaarAuthenticationFormFragment.this.refIdText));
                AadhaarAuthenticationFormFragment aadhaarAuthenticationFormFragment = AadhaarAuthenticationFormFragment.this;
                aadhaarAuthenticationFormFragment.referenceNumber = String.valueOf(aadhaarAuthenticationFormFragment.refNum.get(AadhaarAuthenticationFormFragment.this.refIdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                AadhaarAuthenticationFormFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.getRefreshToken(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            AadhaarAuthenticationFormFragment.this.alertDialog.dismiss();
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In getRefNum() -> else part ----> Response Body is null");
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, String.valueOf(jSONObject));
                String strOptString = jSONObject.optString("status");
                String strOptString2 = jSONObject.optString(AadhaarAuthenticationFormFragment.this.messageText);
                if (!Objects.equals(strOptString2, null) && strOptString2.isEmpty()) {
                    String strOptString3 = jSONObject.optString("error");
                    AadhaarAuthenticationFormFragment aadhaarAuthenticationFormFragment2 = AadhaarAuthenticationFormFragment.this;
                    aadhaarAuthenticationFormFragment2.showDialog1(aadhaarAuthenticationFormFragment2.errorText, strOptString + " - " + strOptString3);
                    Log.d(AadhaarAuthenticationFormFragment.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse2 : " + strOptString3);
                } else {
                    Log.d(AadhaarAuthenticationFormFragment.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString2);
                    AadhaarAuthenticationFormFragment aadhaarAuthenticationFormFragment3 = AadhaarAuthenticationFormFragment.this;
                    aadhaarAuthenticationFormFragment3.showDialog1(aadhaarAuthenticationFormFragment3.errorText, strOptString + " - " + strOptString2);
                }
            } catch (Exception e) {
                AadhaarAuthenticationFormFragment.this.alertDialog.dismiss();
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, AadhaarAuthenticationFormFragment.this.getRefreshTokenText + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.showMessageOK(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AadhaarAuthenticationFormFragment.this.token = AadhaarAuthenticationFormFragment.this.bearerText + str;
            AadhaarAuthenticationFormFragment.this.refreshToken = str2;
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setToken(AadhaarAuthenticationFormFragment.this.bearerText + str);
            AadhaarAuthenticationFormFragment.this.getRefNum();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setLocaleBool(false);
            AadhaarAuthenticationFormFragment.this.startActivity(new Intent(AadhaarAuthenticationFormFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            AadhaarAuthenticationFormFragment.this.alertDialog.dismiss();
        }
    }

    private void dataoneditbutton(String name, String date, String formType) {
        this.viewModel.dataoneditbutton(name, date, formType).observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda24
            public final void onChanged(Object obj) {
                this.f$0.lambda$dataoneditbutton$0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dataoneditbutton$0(List list) {
        if (list.isEmpty()) {
            return;
        }
        String state = ((FormsinDraftModel) list.get(0)).getState();
        String personal = ((FormsinDraftModel) list.get(0)).getPersonal();
        String authentication = ((FormsinDraftModel) list.get(0)).getAuthentication();
        String otherDetail = ((FormsinDraftModel) list.get(0)).getOtherDetail();
        int i = Integer.parseInt(((FormsinDraftModel) list.get(0)).getStepseq());
        this.referenceNumber = ((FormsinDraftModel) list.get(0)).getReference();
        byte[] photo = ((FormsinDraftModel) list.get(0)).getPhoto();
        this.byteArray = photo;
        edit(state, personal, authentication, otherDetail, i, photo);
        this.alertDialog.dismiss();
    }

    private void edit(final String stateData, final String personalData, final String authData, final String otherData, final int stepSeq, final byte[] img) {
        Logger.d(this.logTag, "stateData ---> " + stateData + "\npersonalData ---> " + personalData + "\nauthData ---> " + authData + "\notherData ---> " + otherData + "\nstepSeq ---> " + stepSeq + "\nimg ---> " + Arrays.toString(img));
        if (stepSeq == 2) {
            this.layoutSelected = "3";
            this.layoutVisited = "";
            this.statedetails = stateData.split(this.delimeter);
            this.binding.stateDropDown.setText(this.statedetails[0]);
            this.binding.districtDropDown.setText(this.statedetails[1]);
            this.binding.assemblyNo.setText(this.statedetails[2]);
            this.binding.parliamentNo.setText(this.statedetails[2]);
            this.binding.acDropDown.setText(this.statedetails[3]);
            this.binding.pcDropDown.setText(this.statedetails[3]);
            this.personaldetails = personalData.split(this.delimeter);
            this.binding.typeName.setText(this.personaldetails[0]);
            this.binding.typeSurname.setText(this.personaldetails[1]);
            this.binding.typeEpicNumber.setText(this.personaldetails[2]);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            this.binding.previousTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.personalDetail.setVisibility(8);
            this.binding.finalPreview.setVisibility(8);
            this.binding.selectState.setVisibility(8);
            this.binding.otherDetails.setVisibility(8);
            this.binding.authInfo.setVisibility(0);
            this.binding.previousTv.setEnabled(true);
            this.binding.saveNextTv.setEnabled(true);
            this.binding.resetTv.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.authInfoLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.otherDetailsLayout.setEnabled(true);
            this.binding.delete.setVisibility(8);
            this.binding.linearLayout9.setVisibility(8);
            this.binding.preview.setImageResource(android.R.color.transparent);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1200, this.binding.horizontal.getScrollY());
            return;
        }
        if (stepSeq == 3) {
            this.layoutSelected = "4";
            if (this.binding.placeEt.getText().toString().isEmpty()) {
                this.layoutVisited = "";
            } else {
                this.layoutVisited = "1";
            }
            this.statedetails = stateData.split(this.delimeter);
            this.binding.stateDropDown.setText(this.statedetails[0]);
            this.binding.districtDropDown.setText(this.statedetails[1]);
            this.binding.assemblyNo.setText(this.statedetails[2]);
            this.binding.parliamentNo.setText(this.statedetails[2]);
            this.binding.acDropDown.setText(this.statedetails[3]);
            this.binding.pcDropDown.setText(this.statedetails[3]);
            this.personaldetails = personalData.split(this.delimeter);
            this.binding.typeName.setText(this.personaldetails[0]);
            this.binding.typeSurname.setText(this.personaldetails[1]);
            this.binding.typeEpicNumber.setText(this.personaldetails[2]);
            String[] strArrSplit = authData.split(this.delimeter);
            this.authDetails = strArrSplit;
            if (strArrSplit[0].equals(this.aadhaarText)) {
                this.binding.aadhaarNumber.setChecked(true);
                this.idNumber = this.authDetails[1];
                this.commonUtilClass.getaadharref(getContext(), this.stateCode, this.token, this.authDetails[1], SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "AadhaarAuthentication", new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$edit$3(stateData, personalData, authData, otherData, stepSeq, img, i, str, str2);
                    }
                });
                this.binding.delete.setVisibility(8);
                this.binding.linearLayout9.setVisibility(8);
                this.binding.preview.setImageResource(android.R.color.transparent);
                this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            } else {
                this.binding.alternateId.setChecked(true);
                this.commonUtilClass.getDocument(getContext(), this.stateCode, this.token, new ArraylistReturn1() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.views.ArraylistReturn1
                    public final void onCallback(ArrayList arrayList) {
                        this.f$0.lambda$edit$4(arrayList);
                    }
                });
                this.binding.fileName.setText(this.authDetails[2]);
                this.fileName = this.authDetails[2];
                this.binding.fileSize.setText(this.authDetails[3]);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(img, 0, img.length);
                this.binding.preview.setVisibility(0);
                if (this.authDetails[2].contains(this.pdfText)) {
                    this.binding.imgPreview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                } else {
                    this.binding.imgPreview.setImageBitmap(bitmapDecodeByteArray);
                    this.binding.preview.setImageBitmap(bitmapDecodeByteArray);
                }
                this.binding.delete.setVisibility(0);
                this.binding.linearLayout9.setVisibility(0);
                this.binding.chooseFile.setEnabled(true);
                this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            }
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            this.binding.previousTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.previousTv.setEnabled(true);
            this.binding.saveNextTv.setEnabled(true);
            this.binding.resetTv.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.otherDetailsLayout.setEnabled(true);
            this.binding.authInfoLayout.setEnabled(true);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authInfo.setVisibility(8);
            this.binding.selectState.setVisibility(8);
            this.binding.finalPreview.setVisibility(8);
            this.binding.otherDetails.setVisibility(0);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1200, this.binding.horizontal.getScrollY());
            return;
        }
        if (stepSeq == 4) {
            this.layoutSelected = "4";
            this.statedetails = stateData.split(this.delimeter);
            this.binding.stateDropDown.setText(this.statedetails[0]);
            this.binding.districtDropDown.setText(this.statedetails[1]);
            this.binding.assemblyNo.setText(this.statedetails[2]);
            this.binding.parliamentNo.setText(this.statedetails[2]);
            this.binding.acDropDown.setText(this.statedetails[3]);
            this.binding.pcDropDown.setText(this.statedetails[3]);
            this.personaldetails = personalData.split(this.delimeter);
            this.binding.typeName.setText(this.personaldetails[0]);
            this.binding.typeSurname.setText(this.personaldetails[1]);
            this.binding.typeEpicNumber.setText(this.personaldetails[2]);
            String[] strArrSplit2 = authData.split(this.delimeter);
            this.authDetails = strArrSplit2;
            if (strArrSplit2[0].equals(this.aadhaarText)) {
                this.binding.aadhaarNumber.setChecked(true);
                this.idNumber = this.authDetails[1];
                this.commonUtilClass.getaadhar(getContext(), this.stateCode, this.token, this.authDetails[1], SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "AadharAuthentication", new MultipleString() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.MultipleString
                    public final void onCallBack(String str, String str2) {
                        this.f$0.lambda$edit$5(str, str2);
                    }
                });
                this.binding.delete.setVisibility(8);
                this.binding.linearLayout9.setVisibility(8);
                this.binding.preview.setImageResource(android.R.color.transparent);
                this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            } else {
                this.binding.alternateId.setChecked(true);
                this.commonUtilClass.getDocument(getContext(), this.stateCode, this.token, new ArraylistReturn1() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda5
                    @Override // in.gov.eci.bloapp.views.ArraylistReturn1
                    public final void onCallback(ArrayList arrayList) {
                        this.f$0.lambda$edit$6(arrayList);
                    }
                });
                this.binding.fileName.setText(this.authDetails[2]);
                this.fileName = this.authDetails[2];
                this.binding.fileSize.setText(this.authDetails[3]);
                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(img, 0, img.length);
                this.binding.preview.setVisibility(0);
                if (this.authDetails[2].contains(this.pdfText)) {
                    this.binding.imgPreview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                } else {
                    this.binding.imgPreview.setImageBitmap(bitmapDecodeByteArray2);
                    this.binding.preview.setImageBitmap(bitmapDecodeByteArray2);
                }
                this.binding.delete.setVisibility(0);
                this.binding.linearLayout9.setVisibility(0);
                this.binding.chooseFile.setEnabled(true);
                this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            }
            this.otherDetails = otherData.split(this.delimeter);
            this.binding.emailIdEt.setText(this.otherDetails[0]);
            this.binding.mobileNumberEt.setText(this.otherDetails[1]);
            this.binding.placeEt.setText(this.otherDetails[2]);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            this.binding.previousTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.previousTv.setEnabled(true);
            this.binding.saveNextTv.setEnabled(true);
            this.binding.resetTv.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.otherDetailsLayout.setEnabled(true);
            this.binding.authInfoLayout.setEnabled(true);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authInfo.setVisibility(8);
            this.binding.selectState.setVisibility(8);
            this.binding.finalPreview.setVisibility(8);
            this.binding.otherDetails.setVisibility(0);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1200, this.binding.horizontal.getScrollY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$2(String str, String str2, String str3, String str4, int i, byte[] bArr, int i2, String str5, String str6) {
        Logger.d(this.logTag, this.getRefreshTokenText + i2 + " " + str5 + " " + str6);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$1(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = this.bearerText + str5;
        this.refreshToken = str6;
        SharedPref.getInstance(getContext()).setRefreshToken(str6);
        SharedPref.getInstance(getContext()).setToken(this.bearerText + str5);
        edit(str, str2, str3, str4, i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$1(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getContext()).setLocaleBool(false);
        startActivity(new Intent(getContext(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$3(final String str, final String str2, final String str3, final String str4, final int i, final byte[] bArr, int i2, String str5, String str6) {
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda23
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str7, String str8) {
                    this.f$0.lambda$edit$2(str, str2, str3, str4, i, bArr, i3, str7, str8);
                }
            });
            return;
        }
        if (str5.equals("n") || str5.equals("N")) {
            showDialog(str6);
        } else if (str5.equals("y") || str5.equals("Y")) {
            this.binding.typeAadhaarNo.setText(str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$4(ArrayList arrayList) {
        this.document = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.document);
        this.alternateIdAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.alternateIdDropDown.setAdapter((SpinnerAdapter) this.alternateIdAdapter);
        this.binding.alternateIdDropDown.setSelection(Integer.parseInt(this.authDetails[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$5(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            showDialog(str2);
        } else if (str.equals("y") || str.equals("Y")) {
            this.binding.typeAadhaarNo.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$6(ArrayList arrayList) {
        this.document = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.document);
        this.alternateIdAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.alternateIdDropDown.setAdapter((SpinnerAdapter) this.alternateIdAdapter);
        this.binding.alternateIdDropDown.setSelection(Integer.parseInt(this.authDetails[1]));
    }

    private void saveData() {
        this.binding.typeEpicNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        this.document = new ArrayList<>();
        this.commonUtilClass.getDocument(getContext(), this.stateCode, this.token, new ArraylistReturn1() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda19
            @Override // in.gov.eci.bloapp.views.ArraylistReturn1
            public final void onCallback(ArrayList arrayList) {
                this.f$0.lambda$saveData$7(arrayList);
            }
        });
        this.binding.alternateIdDropDown.setOnItemSelectedListener(this);
        this.binding.aadhaarGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda20
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$saveData$8(radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$7(ArrayList arrayList) {
        this.document = arrayList;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.document);
        this.alternateIdAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.alternateIdDropDown.setAdapter((SpinnerAdapter) this.alternateIdAdapter);
        this.binding.alternateIdDropDown.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$8(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.aadhaarGrp.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131362056) {
            this.binding.typeAadhaarNo.setEnabled(true);
            this.binding.alternateId.setChecked(false);
            this.binding.alternateIdDropDown.setEnabled(false);
            this.binding.alternateIdDropDown.setSelection(0);
            this.binding.linearLayout4.setVisibility(8);
            this.binding.uploadDoc.setVisibility(8);
            this.binding.linearLayout9.setVisibility(8);
            this.binding.preview.setImageResource(0);
            this.binding.fileName.setText("");
            this.binding.fileSize.setText("");
            this.selectedType = this.textForA;
            return;
        }
        if (checkedRadioButtonId == 2131362340) {
            this.binding.aadhaarNumber.setChecked(false);
            this.binding.typeAadhaarNo.setText("");
            this.binding.typeAadhaarNo.setEnabled(false);
            this.binding.alternateIdDropDown.setEnabled(true);
            this.binding.chooseFile.setEnabled(true);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
            this.binding.linearLayout4.setVisibility(0);
            this.binding.uploadDoc.setVisibility(0);
            this.selectedType = this.textForB;
        }
    }

    private void initClickListener() {
        homeBtnClick();
        backBtnClick();
        selectStateLayoutClick();
        personalDetailLayoutClick();
        authInfoLayoutClick();
        otherDetailsLayoutClick();
        previousTvClick();
        saveNextTvClick();
        resetTvClick();
        chooseFileClick();
        deleteClick();
    }

    public void homeBtnClick() {
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$homeBtnClick$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$homeBtnClick$9(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$backBtnClick$10(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    public void backBtnClick() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$backBtnClick$10(view);
            }
        });
    }

    public void selectStateLayoutClick() {
        this.binding.selectStateLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectStateLayoutClick$11(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectStateLayoutClick$11(View view) {
        this.binding.selectState.setVisibility(0);
        this.layoutSelected = "1";
        this.binding.finalPreview.setVisibility(8);
        this.binding.personalDetail.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.otherDetails.setVisibility(8);
        this.binding.resetTv.setEnabled(false);
        this.binding.resetTv.setTextColor(Color.parseColor(this.grayColourTag));
        this.binding.previousTv.setEnabled(false);
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_line));
        this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
    }

    public void personalDetailLayoutClick() {
        this.binding.personalDetailLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$personalDetailLayoutClick$12(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$personalDetailLayoutClick$12(View view) {
        stateCheck();
        this.binding.authInfoLayout.setEnabled(true);
    }

    public void authInfoLayoutClick() {
        this.binding.authInfoLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$authInfoLayoutClick$13(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$authInfoLayoutClick$13(View view) {
        detailCheck();
        this.binding.otherDetailsLayout.setEnabled(true);
    }

    public void otherDetailsLayoutClick() {
        this.binding.otherDetailsLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$otherDetailsLayoutClick$14(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$otherDetailsLayoutClick$14(View view) {
        if (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1) {
            showDialog(this.selectIdText);
        } else if (this.selectedType.equals(this.textForA)) {
            if (this.binding.typeAadhaarNo.getText().toString().isEmpty() && this.binding.aadhaarNumber.isChecked()) {
                showDialog(this.selectAadharText);
            } else if (String.valueOf(Verhoeff.validateVerhoeff(this.binding.typeAadhaarNo.getText().toString())).equals(this.trueText)) {
                storeAadhaarRef();
            } else {
                showDialog(this.selectCorrectAadharText);
            }
        } else if (this.selectedType.equals(this.textForB)) {
            alternateId();
        }
        getCurrentLocation();
    }

    public void previousTvClick() {
        this.binding.previousTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$previousTvClick$15(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previousTvClick$15(View view) {
        if (this.layoutSelected.equals("2")) {
            this.binding.selectState.setVisibility(0);
            this.layoutSelected = "1";
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 200, this.binding.horizontal.getScrollY());
            this.binding.personalDetail.setVisibility(8);
            this.binding.authInfo.setVisibility(8);
            this.binding.otherDetails.setVisibility(8);
            this.binding.previousTv.setEnabled(false);
            this.binding.resetTv.setEnabled(false);
            this.binding.resetTv.setTextColor(Color.parseColor(this.grayColourTag));
            this.binding.saveNextTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_line));
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
                this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if (this.binding.placeEt.getText().toString().isEmpty()) {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
                return;
            } else {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                return;
            }
        }
        if (this.layoutSelected.equals("3")) {
            this.binding.personalDetail.setVisibility(0);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 300, this.binding.horizontal.getScrollY());
            this.layoutSelected = "2";
            this.binding.selectState.setVisibility(8);
            this.binding.authInfo.setVisibility(8);
            this.binding.otherDetails.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.districtDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
                this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
                this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if (this.binding.placeEt.getText().toString().isEmpty()) {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            this.binding.resetTv.setEnabled(false);
            this.binding.resetTv.setTextColor(Color.parseColor(this.grayColourTag));
            this.binding.saveNextTv.setEnabled(true);
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            return;
        }
        if (this.layoutSelected.equals("4")) {
            this.binding.authInfo.setVisibility(0);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 300, this.binding.horizontal.getScrollY());
            this.layoutSelected = "3";
            this.binding.selectState.setVisibility(8);
            this.binding.otherDetails.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
            if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.districtDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
                this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            if (this.binding.placeEt.getText().toString().isEmpty()) {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            } else {
                this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            }
            this.binding.saveNextTv.setEnabled(true);
            this.binding.resetTv.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
            this.binding.previousTv.setEnabled(true);
            this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
            return;
        }
        if (this.layoutSelected.equals("5")) {
            this.layoutSelected = "4";
            this.binding.finalPreview.setVisibility(8);
            this.binding.homeFragmentTopConstraintLayout.setVisibility(0);
            this.binding.otherDetails.setVisibility(0);
            this.binding.selectState.setVisibility(8);
            this.binding.personalDetail.setVisibility(8);
            this.binding.authInfo.setVisibility(8);
            this.binding.textView3.setText(String.format(getString(R.string.blo_aadhaar_Authentication), new Object[0]));
            this.binding.resetTv.setVisibility(0);
            this.binding.previousTv.setText(String.format(getString(R.string.blo_previous), new Object[0]));
            this.binding.saveNextTv.setText(String.format(getString(R.string.blo_save_next), new Object[0]));
            this.binding.previousTv.setEnabled(true);
            this.binding.saveNextTv.setEnabled(true);
            this.binding.resetTv.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
        }
    }

    public void saveNextTvClick() {
        this.binding.saveNextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$saveNextTvClick$16(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveNextTvClick$16(View view) {
        if (this.layoutSelected.equals("1")) {
            stateCheck();
            this.binding.authInfoLayout.setEnabled(true);
            return;
        }
        if (this.layoutSelected.equals("2")) {
            detailCheck();
            this.binding.otherDetailsLayout.setEnabled(true);
            return;
        }
        if (this.layoutSelected.equals("3")) {
            if (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1) {
                showDialog(this.selectIdText);
            } else if (this.selectedType.equals(this.textForA)) {
                if (this.binding.typeAadhaarNo.getText().toString().isEmpty() && this.binding.aadhaarNumber.isChecked()) {
                    showDialog(this.selectAadharText);
                } else if (String.valueOf(Verhoeff.validateVerhoeff(this.binding.typeAadhaarNo.getText().toString())).equals(this.trueText)) {
                    storeAadhaarRef();
                } else {
                    showDialog(this.selectCorrectAadharText);
                }
            } else if (this.selectedType.equals(this.textForB)) {
                alternateId();
            }
            getCurrentLocation();
            return;
        }
        if (this.layoutSelected.equals("4")) {
            otherDetails();
        } else if (this.layoutSelected.equals("5")) {
            previewDetail();
        }
    }

    public void resetTvClick() {
        this.binding.resetTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$resetTvClick$17(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetTvClick$17(View view) {
        if (this.layoutSelected.equals("3")) {
            this.binding.aadhaarGrp.clearCheck();
            this.binding.typeAadhaarNo.setEnabled(false);
            this.binding.preview.setImageResource(0);
            this.binding.typeAadhaarNo.setText("");
            this.binding.alternateIdDropDown.setSelection(0);
            this.binding.uploadDoc.setVisibility(8);
            this.binding.linearLayout4.setVisibility(8);
            this.binding.linearLayout9.setVisibility(8);
            this.binding.fileName.setText("");
            this.binding.fileSize.setText("");
            return;
        }
        if (this.layoutSelected.equals("4")) {
            this.binding.mobileNumberEt.setText(this.mobileNo);
            this.binding.emailIdEt.setText(this.emailId);
            this.binding.placeEt.setText(this.town);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$chooseFileClick$18(View view) {
        selectImage();
    }

    public void chooseFileClick() {
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$chooseFileClick$18(view);
            }
        });
    }

    public void deleteClick() {
        this.binding.delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$deleteClick$19(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteClick$19(View view) {
        this.binding.fileName.setText("");
        this.binding.fileSize.setText("");
        this.binding.delete.setVisibility(8);
        this.binding.chooseFile.setEnabled(true);
        this.binding.linearLayout9.setVisibility(8);
        this.binding.preview.setImageResource(android.R.color.transparent);
        this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
    }

    public void openfile() {
        String[] strArr = {this.applicationPdfText};
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        this.activityResultLauncher.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0080 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0095 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a3 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f9 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0101 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x012e A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0187 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x01a1 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:30:0x0060, B:32:0x0080, B:34:0x0095, B:36:0x00a3, B:42:0x019d, B:37:0x00f9, B:39:0x0101, B:40:0x012e, B:41:0x0187, B:43:0x01a1, B:44:0x01ab), top: B:50:0x0060 }] */
    public /* synthetic */ void lambda$new$25(ActivityResult activityResult) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Cursor cursorQuery;
        String string;
        Throwable th;
        if (activityResult.getResultCode() == -1) {
            Uri data = activityResult.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
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
                        } catch (Throwable th4) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            th = th4;
                        }
                    } catch (IOException e) {
                        e = e;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        Logger.d(this.logTag, e.getMessage());
                        byteArrayOutputStream = byteArrayOutputStream2;
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        this.byteArray = byteArray;
                        cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), this.pdfText), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(this.emptyCursorText);
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.contains(this.pdfText)) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda27
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$new$22();
                                }
                            }, 2000L);
                            showDialog("Please Select correct format of file.");
                        } else if (this.filesize < 1024) {
                            double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                            this.binding.fileName.setText(string);
                            this.binding.chooseFile.setEnabled(true);
                            this.binding.fileSize.setText(dRound + this.kbText);
                            this.binding.delete.setVisibility(0);
                            this.binding.linearLayout9.setVisibility(0);
                            this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        } else if (this.filesize > 3060) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda25
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$new$20();
                                }
                            }, 2000L);
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setMessage("File size is more than 3 MB... Please try again !!!");
                            builder.setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda26
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    this.f$0.lambda$new$21(dialogInterface, i2);
                                }
                            });
                            builder.show();
                        } else {
                            double dRound2 = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                            this.binding.fileName.setText(string);
                            this.binding.chooseFile.setEnabled(true);
                            this.binding.fileSize.setText(dRound2 + this.mbText);
                            this.binding.delete.setVisibility(0);
                            this.binding.linearLayout9.setVisibility(0);
                            this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                        cursorQuery.close();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda28
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$23();
                            }
                        }, 2000L);
                        return;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), this.pdfText), null, null, null, null);
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.emptyCursorText);
                }
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (string.contains(this.pdfText)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda27
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$22();
                        }
                    }, 2000L);
                    showDialog("Please Select correct format of file.");
                } else if (this.filesize < 1024) {
                    double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                    this.binding.fileName.setText(string);
                    this.binding.chooseFile.setEnabled(true);
                    this.binding.fileSize.setText(dRound3 + this.kbText);
                    this.binding.delete.setVisibility(0);
                    this.binding.linearLayout9.setVisibility(0);
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                } else if (this.filesize > 3060) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda25
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$20();
                        }
                    }, 2000L);
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                    builder2.setMessage("File size is more than 3 MB... Please try again !!!");
                    builder2.setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda26
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$new$21(dialogInterface, i2);
                        }
                    });
                    builder2.show();
                } else {
                    double dRound4 = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                    this.binding.fileName.setText(string);
                    this.binding.chooseFile.setEnabled(true);
                    this.binding.fileSize.setText(dRound4 + this.mbText);
                    this.binding.delete.setVisibility(0);
                    this.binding.linearLayout9.setVisibility(0);
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
                cursorQuery.close();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda28
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$new$23();
                    }
                }, 2000L);
                return;
            } catch (Exception e3) {
                Logger.d(this.logTag, e3.getMessage());
            }
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            this.byteArray = byteArray2;
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$24();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$20() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$21(DialogInterface dialogInterface, int i) {
        this.binding.linearLayout9.setVisibility(8);
        this.binding.preview.setImageResource(0);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$22() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$23() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$24() {
        this.alertDialog.dismiss();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            Logger.d(this.logTag, this.cameraText + this.insideCameraText);
            if (data == null) {
                return;
            }
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.d(this.logTag, e.getMessage());
            }
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.imageText), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.emptyCursorText);
                }
                cursorQuery.moveToFirst();
                this.fileName = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (this.filesize < 1024) {
                    double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                    cursorQuery.close();
                    this.binding.delete.setVisibility(0);
                    this.binding.preview.setVisibility(0);
                    this.binding.linearLayout9.setVisibility(0);
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                    this.binding.fileName.setText(this.fileName);
                    this.binding.fileSize.setText(dRound + this.kbText);
                    this.binding.chooseFile.setEnabled(true);
                    ImageView imageView = this.binding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } else if (this.filesize > 2048) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda33
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onActivityResult$26();
                        }
                    }, 2000L);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    this.binding.chooseFile.setEnabled(true);
                    builder.setMessage("File size is more than 2 MB... Please try again !!!");
                    builder.setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda34
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onActivityResult$27(dialogInterface, i);
                        }
                    });
                    builder.show();
                } else {
                    double dRound2 = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                    cursorQuery.close();
                    this.binding.delete.setVisibility(0);
                    this.binding.linearLayout9.setVisibility(0);
                    this.binding.preview.setVisibility(0);
                    this.binding.chooseFile.setEnabled(true);
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.redColourTag));
                    this.binding.fileName.setText(this.fileName);
                    this.binding.fileSize.setText(dRound2 + this.mbText);
                    ImageView imageView2 = this.binding.preview;
                    byte[] bArr2 = this.byteArray;
                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                }
                cursorQuery.close();
                this.alertDialog.dismiss();
            } catch (Exception e2) {
                Logger.d(this.logTag, e2.getMessage());
            }
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResult$28();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$26() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$27(DialogInterface dialogInterface, int i) {
        this.binding.linearLayout9.setVisibility(8);
        this.binding.preview.setImageResource(0);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$28() {
        this.alertDialog.dismiss();
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {this.takePhotoText, this.takePhotoTextFromGallery, this.takePdfTextFromGallery, this.cancelText};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda30
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$30(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$30(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takePhotoText)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
            return;
        }
        if (charSequenceArr[i].equals(this.takePhotoTextFromGallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(this.takePdfTextFromGallery)) {
            this.alertDialog.show();
            openfile();
        } else if (charSequenceArr[i].equals(this.cancelText)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$selectImage$29();
                }
            }, 2000L);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$29() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageApi(String captureFileName, String stateCode1, String asmblyNo1, String partNo1) {
        Logger.d(this.logTag, "image fetch");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadFile1(this.token, this.currentRole, this.bloAppText, MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), this.applicationPdfText), RequestBody.create(MediaType.parse("fileName"), this.referenceNumber + "_doc"), RequestBody.create(stateCode1, MediaType.parse("stateCode")), RequestBody.create(asmblyNo1, MediaType.parse(this.acNoText)), RequestBody.create(partNo1, MediaType.parse("partNo")), RequestBody.create(this.formText, MediaType.parse("type")), RequestBody.create(this.bloAppText, MediaType.parse("appName")), SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), this.channelidobo, "ANDROIDMOB").enqueue(new AnonymousClass2(captureFileName, stateCode1, asmblyNo1, partNo1));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo1;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$partNo1;
        final /* synthetic */ String val$stateCode1;

        AnonymousClass2(final String val$captureFileName, final String val$stateCode1, final String val$asmblyNo1, final String val$partNo1) {
            this.val$captureFileName = val$captureFileName;
            this.val$stateCode1 = val$stateCode1;
            this.val$asmblyNo1 = val$asmblyNo1;
            this.val$partNo1 = val$partNo1;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.isSuccessful()) {
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, AadhaarAuthenticationFormFragment.this.successUploadedText);
                AadhaarAuthenticationFormFragment.this.apiImage = String.valueOf(((JsonObject) response.body()).get(AadhaarAuthenticationFormFragment.this.refIdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "referenceNumber " + AadhaarAuthenticationFormFragment.this.apiImage);
            }
            if (response.code() == 200) {
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, AadhaarAuthenticationFormFragment.this.successUploadedText);
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = AadhaarAuthenticationFormFragment.this.commonUtilClass;
                Context context = AadhaarAuthenticationFormFragment.this.getContext();
                String str = AadhaarAuthenticationFormFragment.this.refreshToken;
                final String str2 = this.val$captureFileName;
                final String str3 = this.val$stateCode1;
                final String str4 = this.val$asmblyNo1;
                final String str5 = this.val$partNo1;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str6, String str7) {
                        this.f$0.lambda$onResponse$2(str2, str3, str4, str5, i, str6, str7);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, String.valueOf(jSONObject));
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "" + response.errorBody());
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, jSONObject.optString(AadhaarAuthenticationFormFragment.this.messageText));
            } catch (IOException | NullPointerException | JSONException e) {
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(final String str, final String str2, final String str3, final String str4, int i, final String str5, final String str6) {
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, AadhaarAuthenticationFormFragment.this.getRefreshTokenText + i + " " + str5 + " " + str6);
            if (i == 401 || i == 400) {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.showMessageOK(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.showMessageOK(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.uploadAgainTextForRefresh, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$2$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(str5, str6, str, str2, str3, str4, dialogInterface, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setLocaleBool(false);
            AadhaarAuthenticationFormFragment.this.startActivity(new Intent(AadhaarAuthenticationFormFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, DialogInterface dialogInterface, int i) {
            AadhaarAuthenticationFormFragment.this.token = AadhaarAuthenticationFormFragment.this.bearerText + str;
            AadhaarAuthenticationFormFragment.this.refreshToken = str2;
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setToken(AadhaarAuthenticationFormFragment.this.bearerText + str);
            AadhaarAuthenticationFormFragment.this.saveImageApi(str3, str4, str5, str6);
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "Failed_Uploaded " + t.getMessage());
        }
    }

    private void stateCheck() {
        if (this.binding.stateDropDown.getText().toString().isEmpty()) {
            this.binding.stateDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.stateDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.acDropDown.getText().toString().isEmpty()) {
            this.binding.acDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.acDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.pcDropDown.getText().toString().isEmpty()) {
            this.binding.pcDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.pcDropDown.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        this.binding.personalDetail.setVisibility(0);
        this.layoutSelected = "2";
        this.binding.selectState.setVisibility(8);
        this.binding.finalPreview.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.otherDetails.setVisibility(8);
        this.binding.resetTv.setEnabled(false);
        this.binding.resetTv.setTextColor(Color.parseColor(this.grayColourTag));
        this.binding.previousTv.setEnabled(true);
        this.binding.saveNextTv.setEnabled(true);
        this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 500, this.binding.horizontal.getScrollY());
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
        this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.pcDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
    }

    private void detailCheck() {
        Logger.d(this.logTag, "inside detailCheck");
        if (this.binding.typeName.getText().toString().isEmpty()) {
            this.binding.typeName.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.typeName.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            this.binding.typeEpicNumber.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.typeEpicNumber.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (Objects.equals(this.referenceNumber, null)) {
            this.alertDialog.show();
            Logger.d(this.logTag, "inside detailCheck before getRefNum");
            getRefNum();
            return;
        }
        if (this.binding.typeName.getText().toString().isEmpty()) {
            showDialog("Please Enter First Name");
            return;
        }
        if (this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            showDialog("Please Enter EPIC Number");
            return;
        }
        if (!this.binding.typeEpicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Please Enter Correct Epic Number");
            return;
        }
        this.binding.authInfo.setVisibility(0);
        this.layoutSelected = "3";
        this.binding.dateEt.setText(this.trxDate);
        this.binding.finalPreview.setVisibility(8);
        this.binding.selectState.setVisibility(8);
        this.binding.personalDetail.setVisibility(8);
        this.binding.otherDetails.setVisibility(8);
        this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 500, this.binding.horizontal.getScrollY());
        this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.pcDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        insertIntoDraft();
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
    }

    private void aadhaarNumber() {
        if (this.binding.aadhaarNumber.isChecked() && this.binding.typeAadhaarNo.getText().toString().isEmpty()) {
            this.binding.typeAadhaarNo.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.typeAadhaarNo.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.aadhaarNumber.isChecked() && this.binding.typeAadhaarNo.getText().toString().isEmpty()) {
            showDialog(this.selectAadharText);
            return;
        }
        this.binding.otherDetails.setVisibility(0);
        this.layoutSelected = "4";
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.layoutVisited = "";
        } else {
            this.layoutVisited = "1";
        }
        this.binding.finalPreview.setVisibility(8);
        this.binding.selectState.setVisibility(8);
        this.binding.personalDetail.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.pcDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        updateDraft();
        this.binding.previousTv.setEnabled(true);
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
        this.binding.saveNextTv.setEnabled(true);
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
    }

    private void alternateId() {
        if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) {
            showDialog(this.selectAlternateIdText);
            return;
        }
        if (!this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText) && this.binding.fileName.getText().toString().isEmpty()) {
            showDialog(this.uploadDocumentText);
            return;
        }
        this.binding.otherDetails.setVisibility(0);
        this.layoutSelected = "4";
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.layoutVisited = "";
        } else {
            this.layoutVisited = "1";
        }
        this.binding.selectState.setVisibility(8);
        this.binding.finalPreview.setVisibility(8);
        this.binding.personalDetail.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.otherDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_state));
        if (this.binding.stateDropDown.getText().toString().isEmpty() || this.binding.pcDropDown.getText().toString().isEmpty() || this.binding.acDropDown.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if (this.binding.typeName.getText().toString().isEmpty() || this.binding.typeEpicNumber.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        if ((this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.fileName.getText().toString().isEmpty() || this.binding.alternateIdDropDown.getSelectedItem().toString().equals(this.selectDocumentText)) && (this.binding.aadhaarGrp.getCheckedRadioButtonId() == -1 || this.binding.typeAadhaarNo.getText().toString().isEmpty())) {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        } else {
            this.binding.authInfoLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        }
        updateDraft();
        saveImageApi(this.saveImageFileName, this.stateCode, this.asmblyNO, this.partNo);
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.blueColourTag));
        this.binding.previousTv.setEnabled(true);
        this.binding.saveNextTv.setEnabled(true);
        this.binding.previousTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_app_theme));
    }

    private void storeAadhaarRef() {
        showProgressVisible();
        this.commonUtilClass.getaadharref(getContext(), this.stateCode, this.token, this.binding.typeAadhaarNo.getText().toString(), SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "AadhaarAuthentication", new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda18
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$storeAadhaarRef$33(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$storeAadhaarRef$32(int i, String str, String str2) {
        Logger.d(this.logTag, this.getRefreshTokenText + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda14
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$storeAadhaarRef$31(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = this.bearerText + str;
        this.refreshToken = str2;
        SharedPref.getInstance(getContext()).setRefreshToken(str2);
        SharedPref.getInstance(getContext()).setToken(this.bearerText + str);
        storeAadhaarRef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$storeAadhaarRef$31(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getContext()).setLocaleBool(false);
        startActivity(new Intent(getContext(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$storeAadhaarRef$33(int i, String str, String str2) {
        if (i == 401 || i == 400) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda32
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str3, String str4) {
                    this.f$0.lambda$storeAadhaarRef$32(i2, str3, str4);
                }
            });
            return;
        }
        if (str.equals("n") || str.equals("N")) {
            showDialog(str2);
        } else if (str.equals("y") || str.equals("Y")) {
            this.apiIdNum = str2;
            this.idNumber = str2;
            aadhaarNumber();
        }
        showProgressInVisible();
    }

    private void otherDetails() {
        if (this.binding.mobileNumberEt.getText().toString().isEmpty()) {
            this.binding.mobileNumberEt.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.mobileNumberEt.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            this.binding.placeEt.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.binding.placeEt.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_black));
        }
        if (this.binding.mobileNumberEt.getText().toString().isEmpty()) {
            showDialog("Please enter Mobile number");
            return;
        }
        if (!this.binding.mobileNumberEt.getText().toString().isEmpty() && !this.binding.mobileNumberEt.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
            showDialog("Please enter correct Mobile number");
            return;
        }
        if (!this.binding.emailIdEt.getText().toString().isEmpty() && !this.binding.emailIdEt.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            showDialog("Please enter correct Email ID");
            return;
        }
        if (this.binding.placeEt.getText().toString().isEmpty()) {
            showDialog("Please Enter Place");
            return;
        }
        if (!this.binding.placeEt.getText().toString().isEmpty() && !this.binding.placeEt.getText().toString().matches(RegexMatcher.PLACE_REGEX2)) {
            showDialog("Please enter correct Place");
            return;
        }
        updateDraft1();
        this.layoutSelected = "5";
        this.binding.finalPreview.setVisibility(0);
        this.binding.otherDetails.setVisibility(8);
        this.binding.selectState.setVisibility(8);
        this.binding.personalDetail.setVisibility(8);
        this.binding.homeFragmentTopConstraintLayout.setVisibility(8);
        this.binding.authInfo.setVisibility(8);
        this.binding.textView3.setText(String.format(getString(R.string.blo_preview), new Object[0]));
        this.binding.resetTv.setVisibility(8);
        this.binding.previousTv.setPadding(10, 7, 10, 7);
        this.binding.previousTv.setText(String.format(getString(R.string.blo_keep_Editing), new Object[0]));
        this.binding.saveNextTv.setText(String.format(getString(R.string.blo_submit), new Object[0]));
        this.binding.previousTv.setEnabled(true);
        this.stateName1 = this.binding.stateDropDown.getText().toString();
        this.districtName1 = this.binding.districtDropDown.getText().toString();
        this.firstName = this.binding.typeName.getText().toString();
        if (this.binding.typeSurname.getText().toString().isEmpty()) {
            this.lastName = "";
        } else {
            this.lastName = this.binding.typeSurname.getText().toString();
        }
        this.epicId = this.binding.typeEpicNumber.getText().toString();
        if (this.binding.alternateId.isChecked()) {
            this.idNumber = null;
            this.isAdhar = "N";
        } else {
            this.idNumber = this.apiIdNum;
            this.isAdhar = "Y";
        }
        this.assemblyNo = this.binding.assemblyNo.getText().toString();
        this.acName = this.binding.acDropDown.getText().toString();
        this.proofOfDoc = this.binding.fileName.getText().toString();
        this.mobileNo = this.binding.mobileNumberEt.getText().toString();
        this.emailId = this.binding.emailIdEt.getText().toString();
        this.town = this.binding.placeEt.getText().toString();
        this.binding.stateDropDownPre.setText(this.stateName);
        this.binding.districtPre.setText(this.districtName);
        this.binding.assemblyNoPre.setText(this.asmblyNO);
        this.binding.acDropDownPre.setText(this.asmblyName);
        this.binding.parliamentNoPre.setText(this.asmblyNO);
        this.binding.pcDropDownPre.setText(this.asmblyName);
        this.binding.typeNamePre.setText(this.firstName);
        this.binding.typeSurnamePre.setText(this.binding.typeSurname.getText().toString());
        this.binding.typeEpicNumberPre.setText(this.epicId);
        if (this.binding.aadhaarNumber.isChecked()) {
            this.binding.linearLayoutMainPre.setVisibility(0);
            this.binding.linearLayoutMainPre1.setVisibility(8);
            this.binding.aadhaarNumberPre.setChecked(true);
            this.binding.aadhaarNumberPre.setEnabled(true);
            this.binding.alternateIdPre.setEnabled(false);
            this.binding.aadhaarTvPre1.setText("********" + this.binding.typeAadhaarNo.getText().toString().substring(8, 12));
        } else if (this.binding.alternateId.isChecked()) {
            this.binding.linearLayoutMainPre.setVisibility(8);
            this.binding.linearLayoutMainPre1.setVisibility(0);
            this.binding.alternateIdPre1.setChecked(true);
            this.binding.aadhaarNumberPre1.setEnabled(false);
            this.binding.alternateIdPre1.setEnabled(true);
            this.binding.documentNameTvPre.setText(this.binding.alternateIdDropDown.getSelectedItem().toString());
            this.binding.uploadedDocTvPre.setText(this.binding.fileName.getText().toString());
            if (this.binding.fileName.getText().toString().contains(this.pdfText)) {
                this.binding.imgPreview.setImageResource(R.drawable.blo_pfd_thumbnail);
            } else {
                ImageView imageView = this.binding.imgPreview;
                byte[] bArr = this.byteArray;
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        this.binding.mobileNumberTvPre.setText(this.binding.mobileNumberEt.getText().toString());
        this.binding.emailIdTvPre.setText(this.binding.emailIdEt.getText().toString());
        this.binding.placeTvPre.setText(this.binding.placeEt.getText().toString());
        this.binding.dateTvPre.setText(this.binding.dateEt.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previewDetail() {
        try {
            this.submitMap.put("aadharRefNo", this.idNumber);
            this.submitMap.put("acName", this.asmblyName);
            this.submitMap.put(this.acNoText, Integer.valueOf(Integer.parseInt(this.asmblyNO)));
            this.submitMap.put("formSubmissionChannel", "GARUDA");
            this.submitMap.put("formSubmissionMode", "ONLINE");
            this.submitMap.put("applicantFullName", this.firstName + " " + this.lastName);
            this.submitMap.put("applicantFirstMidlleName", this.firstName);
            this.submitMap.put(this.applicantLastNameText, this.lastName);
            this.submitMap.put("applicationForOther", "N");
            this.submitMap.put("applicationForSelf", "Y");
            this.submitMap.put(this.districtCdText, this.districtCode);
            this.submitMap.put(this.partNumberText, Integer.valueOf(Integer.parseInt(this.partNo)));
            if (!this.emailId.isEmpty()) {
                this.submitMap.put(this.emailIdText, this.emailId);
            } else {
                this.submitMap.put(this.emailIdText, null);
            }
            this.submitMap.put("epicNo", this.epicId);
            this.submitMap.put("isDraft", "N");
            this.submitMap.put("mobileNo", this.mobileNo);
            if (this.binding.aadhaarNumber.isChecked()) {
                this.submitMap.put(this.proofDocumentTypeText, null);
            } else {
                this.submitMap.put(this.proofDocumentTypeText, this.idType);
            }
            this.submitMap.put("proofDocumentDln", this.apiImage);
            this.submitMap.put(this.refIdText, this.referenceNumber);
            this.submitMap.put("applicantDate", this.dateFormat1.format(this.dateFormat.parse(this.trxDate)));
            this.submitMap.put("formSubDate", this.dateFormat1.format(this.dateFormat.parse(this.trxDate)));
            this.submitMap.put(this.stateCdText, this.stateCode);
            this.submitMap.put("submissionPlace", this.town);
            this.submitMap.put("isAadharAvailable", this.isAdhar);
            this.submitMap.put("typeOfRelation", null);
            this.submitMap.put("codeId", 281);
        } catch (ParseException e) {
            Logger.d(this.logTag, e.getMessage());
        }
        Logger.d(this.logTag, "submitMap : " + new JSONObject(this.submitMap));
        this.alertDialog.show();
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).eroAadhaarAuthSubmit(this.token, this.currentRole, this.stateCode, this.submitMap, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), this.channelidobo).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "Submit API -> code : " + response.code());
            if (response.code() == 200) {
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In previewDetail() -> response body");
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In previewDetail() -> statusCode : " + ((JsonObject) response.body()).get("statusCode"));
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In previewDetail() -> message : " + ((JsonObject) response.body()).get(AadhaarAuthenticationFormFragment.this.messageText));
                AlertDialog.Builder builder = new AlertDialog.Builder(AadhaarAuthenticationFormFragment.this.getContext());
                builder.setMessage("Form 6B Submitted Successfully \nReference Number : " + AadhaarAuthenticationFormFragment.this.referenceNumber);
                builder.setNeutralButton(AadhaarAuthenticationFormFragment.this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                builder.show();
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.getRefreshToken(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i, str, str2);
                    }
                });
                return;
            }
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In previewDetail() -> else part ----> Response Body is null");
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                final String strOptString = jSONObject.optString(AadhaarAuthenticationFormFragment.this.messageText);
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, "In previewDetail() : errorResponse : " + strOptString);
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, String.valueOf(jSONObject));
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4(strOptString);
                    }
                }, 2000L);
            } catch (IOException | JSONException e) {
                Logger.d(AadhaarAuthenticationFormFragment.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            AadhaarAuthenticationFormFragment.this.updateVoterIdDetails();
            AadhaarAuthenticationFormFragment.this.startActivity(new Intent((Context) AadhaarAuthenticationFormFragment.this.getActivity(), (Class<?>) MainActivity.class));
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            Logger.d(AadhaarAuthenticationFormFragment.this.logTag, AadhaarAuthenticationFormFragment.this.getRefreshTokenText + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                AadhaarAuthenticationFormFragment.this.commonUtilClass.showMessageOK(AadhaarAuthenticationFormFragment.this.getContext(), AadhaarAuthenticationFormFragment.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            AadhaarAuthenticationFormFragment.this.token = AadhaarAuthenticationFormFragment.this.bearerText + str;
            AadhaarAuthenticationFormFragment.this.refreshToken = str2;
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setToken(AadhaarAuthenticationFormFragment.this.bearerText + str);
            AadhaarAuthenticationFormFragment.this.previewDetail();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AadhaarAuthenticationFormFragment.this.getContext()).setLocaleBool(false);
            AadhaarAuthenticationFormFragment.this.startActivity(new Intent(AadhaarAuthenticationFormFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(String str) {
            if (str != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AadhaarAuthenticationFormFragment.this.getContext());
                builder.setMessage(str);
                builder.setNeutralButton(AadhaarAuthenticationFormFragment.this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$3(dialogInterface, i);
                    }
                });
                builder.show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
            AadhaarAuthenticationFormFragment.this.startActivity(new Intent((Context) AadhaarAuthenticationFormFragment.this.getActivity(), (Class<?>) MainActivity.class));
            dialogInterface.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d("In previewDetail() -> ON failure", t.getMessage());
        }
    }

    private void insertIntoDraft() {
        this.firstName = this.binding.typeName.getText().toString();
        if (this.binding.typeSurname.getText().toString().isEmpty()) {
            this.lastName = "";
        } else {
            this.lastName = this.binding.typeSurname.getText().toString();
        }
        this.epicId = this.binding.typeEpicNumber.getText().toString();
        String str = this.stateName + this.delimeter + this.districtName + this.delimeter + this.asmblyNO + this.delimeter + this.asmblyName;
        String str2 = this.firstName + this.delimeter + this.binding.typeSurname.getText().toString() + this.delimeter + this.epicId;
        if (this.form.equals("Voter Forms")) {
            AadharAuthViewModel.insertIntoDraft(this.binding.typeName.getText().toString(), str, str2, 2, this.referenceNumber, this.form6BText, this.createdOn);
        }
    }

    private void updateDraft() {
        String str;
        if (this.selectedType.equals(this.textForA)) {
            str = this.aadhaarText + this.delimeter + this.idNumber;
        } else {
            if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("MGNREGA Job Card")) {
                this.idType = "MGJC";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Passbook with photograph issued by Bank/Post Office.")) {
                this.idType = "PPBP";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Health Insurance Smart Card")) {
                this.idType = "HISC";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("PAN Card")) {
                this.idType = "PC";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Driving License.")) {
                this.idType = "DL";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Smart Card issued by RGI under NPR.")) {
                this.idType = "SCRN";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Indian Passport")) {
                this.idType = "IPSP";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Pension document with Photograph.")) {
                this.idType = "PDWP";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Service Identity Card with photograph issued to employees by Central/State Govt./PSUs/Public Limited Companies")) {
                this.idType = "SPEC";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Official Identity Card issued to MPs/MLAs/MLCs.")) {
                this.idType = "OICM";
            } else if (this.binding.alternateIdDropDown.getSelectedItem().toString().equals("Unique Identity ID (UDID) Card, issued by M/o Social Justice and Empowerment, Government of India")) {
                this.idType = "UDID";
            }
            str = this.idType + this.delimeter + this.idPos + this.delimeter + this.binding.fileName.getText().toString() + this.delimeter + this.binding.fileSize.getText().toString();
        }
        AadharAuthViewModel.updateDraft(this.selectedType, this.referenceNumber, str, 3, this.byteArray);
    }

    private void updateDraft1() {
        AadharAuthViewModel.updateDraft1(this.referenceNumber, this.binding.emailIdEt.getText().toString() + this.delimeter + this.binding.mobileNumberEt.getText().toString() + this.delimeter + this.binding.placeEt.getText().toString(), 4);
    }

    public void updateVoterIdDetails() {
        Logger.d(this.logTag, "updateVoterIdDetails");
        AadharAuthViewModel.insertVoterIdDetails(this.firstName, this.lastName, this.stateName1, this.districtName1, this.idNumber, this.acName, this.mobileNo, this.town, this.epicId, this.byteArray, this.createdOn, this.referenceNumber, this.emailId, "Opened", this.form6BText);
    }

    private void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda6
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$34(task);
                    }
                });
                return;
            } else {
                turnOnGPS();
                this.alertDialog.dismiss();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentLocation$34(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                this.binding.placeEt.setText(new Geocoder(getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0).getLocality());
                this.alertDialog.dismiss();
            } catch (Exception e) {
                Logger.d(this.logTag, "Content : " + e.getMessage());
            }
        }
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda11
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$35(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$35(Task task) {
        try {
            Logger.d(this.logTag, "locationResponse : " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
            Toast.makeText(getContext(), "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() == 6) {
                try {
                    e.startResolutionForResult(getActivity(), 2);
                } catch (IntentSender.SendIntentException e2) {
                    Logger.d(this.logTag, e2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$36(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$36(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == 2131362341) {
            this.idPos = position;
        }
    }

    private void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(this.alertText);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
