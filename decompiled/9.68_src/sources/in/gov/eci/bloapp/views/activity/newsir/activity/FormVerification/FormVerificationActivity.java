package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

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
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormverificationBinding;
import in.gov.eci.bloapp.pdfDownloadCallback;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.frs.ManualFaceCaptureActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormVerificationActivity extends AppCompatActivity {
    String No;
    private String SESSION;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivityFormverificationBinding binding;
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
    String spouseEpicNo;
    private String state;
    String submittedForRecommendation;
    String temp;
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
    private String photoref = null;
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\n Weak network detected. Please check your connection and try again.";
    String functionNameForLogBaseActivity = "";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private boolean result = false;
    boolean faceRecognition = true;
    String moduleName = "";
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String garudaTextBaseActivity = "GARUDA";
    private String aadharref = null;
    private String photo1Ref = null;
    private String photo2Ref = null;
    String imageTextBaseActivity = "image";
    File file1 = null;
    File file2 = null;
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
    String getRefreshTokenText = "getRefreshToken : ";
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String fromlist = null;
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    boolean isFatherEPICValid = false;
    boolean isMotherEPICValid = false;
    boolean isSpouseEPICValid = false;
    boolean isRelativeEPICValid = false;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityFormverificationBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.utils = new Utils();
        this.lastSirYear = SharedPref.getInstance(this).getlastSIRYear();
        initilizeValue();
        getIntentValue();
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        if (TextUtils.isEmpty(this.fromlist)) {
            return;
        }
        if (this.fromlist.equalsIgnoreCase("reverify")) {
            this.moduleName = "EFReVerifyForm";
            getVerifyCitizenFormList("A");
            return;
        }
        if (this.fromlist.equalsIgnoreCase("anomaly")) {
            this.moduleName = "anomalylist";
            getAnomalyData("A");
            return;
        }
        if (this.fromlist.equalsIgnoreCase("verify")) {
            this.moduleName = "EFVerifyForm";
            getVerifyCitizenFormList("");
        } else if (this.fromlist.equalsIgnoreCase("asdlist")) {
            this.moduleName = "ASDlist";
            getVerifyCitizenFormList("");
        } else if (this.fromlist.equalsIgnoreCase("draft")) {
            this.moduleName = "draftEF";
            getdraftData("");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList(String key) {
        this.commomUtility.getSpecialRevisionFormsPanIndiaByEpicId(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, key, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        FormVerificationActivity.this.formverificationPayload = datalist.get(0);
                        FormVerificationActivity.this.setValues();
                        return;
                    }
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = FormVerificationActivity.this.utils;
                        ?? r4 = FormVerificationActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = FormVerificationActivity.this.utils;
                        ?? r5 = FormVerificationActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.1.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = FormVerificationActivity.this.utils;
                    ?? r6 = FormVerificationActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.1.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = FormVerificationActivity.this.utils;
                    ?? r7 = FormVerificationActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.1.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getAnomalyData(String key) {
        this.commomUtility.getAnomalyDataByEpic(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, key, new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        FormVerificationActivity.this.formverificationPayload = datalist.get(0);
                        FormVerificationActivity.this.setValues();
                        return;
                    }
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = FormVerificationActivity.this.utils;
                        ?? r4 = FormVerificationActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.2.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = FormVerificationActivity.this.utils;
                        ?? r5 = FormVerificationActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.2.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = FormVerificationActivity.this.utils;
                    ?? r6 = FormVerificationActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.2.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = FormVerificationActivity.this.utils;
                    ?? r7 = FormVerificationActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.2.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }

    private void getIntentValue() {
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
            this.fromlist = intent.getStringExtra("from");
            disableView();
            if (!TextUtils.isEmpty(this.fromlist)) {
                if (this.fromlist.equalsIgnoreCase("reverify") || this.fromlist.equalsIgnoreCase("asdlist")) {
                    this.binding.submitButtonRec.setVisibility(8);
                    if (this.fromlist.equalsIgnoreCase("asdlist")) {
                        this.binding.textView3.setText(getResources().getString(R.string.tv_deceased));
                    } else {
                        this.binding.textView3.setText(getResources().getString(R.string.form_type_reverify_ef));
                    }
                    this.binding.radioNote.setVisibility(0);
                    this.binding.againEnter.setText("Edit/Unmap");
                    this.binding.cardEfphoto.setVisibility(0);
                    this.binding.electorPhotoLayout.setVisibility(0);
                } else if (this.fromlist.equalsIgnoreCase("verify")) {
                    this.binding.submitButtonRec.setVisibility(0);
                    this.binding.radioNote.setVisibility(8);
                    this.binding.cardEfphoto.setVisibility(0);
                    this.binding.electorPhotoLayout.setVisibility(0);
                } else if (this.fromlist.equalsIgnoreCase("draft")) {
                    this.binding.textView3.setText(getResources().getString(R.string.draft_list));
                    this.binding.submitButtonRec.setVisibility(8);
                    this.binding.againEnter.setVisibility(8);
                    this.binding.radioNote.setVisibility(8);
                    this.binding.cardEfphoto.setVisibility(0);
                    this.binding.electorPhotoLayout.setVisibility(0);
                } else if (this.fromlist.equalsIgnoreCase("anomaly")) {
                    this.binding.textView3.setText(getResources().getString(R.string.anomaly));
                    this.binding.submitButtonRec.setVisibility(8);
                    this.binding.againEnter.setVisibility(8);
                    this.binding.radioNote.setVisibility(8);
                    this.binding.cardEfphoto.setVisibility(0);
                    this.binding.electorPhotoLayout.setVisibility(0);
                }
            }
            handleClick();
        }
    }

    private void enableView() {
        this.binding.dateOfBirth.setEnabled(true);
        this.binding.aadharNumber.setEnabled(true);
        this.binding.mobileNumber.setEnabled(true);
        this.binding.fatherEpicNumber.setEnabled(true);
        this.binding.ivSearchFather.setEnabled(true);
        this.binding.fatherName.setEnabled(true);
        this.binding.fatherName.setEnabled(true);
        this.binding.motherEpicNumber.setEnabled(true);
        this.binding.ivSearchMother.setEnabled(true);
        this.binding.motherName.setEnabled(true);
        this.binding.spouseEpicNumber.setEnabled(true);
        this.binding.ivSearchSpouse.setEnabled(true);
        this.binding.spouseName.setEnabled(true);
        this.binding.photo1Annexure.setEnabled(true);
        this.binding.photo2Annexure.setEnabled(true);
        this.binding.chooseFileTv.setEnabled(true);
        this.binding.cancelPhoto1Annexure.setVisibility(0);
        this.binding.cancelPhoto2Annexure.setVisibility(0);
        this.binding.cancel.setVisibility(0);
    }

    private void handleClick() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$0(view);
            }
        });
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$1(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$2(view);
            }
        });
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$3(view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$4(view);
            }
        });
        this.binding.ivSearchMother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormVerificationActivity.this.binding.motherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormVerificationActivity.this.isMotherEPICValid = false;
                FormVerificationActivity.this.checkEpicNumber(strTrim, "Mother");
            }
        });
        this.binding.ivSearchFather.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormVerificationActivity.this.binding.fatherEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormVerificationActivity.this.isFatherEPICValid = false;
                FormVerificationActivity.this.checkEpicNumber(strTrim, "Father");
            }
        });
        this.binding.ivSearchSpouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String strTrim = FormVerificationActivity.this.binding.spouseEpicNumber.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                FormVerificationActivity.this.isSpouseEPICValid = false;
                FormVerificationActivity.this.checkEpicNumber(strTrim, "Spouse");
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$5(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$6(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$7(view);
            }
        });
        this.binding.againEnter.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$8(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClick$9(view);
            }
        });
        this.binding.photo1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!TextUtils.isEmpty(FormVerificationActivity.this.formverificationPayload.getSrFormPage1Url())) {
                    if (FormVerificationActivity.this.formverificationPayload.getSrFormPage1Url().endsWith(".pdf")) {
                        FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                        formVerificationActivity.showPersonPdfDialog(formVerificationActivity.file1, "");
                        return;
                    } else {
                        FormVerificationActivity formVerificationActivity2 = FormVerificationActivity.this;
                        formVerificationActivity2.showImageDialog(formVerificationActivity2.preSignedurl1, "");
                        return;
                    }
                }
                if (TextUtils.isEmpty(FormVerificationActivity.this.formverificationPayload.getAnnexureCUrl()) || !FormVerificationActivity.this.formverificationPayload.getAnnexureCUrl().endsWith(".pdf")) {
                    return;
                }
                FormVerificationActivity formVerificationActivity3 = FormVerificationActivity.this;
                formVerificationActivity3.showPersonPdfDialog(formVerificationActivity3.file1, "");
            }
        });
        this.binding.image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(FormVerificationActivity.this.preSignedurl3)) {
                    return;
                }
                FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                formVerificationActivity.showImageDialog(formVerificationActivity.preSignedurl3, "");
            }
        });
        this.binding.photo2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(FormVerificationActivity.this.preSignedurl2)) {
                    return;
                }
                FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                formVerificationActivity.showImageDialog(formVerificationActivity.preSignedurl2, "");
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
        if (TextUtils.isEmpty(this.photo1Ref)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$5(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$6(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$7(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$handleClick$8(View view) {
        if (this.formverificationPayload != null) {
            Intent intent = new Intent((Context) this, (Class<?>) VerifyEditActivity.class);
            intent.putExtra("data", this.formverificationPayload);
            intent.putExtra("from", this.fromlist);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClick$9(View view) {
        if (this.formverificationPayload != null) {
            submit();
        }
    }

    private void handleItemListner() {
        this.binding.progenyRelationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    FormVerificationActivity.this.relationcode = null;
                } else {
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.relationcode = formVerificationActivity.relationCodeList.get(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setValues() {
        this.binding.selfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSirYear}));
        this.binding.progenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSirYear}));
        this.binding.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{this.lastSirYear}));
        this.binding.includeCurrentDetails.electorNamePendingSir.setText(TextUtils.isEmpty(this.formverificationPayload.getEpicName()) ? "" : this.formverificationPayload.getEpicName());
        this.binding.includeCurrentDetails.epicPendingSir.setText(TextUtils.isEmpty(this.formverificationPayload.getEpicNo()) ? "" : this.formverificationPayload.getEpicNo());
        this.binding.includeCurrentDetails.agePendingSir.setText(String.valueOf(this.formverificationPayload.getErollAge()));
        this.binding.includeCurrentDetails.relativeNamePendingSir.setText(this.formverificationPayload.getRelativeFullName());
        setRelativeType(this.formverificationPayload.getCurrentRelationType(), this.binding.includeCurrentDetails.relativeTypePendingSir);
        this.binding.includeCurrentDetails.serialNoPendingSir.setText(String.valueOf(this.formverificationPayload.getPartSerialNo()));
        this.binding.dateOfBirth.setText(TextUtils.isEmpty(this.formverificationPayload.getDobVerified()) ? "" : this.formverificationPayload.getDobVerified());
        this.binding.mobileNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMobileNo()) ? "" : this.formverificationPayload.getMobileNo());
        this.binding.fatherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianEpicNo()) ? "" : this.formverificationPayload.getFatherOrGuardianEpicNo());
        this.binding.fatherName.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianName()) ? "" : this.formverificationPayload.getFatherOrGuardianName());
        this.binding.motherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersEpicNo()) ? "" : this.formverificationPayload.getMothersEpicNo());
        this.binding.motherName.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersName()) ? "" : this.formverificationPayload.getMothersName());
        this.binding.motherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersEpicNo()) ? "" : this.formverificationPayload.getMothersEpicNo());
        this.binding.spouseEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseEpicNo()) ? "" : this.formverificationPayload.getSpouseEpicNo());
        this.binding.spouseName.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseName()) ? "" : this.formverificationPayload.getSpouseName());
        this.binding.progenyRelationSpinner.setSelection(this.relationCodeList.indexOf(this.formverificationPayload.getRelationType()));
        if (TextUtils.isEmpty(this.formverificationPayload.getAadharNo())) {
            this.binding.aadharNumber.setText("");
        } else {
            this.commomUtility.getaadhar1(this, this.state, this.token, this.formverificationPayload.getAadharNo(), this.atkband, this.rtkband, this.moduleName, new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.MultipleString
                public final void onCallBack(String str, String str2) {
                    this.f$0.lambda$setValues$10(str, str2);
                }
            });
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("progeny")) {
            this.binding.selfCardView.setVisibility(8);
            if (!TextUtils.isEmpty(this.formverificationPayload.getYearOfSirProgeny()) && this.formverificationPayload.getYearOfSirProgeny().equals(Constants.SIR_YEAR_SELF)) {
                this.binding.progenyRb.setChecked(true);
            }
            if (!TextUtils.isEmpty(this.formverificationPayload.getYearOfSirProgeny()) && this.formverificationPayload.getYearOfSirProgeny().equals(Constants.SIR_YEAR_PROGENY)) {
                this.binding.progenyRb2026.setChecked(true);
            }
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("NA")) {
            this.binding.selfCardView.setVisibility(8);
            this.binding.relativeCardView.setVisibility(8);
            this.binding.relationtypecardview.setVisibility(8);
            this.binding.neitherRb.setChecked(true);
        }
        if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("self")) {
            this.binding.selfRb.setChecked(true);
            if (checkProgenyEmpty()) {
                this.binding.relativeCardView.setVisibility(8);
                this.binding.relationtypecardview.setVisibility(8);
            }
        }
        this.binding.tvEpic.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldEpic()) ? "" : this.formverificationPayload.getSelfOldEpic());
        this.binding.tvName.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldName()) ? "" : this.formverificationPayload.getSelfOldName());
        this.binding.tvName1.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnName()) ? "" : this.formverificationPayload.getSelfOldRlnName());
        if (!TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnType())) {
            String selfOldRlnType = this.formverificationPayload.getSelfOldRlnType();
            this.self_selfOldRlnType = selfOldRlnType;
            setRelativeType(selfOldRlnType, this.binding.tvRelation);
        }
        this.binding.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{this.lastSirYear}));
        if (!TextUtils.isEmpty(this.formverificationPayload.getOldStateCd()) && this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            for (int i = 0; i < this.StateList.size(); i++) {
                if (this.StateList.get(i).equalsIgnoreCase(this.formverificationPayload.getOldStateCd())) {
                    this.binding.tvState.setText(TextUtils.isEmpty(this.StateNameList.get(i)) ? "" : this.StateNameList.get(i));
                    break;
                }
            }
        }
        this.binding.tvAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getOldAcName()) ? "" : this.formverificationPayload.getOldAcName());
        if (this.formverificationPayload.getOldAcNo() != 0) {
            this.binding.tvAcNo.setText(String.valueOf(this.formverificationPayload.getOldAcNo()));
        }
        if (this.formverificationPayload.getOldPartNo() != 0) {
            this.binding.tvPartNo.setText(String.valueOf(this.formverificationPayload.getOldPartNo()));
        }
        if (this.formverificationPayload.getOldPslNo() != 0) {
            this.binding.tvSrNo.setText(String.valueOf(this.formverificationPayload.getOldPslNo()));
        }
        this.binding.tvRlEpic.setText(this.formverificationPayload.getRlnPrgyEpic());
        this.binding.tvRlName.setText(this.formverificationPayload.getRlnPrgyName());
        this.binding.tvRlName1.setText(this.formverificationPayload.getRlnPrgyRlnName());
        if (!TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType())) {
            setRelativeType(this.formverificationPayload.getRlnPrgyRlnType(), this.binding.tvRlRelation);
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            for (int i2 = 0; i2 < this.StateList.size(); i2++) {
                if (this.StateList.get(i2).equalsIgnoreCase(this.formverificationPayload.getRelationOldStateCd())) {
                    this.binding.tvRlState.setText(TextUtils.isEmpty(this.StateNameList.get(i2)) ? "" : this.StateNameList.get(i2));
                    break;
                }
            }
        }
        this.binding.tvRlAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getRelationOldAcName()) ? "" : this.formverificationPayload.getRelationOldAcName());
        if (this.formverificationPayload.getRelationOldAcNo() != 0) {
            this.binding.tvRlAcNo.setText(String.valueOf(this.formverificationPayload.getRelationOldAcNo()));
        }
        if (this.formverificationPayload.getRelationOldPartNo() != 0) {
            this.binding.tvRlPartNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPartNo()));
        }
        if (this.formverificationPayload.getRelationOldPslNo() != 0) {
            this.binding.tvRlSrNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPslNo()));
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getAnnexureCUrl())) {
            getFile1(this.formverificationPayload.getAnnexureCUrl());
            if (this.formverificationPayload.getAnnexureCUrl().endsWith(".pdf")) {
                this.binding.photo1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage1Url())) {
            this.binding.annexPage1Layout.setVisibility(0);
            getFile1(this.formverificationPayload.getSrFormPage1Url());
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getSrFormPage2Url())) {
            this.binding.photo2Layout.setVisibility(0);
            getFilePage2(this.formverificationPayload.getSrFormPage2Url());
        }
        if (!TextUtils.isEmpty(this.formverificationPayload.getPhotoUrl())) {
            getFile3(this.formverificationPayload.getPhotoUrl());
        } else {
            this.binding.passPhoto.setVisibility(8);
            this.binding.passPhotoLayout.setVisibility(8);
            this.binding.electorPhotoTV.setVisibility(8);
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        this.minDate = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(1, -18);
        this.maxDate = calendar2.getTime().getTime();
        this.date = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda11
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i3, int i4, int i5) {
                this.f$0.lambda$setValues$11(datePicker, i3, i4, i5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$10(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            return;
        }
        if (str.equalsIgnoreCase("D")) {
            this.binding.aadharNumber.setText("");
        } else {
            this.binding.aadharNumber.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$11(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        openDatePicker();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean submit() {
        if (this.binding.efRadioButtons.getCheckedRadioButtonId() == -1) {
            showDialog1(this.alertText, "Please edit and check elector category");
            return false;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        String submittedForRecommendation = "N";
        map2.put("bloOverridenFlg", "N");
        if (TextUtils.isEmpty(this.formverificationPayload.getSubmittedForRecommendation())) {
            if (this.formverificationPayload.getCategoryType().equalsIgnoreCase("Self") || this.formverificationPayload.getCategoryType().equalsIgnoreCase("Progeny")) {
                submittedForRecommendation = "Y";
            } else if (!this.formverificationPayload.getCategoryType().equalsIgnoreCase("NA")) {
                submittedForRecommendation = this.formverificationPayload.getSubmittedForRecommendation();
            }
        } else {
            submittedForRecommendation = this.formverificationPayload.getSubmittedForRecommendation();
        }
        map2.put("submittedForRecommendation", submittedForRecommendation);
        map2.put("modifiedBy", "BLO");
        map2.put("epicNo", this.formverificationPayload.getEpicNo());
        map2.put("epicId", this.formverificationPayload.getEpicId());
        map2.put("acNo", Integer.valueOf(this.formverificationPayload.getAcNo()));
        map2.put("partNo", Integer.valueOf(this.formverificationPayload.getPartNo()));
        map2.put("partSerialNo", Integer.valueOf(this.formverificationPayload.getPartSerialNo()));
        map2.put("stCode", this.formverificationPayload.getStateCd());
        map2.put("currentAge", Integer.valueOf(this.formverificationPayload.getErollAge()));
        map2.put("categoryType", this.formverificationPayload.getCategoryType());
        map2.put("sirYearSelf", this.formverificationPayload.getYearOfSirSelf());
        map2.put("sirYearProgeny", this.formverificationPayload.getYearOfSirProgeny());
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).updateSpecialRevisionPanIndia(map, map2).enqueue(new AnonymousClass10());
        return false;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass10() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.showDialog1(formVerificationActivity.alertText, string);
                } else {
                    FormVerificationActivity formVerificationActivity2 = FormVerificationActivity.this;
                    formVerificationActivity2.showDialog3("", formVerificationActivity2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$10$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$12(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) VerifyCitizenFormsListActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
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
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$13(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$13(View view) {
        onBackPressed();
    }

    public boolean validate() {
        if (!TextUtils.isEmpty(this.binding.dateOfBirth.getText().toString())) {
            this.dob = this.binding.dateOfBirth.getText().toString();
        }
        if (!TextUtils.isEmpty(this.binding.mobileNumber.getText().toString())) {
            this.mobile = this.binding.mobileNumber.getText().toString();
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
        if (!TextUtils.isEmpty(this.binding.aadharNumber.getText().toString()) && this.binding.aadharNumber.getText().toString().length() < 12) {
            showDialog1(this.alertText, getString(R.string.invalidAadharMsg2));
            return false;
        }
        if (TextUtils.isEmpty(this.mobile)) {
            showDialog1(this.alertText, getString(R.string.enterMobileMsg));
            return false;
        }
        if (this.mobile.length() != 10 || !this.binding.mobileNumber.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
            showDialog1(this.alertText, getString(R.string.incorrecMobileMsg));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.fatherEpicNumber.getText().toString()) && !this.isFatherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_father_verification));
            return false;
        }
        if (!TextUtils.isEmpty(this.binding.motherEpicNumber.getText().toString()) && !this.isMotherEPICValid) {
            showDialog1(this.alertText, getString(R.string.error_mother_verification));
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$14(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$14(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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
        this.temp = this.epicNumber + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$15(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$15(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$16(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$16(DialogInterface dialogInterface, int i) {
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$17(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$18(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$17(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$18(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:119:0x048e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0493  */
    /* JADX WARN: Code duplicated, block: B:125:0x049a  */
    /* JADX WARN: Code duplicated, block: B:127:0x049e A[Catch: Exception -> 0x06f0, TRY_ENTER, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:129:0x04ec A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0509 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0550 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:136:0x056b A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:138:0x056f A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0585 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:141:0x061b A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:143:0x062d A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0654 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0658 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:147:0x066e A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:150:0x06e5 A[Catch: Exception -> 0x06f0, TryCatch #0 {Exception -> 0x06f0, blocks: (B:127:0x049e, B:129:0x04ec, B:130:0x04f1, B:132:0x0534, B:134:0x0550, B:136:0x056b, B:138:0x056f, B:140:0x059f, B:149:0x06e1, B:139:0x0585, B:141:0x061b, B:143:0x062d, B:144:0x0654, B:146:0x0658, B:148:0x0688, B:147:0x066e, B:150:0x06e5, B:151:0x06ef, B:131:0x0509), top: B:155:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v19 */
    /* JADX WARN: Type inference failed for: r22v20 */
    /* JADX WARN: Type inference failed for: r22v21 */
    /* JADX WARN: Type inference failed for: r22v22 */
    /* JADX WARN: Type inference failed for: r22v23 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r2v104, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v131, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v54, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r35v1 */
    /* JADX WARN: Type inference failed for: r35v10 */
    /* JADX WARN: Type inference failed for: r35v11 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v13 */
    /* JADX WARN: Type inference failed for: r35v14 */
    /* JADX WARN: Type inference failed for: r35v16 */
    /* JADX WARN: Type inference failed for: r35v17 */
    /* JADX WARN: Type inference failed for: r35v18 */
    /* JADX WARN: Type inference failed for: r35v19 */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v20 */
    /* JADX WARN: Type inference failed for: r35v21 */
    /* JADX WARN: Type inference failed for: r35v22 */
    /* JADX WARN: Type inference failed for: r35v23 */
    /* JADX WARN: Type inference failed for: r35v24 */
    /* JADX WARN: Type inference failed for: r35v25 */
    /* JADX WARN: Type inference failed for: r35v26 */
    /* JADX WARN: Type inference failed for: r35v27 */
    /* JADX WARN: Type inference failed for: r35v3 */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARN: Type inference failed for: r35v5 */
    /* JADX WARN: Type inference failed for: r35v8 */
    /* JADX WARN: Type inference failed for: r35v9 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.Context, androidx.appcompat.app.AppCompatActivity, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r35;
        ?? r15;
        int i3;
        ?? r22;
        Uri uri;
        int i4;
        Uri saveImagePath;
        Cursor cursorQuery;
        String[] strArrSplit;
        long j;
        double dRound;
        File file;
        ?? r36;
        ?? applicationContext;
        ?? r37;
        ?? r23;
        ?? r16;
        Exception exc;
        ?? r38;
        ?? r24;
        ?? r17;
        ?? r39;
        ?? r25;
        ?? r18;
        ?? r310;
        ?? r19;
        ?? r12 = i2;
        super.onActivityResult(i, i2, intent);
        String str = "/";
        ?? r110 = 80;
        r110 = 80;
        ?? r8 = "KB";
        r8 = 10001;
        if (r12 != -1) {
            r35 = "KB";
            r15 = "MB";
            i3 = i;
            r22 = "img_";
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
                applicationContext = getApplicationContext();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), data);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.pdfbyteArray = byteArray;
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(byteArray, 0), "image", this.temp);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split("/");
                    String str2 = strArrSplit2[strArrSplit2.length - 1];
                    if (i != 101) {
                        data = data;
                        String str3 = "KB";
                        r110 = "MB";
                        applicationContext = "img_";
                        str = "/";
                        if (i == 102) {
                            r18 = r110;
                            r25 = applicationContext;
                            r39 = str3;
                            long j2 = this.filesize;
                            try {
                                if (j2 < 1024) {
                                    try {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        this.binding.photo2Layout.setVisibility(0);
                                        this.binding.cancelPhoto2Annexure.setVisibility(0);
                                        this.binding.photo2Name.setVisibility(0);
                                        this.binding.photo2Size.setVisibility(0);
                                        this.binding.photo2.setVisibility(0);
                                        ImageView imageView = this.binding.photo2;
                                        byte[] bArr = this.pdfbyteArray;
                                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                        this.binding.photo2Annexure.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.photo2Annexure.setEnabled(false);
                                        this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                        String str4 = str3;
                                        this.binding.photo2Size.setText(this.filesize + str4);
                                        r12 = str4;
                                        r39 = r12;
                                        r18 = r110;
                                        r25 = applicationContext;
                                    } catch (Exception e) {
                                        e = e;
                                        r36 = str3;
                                        exc = e;
                                        r16 = r110;
                                        r23 = applicationContext;
                                        r37 = r36;
                                        Logger.d("", exc.getMessage());
                                        r17 = r16;
                                        r24 = r23;
                                        r38 = r37;
                                    }
                                } else {
                                    r12 = str3;
                                    if (j2 > 2048) {
                                        try {
                                            this.binding.photo2Layout.setVisibility(8);
                                            this.binding.cancelPhoto2Annexure.setVisibility(8);
                                            this.binding.photo2Name.setVisibility(8);
                                            this.binding.photo2Size.setVisibility(8);
                                            this.binding.photo2.setVisibility(8);
                                            this.binding.photo2Annexure.setEnabled(true);
                                            this.binding.photo1Annexure.setVisibility(0);
                                            this.binding.photo2Annexure.setVisibility(0);
                                            showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                                            r12 = r12;
                                        } catch (Exception e2) {
                                            e = e2;
                                            exc = e;
                                            r37 = r12;
                                            r16 = r110;
                                            r23 = applicationContext;
                                            Logger.d("", exc.getMessage());
                                            r17 = r16;
                                            r24 = r23;
                                            r38 = r37;
                                        }
                                    } else {
                                        try {
                                            long j3 = j2 / 1024;
                                            this.filesize = j3;
                                            double dRound2 = Math.round(j3 * 100.0d) / 100.0d;
                                            if (dRound2 > 2.0d) {
                                                this.binding.photo2Layout.setVisibility(8);
                                                this.binding.photo2Annexure.setEnabled(true);
                                                showDialog1(this.alertText, this.imgmsg);
                                                r12 = r12;
                                            } else {
                                                r39 = r12;
                                                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                                this.binding.photo2Layout.setVisibility(0);
                                                this.binding.cancelPhoto2Annexure.setVisibility(0);
                                                this.binding.photo2Name.setVisibility(0);
                                                this.binding.photo2Size.setVisibility(0);
                                                this.binding.photo2.setVisibility(0);
                                                ImageView imageView2 = this.binding.photo2;
                                                byte[] bArr2 = this.pdfbyteArray;
                                                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                                this.binding.photo2Annexure.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.photo2Annexure.setEnabled(false);
                                                this.binding.photo2Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                this.binding.photo2Size.setText(new StringBuilder().append(dRound2).append(r110).toString());
                                                r18 = r110;
                                                r25 = applicationContext;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            r36 = r12;
                                            exc = e;
                                            r16 = r110;
                                            r23 = applicationContext;
                                            r37 = r36;
                                            Logger.d("", exc.getMessage());
                                            r17 = r16;
                                            r24 = r23;
                                            r38 = r37;
                                        }
                                    }
                                    r39 = r12;
                                    r18 = r110;
                                    r25 = applicationContext;
                                }
                            } catch (Exception e4) {
                                e = e4;
                            }
                        }
                        r18 = r110;
                        r25 = applicationContext;
                        r39 = str3;
                        cursorQuery2.close();
                        r17 = r18;
                        r24 = r25;
                        r38 = r39;
                        i3 = i;
                        uri = data;
                        r15 = r17;
                        r22 = r24;
                        r35 = r38;
                    } else {
                        long j4 = this.filesize;
                        try {
                            if (j4 < 1024) {
                                try {
                                    try {
                                        try {
                                            data = data;
                                            str = "/";
                                            String str5 = "KB";
                                            Object obj = "MB";
                                            try {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                this.binding.annexPage1Layout.setVisibility(0);
                                                this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                this.binding.photo1Name.setVisibility(0);
                                                this.binding.photo1Size.setVisibility(0);
                                                this.binding.photo1.setVisibility(0);
                                                ImageView imageView3 = this.binding.photo1;
                                                byte[] bArr3 = this.pdfbyteArray;
                                                imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                                this.binding.photo1Annexure.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.photo1Annexure.setEnabled(false);
                                                try {
                                                    this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                    String str6 = str5;
                                                    this.binding.photo1Size.setText(this.filesize + str6);
                                                    r8 = str6;
                                                    r110 = obj;
                                                    r39 = r8;
                                                    r25 = "img_";
                                                    r18 = r110;
                                                    r18 = r110;
                                                    r25 = applicationContext;
                                                    r39 = str3;
                                                    cursorQuery2.close();
                                                    r17 = r18;
                                                    r24 = r25;
                                                    r38 = r39;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    exc = e;
                                                    r19 = obj;
                                                    r310 = str5;
                                                    r23 = "img_";
                                                    r16 = r19;
                                                    r37 = r310;
                                                    Logger.d("", exc.getMessage());
                                                    r17 = r16;
                                                    r24 = r23;
                                                    r38 = r37;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            r110 = "MB";
                                            exc = e;
                                            r310 = r8;
                                            r19 = r110;
                                            r23 = "img_";
                                            r16 = r19;
                                            r37 = r310;
                                            Logger.d("", exc.getMessage());
                                            r17 = r16;
                                            r24 = r23;
                                            r38 = r37;
                                            i3 = i;
                                            uri = data;
                                            r15 = r17;
                                            r22 = r24;
                                            r35 = r38;
                                            if (i3 != 100) {
                                                i4 = 10001;
                                                if (i3 != 10001) {
                                                    return;
                                                }
                                            } else {
                                                i4 = 10001;
                                            }
                                            if (i2 == -1) {
                                                try {
                                                    if (i3 == i4) {
                                                        saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                                                        this.saveImageFileName = ((String) r22) + this.temp + this.jpgTextBaseActivity;
                                                        file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                                                        if (file.exists()) {
                                                            Log.e("extract", "extract true");
                                                        }
                                                        this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
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
                                                        this.binding.passPhotoLayout.setVisibility(0);
                                                        this.binding.passPhoto.setVisibility(8);
                                                        this.binding.cancel.setVisibility(0);
                                                        this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                                                        this.binding.chooseFileTv.setEnabled(false);
                                                        this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                        this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                                                        this.binding.photoSize.setVisibility(0);
                                                        this.binding.photoNameTv2.setVisibility(0);
                                                        this.binding.image.setVisibility(0);
                                                        ImageView imageView4 = this.binding.image;
                                                        byte[] bArr4 = this.byteArray;
                                                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                                    } else {
                                                        long j5 = j / 1024;
                                                        this.filesize = j5;
                                                        dRound = Math.round(j5 * 100.0d) / 100.0d;
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
                                                            this.binding.passPhoto.setVisibility(8);
                                                            this.binding.passPhotoLayout.setVisibility(0);
                                                            this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                                                            this.binding.chooseFileTv.setEnabled(false);
                                                            this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                                                            this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r15).toString());
                                                            ImageView imageView5 = this.binding.image;
                                                            byte[] bArr5 = this.byteArray;
                                                            imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                                        }
                                                    }
                                                    cursorQuery.close();
                                                } catch (Exception e8) {
                                                    Logger.d("tag", e8.getMessage());
                                                    return;
                                                }
                                            }
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        r110 = "MB";
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    data = data;
                                    r8 = "KB";
                                    r110 = "MB";
                                    str = "/";
                                }
                                i3 = i;
                                uri = data;
                                r15 = r17;
                                r22 = r24;
                                r35 = r38;
                            } else {
                                data = data;
                                r8 = "KB";
                                r110 = "MB";
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
                                        r8 = r8;
                                        r110 = r110;
                                    } catch (Exception e11) {
                                        e = e11;
                                        exc = e;
                                        r310 = r8;
                                        r19 = r110;
                                        r23 = "img_";
                                        r16 = r19;
                                        r37 = r310;
                                        Logger.d("", exc.getMessage());
                                        r17 = r16;
                                        r24 = r23;
                                        r38 = r37;
                                    }
                                } else {
                                    try {
                                        long j6 = j4 / 1024;
                                        this.filesize = j6;
                                        double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                                        if (dRound3 > 2.0d) {
                                            this.binding.annexPage1Layout.setVisibility(8);
                                            this.binding.photo1Annexure.setEnabled(true);
                                            showDialog1(this.alertText, this.imgmsg);
                                            r8 = r8;
                                            r110 = r110;
                                        } else {
                                            applicationContext = "img_";
                                            try {
                                                r39 = r8;
                                                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                this.binding.annexPage1Layout.setVisibility(0);
                                                this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                this.binding.photo1Name.setVisibility(0);
                                                this.binding.photo1Size.setVisibility(0);
                                                this.binding.photo1.setVisibility(0);
                                                ImageView imageView6 = this.binding.photo1;
                                                byte[] bArr6 = this.pdfbyteArray;
                                                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                                this.binding.photo1Annexure.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.photo1Annexure.setEnabled(false);
                                                this.binding.photo1Name.setText(strArrSplit2[strArrSplit2.length - 1]);
                                                this.binding.photo1Size.setText(new StringBuilder().append(dRound3).append(r110).toString());
                                                r18 = r110;
                                                r25 = applicationContext;
                                            } catch (Exception e12) {
                                                e = e12;
                                                r36 = r8;
                                                exc = e;
                                                r16 = r110;
                                                r23 = applicationContext;
                                                r37 = r36;
                                                Logger.d("", exc.getMessage());
                                                r17 = r16;
                                                r24 = r23;
                                                r38 = r37;
                                            }
                                        }
                                        r18 = r110;
                                        r25 = applicationContext;
                                        r39 = str3;
                                        cursorQuery2.close();
                                        r17 = r18;
                                        r24 = r25;
                                        r38 = r39;
                                    } catch (Exception e13) {
                                        e = e13;
                                        r36 = r8;
                                        applicationContext = "img_";
                                    }
                                    i3 = i;
                                    uri = data;
                                    r15 = r17;
                                    r22 = r24;
                                    r35 = r38;
                                }
                                r39 = r8;
                                r25 = "img_";
                                r18 = r110;
                                r18 = r110;
                                r25 = applicationContext;
                                r39 = str3;
                                cursorQuery2.close();
                                r17 = r18;
                                r24 = r25;
                                r38 = r39;
                                i3 = i;
                                uri = data;
                                r15 = r17;
                                r22 = r24;
                                r35 = r38;
                            }
                        } catch (Exception e14) {
                            e = e14;
                        }
                    }
                } catch (Exception e15) {
                    e = e15;
                }
            } catch (Exception e16) {
                e = e16;
                data = data;
                r36 = "KB";
                r110 = "MB";
                applicationContext = "img_";
                str = "/";
            }
            exc = e;
            r16 = r110;
            r23 = applicationContext;
            r37 = r36;
            Logger.d("", exc.getMessage());
            r17 = r16;
            r24 = r23;
            r38 = r37;
            i3 = i;
            uri = data;
            r15 = r17;
            r22 = r24;
            r35 = r38;
        }
        if (i3 != 100) {
            i4 = 10001;
            if (i3 != 10001) {
                return;
            }
        } else {
            i4 = 10001;
        }
        if (i2 == -1) {
            if (i3 == i4) {
                saveImagePath = Uri.parse(intent.getStringExtra("file_uri"));
                this.saveImageFileName = ((String) r22) + this.temp + this.jpgTextBaseActivity;
                file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", this.saveImageFileName);
                if (file.exists()) {
                    Log.e("extract", "extract true");
                }
                this.binding.image.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
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
                this.binding.passPhotoLayout.setVisibility(0);
                this.binding.passPhoto.setVisibility(8);
                this.binding.cancel.setVisibility(0);
                this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileTv.setEnabled(false);
                this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r35).toString());
                this.binding.photoSize.setVisibility(0);
                this.binding.photoNameTv2.setVisibility(0);
                this.binding.image.setVisibility(0);
                ImageView imageView7 = this.binding.image;
                byte[] bArr7 = this.byteArray;
                imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
            } else {
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
                    this.binding.passPhoto.setVisibility(8);
                    this.binding.passPhotoLayout.setVisibility(0);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileTv.setEnabled(false);
                    this.binding.photoNameTv2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.photoSize.setText(new StringBuilder().append(dRound).append(r15).toString());
                    ImageView imageView8 = this.binding.image;
                    byte[] bArr8 = this.byteArray;
                    imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
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
        callFaceRecognitionApi.enqueue(new AnonymousClass11(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass11(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                Context applicationContext = FormVerificationActivity.this.getApplicationContext();
                String str = FormVerificationActivity.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$11$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                FormVerificationActivity.this.alertDialog.dismiss();
                if (this.val$uploadtype.equalsIgnoreCase(FormVerificationActivity.this.photostr)) {
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formVerificationActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                return;
            }
            try {
                FormVerificationActivity.this.binding.passPhotoLayout.setVisibility(8);
                FormVerificationActivity.this.binding.passPhoto.setVisibility(0);
                FormVerificationActivity.this.binding.chooseFileTv.setEnabled(true);
                FormVerificationActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(FormVerificationActivity.this.whitecolor));
                new JSONObject(response.errorBody().string());
                FormVerificationActivity formVerificationActivity2 = FormVerificationActivity.this;
                formVerificationActivity2.showDialog1(formVerificationActivity2.alertText, FormVerificationActivity.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r2 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r2, ((FormVerificationActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                FormVerificationActivity.this.alertDialog.dismiss();
                return;
            }
            FormVerificationActivity.this.alertDialog.dismiss();
            FormVerificationActivity.this.token = "Bearer " + str8;
            FormVerificationActivity.this.refreshToken = str9;
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.faceRecognition(str, str2, str3, str4, str5, formVerificationActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent(FormVerificationActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            FormVerificationActivity.this.binding.passPhotoLayout.setVisibility(8);
            FormVerificationActivity.this.binding.chooseFileTv.setEnabled(true);
            FormVerificationActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(FormVerificationActivity.this.whitecolor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.showDialog1(formVerificationActivity.alertText, t.getMessage());
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
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
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass12(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass12(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v18, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                FormVerificationActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r13 = FormVerificationActivity.this;
                String str = ((FormVerificationActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$12$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
                FormVerificationActivity.this.alertDialog.dismiss();
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
                        FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                        formVerificationActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formVerificationActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    FormVerificationActivity.this.alertDialog.dismiss();
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UploadWithPreSignedURL.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(FormVerificationActivity.this.photostr)) {
                        FormVerificationActivity.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (FormVerificationActivity.this.alertDialog != null) {
                            FormVerificationActivity.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(FormVerificationActivity.this.photo1Str)) {
                        FormVerificationActivity.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (FormVerificationActivity.this.alertDialog != null) {
                            FormVerificationActivity.this.alertDialog.dismiss();
                        }
                    }
                    if (this.val$uploadtype.equals(FormVerificationActivity.this.photo2str)) {
                        FormVerificationActivity.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (FormVerificationActivity.this.alertDialog != null) {
                            FormVerificationActivity.this.alertDialog.dismiss();
                        }
                    }
                    Logger.d(FormVerificationActivity.this.TAG, "Presigned URL : " + strDecryptUrl);
                    UploadWithPreSignedURL.uploadToS3(this.val$filepath + this.val$captureFileName, FormVerificationActivity.this.mime, strDecryptUrl, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.12.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                        public void onResult(boolean isValidate) {
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photostr)) {
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.photocount = 0;
                FormVerificationActivity.this.binding.chooseFileTv.setEnabled(true);
                FormVerificationActivity.this.binding.passPhotoLayout.setVisibility(8);
                FormVerificationActivity formVerificationActivity2 = FormVerificationActivity.this;
                formVerificationActivity2.showDialog1(formVerificationActivity2.alertText, FormVerificationActivity.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photo1Str)) {
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.photo1count = 0;
                FormVerificationActivity.this.binding.annexPage1Layout.setVisibility(8);
                FormVerificationActivity.this.binding.photo1Annexure.setEnabled(true);
                FormVerificationActivity formVerificationActivity3 = FormVerificationActivity.this;
                formVerificationActivity3.showDialog1(formVerificationActivity3.alertText, FormVerificationActivity.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photo2str)) {
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.photo2count = 0;
                FormVerificationActivity.this.binding.photo2Annexure.setEnabled(true);
                FormVerificationActivity.this.binding.photo2Layout.setVisibility(8);
                FormVerificationActivity formVerificationActivity4 = FormVerificationActivity.this;
                formVerificationActivity4.showDialog1(formVerificationActivity4.alertText, FormVerificationActivity.this.fileNotFoundMessage);
            }
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r2 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r2, ((FormVerificationActivity) r2).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$12$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormVerificationActivity.this.alertDialog.dismiss();
            FormVerificationActivity.this.token = "Bearer " + str8;
            FormVerificationActivity.this.refreshToken = str9;
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.uploadPhoto(str, str2, str3, str4, str5, formVerificationActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent((Context) FormVerificationActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photostr)) {
                if (FormVerificationActivity.this.photocount < 2 && TextUtils.isEmpty(FormVerificationActivity.this.photoref)) {
                    FormVerificationActivity.this.photocount++;
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formVerificationActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    FormVerificationActivity.this.photocount = 0;
                    FormVerificationActivity.this.binding.passPhotoLayout.setVisibility(8);
                    FormVerificationActivity.this.binding.chooseFileTv.setTextColor(Color.parseColor(FormVerificationActivity.this.whitecolor));
                    FormVerificationActivity.this.binding.chooseFileTv.setEnabled(true);
                    FormVerificationActivity formVerificationActivity2 = FormVerificationActivity.this;
                    formVerificationActivity2.showDialog1(formVerificationActivity2.alertText, FormVerificationActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photo1Str)) {
                if (FormVerificationActivity.this.photo1count < 2 && TextUtils.isEmpty(FormVerificationActivity.this.photo1Ref)) {
                    FormVerificationActivity.this.photo1count++;
                    FormVerificationActivity formVerificationActivity3 = FormVerificationActivity.this;
                    formVerificationActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formVerificationActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    FormVerificationActivity.this.photo1count = 0;
                    FormVerificationActivity.this.binding.annexPage1Layout.setVisibility(8);
                    FormVerificationActivity.this.binding.photo1Annexure.setTextColor(Color.parseColor(FormVerificationActivity.this.blackColor));
                    FormVerificationActivity.this.binding.photo1Annexure.setEnabled(true);
                    FormVerificationActivity formVerificationActivity4 = FormVerificationActivity.this;
                    formVerificationActivity4.showDialog1(formVerificationActivity4.alertText, FormVerificationActivity.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormVerificationActivity.this.photo2str)) {
                if (FormVerificationActivity.this.photo2count < 2 && TextUtils.isEmpty(FormVerificationActivity.this.photo2Ref)) {
                    FormVerificationActivity.this.photo2count++;
                    FormVerificationActivity formVerificationActivity5 = FormVerificationActivity.this;
                    formVerificationActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formVerificationActivity5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                FormVerificationActivity.this.photo2count = 0;
                FormVerificationActivity.this.binding.photo2Layout.setVisibility(8);
                FormVerificationActivity.this.binding.photo2Annexure.setTextColor(Color.parseColor(FormVerificationActivity.this.blackColor));
                FormVerificationActivity.this.binding.photo2Annexure.setEnabled(true);
                FormVerificationActivity formVerificationActivity6 = FormVerificationActivity.this;
                formVerificationActivity6.showDialog1(formVerificationActivity6.alertText, FormVerificationActivity.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void choosseCameraOption() {
        final CharSequence[] charSequenceArr = {this.choose_front_camera, this.choose_back_camera, this.cancel};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alertMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$choosseCameraOption$19(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$choosseCameraOption$19(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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
        commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass13(from, commomUtility, epicEditText));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonArray> {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ String val$epicEditText;
        final /* synthetic */ String val$from;

        AnonymousClass13(final String val$from, final CommomUtility val$commonUtilClass, final String val$epicEditText) {
            this.val$from = val$from;
            this.val$commonUtilClass = val$commonUtilClass;
            this.val$epicEditText = val$epicEditText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
        /* JADX WARN: Type inference failed for: r9v19, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                Logger.d(FormVerificationActivity.this.TAG, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                Toast.makeText((Context) FormVerificationActivity.this, (CharSequence) "Valid EPIC", 1).show();
                if (this.val$from.equalsIgnoreCase("Mother")) {
                    FormVerificationActivity.this.isMotherEPICValid = true;
                    FormVerificationActivity.this.binding.motherName.setText(str);
                    return;
                }
                if (this.val$from.equalsIgnoreCase("Father")) {
                    FormVerificationActivity.this.isFatherEPICValid = true;
                    FormVerificationActivity.this.binding.fatherName.setText(str);
                    return;
                } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                    FormVerificationActivity.this.isSpouseEPICValid = true;
                    FormVerificationActivity.this.binding.spouseName.setText(str);
                    return;
                } else {
                    if (this.val$from.equalsIgnoreCase("Relative")) {
                        FormVerificationActivity.this.isRelativeEPICValid = true;
                        return;
                    }
                    return;
                }
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = this.val$commonUtilClass;
                ?? r10 = FormVerificationActivity.this;
                String str2 = ((FormVerificationActivity) r10).refreshToken;
                final CommomUtility commomUtility2 = this.val$commonUtilClass;
                final String str3 = this.val$epicEditText;
                final String str4 = this.val$from;
                commomUtility.getRefreshToken(r10, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$13$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str5, String str6) {
                        this.f$0.lambda$onResponse$1(commomUtility2, str3, str4, i, str5, str6);
                    }
                });
                return;
            }
            if (this.val$from.equalsIgnoreCase("Mother")) {
                FormVerificationActivity.this.binding.motherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Father")) {
                FormVerificationActivity.this.binding.fatherEpicNumber.setText("");
            } else if (this.val$from.equalsIgnoreCase("Spouse")) {
                FormVerificationActivity.this.binding.spouseEpicNumber.setText("");
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(FormVerificationActivity.this.messageString);
                Logger.d(FormVerificationActivity.this.TAG, strOptString);
                Toast.makeText((Context) FormVerificationActivity.this, (CharSequence) strOptString, 1).show();
            } catch (Exception e) {
                Logger.d(FormVerificationActivity.this.TAG, e.getMessage());
                if (response != null && response.code() != 200 && response.message() != null) {
                    Toast.makeText((Context) FormVerificationActivity.this, (CharSequence) response.message(), 1).show();
                } else {
                    ?? r9 = FormVerificationActivity.this;
                    Toast.makeText((Context) r9, r9.noDataString, 1).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
        public /* synthetic */ void lambda$onResponse$1(CommomUtility commomUtility, String str, String str2, int i, String str3, String str4) {
            Logger.d(FormVerificationActivity.this.TAG, FormVerificationActivity.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                ?? r5 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r5, r5.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$13$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormVerificationActivity.this.token = FormVerificationActivity.this.bearerText + str3;
            FormVerificationActivity.this.refreshToken = str4;
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str4);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken(FormVerificationActivity.this.bearerText + str3);
            FormVerificationActivity.this.checkEpicNumber(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent((Context) FormVerificationActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(FormVerificationActivity.this.TAG, t.getMessage());
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
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
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

    public void disableView() {
        this.binding.dateOfBirth.setEnabled(false);
        this.binding.dateOfBirth.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.aadharNumber.setEnabled(false);
        this.binding.aadharNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.mobileNumber.setEnabled(false);
        this.binding.mobileNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.fatherEpicNumber.setEnabled(false);
        this.binding.fatherEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchFather.setEnabled(false);
        this.binding.ivSearchFather.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.fatherName.setEnabled(false);
        this.binding.fatherName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.motherEpicNumber.setEnabled(false);
        this.binding.motherEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchMother.setEnabled(false);
        this.binding.ivSearchMother.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.motherName.setEnabled(false);
        this.binding.motherName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.spouseEpicNumber.setEnabled(false);
        this.binding.spouseEpicNumber.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.ivSearchSpouse.setEnabled(false);
        this.binding.ivSearchSpouse.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.spouseName.setEnabled(false);
        this.binding.spouseName.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.photo1Annexure.setEnabled(false);
        this.binding.photo2Annexure.setEnabled(false);
        this.binding.chooseFileTv.setEnabled(false);
        this.binding.progenyRelationSpinner.setEnabled(false);
        this.binding.progenyRelationSpinner.setBackgroundColor(getColor(R.color.disable_grey));
        this.binding.cancelPhoto1Annexure.setVisibility(8);
        this.binding.cancelPhoto2Annexure.setVisibility(8);
        this.binding.cancel.setVisibility(8);
        this.binding.efRadioButtons.setEnabled(false);
        this.binding.selfRb.setClickable(false);
        this.binding.selfRb.setFocusable(false);
        this.binding.progenyRb.setClickable(false);
        this.binding.progenyRb.setFocusable(false);
        this.binding.neitherRb.setClickable(false);
        this.binding.neitherRb.setFocusable(false);
        this.binding.progenyRb2026.setClickable(false);
        this.binding.progenyRb2026.setFocusable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormVerificationActivity.this).load(FormVerificationActivity.this.preSignedurl1).into(FormVerificationActivity.this.binding.photo1);
                } else {
                    FormVerificationActivity.this.binding.annexPage1Layout.setVisibility(0);
                    FormVerificationActivity.this.binding.photo1.setImageDrawable(ContextCompat.getDrawable(FormVerificationActivity.this, R.drawable.blo_pdf_thumbnail));
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.downloadPdfToCache(formVerificationActivity.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.14.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormVerificationActivity.this.file1 = file;
                            Log.e("GETFILE", "FILE4::" + FormVerificationActivity.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormVerificationActivity.this.preSignedurl1)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(FormVerificationActivity.this.getResources(), R.drawable.blo_dummy_image);
                    FormVerificationActivity.this.binding.annexPage1Layout.setVisibility(0);
                    FormVerificationActivity.this.binding.photo1.setImageBitmap(bitmapDecodeResource);
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                    ?? r5 = FormVerificationActivity.this;
                    String str = ((FormVerificationActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$14$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag);
                }
            } else {
                try {
                    FormVerificationActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$14$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormVerificationActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(FormVerificationActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(FormVerificationActivity.this.TAG, e.getMessage());
                }
            }
            FormVerificationActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
            FormVerificationActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r5 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r5, ((FormVerificationActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$14$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormVerificationActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                FormVerificationActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent((Context) FormVerificationActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag + t.getMessage());
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.showDialog1(formVerificationActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFilePage2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormVerificationActivity.this).load(FormVerificationActivity.this.preSignedurl2).into(FormVerificationActivity.this.binding.photo2);
                } else {
                    FormVerificationActivity.this.binding.photo2Layout.setVisibility(0);
                    FormVerificationActivity.this.binding.photo2.setImageDrawable(ContextCompat.getDrawable(FormVerificationActivity.this, R.drawable.blo_pdf_thumbnail));
                    FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
                    formVerificationActivity.downloadPdfToCache(formVerificationActivity.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.15.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormVerificationActivity.this.file2 = file;
                            Log.e("GETFILE", "FILE4::" + FormVerificationActivity.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormVerificationActivity.this.preSignedurl2)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(FormVerificationActivity.this.getResources(), R.drawable.blo_dummy_image);
                    FormVerificationActivity.this.binding.photo2Layout.setVisibility(0);
                    FormVerificationActivity.this.binding.photo2.setImageBitmap(bitmapDecodeResource);
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                    ?? r5 = FormVerificationActivity.this;
                    String str = ((FormVerificationActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$15$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag);
                }
            } else {
                try {
                    FormVerificationActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$15$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormVerificationActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(FormVerificationActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(FormVerificationActivity.this.TAG, e.getMessage());
                }
            }
            FormVerificationActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
            FormVerificationActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r5 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r5, ((FormVerificationActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$15$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormVerificationActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                FormVerificationActivity.this.getFilePage2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent((Context) FormVerificationActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag + t.getMessage());
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.showDialog1(formVerificationActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                FormVerificationActivity.this.binding.passPhoto.setVisibility(8);
                FormVerificationActivity.this.binding.passPhotoLayout.setVisibility(0);
                FormVerificationActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormVerificationActivity.this).load(FormVerificationActivity.this.preSignedurl3).into(FormVerificationActivity.this.binding.image);
                }
                if (TextUtils.isEmpty(FormVerificationActivity.this.preSignedurl3)) {
                    FormVerificationActivity.this.binding.image.setImageBitmap(BitmapFactory.decodeResource(FormVerificationActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                    ?? r5 = FormVerificationActivity.this;
                    String str = ((FormVerificationActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$16$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag);
                }
            } else {
                try {
                    FormVerificationActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$16$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(FormVerificationActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(FormVerificationActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(FormVerificationActivity.this.TAG, e.getMessage());
                }
            }
            FormVerificationActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
            FormVerificationActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormVerificationActivity.this.commomUtility;
                ?? r5 = FormVerificationActivity.this;
                commomUtility.showMessageOK(r5, ((FormVerificationActivity) r5).SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$16$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormVerificationActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                FormVerificationActivity.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormVerificationActivity.this.getApplicationContext()).setLocaleBool(false);
            FormVerificationActivity.this.startActivity(new Intent((Context) FormVerificationActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormVerificationActivity.this.TAG, FormVerificationActivity.this.comingTag + t.getMessage());
            if (FormVerificationActivity.this.alertDialog != null) {
                FormVerificationActivity.this.alertDialog.dismiss();
            }
            FormVerificationActivity formVerificationActivity = FormVerificationActivity.this;
            formVerificationActivity.showDialog1(formVerificationActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$20(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$20(String str, pdfDownloadCallback pdfdownloadcallback) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        textView.setVisibility(8);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) {
        try {
            final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
            dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
            ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
            PDFView pDFView = (PDFView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
            TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
            textView.setVisibility(8);
            flattenPdf(preSignedUrl, pDFView);
            textView.setText(pdfNameFromObjectStorage);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    private void flattenPdf(File inputFile, PDFView pdfView) {
        try {
            File file = new File(getCacheDir(), "flattened.pdf");
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputFile.getAbsolutePath()), new PdfWriter(file.getAbsolutePath()));
            PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);
            if (acroForm != null) {
                acroForm.flattenFields();
            }
            pdfDocument.close();
            pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(true).enableAnnotationRendering(true).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkProgenyEmpty() {
        return this.formverificationPayload.getRelationOldAcNo() == 0 && this.formverificationPayload.getRelationOldPartNo() == 0 && this.formverificationPayload.getRelationOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyEpic()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType());
    }

    public void redirecttolistScreen() {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getdraftData(String key) {
        this.commomUtility.getDraftData(this, this.token, this.verifyPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.asmblyNO, this.partNo, "", new VerifyCitizenListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.17
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity] */
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
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        FormVerificationActivity.this.formverificationPayload = datalist.get(0);
                        FormVerificationActivity.this.setValues();
                        return;
                    }
                    if (FormVerificationActivity.this.alertDialog != null) {
                        FormVerificationActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = FormVerificationActivity.this.utils;
                        ?? r4 = FormVerificationActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.17.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = FormVerificationActivity.this.utils;
                        ?? r5 = FormVerificationActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.17.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                FormVerificationActivity.this.redirecttolistScreen();
                            }
                        });
                        return;
                    }
                }
                if (FormVerificationActivity.this.alertDialog != null) {
                    FormVerificationActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = FormVerificationActivity.this.utils;
                    ?? r6 = FormVerificationActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.17.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                } else {
                    Utils utils4 = FormVerificationActivity.this.utils;
                    ?? r7 = FormVerificationActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), FormVerificationActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity.17.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            FormVerificationActivity.this.redirecttolistScreen();
                        }
                    });
                }
            }
        });
    }
}
