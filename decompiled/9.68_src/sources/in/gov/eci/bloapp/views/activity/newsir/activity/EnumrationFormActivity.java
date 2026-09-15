package in.gov.eci.bloapp.views.activity.newsir.activity;

import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityEnumrationFormBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.NameMatcher;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.pendingElectors;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EnumrationFormActivity extends AppCompatActivity {
    String No;
    private String SESSION;
    private String abbrev;
    int age;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivityEnumrationFormBinding binding;
    Bundle bundle;
    byte[] byteArray;
    DatePickerDialog datePickerDialog;
    String dob;
    String dobVerified;
    Long epicId;
    String fatherEpicNo;
    String father_epicNumber;
    String father_oldAcName;
    int father_oldAcNo;
    String father_oldDistName;
    int father_oldDistNo;
    String father_oldFullName;
    String father_oldPartName;
    int father_oldPartNumber;
    int father_oldPartSerialNo;
    String father_oldRelativeFullName;
    String father_oldStateCd;
    String father_oldStateName;
    String father_relationType;
    protected long filesize;
    boolean flag2003;
    String lat;
    String list_epicName;
    String list_epicNo;
    String list_partSerialNo;
    String list_relation_type;
    String list_relation_type_name;
    String list_relationname;
    private LocationRequest locationRequest;
    String longi;
    String mappedType;
    String mime;
    String mobile;
    String motherEpicNo;
    int oldAge;
    private String partNo;
    private byte[] pdfbyteArray;
    ProgressBar progressBar;
    String referenceNo;
    private String refreshToken;
    String relationcode;
    int rlnprgnyoldage;
    private String rtkband;
    protected String saveImageFileName;
    String selectDocumentType;
    String selectRelationType;
    int selectedId;
    String selectedText;
    String self_OldStateCd;
    String self_categoryType;
    String self_oldAcName;
    int self_oldAcNo;
    String self_oldPartName;
    int self_oldPartNumber;
    int self_oldPartSerialNo;
    String self_oldStateName;
    String self_selfOldEpic;
    String self_selfOldName;
    String self_selfOldRlnName;
    String self_selfOldRlnType;
    int selfoldage;
    String sirYearProgeny;
    String sirYearSelf;
    String spinner_relation_type_name;
    String spouseEpicNo;
    private String state;
    String submittedForRecommendation;
    String temp;
    private String token;
    String uploadFlag;
    Utils utils;
    String takephoto = "";
    String choose_front_camera = "";
    String choose_back_camera = "";
    String whitecolor = "#000000";
    private int currentImagePickerId = 0;
    String preRevisonFlag = "N";
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String cancel = "Cancel";
    String alertText = "";
    String TAG = "EnumrationFormActivityTAG";
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String isThisYouRelFlag = "N";
    String applicationpdf = "application/pdf";
    private String photoref = null;
    private String annexRef = null;
    String fileNotFoundMessage = "Something went wrong.";
    String functionNameForLogBaseActivity = "";
    String citizenCat = null;
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private String submitFlag = null;
    private boolean result = false;
    boolean onlineStatus = true;
    boolean faceRecognition = true;
    String tabName = "fillTab";
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String garudaTextBaseActivity = "GARUDA";
    private String aadharref = null;
    private String photo1Ref = null;
    private String photo2Ref = null;
    String imageTextBaseActivity = "image";
    String upload = "Please upload file again.";
    final Calendar dobcalendar = Calendar.getInstance();
    String annexureStr = "Annexure";
    String photo1Str = " Photo1 Annexure";
    String photo2str = "Photo2 Annexure";
    String pdfTextBaseActivity = ".pdf";
    String list8code = "";
    String img = "image";
    String jpgTextBaseActivity = ".jpg";
    String invalidaadhar = "";
    String fileNameTextBaseActivity = "fileName";
    String mobileNo = null;
    String fatherName = null;
    String fatherEpic = null;
    String motherName = null;
    String motherEpic = null;
    String spouseName = null;
    String spouseEpic = null;
    String epicNumber = null;
    String serial = null;
    String erollDoB = null;
    String houseNumber = null;
    String erollPhotoURL = null;
    String isLegacy = null;
    String messageString = "message";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    String sessionTokenExpiredPleaseLogin = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    boolean isRequestOTPClicked = false;
    String otp = "";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String from = "";
    String isselected2003 = "";
    boolean isfirsttimeenter = true;
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;
    String objectStorageString = "objectstorage";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    String packageBundle = "package";

    /* JADX WARN: Code duplicated, block: B:102:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:105:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:108:0x0408  */
    /* JADX WARN: Code duplicated, block: B:111:0x0412  */
    /* JADX WARN: Code duplicated, block: B:114:0x041c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0426  */
    /* JADX WARN: Code duplicated, block: B:120:0x0430  */
    /* JADX WARN: Code duplicated, block: B:123:0x043a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0444  */
    /* JADX WARN: Code duplicated, block: B:129:0x044e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0458  */
    /* JADX WARN: Code duplicated, block: B:135:0x0462  */
    /* JADX WARN: Code duplicated, block: B:138:0x046c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0476  */
    /* JADX WARN: Code duplicated, block: B:144:0x0480  */
    /* JADX WARN: Code duplicated, block: B:147:0x048a  */
    /* JADX WARN: Code duplicated, block: B:150:0x0494  */
    /* JADX WARN: Code duplicated, block: B:153:0x049e  */
    /* JADX WARN: Code duplicated, block: B:156:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:159:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:162:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:164:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:168:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:170:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:173:0x050a  */
    /* JADX WARN: Code duplicated, block: B:181:0x0562  */
    /* JADX WARN: Code duplicated, block: B:183:0x056a  */
    /* JADX WARN: Code duplicated, block: B:184:0x0575  */
    /* JADX WARN: Code duplicated, block: B:186:0x057d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0588  */
    /* JADX WARN: Code duplicated, block: B:233:0x066d  */
    /* JADX WARN: Code duplicated, block: B:234:0x067f  */
    /* JADX WARN: Code duplicated, block: B:237:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:239:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:240:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:242:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:243:0x0709  */
    /* JADX WARN: Code duplicated, block: B:284:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:287:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:288:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:93:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:96:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:99:0x03ea  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    protected void onCreate(Bundle savedInstanceState) {
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
        ?? r9;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityEnumrationFormBinding activityEnumrationFormBindingInflate = ActivityEnumrationFormBinding.inflate(getLayoutInflater());
        this.binding = activityEnumrationFormBindingInflate;
        setContentView(activityEnumrationFormBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.choose_front_camera = getString(R.string.capture_from_front_camera);
        this.choose_back_camera = getString(R.string.capture_from_back_camera);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.utils = new Utils();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        this.isfirsttimeenter = true;
        getCurrentLocation();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        Intent intent = getIntent();
        String str11 = "Father";
        String str12 = "Husband";
        String str13 = "Wife";
        String str14 = "O";
        String str15 = "WIFE";
        if (intent != null) {
            this.erollDoB = intent.getStringExtra("dob");
            this.father_epicNumber = intent.getStringExtra("father_epicNumber");
            str = "W";
            this.father_oldPartNumber = intent.getIntExtra("father_oldPartNumber", 0);
            this.father_oldPartName = intent.getStringExtra("father_oldPartName");
            this.father_oldPartSerialNo = intent.getIntExtra("father_oldPartSerialNo", 0);
            this.father_oldAcName = intent.getStringExtra("father_oldAcName");
            this.father_oldAcNo = intent.getIntExtra("father_oldAcNo", 0);
            this.father_oldDistName = intent.getStringExtra("father_oldDistName");
            this.father_oldDistNo = intent.getIntExtra("father_oldDistNo", 0);
            this.father_oldStateName = intent.getStringExtra("father_oldStateName");
            this.father_oldStateCd = intent.getStringExtra("father_oldStateCd");
            this.father_relationType = intent.getStringExtra("father_relationType");
            this.father_oldFullName = intent.getStringExtra("father_oldFullName");
            this.father_oldRelativeFullName = intent.getStringExtra("father_oldRelativeFullName");
            this.epicId = Long.valueOf(intent.getLongExtra("list_epicId", 0L));
            this.epicNumber = intent.getStringExtra("list_epicNo");
            this.list_partSerialNo = intent.getStringExtra("list_partSerialNo");
            this.list_epicName = intent.getStringExtra("list_epicName");
            this.submittedForRecommendation = intent.getStringExtra("submittedForRecommendation");
            this.self_selfOldName = intent.getStringExtra("self_selfOldName");
            this.self_selfOldEpic = intent.getStringExtra("self_selfOldEpic");
            this.self_selfOldRlnName = intent.getStringExtra("self_selfOldRlnName");
            this.self_selfOldRlnType = intent.getStringExtra("self_selfOldRlnType");
            this.self_categoryType = intent.getStringExtra("self_categoryType");
            this.self_OldStateCd = intent.getStringExtra("self_OldStateCd");
            this.self_oldStateName = intent.getStringExtra("self_oldStateName");
            this.self_oldAcName = intent.getStringExtra("self_oldAcName");
            this.self_oldAcNo = intent.getIntExtra("self_oldAcNo", 0);
            this.self_oldPartNumber = intent.getIntExtra("self_oldPartNumber", 0);
            this.self_oldPartName = intent.getStringExtra("self_oldPartName");
            this.self_oldPartSerialNo = intent.getIntExtra("self_oldPartSerialNo", 0);
            this.mappedType = intent.getStringExtra("mappingType");
            this.No = intent.getStringExtra(BooleanUtils.NO);
            this.rlnprgnyoldage = intent.getIntExtra("rlnprgnyoldage", 0);
            this.selfoldage = intent.getIntExtra("selfoldage", 0);
            this.from = intent.getStringExtra("from");
            this.list_relationname = intent.getStringExtra("list_relationname");
            this.list_relation_type = intent.getStringExtra("list_relation_type");
            if (intent.hasExtra("isselected2003")) {
                this.isselected2003 = intent.getStringExtra("isselected2003");
            } else {
                this.isselected2003 = "";
            }
            if (intent.hasExtra("sirYearSelf")) {
                this.sirYearSelf = intent.getStringExtra("sirYearSelf");
            } else {
                this.sirYearSelf = "";
            }
            if (intent.hasExtra("sirYearProgeny")) {
                this.sirYearProgeny = intent.getStringExtra("sirYearProgeny");
            } else {
                this.sirYearProgeny = "";
            }
            if (TextUtils.isEmpty(this.list_relation_type) || TextUtils.isEmpty(this.list_relationname)) {
                str3 = "Mother";
                str14 = str14;
                str2 = "HSBN";
            } else {
                if (this.list_relation_type.equals("GMTH")) {
                    this.list_relation_type_name = "GrandMother";
                } else if (this.list_relation_type.equals("GFTH")) {
                    this.list_relation_type_name = "GrandFather";
                } else if (this.list_relation_type.equalsIgnoreCase("M") || this.list_relation_type.equalsIgnoreCase("MOTHER") || this.list_relation_type.equalsIgnoreCase("MTHR")) {
                    str14 = str14;
                    str2 = "HSBN";
                    str11 = str11;
                    this.binding.motherName.setText(this.list_relationname);
                    str3 = "Mother";
                    this.list_relation_type_name = str3;
                } else {
                    if (this.list_relation_type.equalsIgnoreCase("F") || this.list_relation_type.equalsIgnoreCase("FATHER") || this.list_relation_type.equalsIgnoreCase("FTHR")) {
                        str14 = str14;
                        str2 = "HSBN";
                        str12 = str12;
                        this.binding.fatherName.setText(this.list_relationname);
                        this.list_relation_type_name = str11;
                    } else {
                        if (this.list_relation_type.equalsIgnoreCase("H") || this.list_relation_type.equalsIgnoreCase("HUSBAND")) {
                            str2 = "HSBN";
                        } else {
                            str2 = "HSBN";
                            if (!this.list_relation_type.equalsIgnoreCase(str2)) {
                                if (!this.list_relation_type.equalsIgnoreCase(str)) {
                                    if (this.list_relation_type.equalsIgnoreCase(str15)) {
                                        str15 = str15;
                                        str14 = str14;
                                        str = str;
                                        this.binding.spouseName.setText(this.list_relationname);
                                        this.list_relation_type_name = str13;
                                    } else {
                                        if (this.list_relation_type.equalsIgnoreCase("L") || this.list_relation_type.equalsIgnoreCase("OTHER")) {
                                            str15 = str15;
                                            str15 = str15;
                                            str14 = str14;
                                        } else {
                                            str14 = str14;
                                            if (this.list_relation_type.equalsIgnoreCase(str14)) {
                                            }
                                            str15 = str15;
                                            str = str;
                                        }
                                        str15 = str15;
                                        this.list_relation_type_name = "other";
                                        str15 = str15;
                                        str = str;
                                    }
                                } else {
                                    str14 = str14;
                                    str = str;
                                    this.binding.spouseName.setText(this.list_relationname);
                                    this.list_relation_type_name = str13;
                                }
                            }
                        }
                        str13 = str13;
                        this.binding.spouseName.setText(this.list_relationname);
                        this.list_relation_type_name = str12;
                    }
                    str3 = "Mother";
                }
                str3 = "Mother";
                str14 = str14;
                str2 = "HSBN";
            }
        } else {
            str = "W";
            str2 = "HSBN";
            str3 = "Mother";
            str14 = str14;
        }
        if (this.erollDoB != null) {
            try {
                str5 = str3;
                str4 = str2;
                try {
                    str6 = "HUSBAND";
                    try {
                        this.dobVerified = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this.erollDoB));
                    } catch (Exception e) {
                        e = e;
                        Logger.d("Date replace", e.toString());
                    }
                } catch (Exception e2) {
                    e = e2;
                    str6 = "HUSBAND";
                    Logger.d("Date replace", e.toString());
                    if (TextUtils.isEmpty(this.dobVerified)) {
                        this.dobVerified = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldPartName)) {
                        this.father_oldPartName = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldAcName)) {
                        this.father_oldAcName = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldDistName)) {
                        this.father_oldDistName = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldStateName)) {
                        this.father_oldStateName = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldStateCd)) {
                        this.father_oldStateCd = "";
                    }
                    if (TextUtils.isEmpty(this.father_relationType)) {
                        this.father_relationType = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldFullName)) {
                        this.father_oldFullName = "";
                    }
                    if (TextUtils.isEmpty(this.father_oldRelativeFullName)) {
                        this.father_oldRelativeFullName = "";
                    }
                    if (TextUtils.isEmpty(this.list_partSerialNo)) {
                        this.list_partSerialNo = "";
                    }
                    if (TextUtils.isEmpty(this.submittedForRecommendation)) {
                        this.submittedForRecommendation = "";
                    }
                    if (TextUtils.isEmpty(this.self_selfOldName)) {
                        this.self_selfOldName = "";
                    }
                    if (TextUtils.isEmpty(this.self_selfOldEpic)) {
                        this.self_selfOldEpic = "";
                    }
                    if (TextUtils.isEmpty(this.self_selfOldRlnName)) {
                        this.self_selfOldRlnName = "";
                    }
                    if (TextUtils.isEmpty(this.self_selfOldRlnType)) {
                        this.self_selfOldRlnType = "";
                    }
                    if (TextUtils.isEmpty(this.self_categoryType)) {
                        this.self_categoryType = "";
                    }
                    if (TextUtils.isEmpty(this.self_OldStateCd)) {
                        this.self_OldStateCd = "";
                    }
                    if (TextUtils.isEmpty(this.self_oldStateName)) {
                        this.self_oldStateName = "";
                    }
                    if (TextUtils.isEmpty(this.self_oldAcName)) {
                        this.self_oldAcName = "";
                    }
                    if (TextUtils.isEmpty(this.self_oldPartName)) {
                        this.self_oldPartName = "";
                    }
                    if (TextUtils.isEmpty(this.mappedType)) {
                        this.mappedType = "";
                    }
                    if (this.self_selfOldRlnType.equalsIgnoreCase(str14)) {
                        this.self_selfOldRlnType = "Others";
                    }
                    if (this.father_relationType.equalsIgnoreCase(str14)) {
                        this.father_relationType = "Others";
                    }
                    this.binding.dateOfBirth.setText(this.dobVerified);
                    if (this.self_categoryType.equalsIgnoreCase("progeny")) {
                        if (checkProgenyEmpty()) {
                            showDialogSelfProgeny(this.alertText, "Either old state, old ac,old part number or old part serial number is null");
                        }
                        this.oldAge = this.rlnprgnyoldage;
                        this.binding.selfCardView.setVisibility(8);
                    }
                    if (this.self_categoryType.equalsIgnoreCase("Self")) {
                        this.oldAge = this.selfoldage;
                        if (checkSelfEmpty()) {
                            showDialogSelfProgeny(this.alertText, "Either old state, old ac,old part number or old part serial number is null");
                        }
                    }
                    if (this.self_categoryType.equalsIgnoreCase("NA")) {
                        this.binding.selfCardView.setVisibility(8);
                        this.binding.relativeCardView.setVisibility(8);
                        this.binding.relationtypecardview.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(this.No)) {
                        this.binding.relativeCardView.setVisibility(8);
                        this.binding.relationtypecardview.setVisibility(8);
                    }
                    this.binding.tvEpic.setText(this.self_selfOldEpic);
                    this.binding.tvName.setText(this.self_selfOldName);
                    this.binding.tvName1.setText(this.self_selfOldRlnName);
                    if (TextUtils.isEmpty(this.self_selfOldRlnType)) {
                        str7 = str5;
                        str8 = str6;
                        str9 = str4;
                    } else {
                        if (this.self_selfOldRlnType.equals("GMTH")) {
                            this.binding.tvRelation.setText("Grand Mother");
                        } else if (this.self_selfOldRlnType.equals("GFTH")) {
                            this.binding.tvRelation.setText("Grand Father");
                        } else if (!this.self_selfOldRlnType.equalsIgnoreCase("M")) {
                            str8 = str6;
                            str9 = str4;
                            str11 = str11;
                            str7 = str5;
                            this.binding.tvRelation.setText(str7);
                        } else {
                            str8 = str6;
                            str9 = str4;
                            str11 = str11;
                            str7 = str5;
                            this.binding.tvRelation.setText(str7);
                        }
                        str7 = str5;
                        str8 = str6;
                        str9 = str4;
                    }
                    str10 = str7;
                    this.binding.tvState.setText(this.self_oldStateName);
                    this.binding.tvAcName.setText(this.self_oldAcName);
                    this.binding.tvAcNo.setText(String.valueOf(this.self_oldAcNo));
                    this.binding.tvPartNo.setText(String.valueOf(this.self_oldPartNumber));
                    this.binding.tvSrNo.setText(String.valueOf(this.self_oldPartSerialNo));
                    this.binding.tvRlEpic.setText(this.father_epicNumber);
                    this.binding.tvRlName.setText(this.father_oldFullName);
                    this.binding.tvRlName1.setText(this.father_oldRelativeFullName);
                    if (!TextUtils.isEmpty(this.father_relationType)) {
                        if (this.father_relationType.equals("GMTH")) {
                            this.binding.tvRlRelation.setText("Grand Mother");
                        } else if (this.father_relationType.equals("GFTH")) {
                            this.binding.tvRlRelation.setText("Grand Father");
                        } else if (!this.father_relationType.equalsIgnoreCase("M")) {
                            this.binding.tvRlRelation.setText(str10);
                        } else {
                            this.binding.tvRlRelation.setText(str10);
                        }
                    }
                    this.binding.tvRlState.setText(this.father_oldStateName);
                    this.binding.tvRlAcName.setText(this.father_oldAcName);
                    this.binding.tvRlAcNo.setText(String.valueOf(this.father_oldAcNo));
                    this.binding.tvRlPartNo.setText(String.valueOf(this.father_oldPartNumber));
                    this.binding.tvRlSrNo.setText(String.valueOf(this.father_oldPartSerialNo));
                    this.binding.speakMotherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                            enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.motherName);
                        }
                    });
                    this.binding.speakSpouseName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                            enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.spouseName);
                        }
                    });
                    this.binding.speakFatherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                            enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.fatherName);
                        }
                    });
                    Date date = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(1, -125);
                    final long time = calendar.getTime().getTime();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(new Date());
                    calendar2.add(1, -18);
                    final long time2 = calendar2.getTime().getTime();
                    final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda14
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            this.f$0.lambda$onCreate$0(datePicker, i, i2, i3);
                        }
                    };
                    this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
                    this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
                    this.token = SharedPref.getInstance(getApplicationContext()).getToken();
                    this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
                    this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
                    this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
                    this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
                    this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda15
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$1(view);
                        }
                    });
                    if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
                        this.faceRecognition = true;
                        r9 = 0;
                    } else {
                        r9 = 0;
                        this.faceRecognition = false;
                    }
                    this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda16
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$2(view);
                        }
                    });
                    this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda17
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$3(view);
                        }
                    });
                    this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda18
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$4(onDateSetListener, time2, time, view);
                        }
                    });
                    this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda19
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$5(view);
                        }
                    });
                    this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            String strTrim = EnumrationFormActivity.this.binding.motherEpicNumber.getText().toString().trim();
                            if (strTrim.isEmpty()) {
                                return;
                            }
                            EnumrationFormActivity.this.isMotherEPICValid = false;
                            EnumrationFormActivity.this.checkEpicNumber(strTrim, "Mother");
                        }
                    });
                    this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            String strTrim = EnumrationFormActivity.this.binding.fatherEpicNumber.getText().toString().trim();
                            if (strTrim.isEmpty()) {
                                return;
                            }
                            EnumrationFormActivity.this.isFatherEPICValid = false;
                            EnumrationFormActivity.this.checkEpicNumber(strTrim, "Father");
                        }
                    });
                    this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            String strTrim = EnumrationFormActivity.this.binding.spouseEpicNumber.getText().toString().trim();
                            if (strTrim.isEmpty()) {
                                return;
                            }
                            EnumrationFormActivity.this.isSpouseEPICValid = false;
                            EnumrationFormActivity.this.checkEpicNumber(strTrim, "Spouse");
                        }
                    });
                    this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda20
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$6(view);
                        }
                    });
                    this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$7(view);
                        }
                    });
                    this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$8(view);
                        }
                    });
                    this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$9(view);
                        }
                    });
                    this.binding.aadharNumber.addTextChangedListener(new AnonymousClass7());
                    View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
                    this.alertDialog = alertDialogCreate;
                    alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(r9));
                    this.alertDialog.setCancelable((boolean) r9);
                    this.alertDialog.setView(viewInflate);
                    this.relationNameList = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
                    this.relationCodeList = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    this.binding.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    this.binding.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.8
                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                            if (i == 0) {
                                EnumrationFormActivity.this.relationcode = null;
                                EnumrationFormActivity.this.spinner_relation_type_name = "";
                                EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
                                return;
                            }
                            EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
                            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                            enumrationFormActivity.relationcode = enumrationFormActivity.relationCodeList.get(i);
                            if (EnumrationFormActivity.this.relationcode.equals("GMTH")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "GrandMother";
                            } else if (EnumrationFormActivity.this.relationcode.equals("GFTH")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "GrandFather";
                            } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("M") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("MOTHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("MTHR")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "Mother";
                            } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("F") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("FATHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("FTHR")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "Father";
                            } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("H") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("HUSBAND") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("HSBN")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "Husband";
                            } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("W") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("WIFE")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "Wife";
                            } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("L") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("OTHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("O")) {
                                EnumrationFormActivity.this.spinner_relation_type_name = "other";
                            }
                            if (TextUtils.isEmpty(EnumrationFormActivity.this.list_relation_type) || TextUtils.isEmpty(EnumrationFormActivity.this.list_relationname) || TextUtils.isEmpty(EnumrationFormActivity.this.list_relation_type_name) || TextUtils.isEmpty(EnumrationFormActivity.this.spinner_relation_type_name) || !EnumrationFormActivity.this.list_relation_type_name.equalsIgnoreCase(EnumrationFormActivity.this.spinner_relation_type_name)) {
                                return;
                            }
                            if (!TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) && !TextUtils.isEmpty(EnumrationFormActivity.this.list_relationname)) {
                                EnumrationFormActivity.this.binding.matchingLayout.setVisibility(0);
                                EnumrationFormActivity.this.showResult(NameMatcher.getMatchResult(EnumrationFormActivity.this.list_relationname, TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) ? "" : EnumrationFormActivity.this.father_oldFullName));
                                EnumrationFormActivity.this.binding.tvLeftName.setText(EnumrationFormActivity.this.list_relationname);
                                EnumrationFormActivity.this.binding.tvRightName.setText(TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) ? "" : EnumrationFormActivity.this.father_oldFullName);
                                return;
                            }
                            EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
                        }
                    });
                    this.binding.fatherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.9
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (TextUtils.isEmpty(s.toString())) {
                                EnumrationFormActivity.this.isFatherEPICValid = false;
                                EnumrationFormActivity.this.binding.fatherName.setEnabled(true);
                                EnumrationFormActivity.this.binding.speakFatherName.setClickable(true);
                            }
                        }
                    });
                    this.binding.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.10
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (TextUtils.isEmpty(s.toString())) {
                                EnumrationFormActivity.this.isMotherEPICValid = false;
                                EnumrationFormActivity.this.binding.motherName.setEnabled(true);
                                EnumrationFormActivity.this.binding.speakMotherName.setClickable(true);
                            }
                        }
                    });
                    this.binding.spouseEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.11
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (TextUtils.isEmpty(s.toString())) {
                                EnumrationFormActivity.this.isSpouseEPICValid = false;
                                EnumrationFormActivity.this.binding.spouseName.setEnabled(true);
                                EnumrationFormActivity.this.binding.speakSpouseName.setClickable(true);
                            }
                        }
                    });
                }
            } catch (Exception e3) {
                e = e3;
                str4 = str2;
                str5 = str3;
            }
        } else {
            str4 = str2;
            str5 = str3;
            str6 = "HUSBAND";
        }
        if (TextUtils.isEmpty(this.dobVerified)) {
            this.dobVerified = "";
        }
        if (TextUtils.isEmpty(this.father_oldPartName)) {
            this.father_oldPartName = "";
        }
        if (TextUtils.isEmpty(this.father_oldAcName)) {
            this.father_oldAcName = "";
        }
        if (TextUtils.isEmpty(this.father_oldDistName)) {
            this.father_oldDistName = "";
        }
        if (TextUtils.isEmpty(this.father_oldStateName)) {
            this.father_oldStateName = "";
        }
        if (TextUtils.isEmpty(this.father_oldStateCd)) {
            this.father_oldStateCd = "";
        }
        if (TextUtils.isEmpty(this.father_relationType)) {
            this.father_relationType = "";
        }
        if (TextUtils.isEmpty(this.father_oldFullName)) {
            this.father_oldFullName = "";
        }
        if (TextUtils.isEmpty(this.father_oldRelativeFullName)) {
            this.father_oldRelativeFullName = "";
        }
        if (TextUtils.isEmpty(this.list_partSerialNo)) {
            this.list_partSerialNo = "";
        }
        if (TextUtils.isEmpty(this.submittedForRecommendation)) {
            this.submittedForRecommendation = "";
        }
        if (TextUtils.isEmpty(this.self_selfOldName)) {
            this.self_selfOldName = "";
        }
        if (TextUtils.isEmpty(this.self_selfOldEpic)) {
            this.self_selfOldEpic = "";
        }
        if (TextUtils.isEmpty(this.self_selfOldRlnName)) {
            this.self_selfOldRlnName = "";
        }
        if (TextUtils.isEmpty(this.self_selfOldRlnType)) {
            this.self_selfOldRlnType = "";
        }
        if (TextUtils.isEmpty(this.self_categoryType)) {
            this.self_categoryType = "";
        }
        if (TextUtils.isEmpty(this.self_OldStateCd)) {
            this.self_OldStateCd = "";
        }
        if (TextUtils.isEmpty(this.self_oldStateName)) {
            this.self_oldStateName = "";
        }
        if (TextUtils.isEmpty(this.self_oldAcName)) {
            this.self_oldAcName = "";
        }
        if (TextUtils.isEmpty(this.self_oldPartName)) {
            this.self_oldPartName = "";
        }
        if (TextUtils.isEmpty(this.mappedType)) {
            this.mappedType = "";
        }
        if (this.self_selfOldRlnType.equalsIgnoreCase(str14)) {
            this.self_selfOldRlnType = "Others";
        }
        if (this.father_relationType.equalsIgnoreCase(str14)) {
            this.father_relationType = "Others";
        }
        this.binding.dateOfBirth.setText(this.dobVerified);
        if (this.self_categoryType.equalsIgnoreCase("progeny")) {
            if (checkProgenyEmpty()) {
                showDialogSelfProgeny(this.alertText, "Either old state, old ac,old part number or old part serial number is null");
            }
            this.oldAge = this.rlnprgnyoldage;
            this.binding.selfCardView.setVisibility(8);
        }
        if (this.self_categoryType.equalsIgnoreCase("Self")) {
            this.oldAge = this.selfoldage;
            if (checkSelfEmpty()) {
                showDialogSelfProgeny(this.alertText, "Either old state, old ac,old part number or old part serial number is null");
            }
        }
        if (this.self_categoryType.equalsIgnoreCase("NA")) {
            this.binding.selfCardView.setVisibility(8);
            this.binding.relativeCardView.setVisibility(8);
            this.binding.relationtypecardview.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.No) && this.No.equalsIgnoreCase("N")) {
            this.binding.relativeCardView.setVisibility(8);
            this.binding.relationtypecardview.setVisibility(8);
        }
        this.binding.tvEpic.setText(this.self_selfOldEpic);
        this.binding.tvName.setText(this.self_selfOldName);
        this.binding.tvName1.setText(this.self_selfOldRlnName);
        if (TextUtils.isEmpty(this.self_selfOldRlnType)) {
            str7 = str5;
            str8 = str6;
            str9 = str4;
        } else {
            if (this.self_selfOldRlnType.equals("GMTH")) {
                this.binding.tvRelation.setText("Grand Mother");
            } else if (this.self_selfOldRlnType.equals("GFTH")) {
                this.binding.tvRelation.setText("Grand Father");
            } else if (!this.self_selfOldRlnType.equalsIgnoreCase("M") || this.self_selfOldRlnType.equalsIgnoreCase("MOTHER") || this.self_selfOldRlnType.equalsIgnoreCase("MTHR")) {
                str8 = str6;
                str9 = str4;
                str11 = str11;
                str7 = str5;
                this.binding.tvRelation.setText(str7);
            } else {
                if (this.self_selfOldRlnType.equalsIgnoreCase("F") || this.self_selfOldRlnType.equalsIgnoreCase("FATHER") || this.self_selfOldRlnType.equalsIgnoreCase("FTHR")) {
                    str8 = str6;
                    str9 = str4;
                    str12 = str12;
                    this.binding.tvRelation.setText(str11);
                } else {
                    if (this.self_selfOldRlnType.equalsIgnoreCase("H")) {
                        str8 = str6;
                    } else {
                        str8 = str6;
                        if (!this.self_selfOldRlnType.equalsIgnoreCase(str8)) {
                            str9 = str4;
                            if (this.self_selfOldRlnType.equalsIgnoreCase(str9)) {
                                str13 = str13;
                                str13 = str13;
                                this.binding.tvRelation.setText(str12);
                            } else {
                                String str16 = str;
                                if (this.self_selfOldRlnType.equalsIgnoreCase(str16)) {
                                    str = str16;
                                } else {
                                    str = str16;
                                    String str17 = str15;
                                    if (this.self_selfOldRlnType.equalsIgnoreCase(str17)) {
                                        str15 = str17;
                                    } else {
                                        str15 = str17;
                                        if (this.self_selfOldRlnType.equalsIgnoreCase("L") || this.self_selfOldRlnType.equalsIgnoreCase("OTHER") || this.self_selfOldRlnType.equalsIgnoreCase(str14)) {
                                            this.binding.tvRelation.setText("Other");
                                        } else if (TextUtils.isEmpty(this.self_selfOldRlnType)) {
                                            this.binding.tvRelation.setText("");
                                        } else {
                                            this.binding.tvRelation.setText(this.self_selfOldRlnType);
                                        }
                                    }
                                }
                                this.binding.tvRelation.setText(str13);
                            }
                        }
                    }
                    str9 = str4;
                    str13 = str13;
                    this.binding.tvRelation.setText(str12);
                }
                str7 = str5;
            }
            str7 = str5;
            str8 = str6;
            str9 = str4;
        }
        str10 = str7;
        this.binding.tvState.setText(this.self_oldStateName);
        this.binding.tvAcName.setText(this.self_oldAcName);
        this.binding.tvAcNo.setText(String.valueOf(this.self_oldAcNo));
        this.binding.tvPartNo.setText(String.valueOf(this.self_oldPartNumber));
        this.binding.tvSrNo.setText(String.valueOf(this.self_oldPartSerialNo));
        this.binding.tvRlEpic.setText(this.father_epicNumber);
        this.binding.tvRlName.setText(this.father_oldFullName);
        this.binding.tvRlName1.setText(this.father_oldRelativeFullName);
        if (!TextUtils.isEmpty(this.father_relationType)) {
            if (this.father_relationType.equals("GMTH")) {
                this.binding.tvRlRelation.setText("Grand Mother");
            } else if (this.father_relationType.equals("GFTH")) {
                this.binding.tvRlRelation.setText("Grand Father");
            } else if (!this.father_relationType.equalsIgnoreCase("M") || this.father_relationType.equalsIgnoreCase("MOTHER") || this.father_relationType.equalsIgnoreCase("MTHR")) {
                this.binding.tvRlRelation.setText(str10);
            } else if (this.father_relationType.equalsIgnoreCase("F") || this.father_relationType.equalsIgnoreCase("FATHER") || this.father_relationType.equalsIgnoreCase("FTHR")) {
                this.binding.tvRlRelation.setText(str11);
            } else if (this.father_relationType.equalsIgnoreCase("H") || this.father_relationType.equalsIgnoreCase(str8) || this.father_relationType.equalsIgnoreCase(str9)) {
                this.binding.tvRlRelation.setText(str12);
            } else if (this.father_relationType.equalsIgnoreCase(str) || this.father_relationType.equalsIgnoreCase(str15)) {
                this.binding.tvRlRelation.setText(str13);
            } else if (this.father_relationType.equalsIgnoreCase("L") || this.father_relationType.equalsIgnoreCase("OTHER") || this.father_relationType.equalsIgnoreCase(str14)) {
                this.binding.tvRlRelation.setText("Other");
            } else if (TextUtils.isEmpty(this.father_relationType)) {
                this.binding.tvRlRelation.setText("");
            } else {
                this.binding.tvRlRelation.setText(this.father_relationType);
            }
        }
        this.binding.tvRlState.setText(this.father_oldStateName);
        this.binding.tvRlAcName.setText(this.father_oldAcName);
        this.binding.tvRlAcNo.setText(String.valueOf(this.father_oldAcNo));
        this.binding.tvRlPartNo.setText(String.valueOf(this.father_oldPartNumber));
        this.binding.tvRlSrNo.setText(String.valueOf(this.father_oldPartSerialNo));
        this.binding.speakMotherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.motherName);
            }
        });
        this.binding.speakSpouseName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.spouseName);
            }
        });
        this.binding.speakFatherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                enumrationFormActivity.setSpeakText(enumrationFormActivity.binding.fatherName);
            }
        });
        Date date2 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date2);
        calendar3.add(1, -125);
        final long time3 = calendar3.getTime().getTime();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(new Date());
        calendar4.add(1, -18);
        final long time4 = calendar4.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda14
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$0(datePicker, i, i2, i3);
            }
        };
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
            this.faceRecognition = true;
            r9 = 0;
        } else {
            r9 = 0;
            this.faceRecognition = false;
        }
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(onDateSetListener2, time4, time3, view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = EnumrationFormActivity.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                EnumrationFormActivity.this.isMotherEPICValid = false;
                EnumrationFormActivity.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = EnumrationFormActivity.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                EnumrationFormActivity.this.isFatherEPICValid = false;
                EnumrationFormActivity.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = EnumrationFormActivity.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                EnumrationFormActivity.this.isSpouseEPICValid = false;
                EnumrationFormActivity.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass7());
        View viewInflate2 = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate2;
        alertDialogCreate2.getWindow().setBackgroundDrawable(new ColorDrawable(r9));
        this.alertDialog.setCancelable((boolean) r9);
        this.alertDialog.setView(viewInflate2);
        this.relationNameList = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        this.relationCodeList = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameList);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.binding.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    EnumrationFormActivity.this.relationcode = null;
                    EnumrationFormActivity.this.spinner_relation_type_name = "";
                    EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
                    return;
                }
                EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
                EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                enumrationFormActivity.relationcode = enumrationFormActivity.relationCodeList.get(i);
                if (EnumrationFormActivity.this.relationcode.equals("GMTH")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "GrandMother";
                } else if (EnumrationFormActivity.this.relationcode.equals("GFTH")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "GrandFather";
                } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("M") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("MOTHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("MTHR")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "Mother";
                } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("F") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("FATHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("FTHR")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "Father";
                } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("H") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("HUSBAND") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("HSBN")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "Husband";
                } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("W") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("WIFE")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "Wife";
                } else if (EnumrationFormActivity.this.relationcode.equalsIgnoreCase("L") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("OTHER") || EnumrationFormActivity.this.relationcode.equalsIgnoreCase("O")) {
                    EnumrationFormActivity.this.spinner_relation_type_name = "other";
                }
                if (TextUtils.isEmpty(EnumrationFormActivity.this.list_relation_type) || TextUtils.isEmpty(EnumrationFormActivity.this.list_relationname) || TextUtils.isEmpty(EnumrationFormActivity.this.list_relation_type_name) || TextUtils.isEmpty(EnumrationFormActivity.this.spinner_relation_type_name) || !EnumrationFormActivity.this.list_relation_type_name.equalsIgnoreCase(EnumrationFormActivity.this.spinner_relation_type_name)) {
                    return;
                }
                if (!TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) && !TextUtils.isEmpty(EnumrationFormActivity.this.list_relationname)) {
                    EnumrationFormActivity.this.binding.matchingLayout.setVisibility(0);
                    EnumrationFormActivity.this.showResult(NameMatcher.getMatchResult(EnumrationFormActivity.this.list_relationname, TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) ? "" : EnumrationFormActivity.this.father_oldFullName));
                    EnumrationFormActivity.this.binding.tvLeftName.setText(EnumrationFormActivity.this.list_relationname);
                    EnumrationFormActivity.this.binding.tvRightName.setText(TextUtils.isEmpty(EnumrationFormActivity.this.father_oldFullName) ? "" : EnumrationFormActivity.this.father_oldFullName);
                    return;
                }
                EnumrationFormActivity.this.binding.matchingLayout.setVisibility(8);
            }
        });
        this.binding.fatherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    EnumrationFormActivity.this.isFatherEPICValid = false;
                    EnumrationFormActivity.this.binding.fatherName.setEnabled(true);
                    EnumrationFormActivity.this.binding.speakFatherName.setClickable(true);
                }
            }
        });
        this.binding.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    EnumrationFormActivity.this.isMotherEPICValid = false;
                    EnumrationFormActivity.this.binding.motherName.setEnabled(true);
                    EnumrationFormActivity.this.binding.speakMotherName.setClickable(true);
                }
            }
        });
        this.binding.spouseEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    EnumrationFormActivity.this.isSpouseEPICValid = false;
                    EnumrationFormActivity.this.binding.spouseName.setEnabled(true);
                    EnumrationFormActivity.this.binding.speakSpouseName.setClickable(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        initClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.isfirsttimeenter = false;
        this.alertDialog.show();
        getCurrentLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadfrontpagemsg));
        } else {
            pickPhoto(102, "Photo2Form");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(DatePickerDialog.OnDateSetListener onDateSetListener, long j, long j2, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setMinDate(j2);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            choosseCameraOption();
        } else {
            pickFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        if (validate()) {
            submit(0);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7, reason: invalid class name */
    class AnonymousClass7 implements TextWatcher {
        AnonymousClass7() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (EnumrationFormActivity.this.binding.aadharNumber.getText().toString().length() == 12) {
                if (EnumrationFormActivity.this.alertDialog != null) {
                    EnumrationFormActivity.this.alertDialog.dismiss();
                }
                try {
                    String string = EnumrationFormActivity.this.binding.aadharNumber.getText().toString();
                    EnumrationFormActivity.this.result = Verhoeff.validateVerhoeff(string);
                    if (!EnumrationFormActivity.this.result) {
                        EnumrationFormActivity.this.binding.aadharNumber.setText("");
                        EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                        enumrationFormActivity.showDialog1("", enumrationFormActivity.getString(R.string.aadhaarnoerror));
                        if (EnumrationFormActivity.this.alertDialog != null) {
                            EnumrationFormActivity.this.alertDialog.dismiss();
                        }
                    } else {
                        CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                        ?? r1 = EnumrationFormActivity.this;
                        commomUtility.getaadharref(r1, ((EnumrationFormActivity) r1).state, EnumrationFormActivity.this.token, EnumrationFormActivity.this.binding.aadharNumber.getText().toString(), EnumrationFormActivity.this.atkband, EnumrationFormActivity.this.rtkband, "EFForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda2
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str, String str2) {
                                this.f$0.lambda$onTextChanged$5(i, str, str2);
                            }
                        });
                    }
                } catch (Exception e) {
                    Logger.d("", e.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public /* synthetic */ void lambda$onTextChanged$5(int i, String str, String str2) {
            if (i == 401) {
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                ?? r4 = EnumrationFormActivity.this;
                commomUtility.getRefreshToken(r4, ((EnumrationFormActivity) r4).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                    enumrationFormActivity.showDialog1(enumrationFormActivity.invalidaadhar, str2);
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                EnumrationFormActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            EnumrationFormActivity.this.showDialog1(EnumrationFormActivity.this.alertText + i, str2);
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public /* synthetic */ void lambda$onTextChanged$3(int i, String str, String str2) {
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                ?? r11 = EnumrationFormActivity.this;
                commomUtility.showMessageOK(r11, ((EnumrationFormActivity) r11).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
            } else {
                EnumrationFormActivity.this.token = "Bearer " + str;
                EnumrationFormActivity.this.refreshToken = str2;
                SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setToken("Bearer " + str);
                EnumrationFormActivity.this.commomUtility.getaadharref(EnumrationFormActivity.this.getApplicationContext(), EnumrationFormActivity.this.state, EnumrationFormActivity.this.token, EnumrationFormActivity.this.binding.aadharNumber.getText().toString(), EnumrationFormActivity.this.atkband, EnumrationFormActivity.this.rtkband, "EFForm", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setLocaleBool(false);
            EnumrationFormActivity.this.startActivity(new Intent(EnumrationFormActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                    enumrationFormActivity.showDialog1(enumrationFormActivity.invalidaadhar, str2);
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                EnumrationFormActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$7$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$1();
                    }
                }, 2000L);
                return;
            }
            EnumrationFormActivity.this.showDialog1(EnumrationFormActivity.this.alertText + i, str2);
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean submit(int status) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        this.binding.submitButtonRec.setEnabled(false);
        String str = null;
        try {
            Log.d(this.TAG, "eroll dob" + this.dob);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (!TextUtils.isEmpty(this.dob)) {
                str = simpleDateFormat2.format(simpleDateFormat.parse(this.dob));
            }
        } catch (Exception e) {
            Logger.d("Date replace", e.toString());
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.binding.submitButtonRec.setEnabled(true);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.epicNumber);
        map2.put("epicId", this.epicId);
        map2.put("stCode", this.state);
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", this.list_partSerialNo);
        map2.put("selfOldName", this.self_selfOldName);
        map2.put("selfOldEpic", this.self_selfOldEpic);
        map2.put("selfOldRlnName", this.self_selfOldRlnName);
        map2.put("selfOldRlnType", this.self_selfOldRlnType);
        map2.put("rlnPrgyName", this.father_oldFullName);
        map2.put("rlnPrgyEpic", this.father_epicNumber);
        map2.put("rlnPrgyRlnName", this.father_oldRelativeFullName);
        map2.put("rlnPrgyRlnType", this.father_relationType);
        map2.put("mappingType", this.mappedType);
        map2.put("oldStateCd", this.self_OldStateCd);
        map2.put("relationOldStateCd", this.father_oldStateCd);
        map2.put("relationType", this.relationcode);
        map2.put("relationOldAcNo", Integer.valueOf(this.father_oldAcNo));
        map2.put("relationOldPartNo", Integer.valueOf(this.father_oldPartNumber));
        map2.put("relationOldPslNo", Integer.valueOf(this.father_oldPartSerialNo));
        map2.put("epicName", this.list_epicName);
        map2.put("submittedForRecommendation", this.submittedForRecommendation);
        map2.put("aadharNo", this.aadharref);
        map2.put("mobileNo", this.binding.mobileNumber.getText().toString());
        map2.put("fathersOrGuardianName", this.fatherName);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpicNo);
        map2.put("mothersName", this.motherName);
        map2.put("mothersEpicNo", this.motherEpicNo);
        map2.put("spouseName", this.spouseName);
        map2.put("spouseEpicNo", this.spouseEpicNo);
        map2.put("photoUrl", this.photoref);
        map2.put("srFormPage1Url", this.photo1Ref);
        map2.put("srFormPage2Url", this.photo2Ref);
        map2.put("oldAcNo", Integer.valueOf(this.self_oldAcNo));
        map2.put("oldPartNo", Integer.valueOf(this.self_oldPartNumber));
        map2.put("oldPslNo", Integer.valueOf(this.self_oldPartSerialNo));
        map2.put("categoryType", this.self_categoryType);
        map2.put("dobVerified", str);
        map2.put("ageValidationFlag", Integer.valueOf(status));
        map2.put("relativeOldAge", Integer.valueOf(this.rlnprgnyoldage));
        map2.put("oldAge", Integer.valueOf(this.selfoldage));
        map2.put("sirYearSelf", this.sirYearSelf);
        map2.put("sirYearProgeny", this.sirYearProgeny);
        map2.put("eflatitude", this.lat);
        map2.put("eflongitude", this.longi);
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).submitSpecialRevisionSurveyPanIndia(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.12
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        if (EnumrationFormActivity.this.alertDialog != null) {
                            EnumrationFormActivity.this.alertDialog.dismiss();
                        }
                        EnumrationFormActivity.this.binding.submitButtonRec.setEnabled(true);
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        if (response.code() == 422) {
                            Utils utils = EnumrationFormActivity.this.utils;
                            ?? r3 = EnumrationFormActivity.this;
                            utils.decisionDialog(r3, r3.getResources().getString(R.string.alertMsg), string, EnumrationFormActivity.this.getResources().getString(R.string.yes), EnumrationFormActivity.this.getResources().getString(R.string.no), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.12.1
                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                public void onNegativeButtonClicked() {
                                }

                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                public void onPositiveButtonClicked() {
                                    EnumrationFormActivity.this.submit(1);
                                }
                            });
                            return;
                        } else {
                            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                            enumrationFormActivity.showDialog3(enumrationFormActivity.alertText, string);
                            return;
                        }
                    }
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    EnumrationFormActivity.this.binding.submitButtonRec.setEnabled(true);
                    EnumrationFormActivity enumrationFormActivity2 = EnumrationFormActivity.this;
                    enumrationFormActivity2.showDialog3("", enumrationFormActivity2.getString(R.string.formSubmittedMsg));
                } catch (Exception e2) {
                    Logger.d("SpecialRevisionDetails", e2.toString());
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    EnumrationFormActivity.this.binding.submitButtonRec.setEnabled(true);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (EnumrationFormActivity.this.alertDialog != null) {
                    EnumrationFormActivity.this.alertDialog.dismiss();
                }
                EnumrationFormActivity.this.binding.submitButtonRec.setEnabled(true);
            }
        });
        return false;
    }

    private boolean checkSelfEmpty() {
        return this.self_oldAcNo == 0 || this.self_oldPartNumber == 0 || this.self_oldPartSerialNo == 0 || TextUtils.isEmpty(this.self_OldStateCd);
    }

    private boolean checkProgenyEmpty() {
        return this.father_oldAcNo == 0 || this.father_oldPartNumber == 0 || this.father_oldPartSerialNo == 0 || TextUtils.isEmpty(this.father_oldStateCd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$10(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$10(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        if (!TextUtils.isEmpty(this.from) && this.from.equalsIgnoreCase("pendingelector")) {
            Intent intent = new Intent((Context) this, (Class<?>) pendingElectors.class);
            intent.setFlags(67108864);
            intent.putExtra("restart", true);
            startActivity(intent);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.from) && this.from.equalsIgnoreCase("SentBackEroUncollectableListActivity")) {
            Intent intent2 = new Intent((Context) this, (Class<?>) SentBackEroUncollectableListActivity.class);
            intent2.setFlags(67108864);
            intent2.putExtra("restart", true);
            startActivity(intent2);
            finish();
            return;
        }
        Intent intent3 = new Intent((Context) this, (Class<?>) pendingElectorsEpicMatch.class);
        intent3.setFlags(67108864);
        intent3.putExtra("restart", true);
        startActivity(intent3);
        finish();
    }

    private void deleteAnnexure(int code) {
        if (code == 102) {
            this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo1Annexure.setEnabled(true);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.photo1Ref = null;
            this.binding.photo1Name.setText("");
            this.binding.photo2Annexure.setVisibility(0);
        }
        if (code == 103) {
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
            this.binding.photo2Layout.setVisibility(8);
            this.photo2Ref = null;
            this.binding.photo2Size.setText("");
            this.binding.photo2Name.setText("");
            this.binding.photo1Annexure.setVisibility(0);
        }
    }

    private void deletePhoto() {
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.passPhoto.setVisibility(0);
        this.binding.passPhotoLayout.setVisibility(8);
        this.photoref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$11(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$11(View view) {
        onBackPressed();
    }

    public boolean validate() {
        if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
            this.dob = this.binding.dateOfBirth.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString())) {
            this.fatherEpicNo = this.binding.fatherEpicNumber.getText().toString();
        } else {
            this.fatherEpicNo = "";
        }
        if (!TextUtils.isEmpty(this.binding.fatherName.getText().toString())) {
            this.fatherName = this.binding.fatherName.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString())) {
            this.motherEpicNo = this.binding.motherEpicNumber.getText().toString();
        } else {
            this.motherEpicNo = "";
        }
        if (!TextUtils.isEmpty(this.binding.motherName.getText().toString())) {
            this.motherName = this.binding.motherName.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString())) {
            this.spouseEpicNo = this.binding.spouseEpicNumber.getText().toString();
        } else {
            this.spouseEpicNo = "";
        }
        if (!TextUtils.isEmpty(this.binding.spouseName.getText().toString())) {
            this.spouseName = this.binding.spouseName.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.aadharNumber.getText().toString()) && this.binding.aadharNumber.getText().toString().length() < 12) {
            showDialog1(this.alertText, getString(R.string.invalidAadharMsg2));
            return false;
        }
        if (!this.binding.mobileNumber.getText().toString().isEmpty() && (this.binding.mobileNumber.getText().toString().length() != 10 || !this.binding.mobileNumber.getText().toString().matches(RegexMatcher.MOBILE_REGEX))) {
            showDialog1(this.alertText, getString(R.string.incorrecMobileMsg));
            return false;
        }
        if (TextUtils.isEmpty(this.binding.fatherName.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.father_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString()) && !this.isFatherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_father_verification));
            return false;
        }
        if (TextUtils.isEmpty(this.binding.motherName.getText().toString())) {
            showDialog1(this.alertText, getString(R.string.mother_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString()) && !this.isMotherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_mother_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString()) && !this.isSpouseEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_Spouse_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString()) && this.binding.fatherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.motherEpicNumber.getText().toString())) {
            showDialog1(this.alertText, "Father and mother EPIC should be different");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString()) && this.binding.fatherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.spouseEpicNumber.getText().toString())) {
            showDialog1(this.alertText, "Father and spouse EPIC should be different");
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString()) && !TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString()) && this.binding.motherEpicNumber.getText().toString().equalsIgnoreCase(this.binding.spouseEpicNumber.getText().toString())) {
            showDialog1(this.alertText, "Mother and spouse EPIC should be different");
            return false;
        }
        if (this.binding.relationtypecardview.getVisibility() == 0 && TextUtils.isEmpty(this.relationcode)) {
            showDialog1(this.alertText, getString(R.string.relative_2003_spinnerErroe));
            return false;
        }
        if (!TextUtils.isEmpty(this.photo1Ref)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = "tempTest_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$12(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$12(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).cropSquare().compress(512).maxResultSize(1028, 1028).cameraOnly().start(100);
            return;
        }
        if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, String listCode) {
        this.currentImagePickerId = code;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.epicNumber.replaceAll("/", "_") + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$13(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$13(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).crop().compress(512).maxResultSize(1028, 1028).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
        new Date();
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str = "img_" + code + this.jpgTextBaseActivity;
            this.saveImageFileName = str;
            Logger.d(this.TAG, str);
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + code + this.pdfTextBaseActivity;
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        }
        File file2 = new File(file, this.saveImageFileName);
        byte[] bArrDecode = Base64.decode(fileNameBase64, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$14(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$14(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$15(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$16(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$15(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$16(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialogSelfProgeny(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialogSelfProgeny$17(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogSelfProgeny$17(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        finish();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:115:0x03a3 A[Catch: Exception -> 0x0591, TRY_ENTER, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x03f1 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0406 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0448 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0463 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0467 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x047d A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x04a9 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x04cf A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x04da A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x04ee A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0514 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0518 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x052e A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0558 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0579 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0586 A[Catch: Exception -> 0x0591, TryCatch #5 {Exception -> 0x0591, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0582, B:131:0x04cf, B:127:0x047d, B:132:0x04da, B:134:0x04ee, B:135:0x0514, B:137:0x0518, B:139:0x0548, B:141:0x0558, B:142:0x0579, B:138:0x052e, B:144:0x0586, B:145:0x0590, B:119:0x0406), top: B:159:0x03a1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v18 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v31 */
    /* JADX WARN: Type inference failed for: r27v32 */
    /* JADX WARN: Type inference failed for: r27v33 */
    /* JADX WARN: Type inference failed for: r27v34 */
    /* JADX WARN: Type inference failed for: r27v35 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r35v1 */
    /* JADX WARN: Type inference failed for: r35v11 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v13 */
    /* JADX WARN: Type inference failed for: r35v14 */
    /* JADX WARN: Type inference failed for: r35v15 */
    /* JADX WARN: Type inference failed for: r35v16 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v3 */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARN: Type inference failed for: r35v7 */
    /* JADX WARN: Type inference failed for: r35v8 */
    /* JADX WARN: Type inference failed for: r35v9 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.Context, androidx.appcompat.app.AppCompatActivity, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r35;
        ?? r27;
        String str;
        Uri uri;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        long j;
        ?? r13;
        double dRound;
        File file;
        Uri uri2;
        ?? r36;
        ?? r28;
        ?? r37;
        ?? r29;
        Object obj;
        ?? r15;
        Object obj2;
        ?? r16;
        ?? r38;
        Object obj3;
        ?? r17;
        String str2;
        Object obj4;
        int i3 = i2;
        super.onActivityResult(i, i2, intent);
        ?? r18 = 80;
        if (i3 != -1) {
            r35 = "KB";
            i3 = i;
            r27 = "img_";
            str = "/";
            if (i3 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.binding.photo1Annexure.setVisibility(0);
                this.binding.photo2Annexure.setVisibility(0);
            }
            uri = null;
        } else {
            Uri data = i == 10001 ? null : intent.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.pdfbyteArray = byteArray;
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp);
                r28 = saveImagePath2;
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(r28, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                    String str3 = strArrSplit2[strArrSplit2.length - 1];
                    if (i != 101) {
                        uri2 = data;
                        str2 = "KB";
                        obj4 = "img_";
                        str = "/";
                        i3 = i;
                        if (i3 == 102) {
                            try {
                                r17 = str2;
                                obj2 = obj4;
                                long j2 = this.filesize;
                                if (j2 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                    this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                    if (this.filesize != 0) {
                                        this.binding.photo2Size.setText(this.filesize + str2);
                                        r17 = str2;
                                        obj2 = obj4;
                                    } else {
                                        this.binding.photo2Size.setVisibility(8);
                                        r17 = str2;
                                        obj2 = obj4;
                                    }
                                } else if (j2 > 2048) {
                                    this.binding.photo2Layout.setVisibility(8);
                                    this.binding.cancelPhoto2Annexure.setVisibility(8);
                                    this.binding.photo2Name.setVisibility(8);
                                    this.binding.photo2Size.setVisibility(8);
                                    this.binding.photo2.setVisibility(8);
                                    this.binding.photo2Annexure.setEnabled(true);
                                    this.binding.photo1Annexure.setVisibility(0);
                                    this.binding.photo2Annexure.setVisibility(0);
                                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                                    r17 = str2;
                                    obj2 = obj4;
                                } else {
                                    long j3 = j2 / 1024;
                                    this.filesize = j3;
                                    double dRound2 = Math.round(j3 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.photo2Annexure.setEnabled(true);
                                        showDialog1(this.alertText, this.imgmsg);
                                        r17 = str2;
                                        obj2 = obj4;
                                    } else {
                                        String str4 = str2;
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                        if (dRound2 != 0.0d) {
                                            this.binding.photo2Size.setText(dRound2 + "MB");
                                            obj3 = obj4;
                                            r38 = str4;
                                        } else {
                                            this.binding.photo2Size.setVisibility(8);
                                            obj3 = obj4;
                                            r38 = str4;
                                        }
                                    }
                                }
                                r17 = str2;
                                obj2 = obj4;
                                r38 = r17;
                                obj3 = obj2;
                            } catch (Exception e) {
                                e = e;
                                r16 = str2;
                                r28 = obj4;
                                r36 = r16;
                                Logger.d("", e.getMessage());
                                r29 = r28;
                                r37 = r36;
                            }
                        } else {
                            r17 = str2;
                            obj2 = obj4;
                            r38 = r17;
                            obj3 = obj2;
                        }
                        cursorQuery2.close();
                        r29 = obj3;
                        r37 = r38;
                    } else {
                        try {
                            long j4 = this.filesize;
                            try {
                                if (j4 < 1024) {
                                    try {
                                        uri2 = data;
                                        str = "/";
                                        String str5 = "KB";
                                        try {
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                            this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                            if (this.filesize != 0) {
                                                String str6 = str5;
                                                this.binding.photo1Size.setText(this.filesize + str6);
                                                r15 = str6;
                                            } else {
                                                r15 = str5;
                                                this.binding.photo1Size.setVisibility(8);
                                            }
                                            i3 = i;
                                            obj2 = "img_";
                                            r17 = r15;
                                        } catch (Exception e2) {
                                            e = e2;
                                            i3 = i;
                                            r28 = "img_";
                                            r36 = str5;
                                            Logger.d("", e.getMessage());
                                            r29 = r28;
                                            r37 = r36;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        uri2 = data;
                                        r18 = "KB";
                                        str = "/";
                                        i3 = i;
                                        r28 = "img_";
                                        r16 = r18;
                                        r36 = r16;
                                    }
                                } else {
                                    uri2 = data;
                                    r18 = "KB";
                                    str = "/";
                                    if (j4 > 2048) {
                                        try {
                                            this.binding.annexPage1Layout.setVisibility(8);
                                            this.binding.cancelPhoto1Annexure.setVisibility(8);
                                            this.binding.photo1Name.setVisibility(8);
                                            this.binding.photo1Size.setVisibility(8);
                                            this.binding.photo1.setVisibility(8);
                                            this.binding.photo1Annexure.setEnabled(true);
                                            this.binding.photo1Annexure.setVisibility(0);
                                            this.binding.photo2Annexure.setVisibility(0);
                                            showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                                            r15 = r18;
                                            i3 = i;
                                            obj2 = "img_";
                                            r17 = r15;
                                        } catch (Exception e4) {
                                            e = e4;
                                            i3 = i;
                                            r28 = "img_";
                                            r16 = r18;
                                            r36 = r16;
                                            Logger.d("", e.getMessage());
                                            r29 = r28;
                                            r37 = r36;
                                        }
                                    } else {
                                        try {
                                            long j5 = j4 / 1024;
                                            this.filesize = j5;
                                            double dRound3 = Math.round(j5 * 100.0d) / 100.0d;
                                            if (dRound3 > 2.0d) {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.photo1Annexure.setEnabled(true);
                                                showDialog1(this.alertText, this.imgmsg);
                                                obj = "img_";
                                            } else {
                                                try {
                                                    obj = "img_";
                                                    try {
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                            if (dRound3 != 0.0d) {
                                                                this.binding.photo1Size.setText(dRound3 + "MB");
                                                            } else {
                                                                this.binding.photo1Size.setVisibility(8);
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            i3 = i;
                                                            r16 = r18;
                                                            r28 = obj;
                                                            r36 = r16;
                                                            Logger.d("", e.getMessage());
                                                            r29 = r28;
                                                            r37 = r36;
                                                        }
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        i3 = i;
                                                        r16 = r18;
                                                        r28 = obj;
                                                        r36 = r16;
                                                        Logger.d("", e.getMessage());
                                                        r29 = r28;
                                                        r37 = r36;
                                                        uri = uri2;
                                                        r27 = r29;
                                                        r35 = r37;
                                                        if (i3 != 100) {
                                                        }
                                                        try {
                                                            if (i3 == 10001) {
                                                                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                                this.saveImageFileName = ((String) r27) + this.temp + this.jpgTextBaseActivity;
                                                                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                                if (file.exists()) {
                                                                    Log.e("extract", "extract true");
                                                                }
                                                                BitmapFactory.decodeFile(file.getAbsolutePath());
                                                                this.filesize = file.length() / 1024;
                                                            } else {
                                                                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                                                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                                bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                                                                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                                                this.byteArray = byteArray2;
                                                                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray2, 0), this.img, this.temp);
                                                            }
                                                            cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                                            if (cursorQuery.getCount() > 0) {
                                                                cursorQuery.close();
                                                                throw new IllegalArgumentException(this.imgmsg);
                                                            }
                                                            cursorQuery.moveToFirst();
                                                            strArrSplit = saveImagePath.getPath().split(str);
                                                            Log.e("extract", strArrSplit[strArrSplit.length - 1]);
                                                            j = this.filesize;
                                                            if (j < 1024) {
                                                                if (this.faceRecognition) {
                                                                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                } else {
                                                                    this.alertDialog.dismiss();
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                }
                                                                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                if (this.filesize != 0) {
                                                                    this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                                                                    this.binding.photoSize.setVisibility(0);
                                                                } else {
                                                                    this.binding.photoSize.setVisibility(8);
                                                                }
                                                            } else {
                                                                r13 = r35;
                                                                long j6 = j / 1024;
                                                                this.filesize = j6;
                                                                dRound = Math.round(j6 * 100.0d) / 100.0d;
                                                                if (dRound > 2.0d) {
                                                                    this.binding.passPhotoLayout.setVisibility(8);
                                                                    this.binding.chooseFileTv.setEnabled(true);
                                                                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    if (this.faceRecognition) {
                                                                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    } else {
                                                                        this.alertDialog.dismiss();
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                                                    }
                                                                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                                    if (dRound != 0.0d) {
                                                                        this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r13).toString());
                                                                        this.binding.photoSize.setVisibility(0);
                                                                    } else {
                                                                        this.binding.photoSize.setVisibility(8);
                                                                    }
                                                                }
                                                            }
                                                            cursorQuery.close();
                                                        } catch (Exception e7) {
                                                            Logger.d("tag", e7.getMessage());
                                                            return;
                                                        }
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    obj = "img_";
                                                }
                                            }
                                            i3 = i;
                                            r17 = r18;
                                            obj2 = obj;
                                        } catch (Exception e9) {
                                            e = e9;
                                            obj = "img_";
                                        }
                                    }
                                }
                                r17 = str2;
                                obj2 = obj4;
                                r38 = r17;
                                obj3 = obj2;
                                cursorQuery2.close();
                                r29 = obj3;
                                r37 = r38;
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            uri2 = data;
                            r18 = "KB";
                            obj = "img_";
                            str = "/";
                        }
                    }
                    uri = uri2;
                    r27 = r29;
                    r35 = r37;
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                uri2 = data;
                r36 = "KB";
                i3 = i;
                r28 = "img_";
                str = "/";
            }
            Logger.d("", e.getMessage());
            r29 = r28;
            r37 = r36;
            uri = uri2;
            r27 = r29;
            r35 = r37;
        }
        if ((i3 != 100 || i3 == 10001) && i2 == -1) {
            if (i3 == 10001) {
                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                this.saveImageFileName = ((String) r27) + this.temp + this.jpgTextBaseActivity;
                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                if (file.exists()) {
                    Log.e("extract", "extract true");
                }
                BitmapFactory.decodeFile(file.getAbsolutePath());
                this.filesize = file.length() / 1024;
            } else {
                Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                bitmap3.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream3);
                byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
                this.byteArray = byteArray3;
                saveImagePath = getSaveImagePath(Base64.encodeToString(byteArray3, 0), this.img, this.temp);
            }
            cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            strArrSplit = saveImagePath.getPath().split(str);
            Log.e("extract", strArrSplit[strArrSplit.length - 1]);
            j = this.filesize;
            if (j < 1024) {
                if (this.faceRecognition) {
                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                } else {
                    this.alertDialog.dismiss();
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                }
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                if (this.filesize != 0) {
                    this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                    this.binding.photoSize.setVisibility(0);
                } else {
                    this.binding.photoSize.setVisibility(8);
                }
            } else {
                r13 = r35;
                long j7 = j / 1024;
                this.filesize = j7;
                dRound = Math.round(j7 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.passPhotoLayout.setVisibility(8);
                    this.binding.chooseFileTv.setEnabled(true);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
                    showDialog1(this.alertText, this.imgmsg);
                } else {
                    if (this.faceRecognition) {
                        faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    } else {
                        this.alertDialog.dismiss();
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    }
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    if (dRound != 0.0d) {
                        this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r13).toString());
                        this.binding.photoSize.setVisibility(0);
                    } else {
                        this.binding.photoSize.setVisibility(8);
                    }
                }
            }
            cursorQuery.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        Call<JsonObject> callFaceRecognitionApi = restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType")));
        this.alertDialog.show();
        callFaceRecognitionApi.enqueue(new AnonymousClass13(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass13(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                Context applicationContext = EnumrationFormActivity.this.getApplicationContext();
                String str = EnumrationFormActivity.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$13$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                EnumrationFormActivity.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(EnumrationFormActivity.this.photostr)) {
                    EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                    enumrationFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, enumrationFormActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                EnumrationFormActivity.this.binding.passPhoto.setVisibility(0);
                EnumrationFormActivity.this.binding.chooseFileTv.setEnabled(true);
                EnumrationFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(EnumrationFormActivity.this.whitecolor));
                new JSONObject(response.errorBody().string());
                EnumrationFormActivity enumrationFormActivity2 = EnumrationFormActivity.this;
                enumrationFormActivity2.showDialog1(enumrationFormActivity2.alertText, EnumrationFormActivity.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                ?? r2 = EnumrationFormActivity.this;
                commomUtility.showMessageOK(r2, ((EnumrationFormActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                EnumrationFormActivity.this.alertDialog.dismiss();
                return;
            }
            EnumrationFormActivity.this.alertDialog.dismiss();
            EnumrationFormActivity.this.token = "Bearer " + str8;
            EnumrationFormActivity.this.refreshToken = str9;
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
            enumrationFormActivity.faceRecognition(str, str2, str3, str4, str5, enumrationFormActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setLocaleBool(false);
            EnumrationFormActivity.this.startActivity(new Intent(EnumrationFormActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(8);
            EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(8);
            EnumrationFormActivity.this.binding.passPhoto.setVisibility(0);
            EnumrationFormActivity.this.binding.chooseFileTv.setEnabled(true);
            EnumrationFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(EnumrationFormActivity.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            EnumrationFormActivity.this.showDialog1("Error!", t.getMessage());
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
        }
    }

    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        try {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            String strSubstring = captureFileName.substring(captureFileName.lastIndexOf("."));
            this.mime = "";
            if (".jpg".equalsIgnoreCase(strSubstring) || ".png".equalsIgnoreCase(strSubstring) || ".jpeg".equalsIgnoreCase(strSubstring)) {
                this.mime = "image/jpeg";
            } else if (".pdf".equalsIgnoreCase(strSubstring)) {
                this.mime = "application/pdf";
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("currentRole", "blo");
            map.put("state", this.state);
            map.put("Content-Type", "application/json");
            map.put("userId", SharedPref.getInstance(getApplicationContext()).getUserName());
            String mD5Checksum = UploadWithPreSignedURL.getMD5Checksum(new File(filepath + captureFileName));
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.epicNumber);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass14(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass14(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v26, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                EnumrationFormActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                ?? r13 = EnumrationFormActivity.this;
                String str = ((EnumrationFormActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$14$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                EnumrationFormActivity.this.alertDialog.dismiss();
                JsonResponse jsonResponse = (JsonResponse) new Gson().fromJson(response.errorBody().toString(), JsonResponse.class);
                if (jsonResponse.getPayload() != null) {
                    Object payload = jsonResponse.getPayload();
                    jsonResponse.getRefId();
                    if (payload instanceof Map) {
                        Map map = (Map) payload;
                        Double d = (Double) map.get("retryTime");
                        Long lValueOf = Long.valueOf(Math.round(d.doubleValue() * 1000.0d));
                        System.out.println("Retry time : " + lValueOf);
                        try {
                            Thread.sleep(lValueOf.longValue());
                        } catch (Exception unused) {
                        }
                        EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                        enumrationFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, enumrationFormActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UploadWithPreSignedURL.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(EnumrationFormActivity.this.photostr)) {
                        EnumrationFormActivity.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        EnumrationFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, EnumrationFormActivity.this.photoref);
                    }
                    if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo1Str)) {
                        EnumrationFormActivity.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        EnumrationFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, EnumrationFormActivity.this.photo1Ref);
                    }
                    if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo2str)) {
                        EnumrationFormActivity.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        EnumrationFormActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, EnumrationFormActivity.this.photo2Ref);
                    }
                    Logger.d(EnumrationFormActivity.this.TAG, "Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    EnumrationFormActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photostr)) {
                if (EnumrationFormActivity.this.alertDialog != null) {
                    EnumrationFormActivity.this.alertDialog.dismiss();
                }
                EnumrationFormActivity.this.photocount = 0;
                EnumrationFormActivity.this.binding.chooseFileTv.setEnabled(true);
                EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                EnumrationFormActivity.this.binding.passPhoto.setVisibility(0);
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo1Str)) {
                if (EnumrationFormActivity.this.alertDialog != null) {
                    EnumrationFormActivity.this.alertDialog.dismiss();
                }
                EnumrationFormActivity.this.photo1count = 0;
                EnumrationFormActivity.this.binding.annexPage1Layout.setVisibility(8);
                EnumrationFormActivity.this.binding.photo1Annexure.setEnabled(true);
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo2str)) {
                if (EnumrationFormActivity.this.alertDialog != null) {
                    EnumrationFormActivity.this.alertDialog.dismiss();
                }
                EnumrationFormActivity.this.photo2count = 0;
                EnumrationFormActivity.this.binding.photo2Annexure.setEnabled(true);
                EnumrationFormActivity.this.binding.photo2Layout.setVisibility(8);
            }
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                Logger.d("", jSONObject2.toString());
                String string = jSONObject2.getString("message");
                EnumrationFormActivity enumrationFormActivity2 = EnumrationFormActivity.this;
                enumrationFormActivity2.showDialog1(enumrationFormActivity2.alertText, string);
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = EnumrationFormActivity.this.commomUtility;
                ?? r2 = EnumrationFormActivity.this;
                commomUtility.showMessageOK(r2, ((EnumrationFormActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$14$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            EnumrationFormActivity.this.alertDialog.dismiss();
            EnumrationFormActivity.this.token = "Bearer " + str8;
            EnumrationFormActivity.this.refreshToken = str9;
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
            enumrationFormActivity.uploadPhoto(str, str2, str3, str4, str5, enumrationFormActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setLocaleBool(false);
            EnumrationFormActivity.this.startActivity(new Intent((Context) EnumrationFormActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (EnumrationFormActivity.this.alertDialog != null) {
                EnumrationFormActivity.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photostr)) {
                if (EnumrationFormActivity.this.photocount < 2 && TextUtils.isEmpty(EnumrationFormActivity.this.photoref)) {
                    EnumrationFormActivity.this.photocount++;
                    EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                    enumrationFormActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, enumrationFormActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    EnumrationFormActivity.this.photocount = 0;
                    EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(8);
                    EnumrationFormActivity.this.binding.passPhoto.setVisibility(0);
                    EnumrationFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(EnumrationFormActivity.this.whitecolor));
                    EnumrationFormActivity.this.binding.chooseFileTv.setEnabled(true);
                    EnumrationFormActivity enumrationFormActivity2 = EnumrationFormActivity.this;
                    enumrationFormActivity2.showDialog1(enumrationFormActivity2.alertText, EnumrationFormActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo1Str)) {
                if (EnumrationFormActivity.this.photo1count < 2 && TextUtils.isEmpty(EnumrationFormActivity.this.photo1Ref)) {
                    EnumrationFormActivity.this.photo1count++;
                    EnumrationFormActivity enumrationFormActivity3 = EnumrationFormActivity.this;
                    enumrationFormActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, enumrationFormActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    EnumrationFormActivity.this.photo1count = 0;
                    EnumrationFormActivity.this.binding.annexPage1Layout.setVisibility(8);
                    EnumrationFormActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(EnumrationFormActivity.this.blackColor));
                    EnumrationFormActivity.this.binding.photo1Annexure.setEnabled(true);
                    EnumrationFormActivity enumrationFormActivity4 = EnumrationFormActivity.this;
                    enumrationFormActivity4.showDialog1(enumrationFormActivity4.alertText, EnumrationFormActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(EnumrationFormActivity.this.photo2str)) {
                if (EnumrationFormActivity.this.photo2count < 2 && TextUtils.isEmpty(EnumrationFormActivity.this.photo2Ref)) {
                    EnumrationFormActivity.this.photo2count++;
                    EnumrationFormActivity enumrationFormActivity5 = EnumrationFormActivity.this;
                    enumrationFormActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, enumrationFormActivity5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                EnumrationFormActivity.this.photo2count = 0;
                EnumrationFormActivity.this.binding.photo2Layout.setVisibility(8);
                EnumrationFormActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(EnumrationFormActivity.this.blackColor));
                EnumrationFormActivity.this.binding.photo2Annexure.setEnabled(true);
                EnumrationFormActivity enumrationFormActivity6 = EnumrationFormActivity.this;
                enumrationFormActivity6.showDialog1(enumrationFormActivity6.alertText, EnumrationFormActivity.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$18(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$18(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
            Intent intent2 = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent2.putExtra("camera_type_configuration", "back");
            intent2.putExtra("temp", this.temp);
            startActivityForResult(intent2, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkEpicNumber(String epicEditText, String from) {
        HashMap map = new HashMap();
        map.put("epicNumber", epicEditText);
        CommomUtility commomUtility = new CommomUtility();
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass15(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass15(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v31, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
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
        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            String asString = "";
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                JsonArray jsonArray = (JsonArray) response.body();
                JsonElement jsonElement = jsonArray.get(0).getAsJsonObject().get("content");
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    return;
                }
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                String asString2 = (!asJsonObject.has("applicantFirstName") || asJsonObject.get("applicantFirstName").isJsonNull()) ? "" : asJsonObject.get("applicantFirstName").getAsString();
                if (asJsonObject.has("applicantLastName") && !asJsonObject.get("applicantLastName").isJsonNull()) {
                    asString = asJsonObject.get("applicantLastName").getAsString();
                }
                String str = asString2 + StringUtils.SPACE + asString;
                Logger.d(EnumrationFormActivity.this.TAG, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                Toast.makeText((Context) EnumrationFormActivity.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    EnumrationFormActivity.this.isMotherEPICValid = true;
                    EnumrationFormActivity.this.binding.motherName.setText(str);
                    EnumrationFormActivity.this.binding.motherName.setEnabled(false);
                    EnumrationFormActivity.this.binding.speakMotherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    EnumrationFormActivity.this.isFatherEPICValid = true;
                    EnumrationFormActivity.this.binding.fatherName.setText(str);
                    EnumrationFormActivity.this.binding.fatherName.setEnabled(false);
                    EnumrationFormActivity.this.binding.speakFatherName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Spouse")) {
                    EnumrationFormActivity.this.isSpouseEPICValid = true;
                    EnumrationFormActivity.this.binding.spouseName.setText(str);
                    EnumrationFormActivity.this.binding.spouseName.setEnabled(false);
                    EnumrationFormActivity.this.binding.speakSpouseName.setClickable(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Relative")) {
                    EnumrationFormActivity.this.isRelativeEPICValid = true;
                    return;
                }
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r11 = EnumrationFormActivity.this;
                String str2 = ((EnumrationFormActivity) r11).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str3 = this.val$epicEditText;
                final String str4 = this.val$from;
                commomUtility.getRefreshToken(r11, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$15$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str3, str4, i, str5, str6);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                EnumrationFormActivity.this.binding.motherEpicNumber.setText("");
                EnumrationFormActivity.this.binding.motherName.setEnabled(true);
                EnumrationFormActivity.this.binding.speakMotherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                EnumrationFormActivity.this.binding.fatherEpicNumber.setText("");
                EnumrationFormActivity.this.binding.fatherName.setEnabled(true);
                EnumrationFormActivity.this.binding.speakFatherName.setClickable(true);
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                EnumrationFormActivity.this.binding.spouseEpicNumber.setText("");
                EnumrationFormActivity.this.binding.spouseName.setEnabled(true);
                EnumrationFormActivity.this.binding.speakSpouseName.setClickable(true);
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(EnumrationFormActivity.this.messageString);
                Logger.d(EnumrationFormActivity.this.TAG, strOptString);
                Toast.makeText((Context) EnumrationFormActivity.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(EnumrationFormActivity.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) EnumrationFormActivity.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r10 = EnumrationFormActivity.this;
                    Toast.makeText((Context) r10, r10.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(EnumrationFormActivity.this.TAG, EnumrationFormActivity.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                ?? r5 = EnumrationFormActivity.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            EnumrationFormActivity.this.token = EnumrationFormActivity.this.bearerText + str3;
            EnumrationFormActivity.this.refreshToken = str4;
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setToken(EnumrationFormActivity.this.bearerText + str3);
            EnumrationFormActivity.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(EnumrationFormActivity.this.getApplicationContext()).setLocaleBool(false);
            EnumrationFormActivity.this.startActivity(new Intent((Context) EnumrationFormActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(EnumrationFormActivity.this.TAG, t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpeakText(final EditText editText) {
        this.utils.showVoicePopup(this, new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.16
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
            public void onCallBack(String result) {
                editText.setText(result);
            }
        });
    }

    public void resetImage(String imagetyype, String error) {
        if (imagetyype.equals(this.photostr)) {
            this.photoref = "";
            this.binding.image.setVisibility(8);
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
        }
        if (imagetyype.equals(this.photo1Str)) {
            this.photo1Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Annexure.setVisibility(0);
            this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo1Annexure.setEnabled(true);
        }
        if (imagetyype.equals(this.photo2str)) {
            this.photo2Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.photo2Layout.setVisibility(8);
            this.binding.photo2Annexure.setVisibility(0);
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.17
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(EnumrationFormActivity.this.photostr)) {
                        EnumrationFormActivity.this.binding.passPhotoLayout.setVisibility(0);
                        EnumrationFormActivity.this.binding.passPhoto.setVisibility(8);
                        EnumrationFormActivity.this.binding.cancel.setVisibility(0);
                        EnumrationFormActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(EnumrationFormActivity.this.greycolor));
                        EnumrationFormActivity.this.binding.chooseFileTv.setEnabled(false);
                        EnumrationFormActivity.this.binding.photoNameTv2.setVisibility(0);
                        EnumrationFormActivity.this.binding.image.setVisibility(0);
                        Glide.with(EnumrationFormActivity.this).load(strReplace).into(EnumrationFormActivity.this.binding.image);
                    }
                    if (uploadType.equals(EnumrationFormActivity.this.photo1Str)) {
                        EnumrationFormActivity.this.binding.annexPage1Layout.setVisibility(0);
                        EnumrationFormActivity.this.binding.cancelPhoto1Annexure.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo1Name.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo1Size.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo1.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(EnumrationFormActivity.this.greycolor));
                        EnumrationFormActivity.this.binding.photo1Annexure.setEnabled(false);
                        Glide.with(EnumrationFormActivity.this).load(strReplace).listener(new RequestListener<Drawable>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.17.1
                            public /* bridge */ /* synthetic */ boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                                return onResourceReady((Drawable) resource, model, (Target<Drawable>) target, dataSource, isFirstResource);
                            }

                            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                Log.e("Glide", "Load failed for: " + model, e);
                                if (e == null || e.getRootCauses() == null) {
                                    return false;
                                }
                                for (Throwable th : e.getRootCauses()) {
                                    Log.e("Glide", "Cause: " + th.getMessage(), th);
                                }
                                return false;
                            }

                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                Log.d("Glide", "Loaded OK from " + dataSource + " : " + model);
                                return false;
                            }
                        }).error(R.drawable.blo_ic_baseline_error_24).placeholder(R.drawable.blo_dummy_image).into(EnumrationFormActivity.this.binding.photo1);
                    }
                    if (uploadType.equals(EnumrationFormActivity.this.photo2str)) {
                        EnumrationFormActivity.this.binding.photo2Layout.setVisibility(0);
                        EnumrationFormActivity.this.binding.cancelPhoto2Annexure.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo2Name.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo2Size.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo2.setVisibility(0);
                        EnumrationFormActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(EnumrationFormActivity.this.greycolor));
                        EnumrationFormActivity.this.binding.photo2Annexure.setEnabled(false);
                        Glide.with(EnumrationFormActivity.this).load(strReplace).into(EnumrationFormActivity.this.binding.photo2);
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    EnumrationFormActivity enumrationFormActivity = EnumrationFormActivity.this;
                    enumrationFormActivity.showDialog1(enumrationFormActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(EnumrationFormActivity.this.messageString);
                    Logger.e(EnumrationFormActivity.this.TAG, strOptString);
                    EnumrationFormActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(EnumrationFormActivity.this.TAG, e.getMessage());
                    EnumrationFormActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                EnumrationFormActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase(this.photostr)) {
            int i = this.getImage1Count;
            if (i < 2) {
                this.getImage1Count = i + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.getImage1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo1Str)) {
            int i2 = this.getImage2Count;
            if (i2 < 2) {
                this.getImage2Count = i2 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog2 = this.alertDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                this.getImage2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo2str)) {
            int i3 = this.getImage3Count;
            if (i3 < 2) {
                this.getImage3Count = i3 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog3 = this.alertDialog;
            if (alertDialog3 != null) {
                alertDialog3.dismiss();
            }
            this.getImage3Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.18
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (EnumrationFormActivity.this.alertDialog != null) {
                        EnumrationFormActivity.this.alertDialog.dismiss();
                    }
                    EnumrationFormActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(EnumrationFormActivity.this.photostr)) {
                            EnumrationFormActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(EnumrationFormActivity.this.photo1Str)) {
                            EnumrationFormActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(EnumrationFormActivity.this.photo2str)) {
                            EnumrationFormActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$20, reason: invalid class name */
    static /* synthetic */ class AnonymousClass20 {
        static final /* synthetic */ int[] $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType;

        static {
            int[] iArr = new int[NameMatcher.MatchType.values().length];
            $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType = iArr;
            try {
                iArr[NameMatcher.MatchType.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.TOKEN_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.PARTIAL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.PARTIAL_WEAK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.NO_MATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResult(NameMatcher.MatchResult result) {
        int color;
        int i = AnonymousClass20.$SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[result.type.ordinal()];
        if (i == 1) {
            color = Color.parseColor("#2E7D32");
        } else if (i == 2) {
            color = Color.parseColor("#43A047");
        } else if (i == 3) {
            color = Color.parseColor("#FBC02D");
        } else if (i == 4) {
            color = Color.parseColor("#FB8C00");
        } else {
            color = Color.parseColor("#D32F2F");
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.binding.progressBar, "progress", this.binding.progressBar.getProgress(), result.score);
        objectAnimatorOfInt.setDuration(800L);
        objectAnimatorOfInt.start();
        this.binding.progressBar.setProgressTintList(ColorStateList.valueOf(color));
        this.binding.progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(color));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity.19
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(EnumrationFormActivity.this).removeLocationUpdates(this);
                        if (locationResult != null && !locationResult.getLocations().isEmpty()) {
                            int size = locationResult.getLocations().size() - 1;
                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                            Double.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                            EnumrationFormActivity.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                            EnumrationFormActivity.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                            Logger.d("latitude and longitudezz", EnumrationFormActivity.this.lat + "  " + EnumrationFormActivity.this.longi);
                            if (EnumrationFormActivity.this.isfirsttimeenter) {
                                return;
                            }
                            if (EnumrationFormActivity.this.alertDialog != null) {
                                EnumrationFormActivity.this.alertDialog.dismiss();
                            }
                            EnumrationFormActivity.this.pickPhoto(101, "photo1Form");
                            return;
                        }
                        Toast.makeText((Context) EnumrationFormActivity.this, (CharSequence) "Unable to fetch location. Please try again.", 0).show();
                    }
                }, Looper.getMainLooper());
                return;
            }
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            turnOnGPS();
            return;
        }
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda9
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$19(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$19(Task task) {
        try {
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException e2) {
                Logger.d("", e2.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == 0) {
            if (requestCode == 1) {
                this.isfirsttimeenter = false;
                this.alertDialog.show();
                getCurrentLocation();
                return;
            }
            return;
        }
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.isfirsttimeenter) {
            return;
        }
        checkLocationPermission();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkLocationPermission() {
        new android.app.AlertDialog.Builder(this).setTitle("request Permission").setMessage("Kindly Allow Location Permission").setCancelable(false).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkLocationPermission$20(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationPermission$20(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, getPackageName(), null));
        startActivity(intent);
    }
}
