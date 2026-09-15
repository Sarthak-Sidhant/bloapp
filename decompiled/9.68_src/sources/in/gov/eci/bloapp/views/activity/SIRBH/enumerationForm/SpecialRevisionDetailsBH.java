package in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySpecialRevisionDetailsBhBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
public class SpecialRevisionDetailsBH extends SuperBaseActivity {
    private String abbrev;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    ActivitySpecialRevisionDetailsBhBinding binding;
    Bundle bundle;
    byte[] byteArray;
    DatePickerDialog datePickerDialog;
    String dobVerified;
    protected long filesize;
    private String partNo;
    private byte[] pdfbyteArray;
    String photoURL;
    ProgressBar progressBar;
    String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    private String state;
    String temp;
    private String token;
    String uploadFlag;
    String takephoto = "";
    String whitecolor = "#000000";
    private int currentImagePickerId = 0;
    String choosegallery = "Choose Image from Gallery";
    String choosepdf = "Choose PDF from Gallery";
    String cancel = "Cancel";
    String alertText = "";
    String TAG = "SpecialRevisionDetailsTAG";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String applicationpdf = "application/pdf";
    private String photoref = null;
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\n Weak network detected. Please check your connection and try again.";
    private String annexRef = null;
    String functionNameForLogBaseActivity = "";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    private String submitFlag = null;
    String SESSION = "";
    private boolean result = false;
    String imgmsg = "";
    CommomUtility commomUtility = new CommomUtility();
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
    String img = "image";
    String jpgTextBaseActivity = ".jpg";
    String invalidaadhar = "Invalid aadhar";
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySpecialRevisionDetailsBhBinding activitySpecialRevisionDetailsBhBindingInflate = ActivitySpecialRevisionDetailsBhBinding.inflate(getLayoutInflater());
        this.binding = activitySpecialRevisionDetailsBhBindingInflate;
        setContentView(activitySpecialRevisionDetailsBhBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.epicNumber = extras.getString("epicNo");
            this.serial = extras.getString("partSerialNo");
            this.erollPhotoURL = extras.getString("photoURL");
            this.erollDoB = extras.getString("dob");
            this.houseNumber = extras.getString("houseNo");
        }
        if (this.erollDoB != null) {
            try {
                this.dobVerified = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this.erollDoB));
            } catch (Exception e) {
                Logger.d("Date replace", e.toString());
            }
            this.binding.dateOfBirth.setText(this.dobVerified);
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(1, -18);
        final long time2 = calendar2.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda12
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$0(datePicker, i, i2, i3);
            }
        };
        this.takephoto = getString(R.string.takePhotoMsg1);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.photo1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.photo2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.dateOfBirth.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(onDateSetListener, time2, time, view);
            }
        });
        this.binding.chooseFileTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.submitLayout.setVisibility(8);
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (SpecialRevisionDetailsBH.this.binding.noDocument.isChecked()) {
                    SpecialRevisionDetailsBH.this.uploadFlag = "N";
                    SpecialRevisionDetailsBH.this.binding.nextButton.setVisibility(8);
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.showDialog2("", specialRevisionDetailsBH.getString(R.string.noDocUploadedMsg));
                    return;
                }
                SpecialRevisionDetailsBH.this.uploadFlag = "Y";
                SpecialRevisionDetailsBH.this.binding.nextButton.setVisibility(0);
                SpecialRevisionDetailsBH.this.binding.submitLayout.setVisibility(8);
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.mobileNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH.2
            boolean hasShowMessage = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 10 && s.toString().matches("\\d{10}") && !this.hasShowMessage) {
                    Logger.d(SpecialRevisionDetailsBH.this.TAG, s.toString());
                    this.hasShowMessage = true;
                } else if (s.length() > 10) {
                    this.hasShowMessage = false;
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.showDialog1(specialRevisionDetailsBH.alertText, SpecialRevisionDetailsBH.this.getString(R.string.mobilenoerror));
                }
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass3());
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
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
        pickPhoto(101, "photo1Form");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        pickPhoto(102, "Photo2Form");
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
    public /* synthetic */ void lambda$onCreate$5(View view) {
        this.photocount = 0;
        pickFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        deletePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        this.submitFlag = "N";
        submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        this.submitFlag = "Y";
        submit();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3, reason: invalid class name */
    class AnonymousClass3 implements TextWatcher {
        AnonymousClass3() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH] */
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
            if (SpecialRevisionDetailsBH.this.binding.aadharNumber.getText().toString().length() == 12) {
                if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                    SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                }
                try {
                    String string = SpecialRevisionDetailsBH.this.binding.aadharNumber.getText().toString();
                    SpecialRevisionDetailsBH.this.result = Verhoeff.validateVerhoeff(string);
                    if (!SpecialRevisionDetailsBH.this.result) {
                        SpecialRevisionDetailsBH.this.binding.aadharNumber.setText("");
                        SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                        specialRevisionDetailsBH.showDialog1("", specialRevisionDetailsBH.getString(R.string.aadhaarnoerror));
                        if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                            SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                        }
                    } else {
                        CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                        ?? r1 = SpecialRevisionDetailsBH.this;
                        commomUtility.getaadharref(r1, ((SpecialRevisionDetailsBH) r1).state, SpecialRevisionDetailsBH.this.token, SpecialRevisionDetailsBH.this.binding.aadharNumber.getText().toString(), SpecialRevisionDetailsBH.this.atkband, SpecialRevisionDetailsBH.this.rtkband, "EFFORMBH", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda3
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
        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH] */
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
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                ?? r4 = SpecialRevisionDetailsBH.this;
                commomUtility.getRefreshToken(r4, ((SpecialRevisionDetailsBH) r4).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.showDialog1(specialRevisionDetailsBH.invalidaadhar, str2);
                    if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                        SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                SpecialRevisionDetailsBH.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$4();
                    }
                }, 2000L);
                return;
            }
            SpecialRevisionDetailsBH.this.showDialog1(SpecialRevisionDetailsBH.this.alertText + i, str2);
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH] */
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
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                ?? r11 = SpecialRevisionDetailsBH.this;
                commomUtility.showMessageOK(r11, r11.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
            } else {
                SpecialRevisionDetailsBH.this.token = "Bearer " + str;
                SpecialRevisionDetailsBH.this.refreshToken = str2;
                SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setToken("Bearer " + str);
                SpecialRevisionDetailsBH.this.commomUtility.getaadharref(SpecialRevisionDetailsBH.this.getApplicationContext(), SpecialRevisionDetailsBH.this.state, SpecialRevisionDetailsBH.this.token, SpecialRevisionDetailsBH.this.binding.aadharNumber.getText().toString(), SpecialRevisionDetailsBH.this.atkband, SpecialRevisionDetailsBH.this.rtkband, "EFFORMBH", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda5
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetailsBH.this.startActivity(new Intent(SpecialRevisionDetailsBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.showDialog1(specialRevisionDetailsBH.invalidaadhar, str2);
                    if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                        SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                SpecialRevisionDetailsBH.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$3$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$1();
                    }
                }, 2000L);
                return;
            }
            SpecialRevisionDetailsBH.this.showDialog1(SpecialRevisionDetailsBH.this.alertText + i, str2);
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit() {
        getFieldsValue();
        if (validateFields()) {
            try {
                String string = this.binding.dateOfBirth.getText().toString();
                this.dobVerified = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(string));
            } catch (Exception e) {
                Logger.d("Date replace", e.toString());
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("currentRole", "blo");
            map.put("state", this.state);
            map.put("Content-Type", "application/json");
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.epicNumber);
            map2.put("stCode", this.state);
            map2.put("houseNo", this.houseNumber);
            map2.put("dobVerified", this.dobVerified);
            map2.put("erollDob", this.erollDoB);
            map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
            map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
            map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
            map2.put("partSerialNo", this.serial);
            map2.put("createdBy", "BLO");
            map2.put("modifiedDttm", null);
            map2.put("modifiedBy", null);
            map2.put("photoUrl", this.photoref);
            map2.put("srFormPage1Url", this.photo1Ref);
            map2.put("citizenshipType", null);
            map2.put("citizenshipTypeCat", null);
            map2.put("surveyChannel", "BLO");
            map2.put("list1Doc", null);
            map2.put("list2Doc", null);
            map2.put("list3Doc", null);
            map2.put("list4Doc", null);
            map2.put("list5Doc", null);
            map2.put("list6Doc", null);
            map2.put("list7Doc", null);
            map2.put("list1DocUrl", null);
            map2.put("list2DocUrl", null);
            map2.put("list3DocUrl", null);
            map2.put("list4DocUrl", null);
            map2.put("list5DocUrl", null);
            map2.put("list6DocUrl", null);
            map2.put("list7DocUrl", null);
            map2.put("aadharNo", this.aadharref);
            map2.put("mobileNo", this.mobileNo);
            map2.put("fathersOrGuardianName", this.fatherName);
            map2.put("fathersOrGuardianEpicNo", this.fatherEpic);
            map2.put("mothersName", this.motherName);
            map2.put("mothersEpicNo", this.motherEpic);
            map2.put("spouseName", this.spouseName);
            map2.put("spouseEpicNo", this.spouseEpic);
            map2.put("annexureCUrl", null);
            map2.put("preRevisionVoterFlg", null);
            map2.put("preRevisionVoterDocUrl", null);
            map2.put("submittedForRecommendation", this.submitFlag);
            map2.put("fathersNationality", null);
            map2.put("mothersNationality", null);
            map2.put("srFormPage2Url", this.photo2Ref);
            map2.put("oldAcNo", null);
            map2.put("oldPartNo", null);
            map2.put("oldPslNo", null);
            map2.put("list8Doc", null);
            map2.put("moldAcNo", null);
            map2.put("moldPslNo", null);
            map2.put("foldAcNo", null);
            map2.put("foldPartNo", null);
            map2.put("foldPslNo", null);
            map2.put("documentUploadedFlg", this.uploadFlag);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient(this).create(UserClient.class)).submitSpecialRevision(map, map2).enqueue(new AnonymousClass4());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass4() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.showDialog3(specialRevisionDetailsBH.alertText, string);
                } else {
                    SpecialRevisionDetailsBH specialRevisionDetailsBH2 = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH2.showDialog3("", specialRevisionDetailsBH2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda8
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
        Intent intent = new Intent((Context) this, (Class<?>) specialRevisionActivityBH.class);
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
        this.binding.cancel.setVisibility(8);
        this.binding.image.setVisibility(8);
        this.photoref = null;
        this.binding.photoSize.setText("");
        this.binding.photoNameTv2.setText("");
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda7
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

    private boolean validateFields() {
        if (this.binding.selectDetails.getCheckedRadioButtonId() == -1) {
            showDialog1(this.alertText, "Please select any one of the option");
            return false;
        }
        if (this.photo1Ref != null && this.photo2Ref != null) {
            return true;
        }
        showDialog1(this.alertText, "Please upload Enumeration form for elector");
        return false;
    }

    private void getFieldsValue() {
        this.dobVerified = this.binding.dateOfBirth.getText().toString();
        String string = this.binding.mobileNumber.getText().toString();
        this.mobileNo = string;
        if (string.isEmpty()) {
            this.mobileNo = null;
        }
        String string2 = this.binding.fatherEpicNumber.getText().toString();
        this.fatherEpic = string2;
        if (string2.isEmpty()) {
            this.fatherEpic = null;
        }
        String string3 = this.binding.motherEpicNumber.getText().toString();
        this.motherEpic = string3;
        if (string3.isEmpty()) {
            this.motherEpic = null;
        }
        String string4 = this.binding.spouseEpicNumber.getText().toString();
        this.spouseEpic = string4;
        if (string4.isEmpty()) {
            this.spouseEpic = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void validate() {
        getFieldsValue();
        if (validateFields()) {
            Bundle bundle = new Bundle();
            this.bundle = bundle;
            bundle.putString("aadharNo", this.aadharref);
            this.bundle.putString("mobileNo", this.mobileNo);
            this.bundle.putString("dobverified", this.dobVerified);
            this.bundle.putString("fatherName", this.fatherName);
            this.bundle.putString("fatherEpic", this.fatherEpic);
            this.bundle.putString("motherEpic", this.motherEpic);
            this.bundle.putString("motherName", this.motherName);
            this.bundle.putString("spouseName", this.spouseName);
            this.bundle.putString("spouseEpic", this.spouseEpic);
            this.bundle.putString("annexure_url", this.annexRef);
            this.bundle.putString("photo1ref", this.photo1Ref);
            this.bundle.putString("photo2ref", this.photo2Ref);
            this.bundle.putString("photo-url", this.photoref);
            this.bundle.putString("epicNo", this.epicNumber);
            this.bundle.putString("houseNo", this.houseNumber);
            this.bundle.putString("dob", this.erollDoB);
            this.bundle.putString("partSerialNo", this.serial);
            int checkedRadioButtonId = this.binding.selectDetails.getCheckedRadioButtonId();
            if (checkedRadioButtonId == -1) {
                Toast.makeText((Context) this, (CharSequence) "Please select an option", 0).show();
            } else {
                this.bundle.putString("radio_choice", ((RadioButton) findViewById(checkedRadioButtonId)).getText().toString());
            }
            Intent intent = new Intent((Context) this, (Class<?>) SpecialRevisionDocumentsBH.class);
            intent.putExtras(this.bundle);
            startActivity(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        this.temp = this.epicNumber.replaceAll("/", "_") + "_voter_photo";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda6
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
            ImagePicker.with(this).cropSquare().compress(512).cameraOnly().start(100);
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
        this.temp = this.epicNumber.replaceAll("/", "_") + "_" + listCode;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda5
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
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
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
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d(this.TAG, str2);
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda11
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$17(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$18(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$17(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$18(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x045a  */
    /* JADX WARN: Code duplicated, block: B:155:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v48, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v83, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v10 */
    /* JADX WARN: Type inference failed for: r28v12 */
    /* JADX WARN: Type inference failed for: r28v13 */
    /* JADX WARN: Type inference failed for: r28v14 */
    /* JADX WARN: Type inference failed for: r28v15 */
    /* JADX WARN: Type inference failed for: r28v16 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Type inference failed for: r28v9 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r35v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH, in.gov.eci.bloapp.views.activity.SuperBaseActivity] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v9 */
    protected void onActivityResult(int i, int i2, Intent intent) {
        ?? r14;
        String str;
        ?? r12;
        ?? r28;
        boolean z;
        boolean z2;
        ?? r15;
        ?? r13;
        boolean z3;
        ?? r29;
        boolean z4;
        ?? r210;
        ?? r211;
        boolean z5;
        String str2;
        int i3 = i;
        ?? r16 = i2;
        super.onActivityResult(i, i2, intent);
        String str3 = "/";
        ?? r17 = 80;
        ?? r18 = 80;
        ?? r9 = "KB";
        String str4 = "";
        if (r16 != -1) {
            Object obj = "KB";
            str3 = "/";
            r14 = 1;
            r14 = 1;
            str = "";
            if (i3 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
                r12 = obj;
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.binding.photo1Annexure.setVisibility(0);
                this.binding.photo2Annexure.setVisibility(0);
                r12 = obj;
            }
        } else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    if (i3 != 101) {
                        str4 = "";
                        str2 = "KB";
                        str3 = "/";
                        z5 = true;
                        z3 = true;
                        z3 = true;
                        z3 = true;
                        z3 = true;
                        r17 = 1;
                        r17 = 1;
                        i3 = i;
                        if (i3 == 102) {
                            try {
                                r211 = str2;
                                long j = this.filesize;
                                if (j < 1024) {
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
                                    this.binding.photo2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                    String str5 = str2;
                                    this.binding.photo2Size.setText(this.filesize + str5);
                                    r13 = str5;
                                } else {
                                    r16 = str2;
                                    if (j > 2048) {
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
                                            r13 = r16;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str = str4;
                                            Logger.d(str, e.getMessage());
                                            r12 = r16;
                                            r14 = r17;
                                        }
                                    } else {
                                        long j2 = j / 1024;
                                        this.filesize = j2;
                                        double dRound = Math.round(j2 * 100.0d) / 100.0d;
                                        if (dRound > 2.0d) {
                                            this.binding.photo2Layout.setVisibility(8);
                                            this.binding.photo2Annexure.setEnabled(true);
                                            showDialog1(this.alertText, this.imgmsg);
                                            r13 = r16;
                                        } else {
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
                                            this.binding.photo2Name.setText(strArrSplit[strArrSplit.length - 1]);
                                            this.binding.photo2Size.setText(dRound + "MB");
                                            r13 = r16;
                                        }
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                r210 = str2;
                                r16 = r210;
                            }
                        } else {
                            r211 = str2;
                            r13 = r211;
                            z3 = z5;
                        }
                        cursorQuery.close();
                        str = str4;
                        r12 = r13;
                        r14 = z3;
                    } else {
                        try {
                            long j3 = this.filesize;
                            try {
                                if (j3 < 1024) {
                                    try {
                                        try {
                                            str3 = "/";
                                            str4 = "";
                                            r18 = "KB";
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
                                                z2 = true;
                                                this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                this.binding.photo1Size.setText(new StringBuilder().append(this.filesize).append(r18).toString());
                                                r15 = r18;
                                                r13 = r15;
                                                z3 = z2;
                                                cursorQuery.close();
                                                str = str4;
                                                r12 = r13;
                                                r14 = z3;
                                            } catch (Exception e4) {
                                                e = e4;
                                                r9 = 1;
                                                r16 = r18;
                                                r17 = r9;
                                                str = str4;
                                                Logger.d(str, e.getMessage());
                                                r12 = r16;
                                                r14 = r17;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            r18 = "KB";
                                            r9 = 1;
                                            r16 = r18;
                                            r17 = r9;
                                            str = str4;
                                            Logger.d(str, e.getMessage());
                                            r12 = r16;
                                            r14 = r17;
                                            if (i3 == 100) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        r18 = "KB";
                                    }
                                } else {
                                    str4 = "";
                                    r18 = "KB";
                                    str3 = "/";
                                    r9 = 1;
                                    z2 = true;
                                    if (j3 > 2048) {
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
                                            r13 = r15;
                                            z3 = z2;
                                            cursorQuery.close();
                                            str = str4;
                                            r12 = r13;
                                            r14 = z3;
                                        } catch (Exception e7) {
                                            e = e7;
                                            r16 = r18;
                                            r17 = r9;
                                            str = str4;
                                            Logger.d(str, e.getMessage());
                                            r12 = r16;
                                            r14 = r17;
                                        }
                                    } else {
                                        try {
                                            long j4 = j3 / 1024;
                                            this.filesize = j4;
                                            double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                                            if (dRound2 > 2.0d) {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.photo1Annexure.setEnabled(true);
                                                showDialog1(this.alertText, this.imgmsg);
                                                r29 = r18;
                                                z4 = true;
                                            } else {
                                                try {
                                                    r28 = r18;
                                                    z = true;
                                                    z4 = true;
                                                    try {
                                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                        this.binding.annexPage1Layout.setVisibility(0);
                                                        this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                        this.binding.photo1Name.setVisibility(0);
                                                        this.binding.photo1Size.setVisibility(0);
                                                        this.binding.photo1.setVisibility(0);
                                                        ImageView imageView4 = this.binding.photo1;
                                                        byte[] bArr4 = this.pdfbyteArray;
                                                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                                        this.binding.photo1Annexure.setTextColor(Color.parseColor(this.greycolor));
                                                        this.binding.photo1Annexure.setEnabled(false);
                                                        this.binding.photo1Name.setText(strArrSplit[strArrSplit.length - 1]);
                                                        this.binding.photo1Size.setText(dRound2 + "MB");
                                                        r29 = r28;
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        i3 = i;
                                                        r17 = z;
                                                        r210 = r28;
                                                        r16 = r210;
                                                        str = str4;
                                                        Logger.d(str, e.getMessage());
                                                        r12 = r16;
                                                        r14 = r17;
                                                    }
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    r28 = r18;
                                                    z = true;
                                                    i3 = i;
                                                    r17 = z;
                                                    r210 = r28;
                                                    r16 = r210;
                                                    str = str4;
                                                    Logger.d(str, e.getMessage());
                                                    r12 = r16;
                                                    r14 = r17;
                                                    if (i3 == 100) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            }
                                            i3 = i;
                                            z5 = z4;
                                            r211 = r29;
                                            r211 = str2;
                                            r13 = r211;
                                            z3 = z5;
                                            cursorQuery.close();
                                            str = str4;
                                            r12 = r13;
                                            r14 = z3;
                                        } catch (Exception e10) {
                                            e = e10;
                                            r28 = r18;
                                            z = true;
                                        }
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            str4 = "";
                            r28 = "KB";
                            str3 = "/";
                        }
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            } catch (Exception e14) {
                e = e14;
                str4 = "";
                r16 = "KB";
                str3 = "/";
                r17 = 1;
            }
            str = str4;
            Logger.d(str, e.getMessage());
            r12 = r16;
            r14 = r17;
        }
        if (i3 == 100 || i2 != -1) {
            return;
        }
        try {
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
            this.byteArray = byteArrayOutputStream2.toByteArray();
        } catch (Exception e15) {
            Logger.d(str, e15.getMessage());
        }
        try {
            Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.img, this.temp);
            Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
            if (cursorQuery2.getCount() <= 0) {
                cursorQuery2.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery2.moveToFirst();
            String[] strArrSplit2 = saveImagePath2.getPath().split(str3);
            long j5 = this.filesize;
            if (j5 < 1024) {
                faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                this.binding.passPhotoLayout.setVisibility(0);
                this.binding.cancel.setVisibility(0);
                this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileTv.setEnabled(false);
                this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r14]);
                this.binding.photoSize.setText(new StringBuilder().append(this.filesize).append(r12).toString());
                this.binding.photoSize.setVisibility(0);
                this.binding.photoNameTv2.setVisibility(0);
                this.binding.image.setVisibility(0);
                ImageView imageView5 = this.binding.image;
                byte[] bArr5 = this.byteArray;
                imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
            } else {
                long j6 = j5 / 1024;
                this.filesize = j6;
                double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                if (dRound3 > 2.0d) {
                    this.binding.passPhotoLayout.setVisibility(8);
                    this.binding.chooseFileTv.setEnabled(r14);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.blackColor));
                    showDialog1(this.alertText, this.imgmsg);
                } else {
                    faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                    this.binding.passPhotoLayout.setVisibility(0);
                    this.binding.chooseFileTv.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileTv.setEnabled(false);
                    this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r14]);
                    this.binding.photoSize.setText(dRound3 + "MB");
                    ImageView imageView6 = this.binding.image;
                    byte[] bArr6 = this.byteArray;
                    imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                }
            }
            cursorQuery2.close();
        } catch (Exception e16) {
            Logger.d(str, e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass5(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass5(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                Context applicationContext = SpecialRevisionDetailsBH.this.getApplicationContext();
                String str = SpecialRevisionDetailsBH.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetailsBH.token, this.val$reference, this.val$uploadtype);
                return;
            }
            try {
                SpecialRevisionDetailsBH.this.binding.passPhotoLayout.setVisibility(8);
                SpecialRevisionDetailsBH.this.binding.chooseFileTv.setEnabled(true);
                SpecialRevisionDetailsBH.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetailsBH.this.blackColor));
                new JSONObject(response.errorBody().string());
                SpecialRevisionDetailsBH specialRevisionDetailsBH2 = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH2.showDialog1(specialRevisionDetailsBH2.alertText, SpecialRevisionDetailsBH.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionDetails", e.toString());
            }
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH] */
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
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                ?? r2 = SpecialRevisionDetailsBH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDetailsBH.this.token = "Bearer " + str8;
            SpecialRevisionDetailsBH.this.refreshToken = str9;
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setToken("Bearer " + str8);
            SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
            specialRevisionDetailsBH.faceRecognition(str, str2, str3, str4, str5, specialRevisionDetailsBH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetailsBH.this.startActivity(new Intent(SpecialRevisionDetailsBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            SpecialRevisionDetailsBH.this.binding.passPhotoLayout.setVisibility(8);
            SpecialRevisionDetailsBH.this.binding.chooseFileTv.setEnabled(true);
            SpecialRevisionDetailsBH.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetailsBH.this.blackColor));
            Logger.d(StringUtils.SPACE, t.getMessage());
            SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
            specialRevisionDetailsBH.showDialog1(specialRevisionDetailsBH.alertText, Constants.somethingWentWrong);
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), captureFileName);
        restClient.uploadImageWithSIR(this.token, "blo", "BLOAPP", partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass6(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass6(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
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
                if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                    SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                Context applicationContext = SpecialRevisionDetailsBH.this.getApplicationContext();
                String str = SpecialRevisionDetailsBH.this.refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(applicationContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$6$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photostr)) {
                    SpecialRevisionDetailsBH.this.photoref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                        SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                    }
                }
                if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo1Str)) {
                    SpecialRevisionDetailsBH.this.photo1Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                        SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                    }
                }
                if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo2str)) {
                    SpecialRevisionDetailsBH.this.photo2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                        SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                    }
                }
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photostr)) {
                if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                    SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                }
                SpecialRevisionDetailsBH.this.photocount = 0;
                SpecialRevisionDetailsBH.this.binding.chooseFileTv.setEnabled(true);
                SpecialRevisionDetailsBH.this.binding.passPhotoLayout.setVisibility(8);
                SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH.showDialog1(specialRevisionDetailsBH.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo1Str)) {
                if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                    SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                }
                SpecialRevisionDetailsBH.this.photo1count = 0;
                SpecialRevisionDetailsBH.this.binding.annexPage1Layout.setVisibility(8);
                SpecialRevisionDetailsBH.this.binding.photo1Annexure.setEnabled(true);
                SpecialRevisionDetailsBH specialRevisionDetailsBH2 = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH2.showDialog1(specialRevisionDetailsBH2.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo2str)) {
                if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                    SpecialRevisionDetailsBH.this.alertDialog.dismiss();
                }
                SpecialRevisionDetailsBH.this.photo2count = 0;
                SpecialRevisionDetailsBH.this.binding.photo2Annexure.setEnabled(true);
                SpecialRevisionDetailsBH.this.binding.photo2Layout.setVisibility(8);
                SpecialRevisionDetailsBH specialRevisionDetailsBH3 = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH3.showDialog1(specialRevisionDetailsBH3.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
            }
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH] */
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
                CommomUtility commomUtility = SpecialRevisionDetailsBH.this.commomUtility;
                ?? r2 = SpecialRevisionDetailsBH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SpecialRevisionDetailsBH.this.token = "Bearer " + str8;
            SpecialRevisionDetailsBH.this.refreshToken = str9;
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setToken("Bearer " + str8);
            SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
            specialRevisionDetailsBH.uploadPhoto(str, str2, str3, str4, str5, specialRevisionDetailsBH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SpecialRevisionDetailsBH.this.getApplicationContext()).setLocaleBool(false);
            SpecialRevisionDetailsBH.this.startActivity(new Intent(SpecialRevisionDetailsBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SpecialRevisionDetailsBH.this.alertDialog != null) {
                SpecialRevisionDetailsBH.this.alertDialog.dismiss();
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photostr)) {
                if (SpecialRevisionDetailsBH.this.photocount < 2 && TextUtils.isEmpty(SpecialRevisionDetailsBH.this.photoref)) {
                    SpecialRevisionDetailsBH.this.photocount++;
                    SpecialRevisionDetailsBH specialRevisionDetailsBH = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetailsBH.token, this.val$reference, this.val$uploadtype);
                } else {
                    SpecialRevisionDetailsBH.this.photocount = 0;
                    SpecialRevisionDetailsBH.this.binding.passPhotoLayout.setVisibility(8);
                    SpecialRevisionDetailsBH.this.binding.chooseFileTv.setTextColor(Color.parseColor(SpecialRevisionDetailsBH.this.blackColor));
                    SpecialRevisionDetailsBH.this.binding.chooseFileTv.setEnabled(true);
                    SpecialRevisionDetailsBH specialRevisionDetailsBH2 = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH2.showDialog1(specialRevisionDetailsBH2.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo1Str)) {
                if (SpecialRevisionDetailsBH.this.photo1count < 2 && TextUtils.isEmpty(SpecialRevisionDetailsBH.this.photo1Ref)) {
                    SpecialRevisionDetailsBH.this.photo1count++;
                    SpecialRevisionDetailsBH specialRevisionDetailsBH3 = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetailsBH3.token, this.val$reference, this.val$uploadtype);
                } else {
                    SpecialRevisionDetailsBH.this.photo1count = 0;
                    SpecialRevisionDetailsBH.this.binding.annexPage1Layout.setVisibility(8);
                    SpecialRevisionDetailsBH.this.binding.photo1Annexure.setTextColor(Color.parseColor(SpecialRevisionDetailsBH.this.blackColor));
                    SpecialRevisionDetailsBH.this.binding.photo1Annexure.setEnabled(true);
                    SpecialRevisionDetailsBH specialRevisionDetailsBH4 = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH4.showDialog1(specialRevisionDetailsBH4.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(SpecialRevisionDetailsBH.this.photo2str)) {
                if (SpecialRevisionDetailsBH.this.photo2count < 2 && TextUtils.isEmpty(SpecialRevisionDetailsBH.this.photo2Ref)) {
                    SpecialRevisionDetailsBH.this.photo2count++;
                    SpecialRevisionDetailsBH specialRevisionDetailsBH5 = SpecialRevisionDetailsBH.this;
                    specialRevisionDetailsBH5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, specialRevisionDetailsBH5.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                SpecialRevisionDetailsBH.this.photo2count = 0;
                SpecialRevisionDetailsBH.this.binding.photo2Layout.setVisibility(8);
                SpecialRevisionDetailsBH.this.binding.photo2Annexure.setTextColor(Color.parseColor(SpecialRevisionDetailsBH.this.blackColor));
                SpecialRevisionDetailsBH.this.binding.photo2Annexure.setEnabled(true);
                SpecialRevisionDetailsBH specialRevisionDetailsBH6 = SpecialRevisionDetailsBH.this;
                specialRevisionDetailsBH6.showDialog1(specialRevisionDetailsBH6.alertText, SpecialRevisionDetailsBH.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("Retry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.SpecialRevisionDetailsBH$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$19(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$19(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }
}
