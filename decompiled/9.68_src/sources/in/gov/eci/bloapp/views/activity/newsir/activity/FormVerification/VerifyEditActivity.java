package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.DatePickerDialog;
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
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityVerifyEditBinding;
import in.gov.eci.bloapp.pdfDownloadCallback;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback;
import in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import kotlin.UByte;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VerifyEditActivity extends AppCompatActivity {
    String No;
    private String SESSION;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivityVerifyEditBinding binding;
    byte[] byteArray;
    DatePickerDialog.OnDateSetListener date;
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
    FormverificationPayload formverificationPayload;
    String lastSirYear;
    String list_epicName;
    String list_partSerialNo;
    String mappedType;
    long maxDate;
    String mime;
    long minDate;
    String mobile;
    String motherEpicNo;
    int oldAge;
    private String partNo;
    private byte[] pdfbyteArray;
    String referenceNo;
    private String refreshToken;
    String relationcode;
    int rlnprgnyoldage;
    private String rtkband;
    protected String saveImageFileName;
    String selectDocumentType;
    String selectRelationType;
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
    String spouseEpicNo;
    private String state;
    String submittedForRecommendation;
    String temp;
    FormverificationPayload tempFormverificationPayload;
    private String token;
    Utils utils;
    VerifyPayload verifyPayload;
    String takephoto = "";
    String choose_front_camera = "";
    String choose_back_camera = "";
    String whitecolor = "#000000";
    private int currentImagePickerId = 0;
    String objectStorageString = "objectstorage";
    String cancel = "Cancel";
    String alertText = "";
    String TAG = "EnumrationFormActivityTAG";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String selfStatus = "N";
    String progenyStatus = "N";
    private String photoref = null;
    String fileNotFoundMessage = "Something went wrong.";
    String functionNameForLogBaseActivity = "";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private boolean result = false;
    boolean faceRecognition = true;
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String garudaTextBaseActivity = "GARUDA";
    private String aadharref = null;
    private String photo1Ref = null;
    private String photo2Ref = null;
    String imageTextBaseActivity = "image";
    File file1 = null;
    final Calendar dobcalendar = Calendar.getInstance();
    String photo1Str = " Photo1 Annexure";
    String photo2str = "Photo2 Annexure";
    String pdfTextBaseActivity = ".pdf";
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
    String messageString = "message";
    String comingTag = "coming in onFailure";
    String noDataString = "Invalid EPIC number, Please enter valid EPIC number";
    String sessionTokenExpiredPleaseLogin = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    String bearerText = "Bearer ";
    String moduleName = "";
    String getRefreshTokenText = "getRefreshToken : ";
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String from = null;
    int lastCheckedId = -1;
    String fromfiled = null;
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;
    File file2 = null;
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityVerifyEditBinding activityVerifyEditBindingInflate = ActivityVerifyEditBinding.inflate(getLayoutInflater());
        this.binding = activityVerifyEditBindingInflate;
        setContentView(activityVerifyEditBindingInflate.getRoot());
        this.lastSirYear = SharedPref.getInstance(this).getlastSIRYear();
        initilizeValue();
        getIntentValue();
        if (this.fromfiled.equalsIgnoreCase("sentbyero")) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            this.moduleName = "sentbyERO";
            getVerifyCitizenFormList("B");
        } else if (this.fromfiled.equalsIgnoreCase("anomalylist")) {
            getAnomalyData("A");
            this.moduleName = "anomalylist";
        } else if (this.fromfiled.equalsIgnoreCase("nomapping")) {
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            getNomappingData("B");
            this.moduleName = "nomapping";
        }
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
    }

    private void getIntentValue() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("from");
            this.fromfiled = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (this.fromfiled.equalsIgnoreCase("reverify") || this.fromfiled.equalsIgnoreCase("asdlist")) {
                    FormverificationPayload formverificationPayload = (FormverificationPayload) intent.getParcelableExtra("data");
                    this.formverificationPayload = formverificationPayload;
                    Log.e("ValueBeforeUpdate", this.gson.toJson(formverificationPayload));
                    Gson gson = this.gson;
                    this.tempFormverificationPayload = (FormverificationPayload) gson.fromJson(gson.toJson(this.formverificationPayload), FormverificationPayload.class);
                    if (this.fromfiled.equalsIgnoreCase("asdlist")) {
                        this.binding.textView3.setText(getResources().getString(R.string.tv_deceased));
                        this.moduleName = "ASDlist";
                    } else {
                        this.binding.textView3.setText(getResources().getString(R.string.form_type_reverify_ef));
                        this.moduleName = "EFVerifyForm";
                    }
                    this.binding.radioNote.setVisibility(0);
                    this.binding.tvNote.setVisibility(0);
                    setValues();
                } else if (this.fromfiled.equalsIgnoreCase("verify")) {
                    this.binding.radioNote.setVisibility(8);
                    FormverificationPayload formverificationPayload2 = (FormverificationPayload) intent.getParcelableExtra("data");
                    this.formverificationPayload = formverificationPayload2;
                    Log.e("ValueBeforeUpdate", this.gson.toJson(formverificationPayload2));
                    Gson gson2 = this.gson;
                    this.tempFormverificationPayload = (FormverificationPayload) gson2.fromJson(gson2.toJson(this.formverificationPayload), FormverificationPayload.class);
                    setValues();
                    this.binding.tvNote.setVisibility(8);
                } else if (this.fromfiled.equalsIgnoreCase("sentbyero")) {
                    this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
                    this.binding.textView3.setText(getResources().getString(R.string.rollback_2));
                    this.binding.tvNote.setVisibility(8);
                } else if (this.fromfiled.equalsIgnoreCase("anomalylist")) {
                    this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
                    this.binding.textView3.setText(getResources().getString(R.string.anomaly));
                    this.binding.tvNote.setVisibility(8);
                } else if (this.fromfiled.equalsIgnoreCase("nomapping")) {
                    this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
                    this.binding.textView3.setText(getResources().getString(R.string.no_mapping));
                    this.binding.tvNote.setVisibility(8);
                }
            }
            handleClick();
        }
    }

    private void handleClick() {
        this.binding.searchRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (VerifyEditActivity.this.lastCheckedId != -1 && VerifyEditActivity.this.lastCheckedId != checkedId) {
                    VerifyEditActivity.this.binding.searchRG.getCheckedRadioButtonId();
                    if (VerifyEditActivity.this.binding.selfRb.isChecked()) {
                        VerifyEditActivity.this.showcategoryChangeDialog(checkedId, "self");
                    } else if (VerifyEditActivity.this.binding.progenyRb.isChecked()) {
                        VerifyEditActivity.this.showcategoryChangeDialog(checkedId, "progeny");
                    } else if (VerifyEditActivity.this.binding.progenyRb2026.isChecked()) {
                        VerifyEditActivity.this.showcategoryChangeDialog(checkedId, "Progeny2026");
                    } else if (VerifyEditActivity.this.binding.neitherRb.isChecked()) {
                        VerifyEditActivity.this.showcategoryChangeDialog(checkedId, "NA");
                    }
                } else {
                    VerifyEditActivity.this.lastCheckedId = checkedId;
                    if (VerifyEditActivity.this.binding.selfRb.isChecked()) {
                        VerifyEditActivity.this.setSelfView(checkedId);
                    } else if (VerifyEditActivity.this.binding.progenyRb.isChecked()) {
                        VerifyEditActivity.this.setProgenyView(checkedId);
                    } else if (VerifyEditActivity.this.binding.progenyRb2026.isChecked()) {
                        VerifyEditActivity.this.setProgenyVie2026(checkedId);
                    } else if (VerifyEditActivity.this.binding.neitherRb.isChecked()) {
                        VerifyEditActivity.this.setNeitherView(checkedId);
                    }
                }
                VerifyEditActivity.this.binding.searchRG.getCheckedRadioButtonId();
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$0(view);
            }
        });
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$1(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$2(view);
            }
        });
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$3(view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$4(view);
            }
        });
        this.binding.ivDelete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        this.binding.ivDeleteProgeny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                verifyEditActivity.showDialog2(verifyEditActivity.alertText, "Are you sure you want to delete this relative details?");
            }
        });
        this.binding.ivAddProgenyLl.setOnClickListener(new AnonymousClass4());
        this.binding.ivAddSelfLl.setOnClickListener(new AnonymousClass5());
        this.binding.ivUpdate.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$6(view);
            }
        });
        this.binding.ivUpdateProgeny.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$8(view);
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = VerifyEditActivity.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                VerifyEditActivity.this.isMotherEPICValid = false;
                VerifyEditActivity.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = VerifyEditActivity.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                VerifyEditActivity.this.isFatherEPICValid = false;
                VerifyEditActivity.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = VerifyEditActivity.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                VerifyEditActivity.this.isSpouseEPICValid = false;
                VerifyEditActivity.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$9(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$10(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$11(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$12(view);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass9());
        this.binding.fatherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                VerifyEditActivity.this.isFatherEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    VerifyEditActivity.this.binding.fatherName.setEnabled(true);
                    VerifyEditActivity.this.binding.speakFatherName.setClickable(true);
                    VerifyEditActivity.this.binding.speakFatherName.setEnabled(true);
                } else {
                    if (TextUtils.isEmpty(VerifyEditActivity.this.formverificationPayload.getFatherOrGuardianEpicNo()) || !VerifyEditActivity.this.formverificationPayload.getFatherOrGuardianEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    VerifyEditActivity.this.isFatherEPICValid = true;
                    VerifyEditActivity.this.binding.fatherName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakFatherName.setClickable(false);
                    VerifyEditActivity.this.binding.speakFatherName.setEnabled(false);
                }
            }
        });
        this.binding.motherEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                VerifyEditActivity.this.isMotherEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    VerifyEditActivity.this.binding.motherName.setEnabled(true);
                    VerifyEditActivity.this.binding.speakMotherName.setClickable(true);
                    VerifyEditActivity.this.binding.speakMotherName.setEnabled(true);
                } else {
                    if (TextUtils.isEmpty(VerifyEditActivity.this.formverificationPayload.getMothersEpicNo()) || !VerifyEditActivity.this.formverificationPayload.getMothersEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    VerifyEditActivity.this.isMotherEPICValid = true;
                    VerifyEditActivity.this.binding.motherName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakMotherName.setClickable(false);
                    VerifyEditActivity.this.binding.speakMotherName.setEnabled(false);
                }
            }
        });
        this.binding.spouseEpicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                VerifyEditActivity.this.isSpouseEPICValid = false;
                if (TextUtils.isEmpty(s.toString())) {
                    VerifyEditActivity.this.binding.spouseName.setEnabled(true);
                    VerifyEditActivity.this.binding.speakSpouseName.setClickable(true);
                    VerifyEditActivity.this.binding.speakSpouseName.setEnabled(true);
                } else {
                    if (TextUtils.isEmpty(VerifyEditActivity.this.formverificationPayload.getSpouseEpicNo()) || !VerifyEditActivity.this.formverificationPayload.getSpouseEpicNo().equalsIgnoreCase(s.toString())) {
                        return;
                    }
                    VerifyEditActivity.this.isSpouseEPICValid = true;
                    VerifyEditActivity.this.binding.spouseName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakSpouseName.setClickable(false);
                    VerifyEditActivity.this.binding.speakSpouseName.setEnabled(false);
                }
            }
        });
        this.binding.speakMotherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                verifyEditActivity.setSpeakText(verifyEditActivity.binding.motherName);
            }
        });
        this.binding.speakSpouseName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                verifyEditActivity.setSpeakText(verifyEditActivity.binding.spouseName);
            }
        });
        this.binding.speakFatherName.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                verifyEditActivity.setSpeakText(verifyEditActivity.binding.fatherName);
            }
        });
        handleItemListner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$0(View view) {
        initClickListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$1(View view) {
        pickPhoto(101, "photo1Form");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$2(View view) {
        if (TextUtils.isEmpty(this.photo1Ref) && TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url())) {
            showDialog1(this.alertText, getString(R.string.uploadfrontpagemsg));
        } else {
            pickPhoto(102, "Photo2Form");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$handleClick$3(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this.date, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(this.maxDate);
        datePickerDialog.getDatePicker().setMinDate(this.minDate);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$handleClick$4(View view) {
        this.photocount = 0;
        if (SharedPref.getInstance(this).getisElectorUpload().equalsIgnoreCase("Y")) {
            choosseCameraOption();
        } else {
            pickFile();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
            updateDialogFragment.setArguments(VerifyEditActivity.this.getBundle("progeny"));
            updateDialogFragment.setOnDataReceivedListener(new UpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$4$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.OnDataReceivedListener
                public final void onDataReceived(Payload payload, MappingList mappingList, String str, String str2) {
                    this.f$0.lambda$onClick$0(payload, mappingList, str, str2);
                }
            });
            updateDialogFragment.show(VerifyEditActivity.this.getSupportFragmentManager(), "CentralDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(Payload payload, MappingList mappingList, String str, String str2) {
            if (str.equalsIgnoreCase("progeny")) {
                VerifyEditActivity.this.progenyStatus = "E";
                if (payload == null) {
                    if (mappingList != null) {
                        VerifyEditActivity.this.binding.relativeCardView.setVisibility(0);
                        VerifyEditActivity.this.binding.ivAddProgenyLl.setVisibility(8);
                        VerifyEditActivity.this.binding.relationtypecardview.setVisibility(0);
                        VerifyEditActivity.this.binding.ivDeleteProgeny.setVisibility(0);
                        VerifyEditActivity.this.binding.tvRlEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                        VerifyEditActivity.this.binding.tvRlName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                        VerifyEditActivity.this.binding.tvRlName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                        if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                            VerifyEditActivity.this.father_relationType = mappingList.getRelationType();
                            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                            verifyEditActivity.setRelativeType(verifyEditActivity.father_relationType, VerifyEditActivity.this.binding.tvRlRelation);
                        }
                        TextView textView = VerifyEditActivity.this.binding.tabTV;
                        VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                        textView.setText(verifyEditActivity2.getString(R.string.elector_tab_title, new Object[]{verifyEditActivity2.lastSirYear}));
                        VerifyEditActivity.this.binding.tvRlState.setText(TextUtils.isEmpty(mappingList.getOldStateCd()) ? "" : mappingList.getOldStateCd());
                        VerifyEditActivity.this.binding.tvRlAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                        VerifyEditActivity.this.binding.tvRlAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                        VerifyEditActivity.this.binding.tvRlPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                        VerifyEditActivity.this.binding.tvRlSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                        VerifyEditActivity.this.setDataInModelRelativeMaping(mappingList);
                        return;
                    }
                    return;
                }
                VerifyEditActivity.this.binding.relativeCardView.setVisibility(0);
                VerifyEditActivity.this.binding.ivAddProgenyLl.setVisibility(8);
                VerifyEditActivity.this.binding.relationtypecardview.setVisibility(0);
                VerifyEditActivity.this.binding.ivDeleteProgeny.setVisibility(0);
                VerifyEditActivity.this.binding.tvRlEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                VerifyEditActivity.this.binding.tvRlName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                VerifyEditActivity.this.binding.tvRlName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                if (!TextUtils.isEmpty(payload.getRelationType())) {
                    VerifyEditActivity.this.father_relationType = payload.getRelationType();
                    VerifyEditActivity verifyEditActivity3 = VerifyEditActivity.this;
                    verifyEditActivity3.setRelativeType(verifyEditActivity3.father_relationType, VerifyEditActivity.this.binding.tvRlRelation);
                }
                TextView textView2 = VerifyEditActivity.this.binding.tabTV;
                VerifyEditActivity verifyEditActivity4 = VerifyEditActivity.this;
                textView2.setText(verifyEditActivity4.getString(R.string.elector_tab_title, new Object[]{verifyEditActivity4.lastSirYear}));
                VerifyEditActivity.this.binding.tvRlState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                VerifyEditActivity.this.binding.tvRlAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                VerifyEditActivity.this.binding.tvRlAcNo.setText(String.valueOf(payload.getOldAcNo()));
                VerifyEditActivity.this.binding.tvRlPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                VerifyEditActivity.this.binding.tvRlSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                if (VerifyEditActivity.this.binding.progenyRb.isChecked()) {
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(null);
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_SELF);
                } else if (VerifyEditActivity.this.binding.progenyRb2026.isChecked()) {
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(null);
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_PROGENY);
                } else if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("Y")) {
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_SELF);
                } else if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("N")) {
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_PROGENY);
                } else {
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirProgeny(null);
                }
                VerifyEditActivity.this.setDataInModelRelative(payload);
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
            updateDialogFragment.setArguments(VerifyEditActivity.this.getBundle("self"));
            updateDialogFragment.setOnDataReceivedListener(new UpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$5$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.OnDataReceivedListener
                public final void onDataReceived(Payload payload, MappingList mappingList, String str, String str2) {
                    this.f$0.lambda$onClick$0(payload, mappingList, str, str2);
                }
            });
            updateDialogFragment.show(VerifyEditActivity.this.getSupportFragmentManager(), "CentralDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(Payload payload, MappingList mappingList, String str, String str2) {
            if (str.equalsIgnoreCase("self")) {
                VerifyEditActivity.this.selfStatus = "E";
                if (payload != null) {
                    VerifyEditActivity.this.binding.selfCardView.setVisibility(0);
                    VerifyEditActivity.this.binding.ivAddSelfLl.setVisibility(8);
                    VerifyEditActivity.this.binding.tvEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                    VerifyEditActivity.this.binding.tvName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                    VerifyEditActivity.this.binding.tvName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                    if (!TextUtils.isEmpty(payload.getRelationType())) {
                        VerifyEditActivity.this.self_selfOldRlnType = payload.getRelationType();
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.setRelativeType(verifyEditActivity.self_selfOldRlnType, VerifyEditActivity.this.binding.tvRelation);
                    }
                    TextView textView = VerifyEditActivity.this.binding.tabTV;
                    VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                    textView.setText(verifyEditActivity2.getString(R.string.elector_tab_title, new Object[]{verifyEditActivity2.lastSirYear}));
                    VerifyEditActivity.this.binding.tvState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                    VerifyEditActivity.this.binding.tvAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                    VerifyEditActivity.this.binding.tvAcNo.setText(String.valueOf(payload.getOldAcNo()));
                    VerifyEditActivity.this.binding.tvPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                    VerifyEditActivity.this.binding.tvSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                    VerifyEditActivity.this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                    VerifyEditActivity.this.setDataInModelSelf(payload);
                    return;
                }
                if (mappingList != null) {
                    VerifyEditActivity.this.binding.selfCardView.setVisibility(0);
                    VerifyEditActivity.this.binding.ivAddSelfLl.setVisibility(8);
                    VerifyEditActivity.this.binding.tvEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                    VerifyEditActivity.this.binding.tvName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                    VerifyEditActivity.this.binding.tvName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                    if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                        VerifyEditActivity.this.self_selfOldRlnType = mappingList.getRelationType();
                        VerifyEditActivity verifyEditActivity3 = VerifyEditActivity.this;
                        verifyEditActivity3.setRelativeType(verifyEditActivity3.self_selfOldRlnType, VerifyEditActivity.this.binding.tvRelation);
                    }
                    TextView textView2 = VerifyEditActivity.this.binding.tabTV;
                    VerifyEditActivity verifyEditActivity4 = VerifyEditActivity.this;
                    textView2.setText(verifyEditActivity4.getString(R.string.elector_tab_title, new Object[]{verifyEditActivity4.lastSirYear}));
                    VerifyEditActivity.this.binding.tvState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                    VerifyEditActivity.this.binding.tvAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                    VerifyEditActivity.this.binding.tvAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                    VerifyEditActivity.this.binding.tvPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                    VerifyEditActivity.this.binding.tvSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                    VerifyEditActivity.this.setDataInModelSelfMapping(mappingList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$6(View view) {
        UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
        updateDialogFragment.setArguments(getBundle("self"));
        updateDialogFragment.setOnDataReceivedListener(new UpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda0
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str, String str2) {
                this.f$0.lambda$handleClick$5(payload, mappingList, str, str2);
            }
        });
        updateDialogFragment.show(getSupportFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$5(Payload payload, MappingList mappingList, String str, String str2) {
        if (str.equalsIgnoreCase("self")) {
            this.selfStatus = "E";
            if (payload != null) {
                this.binding.tvEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                this.binding.tvName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                this.binding.tvName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                if (!TextUtils.isEmpty(payload.getRelationType())) {
                    String relationType = payload.getRelationType();
                    this.self_selfOldRlnType = relationType;
                    setRelativeType(relationType, this.binding.tvRelation);
                }
                this.binding.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
                this.binding.tvState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
                this.binding.tvAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
                this.binding.tvAcNo.setText(String.valueOf(payload.getOldAcNo()));
                this.binding.tvPartNo.setText(String.valueOf(payload.getOldPartNumber()));
                this.binding.tvSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
                this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                setDataInModelSelf(payload);
                return;
            }
            if (mappingList != null) {
                this.binding.tvEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                this.binding.tvName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                this.binding.tvName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                    String relationType2 = mappingList.getRelationType();
                    this.self_selfOldRlnType = relationType2;
                    setRelativeType(relationType2, this.binding.tvRelation);
                }
                this.binding.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
                this.binding.tvState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                this.binding.tvAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                this.binding.tvAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                this.binding.tvPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                this.binding.tvSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                setDataInModelSelfMapping(mappingList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$8(View view) {
        UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
        updateDialogFragment.setArguments(getBundle("progeny"));
        updateDialogFragment.setOnDataReceivedListener(new UpdateDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str, String str2) {
                this.f$0.lambda$handleClick$7(payload, mappingList, str, str2);
            }
        });
        updateDialogFragment.show(getSupportFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$7(Payload payload, MappingList mappingList, String str, String str2) {
        if (str.equalsIgnoreCase("progeny")) {
            this.progenyStatus = "E";
            if (payload == null) {
                if (mappingList != null) {
                    this.binding.tvRlEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
                    this.binding.tvRlName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
                    this.binding.tvRlName1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
                    if (!TextUtils.isEmpty(mappingList.getRelationType())) {
                        this.father_relationType = mappingList.getRelationType();
                        setRelativeType(this.self_selfOldRlnType, this.binding.tvRlRelation);
                    }
                    this.binding.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
                    this.binding.tvRlState.setText(TextUtils.isEmpty(mappingList.getOldStateName()) ? "" : mappingList.getOldStateName());
                    this.binding.tvRlAcName.setText(TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName());
                    this.binding.tvRlAcNo.setText(String.valueOf(mappingList.getOldAcNo()));
                    this.binding.tvRlPartNo.setText(String.valueOf(mappingList.getOldPartNumber()));
                    this.binding.tvRlSrNo.setText(String.valueOf(mappingList.getOldPartSerialNo()));
                    setDataInModelRelativeMaping(mappingList);
                    return;
                }
                return;
            }
            this.binding.tvRlEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
            this.binding.tvRlName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
            this.binding.tvRlName1.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
            if (!TextUtils.isEmpty(payload.getRelationType())) {
                String relationType = payload.getRelationType();
                this.father_relationType = relationType;
                setRelativeType(relationType, this.binding.tvRlRelation);
            }
            this.binding.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
            this.binding.tvRlState.setText(TextUtils.isEmpty(payload.getOldStateName()) ? "" : payload.getOldStateName());
            this.binding.tvRlAcName.setText(TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName());
            this.binding.tvRlAcNo.setText(String.valueOf(payload.getOldAcNo()));
            this.binding.tvRlPartNo.setText(String.valueOf(payload.getOldPartNumber()));
            this.binding.tvRlSrNo.setText(String.valueOf(payload.getOldPartSerialNo()));
            if (this.binding.progenyRb.isChecked()) {
                this.formverificationPayload.setYearOfSirSelf(null);
                this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_SELF);
            } else if (this.binding.progenyRb2026.isChecked()) {
                this.formverificationPayload.setYearOfSirSelf(null);
                this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_PROGENY);
            } else if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("Y")) {
                this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_SELF);
            } else if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("N")) {
                this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_PROGENY);
            } else {
                this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
                this.formverificationPayload.setYearOfSirProgeny(null);
            }
            setDataInModelRelative(payload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$9(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$10(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$11(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$12(View view) {
        if (validate()) {
            submit();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9, reason: invalid class name */
    class AnonymousClass9 implements TextWatcher {
        AnonymousClass9() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            if (VerifyEditActivity.this.binding.aadharNumber.getText().toString().length() != 12 || VerifyEditActivity.this.binding.aadharNumber.getText().toString().contains("xx")) {
                return;
            }
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            try {
                String string = VerifyEditActivity.this.binding.aadharNumber.getText().toString();
                VerifyEditActivity.this.result = Verhoeff.validateVerhoeff(string);
                if (!VerifyEditActivity.this.result) {
                    VerifyEditActivity.this.binding.aadharNumber.setText("");
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.showDialog1("", verifyEditActivity.getString(R.string.aadhaarnoerror));
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                } else {
                    CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                    ?? r1 = VerifyEditActivity.this;
                    commomUtility.getaadharref(r1, ((VerifyEditActivity) r1).state, VerifyEditActivity.this.token, VerifyEditActivity.this.binding.aadharNumber.getText().toString(), VerifyEditActivity.this.atkband, VerifyEditActivity.this.rtkband, VerifyEditActivity.this.moduleName, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda3
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

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r4 = VerifyEditActivity.this;
                commomUtility.getRefreshToken(r4, ((VerifyEditActivity) r4).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.showDialog1(verifyEditActivity.invalidaadhar, str2);
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                VerifyEditActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            VerifyEditActivity.this.showDialog1(VerifyEditActivity.this.alertText + i, str2);
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r11 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r11, ((VerifyEditActivity) r11).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
            } else {
                VerifyEditActivity.this.token = "Bearer " + str;
                VerifyEditActivity.this.refreshToken = str2;
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str);
                VerifyEditActivity.this.commomUtility.getaadharref(VerifyEditActivity.this.getApplicationContext(), VerifyEditActivity.this.state, VerifyEditActivity.this.token, VerifyEditActivity.this.binding.aadharNumber.getText().toString(), VerifyEditActivity.this.atkband, VerifyEditActivity.this.rtkband, VerifyEditActivity.this.moduleName, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent(VerifyEditActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.showDialog1(verifyEditActivity.invalidaadhar, str2);
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                VerifyEditActivity.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$9$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$1();
                    }
                }, 2000L);
                return;
            }
            VerifyEditActivity.this.showDialog1(VerifyEditActivity.this.alertText + i, str2);
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle getBundle(String key) {
        Bundle bundle = new Bundle();
        bundle.putString("key", key);
        bundle.putString("currentName", this.formverificationPayload.getEpicName());
        bundle.putString("currentEpic", this.formverificationPayload.getEpicNo());
        bundle.putInt("currentAge", this.formverificationPayload.getErollAge());
        bundle.putInt("currentAc", this.formverificationPayload.getAcNo());
        bundle.putInt("currentPart", this.formverificationPayload.getPartNo());
        bundle.putString("currentState", this.formverificationPayload.getStateCd());
        bundle.putString("currentRelativeType", this.formverificationPayload.getRelationType());
        bundle.putString("currentRelativeName", this.formverificationPayload.getRelativeFullName());
        bundle.putInt("currentSerialNo", this.formverificationPayload.getPartSerialNo());
        bundle.putString("sirYearSelf", this.formverificationPayload.getYearOfSirSelf());
        bundle.putString("sirYearProgeny", this.formverificationPayload.getYearOfSirProgeny());
        bundle.putString("currentEpicId", String.valueOf(this.formverificationPayload.getEpicId()));
        if (this.binding.selfRb.isChecked()) {
            bundle.putString("mappingtype", "self");
        }
        if (this.binding.progenyRb.isChecked()) {
            bundle.putString("mappingtype", "progeny");
        }
        if (this.binding.progenyRb2026.isChecked()) {
            bundle.putString("mappingtype", "progney2026");
        }
        return bundle;
    }

    private boolean checkSelfEmpty() {
        return this.formverificationPayload.getOldAcNo() == 0 && this.formverificationPayload.getOldPartNo() == 0 && this.formverificationPayload.getOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldEpic()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldName()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnType());
    }

    private boolean checkProgenyEmpty() {
        return this.formverificationPayload.getRelationOldAcNo() == 0 && this.formverificationPayload.getRelationOldPartNo() == 0 && this.formverificationPayload.getRelationOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyEpic()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelRelative(Payload searchModel) {
        this.formverificationPayload.setRelationOldAcNo(searchModel.getOldAcNo());
        this.formverificationPayload.setRelationOldPartNo(searchModel.getOldPartNumber());
        this.formverificationPayload.setRelationOldPslNo(searchModel.getOldPartSerialNo());
        this.formverificationPayload.setRelationOldStateCd(searchModel.getOldStateCd());
        this.formverificationPayload.setRlnPrgyEpic(searchModel.getEpicNumber());
        this.formverificationPayload.setRlnPrgyName(searchModel.getOldFullName());
        this.formverificationPayload.setRlnPrgyRlnName(searchModel.getOldRelativeFullName());
        this.formverificationPayload.setRlnPrgyRlnType(searchModel.getRelationType());
        this.formverificationPayload.setRelativeOldAge(searchModel.getAge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelRelativeMaping(MappingList searchModel) {
        this.formverificationPayload.setRelationOldAcNo(searchModel.getOldAcNo());
        this.formverificationPayload.setRelationOldPartNo(searchModel.getOldPartNumber());
        this.formverificationPayload.setRelationOldPslNo(searchModel.getOldPartSerialNo());
        this.formverificationPayload.setRelationOldStateCd(searchModel.getOldStateCd());
        this.formverificationPayload.setRlnPrgyEpic(searchModel.getOldEpicNumber());
        this.formverificationPayload.setRlnPrgyName(searchModel.getOldFullName());
        this.formverificationPayload.setRlnPrgyRlnName(searchModel.getOldRelativeFullName());
        this.formverificationPayload.setRlnPrgyRlnType(searchModel.getRelationType());
        this.formverificationPayload.setRelativeOldAge(searchModel.getAge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelSelf(Payload searchModel) {
        this.formverificationPayload.setOldAcNo(searchModel.getOldAcNo());
        this.formverificationPayload.setOldPartNo(searchModel.getOldPartNumber());
        this.formverificationPayload.setOldPslNo(searchModel.getOldPartSerialNo());
        this.formverificationPayload.setOldStateCd(searchModel.getOldStateCd());
        this.formverificationPayload.setSelfOldName(searchModel.getOldFullName());
        this.formverificationPayload.setSelfOldEpic(searchModel.getEpicNumber());
        this.formverificationPayload.setSelfOldRlnName(searchModel.getOldRelativeFullName());
        this.formverificationPayload.setSelfOldRlnType(searchModel.getRelationType());
        this.formverificationPayload.setOldAge(searchModel.getAge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataInModelSelfMapping(MappingList searchModel) {
        this.formverificationPayload.setOldAcNo(searchModel.getOldAcNo());
        this.formverificationPayload.setOldPartNo(searchModel.getOldPartNumber());
        this.formverificationPayload.setOldPslNo(searchModel.getOldPartSerialNo());
        this.formverificationPayload.setOldStateCd(searchModel.getOldStateCd());
        this.formverificationPayload.setSelfOldName(searchModel.getOldFullName());
        this.formverificationPayload.setSelfOldEpic(searchModel.getOldEpicNumber());
        this.formverificationPayload.setSelfOldRlnName(searchModel.getOldRelativeFullName());
        this.formverificationPayload.setSelfOldRlnType(searchModel.getRelationType());
        this.formverificationPayload.setOldAge(searchModel.getAge());
    }

    private void clearSelfDetailsFromObj() {
        this.formverificationPayload.setOldAcNo(0);
        this.formverificationPayload.setOldPartNo(0);
        this.formverificationPayload.setOldPslNo(0);
        this.formverificationPayload.setOldStateCd(null);
        this.formverificationPayload.setSelfOldName(null);
        this.formverificationPayload.setSelfOldEpic(null);
        this.formverificationPayload.setSelfOldRlnName(null);
        this.formverificationPayload.setSelfOldRlnType(null);
        this.formverificationPayload.setOldAge(0);
    }

    private void clearRelativeDetailsFromObj() {
        this.formverificationPayload.setRelationOldAcNo(0);
        this.formverificationPayload.setRelationOldPartNo(0);
        this.formverificationPayload.setRelationOldPslNo(0);
        this.formverificationPayload.setRelationOldStateCd(null);
        this.formverificationPayload.setRlnPrgyEpic(null);
        this.formverificationPayload.setRlnPrgyName(null);
        this.formverificationPayload.setRlnPrgyRlnName(null);
        this.formverificationPayload.setRlnPrgyRlnType(null);
        this.formverificationPayload.setRelationType("");
        this.formverificationPayload.setRelativeOldAge(0);
    }

    private void handleItemListner() {
        this.binding.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.16
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    VerifyEditActivity.this.relationcode = null;
                } else {
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.relationcode = verifyEditActivity.relationCodeList.get(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to calculate best type for var: r0v120 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v120 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v120 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v120 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v150 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v150 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v150 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v150 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v159 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v159 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v159 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v159 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v161 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v161 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v161 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v161 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v163 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v163 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v163 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v163 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v171 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v171 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v171 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v171 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v173 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v173 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v173 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v173 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v175 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v175 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v175 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v175 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v183 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v183 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v183 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v183 ??, new type: android.widget.EditText
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v185 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v185 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v185 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v185 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v187 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v187 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v187 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v187 ??, new type: android.widget.ImageView
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v192 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v192 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v192 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v192 ??, new type: android.widget.LinearLayout
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v210 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v210 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v4 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public void setValues() {
        /*
            Method dump skipped, instruction units count: 1835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.setValues():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$13(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            return;
        }
        if (str.equalsIgnoreCase("D")) {
            this.binding.aadharNumber.setText("");
        } else {
            this.aadharref = this.formverificationPayload.getAadharNo();
            this.binding.aadharNumber.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$14(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    private void clearSelfProgenyData() {
        this.formverificationPayload.setSelfOldEpic(null);
        this.formverificationPayload.setSelfOldName(null);
        this.formverificationPayload.setSelfOldRlnName(null);
        this.formverificationPayload.setSelfOldRlnType(null);
        this.formverificationPayload.setOldAcNo(0);
        this.formverificationPayload.setOldPartNo(0);
        this.formverificationPayload.setOldPslNo(0);
        this.formverificationPayload.setOldStateCd(null);
        this.formverificationPayload.setRelationOldStateCd(null);
        this.formverificationPayload.setRelationOldAcNo(0);
        this.formverificationPayload.setRelationOldPartNo(0);
        this.formverificationPayload.setRelationOldPslNo(0);
        this.formverificationPayload.setRelationType("");
        this.formverificationPayload.setRlnPrgyEpic(null);
        this.formverificationPayload.setRlnPrgyName(null);
        this.formverificationPayload.setRlnPrgyRlnName(null);
        this.formverificationPayload.setRlnPrgyRlnType(null);
        this.formverificationPayload.setCategoryType("NA");
        this.binding.selfCardView.setVisibility(8);
        this.binding.progenyRb.setVisibility(8);
        this.binding.progenyRelationSpinner.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean submit() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        this.binding.submitButtonRec.setEnabled(false);
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("self") || this.formverificationPayload.getCategoryType().equalsIgnoreCase("Progeny")) {
            this.submittedForRecommendation = "Y";
        } else if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("na")) {
            this.submittedForRecommendation = "N";
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.formverificationPayload.getEpicNo());
        map2.put("epicId", this.formverificationPayload.getEpicId());
        map2.put("stCode", this.formverificationPayload.getStateCd());
        map2.put("acNo", Integer.valueOf(this.formverificationPayload.getAcNo()));
        map2.put("partNo", Integer.valueOf(this.formverificationPayload.getPartNo()));
        map2.put("partSerialNo", Integer.valueOf(this.formverificationPayload.getPartSerialNo()));
        map2.put("selfOldName", this.formverificationPayload.getSelfOldName());
        map2.put("selfOldEpic", this.formverificationPayload.getSelfOldEpic());
        map2.put("selfOldRlnName", this.formverificationPayload.getSelfOldRlnName());
        map2.put("selfOldRlnType", this.formverificationPayload.getSelfOldRlnType());
        map2.put("rlnPrgyName", this.formverificationPayload.getRlnPrgyName());
        map2.put("rlnPrgyEpic", this.formverificationPayload.getRlnPrgyEpic());
        map2.put("rlnPrgyRlnName", this.formverificationPayload.getRlnPrgyRlnName());
        map2.put("rlnPrgyRlnType", this.formverificationPayload.getRlnPrgyRlnType());
        map2.put("mappingType", this.formverificationPayload.getMappingType());
        map2.put("oldStateCd", this.formverificationPayload.getOldStateCd());
        map2.put("relationOldStateCd", this.formverificationPayload.getRelationOldStateCd());
        map2.put("relationType", this.formverificationPayload.getRelationType());
        map2.put("relationOldAcNo", Integer.valueOf(this.formverificationPayload.getRelationOldAcNo()));
        map2.put("relationOldPartNo", Integer.valueOf(this.formverificationPayload.getRelationOldPartNo()));
        map2.put("relationOldPslNo", Integer.valueOf(this.formverificationPayload.getRelationOldPslNo()));
        map2.put("epicName", this.formverificationPayload.getEpicName());
        map2.put("submittedForRecommendation", this.submittedForRecommendation);
        map2.put("aadharNo", this.formverificationPayload.getAadharNo());
        map2.put("mobileNo", this.formverificationPayload.getMobileNo());
        map2.put("fathersOrGuardianName", this.formverificationPayload.getFatherOrGuardianName());
        map2.put("fathersOrGuardianEpicNo", this.formverificationPayload.getFatherOrGuardianEpicNo());
        map2.put("mothersName", this.formverificationPayload.getMothersName());
        map2.put("mothersEpicNo", this.formverificationPayload.getMothersEpicNo());
        map2.put("spouseName", this.formverificationPayload.getSpouseName());
        map2.put("spouseEpicNo", this.formverificationPayload.getSpouseEpicNo());
        map2.put("photoUrl", this.formverificationPayload.getPhotoUrl());
        map2.put("srFormPage1Url", this.formverificationPayload.getSrFormPage1Url());
        map2.put("srFormPage2Url", this.formverificationPayload.getSrFormPage2Url());
        map2.put("oldAcNo", Integer.valueOf(this.formverificationPayload.getOldAcNo()));
        map2.put("oldPartNo", Integer.valueOf(this.formverificationPayload.getOldPartNo()));
        map2.put("oldPslNo", Integer.valueOf(this.formverificationPayload.getOldPslNo()));
        map2.put("categoryType", this.formverificationPayload.getCategoryType());
        map2.put("dobVerified", this.formverificationPayload.getDobVerified());
        map2.put("annexureCUrl", this.formverificationPayload.getAnnexureCUrl());
        map2.put("modifiedBy", "BLO");
        map2.put("bloOverridenFlg", "Y");
        map2.put("currentAge", Integer.valueOf(this.formverificationPayload.getErollAge()));
        if (this.formverificationPayload.getOldAge() != 0) {
            map2.put("oldAge", Integer.valueOf(this.formverificationPayload.getOldAge()));
        }
        if (this.formverificationPayload.getRelativeOldAge() != 0) {
            map2.put("relativeOldAge", Integer.valueOf(this.formverificationPayload.getRelativeOldAge()));
        }
        map2.put("sirYearSelf", this.formverificationPayload.getYearOfSirSelf());
        map2.put("sirYearProgeny", this.formverificationPayload.getYearOfSirProgeny());
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).updateSpecialRevisionPanIndia(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.17
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        if (VerifyEditActivity.this.alertDialog != null) {
                            VerifyEditActivity.this.alertDialog.dismiss();
                        }
                        VerifyEditActivity.this.binding.submitButtonRec.setEnabled(true);
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.showDialog3(verifyEditActivity.alertText, string);
                        return;
                    }
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    VerifyEditActivity.this.binding.submitButtonRec.setEnabled(true);
                    VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                    verifyEditActivity2.showDialog3("", verifyEditActivity2.getString(R.string.formSubmittedMsg));
                } catch (Exception e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    VerifyEditActivity.this.binding.submitButtonRec.setEnabled(true);
                    Logger.d("SpecialRevisionDetails", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.binding.submitButtonRec.setEnabled(true);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$15(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$15(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        if (!TextUtils.isEmpty(this.fromfiled) && this.fromfiled.equalsIgnoreCase("verify")) {
            Intent intent = new Intent((Context) this, (Class<?>) VerifyCitizenFormsListActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("restart", true);
            startActivity(intent);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.fromfiled) && this.fromfiled.equalsIgnoreCase("reverify")) {
            Intent intent2 = new Intent((Context) this, (Class<?>) ReverifyFormsListActivity.class);
            intent2.setFlags(67108864);
            intent2.putExtra("restart", true);
            startActivity(intent2);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.fromfiled) && this.fromfiled.equalsIgnoreCase("asdlist")) {
            Intent intent3 = new Intent((Context) this, (Class<?>) AsdListActivity.class);
            intent3.setFlags(67108864);
            intent3.putExtra("restart", true);
            startActivity(intent3);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.fromfiled) && this.fromfiled.equalsIgnoreCase("sentbyero")) {
            Intent intent4 = new Intent((Context) this, (Class<?>) SentBackEroFormsListActivity.class);
            intent4.setFlags(67108864);
            intent4.putExtra("restart", true);
            startActivity(intent4);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(this.fromfiled) && this.fromfiled.equalsIgnoreCase("anomalylist")) {
            Intent intent5 = new Intent((Context) this, (Class<?>) AnomalyListActivity.class);
            intent5.setFlags(67108864);
            intent5.putExtra("restart", true);
            startActivity(intent5);
            finish();
            return;
        }
        if (this.fromfiled.equalsIgnoreCase("nomapping")) {
            Intent intent6 = new Intent((Context) this, (Class<?>) NoMappingFormsListActivity.class);
            intent6.setFlags(67108864);
            intent6.putExtra("restart", true);
            startActivity(intent6);
            finish();
            return;
        }
        Intent intent7 = new Intent((Context) this, (Class<?>) VerifyCitizenFormsListActivity.class);
        intent7.setFlags(67108864);
        intent7.putExtra("restart", true);
        startActivity(intent7);
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
            this.binding.annexurePhoto1LL.setVisibility(0);
            this.formverificationPayload.setAnnexureCUrl(null);
            this.formverificationPayload.setSrFormPage1Url(null);
            if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage2Url())) {
                this.binding.photo2Annexure.setEnabled(false);
            }
        }
        if (code == 103) {
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
            this.binding.photo2Layout.setVisibility(8);
            this.photo2Ref = null;
            this.binding.photo2Size.setText("");
            this.binding.photo2Name.setText("");
            this.binding.annexurePhoto1LL.setVisibility(0);
            this.binding.photo1Annexure.setVisibility(0);
            this.formverificationPayload.setSrFormPage2Url(null);
            if (TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url())) {
                return;
            }
            this.binding.photo1Annexure.setEnabled(false);
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
        this.formverificationPayload.setPhotoUrl(null);
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$16(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$16(View view) {
        onBackPressed();
    }

    public boolean validate() {
        if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
            this.dob = this.binding.dateOfBirth.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString())) {
            this.fatherEpicNo = this.binding.fatherEpicNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.fatherName.getText().toString())) {
            this.fatherName = this.binding.fatherName.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString())) {
            this.motherEpicNo = this.binding.motherEpicNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.motherName.getText().toString())) {
            this.motherName = this.binding.motherName.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.spouseEpicNumber.getText().toString())) {
            this.spouseEpicNo = this.binding.spouseEpicNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.spouseName.getText().toString())) {
            this.spouseName = this.binding.spouseName.getText().toString();
        }
        if (this.binding.searchRG.getCheckedRadioButtonId() == -1) {
            showDialog1(this.alertText, getString(R.string.invalidRadioButtonMsg));
            return false;
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
        if (this.fromfiled.equalsIgnoreCase("reverify") && TextUtils.isEmpty(this.formverificationPayload.getAnnexureCUrl()) && TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url()) && TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if ((this.fromfiled.equalsIgnoreCase("sentbyero") || this.fromfiled.equalsIgnoreCase("verify") || this.fromfiled.equalsIgnoreCase("anomalylist") || this.fromfiled.equalsIgnoreCase("nomapping")) && TextUtils.isEmpty(this.formverificationPayload.getAnnexureCUrl()) && TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url()) && TextUtils.isEmpty(this.photo1Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadFrontPageMsg));
            return false;
        }
        if (this.binding.selfRb.isChecked() && checkSelfEmpty()) {
            showDialog1(this.alertText, "Please add self details");
            return false;
        }
        if (this.binding.progenyRb.isChecked() && checkProgenyEmpty()) {
            showDialog1(this.alertText, "Please add progeny details");
            return false;
        }
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
        }
        this.formverificationPayload.setDobVerified(str);
        this.formverificationPayload.setAadharNo(this.aadharref);
        this.formverificationPayload.setMobileNo(this.binding.mobileNumber.getText().toString());
        this.formverificationPayload.setFatherOrGuardianEpicNo(this.binding.fatherEpicNumber.getText().toString());
        this.formverificationPayload.setFatherOrGuardianName(this.binding.fatherName.getText().toString());
        this.formverificationPayload.setMothersEpicNo(this.binding.motherEpicNumber.getText().toString());
        this.formverificationPayload.setMothersName(this.binding.motherName.getText().toString());
        this.formverificationPayload.setSpouseEpicNo(this.binding.spouseEpicNumber.getText().toString());
        this.formverificationPayload.setSpouseName(this.binding.spouseName.getText().toString());
        if (this.binding.selfRb.isChecked()) {
            this.formverificationPayload.setYearOfSirSelf(Constants.SIR_YEAR_SELF);
            this.formverificationPayload.setCategoryType("Self");
            if (!checkProgenyEmpty()) {
                this.formverificationPayload.setRelationType(this.relationcode);
            }
        } else if (this.binding.progenyRb.isChecked()) {
            this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_SELF);
            this.formverificationPayload.setCategoryType("Progeny");
            this.formverificationPayload.setRelationType(this.relationcode);
        } else if (this.binding.progenyRb2026.isChecked()) {
            this.formverificationPayload.setYearOfSirProgeny(Constants.SIR_YEAR_PROGENY);
            this.formverificationPayload.setCategoryType("Progeny");
            this.formverificationPayload.setRelationType(this.relationcode);
        } else if (this.binding.neitherRb.isChecked()) {
            this.formverificationPayload.setCategoryType("NA");
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getAnnexureCUrl()) && TextUtils.isEmpty(this.photo1Ref)) {
            FormverificationPayload formverificationPayload = this.formverificationPayload;
            formverificationPayload.setAnnexureCUrl(formverificationPayload.getAnnexureCUrl());
        } else if (!TextUtils.isEmpty(this.formverificationPayload.getAnnexureCUrl()) && !TextUtils.isEmpty(this.photo1Ref)) {
            this.formverificationPayload.setSrFormPage1Url(this.photo1Ref);
        } else if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url()) && TextUtils.isEmpty(this.photo1Ref)) {
            FormverificationPayload formverificationPayload2 = this.formverificationPayload;
            formverificationPayload2.setSrFormPage1Url(formverificationPayload2.getSrFormPage1Url());
        } else if (TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url()) || !TextUtils.isEmpty(this.photo1Ref)) {
            this.formverificationPayload.setSrFormPage1Url(this.photo1Ref);
        } else {
            this.formverificationPayload.setSrFormPage1Url(this.photo1Ref);
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage2Url()) && TextUtils.isEmpty(this.photo2Ref)) {
            FormverificationPayload formverificationPayload3 = this.formverificationPayload;
            formverificationPayload3.setSrFormPage2Url(formverificationPayload3.getSrFormPage2Url());
        } else if ((TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url()) || TextUtils.isEmpty(this.photo2Ref)) && !TextUtils.isEmpty(this.photo2Ref)) {
            this.formverificationPayload.setSrFormPage2Url(this.photo2Ref);
        } else {
            this.formverificationPayload.setSrFormPage2Url(this.photo2Ref);
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl()) && TextUtils.isEmpty(this.photoref)) {
            FormverificationPayload formverificationPayload4 = this.formverificationPayload;
            formverificationPayload4.setPhotoUrl(formverificationPayload4.getPhotoUrl());
        } else if ((TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl()) || TextUtils.isEmpty(this.photoref)) && !TextUtils.isEmpty(this.photoref)) {
            this.formverificationPayload.setPhotoUrl(this.photoref);
        } else {
            this.formverificationPayload.setPhotoUrl(this.photoref);
        }
        Log.e("ValueAfterUpdate", this.gson.toJson(this.formverificationPayload));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.formverificationPayload.getEpicNo().replaceAll("/", "_") + "_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$17(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$17(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, String listCode) {
        this.currentImagePickerId = code;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.formverificationPayload.getEpicNo().replaceAll("/", "_") + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$18(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$18(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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
        new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$19(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$19(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$20(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda23
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$21(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$20(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        clearRelativeDetailsFromObj();
        this.binding.relativeCardView.setVisibility(8);
        this.binding.ivAddProgenyLl.setVisibility(0);
        this.binding.relationtypecardview.setVisibility(8);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$21(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:115:0x03a3 A[Catch: Exception -> 0x0581, TRY_ENTER, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x03f1 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0406 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0448 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0463 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0467 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x047d A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x04a9 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x04c7 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x04d2 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x04e6 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x050c A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0510 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0526 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0550 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0569 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0576 A[Catch: Exception -> 0x0581, TryCatch #12 {Exception -> 0x0581, blocks: (B:115:0x03a3, B:117:0x03f1, B:118:0x03f6, B:120:0x0431, B:122:0x0448, B:124:0x0463, B:126:0x0467, B:128:0x0497, B:130:0x04a9, B:143:0x0572, B:131:0x04c7, B:127:0x047d, B:132:0x04d2, B:134:0x04e6, B:135:0x050c, B:137:0x0510, B:139:0x0540, B:141:0x0550, B:142:0x0569, B:138:0x0526, B:144:0x0576, B:145:0x0580, B:119:0x0406), top: B:171:0x03a1 }] */
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
    /* JADX WARN: Type inference failed for: r1v37, types: [java.lang.StringBuilder] */
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
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.Context, androidx.appcompat.app.AppCompatActivity, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
        callFaceRecognitionApi.enqueue(new AnonymousClass18(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$18, reason: invalid class name */
    class AnonymousClass18 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass18(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                Context applicationContext = VerifyEditActivity.this.getApplicationContext();
                String str = VerifyEditActivity.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$18$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                VerifyEditActivity.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(VerifyEditActivity.this.photostr)) {
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, verifyEditActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(8);
                VerifyEditActivity.this.binding.passPhoto.setVisibility(0);
                VerifyEditActivity.this.binding.chooseFileTv.setEnabled(true);
                VerifyEditActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(VerifyEditActivity.this.whitecolor));
                new JSONObject(response.errorBody().string());
                VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                verifyEditActivity2.showDialog1(verifyEditActivity2.alertText, VerifyEditActivity.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r2 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r2, ((VerifyEditActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$18$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                VerifyEditActivity.this.alertDialog.dismiss();
                return;
            }
            VerifyEditActivity.this.alertDialog.dismiss();
            VerifyEditActivity.this.token = "Bearer " + str8;
            VerifyEditActivity.this.refreshToken = str9;
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.faceRecognition(str, str2, str3, str4, str5, verifyEditActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent(VerifyEditActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(8);
            VerifyEditActivity.this.binding.chooseFileTv.setEnabled(true);
            VerifyEditActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(VerifyEditActivity.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.showDialog1(verifyEditActivity.alertText, t.getMessage());
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
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
            map2.put("epicNo", this.formverificationPayload.getEpicNo());
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass19(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$19, reason: invalid class name */
    class AnonymousClass19 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass19(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v26, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
                VerifyEditActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r13 = VerifyEditActivity.this;
                String str = ((VerifyEditActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$19$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                VerifyEditActivity.this.alertDialog.dismiss();
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
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, verifyEditActivity.token, this.val$reference, this.val$uploadtype);
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
                    if (this.val$uploadtype.equals(VerifyEditActivity.this.photostr)) {
                        VerifyEditActivity.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        VerifyEditActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, VerifyEditActivity.this.photoref);
                    }
                    if (this.val$uploadtype.equals(VerifyEditActivity.this.photo1Str)) {
                        VerifyEditActivity.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        VerifyEditActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, VerifyEditActivity.this.photo1Ref);
                    }
                    if (this.val$uploadtype.equals(VerifyEditActivity.this.photo2str)) {
                        VerifyEditActivity.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        VerifyEditActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, VerifyEditActivity.this.photo2Ref);
                    }
                    Logger.d(VerifyEditActivity.this.TAG, "Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    VerifyEditActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photostr)) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.photocount = 0;
                VerifyEditActivity.this.binding.chooseFileTv.setEnabled(true);
                VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(8);
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photo1Str)) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.photo1count = 0;
                VerifyEditActivity.this.binding.annexPage1Layout.setVisibility(8);
                VerifyEditActivity.this.binding.photo1Annexure.setEnabled(true);
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photo2str)) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.photo2count = 0;
                VerifyEditActivity.this.binding.photo2Annexure.setEnabled(true);
                VerifyEditActivity.this.binding.photo2Layout.setVisibility(8);
            }
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                Logger.d("", jSONObject2.toString());
                String string = jSONObject2.getString("message");
                VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                verifyEditActivity2.showDialog1(verifyEditActivity2.alertText, string);
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r2 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r2, ((VerifyEditActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$19$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            VerifyEditActivity.this.alertDialog.dismiss();
            VerifyEditActivity.this.token = "Bearer " + str8;
            VerifyEditActivity.this.refreshToken = str9;
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.uploadPhoto(str, str2, str3, str4, str5, verifyEditActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent((Context) VerifyEditActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photostr)) {
                if (VerifyEditActivity.this.photocount < 2 && TextUtils.isEmpty(VerifyEditActivity.this.photoref)) {
                    VerifyEditActivity.this.photocount++;
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, verifyEditActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    VerifyEditActivity.this.photocount = 0;
                    VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(8);
                    VerifyEditActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(VerifyEditActivity.this.whitecolor));
                    VerifyEditActivity.this.binding.chooseFileTv.setEnabled(true);
                    VerifyEditActivity verifyEditActivity2 = VerifyEditActivity.this;
                    verifyEditActivity2.showDialog1(verifyEditActivity2.alertText, VerifyEditActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photo1Str)) {
                if (VerifyEditActivity.this.photo1count < 2 && TextUtils.isEmpty(VerifyEditActivity.this.photo1Ref)) {
                    VerifyEditActivity.this.photo1count++;
                    VerifyEditActivity verifyEditActivity3 = VerifyEditActivity.this;
                    verifyEditActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, verifyEditActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    VerifyEditActivity.this.photo1count = 0;
                    VerifyEditActivity.this.binding.annexPage1Layout.setVisibility(8);
                    VerifyEditActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(VerifyEditActivity.this.blackColor));
                    VerifyEditActivity.this.binding.photo1Annexure.setEnabled(true);
                    VerifyEditActivity verifyEditActivity4 = VerifyEditActivity.this;
                    verifyEditActivity4.showDialog1(verifyEditActivity4.alertText, VerifyEditActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(VerifyEditActivity.this.photo2str)) {
                if (VerifyEditActivity.this.photo2count < 2 && TextUtils.isEmpty(VerifyEditActivity.this.photo2Ref)) {
                    VerifyEditActivity.this.photo2count++;
                    VerifyEditActivity verifyEditActivity5 = VerifyEditActivity.this;
                    verifyEditActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, verifyEditActivity5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                VerifyEditActivity.this.photo2count = 0;
                VerifyEditActivity.this.binding.photo2Layout.setVisibility(8);
                VerifyEditActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(VerifyEditActivity.this.blackColor));
                VerifyEditActivity.this.binding.photo2Annexure.setEnabled(true);
                VerifyEditActivity verifyEditActivity6 = VerifyEditActivity.this;
                verifyEditActivity6.showDialog1(verifyEditActivity6.alertText, VerifyEditActivity.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$22(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$22(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choose_front_camera)) {
            this.temp = this.formverificationPayload.getEpicNo().replaceAll("/", "_") + "_voter_photo";
            Intent intent = new Intent((Context) this, (Class<?>) ManualFaceCaptureActivity.class);
            intent.putExtra("camera_type_configuration", "front");
            intent.putExtra("temp", this.temp);
            startActivityForResult(intent, 10001);
            return;
        }
        if (charSequenceArr[i].equals(this.choose_back_camera)) {
            this.temp = this.formverificationPayload.getEpicNo().replaceAll("/", "_") + "_voter_photo";
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
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass20(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass20(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v37, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
                Logger.d(VerifyEditActivity.this.TAG, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                Toast.makeText((Context) VerifyEditActivity.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    VerifyEditActivity.this.isMotherEPICValid = true;
                    VerifyEditActivity.this.binding.motherName.setText(str);
                    VerifyEditActivity.this.binding.motherName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakMotherName.setClickable(false);
                    VerifyEditActivity.this.binding.speakMotherName.setEnabled(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    VerifyEditActivity.this.isFatherEPICValid = true;
                    VerifyEditActivity.this.binding.fatherName.setText(str);
                    VerifyEditActivity.this.binding.fatherName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakFatherName.setClickable(false);
                    VerifyEditActivity.this.binding.speakFatherName.setEnabled(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Spouse")) {
                    VerifyEditActivity.this.isSpouseEPICValid = true;
                    VerifyEditActivity.this.binding.spouseName.setText(str);
                    VerifyEditActivity.this.binding.spouseName.setEnabled(false);
                    VerifyEditActivity.this.binding.speakSpouseName.setClickable(false);
                    VerifyEditActivity.this.binding.speakSpouseName.setEnabled(false);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Relative")) {
                    VerifyEditActivity.this.isRelativeEPICValid = true;
                    return;
                }
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r11 = VerifyEditActivity.this;
                String str2 = ((VerifyEditActivity) r11).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str3 = this.val$epicEditText;
                final String str4 = this.val$from;
                commomUtility.getRefreshToken(r11, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$20$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str3, str4, i, str5, str6);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                VerifyEditActivity.this.binding.motherEpicNumber.setText("");
                VerifyEditActivity.this.binding.motherName.setEnabled(true);
                VerifyEditActivity.this.binding.speakMotherName.setClickable(true);
                VerifyEditActivity.this.binding.speakMotherName.setEnabled(true);
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                VerifyEditActivity.this.binding.fatherEpicNumber.setText("");
                VerifyEditActivity.this.binding.fatherName.setEnabled(true);
                VerifyEditActivity.this.binding.speakFatherName.setClickable(true);
                VerifyEditActivity.this.binding.speakFatherName.setEnabled(true);
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                VerifyEditActivity.this.binding.spouseEpicNumber.setText("");
                VerifyEditActivity.this.binding.spouseName.setEnabled(true);
                VerifyEditActivity.this.binding.speakSpouseName.setClickable(true);
                VerifyEditActivity.this.binding.speakSpouseName.setEnabled(true);
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString);
                Logger.d(VerifyEditActivity.this.TAG, strOptString);
                Toast.makeText((Context) VerifyEditActivity.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(VerifyEditActivity.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) VerifyEditActivity.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r10 = VerifyEditActivity.this;
                    Toast.makeText((Context) r10, r10.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(VerifyEditActivity.this.TAG, VerifyEditActivity.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                ?? r5 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$20$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            VerifyEditActivity.this.token = VerifyEditActivity.this.bearerText + str3;
            VerifyEditActivity.this.refreshToken = str4;
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken(VerifyEditActivity.this.bearerText + str3);
            VerifyEditActivity.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent((Context) VerifyEditActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(VerifyEditActivity.this.TAG, t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initilizeValue() {
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
        getSessionValue();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.relationNameList = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        this.relationCodeList = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        setRelationShipAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setRelationShipAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.progenyRelationSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getSessionValue() {
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        if (SharedPref.getInstance(getApplicationContext()).getFaceRecognitionFlag().equalsIgnoreCase("Y")) {
            this.faceRecognition = true;
        } else {
            this.faceRecognition = false;
        }
        this.StateList = SharedPref.getInstance(this).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(this).getAcListName(Constants.STATE_LIST_NAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            if (response.code() == 200) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(VerifyEditActivity.this).load(VerifyEditActivity.this.preSignedurl1).into(VerifyEditActivity.this.binding.photo1);
                } else {
                    VerifyEditActivity.this.binding.photo1.setImageDrawable(ContextCompat.getDrawable(VerifyEditActivity.this, R.drawable.blo_pdf_thumbnail));
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.downloadPdfToCache(verifyEditActivity.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.21.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            VerifyEditActivity.this.file1 = file;
                            Log.e("GETFILE", "FILE4::" + VerifyEditActivity.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(VerifyEditActivity.this.preSignedurl1)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(VerifyEditActivity.this.getResources(), R.drawable.blo_dummy_image);
                    VerifyEditActivity.this.binding.annexPage1Layout.setVisibility(0);
                    VerifyEditActivity.this.binding.photo1.setImageBitmap(bitmapDecodeResource);
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                    ?? r5 = VerifyEditActivity.this;
                    String str = ((VerifyEditActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$21$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag);
                }
            } else if (response.code() == 404) {
                if (VerifyEditActivity.this.fromfiled.equalsIgnoreCase("reverify")) {
                    VerifyEditActivity.this.formverificationPayload.setSrFormPage1Url(null);
                }
            } else {
                try {
                    VerifyEditActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$21$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(VerifyEditActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(VerifyEditActivity.this.TAG, e.getMessage());
                }
            }
            VerifyEditActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            VerifyEditActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r5 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r5, ((VerifyEditActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$21$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                VerifyEditActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                VerifyEditActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent((Context) VerifyEditActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag + t.getMessage());
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.showDialog1(verifyEditActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            if (response.code() == 200) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.binding.passPhoto.setVisibility(8);
                VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(0);
                VerifyEditActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(VerifyEditActivity.this).load(VerifyEditActivity.this.preSignedurl3).into(VerifyEditActivity.this.binding.image);
                }
                if (TextUtils.isEmpty(VerifyEditActivity.this.preSignedurl3)) {
                    VerifyEditActivity.this.binding.image.setImageBitmap(BitmapFactory.decodeResource(VerifyEditActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                    ?? r5 = VerifyEditActivity.this;
                    String str = ((VerifyEditActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag);
                }
            } else if (response.code() == 404) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                if (VerifyEditActivity.this.fromfiled.equalsIgnoreCase("reverify") || VerifyEditActivity.this.fromfiled.equalsIgnoreCase("asdlist")) {
                    VerifyEditActivity.this.formverificationPayload.setPhotoUrl("");
                }
            } else {
                try {
                    VerifyEditActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$22$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(VerifyEditActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(VerifyEditActivity.this.TAG, e.getMessage());
                }
            }
            VerifyEditActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            VerifyEditActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r5 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r5, ((VerifyEditActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                VerifyEditActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                VerifyEditActivity.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent((Context) VerifyEditActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag + t.getMessage());
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.showDialog1(verifyEditActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkElectorPhoto(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        AnonymousClass23() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
            } else if (response.code() == 401) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
            } else if (response.code() == 404) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.formverificationPayload.setPhotoUrl("");
            } else {
                try {
                    VerifyEditActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$23$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    });
                    Logger.e(VerifyEditActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(VerifyEditActivity.this.TAG, e.getMessage());
                }
            }
            VerifyEditActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag + t.getMessage());
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.showDialog1(verifyEditActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$23(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$23(String str, pdfDownloadCallback pdfdownloadcallback) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf", ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    pdfdownloadcallback.downloaded(fileCreateTempFile);
                    Log.e("GETFILEq", "FILE119::" + fileCreateTempFile);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void setRelativeType(String relativeType, TextView textView) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            textView.setText("Grand Mother");
            return;
        }
        if (relativeType.equals("GFTH")) {
            textView.setText("Grand Father");
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            textView.setText("Mother");
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            textView.setText("Father");
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            textView.setText("Husband");
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            textView.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            textView.setText("");
        } else {
            textView.setText(relativeType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showcategoryChangeDialog(final int checkedId, final String type) {
        new AlertDialog.Builder(this).setTitle(this.alertText).setMessage("Do you want to change the category type ?").setCancelable(false).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showcategoryChangeDialog$24(type, checkedId, dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showcategoryChangeDialog$25(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showcategoryChangeDialog$24(String str, int i, DialogInterface dialogInterface, int i2) {
        if (str.equalsIgnoreCase("self")) {
            setSelfView(i);
            return;
        }
        if (str.equalsIgnoreCase("progeny")) {
            setProgenyView(i);
        } else if (str.equalsIgnoreCase("Progeny2026")) {
            setProgenyVie2026(i);
        } else if (str.equalsIgnoreCase("NA")) {
            setNeitherView(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showcategoryChangeDialog$25(DialogInterface dialogInterface, int i) {
        if (this.lastCheckedId == this.binding.selfRb.getId()) {
            this.binding.selfRb.setChecked(true);
            return;
        }
        if (this.lastCheckedId == this.binding.progenyRb.getId()) {
            this.binding.progenyRb.setChecked(true);
        } else if (this.lastCheckedId == this.binding.progenyRb2026.getId()) {
            this.binding.progenyRb2026.setChecked(true);
        } else if (this.lastCheckedId == this.binding.neitherRb.getId()) {
            this.binding.neitherRb.setChecked(true);
        }
    }

    public void setSelfView(int checkedId) {
        this.lastCheckedId = checkedId;
        this.binding.ivDelete.setVisibility(8);
        this.submittedForRecommendation = "Y";
        if (checkSelfEmpty() && checkProgenyEmpty()) {
            this.binding.ivAddSelfLl.setVisibility(0);
            this.binding.ivAddProgenyLl.setVisibility(0);
            this.binding.selfCardView.setVisibility(8);
            this.binding.relativeCardView.setVisibility(8);
            return;
        }
        if (checkSelfEmpty() && !checkProgenyEmpty()) {
            this.binding.ivAddSelfLl.setVisibility(0);
            this.binding.ivAddProgenyLl.setVisibility(8);
            this.binding.relativeCardView.setVisibility(0);
            this.binding.ivDeleteProgeny.setVisibility(0);
            this.binding.ivUpdateProgeny.setVisibility(0);
            return;
        }
        if (!checkSelfEmpty() && checkProgenyEmpty()) {
            this.binding.selfCardView.setVisibility(0);
            this.binding.ivDelete.setVisibility(8);
            this.binding.ivUpdate.setVisibility(0);
            this.binding.ivAddProgenyLl.setVisibility(0);
            this.binding.relativeCardView.setVisibility(8);
            return;
        }
        this.binding.selfCardView.setVisibility(0);
        this.binding.ivDelete.setVisibility(8);
        this.binding.ivAddProgenyLl.setVisibility(8);
        this.binding.ivUpdate.setVisibility(0);
        this.binding.relativeCardView.setVisibility(0);
        this.binding.ivDeleteProgeny.setVisibility(0);
        this.binding.ivUpdateProgeny.setVisibility(0);
    }

    public void setProgenyView(int checkedId) {
        this.lastCheckedId = checkedId;
        clearSelfDetailsFromObj();
        this.selfStatus = "D";
        this.binding.selfCardView.setVisibility(8);
        this.binding.ivAddSelfLl.setVisibility(8);
        if (checkProgenyEmpty()) {
            this.binding.ivAddProgenyLl.setVisibility(0);
        } else {
            this.binding.relativeCardView.setVisibility(0);
            this.binding.ivDeleteProgeny.setVisibility(8);
            this.binding.ivUpdateProgeny.setVisibility(0);
            this.binding.relationtypecardview.setVisibility(0);
        }
        this.submittedForRecommendation = "Y";
    }

    public void setProgenyVie2026(int checkedId) {
        this.lastCheckedId = checkedId;
        this.selfStatus = "D";
        this.progenyStatus = "D";
        clearSelfDetailsFromObj();
        clearRelativeDetailsFromObj();
        this.binding.ivAddSelfLl.setVisibility(8);
        this.binding.ivAddProgenyLl.setVisibility(0);
        this.binding.selfCardView.setVisibility(8);
        this.binding.relativeCardView.setVisibility(8);
        this.binding.relationtypecardview.setVisibility(8);
        this.submittedForRecommendation = "N";
    }

    public void setNeitherView(int checkedId) {
        this.lastCheckedId = checkedId;
        this.selfStatus = "D";
        this.progenyStatus = "D";
        clearSelfDetailsFromObj();
        clearRelativeDetailsFromObj();
        this.binding.ivAddSelfLl.setVisibility(8);
        this.binding.ivAddProgenyLl.setVisibility(8);
        this.binding.selfCardView.setVisibility(8);
        this.binding.relativeCardView.setVisibility(8);
        this.binding.relationtypecardview.setVisibility(8);
        this.submittedForRecommendation = "N";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFilePage2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass24(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass24(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            if (response.code() == 200) {
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                VerifyEditActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(VerifyEditActivity.this).load(VerifyEditActivity.this.preSignedurl2).into(VerifyEditActivity.this.binding.photo2);
                } else {
                    VerifyEditActivity.this.binding.photo2.setImageDrawable(ContextCompat.getDrawable(VerifyEditActivity.this, R.drawable.blo_pdf_thumbnail));
                    VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                    verifyEditActivity.downloadPdfToCache(verifyEditActivity.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.24.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            VerifyEditActivity.this.file2 = file;
                            Log.e("GETFILE", "FILE4::" + VerifyEditActivity.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(VerifyEditActivity.this.preSignedurl2)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(VerifyEditActivity.this.getResources(), R.drawable.blo_dummy_image);
                    VerifyEditActivity.this.binding.photo2Layout.setVisibility(0);
                    VerifyEditActivity.this.binding.photo2.setImageBitmap(bitmapDecodeResource);
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                    ?? r5 = VerifyEditActivity.this;
                    String str = ((VerifyEditActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$24$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag);
                }
            } else if (response.code() == 404) {
                if (VerifyEditActivity.this.fromfiled.equalsIgnoreCase("reverify")) {
                    VerifyEditActivity.this.formverificationPayload.setSrFormPage2Url(null);
                }
            } else {
                try {
                    VerifyEditActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$24$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(VerifyEditActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(VerifyEditActivity.this.TAG, e.getMessage());
                }
            }
            VerifyEditActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            VerifyEditActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = VerifyEditActivity.this.commomUtility;
                ?? r5 = VerifyEditActivity.this;
                commomUtility.showMessageOK(r5, ((VerifyEditActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$24$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                VerifyEditActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                VerifyEditActivity.this.getFilePage2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VerifyEditActivity.this.getApplicationContext()).setLocaleBool(false);
            VerifyEditActivity.this.startActivity(new Intent((Context) VerifyEditActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(VerifyEditActivity.this.TAG, VerifyEditActivity.this.comingTag + t.getMessage());
            if (VerifyEditActivity.this.alertDialog != null) {
                VerifyEditActivity.this.alertDialog.dismiss();
            }
            VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
            verifyEditActivity.showDialog1(verifyEditActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpeakText(final EditText editText) {
        this.utils.showVoicePopup(this, new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.25
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
            public void onCallBack(String result) {
                editText.setText(result);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList(String key) {
        this.commomUtility.getSentBackEroEfByEpicId(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.26
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback
            public void onCallBack(int code, List<FormverificationPayload> datalist, String message) {
                if (code == 200) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        VerifyEditActivity.this.formverificationPayload = datalist.get(0);
                        Log.e("ValueBeforeUpdate", VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload));
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.tempFormverificationPayload = (FormverificationPayload) verifyEditActivity.gson.fromJson(VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload), FormverificationPayload.class);
                        VerifyEditActivity.this.setValues();
                        return;
                    }
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = VerifyEditActivity.this.utils;
                        ?? r4 = VerifyEditActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.26.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = VerifyEditActivity.this.utils;
                        ?? r5 = VerifyEditActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.26.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = VerifyEditActivity.this.utils;
                    ?? r6 = VerifyEditActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.26.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = VerifyEditActivity.this.utils;
                    ?? r7 = VerifyEditActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.26.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getAnomalyData(String key) {
        this.commomUtility.getSpecialRevisionFormsPanIndiaByEpicId(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, key, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.27
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback
            public void onCallBack(int code, List<FormverificationPayload> datalist, String message) {
                if (code == 200) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        VerifyEditActivity.this.formverificationPayload = datalist.get(0);
                        Log.e("ValueBeforeUpdate", VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload));
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.tempFormverificationPayload = (FormverificationPayload) verifyEditActivity.gson.fromJson(VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload), FormverificationPayload.class);
                        VerifyEditActivity.this.setValues();
                        return;
                    }
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = VerifyEditActivity.this.utils;
                        ?? r4 = VerifyEditActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.27.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = VerifyEditActivity.this.utils;
                        ?? r5 = VerifyEditActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.27.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = VerifyEditActivity.this.utils;
                    ?? r6 = VerifyEditActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.27.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = VerifyEditActivity.this.utils;
                    ?? r7 = VerifyEditActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.27.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    public void redirecttolistScreen() {
        finish();
    }

    private void clearEF() {
        this.formverificationPayload.setSrFormPage1Url("");
        this.formverificationPayload.setSrFormPage2Url("");
        this.formverificationPayload.setAnnexureCUrl("");
        deleteAnnexure(102);
        deleteAnnexure(103);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.passPhoto.setVisibility(0);
        this.binding.passPhotoLayout.setVisibility(8);
        this.photoref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    public void resetImage(String imagetype, String error) {
        if (imagetype.equals(this.photostr)) {
            this.photoref = "";
            this.binding.image.setVisibility(8);
            this.binding.passPhoto.setVisibility(0);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileTv.setEnabled(true);
        }
        if (imagetype.equals(this.photo1Str)) {
            this.photo1Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.annexurePhoto1LL.setVisibility(0);
            this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo1Annexure.setEnabled(true);
        }
        if (imagetype.equals(this.photo2str)) {
            this.photo2Ref = "";
            this.binding.photo2.setVisibility(8);
            this.binding.photo2Layout.setVisibility(8);
            this.binding.annexurePhoto1LL.setVisibility(0);
            this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.photo2Annexure.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.28
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (uploadType.equals(VerifyEditActivity.this.photostr)) {
                        VerifyEditActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.28.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.binding.passPhotoLayout.setVisibility(0);
                                VerifyEditActivity.this.binding.passPhoto.setVisibility(8);
                                VerifyEditActivity.this.binding.cancel.setVisibility(0);
                                VerifyEditActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(VerifyEditActivity.this.greycolor));
                                VerifyEditActivity.this.binding.chooseFileTv.setEnabled(false);
                                VerifyEditActivity.this.binding.photoNameTv2.setVisibility(0);
                                VerifyEditActivity.this.binding.image.setVisibility(0);
                                Glide.with(VerifyEditActivity.this).load(strReplace).into(VerifyEditActivity.this.binding.image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(VerifyEditActivity.this.photo1Str)) {
                        VerifyEditActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.28.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.binding.annexPage1Layout.setVisibility(0);
                                VerifyEditActivity.this.binding.cancelPhoto1Annexure.setVisibility(0);
                                VerifyEditActivity.this.binding.photo1Name.setVisibility(0);
                                VerifyEditActivity.this.binding.photo1Size.setVisibility(0);
                                VerifyEditActivity.this.binding.photo1.setVisibility(0);
                                VerifyEditActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(VerifyEditActivity.this.greycolor));
                                VerifyEditActivity.this.binding.photo1Annexure.setEnabled(false);
                                Glide.with(VerifyEditActivity.this).load(strReplace).into(VerifyEditActivity.this.binding.photo1);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(VerifyEditActivity.this.photo2str)) {
                        VerifyEditActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.28.3
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.binding.photo2Layout.setVisibility(0);
                                VerifyEditActivity.this.binding.cancelPhoto2Annexure.setVisibility(0);
                                VerifyEditActivity.this.binding.photo2Name.setVisibility(0);
                                VerifyEditActivity.this.binding.photo2Size.setVisibility(0);
                                VerifyEditActivity.this.binding.photo2.setVisibility(0);
                                VerifyEditActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(VerifyEditActivity.this.greycolor));
                                VerifyEditActivity.this.binding.photo2Annexure.setEnabled(false);
                                Glide.with(VerifyEditActivity.this).load(strReplace).into(VerifyEditActivity.this.binding.photo2);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (VerifyEditActivity.this.alertDialog != null) {
                                    VerifyEditActivity.this.alertDialog.dismiss();
                                }
                                VerifyEditActivity.this.resetImage(uploadType, message);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    VerifyEditActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(VerifyEditActivity.this.messageString);
                    Logger.e(VerifyEditActivity.this.TAG, strOptString);
                    VerifyEditActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(VerifyEditActivity.this.TAG, e.getMessage());
                    VerifyEditActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                VerifyEditActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.29
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    VerifyEditActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.29.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(VerifyEditActivity.this.photostr)) {
                            VerifyEditActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(VerifyEditActivity.this.photo1Str)) {
                            VerifyEditActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(VerifyEditActivity.this.photo2str)) {
                            VerifyEditActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    private void hideview() {
        this.binding.photo1Annexure.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.photo1Annexure.setEnabled(true);
        this.binding.annexPage1Layout.setVisibility(8);
        this.binding.photo1Size.setText("");
        this.binding.photo1Name.setText("");
        this.binding.photo2Annexure.setVisibility(0);
        this.binding.annexurePhoto1LL.setVisibility(0);
        this.binding.photo2Annexure.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.photo2Annexure.setEnabled(true);
        this.binding.photo2Layout.setVisibility(8);
        this.binding.photo2Size.setText("");
        this.binding.photo2Name.setText("");
        this.binding.annexurePhoto1LL.setVisibility(0);
        this.binding.photo1Annexure.setVisibility(0);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.passPhoto.setVisibility(0);
        this.binding.passPhotoLayout.setVisibility(8);
        this.photoref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getNomappingData(String key) {
        this.commomUtility.getNomappingData(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.30
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback
            public void onCallBack(int code, List<FormverificationPayload> datalist, String message) {
                if (code == 200) {
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        VerifyEditActivity.this.formverificationPayload = datalist.get(0);
                        Log.e("ValueBeforeUpdate", VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload));
                        VerifyEditActivity verifyEditActivity = VerifyEditActivity.this;
                        verifyEditActivity.tempFormverificationPayload = (FormverificationPayload) verifyEditActivity.gson.fromJson(VerifyEditActivity.this.gson.toJson(VerifyEditActivity.this.formverificationPayload), FormverificationPayload.class);
                        VerifyEditActivity.this.setValues();
                        return;
                    }
                    if (VerifyEditActivity.this.alertDialog != null) {
                        VerifyEditActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = VerifyEditActivity.this.utils;
                        ?? r4 = VerifyEditActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.30.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = VerifyEditActivity.this.utils;
                        ?? r5 = VerifyEditActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.30.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                VerifyEditActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (VerifyEditActivity.this.alertDialog != null) {
                    VerifyEditActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = VerifyEditActivity.this.utils;
                    ?? r6 = VerifyEditActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.30.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = VerifyEditActivity.this.utils;
                    ?? r7 = VerifyEditActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), VerifyEditActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity.30.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            VerifyEditActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$28(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$28(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        ?? r4 = 0;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection2.setConnectTimeout(XmlValidationError.UNDEFINED);
                        httpsURLConnection2.setReadTimeout(20000);
                        httpsURLConnection2.setInstanceFollowRedirects(true);
                        httpsURLConnection2.setRequestMethod("GET");
                        httpsURLConnection2.setUseCaches(false);
                        httpsURLConnection2.setRequestProperty("Accept", "image/*,*/*;q=0.8");
                        httpsURLConnection2.connect();
                        int responseCode = httpsURLConnection2.getResponseCode();
                        if (responseCode != 200) {
                            if (responseCode != 403) {
                                str2 = responseCode != 404 ? "Server returned HTTP " + responseCode : "File not found (HTTP 404). The object may have been deleted or the URL is incorrect.";
                            } else {
                                str2 = "Link expired or invalid (HTTP 403). Please request a new presigned URL.";
                            }
                            throw new IOException(str2);
                        }
                        String contentType = httpsURLConnection2.getContentType();
                        String lowerCase = contentType == null ? "" : contentType.toLowerCase(Locale.US);
                        lowerCase.startsWith("image/");
                        if (httpsURLConnection2.getContentLength() == 0) {
                            throw new IOException("Content-Length is zero; image appears empty.");
                        }
                        InputStream inputStream = httpsURLConnection2.getInputStream();
                        if (inputStream == null) {
                            throw new IOException("Empty response body.");
                        }
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            bufferedInputStream.mark(64);
                            byte[] headBytes = readHeadBytes(bufferedInputStream, 16);
                            bufferedInputStream.reset();
                            if (headBytes.length == 0) {
                                throw new IOException("No data received; image appears empty.");
                            }
                            if (lowerCase.startsWith("image/")) {
                                if (!isImageMagic(headBytes)) {
                                    throw new IOException("Response says image/*, but header bytes don't match known image formats.");
                                }
                            } else if (!isImageMagic(headBytes)) {
                                throw new IOException("Unexpected content type (" + contentType + "); data does not look like an image.");
                            }
                            bufferedInputStream.close();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda25
                                @Override // java.lang.Runnable
                                public final void run() {
                                    downloadCallback.onSuccess(null);
                                }
                            });
                            r4 = headBytes;
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                                r4 = headBytes;
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        httpsURLConnection = httpsURLConnection2;
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity$$ExternalSyntheticLambda26
                            @Override // java.lang.Runnable
                            public final void run() {
                                VerifyEditActivity.DownloadCallback downloadCallback2 = downloadCallback;
                                Exception exc = e;
                                downloadCallback2.onError(exc.getMessage(), exc);
                            }
                        });
                        r4 = httpsURLConnection;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            r4 = httpsURLConnection;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r4 = httpsURLConnection2;
                        if (r4 != 0) {
                            try {
                                r4.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused2) {
        }
    }

    private static byte[] readHeadBytes(InputStream is, int n) throws IOException {
        byte[] bArr = new byte[n];
        int i = is.read(bArr);
        if (i <= 0) {
            return new byte[0];
        }
        return Arrays.copyOf(bArr, i);
    }

    private static boolean isImageMagic(byte[] head) {
        byte b;
        int length = head == null ? 0 : head.length;
        if (length >= 3 && (head[0] & UByte.MAX_VALUE) == 255 && (head[1] & UByte.MAX_VALUE) == 216 && (head[2] & UByte.MAX_VALUE) == 255) {
            return true;
        }
        byte[] bArr = {-119, 80, 78, 71, 13, 10, 26, 10};
        if (length >= 8 && startsWithBytes(head, bArr)) {
            return true;
        }
        if (length >= 6 && head[0] == 71 && head[1] == 73 && head[2] == 70 && head[3] == 56 && (((b = head[4]) == 55 || b == 57) && head[5] == 97)) {
            return true;
        }
        if (length >= 12 && head[0] == 82 && head[1] == 73 && head[2] == 70 && head[3] == 70 && head[8] == 87 && head[9] == 69 && head[10] == 66 && head[11] == 80) {
            return true;
        }
        return length >= 2 && head[0] == 66 && head[1] == 77;
    }

    private static boolean startsWithBytes(byte[] a, byte[] prefix) {
        if (a == null || prefix == null || a.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (a[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }
}
