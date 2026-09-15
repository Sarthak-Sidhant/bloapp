package in.gov.eci.bloapp.views.fragments.h2h;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
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
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallbackjsonTest;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBottomSheetDeletionLayoutBinding;
import in.gov.eci.bloapp.databinding.BloBottomSheetMigrationBinding;
import in.gov.eci.bloapp.databinding.BloBottomsheetaadharBinding;
import in.gov.eci.bloapp.databinding.BloFragmentH2hDetailsBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel;
import in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class H2HDETAILS extends BaseFragment implements View.OnClickListener {
    Boolean Date1Before;
    Boolean Date2Range;
    Boolean Date3After;
    String aadhaarNo;
    String acNumberOther;
    ActivityResultLauncher<Intent> activityResultLauncher;
    AlertDialog alertDialog;
    Double altitude;
    String asmblyNO;
    String asmblyName;
    private String atkband;
    private BloFragmentH2hDetailsBinding binding;
    String bloPhoneNumber;
    Retrofit.Builder builder;
    Bundle bundle2;
    private byte[] byteArray;
    Date c;
    Date dateAfter;
    Date dateBefore;
    Date dateRange;
    String districtName;
    Date dobElector;
    String dobYear;
    private String docref;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    JsonArray epicDetailsArray;
    String fName;
    String finalVerifiedNumberOfElector;
    String formattedDate;
    FusedLocationProviderClient fusedLocationProviderClient;
    String inserted;
    JSONArray jsonArray11;
    String lName;
    Double latitude;
    String locationName;
    LocationRequest locationRequest;
    Double longitude;
    String newEmailID;
    String newPhoneNumberVerified;
    JSONParser parser;
    String partNoOther;
    JsonObject payloadContent;
    private JsonObject payloadForm7;
    private JsonObject payloadForm72;
    private JSONArray payloadgetDetails;
    String phoneNumber;
    JsonArray proceedingEpicDetailsArray;
    private Dialog progressDialog;
    String pwdOtherType;
    String pwdPercentage;
    String refreshToken;
    Retrofit retrofit;
    private String rtkband;
    String sectionName1;
    private String sectionNumber;
    SimpleDateFormat simple;
    String stateName;
    SimpleDateFormat todayDate;
    boolean validateForm6B;
    final Calendar dobcalendar = Calendar.getInstance();
    String h2hDetails1 = "H2H DETAILS";
    String SESSION = "Session Expired. Please Login again..";
    String epicNoString = "epicNo";
    String requestString = "request";
    String noDocAvlblString = "No Document Available";
    String personalDetailTabString = "Please fill Personal Details tab completely";
    String objectStorageString = "objectstorage";
    String cancelString = "Cancel";
    String bloAppString = "BLOAPP";
    String houseNoString = "houseNo";
    String applicantNameString = "applicantName";
    String applicantNameL1String = "applicantNameL1";
    String disabilityPercentagelString = "disabilityPercentage";
    String otherDisabilityString = "otherDisability";
    String disabilityLocomotorString = "disabilityLocomotor";
    String disabilitySpeechHearingString = "disabilitySpeechHearing";
    String disabilityVisuallyString = "disabilityVisually";
    String messageString = "message";
    String sessionTokenString = "Session token expired please Login";
    String noDataString = "No Data Found";
    String sectionNoString = "sectionNo";
    String sectionNameString = "sectionName";
    CommomUtility commonUtilClass = new CommomUtility();
    String genderString = "gender";
    String epicNumberString2 = "epicNumber";
    String femaleString = "Female";
    String thirdGenderString = "Third Gender";
    String relativeNameString = "relativeName";
    String relativeNameL1String = "relativeNameL1";
    String relativeTypeString = "relativeType";
    String enterEpicString = "Enter EPIC Number";
    String enterCorrectEpicString = "Enter Correct EPIC Number";
    String partNumberString = "partNumber";
    String contentString = "content";
    String firstnamefromdbString = "firstnamefromdb";
    String lastnamefromdbString = "lastnamefromdb";
    String voterIdString = "voterId";
    String voterId2String = "voterId2";
    String errorString = "Error";
    String emailString = "email";
    String tryAgainString = "Please try again";
    String verifyFillForm7String = "Verify & Fill Form 7";
    String otherString = "other";
    String husbandString = "Husband";
    String noRecordFoundString = "No Record Found with epic number: ";
    String fatherString = "Father";
    String requestTypeString = "Request Type: ";
    String motherString = "Mother";
    String finalEmail = "";
    String datePattern = "yyyy-MM-dd";
    String datePattern1 = "dd/MM/yyyy";
    String networkTag = "Please check network";
    String comingTag = "coming in onFailure";
    String alert = "Alert";
    String sectionName = "";
    String tehsil = "";
    String pinCode = "";
    String postOffice = "";
    String village = "";
    String newAddressSubmit = "";
    String newAddress = "";
    String finalDob = "";
    String finalAge = "";
    String finalDateOfVerification = "";
    String bloPartNumber = "";
    String bloStateCode = "";
    String bloAssemCode = "";
    String email33 = "";
    String epicVerify = "";
    String houseNo1 = "";
    String appFor = "";
    String epicNumberNew = "";
    String stateNameForForm6B = "";
    String districtNameForForm6B = "";
    String acNameForForm6B = "";
    String assemblyNoForForm6B = "";
    String firstNameForForm6B = "";
    String lastNameForForm6B = "";
    String epicIdForForm6B = "";
    String mobileNoForForm6B = "";
    String emailIdForForm6B = "";
    String stateCdForForm6B = "";
    String dataMissmatchText = "Data Mismatched from user token";
    String rb1st = "";
    String rbDob = "";
    String rbAddress = "";
    String rbInformation1 = "";
    String rbInformation2 = "";
    String rbMetInfo = "";
    String coordinates = "";
    String token = "";
    String stateCode = "";
    String districtCode = "";
    String acNo = "";
    String partNo = "";
    String filerefphoto = "";
    String filerefdob = "";
    String filerefaddress = "";
    String base64element = "";
    String base64element1 = "";
    String base64element2 = "";
    JsonObject payLoad = null;
    String sectionNumberNew = "";
    String epicNumberId = "";
    String epicNumberId2 = "";
    String epicNumberStatus = "";
    String epicNumber = "";
    String epicNumber2 = "";
    String request = "";
    String firstnameId = "";
    String lastnameId = "";
    String firstname = "";
    String lastname = "";
    String error = "start";
    String voterIdText = "voterId";
    String formText = "form";
    String currentRole = "blo";
    String logTag = "H2H Details";
    String contentText = "content";
    String acNumberText = "acNumber";
    String messageText = "message";
    String alertText = "Alert";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String enterEpicNumber = "Enter EPIC Number";
    String enterCorrectEpicNumber = "Enter Correct EPIC Number";
    String epicNumberStringForm7 = "epicNumber";
    String partNumberStringForm7 = "partNumber";
    String noRecordFoundWithEpic = "No Record Found with epic number: ";
    String isAadharVerified = "";
    ArrayList<String> sectionNolist = new ArrayList<>();
    String isPhotographSame = "";
    String isElectorRecordSame = "";
    String isDobRecordSame = "";
    String isAddressRecordSame = "";
    String isPWD = "";
    int isMetElector = 0;
    String partSerialNumber = "";
    String phoneNumberVerified = "";
    String allDetailsVerified = "";
    String isLocomotive = "";
    HashMap<String, Object> epicmap = new HashMap<>();
    String isVisual = "";
    String isDeaf = "";
    String disabilityType = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public H2HDETAILS() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.jsonArray11 = null;
        this.payloadgetDetails = null;
        this.docref = "NA";
        this.validateForm6B = false;
        this.acNumberOther = "";
        this.partNoOther = "";
        this.epicDetailsArray = null;
        this.proceedingEpicDetailsArray = null;
        this.bundle2 = new Bundle();
        this.simple = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        this.c = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault());
        this.todayDate = simpleDateFormat;
        this.formattedDate = simpleDateFormat.format(this.c);
        this.inserted = "INSERTED";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$0((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x007e A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0091 A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[Catch: Exception -> 0x0190, TRY_LEAVE, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e0 A[Catch: Exception -> 0x00f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f0, blocks: (B:37:0x00da, B:39:0x00e0), top: B:60:0x00da, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0105 A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0119 A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0121 A[Catch: Exception -> 0x0190, TRY_LEAVE, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0156 A[Catch: Exception -> 0x0166, TRY_LEAVE, TryCatch #3 {Exception -> 0x0166, blocks: (B:47:0x0150, B:49:0x0156), top: B:65:0x0150, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x017a A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0185 A[Catch: Exception -> 0x0190, TryCatch #1 {Exception -> 0x0190, blocks: (B:30:0x0060, B:32:0x007e, B:34:0x0091, B:36:0x00a1, B:42:0x00f7, B:54:0x0181, B:41:0x00f0, B:43:0x0105, B:45:0x0119, B:46:0x0121, B:52:0x016d, B:51:0x0166, B:53:0x017a, B:55:0x0185, B:56:0x018f, B:37:0x00da, B:39:0x00e0, B:47:0x0150, B:49:0x0156), top: B:62:0x0060, inners: #0, #3 }] */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) throws Throwable {
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
                    Logger.d(this.h2hDetails1, e.getMessage());
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
                        showdialog1("", "Please Select the correct format of file");
                    } else if (this.filesize < 1024) {
                        double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                        this.binding.preview.setVisibility(0);
                        this.binding.chooseFileItems.setVisibility(0);
                        this.binding.selectName.setText(string);
                        this.binding.selectSize.setText(dRound2 + "KB");
                        try {
                            if (isAdded()) {
                                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                            }
                        } catch (Exception unused) {
                            Logger.e(this.h2hDetails1, this.comingTag);
                        }
                        this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        saveimageapi(this.saveImageFileName);
                    } else {
                        dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                        if (dRound > 3.0d) {
                            showdialog1(this.alert, "PDF size exceeded 3MB limit.");
                        } else {
                            this.binding.preview.setVisibility(0);
                            this.binding.chooseFileItems.setVisibility(0);
                            this.binding.selectName.setText(string);
                            this.binding.selectSize.setText(dRound + "MB");
                            try {
                                if (isAdded()) {
                                    this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                                }
                            } catch (Exception unused2) {
                                Logger.e(this.h2hDetails1, this.comingTag);
                            }
                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                            saveimageapi(this.saveImageFileName);
                        }
                    }
                    cursorQuery.close();
                    return;
                }
            } catch (IOException e2) {
                e = e2;
            }
            cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(byteArray, 0), ".pdf"), null, null, null, null);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.close();
                throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
            }
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
            if (string.contains(".pdf")) {
                showdialog1("", "Please Select the correct format of file");
            } else if (this.filesize < 1024) {
                double dRound3 = Math.round(this.filesize * 100.0d) / 100.0d;
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileItems.setVisibility(0);
                this.binding.selectName.setText(string);
                this.binding.selectSize.setText(dRound3 + "KB");
                if (isAdded()) {
                    this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                }
                this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                saveimageapi(this.saveImageFileName);
            } else {
                dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                if (dRound > 3.0d) {
                    showdialog1(this.alert, "PDF size exceeded 3MB limit.");
                } else {
                    this.binding.preview.setVisibility(0);
                    this.binding.chooseFileItems.setVisibility(0);
                    this.binding.selectName.setText(string);
                    this.binding.selectSize.setText(dRound + "MB");
                    if (isAdded()) {
                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                    }
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                    saveimageapi(this.saveImageFileName);
                }
            }
            cursorQuery.close();
            return;
        } catch (Exception e3) {
            Logger.d(this.contentString, e3.getMessage());
            return;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        this.byteArray = byteArray2;
    }

    static String capitailizeWord(String str) {
        StringBuilder sb = new StringBuilder();
        char cCharAt = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (cCharAt != ' ' || str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            cCharAt = str.charAt(i);
        }
        return sb.toString().trim();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentH2hDetailsBinding.inflate(getLayoutInflater());
        this.coordinates = "0.0,0.0,0.0";
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicVerify = arguments.getString("epicnumber");
            this.houseNo1 = arguments.getString("housenomain");
        }
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        try {
            this.dateBefore = this.simple.parse("01/07/1987");
            this.dateAfter = this.simple.parse("03/12/2004");
        } catch (Exception e) {
            Logger.d("H2HDetails", e.toString());
        }
        try {
            if (isAdded()) {
                this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        getCurrentLocation();
        try {
            requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS.1
                public void handleOnBackPressed() {
                    if (H2HDETAILS.this.getFragmentManager().getBackStackEntryCount() != 0) {
                        H2HDETAILS.this.getFragmentManager().popBackStack();
                    }
                }
            });
        } catch (Exception unused2) {
            openFragment(new H2HFragment(), "h2H FRAGMENT");
        }
        try {
            if (isAdded()) {
                this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
                this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
                this.token = SharedPref.getInstance(requireContext()).getToken();
                this.bloPartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
                this.bloAssemCode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
                this.bloStateCode = SharedPref.getInstance(requireContext()).getStateCode();
                this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
                this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
                this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
                this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
                this.stateName = SharedPref.getInstance(requireContext()).getStateName();
                this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
                this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
                this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
                this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
            }
        } catch (Exception unused3) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
        Logger.d("Token Deletion/Objecion", this.token);
        Logger.d("token_Device_comp", this.token);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        final long time2 = calendar2.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda4
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$2(datePicker, i, i2, i3);
            }
        };
        this.binding.correct.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.absent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.expired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.shifted.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$6(view);
            }
        });
        this.binding.repeated.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.binding.pwdRG1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$8(view);
            }
        });
        this.binding.chkOther.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.pwdRG2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$10(view);
            }
        });
        this.binding.metRG1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$11(view);
            }
        });
        this.binding.metRG2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$12(view);
            }
        });
        this.binding.photographRG1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$13(view);
            }
        });
        this.binding.photographRG2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda64
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$14(view);
            }
        });
        this.binding.isElectorRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$15(view);
            }
        });
        this.binding.notElectorRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$16(view);
            }
        });
        this.binding.isDobRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda67
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$17(view);
            }
        });
        this.binding.notDobRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$18(view);
            }
        });
        this.binding.isAddressRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$19(view);
            }
        });
        this.binding.notAddressRecordSameRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$20(view);
            }
        });
        this.binding.aadharRG1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$21(view);
            }
        });
        this.binding.aadharRG2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$22(view);
            }
        });
        this.binding.dobEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$23(onDateSetListener, time2, time, view);
            }
        });
        String str = this.acNo + " - " + this.asmblyName;
        this.binding.ACName.setText(str);
        this.binding.ReviewACName.setText(str);
        this.binding.districtName.setText(this.districtName);
        this.binding.ReviewdistrictName.setText(this.districtName);
        this.binding.partNumber.setText(this.partNo);
        this.binding.ReviewpartNumber.setText(this.partNo);
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$24(view);
            }
        });
        this.binding.rg1stpage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda9
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$25(radioGroup, i);
            }
        });
        this.binding.dobRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda10
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$26(radioGroup, i);
            }
        });
        this.binding.addressRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda12
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$27(radioGroup, i);
            }
        });
        this.binding.informationRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda13
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$28(radioGroup, i);
            }
        });
        this.binding.informationRg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda14
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$29(radioGroup, i);
            }
        });
        String str2 = new SimpleDateFormat(this.datePattern1, Locale.getDefault()).format(new Date());
        this.binding.verificationDateEd.setText(str2);
        this.binding.ReviewverificationDateEd.setText(str2);
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$30(view);
            }
        });
        this.binding.metInfo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda17
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$31(radioGroup, i);
            }
        });
        this.binding.fillForm6Btn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$32(view);
            }
        });
        this.binding.fillForm8Btn1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$33(view);
            }
        });
        this.binding.fillForm7Btn4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$34(view);
            }
        });
        this.binding.fillForm7Btn1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$35(view);
            }
        });
        this.binding.fillForm7Btn2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$36(view);
            }
        });
        this.binding.viewPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$37(view);
            }
        });
        this.binding.dobSelectBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$38(view);
            }
        });
        this.binding.addressSelectBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$39(view);
            }
        });
        try {
            if (isAdded()) {
                if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
                    this.binding.homeBtnIv.setImageResource(R.drawable.blo_outline_home_24_red);
                    eroElectoralDetails11(this.epicVerify, this.houseNo1);
                } else {
                    this.alertDialog.show();
                    this.binding.homeBtnIv.setImageResource(R.drawable.blo_outline_home_24_green);
                    eroElectoralDetails(this.epicVerify, this.houseNo1);
                }
            }
        } catch (Exception unused4) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
        initializingClicks();
        initClickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        updateIssueDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        this.binding.fillForm7Btn4.setVisibility(8);
        this.binding.fillForm7Btn1.setVisibility(8);
        this.binding.fillForm7Btn2.setVisibility(8);
        this.binding.photographRG1.setEnabled(true);
        this.binding.photographRG2.setEnabled(true);
        this.binding.isElectorRecordSameRb.setEnabled(true);
        this.binding.notElectorRecordSameRb.setEnabled(true);
        this.binding.isDobRecordSameRb.setEnabled(true);
        this.binding.notDobRecordSameRb.setEnabled(true);
        this.binding.isAddressRecordSameRb.setEnabled(true);
        this.binding.notAddressRecordSameRb.setEnabled(true);
        this.binding.pwdRG1.setEnabled(true);
        this.binding.pwdRG2.setEnabled(true);
        this.binding.metRG1.setEnabled(true);
        this.binding.metRG2.setEnabled(true);
        this.binding.aadharRG1.setEnabled(true);
        this.binding.aadharRG2.setEnabled(true);
        this.binding.ReviewphotographRG.clearCheck();
        this.binding.Reviewrg1stpage.clearCheck();
        this.binding.ReviewdobRg.clearCheck();
        this.binding.ReviewaddressRg.clearCheck();
        this.binding.ReviewinformationRg2.clearCheck();
        this.binding.photographRG.clearCheck();
        this.binding.rg1stpage.clearCheck();
        this.binding.dobRg.clearCheck();
        this.binding.addressRg.clearCheck();
        this.binding.informationRg2.clearCheck();
        this.binding.ReviewphotographRG1.setEnabled(true);
        this.binding.ReviewphotographRG2.setEnabled(true);
        this.binding.ReviewisElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewnotElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewisDobRecordSameRb.setEnabled(true);
        this.binding.ReviewnotDobRecordSameRb.setEnabled(true);
        this.binding.ReviewisAddressRecordSameRb.setEnabled(true);
        this.binding.ReviewnotAddressRecordSameRb.setEnabled(true);
        this.binding.reviewPwdRG1.setEnabled(true);
        this.binding.reviewPwdRG2.setEnabled(true);
        this.binding.reviewAadhaarRG1.setEnabled(true);
        this.binding.reviewAadhaarRG2.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        this.binding.fillForm7Btn4.setVisibility(8);
        this.binding.fillForm7Btn1.setVisibility(8);
        this.binding.fillForm7Btn2.setVisibility(8);
        this.binding.pwdLinearLayout.setVisibility(8);
        this.binding.reviewPWDLinearLayout.setVisibility(8);
        this.binding.photographRG1.setChecked(true);
        this.binding.photographRG2.setChecked(true);
        this.binding.photographRG1.setChecked(true);
        this.binding.photographRG2.setChecked(true);
        this.binding.isElectorRecordSameRb.setChecked(true);
        this.binding.notElectorRecordSameRb.setChecked(true);
        this.binding.isDobRecordSameRb.setChecked(true);
        this.binding.notDobRecordSameRb.setChecked(true);
        this.binding.isAddressRecordSameRb.setChecked(true);
        this.binding.notAddressRecordSameRb.setChecked(true);
        this.binding.pwdRG1.setChecked(true);
        this.binding.pwdRG2.setChecked(true);
        this.binding.photographRG1.setEnabled(false);
        this.binding.photographRG2.setEnabled(false);
        this.binding.isElectorRecordSameRb.setEnabled(false);
        this.binding.notElectorRecordSameRb.setEnabled(false);
        this.binding.isDobRecordSameRb.setEnabled(false);
        this.binding.notDobRecordSameRb.setEnabled(false);
        this.binding.isAddressRecordSameRb.setEnabled(false);
        this.binding.notAddressRecordSameRb.setEnabled(false);
        this.binding.pwdRG1.setEnabled(false);
        this.binding.pwdRG2.setEnabled(false);
        this.binding.metRG1.setEnabled(false);
        this.binding.metRG2.setEnabled(false);
        this.binding.aadharRG1.setEnabled(false);
        this.binding.aadharRG2.setEnabled(false);
        this.binding.ReviewphotographRG1.setEnabled(false);
        this.binding.ReviewphotographRG2.setEnabled(false);
        this.binding.ReviewisElectorRecordSameRb.setEnabled(false);
        this.binding.ReviewnotElectorRecordSameRb.setEnabled(false);
        this.binding.ReviewisDobRecordSameRb.setEnabled(false);
        this.binding.ReviewnotDobRecordSameRb.setEnabled(false);
        this.binding.ReviewisAddressRecordSameRb.setEnabled(false);
        this.binding.ReviewnotAddressRecordSameRb.setEnabled(false);
        this.binding.reviewPwdRG1.setEnabled(false);
        this.binding.reviewPwdRG2.setEnabled(false);
        this.binding.ReviewMetRG1.setEnabled(false);
        this.binding.ReviewMetRG2.setEnabled(false);
        this.binding.reviewAadhaarRG1.setEnabled(false);
        this.binding.reviewAadhaarRG2.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        this.binding.fillForm7Btn4.setVisibility(8);
        this.binding.fillForm7Btn1.setVisibility(0);
        this.binding.fillForm7Btn2.setVisibility(8);
        this.binding.photographRG1.setEnabled(true);
        this.binding.photographRG2.setEnabled(true);
        this.binding.isElectorRecordSameRb.setEnabled(true);
        this.binding.notElectorRecordSameRb.setEnabled(true);
        this.binding.isDobRecordSameRb.setEnabled(true);
        this.binding.notDobRecordSameRb.setEnabled(true);
        this.binding.isAddressRecordSameRb.setEnabled(true);
        this.binding.notAddressRecordSameRb.setEnabled(true);
        this.binding.pwdRG1.setEnabled(true);
        this.binding.pwdRG2.setEnabled(true);
        this.binding.aadharRG1.setEnabled(true);
        this.binding.aadharRG2.setEnabled(true);
        this.binding.ReviewphotographRG.clearCheck();
        this.binding.Reviewrg1stpage.clearCheck();
        this.binding.ReviewdobRg.clearCheck();
        this.binding.ReviewaddressRg.clearCheck();
        this.binding.ReviewinformationRg2.clearCheck();
        this.binding.photographRG.clearCheck();
        this.binding.rg1stpage.clearCheck();
        this.binding.dobRg.clearCheck();
        this.binding.addressRg.clearCheck();
        this.binding.ReviewphotographRG1.setEnabled(true);
        this.binding.ReviewphotographRG2.setEnabled(true);
        this.binding.ReviewisElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewnotElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewisDobRecordSameRb.setEnabled(true);
        this.binding.ReviewnotDobRecordSameRb.setEnabled(true);
        this.binding.ReviewisAddressRecordSameRb.setEnabled(true);
        this.binding.ReviewnotAddressRecordSameRb.setEnabled(true);
        this.binding.reviewPwdRG1.setEnabled(true);
        this.binding.reviewPwdRG2.setEnabled(true);
        this.binding.ReviewMetRG1.setEnabled(true);
        this.binding.ReviewMetRG2.setEnabled(true);
        this.binding.reviewAadhaarRG1.setEnabled(true);
        this.binding.reviewAadhaarRG2.setEnabled(true);
        this.binding.informationRg2.clearCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(View view) {
        this.binding.fillForm7Btn4.setVisibility(0);
        this.binding.fillForm7Btn1.setVisibility(8);
        this.binding.fillForm7Btn2.setVisibility(8);
        this.binding.photographRG1.setEnabled(true);
        this.binding.photographRG2.setEnabled(true);
        this.binding.isElectorRecordSameRb.setEnabled(true);
        this.binding.notElectorRecordSameRb.setEnabled(true);
        this.binding.isDobRecordSameRb.setEnabled(true);
        this.binding.notDobRecordSameRb.setEnabled(true);
        this.binding.isAddressRecordSameRb.setEnabled(true);
        this.binding.notAddressRecordSameRb.setEnabled(true);
        this.binding.pwdRG1.setEnabled(true);
        this.binding.pwdRG2.setEnabled(true);
        this.binding.aadharRG1.setEnabled(true);
        this.binding.aadharRG2.setEnabled(true);
        this.binding.ReviewphotographRG.clearCheck();
        this.binding.Reviewrg1stpage.clearCheck();
        this.binding.ReviewdobRg.clearCheck();
        this.binding.ReviewaddressRg.clearCheck();
        this.binding.ReviewinformationRg2.clearCheck();
        this.binding.photographRG.clearCheck();
        this.binding.rg1stpage.clearCheck();
        this.binding.dobRg.clearCheck();
        this.binding.addressRg.clearCheck();
        this.binding.informationRg2.clearCheck();
        this.binding.ReviewphotographRG1.setEnabled(true);
        this.binding.ReviewphotographRG2.setEnabled(true);
        this.binding.ReviewisElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewnotElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewisDobRecordSameRb.setEnabled(true);
        this.binding.ReviewnotDobRecordSameRb.setEnabled(true);
        this.binding.ReviewisAddressRecordSameRb.setEnabled(true);
        this.binding.ReviewnotAddressRecordSameRb.setEnabled(true);
        this.binding.reviewPwdRG1.setEnabled(true);
        this.binding.reviewPwdRG2.setEnabled(true);
        this.binding.ReviewMetRG1.setEnabled(true);
        this.binding.ReviewMetRG2.setEnabled(true);
        this.binding.reviewAadhaarRG1.setEnabled(true);
        this.binding.reviewAadhaarRG2.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        this.binding.fillForm7Btn4.setVisibility(8);
        this.binding.fillForm7Btn1.setVisibility(8);
        this.binding.fillForm7Btn2.setVisibility(0);
        this.binding.photographRG1.setEnabled(true);
        this.binding.photographRG2.setEnabled(true);
        this.binding.isElectorRecordSameRb.setEnabled(true);
        this.binding.notElectorRecordSameRb.setEnabled(true);
        this.binding.isDobRecordSameRb.setEnabled(true);
        this.binding.notDobRecordSameRb.setEnabled(true);
        this.binding.isAddressRecordSameRb.setEnabled(true);
        this.binding.notAddressRecordSameRb.setEnabled(true);
        this.binding.pwdRG1.setEnabled(true);
        this.binding.pwdRG2.setEnabled(true);
        this.binding.aadharRG1.setEnabled(true);
        this.binding.aadharRG2.setEnabled(true);
        this.binding.ReviewphotographRG.clearCheck();
        this.binding.Reviewrg1stpage.clearCheck();
        this.binding.ReviewdobRg.clearCheck();
        this.binding.ReviewaddressRg.clearCheck();
        this.binding.ReviewinformationRg2.clearCheck();
        this.binding.photographRG.clearCheck();
        this.binding.rg1stpage.clearCheck();
        this.binding.dobRg.clearCheck();
        this.binding.addressRg.clearCheck();
        this.binding.informationRg2.clearCheck();
        this.binding.ReviewphotographRG1.setEnabled(true);
        this.binding.ReviewphotographRG2.setEnabled(true);
        this.binding.ReviewisElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewnotElectorRecordSameRb.setEnabled(true);
        this.binding.ReviewisDobRecordSameRb.setEnabled(true);
        this.binding.ReviewnotDobRecordSameRb.setEnabled(true);
        this.binding.ReviewisAddressRecordSameRb.setEnabled(true);
        this.binding.ReviewnotAddressRecordSameRb.setEnabled(true);
        this.binding.reviewPwdRG1.setEnabled(true);
        this.binding.reviewPwdRG2.setEnabled(true);
        this.binding.reviewAadhaarRG1.setEnabled(true);
        this.binding.reviewAadhaarRG2.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(View view) {
        this.binding.pwdLinearLayout.setVisibility(0);
        this.binding.reviewPWDLinearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        if (this.binding.chkOther.isChecked()) {
            this.binding.EditText999.setVisibility(0);
            this.binding.ReviewPWDOtherDisablity.setVisibility(0);
        } else {
            this.binding.EditText999.setVisibility(8);
            this.binding.ReviewPWDOtherDisablity.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(View view) {
        this.binding.EditText99.setText("");
        this.binding.pwdLinearLayout.setVisibility(8);
        this.binding.reviewPWDLinearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(View view) {
        this.binding.metLinearLayout.setVisibility(0);
        this.binding.metInfo.setVisibility(0);
        this.binding.mobnumElector.setVisibility(0);
        this.binding.mobnumElector.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$12(View view) {
        this.binding.metLinearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(View view) {
        if (this.binding.photographRG1.isChecked() && this.binding.isElectorRecordSameRb.isChecked() && this.binding.isDobRecordSameRb.isChecked() && this.binding.isAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(View view) {
        if (this.binding.photographRG2.isChecked() || this.binding.notElectorRecordSameRb.isChecked() || this.binding.notDobRecordSameRb.isChecked() || this.binding.notAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(View view) {
        if (this.binding.photographRG1.isChecked() && this.binding.isElectorRecordSameRb.isChecked() && this.binding.isDobRecordSameRb.isChecked() && this.binding.isAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$16(View view) {
        if (this.binding.photographRG2.isChecked() || this.binding.notElectorRecordSameRb.isChecked() || this.binding.notDobRecordSameRb.isChecked() || this.binding.notAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$17(View view) {
        if (this.binding.photographRG1.isChecked() && this.binding.isElectorRecordSameRb.isChecked() && this.binding.isDobRecordSameRb.isChecked() && this.binding.isAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$18(View view) {
        if (this.binding.photographRG2.isChecked() || this.binding.notElectorRecordSameRb.isChecked() || this.binding.notDobRecordSameRb.isChecked() || this.binding.notAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$19(View view) {
        if (this.binding.photographRG1.isChecked() && this.binding.isElectorRecordSameRb.isChecked() && this.binding.isDobRecordSameRb.isChecked() && this.binding.isAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$20(View view) {
        if (this.binding.photographRG2.isChecked() || this.binding.notElectorRecordSameRb.isChecked() || this.binding.notDobRecordSameRb.isChecked() || this.binding.notAddressRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$21(View view) {
        this.binding.fillForm6Btn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$22(View view) {
        this.binding.fillForm6Btn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$23(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$24(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$25(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.rg1stpage.getChildAt(radioGroup.indexOfChild(this.binding.rg1stpage.findViewById(this.binding.rg1stpage.getCheckedRadioButtonId())));
        if (this.binding.ReviewisElectorRecordSameRb.isChecked() || this.binding.ReviewnotElectorRecordSameRb.isChecked()) {
            this.rb1st = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$26(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.dobRg.getChildAt(radioGroup.indexOfChild(this.binding.dobRg.findViewById(this.binding.dobRg.getCheckedRadioButtonId())));
        if (this.binding.isDobRecordSameRb.isChecked() || this.binding.notDobRecordSameRb.isChecked()) {
            this.rbDob = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$27(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.addressRg.getChildAt(radioGroup.indexOfChild(this.binding.addressRg.findViewById(this.binding.addressRg.getCheckedRadioButtonId())));
        if (this.binding.isAddressRecordSameRb.isChecked() || this.binding.notAddressRecordSameRb.isChecked()) {
            this.rbAddress = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$28(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.informationRg1.getChildAt(radioGroup.indexOfChild(this.binding.informationRg1.findViewById(this.binding.informationRg1.getCheckedRadioButtonId())));
        if (this.binding.correct.isChecked() || this.binding.absent.isChecked() || this.binding.expired.isChecked() || this.binding.shifted.isChecked() || this.binding.repeated.isChecked()) {
            this.rbInformation1 = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$29(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.informationRg2.getChildAt(radioGroup.indexOfChild(this.binding.informationRg2.findViewById(this.binding.informationRg2.getCheckedRadioButtonId())));
        if (this.binding.aboveDetailsRG1.isChecked() || this.binding.aboveDetailsRG2.isChecked()) {
            this.rbInformation2 = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$30(View view) {
        String str;
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.filerefphoto);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$31(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) this.binding.metInfo.getChildAt(radioGroup.indexOfChild(this.binding.metInfo.findViewById(this.binding.metInfo.getCheckedRadioButtonId())));
        if (this.binding.metRG1.isChecked() || this.binding.metRG2.isChecked()) {
            this.rbMetInfo = (String) radioButton.getText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$32(View view) {
        showAadhaarDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$33(View view) {
        showMigrationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$34(View view) {
        showDeletionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$35(View view) {
        showDeletionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$36(View view) {
        showDeletionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$37(View view) {
        try {
            if (isAdded()) {
                if (isNetworkAvailable(requireContext())) {
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.show();
                    }
                    getFile1(this.filerefphoto);
                    this.binding.personImage.setVisibility(0);
                    this.binding.imageEnlargeTv.setVisibility(0);
                    this.binding.viewPhoto.setVisibility(8);
                    return;
                }
                Toast.makeText(requireContext(), this.networkTag, 1).show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$38(View view) {
        try {
            if (isAdded()) {
                if (isNetworkAvailable(requireContext())) {
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.show();
                    }
                    getFile(this.filerefdob);
                    return;
                }
                Toast.makeText(requireContext(), this.networkTag, 1).show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$39(View view) {
        try {
            if (isAdded()) {
                if (isNetworkAvailable(requireContext())) {
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.show();
                    }
                    getFile2(this.filerefaddress);
                    return;
                }
                Toast.makeText(requireContext(), this.networkTag, 1).show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    public void eroElectoralDetails(String epic, String houseno) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.datePattern);
        Logger.e(this.h2hDetails1, "in get details..............................");
        HashMap map = new HashMap();
        map.put(this.epicNoString, epic);
        map.put(this.houseNoString, houseno);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).eroElectoralDetails(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.stateCode, "ANDROIDMOB", map).enqueue(new AnonymousClass2(simpleDateFormat, simpleDateFormat2, houseno, epic));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        final /* synthetic */ String val$epic;
        final /* synthetic */ String val$houseno;
        final /* synthetic */ SimpleDateFormat val$simpleDateFormat4;
        final /* synthetic */ SimpleDateFormat val$simpleDateFormat5;

        AnonymousClass2(final SimpleDateFormat val$simpleDateFormat4, final SimpleDateFormat val$simpleDateFormat5, final String val$houseno, final String val$epic) {
            this.val$simpleDateFormat4 = val$simpleDateFormat4;
            this.val$simpleDateFormat5 = val$simpleDateFormat5;
            this.val$houseno = val$houseno;
            this.val$epic = val$epic;
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                H2HDETAILS.this.payloadgetDetails = ((EronetResponse) response.body()).getPayload();
                if (H2HDETAILS.this.payloadgetDetails != null && !H2HDETAILS.this.payloadgetDetails.isEmpty()) {
                    LinkedTreeMap linkedTreeMap = (LinkedTreeMap) H2HDETAILS.this.payloadgetDetails.get(0);
                    H2HDETAILS.this.binding.mainheadingTv.setText("H. NO. " + linkedTreeMap.get(H2HDETAILS.this.houseNoString));
                    H2HDETAILS.this.binding.applicantNameTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameString)));
                    H2HDETAILS.this.binding.ReviewapplicantNameTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameString)));
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameL1String)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameL1String)).isEmpty()) {
                        H2HDETAILS.this.binding.applicantNameRegionalTv1.setText("");
                        H2HDETAILS.this.binding.ReviewapplicantNameRegionalTv1.setText("");
                    } else {
                        H2HDETAILS.this.binding.applicantNameRegionalTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameL1String)));
                        H2HDETAILS.this.binding.ReviewapplicantNameRegionalTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.applicantNameL1String)));
                    }
                    H2HDETAILS h2hdetails = H2HDETAILS.this;
                    h2hdetails.epicNumberNew = String.valueOf(linkedTreeMap.get(h2hdetails.epicNoString));
                    H2HDETAILS.this.binding.epicNumberTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.epicNoString)));
                    H2HDETAILS.this.binding.ReviewepicNumberTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.epicNoString)));
                    H2HDETAILS.this.sectionName1 = linkedTreeMap.get(H2HDETAILS.this.sectionNoString) + " - " + linkedTreeMap.get(H2HDETAILS.this.sectionNameString);
                    H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                    h2hdetails2.sectionNumberNew = String.valueOf(linkedTreeMap.get(h2hdetails2.sectionNoString));
                    H2HDETAILS.this.binding.sectionName.setText(H2HDETAILS.this.sectionName1);
                    H2HDETAILS.this.binding.ReviewSection.setText(H2HDETAILS.this.sectionName1);
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.genderString)).equals("M")) {
                        H2HDETAILS.this.binding.genderTv1.setText("Male");
                        H2HDETAILS.this.binding.ReviewgenderTv1.setText("Male");
                    } else if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.genderString)).equals("F")) {
                        H2HDETAILS.this.binding.genderTv1.setText(H2HDETAILS.this.femaleString);
                        H2HDETAILS.this.binding.ReviewgenderTv1.setText(H2HDETAILS.this.femaleString);
                    } else {
                        H2HDETAILS.this.binding.genderTv1.setText(H2HDETAILS.this.thirdGenderString);
                        H2HDETAILS.this.binding.ReviewgenderTv1.setText(H2HDETAILS.this.thirdGenderString);
                    }
                    H2HDETAILS.this.binding.relativeTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameString)));
                    H2HDETAILS.this.binding.ReviewrelativeTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameString)));
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameL1String)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameL1String)).isEmpty()) {
                        H2HDETAILS.this.binding.relativeRegionalTv1.setText("");
                        H2HDETAILS.this.binding.ReviewrelativeRegionalTv1.setText("");
                    } else {
                        H2HDETAILS.this.binding.relativeRegionalTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameL1String)));
                        H2HDETAILS.this.binding.ReviewrelativeRegionalTv1.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeNameL1String)));
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("F") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("FTHR")) {
                        H2HDETAILS.this.binding.relativeTypeTv.setText(H2HDETAILS.this.fatherString);
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText(H2HDETAILS.this.fatherString);
                    } else if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("M") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("MTHR")) {
                        H2HDETAILS.this.binding.relativeTypeTv.setText(H2HDETAILS.this.motherString);
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText(H2HDETAILS.this.motherString);
                    } else if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("H") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("HSBN")) {
                        H2HDETAILS.this.binding.relativeTypeTv.setText(H2HDETAILS.this.husbandString);
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText(H2HDETAILS.this.husbandString);
                    } else if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("W")) {
                        H2HDETAILS.this.binding.relativeTypeTv.setText("Wife");
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText("Wife");
                    } else if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)).equalsIgnoreCase("O")) {
                        H2HDETAILS.this.binding.relativeTypeTv.setText(H2HDETAILS.this.otherString);
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText(H2HDETAILS.this.otherString);
                    } else {
                        H2HDETAILS.this.binding.relativeTypeTv.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)));
                        H2HDETAILS.this.binding.ReviewrelativeTypeTv.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.relativeTypeString)));
                    }
                    String strValueOf = String.valueOf(linkedTreeMap.get("mobileNo"));
                    if (strValueOf.isEmpty() || strValueOf.equals("null")) {
                        H2HDETAILS.this.binding.mobnumTv.setText("");
                        H2HDETAILS.this.binding.ReviewmobnumTv.setText("");
                    } else {
                        if (strValueOf.startsWith("+91")) {
                            strValueOf = strValueOf.substring(3);
                        }
                        H2HDETAILS.this.binding.mobnumTv.setText("+91-" + strValueOf);
                        H2HDETAILS.this.binding.ReviewmobnumTv.setText("+91-" + strValueOf);
                    }
                    H2HDETAILS.this.aadhaarNo = String.valueOf(linkedTreeMap.get("aadharNo"));
                    if (H2HDETAILS.this.aadhaarNo.isEmpty() || H2HDETAILS.this.aadhaarNo.equals("null") || H2HDETAILS.this.aadhaarNo.equals("")) {
                        H2HDETAILS.this.binding.aadhaarNumber.setText("Not Received");
                        H2HDETAILS.this.binding.aadharRG2.setChecked(true);
                        H2HDETAILS.this.binding.aadharRG1.setChecked(false);
                        H2HDETAILS.this.binding.aadharRG1.setClickable(false);
                        H2HDETAILS.this.binding.fillForm6Btn.setVisibility(0);
                    } else {
                        H2HDETAILS.this.binding.aadhaarNumber.setText("Received");
                        H2HDETAILS.this.binding.aadharRG1.setChecked(true);
                        H2HDETAILS.this.binding.aadharRG2.setChecked(false);
                        H2HDETAILS.this.binding.aadharRG2.setClickable(false);
                        H2HDETAILS.this.binding.fillForm6Btn.setVisibility(8);
                    }
                    String strValueOf2 = String.valueOf(linkedTreeMap.get(H2HDETAILS.this.emailString));
                    H2HDETAILS h2hdetails3 = H2HDETAILS.this;
                    h2hdetails3.email33 = String.valueOf(linkedTreeMap.get(h2hdetails3.emailString));
                    if (strValueOf2.isEmpty() || strValueOf2.equals("null")) {
                        H2HDETAILS.this.binding.emailTv.setText("");
                        H2HDETAILS.this.binding.emailTv1.setVisibility(0);
                        H2HDETAILS.this.binding.emailTv.setVisibility(8);
                        H2HDETAILS.this.binding.ReviewemailTv.setText(H2HDETAILS.this.newEmailID);
                    } else {
                        H2HDETAILS.this.binding.emailTv.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.emailString)));
                        H2HDETAILS.this.binding.ReviewemailTv.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.emailString)));
                    }
                    String strValueOf3 = String.valueOf(linkedTreeMap.get("age"));
                    if (!strValueOf3.isEmpty() && !strValueOf3.equals("null")) {
                        H2HDETAILS.this.binding.ageTv.setText(String.valueOf(linkedTreeMap.get("age")));
                        H2HDETAILS.this.binding.ReviewageTv.setText(String.valueOf(linkedTreeMap.get("age")));
                    } else {
                        H2HDETAILS.this.binding.ageTv.setText("");
                        H2HDETAILS.this.binding.ReviewageTv.setText("");
                    }
                    if (!String.valueOf(linkedTreeMap.get("dob")).isEmpty() && !String.valueOf(linkedTreeMap.get("dob")).equals("null")) {
                        try {
                            H2HDETAILS.this.binding.dobTv.setText(this.val$simpleDateFormat4.format(this.val$simpleDateFormat5.parse(String.valueOf(linkedTreeMap.get("dob")))));
                            H2HDETAILS.this.binding.ReviewdobTv.setText(this.val$simpleDateFormat4.format(this.val$simpleDateFormat5.parse(String.valueOf(linkedTreeMap.get("dob")))));
                        } catch (ParseException e) {
                            Logger.e(H2HDETAILS.this.h2hDetails1, e.getMessage());
                        }
                    } else {
                        H2HDETAILS.this.binding.dobTv.setText("");
                    }
                    String strValueOf4 = String.valueOf(linkedTreeMap.get(H2HDETAILS.this.houseNoString));
                    String strValueOf5 = String.valueOf(linkedTreeMap.get("localitySreet"));
                    H2HDETAILS h2hdetails4 = H2HDETAILS.this;
                    h2hdetails4.sectionName = String.valueOf(linkedTreeMap.get(h2hdetails4.sectionNameString));
                    H2HDETAILS.this.village = String.valueOf(linkedTreeMap.get("village"));
                    H2HDETAILS.this.postOffice = String.valueOf(linkedTreeMap.get("postOffice"));
                    H2HDETAILS.this.pinCode = String.valueOf(linkedTreeMap.get("pinCode"));
                    H2HDETAILS.this.tehsil = String.valueOf(linkedTreeMap.get("tehsilTalukaMandal"));
                    if (H2HDETAILS.this.sectionName.isEmpty() || H2HDETAILS.this.sectionName.equals("null")) {
                        H2HDETAILS.this.newAddress = this.val$houseno + ", " + H2HDETAILS.this.asmblyName + ", " + H2HDETAILS.this.districtName + ", " + H2HDETAILS.this.stateName;
                    } else {
                        H2HDETAILS.this.newAddress = this.val$houseno + ", " + H2HDETAILS.this.sectionName + ", " + H2HDETAILS.this.asmblyName + ", " + H2HDETAILS.this.districtName + ", " + H2HDETAILS.this.stateName;
                    }
                    if (strValueOf5.isEmpty() || strValueOf5.equals("null")) {
                        H2HDETAILS.this.binding.streetTv.setText(H2HDETAILS.this.newAddress);
                        H2HDETAILS.this.binding.ReviewstreetTv.setText(H2HDETAILS.this.newAddress);
                    } else {
                        if (H2HDETAILS.this.village.isEmpty() || H2HDETAILS.this.village.equals("null")) {
                            H2HDETAILS.this.village = null;
                        }
                        if (H2HDETAILS.this.postOffice.isEmpty() || H2HDETAILS.this.postOffice.equals("null")) {
                            H2HDETAILS.this.postOffice = null;
                        }
                        if (H2HDETAILS.this.pinCode.isEmpty() || H2HDETAILS.this.pinCode.equals("null")) {
                            H2HDETAILS.this.pinCode = null;
                        }
                        if (H2HDETAILS.this.tehsil.isEmpty() || H2HDETAILS.this.tehsil.equals("null")) {
                            H2HDETAILS.this.tehsil = null;
                        }
                        if (strValueOf4.isEmpty() || strValueOf4.equals("null")) {
                            strValueOf4 = null;
                        }
                        String str = strValueOf4 + ", " + strValueOf5 + ", " + H2HDETAILS.this.village + ", " + H2HDETAILS.this.postOffice + ", " + H2HDETAILS.this.tehsil + ", " + H2HDETAILS.this.asmblyName + ", " + H2HDETAILS.this.districtName + ", " + H2HDETAILS.this.stateName + ", " + H2HDETAILS.this.pinCode;
                        if (!str.contains("null")) {
                            H2HDETAILS.this.binding.streetTv.setText(str);
                            H2HDETAILS.this.binding.ReviewstreetTv.setText(str);
                        } else {
                            H2HDETAILS.this.binding.streetTv.setText(H2HDETAILS.this.newAddress);
                            H2HDETAILS.this.binding.ReviewstreetTv.setText(H2HDETAILS.this.newAddress);
                        }
                    }
                    H2HDETAILS.this.filerefphoto = linkedTreeMap.get("photo").toString();
                    H2HDETAILS.this.filerefdob = linkedTreeMap.get("dobAttachment").toString();
                    H2HDETAILS.this.filerefaddress = linkedTreeMap.get("addressAttachment").toString();
                    H2HDETAILS.this.alertDialog.dismiss();
                    if (String.valueOf(linkedTreeMap.get("pwd")).equals("null") || String.valueOf(linkedTreeMap.get("pwd")).isEmpty() || String.valueOf(linkedTreeMap.get("pwd")).equals("N")) {
                        H2HDETAILS.this.binding.pwdRG2.setChecked(true);
                        H2HDETAILS.this.binding.reviewPwdRG2.setChecked(true);
                    } else {
                        H2HDETAILS.this.binding.pwdRG1.setChecked(true);
                        H2HDETAILS.this.binding.reviewPwdRG1.setChecked(true);
                        H2HDETAILS.this.binding.pwdLinearLayout.setVisibility(0);
                        H2HDETAILS.this.binding.reviewPWDLinearLayout.setVisibility(0);
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityPercentagelString)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityPercentagelString)).isEmpty()) {
                        H2HDETAILS.this.binding.EditText99.setText("");
                        H2HDETAILS.this.binding.ReviewPWDPercentage.setText("");
                    } else {
                        H2HDETAILS.this.binding.EditText99.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityPercentagelString)));
                        H2HDETAILS.this.binding.ReviewPWDPercentage.setText(String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityPercentagelString)));
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.otherDisabilityString)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.otherDisabilityString)).isEmpty() || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.otherDisabilityString)).equals("N")) {
                        H2HDETAILS.this.binding.chkOther.setChecked(false);
                        H2HDETAILS.this.binding.reviewChkOther.setChecked(false);
                    } else {
                        H2HDETAILS.this.binding.chkOther.setChecked(true);
                        H2HDETAILS.this.binding.reviewChkOther.setChecked(true);
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityLocomotorString)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityLocomotorString)).isEmpty() || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityLocomotorString)).equals("N")) {
                        H2HDETAILS.this.binding.chkLocomotive.setChecked(false);
                        H2HDETAILS.this.binding.reviewChkLocomotive.setChecked(false);
                    } else {
                        H2HDETAILS.this.binding.chkLocomotive.setChecked(true);
                        H2HDETAILS.this.binding.reviewChkLocomotive.setChecked(true);
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilitySpeechHearingString)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilitySpeechHearingString)).isEmpty() || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilitySpeechHearingString)).equals("N")) {
                        H2HDETAILS.this.binding.chkDeafDumb.setChecked(false);
                        H2HDETAILS.this.binding.reviewChkDeafDumb.setChecked(false);
                    } else {
                        H2HDETAILS.this.binding.chkDeafDumb.setChecked(true);
                        H2HDETAILS.this.binding.reviewChkDeafDumb.setChecked(true);
                    }
                    if (String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityVisuallyString)).equals("null") || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityVisuallyString)).isEmpty() || String.valueOf(linkedTreeMap.get(H2HDETAILS.this.disabilityVisuallyString)).equals("N")) {
                        H2HDETAILS.this.binding.chkVisual.setChecked(false);
                        H2HDETAILS.this.binding.reviewChkVisual.setChecked(false);
                        return;
                    } else {
                        H2HDETAILS.this.binding.chkVisual.setChecked(true);
                        H2HDETAILS.this.binding.reviewChkVisual.setChecked(true);
                        return;
                    }
                }
                H2HDETAILS h2hdetails5 = H2HDETAILS.this;
                h2hdetails5.showdialogFinal(h2hdetails5.alert, H2HDETAILS.this.noDataString);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                        Context contextRequireContext = H2HDETAILS.this.requireContext();
                        String str2 = H2HDETAILS.this.refreshToken;
                        final String str3 = this.val$epic;
                        final String str4 = this.val$houseno;
                        commomUtility.getRefreshToken(contextRequireContext, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$2$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str5, String str6) {
                                this.f$0.lambda$onResponse$2(str3, str4, i, str5, str6);
                            }
                        });
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                    return;
                }
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                H2HDETAILS h2hdetails6 = H2HDETAILS.this;
                h2hdetails6.showdialogFinal(h2hdetails6.alert, strOptString);
                Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
            } catch (IOException | JSONException e2) {
                Logger.e(H2HDETAILS.this.h2hDetails1, e2.getMessage());
                if (response != null && response.message() != null) {
                    H2HDETAILS h2hdetails7 = H2HDETAILS.this;
                    h2hdetails7.showdialogFinal(h2hdetails7.alert, response.message());
                } else {
                    H2HDETAILS h2hdetails8 = H2HDETAILS.this;
                    h2hdetails8.showdialogFinal(h2hdetails8.alert, H2HDETAILS.this.noDataString);
                }
            }
            H2HDETAILS.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            H2HDETAILS.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2, int i, String str3, String str4) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$2$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str3;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str4);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str3);
            H2HDETAILS.this.eroElectoralDetails(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            H2HDETAILS.this.alertDialog.dismiss();
            H2HDETAILS h2hdetails = H2HDETAILS.this;
            h2hdetails.showdialogFinal(h2hdetails.alert, t.getMessage());
        }
    }

    public void eroElectoralDetails11(String epic, String houseno) {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.datePattern);
        List<PartElectorDetailsModel.Items> nonVerifiedElectorDetails22 = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getNonVerifiedElectorDetails22(epic);
        this.binding.mainheadingTv.setText("H. NO. " + nonVerifiedElectorDetails22.get(0).getHouseNo());
        this.binding.applicantNameTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantName()));
        this.binding.ReviewapplicantNameTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantName()));
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantNameL1()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantNameL1()).isEmpty()) {
            this.binding.applicantNameRegionalTv1.setText("");
            this.binding.ReviewapplicantNameRegionalTv1.setText("");
        } else {
            this.binding.applicantNameRegionalTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantNameL1()));
            this.binding.ReviewapplicantNameRegionalTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getApplicantNameL1()));
        }
        this.epicNumberNew = nonVerifiedElectorDetails22.get(0).getEpicNo();
        this.binding.epicNumberTv1.setText(this.epicNumberNew);
        this.binding.ReviewepicNumberTv1.setText(this.epicNumberNew);
        this.partSerialNumber = String.valueOf(nonVerifiedElectorDetails22.get(0).getPartSerialNumber());
        this.sectionName1 = nonVerifiedElectorDetails22.get(0).getSectionNo() + " - " + nonVerifiedElectorDetails22.get(0).getSectionName();
        this.sectionNumberNew = String.valueOf(nonVerifiedElectorDetails22.get(0).getSectionNo());
        this.binding.sectionName.setText(this.sectionName1);
        this.binding.ReviewSection.setText(this.sectionName1);
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getGender()).equals("M")) {
            this.binding.genderTv1.setText("Male");
            this.binding.ReviewgenderTv1.setText("Male");
        } else if (String.valueOf(nonVerifiedElectorDetails22.get(0).getGender()).equals("F")) {
            this.binding.genderTv1.setText(this.femaleString);
            this.binding.ReviewgenderTv1.setText(this.femaleString);
        } else {
            this.binding.genderTv1.setText(this.thirdGenderString);
            this.binding.ReviewgenderTv1.setText(this.thirdGenderString);
        }
        this.binding.relativeTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeName()));
        this.binding.ReviewrelativeTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeName()));
        if (nonVerifiedElectorDetails22.get(0).getRelativeNameL1().equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeNameL1()).isEmpty()) {
            this.binding.relativeRegionalTv1.setText("");
            this.binding.ReviewrelativeRegionalTv1.setText("");
        } else {
            this.binding.relativeRegionalTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeNameL1()));
            this.binding.ReviewrelativeRegionalTv1.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeNameL1()));
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("F") || String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("FTHR")) {
            this.binding.relativeTypeTv.setText(this.fatherString);
            this.binding.ReviewrelativeTypeTv.setText(this.fatherString);
        } else if (String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("M") || String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("MTHR")) {
            this.binding.relativeTypeTv.setText(this.motherString);
            this.binding.ReviewrelativeTypeTv.setText(this.motherString);
        } else if (String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("H") || String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("HSBN")) {
            this.binding.relativeTypeTv.setText(this.husbandString);
            this.binding.ReviewrelativeTypeTv.setText(this.husbandString);
        } else if (String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("W")) {
            this.binding.relativeTypeTv.setText("Wife");
            this.binding.ReviewrelativeTypeTv.setText("Wife");
        } else if (String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()).equalsIgnoreCase("O")) {
            this.binding.relativeTypeTv.setText(this.otherString);
            this.binding.ReviewrelativeTypeTv.setText(this.otherString);
        } else {
            this.binding.relativeTypeTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()));
            this.binding.ReviewrelativeTypeTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getRelativeType()));
        }
        String strValueOf = String.valueOf(nonVerifiedElectorDetails22.get(0).getMobileNo());
        if (strValueOf.isEmpty() || strValueOf.equals("null")) {
            this.binding.mobnumTv.setText("");
            this.binding.ReviewmobnumTv.setText("");
        } else {
            if (strValueOf.startsWith("+91")) {
                strValueOf = strValueOf.substring(3);
            }
            this.binding.mobnumTv.setText("+91-" + strValueOf);
            this.binding.ReviewmobnumTv.setText("+91-" + strValueOf);
        }
        String strValueOf2 = String.valueOf(nonVerifiedElectorDetails22.get(0).getAadharNo());
        this.aadhaarNo = strValueOf2;
        if (strValueOf2.isEmpty() || this.aadhaarNo.equals("null") || this.aadhaarNo.equals("")) {
            this.binding.aadhaarNumber.setText("Not Received");
            this.binding.aadharRG2.setChecked(true);
            this.binding.aadharRG1.setChecked(false);
            this.binding.aadharRG1.setClickable(false);
            this.binding.fillForm6Btn.setVisibility(0);
        } else {
            this.binding.aadhaarNumber.setText("Received");
            this.binding.aadharRG1.setChecked(true);
            this.binding.aadharRG2.setChecked(false);
            this.binding.aadharRG2.setClickable(false);
            this.binding.fillForm6Btn.setVisibility(8);
        }
        String strValueOf3 = String.valueOf(nonVerifiedElectorDetails22.get(0).getEmail());
        this.email33 = String.valueOf(nonVerifiedElectorDetails22.get(0).getEmail());
        if (strValueOf3.isEmpty() || strValueOf3.equals("null")) {
            this.binding.emailTv.setText("");
            this.binding.emailTv1.setVisibility(0);
            this.binding.emailTv.setVisibility(8);
            this.binding.ReviewemailTv.setText(this.newEmailID);
        } else {
            this.binding.emailTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getEmail()));
            this.binding.ReviewemailTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getEmail()));
        }
        String strValueOf4 = String.valueOf(nonVerifiedElectorDetails22.get(0).getAge());
        if (strValueOf4.isEmpty() || strValueOf4.equals("null")) {
            this.binding.ageTv.setText("");
            this.binding.ReviewageTv.setText("");
        } else {
            this.binding.ageTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getAge()));
            this.binding.ReviewageTv.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getAge()));
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getDob()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getDob()).equals("null")) {
            this.binding.dobTv.setText("");
            this.finalDob = "";
        } else {
            try {
                this.finalDob = String.valueOf(nonVerifiedElectorDetails22.get(0).getDob());
                this.binding.dobTv.setText(simpleDateFormat.format(simpleDateFormat2.parse(String.valueOf(nonVerifiedElectorDetails22.get(0).getDob()))));
                this.binding.ReviewdobTv.setText(simpleDateFormat.format(simpleDateFormat2.parse(String.valueOf(nonVerifiedElectorDetails22.get(0).getDob()))));
            } catch (ParseException e) {
                Logger.e(this.h2hDetails1, e.getMessage());
            }
        }
        String strValueOf5 = String.valueOf(nonVerifiedElectorDetails22.get(0).getHouseNo());
        String strValueOf6 = String.valueOf(nonVerifiedElectorDetails22.get(0).getLocalitySreet());
        this.sectionName = String.valueOf(nonVerifiedElectorDetails22.get(0).getSectionName());
        this.village = String.valueOf(nonVerifiedElectorDetails22.get(0).getVillage());
        this.postOffice = String.valueOf(nonVerifiedElectorDetails22.get(0).getPostOffice());
        this.pinCode = String.valueOf(nonVerifiedElectorDetails22.get(0).getPinCode());
        this.tehsil = String.valueOf(nonVerifiedElectorDetails22.get(0).getTehsilTalukaMandal());
        if (this.sectionName.isEmpty() || this.sectionName.equals("null")) {
            str = houseno + ", " + this.asmblyName + ", " + this.districtName + ", " + this.stateName;
        } else {
            str = houseno + ", " + this.sectionName + ", " + this.asmblyName + ", " + this.districtName + ", " + this.stateName;
        }
        if (strValueOf6.isEmpty() || strValueOf6.equals("null")) {
            this.binding.streetTv.setText(str);
            this.binding.ReviewstreetTv.setText(str);
        } else {
            if (this.village.isEmpty() || this.village.equals("null")) {
                this.village = null;
            }
            if (this.postOffice.isEmpty() || this.postOffice.equals("null")) {
                this.postOffice = null;
            }
            if (this.pinCode.isEmpty() || this.pinCode.equals("null")) {
                this.pinCode = null;
            }
            if (this.tehsil.isEmpty() || this.tehsil.equals("null")) {
                this.tehsil = null;
            }
            if (strValueOf5.isEmpty() || strValueOf5.equals("null")) {
                strValueOf5 = null;
            }
            String str2 = strValueOf5 + ", " + strValueOf6 + ", " + this.village + ", " + this.postOffice + ", " + this.tehsil + ", " + this.asmblyName + ", " + this.districtName + ", " + this.stateName + ", " + this.pinCode;
            if (!str2.contains("null")) {
                this.binding.streetTv.setText(str2);
                this.binding.ReviewstreetTv.setText(str2);
            } else {
                this.binding.streetTv.setText(str);
                this.binding.ReviewstreetTv.setText(str);
            }
        }
        this.filerefphoto = nonVerifiedElectorDetails22.get(0).getPhoto();
        this.filerefdob = nonVerifiedElectorDetails22.get(0).getDobAttachment();
        this.filerefaddress = nonVerifiedElectorDetails22.get(0).getAddressAttachment();
        Logger.e(this.h2hDetails1, "Get file 2 error" + this.filerefaddress + ">>>" + this.filerefdob + ">>>" + this.filerefphoto);
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getPwd()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getPwd()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getPwd()).equals("N")) {
            this.binding.pwdRG2.setChecked(true);
            this.binding.reviewPwdRG2.setChecked(true);
        } else {
            this.binding.pwdRG1.setChecked(true);
            this.binding.reviewPwdRG1.setChecked(true);
            this.binding.pwdLinearLayout.setVisibility(0);
            this.binding.reviewPWDLinearLayout.setVisibility(0);
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityPercentage()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityPercentage()).isEmpty()) {
            this.binding.EditText99.setText("");
            this.binding.ReviewPWDPercentage.setText("");
        } else {
            this.binding.EditText99.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityPercentage()));
            this.binding.ReviewPWDPercentage.setText(String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityPercentage()));
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getOtherDisability()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getOtherDisability()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getOtherDisability()).equals("N")) {
            this.binding.chkOther.setChecked(false);
            this.binding.reviewChkOther.setChecked(false);
        } else {
            this.binding.chkOther.setChecked(true);
            this.binding.reviewChkOther.setChecked(true);
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityLocomotor()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityLocomotor()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityLocomotor()).equals("N")) {
            this.binding.chkLocomotive.setChecked(false);
            this.binding.reviewChkLocomotive.setChecked(false);
        } else {
            this.binding.chkLocomotive.setChecked(true);
            this.binding.reviewChkLocomotive.setChecked(true);
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilitySpeechHearing()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilitySpeechHearing()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilitySpeechHearing()).equals("N")) {
            this.binding.chkDeafDumb.setChecked(false);
            this.binding.reviewChkDeafDumb.setChecked(false);
        } else {
            this.binding.chkDeafDumb.setChecked(true);
            this.binding.reviewChkDeafDumb.setChecked(true);
        }
        if (String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityVisually()).equals("null") || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityVisually()).isEmpty() || String.valueOf(nonVerifiedElectorDetails22.get(0).getDisabilityVisually()).equals("N")) {
            this.binding.chkVisual.setChecked(false);
            this.binding.reviewChkVisual.setChecked(false);
        } else {
            this.binding.chkVisual.setChecked(true);
            this.binding.reviewChkVisual.setChecked(true);
        }
        this.alertDialog.dismiss();
    }

    public void updateIssueDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy", Locale.US);
        this.binding.dobEd.setText(simpleDateFormat.format(this.dobcalendar.getTime()));
        this.binding.ReviewdobEd.setText(simpleDateFormat.format(this.dobcalendar.getTime()));
        this.dobYear = simpleDateFormat.format(this.dobcalendar.getTime());
    }

    public void getSection(String stateCode, String token, String asmblyNo, String partNo) {
        Logger.e(this.h2hDetails1, "in house fetch..............................");
        try {
            this.sectionNolist.clear();
            this.sectionNolist.add("Select Section No. & Name");
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token, this.atkband, this.rtkband, "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass3());
        } catch (Exception e) {
            Logger.d(this.contentString, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JSONArray> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                JSONArray jSONArray = (JSONArray) response.body();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = H2HDETAILS.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    H2HDETAILS.this.sectionNumber = asJsonObject.get(H2HDETAILS.this.sectionNoString).getAsInt() + " - " + asJsonObject.get(H2HDETAILS.this.sectionNameString).getAsString();
                    Logger.e(H2HDETAILS.this.h2hDetails1, "SectionNo " + H2HDETAILS.this.sectionNumber);
                    arrayList.add(String.valueOf(H2HDETAILS.this.sectionNumber));
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$3$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return H2HDETAILS.AnonymousClass3.lambda$onResponse$0((String) obj, (String) obj2);
                    }
                });
                H2HDETAILS.this.sectionNolist.addAll(arrayList);
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                Logger.e(H2HDETAILS.this.h2hDetails1, "Form_6_FVR_FORM_SUBMITTION_Error" + strOptString);
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        H2HDETAILS.this.commomUtility.showMessageWithTitleOK(H2HDETAILS.this.requireContext(), "Section Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$3$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                } catch (Exception unused) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                }
            } catch (IOException | JSONException e) {
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        H2HDETAILS.this.commomUtility.showMessageWithTitleOK(H2HDETAILS.this.requireContext(), "Section Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$3$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                } catch (Exception unused2) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                }
                Logger.d("", e.getMessage());
            }
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag + t.getMessage());
        }
    }

    public void getFile(String fileref) {
        Logger.e(this.h2hDetails1, "in getFile..............................");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.bloAppString, "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                H2HDETAILS.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (H2HDETAILS.this.base64element != null && !H2HDETAILS.this.base64element.isEmpty() && !H2HDETAILS.this.base64element.equals("null") && H2HDETAILS.this.base64element != null) {
                    byte[] bArrDecode = Base64.decode(H2HDETAILS.this.base64element, 0);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    if (H2HDETAILS.this.filerefdob.contains(".pdf")) {
                        try {
                            H2HDETAILS h2hdetails = H2HDETAILS.this;
                            h2hdetails.showpdfDialog(bArrDecode, h2hdetails.filerefdob);
                            if (H2HDETAILS.this.alertDialog != null) {
                                H2HDETAILS.this.alertDialog.dismiss();
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(H2HDETAILS.this.getResources(), R.drawable.blo_pfd_thumbnail);
                            H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                            h2hdetails2.showImageDialog(bitmapDecodeResource, h2hdetails2.filerefdob);
                            H2HDETAILS.this.alertDialog.dismiss();
                            Logger.e(H2HDETAILS.this.h2hDetails1, e.getMessage());
                            H2HDETAILS.this.alertDialog.dismiss();
                            return;
                        }
                    }
                    if (H2HDETAILS.this.alertDialog != null) {
                        H2HDETAILS.this.alertDialog.dismiss();
                    }
                    H2HDETAILS h2hdetails3 = H2HDETAILS.this;
                    h2hdetails3.showImageDialog(bitmapDecodeByteArray, h2hdetails3.filerefdob);
                    return;
                }
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                H2HDETAILS h2hdetails4 = H2HDETAILS.this;
                h2hdetails4.showdialog1(h2hdetails4.alert, H2HDETAILS.this.noDocAvlblString);
                return;
            }
            if (response.code() == 401) {
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                        Context contextRequireContext = H2HDETAILS.this.requireContext();
                        String str = H2HDETAILS.this.refreshToken;
                        final String str2 = this.val$fileref;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$4$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str3, String str4) {
                                this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                            }
                        });
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                    return;
                }
            }
            if (H2HDETAILS.this.alertDialog != null) {
                H2HDETAILS.this.alertDialog.dismiss();
            }
            H2HDETAILS h2hdetails5 = H2HDETAILS.this;
            h2hdetails5.showdialog1(h2hdetails5.alert, H2HDETAILS.this.noDocAvlblString);
            try {
                Logger.e(H2HDETAILS.this.h2hDetails1, new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString));
            } catch (Exception e2) {
                Logger.e(H2HDETAILS.this.h2hDetails1, e2.getMessage());
                if (response.message() != null) {
                    H2HDETAILS h2hdetails6 = H2HDETAILS.this;
                    h2hdetails6.showdialogFinal(h2hdetails6.alert, response.message());
                } else {
                    H2HDETAILS h2hdetails7 = H2HDETAILS.this;
                    h2hdetails7.showdialogFinal(h2hdetails7.alert, H2HDETAILS.this.noDataString);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str2;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str2);
            H2HDETAILS.this.getFile(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (H2HDETAILS.this.alertDialog != null) {
                H2HDETAILS.this.alertDialog.dismiss();
            }
            Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag + t.getMessage());
        }
    }

    public void getFile1(String fileref) {
        Logger.e(this.h2hDetails1, "in getFile1..............................");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.bloAppString, "ANDROIDMOB").enqueue(new AnonymousClass5(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass5(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                H2HDETAILS.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(H2HDETAILS.this.base64element1, 0);
                H2HDETAILS.this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                if (H2HDETAILS.this.base64element1.isEmpty() || H2HDETAILS.this.base64element1.equals("null")) {
                    H2HDETAILS.this.binding.personImage.setImageBitmap(BitmapFactory.decodeResource(H2HDETAILS.this.getResources(), R.drawable.blo_dummy_image));
                    if (H2HDETAILS.this.alertDialog != null) {
                        H2HDETAILS.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                        Context contextRequireContext = H2HDETAILS.this.requireContext();
                        String str = H2HDETAILS.this.refreshToken;
                        final String str2 = this.val$fileref;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$5$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str3, String str4) {
                                this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                            }
                        });
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                    return;
                }
            }
            try {
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                Logger.e(H2HDETAILS.this.h2hDetails1, new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString));
            } catch (IOException | JSONException e) {
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                Logger.e(H2HDETAILS.this.h2hDetails1, e.getMessage());
                if (response.message() != null) {
                    H2HDETAILS h2hdetails = H2HDETAILS.this;
                    h2hdetails.showdialogFinal(h2hdetails.alert, response.message());
                } else {
                    H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                    h2hdetails2.showdialogFinal(h2hdetails2.alert, H2HDETAILS.this.noDataString);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str2;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str2);
            H2HDETAILS.this.getFile1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag + t.getMessage());
            if (H2HDETAILS.this.alertDialog != null) {
                H2HDETAILS.this.alertDialog.dismiss();
            }
            H2HDETAILS h2hdetails = H2HDETAILS.this;
            h2hdetails.showdialog1(h2hdetails.alert, t.getMessage());
        }
    }

    public void getFile2(String fileref) {
        Logger.e(this.h2hDetails1, "in getFile2..............................");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.bloAppString, "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                H2HDETAILS.this.base64element2 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (H2HDETAILS.this.base64element2 != null && !H2HDETAILS.this.base64element2.isEmpty() && !H2HDETAILS.this.base64element2.equals("null") && H2HDETAILS.this.base64element2 != null) {
                    byte[] bArrDecode = Base64.decode(H2HDETAILS.this.base64element2, 0);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    if (H2HDETAILS.this.filerefaddress.contains(".pdf")) {
                        try {
                            if (H2HDETAILS.this.alertDialog != null) {
                                H2HDETAILS.this.alertDialog.dismiss();
                            }
                            H2HDETAILS h2hdetails = H2HDETAILS.this;
                            h2hdetails.showpdfDialog(bArrDecode, h2hdetails.filerefaddress);
                            return;
                        } catch (Exception e) {
                            if (H2HDETAILS.this.alertDialog != null) {
                                H2HDETAILS.this.alertDialog.dismiss();
                            }
                            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(H2HDETAILS.this.getResources(), R.drawable.blo_pfd_thumbnail);
                            H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                            h2hdetails2.showImageDialog(bitmapDecodeResource, h2hdetails2.filerefaddress);
                            Logger.e(H2HDETAILS.this.h2hDetails1, e.getMessage());
                            return;
                        }
                    }
                    if (H2HDETAILS.this.alertDialog != null) {
                        H2HDETAILS.this.alertDialog.dismiss();
                    }
                    H2HDETAILS h2hdetails3 = H2HDETAILS.this;
                    h2hdetails3.showImageDialog(bitmapDecodeByteArray, h2hdetails3.filerefaddress);
                    return;
                }
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                H2HDETAILS h2hdetails4 = H2HDETAILS.this;
                h2hdetails4.showdialog1(h2hdetails4.alert, H2HDETAILS.this.noDocAvlblString);
                return;
            }
            if (response.code() == 401) {
                try {
                    if (H2HDETAILS.this.isAdded()) {
                        CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                        Context contextRequireContext = H2HDETAILS.this.requireContext();
                        String str = H2HDETAILS.this.refreshToken;
                        final String str2 = this.val$fileref;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$6$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str3, String str4) {
                                this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                            }
                        });
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag);
                    return;
                }
            }
            H2HDETAILS h2hdetails5 = H2HDETAILS.this;
            h2hdetails5.showdialog1(h2hdetails5.alert, H2HDETAILS.this.noDocAvlblString);
            try {
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                Logger.e(H2HDETAILS.this.h2hDetails1, new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString));
            } catch (Exception e2) {
                if (H2HDETAILS.this.alertDialog != null) {
                    H2HDETAILS.this.alertDialog.dismiss();
                }
                Logger.e(H2HDETAILS.this.h2hDetails1, e2.getMessage());
                if (response.message() != null) {
                    H2HDETAILS h2hdetails6 = H2HDETAILS.this;
                    h2hdetails6.showdialogFinal(h2hdetails6.alert, response.message());
                } else {
                    H2HDETAILS h2hdetails7 = H2HDETAILS.this;
                    h2hdetails7.showdialogFinal(h2hdetails7.alert, H2HDETAILS.this.noDataString);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str2;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str2);
            H2HDETAILS.this.getFile2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (H2HDETAILS.this.alertDialog != null) {
                H2HDETAILS.this.alertDialog.dismiss();
            }
            Logger.e(H2HDETAILS.this.h2hDetails1, H2HDETAILS.this.comingTag + t.getMessage());
            H2HDETAILS h2hdetails = H2HDETAILS.this;
            h2hdetails.showdialog1(h2hdetails.alert, t.getMessage());
        }
    }

    private void previewDataChecks() {
        if (this.binding.photographRG1.isChecked()) {
            this.binding.ReviewphotographRG1.setChecked(true);
            this.binding.fillForm8Btn1.setVisibility(8);
        } else if (this.binding.photographRG2.isChecked()) {
            this.binding.ReviewphotographRG2.setChecked(true);
            this.binding.fillForm8Btn1.setVisibility(0);
        }
        if (this.binding.isElectorRecordSameRb.isChecked()) {
            this.binding.ReviewisElectorRecordSameRb.setChecked(true);
            this.binding.fillForm8Btn1.setVisibility(8);
        } else if (this.binding.notElectorRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
            this.binding.ReviewnotElectorRecordSameRb.setChecked(true);
        }
        if (this.binding.isDobRecordSameRb.isChecked()) {
            this.binding.ReviewisDobRecordSameRb.setChecked(true);
            this.binding.fillForm8Btn1.setVisibility(8);
        } else if (this.binding.notDobRecordSameRb.isChecked()) {
            this.binding.fillForm8Btn1.setVisibility(0);
            this.binding.ReviewnotDobRecordSameRb.setChecked(true);
        }
        if (this.binding.isAddressRecordSameRb.isChecked()) {
            this.binding.ReviewisAddressRecordSameRb.setChecked(true);
        } else if (this.binding.notAddressRecordSameRb.isChecked()) {
            this.binding.ReviewnotAddressRecordSameRb.setChecked(true);
        }
        if (this.binding.pwdRG1.isChecked()) {
            this.binding.reviewPwdRG1.setChecked(true);
        } else if (this.binding.pwdRG2.isChecked()) {
            this.binding.reviewPwdRG2.setChecked(true);
        }
        if (this.binding.correct.isChecked()) {
            this.binding.reviewHouseVisitRGCorrect.setChecked(true);
        } else if (this.binding.absent.isChecked()) {
            this.binding.ReviewphotographRGAbsent.setChecked(true);
            this.binding.photographRG.setEnabled(false);
        } else if (this.binding.expired.isChecked()) {
            this.binding.reviewHouseVisitRG1.setChecked(true);
        } else if (this.binding.shifted.isChecked()) {
            this.binding.reviewHouseVisitRG2.setChecked(true);
        } else if (this.binding.repeated.isChecked()) {
            this.binding.reviewHouseVisitRG3.setChecked(true);
        }
        if (this.binding.aboveDetailsRG1.isChecked()) {
            this.binding.reviewAboveDetailsRG1.setChecked(true);
        } else if (this.binding.aboveDetailsRG2.isChecked()) {
            this.binding.reviewAboveDetailsRG2.setChecked(true);
        }
        if (this.binding.aadharRG1.isChecked()) {
            this.binding.reviewAadhaarRG1.setChecked(true);
        } else if (this.binding.aadharRG2.isChecked()) {
            this.binding.reviewAadhaarRG2.setChecked(true);
        }
        if (this.binding.metRG1.isChecked()) {
            this.binding.ReviewMetRG1.setChecked(true);
            this.binding.ReviewMetLinearLayout.setVisibility(0);
            this.binding.ReviewMobnumElector.setText(this.newPhoneNumberVerified);
        } else if (this.binding.metRG2.isChecked()) {
            this.binding.ReviewMetRG2.setChecked(true);
            this.binding.ReviewMetLinearLayout.setVisibility(8);
            this.binding.ReviewMobnumElector.setText("");
        }
        if (this.binding.chkLocomotive.isChecked()) {
            this.binding.reviewChkLocomotive.setChecked(true);
        }
        if (this.binding.chkVisual.isChecked()) {
            this.binding.reviewChkVisual.setChecked(true);
        }
        if (this.binding.chkDeafDumb.isChecked()) {
            this.binding.reviewChkDeafDumb.setChecked(true);
        }
        if (this.binding.chkOther.isChecked()) {
            this.binding.reviewChkOther.setChecked(true);
        }
        if (!this.binding.chkLocomotive.isChecked()) {
            this.binding.reviewChkLocomotive.setChecked(false);
        }
        if (!this.binding.chkVisual.isChecked()) {
            this.binding.reviewChkVisual.setChecked(false);
        }
        if (!this.binding.chkDeafDumb.isChecked()) {
            this.binding.reviewChkDeafDumb.setChecked(false);
        }
        if (this.binding.chkOther.isChecked()) {
            return;
        }
        this.binding.reviewChkOther.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void houseSurveySubmit() {
        String str;
        this.alertDialog.show();
        Logger.e(this.h2hDetails1, "in houseSurveySubmit()..........");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.datePattern);
        if (this.binding.genderTv1.getText().toString().equals("Male")) {
            str = "M";
        } else if (this.binding.genderTv1.getText().toString().equals(this.femaleString)) {
            str = "F";
        } else {
            str = "T";
        }
        this.isAadharVerified = "";
        if (this.binding.aadharRG1.isChecked()) {
            this.isAadharVerified = "Y";
        } else if (this.binding.aadharRG2.isChecked()) {
            this.isAadharVerified = "N";
        }
        this.isPhotographSame = "";
        if (this.binding.photographRG1.isChecked()) {
            this.isPhotographSame = "Y";
        } else if (this.binding.photographRG2.isChecked()) {
            this.isPhotographSame = "N";
        }
        this.isElectorRecordSame = "";
        if (this.binding.isElectorRecordSameRb.isChecked()) {
            this.isElectorRecordSame = "Y";
            this.binding.ReviewisElectorRecordSameRb.setChecked(true);
        } else if (this.binding.notElectorRecordSameRb.isChecked()) {
            this.isElectorRecordSame = "N";
            this.binding.ReviewnotElectorRecordSameRb.setChecked(true);
        }
        this.isDobRecordSame = "";
        if (this.binding.isDobRecordSameRb.isChecked()) {
            this.isDobRecordSame = "Y";
        } else if (this.binding.notDobRecordSameRb.isChecked()) {
            this.isDobRecordSame = "N";
        }
        this.isAddressRecordSame = "";
        if (this.binding.isAddressRecordSameRb.isChecked()) {
            this.isAddressRecordSame = "Y";
        } else if (this.binding.notAddressRecordSameRb.isChecked()) {
            this.isAddressRecordSame = "N";
        }
        this.isPWD = "";
        if (this.binding.pwdRG1.isChecked()) {
            this.isPWD = "Y";
        } else if (this.binding.pwdRG2.isChecked()) {
            this.isPWD = "N";
        }
        this.allDetailsVerified = "";
        if (this.rbInformation2.equals("Yes")) {
            this.allDetailsVerified = "Y";
        } else {
            this.allDetailsVerified = "N";
        }
        if (this.binding.chkLocomotive.isChecked()) {
            this.isLocomotive = "Y";
        } else {
            this.isLocomotive = "N";
        }
        if (this.binding.chkVisual.isChecked()) {
            this.isVisual = "Y";
        } else {
            this.isVisual = "N";
        }
        if (this.binding.chkDeafDumb.isChecked()) {
            this.isDeaf = "Y";
        } else {
            this.isDeaf = "N";
        }
        if (this.binding.chkOther.isChecked()) {
            this.disabilityType = "Y";
        } else {
            this.disabilityType = "N";
        }
        if (this.binding.absent.isChecked()) {
            this.isPhotographSame = "";
            this.isElectorRecordSame = "";
            this.isDobRecordSame = "";
            this.isAddressRecordSame = "";
            this.isPWD = "";
            this.pwdPercentage = "";
            this.isLocomotive = "";
            this.isVisual = "";
            this.isDeaf = "";
            this.disabilityType = "";
            this.binding.metRG2.setChecked(true);
            this.isMetElector = 0;
            this.pwdOtherType = "";
        }
        if (this.binding.metRG1.isChecked()) {
            this.isMetElector = 1;
            this.phoneNumberVerified = this.binding.mobnumElector.getText().toString();
        } else if (this.binding.metRG2.isChecked()) {
            this.isMetElector = 0;
            this.phoneNumberVerified = "";
        }
        try {
            this.finalDateOfVerification = simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString()));
        } catch (ParseException e) {
            this.alertDialog.dismiss();
            Logger.e("date2", e.getMessage());
            this.finalDateOfVerification = "";
            this.binding.submitTv.setEnabled(true);
            this.binding.draftTv.setEnabled(true);
        }
        if (this.email33.isEmpty() || this.email33.equals("null")) {
            this.finalEmail = this.newEmailID;
        } else {
            this.finalEmail = this.binding.emailTv.getText().toString();
        }
        if (this.binding.ageTv.getText().toString().isEmpty() || this.binding.ageTv.getText().toString().equals("null")) {
            this.finalAge = "";
        } else {
            this.finalAge = this.binding.ageTv.getText().toString();
        }
        if (this.partSerialNumber.isEmpty() || this.partSerialNumber.equalsIgnoreCase("null")) {
            this.partSerialNumber = "";
        }
        HashMap map = new HashMap();
        map.put("acNo", this.acNo);
        map.put("address", this.houseNo1);
        map.put("pwdPercentage", this.binding.EditText99.getText().toString());
        map.put("addressAttachment", this.filerefaddress);
        map.put("allDetailsVerified", this.allDetailsVerified);
        map.put(this.applicantNameString, this.binding.applicantNameTv1.getText().toString());
        map.put("coordinate", this.coordinates);
        map.put("isPwd", this.isPWD);
        map.put("aadharNo", this.aadhaarNo);
        map.put("isAadharVerified", this.isAadharVerified);
        map.put("residingPeriod", this.dobYear);
        map.put("isLocomotive", this.isLocomotive);
        map.put("isVisual", this.isVisual);
        map.put("isDeaf", this.isDeaf);
        map.put("disabilityType", this.disabilityType);
        map.put(this.otherDisabilityString, this.pwdOtherType);
        map.put(this.sectionNoString, this.sectionNumberNew);
        map.put("dateOfVerification", this.finalDateOfVerification);
        map.put("dob", this.finalDob);
        map.put("dobAttachment", this.filerefdob);
        map.put(this.emailString, this.finalEmail);
        map.put(this.epicNoString, this.binding.epicNumberTv1.getText().toString());
        map.put(this.genderString, str);
        map.put("houseApplicantFound", this.rbInformation1);
        map.put(this.houseNoString, this.houseNo1);
        map.put("isAddressRecordSame", this.isAddressRecordSame);
        map.put("isDobRecordSame", this.isDobRecordSame);
        map.put("photographEleIsCorrect", this.isPhotographSame);
        map.put("isElectorRecordSame", this.isElectorRecordSame);
        map.put("metInPerson", Integer.valueOf(this.isMetElector));
        map.put("phoneNumberVerified", this.phoneNumberVerified);
        map.put("partSerialNumber", this.partSerialNumber);
        if (this.sectionName.isEmpty() || this.sectionName.equals("null")) {
            this.newAddressSubmit = this.binding.streetTv.getText().toString();
        } else {
            this.newAddressSubmit = this.sectionName;
        }
        map.put("localitySreet", this.newAddressSubmit);
        map.put("misDocument", this.docref);
        map.put("mobileNo", this.binding.mobnumTv.getText().toString());
        map.put("partNo", this.partNo);
        map.put(this.relativeNameString, this.binding.relativeTv1.getText().toString());
        map.put(this.relativeTypeString, this.binding.relativeTypeTv.getText().toString());
        map.put("remarks", this.binding.remarkEd.getText().toString());
        map.put("stateCode", this.stateCode);
        map.put("age", this.finalAge);
        map.put("village", this.village);
        map.put("postOffice", this.postOffice);
        map.put("userFname", SharedPref.getInstance(requireContext()).getBloFname());
        map.put("userLname", SharedPref.getInstance(requireContext()).getBloLname());
        map.put("mobileNumber", SharedPref.getInstance(requireContext()).getBloPhone());
        map.put("partName", SharedPref.getInstance(requireContext()).getPartNumber());
        map.put("pinCode", this.pinCode);
        map.put("tehsilTalukaMandal", this.tehsil);
        Logger.e(this.h2hDetails1, "House survey submit json " + map);
        Logger.e(this.h2hDetails1, "House survey submit json66 " + new JSONObject(map).toString());
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).eroSurveySubmit(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.stateCode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        AnonymousClass7() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                H2HDETAILS.this.alertDialog.dismiss();
                Logger.e(H2HDETAILS.this.h2hDetails1, "Inside submit.........House Survey Submitted Successfully");
                H2HDETAILS.this.showdialogFinal("Success", "Verified Successfully");
                H2HDETAILS.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(new HouseSurveyModel.Payload(H2HDETAILS.this.epicVerify, H2HDETAILS.this.houseNo1, H2HDETAILS.this.sectionNumberNew, H2HDETAILS.this.partNo, SharedPref.getInstance(H2HDETAILS.this.requireContext()).getPreferredUsername(), H2HDETAILS.this.formattedDate, H2HDETAILS.this.inserted));
                H2HDETAILS.this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().deleteH2HElecorDetails(new H2HElectorDetailModel(H2HDETAILS.this.epicVerify, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0, "", "", "", "", "", "", "", "", "", "", ""));
                return;
            }
            if (response.code() == 401) {
                H2HDETAILS.this.commomUtility.getRefreshToken(H2HDETAILS.this.requireContext(), H2HDETAILS.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$7$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            H2HDETAILS.this.binding.submitTv.setEnabled(true);
            H2HDETAILS.this.binding.draftTv.setEnabled(true);
            H2HDETAILS.this.alertDialog.dismiss();
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
                H2HDETAILS h2hdetails = H2HDETAILS.this;
                h2hdetails.showdialog1(h2hdetails.alert, strOptString);
            } catch (Exception e) {
                Logger.e("Json1", e.getMessage());
                if (response.message() != null) {
                    H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                    h2hdetails2.showdialogFinal(h2hdetails2.alert, response.message());
                } else {
                    H2HDETAILS h2hdetails3 = H2HDETAILS.this;
                    h2hdetails3.showdialogFinal(h2hdetails3.alert, H2HDETAILS.this.noDataString);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$7$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
            H2HDETAILS.this.houseSurveySubmit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            H2HDETAILS.this.alertDialog.dismiss();
            H2HDETAILS.this.binding.submitTv.setEnabled(true);
            H2HDETAILS.this.binding.draftTv.setEnabled(true);
            Logger.e("on Failure............", t.getMessage());
            H2HDETAILS h2hdetails = H2HDETAILS.this;
            h2hdetails.showdialog1(h2hdetails.errorString, t.getMessage());
        }
    }

    private void draftHouseDataSubmit() {
        String str;
        Logger.e(this.h2hDetails1, "in draftHouseDataSubmit()..........");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.datePattern);
        if (this.binding.genderTv1.getText().toString().equals("Male")) {
            str = "M";
        } else if (this.binding.genderTv1.getText().toString().equals(this.femaleString)) {
            str = "F";
        } else {
            str = "T";
        }
        String str2 = str;
        if (this.sectionName.isEmpty() || this.sectionName.equals("null")) {
            this.newAddressSubmit = this.binding.streetTv.getText().toString();
        } else {
            this.newAddressSubmit = this.sectionName;
        }
        this.isAadharVerified = "";
        if (this.binding.aadharRG1.isChecked()) {
            this.isAadharVerified = "Y";
        } else if (this.binding.aadharRG2.isChecked()) {
            this.isAadharVerified = "N";
        }
        this.isPhotographSame = "";
        if (this.binding.photographRG1.isChecked()) {
            this.isPhotographSame = "Y";
        } else if (this.binding.photographRG2.isChecked()) {
            this.isPhotographSame = "N";
        }
        this.isElectorRecordSame = "";
        if (this.binding.isElectorRecordSameRb.isChecked()) {
            this.isElectorRecordSame = "Y";
            this.binding.ReviewisElectorRecordSameRb.setChecked(true);
        } else if (this.binding.notElectorRecordSameRb.isChecked()) {
            this.isElectorRecordSame = "N";
            this.binding.ReviewnotElectorRecordSameRb.setChecked(true);
        }
        this.isDobRecordSame = "";
        if (this.binding.isDobRecordSameRb.isChecked()) {
            this.isDobRecordSame = "Y";
        } else if (this.binding.notDobRecordSameRb.isChecked()) {
            this.isDobRecordSame = "N";
        }
        this.isAddressRecordSame = "";
        if (this.binding.isAddressRecordSameRb.isChecked()) {
            this.isAddressRecordSame = "Y";
        } else if (this.binding.notAddressRecordSameRb.isChecked()) {
            this.isAddressRecordSame = "N";
        }
        this.isPWD = "";
        if (this.binding.pwdRG1.isChecked()) {
            this.isPWD = "Y";
        } else if (this.binding.pwdRG2.isChecked()) {
            this.isPWD = "N";
        }
        this.allDetailsVerified = "";
        if (this.rbInformation2.equals("Yes")) {
            this.allDetailsVerified = "Y";
        } else {
            this.allDetailsVerified = "N";
        }
        if (this.binding.chkLocomotive.isChecked()) {
            this.isLocomotive = "Y";
        } else {
            this.isLocomotive = "N";
        }
        if (this.binding.chkVisual.isChecked()) {
            this.isVisual = "Y";
        } else {
            this.isVisual = "N";
        }
        if (this.binding.chkDeafDumb.isChecked()) {
            this.isDeaf = "Y";
        } else {
            this.isDeaf = "N";
        }
        if (this.binding.chkOther.isChecked()) {
            this.disabilityType = "Y";
        } else {
            this.disabilityType = "N";
        }
        this.isMetElector = 0;
        if (this.binding.metRG1.isChecked()) {
            this.isMetElector = 1;
            this.phoneNumberVerified = this.binding.mobnumElector.getText().toString();
        } else if (this.binding.metRG2.isChecked()) {
            this.isMetElector = 0;
        }
        if (this.binding.absent.isChecked()) {
            this.isPhotographSame = "";
            this.isElectorRecordSame = "";
            this.isDobRecordSame = "";
            this.isAddressRecordSame = "";
            this.isPWD = "";
            this.pwdPercentage = "";
            this.isLocomotive = "";
            this.isVisual = "";
            this.isDeaf = "";
            this.disabilityType = "";
            this.pwdOtherType = "";
            this.binding.metRG2.setChecked(true);
            this.isMetElector = 0;
            this.phoneNumberVerified = "";
        }
        try {
            this.finalDateOfVerification = simpleDateFormat2.format(simpleDateFormat.parse(this.binding.verificationDateEd.getText().toString()));
        } catch (ParseException e) {
            Logger.e(this.h2hDetails1, e.getMessage());
            this.finalDateOfVerification = "";
            this.binding.submitTv.setEnabled(true);
            this.binding.draftTv.setEnabled(true);
        }
        if (this.email33.isEmpty() || this.email33.equals("null")) {
            this.finalEmail = this.newEmailID;
        } else {
            this.finalEmail = this.binding.emailTv.getText().toString();
        }
        if (this.binding.ageTv.getText().toString().isEmpty() || this.binding.ageTv.getText().toString().equals("null")) {
            this.finalAge = "";
        } else {
            this.finalAge = this.binding.ageTv.getText().toString();
        }
        if (this.binding.mobnumElector.getText().toString().isEmpty() || this.binding.mobnumElector.getText().toString().equals("null")) {
            this.phoneNumberVerified = "";
        }
        try {
            H2HElectorDetailModelDao h2HElectorDetailModelDao = this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao();
            String string = this.binding.epicNumberTv1.getText().toString();
            String string2 = this.binding.applicantNameTv1.getText().toString();
            String string3 = this.binding.mobnumTv.getText().toString();
            String str3 = this.finalEmail;
            String str4 = this.aadhaarNo;
            String str5 = this.finalDob;
            String str6 = this.finalAge;
            String string4 = this.binding.relativeTv1.getText().toString();
            String string5 = this.binding.relativeTypeTv.getText().toString();
            String str7 = this.houseNo1;
            h2HElectorDetailModelDao.addH2HElecorDetails(new H2HElectorDetailModel(string, string2, string3, str2, str3, str4, str5, str6, string4, string5, str7, this.village, this.postOffice, this.acNo, this.newAddressSubmit, str7, this.pinCode + " " + this.tehsil, this.partNo, this.stateCode, this.coordinates, this.dobYear, this.rbInformation1, this.isAadharVerified, this.isElectorRecordSame, this.allDetailsVerified, this.isAddressRecordSame, this.isDobRecordSame, this.isPhotographSame, this.disabilityType, this.isVisual, this.sectionNumberNew, this.isPWD, this.isDeaf, this.binding.EditText99.getText().toString(), this.isLocomotive, this.pwdOtherType, this.isMetElector, this.phoneNumberVerified, this.finalDateOfVerification, this.filerefaddress, this.filerefdob, this.docref, this.binding.remarkEd.getText().toString(), this.sectionName1, this.binding.applicantNameRegionalTv1.getText().toString(), this.binding.relativeRegionalTv1.getText().toString(), this.filerefphoto, this.partSerialNumber));
            showProgressInVisible();
            showdialogFinal("Success", "Data Saved In H2H Draft");
        } catch (Exception unused) {
            this.binding.submitTv.setEnabled(true);
            this.binding.draftTv.setEnabled(true);
            showProgressInVisible();
            showdialogFinal(this.errorString, "Something went wrong");
        }
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.submitTv.setOnClickListener(this);
        this.binding.draftTv.setOnClickListener(this);
        this.binding.resetTv.setOnClickListener(this);
        this.binding.keepEditingTv.setOnClickListener(this);
        this.binding.previewTvBtn.setOnClickListener(this);
    }

    private void initClickListener() {
        this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$40(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$40(View view) {
        this.binding.preview.setVisibility(8);
        this.binding.chooseFileItems.setVisibility(4);
        try {
            if (isAdded()) {
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131362458) {
            prevFragment();
        }
        if (v.getId() == 2131365939) {
            if (!this.newPhoneNumberVerified.isEmpty() || this.isMetElector == 1) {
                showdialogNew("Attention", "Are you sure you have met the elector and verified the entered information?");
            } else {
                showdialogNew("Attention", "Have you verified the entered information?");
            }
            this.binding.submitTv.setEnabled(false);
            this.binding.draftTv.setEnabled(false);
        }
        if (v.getId() == 2131363490) {
            showDialogNew1("Attention", "Do you want to save data in H2H Draft and access it Later?");
            this.binding.submitTv.setEnabled(false);
            this.binding.draftTv.setEnabled(false);
        }
        if (v.getId() == 2131365246) {
            this.binding.ReviewRemark.setText(this.binding.remarkEd.getText().toString());
            this.newEmailID = this.binding.emailTv1.getText().toString();
            if (this.email33.isEmpty() || this.email33.equals("null")) {
                this.binding.ReviewemailTv.setText(this.newEmailID);
            }
            this.pwdPercentage = this.binding.EditText99.getText().toString() + " %";
            if (this.binding.EditText99.getText().toString().isEmpty() || this.binding.EditText99.getText().toString().equals("null")) {
                this.binding.ReviewPWDPercentage.setText("");
            } else {
                this.binding.ReviewPWDPercentage.setText(this.pwdPercentage);
            }
            this.pwdOtherType = this.binding.EditText999.getText().toString();
            this.binding.ReviewPWDOtherDisablity.setText(this.pwdOtherType);
            this.newPhoneNumberVerified = this.binding.mobnumElector.getText().toString();
            if (this.phoneNumberVerified.isEmpty() || this.phoneNumberVerified.equals("null")) {
                this.binding.mobnumElector.setText(this.newPhoneNumberVerified);
            }
            previewDataChecks();
            nextFragment();
        }
        if (v.getId() == 2131365497) {
            this.binding.EditDetails.setVisibility(0);
            this.binding.dobEd.setText("");
            this.binding.ReviewphotographRG.clearCheck();
            this.binding.Reviewrg1stpage.clearCheck();
            this.binding.ReviewdobRg.clearCheck();
            this.binding.ReviewaddressRg.clearCheck();
            this.binding.Reviewinformationrg999.clearCheck();
            this.binding.ReviewinformationRg1.clearCheck();
            this.binding.ReviewinformationRg2.clearCheck();
            this.binding.photographRG.clearCheck();
            this.binding.rg1stpage.clearCheck();
            this.binding.dobRg.clearCheck();
            this.binding.addressRg.clearCheck();
            this.binding.informationrg999.clearCheck();
            this.binding.informationRg1.clearCheck();
            this.binding.informationRg2.clearCheck();
            this.binding.EditText99.setText("");
            this.binding.chkLocomotive.setChecked(false);
            this.binding.reviewChkLocomotive.setChecked(false);
            this.binding.chkVisual.setChecked(false);
            this.binding.reviewChkVisual.setChecked(false);
            this.binding.chkDeafDumb.setChecked(false);
            this.binding.reviewChkDeafDumb.setChecked(false);
            this.binding.chkOther.setChecked(false);
            this.binding.reviewChkOther.setChecked(false);
            this.binding.metInfo.clearCheck();
            this.binding.EditText999.setText("");
            this.binding.remarkEd.setText("");
            this.binding.preview.setVisibility(8);
            this.binding.chooseFileItems.setVisibility(4);
            try {
                if (isAdded()) {
                    this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                }
            } catch (Exception unused) {
                Logger.e(this.h2hDetails1, this.comingTag);
            }
            this.isAadharVerified = "";
            this.isPhotographSame = "";
            this.isElectorRecordSame = "";
            this.isDobRecordSame = "";
            this.isAddressRecordSame = "";
            this.isPWD = "";
            this.allDetailsVerified = "";
            this.dobYear = "";
            this.binding.fillForm8Btn1.setVisibility(8);
            this.binding.fillForm8Btn1.setVisibility(8);
            this.binding.fillForm8Btn1.setVisibility(8);
            this.binding.photographRG1.setEnabled(true);
            this.binding.photographRG2.setEnabled(true);
            this.binding.isElectorRecordSameRb.setEnabled(true);
            this.binding.notElectorRecordSameRb.setEnabled(true);
            this.binding.isDobRecordSameRb.setEnabled(true);
            this.binding.notDobRecordSameRb.setEnabled(true);
            this.binding.isAddressRecordSameRb.setEnabled(true);
            this.binding.notAddressRecordSameRb.setEnabled(true);
            this.binding.pwdRG1.setEnabled(true);
            this.binding.pwdRG2.setEnabled(true);
            this.binding.aadharRG1.setEnabled(true);
            this.binding.aadharRG2.setEnabled(true);
        }
        if (v.getId() == 2131364274) {
            this.binding.EditDetails.setVisibility(0);
            this.binding.ReviewDetails.setVisibility(8);
            this.binding.keepEditingTv.setVisibility(8);
            this.binding.resetTv.setVisibility(0);
            this.binding.previewTvBtn.setVisibility(0);
            this.binding.submitTv.setVisibility(8);
            this.binding.draftTv.setVisibility(8);
            this.binding.submitTv.setEnabled(true);
        }
    }

    private void nextFragment() {
        if (this.email33.isEmpty() && !this.newEmailID.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && !this.newEmailID.isEmpty()) {
            showdialog1(this.alert, "Please enter correct Email ID");
            return;
        }
        if (this.binding.photographRG.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, this.personalDetailTabString);
            return;
        }
        if (this.binding.rg1stpage.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, this.personalDetailTabString);
            return;
        }
        if (this.binding.dobRg.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, this.personalDetailTabString);
            return;
        }
        if (this.binding.addressRg.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, this.personalDetailTabString);
            return;
        }
        if (!this.binding.EditText99.getText().toString().isEmpty() && Integer.parseInt(this.binding.EditText99.getText().toString()) <= 0) {
            showdialog1(this.alert, "Please enter correct percentage of PWD");
            return;
        }
        if (!this.binding.EditText99.getText().toString().isEmpty() && Integer.parseInt(this.binding.EditText99.getText().toString()) > 100) {
            showdialog1(this.alert, "Please enter correct percentage of PWD");
            return;
        }
        if (this.binding.informationrg999.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, "Please fill PWD tab completely");
            return;
        }
        if (this.binding.pwdRG1.isChecked() && this.binding.EditText99.getText().toString().isEmpty()) {
            showdialog1(this.alert, "Please Enter PWD Percentage");
            return;
        }
        if (this.binding.pwdRG1.isChecked() && !this.binding.chkLocomotive.isChecked() && !this.binding.chkVisual.isChecked() && !this.binding.chkDeafDumb.isChecked() && !this.binding.chkOther.isChecked()) {
            showdialog1(this.alert, "Please Select Disability Type");
            return;
        }
        if (!this.phoneNumberVerified.isEmpty() && !this.phoneNumberVerified.matches(RegexMatcher.MOBILE_REGEX)) {
            showdialog1(this.alert, "Please enter correct Mobile Number of Elector");
            return;
        }
        if (this.binding.metInfo.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, "Please fill Met Elector tab completely");
            return;
        }
        if (this.binding.informationrg9999.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, "Please fill Aadhaar tab completely");
            return;
        }
        if (this.binding.informationRg1.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, "Please fill Information tab completely");
            return;
        }
        if (this.binding.informationRg2.getCheckedRadioButtonId() == -1) {
            showdialog1(this.alert, "Please fill Information tab completely");
            return;
        }
        this.binding.EditDetails.setVisibility(8);
        this.binding.ReviewDetails.setVisibility(0);
        this.binding.resetTv.setVisibility(8);
        this.binding.keepEditingTv.setVisibility(0);
        this.binding.previewTvBtn.setVisibility(8);
        this.binding.submitTv.setVisibility(0);
        this.binding.draftTv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prevFragment$41(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    private void prevFragment() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$prevFragment$41(view);
            }
        });
    }

    private void showMigrationDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomSheetMigrationBinding bloBottomSheetMigrationBindingInflate = BloBottomSheetMigrationBinding.inflate(getLayoutInflater());
        bloBottomSheetMigrationBindingInflate.epicNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        bloBottomSheetMigrationBindingInflate.epicNumber1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        bloBottomSheetMigrationBindingInflate.epicNumber.setText(this.epicNumberNew);
        dialog.setContentView((View) bloBottomSheetMigrationBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        bloBottomSheetMigrationBindingInflate.sameotherepiclayout.setVisibility(0);
        bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(true);
        bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(true);
        bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(false);
        dialog.getWindow().setGravity(80);
        bloBottomSheetMigrationBindingInflate.epicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == bloBottomSheetMigrationBindingInflate.epicNumber.getEditableText()) {
                    if (!bloBottomSheetMigrationBindingInflate.epicNumber.getText().toString().isEmpty()) {
                        bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(true);
                        bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(true);
                        return;
                    }
                    bloBottomSheetMigrationBindingInflate.SameEpic.setChecked(false);
                    bloBottomSheetMigrationBindingInflate.otherEpic.setChecked(false);
                    bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(false);
                }
            }
        });
        bloBottomSheetMigrationBindingInflate.Epictype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda51
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$showMigrationDialog$42(bloBottomSheetMigrationBindingInflate, radioGroup, i);
            }
        });
        bloBottomSheetMigrationBindingInflate.epicNumber1.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == bloBottomSheetMigrationBindingInflate.epicNumber1.getEditableText()) {
                    bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(!bloBottomSheetMigrationBindingInflate.epicNumber1.getText().toString().isEmpty());
                }
            }
        });
        bloBottomSheetMigrationBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMigrationDialog$43(bloBottomSheetMigrationBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationDialog$42(BloBottomSheetMigrationBinding bloBottomSheetMigrationBinding, RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = bloBottomSheetMigrationBinding.Epictype.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131362023) {
            bloBottomSheetMigrationBinding.epicNumber1.setEnabled(true);
            bloBottomSheetMigrationBinding.epicNumber1.setText(bloBottomSheetMigrationBinding.epicNumber.getText().toString());
            bloBottomSheetMigrationBinding.btnProceed.setEnabled(true);
            this.appFor = "self";
            return;
        }
        if (checkedRadioButtonId != 2131364960) {
            return;
        }
        bloBottomSheetMigrationBinding.epicNumber1.setEnabled(true);
        bloBottomSheetMigrationBinding.btnProceed.setEnabled(false);
        bloBottomSheetMigrationBinding.epicNumber1.setText("");
        this.appFor = this.otherString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationDialog$43(BloBottomSheetMigrationBinding bloBottomSheetMigrationBinding, Dialog dialog, View view) {
        if (bloBottomSheetMigrationBinding.epicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX) && bloBottomSheetMigrationBinding.epicNumber1.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            if (!bloBottomSheetMigrationBinding.epicNumber.getText().toString().equals(bloBottomSheetMigrationBinding.epicNumber1.getText().toString())) {
                this.alertDialog.show();
                getdetailsofInitialEpic(bloBottomSheetMigrationBinding.epicNumber.getText().toString(), bloBottomSheetMigrationBinding.epicNumber1.getText().toString());
                if (this.error.equals("part") || this.error.equals("Assembly") || this.error.equals("state")) {
                    bloBottomSheetMigrationBinding.btnProceed.setEnabled(false);
                    bloBottomSheetMigrationBinding.epicNumber1.setText("");
                }
                dialog.dismiss();
                return;
            }
            if (this.appFor.equals("self")) {
                this.alertDialog.show();
                getdetailsofProceedingEpicSame(bloBottomSheetMigrationBinding.epicNumber1.getText().toString());
                dialog.dismiss();
                return;
            }
            showDialog("Enter Different Proceeding EPIC Number");
            return;
        }
        showDialog("Enter Correct Proceeding EPIC Number");
        bloBottomSheetMigrationBinding.epicNumber.setText("");
        bloBottomSheetMigrationBinding.epicNumber1.setText("");
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showAadhaarDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomsheetaadharBinding bloBottomsheetaadharBindingInflate = BloBottomsheetaadharBinding.inflate(getLayoutInflater());
        bloBottomsheetaadharBindingInflate.epicNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        dialog.setContentView((View) bloBottomsheetaadharBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloBottomsheetaadharBindingInflate.epicNumber.setText(this.epicNumberNew);
        bloBottomsheetaadharBindingInflate.btnForm6b.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showAadhaarDialog$45(bloBottomsheetaadharBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAadhaarDialog$45(BloBottomsheetaadharBinding bloBottomsheetaadharBinding, Dialog dialog, View view) {
        this.epicNumber = bloBottomsheetaadharBinding.epicNumber.getText().toString();
        if (bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty()) {
            showDialog(this.enterEpicString);
            return;
        }
        if (!bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty() && !bloBottomsheetaadharBinding.epicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog(this.enterCorrectEpicString);
            return;
        }
        try {
            if (isAdded()) {
                if (isNetworkAvailable(requireContext())) {
                    this.alertDialog.show();
                    getEpic();
                    dialog.dismiss();
                } else {
                    Toast.makeText(requireContext(), this.networkTag, 1).show();
                }
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle(this.errorString);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda36
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEpic() {
        Dialog dialog = new Dialog(getContext());
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getAadhaarLink(this.epicIdForForm6B, this.token, this.currentRole, this.bloStateCode, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP").enqueue(new AnonymousClass10(dialog));
        dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass10(final Dialog val$dialog) {
            this.val$dialog = val$dialog;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                H2HDETAILS.this.payLoad = (JsonObject) response.body();
                Logger.d(H2HDETAILS.this.logTag, "Response message" + H2HDETAILS.this.payLoad.get(H2HDETAILS.this.messageText));
                String strSubstring = String.valueOf(H2HDETAILS.this.payLoad.get(H2HDETAILS.this.messageText)).substring(1, String.valueOf(H2HDETAILS.this.payLoad.get(H2HDETAILS.this.messageText)).length() - 1);
                Logger.d(H2HDETAILS.this.logTag, "Response message2 " + strSubstring);
                if (strSubstring.equals("There is no Adhar provided for the Entered Epic")) {
                    HashMap map = new HashMap();
                    map.put(H2HDETAILS.this.epicNumberStringForm7, H2HDETAILS.this.epicNumber);
                    H2HDETAILS.this.validateForm6B = false;
                    H2HDETAILS.this.commonUtilClass.getRetrofitClient(H2HDETAILS.this.getContext(), H2HDETAILS.this.token, H2HDETAILS.this.atkband, H2HDETAILS.this.rtkband).getByEpicForForm(H2HDETAILS.this.token, SharedPref.getInstance(H2HDETAILS.this.getContext()).getAtknBnd(), SharedPref.getInstance(H2HDETAILS.this.getContext()).getRtknBnd(), "BLOAPP", H2HDETAILS.this.currentRole, "ANDROIDMOB", map).enqueue(new AnonymousClass1());
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 1000L);
                    this.val$dialog.dismiss();
                } else if (strSubstring.equals("EPIC Number already Linked. Please try again with differnt EPIC")) {
                    H2HDETAILS.this.showDialog("EPIC Number already Linked. Please try again with different EPIC");
                } else {
                    H2HDETAILS.this.showDialog(strSubstring);
                }
            } else if (response.code() == 401) {
                H2HDETAILS.this.commomUtility.getRefreshToken(H2HDETAILS.this.requireContext(), H2HDETAILS.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i, str, str2);
                    }
                });
            } else {
                H2HDETAILS.this.showDialog("No data Found");
                this.val$dialog.dismiss();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$3();
                }
            }, 1000L);
            this.val$dialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JsonArray> {
            AnonymousClass1() {
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    JsonArray jsonArray = (JsonArray) response.body();
                    Logger.d(H2HDETAILS.this.logTag, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                    for (int i = 0; i < jsonArray.size(); i++) {
                        H2HDETAILS.this.payloadContent = jsonArray.get(i).get(H2HDETAILS.this.contentText);
                        Logger.d(H2HDETAILS.this.logTag, "getEpic : getByEpicForForm : payloadContent : " + H2HDETAILS.this.payloadContent);
                        H2HDETAILS.this.acNumberOther = String.valueOf(H2HDETAILS.this.payloadContent.get(H2HDETAILS.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        H2HDETAILS.this.partNoOther = String.valueOf(H2HDETAILS.this.payloadContent.get(H2HDETAILS.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (H2HDETAILS.this.asmblyNO.equals(H2HDETAILS.this.acNumberOther) && H2HDETAILS.this.partNo.equals(H2HDETAILS.this.partNoOther)) {
                            H2HDETAILS.this.validateForm6B = true;
                            H2HDETAILS.this.stateNameForForm6B = H2HDETAILS.this.payloadContent.get("stateName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.districtNameForForm6B = H2HDETAILS.this.payloadContent.get("districtValue").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.acNameForForm6B = H2HDETAILS.this.payloadContent.get("asmblyName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.assemblyNoForForm6B = H2HDETAILS.this.payloadContent.get(H2HDETAILS.this.acNumberText).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.firstNameForForm6B = H2HDETAILS.this.payloadContent.get("applicantFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.lastNameForForm6B = H2HDETAILS.this.payloadContent.get("applicantLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.epicIdForForm6B = H2HDETAILS.this.payloadContent.get("epicNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.mobileNoForForm6B = H2HDETAILS.this.payloadContent.get("mobileNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.emailIdForForm6B = H2HDETAILS.this.payloadContent.get(Constants.EMAIL_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            H2HDETAILS.this.stateCdForForm6B = H2HDETAILS.this.payloadContent.get("stateCd").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", " ");
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> stateNameForForm6B : " + H2HDETAILS.this.stateNameForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> districtNameForForm6B : " + H2HDETAILS.this.districtNameForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> acNameForForm6B : " + H2HDETAILS.this.acNameForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> assemblyNoForForm6B : " + H2HDETAILS.this.assemblyNoForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> firstNameForForm6B : " + H2HDETAILS.this.firstNameForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> lastNameForForm6B : " + H2HDETAILS.this.lastNameForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> epicIdForForm6B : " + H2HDETAILS.this.epicIdForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> mobileNoForForm6B : " + H2HDETAILS.this.mobileNoForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> emailIdForForm6B : " + H2HDETAILS.this.emailIdForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> stateCdForForm6B : " + H2HDETAILS.this.stateCdForForm6B);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> acNumberOther : " + H2HDETAILS.this.acNumberOther);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> asmblyNO : " + H2HDETAILS.this.asmblyNO);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> partNoOther : " + H2HDETAILS.this.partNoOther);
                            Logger.d(H2HDETAILS.this.logTag, "getEpic ----> partNo : " + H2HDETAILS.this.partNo);
                        }
                    }
                    if (H2HDETAILS.this.validateForm6B) {
                        H2HDETAILS.this.openFragment3(new AadhaarAuthenticationFormFragment(), "Aadhaar Authentication");
                        AnonymousClass10.this.val$dialog.dismiss();
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    H2HDETAILS.this.commomUtility.getRefreshToken(H2HDETAILS.this.requireContext(), H2HDETAILS.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$1$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageText);
                    Logger.d(H2HDETAILS.this.logTag, strOptString);
                    AnonymousClass10.this.val$dialog.dismiss();
                    H2HDETAILS.this.showDialog(strOptString);
                } catch (Exception e) {
                    Logger.d(H2HDETAILS.this.logTag, e.getMessage());
                    AnonymousClass10.this.val$dialog.dismiss();
                    if (response != null && response.code() != 200 && response.message() != null) {
                        H2HDETAILS.this.showDialog(response.message());
                    } else {
                        H2HDETAILS.this.showDialog(H2HDETAILS.this.noRecordFoundWithEpic + H2HDETAILS.this.epicNumber);
                    }
                }
                AnonymousClass10.this.val$dialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                H2HDETAILS.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                if (i == 401 || i == 400) {
                    H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                H2HDETAILS.this.token = "Bearer " + str;
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
                H2HDETAILS.this.getEpic();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
                H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (H2HDETAILS.this.epicNumber.isEmpty()) {
                    H2HDETAILS.this.showDialog(H2HDETAILS.this.enterEpicNumber);
                } else {
                    H2HDETAILS.this.showDialog(H2HDETAILS.this.enterCorrectEpicNumber);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            H2HDETAILS.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$10$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str;
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
            H2HDETAILS.this.getEpic();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            H2HDETAILS.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (H2HDETAILS.this.epicNumber.isEmpty()) {
                H2HDETAILS h2hdetails = H2HDETAILS.this;
                h2hdetails.showDialog(h2hdetails.enterEpicNumber);
            } else {
                H2HDETAILS h2hdetails2 = H2HDETAILS.this;
                h2hdetails2.showDialog(h2hdetails2.enterCorrectEpicNumber);
            }
            this.val$dialog.dismiss();
        }
    }

    private void getdetailsofInitialEpic(final String initialEpic, final String procEpic) {
        this.commomUtility.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, initialEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda37
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofInitialEpic$49(procEpic, initialEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$49(final String str, final String str2, int i, JsonArray jsonArray) {
        if (i != 200) {
            this.alertDialog.dismiss();
            if (i == 401) {
                this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda45
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$getdetailsofInitialEpic$48(str2, str, i2, str3, str4);
                    }
                });
                return;
            } else {
                showDialog(this.noRecordFoundString + str2);
                return;
            }
        }
        if (jsonArray != null) {
            this.epicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicDetails", this.epicDetailsArray.toString());
            this.bundle2.putString("appfor", this.appFor);
            getdetailsofProceedingEpic(str);
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundString + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$48(String str, String str2, int i, String str3, String str4) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda35
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofInitialEpic$47(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str4);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str3);
        getdetailsofInitialEpic(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$47(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getdetailsofProceedingEpic(final String proceedingEpic) {
        this.commomUtility.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, proceedingEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda54
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofProceedingEpic$52(proceedingEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$52(final String str, int i, JsonArray jsonArray) {
        if (i != 200) {
            this.alertDialog.dismiss();
            if (i == 401) {
                this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda11
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$getdetailsofProceedingEpic$51(str, i2, str2, str3);
                    }
                });
                return;
            } else {
                showDialog(this.noRecordFoundString + str);
                return;
            }
        }
        if (jsonArray != null) {
            this.proceedingEpicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicProceedingDetails", this.proceedingEpicDetailsArray.toString());
            this.bundle2.putString("FlagKey", "1");
            openFragment5(new SelectApplicantObjecteeFragment(), "SelectApplicantFragment");
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundString + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$51(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda39
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofProceedingEpic$50(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getdetailsofProceedingEpic(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$50(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getdetailsofProceedingEpicSame(final String proceedingEpic) {
        this.epicmap.put("epic", proceedingEpic);
        this.commomUtility.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, proceedingEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda38
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofProceedingEpicSame$55(proceedingEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$55(final String str, int i, JsonArray jsonArray) {
        if (i != 200) {
            this.alertDialog.dismiss();
            if (i == 401) {
                this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda56
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$getdetailsofProceedingEpicSame$54(str, i2, str2, str3);
                    }
                });
                return;
            } else {
                showDialog(this.noRecordFoundString + str);
                return;
            }
        }
        if (jsonArray != null) {
            this.epicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicDetails", this.epicDetailsArray.toString());
            this.bundle2.putString("appfor", this.appFor);
            this.bundle2.putString("FlagKey", "1");
            openFragment5(new SelectApplicantFragment(), "SelectApplicantFragment");
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundString + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$54(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda43
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofProceedingEpicSame$53(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getdetailsofProceedingEpicSame(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$53(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda48
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    private void showdialogNew(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda49
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showdialogNew$58(dialogInterface, i);
                    }
                }).setNegativeButton(this.cancelString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda50
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showdialogNew$59(dialogInterface, i);
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogNew$58(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        houseSurveySubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogNew$59(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.binding.submitTv.setEnabled(true);
        this.binding.draftTv.setEnabled(true);
        this.binding.EditDetails.setVisibility(0);
        this.binding.ReviewDetails.setVisibility(8);
        this.binding.keepEditingTv.setVisibility(8);
        this.binding.resetTv.setVisibility(0);
        this.binding.previewTvBtn.setVisibility(0);
        this.binding.submitTv.setVisibility(8);
        this.binding.draftTv.setVisibility(8);
    }

    private void showDialogNew1(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda62
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showDialogNew1$60(dialogInterface, i);
                    }
                }).setNegativeButton(this.cancelString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda63
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showDialogNew1$61(dialogInterface, i);
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogNew1$60(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        showProgressVisible();
        draftHouseDataSubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogNew1$61(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.binding.submitTv.setEnabled(true);
        this.binding.draftTv.setEnabled(true);
        this.binding.EditDetails.setVisibility(0);
        this.binding.ReviewDetails.setVisibility(8);
        this.binding.keepEditingTv.setVisibility(8);
        this.binding.resetTv.setVisibility(0);
        this.binding.previewTvBtn.setVisibility(0);
        this.binding.submitTv.setVisibility(8);
        this.binding.draftTv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda47
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showdialogFinal$62(dialogInterface, i);
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogFinal$62(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity();
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        try {
            this.jsonArray11 = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getSearchedAllHousesData());
            Logger.e(this.h2hDetails1, "" + this.jsonArray11.size());
            renderingData1(this.jsonArray11);
            Logger.e(this.h2hDetails1, SharedPref.getInstance(getActivity()).getSearchedAllHousesData() + "EEEEEEEEEEEEEEEEEEE");
        } catch (Exception e) {
            if (e.getMessage() == null) {
                Logger.d("", this.comingTag);
            } else {
                Logger.d("", e.getMessage());
            }
        }
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
        showProgressInVisible();
    }

    private void selectImage() {
        try {
            if (isAdded()) {
                final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Choose PDF from Gallery", this.cancelString};
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Add Photo!");
                builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda40
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$selectImage$63(charSequenceArr, dialogInterface, i);
                    }
                });
                builder.show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$63(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            showProgressVisible();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose from Gallery")) {
            showProgressVisible();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            openfile1();
        } else if (charSequenceArr[i].equals(this.cancelString)) {
            dialogInterface.dismiss();
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher.launch(Intent.createChooser(intent, "Choose File"));
    }

    private void openFragment5(Fragment fragment, String selectedFragment) {
        fragment.setArguments(this.bundle2);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
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
                Logger.e(this.h2hDetails1, e.getMessage());
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
                    Logger.e(this.h2hDetails1, "in 1024 upload api..............................");
                    this.binding.preview.setVisibility(0);
                    this.binding.chooseFileItems.setVisibility(0);
                    try {
                        if (isAdded()) {
                            this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                        }
                    } catch (Exception unused) {
                        Logger.e(this.h2hDetails1, this.comingTag);
                    }
                    this.binding.selectName.setText(string);
                    this.binding.selectSize.setText(this.filesize + "KB");
                    ImageView imageView = this.binding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    saveimageapi(this.saveImageFileName);
                    return;
                }
                Logger.e(this.h2hDetails1, "in 1024 else upload api..............................");
                if (this.filesize > 2048) {
                    Logger.e(this.h2hDetails1, "in 1024 else 2048 upload api..............................");
                    this.alertDialog.dismiss();
                    showProgressInVisible();
                    showdialog1(this.alert, "Image size exceeds the limit of 2MB, Please retry.");
                    return;
                }
                Logger.e(this.h2hDetails1, "in 1024 else 2048 else upload api..............................");
                float f = this.filesize / 1024.0f;
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileItems.setVisibility(0);
                try {
                    if (isAdded()) {
                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                    }
                } catch (Exception unused2) {
                    Logger.e(this.h2hDetails1, this.comingTag);
                }
                this.binding.selectName.setText(string);
                this.binding.selectSize.setText(String.format("%.2f", Float.valueOf(f)) + "MB");
                ImageView imageView2 = this.binding.preview;
                byte[] bArr2 = this.byteArray;
                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                saveimageapi(this.saveImageFileName);
            } catch (Exception e2) {
                Logger.d(this.h2hDetails1, e2.getMessage());
                string = "";
            }
        } else {
            showProgressInVisible();
        }
    }

    private void saveimageapi(String captureFileName) {
        showProgressInVisible();
        try {
            if (isAdded()) {
                if (isNetworkAvailable(requireContext())) {
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.show();
                    }
                    Logger.e(this.h2hDetails1, "in image upload api..............................");
                    File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
                    MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
                    RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), "misc_document");
                    ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.bloAppString, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.acNo, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.bloAppString, MediaType.parse("appName"))).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS.11
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if (!response.isSuccessful()) {
                                H2HDETAILS.this.showProgressInVisible();
                                if (H2HDETAILS.this.alertDialog != null) {
                                    H2HDETAILS.this.alertDialog.dismiss();
                                    return;
                                }
                                return;
                            }
                            Logger.e(H2HDETAILS.this.h2hDetails1, "Success_Uploaded");
                            JsonElement jsonElement = ((JsonObject) response.body()).get("refId");
                            H2HDETAILS.this.docref = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            Logger.d("document ", H2HDETAILS.this.docref);
                            H2HDETAILS.this.showProgressInVisible();
                            if (H2HDETAILS.this.alertDialog != null) {
                                H2HDETAILS.this.alertDialog.dismiss();
                            }
                        }

                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            Logger.e(H2HDETAILS.this.h2hDetails1, "Failed_Uploaded " + t.getMessage());
                            H2HDETAILS.this.showProgressInVisible();
                            if (H2HDETAILS.this.alertDialog != null) {
                                H2HDETAILS.this.alertDialog.dismiss();
                            }
                        }
                    });
                    return;
                }
                AlertDialog alertDialog2 = this.alertDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                this.binding.preview.setVisibility(8);
                this.binding.chooseFileItems.setVisibility(4);
                this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
                Toast.makeText(requireContext(), this.networkTag, 1).show();
            }
        } catch (Exception unused) {
            Logger.e(this.h2hDetails1, this.comingTag);
        }
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda57
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$64(task);
                    }
                });
            } else {
                Logger.e(this.h2hDetails1, "Location not captured");
            }
        } else {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
        Logger.e(this.h2hDetails1, "not version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentLocation$64(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                this.locationName = fromLocation.get(0).getAddressLine(0);
                this.latitude = Double.valueOf(fromLocation.get(0).getLatitude());
                this.longitude = Double.valueOf(fromLocation.get(0).getLongitude());
                if (location.hasAltitude()) {
                    this.altitude = Double.valueOf(location.getAltitude());
                } else {
                    this.altitude = Double.valueOf(0.0d);
                }
                String str = this.latitude + "," + this.longitude + "," + this.altitude;
                this.coordinates = str;
                Logger.e(this.h2hDetails1, str);
                return;
            } catch (Exception e) {
                Logger.d("Content : ", e.getMessage());
                return;
            }
        }
        Logger.e(this.h2hDetails1, "Location not captured");
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void renderingData1(JSONArray allHouses) {
        JSONArray jSONArray = new JSONArray();
        try {
            Logger.e(this.h2hDetails1, "in reading..........................." + allHouses);
            for (int i = 0; i < allHouses.size(); i++) {
                JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
                Logger.e(this.h2hDetails1, "RRRRRRRRRRRRR" + asJsonObject.get(this.houseNoString));
                String strReplace = asJsonObject.get(this.houseNoString).toString().replace("^\"|\"$", "").replace("null", " ");
                String strReplace2 = asJsonObject.get(this.applicantNameString).toString().replace("^\"|\"$", "").replace("null", " ");
                if (strReplace.equals(this.houseNo1) && strReplace2.equals(this.binding.applicantNameTv1.getText())) {
                    asJsonObject.addProperty("isVerified", "Y");
                    jSONArray.add(asJsonObject);
                } else {
                    jSONArray.add(asJsonObject);
                }
            }
            SharedPref.getInstance(getContext()).setSearchedAllHousesData(jSONArray.toString());
        } catch (Exception e) {
            Logger.d("All houses", e.getMessage());
            Logger.d(this.errorString, "Failed to read");
        }
    }

    private void showDeletionDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) BloBottomSheetDeletionLayoutBinding.inflate(getLayoutInflater()).getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        final TextView textView = (TextView) dialog.findViewById(R.id.btn_Proceed);
        TextView textView2 = (TextView) dialog.findViewById(R.id.first_name_tv);
        RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.bottom_sheet_rg);
        final RadioGroup radioGroup2 = (RadioGroup) dialog.findViewById(R.id.bottom_sheet_rg2);
        final RadioButton radioButton = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.same_epic_rb);
        final RadioButton radioButton2 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.other_elector_rb);
        radioButton.setEnabled(false);
        radioButton.setChecked(false);
        radioButton2.setChecked(true);
        final RadioButton radioButton3 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.object_rb);
        radioButton3.setEnabled(false);
        ((TextView) dialog.findViewById(R.id.search_by_tv)).setVisibility(0);
        dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(0);
        dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(0);
        final RadioButton radioButton4 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg2).findViewById(R.id.prefilled_epic_rb);
        final RadioButton radioButton5 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg2).findViewById(R.id.prefilled_name_rb);
        radioButton5.setChecked(false);
        radioButton5.setEnabled(false);
        radioButton4.setChecked(true);
        final EditText editText = (EditText) dialog.findViewById(R.id.bottom_sheet_epic_layout).findViewById(R.id.bottom_sheet_epic_ed);
        final EditText editText2 = (EditText) dialog.findViewById(R.id.bottom_sheet_epic_layout2).findViewById(R.id.bottom_sheet_epic_ed2);
        editText2.setText(this.epicNumberNew);
        editText2.setEnabled(false);
        final EditText editText3 = (EditText) dialog.findViewById(R.id.bottom_sheet_name_layout).findViewById(R.id.bottom_sheet_firstname_ed);
        final EditText editText4 = (EditText) dialog.findViewById(R.id.bottom_sheet_name_layout).findViewById(R.id.bottom_sheet_lastname_ed);
        textView.setText(this.verifyFillForm7String);
        editText.requestFocus();
        textView2.setText(mandatorymarker(textView2.getText().toString()));
        editText3.setEnabled(false);
        editText4.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda41
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i) {
                this.f$0.lambda$showDeletionDialog$66(radioButton, textView, dialog, editText2, editText3, editText4, radioButton2, radioButton4, radioButton5, radioGroup2, radioButton3, radioGroup3, i);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDeletionDialog$67(editText, editText2, editText3, editText4, radioButton2, radioButton4, radioButton5, radioButton3, radioButton, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$66(RadioButton radioButton, final TextView textView, final Dialog dialog, final EditText editText, final EditText editText2, final EditText editText3, RadioButton radioButton2, final RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup, RadioButton radioButton5, RadioGroup radioGroup2, int i) {
        if (radioButton.isChecked()) {
            textView.setText(this.verifyFillForm7String);
            dialog.findViewById(R.id.search_by_tv).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            editText.setEnabled(false);
            editText.setText("");
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            return;
        }
        if (radioButton2.isChecked()) {
            textView.setText(this.verifyFillForm7String);
            dialog.findViewById(R.id.search_by_tv).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            radioButton3.setChecked(true);
            radioButton4.setChecked(false);
            editText.setEnabled(true);
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            editText.requestFocus();
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$$ExternalSyntheticLambda59
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i2) {
                    this.f$0.lambda$showDeletionDialog$65(radioButton3, textView, dialog, editText, editText2, editText3, radioGroup3, i2);
                }
            });
            return;
        }
        if (radioButton5.isChecked()) {
            textView.setText("Select Applicant");
            editText2.setText("");
            editText3.setText("");
            dialog.findViewById(R.id.search_by_tv).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(0);
            editText2.setEnabled(true);
            editText3.setEnabled(true);
            editText2.requestFocus();
            editText.setEnabled(false);
            editText.setText("");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$65(RadioButton radioButton, TextView textView, Dialog dialog, EditText editText, EditText editText2, EditText editText3, RadioGroup radioGroup, int i) {
        if (radioButton.isChecked()) {
            textView.setText(this.verifyFillForm7String);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            editText.setEnabled(true);
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            return;
        }
        textView.setText("Select Applicant");
        dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
        dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(0);
        editText2.setEnabled(true);
        editText3.setEnabled(true);
        editText2.requestFocus();
        editText.setEnabled(false);
        editText.setText("");
        editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$67(EditText editText, EditText editText2, EditText editText3, EditText editText4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, Dialog dialog, View view) {
        this.epicNumberId = editText.getText().toString().toUpperCase();
        this.epicNumberId2 = editText2.getText().toString().toUpperCase();
        this.firstnameId = capitailizeWord(editText3.getText().toString().toLowerCase());
        this.lastnameId = capitailizeWord(editText4.getText().toString().toLowerCase());
        Logger.d("epicNumberId ", this.epicNumberId);
        Logger.d("epicNumberIdOther ", this.epicNumberId2);
        this.epicNumberStatus = "";
        this.epicNumber = "";
        this.epicNumber2 = "";
        this.firstname = "";
        this.lastname = "";
        this.payloadForm7 = null;
        this.payloadForm72 = null;
        if (editText.getText().toString().isEmpty()) {
            showDialog("Enter Applicant's EPIC Number ");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (!editText.getText().toString().isEmpty() && !editText.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Enter Applicant's correct EPIC Number ");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton2.isChecked() && editText2.getText().toString().isEmpty()) {
            showDialog("Enter Other Elector's EPIC Number ");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton2.isChecked() && !editText2.getText().toString().isEmpty() && !editText2.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Enter Other Elector's correct EPIC Number ");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton3.isChecked() && editText3.getText().toString().isEmpty()) {
            showDialog("Enter Other Elector's Name ");
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else if (radioButton4.isChecked() && editText3.getText().toString().isEmpty()) {
            showDialog("Enter Name ");
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.alertDialog.show();
            HashMap map = new HashMap();
            map.put(this.epicNumberString2, this.epicNumberId);
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass12(editText, radioButton5, dialog, radioButton, radioButton2, editText2, radioButton3, editText3, editText4, radioButton4));
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonArray> {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ EditText val$epicEd;
        final /* synthetic */ EditText val$epicEd2;
        final /* synthetic */ RadioButton val$epicrb;
        final /* synthetic */ EditText val$firstNameEd;
        final /* synthetic */ EditText val$lastNameEd;
        final /* synthetic */ RadioButton val$namerb;
        final /* synthetic */ RadioButton val$objectionRb;
        final /* synthetic */ RadioButton val$otherElectorRb;
        final /* synthetic */ RadioButton val$sameEpicRb;

        AnonymousClass12(final EditText val$epicEd, final RadioButton val$sameEpicRb, final Dialog val$dialog, final RadioButton val$otherElectorRb, final RadioButton val$epicrb, final EditText val$epicEd2, final RadioButton val$namerb, final EditText val$firstNameEd, final EditText val$lastNameEd, final RadioButton val$objectionRb) {
            this.val$epicEd = val$epicEd;
            this.val$sameEpicRb = val$sameEpicRb;
            this.val$dialog = val$dialog;
            this.val$otherElectorRb = val$otherElectorRb;
            this.val$epicrb = val$epicrb;
            this.val$epicEd2 = val$epicEd2;
            this.val$namerb = val$namerb;
            this.val$firstNameEd = val$firstNameEd;
            this.val$lastNameEd = val$lastNameEd;
            this.val$objectionRb = val$objectionRb;
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                ArrayList arrayList = new ArrayList();
                JsonArray jsonArray = (JsonArray) response.body();
                for (int i = 0; i < jsonArray.size(); i++) {
                    H2HDETAILS.this.payloadForm7 = jsonArray.get(i).get(H2HDETAILS.this.contentString);
                    String strTrim = String.valueOf(H2HDETAILS.this.payloadForm7.get(H2HDETAILS.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim2 = String.valueOf(H2HDETAILS.this.payloadForm7.get(H2HDETAILS.this.partNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    if (H2HDETAILS.this.asmblyNO.equals(strTrim) && H2HDETAILS.this.partNo.equals(strTrim2)) {
                        arrayList.add(strTrim2);
                    }
                }
                if (arrayList.isEmpty()) {
                    H2HDETAILS.this.showDialog(H2HDETAILS.this.noRecordFoundString + H2HDETAILS.this.epicNumberId);
                    this.val$epicEd.setText("");
                    H2HDETAILS.this.alertDialog.dismiss();
                    return;
                }
                if (this.val$sameEpicRb.isChecked()) {
                    H2HDETAILS.this.request = "same";
                    H2HDETAILS.this.epicNumber = this.val$epicEd.getText().toString().toUpperCase();
                    Bundle bundle = new Bundle();
                    bundle.putString(H2HDETAILS.this.requestString, H2HDETAILS.this.request);
                    bundle.putString(H2HDETAILS.this.voterIdString, H2HDETAILS.this.epicNumber);
                    bundle.putString(H2HDETAILS.this.voterId2String, H2HDETAILS.this.epicNumber2);
                    bundle.putString(H2HDETAILS.this.firstnamefromdbString, H2HDETAILS.this.firstname);
                    bundle.putString(H2HDETAILS.this.lastnamefromdbString, H2HDETAILS.this.lastname);
                    bundle.putString("applicantEpicDetailsArray", jsonArray.toString());
                    NameRecyclerView nameRecyclerView = new NameRecyclerView();
                    nameRecyclerView.setArguments(bundle);
                    H2HDETAILS.this.openFragment(nameRecyclerView, "Deletion Objection for Self");
                    this.val$dialog.dismiss();
                    H2HDETAILS.this.alertDialog.dismiss();
                    return;
                }
                if (this.val$otherElectorRb.isChecked() && this.val$epicrb.isChecked()) {
                    if (H2HDETAILS.this.epicNumberId2.equals(H2HDETAILS.this.epicNumberId)) {
                        H2HDETAILS.this.showDialog("Applicant's EPIC Number and other Elector's EPIC Number cannot be same. Please enter different EPIC numbers.");
                        this.val$epicEd2.setBackgroundTintList(H2HDETAILS.this.getContext().getResources().getColorStateList(R.color.blo_red));
                        this.val$epicEd2.setText("");
                        H2HDETAILS.this.alertDialog.dismiss();
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put(H2HDETAILS.this.epicNumberString2, H2HDETAILS.this.epicNumberId2);
                    H2HDETAILS.this.commonUtilClass.getRetrofitClient(H2HDETAILS.this.getContext(), H2HDETAILS.this.token, H2HDETAILS.this.atkband, H2HDETAILS.this.rtkband).getByEpicForForm(H2HDETAILS.this.token, H2HDETAILS.this.atkband, H2HDETAILS.this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass1(jsonArray));
                    return;
                }
                if (this.val$otherElectorRb.isChecked() && this.val$namerb.isChecked()) {
                    HashMap map2 = new HashMap();
                    map2.put(Constants.FIRST_NAME, H2HDETAILS.this.firstname);
                    map2.put(Constants.LAST_NAME, H2HDETAILS.this.lastname);
                    map2.put("stateCd", H2HDETAILS.this.stateCode);
                    map2.put("acNo", H2HDETAILS.this.asmblyNO);
                    map2.put("isActive", "Y");
                    H2HDETAILS.this.commonUtilClass.getRetrofitClient(H2HDETAILS.this.getContext(), H2HDETAILS.this.token, H2HDETAILS.this.atkband, H2HDETAILS.this.rtkband).getByDetailsForForm(H2HDETAILS.this.token, SharedPref.getInstance(H2HDETAILS.this.getContext()).getAtknBnd(), SharedPref.getInstance(H2HDETAILS.this.getContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB", map2).enqueue(new AnonymousClass2(jsonArray));
                    return;
                }
                if (this.val$objectionRb.isChecked()) {
                    H2HDETAILS.this.commonUtilClass.getRetrofitClient(H2HDETAILS.this.getContext(), H2HDETAILS.this.token, H2HDETAILS.this.atkband, H2HDETAILS.this.rtkband).getForm7byfirstNameAndlastNameObjection(H2HDETAILS.this.firstname, H2HDETAILS.this.lastname, H2HDETAILS.this.stateCode, H2HDETAILS.this.asmblyNO, H2HDETAILS.this.token, SharedPref.getInstance(H2HDETAILS.this.getContext()).getAtknBnd(), SharedPref.getInstance(H2HDETAILS.this.getContext()).getRtknBnd(), "BLOAPP", "blo", H2HDETAILS.this.stateCode, "ANDROIDMOB").enqueue(new AnonymousClass3(jsonArray));
                    return;
                }
                return;
            }
            try {
                if (response.code() == 401) {
                    CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                    Context contextRequireContext = H2HDETAILS.this.requireContext();
                    String str = H2HDETAILS.this.refreshToken;
                    final EditText editText = this.val$epicEd;
                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str2, String str3) {
                            this.f$0.lambda$onResponse$1(editText, i2, str2, str3);
                        }
                    });
                } else {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                    Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
                    H2HDETAILS.this.alertDialog.dismiss();
                    H2HDETAILS.this.showDialog(strOptString);
                }
            } catch (Exception e) {
                H2HDETAILS.this.alertDialog.dismiss();
                if (response.code() == 401) {
                    CommomUtility commomUtility2 = H2HDETAILS.this.commomUtility;
                    Context contextRequireContext2 = H2HDETAILS.this.requireContext();
                    String str2 = H2HDETAILS.this.refreshToken;
                    final EditText editText2 = this.val$epicEd;
                    commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$$ExternalSyntheticLambda3
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$3(editText2, i2, str3, str4);
                        }
                    });
                } else if (response.code() != 200 && response.message() != null) {
                    H2HDETAILS.this.showDialog(response.message());
                } else {
                    H2HDETAILS.this.showDialog(H2HDETAILS.this.noRecordFoundString + H2HDETAILS.this.epicNumberId);
                }
                Logger.d("", e.getMessage());
            }
            this.val$epicEd.setText("");
            H2HDETAILS.this.alertDialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JsonArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            AnonymousClass1(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray jsonArray = (JsonArray) response.body();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        H2HDETAILS.this.payloadForm72 = jsonArray.get(i).get(H2HDETAILS.this.contentString);
                        String strTrim = String.valueOf(H2HDETAILS.this.payloadForm72.get(H2HDETAILS.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        String strTrim2 = String.valueOf(H2HDETAILS.this.payloadForm72.get(H2HDETAILS.this.partNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (H2HDETAILS.this.asmblyNO.equals(strTrim) && H2HDETAILS.this.partNo.equals(strTrim2)) {
                            arrayList.add(strTrim2);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        H2HDETAILS.this.showDialog(H2HDETAILS.this.noRecordFoundString + H2HDETAILS.this.epicNumber2);
                        AnonymousClass12.this.val$epicEd2.setText("");
                        H2HDETAILS.this.alertDialog.dismiss();
                        return;
                    }
                    H2HDETAILS.this.request = H2HDETAILS.this.otherString;
                    H2HDETAILS.this.epicNumber = AnonymousClass12.this.val$epicEd.getText().toString().toUpperCase();
                    H2HDETAILS.this.epicNumber2 = AnonymousClass12.this.val$epicEd2.getText().toString().toUpperCase();
                    Logger.d(H2HDETAILS.this.requestTypeString, H2HDETAILS.this.request);
                    Logger.d("Applicant's EPIC: ", H2HDETAILS.this.epicNumber);
                    Logger.d("Other Elector's EPIC: ", H2HDETAILS.this.epicNumber2);
                    Intent intent = new Intent((Context) H2HDETAILS.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                    intent.putExtra("fromH2h", "Y");
                    intent.putExtra(H2HDETAILS.this.requestString, H2HDETAILS.this.request);
                    intent.putExtra("subRequest", "epic");
                    intent.putExtra(H2HDETAILS.this.voterIdString, H2HDETAILS.this.epicNumber);
                    intent.putExtra(H2HDETAILS.this.voterId2String, H2HDETAILS.this.epicNumber2);
                    intent.putExtra(H2HDETAILS.this.firstnamefromdbString, H2HDETAILS.this.firstname);
                    intent.putExtra(H2HDETAILS.this.lastnamefromdbString, H2HDETAILS.this.lastname);
                    intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                    intent.putExtra("objecteeEpicDetailsArray", jsonArray.toString());
                    H2HDETAILS.this.startActivity(intent);
                    AnonymousClass12.this.val$dialog.dismiss();
                    H2HDETAILS.this.alertDialog.dismiss();
                    return;
                }
                if (response.code() == 401) {
                    CommomUtility commomUtility = H2HDETAILS.this.commomUtility;
                    Context contextRequireContext = H2HDETAILS.this.requireContext();
                    String str = H2HDETAILS.this.refreshToken;
                    final EditText editText = AnonymousClass12.this.val$epicEd2;
                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$1$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str2, String str3) {
                            this.f$0.lambda$onResponse$1(editText, i2, str2, str3);
                        }
                    });
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                    Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
                    H2HDETAILS.this.alertDialog.dismiss();
                    H2HDETAILS.this.showDialog(strOptString);
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    H2HDETAILS.this.alertDialog.dismiss();
                    if (response.code() == 401) {
                        CommomUtility commomUtility2 = H2HDETAILS.this.commomUtility;
                        Context contextRequireContext2 = H2HDETAILS.this.requireContext();
                        String str2 = H2HDETAILS.this.refreshToken;
                        final EditText editText2 = AnonymousClass12.this.val$epicEd2;
                        commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$1$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str3, String str4) {
                                this.f$0.lambda$onResponse$3(editText2, i2, str3, str4);
                            }
                        });
                    } else if (response.code() != 200 && response.message() != null) {
                        H2HDETAILS.this.showDialog(response.message());
                    } else {
                        H2HDETAILS.this.showDialog(H2HDETAILS.this.noRecordFoundString + H2HDETAILS.this.epicNumber2);
                    }
                }
                AnonymousClass12.this.val$epicEd2.setText("");
                H2HDETAILS.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(EditText editText, int i, String str, String str2) {
                H2HDETAILS.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                if (i == 401 || i == 400) {
                    H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$1$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                H2HDETAILS.this.token = "Bearer " + str;
                Toast.makeText(H2HDETAILS.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
                H2HDETAILS.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
                H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$3(EditText editText, int i, String str, String str2) {
                H2HDETAILS.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                if (i == 401 || i == 400) {
                    H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$1$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i2);
                        }
                    });
                    return;
                }
                H2HDETAILS.this.token = "Bearer " + str;
                Toast.makeText(H2HDETAILS.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
                H2HDETAILS.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
                H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                H2HDETAILS.this.showDialog("Other Epic: " + H2HDETAILS.this.tryAgainString);
                AnonymousClass12.this.val$epicEd2.setText("");
                H2HDETAILS.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$2, reason: invalid class name */
        class AnonymousClass2 implements Callback<JsonArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            AnonymousClass2(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.body() != null && ((JsonArray) response.body()).size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray jsonArray = (JsonArray) response.body();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        H2HDETAILS.this.payloadForm72 = jsonArray.get(i).get(H2HDETAILS.this.contentString);
                        String strTrim = String.valueOf(H2HDETAILS.this.payloadForm72.get(H2HDETAILS.this.partNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (H2HDETAILS.this.partNo.equals(strTrim)) {
                            arrayList.add(strTrim);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        H2HDETAILS.this.showDialog("No Record found with name: " + H2HDETAILS.this.firstname + " " + H2HDETAILS.this.lastname);
                        AnonymousClass12.this.val$firstNameEd.setText("");
                        AnonymousClass12.this.val$lastNameEd.setText("");
                        H2HDETAILS.this.alertDialog.dismiss();
                        return;
                    }
                    H2HDETAILS.this.request = H2HDETAILS.this.otherString;
                    H2HDETAILS.this.epicNumber = AnonymousClass12.this.val$epicEd.getText().toString().toUpperCase();
                    H2HDETAILS.this.firstname = H2HDETAILS.capitailizeWord(AnonymousClass12.this.val$firstNameEd.getText().toString().toLowerCase());
                    H2HDETAILS.this.lastname = H2HDETAILS.capitailizeWord(AnonymousClass12.this.val$lastNameEd.getText().toString().toLowerCase());
                    Logger.d(H2HDETAILS.this.requestTypeString, H2HDETAILS.this.request);
                    Logger.d("First Name: ", H2HDETAILS.this.firstname);
                    Logger.d("Last Name: ", H2HDETAILS.this.lastname);
                    Intent intent = new Intent((Context) H2HDETAILS.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                    intent.putExtra(H2HDETAILS.this.requestString, H2HDETAILS.this.request);
                    intent.putExtra("subRequest", "name");
                    intent.putExtra(H2HDETAILS.this.voterIdString, H2HDETAILS.this.epicNumber);
                    intent.putExtra(H2HDETAILS.this.voterId2String, H2HDETAILS.this.epicNumber2);
                    intent.putExtra(H2HDETAILS.this.firstnamefromdbString, H2HDETAILS.this.firstname);
                    intent.putExtra(H2HDETAILS.this.lastnamefromdbString, H2HDETAILS.this.lastname);
                    intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                    intent.putExtra("objecteeEpicDetailsArray", jsonArray.toString());
                    H2HDETAILS.this.startActivity(intent);
                    AnonymousClass12.this.val$dialog.dismiss();
                    H2HDETAILS.this.alertDialog.dismiss();
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                    Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
                    H2HDETAILS.this.alertDialog.dismiss();
                    H2HDETAILS.this.showDialog("Other Name: " + strOptString);
                } catch (IOException | JSONException e) {
                    Logger.d("", e.getMessage());
                    H2HDETAILS.this.alertDialog.dismiss();
                    if (response.code() == 401) {
                        H2HDETAILS.this.commomUtility.showMessageWithTitleOK(H2HDETAILS.this.requireContext(), H2HDETAILS.this.alert, H2HDETAILS.this.sessionTokenString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$2$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                this.f$0.lambda$onResponse$0(dialogInterface, i2);
                            }
                        });
                    } else if (response.message() != null) {
                        H2HDETAILS.this.showDialog(response.message());
                    } else {
                        H2HDETAILS.this.showDialog("No Record found with name: " + H2HDETAILS.this.firstname + " " + H2HDETAILS.this.lastname);
                    }
                }
                AnonymousClass12.this.val$firstNameEd.setText("");
                AnonymousClass12.this.val$lastNameEd.setText("");
                H2HDETAILS.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(H2HDETAILS.this.getContext()).setIsLoggedIn(false);
                SharedPref.getInstance(H2HDETAILS.this.getContext()).setLocaleBool(false);
                H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                H2HDETAILS.this.showDialog("Other Name: " + H2HDETAILS.this.tryAgainString);
                AnonymousClass12.this.val$firstNameEd.setText("");
                AnonymousClass12.this.val$lastNameEd.setText("");
                H2HDETAILS.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$3, reason: invalid class name */
        class AnonymousClass3 implements Callback<JSONArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            AnonymousClass3(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.body() == null) {
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(H2HDETAILS.this.messageString);
                        Logger.e(H2HDETAILS.this.h2hDetails1, strOptString);
                        H2HDETAILS.this.alertDialog.dismiss();
                        H2HDETAILS.this.showDialog("Objection: " + strOptString);
                    } catch (IOException | JSONException e) {
                        Logger.d("", e.getMessage());
                        H2HDETAILS.this.alertDialog.dismiss();
                        if (response.code() == 401) {
                            H2HDETAILS.this.commomUtility.showMessageWithTitleOK(H2HDETAILS.this.requireContext(), H2HDETAILS.this.alert, H2HDETAILS.this.sessionTokenString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$3$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.f$0.lambda$onResponse$0(dialogInterface, i);
                                }
                            });
                        } else if (response.message() != null) {
                            H2HDETAILS.this.showDialog(response.message());
                        } else {
                            H2HDETAILS.this.alertDialog.dismiss();
                            H2HDETAILS.this.showDialog("No record found with name: " + H2HDETAILS.this.firstname + " " + H2HDETAILS.this.lastname);
                        }
                    }
                    AnonymousClass12.this.val$firstNameEd.setText("");
                    AnonymousClass12.this.val$lastNameEd.setText("");
                    H2HDETAILS.this.alertDialog.dismiss();
                    return;
                }
                H2HDETAILS.this.request = "objection";
                H2HDETAILS.this.epicNumber = AnonymousClass12.this.val$epicEd.getText().toString().toUpperCase();
                H2HDETAILS.this.firstname = H2HDETAILS.capitailizeWord(AnonymousClass12.this.val$firstNameEd.getText().toString().toLowerCase());
                H2HDETAILS.this.lastname = H2HDETAILS.capitailizeWord(AnonymousClass12.this.val$lastNameEd.getText().toString().toLowerCase());
                Logger.d(H2HDETAILS.this.requestTypeString, H2HDETAILS.this.request);
                Logger.d("First Name: ", H2HDETAILS.this.firstname);
                Logger.d("Last Name: ", H2HDETAILS.this.lastname);
                Intent intent = new Intent((Context) H2HDETAILS.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                intent.putExtra(H2HDETAILS.this.requestString, H2HDETAILS.this.request);
                intent.putExtra(H2HDETAILS.this.voterIdString, H2HDETAILS.this.epicNumber);
                intent.putExtra(H2HDETAILS.this.voterId2String, H2HDETAILS.this.epicNumber2);
                intent.putExtra(H2HDETAILS.this.firstnamefromdbString, H2HDETAILS.this.firstname);
                intent.putExtra(H2HDETAILS.this.lastnamefromdbString, H2HDETAILS.this.lastname);
                intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                intent.putExtra("objecteeEpicDetailsArray", ((JSONArray) response.body()).toString());
                H2HDETAILS.this.startActivity(intent);
                AnonymousClass12.this.val$dialog.dismiss();
                H2HDETAILS.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(H2HDETAILS.this.getContext()).setIsLoggedIn(false);
                SharedPref.getInstance(H2HDETAILS.this.getContext()).setLocaleBool(false);
                H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                H2HDETAILS.this.showDialog("Objection: " + H2HDETAILS.this.tryAgainString);
                AnonymousClass12.this.val$firstNameEd.setText("");
                AnonymousClass12.this.val$lastNameEd.setText("");
                H2HDETAILS.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(EditText editText, int i, String str, String str2) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str;
            Toast.makeText(H2HDETAILS.this.requireContext(), "Token Refreshed", 1).show();
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
            H2HDETAILS.this.showDialog("Page refreshed due to the token expiry, Please try again");
            editText.setText("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(EditText editText, int i, String str, String str2) {
            H2HDETAILS.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                H2HDETAILS.this.commomUtility.showMessageOK(H2HDETAILS.this.getContext(), H2HDETAILS.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HDETAILS$12$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HDETAILS.this.token = "Bearer " + str;
            Toast.makeText(H2HDETAILS.this.requireContext(), "Token Refreshed", 1).show();
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setToken("Bearer " + str);
            H2HDETAILS.this.showDialog("Page refreshed due to the token expiry, Please try again");
            editText.setText("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HDETAILS.this.requireContext()).setLocaleBool(false);
            H2HDETAILS.this.startActivity(new Intent((Context) H2HDETAILS.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            H2HDETAILS.this.showDialog("Applicant Epic: Please try again later");
            this.val$epicEd.setText("");
            H2HDETAILS.this.alertDialog.dismiss();
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
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment3(Fragment fragment, String selectedFragment) {
        Logger.d(this.logTag, "openFragment3 : voterIdNumberOpen" + this.epicIdForForm6B);
        Bundle bundle = new Bundle();
        bundle.putString(this.voterIdText, this.epicIdForForm6B);
        bundle.putString(this.formText, "Voter Forms");
        bundle.putString("stateNameForForm6B", this.stateNameForForm6B);
        bundle.putString("districtNameForForm6B", this.districtNameForForm6B);
        bundle.putString("acNameForForm6B", this.acNameForForm6B);
        bundle.putString("assemblyNoForForm6B", this.assemblyNoForForm6B);
        bundle.putString("firstNameForForm6B", this.firstNameForForm6B);
        bundle.putString("lastNameForForm6B", this.lastNameForForm6B);
        bundle.putString("mobileNoForForm6B", this.mobileNoForForm6B);
        bundle.putString("emailIdForForm6B", this.emailIdForForm6B);
        bundle.putString("stateCdForForm6B", this.stateCdForForm6B);
        Logger.d(this.logTag, "openFragment3 Bundle : " + bundle);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
