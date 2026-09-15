package in.gov.eci.bloapp.views.fragments.voterforms.overseas;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.os.LocaleList;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
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
import android.widget.LinearLayout;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.yalantis.ucrop.UCrop;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.databinding.BloFragmentOverseasVoterBinding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.languagetransliteration.db.DBClient;
import in.gov.eci.bloapp.languagetransliteration.db.TState;
import in.gov.eci.bloapp.model.app_model.FormsinDraftOverseasModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.PostalCodeValidator;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.utils.ImageUriUtils;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.FormsResponse;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class OverseasVoter extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener {
    private static final String SESSION = "Session Expired. Please Login again.";
    ActivityResultLauncher<Intent> activityResultLauncher1;
    private ArrayAdapter<String> adapterdistrict;
    String addressfield;
    private AlertDialog alertDialog;
    String applicantGender;
    String applicantRelativeSurname;
    String applicantRelativesurnameL1;
    String asmblyNO;
    String asmblyName;
    BloFragmentOverseasVoterBinding binding;
    String birthDistrictCd;
    String birthTown;
    String bluecolor;
    private byte[] byteArray;
    String cancel;
    String choose_back_camera;
    String choose_front_camera;
    String choosegallery;
    String choosepdf;
    String color;
    private ArrayAdapter<String> constadapter;
    private ArrayList<String> constcode;
    private int constdec;
    private ArrayList<String> constituency;
    private ArrayList<String> country;
    String countryISO;
    private ArrayAdapter<String> countryadapter;
    private ArrayList<String> countrycode;
    String countrymsg;
    private int countrypos;
    String crosiState;
    private LinearLayout currentSelectedView;
    String dateOfVisaExpiry;
    String dateOfVisaIssue;
    String declConstituency;
    String declDistrict;
    String declFullAddress;
    String declState;
    private String declare;
    String declareApplCode;
    String delimeter;
    private ArrayList<String> district;
    private String districtCode1;
    String districtName;
    private ArrayList<String> districtNameac;
    private ArrayAdapter<String> districtadapter;
    private ArrayList<String> districtcode;
    private ArrayList<String> districtcodeac;
    private int districtdec;
    String districtmsg;
    private int districtpos;
    private int districtposinac;
    private String dobQualifyingDate;
    String emailText;
    String english_code;
    String filepathimg;
    private String form;
    SimpleDateFormat format;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private ArrayList<String> gender;
    private ArrayAdapter<String> genderadapter;
    ArrayList<String> gendercode;
    String gendermsg;
    private int genderpos;
    String greycolor;
    String isIndia;
    String lastNameL1;
    String lastNameText;
    private LocationRequest locationRequest;
    String mobileNumberText;
    String msg;
    String oriPostOffice;
    String oriPostOfficeL1;
    String outsidePlaceofBirth;
    private String[] outsidedetails;
    private String partLang;
    private String partNo;
    private String[] passportDetails;
    private String passref;
    private byte[] pdfbyteArray;
    private int personalFlag;
    private String[] personaldetails;
    String photograph;
    private String photoref;
    String placeOfPassportIssue;
    String reasonOfAbsence;
    private String reasonabsenting;
    private String referencenumber;
    private String refreshToken;
    String rejected;
    private JSONObject rejectedJson;
    private ArrayList<String> relation;
    private ArrayAdapter<String> relationadapter;
    private ArrayList<String> relationcode1;
    String relationmsg;
    private int relationpos;
    private String[] residenceDetails;
    private String stateCode;
    private ArrayList<String> stateList;
    String stateName;
    private ArrayAdapter<String> stateadapter;
    private ArrayList<String> statecode1;
    private int statedec;
    String statemsg;
    private int statepos;
    String submitdate;
    String takephoto;
    String temp;
    private String token;
    String typeOfRelation;
    String typeOfVisa;
    ActivityResultLauncher<Intent> uCropLauncher;
    private OverseasDetailViewModel viewModel;
    String visaIssuingAuthority;
    String visaNumber;
    private int visaflag;
    String voterforms;
    String whitecolor;
    String yyFormat;
    final Calendar dobcalendar = Calendar.getInstance();
    final Calendar passportissuecalendar = Calendar.getInstance();
    final Calendar absentingdatecalendar = Calendar.getInstance();
    final Calendar visaissueCalendar = Calendar.getInstance();
    final Calendar visaexpiryCalendar = Calendar.getInstance();
    final Calendar issuedatecalendar = Calendar.getInstance();
    CommomUtility commonUtilClass = new CommomUtility();
    String alert = "Alert";
    String india = Constants.COUNTRYNAME1;
    String employment = "Employment";
    String education = "Education";
    String other = "Other (give Description)";
    Date subdate = new Date();
    String dateFormat = "dd/MM/yyyy";

    public OverseasVoter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        this.format = simpleDateFormat;
        this.submitdate = simpleDateFormat.format(this.subdate);
        this.delimeter = "‡";
        this.rejected = "Rejected";
        this.whitecolor = "#000000";
        this.voterforms = "Voter Forms";
        this.greycolor = "#99000000";
        this.msg = "Can't obtain file name, cursor is empty";
        this.birthDistrictCd = "birthDistrictCd";
        this.declDistrict = "declDistrict";
        this.declConstituency = "declConstituency";
        this.bluecolor = "#1c77ff";
        this.relationmsg = "Select Relation Type";
        this.statemsg = "Select State";
        this.gendermsg = "Select Gender";
        this.districtmsg = "Select District";
        this.countrymsg = "Select Country";
        this.color = "#D9D9D9";
        this.yyFormat = "yyyy-MM-dd";
        this.lastNameText = Constants.LAST_NAME;
        this.lastNameL1 = "lastNameL1";
        this.applicantRelativeSurname = "applicantRelativeSurname";
        this.applicantRelativesurnameL1 = "applicantRelativesurnameL1";
        this.typeOfRelation = "typeOfRelation";
        this.birthTown = "birthTown";
        this.applicantGender = "applicantGender";
        this.mobileNumberText = "mobileNumber";
        this.emailText = "email";
        this.photograph = "photograph";
        this.oriPostOffice = "oriPostOffice";
        this.oriPostOfficeL1 = "oriPostOfficeL1";
        this.placeOfPassportIssue = "placeOfPassportIssue";
        this.visaNumber = "visaNumber";
        this.typeOfVisa = "typeOfVisa";
        this.dateOfVisaIssue = "dateOfVisaIssue";
        this.dateOfVisaExpiry = "dateOfVisaExpiry";
        this.visaIssuingAuthority = "visaIssuingAuthority";
        this.reasonOfAbsence = "reasonOfAbsence";
        this.crosiState = "crosiState";
        this.declareApplCode = "declareApplCode";
        this.declState = "declState";
        this.declFullAddress = "declFullAddress";
        this.takephoto = "Take Photo";
        this.choosegallery = "Choose Image from Gallery";
        this.cancel = "Cancel";
        this.choosepdf = "Choose PDF from Gallery";
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
        this.addressfield = "ADDRESS";
        this.visaflag = 0;
        this.passref = " ";
        this.photoref = " ";
        this.form = " ";
        this.reasonabsenting = " ";
        this.personalFlag = 0;
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass1());
        this.choose_front_camera = "";
        this.choose_back_camera = "";
        this.temp = "";
        this.english_code = "en_in";
        this.uCropLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.37
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == -1 && result.getData() != null) {
                    Uri output = UCrop.getOutput(result.getData());
                    if (output != null) {
                        OverseasVoter.this.onCropSuccess(output);
                        return;
                    } else {
                        OverseasVoter.this.onCropError(new Throwable("UCrop returned null output Uri"));
                        return;
                    }
                }
                if (result.getResultCode() == 96) {
                    OverseasVoter.this.onCropError(UCrop.getError(result.getData()));
                } else {
                    OverseasVoter.this.onCropCancelled();
                }
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1, reason: invalid class name */
    class AnonymousClass1 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass1() {
        }

        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            if (result.getResultCode() == -1) {
                Uri data = result.getData().getData();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    InputStream inputStreamOpenInputStream = OverseasVoter.this.getContext().getContentResolver().openInputStream(data);
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
                OverseasVoter.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                try {
                    Uri saveImagePath = OverseasVoter.this.getSaveImagePath(Base64.encodeToString(OverseasVoter.this.pdfbyteArray, 0), ".pdf");
                    Cursor cursorQuery = OverseasVoter.this.getContext().getContentResolver().query(saveImagePath, null, null, null, null);
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(OverseasVoter.this.msg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    if (OverseasVoter.this.filesize < 1024) {
                        double dRound = Math.round(OverseasVoter.this.filesize * 100.0d) / 100.0d;
                        OverseasVoter.this.binding.delete.setVisibility(0);
                        OverseasVoter.this.binding.filename.setVisibility(0);
                        OverseasVoter.this.binding.filesize.setVisibility(0);
                        OverseasVoter.this.binding.preview.setVisibility(0);
                        OverseasVoter.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        OverseasVoter.this.binding.chooseFile.setTextColor(Color.parseColor(OverseasVoter.this.greycolor));
                        OverseasVoter.this.binding.filename.setText(strArrSplit[strArrSplit.length - 1]);
                        OverseasVoter.this.binding.filesize.setText(dRound + "KB");
                    } else {
                        double dRound2 = Math.round(((double) (OverseasVoter.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                        if (dRound2 > 3.0d) {
                            OverseasVoter.this.binding.delete.setVisibility(8);
                            OverseasVoter.this.binding.filename.setVisibility(8);
                            OverseasVoter.this.binding.filesize.setVisibility(8);
                            OverseasVoter.this.binding.preview.setVisibility(8);
                            OverseasVoter overseasVoter = OverseasVoter.this;
                            overseasVoter.showdialog(overseasVoter.alert, "PDF size exceeded 3MB limit.");
                        } else {
                            OverseasVoter.this.binding.delete.setVisibility(0);
                            OverseasVoter.this.binding.filename.setVisibility(0);
                            OverseasVoter.this.binding.filesize.setVisibility(0);
                            OverseasVoter.this.binding.preview.setVisibility(0);
                            OverseasVoter.this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                            OverseasVoter.this.binding.chooseFile.setTextColor(Color.parseColor(OverseasVoter.this.greycolor));
                            OverseasVoter.this.binding.filename.setText(strArrSplit[strArrSplit.length - 1]);
                            OverseasVoter.this.binding.filesize.setText(dRound2 + "MB");
                        }
                    }
                    OverseasVoter.this.commonUtilClass.uploadToServer2(OverseasVoter.this.getContext(), OverseasVoter.this.stateCode, OverseasVoter.this.asmblyNO, OverseasVoter.this.partNo, OverseasVoter.this.filepathimg, OverseasVoter.this.saveImageFileName, OverseasVoter.this.token, OverseasVoter.this.referencenumber, SharedPref.getInstance(OverseasVoter.this.requireContext()).getAtknBnd(), SharedPref.getInstance(OverseasVoter.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str) {
                            this.f$0.lambda$onActivityResult$5(i2, str);
                        }
                    });
                    cursorQuery.close();
                } catch (Exception e3) {
                    Logger.d("", e3.getMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$5(int i, String str) {
            if (i == 401) {
                OverseasVoter.this.commonUtilClass.getRefreshToken(OverseasVoter.this.requireContext(), OverseasVoter.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$3(i2, str2, str3);
                    }
                });
            } else {
                OverseasVoter.this.passref = str;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onActivityResult$4();
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$3(int i, String str, String str2) {
            OverseasVoter.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                OverseasVoter.this.commonUtilClass.showMessageOK(OverseasVoter.this.getContext(), OverseasVoter.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            OverseasVoter.this.token = "Bearer " + str;
            OverseasVoter.this.refreshToken = str2;
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setToken("Bearer " + str);
            OverseasVoter.this.commonUtilClass.uploadToServer2(OverseasVoter.this.getContext(), OverseasVoter.this.stateCode, OverseasVoter.this.asmblyNO, OverseasVoter.this.partNo, OverseasVoter.this.filepathimg, OverseasVoter.this.saveImageFileName, OverseasVoter.this.token, OverseasVoter.this.referencenumber, SharedPref.getInstance(OverseasVoter.this.requireContext()).getAtknBnd(), SharedPref.getInstance(OverseasVoter.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda4
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onActivityResult$2(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setLocaleBool(false);
            OverseasVoter.this.startActivity(new Intent((Context) OverseasVoter.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(int i, String str) {
            OverseasVoter.this.passref = str;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResult$1();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1() {
            OverseasVoter.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$4() {
            OverseasVoter.this.alertDialog.dismiss();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentOverseasVoterBinding.inflate(getLayoutInflater());
        this.viewModel = (OverseasDetailViewModel) new ViewModelProvider(requireActivity()).get(OverseasDetailViewModel.class);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode1 = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.dobQualifyingDate = SharedPref.getInstance(requireContext()).getDobQualifyingDate();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        String str = this.partLang;
        if (str == null || str.trim().isEmpty()) {
            this.partLang = "en_in";
        }
        this.choose_front_camera = getString(R.string.capture_from_front_camera);
        this.choose_back_camera = getString(R.string.capture_from_back_camera);
        boolean z = true;
        this.binding.firstNameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.surNameEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeName.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.relativeLastname.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.houseNoEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.streetEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.postofficeEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.villageEd.setImeHintLocales(new LocaleList(new Locale(Constants.COUNTRYNAME2_LANG, Constants.COUNTRYNAME2)));
        this.binding.firstNameEd.setInputType(532624);
        this.binding.surNameEd.setInputType(532624);
        this.binding.relativeName.setInputType(532624);
        this.binding.relativeLastname.setInputType(532624);
        this.binding.houseNoEd.setInputType(532624);
        this.binding.postofficeEd.setInputType(532624);
        this.binding.streetEd.setInputType(532624);
        this.binding.villageEd.setInputType(532624);
        this.binding.firstNameEd.setImportantForAutofill(2);
        this.binding.surNameEd.setImportantForAutofill(2);
        this.binding.relativeName.setImportantForAutofill(2);
        this.binding.relativeLastname.setImportantForAutofill(2);
        this.binding.houseNoEd.setImportantForAutofill(2);
        this.binding.postofficeEd.setImportantForAutofill(2);
        this.binding.streetEd.setImportantForAutofill(2);
        this.binding.villageEd.setImportantForAutofill(2);
        String strSubstring = this.partLang.substring(0, 2);
        this.binding.firstnameEnglish.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.firstnameEnglish.setImportantForAutofill(2);
        this.binding.surnameEnglish.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.relativeNameEnglish.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.relativeLastnameEnglish.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.houseRegional.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.streetRegional.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.postofficeOfficial.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.villageRegional.setImeHintLocales(new LocaleList(new Locale(strSubstring, Constants.COUNTRYNAME1)));
        this.binding.surnameEnglish.setImportantForAutofill(2);
        this.binding.relativeNameEnglish.setImportantForAutofill(2);
        this.binding.relativeLastnameEnglish.setImportantForAutofill(2);
        this.binding.houseRegional.setImportantForAutofill(2);
        this.binding.streetRegional.setImportantForAutofill(2);
        this.binding.postofficeOfficial.setImportantForAutofill(2);
        this.binding.villageRegional.setImportantForAutofill(2);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda123
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.homeBtnIv1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda135
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.districtNameac = new ArrayList<>();
        this.districtcodeac = new ArrayList<>();
        this.binding.districtSpinner1.setOnTouchListener(this);
        this.binding.districtSpinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda145
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$onCreateView$2(adapterView, view, i, j);
            }
        });
        View viewInflate = inflater.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.stateSpinner.setText(this.stateName);
        this.binding.noEd.setText(this.asmblyNO);
        this.binding.districtSpinner.setText(this.districtName);
        this.binding.assemblyEd.setText(this.asmblyName);
        loadData();
        this.binding.firstnameEnglish.setOnFocusChangeListener(this);
        this.binding.surnameEnglish.setOnFocusChangeListener(this);
        this.binding.relativeNameEnglish.setOnFocusChangeListener(this);
        this.binding.relativeLastnameEnglish.setOnFocusChangeListener(this);
        this.binding.houseRegional.setOnFocusChangeListener(this);
        this.binding.streetRegional.setOnFocusChangeListener(this);
        this.binding.villageRegional.setOnFocusChangeListener(this);
        this.binding.postofficeOfficial.setOnFocusChangeListener(this);
        this.binding.relationSpinner.setOnItemSelectedListener(this);
        this.binding.genderPersonalSpinner.setOnItemSelectedListener(this);
        this.binding.statePersonalSpinner.setOnItemSelectedListener(this);
        this.binding.stateOutsideSpinnerDec.setOnItemSelectedListener(this);
        this.binding.districtPersonalSpinner.setOnItemSelectedListener(this);
        this.binding.districtOutsideSpinnerDec.setOnItemSelectedListener(this);
        this.binding.constOutsideSpinnerDec.setOnItemSelectedListener(this);
        this.binding.countrySpinner.setOnItemSelectedListener(this);
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("form");
            this.form = string;
            if (string.equals(this.rejected)) {
                this.currentSelectedView = this.binding.selectStateLayout;
                this.binding.personalDetails.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                this.binding.decleration.setVisibility(8);
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.selectStateLayout.setEnabled(false);
                this.binding.personalDetailLayout.setEnabled(false);
                this.binding.residenceDetailsLayout.setEnabled(false);
                this.binding.optionalDetailsLayout.setEnabled(false);
                this.binding.familyDetailsLayout.setEnabled(false);
                this.binding.outsideLayout.setEnabled(false);
                this.binding.declarationLayout.setEnabled(false);
                this.binding.ordinaryLayout.setEnabled(false);
                try {
                    JSONObject jSONObject = new JSONObject(arguments.getString("OverseasVoter"));
                    this.rejectedJson = jSONObject;
                    this.referencenumber = String.valueOf(jSONObject.get("formRefNumber"));
                    this.binding.stateSpinner.setText(this.stateName);
                    this.binding.districtSpinner.setText(this.districtName);
                    this.binding.assemblyEd.setText(this.asmblyName);
                    this.binding.noEd.setText(String.valueOf(this.rejectedJson.get("asmblyConstituencyNo")));
                } catch (JSONException e) {
                    Logger.d("", e.getMessage());
                }
            } else {
                dataoneditbutton(arguments.getString("name"), arguments.getString("date"), "Form 6A");
            }
        } else {
            this.commonUtilClass.getreferencenumber(getContext(), this.asmblyNO, this.stateCode, "6A", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda146
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str2) {
                    this.f$0.lambda$onCreateView$6(i, str2);
                }
            });
        }
        this.binding.firstnameEnglish.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.2
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
        this.binding.firstNameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.3
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
        this.binding.surNameEd.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.4
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
        this.binding.relativeName.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.5
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
        this.binding.relativeLastname.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.6
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
        this.binding.surnameEnglish.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.7
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
        this.binding.relativeNameEnglish.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.8
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
        this.binding.relativeLastnameEnglish.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.9
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
        this.binding.firstNameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.firstNameEd.getText().toString();
                if (OverseasVoter.this.binding.firstNameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.firstNameEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.firstNameEd.setSelection(OverseasVoter.this.binding.firstNameEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.firstnameEnglish.getText().clear();
                }
            }
        });
        this.binding.postofficeEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.postofficeEd.getText().toString();
                if (OverseasVoter.this.binding.postofficeEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.postofficeEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.postofficeEd.setSelection(OverseasVoter.this.binding.postofficeEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.postofficeOfficial.getText().clear();
                }
            }
        });
        this.binding.postofficeOfficial.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.postofficeOfficial.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.postofficeOfficial.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.postofficeOfficial.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.postofficeOfficial.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(OverseasVoter.this.binding.postofficeOfficial.getSelectionStart() - 1);
                        OverseasVoter.this.binding.postofficeOfficial.setText(sb);
                        OverseasVoter.this.binding.postofficeOfficial.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.13
            public void handleOnBackPressed() {
                OverseasVoter.this.openFragment(new VoterFormsFragment(), OverseasVoter.this.voterforms);
            }
        });
        this.binding.relativeName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.relativeName.getText().toString();
                if (OverseasVoter.this.binding.relativeName.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.relativeName.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.relativeName.setSelection(OverseasVoter.this.binding.relativeName.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.relativeNameEnglish.getText().clear();
                }
            }
        });
        this.binding.surNameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.15
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.surNameEd.getText().toString();
                if (OverseasVoter.this.binding.surNameEd.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.surNameEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.surNameEd.setSelection(OverseasVoter.this.binding.surNameEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.surnameEnglish.getText().clear();
                }
            }
        });
        this.binding.relativeLastname.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.16
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.relativeLastname.getText().toString();
                if (OverseasVoter.this.binding.relativeLastname.getText().toString().matches(RegexMatcher.NAME_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.relativeLastname.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.relativeLastname.setSelection(OverseasVoter.this.binding.relativeLastname.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.relativeLastnameEnglish.getText().clear();
                }
            }
        });
        this.binding.firstnameEnglish.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.17
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.firstnameEnglish.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.firstnameEnglish.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.firstnameEnglish.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.firstnameEnglish.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(OverseasVoter.this.binding.firstnameEnglish.getSelectionStart() - 1);
                        OverseasVoter.this.binding.firstnameEnglish.setText(sb);
                        OverseasVoter.this.binding.firstnameEnglish.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.relativeNameEnglish.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.18
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.relativeNameEnglish.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.relativeNameEnglish.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.relativeNameEnglish.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.relativeNameEnglish.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(OverseasVoter.this.binding.relativeNameEnglish.getSelectionStart() - 1);
                        OverseasVoter.this.binding.relativeNameEnglish.setText(sb);
                        OverseasVoter.this.binding.relativeNameEnglish.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.surnameEnglish.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.19
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.surnameEnglish.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.surnameEnglish.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.surnameEnglish.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.surnameEnglish.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(OverseasVoter.this.binding.surnameEnglish.getSelectionStart() - 1);
                        OverseasVoter.this.binding.surnameEnglish.setText(sb);
                        OverseasVoter.this.binding.surnameEnglish.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.relativeLastnameEnglish.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.20
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.relativeLastnameEnglish.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.relativeLastnameEnglish.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.relativeLastnameEnglish.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.relativeLastnameEnglish.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(OverseasVoter.this.binding.relativeLastnameEnglish.getSelectionStart() - 1);
                        OverseasVoter.this.binding.relativeLastnameEnglish.setText(sb);
                        OverseasVoter.this.binding.relativeLastnameEnglish.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.houseNoEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.21
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.houseNoEd.getText().toString();
                if (OverseasVoter.this.binding.houseNoEd.getText().toString().matches(RegexMatcher.HOUSENO_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.houseNoEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.houseNoEd.setSelection(OverseasVoter.this.binding.houseNoEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.houseRegional.getText().clear();
                }
            }
        });
        this.binding.houseNoEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.22
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.houseNoEd2.getText().toString();
                if (OverseasVoter.this.binding.houseNoEd2.getText().toString().matches(RegexMatcher.HOUSE_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.houseNoEd2.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.houseNoEd2.setSelection(OverseasVoter.this.binding.houseNoEd2.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.addressEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.23
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.addressEd.getText().toString();
                if (OverseasVoter.this.binding.addressEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.addressEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.addressEd.setSelection(OverseasVoter.this.binding.addressEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.houseRegional.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.24
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.houseRegional.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.houseRegional.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.houseRegional.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.houseRegional.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(OverseasVoter.this.binding.houseRegional.getSelectionStart() - 1);
                        OverseasVoter.this.binding.houseRegional.setText(sb);
                        OverseasVoter.this.binding.houseRegional.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.streetEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.25
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.streetEd.getText().toString();
                if (OverseasVoter.this.binding.streetEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.streetEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.streetEd.setSelection(OverseasVoter.this.binding.streetEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.streetRegional.getText().clear();
                }
            }
        });
        this.binding.streetEd2.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.26
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.streetEd2.getText().toString();
                if (OverseasVoter.this.binding.streetEd2.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.streetEd2.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.streetEd2.setSelection(OverseasVoter.this.binding.streetEd2.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.streetRegional.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.27
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.streetRegional.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.streetRegional.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.streetRegional.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.streetRegional.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(OverseasVoter.this.binding.streetRegional.getSelectionStart() - 1);
                        OverseasVoter.this.binding.streetRegional.setText(sb);
                        OverseasVoter.this.binding.streetRegional.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.villageEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.28
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.villageEd.getText().toString();
                if (OverseasVoter.this.binding.villageEd.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.villageEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.villageEd.setSelection(OverseasVoter.this.binding.villageEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
                    OverseasVoter.this.binding.villageRegional.getText().clear();
                }
            }
        });
        this.binding.villageSpinner1.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.29
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.villageSpinner1.getText().toString();
                if (OverseasVoter.this.binding.villageSpinner1.getText().toString().matches(RegexMatcher.ADDRESS_OFFICIAL_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.villageSpinner1.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.villageSpinner1.setSelection(OverseasVoter.this.binding.villageSpinner1.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.villageRegional.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.30
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(OverseasVoter.this.binding.villageRegional.getText().toString());
                    sb.charAt(OverseasVoter.this.binding.villageRegional.getSelectionStart() - 1);
                    int selectionStart = OverseasVoter.this.binding.villageRegional.getSelectionStart() - 1;
                    if (OverseasVoter.this.binding.villageRegional.getText().toString().matches(".*[~`!@#$%^&*()_+=₹©®℗™°℃℉«»⁅⁆¦|‹›?<>¶µ€£;\"{}\\[\\]].*")) {
                        sb.deleteCharAt(OverseasVoter.this.binding.villageRegional.getSelectionStart() - 1);
                        OverseasVoter.this.binding.villageRegional.setText(sb);
                        OverseasVoter.this.binding.villageRegional.setSelection(selectionStart);
                    }
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.placeEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.31
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.placeEd.getText().toString();
                if (OverseasVoter.this.binding.placeEd.getText().toString().matches(RegexMatcher.PLACE_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.placeEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.placeEd.setSelection(OverseasVoter.this.binding.placeEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.binding.placeIssueEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.32
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.d("", s.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string2 = OverseasVoter.this.binding.placeIssueEd.getText().toString();
                if (OverseasVoter.this.binding.placeIssueEd.getText().toString().matches(RegexMatcher.PLACE_REGEX)) {
                    return;
                }
                try {
                    OverseasVoter.this.binding.placeIssueEd.setText(string2.substring(0, string2.length() - 1));
                    OverseasVoter.this.binding.placeIssueEd.setSelection(OverseasVoter.this.binding.placeIssueEd.getText().toString().length());
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
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
        this.currentSelectedView = this.binding.selectStateLayout;
        this.binding.personalDetails.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.outsideDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.selectStateLayout.setEnabled(false);
        this.binding.personalDetailLayout.setEnabled(false);
        this.binding.residenceDetailsLayout.setEnabled(false);
        this.binding.optionalDetailsLayout.setEnabled(false);
        this.binding.familyDetailsLayout.setEnabled(false);
        this.binding.outsideLayout.setEnabled(false);
        this.binding.declarationLayout.setEnabled(false);
        this.binding.ordinaryLayout.setEnabled(false);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        getCurrentLocation();
        initializingClicks();
        this.district = new ArrayList<>();
        this.constituency = new ArrayList<>();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda147
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$7(datePicker, i, i2, i3);
            }
        };
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        String str2 = this.dobQualifyingDate;
        if (str2 != "") {
            try {
                calendar2.setTime(simpleDateFormat.parse(str2));
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
        this.binding.dobEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda148
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$8(onDateSetListener, time2, time, view);
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda149
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$9(datePicker, i, i2, i3);
            }
        };
        this.binding.issueDateEdVisa.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda150
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$10(onDateSetListener2, time, view);
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener3 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$11(datePicker, i, i2, i3);
            }
        };
        this.binding.expiryDateEdVisa.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$12(onDateSetListener3, time, view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda124
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$13(view);
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda125
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$14(view);
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener4 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda126
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$15(datePicker, i, i2, i3);
            }
        };
        this.binding.delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda127
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$16(view);
            }
        });
        this.binding.issueDateEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda128
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$17(onDateSetListener4, time, view);
            }
        });
        this.binding.backBtnIv1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda130
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$18(view);
            }
        });
        this.binding.edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda131
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$19(view);
            }
        });
        this.binding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda132
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$20(view);
            }
        });
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda133
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$21(view);
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener5 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda134
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$22(datePicker, i, i2, i3);
            }
        };
        this.binding.dateEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda136
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$23(onDateSetListener5, time, view);
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener6 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda137
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$24(datePicker, i, i2, i3);
            }
        };
        this.binding.dateIssueEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda138
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$25(onDateSetListener6, time, view);
            }
        });
        this.binding.radioParentDecleration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda139
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$26(radioGroup, i);
            }
        });
        this.binding.radioParent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda141
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$27(radioGroup, i);
            }
        });
        this.binding.emailOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda142
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$28(view);
            }
        });
        this.binding.mobileOtp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda143
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$29(view);
            }
        });
        this.binding.indiaRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                OverseasVoter.this.binding.indiaLayout.setVisibility(0);
                OverseasVoter.this.binding.outsideIndiaLayout.setVisibility(8);
                OverseasVoter.this.isIndia = "Y";
            }
        });
        this.binding.outsideRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda144
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$30(view);
            }
        });
        this.binding.outsideIndiaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.34
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    return;
                }
                OverseasVoter.this.countrypos = i;
                OverseasVoter overseasVoter = OverseasVoter.this;
                overseasVoter.outsidePlaceofBirth = (String) overseasVoter.country.get(i);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(AdapterView adapterView, View view, int i, long j) {
        this.districtposinac = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda25
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$5(i2, str2, str3);
                }
            });
        } else if (i == 200) {
            this.referencenumber = str;
            getMainFunction();
        } else {
            showdialog("Error -" + i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$3(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getreferencenumber(getContext(), this.asmblyNO, this.stateCode, "6A", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda7
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$4(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(int i, String str) {
        if (i == 200) {
            this.referencenumber = str;
            getMainFunction();
        } else {
            showdialog("Error -" + i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        updateIssueDate1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(DatePicker datePicker, int i, int i2, int i3) {
        this.visaissueCalendar.clear();
        this.visaissueCalendar.set(1, i);
        this.visaissueCalendar.set(2, i2);
        this.visaissueCalendar.set(5, i3);
        updateIssueDateVisa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.visaissueCalendar.get(1), this.visaissueCalendar.get(2), this.visaissueCalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.getDatePicker().setMinDate(j);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(DatePicker datePicker, int i, int i2, int i3) {
        this.visaexpiryCalendar.clear();
        this.visaexpiryCalendar.set(1, i);
        this.visaexpiryCalendar.set(2, i2);
        this.visaexpiryCalendar.set(5, i3);
        updateExpiryDateVisa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$12(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.visaexpiryCalendar.get(1), this.visaexpiryCalendar.get(2), this.visaexpiryCalendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(j);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(View view) {
        this.binding.photoNameTv2.setText("");
        this.binding.photoSize.setText("");
        this.binding.cancel.setVisibility(8);
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.image.setVisibility(8);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(DatePicker datePicker, int i, int i2, int i3) {
        this.passportissuecalendar.clear();
        this.passportissuecalendar.set(1, i);
        this.passportissuecalendar.set(2, i2);
        this.passportissuecalendar.set(5, i3);
        updateIssueDatepassport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$16(View view) {
        this.binding.filesize.setText("");
        this.binding.filename.setText("");
        this.binding.delete.setVisibility(8);
        this.binding.chooseFile.setEnabled(true);
        this.binding.preview.setVisibility(8);
        this.binding.chooseFile.setTextColor(Color.parseColor(this.whitecolor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$17(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.passportissuecalendar.get(1), this.passportissuecalendar.get(2), this.passportissuecalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.getDatePicker().setMinDate(j);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$18(View view) {
        openFragment(new VoterFormsFragment(), this.voterforms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$19(View view) {
        this.binding.constraintLayout.setVisibility(0);
        this.binding.constraintLayout1.setVisibility(8);
        this.binding.homeFragmentTopConstraintLayout.setVisibility(0);
        this.binding.nested.setVisibility(0);
        this.binding.previewLayout.setVisibility(8);
        this.binding.cardView.setVisibility(0);
        this.binding.cardViewpre.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$20(View view) {
        createcsv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$21(View view) {
        selectImage1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$22(DatePicker datePicker, int i, int i2, int i3) {
        this.absentingdatecalendar.clear();
        this.absentingdatecalendar.set(1, i);
        this.absentingdatecalendar.set(2, i2);
        this.absentingdatecalendar.set(5, i3);
        updateDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$23(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.absentingdatecalendar.get(1), this.absentingdatecalendar.get(2), this.absentingdatecalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.getDatePicker().setMinDate(j);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$24(DatePicker datePicker, int i, int i2, int i3) {
        this.issuedatecalendar.clear();
        this.issuedatecalendar.set(1, i);
        this.issuedatecalendar.set(2, i2);
        this.issuedatecalendar.set(5, i3);
        updateissueDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$25(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.issuedatecalendar.get(1), this.issuedatecalendar.get(2), this.issuedatecalendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(j);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$26(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.radioParentDecleration.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131364753) {
            this.declare = "Name";
            this.binding.epicNoEd.setText("");
            this.binding.dateIssueEd.setText("");
            this.binding.epicDec.setVisibility(0);
            this.binding.stateLayoutDec.setVisibility(0);
            return;
        }
        if (checkedRadioButtonId != 2131364892) {
            return;
        }
        this.declare = "Not Name";
        this.binding.epicNoEd.setText("");
        this.binding.dateIssueEd.setText("");
        this.binding.epicDec.setVisibility(8);
        this.binding.stateLayoutDec.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$27(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.radioParent.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131363529) {
            this.reasonabsenting = this.education;
            this.binding.employment.setChecked(false);
            this.binding.other.setChecked(false);
            this.binding.desLayout.setVisibility(8);
            this.binding.descEd.setText("");
            return;
        }
        if (checkedRadioButtonId == 2131363638) {
            this.reasonabsenting = this.employment;
            this.binding.education.setChecked(false);
            this.binding.other.setChecked(false);
            this.binding.desLayout.setVisibility(8);
            this.binding.descEd.setText("");
            return;
        }
        if (checkedRadioButtonId != 2131364948) {
            return;
        }
        this.reasonabsenting = this.other;
        this.binding.employment.setChecked(false);
        this.binding.education.setChecked(false);
        this.binding.desLayout.setVisibility(0);
        this.binding.descEd.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$28(View view) {
        this.binding.emailOtpLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$29(View view) {
        this.binding.mobileOtpLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$30(View view) {
        this.binding.outsideIndiaLayout.setVisibility(0);
        this.binding.indiaLayout.setVisibility(8);
        getCountry(this.binding.outsideIndiaSpinner);
        this.isIndia = "N";
    }

    private void getMainFunction() {
        this.relation = new ArrayList<>();
        this.relationcode1 = new ArrayList<>();
        this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda20
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getMainFunction$33(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMainFunction$33(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda22
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$getMainFunction$32(i2, str, str2);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(0);
        getGenderData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMainFunction$32(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda110
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getMainFunction$31(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        getMainFunction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMainFunction$31(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getGenderData() {
        this.gender = new ArrayList<>();
        this.gendercode = new ArrayList<>();
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda70
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getGenderData$34(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGenderData$34(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(0);
        getStatePersonal();
    }

    private void getStatePersonal() {
        this.stateList = new ArrayList<>();
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda109
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getStatePersonal$35(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getStatePersonal$35(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(0);
        this.binding.stateOutsideSpinnerDec.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.stateOutsideSpinnerDec.setSelection(0);
        getCountry(this.binding.countrySpinner);
    }

    private void getCountry(final Spinner spinner) {
        this.country = new ArrayList<>();
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda56
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getCountry$36(spinner, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCountry$36(Spinner spinner, int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        spinner.setAdapter((SpinnerAdapter) this.countryadapter);
        spinner.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void updateDate() {
        this.binding.dateEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.absentingdatecalendar.getTime()));
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    public void updateIssueDateVisa() {
        this.binding.issueDateEdVisa.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.visaissueCalendar.getTime()));
    }

    public void updateExpiryDateVisa() {
        this.binding.expiryDateEdVisa.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.visaexpiryCalendar.getTime()));
    }

    public void updateIssueDatepassport() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat, Locale.US);
        this.binding.issueDateEd.setText(simpleDateFormat.format(this.passportissuecalendar.getTime()));
        this.passportissuecalendar.add(1, 10);
        this.passportissuecalendar.add(5, -1);
        this.binding.expiryDateEd.setText(simpleDateFormat.format(this.passportissuecalendar.getTime()));
    }

    public void updateissueDate() {
        this.binding.dateIssueEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.issuedatecalendar.getTime()));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
        switch (parent.getId()) {
            case R.id.const_outside_spinner_dec /* 2131362893 */:
                this.constdec = position;
                break;
            case R.id.country_spinner /* 2131362969 */:
                this.countrypos = position;
                this.countryISO = this.countrycode.get(position);
                break;
            case R.id.district_outside_spinner_dec /* 2131363249 */:
                this.districtdec = position;
                break;
            case R.id.district_personal_spinner /* 2131363251 */:
                this.districtpos = position;
                break;
            case R.id.gender_personal_spinner /* 2131364012 */:
                this.genderpos = position;
                break;
            case R.id.relation_spinner /* 2131365386 */:
                this.relationpos = position;
                break;
            case R.id.state_outside_spinner_dec /* 2131365829 */:
                this.statedec = position;
                this.commonUtilClass.getDistrict(this.statecode1.get(position), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.ArraylistReturn
                    public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                        this.f$0.lambda$onItemSelected$44(position, i, arrayList, arrayList2);
                    }
                });
                break;
            case R.id.state_personal_spinner /* 2131365832 */:
                this.statepos = position;
                this.commonUtilClass.getDistrict(this.statecode1.get(position), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.ArraylistReturn
                    public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                        this.f$0.lambda$onItemSelected$40(i, arrayList, arrayList2);
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$40(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda34
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onItemSelected$39(i2, str, str2);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(0);
        try {
            if (this.personaldetails != null) {
                this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
            }
            if (this.form.equals(this.rejected)) {
                if (!this.rejectedJson.get(this.birthDistrictCd).toString().equals("null")) {
                    this.binding.districtPersonalSpinner.setSelection(this.districtcode.indexOf(this.rejectedJson.get(this.birthDistrictCd).toString()));
                } else {
                    this.binding.districtPersonalSpinner.setSelection(0);
                }
            }
        } catch (JSONException e) {
            Logger.d("", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$39(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda59
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onItemSelected$37(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getDistrict(this.statecode1.get(this.statepos), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda60
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$onItemSelected$38(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$37(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$38(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(0);
        try {
            if (this.personaldetails != null) {
                this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
            }
            if (this.form.equals(this.rejected)) {
                if (!this.rejectedJson.get(this.birthDistrictCd).toString().equals("null")) {
                    this.binding.districtPersonalSpinner.setSelection(this.districtcode.indexOf(this.rejectedJson.get(this.birthDistrictCd).toString()));
                } else {
                    this.binding.districtPersonalSpinner.setSelection(0);
                }
            }
        } catch (JSONException e) {
            Logger.d("", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$44(final int i, int i2, final ArrayList arrayList, final ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda115
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str, String str2) {
                    this.f$0.lambda$onItemSelected$43(i, arrayList, arrayList2, i3, str, str2);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtOutsideSpinnerDec.setAdapter((SpinnerAdapter) this.districtadapter);
        if (this.form.equals(this.rejected)) {
            try {
                if (!this.rejectedJson.get(this.declDistrict).toString().equals("null") || !this.rejectedJson.get(this.declDistrict).toString().equals(".") || !this.rejectedJson.get(this.declDistrict).toString().equals(" ") || this.rejectedJson.get(this.declDistrict).toString() != null) {
                    this.binding.districtOutsideSpinnerDec.setSelection(this.districtcode.indexOf(this.rejectedJson.get(this.declDistrict).toString()));
                } else {
                    this.binding.districtOutsideSpinnerDec.setSelection(0);
                }
            } catch (JSONException e) {
                Logger.d("", e.getMessage());
            }
        } else {
            this.binding.districtOutsideSpinnerDec.setSelection(0);
        }
        getConstituency(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$43(final int i, final ArrayList arrayList, final ArrayList arrayList2, int i2, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str + " " + str2);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda74
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$onItemSelected$41(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getDistrict(this.statecode1.get(i), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda85
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$onItemSelected$42(arrayList, arrayList2, i, i3, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$41(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemSelected$42(ArrayList arrayList, ArrayList arrayList2, int i, int i2, ArrayList arrayList3, ArrayList arrayList4) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtOutsideSpinnerDec.setAdapter((SpinnerAdapter) this.districtadapter);
        if (this.form.equals(this.rejected)) {
            try {
                if (!this.rejectedJson.get(this.declDistrict).toString().equals("null") || !this.rejectedJson.get(this.declDistrict).toString().equals(".") || !this.rejectedJson.get(this.declDistrict).toString().equals(" ") || this.rejectedJson.get(this.declDistrict).toString() != null) {
                    this.binding.districtOutsideSpinnerDec.setSelection(this.districtcode.indexOf(this.rejectedJson.get(this.declDistrict).toString()));
                } else {
                    this.binding.districtOutsideSpinnerDec.setSelection(0);
                }
            } catch (JSONException e) {
                Logger.d("", e.getMessage());
            }
        } else {
            this.binding.districtOutsideSpinnerDec.setSelection(0);
        }
        getConstituency(i);
    }

    private void getConstituency(int position) {
        this.commonUtilClass.getConstituency(this.statecode1.get(position), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda96
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getConstituency$45(i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getConstituency$45(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.constituency = arrayList;
        this.constcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.constituency);
        this.constadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.constOutsideSpinnerDec.setAdapter((SpinnerAdapter) this.constadapter);
        if (this.form.equals(this.rejected)) {
            try {
                if (!this.rejectedJson.get(this.declConstituency).toString().equals("null") || !this.rejectedJson.get(this.declConstituency).toString().equals(".") || !this.rejectedJson.get(this.declConstituency).toString().equals(" ") || this.rejectedJson.get(this.declConstituency).toString() != null) {
                    this.binding.constOutsideSpinnerDec.setSelection(this.constcode.indexOf(this.rejectedJson.get(this.declConstituency).toString()));
                } else {
                    this.binding.constOutsideSpinnerDec.setSelection(0);
                }
                return;
            } catch (JSONException e) {
                Logger.d("", e.getMessage());
                return;
            }
        }
        this.binding.constOutsideSpinnerDec.setSelection(0);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        Logger.d("", "");
    }

    public void updateIssueDate1() {
        this.binding.dobEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.dobcalendar.getTime()));
    }

    public boolean passport() {
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
        if (this.binding.passportEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter passport number");
            return false;
        }
        if (!this.binding.passportEd.getText().toString().matches(RegexMatcher.PASSPORT_REGEX)) {
            showdialog(this.alert, "Please enter correct passport number");
            return false;
        }
        if (this.binding.issueDateEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select issue date");
            return false;
        }
        if (this.binding.expiryDateEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select expiry date");
            return false;
        }
        if (!this.binding.filename.getText().toString().isEmpty()) {
            return true;
        }
        showdialog(this.alert, "Please choose the file");
        return false;
    }

    private void initializingClicks() {
        this.binding.selectStateLayout.setOnClickListener(this);
        this.binding.personalDetailLayout.setOnClickListener(this);
        this.binding.residenceDetailsLayout.setOnClickListener(this);
        this.binding.optionalDetailsLayout.setOnClickListener(this);
        this.binding.familyDetailsLayout.setOnClickListener(this);
        this.binding.outsideLayout.setOnClickListener(this);
        this.binding.ordinaryLayout.setOnClickListener(this);
        this.binding.declarationLayout.setOnClickListener(this);
        this.binding.backBtnIv.setOnClickListener(this);
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
        if (v.getId() == 2131365502) {
            tab3();
        }
        if (v.getId() == 2131364932) {
            tab4();
        }
        if (v.getId() == 2131363780) {
            tab5();
        }
        if (v.getId() == 2131364941) {
            tab8();
        }
        if (v.getId() == 2131363077) {
            tab6();
        }
        if (v.getId() == 2131364984) {
            tab7();
        }
        if (v.getId() == 2131365561) {
            nextFragment();
        }
        if (v.getId() == 2131365248) {
            prevFragment();
        }
        if (v.getId() == 2131362458) {
            openFragment(new VoterFormsFragment(), this.voterforms);
        }
        if (v.getId() == 2131365497) {
            reset();
        }
    }

    private void tab7() {
        this.binding.outsideDetails.setVisibility(0);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.currentSelectedView = this.binding.outsideLayout;
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab8() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(0);
        this.binding.decleration.setVisibility(8);
        this.currentSelectedView = this.binding.ordinaryLayout;
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab1() {
        this.binding.overseasVoter.setVisibility(0);
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.binding.previousTv.setEnabled(false);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.previousTv.setTextColor(Color.parseColor(this.color));
        this.binding.resetTv.setEnabled(false);
        this.binding.resetTv.setTextColor(Color.parseColor(this.color));
        this.currentSelectedView = this.binding.selectStateLayout;
        if (this.district != null) {
            if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab2() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(0);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        this.currentSelectedView = this.binding.personalDetailLayout;
        if (!this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab3() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(0);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.currentSelectedView = this.binding.residenceDetailsLayout;
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab4() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(0);
        this.binding.visaDetails.setVisibility(8);
        this.binding.decleration.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.currentSelectedView = this.binding.optionalDetailsLayout;
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab5() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(0);
        this.binding.decleration.setVisibility(8);
        this.currentSelectedView = this.binding.familyDetailsLayout;
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    private void tab6() {
        this.binding.outsideDetails.setVisibility(8);
        this.binding.personalDetails.setVisibility(8);
        this.binding.overseasVoter.setVisibility(8);
        this.binding.residenceDetails.setVisibility(8);
        this.binding.passportDetails.setVisibility(8);
        this.binding.visaDetails.setVisibility(8);
        this.binding.ordinaryResidenceLayout.setVisibility(8);
        this.binding.decleration.setVisibility(0);
        this.currentSelectedView = this.binding.declarationLayout;
        this.binding.previousTv.setEnabled(true);
        this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
        this.binding.resetTv.setEnabled(true);
        this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
        if (!this.binding.stateSpinner.getText().toString().isEmpty() && !this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1 && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty()) {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && !this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.dateEd.getText().toString().isEmpty()) {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        if (this.visaflag == 1) {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
        } else {
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
        }
        this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
    }

    /* JADX WARN: Failed to calculate best type for var: r1v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v22 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v22 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v24 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v24 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v26 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v26 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v30 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v30 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v32 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v32 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v34 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v34 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v22 android.widget.LinearLayout, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    private void nextFragment() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.yyFormat);
        if (this.currentSelectedView == this.binding.selectStateLayout) {
            if (selectstate()) {
                if (this.form.equals(this.rejected)) {
                    try {
                        this.binding.firstNameEd.setText(this.rejectedJson.get(Constants.FIRST_NAME).toString());
                        if (this.rejectedJson.get(this.lastNameText).toString().equals("null") || this.rejectedJson.get(this.lastNameText).toString().equals(" ") || this.rejectedJson.get(this.lastNameText).toString() == null) {
                            this.binding.surNameEd.setText("");
                        } else {
                            this.binding.surNameEd.setText(this.rejectedJson.get(this.lastNameText).toString());
                        }
                        if (this.rejectedJson.get(this.lastNameL1).toString().equals("null") || this.rejectedJson.get(this.lastNameL1).toString().equals(" ") || this.rejectedJson.get(this.lastNameL1).toString() == null) {
                            this.binding.surnameEnglish.setText("");
                        } else {
                            this.binding.surnameEnglish.setText(this.rejectedJson.get(this.lastNameL1).toString());
                        }
                        this.binding.firstnameEnglish.setText(this.rejectedJson.get("firstNameL1").toString());
                        this.binding.relativeNameEnglish.setText(this.rejectedJson.get("applicantRelativeNameL1").toString());
                        this.binding.relativeName.setText(this.rejectedJson.get("applicantRelativeName").toString());
                        if (this.rejectedJson.get(this.applicantRelativeSurname).toString().equals("null") || this.rejectedJson.get(this.applicantRelativeSurname).toString().equals(" ") || this.rejectedJson.get(this.applicantRelativeSurname).toString() == null) {
                            this.binding.relativeLastname.setText("");
                        } else {
                            this.binding.relativeLastname.setText(this.rejectedJson.get(this.applicantRelativeSurname).toString());
                        }
                        if (this.rejectedJson.get(this.applicantRelativesurnameL1).toString().equals("null") || this.rejectedJson.get(this.applicantRelativesurnameL1).toString().equals(" ") || this.rejectedJson.get(this.applicantRelativesurnameL1).toString() == null) {
                            this.binding.relativeLastnameEnglish.setText("");
                        } else {
                            this.binding.relativeLastnameEnglish.setText(this.rejectedJson.get(this.applicantRelativesurnameL1).toString());
                        }
                        if (this.rejectedJson.get(this.typeOfRelation).toString().equals("FTHR") || this.rejectedJson.get(this.typeOfRelation).toString().equals("MTHR") || this.rejectedJson.get(this.typeOfRelation).toString().equals("HSBN") || this.rejectedJson.get(this.typeOfRelation).toString().equals("WIFE") || this.rejectedJson.get(this.typeOfRelation).toString().equals("OTHR")) {
                            this.binding.relationSpinner.setSelection(this.relationcode1.indexOf(this.rejectedJson.get(this.typeOfRelation).toString()));
                        } else {
                            this.binding.relationSpinner.setSelection(0);
                        }
                        this.binding.dobEd.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get("dob").toString())));
                        this.binding.statePersonalSpinner.setSelection(this.statecode1.indexOf(this.rejectedJson.get("birthStateCd").toString()));
                        if (this.rejectedJson.get(this.birthTown).toString().equals("null") || this.rejectedJson.get(this.birthTown).toString() == null) {
                            this.binding.villagePersonalSpinner.setText("");
                        } else {
                            this.binding.villagePersonalSpinner.setText(this.rejectedJson.get(this.birthTown).toString());
                        }
                        if (this.rejectedJson.get(this.applicantGender).toString().equals("M") || this.rejectedJson.get(this.applicantGender).toString().equals("F") || this.rejectedJson.get(this.applicantGender).toString().equals("T")) {
                            this.binding.genderPersonalSpinner.setSelection(this.gendercode.indexOf(this.rejectedJson.get(this.applicantGender).toString()));
                        } else {
                            this.binding.genderPersonalSpinner.setSelection(0);
                        }
                        if (this.rejectedJson.get(this.mobileNumberText).toString().equals("null") || this.rejectedJson.get(this.mobileNumberText).toString().equals(" ") || this.rejectedJson.get(this.mobileNumberText).toString() == null) {
                            this.binding.mobileNumEd.setText("");
                        } else {
                            this.binding.mobileNumEd.setText(this.rejectedJson.get(this.mobileNumberText).toString());
                        }
                        if (this.rejectedJson.get(this.emailText).toString() == null || this.rejectedJson.get(this.emailText).toString().equals("null") || this.rejectedJson.get(this.emailText).toString().equals(" ")) {
                            this.binding.emailEd.setText("");
                        } else {
                            this.binding.emailEd.setText(this.rejectedJson.get(this.emailText).toString());
                        }
                        this.binding.photoNameTv2.setVisibility(0);
                        this.binding.photoNameTv2.setText(this.rejectedJson.get(this.photograph).toString().substring(this.rejectedJson.get(this.photograph).toString().lastIndexOf("/") + 1));
                        this.binding.cancel.setVisibility(0);
                        this.binding.image.setVisibility(0);
                        this.photoref = this.rejectedJson.get(this.photograph).toString();
                        if (this.rejectedJson.get(this.photograph).toString().contains(".pdf")) {
                            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
                        } else {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda33
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str) {
                                    this.f$0.lambda$nextFragment$47(i, str);
                                }
                            });
                        }
                    } catch (Exception e) {
                        Logger.d("", e.getMessage());
                    }
                }
                this.binding.nested.smoothScrollTo(0, (int) this.binding.personalDetails.getY());
                this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
                this.binding.previousTv.setEnabled(true);
                this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
                this.binding.resetTv.setEnabled(true);
                this.binding.selectStateLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 400, this.binding.horizontal.getScrollY());
                this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.personalDetailLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.personalDetails.setVisibility(0);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(8);
                this.binding.decleration.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.personalDetailLayout) {
            if (personal()) {
                this.binding.nested.smoothScrollTo(0, (int) this.binding.residenceDetails.getY());
                String str = new SimpleDateFormat("dd/MM/yyyy HH:mm aaa", Locale.getDefault()).format(Calendar.getInstance().getTime());
                String str2 = this.binding.stateSpinner.getText().toString() + this.delimeter + this.binding.districtSpinner.getText().toString() + this.delimeter + this.binding.noEd.getText().toString() + this.delimeter + this.binding.assemblyEd.getText().toString();
                String str3 = this.binding.firstNameEd.getText().toString() + this.delimeter + this.binding.surNameEd.getText().toString() + this.delimeter + this.binding.firstnameEnglish.getText().toString() + this.delimeter + this.binding.surnameEnglish.getText().toString() + this.delimeter + this.binding.photoNameTv2.getText().toString() + this.delimeter + this.binding.photoSize.getText().toString() + this.delimeter + this.relationpos + this.delimeter + this.binding.relativeName.getText().toString() + this.delimeter + this.binding.relativeLastname.getText().toString() + this.delimeter + this.binding.relativeNameEnglish.getText().toString() + this.delimeter + this.binding.relativeLastnameEnglish.getText().toString() + this.delimeter + this.binding.mobileNumEd.getText().toString() + this.delimeter + this.binding.emailEd.getText().toString() + this.delimeter + this.genderpos + this.delimeter + this.binding.dobEd.getText().toString() + this.delimeter + this.isIndia + this.delimeter + this.statepos + this.delimeter + this.districtpos + this.delimeter + this.binding.villagePersonalSpinner.getText().toString() + this.delimeter + this.outsidePlaceofBirth;
                if (this.form.equals("draftform") || this.personalFlag == 1) {
                    updatepersonal(this.binding.firstNameEd.getText().toString() + " " + this.binding.surNameEd.getText().toString(), str3, this.referencenumber, 2, this.photoref, str);
                } else if (this.form.equals(this.rejected)) {
                    try {
                        this.binding.houseNoEd.setText(this.rejectedJson.get("oriHouseNumber").toString());
                        this.binding.houseRegional.setText(this.rejectedJson.get("oriHouseNumberL1").toString());
                        this.binding.streetEd.setText(this.rejectedJson.get("localityStreet").toString());
                        this.binding.streetRegional.setText(this.rejectedJson.get("oriLocalityL1").toString());
                        if (this.rejectedJson.get(this.oriPostOffice).toString().equals("NAA")) {
                            this.binding.postofficeEd.setText("");
                        } else {
                            this.binding.postofficeEd.setText(this.rejectedJson.get(this.oriPostOffice).toString());
                        }
                        if (this.rejectedJson.get(this.oriPostOfficeL1).toString().equals("NAA")) {
                            this.binding.postofficeOfficial.setText("");
                        } else {
                            this.binding.postofficeOfficial.setText(this.rejectedJson.get(this.oriPostOfficeL1).toString());
                        }
                        this.binding.pincodeEd.setText(this.rejectedJson.get("oriPinCode").toString());
                        this.binding.villageEd.setText(this.rejectedJson.get("oriVillageTown").toString());
                        this.binding.villageRegional.setText(this.rejectedJson.get("oriVillageTownL1").toString());
                        this.binding.districtSpinner.setText(this.districtName);
                    } catch (JSONException e2) {
                        Logger.d("", e2.getMessage());
                    }
                } else {
                    this.personalFlag = 1;
                    insertforms(this.binding.firstNameEd.getText().toString() + " " + this.binding.surNameEd.getText().toString(), str2, str3, 2, "Form 6A", this.referencenumber, str, this.photoref);
                }
                this.binding.personalDetailLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.residenceDetailsLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(r6);
                this.binding.personalDetails.setVisibility(r6);
                this.binding.overseasVoter.setVisibility(r6);
                this.binding.residenceDetails.setVisibility(0);
                this.binding.passportDetails.setVisibility(r6);
                this.binding.visaDetails.setVisibility(r6);
                this.binding.decleration.setVisibility(r6);
                this.binding.outsideDetails.setVisibility(8);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.residenceDetailsLayout) {
            if (residence()) {
                this.binding.nested.smoothScrollTo(0, (int) this.binding.passportDetails.getY());
                String str4 = this.binding.houseNoEd.getText().toString() + this.delimeter + this.binding.houseRegional.getText().toString() + this.delimeter + this.binding.streetEd.getText().toString() + this.delimeter + this.binding.streetRegional.getText().toString() + this.delimeter + this.binding.villageEd.getText().toString() + this.delimeter + this.binding.villageRegional.getText().toString() + this.delimeter + this.districtposinac + this.delimeter + this.binding.pincodeEd.getText().toString() + this.delimeter + this.binding.postofficeEd.getText().toString() + this.delimeter + this.binding.postofficeOfficial.getText().toString();
                if (this.form.equals(this.rejected)) {
                    try {
                        if (this.rejectedJson.get(this.placeOfPassportIssue).toString().equals("null") || this.rejectedJson.get(this.placeOfPassportIssue).toString().equals(" ") || this.rejectedJson.get(this.placeOfPassportIssue).toString() == null) {
                            this.binding.placeIssueEd.setText("");
                        } else {
                            this.binding.placeIssueEd.setText(this.rejectedJson.get(this.placeOfPassportIssue).toString());
                        }
                        this.binding.passportEd.setText(this.rejectedJson.get("passportNumber").toString());
                        this.binding.issueDateEd.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get("dateOfPassportIssue").toString())));
                        this.binding.expiryDateEd.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get("passportExpiry").toString())));
                        this.passref = this.rejectedJson.get("passport").toString();
                        TextView textView = this.binding.filename;
                        String str5 = this.passref;
                        textView.setText(str5.substring(str5.lastIndexOf("/") + 1));
                        this.binding.filename.setVisibility(0);
                        if (this.passref.contains(".pdf")) {
                            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                        } else {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda44
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str6) {
                                    this.f$0.lambda$nextFragment$49(i, str6);
                                }
                            });
                        }
                        this.binding.preview.setVisibility(0);
                        this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.delete.setVisibility(0);
                    } catch (Exception e3) {
                        Logger.d("", e3.getMessage());
                    }
                } else {
                    updateresidence(this.referencenumber, str4, 3);
                }
                this.binding.residenceDetailsLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.optionalDetailsLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.personalDetails.setVisibility(8);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(0);
                this.binding.visaDetails.setVisibility(8);
                this.binding.decleration.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.optionalDetailsLayout) {
            if (passport()) {
                this.binding.nested.smoothScrollTo(0, (int) this.binding.visaDetails.getY());
                String str6 = this.binding.passportEd.getText().toString() + this.delimeter + this.binding.placeIssueEd.getText().toString() + this.delimeter + this.binding.issueDateEd.getText().toString() + this.delimeter + this.binding.expiryDateEd.getText().toString() + this.delimeter + this.binding.filename.getText().toString() + this.delimeter + this.binding.filesize.getText().toString();
                if (this.form.equals(this.rejected)) {
                    try {
                        if (this.rejectedJson.get(this.visaNumber).toString().equals("null") || this.rejectedJson.get(this.visaNumber).toString().equals(" ") || this.rejectedJson.get(this.visaNumber).toString() == null) {
                            this.binding.visaNoEd.setText("");
                        } else {
                            this.binding.visaNoEd.setText(this.rejectedJson.get(this.visaNumber).toString());
                        }
                        if (this.rejectedJson.get(this.typeOfVisa).toString().equals("null") || this.rejectedJson.get(this.typeOfVisa).toString().equals(" ") || this.rejectedJson.get(this.typeOfVisa).toString() == null) {
                            this.binding.visaTypeEd.setText("");
                        } else {
                            this.binding.visaTypeEd.setText(this.rejectedJson.get(this.typeOfVisa).toString());
                        }
                        if (this.rejectedJson.get(this.dateOfVisaIssue).toString().equals("null") || this.rejectedJson.get(this.dateOfVisaIssue).toString().equals(" ") || this.rejectedJson.get(this.dateOfVisaIssue).toString() == null) {
                            this.binding.issueDateEdVisa.setText("");
                        } else {
                            this.binding.issueDateEdVisa.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get(this.dateOfVisaIssue).toString())));
                        }
                        if (this.rejectedJson.get(this.dateOfVisaExpiry).toString().equals("null") || this.rejectedJson.get(this.dateOfVisaExpiry).toString().equals(" ") || this.rejectedJson.get(this.dateOfVisaExpiry).toString() == null) {
                            this.binding.expiryDateEdVisa.setText("");
                        } else {
                            this.binding.expiryDateEdVisa.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get(this.dateOfVisaExpiry).toString())));
                        }
                        if (this.rejectedJson.get(this.visaIssuingAuthority).toString().equals("null") || this.rejectedJson.get(this.visaIssuingAuthority).toString().equals(" ") || this.rejectedJson.get(this.visaIssuingAuthority).toString() == null) {
                            this.binding.authorityEd.setText("");
                        } else {
                            this.binding.authorityEd.setText(this.rejectedJson.get(this.visaIssuingAuthority).toString());
                        }
                    } catch (Exception e4) {
                        Logger.d("", e4.getMessage());
                    }
                } else {
                    updatepassport(this.referencenumber, str6, 4, this.passref);
                }
                this.binding.optionalDetailsLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.familyDetailsLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.personalDetails.setVisibility(8);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(0);
                this.binding.decleration.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.familyDetailsLayout) {
            if (visa()) {
                this.visaflag = 1;
                this.binding.nested.smoothScrollTo(0, (int) this.binding.ordinaryResidenceLayout.getY());
                String str7 = this.binding.visaNoEd.getText().toString() + this.delimeter + this.binding.visaTypeEd.getText().toString() + this.delimeter + this.binding.authorityEd.getText().toString() + this.delimeter + this.binding.issueDateEdVisa.getText().toString() + this.delimeter + this.binding.expiryDateEdVisa.getText().toString() + this.delimeter;
                if (this.form.equals(this.rejected)) {
                    try {
                        this.binding.dateEd.setText(simpleDateFormat.format(simpleDateFormat2.parse(this.rejectedJson.get("dateFromWhichAbsentOnOrdinaryResidence").toString())));
                        if (this.rejectedJson.get(this.reasonOfAbsence).toString().equals("EMPL")) {
                            this.binding.employment.setChecked(true);
                        } else if (this.rejectedJson.get(this.reasonOfAbsence).toString().equals("EDU")) {
                            this.binding.education.setChecked(true);
                        } else if (this.rejectedJson.get(this.reasonOfAbsence).toString().equals("OTHR")) {
                            this.binding.other.setChecked(true);
                            this.binding.descEd.setText(this.rejectedJson.get("reasonOfAbsenceOthersDesc").toString());
                        }
                    } catch (Exception e5) {
                        Logger.d("", e5.getMessage());
                    }
                } else {
                    updateVisa(this.referencenumber, str7, 5);
                }
                this.binding.familyDetailsLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.ordinaryLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(0);
                this.binding.personalDetails.setVisibility(8);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(8);
                this.binding.decleration.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.ordinaryLayout) {
            if (ordinaryResidence()) {
                this.binding.nested.smoothScrollTo(0, (int) this.binding.outsideDetails.getY());
                String str8 = this.reasonabsenting + this.delimeter + this.binding.dateEd.getText().toString() + this.delimeter + this.binding.descEd.getText().toString();
                if (this.form.equals(this.rejected)) {
                    try {
                        this.binding.houseNoEd2.setText(this.rejectedJson.get("crosiHouseNumber").toString());
                        this.binding.streetEd2.setText(this.rejectedJson.get("crosiLocalityStreet").toString());
                        this.binding.villageSpinner1.setText(this.rejectedJson.get("crosiVillageTown").toString());
                        if (this.rejectedJson.get(this.crosiState).toString().contains("0")) {
                            this.binding.stateOutsideSpinner.setText(this.stateList.get(this.statecode1.indexOf(this.rejectedJson.get(this.crosiState).toString())));
                        } else {
                            this.binding.stateOutsideSpinner.setText(this.rejectedJson.get(this.crosiState).toString());
                        }
                        this.binding.countrySpinner.setSelection(this.countrycode.indexOf(this.rejectedJson.get("crosiCountryCd").toString()));
                        this.binding.zipEd.setText(this.rejectedJson.get("crosiZipCode").toString());
                    } catch (JSONException e6) {
                        Logger.d("", e6.getMessage());
                    }
                } else {
                    updateordinary(this.referencenumber, str8, 6);
                }
                this.binding.ordinaryLayout.setEnabled(true);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.outsideLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.personalDetails.setVisibility(8);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(8);
                this.binding.decleration.setVisibility(8);
                this.binding.outsideDetails.setVisibility(0);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.outsideLayout) {
            if (outsideIndia()) {
                this.binding.nested.smoothScrollTo(0, (int) this.binding.decleration.getY());
                String str9 = this.binding.houseNoEd2.getText().toString() + this.delimeter + this.binding.streetEd2.getText().toString() + this.delimeter + this.binding.villageSpinner1.getText().toString() + this.delimeter + this.binding.stateOutsideSpinner.getText().toString() + this.delimeter + this.countrypos + this.delimeter + this.binding.zipEd.getText().toString();
                if (this.form.equals(this.rejected)) {
                    try {
                        if (this.rejectedJson.get(this.declareApplCode).toString().equals("M_IN")) {
                            this.binding.name.setChecked(true);
                            if (!this.rejectedJson.get(this.declState).toString().equals("null")) {
                                this.binding.stateOutsideSpinnerDec.setSelection(this.statecode1.indexOf(this.rejectedJson.get(this.declState).toString()));
                            } else {
                                this.binding.stateOutsideSpinnerDec.setSelection(0);
                            }
                            if (this.rejectedJson.get(this.declFullAddress).toString().equals("null") || this.rejectedJson.get(this.declFullAddress).toString().equals(" ") || this.rejectedJson.get(this.declFullAddress).toString() == null) {
                                this.binding.addressEd.setText("");
                            } else {
                                this.binding.addressEd.setText(this.rejectedJson.get(this.declFullAddress).toString());
                            }
                        } else if (this.rejectedJson.get(this.declareApplCode).toString().equals("N_IN")) {
                            this.binding.notname.setChecked(true);
                        }
                    } catch (JSONException e7) {
                        Logger.d("", e7.getMessage());
                    }
                } else {
                    updateoutsideIndia(this.referencenumber, str9, 7);
                }
                this.binding.outsideLayout.setEnabled(true);
                this.binding.dateEdDecleration.setText(this.submitdate);
                this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 600, this.binding.horizontal.getScrollY());
                this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
                this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
                this.currentSelectedView = this.binding.declarationLayout;
                this.binding.ordinaryResidenceLayout.setVisibility(8);
                this.binding.outsideDetails.setVisibility(8);
                this.binding.personalDetails.setVisibility(8);
                this.binding.overseasVoter.setVisibility(8);
                this.binding.residenceDetails.setVisibility(8);
                this.binding.passportDetails.setVisibility(8);
                this.binding.visaDetails.setVisibility(8);
                this.binding.decleration.setVisibility(0);
                return;
            }
            return;
        }
        if (this.currentSelectedView == this.binding.declarationLayout) {
            this.binding.declarationLayout.setEnabled(true);
            if (declaration()) {
                updatedeclaration(this.referencenumber, this.binding.addressEd.getText().toString() + this.delimeter + this.binding.epicNoEd.getText().toString() + this.delimeter + this.binding.dateIssueEd.getText().toString() + this.delimeter + this.declare + this.delimeter + this.statedec + this.delimeter + this.districtdec + this.delimeter + this.constdec, 8);
                this.binding.constraintLayout1.setVisibility(0);
                this.binding.previewLayout.setVisibility(0);
                this.binding.cardViewpre.setVisibility(0);
                this.binding.constraintLayout.setVisibility(8);
                this.binding.cardView.setVisibility(8);
                this.binding.homeFragmentTopConstraintLayout.setVisibility(8);
                this.binding.nested.setVisibility(8);
                previewset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextFragment$47(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda79
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$nextFragment$46(dialogInterface, i2);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextFragment$46(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextFragment$49(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda37
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$nextFragment$48(dialogInterface, i2);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextFragment$48(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void updatepersonal(String name, String personal, String referencenumber, int i, String photoref, String date) {
        this.viewModel.updatepersonal(name, personal, referencenumber, i, photoref, date);
    }

    private void updatedeclaration(String referencenumber, String declaration, int i) {
        this.viewModel.updatedeclaration(referencenumber, declaration, i);
    }

    private void previewset() {
        this.binding.state.setText(this.binding.stateSpinner.getText().toString());
        this.binding.district.setText(this.binding.districtSpinner.getText().toString());
        this.binding.constituency.setText(this.binding.noEd.getText().toString() + " | " + this.binding.assemblyEd.getText().toString());
        this.binding.namepreview.setText(this.binding.firstNameEd.getText().toString());
        this.binding.namepreview1.setText(this.binding.firstnameEnglish.getText().toString());
        this.binding.lastnamepreview.setText(this.binding.surNameEd.getText().toString());
        this.binding.lastnamepreview1.setText(this.binding.surnameEnglish.getText().toString());
        this.binding.relnamepreview.setText(this.binding.relativeName.getText().toString());
        this.binding.relnamepreview1.setText(this.binding.relativeNameEnglish.getText().toString());
        this.binding.rellastnamepreview.setText(this.binding.relativeLastname.getText().toString());
        this.binding.rellastnamepreview1.setText(this.binding.relativeLastnameEnglish.getText().toString());
        this.binding.relationtype.setText(this.binding.relationSpinner.getSelectedItem().toString());
        this.binding.genderpreview.setText(this.binding.genderPersonalSpinner.getSelectedItem().toString());
        this.binding.dobed.setText(this.binding.dobEd.getText().toString());
        if (this.binding.indiaRb.isChecked()) {
            this.binding.indiaRbPre.setChecked(true);
            this.binding.outsideRbPre.setEnabled(false);
            this.binding.indiaLayoutPre.setVisibility(0);
            this.binding.outsideIndiaLayoutPre.setVisibility(8);
            this.binding.birthstatePre.setText(this.binding.statePersonalSpinner.getSelectedItem().toString());
            this.binding.birthdistrictPre.setText(this.binding.districtPersonalSpinner.getSelectedItem().toString());
            this.binding.birthtownPre.setText(this.binding.villagePersonalSpinner.getText().toString());
        }
        if (this.binding.outsideRb.isChecked()) {
            this.binding.outsideRbPre.setChecked(true);
            this.binding.indiaRbPre.setEnabled(false);
            this.binding.outsideIndiaLayoutPre.setVisibility(0);
            this.binding.indiaLayoutPre.setVisibility(8);
            this.binding.countrydecPre.setText(this.binding.outsideIndiaSpinner.getSelectedItem().toString());
        }
        this.binding.emailpreview.setText(this.binding.emailEd.getText().toString());
        this.binding.mobilepreview.setText("+91-" + this.binding.mobileNumEd.getText().toString());
        this.binding.filenamepreview.setText(this.binding.photoNameTv2.getText().toString());
        if (this.binding.filenamepreview.getText().toString().contains(".pdf")) {
            this.binding.imagepreview.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda27
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$previewset$53(i, str);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.binding.housepreview.setText(this.binding.houseNoEd.getText().toString());
        this.binding.housepreview1.setText(this.binding.houseRegional.getText().toString());
        this.binding.postofficepreview.setText(this.binding.postofficeEd.getText().toString());
        this.binding.postofficepreview1.setText(this.binding.postofficeOfficial.getText().toString());
        this.binding.streetpreview.setText(this.binding.streetEd.getText().toString());
        this.binding.streetpreview1.setText(this.binding.streetRegional.getText().toString());
        this.binding.townpreview.setText(this.binding.villageEd.getText().toString());
        this.binding.townpreview1.setText(this.binding.villageRegional.getText().toString());
        this.binding.districtpre.setText(this.binding.districtSpinner1.getText().toString());
        this.binding.pincodepreview.setText(this.binding.pincodeEd.getText().toString());
        this.binding.placepasspreview.setText(this.binding.placeIssueEd.getText().toString());
        this.binding.passnopreview.setText(this.binding.passportEd.getText().toString());
        this.binding.issuepasspre.setText(this.binding.issueDateEd.getText().toString());
        this.binding.expirypasspreview.setText(this.binding.expiryDateEd.getText().toString());
        this.binding.filenamepasspreview.setText(this.binding.filename.getText().toString());
        if (this.binding.filenamepasspreview.getText().toString().contains(".pdf")) {
            this.binding.imagepasspreview.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda28
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$previewset$57(i, str);
                    }
                });
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
        }
        this.binding.visanopreview.setText(this.binding.visaNoEd.getText().toString());
        this.binding.issuevisapreview.setText(this.binding.issueDateEdVisa.getText().toString());
        this.binding.expiryvisapreview.setText(this.binding.expiryDateEdVisa.getText().toString());
        this.binding.visatypepre.setText(this.binding.visaTypeEd.getText().toString());
        this.binding.authpre.setText(this.binding.authorityEd.getText().toString());
        if (this.binding.employment.isChecked()) {
            this.binding.employmentpre.setChecked(true);
            this.binding.educationpre.setEnabled(false);
            this.binding.otherpre.setEnabled(false);
            this.binding.desLayoutpre.setVisibility(8);
        } else if (this.binding.education.isChecked()) {
            this.binding.educationpre.setChecked(true);
            this.binding.employmentpre.setEnabled(false);
            this.binding.otherpre.setEnabled(false);
            this.binding.desLayoutpre.setVisibility(8);
        } else if (this.binding.other.isChecked()) {
            this.binding.otherpre.setChecked(true);
            this.binding.employmentpre.setEnabled(false);
            this.binding.educationpre.setEnabled(false);
            this.binding.desLayoutpre.setVisibility(0);
            this.binding.descriptpre.setText(this.binding.descEd.getText().toString());
        }
        this.binding.dateabsentpre.setText(this.binding.dateEd.getText().toString());
        this.binding.housenopre.setText(this.binding.houseNoEd2.getText().toString());
        this.binding.streetpre.setText(this.binding.streetEd2.getText().toString());
        this.binding.towncurrpreview.setText(this.binding.villageSpinner1.getText().toString());
        this.binding.statecurrpre.setText(this.binding.stateOutsideSpinner.getText().toString());
        this.binding.countrypre.setText(this.binding.countrySpinner.getSelectedItem().toString());
        this.binding.zippre.setText(this.binding.zipEd.getText().toString());
        if (this.binding.notname.isChecked()) {
            this.binding.notnamepre.setChecked(true);
            this.binding.namepre.setEnabled(false);
            this.binding.linear.setVisibility(8);
        } else if (this.binding.name.isChecked()) {
            this.binding.namepre.setChecked(true);
            this.binding.notnamepre.setEnabled(false);
            this.binding.constituencypre.setText(this.binding.constOutsideSpinnerDec.getSelectedItem().toString());
            this.binding.statedecpre.setText(this.binding.stateOutsideSpinnerDec.getSelectedItem().toString());
            this.binding.districtdecpre.setText(this.binding.districtOutsideSpinnerDec.getSelectedItem().toString());
            this.binding.fulladdpre.setText(this.binding.addressEd.getText().toString());
            this.binding.epicpre.setText(this.binding.epicNoEd.getText().toString());
            this.binding.dateissuepre.setText(this.binding.dateIssueEd.getText().toString());
            this.binding.linear.setVisibility(0);
        }
        this.binding.placepre.setText(this.binding.placeEd.getText().toString());
        this.binding.subdatepre.setText(this.binding.dateEdDecleration.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$53(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda71
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$previewset$52(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.imagepreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$52(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda72
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$previewset$50(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda73
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$previewset$51(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$50(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$51(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.imagepreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$57(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda46
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$previewset$56(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.imagepasspreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$56(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda29
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$previewset$54(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda30
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$previewset$55(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$54(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewset$55(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.imagepasspreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public void updateVisa(String referencenumber, String visa, int seq) {
        this.viewModel.updateVisa(referencenumber, visa, seq);
    }

    public void updateordinary(String referencenumber, String visa, int seq) {
        this.viewModel.updateordinary(referencenumber, visa, seq);
    }

    public void updatepassport(String referencenumber, String passport, int seq, String passprtpdf) {
        this.viewModel.updatepassport(referencenumber, passport, seq, passprtpdf);
    }

    public void updateresidence(String referencenumber, String residence, int seq) {
        this.viewModel.updateresidence(referencenumber, residence, seq);
    }

    private void insertforms(String name, String insertState, String personal, int seq, String formtype, String referencenumber, String createdon, String img) {
        this.viewModel.insertforms(name, insertState, personal, seq, formtype, referencenumber, createdon, img);
    }

    public void updateoutsideIndia(String referencenumber, String outsideindia, int seq) {
        this.viewModel.updateoutsideIndia(referencenumber, outsideindia, seq);
    }

    private void prevFragment() {
        if (this.currentSelectedView == this.binding.personalDetailLayout) {
            this.currentSelectedView = this.binding.selectStateLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 1500, this.binding.horizontal.getScrollY());
            if (!this.binding.firstNameEd.getText().toString().isEmpty() && !this.binding.firstnameEnglish.getText().toString().isEmpty() && !this.binding.relativeName.getText().toString().isEmpty() && !this.binding.relativeNameEnglish.getText().toString().isEmpty() && !this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg) && !this.binding.dobEd.getText().toString().isEmpty() && !this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg) && !this.binding.photoNameTv2.getText().toString().isEmpty() && this.binding.placeOfBirthRG.getCheckedRadioButtonId() != -1) {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.previousTv.setEnabled(false);
            this.binding.resetTv.setEnabled(false);
            this.binding.previousTv.setTextColor(Color.parseColor(this.color));
            this.binding.resetTv.setTextColor(Color.parseColor(this.color));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.overseasVoter.setVisibility(0);
            return;
        }
        if (this.currentSelectedView == this.binding.residenceDetailsLayout) {
            this.currentSelectedView = this.binding.personalDetailLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 600, this.binding.horizontal.getScrollY());
            if (!this.binding.houseNoEd.getText().toString().isEmpty() && !this.binding.streetEd.getText().toString().isEmpty() && !this.binding.villageEd.getText().toString().isEmpty() && this.binding.postofficeEd.getText().toString().isEmpty() && !this.binding.pincodeEd.getText().toString().isEmpty()) {
                this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(0);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            return;
        }
        if (this.currentSelectedView == this.binding.optionalDetailsLayout) {
            this.currentSelectedView = this.binding.residenceDetailsLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 600, this.binding.horizontal.getScrollY());
            if (!this.binding.passportEd.getText().toString().isEmpty() && !this.binding.issueDateEd.getText().toString().isEmpty() && !this.binding.expiryDateEd.getText().toString().isEmpty() && !this.binding.filename.getText().toString().isEmpty()) {
                this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(8);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.residenceDetails.setVisibility(0);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            return;
        }
        if (this.currentSelectedView == this.binding.familyDetailsLayout) {
            this.currentSelectedView = this.binding.optionalDetailsLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 600, this.binding.horizontal.getScrollY());
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(0);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.overseasVoter.setVisibility(8);
            return;
        }
        if (this.currentSelectedView == this.binding.ordinaryLayout) {
            this.currentSelectedView = this.binding.familyDetailsLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 600, this.binding.horizontal.getScrollY());
            if (!this.binding.dateEd.getText().toString().isEmpty()) {
                this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(8);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(0);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            return;
        }
        if (this.currentSelectedView == this.binding.outsideLayout) {
            this.currentSelectedView = this.binding.ordinaryLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 600, this.binding.horizontal.getScrollY());
            if (!this.binding.houseNoEd2.getText().toString().isEmpty() && !this.binding.streetEd2.getText().toString().isEmpty() && !this.binding.villageSpinner1.getText().toString().isEmpty() && !this.binding.stateOutsideSpinner.getText().toString().isEmpty() && !this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg) && !this.binding.zipEd.getText().toString().isEmpty()) {
                this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(8);
            this.binding.personalDetails.setVisibility(8);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(0);
            return;
        }
        if (this.currentSelectedView == this.binding.declarationLayout) {
            this.currentSelectedView = this.binding.outsideLayout;
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() - 400, this.binding.horizontal.getScrollY());
            if (!this.binding.dateEdDecleration.getText().toString().isEmpty() && !this.binding.placeEd.getText().toString().isEmpty() && this.binding.radioParentDecleration.getCheckedRadioButtonId() != -1) {
                this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            } else {
                this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state));
            }
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.outsideDetails.setVisibility(0);
            this.binding.personalDetails.setVisibility(8);
            this.binding.residenceDetails.setVisibility(8);
            this.binding.passportDetails.setVisibility(8);
            this.binding.visaDetails.setVisibility(8);
            this.binding.decleration.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.overseasVoter.setVisibility(8);
            return;
        }
        this.binding.previousTv.setEnabled(false);
        this.binding.previousTv.setTextColor(Color.parseColor(this.color));
    }

    private void showdialog1(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda35
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$58(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$58(DialogInterface dialogInterface, int i) {
        insertData();
        try {
            FileUtils.deleteDirectory(new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/"));
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public boolean declaration() {
        if (this.binding.placeEd.getText().toString().isEmpty()) {
            this.binding.placeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.placeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.name.isChecked()) {
            if (this.binding.addressEd.getText().toString().isEmpty()) {
                this.binding.addressEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
            } else {
                this.binding.addressEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
            }
        }
        if (this.binding.radioParentDecleration.getCheckedRadioButtonId() == -1) {
            showdialog(this.alert, "Please Select any one of the radio button");
            return false;
        }
        if (this.binding.name.isChecked()) {
            if (this.binding.stateOutsideSpinnerDec.getSelectedItem().toString().equals(this.statemsg)) {
                showdialog(this.alert, "Please select state");
                return false;
            }
            if (this.binding.constOutsideSpinnerDec.getSelectedItem().toString().equals("Select Constituency")) {
                showdialog(this.alert, "Please select constituency");
                return false;
            }
            if (this.binding.addressEd.getText().toString().isEmpty()) {
                showdialog(this.alert, "Please enter full address");
                return false;
            }
            if (this.binding.epicNoEd.getText().toString().isEmpty() || this.binding.epicNoEd.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
                return true;
            }
            showdialog(this.alert, "Please Enter correct epic number");
            return false;
        }
        if (this.binding.dateEdDecleration.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter date");
            return false;
        }
        if (this.binding.placeEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter place");
            return false;
        }
        if (Objects.equals(this.binding.selectStateLayout.getBackground(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state))) {
            showdialog(this.alert, "Please fill select State, district, AC/PC tab completely");
            return false;
        }
        if (Objects.equals(this.binding.personalDetailLayout.getBackground().getConstantState(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state).getConstantState())) {
            showdialog(this.alert, "Please fill personal details completely");
            return false;
        }
        if (Objects.equals(this.binding.residenceDetailsLayout.getBackground().getConstantState(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state).getConstantState())) {
            showdialog(this.alert, "Please fill residence details completely");
            return false;
        }
        if (Objects.equals(this.binding.optionalDetailsLayout.getBackground().getConstantState(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state).getConstantState())) {
            showdialog(this.alert, "Please fill passport details completely");
            return false;
        }
        if (Objects.equals(this.binding.familyDetailsLayout.getBackground().getConstantState(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state).getConstantState())) {
            showdialog(this.alert, "Please fill visa details completely");
            return false;
        }
        if (Objects.equals(this.binding.ordinaryLayout.getBackground(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state))) {
            showdialog(this.alert, "Please fill ordinary residence tab completely");
            return false;
        }
        if (!Objects.equals(this.binding.outsideLayout.getBackground().getConstantState(), ContextCompat.getDrawable(requireContext(), R.drawable.blo_unselected_state).getConstantState())) {
            return true;
        }
        showdialog(this.alert, "Please fill outside address details completely");
        return false;
    }

    public boolean outsideIndia() {
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
        if (this.binding.villageSpinner1.getText().toString().isEmpty()) {
            this.binding.villageSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.villageSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.stateOutsideSpinner.getText().toString().isEmpty()) {
            this.binding.stateOutsideSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.stateOutsideSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg)) {
            this.binding.viewTehsilSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.viewTehsilSpinner1.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.zipEd.getText().toString().isEmpty() || this.binding.zipEd.getText().toString().length() != 5) {
            this.binding.zipEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.zipEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        Boolean boolValueOf = Boolean.valueOf(PostalCodeValidator.isValid(this.binding.zipEd.getText().toString(), this.countryISO));
        if (this.binding.houseNoEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter house number");
            return false;
        }
        if (this.binding.streetEd2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter street");
            return false;
        }
        if (this.binding.villageSpinner1.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please Select Village");
            return false;
        }
        if (this.binding.countrySpinner.getSelectedItem().toString().equals(this.countrymsg)) {
            showdialog(this.alert, "Please Select Country");
            return false;
        }
        if (this.binding.stateOutsideSpinner.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter State");
            return false;
        }
        if (this.binding.zipEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter zip code");
            return false;
        }
        if (boolValueOf.booleanValue()) {
            return true;
        }
        showdialog(this.alert, "Please enter correct zip code");
        return false;
    }

    public boolean visa() {
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

    public boolean selectstate() {
        if (this.referencenumber == null) {
            this.alertDialog.show();
            this.commonUtilClass.getreferencenumber(getContext(), this.asmblyNO, this.stateCode, "6A", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda16
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str) {
                    this.f$0.lambda$selectstate$62(i, str);
                }
            });
            return false;
        }
        if (this.binding.stateSpinner.getText().toString().isEmpty()) {
            this.binding.stateSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.stateSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.assemblyEd.getText().toString().isEmpty()) {
            this.binding.assemblyEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
            return true;
        }
        this.binding.assemblyEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectstate$62(int i, String str) {
        if (i == 401) {
            this.alertDialog.dismiss();
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda36
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$selectstate$61(i2, str2, str3);
                }
            });
        } else if (i == 200) {
            this.referencenumber = str;
            this.alertDialog.dismiss();
        } else {
            showdialog("Error -" + i, str);
            this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectstate$61(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda76
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$selectstate$59(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getreferencenumber(getContext(), this.asmblyNO, this.stateCode, "6A", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda77
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$selectstate$60(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectstate$59(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectstate$60(int i, String str) {
        if (i == 200) {
            this.referencenumber = str;
            this.alertDialog.dismiss();
        } else {
            showdialog("Error -" + i, str);
            this.alertDialog.dismiss();
        }
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda61
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$63(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$63(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = "voter_photo";
            Intent intent = new Intent(getContext(), (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = "voter_photo";
            Intent intent2 = new Intent(getContext(), (Class<?>) ManualFaceCaptureActivity.class);
            intent2.putExtra("camera_type_configuration", "back");
            intent2.putExtra("temp", this.temp);
            startActivityForResult(intent2, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void selectImage1() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda113
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage1$64(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage1$64(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(102);
            return;
        }
        if (charSequenceArr[i].equals(this.choosegallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(102);
        } else if (charSequenceArr[i].equals(this.choosepdf)) {
            this.alertDialog.show();
            openfile1();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda55
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public boolean personal() {
        Date date;
        Date date2;
        this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.surnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.relativeNameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.relativeLastnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        int iCalculateage = calculateage();
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
        if (this.binding.firstNameEd.getText().toString().isEmpty()) {
            this.binding.firstNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.firstNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.relativeName.getText().toString().isEmpty()) {
            this.binding.relativeName.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.relativeName.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg)) {
            this.binding.viewRelationSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.viewRelationSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.indiaRb.isChecked() && this.binding.statePersonalSpinner.getSelectedItem().toString().equals(this.statemsg)) {
            this.binding.viewStateSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.viewStateSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.indiaRb.isChecked() && (this.binding.districtPersonalSpinner.getSelectedItem().toString().isEmpty() || this.binding.districtPersonalSpinner.getSelectedItem().toString().equals(this.districtmsg))) {
            this.binding.viewDistrictSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.viewDistrictSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.dobEd.getText().toString().isEmpty() || iCalculateage < 17) {
            this.binding.dobEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.dobEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg)) {
            this.binding.viewGenderSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.viewGenderSpinner.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter first name in english");
            return false;
        }
        if (this.binding.firstnameEnglish.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter applicant first name in official language");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.firstnameEnglish.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Applicant first name(" + this.binding.firstnameEnglish.getText().toString() + ") should be in regional language.");
            this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!this.binding.surNameEd.getText().toString().isEmpty() && this.binding.surnameEnglish.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter applicant last name in official language");
            return false;
        }
        if (!this.binding.surNameEd.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.surnameEnglish.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Applicant last name(" + this.binding.surnameEnglish.getText().toString() + ") should be in regional language.");
            this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.surnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.relativeName.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in english");
            return false;
        }
        if (this.binding.relativeNameEnglish.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in official language");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.relativeNameEnglish.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Relative first name(" + this.binding.relativeNameEnglish.getText().toString() + ") should be in regional language.");
            this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.surnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (!this.binding.relativeLastname.getText().toString().isEmpty() && this.binding.relativeLastnameEnglish.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative last name in official language");
            return false;
        }
        if (!this.binding.relativeLastnameEnglish.getText().toString().isEmpty() && !this.partLang.equals(this.english_code) && this.binding.relativeLastnameEnglish.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Relative last name(" + this.binding.relativeLastnameEnglish.getText().toString() + ") should be in regional language.");
            this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.surnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeLastnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.relationSpinner.getSelectedItem().toString().equals(this.relationmsg)) {
            showdialog(this.alert, "Please select Relation type");
            this.binding.firstnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.surnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeNameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.relativeLastnameEnglish.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            return false;
        }
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select Date of birth");
            return false;
        }
        if (date.after(date3)) {
            showdialog(this.alert, "Date of birth should be less than " + this.dobQualifyingDate);
            return false;
        }
        if (iCalculateage < 17) {
            showdialog(this.alert, "Age should be greater than or equal to 17 years");
            return false;
        }
        if (this.binding.placeOfBirthRG.getCheckedRadioButtonId() == 1) {
            showdialog(this.alert, "Please select place of birth");
            return false;
        }
        if (this.binding.indiaRb.isChecked() && this.binding.statePersonalSpinner.getSelectedItem().toString().equals(this.statemsg)) {
            showdialog(this.alert, "Please select state");
            return false;
        }
        if (this.binding.indiaRb.isChecked() && this.binding.districtPersonalSpinner.getSelectedItem().toString().equals(this.districtmsg)) {
            showdialog(this.alert, "Please select District");
            return false;
        }
        if (this.binding.indiaRb.isChecked() && this.binding.villagePersonalSpinner.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter birth village");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals(this.gendermsg)) {
            showdialog(this.alert, "Please select Gender");
            return false;
        }
        if (this.binding.outsideRb.isChecked() && this.binding.outsideIndiaSpinner.getSelectedItem().toString().equals(this.countrymsg)) {
            showdialog(this.alert, "Please select Country");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("MALE") && this.binding.relationSpinner.getSelectedItem().toString().equals("HUSBAND")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is male then relation type should not be husband. Please select correct relation type.");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("FEMALE") && this.binding.relationSpinner.getSelectedItem().toString().equals("WIFE")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is female then relation type should not be wife. Please select correct relation type.");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("THIRD GENDER") && !this.binding.relationSpinner.getSelectedItem().toString().equals("FATHER") && !this.binding.relationSpinner.getSelectedItem().toString().equals("MOTHER")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is third gender then relation type should be Father or Mother. Please select correct relation type.");
            return false;
        }
        if (this.binding.mobileNumEd.getText().toString().length() != 10 && !this.binding.mobileNumEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter correct Mobile number");
            return false;
        }
        if (!this.binding.mobileNumEd.getText().toString().isEmpty() && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
            showdialog(this.alert, "Please Enter Correct Mobile Number");
            return false;
        }
        if (!this.binding.emailEd.getText().toString().matches(RegexMatcher.EMAIL_REGEX) && !this.binding.emailEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter correct Email ID");
            return false;
        }
        if (this.binding.emailOtpLayout.getVisibility() == 0 && this.binding.otpEmailEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter otp received on email");
            return false;
        }
        if (this.binding.mobileOtpLayout.getVisibility() == 0 && this.binding.otpMobileEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter otp received on mobile");
            return false;
        }
        if (this.binding.photoNameTv2.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select file");
            return false;
        }
        if (iCalculateage == 17) {
            showdialog(this.alert, "Your form will be submitted but it will enroll after 18 years");
        }
        return true;
    }

    private int calculateage() {
        String str;
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        try {
            str = new SimpleDateFormat(this.yyFormat).format(simpleDateFormat.parse(this.binding.dobEd.getText().toString()));
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
            str = null;
        }
        LocalDate localDate = LocalDate.parse(str);
        LocalDate localDateNow = LocalDate.now();
        if (localDate == null || localDateNow == null) {
            return 0;
        }
        return Period.between(localDate, localDateNow).getYears();
    }

    public boolean residence() {
        this.binding.houseRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.streetRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.villageRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
        this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
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
        if (this.binding.postofficeEd.getText().toString().isEmpty()) {
            this.binding.postofficeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.postofficeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.pincodeEd.getText().toString().isEmpty() || this.binding.pincodeEd.getText().toString().length() != 6) {
            this.binding.pincodeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_red));
        } else {
            this.binding.pincodeEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.blo_black));
        }
        if (this.binding.houseNoEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter House number");
            return false;
        }
        if (this.binding.houseRegional.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter House number in regional language");
            return false;
        }
        if (this.binding.streetEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter Street");
            return false;
        }
        if (this.binding.streetRegional.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter Street in regional language");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.streetRegional.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Street(" + this.binding.streetRegional.getText().toString() + ") should be in regional");
            this.binding.houseRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.villageEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please Enter Village");
            return false;
        }
        if (this.binding.villageRegional.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter village in regional language");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.villageRegional.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Village(" + this.binding.villageRegional.getText().toString() + ") should be in regional");
            this.binding.houseRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.postofficeEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter postoffice");
            return false;
        }
        if (this.binding.postofficeOfficial.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter postoffice in regional");
            return false;
        }
        if (!this.partLang.equals(this.english_code) && this.binding.postofficeOfficial.getText().toString().matches(RegexMatcher.NAME_REGEX_CHECK)) {
            showdialog(this.alert, "Postoffice(" + this.binding.postofficeOfficial.getText().toString() + ") should be in regional");
            this.binding.houseRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_red));
            return false;
        }
        if (this.binding.pincodeEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter pincode");
            this.binding.houseRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.streetRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.villageRegional.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            this.binding.postofficeOfficial.setTextColor(ContextCompat.getColor(requireContext(), R.color.blo_black));
            return false;
        }
        if (this.binding.pincodeEd.getText().toString().length() != 6) {
            showdialog(this.alert, "Please enter correct pincode");
            return false;
        }
        if (this.binding.pincodeEd.getText().toString().length() != 6 || this.binding.pincodeEd.getText().toString().matches("^[1-9]{1}[0-9]{5}$")) {
            return true;
        }
        showdialog(this.alert, "Please enter correct pincode");
        return false;
    }

    public boolean ordinaryResidence() {
        if (this.binding.dateEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select date");
            return false;
        }
        if (!this.binding.other.isChecked() || !this.binding.descEd.getText().toString().isEmpty()) {
            return true;
        }
        showdialog(this.alert, "Please enter description");
        return false;
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda24
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$66(task);
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
    public /* synthetic */ void lambda$getCurrentLocation$66(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                this.binding.placeEd.setText(new Geocoder(getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0).getLocality());
            } catch (Exception e) {
                Logger.d("Content : ", e.getMessage());
            }
        }
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda117
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$67(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$67(Task task) {
        Toast.makeText(getContext(), "GPS is already turned on", 0).show();
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void insertData() {
        this.viewModel.insertData(this.referencenumber);
    }

    private void dataoneditbutton(String name, String date, String formtype) {
        this.viewModel.dataoneditbutton(name, date, formtype).observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda57
            public final void onChanged(Object obj) {
                this.f$0.lambda$dataoneditbutton$68((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dataoneditbutton$68(List list) {
        if (list.isEmpty()) {
            return;
        }
        String state = ((FormsinDraftOverseasModel) list.get(0)).getState();
        String personal = ((FormsinDraftOverseasModel) list.get(0)).getPersonal();
        String residence = ((FormsinDraftOverseasModel) list.get(0)).getResidence();
        String passport = ((FormsinDraftOverseasModel) list.get(0)).getPassport();
        String visa = ((FormsinDraftOverseasModel) list.get(0)).getVisa();
        String ordinary = ((FormsinDraftOverseasModel) list.get(0)).getOrdinary();
        String outside = ((FormsinDraftOverseasModel) list.get(0)).getOutside();
        String decalaration = ((FormsinDraftOverseasModel) list.get(0)).getDecalaration();
        int i = Integer.parseInt(((FormsinDraftOverseasModel) list.get(0)).getStepseq());
        this.referencenumber = ((FormsinDraftOverseasModel) list.get(0)).getReference();
        this.photoref = ((FormsinDraftOverseasModel) list.get(0)).getPhoto();
        String pdf = ((FormsinDraftOverseasModel) list.get(0)).getPdf();
        this.passref = pdf;
        edit(state, personal, residence, passport, visa, outside, i, this.photoref, pdf, ordinary, decalaration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v51 */
    private void edit(final String statedata, final String personaldata, final String residencedata, final String passportData, final String visaData, final String outsidedata, final int stepseq, String photo, final String pdf, final String ordinary, final String declaration) {
        ?? r1;
        ?? r11;
        ?? r10;
        if (stepseq == 2) {
            this.currentSelectedView = this.binding.residenceDetailsLayout;
            String[] strArrSplit = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit[0]);
            this.binding.districtSpinner.setText(strArrSplit[1]);
            this.binding.assemblyEd.setText(strArrSplit[3]);
            this.binding.noEd.setText(strArrSplit[2]);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda8
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$77(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str = this.personaldetails[15];
            this.isIndia = str;
            if (str.equalsIgnoreCase("Y")) {
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetails.setVisibility(8);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            this.binding.residenceDetails.setVisibility(0);
            this.binding.residenceDetailsLayout.setEnabled(true);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1200, this.binding.horizontal.getScrollY());
            return;
        }
        if (stepseq == 3) {
            this.currentSelectedView = this.binding.optionalDetailsLayout;
            String[] strArrSplit2 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit2[0]);
            this.binding.districtSpinner.setText(strArrSplit2[1]);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.assemblyEd.setText(strArrSplit2[3]);
            this.binding.noEd.setText(strArrSplit2[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$86(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str2 = this.personaldetails[15];
            this.isIndia = str2;
            if (str2.equalsIgnoreCase("Y")) {
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.residenceDetailsLayout.setEnabled(true);
            this.binding.optionalDetailsLayout.setEnabled(true);
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 1900, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[1]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(0);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            return;
        }
        if (stepseq == 4) {
            this.currentSelectedView = this.binding.familyDetailsLayout;
            String[] strArrSplit3 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit3[0]);
            this.binding.districtSpinner.setText(strArrSplit3[1]);
            this.binding.assemblyEd.setText(strArrSplit3[3]);
            this.binding.noEd.setText(strArrSplit3[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda10
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$96(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str3 = this.personaldetails[15];
            this.isIndia = str3;
            if (str3.equalsIgnoreCase("Y")) {
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetails.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.residenceDetailsLayout.setEnabled(true);
            this.binding.optionalDetailsLayout.setEnabled(true);
            this.binding.familyDetailsLayout.setEnabled(true);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 2600, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[1]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(8);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.passportDetails = passportData.split(this.delimeter);
            this.binding.passportEd.setText(this.passportDetails[0]);
            this.binding.placeIssueEd.setText(this.passportDetails[1]);
            this.binding.expiryDateEd.setText(this.passportDetails[3]);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
            this.binding.issueDateEd.setText(this.passportDetails[2]);
            this.binding.filename.setText(this.passportDetails[4]);
            this.binding.filesize.setText(this.passportDetails[5]);
            this.binding.visaDetails.setVisibility(0);
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            return;
        }
        if (stepseq == 5) {
            this.visaflag = 1;
            this.currentSelectedView = this.binding.ordinaryLayout;
            String[] strArrSplit4 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit4[0]);
            this.binding.districtSpinner.setText(strArrSplit4[1]);
            this.binding.assemblyEd.setText(strArrSplit4[3]);
            this.binding.noEd.setText(strArrSplit4[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda12
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$106(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str4 = this.personaldetails[15];
            this.isIndia = str4;
            if (str4.equalsIgnoreCase("Y")) {
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetails.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(true);
            this.binding.selectStateLayout.setEnabled(true);
            this.binding.personalDetailLayout.setEnabled(true);
            this.binding.residenceDetailsLayout.setEnabled(true);
            this.binding.optionalDetailsLayout.setEnabled(true);
            this.binding.familyDetailsLayout.setEnabled(true);
            this.binding.ordinaryLayout.setEnabled(true);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 2600, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[1]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(8);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.passportDetails = passportData.split(this.delimeter);
            this.binding.passportEd.setText(this.passportDetails[0]);
            this.binding.placeIssueEd.setText(this.passportDetails[1]);
            this.binding.expiryDateEd.setText(this.passportDetails[3]);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
            this.binding.issueDateEd.setText(this.passportDetails[2]);
            this.binding.filename.setText(this.passportDetails[4]);
            this.binding.filesize.setText(this.passportDetails[5]);
            this.binding.visaDetails.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(0);
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            String[] strArrSplit5 = visaData.split(this.delimeter);
            if (strArrSplit5.length > 0) {
                this.binding.visaNoEd.setText(strArrSplit5[0]);
                this.binding.visaTypeEd.setText(strArrSplit5[1]);
                this.binding.issueDateEdVisa.setText(strArrSplit5[3]);
                this.binding.expiryDateEdVisa.setText(strArrSplit5[4]);
                this.binding.authorityEd.setText(strArrSplit5[2]);
                return;
            }
            return;
        }
        if (stepseq == 6) {
            this.visaflag = 1;
            this.currentSelectedView = this.binding.outsideLayout;
            String[] strArrSplit6 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit6[0]);
            this.binding.districtSpinner.setText(strArrSplit6[1]);
            this.binding.assemblyEd.setText(strArrSplit6[3]);
            this.binding.noEd.setText(strArrSplit6[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda13
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$116(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str5 = this.personaldetails[15];
            this.isIndia = str5;
            if (str5.equalsIgnoreCase("Y")) {
                r10 = 1;
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                r10 = 1;
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetails.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(r10);
            this.binding.selectStateLayout.setEnabled(r10);
            this.binding.personalDetailLayout.setEnabled(r10);
            this.binding.residenceDetailsLayout.setEnabled(r10);
            this.binding.optionalDetailsLayout.setEnabled(r10);
            this.binding.familyDetailsLayout.setEnabled(r10);
            this.binding.outsideLayout.setEnabled(r10);
            this.binding.ordinaryLayout.setEnabled(r10);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 4000, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[r10]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(8);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.passportDetails = passportData.split(this.delimeter);
            this.binding.passportEd.setText(this.passportDetails[0]);
            this.binding.placeIssueEd.setText(this.passportDetails[r10]);
            this.binding.expiryDateEd.setText(this.passportDetails[3]);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
            this.binding.issueDateEd.setText(this.passportDetails[2]);
            this.binding.filename.setText(this.passportDetails[4]);
            this.binding.filesize.setText(this.passportDetails[5]);
            this.binding.visaDetails.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.outsideDetails.setVisibility(0);
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit7 = visaData.split(this.delimeter);
            if (strArrSplit7.length > 0) {
                this.binding.visaNoEd.setText(strArrSplit7[0]);
                this.binding.visaTypeEd.setText(strArrSplit7[r10]);
                this.binding.issueDateEdVisa.setText(strArrSplit7[3]);
                this.binding.expiryDateEdVisa.setText(strArrSplit7[4]);
                this.binding.authorityEd.setText(strArrSplit7[2]);
            }
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            String[] strArrSplit8 = ordinary.split(this.delimeter);
            if (strArrSplit8[0].equals(this.employment)) {
                this.binding.employment.setChecked(r10);
            } else if (strArrSplit8[0].equals(this.education)) {
                this.binding.education.setChecked(r10);
            } else if (strArrSplit8[0].equals(this.other)) {
                this.binding.other.setChecked(r10);
                this.binding.descEd.setVisibility(0);
                this.binding.descEd.setText(strArrSplit8[2]);
            }
            this.binding.dateEd.setText(strArrSplit8[r10]);
            return;
        }
        if (stepseq == 7) {
            this.visaflag = 1;
            this.currentSelectedView = this.binding.declarationLayout;
            String[] strArrSplit9 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit9[0]);
            this.binding.districtSpinner.setText(strArrSplit9[1]);
            this.binding.assemblyEd.setText(strArrSplit9[3]);
            this.binding.noEd.setText(strArrSplit9[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda14
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$126(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str6 = this.personaldetails[15];
            this.isIndia = str6;
            if (str6.equalsIgnoreCase("Y")) {
                r11 = 1;
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                r11 = 1;
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetails.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(r11);
            this.binding.selectStateLayout.setEnabled(r11);
            this.binding.personalDetailLayout.setEnabled(r11);
            this.binding.residenceDetailsLayout.setEnabled(r11);
            this.binding.optionalDetailsLayout.setEnabled(r11);
            this.binding.familyDetailsLayout.setEnabled(r11);
            this.binding.outsideLayout.setEnabled(r11);
            this.binding.ordinaryLayout.setEnabled(r11);
            this.binding.declarationLayout.setEnabled(r11);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 4000, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[r11]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(8);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.passportDetails = passportData.split(this.delimeter);
            this.binding.passportEd.setText(this.passportDetails[0]);
            this.binding.placeIssueEd.setText(this.passportDetails[r11]);
            this.binding.expiryDateEd.setText(this.passportDetails[3]);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
            this.binding.issueDateEd.setText(this.passportDetails[2]);
            this.binding.filename.setText(this.passportDetails[4]);
            this.binding.filesize.setText(this.passportDetails[5]);
            this.binding.visaDetails.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.outsideDetails.setVisibility(8);
            this.binding.decleration.setVisibility(0);
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit10 = visaData.split(this.delimeter);
            if (strArrSplit10.length > 0) {
                this.binding.visaNoEd.setText(strArrSplit10[0]);
                this.binding.visaTypeEd.setText(strArrSplit10[r11]);
                this.binding.issueDateEdVisa.setText(strArrSplit10[3]);
                this.binding.expiryDateEdVisa.setText(strArrSplit10[4]);
                this.binding.authorityEd.setText(strArrSplit10[2]);
            }
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            String[] strArrSplit11 = ordinary.split(this.delimeter);
            if (strArrSplit11[0].equals(this.employment)) {
                this.binding.employment.setChecked(r11);
            } else if (strArrSplit11[0].equals(this.education)) {
                this.binding.education.setChecked(r11);
            } else if (strArrSplit11[0].equals(this.other)) {
                this.binding.other.setChecked(r11);
                this.binding.descEd.setVisibility(0);
                this.binding.descEd.setText(strArrSplit11[2]);
            }
            this.binding.dateEd.setText(strArrSplit11[r11]);
            this.outsidedetails = outsidedata.split(this.delimeter);
            this.binding.houseNoEd2.setText(this.outsidedetails[0]);
            this.binding.streetEd2.setText(this.outsidedetails[r11]);
            this.binding.stateOutsideSpinner.setText(this.outsidedetails[3]);
            this.binding.villageSpinner1.setText(this.outsidedetails[2]);
            this.binding.zipEd.setText(this.outsidedetails[5]);
            this.binding.dateEdDecleration.setText(this.submitdate);
            return;
        }
        if (stepseq == 8) {
            this.visaflag = 1;
            this.currentSelectedView = this.binding.declarationLayout;
            String[] strArrSplit12 = statedata.split(this.delimeter);
            this.binding.stateSpinner.setText(strArrSplit12[0]);
            this.binding.districtSpinner.setText(strArrSplit12[1]);
            this.binding.assemblyEd.setText(strArrSplit12[3]);
            this.binding.noEd.setText(strArrSplit12[2]);
            this.binding.overseasVoter.setVisibility(8);
            this.binding.resetTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.resetTv.setEnabled(true);
            this.binding.selectStateLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.personaldetails = personaldata.split(this.delimeter);
            this.binding.firstNameEd.setText(this.personaldetails[0]);
            this.binding.surNameEd.setText(this.personaldetails[1]);
            this.binding.firstnameEnglish.setText(this.personaldetails[2]);
            this.binding.surnameEnglish.setText(this.personaldetails[3]);
            this.binding.photoNameTv2.setText(this.personaldetails[4]);
            this.binding.photoSize.setText(this.personaldetails[5]);
            this.binding.photoNameTv2.setVisibility(0);
            this.binding.photoSize.setVisibility(0);
            this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda15
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$edit$136(statedata, personaldata, residencedata, passportData, visaData, outsidedata, stepseq, pdf, ordinary, declaration, i, arrayList, arrayList2);
                }
            });
            this.binding.relativeName.setText(this.personaldetails[7]);
            this.binding.relativeLastname.setText(this.personaldetails[8]);
            this.binding.relativeLastnameEnglish.setText(this.personaldetails[10]);
            this.binding.relativeNameEnglish.setText(this.personaldetails[9]);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
            this.binding.mobileNumEd.setText(this.personaldetails[11]);
            this.binding.emailEd.setText(this.personaldetails[12]);
            this.binding.dobEd.setText(this.personaldetails[14]);
            String str7 = this.personaldetails[15];
            this.isIndia = str7;
            if (str7.equalsIgnoreCase("Y")) {
                r1 = 1;
                this.binding.indiaRb.setChecked(true);
                this.statepos = Integer.parseInt(this.personaldetails[16]);
                this.binding.villagePersonalSpinner.setText(this.personaldetails[18]);
                this.binding.statePersonalSpinner.setSelection(this.statepos);
                this.districtpos = Integer.parseInt(this.personaldetails[17]);
                this.binding.districtPersonalSpinner.setSelection(this.districtpos);
            } else {
                r1 = 1;
                this.binding.outsideRb.setChecked(true);
                this.binding.outsideIndiaSpinner.setSelection(this.countrycode.indexOf(this.outsidePlaceofBirth));
            }
            this.binding.personalDetailLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.residenceDetails.setVisibility(8);
            this.binding.previousTv.setTextColor(Color.parseColor(this.bluecolor));
            this.binding.previousTv.setEnabled(r1);
            this.binding.selectStateLayout.setEnabled(r1);
            this.binding.personalDetailLayout.setEnabled(r1);
            this.binding.residenceDetailsLayout.setEnabled(r1);
            this.binding.optionalDetailsLayout.setEnabled(r1);
            this.binding.familyDetailsLayout.setEnabled(r1);
            this.binding.outsideLayout.setEnabled(r1);
            this.binding.ordinaryLayout.setEnabled(r1);
            this.binding.declarationLayout.setEnabled(r1);
            this.binding.horizontal.scrollTo(this.binding.horizontal.getScrollX() + 4000, this.binding.horizontal.getScrollY());
            this.residenceDetails = residencedata.split(this.delimeter);
            this.residenceDetails = residencedata.split(this.delimeter);
            this.binding.houseNoEd.setText(this.residenceDetails[0]);
            this.binding.houseRegional.setText(this.residenceDetails[r1]);
            this.binding.streetEd.setText(this.residenceDetails[2]);
            this.binding.streetRegional.setText(this.residenceDetails[3]);
            this.binding.villageEd.setText(this.residenceDetails[4]);
            this.binding.villageRegional.setText(this.residenceDetails[5]);
            this.binding.postofficeEd.setText(this.residenceDetails[8]);
            this.binding.postofficeOfficial.setText(this.residenceDetails[9]);
            this.binding.pincodeEd.setText(this.residenceDetails[7]);
            this.binding.passportDetails.setVisibility(8);
            this.binding.optionalDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.passportDetails = passportData.split(this.delimeter);
            this.binding.passportEd.setText(this.passportDetails[0]);
            this.binding.placeIssueEd.setText(this.passportDetails[r1]);
            this.binding.expiryDateEd.setText(this.passportDetails[3]);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
            this.binding.issueDateEd.setText(this.passportDetails[2]);
            this.binding.filename.setText(this.passportDetails[4]);
            this.binding.filesize.setText(this.passportDetails[5]);
            this.binding.visaDetails.setVisibility(8);
            this.binding.ordinaryResidenceLayout.setVisibility(8);
            this.binding.outsideDetails.setVisibility(8);
            this.binding.decleration.setVisibility(0);
            this.binding.familyDetailsLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.ordinaryLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            String[] strArrSplit13 = visaData.split(this.delimeter);
            if (strArrSplit13.length > 0) {
                this.binding.visaNoEd.setText(strArrSplit13[0]);
                this.binding.visaTypeEd.setText(strArrSplit13[r1]);
                this.binding.issueDateEdVisa.setText(strArrSplit13[3]);
                this.binding.expiryDateEdVisa.setText(strArrSplit13[4]);
                this.binding.authorityEd.setText(strArrSplit13[2]);
            }
            this.binding.outsideLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_select_state));
            this.binding.declarationLayout.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_selected_personal));
            String[] strArrSplit14 = ordinary.split(this.delimeter);
            if (strArrSplit14[0].equals(this.employment)) {
                this.binding.employment.setChecked(r1);
            } else if (strArrSplit14[0].equals(this.education)) {
                this.binding.education.setChecked(r1);
            } else if (strArrSplit14[0].equals(this.other)) {
                this.binding.other.setChecked(r1);
                this.binding.descEd.setVisibility(0);
                this.binding.descEd.setText(strArrSplit14[2]);
            }
            this.binding.dateEd.setText(strArrSplit14[r1]);
            this.outsidedetails = outsidedata.split(this.delimeter);
            this.binding.houseNoEd2.setText(this.outsidedetails[0]);
            this.binding.streetEd2.setText(this.outsidedetails[r1]);
            this.binding.stateOutsideSpinner.setText(this.outsidedetails[3]);
            this.binding.villageSpinner1.setText(this.outsidedetails[2]);
            this.binding.zipEd.setText(this.outsidedetails[5]);
            this.binding.dateEdDecleration.setText(this.submitdate);
            String[] strArrSplit15 = declaration.split(this.delimeter);
            if (strArrSplit15[3].equals("Not Name")) {
                this.binding.notname.setChecked(r1);
                return;
            }
            this.binding.name.setChecked(r1);
            this.binding.addressEd.setText(strArrSplit15[0]);
            this.binding.epicNoEd.setText(strArrSplit15[r1]);
            this.binding.dateIssueEd.setText(strArrSplit15[2]);
            this.binding.dateEdDecleration.setText(this.submitdate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$77(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda39
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$70(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda40
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$71(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda41
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$72(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda42
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$74(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda43
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$75(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda45
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$76(i3, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$70(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda112
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$69(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$69(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$71(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$72(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$74(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda89
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$73(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$73(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$75(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(0));
        this.districtposinac = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$76(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(0);
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$86(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda107
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$79(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda118
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$80(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda129
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$81(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda140
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$83(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda151
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$84(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$85(i3, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$79(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda32
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$78(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$78(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$80(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$81(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$83(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda80
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$82(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$82(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$84(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$85(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(0);
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$96(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda47
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$88(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda48
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$89(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda49
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$90(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda50
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$92(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda51
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$93(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda52
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$94(i3, arrayList3, arrayList4);
            }
        });
        if (this.passportDetails[4].contains(".pdf")) {
            this.binding.preview.setVisibility(0);
            this.binding.delete.setVisibility(0);
            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
            return;
        }
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda53
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i3, String str10) {
                this.f$0.lambda$edit$95(i3, str10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$88(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda116
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$87(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$87(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$89(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$90(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$92(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda26
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$91(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$91(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$93(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$94(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(0);
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$95(int i, String str) {
        this.binding.preview.setVisibility(0);
        this.binding.delete.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$106(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda62
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$98(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda64
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$99(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda65
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$100(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda66
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$102(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda67
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$103(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda68
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$104(i3, arrayList3, arrayList4);
            }
        });
        if (this.passportDetails[4].contains(".pdf")) {
            this.binding.preview.setVisibility(0);
            this.binding.delete.setVisibility(0);
            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
            return;
        }
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda69
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i3, String str10) {
                this.f$0.lambda$edit$105(i3, str10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$98(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda75
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$97(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$97(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$99(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$100(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$102(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda119
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$101(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$101(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$103(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$104(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(0);
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$105(int i, String str) {
        this.binding.preview.setVisibility(0);
        this.binding.delete.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$116(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda93
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$108(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda94
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$109(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda95
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$110(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda97
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$112(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda98
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$113(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda99
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$114(i3, arrayList3, arrayList4);
            }
        });
        if (this.passportDetails[4].contains(".pdf")) {
            this.binding.preview.setVisibility(0);
            this.binding.delete.setVisibility(0);
            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
            return;
        }
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda100
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i3, String str10) {
                this.f$0.lambda$edit$115(i3, str10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$108(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda63
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$107(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$107(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$109(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$110(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$112(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda5
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$111(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$111(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$113(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$114(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(0);
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$115(int i, String str) {
        this.binding.preview.setVisibility(0);
        this.binding.delete.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$126(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda101
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$118(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda102
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$119(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda103
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$120(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda104
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$122(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda105
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$123(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda106
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$124(i3, arrayList3, arrayList4);
            }
        });
        if (this.passportDetails[4].contains(".pdf")) {
            this.binding.preview.setVisibility(0);
            this.binding.delete.setVisibility(0);
            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
            return;
        }
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda108
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i3, String str10) {
                this.f$0.lambda$edit$125(i3, str10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$118(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda111
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$117(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$117(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$119(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$120(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$122(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda114
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$121(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$121(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$123(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$124(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(Integer.parseInt(this.outsidedetails[4]));
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$125(int i, String str) {
        this.binding.preview.setVisibility(0);
        this.binding.delete.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$136(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i, final String str7, final String str8, final String str9, int i2, ArrayList arrayList, ArrayList arrayList2) {
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda81
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str10, String str11) {
                    this.f$0.lambda$edit$128(str, str2, str3, str4, str5, str6, i, str7, str8, str9, i3, str10, str11);
                }
            });
            return;
        }
        this.relation = arrayList;
        this.relationcode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.relation);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(Integer.parseInt(this.personaldetails[6]));
        this.relationpos = this.binding.relationSpinner.getSelectedItemPosition();
        if (this.personaldetails[4].contains(".pdf")) {
            this.binding.cancel.setVisibility(0);
            this.binding.image.setVisibility(0);
            this.binding.image.setImageResource(R.drawable.blo_pfd_thumbnail);
        } else {
            try {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.photoref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda82
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str10) {
                        this.f$0.lambda$edit$129(i3, str10);
                    }
                });
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        }
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda83
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$130(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getState(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda84
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$132(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda86
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$133(i3, arrayList3, arrayList4);
            }
        });
        this.commonUtilClass.getCountry(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda87
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i3, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$134(i3, arrayList3, arrayList4);
            }
        });
        if (this.passportDetails[4].contains(".pdf")) {
            this.binding.preview.setVisibility(0);
            this.binding.delete.setVisibility(0);
            this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
            return;
        }
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.passref, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda88
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i3, String str10) {
                this.f$0.lambda$edit$135(i3, str10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$128(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, String str11) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i2 + " " + str10 + " " + str11);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda31
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$edit$127(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str10;
        this.refreshToken = str11;
        SharedPref.getInstance(requireContext()).setRefreshToken(str11);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str10);
        edit(str, str2, str3, str4, str5, str6, i, this.photoref, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$127(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$129(int i, String str) {
        this.binding.cancel.setVisibility(0);
        this.binding.image.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$130(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.gender = arrayList;
        this.gendercode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.gender);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[13]));
        this.genderpos = this.binding.genderPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$132(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.stateList = arrayList;
        this.statecode1 = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.stateList);
        this.stateadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.statePersonalSpinner.setAdapter((SpinnerAdapter) this.stateadapter);
        this.binding.statePersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[16]));
        this.commonUtilClass.getDistrict(this.statecode1.get(Integer.parseInt(this.personaldetails[16])), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda54
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList3, ArrayList arrayList4) {
                this.f$0.lambda$edit$131(i2, arrayList3, arrayList4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$131(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.districtPersonalSpinner.setAdapter((SpinnerAdapter) this.districtadapter);
        this.binding.districtPersonalSpinner.setSelection(Integer.parseInt(this.personaldetails[17]));
        this.districtpos = this.binding.districtPersonalSpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$133(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.setText(this.adapterdistrict.getItem(Integer.parseInt(this.residenceDetails[6])));
        this.districtposinac = Integer.parseInt(this.residenceDetails[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$134(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.country = arrayList;
        this.countrycode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, this.country);
        this.countryadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countryadapter.remove(this.india);
        this.binding.countrySpinner.setAdapter((SpinnerAdapter) this.countryadapter);
        this.binding.countrySpinner.setSelection(Integer.parseInt(this.outsidedetails[4]));
        this.countrypos = this.binding.countrySpinner.getSelectedItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$edit$135(int i, String str) {
        this.binding.preview.setVisibility(0);
        this.binding.delete.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.preview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public void createcsv() {
        String str;
        String str2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.yyFormat);
        if (this.binding.name.isChecked()) {
            str = "M_IN";
        } else {
            str = "N_IN";
        }
        if (this.reasonabsenting.equals(this.education)) {
            str2 = "EDU";
        } else if (this.reasonabsenting.equals(this.employment)) {
            str2 = "EMPL";
        } else {
            str2 = this.reasonabsenting.equals(this.other) ? "OTHR" : null;
        }
        final HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("residingInIndia", "N");
            map.put("stateCd", this.stateCode);
            if (!this.districtCode1.isEmpty()) {
                map.put("districtCd", this.districtCode1);
            } else {
                map.put("districtCd", null);
            }
            map.put("asmblyConstituencyNo", this.asmblyNO);
            map.put(Constants.FIRST_NAME, this.binding.firstNameEd.getText().toString().trim().replaceAll(" +", " "));
            if (this.binding.surNameEd.getText().toString().isEmpty()) {
                map.put(this.lastNameText, null);
            } else {
                map.put(this.lastNameText, this.binding.surNameEd.getText().toString().trim().replaceAll(" +", " "));
            }
            map.put("applicantRelativeName", this.binding.relativeName.getText().toString().trim());
            if (this.binding.relativeLastname.getText().toString().isEmpty()) {
                map.put(this.applicantRelativeSurname, null);
            } else {
                map.put(this.applicantRelativeSurname, this.binding.relativeLastname.getText().toString().trim().replaceAll(" +", " "));
            }
            map.put(this.typeOfRelation, this.relationcode1.get(this.relationpos));
            map.put("firstNameL1", this.binding.firstnameEnglish.getText().toString().trim().replaceAll(" +", " "));
            map.put("firstNameL2", null);
            if (this.binding.surnameEnglish.getText().toString().isEmpty()) {
                map.put(this.lastNameL1, null);
            } else {
                map.put(this.lastNameL1, this.binding.surnameEnglish.getText().toString().trim().replaceAll(" +", " "));
            }
            map.put("lastNameL2", null);
            map.put("applicantRelativeNameL1", this.binding.relativeNameEnglish.getText().toString().trim().replaceAll(" +", " "));
            map.put("applicantRelativeNameL2", null);
            if (this.binding.relativeLastnameEnglish.getText().toString().isEmpty()) {
                map.put(this.applicantRelativesurnameL1, null);
            } else {
                map.put(this.applicantRelativesurnameL1, this.binding.relativeLastnameEnglish.getText().toString().trim().replaceAll(" +", " "));
            }
            map.put("applicantRelativeSurnameL2", null);
            map.put("dob", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dobEd.getText().toString())));
            map.put("isIndia", this.isIndia);
            if (this.isIndia.equalsIgnoreCase("Y")) {
                map.put(this.birthDistrictCd, this.districtcode.get(this.districtpos));
                if (this.binding.villagePersonalSpinner.getText().toString().isEmpty()) {
                    map.put(this.birthTown, null);
                } else {
                    map.put(this.birthTown, this.binding.villagePersonalSpinner.getText().toString().trim().replaceAll(" +", " "));
                }
                map.put("birthStateCd", this.statecode1.get(this.statepos));
            } else {
                map.put("placeOfBirthOutsideIndia", this.outsidePlaceofBirth);
            }
            map.put(this.applicantGender, this.gendercode.get(this.genderpos));
            if (this.binding.emailEd.getText().toString().isEmpty()) {
                map.put(this.emailText, null);
            } else {
                map.put(this.emailText, this.binding.emailEd.getText().toString().trim().replaceAll(" +", " "));
            }
            if (!this.binding.mobileNumEd.getText().toString().isEmpty()) {
                map.put(this.mobileNumberText, this.binding.mobileNumEd.getText().toString().trim().replaceAll(" +", " "));
            } else {
                map.put(this.mobileNumberText, null);
            }
            map.put("dateFromWhichAbsentOnOrdinaryResidence", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dateEd.getText().toString())));
            map.put("formSubmissionPlace", this.binding.placeEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("applicantDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dateEdDecleration.getText().toString())));
            map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.dateEdDecleration.getText().toString())));
            map.put("formSubmissionChannel", "GARUDA");
            map.put("formSubmissionMode", "ONLINE");
            map.put("oriState", this.stateCode);
            map.put("oriDistrict", this.districtcodeac.get(this.districtposinac));
            map.put("oriHouseNumber", this.binding.houseNoEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("localityStreet", this.binding.streetEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriVillageTown", this.binding.villageEd.getText().toString().trim().replaceAll(" +", " "));
            map.put(this.oriPostOffice, this.binding.postofficeEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriHouseNumberL1", this.binding.houseRegional.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriHouseNumberL2", null);
            map.put("oriLocalityL1", this.binding.streetRegional.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriLocalityL2", null);
            map.put("oriVillageTownL1", this.binding.villageRegional.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriVillageTownL2", null);
            map.put(this.oriPostOfficeL1, this.binding.postofficeOfficial.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriPostOfficeL2", null);
            map.put("oriPinCode", this.binding.pincodeEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("oriCountryCd", "IN");
            map.put(this.crosiState, this.binding.stateOutsideSpinner.getText().toString().trim().replaceAll(" +", " "));
            map.put("crosiDistrict", null);
            map.put("crosiHouseNumber", this.binding.houseNoEd2.getText().toString().trim().replaceAll(" +", " "));
            map.put("crosiLocalityStreet", this.binding.streetEd2.getText().toString().trim().replaceAll(" +", " "));
            map.put("crosiVillageTown", this.binding.villageSpinner1.getText().toString().trim().replaceAll(" +", " "));
            map.put("crosiPostOffice", null);
            map.put("crosiHouseNumberL1", "");
            map.put("crosiHouseNumberL2", null);
            map.put("crosiLocalityL1", "");
            map.put("crosiLocalityL2", null);
            map.put("crosiVillageTownL1", "");
            map.put("crosiVillageTownL2", null);
            map.put("crosiPostOfficeL1", null);
            map.put("crosiPostOfficeL2", null);
            map.put("crosiZipCode", this.binding.zipEd.getText().toString().trim().replaceAll(" +", " "));
            map.put("crosiCountryCd", this.countrycode.get(this.countrypos));
            map.put("passportNumber", this.binding.passportEd.getText().toString().trim().replaceAll(" +", " "));
            if (this.binding.placeIssueEd.getText().toString().isEmpty()) {
                map.put(this.placeOfPassportIssue, null);
            } else {
                map.put(this.placeOfPassportIssue, this.binding.placeIssueEd.getText().toString().trim().replaceAll(" +", " "));
            }
            map.put("dateOfPassportIssue", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.issueDateEd.getText().toString())));
            map.put("passportExpiry", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.expiryDateEd.getText().toString())));
            if (this.binding.visaNoEd.getText().toString().isEmpty()) {
                map.put(this.visaNumber, null);
            } else {
                map.put(this.visaNumber, this.binding.visaNoEd.getText().toString().trim().replaceAll(" +", " "));
            }
            if (this.binding.visaTypeEd.getText().toString().isEmpty()) {
                map.put(this.typeOfVisa, null);
            } else {
                map.put(this.typeOfVisa, this.binding.visaTypeEd.getText().toString().trim().replaceAll(" +", " "));
            }
            if (this.binding.issueDateEdVisa.getText().toString().isEmpty()) {
                map.put(this.dateOfVisaIssue, null);
            } else {
                map.put(this.dateOfVisaIssue, simpleDateFormat2.format(simpleDateFormat.parse(this.binding.issueDateEdVisa.getText().toString())));
            }
            if (this.binding.expiryDateEdVisa.getText().toString().isEmpty()) {
                map.put(this.dateOfVisaExpiry, null);
            } else {
                map.put(this.dateOfVisaExpiry, simpleDateFormat2.format(simpleDateFormat.parse(this.binding.expiryDateEdVisa.getText().toString())));
            }
            if (this.binding.name.isChecked()) {
                if (this.binding.addressEd.getText().toString().isEmpty()) {
                    map.put(this.declFullAddress, null);
                } else {
                    map.put(this.declFullAddress, this.binding.addressEd.getText().toString().trim().replaceAll(" +", " "));
                }
                if (this.binding.constOutsideSpinnerDec.getSelectedItem().toString().equals("Select Constituency")) {
                    map.put(this.declConstituency, 0);
                } else {
                    map.put(this.declConstituency, this.constcode.get(this.constdec));
                }
                if (this.binding.stateOutsideSpinnerDec.getSelectedItem().toString().equals(this.statemsg)) {
                    map.put(this.declState, null);
                } else {
                    map.put(this.declState, this.statecode1.get(this.statedec));
                }
            } else {
                map.put(this.declConstituency, 0);
                map.put(this.declFullAddress, null);
                map.put(this.declState, null);
            }
            map.put("form6aId", null);
            map.put(this.reasonOfAbsence, str2);
            map.put("reasonOfAbsenceOthersDesc", this.binding.descEd.getText().toString().trim().replaceAll(" +", " "));
            map.put(this.visaIssuingAuthority, this.binding.authorityEd.getText().toString().isEmpty() ? null : this.binding.authorityEd.getText().toString().trim().replaceAll(" +", " "));
            map.put(this.declareApplCode, str);
            map.put("prevEpicIssueDate", null);
            map.put("prevEpicNo", null);
            map.put("isDraft", "N");
            map.put("createdBy", "operator");
            map.put("formRefNumber", this.referencenumber);
            if (this.photoref.equals(" ")) {
                showdialog(this.alert, "Error in profile picture.Please upload profile picture again.");
                return;
            }
            map.put(this.photograph, this.photoref);
            if (this.passref.equals(" ")) {
                showdialog(this.alert, "Error in passport document.Please upload passport document again.");
                return;
            }
            map.put("passport", this.passref);
            map.put("isReinitiated", "N");
            map.put("id", 0);
            map.put("partNumber", this.partNo);
            map.put("sectionNo", 0);
            this.commonUtilClass.submitform6A(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), map, getContext(), new FormsResponse() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda92
                @Override // in.gov.eci.bloapp.views.fragments.FormsResponse
                public final void onCallback(int i, String str3) {
                    this.f$0.lambda$createcsv$140(map, i, str3);
                }
            });
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createcsv$140(final HashMap map, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda122
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$createcsv$139(map, i2, str2, str3);
                }
            });
        } else if (i == 200) {
            Logger.d("response form6A :", map.toString());
            showdialog1("Success", str + "\nReference Number : " + this.referencenumber);
        } else {
            showdialog2(String.valueOf(i), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createcsv$139(final HashMap map, int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda17
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createcsv$137(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.submitform6A(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), map, getContext(), new FormsResponse() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda18
            @Override // in.gov.eci.bloapp.views.fragments.FormsResponse
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$createcsv$138(map, i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createcsv$137(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createcsv$138(HashMap map, int i, String str) {
        if (i == 200) {
            Logger.d("response form6A :", map.toString());
            showdialog1("Success", str + "\nReference Number : " + this.referencenumber);
        } else {
            showdialog2(String.valueOf(i), str);
        }
    }

    private void showdialog2(String success, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda58
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$141(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$141(DialogInterface dialogInterface, int i) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void reset() {
        if (this.currentSelectedView == this.binding.personalDetailLayout) {
            this.binding.firstNameEd.setText("");
            this.binding.firstnameEnglish.setText("");
            this.binding.surNameEd.setText("");
            this.binding.surnameEnglish.setText("");
            this.binding.relativeName.setText("");
            this.binding.relativeNameEnglish.setText("");
            this.binding.relativeLastname.setText("");
            this.binding.relativeLastnameEnglish.setText("");
            this.binding.relationSpinner.setSelection(0);
            this.binding.placeOfBirthRG.setSelected(false);
            this.binding.indiaRb.setChecked(false);
            this.binding.outsideRb.setChecked(false);
            this.binding.outsideIndiaSpinner.setSelection(0);
            this.binding.indiaLayout.setVisibility(8);
            this.binding.outsideIndiaLayout.setVisibility(8);
            this.binding.dobEd.setText("");
            this.binding.statePersonalSpinner.setSelection(0);
            this.binding.districtPersonalSpinner.setSelection(0);
            this.binding.villagePersonalSpinner.setText("");
            this.binding.genderPersonalSpinner.setSelection(0);
            this.binding.emailEd.setText("");
            this.binding.mobileNumEd.setText("");
            this.photoref = "";
            this.binding.image.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
            this.binding.photoNameTv2.setText("");
            this.binding.photoSize.setText("");
            this.binding.cancel.setVisibility(8);
            return;
        }
        if (this.currentSelectedView == this.binding.residenceDetailsLayout) {
            this.binding.houseRegional.setText("");
            this.binding.houseNoEd.setText("");
            this.binding.streetEd.setText("");
            this.binding.streetRegional.setText("");
            this.binding.villageEd.setText("");
            this.binding.villageRegional.setText("");
            this.binding.districtSpinner1.setText("");
            this.binding.postofficeOfficial.setText("");
            this.binding.postofficeEd.setText("");
            this.binding.pincodeEd.setText("");
            return;
        }
        if (this.currentSelectedView == this.binding.optionalDetailsLayout) {
            this.binding.placeIssueEd.setText("");
            this.binding.passportEd.setText("");
            this.binding.issueDateEd.setText("");
            this.binding.expiryDateEd.setText("");
            this.binding.filesize.setText("");
            this.binding.filename.setText("");
            this.passref = "";
            this.binding.filesize.setVisibility(8);
            this.binding.filename.setVisibility(8);
            this.binding.delete.setVisibility(8);
            this.binding.preview.setVisibility(8);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFile.setEnabled(true);
            return;
        }
        if (this.currentSelectedView == this.binding.familyDetailsLayout) {
            this.binding.visaNoEd.setText("");
            this.binding.issueDateEdVisa.setText("");
            this.binding.expiryDateEdVisa.setText("");
            this.binding.visaTypeEd.setText("");
            this.binding.authorityEd.setText("");
            return;
        }
        if (this.binding.ordinaryLayout == this.currentSelectedView) {
            this.binding.employment.setChecked(false);
            this.binding.education.setChecked(false);
            this.binding.other.setChecked(false);
            this.binding.radioParent.clearCheck();
            this.binding.descEd.setText("");
            this.binding.dateEd.setText("");
            return;
        }
        if (this.binding.outsideLayout == this.currentSelectedView) {
            this.binding.houseNoEd2.setText("");
            this.binding.streetEd2.setText("");
            this.binding.villageSpinner1.setText("");
            this.binding.stateOutsideSpinner.setSelection(0);
            this.binding.countrySpinner.setSelection(0);
            this.binding.zipEd.setText("");
            return;
        }
        if (this.binding.declarationLayout == this.currentSelectedView) {
            this.binding.radioParentDecleration.clearCheck();
            this.binding.stateOutsideSpinnerDec.setSelection(0);
            this.binding.districtOutsideSpinnerDec.setSelection(0);
            this.binding.constOutsideSpinnerDec.setSelection(0);
            this.binding.addressEd.setText("");
            this.binding.epicNoEd.setText("");
            this.binding.dateIssueEd.setText("");
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$35] */
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
                    Logger.d("", e.getMessage());
                    inputStreamOpenRawResource.close();
                    stringWriter.flush();
                    stringWriter.close();
                }
                List list = (List) new GsonBuilder().create().fromJson(stringWriter.toString(), new TypeToken<ArrayList<TState>>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter.35
                }.getType());
                DBClient.getInstance(requireContext()).getAppDatabase().masterDAO().insertStates((TState[]) list.toArray(new TState[list.size()]));
            } catch (Throwable th3) {
                try {
                    inputStreamOpenRawResource.close();
                    stringWriter.flush();
                    stringWriter.close();
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
                }
                throw th3;
            }
        } catch (Exception e3) {
            Logger.d("", e3.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r38v0, types: [in.gov.eci.bloapp.views.fragments.BaseFragment, in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter] */
    public void onActivityResult(int i, int i2, Intent intent) {
        ?? r22;
        String str;
        String str2;
        ?? r23;
        ?? r14;
        ?? contentResolver;
        ?? r24;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            this.alertDialog.dismiss();
        }
        String str3 = "MB";
        ?? r15 = "KB";
        String str4 = "Image size exceeded 2MB limit.";
        if (i != 101 || i2 != -1) {
            r22 = "/";
            str = "MB";
            str2 = "KB";
            r23 = "Image size exceeded 2MB limit.";
            str3 = "";
            str4 = "image";
            r14 = 100;
        } else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image");
                contentResolver = getContext().getContentResolver();
                str2 = null;
                str = null;
                r24 = saveImagePath;
                Cursor cursorQuery = contentResolver.query(r24, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.msg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    contentResolver = "/";
                    try {
                        if (this.filesize < 1024) {
                            this.binding.cancel.setVisibility(0);
                            this.binding.photoSize.setVisibility(0);
                            this.binding.photoNameTv2.setVisibility(0);
                            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.photoSize.setText(this.filesize + "KB");
                            this.binding.image.setVisibility(0);
                            ImageView imageView = this.binding.image;
                            byte[] bArr = this.byteArray;
                            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                        } else if (this.filesize > 2048) {
                            this.binding.image.setVisibility(8);
                            this.binding.cancel.setVisibility(8);
                            this.binding.photoSize.setVisibility(8);
                            this.binding.photoNameTv2.setVisibility(8);
                            showdialog(this.alert, "Image size exceeded 2MB limit.");
                        } else {
                            this.filesize /= 1024;
                            double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                            this.binding.cancel.setVisibility(0);
                            this.binding.photoSize.setVisibility(0);
                            this.binding.photoNameTv2.setVisibility(0);
                            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.photoSize.setText(dRound + "MB");
                            this.binding.image.setVisibility(0);
                            ImageView imageView2 = this.binding.image;
                            byte[] bArr2 = this.byteArray;
                            imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                        }
                        cursorQuery.close();
                        str = "MB";
                        str3 = "";
                        r23 = "Image size exceeded 2MB limit.";
                        str4 = "image";
                        str2 = "KB";
                        r14 = 100;
                        faceRecognition(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referencenumber);
                        r22 = contentResolver;
                    } catch (Exception e2) {
                        e = e2;
                        str = "MB";
                        str2 = "KB";
                        r24 = "Image size exceeded 2MB limit.";
                        r15 = 100;
                        str3 = "";
                        str4 = "image";
                        Logger.d(str3, e.getMessage());
                        r14 = r15;
                        r22 = contentResolver;
                        r23 = r24;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                contentResolver = "/";
                str = "MB";
                str2 = "KB";
                r24 = "Image size exceeded 2MB limit.";
                str3 = "";
                str4 = "image";
                r15 = 100;
            }
            Logger.d(str3, e.getMessage());
            r14 = r15;
            r22 = contentResolver;
            r23 = r24;
        }
        if (i == 102 && i2 == -1) {
            try {
                ?? bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, r14, byteArrayOutputStream2);
                this.pdfbyteArray = byteArrayOutputStream2.toByteArray();
            } catch (Exception e5) {
                Logger.d(str3, e5.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), str4);
                Cursor cursorQuery2 = getContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                if (cursorQuery2.getCount() <= 0) {
                    cursorQuery2.close();
                    throw new IllegalArgumentException(this.msg);
                }
                cursorQuery2.moveToFirst();
                String[] strArrSplit2 = saveImagePath2.getPath().split(r22);
                if (this.filesize < 1024) {
                    this.binding.delete.setVisibility(0);
                    this.binding.filename.setVisibility(0);
                    this.binding.filesize.setVisibility(0);
                    this.binding.preview.setVisibility(0);
                    ImageView imageView3 = this.binding.preview;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.filename.setText(strArrSplit2[strArrSplit2.length - 1]);
                    this.binding.filesize.setText(this.filesize + str2);
                } else if (this.filesize > 2048) {
                    this.binding.delete.setVisibility(8);
                    this.binding.filename.setVisibility(8);
                    this.binding.filesize.setVisibility(8);
                    this.binding.preview.setVisibility(8);
                    showdialog(this.alert, r23);
                } else {
                    this.filesize /= 1024;
                    double dRound2 = Math.round(this.filesize * 100.0d) / 100.0d;
                    this.binding.delete.setVisibility(0);
                    this.binding.filename.setVisibility(0);
                    this.binding.filesize.setVisibility(0);
                    this.binding.preview.setVisibility(0);
                    ImageView imageView4 = this.binding.preview;
                    byte[] bArr4 = this.pdfbyteArray;
                    imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.filename.setText(strArrSplit2[strArrSplit2.length - 1]);
                    this.binding.filesize.setText(dRound2 + str);
                }
                this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referencenumber, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda78
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i3, String str5) {
                        this.f$0.lambda$onActivityResult$147(i3, str5);
                    }
                });
            } catch (Exception e6) {
                Logger.d(str3, e6.getMessage());
            }
        }
        if (i == 10001 && i2 == -1) {
            Uri uri = Uri.parse(intent.getStringExtra("file_uri"));
            if (this.stateCode.equalsIgnoreCase("S19")) {
                uploadCroppedImage(uri);
            } else {
                startCrop(uri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$147(int i, final String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda120
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$145(str, i2, str2, str3);
                }
            });
        } else {
            this.passref = str;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda121
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResult$146();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$145(final String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda90
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$142(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referencenumber, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda91
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str4) {
                this.f$0.lambda$onActivityResult$144(str, i2, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$142(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$144(String str, int i, String str2) {
        this.passref = str;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onActivityResult$143();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$143() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$146() {
        this.alertDialog.dismiss();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == 2131363258) {
            this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda38
                @Override // in.gov.eci.bloapp.ArraylistReturn
                public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                    this.f$0.lambda$onTouch$151(i, arrayList, arrayList2);
                }
            });
        }
        if (v.getId() == 2131363872) {
            this.binding.firstnameEnglish.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameEnglish, this.partLang, "NAME");
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365970) {
            this.binding.surnameEnglish.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameEnglish, this.partLang, "NAME");
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365433) {
            this.binding.relativeNameEnglish.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameEnglish, this.partLang, "NAME");
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365428) {
            this.binding.relativeLastnameEnglish.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeLastname.getText().toString().trim(), this.binding.relativeLastnameEnglish, this.partLang, "NAME");
            } catch (Exception e4) {
                Logger.d("", e4.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131364098) {
            this.binding.houseRegional.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseRegional, this.partLang, this.addressfield);
            } catch (Exception e5) {
                Logger.d("", e5.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365207) {
            this.binding.postofficeOfficial.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeOfficial, this.partLang, this.addressfield);
            } catch (Exception e6) {
                Logger.d("", e6.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365895) {
            this.binding.streetRegional.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetRegional, this.partLang, this.addressfield);
            } catch (Exception e7) {
                Logger.d("", e7.getMessage());
            }
            return true;
        }
        if (v.getId() != 2131366685) {
            return false;
        }
        this.binding.villageRegional.requestFocus();
        try {
            FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.villageEd.getText().toString().trim(), this.binding.villageRegional, this.partLang, this.addressfield);
        } catch (Exception e8) {
            Logger.d("", e8.getMessage());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$151(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onTouch$150(i2, str, str2);
                }
            });
            return;
        }
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        if (arrayList.size() == 1) {
            this.binding.districtSpinner1.setText(this.districtNameac.get(0));
            return;
        }
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$150(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda21
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onTouch$148(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getDistrictOnAssembly(getContext(), this.stateCode, this.asmblyNO, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$$ExternalSyntheticLambda23
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$onTouch$149(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$148(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$149(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.districtNameac = arrayList;
        this.districtcodeac = arrayList2;
        if (arrayList.size() == 1) {
            this.binding.districtSpinner1.setText(this.districtNameac.get(0));
            return;
        }
        this.adapterdistrict = new ArrayAdapter<>((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.districtNameac);
        this.binding.districtSpinner1.setAdapter(this.adapterdistrict);
        this.binding.districtSpinner1.setThreshold(-1);
        this.binding.districtSpinner1.showDropDown();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == 2131363872 && hasFocus) {
            if (this.binding.firstNameEd.getText().toString().isEmpty()) {
                this.binding.firstnameEnglish.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameEnglish, this.partLang, "NAME");
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }
        }
        if (v.getId() == 2131365970 && hasFocus) {
            if (this.binding.surNameEd.getText().toString().isEmpty()) {
                this.binding.surnameEnglish.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameEnglish, this.partLang, "NAME");
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
                }
            }
        }
        if (v.getId() == 2131365433 && hasFocus) {
            if (this.binding.relativeName.getText().toString().isEmpty()) {
                this.binding.relativeNameEnglish.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameEnglish, this.partLang, "NAME");
                } catch (Exception e3) {
                    Logger.d("", e3.getMessage());
                }
            }
        }
        if (v.getId() == 2131365428 && hasFocus) {
            if (this.binding.relativeLastname.getText().toString().isEmpty()) {
                this.binding.relativeLastnameEnglish.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeLastname.getText().toString().trim(), this.binding.relativeLastnameEnglish, this.partLang, "NAME");
                } catch (Exception e4) {
                    Logger.d("", e4.getMessage());
                }
            }
        }
        if (v.getId() == 2131364098 && hasFocus) {
            if (this.binding.houseNoEd.getText().toString().isEmpty()) {
                this.binding.houseRegional.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.houseNoEd.getText().toString().trim(), this.binding.houseRegional, this.partLang, this.addressfield);
                } catch (Exception e5) {
                    Logger.d("", e5.getMessage());
                }
            }
        }
        if (v.getId() == 2131365207 && hasFocus) {
            if (this.binding.postofficeEd.getText().toString().isEmpty()) {
                this.binding.postofficeOfficial.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.postofficeEd.getText().toString().trim(), this.binding.postofficeOfficial, this.partLang, this.addressfield);
                } catch (Exception e6) {
                    Logger.d("", e6.getMessage());
                }
            }
        }
        if (v.getId() == 2131365895 && hasFocus) {
            if (this.binding.streetEd.getText().toString().isEmpty()) {
                this.binding.streetRegional.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.streetEd.getText().toString().trim(), this.binding.streetRegional, this.partLang, this.addressfield);
                } catch (Exception e7) {
                    Logger.d("", e7.getMessage());
                }
            }
        }
        if (v.getId() == 2131366685 && hasFocus) {
            if (this.binding.villageEd.getText().toString().isEmpty()) {
                this.binding.villageRegional.setText("");
                return;
            }
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.villageEd.getText().toString().trim(), this.binding.villageRegional, this.partLang, this.addressfield);
            } catch (Exception e8) {
                Logger.d("", e8.getMessage());
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference) {
        RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass36(statecode, asmblyNo, partno, filepath, captureFileName, reference));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;

        AnonymousClass36(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = OverseasVoter.this.commonUtilClass;
                Context contextRequireContext = OverseasVoter.this.requireContext();
                String str = OverseasVoter.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str8, String str9) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, i, str8, str9);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                OverseasVoter.this.commonUtilClass.uploadToServer2(OverseasVoter.this.getContext(), this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, OverseasVoter.this.token, this.val$reference, SharedPref.getInstance(OverseasVoter.this.requireContext()).getAtknBnd(), SharedPref.getInstance(OverseasVoter.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str8) {
                        this.f$0.lambda$onResponse$4(i, str8);
                    }
                });
                return;
            }
            try {
                OverseasVoter.this.binding.image.setVisibility(8);
                OverseasVoter.this.binding.cancel.setVisibility(8);
                OverseasVoter.this.binding.photoSize.setVisibility(8);
                OverseasVoter.this.binding.photoNameTv2.setVisibility(8);
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                OverseasVoter overseasVoter = OverseasVoter.this;
                overseasVoter.showdialog(overseasVoter.alert, jSONObject.optString("message"));
            } catch (IOException | JSONException e) {
                Logger.d("OverseasVoter", e.toString());
            }
            OverseasVoter.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8) {
            OverseasVoter.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str7 + " " + str8);
            if (i == 401 || i == 400) {
                OverseasVoter.this.commonUtilClass.showMessageOK(OverseasVoter.this.getContext(), OverseasVoter.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            OverseasVoter.this.token = "Bearer " + str7;
            OverseasVoter.this.refreshToken = str8;
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setRefreshToken(str8);
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setToken("Bearer " + str7);
            OverseasVoter overseasVoter = OverseasVoter.this;
            overseasVoter.faceRecognition(str, str2, str3, str4, str5, overseasVoter.token, str6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setLocaleBool(false);
            OverseasVoter.this.startActivity(new Intent((Context) OverseasVoter.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(int i, String str) {
            if (i == 401) {
                OverseasVoter.this.commonUtilClass.showMessageOK(OverseasVoter.this.getContext(), OverseasVoter.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
            } else {
                OverseasVoter.this.photoref = str;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter$36$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$3();
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(OverseasVoter.this.requireContext()).setLocaleBool(false);
            OverseasVoter.this.startActivity(new Intent((Context) OverseasVoter.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            OverseasVoter.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            OverseasVoter.this.binding.image.setVisibility(8);
            OverseasVoter.this.binding.cancel.setVisibility(8);
            OverseasVoter.this.binding.photoSize.setVisibility(8);
            OverseasVoter.this.binding.photoNameTv2.setVisibility(8);
            Logger.d(" ", t.getMessage());
            OverseasVoter.this.alertDialog.dismiss();
        }
    }

    public void startCrop(Uri sourceUri) {
        this.uCropLauncher.launch(UCrop.of(sourceUri, ImageUriUtils.createCacheImageUri(getContext(), "cropped_" + System.currentTimeMillis() + ".jpg")).withOptions(buildUCropOptions()).withAspectRatio(1.0f, 1.0f).withMaxResultSize(1024, 1024).getIntent(getContext()));
    }

    private UCrop.Options buildUCropOptions() {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setCompressionQuality(95);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCropSuccess(Uri croppedImageUri) {
        uploadCroppedImage(croppedImageUri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCropError(Throwable t) {
        if (t != null) {
            t.printStackTrace();
        }
        Toast.makeText(getContext(), "Crop failed: " + (t != null ? t.getMessage() : "unknown"), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCropCancelled() {
        Toast.makeText(getContext(), "Crop cancelled", 0).show();
    }

    private void uploadCroppedImage(Uri croppedImageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), croppedImageUri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.pdfbyteArray = byteArray;
            try {
                String[] strArrSplit = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image").getPath().split("/");
                if (this.filesize < 1024) {
                    this.binding.cancel.setVisibility(0);
                    this.binding.photoSize.setVisibility(0);
                    this.binding.photoNameTv2.setVisibility(0);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photoSize.setText(this.filesize + "KB");
                    this.binding.image.setVisibility(0);
                    ImageView imageView = this.binding.image;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } else if (this.filesize > 2048) {
                    this.binding.image.setVisibility(8);
                    this.binding.cancel.setVisibility(8);
                    this.binding.photoSize.setVisibility(8);
                    this.binding.photoNameTv2.setVisibility(8);
                    showdialog(this.alert, "Image size exceeded 2MB limit.");
                } else {
                    this.filesize /= 1024;
                    double dRound = Math.round(this.filesize * 100.0d) / 100.0d;
                    this.binding.cancel.setVisibility(0);
                    this.binding.photoSize.setVisibility(0);
                    this.binding.photoNameTv2.setVisibility(0);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photoSize.setText(dRound + "MB");
                    this.binding.image.setVisibility(0);
                    ImageView imageView2 = this.binding.image;
                    byte[] bArr2 = this.pdfbyteArray;
                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                }
                faceRecognition(this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referencenumber);
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
        } catch (Exception unused) {
        }
    }
}
