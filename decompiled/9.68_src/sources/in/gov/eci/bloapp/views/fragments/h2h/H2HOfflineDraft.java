package in.gov.eci.bloapp.views.fragments.h2h;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentH2HOflineDraftBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class H2HOfflineDraft extends BaseFragment {
    ActivityResultLauncher<Intent> activityResultLauncher;
    String alertString;
    String base64element1;
    BloFragmentH2HOflineDraftBinding binding;
    Retrofit.Builder builder;
    private byte[] byteArray;
    Date c;
    private String docRef;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    String formattedDate;
    String inserted;
    JSONParser parser;
    String refreshToken;
    Retrofit retrofit;
    SimpleDateFormat todayDate;
    String partSerialNumber = "";
    String epicNo = "";
    String applicantName = "";
    String mobileNo = "";
    String gender = "";
    String email = "";
    String aadharNo = "";
    String dob = "";
    String age = "";
    String relativeName = "";
    String relativeType = "";
    String houseNo = "";
    String village = "";
    String postOffice = "";
    String acNo = "";
    String localitySreet = "";
    String SESSION = "Session Expired. Please Login again..";
    String address = "";
    String pinCode = "";
    String pinCodeOld = "";
    String h2hTagString = "H2HDETAILS";
    String cancelText = "Cancel";
    String partNoString = "partNo";
    String stateCodeString = "stateCode";
    String garudaTag = "GARUDA";
    String tehsil = "";
    String partNo = "";
    String stateCode = "";
    String coordinate = "";
    String residingPeriod = "";
    String houseApplicantFound = "";
    String isAadharVerified = "";
    String isElectorRecordSame = "";
    String allDetailsVerified = "";
    String isAddressRecordSame = "";
    String isDobRecordSame = "";
    String photographEleIsCorrect = "";
    String disabilityType = "";
    String isVisual = "";
    String sectionNo = "";
    String isPwd = "";
    String isDeaf = "";
    String pwdPercentage = "";
    int isMetElector = 0;
    String phoneNumberVerified = "";
    String applicantNameString = "applicantName";
    String houseNoString = "houseNo";
    String misDocumentString = "misDocument";
    String isLocomotive = "";
    String otherDisability = "";
    String dateOfVerification = "";
    String addressAttachment = "";
    String dobAttachment = "";
    String misDocument = "";
    String remarks = "";
    String sectionName = "";
    String applicantNameRegional = "";
    String relativeNameRegional = "";
    String photo = "";
    String token = "";
    String districtCode = "";
    String stateName = "";
    String districtName = "";
    String assemblyName = "";
    CommomUtility commomUtility = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public H2HOfflineDraft() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.docRef = "NA";
        this.c = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault());
        this.todayDate = simpleDateFormat;
        this.formattedDate = simpleDateFormat.format(this.c);
        this.inserted = "INSERTED";
        this.alertString = "Alert";
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda13
            public final void onActivityResult(Object obj) throws Throwable {
                this.f$0.lambda$new$0((ActivityResult) obj);
            }
        });
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
                    Logger.d(this.h2hTagString, e.getMessage());
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
                        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_grey_line));
                        this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        saveimageapi(this.saveImageFileName);
                    } else {
                        dRound = Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                        if (dRound > 3.0d) {
                            showdialog1(this.alertString, "PDF size exceeded 3MB limit.");
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
                    showdialog1("", "Please Select the correct format of file");
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
                        showdialog1(this.alertString, "PDF size exceeded 3MB limit.");
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
                Logger.d("CONTENT", e2.getMessage());
                return;
            }
        } catch (IOException e3) {
            e = e3;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        this.byteArray = byteArray2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentH2HOflineDraftBinding.inflate(getLayoutInflater());
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.assemblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Bundle arguments = getArguments();
        boolean z = true;
        if (arguments != null) {
            this.epicNo = arguments.getString("epicNo");
            this.applicantName = arguments.getString(this.applicantNameString);
            this.mobileNo = arguments.getString("mobileNo");
            this.gender = arguments.getString("gender");
            this.email = arguments.getString("email");
            this.aadharNo = arguments.getString("aadharNo");
            this.dob = arguments.getString("dob");
            this.age = arguments.getString("age");
            this.relativeName = arguments.getString("relativeName");
            this.relativeType = arguments.getString("relativeType");
            this.houseNo = arguments.getString(this.houseNoString);
            this.village = arguments.getString("village");
            this.postOffice = arguments.getString("postOffice");
            this.acNo = arguments.getString("acNo");
            this.localitySreet = arguments.getString("localitySreet");
            this.address = arguments.getString("address");
            this.pinCodeOld = arguments.getString("pinCode");
            String str = this.pinCode;
            if (str != null && !str.equals("")) {
                this.pinCode = this.pinCodeOld.substring(0, 6);
                this.tehsil = this.pinCodeOld.substring(7);
            }
            this.partNo = arguments.getString(this.partNoString);
            this.stateCode = arguments.getString(this.stateCodeString);
            this.coordinate = arguments.getString("coordinate");
            this.residingPeriod = arguments.getString("residingPeriod");
            this.houseApplicantFound = arguments.getString("houseApplicantFound");
            this.isAadharVerified = arguments.getString("isAadharVerified");
            this.isElectorRecordSame = arguments.getString("isElectorRecordSame");
            this.allDetailsVerified = arguments.getString("allDetailsVerified");
            this.isAddressRecordSame = arguments.getString("isAddressRecordSame");
            this.isDobRecordSame = arguments.getString("isDobRecordSame");
            this.photographEleIsCorrect = arguments.getString("photographEleIsCorrect");
            this.disabilityType = arguments.getString("disabilityType");
            this.isVisual = arguments.getString("isVisual");
            this.sectionNo = arguments.getString("sectionNo");
            this.isPwd = arguments.getString("isPwd");
            this.isDeaf = arguments.getString("isDeaf");
            this.pwdPercentage = arguments.getString("pwdPercentage");
            this.isLocomotive = arguments.getString("isLocomotive");
            this.otherDisability = arguments.getString("otherDisability");
            this.isMetElector = arguments.getInt("isMetElector");
            this.phoneNumberVerified = arguments.getString("phoneNumberVerified");
            this.dateOfVerification = arguments.getString("dateOfVerification");
            this.addressAttachment = arguments.getString("addressAttachment");
            this.dobAttachment = arguments.getString("dobAttachment");
            this.misDocument = arguments.getString(this.misDocumentString);
            this.remarks = arguments.getString("remarks");
            this.sectionName = arguments.getString("sectionName");
            this.applicantNameRegional = arguments.getString("applicantNameRegional");
            this.relativeNameRegional = arguments.getString("relativeNameRegional");
            this.photo = arguments.getString("photo");
            this.partSerialNumber = arguments.getString("partSerialNumber");
            Logger.d(this.h2hTagString, "epicNo><><><><><><><><><><><" + this.epicNo);
            Logger.d(this.h2hTagString, "applicantName><><><><><><><><><><><" + this.applicantName);
            Logger.d(this.h2hTagString, "mobileNo><><><><><><><><><><><" + this.mobileNo);
            Logger.d(this.h2hTagString, "gender><><><><><><><><><><><" + this.gender);
            Logger.d(this.h2hTagString, "email><><><><><><><><><><><" + this.email);
            Logger.d(this.h2hTagString, "aadharNo><><><><><><><><><><><" + this.aadharNo);
            Logger.d(this.h2hTagString, "dob><><><><><><><><><><><" + this.dob);
            Logger.d(this.h2hTagString, "age><><><><><><><><><><><" + this.age);
            Logger.d(this.h2hTagString, "relativeName><><><><><><><><><><><" + this.relativeName);
            Logger.d(this.h2hTagString, "relativeType><><><><><><><><><><><" + this.relativeType);
            Logger.d(this.h2hTagString, "houseNo><><><><><><><><><><><" + this.houseNo);
            Logger.d(this.h2hTagString, "village><><><><><><><><><><><" + this.village);
            Logger.d(this.h2hTagString, "postOffice><><><><><><><><><><><" + this.postOffice);
            Logger.d(this.h2hTagString, "acNo><><><><><><><><><><><" + this.acNo);
            Logger.d(this.h2hTagString, "localitySreet><><><><><><><><><><><" + this.localitySreet);
            Logger.d(this.h2hTagString, "address><><><><><><><><><><><" + this.address);
            Logger.d(this.h2hTagString, "pinCode><><><><><><><><><><><" + this.pinCode);
            Logger.d(this.h2hTagString, "tehsil><><><><><><><><><><><" + this.tehsil);
            Logger.d(this.h2hTagString, "partNo><><><><><><><><><><><" + this.partNo);
            Logger.d(this.h2hTagString, "stateCode><><><><><><><><><><><" + this.stateCode);
            Logger.d(this.h2hTagString, "coordinate><><><><><><><><><><><" + this.coordinate);
            Logger.d(this.h2hTagString, "residingPeriod><><><><><><><><><><><" + this.residingPeriod);
            Logger.d(this.h2hTagString, "houseApplicantFound><><><><><><><><><><><" + this.houseApplicantFound);
            Logger.d(this.h2hTagString, "isAadharVerified><><><><><><><><><><><" + this.isAadharVerified);
            Logger.d(this.h2hTagString, "isElectorRecordSame><><><><><><><><><><><" + this.isElectorRecordSame);
            Logger.d(this.h2hTagString, "allDetailsVerified><><><><><><><><><><><" + this.allDetailsVerified);
            Logger.d(this.h2hTagString, "isAddressRecordSame><><><><><><><><><><><" + this.isAddressRecordSame);
            Logger.d(this.h2hTagString, "isDobRecordSame><><><><><><><><><><><" + this.isDobRecordSame);
            Logger.d(this.h2hTagString, "photographEleIsCorrect><><><><><><><><><><><" + this.photographEleIsCorrect);
            Logger.d(this.h2hTagString, "disabilityType><><><><><><><><><><><" + this.disabilityType);
            Logger.d(this.h2hTagString, "isVisual><><><><><><><><><><><" + this.isVisual);
            Logger.d(this.h2hTagString, "sectionNo><><><><><><><><><><><" + this.sectionNo);
            Logger.d(this.h2hTagString, "isPwd><><><><><><><><><><><" + this.isPwd);
            Logger.d(this.h2hTagString, "isDeaf><><><><><><><><><><><" + this.isDeaf);
            Logger.d(this.h2hTagString, "pwdPercentage><><><><><><><><><><><" + this.pwdPercentage);
            Logger.d(this.h2hTagString, "isLocomotive><><><><><><><><><><><" + this.isLocomotive);
            Logger.d(this.h2hTagString, "otherDisability><><><><><><><><><><><" + this.otherDisability);
            Logger.d(this.h2hTagString, "isMetElector><><><><><><><><><><><" + this.isMetElector);
            Logger.d(this.h2hTagString, "phoneNumberVerified><><><><><><><><><><><" + this.phoneNumberVerified);
            Logger.d(this.h2hTagString, "dateOfVerification><><><><><><><><><><><" + this.dateOfVerification);
            Logger.d(this.h2hTagString, "addressAttachment><><><><><><><><><><><" + this.addressAttachment);
            Logger.d(this.h2hTagString, "dobAttachment><><><><><><><><><><><" + this.dobAttachment);
            Logger.d(this.h2hTagString, "misDocument><><><><><><><><><><><" + this.misDocument);
            Logger.d(this.h2hTagString, "remarks><><><><><><><><><><><" + this.remarks);
            Logger.d(this.h2hTagString, "sectionName><><><><><><><><><><><" + this.sectionName);
            Logger.d(this.h2hTagString, "applicantNameRegional><><><><><><><><><><><" + this.applicantNameRegional);
            Logger.d(this.h2hTagString, "relativeNameRegional><><><><><><><><><><><" + this.relativeNameRegional);
            Logger.d(this.h2hTagString, "photo><><><><><><><><><><><" + this.photo);
            Logger.d(this.h2hTagString, "partSerialNumber<><><><><><><><><><" + this.partSerialNumber);
            if (this.misDocument.isEmpty() || this.misDocument.equals("null")) {
                this.binding.ReviewMisDoc.setVisibility(0);
                this.binding.ReviewMisDoc1.setVisibility(0);
            } else {
                this.binding.ReviewMisDoc.setVisibility(8);
                this.binding.ReviewMisDoc1.setVisibility(8);
            }
            this.binding.ReviewDetails.setVisibility(0);
            String str2 = this.acNo + " - " + this.assemblyName;
            this.binding.mainheadingTv.setText("H. NO. " + this.houseNo);
            this.binding.ReviewACName.setText(str2);
            this.binding.ReviewdistrictName.setText(this.districtName);
            this.binding.ReviewpartNumber.setText(this.partNo);
            this.binding.ReviewSection.setText(this.sectionName);
            this.binding.ReviewapplicantNameTv1.setText(this.applicantName);
            this.binding.ReviewapplicantNameRegionalTv1.setText(this.applicantNameRegional);
            this.binding.ReviewepicNumberTv1.setText(this.epicNo);
            this.binding.ReviewrelativeTv1.setText(this.relativeName);
            this.binding.ReviewrelativeRegionalTv1.setText(this.relativeNameRegional);
            this.binding.ReviewrelativeTypeTv.setText(this.relativeType);
            this.binding.ReviewmobnumTv.setText(this.mobileNo);
            this.binding.ReviewemailTv.setText(this.email);
            this.binding.ReviewageTv.setText(this.age);
            this.binding.ReviewRemark.setText(this.remarks);
            this.binding.ReviewstreetTv.setText(this.localitySreet);
            this.binding.ReviewdobEd.setText(this.residingPeriod);
            this.binding.ReviewPWDPercentage.setText(this.pwdPercentage);
            this.binding.ReviewPWDOtherDisablity.setText(this.otherDisability);
            this.binding.ReviewMobnumElector.setText(this.phoneNumberVerified);
            try {
                this.binding.ReviewverificationDateEd.setText(simpleDateFormat.format((Date) Objects.requireNonNull(simpleDateFormat2.parse(String.valueOf(this.dateOfVerification)))));
            } catch (ParseException e) {
                Logger.e("H2HOfflineDraftError", e.getMessage());
            }
            try {
                this.binding.ReviewdobTv.setText(simpleDateFormat.format((Date) Objects.requireNonNull(simpleDateFormat2.parse(String.valueOf(this.dob)))));
            } catch (ParseException e2) {
                Logger.e("H2HOfflineDraftError", e2.getMessage());
            }
            if (this.gender.equalsIgnoreCase("M")) {
                this.binding.ReviewgenderTv1.setText("Male");
            } else if (this.gender.equalsIgnoreCase("F")) {
                this.binding.ReviewgenderTv1.setText("Female");
            } else {
                this.binding.ReviewgenderTv1.setText("Third Gender");
            }
            if (this.houseApplicantFound.equalsIgnoreCase("Present")) {
                this.binding.reviewHouseVisitRGCorrect.setChecked(true);
            } else if (this.houseApplicantFound.equalsIgnoreCase("Absent")) {
                this.binding.ReviewphotographRGAbsent.setChecked(true);
            } else if (this.houseApplicantFound.equalsIgnoreCase("Expired")) {
                this.binding.reviewHouseVisitRG1.setChecked(true);
            } else if (this.houseApplicantFound.equalsIgnoreCase("Shifted")) {
                this.binding.reviewHouseVisitRG2.setChecked(true);
            } else if (this.houseApplicantFound.equalsIgnoreCase("Repeated")) {
                this.binding.reviewHouseVisitRG3.setChecked(true);
            }
            if (this.photographEleIsCorrect.equalsIgnoreCase("Y")) {
                this.binding.ReviewphotographRG1.setChecked(true);
            } else {
                this.binding.ReviewphotographRG2.setChecked(true);
            }
            if (this.isElectorRecordSame.equalsIgnoreCase("Y")) {
                this.binding.ReviewisElectorRecordSameRb.setChecked(true);
            } else {
                this.binding.ReviewnotElectorRecordSameRb.setChecked(true);
            }
            if (this.isDobRecordSame.equalsIgnoreCase("Y")) {
                this.binding.ReviewisDobRecordSameRb.setChecked(true);
            } else {
                this.binding.ReviewnotDobRecordSameRb.setChecked(true);
            }
            if (this.isAddressRecordSame.equalsIgnoreCase("Y")) {
                this.binding.ReviewisAddressRecordSameRb.setChecked(true);
            } else {
                this.binding.ReviewnotAddressRecordSameRb.setChecked(true);
            }
            if (this.isPwd.equalsIgnoreCase("Y")) {
                this.binding.reviewPwdRG1.setChecked(true);
                this.binding.reviewPWDLinearLayout.setVisibility(0);
            } else {
                this.binding.reviewPwdRG2.setChecked(true);
            }
            if (this.isLocomotive.equalsIgnoreCase("Y")) {
                this.binding.reviewChkLocomotive.setChecked(true);
            }
            if (this.isVisual.equalsIgnoreCase("Y")) {
                this.binding.reviewChkVisual.setChecked(true);
            }
            if (this.isDeaf.equalsIgnoreCase("Y")) {
                this.binding.reviewChkDeafDumb.setChecked(true);
            }
            if (this.disabilityType.equalsIgnoreCase("Y")) {
                this.binding.reviewChkOther.setChecked(true);
            }
            if (this.isMetElector == 1) {
                this.binding.ReviewMetRG1.setChecked(true);
                this.binding.ReviewMetLinearLayout.setVisibility(0);
                this.binding.ReviewMobnumElector.setText(this.phoneNumberVerified);
            } else {
                this.binding.ReviewMetRG2.setChecked(true);
            }
            if (this.isAadharVerified.equalsIgnoreCase("Y")) {
                this.binding.reviewAadhaarRG1.setChecked(true);
            } else {
                this.binding.reviewAadhaarRG2.setChecked(true);
            }
            if (this.allDetailsVerified.equalsIgnoreCase("Y")) {
                this.binding.reviewAboveDetailsRG1.setChecked(true);
            } else {
                this.binding.reviewAboveDetailsRG2.setChecked(true);
            }
        }
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.submitTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.viewPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.deletebtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$6(view);
            }
        });
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft.1
            public void handleOnBackPressed() {
                H2HOfflineDraft.this.requireActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        this.binding.submitTv.setEnabled(false);
        showdialogNew("Attention", "Have you verified the entered information?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        if (isNetworkAvailable(requireContext())) {
            showProgressVisible();
            getFile1(this.photo);
            this.binding.personImage.setVisibility(0);
            this.binding.imageEnlargeTv.setVisibility(0);
            this.binding.viewPhoto.setVisibility(8);
            showProgressInVisible();
            return;
        }
        Toast.makeText(requireContext(), "Please check network", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(View view) {
        this.binding.preview.setVisibility(8);
        this.binding.chooseFileItems.setVisibility(4);
        this.binding.chooseFile.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        String str;
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.photo);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    private void showImageDialog(Bitmap img, String name) {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        touchImageView.setImageBitmap(img);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showdialogNew(String title, String msg) {
        new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogNew$9(dialogInterface, i);
            }
        }).setNegativeButton(this.cancelText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogNew$10(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogNew$9(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        houseSurveySubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogNew$10(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.binding.submitTv.setEnabled(true);
    }

    @Deprecated
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data != null ? data.getData() : null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.e(this.h2hTagString, e.getMessage());
            }
            String string = "";
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                }
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                Logger.d(this.h2hTagString, "Hii i am file name" + string);
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
                    showProgressInVisible();
                } else if (this.filesize > 2048) {
                    showProgressInVisible();
                    showdialog1(this.alertString, "Image size exceeds the limit of 2MB, Please retry.");
                } else {
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
                    showProgressInVisible();
                }
                showProgressInVisible();
            } catch (Exception e2) {
                Logger.d("H2HDETAILS22", e2.getMessage());
            }
        } else {
            showProgressInVisible();
        }
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Choose PDF from Gallery", this.cancelText};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$11(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$11(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            showProgressVisible();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose from Gallery")) {
            showProgressVisible();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            openfile1();
        } else if (charSequenceArr[i].equals(this.cancelText)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void houseSurveySubmit() {
        showProgressVisible();
        Logger.d(this.h2hTagString, "in houseSurveySubmit()..........");
        HashMap map = new HashMap();
        map.put("acNo", this.acNo);
        map.put("address", this.address);
        map.put("pwdPercentage", this.pwdPercentage);
        map.put("addressAttachment", this.addressAttachment);
        map.put("allDetailsVerified", this.allDetailsVerified);
        map.put(this.applicantNameString, this.applicantName);
        map.put("coordinate", this.coordinate);
        map.put("isPwd", this.isPwd);
        map.put("aadharNo", this.aadharNo);
        map.put("isAadharVerified", this.isAadharVerified);
        map.put("residingPeriod", this.residingPeriod);
        map.put("isLocomotive", this.isLocomotive);
        map.put("isVisual", this.isVisual);
        map.put("isDeaf", this.isDeaf);
        map.put("disabilityType", this.disabilityType);
        map.put("otherDisability", this.otherDisability);
        if (this.binding.ReviewMetRG1.isChecked() || this.isMetElector == 1) {
            this.isMetElector = 1;
            this.phoneNumberVerified = this.binding.ReviewMobnumElector.getText().toString();
        } else if (this.binding.ReviewMetRG2.isChecked() || this.isMetElector == 0) {
            this.isMetElector = 0;
            this.phoneNumberVerified = "";
        }
        map.put("metInPerson", 0);
        map.put("phoneNumberVerified", this.phoneNumberVerified);
        map.put("partSerialNumber", this.partSerialNumber);
        map.put("sectionNo", this.sectionNo);
        map.put("dateOfVerification", this.dateOfVerification);
        map.put("dob", this.dob);
        map.put("dobAttachment", this.dobAttachment);
        map.put("email", this.email);
        map.put("epicNo", this.epicNo);
        map.put("gender", this.gender);
        map.put("houseApplicantFound", this.houseApplicantFound);
        map.put(this.houseNoString, this.houseNo);
        map.put("isAddressRecordSame", this.isAddressRecordSame);
        map.put("isDobRecordSame", this.isDobRecordSame);
        map.put("photographEleIsCorrect", this.photographEleIsCorrect);
        map.put("isElectorRecordSame", this.isElectorRecordSame);
        map.put("localitySreet", this.localitySreet);
        if (this.misDocument.isEmpty() || this.misDocument.equals("null")) {
            map.put(this.misDocumentString, this.docRef);
        } else {
            map.put(this.misDocumentString, this.misDocument);
        }
        map.put("mobileNo", this.mobileNo);
        map.put(this.partNoString, this.partNo);
        map.put("relativeName", this.relativeName);
        map.put("relativeType", this.relativeType);
        map.put("remarks", this.remarks);
        map.put(this.stateCodeString, this.stateCode);
        map.put("age", this.age);
        map.put("village", this.village);
        map.put("postOffice", this.postOffice);
        map.put("pinCode", this.pinCode);
        map.put("tehsilTalukaMandal", this.tehsil);
        Logger.d(this.h2hTagString, "House survey submit json " + new JSONObject(map));
        if (isNetworkAvailable(requireContext())) {
            this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).eroSurveySubmit(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass2());
            return;
        }
        showProgressInVisible();
        this.binding.submitTv.setEnabled(true);
        Toast.makeText(requireContext(), "Please check network", 1).show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null && response.code() == 200) {
                H2HOfflineDraft.this.showProgressInVisible();
                H2HOfflineDraft.this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().deleteH2HElecorDetails(new H2HElectorDetailModel(H2HOfflineDraft.this.epicNo, H2HOfflineDraft.this.applicantName, H2HOfflineDraft.this.mobileNo, H2HOfflineDraft.this.gender, H2HOfflineDraft.this.email, H2HOfflineDraft.this.aadharNo, H2HOfflineDraft.this.dob, H2HOfflineDraft.this.age, H2HOfflineDraft.this.relativeName, H2HOfflineDraft.this.relativeType, H2HOfflineDraft.this.houseNo, H2HOfflineDraft.this.village, H2HOfflineDraft.this.postOffice, H2HOfflineDraft.this.acNo, H2HOfflineDraft.this.localitySreet, H2HOfflineDraft.this.address, H2HOfflineDraft.this.pinCode, H2HOfflineDraft.this.partNo, H2HOfflineDraft.this.stateCode, H2HOfflineDraft.this.coordinate, H2HOfflineDraft.this.residingPeriod, H2HOfflineDraft.this.houseApplicantFound, H2HOfflineDraft.this.isAadharVerified, H2HOfflineDraft.this.isElectorRecordSame, H2HOfflineDraft.this.allDetailsVerified, H2HOfflineDraft.this.isAddressRecordSame, H2HOfflineDraft.this.isDobRecordSame, H2HOfflineDraft.this.photographEleIsCorrect, H2HOfflineDraft.this.disabilityType, H2HOfflineDraft.this.isVisual, H2HOfflineDraft.this.sectionNo, H2HOfflineDraft.this.isPwd, H2HOfflineDraft.this.isDeaf, H2HOfflineDraft.this.pwdPercentage, H2HOfflineDraft.this.isLocomotive, H2HOfflineDraft.this.otherDisability, H2HOfflineDraft.this.isMetElector, H2HOfflineDraft.this.phoneNumberVerified, H2HOfflineDraft.this.dateOfVerification, H2HOfflineDraft.this.addressAttachment, H2HOfflineDraft.this.dobAttachment, H2HOfflineDraft.this.misDocument, H2HOfflineDraft.this.remarks, H2HOfflineDraft.this.sectionName, H2HOfflineDraft.this.applicantNameRegional, H2HOfflineDraft.this.relativeNameRegional, H2HOfflineDraft.this.photo, H2HOfflineDraft.this.partSerialNumber));
                H2HOfflineDraft.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(new HouseSurveyModel.Payload(H2HOfflineDraft.this.epicNo, H2HOfflineDraft.this.houseNo, H2HOfflineDraft.this.sectionNo, H2HOfflineDraft.this.partNo, SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).getPreferredUsername(), H2HOfflineDraft.this.formattedDate, H2HOfflineDraft.this.inserted));
                Logger.d(H2HOfflineDraft.this.h2hTagString, "data delete Successfully");
                Logger.d(H2HOfflineDraft.this.h2hTagString, "Inside submit.........House Survey Submitted Successfully");
                H2HOfflineDraft.this.showdialogFinal("Success", "Verified Successfully");
                return;
            }
            if (response.code() == 401) {
                H2HOfflineDraft.this.commomUtility.getRefreshToken(H2HOfflineDraft.this.requireContext(), H2HOfflineDraft.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            H2HOfflineDraft.this.binding.submitTv.setEnabled(true);
            H2HOfflineDraft.this.showProgressInVisible();
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(H2HOfflineDraft.this.h2hTagString, strOptString);
                H2HOfflineDraft h2HOfflineDraft = H2HOfflineDraft.this;
                h2HOfflineDraft.showdialog1(h2HOfflineDraft.alertString, strOptString);
            } catch (Exception e) {
                Logger.e(H2HOfflineDraft.this.h2hTagString, e.getMessage());
                if (response.message() != null) {
                    H2HOfflineDraft h2HOfflineDraft2 = H2HOfflineDraft.this;
                    h2HOfflineDraft2.showdialogFinal(h2HOfflineDraft2.alertString, response.message());
                } else {
                    H2HOfflineDraft h2HOfflineDraft3 = H2HOfflineDraft.this;
                    h2HOfflineDraft3.showdialogFinal(h2HOfflineDraft3.alertString, "No Data Found");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                H2HOfflineDraft.this.commomUtility.showMessageOK(H2HOfflineDraft.this.getContext(), H2HOfflineDraft.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HOfflineDraft.this.token = "Bearer " + str;
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setToken("Bearer " + str);
            H2HOfflineDraft.this.houseSurveySubmit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setLocaleBool(false);
            H2HOfflineDraft.this.startActivity(new Intent((Context) H2HOfflineDraft.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            H2HOfflineDraft.this.showProgressInVisible();
            H2HOfflineDraft.this.binding.submitTv.setEnabled(true);
            Logger.e("on Failure............", t.getMessage());
            H2HOfflineDraft.this.showdialog1("Error", t.getMessage());
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher.launch(Intent.createChooser(intent, "Choose File"));
    }

    public void getFile1(String fileref) {
        Logger.d(this.h2hTagString, "in getFile1..............................");
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile("objectstorage", fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.garudaTag, "ANDROIDMOB").enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                H2HOfflineDraft.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(H2HOfflineDraft.this.base64element1, 0);
                H2HOfflineDraft.this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                if (H2HOfflineDraft.this.base64element1.isEmpty() || H2HOfflineDraft.this.base64element1.equals("null")) {
                    H2HOfflineDraft.this.binding.personImage.setImageBitmap(BitmapFactory.decodeResource(H2HOfflineDraft.this.getResources(), R.drawable.blo_dummy_image));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401) {
                H2HOfflineDraft.this.commomUtility.getRefreshToken(H2HOfflineDraft.this.requireContext(), H2HOfflineDraft.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(H2HOfflineDraft.this.h2hTagString, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                Logger.e(H2HOfflineDraft.this.h2hTagString, e.getMessage());
                if (response.message() != null) {
                    H2HOfflineDraft h2HOfflineDraft = H2HOfflineDraft.this;
                    h2HOfflineDraft.showdialogFinal(h2HOfflineDraft.alertString, response.message());
                } else {
                    H2HOfflineDraft h2HOfflineDraft2 = H2HOfflineDraft.this;
                    h2HOfflineDraft2.showdialogFinal(h2HOfflineDraft2.alertString, "No Data Found");
                }
            }
            H2HOfflineDraft.this.showProgressInVisible();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            H2HOfflineDraft.this.showProgressInVisible();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                H2HOfflineDraft.this.commomUtility.showMessageOK(H2HOfflineDraft.this.getContext(), H2HOfflineDraft.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            H2HOfflineDraft.this.token = "Bearer " + str;
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setToken("Bearer " + str);
            H2HOfflineDraft.this.houseSurveySubmit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(H2HOfflineDraft.this.requireContext()).setLocaleBool(false);
            H2HOfflineDraft.this.startActivity(new Intent((Context) H2HOfflineDraft.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(H2HOfflineDraft.this.h2hTagString, "coming in onFailure " + t.getMessage());
            H2HOfflineDraft.this.showProgressInVisible();
            H2HOfflineDraft h2HOfflineDraft = H2HOfflineDraft.this;
            h2HOfflineDraft.showdialog1(h2HOfflineDraft.alertString, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogFinal$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogFinal$12(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity();
        this.parser = new JSONParser();
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
        showProgressInVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private void saveimageapi(String captureFileName) {
        showProgressVisible();
        Logger.d(this.h2hTagString, "in image upload api..............................");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), "misc_document");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).uploadImageWithData1(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.garudaTag, "ANDROIDMOB", partCreateFormData, RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse(this.stateCodeString)), RequestBody.create(this.acNo, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse(this.partNoString)), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.garudaTag, MediaType.parse("appName"))).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Logger.d(H2HOfflineDraft.this.h2hTagString, "Success_Uploaded");
                    H2HOfflineDraft.this.docRef = String.valueOf(((JsonObject) response.body()).get("refId")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("document ", H2HOfflineDraft.this.docRef);
                    H2HOfflineDraft.this.showProgressInVisible();
                    return;
                }
                Logger.d(H2HOfflineDraft.this.h2hTagString, ">>>>" + response.errorBody());
                H2HOfflineDraft.this.showProgressInVisible();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(H2HOfflineDraft.this.h2hTagString, "Failed_Uploaded " + t.getMessage());
                H2HOfflineDraft.this.showProgressInVisible();
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
