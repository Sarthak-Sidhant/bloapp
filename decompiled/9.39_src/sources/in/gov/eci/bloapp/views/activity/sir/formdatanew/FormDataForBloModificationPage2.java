package in.gov.eci.bloapp.views.activity.sir.formdatanew;

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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormDataForBloModificationPage2Binding;
import in.gov.eci.bloapp.entity.ListData;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.UploadWithPreSignedURL;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormDataForBloModificationPage2 extends SuperBaseActivity {
    Date DoB;
    String aadharNo;
    String actualDateOfBirthS;
    AlertDialog alertDialog;
    String annexref;
    private String asmblyNO;
    private String atkband;
    ActivityFormDataForBloModificationPage2Binding binding;
    Bundle bundle;
    String choice;
    String citizenshipTypeCatTemp;
    Date dateAfter;
    Date dateBefore;
    Date dateRange;
    String dob;
    Date dobElector;
    String dobTemp;
    Long epicId;
    String epicNumber;
    String erollDoB;
    String fatherEpic;
    String fatherName;
    protected long filesize;
    String functionNameForLogBaseActivity;
    String houseNumber;
    Intent intent;
    boolean isThisYou;
    String isThisYouRel;
    String list1Code;
    String list2;
    String list2code;
    String list3code;
    String list4code;
    String list5code;
    String list6code;
    String list7code;
    String list8code;
    String mime;
    String mobileNo;
    String motherEpic;
    String motherName;
    private String partNo;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    String photo1ref;
    String photo2ref;
    String photoref;
    String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    String serial;
    SIRDatabaseHelper sirDatabaseHelper;
    String spouseEpic;
    String spouseName;
    private String state;
    String surveyChannel;
    String temp;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String TAG = "FormDataForBloModificationPage2";
    String takephoto = "";
    String tabName = "Reverify";
    boolean onlineStatus = false;
    boolean isUserAction = false;
    String fatherOldAcS = "";
    String fatherOldPartS = "";
    String fatherOldPslS = "";
    String motherOldAcS = "";
    String motherOldPartS = "";
    String motherOldPslS = "";
    String oldAc = null;
    String OldPart = null;
    String OldPsl = null;
    String fatherOldAc = null;
    String motherOldAc = null;
    String fatherOldPart = null;
    String oldStatecd = null;
    String fatherOldPsl = null;
    String motherOldPart = null;
    String motherOldPsl = null;
    String whitecolor = "#000000";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String greycolor = "#99000000";
    String choosegallery = "";
    String choosepdf = "";
    String cancel = "";
    String objectStorageString = "objectstorage";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String SESSION = "";
    String imgmsg = "";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String supportingDocumentPage1UrlS = "";
    String supportingDocumentPage2UrlS = "";
    ArrayList<String> relationList = new ArrayList<>();
    String upload = "";
    boolean pdf = false;
    Gson gson = new GsonBuilder().setLenient().create();
    String pdfTextBaseActivity = ".pdf";
    String IRStr = "Intensive Revision";
    String before1987Str = "Before 1987 self";
    String before2004Str = "Before 2004 Self";
    String list2Str = "Before 2004 Father or Mother";
    String list3Str = "After 2004 Father";
    String after2004Str = "After 2004 Self";
    String list4Str = "After 2004 Mother";
    String list5Str = "Not Indian Parent";
    String list6Str = "Born out of India";
    String list7Str = "Acquired Indian Citizenship";
    String IRStr2 = "Intensive Revision 2";
    String before1987Str2 = "Before 1987 self 2";
    String before2004Str2 = "Before 2004 Self 2";
    String list2Str2 = "Before 2004 Father or Mother 2";
    String list3Str2 = " Father  page 2";
    String after2004Str2 = "After 2004 Self 2";
    String list4Str2 = " Mother  page 2";
    String list5Str2 = "Not Indian Parent 2";
    String list5Str3 = "Not Indian Parent 3";
    String list6Str2 = "Born out of India 2";
    String list7Str2 = "Acquired Indian Citizenship 2";
    String img = "image";
    String cat = "";
    String jpgTextBaseActivity = ".jpg";
    String fileNameTextBaseActivity = "fileName";
    String alertText = "";
    String selectRelationType = "";
    private String motherNationality = "Indian";
    private String fatherNationality = "Indian";
    String flagYes = "N";
    String FlagNo = "N";
    String IRRef = null;
    String IRRef2 = null;
    String list1ref = null;
    String list1ref2 = null;
    String list2Ref = null;
    String selectDocumentType = "";
    String list3Ref = null;
    String list4Ref = null;
    String list5Ref = null;
    String list6ref = null;
    String list7ref = null;
    String list3Ref2 = null;
    String list4Ref2 = null;
    String list5Ref2 = null;
    String list6ref2 = null;
    String list7ref2 = null;
    String list5ref3 = null;
    String list2Ref2 = null;
    String IRFlag = "N";
    int IRcount = 0;
    int IRcount2 = 0;
    int list5count3 = 0;
    int before2004count = 0;
    int after2004count = 0;
    int before2004count2 = 0;
    int after2004count2 = 0;
    int before1987count = 0;
    int list2count = 0;
    int list3count = 0;
    int list4coumt = 0;
    int list5count = 0;
    int list6count = 0;
    int list7count = 0;
    int before1987count2 = 0;
    int list2count2 = 0;
    int list3count2 = 0;
    int list4coumt2 = 0;
    int list5count2 = 0;
    int list6count2 = 0;
    int list7count2 = 0;
    int photo3count = 0;
    int photo4count = 0;
    private String submitFlag = null;
    String list1 = "LIST-1";
    String list3 = "LIST-3";
    String list4 = "LIST-4";
    String list5 = "LIST-5";
    String list6 = "LIST-6";
    String list7 = "LIST-7";
    String list8 = "LIST-8";
    ArrayList<String> List1docName = new ArrayList<>();
    ArrayList<String> List1docCode = new ArrayList<>();
    ArrayList<String> List2docName = new ArrayList<>();
    ArrayList<String> List2docCode = new ArrayList<>();
    ArrayList<String> List3docName = new ArrayList<>();
    ArrayList<String> List3docCode = new ArrayList<>();
    ArrayList<String> List4docName = new ArrayList<>();
    ArrayList<String> List4docCode = new ArrayList<>();
    ArrayList<String> List5docName = new ArrayList<>();
    ArrayList<String> List5docCode = new ArrayList<>();
    ArrayList<String> List6docName = new ArrayList<>();
    ArrayList<String> List6docCode = new ArrayList<>();
    ArrayList<String> List7docName = new ArrayList<>();
    ArrayList<String> List7docCode = new ArrayList<>();
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    String flagcat4scenerio1 = "N";
    String flagcat4scenerio2 = "N";
    String flagcat4scenerio3 = "N";
    String flagcat3scenerio1 = "N";
    String flagcat3scenerio2 = "N";
    SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    SimpleDateFormat simple1 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    String base64element1 = "";
    String base64element2 = "";
    String base64element3 = "";
    String base64element4 = "";
    String base64element5 = "";
    String base64element6 = "";
    String base64element7 = "";
    String base64element8 = "";
    String base64element9 = "";
    String base64element10 = "";
    String base64element11 = "";
    String base64element12 = "";
    String base64element13 = "";
    String base64element14 = "";
    String base64element15 = "";
    String base64element16 = "";
    String base64element17 = "";
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String preSignedurl5 = "";
    String preSignedurl6 = "";
    String preSignedurl7 = "";
    String preSignedurl8 = "";
    String preSignedurl9 = "";
    String preSignedurl10 = "";
    String preSignedurl11 = "";
    String preSignedurl12 = "";
    String preSignedurl13 = "";
    String preSignedurl14 = "";
    String preSignedurl15 = "";
    String preSignedurl16 = "";
    String preSignedurl17 = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    boolean isUserSelected = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFormDataForBloModificationPage2Binding activityFormDataForBloModificationPage2BindingInflate = ActivityFormDataForBloModificationPage2Binding.inflate(getLayoutInflater());
        this.binding = activityFormDataForBloModificationPage2BindingInflate;
        setContentView(activityFormDataForBloModificationPage2BindingInflate.getRoot());
        this.takephoto = getString(R.string.takePhotoMsg);
        this.choosegallery = getString(R.string.imageFromGalleryMsg);
        this.choosepdf = getString(R.string.choosePdfMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.SESSION = getString(R.string.sessionMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.upload = getString(R.string.uploadAgainMsg);
        this.alertText = getString(R.string.alertMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        boolean z = false;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(this);
        if (SharedPref.getInstance(getApplicationContext()).getOnlineStatusFlag().equalsIgnoreCase("Y")) {
            this.onlineStatus = true;
        }
        this.StateList = SharedPref.getInstance(getApplicationContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getApplicationContext()).getAcListName(Constants.STATE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldState.setAdapter((SpinnerAdapter) arrayAdapter);
        try {
            this.dateBefore = this.simple1.parse("01/07/1987");
            this.dateAfter = this.simple1.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d("H2HDetails", e.toString());
        }
        clearLists();
        Bundle extras = getIntent().getExtras();
        this.bundle = extras;
        if (extras != null) {
            this.choice = extras.getString("radio_choice");
            this.epicId = Long.valueOf(this.bundle.getLong("epicId"));
            this.dob = this.bundle.getString("dobverified");
            this.citizenshipTypeCatTemp = this.bundle.getString("citizenshipTypeCat");
            this.actualDateOfBirthS = this.bundle.getString("ActualDateOfBirth");
            String str = this.choice;
            if (str != null) {
                if (str.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
                    this.List1docName.clear();
                    this.List1docCode.clear();
                    this.IRFlag = "Y";
                    this.cat = "CAT-1";
                    if (this.onlineStatus) {
                        getList1("LIST-8");
                    } else {
                        setDataOffline(this.list8);
                    }
                    this.binding.radioLayout.setVisibility(8);
                    this.binding.intensiveRevisionLayout.setVisibility(0);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
                    this.simple.setLenient(false);
                    String str2 = this.dob;
                    if (str2 != null && !str2.isEmpty()) {
                        this.binding.radioLayout.setVisibility(8);
                        try {
                            this.DoB = this.simple.parse(this.dob.trim());
                        } catch (ParseException e2) {
                            Logger.d("ReverifyPage2", e2.toString());
                        }
                        Date date = this.DoB;
                        if (date != null) {
                            if (date.before(this.dateBefore)) {
                                this.cat = "CAT-2";
                                this.list1 = "LIST-1";
                                Log.d("before 1987", this.DoB.toString());
                                this.binding.intensiveRevisionLayout.setVisibility(8);
                                this.binding.llBefore1987.setVisibility(0);
                                if (this.onlineStatus) {
                                    getList1(this.list1);
                                } else {
                                    setDataOffline(this.list1);
                                }
                                this.binding.llBefore2004.setVisibility(8);
                                this.binding.llAfter2004.setVisibility(8);
                                this.binding.llBornOutOfIndia.setVisibility(8);
                                this.binding.llAcquired.setVisibility(8);
                            } else if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                                this.cat = "CAT-3";
                                this.list1 = "LIST-1";
                                Log.d("before 2004", this.DoB.toString());
                                if (this.onlineStatus) {
                                    getList1(this.list1);
                                } else {
                                    setDataOffline(this.list1);
                                }
                                this.binding.intensiveRevisionLayout.setVisibility(8);
                                this.binding.llBefore1987.setVisibility(8);
                                this.binding.llBefore2004.setVisibility(0);
                                this.binding.llAfter2004.setVisibility(8);
                                this.binding.llBornOutOfIndia.setVisibility(8);
                                this.binding.llAcquired.setVisibility(8);
                            } else if (this.DoB.after(this.dateAfter)) {
                                this.cat = "CAT-4";
                                this.list1 = "LIST-1";
                                Log.d("after 2004", this.DoB.toString());
                                if (this.onlineStatus) {
                                    getList1(this.list1);
                                } else {
                                    setDataOffline(this.list1);
                                }
                                this.binding.intensiveRevisionLayout.setVisibility(8);
                                this.binding.llBefore1987.setVisibility(8);
                                this.binding.llParentLayout.setVisibility(8);
                                this.binding.llBefore2004.setVisibility(8);
                                this.binding.llBefore2004.setVisibility(8);
                                this.binding.llAfter2004.setVisibility(0);
                                this.binding.llBornOutOfIndia.setVisibility(8);
                                this.binding.llAcquired.setVisibility(8);
                            }
                        }
                    } else {
                        this.binding.radioLayout.setVisibility(0);
                        this.binding.intensiveRevisionLayout.setVisibility(8);
                        this.binding.llBefore1987.setVisibility(8);
                        this.binding.llBefore2004.setVisibility(8);
                        this.binding.llAfter2004.setVisibility(8);
                        this.binding.llBornOutOfIndia.setVisibility(8);
                        this.binding.llAcquired.setVisibility(8);
                    }
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_before_1987))) {
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.cat = "CAT-2";
                    this.binding.llBefore1987.setVisibility(0);
                    this.binding.radioLayout.setVisibility(8);
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_before_2004))) {
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.cat = "CAT-3";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(0);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                    this.binding.radioLayout.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_after_2004))) {
                    this.cat = "CAT-4";
                    if (this.onlineStatus) {
                        getList1(this.list1);
                    } else {
                        setDataOffline(this.list1);
                    }
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llParentLayout.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(0);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                    this.binding.radioLayout.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
                    this.List6docName.clear();
                    this.List6docCode.clear();
                    this.binding.radioLayout.setVisibility(8);
                    this.cat = "CAT-5";
                    this.list6 = "LIST-6";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    if (this.onlineStatus) {
                        getList1(this.list6);
                    } else {
                        setDataOffline(this.list6);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(0);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                    this.binding.radioLayout.setVisibility(8);
                    this.List7docName.clear();
                    this.List7docCode.clear();
                    this.cat = "CAT-6";
                    this.list7 = "LIST-7";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    if (this.onlineStatus) {
                        getList1(this.list7);
                    } else {
                        setDataOffline(this.list7);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(0);
                }
            }
            this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (FormDataForBloModificationPage2.this.binding.bornBefore1987rb.isChecked()) {
                        FormDataForBloModificationPage2.this.cat = "CAT-2";
                        FormDataForBloModificationPage2.this.list1 = "LIST-1";
                        FormDataForBloModificationPage2.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.intensiveRevisionLayout.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBefore1987.setVisibility(0);
                        if (FormDataForBloModificationPage2.this.alertDialog != null) {
                            FormDataForBloModificationPage2.this.alertDialog.show();
                            if (FormDataForBloModificationPage2.this.onlineStatus) {
                                FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                                formDataForBloModificationPage2.getList1(formDataForBloModificationPage2.list1);
                            } else {
                                FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                                formDataForBloModificationPage3.setDataOffline(formDataForBloModificationPage3.list1);
                            }
                        }
                        FormDataForBloModificationPage2.this.binding.llBefore2004.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llAfter2004.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBornOutOfIndia.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llAcquired.setVisibility(8);
                    }
                    if (FormDataForBloModificationPage2.this.binding.bornBefore2004rb.isChecked()) {
                        FormDataForBloModificationPage2.this.cat = "CAT-3";
                        FormDataForBloModificationPage2.this.list1 = "LIST-1";
                        FormDataForBloModificationPage2.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.intensiveRevisionLayout.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBefore1987.setVisibility(8);
                        if (FormDataForBloModificationPage2.this.alertDialog != null) {
                            FormDataForBloModificationPage2.this.alertDialog.show();
                            if (FormDataForBloModificationPage2.this.onlineStatus) {
                                FormDataForBloModificationPage2 formDataForBloModificationPage4 = FormDataForBloModificationPage2.this;
                                formDataForBloModificationPage4.getList1(formDataForBloModificationPage4.list1);
                            } else {
                                FormDataForBloModificationPage2 formDataForBloModificationPage5 = FormDataForBloModificationPage2.this;
                                formDataForBloModificationPage5.setDataOffline(formDataForBloModificationPage5.list1);
                            }
                        }
                        FormDataForBloModificationPage2.this.binding.llBefore2004.setVisibility(0);
                        FormDataForBloModificationPage2.this.binding.llAfter2004.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBornOutOfIndia.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llAcquired.setVisibility(8);
                    }
                    if (FormDataForBloModificationPage2.this.binding.bornAfter2004rb.isChecked()) {
                        FormDataForBloModificationPage2.this.cat = "CAT-4";
                        FormDataForBloModificationPage2.this.list1 = "LIST-1";
                        FormDataForBloModificationPage2.this.binding.layoutVerifyDetails.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.intensiveRevisionLayout.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBefore1987.setVisibility(8);
                        if (FormDataForBloModificationPage2.this.onlineStatus) {
                            FormDataForBloModificationPage2 formDataForBloModificationPage6 = FormDataForBloModificationPage2.this;
                            formDataForBloModificationPage6.getList1(formDataForBloModificationPage6.list1);
                        } else {
                            FormDataForBloModificationPage2 formDataForBloModificationPage7 = FormDataForBloModificationPage2.this;
                            formDataForBloModificationPage7.setDataOffline(formDataForBloModificationPage7.list1);
                        }
                        FormDataForBloModificationPage2.this.binding.llParentLayout.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llBefore2004.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llAfter2004.setVisibility(0);
                        FormDataForBloModificationPage2.this.binding.llBornOutOfIndia.setVisibility(8);
                        FormDataForBloModificationPage2.this.binding.llAcquired.setVisibility(8);
                    }
                }
            });
            this.epicNumber = this.bundle.getString("epicNo");
            this.serial = this.bundle.getString("partSerialNo");
            this.erollDoB = this.bundle.getString("dob");
            this.houseNumber = this.bundle.getString("houseNo");
            this.aadharNo = this.bundle.getString("aadharNo");
            this.mobileNo = this.bundle.getString("mobileNo");
            this.fatherName = this.bundle.getString("fatherName");
            this.fatherEpic = this.bundle.getString("fatherEpic");
            this.motherEpic = this.bundle.getString("motherEpic");
            this.motherName = this.bundle.getString("motherName");
            this.spouseName = this.bundle.getString("spouseName");
            this.spouseEpic = this.bundle.getString("spouseEpic");
            this.photoref = this.bundle.getString("photo-url");
            this.annexref = this.bundle.getString("annexure_url");
            this.photo1ref = this.bundle.getString("photo1ref");
            this.photo2ref = this.bundle.getString("photo2ref");
            this.isThisYouRel = this.bundle.getString("isThisYouRel");
            String string = this.bundle.getString("isThisYou");
            if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("Y")) {
                z = true;
            }
            this.isThisYou = z;
        }
        this.binding.chooseFileIR2003.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.chooseFileIR2003Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.chooseFileBefore1987.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.chooseFileBefore1987Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.chooseFileBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.chooseFileBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.chooseFileBefore2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.chooseFileBefore2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.chooseFileAfter2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda71
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.chooseFileAfter2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.chooseFileAfter2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.chooseFileAfter2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.chooseFileAfter2004Mother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda81
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.chooseFileAfter2004MotherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndian.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.chooseFileBornOutOfIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.chooseFileBornOutOfIndiaPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.chooseFileAcquired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.chooseFileAcquiredPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.cancelIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.cancelList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$22(view);
            }
        });
        this.binding.cancelBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$23(view);
            }
        });
        this.binding.cancelList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$24(view);
            }
        });
        this.binding.cancelAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$25(view);
            }
        });
        this.binding.cancelList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$26(view);
            }
        });
        this.binding.cancelList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$27(view);
            }
        });
        this.binding.cancelList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$28(view);
            }
        });
        this.binding.cancelList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$29(view);
            }
        });
        this.binding.cancelList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$30(view);
            }
        });
        this.binding.cancelIRPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$31(view);
            }
        });
        this.binding.cancelList1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$32(view);
            }
        });
        this.binding.cancelBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$33(view);
            }
        });
        this.binding.cancelList2Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$34(view);
            }
        });
        this.binding.cancelAfter2004selfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$35(view);
            }
        });
        this.binding.cancelList3Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$36(view);
            }
        });
        this.binding.cancelList4Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$37(view);
            }
        });
        this.binding.cancelList5Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$38(view);
            }
        });
        this.binding.cancelList6Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$39(view);
            }
        });
        this.binding.cancelList7Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$40(view);
            }
        });
        this.binding.cancelList5Page3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$41(view);
            }
        });
        this.binding.oldState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage2.oldStatecd = formDataForBloModificationPage2.StateList.get(i);
                Log.d(FormDataForBloModificationPage2.this.TAG, "AClist " + FormDataForBloModificationPage2.this.StateList);
                Log.d(FormDataForBloModificationPage2.this.TAG, "Spinner value " + FormDataForBloModificationPage2.this.oldStatecd);
                FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage3.getAllAC(formDataForBloModificationPage3.oldStatecd);
            }
        });
        this.binding.SpinnerIROldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage2.oldAc = formDataForBloModificationPage2.ACList.get(i);
                Log.d(FormDataForBloModificationPage2.this.TAG, "AClist " + FormDataForBloModificationPage2.this.ACList);
                Log.d(FormDataForBloModificationPage2.this.TAG, "Spinner value " + FormDataForBloModificationPage2.this.oldAc);
                FormDataForBloModificationPage2.this.getPartByAc(Integer.parseInt(FormDataForBloModificationPage2.this.ACList.get(i)), "case1");
            }
        });
        this.binding.SpinnerIROldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage2.OldPart = formDataForBloModificationPage2.partList.get(i - 1).toString();
            }
        });
        initializeSpinnerTouch();
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(101);
                    FormDataForBloModificationPage2.this.deletePhoto(201);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list8code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List8docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list8code = formDataForBloModificationPage2.List8docCode.get(i);
                    Logger.d(FormDataForBloModificationPage2.this.TAG, Constants.LIST8_CODE + FormDataForBloModificationPage2.this.list8code);
                }
            }
        });
        this.binding.spinnerBefore1987Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(102);
                    FormDataForBloModificationPage2.this.deletePhoto(202);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list1Code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List1docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list1Code = formDataForBloModificationPage2.List1docCode.get(i);
                    Logger.d("list1Code", FormDataForBloModificationPage2.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(103);
                    FormDataForBloModificationPage2.this.deletePhoto(203);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list1Code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List1docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list1Code = formDataForBloModificationPage2.List1docCode.get(i);
                    Logger.d("list1Code", FormDataForBloModificationPage2.this.list1Code);
                }
            }
        });
        this.binding.spinnerAfter2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(105);
                    FormDataForBloModificationPage2.this.deletePhoto(205);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list1Code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List1docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list1Code = formDataForBloModificationPage2.List1docCode.get(i);
                    Logger.d("list1Code", FormDataForBloModificationPage2.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage2.this.binding.betweenParentFatherRb.isChecked()) {
                    if (FormDataForBloModificationPage2.this.isUserSelected) {
                        FormDataForBloModificationPage2.this.deletePhoto(104);
                        FormDataForBloModificationPage2.this.deletePhoto(204);
                        FormDataForBloModificationPage2.this.isUserSelected = false;
                        FormDataForBloModificationPage2.this.list3code = "";
                    }
                } else if (FormDataForBloModificationPage2.this.binding.betweenParentMotherRb.isChecked() && FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(111);
                    FormDataForBloModificationPage2.this.deletePhoto(211);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list4code = "";
                }
                if (i == 0) {
                    return;
                }
                if (FormDataForBloModificationPage2.this.binding.betweenParentFatherRb.isChecked()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list3code = formDataForBloModificationPage2.List3docCode.get(i);
                    Logger.d("list3code", FormDataForBloModificationPage2.this.list3code);
                    FormDataForBloModificationPage2.this.deletePhoto(104);
                    return;
                }
                if (FormDataForBloModificationPage2.this.binding.betweenParentMotherRb.isChecked()) {
                    FormDataForBloModificationPage2.this.deletePhoto(111);
                    FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage3.list4code = formDataForBloModificationPage3.List4docCode.get(i);
                    Logger.d("list4code", FormDataForBloModificationPage2.this.list4code);
                }
            }
        });
        this.binding.spinnerAfter2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(106);
                    FormDataForBloModificationPage2.this.deletePhoto(206);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list3code = "";
                }
                if (i != 0 && i >= 0 && i < FormDataForBloModificationPage2.this.List3docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list3code = formDataForBloModificationPage2.List3docCode.get(i);
                    if (FormDataForBloModificationPage2.this.binding.parentYesRb.isChecked()) {
                        FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                        formDataForBloModificationPage3.list3code = formDataForBloModificationPage3.List3docCode.get(i);
                        Logger.d("list3code", FormDataForBloModificationPage2.this.list3code);
                    } else if (FormDataForBloModificationPage2.this.binding.parentNoRb.isChecked() && FormDataForBloModificationPage2.this.binding.parentFatherRb.isChecked()) {
                        FormDataForBloModificationPage2 formDataForBloModificationPage4 = FormDataForBloModificationPage2.this;
                        formDataForBloModificationPage4.list3code = formDataForBloModificationPage4.List3docCode.get(i);
                        Logger.d("list3code", FormDataForBloModificationPage2.this.list3code);
                        FormDataForBloModificationPage2.this.flagYes = "Y";
                    }
                }
            }
        });
        this.binding.spinnerAfter2004Mother.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(107);
                    FormDataForBloModificationPage2.this.deletePhoto(207);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list4code = "";
                }
                if (i == 0) {
                    return;
                }
                FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage2.list4code = formDataForBloModificationPage2.List4docCode.get(i);
                Log.d("list4code", FormDataForBloModificationPage2.this.list4code);
            }
        });
        this.binding.spinnerAfter2004NotIndian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(108);
                    FormDataForBloModificationPage2.this.deletePhoto(208);
                    FormDataForBloModificationPage2.this.deletePhoto(212);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list5code = "";
                }
                if (i == 0) {
                    return;
                }
                int i2 = i - 1;
                if (i2 >= 0 && i2 < FormDataForBloModificationPage2.this.List5docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list5code = formDataForBloModificationPage2.List5docCode.get(i);
                    Logger.d("list5code", FormDataForBloModificationPage2.this.list5code);
                }
                if (i == 1) {
                    FormDataForBloModificationPage2.this.binding.page3LL.setVisibility(0);
                } else {
                    FormDataForBloModificationPage2.this.binding.page3LL.setVisibility(8);
                }
            }
        });
        this.binding.spinnerBornOutOfIndia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.13
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(109);
                    FormDataForBloModificationPage2.this.deletePhoto(209);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list6code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List6docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list6code = formDataForBloModificationPage2.List6docCode.get(i);
                    Logger.d("list6code", FormDataForBloModificationPage2.this.list6code);
                }
            }
        });
        this.binding.spinnerAcquired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.14
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (FormDataForBloModificationPage2.this.isUserSelected) {
                    FormDataForBloModificationPage2.this.deletePhoto(110);
                    FormDataForBloModificationPage2.this.deletePhoto(210);
                    FormDataForBloModificationPage2.this.isUserSelected = false;
                    FormDataForBloModificationPage2.this.list7code = "";
                }
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < FormDataForBloModificationPage2.this.List7docName.size()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.list7code = formDataForBloModificationPage2.List7docCode.get(i);
                    Logger.d("list7code", FormDataForBloModificationPage2.this.list7code);
                }
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$42(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$43(view);
            }
        });
        this.binding.betweenParentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$44(view);
            }
        });
        this.binding.betweenParentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$45(view);
            }
        });
        this.binding.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$47(view);
            }
        });
        this.binding.parentNoRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$48(view);
            }
        });
        this.binding.parentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$49(view);
            }
        });
        this.binding.parentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$50(view);
            }
        });
        initClickListener();
        setInitialDataFromAPI();
        this.binding.imageList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$51(view);
            }
        });
        this.binding.imageList6Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$52(view);
            }
        });
        this.binding.imageList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$53(view);
            }
        });
        this.binding.imageList7Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$54(view);
            }
        });
        this.binding.imageIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$55(view);
            }
        });
        this.binding.imageIRPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$56(view);
            }
        });
        this.binding.imageList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$57(view);
            }
        });
        this.binding.imageBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$58(view);
            }
        });
        this.binding.imageAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$59(view);
            }
        });
        this.binding.imageList1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$60(view);
            }
        });
        this.binding.imageBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$61(view);
            }
        });
        this.binding.imageAfter2004selfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$62(view);
            }
        });
        this.binding.imageList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda59
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$63(view);
            }
        });
        this.binding.imageList2Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$64(view);
            }
        });
        this.binding.imageList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$65(view);
            }
        });
        this.binding.imageList3Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$66(view);
            }
        });
        this.binding.imageList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$67(view);
            }
        });
        this.binding.imageList4Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda64
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$68(view);
            }
        });
        this.binding.imageList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$69(view);
            }
        });
        this.binding.imageList5Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda67
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$70(view);
            }
        });
        this.binding.imageList5Page3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda69
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$71(view);
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FormDataForBloModificationPage2.this.binding.SpinnerIROldAcNo.getSelectedItemPosition() == 0 || FormDataForBloModificationPage2.this.binding.SpinnerIROldPartNo.getSelectedItemPosition() == 0 || FormDataForBloModificationPage2.this.binding.IROldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                FormDataForBloModificationPage2.this.callVerifyRelativeApi();
            }
        });
        this.binding.IROldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.16
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if (FormDataForBloModificationPage2.this.binding.oldState.getSelectedItemPosition() != 0 && FormDataForBloModificationPage2.this.binding.SpinnerIROldAcNo.getSelectedItemPosition() != 0 && FormDataForBloModificationPage2.this.binding.SpinnerIROldPartNo.getSelectedItemPosition() != 0 && !FormDataForBloModificationPage2.this.binding.IROldPslNo.getText().toString().trim().isEmpty()) {
                    FormDataForBloModificationPage2.this.binding.layoutVerifyDetails.setVisibility(0);
                } else {
                    FormDataForBloModificationPage2.this.binding.layoutVerifyDetails.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (this.binding.spinnerIR.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.IRcount = 0;
            pickFileIntensiveRevision(101, this.list8code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (TextUtils.isEmpty(this.IRRef)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(201, this.list8code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (this.binding.spinnerBefore1987Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.before1987count = 0;
            pickFileIntensiveRevision(102, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(202, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (this.binding.spinnerBefore2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.before2004count = 0;
            pickFileIntensiveRevision(103, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(203, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (this.binding.spinnerBefore2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
            return;
        }
        this.list2count = 0;
        if (this.binding.betweenParentFatherRb.isChecked()) {
            pickFileIntensiveRevision(104, this.list3code);
        } else if (this.binding.betweenParentMotherRb.isChecked()) {
            pickFileIntensiveRevision(111, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (this.binding.betweenParentFatherRb.isChecked()) {
            if (TextUtils.isEmpty(this.list3Ref)) {
                showDialog1(this.alertText, getString(R.string.uploadpage1error));
                return;
            } else {
                pickFileIntensiveRevision(204, this.list3code + "_page2_");
                return;
            }
        }
        if (this.binding.betweenParentMotherRb.isChecked()) {
            if (TextUtils.isEmpty(this.list4Ref)) {
                showDialog1(this.alertText, getString(R.string.uploadpage1error));
            } else {
                pickFileIntensiveRevision(211, this.list4code + "_page2_");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        if (this.binding.spinnerAfter2004Self.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.after2004count = 0;
            pickFileIntensiveRevision(105, this.list1Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        if (TextUtils.isEmpty(this.list1ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(205, this.list1Code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        if (this.binding.spinnerAfter2004Father.getSelectedItem() != null) {
            if (this.binding.spinnerAfter2004Father.getSelectedItem().toString().equals(this.selectDocumentType)) {
                showDialog1(this.alertText, this.selectDocumentType);
            } else {
                this.list3count = 0;
                pickFileIntensiveRevision(106, this.list3code);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        if (TextUtils.isEmpty(this.list3Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(206, this.list3code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        if (this.binding.spinnerAfter2004Mother.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list4coumt = 0;
            pickFileIntensiveRevision(107, this.list4code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        if (TextUtils.isEmpty(this.list4Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(207, this.list4code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        if (this.binding.spinnerAfter2004NotIndian.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list5count = 0;
            pickFileIntensiveRevision(108, this.list5code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        if (TextUtils.isEmpty(this.list5Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(208, this.list5code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        if (this.binding.spinnerBornOutOfIndia.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list6count = 0;
            pickFileIntensiveRevision(109, this.list6code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        if (TextUtils.isEmpty(this.list6ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(209, this.list6code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        if (this.binding.spinnerAcquired.getSelectedItem().toString().equals(this.selectDocumentType)) {
            showDialog1(this.alertText, this.selectDocumentType);
        } else {
            this.list7count = 0;
            pickFileIntensiveRevision(110, this.list7code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        if (TextUtils.isEmpty(this.list7ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else {
            pickFileIntensiveRevision(210, this.list7code + "_page2_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        if (TextUtils.isEmpty(this.list5Ref)) {
            showDialog1(this.alertText, getString(R.string.uploadpage1error));
        } else if (TextUtils.isEmpty(this.list5Ref2)) {
            showDialog1(this.alertText, getString(R.string.uploadpage2error));
        } else {
            pickFileIntensiveRevision(212, this.list5code + "_page3_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        deletePhoto(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$23(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$24(View view) {
        deletePhoto(111);
        deletePhoto(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$25(View view) {
        deletePhoto(105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$26(View view) {
        deletePhoto(106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$27(View view) {
        deletePhoto(107);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$28(View view) {
        deletePhoto(108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$29(View view) {
        deletePhoto(109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$30(View view) {
        deletePhoto(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$31(View view) {
        deletePhoto(201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$32(View view) {
        deletePhoto(202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$33(View view) {
        deletePhoto(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$34(View view) {
        deletePhoto(211);
        deletePhoto(204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$35(View view) {
        deletePhoto(205);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$36(View view) {
        deletePhoto(206);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$37(View view) {
        deletePhoto(207);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$38(View view) {
        deletePhoto(208);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$39(View view) {
        deletePhoto(209);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$40(View view) {
        deletePhoto(210);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$41(View view) {
        deletePhoto(212);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$42(View view) {
        this.submitFlag = "N";
        callIRFields();
        callParentFields();
        if (this.cat.equals("CAT-1") && validate()) {
            submit();
            return;
        }
        if (this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) {
            submit();
        } else if (this.cat.equals("CAT-2") || this.cat.equals("CAT-5") || this.cat.equals("CAT-6")) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$43(View view) {
        this.submitFlag = "Y";
        callIRFields();
        callParentFields();
        if (this.cat.equals("CAT-1") && validate()) {
            submit();
            return;
        }
        if (this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) {
            submit();
        } else if (this.cat.equals("CAT-2") || this.cat.equals("CAT-5") || this.cat.equals("CAT-6")) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$44(View view) {
        this.flagcat3scenerio1 = "Y";
        this.List3docName.clear();
        this.List3docCode.clear();
        if (this.onlineStatus) {
            getList1(this.list3);
        } else {
            setDataOffline(this.list3);
        }
        this.motherOldAc = "";
        this.motherOldPart = "";
        this.motherOldPsl = "";
        this.list3Ref = "";
        this.list3Ref2 = "";
        this.list4code = "";
        this.list4Ref = "";
        this.list4Ref2 = "";
        this.fatherOldAcS = "";
        this.fatherOldPartS = "";
        this.fatherOldPslS = "";
        this.motherOldAcS = "";
        this.motherOldPartS = "";
        this.motherOldPslS = "";
        this.binding.viewLayoutList2.setVisibility(8);
        this.binding.imageList2.setVisibility(8);
        this.binding.list2Name.setText("");
        this.binding.list2Name.setVisibility(8);
        this.binding.list2Size.setVisibility(8);
        this.binding.cancelList2.setVisibility(8);
        this.binding.chooseFileBefore2004Father.setEnabled(true);
        this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewLayoutList2Page2.setVisibility(8);
        this.binding.imageList2Page2.setVisibility(8);
        this.binding.list2NamePage2.setText("");
        this.binding.list2NamePage2.setVisibility(8);
        this.binding.list2SizePage2.setVisibility(8);
        this.binding.cancelList2Page2.setVisibility(8);
        this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
        this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$45(View view) {
        this.flagcat3scenerio2 = "Y";
        this.List4docName.clear();
        this.List4docCode.clear();
        if (this.onlineStatus) {
            getList1(this.list4);
        } else {
            setDataOffline(this.list4);
        }
        this.list3code = "";
        this.list3Ref = "";
        this.list3Ref2 = "";
        this.list4Ref = "";
        this.list4Ref2 = "";
        this.fatherOldAcS = "";
        this.fatherOldPartS = "";
        this.fatherOldPslS = "";
        this.motherOldAcS = "";
        this.motherOldPartS = "";
        this.motherOldPslS = "";
        this.binding.viewLayoutList2.setVisibility(8);
        this.binding.imageList2.setVisibility(8);
        this.binding.list2Name.setText("");
        this.binding.list2Name.setVisibility(8);
        this.binding.list2Size.setVisibility(8);
        this.binding.cancelList2.setVisibility(8);
        this.binding.chooseFileBefore2004Father.setEnabled(true);
        this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewLayoutList2Page2.setVisibility(8);
        this.binding.imageList2Page2.setVisibility(8);
        this.binding.list2NamePage2.setText("");
        this.binding.list2NamePage2.setVisibility(8);
        this.binding.list2SizePage2.setVisibility(8);
        this.binding.cancelList2Page2.setVisibility(8);
        this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
        this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$47(View view) {
        this.binding.parentYesRb.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$46();
            }
        });
        this.flagcat4scenerio1 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        if (this.onlineStatus) {
            getList1(this.list3);
            getList1(this.list4);
        } else {
            setDataOffline(this.list3);
            setDataOffline(this.list4);
        }
        this.binding.viewFatherOldLayout.setVisibility(8);
        this.binding.viewMotherOldLayout.setVisibility(8);
        this.binding.llParentLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(0);
        this.binding.motherLayout.setVisibility(0);
        this.binding.forIndianParentLayout.setVisibility(8);
        this.binding.selectParentLayout.setVisibility(8);
        this.binding.llNotIndianLayout.setVisibility(8);
        this.binding.forNonIndianParentLayout.setVisibility(8);
        this.list3Ref = "";
        this.list3Ref2 = "";
        this.list4code = "";
        this.list4Ref = "";
        this.list4Ref2 = "";
        this.list5code = "";
        this.list5Ref = "";
        this.list5Ref2 = "";
        this.list5ref3 = "";
        this.fatherOldAcS = "";
        this.fatherOldPartS = "";
        this.fatherOldPslS = "";
        this.motherOldAcS = "";
        this.motherOldPartS = "";
        this.motherOldPslS = "";
        this.binding.viewList3.setVisibility(8);
        this.binding.imageList3.setVisibility(8);
        this.binding.list3Name.setText("");
        this.binding.list3Name.setVisibility(8);
        this.binding.list3Size.setVisibility(8);
        this.binding.cancelList3.setVisibility(8);
        this.binding.chooseFileAfter2004Father.setEnabled(true);
        this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList3Page2.setVisibility(8);
        this.binding.imageList3Page2.setVisibility(8);
        this.binding.list3NamePage2.setText("");
        this.binding.list3NamePage2.setVisibility(8);
        this.binding.list3SizePage2.setVisibility(8);
        this.binding.cancelList3Page2.setVisibility(8);
        this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4.setVisibility(8);
        this.binding.imageList4.setVisibility(8);
        this.binding.list4Name.setText("");
        this.binding.list4Name.setVisibility(8);
        this.binding.list4Size.setVisibility(8);
        this.binding.cancelList4.setVisibility(8);
        this.binding.chooseFileAfter2004Mother.setEnabled(true);
        this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4Page2.setVisibility(8);
        this.binding.imageList4Page2.setVisibility(8);
        this.binding.list4NamePage2.setText("");
        this.binding.list4NamePage2.setVisibility(8);
        this.binding.list4SizePage2.setVisibility(8);
        this.binding.cancelList4Page2.setVisibility(8);
        this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5.setVisibility(8);
        this.binding.imageList5.setVisibility(8);
        this.binding.list5Name.setText("");
        this.binding.list5Name.setVisibility(8);
        this.binding.list5Size.setVisibility(8);
        this.binding.cancelList5.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page2.setVisibility(8);
        this.binding.imageList5Page2.setVisibility(8);
        this.binding.list5NamePage2.setText("");
        this.binding.list5NamePage2.setVisibility(8);
        this.binding.list5SizePage2.setVisibility(8);
        this.binding.cancelList5Page2.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page3.setVisibility(8);
        this.binding.imageList5Page3.setVisibility(8);
        this.binding.list5NamePage3.setText("");
        this.binding.list5NamePage3.setVisibility(8);
        this.binding.list5SizePage3.setVisibility(8);
        this.binding.cancelList5Page3.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.whitecolor));
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$46() {
        this.binding.parentYesRb.setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$48(View view) {
        this.binding.parentFatherRb.setChecked(false);
        this.binding.parentMotherRb.setChecked(false);
        this.binding.selectParentLayout.setVisibility(0);
        this.binding.llParentLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(8);
        this.binding.motherLayout.setVisibility(8);
        this.binding.llNotIndianLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(8);
        this.binding.forNonIndianParentLayout.setVisibility(8);
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$49(View view) {
        this.binding.parentFatherRb.setChecked(true);
        this.flagcat4scenerio2 = "Y";
        this.motherNationality = "Non-Indian";
        this.fatherNationality = "Indian";
        if (this.onlineStatus) {
            getList1(this.list3);
        } else {
            setDataOffline(this.list3);
            setDataOffline(this.list5);
        }
        this.binding.fatherLayout.setVisibility(0);
        this.binding.motherLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(0);
        this.binding.indianParentTv2.setText(getString(R.string.father_sr));
        this.binding.llNotIndianLayout.setVisibility(0);
        this.binding.nonIndianParentTv2.setText(R.string.mother_sr);
        this.binding.forNonIndianParentLayout.setVisibility(0);
        this.list3code = "";
        this.list3Ref = "";
        this.list3Ref2 = "";
        this.list4code = "";
        this.list4Ref = "";
        this.list4Ref2 = "";
        this.list5code = "";
        this.list5Ref = "";
        this.list5Ref2 = "";
        this.list5ref3 = "";
        this.fatherOldAcS = "";
        this.fatherOldPartS = "";
        this.fatherOldPslS = "";
        this.motherOldAcS = "";
        this.motherOldPartS = "";
        this.motherOldPslS = "";
        this.binding.viewList3.setVisibility(8);
        this.binding.imageList3.setVisibility(8);
        this.binding.list3Name.setText("");
        this.binding.list3Name.setVisibility(8);
        this.binding.list3Size.setVisibility(8);
        this.binding.cancelList3.setVisibility(8);
        this.binding.chooseFileAfter2004Father.setEnabled(true);
        this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList3Page2.setVisibility(8);
        this.binding.imageList3Page2.setVisibility(8);
        this.binding.list3NamePage2.setText("");
        this.binding.list3NamePage2.setVisibility(8);
        this.binding.list3SizePage2.setVisibility(8);
        this.binding.cancelList3Page2.setVisibility(8);
        this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4.setVisibility(8);
        this.binding.imageList4.setVisibility(8);
        this.binding.list4Name.setText("");
        this.binding.list4Name.setVisibility(8);
        this.binding.list4Size.setVisibility(8);
        this.binding.cancelList4.setVisibility(8);
        this.binding.chooseFileAfter2004Mother.setEnabled(true);
        this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4Page2.setVisibility(8);
        this.binding.imageList4Page2.setVisibility(8);
        this.binding.list4NamePage2.setText("");
        this.binding.list4NamePage2.setVisibility(8);
        this.binding.list4SizePage2.setVisibility(8);
        this.binding.cancelList4Page2.setVisibility(8);
        this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5.setVisibility(8);
        this.binding.imageList5.setVisibility(8);
        this.binding.list5Name.setText("");
        this.binding.list5Name.setVisibility(8);
        this.binding.list5Size.setVisibility(8);
        this.binding.cancelList5.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page2.setVisibility(8);
        this.binding.imageList5Page2.setVisibility(8);
        this.binding.list5NamePage2.setText("");
        this.binding.list5NamePage2.setVisibility(8);
        this.binding.list5SizePage2.setVisibility(8);
        this.binding.cancelList5Page2.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page3.setVisibility(8);
        this.binding.imageList5Page3.setVisibility(8);
        this.binding.list5NamePage3.setText("");
        this.binding.list5NamePage3.setVisibility(8);
        this.binding.list5SizePage3.setVisibility(8);
        this.binding.cancelList5Page3.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.whitecolor));
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$50(View view) {
        this.List5docCode.clear();
        this.flagcat4scenerio3 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Non-Indian";
        setDataOffline(this.list4);
        setDataOffline(this.list5);
        this.binding.motherLayout.setVisibility(0);
        this.binding.fatherLayout.setVisibility(8);
        this.binding.forIndianParentLayout.setVisibility(0);
        this.binding.indianParentTv2.setText(R.string.mother_sr);
        this.binding.llNotIndianLayout.setVisibility(0);
        this.binding.nonIndianParentTv2.setText(R.string.father_sr);
        this.binding.forNonIndianParentLayout.setVisibility(0);
        this.list3code = "";
        this.list3Ref = "";
        this.list3Ref2 = "";
        this.list4code = "";
        this.list4Ref = "";
        this.list4Ref2 = "";
        this.list5code = "";
        this.list5Ref = "";
        this.list5Ref2 = "";
        this.list5ref3 = "";
        this.fatherOldAcS = "";
        this.fatherOldPartS = "";
        this.fatherOldPslS = "";
        this.motherOldAcS = "";
        this.motherOldPartS = "";
        this.motherOldPslS = "";
        this.binding.viewList3.setVisibility(8);
        this.binding.imageList3.setVisibility(8);
        this.binding.list3Name.setText("");
        this.binding.list3Name.setVisibility(8);
        this.binding.list3Size.setVisibility(8);
        this.binding.cancelList3.setVisibility(8);
        this.binding.chooseFileAfter2004Father.setEnabled(true);
        this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList3Page2.setVisibility(8);
        this.binding.imageList3Page2.setVisibility(8);
        this.binding.list3NamePage2.setText("");
        this.binding.list3NamePage2.setVisibility(8);
        this.binding.list3SizePage2.setVisibility(8);
        this.binding.cancelList3Page2.setVisibility(8);
        this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4.setVisibility(8);
        this.binding.imageList4.setVisibility(8);
        this.binding.list4Name.setText("");
        this.binding.list4Name.setVisibility(8);
        this.binding.list4Size.setVisibility(8);
        this.binding.cancelList4.setVisibility(8);
        this.binding.chooseFileAfter2004Mother.setEnabled(true);
        this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList4Page2.setVisibility(8);
        this.binding.imageList4Page2.setVisibility(8);
        this.binding.list4NamePage2.setText("");
        this.binding.list4NamePage2.setVisibility(8);
        this.binding.list4SizePage2.setVisibility(8);
        this.binding.cancelList4Page2.setVisibility(8);
        this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
        this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5.setVisibility(8);
        this.binding.imageList5.setVisibility(8);
        this.binding.list5Name.setText("");
        this.binding.list5Name.setVisibility(8);
        this.binding.list5Size.setVisibility(8);
        this.binding.cancelList5.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page2.setVisibility(8);
        this.binding.imageList5Page2.setVisibility(8);
        this.binding.list5NamePage2.setText("");
        this.binding.list5NamePage2.setVisibility(8);
        this.binding.list5SizePage2.setVisibility(8);
        this.binding.cancelList5Page2.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.whitecolor));
        this.binding.viewList5Page3.setVisibility(8);
        this.binding.imageList5Page3.setVisibility(8);
        this.binding.list5NamePage3.setText("");
        this.binding.list5NamePage3.setVisibility(8);
        this.binding.list5SizePage3.setVisibility(8);
        this.binding.cancelList5Page3.setVisibility(8);
        this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
        this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.whitecolor));
        if (this.citizenshipTypeCatTemp.equals("CAT-3") && (!TextUtils.isEmpty(this.list3code) || !TextUtils.isEmpty(this.list4code))) {
            this.binding.father1OldAcNo.setText("");
            this.binding.father1OldPartNo.setText("");
            this.binding.father1OldPslNo.setText("");
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText("");
            this.binding.fatherOldPartNo.setText("");
            this.binding.fatherOldPslNo.setText("");
            this.binding.motherOldAcNo.setText("");
            this.binding.motherOldPartNo.setText("");
            this.binding.motherOldPslNo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$51(View view) {
        if (!TextUtils.isEmpty(this.list6ref) && this.list6ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl1, this.list6ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list6ref) || this.list6ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl1)) {
            showImageDialog(this.preSignedurl1, this.list6ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$52(View view) {
        Log.d("Here", "Inside 6" + this.list6ref2);
        if (!TextUtils.isEmpty(this.list6ref2) && this.list6ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl2, this.list6ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list6ref2) || this.list6ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl2)) {
            showImageDialog(this.preSignedurl2, this.list6ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$53(View view) {
        if (!TextUtils.isEmpty(this.list7ref) && this.list7ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl3, this.list7ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list7ref) || this.list7ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl3, this.list7ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$54(View view) {
        if (!TextUtils.isEmpty(this.list7ref2) && this.list7ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl4, this.list7ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list7ref2) || this.list7ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl4)) {
            showImageDialog(this.preSignedurl4, this.list7ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$55(View view) {
        if (!TextUtils.isEmpty(this.IRRef) && this.IRRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl5, this.IRRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.IRRef) || this.IRRef.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl5)) {
            showImageDialog(this.preSignedurl5, this.IRRef);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$56(View view) {
        if (!TextUtils.isEmpty(this.IRRef2) && this.IRRef2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl6, this.IRRef2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.IRRef2) || this.IRRef2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl6)) {
            showImageDialog(this.preSignedurl6, this.IRRef2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$57(View view) {
        if (!TextUtils.isEmpty(this.list1ref) && this.list1ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl7, this.list1ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref) || this.list1ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl7)) {
            showImageDialog(this.preSignedurl7, this.list1ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$58(View view) {
        if (!TextUtils.isEmpty(this.list1ref) && this.list1ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl7, this.list1ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref) || this.list1ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl7)) {
            showImageDialog(this.preSignedurl7, this.list1ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$59(View view) {
        if (!TextUtils.isEmpty(this.list1ref) && this.list1ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl7, this.list1ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref) || this.list1ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl7)) {
            showImageDialog(this.preSignedurl7, this.list1ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$60(View view) {
        if (!TextUtils.isEmpty(this.list1ref2) && this.list1ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl8, this.list1ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref2) || this.list1ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl8)) {
            showImageDialog(this.preSignedurl8, this.list1ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$61(View view) {
        if (!TextUtils.isEmpty(this.list1ref2) && this.list1ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl8, this.list1ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref2) || this.list1ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl8)) {
            showImageDialog(this.preSignedurl8, this.list1ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$62(View view) {
        if (!TextUtils.isEmpty(this.list1ref2) && this.list1ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl8, this.list1ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list1ref2) || this.list1ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl8)) {
            showImageDialog(this.preSignedurl8, this.list1ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$63(View view) {
        Log.d("Here", "Inside ImageList2");
        if (!TextUtils.isEmpty(this.list3Ref) && this.list3Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl9, this.list3Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list3Ref) || this.list3Ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl9)) {
            showImageDialog(this.preSignedurl9, this.list3Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$64(View view) {
        if (!TextUtils.isEmpty(this.list3Ref2) && this.list3Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl10, this.list3Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list3Ref2) || this.list3Ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl10)) {
            showImageDialog(this.preSignedurl10, this.list3Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$65(View view) {
        if (!TextUtils.isEmpty(this.list3Ref) && this.list3Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl11, this.list3Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list3Ref) || this.list3Ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl11)) {
            showImageDialog(this.preSignedurl11, this.list3Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$66(View view) {
        if (!TextUtils.isEmpty(this.list3Ref2) && this.list3Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl12, this.list3Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list3Ref2) || this.list3Ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl12)) {
            showImageDialog(this.preSignedurl12, this.list3Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$67(View view) {
        if (!TextUtils.isEmpty(this.list4Ref) && this.list4Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl13, this.list4Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list4Ref) || this.list4Ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl13)) {
            showImageDialog(this.preSignedurl13, this.list4Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$68(View view) {
        if (!TextUtils.isEmpty(this.list4Ref2) && this.list4Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl14, this.list4Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list4Ref2) || this.list4Ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl14)) {
            showImageDialog(this.preSignedurl14, this.list4Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$69(View view) {
        if (!TextUtils.isEmpty(this.list5Ref) && this.list5Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl15, this.list5Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list5Ref) || this.list5Ref.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl15)) {
            showImageDialog(this.preSignedurl15, this.list5Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$70(View view) {
        if (!TextUtils.isEmpty(this.list5Ref2) && this.list5Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl16, this.list5Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list5Ref2) || this.list5Ref2.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl16)) {
            showImageDialog(this.preSignedurl16, this.list5Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$71(View view) {
        if (!TextUtils.isEmpty(this.list5ref3) && this.list5ref3.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.preSignedurl17, this.list5ref3);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(this.list5ref3) || this.list5ref3.endsWith(".pdf")) {
            return;
        }
        if (!TextUtils.isEmpty(this.preSignedurl17)) {
            showImageDialog(this.preSignedurl17, this.list5ref3);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getPartByAc(int ac, final String partCase) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        Log.d(this.TAG, "getpartbyac " + ac);
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.17
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (FormDataForBloModificationPage2.this.partNameList.isEmpty()) {
                        FormDataForBloModificationPage2.this.partNameList.add(0, FormDataForBloModificationPage2.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        if (partCase.equalsIgnoreCase("case1")) {
                            FormDataForBloModificationPage2.this.partNameList.add(asInt + " - " + asString);
                            FormDataForBloModificationPage2.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.SpinnerIROldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (!TextUtils.isEmpty(FormDataForBloModificationPage2.this.oldStatecd) && !TextUtils.isEmpty(FormDataForBloModificationPage2.this.OldPart)) {
                                FormDataForBloModificationPage2.this.binding.SpinnerIROldPartNo.setSelection(Integer.parseInt(FormDataForBloModificationPage2.this.OldPart));
                            }
                            if (!TextUtils.isEmpty(FormDataForBloModificationPage2.this.OldPsl)) {
                                FormDataForBloModificationPage2.this.binding.IROldPslNo.setText(FormDataForBloModificationPage2.this.OldPsl);
                            }
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) FormDataForBloModificationPage2.this, (CharSequence) "Failed to get Part List", 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setDataOffline(String list) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        for (ListData listData : this.sirDatabaseHelper.ListDataDao().getList(list)) {
            if (list.equalsIgnoreCase(this.list1)) {
                this.List1docCode.add(listData.docCode);
                this.List1docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list2)) {
                this.List2docCode.add(listData.docCode);
                this.List2docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list3)) {
                this.List3docCode.add(listData.docCode);
                this.List3docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list4)) {
                this.List4docCode.add(listData.docCode);
                this.List4docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list5)) {
                this.List5docCode.add(listData.docCode);
                this.List5docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list6)) {
                this.List6docCode.add(listData.docCode);
                this.List6docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list7)) {
                this.List7docCode.add(listData.docCode);
                this.List7docName.add(listData.docName);
            } else if (list.equalsIgnoreCase(this.list8)) {
                this.List8docCode.add(listData.docCode);
                this.List8docName.add(listData.docName);
            }
        }
        if (list.equalsIgnoreCase(this.list1)) {
            if (!this.List1docName.contains(this.selectDocumentType)) {
                this.List1docName.add(0, this.selectDocumentType);
                this.List1docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List1docName);
            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
            this.binding.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
            this.binding.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
            if (this.bundle.getString("list1Doc") == null || this.bundle.getString("list1Doc").equals("")) {
                this.binding.spinnerBefore1987Self.setSelection(0);
                this.binding.spinnerBefore2004Self.setSelection(0);
                this.binding.spinnerAfter2004Self.setSelection(0);
                return;
            } else {
                this.binding.spinnerBefore1987Self.setSelection(this.List1docCode.indexOf(this.bundle.getString("list1Doc")));
                this.binding.spinnerBefore2004Self.setSelection(this.List1docCode.indexOf(this.bundle.getString("list1Doc")));
                this.binding.spinnerAfter2004Self.setSelection(this.List1docCode.indexOf(this.bundle.getString("list1Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list3)) {
            if (!this.List3docName.contains(this.selectDocumentType)) {
                this.List3docName.add(0, this.selectDocumentType);
                this.List3docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List3docName);
            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
            this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
            if (this.bundle.getString("list3Doc") == null || this.bundle.getString("list3Doc").equals("")) {
                this.binding.spinnerAfter2004Father.setSelection(0);
                this.binding.spinnerBefore2004Father.setSelection(0);
                return;
            } else {
                this.binding.spinnerAfter2004Father.setSelection(this.List3docCode.indexOf(this.bundle.getString("list3Doc")));
                this.binding.spinnerBefore2004Father.setSelection(this.List3docCode.indexOf(this.bundle.getString("list3Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list4)) {
            if (!this.List4docName.contains(this.selectDocumentType)) {
                this.List4docName.add(0, this.selectDocumentType);
                this.List4docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List4docName);
            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter3);
            this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
            if (this.bundle.getString("list4Doc") == null || this.bundle.getString("list4Doc").equals("")) {
                this.binding.spinnerAfter2004Mother.setSelection(0);
                this.binding.spinnerBefore2004Father.setSelection(0);
                return;
            } else {
                this.binding.spinnerAfter2004Mother.setSelection(this.List4docCode.indexOf(this.bundle.getString("list4Doc")));
                this.binding.spinnerBefore2004Father.setSelection(this.List4docCode.indexOf(this.bundle.getString("list4Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list5)) {
            if (!this.List5docName.contains(this.selectDocumentType)) {
                this.List5docName.add(0, this.selectDocumentType);
                this.List5docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List5docName);
            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter4);
            if (this.bundle.getString("list5Doc") == null || this.bundle.getString("list5Doc").equals("")) {
                this.binding.spinnerAfter2004NotIndian.setSelection(0);
                return;
            } else {
                this.binding.spinnerAfter2004NotIndian.setSelection(this.List5docCode.indexOf(this.bundle.getString("list5Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list6)) {
            if (!this.List6docName.contains(this.selectDocumentType)) {
                this.List6docName.add(0, this.selectDocumentType);
                this.List6docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List6docName);
            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter5);
            if (this.bundle.getString("list6Doc") == null || this.bundle.getString("list6Doc").equals("")) {
                this.binding.spinnerBornOutOfIndia.setSelection(0);
                return;
            } else {
                this.binding.spinnerBornOutOfIndia.setSelection(this.List6docCode.indexOf(this.bundle.getString("list6Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list7)) {
            if (!this.List7docName.contains(this.selectDocumentType)) {
                this.List7docName.add(0, this.selectDocumentType);
                this.List7docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List7docName);
            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter6);
            if (this.bundle.getString("list7Doc") == null || this.bundle.getString("list7Doc").equals("")) {
                this.binding.spinnerAcquired.setSelection(0);
                return;
            } else {
                this.binding.spinnerAcquired.setSelection(this.List7docCode.indexOf(this.bundle.getString("list7Doc")));
                return;
            }
        }
        if (list.equalsIgnoreCase(this.list8)) {
            if (!this.List8docName.contains(this.selectDocumentType)) {
                this.List8docName.add(0, this.selectDocumentType);
                this.List8docCode.add(0, null);
            }
            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List8docName);
            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter7);
            if (this.bundle.getString("list8Doc") == null || this.bundle.getString("list8Doc").equals("")) {
                this.binding.spinnerIR.setSelection(0);
            } else {
                this.binding.spinnerIR.setSelection(this.List8docCode.indexOf(this.bundle.getString("list8Doc")));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.oldStatecd);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getDetailsByEroll(Integer.parseInt(this.oldAc), Integer.parseInt(this.OldPart), Integer.parseInt(this.binding.IROldPslNo.getText().toString().trim()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.18
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(FormDataForBloModificationPage2.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        String strOptString = jSONObject.optString("epic", null);
                        String strOptString2 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString3 = jSONObject.optString(Constants.LAST_NAME, null);
                        String strOptString4 = jSONObject.optString("relativeFName", null);
                        String strOptString5 = jSONObject.optString("relativeLName", null);
                        String strOptString6 = jSONObject.optString("relationType", null);
                        if (TextUtils.isEmpty(strOptString)) {
                            strOptString = "";
                        }
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        if (TextUtils.isEmpty(strOptString3)) {
                            strOptString3 = "";
                        }
                        if (TextUtils.isEmpty(strOptString4)) {
                            strOptString4 = "";
                        }
                        if (TextUtils.isEmpty(strOptString5)) {
                            strOptString5 = "";
                        }
                        if (TextUtils.isEmpty(strOptString6)) {
                            strOptString6 = "";
                        }
                        FormDataForBloModificationPage2.this.showVerifyDetailsDialog(strOptString2 + " " + strOptString3, strOptString4 + " " + strOptString5, strOptString6, strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("ReverifyPage2", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    FormDataForBloModificationPage2.this.isThisYou = false;
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.alertText, FormDataForBloModificationPage2.this.getString(R.string.no_record_found));
                    return;
                }
                FormDataForBloModificationPage2.this.isThisYou = false;
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String typeRelation, String epic) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_verify_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtTypeRelation);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtEpic);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.linearNameNew);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.linearNameNewRelative);
        LinearLayout linearLayout3 = (LinearLayout) dialog.findViewById(R.id.linearNameEpic);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtSureNew);
        linearLayout.setVisibility(8);
        linearLayout3.setVisibility(8);
        textView5.setVisibility(8);
        linearLayout2.setVisibility(8);
        textView.setText(name);
        textView2.setText(relativeName);
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH") || typeRelation.equalsIgnoreCase("Grand Mother")) {
                textView3.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH") || typeRelation.equalsIgnoreCase("Grand Father")) {
                textView3.setText("Grand Father");
            } else if (typeRelation.equals("MTHR") || typeRelation.equalsIgnoreCase("Mother") || typeRelation.equalsIgnoreCase("M")) {
                textView3.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F") || typeRelation.equalsIgnoreCase("Father")) {
                textView3.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H") || typeRelation.equalsIgnoreCase("Husband")) {
                textView3.setText("Husband");
            } else if (typeRelation.equals("OTHR") || typeRelation.equalsIgnoreCase("Other")) {
                textView3.setText("Other");
            } else if (TextUtils.isEmpty(typeRelation)) {
                textView3.setText("");
            }
        }
        textView4.setText(epic);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                FormDataForBloModificationPage2.this.isThisYou = true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                FormDataForBloModificationPage2.this.isThisYou = false;
            }
        });
        dialog.show();
    }

    private void callIRFields() {
        this.OldPsl = this.binding.IROldPslNo.getText().toString();
    }

    private void callParentFields() {
        if (this.cat.equalsIgnoreCase("CAT-4")) {
            if (this.binding.parentYesRb.isChecked()) {
                this.fatherOldAc = this.binding.fatherOldAcNo.getText().toString();
                this.fatherOldPart = this.binding.fatherOldPartNo.getText().toString();
                this.fatherOldPsl = this.binding.fatherOldPslNo.getText().toString();
                this.motherOldAc = this.binding.motherOldAcNo.getText().toString();
                this.motherOldPart = this.binding.motherOldPartNo.getText().toString();
                this.motherOldPsl = this.binding.motherOldPslNo.getText().toString();
            } else if (this.binding.parentNoRb.isChecked()) {
                if (this.binding.parentMotherRb.isChecked()) {
                    this.motherOldAc = this.binding.motherOldAcNo.getText().toString();
                    this.motherOldPart = this.binding.motherOldPartNo.getText().toString();
                    this.motherOldPsl = this.binding.motherOldPslNo.getText().toString();
                } else if (this.binding.parentFatherRb.isChecked()) {
                    this.fatherOldAc = this.binding.fatherOldAcNo.getText().toString();
                    this.fatherOldPart = this.binding.fatherOldPartNo.getText().toString();
                    this.fatherOldPsl = this.binding.fatherOldPslNo.getText().toString();
                }
            }
        }
        if (this.cat.equalsIgnoreCase("CAT-3")) {
            if (this.binding.betweenParentMotherRb.isChecked()) {
                this.motherOldAc = this.binding.father1OldAcNo.getText().toString();
                this.motherOldPart = this.binding.father1OldPartNo.getText().toString();
                this.motherOldPsl = this.binding.father1OldPslNo.getText().toString();
            } else if (this.binding.betweenParentFatherRb.isChecked()) {
                this.fatherOldAc = this.binding.father1OldAcNo.getText().toString();
                this.fatherOldPart = this.binding.father1OldPartNo.getText().toString();
                this.fatherOldPsl = this.binding.father1OldPslNo.getText().toString();
            }
        }
    }

    private boolean validate() {
        if (!this.cat.equalsIgnoreCase("CAT-1")) {
            return true;
        }
        if (TextUtils.isEmpty(this.oldStatecd)) {
            showDialog1(this.alertText, getString(R.string.please_select_previous_sir_state));
            return false;
        }
        if (TextUtils.isEmpty(this.oldAc)) {
            showDialog1(this.alertText, getString(R.string.please_enter_previous_sir_ac));
            return false;
        }
        if (TextUtils.isEmpty(this.OldPart)) {
            showDialog1(this.alertText, getString(R.string.please_enter_previous_sir_part));
            return false;
        }
        if (!TextUtils.isEmpty(this.OldPsl)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.please_enter_previous_sir_part_serial_no));
        return false;
    }

    private boolean validate2() {
        if (!this.cat.equalsIgnoreCase("CAT-3") && !this.cat.equalsIgnoreCase("CAT-4")) {
            return true;
        }
        if (!TextUtils.isEmpty(this.list3code) && this.list3code.equals("L3D0") && this.binding.viewFatherOldLayout.getVisibility() == 0) {
            if (TextUtils.isEmpty(this.fatherOldAc)) {
                showDialog1(this.alertText, "Please enter father old AC");
                return false;
            }
            if (TextUtils.isEmpty(this.fatherOldPart)) {
                showDialog1(this.alertText, "Please enter father old Part");
                return false;
            }
            if (TextUtils.isEmpty(this.fatherOldPsl)) {
                showDialog1(this.alertText, "Please enter father old Part serial no");
                return false;
            }
        }
        if (TextUtils.isEmpty(this.list4code) || !this.list4code.equals("L4D0") || this.binding.viewMotherOldLayout.getVisibility() != 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.motherOldAc)) {
            showDialog1(this.alertText, "Please enter mother Previous SIR AC");
            return false;
        }
        if (TextUtils.isEmpty(this.motherOldPart)) {
            showDialog1(this.alertText, "Please enter mother Previous SIR Part");
            return false;
        }
        if (!TextUtils.isEmpty(this.motherOldPsl)) {
            return true;
        }
        showDialog1(this.alertText, "Please enter mother Previous SIR Part serial no");
        return false;
    }

    private boolean validate3() {
        if (this.cat.equals("CAT-2") && TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2)) {
            showDialog1(this.alertText, getString(R.string.please_upload_self_doc));
            return false;
        }
        if (this.cat.equals("CAT-3") && TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2) && TextUtils.isEmpty(this.list3Ref) && TextUtils.isEmpty(this.list3Ref2) && TextUtils.isEmpty(this.list4Ref) && TextUtils.isEmpty(this.list4Ref2)) {
            showDialog1(this.alertText, getString(R.string.please_upload_document));
            return false;
        }
        if (this.cat.equals("CAT-5") && TextUtils.isEmpty(this.list6ref) && TextUtils.isEmpty(this.list6ref2)) {
            showDialog1(this.alertText, getString(R.string.please_upload_document));
            return false;
        }
        if (this.cat.equals("CAT-6") && TextUtils.isEmpty(this.list7ref) && TextUtils.isEmpty(this.list7ref2)) {
            showDialog1(this.alertText, getString(R.string.please_upload_document));
            return false;
        }
        if (this.cat.equals("CAT-4")) {
            if (this.binding.parentYesRb.isChecked()) {
                String[] strArr = {this.list1ref, this.list1ref2, this.list3Ref, this.list3Ref2, this.list4Ref, this.list4Ref2};
                for (int i = 0; i < 6; i++) {
                    if (TextUtils.isEmpty(strArr[i])) {
                    }
                }
                showDialog1(this.alertText, getString(R.string.please_upload_document));
                return false;
            }
            if (this.binding.parentNoRb.isChecked()) {
                String[] strArr2 = {this.list1ref, this.list1ref2, this.list3Ref, this.list3Ref2, this.list4Ref, this.list4Ref2, this.list5Ref, this.list5Ref2, this.list5ref3};
                for (int i2 = 0; i2 < 9; i2++) {
                    if (TextUtils.isEmpty(strArr2[i2])) {
                    }
                }
                showDialog1(this.alertText, getString(R.string.please_upload_document));
                return false;
            }
            if (TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2)) {
                showDialog1(this.alertText, getString(R.string.please_upload_document));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 101) {
            this.IRRef = null;
            this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileIR2003.setEnabled(true);
            this.binding.imageIR.setVisibility(8);
            this.binding.IRSize.setText("");
            this.binding.IRName.setText("");
            this.binding.cancelIR.setVisibility(8);
            this.binding.viewLayoutIR.setVisibility(8);
            return;
        }
        if (code == 102) {
            this.list1ref = null;
            this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore1987.setEnabled(true);
            this.binding.imageList1.setVisibility(8);
            this.binding.list1Size.setText("");
            this.binding.list1Name.setText("");
            this.binding.cancelList1.setVisibility(8);
            this.binding.viewLayoutList1.setVisibility(8);
            return;
        }
        if (code == 103) {
            this.list1ref = null;
            this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004Self.setEnabled(true);
            this.binding.imageBefore2004Self.setVisibility(8);
            this.binding.before2004SelfSize.setText("");
            this.binding.before2004SelfName.setText("");
            this.binding.cancelBefore2004Self.setVisibility(8);
            this.binding.viewLayoutBefore2004Self.setVisibility(8);
            return;
        }
        if (code == 104) {
            this.list3Ref = null;
            this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004Father.setEnabled(true);
            this.binding.imageList2.setVisibility(8);
            this.binding.list2Size.setText("");
            this.binding.list2Name.setText("");
            this.binding.cancelList2.setVisibility(8);
            this.binding.viewLayoutList2.setVisibility(8);
            return;
        }
        if (code == 105) {
            this.list1ref = null;
            this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Self.setEnabled(true);
            this.binding.imageAfter2004self.setVisibility(8);
            this.binding.after2004selfSize.setText("");
            this.binding.after2004selfName.setText("");
            this.binding.cancelAfter2004self.setVisibility(8);
            this.binding.viewLayoutAfter2004self.setVisibility(8);
            return;
        }
        if (code == 106) {
            this.list3Ref = null;
            this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Father.setEnabled(true);
            this.binding.imageList3.setVisibility(8);
            this.binding.list3Size.setText("");
            this.binding.list3Name.setText("");
            this.binding.cancelList3.setVisibility(8);
            this.binding.viewList3.setVisibility(8);
            return;
        }
        if (code == 107 || code == 111) {
            this.list4Ref = null;
            this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004Mother.setEnabled(true);
            this.binding.imageList4.setVisibility(8);
            this.binding.list4Size.setText("");
            this.binding.list4Name.setText("");
            this.binding.cancelList4.setVisibility(8);
            this.binding.viewList4.setVisibility(8);
            return;
        }
        if (code == 108) {
            this.list5Ref = null;
            this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
            this.binding.imageList5.setVisibility(8);
            this.binding.list5Size.setText("");
            this.binding.list5Name.setText("");
            this.binding.cancelList5.setVisibility(8);
            this.binding.viewList5.setVisibility(8);
            return;
        }
        if (code == 109) {
            this.list6ref = null;
            this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBornOutOfIndia.setEnabled(true);
            this.binding.imageList6.setVisibility(8);
            this.binding.list6Size.setText("");
            this.binding.list6Name.setText("");
            this.binding.cancelList6.setVisibility(8);
            this.binding.viewList6.setVisibility(8);
            return;
        }
        if (code == 110) {
            this.list7ref = null;
            this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAcquired.setEnabled(true);
            this.binding.imageList7.setVisibility(8);
            this.binding.list7Size.setText("");
            this.binding.list7Name.setText("");
            this.binding.cancelList7.setVisibility(8);
            this.binding.viewList7.setVisibility(8);
            return;
        }
        if (code == 201) {
            this.IRRef2 = null;
            this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileIR2003Page2.setEnabled(true);
            this.binding.imageIRPage2.setVisibility(8);
            this.binding.IRSizePage2.setText("");
            this.binding.IRNamePage2.setText("");
            this.binding.cancelIRPage2.setVisibility(8);
            this.binding.viewLayoutIRPage2.setVisibility(8);
            return;
        }
        if (code == 202) {
            this.list1ref2 = null;
            this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore1987Page2.setEnabled(true);
            this.binding.imageList1Page2.setVisibility(8);
            this.binding.list1SizePage2.setText("");
            this.binding.list1NamePage2.setText("");
            this.binding.cancelList1Page2.setVisibility(8);
            this.binding.viewLayoutList1Page2.setVisibility(8);
            return;
        }
        if (code == 203) {
            this.list1ref2 = null;
            this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
            this.binding.imageBefore2004SelfPage2.setVisibility(8);
            this.binding.before2004SelfSizePage2.setText("");
            this.binding.before2004SelfNamePage2.setText("");
            this.binding.cancelBefore2004SelfPage2.setVisibility(8);
            this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
            return;
        }
        if (code == 204) {
            this.list3Ref2 = null;
            this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
            this.binding.imageList2Page2.setVisibility(8);
            this.binding.list2SizePage2.setText("");
            this.binding.list2NamePage2.setText("");
            this.binding.cancelList2Page2.setVisibility(8);
            this.binding.viewLayoutList2Page2.setVisibility(8);
            return;
        }
        if (code == 205) {
            this.list1ref2 = null;
            this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
            this.binding.imageAfter2004selfPage2.setVisibility(8);
            this.binding.after2004selfSizePage2.setText("");
            this.binding.after2004selfNamePage2.setText("");
            this.binding.cancelAfter2004selfPage2.setVisibility(8);
            this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
            return;
        }
        if (code == 206) {
            this.list3Ref2 = null;
            this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
            this.binding.imageList3Page2.setVisibility(8);
            this.binding.list3SizePage2.setText("");
            this.binding.list3NamePage2.setText("");
            this.binding.cancelList3Page2.setVisibility(8);
            this.binding.viewList3Page2.setVisibility(8);
            return;
        }
        if (code == 207 || code == 211) {
            this.list4Ref2 = null;
            this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
            this.binding.imageList4Page2.setVisibility(8);
            this.binding.list4SizePage2.setText("");
            this.binding.list4NamePage2.setText("");
            this.binding.cancelList4Page2.setVisibility(8);
            this.binding.viewList4Page2.setVisibility(8);
            return;
        }
        if (code == 208) {
            this.list5Ref2 = null;
            this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
            this.binding.imageList5Page2.setVisibility(8);
            this.binding.list5SizePage2.setText("");
            this.binding.list5NamePage2.setText("");
            this.binding.cancelList5Page2.setVisibility(8);
            this.binding.viewList5Page2.setVisibility(8);
            return;
        }
        if (code == 209) {
            this.list6ref2 = null;
            this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
            this.binding.imageList6Page2.setVisibility(8);
            this.binding.list6SizePage2.setText("");
            this.binding.list6NamePage2.setText("");
            this.binding.cancelList6Page2.setVisibility(8);
            this.binding.viewList6Page2.setVisibility(8);
            return;
        }
        if (code == 210) {
            this.list7ref2 = null;
            this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAcquiredPage2.setEnabled(true);
            this.binding.imageList7Page2.setVisibility(8);
            this.binding.list7SizePage2.setText("");
            this.binding.list7NamePage2.setText("");
            this.binding.cancelList7Page2.setVisibility(8);
            this.binding.viewList7Page2.setVisibility(8);
            return;
        }
        if (code == 212) {
            this.list5ref3 = null;
            this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
            this.binding.imageList5Page3.setVisibility(8);
            this.binding.list5SizePage3.setText("");
            this.binding.list5NamePage3.setText("");
            this.binding.cancelList5Page3.setVisibility(8);
            this.binding.viewList5Page3.setVisibility(8);
        }
    }

    private void clearLists() {
        this.List1docName.clear();
        this.List1docCode.clear();
        this.List2docName.clear();
        this.List2docCode.clear();
        this.List3docName.clear();
        this.List3docCode.clear();
        this.List4docName.clear();
        this.List4docCode.clear();
        this.List5docName.clear();
        this.List5docCode.clear();
        this.List6docName.clear();
        this.List6docCode.clear();
        this.List7docName.clear();
        this.List7docCode.clear();
        this.List8docName.clear();
        this.List8docCode.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit() {
        String str;
        String string;
        String str2;
        String[] strArr;
        int i;
        String str3;
        callIRFields();
        try {
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this.dob));
            while (true) {
                if (i >= 17) {
                    str3 = "N";
                    break;
                } else {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        str3 = "Y";
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            String str4 = this.dob;
            Logger.d("Date replace", e.toString());
            str = str4;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        HashMap map2 = new HashMap();
        map2.put("epicNo", TextUtils.isEmpty(this.epicNumber) ? "" : this.epicNumber);
        map2.put("epicId", this.epicId);
        map2.put("stCode", TextUtils.isEmpty(this.state) ? "" : this.state);
        map2.put("houseNo", TextUtils.isEmpty(this.houseNumber) ? "" : this.houseNumber);
        map2.put("dobVerified", TextUtils.isEmpty(str) ? "" : this.dob);
        map2.put("erollDob", this.actualDateOfBirthS);
        map2.put("districtCd", SharedPref.getInstance(this).getDistrictCode());
        map2.put("acNo", SharedPref.getInstance(this).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(this).getPartNumber());
        map2.put("partSerialNo", TextUtils.isEmpty(this.serial) ? "" : this.serial);
        map2.put("createdBy", TextUtils.isEmpty(this.bundle.getString("createdByFlag")) ? "" : this.bundle.getString("createdByFlag"));
        map2.put("modifiedDttm", "");
        map2.put("modifiedBy", "BLO");
        map2.put("photoUrl", TextUtils.isEmpty(this.photoref) ? "" : this.photoref);
        map2.put("srFormPage1Url", TextUtils.isEmpty(this.photo1ref) ? "" : this.photo1ref);
        map2.put("citizenshipType", TextUtils.isEmpty(this.choice) ? "" : this.choice);
        map2.put("citizenshipTypeCat", TextUtils.isEmpty(this.cat) ? "" : this.cat);
        map2.put("surveyChannel", this.surveyChannel);
        map2.put("list1Doc", TextUtils.isEmpty(this.list1Code) ? "" : this.list1Code);
        map2.put("list2Doc", TextUtils.isEmpty(this.list2code) ? "" : this.list2code);
        map2.put("list3Doc", TextUtils.isEmpty(this.list3code) ? "" : this.list3code);
        map2.put("list4Doc", TextUtils.isEmpty(this.list4code) ? "" : this.list4code);
        map2.put("list5Doc", TextUtils.isEmpty(this.list5code) ? "" : this.list5code);
        map2.put("list6Doc", TextUtils.isEmpty(this.list6code) ? "" : this.list6code);
        map2.put("list7Doc", TextUtils.isEmpty(this.list7code) ? "" : this.list7code);
        map2.put("list1DocUrl", TextUtils.isEmpty(this.list1ref) ? "" : this.list1ref);
        map2.put("list2DocUrl", TextUtils.isEmpty(this.list2Ref) ? "" : this.list2Ref);
        map2.put("list3DocUrl", TextUtils.isEmpty(this.list3Ref) ? "" : this.list3Ref);
        map2.put("list4DocUrl", TextUtils.isEmpty(this.list4Ref) ? "" : this.list4Ref);
        map2.put("list5DocUrl", TextUtils.isEmpty(this.list5Ref) ? "" : this.list5Ref);
        map2.put("list6DocUrl", TextUtils.isEmpty(this.list6ref) ? "" : this.list6ref);
        map2.put("list7DocUrl", TextUtils.isEmpty(this.list7ref) ? "" : this.list7ref);
        map2.put("list1docUrlPg2", TextUtils.isEmpty(this.list1ref2) ? "" : this.list1ref2);
        map2.put("list2docUrlPg2", TextUtils.isEmpty(this.list2Ref2) ? "" : this.list2Ref2);
        map2.put("list3docUrlPg2", TextUtils.isEmpty(this.list3Ref2) ? "" : this.list3Ref2);
        map2.put("list4docUrlPg2", TextUtils.isEmpty(this.list4Ref2) ? "" : this.list4Ref2);
        map2.put("list5docUrlPg2", TextUtils.isEmpty(this.list5Ref2) ? "" : this.list5Ref2);
        map2.put("list6docUrlPg2", TextUtils.isEmpty(this.list6ref2) ? "" : this.list6ref2);
        map2.put("list7docUrlPg2", TextUtils.isEmpty(this.list7ref2) ? "" : this.list7ref2);
        map2.put("list5docUrlPg3", TextUtils.isEmpty(this.list5ref3) ? "" : this.list5ref3);
        map2.put("aadharNo", TextUtils.isEmpty(this.aadharNo) ? "" : this.aadharNo);
        map2.put("mobileNo", TextUtils.isEmpty(this.mobileNo) ? "" : this.mobileNo);
        map2.put("fathersOrGuardianName", TextUtils.isEmpty(this.fatherName) ? "" : this.fatherName);
        map2.put("fathersOrGuardianEpicNo", TextUtils.isEmpty(this.fatherEpic) ? "" : this.fatherEpic);
        map2.put("mothersName", TextUtils.isEmpty(this.motherName) ? "" : this.motherName);
        map2.put("mothersEpicNo", TextUtils.isEmpty(this.motherEpic) ? "" : this.motherEpic);
        map2.put("spouseName", TextUtils.isEmpty(this.spouseName) ? "" : this.spouseName);
        map2.put("spouseEpicNo", TextUtils.isEmpty(this.spouseEpic) ? "" : this.spouseEpic);
        map2.put("annexureCUrl", TextUtils.isEmpty(this.annexref) ? "" : this.annexref);
        map2.put("preRevisionVoterFlg", (TextUtils.isEmpty(this.cat) || !this.cat.equals("CAT-1")) ? "N" : "Y");
        map2.put("preRevisionVoterDocUrl", TextUtils.isEmpty(this.IRRef) ? "" : this.IRRef);
        map2.put("preRevisionVoterDocUrlPg2", TextUtils.isEmpty(this.IRRef2) ? "" : this.IRRef2);
        map2.put("submittedForRecommendation", TextUtils.isEmpty(this.submitFlag) ? "" : this.submitFlag);
        map2.put("fathersNationality", TextUtils.isEmpty(this.fatherNationality) ? "Indian" : this.fatherNationality);
        map2.put("mothersNationality", TextUtils.isEmpty(this.motherNationality) ? "Indian" : this.motherNationality);
        map2.put("srFormPage2Url", TextUtils.isEmpty(this.photo2ref) ? "" : this.photo2ref);
        map2.put("oldAcNo", TextUtils.isEmpty(this.oldAc) ? "" : this.oldAc);
        map2.put("oldPartNo", TextUtils.isEmpty(this.OldPart) ? "" : this.OldPart);
        map2.put("oldPslNo", TextUtils.isEmpty(this.OldPsl) ? "" : this.OldPsl);
        map2.put("list8Doc", TextUtils.isEmpty(this.list8code) ? "" : this.list8code);
        map2.put("moldAcNo", TextUtils.isEmpty(this.motherOldAc) ? "" : this.motherOldAc);
        map2.put("moldPartNo", TextUtils.isEmpty(this.motherOldPart) ? "" : this.motherOldPart);
        map2.put("moldPslNo", TextUtils.isEmpty(this.motherOldPsl) ? "" : this.motherOldPsl);
        map2.put("foldAcNo", TextUtils.isEmpty(this.fatherOldAc) ? "" : this.fatherOldAc);
        map2.put("foldPartNo", TextUtils.isEmpty(this.fatherOldPart) ? "" : this.fatherOldPart);
        map2.put("foldPslNo", TextUtils.isEmpty(this.fatherOldPsl) ? "" : this.fatherOldPsl);
        map2.put("relationOldStateCd", TextUtils.isEmpty(this.bundle.getString("relationOldStateCd")) ? null : this.bundle.getString("relationOldStateCd"));
        map2.put("relationOldAcNo", TextUtils.isEmpty(this.bundle.getString("relationOldAcNo")) ? null : this.bundle.getString("relationOldAcNo"));
        map2.put("relationOldPartNo", TextUtils.isEmpty(this.bundle.getString("relationOldPartNo")) ? null : this.bundle.getString("relationOldPartNo"));
        map2.put("relationOldPslNo", TextUtils.isEmpty(this.bundle.getString("relationOldPSLNo")) ? null : this.bundle.getString("relationOldPSLNo"));
        map2.put("relationDocType", TextUtils.isEmpty(this.bundle.getString("relationList8Code")) ? "" : this.bundle.getString("relationList8Code"));
        map2.put("relationDocUrlPg1", TextUtils.isEmpty(this.bundle.getString("relationList8DocPage1")) ? "" : this.bundle.getString("relationList8DocPage1"));
        map2.put("relationDocUrlPg2", TextUtils.isEmpty(this.bundle.getString("relationList8DocPage2")) ? "" : this.bundle.getString("relationList8DocPage2"));
        map2.put("isRelativePreVoterFlg", TextUtils.isEmpty(this.bundle.getString("isRelative2003")) ? "" : this.bundle.getString("isRelative2003"));
        if (TextUtils.isEmpty(this.bundle.getString("relationProofDocPage1"))) {
            string = "";
            str2 = string;
        } else {
            string = this.bundle.getString("relationProofDocPage1");
            str2 = "";
        }
        map2.put("relationProofDocUrlPg1", string);
        map2.put("relationProofDocUrlPg2", TextUtils.isEmpty(this.bundle.getString("relationProofDocPage2")) ? str2 : this.bundle.getString("relationProofDocPage2"));
        map2.put("relationType", TextUtils.isEmpty(this.bundle.getString("relationCode")) ? str2 : this.bundle.getString("relationCode"));
        map2.put("oldStateCd", TextUtils.isEmpty(this.oldStatecd) ? str2 : this.oldStatecd);
        map2.put("relationEpicNo", TextUtils.isEmpty(this.bundle.getString("relativeEpic")) ? str2 : this.bundle.getString("relativeEpic"));
        strArr = new String[]{this.list1ref, this.list1ref2, this.list2Ref, this.list2Ref2, this.list3Ref, this.list3Ref2, this.list4Ref, this.list4Ref2, this.list5Ref, this.list5Ref2, this.list5ref3, this.list6ref, this.list6ref2, this.list7ref, this.list7ref2, this.IRRef, this.IRRef2};
        i = 0;
        map2.put("documentUploadedFlg", str3);
        map2.put("bloOverridenFlg", this.bundle.getString("bloOverridenFlg"));
        String str5 = str3;
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou ? "Y" : "N");
        Logger.d(this.TAG, map2.toString());
        if (this.onlineStatus) {
            ((UserClient) ApiClient.getClient(this).create(UserClient.class)).updateSpecialRevision2SIR(map, map2).enqueue(new AnonymousClass21());
            return;
        }
        try {
            this.sirDatabaseHelper.SpecialRevisionDao().addSpecialSurveyRevisionDetails(new SpecialSurveyRevisionModel(this.epicId, this.state, this.epicNumber, this.houseNumber, this.dob, this.actualDateOfBirthS, SharedPref.getInstance(this).getDistrictCode(), this.asmblyNO, this.partNo, this.serial, null, this.bundle.getString("createdByFlag"), null, "BLO", this.photoref, this.photo1ref, this.choice, this.cat, TextUtils.isEmpty(this.list1Code) ? str2 : this.list1Code, TextUtils.isEmpty(this.list2code) ? str2 : this.list2code, TextUtils.isEmpty(this.list3code) ? str2 : this.list3code, TextUtils.isEmpty(this.list4code) ? str2 : this.list4code, TextUtils.isEmpty(this.list5code) ? str2 : this.list5code, TextUtils.isEmpty(this.list6code) ? str2 : this.list6code, TextUtils.isEmpty(this.list7code) ? str2 : this.list7code, this.list1ref, this.list2Ref, this.list3Ref, this.list4Ref, this.list5Ref, this.list6ref, this.list7ref, this.surveyChannel, this.aadharNo, this.mobileNo, null, this.fatherEpic, null, this.motherEpic, null, this.spouseEpic, TextUtils.isEmpty(this.annexref) ? str2 : this.annexref, (TextUtils.isEmpty(this.cat) || !this.cat.equals("CAT-1")) ? "N" : "Y", this.IRRef, this.submitFlag, this.fatherNationality, this.motherNationality, this.photo2ref, this.oldAc, this.OldPart, this.OldPsl, this.fatherOldAc, this.fatherOldPart, this.fatherOldPsl, this.motherOldAc, this.motherOldPart, this.motherOldPsl, this.list8code, str5, "", "", this.list1ref2, this.list2Ref2, this.list3Ref2, this.list4Ref2, this.list5Ref2, this.list5ref3, this.list6ref2, this.list7ref2, this.IRRef2, "", null, null, null, this.bundle.getString("bloOverridenFlg"), null, null, null, null, this.bundle.getString("relationCode"), this.bundle.getString("relationList8Code"), this.bundle.getString("relationList8DocPage1"), this.bundle.getString("isRelative2003"), this.bundle.getString("relationList8DocPage2"), this.bundle.getString("relationProofDocPage1"), this.bundle.getString("relationProofDocPage2"), this.bundle.getString("relationOldAcNo"), this.bundle.getString("relationOldPartNo"), this.bundle.getString("relationOldPSLNo"), this.bundle.getString("relativeEpic"), this.isThisYou ? "Y" : "N", this.isThisYouRel, this.tabName, this.bundle.getString("relationOldStateCd"), this.oldStatecd));
            showDialog3(str2, getString(R.string.form_saved_successfully));
            WorkManager.getInstance(this).enqueueUniqueWork("SIR_UPLOAD_WORK", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(SirUploadWorker.class).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10L, TimeUnit.SECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
        } catch (Exception e2) {
            Logger.d(this.TAG, e2.toString());
            showDialog1("Error", getString(R.string.something_went_wrong));
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        AnonymousClass21() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.showDialog2(formDataForBloModificationPage2.alertText, string);
                } else {
                    FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage3.showDialog2("", formDataForBloModificationPage3.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("ReverifyPage2", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$21$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$72(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$72(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationList.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("lists", list);
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionListSIR(map, map2).enqueue(new AnonymousClass22(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass22(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v119, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v140, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v158, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v26, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v44, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v62, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v80, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
        /* JADX WARN: Type inference failed for: r3v98, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.payloadData1 = (JsonObject) response.body();
                if (FormDataForBloModificationPage2.this.payloadData1 != null) {
                    JsonArray asJsonArray = FormDataForBloModificationPage2.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage2.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1") && FormDataForBloModificationPage2.this.List1docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List1docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List1docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List1docCode.add(0, null);
                            }
                            ?? r3 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.List1docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            FormDataForBloModificationPage2.this.binding.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            FormDataForBloModificationPage2.this.binding.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list1Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list1Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerBefore1987Self.setSelection(0);
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Self.setSelection(0);
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Self.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerBefore1987Self.setSelection(FormDataForBloModificationPage2.this.List1docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list1Doc")));
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Self.setSelection(FormDataForBloModificationPage2.this.List1docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list1Doc")));
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Self.setSelection(FormDataForBloModificationPage2.this.List1docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list1Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-2") && FormDataForBloModificationPage2.this.List2docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List2docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List2docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List2docCode.add(0, null);
                            }
                            ?? r4 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) r4, R.layout.blo_spinner_dropdown, r4.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list2Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list2Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(FormDataForBloModificationPage2.this.List2docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list2Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-3") && FormDataForBloModificationPage2.this.List3docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List3docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List3docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List3docCode.add(0, null);
                            }
                            ?? r5 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) r5, R.layout.blo_spinner_dropdown, r5.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list3Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list3Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Father.setSelection(0);
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Father.setSelection(FormDataForBloModificationPage2.this.List3docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list3Doc")));
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(FormDataForBloModificationPage2.this.List3docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list3Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-4") && FormDataForBloModificationPage2.this.List4docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List4docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List4docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List4docCode.add(0, null);
                            }
                            ?? r6 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) r6, R.layout.blo_spinner_dropdown, r6.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list4Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list4Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Mother.setSelection(0);
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004Mother.setSelection(FormDataForBloModificationPage2.this.List4docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list4Doc")));
                                FormDataForBloModificationPage2.this.binding.spinnerBefore2004Father.setSelection(FormDataForBloModificationPage2.this.List4docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list4Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-5") && FormDataForBloModificationPage2.this.List5docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List5docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List5docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List5docCode.add(0, null);
                            }
                            ?? r7 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) r7, R.layout.blo_spinner_dropdown, r7.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list5Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list5Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004NotIndian.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerAfter2004NotIndian.setSelection(FormDataForBloModificationPage2.this.List5docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list5Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-6") && FormDataForBloModificationPage2.this.List6docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List6docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List6docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List6docCode.add(0, null);
                            }
                            ?? r8 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) r8, R.layout.blo_spinner_dropdown, r8.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list6Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list6Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerBornOutOfIndia.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerBornOutOfIndia.setSelection(FormDataForBloModificationPage2.this.List6docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list6Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-7") && FormDataForBloModificationPage2.this.List7docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List7docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List7docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List7docCode.add(0, null);
                            }
                            ?? r9 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) r9, R.layout.blo_spinner_dropdown, r9.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list7Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list7Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerAcquired.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerAcquired.setSelection(FormDataForBloModificationPage2.this.List7docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list7Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-8") && FormDataForBloModificationPage2.this.List8docName.size() != size + 1) {
                            FormDataForBloModificationPage2.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            FormDataForBloModificationPage2.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!FormDataForBloModificationPage2.this.List8docName.contains(FormDataForBloModificationPage2.this.selectDocumentType)) {
                                FormDataForBloModificationPage2.this.List8docName.add(0, FormDataForBloModificationPage2.this.selectDocumentType);
                                FormDataForBloModificationPage2.this.List8docCode.add(0, null);
                            }
                            ?? r10 = FormDataForBloModificationPage2.this;
                            ArrayAdapter arrayAdapter8 = new ArrayAdapter((Context) r10, R.layout.blo_spinner_dropdown, r10.List8docName);
                            arrayAdapter8.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            FormDataForBloModificationPage2.this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter8);
                            if (FormDataForBloModificationPage2.this.bundle.getString("list8Doc") == null || FormDataForBloModificationPage2.this.bundle.getString("list8Doc").equals("")) {
                                FormDataForBloModificationPage2.this.binding.spinnerIR.setSelection(0);
                            } else {
                                FormDataForBloModificationPage2.this.binding.spinnerIR.setSelection(FormDataForBloModificationPage2.this.List8docCode.indexOf(FormDataForBloModificationPage2.this.bundle.getString("list8Doc")));
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r14 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r14).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r14, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                Logger.e(FormDataForBloModificationPage2.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getList1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent(FormDataForBloModificationPage2.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            Logger.d(FormDataForBloModificationPage2.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFileIntensiveRevision(final int code, final String listCode) {
        final String strReplaceAll = this.epicNumber.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addDocumentMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda76
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$73(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$73(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            this.pdf = false;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFileIntensiveRevision(final int code) {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addDocumentMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda75
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$74(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$74(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.pdf = false;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$75(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$75(View view) {
        onBackPressed();
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + code + this.jpgTextBaseActivity;
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
            Logger.d(this.TAG, this.TAG + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.TAG + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
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
            ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass23(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass23(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v18, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r13 = FormDataForBloModificationPage2.this;
                String str = ((FormDataForBloModificationPage2) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$23$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 429) {
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
                        FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                        formDataForBloModificationPage2.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage2.token, this.val$reference, this.val$uploadtype);
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
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr)) {
                        FormDataForBloModificationPage2.this.IRRef = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("IRRef", FormDataForBloModificationPage2.this.IRRef);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str)) {
                        FormDataForBloModificationPage2.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref1987", FormDataForBloModificationPage2.this.list1ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str)) {
                        FormDataForBloModificationPage2.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref2004", FormDataForBloModificationPage2.this.list1ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str)) {
                        FormDataForBloModificationPage2.this.list2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list2ref", FormDataForBloModificationPage2.this.list2Ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str)) {
                        FormDataForBloModificationPage2.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1refafter2004", FormDataForBloModificationPage2.this.list1ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str)) {
                        FormDataForBloModificationPage2.this.list3Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list3Ref", FormDataForBloModificationPage2.this.list3Ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str)) {
                        FormDataForBloModificationPage2.this.list4Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list4Ref", FormDataForBloModificationPage2.this.list4Ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str)) {
                        FormDataForBloModificationPage2.this.list5Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref", FormDataForBloModificationPage2.this.list5Ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str)) {
                        FormDataForBloModificationPage2.this.list6ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List6ref", FormDataForBloModificationPage2.this.list6ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str)) {
                        FormDataForBloModificationPage2.this.list7ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list7ref", FormDataForBloModificationPage2.this.list7ref);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr2)) {
                        FormDataForBloModificationPage2.this.IRRef2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("IRRef2", FormDataForBloModificationPage2.this.IRRef2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str2)) {
                        FormDataForBloModificationPage2.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref21987", FormDataForBloModificationPage2.this.list1ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str2)) {
                        FormDataForBloModificationPage2.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref22004", FormDataForBloModificationPage2.this.list1ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str2)) {
                        FormDataForBloModificationPage2.this.list2Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list2ref2", FormDataForBloModificationPage2.this.list2Ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str2)) {
                        FormDataForBloModificationPage2.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List1ref2after2004", FormDataForBloModificationPage2.this.list1ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str2)) {
                        FormDataForBloModificationPage2.this.list3Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list3Ref2", FormDataForBloModificationPage2.this.list3Ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str2)) {
                        FormDataForBloModificationPage2.this.list4Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list4Ref2", FormDataForBloModificationPage2.this.list4Ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str2)) {
                        FormDataForBloModificationPage2.this.list5Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref", FormDataForBloModificationPage2.this.list5Ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str3)) {
                        FormDataForBloModificationPage2.this.list5ref3 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List5ref3", FormDataForBloModificationPage2.this.list5ref3);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str2)) {
                        FormDataForBloModificationPage2.this.list6ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("List6ref2", FormDataForBloModificationPage2.this.list6ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str2)) {
                        FormDataForBloModificationPage2.this.list7ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("list7ref2", FormDataForBloModificationPage2.this.list7ref2);
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.d(FormDataForBloModificationPage2.this.TAG, "Presigned URL : " + strDecryptUrl);
                    UploadWithPreSignedURL.uploadToS3(this.val$filepath + this.val$captureFileName, FormDataForBloModificationPage2.this.mime, strDecryptUrl, null);
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.imageIR.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.viewLayoutIR.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileIR2003.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileIR2003.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.IRcount = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage3.showDialog1(formDataForBloModificationPage3.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutList1.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList1.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.before1987count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage4 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage4.showDialog1(formDataForBloModificationPage4.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004Self.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.before1987count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage5 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage5.showDialog1(formDataForBloModificationPage5.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutList2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Father.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.list2count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage6 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage6.showDialog1(formDataForBloModificationPage6.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004self.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageAfter2004self.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setEnabled(true);
                FormDataForBloModificationPage2.this.after2004count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage7 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage7.showDialog1(formDataForBloModificationPage7.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList3.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList3.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setEnabled(true);
                FormDataForBloModificationPage2.this.list3count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage8 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage8.showDialog1(formDataForBloModificationPage8.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList4.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList4.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                FormDataForBloModificationPage2.this.list4coumt = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage9 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage9.showDialog1(formDataForBloModificationPage9.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList5.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList5.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                FormDataForBloModificationPage2.this.list5count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage10 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage10.showDialog1(formDataForBloModificationPage10.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList6.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList6.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                FormDataForBloModificationPage2.this.list6count = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage11 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage11.showDialog1(formDataForBloModificationPage11.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList7.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList7.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAcquired.setEnabled(true);
                FormDataForBloModificationPage2.this.list7count = 0;
                FormDataForBloModificationPage2.this.binding.chooseFileAcquired.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2 formDataForBloModificationPage12 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage12.showDialog1(formDataForBloModificationPage12.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutIRPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageIRPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileIR2003Page2.setEnabled(true);
                FormDataForBloModificationPage2.this.IRcount2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage13 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage13.showDialog1(formDataForBloModificationPage13.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutList1Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList1Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                FormDataForBloModificationPage2.this.before1987count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage14 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage14.showDialog1(formDataForBloModificationPage14.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.before1987count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage15 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage15.showDialog1(formDataForBloModificationPage15.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutList2Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList2Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.list2count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage16 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage16.showDialog1(formDataForBloModificationPage16.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.after2004count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage17 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage17.showDialog1(formDataForBloModificationPage17.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList3Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList3Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.list3count2 = 0;
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2 formDataForBloModificationPage18 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage18.showDialog1(formDataForBloModificationPage18.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList4Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList4Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.list4coumt2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage19 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage19.showDialog1(formDataForBloModificationPage19.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList5Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList5Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.list5count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage20 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage20.showDialog1(formDataForBloModificationPage20.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str3)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList5Page3.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList5Page3.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                FormDataForBloModificationPage2.this.list5count3 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage21 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage21.showDialog1(formDataForBloModificationPage21.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList6Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList6Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.list6count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage22 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage22.showDialog1(formDataForBloModificationPage22.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str2)) {
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList7Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList7Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.list7count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage23 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage23.showDialog1(formDataForBloModificationPage23.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str8 + " " + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r2 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$23$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FormDataForBloModificationPage2.this.token = "Bearer " + str8;
            FormDataForBloModificationPage2.this.refreshToken = str9;
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str8);
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.uploadPhoto(str, str2, str3, str4, str5, formDataForBloModificationPage2.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr)) {
                if (FormDataForBloModificationPage2.this.IRcount < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.IRRef)) {
                    FormDataForBloModificationPage2.this.IRcount++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage2.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.imageIR.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.viewLayoutIR.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileIR2003.setEnabled(true);
                    FormDataForBloModificationPage2.this.binding.chooseFileIR2003.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.IRcount = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage3.showDialog1(formDataForBloModificationPage3.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str)) {
                if (FormDataForBloModificationPage2.this.before1987count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref)) {
                    FormDataForBloModificationPage2.this.before1987count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage4 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage4.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage4.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList1.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setEnabled(true);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.before1987count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage5 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage5.showDialog1(formDataForBloModificationPage5.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str)) {
                if (FormDataForBloModificationPage2.this.before2004count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref)) {
                    FormDataForBloModificationPage2.this.before2004count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage6 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage6.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage6.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setEnabled(true);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.before1987count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage7 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage7.showDialog1(formDataForBloModificationPage7.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str)) {
                if (FormDataForBloModificationPage2.this.list2count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list2Ref)) {
                    FormDataForBloModificationPage2.this.list2count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage8 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage8.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage8.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutList2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Father.setEnabled(true);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.list2count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage9 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage9.showDialog1(formDataForBloModificationPage9.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str)) {
                if (FormDataForBloModificationPage2.this.after2004count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref)) {
                    FormDataForBloModificationPage2.this.after2004count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage10 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage10.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage10.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004self.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004self.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setEnabled(true);
                    FormDataForBloModificationPage2.this.after2004count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage11 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage11.showDialog1(formDataForBloModificationPage11.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str)) {
                if (FormDataForBloModificationPage2.this.list3count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list3Ref)) {
                    FormDataForBloModificationPage2.this.list3count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage12 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage12.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage12.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList3.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList3.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setEnabled(true);
                    FormDataForBloModificationPage2.this.list3count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage13 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage13.showDialog1(formDataForBloModificationPage13.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str)) {
                if (FormDataForBloModificationPage2.this.list4coumt < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list4Ref)) {
                    FormDataForBloModificationPage2.this.list4coumt++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage14 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage14.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage14.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList4.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList4.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                    FormDataForBloModificationPage2.this.list4coumt = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage15 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage15.showDialog1(formDataForBloModificationPage15.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str)) {
                if (FormDataForBloModificationPage2.this.list5count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list5Ref)) {
                    FormDataForBloModificationPage2.this.list5count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage16 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage16.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage16.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList5.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList5.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                    FormDataForBloModificationPage2.this.list5count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage17 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage17.showDialog1(formDataForBloModificationPage17.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str)) {
                if (FormDataForBloModificationPage2.this.list6count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list6ref)) {
                    FormDataForBloModificationPage2.this.list6count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage18 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage18.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage18.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList6.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList6.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                    FormDataForBloModificationPage2.this.list6count = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage19 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage19.showDialog1(formDataForBloModificationPage19.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str)) {
                if (FormDataForBloModificationPage2.this.list7count < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list7ref)) {
                    FormDataForBloModificationPage2.this.list7count++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage20 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage20.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage20.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList7.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList7.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAcquired.setEnabled(true);
                    FormDataForBloModificationPage2.this.list7count = 0;
                    FormDataForBloModificationPage2.this.binding.chooseFileAcquired.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2 formDataForBloModificationPage21 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage21.showDialog1(formDataForBloModificationPage21.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.IRStr2)) {
                if (FormDataForBloModificationPage2.this.IRcount2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.IRRef2)) {
                    FormDataForBloModificationPage2.this.IRcount2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage22 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage22.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage22.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutIRPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageIRPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileIR2003Page2.setEnabled(true);
                    FormDataForBloModificationPage2.this.IRcount2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage23 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage23.showDialog1(formDataForBloModificationPage23.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before1987Str2)) {
                if (FormDataForBloModificationPage2.this.before1987count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref2)) {
                    FormDataForBloModificationPage2.this.before1987count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage24 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage24.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage24.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList1Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                    FormDataForBloModificationPage2.this.before1987count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage25 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage25.showDialog1(formDataForBloModificationPage25.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.before2004Str2)) {
                if (FormDataForBloModificationPage2.this.before2004count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref2)) {
                    FormDataForBloModificationPage2.this.before2004count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage26 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage26.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage26.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.before1987count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage27 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage27.showDialog1(formDataForBloModificationPage27.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list2Str2)) {
                if (FormDataForBloModificationPage2.this.list2count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list2Ref2)) {
                    FormDataForBloModificationPage2.this.list2count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage28 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage28.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage28.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutList2Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList2Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.list2count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage29 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage29.showDialog1(formDataForBloModificationPage29.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.after2004Str2)) {
                if (FormDataForBloModificationPage2.this.after2004count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list1ref2)) {
                    FormDataForBloModificationPage2.this.after2004count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage30 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage30.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage30.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.after2004count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage31 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage31.showDialog1(formDataForBloModificationPage31.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list3Str2)) {
                if (FormDataForBloModificationPage2.this.list3count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list3Ref2)) {
                    FormDataForBloModificationPage2.this.list3count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage32 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage32.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage32.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList3Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList3Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.list3count2 = 0;
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2 formDataForBloModificationPage33 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage33.showDialog1(formDataForBloModificationPage33.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list4Str2)) {
                if (FormDataForBloModificationPage2.this.list4coumt2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list4Ref2)) {
                    FormDataForBloModificationPage2.this.list4coumt2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage34 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage34.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage34.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList4Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList4Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.list4coumt2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage35 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage35.showDialog1(formDataForBloModificationPage35.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str2)) {
                if (FormDataForBloModificationPage2.this.list5count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list5Ref2)) {
                    FormDataForBloModificationPage2.this.list5count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage36 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage36.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage36.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList5Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList5Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.list5count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage37 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage37.showDialog1(formDataForBloModificationPage37.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list5Str3)) {
                if (FormDataForBloModificationPage2.this.list5count3 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list5ref3)) {
                    FormDataForBloModificationPage2.this.list5count3++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage38 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage38.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage38.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList5Page3.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList5Page3.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                    FormDataForBloModificationPage2.this.list5count3 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage39 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage39.showDialog1(formDataForBloModificationPage39.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list6Str2)) {
                if (FormDataForBloModificationPage2.this.list6count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list6ref2)) {
                    FormDataForBloModificationPage2.this.list6count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage40 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage40.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage40.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    FormDataForBloModificationPage2.this.binding.viewList6Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.imageList6Page2.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                    FormDataForBloModificationPage2.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                    FormDataForBloModificationPage2.this.list6count2 = 0;
                    FormDataForBloModificationPage2 formDataForBloModificationPage41 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage41.showDialog1(formDataForBloModificationPage41.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(FormDataForBloModificationPage2.this.list7Str2)) {
                if (FormDataForBloModificationPage2.this.list7count2 < 1 && TextUtils.isEmpty(FormDataForBloModificationPage2.this.list7ref2)) {
                    FormDataForBloModificationPage2.this.list7count2++;
                    FormDataForBloModificationPage2 formDataForBloModificationPage42 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage42.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, formDataForBloModificationPage42.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.binding.viewList7Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.imageList7Page2.setVisibility(8);
                FormDataForBloModificationPage2.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                FormDataForBloModificationPage2.this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.whitecolor));
                FormDataForBloModificationPage2.this.list7count2 = 0;
                FormDataForBloModificationPage2 formDataForBloModificationPage43 = FormDataForBloModificationPage2.this;
                formDataForBloModificationPage43.showDialog1(formDataForBloModificationPage43.alertText, FormDataForBloModificationPage2.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$76(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$76(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda44
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$77(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$77(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationList.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.retryMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda73
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$78(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$78(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (requestCode == 0) {
                Toast.makeText((Context) this, (CharSequence) ImagePicker.getError(data), 0).show();
                return;
            } else {
                Toast.makeText((Context) this, (CharSequence) "Uploading cancelled", 0).show();
                this.alertDialog.dismiss();
                return;
            }
        }
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        try {
            Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
            Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.imgmsg);
            }
            cursorQuery.moveToFirst();
            String[] strArrSplit = saveImagePath.getPath().split("/");
            String str = strArrSplit[strArrSplit.length - 1];
            Logger.d(this.TAG, Arrays.toString(strArrSplit));
            if (requestCode == 101) {
                long j = this.filesize;
                if (j < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
                    } else {
                        this.alertDialog.dismiss();
                        this.IRRef = str;
                    }
                    this.binding.viewLayoutIR.setVisibility(0);
                    this.binding.cancelIR.setVisibility(0);
                    this.binding.IRName.setVisibility(0);
                    this.binding.IRSize.setVisibility(0);
                    this.binding.imageIR.setVisibility(0);
                    ImageView imageView = this.binding.imageIR;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileIR2003.setEnabled(false);
                    this.binding.IRName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.IRSize.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j > 2048) {
                    this.binding.viewLayoutIR.setVisibility(8);
                    this.binding.cancelIR.setVisibility(8);
                    this.binding.IRName.setVisibility(8);
                    this.binding.IRSize.setVisibility(8);
                    this.binding.imageIR.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j2 = j / 1024;
                this.filesize = j2;
                double dRound = Math.round(j2 * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.binding.viewLayoutIR.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
                } else {
                    this.alertDialog.dismiss();
                    this.IRRef = str;
                }
                this.binding.viewLayoutIR.setVisibility(0);
                this.binding.cancelIR.setVisibility(0);
                this.binding.IRName.setVisibility(0);
                this.binding.IRSize.setVisibility(0);
                this.binding.imageIR.setVisibility(0);
                ImageView imageView2 = this.binding.imageIR;
                byte[] bArr2 = this.pdfbyteArray;
                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.IRName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.IRSize.setText(dRound + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 102) {
                long j3 = this.filesize;
                if (j3 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutList1.setVisibility(0);
                    this.binding.cancelList1.setVisibility(0);
                    this.binding.list1Name.setVisibility(0);
                    this.binding.list1Size.setVisibility(0);
                    this.binding.imageList1.setVisibility(0);
                    ImageView imageView3 = this.binding.imageList1;
                    byte[] bArr3 = this.pdfbyteArray;
                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                    this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore1987.setEnabled(false);
                    this.binding.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list1Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j3 > 2048) {
                    this.binding.viewLayoutList1.setVisibility(8);
                    this.binding.cancelList1.setVisibility(8);
                    this.binding.list1Name.setVisibility(8);
                    this.binding.list1Size.setVisibility(8);
                    this.binding.imageList1.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j4 = j3 / 1024;
                this.filesize = j4;
                double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                if (dRound2 > 2.0d) {
                    this.binding.viewLayoutList1.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutList1.setVisibility(0);
                this.binding.cancelList1.setVisibility(0);
                this.binding.list1Name.setVisibility(0);
                this.binding.list1Size.setVisibility(0);
                this.binding.imageList1.setVisibility(0);
                ImageView imageView4 = this.binding.imageList1;
                byte[] bArr4 = this.pdfbyteArray;
                imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore1987.setEnabled(false);
                this.binding.list1Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list1Size.setText(dRound2 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 104) {
                long j5 = this.filesize;
                if (j5 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref = str;
                    }
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView5 = this.binding.imageList2;
                    byte[] bArr5 = this.pdfbyteArray;
                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
                    this.binding.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j5 > 2048) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    this.binding.cancelList2.setVisibility(8);
                    this.binding.list2Name.setVisibility(8);
                    this.binding.list2Size.setVisibility(8);
                    this.binding.imageList2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j6 = j5 / 1024;
                this.filesize = j6;
                double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                if (dRound3 > 2.0d) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref = str;
                }
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView6 = this.binding.imageList2;
                byte[] bArr6 = this.pdfbyteArray;
                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound3 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 111) {
                long j7 = this.filesize;
                if (j7 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref = str;
                    }
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView7 = this.binding.imageList2;
                    byte[] bArr7 = this.pdfbyteArray;
                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
                    this.binding.chooseFileBefore2004Father.setEnabled(false);
                    this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j7 > 2048) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    this.binding.cancelList2.setVisibility(8);
                    this.binding.list2Name.setVisibility(8);
                    this.binding.list2Size.setVisibility(8);
                    this.binding.imageList2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j8 = j7 / 1024;
                this.filesize = j8;
                double dRound4 = Math.round(j8 * 100.0d) / 100.0d;
                if (dRound4 > 2.0d) {
                    this.binding.viewLayoutList2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref = str;
                }
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView8 = this.binding.imageList2;
                byte[] bArr8 = this.pdfbyteArray;
                imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound4 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 103) {
                long j9 = this.filesize;
                if (j9 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    this.binding.cancelBefore2004Self.setVisibility(0);
                    this.binding.before2004SelfName.setVisibility(0);
                    this.binding.before2004SelfSize.setVisibility(0);
                    this.binding.imageBefore2004Self.setVisibility(0);
                    ImageView imageView9 = this.binding.imageBefore2004Self;
                    byte[] bArr9 = this.pdfbyteArray;
                    imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                    this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004Self.setEnabled(false);
                    this.binding.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.before2004SelfSize.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j9 > 2048) {
                    this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    this.binding.cancelBefore2004Self.setVisibility(8);
                    this.binding.before2004SelfName.setVisibility(8);
                    this.binding.before2004SelfSize.setVisibility(8);
                    this.binding.imageBefore2004Self.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j10 = j9 / 1024;
                this.filesize = j10;
                double dRound5 = Math.round(j10 * 100.0d) / 100.0d;
                if (dRound5 > 2.0d) {
                    this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutBefore2004Self.setVisibility(0);
                this.binding.cancelBefore2004Self.setVisibility(0);
                this.binding.before2004SelfName.setVisibility(0);
                this.binding.before2004SelfSize.setVisibility(0);
                this.binding.imageBefore2004Self.setVisibility(0);
                ImageView imageView10 = this.binding.imageBefore2004Self;
                byte[] bArr10 = this.pdfbyteArray;
                imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.before2004SelfName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.before2004SelfSize.setText(dRound5 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 105) {
                long j11 = this.filesize;
                if (j11 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref = str;
                    }
                    this.binding.viewLayoutAfter2004self.setVisibility(0);
                    this.binding.cancelAfter2004self.setVisibility(0);
                    this.binding.after2004selfName.setVisibility(0);
                    this.binding.after2004selfSize.setVisibility(0);
                    this.binding.imageAfter2004self.setVisibility(0);
                    ImageView imageView11 = this.binding.imageAfter2004self;
                    byte[] bArr11 = this.pdfbyteArray;
                    imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                    this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Self.setEnabled(false);
                    this.binding.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.after2004selfSize.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j11 > 2048) {
                    this.binding.viewLayoutAfter2004self.setVisibility(8);
                    this.binding.cancelAfter2004self.setVisibility(8);
                    this.binding.after2004selfName.setVisibility(8);
                    this.binding.after2004selfSize.setVisibility(8);
                    this.binding.imageAfter2004self.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j12 = j11 / 1024;
                this.filesize = j12;
                double dRound6 = Math.round(j12 * 100.0d) / 100.0d;
                if (dRound6 > 2.0d) {
                    this.binding.viewLayoutAfter2004self.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref = str;
                }
                this.binding.viewLayoutAfter2004self.setVisibility(0);
                this.binding.cancelAfter2004self.setVisibility(0);
                this.binding.after2004selfName.setVisibility(0);
                this.binding.after2004selfSize.setVisibility(0);
                this.binding.imageAfter2004self.setVisibility(0);
                ImageView imageView12 = this.binding.imageAfter2004self;
                byte[] bArr12 = this.pdfbyteArray;
                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Self.setEnabled(false);
                this.binding.after2004selfName.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.after2004selfSize.setText(dRound6 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 106) {
                long j13 = this.filesize;
                if (j13 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref = str;
                    }
                    this.binding.viewList3.setVisibility(0);
                    this.binding.cancelList3.setVisibility(0);
                    this.binding.list3Name.setVisibility(0);
                    this.binding.list3Size.setVisibility(0);
                    this.binding.imageList3.setVisibility(0);
                    ImageView imageView13 = this.binding.imageList3;
                    byte[] bArr13 = this.pdfbyteArray;
                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                    this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Father.setEnabled(false);
                    this.binding.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list3Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j13 > 2048) {
                    this.binding.viewList3.setVisibility(8);
                    this.binding.cancelList3.setVisibility(8);
                    this.binding.list3Name.setVisibility(8);
                    this.binding.list3Size.setVisibility(8);
                    this.binding.imageList3.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j14 = j13 / 1024;
                this.filesize = j14;
                double dRound7 = Math.round(j14 * 100.0d) / 100.0d;
                if (dRound7 > 2.0d) {
                    this.binding.viewList3.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref = str;
                }
                this.binding.viewList3.setVisibility(0);
                this.binding.cancelList3.setVisibility(0);
                this.binding.list3Name.setVisibility(0);
                this.binding.list3Size.setVisibility(0);
                this.binding.imageList3.setVisibility(0);
                ImageView imageView14 = this.binding.imageList3;
                byte[] bArr14 = this.pdfbyteArray;
                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Father.setEnabled(false);
                this.binding.list3Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list3Size.setText(dRound7 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 107) {
                long j15 = this.filesize;
                if (j15 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref = str;
                    }
                    this.binding.viewList4.setVisibility(0);
                    this.binding.cancelList4.setVisibility(0);
                    this.binding.list4Name.setVisibility(0);
                    this.binding.list4Size.setVisibility(0);
                    this.binding.imageList4.setVisibility(0);
                    ImageView imageView15 = this.binding.imageList4;
                    byte[] bArr15 = this.pdfbyteArray;
                    imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                    this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004Mother.setEnabled(false);
                    this.binding.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list4Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j15 > 2048) {
                    this.binding.viewList4.setVisibility(8);
                    this.binding.cancelList4.setVisibility(8);
                    this.binding.list4Name.setVisibility(8);
                    this.binding.list4Size.setVisibility(8);
                    this.binding.imageList4.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j16 = j15 / 1024;
                this.filesize = j16;
                double dRound8 = Math.round(j16 * 100.0d) / 100.0d;
                if (dRound8 > 2.0d) {
                    this.binding.viewList4.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref = str;
                }
                this.binding.viewList4.setVisibility(0);
                this.binding.cancelList4.setVisibility(0);
                this.binding.list4Name.setVisibility(0);
                this.binding.list4Size.setVisibility(0);
                this.binding.imageList4.setVisibility(0);
                ImageView imageView16 = this.binding.imageList4;
                byte[] bArr16 = this.pdfbyteArray;
                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004Mother.setEnabled(false);
                this.binding.list4Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list4Size.setText(dRound8 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 108) {
                long j17 = this.filesize;
                if (j17 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list5Ref = str;
                    }
                    this.binding.viewList5.setVisibility(0);
                    this.binding.cancelList5.setVisibility(0);
                    this.binding.list5Name.setVisibility(0);
                    this.binding.list5Size.setVisibility(0);
                    this.binding.imageList5.setVisibility(0);
                    ImageView imageView17 = this.binding.imageList5;
                    byte[] bArr17 = this.pdfbyteArray;
                    imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
                    this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                    this.binding.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j17 > 2048) {
                    this.binding.viewList5.setVisibility(8);
                    this.binding.cancelList5.setVisibility(8);
                    this.binding.list5Name.setVisibility(8);
                    this.binding.list5Size.setVisibility(8);
                    this.binding.imageList5.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j18 = j17 / 1024;
                this.filesize = j18;
                double dRound9 = Math.round(j18 * 100.0d) / 100.0d;
                if (dRound9 > 2.0d) {
                    this.binding.viewList5.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list5Ref = str;
                }
                this.binding.viewList5.setVisibility(0);
                this.binding.cancelList5.setVisibility(0);
                this.binding.list5Name.setVisibility(0);
                this.binding.list5Size.setVisibility(0);
                this.binding.imageList5.setVisibility(0);
                ImageView imageView18 = this.binding.imageList5;
                byte[] bArr18 = this.pdfbyteArray;
                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                this.binding.list5Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5Size.setText(dRound9 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 109) {
                long j19 = this.filesize;
                if (j19 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list6ref = str;
                    }
                    this.binding.viewList6.setVisibility(0);
                    this.binding.cancelList6.setVisibility(0);
                    this.binding.list6Name.setVisibility(0);
                    this.binding.list6Size.setVisibility(0);
                    this.binding.imageList6.setVisibility(0);
                    ImageView imageView19 = this.binding.imageList6;
                    byte[] bArr19 = this.pdfbyteArray;
                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, 0, bArr19.length));
                    this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                    this.binding.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list6Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j19 > 2048) {
                    this.binding.viewList6.setVisibility(8);
                    this.binding.cancelList6.setVisibility(8);
                    this.binding.list6Name.setVisibility(8);
                    this.binding.list6Size.setVisibility(8);
                    this.binding.imageList6.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j20 = j19 / 1024;
                this.filesize = j20;
                double dRound10 = Math.round(j20 * 100.0d) / 100.0d;
                if (dRound10 > 2.0d) {
                    this.binding.viewList6.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list6ref = str;
                }
                this.binding.viewList6.setVisibility(0);
                this.binding.cancelList6.setVisibility(0);
                this.binding.list6Name.setVisibility(0);
                this.binding.list6Size.setVisibility(0);
                this.binding.imageList6.setVisibility(0);
                ImageView imageView20 = this.binding.imageList6;
                byte[] bArr20 = this.pdfbyteArray;
                imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, 0, bArr20.length));
                this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                this.binding.list6Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list6Size.setText(dRound10 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 110) {
                long j21 = this.filesize;
                if (j21 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                    } else {
                        this.alertDialog.dismiss();
                        this.list7ref = str;
                    }
                    this.binding.viewList7.setVisibility(0);
                    this.binding.cancelList7.setVisibility(0);
                    this.binding.list7Name.setVisibility(0);
                    this.binding.list7Size.setVisibility(0);
                    this.binding.imageList7.setVisibility(0);
                    ImageView imageView21 = this.binding.imageList7;
                    byte[] bArr21 = this.pdfbyteArray;
                    imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, 0, bArr21.length));
                    this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAcquired.setEnabled(false);
                    this.binding.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list7Size.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j21 > 2048) {
                    this.binding.viewList7.setVisibility(8);
                    this.binding.cancelList7.setVisibility(8);
                    this.binding.list7Name.setVisibility(8);
                    this.binding.list7Size.setVisibility(8);
                    this.binding.imageList7.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j22 = j21 / 1024;
                this.filesize = j22;
                double dRound11 = Math.round(j22 * 100.0d) / 100.0d;
                if (dRound11 > 2.0d) {
                    this.binding.viewList7.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
                } else {
                    this.alertDialog.dismiss();
                    this.list7ref = str;
                }
                this.binding.viewList7.setVisibility(0);
                this.binding.cancelList7.setVisibility(0);
                this.binding.list7Name.setVisibility(0);
                this.binding.list7Size.setVisibility(0);
                this.binding.imageList7.setVisibility(0);
                ImageView imageView22 = this.binding.imageList7;
                byte[] bArr22 = this.pdfbyteArray;
                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, 0, bArr22.length));
                this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAcquired.setEnabled(false);
                this.binding.list7Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list7Size.setText(dRound11 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 201) {
                long j23 = this.filesize;
                if (j23 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
                    } else {
                        this.alertDialog.dismiss();
                        this.IRRef2 = str;
                    }
                    this.binding.viewLayoutIRPage2.setVisibility(0);
                    this.binding.cancelIRPage2.setVisibility(0);
                    this.binding.IRNamePage2.setVisibility(0);
                    this.binding.IRSizePage2.setVisibility(0);
                    this.binding.imageIRPage2.setVisibility(0);
                    ImageView imageView23 = this.binding.imageIRPage2;
                    byte[] bArr23 = this.pdfbyteArray;
                    imageView23.setImageBitmap(BitmapFactory.decodeByteArray(bArr23, 0, bArr23.length));
                    this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileIR2003Page2.setEnabled(false);
                    this.binding.IRNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.IRSizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j23 > 2048) {
                    this.binding.viewLayoutIRPage2.setVisibility(8);
                    this.binding.cancelIRPage2.setVisibility(8);
                    this.binding.IRNamePage2.setVisibility(8);
                    this.binding.IRSizePage2.setVisibility(8);
                    this.binding.imageIRPage2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j24 = j23 / 1024;
                this.filesize = j24;
                double dRound12 = Math.round(j24 * 100.0d) / 100.0d;
                if (dRound12 > 2.0d) {
                    this.binding.viewLayoutIRPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
                } else {
                    this.alertDialog.dismiss();
                    this.IRRef2 = str;
                }
                this.binding.viewLayoutIRPage2.setVisibility(0);
                this.binding.cancelIRPage2.setVisibility(0);
                this.binding.IRNamePage2.setVisibility(0);
                this.binding.IRSizePage2.setVisibility(0);
                this.binding.imageIRPage2.setVisibility(0);
                ImageView imageView24 = this.binding.imageIRPage2;
                byte[] bArr24 = this.pdfbyteArray;
                imageView24.setImageBitmap(BitmapFactory.decodeByteArray(bArr24, 0, bArr24.length));
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.IRNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.IRSizePage2.setText(dRound12 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 202) {
                long j25 = this.filesize;
                if (j25 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutList1Page2.setVisibility(0);
                    this.binding.cancelList1Page2.setVisibility(0);
                    this.binding.list1NamePage2.setVisibility(0);
                    this.binding.list1SizePage2.setVisibility(0);
                    this.binding.imageList1Page2.setVisibility(0);
                    ImageView imageView25 = this.binding.imageList1Page2;
                    byte[] bArr25 = this.pdfbyteArray;
                    imageView25.setImageBitmap(BitmapFactory.decodeByteArray(bArr25, 0, bArr25.length));
                    this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    this.binding.list1NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list1SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j25 > 2048) {
                    this.binding.viewLayoutList1Page2.setVisibility(8);
                    this.binding.cancelList1Page2.setVisibility(8);
                    this.binding.list1NamePage2.setVisibility(8);
                    this.binding.list1SizePage2.setVisibility(8);
                    this.binding.imageList1Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j26 = j25 / 1024;
                this.filesize = j26;
                double dRound13 = Math.round(j26 * 100.0d) / 100.0d;
                if (dRound13 > 2.0d) {
                    this.binding.viewLayoutList1Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutList1Page2.setVisibility(0);
                this.binding.cancelList1Page2.setVisibility(0);
                this.binding.list1NamePage2.setVisibility(0);
                this.binding.list1SizePage2.setVisibility(0);
                this.binding.imageList1Page2.setVisibility(0);
                ImageView imageView26 = this.binding.imageList1Page2;
                byte[] bArr26 = this.pdfbyteArray;
                imageView26.setImageBitmap(BitmapFactory.decodeByteArray(bArr26, 0, bArr26.length));
                this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore1987Page2.setEnabled(false);
                this.binding.list1NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list1SizePage2.setText(dRound13 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 204) {
                long j27 = this.filesize;
                if (j27 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref2 = str;
                    }
                    this.binding.viewLayoutList2Page2.setVisibility(0);
                    this.binding.cancelList2Page2.setVisibility(0);
                    this.binding.list2NamePage2.setVisibility(0);
                    this.binding.list2SizePage2.setVisibility(0);
                    this.binding.imageList2Page2.setVisibility(0);
                    ImageView imageView27 = this.binding.imageList2Page2;
                    byte[] bArr27 = this.pdfbyteArray;
                    imageView27.setImageBitmap(BitmapFactory.decodeByteArray(bArr27, 0, bArr27.length));
                    this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                    this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j27 > 2048) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    this.binding.cancelList2Page2.setVisibility(8);
                    this.binding.list2NamePage2.setVisibility(8);
                    this.binding.list2SizePage2.setVisibility(8);
                    this.binding.imageList2Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j28 = j27 / 1024;
                this.filesize = j28;
                double dRound14 = Math.round(j28 * 100.0d) / 100.0d;
                if (dRound14 > 2.0d) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref2 = str;
                }
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                ImageView imageView28 = this.binding.imageList2Page2;
                byte[] bArr28 = this.pdfbyteArray;
                imageView28.setImageBitmap(BitmapFactory.decodeByteArray(bArr28, 0, bArr28.length));
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2SizePage2.setText(dRound14 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 211) {
                long j29 = this.filesize;
                if (j29 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref2 = str;
                    }
                    this.binding.viewLayoutList2Page2.setVisibility(0);
                    this.binding.cancelList2Page2.setVisibility(0);
                    this.binding.list2NamePage2.setVisibility(0);
                    this.binding.list2SizePage2.setVisibility(0);
                    this.binding.imageList2Page2.setVisibility(0);
                    ImageView imageView29 = this.binding.imageList2Page2;
                    byte[] bArr29 = this.pdfbyteArray;
                    imageView29.setImageBitmap(BitmapFactory.decodeByteArray(bArr29, 0, bArr29.length));
                    this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                    this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list2SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j29 > 2048) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    this.binding.cancelList2Page2.setVisibility(8);
                    this.binding.list2NamePage2.setVisibility(8);
                    this.binding.list2SizePage2.setVisibility(8);
                    this.binding.imageList2Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j30 = j29 / 1024;
                this.filesize = j30;
                double dRound15 = Math.round(j30 * 100.0d) / 100.0d;
                if (dRound15 > 2.0d) {
                    this.binding.viewLayoutList2Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref2 = str;
                }
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                ImageView imageView30 = this.binding.imageList2Page2;
                byte[] bArr30 = this.pdfbyteArray;
                imageView30.setImageBitmap(BitmapFactory.decodeByteArray(bArr30, 0, bArr30.length));
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.list2NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2SizePage2.setText(dRound15 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 203) {
                long j31 = this.filesize;
                if (j31 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    this.binding.before2004SelfNamePage2.setVisibility(0);
                    this.binding.before2004SelfSizePage2.setVisibility(0);
                    this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    ImageView imageView31 = this.binding.imageBefore2004SelfPage2;
                    byte[] bArr31 = this.pdfbyteArray;
                    imageView31.setImageBitmap(BitmapFactory.decodeByteArray(bArr31, 0, bArr31.length));
                    this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    this.binding.before2004SelfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.before2004SelfSizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j31 > 2048) {
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    this.binding.cancelBefore2004SelfPage2.setVisibility(8);
                    this.binding.before2004SelfNamePage2.setVisibility(8);
                    this.binding.before2004SelfSizePage2.setVisibility(8);
                    this.binding.imageBefore2004SelfPage2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j32 = j31 / 1024;
                this.filesize = j32;
                double dRound16 = Math.round(j32 * 100.0d) / 100.0d;
                if (dRound16 > 2.0d) {
                    this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                this.binding.before2004SelfNamePage2.setVisibility(0);
                this.binding.before2004SelfSizePage2.setVisibility(0);
                this.binding.imageBefore2004SelfPage2.setVisibility(0);
                ImageView imageView32 = this.binding.imageBefore2004SelfPage2;
                byte[] bArr32 = this.pdfbyteArray;
                imageView32.setImageBitmap(BitmapFactory.decodeByteArray(bArr32, 0, bArr32.length));
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.before2004SelfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.before2004SelfSizePage2.setText(dRound16 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 205) {
                long j33 = this.filesize;
                if (j33 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list1ref2 = str;
                    }
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    this.binding.after2004selfNamePage2.setVisibility(0);
                    this.binding.after2004selfSizePage2.setVisibility(0);
                    this.binding.imageAfter2004selfPage2.setVisibility(0);
                    ImageView imageView33 = this.binding.imageAfter2004selfPage2;
                    byte[] bArr33 = this.pdfbyteArray;
                    imageView33.setImageBitmap(BitmapFactory.decodeByteArray(bArr33, 0, bArr33.length));
                    this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    this.binding.after2004selfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.after2004selfSizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j33 > 2048) {
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    this.binding.cancelAfter2004selfPage2.setVisibility(8);
                    this.binding.after2004selfNamePage2.setVisibility(8);
                    this.binding.after2004selfSizePage2.setVisibility(8);
                    this.binding.imageAfter2004selfPage2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j34 = j33 / 1024;
                this.filesize = j34;
                double dRound17 = Math.round(j34 * 100.0d) / 100.0d;
                if (dRound17 > 2.0d) {
                    this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list1ref2 = str;
                }
                this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                this.binding.cancelAfter2004selfPage2.setVisibility(0);
                this.binding.after2004selfNamePage2.setVisibility(0);
                this.binding.after2004selfSizePage2.setVisibility(0);
                this.binding.imageAfter2004selfPage2.setVisibility(0);
                ImageView imageView34 = this.binding.imageAfter2004selfPage2;
                byte[] bArr34 = this.pdfbyteArray;
                imageView34.setImageBitmap(BitmapFactory.decodeByteArray(bArr34, 0, bArr34.length));
                this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                this.binding.after2004selfNamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.after2004selfSizePage2.setText(dRound17 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 206) {
                long j35 = this.filesize;
                if (j35 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list3Ref2 = str;
                    }
                    this.binding.viewList3Page2.setVisibility(0);
                    this.binding.cancelList3Page2.setVisibility(0);
                    this.binding.list3NamePage2.setVisibility(0);
                    this.binding.list3SizePage2.setVisibility(0);
                    this.binding.imageList3Page2.setVisibility(0);
                    ImageView imageView35 = this.binding.imageList3Page2;
                    byte[] bArr35 = this.pdfbyteArray;
                    imageView35.setImageBitmap(BitmapFactory.decodeByteArray(bArr35, 0, bArr35.length));
                    this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                    this.binding.list3NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list3SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j35 > 2048) {
                    this.binding.viewList3Page2.setVisibility(8);
                    this.binding.cancelList3Page2.setVisibility(8);
                    this.binding.list3NamePage2.setVisibility(8);
                    this.binding.list3SizePage2.setVisibility(8);
                    this.binding.imageList3Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j36 = j35 / 1024;
                this.filesize = j36;
                double dRound18 = Math.round(j36 * 100.0d) / 100.0d;
                if (dRound18 > 2.0d) {
                    this.binding.viewList3Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list3Ref2 = str;
                }
                this.binding.viewList3Page2.setVisibility(0);
                this.binding.cancelList3Page2.setVisibility(0);
                this.binding.list3NamePage2.setVisibility(0);
                this.binding.list3SizePage2.setVisibility(0);
                this.binding.imageList3Page2.setVisibility(0);
                ImageView imageView36 = this.binding.imageList3Page2;
                byte[] bArr36 = this.pdfbyteArray;
                imageView36.setImageBitmap(BitmapFactory.decodeByteArray(bArr36, 0, bArr36.length));
                this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                this.binding.list3NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list3SizePage2.setText(dRound18 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 207) {
                long j37 = this.filesize;
                if (j37 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list4Ref2 = str;
                    }
                    this.binding.viewList4Page2.setVisibility(0);
                    this.binding.cancelList4Page2.setVisibility(0);
                    this.binding.list4NamePage2.setVisibility(0);
                    this.binding.list4SizePage2.setVisibility(0);
                    this.binding.imageList4Page2.setVisibility(0);
                    ImageView imageView37 = this.binding.imageList4Page2;
                    byte[] bArr37 = this.pdfbyteArray;
                    imageView37.setImageBitmap(BitmapFactory.decodeByteArray(bArr37, 0, bArr37.length));
                    this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                    this.binding.list4NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list4SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j37 > 2048) {
                    this.binding.viewList4Page2.setVisibility(8);
                    this.binding.cancelList4Page2.setVisibility(8);
                    this.binding.list4NamePage2.setVisibility(8);
                    this.binding.list4SizePage2.setVisibility(8);
                    this.binding.imageList4Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j38 = j37 / 1024;
                this.filesize = j38;
                double dRound19 = Math.round(j38 * 100.0d) / 100.0d;
                if (dRound19 > 2.0d) {
                    this.binding.viewList4Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list4Ref2 = str;
                }
                this.binding.viewList4Page2.setVisibility(0);
                this.binding.cancelList4Page2.setVisibility(0);
                this.binding.list4NamePage2.setVisibility(0);
                this.binding.list4SizePage2.setVisibility(0);
                this.binding.imageList4Page2.setVisibility(0);
                ImageView imageView38 = this.binding.imageList4Page2;
                byte[] bArr38 = this.pdfbyteArray;
                imageView38.setImageBitmap(BitmapFactory.decodeByteArray(bArr38, 0, bArr38.length));
                this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                this.binding.list4NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list4SizePage2.setText(dRound19 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 208) {
                long j39 = this.filesize;
                if (j39 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list5Ref2 = str;
                    }
                    this.binding.viewList5Page2.setVisibility(0);
                    this.binding.cancelList5Page2.setVisibility(0);
                    this.binding.list5NamePage2.setVisibility(0);
                    this.binding.list5SizePage2.setVisibility(0);
                    this.binding.imageList5Page2.setVisibility(0);
                    ImageView imageView39 = this.binding.imageList5Page2;
                    byte[] bArr39 = this.pdfbyteArray;
                    imageView39.setImageBitmap(BitmapFactory.decodeByteArray(bArr39, 0, bArr39.length));
                    this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                    this.binding.list5NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j39 > 2048) {
                    this.binding.viewList5Page2.setVisibility(8);
                    this.binding.cancelList5Page2.setVisibility(8);
                    this.binding.list5NamePage2.setVisibility(8);
                    this.binding.list5SizePage2.setVisibility(8);
                    this.binding.imageList5Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j40 = j39 / 1024;
                this.filesize = j40;
                double dRound20 = Math.round(j40 * 100.0d) / 100.0d;
                if (dRound20 > 2.0d) {
                    this.binding.viewList5Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list5Ref2 = str;
                }
                this.binding.viewList5Page2.setVisibility(0);
                this.binding.cancelList5Page2.setVisibility(0);
                this.binding.list5NamePage2.setVisibility(0);
                this.binding.list5SizePage2.setVisibility(0);
                this.binding.imageList5Page2.setVisibility(0);
                ImageView imageView40 = this.binding.imageList5Page2;
                byte[] bArr40 = this.pdfbyteArray;
                imageView40.setImageBitmap(BitmapFactory.decodeByteArray(bArr40, 0, bArr40.length));
                this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                this.binding.list5NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5SizePage2.setText(dRound20 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 209) {
                long j41 = this.filesize;
                if (j41 < 1024) {
                    if (this.onlineStatus) {
                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
                    } else {
                        this.alertDialog.dismiss();
                        this.list6ref2 = str;
                    }
                    this.binding.viewList6Page2.setVisibility(0);
                    this.binding.cancelList6Page2.setVisibility(0);
                    this.binding.list6NamePage2.setVisibility(0);
                    this.binding.list6SizePage2.setVisibility(0);
                    this.binding.imageList6Page2.setVisibility(0);
                    ImageView imageView41 = this.binding.imageList6Page2;
                    byte[] bArr41 = this.pdfbyteArray;
                    imageView41.setImageBitmap(BitmapFactory.decodeByteArray(bArr41, 0, bArr41.length));
                    this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                    this.binding.list6NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list6SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j41 > 2048) {
                    this.binding.viewList6Page2.setVisibility(8);
                    this.binding.cancelList6Page2.setVisibility(8);
                    this.binding.list6NamePage2.setVisibility(8);
                    this.binding.list6SizePage2.setVisibility(8);
                    this.binding.imageList6Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j42 = j41 / 1024;
                this.filesize = j42;
                double dRound21 = Math.round(j42 * 100.0d) / 100.0d;
                if (dRound21 > 2.0d) {
                    this.binding.viewList6Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list6ref2 = str;
                }
                this.binding.viewList6Page2.setVisibility(0);
                this.binding.cancelList6Page2.setVisibility(0);
                this.binding.list6NamePage2.setVisibility(0);
                this.binding.list6SizePage2.setVisibility(0);
                this.binding.imageList6Page2.setVisibility(0);
                ImageView imageView42 = this.binding.imageList6Page2;
                byte[] bArr42 = this.pdfbyteArray;
                imageView42.setImageBitmap(BitmapFactory.decodeByteArray(bArr42, 0, bArr42.length));
                this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                this.binding.list6NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list6SizePage2.setText(dRound21 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode != 210) {
                if (requestCode == 212) {
                    long j43 = this.filesize;
                    if (j43 < 1024) {
                        if (this.onlineStatus) {
                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str3);
                        } else {
                            this.alertDialog.dismiss();
                            this.list5ref3 = str;
                        }
                        this.binding.viewList5Page3.setVisibility(0);
                        this.binding.cancelList5Page3.setVisibility(0);
                        this.binding.list5NamePage3.setVisibility(0);
                        this.binding.list5SizePage3.setVisibility(0);
                        this.binding.imageList5Page3.setVisibility(0);
                        ImageView imageView43 = this.binding.imageList5Page3;
                        byte[] bArr43 = this.pdfbyteArray;
                        imageView43.setImageBitmap(BitmapFactory.decodeByteArray(bArr43, 0, bArr43.length));
                        this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                        this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                        this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                        this.binding.list5SizePage3.setText(this.filesize + getString(R.string.kbMsg));
                        return;
                    }
                    if (j43 > 2048) {
                        this.binding.viewList5Page3.setVisibility(8);
                        this.binding.cancelList5Page3.setVisibility(8);
                        this.binding.list5NamePage3.setVisibility(8);
                        this.binding.list5SizePage3.setVisibility(8);
                        this.binding.imageList5Page3.setVisibility(8);
                        showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                        return;
                    }
                    long j44 = j43 / 1024;
                    this.filesize = j44;
                    double dRound22 = Math.round(j44 * 100.0d) / 100.0d;
                    if (dRound22 > 2.0d) {
                        this.binding.viewList5Page3.setVisibility(8);
                        showDialog1(this.alertText, this.imgmsg);
                        return;
                    }
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str3);
                    this.binding.viewList5Page3.setVisibility(0);
                    this.binding.cancelList5Page3.setVisibility(0);
                    this.binding.list5NamePage3.setVisibility(0);
                    this.binding.list5SizePage3.setVisibility(0);
                    this.binding.imageList5Page3.setVisibility(0);
                    ImageView imageView44 = this.binding.imageList5Page3;
                    byte[] bArr44 = this.pdfbyteArray;
                    imageView44.setImageBitmap(BitmapFactory.decodeByteArray(bArr44, 0, bArr44.length));
                    this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                    this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5SizePage3.setText(dRound22 + getString(R.string.mbMsg));
                    return;
                }
                return;
            }
            long j45 = this.filesize;
            if (j45 < 1024) {
                if (this.onlineStatus) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
                } else {
                    this.alertDialog.dismiss();
                    this.list7ref2 = str;
                }
                this.binding.viewList7Page2.setVisibility(0);
                this.binding.cancelList7Page2.setVisibility(0);
                this.binding.list7NamePage2.setVisibility(0);
                this.binding.list7SizePage2.setVisibility(0);
                this.binding.imageList7Page2.setVisibility(0);
                ImageView imageView45 = this.binding.imageList7Page2;
                byte[] bArr45 = this.pdfbyteArray;
                imageView45.setImageBitmap(BitmapFactory.decodeByteArray(bArr45, 0, bArr45.length));
                this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAcquiredPage2.setEnabled(false);
                this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list7SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                return;
            }
            if (j45 > 2048) {
                this.binding.viewList7Page2.setVisibility(8);
                this.binding.cancelList7Page2.setVisibility(8);
                this.binding.list7NamePage2.setVisibility(8);
                this.binding.list7SizePage2.setVisibility(8);
                this.binding.imageList7Page2.setVisibility(8);
                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                return;
            }
            long j46 = j45 / 1024;
            this.filesize = j46;
            double dRound23 = Math.round(j46 * 100.0d) / 100.0d;
            if (dRound23 > 2.0d) {
                this.binding.viewList7Page2.setVisibility(8);
                showDialog1(this.alertText, this.imgmsg);
                return;
            }
            if (this.onlineStatus) {
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
            } else {
                this.alertDialog.dismiss();
                this.list7ref2 = str;
            }
            this.binding.viewList7Page2.setVisibility(0);
            this.binding.cancelList7Page2.setVisibility(0);
            this.binding.list7NamePage2.setVisibility(0);
            this.binding.list7SizePage2.setVisibility(0);
            this.binding.imageList7Page2.setVisibility(0);
            ImageView imageView46 = this.binding.imageList7Page2;
            byte[] bArr46 = this.pdfbyteArray;
            imageView46.setImageBitmap(BitmapFactory.decodeByteArray(bArr46, 0, bArr46.length));
            this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
            this.binding.chooseFileAcquiredPage2.setEnabled(false);
            this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
            this.binding.list7SizePage2.setText(dRound23 + getString(R.string.mbMsg));
        } catch (Exception e2) {
            Logger.d("", e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInitialDataFromAPI() {
        Date date;
        Date date2;
        this.list6ref = this.bundle.getString("list6DocUrl");
        this.list6ref2 = this.bundle.getString("list6DocUrlPg2");
        this.list7ref = this.bundle.getString("list7DocUrl");
        this.list7ref2 = this.bundle.getString("list7DocUrlPg2");
        this.oldAc = this.bundle.getString("oldAcNo");
        this.OldPart = this.bundle.getString("oldPartNo");
        String string = this.bundle.getString("oldPslNo");
        this.OldPsl = string;
        if (!TextUtils.isEmpty(string)) {
            this.binding.layoutVerifyDetails.setVisibility(0);
        }
        this.oldStatecd = this.bundle.getString("oldStateCd");
        String string2 = this.bundle.getString("preRevisionVoterFlg");
        this.IRFlag = string2;
        if (TextUtils.isEmpty(string2) && this.choice.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
            this.IRFlag = "Y";
        } else {
            this.IRFlag = "N";
        }
        this.IRRef = this.bundle.getString("preRevisionVoterDocUrl");
        this.IRRef2 = this.bundle.getString("peRevisionVoterDocUrlPg2");
        this.surveyChannel = this.bundle.getString("surveyChannel");
        if (!TextUtils.isEmpty(this.oldStatecd)) {
            this.binding.oldState.setSelection(this.StateList.indexOf(this.oldStatecd));
        }
        this.binding.IROldPslNo.setText(this.OldPsl);
        this.fatherOldAcS = this.bundle.getString("foldAcNo");
        this.fatherOldPartS = this.bundle.getString("foldPartNo");
        this.fatherOldPslS = this.bundle.getString("foldPslNo");
        this.motherOldAcS = this.bundle.getString("moldAcNo");
        this.motherOldPartS = this.bundle.getString("moldPartNo");
        this.motherOldPslS = this.bundle.getString("moldPslNo");
        this.list1ref = this.bundle.getString("list1DocUrl");
        this.list1ref2 = this.bundle.getString("list1DocUrlPg2");
        this.list3Ref = this.bundle.getString("list3DocUrl");
        this.list3Ref2 = this.bundle.getString("list3DocUrlPg2");
        this.list4Ref = this.bundle.getString("list4DocUrl");
        this.list4Ref2 = this.bundle.getString("list4DocUrlPg2");
        this.list5Ref = this.bundle.getString("list5DocUrl");
        this.list5Ref2 = this.bundle.getString("list5DocUrlPg2");
        this.list5ref3 = this.bundle.getString("list5DocUrlPg3");
        this.list3code = this.bundle.getString("list3Doc");
        this.list4code = this.bundle.getString("list4Doc");
        this.list5code = this.bundle.getString("list5Doc");
        this.fatherNationality = this.bundle.getString("fathersNationality");
        this.motherNationality = this.bundle.getString("mothersNationality");
        Log.d("FatherNat= ", this.fatherNationality);
        Log.d("FatherNat= ", this.motherNationality);
        String string3 = this.bundle.getString("citizenshipTypeCat");
        if (this.citizenshipTypeCatTemp.equals("CAT-3")) {
            if (!TextUtils.isEmpty(this.list3code)) {
                this.binding.father1OldAcNo.setText(this.fatherOldAcS);
                this.binding.father1OldPartNo.setText(this.fatherOldPartS);
                this.binding.father1OldPslNo.setText(this.fatherOldPslS);
            } else if (!TextUtils.isEmpty(this.list4code)) {
                this.binding.father1OldAcNo.setText(this.motherOldAcS);
                this.binding.father1OldPartNo.setText(this.motherOldPartS);
                this.binding.father1OldPslNo.setText(this.motherOldPslS);
            }
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            this.binding.fatherOldAcNo.setText(this.fatherOldAcS);
            this.binding.fatherOldPartNo.setText(this.fatherOldPartS);
            this.binding.fatherOldPslNo.setText(this.fatherOldPslS);
            this.binding.motherOldAcNo.setText(this.motherOldAcS);
            this.binding.motherOldPartNo.setText(this.motherOldPartS);
            this.binding.motherOldPslNo.setText(this.motherOldPslS);
        }
        if (this.citizenshipTypeCatTemp.equals("CAT-4")) {
            setDataOffline(this.list3);
            setDataOffline(this.list4);
            setDataOffline(this.list1);
        }
        String str = this.list6ref;
        if (str != null && !str.equals("")) {
            if (!this.list6ref.endsWith(".pdf")) {
                getFileforSIR1(this.list6ref);
                this.binding.viewList6.setVisibility(0);
                this.binding.imageList6.setVisibility(0);
                this.binding.list6Name.setText(this.list6ref);
                this.binding.list6Name.setVisibility(0);
                this.binding.list6Size.setVisibility(0);
                this.binding.cancelList6.setVisibility(0);
                this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
            } else {
                this.binding.viewList6.setVisibility(0);
                this.binding.imageList6.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.imageList6.setVisibility(0);
                this.binding.list6Name.setText(this.list6ref);
                this.binding.list6Name.setVisibility(0);
                this.binding.list6Size.setVisibility(0);
                this.binding.cancelList6.setVisibility(0);
                this.binding.chooseFileBornOutOfIndia.setEnabled(false);
                this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str2 = this.list6ref2;
        if (str2 != null && !str2.equals("")) {
            if (!this.list6ref2.endsWith(".pdf")) {
                getFileforSIR2(this.list6ref2);
                this.binding.viewList6Page2.setVisibility(0);
                this.binding.imageList6Page2.setVisibility(0);
                this.binding.list6NamePage2.setText(this.list6ref2);
                this.binding.list6NamePage2.setVisibility(0);
                this.binding.list6SizePage2.setVisibility(0);
                this.binding.cancelList6Page2.setVisibility(0);
                this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR2(this.list6ref2);
                this.binding.viewList6Page2.setVisibility(0);
                this.binding.imageList6Page2.setVisibility(0);
                this.binding.imageList6Page2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.list6NamePage2.setText(this.list6ref2);
                this.binding.list6NamePage2.setVisibility(0);
                this.binding.list6SizePage2.setVisibility(0);
                this.binding.cancelList6Page2.setVisibility(0);
                this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(false);
                this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str3 = this.list7ref;
        if (str3 != null && !str3.equals("")) {
            if (!this.list7ref.endsWith(".pdf")) {
                getFileforSIR3(this.list7ref);
                this.binding.viewList7.setVisibility(0);
                this.binding.imageList7.setVisibility(0);
                this.binding.list7Name.setText(this.list7ref);
                this.binding.list7Name.setVisibility(0);
                this.binding.list7Size.setVisibility(0);
                this.binding.cancelList7.setVisibility(0);
                this.binding.chooseFileAcquired.setEnabled(false);
                this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR3(this.list7ref);
                this.binding.viewList7.setVisibility(0);
                this.binding.imageList7.setVisibility(0);
                this.binding.imageList7.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.list7Name.setText(this.list7ref);
                this.binding.list7Name.setVisibility(0);
                this.binding.list7Size.setVisibility(0);
                this.binding.cancelList7.setVisibility(0);
                this.binding.chooseFileAcquired.setEnabled(false);
                this.binding.chooseFileAcquired.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str4 = this.list7ref2;
        if (str4 != null && !str4.equals("")) {
            if (!this.list7ref2.endsWith(".pdf")) {
                getFileforSIR4(this.list7ref2);
                this.binding.viewList7Page2.setVisibility(0);
                this.binding.imageList7Page2.setVisibility(0);
                this.binding.list7NamePage2.setText(this.list7ref2);
                this.binding.list7NamePage2.setVisibility(0);
                this.binding.list7SizePage2.setVisibility(0);
                this.binding.cancelList7Page2.setVisibility(0);
                this.binding.chooseFileAcquiredPage2.setEnabled(false);
                this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR4(this.list7ref2);
                this.binding.viewList7Page2.setVisibility(0);
                this.binding.imageList7Page2.setVisibility(0);
                this.binding.imageList7Page2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.list7NamePage2.setText(this.list7ref2);
                this.binding.list7NamePage2.setVisibility(0);
                this.binding.list7SizePage2.setVisibility(0);
                this.binding.cancelList7Page2.setVisibility(0);
                this.binding.chooseFileAcquiredPage2.setEnabled(false);
                this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str5 = this.IRRef;
        if (str5 != null && !str5.equals("")) {
            if (!this.IRRef.endsWith(".pdf")) {
                getFileforSIR5(this.IRRef);
                this.binding.viewLayoutIR.setVisibility(0);
                this.binding.imageIR.setVisibility(0);
                this.binding.IRName.setText(this.IRRef);
                this.binding.IRName.setVisibility(0);
                this.binding.IRSize.setVisibility(0);
                this.binding.cancelIR.setVisibility(0);
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR5(this.IRRef);
                this.binding.viewLayoutIR.setVisibility(0);
                this.binding.imageIR.setVisibility(0);
                this.binding.imageIR.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.IRName.setText(this.IRRef);
                this.binding.IRName.setVisibility(0);
                this.binding.IRSize.setVisibility(0);
                this.binding.cancelIR.setVisibility(0);
                this.binding.chooseFileIR2003.setEnabled(false);
                this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str6 = this.IRRef2;
        if (str6 != null && !str6.equals("")) {
            if (!this.IRRef2.endsWith(".pdf")) {
                getFileforSIR6(this.IRRef2);
                this.binding.viewLayoutIRPage2.setVisibility(0);
                this.binding.imageIRPage2.setVisibility(0);
                this.binding.IRNamePage2.setText(this.IRRef2);
                this.binding.IRNamePage2.setVisibility(0);
                this.binding.IRSizePage2.setVisibility(0);
                this.binding.cancelIRPage2.setVisibility(0);
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR6(this.IRRef2);
                this.binding.viewLayoutIRPage2.setVisibility(0);
                this.binding.imageIRPage2.setVisibility(0);
                this.binding.imageIRPage2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.IRNamePage2.setText(this.IRRef2);
                this.binding.IRNamePage2.setVisibility(0);
                this.binding.IRSizePage2.setVisibility(0);
                this.binding.cancelIRPage2.setVisibility(0);
                this.binding.chooseFileIR2003Page2.setEnabled(false);
                this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str7 = this.list1ref;
        if (str7 != null && !str7.equals("")) {
            if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-2")) {
                getFileforSIR7(this.list1ref, "CAT-2");
            } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-3")) {
                getFileforSIR7(this.list1ref, "CAT-3");
            } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-4")) {
                getFileforSIR7(this.list1ref, "CAT-4");
            } else {
                this.dobTemp = this.bundle.getString("dobverified");
                try {
                    this.simple.setLenient(false);
                    if (!TextUtils.isEmpty(this.dobTemp)) {
                        this.DoB = this.simple.parse(this.dobTemp.trim());
                    }
                } catch (ParseException e) {
                    Logger.d("ReverifyPage2", e.toString());
                }
                Date date3 = this.DoB;
                if (date3 != null && (date2 = this.dateBefore) != null) {
                    if (date3.before(date2)) {
                        getFileforSIR7(this.list1ref, "CAT-2");
                    } else if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                        getFileforSIR7(this.list1ref, "CAT-3");
                    } else if (this.DoB.after(this.dateAfter)) {
                        getFileforSIR7(this.list1ref, "CAT-4");
                    }
                }
            }
        }
        String str8 = this.list1ref2;
        if (str8 != null && !str8.equals("")) {
            if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-2")) {
                getFileforSIR8(this.list1ref2, "CAT-2");
            } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-3")) {
                getFileforSIR8(this.list1ref2, "CAT-3");
            } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-4")) {
                getFileforSIR8(this.list1ref2, "CAT-4");
            } else {
                this.dobTemp = this.bundle.getString("dobverified");
                try {
                    this.simple.setLenient(false);
                    this.DoB = this.simple.parse(this.dobTemp.trim());
                } catch (ParseException e2) {
                    Logger.d("ReverifyPage2", e2.toString());
                }
                Date date4 = this.DoB;
                if (date4 != null && (date = this.dateBefore) != null) {
                    if (date4.before(date)) {
                        getFileforSIR8(this.list1ref2, "CAT-2");
                    } else if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                        getFileforSIR8(this.list1ref2, "CAT-3");
                    } else if (this.DoB.after(this.dateAfter)) {
                        getFileforSIR8(this.list1ref2, "CAT-4");
                    }
                }
            }
        }
        String str9 = this.list3Ref;
        if (str9 != null && !str9.equals("") && string3.equals("CAT-3")) {
            if (!this.list3Ref.endsWith(".pdf")) {
                getFileforSIR9(this.list3Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list3Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            } else {
                getFileforSIR9(this.list3Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList6.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list3Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            }
        }
        String str10 = this.list3Ref2;
        if (str10 != null && !str10.equals("") && string3.equals("CAT-3")) {
            if (!this.list3Ref2.endsWith(".pdf")) {
                getFileforSIR10(this.list3Ref2);
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setText(this.list3Ref2);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR10(this.list3Ref2);
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.list2NamePage2.setText(this.list3Ref2);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str11 = this.list4Ref;
        if (str11 != null && !str11.equals("") && string3.equals("CAT-3")) {
            if (!this.list4Ref.endsWith(".pdf")) {
                getFileforSIR9(this.list4Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list4Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            } else {
                getFileforSIR9(this.list4Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list4Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.whitecolor));
            }
        }
        String str12 = this.list4Ref2;
        if (str12 != null && !str12.equals("") && string3.equals("CAT-3")) {
            if (!this.list4Ref2.endsWith(".pdf")) {
                getFileforSIR10(this.list4Ref2);
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                this.binding.list2NamePage2.setText(this.list4Ref2);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
            } else {
                getFileforSIR10(this.list4Ref2);
                this.binding.viewLayoutList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setVisibility(0);
                this.binding.imageList2Page2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blo_pdf_thumbnail));
                this.binding.list2NamePage2.setText(this.list4Ref2);
                this.binding.list2NamePage2.setVisibility(0);
                this.binding.list2SizePage2.setVisibility(0);
                this.binding.cancelList2Page2.setVisibility(0);
                this.binding.chooseFileBefore2004FatherPage2.setEnabled(false);
                this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        if (!TextUtils.isEmpty(this.list3code)) {
            this.binding.betweenParentFatherRb.setChecked(true);
            this.binding.before2004ParentDoc.setVisibility(0);
            setDataOffline(this.list3);
        }
        if (!TextUtils.isEmpty(this.list4code)) {
            this.binding.betweenParentMotherRb.setChecked(true);
            this.binding.before2004ParentDoc.setVisibility(0);
            setDataOffline(this.list4);
        }
        if (!TextUtils.isEmpty(this.list5code)) {
            if (this.onlineStatus) {
                getList1(this.list5);
            } else {
                setDataOffline(this.list5);
            }
        }
        if (!TextUtils.isEmpty(this.fatherNationality) && !TextUtils.isEmpty(this.motherNationality) && this.fatherNationality.equalsIgnoreCase(this.motherNationality)) {
            this.binding.parentYesRb.setChecked(true);
            if (this.onlineStatus) {
                getList1(this.list3);
                getList1(this.list4);
            } else {
                setDataOffline(this.list3);
                setDataOffline(this.list4);
            }
            this.binding.viewFatherOldLayout.setVisibility(8);
            this.binding.viewMotherOldLayout.setVisibility(8);
            this.binding.llParentLayout.setVisibility(0);
            this.binding.fatherLayout.setVisibility(0);
            this.binding.motherLayout.setVisibility(0);
            this.binding.forIndianParentLayout.setVisibility(8);
            this.binding.selectParentLayout.setVisibility(8);
            this.binding.llNotIndianLayout.setVisibility(8);
            this.binding.forNonIndianParentLayout.setVisibility(8);
            String str13 = this.list3Ref;
            if (str13 != null && !str13.equals("")) {
                getFileforSIR11(this.list3Ref);
            }
            String str14 = this.list3Ref2;
            if (str14 != null && !str14.equals("")) {
                getFileforSIR12(this.list3Ref2);
            }
            String str15 = this.list4Ref;
            if (str15 != null && !str15.equals("")) {
                getFileforSIR13(this.list4Ref);
            }
            String str16 = this.list4Ref2;
            if (str16 != null && !str16.equals("")) {
                getFileforSIR14(this.list4Ref2);
            }
        } else if (!TextUtils.isEmpty(this.fatherNationality) && !TextUtils.isEmpty(this.motherNationality) && !this.fatherNationality.equalsIgnoreCase(this.motherNationality)) {
            this.binding.parentNoRb.setChecked(true);
            this.binding.selectParentLayout.setVisibility(0);
            this.binding.llParentLayout.setVisibility(0);
            this.binding.fatherLayout.setVisibility(8);
            this.binding.motherLayout.setVisibility(8);
            this.binding.llNotIndianLayout.setVisibility(8);
            this.binding.forIndianParentLayout.setVisibility(8);
            this.binding.forNonIndianParentLayout.setVisibility(8);
            if (this.onlineStatus) {
                getList1(this.list5);
            } else {
                setDataOffline(this.list5);
            }
            if (this.fatherNationality.equalsIgnoreCase("Indian")) {
                if (this.onlineStatus) {
                    getList1(this.list3);
                } else {
                    setDataOffline(this.list3);
                }
                this.binding.parentFatherRb.setChecked(true);
                String str17 = this.list3Ref;
                if (str17 != null && !str17.equals("")) {
                    getFileforSIR11(this.list3Ref);
                }
                String str18 = this.list3Ref2;
                if (str18 != null && !str18.equals("")) {
                    getFileforSIR12(this.list3Ref2);
                }
                String str19 = this.list5Ref;
                if (str19 != null && !str19.equals("")) {
                    getFileforSIR15(this.list5Ref);
                }
                String str20 = this.list5Ref2;
                if (str20 != null && !str20.equals("")) {
                    getFileforSIR16(this.list5Ref2);
                }
                String str21 = this.list5ref3;
                if (str21 != null && !str21.equals("")) {
                    getFileforSIR17(this.list5ref3);
                }
                this.binding.fatherLayout.setVisibility(0);
                this.binding.motherLayout.setVisibility(8);
                this.binding.forIndianParentLayout.setVisibility(0);
                this.binding.indianParentTv2.setText(getString(R.string.father_sr));
                this.binding.llNotIndianLayout.setVisibility(0);
                this.binding.nonIndianParentTv2.setText(R.string.mother_sr);
                this.binding.forNonIndianParentLayout.setVisibility(0);
            } else if (this.motherNationality.equalsIgnoreCase("Indian")) {
                if (this.onlineStatus) {
                    getList1(this.list4);
                } else {
                    setDataOffline(this.list4);
                }
                this.binding.parentMotherRb.setChecked(true);
                String str22 = this.list4Ref;
                if (str22 != null && !str22.equals("")) {
                    getFileforSIR13(this.list4Ref);
                }
                String str23 = this.list4Ref2;
                if (str23 != null && !str23.equals("")) {
                    getFileforSIR14(this.list4Ref2);
                }
                String str24 = this.list5Ref;
                if (str24 != null && !str24.equals("")) {
                    getFileforSIR15(this.list5Ref);
                }
                String str25 = this.list5Ref2;
                if (str25 != null && !str25.equals("")) {
                    getFileforSIR16(this.list5Ref2);
                }
                String str26 = this.list5ref3;
                if (str26 != null && !str26.equals("")) {
                    getFileforSIR17(this.list5ref3);
                }
                this.binding.motherLayout.setVisibility(0);
                this.binding.fatherLayout.setVisibility(8);
                this.binding.forIndianParentLayout.setVisibility(0);
                this.binding.indianParentTv2.setText(R.string.mother_sr);
                this.binding.llNotIndianLayout.setVisibility(0);
                this.binding.nonIndianParentTv2.setText(R.string.father_sr);
                this.binding.forNonIndianParentLayout.setVisibility(0);
            }
        } else {
            this.binding.parentYesRb.setChecked(false);
            this.binding.parentNoRb.setChecked(false);
        }
        this.binding.betweenparentRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.24
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (FormDataForBloModificationPage2.this.binding.betweenParentFatherRb.isChecked()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage2.setDataOffline(formDataForBloModificationPage2.list3);
                    FormDataForBloModificationPage2.this.flagcat3scenerio1 = "Y";
                    FormDataForBloModificationPage2.this.binding.before2004ParentDoc.setVisibility(0);
                }
                if (FormDataForBloModificationPage2.this.binding.betweenParentMotherRb.isChecked()) {
                    FormDataForBloModificationPage2 formDataForBloModificationPage3 = FormDataForBloModificationPage2.this;
                    formDataForBloModificationPage3.setDataOffline(formDataForBloModificationPage3.list4);
                    FormDataForBloModificationPage2.this.flagcat3scenerio2 = "Y";
                    FormDataForBloModificationPage2.this.binding.before2004ParentDoc.setVisibility(0);
                }
            }
        });
        this.binding.parentRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.25
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (FormDataForBloModificationPage2.this.binding.parentYesRb.isChecked()) {
                    FormDataForBloModificationPage2.this.binding.viewFatherOldLayout.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.viewMotherOldLayout.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.llParentLayout.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.fatherLayout.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.motherLayout.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.forIndianParentLayout.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.selectParentLayout.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.llNotIndianLayout.setVisibility(8);
                    FormDataForBloModificationPage2.this.binding.forNonIndianParentLayout.setVisibility(8);
                }
            }
        });
        this.binding.indianparentRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.26
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
            }
        });
    }

    public void getFileforSIR1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass27(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$27, reason: invalid class name */
    class AnonymousClass27 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass27(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl1).into(FormDataForBloModificationPage2.this.binding.imageList6);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl1)) {
                    FormDataForBloModificationPage2.this.binding.imageList6.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$27$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$27$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass28(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$28, reason: invalid class name */
    class AnonymousClass28 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass28(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl2).into(FormDataForBloModificationPage2.this.binding.imageList6Page2);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl2)) {
                    FormDataForBloModificationPage2.this.binding.imageList6Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$28$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$28$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass29(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass29(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl3).into(FormDataForBloModificationPage2.this.binding.imageList7);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl3)) {
                    FormDataForBloModificationPage2.this.binding.imageList7.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$29$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$29$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass30(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass30(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl4).into(FormDataForBloModificationPage2.this.binding.imageList7Page2);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl4)) {
                    FormDataForBloModificationPage2.this.binding.imageList7Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$30$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$30$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR5(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass31(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass31(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl5 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl5).into(FormDataForBloModificationPage2.this.binding.imageIR);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl5)) {
                    FormDataForBloModificationPage2.this.binding.imageIR.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$31$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$31$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR5(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR6(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass32(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$32, reason: invalid class name */
    class AnonymousClass32 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass32(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl6 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl6).into(FormDataForBloModificationPage2.this.binding.imageIR);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl6)) {
                    FormDataForBloModificationPage2.this.binding.imageIR.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$32$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$32$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR6(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR7(String fileref, String category) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass33(fileref, category));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        final /* synthetic */ String val$category;
        final /* synthetic */ String val$fileref;

        AnonymousClass33(final String val$fileref, final String val$category) {
            this.val$fileref = val$fileref;
            this.val$category = val$category;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl7 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageList1);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageBefore2004Self);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageAfter2004self);
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1Name.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list1Name.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1Size.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1Name.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list1Name.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1Size.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList1.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageList1.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageList1);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageBefore2004Self);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageAfter2004self);
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfName.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.before2004SelfName.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfSize.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfName.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.before2004SelfName.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfSize.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelBefore2004Self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageList1);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageBefore2004Self);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl7).into(FormDataForBloModificationPage2.this.binding.imageAfter2004self);
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfName.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.after2004selfName.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfSize.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfName.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.after2004selfName.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfSize.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelAfter2004self.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageAfter2004self.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl7)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image);
                    FormDataForBloModificationPage2.this.binding.imageList1.setImageBitmap(bitmapDecodeResource);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004Self.setImageBitmap(bitmapDecodeResource);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004self.setImageBitmap(bitmapDecodeResource);
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r6 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    final String str3 = this.val$category;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$33$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str4, String str5) {
                            this.f$0.lambda$onResponse$1(str2, str3, i, str4, str5);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, int i, String str3, String str4) {
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$33$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str3;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str4);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str3);
                FormDataForBloModificationPage2.this.getFileforSIR7(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR8(String fileref, String category) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass34(fileref, category));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<JsonObject> {
        final /* synthetic */ String val$category;
        final /* synthetic */ String val$fileref;

        AnonymousClass34(final String val$fileref, final String val$category) {
            this.val$fileref = val$fileref;
            this.val$category = val$category;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl8 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageList1Page2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2);
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1NamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list1NamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1SizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1NamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list1NamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list1SizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList1Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageList1Page2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageList1Page2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2);
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfNamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.before2004SelfNamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfSizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfNamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.before2004SelfNamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.before2004SelfSizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageList1Page2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2);
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl8).into(FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2);
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfNamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.after2004selfNamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfSizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    FormDataForBloModificationPage2.this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfNamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.after2004selfNamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.after2004selfSizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                    FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl8)) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image);
                    FormDataForBloModificationPage2.this.binding.imageList1Page2.setImageBitmap(bitmapDecodeResource);
                    FormDataForBloModificationPage2.this.binding.imageBefore2004SelfPage2.setImageBitmap(bitmapDecodeResource);
                    FormDataForBloModificationPage2.this.binding.imageAfter2004selfPage2.setImageBitmap(bitmapDecodeResource);
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r6 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    final String str3 = this.val$category;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$34$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str4, String str5) {
                            this.f$0.lambda$onResponse$1(str2, str3, i, str4, str5);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, int i, String str3, String str4) {
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$34$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str3;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str4);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str3);
                FormDataForBloModificationPage2.this.getFileforSIR8(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR9(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass35(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass35(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl9 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl9).into(FormDataForBloModificationPage2.this.binding.imageList2);
                }
                if (FormDataForBloModificationPage2.this.base64element9.isEmpty() || FormDataForBloModificationPage2.this.base64element9.equals("null")) {
                    FormDataForBloModificationPage2.this.binding.imageList2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$35$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$35$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR9(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR10(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass36(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass36(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl9 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl9).into(FormDataForBloModificationPage2.this.binding.imageList2Page2);
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl9)) {
                    FormDataForBloModificationPage2.this.binding.imageList2Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$36$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$36$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR10(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass37(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$37, reason: invalid class name */
    class AnonymousClass37 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass37(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                FormDataForBloModificationPage2.this.binding.viewList3.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.imageList3.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list3Name.setText(this.val$fileref);
                FormDataForBloModificationPage2.this.binding.list3Name.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list3Size.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.cancelList3.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setEnabled(false);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl11).into(FormDataForBloModificationPage2.this.binding.imageList3);
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList3.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl11)) {
                    FormDataForBloModificationPage2.this.binding.imageList3.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$37$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$37$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR12(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass38(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$38, reason: invalid class name */
    class AnonymousClass38 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass38(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl12 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                FormDataForBloModificationPage2.this.binding.viewList3Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.imageList3Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list3NamePage2.setText(this.val$fileref);
                FormDataForBloModificationPage2.this.binding.list3NamePage2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list3SizePage2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.cancelList3Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl12).into(FormDataForBloModificationPage2.this.binding.imageList3Page2);
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList3Page2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl12)) {
                    FormDataForBloModificationPage2.this.binding.imageList3Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$38$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$38$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR12(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR13(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass39(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$39, reason: invalid class name */
    class AnonymousClass39 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass39(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl13 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                FormDataForBloModificationPage2.this.binding.viewList4.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.imageList4.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list4Name.setText(this.val$fileref);
                FormDataForBloModificationPage2.this.binding.list4Name.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list4Size.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.cancelList4.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setEnabled(false);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl13).into(FormDataForBloModificationPage2.this.binding.imageList4);
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList4.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl13)) {
                    FormDataForBloModificationPage2.this.binding.imageList4.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$39$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$39$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR13(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR14(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass40(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$40, reason: invalid class name */
    class AnonymousClass40 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass40(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl14 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                FormDataForBloModificationPage2.this.binding.viewList4Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.imageList4Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list4NamePage2.setText(this.val$fileref);
                FormDataForBloModificationPage2.this.binding.list4NamePage2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.list4SizePage2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.cancelList4Page2.setVisibility(0);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                FormDataForBloModificationPage2.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl14).into(FormDataForBloModificationPage2.this.binding.imageList4Page2);
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList4Page2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl14)) {
                    FormDataForBloModificationPage2.this.binding.imageList4Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$40$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$40$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR14(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR15(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass41(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$41, reason: invalid class name */
    class AnonymousClass41 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass41(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl15 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl14).into(FormDataForBloModificationPage2.this.binding.imageList5);
                    FormDataForBloModificationPage2.this.binding.viewList5.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList5.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5Name.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list5Name.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5Size.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList5.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList5.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl15)) {
                    FormDataForBloModificationPage2.this.binding.imageList5.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$41$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$41$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR15(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR16(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass42(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$42, reason: invalid class name */
    class AnonymousClass42 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass42(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl15 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl14).into(FormDataForBloModificationPage2.this.binding.imageList5Page2);
                    FormDataForBloModificationPage2.this.binding.viewList5Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList5Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5NamePage2.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list5NamePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5SizePage2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList5Page2.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList5Page2.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl15)) {
                    FormDataForBloModificationPage2.this.binding.imageList5Page2.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$42$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$42$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR16(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR17(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass43(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$43, reason: invalid class name */
    class AnonymousClass43 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass43(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
                if (FormDataForBloModificationPage2.this.alertDialog != null) {
                    FormDataForBloModificationPage2.this.alertDialog.dismiss();
                }
                FormDataForBloModificationPage2.this.preSignedurl16 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(FormDataForBloModificationPage2.this).load(FormDataForBloModificationPage2.this.preSignedurl14).into(FormDataForBloModificationPage2.this.binding.imageList5Page3);
                    FormDataForBloModificationPage2.this.binding.viewList5Page3.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.imageList5Page3.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5NamePage3.setText(this.val$fileref);
                    FormDataForBloModificationPage2.this.binding.list5NamePage3.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.list5SizePage3.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.cancelList5Page3.setVisibility(0);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                    FormDataForBloModificationPage2.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(FormDataForBloModificationPage2.this.greycolor));
                } else {
                    FormDataForBloModificationPage2.this.binding.imageList5Page3.setImageDrawable(ContextCompat.getDrawable(FormDataForBloModificationPage2.this, R.drawable.blo_pdf_thumbnail));
                }
                if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.preSignedurl16)) {
                    FormDataForBloModificationPage2.this.binding.imageList5Page3.setImageBitmap(BitmapFactory.decodeResource(FormDataForBloModificationPage2.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                    ?? r5 = FormDataForBloModificationPage2.this;
                    String str = ((FormDataForBloModificationPage2) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$43$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag);
                }
            } else {
                try {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDataForBloModificationPage2.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDataForBloModificationPage2.this.alertDialog != null) {
                        FormDataForBloModificationPage2.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDataForBloModificationPage2.this.TAG, e.getMessage());
                }
            }
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
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
            FormDataForBloModificationPage2.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationPage2.this.commomUtility;
                ?? r5 = FormDataForBloModificationPage2.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$43$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationPage2.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDataForBloModificationPage2.this.getFileforSIR17(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationPage2.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationPage2.this.startActivity(new Intent((Context) FormDataForBloModificationPage2.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDataForBloModificationPage2.this.TAG, FormDataForBloModificationPage2.this.comingTag + t.getMessage());
            if (FormDataForBloModificationPage2.this.alertDialog != null) {
                FormDataForBloModificationPage2.this.alertDialog.dismiss();
            }
            FormDataForBloModificationPage2 formDataForBloModificationPage2 = FormDataForBloModificationPage2.this;
            formDataForBloModificationPage2.showDialog1(formDataForBloModificationPage2.getString(R.string.alertMsg), t.getMessage());
        }
    }

    private void showPersonPdfDialog(final String preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        final PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        new Thread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda78
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonPdfDialog$80(preSignedUrl, pDFViewFindViewById);
            }
        });
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda79
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonPdfDialog$80(String str, final PDFView pDFView) {
        try {
            final InputStream inputStreamOpenStream = new URL(str).openStream();
            runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    pDFView.fromStream(inputStreamOpenStream).load();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri getSaveImagePath2(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
            Log.d("Value1", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Log.d("Value2", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        }
        File file2 = new File(file, this.saveImageFileName);
        Log.d("Path= ", file2.getPath());
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
            Log.d("Value3", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("Test1= ", "filesize " + this.filesize);
        Logger.d("Test2= ", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2);
    }

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.44
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    FormDataForBloModificationPage2.this.ACNameList.clear();
                    FormDataForBloModificationPage2.this.ACList.clear();
                    FormDataForBloModificationPage2.this.ACNameList.add(FormDataForBloModificationPage2.this.getString(R.string.select_assembly_constituency));
                    FormDataForBloModificationPage2.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormDataForBloModificationPage2.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormDataForBloModificationPage2.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormDataForBloModificationPage2.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = FormDataForBloModificationPage2.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        FormDataForBloModificationPage2.this.binding.SpinnerIROldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    if (TextUtils.isEmpty(FormDataForBloModificationPage2.this.oldStatecd) || TextUtils.isEmpty(FormDataForBloModificationPage2.this.oldAc)) {
                        return;
                    }
                    FormDataForBloModificationPage2.this.binding.SpinnerIROldAcNo.setSelection(Integer.parseInt(FormDataForBloModificationPage2.this.oldAc));
                    return;
                }
                Logger.e("AC List error", String.valueOf(response.code()));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    private void initializeSpinnerTouch() {
        this.binding.spinnerIR.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.45
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.46
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore1987Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.47
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Self.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.48
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBefore2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.49
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Father.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.50
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004Mother.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.51
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAfter2004NotIndian.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.52
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerBornOutOfIndia.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.53
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.spinnerAcquired.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationPage2.54
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FormDataForBloModificationPage2.this.isUserSelected = true;
                return false;
            }
        });
    }
}
